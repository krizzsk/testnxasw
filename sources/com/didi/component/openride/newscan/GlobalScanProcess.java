package com.didi.component.openride.newscan;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.openride.deeplink.OpenRideSchemeFilter;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.sdk.util.AppUtils;
import com.didi.travel.psnger.model.response.PinCodeInfoResult;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.scan.delegate.QRCodeProcessDelegate;
import com.didiglobal.scan.delegate.QRScanDelegate;

@ServiceProvider({QRCodeProcessDelegate.class})
public class GlobalScanProcess implements IQRScannerView, QRCodeProcessDelegate {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public GlobalOpenRideQRScanPresenter f16582a;

    /* renamed from: b */
    private QRScanDelegate f16583b;

    /* renamed from: c */
    private Context f16584c;

    /* renamed from: d */
    private Fragment f16585d;

    /* renamed from: e */
    private Handler f16586e = new Handler(Looper.getMainLooper());

    public void dismissRequestLoadingDialog() {
    }

    public void finishWithResultOk() {
    }

    public void onLeave() {
    }

    public void scanResume() {
    }

    public void showNotRequireQRCodeToast() {
    }

    public void showRequestFailedToast(PinCodeInfoResult pinCodeInfoResult) {
    }

    public void showRequestLoadingDialog() {
    }

    public void onEnter(QRScanDelegate qRScanDelegate) {
        if (qRScanDelegate != null) {
            this.f16583b = qRScanDelegate;
            this.f16584c = qRScanDelegate.getActivity();
            this.f16585d = this.f16583b.getFragment();
            Context context = this.f16584c;
            if (context != null) {
                this.f16582a = new GlobalOpenRideQRScanPresenter(context, this);
                if (FormStore.getInstance().isOpenRideFromDeepLink()) {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            GlobalScanProcess.this.f16582a.createPinSuccess(FormStore.getInstance().getDriverInfo());
                        }
                    }, 100);
                }
            }
        }
    }

    public void showPop(PinCodeInfoResult pinCodeInfoResult) {
        if (this.f16584c != null) {
            StringBuilder sb = new StringBuilder();
            if (AppUtils.isBrazilApp(this.f16584c)) {
                sb.append(OpenRideSchemeFilter.OPEN_RIDE_99_SCHEME);
            } else {
                sb.append("globalonetravel");
            }
            sb.append("://one/openridedriverpage");
            FormStore.getInstance().setIsFromOpenRide(true);
            ((Request) DRouter.build(sb.toString()).putExtra("data", pinCodeInfoResult.toJson())).start();
        }
    }
}
