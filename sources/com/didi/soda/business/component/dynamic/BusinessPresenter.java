package com.didi.soda.business.component.dynamic;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.didi.app.nova.skeleton.PageFactory;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.flutter.nacho2.p116v2.NachoLifecycleManager;
import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.blocks.action.ActionResult;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.business.component.dynamic.home.Contract;
import com.didi.soda.business.component.home.PreviewImageModel;
import com.didi.soda.business.component.image.PreviewImageRepo;
import com.didi.soda.business.listener.BusinessCategoryListener;
import com.didi.soda.business.listener.BusinessSelectedCallback;
import com.didi.soda.business.manager.BusinessActionRepo;
import com.didi.soda.business.manager.BusinessDataHelper;
import com.didi.soda.business.manager.BusinessDeliveryFeeTipsManager;
import com.didi.soda.business.manager.BusinessDialogHelper;
import com.didi.soda.business.manager.BusinessGuideManager;
import com.didi.soda.business.manager.BusinessOmegaHelper;
import com.didi.soda.business.manager.BusinessOmegaModel;
import com.didi.soda.business.manager.BusinessRepo;
import com.didi.soda.business.model.BusinessActionParam;
import com.didi.soda.business.model.BusinessCategoryRvModel;
import com.didi.soda.business.model.BusinessExpandRvModel;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.business.model.BusinessHeaderRvModel;
import com.didi.soda.business.model.BusinessPageLifeStateRepo;
import com.didi.soda.business.page.BusinessHomePage;
import com.didi.soda.business.page.BusinessSearchPage;
import com.didi.soda.cart.model.BusinessState;
import com.didi.soda.cart.model.CartInfoModel;
import com.didi.soda.cart.model.CartItemModel;
import com.didi.soda.cart.repo.BusinessStateRepo;
import com.didi.soda.cart.repo.CartItemStateRepo;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.binder.model.CustomerDividerLineRvModel;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.component.floatingcarprovider.IFloatingCartProvider;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.login.LoginListener;
import com.didi.soda.customer.foundation.push.model.AnchorInfoModel;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.entity.ActionInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.AnchorInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessFavorResultEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.tracker.AppsFlyerTrackHelper;
import com.didi.soda.customer.foundation.tracker.FirebaseAnalyticsHelper;
import com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.repo.model.ItemState;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalFactory;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalViewModel;
import com.didi.soda.goods.contract.GoodsAmountModel;
import com.didi.soda.goodsV2.helper.GoodsDataHelper;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.didi.soda.manager.base.ICustomerBusinessManager;
import com.didi.soda.manager.base.ICustomerCartManager;
import com.didi.soda.manager.base.ICustomerGoodsManager;
import com.didi.soda.router.DiRouter;
import com.didichuxing.dfbasesdk.utils.StringUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;

public class BusinessPresenter extends Contract.AbsBusinessPresenter {

    /* renamed from: c */
    private static final String f42111c = "BusinessPresenter";

    /* renamed from: A */
    private int f42112A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public boolean f42113B = false;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public boolean f42114C = false;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public boolean f42115D = false;

    /* renamed from: E */
    private String f42116E;

    /* renamed from: F */
    private String f42117F = "0";

    /* renamed from: G */
    private Subscription f42118G;

    /* renamed from: H */
    private int f42119H = 0;

    /* renamed from: I */
    private int f42120I = 0;

    /* renamed from: J */
    private int f42121J = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_80);

    /* renamed from: K */
    private int f42122K = -1;

    /* renamed from: L */
    private BusinessPayload f42123L;

    /* renamed from: M */
    private CartInfoModel f42124M;

    /* renamed from: N */
    private boolean f42125N;

    /* renamed from: O */
    private boolean f42126O;

    /* renamed from: P */
    private BusinessGoodsItemRvModel f42127P;

    /* renamed from: a */
    int f42128a = 0;

    /* renamed from: b */
    int f42129b = -1;

    /* renamed from: d */
    private ICustomerBusinessManager f42130d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f42131e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public BusinessEntity f42132f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public BusinessHeaderRvModel f42133g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public LinkedHashMap<String, BusinessCategoryRvModel> f42134h;

    /* renamed from: i */
    private HashMap<String, GoodsAmountModel> f42135i = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public List<BusinessGoodsItemRvModel> f42136j = new ArrayList();

    /* renamed from: k */
    private ChildDataListManager<RecyclerModel> f42137k;

    /* renamed from: l */
    private CartItemStateRepo f42138l;

    /* renamed from: m */
    private boolean f42139m = false;

    /* renamed from: n */
    private Subscription f42140n = null;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f42141o = 1;

    /* renamed from: p */
    private String f42142p = "";

    /* renamed from: q */
    private String f42143q = "";

    /* renamed from: r */
    private BusinessOmegaHelper f42144r;

    /* renamed from: s */
    private BusinessOmegaModel f42145s = new BusinessOmegaModel();

    /* renamed from: t */
    private BusinessCategoryListener f42146t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public String f42147u = "";

    /* renamed from: v */
    private int f42148v;

    /* renamed from: w */
    private String f42149w;

    /* renamed from: x */
    private int f42150x;

    /* renamed from: y */
    private String f42151y;

    /* renamed from: z */
    private String f42152z;

    interface GetModelCallBack {
        boolean doBeforeSetMddel(BusinessGoodsItemRvModel businessGoodsItemRvModel);
    }

    public void updateAnchorData(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
    }

    public void onTabItemExposure(int i, BusinessCategoryRvModel businessCategoryRvModel) {
        m31648u().onClassifyTabSw(businessCategoryRvModel.mCategoryId, businessCategoryRvModel.mCategoryIndex, businessCategoryRvModel.mCategoryName, 1, businessCategoryRvModel.mItemCount, this.f42143q);
    }

    public void onTabItemSelected(int i, BusinessCategoryRvModel businessCategoryRvModel, boolean z, boolean z2) {
        if (z) {
            m31576a("onTabClicked", "c-act|").setOtherParam("cate_index", Integer.valueOf(i)).build().info();
            m31648u().onClassifyTabClick(businessCategoryRvModel.mCategoryId, businessCategoryRvModel.mCategoryIndex, businessCategoryRvModel.mCategoryName, 1);
        }
        BusinessHeaderRvModel businessHeaderRvModel = this.f42133g;
        if (businessHeaderRvModel != null && !CollectionsUtil.isEmpty(businessHeaderRvModel.mCategoryMenuList) && this.f42122K != i && i < this.f42133g.mCategoryMenuList.size() && this.f42122K < this.f42133g.mCategoryMenuList.size()) {
            if (this.f42122K == -1) {
                this.f42133g.mCategoryMenuList.get(0).isSelected = true;
            } else {
                this.f42133g.mCategoryMenuList.get(i).isSelected = true;
                this.f42133g.mCategoryMenuList.get(this.f42122K).isSelected = false;
            }
            this.f42122K = i;
        }
    }

    public void onMoreTabExposure() {
        m31648u().onMoreClassifyTabSw();
    }

    public void onPageResult(Bundle bundle) {
        int i = 0;
        if (bundle.getBoolean(Const.PageParams.BUSINESS_GOODS_PURCHASED, false)) {
            String string = bundle.getString(Const.PageParams.ITEM_UNIQ_KEY);
            ((Contract.AbsBusinessView) getLogicView()).playAdd2CartAnim();
            ChildDataListManager<RecyclerModel> childDataListManager = this.f42137k;
            if (childDataListManager != null && childDataListManager.size() > 0 && !TextUtils.isEmpty(string)) {
                int size = this.f42137k.size();
                while (true) {
                    if (i < size) {
                        if ((this.f42137k.get(i) instanceof BusinessGoodsItemRvModel) && string.equals(((BusinessGoodsItemRvModel) this.f42137k.get(i)).mItemUniqKey)) {
                            BusinessGoodsItemRvModel businessGoodsItemRvModel = (BusinessGoodsItemRvModel) this.f42137k.get(i);
                            businessGoodsItemRvModel.mAddToCartAnimation = true;
                            this.f42137k.set(i, businessGoodsItemRvModel);
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
            }
        }
        if (bundle.getString("from") != null && bundle.getString("from").contains("businesssearch")) {
            ((IFloatingCartProvider) getScopeContext().getObject("service_floating_cart_key")).requestCartInfo();
        }
    }

    public int getCategoryRvIndex(int i) {
        LinkedHashMap<String, BusinessCategoryRvModel> linkedHashMap;
        ChildDataListManager<RecyclerModel> childDataListManager;
        if (!(i == 0 || (linkedHashMap = this.f42134h) == null)) {
            Iterator<BusinessCategoryRvModel> it = linkedHashMap.values().iterator();
            BusinessCategoryRvModel businessCategoryRvModel = null;
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BusinessCategoryRvModel next = it.next();
                if (i2 == i) {
                    businessCategoryRvModel = next;
                    break;
                }
                i2++;
            }
            if (!(businessCategoryRvModel == null || (childDataListManager = this.f42137k) == null)) {
                return childDataListManager.indexOf(businessCategoryRvModel);
            }
        }
        return 0;
    }

    public void goBusinessDetail() {
        m31576a("goBusinessDetail", "c-act|").build().info();
        BusinessEntity businessEntity = this.f42132f;
        DiRouter.request().path(RoutePath.BUSINESS_DETAIL).putSerializable(Const.PageParams.SHOP_ID, this.f42131e).putSerializable(Const.PageParams.SHOP_INFO_ENTITY, (businessEntity == null || businessEntity.shopInfo == null) ? null : this.f42132f.shopInfo).putSerializable(Const.PageParams.SHOP_OMEGA_MODEL, this.f42145s).open();
    }

    public void onBusinessFavor(boolean z) {
        BusinessHeaderRvModel businessHeaderRvModel = this.f42133g;
        if (businessHeaderRvModel != null) {
            businessHeaderRvModel.isFavor = z;
        }
        BusinessOmegaHelper businessOmegaHelper = this.f42144r;
        if (businessOmegaHelper != null) {
            businessOmegaHelper.onFavorClick(this.f42131e, this.f42141o, z);
        }
        CustomerRpcManagerProxy.get().setBusinessFavor(this.f42131e, z ? 1 : 0, new CustomerRpcCallback<BusinessFavorResultEntity>() {
            public void onRpcFailure(SFRpcException sFRpcException) {
            }

            public void onRpcSuccess(BusinessFavorResultEntity businessFavorResultEntity, long j) {
            }
        });
    }

    public void goBusinessSearch() {
        int i;
        BusinessInfoEntity businessInfoEntity;
        m31648u().onHeaderSearchClick();
        BusinessEntity businessEntity = this.f42132f;
        String str = null;
        if (businessEntity == null || businessEntity.shopInfo == null) {
            i = 1;
            businessInfoEntity = null;
        } else {
            BusinessInfoEntity businessInfoEntity2 = this.f42132f.shopInfo;
            String str2 = this.f42132f.shopInfo.cartRevision;
            i = this.f42132f.shopInfo.cShopStatus;
            BusinessInfoEntity businessInfoEntity3 = businessInfoEntity2;
            str = str2;
            businessInfoEntity = businessInfoEntity3;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(Const.PageParams.SHOP_ID, this.f42131e);
        bundle.putInt(Const.PageParams.SHOP_STATUS, i);
        bundle.putString(Const.PageParams.CART_REVISION, str);
        bundle.putSerializable(Const.PageParams.SHOP_INFO_ENTITY, businessInfoEntity);
        bundle.putString(Const.PageParams.BIDATA, this.f42147u);
        getScopeContext().getNavigator().pushForResult((BusinessSearchPage) PageFactory.newInstance(BusinessSearchPage.class, bundle));
    }

    public boolean isDataLoadSuccess() {
        return this.f42139m;
    }

    public void onGoodsItemExposure(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        int i;
        BusinessGoodsItemRvModel businessGoodsItemRvModel2 = businessGoodsItemRvModel;
        LinkedHashMap<String, BusinessCategoryRvModel> linkedHashMap = this.f42134h;
        int i2 = -1;
        if (linkedHashMap != null) {
            BusinessCategoryRvModel businessCategoryRvModel = linkedHashMap.get(businessGoodsItemRvModel2.mCateId);
            if (businessCategoryRvModel != null) {
                i2 = businessCategoryRvModel.mCategoryIndex;
            }
            i = i2;
        } else {
            i = -1;
        }
        m31576a("Exposure: {id}" + businessGoodsItemRvModel2.mGoodsId + " {uniKey}" + businessGoodsItemRvModel2.mItemUniqKey + " {name}" + businessGoodsItemRvModel2.mGoodsName, "c-show|").build().info();
        if (businessGoodsItemRvModel2.mActinfo != null) {
            Integer.toString(businessGoodsItemRvModel2.mActinfo.getActType());
        }
        m31648u().onItemExposure(businessGoodsItemRvModel2.mGoodsId, businessGoodsItemRvModel2.mStatus, businessGoodsItemRvModel2.mGoodsMarketingTipString, this.f42142p, businessGoodsItemRvModel2.mCateId, businessGoodsItemRvModel2.mCateName, i, businessGoodsItemRvModel2.mInCategoryIndex, 0, businessGoodsItemRvModel2.mHeadImg, businessGoodsItemRvModel2.mSoldStatus, businessGoodsItemRvModel2.mSoldTimeDesc, businessGoodsItemRvModel2.mPrice + "", businessGoodsItemRvModel2.mSpecialPrice + "", businessGoodsItemRvModel2.mActivityType + "", businessGoodsItemRvModel2.mAdditionalType, businessGoodsItemRvModel2.mCateIndex, businessGoodsItemRvModel2.hasMultipleContents ? 1 : 0, businessGoodsItemRvModel2.mInCategoryIndex);
    }

    public void showMoreCategory(BusinessSelectedCallback businessSelectedCallback) {
        m31648u().onMoreClassifyTabCk();
        BusinessCategoryListener businessCategoryListener = this.f42146t;
        if (businessCategoryListener != null) {
            BusinessHeaderRvModel businessHeaderRvModel = this.f42133g;
            businessCategoryListener.showDyCategory(businessHeaderRvModel != null ? businessHeaderRvModel.mCategoryMenuList : null, businessSelectedCallback);
        }
    }

    public boolean hasDynamicNotice() {
        return BusinessDataHelper.hasDynamicNotice(this.f42132f);
    }

    public void onFavorLogin() {
        LoginUtil.updateLoginPopToRootStatus(false);
        LoginUtil.loginActivityAndTrack(getContext(), 18, new LoginListener() {
            public /* synthetic */ void onCancel() {
                LoginListener.CC.$default$onCancel(this);
            }

            public void onSuccess(String str) {
                BusinessPresenter.this.onBusinessFavor(true);
                ((Contract.AbsBusinessView) BusinessPresenter.this.getLogicView()).favorBusiness();
            }
        });
    }

    public void onExpandOrFoldAction(BusinessExpandRvModel businessExpandRvModel, int i) {
        List<ComponentModel> list = businessExpandRvModel.mComponentModelExpandList;
        if (CollectionsUtil.isEmpty(list)) {
            List<BusinessGoodsItemRvModel> list2 = businessExpandRvModel.mExpandList;
            if (businessExpandRvModel.mIsExpand) {
                this.f42137k.addAll(i, list2);
                return;
            }
            for (BusinessGoodsItemRvModel indexOf : list2) {
                this.f42137k.remove(this.f42137k.indexOf(indexOf));
            }
        } else if (businessExpandRvModel.mIsExpand) {
            this.f42137k.addAll(i, list);
            ChildDataListManager<RecyclerModel> childDataListManager = this.f42137k;
            childDataListManager.remove(childDataListManager.indexOf(businessExpandRvModel));
        }
    }

    public void onExpandShow(BusinessExpandRvModel businessExpandRvModel) {
        m31648u().onExpandExposure(businessExpandRvModel);
    }

    public void onExpandClickEvent(BusinessExpandRvModel businessExpandRvModel) {
        m31648u().onExpandClickEvent(businessExpandRvModel);
    }

    public void onRvScrolled(int i) {
        LogUtil.m32584d(f42111c, "onRvScrolled:" + i);
        if (Math.abs(i) <= this.f42121J) {
            LogUtil.m32584d(f42111c, "onRvScrolled a little:" + i);
        } else if (i > 0) {
            m31648u().onRvScrolled(1);
        } else {
            m31648u().onRvScrolled(2);
        }
    }

    public void onTabScrolled(int i) {
        LogUtil.m32584d(f42111c, "onTabScrolled:" + i);
        if (Math.abs(i) <= this.f42121J) {
            LogUtil.m32584d(f42111c, "onTabScrolled a little:" + i);
        } else if (i > 0) {
            m31648u().onTabScrolled(3);
        } else {
            m31648u().onTabScrolled(4);
        }
    }

    public void onBack(int i) {
        Bundle bundle = new Bundle();
        BusinessHeaderRvModel businessHeaderRvModel = this.f42133g;
        if (businessHeaderRvModel != null) {
            bundle.putInt(Const.PageParams.IS_BUSINESS_FAVORED, businessHeaderRvModel.isFavor);
        }
        if (!TextUtils.isEmpty(this.f42131e)) {
            bundle.putString(Const.PageParams.SHOP_ID, this.f42131e);
        }
        this.f42145s.mReturnWay = i;
        String str = (getScopeContext() == null || getScopeContext().getObject("PageName") == null) ? "" : (String) getScopeContext().getObject("PageName");
        bundle.putString("fromPage", str);
        OmegaTracker.Builder.create("sailing_c_x_page_return_ck").addEventParam("from", str).build().track();
        getScopeContext().getNavigator().finish(bundle);
    }

    public void onCreate() {
        super.onCreate();
        m31576a(NachoLifecycleManager.LIFECYCLE_ON_CREATE, "c-state|").build().info();
        m31618d();
        m31621e();
        m31627f();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        m31576a(NachoLifecycleManager.LIFECYCLE_ON_DESTROY, "c-state|").build().info();
        m31578a();
        BusinessState state = ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).getState(this.f42131e);
        if (state != null) {
            state.mHasShowedWineRemind = false;
            ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).setValue(state);
        }
        ((BusinessPageLifeStateRepo) RepoFactory.getRepo(BusinessPageLifeStateRepo.class)).setState(1);
        BusinessDialogHelper.dismissAllDialog();
        m31648u().onExit(this.f42145s.mDistance, this.f42145s.mReturnWay, this.f42145s.mDeliveryFee, this.f42145s.mDeliveryTime, this.f42145s.mExposureActivityNum, this.f42145s.mTabTypeList, this.f42145s.mDeliveryType, this.f42145s.couponNum, this.f42145s.mRecId, this.f42145s.mIsMarketArea);
    }

    public void onGoodsItemClick(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        BusinessCategoryRvModel businessCategoryRvModel;
        BusinessGoodsItemRvModel businessGoodsItemRvModel2 = businessGoodsItemRvModel;
        m31602b(businessGoodsItemRvModel2, false);
        m31576a("onGoodsItemClick", "c-act|").setOtherParam("cate_id", businessGoodsItemRvModel2.mCateId).setOtherParam("goods_id", businessGoodsItemRvModel2.mGoodsId).build().info();
        if (!m31649v()) {
            LinkedHashMap<String, BusinessCategoryRvModel> linkedHashMap = this.f42134h;
            int i = -1;
            if (!(linkedHashMap == null || (businessCategoryRvModel = linkedHashMap.get(businessGoodsItemRvModel2.mCateId)) == null)) {
                i = businessCategoryRvModel.mCategoryIndex;
            }
            boolean isNeedReloadSubitem = BusinessDataHelper.isNeedReloadSubitem(this.f42132f.shopInfo);
            if (BusinessDataHelper.isNeedReloadSubitem(this.f42132f.shopInfo) || BusinessDataHelper.isNeedReloadSubitem(businessGoodsItemRvModel)) {
                m31593a(EventConst.Business.SHOP_GOODS_ITEM_CK, businessGoodsItemRvModel2, isNeedReloadSubitem ? 1 : 0, 0);
                BusinessDataHelper.toGoodsItemDetail(getScopeContext(), businessGoodsItemRvModel, m31596a(businessGoodsItemRvModel2.mNeedAlcoholRemind), this.f42147u, 1, this.f42116E, i);
                return;
            }
            GoodsItemEntity findGoodEntity = BusinessDataHelper.findGoodEntity(this.f42132f, businessGoodsItemRvModel2.mGoodsId, businessGoodsItemRvModel2.mItemUniqKey);
            m31593a(EventConst.Business.SHOP_GOODS_ITEM_CK, businessGoodsItemRvModel2, (int) isNeedReloadSubitem, GoodsDataHelper.hasMultipleContents(findGoodEntity) ? 1 : 0);
            if (findGoodEntity != null) {
                BusinessDataHelper.toGoodItemDetail(getScopeContext(), findGoodEntity, businessGoodsItemRvModel2.mInCategoryIndex, m31596a(businessGoodsItemRvModel2.mNeedAlcoholRemind), this.f42147u, 1, this.f42116E, businessGoodsItemRvModel2.mCateId, i);
            }
        }
    }

    public void onGoodsImageClick(View view, BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        int i;
        m31602b(businessGoodsItemRvModel, true);
        m31593a(EventConst.Business.SHOP_ITEM_PHOTO_CK, businessGoodsItemRvModel, BusinessDataHelper.isNeedReloadSubitem(this.f42132f.shopInfo) ? 1 : 0, GoodsDataHelper.hasMultipleContents(BusinessDataHelper.findGoodEntity(this.f42132f, businessGoodsItemRvModel.mGoodsId, businessGoodsItemRvModel.mItemUniqKey)) ? 1 : 0);
        LinkedHashMap<String, BusinessCategoryRvModel> linkedHashMap = this.f42134h;
        if (linkedHashMap != null) {
            BusinessCategoryRvModel businessCategoryRvModel = linkedHashMap.get(businessGoodsItemRvModel.mCateId);
            i = businessCategoryRvModel != null ? businessCategoryRvModel.mCategoryIndex : -1;
        } else {
            i = 0;
        }
        String string = view.getContext().getString(R.string.customer_transition_tag_business_preview_image_named, new Object[]{String.valueOf(System.currentTimeMillis())});
        ViewCompat.setTransitionName(view, string);
        DiRouter.request().path(RoutePath.BUSINESS_PREVIEW_IMAGE).setFromPage(getScopeContext()).putString(Const.PageParams.TRANSITION_NAMES, string).putSerializable(Const.PageParams.PREVIEW_IMAGE, PreviewImageModel.copyFrom(businessGoodsItemRvModel, view, i, this.f42142p, -1)).open();
    }

    public void onGoodsAddClick(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        m31576a("onGoodsAddClick", "c-act|").setOtherParam("cate_id", businessGoodsItemRvModel.mCateId).setOtherParam("goods_id", businessGoodsItemRvModel.mGoodsId).build().info();
        m31588a(businessGoodsItemRvModel, false);
    }

    public void onGoodsMinusClick(BusinessGoodsItemRvModel businessGoodsItemRvModel, String str, String str2) {
        m31576a("onGoodsAddClick", "c-act|").setOtherParam("cate_id", businessGoodsItemRvModel.mCateId).setOtherParam("goods_id", businessGoodsItemRvModel.mGoodsId).build().info();
        m31587a(businessGoodsItemRvModel, str, str2, false);
    }

    public void setBusinessCategoryListener(BusinessCategoryListener businessCategoryListener) {
        this.f42146t = businessCategoryListener;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        m31576a("onStart", "c-state|").build().info();
        OmegaCommonParamHelper.refreshLv3GuideParam();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f42140n == null) {
            this.f42140n = BusinessRepo.get(getScopeContext()).subscribe(getScopeContext(), new Action1<CustomerResource<BusinessEntity>>() {
                public void call(CustomerResource<BusinessEntity> customerResource) {
                    if (customerResource != null) {
                        if (customerResource.status == Resource.Status.LOADING) {
                            BusinessPresenter.this.m31631h();
                        } else {
                            BusinessPresenter.this.m31633i();
                            if (customerResource.data == null) {
                                BusinessPresenter.this.m31604b(ResourceHelper.getString(R.string.customer_global_no_data_available));
                                return;
                            }
                            int i = C142547.$SwitchMap$com$didi$app$nova$skeleton$repo$Resource$Status[customerResource.status.ordinal()];
                            if (i == 1 || i == 2) {
                                BusinessPresenter.this.m31591a(customerResource);
                            } else if (i == 3) {
                                BusinessPresenter.this.m31604b(customerResource.message);
                            }
                        }
                        if (!BusinessPresenter.this.f42115D && customerResource.data != null && ((BusinessEntity) customerResource.data).shopInfo != null && !TextUtils.isEmpty(((BusinessEntity) customerResource.data).shopInfo.cartRevision)) {
                            boolean unused = BusinessPresenter.this.f42115D = true;
                            ((IFloatingCartProvider) BusinessPresenter.this.getScopeContext().getObject("service_floating_cart_key")).showFloatingCart(((BusinessEntity) customerResource.data).shopInfo.cartRevision, ((BusinessEntity) customerResource.data).shopInfo.cShopStatus, BusinessPresenter.this.f42147u, BusinessPresenter.this.f42114C);
                        }
                    }
                }
            });
        }
    }

    /* renamed from: com.didi.soda.business.component.dynamic.BusinessPresenter$7 */
    static /* synthetic */ class C142547 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$app$nova$skeleton$repo$Resource$Status;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didi.app.nova.skeleton.repo.Resource$Status[] r0 = com.didi.app.nova.skeleton.repo.Resource.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$app$nova$skeleton$repo$Resource$Status = r0
                com.didi.app.nova.skeleton.repo.Resource$Status r1 = com.didi.app.nova.skeleton.repo.Resource.Status.SUCCESS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$app$nova$skeleton$repo$Resource$Status     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.app.nova.skeleton.repo.Resource$Status r1 = com.didi.app.nova.skeleton.repo.Resource.Status.CHANGE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$app$nova$skeleton$repo$Resource$Status     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.app.nova.skeleton.repo.Resource$Status r1 = com.didi.app.nova.skeleton.repo.Resource.Status.ERROR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.business.component.dynamic.BusinessPresenter.C142547.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31588a(BusinessGoodsItemRvModel businessGoodsItemRvModel, boolean z) {
        BusinessCategoryRvModel businessCategoryRvModel;
        if (businessGoodsItemRvModel != null) {
            m31602b(businessGoodsItemRvModel, z);
            if (!m31649v()) {
                int i = z ? 5 : 1;
                boolean isNeedReloadSubitem = BusinessDataHelper.isNeedReloadSubitem(this.f42132f.shopInfo);
                LinkedHashMap<String, BusinessCategoryRvModel> linkedHashMap = this.f42134h;
                int i2 = -1;
                if (!(linkedHashMap == null || (businessCategoryRvModel = linkedHashMap.get(businessGoodsItemRvModel.mCateId)) == null)) {
                    i2 = businessCategoryRvModel.mCategoryIndex;
                }
                if (BusinessDataHelper.isNeedReloadSubitem(this.f42132f.shopInfo)) {
                    m31593a(EventConst.Business.SHOP_GOODS_ITEM_ADD_CK, businessGoodsItemRvModel, (int) isNeedReloadSubitem, 0);
                    BusinessDataHelper.toGoodsItemDetail(getScopeContext(), businessGoodsItemRvModel, m31596a(businessGoodsItemRvModel.mNeedAlcoholRemind), this.f42147u, i, this.f42116E, i2);
                    return;
                }
                GoodsItemEntity findGoodEntity = BusinessDataHelper.findGoodEntity(this.f42132f, businessGoodsItemRvModel.mGoodsId, businessGoodsItemRvModel.mItemUniqKey);
                m31593a(EventConst.Business.SHOP_GOODS_ITEM_ADD_CK, businessGoodsItemRvModel, isNeedReloadSubitem ? 1 : 0, GoodsDataHelper.hasMultipleContents(findGoodEntity) ? 1 : 0);
                if (findGoodEntity != null) {
                    BusinessDataHelper.dispatchAddAction(getScopeContext(), findGoodEntity, businessGoodsItemRvModel, this.f42147u, i, this.f42116E, m31596a(businessGoodsItemRvModel.mNeedAlcoholRemind), m31648u(), (CartItemModel) null);
                }
            }
        }
    }

    /* renamed from: a */
    private void m31587a(BusinessGoodsItemRvModel businessGoodsItemRvModel, String str, String str2, boolean z) {
        BusinessCategoryRvModel businessCategoryRvModel;
        BusinessGoodsItemRvModel businessGoodsItemRvModel2 = businessGoodsItemRvModel;
        boolean z2 = z;
        m31602b(businessGoodsItemRvModel, z2);
        if (!m31649v()) {
            int i = z2 ? 5 : 1;
            boolean isNeedReloadSubitem = BusinessDataHelper.isNeedReloadSubitem(this.f42132f.shopInfo);
            LinkedHashMap<String, BusinessCategoryRvModel> linkedHashMap = this.f42134h;
            int i2 = -1;
            if (!(linkedHashMap == null || (businessCategoryRvModel = linkedHashMap.get(businessGoodsItemRvModel2.mCateId)) == null)) {
                i2 = businessCategoryRvModel.mCategoryIndex;
            }
            if (BusinessDataHelper.isNeedReloadSubitem(this.f42132f.shopInfo)) {
                m31593a(EventConst.Business.SHOP_GOODS_ITEM_ADD_CK, businessGoodsItemRvModel, (int) isNeedReloadSubitem, 0);
                BusinessDataHelper.toGoodsItemDetail(getScopeContext(), businessGoodsItemRvModel, m31596a(businessGoodsItemRvModel2.mNeedAlcoholRemind), this.f42147u, i, this.f42116E, i2);
                return;
            }
            GoodsItemEntity findGoodEntity = BusinessDataHelper.findGoodEntity(this.f42132f, businessGoodsItemRvModel2.mGoodsId, businessGoodsItemRvModel2.mItemUniqKey);
            m31593a(EventConst.Business.SHOP_GOODS_ITEM_ADD_CK, businessGoodsItemRvModel, isNeedReloadSubitem ? 1 : 0, GoodsDataHelper.hasMultipleContents(findGoodEntity) ? 1 : 0);
            if (findGoodEntity != null) {
                BusinessDataHelper.dispatchMinusAction(getScopeContext(), findGoodEntity, businessGoodsItemRvModel, this.f42147u, i, this.f42116E, m31596a(businessGoodsItemRvModel2.mNeedAlcoholRemind), m31648u(), str, str2);
            }
        }
    }

    /* renamed from: a */
    private void m31578a() {
        this.f42135i.clear();
        ChildDataListManager<RecyclerModel> childDataListManager = this.f42137k;
        if (childDataListManager != null) {
            childDataListManager.clear();
            this.f42137k = null;
        }
        this.f42136j.clear();
        clearDataManagers();
        m31648u().reset();
    }

    public int getBusinessDialogSourceType() {
        if (this.f42119H == 1) {
            return 2;
        }
        if (TextUtils.equals(this.f42117F, "1")) {
            return 1;
        }
        return 0;
    }

    /* renamed from: b */
    private void m31599b() {
        Bundle bundle = getScopeContext().getBundle();
        String string = bundle.getString(Const.PageParams.ANCHOR_INFO);
        if (TextUtils.isEmpty(string)) {
            string = bundle.getString(Const.PageParams.ANCHOR_INFO2);
        }
        try {
            AnchorInfoModel anchorInfoModel = (AnchorInfoModel) GsonUtil.fromJson(string, AnchorInfoModel.class);
            if (anchorInfoModel != null) {
                this.f42149w = anchorInfoModel.itemId;
                this.f42148v = anchorInfoModel.anchorStatus;
            }
        } catch (Exception e) {
            LogUtil.m32588i(f42111c, "anchorInfo parse error: " + e.toString() + string);
        }
    }

    /* renamed from: c */
    private void m31612c() {
        Bundle bundle = getScopeContext().getBundle();
        String string = bundle.getString(Const.PageParams.ACTION_INFO);
        if (TextUtils.isEmpty(string)) {
            string = bundle.getString(Const.PageParams.ACTION_INFO_DICT);
        }
        if (TextUtils.isEmpty(string)) {
            string = bundle.getString(Const.PageParams.ACTION_INFO_DICT2);
        }
        try {
            ActionInfoEntity actionInfoEntity = (ActionInfoEntity) GsonUtil.fromJson(string, ActionInfoEntity.class);
            if (actionInfoEntity != null) {
                this.f42150x = actionInfoEntity.getType();
                this.f42151y = actionInfoEntity.getItemId();
            }
        } catch (Exception e) {
            LogUtil.m32588i(f42111c, "actionInfo parse error: " + e.toString() + string);
        }
    }

    /* renamed from: d */
    private void m31618d() {
        this.f42130d = (ICustomerBusinessManager) CustomerManagerLoader.loadManager(ICustomerBusinessManager.class);
    }

    /* renamed from: e */
    private void m31621e() {
        Bundle bundle = getScopeContext().getBundle();
        String string = bundle.getString(Const.PageParams.SHOP_ID);
        this.f42131e = string;
        bundle.putString("current_shop_id", string);
        this.f42147u = bundle.getString(Const.PageParams.BIDATA, "");
        this.f42152z = bundle.getString(Const.PageParams.SHOP_ITEM_SEARCH_INFO);
        this.f42117F = bundle.getString(Const.URI_FROM_OUTER, "0");
        this.f42119H = bundle.getInt("sceneType", 0);
        this.f42120I = bundle.getInt("fromType", 0);
        int i = bundle.getInt(Const.PageParams.WINE_CONFIRM, 0);
        this.f42112A = i;
        if (i == 1) {
            this.f42113B = true;
        }
        m31599b();
        m31612c();
    }

    /* renamed from: f */
    private void m31627f() {
        this.f42138l = (CartItemStateRepo) RepoFactory.getRepo(CartItemStateRepo.class);
        ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).subscribe(this.f42131e, getScopeContext(), new Action1<BusinessState>() {
            public void call(BusinessState businessState) {
                if (businessState != null) {
                    boolean unused = BusinessPresenter.this.f42113B = businessState.mHasShowedWineRemind;
                    BusinessDataHelper.addBlockScopeParam(businessState, BusinessPresenter.this.getScope());
                }
                if (businessState != null && BusinessPresenter.this.f42141o != businessState.shopStatus) {
                    if (!(BusinessPresenter.this.f42132f == null || BusinessPresenter.this.f42132f.shopInfo == null)) {
                        try {
                            BusinessPresenter.this.f42132f.shopInfo.cShopStatus = businessState.shopStatus;
                            LinkedHashMap unused2 = BusinessPresenter.this.f42134h = BusinessDataHelper.parseBusinessEntity(BusinessPresenter.this.f42132f, BusinessPresenter.this.f42133g.mCategoryList, BusinessPresenter.this.f42133g.mCategoryMenuList, BusinessPresenter.this.getScope(), BusinessPresenter.this.m31640m());
                            BusinessPresenter.this.clearDataManagers();
                            BusinessPresenter.this.m31642o();
                            LogUtil.m32584d(BusinessPresenter.f42111c, "BusinessStateRepo changed and showCategoryAndGoods");
                            if (BusinessPresenter.this.f42133g != null) {
                                BusinessPresenter.this.f42133g.updateBusinessStatus(businessState.shopStatus, businessState.shopStatusDesc);
                                ((Contract.AbsBusinessView) BusinessPresenter.this.getLogicView()).updateHeaderView(BusinessPresenter.this.f42133g, BusinessPresenter.this.getScope());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_SHOP_CATE_ERROR).addModuleName("shop").addParam("shop_id", BusinessPresenter.this.f42131e).addParam("errmsg", e.toString()).build().trackError();
                            BusinessPresenter.this.m31592a(ResourceHelper.getString(R.string.customer_global_no_data_available));
                            BusinessPresenter.this.m31576a("parseBusinessEntity error", "c-data|").setMessage(e.getMessage()).build().error();
                            return;
                        }
                    }
                    BusinessPresenter.this.m31579a(businessState.shopStatus);
                }
            }
        });
        ((PreviewImageRepo) RepoFactory.getRepo(PreviewImageRepo.class)).subscribe(getScopeContext(), new Action1<PreviewImageModel>() {
            public void call(PreviewImageModel previewImageModel) {
                BusinessGoodsItemRvModel findGoodsItemRvModel = BusinessDataHelper.findGoodsItemRvModel(BusinessPresenter.this.f42136j, previewImageModel.mGoodId, previewImageModel.mCateId);
                if (findGoodsItemRvModel != null) {
                    BusinessPresenter.this.m31576a("onImageAddClick", "c-act|").setOtherParam("cate_id", findGoodsItemRvModel.mCateId).setOtherParam("goods_id", findGoodsItemRvModel.mGoodsId).build().info();
                    BusinessPresenter.this.m31588a(findGoodsItemRvModel, true);
                }
            }
        });
        ((BusinessActionRepo) RepoFactory.getRepo(BusinessActionRepo.class)).subscribe(getScopeContext(), new Action1<BusinessActionParam>() {
            public void call(BusinessActionParam businessActionParam) {
                if (businessActionParam != null) {
                    if (businessActionParam.isNeedRefreshBusiness()) {
                        LogUtil.m32584d("BusinessLink", "requestShopData");
                        BusinessPresenter.this.m31615d("requestShopData").build().info();
                        BusinessHomePage.refreshBusinessData(BusinessPresenter.this.getScopeContext(), businessActionParam.isWithActInfo());
                    }
                    if (businessActionParam.isNeedRefreshCart()) {
                        ((IFloatingCartProvider) BusinessPresenter.this.getScopeContext().getObject("service_floating_cart_key")).requestCartInfo();
                    }
                }
            }
        });
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).subscribe(getScopeContext(), this.f42131e, (Action1<CustomerResource<CartInfoEntity>>) new Action1() {
            public final void call(Object obj) {
                BusinessPresenter.this.m31603b((CustomerResource) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m31603b(CustomerResource customerResource) {
        if (customerResource != null && customerResource.data != null) {
            this.f42124M = new CartInfoModel().convertModel((CartInfoEntity) customerResource.data, this.f42141o);
        }
    }

    /* renamed from: g */
    private void m31629g() {
        LogUtil.m32584d("BusinessLink", "requestShopData");
        m31615d("requestShopData").build().info();
        BusinessHomePage.requestBusinessData(getScopeContext());
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m31631h() {
        ((Contract.AbsBusinessView) getLogicView()).showShimmerView();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m31633i() {
        ((Contract.AbsBusinessView) getLogicView()).hideShimmerView();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31592a(String str) {
        ((Contract.AbsBusinessView) getLogicView()).showAbnormalView(m31610c(str));
        ((Contract.AbsBusinessView) getLogicView()).showBusinessHeader(false);
        BusinessDialogHelper.dismissAllDialog();
    }

    /* renamed from: j */
    private void m31634j() {
        ((Contract.AbsBusinessView) getLogicView()).hideAbnormalView();
        ((Contract.AbsBusinessView) getLogicView()).showBusinessHeader(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31591a(CustomerResource<BusinessEntity> customerResource) {
        BusinessEntity businessEntity = (BusinessEntity) customerResource.data;
        if (customerResource.mExtension != null) {
            this.f42143q = customerResource.mExtension.getString(ParamConst.TRACE_ID, "");
        }
        m31576a("onLoadShopDataSuccess", "c-data|").build().info();
        this.f42139m = true;
        this.f42132f = businessEntity;
        this.f42142p = businessEntity.recId;
        m31578a();
        m31639l();
        this.f42145s = BusinessOmegaModel.newInstance(businessEntity, this.f42143q);
        int i = 0;
        if (getScope().getObject(BusinessDataHelper.PARA_IS_MARKET_AREA) != null) {
            i = ((Integer) getScope().getObject(BusinessDataHelper.PARA_IS_MARKET_AREA)).intValue();
        }
        this.f42145s.mIsMarketArea = i;
        m31650w();
        this.f42138l.subscribe(this.f42131e, getScopeContext(), new Action1() {
            public final void call(Object obj) {
                BusinessPresenter.this.m31605b((HashMap) obj);
            }
        });
        if (businessEntity.shopInfo != null) {
            ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).setActInfo(businessEntity.shopInfo.actInfo);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m31605b(HashMap hashMap) {
        if (hashMap == null || hashMap.size() <= 0) {
            m31637k();
        } else {
            m31594a((Map<String, ItemState>) hashMap);
        }
    }

    /* renamed from: k */
    private void m31637k() {
        ChildDataListManager<RecyclerModel> childDataListManager = this.f42137k;
        if (childDataListManager != null && childDataListManager.size() > 0) {
            int size = this.f42137k.size();
            for (int i = 0; i < size; i++) {
                if (this.f42137k.get(i) instanceof BusinessGoodsItemRvModel) {
                    BusinessGoodsItemRvModel businessGoodsItemRvModel = (BusinessGoodsItemRvModel) this.f42137k.get(i);
                    businessGoodsItemRvModel.mGoodsAmountModel.clearAmount();
                    this.f42137k.set(i, businessGoodsItemRvModel);
                }
            }
        }
    }

    public int getBusinessSourceType() {
        if (TextUtils.equals(this.f42117F, "1")) {
            return 2;
        }
        int i = this.f42120I;
        if (i == 1) {
            return 4;
        }
        return i == 2 ? 3 : 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m31604b(String str) {
        m31576a("onLoadShopDataError", "c-data|").build().info();
        this.f42139m = false;
        m31592a(str);
    }

    /* renamed from: c */
    private TopGunAbnormalViewModel m31610c(String str) {
        $$Lambda$BusinessPresenter$8mgI3mICNlPmvdIpf8jbsX6h8bs r0 = new View.OnClickListener() {
            public final void onClick(View view) {
                BusinessPresenter.this.m31581a(view);
            }
        };
        if (!NetWorkUtils.isNetworkConnected(getContext())) {
            return TopGunAbnormalFactory.buildNoNetwork(r0);
        }
        return TopGunAbnormalFactory.buildHomeNoService(str, r0);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m31581a(View view) {
        m31634j();
        m31629g();
        ((IFloatingCartProvider) getScopeContext().getObject("service_floating_cart_key")).requestCartInfo();
    }

    /* renamed from: a */
    private void m31594a(Map<String, ItemState> map) {
        String str;
        ChildDataListManager<RecyclerModel> childDataListManager = this.f42137k;
        if (childDataListManager != null && childDataListManager.size() > 0) {
            int size = this.f42137k.size();
            for (int i = 0; i < size; i++) {
                if (this.f42137k.get(i) instanceof BusinessGoodsItemRvModel) {
                    BusinessGoodsItemRvModel businessGoodsItemRvModel = (BusinessGoodsItemRvModel) this.f42137k.get(i);
                    if (!map.containsKey(businessGoodsItemRvModel.mItemUniqKey) || map.get(businessGoodsItemRvModel.mItemUniqKey) == null) {
                        str = "Goods amount is 0 goodsId: " + businessGoodsItemRvModel.mGoodsId + " uniKey:" + businessGoodsItemRvModel.mItemUniqKey;
                        businessGoodsItemRvModel.mGoodsAmountModel.clearAmount();
                    } else {
                        str = "Goods amount or status changed...[goodsId: " + businessGoodsItemRvModel.mGoodsId + " uniKey:" + businessGoodsItemRvModel.mItemUniqKey + ", amount: " + map.get(businessGoodsItemRvModel.mItemUniqKey).amount + com.didichuxing.bigdata.p174dp.locsdk.Const.jaRight;
                        businessGoodsItemRvModel.mGoodsAmountModel.updateGoodsItemAmountModel(map.get(businessGoodsItemRvModel.mItemUniqKey));
                    }
                    m31576a(str, "c-show|").build().info();
                    this.f42137k.set(i, businessGoodsItemRvModel);
                }
            }
        }
    }

    /* renamed from: b */
    private void m31606b(Map<String, ItemState> map) {
        String str;
        ChildDataListManager<RecyclerModel> childDataListManager = this.f42137k;
        if (childDataListManager != null && childDataListManager.size() > 0) {
            int size = this.f42137k.size();
            for (int i = 0; i < size; i++) {
                if (this.f42137k.get(i) instanceof ComponentModel) {
                    ComponentModel componentModel = (ComponentModel) this.f42137k.get(i);
                    if (componentModel.getDataModel() instanceof BusinessGoodsItemRvModel) {
                        BusinessGoodsItemRvModel businessGoodsItemRvModel = (BusinessGoodsItemRvModel) componentModel.getDataModel();
                        if (!map.containsKey(businessGoodsItemRvModel.mItemUniqKey) || map.get(businessGoodsItemRvModel.mItemUniqKey) == null) {
                            str = "Goods amount is 0 goodsId: " + businessGoodsItemRvModel.mGoodsId + " uniKey:" + businessGoodsItemRvModel.mItemUniqKey;
                            businessGoodsItemRvModel.mGoodsAmountModel.clearAmount();
                        } else {
                            str = "Goods amount or status changed...[goodsId: " + businessGoodsItemRvModel.mGoodsId + " uniKey:" + businessGoodsItemRvModel.mItemUniqKey + ", amount: " + map.get(businessGoodsItemRvModel.mItemUniqKey).amount + com.didichuxing.bigdata.p174dp.locsdk.Const.jaRight;
                            businessGoodsItemRvModel.mGoodsAmountModel.updateGoodsItemAmountModel(map.get(businessGoodsItemRvModel.mItemUniqKey));
                        }
                        m31576a(str, "c-show|").build().info();
                    }
                }
            }
        }
    }

    /* renamed from: l */
    private void m31639l() {
        BusinessEntity businessEntity = this.f42132f;
        if (businessEntity != null) {
            if (businessEntity.shopInfo == null || TextUtils.isEmpty(this.f42132f.shopInfo.cartRevision)) {
                this.f42116E = "0";
            } else {
                this.f42116E = this.f42132f.shopInfo.cartRevision;
            }
            if (CollectionsUtil.isEmpty(this.f42132f.cateInfo)) {
                ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_SHOP_CATE_ERROR).addModuleName("shop").addParam("shop_id", this.f42131e).build().trackError();
                m31592a(ResourceHelper.getString(R.string.customer_global_no_data_available));
                m31576a("No Cate", "c-data|").build().error();
                return;
            }
            m31634j();
            BusinessHeaderRvModel newInstance = BusinessHeaderRvModel.newInstance(getContext(), this.f42132f, this.f42123L);
            this.f42133g = newInstance;
            try {
                this.f42134h = BusinessDataHelper.parseBusinessEntity(this.f42132f, newInstance.mCategoryList, this.f42133g.mCategoryMenuList, getScope(), m31640m());
                ((Contract.AbsBusinessView) getLogicView()).updateHeaderView(this.f42133g, getScope());
                m31589a(this.f42132f);
                m31642o();
                m31643p();
                m31580a(this.f42128a, this.f42129b, this.f42125N, this.f42126O);
                if ((TextUtils.equals(this.f42117F, "1") && !BusinessGuideManager.Companion.getInstance().isGuideWidgetShown()) || this.f42119H == 1) {
                    m31641n();
                }
            } catch (Exception e) {
                e.printStackTrace();
                ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_SHOP_CATE_ERROR).addModuleName("shop").addParam("shop_id", this.f42131e).addParam("errmsg", e.toString()).build().trackError();
                m31592a(ResourceHelper.getString(R.string.customer_global_no_data_available));
                m31576a("parseBusinessEntity error", "c-data|").setMessage(e.getMessage()).build().error();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public String m31640m() {
        BusinessEntity businessEntity;
        String str = this.f42149w;
        int i = this.f42150x;
        if (!((i != 2 && i != 3) || (businessEntity = this.f42132f) == null || businessEntity.shopInfo == null || this.f42132f.shopInfo.anchorInfo == null)) {
            str = this.f42132f.shopInfo.anchorInfo.itemUniqKey;
            if (TextUtils.isEmpty(str)) {
                str = this.f42132f.shopInfo.anchorInfo.itemId;
            }
        }
        if (getScope() != null && !TextUtils.isEmpty(str)) {
            getScope().attach(BlocksConst.ANCHOR_UNIQ_KEY, str);
        }
        return str;
    }

    /* renamed from: n */
    private void m31641n() {
        if (this.f42118G == null && getScopeContext() != null) {
            LogUtil.m32584d("BusinessLink", "subscribeAddress");
            this.f42118G = ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).subscribeAddressNoViscous(getScopeContext(), new Action1() {
                public final void call(Object obj) {
                    BusinessPresenter.this.m31590a((AddressEntity) obj);
                }
            });
        }
        m31651x();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m31590a(AddressEntity addressEntity) {
        m31629g();
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m31642o() {
        ((Contract.AbsBusinessView) getLogicView()).updateCategoryAmount(this.f42134h);
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (BusinessCategoryRvModel next : this.f42134h.values()) {
            if (!z) {
                next.isFirst = true;
                arrayList.add(next);
                z = true;
            } else {
                arrayList.add(next);
            }
            if (!CollectionsUtil.isEmpty(next.mGoodsItemList)) {
                for (BusinessGoodsItemRvModel next2 : next.mGoodsItemList) {
                    arrayList.add(next2);
                    this.f42135i.put(next2.mItemUniqKey, next2.mGoodsAmountModel);
                    this.f42136j.add(next2);
                }
            }
            if (!CollectionsUtil.isEmpty(next.mGoodsDynamicItemList)) {
                for (ComponentModel next3 : next.mGoodsDynamicItemList) {
                    arrayList.add(next3);
                    if (!(next3 == null || next3.getDataModel() == null || !(next3.getDataModel() instanceof BusinessGoodsItemRvModel))) {
                        BusinessGoodsItemRvModel businessGoodsItemRvModel = (BusinessGoodsItemRvModel) next3.getDataModel();
                        this.f42135i.put(businessGoodsItemRvModel.mItemUniqKey, businessGoodsItemRvModel.mGoodsAmountModel);
                        this.f42136j.add(businessGoodsItemRvModel);
                    }
                }
            }
            if (next.mExpandRvModel != null) {
                boolean z2 = false;
                for (BusinessGoodsItemRvModel next4 : next.mExpandRvModel.mExpandList) {
                    this.f42135i.put(next4.mItemUniqKey, next4.mGoodsAmountModel);
                    this.f42136j.add(next4);
                    if (this.f42148v == 1 && TextUtils.equals(next4.mGoodsId, this.f42149w)) {
                        z2 = true;
                    }
                }
                if (z2) {
                    next.mExpandRvModel.mIsExpand = true;
                    arrayList.addAll(next.mExpandRvModel.mExpandList);
                }
                arrayList.add(next.mExpandRvModel);
            }
        }
        arrayList.add(m31646s());
        ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager(arrayList);
        this.f42137k = createChildDataListManager;
        addDataManager(createChildDataListManager);
    }

    /* renamed from: p */
    private void m31643p() {
        AnchorInfoEntity anchorInfoEntity;
        BusinessGoodsItemRvModel businessGoodsItemRvModel;
        int i;
        BusinessEntity businessEntity = this.f42132f;
        if (businessEntity == null || businessEntity.shopInfo == null || this.f42132f.shopInfo.anchorInfo == null || !((i = this.f42150x) == 2 || i == 3)) {
            anchorInfoEntity = null;
        } else {
            anchorInfoEntity = this.f42132f.shopInfo.anchorInfo;
            int i2 = anchorInfoEntity.anchorStatus;
            if (i2 == 2) {
                this.f42149w = anchorInfoEntity.cateId;
                this.f42148v = 2;
            } else {
                if (!TextUtils.isEmpty(anchorInfoEntity.itemUniqKey)) {
                    this.f42149w = anchorInfoEntity.itemUniqKey;
                } else {
                    this.f42149w = anchorInfoEntity.itemId;
                }
                this.f42148v = 1;
            }
            if (anchorInfoEntity.reminder != null && !TextUtils.isEmpty(anchorInfoEntity.reminder.content)) {
                ToastUtil.showCustomerErrorToast(getScopeContext(), anchorInfoEntity.reminder.content);
            }
            if (i2 == 0) {
                this.f42126O = false;
                this.f42125N = false;
                return;
            }
        }
        m31644q();
        if (anchorInfoEntity != null && this.f42148v == 1 && anchorInfoEntity.setItemAction.intValue() == 1 && (businessGoodsItemRvModel = this.f42127P) != null) {
            if (!GoodsDataHelper.hasMultipleContents(BusinessDataHelper.findGoodEntity(this.f42132f, businessGoodsItemRvModel.mGoodsId, this.f42127P.mItemUniqKey)) && !this.f42127P.mNeedAlcoholRemind) {
                this.f42114C = true;
            }
            this.f42126O = true;
        }
    }

    /* renamed from: q */
    private void m31644q() {
        LinkedHashMap<String, BusinessCategoryRvModel> linkedHashMap = this.f42134h;
        if (linkedHashMap != null) {
            for (BusinessCategoryRvModel next : linkedHashMap.values()) {
                if (this.f42148v == 2) {
                    if (anchorCateGory(next)) {
                        break;
                    }
                }
                if (this.f42148v == 1) {
                    if (anchorItem(next, this.f42149w)) {
                        break;
                    }
                }
                if (this.f42129b >= 0) {
                    break;
                }
            }
            this.f42126O = this.f42150x == 1;
            this.f42125N = true;
            BusinessGoodsItemRvModel findGoodsItemRvModel = BusinessDataHelper.findGoodsItemRvModel(this.f42136j, this.f42151y);
            this.f42127P = findGoodsItemRvModel;
            if (findGoodsItemRvModel != null) {
                findGoodsItemRvModel.mIsAnchorItem = true;
            }
        }
    }

    public boolean anchorCateGory(BusinessCategoryRvModel businessCategoryRvModel) {
        if (businessCategoryRvModel == null) {
            return false;
        }
        if (this.f42149w.equals(businessCategoryRvModel.mCategoryId)) {
            int i = businessCategoryRvModel.mCategoryIndex;
            this.f42128a = i;
            this.f42129b = getCategoryRvIndex(i);
            return true;
        }
        List<ComponentModel> allDyDisplayGoods = businessCategoryRvModel.getAllDyDisplayGoods();
        if (!CollectionsUtil.isEmpty(allDyDisplayGoods)) {
            ComponentModel findGoodItemRvFromComponent = BusinessDataHelper.findGoodItemRvFromComponent(allDyDisplayGoods, this.f42149w);
            this.f42128a = businessCategoryRvModel.mCategoryIndex;
            int indexOf = this.f42137k.indexOf(findGoodItemRvFromComponent);
            this.f42129b = indexOf;
            if (indexOf > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean anchorItem(BusinessCategoryRvModel businessCategoryRvModel, String str) {
        if (businessCategoryRvModel == null) {
            return false;
        }
        List<BusinessGoodsItemRvModel> allDisplayGoods = businessCategoryRvModel.getAllDisplayGoods();
        if (!CollectionsUtil.isEmpty(allDisplayGoods)) {
            for (BusinessGoodsItemRvModel next : allDisplayGoods) {
                if (str.equals(next.mGoodsId)) {
                    this.f42128a = businessCategoryRvModel.mCategoryIndex;
                    this.f42129b = this.f42137k.indexOf(next);
                    return true;
                }
            }
        }
        List<ComponentModel> allDyDisplayGoods = businessCategoryRvModel.getAllDyDisplayGoods();
        if (!CollectionsUtil.isEmpty(allDyDisplayGoods)) {
            ComponentModel findGoodItemRvFromComponent = BusinessDataHelper.findGoodItemRvFromComponent(allDyDisplayGoods, str);
            if (findGoodItemRvFromComponent != null) {
                this.f42128a = businessCategoryRvModel.mCategoryIndex;
                this.f42129b = this.f42137k.indexOf(findGoodItemRvFromComponent);
                return true;
            }
            this.f42129b = -1;
        }
        return false;
    }

    /* renamed from: a */
    private void m31580a(int i, int i2, boolean z, boolean z2) {
        if (z2 && m31645r()) {
            m31588a(this.f42127P, false);
        }
        this.f42127P = null;
        if (i != 0 || i2 > 0) {
            if (z) {
                ((Contract.AbsBusinessView) getLogicView()).anchorView(i, i2, (BusinessGoodsItemRvModel) null);
            }
            this.f42128a = 0;
            this.f42129b = -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r2.f42132f;
     */
    /* renamed from: r */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m31645r() {
        /*
            r2 = this;
            com.didi.soda.business.model.BusinessGoodsItemRvModel r0 = r2.f42127P
            r1 = 1
            if (r0 == 0) goto L_0x0016
            com.didi.soda.customer.foundation.rpc.entity.BusinessEntity r0 = r2.f42132f
            if (r0 == 0) goto L_0x0016
            com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity r0 = r0.shopInfo
            if (r0 == 0) goto L_0x0016
            com.didi.soda.customer.foundation.rpc.entity.BusinessEntity r0 = r2.f42132f
            com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity r0 = r0.shopInfo
            int r0 = r0.cShopStatus
            if (r0 != r1) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r1 = 0
        L_0x0017:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.business.component.dynamic.BusinessPresenter.m31645r():boolean");
    }

    /* renamed from: a */
    private void m31589a(BusinessEntity businessEntity) {
        if (businessEntity.shopInfo != null) {
            m31579a(businessEntity.shopInfo.cShopStatus);
            BusinessState state = ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).getState(this.f42131e);
            if (state == null) {
                state = new BusinessState();
            }
            state.shopId = businessEntity.shopInfo.shopId;
            state.shopStatus = businessEntity.shopInfo.cShopStatus;
            state.shopStatusDesc = businessEntity.shopInfo.cShopStatusDesc;
            state.nextBizTimeDesc = businessEntity.shopInfo.nextBizTimeDesc;
            if (this.f42112A == 1) {
                state.mHasShowedWineRemind = true;
            }
            state.mWineConfirmDesc = businessEntity.shopInfo.wineConfirmDesc;
            ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).setValue(state);
        }
    }

    /* renamed from: s */
    private CustomerDividerLineRvModel m31646s() {
        return new CustomerDividerLineRvModel(DisplayUtils.dip2px(getContext(), 220.0f), 0, 0, getContext().getResources().getColor(R.color.rf_color_gery_7_97_F5F5F7));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31579a(int i) {
        m31576a("Business status changed... old: " + this.f42141o + " new: " + i, "c-show|").build().info();
        this.f42141o = i;
        m31648u().updateBusinessStatus(i);
        m31647t();
    }

    /* renamed from: t */
    private void m31647t() {
        ChildDataListManager<RecyclerModel> childDataListManager = this.f42137k;
        if (childDataListManager != null && childDataListManager.size() > 0) {
            int size = this.f42137k.size();
            GoodsAmountModel[] goodsAmountModelArr = new GoodsAmountModel[1];
            for (int i = 0; i < size; i++) {
                if (this.f42137k.get(i) instanceof BusinessGoodsItemRvModel) {
                    BusinessGoodsItemRvModel businessGoodsItemRvModel = (BusinessGoodsItemRvModel) this.f42137k.get(i);
                    goodsAmountModelArr[0] = this.f42135i.get(businessGoodsItemRvModel.mItemUniqKey);
                    if (goodsAmountModelArr[0] != null) {
                        goodsAmountModelArr[0].mGoodsItemState = GoodsDataHelper.getGoodsItemState(businessGoodsItemRvModel.mStatus, businessGoodsItemRvModel.mSoldStatus, this.f42141o);
                        businessGoodsItemRvModel.mGoodsAmountModel = goodsAmountModelArr[0];
                        this.f42137k.set(i, businessGoodsItemRvModel);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = r0.f42132f;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m31596a(boolean r1) {
        /*
            r0 = this;
            if (r1 == 0) goto L_0x0018
            com.didi.soda.customer.foundation.rpc.entity.BusinessEntity r1 = r0.f42132f
            if (r1 == 0) goto L_0x0018
            com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity r1 = r1.shopInfo
            if (r1 == 0) goto L_0x0018
            com.didi.soda.customer.foundation.rpc.entity.BusinessEntity r1 = r0.f42132f
            com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity r1 = r1.shopInfo
            int r1 = r1.wineConfirm
            if (r1 != 0) goto L_0x0018
            boolean r1 = r0.f42113B
            if (r1 != 0) goto L_0x0018
            r1 = 1
            goto L_0x0019
        L_0x0018:
            r1 = 0
        L_0x0019:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.business.component.dynamic.BusinessPresenter.m31596a(boolean):boolean");
    }

    /* renamed from: u */
    private BusinessOmegaHelper m31648u() {
        if (this.f42144r == null) {
            this.f42144r = new BusinessOmegaHelper(getScopeContext(), this.f42131e, this.f42141o);
        }
        return this.f42144r;
    }

    /* renamed from: v */
    private boolean m31649v() {
        if (this.f42132f != null) {
            return false;
        }
        m31576a("businessEntityIsNull", "c-data|").build().info();
        return true;
    }

    /* renamed from: w */
    private void m31650w() {
        m31648u().onShow(this.f42145s.mDistance, this.f42145s.mDeliveryFee, this.f42145s.mDeliveryTime, this.f42145s.mExposureActivityNum, this.f42145s.mTabTypeList, this.f42145s.mDeliveryType, this.f42145s.mRecId, getBusinessSourceType(), this.f42145s.mIsCouponLogo, this.f42145s.mTraceId, this.f42145s.couponNum, this.f42145s.mIsMarketArea);
        AppsFlyerTrackHelper.trackViewRestaurant(getContext());
        FirebaseAnalyticsHelper.trackViewRestaurant(getContext());
    }

    /* renamed from: x */
    private void m31651x() {
        BusinessEntity businessEntity;
        if (getScopeContext() != null && (businessEntity = this.f42132f) != null && businessEntity.shopInfo != null) {
            int businessDialogSourceType = getBusinessDialogSourceType();
            int i = this.f42132f.shopInfo.cShopStatus;
            if (i != 2) {
                if (i == 3) {
                    AddressEntity delieveryAddress = ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getDelieveryAddress();
                    BusinessDialogHelper.showBusinessOutSideDialog(getScopeContext().getNavigator(), AddressUtil.checkAddressValid(delieveryAddress) ? delieveryAddress.getBusinessDepartPoi() : "", new Function0(businessDialogSourceType) {
                        public final /* synthetic */ int f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final Object invoke() {
                            return BusinessPresenter.this.m31617d(this.f$1);
                        }
                    }, new Function0(businessDialogSourceType) {
                        public final /* synthetic */ int f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final Object invoke() {
                            return BusinessPresenter.this.m31611c(this.f$1);
                        }
                    }, new Function0(businessDialogSourceType) {
                        public final /* synthetic */ int f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final Object invoke() {
                            return BusinessPresenter.this.m31598b(this.f$1);
                        }
                    });
                    m31648u().onOutsideDeliveryPopupSw(businessDialogSourceType);
                    return;
                } else if (!(i == 4 || i == 5)) {
                    return;
                }
            }
            BusinessDialogHelper.showBusinessClosedsDialog(getScopeContext(), getContext(), this.f42132f.shopInfo.nextBizTimeDesc, new Function0(businessDialogSourceType) {
                public final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final Object invoke() {
                    return BusinessPresenter.this.m31626f(this.f$1);
                }
            }, new Function0(businessDialogSourceType) {
                public final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final Object invoke() {
                    return BusinessPresenter.this.m31620e(this.f$1);
                }
            });
            m31648u().onOutsideClosePopupSw(businessDialogSourceType);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ Unit m31626f(int i) {
        getScopeContext().getNavigator().popToRoot();
        m31648u().onOutsideClosePopupCk(1, i);
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ Unit m31620e(int i) {
        m31648u().onOutsideClosePopupCk(2, i);
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ Unit m31617d(int i) {
        DiRouter.request().path(RoutePath.ADDRESS_HOME).putInt("from", 8).open();
        m31648u().onOutsideDeliveryPopupCk(1, i);
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ Unit m31611c(int i) {
        getScopeContext().getNavigator().popToRoot();
        m31648u().onOutsideDeliveryPopupCk(2, i);
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ Unit m31598b(int i) {
        m31648u().onOutsideDeliveryPopupCk(3, i);
        return null;
    }

    /* renamed from: b */
    private void m31602b(BusinessGoodsItemRvModel businessGoodsItemRvModel, boolean z) {
        BusinessCategoryRvModel businessCategoryRvModel;
        if (businessGoodsItemRvModel != null) {
            OmegaCommonParamHelper.setLv3RecId(this.f42145s.mRecId);
            OmegaCommonParamHelper.setLv3Body(StringUtils.SP_DATA_ITEM + businessGoodsItemRvModel.mGoodsId);
            LinkedHashMap<String, BusinessCategoryRvModel> linkedHashMap = this.f42134h;
            if (linkedHashMap != null && (businessCategoryRvModel = linkedHashMap.get(businessGoodsItemRvModel.mCateId)) != null) {
                OmegaCommonParamHelper.setLv3Location("shop" + "_" + businessCategoryRvModel.mCategoryId + "_" + 0 + "_" + businessCategoryRvModel.mCategoryIndex + "_" + 0 + "_" + businessGoodsItemRvModel.mInCategoryIndex + "_" + 0 + "_" + (z ? 1 : 0));
            }
        }
    }

    /* renamed from: a */
    private void m31593a(String str, BusinessGoodsItemRvModel businessGoodsItemRvModel, int i, int i2) {
        m31648u().onGoodsItemClick(str, businessGoodsItemRvModel, i, i2, this.f42145s);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public RecordTracker.Builder m31615d(String str) {
        return m31576a(str, (String) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public RecordTracker.Builder m31576a(String str, String str2) {
        return RecordTracker.Builder.create().setTag(f42111c).setLogModule("m-business|").setMessage(str).setLogCategory(str2).setOtherParam("business_id", this.f42131e).setOtherParam("business_status", Integer.valueOf(this.f42141o));
    }

    /* access modifiers changed from: protected */
    public void registerScopeActions(IBlockScope iBlockScope) {
        iBlockScope.registerAction(BusinessDeliveryFeeTipsManager.TIPS_EVENT_NAME, new Function4() {
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BusinessPresenter.this.m31625f((Context) obj, (IBlockScope) obj2, (HashMap) obj3, (Buildable) obj4);
            }
        });
        iBlockScope.registerAction(BlocksConst.SCOPE_ACTION_TYPE_OPEN_SHOP_DETAIL, new Function4() {
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BusinessPresenter.this.m31619e((Context) obj, (IBlockScope) obj2, (HashMap) obj3, (Buildable) obj4);
            }
        });
        iBlockScope.registerAction(BlocksConst.SCOPE_ACTION_ON_GOOD_ADD, new Function4() {
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BusinessPresenter.this.m31614d((Context) obj, (IBlockScope) obj2, (HashMap) obj3, (Buildable) obj4);
            }
        });
        iBlockScope.registerAction(BlocksConst.SCOPE_ACTION_ON_GOOD_MINUS, new Function4() {
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BusinessPresenter.this.m31608c((Context) obj, (IBlockScope) obj2, (HashMap) obj3, (Buildable) obj4);
            }
        });
        iBlockScope.registerAction(BlocksConst.SCOPE_ACTION_GOOD_ITEM_CLICK, new Function4() {
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BusinessPresenter.this.m31597b((Context) obj, (IBlockScope) obj2, (HashMap) obj3, (Buildable) obj4);
            }
        });
        iBlockScope.registerAction(BlocksConst.SCOPE_ACTION_GOOD_ITEM_EXPOSURE, new Function4() {
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BusinessPresenter.this.m31574a((Context) obj, (IBlockScope) obj2, (HashMap) obj3, (Buildable) obj4);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ ActionResult m31625f(Context context, IBlockScope iBlockScope, HashMap hashMap, Buildable buildable) {
        ((Contract.AbsBusinessView) getLogicView()).showDeliveryFeeDescRule(hashMap, buildable.getView());
        return ActionResult.resolve();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ ActionResult m31619e(Context context, IBlockScope iBlockScope, HashMap hashMap, Buildable buildable) {
        goBusinessDetail();
        return ActionResult.resolve();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ ActionResult m31614d(Context context, IBlockScope iBlockScope, HashMap hashMap, Buildable buildable) {
        BusinessGoodsItemRvModel goodRvModelFromParam = BusinessDataHelper.getGoodRvModelFromParam(hashMap, buildable);
        if (goodRvModelFromParam != null) {
            ItemState mainGoodState = this.f42138l.getMainGoodState(this.f42131e, goodRvModelFromParam.mItemUniqKey);
            if (mainGoodState != null) {
                mainGoodState.amount++;
            }
            goodRvModelFromParam.mGoodsAmountModel.updateGoodsItemAmountModel(mainGoodState);
            Buildable findWidgetByComponentId = buildable.findWidgetByComponentId(BlocksConst.COMPONENT_ID_BUSINESS_DISH_IMAGE, 1);
            if (!(findWidgetByComponentId == null || findWidgetByComponentId.getView() == null)) {
                ((Contract.AbsBusinessView) getLogicView()).setCurrentVirView(findWidgetByComponentId.getView(), goodRvModelFromParam.mHeadImg);
                if (!goodRvModelFromParam.hasMultipleContents && goodRvModelFromParam.mHasWine != 1 && !BusinessDataHelper.isNeedReloadSubitem(goodRvModelFromParam) && !BusinessDataHelper.isNeedReloadSubitem(this.f42132f.shopInfo)) {
                    ((Contract.AbsBusinessView) getLogicView()).playAdd2CartAnim();
                }
            }
            onGoodsAddClick(goodRvModelFromParam);
        }
        return ActionResult.resolve();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ ActionResult m31608c(Context context, IBlockScope iBlockScope, HashMap hashMap, Buildable buildable) {
        String str;
        BusinessGoodsItemRvModel goodRvModelFromParam = BusinessDataHelper.getGoodRvModelFromParam(hashMap, buildable);
        CartInfoModel cartInfoModel = this.f42124M;
        if (cartInfoModel == null) {
            return ActionResult.resolve();
        }
        String cartId = cartInfoModel.getCartId();
        if (goodRvModelFromParam != null) {
            ItemState mainGoodState = this.f42138l.getMainGoodState(this.f42131e, goodRvModelFromParam.mItemUniqKey);
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
    public /* synthetic */ ActionResult m31597b(Context context, IBlockScope iBlockScope, HashMap hashMap, Buildable buildable) {
        BusinessGoodsItemRvModel goodRvModelFromParam = BusinessDataHelper.getGoodRvModelFromParam(hashMap, buildable);
        if (goodRvModelFromParam == null) {
            return ActionResult.reject();
        }
        Buildable findWidgetByComponentId = buildable.findWidgetByComponentId(BlocksConst.COMPONENT_ID_BUSINESS_DISH_IMAGE, 1);
        if (!(findWidgetByComponentId == null || findWidgetByComponentId.getView() == null)) {
            ((Contract.AbsBusinessView) getLogicView()).setCurrentVirView(findWidgetByComponentId.getView(), goodRvModelFromParam.mHeadImg);
        }
        onGoodsItemClick(goodRvModelFromParam);
        return ActionResult.resolve();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ ActionResult m31574a(Context context, IBlockScope iBlockScope, HashMap hashMap, Buildable buildable) {
        BusinessGoodsItemRvModel goodRvModelFromParam = BusinessDataHelper.getGoodRvModelFromParam(hashMap, buildable);
        if (goodRvModelFromParam == null) {
            return ActionResult.reject();
        }
        onGoodsItemExposure(goodRvModelFromParam);
        return ActionResult.resolve();
    }

    /* renamed from: a */
    private int m31573a(HashMap<String, Object> hashMap) {
        if (hashMap == null || hashMap.get(BlocksConst.SCOPE_ACTION_PARAM_GOOD_NEXT_VALUE) == null) {
            return 0;
        }
        return ((Integer) hashMap.get(BlocksConst.SCOPE_ACTION_PARAM_GOOD_NEXT_VALUE)).intValue();
    }

    /* renamed from: e */
    private void m31622e(String str) {
        LogUtil.m32584d(f42111c, str);
    }
}
