package com.didichuxing.diface.appeal.brazil;

import android.content.Context;
import com.didichuxing.diface.appeal.video.p180M.fetch_demo.FetchDemoModel;
import com.didichuxing.diface.appeal.video.p180M.fetch_demo.FetchDemoResult;
import com.didichuxing.diface.utils.FileUtils;
import com.didichuxing.diface.utils.HttpUtils;
import com.didichuxing.diface.utils.http.AbsHttpCallback;
import java.io.File;
import java.io.IOException;

public class AppealExampleManager {

    /* renamed from: a */
    private static volatile AppealExampleManager f49669a;

    /* renamed from: b */
    private Context f49670b;

    /* renamed from: c */
    private String f49671c;

    /* renamed from: d */
    private String f49672d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f49673e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f49674f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public IDownloadCallback f49675g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f49676h = false;

    public interface IDownloadCallback {
        void onPhotoDownload(boolean z);

        void onVideoDownload(boolean z);
    }

    public static AppealExampleManager getInstance() {
        if (f49669a == null) {
            synchronized (AppealExampleManager.class) {
                if (f49669a == null) {
                    f49669a = new AppealExampleManager();
                }
            }
        }
        return f49669a;
    }

    public void init(Context context) {
        this.f49670b = context.getApplicationContext();
        String absolutePath = FileUtils.getDir(this.f49670b.getFilesDir() + File.separator + "diface").getAbsolutePath();
        this.f49671c = absolutePath + File.separator + "videoDemo.mp4";
        this.f49672d = absolutePath + File.separator + "photoDemo.jpg";
    }

    public void setDownloadCallback(IDownloadCallback iDownloadCallback) {
        this.f49675g = iDownloadCallback;
    }

    public void downloadExample() {
        if (!this.f49676h) {
            if (new File(this.f49671c).exists()) {
                this.f49673e = true;
            } else {
                this.f49673e = false;
            }
            if (new File(this.f49672d).exists()) {
                this.f49674f = true;
            } else {
                this.f49674f = false;
            }
            if (!this.f49673e || !this.f49674f) {
                this.f49676h = true;
                new FetchDemoModel(this.f49670b).fetch(new AbsHttpCallback<FetchDemoResult>() {
                    public void onSuccess(FetchDemoResult fetchDemoResult) {
                        int i = fetchDemoResult.data.code;
                        String str = fetchDemoResult.data.message;
                        if (i == 100000) {
                            AppealExampleManager.this.m37178a(fetchDemoResult);
                        } else {
                            onFailed(i, str);
                        }
                    }

                    public void onFailed(int i, String str) {
                        boolean unused = AppealExampleManager.this.f49676h = false;
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37178a(FetchDemoResult fetchDemoResult) {
        String str = fetchDemoResult.data.result.teachVideoUrl;
        String str2 = fetchDemoResult.data.result.demoPhotoUrl;
        m37179a(str);
        m37181b(str2);
    }

    /* renamed from: a */
    private void m37179a(String str) {
        if (!this.f49673e) {
            HttpUtils.download(this.f49670b, str, new File(this.f49671c), new HttpUtils.IDownloadListener() {
                public void onSuccess() {
                    boolean unused = AppealExampleManager.this.f49673e = true;
                    if (AppealExampleManager.this.f49675g != null) {
                        AppealExampleManager.this.f49675g.onVideoDownload(true);
                    }
                }

                public void onFailed(IOException iOException) {
                    boolean unused = AppealExampleManager.this.f49673e = false;
                    if (AppealExampleManager.this.f49675g != null) {
                        AppealExampleManager.this.f49675g.onVideoDownload(false);
                    }
                }
            });
            return;
        }
        IDownloadCallback iDownloadCallback = this.f49675g;
        if (iDownloadCallback != null) {
            iDownloadCallback.onVideoDownload(true);
        }
    }

    /* renamed from: b */
    private void m37181b(String str) {
        if (!this.f49674f) {
            HttpUtils.download(this.f49670b, str, new File(this.f49672d), new HttpUtils.IDownloadListener() {
                public void onSuccess() {
                    boolean unused = AppealExampleManager.this.f49674f = true;
                    if (AppealExampleManager.this.f49675g != null) {
                        AppealExampleManager.this.f49675g.onPhotoDownload(true);
                    }
                }

                public void onFailed(IOException iOException) {
                    boolean unused = AppealExampleManager.this.f49674f = false;
                    if (AppealExampleManager.this.f49675g != null) {
                        AppealExampleManager.this.f49675g.onPhotoDownload(false);
                    }
                }
            });
            return;
        }
        IDownloadCallback iDownloadCallback = this.f49675g;
        if (iDownloadCallback != null) {
            iDownloadCallback.onPhotoDownload(true);
        }
    }

    public boolean isVideoDemoExist() {
        return this.f49673e;
    }

    public String getVideoPath() {
        return this.f49671c;
    }

    public boolean isPhotoDemoExist() {
        return this.f49674f;
    }

    public String getPhotoPath() {
        return this.f49672d;
    }

    public boolean isDownloading() {
        return this.f49676h;
    }
}
