<%@page import="com.dtt.portal.dao.vbpq.util.VanBanPhapQuyUtils"%>
<%@page import="com.dtt.portal.dao.vbpq.model.LinhVucVanBan"%>
<%@page import="com.dtt.portal.adminvbpq.business.LinhVucVanBanBusiness"%>
<%@page import="com.dtt.portal.adminvbpq.business.CoQuanBanHanhBusiness"%>
<%@page import="com.dtt.portal.dao.vbpq.model.CoQuanBanHanhVanBan"%>
<%@page import="com.dtt.portal.adminvbpq.business.LoaiVanBanBusiness"%>
<%@page import="com.dtt.portal.dao.vbpq.model.LoaiVanBan"%>
<%@include file="/init.jsp"%>

<%
List<Group> sites = VanBanPhapQuyUtils.getSiteAvailables(themeDisplay);

List<CoQuanBanHanhVanBan> lsCoQuanBanHanh = CoQuanBanHanhBusiness.getByTrangThai(scopeId, true, -1, -1);
List<LinhVucVanBan> lsLinhVuc = LinhVucVanBanBusiness.getByTrangThai(scopeId, true, -1, -1);
List<LoaiVanBan> lsLoaiVanBan = LoaiVanBanBusiness.getByTrangThai(scopeId, true, -1, -1);

%>

<liferay-portlet:actionURL portletConfiguration="true" var="menuVbpqPortletConfigURL">	
	<liferay-portlet:param  name="portletResource" value="<%= portletResource %>"/>
</liferay-portlet:actionURL>

<aui:form name="fm" method="post" action="<%=menuVbpqPortletConfigURL %>">
	<aui:fieldset>
		<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
		
		<div class="hidden">
			<aui:select name="preferences--scopeId--" label="scope">
			<% for(Group site : sites) { %>
				<c:if test="<%= site.isSite() %>">
					<aui:option value="<%= site.getGroupId() %>" label="<%= site.getName() %>" selected="<%= scopeId == site.getGroupId()  %>"/>
				</c:if>
			<% } %>
			</aui:select>
		</div>
		
		<aui:row>
			<aui:col width="<%= 25 %>">
				<aui:input type="checkbox" name="preferences--showSearchLoaiVanBan--" value="<%= showSearchLoaiVanBan %>" cssClass="tthc_input_select" label="show-search-loai-van-ban" />
				
				<aui:select name="preferences--loaivanban--" cssClass="multi_select" label="loaivanban" multiple="<%= true %>" showEmptyOption="<%= true %>">
					<%
						for (LoaiVanBan loaivanban : lsLoaiVanBan)
						{
					%>
							<aui:option value="<%= loaivanban.getId() %>" label="<%= loaivanban.getTen() %>" selected="<%= ArrayUtil.contains(loaiVanBanIdPrefs, loaivanban.getId()) %>"/>
					<%
						}
					%>
				</aui:select>
			</aui:col>
			
			<aui:col width="<%= 25 %>">
				<aui:input type="checkbox" name="preferences--showSearchCoQuanBanHanh--" value="<%= showSearchCoQuanBanHanh %>" cssClass="tthc_input_select" label="show-search-co-quan-ban-hanh" />
				
				<aui:select name="preferences--coquanbanhanh--" cssClass="multi_select" label="coquanbanhanh" multiple="<%= true %>" showEmptyOption="<%= true %>">
					<%
						for (CoQuanBanHanhVanBan coquan : lsCoQuanBanHanh)
						{
					%>
							<aui:option value="<%= coquan.getId() %>" label="<%= coquan.getTen() %>" selected="<%= ArrayUtil.contains(coQuanBanHanhIdPrefs, coquan.getId()) %>"/>
					<%
						}
					%>
				</aui:select>
			</aui:col>
			
			<aui:col width="<%= 25 %>">
				<aui:input type="checkbox" name="preferences--showSearchLinhVuc--" value="<%= showSearchLinhVuc %>" cssClass="tthc_input_select" label="show-search-linh-vuc" />
				
				<aui:select name="preferences--linhvuc--" cssClass="multi_select" label="linhvuc" multiple="<%= true %>" showEmptyOption="<%= true %>">
					<%
						for (LinhVucVanBan linhvuc : lsLinhVuc)
						{
					%>
							<aui:option value="<%= linhvuc.getId() %>" label="<%= linhvuc.getTen() %>" selected="<%= ArrayUtil.contains(linhVucVanBanIdPrefs, linhvuc.getId()) %>"/>
					<%
						}
					%>
				</aui:select>
			</aui:col>
			
			<aui:col width="<%= 25 %>">
				<aui:input type="checkbox" name="preferences--showSearchYear--" value="<%= showSearchYear %>" label="year" cssClass="tthc_input_select" />
				
				<aui:select name="preferences--year--" cssClass="multi_select"  label="year" multiple="<%= true %>" showEmptyOption="<%= true %>">
					<%
						for (int i = 1992; i< 2020; i++)
						{
					%>
							<aui:option value="<%= i %>" label="<%= i %>" selected="<%= ArrayUtil.contains(years, i) %>"/>
					<%
						}
					%>
				</aui:select>
			</aui:col>
		</aui:row>
		
		<aui:input type="checkbox" name="preferences--showNgayBanHanh--" value="<%= showNgayBanHanh %>" cssClass="tthc_input_select" label="show-ngay-ban-hanh" />
		
		<aui:input type="checkbox" name="preferences--showNguoiKy--" value="<%= showNguoiKy %>" cssClass="tthc_input_select" label="show-nguoi-ky" />
		
		<aui:input type="checkbox" name="preferences--showDetail--" value="<%= showDetail %>" cssClass="tthc_input_select" label="show-detail" />
		
		<aui:input type="checkbox" name="preferences--showAttachment--" value="<%= showAttachment %>" cssClass="tthc_input_select" label="show-attachment" />
		
		<aui:input type="checkbox" name="preferences--showCQBH--" value="<%= showCQBH %>" cssClass="tthc_input_select" label="show-cqbh" />
		
		
		<aui:button-row>
			<aui:button type="submit" value="save"/>
			<aui:button type="cancel"/>
		</aui:button-row>
	</aui:fieldset>
</aui:form>