package com.didi.payment.kycservice.key.migrateout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.didi.payment.base.utils.TextHighlightUtil;
import com.didi.payment.commonsdk.p130ui.WBaseFragment;
import com.didi.payment.commonsdk.p130ui.WBaseViewModel;
import com.didi.payment.commonsdk.utils.NViewUtils;
import com.didi.payment.kycservice.key.migrateout.p133vm.PixKeyMigrateOutVM;
import com.didi.payment.kycservice.key.migrateout.response.PixKeyMigrateOutListResp;
import com.didi.payment.kycservice.kyc.response.ResultPageData;
import com.taxis99.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J&\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo148868d2 = {"Lcom/didi/payment/kycservice/key/migrateout/MigrateOutDetailFragment;", "Lcom/didi/payment/commonsdk/ui/WBaseFragment;", "Lcom/didi/payment/kycservice/key/migrateout/vm/PixKeyMigrateOutVM;", "()V", "btnCancel", "Landroid/widget/TextView;", "btnConfirm", "llContentContainer", "Landroid/widget/LinearLayout;", "tvMainTitle", "tvSubTitle", "addItemView", "", "itemInfo", "Lcom/didi/payment/kycservice/kyc/response/ResultPageData$ItemInfo;", "getTitleBarView", "Landroid/view/View;", "initListener", "initView", "rootView", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Companion", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: MigrateOutDetailFragment.kt */
public final class MigrateOutDetailFragment extends WBaseFragment<PixKeyMigrateOutVM> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private TextView f33172a;

    /* renamed from: b */
    private TextView f33173b;

    /* renamed from: c */
    private LinearLayout f33174c;

    /* renamed from: d */
    private TextView f33175d;

    /* renamed from: e */
    private TextView f33176e;

    @JvmStatic
    public static final MigrateOutDetailFragment newInstance() {
        return Companion.newInstance();
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_migrate_out_detail_new, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        m25193a(view);
        m25192a();
    }

    /* renamed from: a */
    private final void m25193a(View view) {
        View findViewById = view.findViewById(R.id.pix_key_migrate_main_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.…x_key_migrate_main_title)");
        this.f33172a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.pix_key_migrate_sub_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.…ix_key_migrate_sub_title)");
        this.f33173b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.pix_content_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.pix_content_container)");
        this.f33174c = (LinearLayout) findViewById3;
        View findViewById4 = view.findViewById(R.id.pix_key_migrate_btn_confirm);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.…_key_migrate_btn_confirm)");
        this.f33175d = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.pix_key_migrate_btn_cancel);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.…x_key_migrate_btn_cancel)");
        this.f33176e = (TextView) findViewById5;
        ViewModel viewModel = new ViewModelProvider(requireActivity()).get(PixKeyMigrateOutVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir…MigrateOutVM::class.java)");
        setVm((WBaseViewModel) viewModel);
        PixKeyMigrateOutListResp.KeyItem detailPageData = ((PixKeyMigrateOutVM) getVm()).getDetailPageData();
        if (detailPageData != null) {
            TextView textView = this.f33172a;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvMainTitle");
                textView = null;
            }
            ResultPageData resultData = detailPageData.getResultData();
            Intrinsics.checkNotNull(resultData);
            textView.setText(TextHighlightUtil.highlight(resultData.getCenterTitle(), Color.parseColor("#000000"), Color.parseColor("#FF8040")));
            NViewUtils nViewUtils = NViewUtils.INSTANCE;
            TextView textView3 = this.f33173b;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvSubTitle");
                textView3 = null;
            }
            ResultPageData resultData2 = detailPageData.getResultData();
            Intrinsics.checkNotNull(resultData2);
            nViewUtils.setText(textView3, resultData2.getCenterSubTitle());
            LinearLayout linearLayout = this.f33174c;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llContentContainer");
                linearLayout = null;
            }
            linearLayout.removeAllViews();
            ResultPageData resultData3 = detailPageData.getResultData();
            Intrinsics.checkNotNull(resultData3);
            ArrayList<ResultPageData.ItemInfo> entryList = resultData3.getEntryList();
            int i = 0;
            Intrinsics.checkNotNull(entryList);
            int size = entryList.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i2 = i + 1;
                    ResultPageData.ItemInfo itemInfo = entryList.get(i);
                    Intrinsics.checkNotNullExpressionValue(itemInfo, "entryLst[index]");
                    m25195a(itemInfo);
                    if (i2 > size) {
                        break;
                    }
                    i = i2;
                }
            }
            TextView textView4 = this.f33175d;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
                textView4 = null;
            }
            textView4.setText(((PixKeyMigrateOutVM) getVm()).getMigrateOutListData().getConfirmButton());
            TextView textView5 = this.f33176e;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnCancel");
            } else {
                textView2 = textView5;
            }
            textView2.setText(((PixKeyMigrateOutVM) getVm()).getMigrateOutListData().getCancelButton());
        }
    }

    /* renamed from: a */
    private final void m25192a() {
        TextView textView = this.f33175d;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MigrateOutDetailFragment.m25194a(MigrateOutDetailFragment.this, view);
            }
        });
        TextView textView3 = this.f33176e;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnCancel");
        } else {
            textView2 = textView3;
        }
        textView2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MigrateOutDetailFragment.m25196b(MigrateOutDetailFragment.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25194a(MigrateOutDetailFragment migrateOutDetailFragment, View view) {
        Intrinsics.checkNotNullParameter(migrateOutDetailFragment, "this$0");
        ((PixKeyMigrateOutVM) migrateOutDetailFragment.getVm()).doMigrateOut();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m25196b(MigrateOutDetailFragment migrateOutDetailFragment, View view) {
        Intrinsics.checkNotNullParameter(migrateOutDetailFragment, "this$0");
        ((PixKeyMigrateOutVM) migrateOutDetailFragment.getVm()).cancelMigrateOut();
    }

    /* renamed from: a */
    private final void m25195a(ResultPageData.ItemInfo itemInfo) {
        LayoutInflater from = LayoutInflater.from(getActivity());
        LinearLayout linearLayout = this.f33174c;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llContentContainer");
            linearLayout = null;
        }
        View inflate = from.inflate(R.layout.pix_sign_up_result_item_with_dot_new, linearLayout, false);
        ((TextView) inflate.findViewById(R.id.pix_sign_up_result_title)).setText(TextHighlightUtil.highlight(itemInfo.getTitle(), Color.parseColor("#000000"), Color.parseColor("#FF8040")));
        LinearLayout linearLayout3 = this.f33174c;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llContentContainer");
        } else {
            linearLayout2 = linearLayout3;
        }
        linearLayout2.addView(inflate);
    }

    @Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, mo148868d2 = {"Lcom/didi/payment/kycservice/key/migrateout/MigrateOutDetailFragment$Companion;", "", "()V", "newInstance", "Lcom/didi/payment/kycservice/key/migrateout/MigrateOutDetailFragment;", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: MigrateOutDetailFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MigrateOutDetailFragment newInstance() {
            return new MigrateOutDetailFragment();
        }
    }
}
