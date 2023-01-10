package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.activities;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.commonsdk.utils.NWRouter;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.contract.WalletSendEmailContract;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.contract.WalletViewBoletoContract;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model.WalletBoletoResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.presenter.WalletViewBoletoPresenter;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.widget.BoletoSendEmailDialogFragment;
import com.didi.payment.wallet.global.wallet.view.activity.WalletBaseActivity;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class WalletViewBoletoActivity extends WalletBaseActivity implements WalletSendEmailContract, WalletViewBoletoContract.View {

    /* renamed from: d */
    private static final String f34508d = "boleto";

    /* renamed from: a */
    RelativeLayout f34509a;

    /* renamed from: b */
    ImageView f34510b;

    /* renamed from: c */
    TextView f34511c;

    /* renamed from: e */
    private TextView f34512e;

    /* renamed from: f */
    private TextView f34513f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextView f34514g;

    /* renamed from: h */
    private TextView f34515h;

    /* renamed from: i */
    private TextView f34516i;

    /* renamed from: j */
    private TextView f34517j;

    /* renamed from: k */
    private WalletViewBoletoContract.Presenter f34518k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public WalletBoletoResp f34519l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public BoletoSendEmailDialogFragment f34520m;

    public void onNetworkError() {
    }

    public static void launch(Context context, WalletBoletoResp walletBoletoResp) {
        Intent intent = new Intent(context, WalletViewBoletoActivity.class);
        intent.putExtra(f34508d, walletBoletoResp);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, 100);
            return;
        }
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.wallet_global_activity_boleto_view);
        m26311a();
        m26315b();
        this.f34518k = new WalletViewBoletoPresenter(this, this, this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            WalletBoletoResp walletBoletoResp = (WalletBoletoResp) extras.getSerializable(f34508d);
            this.f34519l = walletBoletoResp;
            if (walletBoletoResp != null) {
                refreshUI(walletBoletoResp);
                GlobalOmegaUtils.trackBillViewSW();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        initLoadingDialog(this, R.id.wallet_view_boleto_title_bar);
    }

    /* renamed from: a */
    private void m26311a() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.wallet_view_boleto_title_bar);
        this.f34509a = relativeLayout;
        this.f34510b = (ImageView) relativeLayout.findViewById(R.id.iv_left);
        this.f34511c = (TextView) this.f34509a.findViewById(R.id.tv_title);
        this.f34512e = (TextView) findViewById(R.id.tv_view_boleto_amount_title);
        this.f34513f = (TextView) findViewById(R.id.tv_view_boleto_expiration);
        this.f34514g = (TextView) findViewById(R.id.tv_view_boleto_number);
        this.f34515h = (TextView) findViewById(R.id.iv_view_boleto_copy_number);
        this.f34516i = (TextView) findViewById(R.id.btn_view_boleto_send_email);
        this.f34517j = (TextView) findViewById(R.id.tv_view_boleto_viewing_in_web_view);
        this.f34520m = new BoletoSendEmailDialogFragment();
    }

    /* renamed from: b */
    private void m26315b() {
        this.f34510b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletViewBoletoActivity.this.onBackPressed();
            }
        });
        this.f34515h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackBillCopyCK();
                WalletViewBoletoActivity walletViewBoletoActivity = WalletViewBoletoActivity.this;
                walletViewBoletoActivity.m26312a(walletViewBoletoActivity.getContext(), WalletViewBoletoActivity.this.f34514g.getText().toString());
                WalletToastNew.showSuccessMsg(WalletViewBoletoActivity.this.getContext(), WalletViewBoletoActivity.this.getContext().getResources().getString(R.string.wallet_view_boleto_copy_number_toast_msg));
            }
        });
        this.f34516i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackSendEmailCK();
                if (WalletViewBoletoActivity.this.f34519l != null && WalletViewBoletoActivity.this.f34519l.accountEmail != null) {
                    WalletViewBoletoActivity.this.f34520m.setData(WalletViewBoletoActivity.this.f34519l.accountEmail);
                    WalletViewBoletoActivity.this.f34520m.setWalletSendEmailContract(WalletViewBoletoActivity.this);
                    WalletViewBoletoActivity.this.f34520m.show(WalletViewBoletoActivity.this.getSupportFragmentManager(), "topuperror");
                }
            }
        });
        this.f34517j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackBillDetailCK();
                if (WalletViewBoletoActivity.this.f34519l != null && WalletViewBoletoActivity.this.f34519l.url != null) {
                    NWRouter nWRouter = NWRouter.INSTANCE;
                    WalletViewBoletoActivity walletViewBoletoActivity = WalletViewBoletoActivity.this;
                    nWRouter.gotoPDFPage(walletViewBoletoActivity, walletViewBoletoActivity.f34519l.url);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26312a(Context context, String str) {
        ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Copied Text", str));
    }

    public void refreshUI(WalletBoletoResp walletBoletoResp) {
        if (walletBoletoResp != null) {
            walletBoletoResp.amount.bindTextView(this.f34512e);
            this.f34513f.setText(getString(R.string.wallet_view_boleto_expirytime_prefix) + " " + walletBoletoResp.expiryTime);
            this.f34514g.setText(walletBoletoResp.typeableLine);
        }
    }

    public void onEmailSentSuccess() {
        this.f34520m.dismissEmailDialog();
        WalletToastNew.showSuccessMsg(this, getResources().getString(R.string.boleto_send_email_success_msg));
    }

    public void onSendClick(String str) {
        WalletBoletoResp walletBoletoResp = this.f34519l;
        if (walletBoletoResp != null) {
            walletBoletoResp.receiverEmail = str;
            this.f34518k.sendEmail(this.f34519l);
        }
    }
}
