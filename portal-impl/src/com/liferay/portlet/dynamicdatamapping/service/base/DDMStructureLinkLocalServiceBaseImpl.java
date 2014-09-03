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

package com.liferay.portlet.dynamicdatamapping.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.dynamicdatamapping.model.DDMStructureLink;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLinkLocalService;
import com.liferay.portlet.dynamicdatamapping.service.persistence.DDMStructureLinkPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the d d m structure link local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.portlet.dynamicdatamapping.service.impl.DDMStructureLinkLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portlet.dynamicdatamapping.service.impl.DDMStructureLinkLocalServiceImpl
 * @see com.liferay.portlet.dynamicdatamapping.service.DDMStructureLinkLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class DDMStructureLinkLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements DDMStructureLinkLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.portlet.dynamicdatamapping.service.DDMStructureLinkLocalServiceUtil} to access the d d m structure link local service.
	 */

	/**
	 * Adds the d d m structure link to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ddmStructureLink the d d m structure link
	 * @return the d d m structure link that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DDMStructureLink addDDMStructureLink(
		DDMStructureLink ddmStructureLink) {
		ddmStructureLink.setNew(true);

		return ddmStructureLinkPersistence.update(ddmStructureLink);
	}

	/**
	 * Creates a new d d m structure link with the primary key. Does not add the d d m structure link to the database.
	 *
	 * @param structureLinkId the primary key for the new d d m structure link
	 * @return the new d d m structure link
	 */
	@Override
	public DDMStructureLink createDDMStructureLink(long structureLinkId) {
		return ddmStructureLinkPersistence.create(structureLinkId);
	}

	/**
	 * Deletes the d d m structure link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param structureLinkId the primary key of the d d m structure link
	 * @return the d d m structure link that was removed
	 * @throws PortalException if a d d m structure link with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DDMStructureLink deleteDDMStructureLink(long structureLinkId)
		throws PortalException {
		return ddmStructureLinkPersistence.remove(structureLinkId);
	}

	/**
	 * Deletes the d d m structure link from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ddmStructureLink the d d m structure link
	 * @return the d d m structure link that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DDMStructureLink deleteDDMStructureLink(
		DDMStructureLink ddmStructureLink) {
		return ddmStructureLinkPersistence.remove(ddmStructureLink);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(DDMStructureLink.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return ddmStructureLinkPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portlet.dynamicdatamapping.model.impl.DDMStructureLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return ddmStructureLinkPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portlet.dynamicdatamapping.model.impl.DDMStructureLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return ddmStructureLinkPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return ddmStructureLinkPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return ddmStructureLinkPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public DDMStructureLink fetchDDMStructureLink(long structureLinkId) {
		return ddmStructureLinkPersistence.fetchByPrimaryKey(structureLinkId);
	}

	/**
	 * Returns the d d m structure link with the primary key.
	 *
	 * @param structureLinkId the primary key of the d d m structure link
	 * @return the d d m structure link
	 * @throws PortalException if a d d m structure link with the primary key could not be found
	 */
	@Override
	public DDMStructureLink getDDMStructureLink(long structureLinkId)
		throws PortalException {
		return ddmStructureLinkPersistence.findByPrimaryKey(structureLinkId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(com.liferay.portlet.dynamicdatamapping.service.DDMStructureLinkLocalServiceUtil.getService());
		actionableDynamicQuery.setClass(DDMStructureLink.class);
		actionableDynamicQuery.setClassLoader(getClassLoader());

		actionableDynamicQuery.setPrimaryKeyPropertyName("structureLinkId");

		return actionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(com.liferay.portlet.dynamicdatamapping.service.DDMStructureLinkLocalServiceUtil.getService());
		actionableDynamicQuery.setClass(DDMStructureLink.class);
		actionableDynamicQuery.setClassLoader(getClassLoader());

		actionableDynamicQuery.setPrimaryKeyPropertyName("structureLinkId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return ddmStructureLinkLocalService.deleteDDMStructureLink((DDMStructureLink)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return ddmStructureLinkPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the d d m structure links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portlet.dynamicdatamapping.model.impl.DDMStructureLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of d d m structure links
	 * @param end the upper bound of the range of d d m structure links (not inclusive)
	 * @return the range of d d m structure links
	 */
	@Override
	public List<DDMStructureLink> getDDMStructureLinks(int start, int end) {
		return ddmStructureLinkPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of d d m structure links.
	 *
	 * @return the number of d d m structure links
	 */
	@Override
	public int getDDMStructureLinksCount() {
		return ddmStructureLinkPersistence.countAll();
	}

	/**
	 * Updates the d d m structure link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ddmStructureLink the d d m structure link
	 * @return the d d m structure link that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DDMStructureLink updateDDMStructureLink(
		DDMStructureLink ddmStructureLink) {
		return ddmStructureLinkPersistence.update(ddmStructureLink);
	}

	/**
	 * Returns the d d m structure link local service.
	 *
	 * @return the d d m structure link local service
	 */
	public com.liferay.portlet.dynamicdatamapping.service.DDMStructureLinkLocalService getDDMStructureLinkLocalService() {
		return ddmStructureLinkLocalService;
	}

	/**
	 * Sets the d d m structure link local service.
	 *
	 * @param ddmStructureLinkLocalService the d d m structure link local service
	 */
	public void setDDMStructureLinkLocalService(
		com.liferay.portlet.dynamicdatamapping.service.DDMStructureLinkLocalService ddmStructureLinkLocalService) {
		this.ddmStructureLinkLocalService = ddmStructureLinkLocalService;
	}

	/**
	 * Returns the d d m structure link persistence.
	 *
	 * @return the d d m structure link persistence
	 */
	public DDMStructureLinkPersistence getDDMStructureLinkPersistence() {
		return ddmStructureLinkPersistence;
	}

	/**
	 * Sets the d d m structure link persistence.
	 *
	 * @param ddmStructureLinkPersistence the d d m structure link persistence
	 */
	public void setDDMStructureLinkPersistence(
		DDMStructureLinkPersistence ddmStructureLinkPersistence) {
		this.ddmStructureLinkPersistence = ddmStructureLinkPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.liferay.portlet.dynamicdatamapping.model.DDMStructureLink",
			ddmStructureLinkLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.portlet.dynamicdatamapping.model.DDMStructureLink");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	protected Class<?> getModelClass() {
		return DDMStructureLink.class;
	}

	protected String getModelClassName() {
		return DDMStructureLink.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = ddmStructureLinkPersistence.getDataSource();

			DB db = DBFactoryUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.portlet.dynamicdatamapping.service.DDMStructureLinkLocalService.class)
	protected com.liferay.portlet.dynamicdatamapping.service.DDMStructureLinkLocalService ddmStructureLinkLocalService;
	@BeanReference(type = DDMStructureLinkPersistence.class)
	protected DDMStructureLinkPersistence ddmStructureLinkPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
	private String _beanIdentifier;
}