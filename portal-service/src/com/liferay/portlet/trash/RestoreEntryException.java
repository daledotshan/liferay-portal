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

package com.liferay.portlet.trash;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class RestoreEntryException extends PortalException {

	public static final int DUPLICATE = 1;

	public static final int INVALID_CONTAINER = 2;

	public RestoreEntryException() {
	}

	public RestoreEntryException(int type) {
		_type = type;
	}

	public RestoreEntryException(String msg) {
		super(msg);
	}

	public RestoreEntryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RestoreEntryException(Throwable cause) {
		super(cause);
	}

	public long getDuplicateEntryId() {
		return _duplicateEntryId;
	}

	public String getOldName() {
		return _oldName;
	}

	public long getTrashEntryId() {
		return _trashEntryId;
	}

	public int getType() {
		return _type;
	}

	public void setDuplicateEntryId(long duplicateEntryId) {
		_duplicateEntryId = duplicateEntryId;
	}

	public void setOldName(String oldName) {
		_oldName = oldName;
	}

	public void setTrashEntryId(long trashEntryId) {
		_trashEntryId = trashEntryId;
	}

	public void setType(int type) {
		_type = type;
	}

	private long _duplicateEntryId;
	private String _oldName;
	private long _trashEntryId;
	private int _type;

}