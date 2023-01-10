package com.google.android.play.core.splitinstall.model;

import com.didi.payment.base.tracker.ErrorName;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.play.core.splitinstall.model.a */
public final class C20204a {

    /* renamed from: a */
    private static final Map<Integer, String> f56266a = new HashMap();

    /* renamed from: b */
    private static final Map<Integer, String> f56267b = new HashMap();

    static {
        f56266a.put(-1, "Too many sessions are running for current app, existing sessions must be resolved first.");
        f56266a.put(-2, "A requested module is not available (to this user/device, for the installed apk).");
        f56266a.put(-3, "Request is otherwise invalid.");
        f56266a.put(-4, "Requested session is not found.");
        f56266a.put(-5, "Split Install API is not available.");
        f56266a.put(-6, "Network error: unable to obtain split details.");
        f56266a.put(-7, "Download not permitted under current device circumstances (e.g. in background).");
        f56266a.put(-8, "Requested session contains modules from an existing active session and also new modules.");
        f56266a.put(-9, "Service handling split install has died.");
        f56266a.put(-10, "Install failed due to insufficient storage.");
        f56266a.put(-11, "Signature verification error when invoking SplitCompat.");
        f56266a.put(-12, "Error in SplitCompat emulation.");
        f56266a.put(-13, "Error in copying files for SplitCompat.");
        f56266a.put(-14, "The Play Store app is either not installed or not the official version.");
        f56266a.put(-15, "The app is not owned by any user on this device. An app is \"owned\" if it has been acquired from Play.");
        f56266a.put(-100, "Unknown error processing split install.");
        f56267b.put(-1, "ACTIVE_SESSIONS_LIMIT_EXCEEDED");
        f56267b.put(-2, "MODULE_UNAVAILABLE");
        f56267b.put(-3, "INVALID_REQUEST");
        f56267b.put(-4, "DOWNLOAD_NOT_FOUND");
        f56267b.put(-5, "API_NOT_AVAILABLE");
        f56267b.put(-6, ErrorName.NETWORK_ERROR);
        f56267b.put(-7, "ACCESS_DENIED");
        f56267b.put(-8, "INCOMPATIBLE_WITH_EXISTING_SESSION");
        f56267b.put(-9, "SERVICE_DIED");
        f56267b.put(-10, "INSUFFICIENT_STORAGE");
        f56267b.put(-11, "SPLITCOMPAT_VERIFICATION_ERROR");
        f56267b.put(-12, "SPLITCOMPAT_EMULATION_ERROR");
        f56267b.put(-13, "SPLITCOMPAT_COPY_ERROR");
        f56267b.put(-14, "PLAY_STORE_NOT_FOUND");
        f56267b.put(-15, "APP_NOT_OWNED");
    }

    /* renamed from: a */
    public static String m42537a(int i) {
        Map<Integer, String> map = f56266a;
        Integer valueOf = Integer.valueOf(i);
        if (!map.containsKey(valueOf) || !f56267b.containsKey(valueOf)) {
            return "";
        }
        String str = f56266a.get(valueOf);
        String str2 = f56267b.get(valueOf);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 118 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(" (https://developer.android.com/reference/com/google/android/play/core/splitinstall/model/SplitInstallErrorCode.html#");
        sb.append(str2);
        sb.append(")");
        return sb.toString();
    }
}
