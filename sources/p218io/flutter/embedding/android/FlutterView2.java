package p218io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import androidx.window.java.layout.WindowInfoTrackerCallbackAdapter;
import androidx.window.layout.DisplayFeature;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import p218io.flutter.Log;
import p218io.flutter.embedding.android.FlutterImageView;
import p218io.flutter.embedding.engine.FlutterEngine;
import p218io.flutter.embedding.engine.renderer.FlutterRenderer;
import p218io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import p218io.flutter.embedding.engine.renderer.RenderSurface;
import p218io.flutter.embedding.engine.systemchannels.SettingsChannel;
import p218io.flutter.plugin.editing.TextInputPlugin;
import p218io.flutter.plugin.localization.LocalizationPlugin;
import p218io.flutter.plugin.mouse.MouseCursorPlugin;
import p218io.flutter.util.ViewUtils;
import p218io.flutter.view.AccessibilityBridge;

/* renamed from: io.flutter.embedding.android.FlutterView2 */
public class FlutterView2 extends FrameLayout implements MouseCursorPlugin.MouseCursorViewDelegate {

    /* renamed from: b */
    private static final String f60270b = "FlutterView";

    /* renamed from: a */
    RenderSurface f60271a;

    /* renamed from: c */
    private FlutterSurfaceView f60272c;

    /* renamed from: d */
    private FlutterTextureView f60273d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public FlutterImageView f60274e;

    /* renamed from: f */
    private RenderSurface f60275f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Set<FlutterUiDisplayListener> f60276g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f60277h;

    /* renamed from: i */
    private FlutterEngine f60278i;

    /* renamed from: j */
    private final Set<FlutterEngineAttachmentListener> f60279j;

    /* renamed from: k */
    private MouseCursorPlugin f60280k;

    /* renamed from: l */
    private TextInputPlugin f60281l;

    /* renamed from: m */
    private LocalizationPlugin f60282m;

    /* renamed from: n */
    private KeyboardManager f60283n;

    /* renamed from: o */
    private AndroidTouchProcessor f60284o;

    /* renamed from: p */
    private AccessibilityBridge f60285p;

    /* renamed from: q */
    private WindowInfoRepositoryCallbackAdapterWrapper f60286q;

    /* renamed from: r */
    private final FlutterRenderer.ViewportMetrics f60287r;

    /* renamed from: s */
    private final AccessibilityBridge.OnAccessibilityChangeListener f60288s;

    /* renamed from: t */
    private final FlutterUiDisplayListener f60289t;

    /* renamed from: u */
    private final Consumer<WindowLayoutInfo> f60290u;

    /* renamed from: io.flutter.embedding.android.FlutterView2$FlutterEngineAttachmentListener */
    public interface FlutterEngineAttachmentListener {
        void onFlutterEngineAttachedToFlutterView(FlutterEngine flutterEngine);

        void onFlutterEngineDetachedFromFlutterView();
    }

    /* renamed from: io.flutter.embedding.android.FlutterView2$ZeroSides */
    private enum ZeroSides {
        NONE,
        LEFT,
        RIGHT,
        BOTH
    }

    public FlutterView2(Context context) {
        this(context, (AttributeSet) null, new FlutterSurfaceView(context));
    }

    @Deprecated
    public FlutterView2(Context context, RenderMode renderMode) {
        super(context, (AttributeSet) null);
        this.f60276g = new HashSet();
        this.f60279j = new HashSet();
        this.f60287r = new FlutterRenderer.ViewportMetrics();
        this.f60288s = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView2.this.m45507a(z, z2);
            }
        };
        this.f60289t = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView2.this.f60277h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterView2.this.f60276g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView2.this.f60277h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterView2.this.f60276g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.f60290u = new Consumer<WindowLayoutInfo>() {
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView2.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        if (renderMode == RenderMode.surface) {
            FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(context);
            this.f60272c = flutterSurfaceView;
            this.f60271a = flutterSurfaceView;
        } else if (renderMode == RenderMode.texture) {
            FlutterTextureView flutterTextureView = new FlutterTextureView(context);
            this.f60273d = flutterTextureView;
            this.f60271a = flutterTextureView;
        } else {
            throw new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", new Object[]{renderMode}));
        }
        m45510b();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public FlutterView2(Context context, TransparencyMode transparencyMode) {
        this(context, (AttributeSet) null, new FlutterSurfaceView(context, transparencyMode == TransparencyMode.transparent));
    }

    public FlutterView2(Context context, FlutterSurfaceView flutterSurfaceView) {
        this(context, (AttributeSet) null, flutterSurfaceView);
    }

    public FlutterView2(Context context, FlutterTextureView flutterTextureView) {
        this(context, (AttributeSet) null, flutterTextureView);
    }

    public FlutterView2(Context context, FlutterImageView flutterImageView) {
        this(context, (AttributeSet) null, flutterImageView);
    }

    public FlutterView2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, new FlutterSurfaceView(context));
    }

    @Deprecated
    public FlutterView2(Context context, RenderMode renderMode, TransparencyMode transparencyMode) {
        super(context, (AttributeSet) null);
        this.f60276g = new HashSet();
        this.f60279j = new HashSet();
        this.f60287r = new FlutterRenderer.ViewportMetrics();
        this.f60288s = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView2.this.m45507a(z, z2);
            }
        };
        this.f60289t = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView2.this.f60277h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterView2.this.f60276g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView2.this.f60277h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterView2.this.f60276g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.f60290u = new Consumer<WindowLayoutInfo>() {
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView2.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        boolean z = false;
        if (renderMode == RenderMode.surface) {
            FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(context, transparencyMode == TransparencyMode.transparent ? true : z);
            this.f60272c = flutterSurfaceView;
            this.f60271a = flutterSurfaceView;
        } else if (renderMode == RenderMode.texture) {
            FlutterTextureView flutterTextureView = new FlutterTextureView(context);
            this.f60273d = flutterTextureView;
            this.f60271a = flutterTextureView;
        } else {
            throw new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", new Object[]{renderMode}));
        }
        m45510b();
    }

    private FlutterView2(Context context, AttributeSet attributeSet, FlutterSurfaceView flutterSurfaceView) {
        super(context, attributeSet);
        this.f60276g = new HashSet();
        this.f60279j = new HashSet();
        this.f60287r = new FlutterRenderer.ViewportMetrics();
        this.f60288s = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView2.this.m45507a(z, z2);
            }
        };
        this.f60289t = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView2.this.f60277h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterView2.this.f60276g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView2.this.f60277h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterView2.this.f60276g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.f60290u = new Consumer<WindowLayoutInfo>() {
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView2.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        this.f60272c = flutterSurfaceView;
        this.f60271a = flutterSurfaceView;
        m45510b();
    }

    private FlutterView2(Context context, AttributeSet attributeSet, FlutterTextureView flutterTextureView) {
        super(context, attributeSet);
        this.f60276g = new HashSet();
        this.f60279j = new HashSet();
        this.f60287r = new FlutterRenderer.ViewportMetrics();
        this.f60288s = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView2.this.m45507a(z, z2);
            }
        };
        this.f60289t = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView2.this.f60277h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterView2.this.f60276g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView2.this.f60277h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterView2.this.f60276g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.f60290u = new Consumer<WindowLayoutInfo>() {
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView2.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        this.f60273d = flutterTextureView;
        this.f60271a = flutterTextureView;
        m45510b();
    }

    private FlutterView2(Context context, AttributeSet attributeSet, FlutterImageView flutterImageView) {
        super(context, attributeSet);
        this.f60276g = new HashSet();
        this.f60279j = new HashSet();
        this.f60287r = new FlutterRenderer.ViewportMetrics();
        this.f60288s = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView2.this.m45507a(z, z2);
            }
        };
        this.f60289t = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView2.this.f60277h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterView2.this.f60276g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView2.this.f60277h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterView2.this.f60276g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.f60290u = new Consumer<WindowLayoutInfo>() {
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView2.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        this.f60274e = flutterImageView;
        this.f60271a = flutterImageView;
        m45510b();
    }

    /* renamed from: b */
    private void m45510b() {
        Log.m45259v(f60270b, "Initializing FlutterView");
        if (this.f60272c != null) {
            Log.m45259v(f60270b, "Internally using a FlutterSurfaceView.");
            addView(this.f60272c);
        } else if (this.f60273d != null) {
            Log.m45259v(f60270b, "Internally using a FlutterTextureView.");
            addView(this.f60273d);
        } else {
            Log.m45259v(f60270b, "Internally using a FlutterImageView.");
            addView(this.f60274e);
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(4);
        }
    }

    public boolean hasRenderedFirstFrame() {
        return this.f60277h;
    }

    public void addOnFirstFrameRenderedListener(FlutterUiDisplayListener flutterUiDisplayListener) {
        this.f60276g.add(flutterUiDisplayListener);
    }

    public void removeOnFirstFrameRenderedListener(FlutterUiDisplayListener flutterUiDisplayListener) {
        this.f60276g.remove(flutterUiDisplayListener);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f60278i != null) {
            Log.m45259v(f60270b, "Configuration changed. Sending locales and user settings to Flutter.");
            this.f60282m.sendLocalesToFlutter(configuration);
            mo182022a();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Log.m45259v(f60270b, "Size changed. Sending Flutter new viewport metrics. FlutterView was " + i3 + " x " + i4 + ", it is now " + i + " x " + i2);
        this.f60287r.width = i;
        this.f60287r.height = i2;
        m45512d();
    }

    /* access modifiers changed from: protected */
    public WindowInfoRepositoryCallbackAdapterWrapper createWindowInfoRepo() {
        try {
            return new WindowInfoRepositoryCallbackAdapterWrapper(new WindowInfoTrackerCallbackAdapter(WindowInfoTracker.Companion.getOrCreate(getContext())));
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f60286q = createWindowInfoRepo();
        Activity activity = ViewUtils.getActivity(getContext());
        WindowInfoRepositoryCallbackAdapterWrapper windowInfoRepositoryCallbackAdapterWrapper = this.f60286q;
        if (windowInfoRepositoryCallbackAdapterWrapper != null && activity != null) {
            windowInfoRepositoryCallbackAdapterWrapper.addWindowLayoutInfoListener(activity, ContextCompat.getMainExecutor(getContext()), this.f60290u);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        WindowInfoRepositoryCallbackAdapterWrapper windowInfoRepositoryCallbackAdapterWrapper = this.f60286q;
        if (windowInfoRepositoryCallbackAdapterWrapper != null) {
            windowInfoRepositoryCallbackAdapterWrapper.removeWindowLayoutInfoListener(this.f60290u);
        }
        this.f60286q = null;
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void setWindowInfoListenerDisplayFeatures(WindowLayoutInfo windowLayoutInfo) {
        WindowInsets rootWindowInsets;
        DisplayCutout displayCutout;
        FlutterRenderer.DisplayFeatureType displayFeatureType;
        FlutterRenderer.DisplayFeatureState displayFeatureState;
        List<DisplayFeature> displayFeatures = windowLayoutInfo.getDisplayFeatures();
        ArrayList arrayList = new ArrayList();
        for (DisplayFeature next : displayFeatures) {
            Log.m45259v(f60270b, "WindowInfoTracker Display Feature reported with bounds = " + next.getBounds().toString() + " and type = " + next.getClass().getSimpleName());
            if (next instanceof FoldingFeature) {
                FoldingFeature foldingFeature = (FoldingFeature) next;
                if (foldingFeature.getOcclusionType() == FoldingFeature.OcclusionType.FULL) {
                    displayFeatureType = FlutterRenderer.DisplayFeatureType.HINGE;
                } else {
                    displayFeatureType = FlutterRenderer.DisplayFeatureType.FOLD;
                }
                if (foldingFeature.getState() == FoldingFeature.State.FLAT) {
                    displayFeatureState = FlutterRenderer.DisplayFeatureState.POSTURE_FLAT;
                } else if (foldingFeature.getState() == FoldingFeature.State.HALF_OPENED) {
                    displayFeatureState = FlutterRenderer.DisplayFeatureState.POSTURE_HALF_OPENED;
                } else {
                    displayFeatureState = FlutterRenderer.DisplayFeatureState.UNKNOWN;
                }
                arrayList.add(new FlutterRenderer.DisplayFeature(next.getBounds(), displayFeatureType, displayFeatureState));
            } else {
                arrayList.add(new FlutterRenderer.DisplayFeature(next.getBounds(), FlutterRenderer.DisplayFeatureType.UNKNOWN, FlutterRenderer.DisplayFeatureState.UNKNOWN));
            }
        }
        if (!(Build.VERSION.SDK_INT < 28 || (rootWindowInsets = getRootWindowInsets()) == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null)) {
            for (Rect next2 : displayCutout.getBoundingRects()) {
                Log.m45259v(f60270b, "DisplayCutout area reported with bounds = " + next2.toString());
                arrayList.add(new FlutterRenderer.DisplayFeature(next2, FlutterRenderer.DisplayFeatureType.CUTOUT));
            }
        }
        this.f60287r.displayFeatures = arrayList;
        m45512d();
    }

    /* renamed from: c */
    private ZeroSides m45511c() {
        Context context = getContext();
        int i = context.getResources().getConfiguration().orientation;
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (i == 2) {
            if (rotation == 1) {
                return ZeroSides.RIGHT;
            }
            if (rotation == 3) {
                return Build.VERSION.SDK_INT >= 23 ? ZeroSides.LEFT : ZeroSides.RIGHT;
            }
            if (rotation == 0 || rotation == 2) {
                return ZeroSides.BOTH;
            }
        }
        return ZeroSides.NONE;
    }

    /* renamed from: a */
    private int m45503a(WindowInsets windowInsets) {
        if (((double) windowInsets.getSystemWindowInsetBottom()) < ((double) getRootView().getHeight()) * 0.18d) {
            return 0;
        }
        return windowInsets.getSystemWindowInsetBottom();
    }

    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        if (Build.VERSION.SDK_INT == 29) {
            Insets systemGestureInsets = windowInsets.getSystemGestureInsets();
            this.f60287r.systemGestureInsetTop = systemGestureInsets.top;
            this.f60287r.systemGestureInsetRight = systemGestureInsets.right;
            this.f60287r.systemGestureInsetBottom = systemGestureInsets.bottom;
            this.f60287r.systemGestureInsetLeft = systemGestureInsets.left;
        }
        boolean z = true;
        int i = 0;
        boolean z2 = (getWindowSystemUiVisibility() & 4) == 0;
        if ((getWindowSystemUiVisibility() & 2) != 0) {
            z = false;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            if (z) {
                i = 0 | WindowInsets.Type.navigationBars();
            }
            if (z2) {
                i |= WindowInsets.Type.statusBars();
            }
            Insets insets = windowInsets.getInsets(i);
            this.f60287r.viewPaddingTop = insets.top;
            this.f60287r.viewPaddingRight = insets.right;
            this.f60287r.viewPaddingBottom = insets.bottom;
            this.f60287r.viewPaddingLeft = insets.left;
            Insets insets2 = windowInsets.getInsets(WindowInsets.Type.ime());
            this.f60287r.viewInsetTop = insets2.top;
            this.f60287r.viewInsetRight = insets2.right;
            this.f60287r.viewInsetBottom = insets2.bottom;
            this.f60287r.viewInsetLeft = insets2.left;
            Insets insets3 = windowInsets.getInsets(WindowInsets.Type.systemGestures());
            this.f60287r.systemGestureInsetTop = insets3.top;
            this.f60287r.systemGestureInsetRight = insets3.right;
            this.f60287r.systemGestureInsetBottom = insets3.bottom;
            this.f60287r.systemGestureInsetLeft = insets3.left;
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                Insets waterfallInsets = displayCutout.getWaterfallInsets();
                FlutterRenderer.ViewportMetrics viewportMetrics = this.f60287r;
                viewportMetrics.viewPaddingTop = Math.max(Math.max(viewportMetrics.viewPaddingTop, waterfallInsets.top), displayCutout.getSafeInsetTop());
                FlutterRenderer.ViewportMetrics viewportMetrics2 = this.f60287r;
                viewportMetrics2.viewPaddingRight = Math.max(Math.max(viewportMetrics2.viewPaddingRight, waterfallInsets.right), displayCutout.getSafeInsetRight());
                FlutterRenderer.ViewportMetrics viewportMetrics3 = this.f60287r;
                viewportMetrics3.viewPaddingBottom = Math.max(Math.max(viewportMetrics3.viewPaddingBottom, waterfallInsets.bottom), displayCutout.getSafeInsetBottom());
                FlutterRenderer.ViewportMetrics viewportMetrics4 = this.f60287r;
                viewportMetrics4.viewPaddingLeft = Math.max(Math.max(viewportMetrics4.viewPaddingLeft, waterfallInsets.left), displayCutout.getSafeInsetLeft());
            }
        } else {
            ZeroSides zeroSides = ZeroSides.NONE;
            if (!z) {
                zeroSides = m45511c();
            }
            this.f60287r.viewPaddingTop = z2 ? windowInsets.getSystemWindowInsetTop() : 0;
            this.f60287r.viewPaddingRight = (zeroSides == ZeroSides.RIGHT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetRight();
            this.f60287r.viewPaddingBottom = (!z || m45503a(windowInsets) != 0) ? 0 : windowInsets.getSystemWindowInsetBottom();
            this.f60287r.viewPaddingLeft = (zeroSides == ZeroSides.LEFT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetLeft();
            this.f60287r.viewInsetTop = 0;
            this.f60287r.viewInsetRight = 0;
            this.f60287r.viewInsetBottom = m45503a(windowInsets);
            this.f60287r.viewInsetLeft = 0;
        }
        Log.m45259v(f60270b, "Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: " + this.f60287r.viewPaddingTop + ", Left: " + this.f60287r.viewPaddingLeft + ", Right: " + this.f60287r.viewPaddingRight + "\nKeyboard insets: Bottom: " + this.f60287r.viewInsetBottom + ", Left: " + this.f60287r.viewInsetLeft + ", Right: " + this.f60287r.viewInsetRight + "System Gesture Insets - Left: " + this.f60287r.systemGestureInsetLeft + ", Top: " + this.f60287r.systemGestureInsetTop + ", Right: " + this.f60287r.systemGestureInsetRight + ", Bottom: " + this.f60287r.viewInsetBottom);
        m45512d();
        return onApplyWindowInsets;
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT > 19) {
            return super.fitSystemWindows(rect);
        }
        this.f60287r.viewPaddingTop = rect.top;
        this.f60287r.viewPaddingRight = rect.right;
        this.f60287r.viewPaddingBottom = 0;
        this.f60287r.viewPaddingLeft = rect.left;
        this.f60287r.viewInsetTop = 0;
        this.f60287r.viewInsetRight = 0;
        this.f60287r.viewInsetBottom = rect.bottom;
        this.f60287r.viewInsetLeft = 0;
        Log.m45259v(f60270b, "Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: " + this.f60287r.viewPaddingTop + ", Left: " + this.f60287r.viewPaddingLeft + ", Right: " + this.f60287r.viewPaddingRight + "\nKeyboard insets: Bottom: " + this.f60287r.viewInsetBottom + ", Left: " + this.f60287r.viewInsetLeft + ", Right: " + this.f60287r.viewInsetRight);
        m45512d();
        return true;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        if (!isAttachedToFlutterEngine()) {
            return super.onCreateInputConnection(editorInfo);
        }
        return this.f60281l.createInputConnection(this, this.f60283n, editorInfo);
    }

    public boolean checkInputConnectionProxy(View view) {
        FlutterEngine flutterEngine = this.f60278i;
        if (flutterEngine != null) {
            return flutterEngine.getPlatformViewsController().checkInputConnectionProxy(view);
        }
        return super.checkInputConnectionProxy(view);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            getKeyDispatcherState().startTracking(keyEvent, this);
        } else if (keyEvent.getAction() == 1) {
            getKeyDispatcherState().handleUpEvent(keyEvent);
        }
        if ((!isAttachedToFlutterEngine() || !this.f60283n.handleEvent(keyEvent)) && !super.dispatchKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isAttachedToFlutterEngine()) {
            return super.onTouchEvent(motionEvent);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            requestUnbufferedDispatch(motionEvent);
        }
        return this.f60284o.onTouchEvent(motionEvent);
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (isAttachedToFlutterEngine() && this.f60284o.onGenericMotionEvent(motionEvent)) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (!isAttachedToFlutterEngine()) {
            return super.onHoverEvent(motionEvent);
        }
        return this.f60285p.onAccessibilityHoverEvent(motionEvent);
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        AccessibilityBridge accessibilityBridge = this.f60285p;
        if (accessibilityBridge == null || !accessibilityBridge.isAccessibilityEnabled()) {
            return null;
        }
        return this.f60285p;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View findViewByAccessibilityIdTraversal(int r8) {
        /*
            r7 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 >= r1) goto L_0x000b
            android.view.View r8 = r7.m45504a((int) r8, (android.view.View) r7)
            return r8
        L_0x000b:
            r0 = 0
            java.lang.Class<android.view.View> r1 = android.view.View.class
            java.lang.String r2 = "findViewByAccessibilityIdTraversal"
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{  }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{  }
            r6 = 0
            r4[r6] = r5     // Catch:{  }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r2, r4)     // Catch:{  }
            r1.setAccessible(r3)
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ NoSuchMethodException -> 0x002e }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ NoSuchMethodException -> 0x002e }
            r2[r6] = r8     // Catch:{ NoSuchMethodException -> 0x002e }
            java.lang.Object r8 = r1.invoke(r7, r2)     // Catch:{ NoSuchMethodException -> 0x002e }
            android.view.View r8 = (android.view.View) r8     // Catch:{ NoSuchMethodException -> 0x002e }
            return r8
        L_0x002e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p218io.flutter.embedding.android.FlutterView2.findViewByAccessibilityIdTraversal(int):android.view.View");
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View m45504a(int r6, android.view.View r7) {
        /*
            r5 = this;
            r0 = 0
            java.lang.Class<android.view.View> r1 = android.view.View.class
            java.lang.String r2 = "getAccessibilityViewId"
            r3 = 0
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{  }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r2, r4)     // Catch:{  }
            r2 = 1
            r1.setAccessible(r2)
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ NoSuchMethodException -> 0x003c }
            java.lang.Object r1 = r1.invoke(r7, r2)     // Catch:{ NoSuchMethodException -> 0x003c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch:{ NoSuchMethodException -> 0x003c }
            boolean r1 = r1.equals(r2)     // Catch:{ NoSuchMethodException -> 0x003c }
            if (r1 == 0) goto L_0x0021
            return r7
        L_0x0021:
            boolean r1 = r7 instanceof android.view.ViewGroup
            if (r1 == 0) goto L_0x003c
        L_0x0025:
            r1 = r7
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            int r2 = r1.getChildCount()
            if (r3 >= r2) goto L_0x003c
            android.view.View r1 = r1.getChildAt(r3)
            android.view.View r1 = r5.m45504a((int) r6, (android.view.View) r1)
            if (r1 == 0) goto L_0x0039
            return r1
        L_0x0039:
            int r3 = r3 + 1
            goto L_0x0025
        L_0x003c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p218io.flutter.embedding.android.FlutterView2.m45504a(int, android.view.View):android.view.View");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m45507a(boolean z, boolean z2) {
        boolean z3 = false;
        if (!this.f60278i.getRenderer().isSoftwareRenderingEnabled()) {
            if (!z && !z2) {
                z3 = true;
            }
            setWillNotDraw(z3);
            return;
        }
        setWillNotDraw(false);
    }

    public PointerIcon getSystemPointerIcon(int i) {
        return PointerIcon.getSystemIcon(getContext(), i);
    }

    public void attachToFlutterEngine(FlutterEngine flutterEngine) {
        Log.m45259v(f60270b, "Attaching to a FlutterEngine: " + flutterEngine);
        if (isAttachedToFlutterEngine()) {
            if (flutterEngine == this.f60278i) {
                Log.m45259v(f60270b, "Already attached to this engine. Doing nothing.");
                return;
            } else {
                Log.m45259v(f60270b, "Currently attached to a different engine. Detaching and then attaching to new engine.");
                detachFromFlutterEngine();
            }
        }
        this.f60278i = flutterEngine;
        FlutterRenderer renderer = flutterEngine.getRenderer();
        this.f60277h = renderer.isDisplayingFlutterUi();
        this.f60271a.attachToRenderer(renderer);
        renderer.addIsDisplayingFlutterUiListener(this.f60289t);
        if (Build.VERSION.SDK_INT >= 24) {
            this.f60280k = new MouseCursorPlugin(this, this.f60278i.getMouseCursorChannel());
        }
        this.f60281l = new TextInputPlugin(this, this.f60278i.getTextInputChannel(), this.f60278i.getPlatformViewsController());
        this.f60282m = this.f60278i.getLocalizationPlugin();
        this.f60283n = new KeyboardManager(this, this.f60281l, new KeyChannelResponder[]{new KeyChannelResponder(flutterEngine.getKeyEventChannel())});
        this.f60284o = new AndroidTouchProcessor(this.f60278i.getRenderer(), false);
        AccessibilityBridge accessibilityBridge = new AccessibilityBridge(this, flutterEngine.getAccessibilityChannel(), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.f60278i.getPlatformViewsController());
        this.f60285p = accessibilityBridge;
        accessibilityBridge.setOnAccessibilityChangeListener(this.f60288s);
        m45507a(this.f60285p.isAccessibilityEnabled(), this.f60285p.isTouchExplorationEnabled());
        this.f60278i.getPlatformViewsController().attachAccessibilityBridge(this.f60285p);
        this.f60278i.getPlatformViewsController().attachToFlutterRenderer(this.f60278i.getRenderer());
        this.f60281l.getInputMethodManager().restartInput(this);
        mo182022a();
        this.f60282m.sendLocalesToFlutter(getResources().getConfiguration());
        m45512d();
        for (FlutterEngineAttachmentListener onFlutterEngineAttachedToFlutterView : this.f60279j) {
            onFlutterEngineAttachedToFlutterView.onFlutterEngineAttachedToFlutterView(flutterEngine);
        }
        if (this.f60277h) {
            this.f60289t.onFlutterUiDisplayed();
        }
    }

    public void detachFromFlutterEngine() {
        Log.m45259v(f60270b, "Detaching from a FlutterEngine: " + this.f60278i);
        if (!isAttachedToFlutterEngine()) {
            Log.m45259v(f60270b, "FlutterView not attached to an engine. Not detaching.");
            return;
        }
        for (FlutterEngineAttachmentListener onFlutterEngineDetachedFromFlutterView : this.f60279j) {
            onFlutterEngineDetachedFromFlutterView.onFlutterEngineDetachedFromFlutterView();
        }
        this.f60278i.getPlatformViewsController().detachFromView();
        this.f60278i.getPlatformViewsController().detachAccessibilityBridge();
        this.f60285p.release();
        this.f60285p = null;
        this.f60281l.getInputMethodManager().restartInput(this);
        this.f60281l.destroy();
        this.f60283n.destroy();
        if (this.f60280k != null && Build.VERSION.SDK_INT >= 24) {
            this.f60280k.destroy();
        }
        FlutterRenderer renderer = this.f60278i.getRenderer();
        this.f60277h = false;
        renderer.removeIsDisplayingFlutterUiListener(this.f60289t);
        renderer.stopRenderingToSurface();
        renderer.setSemanticsEnabled(false);
        RenderSurface renderSurface = this.f60275f;
        if (renderSurface != null && this.f60271a == this.f60274e) {
            this.f60271a = renderSurface;
        }
        this.f60271a.detachFromRenderer();
        FlutterImageView flutterImageView = this.f60274e;
        if (flutterImageView != null) {
            flutterImageView.closeImageReader();
            this.f60274e = null;
        }
        this.f60275f = null;
        this.f60278i = null;
    }

    public FlutterImageView createImageView() {
        return new FlutterImageView(getContext(), getWidth(), getHeight(), FlutterImageView.SurfaceKind.background);
    }

    public void convertToImageView() {
        this.f60271a.pause();
        FlutterImageView flutterImageView = this.f60274e;
        if (flutterImageView == null) {
            FlutterImageView createImageView = createImageView();
            this.f60274e = createImageView;
            addView(createImageView);
        } else {
            flutterImageView.resizeIfNeeded(getWidth(), getHeight());
        }
        this.f60275f = this.f60271a;
        FlutterImageView flutterImageView2 = this.f60274e;
        this.f60271a = flutterImageView2;
        FlutterEngine flutterEngine = this.f60278i;
        if (flutterEngine != null) {
            flutterImageView2.attachToRenderer(flutterEngine.getRenderer());
        }
    }

    public void revertImageView(final Runnable runnable) {
        FlutterImageView flutterImageView = this.f60274e;
        if (flutterImageView == null) {
            Log.m45259v(f60270b, "Tried to revert the image view, but no image view is used.");
            return;
        }
        RenderSurface renderSurface = this.f60275f;
        if (renderSurface == null) {
            Log.m45259v(f60270b, "Tried to revert the image view, but no previous surface was used.");
            return;
        }
        this.f60271a = renderSurface;
        this.f60275f = null;
        FlutterEngine flutterEngine = this.f60278i;
        if (flutterEngine == null) {
            flutterImageView.detachFromRenderer();
            runnable.run();
            return;
        }
        final FlutterRenderer renderer = flutterEngine.getRenderer();
        if (renderer == null) {
            this.f60274e.detachFromRenderer();
            runnable.run();
            return;
        }
        this.f60271a.attachToRenderer(renderer);
        renderer.addIsDisplayingFlutterUiListener(new FlutterUiDisplayListener() {
            public void onFlutterUiNoLongerDisplayed() {
            }

            public void onFlutterUiDisplayed() {
                renderer.removeIsDisplayingFlutterUiListener(this);
                runnable.run();
                if (!(FlutterView2.this.f60271a instanceof FlutterImageView)) {
                    FlutterView2.this.f60274e.detachFromRenderer();
                }
            }
        });
    }

    public void attachOverlaySurfaceToRender(FlutterImageView flutterImageView) {
        FlutterEngine flutterEngine = this.f60278i;
        if (flutterEngine != null) {
            flutterImageView.attachToRenderer(flutterEngine.getRenderer());
        }
    }

    public boolean acquireLatestImageViewFrame() {
        FlutterImageView flutterImageView = this.f60274e;
        if (flutterImageView != null) {
            return flutterImageView.acquireLatestImage();
        }
        return false;
    }

    public boolean isAttachedToFlutterEngine() {
        FlutterEngine flutterEngine = this.f60278i;
        return flutterEngine != null && flutterEngine.getRenderer() == this.f60271a.getAttachedRenderer();
    }

    public FlutterEngine getAttachedFlutterEngine() {
        return this.f60278i;
    }

    public void addFlutterEngineAttachmentListener(FlutterEngineAttachmentListener flutterEngineAttachmentListener) {
        this.f60279j.add(flutterEngineAttachmentListener);
    }

    public void removeFlutterEngineAttachmentListener(FlutterEngineAttachmentListener flutterEngineAttachmentListener) {
        this.f60279j.remove(flutterEngineAttachmentListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo182022a() {
        SettingsChannel.PlatformBrightness platformBrightness;
        if ((getResources().getConfiguration().uiMode & 48) == 32) {
            platformBrightness = SettingsChannel.PlatformBrightness.dark;
        } else {
            platformBrightness = SettingsChannel.PlatformBrightness.light;
        }
        this.f60278i.getSettingsChannel().startMessage().setTextScaleFactor(getResources().getConfiguration().fontScale).setUse24HourFormat(DateFormat.is24HourFormat(getContext())).setPlatformBrightness(platformBrightness).send();
    }

    /* renamed from: d */
    private void m45512d() {
        if (!isAttachedToFlutterEngine()) {
            Log.m45261w(f60270b, "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
            return;
        }
        this.f60287r.devicePixelRatio = getResources().getDisplayMetrics().density;
        this.f60287r.physicalTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f60278i.getRenderer().setViewportMetrics(this.f60287r);
    }

    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i) {
        super.onProvideAutofillVirtualStructure(viewStructure, i);
        this.f60281l.onProvideAutofillVirtualStructure(viewStructure, i);
    }

    public void autofill(SparseArray<AutofillValue> sparseArray) {
        this.f60281l.autofill(sparseArray);
    }

    public void attachToRenderer() {
        RenderSurface renderSurface = this.f60271a;
        if ((renderSurface != null && renderSurface.getAttachedRenderer() == null) || !this.f60271a.getAttachedRenderer().isDisplayingFlutterUi()) {
            this.f60271a.attachToRenderer(this.f60278i.getRenderer());
        }
    }

    public void detachFromRenderer() {
        this.f60271a.detachFromRenderer();
    }
}
