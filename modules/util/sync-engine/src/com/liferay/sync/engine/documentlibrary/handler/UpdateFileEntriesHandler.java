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

package com.liferay.sync.engine.documentlibrary.handler;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.liferay.sync.engine.documentlibrary.event.Event;

import java.nio.file.Files;
import java.nio.file.Path;

import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shinn Lok
 */
public class UpdateFileEntriesHandler extends BaseJSONHandler {

	public UpdateFileEntriesHandler(Event event) {
		super(event);
	}

	@Override
	public void processResponse(String response) throws Exception {
		Map<String, Handler> handlers = (Map<String, Handler>)getParameterValue(
			"handlers");

		ObjectMapper objectMapper = new ObjectMapper();

		JsonNode rootJsonNode = objectMapper.readTree(response);

		Iterator<Map.Entry<String, JsonNode>> fields = rootJsonNode.fields();

		while (fields.hasNext()) {
			try {
				Map.Entry<String, JsonNode> field = fields.next();

				Handler handler = handlers.get(field.getKey());

				JsonNode fieldValue = field.getValue();

				String exception = handler.getException(fieldValue.textValue());

				if (handler.handlePortalException(exception)) {
					continue;
				}

				handler.processResponse(fieldValue.toString());
			}
			catch (Exception e) {
				_logger.debug(e.getMessage(), e);
			}
		}

		Path filePath = (Path)getParameterValue("zipFilePath");

		Files.deleteIfExists(filePath);
	}

	private static final Logger _logger = LoggerFactory.getLogger(
		UpdateFileEntriesHandler.class);

}