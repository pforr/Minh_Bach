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
public class LoaiVanBanFinderUtil {
	public static int count(java.lang.String keyword, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder().count(keyword, groupId);
	}

	public static java.util.List<com.dtt.portal.dao.vbpq.model.LoaiVanBan> find(
		java.lang.String keyword, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator obc, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getFinder().find(keyword, groupId, obc, start, end);
	}

	public static LoaiVanBanFinder getFinder() {
		if (_finder == null) {
			_finder = (LoaiVanBanFinder)PortletBeanLocatorUtil.locate(com.dtt.portal.dao.vbpq.service.ClpSerializer.getServletContextName(),
					LoaiVanBanFinder.class.getName());

			ReferenceRegistry.registerReference(LoaiVanBanFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(LoaiVanBanFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(LoaiVanBanFinderUtil.class,
			"_finder");
	}

	private static LoaiVanBanFinder _finder;
}