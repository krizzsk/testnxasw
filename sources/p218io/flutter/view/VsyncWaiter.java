package p218io.flutter.view;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.view.Choreographer;
import java.util.Objects;
import p218io.flutter.embedding.engine.FlutterJNI;

/* renamed from: io.flutter.view.VsyncWaiter */
public class VsyncWaiter {

    /* renamed from: a */
    private static VsyncWaiter f60765a;

    /* renamed from: b */
    private static DisplayListener f60766b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public long f60767c = -1;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public FlutterJNI f60768d;

    /* renamed from: e */
    private final FlutterJNI.AsyncWaitForVsyncDelegate f60769e = new FlutterJNI.AsyncWaitForVsyncDelegate() {
        public void asyncWaitForVsync(final long j) {
            Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
                public void doFrame(long j) {
                    long nanoTime = System.nanoTime() - j;
                    VsyncWaiter.this.f60768d.onVsync(nanoTime < 0 ? 0 : nanoTime, VsyncWaiter.this.f60767c, j);
                }
            });
        }
    };

    /* renamed from: io.flutter.view.VsyncWaiter$DisplayListener */
    class DisplayListener implements DisplayManager.DisplayListener {
        private DisplayManager displayManager;

        public void onDisplayAdded(int i) {
        }

        public void onDisplayRemoved(int i) {
        }

        DisplayListener(DisplayManager displayManager2) {
            this.displayManager = displayManager2;
        }

        /* access modifiers changed from: package-private */
        public void register() {
            this.displayManager.registerDisplayListener(this, (Handler) null);
        }

        public void onDisplayChanged(int i) {
            if (i == 0) {
                float refreshRate = this.displayManager.getDisplay(0).getRefreshRate();
                long unused = VsyncWaiter.this.f60767c = (long) (1.0E9d / ((double) refreshRate));
                VsyncWaiter.this.f60768d.setRefreshRateFPS(refreshRate);
            }
        }
    }

    public static VsyncWaiter getInstance(float f, FlutterJNI flutterJNI) {
        if (f60765a == null) {
            f60765a = new VsyncWaiter(flutterJNI);
        }
        flutterJNI.setRefreshRateFPS(f);
        VsyncWaiter vsyncWaiter = f60765a;
        vsyncWaiter.f60767c = (long) (1.0E9d / ((double) f));
        return vsyncWaiter;
    }

    public static VsyncWaiter getInstance(DisplayManager displayManager, FlutterJNI flutterJNI) {
        if (f60765a == null) {
            f60765a = new VsyncWaiter(flutterJNI);
        }
        if (f60766b == null) {
            VsyncWaiter vsyncWaiter = f60765a;
            Objects.requireNonNull(vsyncWaiter);
            DisplayListener displayListener = new DisplayListener(displayManager);
            f60766b = displayListener;
            displayListener.register();
        }
        if (f60765a.f60767c == -1) {
            float refreshRate = displayManager.getDisplay(0).getRefreshRate();
            f60765a.f60767c = (long) (1.0E9d / ((double) refreshRate));
            flutterJNI.setRefreshRateFPS(refreshRate);
        }
        return f60765a;
    }

    public static void reset() {
        f60765a = null;
        f60766b = null;
    }

    private VsyncWaiter(FlutterJNI flutterJNI) {
        this.f60768d = flutterJNI;
    }

    public void init() {
        this.f60768d.setAsyncWaitForVsyncDelegate(this.f60769e);
    }
}
