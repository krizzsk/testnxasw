package com.didi.soda.customer.coordshop;

import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.soda.customer.coordshop.finder.FinderVisibleDish;
import com.didi.soda.customer.coordshop.visitor.BlockShopItemVisitor;
import com.didi.soda.customer.coordshop.visitor.NativeShopItemVisitor;
import com.didi.soda.customer.coordshop.visitor.VisibleDishVisitor;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.datasource.page.dynamic.DynamicRecyclePresenter;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002JD\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\"\b\u0002\u0010\r\u001a\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\bJ\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, mo148868d2 = {"Lcom/didi/soda/customer/coordshop/CoordShopManager;", "", "()V", "coordHost", "Lcom/didi/soda/customer/coordshop/CoordHost;", "requestCoordShop", "Lcom/didi/soda/customer/coordshop/RequestCoordShop;", "shopSaver", "Lcom/didi/soda/customer/coordshop/ShopSaver;", "attachToHost", "", "present", "Lcom/didi/soda/customer/base/recycler/CustomerRecyclerPresenter;", "addCoordShopCard", "Lkotlin/Function2;", "", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "Lcom/didi/soda/customer/coordshop/AddCoordShopCard;", "recycleView", "Landroidx/recyclerview/widget/RecyclerView;", "detachFromHost", "findCoordShopPredicate", "recyclerView", "getSaver", "triggerEnterBusinessEvent", "page", "Lcom/didi/soda/customer/base/pages/CustomerPage;", "triggerTopicSw", "shop", "Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "updateFilterStatus", "isOriginalFilter", "", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CoordShopManager.kt */
public final class CoordShopManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static CoordShopManager f43428d;

    /* renamed from: a */
    private final ShopSaver f43429a;

    /* renamed from: b */
    private final RequestCoordShop f43430b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CoordHost f43431c;

    public CoordShopManager() {
        ShopSaver shopSaver = new ShopSaver();
        shopSaver.addAddVisitor(new BlockShopItemVisitor());
        shopSaver.addAddVisitor(new NativeShopItemVisitor());
        shopSaver.addAddVisitor(new VisibleDishVisitor());
        Unit unit = Unit.INSTANCE;
        this.f43429a = shopSaver;
        this.f43430b = new RequestCoordShop(shopSaver);
    }

    public final ShopSaver getSaver() {
        return this.f43429a;
    }

    public final void updateFilterStatus(boolean z) {
        this.f43429a.setOriginalFilter(z);
    }

    public final void triggerEnterBusinessEvent(CustomerPage customerPage) {
        Intrinsics.checkNotNullParameter(customerPage, "page");
        if (!this.f43429a.checkAlreadyShowTimes() || !this.f43429a.isOriginalFilter()) {
            LogUtil.m32588i("Coord", "fail trigger coord when enter shop!!，" + this.f43429a.getPrintMsg() + " p2=" + this.f43429a.isOriginalFilter());
            return;
        }
        this.f43430b.triggerEnterBusinessEvent(customerPage, new CoordShopManager$triggerEnterBusinessEvent$1(customerPage, this));
    }

    public static /* synthetic */ void attachToHost$default(CoordShopManager coordShopManager, CustomerRecyclerPresenter customerRecyclerPresenter, Function2 function2, RecyclerView recyclerView, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            recyclerView = null;
        }
        coordShopManager.attachToHost(customerRecyclerPresenter, function2, recyclerView);
    }

    public final void attachToHost(CustomerRecyclerPresenter<?> customerRecyclerPresenter, Function2<? super Integer, ? super RecyclerModel, Unit> function2, RecyclerView recyclerView) {
        IBlockScope scope = customerRecyclerPresenter instanceof DynamicRecyclePresenter ? ((DynamicRecyclePresenter) customerRecyclerPresenter).getScope() : null;
        CoordHost coordHost = this.f43431c;
        if (coordHost != null) {
            Intrinsics.checkNotNull(coordHost);
            coordHost.detach();
        }
        CoordHost create = CoordHost.Companion.create(this.f43429a, scope, function2, recyclerView);
        this.f43431c = create;
        if (create != null) {
            create.attached();
        }
    }

    public final void detachFromHost() {
        CoordHost coordHost = this.f43431c;
        if (coordHost != null) {
            coordHost.detach();
        }
        this.f43431c = null;
    }

    public final void triggerTopicSw(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "shop");
        getSaver().triggerTopicSw(homeBusinessInfoRvModel);
    }

    public final void findCoordShopPredicate(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (this.f43429a.checkAlreadyShowTimes()) {
            new FinderVisibleDish(this.f43429a).findInRecycleView(recyclerView);
        }
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo148868d2 = {"Lcom/didi/soda/customer/coordshop/CoordShopManager$Companion;", "", "()V", "instance", "Lcom/didi/soda/customer/coordshop/CoordShopManager;", "get", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: CoordShopManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CoordShopManager get() {
            if (CoordShopManager.f43428d == null) {
                CoordShopManager.f43428d = new CoordShopManager();
            }
            CoordShopManager access$getInstance$cp = CoordShopManager.f43428d;
            Intrinsics.checkNotNull(access$getInstance$cp);
            return access$getInstance$cp;
        }
    }
}
