package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.soda.blocks.scope.BlockScopeBase;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.blocks.ItemOperationListener;
import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.ActionInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.ButtonInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ViewMoreEntity;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.home.topgun.binder.HomeTopicBinder;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.didi.soda.home.topgun.binder.model.HomeTopicRvModel;
import com.didi.soda.home.topgun.binder.model.TopicItemModel;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fH\u0016J \u0010\u0019\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\tR\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/HomeTopicItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/didi/soda/home/topgun/widget/HomeTopicItemAdapter$Companion$InnerHolder;", "()V", "list", "Ljava/util/ArrayList;", "Lcom/didi/soda/home/topgun/binder/model/TopicItemModel;", "Lkotlin/collections/ArrayList;", "logic", "Lcom/didi/soda/home/topgun/binder/HomeTopicBinder$Companion$Logic;", "model", "Lcom/didi/soda/home/topgun/binder/model/HomeTopicRvModel;", "scope", "Lcom/didi/soda/blocks/scope/BlockScopeBase;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HomeTopicItemAdapter.kt */
public final class HomeTopicItemAdapter extends RecyclerView.Adapter<Companion.InnerHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final ArrayList<TopicItemModel> f45674a = new ArrayList<>();

    /* renamed from: b */
    private HomeTopicRvModel f45675b;

    /* renamed from: c */
    private BlockScopeBase f45676c;

    /* renamed from: d */
    private HomeTopicBinder.Companion.Logic f45677d;

    public final void setData(HomeTopicRvModel homeTopicRvModel, BlockScopeBase blockScopeBase, HomeTopicBinder.Companion.Logic logic) {
        Intrinsics.checkNotNullParameter(homeTopicRvModel, "model");
        Intrinsics.checkNotNullParameter(blockScopeBase, "scope");
        this.f45675b = homeTopicRvModel;
        this.f45676c = blockScopeBase;
        this.f45677d = logic;
        this.f45674a.clear();
        this.f45674a.addAll(homeTopicRvModel.getItemList());
        notifyDataSetChanged();
    }

    public Companion.InnerHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i == 0) {
            Context context = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            Context context2 = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
            return new Companion.GoodsHolder(context, new HomeTopicGoodsItemView(context2, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null));
        } else if (i == 1) {
            Context context3 = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "parent.context");
            Context context4 = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "parent.context");
            return new Companion.ShopItemHolder(context3, new HomeTopicShopItemView(context4, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null));
        } else if (i == 2) {
            Context context5 = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context5, "parent.context");
            Context context6 = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context6, "parent.context");
            return new Companion.ViewMoreHolder(context5, new HomeTopicMoreView(context6, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null));
        } else if (i == 10) {
            Context context7 = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context7, "parent.context");
            Context context8 = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context8, "parent.context");
            return new Companion.GoodsHolder2(context7, new HomeTopicGoodsItemViewV2(context8, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null));
        } else if (i != 11) {
            Context context9 = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context9, "parent.context");
            Context context10 = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context10, "parent.context");
            return new Companion.ViewMoreHolder2(context9, new HomeTopicMoreViewV2(context10, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null));
        } else {
            Context context11 = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context11, "parent.context");
            Context context12 = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context12, "parent.context");
            return new Companion.ShopItemHolder2(context11, new HomeTopicShopItemViewV2(context12, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null));
        }
    }

    public int getItemViewType(int i) {
        return this.f45674a.get(i).getType();
    }

    public void onBindViewHolder(Companion.InnerHolder innerHolder, int i) {
        Intrinsics.checkNotNullParameter(innerHolder, "holder");
        TopicItemModel topicItemModel = this.f45674a.get(i);
        Intrinsics.checkNotNullExpressionValue(topicItemModel, "list[position]");
        TopicItemModel topicItemModel2 = topicItemModel;
        HomeTopicRvModel homeTopicRvModel = this.f45675b;
        BlockScopeBase blockScopeBase = null;
        if (homeTopicRvModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
            homeTopicRvModel = null;
        }
        BlockScopeBase blockScopeBase2 = this.f45676c;
        if (blockScopeBase2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scope");
        } else {
            blockScopeBase = blockScopeBase2;
        }
        innerHolder.setData(topicItemModel2, homeTopicRvModel, blockScopeBase, this.f45677d);
    }

    public int getItemCount() {
        return this.f45674a.size();
    }

    @Metadata(mo148867d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\n"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/HomeTopicItemAdapter$Companion;", "", "()V", "GoodsHolder", "GoodsHolder2", "InnerHolder", "ShopItemHolder", "ShopItemHolder2", "ViewMoreHolder", "ViewMoreHolder2", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: HomeTopicItemAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Metadata(mo148867d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0004J.\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0019J*\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020#2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006$"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/HomeTopicItemAdapter$Companion$InnerHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "container", "Landroid/view/View;", "(Landroid/content/Context;Landroid/view/View;)V", "getContext", "()Landroid/content/Context;", "logic", "Lcom/didi/soda/home/topgun/binder/HomeTopicBinder$Companion$Logic;", "getLogic", "()Lcom/didi/soda/home/topgun/binder/HomeTopicBinder$Companion$Logic;", "setLogic", "(Lcom/didi/soda/home/topgun/binder/HomeTopicBinder$Companion$Logic;)V", "onAppear", "", "onGoodItemClick", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "isBtn", "", "good", "Lcom/didi/soda/business/model/BusinessGoodsItemRvModel;", "topic", "Lcom/didi/soda/home/topgun/binder/model/HomeTopicRvModel;", "orderWay", "", "onShopItemClick", "shop", "Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "setData", "itemModel", "Lcom/didi/soda/home/topgun/binder/model/TopicItemModel;", "model", "Lcom/didi/soda/blocks/scope/BlockScopeBase;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
        /* compiled from: HomeTopicItemAdapter.kt */
        public static abstract class InnerHolder extends RecyclerView.ViewHolder {
            private final Context context;
            private HomeTopicBinder.Companion.Logic logic;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public InnerHolder(Context context2, View view) {
                super(view);
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(view, "container");
                this.context = context2;
            }

            public final Context getContext() {
                return this.context;
            }

            public final HomeTopicBinder.Companion.Logic getLogic() {
                return this.logic;
            }

            public final void setLogic(HomeTopicBinder.Companion.Logic logic2) {
                this.logic = logic2;
            }

            public void setData(TopicItemModel topicItemModel, HomeTopicRvModel homeTopicRvModel, BlockScopeBase blockScopeBase, HomeTopicBinder.Companion.Logic logic2) {
                Intrinsics.checkNotNullParameter(topicItemModel, "itemModel");
                Intrinsics.checkNotNullParameter(homeTopicRvModel, "model");
                Intrinsics.checkNotNullParameter(blockScopeBase, "scope");
                this.logic = logic2;
            }

            /* access modifiers changed from: protected */
            public final void onAppear() {
                if (this.itemView instanceof ItemOperationListener) {
                    ((ItemOperationListener) this.itemView).onAppear();
                }
            }

            public final void onGoodItemClick(IBlockScope iBlockScope, boolean z, BusinessGoodsItemRvModel businessGoodsItemRvModel, HomeTopicRvModel homeTopicRvModel, int i) {
                Serializable serializable;
                Serializable serializable2;
                Serializable serializable3;
                IBlockScope iBlockScope2 = iBlockScope;
                BusinessGoodsItemRvModel businessGoodsItemRvModel2 = businessGoodsItemRvModel;
                HomeTopicRvModel homeTopicRvModel2 = homeTopicRvModel;
                int i2 = i;
                Intrinsics.checkNotNullParameter(iBlockScope2, "scope");
                Intrinsics.checkNotNullParameter(businessGoodsItemRvModel2, "good");
                Intrinsics.checkNotNullParameter(homeTopicRvModel2, "topic");
                if (i2 == 1) {
                    HomeTopicBinder.Companion.Logic logic2 = this.logic;
                    if (logic2 != null) {
                        Context context2 = this.context;
                        Pair[] pairArr = new Pair[10];
                        pairArr[0] = TuplesKt.m41339to("fromType", 7);
                        pairArr[1] = TuplesKt.m41339to("sceneType", 22);
                        int i3 = 2;
                        pairArr[2] = TuplesKt.m41339to("source", 1);
                        pairArr[3] = TuplesKt.m41339to(BlocksConst.ACTION_PARAMS_ACT_VALIDATE_TYPE, 1);
                        ActInfoEntity actInfoEntity = businessGoodsItemRvModel2.mActinfo;
                        if (actInfoEntity == null) {
                            serializable = "";
                        } else {
                            serializable = actInfoEntity;
                        }
                        pairArr[4] = TuplesKt.m41339to(BlocksConst.ACTION_PARAMS_ACT_INFO, GsonUtil.toJson(serializable));
                        pairArr[5] = TuplesKt.m41339to("shopId", businessGoodsItemRvModel2.mBusinessId);
                        pairArr[6] = TuplesKt.m41339to(BlocksConst.ACTION_PARAMS_ITEM_ID, businessGoodsItemRvModel2.mGoodsId);
                        pairArr[7] = TuplesKt.m41339to(BlocksConst.ACTION_PARAMS_HAS_WINE, Integer.valueOf(businessGoodsItemRvModel2.mHasWine));
                        if (z) {
                            i3 = businessGoodsItemRvModel2.mMaxLevel;
                        }
                        pairArr[8] = TuplesKt.m41339to(BlocksConst.ACTION_PARAMS_MAX_LEVEL, Integer.valueOf(i3));
                        ItemNodeEntity itemNodeEntity = businessGoodsItemRvModel2.mNode;
                        if (itemNodeEntity != null) {
                            serializable2 = itemNodeEntity;
                        }
                        pairArr[9] = TuplesKt.m41339to(BlocksConst.ACTION_PARAMS_ITEM_NODE, GsonUtil.toJson(serializable2));
                        logic2.fastBuy(context2, iBlockScope2, MapsKt.hashMapOf(pairArr));
                    }
                    if (z) {
                        HomeOmegaHelper.getInstance().traceTopicBtnBuyCK(homeTopicRvModel2, businessGoodsItemRvModel2);
                    } else {
                        HomeOmegaHelper.getInstance().traceTopicGoodsItemCK(homeTopicRvModel2, businessGoodsItemRvModel2);
                    }
                } else if (i2 != 3) {
                    Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.m41339to(Const.PageParams.SHOP_ID, businessGoodsItemRvModel2.mBusinessId));
                    CharSequence charSequence = businessGoodsItemRvModel2.mGoodsId;
                    if (!(charSequence == null || charSequence.length() == 0)) {
                        ActionInfoEntity actionInfoEntity = new ActionInfoEntity();
                        String str = businessGoodsItemRvModel2.mGoodsId;
                        if (str == null) {
                            str = "";
                        }
                        actionInfoEntity.setItemId(str);
                        actionInfoEntity.setType(z ? 3 : 2);
                        mutableMapOf.put(Const.PageParams.ACTION_INFO_DICT, actionInfoEntity);
                    }
                    if (businessGoodsItemRvModel2.mActinfo != null) {
                        String json = GsonUtil.toJson(businessGoodsItemRvModel2.mActinfo);
                        Intrinsics.checkNotNullExpressionValue(json, "toJson(good.mActinfo)");
                        mutableMapOf.put(Const.PageParams.ACT_INFO, json);
                    }
                    HomeTopicBinder.Companion.Logic logic3 = this.logic;
                    if (logic3 != null) {
                        Context context3 = this.context;
                        Pair[] pairArr2 = new Pair[6];
                        pairArr2[0] = TuplesKt.m41339to("url", RoutePath.BUSINESS_HOME);
                        pairArr2[1] = TuplesKt.m41339to(BlocksConst.ACTION_PARAMS_ENABLE_PAGE_RESULT, 1);
                        pairArr2[2] = TuplesKt.m41339to("sceneType", 22);
                        pairArr2[3] = TuplesKt.m41339to(BlocksConst.ACTION_PARAMS_ACT_VALIDATE_TYPE, 1);
                        ActInfoEntity actInfoEntity2 = businessGoodsItemRvModel2.mActinfo;
                        if (actInfoEntity2 != null) {
                            serializable3 = actInfoEntity2;
                        }
                        pairArr2[4] = TuplesKt.m41339to(BlocksConst.ACTION_PARAMS_ACT_INFO, GsonUtil.toJson(serializable3));
                        pairArr2[5] = TuplesKt.m41339to("params", mutableMapOf);
                        logic3.openPage(context3, iBlockScope2, MapsKt.hashMapOf(pairArr2));
                    }
                    if (z) {
                        HomeOmegaHelper.getInstance().traceTopicBtnOpenStoreCK(homeTopicRvModel2, businessGoodsItemRvModel2);
                    } else {
                        HomeOmegaHelper.getInstance().traceTopicGoodsItemCK(homeTopicRvModel2, businessGoodsItemRvModel2);
                    }
                } else {
                    HomeTopicBinder.Companion.Logic logic4 = this.logic;
                    if (logic4 != null) {
                        logic4.toMorePage(homeTopicRvModel2);
                    }
                    if (z) {
                        HomeOmegaHelper.getInstance().traceTopicBtnOpenStoreCK(homeTopicRvModel2, businessGoodsItemRvModel2);
                    } else {
                        HomeOmegaHelper.getInstance().traceTopicGoodsItemCK(homeTopicRvModel2, businessGoodsItemRvModel2);
                    }
                }
            }

            public final void onShopItemClick(IBlockScope iBlockScope, HomeBusinessInfoRvModel homeBusinessInfoRvModel, HomeTopicRvModel homeTopicRvModel) {
                Serializable serializable;
                Serializable serializable2;
                Serializable serializable3;
                IBlockScope iBlockScope2 = iBlockScope;
                HomeBusinessInfoRvModel homeBusinessInfoRvModel2 = homeBusinessInfoRvModel;
                HomeTopicRvModel homeTopicRvModel2 = homeTopicRvModel;
                Intrinsics.checkNotNullParameter(iBlockScope2, "scope");
                Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel2, "shop");
                Intrinsics.checkNotNullParameter(homeTopicRvModel2, "topic");
                HomeOmegaHelper.getInstance().traceTopicShopItemCK(homeTopicRvModel2, homeBusinessInfoRvModel2);
                if (homeBusinessInfoRvModel2.orderWay == 1) {
                    HomeTopicBinder.Companion.Logic logic2 = this.logic;
                    if (logic2 != null) {
                        Context context2 = this.context;
                        Pair[] pairArr = new Pair[10];
                        pairArr[0] = TuplesKt.m41339to("fromType", 7);
                        pairArr[1] = TuplesKt.m41339to("sceneType", 22);
                        pairArr[2] = TuplesKt.m41339to("source", 1);
                        pairArr[3] = TuplesKt.m41339to(BlocksConst.ACTION_PARAMS_ACT_VALIDATE_TYPE, 1);
                        ActInfoEntity actInfoEntity = homeBusinessInfoRvModel2.mActInfo;
                        if (actInfoEntity == null) {
                            serializable2 = "";
                        } else {
                            serializable2 = actInfoEntity;
                        }
                        pairArr[4] = TuplesKt.m41339to(BlocksConst.ACTION_PARAMS_ACT_INFO, GsonUtil.toJson(serializable2));
                        pairArr[5] = TuplesKt.m41339to("shopId", homeBusinessInfoRvModel2.mShopId);
                        pairArr[6] = TuplesKt.m41339to(BlocksConst.ACTION_PARAMS_ITEM_ID, homeBusinessInfoRvModel2.mItemId);
                        pairArr[7] = TuplesKt.m41339to(BlocksConst.ACTION_PARAMS_HAS_WINE, Integer.valueOf(homeBusinessInfoRvModel2.mHasWine));
                        pairArr[8] = TuplesKt.m41339to(BlocksConst.ACTION_PARAMS_MAX_LEVEL, 2);
                        ItemNodeEntity itemNodeEntity = homeBusinessInfoRvModel2.mNode;
                        if (itemNodeEntity != null) {
                            serializable3 = itemNodeEntity;
                        }
                        pairArr[9] = TuplesKt.m41339to(BlocksConst.ACTION_PARAMS_ITEM_NODE, GsonUtil.toJson(serializable3));
                        logic2.fastBuy(context2, iBlockScope2, MapsKt.hashMapOf(pairArr));
                        return;
                    }
                    return;
                }
                Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.m41339to(Const.PageParams.SHOP_ID, homeBusinessInfoRvModel2.mShopId), TuplesKt.m41339to(Const.PageParams.BIDATA, HomeOmegaHelper.getInstance().getBusinessBiData(homeBusinessInfoRvModel2)));
                CharSequence charSequence = homeBusinessInfoRvModel2.mItemId;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    ActionInfoEntity actionInfoEntity = new ActionInfoEntity();
                    String str = homeBusinessInfoRvModel2.mItemId;
                    Intrinsics.checkNotNullExpressionValue(str, "shop.mItemId");
                    actionInfoEntity.setItemId(str);
                    actionInfoEntity.setType(2);
                    mutableMapOf.put(Const.PageParams.ACTION_INFO_DICT, actionInfoEntity);
                }
                if (homeBusinessInfoRvModel2.mActInfo != null) {
                    String json = GsonUtil.toJson(homeBusinessInfoRvModel2.mActInfo);
                    Intrinsics.checkNotNullExpressionValue(json, "toJson(shop.mActInfo)");
                    mutableMapOf.put(Const.PageParams.ACT_INFO, json);
                }
                HomeTopicBinder.Companion.Logic logic3 = this.logic;
                if (logic3 != null) {
                    Context context3 = this.context;
                    Pair[] pairArr2 = new Pair[6];
                    pairArr2[0] = TuplesKt.m41339to("url", RoutePath.BUSINESS_HOME);
                    pairArr2[1] = TuplesKt.m41339to(BlocksConst.ACTION_PARAMS_ENABLE_PAGE_RESULT, 1);
                    pairArr2[2] = TuplesKt.m41339to("sceneType", 22);
                    pairArr2[3] = TuplesKt.m41339to(BlocksConst.ACTION_PARAMS_ACT_VALIDATE_TYPE, 1);
                    ActInfoEntity actInfoEntity2 = homeBusinessInfoRvModel2.mActInfo;
                    if (actInfoEntity2 != null) {
                        serializable = actInfoEntity2;
                    }
                    pairArr2[4] = TuplesKt.m41339to(BlocksConst.ACTION_PARAMS_ACT_INFO, GsonUtil.toJson(serializable));
                    pairArr2[5] = TuplesKt.m41339to("params", mutableMapOf);
                    logic3.openPage(context3, iBlockScope2, MapsKt.hashMapOf(pairArr2));
                }
            }
        }

        @Metadata(mo148867d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J*\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/HomeTopicItemAdapter$Companion$GoodsHolder;", "Lcom/didi/soda/home/topgun/widget/HomeTopicItemAdapter$Companion$InnerHolder;", "context", "Landroid/content/Context;", "cardView", "Lcom/didi/soda/home/topgun/widget/HomeTopicGoodsItemView;", "(Landroid/content/Context;Lcom/didi/soda/home/topgun/widget/HomeTopicGoodsItemView;)V", "setData", "", "itemModel", "Lcom/didi/soda/home/topgun/binder/model/TopicItemModel;", "model", "Lcom/didi/soda/home/topgun/binder/model/HomeTopicRvModel;", "scope", "Lcom/didi/soda/blocks/scope/BlockScopeBase;", "logic", "Lcom/didi/soda/home/topgun/binder/HomeTopicBinder$Companion$Logic;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
        /* compiled from: HomeTopicItemAdapter.kt */
        public static final class GoodsHolder extends InnerHolder {
            private final HomeTopicGoodsItemView cardView;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public GoodsHolder(Context context, HomeTopicGoodsItemView homeTopicGoodsItemView) {
                super(context, homeTopicGoodsItemView);
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(homeTopicGoodsItemView, "cardView");
                this.cardView = homeTopicGoodsItemView;
            }

            public void setData(TopicItemModel topicItemModel, HomeTopicRvModel homeTopicRvModel, BlockScopeBase blockScopeBase, HomeTopicBinder.Companion.Logic logic) {
                Intrinsics.checkNotNullParameter(topicItemModel, "itemModel");
                Intrinsics.checkNotNullParameter(homeTopicRvModel, "model");
                Intrinsics.checkNotNullParameter(blockScopeBase, "scope");
                super.setData(topicItemModel, homeTopicRvModel, blockScopeBase, logic);
                BusinessGoodsItemRvModel goodsItem = topicItemModel.getGoodsItem();
                if (goodsItem != null) {
                    this.cardView.setData(goodsItem, homeTopicRvModel.isPriceVertical());
                    this.cardView.setBtnClickListener(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002a: INVOKE  
                          (wrap: com.didi.soda.home.topgun.widget.HomeTopicGoodsItemView : 0x0023: IGET  (r0v4 com.didi.soda.home.topgun.widget.HomeTopicGoodsItemView) = 
                          (r2v0 'this' com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$GoodsHolder A[THIS])
                         com.didi.soda.home.topgun.widget.HomeTopicItemAdapter.Companion.GoodsHolder.cardView com.didi.soda.home.topgun.widget.HomeTopicGoodsItemView)
                          (wrap: com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$GoodsHolder$tUBcxdob7y57RUS8iLrcaHHutDU : 0x0027: CONSTRUCTOR  (r1v1 com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$GoodsHolder$tUBcxdob7y57RUS8iLrcaHHutDU) = 
                          (r2v0 'this' com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$GoodsHolder A[THIS])
                          (r5v0 'blockScopeBase' com.didi.soda.blocks.scope.BlockScopeBase)
                          (r3v1 'goodsItem' com.didi.soda.business.model.BusinessGoodsItemRvModel)
                          (r4v0 'homeTopicRvModel' com.didi.soda.home.topgun.binder.model.HomeTopicRvModel)
                         call: com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$GoodsHolder$tUBcxdob7y57RUS8iLrcaHHutDU.<init>(com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$GoodsHolder, com.didi.soda.blocks.scope.BlockScopeBase, com.didi.soda.business.model.BusinessGoodsItemRvModel, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel):void type: CONSTRUCTOR)
                         com.didi.soda.home.topgun.widget.HomeTopicGoodsItemView.setBtnClickListener(android.view.View$OnClickListener):void type: VIRTUAL in method: com.didi.soda.home.topgun.widget.HomeTopicItemAdapter.Companion.GoodsHolder.setData(com.didi.soda.home.topgun.binder.model.TopicItemModel, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel, com.didi.soda.blocks.scope.BlockScopeBase, com.didi.soda.home.topgun.binder.HomeTopicBinder$Companion$Logic):void, dex: classes6.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0027: CONSTRUCTOR  (r1v1 com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$GoodsHolder$tUBcxdob7y57RUS8iLrcaHHutDU) = 
                          (r2v0 'this' com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$GoodsHolder A[THIS])
                          (r5v0 'blockScopeBase' com.didi.soda.blocks.scope.BlockScopeBase)
                          (r3v1 'goodsItem' com.didi.soda.business.model.BusinessGoodsItemRvModel)
                          (r4v0 'homeTopicRvModel' com.didi.soda.home.topgun.binder.model.HomeTopicRvModel)
                         call: com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$GoodsHolder$tUBcxdob7y57RUS8iLrcaHHutDU.<init>(com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$GoodsHolder, com.didi.soda.blocks.scope.BlockScopeBase, com.didi.soda.business.model.BusinessGoodsItemRvModel, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel):void type: CONSTRUCTOR in method: com.didi.soda.home.topgun.widget.HomeTopicItemAdapter.Companion.GoodsHolder.setData(com.didi.soda.home.topgun.binder.model.TopicItemModel, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel, com.didi.soda.blocks.scope.BlockScopeBase, com.didi.soda.home.topgun.binder.HomeTopicBinder$Companion$Logic):void, dex: classes6.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	... 66 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$GoodsHolder$tUBcxdob7y57RUS8iLrcaHHutDU, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:260)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:606)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                        	... 72 more
                        */
                    /*
                        this = this;
                        java.lang.String r0 = "itemModel"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                        java.lang.String r0 = "model"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                        java.lang.String r0 = "scope"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                        super.setData(r3, r4, r5, r6)
                        com.didi.soda.business.model.BusinessGoodsItemRvModel r3 = r3.getGoodsItem()
                        if (r3 != 0) goto L_0x001a
                        goto L_0x0046
                    L_0x001a:
                        com.didi.soda.home.topgun.widget.HomeTopicGoodsItemView r0 = r2.cardView
                        boolean r1 = r4.isPriceVertical()
                        r0.setData(r3, r1)
                        com.didi.soda.home.topgun.widget.HomeTopicGoodsItemView r0 = r2.cardView
                        com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$GoodsHolder$tUBcxdob7y57RUS8iLrcaHHutDU r1 = new com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$GoodsHolder$tUBcxdob7y57RUS8iLrcaHHutDU
                        r1.<init>(r2, r5, r3, r4)
                        r0.setBtnClickListener(r1)
                        com.didi.soda.home.topgun.widget.HomeTopicGoodsItemView r0 = r2.cardView
                        com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$GoodsHolder$jCGhRS0VmGvcAT-eYTXEXNjkXMc r1 = new com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$GoodsHolder$jCGhRS0VmGvcAT-eYTXEXNjkXMc
                        r1.<init>(r2, r5, r3, r4)
                        r0.setOnClickListener(r1)
                        com.didi.soda.home.topgun.widget.HomeTopicGoodsItemView r4 = r2.cardView
                        com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$GoodsHolder$setData$1$3 r5 = new com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$GoodsHolder$setData$1$3
                        r5.<init>(r6, r3)
                        kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
                        r4.setAppearListener(r5)
                        r2.onAppear()
                    L_0x0046:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.widget.HomeTopicItemAdapter.Companion.GoodsHolder.setData(com.didi.soda.home.topgun.binder.model.TopicItemModel, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel, com.didi.soda.blocks.scope.BlockScopeBase, com.didi.soda.home.topgun.binder.HomeTopicBinder$Companion$Logic):void");
                }

                /* access modifiers changed from: private */
                /* renamed from: setData$lambda-2$lambda-0  reason: not valid java name */
                public static final void m47477setData$lambda2$lambda0(GoodsHolder goodsHolder, BlockScopeBase blockScopeBase, BusinessGoodsItemRvModel businessGoodsItemRvModel, HomeTopicRvModel homeTopicRvModel, View view) {
                    Intrinsics.checkNotNullParameter(goodsHolder, "this$0");
                    Intrinsics.checkNotNullParameter(blockScopeBase, "$scope");
                    Intrinsics.checkNotNullParameter(businessGoodsItemRvModel, "$goodsItem");
                    Intrinsics.checkNotNullParameter(homeTopicRvModel, "$model");
                    IBlockScope iBlockScope = blockScopeBase;
                    ButtonInfoEntity buttonInfoEntity = businessGoodsItemRvModel.mBtnInfo;
                    goodsHolder.onGoodItemClick(iBlockScope, true, businessGoodsItemRvModel, homeTopicRvModel, buttonInfoEntity == null ? 0 : buttonInfoEntity.getOrderWay());
                }

                /* access modifiers changed from: private */
                /* renamed from: setData$lambda-2$lambda-1  reason: not valid java name */
                public static final void m47478setData$lambda2$lambda1(GoodsHolder goodsHolder, BlockScopeBase blockScopeBase, BusinessGoodsItemRvModel businessGoodsItemRvModel, HomeTopicRvModel homeTopicRvModel, View view) {
                    Intrinsics.checkNotNullParameter(goodsHolder, "this$0");
                    Intrinsics.checkNotNullParameter(blockScopeBase, "$scope");
                    Intrinsics.checkNotNullParameter(businessGoodsItemRvModel, "$goodsItem");
                    Intrinsics.checkNotNullParameter(homeTopicRvModel, "$model");
                    goodsHolder.onGoodItemClick(blockScopeBase, false, businessGoodsItemRvModel, homeTopicRvModel, businessGoodsItemRvModel.orderWay);
                }
            }

            @Metadata(mo148867d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J*\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/HomeTopicItemAdapter$Companion$ShopItemHolder;", "Lcom/didi/soda/home/topgun/widget/HomeTopicItemAdapter$Companion$InnerHolder;", "context", "Landroid/content/Context;", "cardView", "Lcom/didi/soda/home/topgun/widget/HomeTopicShopItemView;", "(Landroid/content/Context;Lcom/didi/soda/home/topgun/widget/HomeTopicShopItemView;)V", "setData", "", "itemModel", "Lcom/didi/soda/home/topgun/binder/model/TopicItemModel;", "model", "Lcom/didi/soda/home/topgun/binder/model/HomeTopicRvModel;", "scope", "Lcom/didi/soda/blocks/scope/BlockScopeBase;", "logic", "Lcom/didi/soda/home/topgun/binder/HomeTopicBinder$Companion$Logic;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
            /* compiled from: HomeTopicItemAdapter.kt */
            public static final class ShopItemHolder extends InnerHolder {
                private final HomeTopicShopItemView cardView;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public ShopItemHolder(Context context, HomeTopicShopItemView homeTopicShopItemView) {
                    super(context, homeTopicShopItemView);
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(homeTopicShopItemView, "cardView");
                    this.cardView = homeTopicShopItemView;
                }

                public void setData(TopicItemModel topicItemModel, HomeTopicRvModel homeTopicRvModel, BlockScopeBase blockScopeBase, HomeTopicBinder.Companion.Logic logic) {
                    Intrinsics.checkNotNullParameter(topicItemModel, "itemModel");
                    Intrinsics.checkNotNullParameter(homeTopicRvModel, "model");
                    Intrinsics.checkNotNullParameter(blockScopeBase, "scope");
                    super.setData(topicItemModel, homeTopicRvModel, blockScopeBase, logic);
                    HomeBusinessInfoRvModel shopItem = topicItemModel.getShopItem();
                    if (shopItem != null) {
                        this.cardView.setData(shopItem);
                        this.cardView.setOnClickListener(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0025: INVOKE  
                              (wrap: com.didi.soda.home.topgun.widget.HomeTopicShopItemView : 0x001e: IGET  (r0v4 com.didi.soda.home.topgun.widget.HomeTopicShopItemView) = 
                              (r2v0 'this' com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$ShopItemHolder A[THIS])
                             com.didi.soda.home.topgun.widget.HomeTopicItemAdapter.Companion.ShopItemHolder.cardView com.didi.soda.home.topgun.widget.HomeTopicShopItemView)
                              (wrap: com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ShopItemHolder$PER-eHWIQ-7-qlfh5-Du89h92m8 : 0x0022: CONSTRUCTOR  (r1v0 com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ShopItemHolder$PER-eHWIQ-7-qlfh5-Du89h92m8) = 
                              (r2v0 'this' com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$ShopItemHolder A[THIS])
                              (r5v0 'blockScopeBase' com.didi.soda.blocks.scope.BlockScopeBase)
                              (r3v1 'shopItem' com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel)
                              (r4v0 'homeTopicRvModel' com.didi.soda.home.topgun.binder.model.HomeTopicRvModel)
                             call: com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ShopItemHolder$PER-eHWIQ-7-qlfh5-Du89h92m8.<init>(com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$ShopItemHolder, com.didi.soda.blocks.scope.BlockScopeBase, com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel):void type: CONSTRUCTOR)
                             com.didi.soda.home.topgun.widget.HomeTopicShopItemView.setOnClickListener(android.view.View$OnClickListener):void type: VIRTUAL in method: com.didi.soda.home.topgun.widget.HomeTopicItemAdapter.Companion.ShopItemHolder.setData(com.didi.soda.home.topgun.binder.model.TopicItemModel, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel, com.didi.soda.blocks.scope.BlockScopeBase, com.didi.soda.home.topgun.binder.HomeTopicBinder$Companion$Logic):void, dex: classes6.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0022: CONSTRUCTOR  (r1v0 com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ShopItemHolder$PER-eHWIQ-7-qlfh5-Du89h92m8) = 
                              (r2v0 'this' com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$ShopItemHolder A[THIS])
                              (r5v0 'blockScopeBase' com.didi.soda.blocks.scope.BlockScopeBase)
                              (r3v1 'shopItem' com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel)
                              (r4v0 'homeTopicRvModel' com.didi.soda.home.topgun.binder.model.HomeTopicRvModel)
                             call: com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ShopItemHolder$PER-eHWIQ-7-qlfh5-Du89h92m8.<init>(com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$ShopItemHolder, com.didi.soda.blocks.scope.BlockScopeBase, com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel):void type: CONSTRUCTOR in method: com.didi.soda.home.topgun.widget.HomeTopicItemAdapter.Companion.ShopItemHolder.setData(com.didi.soda.home.topgun.binder.model.TopicItemModel, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel, com.didi.soda.blocks.scope.BlockScopeBase, com.didi.soda.home.topgun.binder.HomeTopicBinder$Companion$Logic):void, dex: classes6.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                            	... 66 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ShopItemHolder$PER-eHWIQ-7-qlfh5-Du89h92m8, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:260)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:606)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                            	... 72 more
                            */
                        /*
                            this = this;
                            java.lang.String r0 = "itemModel"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                            java.lang.String r0 = "model"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                            java.lang.String r0 = "scope"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                            super.setData(r3, r4, r5, r6)
                            com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel r3 = r3.getShopItem()
                            if (r3 != 0) goto L_0x0019
                            goto L_0x0037
                        L_0x0019:
                            com.didi.soda.home.topgun.widget.HomeTopicShopItemView r0 = r2.cardView
                            r0.setData(r3)
                            com.didi.soda.home.topgun.widget.HomeTopicShopItemView r0 = r2.cardView
                            com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ShopItemHolder$PER-eHWIQ-7-qlfh5-Du89h92m8 r1 = new com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ShopItemHolder$PER-eHWIQ-7-qlfh5-Du89h92m8
                            r1.<init>(r2, r5, r3, r4)
                            r0.setOnClickListener(r1)
                            com.didi.soda.home.topgun.widget.HomeTopicShopItemView r4 = r2.cardView
                            com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$ShopItemHolder$setData$1$2 r5 = new com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$ShopItemHolder$setData$1$2
                            r5.<init>(r6, r3)
                            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
                            r4.setAppearListener(r5)
                            r2.onAppear()
                        L_0x0037:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.widget.HomeTopicItemAdapter.Companion.ShopItemHolder.setData(com.didi.soda.home.topgun.binder.model.TopicItemModel, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel, com.didi.soda.blocks.scope.BlockScopeBase, com.didi.soda.home.topgun.binder.HomeTopicBinder$Companion$Logic):void");
                    }

                    /* access modifiers changed from: private */
                    /* renamed from: setData$lambda-1$lambda-0  reason: not valid java name */
                    public static final void m47483setData$lambda1$lambda0(ShopItemHolder shopItemHolder, BlockScopeBase blockScopeBase, HomeBusinessInfoRvModel homeBusinessInfoRvModel, HomeTopicRvModel homeTopicRvModel, View view) {
                        Intrinsics.checkNotNullParameter(shopItemHolder, "this$0");
                        Intrinsics.checkNotNullParameter(blockScopeBase, "$scope");
                        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "$shopModel");
                        Intrinsics.checkNotNullParameter(homeTopicRvModel, "$model");
                        shopItemHolder.onShopItemClick(blockScopeBase, homeBusinessInfoRvModel, homeTopicRvModel);
                    }
                }

                @Metadata(mo148867d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J*\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/HomeTopicItemAdapter$Companion$ViewMoreHolder;", "Lcom/didi/soda/home/topgun/widget/HomeTopicItemAdapter$Companion$InnerHolder;", "context", "Landroid/content/Context;", "cardView", "Lcom/didi/soda/home/topgun/widget/HomeTopicMoreView;", "(Landroid/content/Context;Lcom/didi/soda/home/topgun/widget/HomeTopicMoreView;)V", "setData", "", "itemModel", "Lcom/didi/soda/home/topgun/binder/model/TopicItemModel;", "model", "Lcom/didi/soda/home/topgun/binder/model/HomeTopicRvModel;", "scope", "Lcom/didi/soda/blocks/scope/BlockScopeBase;", "logic", "Lcom/didi/soda/home/topgun/binder/HomeTopicBinder$Companion$Logic;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
                /* compiled from: HomeTopicItemAdapter.kt */
                public static final class ViewMoreHolder extends InnerHolder {
                    private final HomeTopicMoreView cardView;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public ViewMoreHolder(Context context, HomeTopicMoreView homeTopicMoreView) {
                        super(context, homeTopicMoreView);
                        Intrinsics.checkNotNullParameter(context, "context");
                        Intrinsics.checkNotNullParameter(homeTopicMoreView, "cardView");
                        this.cardView = homeTopicMoreView;
                    }

                    public void setData(TopicItemModel topicItemModel, HomeTopicRvModel homeTopicRvModel, BlockScopeBase blockScopeBase, HomeTopicBinder.Companion.Logic logic) {
                        Intrinsics.checkNotNullParameter(topicItemModel, "itemModel");
                        Intrinsics.checkNotNullParameter(homeTopicRvModel, "model");
                        Intrinsics.checkNotNullParameter(blockScopeBase, "scope");
                        super.setData(topicItemModel, homeTopicRvModel, blockScopeBase, logic);
                        ViewMoreEntity viewMoreItem = topicItemModel.getViewMoreItem();
                        if (viewMoreItem != null) {
                            this.cardView.setData(viewMoreItem);
                            this.cardView.setOnClickListener(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0025: INVOKE  
                                  (wrap: com.didi.soda.home.topgun.widget.HomeTopicMoreView : 0x001e: IGET  (r2v2 com.didi.soda.home.topgun.widget.HomeTopicMoreView) = 
                                  (r1v0 'this' com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$ViewMoreHolder A[THIS])
                                 com.didi.soda.home.topgun.widget.HomeTopicItemAdapter.Companion.ViewMoreHolder.cardView com.didi.soda.home.topgun.widget.HomeTopicMoreView)
                                  (wrap: com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ViewMoreHolder$2a8wt9l9fEc2T2sqah0zycRQ-qo : 0x0022: CONSTRUCTOR  (r4v2 com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ViewMoreHolder$2a8wt9l9fEc2T2sqah0zycRQ-qo) = 
                                  (r5v0 'logic' com.didi.soda.home.topgun.binder.HomeTopicBinder$Companion$Logic)
                                  (r3v0 'homeTopicRvModel' com.didi.soda.home.topgun.binder.model.HomeTopicRvModel)
                                 call: com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ViewMoreHolder$2a8wt9l9fEc2T2sqah0zycRQ-qo.<init>(com.didi.soda.home.topgun.binder.HomeTopicBinder$Companion$Logic, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel):void type: CONSTRUCTOR)
                                 com.didi.soda.home.topgun.widget.HomeTopicMoreView.setOnClickListener(android.view.View$OnClickListener):void type: VIRTUAL in method: com.didi.soda.home.topgun.widget.HomeTopicItemAdapter.Companion.ViewMoreHolder.setData(com.didi.soda.home.topgun.binder.model.TopicItemModel, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel, com.didi.soda.blocks.scope.BlockScopeBase, com.didi.soda.home.topgun.binder.HomeTopicBinder$Companion$Logic):void, dex: classes6.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0022: CONSTRUCTOR  (r4v2 com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ViewMoreHolder$2a8wt9l9fEc2T2sqah0zycRQ-qo) = 
                                  (r5v0 'logic' com.didi.soda.home.topgun.binder.HomeTopicBinder$Companion$Logic)
                                  (r3v0 'homeTopicRvModel' com.didi.soda.home.topgun.binder.model.HomeTopicRvModel)
                                 call: com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ViewMoreHolder$2a8wt9l9fEc2T2sqah0zycRQ-qo.<init>(com.didi.soda.home.topgun.binder.HomeTopicBinder$Companion$Logic, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel):void type: CONSTRUCTOR in method: com.didi.soda.home.topgun.widget.HomeTopicItemAdapter.Companion.ViewMoreHolder.setData(com.didi.soda.home.topgun.binder.model.TopicItemModel, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel, com.didi.soda.blocks.scope.BlockScopeBase, com.didi.soda.home.topgun.binder.HomeTopicBinder$Companion$Logic):void, dex: classes6.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                                	... 66 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ViewMoreHolder$2a8wt9l9fEc2T2sqah0zycRQ-qo, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:260)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:606)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                	... 72 more
                                */
                            /*
                                this = this;
                                java.lang.String r0 = "itemModel"
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                                java.lang.String r0 = "model"
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                                java.lang.String r0 = "scope"
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                                super.setData(r2, r3, r4, r5)
                                com.didi.soda.customer.foundation.rpc.entity.topgun.ViewMoreEntity r2 = r2.getViewMoreItem()
                                if (r2 != 0) goto L_0x0019
                                goto L_0x002b
                            L_0x0019:
                                com.didi.soda.home.topgun.widget.HomeTopicMoreView r4 = r1.cardView
                                r4.setData(r2)
                                com.didi.soda.home.topgun.widget.HomeTopicMoreView r2 = r1.cardView
                                com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ViewMoreHolder$2a8wt9l9fEc2T2sqah0zycRQ-qo r4 = new com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ViewMoreHolder$2a8wt9l9fEc2T2sqah0zycRQ-qo
                                r4.<init>(r5, r3)
                                r2.setOnClickListener(r4)
                                r1.onAppear()
                            L_0x002b:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.widget.HomeTopicItemAdapter.Companion.ViewMoreHolder.setData(com.didi.soda.home.topgun.binder.model.TopicItemModel, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel, com.didi.soda.blocks.scope.BlockScopeBase, com.didi.soda.home.topgun.binder.HomeTopicBinder$Companion$Logic):void");
                        }

                        /* access modifiers changed from: private */
                        /* renamed from: setData$lambda-1$lambda-0  reason: not valid java name */
                        public static final void m47486setData$lambda1$lambda0(HomeTopicBinder.Companion.Logic logic, HomeTopicRvModel homeTopicRvModel, View view) {
                            Intrinsics.checkNotNullParameter(homeTopicRvModel, "$model");
                            if (logic != null) {
                                logic.toMorePage(homeTopicRvModel, false);
                            }
                        }
                    }

                    @Metadata(mo148867d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J*\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/HomeTopicItemAdapter$Companion$GoodsHolder2;", "Lcom/didi/soda/home/topgun/widget/HomeTopicItemAdapter$Companion$InnerHolder;", "context", "Landroid/content/Context;", "cardView", "Lcom/didi/soda/home/topgun/widget/HomeTopicGoodsItemViewV2;", "(Landroid/content/Context;Lcom/didi/soda/home/topgun/widget/HomeTopicGoodsItemViewV2;)V", "setData", "", "itemModel", "Lcom/didi/soda/home/topgun/binder/model/TopicItemModel;", "model", "Lcom/didi/soda/home/topgun/binder/model/HomeTopicRvModel;", "scope", "Lcom/didi/soda/blocks/scope/BlockScopeBase;", "logic", "Lcom/didi/soda/home/topgun/binder/HomeTopicBinder$Companion$Logic;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
                    /* compiled from: HomeTopicItemAdapter.kt */
                    public static final class GoodsHolder2 extends InnerHolder {
                        private final HomeTopicGoodsItemViewV2 cardView;

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        public GoodsHolder2(Context context, HomeTopicGoodsItemViewV2 homeTopicGoodsItemViewV2) {
                            super(context, homeTopicGoodsItemViewV2);
                            Intrinsics.checkNotNullParameter(context, "context");
                            Intrinsics.checkNotNullParameter(homeTopicGoodsItemViewV2, "cardView");
                            this.cardView = homeTopicGoodsItemViewV2;
                        }

                        public void setData(TopicItemModel topicItemModel, HomeTopicRvModel homeTopicRvModel, BlockScopeBase blockScopeBase, HomeTopicBinder.Companion.Logic logic) {
                            Intrinsics.checkNotNullParameter(topicItemModel, "itemModel");
                            Intrinsics.checkNotNullParameter(homeTopicRvModel, "model");
                            Intrinsics.checkNotNullParameter(blockScopeBase, "scope");
                            super.setData(topicItemModel, homeTopicRvModel, blockScopeBase, logic);
                            BusinessGoodsItemRvModel goodsItem = topicItemModel.getGoodsItem();
                            if (goodsItem != null) {
                                this.cardView.setData(goodsItem, homeTopicRvModel.isPriceVertical());
                                this.cardView.setBtnClickListener(
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0029: INVOKE  
                                      (wrap: com.didi.soda.home.topgun.widget.HomeTopicGoodsItemViewV2 : 0x0022: IGET  (r0v4 com.didi.soda.home.topgun.widget.HomeTopicGoodsItemViewV2) = 
                                      (r2v0 'this' com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$GoodsHolder2 A[THIS])
                                     com.didi.soda.home.topgun.widget.HomeTopicItemAdapter.Companion.GoodsHolder2.cardView com.didi.soda.home.topgun.widget.HomeTopicGoodsItemViewV2)
                                      (wrap: com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$GoodsHolder2$3enfeMUYsHth6citcZHbB6CsS1w : 0x0026: CONSTRUCTOR  (r1v1 com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$GoodsHolder2$3enfeMUYsHth6citcZHbB6CsS1w) = 
                                      (r2v0 'this' com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$GoodsHolder2 A[THIS])
                                      (r5v0 'blockScopeBase' com.didi.soda.blocks.scope.BlockScopeBase)
                                      (r3v1 'goodsItem' com.didi.soda.business.model.BusinessGoodsItemRvModel)
                                      (r4v0 'homeTopicRvModel' com.didi.soda.home.topgun.binder.model.HomeTopicRvModel)
                                     call: com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$GoodsHolder2$3enfeMUYsHth6citcZHbB6CsS1w.<init>(com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$GoodsHolder2, com.didi.soda.blocks.scope.BlockScopeBase, com.didi.soda.business.model.BusinessGoodsItemRvModel, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel):void type: CONSTRUCTOR)
                                     com.didi.soda.home.topgun.widget.HomeTopicGoodsItemViewV2.setBtnClickListener(android.view.View$OnClickListener):void type: VIRTUAL in method: com.didi.soda.home.topgun.widget.HomeTopicItemAdapter.Companion.GoodsHolder2.setData(com.didi.soda.home.topgun.binder.model.TopicItemModel, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel, com.didi.soda.blocks.scope.BlockScopeBase, com.didi.soda.home.topgun.binder.HomeTopicBinder$Companion$Logic):void, dex: classes6.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0026: CONSTRUCTOR  (r1v1 com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$GoodsHolder2$3enfeMUYsHth6citcZHbB6CsS1w) = 
                                      (r2v0 'this' com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$GoodsHolder2 A[THIS])
                                      (r5v0 'blockScopeBase' com.didi.soda.blocks.scope.BlockScopeBase)
                                      (r3v1 'goodsItem' com.didi.soda.business.model.BusinessGoodsItemRvModel)
                                      (r4v0 'homeTopicRvModel' com.didi.soda.home.topgun.binder.model.HomeTopicRvModel)
                                     call: com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$GoodsHolder2$3enfeMUYsHth6citcZHbB6CsS1w.<init>(com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$GoodsHolder2, com.didi.soda.blocks.scope.BlockScopeBase, com.didi.soda.business.model.BusinessGoodsItemRvModel, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel):void type: CONSTRUCTOR in method: com.didi.soda.home.topgun.widget.HomeTopicItemAdapter.Companion.GoodsHolder2.setData(com.didi.soda.home.topgun.binder.model.TopicItemModel, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel, com.didi.soda.blocks.scope.BlockScopeBase, com.didi.soda.home.topgun.binder.HomeTopicBinder$Companion$Logic):void, dex: classes6.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                                    	... 66 more
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$GoodsHolder2$3enfeMUYsHth6citcZHbB6CsS1w, state: NOT_LOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:260)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:606)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                    	... 72 more
                                    */
                                /*
                                    this = this;
                                    java.lang.String r0 = "itemModel"
                                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                                    java.lang.String r0 = "model"
                                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                                    java.lang.String r0 = "scope"
                                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                                    super.setData(r3, r4, r5, r6)
                                    com.didi.soda.business.model.BusinessGoodsItemRvModel r3 = r3.getGoodsItem()
                                    if (r3 != 0) goto L_0x0019
                                    goto L_0x0045
                                L_0x0019:
                                    com.didi.soda.home.topgun.widget.HomeTopicGoodsItemViewV2 r0 = r2.cardView
                                    boolean r1 = r4.isPriceVertical()
                                    r0.setData(r3, r1)
                                    com.didi.soda.home.topgun.widget.HomeTopicGoodsItemViewV2 r0 = r2.cardView
                                    com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$GoodsHolder2$3enfeMUYsHth6citcZHbB6CsS1w r1 = new com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$GoodsHolder2$3enfeMUYsHth6citcZHbB6CsS1w
                                    r1.<init>(r2, r5, r3, r4)
                                    r0.setBtnClickListener(r1)
                                    com.didi.soda.home.topgun.widget.HomeTopicGoodsItemViewV2 r0 = r2.cardView
                                    com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$GoodsHolder2$GDZwGzki87WozvTP-Y-SWWiDpP0 r1 = new com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$GoodsHolder2$GDZwGzki87WozvTP-Y-SWWiDpP0
                                    r1.<init>(r2, r5, r3, r4)
                                    r0.setOnClickListener(r1)
                                    com.didi.soda.home.topgun.widget.HomeTopicGoodsItemViewV2 r4 = r2.cardView
                                    com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$GoodsHolder2$setData$1$3 r5 = new com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$GoodsHolder2$setData$1$3
                                    r5.<init>(r6, r3)
                                    kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
                                    r4.setAppearListener(r5)
                                    r2.onAppear()
                                L_0x0045:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.widget.HomeTopicItemAdapter.Companion.GoodsHolder2.setData(com.didi.soda.home.topgun.binder.model.TopicItemModel, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel, com.didi.soda.blocks.scope.BlockScopeBase, com.didi.soda.home.topgun.binder.HomeTopicBinder$Companion$Logic):void");
                            }

                            /* access modifiers changed from: private */
                            /* renamed from: setData$lambda-2$lambda-0  reason: not valid java name */
                            public static final void m47480setData$lambda2$lambda0(GoodsHolder2 goodsHolder2, BlockScopeBase blockScopeBase, BusinessGoodsItemRvModel businessGoodsItemRvModel, HomeTopicRvModel homeTopicRvModel, View view) {
                                Intrinsics.checkNotNullParameter(goodsHolder2, "this$0");
                                Intrinsics.checkNotNullParameter(blockScopeBase, "$scope");
                                Intrinsics.checkNotNullParameter(businessGoodsItemRvModel, "$goodsItem");
                                Intrinsics.checkNotNullParameter(homeTopicRvModel, "$model");
                                IBlockScope iBlockScope = blockScopeBase;
                                ButtonInfoEntity buttonInfoEntity = businessGoodsItemRvModel.mBtnInfo;
                                goodsHolder2.onGoodItemClick(iBlockScope, true, businessGoodsItemRvModel, homeTopicRvModel, buttonInfoEntity == null ? 0 : buttonInfoEntity.getOrderWay());
                            }

                            /* access modifiers changed from: private */
                            /* renamed from: setData$lambda-2$lambda-1  reason: not valid java name */
                            public static final void m47481setData$lambda2$lambda1(GoodsHolder2 goodsHolder2, BlockScopeBase blockScopeBase, BusinessGoodsItemRvModel businessGoodsItemRvModel, HomeTopicRvModel homeTopicRvModel, View view) {
                                Intrinsics.checkNotNullParameter(goodsHolder2, "this$0");
                                Intrinsics.checkNotNullParameter(blockScopeBase, "$scope");
                                Intrinsics.checkNotNullParameter(businessGoodsItemRvModel, "$goodsItem");
                                Intrinsics.checkNotNullParameter(homeTopicRvModel, "$model");
                                goodsHolder2.onGoodItemClick(blockScopeBase, false, businessGoodsItemRvModel, homeTopicRvModel, businessGoodsItemRvModel.orderWay);
                            }
                        }

                        @Metadata(mo148867d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J*\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/HomeTopicItemAdapter$Companion$ShopItemHolder2;", "Lcom/didi/soda/home/topgun/widget/HomeTopicItemAdapter$Companion$InnerHolder;", "context", "Landroid/content/Context;", "cardView", "Lcom/didi/soda/home/topgun/widget/HomeTopicShopItemViewV2;", "(Landroid/content/Context;Lcom/didi/soda/home/topgun/widget/HomeTopicShopItemViewV2;)V", "setData", "", "itemModel", "Lcom/didi/soda/home/topgun/binder/model/TopicItemModel;", "model", "Lcom/didi/soda/home/topgun/binder/model/HomeTopicRvModel;", "scope", "Lcom/didi/soda/blocks/scope/BlockScopeBase;", "logic", "Lcom/didi/soda/home/topgun/binder/HomeTopicBinder$Companion$Logic;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
                        /* compiled from: HomeTopicItemAdapter.kt */
                        public static final class ShopItemHolder2 extends InnerHolder {
                            private final HomeTopicShopItemViewV2 cardView;

                            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                            public ShopItemHolder2(Context context, HomeTopicShopItemViewV2 homeTopicShopItemViewV2) {
                                super(context, homeTopicShopItemViewV2);
                                Intrinsics.checkNotNullParameter(context, "context");
                                Intrinsics.checkNotNullParameter(homeTopicShopItemViewV2, "cardView");
                                this.cardView = homeTopicShopItemViewV2;
                            }

                            public void setData(TopicItemModel topicItemModel, HomeTopicRvModel homeTopicRvModel, BlockScopeBase blockScopeBase, HomeTopicBinder.Companion.Logic logic) {
                                Intrinsics.checkNotNullParameter(topicItemModel, "itemModel");
                                Intrinsics.checkNotNullParameter(homeTopicRvModel, "model");
                                Intrinsics.checkNotNullParameter(blockScopeBase, "scope");
                                super.setData(topicItemModel, homeTopicRvModel, blockScopeBase, logic);
                                HomeBusinessInfoRvModel shopItem = topicItemModel.getShopItem();
                                if (shopItem != null) {
                                    this.cardView.setData(shopItem);
                                    this.cardView.setOnClickListener(
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0025: INVOKE  
                                          (wrap: com.didi.soda.home.topgun.widget.HomeTopicShopItemViewV2 : 0x001e: IGET  (r0v4 com.didi.soda.home.topgun.widget.HomeTopicShopItemViewV2) = 
                                          (r2v0 'this' com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$ShopItemHolder2 A[THIS])
                                         com.didi.soda.home.topgun.widget.HomeTopicItemAdapter.Companion.ShopItemHolder2.cardView com.didi.soda.home.topgun.widget.HomeTopicShopItemViewV2)
                                          (wrap: com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ShopItemHolder2$Zi9TS7DAGOi9lk0nXiZVsmwug5A : 0x0022: CONSTRUCTOR  (r1v0 com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ShopItemHolder2$Zi9TS7DAGOi9lk0nXiZVsmwug5A) = 
                                          (r2v0 'this' com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$ShopItemHolder2 A[THIS])
                                          (r5v0 'blockScopeBase' com.didi.soda.blocks.scope.BlockScopeBase)
                                          (r3v1 'shopItem' com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel)
                                          (r4v0 'homeTopicRvModel' com.didi.soda.home.topgun.binder.model.HomeTopicRvModel)
                                         call: com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ShopItemHolder2$Zi9TS7DAGOi9lk0nXiZVsmwug5A.<init>(com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$ShopItemHolder2, com.didi.soda.blocks.scope.BlockScopeBase, com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel):void type: CONSTRUCTOR)
                                         com.didi.soda.home.topgun.widget.HomeTopicShopItemViewV2.setOnClickListener(android.view.View$OnClickListener):void type: VIRTUAL in method: com.didi.soda.home.topgun.widget.HomeTopicItemAdapter.Companion.ShopItemHolder2.setData(com.didi.soda.home.topgun.binder.model.TopicItemModel, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel, com.didi.soda.blocks.scope.BlockScopeBase, com.didi.soda.home.topgun.binder.HomeTopicBinder$Companion$Logic):void, dex: classes6.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0022: CONSTRUCTOR  (r1v0 com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ShopItemHolder2$Zi9TS7DAGOi9lk0nXiZVsmwug5A) = 
                                          (r2v0 'this' com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$ShopItemHolder2 A[THIS])
                                          (r5v0 'blockScopeBase' com.didi.soda.blocks.scope.BlockScopeBase)
                                          (r3v1 'shopItem' com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel)
                                          (r4v0 'homeTopicRvModel' com.didi.soda.home.topgun.binder.model.HomeTopicRvModel)
                                         call: com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ShopItemHolder2$Zi9TS7DAGOi9lk0nXiZVsmwug5A.<init>(com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$ShopItemHolder2, com.didi.soda.blocks.scope.BlockScopeBase, com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel):void type: CONSTRUCTOR in method: com.didi.soda.home.topgun.widget.HomeTopicItemAdapter.Companion.ShopItemHolder2.setData(com.didi.soda.home.topgun.binder.model.TopicItemModel, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel, com.didi.soda.blocks.scope.BlockScopeBase, com.didi.soda.home.topgun.binder.HomeTopicBinder$Companion$Logic):void, dex: classes6.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                                        	... 66 more
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ShopItemHolder2$Zi9TS7DAGOi9lk0nXiZVsmwug5A, state: NOT_LOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:260)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:606)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                        	... 72 more
                                        */
                                    /*
                                        this = this;
                                        java.lang.String r0 = "itemModel"
                                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                                        java.lang.String r0 = "model"
                                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                                        java.lang.String r0 = "scope"
                                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                                        super.setData(r3, r4, r5, r6)
                                        com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel r3 = r3.getShopItem()
                                        if (r3 != 0) goto L_0x0019
                                        goto L_0x0037
                                    L_0x0019:
                                        com.didi.soda.home.topgun.widget.HomeTopicShopItemViewV2 r0 = r2.cardView
                                        r0.setData(r3)
                                        com.didi.soda.home.topgun.widget.HomeTopicShopItemViewV2 r0 = r2.cardView
                                        com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ShopItemHolder2$Zi9TS7DAGOi9lk0nXiZVsmwug5A r1 = new com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ShopItemHolder2$Zi9TS7DAGOi9lk0nXiZVsmwug5A
                                        r1.<init>(r2, r5, r3, r4)
                                        r0.setOnClickListener(r1)
                                        com.didi.soda.home.topgun.widget.HomeTopicShopItemViewV2 r4 = r2.cardView
                                        com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$ShopItemHolder2$setData$1$2 r5 = new com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$ShopItemHolder2$setData$1$2
                                        r5.<init>(r6, r3)
                                        kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
                                        r4.setAppearListener(r5)
                                        r2.onAppear()
                                    L_0x0037:
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.widget.HomeTopicItemAdapter.Companion.ShopItemHolder2.setData(com.didi.soda.home.topgun.binder.model.TopicItemModel, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel, com.didi.soda.blocks.scope.BlockScopeBase, com.didi.soda.home.topgun.binder.HomeTopicBinder$Companion$Logic):void");
                                }

                                /* access modifiers changed from: private */
                                /* renamed from: setData$lambda-1$lambda-0  reason: not valid java name */
                                public static final void m47484setData$lambda1$lambda0(ShopItemHolder2 shopItemHolder2, BlockScopeBase blockScopeBase, HomeBusinessInfoRvModel homeBusinessInfoRvModel, HomeTopicRvModel homeTopicRvModel, View view) {
                                    Intrinsics.checkNotNullParameter(shopItemHolder2, "this$0");
                                    Intrinsics.checkNotNullParameter(blockScopeBase, "$scope");
                                    Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "$shopModel");
                                    Intrinsics.checkNotNullParameter(homeTopicRvModel, "$model");
                                    shopItemHolder2.onShopItemClick(blockScopeBase, homeBusinessInfoRvModel, homeTopicRvModel);
                                }
                            }

                            @Metadata(mo148867d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J*\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/HomeTopicItemAdapter$Companion$ViewMoreHolder2;", "Lcom/didi/soda/home/topgun/widget/HomeTopicItemAdapter$Companion$InnerHolder;", "context", "Landroid/content/Context;", "cardView", "Lcom/didi/soda/home/topgun/widget/HomeTopicMoreViewV2;", "(Landroid/content/Context;Lcom/didi/soda/home/topgun/widget/HomeTopicMoreViewV2;)V", "setData", "", "itemModel", "Lcom/didi/soda/home/topgun/binder/model/TopicItemModel;", "model", "Lcom/didi/soda/home/topgun/binder/model/HomeTopicRvModel;", "scope", "Lcom/didi/soda/blocks/scope/BlockScopeBase;", "logic", "Lcom/didi/soda/home/topgun/binder/HomeTopicBinder$Companion$Logic;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
                            /* compiled from: HomeTopicItemAdapter.kt */
                            public static final class ViewMoreHolder2 extends InnerHolder {
                                private final HomeTopicMoreViewV2 cardView;

                                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                                public ViewMoreHolder2(Context context, HomeTopicMoreViewV2 homeTopicMoreViewV2) {
                                    super(context, homeTopicMoreViewV2);
                                    Intrinsics.checkNotNullParameter(context, "context");
                                    Intrinsics.checkNotNullParameter(homeTopicMoreViewV2, "cardView");
                                    this.cardView = homeTopicMoreViewV2;
                                }

                                public void setData(TopicItemModel topicItemModel, HomeTopicRvModel homeTopicRvModel, BlockScopeBase blockScopeBase, HomeTopicBinder.Companion.Logic logic) {
                                    Intrinsics.checkNotNullParameter(topicItemModel, "itemModel");
                                    Intrinsics.checkNotNullParameter(homeTopicRvModel, "model");
                                    Intrinsics.checkNotNullParameter(blockScopeBase, "scope");
                                    super.setData(topicItemModel, homeTopicRvModel, blockScopeBase, logic);
                                    ViewMoreEntity viewMoreItem = topicItemModel.getViewMoreItem();
                                    if (viewMoreItem != null) {
                                        this.cardView.setData(viewMoreItem);
                                        this.cardView.setOnClickListener(
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0025: INVOKE  
                                              (wrap: com.didi.soda.home.topgun.widget.HomeTopicMoreViewV2 : 0x001e: IGET  (r2v2 com.didi.soda.home.topgun.widget.HomeTopicMoreViewV2) = 
                                              (r1v0 'this' com.didi.soda.home.topgun.widget.HomeTopicItemAdapter$Companion$ViewMoreHolder2 A[THIS])
                                             com.didi.soda.home.topgun.widget.HomeTopicItemAdapter.Companion.ViewMoreHolder2.cardView com.didi.soda.home.topgun.widget.HomeTopicMoreViewV2)
                                              (wrap: com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ViewMoreHolder2$ngE1P-ercMsSepylPd6Nvxodpvk : 0x0022: CONSTRUCTOR  (r4v2 com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ViewMoreHolder2$ngE1P-ercMsSepylPd6Nvxodpvk) = 
                                              (r5v0 'logic' com.didi.soda.home.topgun.binder.HomeTopicBinder$Companion$Logic)
                                              (r3v0 'homeTopicRvModel' com.didi.soda.home.topgun.binder.model.HomeTopicRvModel)
                                             call: com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ViewMoreHolder2$ngE1P-ercMsSepylPd6Nvxodpvk.<init>(com.didi.soda.home.topgun.binder.HomeTopicBinder$Companion$Logic, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel):void type: CONSTRUCTOR)
                                             com.didi.soda.home.topgun.widget.HomeTopicMoreViewV2.setOnClickListener(android.view.View$OnClickListener):void type: VIRTUAL in method: com.didi.soda.home.topgun.widget.HomeTopicItemAdapter.Companion.ViewMoreHolder2.setData(com.didi.soda.home.topgun.binder.model.TopicItemModel, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel, com.didi.soda.blocks.scope.BlockScopeBase, com.didi.soda.home.topgun.binder.HomeTopicBinder$Companion$Logic):void, dex: classes6.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                                            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                                            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0022: CONSTRUCTOR  (r4v2 com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ViewMoreHolder2$ngE1P-ercMsSepylPd6Nvxodpvk) = 
                                              (r5v0 'logic' com.didi.soda.home.topgun.binder.HomeTopicBinder$Companion$Logic)
                                              (r3v0 'homeTopicRvModel' com.didi.soda.home.topgun.binder.model.HomeTopicRvModel)
                                             call: com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ViewMoreHolder2$ngE1P-ercMsSepylPd6Nvxodpvk.<init>(com.didi.soda.home.topgun.binder.HomeTopicBinder$Companion$Logic, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel):void type: CONSTRUCTOR in method: com.didi.soda.home.topgun.widget.HomeTopicItemAdapter.Companion.ViewMoreHolder2.setData(com.didi.soda.home.topgun.binder.model.TopicItemModel, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel, com.didi.soda.blocks.scope.BlockScopeBase, com.didi.soda.home.topgun.binder.HomeTopicBinder$Companion$Logic):void, dex: classes6.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                                            	... 66 more
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ViewMoreHolder2$ngE1P-ercMsSepylPd6Nvxodpvk, state: NOT_LOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:260)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:606)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                            	... 72 more
                                            */
                                        /*
                                            this = this;
                                            java.lang.String r0 = "itemModel"
                                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                                            java.lang.String r0 = "model"
                                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                                            java.lang.String r0 = "scope"
                                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                                            super.setData(r2, r3, r4, r5)
                                            com.didi.soda.customer.foundation.rpc.entity.topgun.ViewMoreEntity r2 = r2.getViewMoreItem()
                                            if (r2 != 0) goto L_0x0019
                                            goto L_0x002b
                                        L_0x0019:
                                            com.didi.soda.home.topgun.widget.HomeTopicMoreViewV2 r4 = r1.cardView
                                            r4.setData(r2)
                                            com.didi.soda.home.topgun.widget.HomeTopicMoreViewV2 r2 = r1.cardView
                                            com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ViewMoreHolder2$ngE1P-ercMsSepylPd6Nvxodpvk r4 = new com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicItemAdapter$Companion$ViewMoreHolder2$ngE1P-ercMsSepylPd6Nvxodpvk
                                            r4.<init>(r5, r3)
                                            r2.setOnClickListener(r4)
                                            r1.onAppear()
                                        L_0x002b:
                                            return
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.widget.HomeTopicItemAdapter.Companion.ViewMoreHolder2.setData(com.didi.soda.home.topgun.binder.model.TopicItemModel, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel, com.didi.soda.blocks.scope.BlockScopeBase, com.didi.soda.home.topgun.binder.HomeTopicBinder$Companion$Logic):void");
                                    }

                                    /* access modifiers changed from: private */
                                    /* renamed from: setData$lambda-1$lambda-0  reason: not valid java name */
                                    public static final void m47488setData$lambda1$lambda0(HomeTopicBinder.Companion.Logic logic, HomeTopicRvModel homeTopicRvModel, View view) {
                                        Intrinsics.checkNotNullParameter(homeTopicRvModel, "$model");
                                        if (logic != null) {
                                            logic.toMorePage(homeTopicRvModel, false);
                                        }
                                    }
                                }
                            }
                        }
