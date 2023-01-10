package com.didichuxing.dfbasesdk.logupload;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didichuxing.dfbasesdk.data.BaseInnerResult;
import com.didichuxing.dfbasesdk.http.AbsOkHttpCallback;
import com.didichuxing.dfbasesdk.utils.DFApi;
import java.util.List;

class LogUploader {

    /* renamed from: a */
    public static final int f49266a = 1;

    /* renamed from: b */
    private final String f49267b;

    /* renamed from: c */
    private final Handler f49268c = new UpHandler(Looper.getMainLooper());

    /* renamed from: d */
    private final Handler f49269d;

    LogUploader(Handler handler, String str) {
        this.f49269d = handler;
        this.f49267b = str;
    }

    /* renamed from: a */
    public Handler mo122280a() {
        return this.f49268c;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36950a(int i, Object obj) {
        Message obtain = Message.obtain(this.f49269d);
        obtain.what = i;
        obtain.obj = obj;
        obtain.sendToTarget();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36953a(UploadObj uploadObj) {
        if (uploadObj.needUpload()) {
            final List<Object> list = uploadObj.ids;
            DFApi.postWithoutEnv(this.f49267b, uploadObj.jsonBody, new AbsOkHttpCallback<BaseInnerResult>() {
                public void onSuccess(BaseInnerResult baseInnerResult) {
                    LogUploader.this.m36950a(2, (Object) list);
                }

                public void onFailed(int i, String str) {
                    LogUploader.this.m36950a(3, (Object) list);
                }
            });
        }
    }

    private class UpHandler extends Handler {
        private UpHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                LogUploader.this.m36953a((UploadObj) message.obj);
            }
        }
    }
}
