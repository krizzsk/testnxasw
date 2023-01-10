package com.didi.soda.customer.widget.tabbar;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tJ\u000e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\""}, mo148868d2 = {"Lcom/didi/soda/customer/widget/tabbar/TabBarItemModel;", "", "tabBarItem", "Lcom/didi/soda/customer/widget/tabbar/TabBarItem;", "itemView", "Lcom/didi/soda/customer/widget/tabbar/TabBarItemView;", "tabContainer", "Landroid/view/View;", "isClicked", "", "(Lcom/didi/soda/customer/widget/tabbar/TabBarItem;Lcom/didi/soda/customer/widget/tabbar/TabBarItemView;Landroid/view/View;Z)V", "()Z", "setClicked", "(Z)V", "isControllerInit", "setControllerInit", "<set-?>", "isSelected", "getItemView", "()Lcom/didi/soda/customer/widget/tabbar/TabBarItemView;", "getTabBarItem", "()Lcom/didi/soda/customer/widget/tabbar/TabBarItem;", "getTabContainer", "()Landroid/view/View;", "setTabContainer", "(Landroid/view/View;)V", "setIsSelected", "", "selected", "fromUser", "clickSelf", "updateSelf", "op", "Lcom/didi/soda/customer/widget/tabbar/TabBarOp;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TabBarItemModel.kt */
public final class TabBarItemModel {

    /* renamed from: a */
    private final TabBarItem f44782a;

    /* renamed from: b */
    private final TabBarItemView f44783b;

    /* renamed from: c */
    private View f44784c;

    /* renamed from: d */
    private boolean f44785d;

    /* renamed from: e */
    private boolean f44786e;

    /* renamed from: f */
    private boolean f44787f;

    public TabBarItemModel(TabBarItem tabBarItem, TabBarItemView tabBarItemView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(tabBarItem, "tabBarItem");
        Intrinsics.checkNotNullParameter(tabBarItemView, "itemView");
        this.f44782a = tabBarItem;
        this.f44783b = tabBarItemView;
        this.f44784c = view;
        this.f44785d = z;
        this.f44786e = tabBarItem.isSelected();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TabBarItemModel(TabBarItem tabBarItem, TabBarItemView tabBarItemView, View view, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(tabBarItem, tabBarItemView, (i & 4) != 0 ? null : view, (i & 8) != 0 ? false : z);
    }

    public final TabBarItem getTabBarItem() {
        return this.f44782a;
    }

    public final TabBarItemView getItemView() {
        return this.f44783b;
    }

    public final View getTabContainer() {
        return this.f44784c;
    }

    public final void setTabContainer(View view) {
        this.f44784c = view;
    }

    public final boolean isClicked() {
        return this.f44785d;
    }

    public final void setClicked(boolean z) {
        this.f44785d = z;
    }

    public final boolean isSelected() {
        return this.f44786e;
    }

    public final boolean isControllerInit() {
        return this.f44787f;
    }

    public final void setControllerInit(boolean z) {
        this.f44787f = z;
    }

    public final void setIsSelected(boolean z, boolean z2, boolean z3) {
        TabBarItemView tabBarItemView;
        this.f44786e = z;
        this.f44782a.setSelected(z);
        if (z2 && z) {
            TabBarItemView tabBarItemView2 = this.f44783b;
            if (tabBarItemView2 != null) {
                tabBarItemView2.saveClickTimeForDiscountTagView(this);
            }
            this.f44785d = true;
            if (z3 && (tabBarItemView = this.f44783b) != null) {
                tabBarItemView.checkShouldBackToTop(this);
            }
        }
        this.f44783b.updateTabBarItem(this);
        View view = this.f44784c;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public final void updateSelf(TabBarOp tabBarOp) {
        ComponentController controller;
        Intrinsics.checkNotNullParameter(tabBarOp, "op");
        this.f44783b.updateTabBarItem(this);
        if (tabBarOp == TabBarOp.UPDATE_ALL && this.f44787f && (controller = this.f44782a.getController()) != null) {
            controller.internOnTabUpdate(this.f44782a.getParams());
        }
    }
}
