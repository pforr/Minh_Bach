package com.dtt.portal.adminvbpq.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.dtt.portal.dao.vbpq.service.LinhVucVanBanLocalServiceUtil;
import com.dtt.portal.dao.vbpq.terms.LinhVucVanBanTerms;
import com.dtt.portal.dao.vbpq.util.MessageErrors;

public class LinhVucVanBanAction {

	/**
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void deleteLinhVuc(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException {

		long linhvucId = ParamUtil
				.getLong(actionRequest, LinhVucVanBanTerms.ID);

		LinhVucVanBanLocalServiceUtil.deleteLinhVuc(linhvucId);
	}

	/**
	 * Update CoQuanBanHanh
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void updateLinhVuc(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException {

		LinhVucVanBanTerms terms = new LinhVucVanBanTerms(actionRequest);

		ServiceContext context = ServiceContextFactory
				.getInstance(actionRequest);

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		List<String> errors = new ArrayList<String>();

		boolean valid = validationInput(terms.getTen(), errors);

		if (valid) {
			if (cmd.contentEquals(Constants.ADD)
					|| cmd.contentEquals(Constants.UPDATE)) {
				LinhVucVanBanLocalServiceUtil.updateLinhVucVanBan(
						context.getUserId(), terms.getId(), terms.getTen(),
						terms.isTrangThai(), terms.getOrder(),
						context.getScopeGroupId());
			}
		}

		for (String error : errors) {
			SessionErrors.add(actionRequest, error);
		}

	}

	/**
	 * Validation input form
	 * 
	 * @param ten
	 * @param errors
	 * @return
	 */
	private boolean validationInput(String ten, List<String> errors) {

		boolean result = true;

		if (Validator.isNull(ten)) {
			errors.add(MessageErrors.EMPTY_TEN_LINH_VUC_VAN_BAN);
			result = false;
		}

		return result;
	}
}
