package com.dtt.portal.dao.vbpq.service.persistence;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.dtt.portal.dao.vbpq.model.VanBanPhapQuy;
import com.dtt.portal.dao.vbpq.model.impl.VanBanPhapQuyImpl;

public class VanBanPhapQuyFinderImpl extends BasePersistenceImpl<VanBanPhapQuy>
		implements VanBanPhapQuyFinder {
	
	public static final String FINDER_SQL = VanBanPhapQuyFinder.class.getName()
		+ ".finder";

	public static final String COUNT_SQL = VanBanPhapQuyFinder.class.getName()
		+ ".count";

	public int count(String keyword, long groupId, long[] loaiVanBanIds,
			long[] linhVucVanBanIds, long[] coQuanBanHanhIds, Integer status,
			Date startDateObj, Date endDateObj) 
		throws SystemException {
		
		String[] keywords = _getKeywords(keyword);
		boolean andOperator = false;

		if (Validator.isNull(keyword)) {
			andOperator = true;
		}

		return countBy_K(keywords, groupId, loaiVanBanIds, linhVucVanBanIds, coQuanBanHanhIds, 
				status, startDateObj, endDateObj, andOperator);
	}

	public List<VanBanPhapQuy> find(String keyword, long groupId,
			long[] loaiVanBanIds, long[] linhVucVanBanIds,
			long[] coQuanBanHanhIds, Integer status, Date startDateObj,
			Date endDateObj, int start, int end, OrderByComparator obc)
		throws SystemException {
		
		String[] keywords = _getKeywords(keyword);
		boolean andOperator = false;

		if (Validator.isNull(keyword)) {
			andOperator = true;
		}

		return findBy_K(keywords, groupId, loaiVanBanIds, linhVucVanBanIds, coQuanBanHanhIds,
			status, startDateObj, endDateObj, andOperator, start, end, obc);
	}
	
	private int countBy_K(String[] keywords, long groupId, long[] loaiVanBanIds, long[] linhVucVanBanIds,
			long[] coQuanBanHanhIds, Integer status,
			Date startDateObj, Date endDateObj, boolean andOperator)
		throws SystemException {
		
		Session session = null;
		
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_SQL);

			sql = CustomSQLUtil.replaceKeywords(sql, "lower(trichyeu)",
				StringPool.LIKE, true, keywords);

			sql = CustomSQLUtil.replaceKeywords(sql, "lower(nguoiky)",
				StringPool.LIKE, true, keywords);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(mavanban)",
				StringPool.LIKE, true, keywords);

			if (ArrayUtil.isEmpty(coQuanBanHanhIds)) {
				sql = StringUtil.replace(sql, "AND (coquanbanhanh IN ([$WHERE_CQBH$]))",
					StringPool.BLANK);
			} else {
				sql = StringUtil.replace(sql, "[$WHERE_CQBH$]", StringUtil.merge(coQuanBanHanhIds));
			}

			if (ArrayUtil.isEmpty(loaiVanBanIds)) {
				sql = StringUtil.replace(sql, "AND (loaivanban IN ([$WHERE_LVB$]))",
					StringPool.BLANK);
			} else {
				sql = StringUtil.replace(sql, "[$WHERE_LVB$]", StringUtil.merge(loaiVanBanIds));
			}

			if (ArrayUtil.isEmpty(linhVucVanBanIds)) {
				sql = StringUtil.replace(sql, "AND (linhvucvanban IN ([$WHERE_LVVB$]))",
					StringPool.BLANK);
			} else {
				sql = StringUtil.replace(sql, "[$WHERE_LVVB$]", StringUtil.merge(linhVucVanBanIds));
			}
			
			if(status == null) {
				sql = StringUtil.replace(sql, "AND (status = ?)",
					StringPool.BLANK);
			}
			
			if(startDateObj == null) {
				sql = StringUtil.replace(
					sql, "AND (ngaybanhanh >= ?)", StringPool.BLANK);
			}
			
			if(endDateObj == null) {
				sql = StringUtil.replace(
					sql, "AND (ngaybanhanh <= ?)", StringPool.BLANK);
			}
			
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(keywords, 2);

			qPos.add(keywords, 2);
			
			qPos.add(keywords, 2);

			
			if(status != null) {
				qPos.add(status);
			}
			
			if(startDateObj != null) {
				Timestamp startDateTS = CalendarUtil.getTimestamp(startDateObj);
				
				qPos.add(startDateTS);
			}
			
			if(endDateObj != null) {
				Timestamp endDateTS = CalendarUtil.getTimestamp(endDateObj);
				
				qPos.add(endDateTS);
			}
			
			Iterator<Long> itr = q.iterate();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	private List<VanBanPhapQuy> findBy_K(String[] keywords, long groupId,
			long[] loaiVanBanIds, long[] linhVucVanBanIds,
			long[] coQuanBanHanhIds, Integer status,
			Date startDateObj, Date endDateObj, boolean andOperator, int start, int end,
			OrderByComparator obc)
		throws SystemException {

		Session session = null;
		
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FINDER_SQL);

			sql = CustomSQLUtil.replaceKeywords(sql, "lower(trichyeu)",
					StringPool.LIKE, true, keywords);

			sql = CustomSQLUtil.replaceKeywords(sql, "lower(nguoiky)",
					StringPool.LIKE, true, keywords);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(mavanban)",
					StringPool.LIKE, true, keywords);

			if (ArrayUtil.isEmpty(coQuanBanHanhIds)) {
				sql = StringUtil.replace(sql, "AND (coquanbanhanh IN ([$WHERE_CQBH$]))",
					StringPool.BLANK);
			} else {
				sql = StringUtil.replace(sql, "[$WHERE_CQBH$]", StringUtil.merge(coQuanBanHanhIds));
			}

			if (ArrayUtil.isEmpty(loaiVanBanIds)) {
				sql = StringUtil.replace(sql, "AND (loaivanban IN ([$WHERE_LVB$]))",
					StringPool.BLANK);
			} else {
				sql = StringUtil.replace(sql, "[$WHERE_LVB$]", StringUtil.merge(loaiVanBanIds));
			}

			if (ArrayUtil.isEmpty(linhVucVanBanIds)) {
				sql = StringUtil.replace(sql, "AND (linhvucvanban IN ([$WHERE_LVVB$]))",
					StringPool.BLANK);
			} else {
				sql = StringUtil.replace(sql, "[$WHERE_LVVB$]", StringUtil.merge(linhVucVanBanIds));
			}
			
			if(status == null) {
				sql = StringUtil.replace(sql, "AND (status = ?)",
					StringPool.BLANK);
			}
			
			if(startDateObj == null) {
				sql = StringUtil.replace(
					sql, "AND (ngaybanhanh >= ?)", StringPool.BLANK);
			}
			
			if(endDateObj == null) {
				sql = StringUtil.replace(
					sql, "AND (ngaybanhanh <= ?)", StringPool.BLANK);
			}
			
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("VanBanPhapQuy", VanBanPhapQuyImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(keywords, 2);

			qPos.add(keywords, 2);
			
			qPos.add(keywords, 2);

			if(status != null) {
				qPos.add(status);
			}
			
			if(startDateObj != null) {
				Timestamp startDateTS = CalendarUtil.getTimestamp(startDateObj);
				
				qPos.add(startDateTS);
			}
			
			if(endDateObj != null) {
				Timestamp endDateTS = CalendarUtil.getTimestamp(endDateObj);
				
				qPos.add(endDateTS);
			}

			return (List<VanBanPhapQuy>) QueryUtil.list(q, getDialect(), start,
					end);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	private String[] _getKeywords(String keyword) {
		if (Validator.isNull(keyword)) {
			return new String[] {null};
		}
		
		keyword = keyword.trim();
		
		return new String[]{StringUtil.quote(StringUtil.toLowerCase(keyword), 
			StringPool.PERCENT)};
	}
}
