
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

<c:if test="<%= AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_VANBANPHAPQUY) %>">
	<aui:nav-bar>
		<aui:nav>
			<portlet:renderURL var="editEntryURL">
				<portlet:param name="mvcPath" value='<%= templatePath + "edit_vanban.jsp" %>' />
				<portlet:param name="redirect" value="<%= currentURL %>"/>
			</portlet:renderURL>

			<aui:nav-item href="<%= editEntryURL %>" label="add" name="addEntryButton" iconCssClass="icon-plus"/>
		</aui:nav>
	</aui:nav-bar>
</c:if>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "view_vanban.jsp" %>' />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
		
	<aui:fieldset>
		<liferay-ui:search-container delta="20" emptyResultsMessage="no-result-were-found" 
			searchContainer="<%= new VanBanSearch(liferayPortletRequest, currentURLObj) %>">
		
			<liferay-ui:search-form
				page='<%= templatePath + "view_vanban_search.jsp" %>'
				servletContext="<%= application %>"
			/>
			
			<%
				VanBanDisplayTerms searchTerms = (VanBanDisplayTerms)searchContainer.getSearchTerms();
			%>
			
			<liferay-ui:search-container-results
				results="<%= VanBanPhapQuyBusiness.find(
					searchTerms.getKeywords(), searchTerms.getGroupId(), searchTerms.getLoaiVanBanIds(), searchTerms.getLinhVucVanBanIds(), 
					searchTerms.getCoQuanBanHanhIds(), searchTerms.getStatusObj(), searchTerms.getStartDateObj(), searchTerms.getEndDateObj(),
					searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator())%>"
				
				total="<%= VanBanPhapQuyBusiness.count(
					searchTerms.getKeywords(), searchTerms.getGroupId(), searchTerms.getLoaiVanBanIds(), searchTerms.getLinhVucVanBanIds(),
					searchTerms.getCoQuanBanHanhIds(), searchTerms.getStatusObj(), searchTerms.getStartDateObj(), searchTerms.getEndDateObj()) %>"
			/>

			<liferay-ui:search-container-row
	 			className="com.dtt.portal.dao.vbpq.model.VanBanPhapQuy"
				keyProperty="id"
				modelVar="vanban"
			>
				<portlet:renderURL var="rowURL">
					<portlet:param name="mvcPath" value='<%= templatePath + "edit_vanban.jsp" %>' />
					<portlet:param name="id" value="<%=String.valueOf(vanban.getId()) %>"/>
					<portlet:param name="redirect" value="<%= currentURL %>"/>
				</portlet:renderURL>
				
				<liferay-ui:search-container-column-text
					name="STT"
					value="<%=String.valueOf(index+1) %>"
					href="<%=rowURL %>"
				/>
				
				<liferay-ui:search-container-column-text
					name="ma-van-ban"
					href="<%= rowURL %>"
					property="maVanBan"
				/>
				
				<liferay-ui:search-container-column-text 
					name="trich-yeu"
					property="trichYeu"
					href="<%= rowURL %>"
				/>

				<liferay-ui:search-container-column-text 
					name="nguoi-tao"
					property="nguoiTao"
					href="<%= rowURL %>"
				/>
				
				<liferay-ui:search-container-column-text
					name="ngay-tao"
					href="<%=rowURL %>"
				>
					<%= dateFormatDateTime.format(vanban.getNgaySua()) %>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text
					name="ngay-ban-hanh"
					href="<%=rowURL %>"
				>
					<c:if test="<%= vanban.getNgayBanHanh() != null %>">
						<%= dateFormatDate.format(vanban.getNgayBanHanh()) %>
					</c:if>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text
					name="status"
					href="<%=rowURL %>"
				>
					<c:choose>
						<c:when test="<%= vanban.getStatus() == VanBanPhapQuyConstants.STATUS_PUBLISH %>">
							<liferay-ui:message key="da-dang" />
						</c:when>
						
						<c:otherwise>
							<liferay-ui:message key="chua-dang" />
						</c:otherwise>
					</c:choose>
				</liferay-ui:search-container-column-text>

				<%
				boolean deletePermission = AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.DELETE_VANBANPHAPQUY);
				boolean publishPermission = vanban.getStatus() != VanBanPhapQuyConstants.STATUS_PUBLISH 
					&& AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.PUBLISH_VANBAN);
				%>
				
				<c:if test="<%= deletePermission || publishPermission %>">
					<liferay-ui:search-container-column-text
						name="action"
					>
						<c:if test="<%= publishPermission %>">
							
							<portlet:actionURL var="publishURL" name="updateStatusVanBan">
								<portlet:param name="id" value="<%= String.valueOf(vanban.getId()) %>"/>
								<portlet:param name="status" value="<%= String.valueOf(VanBanPhapQuyConstants.STATUS_PUBLISH) %>"/>
								<portlet:param name="redirect" value="<%= currentURL %>"/>
							</portlet:actionURL>
							
							<liferay-ui:icon image="post" message="publish" url="<%=publishURL %>" />
						</c:if>
						
						<c:if test="<%= deletePermission %>">
							<portlet:actionURL var="deleteURL" name="deleteVanBan">
								<portlet:param name="id" value="<%= String.valueOf(vanban.getId()) %>"/>
								<portlet:param name="redirect" value="<%= currentURL %>"/>
							</portlet:actionURL>
						
							<liferay-ui:icon-delete url="<%= deleteURL %>" />
						</c:if>
					</liferay-ui:search-container-column-text>
				</c:if>
				
			</liferay-ui:search-container-row>
	
			<liferay-ui:search-iterator/>
			
		</liferay-ui:search-container>
	</aui:fieldset>
</aui:form>
