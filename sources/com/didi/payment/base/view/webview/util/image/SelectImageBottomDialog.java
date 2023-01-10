package com.didi.payment.base.view.webview.util.image;

import android.view.View;
import android.widget.TextView;
import com.didi.sdk.view.SimplePopupBase;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0005H\u0014R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006\u001c"}, mo148868d2 = {"Lcom/didi/payment/base/view/webview/util/image/SelectImageBottomDialog;", "Lcom/didi/sdk/view/SimplePopupBase;", "()V", "onAlbumClick", "Lkotlin/Function0;", "", "getOnAlbumClick", "()Lkotlin/jvm/functions/Function0;", "setOnAlbumClick", "(Lkotlin/jvm/functions/Function0;)V", "onCameraClick", "getOnCameraClick", "setOnCameraClick", "tv_album", "Landroid/widget/TextView;", "getTv_album", "()Landroid/widget/TextView;", "setTv_album", "(Landroid/widget/TextView;)V", "tv_camera", "getTv_camera", "setTv_camera", "tv_cancel", "getTv_cancel", "setTv_cancel", "getLayout", "", "initView", "base_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SelectImageBottomDialog.kt */
public final class SelectImageBottomDialog extends SimplePopupBase {

    /* renamed from: a */
    private Function0<Unit> f32567a;

    /* renamed from: b */
    private Function0<Unit> f32568b;

    /* renamed from: c */
    private TextView f32569c;

    /* renamed from: d */
    private TextView f32570d;

    /* renamed from: e */
    private TextView f32571e;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.dialog_select_image;
    }

    public final Function0<Unit> getOnAlbumClick() {
        return this.f32567a;
    }

    public final void setOnAlbumClick(Function0<Unit> function0) {
        this.f32567a = function0;
    }

    public final Function0<Unit> getOnCameraClick() {
        return this.f32568b;
    }

    public final void setOnCameraClick(Function0<Unit> function0) {
        this.f32568b = function0;
    }

    public final TextView getTv_album() {
        return this.f32569c;
    }

    public final void setTv_album(TextView textView) {
        this.f32569c = textView;
    }

    public final TextView getTv_camera() {
        return this.f32570d;
    }

    public final void setTv_camera(TextView textView) {
        this.f32570d = textView;
    }

    public final TextView getTv_cancel() {
        return this.f32571e;
    }

    public final void setTv_cancel(TextView textView) {
        this.f32571e = textView;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f32569c = (TextView) this.mRootView.findViewById(R.id.tv_album);
        this.f32570d = (TextView) this.mRootView.findViewById(R.id.tv_camera);
        this.f32571e = (TextView) this.mRootView.findViewById(R.id.tv_cancel);
        TextView textView = this.f32569c;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    SelectImageBottomDialog.m24697a(SelectImageBottomDialog.this, view);
                }
            });
        }
        TextView textView2 = this.f32570d;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    SelectImageBottomDialog.m24698b(SelectImageBottomDialog.this, view);
                }
            });
        }
        TextView textView3 = this.f32571e;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    SelectImageBottomDialog.m24699c(SelectImageBottomDialog.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m24697a(SelectImageBottomDialog selectImageBottomDialog, View view) {
        Intrinsics.checkNotNullParameter(selectImageBottomDialog, "this$0");
        selectImageBottomDialog.dismiss();
        Function0<Unit> onAlbumClick = selectImageBottomDialog.getOnAlbumClick();
        if (onAlbumClick != null) {
            onAlbumClick.invoke();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m24698b(SelectImageBottomDialog selectImageBottomDialog, View view) {
        Intrinsics.checkNotNullParameter(selectImageBottomDialog, "this$0");
        selectImageBottomDialog.dismiss();
        Function0<Unit> onCameraClick = selectImageBottomDialog.getOnCameraClick();
        if (onCameraClick != null) {
            onCameraClick.invoke();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m24699c(SelectImageBottomDialog selectImageBottomDialog, View view) {
        Intrinsics.checkNotNullParameter(selectImageBottomDialog, "this$0");
        selectImageBottomDialog.dismiss();
    }
}
