package com.didi.zxing.barcodescanner.camera;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.view.SurfaceHolder;
import java.io.IOException;

public class CameraSurface {

    /* renamed from: a */
    private SurfaceHolder f48039a;

    /* renamed from: b */
    private SurfaceTexture f48040b;

    public CameraSurface(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != null) {
            this.f48039a = surfaceHolder;
            return;
        }
        throw new IllegalArgumentException("surfaceHolder may not be null");
    }

    public CameraSurface(SurfaceTexture surfaceTexture) {
        if (surfaceTexture != null) {
            this.f48040b = surfaceTexture;
            return;
        }
        throw new IllegalArgumentException("surfaceTexture may not be null");
    }

    public SurfaceHolder getSurfaceHolder() {
        return this.f48039a;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.f48040b;
    }

    public void setPreview(Camera camera) throws IOException {
        SurfaceHolder surfaceHolder = this.f48039a;
        if (surfaceHolder != null) {
            camera.setPreviewDisplay(surfaceHolder);
        } else if (Build.VERSION.SDK_INT >= 11) {
            camera.setPreviewTexture(this.f48040b);
        } else {
            throw new IllegalStateException("SurfaceTexture not supported.");
        }
    }
}
