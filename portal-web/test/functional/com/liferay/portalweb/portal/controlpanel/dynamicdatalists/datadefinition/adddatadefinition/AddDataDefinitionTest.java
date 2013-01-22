/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.liferay.portalweb.portal.controlpanel.dynamicdatalists.datadefinition.adddatadefinition;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddDataDefinitionTest extends BaseTestCase {
	public void testAddDataDefinition() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("//div[@id='dockbar']",
			RuntimeVariables.replace("Dockbar"));
		selenium.waitForElementPresent(
			"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
		assertEquals(RuntimeVariables.replace("Go to"),
			selenium.getText("//li[@id='_145_mySites']/a/span"));
		selenium.mouseOver("//li[@id='_145_mySites']/a/span");
		selenium.waitForVisible("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Dynamic Data Lists",
			RuntimeVariables.replace("Dynamic Data Lists"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Manage Data Definitions"),
			selenium.getText("//a[@id='_167_manageDDMStructuresLink']"));
		selenium.clickAt("//a[@id='_167_manageDDMStructuresLink']",
			RuntimeVariables.replace("Manage Data Definitions"));
		selenium.waitForVisible("//iframe[contains(@src,'dynamicdatalists')]");
		selenium.selectFrame("//iframe[contains(@src,'dynamicdatalists')]");
		selenium.waitForVisible("//span[contains(@class,'add-button')]/a");
		assertEquals(RuntimeVariables.replace("Add"),
			selenium.getText("//span[contains(@class,'add-button')]/a"));
		selenium.clickAt("//span[contains(@class,'add-button')]/a",
			RuntimeVariables.replace("Add"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_166_name_en_US']",
			RuntimeVariables.replace("Data Definition"));
		assertEquals(RuntimeVariables.replace("Boolean"),
			selenium.getText(
				"//div[@class='aui-tabview-content aui-widget-bd']/div/ul/li[1]/div"));
		selenium.dragAndDropToObject("//div[@class='aui-tabview-content aui-widget-bd']/div/ul/li[1]/div",
			"//div[@class='aui-tabview-content aui-widget-bd']");
		assertEquals(RuntimeVariables.replace("Date"),
			selenium.getText(
				"//div[@class='aui-tabview-content aui-widget-bd']/div/ul/li[2]/div"));
		selenium.dragAndDropToObject("//div[@class='aui-tabview-content aui-widget-bd']/div/ul/li[2]/div",
			"//div[@class='aui-tabview-content aui-widget-bd']");
		assertEquals(RuntimeVariables.replace("Decimal"),
			selenium.getText(
				"//div[@class='aui-tabview-content aui-widget-bd']/div/ul/li[3]/div"));
		selenium.dragAndDropToObject("//div[@class='aui-tabview-content aui-widget-bd']/div/ul/li[3]/div",
			"//div[@class='aui-tabview-content aui-widget-bd']");
		assertEquals(RuntimeVariables.replace("Documents and Media"),
			selenium.getText(
				"//div[@class='aui-tabview-content aui-widget-bd']/div/ul/li[4]/div"));
		selenium.dragAndDropToObject("//div[@class='aui-tabview-content aui-widget-bd']/div/ul/li[4]/div",
			"//div[@class='aui-tabview-content aui-widget-bd']");
		assertEquals(RuntimeVariables.replace("File Upload"),
			selenium.getText(
				"//div[@class='aui-tabview-content aui-widget-bd']/div/ul/li[5]/div"));
		selenium.dragAndDropToObject("//div[@class='aui-tabview-content aui-widget-bd']/div/ul/li[5]/div",
			"//div[@class='aui-tabview-content aui-widget-bd']");
		assertEquals(RuntimeVariables.replace("Integer"),
			selenium.getText(
				"//div[@class='aui-tabview-content aui-widget-bd']/div/ul/li[6]/div"));
		selenium.dragAndDropToObject("//div[@class='aui-tabview-content aui-widget-bd']/div/ul/li[6]/div",
			"//div[@class='aui-tabview-content aui-widget-bd']");
		assertEquals(RuntimeVariables.replace("Number"),
			selenium.getText(
				"//div[@class='aui-tabview-content aui-widget-bd']/div/ul/li[7]/div"));
		selenium.dragAndDropToObject("//div[@class='aui-tabview-content aui-widget-bd']/div/ul/li[7]/div",
			"//div[@class='aui-tabview-content aui-widget-bd']");
		assertEquals(RuntimeVariables.replace("Radio"),
			selenium.getText(
				"//div[@class='aui-tabview-content aui-widget-bd']/div/ul/li[8]/div"));
		selenium.dragAndDropToObject("//div[@class='aui-tabview-content aui-widget-bd']/div/ul/li[8]/div",
			"//div[@class='aui-tabview-content aui-widget-bd']");
		assertEquals(RuntimeVariables.replace("Select"),
			selenium.getText(
				"//div[@class='aui-tabview-content aui-widget-bd']/div/ul/li[9]/div"));
		selenium.dragAndDropToObject("//div[@class='aui-tabview-content aui-widget-bd']/div/ul/li[9]/div",
			"//div[@class='aui-tabview-content aui-widget-bd']");
		assertEquals(RuntimeVariables.replace("Text"),
			selenium.getText(
				"//div[@class='aui-tabview-content aui-widget-bd']/div/ul/li[10]/div"));
		selenium.dragAndDropToObject("//div[@class='aui-tabview-content aui-widget-bd']/div/ul/li[10]/div",
			"//div[@class='aui-tabview-content aui-widget-bd']");
		assertEquals(RuntimeVariables.replace("Text Box"),
			selenium.getText(
				"//div[@class='aui-tabview-content aui-widget-bd']/div/ul/li[11]/div"));
		selenium.dragAndDropToObject("//div[@class='aui-tabview-content aui-widget-bd']/div/ul/li[11]/div",
			"//div[@class='aui-tabview-content aui-widget-bd']");
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		selenium.selectFrame("relative=top");
	}
}