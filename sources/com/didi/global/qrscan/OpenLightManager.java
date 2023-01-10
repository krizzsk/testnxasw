package com.didi.global.qrscan;

import android.content.Context;
import android.view.TextureView;
import com.didi.zxing.barcodescanner.camera.CameraInstance;
import com.didi.zxing.barcodescanner.camera.CameraSettings;
import com.didi.zxing.barcodescanner.camera.CameraSurface;

public class OpenLightManager {

    /* renamed from: a */
    private CameraInstance f24822a;

    public void start(Context context, TextureView textureView) {
        if (this.f24822a == null) {
            try {
                this.f24822a = new CameraInstance(context);
                CameraSettings cameraSettings = new CameraSettings();
                cameraSettings.setAutoTorchEnabled(true);
                this.f24822a.setCameraSettings(cameraSettings);
                this.f24822a.setSurface(new CameraSurface(textureView.getSurfaceTexture()));
                this.f24822a.open();
                this.f24822a.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        try {
            this.f24822a.stopPreview();
            this.f24822a.close();
            this.f24822a = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
