package com.didi.payment.creditcard.global.activity;

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
import androidx.fragment.app.Fragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dcrypto.DCryptoMainFragment;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.creditcard.global.contract.CreditCardVerifyContract;
import com.didi.payment.creditcard.global.model.GlobalCardVerifyInfo;
import com.didi.payment.creditcard.global.omega.GlobalOmegaUtils;
import com.didi.payment.creditcard.global.presenter.GlobalVerificationPresenter;
import com.didi.payment.creditcard.global.utils.GlobalDialogUtil;
import com.didi.payment.creditcard.global.widget.DecimalEditText;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class GlobalCreditCardVerificationActivity extends GlobalBaseActivity implements CreditCardVerifyContract.IView {

    /* renamed from: a */
    private static final String f32813a = "RESULT_KEY_TYPE";

    /* renamed from: b */
    private static final int f32814b = 1;

    /* renamed from: c */
    private static final int f32815c = 2;

    /* renamed from: d */
    private static final String f32816d = "KEY_INFO";

    /* renamed from: e */
    private ImageView f32817e;

    /* renamed from: f */
    private TextView f32818f;

    /* renamed from: g */
    private TextView f32819g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TextView f32820h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public DecimalEditText f32821i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public TextView f32822j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public GlobalVerificationPresenter f32823k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public GlobalCardVerifyInfo f32824l;

    public void onVerifyFailure() {
    }

    public static void startActivityForResult(Activity activity, int i, GlobalCardVerifyInfo globalCardVerifyInfo) {
        Intent intent = new Intent();
        intent.setClass(activity, GlobalCreditCardVerificationActivity.class);
        intent.putExtra(f32816d, globalCardVerifyInfo);
        activity.startActivityForResult(intent, i);
    }

    public static void startActivityForResult(Fragment fragment, int i, GlobalCardVerifyInfo globalCardVerifyInfo) {
        Intent intent = new Intent();
        intent.setClass(fragment.getActivity(), GlobalCreditCardVerificationActivity.class);
        intent.putExtra(f32816d, globalCardVerifyInfo);
        fragment.startActivityForResult(intent, i);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.one_payment_creditcard_global_activity_verify);
        if (m24937a()) {
            m24939b();
            return;
        }
        SystemUtils.log(3, "VerificationActivity", "onCreate: data is invalidate", (Throwable) null, "com.didi.payment.creditcard.global.activity.GlobalCreditCardVerificationActivity", 75);
        finish();
    }

    /* renamed from: a */
    private boolean m24937a() {
        this.f32823k = new GlobalVerificationPresenter(this);
        Intent intent = getIntent();
        if (intent == null) {
            return false;
        }
        GlobalCardVerifyInfo globalCardVerifyInfo = (GlobalCardVerifyInfo) intent.getSerializableExtra(f32816d);
        this.f32824l = globalCardVerifyInfo;
        if (!TextUtils.isEmpty(globalCardVerifyInfo.defaultText)) {
            return true;
        }
        this.f32824l.defaultText = DCryptoMainFragment.DCRYPTO_ZERO;
        return true;
    }

    /* renamed from: b */
    private void m24939b() {
        this.f32817e = (ImageView) findViewById(R.id.iv_close);
        this.f32818f = (TextView) findViewById(R.id.tv_remove);
        this.f32819g = (TextView) findViewById(R.id.tv_content);
        if (this.f32824l.isCurrencySuffix) {
            this.f32820h = (TextView) findViewById(R.id.suffix_verify_tv_currency);
        } else {
            this.f32820h = (TextView) findViewById(R.id.prefix_verify_tv_currency);
        }
        DecimalEditText decimalEditText = (DecimalEditText) findViewById(R.id.et_money);
        this.f32821i = decimalEditText;
        decimalEditText.setHint(this.f32824l.defaultText);
        TextView textView = (TextView) findViewById(R.id.btn_commit);
        this.f32822j = textView;
        textView.setEnabled(false);
        this.f32821i.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    GlobalCreditCardVerificationActivity.this.f32822j.setEnabled(true);
                    GlobalCreditCardVerificationActivity.this.f32820h.setVisibility(0);
                    GlobalCreditCardVerificationActivity.this.f32821i.setWidth((int) GlobalCreditCardVerificationActivity.this.f32821i.getPaint().measureText(editable.toString()));
                    return;
                }
                GlobalCreditCardVerificationActivity.this.f32822j.setEnabled(false);
                GlobalCreditCardVerificationActivity.this.f32820h.setVisibility(8);
                GlobalCreditCardVerificationActivity.this.f32821i.setWidth((int) GlobalCreditCardVerificationActivity.this.f32821i.getPaint().measureText(GlobalCreditCardVerificationActivity.this.f32824l.defaultText));
            }
        });
        if (!this.f32824l.isShowDecimal) {
            this.f32821i.setDecimalNumber(0);
        }
        this.f32817e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditCardVerificationActivity.this.onBackPressed();
            }
        });
        this.f32818f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditCardVerificationActivity.this.m24943d();
            }
        });
        this.f32822j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditCardVerificationActivity.this.m24941c();
            }
        });
        findViewById(R.id.input_ll).setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                GlobalCreditCardVerificationActivity globalCreditCardVerificationActivity = GlobalCreditCardVerificationActivity.this;
                globalCreditCardVerificationActivity.m24933a((View) globalCreditCardVerificationActivity.f32821i, GlobalCreditCardVerificationActivity.this.getContext());
                return false;
            }
        });
        this.f32819g.setText(this.f32824l.pageContent);
        this.f32820h.setText(this.f32824l.currencyText);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24933a(View view, Context context) {
        InputMethodManager inputMethodManager;
        if (view.requestFocus() && (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) != null) {
            inputMethodManager.showSoftInput(view, 1);
        }
    }

    public void onCancelSignSuccess() {
        Intent intent = new Intent();
        intent.putExtra(f32813a, 2);
        setResult(-1, intent);
        finish();
    }

    public void onVerifySuccess() {
        Intent intent = new Intent();
        intent.putExtra(f32813a, 1);
        setResult(-1, intent);
        finish();
    }

    public void onVerifyMultiFailure(String str, final String str2) {
        GlobalDialogUtil.showVerifyFailureDialog(this, str, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditCardVerificationActivity.this.setResult(0);
                GlobalCreditCardVerificationActivity.this.finish();
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditCardVerificationActivity.this.m24936a(str2);
                GlobalCreditCardVerificationActivity.this.setResult(0);
                GlobalCreditCardVerificationActivity.this.finish();
            }
        });
    }

    public void onBackPressed() {
        setResult(0);
        finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m24941c() {
        this.f32823k.verifyCard(this.f32821i.getText().toString().trim(), this.f32824l.cardIndex, this.f32824l.productId);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24936a(String str) {
        if (TextUtils.isEmpty(str)) {
            String stringParam = PayBaseParamUtil.getStringParam(getContext(), "country");
            str = (TextUtils.isEmpty(stringParam) || !stringParam.toUpperCase().contains("BR")) ? "https://help.didiglobal.com/passenger-index.html?source=app_globalck_home" : "https://help.99taxis.mobi/static/index.html?source=app_brck_home";
        }
        WebBrowserUtil.startInternalWebActivity(this, str, "");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m24943d() {
        GlobalDialogUtil.showCancelSignConfirmDialog(this, getString(R.string.one_payment_creditcard_global_detail_page_dialog_remove_card_content), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditCardVerificationActivity.this.f32823k.removeCard(GlobalCreditCardVerificationActivity.this.f32824l.cardIndex);
                GlobalOmegaUtils.trackCardDetailPageRemoveOKCk(GlobalCreditCardVerificationActivity.this);
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackCardDetailPageRemoveCancelCk(GlobalCreditCardVerificationActivity.this);
            }
        });
    }
}
