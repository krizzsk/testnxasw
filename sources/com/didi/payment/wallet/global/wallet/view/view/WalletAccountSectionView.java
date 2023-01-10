package com.didi.payment.wallet.global.wallet.view.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.wallet.global.model.resp.WalletPageQueryResp;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.utils.WalletSPUtils;
import com.taxis99.R;
import java.util.HashMap;

public class WalletAccountSectionView extends WalletAbsSectionView<WalletPageQueryResp.AccountSectionItem, IWalletMainListEventListener> implements View.OnClickListener {

    /* renamed from: a */
    private TextView f34930a;

    /* renamed from: b */
    private TextView f34931b;

    /* renamed from: c */
    private TextView f34932c;

    /* renamed from: d */
    private WalletCardButton f34933d;

    /* renamed from: e */
    private ImageView f34934e;

    /* renamed from: f */
    private ImageView f34935f;

    /* renamed from: g */
    private WalletPageQueryResp.AccountSectionItem f34936g;

    /* renamed from: h */
    private View f34937h;

    public WalletAccountSectionView(Context context) {
        super(context);
    }

    public WalletAccountSectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletAccountSectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(Context context) {
        this.f34937h = LayoutInflater.from(context).inflate(R.layout.wallet_account_section, this, true);
        this.f34930a = (TextView) findViewById(R.id.account_main_title_tv);
        this.f34931b = (TextView) findViewById(R.id.account_sub_title_tv);
        this.f34932c = (TextView) findViewById(R.id.account_desc_tv);
        this.f34933d = (WalletCardButton) findViewById(R.id.account_btn_tv);
        this.f34934e = (ImageView) findViewById(R.id.account_more_iv);
        this.f34935f = (ImageView) findViewById(R.id.account_status_iv);
    }

    public void updateContent(WalletPageQueryResp.AccountSectionItem accountSectionItem) {
        if (accountSectionItem == null) {
            setVisibility(8);
            return;
        }
        this.f34936g = accountSectionItem;
        setVisibility(0);
        this.f34930a.setText(accountSectionItem.name);
        if (accountSectionItem.richText != null) {
            accountSectionItem.richText.bindTextView(this.f34931b);
        }
        if (!TextUtils.isEmpty(accountSectionItem.buttonText)) {
            this.f34933d.setText(accountSectionItem.buttonText);
            this.f34933d.setVisibility(0);
        } else {
            this.f34933d.setVisibility(8);
        }
        this.f34933d.updateStatus(accountSectionItem.status);
        this.f34932c.setText(accountSectionItem.promotionText);
        this.f34933d.setOnClickListener(this);
        this.f34934e.setOnClickListener(this);
        this.f34937h.setOnClickListener(this);
        setWalletStatusImageView(accountSectionItem.status);
    }

    private void setWalletStatusImageView(int i) {
        this.f34935f.setImageResource(i != 0 ? i != 1 ? i != 2 ? i != 3 ? 0 : R.drawable.wallet_card_status_failed : R.drawable.wallet_card_status_on_check : R.drawable.wallet_card_status_succeed : R.drawable.wallet_card_status_init);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.account_btn_tv) {
            m26669a();
        } else if (view.getId() == R.id.account_more_iv) {
            m26672c();
        } else if (view.getId() == R.id.v_account_section) {
            m26671b();
        }
    }

    /* renamed from: a */
    private void m26669a() {
        int i = this.f34936g.status;
        if (i == 0) {
            m26675f();
        } else if (i == 1) {
            m26673d();
        } else if (i == 2) {
            WalletRouter.gotoSignUpWaitingPage(getContext(), this.f34936g.accountStatus);
        } else if (i == 3) {
            m26674e();
        }
        m26670a("gp_99pay_payment_btn_ck");
    }

    /* renamed from: a */
    private void m26670a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(this.f34936g.status));
        FinOmegaSDK.trackEvent(str, hashMap);
    }

    /* renamed from: b */
    private void m26671b() {
        m26670a("gp_99pay_payment_blank_ck");
        WalletRouter.gotoAccountBalancePage(getContext(), this.f34936g.richText, this.f34936g.channelId, this.f34936g.detailsText, this.f34936g.balanceAmount, this.f34936g.status, this.f34936g.accountStatus, this.f34936g.hasInterest, 6);
    }

    /* renamed from: c */
    private void m26672c() {
        m26670a("gp_99pay_payment_detail_ck");
        WalletRouter.gotoAccountBalancePage(getContext(), this.f34936g.richText, this.f34936g.channelId, this.f34936g.detailsText, this.f34936g.balanceAmount, this.f34936g.status, this.f34936g.accountStatus, this.f34936g.hasInterest, 6);
    }

    /* renamed from: d */
    private void m26673d() {
        WalletRouter.gotoTopUpPage(getContext(), 3);
    }

    /* renamed from: e */
    private void m26674e() {
        if (this.f34936g.accountStatus != null) {
            WalletRouter.gotoFailedReasonPage(getContext(), this.f34936g.accountStatus);
        }
    }

    /* renamed from: f */
    private void m26675f() {
        if (WalletSPUtils.needShowGetAccountGuide(getContext())) {
            WalletRouter.gotoSignUpGuidePage(getContext(), this.f34936g.accountStatus);
            WalletSPUtils.getAccountGuideHasShowed(getContext());
            return;
        }
        WalletRouter.gotoApplyAccountPage(getContext());
    }
}
