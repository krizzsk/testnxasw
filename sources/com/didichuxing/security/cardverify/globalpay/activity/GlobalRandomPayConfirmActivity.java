package com.didichuxing.security.cardverify.globalpay.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.security.cardverify.DiCardVerifyCallback;
import com.didichuxing.security.cardverify.DiCardVerifyParam;
import com.didichuxing.security.cardverify.globalpay.presenter.GlobalPayVerificationPrePresenter;
import com.didichuxing.security.cardverify.globalpay.view.GlobalPayLottieLoadingView;
import com.didichuxing.security.cardverify.globalpay.view.GlobalPayShadowLayout;
import com.didichuxing.security.cardverify.report.DiCardVerifyTracker;
import com.google.gson.Gson;
import com.taxis99.R;

public class GlobalRandomPayConfirmActivity extends FragmentActivity {
    public static final String EXTRA_MSG = "msg";
    public static final String EXTRA_PARAM = "param";
    public static DiCardVerifyCallback callback;

    /* renamed from: a */
    private GlobalPayShadowLayout f51482a;

    /* renamed from: b */
    private GlobalPayLottieLoadingView f51483b;

    /* renamed from: c */
    private TextView f51484c;

    /* renamed from: d */
    private boolean f51485d = true;

    /* renamed from: e */
    private int f51486e;

    /* renamed from: f */
    private View.OnClickListener f51487f = null;

    public static void start(Context context, DiCardVerifyParam diCardVerifyParam, String str, DiCardVerifyCallback diCardVerifyCallback) {
        callback = diCardVerifyCallback;
        Intent intent = new Intent(context, GlobalRandomPayConfirmActivity.class);
        intent.putExtra("param", new Gson().toJson((Object) diCardVerifyParam));
        intent.putExtra("msg", str);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        DiCardVerifyParam diCardVerifyParam = (DiCardVerifyParam) new Gson().fromJson(getIntent().getStringExtra("param"), DiCardVerifyParam.class);
        new GlobalPayVerificationPrePresenter(diCardVerifyParam).startVerification(this, diCardVerifyParam, getIntent().getStringExtra("msg"), callback);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        callback = null;
    }

    public void finish() {
        int i = this.f51486e;
        if (2 == i) {
            DiCardVerifyTracker.trackDeductSucceed();
        } else if (1 == i) {
            DiCardVerifyTracker.trackDeductFailed();
        }
        super.finish();
    }

    public void payStart() {
        this.f51486e = 1;
    }

    public void paySuccess() {
        this.f51486e = 2;
    }

    public void showVerifyConfirmDialog(String str, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        setContentView((int) R.layout.didi_security_card_verify_global_pay_confirm_activity);
        View findViewById = findViewById(R.id.iv_close);
        this.f51487f = onClickListener2;
        findViewById.setOnClickListener(onClickListener2);
        TextView textView = (TextView) findViewById(R.id.btn_confirm);
        this.f51484c = textView;
        textView.setText(getResources().getString(R.string.didi_security_card_verify_pay_confirm_dialog_positive));
        this.f51484c.setOnClickListener(onClickListener);
        ((TextView) findViewById(R.id.tv_content)).setText(str);
        this.f51482a = (GlobalPayShadowLayout) findViewById(R.id.loading_view_container);
        this.f51483b = (GlobalPayLottieLoadingView) findViewById(R.id.loading_view);
    }

    public void onBackPressed() {
        if (this.f51485d) {
            super.onBackPressed();
            View.OnClickListener onClickListener = this.f51487f;
            if (onClickListener != null) {
                onClickListener.onClick((View) null);
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f51485d) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    public void showLoading() {
        this.f51483b.show();
        this.f51482a.setVisibility(0);
        this.f51484c.setEnabled(false);
        this.f51485d = false;
    }

    public void hideLoading() {
        this.f51483b.hide();
        this.f51482a.setVisibility(8);
        this.f51484c.setEnabled(true);
        this.f51485d = true;
    }
}
