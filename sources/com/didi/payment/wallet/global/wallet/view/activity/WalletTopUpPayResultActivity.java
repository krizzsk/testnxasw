package com.didi.payment.wallet.global.wallet.view.activity;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.LottieTask;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.drouter.api.DRouter;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.LEGODrawerModel;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.payment.base.finResource.FinResUtils;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.TextHighlightUtil;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.base.widget.CircleLoadingView;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.base.widget.FastCheckOnClickListener;
import com.didi.payment.commonsdk.utils.NViewUtils;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.payment.wallet.global.model.resp.WalletPayResultResp;
import com.didi.payment.wallet.global.model.resp.model.WalletOperationItem;
import com.didi.payment.wallet.global.prepaidcard.TopupPrepaidDialog;
import com.didi.payment.wallet.global.utils.WalletSecuritySPUtils;
import com.didi.payment.wallet.global.wallet.contract.WalletOperationBannerContract;
import com.didi.payment.wallet.global.wallet.contract.WalletOrderSharePicContract;
import com.didi.payment.wallet.global.wallet.contract.WalletTopUpPayResultContract;
import com.didi.payment.wallet.global.wallet.presenter.WalletOrderSharePicPresenter;
import com.didi.payment.wallet.global.wallet.presenter.WalletTopUpOrderDetailPresenter;
import com.didi.payment.wallet.global.wallet.presenter.WalletTopUpPayResultPresenter;
import com.didi.payment.wallet.global.wallet.view.adapter.WalletOrderDetailSharePicAdapter;
import com.didi.payment.wallet.global.wallet.view.view.WalletOperationBannerSectionView;
import com.didi.payment.wallet.global.wallet.view.view.WalletOrderSharePicView;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.fastframe.util.CollectionUtil;
import com.didi.sdk.sidebar.history.constant.HistoryRecordConstant;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.taxis99.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Callable;

public class WalletTopUpPayResultActivity extends WalletBaseActivity implements WalletTopUpPayResultContract.View {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public WalletTopUpPayResultContract.Presenter f34788A;

    /* renamed from: B */
    private int f34789B = 0;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public boolean f34790C = true;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public int f34791D;

    /* renamed from: E */
    private int f34792E;

    /* renamed from: a */
    private ImageView f34793a;

    /* renamed from: b */
    private TextView f34794b;

    /* renamed from: c */
    private TextView f34795c;

    /* renamed from: d */
    private CircleLoadingView f34796d;

    /* renamed from: e */
    private RelativeLayout f34797e;

    /* renamed from: f */
    private View f34798f;

    /* renamed from: g */
    private LottieAnimationView f34799g;

    /* renamed from: h */
    private View f34800h;

    /* renamed from: i */
    private ImageView f34801i;

    /* renamed from: j */
    private LinearLayout f34802j;

    /* renamed from: k */
    private TextView f34803k;

    /* renamed from: l */
    private TextView f34804l;

    /* renamed from: m */
    private TextView f34805m;
    protected TextView mTvBtn;

    /* renamed from: n */
    private TextView f34806n;

    /* renamed from: o */
    private TextView f34807o;

    /* renamed from: p */
    private ImageView f34808p;

    /* renamed from: q */
    private TextView f34809q;

    /* renamed from: r */
    private TextView f34810r;

    /* renamed from: s */
    private LinearLayout f34811s;

    /* renamed from: t */
    private WalletOperationBannerSectionView f34812t;

    /* renamed from: u */
    private RelativeLayout f34813u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public LEGODrawer f34814v;

    /* renamed from: w */
    private ScrollView f34815w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public WalletOrderSharePicContract.Presenter f34816x;

    /* renamed from: y */
    private WalletOrderSharePicContract.View f34817y;

    /* renamed from: z */
    private WalletOrderDetailSharePicAdapter f34818z;

    interface IPayResultUI {
        void onBottomBtnUI();

        void onPageTitleUI();

        void onTableViewUI();

        void onTitleBarUI();
    }

    public void onNetworkError() {
    }

    public static void launchFromFlutterTopUp(Context context, int i, int i2, String str, int i3) {
        Intent intent = new Intent(context, WalletTopUpPayResultActivity.class);
        intent.putExtra("product_line", i2);
        intent.putExtra("order_id", str);
        intent.putExtra("order_type", i3);
        intent.putExtra(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_FROM_PAGE, 256);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i);
            return;
        }
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static void launch(Context context, int i, int i2, String str, int i3) {
        Intent intent = new Intent(context, WalletTopUpPayResultActivity.class);
        intent.putExtra("product_line", i2);
        intent.putExtra("order_id", str);
        intent.putExtra("order_type", i3);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i);
            return;
        }
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static void launch(Context context, int i, Bundle bundle) {
        Intent intent = new Intent(context, WalletTopUpPayResultActivity.class);
        intent.putExtras(bundle);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i);
            return;
        }
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.wallet_global_activity_topup_pay_result);
        this.f34788A = createPresenter();
        initViews();
        this.f34788A.executeTask();
    }

    /* access modifiers changed from: protected */
    public WalletTopUpPayResultContract.Presenter createPresenter() {
        Intent intent = getIntent();
        if (intent != null) {
            int intExtra = intent.getIntExtra(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_FROM_PAGE, 0);
            this.f34792E = intExtra;
            this.f34790C = intExtra == 256 || intExtra == 260;
        }
        if (intent != null) {
            this.f34791D = intent.getIntExtra("product_line", 0);
        }
        if (intent == null || intent.getIntExtra("order_type", -1) != 1) {
            return new WalletTopUpPayResultPresenter(this, this);
        }
        return new WalletTopUpOrderDetailPresenter(this, this);
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        this.f34813u = (RelativeLayout) findViewById(R.id.root_view_layout);
        this.f34812t = (WalletOperationBannerSectionView) findViewById(R.id.v_operation_section);
        this.f34796d = (CircleLoadingView) findViewById(R.id.pay_result_circle_view);
        this.f34795c = (TextView) findViewById(R.id.pay_result_details_tv);
        this.mTvBtn = (TextView) findViewById(R.id.pay_result_confirm_btn);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.history_contacts_title_bar);
        this.f34797e = relativeLayout;
        relativeLayout.setBackgroundColor(ResourcesHelper.getColor(this, R.color.transparent));
        View findViewById = findViewById(R.id.divider_line);
        this.f34798f = findViewById;
        findViewById.setVisibility(8);
        this.f34794b = (TextView) findViewById(R.id.tv_right);
        ImageView imageView = (ImageView) findViewById(R.id.iv_left);
        this.f34793a = imageView;
        if (!this.f34790C) {
            imageView.setImageDrawable(ResourcesHelper.getDrawable(this, R.drawable.wallet_global_paymethod_adddialog_close));
        }
        this.f34808p = (ImageView) findViewById(R.id.iv_right);
        this.f34800h = findViewById(R.id.pay_result_content_rl);
        this.f34801i = (ImageView) findViewById(R.id.pay_result_card_icon_iv);
        this.f34802j = (LinearLayout) findViewById(R.id.pay_result_page_card_ll);
        this.f34803k = (TextView) findViewById(R.id.pay_result_card_sub_title_tv);
        this.f34804l = (TextView) findViewById(R.id.pay_result_card_main_title_tv);
        this.f34789B = this.f34802j.getPaddingLeft();
        this.f34805m = (TextView) findViewById(R.id.pay_result_amount_price_tv);
        this.f34806n = (TextView) findViewById(R.id.pay_result_amount_symbol_tv);
        this.f34807o = (TextView) findViewById(R.id.tv_limit_info);
        this.f34809q = (TextView) findViewById(R.id.bubble_area_tv);
        this.f34810r = (TextView) findViewById(R.id.cancel_payment_btn);
        this.f34811s = (LinearLayout) findViewById(R.id.bottom_btn_layout);
        this.f34815w = (ScrollView) findViewById(R.id.content_view);
        this.mTvBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletTopUpPayResultActivity.this.f34788A.handleConfirmClick();
            }
        });
        this.f34793a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (WalletTopUpPayResultActivity.this.f34790C) {
                    WalletTopUpPayResultActivity.this.f34788A.handleBackClick();
                } else if (WalletCommonParamsUtil.isPassengerClient()) {
                    DRouter.build("taxis99OneTravel://ride/backhome?groupType=wallet").start(WalletTopUpPayResultActivity.this.getContext());
                } else {
                    DRouter.build("99pay://one/nativeWallet").start(WalletTopUpPayResultActivity.this.getContext());
                }
            }
        });
        initLoadingDialog(this, R.id.history_contacts_title_bar);
        this.f34812t.setListener(new WalletOperationBannerContract.Listener() {
            public void onOperationItemClicked(WalletOperationItem walletOperationItem) {
                WalletTopUpPayResultActivity.this.f34788A.onOperationItemClicked(walletOperationItem);
            }

            public void onOperationItemShown(WalletOperationItem walletOperationItem) {
                WalletTopUpPayResultActivity.this.f34788A.onOperationItemShown(walletOperationItem);
            }
        });
    }

    public void showLoadingStart() {
        this.mTvBtn.setEnabled(false);
    }

    public void showCountdownLoading(int i, int i2) {
        if (this.f34796d.getVisibility() != 0) {
            this.f34796d.setVisibility(0);
        }
        if (this.f34795c.getVisibility() != 0) {
            this.f34795c.setVisibility(0);
        }
        this.f34815w.setVisibility(8);
        this.f34811s.setVisibility(8);
        this.f34807o.setVisibility(8);
        this.f34812t.setVisibility(8);
        CircleLoadingView circleLoadingView = this.f34796d;
        circleLoadingView.setText(i + ExifInterface.LATITUDE_SOUTH);
        this.f34796d.setProgress((double) i2);
    }

    /* renamed from: a */
    private void m26568a() {
        if (this.f34796d.getVisibility() != 8) {
            this.f34796d.setVisibility(8);
        }
        if (this.f34795c.getVisibility() != 8) {
            this.f34795c.setVisibility(8);
        }
        this.f34815w.setVisibility(0);
    }

    public void showLoadingFinish(WalletPayResultResp.PayResultData payResultData) {
        if (!this.f34788A.isSupportCountdonw()) {
            m26568a();
            if (payResultData == null) {
                return;
            }
        } else if (payResultData != null) {
            m26568a();
        } else {
            return;
        }
        refreshUIData(payResultData);
        m26581b(payResultData);
        m26571a(payResultData);
        m26573a(payResultData.pop);
    }

    /* renamed from: a */
    private void m26571a(WalletPayResultResp.PayResultData payResultData) {
        if (payResultData != null && payResultData.commonResourceState != null && isVisible2User()) {
            FinResUtils.INSTANCE.showFinSysPopUpDlg(this, payResultData.commonResourceState.getPopUpState());
        }
    }

    /* renamed from: a */
    private void m26573a(WalletPayResultResp.PopInfo popInfo) {
        if (popInfo != null && "0".equals(popInfo.type)) {
            new TopupPrepaidDialog(popInfo).show(getSupportFragmentManager(), "prepaid");
        }
    }

    /* renamed from: b */
    private void m26581b(WalletPayResultResp.PayResultData payResultData) {
        if (this.f34817y == null) {
            this.f34817y = new WalletOrderSharePicView(this);
            WalletOrderDetailSharePicAdapter walletOrderDetailSharePicAdapter = new WalletOrderDetailSharePicAdapter(this, this.f34788A.isTopupByDriver());
            this.f34818z = walletOrderDetailSharePicAdapter;
            this.f34817y.setAdapter(walletOrderDetailSharePicAdapter);
        }
        if (this.f34816x == null) {
            WalletOrderSharePicPresenter walletOrderSharePicPresenter = new WalletOrderSharePicPresenter(this, this.f34817y);
            walletOrderSharePicPresenter.setLoadingView(this);
            this.f34816x = walletOrderSharePicPresenter;
        }
        WalletOrderDetailSharePicAdapter walletOrderDetailSharePicAdapter2 = this.f34818z;
        if (walletOrderDetailSharePicAdapter2 != null) {
            walletOrderDetailSharePicAdapter2.setData(payResultData);
        }
    }

    /* access modifiers changed from: protected */
    public void refreshUIData(WalletPayResultResp.PayResultData payResultData) {
        if (!this.f34790C) {
            this.f34793a.setImageDrawable(ResourcesHelper.getDrawable(this, R.drawable.wallet_global_paymethod_adddialog_close));
        }
        this.mTvBtn.setEnabled(true);
        this.f34800h.setVisibility(0);
        if (payResultData != null) {
            if (payResultData.share) {
                m26580b();
            } else {
                this.f34808p.setVisibility(8);
            }
            this.f34812t.updateContent(payResultData.operationSection);
            WalletPayResultResp.RuleLimitDetailVo ruleLimitDetailVo = payResultData.ruleLimitDetail;
            if (ruleLimitDetailVo != null) {
                String str = ruleLimitDetailVo.text;
                final String str2 = ruleLimitDetailVo.link;
                this.f34807o.setText(TextHighlightUtil.highlight(str, Color.parseColor("#000000"), Color.parseColor("#FF8040")));
                this.f34807o.setOnClickListener(new DoubleCheckOnClickListener() {
                    public void doClick(View view) {
                        if (!TextUtils.isEmpty(str2)) {
                            DRouter.build(str2).start(WalletTopUpPayResultActivity.this);
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("pub_page", "order_finish");
                        hashMap.put("pub_target", "text");
                        hashMap.put("pub_biz", "fintech");
                        hashMap.put("product_line", Integer.valueOf(WalletTopUpPayResultActivity.this.f34791D));
                        hashMap.put("text_theme", LoginOmegaUtil.NEED_VERIFY_EMAIL);
                        hashMap.put("button_name", "text");
                        hashMap.put("kyc_tag", Integer.valueOf(WalletSecuritySPUtils.getKycTag()));
                        PayTracker.trackEvent("ibt_fintech_passenger_text_ck", hashMap);
                    }
                });
                this.f34807o.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
                if (this.f34807o.getVisibility() == 0) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("pub_page", "order_finish");
                    hashMap.put("pub_target", "text");
                    hashMap.put("pub_biz", "fintech");
                    hashMap.put("product_line", Integer.valueOf(this.f34791D));
                    hashMap.put("text_theme", LoginOmegaUtil.NEED_VERIFY_EMAIL);
                    hashMap.put("kyc_tag", Integer.valueOf(WalletSecuritySPUtils.getKycTag()));
                    PayTracker.trackEvent("ibt_fintech_passenger_text_sw", hashMap);
                }
            } else {
                this.f34807o.setText((CharSequence) null);
                this.f34807o.setVisibility(8);
                this.f34807o.setOnClickListener((View.OnClickListener) null);
            }
            boolean isTopupByDriver = this.f34788A.isTopupByDriver();
            int i = R.drawable.wallet_transfer_icon_failed;
            if (isTopupByDriver) {
                if (payResultData.status == 1) {
                    i = R.drawable.wallet_transfer_icon_success;
                } else if (payResultData.status == 0) {
                    i = R.drawable.wallet_transfer_icon_processing;
                }
                if (i != -1) {
                    this.f34801i.setVisibility(0);
                    this.f34801i.setImageResource(i);
                    this.f34804l.setPadding(0, 0, 0, 0);
                    this.f34803k.setPadding(0, 0, 0, 0);
                } else {
                    this.f34801i.setVisibility(8);
                    this.f34804l.setPadding(this.f34789B, 0, 0, 0);
                    this.f34803k.setPadding(this.f34789B, 0, 0, 0);
                }
            } else {
                if (payResultData.status == 1) {
                    showFlowerAnimation();
                    i = R.drawable.wallet_transfer_icon_success;
                } else if (payResultData.status == 0 || payResultData.status == 6) {
                    i = R.drawable.wallet_transfer_icon_processing;
                }
                this.f34801i.setImageResource(i);
            }
            this.f34804l.setText(payResultData.resultMainTitle);
            this.f34805m.setText(payResultData.amount);
            this.f34806n.setText(payResultData.currencySymbol);
            if (this.f34788A.isTopupByDriver()) {
                this.mTvBtn.setText(R.string.GRider_Riders_Send_it_fAPb);
            }
            if (payResultData.status == 0 && this.f34788A.isCancelableOrder()) {
                this.mTvBtn.setBackgroundResource(R.drawable.wallet_topup_order_detail_cancel_btn_selector);
                this.mTvBtn.setText(R.string.GRider_Riders_Cancel_this_zJFP);
                this.mTvBtn.setTextColor(ResourcesHelper.getColor(this, R.color.ggk_color_666666));
                this.f34811s.setVisibility(0);
                this.mTvBtn.setVisibility(0);
                this.f34810r.setVisibility(8);
            } else if (payResultData.status != 99 || !this.f34788A.isTopupByDriver()) {
                this.f34811s.setVisibility(8);
                this.mTvBtn.setVisibility(8);
            } else {
                try {
                    this.mTvBtn.setBackground(DidiThemeManager.getIns().getResPicker(this).getDrawable(R.attr.submit_btn_bg_selector));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.mTvBtn.setText(R.string.GRider_Riders_Send_it_fAPb);
                this.f34811s.setVisibility(0);
                this.mTvBtn.setVisibility(0);
                this.f34810r.setVisibility(8);
            }
            m26572a(payResultData, false);
            m26590e(payResultData);
            m26588d(payResultData);
            m26585c(payResultData);
        }
    }

    /* renamed from: c */
    private void m26585c(final WalletPayResultResp.PayResultData payResultData) {
        if (payResultData != null) {
            if (payResultData.status == 6 && this.f34792E == 260) {
                this.f34811s.setVisibility(0);
                this.mTvBtn.setVisibility(0);
                this.mTvBtn.setText(getString(R.string.Fintech_Payment_optimization_Payment_iJVF));
                this.f34810r.setVisibility(0);
                this.f34810r.setOnClickListener(new DoubleCheckOnClickListener() {
                    public void doClick(View view) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("g_BizId", "Boleto");
                        hashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
                        hashMap.put("button_name", "Cancel Payment");
                        PayTracker.trackEvent("fin_boleto_unpaidpage_btn_ck", hashMap);
                        WalletTopUpPayResultActivity.this.m26579a(payResultData.cancelTitle, payResultData.cancelSubTitle);
                    }
                });
                HashMap hashMap = new HashMap();
                hashMap.put("g_BizId", "Boleto");
                hashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
                PayTracker.trackEvent("fin_boleto_unpaidpage_sw", hashMap);
                return;
            }
            this.f34811s.setVisibility(8);
            this.mTvBtn.setVisibility(8);
            this.f34810r.setVisibility(8);
            m26569a(this.f34791D, this.f34792E, payResultData.status);
        }
    }

    /* renamed from: d */
    private void m26588d(WalletPayResultResp.PayResultData payResultData) {
        PayResultAdapter payResultAdapter = ((payResultData.status == 1 || payResultData.status == 2) && this.f34791D == 605) ? new PayResultAdapter() : null;
        if (payResultAdapter != null) {
            if (!payResultData.share) {
                payResultAdapter.onTitleBarUI();
            }
            payResultAdapter.onPageTitleUI();
            payResultAdapter.onTableViewUI();
            if (!this.f34788A.isTopupByDriver()) {
                payResultAdapter.onBottomBtnUI();
            }
        }
    }

    /* renamed from: b */
    private void m26580b() {
        this.f34808p.setVisibility(0);
        this.f34808p.setImageResource(R.drawable.wallet_topup_share_entrance_icon);
        this.f34808p.setOnClickListener(new FastCheckOnClickListener() {
            public void doClick(View view) {
                if (WalletTopUpPayResultActivity.this.f34816x != null) {
                    WalletTopUpPayResultActivity.this.f34816x.onShareClicked();
                }
            }
        });
        this.f34794b.setVisibility(8);
        PayTracker.trackEvent("ibt_didipay_receipt_sharing_sw");
    }

    /* renamed from: e */
    private void m26590e(WalletPayResultResp.PayResultData payResultData) {
        if (payResultData != null) {
            if (!TextUtils.isEmpty(payResultData.resultSubTitle)) {
                this.f34809q.setVisibility(0);
                this.f34809q.setText(payResultData.resultSubTitle);
                if (!TextUtils.isEmpty(payResultData.subTitleColor)) {
                    this.f34809q.setTextColor(Color.parseColor(payResultData.subTitleColor));
                }
                if (!TextUtils.isEmpty(payResultData.subTitleBgColor)) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setColor(Color.parseColor(payResultData.subTitleBgColor));
                    gradientDrawable.setCornerRadius((float) UIUtil.dip2px(getContext(), 16.0f));
                    this.f34809q.setBackground(gradientDrawable);
                }
            } else {
                this.f34809q.setVisibility(8);
            }
            if (!CollectionUtil.isEmpty((Collection) payResultData.rechargeStatement) && !CollectionUtil.isEmpty((Collection) payResultData.payeeStatement)) {
                this.f34802j.removeAllViews();
                View inflate = LayoutInflater.from(this).inflate(R.layout.wallet_boleto_detail_title_view, this.f34802j, false);
                ((TextView) inflate.findViewById(R.id.pay_result_item_content)).setText(payResultData.rechargeStatementTile);
                this.f34802j.addView(inflate);
                for (WalletPayResultResp.ItemModel next : payResultData.rechargeStatement) {
                    View inflate2 = LayoutInflater.from(this).inflate(R.layout.wallet_global_activity_topup_pay_result_item_view, this.f34802j, false);
                    TextView textView = (TextView) inflate2.findViewById(R.id.pay_result_item_content);
                    ((TextView) inflate2.findViewById(R.id.pay_result_item_title)).setText(next.title);
                    textView.setText(next.value);
                    if (next.color != null && !TextUtils.isEmpty(next.color)) {
                        textView.setTextColor(Color.parseColor(next.color));
                    }
                    if (next.isBold) {
                        textView.setTypeface(Typeface.defaultFromStyle(1));
                    }
                    this.f34802j.addView(inflate2);
                }
                this.f34802j.addView(LayoutInflater.from(this).inflate(R.layout.wallet_boleto_history_dash_line_view, this.f34802j, false));
                View inflate3 = LayoutInflater.from(this).inflate(R.layout.wallet_boleto_detail_title_view, this.f34802j, false);
                ((TextView) inflate3.findViewById(R.id.pay_result_item_content)).setText(payResultData.payeeStatementTitle);
                this.f34802j.addView(inflate3);
                for (WalletPayResultResp.ItemModel next2 : payResultData.payeeStatement) {
                    View inflate4 = LayoutInflater.from(this).inflate(R.layout.wallet_global_activity_topup_pay_result_item_view, this.f34802j, false);
                    TextView textView2 = (TextView) inflate4.findViewById(R.id.pay_result_item_content);
                    ((TextView) inflate4.findViewById(R.id.pay_result_item_title)).setText(next2.title);
                    textView2.setText(next2.value);
                    if (next2.color != null && !TextUtils.isEmpty(next2.color)) {
                        textView2.setTextColor(Color.parseColor(next2.color));
                    }
                    if (next2.isBold) {
                        textView2.setTypeface(Typeface.defaultFromStyle(1));
                    }
                    this.f34802j.addView(inflate4);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26572a(final WalletPayResultResp.PayResultData payResultData, boolean z) {
        if (payResultData != null && !CollectionUtil.isEmpty((Collection) payResultData.statement)) {
            LinkedList<WalletPayResultResp.ItemModel> linkedList = new LinkedList<>(payResultData.statement);
            if (z && !CollectionUtil.isEmpty((Collection) payResultData.statementExtend)) {
                linkedList.addAll(payResultData.statementExtend);
            }
            this.f34802j.removeAllViews();
            this.f34802j.addView(LayoutInflater.from(this).inflate(R.layout.wallet_boleto_detail_title_view, this.f34802j, false));
            for (WalletPayResultResp.ItemModel itemModel : linkedList) {
                View inflate = LayoutInflater.from(this).inflate(R.layout.wallet_global_activity_topup_pay_result_item_view, this.f34802j, false);
                TextView textView = (TextView) inflate.findViewById(R.id.pay_result_item_title);
                TextView textView2 = (TextView) inflate.findViewById(R.id.pay_result_item_content);
                textView.setText(itemModel.title);
                textView2.setText(itemModel.value);
                if (itemModel.color != null && !TextUtils.isEmpty(itemModel.color)) {
                    textView.setTextColor(Color.parseColor(itemModel.color));
                    textView2.setTextColor(Color.parseColor(itemModel.color));
                }
                this.f34802j.addView(inflate);
            }
            if (!z && !CollectionUtil.isEmpty((Collection) payResultData.statementExtend)) {
                PayTracker.trackEvent("ibt_didipay_full_receipt_sw");
                View inflate2 = LayoutInflater.from(this).inflate(R.layout.wallet_global_activity_topup_pay_result_extend_view, this.f34802j, false);
                inflate2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        PayTracker.trackEvent("ibt_didipay_full_receipt_ck");
                        WalletTopUpPayResultActivity.this.m26572a(payResultData, true);
                    }
                });
                this.f34802j.addView(inflate2);
            }
            if (!CollectionUtil.isEmpty((Collection) payResultData.expirationReminder)) {
                this.f34802j.addView(LayoutInflater.from(this).inflate(R.layout.wallet_boleto_history_dash_line_view, this.f34802j, false));
                for (String text : payResultData.expirationReminder) {
                    View inflate3 = LayoutInflater.from(this).inflate(R.layout.wallet_boleto_history_bottom_desc_text, this.f34802j, false);
                    ((TextView) inflate3.findViewById(R.id.desc_tv)).setText(text);
                    this.f34802j.addView(inflate3);
                }
            } else if (!TextUtils.isEmpty(payResultData.resultSubTitle)) {
                this.f34803k.setVisibility(8);
                this.f34802j.addView(LayoutInflater.from(this).inflate(R.layout.wallet_boleto_history_dash_line_view, this.f34802j, false));
                View inflate4 = LayoutInflater.from(this).inflate(R.layout.wallet_boleto_history_bottom_desc_text, this.f34802j, false);
                ((TextView) inflate4.findViewById(R.id.desc_tv)).setText(payResultData.resultSubTitle);
                this.f34802j.addView(inflate4);
            }
        }
    }

    public void onBackPressed() {
        if (this.f34788A != null) {
            if (!this.f34790C) {
                setResult(-1);
            }
            this.f34788A.handleBackClick();
        }
    }

    public void showFlowerAnimation() {
        if (this.f34799g == null) {
            new LottieTask(new Callable<LottieResult<LottieComposition>>() {
                public LottieResult<LottieComposition> call() {
                    return WalletTopUpPayResultActivity.this.m26584c();
                }
            }).addListener(new LottieListener<LottieComposition>() {
                public void onResult(LottieComposition lottieComposition) {
                    WalletTopUpPayResultActivity.this.m26570a(lottieComposition);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public LottieResult<LottieComposition> m26584c() {
        try {
            return LottieCompositionFactory.fromJsonInputStreamSync(getAssets().open("installment_firework.json"), (String) null);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26570a(LottieComposition lottieComposition) {
        try {
            LottieAnimationView lottieAnimationView = new LottieAnimationView(getContext());
            this.f34799g = lottieAnimationView;
            lottieAnimationView.setLayoutParams(new FrameLayout.LayoutParams(-1, UIUtil.dip2px(this, 800.0f)));
            this.f34799g.setComposition(lottieComposition);
            this.f34799g.playAnimation();
            this.f34813u.addView(this.f34799g);
            this.f34799g.addAnimatorListener(new Animator.AnimatorListener() {
                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    WalletTopUpPayResultActivity.this.m26587d();
                }

                public void onAnimationCancel(Animator animator) {
                    WalletTopUpPayResultActivity.this.m26587d();
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m26587d() {
        try {
            if (this.f34799g != null) {
                if (this.f34799g.getParent() == null) {
                    this.f34799g = null;
                    return;
                }
                this.f34799g.removeAllAnimatorListeners();
                ((ViewGroup) this.f34799g.getParent()).removeView(this.f34799g);
                this.f34799g = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (i == 100) {
            if (intent.getIntExtra("code", 3) == 1 && this.f34788A != null) {
                this.f34790C = false;
                this.f34793a.setImageDrawable(ResourcesHelper.getDrawable(this, R.drawable.wallet_global_paymethod_adddialog_close));
                this.f34788A.startPollingStatus();
            }
        } else if (i == 200 && intent.getIntExtra("code", 3) == 1 && this.f34788A != null) {
            this.f34790C = false;
            this.f34793a.setImageDrawable(ResourcesHelper.getDrawable(this, R.drawable.wallet_global_paymethod_adddialog_close));
            this.f34788A.startPollingStatus();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26579a(String str, String str2) {
        if (str == null) {
            str = getString(R.string.GRider_reminder_Are_you_tLEI);
        }
        if (str2 == null) {
            str2 = "";
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.wallet_dialog_extended_rich_title_view, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(R.id.wallet_extended_dialog_subtitle);
        NViewUtils.INSTANCE.setText2HighLight((TextView) inflate.findViewById(R.id.wallet_extended_dialog_title), str, Color.parseColor("#000000"), Color.parseColor(ColorUtils.DIDI_GREEN_MOUTON));
        textView.setVisibility(0);
        textView.setText(str2);
        C1211912 r9 = new LEGODrawerModel1("", new LEGOBtnTextAndCallback(getContext().getString(R.string.Wallet_App_Onboarding_Confirmation_NpIr), new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (WalletTopUpPayResultActivity.this.f34814v != null && WalletTopUpPayResultActivity.this.f34814v.isShowing()) {
                    WalletTopUpPayResultActivity.this.f34814v.dismiss();
                    if (WalletTopUpPayResultActivity.this.f34788A != null) {
                        WalletTopUpPayResultActivity.this.m26578a("Confirm");
                        WalletTopUpPayResultActivity.this.f34788A.onCancelBtnClick();
                    }
                }
            }
        })) {
            /* access modifiers changed from: protected */
            public LEGODrawerModel convertOthers(LEGODrawerModel lEGODrawerModel) {
                lEGODrawerModel.isTwoBtnHorizontal = true;
                return lEGODrawerModel;
            }
        };
        r9.setExtendedView(inflate);
        r9.addMinorBtn(new LEGOBtnTextAndCallback(getContext().getString(R.string.Wallet_App_window_Not_now_fzRN), new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (WalletTopUpPayResultActivity.this.f34814v != null && WalletTopUpPayResultActivity.this.f34814v.isShowing()) {
                    WalletTopUpPayResultActivity.this.m26578a("Not Now");
                    WalletTopUpPayResultActivity.this.f34814v.dismiss();
                }
            }
        }));
        this.f34814v = LEGOUICreator.showDrawerTemplate(this, r9);
        HashMap hashMap = new HashMap();
        hashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        hashMap.put("g_BizId", "Boleto");
        PayTracker.trackEvent("fin_boleto_cancel_popup_sw", hashMap);
    }

    class PayResultAdapter implements IPayResultUI {
        public void onBottomBtnUI() {
        }

        public void onPageTitleUI() {
        }

        public void onTableViewUI() {
        }

        public void onTitleBarUI() {
        }

        PayResultAdapter() {
        }
    }

    /* renamed from: a */
    private void m26569a(int i, int i2, int i3) {
        String str = i2 == 256 ? HistoryRecordConstant.VAMOS_HISTORY : "trans_page";
        HashMap hashMap = new HashMap();
        hashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        hashMap.put("product_line", Integer.toString(i));
        hashMap.put("wallet_trans_result", Integer.toString(i3));
        hashMap.put("pub_from_page", str);
        PayTracker.trackEvent("fin_transresult_sw", hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26578a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        hashMap.put("g_BizId", "Boleto");
        hashMap.put("button_name", str);
        PayTracker.trackEvent("fin_boleto_cancel_popup_ck", hashMap);
    }
}
