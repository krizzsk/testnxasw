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

public class PcmFileWriter extends AudioProcessModule implements Supporter.FileProvider, Supporter.Pcm16kConsumer, Supporter.Pcm8kConsumer {
    public static final String FILE_FLAG_PCM_16K = "_16k";
    public static final String FILE_FLAG_PCM_8K = "_8k";

    /* renamed from: a */
    private static final String f38153a = "PcmFileWriter -> ";

    /* renamed from: b */
    private Supporter.FileConsumer f38154b;

    /* renamed from: c */
    private volatile DataOutputStream f38155c;

    /* renamed from: d */
    private File f38156d;

    /* renamed from: e */
    private int f38157e;

    public void setPcm16kProvider(Supporter.Pcm16kProvider pcm16kProvider) {
    }

    public PcmFileWriter(String str) {
        if (FILE_FLAG_PCM_8K.equals(str)) {
            this.f38157e = 0;
        } else if (FILE_FLAG_PCM_16K.equals(str)) {
            this.f38157e = 1;
        } else {
            throw new IllegalArgumentException("Illegal file flag (must be '_8k' or '_16k'");
        }
    }

    /* access modifiers changed from: protected */
    public boolean performStart() {
        if (this.f38155c == null) {
            return m28805a();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void performStop() {
        if (this.f38155c != null) {
            try {
                this.f38155c.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Supporter.FileConsumer fileConsumer = this.f38154b;
            if (fileConsumer != null) {
                fileConsumer.onFileFeed(this.f38156d);
            }
        }
        this.f38155c = null;
        this.f38156d = null;
    }

    public void onPcm8kFeed(byte[] bArr, int i) {
        if (this.f38157e == 0) {
            m28804a(bArr, i);
        }
    }

    public void onPcm16kFeed(byte[] bArr, int i) {
        if (this.f38157e == 1) {
            m28804a(bArr, i);
        }
    }

    /* renamed from: a */
    private void m28804a(byte[] bArr, int i) {
        try {
            if (this.f38155c != null) {
                this.f38155c.write(bArr, 0, i);
            }
        } catch (IOException e) {
            File file = this.f38156d;
            if (file == null || !file.exists() || !this.f38156d.canWrite() || !this.f38156d.canRead()) {
                LogUtil.log("PcmFileWriter -> pcmToFile -> Failed to write data stream, switch data stream. ", e.getLocalizedMessage());
                m28805a();
            }
        }
    }

    public void setFileConsumer(Supporter.FileConsumer fileConsumer) {
        this.f38154b = fileConsumer;
    }

    public void sliceFile() {
        if (isStarted()) {
            m28805a();
        }
    }

    /* renamed from: a */
    private boolean m28805a() {
        m28808b();
        return m28806a(m28810c());
    }

    /* renamed from: b */
    private void m28808b() {
        if (this.f38155c != null) {
            try {
                this.f38155c.close();
                if (this.f38154b != null) {
                    this.f38154b.onFileFeed(this.f38156d);
                }
            } catch (IOException e) {
                LogUtil.log("PcmFileWriter -> closeCurrentDataStream failed. ", e);
            } catch (Throwable th) {
                this.f38155c = null;
                throw th;
            }
            this.f38155c = null;
        }
    }

    /* renamed from: a */
    private boolean m28806a(File file) {
        if (file == null) {
            LogUtil.log(f38153a, "createDataStreamToCacheDir -> Failed to getCacheDir");
            notifyError(1);
            return false;
        }
        File b = m28807b(file);
        if (b != null) {
            try {
                DataOutputStream c = m28809c(b);
                this.f38156d = b;
                this.f38155c = c;
                Supporter.FileConsumer fileConsumer = this.f38154b;
                if (fileConsumer != null) {
                    fileConsumer.onTmpFileCreated(b);
                }
                return true;
            } catch (Exception e) {
                LogUtil.log("PcmFileWriter -> createDataStreamToCacheDir -> failed to create stream. ", e);
                if (this.f38154b.isDefaultDir(file)) {
                    notifyError(3);
                    return false;
                }
                LogUtil.log(f38153a, "createDataStreamToCacheDir -> failed to create stream, change dir to default.");
                b.delete();
                return m28806a(this.f38154b.getDefaultDir());
            }
        } else if (this.f38154b.isDefaultDir(file)) {
            LogUtil.log(f38153a, "createDataStreamToCacheDir -> Failed to create File");
            notifyError(2);
            return false;
        } else {
            LogUtil.log(f38153a, "createDataStreamToCacheDir -> Failed to create File, change dir to default.");
            return m28806a(this.f38154b.getDefaultDir());
        }
    }

    /* renamed from: c */
    private File m28810c() {
        File cacheDir = this.f38154b.getCacheDir();
        if (cacheDir != null) {
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }
            if (cacheDir.canRead() && cacheDir.canWrite()) {
                LogUtil.log(f38153a, "getCacheDir -> target dir available: ", cacheDir.getAbsolutePath());
                return cacheDir;
            }
        }
        if (this.f38154b.isDefaultDir(cacheDir)) {
            return null;
        }
        LogUtil.log(f38153a, "getCacheDir -> default dir available: ", this.f38154b.getDefaultDir().getAbsolutePath());
        return this.f38154b.getDefaultDir();
    }

    /* renamed from: b */
    private File m28807b(File file) {
        String replace = UUID.randomUUID().toString().replace("-", "");
        StringBuilder sb = new StringBuilder();
        sb.append(replace);
        sb.append(this.f38157e == 0 ? FILE_FLAG_PCM_8K : FILE_FLAG_PCM_16K);
        sb.append(".pcm");
        File file2 = new File(file, sb.toString());
        if (file2.exists()) {
            LogUtil.log(f38153a, "createTempFile -> success: ", file2.getAbsolutePath());
            return file2;
        }
        try {
            if (file2.createNewFile()) {
                return file2;
            }
            LogUtil.log(f38153a, "createTempFile -> failed to create new file: ", file2.getAbsolutePath());
            return null;
        } catch (IOException e) {
            LogUtil.log(f38153a, "createTempFile -> exception in creating new file: ", file2.getAbsolutePath(), e.getLocalizedMessage());
            return null;
        }
    }

    /* renamed from: c */
    private DataOutputStream m28809c(File file) throws FileNotFoundException {
        return new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
    }
}
