package com.didi.dimina.container.secondparty.http;

import android.text.TextUtils;
import com.didi.dimina.container.service.NetworkService;
import com.didi.dimina.container.util.LogUtil;
import didihttp.Call;
import didihttp.DidiHttpClient;
import didihttp.Headers;
import didihttp.MediaType;
import didihttp.MultipartBody;
import didihttp.Request;
import didihttp.RequestBody;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.didi.dimina.container.secondparty.http.d */
/* compiled from: UploadTask */
class C8141d {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Map<String, String> f19013a = new ConcurrentHashMap();

    C8141d() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Call mo60557a(String str, NetworkService.NetworkTaskModel.Upload upload, DidiHttpClient didiHttpClient, NetworkService.ITaskCallback iTaskCallback) {
        Call newCall = didiHttpClient.newCall(m16143a(upload, (RequestBody) new ProgressRequestBody(m16144a(upload), new UploadTask$1(this, iTaskCallback))));
        if (!TextUtils.isEmpty(str)) {
            this.f19013a.put(str, newCall.request().tag().toString());
        }
        return newCall;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Call mo60556a(NetworkService.NetworkTaskModel.Upload upload, DidiHttpClient didiHttpClient, NetworkService.ITaskCallback iTaskCallback) {
        return mo60557a("", upload, didiHttpClient, iTaskCallback);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo60559a(String str, Call call, NetworkService.NetworkTaskModel.Upload upload, NetworkService.ITaskCallback iTaskCallback) {
        call.enqueue(new UploadTask$2(this, str, iTaskCallback));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo60558a(Call call, NetworkService.NetworkTaskModel.Upload upload, NetworkService.ITaskCallback iTaskCallback) {
        mo60559a("", call, upload, iTaskCallback);
    }

    /* renamed from: a */
    public boolean mo60560a(String str, DidiHttpClient didiHttpClient) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String str2 = this.f19013a.get(str);
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
            LogUtil.iRelease("UploadTask", "upload load abort failed");
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private Request m16143a(NetworkService.NetworkTaskModel.Upload upload, RequestBody requestBody) {
        return new Request.Builder().post(requestBody).url(upload.url).headers(Headers.m44731of((Map<String, String>) upload.headers)).tag(Long.valueOf(System.currentTimeMillis())).build();
    }

    /* renamed from: a */
    private static RequestBody m16144a(NetworkService.NetworkTaskModel.Upload upload) {
        File file = new File(upload.filePath);
        MultipartBody.Builder addFormDataPart = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart(upload.fileName, file.getName(), RequestBody.create(MediaType.parse(C8139b.m16129a(upload.filePath)), file));
        for (Map.Entry next : upload.formData.entrySet()) {
            try {
                addFormDataPart.addFormDataPart(URLEncoder.encode((String) next.getKey(), "UTF-8"), URLEncoder.encode(next.getValue().toString(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return addFormDataPart.build();
    }
}
