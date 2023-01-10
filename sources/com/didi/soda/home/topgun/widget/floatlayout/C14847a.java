package com.didi.soda.home.topgun.widget.floatlayout;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/floatlayout/StickInfo;", "", "stickHolder", "Lcom/didi/soda/home/topgun/widget/floatlayout/IStickHolder;", "stickView", "Landroid/view/View;", "stickViewParent", "Landroid/view/ViewGroup;", "position", "", "(Lcom/didi/soda/home/topgun/widget/floatlayout/IStickHolder;Landroid/view/View;Landroid/view/ViewGroup;I)V", "getPosition", "()I", "setPosition", "(I)V", "getStickHolder", "()Lcom/didi/soda/home/topgun/widget/floatlayout/IStickHolder;", "setStickHolder", "(Lcom/didi/soda/home/topgun/widget/floatlayout/IStickHolder;)V", "getStickView", "()Landroid/view/View;", "setStickView", "(Landroid/view/View;)V", "getStickViewParent", "()Landroid/view/ViewGroup;", "setStickViewParent", "(Landroid/view/ViewGroup;)V", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.soda.home.topgun.widget.floatlayout.a */
/* compiled from: StickItemImp.kt */
final class C14847a {

    /* renamed from: a */
    private IStickHolder f45813a;

    /* renamed from: b */
    private View f45814b;

    /* renamed from: c */
    private ViewGroup f45815c;

    /* renamed from: d */
    private int f45816d;

    public C14847a(IStickHolder iStickHolder, View view, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(iStickHolder, "stickHolder");
        Intrinsics.checkNotNullParameter(view, "stickView");
        Intrinsics.checkNotNullParameter(viewGroup, "stickViewParent");
        this.f45813a = iStickHolder;
        this.f45814b = view;
        this.f45815c = viewGroup;
        this.f45816d = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C14847a(IStickHolder iStickHolder, View view, ViewGroup viewGroup, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(iStickHolder, view, viewGroup, (i2 & 8) != 0 ? 0 : i);
    }

    /* renamed from: a */
    public final IStickHolder mo114620a() {
        return this.f45813a;
    }

    /* renamed from: a */
    public final void mo114624a(IStickHolder iStickHolder) {
        Intrinsics.checkNotNullParameter(iStickHolder, "<set-?>");
        this.f45813a = iStickHolder;
    }

    /* renamed from: a */
    public final void mo114622a(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.f45814b = view;
    }

    /* renamed from: b */
    public final View mo114625b() {
        return this.f45814b;
    }

    /* renamed from: a */
    public final void mo114623a(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.f45815c = viewGroup;
    }

    /* renamed from: c */
    public final ViewGroup mo114626c() {
        return this.f45815c;
    }

    /* renamed from: a */
    public final void mo114621a(int i) {
        this.f45816d = i;
    }

    /* renamed from: d */
    public final int mo114627d() {
        return this.f45816d;
    }
}
