package com.facebook;

import com.facebook.GraphRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/facebook/GraphRequest$Companion$newMyFriendsRequest$wrapper$1", "Lcom/facebook/GraphRequest$Callback;", "onCompleted", "", "response", "Lcom/facebook/GraphResponse;", "facebook-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GraphRequest.kt */
public final class GraphRequest$Companion$newMyFriendsRequest$wrapper$1 implements GraphRequest.Callback {
    final /* synthetic */ GraphRequest.GraphJSONArrayCallback $callback;

    GraphRequest$Companion$newMyFriendsRequest$wrapper$1(GraphRequest.GraphJSONArrayCallback graphJSONArrayCallback) {
        this.$callback = graphJSONArrayCallback;
    }

    public void onCompleted(GraphResponse graphResponse) {
        JSONArray jSONArray;
        Intrinsics.checkNotNullParameter(graphResponse, "response");
        if (this.$callback != null) {
            JSONObject jSONObject = graphResponse.getJSONObject();
            if (jSONObject == null) {
                jSONArray = null;
            } else {
                jSONArray = jSONObject.optJSONArray("data");
            }
            this.$callback.onCompleted(jSONArray, graphResponse);
        }
    }
}
