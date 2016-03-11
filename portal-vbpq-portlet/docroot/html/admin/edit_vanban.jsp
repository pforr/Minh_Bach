<%@page import="com.dtt.portal.dao.vbpq.util.VanBanPhapQuyConstants"%>
<%@page import="com.dtt.portal.dao.vbpq.service.AttachFileLocalServiceUtil"%>
<%@page import="com.dtt.portal.dao.vbpq.model.AttachFile"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@page import="com.dtt.portal.adminvbpq.business.LoaiVanBanBusiness"%>
<%@page import="com.dtt.portal.adminvbpq.business.LinhVucVanBanBusiness"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryPos"%>
<%@page import="com.dtt.portal.dao.vbpq.model.LoaiVanBan"%>
<%@page import="com.dtt.portal.dao.vbpq.model.LinhVucVanBan"%>
<%@page import="com.dtt.portal.adminvbpq.action.CoQuanBanHanhAction"%>
<%@page import="com.dtt.portal.dao.vbpq.terms.VanBanPhapQuyTerms"%>
<%@page import="com.dtt.portal.adminvbpq.business.VanBanPhapQuyBusiness"%>
<%@page import="com.dtt.portal.dao.vbpq.model.VanBanPhapQuy"%>
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

<%
	long id = ParamUtil.getLong(request, "id");
	VanBanPhapQuy vanban = VanBanPhapQuyBusiness.getVanBan(id);
	
	boolean neverExpire = true;
	
	if (Validator.isNotNull(vanban)) {
		neverExpire = vanban.getNgayHetHieuLuc() != null ? false : true;
	}

	List<CoQuanBanHanhVanBan> lsCoQuanBanHanh = CoQuanBanHanhBusiness.getByTrangThai(scopeGroupId, true, -1, -1);
	List<LinhVucVanBan> lsLinhVuc = LinhVucVanBanBusiness.getByTrangThai(scopeGroupId, true, -1, -1);
	List<LoaiVanBan> lsLoaiVanBan = LoaiVanBanBusiness.getByTrangThai(scopeGroupId, true, -1, -1);
	
	List<DLFolder> folders = DLFolderLocalServiceUtil.getFolders(scopeGroupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
	
	List<AttachFile> vanBanAttachFiles = null;
	
	if(vanban != null) {
		vanBanAttachFiles = VanBanPhapQuyBusiness.getAttachFiles(vanban.getId());
	}
	
	long vanBanFolderId = VanBanPhapQuyUtils.getFolderId(themeDisplay.getUserId(), scopeGroupId);
	
	int status = VanBanPhapQuyConstants.STATUS_DRAFT;
	
	if(vanban != null) {
		status = vanban.getStatus();
	}
%>


<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%= (vanban == null) ? "them-moi-van-ban" : "sua-van-ban" %>'
/>

<portlet:actionURL name="updateVanBanPhapQuy" var="updateVanBanPhapQuyURL"/>

<aui:form action="<%= updateVanBanPhapQuyURL %>" method="post" name="fm" enctype="multipart/form-data">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Validator.isNotNull(vanban) ? Constants.UPDATE : Constants.ADD %>"/>
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="backURL" type="hidden" value="<%= currentURL %>" />
	<aui:input name="id" type="hidden" value="<%= id %>" />
	<aui:input name="vanBanFolderId" type="hidden" value="<%= vanBanFolderId %>" />
	<aui:input name="status" type="hidden" value="<%= status %>" />
	
	<liferay-ui:error key="<%= MessageErrors.EMPTY_NGUOI_KY %>" message="<%= MessageErrors.EMPTY_NGUOI_KY %>" />
	<liferay-ui:error key="<%= MessageErrors.EMPTY_TEN_VAN_BAN %>" message="<%= MessageErrors.EMPTY_TEN_VAN_BAN %>" />
	<liferay-ui:error key="<%= MessageErrors.EMPTY_TRICH_YEU %>" message="<%= MessageErrors.EMPTY_TRICH_YEU %>" />
	<liferay-ui:error key="<%= MessageErrors.UNCHECK_LOAI_VAN_BAN %>" message="<%= MessageErrors.UNCHECK_LOAI_VAN_BAN %>" />
	<liferay-ui:error key="<%= MessageErrors.UNCHECK_LINH_VUC_VAN_BAN %>" message="<%= MessageErrors.UNCHECK_LINH_VUC_VAN_BAN %>" />
	<liferay-ui:error key="<%= MessageErrors.UNCHECK_CO_QUAN_BAN_HANH %>" message="<%= MessageErrors.UNCHECK_CO_QUAN_BAN_HANH %>" />

	<aui:fieldset>
		<aui:model-context bean="<%= vanban %>" model="<%= VanBanPhapQuy.class %>" />
		
		<aui:row>
			<aui:col width="<%= 100 %>">
				<aui:input name="<%= VanBanPhapQuyTerms.MA_VAN_BAN %>" autoFocus="<%= true %>" type="text" cssClass="span12">
					<aui:validator name="required" />
				</aui:input>
			</aui:col>
		</aui:row>
		
		<aui:row>
			<aui:col width="<%= 100 %>">
				<aui:input name="trichYeu" type="textarea" cssClass="trich-yeu span12" style='<%= "height: " + ModelHintsConstants.TEXTAREA_DISPLAY_HEIGHT + "px;" %>'/>
			</aui:col>
		</aui:row>
		
		<aui:row>
			<aui:col width="<%= 33 %>">
				<aui:select name="coQuanBanHanh" showEmptyOption="<%= true %>" required="<%= true %>">
					<%
						for (CoQuanBanHanhVanBan coquan : lsCoQuanBanHanh) {
					%>
							<aui:option value="<%= Long.toString(coquan.getId()) %>">
								<%= coquan.getTen() %>
							</aui:option>
					<%
						}
					%>
				</aui:select>
			</aui:col>
			
			<aui:col width="<%= 33 %>">
				<aui:select name="linhVucVanBan" showEmptyOption="<%= true %>" required="<%= true %>">
					<%
						for (LinhVucVanBan linhvuc : lsLinhVuc) {
					%>
							<aui:option value="<%= Long.toString(linhvuc.getId()) %>">
								<%= linhvuc.getTen() %>
							</aui:option>
					<%
						}
					%>
				</aui:select>
			</aui:col>
			
			<aui:col width="<%= 33 %>">
				<aui:select name="loaiVanBan" showEmptyOption="<%= true %>" required="<%= true %>">
					<%
						for (LoaiVanBan loaivanban : lsLoaiVanBan) {
					%>
							<aui:option value="<%= Long.toString(loaivanban.getId()) %>">
								<%= loaivanban.getTen() %>
							</aui:option>
					<%
						}
					%>
				</aui:select>
			</aui:col>
		</aui:row>
		
		<aui:row>
			<aui:col width="<%= 33 %>">
				<aui:input name="ngayBanHanh" />
			</aui:col>
			
			<aui:col width="<%= 33 %>">
				<aui:input name="ngayCoHieuLuc" />
			</aui:col>
			
			<aui:col width="<%= 33 %>">
				<aui:input name="ngayHetHieuLuc" dateTogglerCheckboxLabel="never-expire" disabled="<%= neverExpire %>" formName="fm" />
			</aui:col>
		</aui:row>
		
		<aui:row>
			<aui:col width="<%= 66 %>">
				<aui:field-wrapper>
					<aui:input autoFocus="<%= true %>" name="vanBanFile" onChange='<%= renderResponse.getNamespace() + "validateTitle();" %>' style="width: auto;" type="file" multiple="true">
						<aui:validator name="acceptFiles">
							'<%= StringUtil.merge(PrefsPropsUtil.getStringArray(PropsKeys.DL_FILE_EXTENSIONS, StringPool.COMMA)) %>'
						</aui:validator>
					</aui:input>
					
					<c:if test="<%= vanBanAttachFiles != null %>">
						<ul class="vanBanAttachFiles">
							<% for(AttachFile attachFile : vanBanAttachFiles) { %>
							<li>
								<input type="checkbox" name="<portlet:namespace />deleteAttachFileIds" value="<%= attachFile.getId() %>"/>
								
								<a href="<%= attachFile.getFileLink() %>">
									<c:if test="<%= attachFile.getId() > 0 %>">
										<%= HtmlUtil.escape(attachFile.getFileName()) %> (<%= GetterUtil.getLong(attachFile.getFileSize()) / 1024 %> KB)
									</c:if>
									
									<c:if test="<%= attachFile.getId() == 0 %>">
										<%= HtmlUtil.escape(attachFile.getFileLink()) %></li>
									</c:if>
								</a>
							</li>
							<% } %>
						</ul>
					</c:if>
				</aui:field-wrapper>
			</aui:col>
			
			<aui:col width="<%= 33 %>">
				<aui:input name="nguoiKy" type="text" cssClass="nguoi-ky span12"/>
			</aui:col>
		</aui:row>

		<aui:button-row>
			<aui:button type="submit" value="save"/>
			
			<%
			boolean publishPermission = status != VanBanPhapQuyConstants.STATUS_PUBLISH 
				&& AdminPermission.contains(permissionChecker, scopeGroupId, ActionKeys.PUBLISH_VANBAN);
			%>
			
			<c:if test="<%= publishPermission %>">
				<aui:button value="luu-va-dang" onClick='<%=renderResponse.getNamespace() + "updateStatusVanBan();" %>'/>
			</c:if>
			
			<aui:button href="<%= redirect %>" name="cancelButton" type="cancel" />
		</aui:button-row>
	</aui:fieldset>
</aui:form>

<aui:script>
	function <portlet:namespace />updateVanBan() {
		submitForm(document.<portlet:namespace/>fm, '<portlet:actionURL name="updateVanBanPhapQuy"/>');
	}
	
	function <portlet:namespace />validateTitle() {
		Liferay.Form.get('<portlet:namespace />fm').formValidator.validateField('<portlet:namespace />title');
	}
	
	function <portlet:namespace />updateStatusVanBan() {
		document.<portlet:namespace />fm.<portlet:namespace />status.value = <%= VanBanPhapQuyConstants.STATUS_PUBLISH %>;
		submitForm(document.<portlet:namespace/>fm, '<portlet:actionURL name="updateVanBanPhapQuy"/>');
	}
</aui:script>

<%!
	private static final Log _log = LogFactoryUtil.getLog("html_portlet_admin_edit_vanban_jsp"); 
%>
