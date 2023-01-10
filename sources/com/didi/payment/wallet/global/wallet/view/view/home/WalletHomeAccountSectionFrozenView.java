package com.didi.payment.wallet.global.wallet.view.view.home;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.wallet.global.model.resp.WalletHomeResp;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;
import java.util.HashMap;

public class WalletHomeAccountSectionFrozenView extends WalletHomeAbsSectionView<WalletHomeResp.AccountSection, WalletHomeContract.Listener> implements View.OnClickListener {

    /* renamed from: a */
    private TextView f35088a;

    /* renamed from: b */
    private TextView f35089b;

    /* renamed from: c */
    private TextView f35090c;

    /* renamed from: d */
    private TextView f35091d;

    /* renamed from: e */
    private WalletHomeResp.AccountSection f35092e;

    /* renamed from: f */
    private View f35093f;

    public WalletHomeAccountSectionFrozenView(Context context) {
        super(context);
    }

    public WalletHomeAccountSectionFrozenView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletHomeAccountSectionFrozenView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.wallet_global_home_account_frozen_section, this, true);
        this.f35093f = findViewById(R.id.frozen_header_view);
        this.f35088a = (TextView) findViewById(R.id.frozen_header_main_title_tv);
        this.f35089b = (TextView) findViewById(R.id.frozen_header_subtitle_tv);
        this.f35090c = (TextView) findViewById(R.id.frozen_header_extra_tv);
        TextView textView = (TextView) findViewById(R.id.wallet_blocked_balance_amount_tv);
        this.f35091d = textView;
        textView.setOnClickListener(this);
        findViewById(R.id.wallet_blocked_balance_card_rl).setOnClickListener(this);
    }

    public void updateContent(WalletHomeResp.AccountSection accountSection) {
        if (accountSection == null || accountSection.accountFreezeData == null) {
            setVisibility(8);
            return;
        }
        this.f35092e = accountSection;
        setVisibility(0);
        AccountFreezeData accountFreezeData = accountSection.accountFreezeData;
        this.f35088a.setText(accountFreezeData.title);
        this.f35089b.setText(accountFreezeData.subTitle);
        this.f35090c.setText(accountFreezeData.desc);
        if (!accountFreezeData.isJumpable(0)) {
            this.f35093f.setOnClickListener((View.OnClickListener) null);
            this.f35088a.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        } else {
            this.f35093f.setOnClickListener(this);
        }
        if (accountSection.statusMsg != null) {
            accountSection.statusMsg.updateTextColor("#99FFFFFF");
            accountSection.statusMsg.bindTextView(this.f35091d);
            this.f35091d.setTextColor(ResourcesHelper.getColor(getContext(), R.color.wallet_color_FFFFFF_60Alpha));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_status", Integer.valueOf(accountFreezeData.freezeStatus));
        hashMap.put("passenger_uid", PayBaseParamUtil.getStringParam(this.mContext, "uid"));
        PayTracker.trackEvent("pax_freezen_banner_sw", hashMap);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (this.mListener != null) {
            if (view.getId() == R.id.frozen_header_view) {
                WalletHomeResp.AccountSection accountSection = this.f35092e;
                if (accountSection != null && accountSection.accountFreezeData != null) {
                    String link = this.f35092e.accountFreezeData.getLink(0);
                    if (!TextUtils.isEmpty(link)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("passenger_status", Integer.valueOf(this.f35092e.accountFreezeData.freezeStatus));
                        hashMap.put("passenger_uid", PayBaseParamUtil.getStringParam(this.mContext, "uid"));
                        PayTracker.trackEvent("pax_freezen_banner_ck", hashMap);
                        ((WalletHomeContract.Listener) this.mListener).onAccountFrozenDetailClick(link);
                    }
                }
            } else if (view.getId() == R.id.wallet_blocked_balance_amount_tv) {
                ((WalletHomeContract.Listener) this.mListener).onStatusMsgClicked(this.f35092e);
            } else if (view.getId() == R.id.wallet_blocked_balance_card_rl) {
                ((WalletHomeContract.Listener) this.mListener).onWholeCardClicked(this.f35092e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setBackgroudStyle(int i) {
        super.setBackgroudStyle(i);
    }
}
