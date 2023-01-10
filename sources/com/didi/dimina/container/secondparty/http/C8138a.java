package com.didi.dimina.container.secondparty.http;

import android.text.TextUtils;
import com.didi.dimina.container.service.NetworkService;
import com.didi.dimina.container.util.LogUtil;
import didihttp.Call;
import didihttp.DidiHttpClient;
import didihttp.Headers;
import didihttp.Request;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.didi.dimina.container.secondparty.http.a */
/* compiled from: DownloadTask */
class C8138a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Map<String, String> f19006a = new ConcurrentHashMap();

    C8138a() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Call mo60547a(String str, NetworkService.NetworkTaskModel.Download download, DidiHttpClient didiHttpClient) {
        Call newCall = didiHttpClient.newCall(m16122a(download));
        if (!TextUtils.isEmpty(str)) {
            this.f19006a.put(str, newCall.request().tag().toString());
        }
        return newCall;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Call mo60546a(NetworkService.NetworkTaskModel.Download download, DidiHttpClient didiHttpClient) {
        return mo60547a("", download, didiHttpClient);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo60549a(String str, Call call, NetworkService.NetworkTaskModel.Download download, NetworkService.ITaskCallback iTaskCallback) {
        call.enqueue(new DownloadTask$1(this, str, iTaskCallback, download));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo60548a(Call call, NetworkService.NetworkTaskModel.Download download, NetworkService.ITaskCallback iTaskCallback) {
        mo60549a("", call, download, iTaskCallback);
    }

    /* renamed from: a */
    private Request m16122a(NetworkService.NetworkTaskModel.Download download) {
        Request.Builder builder = new Request.Builder();
        if (download.headers != null) {
            builder.headers(Headers.m44731of((Map<String, String>) download.headers));
        }
        return builder.url(download.url).tag(Long.valueOf(System.currentTimeMillis())).get().build();
    }

    /* renamed from: a */
    public boolean mo60550a(String str, DidiHttpClient didiHttpClient) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String str2 = this.f19006a.get(str);
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            for (Call next : didiHttpClient.dispatcher().queuedCalls()) {
                if (str2.equals(next.request().tag().toString())) {
                    if (!next.isCanceled()) {
                        next.cancel();
                    }
                    z = true;
                }
            }
            for (Call next2 : didiHttpClient.dispatcher().runningCalls()) {
                if (str2.equals(next2.request().tag().toString())) {
                    if (!next2.isCanceled()) {
                        next2.cancel();
                    }
                    z = true;
                }
            }
            return z;
        } catch (Exception e) {
            LogUtil.iRelease("DownloadTask", "download abort failed");
            e.printStackTrace();
        }
    }
}
