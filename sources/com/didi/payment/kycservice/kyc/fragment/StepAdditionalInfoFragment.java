package com.didi.payment.kycservice.kyc.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.commonsdk.p130ui.WBaseFragment;
import com.didi.payment.commonsdk.p130ui.WBaseViewModel;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.commonsdk.utils.OmegaComParams;
import com.didi.payment.kycservice.kyc.SignUpVM;
import com.didi.payment.kycservice.kyc.p134vm.FullKycExtraVM;
import com.didi.payment.kycservice.net.response.AddressZipCodeResp;
import com.didi.payment.kycservice.net.response.PixGetApplyInfoResp;
import com.didi.payment.kycservice.utils.KycSPUtils;
import com.didi.payment.kycservice.utils.ViewExtsKt;
import com.didi.payment.kycservice.widget.NewPixInputView;
import com.taxis99.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u0019H\u0002J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020 H\u0002J&\u0010$\u001a\u0004\u0018\u00010 2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u0019H\u0016J\b\u0010,\u001a\u00020\u0019H\u0016J\u001a\u0010-\u001a\u00020\u00192\u0006\u0010#\u001a\u00020 2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u0002H\u0016J\u0010\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020\u0019H\u0002J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u00069"}, mo148868d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/StepAdditionalInfoFragment;", "Lcom/didi/payment/commonsdk/ui/WBaseFragment;", "Lcom/didi/payment/kycservice/kyc/vm/FullKycExtraVM;", "()V", "addressType", "", "blockId", "mAddMoreInput", "Lcom/didi/payment/kycservice/widget/NewPixInputView;", "mCityInput", "mDistrictInput", "mExpandInfoContainer", "Landroid/widget/LinearLayout;", "mNumberInput", "mPreBtn", "Landroid/widget/ImageView;", "mStateInput", "mStreetInput", "mSubmitBtn", "Landroid/widget/TextView;", "mZipCodeInput", "pixSignUpVM", "Lcom/didi/payment/kycservice/kyc/SignUpVM;", "uid", "clearFormerInfo", "", "closeKeyboard", "fillInfoFromNetwork", "kycInfo", "Lcom/didi/payment/kycservice/net/response/PixGetApplyInfoResp$CPFInfo;", "fillInfoFromSp", "getTitleBarView", "Landroid/view/View;", "initListener", "initView", "view", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onResume", "onViewCreated", "subscribeUi", "vm", "updateAddress", "addressResp", "Lcom/didi/payment/kycservice/net/response/AddressZipCodeResp$DataBean;", "updateSubmitBtn", "validInput", "", "tag", "", "Companion", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: StepAdditionalInfoFragment.kt */
public final class StepAdditionalInfoFragment extends WBaseFragment<FullKycExtraVM> {
    public static final String ADDRESS_TYPE = "typeId";
    public static final String BLOCK_ID = "blockId";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: o */
    private static final String f33320o = "state";

    /* renamed from: p */
    private static final String f33321p = "city";

    /* renamed from: q */
    private static final String f33322q = "type";

    /* renamed from: r */
    private static final String f33323r = "result";

    /* renamed from: s */
    private static final String f33324s = "99OneTravel://one/wallet_address_list";

    /* renamed from: t */
    private static final int f33325t = 2;

    /* renamed from: u */
    private static final int f33326u = 3;

    /* renamed from: a */
    private ImageView f33327a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public NewPixInputView f33328b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public LinearLayout f33329c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public NewPixInputView f33330d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public NewPixInputView f33331e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public NewPixInputView f33332f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public NewPixInputView f33333g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public NewPixInputView f33334h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public NewPixInputView f33335i;

    /* renamed from: j */
    private TextView f33336j;

    /* renamed from: k */
    private SignUpVM f33337k;

    /* renamed from: l */
    private String f33338l = "";

    /* renamed from: m */
    private String f33339m;

    /* renamed from: n */
    private String f33340n;

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return null;
    }

    public static final /* synthetic */ FullKycExtraVM access$getVm(StepAdditionalInfoFragment stepAdditionalInfoFragment) {
        return (FullKycExtraVM) stepAdditionalInfoFragment.getVm();
    }

    @Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo148868d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/StepAdditionalInfoFragment$Companion;", "", "()V", "ADDRESS_TYPE", "", "APARTMENT_TAG", "", "BLOCK_ID", "CITY", "RESULT", "ROUTER_ADDRESS_LIST", "STATE", "TYPE", "ZIPCODE_TAG", "newInstance", "Lcom/didi/payment/kycservice/kyc/fragment/StepAdditionalInfoFragment;", "bundle", "Landroid/os/Bundle;", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: StepAdditionalInfoFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StepAdditionalInfoFragment newInstance(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            StepAdditionalInfoFragment stepAdditionalInfoFragment = new StepAdditionalInfoFragment();
            stepAdditionalInfoFragment.setArguments(bundle);
            return stepAdditionalInfoFragment;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_step_additional_info, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ViewModel viewModel = new ViewModelProvider(requireActivity()).get(SignUpVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir…get(SignUpVM::class.java)");
        this.f33337k = (SignUpVM) viewModel;
        ViewModel viewModel2 = new ViewModelProvider(requireParentFragment()).get(FullKycExtraVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(requir…llKycExtraVM::class.java)");
        setVm((WBaseViewModel) viewModel2);
        Bundle arguments = getArguments();
        String str = null;
        this.f33339m = arguments == null ? null : arguments.getString("typeId");
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str = arguments2.getString("blockId");
        }
        this.f33340n = str;
        if (Intrinsics.areEqual((Object) this.f33339m, (Object) "1")) {
            OmegaComParams.Companion.setPubPage(OmegaComParams.ADDRESS_VERIFY);
        } else {
            OmegaComParams.Companion.setPubPage(OmegaComParams.FULL_KYC);
        }
        m25358a(view);
        m25357a();
        m25368b();
        subscribeUi((FullKycExtraVM) getVm());
        String stringParam = PayBaseParamUtil.getStringParam(getContext(), "phone");
        Intrinsics.checkNotNullExpressionValue(stringParam, "getStringParam(context, PayParam.PHONE)");
        this.f33338l = stringParam;
        KycOmega.Companion.trackEvent("fin_table2_code_sw");
    }

    public void onDestroyView() {
        super.onDestroyView();
        OmegaComParams.Companion.setPUB_FROM_PAGE(Intrinsics.areEqual((Object) this.f33339m, (Object) "1") ? "" : OmegaComParams.FULL_KYC);
    }

    /* renamed from: a */
    private final void m25358a(View view) {
        View findViewById = view.findViewById(R.id.account_zipcode);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.account_zipcode)");
        this.f33328b = (NewPixInputView) findViewById;
        View findViewById2 = view.findViewById(R.id.account_expand_info_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.a…nt_expand_info_container)");
        this.f33329c = (LinearLayout) findViewById2;
        View findViewById3 = view.findViewById(R.id.account_street);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.account_street)");
        this.f33330d = (NewPixInputView) findViewById3;
        View findViewById4 = view.findViewById(R.id.account_apartment_number);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.account_apartment_number)");
        this.f33331e = (NewPixInputView) findViewById4;
        View findViewById5 = view.findViewById(R.id.account_other_info);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.account_other_info)");
        this.f33332f = (NewPixInputView) findViewById5;
        View findViewById6 = view.findViewById(R.id.account_district);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.account_district)");
        this.f33333g = (NewPixInputView) findViewById6;
        View findViewById7 = view.findViewById(R.id.account_state);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.account_state)");
        this.f33334h = (NewPixInputView) findViewById7;
        View findViewById8 = view.findViewById(R.id.account_city);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.account_city)");
        this.f33335i = (NewPixInputView) findViewById8;
        View findViewById9 = view.findViewById(R.id.btn_next);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.btn_next)");
        this.f33336j = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.btn_pre_page);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.btn_pre_page)");
        this.f33327a = (ImageView) findViewById10;
        TextView textView = this.f33336j;
        NewPixInputView newPixInputView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSubmitBtn");
            textView = null;
        }
        textView.setText(getString(Intrinsics.areEqual((Object) this.f33339m, (Object) "1") ? R.string.Fintech_Payment_Optimization_Submission_hMgW : R.string.Fintech_Payment_Optimization_Next_step_SRDJ));
        NewPixInputView newPixInputView2 = this.f33328b;
        if (newPixInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mZipCodeInput");
            newPixInputView2 = null;
        }
        String string = getString(R.string.Fintech_Payment_improvment_HfBc_MukB);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.Finte…ent_improvment_HfBc_MukB)");
        newPixInputView2.initData(string, 8, 2, "00000000");
        NewPixInputView newPixInputView3 = this.f33330d;
        if (newPixInputView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStreetInput");
            newPixInputView3 = null;
        }
        String string2 = getString(R.string.kyc_extra_addr_street);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.kyc_extra_addr_street)");
        newPixInputView3.initData(string2, 100, 1);
        NewPixInputView newPixInputView4 = this.f33331e;
        if (newPixInputView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
            newPixInputView4 = null;
        }
        String string3 = getString(R.string.kyc_extra_addr_number);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.kyc_extra_addr_number)");
        String string4 = getString(R.string.Fintech_Payment_Optimization_e_g_FChd);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.Finte…nt_Optimization_e_g_FChd)");
        newPixInputView4.initData(string3, 20, 2, string4);
        NewPixInputView newPixInputView5 = this.f33331e;
        if (newPixInputView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
            newPixInputView5 = null;
        }
        String string5 = getString(R.string.Fintech_Payment_Optimization_No_house_CmWq);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(R.string.Finte…timization_No_house_CmWq)");
        newPixInputView5.setCheckBoxTitle(string5);
        NewPixInputView newPixInputView6 = this.f33332f;
        if (newPixInputView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddMoreInput");
            newPixInputView6 = null;
        }
        String string6 = getString(R.string.kyc_extra_addr_complement);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(R.string.kyc_extra_addr_complement)");
        String string7 = getString(R.string.Fintech_Payment_Optimization_Apartments_blocks_qnaq);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(R.string.Finte…n_Apartments_blocks_qnaq)");
        newPixInputView6.initData(string6, 30, 1, string7);
        NewPixInputView newPixInputView7 = this.f33333g;
        if (newPixInputView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDistrictInput");
            newPixInputView7 = null;
        }
        String string8 = getString(R.string.kyc_extra_addr_district);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(R.string.kyc_extra_addr_district)");
        newPixInputView7.initData(string8, 30, 1);
        NewPixInputView newPixInputView8 = this.f33334h;
        if (newPixInputView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
            newPixInputView8 = null;
        }
        String string9 = getString(R.string.kyc_extra_addr_state);
        Intrinsics.checkNotNullExpressionValue(string9, "getString(R.string.kyc_extra_addr_state)");
        newPixInputView8.initData(string9, 200, 1);
        NewPixInputView newPixInputView9 = this.f33335i;
        if (newPixInputView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCityInput");
        } else {
            newPixInputView = newPixInputView9;
        }
        String string10 = getString(R.string.kyc_extra_addr_city);
        Intrinsics.checkNotNullExpressionValue(string10, "getString(R.string.kyc_extra_addr_city)");
        newPixInputView.initData(string10, 200, 1);
        m25372d();
    }

    public void subscribeUi(FullKycExtraVM fullKycExtraVM) {
        Intrinsics.checkNotNullParameter(fullKycExtraVM, "vm");
        fullKycExtraVM.getAddressInfo().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                StepAdditionalInfoFragment.m25360a(StepAdditionalInfoFragment.this, (AddressZipCodeResp.DataBean) obj);
            }
        });
        fullKycExtraVM.getCpfinfo().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                StepAdditionalInfoFragment.m25361a(StepAdditionalInfoFragment.this, (PixGetApplyInfoResp.CPFInfo) obj);
            }
        });
        fullKycExtraVM.getErrorMsg().observe(getViewLifecycleOwner(), $$Lambda$StepAdditionalInfoFragment$dK3SVICEZNh_VymjhRof1ZghQrg.INSTANCE);
        NewPixInputView newPixInputView = this.f33330d;
        SignUpVM signUpVM = null;
        if (newPixInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStreetInput");
            newPixInputView = null;
        }
        SignUpVM signUpVM2 = this.f33337k;
        if (signUpVM2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM2 = null;
        }
        newPixInputView.setEditViewEnabled(!signUpVM2.isNewStep());
        NewPixInputView newPixInputView2 = this.f33335i;
        if (newPixInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCityInput");
            newPixInputView2 = null;
        }
        SignUpVM signUpVM3 = this.f33337k;
        if (signUpVM3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM3 = null;
        }
        newPixInputView2.setEditViewEnabled(!signUpVM3.isNewStep());
        NewPixInputView newPixInputView3 = this.f33334h;
        if (newPixInputView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
            newPixInputView3 = null;
        }
        SignUpVM signUpVM4 = this.f33337k;
        if (signUpVM4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
        } else {
            signUpVM = signUpVM4;
        }
        newPixInputView3.setEditViewEnabled(!signUpVM.isNewStep());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25360a(StepAdditionalInfoFragment stepAdditionalInfoFragment, AddressZipCodeResp.DataBean dataBean) {
        Intrinsics.checkNotNullParameter(stepAdditionalInfoFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(dataBean, "it");
        stepAdditionalInfoFragment.m25364a(dataBean);
        NewPixInputView newPixInputView = stepAdditionalInfoFragment.f33328b;
        if (newPixInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mZipCodeInput");
            newPixInputView = null;
        }
        newPixInputView.hideErrorInfo();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25361a(StepAdditionalInfoFragment stepAdditionalInfoFragment, PixGetApplyInfoResp.CPFInfo cPFInfo) {
        Intrinsics.checkNotNullParameter(stepAdditionalInfoFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(cPFInfo, "it");
        stepAdditionalInfoFragment.m25365a(cPFInfo);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25366a(String str) {
        Map linkedHashMap = new LinkedHashMap();
        if (str == null) {
            str = "";
        }
        linkedHashMap.put("error_message", str);
        KycOmega.Companion.trackEvent("fin_fullkycinformation_toast_sw", linkedHashMap);
    }

    public void onResume() {
        super.onResume();
        SignUpVM signUpVM = this.f33337k;
        if (signUpVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM = null;
        }
        signUpVM.updateStepProgress(KycFormStep.STEP_ADDRESS);
    }

    /* renamed from: a */
    private final void m25357a() {
        Context context = getContext();
        if (context != null) {
            String stringParam = PayBaseParamUtil.getStringParam(context, "phone");
            KycSPUtils.Companion companion = KycSPUtils.Companion;
            Intrinsics.checkNotNullExpressionValue(stringParam, "phone");
            String zipCode = companion.getZipCode(context, stringParam);
            String apartmentNum = KycSPUtils.Companion.getApartmentNum(context, stringParam);
            boolean isNoApartmentNum = KycSPUtils.Companion.isNoApartmentNum(context, stringParam);
            String street = KycSPUtils.Companion.getStreet(context, stringParam);
            String optionalInfo = KycSPUtils.Companion.getOptionalInfo(context, stringParam);
            String district = KycSPUtils.Companion.getDistrict(context, stringParam);
            String state = KycSPUtils.Companion.getState(context, stringParam);
            String city = KycSPUtils.Companion.getCity(context, stringParam);
            boolean z = true;
            LinearLayout linearLayout = null;
            if (isNoApartmentNum) {
                NewPixInputView newPixInputView = this.f33331e;
                if (newPixInputView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                    newPixInputView = null;
                }
                newPixInputView.setCheckedState(isNoApartmentNum);
                NewPixInputView newPixInputView2 = this.f33331e;
                if (newPixInputView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                    newPixInputView2 = null;
                }
                newPixInputView2.getEditText().setHint("");
                NewPixInputView newPixInputView3 = this.f33331e;
                if (newPixInputView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                    newPixInputView3 = null;
                }
                newPixInputView3.getEditText().setEnabled(false);
                LinearLayout linearLayout2 = this.f33329c;
                if (linearLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mExpandInfoContainer");
                    linearLayout2 = null;
                }
                linearLayout2.setVisibility(0);
            } else {
                CharSequence charSequence = apartmentNum;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    NewPixInputView newPixInputView4 = this.f33331e;
                    if (newPixInputView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                        newPixInputView4 = null;
                    }
                    newPixInputView4.setInputStr(apartmentNum);
                    NewPixInputView newPixInputView5 = this.f33331e;
                    if (newPixInputView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                        newPixInputView5 = null;
                    }
                    newPixInputView5.hideCheckBox();
                    LinearLayout linearLayout3 = this.f33329c;
                    if (linearLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mExpandInfoContainer");
                        linearLayout3 = null;
                    }
                    linearLayout3.setVisibility(0);
                }
            }
            CharSequence charSequence2 = zipCode;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                NewPixInputView newPixInputView6 = this.f33328b;
                if (newPixInputView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mZipCodeInput");
                    newPixInputView6 = null;
                }
                newPixInputView6.setInputStr(zipCode);
                LinearLayout linearLayout4 = this.f33329c;
                if (linearLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mExpandInfoContainer");
                    linearLayout4 = null;
                }
                linearLayout4.setVisibility(0);
                KycOmega.Companion.trackEvent("fin_table2_code2_sw");
            }
            CharSequence charSequence3 = street;
            if (!(charSequence3 == null || charSequence3.length() == 0)) {
                NewPixInputView newPixInputView7 = this.f33330d;
                if (newPixInputView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStreetInput");
                    newPixInputView7 = null;
                }
                newPixInputView7.setInputStr(street);
                LinearLayout linearLayout5 = this.f33329c;
                if (linearLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mExpandInfoContainer");
                    linearLayout5 = null;
                }
                linearLayout5.setVisibility(0);
            }
            CharSequence charSequence4 = optionalInfo;
            if (!(charSequence4 == null || charSequence4.length() == 0)) {
                NewPixInputView newPixInputView8 = this.f33332f;
                if (newPixInputView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAddMoreInput");
                    newPixInputView8 = null;
                }
                newPixInputView8.setInputStr(optionalInfo);
                LinearLayout linearLayout6 = this.f33329c;
                if (linearLayout6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mExpandInfoContainer");
                    linearLayout6 = null;
                }
                linearLayout6.setVisibility(0);
            }
            CharSequence charSequence5 = district;
            if (!(charSequence5 == null || charSequence5.length() == 0)) {
                NewPixInputView newPixInputView9 = this.f33333g;
                if (newPixInputView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDistrictInput");
                    newPixInputView9 = null;
                }
                newPixInputView9.setInputStr(district);
                LinearLayout linearLayout7 = this.f33329c;
                if (linearLayout7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mExpandInfoContainer");
                    linearLayout7 = null;
                }
                linearLayout7.setVisibility(0);
            }
            CharSequence charSequence6 = state;
            if (!(charSequence6 == null || charSequence6.length() == 0)) {
                NewPixInputView newPixInputView10 = this.f33334h;
                if (newPixInputView10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
                    newPixInputView10 = null;
                }
                newPixInputView10.setInputStr(state);
                LinearLayout linearLayout8 = this.f33329c;
                if (linearLayout8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mExpandInfoContainer");
                    linearLayout8 = null;
                }
                linearLayout8.setVisibility(0);
            }
            CharSequence charSequence7 = city;
            if (!(charSequence7 == null || charSequence7.length() == 0)) {
                z = false;
            }
            if (!z) {
                NewPixInputView newPixInputView11 = this.f33335i;
                if (newPixInputView11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCityInput");
                    newPixInputView11 = null;
                }
                newPixInputView11.setInputStr(city);
                LinearLayout linearLayout9 = this.f33329c;
                if (linearLayout9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mExpandInfoContainer");
                } else {
                    linearLayout = linearLayout9;
                }
                linearLayout.setVisibility(0);
            }
            m25372d();
        }
    }

    /* renamed from: a */
    private final void m25365a(PixGetApplyInfoResp.CPFInfo cPFInfo) {
        PixGetApplyInfoResp.AddressDetail addressDetail = cPFInfo.getAddressDetail();
        if (addressDetail != null) {
            LinearLayout linearLayout = this.f33329c;
            NewPixInputView newPixInputView = null;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mExpandInfoContainer");
                linearLayout = null;
            }
            boolean z = false;
            linearLayout.setVisibility(0);
            KycOmega.Companion.trackEvent("fin_table2_code2_sw");
            NewPixInputView newPixInputView2 = this.f33328b;
            if (newPixInputView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mZipCodeInput");
                newPixInputView2 = null;
            }
            if (newPixInputView2.getInputStr().length() == 0) {
                CharSequence zipCode = addressDetail.getZipCode();
                if (!(zipCode == null || zipCode.length() == 0)) {
                    NewPixInputView newPixInputView3 = this.f33328b;
                    if (newPixInputView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mZipCodeInput");
                        newPixInputView3 = null;
                    }
                    String zipCode2 = addressDetail.getZipCode();
                    Intrinsics.checkNotNull(zipCode2);
                    newPixInputView3.setInputStr(zipCode2);
                }
            }
            NewPixInputView newPixInputView4 = this.f33331e;
            if (newPixInputView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                newPixInputView4 = null;
            }
            if (!newPixInputView4.isCheckBoxChecked()) {
                NewPixInputView newPixInputView5 = this.f33331e;
                if (newPixInputView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                    newPixInputView5 = null;
                }
                if (newPixInputView5.getInputStr().length() == 0) {
                    if (addressDetail.getNeedHideNumber()) {
                        NewPixInputView newPixInputView6 = this.f33331e;
                        if (newPixInputView6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                            newPixInputView6 = null;
                        }
                        newPixInputView6.setCheckedState(true);
                    } else if (addressDetail.getNumber() != null) {
                        NewPixInputView newPixInputView7 = this.f33331e;
                        if (newPixInputView7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                            newPixInputView7 = null;
                        }
                        String number = addressDetail.getNumber();
                        Intrinsics.checkNotNull(number);
                        newPixInputView7.setInputStr(number);
                    }
                }
            }
            NewPixInputView newPixInputView8 = this.f33330d;
            if (newPixInputView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStreetInput");
                newPixInputView8 = null;
            }
            if ((newPixInputView8.getInputStr().length() == 0) && addressDetail.getStreetName() != null) {
                NewPixInputView newPixInputView9 = this.f33330d;
                if (newPixInputView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStreetInput");
                    newPixInputView9 = null;
                }
                String streetName = addressDetail.getStreetName();
                Intrinsics.checkNotNull(streetName);
                newPixInputView9.setInputStr(streetName);
            }
            NewPixInputView newPixInputView10 = this.f33332f;
            if (newPixInputView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddMoreInput");
                newPixInputView10 = null;
            }
            if ((newPixInputView10.getInputStr().length() == 0) && addressDetail.getComplement() != null) {
                NewPixInputView newPixInputView11 = this.f33332f;
                if (newPixInputView11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAddMoreInput");
                    newPixInputView11 = null;
                }
                String complement = addressDetail.getComplement();
                Intrinsics.checkNotNull(complement);
                newPixInputView11.setInputStr(complement);
            }
            NewPixInputView newPixInputView12 = this.f33333g;
            if (newPixInputView12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDistrictInput");
                newPixInputView12 = null;
            }
            if ((newPixInputView12.getInputStr().length() == 0) && addressDetail.getNeighborhood() != null) {
                NewPixInputView newPixInputView13 = this.f33333g;
                if (newPixInputView13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDistrictInput");
                    newPixInputView13 = null;
                }
                String neighborhood = addressDetail.getNeighborhood();
                Intrinsics.checkNotNull(neighborhood);
                newPixInputView13.setInputStr(neighborhood);
            }
            NewPixInputView newPixInputView14 = this.f33334h;
            if (newPixInputView14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
                newPixInputView14 = null;
            }
            if ((newPixInputView14.getInputStr().length() == 0) && addressDetail.getState() != null) {
                NewPixInputView newPixInputView15 = this.f33334h;
                if (newPixInputView15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
                    newPixInputView15 = null;
                }
                String state = addressDetail.getState();
                Intrinsics.checkNotNull(state);
                newPixInputView15.setInputStr(state);
            }
            NewPixInputView newPixInputView16 = this.f33335i;
            if (newPixInputView16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCityInput");
                newPixInputView16 = null;
            }
            if (newPixInputView16.getInputStr().length() == 0) {
                z = true;
            }
            if (z && addressDetail.getCity() != null) {
                NewPixInputView newPixInputView17 = this.f33335i;
                if (newPixInputView17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCityInput");
                } else {
                    newPixInputView = newPixInputView17;
                }
                String city = addressDetail.getCity();
                Intrinsics.checkNotNull(city);
                newPixInputView.setInputStr(city);
            }
        }
        m25372d();
    }

    /* renamed from: b */
    private final void m25368b() {
        String stringParam = PayBaseParamUtil.getStringParam(getContext(), "phone");
        TextView textView = this.f33336j;
        NewPixInputView newPixInputView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSubmitBtn");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                StepAdditionalInfoFragment.m25359a(StepAdditionalInfoFragment.this, view);
            }
        });
        ImageView imageView = this.f33327a;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPreBtn");
            imageView = null;
        }
        ViewExtsKt.click(imageView, new StepAdditionalInfoFragment$initListener$2(this));
        NewPixInputView newPixInputView2 = this.f33328b;
        if (newPixInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mZipCodeInput");
            newPixInputView2 = null;
        }
        newPixInputView2.setEditTextClickListener($$Lambda$StepAdditionalInfoFragment$jfQcOevoKJvtxw0eHYA028e5ds.INSTANCE);
        NewPixInputView newPixInputView3 = this.f33328b;
        if (newPixInputView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mZipCodeInput");
            newPixInputView3 = null;
        }
        newPixInputView3.setAfterTextChangedListener(new StepAdditionalInfoFragment$initListener$4(this));
        NewPixInputView newPixInputView4 = this.f33331e;
        if (newPixInputView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
            newPixInputView4 = null;
        }
        newPixInputView4.setAfterTextChangedListener(new StepAdditionalInfoFragment$initListener$5(this));
        NewPixInputView newPixInputView5 = this.f33330d;
        if (newPixInputView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStreetInput");
            newPixInputView5 = null;
        }
        newPixInputView5.setAfterTextChangedListener(new StepAdditionalInfoFragment$initListener$6(this));
        NewPixInputView newPixInputView6 = this.f33332f;
        if (newPixInputView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddMoreInput");
            newPixInputView6 = null;
        }
        newPixInputView6.setAfterTextChangedListener(new StepAdditionalInfoFragment$initListener$7(this));
        NewPixInputView newPixInputView7 = this.f33333g;
        if (newPixInputView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDistrictInput");
            newPixInputView7 = null;
        }
        newPixInputView7.setAfterTextChangedListener(new StepAdditionalInfoFragment$initListener$8(this));
        NewPixInputView newPixInputView8 = this.f33334h;
        if (newPixInputView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
            newPixInputView8 = null;
        }
        newPixInputView8.setAfterTextChangedListener(new StepAdditionalInfoFragment$initListener$9(this));
        NewPixInputView newPixInputView9 = this.f33335i;
        if (newPixInputView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCityInput");
            newPixInputView9 = null;
        }
        newPixInputView9.setAfterTextChangedListener(new StepAdditionalInfoFragment$initListener$10(this));
        NewPixInputView newPixInputView10 = this.f33331e;
        if (newPixInputView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
            newPixInputView10 = null;
        }
        newPixInputView10.setOnCheckBoxCheckedChange(new CompoundButton.OnCheckedChangeListener(stringParam) {
            public final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                StepAdditionalInfoFragment.m25363a(StepAdditionalInfoFragment.this, this.f$1, compoundButton, z);
            }
        });
        NewPixInputView newPixInputView11 = this.f33328b;
        if (newPixInputView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mZipCodeInput");
            newPixInputView11 = null;
        }
        newPixInputView11.setOnLoseFocus(new StepAdditionalInfoFragment$initListener$12(this, stringParam));
        NewPixInputView newPixInputView12 = this.f33331e;
        if (newPixInputView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
            newPixInputView12 = null;
        }
        newPixInputView12.setOnLoseFocus(new StepAdditionalInfoFragment$initListener$13(this, stringParam));
        NewPixInputView newPixInputView13 = this.f33330d;
        if (newPixInputView13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStreetInput");
            newPixInputView13 = null;
        }
        newPixInputView13.setOnLoseFocus(new StepAdditionalInfoFragment$initListener$14(this, stringParam));
        NewPixInputView newPixInputView14 = this.f33332f;
        if (newPixInputView14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddMoreInput");
            newPixInputView14 = null;
        }
        newPixInputView14.setOnLoseFocus(new StepAdditionalInfoFragment$initListener$15(this, stringParam));
        NewPixInputView newPixInputView15 = this.f33333g;
        if (newPixInputView15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDistrictInput");
            newPixInputView15 = null;
        }
        newPixInputView15.setOnLoseFocus(new StepAdditionalInfoFragment$initListener$16(this, stringParam));
        NewPixInputView newPixInputView16 = this.f33334h;
        if (newPixInputView16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
            newPixInputView16 = null;
        }
        newPixInputView16.setEditTextClickListener(new View.OnClickListener(stringParam) {
            public final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                StepAdditionalInfoFragment.m25362a(StepAdditionalInfoFragment.this, this.f$1, view);
            }
        });
        NewPixInputView newPixInputView17 = this.f33335i;
        if (newPixInputView17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCityInput");
        } else {
            newPixInputView = newPixInputView17;
        }
        newPixInputView.setEditTextClickListener(new View.OnClickListener(stringParam) {
            public final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                StepAdditionalInfoFragment.m25370b(StepAdditionalInfoFragment.this, this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25359a(StepAdditionalInfoFragment stepAdditionalInfoFragment, View view) {
        String inputStr;
        Intrinsics.checkNotNullParameter(stepAdditionalInfoFragment, "this$0");
        KycOmega.Companion.trackEvent("fin_table2_code_leave_ck");
        NewPixInputView newPixInputView = stepAdditionalInfoFragment.f33331e;
        NewPixInputView newPixInputView2 = null;
        if (newPixInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
            newPixInputView = null;
        }
        if (newPixInputView.isCheckBoxChecked()) {
            inputStr = "NO_NUM";
        } else {
            NewPixInputView newPixInputView3 = stepAdditionalInfoFragment.f33331e;
            if (newPixInputView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                newPixInputView3 = null;
            }
            inputStr = newPixInputView3.getInputStr();
        }
        String str = inputStr;
        if (Intrinsics.areEqual((Object) stepAdditionalInfoFragment.f33339m, (Object) "1")) {
            FullKycExtraVM fullKycExtraVM = (FullKycExtraVM) stepAdditionalInfoFragment.getVm();
            String incomeType = ((FullKycExtraVM) stepAdditionalInfoFragment.getVm()).getIncomeType();
            NewPixInputView newPixInputView4 = stepAdditionalInfoFragment.f33328b;
            if (newPixInputView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mZipCodeInput");
                newPixInputView4 = null;
            }
            String inputStr2 = newPixInputView4.getInputStr();
            NewPixInputView newPixInputView5 = stepAdditionalInfoFragment.f33330d;
            if (newPixInputView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStreetInput");
                newPixInputView5 = null;
            }
            String inputStr3 = newPixInputView5.getInputStr();
            NewPixInputView newPixInputView6 = stepAdditionalInfoFragment.f33332f;
            if (newPixInputView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddMoreInput");
                newPixInputView6 = null;
            }
            String inputStr4 = newPixInputView6.getInputStr();
            NewPixInputView newPixInputView7 = stepAdditionalInfoFragment.f33333g;
            if (newPixInputView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDistrictInput");
                newPixInputView7 = null;
            }
            String inputStr5 = newPixInputView7.getInputStr();
            NewPixInputView newPixInputView8 = stepAdditionalInfoFragment.f33334h;
            if (newPixInputView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
                newPixInputView8 = null;
            }
            String inputStr6 = newPixInputView8.getInputStr();
            NewPixInputView newPixInputView9 = stepAdditionalInfoFragment.f33335i;
            if (newPixInputView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCityInput");
            } else {
                newPixInputView2 = newPixInputView9;
            }
            String inputStr7 = newPixInputView2.getInputStr();
            String str2 = stepAdditionalInfoFragment.f33340n;
            if (str2 == null) {
                str2 = "";
            }
            fullKycExtraVM.submitAddressVerification(incomeType, inputStr2, inputStr3, str, inputStr4, inputStr5, inputStr6, inputStr7, str2);
            return;
        }
        FullKycExtraVM fullKycExtraVM2 = (FullKycExtraVM) stepAdditionalInfoFragment.getVm();
        String incomeType2 = ((FullKycExtraVM) stepAdditionalInfoFragment.getVm()).getIncomeType();
        NewPixInputView newPixInputView10 = stepAdditionalInfoFragment.f33328b;
        if (newPixInputView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mZipCodeInput");
            newPixInputView10 = null;
        }
        String inputStr8 = newPixInputView10.getInputStr();
        NewPixInputView newPixInputView11 = stepAdditionalInfoFragment.f33330d;
        if (newPixInputView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStreetInput");
            newPixInputView11 = null;
        }
        String inputStr9 = newPixInputView11.getInputStr();
        NewPixInputView newPixInputView12 = stepAdditionalInfoFragment.f33332f;
        if (newPixInputView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddMoreInput");
            newPixInputView12 = null;
        }
        String inputStr10 = newPixInputView12.getInputStr();
        NewPixInputView newPixInputView13 = stepAdditionalInfoFragment.f33333g;
        if (newPixInputView13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDistrictInput");
            newPixInputView13 = null;
        }
        String inputStr11 = newPixInputView13.getInputStr();
        NewPixInputView newPixInputView14 = stepAdditionalInfoFragment.f33334h;
        if (newPixInputView14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
            newPixInputView14 = null;
        }
        String inputStr12 = newPixInputView14.getInputStr();
        NewPixInputView newPixInputView15 = stepAdditionalInfoFragment.f33335i;
        if (newPixInputView15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCityInput");
        } else {
            newPixInputView2 = newPixInputView15;
        }
        fullKycExtraVM2.submitKycAddressInfo(incomeType2, inputStr8, inputStr9, str, inputStr10, inputStr11, inputStr12, newPixInputView2.getInputStr());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m25369b(View view) {
        KycOmega.Companion.trackEvent("fin_table2_code_ck");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25363a(StepAdditionalInfoFragment stepAdditionalInfoFragment, String str, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(stepAdditionalInfoFragment, "this$0");
        NewPixInputView newPixInputView = null;
        if (z) {
            NewPixInputView newPixInputView2 = stepAdditionalInfoFragment.f33331e;
            if (newPixInputView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                newPixInputView2 = null;
            }
            newPixInputView2.setInputStr("");
            NewPixInputView newPixInputView3 = stepAdditionalInfoFragment.f33331e;
            if (newPixInputView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                newPixInputView3 = null;
            }
            newPixInputView3.getEditText().setHint("");
            stepAdditionalInfoFragment.m25373e();
            NewPixInputView newPixInputView4 = stepAdditionalInfoFragment.f33331e;
            if (newPixInputView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
            } else {
                newPixInputView = newPixInputView4;
            }
            newPixInputView.getEditText().setEnabled(false);
        } else {
            NewPixInputView newPixInputView5 = stepAdditionalInfoFragment.f33331e;
            if (newPixInputView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                newPixInputView5 = null;
            }
            newPixInputView5.getEditText().setEnabled(true);
            NewPixInputView newPixInputView6 = stepAdditionalInfoFragment.f33331e;
            if (newPixInputView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                newPixInputView6 = null;
            }
            newPixInputView6.getEditText().setHint(stepAdditionalInfoFragment.getString(R.string.Fintech_Payment_Optimization_e_g_FChd));
            NewPixInputView newPixInputView7 = stepAdditionalInfoFragment.f33331e;
            if (newPixInputView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
            } else {
                newPixInputView = newPixInputView7;
            }
            newPixInputView.getEditText().requestFocus();
        }
        Context context = stepAdditionalInfoFragment.getContext();
        if (context != null) {
            KycSPUtils.Companion companion = KycSPUtils.Companion;
            Intrinsics.checkNotNullExpressionValue(str, "phone");
            companion.setIsNoApartmentNum(context, str, z);
        }
        stepAdditionalInfoFragment.m25372d();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25362a(StepAdditionalInfoFragment stepAdditionalInfoFragment, String str, View view) {
        Intrinsics.checkNotNullParameter(stepAdditionalInfoFragment, "this$0");
        stepAdditionalInfoFragment.m25373e();
        ((Request) DRouter.build(f33324s).putExtra("type", "state")).start(stepAdditionalInfoFragment.getActivity(), new StepAdditionalInfoFragment$initListener$17$1(stepAdditionalInfoFragment, str));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m25370b(StepAdditionalInfoFragment stepAdditionalInfoFragment, String str, View view) {
        Intrinsics.checkNotNullParameter(stepAdditionalInfoFragment, "this$0");
        NewPixInputView newPixInputView = stepAdditionalInfoFragment.f33334h;
        NewPixInputView newPixInputView2 = null;
        if (newPixInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
            newPixInputView = null;
        }
        if (!TextUtils.isEmpty(newPixInputView.getInputStr())) {
            stepAdditionalInfoFragment.m25373e();
            Request request = (Request) DRouter.build(f33324s).putExtra("type", "city");
            NewPixInputView newPixInputView3 = stepAdditionalInfoFragment.f33334h;
            if (newPixInputView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
            } else {
                newPixInputView2 = newPixInputView3;
            }
            ((Request) request.putExtra("state", newPixInputView2.getInputStr())).start(stepAdditionalInfoFragment.getActivity(), new StepAdditionalInfoFragment$initListener$18$1(stepAdditionalInfoFragment, str));
        }
    }

    /* renamed from: a */
    private final void m25364a(AddressZipCodeResp.DataBean dataBean) {
        m25371c();
        String stringParam = PayBaseParamUtil.getStringParam(getContext(), "phone");
        NewPixInputView newPixInputView = null;
        if (dataBean.streetName != null) {
            NewPixInputView newPixInputView2 = this.f33330d;
            if (newPixInputView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStreetInput");
                newPixInputView2 = null;
            }
            String str = dataBean.streetName;
            Intrinsics.checkNotNullExpressionValue(str, "addressResp.streetName");
            newPixInputView2.setInputStr(str);
            Context context = getContext();
            if (context != null) {
                KycSPUtils.Companion companion = KycSPUtils.Companion;
                Intrinsics.checkNotNullExpressionValue(stringParam, "phone");
                String str2 = dataBean.streetName;
                Intrinsics.checkNotNullExpressionValue(str2, "addressResp.streetName");
                companion.putStreet(context, stringParam, str2);
            }
        }
        if (dataBean.number != null) {
            NewPixInputView newPixInputView3 = this.f33331e;
            if (newPixInputView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                newPixInputView3 = null;
            }
            String str3 = dataBean.number;
            Intrinsics.checkNotNullExpressionValue(str3, "addressResp.number");
            newPixInputView3.setInputStr(str3);
            Context context2 = getContext();
            if (context2 != null) {
                KycSPUtils.Companion companion2 = KycSPUtils.Companion;
                Intrinsics.checkNotNullExpressionValue(stringParam, "phone");
                String str4 = dataBean.number;
                Intrinsics.checkNotNullExpressionValue(str4, "addressResp.number");
                companion2.putApartmentNum(context2, stringParam, str4);
            }
        }
        if (dataBean.city != null) {
            NewPixInputView newPixInputView4 = this.f33335i;
            if (newPixInputView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCityInput");
                newPixInputView4 = null;
            }
            String str5 = dataBean.city;
            Intrinsics.checkNotNullExpressionValue(str5, "addressResp.city");
            newPixInputView4.setInputStr(str5);
            Context context3 = getContext();
            if (context3 != null) {
                KycSPUtils.Companion companion3 = KycSPUtils.Companion;
                Intrinsics.checkNotNullExpressionValue(stringParam, "phone");
                String str6 = dataBean.city;
                Intrinsics.checkNotNullExpressionValue(str6, "addressResp.city");
                companion3.putCity(context3, stringParam, str6);
            }
        }
        if (dataBean.complement != null) {
            NewPixInputView newPixInputView5 = this.f33332f;
            if (newPixInputView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddMoreInput");
                newPixInputView5 = null;
            }
            String str7 = dataBean.complement;
            Intrinsics.checkNotNullExpressionValue(str7, "addressResp.complement");
            newPixInputView5.setInputStr(str7);
            Context context4 = getContext();
            if (context4 != null) {
                KycSPUtils.Companion companion4 = KycSPUtils.Companion;
                Intrinsics.checkNotNullExpressionValue(stringParam, "phone");
                String str8 = dataBean.complement;
                Intrinsics.checkNotNullExpressionValue(str8, "addressResp.complement");
                companion4.putOptionalInfo(context4, stringParam, str8);
            }
        }
        if (dataBean.state != null) {
            NewPixInputView newPixInputView6 = this.f33334h;
            if (newPixInputView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
                newPixInputView6 = null;
            }
            String str9 = dataBean.state;
            Intrinsics.checkNotNullExpressionValue(str9, "addressResp.state");
            newPixInputView6.setInputStr(str9);
            Context context5 = getContext();
            if (context5 != null) {
                KycSPUtils.Companion companion5 = KycSPUtils.Companion;
                Intrinsics.checkNotNullExpressionValue(stringParam, "phone");
                String str10 = dataBean.state;
                Intrinsics.checkNotNullExpressionValue(str10, "addressResp.state");
                companion5.putState(context5, stringParam, str10);
            }
        }
        if (dataBean.neighborhood != null) {
            NewPixInputView newPixInputView7 = this.f33333g;
            if (newPixInputView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDistrictInput");
            } else {
                newPixInputView = newPixInputView7;
            }
            String str11 = dataBean.neighborhood;
            Intrinsics.checkNotNullExpressionValue(str11, "addressResp.neighborhood");
            newPixInputView.setInputStr(str11);
            Context context6 = getContext();
            if (context6 != null) {
                KycSPUtils.Companion companion6 = KycSPUtils.Companion;
                Intrinsics.checkNotNullExpressionValue(stringParam, "phone");
                String str12 = dataBean.neighborhood;
                Intrinsics.checkNotNullExpressionValue(str12, "addressResp.neighborhood");
                companion6.putDistrict(context6, stringParam, str12);
            }
        }
        m25372d();
    }

    /* renamed from: c */
    private final void m25371c() {
        NewPixInputView newPixInputView = this.f33330d;
        NewPixInputView newPixInputView2 = null;
        if (newPixInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStreetInput");
            newPixInputView = null;
        }
        newPixInputView.setInputStr("");
        NewPixInputView newPixInputView3 = this.f33333g;
        if (newPixInputView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDistrictInput");
            newPixInputView3 = null;
        }
        newPixInputView3.setInputStr("");
        NewPixInputView newPixInputView4 = this.f33334h;
        if (newPixInputView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
            newPixInputView4 = null;
        }
        newPixInputView4.setInputStr("");
        NewPixInputView newPixInputView5 = this.f33335i;
        if (newPixInputView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCityInput");
        } else {
            newPixInputView2 = newPixInputView5;
        }
        newPixInputView2.setInputStr("");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final void m25372d() {
        boolean z;
        TextView textView = this.f33336j;
        NewPixInputView newPixInputView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSubmitBtn");
            textView = null;
        }
        if (m25367a(2) && m25367a(3)) {
            NewPixInputView newPixInputView2 = this.f33333g;
            if (newPixInputView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDistrictInput");
                newPixInputView2 = null;
            }
            if (newPixInputView2.isInputNotBlank()) {
                NewPixInputView newPixInputView3 = this.f33330d;
                if (newPixInputView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStreetInput");
                    newPixInputView3 = null;
                }
                if (newPixInputView3.isInputNotBlank()) {
                    NewPixInputView newPixInputView4 = this.f33334h;
                    if (newPixInputView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
                        newPixInputView4 = null;
                    }
                    if (newPixInputView4.isInputNotBlank()) {
                        NewPixInputView newPixInputView5 = this.f33335i;
                        if (newPixInputView5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mCityInput");
                        } else {
                            newPixInputView = newPixInputView5;
                        }
                        if (newPixInputView.isInputNotBlank()) {
                            z = true;
                            textView.setEnabled(z);
                        }
                    }
                }
            }
        }
        z = false;
        textView.setEnabled(z);
    }

    /* renamed from: a */
    private final boolean m25367a(int i) {
        NewPixInputView newPixInputView = null;
        if (i == 2) {
            NewPixInputView newPixInputView2 = this.f33328b;
            if (newPixInputView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mZipCodeInput");
            } else {
                newPixInputView = newPixInputView2;
            }
            if (newPixInputView.getInputStr().length() == 8) {
                return true;
            }
            return false;
        } else if (i != 3) {
            return false;
        } else {
            NewPixInputView newPixInputView3 = this.f33331e;
            if (newPixInputView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                newPixInputView3 = null;
            }
            if (!StringsKt.isBlank(newPixInputView3.getInputStr())) {
                return true;
            }
            NewPixInputView newPixInputView4 = this.f33331e;
            if (newPixInputView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
            } else {
                newPixInputView = newPixInputView4;
            }
            return newPixInputView.isCheckBoxChecked();
        }
    }

    /* renamed from: e */
    private final void m25373e() {
        FragmentActivity activity = getActivity();
        Object obj = null;
        View currentFocus = activity == null ? null : activity.getCurrentFocus();
        if (currentFocus != null) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                obj = activity2.getSystemService("input_method");
            }
            if (obj != null) {
                ((InputMethodManager) obj).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }
}
