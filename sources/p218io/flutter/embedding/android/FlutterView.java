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

/* renamed from: io.flutter.embedding.android.FlutterView */
public class FlutterView extends FrameLayout implements MouseCursorPlugin.MouseCursorViewDelegate {

    /* renamed from: b */
    private static final String f60249b = "FlutterView";

    /* renamed from: a */
    RenderSurface f60250a;

    /* renamed from: c */
    private FlutterSurfaceView f60251c;

    /* renamed from: d */
    private FlutterTextureView f60252d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public FlutterImageView f60253e;

    /* renamed from: f */
    private RenderSurface f60254f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Set<FlutterUiDisplayListener> f60255g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f60256h;

    /* renamed from: i */
    private FlutterEngine f60257i;

    /* renamed from: j */
    private final Set<FlutterEngineAttachmentListener> f60258j;

    /* renamed from: k */
    private MouseCursorPlugin f60259k;

    /* renamed from: l */
    private TextInputPlugin f60260l;

    /* renamed from: m */
    private LocalizationPlugin f60261m;

    /* renamed from: n */
    private KeyboardManager f60262n;

    /* renamed from: o */
    private AndroidTouchProcessor f60263o;

    /* renamed from: p */
    private AccessibilityBridge f60264p;

    /* renamed from: q */
    private WindowInfoRepositoryCallbackAdapterWrapper f60265q;

    /* renamed from: r */
    private final FlutterRenderer.ViewportMetrics f60266r;

    /* renamed from: s */
    private final AccessibilityBridge.OnAccessibilityChangeListener f60267s;

    /* renamed from: t */
    private final FlutterUiDisplayListener f60268t;

    /* renamed from: u */
    private final Consumer<WindowLayoutInfo> f60269u;

    /* renamed from: io.flutter.embedding.android.FlutterView$FlutterEngineAttachmentListener */
    public interface FlutterEngineAttachmentListener {
        void onFlutterEngineAttachedToFlutterView(FlutterEngine flutterEngine);

        void onFlutterEngineDetachedFromFlutterView();
    }

    /* renamed from: io.flutter.embedding.android.FlutterView$ZeroSides */
    private enum ZeroSides {
        NONE,
        LEFT,
        RIGHT,
        BOTH
    }

    public FlutterView(Context context) {
        this(context, (AttributeSet) null, new FlutterSurfaceView(context));
    }

    @Deprecated
    public FlutterView(Context context, RenderMode renderMode) {
        super(context, (AttributeSet) null);
        this.f60255g = new HashSet();
        this.f60258j = new HashSet();
        this.f60266r = new FlutterRenderer.ViewportMetrics();
        this.f60267s = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView.this.m45496a(z, z2);
            }
        };
        this.f60268t = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView.this.f60256h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterView.this.f60255g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView.this.f60256h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterView.this.f60255g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.f60269u = new Consumer<WindowLayoutInfo>() {
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        if (renderMode == RenderMode.surface) {
            FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(context);
            this.f60251c = flutterSurfaceView;
            this.f60250a = flutterSurfaceView;
        } else if (renderMode == RenderMode.texture) {
            FlutterTextureView flutterTextureView = new FlutterTextureView(context);
            this.f60252d = flutterTextureView;
            this.f60250a = flutterTextureView;
        } else {
            throw new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", new Object[]{renderMode}));
        }
        m45499b();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public FlutterView(Context context, TransparencyMode transparencyMode) {
        this(context, (AttributeSet) null, new FlutterSurfaceView(context, transparencyMode == TransparencyMode.transparent));
    }

    public FlutterView(Context context, FlutterSurfaceView flutterSurfaceView) {
        this(context, (AttributeSet) null, flutterSurfaceView);
    }

    public FlutterView(Context context, FlutterTextureView flutterTextureView) {
        this(context, (AttributeSet) null, flutterTextureView);
    }

    public FlutterView(Context context, FlutterImageView flutterImageView) {
        this(context, (AttributeSet) null, flutterImageView);
    }

    public FlutterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, new FlutterSurfaceView(context));
    }

    @Deprecated
    public FlutterView(Context context, RenderMode renderMode, TransparencyMode transparencyMode) {
        super(context, (AttributeSet) null);
        this.f60255g = new HashSet();
        this.f60258j = new HashSet();
        this.f60266r = new FlutterRenderer.ViewportMetrics();
        this.f60267s = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView.this.m45496a(z, z2);
            }
        };
        this.f60268t = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView.this.f60256h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterView.this.f60255g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView.this.f60256h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterView.this.f60255g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.f60269u = new Consumer<WindowLayoutInfo>() {
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        boolean z = false;
        if (renderMode == RenderMode.surface) {
            FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(context, transparencyMode == TransparencyMode.transparent ? true : z);
            this.f60251c = flutterSurfaceView;
            this.f60250a = flutterSurfaceView;
        } else if (renderMode == RenderMode.texture) {
            FlutterTextureView flutterTextureView = new FlutterTextureView(context);
            this.f60252d = flutterTextureView;
            this.f60250a = flutterTextureView;
        } else {
            throw new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", new Object[]{renderMode}));
        }
        m45499b();
    }

    private FlutterView(Context context, AttributeSet attributeSet, FlutterSurfaceView flutterSurfaceView) {
        super(context, attributeSet);
        this.f60255g = new HashSet();
        this.f60258j = new HashSet();
        this.f60266r = new FlutterRenderer.ViewportMetrics();
        this.f60267s = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView.this.m45496a(z, z2);
            }
        };
        this.f60268t = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView.this.f60256h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterView.this.f60255g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView.this.f60256h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterView.this.f60255g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.f60269u = new Consumer<WindowLayoutInfo>() {
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        this.f60251c = flutterSurfaceView;
        this.f60250a = flutterSurfaceView;
        m45499b();
    }

    private FlutterView(Context context, AttributeSet attributeSet, FlutterTextureView flutterTextureView) {
        super(context, attributeSet);
        this.f60255g = new HashSet();
        this.f60258j = new HashSet();
        this.f60266r = new FlutterRenderer.ViewportMetrics();
        this.f60267s = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView.this.m45496a(z, z2);
            }
        };
        this.f60268t = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView.this.f60256h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterView.this.f60255g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView.this.f60256h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterView.this.f60255g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.f60269u = new Consumer<WindowLayoutInfo>() {
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        this.f60252d = flutterTextureView;
        this.f60250a = flutterTextureView;
        m45499b();
    }

    private FlutterView(Context context, AttributeSet attributeSet, FlutterImageView flutterImageView) {
        super(context, attributeSet);
        this.f60255g = new HashSet();
        this.f60258j = new HashSet();
        this.f60266r = new FlutterRenderer.ViewportMetrics();
        this.f60267s = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView.this.m45496a(z, z2);
            }
        };
        this.f60268t = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView.this.f60256h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterView.this.f60255g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView.this.f60256h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterView.this.f60255g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.f60269u = new Consumer<WindowLayoutInfo>() {
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        this.f60253e = flutterImageView;
        this.f60250a = flutterImageView;
        m45499b();
    }

    /* renamed from: b */
    private void m45499b() {
        Log.m45259v(f60249b, "Initializing FlutterView");
        if (this.f60251c != null) {
            Log.m45259v(f60249b, "Internally using a FlutterSurfaceView.");
            addView(this.f60251c);
        } else if (this.f60252d != null) {
            Log.m45259v(f60249b, "Internally using a FlutterTextureView.");
            addView(this.f60252d);
        } else {
            Log.m45259v(f60249b, "Internally using a FlutterImageView.");
            addView(this.f60253e);
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(4);
        }
    }

    public boolean hasRenderedFirstFrame() {
        return this.f60256h;
    }

    public void addOnFirstFrameRenderedListener(FlutterUiDisplayListener flutterUiDisplayListener) {
        this.f60255g.add(flutterUiDisplayListener);
    }

    public void removeOnFirstFrameRenderedListener(FlutterUiDisplayListener flutterUiDisplayListener) {
        this.f60255g.remove(flutterUiDisplayListener);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f60257i != null) {
            Log.m45259v(f60249b, "Configuration changed. Sending locales and user settings to Flutter.");
            this.f60261m.sendLocalesToFlutter(configuration);
            mo181986a();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Log.m45259v(f60249b, "Size changed. Sending Flutter new viewport metrics. FlutterView was " + i3 + " x " + i4 + ", it is now " + i + " x " + i2);
        this.f60266r.width = i;
        this.f60266r.height = i2;
        m45501d();
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
        this.f60265q = createWindowInfoRepo();
        Activity activity = ViewUtils.getActivity(getContext());
        WindowInfoRepositoryCallbackAdapterWrapper windowInfoRepositoryCallbackAdapterWrapper = this.f60265q;
        if (windowInfoRepositoryCallbackAdapterWrapper != null && activity != null) {
            windowInfoRepositoryCallbackAdapterWrapper.addWindowLayoutInfoListener(activity, ContextCompat.getMainExecutor(getContext()), this.f60269u);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        WindowInfoRepositoryCallbackAdapterWrapper windowInfoRepositoryCallbackAdapterWrapper = this.f60265q;
        if (windowInfoRepositoryCallbackAdapterWrapper != null) {
            windowInfoRepositoryCallbackAdapterWrapper.removeWindowLayoutInfoListener(this.f60269u);
        }
        this.f60265q = null;
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
            Log.m45259v(f60249b, "WindowInfoTracker Display Feature reported with bounds = " + next.getBounds().toString() + " and type = " + next.getClass().getSimpleName());
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
                Log.m45259v(f60249b, "DisplayCutout area reported with bounds = " + next2.toString());
                arrayList.add(new FlutterRenderer.DisplayFeature(next2, FlutterRenderer.DisplayFeatureType.CUTOUT));
            }
        }
        this.f60266r.displayFeatures = arrayList;
        m45501d();
    }

    /* renamed from: c */
    private ZeroSides m45500c() {
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
    private int m45492a(WindowInsets windowInsets) {
        if (((double) windowInsets.getSystemWindowInsetBottom()) < ((double) getRootView().getHeight()) * 0.18d) {
            return 0;
        }
        return windowInsets.getSystemWindowInsetBottom();
    }

    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        if (Build.VERSION.SDK_INT == 29) {
            Insets systemGestureInsets = windowInsets.getSystemGestureInsets();
            this.f60266r.systemGestureInsetTop = systemGestureInsets.top;
            this.f60266r.systemGestureInsetRight = systemGestureInsets.right;
            this.f60266r.systemGestureInsetBottom = systemGestureInsets.bottom;
            this.f60266r.systemGestureInsetLeft = systemGestureInsets.left;
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
            this.f60266r.viewPaddingTop = insets.top;
            this.f60266r.viewPaddingRight = insets.right;
            this.f60266r.viewPaddingBottom = insets.bottom;
            this.f60266r.viewPaddingLeft = insets.left;
            Insets insets2 = windowInsets.getInsets(WindowInsets.Type.ime());
            this.f60266r.viewInsetTop = insets2.top;
            this.f60266r.viewInsetRight = insets2.right;
            this.f60266r.viewInsetBottom = insets2.bottom;
            this.f60266r.viewInsetLeft = insets2.left;
            Insets insets3 = windowInsets.getInsets(WindowInsets.Type.systemGestures());
            this.f60266r.systemGestureInsetTop = insets3.top;
            this.f60266r.systemGestureInsetRight = insets3.right;
            this.f60266r.systemGestureInsetBottom = insets3.bottom;
            this.f60266r.systemGestureInsetLeft = insets3.left;
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                Insets waterfallInsets = displayCutout.getWaterfallInsets();
                FlutterRenderer.ViewportMetrics viewportMetrics = this.f60266r;
                viewportMetrics.viewPaddingTop = Math.max(Math.max(viewportMetrics.viewPaddingTop, waterfallInsets.top), displayCutout.getSafeInsetTop());
                FlutterRenderer.ViewportMetrics viewportMetrics2 = this.f60266r;
                viewportMetrics2.viewPaddingRight = Math.max(Math.max(viewportMetrics2.viewPaddingRight, waterfallInsets.right), displayCutout.getSafeInsetRight());
                FlutterRenderer.ViewportMetrics viewportMetrics3 = this.f60266r;
                viewportMetrics3.viewPaddingBottom = Math.max(Math.max(viewportMetrics3.viewPaddingBottom, waterfallInsets.bottom), displayCutout.getSafeInsetBottom());
                FlutterRenderer.ViewportMetrics viewportMetrics4 = this.f60266r;
                viewportMetrics4.viewPaddingLeft = Math.max(Math.max(viewportMetrics4.viewPaddingLeft, waterfallInsets.left), displayCutout.getSafeInsetLeft());
            }
        } else {
            ZeroSides zeroSides = ZeroSides.NONE;
            if (!z) {
                zeroSides = m45500c();
            }
            this.f60266r.viewPaddingTop = z2 ? windowInsets.getSystemWindowInsetTop() : 0;
            this.f60266r.viewPaddingRight = (zeroSides == ZeroSides.RIGHT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetRight();
            this.f60266r.viewPaddingBottom = (!z || m45492a(windowInsets) != 0) ? 0 : windowInsets.getSystemWindowInsetBottom();
            this.f60266r.viewPaddingLeft = (zeroSides == ZeroSides.LEFT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetLeft();
            this.f60266r.viewInsetTop = 0;
            this.f60266r.viewInsetRight = 0;
            this.f60266r.viewInsetBottom = m45492a(windowInsets);
            this.f60266r.viewInsetLeft = 0;
        }
        Log.m45259v(f60249b, "Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: " + this.f60266r.viewPaddingTop + ", Left: " + this.f60266r.viewPaddingLeft + ", Right: " + this.f60266r.viewPaddingRight + "\nKeyboard insets: Bottom: " + this.f60266r.viewInsetBottom + ", Left: " + this.f60266r.viewInsetLeft + ", Right: " + this.f60266r.viewInsetRight + "System Gesture Insets - Left: " + this.f60266r.systemGestureInsetLeft + ", Top: " + this.f60266r.systemGestureInsetTop + ", Right: " + this.f60266r.systemGestureInsetRight + ", Bottom: " + this.f60266r.viewInsetBottom);
        m45501d();
        return onApplyWindowInsets;
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT > 19) {
            return super.fitSystemWindows(rect);
        }
        this.f60266r.viewPaddingTop = rect.top;
        this.f60266r.viewPaddingRight = rect.right;
        this.f60266r.viewPaddingBottom = 0;
        this.f60266r.viewPaddingLeft = rect.left;
        this.f60266r.viewInsetTop = 0;
        this.f60266r.viewInsetRight = 0;
        this.f60266r.viewInsetBottom = rect.bottom;
        this.f60266r.viewInsetLeft = 0;
        Log.m45259v(f60249b, "Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: " + this.f60266r.viewPaddingTop + ", Left: " + this.f60266r.viewPaddingLeft + ", Right: " + this.f60266r.viewPaddingRight + "\nKeyboard insets: Bottom: " + this.f60266r.viewInsetBottom + ", Left: " + this.f60266r.viewInsetLeft + ", Right: " + this.f60266r.viewInsetRight);
        m45501d();
        return true;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        if (!isAttachedToFlutterEngine()) {
            return super.onCreateInputConnection(editorInfo);
        }
        return this.f60260l.createInputConnection(this, this.f60262n, editorInfo);
    }

    public boolean checkInputConnectionProxy(View view) {
        FlutterEngine flutterEngine = this.f60257i;
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
        if ((!isAttachedToFlutterEngine() || !this.f60262n.handleEvent(keyEvent)) && !super.dispatchKeyEvent(keyEvent)) {
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
        return this.f60263o.onTouchEvent(motionEvent);
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (isAttachedToFlutterEngine() && this.f60263o.onGenericMotionEvent(motionEvent)) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (!isAttachedToFlutterEngine()) {
            return super.onHoverEvent(motionEvent);
        }
        return this.f60264p.onAccessibilityHoverEvent(motionEvent);
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        AccessibilityBridge accessibilityBridge = this.f60264p;
        if (accessibilityBridge == null || !accessibilityBridge.isAccessibilityEnabled()) {
            return null;
        }
        return this.f60264p;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View findViewByAccessibilityIdTraversal(int r8) {
        /*
            r7 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 >= r1) goto L_0x000b
            android.view.View r8 = r7.m45493a((int) r8, (android.view.View) r7)
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
        throw new UnsupportedOperationException("Method not decompiled: p218io.flutter.embedding.android.FlutterView.findViewByAccessibilityIdTraversal(int):android.view.View");
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View m45493a(int r6, android.view.View r7) {
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
            android.view.View r1 = r5.m45493a((int) r6, (android.view.View) r1)
            if (r1 == 0) goto L_0x0039
            return r1
        L_0x0039:
            int r3 = r3 + 1
            goto L_0x0025
        L_0x003c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p218io.flutter.embedding.android.FlutterView.m45493a(int, android.view.View):android.view.View");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m45496a(boolean z, boolean z2) {
        boolean z3 = false;
        if (!this.f60257i.getRenderer().isSoftwareRenderingEnabled()) {
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
        Log.m45259v(f60249b, "Attaching to a FlutterEngine: " + flutterEngine);
        if (isAttachedToFlutterEngine()) {
            if (flutterEngine == this.f60257i) {
                Log.m45259v(f60249b, "Already attached to this engine. Doing nothing.");
                return;
            } else {
                Log.m45259v(f60249b, "Currently attached to a different engine. Detaching and then attaching to new engine.");
                detachFromFlutterEngine();
            }
        }
        this.f60257i = flutterEngine;
        FlutterRenderer renderer = flutterEngine.getRenderer();
        this.f60256h = renderer.isDisplayingFlutterUi();
        this.f60250a.attachToRenderer(renderer);
        renderer.addIsDisplayingFlutterUiListener(this.f60268t);
        if (Build.VERSION.SDK_INT >= 24) {
            this.f60259k = new MouseCursorPlugin(this, this.f60257i.getMouseCursorChannel());
        }
        this.f60260l = new TextInputPlugin(this, this.f60257i.getTextInputChannel(), this.f60257i.getPlatformViewsController());
        this.f60261m = this.f60257i.getLocalizationPlugin();
        this.f60262n = new KeyboardManager(this, this.f60260l, new KeyChannelResponder[]{new KeyChannelResponder(flutterEngine.getKeyEventChannel())});
        this.f60263o = new AndroidTouchProcessor(this.f60257i.getRenderer(), false);
        AccessibilityBridge accessibilityBridge = new AccessibilityBridge(this, flutterEngine.getAccessibilityChannel(), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.f60257i.getPlatformViewsController());
        this.f60264p = accessibilityBridge;
        accessibilityBridge.setOnAccessibilityChangeListener(this.f60267s);
        m45496a(this.f60264p.isAccessibilityEnabled(), this.f60264p.isTouchExplorationEnabled());
        this.f60257i.getPlatformViewsController().attachAccessibilityBridge(this.f60264p);
        this.f60257i.getPlatformViewsController().attachToFlutterRenderer(this.f60257i.getRenderer());
        this.f60260l.getInputMethodManager().restartInput(this);
        mo181986a();
        this.f60261m.sendLocalesToFlutter(getResources().getConfiguration());
        m45501d();
        flutterEngine.getPlatformViewsController().attachToView(this);
        for (FlutterEngineAttachmentListener onFlutterEngineAttachedToFlutterView : this.f60258j) {
            onFlutterEngineAttachedToFlutterView.onFlutterEngineAttachedToFlutterView(flutterEngine);
        }
        if (this.f60256h) {
            this.f60268t.onFlutterUiDisplayed();
        }
    }

    public void detachFromFlutterEngine() {
        Log.m45259v(f60249b, "Detaching from a FlutterEngine: " + this.f60257i);
        if (!isAttachedToFlutterEngine()) {
            Log.m45259v(f60249b, "FlutterView not attached to an engine. Not detaching.");
            return;
        }
        for (FlutterEngineAttachmentListener onFlutterEngineDetachedFromFlutterView : this.f60258j) {
            onFlutterEngineDetachedFromFlutterView.onFlutterEngineDetachedFromFlutterView();
        }
        this.f60257i.getPlatformViewsController().detachFromView();
        this.f60257i.getPlatformViewsController().detachAccessibilityBridge();
        this.f60264p.release();
        this.f60264p = null;
        this.f60260l.getInputMethodManager().restartInput(this);
        this.f60260l.destroy();
        this.f60262n.destroy();
        MouseCursorPlugin mouseCursorPlugin = this.f60259k;
        if (mouseCursorPlugin != null) {
            mouseCursorPlugin.destroy();
        }
        FlutterRenderer renderer = this.f60257i.getRenderer();
        this.f60256h = false;
        renderer.removeIsDisplayingFlutterUiListener(this.f60268t);
        renderer.stopRenderingToSurface();
        renderer.setSemanticsEnabled(false);
        RenderSurface renderSurface = this.f60254f;
        if (renderSurface != null && this.f60250a == this.f60253e) {
            this.f60250a = renderSurface;
        }
        this.f60250a.detachFromRenderer();
        FlutterImageView flutterImageView = this.f60253e;
        if (flutterImageView != null) {
            flutterImageView.closeImageReader();
            this.f60253e = null;
        }
        this.f60254f = null;
        this.f60257i = null;
    }

    public FlutterImageView createImageView() {
        return new FlutterImageView(getContext(), getWidth(), getHeight(), FlutterImageView.SurfaceKind.background);
    }

    public void convertToImageView() {
        this.f60250a.pause();
        FlutterImageView flutterImageView = this.f60253e;
        if (flutterImageView == null) {
            FlutterImageView createImageView = createImageView();
            this.f60253e = createImageView;
            addView(createImageView);
        } else {
            flutterImageView.resizeIfNeeded(getWidth(), getHeight());
        }
        this.f60254f = this.f60250a;
        FlutterImageView flutterImageView2 = this.f60253e;
        this.f60250a = flutterImageView2;
        FlutterEngine flutterEngine = this.f60257i;
        if (flutterEngine != null) {
            flutterImageView2.attachToRenderer(flutterEngine.getRenderer());
        }
    }

    public void revertImageView(final Runnable runnable) {
        FlutterImageView flutterImageView = this.f60253e;
        if (flutterImageView == null) {
            Log.m45259v(f60249b, "Tried to revert the image view, but no image view is used.");
            return;
        }
        RenderSurface renderSurface = this.f60254f;
        if (renderSurface == null) {
            Log.m45259v(f60249b, "Tried to revert the image view, but no previous surface was used.");
            return;
        }
        this.f60250a = renderSurface;
        this.f60254f = null;
        FlutterEngine flutterEngine = this.f60257i;
        if (flutterEngine == null) {
            flutterImageView.detachFromRenderer();
            runnable.run();
            return;
        }
        final FlutterRenderer renderer = flutterEngine.getRenderer();
        if (renderer == null) {
            this.f60253e.detachFromRenderer();
            runnable.run();
            return;
        }
        this.f60250a.attachToRenderer(renderer);
        renderer.addIsDisplayingFlutterUiListener(new FlutterUiDisplayListener() {
            public void onFlutterUiNoLongerDisplayed() {
            }

            public void onFlutterUiDisplayed() {
                renderer.removeIsDisplayingFlutterUiListener(this);
                runnable.run();
                if (!(FlutterView.this.f60250a instanceof FlutterImageView)) {
                    FlutterView.this.f60253e.detachFromRenderer();
                }
            }
        });
    }

    public void attachOverlaySurfaceToRender(FlutterImageView flutterImageView) {
        FlutterEngine flutterEngine = this.f60257i;
        if (flutterEngine != null) {
            flutterImageView.attachToRenderer(flutterEngine.getRenderer());
        }
    }

    public boolean acquireLatestImageViewFrame() {
        FlutterImageView flutterImageView = this.f60253e;
        if (flutterImageView != null) {
            return flutterImageView.acquireLatestImage();
        }
        return false;
    }

    public boolean isAttachedToFlutterEngine() {
        FlutterEngine flutterEngine = this.f60257i;
        return flutterEngine != null && flutterEngine.getRenderer() == this.f60250a.getAttachedRenderer();
    }

    public FlutterEngine getAttachedFlutterEngine() {
        return this.f60257i;
    }

    public void addFlutterEngineAttachmentListener(FlutterEngineAttachmentListener flutterEngineAttachmentListener) {
        this.f60258j.add(flutterEngineAttachmentListener);
    }

    public void removeFlutterEngineAttachmentListener(FlutterEngineAttachmentListener flutterEngineAttachmentListener) {
        this.f60258j.remove(flutterEngineAttachmentListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo181986a() {
        SettingsChannel.PlatformBrightness platformBrightness;
        if ((getResources().getConfiguration().uiMode & 48) == 32) {
            platformBrightness = SettingsChannel.PlatformBrightness.dark;
        } else {
            platformBrightness = SettingsChannel.PlatformBrightness.light;
        }
        this.f60257i.getSettingsChannel().startMessage().setTextScaleFactor(getResources().getConfiguration().fontScale).setUse24HourFormat(DateFormat.is24HourFormat(getContext())).setPlatformBrightness(platformBrightness).send();
    }

    /* renamed from: d */
    private void m45501d() {
        if (!isAttachedToFlutterEngine()) {
            Log.m45261w(f60249b, "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
            return;
        }
        this.f60266r.devicePixelRatio = getResources().getDisplayMetrics().density;
        this.f60266r.physicalTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f60257i.getRenderer().setViewportMetrics(this.f60266r);
    }

    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i) {
        super.onProvideAutofillVirtualStructure(viewStructure, i);
        this.f60260l.onProvideAutofillVirtualStructure(viewStructure, i);
    }

    public void autofill(SparseArray<AutofillValue> sparseArray) {
        this.f60260l.autofill(sparseArray);
    }
}
