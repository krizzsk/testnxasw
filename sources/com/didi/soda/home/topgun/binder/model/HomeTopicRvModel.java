package com.didi.soda.home.topgun.binder.model;

import android.widget.LinearLayout;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.PromptEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ViewMoreEntity;
import com.didi.soda.customer.foundation.tracker.model.ModuleModelV2;
import com.didi.soda.customer.foundation.util.ExtentionsKt;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.home.topgun.widget.HomeTopicGoodsItemView;
import com.didi.soda.home.topgun.widget.HomeTopicGoodsItemViewV2;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0005¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001a\u0010\u001d\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR*\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006."}, mo148868d2 = {"Lcom/didi/soda/home/topgun/binder/model/HomeTopicRvModel;", "Lcom/didi/soda/customer/foundation/tracker/model/ModuleModelV2;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "createTime", "", "getCreateTime", "()J", "setCreateTime", "(J)V", "data", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeTopicEntity;", "getData", "()Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeTopicEntity;", "setData", "(Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeTopicEntity;)V", "filterParams", "", "getFilterParams", "()Ljava/lang/String;", "setFilterParams", "(Ljava/lang/String;)V", "isNewTopic", "", "()Z", "setNewTopic", "(Z)V", "isPlayingRightTopAnim", "setPlayingRightTopAnim", "isPriceVertical", "setPriceVertical", "itemList", "Ljava/util/ArrayList;", "Lcom/didi/soda/home/topgun/binder/model/TopicItemModel;", "Lkotlin/collections/ArrayList;", "getItemList", "()Ljava/util/ArrayList;", "setItemList", "(Ljava/util/ArrayList;)V", "payload", "Lcom/didi/soda/datasource/parser/FeedPayload;", "getPayload", "()Lcom/didi/soda/datasource/parser/FeedPayload;", "setPayload", "(Lcom/didi/soda/datasource/parser/FeedPayload;)V", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HomeTopicRvModel.kt */
public final class HomeTopicRvModel extends ModuleModelV2 implements RecyclerModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private HomeTopicEntity f45275a;

    /* renamed from: b */
    private FeedPayload f45276b;

    /* renamed from: c */
    private long f45277c;

    /* renamed from: d */
    private boolean f45278d;

    /* renamed from: e */
    private String f45279e;

    /* renamed from: f */
    private boolean f45280f;

    /* renamed from: g */
    private ArrayList<TopicItemModel> f45281g = new ArrayList<>();

    /* renamed from: h */
    private boolean f45282h;

    public final HomeTopicEntity getData() {
        return this.f45275a;
    }

    public final void setData(HomeTopicEntity homeTopicEntity) {
        this.f45275a = homeTopicEntity;
    }

    public final FeedPayload getPayload() {
        return this.f45276b;
    }

    public final void setPayload(FeedPayload feedPayload) {
        this.f45276b = feedPayload;
    }

    public final long getCreateTime() {
        return this.f45277c;
    }

    public final void setCreateTime(long j) {
        this.f45277c = j;
    }

    public final boolean isPlayingRightTopAnim() {
        return this.f45278d;
    }

    public final void setPlayingRightTopAnim(boolean z) {
        this.f45278d = z;
    }

    public final String getFilterParams() {
        return this.f45279e;
    }

    public final void setFilterParams(String str) {
        this.f45279e = str;
    }

    public final boolean isNewTopic() {
        return this.f45280f;
    }

    public final void setNewTopic(boolean z) {
        this.f45280f = z;
    }

    public final ArrayList<TopicItemModel> getItemList() {
        return this.f45281g;
    }

    public final void setItemList(ArrayList<TopicItemModel> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.f45281g = arrayList;
    }

    public final boolean isPriceVertical() {
        return this.f45282h;
    }

    public final void setPriceVertical(boolean z) {
        this.f45282h = z;
    }

    @Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/binder/model/HomeTopicRvModel$Companion;", "", "()V", "convert", "Lcom/didi/soda/home/topgun/binder/model/HomeTopicRvModel;", "compJson", "Lcom/google/gson/JsonObject;", "payload", "Lcom/didi/soda/datasource/parser/FeedPayload;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: HomeTopicRvModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HomeTopicRvModel convert(JsonObject jsonObject, FeedPayload feedPayload) {
            JsonElement jsonElement;
            Integer num;
            String str;
            String str2;
            PromptEntity promptEntity;
            JsonObject jsonObject2 = jsonObject;
            FeedPayload feedPayload2 = feedPayload;
            HomeTopicRvModel homeTopicRvModel = new HomeTopicRvModel();
            String str3 = null;
            if (jsonObject2 == null) {
                jsonElement = null;
            } else {
                jsonElement = jsonObject2.get("data");
            }
            if (jsonElement == null) {
                return homeTopicRvModel;
            }
            try {
                Object fromJson = GsonUtil.fromJson(jsonElement, (Type) HomeTopicEntity.class);
                Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(dataElement, HomeTopicEntity::class.java)");
                HomeTopicEntity homeTopicEntity = (HomeTopicEntity) fromJson;
                if (feedPayload2 == null) {
                    num = null;
                } else {
                    num = Integer.valueOf(feedPayload2.mComponentIndex);
                }
                homeTopicRvModel.mAbsoluteIndex = ExtentionsKt.orZero(num);
                JsonElement jsonElement2 = jsonObject2.get(BlocksConst.BLOCK_PARAM_COMPONENT_ID);
                String asString = jsonElement2 == null ? null : jsonElement2.getAsString();
                String str4 = "";
                if (asString == null) {
                    asString = str4;
                }
                homeTopicRvModel.mComponentId = asString;
                JsonElement jsonElement3 = jsonObject2.get("position");
                homeTopicRvModel.mIndexInModule = ExtentionsKt.orZero(jsonElement3 == null ? null : Integer.valueOf(jsonElement3.getAsInt()));
                JsonElement jsonElement4 = jsonObject2.get("type");
                String asString2 = jsonElement4 == null ? null : jsonElement4.getAsString();
                if (asString2 != null) {
                    str4 = asString2;
                }
                homeTopicRvModel.mComponentType = str4;
                homeTopicRvModel.setData(homeTopicEntity);
                homeTopicRvModel.setPayload(feedPayload2);
                homeTopicRvModel.setCreateTime(System.currentTimeMillis());
                if (feedPayload2 == null) {
                    str = null;
                } else {
                    str = feedPayload2.mRecId;
                }
                homeTopicRvModel.mRecId = str;
                if (feedPayload2 == null) {
                    str2 = null;
                } else {
                    str2 = feedPayload2.mTraceId;
                }
                homeTopicRvModel.mTraceId = str2;
                boolean z = false;
                homeTopicRvModel.setNewTopic(homeTopicEntity.showVersion == 1);
                if (homeTopicRvModel.isNewTopic()) {
                    LinearLayout initLayout = HomeTopicGoodsItemViewV2.Companion.initLayout();
                    List<GoodsItemEntity> list = homeTopicEntity.mItems;
                    if (list != null) {
                        for (GoodsItemEntity goodsItemEntity : list) {
                            ArrayList<TopicItemModel> itemList = homeTopicRvModel.getItemList();
                            BusinessGoodsItemRvModel newInstance = BusinessGoodsItemRvModel.newInstance(goodsItemEntity);
                            Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(it)");
                            itemList.add(new TopicItemModel(newInstance, homeTopicRvModel.isNewTopic()));
                            if (!homeTopicRvModel.isPriceVertical()) {
                                homeTopicRvModel.setPriceVertical(HomeTopicGoodsItemViewV2.Companion.isPriceNeedVertical(goodsItemEntity.priceDesc, goodsItemEntity.origPriceDesc, initLayout));
                            }
                        }
                    }
                } else {
                    LinearLayout initLayout2 = HomeTopicGoodsItemView.Companion.initLayout();
                    List<GoodsItemEntity> list2 = homeTopicEntity.mItems;
                    if (list2 != null) {
                        for (GoodsItemEntity goodsItemEntity2 : list2) {
                            ArrayList<TopicItemModel> itemList2 = homeTopicRvModel.getItemList();
                            BusinessGoodsItemRvModel newInstance2 = BusinessGoodsItemRvModel.newInstance(goodsItemEntity2);
                            Intrinsics.checkNotNullExpressionValue(newInstance2, "newInstance(it)");
                            itemList2.add(new TopicItemModel(newInstance2, homeTopicRvModel.isNewTopic()));
                            if (!homeTopicRvModel.isPriceVertical()) {
                                homeTopicRvModel.setPriceVertical(HomeTopicGoodsItemView.Companion.isPriceNeedVertical(goodsItemEntity2.priceDesc, goodsItemEntity2.origPriceDesc, initLayout2));
                            }
                        }
                    }
                }
                LinesVisibleModel linesVisibleModel = new LinesVisibleModel(false, false, false, 7, (DefaultConstructorMarker) null);
                List<BusinessInfoEntity> list3 = homeTopicEntity.mShopList;
                if (list3 != null) {
                    for (BusinessInfoEntity convertBusinessInfoEntity : list3) {
                        ArrayList<TopicItemModel> itemList3 = homeTopicRvModel.getItemList();
                        HomeBusinessInfoRvModel convertBusinessInfoEntity2 = HomeBusinessInfoRvModel.convertBusinessInfoEntity(convertBusinessInfoEntity, feedPayload2);
                        Intrinsics.checkNotNullExpressionValue(convertBusinessInfoEntity2, "convertBusinessInfoEntity(it, payload)");
                        TopicItemModel topicItemModel = new TopicItemModel(convertBusinessInfoEntity2, homeTopicRvModel.isNewTopic());
                        if (homeTopicRvModel.isNewTopic()) {
                            HomeBusinessInfoRvModel shopItem = topicItemModel.getShopItem();
                            Collection collection = shopItem == null ? null : shopItem.mRating;
                            if (!(collection == null || collection.isEmpty())) {
                                linesVisibleModel.setHasRatingLine(true);
                            }
                            HomeBusinessInfoRvModel shopItem2 = topicItemModel.getShopItem();
                            Collection collection2 = shopItem2 == null ? null : shopItem2.mFulfillment;
                            if (!(collection2 == null || collection2.isEmpty())) {
                                linesVisibleModel.setHasFulfillmentLine(true);
                            }
                            HomeBusinessInfoRvModel shopItem3 = topicItemModel.getShopItem();
                            CharSequence charSequence = (shopItem3 == null || (promptEntity = shopItem3.mRecInfo) == null) ? null : promptEntity.content;
                            if (!(charSequence == null || charSequence.length() == 0)) {
                                linesVisibleModel.setHasRecLine(true);
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                        itemList3.add(topicItemModel);
                    }
                }
                if (homeTopicRvModel.isNewTopic()) {
                    Collection collection3 = homeTopicEntity.mShopList;
                    if (collection3 == null || collection3.isEmpty()) {
                        z = true;
                    }
                    if (!z) {
                        for (TopicItemModel shopItem4 : homeTopicRvModel.getItemList()) {
                            HomeBusinessInfoRvModel shopItem5 = shopItem4.getShopItem();
                            if (shopItem5 != null) {
                                shopItem5.linesVisibleModel = linesVisibleModel;
                            }
                        }
                    }
                }
                ViewMoreEntity viewMoreEntity = homeTopicEntity.mViewMore;
                if (viewMoreEntity != null) {
                    homeTopicRvModel.getItemList().add(new TopicItemModel(viewMoreEntity, homeTopicRvModel.isNewTopic()));
                }
                if (feedPayload2 != null) {
                    str3 = feedPayload2.mPageFilter;
                }
                homeTopicRvModel.setFilterParams(str3);
            } catch (Exception unused) {
            }
            return homeTopicRvModel;
        }
    }
}
