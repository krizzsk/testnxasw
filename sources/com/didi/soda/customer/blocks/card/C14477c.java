package com.didi.soda.customer.blocks.card;

import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0002\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012[\u0010\t\u001aW\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\u0002\u0010\u0010R$\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014Ro\u0010\t\u001aW\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u000f0\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, mo148868d2 = {"Lcom/didi/soda/customer/blocks/card/TrackSwBean;", "", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "widgetNodeModel", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "actions", "", "Lcom/didi/soda/blocks/action/BaseAction;", "handler", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "Lcom/didi/soda/blocks/widget/Buildable;", "widget", "", "(Lcom/didi/soda/blocks/scope/IBlockScope;Lcom/didi/soda/blocks/model/WidgetNodeModel;Ljava/util/List;Lkotlin/jvm/functions/Function4;)V", "getActions", "()Ljava/util/List;", "setActions", "(Ljava/util/List;)V", "getHandler", "()Lkotlin/jvm/functions/Function4;", "setHandler", "(Lkotlin/jvm/functions/Function4;)V", "getScope", "()Lcom/didi/soda/blocks/scope/IBlockScope;", "setScope", "(Lcom/didi/soda/blocks/scope/IBlockScope;)V", "getWidgetNodeModel", "()Lcom/didi/soda/blocks/model/WidgetNodeModel;", "setWidgetNodeModel", "(Lcom/didi/soda/blocks/model/WidgetNodeModel;)V", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.soda.customer.blocks.card.c */
/* compiled from: TopicItemWidget.kt */
final class C14477c {

    /* renamed from: a */
    private IBlockScope f43206a;

    /* renamed from: b */
    private WidgetNodeModel f43207b;

    /* renamed from: c */
    private List<? extends BaseAction> f43208c;

    /* renamed from: d */
    private Function4<? super IBlockScope, ? super WidgetNodeModel, ? super Buildable, ? super List<? extends BaseAction>, Unit> f43209d;

    public C14477c(IBlockScope iBlockScope, WidgetNodeModel widgetNodeModel, List<? extends BaseAction> list, Function4<? super IBlockScope, ? super WidgetNodeModel, ? super Buildable, ? super List<? extends BaseAction>, Unit> function4) {
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        Intrinsics.checkNotNullParameter(widgetNodeModel, "widgetNodeModel");
        Intrinsics.checkNotNullParameter(function4, "handler");
        this.f43206a = iBlockScope;
        this.f43207b = widgetNodeModel;
        this.f43208c = list;
        this.f43209d = function4;
    }

    /* renamed from: a */
    public final IBlockScope mo108822a() {
        return this.f43206a;
    }

    /* renamed from: a */
    public final void mo108824a(IBlockScope iBlockScope) {
        Intrinsics.checkNotNullParameter(iBlockScope, "<set-?>");
        this.f43206a = iBlockScope;
    }

    /* renamed from: a */
    public final void mo108823a(WidgetNodeModel widgetNodeModel) {
        Intrinsics.checkNotNullParameter(widgetNodeModel, "<set-?>");
        this.f43207b = widgetNodeModel;
    }

    /* renamed from: b */
    public final WidgetNodeModel mo108827b() {
        return this.f43207b;
    }

    /* renamed from: a */
    public final void mo108825a(List<? extends BaseAction> list) {
        this.f43208c = list;
    }

    /* renamed from: c */
    public final List<BaseAction> mo108828c() {
        return this.f43208c;
    }

    /* renamed from: a */
    public final void mo108826a(Function4<? super IBlockScope, ? super WidgetNodeModel, ? super Buildable, ? super List<? extends BaseAction>, Unit> function4) {
        Intrinsics.checkNotNullParameter(function4, "<set-?>");
        this.f43209d = function4;
    }

    /* renamed from: d */
    public final Function4<IBlockScope, WidgetNodeModel, Buildable, List<? extends BaseAction>, Unit> mo108829d() {
        return this.f43209d;
    }
}
