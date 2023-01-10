package com.didi.payment.kycservice.kyc.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.commonsdk.p130ui.WBaseFragment;
import com.didi.payment.commonsdk.p130ui.WBaseViewModel;
import com.didi.payment.commonsdk.spi.JumioService;
import com.didi.payment.commonsdk.utils.JumioFaceFinishEvent;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.commonsdk.utils.NViewUtils;
import com.didi.payment.commonsdk.utils.OmegaComParams;
import com.didi.payment.kycservice.kyc.SignUpVM;
import com.didi.payment.kycservice.kyc.p134vm.IDTypeVM;
import com.didi.payment.kycservice.net.response.JumioCreateResultResp;
import com.didi.payment.kycservice.net.response.JumioGuideResp;
import com.didi.payment.kycservice.utils.ViewExtsKt;
import com.didi.payment.wallet_ui.dialog.WalletDialog;
import com.didi.payment.wallet_ui.wheel.OnOptionWheelClick;
import com.didi.payment.wallet_ui.wheel.OptionLinkWheelBuilder;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.taxis99.R;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@Metadata(mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 G2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001GB\u0005¢\u0006\u0002\u0010\u0003J\n\u0010#\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0002J\u0010\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020\u0010H\u0002J&\u0010)\u001a\u0004\u0018\u00010\u00102\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020%H\u0016J\u0012\u00101\u001a\u00020%2\b\u00102\u001a\u0004\u0018\u000103H\u0007J\b\u00104\u001a\u00020%H\u0016J\u001a\u00105\u001a\u00020%2\u0006\u00106\u001a\u00020\u00102\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0010\u00107\u001a\u00020%2\u0006\u00108\u001a\u000209H\u0002J+\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u00020<2\u000e\u0010=\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0>2\u0006\u0010?\u001a\u00020@¢\u0006\u0002\u0010AJ\u0010\u0010B\u001a\u00020%2\u0006\u0010C\u001a\u00020\u0002H\u0016J\u0010\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020FH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X.¢\u0006\u0002\n\u0000¨\u0006H"}, mo148868d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/IDTypeFragment;", "Lcom/didi/payment/commonsdk/ui/WBaseFragment;", "Lcom/didi/payment/kycservice/kyc/vm/IDTypeVM;", "()V", "alertDrawer", "Lcom/didi/payment/wallet_ui/dialog/WalletDialog;", "mAlertLayout", "Landroid/widget/LinearLayout;", "mAlertTitle", "Landroid/widget/TextView;", "mConfirmBtn", "getMConfirmBtn", "()Landroid/widget/TextView;", "setMConfirmBtn", "(Landroid/widget/TextView;)V", "mDividerView", "Landroid/view/View;", "mIdGuideSubTitle", "getMIdGuideSubTitle", "setMIdGuideSubTitle", "mIdGuideTitle", "getMIdGuideTitle", "setMIdGuideTitle", "mIdImage", "Landroid/widget/ImageView;", "getMIdImage", "()Landroid/widget/ImageView;", "setMIdImage", "(Landroid/widget/ImageView;)V", "mPreBtn", "mShadowView", "pageSource", "", "pixSignUpVM", "Lcom/didi/payment/kycservice/kyc/SignUpVM;", "getTitleBarView", "goIntentSetting", "", "initListener", "initView", "rootView", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onEvent", "event", "Lcom/didi/payment/commonsdk/utils/JumioFaceFinishEvent;", "onResume", "onViewCreated", "view", "setAlertDialog", "data", "Lcom/didi/payment/kycservice/net/response/JumioGuideResp$TimeSelectDetail;", "showPerDialog", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "subscribeUi", "vm", "updateView", "guideData", "Lcom/didi/payment/kycservice/net/response/JumioGuideResp$Data;", "Companion", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: IDTypeFragment.kt */
public final class IDTypeFragment extends WBaseFragment<IDTypeVM> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private TextView f33273a;

    /* renamed from: b */
    private TextView f33274b;

    /* renamed from: c */
    private TextView f33275c;

    /* renamed from: d */
    private ImageView f33276d;

    /* renamed from: e */
    private String f33277e = "";
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SignUpVM f33278f;

    /* renamed from: g */
    private LinearLayout f33279g;

    /* renamed from: h */
    private ImageView f33280h;

    /* renamed from: i */
    private View f33281i;

    /* renamed from: j */
    private View f33282j;

    /* renamed from: k */
    private TextView f33283k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public WalletDialog f33284l;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m25301a(Map map) {
        return true;
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return null;
    }

    public final TextView getMConfirmBtn() {
        return this.f33273a;
    }

    public final void setMConfirmBtn(TextView textView) {
        this.f33273a = textView;
    }

    public final TextView getMIdGuideTitle() {
        return this.f33274b;
    }

    public final void setMIdGuideTitle(TextView textView) {
        this.f33274b = textView;
    }

    public final TextView getMIdGuideSubTitle() {
        return this.f33275c;
    }

    public final void setMIdGuideSubTitle(TextView textView) {
        this.f33275c = textView;
    }

    public final ImageView getMIdImage() {
        return this.f33276d;
    }

    public final void setMIdImage(ImageView imageView) {
        this.f33276d = imageView;
    }

    @Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo148868d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/IDTypeFragment$Companion;", "", "()V", "newInstance", "Lcom/didi/payment/kycservice/kyc/fragment/IDTypeFragment;", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: IDTypeFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IDTypeFragment newInstance() {
            Bundle bundle = new Bundle();
            IDTypeFragment iDTypeFragment = new IDTypeFragment();
            iDTypeFragment.setArguments(bundle);
            return iDTypeFragment;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragement_id_type_layout, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        OmegaComParams.Companion.setPubPage(OmegaComParams.FULL_KYC_VER);
        ViewModel viewModel = new ViewModelProvider(requireActivity()).get(SignUpVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir…get(SignUpVM::class.java)");
        SignUpVM signUpVM = (SignUpVM) viewModel;
        this.f33278f = signUpVM;
        if (signUpVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM = null;
        }
        this.f33277e = signUpVM.getPageSource();
        ViewModel viewModel2 = new ViewModelProvider(this).get(IDTypeVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(this).get(IDTypeVM::class.java)");
        setVm((WBaseViewModel) viewModel2);
        ((IDTypeVM) getVm()).loadData();
        subscribeUi((IDTypeVM) getVm());
        m25291a(view);
        m25290a();
        EventBus.getDefault().register(this);
        KycOmega.Companion.trackEvent("fin_fullkycverification_sw");
    }

    public void subscribeUi(IDTypeVM iDTypeVM) {
        Intrinsics.checkNotNullParameter(iDTypeVM, "vm");
        super.subscribeUi(iDTypeVM);
        iDTypeVM.getJumioGuideData().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                IDTypeFragment.m25294a(IDTypeFragment.this, (JumioGuideResp.Data) obj);
            }
        });
        iDTypeVM.getJumioCreateData().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                IDTypeFragment.m25293a(IDTypeFragment.this, (JumioCreateResultResp.Data) obj);
            }
        });
        iDTypeVM.isLoading().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                IDTypeFragment.m25296a(IDTypeFragment.this, (Boolean) obj);
            }
        });
        iDTypeVM.getDelayPushSet().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                IDTypeFragment.m25303b(IDTypeFragment.this, (Boolean) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25294a(IDTypeFragment iDTypeFragment, JumioGuideResp.Data data) {
        Intrinsics.checkNotNullParameter(iDTypeFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(data, "it");
        iDTypeFragment.m25297a(data);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25293a(IDTypeFragment iDTypeFragment, JumioCreateResultResp.Data data) {
        String sdkToken;
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(iDTypeFragment, "this$0");
        if (data != null && (sdkToken = data.getSdkToken()) != null && (activity = iDTypeFragment.getActivity()) != null) {
            JumioService.Companion.startDDCustomActivity(activity, sdkToken, data.getDateCenter());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25296a(IDTypeFragment iDTypeFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(iDTypeFragment, "this$0");
        SignUpVM signUpVM = iDTypeFragment.f33278f;
        if (signUpVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM = null;
        }
        signUpVM.isLoading().setValue(bool);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m25303b(IDTypeFragment iDTypeFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(iDTypeFragment, "this$0");
        LinearLayout linearLayout = iDTypeFragment.f33279g;
        if (linearLayout != null) {
            linearLayout.setEnabled(!bool.booleanValue());
        }
        View view = iDTypeFragment.f33281i;
        if (view != null) {
            Intrinsics.checkNotNullExpressionValue(bool, "it");
            view.setVisibility(bool.booleanValue() ? 0 : 8);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    /* renamed from: a */
    private final void m25291a(View view) {
        this.f33273a = (TextView) view.findViewById(R.id.confirm_btn);
        this.f33274b = (TextView) view.findViewById(R.id.id_guide_title);
        this.f33275c = (TextView) view.findViewById(R.id.id_guide_sub_title);
        this.f33276d = (ImageView) view.findViewById(R.id.id_guide_image);
        this.f33279g = (LinearLayout) view.findViewById(R.id.alert_layout);
        this.f33280h = (ImageView) view.findViewById(R.id.btn_pre_page);
        this.f33281i = view.findViewById(R.id.view_shadow);
        this.f33282j = view.findViewById(R.id.divider_view);
        this.f33283k = (TextView) view.findViewById(R.id.alert_title);
        SignUpVM signUpVM = null;
        if (((IDTypeVM) getVm()).getNeedShowReminder()) {
            LinearLayout linearLayout = this.f33279g;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            SignUpVM signUpVM2 = this.f33278f;
            if (signUpVM2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                signUpVM2 = null;
            }
            signUpVM2.updateStepProgress(KycFormStep.STEP_ID_TYPE);
        } else {
            LinearLayout linearLayout2 = this.f33279g;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            View view2 = this.f33281i;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
        SignUpVM signUpVM3 = this.f33278f;
        if (signUpVM3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
        } else {
            signUpVM = signUpVM3;
        }
        if (signUpVM.isNewStep()) {
            ImageView imageView = this.f33280h;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            View view3 = this.f33282j;
            if (view3 != null) {
                view3.setVisibility(8);
                return;
            }
            return;
        }
        ImageView imageView2 = this.f33280h;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        View view4 = this.f33282j;
        if (view4 != null) {
            view4.setVisibility(0);
        }
    }

    /* renamed from: a */
    private final void m25290a() {
        TextView textView = this.f33273a;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    IDTypeFragment.m25292a(IDTypeFragment.this, view);
                }
            });
        }
        LinearLayout linearLayout = this.f33279g;
        if (linearLayout != null) {
            ViewExtsKt.click(linearLayout, new IDTypeFragment$initListener$2(this));
        }
        ImageView imageView = this.f33280h;
        if (imageView != null) {
            ViewExtsKt.click(imageView, new IDTypeFragment$initListener$3(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25292a(IDTypeFragment iDTypeFragment, View view) {
        Intrinsics.checkNotNullParameter(iDTypeFragment, "this$0");
        try {
            KycOmega.Companion.trackButtonEvent("fin_fullkycverification_button_ck", 1);
            FragmentActivity activity = iDTypeFragment.getActivity();
            if (activity != null) {
                if (!JumioService.Companion.checkPermissions(activity)) {
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        IDTypeVM iDTypeVM = (IDTypeVM) iDTypeFragment.getVm();
        SignUpVM signUpVM = iDTypeFragment.f33278f;
        SignUpVM signUpVM2 = null;
        if (signUpVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM = null;
        }
        String pageSource = signUpVM.getPageSource();
        SignUpVM signUpVM3 = iDTypeFragment.f33278f;
        if (signUpVM3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
        } else {
            signUpVM2 = signUpVM3;
        }
        iDTypeVM.createToken(pageSource, signUpVM2.getFromPrimary());
    }

    /* renamed from: a */
    private final void m25297a(JumioGuideResp.Data data) {
        String imageLink;
        TextView textView = this.f33274b;
        if (textView != null) {
            textView.setText(data.getTitle());
        }
        TextView textView2 = this.f33275c;
        if (textView2 != null) {
            NViewUtils.INSTANCE.setText2HighLight(textView2, data.getSubTitle(), Color.parseColor("#666666"));
        }
        ImageView imageView = this.f33276d;
        if (!(imageView == null || (imageLink = data.getImageLink()) == null)) {
            GlideUtils.with2load2into(getContext(), imageLink, imageView);
        }
        JumioGuideResp.TimeSelectDetail timeSelectDetail = data.getTimeSelectDetail();
        if (timeSelectDetail != null) {
            TextView textView3 = this.f33283k;
            if (textView3 != null) {
                textView3.setText(timeSelectDetail.getTitle());
            }
            if (Intrinsics.areEqual((Object) timeSelectDetail.getCanSetUp(), (Object) true)) {
                LinearLayout linearLayout = this.f33279g;
                if (linearLayout != null) {
                    linearLayout.setEnabled(true);
                }
                View view = this.f33281i;
                if (view != null) {
                    view.setVisibility(8);
                }
            } else {
                LinearLayout linearLayout2 = this.f33279g;
                if (linearLayout2 != null) {
                    linearLayout2.setEnabled(false);
                }
                View view2 = this.f33281i;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
            }
            m25298a(timeSelectDetail);
        }
    }

    @Subscribe
    public final void onEvent(JumioFaceFinishEvent jumioFaceFinishEvent) {
        boolean z = false;
        if (jumioFaceFinishEvent != null && jumioFaceFinishEvent.finish) {
            z = true;
        }
        if (z) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        ((IDTypeVM) getVm()).checkJumio(new IDTypeFragment$onEvent$1(this));
    }

    public final void showPerDialog(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        if (i == 303) {
            StringBuilder sb = new StringBuilder();
            int length = iArr.length - 1;
            if (length >= 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    if (iArr[i2] != 0) {
                        sb.append(strArr[i2]);
                        sb.append(" not granted,");
                    }
                    if (i3 > length) {
                        break;
                    }
                    i2 = i3;
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
            SignUpVM signUpVM = null;
            if (!StringsKt.isBlank(sb2)) {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_kyc_title_custome, (ViewGroup) null, false);
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    new AlertDialogFragment.Builder(activity).setContentView(inflate).setPositiveButton((CharSequence) getResources().getString(R.string.FoodC_homepage_To_authorize_CEZR), (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
                        public final void onClick(AlertDialogFragment alertDialogFragment, View view) {
                            IDTypeFragment.m25295a(IDTypeFragment.this, alertDialogFragment, view);
                        }
                    }).setPositiveButtonDefault().setCancelable(false).setNegativeButton((CharSequence) getResources().getString(R.string.GRider_Registration_Cancel_kckP), (AlertDialogFragment.OnClickListener) $$Lambda$IDTypeFragment$amQwWFwbPGmkDw2Wcizdd_88H8o.INSTANCE).create().show(activity.getSupportFragmentManager(), "");
                    return;
                }
                return;
            }
            IDTypeVM iDTypeVM = (IDTypeVM) getVm();
            SignUpVM signUpVM2 = this.f33278f;
            if (signUpVM2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                signUpVM2 = null;
            }
            String pageSource = signUpVM2.getPageSource();
            SignUpVM signUpVM3 = this.f33278f;
            if (signUpVM3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            } else {
                signUpVM = signUpVM3;
            }
            iDTypeVM.createToken(pageSource, signUpVM.getFromPrimary());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25295a(IDTypeFragment iDTypeFragment, AlertDialogFragment alertDialogFragment, View view) {
        Intrinsics.checkNotNullParameter(iDTypeFragment, "this$0");
        alertDialogFragment.dismiss();
        iDTypeFragment.m25302b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25299a(AlertDialogFragment alertDialogFragment, View view) {
        alertDialogFragment.dismiss();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f A[Catch:{ Exception -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m25302b() {
        /*
            r6 = this;
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            r1 = 0
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x0043 }
            java.lang.String r3 = "android.settings.APPLICATION_DETAILS_SETTINGS"
            r2.<init>(r3)     // Catch:{ Exception -> 0x0043 }
            r2.setFlags(r0)     // Catch:{ Exception -> 0x0043 }
            java.lang.String r3 = "package"
            androidx.fragment.app.FragmentActivity r4 = r6.getActivity()     // Catch:{ Exception -> 0x0043 }
            if (r4 != 0) goto L_0x0017
            r4 = r1
            goto L_0x001b
        L_0x0017:
            java.lang.String r4 = r4.getPackageName()     // Catch:{ Exception -> 0x0043 }
        L_0x001b:
            r5 = r1
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0043 }
            android.net.Uri r3 = android.net.Uri.fromParts(r3, r4, r5)     // Catch:{ Exception -> 0x0043 }
            java.lang.String r4 = "fromParts(\"package\", act…ageName, null as String?)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ Exception -> 0x0043 }
            r2.setData(r3)     // Catch:{ Exception -> 0x0043 }
            androidx.fragment.app.FragmentActivity r3 = r6.getActivity()     // Catch:{ Exception -> 0x0043 }
            if (r3 != 0) goto L_0x0032
        L_0x0030:
            r3 = r1
            goto L_0x003d
        L_0x0032:
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch:{ Exception -> 0x0043 }
            if (r3 != 0) goto L_0x0039
            goto L_0x0030
        L_0x0039:
            android.content.ComponentName r3 = r2.resolveActivity(r3)     // Catch:{ Exception -> 0x0043 }
        L_0x003d:
            if (r3 == 0) goto L_0x006d
            r6.startActivity(r2)     // Catch:{ Exception -> 0x0043 }
            goto L_0x006d
        L_0x0043:
            r2 = move-exception
            r2.printStackTrace()
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x0069 }
            java.lang.String r3 = "android.settings.SETTINGS"
            r2.<init>(r3)     // Catch:{ Exception -> 0x0069 }
            r2.setFlags(r0)     // Catch:{ Exception -> 0x0069 }
            androidx.fragment.app.FragmentActivity r0 = r6.getActivity()     // Catch:{ Exception -> 0x0069 }
            if (r0 != 0) goto L_0x0058
            goto L_0x0063
        L_0x0058:
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ Exception -> 0x0069 }
            if (r0 != 0) goto L_0x005f
            goto L_0x0063
        L_0x005f:
            android.content.ComponentName r1 = r2.resolveActivity(r0)     // Catch:{ Exception -> 0x0069 }
        L_0x0063:
            if (r1 == 0) goto L_0x006d
            r6.startActivity(r2)     // Catch:{ Exception -> 0x0069 }
            goto L_0x006d
        L_0x0069:
            r0 = move-exception
            r0.printStackTrace()
        L_0x006d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.kycservice.kyc.fragment.IDTypeFragment.m25302b():void");
    }

    /* renamed from: a */
    private final void m25298a(JumioGuideResp.TimeSelectDetail timeSelectDetail) {
        List list;
        List<JumioGuideResp.TimeData> data = timeSelectDetail.getData();
        if (data == null) {
            list = null;
        } else {
            list = CollectionsKt.listOf(new IDTypeFragment$setAlertDialog$1$1(data), new IDTypeFragment$setAlertDialog$1$2(data));
        }
        Context context = getContext();
        if (context != null) {
            WalletDialog.Companion companion = WalletDialog.Companion;
            OptionLinkWheelBuilder optionLinkWheelBuilder = new OptionLinkWheelBuilder();
            optionLinkWheelBuilder.addAllItem(list);
            optionLinkWheelBuilder.setKeepLastSelected(true);
            optionLinkWheelBuilder.setShowDelete(false);
            optionLinkWheelBuilder.setTitle(timeSelectDetail.getInnerTitle());
            optionLinkWheelBuilder.setCancelClick($$Lambda$IDTypeFragment$OfZ_f_nqkAwFWqPCm7D7k3maA.INSTANCE);
            optionLinkWheelBuilder.setConfirmText(getString(R.string.pay_base_confirm));
            optionLinkWheelBuilder.setConfirmClick(new OnOptionWheelClick(this) {
                public final /* synthetic */ IDTypeFragment f$1;

                {
                    this.f$1 = r2;
                }

                public final boolean onClick(Map map) {
                    return IDTypeFragment.m25300a(JumioGuideResp.TimeSelectDetail.this, this.f$1, map);
                }
            });
            Unit unit = Unit.INSTANCE;
            this.f33284l = WalletDialog.Companion.configLinkageOptionWheel$default(companion, context, optionLinkWheelBuilder, false, false, 12, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m25300a(JumioGuideResp.TimeSelectDetail timeSelectDetail, IDTypeFragment iDTypeFragment, Map map) {
        Long time;
        Intrinsics.checkNotNullParameter(timeSelectDetail, "$data");
        Intrinsics.checkNotNullParameter(iDTypeFragment, "this$0");
        List<JumioGuideResp.TimeData> data = timeSelectDetail.getData();
        if (data != null) {
            Object obj = map.get("day");
            Intrinsics.checkNotNull(obj);
            List<JumioGuideResp.HourData> hour = data.get(((Number) obj).intValue()).getHour();
            if (hour != null) {
                Object obj2 = map.get("hour");
                Intrinsics.checkNotNull(obj2);
                JumioGuideResp.HourData hourData = hour.get(((Number) obj2).intValue());
                if (!(hourData == null || (time = hourData.getTime()) == null)) {
                    ((IDTypeVM) iDTypeFragment.getVm()).setDelayPush(time.longValue());
                }
            }
        }
        KycOmega.Companion.trackButtonEvent("fin_table2_certificate_ck", 2);
        return true;
    }

    public void onResume() {
        super.onResume();
        SignUpVM signUpVM = this.f33278f;
        if (signUpVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM = null;
        }
        signUpVM.updateStepProgress(KycFormStep.STEP_ID_TYPE);
    }
}
