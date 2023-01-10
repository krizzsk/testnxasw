package com.didichuxing.dfbasesdk.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.passenger.C11267R;
import com.didichuxing.dfbasesdk.camera.CameraWrapper;
import com.didichuxing.dfbasesdk.camera.IMediaInterface;
import com.didichuxing.dfbasesdk.utils.ResUtils;
import com.didichuxing.dfbasesdk.video_capture.IErrorListener;
import com.didichuxing.dfbasesdk.video_capture.IMediaControl;
import com.didichuxing.dfbasesdk.video_capture.RendererDecorate2;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GLSurfaceViewEx extends GLSurfaceView implements LifecycleObserver, IMediaInterface {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public CameraWrapper f49580a;

    /* renamed from: b */
    private RendererDecorate2 f49581b;

    /* renamed from: c */
    private int f49582c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public SurfaceTexture f49583d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Camera.PreviewCallback f49584e;

    /* renamed from: f */
    private IMediaControl f49585f;

    /* renamed from: g */
    private int f49586g;

    /* renamed from: h */
    private int f49587h;

    public GLSurfaceViewEx(Context context) {
        this(context, (AttributeSet) null);
    }

    public GLSurfaceViewEx(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m37132a(attributeSet);
        m37131a();
    }

    /* renamed from: a */
    private void m37132a(AttributeSet attributeSet) {
        TypedArray typedArray = null;
        try {
            typedArray = getContext().obtainStyledAttributes(attributeSet, C11267R.styleable.GLSurfaceViewEx);
            this.f49586g = typedArray.getInt(4, 640);
            this.f49587h = typedArray.getInt(3, 480);
            int i = typedArray.getInt(2, -1);
            int i2 = typedArray.getInt(1, -1);
            this.f49582c = typedArray.getInt(0, 0);
            this.f49580a = new CameraWrapper(ResUtils.isScreenPortrait(getContext()), -1, -1, this.f49586g, this.f49587h, i, i2);
            if (typedArray == null) {
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (typedArray == null) {
                return;
            }
        } catch (Throwable th) {
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw th;
        }
        typedArray.recycle();
    }

    public void setCallback(Camera.PreviewCallback previewCallback) {
        this.f49584e = previewCallback;
    }

    /* renamed from: a */
    private void m37131a() {
        setEGLContextClientVersion(2);
        C161391 r0 = new RendererDecorate2(getContext(), this.f49580a, this) {
            public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig, SurfaceTexture surfaceTexture) {
                SurfaceTexture unused = GLSurfaceViewEx.this.f49583d = surfaceTexture;
                if (GLSurfaceViewEx.this.f49580a != null) {
                    GLSurfaceViewEx.this.f49580a.startPreview(GLSurfaceViewEx.this.f49583d);
                    GLSurfaceViewEx.this.f49580a.autoFocus();
                    if (GLSurfaceViewEx.this.f49584e != null) {
                        GLSurfaceViewEx.this.f49580a.setPreviewCallback(GLSurfaceViewEx.this.f49584e);
                    }
                }
            }
        };
        this.f49581b = r0;
        setRenderer(r0);
        this.f49585f = this.f49581b.getMediaControl();
        if (getContext() instanceof LifecycleOwner) {
            ((LifecycleOwner) getContext()).getLifecycle().addObserver(this);
        }
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GLSurfaceViewEx.this.autoFocus();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        setMeasuredDimension(measuredWidth, (int) (((((float) measuredWidth) * 1.0f) * ((float) this.f49586g)) / ((float) this.f49587h)));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void openCamera() {
        CameraWrapper cameraWrapper = this.f49580a;
        if (cameraWrapper != null) {
            cameraWrapper.openCamera(this.f49582c);
            if (!(this.f49580a.getPreviewWidth() == this.f49586g && this.f49580a.getPreviewHeight() == this.f49587h)) {
                this.f49586g = this.f49580a.getPreviewWidth();
                this.f49587h = this.f49580a.getPreviewHeight();
                requestLayout();
            }
        }
        onResume();
    }

    public void openCamera(int i) {
        this.f49582c = i;
        openCamera();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void closeCamera() {
        onPause();
        CameraWrapper cameraWrapper = this.f49580a;
        if (cameraWrapper != null) {
            cameraWrapper.closeCamera();
        }
    }

    public void setRecordVideo(boolean z, float f, int i) {
        RendererDecorate2 rendererDecorate2 = this.f49581b;
        if (rendererDecorate2 != null) {
            rendererDecorate2.setRecordVideo(z, f, i);
        }
    }

    public void startRecord() {
        IMediaControl iMediaControl = this.f49585f;
        if (iMediaControl != null) {
            iMediaControl.startRecord();
        }
    }

    public void startRecord(String str) {
        IMediaControl iMediaControl = this.f49585f;
        if (iMediaControl != null) {
            iMediaControl.startRecord(str);
        }
    }

    public void stopRecord() {
        IMediaControl iMediaControl = this.f49585f;
        if (iMediaControl != null) {
            iMediaControl.stopRecord();
        }
    }

    public boolean recording() {
        IMediaControl iMediaControl = this.f49585f;
        if (iMediaControl != null) {
            return iMediaControl.recording();
        }
        return false;
    }

    public String getVideoPath() {
        IMediaControl iMediaControl = this.f49585f;
        if (iMediaControl != null) {
            return iMediaControl.getVideoPath();
        }
        return null;
    }

    public void setErrorListener(IErrorListener iErrorListener) {
        IMediaControl iMediaControl = this.f49585f;
        if (iMediaControl != null) {
            iMediaControl.setErrorListener(iErrorListener);
        }
    }

    public void switchCamera() {
        SurfaceTexture surfaceTexture;
        CameraWrapper cameraWrapper = this.f49580a;
        if (cameraWrapper != null && (surfaceTexture = this.f49583d) != null) {
            cameraWrapper.switchCamera(surfaceTexture);
        }
    }

    public void autoFocus() {
        CameraWrapper cameraWrapper = this.f49580a;
        if (cameraWrapper != null) {
            cameraWrapper.autoFocus();
        }
    }

    public void takePhoto(Camera.PictureCallback pictureCallback) {
        CameraWrapper cameraWrapper = this.f49580a;
        if (cameraWrapper != null) {
            cameraWrapper.takePhoto(pictureCallback);
        }
    }

    public boolean switchFlashLight() {
        CameraWrapper cameraWrapper = this.f49580a;
        if (cameraWrapper != null) {
            return cameraWrapper.switchFlashLight();
        }
        return false;
    }

    public CameraWrapper getCamera() {
        return this.f49580a;
    }

    public int getPreviewWidth() {
        return this.f49580a.getPreviewWidth();
    }

    public int getPreviewHeight() {
        return this.f49580a.getPreviewHeight();
    }
}
