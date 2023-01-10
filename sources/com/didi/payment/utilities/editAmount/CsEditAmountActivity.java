package com.didi.payment.utilities.editAmount;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.didi.dcrypto.DCryptoMainFragment;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.MathUtil;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.commonsdk.p130ui.helper.NFloatInputHelper;
import com.didi.payment.commonsdk.utils.OmegaComParams;
import com.didi.payment.utilities.base.CsBaseActivity;
import com.didi.payment.utilities.details.CsBillDetailActivity;
import com.didi.payment.utilities.resp.CsGetBillResp;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.taxis99.R;
import java.io.Serializable;
import java.util.HashMap;

public class CsEditAmountActivity extends CsBaseActivity {
    public static final String ERROR_INFO = "error_info";
    public static final String MAX_VALUE_CENT = "max_value_cent";
    public static final String MIN_VALUE_CENT = "min_value_cent";

    /* renamed from: h */
    private static final int f34139h = 0;

    /* renamed from: i */
    private static final int f34140i = 1;

    /* renamed from: a */
    NFloatInputHelper f34141a = new NFloatInputHelper();

    /* renamed from: b */
    CsGetBillResp f34142b;

    /* renamed from: c */
    String f34143c = "";

    /* renamed from: d */
    private TextView f34144d;

    /* renamed from: e */
    private TextView f34145e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TextView f34146f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public AppCompatEditText f34147g;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public long f34148j = 100;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public long f34149k = 500000;

    public static void launch(Context context, long j, long j2, String str, CsGetBillResp csGetBillResp) {
        Intent intent = new Intent(context, CsEditAmountActivity.class);
        intent.putExtra(MAX_VALUE_CENT, j);
        intent.putExtra(MIN_VALUE_CENT, j2);
        intent.putExtra("data", csGetBillResp);
        intent.putExtra(ERROR_INFO, str);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.cs_activity_edit_amount_layout);
        m26025c();
        m26018a();
        m26027d();
    }

    /* renamed from: a */
    private void m26018a() {
        this.f34144d = (TextView) findViewById(R.id.tv_main_title);
        this.f34145e = (TextView) findViewById(R.id.tv_error_info);
        this.f34147g = (AppCompatEditText) findViewById(R.id.et_amount);
        TextView textView = (TextView) findViewById(R.id.tv_pay);
        this.f34146f = textView;
        textView.setEnabled(false);
        this.f34146f.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                CsEditAmountActivity.this.m26029e();
                if (CsEditAmountActivity.this.f34147g.getText() != null && CsEditAmountActivity.this.f34142b != null && CsEditAmountActivity.this.f34142b.data != null) {
                    long dollarToCent = (long) MathUtil.dollarToCent(CsEditAmountActivity.this.f34141a.parseFloatValue(CsEditAmountActivity.this.f34147g.getText().toString()));
                    double d = (double) dollarToCent;
                    CsEditAmountActivity.this.f34142b.data.amount = MathUtil.centToDollar(Double.valueOf(d * 1.0d));
                    CsEditAmountActivity.this.f34142b.data.amountCent = dollarToCent;
                    CsEditAmountActivity.this.f34142b.data.amountInDouble = d / 100.0d;
                    MetaData metaData = (MetaData) new Gson().fromJson(CsEditAmountActivity.this.f34142b.data.metadata, MetaData.class);
                    metaData.price = dollarToCent;
                    CsEditAmountActivity.this.f34142b.data.metadata = new Gson().toJson((Object) metaData);
                    CsBillDetailActivity.startActivity(CsEditAmountActivity.this.f34142b, CsEditAmountActivity.this.getContext(), OmegaComParams.BOLETO_EDIT_AMOUNT_PAGE);
                    CsEditAmountActivity.this.finish();
                }
            }
        });
        m26023b();
        m26019a(1);
    }

    /* renamed from: b */
    private void m26023b() {
        this.f34147g.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0) {
                    CsEditAmountActivity.this.m26019a(1);
                    CsEditAmountActivity.this.f34146f.setEnabled(false);
                    return;
                }
                String obj = editable.toString();
                if (CsEditAmountActivity.this.f34148j >= 100 && (obj.startsWith(".") || obj.startsWith(",") || obj.startsWith("0.") || obj.startsWith("0,"))) {
                    CsEditAmountActivity.this.f34146f.setEnabled(false);
                    CsEditAmountActivity.this.m26019a(0);
                } else if (obj.startsWith(DCryptoMainFragment.DCRYPTO_ZERO) || obj.startsWith("0,00")) {
                    CsEditAmountActivity.this.f34146f.setEnabled(false);
                    CsEditAmountActivity.this.m26019a(0);
                } else {
                    int dollarToCent = MathUtil.dollarToCent(CsEditAmountActivity.this.f34141a.parseFloatValue(obj));
                    long j = (long) dollarToCent;
                    if (j < CsEditAmountActivity.this.f34148j) {
                        CsEditAmountActivity.this.f34146f.setEnabled(false);
                        if (dollarToCent != 0) {
                            CsEditAmountActivity.this.m26019a(0);
                        }
                    } else if (j > CsEditAmountActivity.this.f34149k) {
                        CsEditAmountActivity.this.f34146f.setEnabled(false);
                        CsEditAmountActivity.this.m26019a(0);
                    } else {
                        CsEditAmountActivity.this.f34146f.setEnabled(true);
                        CsEditAmountActivity.this.m26019a(1);
                    }
                }
            }
        });
        this.f34147g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10), new NFloatInputHelper.NumberDecimalInputFilter(2, this.f34141a.decimalSeperatorBySys)});
    }

    /* renamed from: c */
    private void m26025c() {
        if (getIntent() != null) {
            this.f34149k = getIntent().getLongExtra(MAX_VALUE_CENT, 500000);
            this.f34148j = getIntent().getLongExtra(MIN_VALUE_CENT, 100);
            this.f34142b = (CsGetBillResp) getIntent().getSerializableExtra("data");
            this.f34143c = getIntent().getStringExtra(ERROR_INFO);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26019a(int i) {
        if (i == 0) {
            this.f34145e.setTextColor(Color.parseColor("#FF525D"));
        } else {
            this.f34145e.setTextColor(Color.parseColor("#919599"));
        }
        this.f34145e.setText(this.f34143c);
    }

    class MetaData implements Serializable {
        @SerializedName("currency")
        String currency;
        @SerializedName("price")
        long price;
        @SerializedName("sku")
        String sku;

        MetaData() {
        }
    }

    /* renamed from: d */
    private void m26027d() {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        hashMap.put("g_BizId", "Boleto");
        FinOmegaSDK.trackEvent("fin_boleto_billamt_sw", hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m26029e() {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        hashMap.put("g_BizId", "Boleto");
        FinOmegaSDK.trackEvent("fin_boleto_billamt_btn_ck", hashMap);
    }
}
