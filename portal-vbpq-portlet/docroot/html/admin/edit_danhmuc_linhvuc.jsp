<%@page import="com.dtt.portal.dao.vbpq.terms.LinhVucVanBanTerms"%>
<%@page import="com.dtt.portal.adminvbpq.business.LinhVucVanBanBusiness"%>
<%@page import="com.dtt.portal.dao.vbpq.model.LinhVucVanBan"%>
<%@page import="com.dtt.portal.dao.vbpq.terms.CoQuanBanHanhTerms"%>
<%@page import="com.dtt.portal.dao.vbpq.util.MessageErrors"%>
<%@page import="com.dtt.portal.adminvbpq.business.CoQuanBanHanhBusiness"%>
<%@page import="com.dtt.portal.dao.vbpq.model.CoQuanBanHanhVanBan"%>
<%@page import="com.dtt.portal.vbpq.permission.AdminPermission"%>
<%
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
%>

<%@ include file="init.jsp" %>

<liferay-util:include page='<%= templatePath + "top_tabs.jsp" %>' servletContext="<%= application %>" />

<liferay-util:include page='<%= templatePath + "top_tabs_danhmuc.jsp" %>' servletContext="<%= application %>" />

<%
	long id = ParamUtil.getLong(request, "id");
	LinhVucVanBan linhvuc = LinhVucVanBanBusiness.getLinhVucVanBan(id);
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%= (linhvuc == null) ? "them-moi-linh-vuc" : "sua-linh-vuc" %>'
/>

<portlet:actionURL name="updateLinhVuc" var="updateLinhVucURL"/>

<aui:form action="" method="post" name="fm" onSubmit='<%= "event.preventDefault(); submitForm(event.target);" %>'>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value=""/>
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="backURL" type="hidden" value="<%= currentURL %>" />
	<aui:input name="id" type="hidden" value="<%= id %>" />
	
	<liferay-ui:error key="<%= MessageErrors.EMPTY_TEN_CO_QUAN_BAN_HANH %>" message="<%= MessageErrors.EMPTY_TEN_CO_QUAN_BAN_HANH %>" />

	<aui:fieldset>
		<aui:model-context bean="<%= linhvuc %>" model="<%= LinhVucVanBan.class %>" />
		
		<aui:input name="<%= LinhVucVanBanTerms.TEN %>" autoFocus="<%= true %>" type="text" cssClass="lfr-input-text">
			<aui:validator name="required" />
		</aui:input>
		
		<aui:input name="<%= LinhVucVanBanTerms.TRANG_THAI %>" cssClass="lfr-checkbox" label="hien-thi"/>
		
		<aui:input name="<%= LinhVucVanBanTerms.ORDER %>" cssClass="lfr-input-text-order" type="text" />
		
		<aui:button-row>
			<aui:button type="button" value='<%= linhvuc != null ? "save" : "add-new" %>' onClick='<%=renderResponse.getNamespace() + "updateLinhVuc();" %>'/>
			
			<aui:button href="<%= redirect %>" name="cancelButton" type="cancel" />
		</aui:button-row>
	
	</aui:fieldset>

</aui:form>

<aui:script>
	function <portlet:namespace />updateLinhVuc() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= (linhvuc == null) ? Constants.ADD : Constants.UPDATE %>";
		submitForm(document.<portlet:namespace/>fm, '<portlet:actionURL name="updateLinhVuc"/>');
	}
</aui:script>

<%!
	private static final Log _log = LogFactoryUtil.getLog("html_portlet_admin_edit_linhvuc_jsp"); 
%>
