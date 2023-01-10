package com.didi.payment.kycservice.kyc.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.datadog.android.log.LogAttributes;
import com.didi.dimina.container.secondparty.trace.DiminaTraceService;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.base.utils.TextHighlightUtil;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.commonsdk.p130ui.WBaseFragment;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.commonsdk.utils.NWRouter;
import com.didi.payment.kycservice.kyc.SignUpVM;
import com.didi.payment.kycservice.kyc.p134vm.SignUp99PayVM;
import com.didi.payment.kycservice.net.response.PixGetApplyInfoResp;
import com.didi.payment.kycservice.utils.CPFInputWatcher;
import com.didi.payment.kycservice.utils.KycSPUtils;
import com.didi.payment.kycservice.utils.ViewExtsKt;
import com.didi.payment.kycservice.widget.NewPixInputView;
import com.didi.payment.wallet_ui.dialog.WalletDialog;
import com.didi.payment.wallet_ui.wheel.OnTimeWheelClick;
import com.didi.payment.wallet_ui.wheel.TimeItemAdapter;
import com.didi.payment.wallet_ui.wheel.TimeWheelBuilder;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 D2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001DB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u001eH\u0002J\b\u0010(\u001a\u00020%H\u0002J\n\u0010)\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010*\u001a\u00020\u001eH\u0002J\b\u0010+\u001a\u00020%H\u0002J\b\u0010,\u001a\u00020%H\u0002J\b\u0010-\u001a\u00020%H\u0002J\u0010\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u00020\u000fH\u0002J\b\u00100\u001a\u00020#H\u0002J\b\u00101\u001a\u00020#H\u0002J\b\u00102\u001a\u00020#H\u0002J&\u00103\u001a\u0004\u0018\u00010\u000f2\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u001a\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u00020\u000f2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0012\u0010<\u001a\u0004\u0018\u00010\u00152\u0006\u0010=\u001a\u00020\u001eH\u0002J\u0010\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020\nH\u0002J\b\u0010@\u001a\u00020%H\u0002J\u0010\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020\u0002H\u0016J\b\u0010C\u001a\u00020%H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, mo148868d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/StepBaseInfoFragment;", "Lcom/didi/payment/commonsdk/ui/WBaseFragment;", "Lcom/didi/payment/kycservice/kyc/vm/SignUp99PayVM;", "()V", "mActivityTv", "Landroid/widget/TextView;", "mAgeErrorTv", "mAgeLayout", "Landroid/widget/LinearLayout;", "mCPFInfo", "Lcom/didi/payment/kycservice/net/response/PixGetApplyInfoResp$CPFInfo;", "mCPFInput", "Lcom/didi/payment/kycservice/widget/NewPixInputView;", "mDateTv", "mDividerView", "Landroid/view/View;", "mNameInput", "mNextBtn", "mPreBtn", "Landroid/widget/ImageView;", "mSelectDate", "Ljava/util/Date;", "mSignUpVM", "mTermCb", "Landroid/widget/CheckBox;", "mTermTv", "mTermsLayout", "nextStep", "Lcom/didi/payment/kycservice/kyc/fragment/KycFormStep;", "pageSource", "", "pixSignUpVM", "Lcom/didi/payment/kycservice/kyc/SignUpVM;", "step", "checkInputInfo", "", "configTimePicker", "", "fillCPFInput", "taxId", "fillInfoFromSP", "getTitleBarView", "getUpLoadTime", "gotoTermPage", "initListener", "initTermView", "initView", "rootView", "isValidAge", "isValidCPF", "isValidName", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "parseDateString", "text", "showData", "data", "submitKycInfoV1", "subscribeUi", "vm", "updateSubmitBtn", "Companion", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: StepBaseInfoFragment.kt */
public final class StepBaseInfoFragment extends WBaseFragment<SignUp99PayVM> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: t */
    private static final int f33341t = 14;

    /* renamed from: u */
    private static final int f33342u = 18;

    /* renamed from: v */
    private static final String f33343v = "STEP";

    /* renamed from: w */
    private static final String f33344w = "SOURCE_PAGE";

    /* renamed from: a */
    private TextView f33345a;

    /* renamed from: b */
    private ImageView f33346b;

    /* renamed from: c */
    private LinearLayout f33347c;

    /* renamed from: d */
    private TextView f33348d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public NewPixInputView f33349e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public NewPixInputView f33350f;

    /* renamed from: g */
    private TextView f33351g;

    /* renamed from: h */
    private TextView f33352h;

    /* renamed from: i */
    private TextView f33353i;

    /* renamed from: j */
    private CheckBox f33354j;

    /* renamed from: k */
    private LinearLayout f33355k;

    /* renamed from: l */
    private View f33356l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public SignUp99PayVM f33357m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public SignUpVM f33358n;

    /* renamed from: o */
    private Date f33359o;

    /* renamed from: p */
    private PixGetApplyInfoResp.CPFInfo f33360p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public KycFormStep f33361q = KycFormStep.STEP_NAME;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public KycFormStep f33362r = KycFormStep.STEP_NAME;

    /* renamed from: s */
    private String f33363s = "";

    @Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: StepBaseInfoFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KycFormStep.values().length];
            iArr[KycFormStep.STEP_DATE.ordinal()] = 1;
            iArr[KycFormStep.STEP_CPF.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m25384a(Date date) {
        return true;
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return null;
    }

    @Metadata(mo148867d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo148868d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/StepBaseInfoFragment$Companion;", "", "()V", "ARGS_SOURCE_PAGE", "", "ARGS_STEP", "CPF_LENGTH", "", "LEGAL_AGE", "newInstance", "Lcom/didi/payment/kycservice/kyc/fragment/StepBaseInfoFragment;", "step", "Lcom/didi/payment/kycservice/kyc/fragment/KycFormStep;", "pageSource", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: StepBaseInfoFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StepBaseInfoFragment newInstance(KycFormStep kycFormStep, String str) {
            Intrinsics.checkNotNullParameter(kycFormStep, DiminaTraceService.MAS_MONITOR_EVENT.KEY.STEP);
            Intrinsics.checkNotNullParameter(str, "pageSource");
            StepBaseInfoFragment stepBaseInfoFragment = new StepBaseInfoFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(StepBaseInfoFragment.f33343v, kycFormStep);
            bundle.putString(StepBaseInfoFragment.f33344w, str);
            Unit unit = Unit.INSTANCE;
            stepBaseInfoFragment.setArguments(bundle);
            return stepBaseInfoFragment;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_step_base_info, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        String string;
        Intrinsics.checkNotNullParameter(view, "view");
        ViewModel viewModel = new ViewModelProvider(requireActivity()).get(SignUpVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir…get(SignUpVM::class.java)");
        this.f33358n = (SignUpVM) viewModel;
        ViewModel viewModel2 = new ViewModelProvider(requireParentFragment()).get(SignUp99PayVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(requir…ignUp99PayVM::class.java)");
        this.f33357m = (SignUp99PayVM) viewModel2;
        Bundle arguments = getArguments();
        SignUp99PayVM signUp99PayVM = null;
        Serializable serializable = arguments == null ? null : arguments.getSerializable(f33343v);
        KycFormStep kycFormStep = serializable instanceof KycFormStep ? (KycFormStep) serializable : null;
        if (kycFormStep == null) {
            kycFormStep = KycFormStep.STEP_NAME;
        }
        this.f33361q = kycFormStep;
        Bundle arguments2 = getArguments();
        String str = "";
        if (!(arguments2 == null || (string = arguments2.getString(f33344w, str)) == null)) {
            str = string;
        }
        this.f33363s = str;
        m25376a(view);
        m25388d();
        m25375a();
        m25395k();
        SignUp99PayVM signUp99PayVM2 = this.f33357m;
        if (signUp99PayVM2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSignUpVM");
        } else {
            signUp99PayVM = signUp99PayVM2;
        }
        subscribeUi(signUp99PayVM);
    }

    public void subscribeUi(SignUp99PayVM signUp99PayVM) {
        Intrinsics.checkNotNullParameter(signUp99PayVM, "vm");
        super.subscribeUi(signUp99PayVM);
        signUp99PayVM.getCpfinfo().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                StepBaseInfoFragment.m25378a(StepBaseInfoFragment.this, (PixGetApplyInfoResp.CPFInfo) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25378a(StepBaseInfoFragment stepBaseInfoFragment, PixGetApplyInfoResp.CPFInfo cPFInfo) {
        Intrinsics.checkNotNullParameter(stepBaseInfoFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(cPFInfo, "it");
        stepBaseInfoFragment.m25381a(cPFInfo);
    }

    /* renamed from: a */
    private final void m25376a(View view) {
        View findViewById = view.findViewById(R.id.btn_next);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.btn_next)");
        this.f33345a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.btn_pre_page);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.btn_pre_page)");
        this.f33346b = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.age_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.age_layout)");
        this.f33347c = (LinearLayout) findViewById3;
        View findViewById4 = view.findViewById(R.id.wallet_account_appply_name_input);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.…ccount_appply_name_input)");
        this.f33349e = (NewPixInputView) findViewById4;
        View findViewById5 = view.findViewById(R.id.wallet_account_appply_cpf_input);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.…account_appply_cpf_input)");
        this.f33350f = (NewPixInputView) findViewById5;
        View findViewById6 = view.findViewById(R.id.wallet_account_appply_age_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.…et_account_appply_age_tv)");
        this.f33351g = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.wallet_account_appply_term_cb);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.…t_account_appply_term_cb)");
        this.f33354j = (CheckBox) findViewById7;
        View findViewById8 = view.findViewById(R.id.wallet_account_appply_term_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.…t_account_appply_term_tv)");
        this.f33352h = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.wallet_account_activity_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "rootView.findViewById(R.…llet_account_activity_tv)");
        this.f33353i = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.tv_age_error_info);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "rootView.findViewById(R.id.tv_age_error_info)");
        this.f33348d = (TextView) findViewById10;
        View findViewById11 = view.findViewById(R.id.terms_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "rootView.findViewById(R.id.terms_layout)");
        this.f33355k = (LinearLayout) findViewById11;
        View findViewById12 = view.findViewById(R.id.divider_view);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "rootView.findViewById(R.id.divider_view)");
        this.f33356l = findViewById12;
        CharSequence highlight = TextHighlightUtil.highlight(getString(R.string.kyc_create_account_page_input_name), Color.parseColor("#999999"), Color.parseColor("#FF0000"));
        NewPixInputView newPixInputView = this.f33349e;
        SignUpVM signUpVM = null;
        if (newPixInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNameInput");
            newPixInputView = null;
        }
        Intrinsics.checkNotNullExpressionValue(highlight, "nameTitle");
        newPixInputView.initData(highlight, 120, 1);
        CharSequence highlight2 = TextHighlightUtil.highlight(getString(R.string.kyc_create_account_page_input_cpf), Color.parseColor("#999999"), Color.parseColor("#FF0000"));
        NewPixInputView newPixInputView2 = this.f33350f;
        if (newPixInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
            newPixInputView2 = null;
        }
        Intrinsics.checkNotNullExpressionValue(highlight2, "cpfTitle");
        newPixInputView2.initData(highlight2, 14, 2, "000.000.000-00");
        int i = WhenMappings.$EnumSwitchMapping$0[this.f33361q.ordinal()];
        if (i == 1) {
            ImageView imageView = this.f33346b;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPreBtn");
                imageView = null;
            }
            imageView.setVisibility(0);
            NewPixInputView newPixInputView3 = this.f33349e;
            if (newPixInputView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNameInput");
                newPixInputView3 = null;
            }
            newPixInputView3.setVisibility(8);
            LinearLayout linearLayout = this.f33355k;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTermsLayout");
                linearLayout = null;
            }
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = this.f33347c;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAgeLayout");
                linearLayout2 = null;
            }
            linearLayout2.setVisibility(0);
            NewPixInputView newPixInputView4 = this.f33350f;
            if (newPixInputView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
                newPixInputView4 = null;
            }
            newPixInputView4.setVisibility(8);
            View view2 = this.f33356l;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDividerView");
                view2 = null;
            }
            view2.setVisibility(8);
            this.f33362r = KycFormStep.STEP_CPF;
            KycOmega.Companion.trackEvent("fin_table2_birthday_sw");
        } else if (i != 2) {
            ImageView imageView2 = this.f33346b;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPreBtn");
                imageView2 = null;
            }
            imageView2.setVisibility(8);
            NewPixInputView newPixInputView5 = this.f33349e;
            if (newPixInputView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNameInput");
                newPixInputView5 = null;
            }
            newPixInputView5.setVisibility(0);
            LinearLayout linearLayout3 = this.f33355k;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTermsLayout");
                linearLayout3 = null;
            }
            linearLayout3.setVisibility(0);
            LinearLayout linearLayout4 = this.f33347c;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAgeLayout");
                linearLayout4 = null;
            }
            linearLayout4.setVisibility(8);
            NewPixInputView newPixInputView6 = this.f33350f;
            if (newPixInputView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
                newPixInputView6 = null;
            }
            newPixInputView6.setVisibility(8);
            View view3 = this.f33356l;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDividerView");
                view3 = null;
            }
            view3.setVisibility(0);
            this.f33362r = KycFormStep.STEP_DATE;
            KycOmega.Companion.trackEvent("fin_table2_name_sw");
        } else {
            ImageView imageView3 = this.f33346b;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPreBtn");
                imageView3 = null;
            }
            imageView3.setVisibility(0);
            NewPixInputView newPixInputView7 = this.f33349e;
            if (newPixInputView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNameInput");
                newPixInputView7 = null;
            }
            newPixInputView7.setVisibility(8);
            LinearLayout linearLayout5 = this.f33355k;
            if (linearLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTermsLayout");
                linearLayout5 = null;
            }
            linearLayout5.setVisibility(8);
            LinearLayout linearLayout6 = this.f33347c;
            if (linearLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAgeLayout");
                linearLayout6 = null;
            }
            linearLayout6.setVisibility(8);
            NewPixInputView newPixInputView8 = this.f33350f;
            if (newPixInputView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
                newPixInputView8 = null;
            }
            newPixInputView8.setVisibility(0);
            View view4 = this.f33356l;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDividerView");
                view4 = null;
            }
            view4.setVisibility(8);
            this.f33362r = KycFormStep.STEP_CPF;
            KycOmega.Companion.trackEvent("fin_table2_cpf_sw");
        }
        SignUpVM signUpVM2 = this.f33358n;
        if (signUpVM2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
        } else {
            signUpVM = signUpVM2;
        }
        signUpVM.updateStepProgress(this.f33361q);
    }

    /* renamed from: a */
    private final void m25375a() {
        String stringParam = PayBaseParamUtil.getStringParam(getContext(), "phone");
        TextView textView = this.f33351g;
        CheckBox checkBox = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDateTv");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                StepBaseInfoFragment.m25377a(StepBaseInfoFragment.this, view);
            }
        });
        TextView textView2 = this.f33345a;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNextBtn");
            textView2 = null;
        }
        ViewExtsKt.click(textView2, new StepBaseInfoFragment$initListener$2(this));
        ImageView imageView = this.f33346b;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPreBtn");
            imageView = null;
        }
        ViewExtsKt.click(imageView, new StepBaseInfoFragment$initListener$3(this));
        NewPixInputView newPixInputView = this.f33350f;
        if (newPixInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
            newPixInputView = null;
        }
        newPixInputView.setAfterTextChangedListener(new StepBaseInfoFragment$initListener$4(this));
        NewPixInputView newPixInputView2 = this.f33350f;
        if (newPixInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
            newPixInputView2 = null;
        }
        NewPixInputView newPixInputView3 = this.f33350f;
        if (newPixInputView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
            newPixInputView3 = null;
        }
        newPixInputView2.addTextChangeListener(new CPFInputWatcher(newPixInputView3.getEditText()));
        NewPixInputView newPixInputView4 = this.f33349e;
        if (newPixInputView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNameInput");
            newPixInputView4 = null;
        }
        newPixInputView4.setAfterTextChangedListener(new StepBaseInfoFragment$initListener$5(this));
        NewPixInputView newPixInputView5 = this.f33349e;
        if (newPixInputView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNameInput");
            newPixInputView5 = null;
        }
        newPixInputView5.setOnLoseFocus(new StepBaseInfoFragment$initListener$6(this, stringParam));
        NewPixInputView newPixInputView6 = this.f33350f;
        if (newPixInputView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
            newPixInputView6 = null;
        }
        newPixInputView6.setOnLoseFocus(new StepBaseInfoFragment$initListener$7(this, stringParam));
        CheckBox checkBox2 = this.f33354j;
        if (checkBox2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTermCb");
        } else {
            checkBox = checkBox2;
        }
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(stringParam) {
            public final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                StepBaseInfoFragment.m25380a(StepBaseInfoFragment.this, this.f$1, compoundButton, z);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25377a(StepBaseInfoFragment stepBaseInfoFragment, View view) {
        Intrinsics.checkNotNullParameter(stepBaseInfoFragment, "this$0");
        stepBaseInfoFragment.m25389e();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25380a(StepBaseInfoFragment stepBaseInfoFragment, String str, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(stepBaseInfoFragment, "this$0");
        stepBaseInfoFragment.m25390f();
        KycOmega.Companion.trackEvent("gp_99pay_information_clause_ck");
        Context context = stepBaseInfoFragment.getContext();
        if (context != null) {
            KycSPUtils.Companion companion = KycSPUtils.Companion;
            Intrinsics.checkNotNullExpressionValue(str, "phone");
            companion.setCheckedTc(context, str, z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m25386b() {
        NewPixInputView newPixInputView = this.f33350f;
        NewPixInputView newPixInputView2 = null;
        if (newPixInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
            newPixInputView = null;
        }
        String replace = new Regex(" ").replace((CharSequence) new Regex("-").replace((CharSequence) StringsKt.replace$default(newPixInputView.getInputStr(), '.', ' ', false, 4, (Object) null), ""), "");
        SignUp99PayVM signUp99PayVM = this.f33357m;
        if (signUp99PayVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSignUpVM");
            signUp99PayVM = null;
        }
        NewPixInputView newPixInputView3 = this.f33349e;
        if (newPixInputView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNameInput");
        } else {
            newPixInputView2 = newPixInputView3;
        }
        signUp99PayVM.submitKycInfoV1(newPixInputView2.getInputStr(), m25387c(), replace, this.f33363s);
    }

    /* renamed from: c */
    private final String m25387c() {
        if (this.f33359o == null) {
            return "";
        }
        String format = new SimpleDateFormat("yyyy-MM-dd").format(this.f33359o);
        Intrinsics.checkNotNullExpressionValue(format, "format.format(mSelectDate)");
        return format;
    }

    /* renamed from: d */
    private final void m25388d() {
        Context context = getContext();
        if (context != null) {
            String stringParam = PayBaseParamUtil.getStringParam(context, "phone");
            KycSPUtils.Companion companion = KycSPUtils.Companion;
            Intrinsics.checkNotNullExpressionValue(stringParam, "phone");
            String name = companion.getName(context, stringParam);
            String birthday = KycSPUtils.Companion.getBirthday(context, stringParam);
            String cpf = KycSPUtils.Companion.getCPF(context, stringParam);
            CharSequence charSequence = name;
            boolean z = false;
            CheckBox checkBox = null;
            if (!(charSequence == null || charSequence.length() == 0)) {
                NewPixInputView newPixInputView = this.f33349e;
                if (newPixInputView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNameInput");
                    newPixInputView = null;
                }
                newPixInputView.setInputStr(name);
            }
            CharSequence charSequence2 = birthday;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                TextView textView = this.f33351g;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDateTv");
                    textView = null;
                }
                textView.setText(charSequence2);
                TextView textView2 = this.f33351g;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDateTv");
                    textView2 = null;
                }
                textView2.setTextColor(Color.parseColor("#000000"));
                if (birthday != null) {
                    String substring = birthday.substring(0, 2);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (birthday != null) {
                        String substring2 = birthday.substring(3, 5);
                        Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        if (birthday != null) {
                            String substring3 = birthday.substring(6, 10);
                            Intrinsics.checkNotNullExpressionValue(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            this.f33359o = m25385b(substring3 + '-' + substring2 + '-' + substring);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                TextView textView3 = this.f33351g;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDateTv");
                    textView3 = null;
                }
                textView3.setText(getString(R.string.Fintech_Payment_Optimization_Day_month_tVPF));
                TextView textView4 = this.f33351g;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDateTv");
                    textView4 = null;
                }
                textView4.setTextColor(Color.parseColor("#999999"));
            }
            CharSequence charSequence3 = cpf;
            if (!(charSequence3 == null || charSequence3.length() == 0)) {
                NewPixInputView newPixInputView2 = this.f33350f;
                if (newPixInputView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
                    newPixInputView2 = null;
                }
                newPixInputView2.setInputStr(cpf);
            }
            CheckBox checkBox2 = this.f33354j;
            if (checkBox2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTermCb");
            } else {
                checkBox = checkBox2;
            }
            if (KycSPUtils.Companion.isCheckedTc(context, stringParam)) {
                z = true;
            }
            checkBox.setChecked(z);
            m25390f();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ac, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0.getText(), (java.lang.Object) getString(com.taxis99.R.string.Fintech_Payment_Optimization_Day_month_tVPF)) != false) goto L_0x00ae;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m25381a(com.didi.payment.kycservice.net.response.PixGetApplyInfoResp.CPFInfo r6) {
        /*
            r5 = this;
            r5.f33360p = r6
            java.lang.String r0 = r6.getName()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L_0x003e
            com.didi.payment.kycservice.widget.NewPixInputView r0 = r5.f33349e
            java.lang.String r4 = "mNameInput"
            if (r0 != 0) goto L_0x001b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r0 = r3
        L_0x001b:
            java.lang.String r0 = r0.getInputStr()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0029
            r0 = 1
            goto L_0x002a
        L_0x0029:
            r0 = 0
        L_0x002a:
            if (r0 == 0) goto L_0x003e
            com.didi.payment.kycservice.widget.NewPixInputView r0 = r5.f33349e
            if (r0 != 0) goto L_0x0034
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r0 = r3
        L_0x0034:
            java.lang.String r4 = r6.getName()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            r0.setInputStr(r4)
        L_0x003e:
            java.lang.String r0 = r6.getTaxId()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x006f
            com.didi.payment.kycservice.widget.NewPixInputView r0 = r5.f33350f
            if (r0 != 0) goto L_0x0054
            java.lang.String r0 = "mCPFInput"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = r3
        L_0x0054:
            java.lang.String r0 = r0.getInputStr()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0062
            r0 = 1
            goto L_0x0063
        L_0x0062:
            r0 = 0
        L_0x0063:
            if (r0 == 0) goto L_0x006f
            java.lang.String r0 = r6.getTaxId()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r5.m25382a((java.lang.String) r0)
        L_0x006f:
            java.lang.String r0 = r6.getBirthdate()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00ee
            android.widget.TextView r0 = r5.f33351g
            java.lang.String r4 = "mDateTv"
            if (r0 != 0) goto L_0x0085
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r0 = r3
        L_0x0085:
            java.lang.CharSequence r0 = r0.getText()
            if (r0 == 0) goto L_0x0093
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0092
            goto L_0x0093
        L_0x0092:
            r1 = 0
        L_0x0093:
            if (r1 != 0) goto L_0x00ae
            android.widget.TextView r0 = r5.f33351g
            if (r0 != 0) goto L_0x009d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r0 = r3
        L_0x009d:
            java.lang.CharSequence r0 = r0.getText()
            r1 = 2131951760(0x7f130090, float:1.9539944E38)
            java.lang.String r1 = r5.getString(r1)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x00ee
        L_0x00ae:
            java.lang.String r0 = r6.getBirthdate()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.util.Date r0 = r5.m25385b(r0)
            if (r0 == 0) goto L_0x00ee
            r5.f33359o = r0
            android.widget.TextView r0 = r5.f33351g
            if (r0 != 0) goto L_0x00c5
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r0 = r3
        L_0x00c5:
            java.lang.String r1 = "#000000"
            int r1 = android.graphics.Color.parseColor(r1)
            r0.setTextColor(r1)
            android.widget.TextView r0 = r5.f33351g
            if (r0 != 0) goto L_0x00d6
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r0 = r3
        L_0x00d6:
            com.didi.payment.kycservice.kyc.vm.SignUp99PayVM r1 = r5.f33357m
            if (r1 != 0) goto L_0x00e0
            java.lang.String r1 = "mSignUpVM"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r1 = r3
        L_0x00e0:
            java.util.Date r4 = r5.f33359o
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.String r1 = r1.getShowTime(r4)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x00ee:
            com.didi.payment.kycservice.net.response.PixGetApplyInfoResp$PromotionActivity r0 = r6.getPromotionRule()
            if (r0 == 0) goto L_0x015b
            com.didi.payment.kycservice.net.response.PixGetApplyInfoResp$PromotionActivity r0 = r6.getPromotionRule()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r0 = r0.getText()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x015b
            com.didi.payment.kycservice.net.response.PixGetApplyInfoResp$PromotionActivity r0 = r6.getPromotionRule()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r0 = r0.getUrl()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x015b
            android.widget.TextView r0 = r5.f33353i
            java.lang.String r1 = "mActivityTv"
            if (r0 != 0) goto L_0x0124
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r3
        L_0x0124:
            r0.setVisibility(r2)
            android.widget.TextView r0 = r5.f33353i
            if (r0 != 0) goto L_0x012f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r3
        L_0x012f:
            com.didi.payment.kycservice.net.response.PixGetApplyInfoResp$PromotionActivity r2 = r6.getPromotionRule()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.String r2 = r2.getText()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            com.didi.payment.kycservice.net.response.PixGetApplyInfoResp$PromotionActivity r6 = r6.getPromotionRule()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            java.lang.String r6 = r6.getUrl()
            android.widget.TextView r0 = r5.f33353i
            if (r0 != 0) goto L_0x0152
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x0153
        L_0x0152:
            r3 = r0
        L_0x0153:
            com.didi.payment.kycservice.kyc.fragment.-$$Lambda$StepBaseInfoFragment$djWHYbZQtQZ3NV534cOUXG734JM r0 = new com.didi.payment.kycservice.kyc.fragment.-$$Lambda$StepBaseInfoFragment$djWHYbZQtQZ3NV534cOUXG734JM
            r0.<init>(r6)
            r3.setOnClickListener(r0)
        L_0x015b:
            r5.m25390f()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.kycservice.kyc.fragment.StepBaseInfoFragment.m25381a(com.didi.payment.kycservice.net.response.PixGetApplyInfoResp$CPFInfo):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25379a(StepBaseInfoFragment stepBaseInfoFragment, String str, View view) {
        Intrinsics.checkNotNullParameter(stepBaseInfoFragment, "this$0");
        WebBrowserUtil.startInternalWebActivity(stepBaseInfoFragment.getContext(), str, "");
    }

    /* renamed from: e */
    private final void m25389e() {
        Context context = getContext();
        if (context != null) {
            WalletDialog.Companion companion = WalletDialog.Companion;
            TimeWheelBuilder timeWheelBuilder = new TimeWheelBuilder();
            timeWheelBuilder.setDateTypeList(CollectionsKt.listOf(new TimeWheelBuilder.TimeType(3), new TimeWheelBuilder.TimeType(2), new TimeWheelBuilder.TimeType(1)));
            Calendar instance = Calendar.getInstance();
            instance.set(1, 1904);
            instance.set(2, 1);
            instance.set(5, 23);
            timeWheelBuilder.setStartDate(instance.getTime());
            timeWheelBuilder.setEndDate(Calendar.getInstance().getTime());
            timeWheelBuilder.setTitle(getString(R.string.wallet_create_account_page_birthday));
            timeWheelBuilder.setConfirmText(getString(R.string.pay_base_confirm));
            String[] stringArray = context.getResources().getStringArray(R.array.months);
            Intrinsics.checkNotNullExpressionValue(stringArray, "ctx.resources.getStringArray(R.array.months)");
            timeWheelBuilder.setItemAdapter(new TimeItemAdapter(stringArray) {
                public final /* synthetic */ String[] f$0;

                {
                    this.f$0 = r1;
                }

                public final String onGetItem(int i, int i2) {
                    return StepBaseInfoFragment.m25374a(this.f$0, i, i2);
                }
            });
            Calendar instance2 = Calendar.getInstance();
            Date date = this.f33359o;
            if (date != null) {
                Intrinsics.checkNotNull(date);
                instance2.setTime(date);
            } else {
                instance2.set(1990, 0, 1);
            }
            timeWheelBuilder.setSelectedDate(instance2.getTime());
            timeWheelBuilder.setKeepLastSelected(true);
            timeWheelBuilder.setShowDelete(false);
            timeWheelBuilder.setCancelClick($$Lambda$StepBaseInfoFragment$1lWspeG6hE7VcccRw0zkIsYZE7A.INSTANCE);
            timeWheelBuilder.setConfirmClick(new OnTimeWheelClick(context) {
                public final /* synthetic */ Context f$1;

                {
                    this.f$1 = r2;
                }

                public final boolean onClick(Date date) {
                    return StepBaseInfoFragment.m25383a(StepBaseInfoFragment.this, this.f$1, date);
                }
            });
            Unit unit = Unit.INSTANCE;
            SystemUtils.showDialog(WalletDialog.Companion.configDateWheel$default(companion, context, timeWheelBuilder, false, false, 12, (Object) null));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final String m25374a(String[] strArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(strArr, "$months");
        if (i == 2) {
            return strArr[i2 - 1];
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m25383a(StepBaseInfoFragment stepBaseInfoFragment, Context context, Date date) {
        Intrinsics.checkNotNullParameter(stepBaseInfoFragment, "this$0");
        Intrinsics.checkNotNullParameter(context, "$ctx");
        stepBaseInfoFragment.f33359o = date;
        TextView textView = stepBaseInfoFragment.f33351g;
        NewPixInputView newPixInputView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDateTv");
            textView = null;
        }
        SignUp99PayVM signUp99PayVM = stepBaseInfoFragment.f33357m;
        if (signUp99PayVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSignUpVM");
            signUp99PayVM = null;
        }
        Intrinsics.checkNotNullExpressionValue(date, LogAttributes.DATE);
        textView.setText(signUp99PayVM.getShowTime(date));
        TextView textView2 = stepBaseInfoFragment.f33351g;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDateTv");
            textView2 = null;
        }
        textView2.setTextColor(Color.parseColor("#000000"));
        if (stepBaseInfoFragment.m25394j()) {
            TextView textView3 = stepBaseInfoFragment.f33348d;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAgeErrorTv");
                textView3 = null;
            }
            textView3.setVisibility(8);
            KycSPUtils.Companion companion = KycSPUtils.Companion;
            String stringParam = PayBaseParamUtil.getStringParam(context, "phone");
            Intrinsics.checkNotNullExpressionValue(stringParam, "getStringParam(ctx, PayParam.PHONE)");
            TextView textView4 = stepBaseInfoFragment.f33351g;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDateTv");
                textView4 = null;
            }
            companion.putBirthday(context, stringParam, textView4.getText().toString());
        } else {
            TextView textView5 = stepBaseInfoFragment.f33348d;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAgeErrorTv");
                textView5 = null;
            }
            textView5.setVisibility(0);
            TextView textView6 = stepBaseInfoFragment.f33348d;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAgeErrorTv");
                textView6 = null;
            }
            textView6.setText(stepBaseInfoFragment.getString(R.string.Fintech_Payment_Optimization_Unregistered_until_gAeR));
        }
        stepBaseInfoFragment.m25390f();
        NewPixInputView newPixInputView2 = stepBaseInfoFragment.f33350f;
        if (newPixInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
        } else {
            newPixInputView = newPixInputView2;
        }
        newPixInputView.getEditText().requestFocus();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public final void m25390f() {
        TextView textView = this.f33345a;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNextBtn");
            textView = null;
        }
        textView.setEnabled(m25391g());
    }

    /* renamed from: g */
    private final boolean m25391g() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.f33361q.ordinal()];
        if (i == 1) {
            return m25394j();
        }
        if (i == 2) {
            return m25392h();
        }
        if (m25393i()) {
            CheckBox checkBox = this.f33354j;
            if (checkBox == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTermCb");
                checkBox = null;
            }
            if (checkBox.isChecked()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public final boolean m25392h() {
        NewPixInputView newPixInputView = this.f33350f;
        if (newPixInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
            newPixInputView = null;
        }
        String replace = new Regex(" ").replace((CharSequence) new Regex("-").replace((CharSequence) StringsKt.replace$default(newPixInputView.getInputStr(), '.', ' ', false, 4, (Object) null), ""), "");
        if (StringsKt.isBlank(replace) || replace.length() != 11) {
            return false;
        }
        int[] iArr = new int[11];
        int i = 0;
        while (true) {
            int i2 = i + 1;
            iArr[i] = Character.getNumericValue(replace.charAt(i));
            if (i2 > 10) {
                break;
            }
            i = i2;
        }
        int i3 = 100;
        int i4 = 0;
        for (int i5 = 0; i5 < 9; i5++) {
            i4 += iArr[i5] * i3;
            i3 -= 10;
        }
        int i6 = i4 % 11;
        if (i6 == 10) {
            i6 = 0;
        }
        if (i6 != iArr[9]) {
            return false;
        }
        int i7 = 110;
        int i8 = 0;
        for (int i9 = 0; i9 < 10; i9++) {
            i8 += iArr[i9] * i7;
            i7 -= 10;
        }
        int i10 = i8 % 11;
        if (i10 == 10) {
            i10 = 0;
        }
        if (i10 == iArr[10]) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public final boolean m25393i() {
        NewPixInputView newPixInputView = this.f33349e;
        NewPixInputView newPixInputView2 = null;
        if (newPixInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNameInput");
            newPixInputView = null;
        }
        if (!StringsKt.isBlank(newPixInputView.getInputStr())) {
            NewPixInputView newPixInputView3 = this.f33349e;
            if (newPixInputView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNameInput");
            } else {
                newPixInputView2 = newPixInputView3;
            }
            if (Pattern.matches("[^1234567890\\-/:;()$&@“”\".,?!’\\[\\]{}#%^*+=_|~<>€£¥•]*$", newPixInputView2.getInputStr())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: j */
    private final boolean m25394j() {
        TextView textView = this.f33351g;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDateTv");
            textView = null;
        }
        CharSequence text = textView.getText();
        if ((text == null || text.length() == 0) || Intrinsics.areEqual((Object) text, (Object) getString(R.string.Fintech_Payment_Optimization_Day_month_tVPF))) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(text, "str");
        int parseInt = Integer.parseInt(text.subSequence(0, 2).toString());
        int parseInt2 = Integer.parseInt(text.subSequence(3, 5).toString());
        int parseInt3 = Integer.parseInt(text.subSequence(6, 10).toString());
        Calendar instance = Calendar.getInstance();
        int i = instance.get(1) - parseInt3;
        int i2 = (instance.get(2) + 1) - parseInt2;
        int i3 = instance.get(5) - parseInt;
        if (i <= 0) {
            return false;
        }
        if (i2 < 0 || (i2 == 0 && i3 < 0)) {
            i--;
        }
        if (i >= 18) {
            return true;
        }
        return false;
    }

    /* renamed from: k */
    private final void m25395k() {
        String string = getString(R.string.wallet_create_account_page_term_text);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.walle…e_account_page_term_text)");
        String string2 = getString(R.string.wallet_create_account_page_term_high_light_text);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.walle…age_term_high_light_text)");
        CharSequence charSequence = string;
        int indexOf$default = StringsKt.indexOf$default(charSequence, string2, 0, false, 6, (Object) null);
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new StepBaseInfoFragment$initTermView$clickableSpan$1(this), indexOf$default, string.length(), 18);
        TextView textView = this.f33352h;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTermTv");
            textView = null;
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView3 = this.f33352h;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTermTv");
            textView3 = null;
        }
        textView3.setHighlightColor(0);
        TextView textView4 = this.f33352h;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTermTv");
        } else {
            textView2 = textView4;
        }
        textView2.setText(spannableString);
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public final void m25396l() {
        PixGetApplyInfoResp.CPFInfo cPFInfo = this.f33360p;
        if ((cPFInfo == null ? null : cPFInfo.getTermsUrl()) != null && getActivity() != null) {
            NWRouter nWRouter = NWRouter.INSTANCE;
            FragmentActivity activity = getActivity();
            PixGetApplyInfoResp.CPFInfo cPFInfo2 = this.f33360p;
            Intrinsics.checkNotNull(cPFInfo2);
            nWRouter.gotoPDFPage(activity, cPFInfo2.getTermsUrl());
        }
    }

    /* renamed from: a */
    private final void m25382a(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 11) {
            NewPixInputView newPixInputView = this.f33350f;
            if (newPixInputView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
                newPixInputView = null;
            }
            newPixInputView.setInputStr(str);
        }
    }

    /* renamed from: b */
    private final Date m25385b(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
