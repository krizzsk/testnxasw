package com.didi.payment.wallet.global.wallet.presenter;

import android.app.Activity;
import android.content.Intent;
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
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGOBaseDrawerModel;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel2;
import com.didi.payment.base.proxy.CommonProxyHolder;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.commonsdk.utils.NViewUtils;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.global.model.event.PagePopupStack;
import com.didi.payment.wallet.global.model.resp.CsHistoryItem;
import com.didi.payment.wallet.global.model.resp.CsHistoryListResp;
import com.didi.payment.wallet.global.model.resp.LimitRiskReminderVo;
import com.didi.payment.wallet.global.model.resp.WalletAccountStatus;
import com.didi.payment.wallet.global.model.resp.WalletGetCancelReasonResp;
import com.didi.payment.wallet.global.model.resp.WalletPrePayResp;
import com.didi.payment.wallet.global.omega.GlobalOmegaConstant;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.risk.LimitRiskReminderHandler;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.utils.WalletSPUtils;
import com.didi.payment.wallet.global.wallet.contract.WalletStatusHistoryContract;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpPayResultActivity;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpUniPayActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.unifiedPay.component.model.PayParam;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

public class WalletStatusHistoryPresenter implements WalletStatusHistoryContract.Presenter {

    /* renamed from: a */
    private final int f34611a = 3;

    /* renamed from: b */
    private WalletPageModel f34612b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f34613c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f34614d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f34615e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public LEGODrawer f34616f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public WalletGetCancelReasonResp.Reason f34617g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f34618h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public WalletPrePayResp.DataBean f34619i;
    protected FragmentActivity mContext;
    protected int mPageFrom;
    protected int mProductLine;
    protected WalletStatusHistoryContract.View mView;
    protected int orderType;
    protected LimitRiskReminderHandler reminderHandler = new LimitRiskReminderHandler();

    public WalletStatusHistoryPresenter(FragmentActivity fragmentActivity, WalletStatusHistoryContract.View view) {
        this.mContext = fragmentActivity;
        this.f34612b = new WalletPageModel(fragmentActivity);
        this.mProductLine = fragmentActivity.getIntent().getIntExtra("product_line", 0);
        this.orderType = fragmentActivity.getIntent().getIntExtra("order_type", -1);
        this.mPageFrom = fragmentActivity.getIntent().getIntExtra(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_FROM_PAGE, -1);
        this.mView = view;
    }

    public void loadHistoryData(final boolean z, final int i) {
        if (z) {
            this.f34613c = 0;
            this.mView.clearHistoryItem();
        }
        if (this.f34613c != -1) {
            this.f34614d = true;
            if (z) {
                this.mView.showLoadingDialog();
            }
            this.f34612b.getHistoryList(this.mProductLine, this.f34613c, this.orderType, i, new RpcService.Callback<CsHistoryListResp>() {
                public void onSuccess(CsHistoryListResp csHistoryListResp) {
                    if (WalletStatusHistoryPresenter.this.mView != null && i == WalletStatusHistoryPresenter.this.mView.getCurrentCategory()) {
                        boolean z = false;
                        boolean unused = WalletStatusHistoryPresenter.this.f34614d = false;
                        if (z) {
                            WalletStatusHistoryPresenter.this.mView.dismissLoadingDialog();
                        }
                        if (csHistoryListResp.errno == 0 && csHistoryListResp.data != null && !CollectionUtil.isEmpty((Collection<?>) csHistoryListResp.data.orders)) {
                            int unused2 = WalletStatusHistoryPresenter.this.f34613c = csHistoryListResp.data.nextIndex;
                            WalletStatusHistoryPresenter.this.mView.appendHistoryItem(csHistoryListResp.data);
                            WalletStatusHistoryPresenter.this.mView.hideEmptyView();
                        } else if (z) {
                            if (WalletCommonParamsUtil.isBrazilDriverClient() && csHistoryListResp.data != null && csHistoryListResp.data.showDriverBoletoHistory) {
                                z = true;
                            }
                            WalletStatusHistoryPresenter.this.mView.showEmptyView(WalletStatusHistoryPresenter.this.mView.getCurrentCategory() == 0 ? R.string.GRider_reminder_You_currently_ZrqL : R.string.cs_history_list_empty_text, z);
                        }
                    }
                }

                public void onFailure(IOException iOException) {
                    boolean unused = WalletStatusHistoryPresenter.this.f34614d = false;
                    if (z) {
                        WalletStatusHistoryPresenter.this.mView.dismissLoadingDialog();
                        WalletStatusHistoryPresenter.this.mView.showEmptyView(R.string.cs_history_list_error_text, false);
                    }
                }
            });
        }
    }

    public void handleItemClick(CsHistoryItem csHistoryItem, boolean z, int i) {
        SystemUtils.log(3, "hgl_tag", "handleItemclick item = " + csHistoryItem, (Throwable) null, "com.didi.payment.wallet.global.wallet.presenter.WalletStatusHistoryPresenter", 168);
        Bundle bundle = new Bundle();
        bundle.putInt("product_line", this.mProductLine);
        bundle.putString("order_id", csHistoryItem.orderIdLong);
        bundle.putInt("order_type", csHistoryItem.orderType);
        if (!z) {
            bundle.putInt(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_FROM_PAGE, 256);
            WalletTopUpPayResultActivity.launch(this.mContext, 12, bundle);
            return;
        }
        prepayOrder(csHistoryItem, i);
    }

    public void handleBackClick() {
        if (this.mProductLine == 650) {
            this.mContext.finish();
            return;
        }
        EventBus.getDefault().post(new PagePopupStack());
        this.mContext.finish();
    }

    public void closeOrder(CsHistoryItem csHistoryItem, final int i) {
        this.mView.showLoadingDialog();
        this.f34612b.closeOrder(this.mProductLine, csHistoryItem.orderIdLong, new RpcService.Callback<WBaseResp>() {
            public void onSuccess(WBaseResp wBaseResp) {
                WalletStatusHistoryPresenter.this.mView.dismissLoadingDialog();
                if (wBaseResp.errno == 0) {
                    WalletStatusHistoryPresenter.this.mView.removeItem(i);
                } else if (!TextUtils.isEmpty(wBaseResp.errmsg)) {
                    WalletToastNew.showFailedMsg(WalletStatusHistoryPresenter.this.mContext, wBaseResp.errmsg);
                } else {
                    WalletToastNew.showFailedMsg(WalletStatusHistoryPresenter.this.mContext, ResourcesHelper.getString(WalletStatusHistoryPresenter.this.mContext, R.string.pay_base_network_error));
                }
            }

            public void onFailure(IOException iOException) {
                WalletStatusHistoryPresenter.this.mView.dismissLoadingDialog();
                WalletToastNew.showFailedMsg(WalletStatusHistoryPresenter.this.mContext, ResourcesHelper.getString(WalletStatusHistoryPresenter.this.mContext, R.string.pay_base_network_error));
            }
        });
    }

    public void getCancelReason(final CsHistoryItem csHistoryItem, final int i) {
        final int historyShowCancelReasonCount = WalletSPUtils.getHistoryShowCancelReasonCount(this.mContext);
        if (historyShowCancelReasonCount < 3) {
            this.mView.showLoadingDialog();
            this.f34612b.getCancelReason(this.mProductLine, new RpcService.Callback<WalletGetCancelReasonResp>() {
                public void onSuccess(WalletGetCancelReasonResp walletGetCancelReasonResp) {
                    WalletStatusHistoryPresenter.this.mView.dismissLoadingDialog();
                    WalletStatusHistoryPresenter.this.m26418a(csHistoryItem, i, walletGetCancelReasonResp);
                    WalletSPUtils.setHistoryShowCancelReasonCount(WalletStatusHistoryPresenter.this.mContext, historyShowCancelReasonCount + 1);
                }

                public void onFailure(IOException iOException) {
                    WalletStatusHistoryPresenter.this.mView.dismissLoadingDialog();
                    WalletStatusHistoryPresenter.this.m26418a(csHistoryItem, i, (WalletGetCancelReasonResp) null);
                }
            });
        } else {
            m26418a(csHistoryItem, i, (WalletGetCancelReasonResp) null);
        }
        if (csHistoryItem != null) {
            GlobalOmegaUtils.trackBoletoHistoryUnpaidOrderCancelCK(csHistoryItem.orderIdLong);
        }
    }

    public void prepayOrder(CsHistoryItem csHistoryItem, final int i) {
        this.mView.showLoadingDialog();
        this.f34612b.prePay(this.mProductLine, csHistoryItem.orderIdLong, new RpcService.Callback<WalletPrePayResp>() {
            public void onSuccess(WalletPrePayResp walletPrePayResp) {
                LimitRiskReminderVo limitRiskReminderVo;
                WalletStatusHistoryPresenter.this.mView.dismissLoadingDialog();
                if (walletPrePayResp.errno == 0 && walletPrePayResp.data != null) {
                    String unused = WalletStatusHistoryPresenter.this.f34615e = walletPrePayResp.data.orderId;
                    if (!WalletStatusHistoryPresenter.this.m26426a(walletPrePayResp.data)) {
                        WalletStatusHistoryPresenter.this.m26416a();
                    }
                } else if (walletPrePayResp.errno == 30110) {
                    WalletPrePayResp.DataBean dataBean = walletPrePayResp.data;
                    if (dataBean == null || (limitRiskReminderVo = dataBean.limitRiskReminder) == null) {
                        WalletToastNew.showFailedMsg(WalletStatusHistoryPresenter.this.mContext, walletPrePayResp.errmsg);
                    } else {
                        WalletStatusHistoryPresenter.this.m26419a(limitRiskReminderVo, dataBean);
                    }
                } else if (60100 == walletPrePayResp.errno || 60104 == walletPrePayResp.errno || 60106 == walletPrePayResp.errno) {
                    WalletStatusHistoryPresenter.this.mView.removeItem(i);
                    if (!TextUtils.isEmpty(walletPrePayResp.errmsg)) {
                        WalletToastNew.showFailedMsg(WalletStatusHistoryPresenter.this.mContext, walletPrePayResp.errmsg);
                    }
                } else if (!TextUtils.isEmpty(walletPrePayResp.errmsg)) {
                    WalletToastNew.showFailedMsg(WalletStatusHistoryPresenter.this.mContext, walletPrePayResp.errmsg);
                } else {
                    WalletToastNew.showFailedMsg(WalletStatusHistoryPresenter.this.mContext, ResourcesHelper.getString(WalletStatusHistoryPresenter.this.mContext, R.string.pay_base_network_error));
                }
            }

            public void onFailure(IOException iOException) {
                WalletStatusHistoryPresenter.this.mView.dismissLoadingDialog();
                WalletToastNew.showFailedMsg(WalletStatusHistoryPresenter.this.mContext, ResourcesHelper.getString(WalletStatusHistoryPresenter.this.mContext, R.string.pay_base_network_error));
            }
        });
        GlobalOmegaUtils.trackBoletoHistoryUnpaidOrderPayCK(csHistoryItem.orderIdLong);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26419a(LimitRiskReminderVo limitRiskReminderVo, final WalletPrePayResp.DataBean dataBean) {
        if (limitRiskReminderVo != null) {
            this.reminderHandler.show(limitRiskReminderVo, this.mContext, GlobalOmegaConstant.SkuRiskLimit.PUB_PAGE_BOLETO_ORDERS, 606, new Consumer<Integer>() {
                public void accept(Integer num) {
                    if (num.intValue() == 1 && dataBean != null) {
                        WalletStatusHistoryPresenter.this.m26416a();
                    }
                }
            });
        }
    }

    public void loadNextPage(int i) {
        if (this.f34613c != -1 && !this.f34614d) {
            loadHistoryData(false, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m26426a(final WalletPrePayResp.DataBean dataBean) {
        boolean z = false;
        if (!(dataBean == null || dataBean.extraInfo == null || dataBean.extraInfo.prePayDialogInfo == null)) {
            WalletPrePayResp.PrePayDialogInfo prePayDialogInfo = dataBean.extraInfo.prePayDialogInfo;
            boolean isNewPayMethodListEnable = WalletApolloUtil.isNewPayMethodListEnable();
            String str = prePayDialogInfo.title;
            String str2 = prePayDialogInfo.posBtnText;
            String str3 = prePayDialogInfo.negBtnText;
            if (isNewPayMethodListEnable) {
                if (!TextUtil.isEmpty(prePayDialogInfo.newTitle)) {
                    str = prePayDialogInfo.newTitle;
                }
                if (!TextUtil.isEmpty(prePayDialogInfo.newPosBtnText)) {
                    str2 = prePayDialogInfo.newPosBtnText;
                }
                if (!TextUtil.isEmpty(prePayDialogInfo.newNegBtnText)) {
                    str3 = prePayDialogInfo.newNegBtnText;
                }
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                if (this.f34616f != null && this.f34616f.isShowing()) {
                    this.f34616f.dismiss();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (2 == dataBean.extraInfo.accountStatus || 3 == dataBean.extraInfo.accountStatus) {
                str = this.mContext.getString(R.string.GRider_reminder_In_the_cnSS);
                str2 = this.mContext.getString(R.string.GRider_reminder_I_see_qZXc);
                GlobalOmegaUtils.trackBoletoHistoryKycDialog(GlobalOmegaConstant.BoletoHistoryPage.EventId.BOLETO_NO_KYC_PENDING_SW, this.f34615e);
            } else {
                GlobalOmegaUtils.trackBoletoHistoryKycDialog(GlobalOmegaConstant.BoletoHistoryPage.EventId.BOLETO_NO_KYC_GEN_BOLETO_SW, this.f34615e);
            }
            z = true;
            LEGOBaseDrawerModel isShowCloseImg = new LEGODrawerModel1(str, new LEGOBtnTextAndCallback(str2, new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    if (WalletStatusHistoryPresenter.this.f34616f != null && WalletStatusHistoryPresenter.this.f34616f.isShowing()) {
                        WalletStatusHistoryPresenter.this.f34616f.dismiss();
                    }
                    if (2 == dataBean.extraInfo.accountStatus || 3 == dataBean.extraInfo.accountStatus) {
                        WalletStatusHistoryPresenter.this.mContext.finish();
                        return;
                    }
                    WalletStatusHistoryPresenter walletStatusHistoryPresenter = WalletStatusHistoryPresenter.this;
                    walletStatusHistoryPresenter.m26417a((Activity) walletStatusHistoryPresenter.mContext, dataBean);
                    boolean unused = WalletStatusHistoryPresenter.this.f34618h = true;
                    WalletPrePayResp.DataBean unused2 = WalletStatusHistoryPresenter.this.f34619i = dataBean;
                    GlobalOmegaUtils.trackBoletoHistoryKycDialog(GlobalOmegaConstant.BoletoHistoryPage.EventId.BOLETO_NO_KYC_SIGNUP_CK, WalletStatusHistoryPresenter.this.f34615e);
                }
            })).setIsShowCloseImg(true);
            if (dataBean.extraInfo.accountStatus == 0) {
                isShowCloseImg.addMinorBtn(new LEGOBtnTextAndCallback(str3, new LEGOOnAntiShakeClickListener() {
                    public void onAntiShakeClick(View view) {
                        if (WalletStatusHistoryPresenter.this.f34616f != null && WalletStatusHistoryPresenter.this.f34616f.isShowing()) {
                            WalletStatusHistoryPresenter.this.f34616f.dismiss();
                        }
                        GlobalOmegaUtils.trackBoletoHistoryKycDialog(GlobalOmegaConstant.BoletoHistoryPage.EventId.BOLETO_NO_KYC_GOT_IT_CK, WalletStatusHistoryPresenter.this.f34615e);
                    }
                }));
            }
            if (dataBean.extraInfo.prePayDialogInfo.subTitle != null) {
                isShowCloseImg.setSubTitle(dataBean.extraInfo.prePayDialogInfo.subTitle);
            }
            isShowCloseImg.setShowCloseImgListener(new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    GlobalOmegaUtils.trackBoletoHistoryKycDialog(GlobalOmegaConstant.BoletoHistoryPage.EventId.BOLETO_NO_KYC_GOT_IT_CK, WalletStatusHistoryPresenter.this.f34615e);
                }
            });
            this.f34616f = LEGOUICreator.showDrawerTemplate(this.mContext, isShowCloseImg);
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26417a(Activity activity, WalletPrePayResp.DataBean dataBean) {
        if (dataBean != null && dataBean.extraInfo != null) {
            int i = dataBean.extraInfo.accountStatus;
            if (i == 0) {
                WalletRouter.gotoApplyAccountPage(activity);
            } else if (i != 2) {
                if (i == 3 && dataBean.extraInfo.accountInfo != null) {
                    WalletRouter.gotoFailedReasonPage(activity, dataBean.extraInfo.accountInfo);
                }
            } else if (dataBean.extraInfo.accountInfo != null) {
                WalletRouter.gotoSignUpWaitingPage(activity, dataBean.extraInfo.accountInfo);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m26431b(WalletPrePayResp.DataBean dataBean) {
        if (dataBean != null) {
            LimitRiskReminderVo limitRiskReminderVo = dataBean.limitRiskReminder;
            if (limitRiskReminderVo != null) {
                this.reminderHandler.show(limitRiskReminderVo, this.mContext, GlobalOmegaConstant.SkuRiskLimit.PUB_PAGE_BOLETO_ORDERS, 606, new Consumer<Integer>() {
                    public void accept(Integer num) {
                        if (num.intValue() == 1) {
                            WalletStatusHistoryPresenter.this.m26416a();
                        }
                    }
                });
            } else {
                m26416a();
            }
        }
    }

    /* renamed from: c */
    private void m26434c(WalletPrePayResp.DataBean dataBean) {
        Object terminalId;
        PayParam payParam = new PayParam();
        payParam.outTradeId = dataBean.outTradeId;
        payParam.omegaAttrs = new HashMap();
        payParam.omegaAttrs.put("product_line", Integer.valueOf(this.mProductLine));
        CommonProxyHolder.ICommonProxy proxy = CommonProxyHolder.getProxy();
        if (!(proxy == null || (terminalId = proxy.getTerminalId(this.mContext.getApplicationContext())) == null)) {
            payParam.omegaAttrs.put("wallet_terminal_id", terminalId);
        }
        WalletTopUpUniPayActivity.launch(this.mContext, payParam, 100);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26416a() {
        if (!TextUtils.isEmpty(this.f34615e)) {
            Intent intent = new Intent(this.mContext, WalletTopUpPayResultActivity.class);
            intent.putExtra("product_line", this.mProductLine);
            intent.putExtra("order_id", this.f34615e);
            intent.putExtra("order_type", this.orderType);
            intent.putExtra(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_FROM_PAGE, 260);
            this.mContext.startActivityForResult(intent, 101);
        }
    }

    public void gotoPayResultPage() {
        if (!TextUtils.isEmpty(this.f34615e)) {
            WalletTopUpPayResultActivity.launch(this.mContext, 101, this.mProductLine, this.f34615e, this.orderType);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26418a(final CsHistoryItem csHistoryItem, final int i, WalletGetCancelReasonResp walletGetCancelReasonResp) {
        WalletGetCancelReasonResp.DataBean dataBean;
        String str;
        final String str2;
        LinearLayout linearLayout;
        try {
            if (this.f34616f != null && this.f34616f.isShowing()) {
                this.f34616f.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String string = this.mContext.getString(R.string.GRider_reminder_Are_you_tLEI);
        if (walletGetCancelReasonResp == null || walletGetCancelReasonResp.data == null) {
            dataBean = null;
        } else {
            dataBean = walletGetCancelReasonResp.data;
            if (!TextUtils.isEmpty(walletGetCancelReasonResp.data.title)) {
                string = walletGetCancelReasonResp.data.title;
            }
        }
        if (csHistoryItem != null && !TextUtils.isEmpty(csHistoryItem.cancelTitle)) {
            string = csHistoryItem.cancelTitle;
        }
        if (dataBean == null || dataBean.cancelReasons == null || dataBean.cancelReasons.size() <= 0) {
            str2 = "direct_confirm";
            str = null;
            linearLayout = null;
        } else {
            linearLayout = m26413a(walletGetCancelReasonResp);
            str = walletGetCancelReasonResp.data.subTitle;
            str2 = "detailed_list";
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.wallet_dialog_extended_rich_title_view, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(R.id.wallet_extended_dialog_subtitle);
        NViewUtils.INSTANCE.setText2HighLight((TextView) inflate.findViewById(R.id.wallet_extended_dialog_title), string, Color.parseColor("#000000"), Color.parseColor(ColorUtils.DIDI_GREEN_MOUTON));
        if (!TextUtils.isEmpty(str)) {
            textView.setVisibility(0);
        }
        textView.setText(str);
        LEGOBaseDrawerModel isShowCloseImg = new LEGODrawerModel2("", new LEGOBtnTextAndCallback(this.mContext.getString(R.string.Wallet_App_Onboarding_Confirmation_NpIr), new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (WalletStatusHistoryPresenter.this.f34616f != null && WalletStatusHistoryPresenter.this.f34616f.isShowing()) {
                    WalletStatusHistoryPresenter.this.f34616f.dismiss();
                }
                CsHistoryItem csHistoryItem = csHistoryItem;
                if (csHistoryItem != null) {
                    GlobalOmegaUtils.trackBoletoHistoryCancelOrderCK(csHistoryItem.orderIdLong, str2, WalletStatusHistoryPresenter.this.f34617g == null ? "0" : WalletStatusHistoryPresenter.this.f34617g.f34290id);
                    WalletGetCancelReasonResp.Reason unused = WalletStatusHistoryPresenter.this.f34617g = null;
                    WalletStatusHistoryPresenter.this.closeOrder(csHistoryItem, i);
                }
            }
        }), new LEGOBtnTextAndCallback(this.mContext.getString(R.string.Wallet_App_window_Not_now_fzRN), new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (WalletStatusHistoryPresenter.this.f34616f != null && WalletStatusHistoryPresenter.this.f34616f.isShowing()) {
                    WalletStatusHistoryPresenter.this.f34616f.dismiss();
                }
            }
        })).setIsShowCloseImg(true);
        isShowCloseImg.setExtendedView(inflate);
        if (!TextUtils.isEmpty(str)) {
            isShowCloseImg.setSubTitle(str);
        }
        if (linearLayout != null) {
            isShowCloseImg.setExtendedBottomView(linearLayout);
        }
        isShowCloseImg.setShowCloseImgListener(new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                GlobalOmegaUtils.trackBoletoHistoryCancelOrderExitCK(csHistoryItem.orderIdLong, str2);
                WalletGetCancelReasonResp.Reason unused = WalletStatusHistoryPresenter.this.f34617g = null;
            }
        });
        this.f34616f = LEGOUICreator.showDrawerTemplate(this.mContext, isShowCloseImg);
        GlobalOmegaUtils.trackBoletoHistoryCancelOrderSW(csHistoryItem.orderIdLong, str2);
    }

    /* renamed from: a */
    private LinearLayout m26413a(WalletGetCancelReasonResp walletGetCancelReasonResp) {
        final List<WalletGetCancelReasonResp.Reason> list = walletGetCancelReasonResp.data.cancelReasons;
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        final ArrayList arrayList = new ArrayList();
        for (final int i = 0; i < list.size(); i++) {
            if (list.get(i) != null && !TextUtils.isEmpty(list.get(i).content)) {
                View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.cs_history_list_cancel_item, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.history_cancel_title)).setText(list.get(i).content);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.history_cancel_select_icon);
                arrayList.add(imageView);
                imageView.setTag(Integer.valueOf(i));
                inflate.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        WalletGetCancelReasonResp.Reason unused = WalletStatusHistoryPresenter.this.f34617g = (WalletGetCancelReasonResp.Reason) list.get(i);
                        WalletStatusHistoryPresenter.this.m26425a((List<ImageView>) arrayList, i);
                    }
                });
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, UIUtil.dip2px(this.mContext, 45.0f));
                if (i == 0) {
                    layoutParams.topMargin = UIUtil.dip2px(this.mContext, 25.0f);
                } else if (i == list.size() - 1) {
                    inflate.findViewById(R.id.cancel_item_dividing_line).setVisibility(8);
                }
                linearLayout.addView(inflate, layoutParams);
            }
        }
        return linearLayout;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26425a(List<ImageView> list, int i) {
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (list.get(i2) == null || list.get(i2).getTag() == null || i != ((Integer) list.get(i2).getTag()).intValue()) {
                    list.get(i2).setImageResource(R.drawable.wallet_history_icon_unselect);
                } else {
                    list.get(i2).setImageResource(R.drawable.wallet_history_icon_select);
                }
            }
        }
    }

    public void checkAccountStatus() {
        if (this.f34618h) {
            this.f34618h = false;
            this.mView.showLoadingDialog();
            this.f34612b.checkAccountStatus(new RpcService.Callback<WalletAccountStatus>() {
                public void onSuccess(WalletAccountStatus walletAccountStatus) {
                    WalletStatusHistoryPresenter.this.mView.dismissLoadingDialog();
                    if (!(walletAccountStatus == null || walletAccountStatus.data == null || WalletStatusHistoryPresenter.this.f34619i == null)) {
                        if (1 == walletAccountStatus.data.status) {
                            WalletStatusHistoryPresenter walletStatusHistoryPresenter = WalletStatusHistoryPresenter.this;
                            walletStatusHistoryPresenter.m26431b(walletStatusHistoryPresenter.f34619i);
                        } else if (2 == walletAccountStatus.data.status) {
                            if (WalletStatusHistoryPresenter.this.f34619i.extraInfo != null) {
                                WalletStatusHistoryPresenter.this.f34619i.extraInfo.accountStatus = 2;
                                WalletStatusHistoryPresenter walletStatusHistoryPresenter2 = WalletStatusHistoryPresenter.this;
                                boolean unused = walletStatusHistoryPresenter2.m26426a(walletStatusHistoryPresenter2.f34619i);
                            }
                        } else if (walletAccountStatus.data.status == 0 || 3 == walletAccountStatus.data.status) {
                            WalletStatusHistoryPresenter walletStatusHistoryPresenter3 = WalletStatusHistoryPresenter.this;
                            boolean unused2 = walletStatusHistoryPresenter3.m26426a(walletStatusHistoryPresenter3.f34619i);
                        }
                    }
                    WalletPrePayResp.DataBean unused3 = WalletStatusHistoryPresenter.this.f34619i = null;
                }

                public void onFailure(IOException iOException) {
                    WalletStatusHistoryPresenter.this.mView.dismissLoadingDialog();
                }
            });
        }
    }

    public void destroy() {
        this.reminderHandler.destroy();
    }
}
