package com.didiglobal.scan.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0003!\"#B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0007J\u0010\u0010 \u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\rR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, mo148868d2 = {"Lcom/didiglobal/scan/view/ScanErrorDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "actionScheme", "", "actionType", "clickCallBack", "Lcom/didiglobal/scan/view/ScanErrorDialogFragment$ClickCallBack;", "errorText", "Landroid/widget/TextView;", "errorTitle", "retry", "showCallBack", "Lcom/didiglobal/scan/view/ScanErrorDialogFragment$ShowCallBack;", "dismiss", "", "initData", "initListener", "initView", "view", "Landroid/view/View;", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "setCallBack", "callback", "setShowBack", "ClickCallBack", "Companion", "ShowCallBack", "scan_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: ScanErrorDialogFragment.kt */
public final class ScanErrorDialogFragment extends DialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_ACTIONTYPE = "key_action_type";
    public static final String KEY_BUTTONTITLE = "key_button_title";
    public static final String KEY_MSG = "key_msg";
    public static final String KEY_SCHEME = "key_scheme";
    public static final String KEY_TITLE = "key_title";

    /* renamed from: a */
    private TextView f53905a;

    /* renamed from: b */
    private TextView f53906b;

    /* renamed from: c */
    private TextView f53907c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ClickCallBack f53908d;

    /* renamed from: e */
    private ShowCallBack f53909e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f53910f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f53911g;

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo148868d2 = {"Lcom/didiglobal/scan/view/ScanErrorDialogFragment$ClickCallBack;", "", "onClick", "", "scan_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: ScanErrorDialogFragment.kt */
    public interface ClickCallBack {
        void onClick();
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo148868d2 = {"Lcom/didiglobal/scan/view/ScanErrorDialogFragment$ShowCallBack;", "", "show", "", "isShow", "", "scan_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: ScanErrorDialogFragment.kt */
    public interface ShowCallBack {
        void show(boolean z);
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JV\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo148868d2 = {"Lcom/didiglobal/scan/view/ScanErrorDialogFragment$Companion;", "", "()V", "KEY_ACTIONTYPE", "", "KEY_BUTTONTITLE", "KEY_MSG", "KEY_SCHEME", "KEY_TITLE", "show", "", "errorMsg", "title", "buttonTitle", "scheme", "actionType", "manager", "Landroidx/fragment/app/FragmentManager;", "callback", "Lcom/didiglobal/scan/view/ScanErrorDialogFragment$ClickCallBack;", "showCallBack", "Lcom/didiglobal/scan/view/ScanErrorDialogFragment$ShowCallBack;", "scan_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: ScanErrorDialogFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void show$default(Companion companion, String str, String str2, String str3, String str4, String str5, FragmentManager fragmentManager, ClickCallBack clickCallBack, ShowCallBack showCallBack, int i, Object obj) {
            int i2 = i;
            companion.show(str, str2, str3, str4, str5, fragmentManager, (i2 & 64) != 0 ? null : clickCallBack, (i2 & 128) != 0 ? null : showCallBack);
        }

        public final void show(String str, String str2, String str3, String str4, String str5, FragmentManager fragmentManager, ClickCallBack clickCallBack, ShowCallBack showCallBack) {
            Intrinsics.checkParameterIsNotNull(str, "errorMsg");
            Intrinsics.checkParameterIsNotNull(fragmentManager, "manager");
            try {
                ScanErrorDialogFragment scanErrorDialogFragment = new ScanErrorDialogFragment();
                Bundle bundle = new Bundle();
                bundle.putString("key_msg", str);
                bundle.putString(ScanErrorDialogFragment.KEY_TITLE, str2);
                bundle.putString(ScanErrorDialogFragment.KEY_BUTTONTITLE, str3);
                bundle.putString(ScanErrorDialogFragment.KEY_ACTIONTYPE, str5);
                bundle.putString(ScanErrorDialogFragment.KEY_SCHEME, str4);
                scanErrorDialogFragment.setArguments(bundle);
                scanErrorDialogFragment.setCallBack(clickCallBack);
                scanErrorDialogFragment.setShowBack(showCallBack);
                scanErrorDialogFragment.show(fragmentManager, "ScanErrorDialogFragment");
            } catch (Exception unused) {
            }
        }
    }

    public final void setCallBack(ClickCallBack clickCallBack) {
        this.f53908d = clickCallBack;
    }

    public final void setShowBack(ShowCallBack showCallBack) {
        this.f53909e = showCallBack;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r2 = r2.getWindow();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityCreated(android.os.Bundle r2) {
        /*
            r1 = this;
            super.onActivityCreated(r2)
            android.app.Dialog r2 = r1.getDialog()
            if (r2 == 0) goto L_0x0014
            android.view.Window r2 = r2.getWindow()
            if (r2 == 0) goto L_0x0014
            android.view.WindowManager$LayoutParams r2 = r2.getAttributes()
            goto L_0x0015
        L_0x0014:
            r2 = 0
        L_0x0015:
            r0 = -1
            if (r2 == 0) goto L_0x001a
            r2.width = r0
        L_0x001a:
            if (r2 == 0) goto L_0x001e
            r2.height = r0
        L_0x001e:
            android.app.Dialog r0 = r1.getDialog()
            if (r0 == 0) goto L_0x002d
            android.view.Window r0 = r0.getWindow()
            if (r0 == 0) goto L_0x002d
            r0.setAttributes(r2)
        L_0x002d:
            android.app.Dialog r2 = r1.getDialog()
            if (r2 == 0) goto L_0x003f
            android.view.Window r2 = r2.getWindow()
            if (r2 == 0) goto L_0x003f
            r0 = 2131233513(0x7f080ae9, float:1.8083166E38)
            r2.setBackgroundDrawableResource(r0)
        L_0x003f:
            android.app.Dialog r2 = r1.getDialog()
            if (r2 == 0) goto L_0x0049
            r0 = 0
            r2.setCanceledOnTouchOutside(r0)
        L_0x0049:
            com.didiglobal.scan.view.ScanErrorDialogFragment$ShowCallBack r2 = r1.f53909e
            if (r2 == 0) goto L_0x0051
            r0 = 1
            r2.show(r0)
        L_0x0051:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.scan.view.ScanErrorDialogFragment.onActivityCreated(android.os.Bundle):void");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.layout_dialog_scan_error, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        m40205a(view);
        m40204a();
        m40206b();
    }

    /* renamed from: a */
    private final void m40205a(View view) {
        this.f53905a = (TextView) view.findViewById(R.id.errorMsg);
        this.f53906b = (TextView) view.findViewById(R.id.title);
        this.f53907c = (TextView) view.findViewById(R.id.retry);
    }

    /* renamed from: a */
    private final void m40204a() {
        String str;
        String str2;
        String str3;
        TextView textView = this.f53905a;
        if (textView != null) {
            Bundle arguments = getArguments();
            if (arguments == null || (str3 = arguments.getString("key_msg")) == null) {
                str3 = ResourcesHelper.getString(getContext(), R.string.Finance_LightSpeedPC_Unidentified_valid_PvEk);
            }
            textView.setText(str3);
        }
        TextView textView2 = this.f53906b;
        if (textView2 != null) {
            Bundle arguments2 = getArguments();
            if (arguments2 == null || (str2 = arguments2.getString(KEY_TITLE)) == null) {
                str2 = ResourcesHelper.getString(getContext(), R.string.Finance_LightSpeedPC_Identification_failed_wKuB);
            }
            textView2.setText(str2);
        }
        TextView textView3 = this.f53907c;
        if (textView3 != null) {
            Bundle arguments3 = getArguments();
            if (arguments3 == null || (str = arguments3.getString(KEY_BUTTONTITLE)) == null) {
                str = ResourcesHelper.getString(getContext(), R.string.Finance_LightSpeedPC_Try_again_Ffyz);
            }
            textView3.setText(str);
        }
        Bundle arguments4 = getArguments();
        String str4 = null;
        this.f53911g = arguments4 != null ? arguments4.getString(KEY_SCHEME) : null;
        Bundle arguments5 = getArguments();
        if (arguments5 != null) {
            str4 = arguments5.getString(KEY_ACTIONTYPE);
        }
        this.f53910f = str4;
    }

    /* renamed from: b */
    private final void m40206b() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnKeyListener(new ScanErrorDialogFragment$initListener$1());
        }
        TextView textView = this.f53907c;
        if (textView != null) {
            textView.setOnClickListener(new ScanErrorDialogFragment$initListener$2(this));
        }
    }

    public void dismiss() {
        ShowCallBack showCallBack = this.f53909e;
        if (showCallBack != null) {
            showCallBack.show(false);
        }
        super.dismiss();
    }
}
