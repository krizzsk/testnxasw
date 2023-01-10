package com.didi.onehybrid.resource;

import android.text.TextUtils;
import com.didi.onehybrid.resource.FusionBridgeStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class FusionNetStream extends InputStream {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f32150a;

    /* renamed from: b */
    private Map<String, String> f32151b;

    /* renamed from: c */
    private FusionBridgeStream f32152c;

    /* renamed from: d */
    private boolean f32153d = true;

    public FusionNetStream(String str, Map<String, String> map) {
        this.f32150a = str;
        this.f32151b = map;
    }

    public int read() throws IOException {
        if (this.f32152c == null && this.f32153d) {
            m24455a();
        }
        FusionBridgeStream fusionBridgeStream = this.f32152c;
        if (fusionBridgeStream != null) {
            return fusionBridgeStream.read();
        }
        return -1;
    }

    /* renamed from: a */
    private void m24455a() {
        final FusionHttpClient fusionHttpClient = new FusionHttpClient(this.f32150a, this.f32151b);
        if (fusionHttpClient.connect() != 0) {
            this.f32153d = false;
        } else if (200 == fusionHttpClient.getResponseCode()) {
            final String headerValue = fusionHttpClient.getHeaderValue("Content-Type");
            final Map<String, List<String>> responseHeader = fusionHttpClient.getResponseHeader();
            FusionBridgeStream fusionBridgeStream = new FusionBridgeStream(fusionHttpClient.getResponseStream());
            this.f32152c = fusionBridgeStream;
            fusionBridgeStream.setOnCloseListener(new FusionBridgeStream.OnCloseListener() {
                public void onClose(boolean z, final ByteArrayOutputStream byteArrayOutputStream) {
                    if (!TextUtils.isEmpty(headerValue)) {
                        String str = headerValue.split(";")[0];
                        FusionAsynDispatcher.Instance.asynRunTask(new Runnable() {
                            public void run() {
                                FusionCacheClient.sInstance.saveHeaders(FusionNetStream.this.f32150a, responseHeader);
                                FusionCacheClient.sInstance.saveBody(FusionNetStream.this.f32150a, byteArrayOutputStream);
                                fusionHttpClient.disconnect();
                            }
                        }, 2, TimeUnit.SECONDS);
                    }
                }
            });
        } else {
            this.f32153d = false;
        }
    }

    public void close() throws IOException {
        super.close();
        FusionBridgeStream fusionBridgeStream = this.f32152c;
        if (fusionBridgeStream != null) {
            fusionBridgeStream.close();
        }
    }
}
