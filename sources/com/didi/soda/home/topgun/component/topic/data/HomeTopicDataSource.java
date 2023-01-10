package com.didi.soda.home.topgun.component.topic.data;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.rpc.AccountErrorConsumer;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeFeedEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.datasource.listener.DataSourceListener;
import com.didi.soda.datasource.listener.PageEventListener;
import com.didi.soda.datasource.listener.PayloadProvider;
import com.didi.soda.datasource.page.PageController;
import com.didi.soda.datasource.page.PageStore;
import com.didi.soda.datasource.page.UpdateUtils;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.home.topgun.manager.HomeFeedParam;
import java.util.ArrayList;
import java.util.List;

public class HomeTopicDataSource implements DataSourceListener<ComponentEntity, RecyclerModel>, PageEventListener, PayloadProvider<FeedPayload> {

    /* renamed from: a */
    private static final String f45388a = "HomeTopicDataSource";

    /* renamed from: b */
    private ScopeContext f45389b;

    /* renamed from: c */
    private String f45390c;

    /* renamed from: d */
    private PageStore<ComponentEntity, RecyclerModel> f45391d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public PageController<HomeFeedParam, ComponentEntity> f45392e;

    /* renamed from: f */
    private List<Action1> f45393f = new ArrayList();

    /* renamed from: g */
    private List<Action1> f45394g = new ArrayList();

    /* renamed from: h */
    private List<Action1> f45395h = new ArrayList();

    /* renamed from: i */
    private int f45396i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f45397j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public String f45398k;

    /* renamed from: l */
    private CustomerRpcService f45399l;

    /* renamed from: m */
    private AccountErrorConsumer f45400m;

    public HomeTopicDataSource(ScopeContext scopeContext, String str) {
        this.f45389b = scopeContext;
        this.f45390c = str;
        this.f45391d = new PageStore<>(new HomeTopicDataMapFunction(this), this);
        PageController<HomeFeedParam, ComponentEntity> pageController = new PageController<>();
        this.f45392e = pageController;
        pageController.initialize(0, this, this.f45391d);
        this.f45399l = CustomerRpcManagerProxy.get();
    }

    public void loadInit() {
        this.f45392e.loadInit();
    }

    public void loadNextPage() {
        this.f45392e.loadNextPage();
    }

    public void subscribePageResult(Action1<CustomerResource<HomeFeedEntity>> action1) {
        this.f45393f.add(action1);
    }

    public void subscribeListChanged(Action1<List<RecyclerModel>> action1) {
        this.f45394g.add(action1);
    }

    public void subscribeListUpdate(Action1<List<RecyclerModel>> action1) {
        this.f45395h.add(action1);
    }

    public void update(UpdateUtils.DiffCallback diffCallback, UpdateUtils.UpdateCallback updateCallback) {
        this.f45391d.update(diffCallback, updateCallback);
    }

    public void remove(UpdateUtils.DiffCallback diffCallback) {
        this.f45391d.remove(diffCallback);
    }

    public void insert(int i, RecyclerModel recyclerModel) {
        this.f45391d.insert(i, recyclerModel);
    }

    public int getPageIndex() {
        return this.f45396i;
    }

    public void onPageLoad(int i, Object obj) {
        this.f45396i = i;
        m33735a(this.f45389b, i, this.f45390c);
    }

    public void onPageResult(CustomerResource<HomeFeedEntity> customerResource) {
        for (Action1 call : this.f45393f) {
            call.call(customerResource);
        }
    }

    public void onDataSourceChanged(PageStore<ComponentEntity, RecyclerModel> pageStore, List<RecyclerModel> list) {
        for (Action1 call : this.f45394g) {
            call.call(list);
        }
    }

    public void onDataSourceUpdate(List<RecyclerModel> list) {
        for (Action1 call : this.f45395h) {
            call.call(list);
        }
    }

    public boolean contains(UpdateUtils.DiffCallback diffCallback) {
        return this.f45391d.contains(diffCallback);
    }

    public List getTargetList() {
        return this.f45391d.getTargetList();
    }

    public boolean hasMore() {
        return this.f45397j;
    }

    public FeedPayload providePayload() {
        FeedPayload feedPayload = new FeedPayload();
        feedPayload.mPageId = "showAll";
        feedPayload.mPageIndex = this.f45396i;
        feedPayload.mRecId = this.f45398k;
        return feedPayload;
    }

    /* renamed from: a */
    private void m33735a(ScopeContext scopeContext, final int i, String str) {
        if (this.f45400m == null) {
            this.f45400m = new AccountErrorConsumer(scopeContext);
        }
        this.f45399l.getHomeTopicFeedV2(i, str, new CustomerRpcCallback<HomeFeedEntity>() {
            public void onRpcSuccess(HomeFeedEntity homeFeedEntity, long j) {
                boolean unused = HomeTopicDataSource.this.f45397j = homeFeedEntity.mHasMore && LoginUtil.isLogin();
                String unused2 = HomeTopicDataSource.this.f45398k = homeFeedEntity.mRecId;
                HomeTopicDataSource.this.f45392e.receiveResult(homeFeedEntity.mComponentList, i);
                HomeTopicDataSource.this.onPageResult(CustomerResource.success(homeFeedEntity));
            }

            public void onRpcFailure(SFRpcException sFRpcException) {
                HomeTopicDataSource.this.onPageResult(CustomerResource.error(sFRpcException.getCode(), sFRpcException.getMessage()));
            }
        });
    }
}
