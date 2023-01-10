package com.didi.consume.phone.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.consume.base.CsOmegaUtils;
import com.didi.consume.phone.model.CsAmountListResp;
import com.didi.consume.phone.model.CsCouponOrderBody;
import com.didi.consume.phone.model.CsCreateOrderBody;
import com.didi.consume.phone.model.CsCreateOrderResp;
import com.didi.consume.phone.model.CsVoucherResponse;
import com.didi.consume.phone.view.adapter.CsMobileAmountAdapter;
import com.didi.consume.phone.view.contract.CsPhoneAmountContract;
import com.didi.consume.phone.view.prsenter.CsPhoneAmountPresenter;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.api.Extend;
import com.didi.drouter.router.Request;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.facade.CashierLaunchListener;
import com.didi.global.fintech.cashier.user.facade.FastPayFacade;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.base.proxy.CommonProxyHolder;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.base.view.webview.fusion.model.UrlUtil;
import com.didi.payment.base.web.WalletDiminaUtil;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.commonsdk.fastpay.FastPayUT;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.creditcard.global.widget.NoDoubleClickListener;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpPayResultActivity;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpUniPayActivity;
import com.didi.sdk.util.TextUtil;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.unifiedPay.component.model.PayParam;
import com.didi.wallet.dimina.DiminaLaunchModel;
import com.google.gson.Gson;
import com.taxis99.R;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;

public class CsPhoneAmountFragment extends Fragment implements CsPhoneAmountContract.View {

    /* renamed from: a */
    private static final String f18163a = "param_country_code";

    /* renamed from: b */
    private static final String f18164b = "param_phone_num";

    /* renamed from: c */
    private static final String f18165c = "param_phone_operatorid";

    /* renamed from: d */
    private static final String f18166d = "param_order_type";

    /* renamed from: e */
    private static final String f18167e = "param_extra";

    /* renamed from: f */
    private static final int f18168f = 101;

    /* renamed from: A */
    private String f18169A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public boolean f18170B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public String f18171C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public String f18172D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public String f18173E;

    /* renamed from: F */
    private CsVoucherResponse.DataBean f18174F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public String f18175G;

    /* renamed from: H */
    private CsAmountListResp.DataBean f18176H;

    /* renamed from: I */
    private CsMobileAmountAdapter.OnAmountClickListener f18177I = new CsMobileAmountAdapter.OnAmountClickListener() {
        public void onClick(CsAmountListResp.Amount amount, String str) {
            CsPhoneAmountFragment csPhoneAmountFragment = CsPhoneAmountFragment.this;
            int unused = csPhoneAmountFragment.f18197z = csPhoneAmountFragment.getActivity().getIntent().getIntExtra("order_type", -1);
            HashMap hashMap = new HashMap();
            int i = 1;
            if (CsPhoneAmountFragment.this.f18197z != 1) {
                i = 0;
            }
            hashMap.put("order_type", Integer.valueOf(i));
            if ("1".equalsIgnoreCase(amount.disabled)) {
                if (TextUtil.isEmpty(str)) {
                    str = CsPhoneAmountFragment.this.getString(R.string.wallet_topup_amount_disable_reason);
                }
                WalletToastNew.showFailedMsg(CsPhoneAmountFragment.this.getActivity(), str);
                FinOmegaSDK.trackEvent("ibt_gp_didipay_drv_phone_topup_toast_sw", hashMap);
                return;
            }
            CsPhoneAmountFragment.this.f18185n.refreshSelectAmount(amount);
            String unused2 = CsPhoneAmountFragment.this.f18171C = amount.amount;
            String unused3 = CsPhoneAmountFragment.this.f18172D = amount.payAmount;
            if (CsPhoneAmountFragment.this.f18170B) {
                CsPhoneAmountFragment.this.f18194w.getVoucherDiscount(605, CsPhoneAmountFragment.this.f18172D);
            }
            CsPhoneAmountFragment.this.m15380a(amount.currencySymbol, amount.amount);
            CsOmegaUtils.trackPhoneBillAmountSelected(hashMap);
        }
    };

    /* renamed from: g */
    private String f18178g;

    /* renamed from: h */
    private String f18179h;

    /* renamed from: i */
    private String f18180i;

    /* renamed from: j */
    private String f18181j;

    /* renamed from: k */
    private boolean f18182k;

    /* renamed from: l */
    private LinearLayout f18183l;

    /* renamed from: m */
    private RecyclerView f18184m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public CsMobileAmountAdapter f18185n;

    /* renamed from: o */
    private TextView f18186o;

    /* renamed from: p */
    private TextView f18187p;

    /* renamed from: q */
    private TextView f18188q;

    /* renamed from: r */
    private TextView f18189r;

    /* renamed from: s */
    private ConstraintLayout f18190s;

    /* renamed from: t */
    private ConstraintLayout f18191t;

    /* renamed from: u */
    private LinearLayout f18192u;

    /* renamed from: v */
    private TextView f18193v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public CsPhoneAmountContract.Presenter f18194w;

    /* renamed from: x */
    private OnFragmentAmountInteractionListener f18195x;

    /* renamed from: y */
    private WalletLoadingContract f18196y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f18197z = -1;

    public interface OnFragmentAmountInteractionListener {
        void onFragmentAmountInteraction();
    }

    public static CsPhoneAmountFragment newInstance(String str, String str2, String str3, int i, String str4) {
        CsPhoneAmountFragment csPhoneAmountFragment = new CsPhoneAmountFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(f18163a, str);
        bundle.putSerializable(f18164b, str2);
        bundle.putSerializable(f18165c, str3);
        bundle.putInt(f18166d, i);
        bundle.putString(f18167e, str4);
        csPhoneAmountFragment.setArguments(bundle);
        return csPhoneAmountFragment;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentAmountInteractionListener) {
            this.f18195x = (OnFragmentAmountInteractionListener) context;
            if (context instanceof WalletLoadingContract) {
                this.f18196y = (WalletLoadingContract) context;
                return;
            }
            throw new RuntimeException(context.toString() + " must implement WalletLoadingContract");
        }
        throw new RuntimeException(context.toString() + " must implement OnFragmentZipCodeInteractionListener");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f18178g = (String) getArguments().getSerializable(f18163a);
            this.f18179h = (String) getArguments().getSerializable(f18164b);
            this.f18180i = (String) getArguments().getSerializable(f18165c);
            this.f18197z = getArguments().getInt(f18166d);
            this.f18169A = getArguments().getString(f18167e);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.cs_fragment_amount, viewGroup, false);
        m15373a(inflate);
        m15372a();
        this.f18194w = new CsPhoneAmountPresenter(getActivity(), this, this.f18196y);
        return inflate;
    }

    public void onStart() {
        super.onStart();
        if (this.f18185n == null) {
            this.f18194w.getAmountList(605, this.f18178g, this.f18179h, this.f18180i, this.f18169A);
        }
    }

    /* renamed from: a */
    private void m15373a(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_amount_content);
        this.f18183l = linearLayout;
        this.f18184m = (RecyclerView) linearLayout.findViewById(R.id.rv_amount_list);
        this.f18186o = (TextView) this.f18183l.findViewById(R.id.btn_amount_next);
        this.f18187p = (TextView) this.f18183l.findViewById(R.id.tv_sub_title);
        this.f18188q = (TextView) this.f18183l.findViewById(R.id.tv_voucher_price);
        this.f18189r = (TextView) this.f18183l.findViewById(R.id.tv_voucher_status);
        this.f18190s = (ConstraintLayout) this.f18183l.findViewById(R.id.voucher_price_container);
        this.f18191t = (ConstraintLayout) this.f18183l.findViewById(R.id.voucher_container);
        this.f18192u = (LinearLayout) this.f18183l.findViewById(R.id.ll_switch_pay_method_container);
        this.f18193v = (TextView) this.f18183l.findViewById(R.id.tv_pay_method_title);
        this.f18190s.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                if (!TextUtils.isEmpty(CsPhoneAmountFragment.this.f18175G)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("miniCouponId", CsPhoneAmountFragment.this.f18173E);
                    hashMap.put("amount", CsPhoneAmountFragment.this.f18172D);
                    hashMap.put(ErrorConst.ModuleName.SKU, "phonerecharge");
                    hashMap.put(DiminaLaunchModel.PRODUCT_LINE, String.valueOf(605));
                    ((Request) DRouter.build(UrlUtil.Companion.buildParamsUrl(CsPhoneAmountFragment.this.f18175G, hashMap)).putExtra(Extend.START_ACTIVITY_REQUEST_CODE, 101)).start(CsPhoneAmountFragment.this.getContext());
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
                    hashMap2.put("g_BizId", "phonebill");
                    hashMap2.put("uid", WalletCommonParamsUtil.getUID(CsPhoneAmountFragment.this.getContext()));
                    CsOmegaUtils.trackPhoneVoucherClick(hashMap2);
                }
            }
        });
    }

    /* renamed from: a */
    private void m15372a() {
        this.f18186o.setOnClickListener(new NoDoubleClickListener() {
            public void onNoDoubleClick(View view) {
                boolean d = CsPhoneAmountFragment.this.m15386b();
                CsPhoneAmountFragment.this.m15381a(d);
                if (d) {
                    FastPayUT.INSTANCE.trackFastPayBtnClk(605);
                }
            }
        });
        this.f18192u.setOnClickListener(new NoDoubleClickListener() {
            public void onNoDoubleClick(View view) {
                CsPhoneAmountFragment.this.m15381a(false);
                FastPayUT.INSTANCE.trackFastPay2CashierBtnClk(605);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15381a(boolean z) {
        CsMobileAmountAdapter csMobileAmountAdapter = this.f18185n;
        if (csMobileAmountAdapter != null && csMobileAmountAdapter.getCurrentSelectItem() != null) {
            this.f18186o.setEnabled(false);
            this.f18194w.trackOmega(0);
            CsCreateOrderBody csCreateOrderBody = new CsCreateOrderBody();
            csCreateOrderBody.phoneCountryCode = this.f18178g;
            csCreateOrderBody.phoneNumber = this.f18179h;
            csCreateOrderBody.operatorId = this.f18180i;
            csCreateOrderBody.orderType = this.f18197z;
            csCreateOrderBody.extraData = this.f18169A;
            csCreateOrderBody.fraudStatus = Boolean.valueOf(this.f18182k);
            csCreateOrderBody.useFastPay = Boolean.valueOf(z);
            CsCouponOrderBody csCouponOrderBody = new CsCouponOrderBody();
            if (this.f18170B) {
                csCouponOrderBody.couponId = this.f18173E;
                csCouponOrderBody.couponAmount = this.f18174F.couponAmount;
                csCouponOrderBody.originalAmount = this.f18174F.originalAmount;
                csCouponOrderBody.afterCouponAmount = this.f18174F.afterCouponAmount;
                csCouponOrderBody.utcOffset = this.f18174F.utcOffset;
                csCouponOrderBody.batchNo = this.f18174F.batchNo;
                csCouponOrderBody.hasCoupons = true;
            }
            this.f18194w.createPhoneRefillOrder(605, this.f18185n.getCurrentSelectItem().metadata, csCreateOrderBody, csCouponOrderBody);
        }
    }

    public void showAmountList(CsAmountListResp.DataBean dataBean) {
        if (dataBean != null) {
            this.f18176H = dataBean;
            this.f18182k = dataBean.fraudStatus.booleanValue();
            int i = 1;
            this.f18170B = dataBean.hasCoupons != null && dataBean.hasCoupons.booleanValue();
            if (dataBean.cashBackMessage != null) {
                dataBean.cashBackMessage.bindTextView(this.f18187p);
            }
            this.f18185n = new CsMobileAmountAdapter(getContext(), dataBean.items, dataBean.disabledReason, this.f18177I);
            this.f18184m.setLayoutManager(new GridLayoutManager(getContext(), 2));
            this.f18184m.setAdapter(this.f18185n);
            HashMap hashMap = new HashMap();
            if (this.f18197z != 1) {
                i = 0;
            }
            hashMap.put("order_type", Integer.valueOf(i));
            if (!(dataBean.items == null || dataBean.items.isEmpty() || dataBean.items.get(0) == null)) {
                this.f18185n.refreshSelectAmount(dataBean.items.get(0));
                this.f18171C = dataBean.items.get(0).amount;
                m15380a(dataBean.items.get(0).currencySymbol, dataBean.items.get(0).amount);
            }
            m15384b(dataBean);
            m15374a(dataBean);
            if (!(!this.f18170B || dataBean.items == null || dataBean.items.get(0) == null)) {
                String str = dataBean.items.get(0).payAmount;
                this.f18172D = str;
                this.f18194w.getVoucherDiscount(605, str);
            }
            CsOmegaUtils.trackPhoneBillAmountDisplay(hashMap);
            HashMap hashMap2 = new HashMap();
            if (this.f18170B) {
                hashMap2.put("coupon_sw", "1");
            } else {
                hashMap2.put("coupon_sw", "0");
            }
            hashMap2.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
            hashMap2.put("g_BizId", "phonebill");
            hashMap2.put("uid", WalletCommonParamsUtil.getUID(getContext()));
            CsOmegaUtils.trackPhoneVoucherShow(hashMap2);
        }
    }

    /* renamed from: a */
    private void m15374a(CsAmountListResp.DataBean dataBean) {
        if (m15386b()) {
            this.f18192u.setVisibility(0);
            this.f18193v.setText(dataBean.fastPayData.getPaymentMethodText());
            FastPayUT.INSTANCE.trackFastPayBtnShow(605);
            return;
        }
        this.f18192u.setVisibility(8);
    }

    /* renamed from: b */
    private void m15384b(CsAmountListResp.DataBean dataBean) {
        if (dataBean != null) {
            if (dataBean.hasCoupons != null && dataBean.hasCoupons.booleanValue()) {
                this.f18191t.setVisibility(0);
            } else {
                this.f18191t.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15380a(String str, String str2) {
        this.f18186o.setEnabled(true);
        if (m15386b()) {
            this.f18186o.setText(this.f18176H.fastPayData.getFastPayButtonText());
            return;
        }
        this.f18186o.setText(getString(R.string.Fintech_Payment_SKUs_Payment_Pay_GOTT, str, str2));
    }

    public void showVoucherAmount(CsVoucherResponse.DataBean dataBean) {
        this.f18174F = dataBean;
        if (dataBean.formattedCouponAmount == null || dataBean.formattedCouponAmount.isEmpty() || dataBean.afterCouponAmount < 100) {
            this.f18189r.setVisibility(0);
            this.f18188q.setVisibility(8);
            if (dataBean.isSelectNoVoucher) {
                this.f18189r.setText(R.string.Fintech_Payment_display_Do_not_irKT);
            } else {
                this.f18189r.setText(R.string.Fintech_Payment_display_No_coupon_AQlR);
            }
            this.f18173E = "";
        } else {
            this.f18189r.setVisibility(8);
            this.f18188q.setVisibility(0);
            TextView textView = this.f18188q;
            textView.setText("-R$" + dataBean.formattedCouponAmount);
            this.f18173E = dataBean.couponId;
        }
        if (dataBean.formattedAfterCouponAmount != null && dataBean.afterCouponAmount >= 100) {
            m15380a(dataBean.currencySymbol, dataBean.formattedAfterCouponAmount);
        }
        if (dataBean.couponLinkUrl != null && !dataBean.couponLinkUrl.isEmpty()) {
            this.f18175G = dataBean.couponLinkUrl;
        }
    }

    public void goToUniPay(FragmentActivity fragmentActivity, CsCreateOrderResp.DataBean dataBean) {
        this.f18186o.setEnabled(true);
        if (dataBean != null) {
            this.f18181j = dataBean.orderId;
            m15375a(dataBean);
        }
    }

    /* renamed from: a */
    private void m15375a(final CsCreateOrderResp.DataBean dataBean) {
        CashierParam cashierParam = new CashierParam();
        cashierParam.setOutTradeId(dataBean.outTradeId);
        C79235 r1 = !WalletApolloUtil.useNewCashier() ? new CashierLaunchListener() {
            public void onCashierLaunch(boolean z) {
                if (!z) {
                    CsPhoneAmountFragment.this.m15385b(dataBean);
                }
            }
        } : null;
        if (dataBean.cashierType == 1) {
            FastPayFacade.getInstance().pay((Fragment) this, 200, cashierParam);
        } else {
            CashierFacade.getInstance().launchForResult((Fragment) this, 200, cashierParam, (CashierLaunchListener) r1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m15385b(CsCreateOrderResp.DataBean dataBean) {
        Object terminalId;
        PayParam payParam = new PayParam();
        payParam.outTradeId = dataBean.outTradeId;
        payParam.omegaAttrs = new HashMap();
        payParam.omegaAttrs.put("product_line", 605);
        CommonProxyHolder.ICommonProxy proxy = CommonProxyHolder.getProxy();
        if (!(proxy == null || (terminalId = proxy.getTerminalId(getContext())) == null)) {
            payParam.omegaAttrs.put("wallet_terminal_id", terminalId);
        }
        WalletTopUpUniPayActivity.launchInFragment(this, payParam, 100);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int i3;
        if (i2 == -1) {
            if (i == 200) {
                i3 = intent.getIntExtra("code", 3);
                if (!(i3 != 1 || this.f18181j == null || getActivity() == null)) {
                    getActivity().finish();
                    m15379a(this.f18181j);
                }
            } else if (i != 101) {
                i3 = intent.getIntExtra("code", 3);
                if (!(i3 != 1 || this.f18181j == null || getActivity() == null)) {
                    getActivity().finish();
                    m15379a(this.f18181j);
                }
            } else if (intent != null) {
                CsVoucherResponse csVoucherResponse = null;
                try {
                    csVoucherResponse = (CsVoucherResponse) new Gson().fromJson(intent.getStringExtra(WalletDiminaUtil.DIMINA_NATIVE_H5_CALLBACK), CsVoucherResponse.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (csVoucherResponse != null && csVoucherResponse.data != null) {
                    if (csVoucherResponse.data.couponId == null) {
                        csVoucherResponse.data.isSelectNoVoucher = true;
                    }
                    showVoucherAmount(csVoucherResponse.data);
                    return;
                }
                return;
            } else {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("exit_code", Integer.valueOf(i3));
            PayTracker.trackEvent("ibt_gp_didipay_phonebill_cashier_sdk_finished_bt", hashMap);
        }
    }

    /* renamed from: a */
    private void m15379a(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("product_line", 605);
        bundle.putString("order_id", str);
        bundle.putInt("order_type", -1);
        bundle.putInt(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_FROM_PAGE, 258);
        WalletTopUpPayResultActivity.launch(getActivity(), 100, bundle);
        EventBus.getDefault().post(new WalletRefreshDataEvent());
    }

    public void onNetworkError() {
        this.f18186o.setEnabled(true);
    }

    public void showVoucherLoading() {
        this.f18189r.setVisibility(0);
        this.f18188q.setVisibility(8);
        this.f18189r.setText(R.string.Fintech_Payment_display_In_calculation_VGdP);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m15386b() {
        CsAmountListResp.DataBean dataBean = this.f18176H;
        return (dataBean == null || dataBean.fastPayData == null || !this.f18176H.fastPayData.isSupportFastPay()) ? false : true;
    }
}
