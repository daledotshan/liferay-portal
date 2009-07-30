package com.ext.portlet.reports.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


/**
 * <a href="ReportsEntryPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 */
public interface ReportsEntryPersistence extends BasePersistence {
    public void cacheResult(
        com.ext.portlet.reports.model.ReportsEntry reportsEntry);

    public void cacheResult(
        java.util.List<com.ext.portlet.reports.model.ReportsEntry> reportsEntries);

    public void clearCache();

    public com.ext.portlet.reports.model.ReportsEntry create(
        java.lang.String entryId);

    public com.ext.portlet.reports.model.ReportsEntry remove(
        java.lang.String entryId)
        throws com.ext.portlet.reports.NoSuchEntryException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.reports.model.ReportsEntry remove(
        com.ext.portlet.reports.model.ReportsEntry reportsEntry)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.reports.model.ReportsEntry update(
        com.ext.portlet.reports.model.ReportsEntry reportsEntry)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.reports.model.ReportsEntry update(
        com.ext.portlet.reports.model.ReportsEntry reportsEntry, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.reports.model.ReportsEntry updateImpl(
        com.ext.portlet.reports.model.ReportsEntry reportsEntry, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.reports.model.ReportsEntry findByPrimaryKey(
        java.lang.String entryId)
        throws com.ext.portlet.reports.NoSuchEntryException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.reports.model.ReportsEntry fetchByPrimaryKey(
        java.lang.String entryId) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.reports.model.ReportsEntry> findByCompanyId(
        java.lang.String companyId) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.reports.model.ReportsEntry> findByCompanyId(
        java.lang.String companyId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.reports.model.ReportsEntry> findByCompanyId(
        java.lang.String companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.reports.model.ReportsEntry findByCompanyId_First(
        java.lang.String companyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.reports.NoSuchEntryException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.reports.model.ReportsEntry findByCompanyId_Last(
        java.lang.String companyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.reports.NoSuchEntryException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.reports.model.ReportsEntry[] findByCompanyId_PrevAndNext(
        java.lang.String entryId, java.lang.String companyId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.reports.NoSuchEntryException,
            com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.reports.model.ReportsEntry> findByUserId(
        java.lang.String userId) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.reports.model.ReportsEntry> findByUserId(
        java.lang.String userId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.reports.model.ReportsEntry> findByUserId(
        java.lang.String userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.reports.model.ReportsEntry findByUserId_First(
        java.lang.String userId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.reports.NoSuchEntryException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.reports.model.ReportsEntry findByUserId_Last(
        java.lang.String userId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.reports.NoSuchEntryException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.reports.model.ReportsEntry[] findByUserId_PrevAndNext(
        java.lang.String entryId, java.lang.String userId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.reports.NoSuchEntryException,
            com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.reports.model.ReportsEntry> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.reports.model.ReportsEntry> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.reports.model.ReportsEntry> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByCompanyId(java.lang.String companyId)
        throws com.liferay.portal.SystemException;

    public void removeByUserId(java.lang.String userId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByCompanyId(java.lang.String companyId)
        throws com.liferay.portal.SystemException;

    public int countByUserId(java.lang.String userId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}