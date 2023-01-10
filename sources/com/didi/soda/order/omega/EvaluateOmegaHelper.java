package com.didi.soda.order.omega;

import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationItemsListEntity;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.OnceActionUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo148868d2 = {"Lcom/didi/soda/order/omega/EvaluateOmegaHelper;", "", "()V", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: EvaluateOmegaHelper.kt */
public final class EvaluateOmegaHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static OnceActionUtil.ActionPool f46072a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static String f46073b = "";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static String f46074c = "";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static String f46075d = "";

    @Metadata(mo148867d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\rJ$\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006J\"\u0010\u0012\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u0015Jt\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00152\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001f\u001a\u00020\u00152\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u001b2\u0006\u0010\"\u001a\u00020\u0015J\u0016\u0010#\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0015J\u0006\u0010%\u001a\u00020\rJ\u0016\u0010&\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015J\u000e\u0010'\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0015J\u000e\u0010(\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0015J\u000e\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u0015J\u0006\u0010+\u001a\u00020\rR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, mo148868d2 = {"Lcom/didi/soda/order/omega/EvaluateOmegaHelper$Companion;", "", "()V", "mActionPool", "Lcom/didi/soda/customer/foundation/util/OnceActionUtil$ActionPool;", "mOrderId", "", "mRiderId", "mShopId", "createTracker", "Lcom/didi/soda/customer/foundation/tracker/OmegaTracker$Builder;", "key", "detach", "", "init", "orderId", "shopId", "riderId", "trackEvaluateDetailSw", "from", "isEvaluateShop", "", "trackEvaluatePageCompleteCk", "isEvaluate", "isSuc", "failureReason", "tagShop", "", "courierShop", "contentShop", "contentCourier", "starRating", "infoDish", "Lcom/didi/soda/customer/foundation/rpc/entity/order/OrderEvaluationItemsListEntity;", "isLikeCourier", "trackEvaluatePageLikeCk", "likeType", "trackEvaluatePageRatingCk", "trackEvaluatePageShow", "trackEvaluatePageTagCk", "trackEvaluatePageTextCk", "trackEvaluatePopCk", "buttonType", "trackEvaluatePopSw", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: EvaluateOmegaHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void init(String str, String str2, String str3) {
            if (str == null) {
                str = "";
            }
            EvaluateOmegaHelper.f46073b = str;
            if (str2 == null) {
                str2 = "";
            }
            EvaluateOmegaHelper.f46074c = str2;
            if (str3 == null) {
                str3 = "";
            }
            EvaluateOmegaHelper.f46075d = str3;
            EvaluateOmegaHelper.f46072a = new OnceActionUtil.ActionPool();
        }

        public final void trackEvaluatePageShow(int i, int i2) {
            createTracker(EventConst.Order.SAILING_C_X_SIDEBAR_EVALUATE_PAGE_SW).addEventParam("from_page", Integer.valueOf(i)).addEventParam(ParamConst.PARAMS_IS_EVALUATE, Integer.valueOf(i2)).build().track();
        }

        public final void trackEvaluatePageCompleteCk(int i, int i2, int i3, int i4, List<Integer> list, List<Integer> list2, String str, String str2, int i5, List<OrderEvaluationItemsListEntity> list3, int i6) {
            Intrinsics.checkNotNullParameter(list, "tagShop");
            Intrinsics.checkNotNullParameter(list2, "courierShop");
            Intrinsics.checkNotNullParameter(list3, "infoDish");
            OmegaTracker.Builder addEventParam = createTracker(EventConst.Order.SAILING_C_X_SIDEBAR_EVALUATE_PAGE_COMPLETE_CK).addEventParam("from_channel", Integer.valueOf(i)).addEventParam(ParamConst.PARAMS_IS_EVALUATE, Integer.valueOf(i2)).addEventParam("is_suc", Integer.valueOf(i3)).addEventParam("failure_reason", Integer.valueOf(i4));
            String str3 = "";
            OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam(ParamConst.PARAMS_TAG_SHOP, CollectionsUtil.isEmpty(list) ? str3 : GsonUtil.toJson(list)).addEventParam(ParamConst.PARAMS_TAG_COURIER, CollectionsUtil.isEmpty(list2) ? str3 : GsonUtil.toJson(list2));
            if (str == null) {
                str = str3;
            }
            OmegaTracker.Builder addEventParam3 = addEventParam2.addEventParam(ParamConst.PARAMS_CONTENT_SHOP, str);
            if (str2 == null) {
                str2 = str3;
            }
            OmegaTracker.Builder addEventParam4 = addEventParam3.addEventParam(ParamConst.PARAMS_CONTENT_COURIER, str2).addEventParam(ParamConst.PARAMS_STAR_RATING, Integer.valueOf(i5));
            if (!CollectionsUtil.isEmpty(list3)) {
                str3 = GsonUtil.toJson(list3);
            }
            addEventParam4.addEventParam(ParamConst.PARAMS_LIKE_INFO_DISH, str3).addEventParam(ParamConst.PARAMS_IS_LIKE_COURIER, Integer.valueOf(i6)).build().track();
        }

        public final void trackEvaluatePageTextCk(int i) {
            OnceActionUtil.OnceAction evaluateOmegaHelper$Companion$trackEvaluatePageTextCk$moduleShowTrack$1 = new C14918xa4ad7a4d(i, i + "trackEvaluatePageTextCk");
            OnceActionUtil.ActionPool access$getMActionPool$cp = EvaluateOmegaHelper.f46072a;
            if (access$getMActionPool$cp != null) {
                access$getMActionPool$cp.doAction(evaluateOmegaHelper$Companion$trackEvaluatePageTextCk$moduleShowTrack$1);
            }
        }

        public final void trackEvaluatePageRatingCk() {
            createTracker(EventConst.Order.SAILING_C_X_SIDEBAR_EVALUATE_PAGE_RATING_CK).build().track();
        }

        public final void trackEvaluatePageTagCk(int i) {
            OnceActionUtil.OnceAction evaluateOmegaHelper$Companion$trackEvaluatePageTagCk$moduleShowTrack$1 = new C14917xf4ea1bc0(i, i + "trackEvaluatePageTagCk");
            OnceActionUtil.ActionPool access$getMActionPool$cp = EvaluateOmegaHelper.f46072a;
            if (access$getMActionPool$cp != null) {
                access$getMActionPool$cp.doAction(evaluateOmegaHelper$Companion$trackEvaluatePageTagCk$moduleShowTrack$1);
            }
        }

        public final void trackEvaluatePageLikeCk(int i, int i2) {
            OnceActionUtil.OnceAction evaluateOmegaHelper$Companion$trackEvaluatePageLikeCk$moduleShowTrack$1 = new C14916x5ba68bb7(i, i2, i + i2 + "trackEvaluatePageLikeCk");
            OnceActionUtil.ActionPool access$getMActionPool$cp = EvaluateOmegaHelper.f46072a;
            if (access$getMActionPool$cp != null) {
                access$getMActionPool$cp.doAction(evaluateOmegaHelper$Companion$trackEvaluatePageLikeCk$moduleShowTrack$1);
            }
        }

        public final void trackEvaluatePopSw() {
            createTracker(EventConst.Order.SAILING_C_X_SIDEBAR_EVALUATE_POP_SW).build().track();
        }

        public final void trackEvaluatePopCk(int i) {
            createTracker(EventConst.Order.SAILING_C_X_SIDEBAR_EVALUATE_POP_CK).addEventParam("button_name", Integer.valueOf(i)).build().track();
        }

        public final void trackEvaluateDetailSw(String str, String str2, int i) {
            OmegaTracker.Builder createTracker = createTracker(EventConst.Order.SAILING_C_X_EVALUATION_CHECK_PAGE_SW);
            if (str == null) {
                str = "";
            }
            OmegaTracker.Builder addEventParam = createTracker.addEventParam("order_id", str);
            if (str2 == null) {
                str2 = "";
            }
            addEventParam.addEventParam("from", str2).addEventParam(ParamConst.PARAMS_IS_EVALUATE_SHOP, String.valueOf(i)).build().track();
        }

        public final void detach() {
            OnceActionUtil.ActionPool access$getMActionPool$cp = EvaluateOmegaHelper.f46072a;
            if (access$getMActionPool$cp != null) {
                access$getMActionPool$cp.reset();
            }
            EvaluateOmegaHelper.f46072a = null;
            EvaluateOmegaHelper.f46073b = "";
            EvaluateOmegaHelper.f46074c = "";
            EvaluateOmegaHelper.f46075d = "";
        }

        public final OmegaTracker.Builder createTracker(String str) {
            Intrinsics.checkNotNullParameter(str, "key");
            OmegaTracker.Builder addEventParam = OmegaTracker.Builder.create(str).addEventParam("order_id", EvaluateOmegaHelper.f46073b).addEventParam("shop_id", EvaluateOmegaHelper.f46074c).addEventParam(ParamConst.PARAM_RIDER_ID, EvaluateOmegaHelper.f46075d);
            Intrinsics.checkNotNullExpressionValue(addEventParam, "create(key)\n            …PARAM_RIDER_ID, mRiderId)");
            return addEventParam;
        }
    }
}
