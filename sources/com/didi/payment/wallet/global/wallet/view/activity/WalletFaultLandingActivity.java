package com.didi.payment.wallet.global.wallet.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.payment.base.cons.WalletExtraConstant;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;

public class WalletFaultLandingActivity extends WalletBaseActivity {

    /* renamed from: a */
    private ImageView f34675a;

    /* renamed from: b */
    private ImageView f34676b;

    /* renamed from: c */
    private TextView f34677c;

    /* renamed from: d */
    private TextView f34678d;

    /* renamed from: e */
    private TextView f34679e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public WalletPageModel f34680f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f34681g;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.wallet_fault_landing_activity);
        this.f34675a = (ImageView) findViewById(R.id.iv_left);
        this.f34676b = (ImageView) findViewById(R.id.iv_error_image);
        this.f34677c = (TextView) findViewById(R.id.tv_main_title);
        this.f34678d = (TextView) findViewById(R.id.tv_sub_title);
        this.f34679e = (TextView) findViewById(R.id.tv_remind);
        initLoadingDialog(this, R.id.layout_title_bar);
        m26496a();
        this.f34680f = new WalletPageModel(this);
        this.f34679e.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                WalletFaultLandingActivity.this.trackBtnCK();
                WalletFaultLandingActivity.this.showLoadingDialog();
                WalletFaultLandingActivity.this.f34680f.subscribeRecoverNotice(WalletFaultLandingActivity.this.f34681g, new RpcService.Callback<WBaseResp>() {
                    public void onSuccess(WBaseResp wBaseResp) {
                        WalletFaultLandingActivity.this.dismissLoadingDialog();
                        WalletToastNew.showSuccessMsg(WalletFaultLandingActivity.this.getContext(), WalletFaultLandingActivity.this.getString(R.string.Fintech_Payment_optimization__AWey));
                    }

                    public void onFailure(IOException iOException) {
                        WalletFaultLandingActivity.this.dismissLoadingDialog();
                        WalletToastNew.showFailedMsg(WalletFaultLandingActivity.this.getContext(), WalletFaultLandingActivity.this.getString(R.string.Fintech_Payment_optimization__JivK));
                    }
                });
            }
        });
        this.f34675a.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                WalletFaultLandingActivity.this.onBackPressed();
            }
        });
    }

    /* renamed from: a */
    private void m26496a() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f34681g = intent.getStringExtra(WalletExtraConstant.Key.CRASH_TYPE);
            String stringExtra = intent.getStringExtra(WalletExtraConstant.Key.CRASH_PAGE_TITLE);
            String stringExtra2 = intent.getStringExtra(WalletExtraConstant.Key.CRASH_PAGE_SUBTITLE);
            this.f34677c.setText(stringExtra);
            this.f34678d.setText(stringExtra2);
        }
        trackPageSW();
    }

    public void onBackPressed() {
        finish();
    }

    public void trackPageSW() {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        hashMap.put("pub_from_page", this.f34681g);
        FinOmegaSDK.trackEvent("fin_errorpage_sw", hashMap);
    }

    public void trackBtnCK() {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        hashMap.put("pub_from_page", this.f34681g);
        FinOmegaSDK.trackEvent("fin_errorpage_ck", hashMap);
    }
}
