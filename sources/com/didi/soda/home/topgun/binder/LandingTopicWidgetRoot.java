package com.didi.soda.home.topgun.binder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.customer.blocks.binderpool.BinderRoot;
import com.didi.soda.customer.blocks.card.LandingTopicWidget;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0003H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0016"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/binder/LandingTopicWidgetRoot;", "Lcom/didi/soda/customer/blocks/binderpool/BinderRoot;", "Lcom/didi/soda/customer/blocks/card/LandingTopicWidget;", "Lcom/didi/soda/blocks/model/ComponentModel;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "type", "", "(Lcom/didi/soda/blocks/scope/IBlockScope;Ljava/lang/String;)V", "getScope", "()Lcom/didi/soda/blocks/scope/IBlockScope;", "setScope", "(Lcom/didi/soda/blocks/scope/IBlockScope;)V", "bind", "", "view", "data", "position", "", "createView", "context", "Landroid/content/Context;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HomeRecyclerBinder.kt */
public final class LandingTopicWidgetRoot extends BinderRoot<LandingTopicWidget, ComponentModel> {

    /* renamed from: a */
    private IBlockScope f45253a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LandingTopicWidgetRoot(IBlockScope iBlockScope, String str) {
        super(str, (BinderRootConfig) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        Intrinsics.checkNotNullParameter(str, "type");
        this.f45253a = iBlockScope;
    }

    public final IBlockScope getScope() {
        return this.f45253a;
    }

    public final void setScope(IBlockScope iBlockScope) {
        Intrinsics.checkNotNullParameter(iBlockScope, "<set-?>");
        this.f45253a = iBlockScope;
    }

    public LandingTopicWidget createView(Context context, ComponentModel componentModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(componentModel, "data");
        LandingTopicWidget landingTopicWidget = null;
        Buildable renderViewWithData$default = BlocksEngine.renderViewWithData$default(BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null), context, this.f45253a, componentModel.getWidgetNodeModel(), (BinderRootConfig) null, 8, (Object) null);
        View view = renderViewWithData$default == null ? null : renderViewWithData$default.getView();
        if (view instanceof LandingTopicWidget) {
            landingTopicWidget = (LandingTopicWidget) view;
        }
        return landingTopicWidget == null ? new LandingTopicWidget(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null) : landingTopicWidget;
    }

    public void bind(LandingTopicWidget landingTopicWidget, ComponentModel componentModel, int i) {
        Intrinsics.checkNotNullParameter(landingTopicWidget, "view");
        Intrinsics.checkNotNullParameter(componentModel, "data");
        Buildable buildable = landingTopicWidget;
        super.bind(buildable, componentModel, i);
        BlocksEngine.bindDataOnWidget$default(BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null), this.f45253a, buildable, componentModel.getWidgetNodeModel(), (BinderRootConfig) null, 8, (Object) null);
    }
}
