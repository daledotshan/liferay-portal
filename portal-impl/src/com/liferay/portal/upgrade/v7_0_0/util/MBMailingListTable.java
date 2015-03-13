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

package com.liferay.portal.upgrade.v7_0_0.util;

import java.sql.Types;

/**
 * @author	  Brian Wing Shun Chan
 * @generated
 */
public class MBMailingListTable {

	public static final String TABLE_NAME = "MBMailingList";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR},
		{"mailingListId", Types.BIGINT},
		{"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT},
		{"userId", Types.BIGINT},
		{"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP},
		{"categoryId", Types.BIGINT},
		{"emailAddress", Types.VARCHAR},
		{"inProtocol", Types.VARCHAR},
		{"inServerName", Types.VARCHAR},
		{"inServerPort", Types.INTEGER},
		{"inUseSSL", Types.BOOLEAN},
		{"inUserName", Types.VARCHAR},
		{"inPassword", Types.VARCHAR},
		{"inReadInterval", Types.INTEGER},
		{"outEmailAddress", Types.VARCHAR},
		{"outCustom", Types.BOOLEAN},
		{"outServerName", Types.VARCHAR},
		{"outServerPort", Types.INTEGER},
		{"outUseSSL", Types.BOOLEAN},
		{"outUserName", Types.VARCHAR},
		{"outPassword", Types.VARCHAR},
		{"allowAnonymous", Types.BOOLEAN},
		{"active_", Types.BOOLEAN}
	};

	public static final String TABLE_SQL_CREATE = "create table MBMailingList (uuid_ VARCHAR(75) null,mailingListId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,categoryId LONG,emailAddress VARCHAR(254) null,inProtocol VARCHAR(75) null,inServerName VARCHAR(75) null,inServerPort INTEGER,inUseSSL BOOLEAN,inUserName VARCHAR(75) null,inPassword VARCHAR(75) null,inReadInterval INTEGER,outEmailAddress VARCHAR(254) null,outCustom BOOLEAN,outServerName VARCHAR(75) null,outServerPort INTEGER,outUseSSL BOOLEAN,outUserName VARCHAR(75) null,outPassword VARCHAR(75) null,allowAnonymous BOOLEAN,active_ BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table MBMailingList";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_BFEB984F on MBMailingList (active_)",
		"create unique index IX_76CE9CDD on MBMailingList (groupId, categoryId)",
		"create index IX_FC61676E on MBMailingList (uuid_, companyId)",
		"create unique index IX_E858F170 on MBMailingList (uuid_, groupId)"
	};

}