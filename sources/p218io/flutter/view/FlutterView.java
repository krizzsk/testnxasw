package p218io.flutter.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Insets;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
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
import android.view.inputmethod.InputMethodManager;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import p218io.flutter.Log;
import p218io.flutter.app.FlutterPluginRegistry;
import p218io.flutter.embedding.android.AndroidTouchProcessor;
import p218io.flutter.embedding.android.KeyChannelResponder;
import p218io.flutter.embedding.android.KeyboardManager;
import p218io.flutter.embedding.engine.dart.DartExecutor;
import p218io.flutter.embedding.engine.renderer.FlutterRenderer;
import p218io.flutter.embedding.engine.renderer.SurfaceTextureWrapper;
import p218io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import p218io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import p218io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import p218io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import p218io.flutter.embedding.engine.systemchannels.MouseCursorChannel;
import p218io.flutter.embedding.engine.systemchannels.NavigationChannel;
import p218io.flutter.embedding.engine.systemchannels.PlatformChannel;
import p218io.flutter.embedding.engine.systemchannels.SettingsChannel;
import p218io.flutter.embedding.engine.systemchannels.SystemChannel;
import p218io.flutter.embedding.engine.systemchannels.TextInputChannel;
import p218io.flutter.plugin.common.ActivityLifecycleListener;
import p218io.flutter.plugin.common.BinaryMessenger;
import p218io.flutter.plugin.editing.TextInputPlugin;
import p218io.flutter.plugin.localization.LocalizationPlugin;
import p218io.flutter.plugin.mouse.MouseCursorPlugin;
import p218io.flutter.plugin.platform.PlatformPlugin;
import p218io.flutter.plugin.platform.PlatformViewsController;
import p218io.flutter.util.ViewUtils;
import p218io.flutter.view.AccessibilityBridge;
import p218io.flutter.view.TextureRegistry;

@Deprecated
/* renamed from: io.flutter.view.FlutterView */
public class FlutterView extends SurfaceView implements BinaryMessenger, MouseCursorPlugin.MouseCursorViewDelegate, TextureRegistry {

    /* renamed from: a */
    private static final String f60738a = "FlutterView";

    /* renamed from: b */
    private final DartExecutor f60739b;

    /* renamed from: c */
    private final FlutterRenderer f60740c;

    /* renamed from: d */
    private final NavigationChannel f60741d;

    /* renamed from: e */
    private final KeyEventChannel f60742e;

    /* renamed from: f */
    private final LifecycleChannel f60743f;

    /* renamed from: g */
    private final LocalizationChannel f60744g;

    /* renamed from: h */
    private final PlatformChannel f60745h;

    /* renamed from: i */
    private final SettingsChannel f60746i;

    /* renamed from: j */
    private final SystemChannel f60747j;

    /* renamed from: k */
    private final InputMethodManager f60748k;

    /* renamed from: l */
    private final TextInputPlugin f60749l;

    /* renamed from: m */
    private final LocalizationPlugin f60750m;

    /* renamed from: n */
    private final MouseCursorPlugin f60751n;

    /* renamed from: o */
    private final KeyboardManager f60752o;

    /* renamed from: p */
    private final AndroidTouchProcessor f60753p;

    /* renamed from: q */
    private AccessibilityBridge f60754q;

    /* renamed from: r */
    private final SurfaceHolder.Callback f60755r;

    /* renamed from: s */
    private final ViewportMetrics f60756s;

    /* renamed from: t */
    private final List<ActivityLifecycleListener> f60757t;

    /* renamed from: u */
    private final List<FirstFrameListener> f60758u;

    /* renamed from: v */
    private final AtomicLong f60759v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public FlutterNativeView f60760w;

    /* renamed from: x */
    private boolean f60761x;

    /* renamed from: y */
    private boolean f60762y;

    /* renamed from: z */
    private final AccessibilityBridge.OnAccessibilityChangeListener f60763z;

    /* renamed from: io.flutter.view.FlutterView$FirstFrameListener */
    public interface FirstFrameListener {
        void onFirstFrame();
    }

    /* renamed from: io.flutter.view.FlutterView$Provider */
    public interface Provider {
        FlutterView getFlutterView();
    }

    /* renamed from: io.flutter.view.FlutterView$ZeroSides */
    private enum ZeroSides {
        NONE,
        LEFT,
        RIGHT,
        BOTH
    }

    /* renamed from: g */
    private void m45878g() {
    }

    public void disableBufferingIncomingMessages() {
    }

    public void enableBufferingIncomingMessages() {
    }

    public /* synthetic */ BinaryMessenger.TaskQueue makeBackgroundTaskQueue() {
        return BinaryMessenger.CC.$default$makeBackgroundTaskQueue(this);
    }

    public BinaryMessenger.TaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions) {
        return null;
    }

    /* renamed from: io.flutter.view.FlutterView$ViewportMetrics */
    static final class ViewportMetrics {
        float devicePixelRatio = 1.0f;
        int physicalHeight = 0;
        int physicalTouchSlop = -1;
        int physicalViewInsetBottom = 0;
        int physicalViewInsetLeft = 0;
        int physicalViewInsetRight = 0;
        int physicalViewInsetTop = 0;
        int physicalViewPaddingBottom = 0;
        int physicalViewPaddingLeft = 0;
        int physicalViewPaddingRight = 0;
        int physicalViewPaddingTop = 0;
        int physicalWidth = 0;
        int systemGestureInsetBottom = 0;
        int systemGestureInsetLeft = 0;
        int systemGestureInsetRight = 0;
        int systemGestureInsetTop = 0;

        ViewportMetrics() {
        }
    }

    public FlutterView(Context context) {
        this(context, (AttributeSet) null);
    }

    public FlutterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (FlutterNativeView) null);
    }

    public FlutterView(Context context, AttributeSet attributeSet, FlutterNativeView flutterNativeView) {
        super(context, attributeSet);
        this.f60759v = new AtomicLong(0);
        this.f60761x = false;
        this.f60762y = false;
        this.f60763z = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView.this.m45873a(z, z2);
            }
        };
        Activity activity = ViewUtils.getActivity(getContext());
        if (activity != null) {
            if (flutterNativeView == null) {
                this.f60760w = new FlutterNativeView(activity.getApplicationContext());
            } else {
                this.f60760w = flutterNativeView;
            }
            this.f60739b = this.f60760w.getDartExecutor();
            this.f60740c = new FlutterRenderer(this.f60760w.mo182758a());
            this.f60761x = this.f60760w.mo182758a().getIsSoftwareRenderingEnabled();
            ViewportMetrics viewportMetrics = new ViewportMetrics();
            this.f60756s = viewportMetrics;
            viewportMetrics.devicePixelRatio = context.getResources().getDisplayMetrics().density;
            this.f60756s.physicalTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
            setFocusable(true);
            setFocusableInTouchMode(true);
            this.f60760w.attachViewAndActivity(this, activity);
            this.f60755r = new SurfaceHolder.Callback() {
                public void surfaceCreated(SurfaceHolder surfaceHolder) {
                    FlutterView.this.mo182768a();
                    FlutterView.this.f60760w.mo182758a().onSurfaceCreated(surfaceHolder.getSurface());
                }

                public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                    FlutterView.this.mo182768a();
                    FlutterView.this.f60760w.mo182758a().onSurfaceChanged(i2, i3);
                }

                public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                    FlutterView.this.mo182768a();
                    FlutterView.this.f60760w.mo182758a().onSurfaceDestroyed();
                }
            };
            getHolder().addCallback(this.f60755r);
            this.f60757t = new ArrayList();
            this.f60758u = new ArrayList();
            this.f60741d = new NavigationChannel(this.f60739b);
            this.f60742e = new KeyEventChannel(this.f60739b);
            this.f60743f = new LifecycleChannel(this.f60739b);
            this.f60744g = new LocalizationChannel(this.f60739b);
            this.f60745h = new PlatformChannel(this.f60739b);
            this.f60747j = new SystemChannel(this.f60739b);
            this.f60746i = new SettingsChannel(this.f60739b);
            final PlatformPlugin platformPlugin = new PlatformPlugin(activity, this.f60745h);
            addActivityLifecycleListener(new ActivityLifecycleListener() {
                public void onPostResume() {
                    platformPlugin.updateSystemUiOverlays();
                }
            });
            this.f60748k = (InputMethodManager) getContext().getSystemService("input_method");
            PlatformViewsController platformViewsController = this.f60760w.getPluginRegistry().getPlatformViewsController();
            TextInputPlugin textInputPlugin = new TextInputPlugin(this, new TextInputChannel(this.f60739b), platformViewsController);
            this.f60749l = textInputPlugin;
            this.f60752o = new KeyboardManager(this, textInputPlugin, new KeyChannelResponder[]{new KeyChannelResponder(this.f60742e)});
            if (Build.VERSION.SDK_INT >= 24) {
                this.f60751n = new MouseCursorPlugin(this, new MouseCursorChannel(this.f60739b));
            } else {
                this.f60751n = null;
            }
            this.f60750m = new LocalizationPlugin(context, this.f60744g);
            this.f60753p = new AndroidTouchProcessor(this.f60740c, false);
            platformViewsController.attachToFlutterRenderer(this.f60740c);
            this.f60760w.getPluginRegistry().getPlatformViewsController().attachTextInputPlugin(this.f60749l);
            this.f60760w.mo182758a().setLocalizationPlugin(this.f60750m);
            this.f60750m.sendLocalesToFlutter(getResources().getConfiguration());
            m45874c();
            return;
        }
        throw new IllegalArgumentException("Bad context");
    }

    public DartExecutor getDartExecutor() {
        return this.f60739b;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Log.m45255e(f60738a, "dispatchKeyEvent: " + keyEvent.toString());
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            getKeyDispatcherState().startTracking(keyEvent, this);
        } else if (keyEvent.getAction() == 1) {
            getKeyDispatcherState().handleUpEvent(keyEvent);
        }
        if ((!m45876e() || !this.f60752o.handleEvent(keyEvent)) && !super.dispatchKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    public FlutterNativeView getFlutterNativeView() {
        return this.f60760w;
    }

    public FlutterPluginRegistry getPluginRegistry() {
        return this.f60760w.getPluginRegistry();
    }

    public String getLookupKeyForAsset(String str) {
        return FlutterMain.getLookupKeyForAsset(str);
    }

    public String getLookupKeyForAsset(String str, String str2) {
        return FlutterMain.getLookupKeyForAsset(str, str2);
    }

    public void addActivityLifecycleListener(ActivityLifecycleListener activityLifecycleListener) {
        this.f60757t.add(activityLifecycleListener);
    }

    public void onStart() {
        this.f60743f.appIsInactive();
    }

    public void onPause() {
        this.f60743f.appIsInactive();
    }

    public void onPostResume() {
        for (ActivityLifecycleListener onPostResume : this.f60757t) {
            onPostResume.onPostResume();
        }
        this.f60743f.appIsResumed();
    }

    public void onStop() {
        this.f60743f.appIsPaused();
    }

    public void onMemoryPressure() {
        this.f60760w.mo182758a().notifyLowMemoryWarning();
        this.f60747j.sendMemoryPressureWarning();
    }

    public boolean hasRenderedFirstFrame() {
        return this.f60762y;
    }

    public void addFirstFrameListener(FirstFrameListener firstFrameListener) {
        this.f60758u.add(firstFrameListener);
    }

    public void removeFirstFrameListener(FirstFrameListener firstFrameListener) {
        this.f60758u.remove(firstFrameListener);
    }

    public void disableTransparentBackground() {
        setZOrderOnTop(false);
        getHolder().setFormat(-1);
    }

    public void setInitialRoute(String str) {
        this.f60741d.setInitialRoute(str);
    }

    public void pushRoute(String str) {
        this.f60741d.pushRoute(str);
    }

    public void popRoute() {
        this.f60741d.popRoute();
    }

    /* renamed from: c */
    private void m45874c() {
        SettingsChannel.PlatformBrightness platformBrightness;
        if ((getResources().getConfiguration().uiMode & 48) == 32) {
            platformBrightness = SettingsChannel.PlatformBrightness.dark;
        } else {
            platformBrightness = SettingsChannel.PlatformBrightness.light;
        }
        this.f60746i.startMessage().setTextScaleFactor(getResources().getConfiguration().fontScale).setUse24HourFormat(DateFormat.is24HourFormat(getContext())).setPlatformBrightness(platformBrightness).send();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f60750m.sendLocalesToFlutter(configuration);
        m45874c();
    }

    /* access modifiers changed from: package-private */
    public float getDevicePixelRatio() {
        return this.f60756s.devicePixelRatio;
    }

    public FlutterNativeView detach() {
        if (!m45876e()) {
            return null;
        }
        getHolder().removeCallback(this.f60755r);
        this.f60760w.detachFromFlutterView();
        FlutterNativeView flutterNativeView = this.f60760w;
        this.f60760w = null;
        return flutterNativeView;
    }

    public void destroy() {
        if (m45876e()) {
            getHolder().removeCallback(this.f60755r);
            m45880i();
            this.f60760w.destroy();
            this.f60760w = null;
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.f60749l.createInputConnection(this, this.f60752o, editorInfo);
    }

    public boolean checkInputConnectionProxy(View view) {
        return this.f60760w.getPluginRegistry().getPlatformViewsController().checkInputConnectionProxy(view);
    }

    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i) {
        super.onProvideAutofillVirtualStructure(viewStructure, i);
        this.f60749l.onProvideAutofillVirtualStructure(viewStructure, i);
    }

    public void autofill(SparseArray<AutofillValue> sparseArray) {
        this.f60749l.autofill(sparseArray);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!m45876e()) {
            return super.onTouchEvent(motionEvent);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            requestUnbufferedDispatch(motionEvent);
        }
        return this.f60753p.onTouchEvent(motionEvent);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (!m45876e()) {
            return super.onHoverEvent(motionEvent);
        }
        return this.f60754q.onAccessibilityHoverEvent(motionEvent);
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (m45876e() && this.f60753p.onGenericMotionEvent(motionEvent)) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.f60756s.physicalWidth = i;
        this.f60756s.physicalHeight = i2;
        m45879h();
        super.onSizeChanged(i, i2, i3, i4);
    }

    /* renamed from: d */
    private ZeroSides m45875d() {
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
    private int m45870a(WindowInsets windowInsets) {
        if (((double) windowInsets.getSystemWindowInsetBottom()) < ((double) getRootView().getHeight()) * 0.18d) {
            return 0;
        }
        return windowInsets.getSystemWindowInsetBottom();
    }

    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        if (Build.VERSION.SDK_INT == 29) {
            Insets systemGestureInsets = windowInsets.getSystemGestureInsets();
            this.f60756s.systemGestureInsetTop = systemGestureInsets.top;
            this.f60756s.systemGestureInsetRight = systemGestureInsets.right;
            this.f60756s.systemGestureInsetBottom = systemGestureInsets.bottom;
            this.f60756s.systemGestureInsetLeft = systemGestureInsets.left;
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
            this.f60756s.physicalViewPaddingTop = insets.top;
            this.f60756s.physicalViewPaddingRight = insets.right;
            this.f60756s.physicalViewPaddingBottom = insets.bottom;
            this.f60756s.physicalViewPaddingLeft = insets.left;
            Insets insets2 = windowInsets.getInsets(WindowInsets.Type.ime());
            this.f60756s.physicalViewInsetTop = insets2.top;
            this.f60756s.physicalViewInsetRight = insets2.right;
            this.f60756s.physicalViewInsetBottom = insets2.bottom;
            this.f60756s.physicalViewInsetLeft = insets2.left;
            Insets insets3 = windowInsets.getInsets(WindowInsets.Type.systemGestures());
            this.f60756s.systemGestureInsetTop = insets3.top;
            this.f60756s.systemGestureInsetRight = insets3.right;
            this.f60756s.systemGestureInsetBottom = insets3.bottom;
            this.f60756s.systemGestureInsetLeft = insets3.left;
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                Insets waterfallInsets = displayCutout.getWaterfallInsets();
                ViewportMetrics viewportMetrics = this.f60756s;
                viewportMetrics.physicalViewPaddingTop = Math.max(Math.max(viewportMetrics.physicalViewPaddingTop, waterfallInsets.top), displayCutout.getSafeInsetTop());
                ViewportMetrics viewportMetrics2 = this.f60756s;
                viewportMetrics2.physicalViewPaddingRight = Math.max(Math.max(viewportMetrics2.physicalViewPaddingRight, waterfallInsets.right), displayCutout.getSafeInsetRight());
                ViewportMetrics viewportMetrics3 = this.f60756s;
                viewportMetrics3.physicalViewPaddingBottom = Math.max(Math.max(viewportMetrics3.physicalViewPaddingBottom, waterfallInsets.bottom), displayCutout.getSafeInsetBottom());
                ViewportMetrics viewportMetrics4 = this.f60756s;
                viewportMetrics4.physicalViewPaddingLeft = Math.max(Math.max(viewportMetrics4.physicalViewPaddingLeft, waterfallInsets.left), displayCutout.getSafeInsetLeft());
            }
        } else {
            ZeroSides zeroSides = ZeroSides.NONE;
            if (!z) {
                zeroSides = m45875d();
            }
            this.f60756s.physicalViewPaddingTop = z2 ? windowInsets.getSystemWindowInsetTop() : 0;
            this.f60756s.physicalViewPaddingRight = (zeroSides == ZeroSides.RIGHT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetRight();
            this.f60756s.physicalViewPaddingBottom = (!z || m45870a(windowInsets) != 0) ? 0 : windowInsets.getSystemWindowInsetBottom();
            this.f60756s.physicalViewPaddingLeft = (zeroSides == ZeroSides.LEFT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetLeft();
            this.f60756s.physicalViewInsetTop = 0;
            this.f60756s.physicalViewInsetRight = 0;
            this.f60756s.physicalViewInsetBottom = m45870a(windowInsets);
            this.f60756s.physicalViewInsetLeft = 0;
        }
        m45879h();
        return super.onApplyWindowInsets(windowInsets);
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT > 19) {
            return super.fitSystemWindows(rect);
        }
        this.f60756s.physicalViewPaddingTop = rect.top;
        this.f60756s.physicalViewPaddingRight = rect.right;
        this.f60756s.physicalViewPaddingBottom = 0;
        this.f60756s.physicalViewPaddingLeft = rect.left;
        this.f60756s.physicalViewInsetTop = 0;
        this.f60756s.physicalViewInsetRight = 0;
        this.f60756s.physicalViewInsetBottom = rect.bottom;
        this.f60756s.physicalViewInsetLeft = 0;
        m45879h();
        return true;
    }

    /* renamed from: e */
    private boolean m45876e() {
        FlutterNativeView flutterNativeView = this.f60760w;
        return flutterNativeView != null && flutterNativeView.isAttached();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo182768a() {
        if (!m45876e()) {
            throw new AssertionError("Platform view is not attached");
        }
    }

    /* renamed from: f */
    private void m45877f() {
        mo182772b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo182772b() {
        AccessibilityBridge accessibilityBridge = this.f60754q;
        if (accessibilityBridge != null) {
            accessibilityBridge.reset();
        }
    }

    public void runFromBundle(FlutterRunArguments flutterRunArguments) {
        mo182768a();
        m45877f();
        this.f60760w.runFromBundle(flutterRunArguments);
        m45878g();
    }

    public Bitmap getBitmap() {
        mo182768a();
        return this.f60760w.mo182758a().getBitmap();
    }

    /* renamed from: h */
    private void m45879h() {
        if (m45876e()) {
            this.f60760w.mo182758a().setViewportMetrics(this.f60756s.devicePixelRatio, this.f60756s.physicalWidth, this.f60756s.physicalHeight, this.f60756s.physicalViewPaddingTop, this.f60756s.physicalViewPaddingRight, this.f60756s.physicalViewPaddingBottom, this.f60756s.physicalViewPaddingLeft, this.f60756s.physicalViewInsetTop, this.f60756s.physicalViewInsetRight, this.f60756s.physicalViewInsetBottom, this.f60756s.physicalViewInsetLeft, this.f60756s.systemGestureInsetTop, this.f60756s.systemGestureInsetRight, this.f60756s.systemGestureInsetBottom, this.f60756s.systemGestureInsetLeft, this.f60756s.physicalTouchSlop, new int[0], new int[0], new int[0]);
        }
    }

    public void onFirstFrame() {
        this.f60762y = true;
        for (FirstFrameListener onFirstFrame : new ArrayList(this.f60758u)) {
            onFirstFrame.onFirstFrame();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AccessibilityBridge accessibilityBridge = new AccessibilityBridge(this, new AccessibilityChannel(this.f60739b, getFlutterNativeView().mo182758a()), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), getPluginRegistry().getPlatformViewsController());
        this.f60754q = accessibilityBridge;
        accessibilityBridge.setOnAccessibilityChangeListener(this.f60763z);
        m45873a(this.f60754q.isAccessibilityEnabled(), this.f60754q.isTouchExplorationEnabled());
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m45880i();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m45873a(boolean z, boolean z2) {
        boolean z3 = false;
        if (!this.f60761x) {
            if (!z && !z2) {
                z3 = true;
            }
            setWillNotDraw(z3);
            return;
        }
        setWillNotDraw(false);
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        AccessibilityBridge accessibilityBridge = this.f60754q;
        if (accessibilityBridge == null || !accessibilityBridge.isAccessibilityEnabled()) {
            return null;
        }
        return this.f60754q;
    }

    /* renamed from: i */
    private void m45880i() {
        AccessibilityBridge accessibilityBridge = this.f60754q;
        if (accessibilityBridge != null) {
            accessibilityBridge.release();
            this.f60754q = null;
        }
    }

    public PointerIcon getSystemPointerIcon(int i) {
        return PointerIcon.getSystemIcon(getContext(), i);
    }

    public void send(String str, ByteBuffer byteBuffer) {
        send(str, byteBuffer, (BinaryMessenger.BinaryReply) null);
    }

    public void send(String str, ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
        if (!m45876e()) {
            Log.m45253d(f60738a, "FlutterView.send called on a detached view, channel=" + str);
            return;
        }
        this.f60760w.send(str, byteBuffer, binaryReply);
    }

    public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
        this.f60760w.setMessageHandler(str, binaryMessageHandler);
    }

    public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler, BinaryMessenger.TaskQueue taskQueue) {
        this.f60760w.setMessageHandler(str, binaryMessageHandler, taskQueue);
    }

    public TextureRegistry.SurfaceTextureEntry createSurfaceTexture() {
        return registerSurfaceTexture(new SurfaceTexture(0));
    }

    public TextureRegistry.SurfaceTextureEntry registerSurfaceTexture(SurfaceTexture surfaceTexture) {
        surfaceTexture.detachFromGLContext();
        SurfaceTextureRegistryEntry surfaceTextureRegistryEntry = new SurfaceTextureRegistryEntry(this.f60759v.getAndIncrement(), surfaceTexture);
        this.f60760w.mo182758a().registerTexture(surfaceTextureRegistryEntry.mo182404id(), surfaceTextureRegistryEntry.textureWrapper());
        return surfaceTextureRegistryEntry;
    }

    /* renamed from: io.flutter.view.FlutterView$SurfaceTextureRegistryEntry */
    final class SurfaceTextureRegistryEntry implements TextureRegistry.SurfaceTextureEntry {
        /* access modifiers changed from: private */

        /* renamed from: id */
        public final long f60764id;
        private SurfaceTexture.OnFrameAvailableListener onFrameListener = new SurfaceTexture.OnFrameAvailableListener() {
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                if (!SurfaceTextureRegistryEntry.this.released && FlutterView.this.f60760w != null) {
                    FlutterView.this.f60760w.mo182758a().markTextureFrameAvailable(SurfaceTextureRegistryEntry.this.f60764id);
                }
            }
        };
        /* access modifiers changed from: private */
        public boolean released;
        private final SurfaceTextureWrapper textureWrapper;

        SurfaceTextureRegistryEntry(long j, SurfaceTexture surfaceTexture) {
            this.f60764id = j;
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
            return this.f60764id;
        }

        public void release() {
            if (!this.released) {
                this.released = true;
                surfaceTexture().setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener) null);
                this.textureWrapper.release();
                FlutterView.this.f60760w.mo182758a().unregisterTexture(this.f60764id);
            }
        }
    }
}
