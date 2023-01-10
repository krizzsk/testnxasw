package com.didi.component.driverbar.presenter;

import com.didi.component.common.util.GsonUtils;
import com.didi.component.driverbar.model.DriverBarCardInfo;
import com.google.gson.Gson;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n"}, mo148868d2 = {"<anonymous>", "Lcom/didi/component/driverbar/model/DriverBarCardInfo;", "kotlin.jvm.PlatformType"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: DriverBarV2Presenter.kt */
final class DriverBarV2Presenter$process$1<V> implements Callable {
    final /* synthetic */ JSONObject $this_process;

    DriverBarV2Presenter$process$1(JSONObject jSONObject) {
        this.$this_process = jSONObject;
    }

    public final DriverBarCardInfo call() {
        JSONObject jSONObject = this.$this_process;
        Gson singleGson = GsonUtils.singleGson();
        Intrinsics.checkNotNullExpressionValue(singleGson, "singleGson()");
        return (DriverBarCardInfo) singleGson.fromJson(jSONObject.toString(), DriverBarCardInfo.class);
    }
}
