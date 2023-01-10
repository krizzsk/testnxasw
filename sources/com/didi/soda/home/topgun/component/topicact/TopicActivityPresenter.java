package com.didi.soda.home.topgun.component.topicact;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.rfusion.widget.dialog.RFCommonDialog;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.didi.soda.blocks.action.ActionResult;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.blocks.scope.BlockScopeBase;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.binder.abnormal.topgun.TopGunAbnormalRvModel;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.compose.action.ComposeActionHelper;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.Clock;
import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.ComposeActionEntity;
import com.didi.soda.customer.foundation.rpc.entity.TabInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.FilterEntity;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.widget.abnormal.ActivityAbnormalViewModel;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalFactory;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalViewModel;
import com.didi.soda.customer.widget.dialog.SodaWindowFactory;
import com.didi.soda.customer.widget.text.RichTextParser;
import com.didi.soda.datasource.listener.DataSourceListener;
import com.didi.soda.datasource.page.PageStore;
import com.didi.soda.home.manager.ActInvalidateRepo;
import com.didi.soda.home.page.FilterPageKt;
import com.didi.soda.home.topgun.binder.LandingLogicUnit;
import com.didi.soda.home.topgun.binder.model.FilterRvModel;
import com.didi.soda.home.topgun.binder.model.HomeNoResultRvModel;
import com.didi.soda.home.topgun.component.filter.FilterDataManager;
import com.didi.soda.home.topgun.component.filter.FilterHelper;
import com.didi.soda.home.topgun.component.topicact.Contract;
import com.didi.soda.home.topgun.component.topicact.data.ActivityDataSource;
import com.didi.soda.home.topgun.manager.HomeFeedParam;
import com.didi.soda.home.topgun.model.FilterModel;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.didi.soda.manager.base.ICustomerHomeManager;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo148867d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010.\u001a\u00020\u000fH\u0002J\u0010\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\u001cH\u0002J\b\u00101\u001a\u00020\u001aH\u0002J\u0018\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007H\u0002J\b\u00106\u001a\u00020\u0011H\u0002J\b\u00107\u001a\u00020)H\u0016J\u0010\u00108\u001a\u00020\f2\u0006\u00109\u001a\u00020\tH\u0002J\u0010\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020\f2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010>\u001a\u00020\fH\u0016J\b\u0010?\u001a\u00020\fH\u0002J\b\u0010@\u001a\u00020\u001cH\u0002J\b\u0010A\u001a\u00020\fH\u0002J\b\u0010B\u001a\u00020\u001cH\u0016J\u0018\u0010C\u001a\u00020\f2\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020\u001cJ\b\u0010G\u001a\u00020\fH\u0016J.\u0010H\u001a\u00020\f2\u0014\u0010I\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010J2\u000e\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010LH\u0016J\u0018\u0010M\u001a\u00020\f2\u000e\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010LH\u0016J\b\u0010O\u001a\u00020\fH\u0014J\b\u0010P\u001a\u00020\fH\u0016J\b\u0010Q\u001a\u00020\fH\u0016J\b\u0010R\u001a\u00020\u001cH\u0016J\b\u0010S\u001a\u00020\fH\u0016J\u0018\u0010T\u001a\u00020\f2\u0006\u0010U\u001a\u00020\u001a2\b\u00109\u001a\u0004\u0018\u00010\tJ\u0012\u0010V\u001a\u00020\f2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J4\u0010V\u001a\u00020\f2\u0006\u0010U\u001a\u00020\u001a2\b\u0010Y\u001a\u0004\u0018\u00010\u00072\b\u00109\u001a\u0004\u0018\u00010\t2\b\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010\\\u001a\u00020\u001cJ\b\u0010]\u001a\u00020\fH\u0014J\b\u0010^\u001a\u00020\fH\u0016J\b\u0010_\u001a\u00020\fH\u0014J\u0010\u0010`\u001a\u00020\f2\u0006\u0010a\u001a\u00020bH\u0016J\b\u0010c\u001a\u00020dH\u0016J\b\u0010e\u001a\u00020\fH\u0002J\u000e\u0010f\u001a\u00020\f2\u0006\u0010(\u001a\u00020)JH\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020j2\u0006\u0010(\u001a\u00020)2&\u0010k\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020m\u0018\u00010lj\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020m\u0018\u0001`n2\u0006\u0010o\u001a\u00020pH\u0002J\u0006\u0010q\u001a\u00020\fJ\b\u0010r\u001a\u00020\fH\u0002J\u0012\u0010s\u001a\u00020\f2\b\u0010t\u001a\u0004\u0018\u00010uH\u0002J\u0018\u0010v\u001a\u00020\f2\u0006\u0010U\u001a\u00020\u001a2\u0006\u0010Z\u001a\u00020[H\u0002J\b\u0010w\u001a\u00020\fH\u0002J\u0018\u0010x\u001a\u00020\f2\u0006\u0010U\u001a\u00020\u001a2\u0006\u00109\u001a\u00020\tH\u0002J\b\u0010y\u001a\u00020\fH\u0002J\b\u0010z\u001a\u00020\fH\u0002J\u0006\u0010{\u001a\u00020\fJ\u0010\u0010|\u001a\u00020\f2\u0006\u0010}\u001a\u00020~H\u0002J\b\u0010\u001a\u00020\fH\u0002JI\u0010\u0001\u001a\u00020h2\u0006\u0010i\u001a\u00020j2\u0006\u0010(\u001a\u00020)2&\u0010k\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020m\u0018\u00010lj\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020m\u0018\u0001`n2\u0006\u0010o\u001a\u00020pH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\f\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00140\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f0\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/component/topicact/TopicActivityPresenter;", "Lcom/didi/soda/home/topgun/component/topicact/Contract$AbsTopicActivityPresenter;", "Lcom/didi/soda/datasource/listener/DataSourceListener;", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/ComponentEntity;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "activityId", "", "activityInfoEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity;", "countDownCallback", "Lkotlin/Function0;", "", "Lcom/didi/soda/customer/foundation/util/VoidCallback;", "dataSource", "Lcom/didi/soda/home/topgun/component/topicact/data/ActivityDataSource;", "deadline", "", "feedParamMirrors", "", "", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/FilterEntity;", "filterRvModel", "Lcom/didi/soda/home/topgun/binder/model/FilterRvModel;", "fromChannel", "fromSceneComponent", "", "hasSuccessResponse", "", "listManager", "Lcom/didi/app/nova/support/view/recyclerview/data/ChildDataListManager;", "mFilterHelper", "Lcom/didi/soda/home/topgun/component/filter/FilterHelper;", "mHeaderLoginUnit", "Lcom/didi/soda/home/topgun/binder/LandingLogicUnit;", "mHomePageSource", "mScene", "pageMirrors", "refreshBean", "Lcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity$AutoRefreshBean;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "timer", "Ljava/lang/Runnable;", "timerHandler", "Landroid/os/Handler;", "createPageMirror", "floatToAnchorState", "isErrorState", "getAnchorIndex", "getLogTracker", "Lcom/didi/soda/customer/foundation/log/RecordTracker$Builder;", "message", "category", "getRemainTime", "getScope", "getTabTime4Omega", "entity", "handleAlertMessage", "alertEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity$AlertBean;", "handleCountDown", "initDataManagers", "initFilter", "isFilterNone", "loadNextPage", "needShowAddressTitleLayout", "notifyFilterItemClick", "filterModel", "Lcom/didi/soda/home/topgun/model/FilterModel;", "isFloating", "onCreate", "onDataSourceChanged", "pageStorage", "Lcom/didi/soda/datasource/page/PageStore;", "listData", "", "onDataSourceUpdate", "updatedList", "onDestroy", "onFooterErrorClicked", "onFooterSignInClicked", "onHandleBack", "onLoadMore", "onPageMirrorPlayBack", "pageIndex", "onPageResult", "data", "Landroid/os/Bundle;", "componentId", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "checkOnly", "onPause", "onPullToRefresh", "onResume", "onTabSwitched", "tabInfoEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/TabInfoEntity;", "provideComponentLogicUnit", "Lcom/didi/soda/customer/base/binder/ComponentLogicUnit;", "refresh", "registerScopeActions", "removeFeedBackCard", "Lcom/didi/soda/blocks/action/ActionResult;", "context", "Landroid/content/Context;", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "widget", "Lcom/didi/soda/blocks/widget/Buildable;", "resetFilter", "resetFilterState", "showActivityErrorView", "exceptionBean", "Lcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity$ExceptionBean;", "showErrorView", "showNoServiceView", "showNormalPageView", "subscribeAddressChanged", "updateFilter", "updateFilterFromCache", "updateHomeParam", "filterDataManager", "Lcom/didi/soda/home/topgun/component/filter/FilterDataManager;", "updatePageMoreState", "updateSceneTag", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TopicActivityPresenter.kt */
public final class TopicActivityPresenter extends Contract.AbsTopicActivityPresenter implements DataSourceListener<ComponentEntity, RecyclerModel> {

    /* renamed from: a */
    private IBlockScope f45413a;

    /* renamed from: b */
    private ChildDataListManager<RecyclerModel> f45414b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ActivityDataSource f45415c;

    /* renamed from: d */
    private Map<String, ActivityDataSource> f45416d = new LinkedHashMap();

    /* renamed from: e */
    private Map<String, List<FilterEntity>> f45417e = new LinkedHashMap();

    /* renamed from: f */
    private String f45418f = "";

    /* renamed from: g */
    private String f45419g = "";

    /* renamed from: h */
    private ActivityInfoEntity f45420h;

    /* renamed from: i */
    private int f45421i;

    /* renamed from: j */
    private int f45422j;

    /* renamed from: k */
    private int f45423k;

    /* renamed from: l */
    private boolean f45424l;

    /* renamed from: m */
    private Function0<Unit> f45425m = new TopicActivityPresenter$countDownCallback$1(this);

    /* renamed from: n */
    private final Handler f45426n = new Handler();

    /* renamed from: o */
    private long f45427o = -1;

    /* renamed from: p */
    private ActivityInfoEntity.AutoRefreshBean f45428p;

    /* renamed from: q */
    private final Runnable f45429q = new Runnable() {
        public final void run() {
            TopicActivityPresenter.m33754a(TopicActivityPresenter.this);
        }
    };

    /* renamed from: r */
    private final FilterHelper f45430r = new FilterHelper(4);

    /* renamed from: s */
    private LandingLogicUnit f45431s = new LandingLogicUnit(this);

    /* renamed from: t */
    private FilterRvModel f45432t;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m33754a(TopicActivityPresenter topicActivityPresenter) {
        ActivityInfoEntity.AutoRefreshBean autoRefreshBean;
        ActivityInfoEntity.AlertBean alertBean;
        Intrinsics.checkNotNullParameter(topicActivityPresenter, "this$0");
        ActivityInfoEntity.AutoRefreshBean autoRefreshBean2 = topicActivityPresenter.f45428p;
        boolean z = true;
        if (autoRefreshBean2 != null && autoRefreshBean2.autoRefreshAction == 1) {
            ActivityDataSource activityDataSource = topicActivityPresenter.f45415c;
            if (activityDataSource == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataSource");
                activityDataSource = null;
            }
            activityDataSource.setMReqType(2);
            topicActivityPresenter.f45416d.clear();
            topicActivityPresenter.m33776j();
            return;
        }
        ActivityInfoEntity.AutoRefreshBean autoRefreshBean3 = topicActivityPresenter.f45428p;
        if (autoRefreshBean3 == null || autoRefreshBean3.autoRefreshAction != 2) {
            z = false;
        }
        if (z && (autoRefreshBean = topicActivityPresenter.f45428p) != null && (alertBean = autoRefreshBean.alert) != null) {
            topicActivityPresenter.m33749a(alertBean);
        }
    }

    public void onCreate() {
        String str;
        super.onCreate();
        String string = getScopeContext().getBundle().getString(Const.PageParams.SCENE_EXTRA, "0");
        Intrinsics.checkNotNullExpressionValue(string, "scopeContext.bundle.getS…eParams.SCENE_EXTRA, \"0\")");
        this.f45422j = Integer.parseInt(string);
        String string2 = getScopeContext().getBundle().getString("scene", "0");
        Intrinsics.checkNotNullExpressionValue(string2, "scopeContext.bundle.getS…eParams.TOPIC_SCENE, \"0\")");
        this.f45421i = Integer.parseInt(string2);
        String string3 = getScopeContext().getBundle().getString("homepage_source", "0");
        Intrinsics.checkNotNullExpressionValue(string3, "scopeContext.bundle.getS…ams.HOMEPAGE_SOURCE, \"0\")");
        this.f45423k = Integer.parseInt(string3);
        String string4 = getScopeContext().getBundle().getString("from_channel", "");
        Intrinsics.checkNotNullExpressionValue(string4, "scopeContext.bundle.getS…t.PARAM_FROM_CHANNEL, \"\")");
        this.f45419g = string4;
        ((Contract.AbsTopicActivityView) getLogicView()).setConfigScene(this.f45421i);
        ActivityDataSource b = m33764b();
        this.f45415c = b;
        if (b == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataSource");
            b = null;
        }
        this.f45418f = b.getMActivityId();
        String string5 = getScopeContext().getBundle().getString(Const.PageParams.COMPONENT_ID);
        if (string5 != null) {
            str = string5;
        } else {
            str = "";
        }
        TopicActOmegaHelper instance = TopicActOmegaHelper.Companion.getInstance();
        ScopeContext scopeContext = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
        instance.attach(scopeContext, this.f45418f, this.f45421i, this.f45422j, str);
        registerScopeActions(getScope());
        m33773g();
        m33776j();
        if (this.f45421i == 0) {
            TopicActOmegaHelper.Companion.getInstance().trackPageShow(this.f45418f);
        }
        getScopeContext().attach(Const.TopicActivity.KEY_COUNT_DOWN_CALLBACK, this.f45425m);
        ((ActInvalidateRepo) RepoFactory.getRepo(ActInvalidateRepo.class)).subscriptionNoViscous(getScopeContext(), new Action1() {
            public final void call(Object obj) {
                TopicActivityPresenter.m33757a(TopicActivityPresenter.this, (String) obj);
            }
        });
        m33746a();
        IBlockScope iBlockScope = this.f45413a;
        if (iBlockScope != null) {
            iBlockScope.attach(BlocksConst.BLOCK_PARAM_ROUTE_PATH, RoutePath.BLOCKS_LANDING_PAGE);
        }
        IBlockScope iBlockScope2 = this.f45413a;
        if (iBlockScope2 != null) {
            iBlockScope2.attach("activityId", this.f45418f);
        }
        IBlockScope iBlockScope3 = this.f45413a;
        if (iBlockScope3 != null) {
            iBlockScope3.attach("scene", Integer.valueOf(this.f45421i + this.f45422j));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m33757a(TopicActivityPresenter topicActivityPresenter, String str) {
        Intrinsics.checkNotNullParameter(topicActivityPresenter, "this$0");
        if (!TextUtils.isEmpty(topicActivityPresenter.f45418f) && topicActivityPresenter.f45418f.equals(str)) {
            topicActivityPresenter.getScopeContext().getNavigator().finish();
        }
    }

    public void onPageResult(Bundle bundle) {
        if (bundle != null && bundle.getBoolean(FilterPageKt.KEY_FILTER_CONFIRM)) {
            this.f45430r.doConfirmFromFilterPage(bundle.getBoolean(FilterPageKt.KEY_FILTER_IS_RESET, false));
        }
    }

    /* renamed from: a */
    private final void m33746a() {
        if (needShowAddressTitleLayout()) {
            ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).subscribeAddress(getScopeContext(), new Action1() {
                public final void call(Object obj) {
                    TopicActivityPresenter.m33756a(TopicActivityPresenter.this, (AddressEntity) obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m33756a(TopicActivityPresenter topicActivityPresenter, AddressEntity addressEntity) {
        Intrinsics.checkNotNullParameter(topicActivityPresenter, "this$0");
        LogUtil.m32584d("TAG", " >>>>>> 地址发生变化 <<<<<< ");
        ActivityDataSource activityDataSource = topicActivityPresenter.f45415c;
        if (activityDataSource == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataSource");
            activityDataSource = null;
        }
        activityDataSource.setMReqType(1);
        topicActivityPresenter.f45416d.clear();
        topicActivityPresenter.m33776j();
    }

    public ComponentLogicUnit provideComponentLogicUnit() {
        return this.f45431s;
    }

    public IBlockScope getScope() {
        if (this.f45413a == null) {
            BlockScopeBase createBlockScope = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).createBlockScope();
            ScopeContext scopeContext = getScopeContext();
            Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
            createBlockScope.attach(Const.BusinessConst.SCOPE_KEY_SCOPE_CONTEXT, scopeContext);
            Unit unit = Unit.INSTANCE;
            this.f45413a = createBlockScope;
        }
        IBlockScope iBlockScope = this.f45413a;
        Intrinsics.checkNotNull(iBlockScope);
        return iBlockScope;
    }

    public void onPullToRefresh() {
        m33774h();
        ActivityDataSource activityDataSource = this.f45415c;
        if (activityDataSource == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataSource");
            activityDataSource = null;
        }
        activityDataSource.setMReqType(3);
        this.f45416d.clear();
        m33776j();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f45430r.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f45430r.onPause();
    }

    public final void registerScopeActions(IBlockScope iBlockScope) {
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        iBlockScope.registerAction("removeFeedBack", new TopicActivityPresenter$registerScopeActions$1(this));
        iBlockScope.registerAction("updateSceneTag", new TopicActivityPresenter$registerScopeActions$2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m33761a(int i, RecyclerModel recyclerModel) {
        if (recyclerModel instanceof ComponentModel) {
            Object dataModel = ((ComponentModel) recyclerModel).getDataModel();
            String str = null;
            ComponentEntity componentEntity = dataModel instanceof ComponentEntity ? (ComponentEntity) dataModel : null;
            if (componentEntity != null) {
                str = componentEntity.getType();
            }
            if (TextUtils.equals(str, "1000")) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final ActionResult m33744a(Context context, IBlockScope iBlockScope, HashMap<String, Object> hashMap, Buildable buildable) {
        $$Lambda$TopicActivityPresenter$_jPIiA4Coc1Wp2jmVEhWG_QbIh0 r1 = $$Lambda$TopicActivityPresenter$_jPIiA4Coc1Wp2jmVEhWG_QbIh0.INSTANCE;
        ActivityDataSource activityDataSource = this.f45415c;
        if (activityDataSource == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataSource");
            activityDataSource = null;
        }
        activityDataSource.remove(r1);
        return ActionResult.Companion.resolve$default(ActionResult.Companion, (HashMap) null, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r4 = r5.get(com.didi.soda.customer.blocks.BlocksConst.ACTION_PARAMS_SCENE_ID);
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.didi.soda.blocks.action.ActionResult m33763b(android.content.Context r3, com.didi.soda.blocks.scope.IBlockScope r4, java.util.HashMap<java.lang.String, java.lang.Object> r5, com.didi.soda.blocks.widget.Buildable r6) {
        /*
            r2 = this;
            r3 = 0
            if (r5 != 0) goto L_0x0005
        L_0x0003:
            r4 = r3
            goto L_0x0012
        L_0x0005:
            java.lang.String r4 = "sceneId"
            java.lang.Object r4 = r5.get(r4)
            if (r4 != 0) goto L_0x000e
            goto L_0x0003
        L_0x000e:
            java.lang.String r4 = r4.toString()
        L_0x0012:
            if (r4 == 0) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            java.lang.String r4 = ""
        L_0x0017:
            java.lang.String r5 = "launchActivityPage_"
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r4)
            long r5 = java.lang.System.currentTimeMillis()
            java.lang.Class<com.didi.soda.customer.foundation.storage.FeedBackStrategyStore> r0 = com.didi.soda.customer.foundation.storage.FeedBackStrategyStore.class
            java.lang.Object r0 = com.didi.soda.customer.foundation.util.SingletonFactory.get(r0)
            com.didi.soda.customer.foundation.storage.FeedBackStrategyStore r0 = (com.didi.soda.customer.foundation.storage.FeedBackStrategyStore) r0
            com.didi.soda.customer.foundation.storage.model.FeedBackStrategyConfig r1 = r0.getData((java.lang.String) r4)
            if (r1 != 0) goto L_0x0034
            com.didi.soda.customer.foundation.storage.model.FeedBackStrategyConfig r1 = new com.didi.soda.customer.foundation.storage.model.FeedBackStrategyConfig
            r1.<init>()
        L_0x0034:
            r1.setSceneId(r4)
            r1.setLastRemoveTime(r5)
            android.os.Parcelable r1 = (android.os.Parcelable) r1
            r0.setData((java.lang.String) r4, r1)
            com.didi.soda.blocks.action.ActionResult$Companion r4 = com.didi.soda.blocks.action.ActionResult.Companion
            r5 = 1
            com.didi.soda.blocks.action.ActionResult r3 = com.didi.soda.blocks.action.ActionResult.Companion.resolve$default(r4, r3, r5, r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.component.topicact.TopicActivityPresenter.m33763b(android.content.Context, com.didi.soda.blocks.scope.IBlockScope, java.util.HashMap, com.didi.soda.blocks.widget.Buildable):com.didi.soda.blocks.action.ActionResult");
    }

    public boolean needShowAddressTitleLayout() {
        if (Intrinsics.areEqual((Object) getScopeContext().getBundle().getString("from_channel", ""), (Object) "1")) {
            return CustomerApolloUtil.getSALandingShowAddr();
        }
        return false;
    }

    public void onTabSwitched(TabInfoEntity tabInfoEntity) {
        Intrinsics.checkNotNullParameter(tabInfoEntity, "tabInfoEntity");
        super.onTabSwitched(tabInfoEntity);
        String tabId = tabInfoEntity.getTabId();
        ActivityDataSource activityDataSource = this.f45415c;
        ActivityDataSource activityDataSource2 = null;
        if (activityDataSource == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataSource");
            activityDataSource = null;
        }
        if (!Intrinsics.areEqual((Object) tabId, (Object) activityDataSource.getMTabId())) {
            TopicActOmegaHelper instance = TopicActOmegaHelper.Companion.getInstance();
            String str = this.f45418f;
            String tabId2 = tabInfoEntity.getTabId();
            if (tabId2 == null) {
                tabId2 = "";
            }
            instance.trackTabClick(str, tabId2, tabInfoEntity.getIndex());
            String tabId3 = tabInfoEntity.getTabId();
            if (tabId3 != null) {
                ActivityDataSource activityDataSource3 = this.f45415c;
                if (activityDataSource3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataSource");
                    activityDataSource3 = null;
                }
                String mTabId = activityDataSource3.getMTabId();
                if (mTabId != null) {
                    Map<String, ActivityDataSource> map = this.f45416d;
                    ActivityDataSource activityDataSource4 = this.f45415c;
                    if (activityDataSource4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dataSource");
                        activityDataSource4 = null;
                    }
                    map.put(mTabId, activityDataSource4);
                }
                if (this.f45416d.get(tabId3) != null) {
                    ActivityDataSource activityDataSource5 = this.f45416d.get(tabId3);
                    Intrinsics.checkNotNull(activityDataSource5);
                    this.f45415c = activityDataSource5;
                    updateFilterFromCache();
                    ActivityDataSource activityDataSource6 = this.f45415c;
                    if (activityDataSource6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dataSource");
                    } else {
                        activityDataSource2 = activityDataSource6;
                    }
                    activityDataSource2.playBackDataSource();
                    return;
                }
                ActivityDataSource b = m33764b();
                b.setMReqType(4);
                b.setMTabId(tabId3);
                Unit unit = Unit.INSTANCE;
                this.f45415c = b;
                updateFilterFromCache();
                m33776j();
            }
        }
    }

    public final void updateFilterFromCache() {
        Map<String, List<FilterEntity>> map = this.f45417e;
        ActivityDataSource activityDataSource = this.f45415c;
        if (activityDataSource == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataSource");
            activityDataSource = null;
        }
        String mTabId = activityDataSource.getMTabId();
        if (mTabId == null) {
            mTabId = "";
        }
        List list = map.get(mTabId);
        if (list != null) {
            this.f45430r.getFilterManager().parseFilterEntity(list);
            FilterRvModel filterRvModel = this.f45432t;
            if (filterRvModel != null) {
                filterRvModel.setFilterManager(this.f45430r.getFilterManager());
            }
            m33775i();
            m33753a(this.f45430r.getFilterManager());
        }
    }

    public final void resetFilter() {
        this.f45430r.reset();
    }

    public final void notifyFilterItemClick(FilterModel filterModel, boolean z) {
        if (filterModel != null) {
            filterModel.mTopicFromScence = this.f45421i;
            filterModel.mTimePeriod = getMOmegaTabTime();
            FilterHelper filterHelper = this.f45430r;
            ScopeContext scopeContext = getScopeContext();
            Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
            filterHelper.clickItem(filterModel, scopeContext);
            if (filterModel.mShowType == 7) {
                TopicActOmegaHelper.Companion.getInstance().headerFilterTopicCategoriesCK(filterModel.getCurrentHeaderLine(), String.valueOf(this.f45421i), getMOmegaTabTime());
            } else if (filterModel.mShowType == 5) {
                TopicActOmegaHelper.Companion.getInstance().headerFilterTopicSportCK(filterModel.getCurrentHeaderLine(), String.valueOf(this.f45421i), getMOmegaTabTime(), filterModel.getOutFilterId(), String.valueOf(filterModel.position));
            }
        }
    }

    /* renamed from: b */
    private final ActivityDataSource m33764b() {
        ScopeContext scopeContext = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
        ActivityDataSource activityDataSource = new ActivityDataSource(scopeContext, getScope(), this);
        activityDataSource.setOnPageResultListener(new TopicActivityPresenter$createPageMirror$1$1(this));
        activityDataSource.setOnPagePlayBackListener(new TopicActivityPresenter$createPageMirror$1$2(this));
        return activityDataSource;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        TopicActOmegaHelper instance = TopicActOmegaHelper.Companion.getInstance();
        ScopeContext scopeContext = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
        instance.detach(scopeContext);
        ((Contract.AbsTopicActivityView) getLogicView()).dismissPullToRefresh();
        this.f45426n.removeCallbacksAndMessages((Object) null);
        FilterDataManager.Companion.removeHadaManager(4);
    }

    public void initDataManagers() {
        super.initDataManagers();
        if (this.f45414b == null) {
            ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager();
            this.f45414b = createChildDataListManager;
            addDataManager(createChildDataListManager);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: com.didi.soda.home.topgun.component.topicact.data.ActivityDataSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v3, resolved type: com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity$ExceptionBean} */
    /* JADX WARNING: type inference failed for: r14v0 */
    /* JADX WARNING: type inference failed for: r14v2 */
    /* JADX WARNING: type inference failed for: r14v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPageResult(int r16, java.lang.String r17, com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity r18, com.didi.soda.customer.foundation.rpc.net.SFRpcException r19, boolean r20) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r10 = r18
            r11 = r19
            r12 = 1
            java.lang.String r13 = "dataSource"
            r14 = 0
            if (r20 != 0) goto L_0x005a
            int r2 = r0.f45421i
            if (r2 == 0) goto L_0x005a
            int r3 = r0.f45422j
            int r7 = r2 + r3
            com.didi.soda.home.topgun.component.topicact.data.ActivityDataSource r2 = r0.f45415c
            if (r2 != 0) goto L_0x001d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r13)
            r2 = r14
        L_0x001d:
            int r2 = r2.getMReqType()
            if (r2 != r12) goto L_0x0039
            com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper$Companion r2 = com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper.Companion
            com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper r2 = r2.getInstance()
            int r3 = r0.f45423k
            java.lang.String r4 = r0.f45419g
            java.lang.String r5 = r0.f45418f
            r6 = r17
            r8 = r18
            r9 = r19
            r2.trackLandingPageShow(r3, r4, r5, r6, r7, r8, r9)
            goto L_0x005a
        L_0x0039:
            com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity r2 = r0.f45420h
            if (r2 != 0) goto L_0x003f
            r2 = r14
            goto L_0x0041
        L_0x003f:
            com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity$ExceptionBean r2 = r2.exception
        L_0x0041:
            if (r2 != 0) goto L_0x0045
            if (r11 == 0) goto L_0x005a
        L_0x0045:
            com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper$Companion r2 = com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper.Companion
            com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper r2 = r2.getInstance()
            int r3 = r0.f45423k
            java.lang.String r4 = r0.f45419g
            java.lang.String r5 = r0.f45418f
            r6 = r17
            r8 = r18
            r9 = r19
            r2.trackLandingPageShow(r3, r4, r5, r6, r7, r8, r9)
        L_0x005a:
            com.didi.app.nova.skeleton.mvp.IView r2 = r15.getLogicView()
            com.didi.soda.home.topgun.component.topicact.Contract$AbsTopicActivityView r2 = (com.didi.soda.home.topgun.component.topicact.Contract.AbsTopicActivityView) r2
            r2.dismissPullToRefresh()
            r0.f45420h = r10
            com.didi.app.nova.skeleton.mvp.IView r2 = r15.getLogicView()
            com.didi.soda.home.topgun.component.topicact.Contract$AbsTopicActivityView r2 = (com.didi.soda.home.topgun.component.topicact.Contract.AbsTopicActivityView) r2
            r2.dismissLoadingDialog()
            if (r20 != 0) goto L_0x0094
            com.didi.soda.home.topgun.component.topicact.data.ActivityDataSource r2 = r0.f45415c
            if (r2 != 0) goto L_0x0078
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r13)
            r2 = r14
        L_0x0078:
            int r2 = r2.getMReqType()
            r3 = 4
            if (r2 != r3) goto L_0x0089
            com.didi.app.nova.skeleton.mvp.IView r2 = r15.getLogicView()
            com.didi.soda.home.topgun.component.topicact.Contract$AbsTopicActivityView r2 = (com.didi.soda.home.topgun.component.topicact.Contract.AbsTopicActivityView) r2
            r2.scrollToLastOffest()
            goto L_0x0094
        L_0x0089:
            if (r1 != 0) goto L_0x0094
            com.didi.app.nova.skeleton.mvp.IView r2 = r15.getLogicView()
            com.didi.soda.home.topgun.component.topicact.Contract$AbsTopicActivityView r2 = (com.didi.soda.home.topgun.component.topicact.Contract.AbsTopicActivityView) r2
            r2.scrollToTop()
        L_0x0094:
            com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity r2 = r0.f45420h
            if (r2 != 0) goto L_0x009a
            r2 = r14
            goto L_0x009c
        L_0x009a:
            com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity$ExceptionBean r2 = r2.exception
        L_0x009c:
            if (r2 == 0) goto L_0x00a9
            com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity r1 = r0.f45420h
            if (r1 != 0) goto L_0x00a3
            goto L_0x00a5
        L_0x00a3:
            com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity$ExceptionBean r14 = r1.exception
        L_0x00a5:
            r15.m33751a((com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity.ExceptionBean) r14)
            goto L_0x00eb
        L_0x00a9:
            if (r11 == 0) goto L_0x00af
            r15.m33748a((int) r1, (com.didi.soda.customer.foundation.rpc.net.SFRpcException) r11)
            goto L_0x00eb
        L_0x00af:
            if (r20 != 0) goto L_0x00eb
            if (r10 == 0) goto L_0x00eb
            com.didi.soda.home.topgun.component.topicact.data.ActivityDataSource r2 = r0.f45415c
            if (r2 != 0) goto L_0x00bb
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r13)
            goto L_0x00bc
        L_0x00bb:
            r14 = r2
        L_0x00bc:
            r2 = 0
            r14.setMReqType(r2)
            if (r1 != 0) goto L_0x00d6
            java.util.List<com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity> r3 = r10.mCompList
            java.util.Collection r3 = (java.util.Collection) r3
            if (r3 == 0) goto L_0x00d0
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x00cf
            goto L_0x00d0
        L_0x00cf:
            r12 = 0
        L_0x00d0:
            if (r12 == 0) goto L_0x00d6
            r15.m33772f()
            goto L_0x00eb
        L_0x00d6:
            r15.m33747a((int) r1, (com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity) r10)
            com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity$AlertBean r1 = r10.alert
            if (r1 != 0) goto L_0x00de
            goto L_0x00e1
        L_0x00de:
            r15.m33749a((com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity.AlertBean) r1)
        L_0x00e1:
            com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity$AutoRefreshBean r1 = r10.autoRefresh
            if (r1 != 0) goto L_0x00e6
            goto L_0x00eb
        L_0x00e6:
            r0.f45428p = r1
            r15.m33750a((com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity.AutoRefreshBean) r1)
        L_0x00eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.component.topicact.TopicActivityPresenter.onPageResult(int, java.lang.String, com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity, com.didi.soda.customer.foundation.rpc.net.SFRpcException, boolean):void");
    }

    /* renamed from: a */
    private final void m33749a(ActivityInfoEntity.AlertBean alertBean) {
        if (alertBean.type == 1) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            RFCommonDialog.Builder message = new RFCommonDialog.Builder().setMessage(RichTextParser.parseText(alertBean.content));
            if (alertBean.action == 1) {
                message.setMainAction(ResourceHelper.getString(R.string.FoodC_sale_OK_NWns), new RFDialogInterface.OnClickListener() {
                    public final void onClick(RFDialog rFDialog) {
                        TopicActivityPresenter.m33758a(Ref.ObjectRef.this, rFDialog);
                    }
                });
            } else if (alertBean.action == 2) {
                message.setMainAction(ResourceHelper.getString(R.string.FoodC_sale_OK_NWns), new RFDialogInterface.OnClickListener(this) {
                    public final /* synthetic */ TopicActivityPresenter f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(RFDialog rFDialog) {
                        TopicActivityPresenter.m33759a(Ref.ObjectRef.this, this.f$1, rFDialog);
                    }
                });
            }
            objectRef.element = message.create();
            SodaWindowFactory.showDialog(getScopeContext().getNavigator(), (Dialog) objectRef.element);
            TopicActOmegaHelper.Companion.getInstance().trackLandingPageFailShow(this.f45418f, alertBean.content);
            return;
        }
        ToastUtil.showCustomerToast(getScopeContext(), alertBean.content);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m33758a(Ref.ObjectRef objectRef, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(objectRef, "$dialog");
        RFDialog rFDialog2 = (RFDialog) objectRef.element;
        if (rFDialog2 != null) {
            rFDialog2.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m33759a(Ref.ObjectRef objectRef, TopicActivityPresenter topicActivityPresenter, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(objectRef, "$dialog");
        Intrinsics.checkNotNullParameter(topicActivityPresenter, "this$0");
        RFDialog rFDialog2 = (RFDialog) objectRef.element;
        if (rFDialog2 != null) {
            rFDialog2.dismiss();
        }
        topicActivityPresenter.getScopeContext().getNavigator().finish();
    }

    /* renamed from: a */
    private final void m33750a(ActivityInfoEntity.AutoRefreshBean autoRefreshBean) {
        this.f45427o = autoRefreshBean.refreshTs;
        this.f45426n.removeCallbacksAndMessages((Object) null);
        if (m33768c() != 0) {
            this.f45426n.postDelayed(this.f45429q, m33768c() * 1000);
        }
    }

    /* renamed from: c */
    private final long m33768c() {
        return Math.max(this.f45427o - Clock.timeAtSeconds(), 0);
    }

    public final void onPageMirrorPlayBack(int i, ActivityInfoEntity activityInfoEntity) {
        this.f45420h = activityInfoEntity;
        if (activityInfoEntity != null) {
            m33747a(i, activityInfoEntity);
        }
        ((Contract.AbsTopicActivityView) getLogicView()).scrollToLastOffest();
    }

    /* renamed from: a */
    private final void m33747a(int i, ActivityInfoEntity activityInfoEntity) {
        boolean z;
        boolean z2;
        ActivityInfoEntity.HeaderInfo headerInfo;
        boolean z3 = true;
        if (i == 0) {
            ((Contract.AbsTopicActivityView) getLogicView()).showNavBarWhenNormal();
            Collection collection = activityInfoEntity.mCompList;
            if (!(collection == null || collection.isEmpty())) {
                z = activityInfoEntity.mCompList.get(0).header != null || (Intrinsics.areEqual((Object) activityInfoEntity.mCompList.get(0).getType(), (Object) "300") && activityInfoEntity.mCompList.get(0).data != null);
                Contract.AbsTopicActivityView absTopicActivityView = (Contract.AbsTopicActivityView) getLogicView();
                ComponentEntity componentEntity = activityInfoEntity.mCompList.get(0);
                ActivityInfoEntity.RuleLink ruleLink = (componentEntity == null || (headerInfo = componentEntity.header) == null) ? null : headerInfo.ruleLink;
                ActivityDataSource activityDataSource = this.f45415c;
                if (activityDataSource == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataSource");
                    activityDataSource = null;
                }
                ActInfoEntity mActInfo = activityDataSource.getMActInfo();
                absTopicActivityView.setRules(ruleLink, mActInfo == null ? null : mActInfo.getActId());
                if (z) {
                    m33752a(activityInfoEntity);
                }
                TopicActivityPresenter topicActivityPresenter = this;
                List<ComponentEntity> list = activityInfoEntity.mCompList;
                Intrinsics.checkNotNullExpressionValue(list, "entity.mCompList");
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    }
                    ComponentEntity componentEntity2 = (ComponentEntity) it.next();
                    if (!CollectionsUtil.isEmpty(componentEntity2.mFilterList)) {
                        ActivityDataSource activityDataSource2 = topicActivityPresenter.f45415c;
                        if (activityDataSource2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("dataSource");
                            activityDataSource2 = null;
                        }
                        String mTabId = activityDataSource2.getMTabId();
                        if (mTabId != null) {
                            topicActivityPresenter.f45417e.put(mTabId, componentEntity2.mFilterList);
                        }
                        topicActivityPresenter.f45430r.getFilterManager().parseFilterEntity(componentEntity2.mFilterList);
                        FilterRvModel filterRvModel = topicActivityPresenter.f45432t;
                        if (filterRvModel != null) {
                            filterRvModel.setFilterManager(topicActivityPresenter.f45430r.getFilterManager());
                        }
                        topicActivityPresenter.m33775i();
                        z2 = true;
                    }
                }
                if (!z2) {
                    ActivityDataSource activityDataSource3 = this.f45415c;
                    if (activityDataSource3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dataSource");
                        activityDataSource3 = null;
                    }
                    String mTabId2 = activityDataSource3.getMTabId();
                    if (mTabId2 != null) {
                        this.f45417e.put(mTabId2, (Object) null);
                    }
                }
            } else {
                z = false;
            }
            ((Contract.AbsTopicActivityView) getLogicView()).setStyleByColorAndHeader(activityInfoEntity.bgColor, z);
        }
        m33778l();
        if (activityInfoEntity.navi != null) {
            CharSequence charSequence = activityInfoEntity.navi.title;
            if (!(charSequence == null || charSequence.length() == 0)) {
                z3 = false;
            }
            if (!z3) {
                String str = activityInfoEntity.navi.title;
                Intrinsics.checkNotNullExpressionValue(str, "entity.navi.title");
                ((Contract.AbsTopicActivityView) getLogicView()).setTitle(str);
                return;
            }
        }
        ((Contract.AbsTopicActivityView) getLogicView()).setTitle("");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        r0 = r0.header;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m33752a(com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity r5) {
        /*
            r4 = this;
            java.util.List<com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity> r0 = r5.mCompList
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity r0 = (com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity) r0
            r2 = 0
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            r0 = r2
            goto L_0x0015
        L_0x000e:
            com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity$HeaderInfo r0 = r0.header
            if (r0 != 0) goto L_0x0013
            goto L_0x000c
        L_0x0013:
            com.didi.soda.customer.foundation.rpc.entity.TabInfoEntity r0 = r0.tab
        L_0x0015:
            if (r0 == 0) goto L_0x003e
            java.util.List<com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity> r5 = r5.mCompList
            java.lang.Object r5 = r5.get(r1)
            com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity r5 = (com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity) r5
            if (r5 != 0) goto L_0x0022
            goto L_0x0030
        L_0x0022:
            com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity$HeaderInfo r5 = r5.header
            if (r5 != 0) goto L_0x0027
            goto L_0x0030
        L_0x0027:
            com.didi.soda.customer.foundation.rpc.entity.TabInfoEntity r5 = r5.tab
            if (r5 != 0) goto L_0x002c
            goto L_0x0030
        L_0x002c:
            java.lang.String r2 = r5.getTitle()
        L_0x0030:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.CharSequence r5 = com.didi.soda.customer.widget.text.RichTextParser.parseText(r2)
            java.lang.String r5 = r5.toString()
            r4.setMOmegaTabTime(r5)
            goto L_0x0090
        L_0x003e:
            java.util.List<com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity> r5 = r5.mCompList
            java.lang.Object r5 = r5.get(r1)
            com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity r5 = (com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity) r5
            if (r5 != 0) goto L_0x0049
            goto L_0x0090
        L_0x0049:
            com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity$HeaderInfo r5 = r5.header
            if (r5 != 0) goto L_0x004e
            goto L_0x0090
        L_0x004e:
            java.util.List<com.didi.soda.customer.foundation.rpc.entity.TabInfoEntity> r5 = r5.tabs
            if (r5 != 0) goto L_0x0053
            goto L_0x0090
        L_0x0053:
            java.util.Iterator r5 = r5.iterator()
        L_0x0057:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0090
            java.lang.Object r0 = r5.next()
            com.didi.soda.customer.foundation.rpc.entity.TabInfoEntity r0 = (com.didi.soda.customer.foundation.rpc.entity.TabInfoEntity) r0
            if (r0 != 0) goto L_0x0066
            goto L_0x0057
        L_0x0066:
            java.lang.String r1 = r0.getTabId()
            com.didi.soda.home.topgun.component.topicact.data.ActivityDataSource r3 = r4.f45415c
            if (r3 != 0) goto L_0x0074
            java.lang.String r3 = "dataSource"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r3 = r2
        L_0x0074:
            java.lang.String r3 = r3.getMTabId()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 == 0) goto L_0x0057
            java.lang.String r0 = r0.getTitle()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r0 = com.didi.soda.customer.widget.text.RichTextParser.parseText(r0)
            java.lang.String r0 = r0.toString()
            r4.setMOmegaTabTime(r0)
            goto L_0x0057
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.component.topicact.TopicActivityPresenter.m33752a(com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity):void");
    }

    /* renamed from: a */
    private final void m33760a(boolean z) {
        ActivityDataSource activityDataSource = null;
        boolean z2 = true;
        if (z) {
            ActivityDataSource activityDataSource2 = this.f45415c;
            if (activityDataSource2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataSource");
            } else {
                activityDataSource = activityDataSource2;
            }
            HomeFeedParam homeFeedParam = activityDataSource.getHomeFeedParam();
            if (homeFeedParam == null || !homeFeedParam.isFilter()) {
                z2 = false;
            }
            if (z2) {
                ((Contract.AbsTopicActivityView) getLogicView()).scrollToFloatingState(-1, false);
                return;
            }
            return;
        }
        ActivityDataSource activityDataSource3 = this.f45415c;
        if (activityDataSource3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataSource");
            activityDataSource3 = null;
        }
        HomeFeedParam homeFeedParam2 = activityDataSource3.getHomeFeedParam();
        boolean z3 = (homeFeedParam2 != null && homeFeedParam2.getPageIndex() == 0) && m33770d();
        ActivityDataSource activityDataSource4 = this.f45415c;
        if (activityDataSource4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataSource");
            activityDataSource4 = null;
        }
        HomeFeedParam homeFeedParam3 = activityDataSource4.getHomeFeedParam();
        if ((homeFeedParam3 != null && homeFeedParam3.isFilter()) || z3) {
            ActivityDataSource activityDataSource5 = this.f45415c;
            if (activityDataSource5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataSource");
                activityDataSource5 = null;
            }
            HomeFeedParam homeFeedParam4 = activityDataSource5.getHomeFeedParam();
            if (homeFeedParam4 == null || !homeFeedParam4.isFilter()) {
                z2 = false;
            }
            if (z2) {
                ActivityDataSource activityDataSource6 = this.f45415c;
                if (activityDataSource6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataSource");
                } else {
                    activityDataSource = activityDataSource6;
                }
                HomeFeedParam homeFeedParam5 = activityDataSource.getHomeFeedParam();
                if (homeFeedParam5 != null) {
                    homeFeedParam5.setIsFilter(false);
                }
                ((Contract.AbsTopicActivityView) getLogicView()).scrollToFloatingState(m33771e(), z3);
                return;
            }
            return;
        }
        Contract.AbsTopicActivityView absTopicActivityView = (Contract.AbsTopicActivityView) getLogicView();
        ActivityDataSource activityDataSource7 = this.f45415c;
        if (activityDataSource7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataSource");
        } else {
            activityDataSource = activityDataSource7;
        }
        HomeFeedParam homeFeedParam6 = activityDataSource.getHomeFeedParam();
        if (homeFeedParam6 == null || !homeFeedParam6.getHasMore()) {
            z2 = false;
        }
        absTopicActivityView.fillRecyclerViewContentHeight(z2);
    }

    /* renamed from: d */
    private final boolean m33770d() {
        ActivityDataSource activityDataSource = this.f45415c;
        if (activityDataSource == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataSource");
            activityDataSource = null;
        }
        return activityDataSource.find(new TopicActivityPresenter$isFilterNone$1()) >= 0;
    }

    /* renamed from: e */
    private final int m33771e() {
        ActivityDataSource activityDataSource = this.f45415c;
        if (activityDataSource == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataSource");
            activityDataSource = null;
        }
        return activityDataSource.find($$Lambda$TopicActivityPresenter$26iVEffD9VWLFob9nXXv_QYCKg0.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final boolean m33767b(int i, RecyclerModel recyclerModel) {
        return (recyclerModel instanceof ComponentModel) || (recyclerModel instanceof HomeNoResultRvModel);
    }

    /* renamed from: a */
    private final void m33751a(ActivityInfoEntity.ExceptionBean exceptionBean) {
        String str;
        Integer num;
        String str2;
        String str3;
        String str4;
        ActivityInfoEntity.ButtonBean buttonBean;
        ActivityAbnormalViewModel.Builder builder = ActivityAbnormalViewModel.Companion.builder();
        String str5 = null;
        if (exceptionBean == null) {
            str = null;
        } else {
            str = exceptionBean.pic;
        }
        ActivityAbnormalViewModel.Builder imageUrl = builder.setImageUrl(str);
        if (exceptionBean == null) {
            num = null;
        } else {
            num = Integer.valueOf(exceptionBean.actStatus);
        }
        ActivityAbnormalViewModel.Builder actStatus = imageUrl.setActStatus(num);
        if (exceptionBean == null) {
            str2 = null;
        } else {
            str2 = exceptionBean.bgColor;
        }
        ActivityAbnormalViewModel.Builder backgroundColor = actStatus.setBackgroundColor(str2);
        if (exceptionBean == null || (buttonBean = exceptionBean.btn) == null) {
            str3 = null;
        } else {
            str3 = buttonBean.title;
        }
        ActivityAbnormalViewModel.Builder button = backgroundColor.setButton(str3);
        if (exceptionBean == null) {
            str4 = null;
        } else {
            str4 = exceptionBean.desc;
        }
        ActivityAbnormalViewModel.Builder desc = button.setDesc(str4);
        if (exceptionBean != null) {
            str5 = exceptionBean.detail;
        }
        ActivityAbnormalViewModel build = desc.setDetail(str5).setClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TopicActivityPresenter.m33755a(TopicActivityPresenter.this, view);
            }
        }).setHeight(-1).build();
        ChildDataListManager<RecyclerModel> childDataListManager = this.f45414b;
        if (childDataListManager != null) {
            childDataListManager.clear();
        }
        ChildDataListManager<RecyclerModel> childDataListManager2 = this.f45414b;
        if (childDataListManager2 != null) {
            childDataListManager2.add(build);
        }
        ((Contract.AbsTopicActivityView) getLogicView()).showNavBarWhenError();
        ((Contract.AbsTopicActivityView) getLogicView()).resetStyle();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m33755a(TopicActivityPresenter topicActivityPresenter, View view) {
        Intrinsics.checkNotNullParameter(topicActivityPresenter, "this$0");
        topicActivityPresenter.getScopeContext().getNavigator().finish();
        ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).activityInvalidedRefreshHome();
    }

    /* renamed from: f */
    private final void m33772f() {
        ((Contract.AbsTopicActivityView) getLogicView()).showFooterEmptyView();
        TopGunAbnormalRvModel topGunAbnormalRvModel = new TopGunAbnormalRvModel();
        topGunAbnormalRvModel.mHeight = ((Contract.AbsTopicActivityView) getLogicView()).calculateAbnormalHeight();
        topGunAbnormalRvModel.setAbnormalVm(new TopGunAbnormalViewModel.Builder().setResId(R.drawable.customer_img_topgun_no_shop_result).setTitle(ResourceHelper.getString(R.string.FoodC_result_No_store_onPd)).build());
        ChildDataListManager<RecyclerModel> childDataListManager = this.f45414b;
        if (childDataListManager != null) {
            childDataListManager.clear();
        }
        ChildDataListManager<RecyclerModel> childDataListManager2 = this.f45414b;
        if (childDataListManager2 != null) {
            childDataListManager2.add(topGunAbnormalRvModel);
        }
        ((Contract.AbsTopicActivityView) getLogicView()).showNavBarWhenError();
        ((Contract.AbsTopicActivityView) getLogicView()).resetStyle();
        TopicActOmegaHelper.Companion.getInstance().trackNoServiceSw();
    }

    /* renamed from: a */
    private final void m33748a(int i, SFRpcException sFRpcException) {
        if (i == 0) {
            if (NetWorkUtils.isNetworkConnected(getContext())) {
                ChildDataListManager<RecyclerModel> childDataListManager = this.f45414b;
                if (childDataListManager != null) {
                    childDataListManager.clear();
                }
                TopGunAbnormalRvModel topGunAbnormalRvModel = new TopGunAbnormalRvModel();
                topGunAbnormalRvModel.mHeight = ((Contract.AbsTopicActivityView) getLogicView()).calculateAbnormalHeight();
                topGunAbnormalRvModel.setAbnormalVm(TopGunAbnormalFactory.buildHomeNoService(sFRpcException.getMessage(), new View.OnClickListener() {
                    public final void onClick(View view) {
                        TopicActivityPresenter.m33766b(TopicActivityPresenter.this, view);
                    }
                }));
                ChildDataListManager<RecyclerModel> childDataListManager2 = this.f45414b;
                if (childDataListManager2 != null) {
                    childDataListManager2.add(topGunAbnormalRvModel);
                }
                m33745a("updateErrorState -> Network", "c-data|").build().error();
            } else {
                ChildDataListManager<RecyclerModel> childDataListManager3 = this.f45414b;
                if (childDataListManager3 != null) {
                    childDataListManager3.clear();
                }
                TopGunAbnormalRvModel topGunAbnormalRvModel2 = new TopGunAbnormalRvModel();
                topGunAbnormalRvModel2.mHeight = ((Contract.AbsTopicActivityView) getLogicView()).calculateAbnormalHeight();
                topGunAbnormalRvModel2.setAbnormalVm(TopGunAbnormalFactory.buildNoNetwork(new View.OnClickListener() {
                    public final void onClick(View view) {
                        TopicActivityPresenter.m33769c(TopicActivityPresenter.this, view);
                    }
                }));
                ChildDataListManager<RecyclerModel> childDataListManager4 = this.f45414b;
                if (childDataListManager4 != null) {
                    childDataListManager4.add(topGunAbnormalRvModel2);
                }
                m33745a("updateErrorState -> Service No Cache", "c-data|").build().error();
            }
            ((Contract.AbsTopicActivityView) getLogicView()).showNavBarWhenError();
            ((Contract.AbsTopicActivityView) getLogicView()).resetStyle();
            return;
        }
        if (NetWorkUtils.isNetworkConnected(getContext())) {
            ((Contract.AbsTopicActivityView) getLogicView()).showFooterErrorView();
        } else {
            ((Contract.AbsTopicActivityView) getLogicView()).showFooterNoNetView();
        }
        m33745a("updateErrorState -> Footer Error", "c-data|").build().error();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m33766b(TopicActivityPresenter topicActivityPresenter, View view) {
        Intrinsics.checkNotNullParameter(topicActivityPresenter, "this$0");
        topicActivityPresenter.m33776j();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m33769c(TopicActivityPresenter topicActivityPresenter, View view) {
        Intrinsics.checkNotNullParameter(topicActivityPresenter, "this$0");
        topicActivityPresenter.m33776j();
    }

    public void onLoadMore() {
        ActivityDataSource activityDataSource = this.f45415c;
        if (activityDataSource == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataSource");
            activityDataSource = null;
        }
        if (activityDataSource.getHasMore() && !((Contract.AbsTopicActivityView) getLogicView()).needBlockFooterLoading()) {
            ((Contract.AbsTopicActivityView) getLogicView()).showFooterLoadingView();
            m33777k();
            m33745a("onLoadMore", "c-act|").build().info();
        }
    }

    public void onDataSourceChanged(PageStore<ComponentEntity, RecyclerModel> pageStore, List<RecyclerModel> list) {
        this.f45424l = true;
        ChildDataListManager<RecyclerModel> childDataListManager = this.f45414b;
        if (childDataListManager != null) {
            childDataListManager.set(list);
        }
        if (list != null) {
            for (RecyclerModel recyclerModel : list) {
                if (recyclerModel instanceof FilterRvModel) {
                    this.f45432t = (FilterRvModel) recyclerModel;
                }
            }
        }
    }

    public void onDataSourceUpdate(List<RecyclerModel> list) {
        ChildDataListManager<RecyclerModel> childDataListManager;
        if (list != null) {
            int i = 0;
            int size = list.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i2 = i + 1;
                    RecyclerModel recyclerModel = list.get(i);
                    ChildDataListManager<RecyclerModel> childDataListManager2 = this.f45414b;
                    int indexOf = childDataListManager2 == null ? -1 : childDataListManager2.indexOf(recyclerModel);
                    if (indexOf >= 0 && (childDataListManager = this.f45414b) != null) {
                        childDataListManager.set(indexOf, recyclerModel);
                    }
                    if (i2 <= size) {
                        i = i2;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: g */
    private final void m33773g() {
        this.f45430r.setOnFilterEvent(new TopicActivityPresenter$initFilter$1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m33753a(FilterDataManager filterDataManager) {
        String json = GsonUtil.toJson(filterDataManager.generateOutParams());
        ActivityDataSource activityDataSource = this.f45415c;
        if (activityDataSource == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataSource");
            activityDataSource = null;
        }
        HomeFeedParam homeFeedParam = activityDataSource.getHomeFeedParam();
        if (homeFeedParam != null) {
            homeFeedParam.updateFilterParam(json);
        }
        getScopeContext().attach("filter", json);
    }

    /* renamed from: h */
    private final void m33774h() {
        ActivityDataSource activityDataSource = this.f45415c;
        ActivityDataSource activityDataSource2 = null;
        if (activityDataSource == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataSource");
            activityDataSource = null;
        }
        HomeFeedParam homeFeedParam = activityDataSource.getHomeFeedParam();
        boolean z = true;
        if (homeFeedParam == null || !homeFeedParam.isFilter()) {
            z = false;
        }
        if (z) {
            ActivityDataSource activityDataSource3 = this.f45415c;
            if (activityDataSource3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataSource");
            } else {
                activityDataSource2 = activityDataSource3;
            }
            HomeFeedParam homeFeedParam2 = activityDataSource2.getHomeFeedParam();
            if (homeFeedParam2 != null) {
                homeFeedParam2.setIsFilter(false);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m33762a(int i, Object obj) {
        return obj instanceof FilterRvModel;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public final void m33775i() {
        ActivityDataSource activityDataSource = this.f45415c;
        if (activityDataSource == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataSource");
            activityDataSource = null;
        }
        activityDataSource.update($$Lambda$TopicActivityPresenter$DXMtO8j3Ke0YaUsSoyoDqVWc12s.INSTANCE, $$Lambda$TopicActivityPresenter$uwiUsa5ZeDwRVxKmjIs9cQNjy14.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m33765b(int i, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "recyclerModel");
        if (obj instanceof FilterRvModel) {
            ((FilterRvModel) obj).setHasAnim(true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public final void m33776j() {
        ActivityDataSource activityDataSource = this.f45415c;
        ActivityDataSource activityDataSource2 = null;
        if (activityDataSource == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataSource");
            activityDataSource = null;
        }
        if (activityDataSource.getMReqType() != 3) {
            ((Contract.AbsTopicActivityView) getLogicView()).showLoadingView();
        }
        TopicActOmegaHelper.Companion.getInstance().reset();
        ActivityDataSource activityDataSource3 = this.f45415c;
        if (activityDataSource3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataSource");
        } else {
            activityDataSource2 = activityDataSource3;
        }
        activityDataSource2.loadInit();
    }

    /* renamed from: k */
    private final void m33777k() {
        ActivityDataSource activityDataSource = this.f45415c;
        if (activityDataSource == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataSource");
            activityDataSource = null;
        }
        activityDataSource.loadNextPage();
    }

    /* renamed from: l */
    private final void m33778l() {
        ActivityDataSource activityDataSource = this.f45415c;
        if (activityDataSource == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataSource");
            activityDataSource = null;
        }
        if (!activityDataSource.getHasMore()) {
            ((Contract.AbsTopicActivityView) getLogicView()).showFooterNoMoreView();
        } else {
            ((Contract.AbsTopicActivityView) getLogicView()).showFooterEmptyView();
        }
    }

    public void onFooterErrorClicked() {
        m33777k();
    }

    public void onFooterSignInClicked() {
        if (!LoginUtil.isLogin()) {
            TopicActivityPresenter$onFooterSignInClicked$listener$1 topicActivityPresenter$onFooterSignInClicked$listener$1 = new TopicActivityPresenter$onFooterSignInClicked$listener$1(this);
            LoginUtil.updateLoginPopToRootStatus(false);
            LoginUtil.loginActivityAndTrack(getContext(), 24, topicActivityPresenter$onFooterSignInClicked$listener$1);
        }
    }

    /* renamed from: a */
    private final RecordTracker.Builder m33745a(String str, String str2) {
        RecordTracker.Builder logCategory = RecordTracker.Builder.create().setTag("TopicActivityPresenter").setLogModule("m-home|").setMessage(str).setLogCategory(str2);
        Intrinsics.checkNotNullExpressionValue(logCategory, "create()\n               ….setLogCategory(category)");
        return logCategory;
    }

    public boolean onHandleBack() {
        ComposeActionEntity composeActionEntity;
        ActivityInfoEntity.NaviStructBean naviStructBean;
        List<ComposeActionEntity> list;
        Object obj;
        ActivityInfoEntity activityInfoEntity = this.f45420h;
        if (activityInfoEntity == null) {
            return false;
        }
        ActivityDataSource activityDataSource = null;
        if (activityInfoEntity == null || (naviStructBean = activityInfoEntity.navi) == null || (list = naviStructBean.interactions) == null) {
            composeActionEntity = null;
        } else {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((ComposeActionEntity) obj).getIdentifier(), (Object) "backBtn")) {
                    break;
                }
            }
            composeActionEntity = (ComposeActionEntity) obj;
        }
        TopicActivityPresenter$onHandleBack$lis$1 topicActivityPresenter$onHandleBack$lis$1 = new TopicActivityPresenter$onHandleBack$lis$1(this);
        if (composeActionEntity == null) {
            return false;
        }
        ComposeActionEntity.RetainInfo retainInfo = composeActionEntity.getRetainInfo();
        if ((retainInfo == null ? null : retainInfo.getActions()) == null) {
            ArrayList arrayList = new ArrayList();
            ActivityDataSource activityDataSource2 = this.f45415c;
            if (activityDataSource2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataSource");
            } else {
                activityDataSource = activityDataSource2;
            }
            String mRecId = activityDataSource.getMRecId();
            if (mRecId == null) {
                mRecId = "";
            }
            arrayList.add(Intrinsics.stringPlus("bsodacustomer://soda/track?name=sailing_c_x_operation_activity_quit_popup_sw&params=rec_id%3D", mRecId));
            ComposeActionEntity.RetainInfo retainInfo2 = composeActionEntity.getRetainInfo();
            if (retainInfo2 != null) {
                retainInfo2.setActions(arrayList);
            }
        }
        ComposeActionHelper composeActionHelper = ComposeActionHelper.INSTANCE;
        ScopeContext scopeContext = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
        composeActionHelper.doAction(scopeContext, composeActionEntity, topicActivityPresenter$onHandleBack$lis$1);
        return true;
    }
}
