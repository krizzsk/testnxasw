package com.jumio.core.extraction;

import android.content.Context;
import android.graphics.Rect;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.camera.Size;
import com.jumio.commons.log.Log;
import com.jumio.core.environment.Environment;
import com.jumio.core.model.PublisherWithUpdate;
import com.jumio.core.model.StaticModel;
import com.jumio.core.persistence.DataManager;
import com.jumio.jvision.jvcorejava.swig.ImageFormat;
import com.jumio.jvision.jvcorejava.swig.ImageSource;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class ExtractionClient extends PublisherWithUpdate<ExtractionUpdate, StaticModel> {

    /* renamed from: b */
    public final AtomicBoolean f57557b;

    /* renamed from: c */
    public final AtomicBoolean f57558c;
    public Context context;

    /* renamed from: d */
    public C20954a f57559d;

    /* renamed from: e */
    public PreviewProperties f57560e;

    /* renamed from: f */
    public Rect f57561f;
    public boolean isTablet;
    public boolean shouldInitAsync = false;

    public static class ExtractionUpdate<T> {

        /* renamed from: a */
        public final T f57562a;

        /* renamed from: b */
        public final int f57563b;

        public ExtractionUpdate(int i, T t) {
            this.f57563b = i;
            this.f57562a = t;
        }

        public T getData() {
            return this.f57562a;
        }

        public int getState() {
            return this.f57563b;
        }
    }

    public class InitThread extends Thread {

        /* renamed from: a */
        public final PreviewProperties f57564a;

        /* renamed from: b */
        public final Rect f57565b;

        public InitThread(PreviewProperties previewProperties, Rect rect) {
            this.f57564a = previewProperties;
            this.f57565b = rect;
        }

        public void run() {
            ExtractionClient.this.init(this.f57564a, this.f57565b);
        }
    }

    /* renamed from: com.jumio.core.extraction.ExtractionClient$a */
    public class C20954a extends Thread {

        /* renamed from: a */
        public final Semaphore f57567a = new Semaphore(0);

        /* renamed from: b */
        public byte[] f57568b;

        public C20954a() {
        }

        /* renamed from: a */
        public void mo172077a(byte[] bArr) {
            if (ExtractionClient.this.f57557b.get() && ExtractionClient.this.shouldFeed() && ExtractionClient.this.f57558c.compareAndSet(false, true)) {
                byte[] bArr2 = this.f57568b;
                if (bArr2 == null || bArr2.length != bArr.length) {
                    this.f57568b = new byte[bArr.length];
                }
                System.arraycopy(bArr, 0, this.f57568b, 0, bArr.length);
                this.f57567a.release();
            }
        }

        public synchronized void run() {
            while (!isInterrupted()) {
                try {
                    this.f57567a.acquire();
                    int i = ExtractionClient.this.f57560e.camera.width;
                    ImageSource CreateFromUncompressedByteArray = ImageSource.CreateFromUncompressedByteArray(this.f57568b, i, ExtractionClient.this.f57560e.camera.height, ImageFormat.YUVNV21, i);
                    ExtractionClient extractionClient = ExtractionClient.this;
                    extractionClient.process(CreateFromUncompressedByteArray, extractionClient.f57560e, ExtractionClient.this.f57561f);
                } catch (InterruptedException unused) {
                    interrupt();
                } catch (Exception e) {
                    Log.printStackTrace(e);
                    ExtractionClient.this.setResult(false);
                }
            }
            notifyAll();
        }
    }

    public ExtractionClient(Context context2) {
        this.context = context2;
        Environment.loadJniJvCoreLib();
        Environment.loadJniImageQualityLib();
        this.f57557b = new AtomicBoolean(false);
        this.f57558c = new AtomicBoolean(false);
    }

    public void cancel() {
        setDataExtractionActive(false);
        System.gc();
    }

    public void cleanImages(ImageSource... imageSourceArr) {
        for (ImageSource imageSource : imageSourceArr) {
            if (imageSource != null) {
                imageSource.delete();
            }
        }
    }

    public void configure(DataManager dataManager, StaticModel staticModel) {
    }

    public void destroy() {
        cancel();
        C20954a aVar = this.f57559d;
        if (aVar != null) {
            aVar.interrupt();
            this.f57559d = null;
        }
    }

    public synchronized void feed(byte[] bArr) {
        C20954a aVar = this.f57559d;
        if (aVar != null) {
            aVar.mo172077a(bArr);
        }
    }

    public Size getPreferredPreviewSize() {
        return null;
    }

    public void init(PreviewProperties previewProperties, Rect rect) {
    }

    public boolean isDataExtractionActive() {
        return this.f57557b.get();
    }

    public boolean isProcessing() {
        return this.f57558c.get();
    }

    public abstract void process(ImageSource imageSource, PreviewProperties previewProperties, Rect rect);

    public void reinit() {
        if (this.f57561f != null && this.f57560e != null) {
            if (this.f57559d == null) {
                C20954a aVar = new C20954a();
                this.f57559d = aVar;
                aVar.start();
            }
            if (!this.f57557b.get()) {
                if (this.shouldInitAsync) {
                    new InitThread(this.f57560e, this.f57561f).start();
                } else {
                    init(this.f57560e, this.f57561f);
                }
            }
            this.f57558c.set(false);
        }
    }

    public void setDataExtractionActive(boolean z) {
        this.f57557b.set(z);
    }

    public void setExtractionArea(Rect rect) {
        this.f57561f = new Rect(rect);
    }

    public void setPreviewProperties(PreviewProperties previewProperties) {
        if (previewProperties != null) {
            this.f57560e = previewProperties.copy();
        }
    }

    public void setResult(boolean z) {
        this.f57558c.set(z);
    }

    public abstract boolean shouldFeed();

    public void takePicture() {
    }

    public boolean takePictureManually() {
        return false;
    }
}
