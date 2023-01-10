package com.didi.soda.home.topgun.binder;

import android.net.Uri;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.grid.GridItemModel;
import com.didi.soda.customer.foundation.util.ExtentionsKt;
import com.didi.soda.customer.foundation.util.UrlBuilder;
import com.didi.soda.home.topgun.binder.model.SceneComponentModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, mo148868d2 = {"<anonymous>", "", "type", "", "builder", "Lcom/didi/soda/customer/foundation/util/UrlBuilder;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HomeSceneBinder.kt */
final class HomeSceneLogic$onSceneItemClick$1 extends Lambda implements Function2<Integer, UrlBuilder, Unit> {
    final /* synthetic */ GridItemModel $itemModel;
    final /* synthetic */ SceneComponentModel $model;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeSceneLogic$onSceneItemClick$1(GridItemModel gridItemModel, SceneComponentModel sceneComponentModel) {
        super(2);
        this.$itemModel = gridItemModel;
        this.$model = sceneComponentModel;
    }

    public /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), (UrlBuilder) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, UrlBuilder urlBuilder) {
        Intrinsics.checkNotNullParameter(urlBuilder, "builder");
        if (i == 3) {
            urlBuilder.appendParam(Const.PageParams.SUB_ITEMS, Uri.encode(this.$itemModel.getSubItems()));
            urlBuilder.appendParam("position", String.valueOf(ExtentionsKt.orZero(Integer.valueOf(this.$model.mIndexInModule))));
            urlBuilder.appendParam(Const.PageParams.ABSOLUTE_POSITION, String.valueOf(ExtentionsKt.orZero(Integer.valueOf(this.$model.mAbsoluteIndex))));
            String str = this.$model.mRecId;
            if (str == null) {
                str = "";
            }
            urlBuilder.appendParam("recid", str);
        }
    }
}
