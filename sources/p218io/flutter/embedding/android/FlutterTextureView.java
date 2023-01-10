package p218io.flutter.embedding.android;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import p218io.flutter.Log;
import p218io.flutter.embedding.engine.renderer.FlutterRenderer;
import p218io.flutter.embedding.engine.renderer.RenderSurface;

/* renamed from: io.flutter.embedding.android.FlutterTextureView */
public class FlutterTextureView extends TextureView implements RenderSurface {

    /* renamed from: a */
    private static final String f60242a = "FlutterTextureView";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f60243b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f60244c;

    /* renamed from: d */
    private boolean f60245d;

    /* renamed from: e */
    private FlutterRenderer f60246e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Surface f60247f;

    /* renamed from: g */
    private final TextureView.SurfaceTextureListener f60248g;

    public FlutterTextureView(Context context) {
        this(context, (AttributeSet) null);
    }

    public FlutterTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60243b = false;
        this.f60244c = false;
        this.f60245d = false;
        this.f60248g = new TextureView.SurfaceTextureListener() {
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                Log.m45259v(FlutterTextureView.f60242a, "SurfaceTextureListener.onSurfaceTextureAvailable()");
                boolean unused = FlutterTextureView.this.f60243b = true;
                if (FlutterTextureView.this.f60244c) {
                    FlutterTextureView.this.m45487b();
                }
            }

            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                Log.m45259v(FlutterTextureView.f60242a, "SurfaceTextureListener.onSurfaceTextureSizeChanged()");
                if (FlutterTextureView.this.f60244c) {
                    FlutterTextureView.this.m45483a(i, i2);
                }
            }

            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                Log.m45259v(FlutterTextureView.f60242a, "SurfaceTextureListener.onSurfaceTextureDestroyed()");
                boolean unused = FlutterTextureView.this.f60243b = false;
                if (FlutterTextureView.this.f60244c) {
                    FlutterTextureView.this.m45489c();
                }
                if (FlutterTextureView.this.f60247f == null) {
                    return true;
                }
                FlutterTextureView.this.f60247f.release();
                Surface unused2 = FlutterTextureView.this.f60247f = null;
                return true;
            }
        };
        m45482a();
    }

    /* renamed from: a */
    private void m45482a() {
        setSurfaceTextureListener(this.f60248g);
    }

    public FlutterRenderer getAttachedRenderer() {
        return this.f60246e;
    }

    public void attachToRenderer(FlutterRenderer flutterRenderer) {
        Log.m45259v(f60242a, "Attaching to FlutterRenderer.");
        if (this.f60246e != null) {
            Log.m45259v(f60242a, "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.f60246e.stopRenderingToSurface();
        }
        this.f60246e = flutterRenderer;
        this.f60244c = true;
        if (this.f60243b) {
            Log.m45259v(f60242a, "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            m45487b();
        }
    }

    public void detachFromRenderer() {
        if (this.f60246e != null) {
            if (getWindowToken() != null) {
                Log.m45259v(f60242a, "Disconnecting FlutterRenderer from Android surface.");
                m45489c();
            }
            this.f60246e = null;
            this.f60244c = false;
            return;
        }
        Log.m45261w(f60242a, "detachFromRenderer() invoked when no FlutterRenderer was attached.");
    }

    public void pause() {
        if (this.f60246e != null) {
            this.f60246e = null;
            this.f60245d = true;
            this.f60244c = false;
            return;
        }
        Log.m45261w(f60242a, "pause() invoked when no FlutterRenderer was attached.");
    }

    public void setRenderSurface(Surface surface) {
        this.f60247f = surface;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m45487b() {
        if (this.f60246e == null || getSurfaceTexture() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
        }
        Surface surface = this.f60247f;
        if (surface != null) {
            surface.release();
            this.f60247f = null;
        }
        Surface surface2 = new Surface(getSurfaceTexture());
        this.f60247f = surface2;
        this.f60246e.startRenderingToSurface(surface2, this.f60245d);
        this.f60245d = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m45483a(int i, int i2) {
        if (this.f60246e != null) {
            Log.m45259v(f60242a, "Notifying FlutterRenderer that Android surface size has changed to " + i + " x " + i2);
            this.f60246e.surfaceChanged(i, i2);
            return;
        }
        throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m45489c() {
        FlutterRenderer flutterRenderer = this.f60246e;
        if (flutterRenderer != null) {
            flutterRenderer.stopRenderingToSurface();
            Surface surface = this.f60247f;
            if (surface != null) {
                surface.release();
                this.f60247f = null;
                return;
            }
            return;
        }
        throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
    }
}
