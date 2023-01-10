package com.didi.payment.wallet.global.wallet.view.view.mainlist;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dcrypto.util.network.NetworkConstants;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.base.view.helper.IViewFreezeApplyer;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.commonsdk.view.RoundedImageView;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.wallet.global.model.resp.WalletPageQueryResp;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.wallet.view.view.IWalletMainListEventListener;
import com.didi.payment.wallet.global.wallet.view.view.WalletAbsSectionView;
import com.didi.sdk.util.ResourcesHelper;
import com.didichuxing.dfbasesdk.utils.ResUtils;
import com.taxis99.R;
import java.util.HashMap;

public class WalletMainListAccountSectionView extends WalletAbsSectionView<WalletPageQueryResp.AccountSectionItem, IWalletMainListEventListener> implements View.OnClickListener, IViewFreezeApplyer {

    /* renamed from: a */
    private View f35352a;

    /* renamed from: b */
    private TextView f35353b;

    /* renamed from: c */
    private TextView f35354c;

    /* renamed from: d */
    private TextView f35355d;

    /* renamed from: e */
    private TextView f35356e;

    /* renamed from: f */
    private TextView f35357f;

    /* renamed from: g */
    private TextView f35358g;

    /* renamed from: h */
    private RoundedImageView f35359h;

    /* renamed from: i */
    private WalletPageQueryResp.AccountSectionItem f35360i;

    /* renamed from: j */
    private View f35361j;

    /* renamed from: k */
    private AccountFreezeData f35362k = null;

    public WalletMainListAccountSectionView(Context context) {
        super(context);
    }

    public WalletMainListAccountSectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletMainListAccountSectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(Context context) {
        this.f35361j = LayoutInflater.from(context).inflate(R.layout.wallet_global_v_mainlist_account_section, this, true);
        this.f35352a = findViewById(R.id.v_account_card_bg);
        this.f35353b = (TextView) findViewById(R.id.tv_account_title);
        this.f35354c = (TextView) findViewById(R.id.tv_account_name);
        this.f35355d = (TextView) findViewById(R.id.tv_account_msg);
        this.f35356e = (TextView) findViewById(R.id.tv_account_btn);
        this.f35357f = (TextView) findViewById(R.id.tv_account_tag);
        this.f35358g = (TextView) findViewById(R.id.tv_account_details);
        RoundedImageView roundedImageView = (RoundedImageView) findViewById(R.id.iv_account_card_left_icon);
        this.f35359h = roundedImageView;
        roundedImageView.setCornerType(3);
        this.f35359h.setRectAdius((float) UIUtil.dip2px(this.mContext, 20.0f));
        this.f35353b.setOnClickListener(this);
        this.f35352a.setOnClickListener(this);
        this.f35356e.setOnClickListener(this);
        this.f35358g.setOnClickListener(this);
    }

    public void updateContent(final WalletPageQueryResp.AccountSectionItem accountSectionItem) {
        int i;
        if (accountSectionItem == null) {
            setVisibility(8);
            return;
        }
        this.f35360i = accountSectionItem;
        setVisibility(0);
        if (TextUtils.isEmpty(accountSectionItem.title)) {
            this.f35353b.setVisibility(8);
        } else {
            this.f35353b.setVisibility(0);
            this.f35353b.setText(accountSectionItem.title);
            if (TextUtils.isEmpty(accountSectionItem.helpUrl)) {
                this.f35353b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.f35353b.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.wallet_global_main_list_help_icon, 0);
            }
        }
        this.f35354c.setText(accountSectionItem.name);
        if (accountSectionItem.richText != null) {
            accountSectionItem.richText.bindTextView(this.f35355d);
        }
        if (accountSectionItem.freezeData == null || !accountSectionItem.freezeData.isBlocked()) {
            if (!TextUtils.isEmpty(accountSectionItem.buttonText)) {
                this.f35356e.setText(accountSectionItem.buttonText);
                this.f35356e.setVisibility(0);
            } else {
                this.f35356e.setVisibility(8);
            }
            if (TextUtils.isEmpty(accountSectionItem.detailsText)) {
                this.f35358g.setVisibility(8);
            } else {
                TextView textView = this.f35358g;
                textView.setText(accountSectionItem.detailsText + " >");
                this.f35358g.setVisibility(0);
            }
            if (TextUtils.isEmpty(accountSectionItem.promotionText)) {
                this.f35357f.setVisibility(8);
                i = UIUtil.dip2px(this.mContext, 86.0f);
            } else {
                this.f35357f.setVisibility(0);
                this.f35357f.setText(accountSectionItem.promotionText);
                i = UIUtil.dip2px(this.mContext, 113.0f);
            }
        } else {
            this.f35362k = accountSectionItem.freezeData;
            this.f35355d.setTextColor(ResUtils.getColor(R.color.wallet_color_FFFFFF_60Alpha));
            this.f35356e.setText(ResourcesHelper.getString(this.mContext, R.string.wallet_balance_type_unblock));
            this.f35356e.setVisibility(0);
            this.f35357f.setVisibility(0);
            this.f35357f.setBackgroundResource(R.drawable.wallet_global_mainlist_account_blocked_tag_bg);
            this.f35357f.setTextColor(ResUtils.getColor(R.color.wallet_color_FF4060));
            this.f35357f.setText(accountSectionItem.freezeData.title);
            this.f35357f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    WebBrowserUtil.startInternalWebActivity(WalletMainListAccountSectionView.this.mContext, accountSectionItem.freezeData.link, "");
                }
            });
            i = UIUtil.dip2px(this.mContext, 113.0f);
        }
        ViewGroup.LayoutParams layoutParams = this.f35352a.getLayoutParams();
        layoutParams.height = i;
        this.f35352a.setLayoutParams(layoutParams);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.tv_account_btn) {
            AccountFreezeData accountFreezeData = this.f35362k;
            if (accountFreezeData == null || accountFreezeData.dialogData == null) {
                m26840a();
            } else {
                DRouter.build(this.f35362k.dialogData.landingUrl).start((Context) null);
            }
        } else if (view.getId() == R.id.v_account_card_bg) {
            if (this.f35362k != null) {
                WalletRouter.gotoAccountBalancePageWithBlockData(getContext(), this.f35360i.richText, this.f35360i.channelId, this.f35360i.detailsText, this.f35360i.balanceAmount, this.f35360i.status, this.f35360i.accountStatus, this.f35360i.hasInterest, 6, this.f35362k);
            } else {
                m26842b();
            }
        } else if (view.getId() == R.id.tv_account_title) {
            if (this.mListener != null && !TextUtils.isEmpty(this.f35360i.helpUrl)) {
                ((IWalletMainListEventListener) this.mListener).onPayMethodHelpEvent(this.f35360i.helpUrl);
            }
        } else if (view.getId() == R.id.tv_account_details) {
            m26844d();
        }
    }

    /* renamed from: a */
    private void m26840a() {
        int i = this.f35360i.status;
        if (i == 0 || i == 1 || i == 2 || i == 3) {
            m26843c();
        }
        m26841a("gp_99pay_payment_btn_ck");
    }

    /* renamed from: a */
    private void m26841a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(this.f35360i.status));
        FinOmegaSDK.trackEvent(str, hashMap);
    }

    /* renamed from: b */
    private void m26842b() {
        m26841a("gp_99pay_payment_blank_ck");
        WalletRouter.gotoAccountBalancePage(getContext(), this.f35360i.richText, this.f35360i.channelId, this.f35360i.detailsText, this.f35360i.balanceAmount, this.f35360i.status, this.f35360i.accountStatus, this.f35360i.hasInterest, 6);
    }

    /* renamed from: c */
    private void m26843c() {
        WalletRouter.gotoTopUpPage(getContext(), 5);
    }

    /* renamed from: d */
    private void m26844d() {
        WalletPageQueryResp.AccountSectionItem accountSectionItem = this.f35360i;
        if (accountSectionItem != null) {
            if (accountSectionItem.status != 1) {
                HashMap hashMap = new HashMap();
                hashMap.put(TransGlobalOmegaKey.KEY_ACCOUNT_STATUS, Integer.valueOf(this.f35360i.status));
                hashMap.put("interest_status", Integer.valueOf(this.f35360i.interestStatus));
                PayTracker.trackEvent("ibt_didipay_sidebar_interest_signup_ck", hashMap);
            }
            if (this.f35360i.status == 0) {
                DRouter.build("99pay://one/register").start((Context) null);
            } else if (this.f35360i.status == 3) {
                WalletRouter.gotoFailedReasonPage(getContext(), this.f35360i.accountStatus);
            } else if (this.f35360i.status == 2) {
                WalletRouter.gotoSignUpWaitingPage(getContext(), this.f35360i.accountStatus);
            } else if (this.f35360i.status != 1) {
            } else {
                if (this.f35360i.balanceAmount == 0.0d) {
                    DRouter.build(NetworkConstants.URL_BANNER_BOTTOM_TOPUP).start((Context) null);
                } else {
                    WalletRouter.gotoAccountBalancePage(getContext(), this.f35360i.richText, this.f35360i.channelId, this.f35360i.detailsText, this.f35360i.balanceAmount, this.f35360i.status, this.f35360i.accountStatus, this.f35360i.hasInterest, 7);
                }
            }
        }
    }

    public void apply(IViewFreezeApplyer.FreezeState freezeState) {
        if (freezeState != null && freezeState.isFreeze) {
            this.f35354c.setTextColor(ResourcesHelper.getColor(getContext(), R.color.wallet_color_FFFFFF_60Alpha));
            this.f35355d.setTextColor(ResourcesHelper.getColor(getContext(), R.color.wallet_color_FFFFFF_60Alpha));
            this.f35356e.setBackground(ResourcesHelper.getDrawable(getContext(), R.drawable.wallet_global_mainlist_account_btn_disable_bg));
            this.f35356e.setTextColor(ResourcesHelper.getColor(getContext(), R.color.wallet_color_D4D7D9));
            this.f35356e.setOnClickListener((View.OnClickListener) null);
            this.f35358g.setVisibility(4);
            if (this.f35357f.getVisibility() == 0) {
                this.f35357f.setVisibility(8);
                int dip2px = UIUtil.dip2px(this.mContext, 86.0f);
                ViewGroup.LayoutParams layoutParams = this.f35352a.getLayoutParams();
                layoutParams.height = dip2px;
                this.f35352a.setLayoutParams(layoutParams);
            }
        }
    }
}
