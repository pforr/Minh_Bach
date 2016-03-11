<%@page import="com.dtt.portal.dao.vbpq.util.WebKeys"%>
<%@page import="com.dtt.portal.adminvbpq.business.LinhVucVanBanBusiness"%>
<%@page import="com.dtt.portal.dao.vbpq.model.LinhVucVanBan"%>
<%@page import="com.dtt.portal.adminvbpq.business.CoQuanBanHanhBusiness"%>
<%@page import="com.dtt.portal.dao.vbpq.model.CoQuanBanHanhVanBan"%>
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
	List<LinhVucVanBan> list = LinhVucVanBanBusiness.getByTrangThai(scopeId, true, 0, 100);
%>

<div class="ls_danhmucvanban">
	<ul>
		<%
			for (LinhVucVanBan linhvuc : list) {
				
		%>
			<li>
				<liferay-portlet:renderURL var="viewVBPQ" portletName="<%= WebKeys.VBPQ_PORTLET_NAME %>">
						<portlet:param name="typeContent" value="<%= typeContent %>"/>
						<portlet:param name="entryId" value="<%= Long.toString(linhvuc.getId()) %>"/>
				</liferay-portlet:renderURL>

				<a href="<%= viewVBPQ %>">
					<%= linhvuc.getTen() %>
				</a>
			</li>
		<%
			}
		%>
	</ul>
</div>
