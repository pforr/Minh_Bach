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

import com.dtt.portal.dao.vbpq.NoSuchVanBanPhapQuyException;
import com.dtt.portal.dao.vbpq.model.VanBanPhapQuy;
import com.dtt.portal.dao.vbpq.model.impl.VanBanPhapQuyImpl;
import com.dtt.portal.dao.vbpq.model.impl.VanBanPhapQuyModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the van ban phap quy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HuyMQ
 * @see VanBanPhapQuyPersistence
 * @see VanBanPhapQuyUtil
 * @generated
 */
public class VanBanPhapQuyPersistenceImpl extends BasePersistenceImpl<VanBanPhapQuy>
	implements VanBanPhapQuyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VanBanPhapQuyUtil} to access the van ban phap quy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VanBanPhapQuyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
			VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED,
			VanBanPhapQuyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
			VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED,
			VanBanPhapQuyImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
			VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
			VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED,
			VanBanPhapQuyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
			VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED,
			VanBanPhapQuyImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupId",
			new String[] { Long.class.getName(), Integer.class.getName() },
			VanBanPhapQuyModelImpl.GROUPID_COLUMN_BITMASK |
			VanBanPhapQuyModelImpl.STATUS_COLUMN_BITMASK |
			VanBanPhapQuyModelImpl.NGAYBANHANH_COLUMN_BITMASK |
			VanBanPhapQuyModelImpl.NGAYCOHIEULUC_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
			VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the van ban phap quies where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching van ban phap quies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VanBanPhapQuy> findByGroupId(long groupId, int status)
		throws SystemException {
		return findByGroupId(groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the van ban phap quies where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dtt.portal.dao.vbpq.model.impl.VanBanPhapQuyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of van ban phap quies
	 * @param end the upper bound of the range of van ban phap quies (not inclusive)
	 * @return the range of matching van ban phap quies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VanBanPhapQuy> findByGroupId(long groupId, int status,
		int start, int end) throws SystemException {
		return findByGroupId(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the van ban phap quies where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dtt.portal.dao.vbpq.model.impl.VanBanPhapQuyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of van ban phap quies
	 * @param end the upper bound of the range of van ban phap quies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching van ban phap quies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VanBanPhapQuy> findByGroupId(long groupId, int status,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] {
					groupId, status,
					
					start, end, orderByComparator
				};
		}

		List<VanBanPhapQuy> list = (List<VanBanPhapQuy>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VanBanPhapQuy vanBanPhapQuy : list) {
				if ((groupId != vanBanPhapQuy.getGroupId()) ||
						(status != vanBanPhapQuy.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_VANBANPHAPQUY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPID_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VanBanPhapQuyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

				if (!pagination) {
					list = (List<VanBanPhapQuy>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VanBanPhapQuy>(list);
				}
				else {
					list = (List<VanBanPhapQuy>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first van ban phap quy in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching van ban phap quy
	 * @throws com.dtt.portal.dao.vbpq.NoSuchVanBanPhapQuyException if a matching van ban phap quy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanPhapQuy findByGroupId_First(long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchVanBanPhapQuyException, SystemException {
		VanBanPhapQuy vanBanPhapQuy = fetchByGroupId_First(groupId, status,
				orderByComparator);

		if (vanBanPhapQuy != null) {
			return vanBanPhapQuy;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVanBanPhapQuyException(msg.toString());
	}

	/**
	 * Returns the first van ban phap quy in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching van ban phap quy, or <code>null</code> if a matching van ban phap quy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanPhapQuy fetchByGroupId_First(long groupId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<VanBanPhapQuy> list = findByGroupId(groupId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last van ban phap quy in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching van ban phap quy
	 * @throws com.dtt.portal.dao.vbpq.NoSuchVanBanPhapQuyException if a matching van ban phap quy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanPhapQuy findByGroupId_Last(long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchVanBanPhapQuyException, SystemException {
		VanBanPhapQuy vanBanPhapQuy = fetchByGroupId_Last(groupId, status,
				orderByComparator);

		if (vanBanPhapQuy != null) {
			return vanBanPhapQuy;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVanBanPhapQuyException(msg.toString());
	}

	/**
	 * Returns the last van ban phap quy in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching van ban phap quy, or <code>null</code> if a matching van ban phap quy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanPhapQuy fetchByGroupId_Last(long groupId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId, status);

		if (count == 0) {
			return null;
		}

		List<VanBanPhapQuy> list = findByGroupId(groupId, status, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the van ban phap quies before and after the current van ban phap quy in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param id the primary key of the current van ban phap quy
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next van ban phap quy
	 * @throws com.dtt.portal.dao.vbpq.NoSuchVanBanPhapQuyException if a van ban phap quy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanPhapQuy[] findByGroupId_PrevAndNext(long id, long groupId,
		int status, OrderByComparator orderByComparator)
		throws NoSuchVanBanPhapQuyException, SystemException {
		VanBanPhapQuy vanBanPhapQuy = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VanBanPhapQuy[] array = new VanBanPhapQuyImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, vanBanPhapQuy,
					groupId, status, orderByComparator, true);

			array[1] = vanBanPhapQuy;

			array[2] = getByGroupId_PrevAndNext(session, vanBanPhapQuy,
					groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VanBanPhapQuy getByGroupId_PrevAndNext(Session session,
		VanBanPhapQuy vanBanPhapQuy, long groupId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VANBANPHAPQUY_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPID_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(VanBanPhapQuyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vanBanPhapQuy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VanBanPhapQuy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the van ban phap quies where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId, int status)
		throws SystemException {
		for (VanBanPhapQuy vanBanPhapQuy : findByGroupId(groupId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vanBanPhapQuy);
		}
	}

	/**
	 * Returns the number of van ban phap quies where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching van ban phap quies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId, int status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VANBANPHAPQUY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPID_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "vanBanPhapQuy.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPID_STATUS_2 = "vanBanPhapQuy.status = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_GROUPID_MAVANBAN = new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
			VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED,
			VanBanPhapQuyImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByGroupId_MaVanBan",
			new String[] { Long.class.getName(), String.class.getName() },
			VanBanPhapQuyModelImpl.GROUPID_COLUMN_BITMASK |
			VanBanPhapQuyModelImpl.MAVANBAN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID_MAVANBAN = new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
			VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupId_MaVanBan",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the van ban phap quy where groupId = &#63; and maVanBan = &#63; or throws a {@link com.dtt.portal.dao.vbpq.NoSuchVanBanPhapQuyException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param maVanBan the ma van ban
	 * @return the matching van ban phap quy
	 * @throws com.dtt.portal.dao.vbpq.NoSuchVanBanPhapQuyException if a matching van ban phap quy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanPhapQuy findByGroupId_MaVanBan(long groupId, String maVanBan)
		throws NoSuchVanBanPhapQuyException, SystemException {
		VanBanPhapQuy vanBanPhapQuy = fetchByGroupId_MaVanBan(groupId, maVanBan);

		if (vanBanPhapQuy == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", maVanBan=");
			msg.append(maVanBan);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchVanBanPhapQuyException(msg.toString());
		}

		return vanBanPhapQuy;
	}

	/**
	 * Returns the van ban phap quy where groupId = &#63; and maVanBan = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param maVanBan the ma van ban
	 * @return the matching van ban phap quy, or <code>null</code> if a matching van ban phap quy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanPhapQuy fetchByGroupId_MaVanBan(long groupId, String maVanBan)
		throws SystemException {
		return fetchByGroupId_MaVanBan(groupId, maVanBan, true);
	}

	/**
	 * Returns the van ban phap quy where groupId = &#63; and maVanBan = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param maVanBan the ma van ban
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching van ban phap quy, or <code>null</code> if a matching van ban phap quy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanPhapQuy fetchByGroupId_MaVanBan(long groupId, String maVanBan,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, maVanBan };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GROUPID_MAVANBAN,
					finderArgs, this);
		}

		if (result instanceof VanBanPhapQuy) {
			VanBanPhapQuy vanBanPhapQuy = (VanBanPhapQuy)result;

			if ((groupId != vanBanPhapQuy.getGroupId()) ||
					!Validator.equals(maVanBan, vanBanPhapQuy.getMaVanBan())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_VANBANPHAPQUY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_MAVANBAN_GROUPID_2);

			boolean bindMaVanBan = false;

			if (maVanBan == null) {
				query.append(_FINDER_COLUMN_GROUPID_MAVANBAN_MAVANBAN_1);
			}
			else if (maVanBan.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPID_MAVANBAN_MAVANBAN_3);
			}
			else {
				bindMaVanBan = true;

				query.append(_FINDER_COLUMN_GROUPID_MAVANBAN_MAVANBAN_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindMaVanBan) {
					qPos.add(maVanBan);
				}

				List<VanBanPhapQuy> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_MAVANBAN,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"VanBanPhapQuyPersistenceImpl.fetchByGroupId_MaVanBan(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					VanBanPhapQuy vanBanPhapQuy = list.get(0);

					result = vanBanPhapQuy;

					cacheResult(vanBanPhapQuy);

					if ((vanBanPhapQuy.getGroupId() != groupId) ||
							(vanBanPhapQuy.getMaVanBan() == null) ||
							!vanBanPhapQuy.getMaVanBan().equals(maVanBan)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_MAVANBAN,
							finderArgs, vanBanPhapQuy);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID_MAVANBAN,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (VanBanPhapQuy)result;
		}
	}

	/**
	 * Removes the van ban phap quy where groupId = &#63; and maVanBan = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param maVanBan the ma van ban
	 * @return the van ban phap quy that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanPhapQuy removeByGroupId_MaVanBan(long groupId, String maVanBan)
		throws NoSuchVanBanPhapQuyException, SystemException {
		VanBanPhapQuy vanBanPhapQuy = findByGroupId_MaVanBan(groupId, maVanBan);

		return remove(vanBanPhapQuy);
	}

	/**
	 * Returns the number of van ban phap quies where groupId = &#63; and maVanBan = &#63;.
	 *
	 * @param groupId the group ID
	 * @param maVanBan the ma van ban
	 * @return the number of matching van ban phap quies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId_MaVanBan(long groupId, String maVanBan)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID_MAVANBAN;

		Object[] finderArgs = new Object[] { groupId, maVanBan };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VANBANPHAPQUY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_MAVANBAN_GROUPID_2);

			boolean bindMaVanBan = false;

			if (maVanBan == null) {
				query.append(_FINDER_COLUMN_GROUPID_MAVANBAN_MAVANBAN_1);
			}
			else if (maVanBan.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPID_MAVANBAN_MAVANBAN_3);
			}
			else {
				bindMaVanBan = true;

				query.append(_FINDER_COLUMN_GROUPID_MAVANBAN_MAVANBAN_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindMaVanBan) {
					qPos.add(maVanBan);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_MAVANBAN_GROUPID_2 = "vanBanPhapQuy.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPID_MAVANBAN_MAVANBAN_1 = "vanBanPhapQuy.maVanBan IS NULL";
	private static final String _FINDER_COLUMN_GROUPID_MAVANBAN_MAVANBAN_2 = "vanBanPhapQuy.maVanBan = ?";
	private static final String _FINDER_COLUMN_GROUPID_MAVANBAN_MAVANBAN_3 = "(vanBanPhapQuy.maVanBan IS NULL OR vanBanPhapQuy.maVanBan = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
			VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED,
			VanBanPhapQuyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStatus",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
			VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED,
			VanBanPhapQuyImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByStatus", new String[] { Integer.class.getName() },
			VanBanPhapQuyModelImpl.STATUS_COLUMN_BITMASK |
			VanBanPhapQuyModelImpl.NGAYBANHANH_COLUMN_BITMASK |
			VanBanPhapQuyModelImpl.NGAYCOHIEULUC_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
			VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the van ban phap quies where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching van ban phap quies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VanBanPhapQuy> findByStatus(int status)
		throws SystemException {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the van ban phap quies where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dtt.portal.dao.vbpq.model.impl.VanBanPhapQuyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of van ban phap quies
	 * @param end the upper bound of the range of van ban phap quies (not inclusive)
	 * @return the range of matching van ban phap quies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VanBanPhapQuy> findByStatus(int status, int start, int end)
		throws SystemException {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the van ban phap quies where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dtt.portal.dao.vbpq.model.impl.VanBanPhapQuyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of van ban phap quies
	 * @param end the upper bound of the range of van ban phap quies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching van ban phap quies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VanBanPhapQuy> findByStatus(int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<VanBanPhapQuy> list = (List<VanBanPhapQuy>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VanBanPhapQuy vanBanPhapQuy : list) {
				if ((status != vanBanPhapQuy.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VANBANPHAPQUY_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VanBanPhapQuyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (!pagination) {
					list = (List<VanBanPhapQuy>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VanBanPhapQuy>(list);
				}
				else {
					list = (List<VanBanPhapQuy>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first van ban phap quy in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching van ban phap quy
	 * @throws com.dtt.portal.dao.vbpq.NoSuchVanBanPhapQuyException if a matching van ban phap quy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanPhapQuy findByStatus_First(int status,
		OrderByComparator orderByComparator)
		throws NoSuchVanBanPhapQuyException, SystemException {
		VanBanPhapQuy vanBanPhapQuy = fetchByStatus_First(status,
				orderByComparator);

		if (vanBanPhapQuy != null) {
			return vanBanPhapQuy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVanBanPhapQuyException(msg.toString());
	}

	/**
	 * Returns the first van ban phap quy in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching van ban phap quy, or <code>null</code> if a matching van ban phap quy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanPhapQuy fetchByStatus_First(int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<VanBanPhapQuy> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last van ban phap quy in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching van ban phap quy
	 * @throws com.dtt.portal.dao.vbpq.NoSuchVanBanPhapQuyException if a matching van ban phap quy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanPhapQuy findByStatus_Last(int status,
		OrderByComparator orderByComparator)
		throws NoSuchVanBanPhapQuyException, SystemException {
		VanBanPhapQuy vanBanPhapQuy = fetchByStatus_Last(status,
				orderByComparator);

		if (vanBanPhapQuy != null) {
			return vanBanPhapQuy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVanBanPhapQuyException(msg.toString());
	}

	/**
	 * Returns the last van ban phap quy in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching van ban phap quy, or <code>null</code> if a matching van ban phap quy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanPhapQuy fetchByStatus_Last(int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<VanBanPhapQuy> list = findByStatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the van ban phap quies before and after the current van ban phap quy in the ordered set where status = &#63;.
	 *
	 * @param id the primary key of the current van ban phap quy
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next van ban phap quy
	 * @throws com.dtt.portal.dao.vbpq.NoSuchVanBanPhapQuyException if a van ban phap quy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanPhapQuy[] findByStatus_PrevAndNext(long id, int status,
		OrderByComparator orderByComparator)
		throws NoSuchVanBanPhapQuyException, SystemException {
		VanBanPhapQuy vanBanPhapQuy = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VanBanPhapQuy[] array = new VanBanPhapQuyImpl[3];

			array[0] = getByStatus_PrevAndNext(session, vanBanPhapQuy, status,
					orderByComparator, true);

			array[1] = vanBanPhapQuy;

			array[2] = getByStatus_PrevAndNext(session, vanBanPhapQuy, status,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VanBanPhapQuy getByStatus_PrevAndNext(Session session,
		VanBanPhapQuy vanBanPhapQuy, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VANBANPHAPQUY_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(VanBanPhapQuyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vanBanPhapQuy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VanBanPhapQuy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the van ban phap quies where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStatus(int status) throws SystemException {
		for (VanBanPhapQuy vanBanPhapQuy : findByStatus(status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vanBanPhapQuy);
		}
	}

	/**
	 * Returns the number of van ban phap quies where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching van ban phap quies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStatus(int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VANBANPHAPQUY_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "vanBanPhapQuy.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_CQBH_S = new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
			VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED,
			VanBanPhapQuyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByG_CQBH_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CQBH_S =
		new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
			VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED,
			VanBanPhapQuyImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByG_CQBH_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			VanBanPhapQuyModelImpl.GROUPID_COLUMN_BITMASK |
			VanBanPhapQuyModelImpl.COQUANBANHANH_COLUMN_BITMASK |
			VanBanPhapQuyModelImpl.STATUS_COLUMN_BITMASK |
			VanBanPhapQuyModelImpl.NGAYBANHANH_COLUMN_BITMASK |
			VanBanPhapQuyModelImpl.NGAYCOHIEULUC_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_CQBH_S = new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
			VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_CQBH_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the van ban phap quies where groupId = &#63; and coQuanBanHanh = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param coQuanBanHanh the co quan ban hanh
	 * @param status the status
	 * @return the matching van ban phap quies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VanBanPhapQuy> findByG_CQBH_S(long groupId, long coQuanBanHanh,
		int status) throws SystemException {
		return findByG_CQBH_S(groupId, coQuanBanHanh, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the van ban phap quies where groupId = &#63; and coQuanBanHanh = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dtt.portal.dao.vbpq.model.impl.VanBanPhapQuyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param coQuanBanHanh the co quan ban hanh
	 * @param status the status
	 * @param start the lower bound of the range of van ban phap quies
	 * @param end the upper bound of the range of van ban phap quies (not inclusive)
	 * @return the range of matching van ban phap quies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VanBanPhapQuy> findByG_CQBH_S(long groupId, long coQuanBanHanh,
		int status, int start, int end) throws SystemException {
		return findByG_CQBH_S(groupId, coQuanBanHanh, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the van ban phap quies where groupId = &#63; and coQuanBanHanh = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dtt.portal.dao.vbpq.model.impl.VanBanPhapQuyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param coQuanBanHanh the co quan ban hanh
	 * @param status the status
	 * @param start the lower bound of the range of van ban phap quies
	 * @param end the upper bound of the range of van ban phap quies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching van ban phap quies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VanBanPhapQuy> findByG_CQBH_S(long groupId, long coQuanBanHanh,
		int status, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CQBH_S;
			finderArgs = new Object[] { groupId, coQuanBanHanh, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_CQBH_S;
			finderArgs = new Object[] {
					groupId, coQuanBanHanh, status,
					
					start, end, orderByComparator
				};
		}

		List<VanBanPhapQuy> list = (List<VanBanPhapQuy>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VanBanPhapQuy vanBanPhapQuy : list) {
				if ((groupId != vanBanPhapQuy.getGroupId()) ||
						(coQuanBanHanh != vanBanPhapQuy.getCoQuanBanHanh()) ||
						(status != vanBanPhapQuy.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_VANBANPHAPQUY_WHERE);

			query.append(_FINDER_COLUMN_G_CQBH_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_CQBH_S_COQUANBANHANH_2);

			query.append(_FINDER_COLUMN_G_CQBH_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VanBanPhapQuyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(coQuanBanHanh);

				qPos.add(status);

				if (!pagination) {
					list = (List<VanBanPhapQuy>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VanBanPhapQuy>(list);
				}
				else {
					list = (List<VanBanPhapQuy>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first van ban phap quy in the ordered set where groupId = &#63; and coQuanBanHanh = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param coQuanBanHanh the co quan ban hanh
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching van ban phap quy
	 * @throws com.dtt.portal.dao.vbpq.NoSuchVanBanPhapQuyException if a matching van ban phap quy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanPhapQuy findByG_CQBH_S_First(long groupId, long coQuanBanHanh,
		int status, OrderByComparator orderByComparator)
		throws NoSuchVanBanPhapQuyException, SystemException {
		VanBanPhapQuy vanBanPhapQuy = fetchByG_CQBH_S_First(groupId,
				coQuanBanHanh, status, orderByComparator);

		if (vanBanPhapQuy != null) {
			return vanBanPhapQuy;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", coQuanBanHanh=");
		msg.append(coQuanBanHanh);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVanBanPhapQuyException(msg.toString());
	}

	/**
	 * Returns the first van ban phap quy in the ordered set where groupId = &#63; and coQuanBanHanh = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param coQuanBanHanh the co quan ban hanh
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching van ban phap quy, or <code>null</code> if a matching van ban phap quy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanPhapQuy fetchByG_CQBH_S_First(long groupId,
		long coQuanBanHanh, int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<VanBanPhapQuy> list = findByG_CQBH_S(groupId, coQuanBanHanh,
				status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last van ban phap quy in the ordered set where groupId = &#63; and coQuanBanHanh = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param coQuanBanHanh the co quan ban hanh
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching van ban phap quy
	 * @throws com.dtt.portal.dao.vbpq.NoSuchVanBanPhapQuyException if a matching van ban phap quy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanPhapQuy findByG_CQBH_S_Last(long groupId, long coQuanBanHanh,
		int status, OrderByComparator orderByComparator)
		throws NoSuchVanBanPhapQuyException, SystemException {
		VanBanPhapQuy vanBanPhapQuy = fetchByG_CQBH_S_Last(groupId,
				coQuanBanHanh, status, orderByComparator);

		if (vanBanPhapQuy != null) {
			return vanBanPhapQuy;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", coQuanBanHanh=");
		msg.append(coQuanBanHanh);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVanBanPhapQuyException(msg.toString());
	}

	/**
	 * Returns the last van ban phap quy in the ordered set where groupId = &#63; and coQuanBanHanh = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param coQuanBanHanh the co quan ban hanh
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching van ban phap quy, or <code>null</code> if a matching van ban phap quy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanPhapQuy fetchByG_CQBH_S_Last(long groupId, long coQuanBanHanh,
		int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByG_CQBH_S(groupId, coQuanBanHanh, status);

		if (count == 0) {
			return null;
		}

		List<VanBanPhapQuy> list = findByG_CQBH_S(groupId, coQuanBanHanh,
				status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the van ban phap quies before and after the current van ban phap quy in the ordered set where groupId = &#63; and coQuanBanHanh = &#63; and status = &#63;.
	 *
	 * @param id the primary key of the current van ban phap quy
	 * @param groupId the group ID
	 * @param coQuanBanHanh the co quan ban hanh
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next van ban phap quy
	 * @throws com.dtt.portal.dao.vbpq.NoSuchVanBanPhapQuyException if a van ban phap quy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanPhapQuy[] findByG_CQBH_S_PrevAndNext(long id, long groupId,
		long coQuanBanHanh, int status, OrderByComparator orderByComparator)
		throws NoSuchVanBanPhapQuyException, SystemException {
		VanBanPhapQuy vanBanPhapQuy = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VanBanPhapQuy[] array = new VanBanPhapQuyImpl[3];

			array[0] = getByG_CQBH_S_PrevAndNext(session, vanBanPhapQuy,
					groupId, coQuanBanHanh, status, orderByComparator, true);

			array[1] = vanBanPhapQuy;

			array[2] = getByG_CQBH_S_PrevAndNext(session, vanBanPhapQuy,
					groupId, coQuanBanHanh, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VanBanPhapQuy getByG_CQBH_S_PrevAndNext(Session session,
		VanBanPhapQuy vanBanPhapQuy, long groupId, long coQuanBanHanh,
		int status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VANBANPHAPQUY_WHERE);

		query.append(_FINDER_COLUMN_G_CQBH_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_CQBH_S_COQUANBANHANH_2);

		query.append(_FINDER_COLUMN_G_CQBH_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(VanBanPhapQuyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(coQuanBanHanh);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vanBanPhapQuy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VanBanPhapQuy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the van ban phap quies where groupId = &#63; and coQuanBanHanh = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param coQuanBanHanh the co quan ban hanh
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_CQBH_S(long groupId, long coQuanBanHanh, int status)
		throws SystemException {
		for (VanBanPhapQuy vanBanPhapQuy : findByG_CQBH_S(groupId,
				coQuanBanHanh, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(vanBanPhapQuy);
		}
	}

	/**
	 * Returns the number of van ban phap quies where groupId = &#63; and coQuanBanHanh = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param coQuanBanHanh the co quan ban hanh
	 * @param status the status
	 * @return the number of matching van ban phap quies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_CQBH_S(long groupId, long coQuanBanHanh, int status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_CQBH_S;

		Object[] finderArgs = new Object[] { groupId, coQuanBanHanh, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_VANBANPHAPQUY_WHERE);

			query.append(_FINDER_COLUMN_G_CQBH_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_CQBH_S_COQUANBANHANH_2);

			query.append(_FINDER_COLUMN_G_CQBH_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(coQuanBanHanh);

				qPos.add(status);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_CQBH_S_GROUPID_2 = "vanBanPhapQuy.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_CQBH_S_COQUANBANHANH_2 = "vanBanPhapQuy.coQuanBanHanh = ? AND ";
	private static final String _FINDER_COLUMN_G_CQBH_S_STATUS_2 = "vanBanPhapQuy.status = ?";

	public VanBanPhapQuyPersistenceImpl() {
		setModelClass(VanBanPhapQuy.class);
	}

	/**
	 * Caches the van ban phap quy in the entity cache if it is enabled.
	 *
	 * @param vanBanPhapQuy the van ban phap quy
	 */
	@Override
	public void cacheResult(VanBanPhapQuy vanBanPhapQuy) {
		EntityCacheUtil.putResult(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
			VanBanPhapQuyImpl.class, vanBanPhapQuy.getPrimaryKey(),
			vanBanPhapQuy);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_MAVANBAN,
			new Object[] { vanBanPhapQuy.getGroupId(), vanBanPhapQuy.getMaVanBan() },
			vanBanPhapQuy);

		vanBanPhapQuy.resetOriginalValues();
	}

	/**
	 * Caches the van ban phap quies in the entity cache if it is enabled.
	 *
	 * @param vanBanPhapQuies the van ban phap quies
	 */
	@Override
	public void cacheResult(List<VanBanPhapQuy> vanBanPhapQuies) {
		for (VanBanPhapQuy vanBanPhapQuy : vanBanPhapQuies) {
			if (EntityCacheUtil.getResult(
						VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
						VanBanPhapQuyImpl.class, vanBanPhapQuy.getPrimaryKey()) == null) {
				cacheResult(vanBanPhapQuy);
			}
			else {
				vanBanPhapQuy.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all van ban phap quies.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VanBanPhapQuyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VanBanPhapQuyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the van ban phap quy.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VanBanPhapQuy vanBanPhapQuy) {
		EntityCacheUtil.removeResult(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
			VanBanPhapQuyImpl.class, vanBanPhapQuy.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(vanBanPhapQuy);
	}

	@Override
	public void clearCache(List<VanBanPhapQuy> vanBanPhapQuies) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VanBanPhapQuy vanBanPhapQuy : vanBanPhapQuies) {
			EntityCacheUtil.removeResult(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
				VanBanPhapQuyImpl.class, vanBanPhapQuy.getPrimaryKey());

			clearUniqueFindersCache(vanBanPhapQuy);
		}
	}

	protected void cacheUniqueFindersCache(VanBanPhapQuy vanBanPhapQuy) {
		if (vanBanPhapQuy.isNew()) {
			Object[] args = new Object[] {
					vanBanPhapQuy.getGroupId(), vanBanPhapQuy.getMaVanBan()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID_MAVANBAN,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_MAVANBAN,
				args, vanBanPhapQuy);
		}
		else {
			VanBanPhapQuyModelImpl vanBanPhapQuyModelImpl = (VanBanPhapQuyModelImpl)vanBanPhapQuy;

			if ((vanBanPhapQuyModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GROUPID_MAVANBAN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vanBanPhapQuy.getGroupId(), vanBanPhapQuy.getMaVanBan()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID_MAVANBAN,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID_MAVANBAN,
					args, vanBanPhapQuy);
			}
		}
	}

	protected void clearUniqueFindersCache(VanBanPhapQuy vanBanPhapQuy) {
		VanBanPhapQuyModelImpl vanBanPhapQuyModelImpl = (VanBanPhapQuyModelImpl)vanBanPhapQuy;

		Object[] args = new Object[] {
				vanBanPhapQuy.getGroupId(), vanBanPhapQuy.getMaVanBan()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_MAVANBAN, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID_MAVANBAN, args);

		if ((vanBanPhapQuyModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GROUPID_MAVANBAN.getColumnBitmask()) != 0) {
			args = new Object[] {
					vanBanPhapQuyModelImpl.getOriginalGroupId(),
					vanBanPhapQuyModelImpl.getOriginalMaVanBan()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID_MAVANBAN,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID_MAVANBAN,
				args);
		}
	}

	/**
	 * Creates a new van ban phap quy with the primary key. Does not add the van ban phap quy to the database.
	 *
	 * @param id the primary key for the new van ban phap quy
	 * @return the new van ban phap quy
	 */
	@Override
	public VanBanPhapQuy create(long id) {
		VanBanPhapQuy vanBanPhapQuy = new VanBanPhapQuyImpl();

		vanBanPhapQuy.setNew(true);
		vanBanPhapQuy.setPrimaryKey(id);

		return vanBanPhapQuy;
	}

	/**
	 * Removes the van ban phap quy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the van ban phap quy
	 * @return the van ban phap quy that was removed
	 * @throws com.dtt.portal.dao.vbpq.NoSuchVanBanPhapQuyException if a van ban phap quy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanPhapQuy remove(long id)
		throws NoSuchVanBanPhapQuyException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the van ban phap quy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the van ban phap quy
	 * @return the van ban phap quy that was removed
	 * @throws com.dtt.portal.dao.vbpq.NoSuchVanBanPhapQuyException if a van ban phap quy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanPhapQuy remove(Serializable primaryKey)
		throws NoSuchVanBanPhapQuyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VanBanPhapQuy vanBanPhapQuy = (VanBanPhapQuy)session.get(VanBanPhapQuyImpl.class,
					primaryKey);

			if (vanBanPhapQuy == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVanBanPhapQuyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vanBanPhapQuy);
		}
		catch (NoSuchVanBanPhapQuyException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected VanBanPhapQuy removeImpl(VanBanPhapQuy vanBanPhapQuy)
		throws SystemException {
		vanBanPhapQuy = toUnwrappedModel(vanBanPhapQuy);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vanBanPhapQuy)) {
				vanBanPhapQuy = (VanBanPhapQuy)session.get(VanBanPhapQuyImpl.class,
						vanBanPhapQuy.getPrimaryKeyObj());
			}

			if (vanBanPhapQuy != null) {
				session.delete(vanBanPhapQuy);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vanBanPhapQuy != null) {
			clearCache(vanBanPhapQuy);
		}

		return vanBanPhapQuy;
	}

	@Override
	public VanBanPhapQuy updateImpl(
		com.dtt.portal.dao.vbpq.model.VanBanPhapQuy vanBanPhapQuy)
		throws SystemException {
		vanBanPhapQuy = toUnwrappedModel(vanBanPhapQuy);

		boolean isNew = vanBanPhapQuy.isNew();

		VanBanPhapQuyModelImpl vanBanPhapQuyModelImpl = (VanBanPhapQuyModelImpl)vanBanPhapQuy;

		Session session = null;

		try {
			session = openSession();

			if (vanBanPhapQuy.isNew()) {
				session.save(vanBanPhapQuy);

				vanBanPhapQuy.setNew(false);
			}
			else {
				session.merge(vanBanPhapQuy);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VanBanPhapQuyModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vanBanPhapQuyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vanBanPhapQuyModelImpl.getOriginalGroupId(),
						vanBanPhapQuyModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] {
						vanBanPhapQuyModelImpl.getGroupId(),
						vanBanPhapQuyModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((vanBanPhapQuyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vanBanPhapQuyModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { vanBanPhapQuyModelImpl.getStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}

			if ((vanBanPhapQuyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CQBH_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vanBanPhapQuyModelImpl.getOriginalGroupId(),
						vanBanPhapQuyModelImpl.getOriginalCoQuanBanHanh(),
						vanBanPhapQuyModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_CQBH_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CQBH_S,
					args);

				args = new Object[] {
						vanBanPhapQuyModelImpl.getGroupId(),
						vanBanPhapQuyModelImpl.getCoQuanBanHanh(),
						vanBanPhapQuyModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_CQBH_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_CQBH_S,
					args);
			}
		}

		EntityCacheUtil.putResult(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
			VanBanPhapQuyImpl.class, vanBanPhapQuy.getPrimaryKey(),
			vanBanPhapQuy);

		clearUniqueFindersCache(vanBanPhapQuy);
		cacheUniqueFindersCache(vanBanPhapQuy);

		return vanBanPhapQuy;
	}

	protected VanBanPhapQuy toUnwrappedModel(VanBanPhapQuy vanBanPhapQuy) {
		if (vanBanPhapQuy instanceof VanBanPhapQuyImpl) {
			return vanBanPhapQuy;
		}

		VanBanPhapQuyImpl vanBanPhapQuyImpl = new VanBanPhapQuyImpl();

		vanBanPhapQuyImpl.setNew(vanBanPhapQuy.isNew());
		vanBanPhapQuyImpl.setPrimaryKey(vanBanPhapQuy.getPrimaryKey());

		vanBanPhapQuyImpl.setId(vanBanPhapQuy.getId());
		vanBanPhapQuyImpl.setMaVanBan(vanBanPhapQuy.getMaVanBan());
		vanBanPhapQuyImpl.setNgayTao(vanBanPhapQuy.getNgayTao());
		vanBanPhapQuyImpl.setNgaySua(vanBanPhapQuy.getNgaySua());
		vanBanPhapQuyImpl.setNguoiTao(vanBanPhapQuy.getNguoiTao());
		vanBanPhapQuyImpl.setNguoiSua(vanBanPhapQuy.getNguoiSua());
		vanBanPhapQuyImpl.setTrichYeu(vanBanPhapQuy.getTrichYeu());
		vanBanPhapQuyImpl.setCoQuanBanHanh(vanBanPhapQuy.getCoQuanBanHanh());
		vanBanPhapQuyImpl.setLoaiVanBan(vanBanPhapQuy.getLoaiVanBan());
		vanBanPhapQuyImpl.setLinhVucVanBan(vanBanPhapQuy.getLinhVucVanBan());
		vanBanPhapQuyImpl.setNgayBanHanh(vanBanPhapQuy.getNgayBanHanh());
		vanBanPhapQuyImpl.setNgayCoHieuLuc(vanBanPhapQuy.getNgayCoHieuLuc());
		vanBanPhapQuyImpl.setNgayHetHieuLuc(vanBanPhapQuy.getNgayHetHieuLuc());
		vanBanPhapQuyImpl.setNguoiKy(vanBanPhapQuy.getNguoiKy());
		vanBanPhapQuyImpl.setVanBanThayThe(vanBanPhapQuy.getVanBanThayThe());
		vanBanPhapQuyImpl.setGroupId(vanBanPhapQuy.getGroupId());
		vanBanPhapQuyImpl.setStatus(vanBanPhapQuy.getStatus());
		vanBanPhapQuyImpl.setStatusByDate(vanBanPhapQuy.getStatusByDate());
		vanBanPhapQuyImpl.setStatusByUserId(vanBanPhapQuy.getStatusByUserId());
		vanBanPhapQuyImpl.setStatusByUserName(vanBanPhapQuy.getStatusByUserName());

		return vanBanPhapQuyImpl;
	}

	/**
	 * Returns the van ban phap quy with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the van ban phap quy
	 * @return the van ban phap quy
	 * @throws com.dtt.portal.dao.vbpq.NoSuchVanBanPhapQuyException if a van ban phap quy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanPhapQuy findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVanBanPhapQuyException, SystemException {
		VanBanPhapQuy vanBanPhapQuy = fetchByPrimaryKey(primaryKey);

		if (vanBanPhapQuy == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVanBanPhapQuyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vanBanPhapQuy;
	}

	/**
	 * Returns the van ban phap quy with the primary key or throws a {@link com.dtt.portal.dao.vbpq.NoSuchVanBanPhapQuyException} if it could not be found.
	 *
	 * @param id the primary key of the van ban phap quy
	 * @return the van ban phap quy
	 * @throws com.dtt.portal.dao.vbpq.NoSuchVanBanPhapQuyException if a van ban phap quy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanPhapQuy findByPrimaryKey(long id)
		throws NoSuchVanBanPhapQuyException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the van ban phap quy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the van ban phap quy
	 * @return the van ban phap quy, or <code>null</code> if a van ban phap quy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanPhapQuy fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VanBanPhapQuy vanBanPhapQuy = (VanBanPhapQuy)EntityCacheUtil.getResult(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
				VanBanPhapQuyImpl.class, primaryKey);

		if (vanBanPhapQuy == _nullVanBanPhapQuy) {
			return null;
		}

		if (vanBanPhapQuy == null) {
			Session session = null;

			try {
				session = openSession();

				vanBanPhapQuy = (VanBanPhapQuy)session.get(VanBanPhapQuyImpl.class,
						primaryKey);

				if (vanBanPhapQuy != null) {
					cacheResult(vanBanPhapQuy);
				}
				else {
					EntityCacheUtil.putResult(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
						VanBanPhapQuyImpl.class, primaryKey, _nullVanBanPhapQuy);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
					VanBanPhapQuyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vanBanPhapQuy;
	}

	/**
	 * Returns the van ban phap quy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the van ban phap quy
	 * @return the van ban phap quy, or <code>null</code> if a van ban phap quy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VanBanPhapQuy fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the van ban phap quies.
	 *
	 * @return the van ban phap quies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VanBanPhapQuy> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the van ban phap quies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dtt.portal.dao.vbpq.model.impl.VanBanPhapQuyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of van ban phap quies
	 * @param end the upper bound of the range of van ban phap quies (not inclusive)
	 * @return the range of van ban phap quies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VanBanPhapQuy> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the van ban phap quies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dtt.portal.dao.vbpq.model.impl.VanBanPhapQuyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of van ban phap quies
	 * @param end the upper bound of the range of van ban phap quies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of van ban phap quies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VanBanPhapQuy> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<VanBanPhapQuy> list = (List<VanBanPhapQuy>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VANBANPHAPQUY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VANBANPHAPQUY;

				if (pagination) {
					sql = sql.concat(VanBanPhapQuyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VanBanPhapQuy>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VanBanPhapQuy>(list);
				}
				else {
					list = (List<VanBanPhapQuy>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the van ban phap quies from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VanBanPhapQuy vanBanPhapQuy : findAll()) {
			remove(vanBanPhapQuy);
		}
	}

	/**
	 * Returns the number of van ban phap quies.
	 *
	 * @return the number of van ban phap quies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VANBANPHAPQUY);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the van ban phap quy persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.dtt.portal.dao.vbpq.model.VanBanPhapQuy")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VanBanPhapQuy>> listenersList = new ArrayList<ModelListener<VanBanPhapQuy>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VanBanPhapQuy>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(VanBanPhapQuyImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VANBANPHAPQUY = "SELECT vanBanPhapQuy FROM VanBanPhapQuy vanBanPhapQuy";
	private static final String _SQL_SELECT_VANBANPHAPQUY_WHERE = "SELECT vanBanPhapQuy FROM VanBanPhapQuy vanBanPhapQuy WHERE ";
	private static final String _SQL_COUNT_VANBANPHAPQUY = "SELECT COUNT(vanBanPhapQuy) FROM VanBanPhapQuy vanBanPhapQuy";
	private static final String _SQL_COUNT_VANBANPHAPQUY_WHERE = "SELECT COUNT(vanBanPhapQuy) FROM VanBanPhapQuy vanBanPhapQuy WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vanBanPhapQuy.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VanBanPhapQuy exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VanBanPhapQuy exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VanBanPhapQuyPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id", "maVanBan", "ngayTao", "ngaySua", "nguoiTao", "nguoiSua",
				"trichYeu", "coQuanBanHanh", "loaiVanBan", "linhVucVanBan",
				"ngayBanHanh", "ngayCoHieuLuc", "ngayHetHieuLuc", "nguoiKy",
				"vanBanThayThe", "groupId", "status", "statusByDate",
				"statusByUserId", "statusByUserName"
			});
	private static VanBanPhapQuy _nullVanBanPhapQuy = new VanBanPhapQuyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VanBanPhapQuy> toCacheModel() {
				return _nullVanBanPhapQuyCacheModel;
			}
		};

	private static CacheModel<VanBanPhapQuy> _nullVanBanPhapQuyCacheModel = new CacheModel<VanBanPhapQuy>() {
			@Override
			public VanBanPhapQuy toEntityModel() {
				return _nullVanBanPhapQuy;
			}
		};
}