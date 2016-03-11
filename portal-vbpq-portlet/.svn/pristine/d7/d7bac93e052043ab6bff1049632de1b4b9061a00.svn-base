
<%@page import="com.dtt.portal.dao.vbpq.util.VanBanPhapQuyUtils"%>
<%@include file="/init.jsp"%>

<% List<Group> sites = VanBanPhapQuyUtils.getSiteAvailables(themeDisplay); %>

<liferay-portlet:actionURL portletConfiguration="true" var="menuVbpqPortletConfigURL">	
	<liferay-portlet:param  name="portletResource" value="<%= portletResource %>"/>
</liferay-portlet:actionURL>

<aui:form name="menu-vbpq-config-form" method="post" action="<%=menuVbpqPortletConfigURL %>">
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
	
	<aui:select name="typeContent" label="select-type">
		<%
			for (int i = 1; i < 4; i++)
			{
		%>
			<aui:option value="<%= i %>" selected='<%=Validator.equals(typeContent, Integer.toString(i)) %>' label='<%= "type-content-" + i %>'/>	
		<%
			}
		%>
	</aui:select>
	
	<aui:button-row>
		<aui:button type="submit" value="save"/>
		<aui:button type="cancel"/>
	</aui:button-row>
</aui:form>