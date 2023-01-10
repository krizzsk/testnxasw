package com.jumio.core.extraction.manual;

import android.content.Context;
import android.graphics.Rect;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.log.Log;
import com.jumio.core.extraction.ExtractionClient;
import com.jumio.core.extraction.ExtractionUpdateState;
import com.jumio.jvision.jvcorejava.swig.ImageSource;
import java.util.concurrent.atomic.AtomicBoolean;

public class ManualPictureClient extends ExtractionClient {

    /* renamed from: g */
    public final AtomicBoolean f57635g = new AtomicBoolean(false);

    /* renamed from: h */
    public final AtomicBoolean f57636h = new AtomicBoolean(false);

    public ManualPictureClient(Context context) {
        super(context);
    }

    public void init(PreviewProperties previewProperties, Rect rect) {
        super.init(previewProperties, rect);
        this.f57635g.set(false);
        this.f57636h.set(false);
    }

    public void process(ImageSource imageSource, PreviewProperties previewProperties, Rect rect) {
        boolean z = true;
        try {
            if (!this.f57635g.get() || this.f57636h.get()) {
                this.f57635g.set(false);
                z = false;
                imageSource.delete();
                setResult(z);
            }
            this.f57636h.set(true);
            publishUpdate(new ExtractionClient.ExtractionUpdate(ExtractionUpdateState.shotTaken, Float.valueOf(1.0f)));
            publishUpdate(new ExtractionClient.ExtractionUpdate(ExtractionUpdateState.saveImage, CameraUtils.yuv2bitmap(imageSource, previewProperties.isPortrait, previewProperties, rect, -1)));
            publishResult(null);
            System.gc();
            imageSource.delete();
            setResult(z);
        } catch (Exception e) {
            Log.m43666w("ImageCheck", "computeFocusConfidence failed!", (Throwable) e);
        }
    }

    public boolean shouldFeed() {
        return !this.f57636h.get();
    }

    public void takePicture() {
        this.f57635g.set(true);
    }

    public boolean takePictureManually() {
        return true;
    }
}
