package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.dialog.VerifyDialogFragment;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.view.PayBaseToast;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelResp;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.contract.WalletBoletoCashinContract;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model.WalletBoletoResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.presenter.WalletBoletoCashinPresenter;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.widget.BrazilDecimalEditText;
import com.didi.payment.wallet.global.utils.TextViewUtils;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.wallet.view.activity.WalletBaseActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;

public class WalletBoletoCashinActivity extends WalletBaseActivity implements WalletBoletoCashinContract.View {

    /* renamed from: a */
    RelativeLayout f34490a;

    /* renamed from: b */
    ImageView f34491b;

    /* renamed from: c */
    TextView f34492c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public WalletBoletoCashinContract.Presenter f34493d;

    /* renamed from: e */
    private RelativeLayout f34494e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public BrazilDecimalEditText f34495f;

    /* renamed from: g */
    private ImageView f34496g;

    /* renamed from: h */
    private TextView f34497h;

    /* renamed from: i */
    private TextView f34498i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public WalletTopUpChannelResp.ChannelExtraData f34499j = null;

    /* renamed from: a */
    private void m26296a(EditText editText) {
    }

    public void onNetworkError() {
    }

    public static void launch(Context context) {
        Intent intent = new Intent(context, WalletBoletoCashinActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void launch(Context context, WalletTopUpChannelResp.ChannelExtraData channelExtraData) {
        Intent intent = new Intent(context, WalletBoletoCashinActivity.class);
        intent.putExtra("extraData", channelExtraData);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.wallet_global_activity_boleto_cashin_regular);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f34499j = (WalletTopUpChannelResp.ChannelExtraData) extras.getSerializable("extraData");
        }
        m26295a();
        m26307h();
        this.f34493d = new WalletBoletoCashinPresenter(this, this, this);
        GlobalOmegaUtils.trackBoletoCashinPageSW();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        initLoadingDialog(this, R.id.wallet_balance_top_up_boleto_regular_title_bar);
    }

    /* renamed from: a */
    private void m26295a() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.wallet_balance_top_up_boleto_regular_title_bar);
        this.f34490a = relativeLayout;
        this.f34491b = (ImageView) relativeLayout.findViewById(R.id.iv_left);
        this.f34492c = (TextView) this.f34490a.findViewById(R.id.tv_title);
        this.f34494e = (RelativeLayout) findViewById(R.id.rl_wallet_balance_boleto_cashin_history_entry);
        this.f34495f = (BrazilDecimalEditText) findViewById(R.id.et_wallet_boleto_cashin_regular_amount);
        ImageView imageView = (ImageView) findViewById(R.id.tv_wallet_boleto_cashin_amount_delete_btn);
        this.f34496g = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletBoletoCashinActivity.this.f34495f.setText("");
            }
        });
        this.f34497h = (TextView) findViewById(R.id.tv_wallet_boleto_cashin_minimum_amount);
        this.f34498i = (TextView) findViewById(R.id.btn_wallet_boleto_cashin_regular_generate);
    }

    public void updateUIAfterEditTextChanged() {
        this.f34495f.setTextColor(ResourcesCompat.getColor(getResources(), R.color.black, getTheme()));
        m26302c();
        m26303d();
        m26300b();
    }

    /* renamed from: b */
    private void m26300b() {
        if (m26305f() || m26306g()) {
            this.f34497h.setTextColor(ResourcesCompat.getColor(getResources(), R.color.wallet_boleto_cashin_tv_min_value_default, getTheme()));
        } else {
            this.f34497h.setTextColor(ResourcesCompat.getColor(getResources(), R.color.wallet_boleto_cashin_tv_min_value_red, getTheme()));
        }
    }

    /* renamed from: c */
    private void m26302c() {
        if (!m26305f()) {
            this.f34496g.setVisibility(0);
        } else {
            this.f34496g.setVisibility(8);
        }
    }

    /* renamed from: d */
    private void m26303d() {
        if (m26304e()) {
            this.f34498i.setEnabled(true);
        } else {
            this.f34498i.setEnabled(false);
        }
    }

    /* renamed from: e */
    private boolean m26304e() {
        return !m26305f() && m26306g();
    }

    /* renamed from: f */
    private boolean m26305f() {
        return TextUtils.isEmpty(BrazilDecimalEditText.trimStringToNormalDecimalFormat(this.f34495f.getText().toString()));
    }

    /* renamed from: g */
    private boolean m26306g() {
        String trimStringToNormalDecimalFormat = BrazilDecimalEditText.trimStringToNormalDecimalFormat(this.f34495f.getText().toString());
        return (TextUtils.isEmpty(trimStringToNormalDecimalFormat) ? 0.0d : Double.parseDouble(trimStringToNormalDecimalFormat)) >= 7.0d;
    }

    /* renamed from: h */
    private void m26307h() {
        this.f34491b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletBoletoCashinActivity.this.finish();
            }
        });
        this.f34494e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackBoletoCashinHistoryPageCK();
                WalletRouter.gotoBoletoHistoryPage(WalletBoletoCashinActivity.this);
            }
        });
        this.f34498i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackBoletoCashinBtnCK();
                long parseDouble = (long) (Double.parseDouble(BrazilDecimalEditText.trimStringToNormalDecimalFormat(WalletBoletoCashinActivity.this.f34495f.getText().toString())) * 100.0d);
                if (parseDouble < 700) {
                    try {
                        WalletBoletoCashinActivity.this.f34495f.setText("");
                        PayBaseToast.showInfo((Context) WalletBoletoCashinActivity.this, (int) R.string.wallet_boleto_cashin_minimum_amount);
                    } catch (Exception unused) {
                    }
                } else if (WalletBoletoCashinActivity.this.f34499j == null || parseDouble <= ((long) Integer.parseInt(WalletBoletoCashinActivity.this.f34499j.maximumAmount))) {
                    WalletBoletoCashinActivity.this.f34493d.submitBoleto(Long.valueOf(parseDouble));
                } else {
                    WalletBoletoCashinActivity.this.m26298a(WalletBoletoCashinActivity.this.f34499j.dialog.title, WalletBoletoCashinActivity.this.f34499j.dialog.desc, WalletBoletoCashinActivity.this.f34499j.dialog.kycLink);
                }
            }
        });
        WalletTopUpChannelResp.ChannelExtraData channelExtraData = this.f34499j;
        if (channelExtraData != null) {
            TextViewUtils.appendDrawableLast(this.f34497h, channelExtraData.inputAmountRuleText, R.drawable.common_main_list_right_arrow_icon);
            this.f34497h.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    WebBrowserUtil.startInternalWebActivity(WalletBoletoCashinActivity.this.getContext(), WalletBoletoCashinActivity.this.f34499j.link, "");
                }
            });
            return;
        }
        this.f34497h.setText(ResourcesHelper.getString(getContext(), R.string.wallet_boleto_cashin_minimum_amount));
    }

    public void displayBoleto(WalletBoletoResp walletBoletoResp) {
        WalletRouter.gotoBoletoDetailPage(this, walletBoletoResp);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26298a(String str, String str2, final String str3) {
        new VerifyDialogFragment.Builder().showCloseBtn(false).setImageRes(R.drawable.one_pay_base_transfer_failed).setTitle(str).setContent(str2).setClickListener(getString(R.string.wallet_common_btn_verify_now), getString(R.string.wallet_common_btn_next_time), new VerifyDialogFragment.OnClickListener() {
            public void onPositiveClick(VerifyDialogFragment verifyDialogFragment) {
                DRouter.build(str3).start((Context) null);
                FinOmegaSDK.trackEvent("ibt_didipay_recharge_verify_ck");
                verifyDialogFragment.dismiss();
            }

            public void onNegativeClick(VerifyDialogFragment verifyDialogFragment) {
                FinOmegaSDK.trackEvent("ibt_didipay_recharge_details_ck");
                verifyDialogFragment.dismiss();
            }
        }).create().show(getSupportFragmentManager(), "verify_dialog_fragment");
    }
}
