package com.jumio.defaultui.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.didi.autotracker.AutoTrackHelper;
import com.google.android.material.button.MaterialButton;
import com.jumio.sdk.scanpart.JumioScanPart;
import com.jumio.sdk.views.JumioRejectView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.C2404Reflection;
import kotlin.jvm.internal.Intrinsics;
import p001a.C0010a;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b+\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J(\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\b0\nj\b\u0012\u0004\u0012\u00020\b`\u000bH\u0002J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0011H\u0016R\u001d\u0010 \u001a\u00020\u001b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010)¨\u0006-"}, mo148868d2 = {"Lcom/jumio/defaultui/view/RejectFragment;", "Lcom/jumio/defaultui/view/BaseFragment;", "Landroid/view/View$OnClickListener;", "", "retakeImage", "", "reason", "updateUiWithReason", "", "titleResId", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "tipIds", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "createLayout", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "onStart", "onDestroyView", "v", "onClick", "La/a;", "jumioViewModel$delegate", "Lkotlin/Lazy;", "getJumioViewModel", "()La/a;", "jumioViewModel", "Lcom/jumio/sdk/views/JumioRejectView;", "rejectView", "Lcom/jumio/sdk/views/JumioRejectView;", "Lcom/google/android/material/button/MaterialButton;", "rejectButton", "Lcom/google/android/material/button/MaterialButton;", "Landroidx/appcompat/widget/AppCompatTextView;", "descriptionTextView", "Landroidx/appcompat/widget/AppCompatTextView;", "tipsTextView", "<init>", "()V", "jumio-defaultui_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: RejectFragment.kt */
public final class RejectFragment extends BaseFragment implements View.OnClickListener {
    private AppCompatTextView descriptionTextView;
    private final Lazy jumioViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, C2404Reflection.getOrCreateKotlinClass(C0010a.class), new RejectFragment$special$$inlined$activityViewModels$default$1(this), new RejectFragment$special$$inlined$activityViewModels$default$2(this));
    private MaterialButton rejectButton;
    private JumioRejectView rejectView;
    private AppCompatTextView tipsTextView;

    /* access modifiers changed from: private */
    public final C0010a getJumioViewModel() {
        return (C0010a) this.jumioViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void retakeImage() {
        JumioRejectView jumioRejectView = this.rejectView;
        if (jumioRejectView != null) {
            jumioRejectView.retake();
        }
        JumioFragmentCallback callback = getCallback();
        if (callback != null) {
            callback.retakeImage();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0055, code lost:
        if (r6.equals(com.jumio.sdk.reject.JumioRejectReason.HIDDEN_PART_DOC) == false) goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005f, code lost:
        if (r6.equals(com.jumio.sdk.reject.JumioRejectReason.MISSING_PART_DOC) == false) goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0063, code lost:
        r6 = com.taxis99.R.string.jumio_error_instant_feedback_missing_part_doc_title;
        r0.add(java.lang.Integer.valueOf(com.taxis99.R.string.jumio_error_instant_feedback_no_doc_tip_whole_document));
        r0.add(java.lang.Integer.valueOf(com.taxis99.R.string.jumio_error_instant_feedback_no_doc_tip_hand));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateUiWithReason(java.lang.String r6) {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r6 == 0) goto L_0x0155
            int r1 = r6.hashCode()
            r2 = 2131955997(0x7f13111d, float:1.9548537E38)
            r3 = 2131955998(0x7f13111e, float:1.954854E38)
            r4 = 2131955993(0x7f131119, float:1.954853E38)
            switch(r1) {
                case 48627: goto L_0x0137;
                case 48628: goto L_0x0123;
                case 48629: goto L_0x010f;
                case 49586: goto L_0x00ea;
                case 49587: goto L_0x00d1;
                case 49592: goto L_0x00b8;
                case 49621: goto L_0x009f;
                case 1537215: goto L_0x007c;
                case 1537217: goto L_0x0059;
                case 1537218: goto L_0x004f;
                case 1537219: goto L_0x0036;
                case 1537220: goto L_0x0019;
                default: goto L_0x0017;
            }
        L_0x0017:
            goto L_0x0155
        L_0x0019:
            java.lang.String r1 = "2006"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0023
            goto L_0x0155
        L_0x0023:
            r6 = 2131955999(0x7f13111f, float:1.9548541E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r0.add(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r0.add(r1)
            goto L_0x0162
        L_0x0036:
            java.lang.String r1 = "2005"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0040
            goto L_0x0155
        L_0x0040:
            r6 = 2131955992(0x7f131118, float:1.9548527E38)
            r1 = 2131955991(0x7f131117, float:1.9548525E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L_0x0162
        L_0x004f:
            java.lang.String r1 = "2004"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0063
            goto L_0x0155
        L_0x0059:
            java.lang.String r1 = "2003"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0063
            goto L_0x0155
        L_0x0063:
            r6 = 2131956004(0x7f131124, float:1.9548551E38)
            r1 = 2131956007(0x7f131127, float:1.9548558E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            r1 = 2131956006(0x7f131126, float:1.9548556E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L_0x0162
        L_0x007c:
            java.lang.String r1 = "2001"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0086
            goto L_0x0155
        L_0x0086:
            r6 = 2131955987(0x7f131113, float:1.9548517E38)
            r1 = 2131955985(0x7f131111, float:1.9548513E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            r1 = 2131955986(0x7f131112, float:1.9548515E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L_0x0162
        L_0x009f:
            java.lang.String r1 = "214"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x00a9
            goto L_0x0155
        L_0x00a9:
            r6 = 2131956003(0x7f131123, float:1.954855E38)
            r1 = 2131956002(0x7f131122, float:1.9548547E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L_0x0162
        L_0x00b8:
            java.lang.String r1 = "206"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x00c2
            goto L_0x0155
        L_0x00c2:
            r6 = 2131956001(0x7f131121, float:1.9548545E38)
            r1 = 2131956000(0x7f131120, float:1.9548543E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L_0x0162
        L_0x00d1:
            java.lang.String r1 = "201"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x00db
            goto L_0x0155
        L_0x00db:
            r6 = 2131956008(0x7f131128, float:1.954856E38)
            r1 = 2131956005(0x7f131125, float:1.9548553E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L_0x0162
        L_0x00ea:
            java.lang.String r1 = "200"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x00f3
            goto L_0x0155
        L_0x00f3:
            r6 = 2131956009(0x7f131129, float:1.9548562E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r0.add(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r0.add(r1)
            r1 = 2131955984(0x7f131110, float:1.954851E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L_0x0162
        L_0x010f:
            java.lang.String r1 = "104"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0118
            goto L_0x0155
        L_0x0118:
            r6 = 2131955994(0x7f13111a, float:1.9548531E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            r0.add(r1)
            goto L_0x0162
        L_0x0123:
            java.lang.String r1 = "103"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x012c
            goto L_0x0155
        L_0x012c:
            r6 = 2131955990(0x7f131116, float:1.9548523E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            r0.add(r1)
            goto L_0x0162
        L_0x0137:
            java.lang.String r1 = "102"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0140
            goto L_0x0155
        L_0x0140:
            r6 = 2131955989(0x7f131115, float:1.9548521E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            r0.add(r1)
            r1 = 2131955988(0x7f131114, float:1.954852E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L_0x0162
        L_0x0155:
            r6 = 2131955996(0x7f13111c, float:1.9548535E38)
            r1 = 2131955995(0x7f13111b, float:1.9548533E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
        L_0x0162:
            r5.updateUiWithReason(r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.RejectFragment.updateUiWithReason(java.lang.String):void");
    }

    public View createLayout(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_reject, viewGroup, false);
        this.rejectView = (JumioRejectView) inflate.findViewById(R.id.reject_fragment_reject_view);
        MaterialButton materialButton = (MaterialButton) inflate.findViewById(R.id.reject_fragment_retry_button);
        this.rejectButton = materialButton;
        if (materialButton != null) {
            materialButton.setOnClickListener(this);
        }
        this.descriptionTextView = (AppCompatTextView) inflate.findViewById(R.id.reject_fragment_details_description);
        this.tipsTextView = (AppCompatTextView) inflate.findViewById(R.id.reject_fragment_details_tips);
        MaterialButton materialButton2 = this.rejectButton;
        if (materialButton2 != null) {
            materialButton2.setVisibility(0);
        }
        JumioRejectView jumioRejectView = this.rejectView;
        if (jumioRejectView != null) {
            AppCompatTextView appCompatTextView = this.descriptionTextView;
            jumioRejectView.setContentDescription(appCompatTextView == null ? null : appCompatTextView.getText());
        }
        String i = getJumioViewModel().mo46i();
        if (i != null) {
            updateUiWithReason(i);
        }
        return inflate;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        if (valueOf != null && valueOf.intValue() == R.id.reject_fragment_retry_button) {
            retakeImage();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.rejectView = null;
        this.rejectButton = null;
        this.descriptionTextView = null;
        this.tipsTextView = null;
    }

    public void onStart() {
        JumioRejectView jumioRejectView;
        super.onStart();
        JumioScanPart k = getJumioViewModel().mo48k();
        if (k != null && (jumioRejectView = this.rejectView) != null) {
            jumioRejectView.attach(k);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (activity != null && (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) != null) {
            onBackPressedDispatcher.addCallback(getViewLifecycleOwner(), new RejectFragment$onViewCreated$1(this));
        }
    }

    private final void updateUiWithReason(int i, ArrayList<Integer> arrayList) {
        AppCompatTextView appCompatTextView = this.descriptionTextView;
        if (appCompatTextView != null) {
            appCompatTextView.setText(getString(i));
        }
        AppCompatTextView appCompatTextView2 = this.tipsTextView;
        if (appCompatTextView2 != null) {
            int[] intArray = CollectionsKt.toIntArray(arrayList);
            appCompatTextView2.setText(generateBulletPointList(Arrays.copyOf(intArray, intArray.length)));
        }
    }
}
