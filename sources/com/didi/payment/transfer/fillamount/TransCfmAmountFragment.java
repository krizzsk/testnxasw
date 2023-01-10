package com.didi.payment.transfer.fillamount;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.NumberKeyListener;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.didi.dcrypto.DCryptoMainFragment;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.RouterCallback;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.facade.CashierLaunchListener;
import com.didi.global.fintech.cashier.user.facade.FastPayFacade;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.utils.MathUtil;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.base.utils.ServiceLoaderUtil;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.base.widget.CommonEditText;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.commonsdk.fastpay.FastPayData;
import com.didi.payment.commonsdk.fastpay.FastPayUT;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.creditcard.global.utils.InputTools;
import com.didi.payment.transfer.DebugUtil;
import com.didi.payment.transfer.cashier.TransferCashierActivity;
import com.didi.payment.transfer.common.TransBaseFragment;
import com.didi.payment.transfer.constants.TransferContants;
import com.didi.payment.transfer.fillamount.IConfirmTransferInfo;
import com.didi.payment.transfer.fillamount.TransConfirmBankInfoDialog;
import com.didi.payment.transfer.fillamount.TransCreateOrderResp;
import com.didi.payment.transfer.fillamount.TransServiceFeeResp;
import com.didi.payment.transfer.fillamount.presenter.ICfmAmountPresenter;
import com.didi.payment.transfer.fillamount.presenter.TransCfmAmountPresenter;
import com.didi.payment.transfer.fillamount.presenter.TransCfmAmountPresenter4Bank;
import com.didi.payment.transfer.orderdetail.TransOrderDetailActivity;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.transfer.utils.TransOmegaUtil;
import com.didi.payment.transfer.utils.TransStore;
import com.didi.payment.wallet.global.model.resp.GetNightlyLimitResp;
import com.didi.payment.wallet.global.model.resp.LimitRiskDetailVo;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.password.PasswordDataVo;
import com.didi.payment.wallet.password.PasswordScene;
import com.didi.payment.wallet_ui.dialog.WalletDialog;
import com.didi.payment.wallet_ui.dialog.WalletDrawerContent;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.unifiedPay.component.model.PayParam;
import com.didi.unifiedPay.util.LogUtil;
import com.didichuxing.dfbasesdk.utils.UIHandler;
import com.didiglobal.pay.paysecure.OpenCertificationListener;
import com.didiglobal.pay.paysecure.PayPwdResultListener;
import com.didiglobal.pay.paysecure.PaySecure;
import com.didiglobal.pay.paysecure.SetPwdResultListener;
import com.didiglobal.pay.paysecure.omega.OmegaUtilKt;
import com.taxis99.R;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Locale;

public class TransCfmAmountFragment extends TransBaseFragment<ICfmAmountPresenter> implements ICfmAmountPageView {

    /* renamed from: E */
    private static final int f33864E = 1;

    /* renamed from: F */
    private static final int f33865F = 2;

    /* renamed from: A */
    private String f33866A;

    /* renamed from: B */
    private LinearLayout f33867B;

    /* renamed from: C */
    private TextView f33868C;

    /* renamed from: D */
    private TextView f33869D;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public TransServiceFeeResp f33870G;

    /* renamed from: a */
    private ImageView f33871a;

    /* renamed from: b */
    private TextView f33872b;

    /* renamed from: c */
    private TextView f33873c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CommonEditText f33874d;

    /* renamed from: e */
    private TextView f33875e;

    /* renamed from: f */
    private View f33876f;

    /* renamed from: g */
    private TextView f33877g;

    /* renamed from: h */
    private ImageView f33878h;

    /* renamed from: i */
    private TextView f33879i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f33880j = -1;

    /* renamed from: k */
    private IConfirmTransferInfo f33881k;

    /* renamed from: l */
    private TextView f33882l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public String f33883m = ",";
    /* access modifiers changed from: private */

    /* renamed from: n */
    public String f33884n = ",";
    /* access modifiers changed from: private */

    /* renamed from: o */
    public String f33885o = ".";

    /* renamed from: p */
    private final int f33886p = 2;

    /* renamed from: q */
    private View f33887q;

    /* renamed from: r */
    private TextView f33888r;

    /* renamed from: s */
    private View f33889s;

    /* renamed from: t */
    private TextView f33890t;

    /* renamed from: u */
    private TextView f33891u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f33892v;

    /* renamed from: w */
    private ImageView f33893w;

    /* renamed from: x */
    private long f33894x = -1;

    /* renamed from: y */
    private String f33895y = null;

    /* renamed from: z */
    private LimitRiskDetailVo f33896z;

    /* renamed from: a */
    private boolean m25737a(long j, long j2) {
        return j2 < 0 || j <= j2;
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.trans_fragment_fillamount_lay;
    }

    public static TransCfmAmountFragment getInstance(Bundle bundle) {
        TransCfmAmountFragment transCfmAmountFragment = new TransCfmAmountFragment();
        transCfmAmountFragment.setArguments(bundle);
        return transCfmAmountFragment;
    }

    /* access modifiers changed from: protected */
    public ICfmAmountPresenter onCreatePresenter() {
        if (this.f33880j == 651) {
            return new TransCfmAmountPresenter4Bank(getActivity(), this);
        }
        return new TransCfmAmountPresenter(getActivity(), this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f33880j = arguments.getInt(TransferContants.IntentKey.INTENT_PARAM_KEY_PRODUCT_LINE);
        IConfirmTransferInfo iConfirmTransferInfo = (IConfirmTransferInfo) arguments.getSerializable(TransferContants.IntentKey.INTENT_PARAM_KEY_TRANS_CFM_AMOUNT_MODEL);
        this.f33881k = iConfirmTransferInfo;
        if (iConfirmTransferInfo != null) {
            this.f33866A = iConfirmTransferInfo.getValueByType(IConfirmTransferInfo.ValueType.CPF);
        }
        m25726a();
    }

    /* renamed from: a */
    private void m25726a() {
        if (this.f33880j == 651) {
            TransStore.getInstance().isBankDataPrepared();
        }
    }

    /* access modifiers changed from: protected */
    public void initViews(View view) {
        m25749c();
        this.f33887q = view.findViewById(R.id.trans_cfm_amount_page_root);
        this.f33871a = (ImageView) view.findViewById(R.id.trans_fillamount_head_img);
        this.f33872b = (TextView) view.findViewById(R.id.trans_receiver_name_tv);
        this.f33873c = (TextView) view.findViewById(R.id.trans_money_amount_label_tv);
        view.findViewById(R.id.trans_amount_edit_area_rl);
        this.f33882l = (TextView) view.findViewById(R.id.dollar_symbal);
        CommonEditText commonEditText = (CommonEditText) view.findViewById(R.id.trans_amount_et);
        this.f33874d = commonEditText;
        m25744b(commonEditText);
        this.f33874d.setKeyListener(new NumberKeyListener() {
            public int getInputType() {
                return 8194;
            }

            /* access modifiers changed from: protected */
            public char[] getAcceptedChars() {
                return "0123456789.,".toCharArray();
            }
        });
        this.f33874d.registeTextChangeListener(new CommonEditText.OnTextChangeListener() {
            public void onTextChanged(String str) {
                TransCfmAmountFragment.this.m25734a(str);
            }
        });
        this.f33875e = (TextView) view.findViewById(R.id.trans_amount_errinfo_tv);
        m25729a(view);
        m25752d();
        m25743b(view);
        m25750c(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25734a(String str) {
        String str2;
        String str3;
        String str4;
        long j;
        String str5;
        if (getContext() != null) {
            boolean z = false;
            if (TextUtils.isEmpty(str)) {
                this.f33882l.setTextColor(ContextCompat.getColor(requireContext(), R.color.wallet_color_000000));
                this.f33875e.setVisibility(8);
                this.f33893w.setVisibility(8);
                m25736a(false);
                return;
            }
            TransServiceFeeResp transServiceFeeResp = this.f33870G;
            if (!(transServiceFeeResp == null || transServiceFeeResp.data == null)) {
                z = this.f33870G.data.isSameCpf;
            }
            long dollarToCent = (long) MathUtil.dollarToCent(m25724a(this.f33874d));
            long b = (long) m25741b();
            long j2 = -1;
            if (z) {
                str5 = null;
                str4 = null;
                str3 = null;
                str2 = null;
                j = -1;
            } else {
                LimitRiskDetailVo limitRiskDetailVo = this.f33896z;
                if (limitRiskDetailVo != null) {
                    long j3 = limitRiskDetailVo.riskLimitQuota;
                    String str6 = this.f33896z.description;
                    String str7 = this.f33896z.link;
                    str4 = str6;
                    str3 = str7;
                    j2 = this.f33894x;
                    str5 = this.f33895y;
                    str2 = this.f33896z.payButtonText;
                    j = j3;
                } else {
                    long j4 = this.f33894x;
                    str5 = this.f33895y;
                    str4 = null;
                    str3 = null;
                    str2 = null;
                    j = -1;
                    j2 = j4;
                }
            }
            m25727a(dollarToCent, j2, str5, j, str4, str3, b, str2);
        }
    }

    /* renamed from: a */
    private float m25724a(CommonEditText commonEditText) {
        if (commonEditText != null) {
            return m25740b(m25725a(commonEditText.getTextString(), this.f33883m), this.f33883m);
        }
        throw new IllegalArgumentException("parse float value for input amount fail with invalid params.");
    }

    /* renamed from: a */
    private String m25725a(String str, String str2) {
        return (str == null || str.lastIndexOf(str2) != str.length() + -1) ? str : str.substring(0, str.length() - 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m25741b() {
        TransServiceFeeResp transServiceFeeResp = this.f33870G;
        if (transServiceFeeResp == null || transServiceFeeResp.data == null) {
            return 0;
        }
        int i = this.f33880j;
        if (i == 651) {
            return this.f33870G.data.maxTransferAmountInFen;
        }
        return i == 99998 ? -1 : 0;
    }

    /* renamed from: b */
    private float m25740b(String str, String str2) {
        if (str != null && !TextUtil.isEmpty(str2)) {
            if (str.indexOf(str2) > 0) {
                str = str.replace(str2, ".");
            }
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
            }
        }
        return 0.0f;
    }

    /* renamed from: c */
    private void m25749c() {
        Locale locale = Locale.getDefault();
        DebugUtil.log("current default locale with system setting is %s", locale.toString());
        this.f33883m = Character.toString(((DecimalFormat) DecimalFormat.getInstance(locale)).getDecimalFormatSymbols().getDecimalSeparator());
        this.f33885o = Character.toString(((DecimalFormat) DecimalFormat.getInstance(Locale.US)).getDecimalFormatSymbols().getDecimalSeparator());
        this.f33884n = Character.toString(((DecimalFormat) DecimalFormat.getInstance(new Locale("pt", "BR"))).getDecimalFormatSymbols().getDecimalSeparator());
    }

    /* renamed from: b */
    private void m25744b(CommonEditText commonEditText) {
        if (commonEditText != null) {
            this.f33874d.setHint(DCryptoMainFragment.DCRYPTO_ZERO.replace(".", this.f33883m));
            commonEditText.setFilters(new InputFilter[]{new InputFilter() {
                public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                    String str;
                    boolean z = false;
                    if (TransCfmAmountFragment.this.f33892v) {
                        boolean unused = TransCfmAmountFragment.this.f33892v = false;
                        return null;
                    } else if (!"01233456789,.".contains(String.valueOf(charSequence))) {
                        return "";
                    } else {
                        if (TransCfmAmountFragment.this.f33884n.contentEquals(charSequence) || TransCfmAmountFragment.this.f33885o.contentEquals(charSequence)) {
                            z = true;
                        }
                        if (spanned != null) {
                            str = spanned.toString();
                        } else {
                            str = "";
                        }
                        if (!z || str.length() != 0) {
                            int indexOf = str.indexOf(TransCfmAmountFragment.this.f33883m);
                            if (z) {
                                if (indexOf >= 0) {
                                    return "";
                                }
                                return TransCfmAmountFragment.this.f33883m;
                            } else if ("0".contentEquals(charSequence) && "0".equals(str)) {
                                return "";
                            } else {
                                if (!str.contains(TransCfmAmountFragment.this.f33883m) || i4 - str.indexOf(TransCfmAmountFragment.this.f33883m) < 3) {
                                    return null;
                                }
                                return "";
                            }
                        } else {
                            return "0" + TransCfmAmountFragment.this.f33883m;
                        }
                    }
                }
            }, new InputFilter.LengthFilter(10)});
        }
    }

    /* renamed from: a */
    private void m25729a(View view) {
        this.f33876f = view.findViewById(R.id.trans_extra_fee_rl);
        if (this.f33880j == 651) {
            this.f33877g = (TextView) view.findViewById(R.id.extra_fee_label);
            this.f33879i = (TextView) view.findViewById(R.id.extra_fee_amount);
            ImageView imageView = (ImageView) view.findViewById(R.id.extra_fee_detailrules_img);
            this.f33878h = imageView;
            imageView.setOnClickListener(new DoubleCheckOnClickListener() {
                public void doClick(View view) {
                    TransOmegaUtil.trackEventWithGlobal("ibt_didipay_p2p_bank_account_service_fee_ck", TransGlobalOmegaKey.KEY_WALLET_PAGEID, TransGlobalOmegaKey.KEY_ACCOUNT_STATUS);
                    if (TransCfmAmountFragment.this.f33870G == null || TransCfmAmountFragment.this.f33870G.data == null || TransCfmAmountFragment.this.f33870G.data.withdrawMg == null) {
                        LogUtil.m35172fi("tranfer_log", "no service fee");
                        return;
                    }
                    TransCfmAmountFragment transCfmAmountFragment = TransCfmAmountFragment.this;
                    transCfmAmountFragment.showConfirmDialog(transCfmAmountFragment.f33870G.data.withdrawMg.title, TransCfmAmountFragment.this.f33870G.data.withdrawMg.desc, TransCfmAmountFragment.this.getString(R.string.GRider_Riders_OK_jLdZ), (DoubleCheckOnClickListener) null);
                }
            });
        }
    }

    /* renamed from: d */
    private void m25752d() {
        if (this.f33881k != null) {
            GlideUtils.loadCircleImageWithDefaultImg(getActivity(), Uri.parse(this.f33881k.getValueByType(IConfirmTransferInfo.ValueType.HEAD_ICON)), R.drawable.pay_icon_contacts, this.f33871a);
            String valueByType = this.f33881k.getValueByType(IConfirmTransferInfo.ValueType.NAME);
            this.f33872b.setText(String.format(getResources().getString(R.string.GRider_PAX_Transfer_to_YHvh), new Object[]{valueByType}));
            return;
        }
        DebugUtil.log("Empty transfer cfm amount model! check again!", new Object[0]);
    }

    /* renamed from: b */
    private void m25743b(View view) {
        this.f33889s = view.findViewById(R.id.unable_amount_rl);
        this.f33888r = (TextView) view.findViewById(R.id.trans_amount_all);
        this.f33890t = (TextView) view.findViewById(R.id.unable_amount_label);
        this.f33891u = (TextView) view.findViewById(R.id.unable_amount_btn_label);
        ImageView imageView = (ImageView) view.findViewById(R.id.trans_amount_clear);
        this.f33893w = imageView;
        imageView.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                TransCfmAmountFragment.this.f33874d.setText("");
            }
        });
    }

    public void onViewCreated(View view, Bundle bundle) {
        int i;
        super.onViewCreated(view, bundle);
        try {
            i = Integer.parseInt(PayBaseParamUtil.getStringParam(getContext(), "city_id"));
        } catch (Exception unused) {
            i = 0;
        }
        ((ICfmAmountPresenter) this.mDefaultPresenter).loadServiceFeeData(i, this.f33880j, this.f33866A);
        TransOmegaUtil.trackEventWithGlobal(this.f33880j == 651 ? "ibt_didipay_p2p_bank_account_amount_confirm_sw" : "ibt_didipay_p2p_99pay_amount_confirm_sw", TransGlobalOmegaKey.KEY_WALLET_PAGEID, TransGlobalOmegaKey.KEY_ACCOUNT_STATUS, TransGlobalOmegaKey.KEY_PAYEE_99ACCOUNT_STATUS, TransGlobalOmegaKey.KEY_PAYEE_99PAY_ACCOUNT_STATUS);
    }

    public void onResume() {
        super.onResume();
    }

    public void onShowPageLoadding() {
        notifyParentPageLoading(true);
    }

    public void onDismissPageLoadding() {
        notifyParentPageLoading(false);
    }

    /* renamed from: a */
    private void m25727a(long j, long j2, String str, long j3, String str2, String str3, long j4, String str4) {
        boolean z;
        long j5 = j;
        long j6 = j3;
        String str5 = str2;
        final String str6 = str3;
        boolean z2 = false;
        if (!TextUtils.isEmpty(str4)) {
            if (m25737a(j, j6)) {
                m25735a(getString(R.string.GRider_PAX_Next_step_wnXY), (Boolean) false);
                z = false;
            } else {
                if (!TextUtils.isEmpty(str2)) {
                    m25730a(this.f33875e, str5, new DoubleCheckOnClickListener() {
                        public void doClick(View view) {
                            if (!TextUtils.isEmpty(str6)) {
                                DRouter.build(str6).start(TransCfmAmountFragment.this.getContext());
                            }
                            GlobalOmegaUtils.trackSkuLimitInputExceedCk(TransCfmAmountFragment.this.f33880j);
                        }
                    }, new Runnable() {
                        public void run() {
                            GlobalOmegaUtils.trackSkuLimitInputExceedSw(TransCfmAmountFragment.this.f33880j);
                        }
                    });
                    z2 = true;
                }
                m25735a(str4, (Boolean) true);
                z = z2;
            }
            m25728a(j, j2, str, j4, z);
        } else if (m25737a(j, j6)) {
            m25728a(j, j2, str, j4, false);
        } else {
            if (!TextUtils.isEmpty(str2)) {
                m25730a(this.f33875e, str5, new DoubleCheckOnClickListener() {
                    public void doClick(View view) {
                        if (!TextUtils.isEmpty(str6)) {
                            DRouter.build(str6).start(TransCfmAmountFragment.this.getContext());
                        }
                        GlobalOmegaUtils.trackSkuLimitInputExceedCk(TransCfmAmountFragment.this.f33880j);
                    }
                }, new Runnable() {
                    public void run() {
                        GlobalOmegaUtils.trackSkuLimitInputExceedSw(TransCfmAmountFragment.this.f33880j);
                    }
                });
            }
            this.f33874d.setTextColor(ContextCompat.getColor(requireContext(), R.color.wallet_color_FF4060));
            m25736a(false);
        }
    }

    /* renamed from: a */
    private void m25728a(final long j, long j2, final String str, long j3, boolean z) {
        String str2;
        if (!m25737a(j, j2)) {
            C1173010 r4 = new DoubleCheckOnClickListener() {
                public void doClick(View view) {
                    HashMap hashMap = new HashMap();
                    String str = "bank_transfer_page_id";
                    if (TransCfmAmountFragment.this.m25754e()) {
                        hashMap.put(OmegaUtilKt.ENTRANCE_PAGE_ID, str);
                    } else {
                        hashMap.put(OmegaUtilKt.ENTRANCE_PAGE_ID, "p2p_page_id");
                    }
                    hashMap.put("beyond_limit_amount", TransCfmAmountFragment.this.f33874d.getTextString());
                    if (TransCfmAmountFragment.this.m25754e()) {
                        PayTracker.getTracker().trackEvent("ibt_cash_out_limit_setting_bank_transfer_page_ck", hashMap);
                    } else {
                        PayTracker.getTracker().trackEvent("ibt_cash_out_limit_setting_p2p_page_ck", hashMap);
                    }
                    if (!TransCfmAmountFragment.this.m25754e()) {
                        str = "p2p_page_id";
                    }
                    if (TextUtils.isEmpty(str)) {
                        ((Request) DRouter.build("99pay://one/nightly_limit_setting").putExtra("pageFrom", str)).start(TransCfmAmountFragment.this.requireContext(), new RouterCallback.ActivityCallback() {
                            public void onActivityResult(int i, Intent intent) {
                                if (i == -1) {
                                    ((ICfmAmountPresenter) TransCfmAmountFragment.this.mDefaultPresenter).loadNightlyLimitConfig(TransCfmAmountFragment.this.f33880j);
                                }
                            }
                        });
                    } else {
                        DRouter.build("99pay://one/nightly_limit_result").start(TransCfmAmountFragment.this.requireContext());
                    }
                }
            };
            if (TextUtils.isEmpty(str)) {
                str2 = getString(R.string.GRider_limit_Beyond_the_GuvV);
            } else {
                str2 = getString(R.string.GRider_2_When_the_QyBM);
            }
            m25730a(this.f33875e, str2, r4, new Runnable() {
                public void run() {
                    HashMap hashMap = new HashMap();
                    if (TransCfmAmountFragment.this.m25754e()) {
                        hashMap.put(OmegaUtilKt.ENTRANCE_PAGE_ID, "bank_transfer_page_id");
                    } else {
                        hashMap.put(OmegaUtilKt.ENTRANCE_PAGE_ID, "p2p_page_id");
                    }
                    hashMap.put("beyond_limit_amount", MathUtil.centToDollar(Double.valueOf(((double) j) * 1.0d)));
                    if (TransCfmAmountFragment.this.m25754e()) {
                        PayTracker.getTracker().trackEvent("ibt_cash_out_limit_setting_bank_transfer_page_bt", hashMap);
                    } else {
                        PayTracker.getTracker().trackEvent("ibt_cash_out_limit_setting_p2p_page_bt", hashMap);
                    }
                }
            });
            this.f33874d.setTextColor(ContextCompat.getColor(requireContext(), R.color.wallet_color_FF4060));
            m25736a(false);
        } else if (m25737a(j, j3)) {
            if (!z) {
                m25730a(this.f33875e, (String) null, (View.OnClickListener) null, (Runnable) null);
            }
            this.f33874d.setTextColor(ContextCompat.getColor(requireContext(), R.color.wallet_color_000000));
            m25736a(true);
        } else {
            m25730a(this.f33875e, getString(R.string.GRider_PAX_Input_exceeds_zALV), (View.OnClickListener) null, (Runnable) null);
            this.f33874d.setTextColor(ContextCompat.getColor(requireContext(), R.color.wallet_color_FF4060));
            m25736a(false);
        }
    }

    /* renamed from: a */
    private void m25730a(TextView textView, String str, View.OnClickListener onClickListener, Runnable runnable) {
        textView.setText(str);
        textView.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        textView.setOnClickListener(onClickListener);
        if (!TextUtils.isEmpty(str) && runnable != null) {
            runnable.run();
        }
    }

    public void openCashier(TransCreateOrderResp.DataBean dataBean, int i) {
        m25733a(dataBean, i);
    }

    /* renamed from: a */
    private void m25733a(final TransCreateOrderResp.DataBean dataBean, final int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("product_line", Integer.valueOf(i));
        CashierParam cashierParam = new CashierParam();
        cashierParam.setOmegaAttrs(hashMap);
        cashierParam.setOutTradeId(dataBean.outTradeId);
        if (dataBean.cashierType == 1) {
            FastPayFacade.getInstance().pay((Activity) getActivity(), 200, cashierParam);
        } else {
            CashierFacade.getInstance().launchForResult((Activity) getActivity(), 200, cashierParam, (CashierLaunchListener) !WalletApolloUtil.useNewCashier() ? new CashierLaunchListener() {
                public void onCashierLaunch(boolean z) {
                    if (!z) {
                        TransCfmAmountFragment.this.m25746b(dataBean, i);
                    }
                }
            } : null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m25746b(TransCreateOrderResp.DataBean dataBean, int i) {
        PayParam payParam = new PayParam();
        payParam.outTradeId = dataBean.outTradeId;
        payParam.omegaAttrs = new HashMap();
        payParam.omegaAttrs.put("product_line", Integer.valueOf(i));
        TransferCashierActivity.launch(getActivity(), payParam, 100);
    }

    public void toOrderDetailPage(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt(TransferContants.IntentKey.INTENT_PARAM_KEY_PRODUCT_LINE, this.f33880j);
        bundle.putInt(TransferContants.IntentKey.INTENT_PARAM_KEY_ORDER_TYPE, 0);
        bundle.putString(TransferContants.IntentKey.INTENT_PARAM_KEY_ORDER_ID, str);
        bundle.putBoolean(TransferContants.IntentKey.INTENT_PARAMS_KEY_HAS99PAY, Boolean.parseBoolean(getInputValue(IConfirmTransferInfo.ValueType.Account99_Exist)));
        TransOrderDetailActivity.launch(getContext(), 0, bundle);
        getActivity().finish();
    }

    public void onServiceFeeGot(TransServiceFeeResp transServiceFeeResp) {
        this.f33887q.setVisibility(0);
        UIHandler.getHandler().postDelayed(new Runnable() {
            public void run() {
                InputTools.showKeyboard(TransCfmAmountFragment.this.f33874d);
            }
        }, 100);
        this.f33874d.setEnabled(true);
        String string = getActivity() != null ? getActivity().getString(R.string.Trans_money_symbal_default) : "R$";
        if (!(transServiceFeeResp == null || transServiceFeeResp.data == null)) {
            string = transServiceFeeResp.data.symbol;
        }
        this.f33882l.setText(string);
        if (transServiceFeeResp != null) {
            this.f33870G = transServiceFeeResp;
            if (this.f33880j == 651) {
                String str = transServiceFeeResp.data != null ? transServiceFeeResp.data.withdrawFeeLabel : "";
                if (TextUtils.isEmpty(str)) {
                    this.f33879i.setVisibility(8);
                    return;
                }
                this.f33876f.setVisibility(0);
                this.f33879i.setVisibility(0);
                this.f33879i.setText(str);
            }
            if (transServiceFeeResp.data != null) {
                if (!TextUtils.isEmpty(transServiceFeeResp.data.unableAmountLabel)) {
                    this.f33889s.setVisibility(0);
                    this.f33890t.setText(transServiceFeeResp.data.unableAmountLabel);
                    this.f33890t.setVisibility(0);
                    if (!TextUtils.isEmpty(transServiceFeeResp.data.unableAmountBtnLabel) && !TextUtils.isEmpty(transServiceFeeResp.data.unableAmountDesc)) {
                        this.f33891u.setText(transServiceFeeResp.data.unableAmountBtnLabel);
                        this.f33891u.setVisibility(0);
                        this.f33891u.setOnClickListener(new DoubleCheckOnClickListener() {
                            public void doClick(View view) {
                                if (TransCfmAmountFragment.this.f33870G != null && TransCfmAmountFragment.this.f33870G.data != null && TransCfmAmountFragment.this.f33870G.data.unableAmountDesc != null) {
                                    TransCfmAmountFragment transCfmAmountFragment = TransCfmAmountFragment.this;
                                    transCfmAmountFragment.showConfirmDialog(transCfmAmountFragment.f33870G.data.unableAmountDesc, (String) null, TransCfmAmountFragment.this.getString(R.string.GRider_Riders_OK_jLdZ), (DoubleCheckOnClickListener) null);
                                }
                            }
                        });
                    }
                }
                if (TextUtils.isEmpty(transServiceFeeResp.data.maxTransferAmountLabel) || this.f33874d == null) {
                    this.f33873c.setVisibility(0);
                } else {
                    SpannableString spannableString = new SpannableString(transServiceFeeResp.data.maxTransferAmountLabel);
                    spannableString.setSpan(new AbsoluteSizeSpan(16, true), 0, spannableString.length(), 33);
                    this.f33874d.setHint(spannableString);
                }
                if (((double) transServiceFeeResp.data.maxTransferAmountInFen) > 0.0d) {
                    this.f33888r.setVisibility(0);
                    this.f33888r.setOnClickListener(new DoubleCheckOnClickListener() {
                        public void doClick(View view) {
                            try {
                                if (TransCfmAmountFragment.this.f33870G != null && TransCfmAmountFragment.this.f33870G.data != null && TransCfmAmountFragment.this.f33870G.data.maxTransferAmountInFen > 0) {
                                    DecimalFormat decimalFormat = new DecimalFormat(DCryptoMainFragment.DCRYPTO_ZERO);
                                    double d = (double) TransCfmAmountFragment.this.f33870G.data.maxTransferAmountInFen;
                                    if (TransCfmAmountFragment.this.m25741b() > 0 && d > ((double) TransCfmAmountFragment.this.m25741b())) {
                                        d = (double) TransCfmAmountFragment.this.m25741b();
                                    }
                                    boolean unused = TransCfmAmountFragment.this.f33892v = true;
                                    TransCfmAmountFragment.this.f33874d.setText(decimalFormat.format(d / 100.0d).replace(".", TransCfmAmountFragment.this.f33883m));
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
                m25735a(getString(R.string.GRider_PAX_Next_step_wnXY), (Boolean) false);
                if (m25756f()) {
                    FastPayUT.INSTANCE.trackFastPayBtnShow(this.f33880j);
                }
            }
        }
    }

    public void onSecondConfirmInfo() {
        Bundle bundle = new Bundle();
        this.f33881k.setTypeValue(IConfirmTransferInfo.ValueType.Transfer_Amount, getInputValue(IConfirmTransferInfo.ValueType.Transfer_Amount));
        this.f33881k.setTypeValue(IConfirmTransferInfo.ValueType.Transfer_MoneySymbal, getInputValue(IConfirmTransferInfo.ValueType.Transfer_MoneySymbal));
        this.f33881k.setTypeValue(IConfirmTransferInfo.ValueType.Transfer_ServiceFee, getInputValue(IConfirmTransferInfo.ValueType.Transfer_ServiceFee));
        this.f33881k.setTypeValue(IConfirmTransferInfo.ValueType.Transfer_Total_Amount, getInputValue(IConfirmTransferInfo.ValueType.Transfer_Total_Amount));
        bundle.putSerializable("transfer_to_bank_data", this.f33881k);
        TransConfirmBankInfoDialog newInstance = TransConfirmBankInfoDialog.newInstance(bundle);
        newInstance.setOperationListener(new TransConfirmBankInfoDialog.OperationListener() {
            public void onAction(int i, Bundle bundle) {
                if (i == 0) {
                    ((ICfmAmountPresenter) TransCfmAmountFragment.this.mDefaultPresenter).createOrder(TransCfmAmountFragment.this.f33880j, 0, "", false);
                    TransOmegaUtil.trackEventWithGlobal("ibt_didipay_p2p_bank_account_account_details_confirm_ck", TransGlobalOmegaKey.KEY_WALLET_PAGEID, TransGlobalOmegaKey.KEY_ACCOUNT_STATUS, TransGlobalOmegaKey.KEY_PAYEE_99ACCOUNT_STATUS, TransGlobalOmegaKey.KEY_PAYEE_99PAY_ACCOUNT_STATUS);
                }
            }
        });
        newInstance.show(getFragmentManager(), "trans_to_bank_confirm_dialog");
    }

    /* renamed from: com.didi.payment.transfer.fillamount.TransCfmAmountFragment$22 */
    static /* synthetic */ class C1174522 {

        /* renamed from: $SwitchMap$com$didi$payment$transfer$fillamount$IConfirmTransferInfo$ValueType */
        static final /* synthetic */ int[] f33897x9e3d9ebc;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType[] r0 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f33897x9e3d9ebc = r0
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.NAME     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f33897x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.CPF     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f33897x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.BANK_CODE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f33897x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.AGENT_CODE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f33897x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.BANK_CARD     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f33897x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.To_TEL     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f33897x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.To_CountryCode     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f33897x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.Account_Exist     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f33897x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x006c }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.Account99_Exist     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f33897x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.HEAD_ICON     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f33897x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.ACCOUNT_TYPE     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f33897x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.ACCOUNT_TYPE_VALUE     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f33897x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x009c }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.Transfer_Amount     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f33897x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.Transfer_Amount4Program     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f33897x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.Transfer_Total_Amount     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f33897x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.Transfer_MoneySymbal     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f33897x9e3d9ebc     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.didi.payment.transfer.fillamount.IConfirmTransferInfo$ValueType r1 = com.didi.payment.transfer.fillamount.IConfirmTransferInfo.ValueType.Transfer_ServiceFee     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.transfer.fillamount.TransCfmAmountFragment.C1174522.<clinit>():void");
        }
    }

    public String getInputValue(IConfirmTransferInfo.ValueType valueType) {
        switch (C1174522.f33897x9e3d9ebc[valueType.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                return this.f33881k.getValueByType(valueType);
            case 13:
                return m25725a(this.f33874d.getTextString(), this.f33883m);
            case 14:
                return String.valueOf(m25724a(this.f33874d));
            case 15:
                TransServiceFeeResp transServiceFeeResp = this.f33870G;
                int i = (transServiceFeeResp == null || transServiceFeeResp.data == null) ? 0 : this.f33870G.data.withdrawFeeInFen;
                float f = 0.0f;
                try {
                    f = m25724a(this.f33874d);
                } catch (Exception unused) {
                    DebugUtil.log("invalid input transfer amount!", new Object[0]);
                }
                String format = new DecimalFormat("#.##").format((double) (((float) (i + MathUtil.dollarToCent(f))) / 100.0f));
                return (format == null || format.contains(this.f33883m)) ? format : format.replace(".", this.f33883m);
            case 16:
                TransServiceFeeResp transServiceFeeResp2 = this.f33870G;
                return (transServiceFeeResp2 == null || transServiceFeeResp2.data == null) ? getString(R.string.Trans_money_symbal_default) : this.f33870G.data.symbol;
            case 17:
                TransServiceFeeResp transServiceFeeResp3 = this.f33870G;
                if (transServiceFeeResp3 != null && transServiceFeeResp3.data != null) {
                    return this.f33870G.data.withdrawFeeLabel;
                }
                return String.format(getString(R.string.Trans_money_symbal_default_prefix), new Object[]{DCryptoMainFragment.DCRYPTO_ZERO.replace(".", this.f33883m)});
            default:
                return "";
        }
    }

    public void onFetchLimit(GetNightlyLimitResp.NightlyLimitVo nightlyLimitVo) {
        if (getContext() != null) {
            if (nightlyLimitVo != null) {
                if (nightlyLimitVo.isHit) {
                    this.f33894x = nightlyLimitVo.remainingLimit;
                    this.f33895y = nightlyLimitVo.effectiveTime;
                } else {
                    this.f33894x = -1;
                    this.f33895y = null;
                }
                this.f33896z = nightlyLimitVo.limitRiskDetail;
            }
            m25734a(this.f33874d.getTextString());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            String stringExtra = intent.getStringExtra("message");
            if (i == 200) {
                if (intent.getIntExtra("code", 3) == 1) {
                    ((ICfmAmountPresenter) this.mDefaultPresenter).onPaySuccess(stringExtra);
                }
            } else if (i == 100 && intent.getIntExtra("code", 3) == 1) {
                ((ICfmAmountPresenter) this.mDefaultPresenter).onPaySuccess(stringExtra);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m25754e() {
        return this.f33880j == 651;
    }

    public void payPwdInfo(PasswordDataVo passwordDataVo) {
        OpenCertificationListener openCertificationListener;
        Context context;
        if (passwordDataVo.getType() == 0) {
            if (passwordDataVo.getTitle() != null && passwordDataVo.getContent() != null && passwordDataVo.getConfirmButton() != null && passwordDataVo.getCancelButton() != null && (context = getContext()) != null) {
                FinOmegaSDK.trackEvent("ibt_password_paying_bottom_popoup_sw");
                final WalletDialog createDrawer = WalletDialog.createDrawer(context, true, true);
                WalletDrawerContent.Builder builder = new WalletDrawerContent.Builder();
                builder.setTitle(passwordDataVo.getTitle());
                builder.setContent(passwordDataVo.getContent());
                builder.setSecondBtnText(passwordDataVo.getCancelButton());
                builder.setSecondClickListener(new DoubleCheckOnClickListener() {
                    public void doClick(View view) {
                        createDrawer.dismiss();
                    }
                });
                builder.setFirstBtnText(passwordDataVo.getConfirmButton());
                builder.setFirstClickListener(new DoubleCheckOnClickListener() {
                    public void doClick(View view) {
                        FinOmegaSDK.trackEvent("ibt_password_paying_bottom_popoup_yes_ck");
                        OpenCertificationListener openCertificationListener = (OpenCertificationListener) ServiceLoaderUtil.getInstance().load(OpenCertificationListener.class);
                        if (openCertificationListener != null) {
                            PaySecure.INSTANCE.createPayPassword(PasswordScene.TRANSFER_TO_CARD.name(), openCertificationListener, new SetPwdResultListener() {
                                public void onFailure(String str, String str2) {
                                }

                                public void onSuccess(String str) {
                                    ((ICfmAmountPresenter) TransCfmAmountFragment.this.mDefaultPresenter).createOrder(TransCfmAmountFragment.this.f33880j, 0, str, false);
                                }
                            });
                        }
                        createDrawer.dismiss();
                    }
                });
                createDrawer.setContentView((View) builder.build(context));
                SystemUtils.showDialog(createDrawer);
            }
        } else if (passwordDataVo.getType() == 1 && (openCertificationListener = (OpenCertificationListener) ServiceLoaderUtil.getInstance().load(OpenCertificationListener.class)) != null && passwordDataVo.getPaySessionId() != null) {
            PaySecure paySecure = PaySecure.INSTANCE;
            String name = PasswordScene.CHECK_OUT_WALLET.name();
            String paySessionId = passwordDataVo.getPaySessionId();
            paySecure.verifyPayPassword(name, paySessionId, this.f33882l.getText().toString() + getInputValue(IConfirmTransferInfo.ValueType.Transfer_Total_Amount), new PayPwdResultListener() {
                public void onFailure(String str, String str2) {
                }

                public void onSuccess(String str) {
                    ((ICfmAmountPresenter) TransCfmAmountFragment.this.mDefaultPresenter).createOrder(TransCfmAmountFragment.this.f33880j, 0, str, false);
                }
            }, openCertificationListener);
        }
    }

    /* renamed from: f */
    private boolean m25756f() {
        TransServiceFeeResp.WithDraw withDraw;
        TransServiceFeeResp transServiceFeeResp = this.f33870G;
        if (transServiceFeeResp == null || this.f33880j != 99998 || (withDraw = transServiceFeeResp.data) == null || withDraw.fastPayData == null || !withDraw.fastPayData.isSupportFastPay()) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private void m25750c(View view) {
        this.f33867B = (LinearLayout) view.findViewById(R.id.ll_switch_pay_method_container);
        this.f33868C = (TextView) view.findViewById(R.id.tv_pay_method_title);
        this.f33867B.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                TransCfmAmountFragment.this.m25747b(false);
                FastPayUT.INSTANCE.trackFastPay2CashierBtnClk(TransCfmAmountFragment.this.f33880j);
            }
        });
        TextView textView = (TextView) view.findViewById(R.id.trans_btn_cfm_transamount_next);
        this.f33869D = textView;
        textView.setOnClickListener(new DoubleCheckOnClickListener(1000) {
            public void doClick(View view) {
                boolean z = ((Integer) view.getTag()).intValue() == 2;
                TransCfmAmountFragment.this.m25747b(z);
                if (z) {
                    FastPayUT.INSTANCE.trackFastPayBtnClk(TransCfmAmountFragment.this.f33880j);
                }
            }
        });
    }

    /* renamed from: a */
    private void m25735a(String str, Boolean bool) {
        if (!m25756f() || bool.booleanValue()) {
            this.f33869D.setText(str);
            this.f33869D.setTag(1);
            this.f33867B.setVisibility(8);
            return;
        }
        FastPayData fastPayData = this.f33870G.data.fastPayData;
        this.f33869D.setText(fastPayData.getFastPayButtonText());
        this.f33869D.setTag(2);
        this.f33867B.setVisibility(0);
        this.f33868C.setText(fastPayData.getPaymentMethodText());
    }

    /* renamed from: a */
    private void m25736a(boolean z) {
        this.f33869D.setEnabled(z);
        this.f33867B.setEnabled(z);
        this.f33868C.setEnabled(z);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m25747b(boolean z) {
        float a = m25724a(this.f33874d);
        if (this.f33880j == 651) {
            TransOmegaUtil.trackEventWithGlobal("ibt_didipay_p2p_bank_account_amount_confirm_ck", TransGlobalOmegaKey.KEY_WALLET_PAGEID, TransGlobalOmegaKey.KEY_ACCOUNT_STATUS, TransGlobalOmegaKey.KEY_PAYEE_99ACCOUNT_STATUS, TransGlobalOmegaKey.KEY_PAYEE_99PAY_ACCOUNT_STATUS);
        } else {
            HashMap hashMap = new HashMap();
            TransServiceFeeResp transServiceFeeResp = this.f33870G;
            if (!(transServiceFeeResp == null || transServiceFeeResp.data == null)) {
                hashMap.put("reward_balance", Integer.valueOf(this.f33870G.data.userBlockAmount));
                hashMap.put("normal_balance", Integer.valueOf(this.f33870G.data.userAvailableAmount));
            }
            hashMap.put("order_amount", Float.valueOf(a));
            TransOmegaUtil.trackEventWithGlobal("ibt_didipay_p2p_99pay_amount_confirm_ck", hashMap, TransGlobalOmegaKey.KEY_WALLET_PAGEID, TransGlobalOmegaKey.KEY_ACCOUNT_STATUS, TransGlobalOmegaKey.KEY_PAYEE_99ACCOUNT_STATUS, TransGlobalOmegaKey.KEY_PAYEE_99PAY_ACCOUNT_STATUS);
        }
        if (a <= 0.0f) {
            WalletToastNew.showFailedMsg(getContext(), getString(R.string.GRider_PAX_Input_invalid_zALV));
        } else if (m25741b() > 0 && MathUtil.dollarToCent(a) > m25741b()) {
            WalletToastNew.showFailedMsg(getContext(), getString(R.string.GRider_PAX_Input_exceeds_zALV));
        } else if (((ICfmAmountPresenter) this.mDefaultPresenter).needSecondConfirmData()) {
            onSecondConfirmInfo();
        } else {
            ((ICfmAmountPresenter) this.mDefaultPresenter).createOrder(this.f33880j, 0, "", z);
        }
    }
}
