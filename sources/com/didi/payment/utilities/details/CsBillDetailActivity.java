package com.didi.payment.utilities.details;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.util.Consumer;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.api.Extend;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.RouterCallback;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.facade.CashierLaunchListener;
import com.didi.global.fintech.cashier.user.facade.FastPayFacade;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGOBaseDrawerModel;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.payment.base.proxy.CommonProxyHolder;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.MathUtil;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.base.view.webview.fusion.model.UrlUtil;
import com.didi.payment.base.web.WalletDiminaUtil;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.commonsdk.fastpay.FastPayData;
import com.didi.payment.commonsdk.fastpay.FastPayUT;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.commonsdk.utils.OmegaComParams;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.creditcard.global.omega.GlobalOmegaConstant;
import com.didi.payment.creditcard.global.widget.NoDoubleClickListener;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.utilities.CsInputFilter;
import com.didi.payment.utilities.base.CsBaseActivity;
import com.didi.payment.utilities.base.CsNetModel;
import com.didi.payment.utilities.base.CsOmegaUtils;
import com.didi.payment.utilities.base.CsRouter;
import com.didi.payment.utilities.resp.BoletoBillLimitRiskDetailVo;
import com.didi.payment.utilities.resp.CsAccountStatus;
import com.didi.payment.utilities.resp.CsCashbackResp;
import com.didi.payment.utilities.resp.CsCouponResp;
import com.didi.payment.utilities.resp.CsCreateOrderResp;
import com.didi.payment.utilities.resp.CsGetBillResp;
import com.didi.payment.utilities.resp.CsOrderCashbackModel;
import com.didi.payment.utilities.resp.CsOrderCouponModel;
import com.didi.payment.wallet.global.model.NightlyLimitSettingModel;
import com.didi.payment.wallet.global.model.resp.GetNightlyLimitResp;
import com.didi.payment.wallet.global.omega.GlobalOmegaConstant;
import com.didi.payment.wallet.global.risk.LimitRiskReminderHandler;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpUniPayActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.unifiedPay.component.model.PayParam;
import com.didi.wallet.dimina.DiminaLaunchModel;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.pay.paysecure.omega.OmegaUtilKt;
import com.google.gson.Gson;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;

public class CsBillDetailActivity extends CsBaseActivity {
    public static final String PARAM_FROM = "param_from";

    /* renamed from: V */
    private static final int f34091V = 101;

    /* renamed from: a */
    private static final int f34092a = 100;

    /* renamed from: b */
    private static final String f34093b = "param_key";

    /* renamed from: c */
    private static final String f34094c = "param_barcode";

    /* renamed from: A */
    private TextView f34095A;

    /* renamed from: B */
    private ConstraintLayout f34096B;

    /* renamed from: C */
    private ConstraintLayout f34097C;

    /* renamed from: D */
    private TextView f34098D;

    /* renamed from: E */
    private TextView f34099E;

    /* renamed from: F */
    private TextView f34100F;

    /* renamed from: G */
    private TextView f34101G;

    /* renamed from: H */
    private TextView f34102H;

    /* renamed from: I */
    private TextView f34103I;

    /* renamed from: J */
    private TextView f34104J;

    /* renamed from: K */
    private TextView f34105K;

    /* renamed from: L */
    private LinearLayout f34106L;

    /* renamed from: M */
    private LinearLayout f34107M;

    /* renamed from: N */
    private LinearLayout f34108N;

    /* renamed from: O */
    private Boolean f34109O = false;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public LEGODrawer f34110P;

    /* renamed from: Q */
    private LimitRiskReminderHandler f34111Q = new LimitRiskReminderHandler();
    /* access modifiers changed from: private */

    /* renamed from: R */
    public boolean f34112R;
    /* access modifiers changed from: private */

    /* renamed from: S */
    public String f34113S;

    /* renamed from: T */
    private NightlyLimitSettingModel f34114T;
    /* access modifiers changed from: private */

    /* renamed from: U */
    public GetNightlyLimitResp.NightlyLimitVo f34115U;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CsGetBillResp.Data f34116d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f34117e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public CsCreateOrderResp.DataBean f34118f;

    /* renamed from: g */
    private CsCouponResp.CsCouponData f34119g;

    /* renamed from: h */
    private String f34120h;

    /* renamed from: i */
    private String f34121i;

    /* renamed from: j */
    private boolean f34122j = true;

    /* renamed from: k */
    private boolean f34123k = false;

    /* renamed from: l */
    private boolean f34124l;

    /* renamed from: m */
    private int f34125m;

    /* renamed from: n */
    private int f34126n;

    /* renamed from: o */
    private View f34127o;

    /* renamed from: p */
    private TextView f34128p;

    /* renamed from: q */
    private TextView f34129q;

    /* renamed from: r */
    private TextView f34130r;

    /* renamed from: s */
    private TextView f34131s;

    /* renamed from: t */
    private TextView f34132t;

    /* renamed from: u */
    private TextView f34133u;

    /* renamed from: v */
    private View f34134v;

    /* renamed from: w */
    private View f34135w;

    /* renamed from: x */
    private LinearLayout f34136x;

    /* renamed from: y */
    private TextView f34137y;

    /* renamed from: z */
    private TextView f34138z;

    /* renamed from: a */
    private boolean m25983a(long j, long j2) {
        return j2 < 0 || j <= j2;
    }

    public static void startActivity(CsGetBillResp csGetBillResp, Context context, String str) {
        Intent intent = new Intent(context, CsBillDetailActivity.class);
        intent.putExtra(f34093b, csGetBillResp);
        intent.putExtra(PARAM_FROM, str);
        context.startActivity(intent);
    }

    public static void startActivity(String str, Context context) {
        Intent intent = new Intent(context, CsBillDetailActivity.class);
        intent.putExtra(f34094c, str);
        context.startActivity(intent);
    }

    public static void startActivity(String str, Context context, String str2) {
        Intent intent = new Intent(context, CsBillDetailActivity.class);
        intent.putExtra(f34094c, str);
        intent.putExtra(PARAM_FROM, str2);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.cs_activity_bill_details_layout);
        m25987b();
        m25991c();
        m25999e();
    }

    /* access modifiers changed from: protected */
    public void initStatusBar() {
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.white));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f34112R) {
            m26016m();
            this.f34112R = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25964a() {
        CsGetBillResp csGetBillResp = (CsGetBillResp) getIntent().getSerializableExtra(f34093b);
        HashMap hashMap = new HashMap();
        String stringExtra = getIntent().getStringExtra(PARAM_FROM);
        if (!TextUtils.isEmpty(stringExtra)) {
            this.f34113S = stringExtra;
        } else if (csGetBillResp == null || csGetBillResp.data == null) {
            this.f34113S = "auto_scan";
        } else {
            this.f34113S = GlobalOmegaConstant.AddCardPage.EventKey.MANUAL_INPUT;
        }
        hashMap.put("boleto_recognize_success_from", this.f34113S);
        CsGetBillResp.Data data = this.f34116d;
        hashMap.put("boleto_code", data == null ? "" : data.barCode);
        PayTracker.trackEvent("ibt_gp_didipay_lifebill_detailsuccess_sw", hashMap);
    }

    /* renamed from: b */
    private void m25987b() {
        initProgressDialog(this, R.id.pay_result_title_bar);
        this.f34127o = findViewById(R.id.pay_result_back_btn);
        this.f34128p = (TextView) findViewById(R.id.pay_result_card_desc_content);
        this.f34129q = (TextView) findViewById(R.id.pay_result_card_time_content);
        this.f34130r = (TextView) findViewById(R.id.pay_result_card_number_title);
        this.f34131s = (TextView) findViewById(R.id.pay_result_card_number_content);
        this.f34132t = (TextView) findViewById(R.id.pay_result_amount_price_tv);
        this.f34133u = (TextView) findViewById(R.id.pay_result_amount_symbol_tv);
        this.f34103I = (TextView) findViewById(R.id.cs_bill_details_btn);
        this.f34134v = findViewById(R.id.sv_bill_details_content);
        this.f34135w = findViewById(R.id.ll_bill_details_empty);
        this.f34136x = (LinearLayout) findViewById(R.id.cs_bill_bottom_tip_layout);
        this.f34137y = (TextView) findViewById(R.id.cs_bill_bottom_tip);
        this.f34138z = (TextView) findViewById(R.id.tv_night_limit);
        this.f34095A = (TextView) findViewById(R.id.tv_month_limit_info);
        this.f34096B = (ConstraintLayout) findViewById(R.id.boleto_coupon_container);
        this.f34097C = (ConstraintLayout) findViewById(R.id.container_coupon_more);
        this.f34098D = (TextView) findViewById(R.id.tv_coupon_amount);
        this.f34099E = (TextView) findViewById(R.id.tv_coupon_no_select);
        this.f34104J = (TextView) findViewById(R.id.boleto_bill_fastpay_btn);
        this.f34105K = (TextView) findViewById(R.id.tv_pay_method_title);
        this.f34106L = (LinearLayout) findViewById(R.id.ll_switch_pay_method_container);
        this.f34107M = (LinearLayout) findViewById(R.id.boleto_bill_fastpay_container);
        this.f34108N = (LinearLayout) findViewById(R.id.cs_bill_bottom_container);
        this.f34138z.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put(OmegaUtilKt.ENTRANCE_PAGE_ID, "boleto_page_id");
                hashMap.put("beyond_limit_amount", Double.valueOf(CsBillDetailActivity.this.f34116d.amountInDouble));
                PayTracker.getTracker().trackEvent("ibt_cash_out_limit_setting_boleto_page_ck", hashMap);
                if (CsBillDetailActivity.this.f34115U == null || !TextUtils.isEmpty(CsBillDetailActivity.this.f34115U.effectiveTime)) {
                    DRouter.build("99pay://one/nightly_limit_result").start(CsBillDetailActivity.this);
                } else {
                    ((Request) DRouter.build("99pay://one/nightly_limit_setting").putExtra("pageFrom", "boleto_page_id")).start(CsBillDetailActivity.this, new RouterCallback.ActivityCallback() {
                        public void onActivityResult(int i, Intent intent) {
                            if (i == -1) {
                                CsBillDetailActivity.this.m26012j();
                                String str = null;
                                if (intent != null) {
                                    str = intent.getStringExtra("effectiveTime");
                                }
                                if (!TextUtils.isEmpty(str)) {
                                    CsBillDetailActivity.this.f34115U.effectiveTime = str;
                                    CsBillDetailActivity.this.m26014k();
                                }
                            }
                        }
                    });
                }
            }
        });
        this.f34095A.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                BoletoBillLimitRiskDetailVo boletoBillLimitRiskDetailVo;
                if (CsBillDetailActivity.this.f34116d != null && (boletoBillLimitRiskDetailVo = CsBillDetailActivity.this.f34116d.limitRiskDetail) != null) {
                    DRouter.build(boletoBillLimitRiskDetailVo.link).start(CsBillDetailActivity.this);
                }
            }
        });
        this.f34127o.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CsBillDetailActivity.this.onBackPressed();
            }
        });
        this.f34135w.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CsBillDetailActivity.this.m26003f();
            }
        });
        this.f34097C.setOnClickListener(new NoDoubleClickListener() {
            public void onNoDoubleClick(View view) {
                CsBillDetailActivity.this.m25995d();
            }
        });
        TextView textView = (TextView) findViewById(R.id.bill_origin_price);
        this.f34100F = textView;
        textView.getPaint().setFlags(16);
        this.f34101G = (TextView) findViewById(R.id.pay_result_card_cashback_title);
        this.f34102H = (TextView) findViewById(R.id.pay_result_card_cashback_amount);
    }

    /* renamed from: c */
    private void m25991c() {
        this.f34103I.setOnClickListener(new NoDoubleClickListener() {
            public void onNoDoubleClick(View view) {
                CsBillDetailActivity.this.payOrder(false);
            }
        });
        this.f34106L.setOnClickListener(new NoDoubleClickListener() {
            public void onNoDoubleClick(View view) {
                CsBillDetailActivity.this.payOrder(false);
                FastPayUT.INSTANCE.trackFastPay2CashierBtnClk(606);
            }
        });
        this.f34104J.setOnClickListener(new NoDoubleClickListener() {
            public void onNoDoubleClick(View view) {
                CsBillDetailActivity.this.payOrder(true);
                FastPayUT.INSTANCE.trackFastPayBtnClk(606);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m25995d() {
        if (!TextUtils.isEmpty(this.f34120h)) {
            HashMap hashMap = new HashMap();
            hashMap.put("miniCouponId", this.f34121i);
            hashMap.put("amount", String.valueOf(this.f34116d.amountInDouble));
            hashMap.put(ErrorConst.ModuleName.SKU, "bill");
            hashMap.put(DiminaLaunchModel.PRODUCT_LINE, String.valueOf(606));
            ((Request) DRouter.build(UrlUtil.Companion.buildParamsUrl(this.f34120h, hashMap)).putExtra(Extend.START_ACTIVITY_REQUEST_CODE, 101)).start(this);
            CsOmegaUtils.trackBoletoCouponCk(WalletCommonParamsUtil.getUID(getContext()));
        }
    }

    /* renamed from: e */
    private void m25999e() {
        this.f34114T = new NightlyLimitSettingModel(this);
        CsGetBillResp csGetBillResp = (CsGetBillResp) getIntent().getSerializableExtra(f34093b);
        if (csGetBillResp == null || csGetBillResp.data == null) {
            m26003f();
            return;
        }
        m25990b(csGetBillResp);
        m25964a();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m26003f() {
        String stringExtra = getIntent().getStringExtra(f34094c);
        if (!TextUtils.isEmpty(stringExtra)) {
            String removeNonNumber = CsInputFilter.removeNonNumber(stringExtra);
            showLoadingDialog();
            CsNetModel.getIns(this).getBillInfo(606, removeNonNumber, new RpcService.Callback<CsGetBillResp>() {
                public void onSuccess(CsGetBillResp csGetBillResp) {
                    CsBillDetailActivity.this.m25976a(csGetBillResp);
                    CsBillDetailActivity.this.m25964a();
                }

                public void onFailure(IOException iOException) {
                    CsBillDetailActivity.this.m25976a((CsGetBillResp) null);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25976a(CsGetBillResp csGetBillResp) {
        dismissLoadingDialog();
        if (csGetBillResp == null || csGetBillResp.errno != 0 || csGetBillResp.data == null) {
            if (!(csGetBillResp == null || csGetBillResp.errno == 0 || TextUtils.isEmpty(csGetBillResp.errmsg))) {
                WalletToastNew.showFailedMsg(this, csGetBillResp.errmsg);
            }
            m26005g();
            return;
        }
        m25990b(csGetBillResp);
    }

    /* renamed from: g */
    private void m26005g() {
        this.f34135w.setVisibility(0);
        this.f34134v.setVisibility(8);
        this.f34108N.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m26007h() {
        this.f34135w.setVisibility(8);
        this.f34134v.setVisibility(0);
        this.f34108N.setVisibility(0);
        m26010i();
    }

    /* renamed from: b */
    private void m25990b(CsGetBillResp csGetBillResp) {
        this.f34116d = csGetBillResp.data;
        m25979a(String.valueOf(csGetBillResp.data.amountInDouble), "", false, "0");
        this.f34128p.setText(this.f34116d.barCode);
        this.f34129q.setText(this.f34116d.payee);
        if (!TextUtils.isEmpty(this.f34116d.dueDate)) {
            this.f34130r.setVisibility(0);
            this.f34131s.setVisibility(0);
            this.f34131s.setText(this.f34116d.dueDate);
        } else {
            this.f34130r.setVisibility(8);
            this.f34131s.setVisibility(8);
        }
        this.f34132t.setText(this.f34116d.amount);
        this.f34133u.setText(this.f34116d.currencySymbol);
        if (!TextUtils.isEmpty(this.f34116d.cashBack)) {
            this.f34136x.setVisibility(0);
            this.f34137y.setText(this.f34116d.cashBack);
        } else {
            this.f34136x.setVisibility(8);
        }
        m26012j();
        if (!TextUtils.isEmpty(this.f34116d.currencySymbol) && !TextUtils.isEmpty(this.f34116d.amount)) {
            this.f34103I.setText(String.format(getString(R.string.Fintech_Payment_SKUs_Payment_Pay_GOTT), new Object[]{this.f34116d.currencySymbol, this.f34116d.amount}));
        }
        FastPayData fastPayData = this.f34116d.fastPayData;
        if (fastPayData != null && !TextUtils.isEmpty(fastPayData.getPaymentMethodText())) {
            this.f34105K.setText(fastPayData.getPaymentMethodText());
            this.f34104J.setText(fastPayData.getFastPayButtonText());
        }
    }

    /* renamed from: i */
    private void m26010i() {
        if (m26017n()) {
            this.f34103I.setVisibility(8);
            this.f34107M.setVisibility(0);
            FastPayUT.INSTANCE.trackFastPayBtnShow(606);
            return;
        }
        this.f34103I.setVisibility(0);
        this.f34107M.setVisibility(8);
    }

    /* renamed from: a */
    private void m25979a(String str, String str2, final boolean z, String str3) {
        CsNetModel.getIns(this).getCouponData(606, str, str2, str3, new RpcService.Callback<CsCashbackResp>() {
            public void onSuccess(CsCashbackResp csCashbackResp) {
                if (csCashbackResp == null) {
                    WalletToastNew.showFailedMsg(CsBillDetailActivity.this.getContext(), CsBillDetailActivity.this.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                } else if (csCashbackResp.data == null || csCashbackResp.errno != 0) {
                    WalletToastNew.showFailedMsg(CsBillDetailActivity.this.getContext(), csCashbackResp.errmsg);
                } else {
                    CsBillDetailActivity.this.m25973a(csCashbackResp.data, z);
                }
            }

            public void onFailure(IOException iOException) {
                WalletToastNew.showFailedMsg(CsBillDetailActivity.this.getContext(), CsBillDetailActivity.this.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25973a(CsCashbackResp.DataBean dataBean, boolean z) {
        if (dataBean.couponData != null && !z) {
            CsCouponResp.CsCouponData csCouponData = new CsCouponResp.CsCouponData();
            csCouponData.couponId = dataBean.couponData.couponId;
            if (dataBean.couponData.couponAmountFormatted != null) {
                csCouponData.formattedCouponAmount = dataBean.couponData.couponAmountFormatted.value;
            }
            if (dataBean.totalAmountFormatted != null && !TextUtils.isEmpty(dataBean.totalAmountFormatted.value)) {
                csCouponData.formattedOriginalAmount = dataBean.totalAmountFormatted.value;
            }
            if (dataBean.couponData.afterCouponAmountFormatted != null) {
                csCouponData.formattedAfterCouponAmount = dataBean.couponData.afterCouponAmountFormatted.value;
                csCouponData.currencySymbol = dataBean.couponData.afterCouponAmountFormatted.symbol;
            }
            csCouponData.couponAmount = dataBean.couponData.couponAmount;
            csCouponData.originalAmount = dataBean.totalAmountFen;
            csCouponData.afterCouponAmount = dataBean.payAmountFen;
            csCouponData.hasCoupons = true;
            csCouponData.batchNo = dataBean.couponData.batchNo;
            csCouponData.utcOffset = dataBean.couponData.utcOffset;
            csCouponData.couponLinkUrl = dataBean.couponLinkUrl;
            m25974a(csCouponData);
        }
        m25972a(dataBean.cashbackData);
        String str = "";
        String str2 = (dataBean.cashbackData == null || dataBean.cashbackData.cashbackAmountFormatted == null || TextUtils.isEmpty(dataBean.cashbackData.cashbackAmountFormatted.value)) ? str : dataBean.cashbackData.cashbackAmountFormatted.value;
        if (this.f34122j) {
            this.f34122j = false;
            Intent intent = getIntent();
            if (!(intent == null || intent.getStringExtra(PARAM_FROM) == null)) {
                str = intent.getStringExtra(PARAM_FROM);
            }
            CsOmegaUtils.trackBoletoCouponSw(this.f34124l, WalletCommonParamsUtil.getUID(getContext()), this.f34123k, str2, str);
        }
    }

    /* renamed from: a */
    private void m25972a(CsCashbackResp.CashBackData cashBackData) {
        if (cashBackData == null || TextUtils.isEmpty(cashBackData.cashbackDisplay)) {
            this.f34125m = 0;
            this.f34101G.setVisibility(8);
            this.f34102H.setVisibility(8);
            return;
        }
        this.f34125m = cashBackData.cashbackAmount;
        this.f34126n = cashBackData.activityId;
        this.f34123k = true;
        this.f34101G.setVisibility(0);
        this.f34102H.setVisibility(0);
        this.f34102H.setText(cashBackData.cashbackDisplay);
    }

    /* renamed from: a */
    private void m25974a(CsCouponResp.CsCouponData csCouponData) {
        this.f34119g = csCouponData;
        if (csCouponData.hasCoupons) {
            this.f34096B.setVisibility(0);
            this.f34124l = csCouponData.hasCoupons;
        }
        if (!TextUtils.isEmpty(this.f34119g.couponLinkUrl)) {
            this.f34120h = this.f34119g.couponLinkUrl;
        }
        if (csCouponData.couponId == null || csCouponData.couponId.isEmpty()) {
            this.f34098D.setVisibility(8);
            this.f34099E.setVisibility(0);
            this.f34100F.setVisibility(8);
            if (csCouponData.isSelectNoVoucher) {
                this.f34099E.setText(getString(R.string.Fintech_Payment_display_Do_not_irKT));
                this.f34132t.setText(this.f34116d.amount);
                CsGetBillResp.Data data = this.f34116d;
                if (data == null || data.limitRiskDetail == null || TextUtils.isEmpty(this.f34116d.limitRiskDetail.payButtonText)) {
                    this.f34103I.setText(String.format(getString(R.string.Fintech_Payment_SKUs_Payment_Pay_GOTT), new Object[]{this.f34116d.currencySymbol, this.f34116d.amount}));
                }
            } else {
                this.f34099E.setText(getString(R.string.Fintech_Payment_display_No_coupon_AQlR));
            }
            this.f34121i = "";
            return;
        }
        this.f34098D.setVisibility(0);
        this.f34099E.setVisibility(8);
        this.f34100F.setVisibility(0);
        if (!TextUtils.isEmpty(csCouponData.formattedCouponAmount)) {
            this.f34098D.setText(String.format(getString(R.string.Fintech_Payment_Coupon_Amount), new Object[]{csCouponData.currencySymbol, csCouponData.formattedCouponAmount}));
        }
        this.f34121i = csCouponData.couponId;
        if (!TextUtils.isEmpty(csCouponData.formattedOriginalAmount)) {
            this.f34100F.setText(String.format(getString(R.string.Fintech_Payment_Amount), new Object[]{csCouponData.currencySymbol, csCouponData.formattedOriginalAmount}));
        }
        if (!TextUtils.isEmpty(csCouponData.formattedAfterCouponAmount)) {
            this.f34132t.setText(csCouponData.formattedAfterCouponAmount);
            CsGetBillResp.Data data2 = this.f34116d;
            if (data2 == null || data2.limitRiskDetail == null || TextUtils.isEmpty(this.f34116d.limitRiskDetail.payButtonText)) {
                this.f34103I.setText(String.format(getString(R.string.Fintech_Payment_SKUs_Payment_Pay_GOTT), new Object[]{csCouponData.currencySymbol, csCouponData.formattedAfterCouponAmount}));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m26012j() {
        showLoadingDialog();
        this.f34114T.getNightlyLimit(606, new RpcService.Callback<GetNightlyLimitResp>() {
            public void onSuccess(GetNightlyLimitResp getNightlyLimitResp) {
                CsBillDetailActivity.this.dismissLoadingDialog();
                if (getNightlyLimitResp.errno == 0 && getNightlyLimitResp.data != null) {
                    GetNightlyLimitResp.NightlyLimitVo unused = CsBillDetailActivity.this.f34115U = getNightlyLimitResp.data;
                    CsBillDetailActivity.this.m26014k();
                }
                CsBillDetailActivity.this.m26007h();
            }

            public void onFailure(IOException iOException) {
                CsBillDetailActivity.this.dismissLoadingDialog();
                GetNightlyLimitResp.NightlyLimitVo unused = CsBillDetailActivity.this.f34115U = null;
                CsBillDetailActivity.this.m26014k();
                CsBillDetailActivity.this.m26007h();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m26014k() {
        BoletoBillLimitRiskDetailVo boletoBillLimitRiskDetailVo;
        boolean z;
        long j;
        String str;
        long j2;
        CsGetBillResp.Data data = this.f34116d;
        if (data != null) {
            j = (long) MathUtil.dollarToCent(data.amountInDouble);
            BoletoBillLimitRiskDetailVo boletoBillLimitRiskDetailVo2 = this.f34116d.limitRiskDetail;
            z = this.f34116d.isNightLimitHit;
            boletoBillLimitRiskDetailVo = boletoBillLimitRiskDetailVo2;
        } else {
            j = 0;
            z = false;
            boletoBillLimitRiskDetailVo = null;
        }
        long j3 = j;
        GetNightlyLimitResp.NightlyLimitVo nightlyLimitVo = this.f34115U;
        if (nightlyLimitVo == null || !z) {
            str = null;
            j2 = -1;
        } else {
            j2 = nightlyLimitVo.remainingLimit;
            str = this.f34115U.effectiveTime;
        }
        m25965a(j3, j2, str, boletoBillLimitRiskDetailVo);
    }

    /* renamed from: a */
    private void m25965a(long j, long j2, String str, BoletoBillLimitRiskDetailVo boletoBillLimitRiskDetailVo) {
        String str2;
        long j3;
        String str3 = null;
        if (boletoBillLimitRiskDetailVo != null) {
            str3 = boletoBillLimitRiskDetailVo.payButtonText;
            j3 = boletoBillLimitRiskDetailVo.riskLimitQuota;
            str2 = boletoBillLimitRiskDetailVo.description;
        } else {
            j3 = -1;
            str2 = null;
        }
        this.f34109O = false;
        if (m25983a(j, j3) || TextUtils.isEmpty(str3)) {
            this.f34095A.setVisibility(8);
        } else {
            this.f34103I.setText(str3);
            this.f34095A.setText(str2);
            this.f34095A.setVisibility(TextUtils.isEmpty(str2) ? 8 : 0);
            this.f34109O = true;
        }
        if (m25983a(j, j2)) {
            this.f34103I.setEnabled(true);
            this.f34138z.setVisibility(8);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.f34138z.setText(R.string.GRider_limit_Beyond_the_GuvV);
        } else {
            this.f34138z.setText(R.string.GRider_2_When_the_QyBM);
        }
        this.f34138z.setVisibility(0);
        CsCouponResp.CsCouponData csCouponData = this.f34119g;
        if (csCouponData == null || TextUtils.isEmpty(csCouponData.formattedAfterCouponAmount)) {
            this.f34103I.setText(String.format(getString(R.string.Fintech_Payment_SKUs_Payment_Pay_GOTT), new Object[]{this.f34116d.currencySymbol, this.f34116d.amount}));
        } else {
            this.f34103I.setText(String.format(getString(R.string.Fintech_Payment_SKUs_Payment_Pay_GOTT), new Object[]{this.f34119g.currencySymbol, this.f34119g.formattedAfterCouponAmount}));
        }
        this.f34095A.setVisibility(8);
        HashMap hashMap = new HashMap();
        hashMap.put(OmegaUtilKt.ENTRANCE_PAGE_ID, "boleto_page_id");
        hashMap.put("beyond_limit_amount", Double.valueOf(this.f34116d.amountInDouble));
        PayTracker.getTracker().trackEvent("ibt_cash_out_limit_setting_boleto_page_bt", hashMap);
        this.f34103I.setEnabled(false);
        this.f34109O = true;
    }

    public void payOrder(boolean z) {
        m25982a(z);
        String str = this.f34113S;
        CsGetBillResp.Data data = this.f34116d;
        CsOmegaUtils.trackConfirmBtnClicked("detailsuccess", str, data == null ? "" : data.barCode);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25975a(final CsCreateOrderResp.DataBean dataBean) {
        if (dataBean != null) {
            this.f34111Q.show(dataBean.limitRiskReminder, this, GlobalOmegaConstant.SkuRiskLimit.PUB_PAGE_BOLETO_BILL_DETAIL, 606, new Consumer<Integer>() {
                public void accept(Integer num) {
                    if (num.intValue() != 1) {
                        CsCreateOrderResp.DataBean unused = CsBillDetailActivity.this.f34118f = null;
                    } else if (!TextUtils.isEmpty(dataBean.outTradeId)) {
                        CsBillDetailActivity.this.m25989b(dataBean);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m25989b(CsCreateOrderResp.DataBean dataBean) {
        m25994c(dataBean);
    }

    /* renamed from: c */
    private void m25994c(final CsCreateOrderResp.DataBean dataBean) {
        CashierParam cashierParam = new CashierParam();
        cashierParam.setOutTradeId(dataBean.outTradeId);
        if (dataBean.cashierType == 1) {
            FastPayFacade.getInstance().pay((Activity) this, 200, cashierParam);
        } else {
            CashierFacade.getInstance().launchForResult((Activity) this, 200, cashierParam, (CashierLaunchListener) !WalletApolloUtil.useNewCashier() ? new CashierLaunchListener() {
                public void onCashierLaunch(boolean z) {
                    if (!z) {
                        CsBillDetailActivity.this.m25997d(dataBean);
                    }
                }
            } : null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m25997d(CsCreateOrderResp.DataBean dataBean) {
        Object terminalId;
        PayParam payParam = new PayParam();
        payParam.outTradeId = dataBean.outTradeId;
        payParam.omegaAttrs = new HashMap();
        payParam.omegaAttrs.put("product_line", 606);
        CommonProxyHolder.ICommonProxy proxy = CommonProxyHolder.getProxy();
        if (!(proxy == null || (terminalId = proxy.getTerminalId(getContext())) == null)) {
            payParam.omegaAttrs.put("wallet_terminal_id", terminalId);
        }
        WalletTopUpUniPayActivity.launch(this, payParam, 100);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25982a(final boolean z) {
        showLoadingDialog();
        CsOrderCouponModel csOrderCouponModel = new CsOrderCouponModel();
        if (this.f34124l) {
            csOrderCouponModel.couponId = this.f34121i;
            csOrderCouponModel.couponAmount = this.f34119g.couponAmount;
            csOrderCouponModel.originalAmount = this.f34119g.originalAmount;
            csOrderCouponModel.afterCouponAmount = this.f34119g.afterCouponAmount;
            csOrderCouponModel.utcOffset = this.f34119g.utcOffset;
            csOrderCouponModel.batchNo = this.f34119g.batchNo;
            csOrderCouponModel.hasCoupons = "true";
        }
        CsOrderCashbackModel csOrderCashbackModel = new CsOrderCashbackModel();
        if (this.f34125m > 0) {
            csOrderCashbackModel.activityId = String.valueOf(this.f34126n);
            csOrderCashbackModel.cashbackAmount = this.f34125m;
        }
        CsNetModel.getIns(this).createUtilitiesOrder(606, this.f34116d.metadata, this.f34116d.bizContent, Boolean.valueOf(z), csOrderCouponModel, csOrderCashbackModel, new RpcService.Callback<CsCreateOrderResp>() {
            public void onSuccess(CsCreateOrderResp csCreateOrderResp) {
                if (csCreateOrderResp == null) {
                    CsBillDetailActivity.this.dismissLoadingDialog();
                    return;
                }
                KycOmega.Companion.fin_tech_wallet_http_req_lite_en(csCreateOrderResp.errno, csCreateOrderResp.errmsg, "/v0/didipay/order");
                if (csCreateOrderResp.errno == 0 && csCreateOrderResp.data != null) {
                    CsBillDetailActivity.this.dismissLoadingDialog();
                    String unused = CsBillDetailActivity.this.f34117e = csCreateOrderResp.data.orderId;
                    CsCreateOrderResp.DataBean unused2 = CsBillDetailActivity.this.f34118f = csCreateOrderResp.data;
                    if (!CsBillDetailActivity.this.m26002e(csCreateOrderResp.data)) {
                        CsBillDetailActivity.this.m25989b(csCreateOrderResp.data);
                    }
                    CsCreateOrderResp.ToastInfo toastInfo = csCreateOrderResp.data.toastInfo;
                    if (toastInfo != null && toastInfo.isErrorToast()) {
                        WalletToastNew.showFailedMsg(CsBillDetailActivity.this, toastInfo.message);
                    }
                } else if (csCreateOrderResp.errno == 30108 && csCreateOrderResp.data != null) {
                    CsBillDetailActivity.this.m25975a(csCreateOrderResp.data);
                    CsBillDetailActivity.this.dismissLoadingDialog();
                } else if (csCreateOrderResp.errno == 60104) {
                    if (csCreateOrderResp.data != null) {
                        CsBillDetailActivity.this.m25981a(csCreateOrderResp.data.orderId, z, csCreateOrderResp.errmsg);
                    }
                    CsBillDetailActivity.this.dismissLoadingDialog();
                } else if (!TextUtils.isEmpty(csCreateOrderResp.errmsg)) {
                    WalletToastNew.showFailedMsg(CsBillDetailActivity.this.getContext(), csCreateOrderResp.errmsg);
                    CsBillDetailActivity.this.dismissLoadingDialog();
                } else {
                    WalletToastNew.showFailedMsg(CsBillDetailActivity.this.getContext(), CsBillDetailActivity.this.getString(R.string.pay_base_network_error));
                    CsBillDetailActivity.this.dismissLoadingDialog();
                }
            }

            public void onFailure(IOException iOException) {
                CsBillDetailActivity.this.dismissLoadingDialog();
                WalletToastNew.showFailedMsg(CsBillDetailActivity.this.getContext(), CsBillDetailActivity.this.getString(R.string.pay_base_network_error));
                KycOmega.Companion.fin_tech_wallet_http_req_lite_en(-11, "", "/v0/didipay/order");
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        dismissLoadingDialog();
        if (i2 != -1) {
            return;
        }
        if (i == 100) {
            if (intent.getIntExtra("code", 3) == 1) {
                m26015l();
            }
        } else if (i == 200) {
            if (intent.getIntExtra("code", 3) == 1) {
                m26015l();
            }
        } else if (i == 101 && intent != null && !TextUtils.isEmpty(intent.getStringExtra(WalletDiminaUtil.DIMINA_NATIVE_H5_CALLBACK))) {
            m25977a(intent.getStringExtra(WalletDiminaUtil.DIMINA_NATIVE_H5_CALLBACK));
        }
    }

    /* renamed from: a */
    private void m25977a(String str) {
        CsCouponResp csCouponResp;
        try {
            csCouponResp = (CsCouponResp) new Gson().fromJson(str, CsCouponResp.class);
        } catch (Exception e) {
            e.printStackTrace();
            csCouponResp = null;
        }
        if (csCouponResp != null && csCouponResp.data != null) {
            if (csCouponResp.data.couponId == null) {
                csCouponResp.data.isSelectNoVoucher = true;
            }
            m25974a(csCouponResp.data);
            String valueOf = String.valueOf(this.f34116d.amountInDouble);
            String str2 = this.f34121i;
            m25979a(valueOf, str2, true, TextUtils.isEmpty(str2) ? "1" : "0");
        }
    }

    /* renamed from: l */
    private void m26015l() {
        finish();
        CsRouter.startPayResultActivity(this, 606, this.f34117e, -1);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m26002e(final CsCreateOrderResp.DataBean dataBean) {
        boolean z = false;
        if (!(dataBean == null || dataBean.extraInfo == null || dataBean.extraInfo.prePayDialogInfo == null || dataBean.extraInfo.accountInfo == null)) {
            CsCreateOrderResp.PrePayDialogInfo prePayDialogInfo = dataBean.extraInfo.prePayDialogInfo;
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
                if (this.f34110P != null && this.f34110P.isShowing()) {
                    this.f34110P.dismiss();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (2 == dataBean.extraInfo.accountStatus || 3 == dataBean.extraInfo.accountStatus) {
                str = getString(R.string.GRider_reminder_In_the_cnSS);
                str2 = getString(R.string.GRider_reminder_I_see_YkJW);
                m25978a(GlobalOmegaConstant.BoletoHistoryPage.EventId.BOLETO_NO_KYC_PENDING_SW, dataBean);
            } else if (dataBean.extraInfo.prePayDialogInfo.canUseOtherPay) {
                m25978a("ibt_gp_didipay_not_gen_boleto_sw", dataBean);
            } else {
                m25978a(GlobalOmegaConstant.BoletoHistoryPage.EventId.BOLETO_NO_KYC_GEN_BOLETO_SW, dataBean);
            }
            z = true;
            LEGOBaseDrawerModel isShowCloseImg = new LEGODrawerModel1(str, new LEGOBtnTextAndCallback(str2, new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    if (CsBillDetailActivity.this.f34110P != null && CsBillDetailActivity.this.f34110P.isShowing()) {
                        CsBillDetailActivity.this.f34110P.dismiss();
                    }
                    if (2 == dataBean.extraInfo.accountStatus || 3 == dataBean.extraInfo.accountStatus) {
                        CsBillDetailActivity.this.finish();
                        return;
                    }
                    if (dataBean.extraInfo.prePayDialogInfo.canUseOtherPay) {
                        CsBillDetailActivity.this.m25978a("ibt_gp_didipay_not_gen_boleto_pk_didi_ck", dataBean);
                    } else {
                        CsBillDetailActivity.this.m25978a(GlobalOmegaConstant.BoletoHistoryPage.EventId.BOLETO_NO_KYC_SIGNUP_CK, dataBean);
                    }
                    OmegaComParams.Companion.setKYC_RESOURCE_ID(DiFaceLogger.EVENT_ID_BI_DETECT_DONE);
                    CsRouter.gotoAccountStatusPage(CsBillDetailActivity.this, dataBean);
                    boolean unused = CsBillDetailActivity.this.f34112R = true;
                }
            })).setIsShowCloseImg(true);
            if (dataBean.extraInfo.accountStatus == 0) {
                isShowCloseImg.addMinorBtn(new LEGOBtnTextAndCallback(str3, new LEGOOnAntiShakeClickListener() {
                    public void onAntiShakeClick(View view) {
                        if (CsBillDetailActivity.this.f34110P != null && CsBillDetailActivity.this.f34110P.isShowing()) {
                            CsBillDetailActivity.this.f34110P.dismiss();
                        }
                        if (dataBean.extraInfo.prePayDialogInfo.canUseOtherPay) {
                            CsBillDetailActivity.this.m25978a("ibt_gp_didipay_not_gen_boleto_pk_other_ck", dataBean);
                            CsBillDetailActivity.this.m25975a(dataBean);
                            return;
                        }
                        CsBillDetailActivity.this.m25978a(GlobalOmegaConstant.BoletoHistoryPage.EventId.BOLETO_NO_KYC_GOT_IT_CK, dataBean);
                    }
                }));
            }
            if (!TextUtils.isEmpty(dataBean.extraInfo.prePayDialogInfo.subTitle)) {
                isShowCloseImg.setSubTitle(dataBean.extraInfo.prePayDialogInfo.subTitle);
            }
            isShowCloseImg.setShowCloseImgListener(new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    if (CsBillDetailActivity.this.f34110P != null && CsBillDetailActivity.this.f34110P.isShowing()) {
                        CsBillDetailActivity.this.f34110P.dismiss();
                    }
                    CsBillDetailActivity.this.m25978a(GlobalOmegaConstant.BoletoHistoryPage.EventId.BOLETO_NO_KYC_GOT_IT_CK, dataBean);
                }
            });
            this.f34110P = LEGOUICreator.showDrawerTemplate(this, isShowCloseImg);
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25978a(String str, CsCreateOrderResp.DataBean dataBean) {
        if (dataBean != null && dataBean.extraInfo != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(TransGlobalOmegaKey.KEY_ACCOUNT_STATUS, Integer.valueOf(dataBean.extraInfo.accountStatus));
            CsGetBillResp.Data data = this.f34116d;
            hashMap.put("boleto_code", data == null ? "" : data.barCode);
            hashMap.put("boleto_recognize_success_from", this.f34113S);
            hashMap.put("biz_order_id", dataBean.orderId);
            hashMap.put("no_kyc_popup_from", "payment_details");
            PayTracker.trackEvent(str, hashMap);
        }
    }

    /* renamed from: m */
    private void m26016m() {
        showLoadingDialog();
        CsNetModel.getIns(this).checkAccountStatus(new RpcService.Callback<CsAccountStatus>() {
            public void onSuccess(CsAccountStatus csAccountStatus) {
                CsBillDetailActivity.this.dismissLoadingDialog();
                if (csAccountStatus != null && csAccountStatus.data != null && CsBillDetailActivity.this.f34118f != null) {
                    if (1 == csAccountStatus.data.status) {
                        CsBillDetailActivity csBillDetailActivity = CsBillDetailActivity.this;
                        csBillDetailActivity.m25975a(csBillDetailActivity.f34118f);
                    } else if (2 == csAccountStatus.data.status || 3 == csAccountStatus.data.status) {
                        if (CsBillDetailActivity.this.f34118f.extraInfo != null) {
                            CsBillDetailActivity.this.f34118f.extraInfo.accountStatus = 2;
                            CsBillDetailActivity csBillDetailActivity2 = CsBillDetailActivity.this;
                            boolean unused = csBillDetailActivity2.m26002e(csBillDetailActivity2.f34118f);
                        }
                    } else if (csAccountStatus.data.status == 0) {
                        CsBillDetailActivity csBillDetailActivity3 = CsBillDetailActivity.this;
                        boolean unused2 = csBillDetailActivity3.m26002e(csBillDetailActivity3.f34118f);
                    }
                }
            }

            public void onFailure(IOException iOException) {
                CsBillDetailActivity.this.dismissLoadingDialog();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25981a(final String str, final boolean z, String str2) {
        if (this.f34116d != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                if (this.f34110P != null && this.f34110P.isShowing()) {
                    this.f34110P.dismiss();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            LEGOBaseDrawerModel isShowCloseImg = new LEGODrawerModel1(str2, new LEGOBtnTextAndCallback(getString(R.string.GRider_reminder_Payments_now_kcFN), new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    if (CsBillDetailActivity.this.f34110P != null && CsBillDetailActivity.this.f34110P.isShowing()) {
                        CsBillDetailActivity.this.f34110P.dismiss();
                    }
                    CsBillDetailActivity.this.m25980a(str, z);
                    CsOmegaUtils.trackBoletoPayExpiredCk(CsBillDetailActivity.this.f34116d.barCode, CsBillDetailActivity.this.f34113S, str);
                }
            })).setIsShowCloseImg(true);
            isShowCloseImg.setShowCloseImgListener(new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    CsOmegaUtils.trackBoletoPayExpiredExitCk(CsBillDetailActivity.this.f34116d.barCode, CsBillDetailActivity.this.f34113S, str);
                }
            });
            this.f34110P = LEGOUICreator.showDrawerTemplate(this, isShowCloseImg);
            CsOmegaUtils.trackBoletoPayExpiredSw(this.f34116d.barCode, this.f34113S, str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25980a(String str, final boolean z) {
        showLoadingDialog();
        CsNetModel.getIns(this).closeOrder(606, str, new RpcService.Callback<WBaseResp>() {
            public void onSuccess(WBaseResp wBaseResp) {
                CsBillDetailActivity.this.dismissLoadingDialog();
                CsBillDetailActivity.this.m25982a(z);
            }

            public void onFailure(IOException iOException) {
                CsBillDetailActivity.this.dismissLoadingDialog();
                WalletToastNew.showFailedMsg(CsBillDetailActivity.this.getApplicationContext(), ResourcesHelper.getString(CsBillDetailActivity.this.getApplicationContext(), R.string.pay_base_network_error));
            }
        });
    }

    /* renamed from: n */
    private boolean m26017n() {
        CsGetBillResp.Data data = this.f34116d;
        return data != null && data.fastPayData != null && this.f34116d.fastPayData.isSupportFastPay() && !this.f34109O.booleanValue();
    }
}
