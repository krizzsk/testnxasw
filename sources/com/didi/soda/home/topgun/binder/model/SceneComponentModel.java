package com.didi.soda.home.topgun.binder.model;

import android.os.Parcelable;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.grid.GridItemModel;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.foundation.rpc.entity.grid.GridItemEntity;
import com.didi.soda.customer.foundation.tracker.model.ModuleModelV2;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.ExtentionsKt;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.UrlBuilder;
import com.didi.soda.datasource.parser.FeedPayload;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/binder/model/SceneComponentModel;", "Lcom/didi/soda/customer/foundation/tracker/model/ModuleModelV2;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "items", "", "Lcom/didi/soda/customer/base/pages/grid/GridItemModel;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "state", "Landroid/os/Parcelable;", "getState", "()Landroid/os/Parcelable;", "setState", "(Landroid/os/Parcelable;)V", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SceneComponentModel.kt */
public final class SceneComponentModel extends ModuleModelV2 implements RecyclerModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: c */
    private static final int f45296c = 900;

    /* renamed from: a */
    private Parcelable f45297a;

    /* renamed from: b */
    private List<GridItemModel> f45298b = new ArrayList();

    public final Parcelable getState() {
        return this.f45297a;
    }

    public final void setState(Parcelable parcelable) {
        this.f45297a = parcelable;
    }

    public final List<GridItemModel> getItems() {
        return this.f45298b;
    }

    public final void setItems(List<GridItemModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f45298b = list;
    }

    @Metadata(mo148867d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJQ\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f\u0018\u00010\u0013¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/binder/model/SceneComponentModel$Companion;", "", "()V", "fromSceneComponent", "", "convert", "Lcom/didi/soda/home/topgun/binder/model/SceneComponentModel;", "compJson", "Lcom/google/gson/JsonObject;", "payload", "Lcom/didi/soda/datasource/parser/FeedPayload;", "performClickFromScene", "", "url", "", "type", "title", "recId", "extra", "Lkotlin/Function2;", "Lcom/didi/soda/customer/foundation/util/UrlBuilder;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: SceneComponentModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SceneComponentModel convert(JsonObject jsonObject, FeedPayload feedPayload) {
            Intrinsics.checkNotNullParameter(jsonObject, "compJson");
            JsonObject asJsonObject = jsonObject.getAsJsonObject("data");
            String str = null;
            List<GridItemEntity> list = (List) GsonUtil.fromJson(asJsonObject == null ? null : asJsonObject.get(FirebaseAnalytics.Param.ITEMS), new SceneComponentModel$Companion$convert$type$1().getType());
            Collection collection = list;
            if (collection == null || collection.isEmpty()) {
                return null;
            }
            SceneComponentModel sceneComponentModel = new SceneComponentModel();
            for (GridItemEntity create : list) {
                sceneComponentModel.getItems().add(GridItemModel.Companion.create(create));
            }
            if (feedPayload != null) {
                str = feedPayload.mRecId;
            }
            sceneComponentModel.mRecId = str;
            if (feedPayload != null) {
                sceneComponentModel.mAbsoluteIndex = feedPayload.mComponentIndex;
            }
            if (jsonObject.get("position") != null) {
                sceneComponentModel.mIndexInModule = jsonObject.get("position").getAsInt();
            }
            return sceneComponentModel;
        }

        public static /* synthetic */ void performClickFromScene$default(Companion companion, String str, Integer num, String str2, String str3, Function2 function2, int i, Object obj) {
            if ((i & 16) != 0) {
                function2 = null;
            }
            companion.performClickFromScene(str, num, str2, str3, function2);
        }

        public final void performClickFromScene(String str, Integer num, String str2, String str3, Function2<? super Integer, ? super UrlBuilder, Unit> function2) {
            CharSequence charSequence = str;
            boolean z = false;
            if (!(charSequence == null || charSequence.length() == 0)) {
                UrlBuilder create = UrlBuilder.create(str);
                if (function2 != null) {
                    Integer valueOf = Integer.valueOf(ExtentionsKt.orZero(num));
                    Intrinsics.checkNotNullExpressionValue(create, "builder");
                    function2.invoke(valueOf, create);
                }
                create.appendParam(Const.PageParams.SCENE_EXTRA, "900");
                if (str3 == null) {
                    str3 = "";
                }
                create.appendParam("recid", str3);
                CharSequence charSequence2 = str2;
                if (!(charSequence2 == null || charSequence2.length() == 0) && (!Intrinsics.areEqual((Object) charSequence2, (Object) "null"))) {
                    z = true;
                }
                if (z) {
                    create.appendParam(Const.PageParams.TOPIC_TITLE, CustomerExtentionKt.encodeUseByUri(str2));
                }
                SchemeHelper.dispatchMsg(create.build());
            }
        }
    }
}
