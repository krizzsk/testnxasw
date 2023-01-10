package p218io.flutter.plugin.platform;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import p218io.flutter.Log;
import p218io.flutter.embedding.android.AndroidTouchProcessor;
import p218io.flutter.embedding.android.FlutterImageView;
import p218io.flutter.embedding.android.FlutterView;
import p218io.flutter.embedding.android.MotionEventTracker;
import p218io.flutter.embedding.engine.FlutterOverlaySurface;
import p218io.flutter.embedding.engine.dart.DartExecutor;
import p218io.flutter.embedding.engine.mutatorsstack.FlutterMutatorView;
import p218io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import p218io.flutter.embedding.engine.renderer.FlutterRenderer;
import p218io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import p218io.flutter.plugin.editing.TextInputPlugin;
import p218io.flutter.plugin.platform.PlatformViewsController;
import p218io.flutter.view.AccessibilityBridge;
import p218io.flutter.view.TextureRegistry;

/* renamed from: io.flutter.plugin.platform.PlatformViewsController */
public class PlatformViewsController implements PlatformViewsAccessibilityDelegate {

    /* renamed from: c */
    private static final String f60626c = "PlatformViewsController";

    /* renamed from: a */
    final HashMap<Integer, VirtualDisplayController> f60627a = new HashMap<>();

    /* renamed from: b */
    final HashMap<Context, View> f60628b = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C22123b f60629d = new C22123b();

    /* renamed from: e */
    private AndroidTouchProcessor f60630e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Context f60631f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public FlutterView f60632g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TextureRegistry f60633h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public TextInputPlugin f60634i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public PlatformViewsChannel f60635j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final C22122a f60636k = new C22122a();
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final SparseArray<PlatformView> f60637l = new SparseArray<>();
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final SparseArray<FlutterMutatorView> f60638m = new SparseArray<>();

    /* renamed from: n */
    private final SparseArray<FlutterImageView> f60639n = new SparseArray<>();

    /* renamed from: o */
    private int f60640o = 0;

    /* renamed from: p */
    private boolean f60641p = false;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f60642q = true;

    /* renamed from: r */
    private final HashSet<Integer> f60643r = new HashSet<>();

    /* renamed from: s */
    private final HashSet<Integer> f60644s = new HashSet<>();

    /* renamed from: t */
    private final MotionEventTracker f60645t = MotionEventTracker.getInstance();

    /* renamed from: u */
    private final PlatformViewsChannel.PlatformViewsHandler f60646u = new PlatformViewsChannel.PlatformViewsHandler() {
        public void createAndroidViewForPlatformView(PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
            ensureValidAndroidVersion(19);
            if (PlatformViewsController.m45753c(platformViewCreationRequest.direction)) {
                PlatformViewFactory a = PlatformViewsController.this.f60629d.mo182689a(platformViewCreationRequest.viewType);
                if (a != null) {
                    Object obj = null;
                    if (platformViewCreationRequest.params != null) {
                        obj = a.getCreateArgsCodec().decodeMessage(platformViewCreationRequest.params);
                    }
                    PlatformView create = a.create(PlatformViewsController.this.f60631f, platformViewCreationRequest.viewId, obj);
                    create.getView().setLayoutDirection(platformViewCreationRequest.direction);
                    PlatformViewsController.this.f60637l.put(platformViewCreationRequest.viewId, create);
                    return;
                }
                throw new IllegalStateException("Trying to create a platform view of unregistered type: " + platformViewCreationRequest.viewType);
            }
            throw new IllegalStateException("Trying to create a view with unknown direction value: " + platformViewCreationRequest.direction + "(view id: " + platformViewCreationRequest.viewId + ")");
        }

        public void disposeAndroidViewForPlatformView(int i) {
            PlatformView platformView = (PlatformView) PlatformViewsController.this.f60637l.get(i);
            FlutterMutatorView flutterMutatorView = (FlutterMutatorView) PlatformViewsController.this.f60638m.get(i);
            if (platformView != null) {
                if (flutterMutatorView != null) {
                    flutterMutatorView.removeView(platformView.getView());
                }
                PlatformViewsController.this.f60637l.remove(i);
                platformView.dispose();
            }
            if (flutterMutatorView != null) {
                flutterMutatorView.unsetOnDescendantFocusChangeListener();
                ((ViewGroup) flutterMutatorView.getParent()).removeView(flutterMutatorView);
                PlatformViewsController.this.f60638m.remove(i);
            }
        }

        public long createVirtualDisplayForPlatformView(PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
            ensureValidAndroidVersion(20);
            if (!PlatformViewsController.m45753c(platformViewCreationRequest.direction)) {
                throw new IllegalStateException("Trying to create a view with unknown direction value: " + platformViewCreationRequest.direction + "(view id: " + platformViewCreationRequest.viewId + ")");
            } else if (!PlatformViewsController.this.f60627a.containsKey(Integer.valueOf(platformViewCreationRequest.viewId))) {
                PlatformViewFactory a = PlatformViewsController.this.f60629d.mo182689a(platformViewCreationRequest.viewType);
                if (a != null) {
                    Object obj = null;
                    if (platformViewCreationRequest.params != null) {
                        obj = a.getCreateArgsCodec().decodeMessage(platformViewCreationRequest.params);
                    }
                    Object obj2 = obj;
                    int a2 = PlatformViewsController.this.m45732a(platformViewCreationRequest.logicalWidth);
                    int a3 = PlatformViewsController.this.m45732a(platformViewCreationRequest.logicalHeight);
                    PlatformViewsController.this.m45737a(a2, a3);
                    TextureRegistry.SurfaceTextureEntry createSurfaceTexture = PlatformViewsController.this.f60633h.createSurfaceTexture();
                    VirtualDisplayController a4 = VirtualDisplayController.m45764a(PlatformViewsController.this.f60631f, PlatformViewsController.this.f60636k, a, createSurfaceTexture, a2, a3, platformViewCreationRequest.viewId, obj2, new View.OnFocusChangeListener(platformViewCreationRequest) {
                        public final /* synthetic */ PlatformViewsChannel.PlatformViewCreationRequest f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onFocusChange(View view, boolean z) {
                            PlatformViewsController.C221181.this.mo182663x2dd95fbd(this.f$1, view, z);
                        }
                    });
                    if (a4 != null) {
                        if (PlatformViewsController.this.f60632g != null) {
                            a4.mo182679a((View) PlatformViewsController.this.f60632g);
                        }
                        PlatformViewsController.this.f60627a.put(Integer.valueOf(platformViewCreationRequest.viewId), a4);
                        View e = a4.mo182683e();
                        e.setLayoutDirection(platformViewCreationRequest.direction);
                        PlatformViewsController.this.f60628b.put(e.getContext(), e);
                        return createSurfaceTexture.mo182404id();
                    }
                    throw new IllegalStateException("Failed creating virtual display for a " + platformViewCreationRequest.viewType + " with id: " + platformViewCreationRequest.viewId);
                }
                throw new IllegalStateException("Trying to create a platform view of unregistered type: " + platformViewCreationRequest.viewType);
            } else {
                throw new IllegalStateException("Trying to create an already created platform view, view id: " + platformViewCreationRequest.viewId);
            }
        }

        /* renamed from: lambda$createVirtualDisplayForPlatformView$0$PlatformViewsController$1 */
        public /* synthetic */ void mo182663x2dd95fbd(PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest, View view, boolean z) {
            if (z) {
                PlatformViewsController.this.f60635j.invokeViewFocused(platformViewCreationRequest.viewId);
            }
        }

        public void disposeVirtualDisplayForPlatformView(int i) {
            ensureValidAndroidVersion(20);
            VirtualDisplayController virtualDisplayController = PlatformViewsController.this.f60627a.get(Integer.valueOf(i));
            if (virtualDisplayController != null) {
                if (PlatformViewsController.this.f60634i != null) {
                    PlatformViewsController.this.f60634i.clearPlatformViewClient(i);
                }
                PlatformViewsController.this.f60628b.remove(virtualDisplayController.mo182683e().getContext());
                virtualDisplayController.mo182676a();
                PlatformViewsController.this.f60627a.remove(Integer.valueOf(i));
                return;
            }
            throw new IllegalStateException("Trying to dispose a platform view with unknown id: " + i);
        }

        public void resizePlatformView(PlatformViewsChannel.PlatformViewResizeRequest platformViewResizeRequest, Runnable runnable) {
            ensureValidAndroidVersion(20);
            VirtualDisplayController virtualDisplayController = PlatformViewsController.this.f60627a.get(Integer.valueOf(platformViewResizeRequest.viewId));
            if (virtualDisplayController != null) {
                int a = PlatformViewsController.this.m45732a(platformViewResizeRequest.newLogicalWidth);
                int a2 = PlatformViewsController.this.m45732a(platformViewResizeRequest.newLogicalHeight);
                PlatformViewsController.this.m45737a(a, a2);
                PlatformViewsController.this.m45741a(virtualDisplayController);
                virtualDisplayController.mo182677a(a, a2, new Runnable(virtualDisplayController, runnable) {
                    public final /* synthetic */ VirtualDisplayController f$1;
                    public final /* synthetic */ Runnable f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        PlatformViewsController.C221181.this.lambda$resizePlatformView$1$PlatformViewsController$1(this.f$1, this.f$2);
                    }
                });
                return;
            }
            throw new IllegalStateException("Trying to resize a platform view with unknown id: " + platformViewResizeRequest.viewId);
        }

        public /* synthetic */ void lambda$resizePlatformView$1$PlatformViewsController$1(VirtualDisplayController virtualDisplayController, Runnable runnable) {
            PlatformViewsController.this.m45749b(virtualDisplayController);
            runnable.run();
        }

        public void onTouch(PlatformViewsChannel.PlatformViewTouch platformViewTouch) {
            int i = platformViewTouch.viewId;
            float f = PlatformViewsController.this.f60631f.getResources().getDisplayMetrics().density;
            ensureValidAndroidVersion(20);
            if (PlatformViewsController.this.f60627a.containsKey(Integer.valueOf(i))) {
                PlatformViewsController.this.f60627a.get(Integer.valueOf(platformViewTouch.viewId)).mo182678a(PlatformViewsController.this.toMotionEvent(f, platformViewTouch, true));
            } else if (PlatformViewsController.this.f60637l.get(i) != null) {
                MotionEvent motionEvent = PlatformViewsController.this.toMotionEvent(f, platformViewTouch, false);
                View view = ((PlatformView) PlatformViewsController.this.f60637l.get(platformViewTouch.viewId)).getView();
                if (view != null) {
                    view.dispatchTouchEvent(motionEvent);
                }
            } else {
                throw new IllegalStateException("Sending touch to an unknown view with id: " + i);
            }
        }

        public void setDirection(int i, int i2) {
            if (PlatformViewsController.m45753c(i2)) {
                ensureValidAndroidVersion(20);
                PlatformView platformView = (PlatformView) PlatformViewsController.this.f60637l.get(i);
                if (platformView != null) {
                    platformView.getView().setLayoutDirection(i2);
                    return;
                }
                VirtualDisplayController virtualDisplayController = PlatformViewsController.this.f60627a.get(Integer.valueOf(i));
                if (virtualDisplayController != null) {
                    virtualDisplayController.mo182683e().setLayoutDirection(i2);
                    return;
                }
                throw new IllegalStateException("Trying to set direction: " + i2 + " to an unknown platform view with id: " + i);
            }
            throw new IllegalStateException("Trying to set unknown direction value: " + i2 + "(view id: " + i + ")");
        }

        public void clearFocus(int i) {
            PlatformView platformView = (PlatformView) PlatformViewsController.this.f60637l.get(i);
            if (platformView != null) {
                platformView.getView().clearFocus();
                return;
            }
            ensureValidAndroidVersion(20);
            PlatformViewsController.this.f60627a.get(Integer.valueOf(i)).mo182683e().clearFocus();
        }

        private void ensureValidAndroidVersion(int i) {
            if (Build.VERSION.SDK_INT < i) {
                throw new IllegalStateException("Trying to use platform views with API " + Build.VERSION.SDK_INT + ", required API level is: " + i);
            }
        }

        public void synchronizeToNativeViewHierarchy(boolean z) {
            boolean unused = PlatformViewsController.this.f60642q = z;
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static boolean m45753c(int i) {
        return i == 0 || i == 1;
    }

    public void onAttachedToJNI() {
    }

    public MotionEvent toMotionEvent(float f, PlatformViewsChannel.PlatformViewTouch platformViewTouch, boolean z) {
        PlatformViewsChannel.PlatformViewTouch platformViewTouch2 = platformViewTouch;
        MotionEvent pop = this.f60645t.pop(MotionEventTracker.MotionEventId.from(platformViewTouch2.motionEventId));
        MotionEvent.PointerProperties[] pointerPropertiesArr = (MotionEvent.PointerProperties[]) m45735a(platformViewTouch2.rawPointerPropertiesList).toArray(new MotionEvent.PointerProperties[platformViewTouch2.pointerCount]);
        MotionEvent.PointerCoords[] pointerCoordsArr = (MotionEvent.PointerCoords[]) m45736a(platformViewTouch2.rawPointerCoords, f).toArray(new MotionEvent.PointerCoords[platformViewTouch2.pointerCount]);
        if (!z && pop != null) {
            return MotionEvent.obtain(pop.getDownTime(), pop.getEventTime(), pop.getAction(), platformViewTouch2.pointerCount, pointerPropertiesArr, pointerCoordsArr, pop.getMetaState(), pop.getButtonState(), pop.getXPrecision(), pop.getYPrecision(), pop.getDeviceId(), pop.getEdgeFlags(), pop.getSource(), pop.getFlags());
        }
        return MotionEvent.obtain(platformViewTouch2.downTime.longValue(), platformViewTouch2.eventTime.longValue(), platformViewTouch2.action, platformViewTouch2.pointerCount, pointerPropertiesArr, pointerCoordsArr, platformViewTouch2.metaState, platformViewTouch2.buttonState, platformViewTouch2.xPrecision, platformViewTouch2.yPrecision, platformViewTouch2.deviceId, platformViewTouch2.edgeFlags, platformViewTouch2.source, platformViewTouch2.flags);
    }

    public void attach(Context context, TextureRegistry textureRegistry, DartExecutor dartExecutor) {
        if (this.f60631f == null) {
            this.f60631f = context;
            this.f60633h = textureRegistry;
            PlatformViewsChannel platformViewsChannel = new PlatformViewsChannel(dartExecutor);
            this.f60635j = platformViewsChannel;
            platformViewsChannel.setPlatformViewsHandler(this.f60646u);
            return;
        }
        throw new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
    }

    public void detach() {
        PlatformViewsChannel platformViewsChannel = this.f60635j;
        if (platformViewsChannel != null) {
            platformViewsChannel.setPlatformViewsHandler((PlatformViewsChannel.PlatformViewsHandler) null);
        }
        destroyOverlaySurfaces();
        this.f60635j = null;
        this.f60631f = null;
        this.f60633h = null;
    }

    public void attachToView(FlutterView flutterView) {
        this.f60632g = flutterView;
        for (VirtualDisplayController a : this.f60627a.values()) {
            a.mo182679a((View) flutterView);
        }
    }

    public void detachFromView() {
        destroyOverlaySurfaces();
        m45755d();
        this.f60632g = null;
        this.f60641p = false;
        for (VirtualDisplayController b : this.f60627a.values()) {
            b.mo182680b();
        }
    }

    public void attachAccessibilityBridge(AccessibilityBridge accessibilityBridge) {
        this.f60636k.mo182687a(accessibilityBridge);
    }

    public void detachAccessibilityBridge() {
        this.f60636k.mo182687a((AccessibilityBridge) null);
    }

    public void attachTextInputPlugin(TextInputPlugin textInputPlugin) {
        this.f60634i = textInputPlugin;
    }

    public void detachTextInputPlugin() {
        this.f60634i = null;
    }

    public boolean checkInputConnectionProxy(View view) {
        if (view == null || !this.f60628b.containsKey(view.getContext())) {
            return false;
        }
        View view2 = this.f60628b.get(view.getContext());
        if (view2 == view) {
            return true;
        }
        return view2.checkInputConnectionProxy(view);
    }

    public PlatformViewRegistry getRegistry() {
        return this.f60629d;
    }

    public void onDetachedFromJNI() {
        m45747b();
    }

    public void onPreEngineRestart() {
        m45747b();
    }

    public View getPlatformViewById(Integer num) {
        if (this.f60637l.get(num.intValue()) != null) {
            return this.f60637l.get(num.intValue()).getView();
        }
        VirtualDisplayController virtualDisplayController = this.f60627a.get(num);
        if (virtualDisplayController == null) {
            return null;
        }
        return virtualDisplayController.mo182683e();
    }

    public boolean usesVirtualDisplay(Integer num) {
        return this.f60627a.containsKey(num);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m45741a(VirtualDisplayController virtualDisplayController) {
        TextInputPlugin textInputPlugin = this.f60634i;
        if (textInputPlugin != null) {
            textInputPlugin.lockPlatformViewInputConnection();
            virtualDisplayController.mo182681c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m45749b(VirtualDisplayController virtualDisplayController) {
        TextInputPlugin textInputPlugin = this.f60634i;
        if (textInputPlugin != null) {
            textInputPlugin.unlockPlatformViewInputConnection();
            virtualDisplayController.mo182682d();
        }
    }

    /* renamed from: a */
    private static List<MotionEvent.PointerProperties> m45735a(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Object b : (List) obj) {
            arrayList.add(m45746b(b));
        }
        return arrayList;
    }

    /* renamed from: b */
    private static MotionEvent.PointerProperties m45746b(Object obj) {
        List list = (List) obj;
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.id = ((Integer) list.get(0)).intValue();
        pointerProperties.toolType = ((Integer) list.get(1)).intValue();
        return pointerProperties;
    }

    /* renamed from: a */
    private static List<MotionEvent.PointerCoords> m45736a(Object obj, float f) {
        ArrayList arrayList = new ArrayList();
        for (Object b : (List) obj) {
            arrayList.add(m45745b(b, f));
        }
        return arrayList;
    }

    /* renamed from: b */
    private static MotionEvent.PointerCoords m45745b(Object obj, float f) {
        List list = (List) obj;
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.orientation = (float) ((Double) list.get(0)).doubleValue();
        pointerCoords.pressure = (float) ((Double) list.get(1)).doubleValue();
        pointerCoords.size = (float) ((Double) list.get(2)).doubleValue();
        pointerCoords.toolMajor = ((float) ((Double) list.get(3)).doubleValue()) * f;
        pointerCoords.toolMinor = ((float) ((Double) list.get(4)).doubleValue()) * f;
        pointerCoords.touchMajor = ((float) ((Double) list.get(5)).doubleValue()) * f;
        pointerCoords.touchMinor = ((float) ((Double) list.get(6)).doubleValue()) * f;
        pointerCoords.x = ((float) ((Double) list.get(7)).doubleValue()) * f;
        pointerCoords.y = ((float) ((Double) list.get(8)).doubleValue()) * f;
        return pointerCoords;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m45737a(int i, int i2) {
        DisplayMetrics displayMetrics = this.f60631f.getResources().getDisplayMetrics();
        if (i2 > displayMetrics.heightPixels || i > displayMetrics.widthPixels) {
            Log.m45261w(f60626c, "Creating a virtual display of size: [" + i + ", " + i2 + "] may result in problems(https://github.com/flutter/flutter/issues/2897).It is larger than the device screen size: [" + displayMetrics.widthPixels + ", " + displayMetrics.heightPixels + "].");
        }
    }

    /* renamed from: a */
    private float m45731a() {
        return this.f60631f.getResources().getDisplayMetrics().density;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m45732a(double d) {
        return (int) Math.round(d * ((double) m45731a()));
    }

    /* renamed from: b */
    private void m45747b() {
        for (VirtualDisplayController a : this.f60627a.values()) {
            a.mo182676a();
        }
        this.f60627a.clear();
        while (this.f60637l.size() > 0) {
            this.f60646u.disposeAndroidViewForPlatformView(this.f60637l.keyAt(0));
        }
        if (this.f60628b.size() > 0) {
            this.f60628b.clear();
        }
    }

    /* renamed from: c */
    private void m45752c() {
        if (this.f60642q && !this.f60641p) {
            this.f60632g.convertToImageView();
            this.f60641p = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo182642a(int i) {
        PlatformView platformView = this.f60637l.get(i);
        if (platformView == null) {
            throw new IllegalStateException("Platform view hasn't been initialized from the platform view channel.");
        } else if (this.f60638m.get(i) == null) {
            if (platformView.getView() == null) {
                throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
            } else if (platformView.getView().getParent() == null) {
                Context context = this.f60631f;
                FlutterMutatorView flutterMutatorView = new FlutterMutatorView(context, context.getResources().getDisplayMetrics().density, this.f60630e);
                flutterMutatorView.setOnDescendantFocusChangeListener(new View.OnFocusChangeListener(i) {
                    public final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onFocusChange(View view, boolean z) {
                        PlatformViewsController.this.m45738a(this.f$1, view, z);
                    }
                });
                this.f60638m.put(i, flutterMutatorView);
                flutterMutatorView.addView(platformView.getView());
                this.f60632g.addView(flutterMutatorView);
            } else {
                throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m45738a(int i, View view, boolean z) {
        if (z) {
            this.f60635j.invokeViewFocused(i);
            return;
        }
        TextInputPlugin textInputPlugin = this.f60634i;
        if (textInputPlugin != null) {
            textInputPlugin.clearPlatformViewClient(i);
        }
    }

    public void attachToFlutterRenderer(FlutterRenderer flutterRenderer) {
        this.f60630e = new AndroidTouchProcessor(flutterRenderer, true);
    }

    public void onDisplayPlatformView(int i, int i2, int i3, int i4, int i5, int i6, int i7, FlutterMutatorsStack flutterMutatorsStack) {
        m45752c();
        mo182642a(i);
        FlutterMutatorView flutterMutatorView = this.f60638m.get(i);
        flutterMutatorView.readyToDisplay(flutterMutatorsStack, i2, i3, i4, i5);
        flutterMutatorView.setVisibility(0);
        flutterMutatorView.bringToFront();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i6, i7);
        View view = this.f60637l.get(i).getView();
        if (view != null) {
            view.setLayoutParams(layoutParams);
            view.bringToFront();
        }
        this.f60644s.add(Integer.valueOf(i));
    }

    public void onDisplayOverlaySurface(int i, int i2, int i3, int i4, int i5) {
        if (this.f60639n.get(i) != null) {
            m45752c();
            FlutterImageView flutterImageView = this.f60639n.get(i);
            if (flutterImageView.getParent() == null) {
                this.f60632g.addView(flutterImageView);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, i5);
            layoutParams.leftMargin = i2;
            layoutParams.topMargin = i3;
            flutterImageView.setLayoutParams(layoutParams);
            flutterImageView.setVisibility(0);
            flutterImageView.bringToFront();
            this.f60643r.add(Integer.valueOf(i));
            return;
        }
        throw new IllegalStateException("The overlay surface (id:" + i + ") doesn't exist");
    }

    public void onBeginFrame() {
        this.f60643r.clear();
        this.f60644s.clear();
    }

    public void onEndFrame() {
        boolean z = false;
        if (!this.f60641p || !this.f60644s.isEmpty()) {
            if (this.f60641p && this.f60632g.acquireLatestImageViewFrame()) {
                z = true;
            }
            m45742a(z);
            return;
        }
        this.f60641p = false;
        this.f60632g.revertImageView(new Runnable() {
            public final void run() {
                PlatformViewsController.this.m45757e();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m45757e() {
        m45742a(false);
    }

    /* renamed from: a */
    private void m45742a(boolean z) {
        for (int i = 0; i < this.f60639n.size(); i++) {
            int keyAt = this.f60639n.keyAt(i);
            FlutterImageView valueAt = this.f60639n.valueAt(i);
            if (this.f60643r.contains(Integer.valueOf(keyAt))) {
                this.f60632g.attachOverlaySurfaceToRender(valueAt);
                z &= valueAt.acquireLatestImage();
            } else {
                if (!this.f60641p) {
                    valueAt.detachFromRenderer();
                }
                valueAt.setVisibility(8);
            }
        }
        for (int i2 = 0; i2 < this.f60638m.size(); i2++) {
            int keyAt2 = this.f60638m.keyAt(i2);
            View view = this.f60638m.get(keyAt2);
            if (!this.f60644s.contains(Integer.valueOf(keyAt2)) || (!z && this.f60642q)) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
    }

    public FlutterOverlaySurface createOverlaySurface(FlutterImageView flutterImageView) {
        int i = this.f60640o;
        this.f60640o = i + 1;
        this.f60639n.put(i, flutterImageView);
        return new FlutterOverlaySurface(i, flutterImageView.getSurface());
    }

    public FlutterOverlaySurface createOverlaySurface() {
        return createOverlaySurface(new FlutterImageView(this.f60632g.getContext(), this.f60632g.getWidth(), this.f60632g.getHeight(), FlutterImageView.SurfaceKind.overlay));
    }

    public void destroyOverlaySurfaces() {
        for (int i = 0; i < this.f60639n.size(); i++) {
            FlutterImageView valueAt = this.f60639n.valueAt(i);
            valueAt.detachFromRenderer();
            valueAt.closeImageReader();
        }
    }

    /* renamed from: d */
    private void m45755d() {
        if (this.f60632g == null) {
            Log.m45255e(f60626c, "removeOverlaySurfaces called while flutter view is null");
            return;
        }
        for (int i = 0; i < this.f60639n.size(); i++) {
            this.f60632g.removeView(this.f60639n.valueAt(i));
        }
        this.f60639n.clear();
    }
}
