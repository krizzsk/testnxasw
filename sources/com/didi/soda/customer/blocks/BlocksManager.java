package com.didi.soda.customer.blocks;

import android.content.Context;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.entity.CallBackEntity;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.blocks.sdk.config.BlocksConfig;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.business.binder.home.BusinessLittleStepperBinder;
import com.didi.soda.business.widget.BusinessHorizontalScroller;
import com.didi.soda.customer.blocks.actions.BusinessCardClickAction;
import com.didi.soda.customer.blocks.actions.BusinessCardExposureAction;
import com.didi.soda.customer.blocks.actions.CheckStatuOpenPageAction;
import com.didi.soda.customer.blocks.actions.FastBuyAction;
import com.didi.soda.customer.blocks.actions.OpenPageAction;
import com.didi.soda.customer.blocks.actions.SetGuideAction;
import com.didi.soda.customer.blocks.actions.ToastAction;
import com.didi.soda.customer.blocks.actions.TrackAction;
import com.didi.soda.customer.blocks.card.LandingTopicWidget;
import com.didi.soda.customer.blocks.card.LeftImageBusinessItemWidget;
import com.didi.soda.customer.blocks.card.RemainWidget;
import com.didi.soda.customer.blocks.card.RowTwinWidget;
import com.didi.soda.customer.blocks.card.SearchSugShopWidget;
import com.didi.soda.customer.blocks.card.TabsWidget;
import com.didi.soda.customer.blocks.card.TopImageBusinessItemWidget;
import com.didi.soda.customer.blocks.card.TopicHeaderWidget;
import com.didi.soda.customer.blocks.card.TopicItemWidget;
import com.didi.soda.customer.blocks.card.TopicWidget;
import com.didi.soda.customer.blocks.card.suapp.SaTopicItemActionWidget;
import com.didi.soda.customer.blocks.card.suapp.SaTopicItemPriceWidget;
import com.didi.soda.customer.blocks.card.suapp.SaTopicItemWidget;
import com.didi.soda.customer.blocks.card.suapp.SaTopicMoreWidget;
import com.didi.soda.customer.blocks.widget.ColumnWidget;
import com.didi.soda.customer.blocks.widget.DishWidget;
import com.didi.soda.customer.blocks.widget.GridWidget;
import com.didi.soda.customer.blocks.widget.IconAndTextBackgroundWidget;
import com.didi.soda.customer.blocks.widget.IconAndTextWidget;
import com.didi.soda.customer.blocks.widget.ImageWidget;
import com.didi.soda.customer.blocks.widget.InfoTagCommonWidget;
import com.didi.soda.customer.blocks.widget.InfoTagWidget;
import com.didi.soda.customer.blocks.widget.LogoContentWidget;
import com.didi.soda.customer.blocks.widget.LogoTextWidget;
import com.didi.soda.customer.blocks.widget.MaskWidget;
import com.didi.soda.customer.blocks.widget.RowWidget;
import com.didi.soda.customer.blocks.widget.ScrollWidget;
import com.didi.soda.customer.blocks.widget.TagWidget;
import com.didi.soda.customer.blocks.widget.TimerWidget;
import com.didi.soda.customer.blocks.widget.TitleWidget;
import com.didi.soda.customer.blocks.widget.TopicMoreWidget;
import com.didi.soda.customer.blocks.widget.TopicPriceActionWidget;
import com.didi.soda.customer.blocks.widget.binder.FeedBackBinder;
import com.didi.soda.customer.blocks.widget.binder.IconTextBinder;
import com.didi.soda.customer.blocks.widget.binder.SodaTextBinder;
import com.didi.soda.customer.blocks.widget.binder.TailIconTextBinder;
import com.didi.soda.customer.blocks.widget.binder.TouchableMaskBinder;
import com.didi.soda.customer.debug.CustomerToolBoxUtil;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R1\u0010\u0003\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u0004j\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R1\u0010\f\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\u00050\u0004j\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\u0005`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t¨\u0006\u0013"}, mo148868d2 = {"Lcom/didi/soda/customer/blocks/BlocksManager;", "", "()V", "actionList", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/didi/soda/blocks/action/BaseAction;", "Lkotlin/collections/ArrayList;", "getActionList", "()Ljava/util/ArrayList;", "isInit", "", "widgetList", "Lcom/didi/soda/blocks/widget/Buildable;", "getWidgetList", "initBlocks", "", "initContext", "Landroid/content/Context;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BlocksManager.kt */
public final class BlocksManager {
    public static final BlocksManager INSTANCE = new BlocksManager();

    /* renamed from: a */
    private static boolean f43139a;

    /* renamed from: b */
    private static final ArrayList<Class<? extends Buildable>> f43140b = CollectionsKt.arrayListOf(LeftImageBusinessItemWidget.class, TopImageBusinessItemWidget.class, IconAndTextBackgroundWidget.class, IconAndTextWidget.class, ImageWidget.class, TagWidget.class, TitleWidget.class, InfoTagWidget.class, MaskWidget.class, GridWidget.class, TopicWidget.class, TopicHeaderWidget.class, ScrollWidget.class, RowWidget.class, TopicMoreWidget.class, TopicItemWidget.class, ColumnWidget.class, DishWidget.class, InfoTagCommonWidget.class, TopicPriceActionWidget.class, RowTwinWidget.class, LandingTopicWidget.class, LogoTextWidget.class, TimerWidget.class, RemainWidget.class, TabsWidget.class, LogoContentWidget.class, SearchSugShopWidget.class, SaTopicItemWidget.class, SaTopicMoreWidget.class, SaTopicItemPriceWidget.class, SaTopicItemActionWidget.class, IconTextBinder.class, BusinessHorizontalScroller.class, SodaTextBinder.class, TailIconTextBinder.class, BusinessLittleStepperBinder.class, TailIconTextBinder.class, FeedBackBinder.class, TouchableMaskBinder.class);

    /* renamed from: c */
    private static final ArrayList<Class<? extends BaseAction>> f43141c = CollectionsKt.arrayListOf(TrackAction.class, ToastAction.class, SetGuideAction.class, FastBuyAction.class, OpenPageAction.class, CheckStatuOpenPageAction.class, BusinessCardClickAction.class, BusinessCardExposureAction.class);

    private BlocksManager() {
    }

    public final ArrayList<Class<? extends Buildable>> getWidgetList() {
        return f43140b;
    }

    public final ArrayList<Class<? extends BaseAction>> getActionList() {
        return f43141c;
    }

    public final void initBlocks(Context context) {
        Intrinsics.checkNotNullParameter(context, "initContext");
        if (f43139a) {
            LogUtil.m32588i("BlockInit", "BlockInit >>>>> already init !!!");
            return;
        }
        f43139a = true;
        BlocksEngine instance$default = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null);
        BlocksConfig.Companion companion = BlocksConfig.Companion;
        BlocksConfig.Builder builder = new BlocksConfig.Builder();
        builder.setDebug(CustomerToolBoxUtil.getIsBlockDebugOn());
        builder.setOptimizeModel(CustomerApolloUtil.getBlocksOptimizeToggleModel());
        builder.setContext(context);
        builder.setWidgetList2Regist(INSTANCE.getWidgetList());
        builder.setActionList2Regist(INSTANCE.getActionList());
        builder.setWidget(MapsKt.mapOf(TuplesKt.m41339to("image", Const.BlockNameConst.BLOCK_NAME_IMAGE), TuplesKt.m41339to("label", Const.BlockNameConst.BLOCK_NAME_TEXT)));
        builder.setEvent(MapsKt.mapOf(TuplesKt.m41339to("onclick", CallBackEntity.CALLBACK_TYPE_CLICK)));
        builder.setLogic(MapsKt.mapOf(TuplesKt.m41339to(BlocksConst.ACTION_TYPE_TOAST, "Toast")));
        builder.setLocal(MapsKt.mapOf(TuplesKt.m41339to("image", MapsKt.mapOf(TuplesKt.m41339to("kingKongDefaultImage", "customer_skin_img_placeholder_x43"), TuplesKt.m41339to("dottedLine", "customer_icon_dotted_line_vertical"), TuplesKt.m41339to("blackArrow", "commom_icon_arrow_right_black"), TuplesKt.m41339to("shopItemDefaultHeadImg", "customer_img_dish_placeholder"), TuplesKt.m41339to("blackArrow", "commom_icon_arrow_right_black"), TuplesKt.m41339to("businessPlaceholder", "customer_skin_img_topgun_placeholder_business_item"))), TuplesKt.m41339to("font", MapsKt.mapOf(TuplesKt.m41339to(BlocksConst.BLOCK_FONT_BOLD, BlocksConst.BLOCK_FONT_BOLD), TuplesKt.m41339to("medium", "medium"), TuplesKt.m41339to(BlocksConst.BLOCK_FONT_REGULAR, BlocksConst.BLOCK_FONT_REGULAR), TuplesKt.m41339to("light", "light"))), TuplesKt.m41339to("device", MapsKt.mapOf(TuplesKt.m41339to("screenWidth", Intrinsics.stringPlus("", Integer.valueOf(DisplayUtils.getScreenWidth(context)))), TuplesKt.m41339to("screenHeight", Intrinsics.stringPlus("", Integer.valueOf(DisplayUtils.getScreenHeight(context)))), TuplesKt.m41339to("os", "android"))), TuplesKt.m41339to("localized", MapsKt.mapOf(TuplesKt.m41339to("soldout", ResourceHelper.getString(R.string.customer_global_sold_out))))));
        builder.setGlobal(BlocksManager$initBlocks$1$1.INSTANCE);
        builder.setImageLoader(new BlocksManager$initBlocks$1$2());
        builder.setLogger(new BlocksManager$initBlocks$1$3());
        builder.setTracker(new BlocksManager$initBlocks$1$4());
        builder.setTrackConfig(CustomerApolloUtil.getTrackConfig());
        builder.setFontHandler(new BlocksManager$initBlocks$1$5());
        Unit unit = Unit.INSTANCE;
        instance$default.startUp(builder.build());
        LogUtil.m32588i("BlockInit", "BlockInit complete");
    }
}
