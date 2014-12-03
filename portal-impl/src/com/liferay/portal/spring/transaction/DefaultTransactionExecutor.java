/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.spring.transaction;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.aopalliance.intercept.MethodInvocation;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.transaction.interceptor.TransactionAttribute;

/**
 * @author Michael C. Han
 * @author Shuyang Zhou
 */
public class DefaultTransactionExecutor extends BaseTransactionExecutor {

	@Override
	public Object execute(
			PlatformTransactionManager platformTransactionManager,
			TransactionAttribute transactionAttribute,
			MethodInvocation methodInvocation)
		throws Throwable {

		TransactionStatus transactionStatus =
			platformTransactionManager.getTransaction(transactionAttribute);

		boolean newTransaction = transactionStatus.isNewTransaction();

		if (newTransaction) {
			fireTransactionCreatedEvent(
				transactionAttribute, transactionStatus);
		}

		Object returnValue = null;

		try {
			returnValue = methodInvocation.proceed();
		}
		catch (Throwable throwable) {
			processThrowable(
				platformTransactionManager, throwable, transactionAttribute,
				transactionStatus);
		}

		processCommit(
			platformTransactionManager, transactionAttribute,
			transactionStatus);

		return returnValue;
	}

	protected void processCommit(
		PlatformTransactionManager platformTransactionManager,
		TransactionAttribute transactionAttribute,
		TransactionStatus transactionStatus) {

		Throwable throwable = null;

		try {
			platformTransactionManager.commit(transactionStatus);
		}
		catch (TransactionSystemException tse) {
			_log.error(
				"Application exception overridden by commit exception", tse);

			throwable = tse;

			throw tse;
		}
		catch (RuntimeException re) {
			_log.error(
				"Application exception overridden by commit exception", re);

			throwable = re;

			throw re;
		}
		catch (Error e) {
			_log.error("Application exception overridden by commit error", e);

			throwable = e;

			throw e;
		}
		finally {
			if (transactionStatus.isNewTransaction()) {
				if (throwable != null) {
					fireTransactionRollbackedEvent(
						transactionAttribute, transactionStatus, throwable);
				}
				else {
					fireTransactionCommittedEvent(
						transactionAttribute, transactionStatus);
				}
			}
		}
	}

	protected void processThrowable(
			PlatformTransactionManager platformTransactionManager,
			Throwable throwable, TransactionAttribute transactionAttribute,
			TransactionStatus transactionStatus)
		throws Throwable {

		if (transactionAttribute.rollbackOn(throwable)) {
			try {
				platformTransactionManager.rollback(transactionStatus);
			}
			catch (TransactionSystemException tse) {
				_log.error(
					"Application exception overridden by rollback exception",
					tse);

				throw tse;
			}
			catch (RuntimeException re) {
				_log.error(
					"Application exception overridden by rollback exception",
					re);

				throw re;
			}
			catch (Error e) {
				_log.error(
					"Application exception overridden by rollback error", e);

				throw e;
			}
			finally {
				if (transactionStatus.isNewTransaction()) {
					fireTransactionRollbackedEvent(
						transactionAttribute, transactionStatus, throwable);
				}
			}
		}
		else {
			processCommit(
				platformTransactionManager, transactionAttribute,
				transactionStatus);
		}

		throw throwable;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		DefaultTransactionExecutor.class);

}