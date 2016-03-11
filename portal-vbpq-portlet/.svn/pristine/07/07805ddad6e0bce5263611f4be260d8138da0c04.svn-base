<%@page import="com.dtt.portal.adminvbpq.business.CoQuanBanHanhBusiness"%>
<%@page import="com.dtt.portal.dao.vbpq.model.CoQuanBanHanhVanBan"%>
<%@page import="com.dtt.portal.dao.vbpq.service.CoQuanBanHanhVanBanLocalServiceUtil"%>
<%@page import="com.dtt.portal.dao.vbpq.util.VanBanPhapQuyUtils"%>
<%@include file="/init.jsp"%>

<% 
	List<Group> sites = VanBanPhapQuyUtils.getSiteAvailables(themeDisplay); 
	List<CoQuanBanHanhVanBan> lsCoQuanBanHanh = CoQuanBanHanhBusiness.getByTrangThai(scopeId, true, -1, -1);
%>

<liferay-portlet:actionURL portletConfiguration="true" var="homeVbpqPortletConfigURL">	
	<liferay-portlet:param  name="portletResource" value="<%= portletResource %>"/>
</liferay-portlet:actionURL>

<aui:form name="menu-vbpq-config-form" method="post" action="<%= homeVbpqPortletConfigURL %>">

	<div class="hidden">
		<aui:select name="preferences--scopeId--" label="scope">
			<% for(Group site : sites) { %>
				<c:if test="<%= site.isSite() %>">
					<aui:option value="<%= site.getGroupId() %>" label="<%= site.getName() %>" selected="<%= scopeId == site.getGroupId()  %>"/>
				</c:if>
			<% } %>
		</aui:select>
	</div>
	
	<aui:select name="homeDisplay" label="select-type">
		<%
			for (int i = 1; i < 5; i++)
			{
		%>
			<aui:option value="<%= i %>" selected='<%=Validator.equals(homeDisplay, Integer.toString(i)) %>' label='<%= "home-display" + i %>'/>	
		<%
			}
		%>
	</aui:select>
	
	<aui:select name="coquanbanhanhhome" cssClass="multi_select" label="coquanbanhanh" multiple="<%= true %>" showEmptyOption="<%= true %>">
			<%
				for (CoQuanBanHanhVanBan coquan : lsCoQuanBanHanh)
				{
			%>
					<aui:option value="<%= coquan.getId() %>" label="<%= coquan.getTen() %>" selected="<%= ArrayUtil.contains(coQuanBanHanhIdPrefsHome, coquan.getId()) %>"/>
			<%
				}
			%>
	</aui:select>
	
	<aui:input name="numberVbpqDisplay" type="text" value="<%= numberVbpqDisplay %>"/>
	
	<aui:button-row>
		<aui:button type="submit" value="save"/>
		<aui:button type="cancel"/>
	</aui:button-row>
</aui:form>