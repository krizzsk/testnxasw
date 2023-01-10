package p218io.flutter.embedding.engine.renderer;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import p218io.flutter.Log;
import p218io.flutter.embedding.engine.FlutterJNI;
import p218io.flutter.view.TextureRegistry;

/* renamed from: io.flutter.embedding.engine.renderer.FlutterRenderer */
public class FlutterRenderer implements TextureRegistry {

    /* renamed from: a */
    private static final String f60460a = "FlutterRenderer";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final FlutterJNI f60461b;

    /* renamed from: c */
    private final AtomicLong f60462c = new AtomicLong(0);

    /* renamed from: d */
    private Surface f60463d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f60464e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Handler f60465f = new Handler();

    /* renamed from: g */
    private final FlutterUiDisplayListener f60466g;

    public FlutterRenderer(FlutterJNI flutterJNI) {
        C220881 r0 = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterRenderer.this.f60464e = true;
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterRenderer.this.f60464e = false;
            }
        };
        this.f60466g = r0;
        this.f60461b = flutterJNI;
        flutterJNI.addIsDisplayingFlutterUiListener(r0);
    }

    public boolean isDisplayingFlutterUi() {
        return this.f60464e;
    }

    public void addIsDisplayingFlutterUiListener(FlutterUiDisplayListener flutterUiDisplayListener) {
        this.f60461b.addIsDisplayingFlutterUiListener(flutterUiDisplayListener);
        if (this.f60464e) {
            flutterUiDisplayListener.onFlutterUiDisplayed();
        }
    }

    public void removeIsDisplayingFlutterUiListener(FlutterUiDisplayListener flutterUiDisplayListener) {
        this.f60461b.removeIsDisplayingFlutterUiListener(flutterUiDisplayListener);
    }

    public TextureRegistry.SurfaceTextureEntry createSurfaceTexture() {
        Log.m45259v(f60460a, "Creating a SurfaceTexture.");
        return registerSurfaceTexture(new SurfaceTexture(0));
    }

    public TextureRegistry.SurfaceTextureEntry registerSurfaceTexture(SurfaceTexture surfaceTexture) {
        surfaceTexture.detachFromGLContext();
        SurfaceTextureRegistryEntry surfaceTextureRegistryEntry = new SurfaceTextureRegistryEntry(this.f60462c.getAndIncrement(), surfaceTexture);
        Log.m45259v(f60460a, "New SurfaceTexture ID: " + surfaceTextureRegistryEntry.mo182404id());
        m45595a(surfaceTextureRegistryEntry.mo182404id(), surfaceTextureRegistryEntry.textureWrapper());
        return surfaceTextureRegistryEntry;
    }

    /* renamed from: io.flutter.embedding.engine.renderer.FlutterRenderer$SurfaceTextureRegistryEntry */
    final class SurfaceTextureRegistryEntry implements TextureRegistry.SurfaceTextureEntry {
        /* access modifiers changed from: private */

        /* renamed from: id */
        public final long f60468id;
        private SurfaceTexture.OnFrameAvailableListener onFrameListener = new SurfaceTexture.OnFrameAvailableListener() {
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                if (!SurfaceTextureRegistryEntry.this.released && FlutterRenderer.this.f60461b.isAttached()) {
                    FlutterRenderer.this.m45594a(SurfaceTextureRegistryEntry.this.f60468id);
                }
            }
        };
        /* access modifiers changed from: private */
        public boolean released;
        private final SurfaceTextureWrapper textureWrapper;

        SurfaceTextureRegistryEntry(long j, SurfaceTexture surfaceTexture) {
            this.f60468id = j;
            this.textureWrapper = new SurfaceTextureWrapper(surfaceTexture);
            if (Build.VERSION.SDK_INT >= 21) {
                surfaceTexture().setOnFrameAvailableListener(this.onFrameListener, new Handler());
            } else {
                surfaceTexture().setOnFrameAvailableListener(this.onFrameListener);
            }
        }

        public SurfaceTextureWrapper textureWrapper() {
            return this.textureWrapper;
        }

        public SurfaceTexture surfaceTexture() {
            return this.textureWrapper.surfaceTexture();
        }

        /* renamed from: id */
        public long mo182404id() {
            return this.f60468id;
        }

        public void release() {
            if (!this.released) {
                Log.m45259v(FlutterRenderer.f60460a, "Releasing a SurfaceTexture (" + this.f60468id + ").");
                this.textureWrapper.release();
                FlutterRenderer.this.m45599b(this.f60468id);
                this.released = true;
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() throws Throwable {
            try {
                if (!this.released) {
                    FlutterRenderer.this.f60465f.post(new SurfaceTextureFinalizerRunnable(this.f60468id, FlutterRenderer.this.f60461b));
                    super.finalize();
                }
            } finally {
                super.finalize();
            }
        }
    }

    /* renamed from: io.flutter.embedding.engine.renderer.FlutterRenderer$SurfaceTextureFinalizerRunnable */
    static final class SurfaceTextureFinalizerRunnable implements Runnable {
        private final FlutterJNI flutterJNI;

        /* renamed from: id */
        private final long f60467id;

        SurfaceTextureFinalizerRunnable(long j, FlutterJNI flutterJNI2) {
            this.f60467id = j;
            this.flutterJNI = flutterJNI2;
        }

        public void run() {
            if (this.flutterJNI.isAttached()) {
                Log.m45259v(FlutterRenderer.f60460a, "Releasing a SurfaceTexture (" + this.f60467id + ").");
                this.flutterJNI.unregisterTexture(this.f60467id);
            }
        }
    }

    public void startRenderingToSurface(Surface surface, boolean z) {
        if (this.f60463d != null && !z) {
            stopRenderingToSurface();
        }
        this.f60463d = surface;
        this.f60461b.onSurfaceCreated(surface);
    }

    public void swapSurface(Surface surface) {
        this.f60463d = surface;
        this.f60461b.onSurfaceWindowChanged(surface);
    }

    public void surfaceChanged(int i, int i2) {
        this.f60461b.onSurfaceChanged(i, i2);
    }

    public void stopRenderingToSurface() {
        this.f60461b.onSurfaceDestroyed();
        this.f60463d = null;
        if (this.f60464e) {
            this.f60466g.onFlutterUiNoLongerDisplayed();
        }
        this.f60464e = false;
    }

    public void setViewportMetrics(ViewportMetrics viewportMetrics) {
        ViewportMetrics viewportMetrics2 = viewportMetrics;
        if (viewportMetrics.validate()) {
            Log.m45259v(f60460a, "Setting viewport metrics\nSize: " + viewportMetrics2.width + " x " + viewportMetrics2.height + "\nPadding - L: " + viewportMetrics2.viewPaddingLeft + ", T: " + viewportMetrics2.viewPaddingTop + ", R: " + viewportMetrics2.viewPaddingRight + ", B: " + viewportMetrics2.viewPaddingBottom + "\nInsets - L: " + viewportMetrics2.viewInsetLeft + ", T: " + viewportMetrics2.viewInsetTop + ", R: " + viewportMetrics2.viewInsetRight + ", B: " + viewportMetrics2.viewInsetBottom + "\nSystem Gesture Insets - L: " + viewportMetrics2.systemGestureInsetLeft + ", T: " + viewportMetrics2.systemGestureInsetTop + ", R: " + viewportMetrics2.systemGestureInsetRight + ", B: " + viewportMetrics2.systemGestureInsetRight + "\nDisplay Features: " + viewportMetrics2.displayFeatures.size());
            int[] iArr = new int[(viewportMetrics2.displayFeatures.size() * 4)];
            int[] iArr2 = new int[viewportMetrics2.displayFeatures.size()];
            int[] iArr3 = new int[viewportMetrics2.displayFeatures.size()];
            for (int i = 0; i < viewportMetrics2.displayFeatures.size(); i++) {
                DisplayFeature displayFeature = viewportMetrics2.displayFeatures.get(i);
                int i2 = i * 4;
                iArr[i2] = displayFeature.bounds.left;
                iArr[i2 + 1] = displayFeature.bounds.top;
                iArr[i2 + 2] = displayFeature.bounds.right;
                iArr[i2 + 3] = displayFeature.bounds.bottom;
                iArr2[i] = displayFeature.type.encodedValue;
                iArr3[i] = displayFeature.state.encodedValue;
            }
            int[] iArr4 = iArr3;
            FlutterJNI flutterJNI = this.f60461b;
            flutterJNI.setViewportMetrics(viewportMetrics2.devicePixelRatio, viewportMetrics2.width, viewportMetrics2.height, viewportMetrics2.viewPaddingTop, viewportMetrics2.viewPaddingRight, viewportMetrics2.viewPaddingBottom, viewportMetrics2.viewPaddingLeft, viewportMetrics2.viewInsetTop, viewportMetrics2.viewInsetRight, viewportMetrics2.viewInsetBottom, viewportMetrics2.viewInsetLeft, viewportMetrics2.systemGestureInsetTop, viewportMetrics2.systemGestureInsetRight, viewportMetrics2.systemGestureInsetBottom, viewportMetrics2.systemGestureInsetLeft, viewportMetrics2.physicalTouchSlop, iArr, iArr2, iArr4);
        }
    }

    public Bitmap getBitmap() {
        return this.f60461b.getBitmap();
    }

    public void dispatchPointerDataPacket(ByteBuffer byteBuffer, int i) {
        this.f60461b.dispatchPointerDataPacket(byteBuffer, i);
    }

    /* renamed from: a */
    private void m45595a(long j, SurfaceTextureWrapper surfaceTextureWrapper) {
        this.f60461b.registerTexture(j, surfaceTextureWrapper);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m45594a(long j) {
        this.f60461b.markTextureFrameAvailable(j);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m45599b(long j) {
        this.f60461b.unregisterTexture(j);
    }

    public boolean isSoftwareRenderingEnabled() {
        return this.f60461b.getIsSoftwareRenderingEnabled();
    }

    public void setAccessibilityFeatures(int i) {
        this.f60461b.setAccessibilityFeatures(i);
    }

    public void setSemanticsEnabled(boolean z) {
        this.f60461b.setSemanticsEnabled(z);
    }

    public void dispatchSemanticsAction(int i, int i2, ByteBuffer byteBuffer, int i3) {
        this.f60461b.dispatchSemanticsAction(i, i2, byteBuffer, i3);
    }

    /* renamed from: io.flutter.embedding.engine.renderer.FlutterRenderer$ViewportMetrics */
    public static final class ViewportMetrics {
        public static final int unsetValue = -1;
        public float devicePixelRatio = 1.0f;
        public List<DisplayFeature> displayFeatures = new ArrayList();
        public int height = 0;
        public int physicalTouchSlop = -1;
        public int systemGestureInsetBottom = 0;
        public int systemGestureInsetLeft = 0;
        public int systemGestureInsetRight = 0;
        public int systemGestureInsetTop = 0;
        public int viewInsetBottom = 0;
        public int viewInsetLeft = 0;
        public int viewInsetRight = 0;
        public int viewInsetTop = 0;
        public int viewPaddingBottom = 0;
        public int viewPaddingLeft = 0;
        public int viewPaddingRight = 0;
        public int viewPaddingTop = 0;
        public int width = 0;

        /* access modifiers changed from: package-private */
        public boolean validate() {
            return this.width > 0 && this.height > 0 && this.devicePixelRatio > 0.0f;
        }
    }

    /* renamed from: io.flutter.embedding.engine.renderer.FlutterRenderer$DisplayFeature */
    public static final class DisplayFeature {
        public final Rect bounds;
        public final DisplayFeatureState state;
        public final DisplayFeatureType type;

        public DisplayFeature(Rect rect, DisplayFeatureType displayFeatureType, DisplayFeatureState displayFeatureState) {
            this.bounds = rect;
            this.type = displayFeatureType;
            this.state = displayFeatureState;
        }

        public DisplayFeature(Rect rect, DisplayFeatureType displayFeatureType) {
            this.bounds = rect;
            this.type = displayFeatureType;
            this.state = DisplayFeatureState.UNKNOWN;
        }
    }

    /* renamed from: io.flutter.embedding.engine.renderer.FlutterRenderer$DisplayFeatureType */
    public enum DisplayFeatureType {
        UNKNOWN(0),
        FOLD(1),
        HINGE(2),
        CUTOUT(3);
        
        public final int encodedValue;

        private DisplayFeatureType(int i) {
            this.encodedValue = i;
        }
    }

    /* renamed from: io.flutter.embedding.engine.renderer.FlutterRenderer$DisplayFeatureState */
    public enum DisplayFeatureState {
        UNKNOWN(0),
        POSTURE_FLAT(1),
        POSTURE_HALF_OPENED(2);
        
        public final int encodedValue;

        private DisplayFeatureState(int i) {
            this.encodedValue = i;
        }
    }
}
