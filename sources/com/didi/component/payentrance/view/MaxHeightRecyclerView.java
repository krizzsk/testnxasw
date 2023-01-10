package com.didi.component.payentrance.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.business.util.UiUtils;
import com.didi.raven.config.RavenKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tH\u0014J\b\u0010\u001e\u001a\u00020\u001aH\u0002R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo148868d2 = {"Lcom/didi/component/payentrance/view/MaxHeightRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomViewHeight", "isShowBottomView", "", "()Z", "setShowBottomView", "(Z)V", "mWindowHeight", "getMWindowHeight", "()I", "setMWindowHeight", "(I)V", "maxHeight", "statusBarHeight", "toolBarHeight", "init", "", "onMeasure", "widthSpec", "heightSpec", "updateMaxHeight", "comp-payentrance_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: MaxHeightRecyclerView.kt */
public final class MaxHeightRecyclerView extends RecyclerView {

    /* renamed from: a */
    private int f16841a;

    /* renamed from: b */
    private int f16842b;

    /* renamed from: c */
    private int f16843c;

    /* renamed from: d */
    private int f16844d;

    /* renamed from: e */
    private int f16845e;

    /* renamed from: f */
    private boolean f16846f;

    public void _$_clearFindViewByIdCache() {
    }

    public final int getMWindowHeight() {
        return this.f16845e;
    }

    public final void setMWindowHeight(int i) {
        this.f16845e = i;
    }

    public final boolean isShowBottomView() {
        return this.f16846f;
    }

    public final void setShowBottomView(boolean z) {
        this.f16846f = z;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MaxHeightRecyclerView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MaxHeightRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
        m14172a(context, attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MaxHeightRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
        m14172a(context, attributeSet);
    }

    /* renamed from: a */
    private final void m14172a(Context context, AttributeSet attributeSet) {
        this.f16842b = UiUtils.getStatusBarHeight(context);
        this.f16843c = UiUtils.dip2px(context, 44.0f);
        m14171a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        m14171a();
        int i3 = this.f16841a;
        if (i3 > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }

    /* renamed from: a */
    private final void m14171a() {
        if (this.f16846f) {
            this.f16844d = UiUtils.dip2px(getContext(), 30.0f);
        }
        int i = this.f16845e;
        this.f16841a = i > 0 ? ((i - this.f16842b) - this.f16843c) - this.f16844d : 0;
    }
}
