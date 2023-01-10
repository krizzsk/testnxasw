package p218io.flutter.embedding.engine.deferredcomponents;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.didi.sdk.apm.SystemUtils;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.OnSuccessListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import p218io.flutter.Log;
import p218io.flutter.embedding.engine.FlutterJNI;
import p218io.flutter.embedding.engine.loader.ApplicationInfoLoader;
import p218io.flutter.embedding.engine.loader.FlutterApplicationInfo;
import p218io.flutter.embedding.engine.systemchannels.DeferredComponentChannel;

/* renamed from: io.flutter.embedding.engine.deferredcomponents.PlayStoreDeferredComponentManager */
public class PlayStoreDeferredComponentManager implements DeferredComponentManager {
    public static final String MAPPING_KEY = (DeferredComponentManager.class.getName() + ".loadingUnitMapping");

    /* renamed from: a */
    private static final String f60390a = "PlayStoreDeferredComponentManager";

    /* renamed from: b */
    private SplitInstallManager f60391b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public FlutterJNI f60392c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public DeferredComponentChannel f60393d;

    /* renamed from: e */
    private Context f60394e;

    /* renamed from: f */
    private FlutterApplicationInfo f60395f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SparseArray<String> f60396g = new SparseArray<>();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public SparseIntArray f60397h = new SparseIntArray();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public SparseArray<String> f60398i = new SparseArray<>();

    /* renamed from: j */
    private Map<String, Integer> f60399j = new HashMap();

    /* renamed from: k */
    private FeatureInstallStateUpdatedListener f60400k;
    protected SparseArray<String> loadingUnitIdToComponentNames = new SparseArray<>();
    protected SparseArray<String> loadingUnitIdToSharedLibraryNames = new SparseArray<>();

    /* renamed from: io.flutter.embedding.engine.deferredcomponents.PlayStoreDeferredComponentManager$FeatureInstallStateUpdatedListener */
    private class FeatureInstallStateUpdatedListener implements SplitInstallStateUpdatedListener {
        private FeatureInstallStateUpdatedListener() {
        }

        public void onStateUpdate(SplitInstallSessionState splitInstallSessionState) {
            int sessionId = splitInstallSessionState.sessionId();
            if (PlayStoreDeferredComponentManager.this.f60396g.get(sessionId) != null) {
                switch (splitInstallSessionState.status()) {
                    case 1:
                        Log.m45253d(PlayStoreDeferredComponentManager.f60390a, String.format("Module \"%s\" (sessionId %d) install pending.", new Object[]{PlayStoreDeferredComponentManager.this.f60396g.get(sessionId), Integer.valueOf(sessionId)}));
                        PlayStoreDeferredComponentManager.this.f60398i.put(sessionId, "pending");
                        return;
                    case 2:
                        Log.m45253d(PlayStoreDeferredComponentManager.f60390a, String.format("Module \"%s\" (sessionId %d) downloading.", new Object[]{PlayStoreDeferredComponentManager.this.f60396g.get(sessionId), Integer.valueOf(sessionId)}));
                        PlayStoreDeferredComponentManager.this.f60398i.put(sessionId, "downloading");
                        return;
                    case 3:
                        Log.m45253d(PlayStoreDeferredComponentManager.f60390a, String.format("Module \"%s\" (sessionId %d) downloaded.", new Object[]{PlayStoreDeferredComponentManager.this.f60396g.get(sessionId), Integer.valueOf(sessionId)}));
                        PlayStoreDeferredComponentManager.this.f60398i.put(sessionId, "downloaded");
                        return;
                    case 4:
                        Log.m45253d(PlayStoreDeferredComponentManager.f60390a, String.format("Module \"%s\" (sessionId %d) installing.", new Object[]{PlayStoreDeferredComponentManager.this.f60396g.get(sessionId), Integer.valueOf(sessionId)}));
                        PlayStoreDeferredComponentManager.this.f60398i.put(sessionId, "installing");
                        return;
                    case 5:
                        Log.m45253d(PlayStoreDeferredComponentManager.f60390a, String.format("Module \"%s\" (sessionId %d) install successfully.", new Object[]{PlayStoreDeferredComponentManager.this.f60396g.get(sessionId), Integer.valueOf(sessionId)}));
                        PlayStoreDeferredComponentManager playStoreDeferredComponentManager = PlayStoreDeferredComponentManager.this;
                        playStoreDeferredComponentManager.loadAssets(playStoreDeferredComponentManager.f60397h.get(sessionId), (String) PlayStoreDeferredComponentManager.this.f60396g.get(sessionId));
                        if (PlayStoreDeferredComponentManager.this.f60397h.get(sessionId) > 0) {
                            PlayStoreDeferredComponentManager playStoreDeferredComponentManager2 = PlayStoreDeferredComponentManager.this;
                            playStoreDeferredComponentManager2.loadDartLibrary(playStoreDeferredComponentManager2.f60397h.get(sessionId), (String) PlayStoreDeferredComponentManager.this.f60396g.get(sessionId));
                        }
                        if (PlayStoreDeferredComponentManager.this.f60393d != null) {
                            PlayStoreDeferredComponentManager.this.f60393d.completeInstallSuccess((String) PlayStoreDeferredComponentManager.this.f60396g.get(sessionId));
                        }
                        PlayStoreDeferredComponentManager.this.f60396g.delete(sessionId);
                        PlayStoreDeferredComponentManager.this.f60397h.delete(sessionId);
                        PlayStoreDeferredComponentManager.this.f60398i.put(sessionId, "installed");
                        return;
                    case 6:
                        Log.m45255e(PlayStoreDeferredComponentManager.f60390a, String.format("Module \"%s\" (sessionId %d) install failed with: %s", new Object[]{PlayStoreDeferredComponentManager.this.f60396g.get(sessionId), Integer.valueOf(sessionId), Integer.valueOf(splitInstallSessionState.errorCode())}));
                        FlutterJNI c = PlayStoreDeferredComponentManager.this.f60392c;
                        int i = PlayStoreDeferredComponentManager.this.f60397h.get(sessionId);
                        c.deferredComponentInstallFailure(i, "Module install failed with " + splitInstallSessionState.errorCode(), true);
                        if (PlayStoreDeferredComponentManager.this.f60393d != null) {
                            PlayStoreDeferredComponentManager.this.f60393d.completeInstallError((String) PlayStoreDeferredComponentManager.this.f60396g.get(sessionId), "Android Deferred Component failed to install.");
                        }
                        PlayStoreDeferredComponentManager.this.f60396g.delete(sessionId);
                        PlayStoreDeferredComponentManager.this.f60397h.delete(sessionId);
                        PlayStoreDeferredComponentManager.this.f60398i.put(sessionId, "failed");
                        return;
                    case 7:
                        Log.m45253d(PlayStoreDeferredComponentManager.f60390a, String.format("Module \"%s\" (sessionId %d) install canceled.", new Object[]{PlayStoreDeferredComponentManager.this.f60396g.get(sessionId), Integer.valueOf(sessionId)}));
                        if (PlayStoreDeferredComponentManager.this.f60393d != null) {
                            PlayStoreDeferredComponentManager.this.f60393d.completeInstallError((String) PlayStoreDeferredComponentManager.this.f60396g.get(sessionId), "Android Deferred Component installation canceled.");
                        }
                        PlayStoreDeferredComponentManager.this.f60396g.delete(sessionId);
                        PlayStoreDeferredComponentManager.this.f60397h.delete(sessionId);
                        PlayStoreDeferredComponentManager.this.f60398i.put(sessionId, AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED);
                        return;
                    case 8:
                        Log.m45253d(PlayStoreDeferredComponentManager.f60390a, String.format("Module \"%s\" (sessionId %d) install requires user confirmation.", new Object[]{PlayStoreDeferredComponentManager.this.f60396g.get(sessionId), Integer.valueOf(sessionId)}));
                        PlayStoreDeferredComponentManager.this.f60398i.put(sessionId, "requiresUserConfirmation");
                        return;
                    case 9:
                        Log.m45253d(PlayStoreDeferredComponentManager.f60390a, String.format("Module \"%s\" (sessionId %d) install canceling.", new Object[]{PlayStoreDeferredComponentManager.this.f60396g.get(sessionId), Integer.valueOf(sessionId)}));
                        PlayStoreDeferredComponentManager.this.f60398i.put(sessionId, "canceling");
                        return;
                    default:
                        Log.m45253d(PlayStoreDeferredComponentManager.f60390a, "Unknown status: " + splitInstallSessionState.status());
                        return;
                }
            }
        }
    }

    public PlayStoreDeferredComponentManager(Context context, FlutterJNI flutterJNI) {
        this.f60394e = context;
        this.f60392c = flutterJNI;
        this.f60395f = ApplicationInfoLoader.load(context);
        this.f60391b = SplitInstallManagerFactory.create(context);
        FeatureInstallStateUpdatedListener featureInstallStateUpdatedListener = new FeatureInstallStateUpdatedListener();
        this.f60400k = featureInstallStateUpdatedListener;
        this.f60391b.registerListener(featureInstallStateUpdatedListener);
        m45562c();
    }

    public void setJNI(FlutterJNI flutterJNI) {
        this.f60392c = flutterJNI;
    }

    /* renamed from: a */
    private boolean m45558a() {
        if (this.f60392c != null) {
            return true;
        }
        Log.m45255e(f60390a, "No FlutterJNI provided. `setJNI` must be called on the DeferredComponentManager before attempting to load dart libraries or invoking with platform channels.");
        return false;
    }

    public void setDeferredComponentChannel(DeferredComponentChannel deferredComponentChannel) {
        this.f60393d = deferredComponentChannel;
    }

    /* renamed from: b */
    private ApplicationInfo m45559b() {
        try {
            return SystemUtils.getApplicationInfo(this.f60394e.getPackageManager(), this.f60394e.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: c */
    private void m45562c() {
        Bundle bundle;
        DeferredComponentManager.class.getName();
        ApplicationInfo b = m45559b();
        if (b != null && (bundle = b.metaData) != null) {
            String string = bundle.getString(MAPPING_KEY, (String) null);
            if (string == null) {
                Log.m45255e(f60390a, "No loading unit to dynamic feature module name found. Ensure '" + MAPPING_KEY + "' is defined in the base module's AndroidManifest.");
            } else if (!string.equals("")) {
                for (String split : string.split(",")) {
                    String[] split2 = split.split(":", -1);
                    int parseInt = Integer.parseInt(split2[0]);
                    this.loadingUnitIdToComponentNames.put(parseInt, split2[1]);
                    if (split2.length > 2) {
                        this.loadingUnitIdToSharedLibraryNames.put(parseInt, split2[2]);
                    }
                }
            }
        }
    }

    public void installDeferredComponent(int i, String str) {
        String str2 = str != null ? str : this.loadingUnitIdToComponentNames.get(i);
        if (str2 == null) {
            Log.m45255e(f60390a, "Deferred component name was null and could not be resolved from loading unit id.");
        } else if (!str2.equals("") || i <= 0) {
            this.f60391b.startInstall(SplitInstallRequest.newBuilder().addModule(str2).build()).addOnSuccessListener(new OnSuccessListener(str2, i) {
                public final /* synthetic */ String f$1;
                public final /* synthetic */ int f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onSuccess(Object obj) {
                    PlayStoreDeferredComponentManager.this.m45557a(this.f$1, this.f$2, (Integer) obj);
                }
            }).addOnFailureListener(new OnFailureListener(i, str) {
                public final /* synthetic */ int f$1;
                public final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onFailure(Exception exc) {
                    PlayStoreDeferredComponentManager.this.m45556a(this.f$1, this.f$2, exc);
                }
            });
        } else {
            loadDartLibrary(i, str2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m45557a(String str, int i, Integer num) {
        this.f60396g.put(num.intValue(), str);
        this.f60397h.put(num.intValue(), i);
        if (this.f60399j.containsKey(str)) {
            this.f60398i.remove(this.f60399j.get(str).intValue());
        }
        this.f60399j.put(str, num);
        this.f60398i.put(num.intValue(), "Requested");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m45556a(int i, String str, Exception exc) {
        SplitInstallException splitInstallException = (SplitInstallException) exc;
        int errorCode = splitInstallException.getErrorCode();
        if (errorCode == -6) {
            this.f60392c.deferredComponentInstallFailure(i, String.format("Install of deferred component module \"%s\" failed with a network error", new Object[]{str}), true);
        } else if (errorCode != -2) {
            this.f60392c.deferredComponentInstallFailure(i, String.format("Install of deferred component module \"%s\" failed with error %d: %s", new Object[]{str, Integer.valueOf(splitInstallException.getErrorCode()), splitInstallException.getMessage()}), false);
        } else {
            this.f60392c.deferredComponentInstallFailure(i, String.format("Install of deferred component module \"%s\" failed as it is unavailable", new Object[]{str}), false);
        }
    }

    public String getDeferredComponentInstallState(int i, String str) {
        if (str == null) {
            str = this.loadingUnitIdToComponentNames.get(i);
        }
        if (str == null) {
            Log.m45255e(f60390a, "Deferred component name was null and could not be resolved from loading unit id.");
            return "unknown";
        } else if (this.f60399j.containsKey(str)) {
            return this.f60398i.get(this.f60399j.get(str).intValue());
        } else if (this.f60391b.getInstalledModules().contains(str)) {
            return "installedPendingLoad";
        } else {
            return "unknown";
        }
    }

    public void loadAssets(int i, String str) {
        if (m45558a()) {
            try {
                Context createPackageContext = this.f60394e.createPackageContext(this.f60394e.getPackageName(), 0);
                this.f60394e = createPackageContext;
                this.f60392c.updateJavaAssetManager(createPackageContext.getAssets(), this.f60395f.flutterAssetsDir);
            } catch (PackageManager.NameNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void loadDartLibrary(int i, String str) {
        String str2;
        if (m45558a() && i >= 0) {
            String str3 = this.loadingUnitIdToSharedLibraryNames.get(i);
            if (str3 == null) {
                str3 = this.f60395f.aotSharedLibraryName + "-" + i + ".part.so";
            }
            if (Build.VERSION.SDK_INT >= 21) {
                str2 = Build.SUPPORTED_ABIS[0];
            } else {
                str2 = Build.CPU_ABI;
            }
            String replace = str2.replace("-", "_");
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<String> arrayList2 = new ArrayList<>();
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.f60394e.getFilesDir());
            if (Build.VERSION.SDK_INT >= 21) {
                for (String file : this.f60394e.getApplicationInfo().splitSourceDirs) {
                    linkedList.add(new File(file));
                }
            }
            while (!linkedList.isEmpty()) {
                File file2 = (File) linkedList.remove();
                if (file2 == null || !file2.isDirectory() || file2.listFiles() == null) {
                    String name = file2.getName();
                    if (name.endsWith(".apk") && ((name.startsWith(str) || name.startsWith("split_config")) && name.contains(replace))) {
                        arrayList.add(file2.getAbsolutePath());
                    } else if (name.equals(str3)) {
                        arrayList2.add(file2.getAbsolutePath());
                    }
                } else {
                    for (File add : file2.listFiles()) {
                        linkedList.add(add);
                    }
                }
            }
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(str3);
            for (String str4 : arrayList) {
                arrayList3.add(str4 + "!lib/" + str2 + "/" + str3);
            }
            for (String add2 : arrayList2) {
                arrayList3.add(add2);
            }
            this.f60392c.loadDartDeferredLibrary(i, (String[]) arrayList3.toArray(new String[arrayList3.size()]));
        }
    }

    public boolean uninstallDeferredComponent(int i, String str) {
        if (str == null) {
            str = this.loadingUnitIdToComponentNames.get(i);
        }
        if (str == null) {
            Log.m45255e(f60390a, "Deferred component name was null and could not be resolved from loading unit id.");
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.f60391b.deferredUninstall(arrayList);
        if (this.f60399j.get(str) == null) {
            return true;
        }
        this.f60398i.delete(this.f60399j.get(str).intValue());
        return true;
    }

    public void destroy() {
        this.f60391b.unregisterListener(this.f60400k);
        this.f60393d = null;
        this.f60392c = null;
    }
}
