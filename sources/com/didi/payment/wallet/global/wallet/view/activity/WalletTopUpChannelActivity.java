package com.didi.payment.wallet.global.wallet.view.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.core.util.Consumer;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.adapter.BaseAdapter;
import com.didi.payment.base.dialog.VerifyDialogFragment;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.view.PayHomelandCityErrorView;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.commonsdk.basemodel.helper.AccountFreezeConfirmDialogHelper;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelResp;
import com.didi.payment.wallet.global.omega.GlobalOmegaConstant;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.risk.LimitRiskReminderHandler;
import com.didi.payment.wallet.global.wallet.contract.WalletTopUpChannelContract;
import com.didi.payment.wallet.global.wallet.presenter.WalletTopUpChannelPresenter;
import com.didi.payment.wallet.global.wallet.view.adapter.WalletTopUpChannelAdapter;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;

public class WalletTopUpChannelActivity extends WalletBaseActivity implements WalletTopUpChannelContract.View {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public WalletTopUpChannelContract.Presenter f34763a;

    /* renamed from: b */
    private TextView f34764b;

    /* renamed from: c */
    private TextView f34765c;

    /* renamed from: d */
    private TextView f34766d;

    /* renamed from: e */
    private LinearLayout f34767e;

    /* renamed from: f */
    private TextView f34768f;

    /* renamed from: g */
    private TextView f34769g;

    /* renamed from: h */
    private RecyclerView f34770h;

    /* renamed from: i */
    private WalletTopUpChannelAdapter f34771i;

    /* renamed from: j */
    private Group f34772j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ViewGroup f34773k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public WalletTopUpChannelResp.DataBean f34774l;

    /* renamed from: m */
    private boolean f34775m = true;
    protected View mTopIcon;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f34776n = -1;

    /* renamed from: o */
    private final LimitRiskReminderHandler f34777o = new LimitRiskReminderHandler();

    public static void launch(Context context, int i) {
        Intent intent = new Intent(context, WalletTopUpChannelActivity.class);
        intent.putExtra("key_from", i);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void launch(Context context, int i, int i2) {
        Intent intent = new Intent(context, WalletTopUpChannelActivity.class);
        intent.putExtra("key_from", i2);
        boolean z = context instanceof Activity;
        if (!z) {
            intent.addFlags(268435456);
        }
        if (z) {
            ((Activity) context).startActivityForResult(intent, i);
        } else {
            context.startActivity(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.wallet_global_activity_topup_channel);
        initViews();
        this.f34763a = onCreatePresenter();
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.TopUpChannelPage.EventId.GLOBAL_TOPUP_99PAY_CHARGE_VIEW_SW);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f34775m = true;
    }

    /* access modifiers changed from: protected */
    public WalletTopUpChannelContract.Presenter onCreatePresenter() {
        return new WalletTopUpChannelPresenter(this, this, this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        WalletTopUpChannelResp.DataBean dataBean;
        super.onResume();
        if (this.f34775m || (dataBean = this.f34774l) == null || !dataBean.isValid()) {
            if (this.f34775m) {
                this.f34775m = false;
            }
            initLoadingDialog(this, R.id.layout_title_bar);
            this.f34763a.requestData();
        }
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
                bundle.putInt("product_line", WalletTopUpChannelActivity.this.f34776n);
                bundle.putInt("params_topup_confirm_flag", 0);
                bundle.putInt(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_FROM_PAGE, 259);
                WalletTopupHistoryActivity.startActivity((Context) WalletTopUpChannelActivity.this, bundle);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        findViewById(R.id.iv_left).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletTopUpChannelActivity.this.finish();
            }
        });
        TextView textView = (TextView) findViewById(R.id.tv_right);
        this.f34769g = textView;
        initTitlebarRightAction(textView);
        this.mTopIcon = findViewById(R.id.iv_topup_top_icon);
        this.f34764b = (TextView) findViewById(R.id.tv_top_up_channel_promotion_text);
        this.f34765c = (TextView) findViewById(R.id.tv_top_up_channel_desc);
        this.f34766d = (TextView) findViewById(R.id.tv_top_up_rule);
        this.f34767e = (LinearLayout) findViewById(R.id.ll_top_up_condition);
        this.f34768f = (TextView) findViewById(R.id.tv_top_up_condition);
        this.f34772j = (Group) findViewById(R.id.content_group);
        this.f34770h = (RecyclerView) findViewById(R.id.rv_channels);
        WalletTopUpChannelAdapter walletTopUpChannelAdapter = new WalletTopUpChannelAdapter();
        this.f34771i = walletTopUpChannelAdapter;
        walletTopUpChannelAdapter.addClickListener(new BaseAdapter.OnItemClickListener<WalletTopUpChannelResp.ChannelBean>() {
            public void onClick(WalletTopUpChannelResp.ChannelBean channelBean, int i) {
                if (WalletTopUpChannelActivity.this.f34774l != null) {
                    WalletTopUpChannelActivity walletTopUpChannelActivity = WalletTopUpChannelActivity.this;
                    if (walletTopUpChannelActivity.m26554a(walletTopUpChannelActivity.f34774l.accountFreezeStatus)) {
                        return;
                    }
                }
                if (channelBean.disable) {
                    WalletTopUpChannelActivity.this.m26550a(channelBean);
                } else {
                    WalletTopUpChannelActivity.this.f34763a.handleChannelClick(channelBean);
                }
            }
        });
        this.f34770h.setAdapter(this.f34771i);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ll_top_up_channel_empty);
        this.f34773k = viewGroup;
        viewGroup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletTopUpChannelActivity.this.f34773k.setVisibility(8);
                WalletTopUpChannelActivity.this.f34763a.requestData();
            }
        });
        PayTracker.putGlobal(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        GlobalOmegaUtils.trackTopUpSW();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26550a(final WalletTopUpChannelResp.ChannelBean channelBean) {
        if (channelBean != null) {
            if (channelBean.limitRiskReminder != null) {
                this.f34777o.show(channelBean.limitRiskReminder, this, "topup", channelBean.productLine, new Consumer<Integer>() {
                    public void accept(Integer num) {
                        if (num.intValue() == 1) {
                            WalletTopUpChannelActivity.this.f34763a.handleChannelClick(channelBean);
                        }
                    }
                });
            } else if (!TextUtils.isEmpty(channelBean.limitRiskReminderText)) {
                WalletToastNew.showFailedMsg(this, channelBean.limitRiskReminderText);
            }
        }
    }

    public void refreshUI(final WalletTopUpChannelResp.DataBean dataBean) {
        this.mTopIcon.setVisibility(0);
        this.f34772j.setVisibility(0);
        this.f34773k.setVisibility(8);
        this.f34765c.setText(dataBean.channelsTitle);
        this.f34774l = dataBean;
        this.f34776n = dataBean.productLine;
        if (dataBean.dialog != null) {
            m26552a(dataBean.dialog.title, dataBean.dialog.desc, dataBean.dialog.kycLink);
        }
        if (dataBean.promotionRule == null || TextUtils.isEmpty(dataBean.promotionRule.text) || TextUtils.isEmpty(dataBean.promotionRule.url)) {
            this.f34764b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            this.f34764b.setText(dataBean.promotionText);
        } else {
            this.f34764b.setText(dataBean.promotionRule.text);
            this.f34764b.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.wallet_top_up_channel_promotion_icon, 0);
            this.f34764b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    WebBrowserUtil.startInternalWebActivity(WalletTopUpChannelActivity.this, dataBean.promotionRule.url, "");
                }
            });
        }
        if (!TextUtils.isEmpty(dataBean.ruleText)) {
            this.f34766d.setVisibility(0);
            this.f34766d.setText(dataBean.ruleText);
        }
        if (!TextUtils.isEmpty(dataBean.conditionText)) {
            this.f34767e.setVisibility(0);
            this.f34768f.setText(dataBean.conditionText);
            this.f34768f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    WalletTopUpChannelActivity.this.f34763a.handleConditionClick(dataBean.termsAndConditionUrl);
                }
            });
        }
        m26553a(dataBean.channelList);
        m26554a(dataBean.accountFreezeStatus);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m26554a(AccountFreezeData accountFreezeData) {
        if (accountFreezeData == null || !accountFreezeData.isDialogValid()) {
            return false;
        }
        return AccountFreezeConfirmDialogHelper.showAccountFrozenConfirmDialog2(this, (AccountFreezeData) AccountFreezeData.Builder.from(accountFreezeData).btnPos(ResourcesHelper.getString(this, R.string.GRider_Unfreeze_Details_cscc)).btnNeg(ResourcesHelper.getString(this, R.string.GRider_Unfreeze_Confirmation_bqam)).putExtra("entrance", -1).build());
    }

    /* renamed from: a */
    private void m26553a(List<WalletTopUpChannelResp.ChannelBean> list) {
        if (list != null && list.size() > 0) {
            for (WalletTopUpChannelResp.ChannelBean next : list) {
                if (TextUtils.equals(next.channelId, WalletTopUpChannelPresenter.CHANNEL_ID_BRAZIL_CASH)) {
                    m26557b(next);
                }
            }
            this.f34771i.setItems(list);
        }
    }

    /* renamed from: b */
    private void m26557b(WalletTopUpChannelResp.ChannelBean channelBean) {
        HashMap hashMap = new HashMap();
        if (channelBean == null || channelBean.statusInfo == null || !WalletTopUpChannelResp.ChannelStatusInfo.isOrderInTrip(channelBean.statusInfo.extMetaData)) {
            hashMap.put("trip_status", 0);
        } else {
            hashMap.put("trip_status", 1);
        }
        PayTracker.trackEvent("ibt_mouton_pax_balance_topup_homepage_sw", hashMap);
    }

    public void onNetworkError() {
        this.f34772j.setVisibility(8);
        this.f34773k.setVisibility(0);
    }

    public void showHomelandCityErrorPage() {
        this.f34773k.setVisibility(0);
        PayHomelandCityErrorView.show(this.f34773k);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && intent.getIntExtra("code", 3) == 1) {
            setResult(-1);
            finish();
        }
        super.onActivityResult(i, i2, intent);
    }

    /* renamed from: a */
    private void m26552a(String str, String str2, final String str3) {
        new VerifyDialogFragment.Builder().showCloseBtn(false).setImageRes(R.drawable.one_pay_base_frozen).setTitle(str).setContent(str2).setClickListener(getString(R.string.wallet_common_btn_verify_now), getString(R.string.wallet_common_btn_next_time), new VerifyDialogFragment.OnClickListener() {
            public void onPositiveClick(VerifyDialogFragment verifyDialogFragment) {
                WalletTopUpChannelActivity.this.f34763a.handleVerifyClick(str3);
                verifyDialogFragment.dismiss();
            }

            public void onNegativeClick(VerifyDialogFragment verifyDialogFragment) {
                FinOmegaSDK.trackEvent("ibt_didipay_balance_cap_details_ck");
                verifyDialogFragment.dismiss();
            }
        }).create().show(getSupportFragmentManager(), "verify_dialog_fragment");
    }

    @Subscribe
    public void onEvent(WalletRefreshDataEvent walletRefreshDataEvent) {
        this.f34775m = true;
    }
}
