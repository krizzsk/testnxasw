package com.didiglobal.scan.view.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didiglobal.scan.delegate.IViewStyleDelegate;
import com.didiglobal.scan.net.ScanNetRequest;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 ,2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001,B\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J8\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010(\u001a\u0004\u0018\u00010&2\b\u0010)\u001a\u0004\u0018\u00010&2\b\u0010*\u001a\u0004\u0018\u00010&H\u0016J\b\u0010+\u001a\u00020\u0017H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, mo148868d2 = {"Lcom/didiglobal/scan/view/fragment/QrCodeScanFromLocalFragment;", "Lcom/didiglobal/scan/view/fragment/BaseQrScanFragment;", "Lcom/didiglobal/scan/net/ScanNetRequest$LoadingDelegate;", "Lcom/didiglobal/scan/net/ScanNetRequest$ErrorActionDelegate;", "()V", "back", "Landroid/view/View;", "dataUri", "Landroid/net/Uri;", "ok", "preview", "Landroid/widget/ImageView;", "rootView", "dip2px", "", "context", "Landroid/content/Context;", "dpValue", "", "getBg", "Landroid/graphics/drawable/Drawable;", "getTitleBarView", "hideLoading", "", "initListeners", "initView", "onBack", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "showError", "error", "", "title", "buttonTitle", "scheme", "actionType", "showLoading", "Companion", "scan_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: QrCodeScanFromLocalFragment.kt */
public final class QrCodeScanFromLocalFragment extends BaseQrScanFragment implements ScanNetRequest.ErrorActionDelegate, ScanNetRequest.LoadingDelegate {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_URI = "key_uri";

    /* renamed from: a */
    private View f53934a;

    /* renamed from: b */
    private View f53935b;

    /* renamed from: c */
    private View f53936c;

    /* renamed from: d */
    private ImageView f53937d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Uri f53938e;

    public View getTitleBarView() {
        return null;
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo148868d2 = {"Lcom/didiglobal/scan/view/fragment/QrCodeScanFromLocalFragment$Companion;", "", "()V", "KEY_URI", "", "scan_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: QrCodeScanFromLocalFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.layout_fragment_scan_from_local, viewGroup, false);
        this.f53934a = inflate;
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        m40223c();
        m40221a();
    }

    /* renamed from: a */
    private final void m40221a() {
        View view = this.f53935b;
        if (view != null) {
            view.setOnClickListener(new QrCodeScanFromLocalFragment$initListeners$1(this));
        }
        View view2 = this.f53936c;
        if (view2 != null) {
            view2.setOnClickListener(new QrCodeScanFromLocalFragment$initListeners$2(this));
        }
        View view3 = this.f53935b;
        if (view3 != null) {
            view3.setOnClickListener(new QrCodeScanFromLocalFragment$initListeners$3(this));
        }
    }

    public void showError(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkParameterIsNotNull(str, "error");
        UiThreadHandler.getsUiHandler().post(new QrCodeScanFromLocalFragment$showError$1(this, str, str2, str3, str4, str5));
    }

    /* renamed from: b */
    private final Drawable m40222b() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        IViewStyleDelegate viewStyleDelegate = getViewStyleDelegate();
        gradientDrawable.setColor(viewStyleDelegate != null ? viewStyleDelegate.getUploadButtonBgColor() : Color.parseColor("#FFC040"));
        gradientDrawable.setCornerRadius((float) m40220a(getContext(), 14.0f));
        return gradientDrawable;
    }

    /* renamed from: a */
    private final int m40220a(Context context, float f) {
        if (context == null) {
            return (int) f;
        }
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: c */
    private final void m40223c() {
        View view = this.f53934a;
        String str = null;
        this.f53935b = view != null ? view.findViewById(R.id.global_icon_scan_back) : null;
        View view2 = this.f53934a;
        this.f53936c = view2 != null ? view2.findViewById(R.id.global_icon_scan_ok) : null;
        View view3 = this.f53934a;
        this.f53937d = view3 != null ? (ImageView) view3.findViewById(R.id.preview) : null;
        View view4 = this.f53936c;
        if (view4 != null) {
            view4.setBackground(m40222b());
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString(KEY_URI);
        }
        if (TextUtil.isEmpty(str)) {
            onBack();
            return;
        }
        Uri parse = Uri.parse(str);
        this.f53938e = parse;
        ImageView imageView = this.f53937d;
        if (imageView != null) {
            imageView.setImageURI(parse);
        }
    }

    public void onBack() {
        super.onBack();
        QrScanFragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            parentFragment.hideLoading();
        }
        QrScanFragment parentFragment2 = getParentFragment();
        if (parentFragment2 != null) {
            parentFragment2.showScan();
        }
    }

    public void showLoading() {
        QrScanFragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            parentFragment.showLoading();
        }
    }

    public void hideLoading() {
        QrScanFragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            parentFragment.hideLoading();
        }
    }
}
