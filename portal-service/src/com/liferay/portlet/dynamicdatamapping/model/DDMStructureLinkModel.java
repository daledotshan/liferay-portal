/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.portlet.dynamicdatamapping.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.model.AttachedModel;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the DDMStructureLink service. Represents a row in the &quot;DDMStructureLink&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.dynamicdatamapping.model.impl.DDMStructureLinkModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.dynamicdatamapping.model.impl.DDMStructureLinkImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DDMStructureLink
 * @see com.liferay.portlet.dynamicdatamapping.model.impl.DDMStructureLinkImpl
 * @see com.liferay.portlet.dynamicdatamapping.model.impl.DDMStructureLinkModelImpl
 * @generated
 */
@ProviderType
public interface DDMStructureLinkModel extends AttachedModel,
	BaseModel<DDMStructureLink> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a d d m structure link model instance should use the {@link DDMStructureLink} interface instead.
	 */

	/**
	 * Returns the primary key of this d d m structure link.
	 *
	 * @return the primary key of this d d m structure link
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this d d m structure link.
	 *
	 * @param primaryKey the primary key of this d d m structure link
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the structure link ID of this d d m structure link.
	 *
	 * @return the structure link ID of this d d m structure link
	 */
	public long getStructureLinkId();

	/**
	 * Sets the structure link ID of this d d m structure link.
	 *
	 * @param structureLinkId the structure link ID of this d d m structure link
	 */
	public void setStructureLinkId(long structureLinkId);

	/**
	 * Returns the fully qualified class name of this d d m structure link.
	 *
	 * @return the fully qualified class name of this d d m structure link
	 */
	@Override
	public String getClassName();

	public void setClassName(String className);

	/**
	 * Returns the class name ID of this d d m structure link.
	 *
	 * @return the class name ID of this d d m structure link
	 */
	@Override
	public long getClassNameId();

	/**
	 * Sets the class name ID of this d d m structure link.
	 *
	 * @param classNameId the class name ID of this d d m structure link
	 */
	@Override
	public void setClassNameId(long classNameId);

	/**
	 * Returns the class p k of this d d m structure link.
	 *
	 * @return the class p k of this d d m structure link
	 */
	@Override
	public long getClassPK();

	/**
	 * Sets the class p k of this d d m structure link.
	 *
	 * @param classPK the class p k of this d d m structure link
	 */
	@Override
	public void setClassPK(long classPK);

	/**
	 * Returns the structure ID of this d d m structure link.
	 *
	 * @return the structure ID of this d d m structure link
	 */
	public long getStructureId();

	/**
	 * Sets the structure ID of this d d m structure link.
	 *
	 * @param structureId the structure ID of this d d m structure link
	 */
	public void setStructureId(long structureId);

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
	public int compareTo(DDMStructureLink ddmStructureLink);

	@Override
	public int hashCode();

	@Override
	public CacheModel<DDMStructureLink> toCacheModel();

	@Override
	public DDMStructureLink toEscapedModel();

	@Override
	public DDMStructureLink toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}