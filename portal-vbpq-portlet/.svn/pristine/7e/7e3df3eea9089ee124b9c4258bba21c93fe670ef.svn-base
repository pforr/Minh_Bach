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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author HuyMQ
 * @generated
 */
public class AttachFileSoap implements Serializable {
	public static AttachFileSoap toSoapModel(AttachFile model) {
		AttachFileSoap soapModel = new AttachFileSoap();

		soapModel.setId(model.getId());
		soapModel.setVanBanId(model.getVanBanId());
		soapModel.setFileId(model.getFileId());
		soapModel.setFileLink(model.getFileLink());
		soapModel.setFileName(model.getFileName());
		soapModel.setFileSize(model.getFileSize());

		return soapModel;
	}

	public static AttachFileSoap[] toSoapModels(AttachFile[] models) {
		AttachFileSoap[] soapModels = new AttachFileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AttachFileSoap[][] toSoapModels(AttachFile[][] models) {
		AttachFileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AttachFileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AttachFileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AttachFileSoap[] toSoapModels(List<AttachFile> models) {
		List<AttachFileSoap> soapModels = new ArrayList<AttachFileSoap>(models.size());

		for (AttachFile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AttachFileSoap[soapModels.size()]);
	}

	public AttachFileSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getVanBanId() {
		return _vanBanId;
	}

	public void setVanBanId(long vanBanId) {
		_vanBanId = vanBanId;
	}

	public long getFileId() {
		return _fileId;
	}

	public void setFileId(long fileId) {
		_fileId = fileId;
	}

	public String getFileLink() {
		return _fileLink;
	}

	public void setFileLink(String fileLink) {
		_fileLink = fileLink;
	}

	public String getFileName() {
		return _fileName;
	}

	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	public String getFileSize() {
		return _fileSize;
	}

	public void setFileSize(String fileSize) {
		_fileSize = fileSize;
	}

	private long _id;
	private long _vanBanId;
	private long _fileId;
	private String _fileLink;
	private String _fileName;
	private String _fileSize;
}