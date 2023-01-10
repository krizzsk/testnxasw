package com.didi.one.netdetect.http;

import didihttp.Callback;
import didihttp.DidiHttpClient;
import didihttp.MediaType;
import didihttp.Request;
import didihttp.RequestBody;

public class OkHttpClientManager {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    /* renamed from: a */
    private static final String f31902a = "OND_OkHttpClientManager";

    /* renamed from: b */
    private static OkHttpClientManager f31903b;

    /* renamed from: c */
    private DidiHttpClient f31904c = new DidiHttpClient();

    private OkHttpClientManager() {
    }

    public static OkHttpClientManager getInstance() {
        if (f31903b == null) {
            synchronized (OkHttpClientManager.class) {
                if (f31903b == null) {
                    f31903b = new OkHttpClientManager();
                }
            }
        }
        return f31903b;
    }

    public void getAsync(String str, Callback callback) {
        Request build = new Request.Builder().url(str).build();
        if (callback != null) {
            this.f31904c.newCall(build).enqueue(callback);
        }
    }

    public void postAsync(String str, String str2, Callback callback) {
        Request build = new Request.Builder().url(str).post(RequestBody.create(JSON, str2)).build();
        if (callback != null) {
            this.f31904c.newCall(build).enqueue(callback);
        }
    }
}
