package com.didi.soda.home.page;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.soda.customer.base.pages.FloatingCustomerPage;
import com.didi.soda.home.topgun.component.filter.FilterDataManager;
import com.didi.soda.home.topgun.component.filter.panel.FilterCategoryPanel;
import com.didi.soda.home.topgun.component.filter.panel.FilterMultiplePanel;
import com.didi.soda.home.topgun.component.filter.panel.FilterPanel;
import com.didi.soda.home.topgun.model.FilterModel;
import com.didi.soda.router.annotations.Route;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\bH\u0002J\b\u0010\u001a\u001a\u00020\u0015H\u0014J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001c\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0015H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, mo148868d2 = {"Lcom/didi/soda/home/page/FilterPage;", "Lcom/didi/soda/customer/base/pages/FloatingCustomerPage;", "()V", "currentPanel", "Lcom/didi/soda/home/topgun/component/filter/panel/FilterPanel;", "filterDataManager", "Lcom/didi/soda/home/topgun/component/filter/FilterDataManager;", "mFromScene", "", "mTimePeriod", "", "mTopicFromScence", "rootView", "Landroid/widget/FrameLayout;", "getRootView", "()Landroid/widget/FrameLayout;", "setRootView", "(Landroid/widget/FrameLayout;)V", "withConfirm", "", "confirm", "", "isReset", "findFilterModelById", "Lcom/didi/soda/home/topgun/model/FilterModel;", "id", "initContentView", "initFilterPanel", "filterModel", "onCreate", "view", "Landroid/view/View;", "onDestroy", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@Route({"filterPage"})
/* compiled from: FilterPage.kt */
public final class FilterPage extends FloatingCustomerPage {

    /* renamed from: a */
    private FilterPanel f45181a;

    /* renamed from: b */
    private FilterDataManager f45182b;

    /* renamed from: c */
    private int f45183c = 1;

    /* renamed from: d */
    private int f45184d = -1;

    /* renamed from: e */
    private String f45185e;

    /* renamed from: f */
    private boolean f45186f;
    public FrameLayout rootView;

    public final FrameLayout getRootView() {
        FrameLayout frameLayout = this.rootView;
        if (frameLayout != null) {
            return frameLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    }

    public final void setRootView(FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
        this.rootView = frameLayout;
    }

    /* renamed from: a */
    private final void m33533a(boolean z) {
        this.f45186f = true;
        Bundle bundle = new Bundle();
        bundle.putBoolean(FilterPageKt.KEY_FILTER_CONFIRM, true);
        bundle.putBoolean(FilterPageKt.KEY_FILTER_IS_RESET, z);
        dismiss(bundle);
    }

    /* access modifiers changed from: protected */
    public void initContentView() {
        setRootView(new FrameLayout(getBaseContext()));
        getRootView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001e, code lost:
        r0 = r0.getBundle();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.view.View r4) {
        /*
            r3 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            super.onCreate(r4)
            android.widget.FrameLayout r4 = r3.getRootView()
            android.view.View r4 = (android.view.View) r4
            r3.setContentView((android.view.View) r4)
            r4 = 1
            r3.setDismissible(r4)
            com.didi.app.nova.skeleton.ScopeContext r0 = r3.getScopeContext()
            r1 = -1
            if (r0 != 0) goto L_0x001e
        L_0x001c:
            r0 = -1
            goto L_0x002b
        L_0x001e:
            android.os.Bundle r0 = r0.getBundle()
            if (r0 != 0) goto L_0x0025
            goto L_0x001c
        L_0x0025:
            java.lang.String r2 = "model_id"
            int r0 = r0.getInt(r2)
        L_0x002b:
            com.didi.app.nova.skeleton.ScopeContext r2 = r3.getScopeContext()
            if (r2 != 0) goto L_0x0032
            goto L_0x003f
        L_0x0032:
            android.os.Bundle r2 = r2.getBundle()
            if (r2 != 0) goto L_0x0039
            goto L_0x003f
        L_0x0039:
            java.lang.String r4 = "from_scene"
            int r4 = r2.getInt(r4)
        L_0x003f:
            r3.f45183c = r4
            com.didi.app.nova.skeleton.ScopeContext r4 = r3.getScopeContext()
            if (r4 != 0) goto L_0x0048
            goto L_0x0055
        L_0x0048:
            android.os.Bundle r4 = r4.getBundle()
            if (r4 != 0) goto L_0x004f
            goto L_0x0055
        L_0x004f:
            java.lang.String r1 = "topic_from_scence"
            int r1 = r4.getInt(r1)
        L_0x0055:
            r3.f45184d = r1
            com.didi.app.nova.skeleton.ScopeContext r4 = r3.getScopeContext()
            java.lang.String r1 = ""
            if (r4 != 0) goto L_0x0060
            goto L_0x0071
        L_0x0060:
            android.os.Bundle r4 = r4.getBundle()
            if (r4 != 0) goto L_0x0067
            goto L_0x0071
        L_0x0067:
            java.lang.String r2 = "time_period"
            java.lang.String r4 = r4.getString(r2)
            if (r4 != 0) goto L_0x0070
            goto L_0x0071
        L_0x0070:
            r1 = r4
        L_0x0071:
            r3.f45185e = r1
            com.didi.soda.home.topgun.component.filter.FilterDataManager$Companion r4 = com.didi.soda.home.topgun.component.filter.FilterDataManager.Companion
            int r1 = r3.f45183c
            com.didi.soda.home.topgun.component.filter.FilterDataManager r4 = r4.getInstanceByScene(r1)
            r3.f45182b = r4
            com.didi.soda.home.topgun.model.FilterModel r4 = r3.m33531a((int) r0)
            if (r4 == 0) goto L_0x00a9
            com.didi.rfusion.widget.floating.RFFloatingNavBar r0 = r3.getNavBar()
            com.didi.rfusion.widget.floating.RFFloatingTextAttr$Builder r1 = new com.didi.rfusion.widget.floating.RFFloatingTextAttr$Builder
            java.lang.String r2 = r4.mPageTitle
            r1.<init>(r2)
            com.didi.rfusion.widget.floating.RFFloatingTextAttr r1 = r1.build()
            r0.setTitle(r1)
            com.didi.rfusion.widget.floating.RFFloatingNavBar r0 = r3.getNavBar()
            r1 = 2131101568(0x7f060780, float:1.781555E38)
            int r1 = com.didi.soda.customer.foundation.util.ResourceHelper.getColor(r1)
            r0.setBackground(r1)
            com.didi.soda.home.topgun.component.filter.panel.FilterPanel r4 = r3.m33530a((com.didi.soda.home.topgun.model.FilterModel) r4)
            r3.f45181a = r4
        L_0x00a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.page.FilterPage.onCreate(android.view.View):void");
    }

    /* renamed from: a */
    private final FilterModel m33531a(int i) {
        FilterDataManager filterDataManager = this.f45182b;
        if (filterDataManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterDataManager");
            filterDataManager = null;
        }
        return filterDataManager.getFilterGroupDataById(i);
    }

    /* renamed from: a */
    private final FilterPanel m33530a(FilterModel filterModel) {
        FilterPanel filterPanel;
        if (filterModel.mShowType == 2) {
            filterPanel = new FilterCategoryPanel(getBaseContext());
        } else {
            filterPanel = new FilterMultiplePanel(getBaseContext());
            filterPanel.mTopicFromScence = this.f45184d;
            filterPanel.mTimePeriod = this.f45185e;
        }
        filterPanel.attach(getRootView(), filterModel, this.f45183c);
        filterPanel.setOnFilterPanelEvent(new FilterPanel.OnFilterPanelEvent() {
            public final void onConfirm(FilterPanel filterPanel, boolean z, boolean z2) {
                FilterPage.m33532a(FilterPage.this, filterPanel, z, z2);
            }
        });
        return filterPanel;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m33532a(FilterPage filterPage, FilterPanel filterPanel, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(filterPage, "this$0");
        FilterDataManager filterDataManager = filterPage.f45182b;
        if (filterDataManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterDataManager");
            filterDataManager = null;
        }
        filterDataManager.saveFilterGroupChange(filterPanel.getFilterModel());
        filterPage.m33533a(z2);
    }

    public void onDestroy() {
        super.onDestroy();
        FilterPanel filterPanel = this.f45181a;
        if (filterPanel != null) {
            filterPanel.detach(getRootView());
        }
    }
}
