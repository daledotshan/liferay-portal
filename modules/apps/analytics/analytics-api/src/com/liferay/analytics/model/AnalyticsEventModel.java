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

package com.liferay.analytics.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the AnalyticsEvent service. Represents a row in the &quot;Analytics_AnalyticsEvent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.analytics.model.impl.AnalyticsEventModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.analytics.model.impl.AnalyticsEventImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnalyticsEvent
 * @see com.liferay.analytics.model.impl.AnalyticsEventImpl
 * @see com.liferay.analytics.model.impl.AnalyticsEventModelImpl
 * @generated
 */
@ProviderType
public interface AnalyticsEventModel extends BaseModel<AnalyticsEvent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a analytics event model instance should use the {@link AnalyticsEvent} interface instead.
	 */

	/**
	 * Returns the primary key of this analytics event.
	 *
	 * @return the primary key of this analytics event
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this analytics event.
	 *
	 * @param primaryKey the primary key of this analytics event
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the analytics event ID of this analytics event.
	 *
	 * @return the analytics event ID of this analytics event
	 */
	public long getAnalyticsEventId();

	/**
	 * Sets the analytics event ID of this analytics event.
	 *
	 * @param analyticsEventId the analytics event ID of this analytics event
	 */
	public void setAnalyticsEventId(long analyticsEventId);

	/**
	 * Returns the company ID of this analytics event.
	 *
	 * @return the company ID of this analytics event
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this analytics event.
	 *
	 * @param companyId the company ID of this analytics event
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this analytics event.
	 *
	 * @return the user ID of this analytics event
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this analytics event.
	 *
	 * @param userId the user ID of this analytics event
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this analytics event.
	 *
	 * @return the user uuid of this analytics event
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this analytics event.
	 *
	 * @param userUuid the user uuid of this analytics event
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this analytics event.
	 *
	 * @return the create date of this analytics event
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this analytics event.
	 *
	 * @param createDate the create date of this analytics event
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the anonymous user ID of this analytics event.
	 *
	 * @return the anonymous user ID of this analytics event
	 */
	public long getAnonymousUserId();

	/**
	 * Sets the anonymous user ID of this analytics event.
	 *
	 * @param anonymousUserId the anonymous user ID of this analytics event
	 */
	public void setAnonymousUserId(long anonymousUserId);

	/**
	 * Returns the anonymous user uuid of this analytics event.
	 *
	 * @return the anonymous user uuid of this analytics event
	 */
	public String getAnonymousUserUuid();

	/**
	 * Sets the anonymous user uuid of this analytics event.
	 *
	 * @param anonymousUserUuid the anonymous user uuid of this analytics event
	 */
	public void setAnonymousUserUuid(String anonymousUserUuid);

	/**
	 * Returns the class name of this analytics event.
	 *
	 * @return the class name of this analytics event
	 */
	@AutoEscape
	public String getClassName();

	/**
	 * Sets the class name of this analytics event.
	 *
	 * @param className the class name of this analytics event
	 */
	public void setClassName(String className);

	/**
	 * Returns the class p k of this analytics event.
	 *
	 * @return the class p k of this analytics event
	 */
	public long getClassPK();

	/**
	 * Sets the class p k of this analytics event.
	 *
	 * @param classPK the class p k of this analytics event
	 */
	public void setClassPK(long classPK);

	/**
	 * Returns the referrer class name of this analytics event.
	 *
	 * @return the referrer class name of this analytics event
	 */
	@AutoEscape
	public String getReferrerClassName();

	/**
	 * Sets the referrer class name of this analytics event.
	 *
	 * @param referrerClassName the referrer class name of this analytics event
	 */
	public void setReferrerClassName(String referrerClassName);

	/**
	 * Returns the referrer class p k of this analytics event.
	 *
	 * @return the referrer class p k of this analytics event
	 */
	public long getReferrerClassPK();

	/**
	 * Sets the referrer class p k of this analytics event.
	 *
	 * @param referrerClassPK the referrer class p k of this analytics event
	 */
	public void setReferrerClassPK(long referrerClassPK);

	/**
	 * Returns the element key of this analytics event.
	 *
	 * @return the element key of this analytics event
	 */
	@AutoEscape
	public String getElementKey();

	/**
	 * Sets the element key of this analytics event.
	 *
	 * @param elementKey the element key of this analytics event
	 */
	public void setElementKey(String elementKey);

	/**
	 * Returns the type of this analytics event.
	 *
	 * @return the type of this analytics event
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this analytics event.
	 *
	 * @param type the type of this analytics event
	 */
	public void setType(String type);

	/**
	 * Returns the client i p of this analytics event.
	 *
	 * @return the client i p of this analytics event
	 */
	@AutoEscape
	public String getClientIP();

	/**
	 * Sets the client i p of this analytics event.
	 *
	 * @param clientIP the client i p of this analytics event
	 */
	public void setClientIP(String clientIP);

	/**
	 * Returns the user agent of this analytics event.
	 *
	 * @return the user agent of this analytics event
	 */
	@AutoEscape
	public String getUserAgent();

	/**
	 * Sets the user agent of this analytics event.
	 *
	 * @param userAgent the user agent of this analytics event
	 */
	public void setUserAgent(String userAgent);

	/**
	 * Returns the language ID of this analytics event.
	 *
	 * @return the language ID of this analytics event
	 */
	@AutoEscape
	public String getLanguageId();

	/**
	 * Sets the language ID of this analytics event.
	 *
	 * @param languageId the language ID of this analytics event
	 */
	public void setLanguageId(String languageId);

	/**
	 * Returns the url of this analytics event.
	 *
	 * @return the url of this analytics event
	 */
	@AutoEscape
	public String getUrl();

	/**
	 * Sets the url of this analytics event.
	 *
	 * @param url the url of this analytics event
	 */
	public void setUrl(String url);

	/**
	 * Returns the additional info of this analytics event.
	 *
	 * @return the additional info of this analytics event
	 */
	@AutoEscape
	public String getAdditionalInfo();

	/**
	 * Sets the additional info of this analytics event.
	 *
	 * @param additionalInfo the additional info of this analytics event
	 */
	public void setAdditionalInfo(String additionalInfo);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(AnalyticsEvent analyticsEvent);

	@Override
	public int hashCode();

	@Override
	public CacheModel<AnalyticsEvent> toCacheModel();

	@Override
	public AnalyticsEvent toEscapedModel();

	@Override
	public AnalyticsEvent toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}