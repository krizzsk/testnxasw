package p218io.flutter.embedding.android;

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
import java.util.HashSet;
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
import p218io.flutter.view.AccessibilityBridge;

/* renamed from: io.flutter.embedding.android.FlutterViewV1 */
public class FlutterViewV1 extends FrameLayout implements MouseCursorPlugin.MouseCursorViewDelegate {

    /* renamed from: a */
    private static final String f60293a = "FlutterView";

    /* renamed from: b */
    private FlutterSurfaceView f60294b;

    /* renamed from: c */
    private FlutterTextureView f60295c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public FlutterImageView f60296d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public RenderSurface f60297e;

    /* renamed from: f */
    private RenderSurface f60298f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Set<FlutterUiDisplayListener> f60299g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f60300h;

    /* renamed from: i */
    private FlutterEngine f60301i;

    /* renamed from: j */
    private final Set<FlutterEngineAttachmentListener> f60302j;

    /* renamed from: k */
    private MouseCursorPlugin f60303k;

    /* renamed from: l */
    private TextInputPlugin f60304l;

    /* renamed from: m */
    private LocalizationPlugin f60305m;

    /* renamed from: n */
    private KeyboardManager f60306n;

    /* renamed from: o */
    private AndroidTouchProcessor f60307o;

    /* renamed from: p */
    private AccessibilityBridge f60308p;

    /* renamed from: q */
    private final FlutterRenderer.ViewportMetrics f60309q;

    /* renamed from: r */
    private final AccessibilityBridge.OnAccessibilityChangeListener f60310r;

    /* renamed from: s */
    private final FlutterUiDisplayListener f60311s;

    /* renamed from: io.flutter.embedding.android.FlutterViewV1$FlutterEngineAttachmentListener */
    public interface FlutterEngineAttachmentListener {
        void onFlutterEngineAttachedToFlutterView(FlutterEngine flutterEngine);

        void onFlutterEngineDetachedFromFlutterView();
    }

    @Deprecated
    /* renamed from: io.flutter.embedding.android.FlutterViewV1$RenderMode */
    public enum RenderMode {
        surface,
        texture,
        image
    }

    @Deprecated
    /* renamed from: io.flutter.embedding.android.FlutterViewV1$TransparencyMode */
    public enum TransparencyMode {
        opaque,
        transparent
    }

    /* renamed from: io.flutter.embedding.android.FlutterViewV1$ZeroSides */
    private enum ZeroSides {
        NONE,
        LEFT,
        RIGHT,
        BOTH
    }

    public FlutterViewV1(Context context) {
        this(context, (AttributeSet) null, new FlutterSurfaceView(context));
    }

    @Deprecated
    public FlutterViewV1(Context context, RenderMode renderMode) {
        super(context, (AttributeSet) null);
        this.f60299g = new HashSet();
        this.f60302j = new HashSet();
        this.f60309q = new FlutterRenderer.ViewportMetrics();
        this.f60310r = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterViewV1.this.m45518a(z, z2);
            }
        };
        this.f60311s = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterViewV1.this.f60300h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterViewV1.this.f60299g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterViewV1.this.f60300h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterViewV1.this.f60299g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        if (renderMode == RenderMode.surface) {
            FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(context);
            this.f60294b = flutterSurfaceView;
            this.f60297e = flutterSurfaceView;
        } else if (renderMode == RenderMode.texture) {
            FlutterTextureView flutterTextureView = new FlutterTextureView(context);
            this.f60295c = flutterTextureView;
            this.f60297e = flutterTextureView;
        } else {
            throw new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", new Object[]{renderMode}));
        }
        m45521b();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public FlutterViewV1(Context context, TransparencyMode transparencyMode) {
        this(context, (AttributeSet) null, new FlutterSurfaceView(context, transparencyMode == TransparencyMode.transparent));
    }

    public FlutterViewV1(Context context, FlutterSurfaceView flutterSurfaceView) {
        this(context, (AttributeSet) null, flutterSurfaceView);
    }

    public FlutterViewV1(Context context, FlutterTextureView flutterTextureView) {
        this(context, (AttributeSet) null, flutterTextureView);
    }

    public FlutterViewV1(Context context, FlutterImageView flutterImageView) {
        this(context, (AttributeSet) null, flutterImageView);
    }

    public FlutterViewV1(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, new FlutterSurfaceView(context));
    }

    @Deprecated
    public FlutterViewV1(Context context, RenderMode renderMode, TransparencyMode transparencyMode) {
        super(context, (AttributeSet) null);
        this.f60299g = new HashSet();
        this.f60302j = new HashSet();
        this.f60309q = new FlutterRenderer.ViewportMetrics();
        this.f60310r = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterViewV1.this.m45518a(z, z2);
            }
        };
        this.f60311s = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterViewV1.this.f60300h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterViewV1.this.f60299g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterViewV1.this.f60300h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterViewV1.this.f60299g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        boolean z = false;
        if (renderMode == RenderMode.surface) {
            FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(context, transparencyMode == TransparencyMode.transparent ? true : z);
            this.f60294b = flutterSurfaceView;
            this.f60297e = flutterSurfaceView;
        } else if (renderMode == RenderMode.texture) {
            FlutterTextureView flutterTextureView = new FlutterTextureView(context);
            this.f60295c = flutterTextureView;
            this.f60297e = flutterTextureView;
        } else {
            throw new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", new Object[]{renderMode}));
        }
        m45521b();
    }

    private FlutterViewV1(Context context, AttributeSet attributeSet, FlutterSurfaceView flutterSurfaceView) {
        super(context, attributeSet);
        this.f60299g = new HashSet();
        this.f60302j = new HashSet();
        this.f60309q = new FlutterRenderer.ViewportMetrics();
        this.f60310r = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterViewV1.this.m45518a(z, z2);
            }
        };
        this.f60311s = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterViewV1.this.f60300h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterViewV1.this.f60299g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterViewV1.this.f60300h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterViewV1.this.f60299g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.f60294b = flutterSurfaceView;
        this.f60297e = flutterSurfaceView;
        m45521b();
    }

    private FlutterViewV1(Context context, AttributeSet attributeSet, FlutterTextureView flutterTextureView) {
        super(context, attributeSet);
        this.f60299g = new HashSet();
        this.f60302j = new HashSet();
        this.f60309q = new FlutterRenderer.ViewportMetrics();
        this.f60310r = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterViewV1.this.m45518a(z, z2);
            }
        };
        this.f60311s = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterViewV1.this.f60300h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterViewV1.this.f60299g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterViewV1.this.f60300h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterViewV1.this.f60299g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.f60295c = flutterTextureView;
        this.f60297e = flutterTextureView;
        m45521b();
    }

    private FlutterViewV1(Context context, AttributeSet attributeSet, FlutterImageView flutterImageView) {
        super(context, attributeSet);
        this.f60299g = new HashSet();
        this.f60302j = new HashSet();
        this.f60309q = new FlutterRenderer.ViewportMetrics();
        this.f60310r = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterViewV1.this.m45518a(z, z2);
            }
        };
        this.f60311s = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterViewV1.this.f60300h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterViewV1.this.f60299g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterViewV1.this.f60300h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterViewV1.this.f60299g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.f60296d = flutterImageView;
        this.f60297e = flutterImageView;
        m45521b();
    }

    /* renamed from: b */
    private void m45521b() {
        Log.m45259v(f60293a, "Initializing FlutterView");
        if (this.f60294b != null) {
            Log.m45259v(f60293a, "Internally using a FlutterSurfaceView.");
            addView(this.f60294b);
        } else if (this.f60295c != null) {
            Log.m45259v(f60293a, "Internally using a FlutterTextureView.");
            addView(this.f60295c);
        } else {
            Log.m45259v(f60293a, "Internally using a FlutterImageView.");
            addView(this.f60296d);
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(4);
        }
    }

    public boolean hasRenderedFirstFrame() {
        return this.f60300h;
    }

    public void addOnFirstFrameRenderedListener(FlutterUiDisplayListener flutterUiDisplayListener) {
        this.f60299g.add(flutterUiDisplayListener);
    }

    public void removeOnFirstFrameRenderedListener(FlutterUiDisplayListener flutterUiDisplayListener) {
        this.f60299g.remove(flutterUiDisplayListener);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f60301i != null) {
            Log.m45259v(f60293a, "Configuration changed. Sending locales and user settings to Flutter.");
            this.f60305m.sendLocalesToFlutter(configuration);
            mo182063a();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Log.m45259v(f60293a, "Size changed. Sending Flutter new viewport metrics. FlutterView was " + i3 + " x " + i4 + ", it is now " + i + " x " + i2);
        this.f60309q.width = i;
        this.f60309q.height = i2;
        m45524d();
    }

    /* renamed from: c */
    private ZeroSides m45523c() {
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
    private int m45514a(WindowInsets windowInsets) {
        if (((double) windowInsets.getSystemWindowInsetBottom()) < ((double) getRootView().getHeight()) * 0.18d) {
            return 0;
        }
        return windowInsets.getSystemWindowInsetBottom();
    }

    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        if (Build.VERSION.SDK_INT == 29) {
            Insets systemGestureInsets = windowInsets.getSystemGestureInsets();
            this.f60309q.systemGestureInsetTop = systemGestureInsets.top;
            this.f60309q.systemGestureInsetRight = systemGestureInsets.right;
            this.f60309q.systemGestureInsetBottom = systemGestureInsets.bottom;
            this.f60309q.systemGestureInsetLeft = systemGestureInsets.left;
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
            this.f60309q.viewPaddingTop = insets.top;
            this.f60309q.viewPaddingRight = insets.right;
            this.f60309q.viewPaddingBottom = insets.bottom;
            this.f60309q.viewPaddingLeft = insets.left;
            Insets insets2 = windowInsets.getInsets(WindowInsets.Type.ime());
            this.f60309q.viewInsetTop = insets2.top;
            this.f60309q.viewInsetRight = insets2.right;
            this.f60309q.viewInsetBottom = insets2.bottom;
            this.f60309q.viewInsetLeft = insets2.left;
            Insets insets3 = windowInsets.getInsets(WindowInsets.Type.systemGestures());
            this.f60309q.systemGestureInsetTop = insets3.top;
            this.f60309q.systemGestureInsetRight = insets3.right;
            this.f60309q.systemGestureInsetBottom = insets3.bottom;
            this.f60309q.systemGestureInsetLeft = insets3.left;
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                Insets waterfallInsets = displayCutout.getWaterfallInsets();
                FlutterRenderer.ViewportMetrics viewportMetrics = this.f60309q;
                viewportMetrics.viewPaddingTop = Math.max(Math.max(viewportMetrics.viewPaddingTop, waterfallInsets.top), displayCutout.getSafeInsetTop());
                FlutterRenderer.ViewportMetrics viewportMetrics2 = this.f60309q;
                viewportMetrics2.viewPaddingRight = Math.max(Math.max(viewportMetrics2.viewPaddingRight, waterfallInsets.right), displayCutout.getSafeInsetRight());
                FlutterRenderer.ViewportMetrics viewportMetrics3 = this.f60309q;
                viewportMetrics3.viewPaddingBottom = Math.max(Math.max(viewportMetrics3.viewPaddingBottom, waterfallInsets.bottom), displayCutout.getSafeInsetBottom());
                FlutterRenderer.ViewportMetrics viewportMetrics4 = this.f60309q;
                viewportMetrics4.viewPaddingLeft = Math.max(Math.max(viewportMetrics4.viewPaddingLeft, waterfallInsets.left), displayCutout.getSafeInsetLeft());
            }
        } else {
            ZeroSides zeroSides = ZeroSides.NONE;
            if (!z) {
                zeroSides = m45523c();
            }
            this.f60309q.viewPaddingTop = z2 ? windowInsets.getSystemWindowInsetTop() : 0;
            this.f60309q.viewPaddingRight = (zeroSides == ZeroSides.RIGHT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetRight();
            this.f60309q.viewPaddingBottom = (!z || m45514a(windowInsets) != 0) ? 0 : windowInsets.getSystemWindowInsetBottom();
            this.f60309q.viewPaddingLeft = (zeroSides == ZeroSides.LEFT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetLeft();
            this.f60309q.viewInsetTop = 0;
            this.f60309q.viewInsetRight = 0;
            this.f60309q.viewInsetBottom = m45514a(windowInsets);
            this.f60309q.viewInsetLeft = 0;
        }
        Log.m45259v(f60293a, "Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: " + this.f60309q.viewPaddingTop + ", Left: " + this.f60309q.viewPaddingLeft + ", Right: " + this.f60309q.viewPaddingRight + "\nKeyboard insets: Bottom: " + this.f60309q.viewInsetBottom + ", Left: " + this.f60309q.viewInsetLeft + ", Right: " + this.f60309q.viewInsetRight + "System Gesture Insets - Left: " + this.f60309q.systemGestureInsetLeft + ", Top: " + this.f60309q.systemGestureInsetTop + ", Right: " + this.f60309q.systemGestureInsetRight + ", Bottom: " + this.f60309q.viewInsetBottom);
        m45524d();
        return onApplyWindowInsets;
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT > 19) {
            return super.fitSystemWindows(rect);
        }
        this.f60309q.viewPaddingTop = rect.top;
        this.f60309q.viewPaddingRight = rect.right;
        this.f60309q.viewPaddingBottom = 0;
        this.f60309q.viewPaddingLeft = rect.left;
        this.f60309q.viewInsetTop = 0;
        this.f60309q.viewInsetRight = 0;
        this.f60309q.viewInsetBottom = rect.bottom;
        this.f60309q.viewInsetLeft = 0;
        Log.m45259v(f60293a, "Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: " + this.f60309q.viewPaddingTop + ", Left: " + this.f60309q.viewPaddingLeft + ", Right: " + this.f60309q.viewPaddingRight + "\nKeyboard insets: Bottom: " + this.f60309q.viewInsetBottom + ", Left: " + this.f60309q.viewInsetLeft + ", Right: " + this.f60309q.viewInsetRight);
        m45524d();
        return true;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        if (!isAttachedToFlutterEngine()) {
            return super.onCreateInputConnection(editorInfo);
        }
        return this.f60304l.createInputConnection(this, this.f60306n, editorInfo);
    }

    public boolean checkInputConnectionProxy(View view) {
        FlutterEngine flutterEngine = this.f60301i;
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
        if ((!isAttachedToFlutterEngine() || !this.f60306n.handleEvent(keyEvent)) && !super.dispatchKeyEvent(keyEvent)) {
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
        return this.f60307o.onTouchEvent(motionEvent);
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (isAttachedToFlutterEngine() && this.f60307o.onGenericMotionEvent(motionEvent)) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (!isAttachedToFlutterEngine()) {
            return super.onHoverEvent(motionEvent);
        }
        return this.f60308p.onAccessibilityHoverEvent(motionEvent);
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        AccessibilityBridge accessibilityBridge = this.f60308p;
        if (accessibilityBridge == null || !accessibilityBridge.isAccessibilityEnabled()) {
            return null;
        }
        return this.f60308p;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View findViewByAccessibilityIdTraversal(int r8) {
        /*
            r7 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 >= r1) goto L_0x000b
            android.view.View r8 = r7.m45515a((int) r8, (android.view.View) r7)
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
        throw new UnsupportedOperationException("Method not decompiled: p218io.flutter.embedding.android.FlutterViewV1.findViewByAccessibilityIdTraversal(int):android.view.View");
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View m45515a(int r6, android.view.View r7) {
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
            android.view.View r1 = r5.m45515a((int) r6, (android.view.View) r1)
            if (r1 == 0) goto L_0x0039
            return r1
        L_0x0039:
            int r3 = r3 + 1
            goto L_0x0025
        L_0x003c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p218io.flutter.embedding.android.FlutterViewV1.m45515a(int, android.view.View):android.view.View");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m45518a(boolean z, boolean z2) {
        boolean z3 = false;
        if (!this.f60301i.getRenderer().isSoftwareRenderingEnabled()) {
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
        Log.m45259v(f60293a, "Attaching to a FlutterEngine: " + flutterEngine);
        if (isAttachedToFlutterEngine()) {
            if (flutterEngine == this.f60301i) {
                Log.m45259v(f60293a, "Already attached to this engine. Doing nothing.");
                return;
            } else {
                Log.m45259v(f60293a, "Currently attached to a different engine. Detaching and then attaching to new engine.");
                detachFromFlutterEngine();
            }
        }
        this.f60301i = flutterEngine;
        FlutterRenderer renderer = flutterEngine.getRenderer();
        this.f60300h = renderer.isDisplayingFlutterUi();
        this.f60297e.attachToRenderer(renderer);
        renderer.addIsDisplayingFlutterUiListener(this.f60311s);
        if (Build.VERSION.SDK_INT >= 24) {
            this.f60303k = new MouseCursorPlugin(this, this.f60301i.getMouseCursorChannel());
        }
        this.f60304l = new TextInputPlugin(this, this.f60301i.getTextInputChannel(), this.f60301i.getPlatformViewsController());
        this.f60305m = this.f60301i.getLocalizationPlugin();
        this.f60306n = new KeyboardManager(this, this.f60304l, new KeyChannelResponder[]{new KeyChannelResponder(flutterEngine.getKeyEventChannel())});
        this.f60307o = new AndroidTouchProcessor(this.f60301i.getRenderer(), false);
        AccessibilityBridge accessibilityBridge = new AccessibilityBridge(this, flutterEngine.getAccessibilityChannel(), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.f60301i.getPlatformViewsController());
        this.f60308p = accessibilityBridge;
        accessibilityBridge.setOnAccessibilityChangeListener(this.f60310r);
        m45518a(this.f60308p.isAccessibilityEnabled(), this.f60308p.isTouchExplorationEnabled());
        this.f60301i.getPlatformViewsController().attachAccessibilityBridge(this.f60308p);
        this.f60301i.getPlatformViewsController().attachToFlutterRenderer(this.f60301i.getRenderer());
        this.f60304l.getInputMethodManager().restartInput(this);
        mo182063a();
        this.f60305m.sendLocalesToFlutter(getResources().getConfiguration());
        m45524d();
        for (FlutterEngineAttachmentListener onFlutterEngineAttachedToFlutterView : this.f60302j) {
            onFlutterEngineAttachedToFlutterView.onFlutterEngineAttachedToFlutterView(flutterEngine);
        }
        if (this.f60300h) {
            this.f60311s.onFlutterUiDisplayed();
        }
    }

    public void detachFromFlutterEngine() {
        Log.m45259v(f60293a, "Detaching from a FlutterEngine: " + this.f60301i);
        if (!isAttachedToFlutterEngine()) {
            Log.m45259v(f60293a, "FlutterView not attached to an engine. Not detaching.");
            return;
        }
        for (FlutterEngineAttachmentListener onFlutterEngineDetachedFromFlutterView : this.f60302j) {
            onFlutterEngineDetachedFromFlutterView.onFlutterEngineDetachedFromFlutterView();
        }
        this.f60301i.getPlatformViewsController().detachFromView();
        this.f60308p.release();
        this.f60308p = null;
        this.f60304l.getInputMethodManager().restartInput(this);
        this.f60304l.destroy();
        this.f60306n.destroy();
        MouseCursorPlugin mouseCursorPlugin = this.f60303k;
        if (mouseCursorPlugin != null) {
            mouseCursorPlugin.destroy();
        }
        FlutterRenderer renderer = this.f60301i.getRenderer();
        this.f60300h = false;
        renderer.removeIsDisplayingFlutterUiListener(this.f60311s);
        renderer.stopRenderingToSurface();
        renderer.setSemanticsEnabled(false);
        this.f60297e.detachFromRenderer();
        this.f60296d = null;
        this.f60298f = null;
        this.f60301i = null;
    }

    public FlutterImageView createImageView() {
        return new FlutterImageView(getContext(), getWidth(), getHeight(), FlutterImageView.SurfaceKind.background);
    }

    public void convertToImageView() {
        this.f60297e.pause();
        FlutterImageView flutterImageView = this.f60296d;
        if (flutterImageView == null) {
            FlutterImageView createImageView = createImageView();
            this.f60296d = createImageView;
            addView(createImageView);
        } else {
            flutterImageView.resizeIfNeeded(getWidth(), getHeight());
        }
        this.f60298f = this.f60297e;
        FlutterImageView flutterImageView2 = this.f60296d;
        this.f60297e = flutterImageView2;
        FlutterEngine flutterEngine = this.f60301i;
        if (flutterEngine != null) {
            flutterImageView2.attachToRenderer(flutterEngine.getRenderer());
        }
    }

    public void revertImageView(final Runnable runnable) {
        FlutterImageView flutterImageView = this.f60296d;
        if (flutterImageView == null) {
            Log.m45259v(f60293a, "Tried to revert the image view, but no image view is used.");
            return;
        }
        RenderSurface renderSurface = this.f60298f;
        if (renderSurface == null) {
            Log.m45259v(f60293a, "Tried to revert the image view, but no previous surface was used.");
            return;
        }
        this.f60297e = renderSurface;
        this.f60298f = null;
        FlutterEngine flutterEngine = this.f60301i;
        if (flutterEngine == null) {
            flutterImageView.detachFromRenderer();
            runnable.run();
            return;
        }
        final FlutterRenderer renderer = flutterEngine.getRenderer();
        if (renderer == null) {
            this.f60296d.detachFromRenderer();
            runnable.run();
            return;
        }
        this.f60297e.attachToRenderer(renderer);
        renderer.addIsDisplayingFlutterUiListener(new FlutterUiDisplayListener() {
            public void onFlutterUiNoLongerDisplayed() {
            }

            public void onFlutterUiDisplayed() {
                renderer.removeIsDisplayingFlutterUiListener(this);
                runnable.run();
                if (!(FlutterViewV1.this.f60297e instanceof FlutterImageView)) {
                    FlutterViewV1.this.f60296d.detachFromRenderer();
                }
            }
        });
    }

    public void attachOverlaySurfaceToRender(FlutterImageView flutterImageView) {
        FlutterEngine flutterEngine = this.f60301i;
        if (flutterEngine != null) {
            flutterImageView.attachToRenderer(flutterEngine.getRenderer());
        }
    }

    public boolean acquireLatestImageViewFrame() {
        FlutterImageView flutterImageView = this.f60296d;
        if (flutterImageView != null) {
            return flutterImageView.acquireLatestImage();
        }
        return false;
    }

    public boolean isAttachedToFlutterEngine() {
        FlutterEngine flutterEngine = this.f60301i;
        return flutterEngine != null && flutterEngine.getRenderer() == this.f60297e.getAttachedRenderer();
    }

    public FlutterEngine getAttachedFlutterEngine() {
        return this.f60301i;
    }

    public void addFlutterEngineAttachmentListener(FlutterEngineAttachmentListener flutterEngineAttachmentListener) {
        this.f60302j.add(flutterEngineAttachmentListener);
    }

    public void removeFlutterEngineAttachmentListener(FlutterEngineAttachmentListener flutterEngineAttachmentListener) {
        this.f60302j.remove(flutterEngineAttachmentListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo182063a() {
        SettingsChannel.PlatformBrightness platformBrightness;
        if ((getResources().getConfiguration().uiMode & 48) == 32) {
            platformBrightness = SettingsChannel.PlatformBrightness.dark;
        } else {
            platformBrightness = SettingsChannel.PlatformBrightness.light;
        }
        this.f60301i.getSettingsChannel().startMessage().setTextScaleFactor(getResources().getConfiguration().fontScale).setUse24HourFormat(DateFormat.is24HourFormat(getContext())).setPlatformBrightness(platformBrightness).send();
    }

    /* renamed from: d */
    private void m45524d() {
        if (!isAttachedToFlutterEngine()) {
            Log.m45261w(f60293a, "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
            return;
        }
        this.f60309q.devicePixelRatio = getResources().getDisplayMetrics().density;
        this.f60309q.physicalTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f60301i.getRenderer().setViewportMetrics(this.f60309q);
    }

    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i) {
        super.onProvideAutofillVirtualStructure(viewStructure, i);
        this.f60304l.onProvideAutofillVirtualStructure(viewStructure, i);
    }

    public void autofill(SparseArray<AutofillValue> sparseArray) {
        this.f60304l.autofill(sparseArray);
    }

    public void attachToRenderer() {
        RenderSurface renderSurface = this.f60297e;
        if ((renderSurface != null && renderSurface.getAttachedRenderer() == null) || !this.f60297e.getAttachedRenderer().isDisplayingFlutterUi()) {
            this.f60297e.attachToRenderer(this.f60301i.getRenderer());
        }
    }

    public void detachFromRenderer() {
        this.f60297e.detachFromRenderer();
    }
}
