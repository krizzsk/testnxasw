package com.didi.component.openride.newscan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.openride.deeplink.OpenRideSchemeFilter;
import com.didi.component.openride.widget.QRCodeInputLayout;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.didi.travel.psnger.model.response.PinCodeInfoResult;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\"\u001a\u00020\u0013H\u0016J\b\u0010#\u001a\u00020\u0013H\u0002J\b\u0010$\u001a\u00020\u0013H\u0016J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0013H\u0002J\b\u0010)\u001a\u00020\u0013H\u0016J\b\u0010*\u001a\u00020\u0013H\u0016J\u0012\u0010+\u001a\u00020\u00132\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0012\u0010.\u001a\u00020\u00132\b\u0010/\u001a\u0004\u0018\u00010-H\u0016J\b\u00100\u001a\u00020\u0013H\u0016J\b\u00101\u001a\u00020\u0013H\u0002J\b\u00102\u001a\u00020\u0013H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u00063"}, mo148868d2 = {"Lcom/didi/component/openride/newscan/GlobalOpenRideCodeInputFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/didi/component/openride/widget/QRCodeInputLayout$OnStateChangedListener;", "Lcom/didi/component/openride/newscan/IQRScannerView;", "()V", "mMainTitle", "Landroid/widget/TextView;", "mNullEventListener", "Lcom/didi/component/core/event/BaseEventPublisher$OnEventListener;", "Lcom/didi/component/core/event/BaseEventPublisher$NullEvent;", "mOpenRidePresenterOpenRide", "Lcom/didi/component/openride/newscan/GlobalOpenRideQRScanPresenter;", "mQRCodeInputLayout", "Lcom/didi/component/openride/widget/QRCodeInputLayout;", "mRootView", "Landroid/widget/RelativeLayout;", "mTitleBar", "Lcom/didi/sdk/view/titlebar/CommonTitleBar;", "dismissRequestLoadingDialog", "", "finishWithResultOk", "hideSoftKeyboard", "initView", "viewGroup", "Landroid/view/ViewGroup;", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "onDestroy", "onLeaveInputCode", "onPause", "onStateChanged", "state", "Lcom/didi/component/openride/widget/QRCodeInputLayout$State;", "register", "scanResume", "showNotRequireQRCodeToast", "showPop", "result", "Lcom/didi/travel/psnger/model/response/PinCodeInfoResult;", "showRequestFailedToast", "pinCodeInfoResult", "showRequestLoadingDialog", "track", "unregister", "comp-openride_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalOpenRideCodeInputFragment.kt */
public final class GlobalOpenRideCodeInputFragment extends Fragment implements IQRScannerView, QRCodeInputLayout.OnStateChangedListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public CommonTitleBar f16567a;

    /* renamed from: b */
    private TextView f16568b;

    /* renamed from: c */
    private RelativeLayout f16569c;

    /* renamed from: d */
    private QRCodeInputLayout f16570d;

    /* renamed from: e */
    private GlobalOpenRideQRScanPresenter f16571e;

    /* renamed from: f */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f16572f = new GlobalOpenRideCodeInputFragment$mNullEventListener$1(this);

    public void _$_clearFindViewByIdCache() {
    }

    public void finishWithResultOk() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m13929c();
        m13926a();
    }

    public void onDestroy() {
        m13928b();
        super.onDestroy();
    }

    /* renamed from: a */
    private final void m13926a() {
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.OpenRide.EVENT_OPEN_RIDE_SHOW_SUG_PAGE, this.f16572f, BaseEventPublisher.NullEvent.class);
    }

    /* renamed from: b */
    private final void m13928b() {
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.OpenRide.EVENT_OPEN_RIDE_SHOW_SUG_PAGE, this.f16572f, BaseEventPublisher.NullEvent.class);
    }

    /* renamed from: c */
    private final void m13929c() {
        GlobalOmegaUtils.trackEvent("Pas_99GO_digitcode_sw");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_layout_global_qr_code_input, viewGroup, false);
        if (inflate != null) {
            RelativeLayout relativeLayout = (RelativeLayout) inflate;
            this.f16569c = relativeLayout;
            m13927a(relativeLayout);
            return this.f16569c;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        StatusBarLightingCompat.setStatusBarBgLightning(getActivity(), true, 0);
    }

    /* JADX WARNING: type inference failed for: r5v10, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m13927a(android.view.ViewGroup r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0005
            r1 = r0
            goto L_0x000e
        L_0x0005:
            r1 = 2131433000(0x7f0b1628, float:1.8487773E38)
            android.view.View r1 = r5.findViewById(r1)
            com.didi.sdk.view.titlebar.CommonTitleBar r1 = (com.didi.sdk.view.titlebar.CommonTitleBar) r1
        L_0x000e:
            r4.f16567a = r1
            r2 = 8
            if (r1 != 0) goto L_0x0015
            goto L_0x0018
        L_0x0015:
            r1.setTitleBarLineVisible(r2)
        L_0x0018:
            com.didi.sdk.view.titlebar.CommonTitleBar r1 = r4.f16567a
            if (r1 != 0) goto L_0x001d
            goto L_0x0027
        L_0x001d:
            com.didi.component.openride.newscan.GlobalOpenRideCodeInputFragment$initView$1 r3 = new com.didi.component.openride.newscan.GlobalOpenRideCodeInputFragment$initView$1
            r3.<init>(r4)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r1.setLeftBackListener(r3)
        L_0x0027:
            android.widget.RelativeLayout r1 = r4.f16569c
            if (r1 != 0) goto L_0x002d
            r1 = r0
            goto L_0x0036
        L_0x002d:
            r3 = 2131432999(0x7f0b1627, float:1.8487771E38)
            android.view.View r1 = r1.findViewById(r3)
            android.widget.TextView r1 = (android.widget.TextView) r1
        L_0x0036:
            r4.f16568b = r1
            if (r1 != 0) goto L_0x003b
            goto L_0x004b
        L_0x003b:
            r3 = 2131955297(0x7f130e61, float:1.9547117E38)
            java.lang.String r3 = r4.getString(r3)
            android.text.Spanned r3 = android.text.Html.fromHtml(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
        L_0x004b:
            if (r5 != 0) goto L_0x004f
            r5 = r0
            goto L_0x0056
        L_0x004f:
            r1 = 2131432985(0x7f0b1619, float:1.8487743E38)
            android.view.View r5 = r5.findViewById(r1)
        L_0x0056:
            if (r5 == 0) goto L_0x009a
            com.didi.component.openride.widget.QRCodeInputLayout r5 = (com.didi.component.openride.widget.QRCodeInputLayout) r5
            r4.f16570d = r5
            if (r5 != 0) goto L_0x005f
            goto L_0x0065
        L_0x005f:
            r1 = r4
            com.didi.component.openride.widget.QRCodeInputLayout$OnStateChangedListener r1 = (com.didi.component.openride.widget.QRCodeInputLayout.OnStateChangedListener) r1
            r5.setOnStateChangedListener(r1)
        L_0x0065:
            android.widget.RelativeLayout r5 = r4.f16569c
            if (r5 != 0) goto L_0x006a
            goto L_0x0074
        L_0x006a:
            r0 = 2131432998(0x7f0b1626, float:1.848777E38)
            android.view.View r5 = r5.findViewById(r0)
            r0 = r5
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x0074:
            if (r0 != 0) goto L_0x0077
            goto L_0x0083
        L_0x0077:
            r5 = 2131955296(0x7f130e60, float:1.9547115E38)
            java.lang.String r5 = r4.getString(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.setText(r5)
        L_0x0083:
            com.didi.component.openride.widget.QRCodeInputLayout r5 = r4.f16570d
            if (r5 != 0) goto L_0x0088
            goto L_0x008b
        L_0x0088:
            r5.initView(r2)
        L_0x008b:
            com.didi.component.openride.newscan.GlobalOpenRideQRScanPresenter r5 = new com.didi.component.openride.newscan.GlobalOpenRideQRScanPresenter
            android.content.Context r0 = r4.getContext()
            r1 = r4
            com.didi.component.openride.newscan.IQRScannerView r1 = (com.didi.component.openride.newscan.IQRScannerView) r1
            r5.<init>(r0, r1)
            r4.f16571e = r5
            return
        L_0x009a:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type com.didi.component.openride.widget.QRCodeInputLayout"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.openride.newscan.GlobalOpenRideCodeInputFragment.m13927a(android.view.ViewGroup):void");
    }

    public void onPause() {
        super.onPause();
        m13930d();
    }

    /* renamed from: d */
    private final void m13930d() {
        QRCodeInputLayout qRCodeInputLayout = this.f16570d;
        if (qRCodeInputLayout != null) {
            qRCodeInputLayout.hideSoftKeyboard();
        }
    }

    public void onStateChanged(QRCodeInputLayout.State state) {
        String pin;
        Intrinsics.checkNotNullParameter(state, "state");
        if (state == QRCodeInputLayout.State.COMPLETE) {
            m13930d();
            GlobalOpenRideQRScanPresenter globalOpenRideQRScanPresenter = this.f16571e;
            if (globalOpenRideQRScanPresenter != null) {
                QRCodeInputLayout qRCodeInputLayout = this.f16570d;
                String str = "";
                if (!(qRCodeInputLayout == null || (pin = qRCodeInputLayout.getPin()) == null)) {
                    str = pin;
                }
                globalOpenRideQRScanPresenter.handleDriverCode(str, 2);
            }
        }
    }

    public void showRequestLoadingDialog() {
        UiThreadHandler.post(new GlobalOpenRideCodeInputFragment$showRequestLoadingDialog$1(this));
    }

    public void dismissRequestLoadingDialog() {
        UiThreadHandler.post(new GlobalOpenRideCodeInputFragment$dismissRequestLoadingDialog$1(this));
    }

    public void showRequestFailedToast(PinCodeInfoResult pinCodeInfoResult) {
        UiThreadHandler.post(new GlobalOpenRideCodeInputFragment$showRequestFailedToast$1(this, pinCodeInfoResult));
    }

    public void showNotRequireQRCodeToast() {
        UiThreadHandler.post(new GlobalOpenRideCodeInputFragment$showNotRequireQRCodeToast$1(this));
    }

    public void scanResume() {
        QRCodeInputLayout qRCodeInputLayout = this.f16570d;
        if (qRCodeInputLayout != null) {
            qRCodeInputLayout.clearPin();
        }
    }

    public void showPop(PinCodeInfoResult pinCodeInfoResult) {
        if (getContext() != null && !isDetached() && pinCodeInfoResult != null) {
            StringBuilder sb = new StringBuilder();
            if (AppUtils.isBrazilApp(getContext())) {
                sb.append(OpenRideSchemeFilter.OPEN_RIDE_99_SCHEME);
            } else {
                sb.append("globalonetravel");
            }
            sb.append("://one/openridedriverpage");
            scanResume();
            FormStore.getInstance().setIsFromOpenRide(true);
            ((Request) DRouter.build(sb.toString()).putExtra("data", pinCodeInfoResult.toJson())).start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public final void m13931e() {
        GlobalOpenRideQRScanPresenter globalOpenRideQRScanPresenter;
        PinCodeInfoResult driverInfo = FormStore.getInstance().getDriverInfo();
        if (!(driverInfo == null || (globalOpenRideQRScanPresenter = this.f16571e) == null)) {
            globalOpenRideQRScanPresenter.notifyDriverStateOfPsg(2, driverInfo.driverId);
        }
        FormStore.getInstance().setDriverInfo((PinCodeInfoResult) null);
        GlobalOmegaUtils.trackEvent("Pas_99GO_digitcode_back");
    }
}
