package com.dtt.portal.adminvbpq.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.dtt.portal.adminvbpq.action.CoQuanBanHanhAction;
import com.dtt.portal.adminvbpq.action.LinhVucVanBanAction;
import com.dtt.portal.adminvbpq.action.LoaiVanBanAction;
import com.dtt.portal.adminvbpq.action.VanBanPhapQuyAction;

public class AdminPortlet extends MVCPortlet {

	/**
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 */
	public void updateVanBanPhapQuy(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		try {
			VanBanPhapQuyAction action = new VanBanPhapQuyAction();
			action.updateVanBanPhapQuy_NEW(actionRequest, actionResponse);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		
		sendCustomRedirect(actionRequest, actionResponse);
	}

	
	/**updateStatusVanBan
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 */
	public void updateStatusVanBan(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		try {
			VanBanPhapQuyAction action = new VanBanPhapQuyAction();
			action.updateStatusVanBan(actionRequest, actionResponse);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		
		sendCustomRedirect(actionRequest, actionResponse);
	}
	
	/**
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 */
	public void updateLoaiVanBan(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		try {
			LoaiVanBanAction action = new LoaiVanBanAction();
			action.updateLoaiVanBan(actionRequest, actionResponse);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}

		sendCustomRedirect(actionRequest, actionResponse);

	}

	/**
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 */
	public void deleteLoaiVanBan(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		try {
			LoaiVanBanAction action = new LoaiVanBanAction();
			action.deleteLoaiVanBan(actionRequest, actionResponse);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}

		sendCustomRedirect(actionRequest, actionResponse);

	}
	
	public void deleteVanBan(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		try {
			VanBanPhapQuyAction action = new VanBanPhapQuyAction();
			action.deleteVanBan(actionRequest, actionResponse);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}

		sendCustomRedirect(actionRequest, actionResponse);

	}

	/**
	 * Update LinhVucVanBan
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 */
	public void updateLinhVuc(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		try {
			LinhVucVanBanAction action = new LinhVucVanBanAction();
			action.updateLinhVuc(actionRequest, actionResponse);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}

		sendCustomRedirect(actionRequest, actionResponse);

	}

	/**
	 * Delete LinhVucVanban
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 */
	public void deleteLinhVuc(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		try {
			LinhVucVanBanAction action = new LinhVucVanBanAction();
			action.deleteLinhVuc(actionRequest, actionResponse);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}

		sendCustomRedirect(actionRequest, actionResponse);
	}

	/**
	 * Delete CoQuanBanHanh
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 */
	public void deleteCoQuanBanHanh(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {

		try {
			CoQuanBanHanhAction action = new CoQuanBanHanhAction();
			action.deleteCoQuanBanHanh(actionRequest, actionResponse);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}

		sendCustomRedirect(actionRequest, actionResponse);
	}

	/**
	 * Update CoQuanBanHanh
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 */
	public void updateCoQuanBanHanh(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {
		try {
			CoQuanBanHanhAction action = new CoQuanBanHanhAction();
			action.updateCoQuanBanHanh(actionRequest, actionResponse);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}

		sendCustomRedirect(actionRequest, actionResponse);

	}

	/**
	 * Send a Custom redirect after execute action
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 */
	private void sendCustomRedirect(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {

		if (!SessionErrors.isEmpty(actionRequest)) {
			String backURL = ParamUtil.getString(actionRequest, "backURL");

			SessionMessages
					.add(actionRequest,
							PortalUtil.getPortletId(actionRequest)
									+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

			if (Validator.isNotNull(backURL)) {
				actionResponse.sendRedirect(backURL);
			}
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(AdminPortlet.class);

}
