package com.didi.soda.business.component.dynamic.search;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.app.nova.skeleton.tools.Cancelable;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataItemManager;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.nova.assembly.serial.SerialTaskQueue;
import com.didi.soda.blocks.action.ActionResult;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.business.component.contract.dynamic.DynamicRecyclePresenter;
import com.didi.soda.business.component.home.PreviewImageModel;
import com.didi.soda.business.component.image.PreviewImageRepo;
import com.didi.soda.business.component.search.helper.BusinessSearchOmegaModel;
import com.didi.soda.business.component.search.helper.SearchMenuPageInfo;
import com.didi.soda.business.listener.BusinessSearchChangeListener;
import com.didi.soda.business.listener.GoodsItemClickListener;
import com.didi.soda.business.listener.RecommendWordListener;
import com.didi.soda.business.manager.BusinessDataHelper;
import com.didi.soda.business.manager.BusinessDyDataAssist;
import com.didi.soda.business.manager.BusinessOmegaHelper;
import com.didi.soda.business.manager.BusinessOmegaModel;
import com.didi.soda.business.manager.BusinessSearchMenuTask;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.cart.model.BusinessState;
import com.didi.soda.cart.model.CartInfoModel;
import com.didi.soda.cart.model.CartItemModel;
import com.didi.soda.cart.repo.BusinessStateRepo;
import com.didi.soda.cart.repo.CartItemStateRepo;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.binder.abnormal.topgun.TopGunAbnormalRvModel;
import com.didi.soda.customer.binder.model.CustomerDividerLineRvModel;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessSearchHotWordEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessSearchResultEntity;
import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.repo.model.ItemState;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalFactory;
import com.didi.soda.goodsV2.helper.GoodsDataHelper;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerCartManager;
import com.didi.soda.router.DiRouter;
import com.didichuxing.dfbasesdk.utils.StringUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function4;

public class BusinessDySearchPresent extends DynamicRecyclePresenter<BusinessDySearchView> implements GoodsItemClickListener, RecommendWordListener {

    /* renamed from: a */
    private static final String f42193a = "BusinessSearchPresent";

    /* renamed from: b */
    private String f42194b;

    /* renamed from: c */
    private BusinessInfoEntity f42195c;

    /* renamed from: d */
    private BusinessSearchOmegaModel f42196d = new BusinessSearchOmegaModel();

    /* renamed from: e */
    private BusinessOmegaModel f42197e;

    /* renamed from: f */
    private String f42198f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public BusinessOmegaHelper f42199g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f42200h = 1;

    /* renamed from: i */
    private TopGunAbnormalRvModel f42201i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public BusinessSearchResultEntity f42202j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public List<ComponentModel> f42203k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public List<BusinessGoodsItemRvModel> f42204l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ChildDataListManager<RecyclerModel> f42205m;

    /* renamed from: n */
    private ChildDataItemManager<RecyclerModel> f42206n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public SearchMenuPageInfo f42207o;

    /* renamed from: p */
    private SerialTaskQueue f42208p = new SerialTaskQueue();
    /* access modifiers changed from: private */

    /* renamed from: q */
    public Cancelable f42209q;

    /* renamed from: r */
    private Subscription f42210r;

    /* renamed from: s */
    private CartItemStateRepo f42211s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public BusinessSearchChangeListener f42212t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public boolean f42213u = false;

    /* renamed from: v */
    private String f42214v;

    /* renamed from: w */
    private CartInfoModel f42215w;

    public void onPageResult(Bundle bundle) {
    }

    public void setBusinessSearchChangeListener(BusinessSearchChangeListener businessSearchChangeListener) {
        this.f42212t = businessSearchChangeListener;
    }

    public void goBack(int i) {
        BusinessSearchChangeListener businessSearchChangeListener = this.f42212t;
        if (businessSearchChangeListener != null) {
            businessSearchChangeListener.hideRecommendWord();
        }
        m31727k().onSearchCloseClick(i, (getScopeContext() == null || getScopeContext().getObject("PageName") == null) ? "" : (String) getScopeContext().getObject("PageName"));
        Bundle bundle = new Bundle();
        bundle.putString("from", "businesssearch");
        getScopeContext().getNavigator().finish(bundle);
    }

    public void onCreate() {
        super.onCreate();
        m31688a();
        m31701b();
        m31729l();
    }

    public void onDestroy() {
        super.onDestroy();
        Cancelable cancelable = this.f42209q;
        if (cancelable != null) {
            cancelable.cancel();
        }
    }

    public void initDataManagers() {
        super.initDataManagers();
        if (this.f42205m == null) {
            ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager();
            this.f42205m = createChildDataListManager;
            addDataManager(createChildDataListManager);
        }
        if (this.f42206n == null) {
            ChildDataItemManager<RecyclerModel> createChildDataItemManager = createChildDataItemManager();
            this.f42206n = createChildDataItemManager;
            addDataManager(createChildDataItemManager);
        }
        TopGunAbnormalRvModel topGunAbnormalRvModel = new TopGunAbnormalRvModel();
        this.f42201i = topGunAbnormalRvModel;
        topGunAbnormalRvModel.mHeight = ((BusinessDySearchView) getLogicView()).calculateAbnormalHeight();
    }

    public void onRecommendWordSearch(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            ((BusinessDySearchView) getLogicView()).showShimmerView();
            this.f42207o.setSearchWord(str, 1, (String) null);
            ((BusinessDySearchView) getLogicView()).setRecommendSearchText(str);
            BusinessSearchChangeListener businessSearchChangeListener = this.f42212t;
            if (businessSearchChangeListener != null) {
                businessSearchChangeListener.hideRecommendWord();
            }
            onSearchWordRequest(0);
            m31727k().onSearchHotWordClick(str2, str);
        }
    }

    public void onSearchWordUpdate(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f42207o.setSearchWord(str, 0);
            onSearchWordRequest(1);
        }
    }

    public void onSearchWordClear() {
        this.f42205m.clear();
        this.f42208p.clear();
        Cancelable cancelable = this.f42209q;
        if (cancelable != null) {
            cancelable.cancel();
        }
        BusinessSearchChangeListener businessSearchChangeListener = this.f42212t;
        if (businessSearchChangeListener != null) {
            businessSearchChangeListener.showRecommendWord();
            m31727k().onSearchHotWordShow(this.f42196d);
        }
        ((BusinessDySearchView) getLogicView()).hideShimmerView();
        ((BusinessDySearchView) getLogicView()).hideSearchLoading();
        ((BusinessDySearchView) getLogicView()).hideLoading();
        this.f42207o.clearSearchWord();
    }

    public void onSearchWordRequest(int i) {
        if (i == 1) {
            ((BusinessDySearchView) getLogicView()).showSearchLoading();
        } else if (i == 2) {
            ((BusinessDySearchView) getLogicView()).showLoading();
        }
        m31717f();
    }

    public void onGoodsItemExposure(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        m31727k().onSearchItemExposure(businessGoodsItemRvModel, this.f42207o.mRecId, this.f42207o.mTraceCnt, businessGoodsItemRvModel.mAdditionalType, businessGoodsItemRvModel.mCateIndex, businessGoodsItemRvModel.hasMultipleContents ? 1 : 0);
    }

    public void onGoodsItemClick(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        String str;
        String str2;
        BusinessGoodsItemRvModel businessGoodsItemRvModel2 = businessGoodsItemRvModel;
        KeyboardUtils.hideSoftInput(getContext(), (View) null);
        m31692a(businessGoodsItemRvModel2, false);
        m31685a("onGoodsItemClick", "c-act|").setOtherParam("cate_id", businessGoodsItemRvModel2.mCateId).setOtherParam("goods_id", businessGoodsItemRvModel2.mGoodsId).build().info();
        boolean isNeedReloadSubitem = BusinessDataHelper.isNeedReloadSubitem(this.f42195c);
        if (BusinessDataHelper.isNeedReloadSubitem(this.f42195c) || BusinessDataHelper.isNeedReloadSubitem(businessGoodsItemRvModel)) {
            m31695a(EventConst.Business.SHOP_GOODS_ITEM_CK, businessGoodsItemRvModel2, isNeedReloadSubitem ? 1 : 0, 0);
            if (TextUtils.isEmpty(businessGoodsItemRvModel2.mBusinessId) && (str = this.f42194b) != null) {
                businessGoodsItemRvModel2.mBusinessId = str;
            }
            BusinessDataHelper.toGoodsItemDetail(getScopeContext(), businessGoodsItemRvModel, m31706b(businessGoodsItemRvModel2.mNeedAlcoholRemind), this.f42198f, 2, this.f42214v, new int[0]);
            return;
        }
        GoodsItemEntity findGoodDyEntitySearch = BusinessDataHelper.findGoodDyEntitySearch(this.f42202j, this.f42205m.indexOf(businessGoodsItemRvModel2), businessGoodsItemRvModel2.mGoodsId, businessGoodsItemRvModel2.mItemUniqKey);
        m31695a(EventConst.Business.SHOP_GOODS_ITEM_CK, businessGoodsItemRvModel2, (int) isNeedReloadSubitem, GoodsDataHelper.hasMultipleContents(findGoodDyEntitySearch) ? 1 : 0);
        if (findGoodDyEntitySearch != null) {
            if (TextUtils.isEmpty(findGoodDyEntitySearch.shopId) && (str2 = this.f42194b) != null) {
                findGoodDyEntitySearch.shopId = str2;
            }
            BusinessDataHelper.toGoodItemDetail(getScopeContext(), findGoodDyEntitySearch, businessGoodsItemRvModel2.mInCategoryIndex, m31706b(businessGoodsItemRvModel2.mNeedAlcoholRemind), this.f42198f, 2, this.f42214v, businessGoodsItemRvModel2.mCateId, new int[0]);
        }
    }

    public void onGoodsImageClick(View view, BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        KeyboardUtils.hideSoftInput(getContext(), (View) null);
        m31695a(EventConst.Business.SHOP_ITEM_PHOTO_CK, businessGoodsItemRvModel, BusinessDataHelper.isNeedReloadSubitem(this.f42195c) ? 1 : 0, GoodsDataHelper.hasMultipleContents(BusinessDataHelper.findGoodEntitySearch(this.f42202j, this.f42205m.indexOf(businessGoodsItemRvModel), businessGoodsItemRvModel.mGoodsId, businessGoodsItemRvModel.mItemUniqKey)) ? 1 : 0);
        String valueOf = String.valueOf(System.currentTimeMillis());
        String string = view.getContext().getString(R.string.customer_transition_tag_business_preview_image_named, new Object[]{valueOf});
        ViewCompat.setTransitionName(view, string);
        DiRouter.request().path(RoutePath.BUSINESS_PREVIEW_IMAGE).putString(Const.PageParams.TRANSITION_NAMES, string).putSerializable(Const.PageParams.PREVIEW_IMAGE, PreviewImageModel.copyFrom(businessGoodsItemRvModel, view, 0, this.f42207o.mRecId, this.f42207o.mTraceCnt)).open();
    }

    public void onGoodsAddClick(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        KeyboardUtils.hideSoftInput(getContext(), (View) null);
        m31692a(businessGoodsItemRvModel, false);
        m31685a("onGoodsAddClick", "c-act|").setOtherParam("cate_id", businessGoodsItemRvModel.mCateId).setOtherParam("goods_id", businessGoodsItemRvModel.mGoodsId).build().info();
        m31705b(businessGoodsItemRvModel, false);
    }

    public void onGoodsMinusClick(BusinessGoodsItemRvModel businessGoodsItemRvModel, String str, String str2) {
        m31685a("onGoodsAddClick", "c-act|").setOtherParam("cate_id", businessGoodsItemRvModel.mCateId).setOtherParam("goods_id", businessGoodsItemRvModel.mGoodsId).build().info();
        m31691a(businessGoodsItemRvModel, str, str2, false);
    }

    /* renamed from: a */
    private void m31688a() {
        Bundle bundle = getScopeContext().getBundle();
        String string = bundle.getString(Const.PageParams.SHOP_ID);
        this.f42194b = string;
        bundle.putString("current_shop_id", string);
        this.f42195c = (BusinessInfoEntity) bundle.getSerializable(Const.PageParams.SHOP_INFO_ENTITY);
        this.f42198f = getScopeContext().getBundle().getString(Const.PageParams.BIDATA, "");
        BusinessInfoEntity businessInfoEntity = this.f42195c;
        if (businessInfoEntity != null) {
            this.f42200h = businessInfoEntity.cShopStatus;
        }
        BusinessInfoEntity businessInfoEntity2 = this.f42195c;
        if (businessInfoEntity2 == null || TextUtils.isEmpty(businessInfoEntity2.cartRevision)) {
            this.f42214v = "0";
        } else {
            this.f42214v = this.f42195c.cartRevision;
        }
        BusinessDataHelper.addBlockScopeParam(this.f42195c, getScope());
        if (this.f42194b != null) {
            getScope().attach("shopId", this.f42194b);
        }
        LogUtil.m32584d(f42193a, "initParams status: " + this.f42200h);
        this.f42207o = new SearchMenuPageInfo(this.f42194b);
    }

    /* renamed from: b */
    private void m31701b() {
        this.f42211s = (CartItemStateRepo) RepoFactory.getRepo(CartItemStateRepo.class);
        ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).subscribe(this.f42194b, getScopeContext(), new Action1<BusinessState>() {
            public void call(BusinessState businessState) {
                if (businessState != null) {
                    BusinessDataHelper.addBlockScopeParam(businessState, BusinessDySearchPresent.this.getScope());
                }
                boolean z = (businessState == null || BusinessDySearchPresent.this.f42200h == businessState.shopStatus) ? false : true;
                int unused = BusinessDySearchPresent.this.f42200h = businessState.shopStatus;
                if (businessState != null) {
                    boolean unused2 = BusinessDySearchPresent.this.f42213u = businessState.mHasShowedWineRemind;
                }
                LogUtil.m32584d(BusinessDySearchPresent.f42193a, "mBusinessStateRepo status: " + BusinessDySearchPresent.this.f42200h);
                if (z) {
                    BusinessDySearchPresent.this.m31715e();
                }
            }
        });
        ((PreviewImageRepo) RepoFactory.getRepo(PreviewImageRepo.class)).subscribe(getScopeContext(), new Action1<PreviewImageModel>() {
            public void call(PreviewImageModel previewImageModel) {
                BusinessGoodsItemRvModel findGoodsItemRvModel = BusinessDataHelper.findGoodsItemRvModel(BusinessDySearchPresent.this.f42204l, previewImageModel.mGoodId, previewImageModel.mCateId);
                if (findGoodsItemRvModel != null) {
                    BusinessDySearchPresent.this.m31685a("onImageAddClick", "c-act|").setOtherParam("cate_id", findGoodsItemRvModel.mCateId).setOtherParam("goods_id", findGoodsItemRvModel.mGoodsId).build().info();
                    BusinessDySearchPresent.this.m31705b(findGoodsItemRvModel, true);
                }
            }
        });
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).subscribe(getScopeContext(), this.f42194b, (Action1<CustomerResource<CartInfoEntity>>) new Action1() {
            public final void call(Object obj) {
                BusinessDySearchPresent.this.m31693a((CustomerResource) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m31693a(CustomerResource customerResource) {
        if (customerResource != null && customerResource.data != null) {
            this.f42215w = new CartInfoModel().convertModel((CartInfoEntity) customerResource.data, this.f42200h);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m31709c() {
        Subscription subscription;
        if (this.f42202j != null && (subscription = this.f42210r) != null) {
            subscription.unsubscribe();
        }
    }

    /* renamed from: d */
    private void m31712d() {
        int i = 0;
        for (ComponentModel next : this.f42203k) {
            if (next.getDataModel() instanceof BusinessGoodsItemRvModel) {
                ((BusinessGoodsItemRvModel) next.getDataModel()).mGoodsAmountModel.clearAmount();
            }
            this.f42205m.set(i, next);
            i++;
        }
    }

    /* renamed from: a */
    private void m31696a(Map<String, ItemState> map) {
        int i = 0;
        for (ComponentModel next : this.f42203k) {
            if (next.getDataModel() instanceof BusinessGoodsItemRvModel) {
                BusinessGoodsItemRvModel businessGoodsItemRvModel = (BusinessGoodsItemRvModel) next.getDataModel();
                if (!map.containsKey(businessGoodsItemRvModel.mGoodsId) || map.get(businessGoodsItemRvModel.mGoodsId) == null) {
                    businessGoodsItemRvModel.mGoodsAmountModel.clearAmount();
                } else {
                    businessGoodsItemRvModel.mGoodsAmountModel.updateGoodsItemAmountModel(map.get(businessGoodsItemRvModel.mItemUniqKey));
                    LogUtil.m32584d(f42193a, "updateGoodsAmount index: " + i);
                }
                next.setDataModel(businessGoodsItemRvModel);
            }
            this.f42205m.set(i, next);
            i++;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m31715e() {
        if (!CollectionsUtil.isEmpty(this.f42203k)) {
            for (ComponentModel next : this.f42203k) {
                if (next.getDataModel() instanceof BusinessGoodsItemRvModel) {
                    BusinessGoodsItemRvModel businessGoodsItemRvModel = (BusinessGoodsItemRvModel) next.getDataModel();
                    businessGoodsItemRvModel.mGoodsAmountModel.mGoodsItemState = GoodsDataHelper.getGoodsItemState(businessGoodsItemRvModel.mStatus, businessGoodsItemRvModel.mSoldStatus, this.f42200h);
                    next.setDataModel(businessGoodsItemRvModel);
                }
            }
            this.f42205m.clear();
            this.f42205m.addAll(this.f42203k);
            LogUtil.m32584d(f42193a, "updateGoodsStatus size: " + this.f42203k.size());
        }
    }

    /* renamed from: f */
    private void m31717f() {
        this.f42209q = this.f42208p.append(new BusinessSearchMenuTask(new CustomerRpcCallback<BusinessSearchResultEntity>() {
            public void onRpcFailure(SFRpcException sFRpcException) {
                super.onRpcFailure(sFRpcException);
                ((BusinessDySearchView) BusinessDySearchPresent.this.getLogicView()).hideSearchLoading();
                ((BusinessDySearchView) BusinessDySearchPresent.this.getLogicView()).hideLoading();
                ((BusinessDySearchView) BusinessDySearchPresent.this.getLogicView()).hideShimmerView();
                BusinessSearchResultEntity unused = BusinessDySearchPresent.this.f42202j = null;
                List unused2 = BusinessDySearchPresent.this.f42203k = null;
                BusinessDySearchPresent.this.m31694a(sFRpcException.getMessage());
                BusinessDySearchPresent.this.m31723i();
                Cancelable unused3 = BusinessDySearchPresent.this.f42209q = null;
            }

            public void onRpcSuccess(BusinessSearchResultEntity businessSearchResultEntity, long j) {
                BusinessDySearchPresent.this.f42199g.reset();
                ((BusinessDySearchView) BusinessDySearchPresent.this.getLogicView()).hideSearchLoading();
                ((BusinessDySearchView) BusinessDySearchPresent.this.getLogicView()).hideLoading();
                ((BusinessDySearchView) BusinessDySearchPresent.this.getLogicView()).hideShimmerView();
                BusinessSearchResultEntity unused = BusinessDySearchPresent.this.f42202j = businessSearchResultEntity;
                if (BusinessDySearchPresent.this.f42212t != null) {
                    BusinessDySearchPresent.this.f42212t.hideRecommendWord();
                }
                if (businessSearchResultEntity == null) {
                    BusinessDySearchPresent.this.m31718g();
                } else if (CollectionsUtil.isEmpty(businessSearchResultEntity.mTemplates)) {
                    BusinessDySearchPresent.this.m31718g();
                } else {
                    BusinessDyDataAssist.initTemplate(businessSearchResultEntity.mTemplates);
                    List unused2 = BusinessDySearchPresent.this.f42204l = new ArrayList();
                    try {
                        List unused3 = BusinessDySearchPresent.this.f42203k = BusinessDataHelper.parseDyBusinessSearchEntity(businessSearchResultEntity, BusinessDySearchPresent.this.f42204l, BusinessDySearchPresent.this.f42200h, BusinessDySearchPresent.this.getScope());
                        if (CollectionsUtil.isEmpty(BusinessDySearchPresent.this.f42203k)) {
                            BusinessDySearchPresent.this.m31718g();
                        } else {
                            for (ComponentModel componentModel : BusinessDySearchPresent.this.f42203k) {
                                if (!(componentModel == null || componentModel.getDataModel() == null || !(componentModel.getDataModel() instanceof BusinessGoodsItemRvModel))) {
                                    BusinessDySearchPresent.this.f42204l.add((BusinessGoodsItemRvModel) componentModel.getDataModel());
                                }
                            }
                            BusinessDySearchPresent.this.f42205m.clear();
                            BusinessDySearchPresent.this.f42205m.addAll(BusinessDySearchPresent.this.f42203k);
                            LogUtil.m32584d(BusinessDySearchPresent.f42193a, "data:" + BusinessDySearchPresent.this.f42203k.size());
                            BusinessDySearchPresent.this.m31709c();
                            BusinessDySearchPresent.this.m31697a(true);
                        }
                        BusinessDySearchPresent.this.m31723i();
                        if (businessSearchResultEntity != null) {
                            BusinessDySearchPresent.this.f42207o.autoAddTraceCnt(businessSearchResultEntity.recId);
                        } else {
                            BusinessDySearchPresent.this.f42207o.autoAddTraceCnt();
                        }
                        BusinessDySearchPresent.this.m31727k().onSearchItemSw(BusinessDySearchPresent.this.f42207o.mRecId, BusinessDySearchPresent.this.f42207o.mTraceCnt);
                        Cancelable unused4 = BusinessDySearchPresent.this.f42209q = null;
                    } catch (Exception e) {
                        BusinessDySearchPresent.this.m31685a("parseDyBusinessSearchEntity error", "c-data|").setMessage(e.getMessage()).build().error();
                        BusinessDySearchPresent.this.m31718g();
                    }
                }
            }
        }, this.f42207o), SerialTaskQueue.AppendMode.ReplaceStrict);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m31718g() {
        this.f42205m.clear();
        this.f42201i.setAbnormalVm(TopGunAbnormalFactory.buildShopNoResultService());
        this.f42205m.add(this.f42201i);
        m31721h();
        m31727k().onSearchNoResultSw(this.f42207o.mRecId, this.f42207o.mKeyWord);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31694a(String str) {
        if (NetWorkUtils.isNetworkConnected(getContext())) {
            this.f42205m.clear();
            this.f42201i.setAbnormalVm(TopGunAbnormalFactory.buildHomeNoService(str, new View.OnClickListener() {
                public final void onClick(View view) {
                    BusinessDySearchPresent.this.m31710c(view);
                }
            }));
            this.f42205m.add(this.f42201i);
            m31721h();
        } else if (this.f42205m.size() == 0 || this.f42205m.indexOf(this.f42201i) >= 0) {
            this.f42205m.clear();
            this.f42201i.setAbnormalVm(TopGunAbnormalFactory.buildNoNetwork(new View.OnClickListener() {
                public final void onClick(View view) {
                    BusinessDySearchPresent.this.m31702b(view);
                }
            }));
            this.f42205m.add(this.f42201i);
            m31721h();
        } else {
            ((BusinessDySearchView) getLogicView()).showNetErrorToast();
        }
        BusinessSearchChangeListener businessSearchChangeListener = this.f42212t;
        if (businessSearchChangeListener != null) {
            businessSearchChangeListener.hideRecommendWord();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m31710c(View view) {
        this.f42205m.clear();
        onSearchWordRequest(2);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m31702b(View view) {
        this.f42205m.clear();
        onSearchWordRequest(2);
    }

    /* renamed from: h */
    private void m31721h() {
        m31697a(false);
        KeyboardUtils.hideSoftInput(getContext(), (View) null);
        ((BusinessDySearchView) getLogicView()).hideSearchFocus();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m31723i() {
        if (this.f42205m.size() > 2) {
            this.f42206n.setItem(m31724j());
            LogUtil.m32584d(f42193a, "updateBottomDivider: add");
        } else {
            this.f42206n.removeItem();
            LogUtil.m32584d(f42193a, "updateBottomDivider: remove");
        }
        ((BusinessDySearchView) getLogicView()).scrollToTop();
    }

    /* renamed from: j */
    private CustomerDividerLineRvModel m31724j() {
        return new CustomerDividerLineRvModel(DisplayUtils.dip2px(getContext(), 110.0f), 0, 0, getContext().getResources().getColor(R.color.rf_color_gery_7_97_F5F5F7));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31697a(boolean z) {
        BusinessSearchChangeListener businessSearchChangeListener = this.f42212t;
        if (businessSearchChangeListener == null) {
            return;
        }
        if (z) {
            businessSearchChangeListener.showFloatingCart();
        } else {
            businessSearchChangeListener.hideFloatingCart();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public BusinessOmegaHelper m31727k() {
        if (this.f42199g == null) {
            this.f42199g = new BusinessOmegaHelper(getScopeContext(), this.f42194b, this.f42200h);
        }
        return this.f42199g;
    }

    /* renamed from: l */
    private void m31729l() {
        this.f42197e = BusinessOmegaModel.newInstance(this.f42195c);
        BusinessInfoEntity businessInfoEntity = this.f42195c;
        if (businessInfoEntity != null) {
            BusinessSearchHotWordEntity businessSearchHotWordEntity = businessInfoEntity.recItemSearchWords;
            if (businessSearchHotWordEntity != null) {
                this.f42196d.mHotWordList = businessSearchHotWordEntity.recWords;
                this.f42196d.mHotWordRecId = businessSearchHotWordEntity.recId;
            }
            m31727k().onSearchShow(this.f42196d);
            m31727k().onSearchHotWordShow(this.f42196d);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = r0.f42195c;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m31706b(boolean r1) {
        /*
            r0 = this;
            if (r1 == 0) goto L_0x0010
            com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity r1 = r0.f42195c
            if (r1 == 0) goto L_0x0010
            int r1 = r1.wineConfirm
            if (r1 != 0) goto L_0x0010
            boolean r1 = r0.f42213u
            if (r1 != 0) goto L_0x0010
            r1 = 1
            goto L_0x0011
        L_0x0010:
            r1 = 0
        L_0x0011:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.business.component.dynamic.search.BusinessDySearchPresent.m31706b(boolean):boolean");
    }

    /* renamed from: a */
    private void m31692a(BusinessGoodsItemRvModel businessGoodsItemRvModel, boolean z) {
        if (businessGoodsItemRvModel != null) {
            OmegaCommonParamHelper.setLv3Body(StringUtils.SP_DATA_ITEM + businessGoodsItemRvModel.mGoodsId);
            OmegaCommonParamHelper.setLv3Location(ParamConst.PARAM_SHOP_SEARCH + "_" + businessGoodsItemRvModel.mCateId + "_" + 0 + "_" + 0 + "_" + 0 + "_" + businessGoodsItemRvModel.mInCategoryIndex + "_" + 0 + "_" + (z ? 1 : 0));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public RecordTracker.Builder m31685a(String str, String str2) {
        return RecordTracker.Builder.create().setTag(f42193a).setLogModule("m-business|").setMessage(str).setLogCategory(str2).setOtherParam("business_id", this.f42194b).setOtherParam("business_status", Integer.valueOf(this.f42200h));
    }

    /* renamed from: a */
    private void m31695a(String str, BusinessGoodsItemRvModel businessGoodsItemRvModel, int i, int i2) {
        m31727k().onSearchGoodsItemClick(str, businessGoodsItemRvModel, i, i2, this.f42197e, this.f42207o.mRecId, this.f42207o.mTraceCnt);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m31705b(BusinessGoodsItemRvModel businessGoodsItemRvModel, boolean z) {
        String str;
        m31692a(businessGoodsItemRvModel, z);
        boolean isNeedReloadSubitem = BusinessDataHelper.isNeedReloadSubitem(this.f42195c);
        int i = z ? 6 : 2;
        if (BusinessDataHelper.isNeedReloadSubitem(this.f42195c) || BusinessDataHelper.isNeedReloadSubitem(businessGoodsItemRvModel)) {
            m31695a(EventConst.Business.SHOP_GOODS_ITEM_ADD_CK, businessGoodsItemRvModel, isNeedReloadSubitem ? 1 : 0, 0);
            if (TextUtils.isEmpty(businessGoodsItemRvModel.mBusinessId) && (str = this.f42194b) != null) {
                businessGoodsItemRvModel.mBusinessId = str;
            }
            BusinessDataHelper.toGoodsItemDetail(getScopeContext(), businessGoodsItemRvModel, m31706b(businessGoodsItemRvModel.mNeedAlcoholRemind), this.f42198f, i, this.f42214v, new int[0]);
            return;
        }
        GoodsItemEntity findGoodDyEntitySearch = BusinessDataHelper.findGoodDyEntitySearch(this.f42202j, this.f42205m.indexOf(businessGoodsItemRvModel), businessGoodsItemRvModel.mGoodsId, businessGoodsItemRvModel.mItemUniqKey);
        m31695a(EventConst.Business.SHOP_GOODS_ITEM_ADD_CK, businessGoodsItemRvModel, (int) isNeedReloadSubitem, GoodsDataHelper.hasMultipleContents(findGoodDyEntitySearch) ? 1 : 0);
        if (findGoodDyEntitySearch != null) {
            BusinessDataHelper.dispatchAddAction(getScopeContext(), findGoodDyEntitySearch, businessGoodsItemRvModel, this.f42198f, i, this.f42214v, m31706b(businessGoodsItemRvModel.mNeedAlcoholRemind), m31727k(), (CartItemModel) null);
        }
    }

    /* renamed from: a */
    private void m31691a(BusinessGoodsItemRvModel businessGoodsItemRvModel, String str, String str2, boolean z) {
        String str3;
        m31692a(businessGoodsItemRvModel, z);
        if (!m31730m()) {
            boolean isNeedReloadSubitem = BusinessDataHelper.isNeedReloadSubitem(this.f42195c);
            int i = z ? 6 : 2;
            if (BusinessDataHelper.isNeedReloadSubitem(this.f42195c) || BusinessDataHelper.isNeedReloadSubitem(businessGoodsItemRvModel)) {
                m31695a(EventConst.Business.SHOP_GOODS_ITEM_ADD_CK, businessGoodsItemRvModel, isNeedReloadSubitem ? 1 : 0, 0);
                if (TextUtils.isEmpty(businessGoodsItemRvModel.mBusinessId) && (str3 = this.f42194b) != null) {
                    businessGoodsItemRvModel.mBusinessId = str3;
                }
                BusinessDataHelper.toGoodsItemDetail(getScopeContext(), businessGoodsItemRvModel, m31706b(businessGoodsItemRvModel.mNeedAlcoholRemind), this.f42198f, i, this.f42214v, new int[0]);
                return;
            }
            GoodsItemEntity findGoodEntitySearch = BusinessDataHelper.findGoodEntitySearch(this.f42202j, this.f42205m.indexOf(businessGoodsItemRvModel), businessGoodsItemRvModel.mGoodsId, businessGoodsItemRvModel.mItemUniqKey);
            m31695a(EventConst.Business.SHOP_GOODS_ITEM_ADD_CK, businessGoodsItemRvModel, (int) isNeedReloadSubitem, GoodsDataHelper.hasMultipleContents(findGoodEntitySearch) ? 1 : 0);
            if (findGoodEntitySearch != null) {
                BusinessDataHelper.dispatchMinusAction(getScopeContext(), findGoodEntitySearch, businessGoodsItemRvModel, this.f42198f, i, this.f42214v, m31706b(businessGoodsItemRvModel.mNeedAlcoholRemind), m31727k(), str, str2);
            }
        }
    }

    /* renamed from: m */
    private boolean m31730m() {
        if (this.f42195c != null) {
            return false;
        }
        m31685a("businessEntityIsNull", "c-data|").build().info();
        return true;
    }

    /* access modifiers changed from: protected */
    public void registerScopeActions(IBlockScope iBlockScope) {
        super.registerScopeActions(iBlockScope);
        iBlockScope.registerAction(BlocksConst.SCOPE_ACTION_ON_GOOD_ADD, new Function4() {
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BusinessDySearchPresent.this.m31711d((Context) obj, (IBlockScope) obj2, (HashMap) obj3, (Buildable) obj4);
            }
        });
        iBlockScope.registerAction(BlocksConst.SCOPE_ACTION_ON_GOOD_MINUS, new Function4() {
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BusinessDySearchPresent.this.m31707c((Context) obj, (IBlockScope) obj2, (HashMap) obj3, (Buildable) obj4);
            }
        });
        iBlockScope.registerAction(BlocksConst.SCOPE_ACTION_GOOD_ITEM_CLICK, new Function4() {
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BusinessDySearchPresent.this.m31699b((Context) obj, (IBlockScope) obj2, (HashMap) obj3, (Buildable) obj4);
            }
        });
        iBlockScope.registerAction(BlocksConst.SCOPE_ACTION_GOOD_ITEM_EXPOSURE, new Function4() {
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BusinessDySearchPresent.this.m31683a((Context) obj, (IBlockScope) obj2, (HashMap) obj3, (Buildable) obj4);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ ActionResult m31711d(Context context, IBlockScope iBlockScope, HashMap hashMap, Buildable buildable) {
        BusinessGoodsItemRvModel goodRvModelFromParam = BusinessDataHelper.getGoodRvModelFromParam(hashMap, buildable);
        if (goodRvModelFromParam != null) {
            ItemState mainGoodState = this.f42211s.getMainGoodState(this.f42194b, goodRvModelFromParam.mItemUniqKey);
            if (mainGoodState != null) {
                mainGoodState.amount++;
            }
            goodRvModelFromParam.mGoodsAmountModel.updateGoodsItemAmountModel(mainGoodState);
            Buildable findWidgetByComponentId = buildable.findWidgetByComponentId(BlocksConst.COMPONENT_ID_BUSINESS_DISH_IMAGE, 1);
            if (!(findWidgetByComponentId == null || findWidgetByComponentId.getView() == null)) {
                ((BusinessDySearchView) getLogicView()).setCurrentVirView(findWidgetByComponentId.getView(), goodRvModelFromParam.mHeadImg);
                if (!goodRvModelFromParam.hasMultipleContents && goodRvModelFromParam.mHasWine != 1 && !BusinessDataHelper.isNeedReloadSubitem(goodRvModelFromParam) && !BusinessDataHelper.isNeedReloadSubitem(this.f42195c)) {
                    ((BusinessDySearchView) getLogicView()).playAdd2CartAnim();
                }
            }
            onGoodsAddClick(goodRvModelFromParam);
        }
        return ActionResult.resolve();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ ActionResult m31707c(Context context, IBlockScope iBlockScope, HashMap hashMap, Buildable buildable) {
        String str;
        BusinessGoodsItemRvModel goodRvModelFromParam = BusinessDataHelper.getGoodRvModelFromParam(hashMap, buildable);
        CartInfoModel cartInfoModel = this.f42215w;
        if (cartInfoModel == null) {
            return ActionResult.resolve();
        }
        String cartId = cartInfoModel.getCartId();
        if (goodRvModelFromParam != null) {
            ItemState mainGoodState = this.f42211s.getMainGoodState(this.f42194b, goodRvModelFromParam.mItemUniqKey);
            if (mainGoodState != null) {
                mainGoodState.amount--;
                LogUtil.m32584d("dispatchAddAction", "SCOPE_ACTION_ON_GOOD_MINUS amount : " + mainGoodState.amount);
                if (TextUtils.isEmpty(mainGoodState.mduId)) {
                    return ActionResult.resolve();
                }
                str = mainGoodState.mduId;
            } else {
                str = "";
            }
            goodRvModelFromParam.mGoodsAmountModel.updateGoodsItemAmountModel(mainGoodState);
            onGoodsMinusClick(goodRvModelFromParam, str, cartId);
        }
        return ActionResult.resolve();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ ActionResult m31699b(Context context, IBlockScope iBlockScope, HashMap hashMap, Buildable buildable) {
        BusinessGoodsItemRvModel goodRvModelFromParam = BusinessDataHelper.getGoodRvModelFromParam(hashMap, buildable);
        if (goodRvModelFromParam == null) {
            return ActionResult.reject();
        }
        Buildable findWidgetByComponentId = buildable.findWidgetByComponentId(BlocksConst.COMPONENT_ID_BUSINESS_DISH_IMAGE, 1);
        if (!(findWidgetByComponentId == null || findWidgetByComponentId.getView() == null)) {
            ((BusinessDySearchView) getLogicView()).setCurrentVirView(findWidgetByComponentId.getView(), goodRvModelFromParam.mHeadImg);
        }
        onGoodsItemClick(goodRvModelFromParam);
        return ActionResult.resolve();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ ActionResult m31683a(Context context, IBlockScope iBlockScope, HashMap hashMap, Buildable buildable) {
        BusinessGoodsItemRvModel goodRvModelFromParam = BusinessDataHelper.getGoodRvModelFromParam(hashMap, buildable);
        if (goodRvModelFromParam == null) {
            return ActionResult.reject();
        }
        onGoodsItemExposure(goodRvModelFromParam);
        return ActionResult.resolve();
    }

    /* renamed from: a */
    private View m31681a(View view) {
        int width = view.getWidth();
        View view2 = new View(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, ResourceHelper.getDimensionPixelSize(R.dimen.customer_60px));
        layoutParams.gravity = 17;
        view2.setLayoutParams(layoutParams);
        view2.setAlpha(0.25f);
        view2.setBackgroundResource(R.drawable.customer_skin_add_view_virtual_animation_bg);
        return view2;
    }
}
