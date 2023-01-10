package com.didi.soda.customer.widget.tabbar;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.soda.customer.app.CustomerActivityManager;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IOneSdkService;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001JB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020 H\u0002J\u000e\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\u001cJ\b\u0010'\u001a\u00020 H\u0007J\u001e\u0010(\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010)\u001a\u00020 2\u0006\u0010!\u001a\u00020\bH\u0002J\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u001eH\u0002J\u0010\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020 2\u0006\u0010-\u001a\u00020.H\u0002J\u0012\u00100\u001a\u0004\u0018\u00010\b2\u0006\u00101\u001a\u00020\u001eH\u0002J\u0010\u00102\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u00103\u001a\u0002042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J$\u00105\u001a\u00020 2\b\u00106\u001a\u0004\u0018\u00010\u001e2\u0006\u00107\u001a\u00020\u001e2\b\b\u0002\u00108\u001a\u00020\u000eH\u0002J\u001a\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020\b2\b\b\u0002\u00108\u001a\u00020\u000eH\u0002J&\u0010;\u001a\u00020 2\u0006\u00101\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001e0=H\u0002J\u001a\u0010>\u001a\u00020#2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000e0@J\u0006\u0010A\u001a\u00020#J\u0010\u0010B\u001a\u00020 2\u0006\u0010!\u001a\u00020\bH\u0002J\u0018\u0010C\u001a\u00020 2\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u00108\u001a\u00020\u000eJ\u0010\u0010D\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020.H\u0002J\u0018\u0010E\u001a\u00020 2\u0006\u0010F\u001a\u0002042\u0006\u0010G\u001a\u00020\bH\u0002J\b\u0010H\u001a\u00020 H\u0002J\u0014\u0010I\u001a\u00020 2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0=R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\t\u001a\u00060\nR\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001aX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001aX\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, mo148868d2 = {"Lcom/didi/soda/customer/widget/tabbar/TabBarController;", "", "()V", "componentCallback", "Lcom/didi/soda/customer/widget/tabbar/TabComponentCallback;", "context", "Landroid/content/Context;", "curSelected", "Lcom/didi/soda/customer/widget/tabbar/TabBarItemModel;", "event", "Lcom/didi/soda/customer/widget/tabbar/TabBarController$Event;", "getEvent", "()Lcom/didi/soda/customer/widget/tabbar/TabBarController$Event;", "isShowed", "", "onTabBarChangedListener", "Lcom/didi/soda/customer/widget/tabbar/OnTabChangedListener;", "getOnTabBarChangedListener", "()Lcom/didi/soda/customer/widget/tabbar/OnTabChangedListener;", "setOnTabBarChangedListener", "(Lcom/didi/soda/customer/widget/tabbar/OnTabChangedListener;)V", "pageCallback", "Lcom/didi/soda/customer/widget/tabbar/PageCallback;", "tabBar", "Landroid/widget/LinearLayout;", "tabBarModels", "", "tabContentView", "Landroid/view/ViewGroup;", "toUpdateList", "Lcom/didi/soda/customer/widget/tabbar/TabBarItem;", "addToTab", "", "tabBarItemModel", "index", "", "adjustTabOrder", "anchor", "parentView", "apply", "attach", "checkControllerIsInit", "checkRepeatAdd", "toAddItem", "componentAddToPage", "controller", "Lcom/didi/soda/customer/widget/tabbar/ComponentController;", "componentRemoveFromPage", "createTabBarItemModel", "tabBarItem", "createTabContainerView", "createTabItemView", "Lcom/didi/soda/customer/widget/tabbar/TabBarItemView;", "dispatchTabChangedEvent", "pre", "next", "fromUser", "doTabChangeEvent", "waitSelected", "fallbackWhenApply", "updateList", "", "findTabIndex", "predicate", "Lkotlin/Function1;", "getSelectedTabIndex", "removeFromTab", "selectTab", "setupTabContent", "setupTabItemView", "tabItemView", "model", "updateSelectState", "updateTabBarItem", "Event", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TabBarController.kt */
public final class TabBarController {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final List<TabBarItemModel> f44750a = new ArrayList();

    /* renamed from: b */
    private final List<TabBarItem> f44751b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public TabBarItemModel f44752c;

    /* renamed from: d */
    private boolean f44753d;

    /* renamed from: e */
    private ViewGroup f44754e;

    /* renamed from: f */
    private LinearLayout f44755f;

    /* renamed from: g */
    private PageCallback f44756g;

    /* renamed from: h */
    private Context f44757h;

    /* renamed from: i */
    private OnTabChangedListener f44758i;

    /* renamed from: j */
    private final Event f44759j = new Event(this);

    /* renamed from: k */
    private TabComponentCallback f44760k;

    @Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: TabBarController.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TabBarOp.values().length];
            iArr[TabBarOp.ADD.ordinal()] = 1;
            iArr[TabBarOp.UPDATE_ALL.ordinal()] = 2;
            iArr[TabBarOp.UPDATE_TAB.ordinal()] = 3;
            iArr[TabBarOp.NONE.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final OnTabChangedListener getOnTabBarChangedListener() {
        return this.f44758i;
    }

    public final void setOnTabBarChangedListener(OnTabChangedListener onTabChangedListener) {
        this.f44758i = onTabChangedListener;
    }

    public final Event getEvent() {
        return this.f44759j;
    }

    public final void attach(Context context, PageCallback pageCallback, TabComponentCallback tabComponentCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageCallback, "pageCallback");
        Intrinsics.checkNotNullParameter(tabComponentCallback, "componentCallback");
        this.f44757h = context;
        this.f44760k = tabComponentCallback;
        this.f44756g = pageCallback;
    }

    public final void anchor(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parentView");
        if (this.f44753d) {
            LogUtil.m32590w("TabBar", "TabBarController, Error, 多次调用 show() 方法！！！");
            return;
        }
        this.f44753d = true;
        Context context = this.f44757h;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        View inflate = View.inflate(context, R.layout.customer_widget_tabbar_layout, viewGroup);
        this.f44755f = (LinearLayout) inflate.findViewById(R.id.customer_tabbar_item_layout);
        this.f44754e = (ViewGroup) inflate.findViewById(R.id.customer_tabbar_content_layout);
    }

    /* renamed from: a */
    private final void m33206a(TabBarItemModel tabBarItemModel) {
        ViewGroup viewGroup;
        if (this.f44755f != null) {
            ViewGroup viewGroup2 = this.f44754e;
        }
        LinearLayout linearLayout = this.f44755f;
        if (linearLayout != null) {
            linearLayout.removeView(tabBarItemModel.getItemView());
        }
        if (!(tabBarItemModel.getTabContainer() == null || (viewGroup = this.f44754e) == null)) {
            viewGroup.removeView(tabBarItemModel.getTabContainer());
        }
        if (tabBarItemModel.getTabBarItem().getController() != null) {
            ComponentController controller = tabBarItemModel.getTabBarItem().getController();
            Intrinsics.checkNotNull(controller);
            m33216c(controller);
            this.f44759j.dispatchPageEventWhenRemove(controller);
            controller.internOnTabRemoveEvent();
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m33201a(TabBarController tabBarController, TabBarItemModel tabBarItemModel, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        tabBarController.m33207a(tabBarItemModel, i);
    }

    /* renamed from: a */
    private final void m33207a(TabBarItemModel tabBarItemModel, int i) {
        ViewGroup viewGroup;
        if (this.f44755f != null) {
            ViewGroup viewGroup2 = this.f44754e;
        }
        LinearLayout linearLayout = this.f44755f;
        if (linearLayout != null) {
            linearLayout.addView(tabBarItemModel.getItemView(), i);
        }
        if (tabBarItemModel.getTabContainer() != null && (viewGroup = this.f44754e) != null) {
            viewGroup.addView(tabBarItemModel.getTabContainer(), i);
        }
    }

    /* renamed from: a */
    private final void m33199a() {
        if (this.f44755f != null && this.f44754e != null) {
            Iterator it = this.f44750a.iterator();
            boolean z = false;
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                LinearLayout linearLayout = this.f44755f;
                Intrinsics.checkNotNull(linearLayout);
                if (linearLayout.indexOfChild(((TabBarItemModel) next).getItemView()) != i) {
                    z = true;
                    break;
                }
                i = i2;
            }
            if (z) {
                LinearLayout linearLayout2 = this.f44755f;
                Intrinsics.checkNotNull(linearLayout2);
                linearLayout2.removeAllViews();
                ViewGroup viewGroup = this.f44754e;
                Intrinsics.checkNotNull(viewGroup);
                viewGroup.removeAllViews();
                for (TabBarItemModel tabBarItemModel : this.f44750a) {
                    LinearLayout linearLayout3 = this.f44755f;
                    Intrinsics.checkNotNull(linearLayout3);
                    linearLayout3.addView(tabBarItemModel.getItemView());
                    if (tabBarItemModel.isControllerInit()) {
                        ViewGroup viewGroup2 = this.f44754e;
                        Intrinsics.checkNotNull(viewGroup2);
                        viewGroup2.addView(tabBarItemModel.getTabContainer());
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private final void m33213b() {
        Unit unit;
        TabBarItemModel tabBarItemModel = null;
        boolean z = false;
        for (TabBarItemModel tabBarItemModel2 : this.f44750a) {
            if (tabBarItemModel2.isSelected()) {
                tabBarItemModel = tabBarItemModel2;
            }
            if (Intrinsics.areEqual((Object) this.f44752c, (Object) tabBarItemModel2)) {
                z = true;
            }
        }
        if (tabBarItemModel == null) {
            tabBarItemModel = z ? this.f44752c : null;
        }
        if (tabBarItemModel == null) {
            unit = null;
        } else {
            if (!Intrinsics.areEqual((Object) this.f44752c, (Object) tabBarItemModel)) {
                m33215b(tabBarItemModel);
                m33203a(this, tabBarItemModel, false, 2, (Object) null);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null && this.f44750a.size() > 0) {
            TabBarItemModel tabBarItemModel3 = this.f44750a.get(0);
            m33215b(tabBarItemModel3);
            m33203a(this, tabBarItemModel3, false, 2, (Object) null);
        }
    }

    public final int getSelectedTabIndex() {
        TabBarItemModel tabBarItemModel = this.f44752c;
        if (tabBarItemModel == null) {
            return -1;
        }
        List<TabBarItemModel> list = this.f44750a;
        Intrinsics.checkNotNull(tabBarItemModel);
        return list.indexOf(tabBarItemModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m33215b(TabBarItemModel tabBarItemModel) {
        if (!tabBarItemModel.isControllerInit()) {
            LogUtil.m32584d("TabBarController", "init it when you click it.");
            ComponentController controller = tabBarItemModel.getTabBarItem().getController();
            if (controller != null) {
                View a = m33198a(controller);
                tabBarItemModel.setTabContainer(a);
                tabBarItemModel.setControllerInit(true);
                ViewGroup viewGroup = this.f44754e;
                if (viewGroup != null) {
                    viewGroup.addView(a);
                }
                m33214b(controller);
                this.f44759j.dispatchPageEventWhenAdd(controller);
            }
        }
    }

    /* renamed from: a */
    private final boolean m33210a(TabBarItem tabBarItem) {
        Object obj;
        Iterator it = this.f44750a.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) tabBarItem, (Object) ((TabBarItemModel) obj).getTabBarItem())) {
                break;
            }
        }
        if (((TabBarItemModel) obj) == null) {
            return false;
        }
        LogUtil.m32590w("TabBarController", "item = " + tabBarItem + ", 检查是否有重复添加TabBarItem！！！");
        return true;
    }

    public final void updateTabBarItem(List<TabBarItem> list) {
        Intrinsics.checkNotNullParameter(list, "toUpdateList");
        this.f44751b.addAll(list);
    }

    /* renamed from: a */
    private final void m33204a(TabBarItem tabBarItem, int i, List<TabBarItem> list) {
        TabBarItemModel b;
        try {
            String traceInfo = CustomerActivityManager.getInstance().getActivityTraceInfo().getTraceInfo();
            String str = "";
            for (TabBarItem tabBarItem2 : list) {
                str = str + '|' + tabBarItem2.getText() + '-' + tabBarItem2.getOp() + '|';
            }
            OmegaTracker.Builder.create(EventConst.Home.SAILING_C_X_HOME_TAB_ERROR).addEventParam("trace_info", traceInfo).addEventParam("to_update_info", str).addEventParam("subscribe_count", Integer.valueOf(((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).getTabSubscribeNum())).addEventParam("index", Integer.valueOf(i)).build().track();
            Boolean isOpenTabFallback = CustomerApolloUtil.isOpenTabFallback();
            Intrinsics.checkNotNullExpressionValue(isOpenTabFallback, "isOpenTabFallback()");
            if (isOpenTabFallback.booleanValue() && (b = m33211b(tabBarItem)) != null) {
                m33207a(b, i);
                this.f44750a.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: com.didi.soda.customer.widget.tabbar.TabBarItemModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: com.didi.soda.customer.widget.tabbar.TabBarItemModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v0, resolved type: com.didi.soda.customer.widget.tabbar.TabBarItemModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: com.didi.soda.customer.widget.tabbar.TabBarItemModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: com.didi.soda.customer.widget.tabbar.TabBarItemModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: com.didi.soda.customer.widget.tabbar.TabBarItemModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: com.didi.soda.customer.widget.tabbar.TabBarItemModel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void apply() {
        /*
            r13 = this;
            java.util.List<com.didi.soda.customer.widget.tabbar.TabBarItem> r0 = r13.f44751b
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.List<com.didi.soda.customer.widget.tabbar.TabBarItem> r1 = r13.f44751b
            java.util.Collection r1 = (java.util.Collection) r1
            r0.<init>(r1)
            java.util.List<com.didi.soda.customer.widget.tabbar.TabBarItem> r1 = r13.f44751b
            r1.clear()
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.List<com.didi.soda.customer.widget.tabbar.TabBarItemModel> r2 = r13.f44750a
            java.util.Collection r2 = (java.util.Collection) r2
            r1.<init>(r2)
            java.util.List<com.didi.soda.customer.widget.tabbar.TabBarItemModel> r2 = r13.f44750a
            r2.clear()
            r2 = r0
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            r3 = 0
            java.util.Iterator r2 = r2.iterator()
        L_0x002d:
            boolean r4 = r2.hasNext()
            r5 = 0
            if (r4 == 0) goto L_0x00f5
            java.lang.Object r4 = r2.next()
            int r6 = r3 + 1
            if (r3 >= 0) goto L_0x003f
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x003f:
            com.didi.soda.customer.widget.tabbar.TabBarItem r4 = (com.didi.soda.customer.widget.tabbar.TabBarItem) r4
            com.didi.soda.customer.widget.tabbar.TabBarOp r7 = r4.getOp()
            int[] r8 = com.didi.soda.customer.widget.tabbar.TabBarController.WhenMappings.$EnumSwitchMapping$0
            int r7 = r7.ordinal()
            r7 = r8[r7]
            r8 = 1
            java.lang.String r9 = "tabBarItem"
            if (r7 == r8) goto L_0x00dc
            r8 = 2
            java.lang.String r10 = "找不到对于的model!!!!"
            java.lang.String r11 = "TabController"
            if (r7 == r8) goto L_0x009c
            r8 = 3
            if (r7 == r8) goto L_0x009c
            r8 = 4
            if (r7 == r8) goto L_0x0063
            goto L_0x00ed
        L_0x0063:
            r7 = r1
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L_0x006a:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0082
            java.lang.Object r8 = r7.next()
            r12 = r8
            com.didi.soda.customer.widget.tabbar.TabBarItemModel r12 = (com.didi.soda.customer.widget.tabbar.TabBarItemModel) r12
            com.didi.soda.customer.widget.tabbar.TabBarItem r12 = r12.getTabBarItem()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r4)
            if (r12 == 0) goto L_0x006a
            r5 = r8
        L_0x0082:
            com.didi.soda.customer.widget.tabbar.TabBarItemModel r5 = (com.didi.soda.customer.widget.tabbar.TabBarItemModel) r5
            if (r5 == 0) goto L_0x008f
            r1.remove(r5)
            java.util.List<com.didi.soda.customer.widget.tabbar.TabBarItemModel> r3 = r13.f44750a
            r3.add(r5)
            goto L_0x00ed
        L_0x008f:
            com.didi.soda.customer.foundation.log.util.LogUtil.m32588i((java.lang.String) r11, (java.lang.String) r10)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r9)
            r5 = r0
            java.util.List r5 = (java.util.List) r5
            r13.m33204a((com.didi.soda.customer.widget.tabbar.TabBarItem) r4, (int) r3, (java.util.List<com.didi.soda.customer.widget.tabbar.TabBarItem>) r5)
            goto L_0x00ed
        L_0x009c:
            r7 = r1
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L_0x00a3:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x00bb
            java.lang.Object r8 = r7.next()
            r12 = r8
            com.didi.soda.customer.widget.tabbar.TabBarItemModel r12 = (com.didi.soda.customer.widget.tabbar.TabBarItemModel) r12
            com.didi.soda.customer.widget.tabbar.TabBarItem r12 = r12.getTabBarItem()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r4)
            if (r12 == 0) goto L_0x00a3
            r5 = r8
        L_0x00bb:
            com.didi.soda.customer.widget.tabbar.TabBarItemModel r5 = (com.didi.soda.customer.widget.tabbar.TabBarItemModel) r5
            if (r5 == 0) goto L_0x00cf
            r1.remove(r5)
            com.didi.soda.customer.widget.tabbar.TabBarOp r3 = r4.getOp()
            r5.updateSelf(r3)
            java.util.List<com.didi.soda.customer.widget.tabbar.TabBarItemModel> r3 = r13.f44750a
            r3.add(r5)
            goto L_0x00ed
        L_0x00cf:
            com.didi.soda.customer.foundation.log.util.LogUtil.m32588i((java.lang.String) r11, (java.lang.String) r10)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r9)
            r5 = r0
            java.util.List r5 = (java.util.List) r5
            r13.m33204a((com.didi.soda.customer.widget.tabbar.TabBarItem) r4, (int) r3, (java.util.List<com.didi.soda.customer.widget.tabbar.TabBarItem>) r5)
            goto L_0x00ed
        L_0x00dc:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r9)
            com.didi.soda.customer.widget.tabbar.TabBarItemModel r5 = r13.m33211b((com.didi.soda.customer.widget.tabbar.TabBarItem) r4)
            if (r5 == 0) goto L_0x00ed
            r13.m33207a((com.didi.soda.customer.widget.tabbar.TabBarItemModel) r5, (int) r3)
            java.util.List<com.didi.soda.customer.widget.tabbar.TabBarItemModel> r3 = r13.f44750a
            r3.add(r5)
        L_0x00ed:
            com.didi.soda.customer.widget.tabbar.TabBarOp r3 = com.didi.soda.customer.widget.tabbar.TabBarOp.NONE
            r4.setOp(r3)
            r3 = r6
            goto L_0x002d
        L_0x00f5:
            int r0 = r1.size()
            if (r0 <= 0) goto L_0x0120
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r0 = r1.iterator()
        L_0x0101:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0120
            java.lang.Object r1 = r0.next()
            com.didi.soda.customer.widget.tabbar.TabBarItemModel r1 = (com.didi.soda.customer.widget.tabbar.TabBarItemModel) r1
            com.didi.soda.customer.widget.tabbar.TabBarItemModel r2 = r13.f44752c
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r1)
            if (r2 == 0) goto L_0x0117
            r13.f44752c = r5
        L_0x0117:
            java.lang.String r2 = "model"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r13.m33206a((com.didi.soda.customer.widget.tabbar.TabBarItemModel) r1)
            goto L_0x0101
        L_0x0120:
            r13.m33199a()
            r13.m33213b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.widget.tabbar.TabBarController.apply():void");
    }

    /* renamed from: b */
    private final TabBarItemModel m33211b(TabBarItem tabBarItem) {
        ComponentController controller;
        PageCallback pageCallback = null;
        if (m33210a(tabBarItem) || (controller = tabBarItem.getController()) == null) {
            return null;
        }
        Context context = this.f44757h;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        TabBarItemView b = m33212b(context);
        TabBarItemModel tabBarItemModel = new TabBarItemModel(tabBarItem, b, (View) null, false, 12, (DefaultConstructorMarker) null);
        m33209a(b, tabBarItemModel);
        PageCallback pageCallback2 = this.f44756g;
        if (pageCallback2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageCallback");
        } else {
            pageCallback = pageCallback2;
        }
        controller.attach(pageCallback, tabBarItem.getParams());
        boolean z = !tabBarItem.isLazyLoad();
        if (z) {
            tabBarItemModel.setTabContainer(m33198a(controller));
            tabBarItemModel.setControllerInit(true);
        } else {
            tabBarItemModel.setControllerInit(false);
        }
        if (z) {
            m33214b(controller);
            this.f44759j.dispatchPageEventWhenAdd(controller);
        }
        return tabBarItemModel;
    }

    public final int findTabIndex(Function1<? super TabBarItem, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int i = 0;
        for (TabBarItemModel tabBarItem : this.f44750a) {
            if (function1.invoke(tabBarItem.getTabBarItem()).booleanValue()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static /* synthetic */ void selectTab$default(TabBarController tabBarController, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        tabBarController.selectTab(i, z);
    }

    public final void selectTab(int i, boolean z) {
        if (i >= 0 && i < this.f44750a.size()) {
            TabBarItemModel tabBarItemModel = this.f44750a.get(i);
            m33215b(tabBarItemModel);
            m33208a(tabBarItemModel, z);
        }
    }

    /* renamed from: a */
    private final void m33209a(TabBarItemView tabBarItemView, TabBarItemModel tabBarItemModel) {
        tabBarItemView.updateTabBarItem(tabBarItemModel);
        tabBarItemView.setOnClickListener(new View.OnClickListener(tabBarItemModel) {
            public final /* synthetic */ TabBarItemModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                TabBarController.m33202a(TabBarController.this, this.f$1, view);
            }
        });
        if (tabBarItemModel.getTabBarItem().isCanDoubleClick()) {
            tabBarItemView.setOnDoubleClickListener(new TabBarController$setupTabItemView$2(this, tabBarItemModel));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m33202a(TabBarController tabBarController, TabBarItemModel tabBarItemModel, View view) {
        Intrinsics.checkNotNullParameter(tabBarController, "this$0");
        Intrinsics.checkNotNullParameter(tabBarItemModel, "$model");
        tabBarController.m33215b(tabBarItemModel);
        tabBarController.m33208a(tabBarItemModel, true);
    }

    /* renamed from: a */
    private final ViewGroup m33198a(ComponentController componentController) {
        Context context = this.f44757h;
        Context context2 = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        ViewGroup a = m33197a(context);
        Context context3 = this.f44757h;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        } else {
            context2 = context3;
        }
        View tabView = componentController.getTabView(context2);
        componentController.setupComponents(tabView);
        a.addView(tabView);
        a.setVisibility(8);
        return a;
    }

    /* renamed from: b */
    private final void m33214b(ComponentController componentController) {
        for (ComponentInfo componentInfo : componentController.getComponentList()) {
            if (!componentInfo.isAdded()) {
                TabComponentCallback tabComponentCallback = this.f44760k;
                if (tabComponentCallback != null) {
                    tabComponentCallback.addComponent(componentInfo.getComponent());
                }
                componentInfo.setAdded(true);
            }
        }
    }

    /* renamed from: c */
    private final void m33216c(ComponentController componentController) {
        for (ComponentInfo componentInfo : componentController.getComponentList()) {
            if (componentInfo.isAdded()) {
                TabComponentCallback tabComponentCallback = this.f44760k;
                if (tabComponentCallback != null) {
                    tabComponentCallback.removeComponent(componentInfo.getComponent());
                }
                componentInfo.setAdded(false);
            }
        }
    }

    /* renamed from: a */
    private final ViewGroup m33197a(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    /* renamed from: b */
    private final TabBarItemView m33212b(Context context) {
        TabBarItemView tabBarItemView = new TabBarItemView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tabBarItemView.setLayoutParams(layoutParams);
        return tabBarItemView;
    }

    /* renamed from: a */
    static /* synthetic */ void m33203a(TabBarController tabBarController, TabBarItemModel tabBarItemModel, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        tabBarController.m33208a(tabBarItemModel, z);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m33208a(TabBarItemModel tabBarItemModel, boolean z) {
        TabBarItem tabBarItem;
        TabBarItemModel tabBarItemModel2 = this.f44752c;
        if (tabBarItemModel2 != null) {
            tabBarItemModel2.setIsSelected(false, z, Intrinsics.areEqual((Object) tabBarItemModel2, (Object) tabBarItemModel));
            ComponentController controller = tabBarItemModel2.getTabBarItem().getController();
            if (controller != null) {
                controller.onTabVisibleChanged(false, z);
            }
        }
        this.f44752c = tabBarItemModel;
        tabBarItemModel.setIsSelected(true, z, Intrinsics.areEqual((Object) tabBarItemModel2, (Object) tabBarItemModel));
        ComponentController controller2 = tabBarItemModel.getTabBarItem().getController();
        if (controller2 != null) {
            controller2.onTabVisibleChanged(true, z);
        }
        if (tabBarItemModel2 == null) {
            tabBarItem = null;
        } else {
            tabBarItem = tabBarItemModel2.getTabBarItem();
        }
        m33205a(tabBarItem, tabBarItemModel.getTabBarItem(), z);
    }

    /* renamed from: a */
    static /* synthetic */ void m33200a(TabBarController tabBarController, TabBarItem tabBarItem, TabBarItem tabBarItem2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        tabBarController.m33205a(tabBarItem, tabBarItem2, z);
    }

    /* renamed from: a */
    private final void m33205a(TabBarItem tabBarItem, TabBarItem tabBarItem2, boolean z) {
        OnTabChangedListener onTabChangedListener = this.f44758i;
        if (onTabChangedListener != null) {
            onTabChangedListener.onTanChangedEvent(this, tabBarItem, tabBarItem2, z);
        }
    }

    @Metadata(mo148867d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ+\u0010\n\u001a\u00020\u00062!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00060\fH\u0002J\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u0006J\u0010\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0014\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0006J\u0006\u0010\u0017\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo148868d2 = {"Lcom/didi/soda/customer/widget/tabbar/TabBarController$Event;", "", "(Lcom/didi/soda/customer/widget/tabbar/TabBarController;)V", "pageEvent", "Lcom/didi/app/nova/skeleton/IScopeLifecycle$PageStatus;", "dispatchPageEventWhenAdd", "", "controller", "Lcom/didi/soda/customer/widget/tabbar/ComponentController;", "dispatchPageEventWhenRemove", "dispatchToItems", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onCreate", "onDestroy", "onPageResult", "data", "Landroid/os/Bundle;", "onPause", "onResume", "onStart", "onStop", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: TabBarController.kt */
    public final class Event {
        private IScopeLifecycle.PageStatus pageEvent;
        final /* synthetic */ TabBarController this$0;

        @Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
        /* compiled from: TabBarController.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[IScopeLifecycle.PageStatus.values().length];
                iArr[IScopeLifecycle.PageStatus.Create.ordinal()] = 1;
                iArr[IScopeLifecycle.PageStatus.Start.ordinal()] = 2;
                iArr[IScopeLifecycle.PageStatus.Resume.ordinal()] = 3;
                iArr[IScopeLifecycle.PageStatus.Pause.ordinal()] = 4;
                iArr[IScopeLifecycle.PageStatus.Stop.ordinal()] = 5;
                iArr[IScopeLifecycle.PageStatus.Destroy.ordinal()] = 6;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public Event(TabBarController tabBarController) {
            Intrinsics.checkNotNullParameter(tabBarController, "this$0");
            this.this$0 = tabBarController;
        }

        public final void onCreate() {
            this.pageEvent = IScopeLifecycle.PageStatus.Create;
            dispatchToItems(TabBarController$Event$onCreate$1.INSTANCE);
        }

        public final void onStart() {
            this.pageEvent = IScopeLifecycle.PageStatus.Start;
            dispatchToItems(TabBarController$Event$onStart$1.INSTANCE);
        }

        public final void onResume() {
            this.pageEvent = IScopeLifecycle.PageStatus.Resume;
            dispatchToItems(TabBarController$Event$onResume$1.INSTANCE);
        }

        public final void onStop() {
            this.pageEvent = IScopeLifecycle.PageStatus.Stop;
            dispatchToItems(TabBarController$Event$onStop$1.INSTANCE);
        }

        public final void onPause() {
            this.pageEvent = IScopeLifecycle.PageStatus.Pause;
            dispatchToItems(TabBarController$Event$onPause$1.INSTANCE);
        }

        public final void onDestroy() {
            this.pageEvent = IScopeLifecycle.PageStatus.Destroy;
            dispatchToItems(TabBarController$Event$onDestroy$1.INSTANCE);
        }

        public final void onPageResult(Bundle bundle) {
            dispatchToItems(new TabBarController$Event$onPageResult$1(bundle));
        }

        public final void dispatchPageEventWhenAdd(ComponentController componentController) {
            IScopeLifecycle.PageStatus pageStatus;
            int i;
            if (componentController != null && (pageStatus = this.pageEvent) != null) {
                if (pageStatus == null) {
                    i = -1;
                } else {
                    i = WhenMappings.$EnumSwitchMapping$0[pageStatus.ordinal()];
                }
                if (i == 1) {
                    componentController.onCreate();
                } else if (i == 2) {
                    componentController.onCreate();
                    componentController.onStart();
                } else if (i == 3) {
                    componentController.onCreate();
                    componentController.onStart();
                    componentController.onResume();
                } else if (i == 4) {
                    componentController.onCreate();
                    componentController.onStart();
                } else if (i == 5) {
                    componentController.onCreate();
                }
            }
        }

        public final void dispatchPageEventWhenRemove(ComponentController componentController) {
            IScopeLifecycle.PageStatus pageStatus;
            int i;
            if (componentController != null && (pageStatus = this.pageEvent) != null) {
                if (pageStatus == null) {
                    i = -1;
                } else {
                    i = WhenMappings.$EnumSwitchMapping$0[pageStatus.ordinal()];
                }
                if (i == 1) {
                    componentController.onDestroy();
                } else if (i == 2) {
                    componentController.onStop();
                    componentController.onDestroy();
                } else if (i == 3) {
                    componentController.onPause();
                    componentController.onStop();
                    componentController.onDestroy();
                } else if (i == 4) {
                    componentController.onStop();
                    componentController.onDestroy();
                } else if (i == 5) {
                    componentController.onDestroy();
                }
            }
        }

        private final void dispatchToItems(Function1<? super ComponentController, Unit> function1) {
            ComponentController controller;
            for (TabBarItemModel tabBarItemModel : this.this$0.f44750a) {
                if (tabBarItemModel.isControllerInit() && (controller = tabBarItemModel.getTabBarItem().getController()) != null) {
                    function1.invoke(controller);
                }
            }
        }
    }
}
