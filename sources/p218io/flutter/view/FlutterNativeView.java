package p218io.flutter.view;

import android.app.Activity;
import android.content.Context;
import java.nio.ByteBuffer;
import java.util.List;
import p218io.flutter.Log;
import p218io.flutter.app.FlutterPluginRegistry;
import p218io.flutter.embedding.engine.FlutterEngine;
import p218io.flutter.embedding.engine.FlutterJNI;
import p218io.flutter.embedding.engine.dart.DartExecutor;
import p218io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import p218io.flutter.plugin.common.BinaryMessenger;

@Deprecated
/* renamed from: io.flutter.view.FlutterNativeView */
public class FlutterNativeView implements BinaryMessenger {

    /* renamed from: a */
    private static final String f60730a = "FlutterNativeView";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final FlutterPluginRegistry f60731b;

    /* renamed from: c */
    private final DartExecutor f60732c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public FlutterView f60733d;

    /* renamed from: e */
    private final FlutterJNI f60734e;

    /* renamed from: f */
    private final Context f60735f;

    /* renamed from: g */
    private boolean f60736g;

    /* renamed from: h */
    private final FlutterUiDisplayListener f60737h;

    public void disableBufferingIncomingMessages() {
    }

    public void enableBufferingIncomingMessages() {
    }

    public /* synthetic */ BinaryMessenger.TaskQueue makeBackgroundTaskQueue() {
        return BinaryMessenger.CC.$default$makeBackgroundTaskQueue(this);
    }

    public FlutterNativeView(Context context) {
        this(context, false);
    }

    public FlutterNativeView(Context context, boolean z) {
        this.f60737h = new FlutterUiDisplayListener() {
            public void onFlutterUiNoLongerDisplayed() {
            }

            public void onFlutterUiDisplayed() {
                if (FlutterNativeView.this.f60733d != null) {
                    FlutterNativeView.this.f60733d.onFirstFrame();
                }
            }
        };
        if (z) {
            Log.m45261w(f60730a, "'isBackgroundView' is no longer supported and will be ignored");
        }
        this.f60735f = context;
        this.f60731b = new FlutterPluginRegistry(this, context);
        FlutterJNI flutterJNI = new FlutterJNI();
        this.f60734e = flutterJNI;
        flutterJNI.addIsDisplayingFlutterUiListener(this.f60737h);
        this.f60732c = new DartExecutor(this.f60734e, context.getAssets());
        this.f60734e.addEngineLifecycleListener(new EngineLifecycleListenerImpl());
        m45868c(this);
        assertAttached();
    }

    public void detachFromFlutterView() {
        this.f60731b.detach();
        this.f60733d = null;
    }

    public void destroy() {
        this.f60731b.destroy();
        this.f60732c.onDetachedFromJNI();
        this.f60733d = null;
        this.f60734e.removeIsDisplayingFlutterUiListener(this.f60737h);
        this.f60734e.detachFromNativeAndReleaseResources();
        this.f60736g = false;
    }

    public DartExecutor getDartExecutor() {
        return this.f60732c;
    }

    public FlutterPluginRegistry getPluginRegistry() {
        return this.f60731b;
    }

    public void attachViewAndActivity(FlutterView flutterView, Activity activity) {
        this.f60733d = flutterView;
        this.f60731b.attach(flutterView, activity);
    }

    public boolean isAttached() {
        return this.f60734e.isAttached();
    }

    public void assertAttached() {
        if (!isAttached()) {
            throw new AssertionError("Platform view is not attached");
        }
    }

    public void runFromBundle(FlutterRunArguments flutterRunArguments) {
        if (flutterRunArguments.entrypoint != null) {
            assertAttached();
            if (!this.f60736g) {
                this.f60734e.runBundleAndSnapshotFromLibrary(flutterRunArguments.bundlePath, flutterRunArguments.entrypoint, flutterRunArguments.libraryPath, this.f60735f.getResources().getAssets(), (List<String>) null);
                this.f60736g = true;
                return;
            }
            throw new AssertionError("This Flutter engine instance is already running an application");
        }
        throw new AssertionError("An entrypoint must be specified");
    }

    public boolean isApplicationRunning() {
        return this.f60736g;
    }

    public static String getObservatoryUri() {
        return FlutterJNI.getObservatoryUri();
    }

    public BinaryMessenger.TaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions) {
        return this.f60732c.getBinaryMessenger().makeBackgroundTaskQueue(taskQueueOptions);
    }

    public void send(String str, ByteBuffer byteBuffer) {
        this.f60732c.getBinaryMessenger().send(str, byteBuffer);
    }

    public void send(String str, ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
        if (!isAttached()) {
            Log.m45253d(f60730a, "FlutterView.send called on a detached view, channel=" + str);
            return;
        }
        this.f60732c.getBinaryMessenger().send(str, byteBuffer, binaryReply);
    }

    public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
        this.f60732c.getBinaryMessenger().setMessageHandler(str, binaryMessageHandler);
    }

    public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler, BinaryMessenger.TaskQueue taskQueue) {
        this.f60732c.getBinaryMessenger().setMessageHandler(str, binaryMessageHandler, taskQueue);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public FlutterJNI mo182758a() {
        return this.f60734e;
    }

    /* renamed from: c */
    private void m45868c(FlutterNativeView flutterNativeView) {
        this.f60734e.attachToNative();
        this.f60732c.onAttachedToJNI();
    }

    /* renamed from: io.flutter.view.FlutterNativeView$EngineLifecycleListenerImpl */
    private final class EngineLifecycleListenerImpl implements FlutterEngine.EngineLifecycleListener {
        public void onEngineWillDestroy() {
        }

        private EngineLifecycleListenerImpl() {
        }

        public void onPreEngineRestart() {
            if (FlutterNativeView.this.f60733d != null) {
                FlutterNativeView.this.f60733d.mo182772b();
            }
            if (FlutterNativeView.this.f60731b != null) {
                FlutterNativeView.this.f60731b.onPreEngineRestart();
            }
        }
    }
}
