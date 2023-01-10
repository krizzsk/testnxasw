package com.didi.payment.transfer.orderdetail;

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
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.LottieTask;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.finResource.FinResUtils;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.TextHighlightUtil;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.base.widget.CircleLoadingView;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.base.widget.FastCheckOnClickListener;
import com.didi.payment.commonsdk.utils.NCommonShareManager;
import com.didi.payment.transfer.DebugUtil;
import com.didi.payment.transfer.common.TransBaseActivity;
import com.didi.payment.transfer.constants.TransferContants;
import com.didi.payment.transfer.orderdetail.presenter.IOrderDetailPresenter;
import com.didi.payment.transfer.orderdetail.presenter.TransOrderDetailPresenter;
import com.didi.payment.transfer.orderdetail.presenter.TransOrderDetailPresenter2;
import com.didi.payment.transfer.orderdetail.presenter.TransOrderSharePicPresenter;
import com.didi.payment.transfer.orderdetail.presenter.TransPayResultResp;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.transfer.utils.TransOmegaUtil;
import com.didi.payment.transfer.widget.TransProcessItemView;
import com.didi.payment.wallet.global.model.resp.WalletPayResultResp;
import com.didi.payment.wallet.global.omega.GlobalOmegaConstant;
import com.didi.payment.wallet.global.utils.WalletSecuritySPUtils;
import com.didi.payment.wallet.global.wallet.contract.WalletOrderSharePicContract;
import com.didi.payment.wallet.global.wallet.view.view.WalletOrderSharePicView;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.taxis99.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

public class TransOrderDetailActivity extends TransBaseActivity<IOrderDetailPresenter> implements ITransOrderDetailView {

    /* renamed from: A */
    private View f33973A;

    /* renamed from: B */
    private View f33974B;

    /* renamed from: b */
    private ImageView f33975b;

    /* renamed from: c */
    private ImageView f33976c;

    /* renamed from: d */
    private RelativeLayout f33977d;

    /* renamed from: e */
    private View f33978e;

    /* renamed from: f */
    private View f33979f;

    /* renamed from: g */
    private CircleLoadingView f33980g;

    /* renamed from: h */
    private TextView f33981h;
    protected boolean hasValid99PayAccount = false;

    /* renamed from: i */
    private View f33982i;

    /* renamed from: j */
    private ImageView f33983j;

    /* renamed from: k */
    private LinearLayout f33984k;

    /* renamed from: l */
    private TextView f33985l;

    /* renamed from: m */
    private TextView f33986m;
    protected int mConfirmBtnDismiss = -1;
    protected int mOrderType = -1;
    protected int mProductLine = -1;
    protected TextView mTvTitle;

    /* renamed from: n */
    private TextView f33987n;

    /* renamed from: o */
    private View f33988o;

    /* renamed from: p */
    private TextView f33989p;

    /* renamed from: q */
    private TextView f33990q;

    /* renamed from: r */
    private LottieAnimationView f33991r;

    /* renamed from: s */
    private RelativeLayout f33992s;

    /* renamed from: t */
    private TextView f33993t;

    /* renamed from: u */
    private TextView f33994u;

    /* renamed from: v */
    private WalletOrderSharePicContract.View f33995v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public WalletOrderSharePicContract.Presenter f33996w;

    /* renamed from: x */
    private TransOrderDetailSharePicAdapter f33997x;

    /* renamed from: y */
    private LinearLayout f33998y;

    /* renamed from: z */
    private int f33999z = -1;

    /* access modifiers changed from: protected */
    public int getFragContainerId() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.trans_orderdetail_act_lay;
    }

    /* access modifiers changed from: protected */
    public int onBindLoadingBarTo() {
        return R.id.history_contacts_title_bar;
    }

    public void onNetworkError() {
    }

    public static void launch(Context context, int i, int i2, String str, int i3, boolean z) {
        Intent intent = new Intent(context, TransOrderDetailActivity.class);
        intent.putExtra(TransferContants.IntentKey.INTENT_PARAM_KEY_PRODUCT_LINE, i2);
        intent.putExtra(TransferContants.IntentKey.INTENT_PARAM_KEY_ORDER_ID, str);
        intent.putExtra(TransferContants.IntentKey.INTENT_PARAM_KEY_ORDER_TYPE, i3);
        intent.putExtra(TransferContants.IntentKey.INTENT_PARAMS_KEY_HAS99PAY, z);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i);
            return;
        }
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static void launch(Context context, int i, Bundle bundle) {
        Intent intent = new Intent(context, TransOrderDetailActivity.class);
        intent.putExtras(bundle);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i);
            return;
        }
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public IOrderDetailPresenter onCreatePresenter() {
        if (this.hasValid99PayAccount) {
            return new TransOrderDetailPresenter(this, this);
        }
        return new TransOrderDetailPresenter2(this, this);
    }

    public void onPageFinish() {
        finish();
    }

    public void showShareWindow(String str) {
        new NCommonShareManager().showSimpleStrShareWindow(this, str);
    }

    /* access modifiers changed from: protected */
    public void parseIntentData(Intent intent) {
        this.mOrderType = getIntent().getIntExtra(TransferContants.IntentKey.INTENT_PARAM_KEY_ORDER_TYPE, -1);
        this.mProductLine = getIntent().getIntExtra(TransferContants.IntentKey.INTENT_PARAM_KEY_PRODUCT_LINE, -1);
        this.mConfirmBtnDismiss = getIntent().getIntExtra("confirm_button_dismiss", 0);
        this.f33999z = intent.getIntExtra(TransferContants.IntentKey.INTENT_PARAM_KEY_FROM_PAGE, -1);
        this.hasValid99PayAccount = getIntent().getBooleanExtra(TransferContants.IntentKey.INTENT_PARAMS_KEY_HAS99PAY, false);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        initStatusBar();
        ((IOrderDetailPresenter) this.mPresenter).executeTask();
    }

    /* access modifiers changed from: protected */
    public void initStatusBar() {
        setTheme(R.style.GlobalActivityTheme);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.transparent));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        this.f33992s = (RelativeLayout) findViewById(R.id.root_view_layout);
        this.f33979f = findViewById(R.id.order_status_super_scroll_parent);
        this.f33974B = findViewById(R.id.trans_orderstatus_cdloading_parent);
        this.f33980g = (CircleLoadingView) findViewById(R.id.trans_pay_result_circleloading_view);
        this.f33981h = (TextView) findViewById(R.id.trans_pay_result_loading_desc);
        this.f33973A = findViewById(R.id.trans_pageerr_retry2load_rl_root);
        this.f33988o = findViewById(R.id.transfer_order_bottom_operation_view);
        this.f33989p = (TextView) findViewById(R.id.transfer_order_cancel_btn);
        this.f33990q = (TextView) findViewById(R.id.transfer_remind_receiver_btn);
        TextView textView = (TextView) findViewById(R.id.tv_title);
        this.mTvTitle = textView;
        textView.setText(R.string.transfer_top_up_pay_result_title);
        this.f33975b = (ImageView) findViewById(R.id.iv_left);
        this.f33976c = (ImageView) findViewById(R.id.iv_right);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.history_contacts_title_bar);
        this.f33977d = relativeLayout;
        relativeLayout.setBackgroundColor(ResourcesHelper.getColor(this, R.color.transparent));
        View findViewById = findViewById(R.id.divider_line);
        this.f33978e = findViewById;
        findViewById.setVisibility(8);
        this.f33993t = (TextView) findViewById(R.id.tv_limit_info);
        this.f33994u = (TextView) findViewById(R.id.bubble_area_tv);
        this.f33998y = (LinearLayout) findViewById(R.id.trans_process_items_container);
        this.f33982i = findViewById(R.id.transfer_orderdetail_content_rl);
        this.f33983j = (ImageView) findViewById(R.id.transfer_orderdetail_card_icon_iv);
        this.f33984k = (LinearLayout) findViewById(R.id.pay_result_page_card_ll);
        this.f33985l = (TextView) findViewById(R.id.transfer_order_detail_card_main_title_tv);
        this.f33986m = (TextView) findViewById(R.id.pay_result_amount_price_tv);
        this.f33987n = (TextView) findViewById(R.id.pay_result_amount_symbol_tv);
        this.f33989p.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                TransOmegaUtil.trackEventWithGlobal("ibt_didipay_p2p_99pay_result_pending_recall_ck", TransGlobalOmegaKey.KEY_WALLET_PAGEID, TransGlobalOmegaKey.KEY_ACCOUNT_STATUS, TransGlobalOmegaKey.KEY_PAYEE_99ACCOUNT_STATUS, TransGlobalOmegaKey.KEY_PAYEE_99PAY_ACCOUNT_STATUS);
                ((IOrderDetailPresenter) TransOrderDetailActivity.this.mPresenter).onOperationButtonClick(IOrderDetailPresenter.OperationType.CANCEL_TRANSFER);
            }
        });
        this.f33990q.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                TransOmegaUtil.trackEventWithGlobal("ibt_didipay_p2p_99pay_result_pending_invite_ck", TransGlobalOmegaKey.KEY_WALLET_PAGEID, TransGlobalOmegaKey.KEY_ACCOUNT_STATUS, TransGlobalOmegaKey.KEY_PAYEE_99ACCOUNT_STATUS, TransGlobalOmegaKey.KEY_PAYEE_99PAY_ACCOUNT_STATUS);
                ((IOrderDetailPresenter) TransOrderDetailActivity.this.mPresenter).onOperationButtonClick(IOrderDetailPresenter.OperationType.REMIND_RECIEVER);
            }
        });
        if (this.mConfirmBtnDismiss == 1) {
            this.f33988o.setVisibility(8);
        }
        this.f33975b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ((IOrderDetailPresenter) TransOrderDetailActivity.this.mPresenter).handleBackClick();
            }
        });
    }

    public void onShowPageLoadding() {
        if (!((IOrderDetailPresenter) this.mPresenter).isSupportCountdonw()) {
            super.onShowPageLoadding();
        }
        if (this.f33989p.getVisibility() == 0) {
            this.f33989p.setEnabled(false);
        }
        if (this.f33990q.getVisibility() == 0) {
            this.f33990q.setEnabled(false);
        }
    }

    public void onDismissPageLoadding() {
        if (!((IOrderDetailPresenter) this.mPresenter).isSupportCountdonw()) {
            super.onDismissPageLoadding();
        }
        if (this.f33989p.getVisibility() == 0) {
            this.f33989p.setEnabled(true);
        }
        if (this.f33990q.getVisibility() == 0) {
            this.f33990q.setEnabled(true);
        }
    }

    public void onUpdateCountDownLoading(int i, int i2) {
        if (this.f33974B.getVisibility() != 0) {
            this.f33974B.setVisibility(0);
        }
        CircleLoadingView circleLoadingView = this.f33980g;
        circleLoadingView.setText(i + ExifInterface.LATITUDE_SOUTH);
        this.f33980g.setProgress((double) i2);
    }

    public void stopCountdownLoading() {
        this.f33974B.setVisibility(8);
    }

    public void onGotOrderStatus(TransPayResultResp.PayResultData payResultData) {
        refreshOrderStatusView(payResultData);
        m25884b(payResultData);
        m25879a(payResultData);
    }

    /* renamed from: a */
    private void m25879a(TransPayResultResp.PayResultData payResultData) {
        if (payResultData != null && payResultData.commonResourceState != null && this.isInActive) {
            FinResUtils.INSTANCE.showFinSysPopUpDlg(this, payResultData.commonResourceState.getPopUpState());
        }
    }

    /* renamed from: b */
    private void m25884b(TransPayResultResp.PayResultData payResultData) {
        if (this.f33995v == null) {
            this.f33995v = new WalletOrderSharePicView(this);
            TransOrderDetailSharePicAdapter transOrderDetailSharePicAdapter = new TransOrderDetailSharePicAdapter(this);
            this.f33997x = transOrderDetailSharePicAdapter;
            this.f33995v.setAdapter(transOrderDetailSharePicAdapter);
        }
        if (this.f33996w == null) {
            TransOrderSharePicPresenter transOrderSharePicPresenter = new TransOrderSharePicPresenter(this, this.f33995v);
            transOrderSharePicPresenter.setLoadingView(this);
            this.f33996w = transOrderSharePicPresenter;
        }
        TransOrderDetailSharePicAdapter transOrderDetailSharePicAdapter2 = this.f33997x;
        if (transOrderDetailSharePicAdapter2 != null) {
            transOrderDetailSharePicAdapter2.setData(payResultData);
        }
    }

    /* access modifiers changed from: protected */
    public void refreshOrderStatusView(TransPayResultResp.PayResultData payResultData) {
        int i;
        int i2 = 0;
        if (payResultData == null) {
            DebugUtil.log("obtain order status data fail!", new Object[0]);
            m25883b();
            return;
        }
        if (payResultData.share) {
            m25875a();
        } else {
            this.f33976c.setVisibility(8);
        }
        if (this.f33973A.getVisibility() == 0) {
            this.f33973A.setVisibility(8);
        }
        this.f33979f.setVisibility(0);
        HashMap hashMap = new HashMap();
        hashMap.put("payment_result_status", payResultData.resultMainTitle);
        hashMap.put(GlobalOmegaConstant.SkuRiskLimit.PUB_PAGE_TRANSFER_METHOD, Integer.valueOf(payResultData.orderType));
        TransOmegaUtil.trackEventWithGlobal("ibt_didipay_transfer_result_sw", hashMap, TransGlobalOmegaKey.KEY_WALLET_PAGEID, TransGlobalOmegaKey.KEY_ACCOUNT_STATUS, TransGlobalOmegaKey.KEY_PAYEE_99ACCOUNT_STATUS, TransGlobalOmegaKey.KEY_PAYEE_99PAY_ACCOUNT_STATUS);
        if (TextUtils.isEmpty(payResultData.cancelBtnText) || TextUtils.isEmpty(payResultData.remindBtnText)) {
            this.f33988o.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f33979f.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.f33979f.setLayoutParams(layoutParams);
            this.f33979f.requestLayout();
        } else {
            this.f33988o.setVisibility(0);
            this.f33989p.setText(payResultData.cancelBtnText);
            this.f33990q.setText(payResultData.remindBtnText);
            this.f33989p.setEnabled(true);
            this.f33990q.setEnabled(true);
        }
        this.f33982i.setVisibility(0);
        if (payResultData.status == 1) {
            i = R.drawable.wallet_transfer_icon_success;
        } else {
            i = payResultData.status == 0 ? R.drawable.wallet_transfer_icon_processing : R.drawable.wallet_transfer_icon_failed;
        }
        this.f33983j.setVisibility(0);
        this.f33983j.setImageResource(i);
        if (payResultData.status == 1) {
            showFlowerAnimation();
        }
        this.f33985l.setText(payResultData.resultMainTitle);
        this.f33986m.setText(payResultData.amount);
        this.f33987n.setText(payResultData.currencySymbol);
        m25881a(payResultData.transferProcesses);
        m25880a(payResultData, payResultData.resultSubTitle, false);
        m25887c(payResultData);
        WalletPayResultResp.RuleLimitDetailVo ruleLimitDetailVo = payResultData.ruleLimitDetail;
        if (ruleLimitDetailVo != null) {
            String str = ruleLimitDetailVo.text;
            final String str2 = ruleLimitDetailVo.link;
            this.f33993t.setText(TextHighlightUtil.highlight(str, Color.parseColor("#000000"), Color.parseColor("#FF8040")));
            this.f33993t.setOnClickListener(new DoubleCheckOnClickListener() {
                public void doClick(View view) {
                    if (!TextUtils.isEmpty(str2)) {
                        DRouter.build(str2).start(TransOrderDetailActivity.this);
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("pub_page", "order_finish");
                    hashMap.put("pub_target", "text");
                    hashMap.put("pub_biz", "fintech");
                    hashMap.put("product_line", Integer.valueOf(TransOrderDetailActivity.this.mProductLine));
                    hashMap.put("text_theme", LoginOmegaUtil.NEED_VERIFY_EMAIL);
                    hashMap.put("button_name", "text");
                    hashMap.put("kyc_tag", Integer.valueOf(WalletSecuritySPUtils.getKycTag()));
                    PayTracker.trackEvent("ibt_fintech_passenger_text_ck", hashMap);
                }
            });
            TextView textView = this.f33993t;
            if (TextUtils.isEmpty(str)) {
                i2 = 8;
            }
            textView.setVisibility(i2);
            if (this.f33993t.getVisibility() == 0) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("pub_page", "order_finish");
                hashMap2.put("pub_target", "text");
                hashMap2.put("pub_biz", "fintech");
                hashMap2.put("product_line", Integer.valueOf(this.mProductLine));
                hashMap2.put("text_theme", LoginOmegaUtil.NEED_VERIFY_EMAIL);
                hashMap2.put("kyc_tag", Integer.valueOf(WalletSecuritySPUtils.getKycTag()));
                PayTracker.trackEvent("ibt_fintech_passenger_text_sw", hashMap2);
                return;
            }
            return;
        }
        this.f33993t.setVisibility(8);
    }

    /* renamed from: c */
    private void m25887c(TransPayResultResp.PayResultData payResultData) {
        if (payResultData != null) {
            if (!TextUtils.isEmpty(payResultData.resultSubTitle)) {
                this.f33994u.setVisibility(0);
                this.f33994u.setText(payResultData.resultSubTitle);
                if (!TextUtils.isEmpty(payResultData.subTitleColor)) {
                    this.f33994u.setTextColor(Color.parseColor(payResultData.subTitleColor));
                }
                if (!TextUtils.isEmpty(payResultData.subTitleBgColor)) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setColor(Color.parseColor(payResultData.subTitleBgColor));
                    gradientDrawable.setCornerRadius((float) UIUtil.dip2px(getContext(), 16.0f));
                    this.f33994u.setBackground(gradientDrawable);
                }
            } else {
                this.f33994u.setVisibility(8);
            }
            if (!CollectionUtil.isEmpty((Collection<?>) payResultData.rechargeStatement) && !CollectionUtil.isEmpty((Collection<?>) payResultData.payeeStatement)) {
                this.f33984k.removeAllViews();
                View inflate = LayoutInflater.from(this).inflate(R.layout.wallet_boleto_detail_title_view, this.f33984k, false);
                ((TextView) inflate.findViewById(R.id.pay_result_item_content)).setText(payResultData.rechargeStatementTile);
                this.f33984k.addView(inflate);
                for (TransPayResultResp.ItemModel next : payResultData.rechargeStatement) {
                    View inflate2 = LayoutInflater.from(this).inflate(R.layout.trans_orderdetail_item_lay, this.f33984k, false);
                    TextView textView = (TextView) inflate2.findViewById(R.id.pay_result_item_content);
                    ((TextView) inflate2.findViewById(R.id.pay_result_item_title)).setText(next.title);
                    textView.setText(next.value);
                    if (next.color != null && !TextUtils.isEmpty(next.color)) {
                        textView.setTextColor(Color.parseColor(next.color));
                    }
                    if (next.isBold) {
                        textView.setTypeface(Typeface.defaultFromStyle(1));
                    }
                    this.f33984k.addView(inflate2);
                }
                this.f33984k.addView(LayoutInflater.from(this).inflate(R.layout.wallet_boleto_history_dash_line_view, this.f33984k, false));
                View inflate3 = LayoutInflater.from(this).inflate(R.layout.wallet_boleto_detail_title_view, this.f33984k, false);
                ((TextView) inflate3.findViewById(R.id.pay_result_item_content)).setText(payResultData.payeeStatementTitle);
                this.f33984k.addView(inflate3);
                for (TransPayResultResp.ItemModel next2 : payResultData.payeeStatement) {
                    View inflate4 = LayoutInflater.from(this).inflate(R.layout.trans_orderdetail_item_lay, this.f33984k, false);
                    TextView textView2 = (TextView) inflate4.findViewById(R.id.pay_result_item_content);
                    ((TextView) inflate4.findViewById(R.id.pay_result_item_title)).setText(next2.title);
                    textView2.setText(next2.value);
                    if (next2.color != null && !TextUtils.isEmpty(next2.color)) {
                        textView2.setTextColor(Color.parseColor(next2.color));
                    }
                    if (next2.isBold) {
                        textView2.setTypeface(Typeface.defaultFromStyle(1));
                    }
                    this.f33984k.addView(inflate4);
                }
            }
        }
    }

    /* renamed from: a */
    private void m25875a() {
        this.f33976c.setVisibility(0);
        this.f33976c.setImageResource(R.drawable.wallet_topup_share_entrance_icon);
        this.f33976c.setOnClickListener(new FastCheckOnClickListener() {
            public void doClick(View view) {
                if (TransOrderDetailActivity.this.f33996w != null) {
                    TransOrderDetailActivity.this.f33996w.onShareClicked();
                }
            }
        });
        PayTracker.trackEvent("ibt_didipay_receipt_sharing_sw");
    }

    /* renamed from: b */
    private void m25883b() {
        this.f33973A.setVisibility(0);
        this.f33973A.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                ((IOrderDetailPresenter) TransOrderDetailActivity.this.mPresenter).executeTask();
            }
        });
    }

    /* renamed from: a */
    private void m25881a(List<TransPayResultResp.TransferProcess> list) {
        TransProcessItemView.ItemType itemType;
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            this.f33998y.setVisibility(8);
            return;
        }
        int i = 0;
        this.f33998y.setVisibility(0);
        this.f33998y.removeAllViews();
        int size = list.size();
        for (TransPayResultResp.TransferProcess next : list) {
            TransProcessItemView transProcessItemView = new TransProcessItemView(getContext());
            if (i == 0) {
                itemType = TransProcessItemView.ItemType.TYPE_HEAD;
            } else {
                itemType = i == size + -1 ? TransProcessItemView.ItemType.TYPE_FOOT : TransProcessItemView.ItemType.TYPE_NORMAL;
            }
            transProcessItemView.setData(itemType, next.title, next.tvColor, next.subTitle);
            this.f33998y.addView(transProcessItemView, i);
            i++;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25880a(final TransPayResultResp.PayResultData payResultData, final String str, boolean z) {
        if (payResultData != null && !CollectionUtil.isEmpty((Collection<?>) payResultData.statement)) {
            LinkedList<TransPayResultResp.ItemModel> linkedList = new LinkedList<>(payResultData.statement);
            if (z && !CollectionUtil.isEmpty((Collection<?>) payResultData.statementExtend)) {
                linkedList.addAll(payResultData.statementExtend);
            }
            this.f33984k.removeAllViews();
            this.f33984k.addView(LayoutInflater.from(this).inflate(R.layout.wallet_boleto_detail_title_view, this.f33984k, false));
            for (TransPayResultResp.ItemModel itemModel : linkedList) {
                View inflate = LayoutInflater.from(this).inflate(R.layout.trans_orderdetail_item_lay, this.f33984k, false);
                ((TextView) inflate.findViewById(R.id.pay_result_item_title)).setText(itemModel.title);
                ((TextView) inflate.findViewById(R.id.pay_result_item_content)).setText(itemModel.value);
                this.f33984k.addView(inflate);
            }
            if (!z && !CollectionUtil.isEmpty((Collection<?>) payResultData.statementExtend)) {
                PayTracker.trackEvent("ibt_didipay_full_receipt_sw");
                View inflate2 = LayoutInflater.from(this).inflate(R.layout.wallet_global_activity_topup_pay_result_extend_view, this.f33984k, false);
                inflate2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        PayTracker.trackEvent("ibt_didipay_full_receipt_ck");
                        TransOrderDetailActivity.this.m25880a(payResultData, str, true);
                    }
                });
                this.f33984k.addView(inflate2);
            }
            if (!TextUtils.isEmpty(str)) {
                this.f33984k.addView(LayoutInflater.from(this).inflate(R.layout.wallet_boleto_history_dash_line_view, this.f33984k, false));
                View inflate3 = LayoutInflater.from(this).inflate(R.layout.trans_bottom_tip_layout, this.f33984k, false);
                ((TextView) inflate3.findViewById(R.id.desc_tv)).setText(str);
                this.f33984k.addView(inflate3);
            }
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (this.mPresenter != null) {
            ((IOrderDetailPresenter) this.mPresenter).handleBackClick();
        }
    }

    public void showFlowerAnimation() {
        if (this.f33991r == null) {
            new LottieTask(new Callable<LottieResult<LottieComposition>>() {
                public LottieResult<LottieComposition> call() {
                    return TransOrderDetailActivity.this.m25885c();
                }
            }).addListener(new LottieListener<LottieComposition>() {
                public void onResult(LottieComposition lottieComposition) {
                    TransOrderDetailActivity.this.m25876a(lottieComposition);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public LottieResult<LottieComposition> m25885c() {
        try {
            return LottieCompositionFactory.fromJsonInputStreamSync(getAssets().open("installment_firework.json"), (String) null);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25876a(LottieComposition lottieComposition) {
        try {
            LottieAnimationView lottieAnimationView = new LottieAnimationView(getContext());
            this.f33991r = lottieAnimationView;
            lottieAnimationView.setLayoutParams(new FrameLayout.LayoutParams(-1, UIUtil.dip2px(this, 800.0f)));
            this.f33991r.setComposition(lottieComposition);
            this.f33991r.setRepeatCount(2);
            this.f33991r.playAnimation();
            this.f33991r.setSpeed(1.3f);
            this.f33992s.addView(this.f33991r);
            this.f33991r.addAnimatorListener(new Animator.AnimatorListener() {
                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    TransOrderDetailActivity.this.m25889d();
                }

                public void onAnimationCancel(Animator animator) {
                    TransOrderDetailActivity.this.m25889d();
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m25889d() {
        try {
            if (this.f33991r != null) {
                if (this.f33991r.getParent() == null) {
                    this.f33991r = null;
                    return;
                }
                this.f33991r.removeAllAnimatorListeners();
                ((ViewGroup) this.f33991r.getParent()).removeView(this.f33991r);
                this.f33991r = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
