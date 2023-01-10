package com.didi.payment.creditcard.global.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.drawer.GGKDrawer;
import com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel1;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;
import com.didi.payment.base.dialog.GGKUICreatorWithThemeCheck;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.creditcard.global.contract.CreditCardDetailContract;
import com.didi.payment.creditcard.global.model.CancelCardParam;
import com.didi.payment.creditcard.global.omega.GlobalOmegaUtils;
import com.didi.payment.creditcard.global.presenter.GlobalCreditCardDetailPresenter;
import com.didi.payment.creditcard.global.utils.GlobalCreditPayTipDialogFragment;
import com.didi.payment.creditcard.global.utils.GlobalDialogUtil;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.app.constant.Const;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.taxis99.R;
import org.json.JSONObject;

public class GlobalCreditCardDetailActivity extends GlobalBaseActivity implements CreditCardDetailContract.IView {
    public static final int REQ_CODE_UPDATE_CARD = 6;

    /* renamed from: a */
    private static final String f32802a = "param";

    /* renamed from: b */
    private TextView f32803b;

    /* renamed from: c */
    private ImageView f32804c;

    /* renamed from: d */
    private TextView f32805d;

    /* renamed from: e */
    private TextView f32806e;

    /* renamed from: f */
    private TextView f32807f;

    /* renamed from: g */
    private TextView f32808g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public FragmentActivity f32809h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public CancelCardParam f32810i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public GlobalCreditCardDetailPresenter f32811j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public GGKDrawer f32812k;

    public static void launch(Activity activity, int i, CancelCardParam cancelCardParam) {
        Intent intent = new Intent(activity, GlobalCreditCardDetailActivity.class);
        intent.putExtra("param", cancelCardParam);
        activity.startActivityForResult(intent, i);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.one_payment_creditcard_global_activity_credit_card_detail);
        this.f32809h = this;
        m24924a();
        m24930c();
        GlobalOmegaUtils.trackCardDetailPageSW(this);
    }

    /* renamed from: a */
    private void m24924a() {
        this.f32810i = (CancelCardParam) getIntent().getSerializableExtra("param");
        this.f32811j = new GlobalCreditCardDetailPresenter(this);
    }

    /* renamed from: b */
    private void m24928b() {
        this.f32803b = (TextView) findViewById(R.id.tv_title);
        this.f32804c = (ImageView) findViewById(R.id.iv_left);
        this.f32805d = (TextView) findViewById(R.id.tv_right);
        this.f32803b.setText(getString(R.string.one_payment_creditcard_global_detail_page_title));
        this.f32804c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditCardDetailActivity.this.onBackPressed();
                GlobalOmegaUtils.trackCardDetailPageReturnCk(GlobalCreditCardDetailActivity.this);
            }
        });
        this.f32805d.setText(getString(R.string.one_payment_creditcard_global_detail_page_remove_btn));
        this.f32805d.setVisibility(0);
        this.f32805d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (GlobalCreditCardDetailActivity.this.f32810i != null) {
                    GlobalCreditCardDetailActivity.this.f32811j.checkCard(150, GlobalCreditCardDetailActivity.this.f32810i.cardIndex);
                }
                GlobalOmegaUtils.trackCardDetailPageRemoveCk(GlobalCreditCardDetailActivity.this);
            }
        });
    }

    /* renamed from: c */
    private void m24930c() {
        m24928b();
        this.f32806e = (TextView) findViewById(R.id.tv_card_number);
        this.f32807f = (TextView) findViewById(R.id.tv_expired_date);
        this.f32808g = (TextView) findViewById(R.id.tv_update);
        CancelCardParam cancelCardParam = this.f32810i;
        if (cancelCardParam != null) {
            String str = cancelCardParam.cardNo;
            if (!TextUtils.isEmpty(str) && str.length() >= 4) {
                str = str.substring(str.length() - 4);
            }
            this.f32806e.setText(str);
            this.f32807f.setText(this.f32810i.expiryDate);
            if (this.f32810i.expired == 1) {
                this.f32808g.setVisibility(0);
                this.f32808g.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (GlobalCreditCardDetailActivity.this.f32810i != null) {
                            GlobalCreditCardDetailPresenter b = GlobalCreditCardDetailActivity.this.f32811j;
                            GlobalCreditCardDetailActivity globalCreditCardDetailActivity = GlobalCreditCardDetailActivity.this;
                            b.updateCard(globalCreditCardDetailActivity, globalCreditCardDetailActivity.f32810i.cardNo, GlobalCreditCardDetailActivity.this.f32810i.resourceId);
                        }
                    }
                });
            } else {
                this.f32808g.setVisibility(8);
            }
            if (this.f32810i.expired == 1) {
                findViewById(R.id.rl_expired_layout).setBackgroundResource(R.drawable.one_payment_creditcard_global_bg_card_detail_expired);
                ((ImageView) findViewById(R.id.iv_card_icon)).setImageResource(R.drawable.one_payment_creditcard_global_icon_credit_card_expired);
            }
        }
    }

    public void showCancelSignConfirmDialog() {
        GlobalDialogUtil.showCancelSignConfirmDialog(this, getString(R.string.one_payment_creditcard_global_detail_page_dialog_remove_card_content), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (GlobalCreditCardDetailActivity.this.f32810i != null) {
                    GlobalCreditCardDetailActivity.this.f32811j.removeCard(150, GlobalCreditCardDetailActivity.this.f32810i.cardIndex);
                }
                GlobalOmegaUtils.trackCardDetailPageRemoveOKCk(GlobalCreditCardDetailActivity.this);
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackCardDetailPageRemoveCancelCk(GlobalCreditCardDetailActivity.this);
            }
        });
    }

    public void showInvalidCancelDialog(String str) {
        GGKDrawerModel1 gGKDrawerModel1 = new GGKDrawerModel1("", new GGKBtnTextAndCallback(getString(R.string.pay_base_confirm), new GGKOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (GlobalCreditCardDetailActivity.this.f32812k != null) {
                    GlobalCreditCardDetailActivity.this.f32812k.dismiss();
                }
            }
        }));
        gGKDrawerModel1.setSubTitle(str);
        this.f32812k = GGKUICreatorWithThemeCheck.showDrawerModel(this, gGKDrawerModel1);
    }

    public void onCancelSignSuccess() {
        setResult(-1);
        finish();
        overridePendingTransition(R.anim.one_payment_creditcard_in_from_left, R.anim.one_payment_creditcard_out_to_right);
    }

    public void showPayTipDialog(String str, String str2, String str3, String str4, String str5, String str6) {
        final String a = m24923a(str3);
        final String str7 = str4;
        final String str8 = str5;
        final String str9 = str6;
        GlobalDialogUtil.showPayTipDialog(this.f32809h, str, str2, new GlobalCreditPayTipDialogFragment.PayTipDialogEventListener() {
            public void onNegativeClick() {
            }

            public void onPositiveClick() {
                GlobalCreditCardDetailActivity.this.m24926a(str7, str8, str9);
            }

            public void onFaqClick() {
                WebBrowserUtil.startInternalWebActivity(GlobalCreditCardDetailActivity.this.f32809h, a, "");
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24926a(String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setAction("com.didi.global.unifiedPay.entrance");
        intent.setPackage(getPackageName());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Const.PayParams.OUT_TRADE_ID, str);
            jSONObject.put("oid", str2);
            jSONObject.put("sid", str3);
            Bundle bundle = new Bundle();
            bundle.putSerializable("uni_pay_param", jSONObject.toString());
            intent.putExtras(bundle);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private String m24923a(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (!str.contains("token")) {
            str2 = str2 + "&token=" + PayBaseParamUtil.getStringParam(this, "token");
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        if (str.contains("?")) {
            return str + str2;
        }
        return str + str2.replaceFirst(ParamKeys.SIGN_AND, "?");
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 6 && i2 == -1) {
            setResult(-1);
            finish();
        }
    }
}
