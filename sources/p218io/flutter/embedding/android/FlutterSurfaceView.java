package p218io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import p218io.flutter.Log;
import p218io.flutter.embedding.engine.renderer.FlutterRenderer;
import p218io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import p218io.flutter.embedding.engine.renderer.RenderSurface;

/* renamed from: io.flutter.embedding.android.FlutterSurfaceView */
public class FlutterSurfaceView extends SurfaceView implements RenderSurface {

    /* renamed from: a */
    private static final String f60234a = "FlutterSurfaceView";

    /* renamed from: b */
    private final boolean f60235b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f60236c;

    /* renamed from: d */
    private boolean f60237d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f60238e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public FlutterRenderer f60239f;

    /* renamed from: g */
    private final SurfaceHolder.Callback f60240g;

    /* renamed from: h */
    private final FlutterUiDisplayListener f60241h;

    public FlutterSurfaceView(Context context) {
        this(context, (AttributeSet) null, false);
    }

    public FlutterSurfaceView(Context context, boolean z) {
        this(context, (AttributeSet) null, z);
    }

    public FlutterSurfaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, false);
    }

    private FlutterSurfaceView(Context context, AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.f60236c = false;
        this.f60237d = false;
        this.f60238e = false;
        this.f60240g = new SurfaceHolder.Callback() {
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                Log.m45259v(FlutterSurfaceView.f60234a, "SurfaceHolder.Callback.startRenderingToSurface()");
                boolean unused = FlutterSurfaceView.this.f60236c = true;
                if (FlutterSurfaceView.this.f60238e) {
                    FlutterSurfaceView.this.m45476b();
                }
            }

            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                Log.m45259v(FlutterSurfaceView.f60234a, "SurfaceHolder.Callback.surfaceChanged()");
                if (FlutterSurfaceView.this.f60238e) {
                    FlutterSurfaceView.this.m45472a(i2, i3);
                }
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                Log.m45259v(FlutterSurfaceView.f60234a, "SurfaceHolder.Callback.stopRenderingToSurface()");
                boolean unused = FlutterSurfaceView.this.f60236c = false;
                if (FlutterSurfaceView.this.f60238e) {
                    FlutterSurfaceView.this.m45478c();
                }
            }
        };
        this.f60241h = new FlutterUiDisplayListener() {
            public void onFlutterUiNoLongerDisplayed() {
            }

            public void onFlutterUiDisplayed() {
                Log.m45259v(FlutterSurfaceView.f60234a, "onFlutterUiDisplayed()");
                FlutterSurfaceView.this.setAlpha(1.0f);
                if (FlutterSurfaceView.this.f60239f != null) {
                    FlutterSurfaceView.this.f60239f.removeIsDisplayingFlutterUiListener(this);
                }
            }
        };
        this.f60235b = z;
        m45471a();
    }

    /* renamed from: a */
    private void m45471a() {
        if (this.f60235b) {
            getHolder().setFormat(-2);
            setZOrderOnTop(true);
        }
        getHolder().addCallback(this.f60240g);
        setAlpha(0.0f);
    }

    public boolean gatherTransparentRegion(Region region) {
        if (getAlpha() < 1.0f) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        region.op(iArr[0], iArr[1], (iArr[0] + getRight()) - getLeft(), (iArr[1] + getBottom()) - getTop(), Region.Op.DIFFERENCE);
        return true;
    }

    public FlutterRenderer getAttachedRenderer() {
        return this.f60239f;
    }

    public void attachToRenderer(FlutterRenderer flutterRenderer) {
        Log.m45259v(f60234a, "Attaching to FlutterRenderer.");
        if (this.f60239f != null) {
            Log.m45259v(f60234a, "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.f60239f.stopRenderingToSurface();
            this.f60239f.removeIsDisplayingFlutterUiListener(this.f60241h);
        }
        this.f60239f = flutterRenderer;
        this.f60238e = true;
        flutterRenderer.addIsDisplayingFlutterUiListener(this.f60241h);
        if (this.f60236c) {
            Log.m45259v(f60234a, "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            m45476b();
        }
        this.f60237d = false;
    }

    public void detachFromRenderer() {
        if (this.f60239f != null) {
            if (getWindowToken() != null) {
                Log.m45259v(f60234a, "Disconnecting FlutterRenderer from Android surface.");
                m45478c();
            }
            setAlpha(0.0f);
            this.f60239f.removeIsDisplayingFlutterUiListener(this.f60241h);
            this.f60239f = null;
            this.f60238e = false;
            return;
        }
        Log.m45261w(f60234a, "detachFromRenderer() invoked when no FlutterRenderer was attached.");
    }

    public void pause() {
        if (this.f60239f != null) {
            this.f60239f = null;
            this.f60237d = true;
            this.f60238e = false;
            return;
        }
        Log.m45261w(f60234a, "pause() invoked when no FlutterRenderer was attached.");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m45476b() {
        if (this.f60239f == null || getHolder() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
        }
        this.f60239f.startRenderingToSurface(getHolder().getSurface(), this.f60237d);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m45472a(int i, int i2) {
        if (this.f60239f != null) {
            Log.m45259v(f60234a, "Notifying FlutterRenderer that Android surface size has changed to " + i + " x " + i2);
            this.f60239f.surfaceChanged(i, i2);
            return;
        }
        throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m45478c() {
        FlutterRenderer flutterRenderer = this.f60239f;
        if (flutterRenderer != null) {
            flutterRenderer.stopRenderingToSurface();
            return;
        }
        throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
    }
}
