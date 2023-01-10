package com.didi.consume.channels.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.consume.base.CsOmegaUtils;
import com.didi.consume.base.CsRouter;
import com.didi.consume.channels.model.CsTopUpChannelResp;
import com.didi.consume.channels.presenter.CsTopupChannelPresenter;
import com.didi.consume.channels.view.CsTopUpChannelContract;
import com.didi.consume.history.view.CsTopupHistoryActivity;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.view.PayHomelandCityErrorView;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.commonsdk.basemodel.helper.AccountFreezeConfirmDialogHelper;
import com.didi.payment.commonsdk.utils.OmegaComParams;
import com.didi.payment.creditcard.base.utils.PaymentTextUtil;
import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelResp;
import com.didi.payment.wallet.global.wallet.presenter.WalletTopUpChannelPresenter;
import com.didi.payment.wallet.global.wallet.view.activity.WalletBaseActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.soda.blocks.constant.Const;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;

public class CsTopUpChannelActivity extends WalletBaseActivity implements CsTopUpChannelContract.View {

    /* renamed from: m */
    private static final String f18130m = "tab";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public CsTopUpChannelContract.Presenter f18131a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f18132b = -1;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CsTopUpChannelResp.Data f18133c;

    /* renamed from: d */
    private boolean f18134d = true;

    /* renamed from: e */
    private View f18135e;

    /* renamed from: f */
    private ViewGroup f18136f;

    /* renamed from: g */
    private TextView f18137g;

    /* renamed from: h */
    private LinearLayout f18138h;

    /* renamed from: i */
    private TextView f18139i;

    /* renamed from: j */
    private TextView f18140j;

    /* renamed from: k */
    private LinearLayout f18141k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public View f18142l;
    protected TextView mMainTitle;
    protected TextView mSubTitle;
    protected View mTopIcon;

    public static void launch(Context context, int i) {
        Intent intent = new Intent(context, CsTopUpChannelActivity.class);
        intent.putExtra("key_from", i);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.cs_activity_topup_channel);
        m15349a();
        if ("tab".equals(getIntent().getStringExtra(Const.BlockParamConst.SRC))) {
            this.f18132b = 605;
        } else {
            this.f18132b = getIntent().getIntExtra("product_line", -1);
        }
        this.f18131a = onCreatePresenter();
        FinOmegaSDK.trackEvent("ibt_mouton_pax_phone_topup_homepage_sw");
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f18134d = true;
    }

    /* renamed from: a */
    private void m15349a() {
        findViewById(R.id.iv_left).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CsTopUpChannelActivity.this.finish();
            }
        });
        TextView textView = (TextView) findViewById(R.id.tv_right);
        this.f18140j = textView;
        initTitlebarRightAction(textView);
        this.mTopIcon = findViewById(R.id.iv_topup_top_icon);
        this.f18136f = (ViewGroup) findViewById(R.id.ll_top_up_channel_content);
        this.f18137g = (TextView) findViewById(R.id.tv_top_up_rule);
        this.f18138h = (LinearLayout) findViewById(R.id.ll_top_up_condition);
        this.f18139i = (TextView) findViewById(R.id.tv_top_up_condition);
        this.f18141k = (LinearLayout) findViewById(R.id.ll_top_up_channel_channels);
        View findViewById = findViewById(R.id.ll_top_up_channel_empty);
        this.f18142l = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CsTopUpChannelActivity.this.f18142l.setVisibility(8);
                CsTopUpChannelActivity.this.f18131a.requestData();
            }
        });
        m15356b();
    }

    /* renamed from: b */
    private void m15356b() {
        this.mMainTitle = (TextView) findViewById(R.id.tv_top_up_channel_title);
        this.mSubTitle = (TextView) findViewById(R.id.tv_top_up_channel_subtitle);
        View findViewById = findViewById(R.id.ll_top_up_channel_subtitle);
        this.f18135e = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (CsTopUpChannelActivity.this.f18133c != null) {
                    OmegaComParams.Companion.setKYC_RESOURCE_ID("52");
                    CsTopUpChannelActivity csTopUpChannelActivity = CsTopUpChannelActivity.this;
                    CsRouter.gotoAccountPage(csTopUpChannelActivity, csTopUpChannelActivity.f18133c.status, CsTopUpChannelActivity.this.f18133c.accountInfo);
                    CsOmegaUtils.clickKycUT("phone_bill");
                }
            }
        });
    }

    public void refreshUI(final CsTopUpChannelResp.Data data) {
        this.mTopIcon.setVisibility(0);
        this.f18136f.setVisibility(0);
        if (data == null) {
            this.f18136f.setVisibility(8);
            this.f18142l.setVisibility(0);
            return;
        }
        this.f18133c = data;
        if (!TextUtils.isEmpty(data.ruleText)) {
            this.f18137g.setVisibility(0);
            this.f18137g.setText(data.ruleText);
        }
        if (!TextUtils.isEmpty(data.conditionText)) {
            this.f18138h.setVisibility(0);
            this.f18139i.setText(data.conditionText);
            this.f18139i.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    CsTopUpChannelActivity.this.f18131a.handleConditionClick(data.termsAndConditionUrl);
                }
            });
        }
        m15352a((List<WalletTopUpChannelResp.ChannelBean>) data.channelList);
        m15350a(data);
        m15354a(data.accountFreezeStatus);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m15354a(AccountFreezeData accountFreezeData) {
        if (accountFreezeData == null || !accountFreezeData.isDialogValid()) {
            return false;
        }
        return AccountFreezeConfirmDialogHelper.showAccountFrozenConfirmDialog2(this, (AccountFreezeData) AccountFreezeData.Builder.from(accountFreezeData).btnPos(ResourcesHelper.getString(this, R.string.GRider_Unfreeze_Details_cscc)).btnNeg(ResourcesHelper.getString(this, R.string.GRider_Unfreeze_Confirmation_bqam)).putExtra("entrance", -1).build());
    }

    /* renamed from: a */
    private void m15350a(CsTopUpChannelResp.Data data) {
        this.mMainTitle.setText(data.channelsTitle);
        if (1 == data.status || TextUtils.isEmpty(data.statusMsg)) {
            this.f18135e.setVisibility(8);
            return;
        }
        this.mSubTitle.setText(data.statusMsg);
        this.f18135e.setVisibility(0);
    }

    /* renamed from: a */
    private void m15352a(List<WalletTopUpChannelResp.ChannelBean> list) {
        this.f18141k.removeAllViews();
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                final WalletTopUpChannelResp.ChannelBean channelBean = list.get(i);
                if (channelBean != null && TextUtils.equals(channelBean.channelId, WalletTopUpChannelPresenter.CHANNEL_ID_BRAZIL_CASH)) {
                    m15351a(channelBean);
                }
                View inflate = LayoutInflater.from(this).inflate(R.layout.wallet_global_v_topup_channel_item, (ViewGroup) null, false);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, PaymentTextUtil.dip2px(this, 60.0f));
                ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_channel_icon);
                TextView textView = (TextView) inflate.findViewById(R.id.tv_channel_name);
                TextView textView2 = (TextView) inflate.findViewById(R.id.tv_channel_desc);
                TextView textView3 = (TextView) inflate.findViewById(R.id.tv_channel_extra);
                if (channelBean != null) {
                    if (channelBean.statusInfo != null && channelBean.statusInfo.status == 1) {
                        imageView.setAlpha(0.5f);
                        textView.setAlpha(0.5f);
                        textView2.setAlpha(0.5f);
                        textView3.setAlpha(0.5f);
                    }
                    GlideUtils.with2load2into(getContext(), channelBean.iconUrl, imageView);
                    textView.setText(channelBean.name);
                    if (!TextUtil.isEmpty(channelBean.desc)) {
                        textView2.setText(channelBean.desc);
                        textView2.setVisibility(0);
                    } else {
                        textView2.setVisibility(8);
                    }
                    if (TextUtils.isEmpty(channelBean.promotion)) {
                        textView3.setVisibility(8);
                    } else {
                        textView3.setVisibility(0);
                        textView3.setText(channelBean.promotion);
                    }
                }
                inflate.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (CsTopUpChannelActivity.this.f18133c != null) {
                            CsTopUpChannelActivity csTopUpChannelActivity = CsTopUpChannelActivity.this;
                            if (csTopUpChannelActivity.m15354a(csTopUpChannelActivity.f18133c.accountFreezeStatus)) {
                                return;
                            }
                        }
                        CsTopUpChannelActivity.this.f18131a.handleChannelClick(channelBean);
                    }
                });
                this.f18141k.addView(inflate, layoutParams);
            }
        }
    }

    /* renamed from: a */
    private void m15351a(WalletTopUpChannelResp.ChannelBean channelBean) {
        HashMap hashMap = new HashMap();
        if (channelBean == null || channelBean.statusInfo == null || !WalletTopUpChannelResp.ChannelStatusInfo.isOrderInTrip(channelBean.statusInfo.extMetaData)) {
            hashMap.put("trip_status", 0);
        } else {
            hashMap.put("trip_status", 1);
        }
        PayTracker.trackEvent("ibt_mouton_pax_balance_topup_homepage_sw", hashMap);
    }

    /* access modifiers changed from: protected */
    public void initTitlebarRightAction(TextView textView) {
        textView.setVisibility(0);
        textView.setText(R.string.cs_history_list_page_title);
        textView.setTextSize(2, 14.0f);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                Bundle bundle = new Bundle();
                bundle.putInt("product_line", CsTopUpChannelActivity.this.f18132b);
                bundle.putInt("order_type", -1);
                bundle.putInt("params_topup_confirm_flag", 0);
                CsTopupHistoryActivity.startActivity(CsTopUpChannelActivity.this, bundle);
            }
        });
    }

    /* access modifiers changed from: protected */
    public CsTopUpChannelContract.Presenter onCreatePresenter() {
        return new CsTopupChannelPresenter(this, this, this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        CsTopUpChannelResp.Data data;
        super.onResume();
        if (this.f18134d || (data = this.f18133c) == null || !data.isValid()) {
            if (this.f18134d) {
                this.f18134d = false;
            }
            initLoadingDialog(this, R.id.layout_title_bar);
            this.f18131a.requestData();
        }
    }

    public void onNetworkError() {
        this.f18136f.setVisibility(8);
        this.f18142l.setVisibility(0);
    }

    public void showHomelandCityErrorPage() {
        this.f18136f.setVisibility(0);
        PayHomelandCityErrorView.show(this.f18136f);
    }
}
