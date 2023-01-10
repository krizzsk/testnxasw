package com.didi.soda.home.shimmer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, mo148868d2 = {"Lcom/didi/soda/home/shimmer/ShimmerItemView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mShimmerColors", "", "getMShimmerColors", "()[I", "setMShimmerColors", "([I)V", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ShimmerItemView.kt */
public final class ShimmerItemView extends View {

    /* renamed from: a */
    private int[] f45215a = {1725158355, -1714170925, -858532909, -2894893, -2894893, -858532909, -1714170925, 1725158355};

    public void _$_clearFindViewByIdCache() {
    }

    public ShimmerItemView(Context context) {
        super(context);
    }

    public ShimmerItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ShimmerItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final int[] getMShimmerColors() {
        return this.f45215a;
    }

    public final void setMShimmerColors(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.f45215a = iArr;
    }
}
