package com.didi.soda.home.topgun.component.topicact.data;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.blocks.entity.Template;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity;
import com.didi.soda.customer.foundation.rpc.net.CRpcCallBackWithTraceId;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.storage.FeedBackStrategyStore;
import com.didi.soda.customer.foundation.storage.model.FeedBackStrategyConfig;
import com.didi.soda.customer.foundation.tracker.BlocksOmegaHelpter;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.datasource.listener.DataSourceListener;
import com.didi.soda.datasource.listener.PageEventListener;
import com.didi.soda.datasource.listener.PayloadProvider;
import com.didi.soda.datasource.page.PageController;
import com.didi.soda.datasource.page.PageStore;
import com.didi.soda.datasource.page.UpdateUtils;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.home.topgun.manager.HomeFeedParam;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 s2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001sB)\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\u0010\rJ\u0006\u0010Z\u001a\u00020@J\u001c\u0010[\u001a\u00020@2\b\u0010?\u001a\u0004\u0018\u00010>2\b\u0010J\u001a\u0004\u0018\u00010IH\u0002J \u0010\\\u001a\u00020@2\u0006\u0010]\u001a\u00020&2\u0006\u0010K\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\u0016\u0010^\u001a\u00020&2\u000e\u0010_\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010`J\u0018\u0010a\u001a\u00020@2\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020d\u0018\u00010cH\u0002J\u0012\u0010e\u001a\u00020\u000f2\b\u0010f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0006\u0010g\u001a\u00020\u000fJ\u0006\u0010h\u001a\u00020@J\u0010\u0010h\u001a\u00020@2\b\u0010i\u001a\u0004\u0018\u00010\u0002J\u0006\u0010j\u001a\u00020@J\u001a\u0010k\u001a\u00020@2\u0006\u0010l\u001a\u00020&2\b\u0010i\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u0010m\u001a\u00020@J\n\u0010n\u001a\u0004\u0018\u00010\u0004H\u0016J\u0016\u0010o\u001a\u00020@2\u000e\u0010_\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010`J&\u0010p\u001a\u00020@2\u000e\u0010_\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010`2\u000e\u0010q\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010rR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\u001a\u0010*\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u001c\u00102\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010!\"\u0004\b4\u0010#R\u000e\u00105\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u001c\u00106\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010!\"\u0004\b8\u0010#RT\u00109\u001a<\u0012\u0013\u0012\u00110&¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0015\u0012\u0013\u0018\u00010>¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020@\u0018\u00010:j\u0004\u0018\u0001`AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0001\u0010F\u001a\u0012\u0013\u0012\u00110&¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0015\u0012\u0013\u0018\u00010\u001f¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(H\u0012\u0015\u0012\u0013\u0018\u00010>¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(?\u0012\u0015\u0012\u0013\u0018\u00010I¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(J\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020@\u0018\u00010Gj\u0004\u0018\u0001`LX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001a\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0RX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0TX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010U\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006t"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/component/topicact/data/ActivityDataSource;", "Lcom/didi/soda/datasource/listener/PageEventListener;", "Lcom/didi/soda/home/topgun/manager/HomeFeedParam;", "Lcom/didi/soda/datasource/listener/PayloadProvider;", "Lcom/didi/soda/datasource/parser/FeedPayload;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "listener", "Lcom/didi/soda/datasource/listener/DataSourceListener;", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/ComponentEntity;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "(Lcom/didi/app/nova/skeleton/ScopeContext;Lcom/didi/soda/blocks/scope/IBlockScope;Lcom/didi/soda/datasource/listener/DataSourceListener;)V", "<set-?>", "", "hasMore", "getHasMore", "()Z", "homeFeedParam", "getHomeFeedParam", "()Lcom/didi/soda/home/topgun/manager/HomeFeedParam;", "setHomeFeedParam", "(Lcom/didi/soda/home/topgun/manager/HomeFeedParam;)V", "mActInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/ActInfoEntity;", "getMActInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/ActInfoEntity;", "setMActInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/ActInfoEntity;)V", "mActivityId", "", "getMActivityId", "()Ljava/lang/String;", "setMActivityId", "(Ljava/lang/String;)V", "mComponentId", "mPageIndex", "", "mRecId", "getMRecId", "setMRecId", "mReqType", "getMReqType", "()I", "setMReqType", "(I)V", "mRpcService", "Lcom/didi/soda/customer/foundation/rpc/CustomerRpcService;", "mScene", "mTabId", "getMTabId", "setMTabId", "mTitle", "mTraceId", "getMTraceId", "setMTraceId", "onPagePlayBackListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "Lcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity;", "entity", "", "Lcom/didi/soda/home/topgun/component/topicact/data/OnPagePlayBackListener;", "getOnPagePlayBackListener", "()Lkotlin/jvm/functions/Function2;", "setOnPagePlayBackListener", "(Lkotlin/jvm/functions/Function2;)V", "onPageResultListener", "Lkotlin/Function5;", "componentId", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "ex", "checkOnly", "Lcom/didi/soda/home/topgun/component/topicact/data/OnPageResultListener;", "getOnPageResultListener", "()Lkotlin/jvm/functions/Function5;", "setOnPageResultListener", "(Lkotlin/jvm/functions/Function5;)V", "pageController", "Lcom/didi/soda/datasource/page/PageController;", "pageStore", "Lcom/didi/soda/datasource/page/PageStore;", "resultEntity", "getResultEntity", "()Lcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity;", "setResultEntity", "(Lcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity;)V", "checkActivityEffective", "dealPageResult", "fetchActivityInfo", "pageIndex", "find", "diffCallback", "Lcom/didi/soda/datasource/page/UpdateUtils$DiffCallback;", "initTemplate", "templates", "Ljava/util/ArrayList;", "Lcom/didi/soda/blocks/entity/Template;", "isFrequentFeedBackCard", "item", "isNoResult", "loadInit", "params", "loadNextPage", "onPageLoad", "key", "playBackDataSource", "providePayload", "remove", "update", "updateCallback", "Lcom/didi/soda/datasource/page/UpdateUtils$UpdateCallback;", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ActivityDataSource.kt */
public final class ActivityDataSource implements PageEventListener<HomeFeedParam>, PayloadProvider<FeedPayload> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int pageCount = 20;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final ScopeContext f45448a;

    /* renamed from: b */
    private final PageStore<ComponentEntity, RecyclerModel> f45449b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final PageController<HomeFeedParam, ComponentEntity> f45450c;

    /* renamed from: d */
    private Function5<? super Integer, ? super String, ? super ActivityInfoEntity, ? super SFRpcException, ? super Boolean, Unit> f45451d;

    /* renamed from: e */
    private Function2<? super Integer, ? super ActivityInfoEntity, Unit> f45452e;

    /* renamed from: f */
    private String f45453f;

    /* renamed from: g */
    private final CustomerRpcService f45454g;

    /* renamed from: h */
    private int f45455h;

    /* renamed from: i */
    private String f45456i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public String f45457j;

    /* renamed from: k */
    private int f45458k;

    /* renamed from: l */
    private String f45459l;

    /* renamed from: m */
    private ActInfoEntity f45460m;

    /* renamed from: n */
    private String f45461n;

    /* renamed from: o */
    private String f45462o;

    /* renamed from: p */
    private int f45463p = 1;

    /* renamed from: q */
    private ActivityInfoEntity f45464q;

    /* renamed from: r */
    private boolean f45465r;

    /* renamed from: s */
    private HomeFeedParam f45466s;

    public ActivityDataSource(ScopeContext scopeContext, IBlockScope iBlockScope, DataSourceListener<ComponentEntity, RecyclerModel> dataSourceListener) {
        ActInfoEntity actInfoEntity;
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        Intrinsics.checkNotNullParameter(dataSourceListener, "listener");
        this.f45448a = scopeContext;
        this.f45449b = new PageStore<>(new ActivityDataMapFunction(this, iBlockScope), dataSourceListener);
        PageController<HomeFeedParam, ComponentEntity> pageController = new PageController<>();
        this.f45450c = pageController;
        boolean z = true;
        pageController.initialize(0, this, this.f45449b);
        CustomerRpcService customerRpcService = CustomerRpcManagerProxy.get();
        Intrinsics.checkNotNullExpressionValue(customerRpcService, "get()");
        this.f45454g = customerRpcService;
        String string = this.f45448a.getBundle().getString("scene", "0");
        Intrinsics.checkNotNullExpressionValue(string, "scopeContext.bundle.getS…eParams.TOPIC_SCENE, \"0\")");
        this.f45458k = Integer.parseInt(string);
        String string2 = this.f45448a.getBundle().getString("activityid");
        String str = "";
        this.f45456i = string2 == null ? str : string2;
        String string3 = this.f45448a.getBundle().getString(Const.PageParams.COMPONENT_ID);
        this.f45457j = string3 == null ? str : string3;
        String string4 = this.f45448a.getBundle().getString("recid");
        this.f45453f = string4 == null ? str : string4;
        String decodeUseByUri = CustomerExtentionKt.decodeUseByUri(this.f45448a.getBundle().getString(Const.PageParams.TOPIC_TITLE));
        this.f45459l = decodeUseByUri == null ? str : decodeUseByUri;
        String str2 = null;
        try {
            String string5 = this.f45448a.getBundle().getString(Const.PageParams.ACT_INFO);
            actInfoEntity = string5 == null ? null : (ActInfoEntity) GsonUtil.fromJson(string5, ActInfoEntity.class);
        } catch (Exception unused) {
            actInfoEntity = null;
        }
        this.f45460m = actInfoEntity;
        if (actInfoEntity == null) {
            this.f45460m = new ActInfoEntity();
        } else {
            this.f45448a.attach(BlocksConst.BLOCK_ACT_ID, actInfoEntity == null ? null : actInfoEntity.getActId());
            CharSequence charSequence = this.f45456i;
            if (!(charSequence == null || charSequence.length() == 0)) {
                z = false;
            }
            if (z) {
                ActInfoEntity actInfoEntity2 = this.f45460m;
                String actId = actInfoEntity2 == null ? null : actInfoEntity2.getActId();
                this.f45456i = actId == null ? str : actId;
            }
        }
        String string6 = this.f45448a.getBundle().getString(Const.PageParams.SCENE_EXTRA, "0");
        Intrinsics.checkNotNullExpressionValue(string6, "scopeContext.bundle.getS…eParams.SCENE_EXTRA, \"0\")");
        this.f45448a.attach("scene", Integer.valueOf(Integer.parseInt(string6) + this.f45458k));
        HomeFeedParam homeFeedParam = new HomeFeedParam();
        this.f45466s = homeFeedParam;
        ScopeContext scopeContext2 = this.f45448a;
        str2 = homeFeedParam != null ? homeFeedParam.getFilterParam() : str2;
        scopeContext2.attach("filter", str2 != null ? str2 : str);
        HomeFeedParam homeFeedParam2 = this.f45466s;
        if (homeFeedParam2 != null) {
            homeFeedParam2.reset();
        }
    }

    public final Function5<Integer, String, ActivityInfoEntity, SFRpcException, Boolean, Unit> getOnPageResultListener() {
        return this.f45451d;
    }

    public final void setOnPageResultListener(Function5<? super Integer, ? super String, ? super ActivityInfoEntity, ? super SFRpcException, ? super Boolean, Unit> function5) {
        this.f45451d = function5;
    }

    public final Function2<Integer, ActivityInfoEntity, Unit> getOnPagePlayBackListener() {
        return this.f45452e;
    }

    public final void setOnPagePlayBackListener(Function2<? super Integer, ? super ActivityInfoEntity, Unit> function2) {
        this.f45452e = function2;
    }

    public final String getMRecId() {
        return this.f45453f;
    }

    public final void setMRecId(String str) {
        this.f45453f = str;
    }

    public final String getMActivityId() {
        return this.f45456i;
    }

    public final void setMActivityId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f45456i = str;
    }

    public final ActInfoEntity getMActInfo() {
        return this.f45460m;
    }

    public final void setMActInfo(ActInfoEntity actInfoEntity) {
        this.f45460m = actInfoEntity;
    }

    public final String getMTabId() {
        return this.f45461n;
    }

    public final void setMTabId(String str) {
        this.f45461n = str;
    }

    public final String getMTraceId() {
        return this.f45462o;
    }

    public final void setMTraceId(String str) {
        this.f45462o = str;
    }

    public final int getMReqType() {
        return this.f45463p;
    }

    public final void setMReqType(int i) {
        this.f45463p = i;
    }

    public final ActivityInfoEntity getResultEntity() {
        return this.f45464q;
    }

    public final void setResultEntity(ActivityInfoEntity activityInfoEntity) {
        this.f45464q = activityInfoEntity;
    }

    public final boolean getHasMore() {
        return this.f45465r;
    }

    public final HomeFeedParam getHomeFeedParam() {
        return this.f45466s;
    }

    public final void setHomeFeedParam(HomeFeedParam homeFeedParam) {
        this.f45466s = homeFeedParam;
    }

    public final void loadInit() {
        Unit unit;
        HomeFeedParam homeFeedParam = this.f45466s;
        if (homeFeedParam == null) {
            unit = null;
        } else {
            this.f45450c.loadInit(homeFeedParam);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            this.f45450c.loadInit();
        }
    }

    public final void loadInit(HomeFeedParam homeFeedParam) {
        Unit unit;
        if (homeFeedParam == null) {
            unit = null;
        } else {
            this.f45450c.loadInit(homeFeedParam);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            this.f45450c.loadInit();
        }
    }

    public final void loadNextPage() {
        PageController<HomeFeedParam, ComponentEntity> pageController = this.f45450c;
        HomeFeedParam homeFeedParam = this.f45466s;
        if (homeFeedParam == null) {
            homeFeedParam = new HomeFeedParam();
        }
        pageController.loadNextPage(homeFeedParam);
    }

    public final void remove(UpdateUtils.DiffCallback<RecyclerModel> diffCallback) {
        this.f45449b.remove(diffCallback);
    }

    public final void update(UpdateUtils.DiffCallback<RecyclerModel> diffCallback, UpdateUtils.UpdateCallback<RecyclerModel> updateCallback) {
        this.f45449b.update(diffCallback, updateCallback);
    }

    public final void playBackDataSource() {
        if (this.f45464q != null) {
            this.f45448a.attach("recId", this.f45453f);
            this.f45448a.attach("traceId", this.f45462o);
            ScopeContext scopeContext = this.f45448a;
            String str = this.f45461n;
            String str2 = "";
            if (str == null) {
                str = str2;
            }
            scopeContext.attach(BlocksConst.BLOCK_TAB_ID, str);
            this.f45448a.attach("topic_id", this.f45457j);
            ScopeContext scopeContext2 = this.f45448a;
            HomeFeedParam homeFeedParam = this.f45466s;
            String filterParam = homeFeedParam == null ? null : homeFeedParam.getFilterParam();
            if (filterParam != null) {
                str2 = filterParam;
            }
            scopeContext2.attach("filter", str2);
            this.f45449b.provideStoredData();
            Function2<? super Integer, ? super ActivityInfoEntity, Unit> function2 = this.f45452e;
            if (function2 != null) {
                function2.invoke(Integer.valueOf(this.f45455h), this.f45464q);
            }
        }
    }

    public FeedPayload providePayload() {
        FeedPayload feedPayload = new FeedPayload();
        if (this.f45458k == 0) {
            feedPayload.mPageId = RoutePath.TOPIC_ACTIVITY_PAGE;
        } else {
            feedPayload.mPageId = "showAll";
        }
        feedPayload.mPageIndex = this.f45455h;
        feedPayload.mRecId = this.f45453f;
        feedPayload.mTraceId = this.f45462o;
        return feedPayload;
    }

    public void onPageLoad(int i, HomeFeedParam homeFeedParam) {
        this.f45455h = i;
        if (homeFeedParam == null) {
            homeFeedParam = new HomeFeedParam();
        }
        m33795a(i, false, homeFeedParam);
    }

    public final void checkActivityEffective() {
        int i = this.f45455h;
        HomeFeedParam homeFeedParam = this.f45466s;
        if (homeFeedParam == null) {
            homeFeedParam = new HomeFeedParam();
        }
        m33795a(i, true, homeFeedParam);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m33796a(ActivityInfoEntity activityInfoEntity, SFRpcException sFRpcException) {
        if (activityInfoEntity != null) {
            String str = activityInfoEntity.tabId;
            if (str != null) {
                setMTabId(str);
            }
            this.f45465r = activityInfoEntity.mHasMore && LoginUtil.isLogin();
        }
    }

    public final int find(UpdateUtils.DiffCallback<RecyclerModel> diffCallback) {
        return this.f45449b.find(diffCallback);
    }

    public final boolean isNoResult() {
        List<ComponentEntity> list;
        ActivityInfoEntity activityInfoEntity = this.f45464q;
        if (activityInfoEntity == null || (list = activityInfoEntity.mCompList) == null) {
            return false;
        }
        Iterator it = list.iterator();
        while (true) {
            boolean z = false;
            while (true) {
                if (!it.hasNext()) {
                    return z;
                }
                ComponentEntity componentEntity = (ComponentEntity) it.next();
                if ((componentEntity == null ? null : componentEntity.noResult) != null) {
                    z = true;
                }
            }
        }
    }

    /* renamed from: a */
    private final void m33795a(int i, boolean z, HomeFeedParam homeFeedParam) {
        int i2 = i;
        CRpcCallBackWithTraceId activityDataSource$fetchActivityInfo$callback$1 = new ActivityDataSource$fetchActivityInfo$callback$1(z, this, i);
        int i3 = this.f45458k;
        if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4) {
            this.f45454g.getBlocksTopicList(this.f45457j, i, 20, this.f45458k, this.f45453f, this.f45459l, this.f45460m, this.f45461n, this.f45463p, homeFeedParam.getFilterParam(), activityDataSource$fetchActivityInfo$callback$1);
            return;
        }
        this.f45454g.getActivityList(this.f45456i, i, 20, homeFeedParam.getFilterParam(), activityDataSource$fetchActivityInfo$callback$1);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final boolean m33798a(ComponentEntity componentEntity) {
        JsonObject jsonObject;
        JsonElement jsonElement;
        String str = null;
        if (!TextUtils.equals(componentEntity == null ? null : componentEntity.getType(), "1000")) {
            return false;
        }
        if (!(componentEntity == null || (jsonObject = componentEntity.data) == null || (jsonElement = jsonObject.get(BlocksConst.ACTION_PARAMS_SCENE_ID)) == null)) {
            str = jsonElement.getAsString();
        }
        if (str == null) {
            str = "";
        }
        FeedBackStrategyConfig data = ((FeedBackStrategyStore) SingletonFactory.get(FeedBackStrategyStore.class)).getData(Intrinsics.stringPlus("launchActivityPage_", str));
        if (data == null) {
            return false;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(data.getLastRemoveTime()));
        if (instance.get(6) - Calendar.getInstance().get(6) == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m33797a(ArrayList<Template> arrayList) {
        String str;
        Template template;
        JsonObject asJsonObject;
        JsonElement jsonElement;
        String asString;
        Collection collection = arrayList;
        if (!(collection == null || collection.isEmpty())) {
            ArrayList arrayList2 = new ArrayList();
            if (arrayList != null) {
                for (Template template2 : arrayList) {
                    String tmplId = template2 == null ? null : template2.getTmplId();
                    if (TextUtils.isEmpty(tmplId)) {
                        BlocksOmegaHelpter.INSTANCE.trackTemplateWithoutId(template2.toString());
                    } else {
                        if (template2 == null) {
                            str = null;
                        } else {
                            str = template2.getContent();
                        }
                        if (!TextUtils.isEmpty(str)) {
                            JsonElement parse = new JsonParser().parse(str);
                            String str2 = "1";
                            if (!(parse == null || (asJsonObject = parse.getAsJsonObject()) == null || (jsonElement = asJsonObject.get("version")) == null || (asString = jsonElement.getAsString()) == null)) {
                                str2 = asString;
                            }
                            if (Integer.parseInt(str2) > 1) {
                                try {
                                    template = (Template) new Gson().fromJson(str, Template.class);
                                } catch (Exception unused) {
                                    template = null;
                                }
                                if (template != null) {
                                    template.setTemplateId(tmplId);
                                }
                            } else {
                                Template template3 = new Template();
                                template3.setTmplId(tmplId);
                                template3.setContent(str);
                                template = template3;
                            }
                            arrayList2.add(template);
                        }
                    }
                }
            }
            BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).initTemplate(arrayList2);
        }
    }

    @Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/component/topicact/data/ActivityDataSource$Companion;", "", "()V", "pageCount", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: ActivityDataSource.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
