<%--
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
--%>

<%@page import="com.dtt.portal.dao.vbpq.model.LoaiVanBan"%>
<%@page import="com.dtt.portal.dao.vbpq.model.LinhVucVanBan"%>
<%@page import="com.dtt.portal.dao.vbpq.model.CoQuanBanHanhVanBan"%>
<%@page import="com.dtt.portal.adminvbpq.business.LoaiVanBanBusiness"%>
<%@page import="com.dtt.portal.adminvbpq.business.LinhVucVanBanBusiness"%>
<%@page import="com.dtt.portal.adminvbpq.business.CoQuanBanHanhBusiness"%>
<%@ include file="init.jsp" %>

<%
VanBanSearch searchContainer = (VanBanSearch)request.getAttribute("liferay-ui:search:searchContainer");

VanBanDisplayTerms displayTerms = (VanBanDisplayTerms)searchContainer.getDisplayTerms();

List<Group> sites = VanBanPhapQuyUtils.getSiteAvailables(themeDisplay);

Calendar startCalendar = Calendar.getInstance();
if(displayTerms.getStartDateObj() != null) {
	startCalendar.setTime(displayTerms.getStartDateObj());
}

Calendar endCalendar = Calendar.getInstance();
if(displayTerms.getEndDateObj() != null) {
	endCalendar.setTime(displayTerms.getEndDateObj());
}

List<CoQuanBanHanhVanBan> lsCoQuanBanHanh = CoQuanBanHanhBusiness.getByTrangThai(displayTerms.getGroupId(), true, -1, -1);
List<LinhVucVanBan> lsLinhVuc = LinhVucVanBanBusiness.getByTrangThai(displayTerms.getGroupId(), true, -1, -1);
List<LoaiVanBan> lsLoaiVanBan = LoaiVanBanBusiness.getByTrangThai(displayTerms.getGroupId(), true, -1, -1);

%>

<aui:fieldset class="search-form-tthc">
	<aui:row>
		<aui:col width="<%= 33 %>">
			<aui:fieldset>
				<aui:select name="<%= displayTerms.LOAI_VAN_BAN_ID %>" 
					label="loai-van-ban"
					cssClass="vbpq_input_text span12"
					showEmptyOption="<%= true %>">
					<%
						for (LoaiVanBan loaiVanBan : lsLoaiVanBan)
						{
					%>
							<aui:option value="<%= loaiVanBan.getId() %>" label="<%= loaiVanBan.getTen() %>"
								selected="<%= loaiVanBan.getId() == displayTerms.getLoaiVanBanId() %>"/>
					<%
						}
					%>
				</aui:select>
			</aui:fieldset>
		</aui:col>

		<aui:col width="<%= 33 %>">
			<aui:fieldset>
				<aui:select name="<%= displayTerms.CO_QUAN_BAN_HANH_ID %>"
					label="co-quan-ban-hanh"
					cssClass="vbpq_input_text span12"
					showEmptyOption="<%= true %>">
					<%
						for (CoQuanBanHanhVanBan coquan : lsCoQuanBanHanh)
						{
					%>
							<aui:option value="<%= coquan.getId() %>" label="<%= coquan.getTen() %>"
								selected="<%= coquan.getId() == displayTerms.getCoQuanBanHanhId() %>" />
					<%
						}
					%>
				</aui:select>
			</aui:fieldset>
		</aui:col>

		<aui:col width="<%= 33 %>">
			<aui:fieldset>
				<aui:select name="<%= displayTerms.LINH_VUC_VAN_BAN_ID %>" 
					label="linh-vuc-van-ban"
					cssClass="vbpq_input_text span12"
					showEmptyOption="<%= true %>">
					<%
						for (LinhVucVanBan linhVuc : lsLinhVuc)
						{
					%>
							<aui:option value="<%= linhVuc.getId() %>" label="<%= linhVuc.getTen() %>"
								selected="<%= linhVuc.getId() == displayTerms.getLinhVucVanBanId() %>" />
					<%
						}
					%>
				</aui:select>
			</aui:fieldset>
		</aui:col>
	</aui:row>
	
	<aui:row>
		<aui:col width="<%= 33 %>">
			<aui:fieldset>
				<aui:select name="<%= displayTerms.STATUS %>" 
					cssClass="vbpq_input_text span12"
					showEmptyOption="<%= false %>">
					
						<aui:option value="-1" label=""/>
					
						<aui:option value="<%= VanBanPhapQuyConstants.STATUS_PUBLISH %>" label="da-dang"
							selected="<%= VanBanPhapQuyConstants.STATUS_PUBLISH == displayTerms.getStatus() %>" />
							
						<aui:option value="<%= VanBanPhapQuyConstants.STATUS_DRAFT %>" label="chua-dang"
							selected="<%= VanBanPhapQuyConstants.STATUS_DRAFT == displayTerms.getStatus() %>" />
					
				</aui:select>
			</aui:fieldset>
		</aui:col>
		
		<aui:col width="<%= 33 %>">
			<aui:field-wrapper label="ban-hanh-tu-ngay">
				<liferay-ui:input-date
					dayValue="<%= startCalendar.get(Calendar.DATE) %>"
					dayParam='<%= displayTerms.START_DATE + "Day" %>'
					disabled="<%= false %>"
					firstDayOfWeek="<%= startCalendar.getFirstDayOfWeek() - 1 %>"
					monthValue="<%= startCalendar.get(Calendar.MONTH) %>"
					monthParam='<%= displayTerms.START_DATE + "Month" %>'
					yearValue="<%= startCalendar.get(Calendar.YEAR) %>"
					yearParam='<%= displayTerms.START_DATE + "Year" %>'
					name="<%= displayTerms.START_DATE %>"
				/>
			</aui:field-wrapper>
		</aui:col>
		
		<aui:col width="<%= 33 %>">
			<aui:field-wrapper label="ban-hanh-den-ngay">
				<liferay-ui:input-date
					dayValue="<%= endCalendar.get(Calendar.DATE) %>"
					dayParam='<%= displayTerms.END_DATE + "Day" %>'
					disabled="<%= false %>"
					firstDayOfWeek="<%= endCalendar.getFirstDayOfWeek() - 1 %>"
					monthValue="<%= endCalendar.get(Calendar.MONTH) %>"
					monthParam='<%= displayTerms.END_DATE + "Month" %>'
					yearValue="<%= endCalendar.get(Calendar.YEAR) %>"
					yearParam='<%= displayTerms.END_DATE + "Year" %>'
					name="<%= displayTerms.END_DATE %>"
				/>
			</aui:field-wrapper>
		</aui:col>
	</aui:row>
	
	<aui:row>
		<c:if test="<%= permissionChecker.isCompanyAdmin() && AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW_THONGKE_SITE) %>">
			<aui:col width="<%= 33 %>">
				<aui:select name="<%= displayTerms.GROUP_ID %>" label="site" cssClass="vbpq_input_text span12">
					<aui:option label="" value="" />
					<% 
					for(Group site : sites) {
					%>
						<aui:option value="<%= site.getGroupId() %>" selected="<%= site.getGroupId() == displayTerms.getGroupId() %>"><%= site.getName() %></aui:option>
					<% } %>
				</aui:select>
			</aui:col>
		</c:if>
		
		<aui:col width="<%= 33 %>">
			<aui:fieldset>
				<aui:input name="keywords" type="text" cssClass="vbpq_input_text span12" label="keyword" value="<%= displayTerms.getKeywords() %>" />
			</aui:fieldset>
		</aui:col>
		
		<aui:col width="<%= 33 %>">
			<aui:button-row>
				<aui:button type="submit" value="search" cssClass="search_button"/>
			</aui:button-row>
		</aui:col>
	</aui:row>
</aui:fieldset>