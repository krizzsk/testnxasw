package com.didi.sdk.p161sa;

import com.android.didi.bfflib.BffCallBack;
import com.android.didi.bfflib.BffExtra;
import com.didi.sdk.util.SaApolloUtil;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\t"}, mo148868d2 = {"com/didi/sdk/sa/SaManager$requestReal$ability$1", "Lcom/android/didi/bfflib/BffCallBack;", "Lcom/google/gson/JsonObject;", "onFailure", "", "extra", "Lcom/android/didi/bfflib/BffExtra;", "onSuccess", "response", "TheOneSDKGlobal_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.sdk.sa.SaManager$requestReal$ability$1 */
/* compiled from: SaManager.kt */
public final class SaManager$requestReal$ability$1 implements BffCallBack<JsonObject> {
    public void onFailure(BffExtra bffExtra) {
    }

    SaManager$requestReal$ability$1() {
    }

    public void onSuccess(JsonObject jsonObject, BffExtra bffExtra) {
        int i;
        Integer num = null;
        if (jsonObject != null) {
            try {
                JsonElement jsonElement = jsonObject.get("data");
                if (jsonElement != null) {
                    JsonObject asJsonObject = jsonElement.getAsJsonObject();
                    if (asJsonObject != null) {
                        JsonElement jsonElement2 = asJsonObject.get("sa_type");
                        if (jsonElement2 != null) {
                            num = Integer.valueOf(jsonElement2.getAsInt());
                        }
                    }
                }
            } catch (Exception unused) {
                return;
            }
        }
        if (num == null) {
            i = SaApolloUtil.SaType.SA_NONE.getType();
        } else {
            i = num.intValue();
        }
        SaManager.f39854d.edit().putInt(SaManager.f39853c, i).commit();
    }
}
