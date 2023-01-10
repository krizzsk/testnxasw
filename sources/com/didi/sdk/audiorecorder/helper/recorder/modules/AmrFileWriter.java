package com.didi.sdk.audiorecorder.helper.recorder.modules;

import com.didi.sdk.audiorecorder.helper.recorder.AudioProcessModule;
import com.didi.sdk.audiorecorder.helper.recorder.Supporter;
import com.didi.sdk.audiorecorder.utils.LogUtil;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class AmrFileWriter extends AudioProcessModule implements Supporter.AmrConsumer, Supporter.FileProvider {

    /* renamed from: a */
    private static final String f38135a = "AmrFileWriter -> ";

    /* renamed from: b */
    private static final byte[] f38136b = {35, 33, 65, 77, 82, 10};

    /* renamed from: c */
    private Supporter.FileConsumer f38137c;

    /* renamed from: d */
    private volatile DataOutputStream f38138d;

    /* renamed from: e */
    private File f38139e;

    /* access modifiers changed from: protected */
    public boolean performStart() {
        if (this.f38138d == null) {
            return m28791a();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void performStop() {
        if (this.f38138d != null) {
            try {
                this.f38138d.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Supporter.FileConsumer fileConsumer = this.f38137c;
            if (fileConsumer != null) {
                fileConsumer.onFileFeed(this.f38139e);
            }
        }
        this.f38138d = null;
        this.f38139e = null;
    }

    public void onAmrFeed(byte[] bArr, int i) {
        try {
            if (this.f38138d != null) {
                this.f38138d.write(bArr, 0, i);
            }
        } catch (IOException e) {
            File file = this.f38139e;
            if (file == null || !file.exists() || !this.f38139e.canWrite() || !this.f38139e.canRead()) {
                LogUtil.log("AmrFileWriter -> onAmrFeed -> Failed to write data stream, switch data stream. ", e.getLocalizedMessage());
                m28791a();
            }
        }
    }

    public void setFileConsumer(Supporter.FileConsumer fileConsumer) {
        this.f38137c = fileConsumer;
    }

    public void sliceFile() {
        if (isStarted()) {
            m28791a();
        }
    }

    /* renamed from: a */
    private boolean m28791a() {
        m28794b();
        return m28792a(m28796c());
    }

    /* renamed from: b */
    private void m28794b() {
        if (this.f38138d != null) {
            try {
                this.f38138d.close();
                if (this.f38137c != null) {
                    this.f38137c.onFileFeed(this.f38139e);
                }
            } catch (IOException e) {
                LogUtil.log("AmrFileWriter -> closeCurrentDataStream failed. ", e);
            } catch (Throwable th) {
                this.f38138d = null;
                throw th;
            }
            this.f38138d = null;
        }
    }

    /* renamed from: a */
    private boolean m28792a(File file) {
        if (file == null) {
            LogUtil.log(f38135a, "createDataStreamToCacheDir -> Failed to getCacheDir");
            notifyError(1);
            return false;
        }
        File b = m28793b(file);
        if (b != null) {
            try {
                DataOutputStream c = m28795c(b);
                try {
                    c.write(f38136b);
                    this.f38139e = b;
                    this.f38138d = c;
                    Supporter.FileConsumer fileConsumer = this.f38137c;
                    if (fileConsumer != null) {
                        fileConsumer.onTmpFileCreated(b);
                    }
                    return true;
                } catch (Exception e) {
                    LogUtil.log("AmrFileWriter -> createDataStreamToCacheDir -> failed to write amr FILE_HEADER to file: " + b.getAbsolutePath(), e);
                    if (this.f38137c.isDefaultDir(file)) {
                        notifyError(4);
                        return false;
                    }
                    LogUtil.log(f38135a, "createDataStreamToCacheDir -> failed to write amr FILE_HEADER to file, change dir to default.");
                    b.delete();
                    return m28792a(this.f38137c.getDefaultDir());
                }
            } catch (Exception e2) {
                LogUtil.log("AmrFileWriter -> createDataStreamToCacheDir -> failed to create stream. ", e2);
                if (this.f38137c.isDefaultDir(file)) {
                    notifyError(3);
                    return false;
                }
                LogUtil.log(f38135a, "createDataStreamToCacheDir -> failed to create stream, change dir to default.");
                b.delete();
                return m28792a(this.f38137c.getDefaultDir());
            }
        } else if (this.f38137c.isDefaultDir(file)) {
            LogUtil.log(f38135a, "createDataStreamToCacheDir -> Failed to create File");
            notifyError(2);
            return false;
        } else {
            LogUtil.log(f38135a, "createDataStreamToCacheDir -> Failed to create File, change dir to default.");
            return m28792a(this.f38137c.getDefaultDir());
        }
    }

    /* renamed from: c */
    private File m28796c() {
        File cacheDir = this.f38137c.getCacheDir();
        if (cacheDir != null) {
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }
            if (cacheDir.canRead() && cacheDir.canWrite()) {
                LogUtil.log(f38135a, "getCacheDir -> target dir available: ", cacheDir.getAbsolutePath());
                return cacheDir;
            }
        }
        if (this.f38137c.isDefaultDir(cacheDir)) {
            return null;
        }
        LogUtil.log(f38135a, "getCacheDir -> default dir available: ", this.f38137c.getDefaultDir().getAbsolutePath());
        return this.f38137c.getDefaultDir();
    }

    /* renamed from: b */
    private File m28793b(File file) {
        String replace = UUID.randomUUID().toString().replace("-", "");
        File file2 = new File(file, replace + ".amr");
        if (file2.exists()) {
            LogUtil.log(f38135a, "createTempFile -> success: ", file2.getAbsolutePath());
            return file2;
        }
        try {
            if (file2.createNewFile()) {
                return file2;
            }
            LogUtil.log(f38135a, "createTempFile -> failed to create new file: ", file2.getAbsolutePath());
            return null;
        } catch (IOException e) {
            LogUtil.log(f38135a, "createTempFile -> exception in creating new file: ", file2.getAbsolutePath(), e.getLocalizedMessage());
            return null;
        }
    }

    /* renamed from: c */
    private DataOutputStream m28795c(File file) throws FileNotFoundException {
        return new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
    }
}
