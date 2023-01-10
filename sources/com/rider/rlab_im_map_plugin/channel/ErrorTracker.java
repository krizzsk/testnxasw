package com.rider.rlab_im_map_plugin.channel;

import com.didichuxing.omega.sdk.init.OmegaSDK;
import java.util.HashMap;
import java.util.Map;

public final class ErrorTracker {

    /* renamed from: a */
    private String f58605a = "";

    /* renamed from: b */
    private String f58606b;

    /* renamed from: c */
    private String f58607c = "";

    /* renamed from: d */
    private String f58608d = "";

    /* renamed from: e */
    private HashMap<String, Object> f58609e = new HashMap<>();

    private ErrorTracker(String str) {
        this.f58606b = str;
    }

    public static ErrorTracker create(String str) {
        return new ErrorTracker(str);
    }

    public ErrorTracker setModuleName(String str) {
        this.f58605a = str;
        return this;
    }

    public ErrorTracker setErrorType(String str) {
        this.f58607c = str;
        return this;
    }

    public ErrorTracker setErrorMessage(String str) {
        this.f58608d = str;
        return this;
    }

    public ErrorTracker setExtraParams(Map<String, Object> map) {
        this.f58609e.putAll(map);
        return this;
    }

    public ErrorTracker addExtraParam(String str, Object obj) {
        this.f58609e.put(str, obj);
        return this;
    }

    public void trackError() {
        OmegaSDK.trackError(this.f58605a, this.f58606b, this.f58607c, this.f58608d, this.f58609e);
    }
}
