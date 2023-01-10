package com.didi.unifiedPay;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.SystemUtil;
import com.didi.unifiedPay.component.AbsUnifiedPaymentPresenter;
import com.didi.unifiedPay.component.IViewCallback;
import com.didi.unifiedPay.component.model.BackKeyType;
import com.didi.unifiedPay.component.model.PayErrorEvent;
import com.didi.unifiedPay.component.model.PayParam;
import com.didi.unifiedPay.component.presenter.impl.ManhattanUniPayPresenter;
import com.didi.unifiedPay.component.presenter.impl.TripUniPayPresenter;
import com.didi.unifiedPay.component.view.IPayView;
import com.didi.unifiedPay.component.view.PaymentView;
import com.didi.unifiedPay.sdk.net.C15308Util;
import com.taxis99.R;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public abstract class UniPayActivity extends FragmentActivity implements IViewCallback {
    public static final String UNI_PAY_PARAM = "uni_pay_param";

    /* renamed from: a */
    private FrameLayout f47014a;

    /* renamed from: b */
    private AbsUnifiedPaymentPresenter f47015b;

    /* renamed from: c */
    private PayParam f47016c;

    /* renamed from: d */
    private String f47017d;

    /* renamed from: e */
    private boolean f47018e;

    public int requestCode(int i) {
        return i;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        SystemUtil.init(this);
        Bundle extras = getIntent().getExtras();
        this.f47018e = false;
        m34984a(extras);
        setContentView((int) R.layout.oc_uni_pay_activity_layout);
        m34983a();
        extras.putSerializable("pay_param", this.f47016c);
        this.f47015b.onAdd(extras);
        EventBus.getDefault().register(this);
    }

    /* renamed from: a */
    private void m34984a(Bundle bundle) {
        if (bundle != null) {
            String str = (String) bundle.getSerializable("uni_pay_param");
            if (TextUtils.isEmpty(str)) {
                finish();
            }
            PayParam payParam = (PayParam) C15308Util.objectFromJson(str, PayParam.class);
            this.f47016c = payParam;
            if (payParam != null) {
                this.f47017d = payParam.sid;
            }
        }
    }

    /* renamed from: a */
    private void m34983a() {
        this.f47014a = (FrameLayout) findViewById(R.id.oc_uni_fl_component_container);
        PaymentView paymentView = getPaymentView();
        this.f47014a.addView(paymentView);
        m34986b();
        m34985a(paymentView, this.f47015b);
    }

    /* access modifiers changed from: protected */
    public PaymentView getPaymentView() {
        return new PaymentView(this);
    }

    /* renamed from: b */
    private void m34986b() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (this.f47016c.bid <= 0 || TextUtils.isEmpty(this.f47016c.oid)) {
            this.f47015b = new ManhattanUniPayPresenter(this, supportFragmentManager, this.f47017d, this);
            return;
        }
        this.f47015b = new TripUniPayPresenter(this, supportFragmentManager, this.f47017d, this.f47016c.bid, this.f47016c.oid, this);
    }

    /* renamed from: a */
    private void m34985a(IPayView iPayView, AbsUnifiedPaymentPresenter absUnifiedPaymentPresenter) {
        this.f47015b.setIView(iPayView);
        iPayView.setListener(absUnifiedPaymentPresenter);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AbsUnifiedPaymentPresenter absUnifiedPaymentPresenter;
        if (m34987c() || keyEvent.getKeyCode() != 4 || (absUnifiedPaymentPresenter = this.f47015b) == null) {
            return false;
        }
        return absUnifiedPaymentPresenter.onBackPressed(BackKeyType.BackKey);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        AbsUnifiedPaymentPresenter absUnifiedPaymentPresenter = this.f47015b;
        if (absUnifiedPaymentPresenter != null) {
            absUnifiedPaymentPresenter.onRemove();
        }
        super.onDestroy();
        this.f47018e = true;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        this.f47015b.onPageStart();
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.f47015b.onPageStop();
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        this.f47015b.onPageResume();
        this.f47015b.onPageShow();
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.f47015b.onPagePause();
        this.f47015b.onPageHide();
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        this.f47015b.onActivityResult(i, i2, intent);
    }

    public void closeView() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("code", 2);
        bundle.putString("message", "");
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    @Subscribe
    public void onEvent(PayErrorEvent payErrorEvent) {
        if (payErrorEvent != null && payErrorEvent.errorCode == 1059) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt("code", 3);
            bundle.putInt("errCode", payErrorEvent.errorCode);
            bundle.putString("message", payErrorEvent.message);
            intent.putExtras(bundle);
            setResult(-1, intent);
            finish();
        }
    }

    /* renamed from: c */
    private boolean m34987c() {
        return this.f47018e;
    }
}
