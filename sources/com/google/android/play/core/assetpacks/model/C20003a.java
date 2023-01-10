package com.google.android.play.core.assetpacks.model;

import com.didi.payment.base.tracker.ErrorName;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.model.a */
public final class C20003a {

    /* renamed from: a */
    private static final Map<Integer, String> f56031a = new HashMap();

    /* renamed from: b */
    private static final Map<Integer, String> f56032b = new HashMap();

    static {
        f56031a.put(-1, "The requesting app is unavailable (e.g. unpublished, nonexistent version code).");
        f56031a.put(-2, "The requested pack is not available.");
        f56031a.put(-3, "The request is invalid.");
        f56031a.put(-4, "The requested download is not found.");
        f56031a.put(-5, "The Asset Delivery API is not available.");
        f56031a.put(-6, "Network error. Unable to obtain the asset pack details.");
        f56031a.put(-7, "Download not permitted under current device circumstances (e.g. in background).");
        f56031a.put(-10, "Asset pack download failed due to insufficient storage.");
        f56031a.put(-11, "The Play Store app is either not installed or not the official version.");
        f56031a.put(-12, "Tried to show the cellular data confirmation but no asset packs are waiting for Wi-Fi.");
        f56031a.put(-13, "The app is not owned by any user on this device. An app is \"owned\" if it has been acquired from Play.");
        f56031a.put(-100, "Unknown error downloading an asset pack.");
        f56032b.put(-1, "APP_UNAVAILABLE");
        f56032b.put(-2, "PACK_UNAVAILABLE");
        f56032b.put(-3, "INVALID_REQUEST");
        f56032b.put(-4, "DOWNLOAD_NOT_FOUND");
        f56032b.put(-5, "API_NOT_AVAILABLE");
        f56032b.put(-6, ErrorName.NETWORK_ERROR);
        f56032b.put(-7, "ACCESS_DENIED");
        f56032b.put(-10, "INSUFFICIENT_STORAGE");
        f56032b.put(-11, "PLAY_STORE_NOT_FOUND");
        f56032b.put(-12, "NETWORK_UNRESTRICTED");
        f56032b.put(-13, "APP_NOT_OWNED");
        f56032b.put(-100, "INTERNAL_ERROR");
    }

    /* renamed from: a */
    public static String m42081a(int i) {
        Map<Integer, String> map = f56031a;
        Integer valueOf = Integer.valueOf(i);
        if (!map.containsKey(valueOf)) {
            return "";
        }
        String str = f56031a.get(valueOf);
        String str2 = f56032b.get(valueOf);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 113 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(" (https://developer.android.com/reference/com/google/android/play/core/assetpacks/model/AssetPackErrorCode.html#");
        sb.append(str2);
        sb.append(")");
        return sb.toString();
    }
}
