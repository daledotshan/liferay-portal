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

package com.liferay.sync.engine.document.library.handler;

import com.liferay.sync.engine.document.library.event.Event;
import com.liferay.sync.engine.model.SyncFile;
import com.liferay.sync.engine.service.SyncFileService;
import com.liferay.sync.engine.util.JSONUtil;

/**
 * @author Shinn Lok
 */
public class UpdateFileEntryHandler extends BaseSyncDLObjectHandler {

	public UpdateFileEntryHandler(Event event) {
		super(event);
	}

	@Override
	public void processResponse(String response) throws Exception {
		SyncFile remoteSyncFile = JSONUtil.readValue(response, SyncFile.class);

		SyncFile localSyncFile = getLocalSyncFile();

		if (localSyncFile == null) {
			return;
		}

		processFilePathChange(localSyncFile, remoteSyncFile);

		localSyncFile.setLanTokenKey(remoteSyncFile.getLanTokenKey());
		localSyncFile.setModifiedTime(remoteSyncFile.getModifiedTime());
		localSyncFile.setParentFolderId(remoteSyncFile.getParentFolderId());
		localSyncFile.setSize(remoteSyncFile.getSize());
		localSyncFile.setState(SyncFile.STATE_SYNCED);

		if (getParameterValue("filePath") != null) {
			localSyncFile.setUiEvent(SyncFile.UI_EVENT_UPLOADED);
		}
		else {
			localSyncFile.setUiEvent(SyncFile.UI_EVENT_NONE);
		}

		localSyncFile.setUserId(remoteSyncFile.getUserId());
		localSyncFile.setUserName(remoteSyncFile.getUserName());
		localSyncFile.setVersion(remoteSyncFile.getVersion());
		localSyncFile.setVersionId(remoteSyncFile.getVersionId());

		SyncFileService.update(localSyncFile);
	}

}