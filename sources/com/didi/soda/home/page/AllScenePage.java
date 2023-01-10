package com.didi.soda.home.page;

import android.os.Bundle;
import com.didi.soda.customer.base.pages.grid.GridItemModel;
import com.didi.soda.customer.base.pages.grid.GridPage;
import com.didi.soda.customer.foundation.util.OnceActionUtil;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.router.annotations.Route;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J,\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rH\u0016J\u0018\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo148868d2 = {"Lcom/didi/soda/home/page/AllScenePage;", "Lcom/didi/soda/customer/base/pages/grid/GridPage;", "()V", "absolutePositionInRv", "", "actionPool", "Lcom/didi/soda/customer/foundation/util/OnceActionUtil$ActionPool;", "mFeedRecId", "positionInFeed", "dismissConfirm", "", "url", "type", "", "title", "recId", "initGridData", "Lcom/didi/soda/customer/base/pages/grid/GridPageData;", "onCreate", "view", "Landroid/view/View;", "onDestroy", "onGridItemBindEvent", "model", "Lcom/didi/soda/customer/base/pages/grid/GridItemModel;", "position", "onGridItemClickEvent", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@Route({"allScenePage"})
/* compiled from: AllScenePage.kt */
public final class AllScenePage extends GridPage {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_DISMISS_WITH_CONFIRM = "key_dismiss_confirm_from_scene";
    public static final String KEY_TARGET_RECID = "key_target_recid_from_scene";
    public static final String KEY_TARGET_TITLE = "key_target_title_from_scene";
    public static final String KEY_TARGET_TYPE = "key_target_type_from_scene";
    public static final String KEY_TARGET_URL = "key_target_url_from_scene";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f45174a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f45175b;

    /* renamed from: c */
    private String f45176c = "";

    /* renamed from: d */
    private OnceActionUtil.ActionPool f45177d = new OnceActionUtil.ActionPool();

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r0 = r0.getBundle();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.soda.customer.base.pages.grid.GridPageData initGridData() {
        /*
            r6 = this;
            com.didi.app.nova.skeleton.ScopeContext r0 = r6.getScopeContext()
            r1 = 0
            if (r0 != 0) goto L_0x0009
        L_0x0007:
            r0 = r1
            goto L_0x0016
        L_0x0009:
            android.os.Bundle r0 = r0.getBundle()
            if (r0 != 0) goto L_0x0010
            goto L_0x0007
        L_0x0010:
            java.lang.String r2 = "subitems"
            java.lang.String r0 = r0.getString(r2)
        L_0x0016:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0026
            int r5 = r2.length()
            if (r5 != 0) goto L_0x0024
            goto L_0x0026
        L_0x0024:
            r5 = 0
            goto L_0x0027
        L_0x0026:
            r5 = 1
        L_0x0027:
            if (r5 != 0) goto L_0x0033
            java.lang.String r5 = "null"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)
            r2 = r2 ^ r4
            if (r2 == 0) goto L_0x0033
            r3 = 1
        L_0x0033:
            if (r3 == 0) goto L_0x007d
            java.lang.String r0 = android.net.Uri.decode(r0)
            java.lang.Class<com.didi.soda.customer.foundation.rpc.entity.grid.GridEntity> r1 = com.didi.soda.customer.foundation.rpc.entity.grid.GridEntity.class
            java.lang.Object r0 = com.didi.soda.customer.foundation.util.GsonUtil.fromJson((java.lang.String) r0, r1)
            com.didi.soda.customer.foundation.rpc.entity.grid.GridEntity r0 = (com.didi.soda.customer.foundation.rpc.entity.grid.GridEntity) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r1 = (java.util.List) r1
            if (r0 != 0) goto L_0x004b
            goto L_0x006e
        L_0x004b:
            java.util.List r2 = r0.getItems()
            if (r2 != 0) goto L_0x0052
            goto L_0x006e
        L_0x0052:
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x0058:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x006e
            java.lang.Object r3 = r2.next()
            com.didi.soda.customer.foundation.rpc.entity.grid.GridItemEntity r3 = (com.didi.soda.customer.foundation.rpc.entity.grid.GridItemEntity) r3
            com.didi.soda.customer.base.pages.grid.GridItemModel$Companion r4 = com.didi.soda.customer.base.pages.grid.GridItemModel.Companion
            com.didi.soda.customer.base.pages.grid.GridItemModel r3 = r4.create(r3)
            r1.add(r3)
            goto L_0x0058
        L_0x006e:
            com.didi.soda.customer.base.pages.grid.GridPageData r2 = new com.didi.soda.customer.base.pages.grid.GridPageData
            java.lang.String r0 = r0.getTitle()
            if (r0 == 0) goto L_0x0077
            goto L_0x0079
        L_0x0077:
            java.lang.String r0 = ""
        L_0x0079:
            r2.<init>(r0, r1)
            return r2
        L_0x007d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.page.AllScenePage.initGridData():com.didi.soda.customer.base.pages.grid.GridPageData");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0013, code lost:
        r4 = r4.getBundle();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.view.View r4) {
        /*
            r3 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            super.onCreate(r4)
            com.didi.app.nova.skeleton.ScopeContext r4 = r3.getScopeContext()
            java.lang.String r0 = "-1"
            r1 = 0
            if (r4 != 0) goto L_0x0013
        L_0x0011:
            r4 = r1
            goto L_0x0020
        L_0x0013:
            android.os.Bundle r4 = r4.getBundle()
            if (r4 != 0) goto L_0x001a
            goto L_0x0011
        L_0x001a:
            java.lang.String r2 = "position"
            java.lang.String r4 = r4.getString(r2, r0)
        L_0x0020:
            r3.f45174a = r4
            com.didi.app.nova.skeleton.ScopeContext r4 = r3.getScopeContext()
            if (r4 != 0) goto L_0x002a
        L_0x0028:
            r4 = r1
            goto L_0x0037
        L_0x002a:
            android.os.Bundle r4 = r4.getBundle()
            if (r4 != 0) goto L_0x0031
            goto L_0x0028
        L_0x0031:
            java.lang.String r2 = "absoluteposition"
            java.lang.String r4 = r4.getString(r2, r0)
        L_0x0037:
            r3.f45175b = r4
            com.didi.app.nova.skeleton.ScopeContext r4 = r3.getScopeContext()
            if (r4 != 0) goto L_0x0040
            goto L_0x004d
        L_0x0040:
            android.os.Bundle r4 = r4.getBundle()
            if (r4 != 0) goto L_0x0047
            goto L_0x004d
        L_0x0047:
            java.lang.String r1 = "recid"
            java.lang.String r1 = r4.getString(r1, r0)
        L_0x004d:
            r3.f45176c = r1
            r4 = 1
            r3.setDismissible(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.page.AllScenePage.onCreate(android.view.View):void");
    }

    public void onGridItemClickEvent(GridItemModel gridItemModel, int i) {
        Intrinsics.checkNotNullParameter(gridItemModel, "model");
        HomeOmegaHelper.getInstance().trackSceneComponentCk(this.f45174a, this.f45175b, gridItemModel, i, 1);
        String url = gridItemModel.getUrl();
        int type = gridItemModel.getType();
        String title = gridItemModel.getTitle();
        String str = this.f45176c;
        if (str == null) {
            str = "";
        }
        m33529a(url, type, title, str);
    }

    public void onGridItemBindEvent(GridItemModel gridItemModel, int i) {
        Intrinsics.checkNotNullParameter(gridItemModel, "model");
        AllScenePage$onGridItemBindEvent$action$1 allScenePage$onGridItemBindEvent$action$1 = new AllScenePage$onGridItemBindEvent$action$1(this, gridItemModel, i, new Object[]{Integer.valueOf(i)});
        this.f45177d.doAction(allScenePage$onGridItemBindEvent$action$1);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f45177d.reset();
    }

    /* renamed from: a */
    private final void m33529a(String str, int i, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(KEY_DISMISS_WITH_CONFIRM, true);
        if (str == null) {
            str = "";
        }
        bundle.putString(KEY_TARGET_URL, str);
        bundle.putInt(KEY_TARGET_TYPE, i);
        if (str2 == null) {
            str2 = "";
        }
        bundle.putString(KEY_TARGET_TITLE, str2);
        bundle.putString(KEY_TARGET_RECID, str3);
        dismiss(bundle);
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo148868d2 = {"Lcom/didi/soda/home/page/AllScenePage$Companion;", "", "()V", "KEY_DISMISS_WITH_CONFIRM", "", "KEY_TARGET_RECID", "KEY_TARGET_TITLE", "KEY_TARGET_TYPE", "KEY_TARGET_URL", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: AllScenePage.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
