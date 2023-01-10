package com.didi.sdk.util.glide;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpStreamFetcher implements DataFetcher<InputStream> {

    /* renamed from: a */
    private final OkHttpClient f40449a;

    /* renamed from: b */
    private final GlideUrl f40450b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public InputStream f40451c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ResponseBody f40452d;

    public void cancel() {
    }

    public OkHttpStreamFetcher(OkHttpClient okHttpClient, GlideUrl glideUrl) {
        this.f40449a = okHttpClient;
        this.f40450b = glideUrl;
    }

    public void loadData(Priority priority, final DataFetcher.DataCallback<? super InputStream> dataCallback) {
        Request.Builder url = new Request.Builder().url(this.f40450b.toStringUrl());
        for (Map.Entry next : this.f40450b.getHeaders().entrySet()) {
            url.addHeader((String) next.getKey(), (String) next.getValue());
        }
        this.f40449a.newCall(url.build()).enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                dataCallback.onLoadFailed(iOException);
            }

            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody unused = OkHttpStreamFetcher.this.f40452d = response.body();
                if (response.isSuccessful()) {
                    long contentLength = OkHttpStreamFetcher.this.f40452d.contentLength();
                    OkHttpStreamFetcher okHttpStreamFetcher = OkHttpStreamFetcher.this;
                    InputStream unused2 = okHttpStreamFetcher.f40451c = ContentLengthInputStream.obtain(okHttpStreamFetcher.f40452d.byteStream(), contentLength);
                    dataCallback.onDataReady(OkHttpStreamFetcher.this.f40451c);
                    return;
                }
                dataCallback.onLoadFailed(new HttpException(response.message(), response.code()));
            }
        });
    }

    public void cleanup() {
        InputStream inputStream = this.f40451c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ResponseBody responseBody = this.f40452d;
        if (responseBody != null) {
            responseBody.close();
        }
    }

    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }
}
