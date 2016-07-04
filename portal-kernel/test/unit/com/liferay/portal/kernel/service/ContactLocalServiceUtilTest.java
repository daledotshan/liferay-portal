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

package com.liferay.portal.kernel.service;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Contact;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sherly liu
 */
public class ContactLocalServiceUtilTest {

	@Before
	@SuppressWarnings("deprecation")
	public void setUp() throws Exception {
		_birthday = new Date();
		_birthday.setYear(_birthday.getYear());
		_contact = ContactLocalServiceUtil.createContact(99999);
		_contact.setBirthday(_birthday);
	}

	@Test
	public void testAddContact1() throws Exception {
		try {
			ContactLocalServiceUtil.addContact(_contact);
		} catch (SystemException e) {
			Assert.assertTrue(true);
		}

		Assert.assertTrue(false);
	}

	@Test
	public void testAddContact2() throws Exception {
		try {
			ContactLocalServiceUtil.addContact(99999, null, 99999,
					_contact.getEmailAddress(), _contact.getFirstName(),
					_contact.getMiddleName(), _contact.getLastName(),
					_contact.getPrefixId(), _contact.getSuffixId(),
					_contact.getMale(), _contact.getBirthday().getMonth(),
					_contact.getBirthday().getDay(),
					_contact.getBirthday().getYear(), _contact.getSmsSn(),
					_contact.getFacebookSn(), _contact.getJabberSn(),
					_contact.getSkypeSn(), _contact.getTwitterSn(),
					_contact.getJobTitle());
		} catch (SystemException e) {
			Assert.assertTrue(true);
		}

		Assert.assertTrue(false);
	}

	@Test
	public void testUpdateContact1() throws Exception {
		try {
			ContactLocalServiceUtil.updateContact(_contact);
		} catch (SystemException e) {
			Assert.assertTrue(true);
		}

		Assert.assertTrue(false);
	}

	@Test
	public void testUpdateContact2() throws Exception {
		try {
			ContactLocalServiceUtil.updateContact(_contact.getContactId(),
					_contact.getEmailAddress(), _contact.getFirstName(),
					_contact.getMiddleName(), _contact.getLastName(),
					_contact.getPrefixId(), _contact.getSuffixId(),
					_contact.getMale(), _contact.getBirthday().getMonth(),
					_contact.getBirthday().getDay(),
					_contact.getBirthday().getYear(), _contact.getSmsSn(),
					_contact.getFacebookSn(), _contact.getJabberSn(),
					_contact.getSkypeSn(), _contact.getTwitterSn(),
					_contact.getJobTitle());
		} catch (SystemException e) {
			Assert.assertTrue(true);
		}

		Assert.assertTrue(false);
	}

	private Date _birthday;
	private Contact _contact;

}