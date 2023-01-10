package com.didiglobal.scan.util;

import android.content.Context;
import android.view.TextureView;
import com.didi.zxing.barcodescanner.camera.CameraInstance;
import com.didi.zxing.barcodescanner.camera.CameraSettings;
import com.didi.zxing.barcodescanner.camera.CameraSurface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, mo148868d2 = {"Lcom/didiglobal/scan/util/OpenLightManager;", "", "()V", "cameraInstance", "Lcom/didi/zxing/barcodescanner/camera/CameraInstance;", "start", "", "context", "Landroid/content/Context;", "surfaceView", "Landroid/view/TextureView;", "stop", "scan_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: OpenLightManager.kt */
public final class OpenLightManager {

    /* renamed from: a */
    private CameraInstance f53904a;

    public final void start(Context context, TextureView textureView) {
        Intrinsics.checkParameterIsNotNull(textureView, "surfaceView");
        if (this.f53904a == null) {
            try {
                this.f53904a = new CameraInstance(context);
                CameraSettings cameraSettings = new CameraSettings();
                cameraSettings.setAutoTorchEnabled(true);
                CameraInstance cameraInstance = this.f53904a;
                if (cameraInstance == null) {
                    Intrinsics.throwNpe();
                }
                cameraInstance.setCameraSettings(cameraSettings);
                CameraInstance cameraInstance2 = this.f53904a;
                if (cameraInstance2 == null) {
                    Intrinsics.throwNpe();
                }
                cameraInstance2.setSurface(new CameraSurface(textureView.getSurfaceTexture()));
                CameraInstance cameraInstance3 = this.f53904a;
                if (cameraInstance3 == null) {
                    Intrinsics.throwNpe();
                }
                cameraInstance3.open();
                CameraInstance cameraInstance4 = this.f53904a;
                if (cameraInstance4 == null) {
                    Intrinsics.throwNpe();
                }
                cameraInstance4.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void stop() {
        try {
            CameraInstance cameraInstance = this.f53904a;
            if (cameraInstance == null) {
                Intrinsics.throwNpe();
            }
            cameraInstance.stopPreview();
            CameraInstance cameraInstance2 = this.f53904a;
            if (cameraInstance2 == null) {
                Intrinsics.throwNpe();
            }
            cameraInstance2.close();
            this.f53904a = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
