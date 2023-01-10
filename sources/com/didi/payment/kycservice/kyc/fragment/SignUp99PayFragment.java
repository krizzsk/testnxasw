package com.didi.payment.kycservice.kyc.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.datadog.android.log.LogAttributes;
import com.didi.commoninterfacelib.permission.PermissionCallback;
import com.didi.commoninterfacelib.permission.PermissionContext;
import com.didi.commoninterfacelib.permission.PermissionUtil;
import com.didi.component.common.net.CarServerParam;
import com.didi.dimina.container.secondparty.trace.DiminaTraceService;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.base.utils.TextHighlightUtil;
import com.didi.payment.base.view.PayHomelandCityErrorView;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.commonsdk.p130ui.WBaseFragment;
import com.didi.payment.commonsdk.p130ui.WBaseViewModel;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.commonsdk.utils.NWRouter;
import com.didi.payment.commonsdk.utils.OmegaComParams;
import com.didi.payment.kycservice.kyc.SignUpVM;
import com.didi.payment.kycservice.kyc.fragment.StepBaseInfoFragment;
import com.didi.payment.kycservice.kyc.p134vm.PermissionData;
import com.didi.payment.kycservice.kyc.p134vm.SignUp99PayVM;
import com.didi.payment.kycservice.net.response.PixGetApplyInfoResp;
import com.didi.payment.kycservice.utils.CPFInputWatcher;
import com.didi.payment.kycservice.utils.KycRegisterUtils;
import com.didi.payment.kycservice.utils.KycSPUtils;
import com.didi.payment.kycservice.utils.ViewExtsKt;
import com.didi.payment.kycservice.widget.NewPixInputView;
import com.didi.payment.wallet_ui.dialog.WalletDialog;
import com.didi.payment.wallet_ui.wheel.OnTimeWheelClick;
import com.didi.payment.wallet_ui.wheel.TimeItemAdapter;
import com.didi.payment.wallet_ui.wheel.TimeWheelBuilder;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.diface.DiFace;
import com.didichuxing.diface.DiFaceParam;
import com.didichuxing.diface.DiFaceResult;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 U2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001UB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020(H\u0002J\u0018\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0002J\u0010\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020,H\u0002J\b\u00100\u001a\u00020(H\u0002J\n\u00101\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u00102\u001a\u00020,H\u0002J\b\u00103\u001a\u00020(H\u0002J\b\u00104\u001a\u00020(H\u0002J\b\u00105\u001a\u00020(H\u0002J\b\u00106\u001a\u00020(H\u0002J\u0010\u00107\u001a\u00020(2\u0006\u00108\u001a\u00020\u0011H\u0002J\b\u00109\u001a\u00020&H\u0002J\b\u0010:\u001a\u00020&H\u0002J\b\u0010;\u001a\u00020&H\u0002J&\u0010<\u001a\u0004\u0018\u00010\u00112\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u000e2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010B\u001a\u00020(H\u0016J\u001a\u0010C\u001a\u00020(2\u0006\u0010D\u001a\u00020\u00112\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u0012\u0010E\u001a\u0004\u0018\u00010\u001c2\u0006\u0010F\u001a\u00020,H\u0002J\b\u0010G\u001a\u00020(H\u0002J\u0010\u0010H\u001a\u00020(2\u0006\u0010I\u001a\u00020\nH\u0002J\u0010\u0010J\u001a\u00020(2\u0006\u0010K\u001a\u00020LH\u0002J\u0006\u0010M\u001a\u00020(J\b\u0010N\u001a\u00020(H\u0002J\u0010\u0010O\u001a\u00020(2\u0006\u0010P\u001a\u00020\u0002H\u0016J\u0010\u0010Q\u001a\u00020(2\u0006\u0010R\u001a\u00020SH\u0002J\b\u0010T\u001a\u00020(H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X.¢\u0006\u0002\n\u0000¨\u0006V"}, mo148868d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/SignUp99PayFragment;", "Lcom/didi/payment/commonsdk/ui/WBaseFragment;", "Lcom/didi/payment/kycservice/kyc/vm/SignUp99PayVM;", "()V", "curFragment", "Landroidx/fragment/app/Fragment;", "mActivityTv", "Landroid/widget/TextView;", "mAgeErrorTv", "mCPFInfo", "Lcom/didi/payment/kycservice/net/response/PixGetApplyInfoResp$CPFInfo;", "mCPFInput", "Lcom/didi/payment/kycservice/widget/NewPixInputView;", "mContentView", "Landroid/view/ViewGroup;", "mDateTv", "mDividerView", "Landroid/view/View;", "mErrorContentView", "mErrorViewStub", "Landroid/view/ViewStub;", "mFaceGuideView", "mFacesVerify", "mMainTitleTv", "mNameInput", "mPreBtn", "Landroid/widget/ImageView;", "mSelectDate", "Ljava/util/Date;", "mSubTitleTv", "mSubmitBtn", "mTermCb", "Landroid/widget/CheckBox;", "mTermTv", "mTvAgeTitle", "pixSignUpVM", "Lcom/didi/payment/kycservice/kyc/SignUpVM;", "checkInputInfo", "", "closeKeyboard", "", "configTimePicker", "doFaceCreate", "bizCode", "", "sessionId", "fillCPFInput", "taxId", "fillInfoFromSP", "getTitleBarView", "getUpLoadTime", "gotoTermPage", "hideErrorPage", "initListener", "initTermView", "initView", "rootView", "isValidAge", "isValidCPF", "isValidName", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "parseDateString", "text", "requestLocationPermission", "showData", "data", "showErrorPage", "locationResultData", "Lcom/didi/payment/kycservice/kyc/vm/PermissionData;", "showHomelandCityErrorPage", "submitKycInfoV1", "subscribeUi", "vm", "trackTableContentCk", "type", "", "updateSubmitBtn", "Companion", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SignUp99PayFragment.kt */
public final class SignUp99PayFragment extends WBaseFragment<SignUp99PayVM> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: w */
    private static final int f33287w = 14;

    /* renamed from: x */
    private static final int f33288x = 18;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ViewGroup f33289a;

    /* renamed from: b */
    private TextView f33290b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public NewPixInputView f33291c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public NewPixInputView f33292d;

    /* renamed from: e */
    private TextView f33293e;

    /* renamed from: f */
    private TextView f33294f;

    /* renamed from: g */
    private TextView f33295g;

    /* renamed from: h */
    private TextView f33296h;

    /* renamed from: i */
    private TextView f33297i;

    /* renamed from: j */
    private TextView f33298j;

    /* renamed from: k */
    private CheckBox f33299k;

    /* renamed from: l */
    private ViewStub f33300l;

    /* renamed from: m */
    private View f33301m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public View f33302n;

    /* renamed from: o */
    private View f33303o;

    /* renamed from: p */
    private ImageView f33304p;

    /* renamed from: q */
    private View f33305q;

    /* renamed from: r */
    private TextView f33306r;

    /* renamed from: s */
    private Date f33307s;

    /* renamed from: t */
    private PixGetApplyInfoResp.CPFInfo f33308t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public SignUpVM f33309u;

    /* renamed from: v */
    private Fragment f33310v;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m25324a(Date date) {
        return true;
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return null;
    }

    @Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo148868d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/SignUp99PayFragment$Companion;", "", "()V", "CPF_LENGTH", "", "LEGAL_AGE", "newInstance", "Lcom/didi/payment/kycservice/kyc/fragment/SignUp99PayFragment;", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: SignUp99PayFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SignUp99PayFragment newInstance() {
            return new SignUp99PayFragment();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_common_sign_up_99pay, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewModel viewModel = new ViewModelProvider(requireActivity()).get(SignUpVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir…get(SignUpVM::class.java)");
        this.f33309u = (SignUpVM) viewModel;
        OmegaComParams.Companion.setPubPage(OmegaComParams.PRIMARY_KYC);
        m25307a(view);
        m25326b();
        m25305a();
        m25344k();
        ViewModel viewModel2 = new ViewModelProvider(this).get(SignUp99PayVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(this).…ignUp99PayVM::class.java)");
        setVm((WBaseViewModel) viewModel2);
        subscribeUi((SignUp99PayVM) getVm());
    }

    public void onDestroyView() {
        super.onDestroyView();
        OmegaComParams.Companion.setPUB_FROM_PAGE(OmegaComParams.PRIMARY_KYC);
    }

    public void subscribeUi(SignUp99PayVM signUp99PayVM) {
        Intrinsics.checkNotNullParameter(signUp99PayVM, "vm");
        signUp99PayVM.getPermissionData().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                SignUp99PayFragment.m25310a(SignUp99PayFragment.this, (PermissionData) obj);
            }
        });
        signUp99PayVM.getCpfinfo().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                SignUp99PayFragment.m25312a(SignUp99PayFragment.this, (PixGetApplyInfoResp.CPFInfo) obj);
            }
        });
        signUp99PayVM.isLoading().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                SignUp99PayFragment.m25314a(SignUp99PayFragment.this, (Boolean) obj);
            }
        });
        signUp99PayVM.getBShowHomelandCityErrorPage().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                SignUp99PayFragment.m25328b(SignUp99PayFragment.this, (Boolean) obj);
            }
        });
        signUp99PayVM.getBFinishCreateAccount().observe(getViewLifecycleOwner(), new Observer(signUp99PayVM) {
            public final /* synthetic */ SignUp99PayVM f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                SignUp99PayFragment.m25311a(SignUp99PayFragment.this, this.f$1, (Boolean) obj);
            }
        });
        signUp99PayVM.getErrorMsg().observe(getViewLifecycleOwner(), $$Lambda$SignUp99PayFragment$APeLs2NgDoLG6FJEnf5rXO74F0.INSTANCE);
        signUp99PayVM.getBizCode().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                SignUp99PayFragment.m25315a(SignUp99PayFragment.this, (String) obj);
            }
        });
        signUp99PayVM.getSessionId().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                SignUp99PayFragment.m25329b(SignUp99PayFragment.this, (String) obj);
            }
        });
        signUp99PayVM.getNextStepData().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                SignUp99PayFragment.m25309a(SignUp99PayFragment.this, (KycFormStep) obj);
            }
        });
        signUp99PayVM.getPreStepData().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                SignUp99PayFragment.m25332c(SignUp99PayFragment.this, (Boolean) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25310a(SignUp99PayFragment signUp99PayFragment, PermissionData permissionData) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        if (permissionData == null) {
            signUp99PayFragment.m25334d();
        } else {
            signUp99PayFragment.m25318a(permissionData);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25312a(SignUp99PayFragment signUp99PayFragment, PixGetApplyInfoResp.CPFInfo cPFInfo) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(cPFInfo, "it");
        signUp99PayFragment.m25320a(cPFInfo);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25314a(SignUp99PayFragment signUp99PayFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        SignUpVM signUpVM = signUp99PayFragment.f33309u;
        if (signUpVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM = null;
        }
        signUpVM.isLoading().setValue(bool);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m25328b(SignUp99PayFragment signUp99PayFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "isShow");
        if (bool.booleanValue()) {
            signUp99PayFragment.showHomelandCityErrorPage();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25311a(SignUp99PayFragment signUp99PayFragment, SignUp99PayVM signUp99PayVM, Boolean bool) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        Intrinsics.checkNotNullParameter(signUp99PayVM, "$vm");
        Intrinsics.checkNotNullExpressionValue(bool, "isFinish");
        if (bool.booleanValue()) {
            SignUpVM signUpVM = signUp99PayFragment.f33309u;
            ViewGroup viewGroup = null;
            if (signUpVM == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                signUpVM = null;
            }
            if (!Intrinsics.areEqual((Object) signUpVM.getPageSource(), (Object) "1") || ((SignUp99PayVM) signUp99PayFragment.getVm()).getResultPageData() == null) {
                SignUpVM signUpVM2 = signUp99PayFragment.f33309u;
                if (signUpVM2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                    signUpVM2 = null;
                }
                signUpVM2.setFromPrimary(1);
                SignUpVM signUpVM3 = signUp99PayFragment.f33309u;
                if (signUpVM3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                    signUpVM3 = null;
                }
                if (signUpVM3.updatePageSceneByStepList() && (activity = signUp99PayFragment.getActivity()) != null) {
                    activity.finish();
                }
            } else {
                KycRegisterUtils.INSTANCE.go2PixSignUpResultPage(signUp99PayFragment.getActivity(), ((SignUp99PayVM) signUp99PayFragment.getVm()).getResultPageData());
            }
            SignUpVM signUpVM4 = signUp99PayFragment.f33309u;
            if (signUpVM4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                signUpVM4 = null;
            }
            if (signUpVM4.isNewStep() && signUp99PayVM.isInfoComplete()) {
                if (signUp99PayFragment.getChildFragmentManager().getBackStackEntryCount() > 0) {
                    signUp99PayFragment.getChildFragmentManager().popBackStackImmediate((String) null, 1);
                }
                ViewGroup viewGroup2 = signUp99PayFragment.f33289a;
                if (viewGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContentView");
                } else {
                    viewGroup = viewGroup2;
                }
                viewGroup.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m25333c(String str) {
        Map linkedHashMap = new LinkedHashMap();
        Intrinsics.checkNotNullExpressionValue(str, "it");
        linkedHashMap.put("error_message", str);
        KycOmega.Companion.trackEvent("fin_primarykycinformation_toast_sw", linkedHashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25315a(SignUp99PayFragment signUp99PayFragment, String str) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        ViewGroup viewGroup = signUp99PayFragment.f33289a;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            viewGroup = null;
        }
        viewGroup.setVisibility(8);
        View view = signUp99PayFragment.f33302n;
        if (view != null) {
            view.setVisibility(0);
        }
        SignUpVM signUpVM = signUp99PayFragment.f33309u;
        if (signUpVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM = null;
        }
        if (signUpVM.isNewStep()) {
            ImageView imageView = signUp99PayFragment.f33304p;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            View view2 = signUp99PayFragment.f33305q;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            SignUpVM signUpVM2 = signUp99PayFragment.f33309u;
            if (signUpVM2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                signUpVM2 = null;
            }
            signUpVM2.updateStepProgress(KycFormStep.STEP_PRIMARY_FACE);
            if (signUp99PayFragment.getChildFragmentManager().getBackStackEntryCount() > 0) {
                signUp99PayFragment.getChildFragmentManager().popBackStackImmediate((String) null, 1);
            }
        } else {
            ImageView imageView2 = signUp99PayFragment.f33304p;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            View view3 = signUp99PayFragment.f33305q;
            if (view3 != null) {
                view3.setVisibility(0);
            }
        }
        OmegaComParams.Companion.setPubPage(OmegaComParams.FACE_GUIDE);
        KycOmega.Companion.trackEvent("fin_faceguide_sw");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m25329b(SignUp99PayFragment signUp99PayFragment, String str) {
        String value;
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        if (str != null && (value = ((SignUp99PayVM) signUp99PayFragment.getVm()).getBizCode().getValue()) != null) {
            signUp99PayFragment.m25322a(value, str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25309a(SignUp99PayFragment signUp99PayFragment, KycFormStep kycFormStep) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        StepBaseInfoFragment.Companion companion = StepBaseInfoFragment.Companion;
        Intrinsics.checkNotNullExpressionValue(kycFormStep, DiminaTraceService.MAS_MONITOR_EVENT.KEY.STEP);
        SignUpVM signUpVM = signUp99PayFragment.f33309u;
        if (signUpVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM = null;
        }
        Fragment newInstance = companion.newInstance(kycFormStep, signUpVM.getPageSource());
        signUp99PayFragment.f33310v = newInstance;
        if (newInstance != null) {
            String str = newInstance.getClass().getSimpleName() + '_' + kycFormStep;
            signUp99PayFragment.getChildFragmentManager().beginTransaction().add(R.id.sign_up_fragment_container, newInstance, str).addToBackStack(str).commitAllowingStateLoss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m25332c(SignUp99PayFragment signUp99PayFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        if (signUp99PayFragment.getChildFragmentManager().getBackStackEntryCount() > 0) {
            signUp99PayFragment.getChildFragmentManager().popBackStack();
        }
        signUp99PayFragment.m25326b();
    }

    /* renamed from: a */
    private final void m25322a(String str, String str2) {
        DiFaceParam diFaceParam = new DiFaceParam();
        diFaceParam.setBizCode(Integer.parseInt(str));
        diFaceParam.setSessionId(str2);
        diFaceParam.setToken(PayBaseParamUtil.getStringParam(getActivity(), "token"));
        DiFace.startFaceRecognition(diFaceParam, new DiFace.IDiFaceCallback() {
            public final void onResult(DiFaceResult diFaceResult) {
                SignUp99PayFragment.m25313a(SignUp99PayFragment.this, diFaceResult);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25313a(SignUp99PayFragment signUp99PayFragment, DiFaceResult diFaceResult) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        if (diFaceResult.getCode() != 102) {
            ((SignUp99PayVM) signUp99PayFragment.getVm()).getFaceResult();
        }
    }

    /* renamed from: a */
    private final void m25307a(View view) {
        this.f33302n = view.findViewById(R.id.face_guide_layout);
        this.f33303o = view.findViewById(R.id.face_guide_confirm_btn);
        View findViewById = view.findViewById(R.id.rl_wallet_account_apply_content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.…et_account_apply_content)");
        this.f33289a = (ViewGroup) findViewById;
        View findViewById2 = view.findViewById(R.id.wallet_account_appply_title_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.…_account_appply_title_tv)");
        this.f33297i = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.wallet_account_appply_sub_title_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.…ount_appply_sub_title_tv)");
        this.f33298j = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.wallet_account_appply_age_title);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.…account_appply_age_title)");
        this.f33290b = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.wallet_account_appply_name_input);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.…ccount_appply_name_input)");
        this.f33291c = (NewPixInputView) findViewById5;
        View findViewById6 = view.findViewById(R.id.wallet_account_appply_cpf_input);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.…account_appply_cpf_input)");
        this.f33292d = (NewPixInputView) findViewById6;
        View findViewById7 = view.findViewById(R.id.wallet_account_appply_age_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.…et_account_appply_age_tv)");
        this.f33293e = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.wallet_account_appply_term_cb);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.…t_account_appply_term_cb)");
        this.f33299k = (CheckBox) findViewById8;
        View findViewById9 = view.findViewById(R.id.wallet_account_appply_term_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "rootView.findViewById(R.…t_account_appply_term_tv)");
        this.f33294f = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.wallet_account_activity_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "rootView.findViewById(R.…llet_account_activity_tv)");
        this.f33296h = (TextView) findViewById10;
        View findViewById11 = view.findViewById(R.id.wallet_account_appply_submit_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "rootView.findViewById(R.…ccount_appply_submit_btn)");
        this.f33295g = (TextView) findViewById11;
        View findViewById12 = view.findViewById(R.id.wallet_account_apply_vs);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "rootView.findViewById(R.….wallet_account_apply_vs)");
        this.f33300l = (ViewStub) findViewById12;
        View findViewById13 = view.findViewById(R.id.tv_age_error_info);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "rootView.findViewById(R.id.tv_age_error_info)");
        this.f33306r = (TextView) findViewById13;
        this.f33304p = (ImageView) view.findViewById(R.id.btn_pre_page);
        this.f33305q = view.findViewById(R.id.divider_view);
        SignUpVM signUpVM = this.f33309u;
        NewPixInputView newPixInputView = null;
        if (signUpVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM = null;
        }
        if (Intrinsics.areEqual((Object) signUpVM.getPageSource(), (Object) "1")) {
            TextView textView = this.f33295g;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSubmitBtn");
                textView = null;
            }
            textView.setText(getString(R.string.Fintech_Payment_Optimization_Submission_hMgW));
        } else {
            TextView textView2 = this.f33295g;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSubmitBtn");
                textView2 = null;
            }
            textView2.setText(getString(R.string.Fintech_Payment_Optimization_Next_step_SRDJ));
        }
        TextView textView3 = this.f33295g;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSubmitBtn");
            textView3 = null;
        }
        textView3.setEnabled(false);
        TextView textView4 = this.f33290b;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvAgeTitle");
            textView4 = null;
        }
        textView4.setText(TextHighlightUtil.highlight(getString(R.string.kyc_create_account_page_input_age), Color.parseColor("#999999"), Color.parseColor("#FF0000")));
        CharSequence highlight = TextHighlightUtil.highlight(getString(R.string.kyc_create_account_page_input_name), Color.parseColor("#999999"), Color.parseColor("#FF0000"));
        NewPixInputView newPixInputView2 = this.f33291c;
        if (newPixInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNameInput");
            newPixInputView2 = null;
        }
        Intrinsics.checkNotNullExpressionValue(highlight, "nameTitle");
        newPixInputView2.initData(highlight, 120, 1);
        CharSequence highlight2 = TextHighlightUtil.highlight(getString(R.string.kyc_create_account_page_input_cpf), Color.parseColor("#999999"), Color.parseColor("#FF0000"));
        NewPixInputView newPixInputView3 = this.f33292d;
        if (newPixInputView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
        } else {
            newPixInputView = newPixInputView3;
        }
        Intrinsics.checkNotNullExpressionValue(highlight2, "cpfTitle");
        newPixInputView.initData(highlight2, 14, 2, "000.000.000-00");
        KycOmega.Companion.trackEvent("gp_99pay_information_vew_sw");
    }

    /* renamed from: a */
    private final void m25305a() {
        String stringParam = PayBaseParamUtil.getStringParam(getContext(), "phone");
        TextView textView = this.f33293e;
        CheckBox checkBox = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDateTv");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SignUp99PayFragment.m25308a(SignUp99PayFragment.this, view);
            }
        });
        TextView textView2 = this.f33295g;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSubmitBtn");
            textView2 = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SignUp99PayFragment.m25327b(SignUp99PayFragment.this, view);
            }
        });
        ImageView imageView = this.f33304p;
        if (imageView != null) {
            ViewExtsKt.click(imageView, new SignUp99PayFragment$initListener$3(this));
        }
        NewPixInputView newPixInputView = this.f33291c;
        if (newPixInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNameInput");
            newPixInputView = null;
        }
        newPixInputView.setEditTextClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SignUp99PayFragment.m25331c(SignUp99PayFragment.this, view);
            }
        });
        NewPixInputView newPixInputView2 = this.f33292d;
        if (newPixInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
            newPixInputView2 = null;
        }
        newPixInputView2.setEditTextClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SignUp99PayFragment.m25335d(SignUp99PayFragment.this, view);
            }
        });
        NewPixInputView newPixInputView3 = this.f33292d;
        if (newPixInputView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
            newPixInputView3 = null;
        }
        newPixInputView3.setAfterTextChangedListener(new SignUp99PayFragment$initListener$6(this));
        NewPixInputView newPixInputView4 = this.f33292d;
        if (newPixInputView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
            newPixInputView4 = null;
        }
        NewPixInputView newPixInputView5 = this.f33292d;
        if (newPixInputView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
            newPixInputView5 = null;
        }
        newPixInputView4.addTextChangeListener(new CPFInputWatcher(newPixInputView5.getEditText()));
        NewPixInputView newPixInputView6 = this.f33291c;
        if (newPixInputView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNameInput");
            newPixInputView6 = null;
        }
        newPixInputView6.setAfterTextChangedListener(new SignUp99PayFragment$initListener$7(this));
        NewPixInputView newPixInputView7 = this.f33291c;
        if (newPixInputView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNameInput");
            newPixInputView7 = null;
        }
        newPixInputView7.setOnLoseFocus(new SignUp99PayFragment$initListener$8(this, stringParam));
        NewPixInputView newPixInputView8 = this.f33292d;
        if (newPixInputView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
            newPixInputView8 = null;
        }
        newPixInputView8.setOnLoseFocus(new SignUp99PayFragment$initListener$9(this, stringParam));
        CheckBox checkBox2 = this.f33299k;
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
                SignUp99PayFragment.m25317a(SignUp99PayFragment.this, this.f$1, compoundButton, z);
            }
        });
        View view = this.f33303o;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    SignUp99PayFragment.m25337e(SignUp99PayFragment.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25308a(SignUp99PayFragment signUp99PayFragment, View view) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        signUp99PayFragment.m25306a(2);
        signUp99PayFragment.m25330c();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m25327b(SignUp99PayFragment signUp99PayFragment, View view) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        KycOmega.Companion.trackEvent("gp_99pay_information_submit_ck");
        signUp99PayFragment.m25306a(4);
        signUp99PayFragment.m25346m();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m25331c(SignUp99PayFragment signUp99PayFragment, View view) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        signUp99PayFragment.m25306a(1);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static final void m25335d(SignUp99PayFragment signUp99PayFragment, View view) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        signUp99PayFragment.m25306a(3);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25317a(SignUp99PayFragment signUp99PayFragment, String str, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        signUp99PayFragment.m25338f();
        KycOmega.Companion.trackEvent("gp_99pay_information_clause_ck");
        Context context = signUp99PayFragment.getContext();
        if (context != null) {
            KycSPUtils.Companion companion = KycSPUtils.Companion;
            Intrinsics.checkNotNullExpressionValue(str, "phone");
            companion.setCheckedTc(context, str, z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static final void m25337e(SignUp99PayFragment signUp99PayFragment, View view) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        KycOmega.Companion.trackButtonEvent("fin_faceguide_button_ck", 1);
        ((SignUp99PayVM) signUp99PayFragment.getVm()).getFaceSession();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m25326b() {
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
                NewPixInputView newPixInputView = this.f33291c;
                if (newPixInputView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNameInput");
                    newPixInputView = null;
                }
                newPixInputView.setInputStr(name);
            }
            CharSequence charSequence2 = birthday;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                TextView textView = this.f33293e;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDateTv");
                    textView = null;
                }
                textView.setText(charSequence2);
                TextView textView2 = this.f33293e;
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
                            this.f33307s = m25325b(substring3 + '-' + substring2 + '-' + substring);
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
                TextView textView3 = this.f33293e;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDateTv");
                    textView3 = null;
                }
                textView3.setText(getString(R.string.Fintech_Payment_Optimization_Day_month_tVPF));
                TextView textView4 = this.f33293e;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDateTv");
                    textView4 = null;
                }
                textView4.setTextColor(Color.parseColor("#999999"));
            }
            CharSequence charSequence3 = cpf;
            if (!(charSequence3 == null || charSequence3.length() == 0)) {
                NewPixInputView newPixInputView2 = this.f33292d;
                if (newPixInputView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
                    newPixInputView2 = null;
                }
                newPixInputView2.setInputStr(cpf);
            }
            CheckBox checkBox2 = this.f33299k;
            if (checkBox2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTermCb");
            } else {
                checkBox = checkBox2;
            }
            if (KycSPUtils.Companion.isCheckedTc(context, stringParam)) {
                z = true;
            }
            checkBox.setChecked(z);
            m25338f();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0105, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0.getText(), (java.lang.Object) getString(com.taxis99.R.string.Fintech_Payment_Optimization_Day_month_tVPF)) != false) goto L_0x0107;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m25320a(com.didi.payment.kycservice.net.response.PixGetApplyInfoResp.CPFInfo r7) {
        /*
            r6 = this;
            com.didi.payment.kycservice.kyc.SignUpVM r0 = r6.f33309u
            java.lang.String r1 = "pixSignUpVM"
            r2 = 0
            if (r0 != 0) goto L_0x000b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x000b:
            boolean r0 = r0.isNewStep()
            r3 = 8
            java.lang.String r4 = "mContentView"
            r5 = 0
            if (r0 == 0) goto L_0x0039
            com.didi.payment.commonsdk.ui.WBaseViewModel r0 = r6.getVm()
            com.didi.payment.kycservice.kyc.vm.SignUp99PayVM r0 = (com.didi.payment.kycservice.kyc.p134vm.SignUp99PayVM) r0
            boolean r0 = r0.isInfoComplete()
            if (r0 == 0) goto L_0x0039
            android.view.ViewGroup r0 = r6.f33289a
            if (r0 != 0) goto L_0x002a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r0 = r2
        L_0x002a:
            r0.setVisibility(r3)
            com.didi.payment.commonsdk.ui.WBaseViewModel r0 = r6.getVm()
            com.didi.payment.kycservice.kyc.vm.SignUp99PayVM r0 = (com.didi.payment.kycservice.kyc.p134vm.SignUp99PayVM) r0
            com.didi.payment.kycservice.kyc.fragment.KycFormStep r1 = com.didi.payment.kycservice.kyc.fragment.KycFormStep.STEP_NAME
            r0.onNextClick(r1)
            goto L_0x0051
        L_0x0039:
            android.view.ViewGroup r0 = r6.f33289a
            if (r0 != 0) goto L_0x0041
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r0 = r2
        L_0x0041:
            r0.setVisibility(r5)
            com.didi.payment.kycservice.kyc.SignUpVM r0 = r6.f33309u
            if (r0 != 0) goto L_0x004c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x004c:
            com.didi.payment.kycservice.kyc.fragment.KycFormStep r1 = com.didi.payment.kycservice.kyc.fragment.KycFormStep.STEP_CPF
            r0.updateStepProgress(r1)
        L_0x0051:
            android.view.View r0 = r6.f33301m
            if (r0 == 0) goto L_0x005b
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r0.setVisibility(r3)
        L_0x005b:
            r6.f33308t = r7
            java.lang.String r0 = r7.getName()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 1
            if (r0 != 0) goto L_0x0097
            com.didi.payment.kycservice.widget.NewPixInputView r0 = r6.f33291c
            java.lang.String r3 = "mNameInput"
            if (r0 != 0) goto L_0x0074
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r2
        L_0x0074:
            java.lang.String r0 = r0.getInputStr()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0082
            r0 = 1
            goto L_0x0083
        L_0x0082:
            r0 = 0
        L_0x0083:
            if (r0 == 0) goto L_0x0097
            com.didi.payment.kycservice.widget.NewPixInputView r0 = r6.f33291c
            if (r0 != 0) goto L_0x008d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r2
        L_0x008d:
            java.lang.String r3 = r7.getName()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r0.setInputStr(r3)
        L_0x0097:
            java.lang.String r0 = r7.getTaxId()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00c8
            com.didi.payment.kycservice.widget.NewPixInputView r0 = r6.f33292d
            if (r0 != 0) goto L_0x00ad
            java.lang.String r0 = "mCPFInput"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = r2
        L_0x00ad:
            java.lang.String r0 = r0.getInputStr()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00bb
            r0 = 1
            goto L_0x00bc
        L_0x00bb:
            r0 = 0
        L_0x00bc:
            if (r0 == 0) goto L_0x00c8
            java.lang.String r0 = r7.getTaxId()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r6.m25321a((java.lang.String) r0)
        L_0x00c8:
            java.lang.String r0 = r7.getBirthdate()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0143
            android.widget.TextView r0 = r6.f33293e
            java.lang.String r3 = "mDateTv"
            if (r0 != 0) goto L_0x00de
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r2
        L_0x00de:
            java.lang.CharSequence r0 = r0.getText()
            if (r0 == 0) goto L_0x00ec
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00eb
            goto L_0x00ec
        L_0x00eb:
            r1 = 0
        L_0x00ec:
            if (r1 != 0) goto L_0x0107
            android.widget.TextView r0 = r6.f33293e
            if (r0 != 0) goto L_0x00f6
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r2
        L_0x00f6:
            java.lang.CharSequence r0 = r0.getText()
            r1 = 2131951760(0x7f130090, float:1.9539944E38)
            java.lang.String r1 = r6.getString(r1)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x0143
        L_0x0107:
            java.lang.String r0 = r7.getBirthdate()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.util.Date r0 = r6.m25325b(r0)
            if (r0 == 0) goto L_0x0143
            r6.f33307s = r0
            android.widget.TextView r0 = r6.f33293e
            if (r0 != 0) goto L_0x011e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r2
        L_0x011e:
            java.lang.String r1 = "#000000"
            int r1 = android.graphics.Color.parseColor(r1)
            r0.setTextColor(r1)
            android.widget.TextView r0 = r6.f33293e
            if (r0 != 0) goto L_0x012f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r2
        L_0x012f:
            com.didi.payment.commonsdk.ui.WBaseViewModel r1 = r6.getVm()
            com.didi.payment.kycservice.kyc.vm.SignUp99PayVM r1 = (com.didi.payment.kycservice.kyc.p134vm.SignUp99PayVM) r1
            java.util.Date r3 = r6.f33307s
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.String r1 = r1.getShowTime(r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x0143:
            com.didi.payment.kycservice.net.response.PixGetApplyInfoResp$PromotionActivity r0 = r7.getPromotionRule()
            if (r0 == 0) goto L_0x01b0
            com.didi.payment.kycservice.net.response.PixGetApplyInfoResp$PromotionActivity r0 = r7.getPromotionRule()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r0 = r0.getText()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01b0
            com.didi.payment.kycservice.net.response.PixGetApplyInfoResp$PromotionActivity r0 = r7.getPromotionRule()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r0 = r0.getUrl()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01b0
            android.widget.TextView r0 = r6.f33296h
            java.lang.String r1 = "mActivityTv"
            if (r0 != 0) goto L_0x0179
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x0179:
            r0.setVisibility(r5)
            android.widget.TextView r0 = r6.f33296h
            if (r0 != 0) goto L_0x0184
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x0184:
            com.didi.payment.kycservice.net.response.PixGetApplyInfoResp$PromotionActivity r3 = r7.getPromotionRule()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.String r3 = r3.getText()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            com.didi.payment.kycservice.net.response.PixGetApplyInfoResp$PromotionActivity r7 = r7.getPromotionRule()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            java.lang.String r7 = r7.getUrl()
            android.widget.TextView r0 = r6.f33296h
            if (r0 != 0) goto L_0x01a7
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x01a8
        L_0x01a7:
            r2 = r0
        L_0x01a8:
            com.didi.payment.kycservice.kyc.fragment.-$$Lambda$SignUp99PayFragment$Jtiqm4Y1FvvlSP6nAeNKQS5sWSs r0 = new com.didi.payment.kycservice.kyc.fragment.-$$Lambda$SignUp99PayFragment$Jtiqm4Y1FvvlSP6nAeNKQS5sWSs
            r0.<init>(r7)
            r2.setOnClickListener(r0)
        L_0x01b0:
            r6.m25338f()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.kycservice.kyc.fragment.SignUp99PayFragment.m25320a(com.didi.payment.kycservice.net.response.PixGetApplyInfoResp$CPFInfo):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25316a(SignUp99PayFragment signUp99PayFragment, String str, View view) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        WebBrowserUtil.startInternalWebActivity(signUp99PayFragment.getContext(), str, "");
    }

    /* renamed from: c */
    private final void m25330c() {
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
                    return SignUp99PayFragment.m25304a(this.f$0, i, i2);
                }
            });
            Calendar instance2 = Calendar.getInstance();
            Date date = this.f33307s;
            if (date != null) {
                Intrinsics.checkNotNull(date);
                instance2.setTime(date);
            } else {
                instance2.set(1990, 0, 1);
            }
            timeWheelBuilder.setSelectedDate(instance2.getTime());
            timeWheelBuilder.setKeepLastSelected(true);
            timeWheelBuilder.setShowDelete(false);
            timeWheelBuilder.setCancelClick($$Lambda$SignUp99PayFragment$fRfQt4PGENMbU0YqskEkG38dzug.INSTANCE);
            timeWheelBuilder.setConfirmClick(new OnTimeWheelClick(context) {
                public final /* synthetic */ Context f$1;

                {
                    this.f$1 = r2;
                }

                public final boolean onClick(Date date) {
                    return SignUp99PayFragment.m25323a(SignUp99PayFragment.this, this.f$1, date);
                }
            });
            Unit unit = Unit.INSTANCE;
            SystemUtils.showDialog(WalletDialog.Companion.configDateWheel$default(companion, context, timeWheelBuilder, false, false, 12, (Object) null));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final String m25304a(String[] strArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(strArr, "$months");
        if (i == 2) {
            return strArr[i2 - 1];
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m25323a(SignUp99PayFragment signUp99PayFragment, Context context, Date date) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        Intrinsics.checkNotNullParameter(context, "$ctx");
        signUp99PayFragment.f33307s = date;
        TextView textView = signUp99PayFragment.f33293e;
        NewPixInputView newPixInputView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDateTv");
            textView = null;
        }
        Intrinsics.checkNotNullExpressionValue(date, LogAttributes.DATE);
        textView.setText(((SignUp99PayVM) signUp99PayFragment.getVm()).getShowTime(date));
        TextView textView2 = signUp99PayFragment.f33293e;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDateTv");
            textView2 = null;
        }
        textView2.setTextColor(Color.parseColor("#000000"));
        if (signUp99PayFragment.m25343j()) {
            TextView textView3 = signUp99PayFragment.f33306r;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAgeErrorTv");
                textView3 = null;
            }
            textView3.setVisibility(8);
            KycSPUtils.Companion companion = KycSPUtils.Companion;
            String stringParam = PayBaseParamUtil.getStringParam(context, "phone");
            Intrinsics.checkNotNullExpressionValue(stringParam, "getStringParam(ctx, PayParam.PHONE)");
            TextView textView4 = signUp99PayFragment.f33293e;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDateTv");
                textView4 = null;
            }
            companion.putBirthday(context, stringParam, textView4.getText().toString());
        } else {
            TextView textView5 = signUp99PayFragment.f33306r;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAgeErrorTv");
                textView5 = null;
            }
            textView5.setVisibility(0);
            TextView textView6 = signUp99PayFragment.f33306r;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAgeErrorTv");
                textView6 = null;
            }
            textView6.setText(signUp99PayFragment.getString(R.string.Fintech_Payment_Optimization_Unregistered_until_gAeR));
        }
        signUp99PayFragment.m25338f();
        NewPixInputView newPixInputView2 = signUp99PayFragment.f33292d;
        if (newPixInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
        } else {
            newPixInputView = newPixInputView2;
        }
        newPixInputView.getEditText().requestFocus();
        return true;
    }

    /* renamed from: a */
    private final void m25318a(PermissionData permissionData) {
        ViewGroup viewGroup = null;
        if (this.f33301m == null) {
            ViewStub viewStub = this.f33300l;
            if (viewStub == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mErrorViewStub");
                viewStub = null;
            }
            this.f33301m = viewStub.inflate();
        }
        ViewGroup viewGroup2 = this.f33289a;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
        } else {
            viewGroup = viewGroup2;
        }
        viewGroup.setVisibility(8);
        View view = this.f33301m;
        Intrinsics.checkNotNull(view);
        view.setVisibility(0);
        View view2 = this.f33301m;
        Intrinsics.checkNotNull(view2);
        View findViewById = view2.findViewById(R.id.tv_account_apply_error_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mErrorContentView!!.find…ccount_apply_error_title)");
        TextView textView = (TextView) findViewById;
        View view3 = this.f33301m;
        Intrinsics.checkNotNull(view3);
        View findViewById2 = view3.findViewById(R.id.ll_account_apply_retry);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mErrorContentView!!.find…d.ll_account_apply_retry)");
        View view4 = this.f33301m;
        Intrinsics.checkNotNull(view4);
        View findViewById3 = view4.findViewById(R.id.tv_account_apply_setting);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mErrorContentView!!.find…tv_account_apply_setting)");
        TextView textView2 = (TextView) findViewById3;
        if (!permissionData.getHasGetCityId()) {
            textView.setText(R.string.wallet_account_location_failed_title);
            findViewById2.setVisibility(0);
            textView2.setVisibility(8);
            findViewById2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    SignUp99PayFragment.m25339f(SignUp99PayFragment.this, view);
                }
            });
            return;
        }
        textView.setText(R.string.wallet_account_location_none_title);
        findViewById2.setVisibility(8);
        textView2.setVisibility(0);
        textView2.setOnClickListener(new View.OnClickListener(this) {
            public final /* synthetic */ SignUp99PayFragment f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                SignUp99PayFragment.m25319a(PermissionData.this, this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static final void m25339f(SignUp99PayFragment signUp99PayFragment, View view) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        ((SignUp99PayVM) signUp99PayFragment.getVm()).requestLocationOnce();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25319a(PermissionData permissionData, SignUp99PayFragment signUp99PayFragment, View view) {
        Intrinsics.checkNotNullParameter(permissionData, "$locationResultData");
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        if (!permissionData.getHasGranted()) {
            signUp99PayFragment.m25336e();
        }
        if (!permissionData.getHasLocEnable()) {
            signUp99PayFragment.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            FragmentActivity activity = signUp99PayFragment.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* renamed from: d */
    private final void m25334d() {
        View view = this.f33301m;
        if (view != null) {
            view.setVisibility(8);
        }
        SignUpVM signUpVM = this.f33309u;
        ViewGroup viewGroup = null;
        if (signUpVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM = null;
        }
        if (!signUpVM.isNewStep()) {
            ViewGroup viewGroup2 = this.f33289a;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            } else {
                viewGroup = viewGroup2;
            }
            viewGroup.setVisibility(0);
        }
    }

    /* renamed from: e */
    private final void m25336e() {
        PermissionUtil.checkAndRequestPermissions((PermissionContext) this, (PermissionCallback) new SignUp99PayFragment$requestLocationPermission$1(this), new String[]{Permission.ACCESS_FINE_LOCATION}, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public final void m25338f() {
        TextView textView = this.f33295g;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSubmitBtn");
            textView = null;
        }
        textView.setEnabled(m25340g());
    }

    /* renamed from: g */
    private final boolean m25340g() {
        if (m25342i() && m25341h() && m25343j()) {
            CheckBox checkBox = this.f33299k;
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
    public final boolean m25341h() {
        NewPixInputView newPixInputView = this.f33292d;
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
    public final boolean m25342i() {
        NewPixInputView newPixInputView = this.f33291c;
        NewPixInputView newPixInputView2 = null;
        if (newPixInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNameInput");
            newPixInputView = null;
        }
        if (!StringsKt.isBlank(newPixInputView.getInputStr())) {
            NewPixInputView newPixInputView3 = this.f33291c;
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
    private final boolean m25343j() {
        TextView textView = this.f33293e;
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
    private final void m25344k() {
        String string = getString(R.string.wallet_create_account_page_term_text);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.walle…e_account_page_term_text)");
        String string2 = getString(R.string.wallet_create_account_page_term_high_light_text);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.walle…age_term_high_light_text)");
        CharSequence charSequence = string;
        int indexOf$default = StringsKt.indexOf$default(charSequence, string2, 0, false, 6, (Object) null);
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new SignUp99PayFragment$initTermView$clickableSpan$1(this), indexOf$default, string.length(), 18);
        TextView textView = this.f33294f;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTermTv");
            textView = null;
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView3 = this.f33294f;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTermTv");
            textView3 = null;
        }
        textView3.setHighlightColor(0);
        TextView textView4 = this.f33294f;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTermTv");
        } else {
            textView2 = textView4;
        }
        textView2.setText(spannableString);
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public final void m25345l() {
        PixGetApplyInfoResp.CPFInfo cPFInfo = this.f33308t;
        if ((cPFInfo == null ? null : cPFInfo.getTermsUrl()) != null && getActivity() != null) {
            NWRouter nWRouter = NWRouter.INSTANCE;
            FragmentActivity activity = getActivity();
            PixGetApplyInfoResp.CPFInfo cPFInfo2 = this.f33308t;
            Intrinsics.checkNotNull(cPFInfo2);
            nWRouter.gotoPDFPage(activity, cPFInfo2.getTermsUrl());
        }
    }

    /* renamed from: m */
    private final void m25346m() {
        NewPixInputView newPixInputView = this.f33292d;
        SignUpVM signUpVM = null;
        if (newPixInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
            newPixInputView = null;
        }
        String replace = new Regex(" ").replace((CharSequence) new Regex("-").replace((CharSequence) StringsKt.replace$default(newPixInputView.getInputStr(), '.', ' ', false, 4, (Object) null), ""), "");
        SignUp99PayVM signUp99PayVM = (SignUp99PayVM) getVm();
        NewPixInputView newPixInputView2 = this.f33291c;
        if (newPixInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNameInput");
            newPixInputView2 = null;
        }
        String inputStr = newPixInputView2.getInputStr();
        String n = m25347n();
        SignUpVM signUpVM2 = this.f33309u;
        if (signUpVM2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
        } else {
            signUpVM = signUpVM2;
        }
        signUp99PayVM.submitKycInfoV1(inputStr, n, replace, signUpVM.getPageSource());
    }

    /* renamed from: n */
    private final String m25347n() {
        if (this.f33307s == null) {
            return "";
        }
        String format = new SimpleDateFormat("yyyy-MM-dd").format(this.f33307s);
        Intrinsics.checkNotNullExpressionValue(format, "format.format(mSelectDate)");
        return format;
    }

    public final void showHomelandCityErrorPage() {
        ViewGroup viewGroup = this.f33289a;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            viewGroup = null;
        }
        PayHomelandCityErrorView.show(viewGroup);
    }

    /* renamed from: a */
    private final void m25321a(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 11) {
            NewPixInputView newPixInputView = this.f33292d;
            if (newPixInputView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
                newPixInputView = null;
            }
            newPixInputView.setInputStr(str);
        }
    }

    /* renamed from: b */
    private final Date m25325b(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: o */
    private final void m25348o() {
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

    /* renamed from: a */
    private final void m25306a(int i) {
        KycOmega.Companion.trackEvent("fin_table1_leave2_ck", MapsKt.mutableMapOf(TuplesKt.m41339to(CarServerParam.PARAM_BUTTON, Integer.valueOf(i))));
    }
}
