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

package com.dtt.portal.dao.vbpq.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.User;
import com.dtt.portal.dao.vbpq.model.CoQuanBanHanhVanBan;
import com.dtt.portal.dao.vbpq.service.base.CoQuanBanHanhVanBanLocalServiceBaseImpl;

/**
 * The implementation of the co quan ban hanh van ban local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.dtt.portal.dao.vbpq.service.CoQuanBanHanhVanBanLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author point
 * @see com.dtt.portal.dao.vbpq.service.base.CoQuanBanHanhVanBanLocalServiceBaseImpl
 * @see com.dtt.portal.dao.vbpq.service.CoQuanBanHanhVanBanLocalServiceUtil
 */
public class CoQuanBanHanhVanBanLocalServiceImpl extends
		CoQuanBanHanhVanBanLocalServiceBaseImpl {

	public CoQuanBanHanhVanBan getByGroupId_Ten(long groupId, String ten)
			throws SystemException {
		return coQuanBanHanhVanBanPersistence.fetchByGroupId_Ten(groupId, ten);
	}

	/**
	 * @param keyword
	 * @param groupId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public int countCoQuan(String keyword, long groupId)
			throws PortalException, SystemException {
		return coQuanBanHanhVanBanFinder.count(keyword, groupId);
	}

	/**
	 * @param keyword
	 * @param groupId
	 * @param obc
	 * @param start
	 * @param end
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public List<CoQuanBanHanhVanBan> findCoQuan(String keyword, long groupId,
			OrderByComparator obc, int start, int end) throws PortalException,
			SystemException {
		return coQuanBanHanhVanBanFinder
				.find(keyword, groupId, obc, start, end);
	}

	public List<CoQuanBanHanhVanBan> findByTrangThai(boolean trangThai,
			long groupId) throws PortalException, SystemException {
		return coQuanBanHanhVanBanPersistence.findByTrangThai(trangThai,
				groupId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dtt.portal.dao.vbpq.service.CoQuanBanHanhVanBanLocalService#
	 * getCoQuanBanHanh(long)
	 */
	public CoQuanBanHanhVanBan getCoQuanBanHanh(long coquanId)
			throws PortalException, SystemException {
		return coQuanBanHanhVanBanPersistence.fetchByPrimaryKey(coquanId);
	}

	/**
	 * @param groupId
	 * @param trangThai
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public int countByTrangThai(long groupId, boolean trangThai)
			throws PortalException, SystemException {
		return coQuanBanHanhVanBanPersistence.countByTrangThai(trangThai,
				groupId);
	}

	/**
	 * @param groupId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public int countAll(long groupId) throws PortalException, SystemException {
		return coQuanBanHanhVanBanPersistence.countByG_(groupId);
	}

	/**
	 * @param groupId
	 * @param trangThai
	 * @param start
	 * @param end
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public List<CoQuanBanHanhVanBan> getByTrangThai(long groupId,
			boolean trangThai, int start, int end) throws PortalException,
			SystemException {
		return coQuanBanHanhVanBanPersistence.findByTrangThai(trangThai,
				groupId, start, end);
	}

	/**
	 * @param groupId
	 * @param start
	 * @param end
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public List<CoQuanBanHanhVanBan> getAll(long groupId, int start, int end)
			throws PortalException, SystemException {
		return coQuanBanHanhVanBanPersistence.findByG_(groupId, start, end);
	}

	/**
	 * Delete coquan by Id
	 * 
	 * @param id
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void deleteCoQuan(long id) throws PortalException, SystemException {
		CoQuanBanHanhVanBan coquan = coQuanBanHanhVanBanPersistence
				.findByPrimaryKey(id);

		deleteCoQuan(coquan);
	}

	/**
	 * Delete coquan by entry
	 * 
	 * @param coquan
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void deleteCoQuan(CoQuanBanHanhVanBan coquan)
			throws PortalException, SystemException {
		coQuanBanHanhVanBanPersistence.remove(coquan);
	}

	/**
	 * @param userId
	 * @param id
	 * @param ten
	 * @param trangThai
	 * @param order_
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public CoQuanBanHanhVanBan updateCoQuanBanHanh(long userId, long id,
			String ten, boolean trangThai, int order_, long groupId)
			throws PortalException, SystemException {
		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		CoQuanBanHanhVanBan coquan = null;

		if (id > 0) {
			coquan = coQuanBanHanhVanBanPersistence.findByPrimaryKey(id);
		} else {
			id = counterLocalService.increment(CoQuanBanHanhVanBan.class
					.getName());

			coquan = coQuanBanHanhVanBanPersistence.create(id);

			coquan.setNgayTao(now);
			coquan.setNguoiTao(user.getFullName());
		}

		coquan.setNgaySua(now);
		coquan.setNguoiSua(user.getFullName());
		coquan.setTen(ten);
		coquan.setTrangThai(trangThai);
		coquan.setOrder_(order_);
		coquan.setGroupId(groupId);

		coQuanBanHanhVanBanPersistence.update(coquan);

		coQuanBanHanhVanBanPersistence.clearCache();

		return coquan;
	}
}