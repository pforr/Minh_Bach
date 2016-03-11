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

package com.dtt.portal.dao.vbpq.model.impl;

import com.dtt.portal.dao.vbpq.model.LinhVucVanBan;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LinhVucVanBan in entity cache.
 *
 * @author HuyMQ
 * @see LinhVucVanBan
 * @generated
 */
public class LinhVucVanBanCacheModel implements CacheModel<LinhVucVanBan>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", order_=");
		sb.append(order_);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LinhVucVanBan toEntityModel() {
		LinhVucVanBanImpl linhVucVanBanImpl = new LinhVucVanBanImpl();

		linhVucVanBanImpl.setId(id);

		if (ten == null) {
			linhVucVanBanImpl.setTen(StringPool.BLANK);
		}
		else {
			linhVucVanBanImpl.setTen(ten);
		}

		linhVucVanBanImpl.setTrangThai(trangThai);

		if (ngayTao == Long.MIN_VALUE) {
			linhVucVanBanImpl.setNgayTao(null);
		}
		else {
			linhVucVanBanImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			linhVucVanBanImpl.setNgaySua(null);
		}
		else {
			linhVucVanBanImpl.setNgaySua(new Date(ngaySua));
		}

		if (nguoiTao == null) {
			linhVucVanBanImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			linhVucVanBanImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			linhVucVanBanImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			linhVucVanBanImpl.setNguoiSua(nguoiSua);
		}

		linhVucVanBanImpl.setGroupId(groupId);
		linhVucVanBanImpl.setOrder_(order_);

		linhVucVanBanImpl.resetOriginalValues();

		return linhVucVanBanImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		ten = objectInput.readUTF();
		trangThai = objectInput.readBoolean();
		ngayTao = objectInput.readLong();
		ngaySua = objectInput.readLong();
		nguoiTao = objectInput.readUTF();
		nguoiSua = objectInput.readUTF();
		groupId = objectInput.readLong();
		order_ = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (ten == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ten);
		}

		objectOutput.writeBoolean(trangThai);
		objectOutput.writeLong(ngayTao);
		objectOutput.writeLong(ngaySua);

		if (nguoiTao == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nguoiTao);
		}

		if (nguoiSua == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nguoiSua);
		}

		objectOutput.writeLong(groupId);
		objectOutput.writeInt(order_);
	}

	public long id;
	public String ten;
	public boolean trangThai;
	public long ngayTao;
	public long ngaySua;
	public String nguoiTao;
	public String nguoiSua;
	public long groupId;
	public int order_;
}