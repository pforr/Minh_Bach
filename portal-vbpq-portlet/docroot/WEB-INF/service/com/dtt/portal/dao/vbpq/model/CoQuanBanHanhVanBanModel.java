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

package com.dtt.portal.dao.vbpq.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the CoQuanBanHanhVanBan service. Represents a row in the &quot;EPORTAL_COQUANBANHANH&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.dtt.portal.dao.vbpq.model.impl.CoQuanBanHanhVanBanModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.dtt.portal.dao.vbpq.model.impl.CoQuanBanHanhVanBanImpl}.
 * </p>
 *
 * @author HuyMQ
 * @see CoQuanBanHanhVanBan
 * @see com.dtt.portal.dao.vbpq.model.impl.CoQuanBanHanhVanBanImpl
 * @see com.dtt.portal.dao.vbpq.model.impl.CoQuanBanHanhVanBanModelImpl
 * @generated
 */
public interface CoQuanBanHanhVanBanModel extends BaseModel<CoQuanBanHanhVanBan> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a co quan ban hanh van ban model instance should use the {@link CoQuanBanHanhVanBan} interface instead.
	 */

	/**
	 * Returns the primary key of this co quan ban hanh van ban.
	 *
	 * @return the primary key of this co quan ban hanh van ban
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this co quan ban hanh van ban.
	 *
	 * @param primaryKey the primary key of this co quan ban hanh van ban
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this co quan ban hanh van ban.
	 *
	 * @return the ID of this co quan ban hanh van ban
	 */
	public long getId();

	/**
	 * Sets the ID of this co quan ban hanh van ban.
	 *
	 * @param id the ID of this co quan ban hanh van ban
	 */
	public void setId(long id);

	/**
	 * Returns the ten of this co quan ban hanh van ban.
	 *
	 * @return the ten of this co quan ban hanh van ban
	 */
	@AutoEscape
	public String getTen();

	/**
	 * Sets the ten of this co quan ban hanh van ban.
	 *
	 * @param ten the ten of this co quan ban hanh van ban
	 */
	public void setTen(String ten);

	/**
	 * Returns the trang thai of this co quan ban hanh van ban.
	 *
	 * @return the trang thai of this co quan ban hanh van ban
	 */
	public boolean getTrangThai();

	/**
	 * Returns <code>true</code> if this co quan ban hanh van ban is trang thai.
	 *
	 * @return <code>true</code> if this co quan ban hanh van ban is trang thai; <code>false</code> otherwise
	 */
	public boolean isTrangThai();

	/**
	 * Sets whether this co quan ban hanh van ban is trang thai.
	 *
	 * @param trangThai the trang thai of this co quan ban hanh van ban
	 */
	public void setTrangThai(boolean trangThai);

	/**
	 * Returns the ngay tao of this co quan ban hanh van ban.
	 *
	 * @return the ngay tao of this co quan ban hanh van ban
	 */
	public Date getNgayTao();

	/**
	 * Sets the ngay tao of this co quan ban hanh van ban.
	 *
	 * @param ngayTao the ngay tao of this co quan ban hanh van ban
	 */
	public void setNgayTao(Date ngayTao);

	/**
	 * Returns the ngay sua of this co quan ban hanh van ban.
	 *
	 * @return the ngay sua of this co quan ban hanh van ban
	 */
	public Date getNgaySua();

	/**
	 * Sets the ngay sua of this co quan ban hanh van ban.
	 *
	 * @param ngaySua the ngay sua of this co quan ban hanh van ban
	 */
	public void setNgaySua(Date ngaySua);

	/**
	 * Returns the nguoi tao of this co quan ban hanh van ban.
	 *
	 * @return the nguoi tao of this co quan ban hanh van ban
	 */
	@AutoEscape
	public String getNguoiTao();

	/**
	 * Sets the nguoi tao of this co quan ban hanh van ban.
	 *
	 * @param nguoiTao the nguoi tao of this co quan ban hanh van ban
	 */
	public void setNguoiTao(String nguoiTao);

	/**
	 * Returns the nguoi sua of this co quan ban hanh van ban.
	 *
	 * @return the nguoi sua of this co quan ban hanh van ban
	 */
	@AutoEscape
	public String getNguoiSua();

	/**
	 * Sets the nguoi sua of this co quan ban hanh van ban.
	 *
	 * @param nguoiSua the nguoi sua of this co quan ban hanh van ban
	 */
	public void setNguoiSua(String nguoiSua);

	/**
	 * Returns the group ID of this co quan ban hanh van ban.
	 *
	 * @return the group ID of this co quan ban hanh van ban
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this co quan ban hanh van ban.
	 *
	 * @param groupId the group ID of this co quan ban hanh van ban
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the order_ of this co quan ban hanh van ban.
	 *
	 * @return the order_ of this co quan ban hanh van ban
	 */
	public int getOrder_();

	/**
	 * Sets the order_ of this co quan ban hanh van ban.
	 *
	 * @param order_ the order_ of this co quan ban hanh van ban
	 */
	public void setOrder_(int order_);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(CoQuanBanHanhVanBan coQuanBanHanhVanBan);

	@Override
	public int hashCode();

	@Override
	public CacheModel<CoQuanBanHanhVanBan> toCacheModel();

	@Override
	public CoQuanBanHanhVanBan toEscapedModel();

	@Override
	public CoQuanBanHanhVanBan toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}