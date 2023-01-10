package com.jumio.core.extraction.liveness.extraction;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.camera.ImageData;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.log.Log;
import com.jumio.core.environment.Environment;
import com.jumio.core.models.AuthorizationModel;
import com.jumio.jvision.jvcorejava.swig.ImageSource;
import java.io.File;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LivenessSavingTask extends Thread {

    /* renamed from: a */
    public final Queue<ImageSource> f57612a = new ConcurrentLinkedQueue();

    /* renamed from: b */
    public final LinkedList<ImageData> f57613b = new LinkedList<>();

    /* renamed from: c */
    public final int f57614c;

    /* renamed from: d */
    public final int f57615d;

    /* renamed from: e */
    public final File f57616e;

    /* renamed from: f */
    public long f57617f;

    /* renamed from: g */
    public boolean f57618g;

    /* renamed from: h */
    public boolean f57619h;

    /* renamed from: i */
    public PreviewProperties f57620i;

    /* renamed from: j */
    public Rect f57621j;

    /* renamed from: k */
    public int f57622k;

    /* renamed from: l */
    public final AuthorizationModel.SessionKey f57623l;

    public LivenessSavingTask(Context context, AuthorizationModel.SessionKey sessionKey, int i, int i2) {
        this.f57616e = Environment.getDataDirectory(context);
        this.f57623l = sessionKey;
        this.f57614c = i;
        this.f57615d = i2;
        reset();
    }

    /* renamed from: a */
    public final void mo172154a(ImageSource imageSource) {
        if (imageSource != null) {
            try {
                Locale locale = Locale.ENGLISH;
                int i = this.f57622k;
                this.f57622k = i + 1;
                String format = String.format(locale, "tmp_%04d", new Object[]{Integer.valueOf(i)});
                Bitmap yuv2bitmap = CameraUtils.yuv2bitmap(imageSource, this.f57619h, this.f57620i, this.f57621j, 640);
                File file = new File(this.f57616e, format);
                CameraUtils.saveBitmap(yuv2bitmap, file, Bitmap.CompressFormat.JPEG, 70, this.f57623l);
                ImageData imageData = new ImageData();
                imageData.getImage().setPath(file.getAbsolutePath());
                imageData.getImage().getSize().width = yuv2bitmap.getWidth();
                imageData.getImage().getSize().height = yuv2bitmap.getHeight();
                imageData.getImage().setType(ImageData.FileType.JPG);
                this.f57613b.addFirst(imageData);
                if (this.f57613b.size() > this.f57615d) {
                    new File(this.f57616e, this.f57613b.removeLast().getImage().getPath()).delete();
                }
                System.gc();
            } catch (Exception | OutOfMemoryError e) {
                Log.printStackTrace(e);
            }
        }
    }

    public void add(ImageSource imageSource) {
        try {
            if (this.f57614c != 0 && this.f57620i != null) {
                if (this.f57621j != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!isInterrupted() && currentTimeMillis - this.f57617f >= 500) {
                        if (isActive()) {
                            this.f57617f = currentTimeMillis;
                            this.f57612a.add(imageSource);
                        }
                    }
                }
            }
        } catch (OutOfMemoryError e) {
            this.f57612a.clear();
            Log.printStackTrace(e);
            System.gc();
        }
    }

    public void addSync(ImageSource imageSource) {
        try {
            if (this.f57614c != 0 && this.f57620i != null) {
                if (this.f57621j != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!isInterrupted() && currentTimeMillis - this.f57617f >= 500) {
                        if (isActive()) {
                            this.f57617f = currentTimeMillis;
                            mo172154a(imageSource);
                        }
                    }
                }
            }
        } catch (OutOfMemoryError e) {
            Log.printStackTrace(e);
            System.gc();
        }
    }

    public ImageData[] finish() {
        int i = 0;
        setActive(false);
        int size = this.f57613b.size();
        int i2 = this.f57614c;
        if (size <= i2) {
            ImageData[] imageDataArr = new ImageData[this.f57613b.size()];
            while (i < this.f57613b.size()) {
                imageDataArr[(this.f57613b.size() - 1) - i] = this.f57613b.get(i);
                i++;
            }
            return imageDataArr;
        }
        ImageData[] imageDataArr2 = new ImageData[i2];
        int i3 = i2 / 2;
        int i4 = i2 - 1;
        int i5 = 0;
        while (i5 < i3) {
            imageDataArr2[i4] = this.f57613b.get(i5);
            i5++;
            i4--;
        }
        int i6 = this.f57614c;
        int i7 = (i6 / 2) + (i6 % 2);
        int size2 = ((this.f57613b.size() - 1) - i7) / i7;
        int size3 = this.f57613b.size() - 1;
        while (size3 >= i7 && i < i7) {
            imageDataArr2[i] = this.f57613b.get(size3);
            size3 -= size2;
            i++;
        }
        return imageDataArr2;
    }

    public void init(PreviewProperties previewProperties, Rect rect, boolean z) {
        this.f57620i = previewProperties;
        this.f57621j = rect;
        this.f57619h = z;
    }

    public synchronized boolean isActive() {
        return this.f57618g;
    }

    public void reset() {
        this.f57612a.clear();
        this.f57613b.clear();
        System.gc();
        this.f57622k = 0;
    }

    public void run() {
        while (!isInterrupted()) {
            mo172154a(this.f57612a.poll());
        }
        reset();
    }

    public synchronized void setActive(boolean z) {
        this.f57618g = z;
    }
}
