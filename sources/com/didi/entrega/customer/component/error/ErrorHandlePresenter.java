package com.didi.entrega.customer.component.error;

import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.component.error.Contract;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.ApiErrorConst;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.customer.foundation.util.ErrorHandleUtil;
import com.didi.entrega.customer.foundation.util.LoginUtil;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.IOneSdkService;

public class ErrorHandlePresenter extends Contract.AbsErrorHandlePresenter {

    /* renamed from: a */
    private static final String f21704a = "ErrorHandlePresenter";

    /* renamed from: b */
    private ErrorHandleUtil.ErrorHandleListener f21705b = new ErrorHandleUtil.ErrorHandleListener() {
        public void onErrorHandle(SFRpcException sFRpcException) {
            if (sFRpcException.getCode() <= -1) {
                LogUtil.m18183e(ErrorHandlePresenter.f21704a, "Error msg: " + sFRpcException.getOriginalMessage());
            } else if (ApiErrorConst.isAccountAbnormal(sFRpcException.getCode())) {
                ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).logOut(ErrorHandlePresenter.this.getContext(), ApiErrorConst.LogoutReasons.getSignReasonByErrorCode(sFRpcException.getCode()));
                ErrorHandlePresenter.this.getScopeContext().getNavigator().popToRoot();
                LoginUtil.loginActivityAndTrack(GlobalContext.getContext(), 3);
            } else {
                ((Contract.AbsErrorHandleView) ErrorHandlePresenter.this.getLogicView()).showErrorTip(sFRpcException.getMessage());
            }
        }
    };

    /* access modifiers changed from: protected */
    public void onCreate() {
        ErrorHandleUtil.setErrorHandleListener(this.f21705b);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        ErrorHandleUtil.setErrorHandleListener((ErrorHandleUtil.ErrorHandleListener) null);
    }
}
