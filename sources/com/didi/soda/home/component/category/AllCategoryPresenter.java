package com.didi.soda.home.component.category;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.rfusion.widget.floating.IRFFloatingExpand;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;
import com.didi.soda.customer.binder.abnormal.topgun.TopGunAbnormalRvModel;
import com.didi.soda.customer.foundation.rpc.entity.topgun.CategoryEntity;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalFactory;
import com.didi.soda.home.binder.model.AllCategoryItemModel;
import com.didi.soda.home.component.category.Contract;
import com.didi.soda.home.manager.RouterCloseRepo;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\rH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo148868d2 = {"Lcom/didi/soda/home/component/category/AllCategoryPresenter;", "Lcom/didi/soda/home/component/category/Contract$AbsAllCategoryPresenter;", "Lcom/didi/rfusion/widget/floating/IRFFloatingExpand;", "()V", "mCategoryListManager", "Lcom/didi/app/nova/support/view/recyclerview/data/ChildDataListManager;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "mColNum", "", "mComponentLogicUnit", "Lcom/didi/soda/customer/base/binder/ComponentLogicUnit;", "getColumnCount", "handleLogicRepo", "", "allCategoryItemItemModel", "Lcom/didi/soda/home/binder/model/AllCategoryItemModel;", "initDataManagers", "initParams", "onCreate", "provideComponentLogicUnit", "showAbnormalView", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: AllCategoryPresenter.kt */
public final class AllCategoryPresenter extends Contract.AbsAllCategoryPresenter implements IRFFloatingExpand {

    /* renamed from: a */
    private ComponentLogicUnit f45036a;

    /* renamed from: b */
    private ChildDataListManager<RecyclerModel> f45037b;

    /* renamed from: c */
    private int f45038c = 2;

    public /* synthetic */ void dismiss(ScopeContext scopeContext) {
        IRFFloatingExpand.CC.$default$dismiss(this, scopeContext);
    }

    public /* synthetic */ void dismiss(ScopeContext scopeContext, Bundle bundle) {
        IRFFloatingExpand.CC.$default$dismiss(this, scopeContext, bundle);
    }

    public /* synthetic */ Bundle getFloatingArgs(ScopeContext scopeContext) {
        return IRFFloatingExpand.CC.$default$getFloatingArgs(this, scopeContext);
    }

    public /* synthetic */ RFFloatingNavBar getNavBar(ScopeContext scopeContext) {
        return IRFFloatingExpand.CC.$default$getNavBar(this, scopeContext);
    }

    public /* synthetic */ void pushOuter(ScopeContext scopeContext, Page page) {
        IRFFloatingExpand.CC.$default$pushOuter(this, scopeContext, page);
    }

    public /* synthetic */ void pushOuter(ScopeContext scopeContext, Dialog dialog, String str) {
        IRFFloatingExpand.CC.$default$pushOuter(this, scopeContext, dialog, str);
    }

    public /* synthetic */ void pushPage(ScopeContext scopeContext, Page page) {
        IRFFloatingExpand.CC.$default$pushPage(this, scopeContext, page);
    }

    public /* synthetic */ void pushPage(ScopeContext scopeContext, Page page, int i) {
        IRFFloatingExpand.CC.$default$pushPage(this, scopeContext, page, i);
    }

    public /* synthetic */ void setGestureEnable(ScopeContext scopeContext, boolean z) {
        IRFFloatingExpand.CC.$default$setGestureEnable(this, scopeContext, z);
    }

    public int getColumnCount() {
        return this.f45038c;
    }

    public void onCreate() {
        super.onCreate();
        m33378a();
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [kotlin.Unit] */
    /* JADX WARNING: type inference failed for: r1v4, types: [kotlin.Unit] */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v12, types: [kotlin.Unit] */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r0 = r0.getBundle();
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m33378a() {
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
            java.lang.String r2 = "recid"
            java.lang.String r0 = r0.getString(r2)
        L_0x0016:
            com.didi.app.nova.skeleton.ScopeContext r2 = r6.getScopeContext()
            java.lang.String r3 = "allCategoryPageOpenSource"
            if (r2 != 0) goto L_0x0020
        L_0x001e:
            r2 = r1
            goto L_0x002b
        L_0x0020:
            android.os.Bundle r2 = r2.getBundle()
            if (r2 != 0) goto L_0x0027
            goto L_0x001e
        L_0x0027:
            java.lang.String r2 = r2.getString(r3)
        L_0x002b:
            r6.setFromPage(r2)
            java.lang.String r2 = r6.getFromPage()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0059
            com.didi.app.nova.skeleton.ScopeContext r2 = r6.getScopeContext()
            if (r2 != 0) goto L_0x0042
        L_0x0040:
            r2 = r1
            goto L_0x0056
        L_0x0042:
            android.os.Bundle r2 = r2.getBundle()
            if (r2 != 0) goto L_0x0049
            goto L_0x0040
        L_0x0049:
            java.lang.String r3 = r3.toLowerCase()
            java.lang.String r4 = "(this as java.lang.String).toLowerCase()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.lang.String r2 = r2.getString(r3)
        L_0x0056:
            r6.setFromPage(r2)
        L_0x0059:
            com.didi.app.nova.skeleton.ScopeContext r2 = r6.getScopeContext()
            if (r2 != 0) goto L_0x0061
            goto L_0x00e4
        L_0x0061:
            android.os.Bundle r2 = r2.getBundle()
            if (r2 != 0) goto L_0x0069
            goto L_0x00e4
        L_0x0069:
            java.lang.String r3 = "subitems"
            java.lang.String r2 = r2.getString(r3)
            if (r2 != 0) goto L_0x0073
            goto L_0x00e4
        L_0x0073:
            java.lang.Class<com.didi.soda.customer.foundation.rpc.entity.topgun.AllCategoryEntity> r3 = com.didi.soda.customer.foundation.rpc.entity.topgun.AllCategoryEntity.class
            java.lang.Object r2 = com.didi.soda.customer.foundation.util.GsonUtil.fromJson((java.lang.String) r2, r3)     // Catch:{ Exception -> 0x00da }
            com.didi.soda.customer.foundation.rpc.entity.topgun.AllCategoryEntity r2 = (com.didi.soda.customer.foundation.rpc.entity.topgun.AllCategoryEntity) r2     // Catch:{ Exception -> 0x00da }
            if (r2 != 0) goto L_0x007f
            goto L_0x00e4
        L_0x007f:
            int r3 = r2.getColNum()     // Catch:{ Exception -> 0x00da }
            if (r3 <= 0) goto L_0x008b
            int r3 = r2.getColNum()     // Catch:{ Exception -> 0x00da }
            r6.f45038c = r3     // Catch:{ Exception -> 0x00da }
        L_0x008b:
            java.util.List r2 = r2.getItems()     // Catch:{ Exception -> 0x00da }
            if (r2 != 0) goto L_0x0092
            goto L_0x00cf
        L_0x0092:
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3     // Catch:{ Exception -> 0x00da }
            boolean r3 = r3.isEmpty()     // Catch:{ Exception -> 0x00da }
            if (r3 == 0) goto L_0x00a1
            r6.m33380b()     // Catch:{ Exception -> 0x00da }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x00da }
            goto L_0x00ce
        L_0x00a1:
            com.didi.soda.home.binder.model.AllCategoryItemModel$Companion r3 = com.didi.soda.home.binder.model.AllCategoryItemModel.Companion     // Catch:{ Exception -> 0x00da }
            java.lang.String r4 = ""
            if (r0 != 0) goto L_0x00a9
            r5 = r4
            goto L_0x00aa
        L_0x00a9:
            r5 = r0
        L_0x00aa:
            java.util.List r2 = r3.convetModelList(r2, r5)     // Catch:{ Exception -> 0x00da }
            com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager<com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel> r3 = r6.f45037b     // Catch:{ Exception -> 0x00da }
            if (r3 != 0) goto L_0x00b8
            java.lang.String r3 = "mCategoryListManager"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)     // Catch:{ Exception -> 0x00da }
            goto L_0x00b9
        L_0x00b8:
            r1 = r3
        L_0x00b9:
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3     // Catch:{ Exception -> 0x00da }
            r1.addAll(r3)     // Catch:{ Exception -> 0x00da }
            com.didi.soda.home.topgun.manager.HomeOmegaHelper r1 = com.didi.soda.home.topgun.manager.HomeOmegaHelper.getInstance()     // Catch:{ Exception -> 0x00da }
            if (r0 != 0) goto L_0x00c6
            r0 = r4
        L_0x00c6:
            java.lang.String r3 = r6.getFromPage()     // Catch:{ Exception -> 0x00da }
            r1.trackFilterCategoryPanelSw(r2, r0, r3)     // Catch:{ Exception -> 0x00da }
            r0 = r2
        L_0x00ce:
            r1 = r0
        L_0x00cf:
            if (r1 != 0) goto L_0x00e4
            r0 = r6
            com.didi.soda.home.component.category.AllCategoryPresenter r0 = (com.didi.soda.home.component.category.AllCategoryPresenter) r0     // Catch:{ Exception -> 0x00da }
            r0.m33380b()     // Catch:{ Exception -> 0x00da }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x00da }
            goto L_0x00e4
        L_0x00da:
            r0 = move-exception
            r0.printStackTrace()
            r6.m33380b()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r1 = r0
        L_0x00e4:
            if (r1 != 0) goto L_0x00ec
            r0 = r6
            com.didi.soda.home.component.category.AllCategoryPresenter r0 = (com.didi.soda.home.component.category.AllCategoryPresenter) r0
            r0.m33380b()
        L_0x00ec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.component.category.AllCategoryPresenter.m33378a():void");
    }

    /* renamed from: b */
    private final void m33380b() {
        TopGunAbnormalRvModel topGunAbnormalRvModel = new TopGunAbnormalRvModel();
        topGunAbnormalRvModel.setAbnormalVm(TopGunAbnormalFactory.buildAllCategoryNoData());
        topGunAbnormalRvModel.mHeight = -1;
        ChildDataListManager<RecyclerModel> childDataListManager = this.f45037b;
        if (childDataListManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCategoryListManager");
            childDataListManager = null;
        }
        childDataListManager.add(topGunAbnormalRvModel);
    }

    public void initDataManagers() {
        super.initDataManagers();
        ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager();
        Intrinsics.checkNotNullExpressionValue(createChildDataListManager, "createChildDataListManager<RecyclerModel>()");
        this.f45037b = createChildDataListManager;
        if (createChildDataListManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCategoryListManager");
            createChildDataListManager = null;
        }
        addDataManager(createChildDataListManager);
    }

    public ComponentLogicUnit provideComponentLogicUnit() {
        super.provideComponentLogicUnit();
        if (this.f45036a == null) {
            this.f45036a = new AllCategoryPresenter$provideComponentLogicUnit$1(this);
        }
        ComponentLogicUnit componentLogicUnit = this.f45036a;
        if (componentLogicUnit != null) {
            return componentLogicUnit;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.customer.base.binder.ComponentLogicUnit");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m33379a(AllCategoryItemModel allCategoryItemModel) {
        if (allCategoryItemModel != null && allCategoryItemModel.getLogicType() == 100) {
            CategoryEntity category = allCategoryItemModel.getCategory();
            if (category != null) {
                RouterCloseRepo routerCloseRepo = (RouterCloseRepo) RepoFactory.getRepo(RouterCloseRepo.class);
                RouterCloseRepo.AllCateGoryPageCloseModel allCateGoryPageCloseModel = new RouterCloseRepo.AllCateGoryPageCloseModel();
                allCateGoryPageCloseModel.setFrom(getFromPage());
                if (TextUtils.isEmpty(allCateGoryPageCloseModel.getFrom())) {
                    allCateGoryPageCloseModel.setFrom("homePage");
                }
                allCateGoryPageCloseModel.setCateId(category.getCateId());
                allCateGoryPageCloseModel.setRecId(allCategoryItemModel.getRecId());
                allCateGoryPageCloseModel.setUrl(category.getUrl());
                Unit unit = Unit.INSTANCE;
                routerCloseRepo.setValue((RouterCloseRepo.CloseModel) allCateGoryPageCloseModel);
                HomeOmegaHelper.getInstance().trackFilterCategoryConfirm(category, allCategoryItemModel.getPosition(), allCategoryItemModel.getRecId(), getFromPage());
            }
            dismiss(getScopeContext());
        }
    }
}
