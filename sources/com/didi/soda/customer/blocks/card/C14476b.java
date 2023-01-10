package com.didi.soda.customer.blocks.card;

import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012F\u0010\u0007\u001aB\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0004\u0012\u00020\r0\b¢\u0006\u0002\u0010\u000eR$\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012RZ\u0010\u0007\u001aB\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0004\u0012\u00020\r0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, mo148868d2 = {"Lcom/didi/soda/customer/blocks/card/TrackCkBean;", "", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "actions", "", "Lcom/didi/soda/blocks/action/BaseAction;", "handler", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Lcom/didi/soda/blocks/widget/Buildable;", "widget", "", "(Lcom/didi/soda/blocks/scope/IBlockScope;Ljava/util/List;Lkotlin/jvm/functions/Function3;)V", "getActions", "()Ljava/util/List;", "setActions", "(Ljava/util/List;)V", "getHandler", "()Lkotlin/jvm/functions/Function3;", "setHandler", "(Lkotlin/jvm/functions/Function3;)V", "getScope", "()Lcom/didi/soda/blocks/scope/IBlockScope;", "setScope", "(Lcom/didi/soda/blocks/scope/IBlockScope;)V", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.soda.customer.blocks.card.b */
/* compiled from: TopicHeaderWidget.kt */
final class C14476b {

    /* renamed from: a */
    private IBlockScope f43203a;

    /* renamed from: b */
    private List<? extends BaseAction> f43204b;

    /* renamed from: c */
    private Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> f43205c;

    public C14476b(IBlockScope iBlockScope, List<? extends BaseAction> list, Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3) {
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        Intrinsics.checkNotNullParameter(function3, "handler");
        this.f43203a = iBlockScope;
        this.f43204b = list;
        this.f43205c = function3;
    }

    /* renamed from: a */
    public final IBlockScope mo108816a() {
        return this.f43203a;
    }

    /* renamed from: a */
    public final void mo108817a(IBlockScope iBlockScope) {
        Intrinsics.checkNotNullParameter(iBlockScope, "<set-?>");
        this.f43203a = iBlockScope;
    }

    /* renamed from: a */
    public final void mo108818a(List<? extends BaseAction> list) {
        this.f43204b = list;
    }

    /* renamed from: b */
    public final List<BaseAction> mo108820b() {
        return this.f43204b;
    }

    /* renamed from: a */
    public final void mo108819a(Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "<set-?>");
        this.f43205c = function3;
    }

    /* renamed from: c */
    public final Function3<IBlockScope, Buildable, List<? extends BaseAction>, Unit> mo108821c() {
        return this.f43205c;
    }
}
