package com.didi.soda.goodsV2.component.purchase;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Action2;
import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataItemManager;
import com.didi.flutter.nacho2.p116v2.NachoLifecycleManager;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.didi.rfusion.widget.floating.IRFFloatingExpand;
import com.didi.soda.business.manager.BusinessDataHelper;
import com.didi.soda.business.model.BusinessActionParam;
import com.didi.soda.cart.model.BusinessState;
import com.didi.soda.cart.model.SetItemAmountParams;
import com.didi.soda.cart.model.SetItemParams;
import com.didi.soda.cart.repo.BusinessStateRepo;
import com.didi.soda.cart.repo.CartItemStateRepo;
import com.didi.soda.cart.repo.CheckCartMaxNumKt;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.GoodsSubItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillAddTyingEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillDelItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillRefreshEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillUpdateParams;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartItemEntity;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.foundation.tracker.AppsFlyerTrackHelper;
import com.didi.soda.customer.foundation.tracker.FirebaseAnalyticsHelper;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.helper.ToastActionHelper;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.repo.model.ItemState;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalFactory;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalViewModel;
import com.didi.soda.goods.repo.SelectItemState;
import com.didi.soda.goods.repo.SelectSubItemState;
import com.didi.soda.goodsV2.binder.EmptyHeightBinder;
import com.didi.soda.goodsV2.binder.logic.PurchaseSubItemLogicRepo;
import com.didi.soda.goodsV2.component.purchase.Contract;
import com.didi.soda.goodsV2.contract.GoodsAmountModel;
import com.didi.soda.goodsV2.helper.GoodsDataHelper;
import com.didi.soda.goodsV2.helper.GoodsOmegaHelper;
import com.didi.soda.goodsV2.helper.GoodsPurchaseOmegaModel;
import com.didi.soda.goodsV2.manager.GoodsDetailRepo;
import com.didi.soda.goodsV2.model.GoodsPurchaseContentRvModel;
import com.didi.soda.goodsV2.model.GoodsPurchaseCounterRvModel;
import com.didi.soda.goodsV2.model.GoodsPurchaseHeaderRvModel;
import com.didi.soda.goodsV2.model.GoodsPurchaseSubItemRvModel;
import com.didi.soda.goodsV2.parser.SelectItemStateParser;
import com.didi.soda.goodsV2.price.BuyGiftGoodsPriceCalculator;
import com.didi.soda.goodsV2.price.GoodsPriceCalculator;
import com.didi.soda.goodsV2.price.NoOpGoodsPriceCalculator;
import com.didi.soda.goodsV2.price.NormalGoodsPriceCalculator;
import com.didi.soda.goodsV2.price.SpecialGoodsPriceCalculator;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerBillManager;
import com.didi.soda.manager.base.ICustomerBusinessManager;
import com.didi.soda.manager.base.ICustomerCartManager;
import com.didi.soda.manager.base.ICustomerGoodsManager;
import com.taxis99.R;
import didinet.Logger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class GoodsPurchasePresenter extends Contract.AbsGoodsPurchasePresenter implements IRFFloatingExpand {

    /* renamed from: a */
    private static final String f44938a = "GoodsPurchasePresenter";

    /* renamed from: A */
    private boolean f44939A = false;

    /* renamed from: B */
    private String f44940B;

    /* renamed from: C */
    private GoodsDetailRepo f44941C;

    /* renamed from: D */
    private Subscription f44942D;

    /* renamed from: E */
    private ActInfoEntity f44943E;

    /* renamed from: F */
    private int f44944F = -1;

    /* renamed from: G */
    private boolean f44945G;

    /* renamed from: H */
    private String f44946H;

    /* renamed from: I */
    private int f44947I = -1;

    /* renamed from: b */
    private CartItemEntity f44948b;

    /* renamed from: c */
    private GoodsItemEntity f44949c;

    /* renamed from: d */
    private boolean f44950d = false;

    /* renamed from: e */
    private GoodsPurchaseCounterRvModel f44951e;

    /* renamed from: f */
    private GoodsAmountModel f44952f;

    /* renamed from: g */
    private String f44953g;

    /* renamed from: h */
    private String f44954h;

    /* renamed from: i */
    private String f44955i;

    /* renamed from: j */
    private int f44956j;

    /* renamed from: k */
    private int f44957k;

    /* renamed from: l */
    private String f44958l = "";

    /* renamed from: m */
    private String f44959m;

    /* renamed from: n */
    private String f44960n = "";

    /* renamed from: o */
    private int f44961o = 0;

    /* renamed from: p */
    private int f44962p;

    /* renamed from: q */
    private int f44963q = 1;

    /* renamed from: r */
    private boolean f44964r = false;

    /* renamed from: s */
    private boolean f44965s;

    /* renamed from: t */
    private int f44966t;

    /* renamed from: u */
    private int f44967u = Integer.MAX_VALUE;

    /* renamed from: v */
    private int f44968v;

    /* renamed from: w */
    private GoodsOmegaHelper f44969w;

    /* renamed from: x */
    private String f44970x;

    /* renamed from: y */
    private String f44971y;

    /* renamed from: z */
    private String f44972z = "";

    /* renamed from: d */
    private String m33325d(String str) {
        return str == null ? "" : str;
    }

    public void exceedMaxAmount(int i) {
        ((Contract.AbsGoodsPurchaseView) getLogicView()).exceedMaxAmount(i);
    }

    public void exceedMaxSaleAmount(int i) {
        ((Contract.AbsGoodsPurchaseView) getLogicView()).exceedMaxSaleAmount(i);
    }

    public void exceedMinAmount() {
        ((Contract.AbsGoodsPurchaseView) getLogicView()).exceedMinAmount();
    }

    public void onAddCartViewClicked(boolean z) {
        if (!z) {
            anchorToUnSatisfiedContent();
        } else if (this.f44950d) {
            m33313a(this.f44940B);
        } else {
            m33307a();
        }
    }

    public void replaceSubItemState(SelectSubItemState selectSubItemState) {
        SelectItemStateParser.replaceSubItemState(this.mStateUniqueId, (SelectSubItemState) null, selectSubItemState);
    }

    public SelectSubItemState findSelectSubItemState(String str) {
        return SelectItemStateParser.getSubItemState(this.mStateUniqueId, getLevel(), str);
    }

    public void onCloseClicked() {
        KeyboardUtils.hideSoftInput(getContext(), (View) null);
        super.onCloseClicked();
    }

    public void onSelectionStateChanged(String str, String str2, boolean z) {
        super.onSelectionStateChanged(str, str2, z);
        GoodsPurchaseOmegaModel goodsPurchaseOmegaModel = this.mGoodsPurchaseOmegaModel;
        GoodsItemEntity goodsItemEntity = this.f44949c;
        m33347t().onSubItemClick(goodsPurchaseOmegaModel.mCurContentId, goodsPurchaseOmegaModel.mCurContentType, goodsPurchaseOmegaModel.mValidSubItemIdMap.get(str), goodsPurchaseOmegaModel.mInvalidSubItemIdMap.get(str), goodsPurchaseOmegaModel.mCurSelectedSubItemId, goodsPurchaseOmegaModel.mSelectType, goodsPurchaseOmegaModel.mCurContentIsMust, goodsPurchaseOmegaModel.mCurSelectedSubItemType, goodsPurchaseOmegaModel.mIsMultiLevel, (goodsItemEntity == null || goodsItemEntity.node == null) ? 0 : this.f44949c.node.totalLevel);
    }

    /* access modifiers changed from: protected */
    public void onMultiPageEnter(PurchaseSubItemLogicRepo.PurchaseSubItemLogicModel purchaseSubItemLogicModel) {
        m33347t().trackEntreMultiPage(purchaseSubItemLogicModel.rvModel.mSubItemId);
    }

    public void onAddGoodsClick(String str, View view, Bundle bundle) {
        if (this.f44952f != null) {
            m33305a("onAddGoodsClick", "c-act|").build().info();
            this.f44952f.increaseAmount(1);
            m33332f();
            this.f44951e.mBuyTip = m33341n();
            this.f44951e.mReceviedGiftLimit = m33344q();
            ((Contract.AbsGoodsPurchaseView) getLogicView()).bindGoodsPurchaseCounter(this.f44951e, this);
            changeOfflinePrice();
            ((Contract.AbsGoodsPurchaseView) getLogicView()).changeAddCartText(m33345r());
        }
    }

    public void onSubtractGoodsClick(String str, Bundle bundle) {
        if (this.f44952f != null) {
            m33305a("onSubtractGoodsClick", "c-act|").build().info();
            this.f44952f.decreaseAmount(1);
            m33332f();
            this.f44951e.mBuyTip = m33341n();
            this.f44951e.mReceviedGiftLimit = m33344q();
            ((Contract.AbsGoodsPurchaseView) getLogicView()).bindGoodsPurchaseCounter(this.f44951e, this);
            changeOfflinePrice();
            ((Contract.AbsGoodsPurchaseView) getLogicView()).changeAddCartText(m33345r());
        }
    }

    public void onBack(Bundle bundle) {
        KeyboardUtils.hideSoftInput(getContext(), (View) null);
        if (bundle != null) {
            dismiss(getScopeContext(), bundle);
        } else {
            dismiss(getScopeContext());
        }
    }

    public void onCreate() {
        super.onCreate();
        m33305a(NachoLifecycleManager.LIFECYCLE_ON_CREATE, "c-state|").build().info();
        m33333g();
        m33337j();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        m33305a(NachoLifecycleManager.LIFECYCLE_ON_DESTROY, "c-state|").build().info();
        ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).clearSelectItemState(this.mStateUniqueId);
        GoodsItemEntity goodsItemEntity = this.f44949c;
        m33347t().onPurchaseExit(this.mGoodsPurchaseOmegaModel.mHasMultiContents, this.mGoodsPurchaseOmegaModel.mRequiredSelections, this.mGoodsPurchaseOmegaModel.mUnRequiredSelections, (goodsItemEntity == null || goodsItemEntity.node == null) ? 0 : this.f44949c.node.totalLevel);
    }

    /* access modifiers changed from: protected */
    public void changeOfflinePrice() {
        if (!this.notNeedClientCal) {
            if (this.mGoodsPriceCalculator == null) {
                m33305a("mGoodsPriceCalculator == null", "c-show|").build().info();
                return;
            }
            List<SelectSubItemState> filterCalculatePriceStates = SelectItemStateParser.filterCalculatePriceStates(this.mSelectedSubItemStates.values());
            int calculateCurPriceWithStates = this.mGoodsPriceCalculator.calculateCurPriceWithStates(filterCalculatePriceStates, this.f44952f.getCurrentAmount(), this.f44967u);
            int calculateOriPriceWithStates = this.mGoodsPriceCalculator.calculateOriPriceWithStates(filterCalculatePriceStates, this.f44952f.getCurrentAmount());
            if (calculateCurPriceWithStates < 0 || calculateOriPriceWithStates < 0) {
                m33334g("price < 0 , not legal");
                calculateOriPriceWithStates = 0;
                calculateCurPriceWithStates = 0;
            }
            m33305a("changeOfflinePrice:{cur:" + calculateCurPriceWithStates + "},{ori:" + calculateOriPriceWithStates + "}", "c-show|").build().info();
            ((Contract.AbsGoodsPurchaseView) getLogicView()).changeOfflinePrice(calculateCurPriceWithStates, calculateOriPriceWithStates, this.f44949c.currency);
        }
    }

    /* access modifiers changed from: protected */
    public int getLevel() {
        return this.f44949c.node.level + 1;
    }

    /* access modifiers changed from: protected */
    public GoodsSubItemEntity findSubItemEntity(String str, String str2) {
        return GoodsDataHelper.findGoodsSubItemEntity(this.f44949c, str, str2);
    }

    /* access modifiers changed from: protected */
    public void changeAddCartViewState() {
        if (!this.f44939A || this.f44952f.getCurrentAmount() != 0) {
            super.changeAddCartViewState();
            return;
        }
        m33305a("reduce amount to 0, enable add view", "c-act|").build().info();
        ((Contract.AbsGoodsPurchaseView) getLogicView()).enableAddCartView();
    }

    /* renamed from: a */
    private void m33307a() {
        ArrayList<ItemNodeEntity> mapStateRepoToCartParams = SelectItemStateParser.mapStateRepoToCartParams(this.mStateUniqueId);
        int i = this.f44962p;
        if (i == 4) {
            m33326d((List<ItemNodeEntity>) mapStateRepoToCartParams);
        } else if (i == 9) {
            m33330e((List<ItemNodeEntity>) mapStateRepoToCartParams);
        } else if (this.f44965s) {
            m33320b((List<ItemNodeEntity>) mapStateRepoToCartParams);
        } else if (m33321b()) {
            m33314a(mapStateRepoToCartParams);
        } else {
            m33323c((List<ItemNodeEntity>) mapStateRepoToCartParams);
        }
        m33315a((List<ItemNodeEntity>) mapStateRepoToCartParams);
    }

    /* renamed from: b */
    private boolean m33321b() {
        return this.f44961o == 1;
    }

    /* renamed from: c */
    private boolean m33324c() {
        return this.f44961o == 1;
    }

    /* renamed from: d */
    private boolean m33327d() {
        return this.f44961o == 1;
    }

    /* renamed from: a */
    private void m33315a(List<ItemNodeEntity> list) {
        m33305a("Add to cart: {selected:" + list.toString() + "},{amount:" + this.f44952f.getCurrentAmount() + "},{isUpdate:" + this.f44965s + "}", "c-act|").build().info();
        AppsFlyerTrackHelper.trackAddCart(getContext());
        FirebaseAnalyticsHelper.trackAddCart(getContext());
    }

    /* renamed from: a */
    private void m33313a(String str) {
        m33305a("show alcohol", "c-act|").build().info();
        DialogUtil.showAlcoholRemindDialog(getScopeContext().getNavigator(), new RFDialogInterface.OnClickListener() {
            public final void onClick(RFDialog rFDialog) {
                GoodsPurchasePresenter.this.m33318b(rFDialog);
            }
        }, new RFDialogInterface.OnClickListener() {
            public final void onClick(RFDialog rFDialog) {
                GoodsPurchasePresenter.this.m33310a(rFDialog);
            }
        }, getContext().getString(R.string.customer_goods_detail_alcohol_remind_dialog_title), str);
        m33347t().onOrderDialogSw();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m33318b(RFDialog rFDialog) {
        m33305a("click alcohol confirm", "c-act|").build().info();
        m33328e();
        this.f44964r = true;
        m33307a();
        m33347t().onOrderDialogConfirmCk();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33310a(RFDialog rFDialog) {
        m33347t().onOrderDialogCancelCk();
    }

    /* renamed from: e */
    private void m33328e() {
        this.f44950d = false;
        BusinessState state = ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).getState(this.f44959m);
        if (state != null) {
            state.mHasShowedWineRemind = true;
            ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).setValue(state);
        }
    }

    /* renamed from: f */
    private void m33332f() {
        SelectItemState selectItemState = ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).getSelectItemState(this.mStateUniqueId);
        if (selectItemState != null) {
            selectItemState.node.amount = this.f44952f.getCurrentAmount();
            selectItemState.maxSale = this.f44967u;
        }
        if (this.f44939A) {
            changeAddCartViewState();
        }
    }

    /* renamed from: g */
    private void m33333g() {
        String str = "";
        this.f44960n = getScopeContext().getBundle().getString(Const.PageParams.BIDATA, str);
        this.f44959m = getScopeContext().getBundle().getString(Const.PageParams.SHOP_ID);
        this.f44953g = getScopeContext().getBundle().getString(Const.PageParams.ITEM_ID);
        this.f44954h = getScopeContext().getBundle().getString(Const.PageParams.ITEM_UNIQ_KEY);
        this.f44955i = getScopeContext().getBundle().getString(Const.PageParams.KEY_CATE_ID);
        if (this.f44954h == null) {
            this.f44954h = this.f44953g;
        }
        this.f44949c = (GoodsItemEntity) getScopeContext().getBundle().getSerializable(Const.PageParams.ITEM_ENTITY);
        this.f44948b = (CartItemEntity) getScopeContext().getBundle().getSerializable(Const.PageParams.CART_ITEM_ENTITY);
        this.f44962p = getScopeContext().getBundle().getInt("from");
        this.f44946H = getScopeContext().getBundle().getString("is_item_merge", "0");
        this.f44950d = getScopeContext().getBundle().getBoolean(Const.PageParams.ITEM_NEED_SHOW_ALCOHOL_REMIND);
        this.f44970x = getScopeContext().getBundle().getString(Const.PageParams.CART_REVISION, str);
        this.f44971y = getScopeContext().getBundle().getString("cart_id", str);
        this.f44944F = getScopeContext().getBundle().getInt(ParamConst.PARAM_TAB_LOCATION, -1);
        this.f44947I = getScopeContext().getBundle().getInt(ParamConst.PARAM_ITEM_LOCATION, -1);
        boolean z = false;
        this.f44961o = getScopeContext().getBundle().getInt("source", 0);
        if (this.f44948b != null) {
            z = true;
        }
        this.f44965s = z;
        CartItemEntity cartItemEntity = this.f44948b;
        if (cartItemEntity != null) {
            str = cartItemEntity.getMduId();
        }
        this.f44972z = str;
        GoodsItemEntity goodsItemEntity = this.f44949c;
        if (goodsItemEntity != null) {
            this.notNeedClientCal = goodsItemEntity.notNeedClientCal;
            this.allowOverAmount = this.f44949c.allowOverAmount;
        }
        try {
            this.f44943E = (ActInfoEntity) GsonUtil.fromJson(getScopeContext().getBundle().getString(Const.PageParams.ACT_INFO), ActInfoEntity.class);
        } catch (Exception unused) {
            LogUtil.m32588i(f44938a, "actInfoStr parse error: $e|$actInfoStr");
        }
        m33336i();
        m33335h();
    }

    /* renamed from: h */
    private void m33335h() {
        int i = this.f44962p;
        this.f44939A = i == 4 || i == 3;
        m33305a("initCanBZero: mCanDownToZero" + this.f44939A, "c-data|").build().info();
    }

    /* renamed from: i */
    private void m33336i() {
        m33305a("params: from:" + this.f44962p + " alcohol:" + this.f44950d + " cartRevision:" + this.f44970x + " cartId:" + this.f44971y + " mduId:" + this.f44972z, "c-data|").build().info();
    }

    /* renamed from: j */
    private void m33337j() {
        if (this.f44949c != null) {
            m33305a("data not null", "c-data|").build().info();
            m33338k();
            return;
        }
        m33305a("request goods data", "c-data|").build().info();
        if (this.f44941C == null) {
            this.f44941C = new GoodsDetailRepo();
        }
        DialogUtil.showLoadingDialog(getScopeContext(), false);
        ((Contract.AbsGoodsPurchaseView) getLogicView()).hideBottomButton();
        if (this.f44965s) {
            this.f44941C.requestGoodsDetail(this.f44959m, this.f44953g, this.f44948b.getMduId(), this.f44971y, this.f44961o, this.f44943E);
        } else {
            this.f44941C.requestGoodsDetail(this.f44959m, this.f44953g, "", "", this.f44961o, this.f44943E);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        GoodsDetailRepo goodsDetailRepo;
        super.onResume();
        if (this.f44942D == null && (goodsDetailRepo = this.f44941C) != null) {
            this.f44942D = goodsDetailRepo.subscribe(getScopeContext(), new Action1() {
                public final void call(Object obj) {
                    GoodsPurchasePresenter.this.m33311a((CustomerResource) obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33311a(CustomerResource customerResource) {
        DialogUtil.hideLoadingDialog();
        if (customerResource == null) {
            m33319b(ResourceHelper.getString(R.string.customer_get_data_failure));
        } else if (customerResource.status == Resource.Status.SUCCESS) {
            m33340m();
            this.f44949c = (GoodsItemEntity) customerResource.data;
            m33338k();
            ((Contract.AbsGoodsPurchaseView) getLogicView()).showBottomButton();
        } else if (customerResource.status == Resource.Status.ERROR) {
            m33319b(customerResource.message);
        }
    }

    /* renamed from: k */
    private void m33338k() {
        int i;
        GoodsItemEntity goodsItemEntity = this.f44949c;
        if (goodsItemEntity == null || goodsItemEntity.node == null) {
            m33305a("entity or node is null", "c-data|").build().info();
            return;
        }
        GoodsItemEntity goodsItemEntity2 = this.f44949c;
        if (goodsItemEntity2 != null) {
            this.notNeedClientCal = goodsItemEntity2.notNeedClientCal;
            this.allowOverAmount = this.f44949c.allowOverAmount;
        }
        this.f44953g = this.f44949c.itemId;
        String str = this.f44949c.itemUniqKey;
        this.f44954h = str;
        if (str == null) {
            this.f44954h = this.f44953g;
        }
        this.f44956j = this.f44949c.status;
        this.f44959m = this.f44949c.shopId;
        this.f44966t = this.f44949c.activityType;
        this.f44957k = this.f44949c.soldStatus;
        this.f44958l = this.f44949c.soldTimeDesc;
        if (this.f44949c.toast != null && !TextUtils.isEmpty(this.f44949c.toast.getContent())) {
            ToastActionHelper.toastAction(this.f44949c.toast, new Function0() {
                public final Object invoke() {
                    return GoodsPurchasePresenter.this.m33348u();
                }
            });
            if (this.f44943E != null) {
                m33347t().onToastShow(this.f44943E.getActId(), this.f44949c.toast.getContent());
            }
        }
        this.f44943E = this.f44949c.actInfo;
        ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).setActInfo(this.f44943E);
        this.mStateUniqueId = this.f44953g + "_" + System.identityHashCode(this);
        StringBuilder sb = new StringBuilder();
        sb.append("state unique id: ");
        sb.append(this.mStateUniqueId);
        m33305a(sb.toString(), "c-data|").build().info();
        SelectItemState mapGoodsEntityToStateRepo = SelectItemStateParser.mapGoodsEntityToStateRepo(this.f44949c);
        ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).putSelectItemState(this.mStateUniqueId, mapGoodsEntityToStateRepo);
        BusinessState state = ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).getState(this.f44959m);
        if (m33324c()) {
            if (state != null) {
                state.shopStatus = 1;
                ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).setValue(state);
            }
            this.f44963q = 1;
        } else if (state != null) {
            this.f44963q = state.shopStatus;
        }
        if (state != null && !TextUtils.isEmpty(state.mWineConfirmDesc)) {
            this.f44940B = state.mWineConfirmDesc;
        } else if (!m33327d() || TextUtils.isEmpty(this.f44949c.wineConfirmDesc)) {
            this.f44940B = ResourceHelper.getString(R.string.customer_goods_detail_alcohol_remind_dialog_desc);
        } else {
            this.f44940B = this.f44949c.wineConfirmDesc;
        }
        if (m33327d() && this.f44949c.wineConfirm == 0) {
            this.f44950d = true;
        }
        mapGoodsEntityToStateRepo.shopId = this.f44959m;
        mapGoodsEntityToStateRepo.itemId = this.f44953g;
        mapGoodsEntityToStateRepo.shopStatus = this.f44963q;
        mapGoodsEntityToStateRepo.itemStatus = this.f44956j;
        mapGoodsEntityToStateRepo.soldStatus = this.f44957k;
        mapGoodsEntityToStateRepo.limitedTime = this.f44958l;
        mapGoodsEntityToStateRepo.from = this.f44962p;
        ItemState state2 = ((CartItemStateRepo) RepoFactory.getRepo(CartItemStateRepo.class)).getState(this.f44959m, this.f44954h);
        this.f44968v = (state2 == null || this.f44965s) ? 0 : state2.amount;
        if (GoodsDataHelper.hasSpecialPriceActivityInfo(this.f44949c) || GoodsDataHelper.isEFO(this.f44966t) || GoodsDataHelper.isRegularCustomer(this.f44966t)) {
            int i2 = this.f44949c.maxOrderSale;
            if (state2 != null) {
                i2 -= state2.amount;
            }
            this.f44967u = i2;
            if (i2 < 0) {
                this.f44967u = Integer.MAX_VALUE;
            }
        } else {
            this.f44967u = Integer.MAX_VALUE;
        }
        CartItemEntity cartItemEntity = this.f44948b;
        int amount = (cartItemEntity == null || cartItemEntity.getAmount() <= 0) ? 1 : this.f44948b.getAmount();
        int i3 = 99;
        if (state2 == null) {
            i = 99;
        } else {
            i = 99 - state2.amount;
        }
        if (this.f44965s) {
            i += amount;
        }
        if (i > 0 && i <= 99) {
            i3 = i;
        }
        this.f44952f = new GoodsAmountModel.Builder().setGoodsId(this.f44949c.itemId).setItemUniKey(this.f44949c.itemUniqKey).setBusinessId(this.f44949c.shopId).setActivityType(this.f44966t).setGoodsItemState(GoodsDataHelper.getGoodsItemState(this.f44949c, 1)).setMinAmount(this.f44939A ^ true ? 1 : 0).setInitialAmount(amount).setMaxAmount(i3).setMaxSaleAmount(this.f44967u).setAllowOverAmoun(this.allowOverAmount).build();
        ((Contract.AbsGoodsPurchaseView) getLogicView()).refreshTitleBar(this.f44949c.itemName, 0.0f);
        m33305a("handleData: {initial:" + amount + "},{maxSale:" + this.f44967u + "}", "c-data|").build().info();
        this.mGoodsContentMap = GoodsDataHelper.parseGoodsItemEntity(this.f44949c, this.f44963q, mapGoodsEntityToStateRepo, this.mSelectedSubItemList, this.mSelectedSubItemStates, this.mStateUniqueId);
        this.f44952f.setGoodsAmountListener(this);
        m33332f();
        this.f44945G = GoodsDataHelper.isSoldOutOrLimitSale(GoodsDataHelper.getGoodsItemState(this.f44956j, this.f44949c.soldStatus, this.f44963q)) || !TextUtils.isEmpty(this.f44949c.headImg);
        ((Contract.AbsGoodsPurchaseView) getLogicView()).updateHeadImage(this.f44945G);
        addDataManager(createChildDataItemManager(new EmptyHeightBinder.HeightData(this.f44945G ? 0 : ResourceHelper.getDimensionPixelSize(R.dimen.customer_112px))));
        GoodsPurchaseHeaderRvModel newInstance = GoodsPurchaseHeaderRvModel.newInstance(this.f44949c);
        newInstance.mNeedShowAlcoholRemind = this.f44950d || this.f44949c.cHasWine == 1;
        newInstance.mBusinessStatus = this.f44963q;
        int i4 = 2;
        newInstance.setRvIndex(1);
        addDataManager(createChildDataItemManager(newInstance));
        int i5 = 0;
        int i6 = 0;
        for (GoodsPurchaseContentRvModel goodsPurchaseContentRvModel : this.mGoodsContentMap.values()) {
            int i7 = i4 + 1;
            addDataManager(createChildDataItemManager(getDividerLineRvModel()));
            int i8 = i7 + 1;
            goodsPurchaseContentRvModel.setRvIndex(i7);
            ChildDataItemManager createChildDataItemManager = createChildDataItemManager(goodsPurchaseContentRvModel);
            addDataManager(createChildDataItemManager);
            this.mContentDataManagers.put(goodsPurchaseContentRvModel.mContentId, createChildDataItemManager);
            if (goodsPurchaseContentRvModel.mIsObliged) {
                i5++;
            } else {
                i6++;
            }
            updateValidSubItemOmegaModel(goodsPurchaseContentRvModel.mContentId);
            ArrayList arrayList = new ArrayList();
            if (!CollectionsUtil.isEmpty(goodsPurchaseContentRvModel.mSubItemList)) {
                int size = goodsPurchaseContentRvModel.mSubItemList.size();
                int i9 = 0;
                while (i9 < size) {
                    GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel = goodsPurchaseContentRvModel.mSubItemList.get(i9);
                    int i10 = i8 + 1;
                    goodsPurchaseSubItemRvModel.setRvIndex(i8);
                    ChildDataItemManager createChildDataItemManager2 = createChildDataItemManager(goodsPurchaseSubItemRvModel);
                    arrayList.add(createChildDataItemManager2);
                    addDataManager(createChildDataItemManager2);
                    i9++;
                    i8 = i10;
                }
                this.mSubItemDataManagers.put(goodsPurchaseContentRvModel.mContentId, arrayList);
            }
            i4 = i8;
        }
        this.mGoodsPurchaseOmegaModel.setRequiredSelections(i5);
        this.mGoodsPurchaseOmegaModel.setUnRequiredSelections(i6);
        this.mGoodsPurchaseOmegaModel.mHasMultiContents = GoodsDataHelper.hasMultipleContents(this.f44949c) ? 1 : 0;
        this.mGoodsPurchaseOmegaModel.mIsMultiLevel = GoodsDataHelper.isMultiLevelItem(this.f44949c) ? 1 : 0;
        this.f44951e = GoodsPurchaseCounterRvModel.newInstance(this.f44952f, this.f44963q, m33341n(), m33344q());
        ((Contract.AbsGoodsPurchaseView) getLogicView()).bindGoodsPurchaseCounter(this.f44951e, this);
        changeAddCartViewState();
        m33308a(this.f44968v);
        ((Contract.AbsGoodsPurchaseView) getLogicView()).changeAddCartText(m33345r());
        if (this.f44956j != 1 || !BusinessDataHelper.checkBusinessStatusNormal(this.f44963q)) {
            ((Contract.AbsGoodsPurchaseView) getLogicView()).disableAddCartAndEvent();
        }
        GoodsItemEntity goodsItemEntity3 = this.f44949c;
        m33347t().onPurchaseShow(this.mGoodsPurchaseOmegaModel.mRequiredSelections, this.mGoodsPurchaseOmegaModel.mHasMultiContents, this.mGoodsPurchaseOmegaModel.mIsMultiLevel, (goodsItemEntity3 == null || goodsItemEntity3.node == null) ? 0 : this.f44949c.node.totalLevel, this.mGoodsPurchaseOmegaModel.mUnRequiredSelections);
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public /* synthetic */ Unit m33348u() {
        m33339l();
        return null;
    }

    /* renamed from: l */
    private void m33339l() {
        ((ICustomerBusinessManager) CustomerManagerLoader.loadManager(ICustomerBusinessManager.class)).refreshBusinessPage(new BusinessActionParam(true, true, true));
        ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).dispatchChange(new BillRefreshEntity(1));
        dismiss(getScopeContext());
    }

    /* renamed from: b */
    private void m33319b(String str) {
        ((Contract.AbsGoodsPurchaseView) getLogicView()).showAbnormalView(m33322c(str));
        ((Contract.AbsGoodsPurchaseView) getLogicView()).hideGoodsContent();
    }

    /* renamed from: m */
    private void m33340m() {
        ((Contract.AbsGoodsPurchaseView) getLogicView()).hideAbnormalView();
        ((Contract.AbsGoodsPurchaseView) getLogicView()).showGoodsContent();
    }

    /* renamed from: c */
    private TopGunAbnormalViewModel m33322c(String str) {
        $$Lambda$GoodsPurchasePresenter$MybTfIL9hrpNtFMiPRZh6zhcTE r0 = new View.OnClickListener() {
            public final void onClick(View view) {
                GoodsPurchasePresenter.this.m33309a(view);
            }
        };
        if (!NetWorkUtils.isNetworkConnected(getContext())) {
            return TopGunAbnormalFactory.buildNoNetwork(r0);
        }
        return TopGunAbnormalFactory.buildHomeNoService(str, r0);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33309a(View view) {
        ((Contract.AbsGoodsPurchaseView) getLogicView()).hideAbnormalView();
        m33337j();
    }

    /* renamed from: n */
    private SpannableString m33341n() {
        if (GoodsDataHelper.isBuyGift(this.f44966t) && GoodsDataHelper.hasBuyGiftActivityInfo(this.f44949c)) {
            return m33342o();
        }
        if (this.allowOverAmount || this.f44967u >= Integer.MAX_VALUE) {
            return null;
        }
        return m33343p();
    }

    /* renamed from: o */
    private SpannableString m33342o() {
        int i = this.f44949c.activityInfo.buyGift.buyNum;
        int i2 = this.f44949c.activityInfo.buyGift.getNum - i;
        int currentAmount = (this.f44968v % (i + i2)) + this.f44952f.getCurrentAmount();
        if (currentAmount >= i) {
            int i3 = (currentAmount / i) * i2;
            SpannableString spannableString = new SpannableString(getContext().getResources().getQuantityString(R.plurals.customer_goods_buy_gift_received_tip, i3, new Object[]{Integer.valueOf(i3)}));
            spannableString.setSpan(new ForegroundColorSpan(SkinUtil.getBrandPrimaryColor()), 0, spannableString.length(), 33);
            return spannableString;
        } else if (i - currentAmount != 1) {
            return null;
        } else {
            SpannableString spannableString2 = new SpannableString(getContext().getResources().getQuantityString(R.plurals.customer_goods_buy_gift_amount_tip, i2, new Object[]{Integer.valueOf(i2)}));
            spannableString2.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.rf_color_gery_2_40_666666)), 0, spannableString2.length(), 33);
            return spannableString2;
        }
    }

    /* renamed from: p */
    private SpannableString m33343p() {
        SpannableString spannableString = new SpannableString(ResourceHelper.getString(R.string.FoodC_sale_Limited_purchase_xvEP, Integer.valueOf(this.f44967u)));
        spannableString.setSpan(new ForegroundColorSpan(SkinUtil.getBrandPrimaryColor()), 0, spannableString.length(), 33);
        return spannableString;
    }

    /* renamed from: q */
    private boolean m33344q() {
        if (GoodsDataHelper.isBuyGift(this.f44966t) && GoodsDataHelper.hasBuyGiftActivityInfo(this.f44949c)) {
            int i = this.f44949c.activityInfo.buyGift.buyNum;
            if ((this.f44968v % ((this.f44949c.activityInfo.buyGift.getNum - i) + i)) + this.f44952f.getCurrentAmount() >= i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: r */
    private String m33345r() {
        ResourceHelper.getString(R.string.FoodC_dish_Purchase_VBHv);
        if (this.f44965s) {
            return ResourceHelper.getString(R.string.customer_goods_purchase_update);
        }
        if (this.f44961o == 1) {
            return ResourceHelper.getString(R.string.FoodC_requirement_Purchase_MOXm);
        }
        if (!GoodsDataHelper.isBuyGift(this.f44966t) || !GoodsDataHelper.hasBuyGiftActivityInfo(this.f44949c)) {
            return getContext().getResources().getString(R.string.customer_global_add);
        }
        int i = this.f44949c.activityInfo.buyGift.buyNum;
        int currentAmount = ((this.f44968v % ((this.f44949c.activityInfo.buyGift.getNum - i) + i)) + this.f44952f.getCurrentAmount()) / i;
        this.f44952f.getCurrentAmount();
        return getContext().getResources().getString(R.string.customer_global_add);
    }

    /* renamed from: a */
    private void m33308a(int i) {
        m33305a("handleOfflineCalculate:{isUpdate:" + this.f44965s + "}", "c-show|").build().info();
        this.mGoodsPriceCalculator = m33316b(i);
        changeOfflinePrice();
    }

    /* renamed from: b */
    private GoodsPriceCalculator m33316b(int i) {
        if (this.f44965s) {
            return new NoOpGoodsPriceCalculator();
        }
        if (GoodsDataHelper.isBuyGift(this.f44966t)) {
            return new BuyGiftGoodsPriceCalculator(this.f44949c, i);
        }
        if (GoodsDataHelper.isSpecialPrice(this.f44966t) || GoodsDataHelper.isRegularCustomer(this.f44966t) || GoodsDataHelper.isEFO(this.f44966t)) {
            return new SpecialGoodsPriceCalculator(this.f44949c);
        }
        return new NormalGoodsPriceCalculator(this.f44949c);
    }

    /* renamed from: s */
    private void m33346s() {
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).subscribe(getScopeContext(), this.f44959m, (Action2<CustomerResource<CartInfoEntity>>) new Action2() {
            public final void call(Object obj, Subscription subscription) {
                GoodsPurchasePresenter.this.m33312a((CustomerResource) obj, subscription);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33312a(CustomerResource customerResource, Subscription subscription) {
        CustomerResource customerResource2 = customerResource;
        if (customerResource2 == null) {
            ((Contract.AbsGoodsPurchaseView) getLogicView()).hideCartLoadingView();
            m33305a("calculate resource is null", "c-data|").build().info();
        } else if (customerResource2.status == Resource.Status.SUCCESS) {
            ((Contract.AbsGoodsPurchaseView) getLogicView()).hideCartLoadingView();
            if (subscription != null && !subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
            if (customerResource2.data == null) {
                m33305a("calculate data is null", "c-data|").build().info();
                return;
            }
            m33305a("calculate success", "c-data|").build().info();
            GoodsItemEntity goodsItemEntity = this.f44949c;
            int i = (goodsItemEntity == null || goodsItemEntity.node == null) ? 0 : this.f44949c.node.totalLevel;
            this.mGoodsPurchaseOmegaModel.setCartId(((CartInfoEntity) customerResource2.data).getCartId());
            this.mGoodsPurchaseOmegaModel.setCartInfo((CartInfoEntity) customerResource2.data);
            GoodsPurchaseOmegaModel goodsPurchaseOmegaModel = this.mGoodsPurchaseOmegaModel;
            m33347t().onPurchaseItem2CartClick(GsonUtil.toJson(goodsPurchaseOmegaModel.mGoodsSelectOmegaModel), this.f44952f.getCurrentAmount(), goodsPurchaseOmegaModel.mCartInfo, goodsPurchaseOmegaModel.mCartId, this.f44959m, this.f44953g, goodsPurchaseOmegaModel.mHasMultiContents, goodsPurchaseOmegaModel.mIsMultiLevel, this.f44949c.price + "", this.f44949c.specialPrice + "", this.f44966t + "", this.mGoodsPurchaseOmegaModel.mRequiredSelections, this.mGoodsPurchaseOmegaModel.mUnRequiredSelections, i, this.f44946H, this.f44947I);
            if (((CartInfoEntity) customerResource2.data).getAlert() != null && !TextUtils.isEmpty(((CartInfoEntity) customerResource2.data).getAlert().getContent())) {
                ToastUtil.showCustomerErrorToast((ScopeContext) null, ((CartInfoEntity) customerResource2.data).getAlert().getContent());
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean(Const.PageParams.BUSINESS_GOODS_PURCHASED, !this.f44965s);
            bundle.putString(Const.PageParams.ITEM_ID, this.f44953g);
            bundle.putString(Const.PageParams.ITEM_UNIQ_KEY, this.f44954h);
            onBack(bundle);
        } else if (customerResource2.status == Resource.Status.ERROR) {
            ((Contract.AbsGoodsPurchaseView) getLogicView()).hideCartLoadingView();
            if (subscription != null && !subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
            m33305a("calculate fail: " + customerResource2.message, "c-data|").build().error();
            String str = customerResource2.message;
            if (!NetWorkUtils.isNetworkConnected(getContext())) {
                str = ResourceHelper.getString(R.string.customer_net_error_tip_subtitle);
            }
            ToastUtil.showCustomerErrorToast(getScopeContext(), str);
        }
    }

    /* renamed from: b */
    private void m33320b(List<ItemNodeEntity> list) {
        m33305a("dispatch replace", "c-act|").build().info();
        m33346s();
        int currentAmount = this.f44952f.getCurrentAmount();
        CheckCartMaxNumKt.isReachMaxNum(getScopeContext(), this.f44959m, this.f44954h, this.f44972z, currentAmount, new Function0(currentAmount, list) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ List f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Object invoke() {
                return GoodsPurchasePresenter.this.m33317b(this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ Unit m33317b(int i, List list) {
        int i2 = i;
        ((Contract.AbsGoodsPurchaseView) getLogicView()).showCartLoadingView();
        m33305a("dispatchReplaceAction: amount is " + i2 + "businessId is " + this.f44959m + "mGoodsId is " + this.f44953g + "mMduId is " + this.f44972z + "mCartRevision is " + this.f44970x + "mBiData is " + this.f44960n, "c-data|").build().info();
        if (i2 == 0) {
            ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).setItemAmount(new SetItemAmountParams(m33325d(this.f44959m), m33325d(this.f44953g), this.f44954h, m33325d(this.f44971y), new SetItemAmountParams.Content(m33325d(this.f44972z), i2), m33325d(this.f44970x), m33325d(this.f44960n), (ActInfoEntity) null));
            return Unit.INSTANCE;
        }
        SetItemParams setItemParams = new SetItemParams(this.f44959m, this.f44953g, this.f44954h, GoodsDataHelper.hasMultipleContents(this.f44949c), i, list, this.f44971y, this.f44972z, Integer.valueOf(this.f44964r ? 1 : 0), this.f44970x, this.f44960n, this.f44943E);
        if ("1".equals(this.f44946H)) {
            setItemParams = new SetItemParams(this.f44959m, this.f44953g, this.f44954h, GoodsDataHelper.hasMultipleContents(this.f44949c), i, list, this.f44971y, this.f44972z, Integer.valueOf(this.f44964r ? 1 : 0), this.f44970x, this.f44960n, this.f44943E, 1);
        }
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).setItem(setItemParams);
        return Unit.INSTANCE;
    }

    /* renamed from: a */
    private void m33314a(ArrayList<ItemNodeEntity> arrayList) {
        int i = this.f44962p;
        String str = i == 7 ? "homePage" : i == 8 ? "discountDetail" : "";
        Bundle bundle = new Bundle();
        bundle.putString(Const.PageParams.SHOP_ID, this.f44959m);
        bundle.putString("from_page", str);
        bundle.putString("cart_id", this.f44971y);
        bundle.putInt("source", this.f44961o);
        bundle.putInt(Const.PageParams.WINE_CONFIRM, this.f44964r ? 1 : 0);
        bundle.putSerializable(Const.PageParams.NODE_LIST, arrayList);
        bundle.putInt(Const.PageParams.SUB_FROM_SKU_CHECK_OUT, this.f44962p);
        m33347t().trackCheckOut(this.mGoodsPurchaseOmegaModel.mHasMultiContents);
        dismiss(getScopeContext(), bundle);
    }

    /* renamed from: c */
    private void m33323c(List<ItemNodeEntity> list) {
        m33305a("dispatch add", "c-act|").build().info();
        m33346s();
        int currentAmount = this.f44952f.getCurrentAmount();
        CheckCartMaxNumKt.isReachMaxNum(getScopeContext(), this.f44959m, this.f44954h, this.f44972z, currentAmount, new Function0(currentAmount, list) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ List f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Object invoke() {
                return GoodsPurchasePresenter.this.m33306a(this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ Unit m33306a(int i, List list) {
        ((Contract.AbsGoodsPurchaseView) getLogicView()).showCartLoadingView();
        SetItemParams setItemParams = new SetItemParams(this.f44959m, this.f44953g, this.f44954h, GoodsDataHelper.hasMultipleContents(this.f44949c), i, list, (String) null, (String) null, Integer.valueOf(this.f44964r ? 1 : 0), this.f44970x, this.f44960n, this.f44943E);
        if ("1".equals(this.f44946H)) {
            setItemParams = new SetItemParams(this.f44959m, this.f44953g, this.f44954h, GoodsDataHelper.hasMultipleContents(this.f44949c), i, list, (String) null, (String) null, Integer.valueOf(this.f44964r ? 1 : 0), this.f44970x, this.f44960n, this.f44943E, 1);
        }
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).setItem(setItemParams);
        return Unit.INSTANCE;
    }

    /* renamed from: d */
    private void m33326d(List<ItemNodeEntity> list) {
        int currentAmount = this.f44952f.getCurrentAmount();
        m33305a("bill update amount is " + currentAmount, "c-act|").build().info();
        if (currentAmount == 0) {
            ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).dispatchChange(new BillDelItemEntity(this.f44972z));
        } else {
            ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).dispatchChange(new BillUpdateParams(this.f44971y, this.f44959m, this.f44972z, list, 0));
        }
        dismiss(getScopeContext());
    }

    /* renamed from: e */
    private void m33330e(List<ItemNodeEntity> list) {
        BillAddTyingEntity billAddTyingEntity = new BillAddTyingEntity();
        billAddTyingEntity.shopId = this.f44959m;
        billAddTyingEntity.nodeList = list;
        ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).dispatchChange(billAddTyingEntity);
        dismiss(getScopeContext());
    }

    /* renamed from: e */
    private void m33329e(String str) {
        Logger.m45047d(f44938a, str);
    }

    /* renamed from: t */
    private GoodsOmegaHelper m33347t() {
        int i;
        String str;
        String str2;
        if (this.f44969w == null) {
            GoodsItemEntity goodsItemEntity = this.f44949c;
            if (goodsItemEntity != null) {
                String num = Integer.toString(goodsItemEntity.price);
                str = Integer.toString(this.f44949c.specialPrice);
                i = this.f44949c.additionalType == 0 ? 1 : 2;
                str2 = num;
            } else {
                str2 = "";
                str = str2;
                i = 0;
            }
            this.f44969w = new GoodsOmegaHelper(getScopeContext(), this.f44959m, this.f44963q, this.f44953g, this.f44956j, this.f44957k, this.f44958l, this.f44962p, str2, str, Integer.toString(this.f44966t), this.f44944F, this.f44945G, this.f44955i, i);
        }
        return this.f44969w;
    }

    /* renamed from: f */
    private RecordTracker.Builder m33331f(String str) {
        return m33305a(str, (String) null);
    }

    /* renamed from: a */
    private RecordTracker.Builder m33305a(String str, String str2) {
        return RecordTracker.Builder.create().setTag(f44938a).setLogModule("m-purchase|").setMessage(str).setLogCategory(str2).setOtherParam("business_id", this.f44959m).setOtherParam("goods_id", this.f44953g);
    }

    /* renamed from: g */
    private void m33334g(String str) {
        ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_SKU_OFFLINE_ERROR).addModuleName(ErrorConst.ModuleName.SKU).addErrorType(str).addParam("shop_id", this.f44949c.shopId).addParam("item_id", this.f44949c.itemId).build().trackError();
    }
}
