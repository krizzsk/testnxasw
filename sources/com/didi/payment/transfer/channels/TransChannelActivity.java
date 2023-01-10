package com.didi.payment.transfer.channels;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.util.Consumer;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.payment.base.cons.WalletExtraConstant;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.base.service.IWalletService;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.utils.TextHighlightUtil;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.commonsdk.basemodel.helper.AccountFreezeConfirmDialogHelper;
import com.didi.payment.commonsdk.utils.OmegaComParams;
import com.didi.payment.creditcard.base.utils.PaymentTextUtil;
import com.didi.payment.transfer.channels.TransChannelResp;
import com.didi.payment.transfer.channels.presenter.TransChannelPresenter;
import com.didi.payment.transfer.common.TransBaseActivity;
import com.didi.payment.transfer.constants.TransferContants;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.transfer.utils.TransOmegaUtil;
import com.didi.payment.wallet.global.model.resp.LimitRiskReminderVo;
import com.didi.payment.wallet.global.omega.GlobalOmegaConstant;
import com.didi.payment.wallet.global.risk.LimitRiskReminderHandler;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeTrackerManager;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.TextUtil;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;

public class TransChannelActivity extends TransBaseActivity<IChannelPresenter> implements IChannelPageView {

    /* renamed from: b */
    private static final int f33842b = 1;

    /* renamed from: c */
    private TextView f33843c;

    /* renamed from: d */
    private TextView f33844d;

    /* renamed from: e */
    private View f33845e;

    /* renamed from: f */
    private View f33846f;

    /* renamed from: g */
    private TextView f33847g;

    /* renamed from: h */
    private LinearLayout f33848h;

    /* renamed from: i */
    private TextView f33849i;

    /* renamed from: j */
    private TextView f33850j;

    /* renamed from: k */
    private LinearLayout f33851k;

    /* renamed from: l */
    private View f33852l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public TransChannelResp.DataBean f33853m;
    protected View mTopIcon;

    /* renamed from: n */
    private boolean f33854n = true;

    /* renamed from: o */
    private String f33855o = "unknown";

    /* renamed from: p */
    private LimitRiskReminderHandler f33856p = new LimitRiskReminderHandler();

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.trans_activity_channels;
    }

    /* access modifiers changed from: protected */
    public boolean isSupportEventBus() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean needRebindLoadingBar() {
        return true;
    }

    /* access modifiers changed from: protected */
    public int onBindLoadingBarTo() {
        return R.id.history_contacts_title_bar;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra(WalletExtraConstant.Key.PAGE_REFER);
        this.f33855o = stringExtra;
        TransOmegaUtil.addGlobalParam(TransGlobalOmegaKey.KEY_WALLET_PAGEID, stringExtra);
        TransOmegaUtil.removeGlobalParam(TransGlobalOmegaKey.KEY_ACCOUNT_STATUS);
        TransOmegaUtil.trackEventWithGlobal("ibt_didipay_p2p_transfer_method_sw", TransGlobalOmegaKey.KEY_WALLET_PAGEID);
        WalletHomeTrackerManager.trackTransferPageSW();
    }

    /* access modifiers changed from: protected */
    public TransChannelPresenter onCreatePresenter() {
        return new TransChannelPresenter(this, this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        TransChannelResp.DataBean dataBean;
        super.onResume();
        TransOmegaUtil.removeGlobalParam(TransGlobalOmegaKey.KEY_PAYEE_99PAY_ACCOUNT_STATUS);
        TransOmegaUtil.removeGlobalParam(TransGlobalOmegaKey.KEY_PAYEE_99ACCOUNT_STATUS);
        if (this.f33854n || (dataBean = this.f33853m) == null || !dataBean.isValid()) {
            this.f33854n = false;
            if (this.mPresenter != null) {
                ((IChannelPresenter) this.mPresenter).loadChannels();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void initTitlebarRightAction(TextView textView) {
        textView.setVisibility(0);
        textView.setTextSize(2, 14.0f);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TransChannelActivity.this.toHistoryPage();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        findViewById(R.id.iv_left).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TransChannelActivity.this.onBackHome();
            }
        });
        TextView textView = (TextView) findViewById(R.id.tv_right);
        this.f33850j = textView;
        initTitlebarRightAction(textView);
        m25705b();
        this.mTopIcon = findViewById(R.id.iv_transfer_home_top_icon);
        this.f33846f = findViewById(R.id.ll_transfer_channels_parent);
        this.f33847g = (TextView) findViewById(R.id.tv_transfer_rules);
        this.f33848h = (LinearLayout) findViewById(R.id.ll_transfer_conditions);
        this.f33849i = (TextView) findViewById(R.id.tv_transfer_condition_text);
        this.f33851k = (LinearLayout) findViewById(R.id.transfer_channels_ll_container);
        View findViewById = findViewById(R.id.trans_pageerr_retry2load_rl_root);
        this.f33852l = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ((IChannelPresenter) TransChannelActivity.this.mPresenter).loadChannels();
            }
        });
    }

    /* renamed from: b */
    private void m25705b() {
        this.f33843c = (TextView) findViewById(R.id.tv_trans_channel_title);
        this.f33844d = (TextView) findViewById(R.id.tv_trans_channel_subtitle);
        View findViewById = findViewById(R.id.ll_trans_channel_subtitle);
        this.f33845e = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IWalletService iWalletService = (IWalletService) ServiceLoader.load(IWalletService.class).get();
                if (!(iWalletService == null || TransChannelActivity.this.f33853m == null)) {
                    OmegaComParams.Companion.setKYC_RESOURCE_ID(DiFaceLogger.EVENT_ID_CHECK_MODEL_REQ);
                    TransChannelActivity transChannelActivity = TransChannelActivity.this;
                    iWalletService.gotoAccountPage(transChannelActivity, transChannelActivity.f33853m.status, TransChannelActivity.this.f33853m.accountInfo);
                }
                TransChannelActivity.m25707c();
            }
        });
    }

    /* renamed from: a */
    private void m25701a(List<TransChannelResp.ChannelBean> list) {
        this.f33851k.removeAllViews();
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                final TransChannelResp.ChannelBean channelBean = list.get(i);
                View inflate = LayoutInflater.from(this).inflate(R.layout.trans_channel_item_lay, (ViewGroup) null, false);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, PaymentTextUtil.dip2px(this, 60.0f));
                TextView textView = (TextView) inflate.findViewById(R.id.tv_channel_desc);
                TextView textView2 = (TextView) inflate.findViewById(R.id.tv_channel_extra);
                GlideUtils.with2load2into(getContext(), channelBean.iconUrl, (ImageView) inflate.findViewById(R.id.iv_channel_icon));
                ((TextView) inflate.findViewById(R.id.tv_channel_name)).setText(channelBean.name);
                if (!TextUtil.isEmpty(channelBean.desc)) {
                    TransChannelResp.DataBean dataBean = this.f33853m;
                    if (dataBean == null || !dataBean.hitBankImprove) {
                        textView.setText(channelBean.desc);
                    } else {
                        textView.setText(TextHighlightUtil.highlight(channelBean.desc, getContext().getResources().getColor(R.color.oc_color_999999), Color.parseColor("#FF8040")));
                    }
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
                if (TextUtil.isEmpty(channelBean.promotion)) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setVisibility(0);
                    textView2.setText(channelBean.promotion);
                }
                inflate.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (TransChannelActivity.this.f33853m != null) {
                            TransChannelActivity transChannelActivity = TransChannelActivity.this;
                            if (transChannelActivity.m25702a(transChannelActivity.f33853m.accountFreezeStatus)) {
                                return;
                            }
                        }
                        TransChannelActivity.this.onChannelClick(channelBean);
                    }
                });
                this.f33851k.addView(inflate, layoutParams);
            }
        }
    }

    public void updateChannel(TransChannelResp.DataBean dataBean) {
        this.mTopIcon.setVisibility(0);
        this.f33846f.setVisibility(0);
        if (dataBean == null) {
            onLoadChannelFail((TransChannelResp.DataBean) null);
            return;
        }
        if (!TextUtil.isEmpty(dataBean.historyTitle)) {
            this.f33850j.setText(dataBean.historyTitle);
        } else {
            this.f33850j.setText(getString(R.string.transfer_history_list_page_title));
        }
        this.f33853m = dataBean;
        if (!TextUtil.isEmpty(dataBean.ruleText)) {
            this.f33847g.setVisibility(0);
            this.f33847g.setText(dataBean.ruleText);
        }
        if (!TextUtil.isEmpty(dataBean.conditionText)) {
            this.f33848h.setVisibility(0);
            this.f33849i.setText(dataBean.conditionText);
            this.f33849i.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                }
            });
        }
        m25700a(dataBean);
        m25701a(dataBean.channelList);
        m25702a(dataBean.accountFreezeStatus);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m25702a(AccountFreezeData accountFreezeData) {
        if (accountFreezeData == null || !accountFreezeData.isDialogValid()) {
            return false;
        }
        return AccountFreezeConfirmDialogHelper.showAccountFrozenConfirmDialog2(this, (AccountFreezeData) AccountFreezeData.Builder.from(accountFreezeData).btnPos(ResourcesHelper.getString(this, R.string.GRider_Unfreeze_Details_cscc)).btnNeg(ResourcesHelper.getString(this, R.string.GRider_Unfreeze_Confirmation_bqam)).putExtra("entrance", -1).build());
    }

    /* renamed from: a */
    private void m25700a(TransChannelResp.DataBean dataBean) {
        this.f33843c.setText(dataBean.title);
        if (1 == dataBean.status || TextUtils.isEmpty(dataBean.statusMsg)) {
            this.f33845e.setVisibility(8);
            return;
        }
        this.f33844d.setText(dataBean.statusMsg);
        this.f33845e.setVisibility(0);
    }

    public void onLoadChannelFail(TransChannelResp.DataBean dataBean) {
        this.f33846f.setVisibility(8);
        this.f33852l.setVisibility(0);
    }

    public void onChannelClick(final TransChannelResp.ChannelBean channelBean) {
        WalletHomeTrackerManager.Companion.trackTransferClick(channelBean.name);
        if (channelBean.productLine == 99998) {
            TransOmegaUtil.addOmegaGlobalParam("entry_timestamp", Long.valueOf(System.currentTimeMillis()));
            TransOmegaUtil.trackEventWithGlobal("ibt_didipay_p2p_transfer_method_99pay_ck", TransGlobalOmegaKey.KEY_WALLET_PAGEID);
            LimitRiskReminderVo limitRiskReminderVo = channelBean.limitRiskReminder;
            if (limitRiskReminderVo != null) {
                this.f33856p.show(limitRiskReminderVo, this, GlobalOmegaConstant.SkuRiskLimit.PUB_PAGE_TRANSFER_METHOD, channelBean.productLine, new Consumer<Integer>() {
                    public void accept(Integer num) {
                        if (num.intValue() == 1) {
                            ((IChannelPresenter) TransChannelActivity.this.mPresenter).onHandleChannelItemClick(channelBean);
                        }
                    }
                });
                return;
            }
            ((IChannelPresenter) this.mPresenter).onHandleChannelItemClick(channelBean);
        } else if (channelBean.productLine == 651) {
            TransOmegaUtil.addOmegaGlobalParam("entry_timestamp", Long.valueOf(System.currentTimeMillis()));
            TransOmegaUtil.trackEventWithGlobal("ibt_didipay_p2p_transfer_method_bank_account_ck", TransGlobalOmegaKey.KEY_WALLET_PAGEID);
            ((IChannelPresenter) this.mPresenter).onHandleChannelItemClick(channelBean);
        } else {
            DRouter.build(channelBean.linkUrl).start(this);
        }
    }

    public void onBackHome() {
        finish();
    }

    public void toHistoryPage() {
        ((IChannelPresenter) this.mPresenter).toHistoryPage();
    }

    public void gotoCfmPhonePage(int i) {
        Bundle bundle = new Bundle();
        String str = i != 651 ? TransferContants.Router.ROUTE_TO_99PAY_HOMEPAGE : TransferContants.Router.ROUTE_TO_BANK_HOMEPAGE;
        bundle.putInt(TransferContants.IntentKey.INTENT_PARAM_KEY_PRODUCT_LINE, i);
        TransChannelResp.DataBean dataBean = this.f33853m;
        if (dataBean != null) {
            bundle.putBoolean(TransferContants.IntentKey.INTENT_PARAMS_KEY_2BANK_NEW_VERSION, dataBean.hitBankImprove);
        }
        ((Request) DRouter.build(TransferContants.Router.getRouteUrl(str)).putExtras(bundle)).start(this);
    }

    public void showAccountRegisteDialog(String str, String str2, String str3, String str4, DoubleCheckOnClickListener doubleCheckOnClickListener, DoubleCheckOnClickListener doubleCheckOnClickListener2) {
        showChooseDialog(str, str2, str3, str4, doubleCheckOnClickListener, doubleCheckOnClickListener2);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m25707c() {
        HashMap hashMap = new HashMap();
        hashMap.put("sku_source_id", "p2p");
        FinOmegaSDK.trackEvent("ibt_didipay_pay_boleto_kyc_notification_ck", hashMap);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f33856p.destroy();
        super.onDestroy();
    }

    @Subscribe
    public void onEvent(WalletRefreshDataEvent walletRefreshDataEvent) {
        this.f33854n = true;
    }
}
