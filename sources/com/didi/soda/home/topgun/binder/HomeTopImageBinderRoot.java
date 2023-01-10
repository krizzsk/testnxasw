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
import com.didi.soda.customer.blocks.card.TopImageBusinessItemWidget;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\u0002\u0010\nJ \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/binder/HomeTopImageBinderRoot;", "Lcom/didi/soda/customer/blocks/binderpool/BinderRoot;", "Lcom/didi/soda/customer/blocks/card/TopImageBusinessItemWidget;", "Lcom/didi/soda/blocks/model/ComponentModel;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "type", "", "config", "Lcom/didi/soda/blocks/BinderRootConfig;", "(Lcom/didi/soda/blocks/scope/IBlockScope;Ljava/lang/String;Lcom/didi/soda/blocks/BinderRootConfig;)V", "getScope", "()Lcom/didi/soda/blocks/scope/IBlockScope;", "setScope", "(Lcom/didi/soda/blocks/scope/IBlockScope;)V", "bind", "", "view", "data", "position", "", "createView", "context", "Landroid/content/Context;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HomeRecyclerBinder.kt */
public final class HomeTopImageBinderRoot extends BinderRoot<TopImageBusinessItemWidget, ComponentModel> {

    /* renamed from: a */
    private IBlockScope f45249a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeTopImageBinderRoot(IBlockScope iBlockScope, String str, BinderRootConfig<ComponentModel> binderRootConfig) {
        super(str, binderRootConfig);
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        Intrinsics.checkNotNullParameter(str, "type");
        this.f45249a = iBlockScope;
    }

    public final IBlockScope getScope() {
        return this.f45249a;
    }

    public final void setScope(IBlockScope iBlockScope) {
        Intrinsics.checkNotNullParameter(iBlockScope, "<set-?>");
        this.f45249a = iBlockScope;
    }

    public TopImageBusinessItemWidget createView(Context context, ComponentModel componentModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(componentModel, "data");
        TopImageBusinessItemWidget topImageBusinessItemWidget = null;
        Buildable renderViewWithData = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).renderViewWithData(context, this.f45249a, componentModel.getWidgetNodeModel(), getConfig());
        View view = renderViewWithData == null ? null : renderViewWithData.getView();
        if (view instanceof TopImageBusinessItemWidget) {
            topImageBusinessItemWidget = (TopImageBusinessItemWidget) view;
        }
        return topImageBusinessItemWidget == null ? new TopImageBusinessItemWidget(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null) : topImageBusinessItemWidget;
    }

    public void bind(TopImageBusinessItemWidget topImageBusinessItemWidget, ComponentModel componentModel, int i) {
        Intrinsics.checkNotNullParameter(topImageBusinessItemWidget, "view");
        Intrinsics.checkNotNullParameter(componentModel, "data");
        Buildable buildable = topImageBusinessItemWidget;
        super.bind(buildable, componentModel, i);
        BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).bindDataOnWidget(this.f45249a, buildable, componentModel.getWidgetNodeModel(), getConfig());
    }
}
