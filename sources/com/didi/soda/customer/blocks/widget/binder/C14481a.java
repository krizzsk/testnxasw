package com.didi.soda.customer.blocks.widget.binder;

import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0002\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012J\b\u0002\u0010\t\u001aD\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0002\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\u0004\u0012\u00020\r\u0018\u00010\n¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u001f\u001a\u00020\rR$\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\\\u0010\t\u001aD\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0002\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\u0004\u0012\u00020\r\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006 "}, mo148868d2 = {"Lcom/didi/soda/customer/blocks/widget/binder/TrackBean;", "", "widget", "Lcom/didi/soda/blocks/widget/Buildable;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "actions", "", "Lcom/didi/soda/blocks/action/BaseAction;", "handler", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "", "(Lcom/didi/soda/blocks/widget/Buildable;Lcom/didi/soda/blocks/scope/IBlockScope;Ljava/util/List;Lkotlin/jvm/functions/Function3;)V", "getActions", "()Ljava/util/List;", "setActions", "(Ljava/util/List;)V", "getHandler", "()Lkotlin/jvm/functions/Function3;", "setHandler", "(Lkotlin/jvm/functions/Function3;)V", "getScope", "()Lcom/didi/soda/blocks/scope/IBlockScope;", "setScope", "(Lcom/didi/soda/blocks/scope/IBlockScope;)V", "getWidget", "()Lcom/didi/soda/blocks/widget/Buildable;", "setWidget", "(Lcom/didi/soda/blocks/widget/Buildable;)V", "track", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.soda.customer.blocks.widget.binder.a */
/* compiled from: FeedBackBinder.kt */
final class C14481a {

    /* renamed from: a */
    private Buildable f43354a;

    /* renamed from: b */
    private IBlockScope f43355b;

    /* renamed from: c */
    private List<? extends BaseAction> f43356c;

    /* renamed from: d */
    private Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> f43357d;

    public C14481a(Buildable buildable, IBlockScope iBlockScope, List<? extends BaseAction> list, Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3) {
        Intrinsics.checkNotNullParameter(buildable, "widget");
        this.f43354a = buildable;
        this.f43355b = iBlockScope;
        this.f43356c = list;
        this.f43357d = function3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C14481a(Buildable buildable, IBlockScope iBlockScope, List list, Function3 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(buildable, (i & 2) != 0 ? null : iBlockScope, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : function3);
    }

    /* renamed from: a */
    public final Buildable mo109016a() {
        return this.f43354a;
    }

    /* renamed from: a */
    public final void mo109018a(Buildable buildable) {
        Intrinsics.checkNotNullParameter(buildable, "<set-?>");
        this.f43354a = buildable;
    }

    /* renamed from: a */
    public final void mo109017a(IBlockScope iBlockScope) {
        this.f43355b = iBlockScope;
    }

    /* renamed from: b */
    public final IBlockScope mo109021b() {
        return this.f43355b;
    }

    /* renamed from: a */
    public final void mo109019a(List<? extends BaseAction> list) {
        this.f43356c = list;
    }

    /* renamed from: c */
    public final List<BaseAction> mo109022c() {
        return this.f43356c;
    }

    /* renamed from: a */
    public final void mo109020a(Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3) {
        this.f43357d = function3;
    }

    /* renamed from: d */
    public final Function3<IBlockScope, Buildable, List<? extends BaseAction>, Unit> mo109023d() {
        return this.f43357d;
    }

    /* renamed from: e */
    public final void mo109024e() {
        Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3;
        IBlockScope iBlockScope = this.f43355b;
        if (iBlockScope != null && (function3 = this.f43357d) != null) {
            Intrinsics.checkNotNull(iBlockScope);
            function3.invoke(iBlockScope, this.f43354a, this.f43356c);
        }
    }
}
