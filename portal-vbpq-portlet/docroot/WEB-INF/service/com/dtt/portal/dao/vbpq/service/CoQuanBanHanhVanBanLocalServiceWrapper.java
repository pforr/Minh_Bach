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

package com.dtt.portal.dao.vbpq.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CoQuanBanHanhVanBanLocalService}.
 *
 * @author HuyMQ
 * @see CoQuanBanHanhVanBanLocalService
 * @generated
 */
public class CoQuanBanHanhVanBanLocalServiceWrapper
	implements CoQuanBanHanhVanBanLocalService,
		ServiceWrapper<CoQuanBanHanhVanBanLocalService> {
	public CoQuanBanHanhVanBanLocalServiceWrapper(
		CoQuanBanHanhVanBanLocalService coQuanBanHanhVanBanLocalService) {
		_coQuanBanHanhVanBanLocalService = coQuanBanHanhVanBanLocalService;
	}

	/**
	* Adds the co quan ban hanh van ban to the database. Also notifies the appropriate model listeners.
	*
	* @param coQuanBanHanhVanBan the co quan ban hanh van ban
	* @return the co quan ban hanh van ban that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.dtt.portal.dao.vbpq.model.CoQuanBanHanhVanBan addCoQuanBanHanhVanBan(
		com.dtt.portal.dao.vbpq.model.CoQuanBanHanhVanBan coQuanBanHanhVanBan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coQuanBanHanhVanBanLocalService.addCoQuanBanHanhVanBan(coQuanBanHanhVanBan);
	}

	/**
	* Creates a new co quan ban hanh van ban with the primary key. Does not add the co quan ban hanh van ban to the database.
	*
	* @param id the primary key for the new co quan ban hanh van ban
	* @return the new co quan ban hanh van ban
	*/
	@Override
	public com.dtt.portal.dao.vbpq.model.CoQuanBanHanhVanBan createCoQuanBanHanhVanBan(
		long id) {
		return _coQuanBanHanhVanBanLocalService.createCoQuanBanHanhVanBan(id);
	}

	/**
	* Deletes the co quan ban hanh van ban with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the co quan ban hanh van ban
	* @return the co quan ban hanh van ban that was removed
	* @throws PortalException if a co quan ban hanh van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.dtt.portal.dao.vbpq.model.CoQuanBanHanhVanBan deleteCoQuanBanHanhVanBan(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _coQuanBanHanhVanBanLocalService.deleteCoQuanBanHanhVanBan(id);
	}

	/**
	* Deletes the co quan ban hanh van ban from the database. Also notifies the appropriate model listeners.
	*
	* @param coQuanBanHanhVanBan the co quan ban hanh van ban
	* @return the co quan ban hanh van ban that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.dtt.portal.dao.vbpq.model.CoQuanBanHanhVanBan deleteCoQuanBanHanhVanBan(
		com.dtt.portal.dao.vbpq.model.CoQuanBanHanhVanBan coQuanBanHanhVanBan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coQuanBanHanhVanBanLocalService.deleteCoQuanBanHanhVanBan(coQuanBanHanhVanBan);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _coQuanBanHanhVanBanLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coQuanBanHanhVanBanLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dtt.portal.dao.vbpq.model.impl.CoQuanBanHanhVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _coQuanBanHanhVanBanLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dtt.portal.dao.vbpq.model.impl.CoQuanBanHanhVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coQuanBanHanhVanBanLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coQuanBanHanhVanBanLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coQuanBanHanhVanBanLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.dtt.portal.dao.vbpq.model.CoQuanBanHanhVanBan fetchCoQuanBanHanhVanBan(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _coQuanBanHanhVanBanLocalService.fetchCoQuanBanHanhVanBan(id);
	}

	/**
	* Returns the co quan ban hanh van ban with the primary key.
	*
	* @param id the primary key of the co quan ban hanh van ban
	* @return the co quan ban hanh van ban
	* @throws PortalException if a co quan ban hanh van ban with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.dtt.portal.dao.vbpq.model.CoQuanBanHanhVanBan getCoQuanBanHanhVanBan(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _coQuanBanHanhVanBanLocalService.getCoQuanBanHanhVanBan(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _coQuanBanHanhVanBanLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the co quan ban hanh van bans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dtt.portal.dao.vbpq.model.impl.CoQuanBanHanhVanBanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of co quan ban hanh van bans
	* @param end the upper bound of the range of co quan ban hanh van bans (not inclusive)
	* @return the range of co quan ban hanh van bans
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.dtt.portal.dao.vbpq.model.CoQuanBanHanhVanBan> getCoQuanBanHanhVanBans(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coQuanBanHanhVanBanLocalService.getCoQuanBanHanhVanBans(start,
			end);
	}

	/**
	* Returns the number of co quan ban hanh van bans.
	*
	* @return the number of co quan ban hanh van bans
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCoQuanBanHanhVanBansCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coQuanBanHanhVanBanLocalService.getCoQuanBanHanhVanBansCount();
	}

	/**
	* Updates the co quan ban hanh van ban in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param coQuanBanHanhVanBan the co quan ban hanh van ban
	* @return the co quan ban hanh van ban that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.dtt.portal.dao.vbpq.model.CoQuanBanHanhVanBan updateCoQuanBanHanhVanBan(
		com.dtt.portal.dao.vbpq.model.CoQuanBanHanhVanBan coQuanBanHanhVanBan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coQuanBanHanhVanBanLocalService.updateCoQuanBanHanhVanBan(coQuanBanHanhVanBan);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _coQuanBanHanhVanBanLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_coQuanBanHanhVanBanLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _coQuanBanHanhVanBanLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.dtt.portal.dao.vbpq.model.CoQuanBanHanhVanBan getByGroupId_Ten(
		long groupId, java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coQuanBanHanhVanBanLocalService.getByGroupId_Ten(groupId, ten);
	}

	/**
	* @param keyword
	* @param groupId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public int countCoQuan(java.lang.String keyword, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _coQuanBanHanhVanBanLocalService.countCoQuan(keyword, groupId);
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
	@Override
	public java.util.List<com.dtt.portal.dao.vbpq.model.CoQuanBanHanhVanBan> findCoQuan(
		java.lang.String keyword, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator obc, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _coQuanBanHanhVanBanLocalService.findCoQuan(keyword, groupId,
			obc, start, end);
	}

	@Override
	public java.util.List<com.dtt.portal.dao.vbpq.model.CoQuanBanHanhVanBan> findByTrangThai(
		boolean trangThai, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _coQuanBanHanhVanBanLocalService.findByTrangThai(trangThai,
			groupId);
	}

	@Override
	public com.dtt.portal.dao.vbpq.model.CoQuanBanHanhVanBan getCoQuanBanHanh(
		long coquanId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _coQuanBanHanhVanBanLocalService.getCoQuanBanHanh(coquanId);
	}

	/**
	* @param groupId
	* @param trangThai
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public int countByTrangThai(long groupId, boolean trangThai)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _coQuanBanHanhVanBanLocalService.countByTrangThai(groupId,
			trangThai);
	}

	/**
	* @param groupId
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public int countAll(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _coQuanBanHanhVanBanLocalService.countAll(groupId);
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
	@Override
	public java.util.List<com.dtt.portal.dao.vbpq.model.CoQuanBanHanhVanBan> getByTrangThai(
		long groupId, boolean trangThai, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _coQuanBanHanhVanBanLocalService.getByTrangThai(groupId,
			trangThai, start, end);
	}

	/**
	* @param groupId
	* @param start
	* @param end
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public java.util.List<com.dtt.portal.dao.vbpq.model.CoQuanBanHanhVanBan> getAll(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _coQuanBanHanhVanBanLocalService.getAll(groupId, start, end);
	}

	/**
	* Delete coquan by Id
	*
	* @param id
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public void deleteCoQuan(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_coQuanBanHanhVanBanLocalService.deleteCoQuan(id);
	}

	/**
	* Delete coquan by entry
	*
	* @param coquan
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public void deleteCoQuan(
		com.dtt.portal.dao.vbpq.model.CoQuanBanHanhVanBan coquan)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_coQuanBanHanhVanBanLocalService.deleteCoQuan(coquan);
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
	@Override
	public com.dtt.portal.dao.vbpq.model.CoQuanBanHanhVanBan updateCoQuanBanHanh(
		long userId, long id, java.lang.String ten, boolean trangThai,
		int order_, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _coQuanBanHanhVanBanLocalService.updateCoQuanBanHanh(userId, id,
			ten, trangThai, order_, groupId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CoQuanBanHanhVanBanLocalService getWrappedCoQuanBanHanhVanBanLocalService() {
		return _coQuanBanHanhVanBanLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCoQuanBanHanhVanBanLocalService(
		CoQuanBanHanhVanBanLocalService coQuanBanHanhVanBanLocalService) {
		_coQuanBanHanhVanBanLocalService = coQuanBanHanhVanBanLocalService;
	}

	@Override
	public CoQuanBanHanhVanBanLocalService getWrappedService() {
		return _coQuanBanHanhVanBanLocalService;
	}

	@Override
	public void setWrappedService(
		CoQuanBanHanhVanBanLocalService coQuanBanHanhVanBanLocalService) {
		_coQuanBanHanhVanBanLocalService = coQuanBanHanhVanBanLocalService;
	}

	private CoQuanBanHanhVanBanLocalService _coQuanBanHanhVanBanLocalService;
}