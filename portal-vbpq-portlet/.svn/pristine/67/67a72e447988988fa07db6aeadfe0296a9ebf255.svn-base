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

package com.dtt.portal.dao.vbpq.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author HuyMQ
 */
public class VanBanPhapQuyFinderUtil {
	public static int count(java.lang.String keyword, long groupId,
		long[] loaiVanBanIds, long[] linhVucVanBanIds, long[] coQuanBanHanhIds,
		java.lang.Integer status, java.util.Date startDateObj,
		java.util.Date endDateObj)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .count(keyword, groupId, loaiVanBanIds, linhVucVanBanIds,
			coQuanBanHanhIds, status, startDateObj, endDateObj);
	}

	public static java.util.List<com.dtt.portal.dao.vbpq.model.VanBanPhapQuy> find(
		java.lang.String keyword, long groupId, long[] loaiVanBanIds,
		long[] linhVucVanBanIds, long[] coQuanBanHanhIds,
		java.lang.Integer status, java.util.Date startDateObj,
		java.util.Date endDateObj, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .find(keyword, groupId, loaiVanBanIds, linhVucVanBanIds,
			coQuanBanHanhIds, status, startDateObj, endDateObj, start, end, obc);
	}

	public static VanBanPhapQuyFinder getFinder() {
		if (_finder == null) {
			_finder = (VanBanPhapQuyFinder)PortletBeanLocatorUtil.locate(com.dtt.portal.dao.vbpq.service.ClpSerializer.getServletContextName(),
					VanBanPhapQuyFinder.class.getName());

			ReferenceRegistry.registerReference(VanBanPhapQuyFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(VanBanPhapQuyFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(VanBanPhapQuyFinderUtil.class,
			"_finder");
	}

	private static VanBanPhapQuyFinder _finder;
}