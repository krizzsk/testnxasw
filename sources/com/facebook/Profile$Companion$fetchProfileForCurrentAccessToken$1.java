package com.facebook;

import android.net.Uri;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.facebook.internal.Utility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo148867d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, mo148868d2 = {"com/facebook/Profile$Companion$fetchProfileForCurrentAccessToken$1", "Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", "onFailure", "", "error", "Lcom/facebook/FacebookException;", "onSuccess", "userInfo", "Lorg/json/JSONObject;", "facebook-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: Profile.kt */
public final class Profile$Companion$fetchProfileForCurrentAccessToken$1 implements Utility.GraphMeRequestWithCacheCallback {
    Profile$Companion$fetchProfileForCurrentAccessToken$1() {
    }

    public void onSuccess(JSONObject jSONObject) {
        Uri uri = null;
        String optString = jSONObject == null ? null : jSONObject.optString("id");
        if (optString == null) {
            SystemUtils.log(5, Profile.TAG, "No user ID returned on Me request", (Throwable) null, "com.facebook.Profile$Companion$fetchProfileForCurrentAccessToken$1", 280);
            return;
        }
        String optString2 = jSONObject.optString("link");
        String optString3 = jSONObject.optString("profile_picture", (String) null);
        String optString4 = jSONObject.optString(ParamConst.PARAM_FIRST_NAME);
        String optString5 = jSONObject.optString(AuthenticationTokenClaims.JSON_KEY_MIDDLE_NAME);
        String optString6 = jSONObject.optString(ParamConst.PARAM_LAST_NAME);
        String optString7 = jSONObject.optString("name");
        Uri parse = optString2 != null ? Uri.parse(optString2) : null;
        if (optString3 != null) {
            uri = Uri.parse(optString3);
        }
        Profile.Companion.setCurrentProfile(new Profile(optString, optString4, optString5, optString6, optString7, parse, uri));
    }

    public void onFailure(FacebookException facebookException) {
        SystemUtils.log(6, Profile.TAG, Intrinsics.stringPlus("Got unexpected exception: ", facebookException), (Throwable) null, "com.facebook.Profile$Companion$fetchProfileForCurrentAccessToken$1", 298);
    }
}
