package com.didi.sdk.logging.util;

import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class ReportUtils {

    /* renamed from: a */
    private static final String f39430a = "tone_p_x_catchdata_query_result";

    /* renamed from: b */
    private static final String f39431b = "tone_p_x_catchdata_upload_slice_result";

    /* renamed from: c */
    private static final String f39432c = "tone_p_x_upload_filetree_result";

    /* renamed from: d */
    private static final String f39433d = "tone_p_x_catchdata_upload_total_result";

    /* renamed from: e */
    private static final String f39434e = "tone_p_x_catchdata_file_receive_socket";

    /* renamed from: f */
    private static final String f39435f = "networkType";

    /* renamed from: g */
    private static final String f39436g = "statusCode";

    /* renamed from: h */
    private static final String f39437h = "errorMsg";

    /* renamed from: i */
    private static final String f39438i = "result";

    /* renamed from: j */
    private static final String f39439j = "catchType";

    /* renamed from: k */
    private static final String f39440k = "sliceid";

    /* renamed from: l */
    private static final String f39441l = "taskid";

    /* renamed from: m */
    private static final String f39442m = "intentAction";

    /* renamed from: n */
    private static final String f39443n = "intentExtra";

    public static void reportProgramError(String str, Throwable th) {
        OmegaSDK.trackError(str, th);
    }

    public static void reportUploadTaskResult(boolean z, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("result", Integer.valueOf(z ? 1 : 0));
        hashMap.put("networkType", str);
        hashMap.put(f39441l, str2);
        hashMap.put(f39437h, str3);
        hashMap.put("serverUrl", LoggerFactory.getConfig().getServerHost());
        OmegaSDKAdapter.trackEvent(f39433d, (Map<String, Object>) hashMap);
    }

    public static void reportQueryTaskResult(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("result", str);
        hashMap.put("serverUrl", LoggerFactory.getConfig().getServerHost());
        OmegaSDKAdapter.trackEvent(f39430a, (Map<String, Object>) hashMap);
    }

    public static void reportUploadSliceResult(boolean z, String str, long j, int i, String str2, int i2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("result", Integer.valueOf(z ? 1 : 0));
        hashMap.put("networkType", str);
        hashMap.put(f39436g, Integer.valueOf(i2));
        hashMap.put(f39440k, Integer.valueOf(i));
        hashMap.put(f39437h, str3);
        hashMap.put(f39441l, str2);
        hashMap.put("fileLength", Long.valueOf(j));
        hashMap.put("serverUrl", LoggerFactory.getConfig().getServerHost());
        hashMap.put("file", str4);
        OmegaSDKAdapter.trackEvent(f39431b, (Map<String, Object>) hashMap);
    }

    public static void reportUploadFileTreeResult(boolean z, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("result", Integer.valueOf(z ? 1 : 0));
        hashMap.put("networkType", str);
        hashMap.put("response", str3);
        hashMap.put(f39441l, str2);
        hashMap.put("serverUrl", LoggerFactory.getConfig().getServerHost());
        OmegaSDKAdapter.trackEvent(f39432c, (Map<String, Object>) hashMap);
    }

    public static void reportReceivePush(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(f39442m, str);
        hashMap.put(f39443n, str2);
        OmegaSDKAdapter.trackEvent(f39434e, (Map<String, Object>) hashMap);
    }

    public static void reportRequest(String str, Map<String, Object> map, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("param", map.toString());
        hashMap.put("response", str2);
        OmegaSDKAdapter.trackEvent("tone_p_x_catchdata_request", (Map<String, Object>) hashMap);
    }
}
