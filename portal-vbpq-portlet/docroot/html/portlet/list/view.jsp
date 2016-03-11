<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.dtt.portal.dao.vbpq.service.CoQuanBanHanhVanBanLocalServiceUtil"%>
<%@page import="com.dtt.portal.dao.vbpq.util.VanBanPhapQuyConstants"%>
<%@page import="com.dtt.portal.dao.vbpq.util.VanBanPhapQuyUtils"%>
<%@page import="com.dtt.portal.dao.vbpq.service.AttachFileLocalServiceUtil"%>
<%@page import="com.dtt.portal.dao.vbpq.model.AttachFile"%>
<%@page import="com.dtt.portal.adminvbpq.business.LoaiVanBanBusiness"%>
<%@page import="com.dtt.portal.adminvbpq.business.LinhVucVanBanBusiness"%>
<%@page import="com.dtt.portal.adminvbpq.business.CoQuanBanHanhBusiness"%>
<%@page import="com.dtt.portal.dao.vbpq.model.LoaiVanBan"%>
<%@page import="com.dtt.portal.dao.vbpq.model.LinhVucVanBan"%>
<%@page import="com.dtt.portal.dao.vbpq.model.CoQuanBanHanhVanBan"%>
<%@page import="com.dtt.portal.dao.vbpq.model.VanBanPhapQuy"%>
<%@page import="com.dtt.portal.adminvbpq.business.VanBanPhapQuyBusiness"%>
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

<%@ include file="/init.jsp" %>

<%
	String keyword = ParamUtil.getString(request, "keyword");
	
	int typeContentMenu = ParamUtil.getInteger(request, "typeContent");
	
	long entryId = ParamUtil.getLong(request, "entryId");
	long coQuanBanHanhId = ParamUtil.getLong(request, "coQuanBanHanhId");
	long loaiVanBanId = ParamUtil.getLong(request, "loaiVanBanId");
	long linhVucVanBanId = ParamUtil.getLong(request, "linhVucVanBanId");
	int year = ParamUtil.getInteger(request, "year");
	
	if (typeContentMenu != 0 && entryId != 0) {
		if (typeContentMenu == 1) {
			coQuanBanHanhId = entryId;
		} else if (typeContentMenu == 2) {
			linhVucVanBanId = entryId;
		} else if (typeContentMenu == 3) {
			loaiVanBanId = entryId;
		}
	}
	
	List<CoQuanBanHanhVanBan> lsCoQuanBanHanh = null;
	if(coQuanBanHanhIdPrefs != null && coQuanBanHanhIdPrefs.length > 0) {
		lsCoQuanBanHanh = CoQuanBanHanhBusiness.getByListSelected(coQuanBanHanhIdPrefs);
	} else {
		lsCoQuanBanHanh = CoQuanBanHanhBusiness.getByTrangThai(scopeId, true, -1, -1);
	}
	
	List<LinhVucVanBan> lsLinhVuc = null;
	if(linhVucVanBanIdPrefs != null && linhVucVanBanIdPrefs.length > 0) {
		lsLinhVuc = LinhVucVanBanBusiness.getByListSelected(linhVucVanBanIdPrefs);
	} else {
		lsLinhVuc = LinhVucVanBanBusiness.getByTrangThai(scopeId, true, -1, -1);
	}
	
	List<LoaiVanBan> lsLoaiVanBan = null;
	if(loaiVanBanIdPrefs != null && loaiVanBanIdPrefs.length > 0) {
		lsLoaiVanBan = LoaiVanBanBusiness.getByListSelected(loaiVanBanIdPrefs);
	} else {
		lsLoaiVanBan = LoaiVanBanBusiness.getByTrangThai(scopeId, true, -1, -1);
	}
	
	long[] coQuanBanHanhIds = coQuanBanHanhIdPrefs;
	if(coQuanBanHanhId > 0) {
		coQuanBanHanhIds = new long[]{coQuanBanHanhId};
	}
	
	long[] linhVucVanBanIds = linhVucVanBanIdPrefs;
	if(linhVucVanBanId > 0) {
		linhVucVanBanIds = new long[]{linhVucVanBanId};
	}
	long[] loaiVanBanIds = loaiVanBanIdPrefs;
	if(loaiVanBanId > 0) {
		loaiVanBanIds = new long[]{loaiVanBanId};
	}
	
	Date startDate = null;
	Date endDate = null;
	//SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	if(year > 0){
		Calendar cStartDate = Calendar.getInstance();
		cStartDate.set(Calendar.YEAR, year);
		cStartDate.set(Calendar.MONTH, 0);
		cStartDate.set(Calendar.DAY_OF_MONTH, 1);
		cStartDate.set(Calendar.HOUR_OF_DAY, 0);
		cStartDate.set(Calendar.MINUTE, 0);
		cStartDate.set(Calendar.SECOND, 0);
		cStartDate.set(Calendar.MILLISECOND, 0);
		startDate = cStartDate.getTime();
		//System.out.println(format.format(cStartDate.getTime()));
		
		Calendar cEndDate = Calendar.getInstance();
		cEndDate.set(Calendar.YEAR, year);
		cEndDate.set(Calendar.MONTH, 11);
		cEndDate.set(Calendar.DAY_OF_MONTH, 31);
		cEndDate.set(Calendar.HOUR_OF_DAY, 23);
		cEndDate.set(Calendar.MINUTE, 59);
		cEndDate.set(Calendar.SECOND, 59);
		cEndDate.set(Calendar.MILLISECOND, 0);
		endDate = cEndDate.getTime();
		//System.out.println(format.format(cEndDate.getTime()));
	}
%>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "view.jsp" %>' />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">

	<liferay-portlet:renderURLParams varImpl="searchURL" />
	
	<div class="search-form-tthc">
		<aui:row>
			<aui:col width="<%= 100 %>">
				<aui:fieldset>
					<aui:input name="keyword" type="text" cssClass="vbpq_input_text span12" label="keyword" value="<%= keyword %>" />
				</aui:fieldset>
			</aui:col>
		</aui:row>
		
		<aui:row>
		
			<c:if test="<%= showSearchLoaiVanBan %>">
				<aui:col width="<%= 25 %>">
					<aui:fieldset>
						<aui:select name="loaiVanBanId" label="loai-van-ban" cssClass="tthc_input_select" showEmptyOption="<%= true %>">
							<%
								for (LoaiVanBan loaiVanBan : lsLoaiVanBan)
								{
							%>
									<aui:option value="<%= loaiVanBan.getId() %>" label="<%= loaiVanBan.getTen() %>"
										selected="<%= loaiVanBan.getId() == loaiVanBanId %>"/>
							<%
								}
							%>
						</aui:select>
					</aui:fieldset>
				</aui:col>
			</c:if>
			
			<c:if test="<%= showSearchCoQuanBanHanh %>">
				<aui:col width="<%= 25 %>">
					<aui:fieldset>
						<aui:select name="coQuanBanHanhId" label="co-quan-ban-hanh" cssClass="vbpq_input_text" showEmptyOption="<%= true %>">
							<%
								for (CoQuanBanHanhVanBan coquan : lsCoQuanBanHanh)
								{
							%>
									<aui:option value="<%= coquan.getId() %>" label="<%= coquan.getTen() %>"
										selected="<%= coquan.getId() == coQuanBanHanhId %>" />
							<%
								}
							%>
						</aui:select>
					</aui:fieldset>
				</aui:col>
			</c:if>
			
			<c:if test="<%= showSearchLinhVuc %>">
				<aui:col width="<%= 25 %>">
					<aui:fieldset>
						<aui:select name="linhVucVanBanId" label="linh-vuc-van-ban" cssClass="tthc_input_select" showEmptyOption="<%= true %>">
							<%
								for (LinhVucVanBan linhVuc : lsLinhVuc)
								{
							%>
									<aui:option value="<%= linhVuc.getId() %>" label="<%= linhVuc.getTen() %>"
										selected="<%= linhVuc.getId() == linhVucVanBanId %>" />
							<%
								}
							%>
						</aui:select>
					</aui:fieldset>
				</aui:col>
			</c:if>
			
			<c:if test="<%= showSearchYear %>">
				<aui:col width="<%= 25 %>">
					<aui:fieldset>
						<aui:select name="year" label="year" cssClass="tthc_input_select" showEmptyOption="<%= true %>">
							<%
								for (int i = 1992; i< 2020; i++)
								{
							%>
									<aui:option value="<%= i %>" label="<%= i %>" selected="<%= i == year %>"/>
							<%
								}
							%>
						</aui:select>
					</aui:fieldset>
				</aui:col>
			</c:if>
			
			
		</aui:row>
		
		<aui:fieldset>
			<aui:button-row>
				<aui:button name="search" type="submit" value="search" cssClass="search_button"/>
			</aui:button-row>
		</aui:fieldset>
	</div>

	<liferay-ui:search-container delta="20" emptyResultsMessage="no-result-were-found">
		<liferay-ui:search-container-results
			results="<%= VanBanPhapQuyBusiness.find(keyword, scopeId,
					loaiVanBanIds, linhVucVanBanIds, coQuanBanHanhIds, VanBanPhapQuyConstants.STATUS_PUBLISH, startDate, endDate,
					searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator())%>"
			total="<%= VanBanPhapQuyBusiness.count(keyword, scopeId,
					loaiVanBanIds, linhVucVanBanIds, coQuanBanHanhIds, VanBanPhapQuyConstants.STATUS_PUBLISH, startDate, endDate) %>"
	/>   
		<liferay-ui:search-container-row
 			className="com.dtt.portal.dao.vbpq.model.VanBanPhapQuy"
			keyProperty="id"
			modelVar="vanban"
		>
			<portlet:renderURL var="rowURL">
				<portlet:param name="mvcPath" value='<%= templatePath + "view_detail.jsp" %>' />
				<portlet:param name="id" value="<%=String.valueOf(vanban.getId()) %>"/>
			</portlet:renderURL>

			
			<liferay-ui:search-container-column-text
				name="ma-van-ban"
				href="<%= rowURL %>"
				property="maVanBan"
				cssClass="vbpq-sohieuvanban"
				align="left"
			/>
			
			<liferay-ui:search-container-column-text 
				name="trich-yeu"
				property="trichYeu"
				href="<%= rowURL %>"
			/>
			<c:if test="<%= showCQBH %>">
			<liferay-ui:search-container-column-text
					name="don-vi-ban-hanh"
					href="<%=rowURL %>"
					cssClass="vbpq-donvibanhanh"
				>
				
					<%
						long cqbhId = vanban.getCoQuanBanHanh();
						String tenCQBH = StringPool.BLANK;
						if(cqbhId > 0){
							CoQuanBanHanhVanBan banHanhVanBan = null;
							try{
								banHanhVanBan = CoQuanBanHanhVanBanLocalServiceUtil.getCoQuanBanHanh(cqbhId);
								if(banHanhVanBan != null){
									tenCQBH =  banHanhVanBan.getTen();
								}
							}catch(Exception e){
								
							}
						}
					%>
					<%=tenCQBH %>
			</liferay-ui:search-container-column-text>
			</c:if>
			<c:if test="<%= showNgayBanHanh %>">
				<liferay-ui:search-container-column-text
					name="ngay-ban-hanh"
					href="<%=rowURL %>"
					cssClass="vbpq-ngaybanhanh"
				>
					<%= dateFormatDate.format(vanban.getNgayBanHanh()) %>
				</liferay-ui:search-container-column-text>
			</c:if>
			
			<c:if test="<%= showNguoiKy %>">
				<liferay-ui:search-container-column-text 
					name="nguoi-ky"
					property="nguoiKy"
					href="<%= rowURL %>"
					cssClass="vbpq-nguoiky"
				/>
			</c:if>
			<c:if test="<%= showAttachment %>">
			<liferay-ui:search-container-column-text 
				name="file-dinh-kem"
				cssClass="vbpq-file-dinh-kem"
			>
				<%
					List<AttachFile> lsFile = new ArrayList<AttachFile>(); 
					
					if (Validator.isNotNull(lsFile)) {
						lsFile = AttachFileLocalServiceUtil.getAttachByVanBan(vanban.getId());
					}
				%>
				
				<c:if test="<%= lsFile.size() != 0 %>">
					<%
					for (AttachFile atf : lsFile)
					{
						StringBuilder sb = new StringBuilder(4);
						
						String ext = VanBanPhapQuyUtils.getExtensionFile(atf.getFileName());
						
						if(Validator.isNotNull(ext)) {
							sb.append(request.getContextPath());
							sb.append("/images/");
							sb.append(ext.toUpperCase());
							sb.append(".png");
						}
						
						String imgStr = sb.toString();
					%>
						<div>
							<a href="<%= atf.getFileLink() %>" style="padding-right: 5px;">
								<c:choose>
									<c:when test="<%= Validator.isNotNull(imgStr) %>">
										<img alt="" src="<%= imgStr %>" />
									</c:when>
									
									<c:otherwise>
										<liferay-ui:icon image="clip"/>
									</c:otherwise>
								</c:choose>
								
								<span><%= HtmlUtil.escape(vanban.getMaVanBan()) %></span>
							</a>
						</div>
					<% } %>
				</c:if>
			</liferay-ui:search-container-column-text>
			</c:if>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />

	</liferay-ui:search-container>
</aui:form>
