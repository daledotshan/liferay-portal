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

package com.liferay.portlet.dynamicdatamapping.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.User;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import com.liferay.portlet.dynamicdatamapping.model.DDMTemplateVersion;
import com.liferay.portlet.dynamicdatamapping.model.DDMTemplateVersionModel;
import com.liferay.portlet.dynamicdatamapping.model.DDMTemplateVersionSoap;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * The base model implementation for the DDMTemplateVersion service. Represents a row in the &quot;DDMTemplateVersion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.dynamicdatamapping.model.DDMTemplateVersionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DDMTemplateVersionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DDMTemplateVersionImpl
 * @see com.liferay.portlet.dynamicdatamapping.model.DDMTemplateVersion
 * @see com.liferay.portlet.dynamicdatamapping.model.DDMTemplateVersionModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class DDMTemplateVersionModelImpl extends BaseModelImpl<DDMTemplateVersion>
	implements DDMTemplateVersionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a d d m template version model instance should use the {@link com.liferay.portlet.dynamicdatamapping.model.DDMTemplateVersion} interface instead.
	 */
	public static final String TABLE_NAME = "DDMTemplateVersion";
	public static final Object[][] TABLE_COLUMNS = {
			{ "templateVersionId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "templateId", Types.BIGINT },
			{ "version", Types.VARCHAR },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "language", Types.VARCHAR },
			{ "script", Types.CLOB }
		};
	public static final String TABLE_SQL_CREATE = "create table DDMTemplateVersion (templateVersionId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,templateId LONG,version VARCHAR(75) null,name STRING null,description STRING null,language VARCHAR(75) null,script TEXT null)";
	public static final String TABLE_SQL_DROP = "drop table DDMTemplateVersion";
	public static final String ORDER_BY_JPQL = " ORDER BY ddmTemplateVersion.templateVersionId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY DDMTemplateVersion.templateVersionId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.dynamicdatamapping.model.DDMTemplateVersion"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.dynamicdatamapping.model.DDMTemplateVersion"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portlet.dynamicdatamapping.model.DDMTemplateVersion"),
			true);
	public static final long TEMPLATEID_COLUMN_BITMASK = 1L;
	public static final long VERSION_COLUMN_BITMASK = 2L;
	public static final long TEMPLATEVERSIONID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static DDMTemplateVersion toModel(DDMTemplateVersionSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		DDMTemplateVersion model = new DDMTemplateVersionImpl();

		model.setTemplateVersionId(soapModel.getTemplateVersionId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setTemplateId(soapModel.getTemplateId());
		model.setVersion(soapModel.getVersion());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setLanguage(soapModel.getLanguage());
		model.setScript(soapModel.getScript());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<DDMTemplateVersion> toModels(
		DDMTemplateVersionSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<DDMTemplateVersion> models = new ArrayList<DDMTemplateVersion>(soapModels.length);

		for (DDMTemplateVersionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.dynamicdatamapping.model.DDMTemplateVersion"));

	public DDMTemplateVersionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _templateVersionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTemplateVersionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _templateVersionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DDMTemplateVersion.class;
	}

	@Override
	public String getModelClassName() {
		return DDMTemplateVersion.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("templateVersionId", getTemplateVersionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("templateId", getTemplateId());
		attributes.put("version", getVersion());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("language", getLanguage());
		attributes.put("script", getScript());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long templateVersionId = (Long)attributes.get("templateVersionId");

		if (templateVersionId != null) {
			setTemplateVersionId(templateVersionId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long templateId = (Long)attributes.get("templateId");

		if (templateId != null) {
			setTemplateId(templateId);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		String script = (String)attributes.get("script");

		if (script != null) {
			setScript(script);
		}
	}

	@JSON
	@Override
	public long getTemplateVersionId() {
		return _templateVersionId;
	}

	@Override
	public void setTemplateVersionId(long templateVersionId) {
		_templateVersionId = templateVersionId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public long getTemplateId() {
		return _templateId;
	}

	@Override
	public void setTemplateId(long templateId) {
		_columnBitmask |= TEMPLATEID_COLUMN_BITMASK;

		if (!_setOriginalTemplateId) {
			_setOriginalTemplateId = true;

			_originalTemplateId = _templateId;
		}

		_templateId = templateId;
	}

	public long getOriginalTemplateId() {
		return _originalTemplateId;
	}

	@JSON
	@Override
	public String getVersion() {
		if (_version == null) {
			return StringPool.BLANK;
		}
		else {
			return _version;
		}
	}

	@Override
	public void setVersion(String version) {
		_columnBitmask |= VERSION_COLUMN_BITMASK;

		if (_originalVersion == null) {
			_originalVersion = _version;
		}

		_version = version;
	}

	public String getOriginalVersion() {
		return GetterUtil.getString(_originalVersion);
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public String getName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId);
	}

	@Override
	public String getName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId, useDefault);
	}

	@Override
	public String getName(String languageId) {
		return LocalizationUtil.getLocalization(getName(), languageId);
	}

	@Override
	public String getName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getName(), languageId,
			useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return _nameCurrentLanguageId;
	}

	@JSON
	@Override
	public String getNameCurrentValue() {
		Locale locale = getLocale(_nameCurrentLanguageId);

		return getName(locale);
	}

	@Override
	public Map<Locale, String> getNameMap() {
		return LocalizationUtil.getLocalizationMap(getName());
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public void setName(String name, Locale locale) {
		setName(name, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setName(String name, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(name)) {
			setName(LocalizationUtil.updateLocalization(getName(), "Name",
					name, languageId, defaultLanguageId));
		}
		else {
			setName(LocalizationUtil.removeLocalization(getName(), "Name",
					languageId));
		}
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		_nameCurrentLanguageId = languageId;
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap) {
		setNameMap(nameMap, LocaleUtil.getDefault());
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale) {
		if (nameMap == null) {
			return;
		}

		setName(LocalizationUtil.updateLocalization(nameMap, getName(), "Name",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public String getDescription(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId);
	}

	@Override
	public String getDescription(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId, useDefault);
	}

	@Override
	public String getDescription(String languageId) {
		return LocalizationUtil.getLocalization(getDescription(), languageId);
	}

	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getDescription(), languageId,
			useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return _descriptionCurrentLanguageId;
	}

	@JSON
	@Override
	public String getDescriptionCurrentValue() {
		Locale locale = getLocale(_descriptionCurrentLanguageId);

		return getDescription(locale);
	}

	@Override
	public Map<Locale, String> getDescriptionMap() {
		return LocalizationUtil.getLocalizationMap(getDescription());
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public void setDescription(String description, Locale locale) {
		setDescription(description, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setDescription(String description, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(description)) {
			setDescription(LocalizationUtil.updateLocalization(
					getDescription(), "Description", description, languageId,
					defaultLanguageId));
		}
		else {
			setDescription(LocalizationUtil.removeLocalization(
					getDescription(), "Description", languageId));
		}
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		_descriptionCurrentLanguageId = languageId;
	}

	@Override
	public void setDescriptionMap(Map<Locale, String> descriptionMap) {
		setDescriptionMap(descriptionMap, LocaleUtil.getDefault());
	}

	@Override
	public void setDescriptionMap(Map<Locale, String> descriptionMap,
		Locale defaultLocale) {
		if (descriptionMap == null) {
			return;
		}

		setDescription(LocalizationUtil.updateLocalization(descriptionMap,
				getDescription(), "Description",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	@Override
	public String getLanguage() {
		if (_language == null) {
			return StringPool.BLANK;
		}
		else {
			return _language;
		}
	}

	@Override
	public void setLanguage(String language) {
		_language = language;
	}

	@JSON
	@Override
	public String getScript() {
		if (_script == null) {
			return StringPool.BLANK;
		}
		else {
			return _script;
		}
	}

	@Override
	public void setScript(String script) {
		_script = script;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			DDMTemplateVersion.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> nameMap = getNameMap();

		for (Map.Entry<Locale, String> entry : nameMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> descriptionMap = getDescriptionMap();

		for (Map.Entry<Locale, String> entry : descriptionMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getName();

		if (xml == null) {
			return StringPool.BLANK;
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		Locale defaultLocale = LocaleUtil.fromLanguageId(getDefaultLanguageId());

		Locale[] availableLocales = LocaleUtil.fromLanguageIds(getAvailableLanguageIds());

		Locale defaultImportLocale = LocalizationUtil.getDefaultImportLocale(DDMTemplateVersion.class.getName(),
				getPrimaryKey(), defaultLocale, availableLocales);

		prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String name = getName(defaultLocale);

		if (Validator.isNull(name)) {
			setName(getName(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setName(getName(defaultLocale), defaultLocale, defaultLocale);
		}

		String description = getDescription(defaultLocale);

		if (Validator.isNull(description)) {
			setDescription(getDescription(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setDescription(getDescription(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public DDMTemplateVersion toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (DDMTemplateVersion)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DDMTemplateVersionImpl ddmTemplateVersionImpl = new DDMTemplateVersionImpl();

		ddmTemplateVersionImpl.setTemplateVersionId(getTemplateVersionId());
		ddmTemplateVersionImpl.setGroupId(getGroupId());
		ddmTemplateVersionImpl.setCompanyId(getCompanyId());
		ddmTemplateVersionImpl.setUserId(getUserId());
		ddmTemplateVersionImpl.setUserName(getUserName());
		ddmTemplateVersionImpl.setCreateDate(getCreateDate());
		ddmTemplateVersionImpl.setTemplateId(getTemplateId());
		ddmTemplateVersionImpl.setVersion(getVersion());
		ddmTemplateVersionImpl.setName(getName());
		ddmTemplateVersionImpl.setDescription(getDescription());
		ddmTemplateVersionImpl.setLanguage(getLanguage());
		ddmTemplateVersionImpl.setScript(getScript());

		ddmTemplateVersionImpl.resetOriginalValues();

		return ddmTemplateVersionImpl;
	}

	@Override
	public int compareTo(DDMTemplateVersion ddmTemplateVersion) {
		long primaryKey = ddmTemplateVersion.getPrimaryKey();

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

		if (!(obj instanceof DDMTemplateVersion)) {
			return false;
		}

		DDMTemplateVersion ddmTemplateVersion = (DDMTemplateVersion)obj;

		long primaryKey = ddmTemplateVersion.getPrimaryKey();

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
		DDMTemplateVersionModelImpl ddmTemplateVersionModelImpl = this;

		ddmTemplateVersionModelImpl._originalTemplateId = ddmTemplateVersionModelImpl._templateId;

		ddmTemplateVersionModelImpl._setOriginalTemplateId = false;

		ddmTemplateVersionModelImpl._originalVersion = ddmTemplateVersionModelImpl._version;

		ddmTemplateVersionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DDMTemplateVersion> toCacheModel() {
		DDMTemplateVersionCacheModel ddmTemplateVersionCacheModel = new DDMTemplateVersionCacheModel();

		ddmTemplateVersionCacheModel.templateVersionId = getTemplateVersionId();

		ddmTemplateVersionCacheModel.groupId = getGroupId();

		ddmTemplateVersionCacheModel.companyId = getCompanyId();

		ddmTemplateVersionCacheModel.userId = getUserId();

		ddmTemplateVersionCacheModel.userName = getUserName();

		String userName = ddmTemplateVersionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			ddmTemplateVersionCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			ddmTemplateVersionCacheModel.createDate = createDate.getTime();
		}
		else {
			ddmTemplateVersionCacheModel.createDate = Long.MIN_VALUE;
		}

		ddmTemplateVersionCacheModel.templateId = getTemplateId();

		ddmTemplateVersionCacheModel.version = getVersion();

		String version = ddmTemplateVersionCacheModel.version;

		if ((version != null) && (version.length() == 0)) {
			ddmTemplateVersionCacheModel.version = null;
		}

		ddmTemplateVersionCacheModel.name = getName();

		String name = ddmTemplateVersionCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			ddmTemplateVersionCacheModel.name = null;
		}

		ddmTemplateVersionCacheModel.description = getDescription();

		String description = ddmTemplateVersionCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			ddmTemplateVersionCacheModel.description = null;
		}

		ddmTemplateVersionCacheModel.language = getLanguage();

		String language = ddmTemplateVersionCacheModel.language;

		if ((language != null) && (language.length() == 0)) {
			ddmTemplateVersionCacheModel.language = null;
		}

		ddmTemplateVersionCacheModel.script = getScript();

		String script = ddmTemplateVersionCacheModel.script;

		if ((script != null) && (script.length() == 0)) {
			ddmTemplateVersionCacheModel.script = null;
		}

		return ddmTemplateVersionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{templateVersionId=");
		sb.append(getTemplateVersionId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", templateId=");
		sb.append(getTemplateId());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", language=");
		sb.append(getLanguage());
		sb.append(", script=");
		sb.append(getScript());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.portlet.dynamicdatamapping.model.DDMTemplateVersion");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>templateVersionId</column-name><column-value><![CDATA[");
		sb.append(getTemplateVersionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateId</column-name><column-value><![CDATA[");
		sb.append(getTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>language</column-name><column-value><![CDATA[");
		sb.append(getLanguage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>script</column-name><column-value><![CDATA[");
		sb.append(getScript());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = DDMTemplateVersion.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			DDMTemplateVersion.class
		};
	private long _templateVersionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private long _templateId;
	private long _originalTemplateId;
	private boolean _setOriginalTemplateId;
	private String _version;
	private String _originalVersion;
	private String _name;
	private String _nameCurrentLanguageId;
	private String _description;
	private String _descriptionCurrentLanguageId;
	private String _language;
	private String _script;
	private long _columnBitmask;
	private DDMTemplateVersion _escapedModel;
}