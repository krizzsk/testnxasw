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
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.didi.component.common.net.CarServerParam;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.base.view.PayHomelandCityErrorView;
import com.didi.payment.commonsdk.p130ui.WBaseFragment;
import com.didi.payment.commonsdk.p130ui.WBaseViewModel;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.commonsdk.utils.OmegaComParams;
import com.didi.payment.kycservice.kyc.SignUpVM;
import com.didi.payment.kycservice.kyc.p134vm.FullKycExtraVM;
import com.didi.payment.kycservice.kyc.response.GuidesInfoResp;
import com.didi.payment.kycservice.net.response.AddressZipCodeResp;
import com.didi.payment.kycservice.net.response.PixGetApplyInfoResp;
import com.didi.payment.kycservice.utils.KycSPUtils;
import com.didi.payment.kycservice.utils.ViewExtsKt;
import com.didi.payment.kycservice.widget.NewPixInputView;
import com.didi.payment.wallet_ui.dialog.WalletDialog;
import com.didi.payment.wallet_ui.wheel.OnOptionWheelClick;
import com.didi.payment.wallet_ui.wheel.OptionWheelBuilder;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 G2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001GB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020'H\u0002J\u0010\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020'H\u0002J\n\u0010-\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010.\u001a\u00020'H\u0002J\u0010\u0010/\u001a\u00020'2\u0006\u00100\u001a\u00020\u0014H\u0002J&\u00101\u001a\u0004\u0018\u00010\u00142\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u00020'H\u0016J\u001a\u00109\u001a\u00020'2\u0006\u00100\u001a\u00020\u00142\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u0010:\u001a\u00020'H\u0002J\u0010\u0010;\u001a\u00020'2\u0006\u0010<\u001a\u00020\u0002H\u0016J\u0010\u0010=\u001a\u00020'2\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010@\u001a\u00020'2\u0006\u0010A\u001a\u00020BH\u0002J\b\u0010C\u001a\u00020'H\u0002J\u0010\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020?H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, mo148868d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/FullKycExtraFragment;", "Lcom/didi/payment/commonsdk/ui/WBaseFragment;", "Lcom/didi/payment/kycservice/kyc/vm/FullKycExtraVM;", "()V", "addressType", "", "blockId", "curFragment", "Landroidx/fragment/app/Fragment;", "incomeList", "Ljava/util/LinkedList;", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$Income;", "incomeSelect", "mAddMoreInput", "Lcom/didi/payment/kycservice/widget/NewPixInputView;", "mCityInput", "mContentView", "Landroid/widget/RelativeLayout;", "mDistrictInput", "mDividerView", "Landroid/view/View;", "mExpandInfoContainer", "Landroid/widget/LinearLayout;", "mIncomeLayout", "mIncomeText", "Landroid/widget/TextView;", "mMainTitle", "mNumberInput", "mPreBtn", "Landroid/widget/ImageView;", "mStateInput", "mStreetInput", "mSubTitle", "mSubmitBtn", "mZipCodeInput", "pixSignUpVM", "Lcom/didi/payment/kycservice/kyc/SignUpVM;", "uid", "clearFormerInfo", "", "closeKeyboard", "fillInfoFromNetwork", "kycInfo", "Lcom/didi/payment/kycservice/net/response/PixGetApplyInfoResp$CPFInfo;", "fillInfoFromSp", "getTitleBarView", "initListener", "initView", "view", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "showIncomeDialogView", "subscribeUi", "vm", "trackContentCk", "type", "", "updateAddress", "addressResp", "Lcom/didi/payment/kycservice/net/response/AddressZipCodeResp$DataBean;", "updateSubmitBtn", "validInput", "", "tag", "Companion", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FullKycExtraFragment.kt */
public final class FullKycExtraFragment extends WBaseFragment<FullKycExtraVM> {

    /* renamed from: A */
    private static final String f33233A = "result";
    public static final String ADDRESS_TYPE = "typeId";

    /* renamed from: B */
    private static final String f33234B = "99OneTravel://one/wallet_address_list";
    public static final String BLOCK_ID = "blockId";

    /* renamed from: C */
    private static final int f33235C = 1;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: D */
    private static final int f33236D = 2;

    /* renamed from: E */
    private static final int f33237E = 3;

    /* renamed from: x */
    private static final String f33238x = "state";

    /* renamed from: y */
    private static final String f33239y = "city";

    /* renamed from: z */
    private static final String f33240z = "type";

    /* renamed from: a */
    private RelativeLayout f33241a;

    /* renamed from: b */
    private TextView f33242b;

    /* renamed from: c */
    private TextView f33243c;

    /* renamed from: d */
    private LinearLayout f33244d;

    /* renamed from: e */
    private TextView f33245e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public NewPixInputView f33246f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public LinearLayout f33247g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public NewPixInputView f33248h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public NewPixInputView f33249i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public NewPixInputView f33250j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public NewPixInputView f33251k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public NewPixInputView f33252l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public NewPixInputView f33253m;

    /* renamed from: n */
    private TextView f33254n;

    /* renamed from: o */
    private ImageView f33255o;

    /* renamed from: p */
    private View f33256p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public SignUpVM f33257q;

    /* renamed from: r */
    private String f33258r = "";
    /* access modifiers changed from: private */

    /* renamed from: s */
    public LinkedList<GuidesInfoResp.Income> f33259s;

    /* renamed from: t */
    private GuidesInfoResp.Income f33260t;

    /* renamed from: u */
    private String f33261u;

    /* renamed from: v */
    private String f33262v;

    /* renamed from: w */
    private Fragment f33263w;

    @Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: FullKycExtraFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KycFormStep.values().length];
            iArr[KycFormStep.STEP_INCOME.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return null;
    }

    public static final /* synthetic */ FullKycExtraVM access$getVm(FullKycExtraFragment fullKycExtraFragment) {
        return (FullKycExtraVM) fullKycExtraFragment.getVm();
    }

    @Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo148868d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/FullKycExtraFragment$Companion;", "", "()V", "ADDRESS_TYPE", "", "APARTMENT_TAG", "", "BLOCK_ID", "CITY", "INCOME_TAG", "RESULT", "ROUTER_ADDRESS_LIST", "STATE", "TYPE", "ZIPCODE_TAG", "newInstance", "Lcom/didi/payment/kycservice/kyc/fragment/FullKycExtraFragment;", "bundle", "Landroid/os/Bundle;", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: FullKycExtraFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FullKycExtraFragment newInstance(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            FullKycExtraFragment fullKycExtraFragment = new FullKycExtraFragment();
            fullKycExtraFragment.setArguments(bundle);
            return fullKycExtraFragment;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_full_kyc_extra, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        String str = null;
        this.f33261u = arguments == null ? null : arguments.getString("typeId");
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str = arguments2.getString("blockId");
        }
        this.f33262v = str;
        if (Intrinsics.areEqual((Object) this.f33261u, (Object) "1")) {
            OmegaComParams.Companion.setPubPage(OmegaComParams.ADDRESS_VERIFY);
        } else {
            OmegaComParams.Companion.setPubPage(OmegaComParams.FULL_KYC);
        }
        m25260a(view);
        m25259a();
        m25276b();
        ViewModel viewModel = new ViewModelProvider(this).get(FullKycExtraVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).…llKycExtraVM::class.java)");
        setVm((WBaseViewModel) viewModel);
        ViewModel viewModel2 = new ViewModelProvider(requireActivity()).get(SignUpVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(requir…get(SignUpVM::class.java)");
        this.f33257q = (SignUpVM) viewModel2;
        subscribeUi((FullKycExtraVM) getVm());
        String stringParam = PayBaseParamUtil.getStringParam(getContext(), "phone");
        Intrinsics.checkNotNullExpressionValue(stringParam, "getStringParam(context, PayParam.PHONE)");
        this.f33258r = stringParam;
        KycOmega.Companion.trackEvent("ibt_didipay_kyc_sw");
    }

    public void onDestroyView() {
        super.onDestroyView();
        OmegaComParams.Companion.setPUB_FROM_PAGE(Intrinsics.areEqual((Object) this.f33261u, (Object) "1") ? "" : OmegaComParams.FULL_KYC);
    }

    /* renamed from: a */
    private final void m25260a(View view) {
        View findViewById = view.findViewById(R.id.contentView);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.contentView)");
        this.f33241a = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.tv_title)");
        this.f33242b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_subTitle);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.tv_subTitle)");
        this.f33243c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.income_range);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.income_range)");
        this.f33244d = (LinearLayout) findViewById4;
        View findViewById5 = view.findViewById(R.id.income_text);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.income_text)");
        this.f33245e = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.account_zipcode);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.account_zipcode)");
        this.f33246f = (NewPixInputView) findViewById6;
        View findViewById7 = view.findViewById(R.id.account_expand_info_container);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.a…nt_expand_info_container)");
        this.f33247g = (LinearLayout) findViewById7;
        View findViewById8 = view.findViewById(R.id.account_street);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.account_street)");
        this.f33248h = (NewPixInputView) findViewById8;
        View findViewById9 = view.findViewById(R.id.account_apartment_number);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.account_apartment_number)");
        this.f33249i = (NewPixInputView) findViewById9;
        View findViewById10 = view.findViewById(R.id.account_other_info);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.account_other_info)");
        this.f33250j = (NewPixInputView) findViewById10;
        View findViewById11 = view.findViewById(R.id.account_district);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById(R.id.account_district)");
        this.f33251k = (NewPixInputView) findViewById11;
        View findViewById12 = view.findViewById(R.id.account_state);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "view.findViewById(R.id.account_state)");
        this.f33252l = (NewPixInputView) findViewById12;
        View findViewById13 = view.findViewById(R.id.account_city);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "view.findViewById(R.id.account_city)");
        this.f33253m = (NewPixInputView) findViewById13;
        View findViewById14 = view.findViewById(R.id.wallet_account_appply_submit_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "view.findViewById(R.id.w…ccount_appply_submit_btn)");
        this.f33254n = (TextView) findViewById14;
        View findViewById15 = view.findViewById(R.id.btn_pre_page);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "view.findViewById(R.id.btn_pre_page)");
        this.f33255o = (ImageView) findViewById15;
        View findViewById16 = view.findViewById(R.id.divider_view);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "view.findViewById(R.id.divider_view)");
        this.f33256p = findViewById16;
        TextView textView = this.f33254n;
        NewPixInputView newPixInputView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSubmitBtn");
            textView = null;
        }
        textView.setText(getString(Intrinsics.areEqual((Object) this.f33261u, (Object) "1") ? R.string.Fintech_Payment_Optimization_Submission_hMgW : R.string.Fintech_Payment_Optimization_Next_step_SRDJ));
        NewPixInputView newPixInputView2 = this.f33246f;
        if (newPixInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mZipCodeInput");
            newPixInputView2 = null;
        }
        String string = getString(R.string.Fintech_Payment_improvment_HfBc_MukB);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.Finte…ent_improvment_HfBc_MukB)");
        newPixInputView2.initData(string, 8, 2, "00000000");
        NewPixInputView newPixInputView3 = this.f33248h;
        if (newPixInputView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStreetInput");
            newPixInputView3 = null;
        }
        String string2 = getString(R.string.kyc_extra_addr_street);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.kyc_extra_addr_street)");
        newPixInputView3.initData(string2, 100, 1);
        NewPixInputView newPixInputView4 = this.f33249i;
        if (newPixInputView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
            newPixInputView4 = null;
        }
        String string3 = getString(R.string.kyc_extra_addr_number);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.kyc_extra_addr_number)");
        String string4 = getString(R.string.Fintech_Payment_Optimization_e_g_FChd);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.Finte…nt_Optimization_e_g_FChd)");
        newPixInputView4.initData(string3, 20, 2, string4);
        NewPixInputView newPixInputView5 = this.f33249i;
        if (newPixInputView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
            newPixInputView5 = null;
        }
        String string5 = getString(R.string.Fintech_Payment_Optimization_No_house_CmWq);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(R.string.Finte…timization_No_house_CmWq)");
        newPixInputView5.setCheckBoxTitle(string5);
        NewPixInputView newPixInputView6 = this.f33250j;
        if (newPixInputView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddMoreInput");
            newPixInputView6 = null;
        }
        String string6 = getString(R.string.kyc_extra_addr_complement);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(R.string.kyc_extra_addr_complement)");
        String string7 = getString(R.string.Fintech_Payment_Optimization_Apartments_blocks_qnaq);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(R.string.Finte…n_Apartments_blocks_qnaq)");
        newPixInputView6.initData(string6, 30, 1, string7);
        NewPixInputView newPixInputView7 = this.f33251k;
        if (newPixInputView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDistrictInput");
            newPixInputView7 = null;
        }
        String string8 = getString(R.string.kyc_extra_addr_district);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(R.string.kyc_extra_addr_district)");
        newPixInputView7.initData(string8, 30, 1);
        NewPixInputView newPixInputView8 = this.f33252l;
        if (newPixInputView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
            newPixInputView8 = null;
        }
        String string9 = getString(R.string.kyc_extra_addr_state);
        Intrinsics.checkNotNullExpressionValue(string9, "getString(R.string.kyc_extra_addr_state)");
        newPixInputView8.initData(string9, 200, 1);
        NewPixInputView newPixInputView9 = this.f33253m;
        if (newPixInputView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCityInput");
        } else {
            newPixInputView = newPixInputView9;
        }
        String string10 = getString(R.string.kyc_extra_addr_city);
        Intrinsics.checkNotNullExpressionValue(string10, "getString(R.string.kyc_extra_addr_city)");
        newPixInputView.initData(string10, 200, 1);
        m25283e();
    }

    public void subscribeUi(FullKycExtraVM fullKycExtraVM) {
        Intrinsics.checkNotNullParameter(fullKycExtraVM, "vm");
        fullKycExtraVM.getAddressInfo().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                FullKycExtraFragment.m25264a(FullKycExtraFragment.this, (AddressZipCodeResp.DataBean) obj);
            }
        });
        fullKycExtraVM.getBShowHomelandCityErrorPage().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                FullKycExtraFragment.m25266a(FullKycExtraFragment.this, (Boolean) obj);
            }
        });
        fullKycExtraVM.getCpfinfo().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                FullKycExtraFragment.m25265a(FullKycExtraFragment.this, (PixGetApplyInfoResp.CPFInfo) obj);
            }
        });
        fullKycExtraVM.isLoading().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                FullKycExtraFragment.m25279b(FullKycExtraFragment.this, (Boolean) obj);
            }
        });
        fullKycExtraVM.getBFinishCreateAccount().observe(getViewLifecycleOwner(), new Observer(fullKycExtraVM) {
            public final /* synthetic */ FullKycExtraVM f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                FullKycExtraFragment.m25263a(FullKycExtraFragment.this, this.f$1, (Boolean) obj);
            }
        });
        fullKycExtraVM.getErrorMsg().observe(getViewLifecycleOwner(), $$Lambda$FullKycExtraFragment$zILE455eOoefbToAxdPrOvih7PE.INSTANCE);
        NewPixInputView newPixInputView = this.f33248h;
        View view = null;
        if (newPixInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStreetInput");
            newPixInputView = null;
        }
        SignUpVM signUpVM = this.f33257q;
        if (signUpVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM = null;
        }
        newPixInputView.setEditViewEnabled(!signUpVM.isNewStep());
        NewPixInputView newPixInputView2 = this.f33253m;
        if (newPixInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCityInput");
            newPixInputView2 = null;
        }
        SignUpVM signUpVM2 = this.f33257q;
        if (signUpVM2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM2 = null;
        }
        newPixInputView2.setEditViewEnabled(!signUpVM2.isNewStep());
        NewPixInputView newPixInputView3 = this.f33252l;
        if (newPixInputView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
            newPixInputView3 = null;
        }
        SignUpVM signUpVM3 = this.f33257q;
        if (signUpVM3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM3 = null;
        }
        newPixInputView3.setEditViewEnabled(!signUpVM3.isNewStep());
        SignUpVM signUpVM4 = this.f33257q;
        if (signUpVM4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM4 = null;
        }
        if (signUpVM4.isNewStep() && !Intrinsics.areEqual((Object) this.f33261u, (Object) "1")) {
            SignUpVM signUpVM5 = this.f33257q;
            if (signUpVM5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                signUpVM5 = null;
            }
            if (signUpVM5.getCanBackStack()) {
                ImageView imageView = this.f33255o;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPreBtn");
                    imageView = null;
                }
                imageView.setVisibility(0);
                View view2 = this.f33256p;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDividerView");
                } else {
                    view = view2;
                }
                view.setVisibility(8);
                fullKycExtraVM.getNextStepData().observe(getViewLifecycleOwner(), new Observer() {
                    public final void onChanged(Object obj) {
                        FullKycExtraFragment.m25262a(FullKycExtraFragment.this, (KycFormStep) obj);
                    }
                });
                fullKycExtraVM.getPreStepData().observe(getViewLifecycleOwner(), new Observer() {
                    public final void onChanged(Object obj) {
                        FullKycExtraFragment.m25267a(FullKycExtraFragment.this, (Integer) obj);
                    }
                });
            }
        }
        ImageView imageView2 = this.f33255o;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPreBtn");
            imageView2 = null;
        }
        imageView2.setVisibility(8);
        View view3 = this.f33256p;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDividerView");
        } else {
            view = view3;
        }
        view.setVisibility(0);
        fullKycExtraVM.getNextStepData().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                FullKycExtraFragment.m25262a(FullKycExtraFragment.this, (KycFormStep) obj);
            }
        });
        fullKycExtraVM.getPreStepData().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                FullKycExtraFragment.m25267a(FullKycExtraFragment.this, (Integer) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25264a(FullKycExtraFragment fullKycExtraFragment, AddressZipCodeResp.DataBean dataBean) {
        Intrinsics.checkNotNullParameter(fullKycExtraFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(dataBean, "it");
        fullKycExtraFragment.m25270a(dataBean);
        NewPixInputView newPixInputView = fullKycExtraFragment.f33246f;
        if (newPixInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mZipCodeInput");
            newPixInputView = null;
        }
        newPixInputView.hideErrorInfo();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25266a(FullKycExtraFragment fullKycExtraFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(fullKycExtraFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "isShow");
        if (bool.booleanValue()) {
            RelativeLayout relativeLayout = fullKycExtraFragment.f33241a;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentView");
                relativeLayout = null;
            }
            PayHomelandCityErrorView.show(relativeLayout);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25265a(FullKycExtraFragment fullKycExtraFragment, PixGetApplyInfoResp.CPFInfo cPFInfo) {
        Intrinsics.checkNotNullParameter(fullKycExtraFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(cPFInfo, "it");
        fullKycExtraFragment.m25271a(cPFInfo);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m25279b(FullKycExtraFragment fullKycExtraFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(fullKycExtraFragment, "this$0");
        SignUpVM signUpVM = fullKycExtraFragment.f33257q;
        if (signUpVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM = null;
        }
        signUpVM.isLoading().setValue(bool);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25263a(FullKycExtraFragment fullKycExtraFragment, FullKycExtraVM fullKycExtraVM, Boolean bool) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(fullKycExtraFragment, "this$0");
        Intrinsics.checkNotNullParameter(fullKycExtraVM, "$vm");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        RelativeLayout relativeLayout = null;
        if (bool.booleanValue()) {
            SignUpVM signUpVM = fullKycExtraFragment.f33257q;
            if (signUpVM == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                signUpVM = null;
            }
            if (signUpVM.updatePageSceneByStepList() && (activity = fullKycExtraFragment.getActivity()) != null) {
                activity.finish();
            }
        }
        SignUpVM signUpVM2 = fullKycExtraFragment.f33257q;
        if (signUpVM2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM2 = null;
        }
        if (signUpVM2.isNewStep() && fullKycExtraVM.isInfoComplete()) {
            if (fullKycExtraFragment.getChildFragmentManager().getBackStackEntryCount() > 0) {
                fullKycExtraFragment.getChildFragmentManager().popBackStackImmediate((String) null, 1);
            }
            RelativeLayout relativeLayout2 = fullKycExtraFragment.f33241a;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            } else {
                relativeLayout = relativeLayout2;
            }
            relativeLayout.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25272a(String str) {
        Map linkedHashMap = new LinkedHashMap();
        if (str == null) {
            str = "";
        }
        linkedHashMap.put("error_message", str);
        KycOmega.Companion.trackEvent("fin_fullkycinformation_toast_sw", linkedHashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25262a(FullKycExtraFragment fullKycExtraFragment, KycFormStep kycFormStep) {
        Fragment fragment;
        Intrinsics.checkNotNullParameter(fullKycExtraFragment, "this$0");
        if ((kycFormStep == null ? -1 : WhenMappings.$EnumSwitchMapping$0[kycFormStep.ordinal()]) == 1) {
            ArrayList arrayList = new ArrayList();
            LinkedList<GuidesInfoResp.Income> linkedList = fullKycExtraFragment.f33259s;
            if (linkedList == null) {
                SignUpVM signUpVM = fullKycExtraFragment.f33257q;
                if (signUpVM == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                    signUpVM = null;
                }
                linkedList = signUpVM.getIncomeDetailList();
            }
            fullKycExtraFragment.f33259s = linkedList;
            if (linkedList != null) {
                for (GuidesInfoResp.Income add : linkedList) {
                    arrayList.add(add);
                }
            }
            fragment = StepIncomeInfoFragment.Companion.newInstance(arrayList);
        } else {
            Bundle arguments = fullKycExtraFragment.getArguments();
            if (arguments == null) {
                arguments = new Bundle();
            }
            fragment = StepAdditionalInfoFragment.Companion.newInstance(arguments);
        }
        fullKycExtraFragment.f33263w = fragment;
        if (fragment != null) {
            String str = fragment.getClass().getSimpleName() + '_' + kycFormStep;
            fullKycExtraFragment.getChildFragmentManager().beginTransaction().replace(R.id.fragment_container_view, fragment, str).addToBackStack(str).commitAllowingStateLoss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25267a(FullKycExtraFragment fullKycExtraFragment, Integer num) {
        Intrinsics.checkNotNullParameter(fullKycExtraFragment, "this$0");
        if (fullKycExtraFragment.getChildFragmentManager().getBackStackEntryCount() > 0) {
            fullKycExtraFragment.getChildFragmentManager().popBackStack();
        }
        fullKycExtraFragment.m25259a();
    }

    /* renamed from: a */
    private final void m25259a() {
        Context context = getContext();
        if (context != null) {
            String stringParam = PayBaseParamUtil.getStringParam(context, "phone");
            GuidesInfoResp.Income income = KycSPUtils.Companion.getIncome(context);
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
            LinearLayout linearLayout = null;
            if (income != null) {
                this.f33260t = income;
                TextView textView = this.f33245e;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIncomeText");
                    textView = null;
                }
                textView.setText(income.getDisplay());
            }
            boolean z = true;
            if (isNoApartmentNum) {
                NewPixInputView newPixInputView = this.f33249i;
                if (newPixInputView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                    newPixInputView = null;
                }
                newPixInputView.setCheckedState(isNoApartmentNum);
                NewPixInputView newPixInputView2 = this.f33249i;
                if (newPixInputView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                    newPixInputView2 = null;
                }
                newPixInputView2.getEditText().setHint("");
                NewPixInputView newPixInputView3 = this.f33249i;
                if (newPixInputView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                    newPixInputView3 = null;
                }
                newPixInputView3.getEditText().setEnabled(false);
                LinearLayout linearLayout2 = this.f33247g;
                if (linearLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mExpandInfoContainer");
                    linearLayout2 = null;
                }
                linearLayout2.setVisibility(0);
            } else {
                CharSequence charSequence = apartmentNum;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    NewPixInputView newPixInputView4 = this.f33249i;
                    if (newPixInputView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                        newPixInputView4 = null;
                    }
                    newPixInputView4.setInputStr(apartmentNum);
                    NewPixInputView newPixInputView5 = this.f33249i;
                    if (newPixInputView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                        newPixInputView5 = null;
                    }
                    newPixInputView5.hideCheckBox();
                    LinearLayout linearLayout3 = this.f33247g;
                    if (linearLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mExpandInfoContainer");
                        linearLayout3 = null;
                    }
                    linearLayout3.setVisibility(0);
                }
            }
            CharSequence charSequence2 = zipCode;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                NewPixInputView newPixInputView6 = this.f33246f;
                if (newPixInputView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mZipCodeInput");
                    newPixInputView6 = null;
                }
                newPixInputView6.setInputStr(zipCode);
                LinearLayout linearLayout4 = this.f33247g;
                if (linearLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mExpandInfoContainer");
                    linearLayout4 = null;
                }
                linearLayout4.setVisibility(0);
            }
            CharSequence charSequence3 = street;
            if (!(charSequence3 == null || charSequence3.length() == 0)) {
                NewPixInputView newPixInputView7 = this.f33248h;
                if (newPixInputView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStreetInput");
                    newPixInputView7 = null;
                }
                newPixInputView7.setInputStr(street);
                LinearLayout linearLayout5 = this.f33247g;
                if (linearLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mExpandInfoContainer");
                    linearLayout5 = null;
                }
                linearLayout5.setVisibility(0);
            }
            CharSequence charSequence4 = optionalInfo;
            if (!(charSequence4 == null || charSequence4.length() == 0)) {
                NewPixInputView newPixInputView8 = this.f33250j;
                if (newPixInputView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAddMoreInput");
                    newPixInputView8 = null;
                }
                newPixInputView8.setInputStr(optionalInfo);
                LinearLayout linearLayout6 = this.f33247g;
                if (linearLayout6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mExpandInfoContainer");
                    linearLayout6 = null;
                }
                linearLayout6.setVisibility(0);
            }
            CharSequence charSequence5 = district;
            if (!(charSequence5 == null || charSequence5.length() == 0)) {
                NewPixInputView newPixInputView9 = this.f33251k;
                if (newPixInputView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDistrictInput");
                    newPixInputView9 = null;
                }
                newPixInputView9.setInputStr(district);
                LinearLayout linearLayout7 = this.f33247g;
                if (linearLayout7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mExpandInfoContainer");
                    linearLayout7 = null;
                }
                linearLayout7.setVisibility(0);
            }
            CharSequence charSequence6 = state;
            if (!(charSequence6 == null || charSequence6.length() == 0)) {
                NewPixInputView newPixInputView10 = this.f33252l;
                if (newPixInputView10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
                    newPixInputView10 = null;
                }
                newPixInputView10.setInputStr(state);
                LinearLayout linearLayout8 = this.f33247g;
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
                NewPixInputView newPixInputView11 = this.f33253m;
                if (newPixInputView11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCityInput");
                    newPixInputView11 = null;
                }
                newPixInputView11.setInputStr(city);
                LinearLayout linearLayout9 = this.f33247g;
                if (linearLayout9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mExpandInfoContainer");
                } else {
                    linearLayout = linearLayout9;
                }
                linearLayout.setVisibility(0);
            }
            m25283e();
        }
    }

    /* renamed from: a */
    private final void m25271a(PixGetApplyInfoResp.CPFInfo cPFInfo) {
        SignUpVM signUpVM = this.f33257q;
        NewPixInputView newPixInputView = null;
        if (signUpVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM = null;
        }
        boolean z = false;
        if (!signUpVM.isNewStep() || Intrinsics.areEqual((Object) this.f33261u, (Object) "1") || !((FullKycExtraVM) getVm()).isInfoComplete()) {
            RelativeLayout relativeLayout = this.f33241a;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentView");
                relativeLayout = null;
            }
            relativeLayout.setVisibility(0);
            SignUpVM signUpVM2 = this.f33257q;
            if (signUpVM2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                signUpVM2 = null;
            }
            signUpVM2.updateStepProgress(KycFormStep.STEP_ADDRESS);
        } else {
            RelativeLayout relativeLayout2 = this.f33241a;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentView");
                relativeLayout2 = null;
            }
            relativeLayout2.setVisibility(8);
            ((FullKycExtraVM) getVm()).onNextClick(KycFormStep.STEP_INCOME);
        }
        LinkedList<GuidesInfoResp.Income> incomeList = cPFInfo.getIncomeList();
        if (incomeList != null) {
            this.f33259s = incomeList;
        }
        TextView textView = this.f33245e;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIncomeText");
            textView = null;
        }
        CharSequence text = textView.getText();
        Intrinsics.checkNotNullExpressionValue(text, "mIncomeText.text");
        if (text.length() == 0) {
            if (cPFInfo.getIncomeType().length() > 0) {
                SignUpVM signUpVM3 = this.f33257q;
                if (signUpVM3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                    signUpVM3 = null;
                }
                LinkedList<GuidesInfoResp.Income> incomeDetailList = signUpVM3.getIncomeDetailList();
                Intrinsics.checkNotNull(incomeDetailList);
                Iterator it = incomeDetailList.iterator();
                while (it.hasNext()) {
                    GuidesInfoResp.Income income = (GuidesInfoResp.Income) it.next();
                    if (Intrinsics.areEqual((Object) income.getType(), (Object) cPFInfo.getIncomeType())) {
                        this.f33260t = income;
                        TextView textView2 = this.f33245e;
                        if (textView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mIncomeText");
                            textView2 = null;
                        }
                        textView2.setText(income.getDisplay());
                    }
                }
            }
        }
        PixGetApplyInfoResp.AddressDetail addressDetail = cPFInfo.getAddressDetail();
        if (addressDetail != null) {
            LinearLayout linearLayout = this.f33247g;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mExpandInfoContainer");
                linearLayout = null;
            }
            linearLayout.setVisibility(0);
            NewPixInputView newPixInputView2 = this.f33246f;
            if (newPixInputView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mZipCodeInput");
                newPixInputView2 = null;
            }
            if (newPixInputView2.getInputStr().length() == 0) {
                CharSequence zipCode = addressDetail.getZipCode();
                if (!(zipCode == null || zipCode.length() == 0)) {
                    NewPixInputView newPixInputView3 = this.f33246f;
                    if (newPixInputView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mZipCodeInput");
                        newPixInputView3 = null;
                    }
                    String zipCode2 = addressDetail.getZipCode();
                    Intrinsics.checkNotNull(zipCode2);
                    newPixInputView3.setInputStr(zipCode2);
                }
            }
            NewPixInputView newPixInputView4 = this.f33249i;
            if (newPixInputView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                newPixInputView4 = null;
            }
            if (!newPixInputView4.isCheckBoxChecked()) {
                NewPixInputView newPixInputView5 = this.f33249i;
                if (newPixInputView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                    newPixInputView5 = null;
                }
                if (newPixInputView5.getInputStr().length() == 0) {
                    if (addressDetail.getNeedHideNumber()) {
                        NewPixInputView newPixInputView6 = this.f33249i;
                        if (newPixInputView6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                            newPixInputView6 = null;
                        }
                        newPixInputView6.setCheckedState(true);
                    } else if (addressDetail.getNumber() != null) {
                        NewPixInputView newPixInputView7 = this.f33249i;
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
            NewPixInputView newPixInputView8 = this.f33248h;
            if (newPixInputView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStreetInput");
                newPixInputView8 = null;
            }
            if ((newPixInputView8.getInputStr().length() == 0) && addressDetail.getStreetName() != null) {
                NewPixInputView newPixInputView9 = this.f33248h;
                if (newPixInputView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStreetInput");
                    newPixInputView9 = null;
                }
                String streetName = addressDetail.getStreetName();
                Intrinsics.checkNotNull(streetName);
                newPixInputView9.setInputStr(streetName);
            }
            NewPixInputView newPixInputView10 = this.f33250j;
            if (newPixInputView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddMoreInput");
                newPixInputView10 = null;
            }
            if ((newPixInputView10.getInputStr().length() == 0) && addressDetail.getComplement() != null) {
                NewPixInputView newPixInputView11 = this.f33250j;
                if (newPixInputView11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAddMoreInput");
                    newPixInputView11 = null;
                }
                String complement = addressDetail.getComplement();
                Intrinsics.checkNotNull(complement);
                newPixInputView11.setInputStr(complement);
            }
            NewPixInputView newPixInputView12 = this.f33251k;
            if (newPixInputView12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDistrictInput");
                newPixInputView12 = null;
            }
            if ((newPixInputView12.getInputStr().length() == 0) && addressDetail.getNeighborhood() != null) {
                NewPixInputView newPixInputView13 = this.f33251k;
                if (newPixInputView13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDistrictInput");
                    newPixInputView13 = null;
                }
                String neighborhood = addressDetail.getNeighborhood();
                Intrinsics.checkNotNull(neighborhood);
                newPixInputView13.setInputStr(neighborhood);
            }
            NewPixInputView newPixInputView14 = this.f33252l;
            if (newPixInputView14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
                newPixInputView14 = null;
            }
            if ((newPixInputView14.getInputStr().length() == 0) && addressDetail.getState() != null) {
                NewPixInputView newPixInputView15 = this.f33252l;
                if (newPixInputView15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
                    newPixInputView15 = null;
                }
                String state = addressDetail.getState();
                Intrinsics.checkNotNull(state);
                newPixInputView15.setInputStr(state);
            }
            NewPixInputView newPixInputView16 = this.f33253m;
            if (newPixInputView16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCityInput");
                newPixInputView16 = null;
            }
            if (newPixInputView16.getInputStr().length() == 0) {
                z = true;
            }
            if (z && addressDetail.getCity() != null) {
                NewPixInputView newPixInputView17 = this.f33253m;
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
        m25283e();
    }

    /* renamed from: b */
    private final void m25276b() {
        String stringParam = PayBaseParamUtil.getStringParam(getContext(), "phone");
        TextView textView = this.f33254n;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSubmitBtn");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FullKycExtraFragment.m25261a(FullKycExtraFragment.this, view);
            }
        });
        LinearLayout linearLayout = this.f33244d;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIncomeLayout");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(new FullKycExtraFragment$initListener$2(this));
        NewPixInputView newPixInputView = this.f33246f;
        if (newPixInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mZipCodeInput");
            newPixInputView = null;
        }
        newPixInputView.setEditTextClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FullKycExtraFragment.m25278b(FullKycExtraFragment.this, view);
            }
        });
        NewPixInputView newPixInputView2 = this.f33246f;
        if (newPixInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mZipCodeInput");
            newPixInputView2 = null;
        }
        newPixInputView2.setAfterTextChangedListener(new FullKycExtraFragment$initListener$4(this));
        NewPixInputView newPixInputView3 = this.f33249i;
        if (newPixInputView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
            newPixInputView3 = null;
        }
        newPixInputView3.setAfterTextChangedListener(new FullKycExtraFragment$initListener$5(this));
        NewPixInputView newPixInputView4 = this.f33248h;
        if (newPixInputView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStreetInput");
            newPixInputView4 = null;
        }
        newPixInputView4.setAfterTextChangedListener(new FullKycExtraFragment$initListener$6(this));
        NewPixInputView newPixInputView5 = this.f33250j;
        if (newPixInputView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddMoreInput");
            newPixInputView5 = null;
        }
        newPixInputView5.setAfterTextChangedListener(new FullKycExtraFragment$initListener$7(this));
        NewPixInputView newPixInputView6 = this.f33251k;
        if (newPixInputView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDistrictInput");
            newPixInputView6 = null;
        }
        newPixInputView6.setAfterTextChangedListener(new FullKycExtraFragment$initListener$8(this));
        NewPixInputView newPixInputView7 = this.f33252l;
        if (newPixInputView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
            newPixInputView7 = null;
        }
        newPixInputView7.setAfterTextChangedListener(new FullKycExtraFragment$initListener$9(this));
        NewPixInputView newPixInputView8 = this.f33253m;
        if (newPixInputView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCityInput");
            newPixInputView8 = null;
        }
        newPixInputView8.setAfterTextChangedListener(new FullKycExtraFragment$initListener$10(this));
        NewPixInputView newPixInputView9 = this.f33249i;
        if (newPixInputView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
            newPixInputView9 = null;
        }
        newPixInputView9.setOnCheckBoxCheckedChange(new CompoundButton.OnCheckedChangeListener(stringParam) {
            public final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                FullKycExtraFragment.m25269a(FullKycExtraFragment.this, this.f$1, compoundButton, z);
            }
        });
        NewPixInputView newPixInputView10 = this.f33246f;
        if (newPixInputView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mZipCodeInput");
            newPixInputView10 = null;
        }
        newPixInputView10.setOnLoseFocus(new FullKycExtraFragment$initListener$12(this, stringParam));
        NewPixInputView newPixInputView11 = this.f33249i;
        if (newPixInputView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
            newPixInputView11 = null;
        }
        newPixInputView11.setOnLoseFocus(new FullKycExtraFragment$initListener$13(this, stringParam));
        NewPixInputView newPixInputView12 = this.f33248h;
        if (newPixInputView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStreetInput");
            newPixInputView12 = null;
        }
        newPixInputView12.setOnLoseFocus(new FullKycExtraFragment$initListener$14(this, stringParam));
        NewPixInputView newPixInputView13 = this.f33250j;
        if (newPixInputView13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddMoreInput");
            newPixInputView13 = null;
        }
        newPixInputView13.setOnLoseFocus(new FullKycExtraFragment$initListener$15(this, stringParam));
        NewPixInputView newPixInputView14 = this.f33251k;
        if (newPixInputView14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDistrictInput");
            newPixInputView14 = null;
        }
        newPixInputView14.setOnLoseFocus(new FullKycExtraFragment$initListener$16(this, stringParam));
        NewPixInputView newPixInputView15 = this.f33252l;
        if (newPixInputView15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
            newPixInputView15 = null;
        }
        newPixInputView15.setEditTextClickListener(new View.OnClickListener(stringParam) {
            public final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                FullKycExtraFragment.m25268a(FullKycExtraFragment.this, this.f$1, view);
            }
        });
        NewPixInputView newPixInputView16 = this.f33253m;
        if (newPixInputView16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCityInput");
            newPixInputView16 = null;
        }
        newPixInputView16.setEditTextClickListener(new View.OnClickListener(stringParam) {
            public final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                FullKycExtraFragment.m25280b(FullKycExtraFragment.this, this.f$1, view);
            }
        });
        ImageView imageView2 = this.f33255o;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPreBtn");
        } else {
            imageView = imageView2;
        }
        ViewExtsKt.click(imageView, new FullKycExtraFragment$initListener$19(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25261a(FullKycExtraFragment fullKycExtraFragment, View view) {
        String inputStr;
        String type;
        Intrinsics.checkNotNullParameter(fullKycExtraFragment, "this$0");
        fullKycExtraFragment.m25277b(3);
        KycOmega.Companion.trackEvent("ibt_didipay_kyc_ck");
        NewPixInputView newPixInputView = fullKycExtraFragment.f33249i;
        NewPixInputView newPixInputView2 = null;
        if (newPixInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
            newPixInputView = null;
        }
        if (newPixInputView.isCheckBoxChecked()) {
            inputStr = "NO_NUM";
        } else {
            NewPixInputView newPixInputView3 = fullKycExtraFragment.f33249i;
            if (newPixInputView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                newPixInputView3 = null;
            }
            inputStr = newPixInputView3.getInputStr();
        }
        String str = inputStr;
        GuidesInfoResp.Income income = fullKycExtraFragment.f33260t;
        if (income != null && (type = income.getType()) != null) {
            if (Intrinsics.areEqual((Object) fullKycExtraFragment.f33261u, (Object) "1")) {
                FullKycExtraVM fullKycExtraVM = (FullKycExtraVM) fullKycExtraFragment.getVm();
                NewPixInputView newPixInputView4 = fullKycExtraFragment.f33246f;
                if (newPixInputView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mZipCodeInput");
                    newPixInputView4 = null;
                }
                String inputStr2 = newPixInputView4.getInputStr();
                NewPixInputView newPixInputView5 = fullKycExtraFragment.f33248h;
                if (newPixInputView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStreetInput");
                    newPixInputView5 = null;
                }
                String inputStr3 = newPixInputView5.getInputStr();
                NewPixInputView newPixInputView6 = fullKycExtraFragment.f33250j;
                if (newPixInputView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAddMoreInput");
                    newPixInputView6 = null;
                }
                String inputStr4 = newPixInputView6.getInputStr();
                NewPixInputView newPixInputView7 = fullKycExtraFragment.f33251k;
                if (newPixInputView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDistrictInput");
                    newPixInputView7 = null;
                }
                String inputStr5 = newPixInputView7.getInputStr();
                NewPixInputView newPixInputView8 = fullKycExtraFragment.f33252l;
                if (newPixInputView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
                    newPixInputView8 = null;
                }
                String inputStr6 = newPixInputView8.getInputStr();
                NewPixInputView newPixInputView9 = fullKycExtraFragment.f33253m;
                if (newPixInputView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCityInput");
                } else {
                    newPixInputView2 = newPixInputView9;
                }
                String inputStr7 = newPixInputView2.getInputStr();
                String str2 = fullKycExtraFragment.f33262v;
                if (str2 == null) {
                    str2 = "";
                }
                fullKycExtraVM.submitAddressVerification(type, inputStr2, inputStr3, str, inputStr4, inputStr5, inputStr6, inputStr7, str2);
                return;
            }
            FullKycExtraVM fullKycExtraVM2 = (FullKycExtraVM) fullKycExtraFragment.getVm();
            NewPixInputView newPixInputView10 = fullKycExtraFragment.f33246f;
            if (newPixInputView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mZipCodeInput");
                newPixInputView10 = null;
            }
            String inputStr8 = newPixInputView10.getInputStr();
            NewPixInputView newPixInputView11 = fullKycExtraFragment.f33248h;
            if (newPixInputView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStreetInput");
                newPixInputView11 = null;
            }
            String inputStr9 = newPixInputView11.getInputStr();
            NewPixInputView newPixInputView12 = fullKycExtraFragment.f33250j;
            if (newPixInputView12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddMoreInput");
                newPixInputView12 = null;
            }
            String inputStr10 = newPixInputView12.getInputStr();
            NewPixInputView newPixInputView13 = fullKycExtraFragment.f33251k;
            if (newPixInputView13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDistrictInput");
                newPixInputView13 = null;
            }
            String inputStr11 = newPixInputView13.getInputStr();
            NewPixInputView newPixInputView14 = fullKycExtraFragment.f33252l;
            if (newPixInputView14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
                newPixInputView14 = null;
            }
            String inputStr12 = newPixInputView14.getInputStr();
            NewPixInputView newPixInputView15 = fullKycExtraFragment.f33253m;
            if (newPixInputView15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCityInput");
            } else {
                newPixInputView2 = newPixInputView15;
            }
            fullKycExtraVM2.submitKycAddressInfo(type, inputStr8, inputStr9, str, inputStr10, inputStr11, inputStr12, newPixInputView2.getInputStr());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m25278b(FullKycExtraFragment fullKycExtraFragment, View view) {
        Intrinsics.checkNotNullParameter(fullKycExtraFragment, "this$0");
        fullKycExtraFragment.m25277b(2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25269a(FullKycExtraFragment fullKycExtraFragment, String str, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(fullKycExtraFragment, "this$0");
        NewPixInputView newPixInputView = null;
        if (z) {
            NewPixInputView newPixInputView2 = fullKycExtraFragment.f33249i;
            if (newPixInputView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                newPixInputView2 = null;
            }
            newPixInputView2.setInputStr("");
            NewPixInputView newPixInputView3 = fullKycExtraFragment.f33249i;
            if (newPixInputView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                newPixInputView3 = null;
            }
            newPixInputView3.getEditText().setHint("");
            fullKycExtraFragment.m25284f();
            NewPixInputView newPixInputView4 = fullKycExtraFragment.f33249i;
            if (newPixInputView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
            } else {
                newPixInputView = newPixInputView4;
            }
            newPixInputView.getEditText().setEnabled(false);
        } else {
            NewPixInputView newPixInputView5 = fullKycExtraFragment.f33249i;
            if (newPixInputView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                newPixInputView5 = null;
            }
            newPixInputView5.getEditText().setEnabled(true);
            NewPixInputView newPixInputView6 = fullKycExtraFragment.f33249i;
            if (newPixInputView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                newPixInputView6 = null;
            }
            newPixInputView6.getEditText().setHint(fullKycExtraFragment.getString(R.string.Fintech_Payment_Optimization_e_g_FChd));
            NewPixInputView newPixInputView7 = fullKycExtraFragment.f33249i;
            if (newPixInputView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
            } else {
                newPixInputView = newPixInputView7;
            }
            newPixInputView.getEditText().requestFocus();
        }
        Context context = fullKycExtraFragment.getContext();
        if (context != null) {
            KycSPUtils.Companion companion = KycSPUtils.Companion;
            Intrinsics.checkNotNullExpressionValue(str, "phone");
            companion.setIsNoApartmentNum(context, str, z);
        }
        fullKycExtraFragment.m25283e();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25268a(FullKycExtraFragment fullKycExtraFragment, String str, View view) {
        Intrinsics.checkNotNullParameter(fullKycExtraFragment, "this$0");
        fullKycExtraFragment.m25284f();
        ((Request) DRouter.build(f33234B).putExtra("type", "state")).start(fullKycExtraFragment.getActivity(), new FullKycExtraFragment$initListener$17$1(fullKycExtraFragment, str));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m25280b(FullKycExtraFragment fullKycExtraFragment, String str, View view) {
        Intrinsics.checkNotNullParameter(fullKycExtraFragment, "this$0");
        NewPixInputView newPixInputView = fullKycExtraFragment.f33252l;
        NewPixInputView newPixInputView2 = null;
        if (newPixInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
            newPixInputView = null;
        }
        if (!TextUtils.isEmpty(newPixInputView.getInputStr())) {
            fullKycExtraFragment.m25284f();
            Request request = (Request) DRouter.build(f33234B).putExtra("type", "city");
            NewPixInputView newPixInputView3 = fullKycExtraFragment.f33252l;
            if (newPixInputView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
            } else {
                newPixInputView2 = newPixInputView3;
            }
            ((Request) request.putExtra("state", newPixInputView2.getInputStr())).start(fullKycExtraFragment.getActivity(), new FullKycExtraFragment$initListener$18$1(fullKycExtraFragment, str));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m25281c() {
        Ref.IntRef intRef = new Ref.IntRef();
        LinkedList<GuidesInfoResp.Income> linkedList = this.f33259s;
        GuidesInfoResp.Income income = null;
        if (linkedList != null) {
            int i = 0;
            for (Object next : linkedList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String type = ((GuidesInfoResp.Income) next).getType();
                GuidesInfoResp.Income income2 = this.f33260t;
                if (Intrinsics.areEqual((Object) type, (Object) income2 == null ? null : income2.getType())) {
                    intRef.element = i;
                }
                i = i2;
            }
        }
        LinkedList<GuidesInfoResp.Income> linkedList2 = this.f33259s;
        if (linkedList2 != null) {
            income = linkedList2.get(intRef.element);
        }
        this.f33260t = income;
        List listOf = CollectionsKt.listOf(new FullKycExtraFragment$showIncomeDialogView$optionList$1(this, intRef));
        Context context = getContext();
        if (context != null) {
            WalletDialog.Companion companion = WalletDialog.Companion;
            OptionWheelBuilder optionWheelBuilder = new OptionWheelBuilder();
            optionWheelBuilder.addAllItem(listOf);
            optionWheelBuilder.setShowDelete(false);
            optionWheelBuilder.setCancelClick($$Lambda$FullKycExtraFragment$ZRL3jwY3lUOuEllGs_AgFCQ_I8o.INSTANCE);
            optionWheelBuilder.setConfirmText(getString(R.string.pay_base_confirm));
            optionWheelBuilder.setConfirmClick(new OnOptionWheelClick(context) {
                public final /* synthetic */ Context f$1;

                {
                    this.f$1 = r2;
                }

                public final boolean onClick(Map map) {
                    return FullKycExtraFragment.m25274a(FullKycExtraFragment.this, this.f$1, map);
                }
            });
            Unit unit = Unit.INSTANCE;
            SystemUtils.showDialog(WalletDialog.Companion.configOptionWheel$default(companion, context, optionWheelBuilder, false, false, 12, (Object) null));
            KycOmega.Companion.trackEvent("fin_primarykycinformation_income_sw");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m25275a(Map map) {
        KycOmega.Companion.trackButtonEvent("fin_primarykycinformation_incomebutton_ck", 5);
        return true;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0036  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean m25274a(com.didi.payment.kycservice.kyc.fragment.FullKycExtraFragment r3, android.content.Context r4, java.util.Map r5) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "$ctx"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "A"
            java.lang.Object r5 = r5.get(r0)
            java.lang.Integer r5 = (java.lang.Integer) r5
            r0 = 0
            if (r5 != 0) goto L_0x0017
        L_0x0015:
            r5 = r0
            goto L_0x0028
        L_0x0017:
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            java.util.LinkedList<com.didi.payment.kycservice.kyc.response.GuidesInfoResp$Income> r1 = r3.f33259s
            if (r1 != 0) goto L_0x0022
            goto L_0x0015
        L_0x0022:
            java.lang.Object r5 = r1.get(r5)
            com.didi.payment.kycservice.kyc.response.GuidesInfoResp$Income r5 = (com.didi.payment.kycservice.kyc.response.GuidesInfoResp.Income) r5
        L_0x0028:
            r3.f33260t = r5
            com.didi.payment.commonsdk.utils.KycOmega$Companion r5 = com.didi.payment.commonsdk.utils.KycOmega.Companion
            java.lang.String r1 = "fin_primarykycinformation_incomebutton_ck"
            r2 = 1
            r5.trackButtonEvent(r1, r2)
            android.widget.TextView r5 = r3.f33245e
            if (r5 != 0) goto L_0x003c
            java.lang.String r5 = "mIncomeText"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r5 = r0
        L_0x003c:
            com.didi.payment.kycservice.kyc.response.GuidesInfoResp$Income r1 = r3.f33260t
            if (r1 != 0) goto L_0x0041
            goto L_0x0045
        L_0x0041:
            java.lang.String r0 = r1.getDisplay()
        L_0x0045:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r5.setText(r0)
            com.didi.payment.kycservice.kyc.response.GuidesInfoResp$Income r5 = r3.f33260t
            if (r5 != 0) goto L_0x0053
            goto L_0x0058
        L_0x0053:
            com.didi.payment.kycservice.utils.KycSPUtils$Companion r0 = com.didi.payment.kycservice.utils.KycSPUtils.Companion
            r0.putIncome(r4, r5)
        L_0x0058:
            r3.m25283e()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.kycservice.kyc.fragment.FullKycExtraFragment.m25274a(com.didi.payment.kycservice.kyc.fragment.FullKycExtraFragment, android.content.Context, java.util.Map):boolean");
    }

    /* renamed from: a */
    private final void m25270a(AddressZipCodeResp.DataBean dataBean) {
        m25282d();
        String stringParam = PayBaseParamUtil.getStringParam(getContext(), "phone");
        NewPixInputView newPixInputView = null;
        if (dataBean.streetName != null) {
            NewPixInputView newPixInputView2 = this.f33248h;
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
            NewPixInputView newPixInputView3 = this.f33249i;
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
            NewPixInputView newPixInputView4 = this.f33253m;
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
            NewPixInputView newPixInputView5 = this.f33250j;
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
            NewPixInputView newPixInputView6 = this.f33252l;
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
            NewPixInputView newPixInputView7 = this.f33251k;
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
        m25283e();
    }

    /* renamed from: d */
    private final void m25282d() {
        NewPixInputView newPixInputView = this.f33248h;
        NewPixInputView newPixInputView2 = null;
        if (newPixInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStreetInput");
            newPixInputView = null;
        }
        newPixInputView.setInputStr("");
        NewPixInputView newPixInputView3 = this.f33251k;
        if (newPixInputView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDistrictInput");
            newPixInputView3 = null;
        }
        newPixInputView3.setInputStr("");
        NewPixInputView newPixInputView4 = this.f33252l;
        if (newPixInputView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
            newPixInputView4 = null;
        }
        newPixInputView4.setInputStr("");
        NewPixInputView newPixInputView5 = this.f33253m;
        if (newPixInputView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCityInput");
        } else {
            newPixInputView2 = newPixInputView5;
        }
        newPixInputView2.setInputStr("");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005f, code lost:
        if (r1.isInputNotBlank() != false) goto L_0x0063;
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m25283e() {
        /*
            r4 = this;
            android.widget.TextView r0 = r4.f33254n
            r1 = 0
            if (r0 != 0) goto L_0x000b
            java.lang.String r0 = "mSubmitBtn"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = r1
        L_0x000b:
            r2 = 1
            boolean r3 = r4.m25273a((int) r2)
            if (r3 == 0) goto L_0x0062
            r3 = 2
            boolean r3 = r4.m25273a((int) r3)
            if (r3 == 0) goto L_0x0062
            r3 = 3
            boolean r3 = r4.m25273a((int) r3)
            if (r3 == 0) goto L_0x0062
            com.didi.payment.kycservice.widget.NewPixInputView r3 = r4.f33251k
            if (r3 != 0) goto L_0x002a
            java.lang.String r3 = "mDistrictInput"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r3 = r1
        L_0x002a:
            boolean r3 = r3.isInputNotBlank()
            if (r3 == 0) goto L_0x0062
            com.didi.payment.kycservice.widget.NewPixInputView r3 = r4.f33248h
            if (r3 != 0) goto L_0x003a
            java.lang.String r3 = "mStreetInput"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r3 = r1
        L_0x003a:
            boolean r3 = r3.isInputNotBlank()
            if (r3 == 0) goto L_0x0062
            com.didi.payment.kycservice.widget.NewPixInputView r3 = r4.f33252l
            if (r3 != 0) goto L_0x004a
            java.lang.String r3 = "mStateInput"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r3 = r1
        L_0x004a:
            boolean r3 = r3.isInputNotBlank()
            if (r3 == 0) goto L_0x0062
            com.didi.payment.kycservice.widget.NewPixInputView r3 = r4.f33253m
            if (r3 != 0) goto L_0x005a
            java.lang.String r3 = "mCityInput"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            goto L_0x005b
        L_0x005a:
            r1 = r3
        L_0x005b:
            boolean r1 = r1.isInputNotBlank()
            if (r1 == 0) goto L_0x0062
            goto L_0x0063
        L_0x0062:
            r2 = 0
        L_0x0063:
            r0.setEnabled(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.kycservice.kyc.fragment.FullKycExtraFragment.m25283e():void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.didi.payment.kycservice.widget.NewPixInputView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: com.didi.payment.kycservice.widget.NewPixInputView} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.widget.TextView] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m25273a(int r5) {
        /*
            r4 = this;
            r0 = 0
            r1 = 1
            if (r5 == r1) goto L_0x004f
            r2 = 2
            r3 = 0
            if (r5 == r2) goto L_0x0035
            r2 = 3
            if (r5 == r2) goto L_0x000c
            return r3
        L_0x000c:
            com.didi.payment.kycservice.widget.NewPixInputView r5 = r4.f33249i
            java.lang.String r2 = "mNumberInput"
            if (r5 != 0) goto L_0x0016
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r5 = r0
        L_0x0016:
            java.lang.String r5 = r5.getInputStr()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = kotlin.text.StringsKt.isBlank(r5)
            r5 = r5 ^ r1
            if (r5 != 0) goto L_0x0034
            com.didi.payment.kycservice.widget.NewPixInputView r5 = r4.f33249i
            if (r5 != 0) goto L_0x002b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L_0x002c
        L_0x002b:
            r0 = r5
        L_0x002c:
            boolean r5 = r0.isCheckBoxChecked()
            if (r5 == 0) goto L_0x0033
            goto L_0x0034
        L_0x0033:
            r1 = 0
        L_0x0034:
            return r1
        L_0x0035:
            com.didi.payment.kycservice.widget.NewPixInputView r5 = r4.f33246f
            if (r5 != 0) goto L_0x003f
            java.lang.String r5 = "mZipCodeInput"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            goto L_0x0040
        L_0x003f:
            r0 = r5
        L_0x0040:
            java.lang.String r5 = r0.getInputStr()
            int r5 = r5.length()
            r0 = 8
            if (r5 != r0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r1 = 0
        L_0x004e:
            return r1
        L_0x004f:
            android.widget.TextView r5 = r4.f33245e
            if (r5 != 0) goto L_0x0059
            java.lang.String r5 = "mIncomeText"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            goto L_0x005a
        L_0x0059:
            r0 = r5
        L_0x005a:
            java.lang.CharSequence r5 = r0.getText()
            java.lang.String r0 = "mIncomeText.text"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            boolean r5 = kotlin.text.StringsKt.isBlank(r5)
            r5 = r5 ^ r1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.kycservice.kyc.fragment.FullKycExtraFragment.m25273a(int):boolean");
    }

    /* renamed from: f */
    private final void m25284f() {
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

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m25277b(int i) {
        KycOmega.Companion.trackEvent("fin_table2_content_ck", MapsKt.mutableMapOf(TuplesKt.m41339to(CarServerParam.PARAM_BUTTON, Integer.valueOf(i))));
    }
}
