package com.didi.payment.wallet.global.wallet.view.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.dcrypto.DCryptoMainFragment;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.commonsdk.p130ui.helper.NFloatInputHelper;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.creditcard.global.utils.InputTools;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.payment.wallet.global.exts.CurrencyUtils;
import com.didi.payment.wallet.global.model.resp.QueryNightlyLimitSettingResp;
import com.didi.payment.wallet.global.wallet.contract.WalletNightlyLimitContract;
import com.didi.payment.wallet.global.wallet.presenter.WalletNightlyLimitPresenter;
import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.pay.paysecure.omega.OmegaUtilKt;
import com.taxis99.R;
import java.text.DecimalFormat;
import java.util.HashMap;

public class WalletNightlyLimitActivity extends WalletBaseActivity implements WalletNightlyLimitContract.IView {

    /* renamed from: a */
    private View f34712a;

    /* renamed from: b */
    private View f34713b;

    /* renamed from: c */
    private ImageView f34714c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public EditText f34715d;

    /* renamed from: e */
    private TextView f34716e;

    /* renamed from: f */
    private TextView f34717f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextView f34718g;

    /* renamed from: h */
    private View f34719h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public View f34720i;

    /* renamed from: j */
    private View f34721j;

    /* renamed from: k */
    private DecimalFormat f34722k = new DecimalFormat(DCryptoMainFragment.DCRYPTO_ZERO);

    /* renamed from: l */
    private float f34723l = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public float f34724m = 20000.0f;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public WalletNightlyLimitContract.IPresenter f34725n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public QueryNightlyLimitSettingResp.QueryNightlyLimitSettingVo f34726o;

    /* renamed from: p */
    private String f34727p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public NFloatInputHelper f34728q;

    public static void start(Context context) {
        context.startActivity(new Intent(context, WalletNightlyLimitActivity.class));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.f34727p = intent.getStringExtra("pageFrom");
        }
        setContentView((int) R.layout.wallet_global_activity_nightly_limit);
        this.f34725n = new WalletNightlyLimitPresenter(this, this);
        this.f34712a = findViewById(R.id.layout_title_bar);
        this.f34715d = (EditText) findViewById(R.id.et_amount);
        this.f34719h = findViewById(R.id.ll_input);
        this.f34720i = findViewById(R.id.ll_empty);
        this.f34721j = findViewById(R.id.nsv_content);
        TextView textView = (TextView) findViewById(R.id.tv_limit_range);
        this.f34716e = textView;
        textView.setText(getString(R.string.GRider_limit_Limit_range_VIcO, new Object[]{"R$" + CurrencyUtils.currencyFormat(Float.valueOf(this.f34723l), getResources().getConfiguration().locale), "R$" + CurrencyUtils.currencyFormat(Float.valueOf(this.f34724m), getResources().getConfiguration().locale)}));
        this.f34717f = (TextView) findViewById(R.id.tv_currency);
        this.f34718g = (TextView) findViewById(R.id.tv_confirm);
        this.f34713b = findViewById(R.id.iv_left);
        this.f34714c = (ImageView) findViewById(R.id.iv_right);
        this.f34712a.setBackground((Drawable) null);
        this.f34720i.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                WalletNightlyLimitActivity.this.f34720i.setVisibility(8);
                WalletNightlyLimitActivity.this.f34725n.requestData();
            }
        });
        this.f34719h.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                InputTools.showKeyboard(WalletNightlyLimitActivity.this.f34715d);
            }
        });
        this.f34713b.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                PayTracker.getTracker().trackEvent("ibt_cash_out_limit_setting_night_transfer_limit_page_ex");
                WalletNightlyLimitActivity.this.finish();
            }
        });
        this.f34714c.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                PayTracker.getTracker().trackEvent("ibt_cash_out_limit_setting_night_transfer_limit_page_faq_ck");
                WebBrowserUtil.startInternalWebActivity(WalletNightlyLimitActivity.this, WalletConstant.URL.H5_NIGHTLY_LIMIT_HELP, "");
            }
        });
        NFloatInputHelper nFloatInputHelper = new NFloatInputHelper();
        this.f34728q = nFloatInputHelper;
        this.f34715d.setFilters(new InputFilter[]{new NFloatInputHelper.NumberDecimalInputFilter(2, nFloatInputHelper.decimalSeperatorBySys), new InputFilter.LengthFilter(10)});
        this.f34715d.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    try {
                        if (editable.length() != 0) {
                            float parseFloatValue = WalletNightlyLimitActivity.this.f34728q.parseFloatValue(editable.toString());
                            if (parseFloatValue <= WalletNightlyLimitActivity.this.f34724m) {
                                WalletNightlyLimitActivity.this.m26519a(parseFloatValue);
                                return;
                            } else {
                                WalletNightlyLimitActivity.this.m26522a(Float.valueOf(parseFloatValue), WalletNightlyLimitActivity.this.f34724m);
                                return;
                            }
                        }
                    } catch (Exception unused) {
                        return;
                    }
                }
                WalletNightlyLimitActivity.this.f34718g.setEnabled(false);
            }
        });
        this.f34718g.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                String obj = WalletNightlyLimitActivity.this.f34715d.getText().toString();
                HashMap hashMap = new HashMap();
                hashMap.put("confirm_limit_amount", obj);
                PayTracker.getTracker().trackEvent("ibt_cash_out_limit_setting_night_transfer_limit_confirm_ck", hashMap);
                if (TextUtils.isEmpty(obj)) {
                    obj = "0";
                }
                long j = 0;
                try {
                    if (WalletNightlyLimitActivity.this.f34726o != null) {
                        j = WalletNightlyLimitActivity.this.f34726o.limitInEffective;
                    }
                    WalletNightlyLimitActivity.this.f34725n.submit(j, CurrencyUtils.dollarToCents(Float.valueOf(WalletNightlyLimitActivity.this.f34728q.parseFloatValue(obj))));
                } catch (Exception unused) {
                }
            }
        });
        initLoadingDialog(this, R.id.layout_title_bar);
        this.f34725n.requestData();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26519a(float f) {
        this.f34716e.setTextColor(-16777216);
        long dollarToCents = CurrencyUtils.dollarToCents(Float.valueOf(f));
        QueryNightlyLimitSettingResp.QueryNightlyLimitSettingVo queryNightlyLimitSettingVo = this.f34726o;
        boolean z = true;
        if (queryNightlyLimitSettingVo != null) {
            TextView textView = this.f34718g;
            if (Double.compare((double) queryNightlyLimitSettingVo.limitInEffective, (double) dollarToCents) == 0) {
                z = false;
            }
            textView.setEnabled(z);
            return;
        }
        this.f34718g.setEnabled(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26522a(Float f, float f2) {
        if (f != null && f.floatValue() > f2) {
            HashMap hashMap = new HashMap();
            hashMap.put("beyond_limit_amount", f);
            PayTracker.getTracker().trackEvent("ibt_cash_out_limit_setting_night_transfer_limit_amount_bt", hashMap);
            this.f34716e.setTextColor(-65536);
        }
        this.f34718g.setEnabled(false);
    }

    public void onNetworkError() {
        this.f34720i.setVisibility(0);
        this.f34721j.setVisibility(8);
    }

    public void showSettingLimit(QueryNightlyLimitSettingResp.QueryNightlyLimitSettingVo queryNightlyLimitSettingVo) {
        this.f34726o = queryNightlyLimitSettingVo;
        if (!TextUtils.isEmpty(queryNightlyLimitSettingVo.effectiveTime)) {
            WalletChangeLimitResultActivity.start(this, queryNightlyLimitSettingVo);
            finish();
            return;
        }
        this.f34720i.setVisibility(8);
        int i = 0;
        this.f34721j.setVisibility(0);
        HashMap hashMap = new HashMap();
        hashMap.put(OmegaUtilKt.ENTRANCE_PAGE_ID, this.f34727p);
        PayTracker.getTracker().trackEvent("ibt_cash_out_limit_setting_night_transfer_limit_page_sw", hashMap);
        this.f34715d.setText(CurrencyUtils.currencyFormat(CurrencyUtils.centToDollar(Long.valueOf(queryNightlyLimitSettingVo.limitInEffective)), this.f34722k));
        InputTools.showKeyboard(this.f34715d);
        Editable text = this.f34715d.getText();
        if (text != null) {
            i = text.length();
        }
        this.f34715d.setSelection(i);
    }

    public void onChangeSuccess(QueryNightlyLimitSettingResp.QueryNightlyLimitSettingVo queryNightlyLimitSettingVo) {
        WalletChangeLimitResultActivity.start(this, queryNightlyLimitSettingVo);
        Intent intent = new Intent();
        String str = queryNightlyLimitSettingVo.effectiveTime;
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("effectiveTime", str);
        }
        setResult(-1, intent);
        finish();
    }

    public void onChangeFailed(String str) {
        if (!TextUtils.isEmpty(str)) {
            WalletToastNew.showFailedMsg(getContext(), str);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f34725n.destroy();
        super.onDestroy();
    }
}
