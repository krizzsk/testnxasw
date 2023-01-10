package com.didi.soda.goodsV2.component.multilevel;

import android.os.Bundle;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataItemManager;
import com.didi.rfusion.widget.floating.IRFFloatingExpand;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.rpc.entity.GoodsSubItemEntity;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.goods.repo.SelectItemState;
import com.didi.soda.goods.repo.SelectSubItemState;
import com.didi.soda.goodsV2.binder.EmptyHeightBinder;
import com.didi.soda.goodsV2.binder.logic.PurchaseSubItemLogicRepo;
import com.didi.soda.goodsV2.component.multilevel.Contract;
import com.didi.soda.goodsV2.helper.GoodsDataHelper;
import com.didi.soda.goodsV2.helper.GoodsOmegaHelper;
import com.didi.soda.goodsV2.helper.GoodsPurchaseOmegaModel;
import com.didi.soda.goodsV2.model.GoodsPurchaseContentRvModel;
import com.didi.soda.goodsV2.model.GoodsPurchaseSubItemRvModel;
import com.didi.soda.goodsV2.parser.SelectItemStateParser;
import com.didi.soda.goodsV2.price.GoodsPriceCalculator;
import com.didi.soda.goodsV2.price.NoOpGoodsPriceCalculator;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerGoodsManager;
import com.taxis99.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.soda.goodsV2.component.multilevel.a */
/* compiled from: MultiLevelPresenter */
class C14704a extends Contract.AbsMultiLevelPresenter implements IRFFloatingExpand {

    /* renamed from: a */
    private static final String f44923a = "GoodsPurchasePresenter";

    /* renamed from: b */
    private String f44924b;

    /* renamed from: c */
    private int f44925c;

    /* renamed from: d */
    private int f44926d;

    /* renamed from: e */
    private int f44927e;

    /* renamed from: f */
    private String f44928f;

    /* renamed from: g */
    private int f44929g;

    /* renamed from: h */
    private int f44930h;

    /* renamed from: i */
    private String f44931i;

    /* renamed from: j */
    private GoodsSubItemEntity f44932j;

    /* renamed from: k */
    private SelectSubItemState f44933k;

    /* renamed from: l */
    private int f44934l;

    /* renamed from: m */
    private GoodsOmegaHelper f44935m;

    C14704a() {
    }

    public void onCreate() {
        super.onCreate();
        m33302c();
        m33301b();
        m33303d().onMultiLevelShow(this.f44930h, this.f44933k.subItemId);
    }

    public void onAddCartViewClicked(boolean z) {
        if (z) {
            m33303d().onMultiLevelConfirmClick(this.f44930h, this.f44933k.subItemId);
            m33300a();
            return;
        }
        anchorToUnSatisfiedContent();
    }

    public void replaceSubItemState(SelectSubItemState selectSubItemState) {
        SelectItemStateParser.replaceSubItemState(this.mStateUniqueId, this.f44933k, selectSubItemState);
    }

    public SelectSubItemState findSelectSubItemState(String str) {
        for (SelectSubItemState next : this.f44933k.selectedSubItemStates) {
            if (next != null && str != null && str.equals(next.uniqueId)) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onMultiPageEnter(PurchaseSubItemLogicRepo.PurchaseSubItemLogicModel purchaseSubItemLogicModel) {
        m33303d().trackEntreMultiPage(purchaseSubItemLogicModel.rvModel.mSubItemId);
    }

    public void onSelectionStateChanged(String str, String str2, boolean z) {
        super.onSelectionStateChanged(str, str2, z);
        GoodsPurchaseOmegaModel goodsPurchaseOmegaModel = this.mGoodsPurchaseOmegaModel;
        m33303d().onSubItemClick(goodsPurchaseOmegaModel.mCurContentId, goodsPurchaseOmegaModel.mCurContentType, goodsPurchaseOmegaModel.mValidSubItemIdMap.get(str), goodsPurchaseOmegaModel.mInvalidSubItemIdMap.get(str), goodsPurchaseOmegaModel.mCurSelectedSubItemId, goodsPurchaseOmegaModel.mSelectType, goodsPurchaseOmegaModel.mCurContentIsMust, goodsPurchaseOmegaModel.mCurSelectedSubItemType, goodsPurchaseOmegaModel.mIsMultiLevel, 0);
    }

    /* access modifiers changed from: protected */
    public int getLevel() {
        return this.f44930h;
    }

    /* access modifiers changed from: protected */
    public GoodsSubItemEntity findSubItemEntity(String str, String str2) {
        return GoodsDataHelper.filterSubItemEntity(this.f44932j, str, str2);
    }

    /* access modifiers changed from: protected */
    public void changeOfflinePrice() {
        if (!this.notNeedClientCal) {
            if (this.mGoodsPriceCalculator == null) {
                m33299a("mGoodsPriceCalculator == null", "c-show|").build().info();
                return;
            }
            SelectItemState selectItemState = ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).getSelectItemState(this.mStateUniqueId);
            int i = Integer.MAX_VALUE;
            if (selectItemState != null) {
                i = selectItemState.maxSale;
            }
            List<SelectSubItemState> filterCalculatePriceStates = SelectItemStateParser.filterCalculatePriceStates(this.mSelectedSubItemStates.values());
            int calculateOriPriceWithStates = this.mGoodsPriceCalculator.calculateOriPriceWithStates(filterCalculatePriceStates, this.f44934l);
            int calculateCurPriceWithStates = this.mGoodsPriceCalculator.calculateCurPriceWithStates(filterCalculatePriceStates, this.f44934l, i);
            if (calculateCurPriceWithStates < 0) {
                calculateCurPriceWithStates = 0;
                calculateOriPriceWithStates = 0;
            }
            m33299a("changeOfflinePrice:{cur:" + calculateCurPriceWithStates + "},{ori:" + calculateOriPriceWithStates + "}", "c-show|").build().info();
            ((Contract.AbsMultiLevelView) getLogicView()).changeOfflinePrice(calculateCurPriceWithStates, calculateOriPriceWithStates, this.f44932j.currency);
        }
    }

    /* renamed from: a */
    private void m33300a() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(Const.PageParams.MULTI_SUB_ITEM_STATE_BACK, this.f44933k);
        bundle.putSerializable(Const.PageParams.MULTI_SELECTED_SUB_ITEM_STATE_BACK, this.mSelectedSubItemStates);
        dismiss(getScopeContext(), bundle);
    }

    /* renamed from: b */
    private void m33301b() {
        if (this.f44932j != null) {
            ((Contract.AbsMultiLevelView) getLogicView()).refreshTitleBar(this.f44932j.itemName, 1.0f);
            int i = 1;
            this.f44930h = this.f44932j.node.level + 1;
            this.f44933k.node.amount = 1;
            this.mSelectedSubItemStates.put(this.f44933k.uniqueId, this.f44933k);
            this.mSelectedSubItemStates.putAll(this.f44933k.getSelectedSubItemStates());
            this.mGoodsContentMap = GoodsDataHelper.parseMultiLevelSubItem(this.f44932j, this.f44926d, this.f44933k, this.mSelectedSubItemList, this.mSelectedSubItemStates);
            addDataManager(createChildDataItemManager(new EmptyHeightBinder.HeightData(ResourceHelper.getDimensionPixelSize(R.dimen.customer_112px))));
            int i2 = 0;
            for (GoodsPurchaseContentRvModel goodsPurchaseContentRvModel : this.mGoodsContentMap.values()) {
                if (i2 > 0) {
                    i++;
                    addDataManager(createChildDataItemManager(getDividerLineRvModel()));
                }
                i2++;
                int i3 = i + 1;
                goodsPurchaseContentRvModel.setRvIndex(i);
                ChildDataItemManager createChildDataItemManager = createChildDataItemManager(goodsPurchaseContentRvModel);
                addDataManager(createChildDataItemManager);
                this.mContentDataManagers.put(goodsPurchaseContentRvModel.mContentId, createChildDataItemManager);
                updateValidSubItemOmegaModel(goodsPurchaseContentRvModel.mContentId);
                ArrayList arrayList = new ArrayList();
                if (!CollectionsUtil.isEmpty(goodsPurchaseContentRvModel.mSubItemList)) {
                    int size = goodsPurchaseContentRvModel.mSubItemList.size();
                    int i4 = 0;
                    while (i4 < size) {
                        GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel = goodsPurchaseContentRvModel.mSubItemList.get(i4);
                        int i5 = i3 + 1;
                        goodsPurchaseSubItemRvModel.setRvIndex(i3);
                        ChildDataItemManager createChildDataItemManager2 = createChildDataItemManager(goodsPurchaseSubItemRvModel);
                        arrayList.add(createChildDataItemManager2);
                        addDataManager(createChildDataItemManager2);
                        i4++;
                        i3 = i5;
                    }
                    this.mSubItemDataManagers.put(goodsPurchaseContentRvModel.mContentId, arrayList);
                }
                i = i3;
            }
            changeAddCartViewState();
            changeOfflinePrice();
        }
    }

    /* renamed from: c */
    private void m33302c() {
        this.mStateUniqueId = getScopeContext().getBundle().getString(Const.PageParams.SELECT_ITEM_STATE_UNIQUE_ID, "");
        this.f44932j = (GoodsSubItemEntity) getScopeContext().getBundle().getSerializable(Const.PageParams.SUBITEM_ENTITY);
        this.f44933k = (SelectSubItemState) getScopeContext().getBundle().getSerializable(Const.PageParams.SUB_ITEM_STATE_COPY);
        this.mSelectedSubItemStates.putAll((Map) getScopeContext().getBundle().getSerializable(Const.PageParams.SELECTED_SUB_ITEM_STATE_COPY));
        Serializable serializable = getScopeContext().getBundle().getSerializable(Const.PageParams.GOODS_PRICE_CALCULATOR);
        if (serializable == null) {
            this.mGoodsPriceCalculator = new NoOpGoodsPriceCalculator();
        } else {
            this.mGoodsPriceCalculator = (GoodsPriceCalculator) serializable;
        }
        this.notNeedClientCal = getScopeContext().getBundle().getBoolean(Const.PageParams.SUBITEM_NOTNEEDCAL, false);
        SelectItemState selectItemState = ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).getSelectItemState(this.mStateUniqueId);
        if (selectItemState != null) {
            this.f44934l = selectItemState.node.amount;
            this.f44931i = selectItemState.shopId;
            this.f44926d = selectItemState.shopStatus;
            this.f44924b = selectItemState.itemId;
            this.f44925c = selectItemState.itemStatus;
            this.f44927e = selectItemState.soldStatus;
            this.f44928f = selectItemState.limitedTime;
            this.f44929g = selectItemState.from;
        }
    }

    /* renamed from: d */
    private GoodsOmegaHelper m33303d() {
        if (this.f44935m == null) {
            this.f44935m = new GoodsOmegaHelper(getScopeContext(), this.f44931i, this.f44926d, this.f44924b, this.f44925c, this.f44927e, this.f44928f, this.f44929g);
        }
        return this.f44935m;
    }

    /* renamed from: a */
    private RecordTracker.Builder m33299a(String str, String str2) {
        return RecordTracker.Builder.create().setTag(f44923a).setLogModule("m-purchase|").setMessage(str).setLogCategory(str2).setOtherParam("business_id", this.f44931i).setOtherParam("goods_id", this.f44924b);
    }
}
