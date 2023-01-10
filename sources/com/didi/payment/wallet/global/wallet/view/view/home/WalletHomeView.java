package com.didi.payment.wallet.global.wallet.view.view.home;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.LottieTask;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.commoninterfacelib.statuslightning.impl.NoneLightningCompatImpl;
import com.didi.component.common.net.CarServerParam;
import com.didi.payment.base.dialog.GlobalAlertDialog;
import com.didi.payment.base.proxy.LoadingProxyHolder;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.ServiceLoaderUtil;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.base.view.PayGlobalLoading;
import com.didi.payment.base.view.helper.IViewFreezeApplyer;
import com.didi.payment.base.view.webview.WalletWebActivity;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.commonsdk.net.PixQrCodeQueryResp;
import com.didi.payment.commonsdk.p130ui.helper.NQRDetectedDialogHelper;
import com.didi.payment.wallet.global.model.WalletAccountData;
import com.didi.payment.wallet.global.model.resp.WalletHomeResp;
import com.didi.payment.wallet.global.model.resp.WalletPopUpWindowResp;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.utils.WalletSecuritySPUtils;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.payment.wallet.global.wallet.contract.WalletNewPayMethodListContract;
import com.didi.payment.wallet.global.wallet.entity.WalletModelConvert;
import com.didi.payment.wallet.global.wallet.view.view.PixMainEntrySectionView;
import com.didi.payment.wallet.global.wallet.view.view.WalletNewPayMethodListView;
import com.didi.payment.wallet.global.wallet.view.view.WalletOperationBannerSectionView;
import com.didi.payment.wallet.password.PasswordScene;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.unifiedPay.util.UIUtils;
import com.didiglobal.pay.paysecure.OpenCertificationListener;
import com.didiglobal.pay.paysecure.PaySecure;
import com.didiglobal.pay.paysecure.SetPwdResultListener;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;

public class WalletHomeView extends WalletHomeAbsSectionView<WalletHomeResp.DataBean, WalletHomeContract.Listener> implements WalletHomeContract.View {

    /* renamed from: a */
    private ViewGroup f35126a;

    /* renamed from: b */
    private View f35127b;

    /* renamed from: c */
    private View f35128c;

    /* renamed from: d */
    private TextView f35129d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f35130e;

    /* renamed from: f */
    private LinearLayout f35131f;

    /* renamed from: g */
    private TextView f35132g;

    /* renamed from: h */
    private WalletHomeAbsSectionView f35133h;

    /* renamed from: i */
    private PixMainEntrySectionView f35134i;

    /* renamed from: j */
    private WalletHomeConsumeSectionView f35135j;

    /* renamed from: k */
    private WalletNewPayMethodListView f35136k;

    /* renamed from: l */
    private WalletOperationBannerSectionView f35137l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public View f35138m;

    /* renamed from: n */
    private View f35139n;

    /* renamed from: o */
    private View f35140o;

    /* renamed from: p */
    private View f35141p;

    /* renamed from: q */
    private View f35142q;

    /* renamed from: r */
    private LoadingProxyHolder.ILoadingProxy f35143r;

    /* renamed from: s */
    private LottieAnimationView f35144s;

    /* renamed from: t */
    private boolean f35145t;

    /* renamed from: u */
    private View f35146u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public WalletHomeContract.Listener f35147v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public WalletHomeResp.DataBean f35148w;

    public WalletHomeView(Context context) {
        super(context);
    }

    public void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.wallet_global_home, this, true);
        this.f35126a = (ViewGroup) findViewById(R.id.fl_root_container);
        this.f35127b = findViewById(R.id.ll_content);
        this.f35128c = findViewById(R.id.ll_empty);
        this.f35129d = (TextView) findViewById(R.id.tv_agent_retry);
        this.f35130e = findViewById(R.id.ll_wallet_page_loading);
        this.f35131f = (LinearLayout) findViewById(R.id.ll_content_layout);
        this.f35132g = (TextView) findViewById(R.id.tv_tc_link);
        this.f35134i = (PixMainEntrySectionView) inflate.findViewById(R.id.pix_entry_section);
        this.f35135j = (WalletHomeConsumeSectionView) inflate.findViewById(R.id.v_consume_section);
        this.f35136k = (WalletNewPayMethodListView) inflate.findViewById(R.id.v_payment_method_section);
        this.f35137l = (WalletOperationBannerSectionView) inflate.findViewById(R.id.v_operation_section);
        this.f35138m = inflate.findViewById(R.id.ll_wallet_title_bar);
        this.f35139n = inflate.findViewById(R.id.iv_wallet_setting);
        this.f35140o = inflate.findViewById(R.id.iv_wallet_help);
        this.f35142q = inflate.findViewById(R.id.iv_wallet_help_shadow);
        this.f35141p = inflate.findViewById(R.id.iv_wallet_setting_shadow);
        this.f35139n.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                Context context = WalletHomeView.this.getContext();
                if ((context instanceof Activity) && WalletHomeView.this.f35148w != null) {
                    WalletRouter.gotoMainListSettingPage((Activity) context, WalletModelConvert.convertByWalletHomeData(WalletHomeView.this.f35148w));
                }
            }
        });
        this.f35140o.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                if (WalletHomeView.this.f35148w != null && !TextUtils.isEmpty(WalletHomeView.this.f35148w.customerSupportUrl)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("page", "wallet");
                    hashMap.put("source_page", "home");
                    hashMap.put(CarServerParam.PARAM_BUTTON, "top_help");
                    FinOmegaSDK.trackEvent("ibt_wallet_ck", hashMap);
                    WalletWebActivity.launch(WalletHomeView.this.mContext, "", WalletHomeView.this.f35148w.customerSupportUrl);
                }
            }
        });
        this.f35129d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (WalletHomeView.this.f35147v != null) {
                    WalletHomeView.this.f35147v.onRefreshPage();
                }
            }
        });
        this.f35132g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (WalletHomeView.this.f35147v != null) {
                    WalletHomeView.this.f35147v.onTermAndConditionsClicked();
                }
            }
        });
        if (((float) UIUtils.getScreenWidth(this.mContext)) / ((float) UIUtils.getScreenHeight(this.mContext)) < 0.5f) {
            this.f35145t = true;
        }
    }

    /* renamed from: a */
    private void m26745a(Context context, PixQrCodeQueryResp.QRCodeData qRCodeData) {
        NQRDetectedDialogHelper.showDialog(context, qRCodeData);
    }

    public void updateContent(WalletHomeResp.DataBean dataBean) {
        if (dataBean == null) {
            showEmptyView();
            return;
        }
        showContentView();
        this.f35148w = dataBean;
        if (dataBean.accountSection != null) {
            m26747a(dataBean.accountSection);
        }
        boolean z = true;
        if (dataBean.freezonData != null && dataBean.freezonData.isBlocked()) {
            if (!(dataBean.consumeSection == null || dataBean.consumeSection.entryList == null)) {
                for (WalletHomeResp.ConsumeItem consumeItem : dataBean.consumeSection.entryList) {
                    consumeItem.isBlocked = true;
                }
            }
            if (!(dataBean.pixSection == null || dataBean.pixSection.entryList == null)) {
                for (WalletHomeResp.PixEntry pixEntry : dataBean.pixSection.entryList) {
                    pixEntry.isBlocked = true;
                }
            }
            dataBean.accountSection.accountFreezeData = dataBean.freezonData;
        }
        m26748a(dataBean, dataBean.pixSection != null && dataBean.pixSection.isValid());
        boolean isNewPayMethodListEnable = WalletApolloUtil.isNewPayMethodListEnable();
        if (dataBean.pixSection != null && dataBean.pixSection.isValid()) {
            this.f35134i.setVisibility(0);
            this.f35134i.setPixEntries(dataBean.pixSection.title, dataBean.pixSection.entryList);
            if (dataBean.freezonData == null || !dataBean.freezonData.isBlocked()) {
                this.f35134i.setStyle(0);
            } else {
                this.f35134i.setStyle(4);
            }
            WalletHomeAbsSectionView walletHomeAbsSectionView = this.f35133h;
            if ((walletHomeAbsSectionView instanceof WalletHomeAccountSectionView) || (walletHomeAbsSectionView instanceof WalletHomeAccountSectionOpStyleView)) {
                this.f35133h.setBackgroudStyle(1);
            }
        }
        this.f35135j.updateContent(dataBean.consumeSection);
        this.f35137l.updateContent(dataBean.operationSection);
        if (!TextUtils.isEmpty(dataBean.customerSupportUrl)) {
            this.f35140o.setVisibility(0);
            this.f35142q.setVisibility(0);
        } else {
            this.f35140o.setVisibility(8);
            this.f35142q.setVisibility(8);
        }
        if (WalletApolloUtil.isNewPayMethodListEnable()) {
            this.f35136k.setStyle(1);
            if (dataBean.freezonData == null || !dataBean.freezonData.isFrozen()) {
                z = false;
            }
            this.f35136k.updateContent(m26744a(dataBean.paymentSection, new IViewFreezeApplyer.FreezeState(z), dataBean.freezonData));
            return;
        }
        this.f35136k.updateContent((WalletNewPayMethodListContract.Model) null);
    }

    /* renamed from: a */
    private void m26747a(WalletHomeResp.AccountSection accountSection) {
        WalletAccountData walletAccountData = new WalletAccountData();
        walletAccountData.setStatus(accountSection.status);
        walletAccountData.setFullKycStatus(accountSection.fullKycStatus);
        walletAccountData.setSupportFullKyc(accountSection.supportFullKyc);
        walletAccountData.setAccountStatus(accountSection.accountStatus);
        walletAccountData.setAuthenticationStatus(accountSection.facialRecognitionStatus);
        WalletSecuritySPUtils.setWalletAccountData(walletAccountData);
    }

    /* renamed from: a */
    private void m26748a(WalletHomeResp.DataBean dataBean, boolean z) {
        m26752b(dataBean, z);
        WalletHomeAbsSectionView walletHomeAbsSectionView = this.f35133h;
        if (walletHomeAbsSectionView != null) {
            if (walletHomeAbsSectionView instanceof WalletHomeAccountSectionFrozenView) {
                dataBean.accountSection.accountFreezeData = dataBean.freezonData;
            }
            this.f35133h.updateContent(dataBean.accountSection);
        }
    }

    /* renamed from: a */
    private WalletNewPayMethodListContract.Model m26744a(WalletHomeResp.PaymentMethodSection paymentMethodSection, IViewFreezeApplyer.FreezeState freezeState, AccountFreezeData accountFreezeData) {
        if (paymentMethodSection == null) {
            return null;
        }
        WalletNewPayMethodListContract.Model model = new WalletNewPayMethodListContract.Model();
        model.title = paymentMethodSection.title;
        model.topTips = paymentMethodSection.topTips;
        if (paymentMethodSection.payMethodItems == null) {
            return model;
        }
        ArrayList arrayList = new ArrayList();
        for (WalletHomeResp.PaymentMethodItem next : paymentMethodSection.payMethodItems) {
            WalletNewPayMethodListContract.ItemModel itemModel = new WalletNewPayMethodListContract.ItemModel();
            int i = 0;
            boolean z = freezeState != null && freezeState.isFreeze;
            itemModel.iconUrl = next.iconUrl;
            itemModel.name = next.name;
            itemModel.desc = next.desc;
            if (next.cardStatus != 1) {
                itemModel.descColor = R.color.wallet_color_FF5252;
            }
            if (next.channelId == 150 && TextUtil.isEmpty(next.cardIndex)) {
                itemModel.type = 2;
                itemModel.name = ResourcesHelper.getString(this.mContext, R.string.GRider_Cognition_Add_a_dpKu);
                if (accountFreezeData == null || !accountFreezeData.isBlocked()) {
                    itemModel.isInFreezeMode = z;
                    if (z) {
                        i = R.color.wallet_color_919599;
                    }
                    itemModel.mainTextColor = i;
                } else {
                    itemModel.isInFreezeMode = true;
                    itemModel.mainTextColor = R.color.wallet_color_919599;
                }
            } else if (next.channelId == 190 || next.channelId == 120) {
                itemModel.rightStyle = 0;
            } else {
                itemModel.rightStyle = 1;
                if (next.expired == 1 && !TextUtils.isEmpty(next.expiredDesc)) {
                    itemModel.rightText = next.expiredDesc;
                    itemModel.rightTextColor = R.color.wallet_boleto_cashin_tv_min_value_red;
                }
            }
            arrayList.add(itemModel);
        }
        model.items = arrayList;
        return model;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m26752b(com.didi.payment.wallet.global.model.resp.WalletHomeResp.DataBean r3, boolean r4) {
        /*
            r2 = this;
            com.didi.payment.wallet.global.wallet.view.view.home.WalletHomeAbsSectionView r4 = r2.f35133h
            r0 = 0
            if (r4 == 0) goto L_0x0014
            android.view.ViewParent r4 = r4.getParent()
            if (r4 == 0) goto L_0x0014
            android.widget.LinearLayout r4 = r2.f35131f
            com.didi.payment.wallet.global.wallet.view.view.home.WalletHomeAbsSectionView r1 = r2.f35133h
            r4.removeView(r1)
            r2.f35133h = r0
        L_0x0014:
            android.view.View r4 = r2.f35146u
            if (r4 == 0) goto L_0x0027
            android.view.ViewParent r4 = r4.getParent()
            if (r4 == 0) goto L_0x0027
            android.widget.LinearLayout r4 = r2.f35131f
            android.view.View r1 = r2.f35146u
            r4.removeView(r1)
            r2.f35146u = r0
        L_0x0027:
            com.didi.payment.wallet.global.wallet.view.view.home.WalletHomeAbsSectionView r4 = r2.f35133h
            if (r4 != 0) goto L_0x009e
            android.widget.LinearLayout$LayoutParams r4 = new android.widget.LinearLayout$LayoutParams
            r0 = -1
            r1 = -2
            r4.<init>(r0, r1)
            com.didi.payment.commonsdk.basemodel.account.AccountFreezeData r0 = r3.freezonData
            r1 = 0
            if (r0 == 0) goto L_0x0051
            com.didi.payment.commonsdk.basemodel.account.AccountFreezeData r0 = r3.freezonData
            boolean r0 = r0.isBannerValid()
            if (r0 == 0) goto L_0x0051
            com.didi.payment.commonsdk.basemodel.account.AccountFreezeData r0 = r3.freezonData
            boolean r0 = r0.isBlocked()
            if (r0 != 0) goto L_0x0051
            com.didi.payment.wallet.global.wallet.view.view.home.WalletHomeAccountSectionFrozenView r3 = new com.didi.payment.wallet.global.wallet.view.view.home.WalletHomeAccountSectionFrozenView
            android.content.Context r0 = r2.mContext
            r3.<init>(r0)
            r2.f35133h = r3
            goto L_0x007a
        L_0x0051:
            com.didi.payment.commonsdk.basemodel.account.AccountFreezeData r0 = r3.freezonData
            if (r0 == 0) goto L_0x0067
            com.didi.payment.commonsdk.basemodel.account.AccountFreezeData r0 = r3.freezonData
            boolean r0 = r0.isBlocked()
            if (r0 == 0) goto L_0x0067
            com.didi.payment.wallet.global.wallet.view.view.home.WalletHomeAccountSectionBlockedView r3 = new com.didi.payment.wallet.global.wallet.view.view.home.WalletHomeAccountSectionBlockedView
            android.content.Context r0 = r2.mContext
            r3.<init>(r0)
            r2.f35133h = r3
            goto L_0x007a
        L_0x0067:
            com.didi.payment.wallet.global.model.resp.WalletHomeResp$AccountSection r0 = r3.accountSection
            if (r0 == 0) goto L_0x007c
            com.didi.payment.wallet.global.model.resp.WalletHomeResp$AccountSection r3 = r3.accountSection
            boolean r3 = r3.isPromotion
            if (r3 == 0) goto L_0x007c
            com.didi.payment.wallet.global.wallet.view.view.home.WalletHomeAccountSectionOpStyleView r3 = new com.didi.payment.wallet.global.wallet.view.view.home.WalletHomeAccountSectionOpStyleView
            android.content.Context r0 = r2.mContext
            r3.<init>(r0)
            r2.f35133h = r3
        L_0x007a:
            r3 = 0
            goto L_0x0086
        L_0x007c:
            com.didi.payment.wallet.global.wallet.view.view.home.WalletHomeAccountSectionView r3 = new com.didi.payment.wallet.global.wallet.view.view.home.WalletHomeAccountSectionView
            android.content.Context r0 = r2.mContext
            r3.<init>(r0)
            r2.f35133h = r3
            r3 = 1
        L_0x0086:
            com.didi.payment.wallet.global.wallet.view.view.home.WalletHomeAbsSectionView r0 = r2.f35133h
            r0.setLayoutParams(r4)
            android.widget.LinearLayout r4 = r2.f35131f
            com.didi.payment.wallet.global.wallet.view.view.home.WalletHomeAbsSectionView r0 = r2.f35133h
            r4.addView(r0, r1)
            com.didi.payment.wallet.global.wallet.view.view.home.WalletHomeAbsSectionView r4 = r2.f35133h
            com.didi.payment.wallet.global.wallet.contract.WalletHomeContract$Listener r0 = r2.f35147v
            r4.setListener(r0)
            if (r3 == 0) goto L_0x009e
            r2.m26754c()
        L_0x009e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.wallet.view.view.home.WalletHomeView.m26752b(com.didi.payment.wallet.global.model.resp.WalletHomeResp$DataBean, boolean):void");
    }

    public void setListener(WalletHomeContract.Listener listener) {
        super.setListener(listener);
        WalletHomeAbsSectionView walletHomeAbsSectionView = this.f35133h;
        if (walletHomeAbsSectionView != null) {
            walletHomeAbsSectionView.setListener(listener);
        }
        this.f35134i.setEventDeliveryListener(listener);
        this.f35135j.setListener(listener);
        this.f35137l.setListener(listener);
        this.f35136k.setListener((WalletNewPayMethodListContract.Listener) listener);
        this.f35147v = listener;
    }

    public void updateEmptyView(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f35129d.setText(str);
        }
        showEmptyView();
    }

    public void onQRCodeDetected(PixQrCodeQueryResp.QRCodeData qRCodeData) {
        m26745a(this.mContext, qRCodeData);
    }

    public void initLoadingDialog(final Activity activity) {
        this.f35143r = new LoadingProxyHolder.ILoadingProxy() {
            public void showLoading() {
                PayGlobalLoading.show(activity, (int) R.id.ll_wallet_page_loading, false);
            }

            public void dismissLoading() {
                PayGlobalLoading.hide(WalletHomeView.this.f35130e);
            }
        };
    }

    public void showLoadingDialog() {
        LoadingProxyHolder.ILoadingProxy iLoadingProxy = this.f35143r;
        if (iLoadingProxy != null) {
            iLoadingProxy.showLoading();
        }
    }

    public void dismissLoadingDialog() {
        LoadingProxyHolder.ILoadingProxy iLoadingProxy = this.f35143r;
        if (iLoadingProxy != null) {
            iLoadingProxy.dismissLoading();
        }
    }

    public void releaseLoadingDialog() {
        this.f35143r = null;
    }

    public void showPwdGuideDialog(WalletPopUpWindowResp walletPopUpWindowResp) {
        if (walletPopUpWindowResp.getData() != null && walletPopUpWindowResp.getData().getType() != null && walletPopUpWindowResp.getData().getType().intValue() == 2) {
            final GlobalAlertDialog globalAlertDialog = new GlobalAlertDialog();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.add(walletPopUpWindowResp.getData().getButtonText());
            arrayList2.add(new GlobalAlertDialog.OnBtnClickListener() {
                public void onBtnClick(DialogFragment dialogFragment, int i) {
                    FinOmegaSDK.trackEvent("ibt_password_popup_set_ck");
                    OpenCertificationListener openCertificationListener = (OpenCertificationListener) ServiceLoaderUtil.getInstance().load(OpenCertificationListener.class);
                    if (openCertificationListener != null) {
                        PaySecure.INSTANCE.createPayPassword(PasswordScene.HOME_PAGE.name(), openCertificationListener, new SetPwdResultListener() {
                            public void onFailure(String str, String str2) {
                            }

                            public void onSuccess(String str) {
                            }
                        });
                    }
                    globalAlertDialog.dismiss();
                }
            });
            arrayList.add(walletPopUpWindowResp.getData().getNegativeButtonText());
            arrayList2.add(new GlobalAlertDialog.OnBtnClickListener() {
                public void onBtnClick(DialogFragment dialogFragment, int i) {
                    globalAlertDialog.dismiss();
                }
            });
            globalAlertDialog.setButtons(arrayList);
            globalAlertDialog.setListeners(arrayList2);
            globalAlertDialog.setTitle(walletPopUpWindowResp.getData().getTitle());
            globalAlertDialog.setMsg(walletPopUpWindowResp.getData().getSubTitle());
            if (!globalAlertDialog.isVisible()) {
                FinOmegaSDK.trackEvent("ibt_password_popup_sw");
                globalAlertDialog.show(((FragmentActivity) this.mContext).getSupportFragmentManager(), "pwdDialog");
            }
        }
    }

    public void updateTitleBar() {
        post(new Runnable() {
            public void run() {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) WalletHomeView.this.f35138m.getLayoutParams();
                int statusBarHeight = WalletHomeView.getStatusBarHeight(WalletHomeView.this.getContext());
                if (marginLayoutParams != null) {
                    marginLayoutParams.topMargin = statusBarHeight - UIUtil.dip2px(WalletHomeView.this.getContext(), 8.0f);
                    WalletHomeView.this.f35138m.setLayoutParams(marginLayoutParams);
                }
            }
        });
    }

    public static int getStatusBarHeight(Context context) {
        if (Build.VERSION.SDK_INT < 21) {
            return 0;
        }
        if (StatusBarLightingCompat.getImpl() == null || !(StatusBarLightingCompat.getImpl() instanceof NoneLightningCompatImpl)) {
            return getStatusHeight(context);
        }
        return 0;
    }

    public static int getStatusHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public void showEmptyView() {
        this.f35127b.setVisibility(8);
        this.f35128c.setVisibility(0);
        this.f35139n.setVisibility(8);
        this.f35141p.setVisibility(8);
    }

    public void showContentView() {
        this.f35127b.setVisibility(0);
        this.f35128c.setVisibility(8);
        this.f35139n.setVisibility(0);
        this.f35141p.setVisibility(0);
    }

    public void showFlowerAnimation() {
        if (this.f35144s == null) {
            new LottieTask(new Callable<LottieResult<LottieComposition>>() {
                public LottieResult<LottieComposition> call() {
                    return WalletHomeView.this.m26742a();
                }
            }).addListener(new LottieListener<LottieComposition>() {
                public void onResult(LottieComposition lottieComposition) {
                    WalletHomeView.this.m26746a(lottieComposition);
                }
            });
        }
    }

    public void dismissFlowerAnimation() {
        m26751b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public LottieResult<LottieComposition> m26742a() {
        try {
            return LottieCompositionFactory.fromJsonInputStreamSync(this.mContext.getAssets().open("flower.json"), (String) null);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26746a(LottieComposition lottieComposition) {
        try {
            LottieAnimationView lottieAnimationView = new LottieAnimationView(getContext());
            this.f35144s = lottieAnimationView;
            lottieAnimationView.setLayoutParams(new FrameLayout.LayoutParams(-1, UIUtil.dip2px(this.mContext, 250.0f)));
            this.f35144s.setComposition(lottieComposition);
            this.f35144s.setRepeatCount(5);
            this.f35144s.playAnimation();
            this.f35126a.addView(this.f35144s);
            this.f35144s.addAnimatorListener(new Animator.AnimatorListener() {
                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    WalletHomeView.this.m26751b();
                }

                public void onAnimationCancel(Animator animator) {
                    WalletHomeView.this.m26751b();
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m26751b() {
        try {
            if (this.f35144s != null) {
                if (this.f35144s.getParent() == null) {
                    this.f35144s = null;
                    return;
                }
                this.f35144s.removeAllAnimatorListeners();
                ((ViewGroup) this.f35144s.getParent()).removeView(this.f35144s);
                this.f35144s = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    private void m26754c() {
        if (this.f35145t) {
            View view = new View(this.mContext);
            view.setBackgroundColor(-16725383);
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, UIUtils.dip2px(this.mContext, 26.0f)));
            this.f35131f.addView(view, 0);
            this.f35146u = view;
        }
    }
}
