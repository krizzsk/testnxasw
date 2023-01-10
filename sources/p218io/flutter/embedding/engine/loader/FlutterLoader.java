package p218io.flutter.embedding.engine.loader;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.WindowManager;
import androidx.tracing.Trace;
import com.didi.sdk.apm.SystemUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import p218io.flutter.FlutterInjector;
import p218io.flutter.Log;
import p218io.flutter.embedding.engine.FlutterJNI;
import p218io.flutter.embedding.engine.loader.FlutterLoader;
import p218io.flutter.util.PathUtils;
import p218io.flutter.view.VsyncWaiter;

/* renamed from: io.flutter.embedding.engine.loader.FlutterLoader */
public class FlutterLoader {

    /* renamed from: a */
    static final String f60406a = "aot-shared-library-name";

    /* renamed from: b */
    static final String f60407b = "aot-vmservice-shared-library-name";

    /* renamed from: c */
    static final String f60408c = "snapshot-asset-path";

    /* renamed from: d */
    static final String f60409d = "vm-snapshot-data";

    /* renamed from: e */
    static final String f60410e = "isolate-snapshot-data";

    /* renamed from: f */
    static final String f60411f = "flutter-assets-dir";

    /* renamed from: g */
    static final String f60412g = "automatically-register-plugins";

    /* renamed from: i */
    private static final String f60413i = "FlutterLoader";

    /* renamed from: j */
    private static final String f60414j = "io.flutter.embedding.android.OldGenHeapSize";

    /* renamed from: k */
    private static final String f60415k = "io.flutter.embedding.android.EnableSkParagraph";

    /* renamed from: l */
    private static final String f60416l = "libflutter.so";

    /* renamed from: m */
    private static final String f60417m = "kernel_blob.bin";

    /* renamed from: n */
    private static final String f60418n = "libvmservice_snapshot.so";

    /* renamed from: o */
    private static FlutterLoader f60419o;

    /* renamed from: h */
    Future<InitResult> f60420h;

    /* renamed from: p */
    private boolean f60421p;

    /* renamed from: q */
    private Settings f60422q;

    /* renamed from: r */
    private long f60423r;

    /* renamed from: s */
    private FlutterApplicationInfo f60424s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public FlutterJNI f60425t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public ExecutorService f60426u;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public ResourceExtractor m45573a(Context context) {
        return null;
    }

    public FlutterLoader() {
        this(FlutterInjector.instance().getFlutterJNIFactory().provideFlutterJNI());
    }

    public FlutterLoader(FlutterJNI flutterJNI) {
        this(flutterJNI, FlutterInjector.instance().executorService());
    }

    public FlutterLoader(FlutterJNI flutterJNI, ExecutorService executorService) {
        this.f60421p = false;
        this.f60425t = flutterJNI;
        this.f60426u = executorService;
    }

    /* renamed from: io.flutter.embedding.engine.loader.FlutterLoader$InitResult */
    private static class InitResult {
        final String appStoragePath;
        final String dataDirPath;
        final String engineCachesPath;

        private InitResult(String str, String str2, String str3) {
            this.appStoragePath = str;
            this.engineCachesPath = str2;
            this.dataDirPath = str3;
        }
    }

    public void startInitialization(Context context) {
        startInitialization(context, new Settings());
    }

    public void startInitialization(Context context, Settings settings) {
        VsyncWaiter vsyncWaiter;
        if (this.f60422q == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                Trace.beginSection("FlutterLoader#startInitialization");
                try {
                    final Context applicationContext = context.getApplicationContext();
                    this.f60422q = settings;
                    this.f60423r = SystemClock.uptimeMillis();
                    this.f60424s = ApplicationInfoLoader.load(applicationContext);
                    if (Build.VERSION.SDK_INT >= 17) {
                        vsyncWaiter = VsyncWaiter.getInstance((DisplayManager) applicationContext.getSystemService("display"), this.f60425t);
                    } else {
                        vsyncWaiter = VsyncWaiter.getInstance(((WindowManager) applicationContext.getSystemService("window")).getDefaultDisplay().getRefreshRate(), this.f60425t);
                    }
                    vsyncWaiter.init();
                    this.f60420h = this.f60426u.submit(new Callable<InitResult>() {
                        public InitResult call() {
                            Trace.beginSection("FlutterLoader initTask");
                            try {
                                ResourceExtractor a = FlutterLoader.this.m45573a(applicationContext);
                                FlutterLoader.this.f60425t.loadLibrary();
                                FlutterLoader.this.f60426u.execute(new Runnable() {
                                    public final void run() {
                                        FlutterLoader.C220831.this.lambda$call$0$FlutterLoader$1();
                                    }
                                });
                                if (a != null) {
                                    a.mo182346b();
                                }
                                return new InitResult(PathUtils.getFilesDir(applicationContext), PathUtils.getCacheDirectory(applicationContext), PathUtils.getDataDirectory(applicationContext));
                            } finally {
                                Trace.endSection();
                            }
                        }

                        public /* synthetic */ void lambda$call$0$FlutterLoader$1() {
                            FlutterLoader.this.f60425t.prefetchDefaultFontManager();
                        }
                    });
                } finally {
                    Trace.endSection();
                }
            } else {
                throw new IllegalStateException("startInitialization must be called on the main thread");
            }
        }
    }

    public void ensureInitializationComplete(Context context, String[] strArr) {
        if (!this.f60421p) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
            } else if (this.f60422q != null) {
                Trace.beginSection("FlutterLoader#ensureInitializationComplete");
                try {
                    InitResult initResult = this.f60420h.get();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
                    arrayList.add("--icu-native-lib-path=" + this.f60424s.nativeLibraryDir + File.separator + f60416l);
                    if (strArr != null) {
                        Collections.addAll(arrayList, strArr);
                    }
                    arrayList.add("--aot-shared-library-name=" + this.f60424s.aotSharedLibraryName);
                    arrayList.add("--aot-shared-library-name=" + this.f60424s.nativeLibraryDir + File.separator + this.f60424s.aotSharedLibraryName);
                    StringBuilder sb = new StringBuilder();
                    sb.append("--cache-dir-path=");
                    sb.append(initResult.engineCachesPath);
                    arrayList.add(sb.toString());
                    if (this.f60424s.domainNetworkPolicy != null) {
                        arrayList.add("--domain-network-policy=" + this.f60424s.domainNetworkPolicy);
                    }
                    if (this.f60422q.getLogTag() != null) {
                        arrayList.add("--log-tag=" + this.f60422q.getLogTag());
                    }
                    Bundle bundle = SystemUtils.getApplicationInfo(context.getPackageManager(), context.getPackageName(), 128).metaData;
                    int i = bundle != null ? bundle.getInt(f60414j) : 0;
                    if (i == 0) {
                        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
                        i = (int) ((((double) memoryInfo.totalMem) / 1000000.0d) / 2.0d);
                    }
                    arrayList.add("--old-gen-heap-size=" + i);
                    arrayList.add("--prefetched-default-font-manager");
                    if (bundle != null && bundle.getBoolean(f60415k)) {
                        arrayList.add("--enable-skparagraph");
                    }
                    long uptimeMillis = SystemClock.uptimeMillis() - this.f60423r;
                    this.f60425t.init(context, (String[]) arrayList.toArray(new String[0]), (String) null, initResult.appStoragePath, initResult.engineCachesPath, uptimeMillis);
                    this.f60421p = true;
                    Trace.endSection();
                } catch (Exception e) {
                    Log.m45256e(f60413i, "Flutter initialization failed.", e);
                    throw new RuntimeException(e);
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            } else {
                throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
            }
        }
    }

    public void ensureInitializationCompleteAsync(Context context, String[] strArr, Handler handler, Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
        } else if (this.f60422q == null) {
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        } else if (this.f60421p) {
            handler.post(runnable);
        } else {
            this.f60426u.execute(new Runnable(context, strArr, handler, runnable) {
                public final /* synthetic */ Context f$1;
                public final /* synthetic */ String[] f$2;
                public final /* synthetic */ Handler f$3;
                public final /* synthetic */ Runnable f$4;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                }

                public final void run() {
                    FlutterLoader.this.m45576a(this.f$1, this.f$2, this.f$3, this.f$4);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m45576a(Context context, String[] strArr, Handler handler, Runnable runnable) {
        try {
            InitResult initResult = this.f60420h.get();
            new Handler(Looper.getMainLooper()).post(new Runnable(context, strArr, handler, runnable) {
                public final /* synthetic */ Context f$1;
                public final /* synthetic */ String[] f$2;
                public final /* synthetic */ Handler f$3;
                public final /* synthetic */ Runnable f$4;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                }

                public final void run() {
                    FlutterLoader.this.m45578b(this.f$1, this.f$2, this.f$3, this.f$4);
                }
            });
        } catch (Exception e) {
            Log.m45256e(f60413i, "Flutter initialization failed.", e);
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m45578b(Context context, String[] strArr, Handler handler, Runnable runnable) {
        ensureInitializationComplete(context.getApplicationContext(), strArr);
        handler.post(runnable);
    }

    public boolean initialized() {
        return this.f60421p;
    }

    public String findAppBundlePath() {
        return this.f60424s.flutterAssetsDir;
    }

    public String getLookupKeyForAsset(String str) {
        return m45575a(str);
    }

    public String getLookupKeyForAsset(String str, String str2) {
        return getLookupKeyForAsset("packages" + File.separator + str2 + File.separator + str);
    }

    public boolean automaticallyRegisterPlugins() {
        return this.f60424s.f60405a;
    }

    /* renamed from: a */
    private String m45575a(String str) {
        return this.f60424s.flutterAssetsDir + File.separator + str;
    }

    /* renamed from: io.flutter.embedding.engine.loader.FlutterLoader$Settings */
    public static class Settings {
        private String logTag;

        public String getLogTag() {
            return this.logTag;
        }

        public void setLogTag(String str) {
            this.logTag = str;
        }
    }
}
