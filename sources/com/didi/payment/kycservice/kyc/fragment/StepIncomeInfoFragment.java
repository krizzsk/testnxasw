package com.didi.payment.kycservice.kyc.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.payment.commonsdk.p130ui.WBaseFragment;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.kycservice.kyc.SignUpVM;
import com.didi.payment.kycservice.kyc.p134vm.FullKycExtraVM;
import com.didi.payment.kycservice.kyc.response.GuidesInfoResp;
import com.didi.payment.kycservice.utils.KycSPUtils;
import com.didi.payment.kycservice.utils.ViewExtsKt;
import com.taxis99.R;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\fH\u0002J&\u0010\u001b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0018H\u0016J\u001a\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010%\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000¨\u0006'"}, mo148868d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/StepIncomeInfoFragment;", "Lcom/didi/payment/commonsdk/ui/WBaseFragment;", "Lcom/didi/payment/kycservice/kyc/vm/FullKycExtraVM;", "()V", "adapter", "Lcom/didi/payment/kycservice/kyc/fragment/IncomeAdapter;", "incomeList", "Ljava/util/ArrayList;", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$Income;", "Lkotlin/collections/ArrayList;", "incomeSelect", "mDividerView", "Landroid/view/View;", "mExtraVM", "mIncomeRCV", "Landroidx/recyclerview/widget/RecyclerView;", "mNextBtn", "Landroid/widget/TextView;", "mPreBtn", "Landroid/widget/ImageView;", "pixSignUpVM", "Lcom/didi/payment/kycservice/kyc/SignUpVM;", "getTitleBarView", "initListener", "", "initView", "rootView", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "view", "updateSubmitBtn", "Companion", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: StepIncomeInfoFragment.kt */
public final class StepIncomeInfoFragment extends WBaseFragment<FullKycExtraVM> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: j */
    private static final String f33364j = "args_income_list";

    /* renamed from: a */
    private TextView f33365a;

    /* renamed from: b */
    private ImageView f33366b;

    /* renamed from: c */
    private View f33367c;

    /* renamed from: d */
    private RecyclerView f33368d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public FullKycExtraVM f33369e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SignUpVM f33370f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public IncomeAdapter f33371g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ArrayList<GuidesInfoResp.Income> f33372h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public GuidesInfoResp.Income f33373i;

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return null;
    }

    @Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo148868d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/StepIncomeInfoFragment$Companion;", "", "()V", "ARGS_INCOME_LIST", "", "newInstance", "Lcom/didi/payment/kycservice/kyc/fragment/StepIncomeInfoFragment;", "list", "Ljava/util/ArrayList;", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$Income;", "Lkotlin/collections/ArrayList;", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: StepIncomeInfoFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StepIncomeInfoFragment newInstance(ArrayList<GuidesInfoResp.Income> arrayList) {
            StepIncomeInfoFragment stepIncomeInfoFragment = new StepIncomeInfoFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(StepIncomeInfoFragment.f33364j, arrayList);
            Unit unit = Unit.INSTANCE;
            stepIncomeInfoFragment.setArguments(bundle);
            return stepIncomeInfoFragment;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_step_income_info, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        KycOmega.Companion.trackEvent("fin_table2_income_sw");
        ViewModel viewModel = new ViewModelProvider(requireActivity()).get(SignUpVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir…get(SignUpVM::class.java)");
        this.f33370f = (SignUpVM) viewModel;
        ViewModel viewModel2 = new ViewModelProvider(requireParentFragment()).get(FullKycExtraVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(requir…llKycExtraVM::class.java)");
        this.f33369e = (FullKycExtraVM) viewModel2;
        Bundle arguments = getArguments();
        FullKycExtraVM fullKycExtraVM = null;
        Serializable serializable = arguments == null ? null : arguments.getSerializable(f33364j);
        this.f33372h = serializable instanceof ArrayList ? (ArrayList) serializable : null;
        Context context = getContext();
        if (context != null) {
            this.f33373i = KycSPUtils.Companion.getIncome(context);
        }
        m25398a(view);
        m25397a();
        FullKycExtraVM fullKycExtraVM2 = this.f33369e;
        if (fullKycExtraVM2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mExtraVM");
        } else {
            fullKycExtraVM = fullKycExtraVM2;
        }
        subscribeUi(fullKycExtraVM);
    }

    /* renamed from: a */
    private final void m25398a(View view) {
        View findViewById = view.findViewById(R.id.btn_next);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.btn_next)");
        this.f33365a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.btn_pre_page);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.btn_pre_page)");
        this.f33366b = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.income_rcv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.income_rcv)");
        this.f33368d = (RecyclerView) findViewById3;
        View findViewById4 = view.findViewById(R.id.divider_view);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.divider_view)");
        this.f33367c = findViewById4;
        m25399b();
        IncomeAdapter incomeAdapter = new IncomeAdapter();
        this.f33371g = incomeAdapter;
        View view2 = null;
        if (incomeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            incomeAdapter = null;
        }
        incomeAdapter.setOnItemClick(new StepIncomeInfoFragment$initView$1(this));
        RecyclerView recyclerView = this.f33368d;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIncomeRCV");
            recyclerView = null;
        }
        IncomeAdapter incomeAdapter2 = this.f33371g;
        if (incomeAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            incomeAdapter2 = null;
        }
        recyclerView.setAdapter(incomeAdapter2);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), 1);
        dividerItemDecoration.setDrawable(new ColorDrawable(Color.parseColor(ColorUtils.DIDI_GREY)));
        RecyclerView recyclerView2 = this.f33368d;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIncomeRCV");
            recyclerView2 = null;
        }
        recyclerView2.addItemDecoration(dividerItemDecoration);
        ArrayList<GuidesInfoResp.Income> arrayList = this.f33372h;
        if (arrayList != null) {
            for (GuidesInfoResp.Income income : arrayList) {
                String type = income.getType();
                GuidesInfoResp.Income income2 = this.f33373i;
                income.setSelected(Intrinsics.areEqual((Object) type, (Object) income2 == null ? null : income2.getType()));
            }
            IncomeAdapter incomeAdapter3 = this.f33371g;
            if (incomeAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                incomeAdapter3 = null;
            }
            incomeAdapter3.setData(arrayList);
        }
        SignUpVM signUpVM = this.f33370f;
        if (signUpVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM = null;
        }
        if (signUpVM.isNewStep()) {
            SignUpVM signUpVM2 = this.f33370f;
            if (signUpVM2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                signUpVM2 = null;
            }
            if (signUpVM2.getCanBackStack()) {
                ImageView imageView = this.f33366b;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPreBtn");
                    imageView = null;
                }
                imageView.setVisibility(0);
                View view3 = this.f33367c;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDividerView");
                } else {
                    view2 = view3;
                }
                view2.setVisibility(8);
                return;
            }
        }
        ImageView imageView2 = this.f33366b;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPreBtn");
            imageView2 = null;
        }
        imageView2.setVisibility(8);
        View view4 = this.f33367c;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDividerView");
        } else {
            view2 = view4;
        }
        view2.setVisibility(0);
    }

    /* renamed from: a */
    private final void m25397a() {
        TextView textView = this.f33365a;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNextBtn");
            textView = null;
        }
        ViewExtsKt.click(textView, new StepIncomeInfoFragment$initListener$1(this));
        ImageView imageView2 = this.f33366b;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPreBtn");
        } else {
            imageView = imageView2;
        }
        ViewExtsKt.click(imageView, new StepIncomeInfoFragment$initListener$2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m25399b() {
        TextView textView = this.f33365a;
        String str = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNextBtn");
            textView = null;
        }
        GuidesInfoResp.Income income = this.f33373i;
        if (income != null) {
            str = income.getType();
        }
        textView.setEnabled(!TextUtils.isEmpty(str));
    }

    public void onResume() {
        super.onResume();
        SignUpVM signUpVM = this.f33370f;
        if (signUpVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM = null;
        }
        signUpVM.updateStepProgress(KycFormStep.STEP_INCOME);
    }
}
