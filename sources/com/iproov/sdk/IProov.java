package com.iproov.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.iproov.sdk.cameray.Orientation;
import com.iproov.sdk.core.C20873if;
import com.iproov.sdk.core.C20886return;
import com.iproov.sdk.core.exception.CaptureAlreadyActiveException;
import com.iproov.sdk.core.exception.IProovException;
import com.iproov.sdk.core.exception.ListenerNotRegisteredException;
import com.iproov.sdk.core.exception.MultiWindowUnsupportedException;
import com.iproov.sdk.crypto.KeyPair;
import com.iproov.sdk.logging.IPLog;
import com.jumio.core.environment.Environment;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import p069native.C2947if;
import p095switch.C3679throw;

public final class IProov {

    /* renamed from: a */
    static final AtomicBoolean f56831a = new AtomicBoolean(false);

    /* renamed from: b */
    static C20873if f56832b = null;

    /* renamed from: c */
    private static final String f56833c = "IProov";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final Options f56834d = new Options();

    /* renamed from: e */
    private static C20747a f56835e = new C20747a();
    public static final NativeBridge nativeBridge = new NativeBridge();

    public enum Camera {
        FRONT,
        EXTERNAL
    }

    public enum FaceDetector {
        AUTO,
        CLASSIC,
        ML_KIT,
        BLAZEFACE
    }

    public static class FailureResult {
        public final String feedbackCode;
        public final Bitmap frame;
        public final String reason;
        public final String token;

        public FailureResult(String str, String str2, String str3, Bitmap bitmap) {
            this.token = str;
            this.reason = str2;
            this.feedbackCode = str3;
            this.frame = bitmap;
        }
    }

    public enum Filter {
        CLASSIC(1.0f),
        SHADED(0.75f),
        VIBRANT(0.0f);
        
        private final float alpha;

        private Filter(float f) {
            this.alpha = f;
        }

        public float getAlpha() {
            return this.alpha;
        }
    }

    public interface Listener {
        void onCancelled();

        void onConnected();

        void onConnecting();

        void onError(IProovException iProovException);

        void onFailure(FailureResult failureResult);

        void onProcessing(double d, String str);

        void onSuccess(SuccessResult successResult);
    }

    public static class Options {
        public Capture capture = new Capture();
        public Network network = new Network();

        /* renamed from: ui */
        public C20735UI f56836ui = new C20735UI();

        public static final class Capture {
            public Camera camera = Camera.FRONT;
            public FaceDetector faceDetector = FaceDetector.AUTO;
            public GenuinePresenceAssurance genuinePresenceAssurance = new GenuinePresenceAssurance();

            public static final class GenuinePresenceAssurance {
                public Float maxPitch = null;
                public Float maxRoll = null;
                public Float maxYaw = null;
            }
        }

        public static final class Network {
            public List<Object> certificates = new ArrayList(Collections.singletonList(Integer.valueOf(R.raw.iproov__certificate)));
            public String path = "/socket.io/v2/";
            public int timeoutSecs = 10;
        }

        /* renamed from: com.iproov.sdk.IProov$Options$UI */
        public static final class C20735UI {
            public Integer activityCompatibilityRequestCode = null;
            public int backgroundColor = Color.parseColor("#FAFAFA");
            public boolean enableScreenshots = false;
            public Filter filter = Filter.SHADED;
            public boolean floatingPromptEnabled = false;
            public String fontPath = null;
            public int fontResource = -1;
            public int footerBackgroundColor = Color.parseColor("#AA000000");
            @Deprecated
            public int footerTextColor = Color.parseColor("#FFFFFFFF");
            public GenuinePresenceAssurance genuinePresenceAssurance = new GenuinePresenceAssurance();
            public int headerBackgroundColor = Color.parseColor("#AA000000");
            public int headerTextColor = Color.parseColor("#FFFFFFFF");
            public int lineColor = Color.parseColor("#404040");
            public LivenessAssurance livenessAssurance = new LivenessAssurance();
            public Drawable logoImageDrawable = null;
            public int logoImageResource = -1;
            public Orientation orientation = Orientation.PORTRAIT;
            public int promptTextColor = Color.parseColor("#FFFFFFFF");
            public String title = null;

            /* renamed from: com.iproov.sdk.IProov$Options$UI$GenuinePresenceAssurance */
            public static final class GenuinePresenceAssurance {
                public boolean autoStartDisabled = false;
                public int notReadyTintColor = Color.parseColor("#f5a623");
                public int progressBarColor = Color.parseColor("#FF000000");
                public int readyTintColor = Color.parseColor("#01bf46");
            }

            /* renamed from: com.iproov.sdk.IProov$Options$UI$LivenessAssurance */
            public static final class LivenessAssurance {
                public int primaryTintColor = Color.parseColor("#1756E5");
                public int secondaryTintColor = Color.parseColor("#A8A8A8");
            }

            public int getPromptTextColor() {
                if (this.promptTextColor != IProov.f56834d.f56836ui.promptTextColor) {
                    return this.promptTextColor;
                }
                return this.footerTextColor;
            }
        }
    }

    public enum StreamingTransport {
        WEB_SOCKETS,
        POLLING,
        AUTO
    }

    public static class SuccessResult {
        public final Bitmap frame;
        public final String token;

        public SuccessResult(String str, Bitmap bitmap) {
            this.token = str;
            this.frame = bitmap;
        }
    }

    private IProov() {
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m42837b(Context context, String str, String str2, C20886return returnR) {
        try {
            C20873if ifVar = new C20873if(context, str, str2, returnR, f56835e);
            f56832b = ifVar;
            ifVar.m48128super();
        } catch (IProovException e) {
            e.printStackTrace();
            f56835e.onError(e);
        }
    }

    public static String getBuildHash() {
        return "1b8668f8 ";
    }

    public static String getBuildNumber() {
        return "6135";
    }

    public static C20873if getCaptureManager() {
        return f56832b;
    }

    public static KeyPair getKeyPair(Context context) throws IProovException {
        return new KeyPair(context);
    }

    public static String getSDKVersion() {
        return Environment.IPROOV_VERSION;
    }

    public static void launch(Context context, String str, String str2) throws IProovException {
        launch(context, str, str2, new Options());
    }

    public static void registerListener(Listener listener) {
        f56835e.mo171268a(listener, false);
    }

    public static void unregisterListener(Listener listener) {
        f56835e.mo171267a(listener);
    }

    public static void launch(Context context, String str, String str2, Options options) throws IProovException {
        m42836a(context, str, str2, new C20886return(options));
    }

    public static void registerListener(Listener listener, boolean z) {
        f56835e.mo171268a(listener, z);
    }

    /* renamed from: a */
    static void m42836a(Context context, String str, String str2, C20886return returnR) throws IProovException {
        if (!f56835e.mo171270a()) {
            throw new ListenerNotRegisteredException(context);
        } else if (Build.VERSION.SDK_INT >= 24 && (context instanceof Activity) && ((Activity) context).isInMultiWindowMode()) {
            throw new MultiWindowUnsupportedException(context);
        } else if (f56831a.compareAndSet(false, true)) {
            f56835e.mo171271b();
            IPLog.setLoggingEnabled(new C2947if(context).m46615final());
            C3679throw.m7442do((Runnable) new Runnable(context, str, str2, returnR) {
                public final /* synthetic */ Context f$0;
                public final /* synthetic */ String f$1;
                public final /* synthetic */ String f$2;
                public final /* synthetic */ C20886return f$3;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void run() {
                    IProov.m42837b(this.f$0, this.f$1, this.f$2, this.f$3);
                }
            });
        } else {
            throw new CaptureAlreadyActiveException(context);
        }
    }
}
