package p218io.flutter.plugin.platform;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewTreeObserver;
import com.didi.sdk.apm.SystemUtils;
import p218io.flutter.plugin.platform.SingleViewPresentation;
import p218io.flutter.view.TextureRegistry;

/* renamed from: io.flutter.plugin.platform.VirtualDisplayController */
class VirtualDisplayController {

    /* renamed from: a */
    SingleViewPresentation f60647a;

    /* renamed from: b */
    private final Context f60648b;

    /* renamed from: c */
    private final C22122a f60649c;

    /* renamed from: d */
    private final int f60650d;

    /* renamed from: e */
    private final TextureRegistry.SurfaceTextureEntry f60651e;

    /* renamed from: f */
    private final View.OnFocusChangeListener f60652f;

    /* renamed from: g */
    private VirtualDisplay f60653g;

    /* renamed from: h */
    private final Surface f60654h;

    /* renamed from: a */
    public static VirtualDisplayController m45764a(Context context, C22122a aVar, PlatformViewFactory platformViewFactory, TextureRegistry.SurfaceTextureEntry surfaceTextureEntry, int i, int i2, int i3, Object obj, View.OnFocusChangeListener onFocusChangeListener) {
        int i4 = i;
        int i5 = i2;
        surfaceTextureEntry.surfaceTexture().setDefaultBufferSize(i4, i5);
        Surface surface = new Surface(surfaceTextureEntry.surfaceTexture());
        Context context2 = context;
        VirtualDisplay createVirtualDisplay = ((DisplayManager) context.getSystemService("display")).createVirtualDisplay("flutter-vd", i4, i5, context.getResources().getDisplayMetrics().densityDpi, surface, 0);
        if (createVirtualDisplay == null) {
            return null;
        }
        return new VirtualDisplayController(context, aVar, createVirtualDisplay, platformViewFactory, surface, surfaceTextureEntry, onFocusChangeListener, i3, obj);
    }

    private VirtualDisplayController(Context context, C22122a aVar, VirtualDisplay virtualDisplay, PlatformViewFactory platformViewFactory, Surface surface, TextureRegistry.SurfaceTextureEntry surfaceTextureEntry, View.OnFocusChangeListener onFocusChangeListener, int i, Object obj) {
        Context context2 = context;
        this.f60648b = context2;
        C22122a aVar2 = aVar;
        this.f60649c = aVar2;
        this.f60651e = surfaceTextureEntry;
        View.OnFocusChangeListener onFocusChangeListener2 = onFocusChangeListener;
        this.f60652f = onFocusChangeListener2;
        this.f60654h = surface;
        this.f60653g = virtualDisplay;
        this.f60650d = context.getResources().getDisplayMetrics().densityDpi;
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(context2, this.f60653g.getDisplay(), platformViewFactory, aVar2, i, obj, onFocusChangeListener2);
        this.f60647a = singleViewPresentation;
        SystemUtils.showDialog(singleViewPresentation);
    }

    /* renamed from: a */
    public void mo182677a(int i, int i2, Runnable runnable) {
        boolean isFocused = mo182683e().isFocused();
        SingleViewPresentation.PresentationState detachState = this.f60647a.detachState();
        this.f60653g.setSurface((Surface) null);
        this.f60653g.release();
        this.f60651e.surfaceTexture().setDefaultBufferSize(i, i2);
        this.f60653g = ((DisplayManager) this.f60648b.getSystemService("display")).createVirtualDisplay("flutter-vd", i, i2, this.f60650d, this.f60654h, 0);
        final View e = mo182683e();
        final Runnable runnable2 = runnable;
        e.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            public void onViewDetachedFromWindow(View view) {
            }

            public void onViewAttachedToWindow(View view) {
                OneTimeOnDrawListener.schedule(e, new Runnable() {
                    public void run() {
                        e.postDelayed(runnable2, 128);
                    }
                });
                e.removeOnAttachStateChangeListener(this);
            }
        });
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(this.f60648b, this.f60653g.getDisplay(), this.f60649c, detachState, this.f60652f, isFocused);
        SystemUtils.showDialog(singleViewPresentation);
        this.f60647a.cancel();
        this.f60647a = singleViewPresentation;
    }

    /* renamed from: a */
    public void mo182676a() {
        PlatformView view = this.f60647a.getView();
        this.f60647a.cancel();
        this.f60647a.detachState();
        view.dispose();
        this.f60653g.release();
        this.f60651e.release();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo182679a(View view) {
        SingleViewPresentation singleViewPresentation = this.f60647a;
        if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
            this.f60647a.getView().onFlutterViewAttached(view);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo182680b() {
        SingleViewPresentation singleViewPresentation = this.f60647a;
        if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
            this.f60647a.getView().onFlutterViewDetached();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo182681c() {
        SingleViewPresentation singleViewPresentation = this.f60647a;
        if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
            this.f60647a.getView().onInputConnectionLocked();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo182682d() {
        SingleViewPresentation singleViewPresentation = this.f60647a;
        if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
            this.f60647a.getView().onInputConnectionUnlocked();
        }
    }

    /* renamed from: e */
    public View mo182683e() {
        SingleViewPresentation singleViewPresentation = this.f60647a;
        if (singleViewPresentation == null) {
            return null;
        }
        return singleViewPresentation.getView().getView();
    }

    /* renamed from: a */
    public void mo182678a(MotionEvent motionEvent) {
        SingleViewPresentation singleViewPresentation = this.f60647a;
        if (singleViewPresentation != null) {
            singleViewPresentation.dispatchTouchEvent(motionEvent);
        }
    }

    /* renamed from: io.flutter.plugin.platform.VirtualDisplayController$OneTimeOnDrawListener */
    static class OneTimeOnDrawListener implements ViewTreeObserver.OnDrawListener {
        Runnable mOnDrawRunnable;
        final View mView;

        static void schedule(View view, Runnable runnable) {
            view.getViewTreeObserver().addOnDrawListener(new OneTimeOnDrawListener(view, runnable));
        }

        OneTimeOnDrawListener(View view, Runnable runnable) {
            this.mView = view;
            this.mOnDrawRunnable = runnable;
        }

        public void onDraw() {
            Runnable runnable = this.mOnDrawRunnable;
            if (runnable != null) {
                runnable.run();
                this.mOnDrawRunnable = null;
                this.mView.post(new Runnable() {
                    public void run() {
                        OneTimeOnDrawListener.this.mView.getViewTreeObserver().removeOnDrawListener(OneTimeOnDrawListener.this);
                    }
                });
            }
        }
    }
}
