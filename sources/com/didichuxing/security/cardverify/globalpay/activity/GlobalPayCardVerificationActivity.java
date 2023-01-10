package com.didichuxing.security.cardverify.globalpay.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dcrypto.DCryptoMainFragment;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.security.cardverify.DiCardVerifyCallback;
import com.didichuxing.security.cardverify.DiCardVerifyParam;
import com.didichuxing.security.cardverify.activity.CardVerifyBaseActivity;
import com.didichuxing.security.cardverify.contract.CreditCardVerifyContract;
import com.didichuxing.security.cardverify.globalpay.utils.GlobalPayToast;
import com.didichuxing.security.cardverify.globalpay.view.GlobalPayLottieLoadingView;
import com.didichuxing.security.cardverify.globalpay.view.GlobalPayShadowLayout;
import com.didichuxing.security.cardverify.model.CardVerifyInfo;
import com.didichuxing.security.cardverify.presenter.VerificationPresenter;
import com.didichuxing.security.cardverify.report.DiCardVerifyTracker;
import com.didichuxing.security.cardverify.view.DecimalEditText;
import com.didichuxing.security.cardverify.view.MoneyEditTextContainer;
import com.google.gson.Gson;
import com.taxis99.R;
import java.lang.ref.WeakReference;

public class GlobalPayCardVerificationActivity extends CardVerifyBaseActivity implements CreditCardVerifyContract.IView {

    /* renamed from: a */
    private static final String f51464a = "KEY_INFO";

    /* renamed from: b */
    private static final String f51465b = "KEY_PARAM";
    public static DiCardVerifyCallback callback;

    /* renamed from: n */
    private static WeakReference<GlobalPayCardVerificationActivity> f51466n;

    /* renamed from: c */
    private boolean f51467c = true;

    /* renamed from: d */
    private ImageView f51468d;

    /* renamed from: e */
    private TextView f51469e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TextView f51470f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public DecimalEditText f51471g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TextView f51472h;

    /* renamed from: i */
    private GlobalPayShadowLayout f51473i;

    /* renamed from: j */
    private GlobalPayLottieLoadingView f51474j;

    /* renamed from: k */
    private VerificationPresenter f51475k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public CardVerifyInfo f51476l;

    /* renamed from: m */
    private DiCardVerifyParam f51477m;

    public void showToastCompleted(String str) {
    }

    public static void startActivity(Context context, DiCardVerifyParam diCardVerifyParam, CardVerifyInfo cardVerifyInfo, DiCardVerifyCallback diCardVerifyCallback) {
        callback = diCardVerifyCallback;
        Intent intent = new Intent();
        intent.setClass(context, GlobalPayCardVerificationActivity.class);
        intent.putExtra("KEY_PARAM", new Gson().toJson((Object) diCardVerifyParam));
        intent.putExtra(f51464a, cardVerifyInfo);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        f51466n = new WeakReference<>(this);
        setContentView((int) R.layout.didi_security_card_verify_global_pay_activity);
        if (m38538a()) {
            m38540b();
            return;
        }
        SystemUtils.log(3, "VerificationActivity", "onCreate: data is invalidate", (Throwable) null, "com.didichuxing.security.cardverify.globalpay.activity.GlobalPayCardVerificationActivity", 83);
        finish();
    }

    public void showToast(String str) {
        if (str == null) {
            str = "";
        }
        GlobalPayToast.show(getApplicationContext(), str);
    }

    public void onBackPressed() {
        if (this.f51467c) {
            m38535a(callback, 2, "user cancel");
            super.onBackPressed();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f51467c) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    public void showLoadingDialog(String str) {
        this.f51474j.show();
        this.f51473i.setVisibility(0);
        this.f51472h.setEnabled(false);
        this.f51467c = false;
    }

    public void dismissLoadingDialog() {
        this.f51474j.hide();
        this.f51473i.setVisibility(8);
        this.f51472h.setEnabled(true);
        this.f51467c = true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        callback = null;
        f51466n = null;
    }

    /* renamed from: a */
    private boolean m38538a() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f51476l = (CardVerifyInfo) intent.getSerializableExtra(f51464a);
            this.f51477m = (DiCardVerifyParam) new Gson().fromJson(intent.getStringExtra("KEY_PARAM"), DiCardVerifyParam.class);
            if (TextUtils.isEmpty(this.f51476l.defaultText)) {
                this.f51476l.defaultText = DCryptoMainFragment.DCRYPTO_ZERO;
            }
            this.f51475k = new VerificationPresenter(this, this.f51477m);
            return true;
        }
        this.f51475k = new VerificationPresenter(this, new DiCardVerifyParam.Builder(this).build());
        return false;
    }

    /* renamed from: b */
    private void m38540b() {
        this.f51468d = (ImageView) findViewById(R.id.iv_close);
        this.f51469e = (TextView) findViewById(R.id.tv_content);
        if (this.f51476l.isCurrencySuffix) {
            this.f51470f = (TextView) findViewById(R.id.suffix_verify_tv_currency);
        } else {
            this.f51470f = (TextView) findViewById(R.id.prefix_verify_tv_currency);
        }
        DecimalEditText decimalEditText = (DecimalEditText) findViewById(R.id.et_money);
        this.f51471g = decimalEditText;
        decimalEditText.setHint(this.f51476l.defaultText);
        TextView textView = (TextView) findViewById(R.id.btn_commit);
        this.f51472h = textView;
        textView.setText(getResources().getString(R.string.didi_security_card_verify_verify_page_btn_submit));
        this.f51472h.setEnabled(false);
        this.f51473i = (GlobalPayShadowLayout) findViewById(R.id.loading_view_container);
        this.f51474j = (GlobalPayLottieLoadingView) findViewById(R.id.loading_view);
        this.f51471g.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    GlobalPayCardVerificationActivity.this.f51471g.setHint("");
                    GlobalPayCardVerificationActivity.this.f51472h.setEnabled(true);
                    GlobalPayCardVerificationActivity.this.f51470f.setVisibility(0);
                    return;
                }
                GlobalPayCardVerificationActivity.this.f51471g.setHint(GlobalPayCardVerificationActivity.this.f51476l.defaultText);
                GlobalPayCardVerificationActivity.this.f51472h.setEnabled(false);
                GlobalPayCardVerificationActivity.this.f51470f.setVisibility(8);
            }
        });
        if (!this.f51476l.isShowDecimal) {
            this.f51471g.setDecimalNumber(0);
        }
        this.f51468d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalPayCardVerificationActivity.this.m38535a(GlobalPayCardVerificationActivity.callback, 2, "user cancel");
                GlobalPayCardVerificationActivity.this.finish();
            }
        });
        this.f51472h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalPayCardVerificationActivity.this.m38542c();
            }
        });
        ((MoneyEditTextContainer) findViewById(R.id.input_ll)).setTouchEventListener(new MoneyEditTextContainer.OnTouchEventListener() {
            public void onDown() {
                GlobalPayCardVerificationActivity globalPayCardVerificationActivity = GlobalPayCardVerificationActivity.this;
                globalPayCardVerificationActivity.m38534a(globalPayCardVerificationActivity.f51471g, GlobalPayCardVerificationActivity.this.getContext());
            }
        });
        this.f51469e.setText(this.f51476l.pageContent);
        this.f51470f.setText(this.f51476l.currencyText);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38534a(View view, Context context) {
        InputMethodManager inputMethodManager;
        if (view.requestFocus() && (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) != null) {
            inputMethodManager.showSoftInput(view, 1);
        }
    }

    public void onVerifySuccess() {
        DiCardVerifyTracker.trackVerifySucceed();
        finish();
        m38535a(callback, 0, "verify success");
    }

    public void onVerifyFailure() {
        DiCardVerifyTracker.trackVerifyFailed();
    }

    public void onVerifyMultiFailure(String str, String str2) {
        DiCardVerifyTracker.trackVerifyFailed();
        finish();
        m38535a(callback, 5, "verify fail");
    }

    public void onVerifyException() {
        DiCardVerifyTracker.trackVerifyFailed();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m38542c() {
        DiCardVerifyTracker.trackVerifyCk();
        String trim = this.f51471g.getText().toString().trim();
        if (trim.lastIndexOf(46) == trim.length() - 1) {
            trim = trim.substring(0, trim.length() - 1);
        }
        this.f51475k.verifyCard(trim, this.f51477m.getPhone());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38535a(DiCardVerifyCallback diCardVerifyCallback, int i, String str) {
        if (diCardVerifyCallback != null) {
            diCardVerifyCallback.onCallback(i, str);
        }
    }
}
