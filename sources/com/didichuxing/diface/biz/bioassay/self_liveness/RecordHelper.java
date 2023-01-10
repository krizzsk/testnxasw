package com.didichuxing.diface.biz.bioassay.self_liveness;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.didichuxing.dfbasesdk.data.NewBaseResult;
import com.didichuxing.dfbasesdk.data.ResultNothing;
import com.didichuxing.dfbasesdk.http.AbsRpcCallback;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.NetworkUtils;
import com.didichuxing.diface.biz.bioassay.self_liveness.IUploadVideoRequester;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.diface.utils.FileUtils;
import com.didichuxing.sdk.alphaface.core.RendererDecorate;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class RecordHelper implements LifecycleObserver {
    public static final long VIDEO_RECORD_UPLOAD_DELAY = TimeUnit.SECONDS.toMillis(1);
    public final long VIDEO_RECORD_STOP_DELAY;

    /* renamed from: a */
    final Runnable f49895a = new Runnable() {
        public void run() {
            RecordHelper.this.onSuccess();
        }
    };

    /* renamed from: b */
    private final RendererDecorate f49896b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Context f49897c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final String f49898d;

    /* renamed from: e */
    private final Handler f49899e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f49900f;

    /* renamed from: g */
    private boolean f49901g;

    /* renamed from: h */
    private boolean f49902h;

    /* renamed from: i */
    private long f49903i;

    /* renamed from: j */
    private long f49904j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final String f49905k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public String f49906l = "0";
    /* access modifiers changed from: private */

    /* renamed from: m */
    public String f49907m = "";

    public RecordHelper(Context context, RendererDecorate rendererDecorate, String str, int i, long j, long j2) {
        this.f49896b = rendererDecorate;
        this.f49897c = context.getApplicationContext();
        this.f49905k = str;
        this.f49898d = DiFaceFacade.getInstance().getSessionId();
        this.VIDEO_RECORD_STOP_DELAY = TimeUnit.SECONDS.toMillis((long) i);
        this.f49903i = j;
        this.f49904j = j2;
        this.f49899e = new Handler(Looper.getMainLooper());
    }

    public void onStart() {
        if (this.f49896b != null && TextUtils.isEmpty(this.f49900f)) {
            this.f49896b.startRecord();
        }
    }

    /* renamed from: a */
    private void m37362a() {
        RendererDecorate rendererDecorate = this.f49896b;
        if (rendererDecorate != null) {
            String videoPath = rendererDecorate.getVideoPath();
            this.f49900f = videoPath;
            if (!TextUtils.isEmpty(videoPath)) {
                m37367b();
            }
        }
    }

    /* renamed from: b */
    private void m37367b() {
        DiFaceFacade.getInstance().report("201", DiFaceLogger.setBioType((HashMap<String, Object>) null, this.f49905k), (HashMap<String, Object>) null);
        this.f49899e.postDelayed(new Runnable() {
            public void run() {
                File file = new File(RecordHelper.this.f49900f);
                if (RecordHelper.this.m37364a(file)) {
                    IUploadVideoRequester.Holder.createRequest(RecordHelper.this.f49897c).upload(RecordHelper.this.f49898d, file, new AbsRpcCallback<NewBaseResult<ResultNothing>, ResultNothing>() {
                        /* access modifiers changed from: protected */
                        public void failure(int i, String str) {
                            RecordHelper recordHelper = RecordHelper.this;
                            String unused = recordHelper.f49907m = "code:" + i + "  msg:" + str;
                            FileUtils.deleteFile(RecordHelper.this.f49900f);
                        }

                        /* access modifiers changed from: protected */
                        public void success(ResultNothing resultNothing, int i, String str) {
                            String unused = RecordHelper.this.f49906l = "1";
                            FileUtils.deleteFile(RecordHelper.this.f49900f);
                        }
                    });
                } else {
                    String unused = RecordHelper.this.f49907m = "文件太大或无网络";
                    FileUtils.delete(file);
                    LogUtils.m37052d("xxxx", "ifUpload: false : ");
                }
                HashMap hashMap = new HashMap();
                hashMap.put("success", RecordHelper.this.f49906l);
                hashMap.put("errorMsg", RecordHelper.this.f49907m);
                DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_UPLOAD_VIDEO_CALLBACK, DiFaceLogger.setBioType(hashMap, RecordHelper.this.f49905k), (HashMap<String, Object>) null);
            }
        }, VIDEO_RECORD_UPLOAD_DELAY);
    }

    public void hasFace() {
        this.f49901g = true;
    }

    public void hasAction() {
        this.f49902h = true;
    }

    public void removeTimeoutRunnable() {
        this.f49899e.removeCallbacks(this.f49895a);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        removeTimeoutRunnable();
        RendererDecorate rendererDecorate = this.f49896b;
        if (rendererDecorate != null && rendererDecorate.isRecordVideo()) {
            FileUtils.deleteFile(this.f49896b.getVideoPath());
        }
    }

    public void onFailed() {
        removeTimeoutRunnable();
        m37362a();
    }

    public void onSuccess() {
        removeTimeoutRunnable();
        RendererDecorate rendererDecorate = this.f49896b;
        if (rendererDecorate != null) {
            String videoPath = rendererDecorate.getVideoPath();
            this.f49900f = videoPath;
            if (!TextUtils.isEmpty(videoPath)) {
                m37367b();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m37364a(File file) {
        long length = file.length() / 1024;
        return (NetworkUtils.isWifi(this.f49897c) && length <= this.f49903i * 1024) || (NetworkUtils.is4G(this.f49897c) && length <= this.f49904j * 1024);
    }
}
