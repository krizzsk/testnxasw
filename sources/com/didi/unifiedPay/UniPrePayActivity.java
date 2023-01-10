package com.didi.unifiedPay;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import com.didi.sdk.apm.SystemUtils;
import com.didi.unifiedPay.component.IViewCallback;
import com.didi.unifiedPay.component.activity.BaseFragmentActivity;
import com.didi.unifiedPay.component.model.BackKeyType;
import com.didi.unifiedPay.component.model.PayParam;
import com.didi.unifiedPay.component.presenter.impl.PrePayPresenter;
import com.didi.unifiedPay.component.view.PrePaymentView;
import com.didi.unifiedPay.sdk.net.C15308Util;
import com.didi.unifiedPay.util.DeviceUtil;
import com.taxis99.R;

public class UniPrePayActivity extends BaseFragmentActivity implements IViewCallback {

    /* renamed from: a */
    private PrePayPresenter f47019a;

    /* renamed from: b */
    private PrePaymentView f47020b;
    protected PayParam mPayParam;

    public int requestCode(int i) {
        return i;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_pre_pay_layout);
        overridePendingTransition(R.anim.bottom_in, 0);
        m34988a();
        initParam();
        m34989b();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.bottom_out);
    }

    /* renamed from: a */
    private void m34988a() {
        PrePaymentView prePaymentView = new PrePaymentView(this, getSupportFragmentManager());
        this.f47020b = prePaymentView;
        ((FrameLayout) findViewById(R.id.fl_container)).addView(prePaymentView);
    }

    /* access modifiers changed from: protected */
    public void initParam() {
        if (getIntent().getExtras() != null) {
            String str = (String) getIntent().getExtras().getSerializable("pay_param");
            if (TextUtils.isEmpty(str)) {
                finish();
            }
            this.mPayParam = (PayParam) C15308Util.objectFromJson(str, PayParam.class);
        }
    }

    /* renamed from: b */
    private void m34989b() {
        if (this.mPayParam == null) {
            finish();
        }
        PrePayPresenter prePayPresenter = new PrePayPresenter(this, getSupportFragmentManager(), this);
        this.f47019a = prePayPresenter;
        prePayPresenter.setIView(this.f47020b);
        PrePaymentView prePaymentView = this.f47020b;
        if (prePaymentView != null) {
            prePaymentView.setListener(this.f47019a);
        }
        Bundle extras = getIntent().getExtras();
        extras.putSerializable("pay_param", this.mPayParam);
        this.f47019a.onAdd(extras);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        PrePayPresenter prePayPresenter;
        if (isActivityDestroyed() || keyEvent.getKeyCode() != 4 || (prePayPresenter = this.f47019a) == null) {
            return false;
        }
        return prePayPresenter.onBackPressed(BackKeyType.BackKey);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        PrePayPresenter prePayPresenter = this.f47019a;
        if (prePayPresenter != null) {
            prePayPresenter.onRemove();
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        this.f47019a.onPageStart();
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.f47019a.onPageStop();
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        this.f47019a.onPageResume();
        this.f47019a.onPageShow();
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.f47019a.onPagePause();
        this.f47019a.onPageHide();
        super.onPause();
    }

    public void callStartActivityForResult(Intent intent, int i) {
        intent.setPackage(DeviceUtil.getPackageName(this));
        startActivityForResult(intent, i);
    }

    public void callStartActivity(Intent intent) {
        intent.setPackage(DeviceUtil.getPackageName(this));
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        this.f47019a.onActivityResult(i, i2, intent);
    }

    public void closeView() {
        finish();
    }
}
