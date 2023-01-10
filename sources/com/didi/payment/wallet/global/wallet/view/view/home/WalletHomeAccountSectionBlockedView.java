package com.didi.payment.wallet.global.wallet.view.view.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.wallet.global.model.resp.WalletHomeResp;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;

public class WalletHomeAccountSectionBlockedView extends WalletHomeAbsSectionView<WalletHomeResp.AccountSection, WalletHomeContract.Listener> implements View.OnClickListener {

    /* renamed from: a */
    private TextView f35083a;

    /* renamed from: b */
    private TextView f35084b;

    /* renamed from: c */
    private WalletHomeOpCardButton f35085c;

    /* renamed from: d */
    private TextView f35086d;

    /* renamed from: e */
    private WalletHomeResp.AccountSection f35087e;

    public WalletHomeAccountSectionBlockedView(Context context) {
        super(context);
    }

    public WalletHomeAccountSectionBlockedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletHomeAccountSectionBlockedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        WalletHomeResp.AccountSection accountSection = this.f35087e;
        if (accountSection != null && accountSection.accountFreezeData != null && this.f35087e.accountFreezeData.isBlocked()) {
            if (id == R.id.wallet_blocked_unblock_btn) {
                ((WalletHomeContract.Listener) this.mListener).onAccountBlocked2UnBlock(this.f35087e.accountFreezeData.dialogData.landingUrl);
            } else if (id == R.id.wallet_blocked_title_tv) {
                ((WalletHomeContract.Listener) this.mListener).onAccountFrozenDetailClick(this.f35087e.accountFreezeData.link);
                FinOmegaSDK.trackEvent("ibt_didipay_unblock_faq_ck");
            } else if (id == R.id.wallet_blocked_balance_amount_tv) {
                ((WalletHomeContract.Listener) this.mListener).onAccountBlocked2BalanceWithData(this.f35087e);
            }
        }
    }

    public void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.wallet_global_home_account_blocked_section, this, true);
        this.f35083a = (TextView) findViewById(R.id.wallet_blocked_title_tv);
        this.f35084b = (TextView) findViewById(R.id.wallet_blocked_desc_tv);
        this.f35085c = (WalletHomeOpCardButton) findViewById(R.id.wallet_blocked_unblock_btn);
        this.f35086d = (TextView) findViewById(R.id.wallet_blocked_balance_amount_tv);
        this.f35083a.setOnClickListener(this);
        this.f35085c.setOnClickListener(this);
        this.f35086d.setOnClickListener(this);
    }

    public void updateContent(WalletHomeResp.AccountSection accountSection) {
        this.f35087e = accountSection;
        if (accountSection.accountFreezeData != null && accountSection.accountFreezeData.isBlocked()) {
            this.f35083a.setText(accountSection.accountFreezeData.title);
            this.f35084b.setText(accountSection.accountFreezeData.subTitle);
            this.f35085c.setText(ResourcesHelper.getString(this.mContext, R.string.wallet_balance_type_unblock));
            if (accountSection.statusMsg != null) {
                accountSection.statusMsg.bindTextView(this.f35086d);
            }
        }
    }
}
