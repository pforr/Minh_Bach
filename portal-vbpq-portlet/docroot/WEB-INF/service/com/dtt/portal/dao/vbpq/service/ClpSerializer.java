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

import com.dtt.portal.dao.vbpq.model.AttachFileClp;
import com.dtt.portal.dao.vbpq.model.CoQuanBanHanhVanBanClp;
import com.dtt.portal.dao.vbpq.model.LinhVucVanBanClp;
import com.dtt.portal.dao.vbpq.model.LoaiVanBanClp;
import com.dtt.portal.dao.vbpq.model.VanBanPhapQuyClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HuyMQ
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"portal-vbpq-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"portal-vbpq-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "portal-vbpq-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(AttachFileClp.class.getName())) {
			return translateInputAttachFile(oldModel);
		}

		if (oldModelClassName.equals(CoQuanBanHanhVanBanClp.class.getName())) {
			return translateInputCoQuanBanHanhVanBan(oldModel);
		}

		if (oldModelClassName.equals(LinhVucVanBanClp.class.getName())) {
			return translateInputLinhVucVanBan(oldModel);
		}

		if (oldModelClassName.equals(LoaiVanBanClp.class.getName())) {
			return translateInputLoaiVanBan(oldModel);
		}

		if (oldModelClassName.equals(VanBanPhapQuyClp.class.getName())) {
			return translateInputVanBanPhapQuy(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputAttachFile(BaseModel<?> oldModel) {
		AttachFileClp oldClpModel = (AttachFileClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAttachFileRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCoQuanBanHanhVanBan(
		BaseModel<?> oldModel) {
		CoQuanBanHanhVanBanClp oldClpModel = (CoQuanBanHanhVanBanClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCoQuanBanHanhVanBanRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLinhVucVanBan(BaseModel<?> oldModel) {
		LinhVucVanBanClp oldClpModel = (LinhVucVanBanClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLinhVucVanBanRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLoaiVanBan(BaseModel<?> oldModel) {
		LoaiVanBanClp oldClpModel = (LoaiVanBanClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLoaiVanBanRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVanBanPhapQuy(BaseModel<?> oldModel) {
		VanBanPhapQuyClp oldClpModel = (VanBanPhapQuyClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVanBanPhapQuyRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.dtt.portal.dao.vbpq.model.impl.AttachFileImpl")) {
			return translateOutputAttachFile(oldModel);
		}

		if (oldModelClassName.equals(
					"com.dtt.portal.dao.vbpq.model.impl.CoQuanBanHanhVanBanImpl")) {
			return translateOutputCoQuanBanHanhVanBan(oldModel);
		}

		if (oldModelClassName.equals(
					"com.dtt.portal.dao.vbpq.model.impl.LinhVucVanBanImpl")) {
			return translateOutputLinhVucVanBan(oldModel);
		}

		if (oldModelClassName.equals(
					"com.dtt.portal.dao.vbpq.model.impl.LoaiVanBanImpl")) {
			return translateOutputLoaiVanBan(oldModel);
		}

		if (oldModelClassName.equals(
					"com.dtt.portal.dao.vbpq.model.impl.VanBanPhapQuyImpl")) {
			return translateOutputVanBanPhapQuy(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"com.dtt.portal.dao.vbpq.CoQuanBanHanhTenException")) {
			return new com.dtt.portal.dao.vbpq.CoQuanBanHanhTenException();
		}

		if (className.equals(
					"com.dtt.portal.dao.vbpq.DuplicateMaVanBanException")) {
			return new com.dtt.portal.dao.vbpq.DuplicateMaVanBanException();
		}

		if (className.equals("com.dtt.portal.dao.vbpq.DuplicateTenException")) {
			return new com.dtt.portal.dao.vbpq.DuplicateTenException();
		}

		if (className.equals(
					"com.dtt.portal.dao.vbpq.LinhVucVanBanTenException")) {
			return new com.dtt.portal.dao.vbpq.LinhVucVanBanTenException();
		}

		if (className.equals("com.dtt.portal.dao.vbpq.LoaiVanBanTenException")) {
			return new com.dtt.portal.dao.vbpq.LoaiVanBanTenException();
		}

		if (className.equals(
					"com.dtt.portal.dao.vbpq.RequiredCoQuanBanHanhException")) {
			return new com.dtt.portal.dao.vbpq.RequiredCoQuanBanHanhException();
		}

		if (className.equals(
					"com.dtt.portal.dao.vbpq.RequiredLinhVucVanBanException")) {
			return new com.dtt.portal.dao.vbpq.RequiredLinhVucVanBanException();
		}

		if (className.equals(
					"com.dtt.portal.dao.vbpq.RequiredLoaiVanBanException")) {
			return new com.dtt.portal.dao.vbpq.RequiredLoaiVanBanException();
		}

		if (className.equals("com.dtt.portal.dao.vbpq.VanBanFileException")) {
			return new com.dtt.portal.dao.vbpq.VanBanFileException();
		}

		if (className.equals("com.dtt.portal.dao.vbpq.VanBanTenException")) {
			return new com.dtt.portal.dao.vbpq.VanBanTenException();
		}

		if (className.equals(
					"com.dtt.portal.dao.vbpq.NoSuchAttachFileException")) {
			return new com.dtt.portal.dao.vbpq.NoSuchAttachFileException();
		}

		if (className.equals(
					"com.dtt.portal.dao.vbpq.NoSuchCoQuanBanHanhVanBanException")) {
			return new com.dtt.portal.dao.vbpq.NoSuchCoQuanBanHanhVanBanException();
		}

		if (className.equals(
					"com.dtt.portal.dao.vbpq.NoSuchLinhVucVanBanException")) {
			return new com.dtt.portal.dao.vbpq.NoSuchLinhVucVanBanException();
		}

		if (className.equals(
					"com.dtt.portal.dao.vbpq.NoSuchLoaiVanBanException")) {
			return new com.dtt.portal.dao.vbpq.NoSuchLoaiVanBanException();
		}

		if (className.equals(
					"com.dtt.portal.dao.vbpq.NoSuchVanBanPhapQuyException")) {
			return new com.dtt.portal.dao.vbpq.NoSuchVanBanPhapQuyException();
		}

		return throwable;
	}

	public static Object translateOutputAttachFile(BaseModel<?> oldModel) {
		AttachFileClp newModel = new AttachFileClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAttachFileRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCoQuanBanHanhVanBan(
		BaseModel<?> oldModel) {
		CoQuanBanHanhVanBanClp newModel = new CoQuanBanHanhVanBanClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCoQuanBanHanhVanBanRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLinhVucVanBan(BaseModel<?> oldModel) {
		LinhVucVanBanClp newModel = new LinhVucVanBanClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLinhVucVanBanRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLoaiVanBan(BaseModel<?> oldModel) {
		LoaiVanBanClp newModel = new LoaiVanBanClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLoaiVanBanRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVanBanPhapQuy(BaseModel<?> oldModel) {
		VanBanPhapQuyClp newModel = new VanBanPhapQuyClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVanBanPhapQuyRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}