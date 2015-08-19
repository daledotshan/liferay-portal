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

package com.liferay.portal.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.Release;
import com.liferay.portal.model.ReleaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Release service. Represents a row in the &quot;Release_&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ReleaseModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ReleaseImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReleaseImpl
 * @see Release
 * @see ReleaseModel
 * @generated
 */
@ProviderType
public class ReleaseModelImpl extends BaseModelImpl<Release>
	implements ReleaseModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a release model instance should use the {@link Release} interface instead.
	 */
	public static final String TABLE_NAME = "Release_";
	public static final Object[][] TABLE_COLUMNS = {
			{ "mvccVersion", Types.BIGINT },
			{ "releaseId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "servletContextName", Types.VARCHAR },
			{ "buildNumber", Types.INTEGER },
			{ "buildDate", Types.TIMESTAMP },
			{ "verified", Types.BOOLEAN },
			{ "state_", Types.INTEGER },
			{ "testString", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("releaseId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("servletContextName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("buildNumber", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("buildDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("verified", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("state_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("testString", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table Release_ (mvccVersion LONG default 0,releaseId LONG not null primary key,createDate DATE null,modifiedDate DATE null,servletContextName VARCHAR(75) null,buildNumber INTEGER,buildDate DATE null,verified BOOLEAN,state_ INTEGER,testString VARCHAR(1024) null)";
	public static final String TABLE_SQL_DROP = "drop table Release_";
	public static final String ORDER_BY_JPQL = " ORDER BY release.releaseId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Release_.releaseId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portal.model.Release"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portal.model.Release"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portal.model.Release"),
			true);
	public static final long SERVLETCONTEXTNAME_COLUMN_BITMASK = 1L;
	public static final long RELEASEID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portal.model.Release"));

	public ReleaseModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _releaseId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setReleaseId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _releaseId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Release.class;
	}

	@Override
	public String getModelClassName() {
		return Release.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("releaseId", getReleaseId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("servletContextName", getServletContextName());
		attributes.put("buildNumber", getBuildNumber());
		attributes.put("buildDate", getBuildDate());
		attributes.put("verified", getVerified());
		attributes.put("state", getState());
		attributes.put("testString", getTestString());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long releaseId = (Long)attributes.get("releaseId");

		if (releaseId != null) {
			setReleaseId(releaseId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String servletContextName = (String)attributes.get("servletContextName");

		if (servletContextName != null) {
			setServletContextName(servletContextName);
		}

		Integer buildNumber = (Integer)attributes.get("buildNumber");

		if (buildNumber != null) {
			setBuildNumber(buildNumber);
		}

		Date buildDate = (Date)attributes.get("buildDate");

		if (buildDate != null) {
			setBuildDate(buildDate);
		}

		Boolean verified = (Boolean)attributes.get("verified");

		if (verified != null) {
			setVerified(verified);
		}

		Integer state = (Integer)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String testString = (String)attributes.get("testString");

		if (testString != null) {
			setTestString(testString);
		}
	}

	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	@Override
	public long getReleaseId() {
		return _releaseId;
	}

	@Override
	public void setReleaseId(long releaseId) {
		_releaseId = releaseId;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getServletContextName() {
		if (_servletContextName == null) {
			return StringPool.BLANK;
		}
		else {
			return _servletContextName;
		}
	}

	@Override
	public void setServletContextName(String servletContextName) {
		_columnBitmask |= SERVLETCONTEXTNAME_COLUMN_BITMASK;

		if (_originalServletContextName == null) {
			_originalServletContextName = _servletContextName;
		}

		_servletContextName = servletContextName;
	}

	public String getOriginalServletContextName() {
		return GetterUtil.getString(_originalServletContextName);
	}

	@Override
	public int getBuildNumber() {
		return _buildNumber;
	}

	@Override
	public void setBuildNumber(int buildNumber) {
		_buildNumber = buildNumber;
	}

	@Override
	public Date getBuildDate() {
		return _buildDate;
	}

	@Override
	public void setBuildDate(Date buildDate) {
		_buildDate = buildDate;
	}

	@Override
	public boolean getVerified() {
		return _verified;
	}

	@Override
	public boolean isVerified() {
		return _verified;
	}

	@Override
	public void setVerified(boolean verified) {
		_verified = verified;
	}

	@Override
	public int getState() {
		return _state;
	}

	@Override
	public void setState(int state) {
		_state = state;
	}

	@Override
	public String getTestString() {
		if (_testString == null) {
			return StringPool.BLANK;
		}
		else {
			return _testString;
		}
	}

	@Override
	public void setTestString(String testString) {
		_testString = testString;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Release.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Release toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Release)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ReleaseImpl releaseImpl = new ReleaseImpl();

		releaseImpl.setMvccVersion(getMvccVersion());
		releaseImpl.setReleaseId(getReleaseId());
		releaseImpl.setCreateDate(getCreateDate());
		releaseImpl.setModifiedDate(getModifiedDate());
		releaseImpl.setServletContextName(getServletContextName());
		releaseImpl.setBuildNumber(getBuildNumber());
		releaseImpl.setBuildDate(getBuildDate());
		releaseImpl.setVerified(getVerified());
		releaseImpl.setState(getState());
		releaseImpl.setTestString(getTestString());

		releaseImpl.resetOriginalValues();

		return releaseImpl;
	}

	@Override
	public int compareTo(Release release) {
		long primaryKey = release.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Release)) {
			return false;
		}

		Release release = (Release)obj;

		long primaryKey = release.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		ReleaseModelImpl releaseModelImpl = this;

		releaseModelImpl._setModifiedDate = false;

		releaseModelImpl._originalServletContextName = releaseModelImpl._servletContextName;

		releaseModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Release> toCacheModel() {
		ReleaseCacheModel releaseCacheModel = new ReleaseCacheModel();

		releaseCacheModel.mvccVersion = getMvccVersion();

		releaseCacheModel.releaseId = getReleaseId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			releaseCacheModel.createDate = createDate.getTime();
		}
		else {
			releaseCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			releaseCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			releaseCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		releaseCacheModel.servletContextName = getServletContextName();

		String servletContextName = releaseCacheModel.servletContextName;

		if ((servletContextName != null) && (servletContextName.length() == 0)) {
			releaseCacheModel.servletContextName = null;
		}

		releaseCacheModel.buildNumber = getBuildNumber();

		Date buildDate = getBuildDate();

		if (buildDate != null) {
			releaseCacheModel.buildDate = buildDate.getTime();
		}
		else {
			releaseCacheModel.buildDate = Long.MIN_VALUE;
		}

		releaseCacheModel.verified = getVerified();

		releaseCacheModel.state = getState();

		releaseCacheModel.testString = getTestString();

		String testString = releaseCacheModel.testString;

		if ((testString != null) && (testString.length() == 0)) {
			releaseCacheModel.testString = null;
		}

		return releaseCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{mvccVersion=");
		sb.append(getMvccVersion());
		sb.append(", releaseId=");
		sb.append(getReleaseId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", servletContextName=");
		sb.append(getServletContextName());
		sb.append(", buildNumber=");
		sb.append(getBuildNumber());
		sb.append(", buildDate=");
		sb.append(getBuildDate());
		sb.append(", verified=");
		sb.append(getVerified());
		sb.append(", state=");
		sb.append(getState());
		sb.append(", testString=");
		sb.append(getTestString());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.model.Release");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>mvccVersion</column-name><column-value><![CDATA[");
		sb.append(getMvccVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>releaseId</column-name><column-value><![CDATA[");
		sb.append(getReleaseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>servletContextName</column-name><column-value><![CDATA[");
		sb.append(getServletContextName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>buildNumber</column-name><column-value><![CDATA[");
		sb.append(getBuildNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>buildDate</column-name><column-value><![CDATA[");
		sb.append(getBuildDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>verified</column-name><column-value><![CDATA[");
		sb.append(getVerified());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>state</column-name><column-value><![CDATA[");
		sb.append(getState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>testString</column-name><column-value><![CDATA[");
		sb.append(getTestString());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Release.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Release.class
		};
	private long _mvccVersion;
	private long _releaseId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _servletContextName;
	private String _originalServletContextName;
	private int _buildNumber;
	private Date _buildDate;
	private boolean _verified;
	private int _state;
	private String _testString;
	private long _columnBitmask;
	private Release _escapedModel;
}