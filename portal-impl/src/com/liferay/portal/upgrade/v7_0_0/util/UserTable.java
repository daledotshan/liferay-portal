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
public class UserTable {

	public static final String TABLE_NAME = "User_";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT},
		{"uuid_", Types.VARCHAR},
		{"userId", Types.BIGINT},
		{"companyId", Types.BIGINT},
		{"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP},
		{"defaultUser", Types.BOOLEAN},
		{"contactId", Types.BIGINT},
		{"password_", Types.VARCHAR},
		{"passwordEncrypted", Types.BOOLEAN},
		{"passwordReset", Types.BOOLEAN},
		{"passwordModifiedDate", Types.TIMESTAMP},
		{"digest", Types.VARCHAR},
		{"reminderQueryQuestion", Types.VARCHAR},
		{"reminderQueryAnswer", Types.VARCHAR},
		{"graceLoginCount", Types.INTEGER},
		{"screenName", Types.VARCHAR},
		{"emailAddress", Types.VARCHAR},
		{"facebookId", Types.BIGINT},
		{"ldapServerId", Types.BIGINT},
		{"openId", Types.VARCHAR},
		{"portraitId", Types.BIGINT},
		{"languageId", Types.VARCHAR},
		{"timeZoneId", Types.VARCHAR},
		{"greeting", Types.VARCHAR},
		{"comments", Types.VARCHAR},
		{"firstName", Types.VARCHAR},
		{"middleName", Types.VARCHAR},
		{"lastName", Types.VARCHAR},
		{"jobTitle", Types.VARCHAR},
		{"loginDate", Types.TIMESTAMP},
		{"loginIP", Types.VARCHAR},
		{"lastLoginDate", Types.TIMESTAMP},
		{"lastLoginIP", Types.VARCHAR},
		{"lastFailedLoginDate", Types.TIMESTAMP},
		{"failedLoginAttempts", Types.INTEGER},
		{"lockout", Types.BOOLEAN},
		{"lockoutDate", Types.TIMESTAMP},
		{"agreedToTermsOfUse", Types.BOOLEAN},
		{"emailAddressVerified", Types.BOOLEAN},
		{"status", Types.INTEGER}
	};

	public static final String TABLE_SQL_CREATE = "create table User_ (mvccVersion LONG default 0,uuid_ VARCHAR(75) null,userId LONG not null primary key,companyId LONG,createDate DATE null,modifiedDate DATE null,defaultUser BOOLEAN,contactId LONG,password_ VARCHAR(75) null,passwordEncrypted BOOLEAN,passwordReset BOOLEAN,passwordModifiedDate DATE null,digest VARCHAR(255) null,reminderQueryQuestion VARCHAR(75) null,reminderQueryAnswer VARCHAR(75) null,graceLoginCount INTEGER,screenName VARCHAR(75) null,emailAddress VARCHAR(254) null,facebookId LONG,ldapServerId LONG,openId VARCHAR(1024) null,portraitId LONG,languageId VARCHAR(75) null,timeZoneId VARCHAR(75) null,greeting VARCHAR(255) null,comments STRING null,firstName VARCHAR(75) null,middleName VARCHAR(75) null,lastName VARCHAR(75) null,jobTitle VARCHAR(100) null,loginDate DATE null,loginIP VARCHAR(75) null,lastLoginDate DATE null,lastLoginIP VARCHAR(75) null,lastFailedLoginDate DATE null,failedLoginAttempts INTEGER,lockout BOOLEAN,lockoutDate DATE null,agreedToTermsOfUse BOOLEAN,emailAddressVerified BOOLEAN,status INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table User_";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_BCFDA257 on User_ (companyId, createDate, modifiedDate)",
		"create index IX_C6EA4F34 on User_ (companyId, defaultUser, status)",
		"create unique index IX_615E9F7A on User_ (companyId, emailAddress)",
		"create index IX_1D731F03 on User_ (companyId, facebookId)",
		"create index IX_EE8ABD19 on User_ (companyId, modifiedDate)",
		"create index IX_89509087 on User_ (companyId, openId)",
		"create unique index IX_C5806019 on User_ (companyId, screenName)",
		"create index IX_F6039434 on User_ (companyId, status)",
		"create unique index IX_9782AD88 on User_ (companyId, userId)",
		"create unique index IX_5ADBE171 on User_ (contactId)",
		"create index IX_762F63C6 on User_ (emailAddress)",
		"create index IX_A18034A4 on User_ (portraitId)",
		"create index IX_405CC0E on User_ (uuid_, companyId)"
	};

}