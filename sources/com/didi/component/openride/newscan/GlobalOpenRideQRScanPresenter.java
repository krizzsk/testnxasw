package com.didi.component.openride.newscan;

import android.content.Context;
import android.text.TextUtils;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.net.CarRequest;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.PinCodeInfoResult;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;

public class GlobalOpenRideQRScanPresenter {
    public static final int FROM_PINCODE = 2;
    public static final int FROM_SCAN = 1;

    /* renamed from: a */
    private static final int f16575a = 8;

    /* renamed from: b */
    private static final String f16576b = "driverCode";

    /* renamed from: c */
    private Context f16577c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public IQRScannerView f16578d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f16579e;

    public GlobalOpenRideQRScanPresenter(Context context, IQRScannerView iQRScannerView) {
        this.f16577c = context;
        this.f16578d = iQRScannerView;
    }

    public void handleDriverCode(String str, int i) {
        this.f16579e = i;
        if (!m13939b(str)) {
            this.f16578d.showNotRequireQRCodeToast();
        } else {
            m13937a(str);
        }
    }

    /* renamed from: a */
    private void m13937a(String str) {
        int parseInt = Integer.parseInt(str);
        this.f16578d.showRequestLoadingDialog();
        CarRequest.confirmPinCode(this.f16577c, parseInt, new ResponseListener<PinCodeInfoResult>() {
            public void onSuccess(PinCodeInfoResult pinCodeInfoResult) {
                GlobalOpenRideQRScanPresenter.this.createPinSuccess(pinCodeInfoResult);
            }

            public void onError(PinCodeInfoResult pinCodeInfoResult) {
                super.onError(pinCodeInfoResult);
                GlobalOpenRideQRScanPresenter.this.f16578d.showRequestFailedToast(pinCodeInfoResult);
            }

            public void onFail(PinCodeInfoResult pinCodeInfoResult) {
                super.onFail(pinCodeInfoResult);
                GlobalOpenRideQRScanPresenter.this.f16578d.showRequestFailedToast(pinCodeInfoResult);
            }

            public void onFinish(PinCodeInfoResult pinCodeInfoResult) {
                super.onFinish(pinCodeInfoResult);
                if (GlobalOpenRideQRScanPresenter.this.f16579e == 1) {
                    GlobalOmegaUtils.trackEvent("Pas_99GO_qrcode_scan", Constants.ERROR_CODE, String.valueOf(pinCodeInfoResult.errno));
                } else if (GlobalOpenRideQRScanPresenter.this.f16579e == 2) {
                    GlobalOmegaUtils.trackEvent("Pas_99GO_digitcode_enter", Constants.ERROR_CODE, String.valueOf(pinCodeInfoResult.errno));
                }
                GlobalOpenRideQRScanPresenter.this.f16578d.dismissRequestLoadingDialog();
            }
        });
    }

    public void createPinSuccess(PinCodeInfoResult pinCodeInfoResult) {
        if (pinCodeInfoResult != null) {
            FormStore.getInstance().setDriverInfo(pinCodeInfoResult);
            this.f16578d.showPop(pinCodeInfoResult);
            notifyDriverStateOfPsg(1, pinCodeInfoResult.driverId);
        }
    }

    public void notifyDriverStateOfPsg(int i, String str) {
        CarRequest.notifyDriverStateOfPsg(this.f16577c, i, str, (ResponseListener<BaseObject>) null);
    }

    /* renamed from: b */
    private boolean m13939b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.matches("^\\d{8}$");
        }
        return false;
    }
}
