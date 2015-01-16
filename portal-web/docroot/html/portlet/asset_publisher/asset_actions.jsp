<%--
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
--%>

<%@ include file="/html/portlet/asset_publisher/init.jsp" %>

<%
boolean showIconLabel = ((Boolean)request.getAttribute("view.jsp-showIconLabel")).booleanValue();

AssetRenderer assetRenderer = (AssetRenderer)request.getAttribute("view.jsp-assetRenderer");

boolean showEditURL = ParamUtil.getBoolean(request, "showEditURL", true);

PortletURL editPortletURL = null;

if (showEditURL && assetRenderer.hasEditPermission(permissionChecker)) {
	PortletURL redirectURL = liferayPortletResponse.createLiferayPortletURL(plid, portletDisplay.getId(), PortletRequest.RENDER_PHASE, false);

	redirectURL.setParameter("mvcPath", "/html/portlet/asset_publisher/add_asset_redirect.jsp");

	String fullContentRedirect = (String)request.getAttribute("view.jsp-fullContentRedirect");

	if (fullContentRedirect != null) {
		redirectURL.setParameter("redirect", fullContentRedirect);
	}
	else {
		redirectURL.setParameter("redirect", currentURL);
	}

	redirectURL.setWindowState(LiferayWindowState.POP_UP);

	editPortletURL = assetRenderer.getURLEdit(liferayPortletRequest, liferayPortletResponse, LiferayWindowState.POP_UP, redirectURL);

	editPortletURL.setParameter("showHeader", Boolean.FALSE.toString());
}
%>

<c:if test="<%= editPortletURL != null %>">
	<div class="asset-actions lfr-meta-actions">

		<%
		String taglibEditURL = "javascript:Liferay.Util.openWindow({id: '" + renderResponse.getNamespace() + "editAsset', title: '" + HtmlUtil.escapeJS(LanguageUtil.format(request, "edit-x", HtmlUtil.escape(assetRenderer.getTitle(locale)), false)) + "', uri:'" + HtmlUtil.escapeJS(editPortletURL.toString()) + "'});";
		%>

		<liferay-ui:icon
			iconCssClass="icon-edit-sign"
			message='<%= showIconLabel ? HtmlUtil.render(LanguageUtil.format(request, "edit-x-x", new Object[] {"hide-accessible", HtmlUtil.escape(assetRenderer.getTitle(locale))}, false)) : LanguageUtil.format(request, "edit-x", HtmlUtil.escape(assetRenderer.getTitle(locale)), false) %>'
			url="<%= taglibEditURL %>"
		/>
	</div>
</c:if>