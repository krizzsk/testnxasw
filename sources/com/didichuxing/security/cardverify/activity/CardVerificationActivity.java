package com.didichuxing.security.cardverify.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dcrypto.DCryptoMainFragment;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.LEGODrawerDismissListener;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.security.cardverify.DiCardVerifyCallback;
import com.didichuxing.security.cardverify.DiCardVerifyParam;
import com.didichuxing.security.cardverify.contract.CreditCardVerifyContract;
import com.didichuxing.security.cardverify.model.CardVerifyInfo;
import com.didichuxing.security.cardverify.presenter.VerificationPresenter;
import com.didichuxing.security.cardverify.report.DiCardVerifyTracker;
import com.didichuxing.security.cardverify.utils.VerifyDialogUtil;
import com.didichuxing.security.cardverify.view.DecimalEditText;
import com.didichuxing.security.cardverify.view.MoneyEditTextContainer;
import com.google.gson.Gson;
import com.taxis99.R;
import java.lang.ref.WeakReference;

public class CardVerificationActivity extends CardVerifyBaseActivity implements CreditCardVerifyContract.IView {

    /* renamed from: a */
    private static final String f51445a = "KEY_INFO";

    /* renamed from: b */
    private static final String f51446b = "KEY_PARAM";
    public static DiCardVerifyCallback callback;

    /* renamed from: m */
    private static WeakReference<CardVerificationActivity> f51447m;

    /* renamed from: c */
    private ImageView f51448c;

    /* renamed from: d */
    private TextView f51449d;

    /* renamed from: e */
    private TextView f51450e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TextView f51451f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public DecimalEditText f51452g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TextView f51453h;

    /* renamed from: i */
    private VerificationPresenter f51454i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public CardVerifyInfo f51455j;

    /* renamed from: k */
    private DiCardVerifyParam f51456k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public LEGODrawer f51457l = null;

    public static void startActivity(Context context, DiCardVerifyParam diCardVerifyParam, CardVerifyInfo cardVerifyInfo, DiCardVerifyCallback diCardVerifyCallback) {
        callback = diCardVerifyCallback;
        Intent intent = new Intent();
        intent.setClass(context, CardVerificationActivity.class);
        intent.putExtra("KEY_PARAM", new Gson().toJson((Object) diCardVerifyParam));
        intent.putExtra(f51445a, cardVerifyInfo);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void onCardRemoved() {
        CardVerificationActivity cardVerificationActivity;
        WeakReference<CardVerificationActivity> weakReference = f51447m;
        if (weakReference != null && (cardVerificationActivity = (CardVerificationActivity) weakReference.get()) != null && !cardVerificationActivity.isFinishing()) {
            cardVerificationActivity.runOnUiThread(new Runnable(cardVerificationActivity) {
                final /* synthetic */ CardVerificationActivity val$activity;

                {
                    this.val$activity = r1;
                }

                public void run() {
                    this.val$activity.finish();
                }
            });
        }
    }

    public static void onRemoveCardFail(final String str) {
        CardVerificationActivity cardVerificationActivity;
        WeakReference<CardVerificationActivity> weakReference = f51447m;
        if (weakReference != null && (cardVerificationActivity = (CardVerificationActivity) weakReference.get()) != null && !cardVerificationActivity.isFinishing()) {
            cardVerificationActivity.runOnUiThread(new Runnable(cardVerificationActivity) {
                final /* synthetic */ CardVerificationActivity val$activity;

                {
                    this.val$activity = r1;
                }

                public void run() {
                    LEGOToastHelper.showShortNagToast(this.val$activity, str);
                    if (this.val$activity.f51457l != null && this.val$activity.f51457l.isShowing()) {
                        this.val$activity.f51457l.dismiss();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        f51447m = new WeakReference<>(this);
        setContentView((int) R.layout.didi_security_card_verify_activity_verify);
        if (m38510a()) {
            m38512b();
            return;
        }
        SystemUtils.log(3, "VerificationActivity", "onCreate: data is invalidate", (Throwable) null, "com.didichuxing.security.cardverify.activity.CardVerificationActivity", 118);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        callback = null;
        f51447m = null;
    }

    /* renamed from: a */
    private boolean m38510a() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f51455j = (CardVerifyInfo) intent.getSerializableExtra(f51445a);
            this.f51456k = (DiCardVerifyParam) new Gson().fromJson(intent.getStringExtra("KEY_PARAM"), DiCardVerifyParam.class);
            if (TextUtils.isEmpty(this.f51455j.defaultText)) {
                this.f51455j.defaultText = DCryptoMainFragment.DCRYPTO_ZERO;
            }
            this.f51454i = new VerificationPresenter(this, this.f51456k);
            return true;
        }
        this.f51454i = new VerificationPresenter(this, new DiCardVerifyParam.Builder(this).build());
        return false;
    }

    /* renamed from: b */
    private void m38512b() {
        this.f51448c = (ImageView) findViewById(R.id.iv_close);
        this.f51449d = (TextView) findViewById(R.id.tv_remove);
        this.f51450e = (TextView) findViewById(R.id.tv_content);
        if (this.f51455j.isCurrencySuffix) {
            this.f51451f = (TextView) findViewById(R.id.suffix_verify_tv_currency);
        } else {
            this.f51451f = (TextView) findViewById(R.id.prefix_verify_tv_currency);
        }
        DecimalEditText decimalEditText = (DecimalEditText) findViewById(R.id.et_money);
        this.f51452g = decimalEditText;
        decimalEditText.setHint(this.f51455j.defaultText);
        TextView textView = (TextView) findViewById(R.id.btn_commit);
        this.f51453h = textView;
        textView.setEnabled(false);
        this.f51452g.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    CardVerificationActivity.this.f51452g.setHint("");
                    CardVerificationActivity.this.f51453h.setEnabled(true);
                    CardVerificationActivity.this.f51451f.setVisibility(0);
                    return;
                }
                CardVerificationActivity.this.f51452g.setHint(CardVerificationActivity.this.f51455j.defaultText);
                CardVerificationActivity.this.f51453h.setEnabled(false);
                CardVerificationActivity.this.f51451f.setVisibility(8);
            }
        });
        if (!this.f51455j.isShowDecimal) {
            this.f51452g.setDecimalNumber(0);
        }
        this.f51448c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CardVerificationActivity.this.onBackPressed();
            }
        });
        this.f51449d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CardVerificationActivity.this.m38518e();
            }
        });
        this.f51453h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CardVerificationActivity.this.m38516d();
            }
        });
        ((MoneyEditTextContainer) findViewById(R.id.input_ll)).setTouchEventListener(new MoneyEditTextContainer.OnTouchEventListener() {
            public void onDown() {
                CardVerificationActivity cardVerificationActivity = CardVerificationActivity.this;
                cardVerificationActivity.m38506a((View) cardVerificationActivity.f51452g, CardVerificationActivity.this.getContext());
            }
        });
        this.f51450e.setText(this.f51455j.pageContent);
        this.f51451f.setText(this.f51455j.currencyText);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38506a(View view, Context context) {
        InputMethodManager inputMethodManager;
        if (view.requestFocus() && (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) != null) {
            inputMethodManager.showSoftInput(view, 1);
        }
    }

    public void onVerifySuccess() {
        DiCardVerifyTracker.trackVerifySucceed();
        m38507a(callback, 0, "verify success");
        finish();
    }

    public void onVerifyFailure() {
        DiCardVerifyTracker.trackVerifyFailed();
    }

    public void onVerifyMultiFailure(final String str, final String str2) {
        DiCardVerifyTracker.trackVerifyFailed();
        LEGODrawer lEGODrawer = this.f51457l;
        if (lEGODrawer == null || !lEGODrawer.isShowing()) {
            this.f51457l = m38505a(str, str2);
            return;
        }
        this.f51457l.setDismissListener(new LEGODrawerDismissListener() {
            public void onDismiss() {
                CardVerificationActivity cardVerificationActivity = CardVerificationActivity.this;
                LEGODrawer unused = cardVerificationActivity.f51457l = cardVerificationActivity.m38505a(str, str2);
            }
        });
        this.f51457l.dismiss();
    }

    public void onVerifyException() {
        DiCardVerifyTracker.trackVerifyFailed();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public LEGODrawer m38505a(String str, final String str2) {
        return VerifyDialogUtil.showVerifyFailureDialog(this, str, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CardVerificationActivity.this.finish();
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CardVerificationActivity.this.m38507a(CardVerificationActivity.callback, 4, TextUtils.isEmpty(str2) ? CardVerificationActivity.this.m38514c() : str2);
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (CardVerificationActivity.this.f51457l != null && CardVerificationActivity.this.f51457l.isShowing()) {
                    CardVerificationActivity.this.f51457l.dismiss();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public String m38514c() {
        return (TextUtils.isEmpty(this.f51456k.getCountry()) || !this.f51456k.getCountry().toUpperCase().contains("BR")) ? "https://help.didiglobal.com/passenger-index.html?source=app_globalck_home" : "https://help.99taxis.mobi/static/index.html?source=app_brck_home";
    }

    public void onBackPressed() {
        finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m38516d() {
        DiCardVerifyTracker.trackVerifyCk();
        String trim = this.f51452g.getText().toString().trim();
        if (trim.lastIndexOf(46) == trim.length() - 1) {
            trim = trim.substring(0, trim.length() - 1);
        }
        this.f51454i.verifyCard(trim, this.f51456k.getPhone());
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m38518e() {
        LEGODrawer lEGODrawer = this.f51457l;
        if (lEGODrawer == null || !lEGODrawer.isShowing()) {
            this.f51457l = m38519f();
            return;
        }
        this.f51457l.setDismissListener(new LEGODrawerDismissListener() {
            public void onDismiss() {
                CardVerificationActivity cardVerificationActivity = CardVerificationActivity.this;
                LEGODrawer unused = cardVerificationActivity.f51457l = cardVerificationActivity.m38519f();
            }
        });
        this.f51457l.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public LEGODrawer m38519f() {
        return VerifyDialogUtil.showCancelSignConfirmDialog(this, getString(R.string.didi_security_card_verify_dialog_remove_card_content), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (CardVerificationActivity.this.f51457l != null) {
                    CardVerificationActivity.this.f51457l.showLoading();
                }
                CardVerificationActivity.this.m38507a(CardVerificationActivity.callback, 3, "remove card");
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (CardVerificationActivity.this.f51457l != null) {
                    CardVerificationActivity.this.f51457l.dismiss();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38507a(DiCardVerifyCallback diCardVerifyCallback, int i, String str) {
        if (diCardVerifyCallback != null) {
            diCardVerifyCallback.onCallback(i, str);
        }
    }

    public void finish() {
        LEGODrawer lEGODrawer = this.f51457l;
        if (lEGODrawer == null || !lEGODrawer.isShowing()) {
            super.finish();
            return;
        }
        this.f51457l.setDismissListener(new LEGODrawerDismissListener() {
            public void onDismiss() {
                CardVerificationActivity.super.finish();
            }
        });
        this.f51457l.dismiss();
    }
}
