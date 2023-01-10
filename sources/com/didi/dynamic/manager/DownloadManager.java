package com.didi.dynamic.manager;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.dynamic.manager.utils.Constants;
import com.didi.dynamic.manager.utils.DownloadUtil;
import com.didi.dynamic.manager.utils.EncryptDecodeUtils;
import com.didi.dynamic.manager.utils.HttpUtil;
import com.didi.dynamic.manager.utils.IDUtil;
import com.didi.dynamic.manager.utils.NetworkUtil;
import com.didi.dynamic.manager.utils.ReportUtil;
import com.didi.dynamic.manager.utils.ThreadUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class DownloadManager implements IDownloadManager {
    public static final String KEY_APP_KEY = "app_key";
    public static final String KEY_APP_VERSION = "app_version";
    public static final String KEY_CITY_ID = "city";
    public static final String KEY_DEVICE_ID = "device_id";
    public static final String KEY_DEVICE_TYPE = "device_type";
    public static final String KEY_EXT = "ext";
    public static final String KEY_EXTRA_PARA = "extra_para";
    public static final String KEY_LAUNCH_TYPE = "launch_type";
    public static final String KEY_MODULE_CODE = "module_code";
    public static final String KEY_MODULE_VERSION = "module_version";
    public static final String KEY_OS_TYPE = "os_type";
    public static final String KEY_PACKAGE_TYPE = "package_type";
    public static final String KEY_PHONE_NUMBER = "phone";
    public static final String KEY_URL = "url";
    public static final String MODULE_DIR = "ModuleManager";
    public static final String MODULE_DIR_TEMP = "temp";
    public static final String MODULE_DIR_ZIP = "zip";
    public static final String NATIVE_DIR = "nativelibs";
    public static final String OPTIMIZE_DIR = "moduledex";

    /* renamed from: a */
    private static final String f21174a = "DM.DownloadManager";

    /* renamed from: b */
    private static final String f21175b = "errno";

    /* renamed from: c */
    private static final String f21176c = "modules";

    /* renamed from: d */
    private static final boolean f21177d = true;

    /* renamed from: e */
    private static String f21178e = EncryptDecodeUtils.decode("iuuqt://dpog.ejejubyj.dpn.do");

    /* renamed from: f */
    private static final String f21179f = "/api/dynamicmodule/update";

    /* renamed from: g */
    private static final Pattern f21180g = Pattern.compile("(phone=[+%\\w-]*?)([\\w-]+)([\\w-]{3})");
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static Handler f21181i = new Handler(Looper.getMainLooper());

    /* renamed from: j */
    private static DownloadManager f21182j;

    /* renamed from: l */
    private static final HashMap<IDownloadListener, List<Integer>> f21183l = new HashMap<>();

    /* renamed from: x */
    private static boolean f21184x = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Context f21185h;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ModulesTable f21186k;

    /* renamed from: m */
    private volatile Map<String, List<Module>> f21187m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final HashMap<Module, DownloadTask> f21188n = new HashMap<>();

    /* renamed from: o */
    private String f21189o = Constants.APPKEY;

    /* renamed from: p */
    private String f21190p = "";

    /* renamed from: q */
    private int f21191q = -1;

    /* renamed from: r */
    private String f21192r = "";

    /* renamed from: s */
    private volatile HashMap<String, String> f21193s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public HashSet<Integer> f21194t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public final CountDownLatch f21195u = new CountDownLatch(1);
    /* access modifiers changed from: private */

    /* renamed from: v */
    public final AtomicBoolean f21196v = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: w */
    public final AtomicBoolean f21197w = new AtomicBoolean(false);

    public void setLocation(double d, double d2) {
    }

    public static synchronized DownloadManager getInstance(Context context) {
        DownloadManager downloadManager;
        synchronized (DownloadManager.class) {
            if (f21182j == null) {
                f21182j = new DownloadManager(context);
            }
            downloadManager = f21182j;
        }
        return downloadManager;
    }

    public static void setModuleUrlHost(String str) {
        f21178e = str;
    }

    public static String getModuleUrl(String str) {
        return f21178e + str;
    }

    private DownloadManager(Context context) {
        if (context instanceof Application) {
            this.f21185h = context;
        } else {
            this.f21185h = context.getApplicationContext();
        }
        File dir = context.getDir(MODULE_DIR, 0);
        File file = new File(dir, MODULE_DIR_TEMP);
        File file2 = new File(dir, MODULE_DIR_ZIP);
        file.mkdirs();
        file2.mkdirs();
        m17878b();
    }

    public void addIncludeModuleType(int i) {
        if (this.f21194t == null) {
            this.f21194t = new HashSet<>();
        }
        this.f21194t.add(Integer.valueOf(i));
    }

    public void setPhoneNumber(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f21190p = str;
        }
    }

    public void setAppKey(String str) {
        this.f21189o = str;
    }

    public String getAppKey() {
        return this.f21189o;
    }

    public void setCityId(int i) {
        this.f21191q = i;
    }

    public void setExtraParamMap(Map<String, String> map) {
        synchronized (this) {
            if (this.f21193s == null) {
                this.f21193s = new HashMap<>();
            }
            this.f21193s.clear();
            if (map != null) {
                this.f21193s.putAll(map);
            }
        }
    }

    /* renamed from: b */
    private void m17878b() {
        m17881c();
        ((Application) this.f21185h).registerActivityLifecycleCallbacks(new Scheduler());
        try {
            try {
                this.f21185h.registerReceiver(new NetworkChangedReceiver(), new IntentFilter(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION));
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
        } catch (Exception e2) {
            com.didi.dynamic.manager.utils.Log.m17933w(f21174a, (Throwable) e2);
        }
    }

    /* renamed from: c */
    private void m17881c() {
        this.f21186k = ModulesTable.m17891a(this.f21185h);
        for (Module a : getAllCurrentModules(m17882d())) {
            m17873a(a);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public Map<String, List<Module>> m17882d() {
        Map<String, List<Module>> b = this.f21186k.mo64047b(DownloadUtil.getVersionNameAndCode(this.f21185h));
        this.f21187m = b;
        return b;
    }

    /* renamed from: a */
    private void m17873a(Module module) {
        if (module.moduleTempPath.exists()) {
            module.moduleTempPath.renameTo(module.modulePath);
        }
    }

    public String getFetchUrl() throws Exception {
        HashMap hashMap = new HashMap();
        synchronized (this) {
            if (this.f21193s != null && !this.f21193s.isEmpty()) {
                hashMap.putAll(this.f21193s);
            }
        }
        hashMap.put(KEY_APP_KEY, this.f21189o);
        hashMap.put("app_version", DownloadUtil.getVersionNameAndCode(this.f21185h));
        hashMap.put(KEY_DEVICE_TYPE, Build.MODEL);
        hashMap.put("device_id", IDUtil.getUUID(this.f21185h));
        hashMap.put("os_type", Build.VERSION.SDK_INT + "");
        hashMap.put("phone", this.f21190p);
        hashMap.put("city", this.f21191q + "");
        hashMap.put(KEY_EXTRA_PARA, this.f21192r);
        StringBuilder sb = new StringBuilder();
        Map<String, List<Module>> map = this.f21187m;
        for (String newestDownloadedModule : map.keySet()) {
            Module newestDownloadedModule2 = getNewestDownloadedModule(map, newestDownloadedModule);
            if (newestDownloadedModule2 != null) {
                sb.append(String.format("%s:%s;", new Object[]{newestDownloadedModule2.moduleCode, newestDownloadedModule2.version}));
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        hashMap.put(f21176c, sb.toString());
        return HttpUtil.appendQueryParams(getModuleUrl(f21179f), hashMap);
    }

    /* access modifiers changed from: protected */
    public void downloadModuleInWifi(boolean z) {
        if (NetworkUtil.isNetworkAvaialble(this.f21185h) && NetworkUtil.isNetworkWifi(this.f21185h)) {
            HashSet hashSet = new HashSet();
            hashSet.add(3);
            if (z) {
                hashSet.add(1);
            }
            final CountDownLatch dispatchDownloadTask = dispatchDownloadTask(this.f21187m, (Set<Integer>) hashSet, true);
            ThreadUtil.execute(new Runnable() {
                public void run() {
                    while (true) {
                        try {
                            dispatchDownloadTask.await();
                            break;
                        } catch (InterruptedException e) {
                            com.didi.dynamic.manager.utils.Log.m17933w(DownloadManager.f21174a, (Throwable) e);
                        }
                    }
                    Map unused = DownloadManager.this.m17882d();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Module m17869a(Module module, boolean z, HttpUtil.OperationController operationController) {
        if (z) {
            try {
                m17879b(module);
            } catch (IOException e) {
                com.didi.dynamic.manager.utils.Log.m17933w(f21174a, (Throwable) e);
                throw e;
            } catch (Throwable unused) {
                com.didi.dynamic.manager.utils.Log.m17933w(f21174a, th);
            }
        }
        com.didi.dynamic.manager.utils.Log.m17927i(f21174a, "Starting download module: " + module + ", url: " + module.url);
        HttpUtil.download(module.url, module.moduleTempPath, operationController);
        module.f21199a = true;
        m17873a(module);
        this.f21186k.mo64049c(module);
        if (z) {
            m17874a(module, 1);
        }
        if (!DownloadUtil.getDownloadPluginSuccessReportFlag(this.f21185h, module)) {
            ReportUtil.report(this.f21185h, this.f21189o, module, DownloadUtil.getDownloadPluginFailedReportFlag(this.f21185h, module) ? 5 : 1, 0, "");
            DownloadUtil.setDownloadPluginSuccessReportFlag(this.f21185h, module, true);
        }
        return module;
        if (DownloadUtil.getDownloadPluginFailedReportFlag(this.f21185h, module)) {
            return null;
        }
        ReportUtil.report(this.f21185h, this.f21189o, module, 4, 0, com.didi.dynamic.manager.utils.Log.getStackTraceString(th));
        DownloadUtil.setDownloadPluginFailedReportFlag(this.f21185h, module, true);
        return null;
    }

    public void fetchPatch() {
        DownloadUtil.setRequestTime(this.f21185h, 0);
        checkModuleAndDownload();
    }

    public synchronized void checkModuleAndDownload() {
        ThreadUtil.execute(new CheckTask());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17875a(Map<String, List<Module>> map) {
        File dir = this.f21185h.getDir(MODULE_DIR, 0);
        ArrayList arrayList = new ArrayList();
        for (Module module : getAllCurrentModules(map)) {
            arrayList.add(module.modulePath.getAbsolutePath());
        }
        File[] listFiles = dir.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                String absolutePath = file.getAbsolutePath();
                if (file.isFile() && !arrayList.contains(absolutePath)) {
                    com.didi.dynamic.manager.utils.Log.m17927i(f21174a, "delete old module :" + absolutePath);
                    file.delete();
                }
            }
        }
    }

    public void addDownloadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (f21183l) {
                List list = f21183l.get(iDownloadListener);
                if (list == null) {
                    list = new ArrayList();
                    f21183l.put(iDownloadListener, list);
                }
                if (!list.contains(Integer.valueOf(i))) {
                    list.add(Integer.valueOf(i));
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeDownloadListener(int r3, com.didi.dynamic.manager.IDownloadListener r4) {
        /*
            r2 = this;
            java.util.HashMap<com.didi.dynamic.manager.IDownloadListener, java.util.List<java.lang.Integer>> r0 = f21183l
            monitor-enter(r0)
            java.util.HashMap<com.didi.dynamic.manager.IDownloadListener, java.util.List<java.lang.Integer>> r1 = f21183l     // Catch:{ all -> 0x0023 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0023 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0023 }
            if (r1 != 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            return
        L_0x000f:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0023 }
            r1.remove(r3)     // Catch:{ all -> 0x0023 }
            boolean r3 = r1.isEmpty()     // Catch:{ all -> 0x0023 }
            if (r3 == 0) goto L_0x0021
            java.util.HashMap<com.didi.dynamic.manager.IDownloadListener, java.util.List<java.lang.Integer>> r3 = f21183l     // Catch:{ all -> 0x0023 }
            r3.remove(r4)     // Catch:{ all -> 0x0023 }
        L_0x0021:
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            return
        L_0x0023:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dynamic.manager.DownloadManager.removeDownloadListener(int, com.didi.dynamic.manager.IDownloadListener):void");
    }

    public void removeDownloadListener(IDownloadListener iDownloadListener) {
        synchronized (f21183l) {
            f21183l.remove(iDownloadListener);
        }
    }

    public Module getNewestDownloadedModule(String str) {
        return getNewestDownloadedModule(this.f21187m, str);
    }

    /* access modifiers changed from: protected */
    public Module getNewestDownloadedModule(Map<String, List<Module>> map, String str) {
        List<Module> list = map.get(str);
        Module module = null;
        if (list != null && !list.isEmpty()) {
            long j = 0;
            for (Module module2 : list) {
                if (module2.isDownloaded() && module2.versionLong > j) {
                    j = module2.versionLong;
                    module = module2;
                }
            }
        }
        return module;
    }

    public List<Module> getModules(String str) {
        List list = this.f21187m.get(str);
        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }
        return new ArrayList(list);
    }

    public void deleteModule(Module module) {
        if (this.f21186k.mo64051d(module)) {
            m17882d();
        }
    }

    public void deleteModule(String str, String str2) {
        if (str != null && str2 != null) {
            for (Module next : getModules(str)) {
                if (str2.equals(next.version)) {
                    deleteModule(next);
                    return;
                }
            }
        }
    }

    public void setExtraParameter(String str, String str2, int i, double d, double d2, String str3) {
        setAppKey(str);
        setPhoneNumber(str2);
        setCityId(i);
        setLocation(d, d2);
        this.f21192r = str3;
    }

    public Module checkModuleAndDownloadByModuleName(String str) {
        if (!DownloadUtil.isMainProcess(this.f21185h)) {
            return null;
        }
        if (!this.f21196v.get()) {
            checkModuleAndDownload();
        }
        try {
            this.f21195u.await();
        } catch (InterruptedException e) {
            com.didi.dynamic.manager.utils.Log.m17933w(f21174a, (Throwable) e);
        }
        Module newestModule = getNewestModule(str);
        if (newestModule == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(newestModule);
        CountDownLatch dispatchDownloadTask = dispatchDownloadTask((List<Module>) arrayList, (Set<Integer>) null, true);
        while (true) {
            try {
                dispatchDownloadTask.await();
                break;
            } catch (InterruptedException e2) {
                com.didi.dynamic.manager.utils.Log.m17933w(f21174a, (Throwable) e2);
            }
        }
        Module newestModule2 = getNewestModule(m17882d(), str);
        if (newestModule2 == null || !newestModule2.isDownloaded() || !newestModule2.equals(newestModule)) {
            return null;
        }
        return newestModule2;
    }

    public Module getNewestModule(String str) {
        return getNewestModule(this.f21187m, str);
    }

    /* access modifiers changed from: protected */
    public Module getNewestModule(Map<String, List<Module>> map, String str) {
        List<Module> list = map.get(str);
        Module module = null;
        if (list != null && !list.isEmpty()) {
            long j = 0;
            for (Module module2 : list) {
                if (module2.versionLong > j) {
                    j = module2.versionLong;
                    module = module2;
                }
            }
        }
        return module;
    }

    public List<Module> getAllCurrentModules() {
        return getAllCurrentModules(this.f21187m);
    }

    /* access modifiers changed from: protected */
    public List<Module> getAllCurrentModules(Map<String, List<Module>> map) {
        ArrayList arrayList = new ArrayList();
        for (List<Module> addAll : map.values()) {
            arrayList.addAll(addAll);
        }
        return arrayList;
    }

    public Set<String> getAllCurrentModuleCodes() {
        return new HashSet(this.f21187m.keySet());
    }

    public void cleanModuleByModuleType(int i) {
        this.f21186k.mo64035a(i);
    }

    /* renamed from: b */
    private void m17879b(Module module) throws Exception {
        synchronized (f21183l) {
            IDownloadListener[] iDownloadListenerArr = (IDownloadListener[]) f21183l.keySet().toArray(new IDownloadListener[f21183l.size()]);
            Integer valueOf = Integer.valueOf(module.moduleType);
            for (IDownloadListener iDownloadListener : iDownloadListenerArr) {
                List list = f21183l.get(iDownloadListener);
                if (list != null && list.contains(valueOf)) {
                    iDownloadListener.onDownloadStart(module);
                }
            }
        }
    }

    /* renamed from: a */
    private void m17874a(Module module, int i) throws Exception {
        synchronized (f21183l) {
            IDownloadListener[] iDownloadListenerArr = (IDownloadListener[]) f21183l.keySet().toArray(new IDownloadListener[f21183l.size()]);
            Integer valueOf = Integer.valueOf(module.moduleType);
            for (IDownloadListener iDownloadListener : iDownloadListenerArr) {
                List list = f21183l.get(iDownloadListener);
                if (list != null && list.contains(valueOf)) {
                    iDownloadListener.onDownloadEnd(module, i);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m17885e() throws Exception {
        synchronized (f21183l) {
            for (IDownloadListener onFinishAllDownload : (IDownloadListener[]) f21183l.keySet().toArray(new IDownloadListener[f21183l.size()])) {
                onFinishAllDownload.onFinishAllDownload();
            }
        }
    }

    /* access modifiers changed from: protected */
    public CountDownLatch dispatchDownloadTask(Map<String, List<Module>> map, Set<Integer> set, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (String newestModule : map.keySet()) {
            Module newestModule2 = getNewestModule(map, newestModule);
            if (newestModule2 != null && !newestModule2.isDownloaded()) {
                arrayList.add(newestModule2);
            }
        }
        return dispatchDownloadTask((List<Module>) arrayList, set, z);
    }

    /* access modifiers changed from: protected */
    public CountDownLatch dispatchDownloadTask(List<Module> list, Set<Integer> set, boolean z) {
        CountDownLatch countDownLatch = new CountDownLatch(list.size());
        for (Module downloadTask : list) {
            ThreadUtil.execute(new DownloadTask(countDownLatch, downloadTask, z, set));
        }
        return countDownLatch;
    }

    public void hidePrintHostLog(boolean z) {
        f21184x = z;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x006a A[Catch:{ all -> 0x0095 }, LOOP:2: B:15:0x0068->B:16:0x006a, LOOP_END] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m17876b(java.lang.String r8) {
        /*
            java.util.regex.Pattern r0 = f21180g     // Catch:{ all -> 0x0095 }
            java.util.regex.Matcher r0 = r0.matcher(r8)     // Catch:{ all -> 0x0095 }
            boolean r1 = r0.find()     // Catch:{ all -> 0x0095 }
            if (r1 != 0) goto L_0x000d
            return r8
        L_0x000d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0095 }
            r1.<init>()     // Catch:{ all -> 0x0095 }
            boolean r2 = f21184x     // Catch:{ all -> 0x0095 }
            java.lang.String r3 = "X"
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0042
            boolean r2 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0095 }
            if (r2 != 0) goto L_0x0042
            java.lang.String r2 = f21178e     // Catch:{ all -> 0x0095 }
            java.lang.String r6 = "/"
            int r2 = r2.lastIndexOf(r6)     // Catch:{ all -> 0x0095 }
            int r2 = r2 + r5
            java.lang.String r6 = f21178e     // Catch:{ all -> 0x0095 }
            int r6 = r6.length()     // Catch:{ all -> 0x0095 }
            java.lang.String r7 = r8.substring(r4, r2)     // Catch:{ all -> 0x0095 }
            r1.append(r7)     // Catch:{ all -> 0x0095 }
        L_0x0036:
            if (r2 >= r6) goto L_0x0043
            int r7 = r2 + 1
            r8.substring(r2, r7)     // Catch:{ all -> 0x0095 }
            r1.append(r3)     // Catch:{ all -> 0x0095 }
            r2 = r7
            goto L_0x0036
        L_0x0042:
            r6 = 0
        L_0x0043:
            int r2 = r0.start()     // Catch:{ all -> 0x0095 }
            java.lang.String r2 = r8.substring(r6, r2)     // Catch:{ all -> 0x0095 }
            r1.append(r2)     // Catch:{ all -> 0x0095 }
            int r2 = r0.start(r5)     // Catch:{ all -> 0x0095 }
            int r6 = r0.end(r5)     // Catch:{ all -> 0x0095 }
            java.lang.String r2 = r8.substring(r2, r6)     // Catch:{ all -> 0x0095 }
            r1.append(r2)     // Catch:{ all -> 0x0095 }
            r2 = 2
            int r6 = r0.end(r2)     // Catch:{ all -> 0x0095 }
            int r2 = r0.start(r2)     // Catch:{ all -> 0x0095 }
            int r6 = r6 - r2
            r2 = 0
        L_0x0068:
            if (r2 >= r6) goto L_0x0070
            r1.append(r3)     // Catch:{ all -> 0x0095 }
            int r2 = r2 + 1
            goto L_0x0068
        L_0x0070:
            r2 = 3
            int r6 = r0.start(r2)     // Catch:{ all -> 0x0095 }
            int r2 = r0.end(r2)     // Catch:{ all -> 0x0095 }
            java.lang.String r2 = r8.substring(r6, r2)     // Catch:{ all -> 0x0095 }
            r1.append(r2)     // Catch:{ all -> 0x0095 }
            int r6 = r0.end()     // Catch:{ all -> 0x0095 }
            boolean r2 = r0.find()     // Catch:{ all -> 0x0095 }
            if (r2 != 0) goto L_0x0043
            java.lang.String r0 = r8.substring(r6)     // Catch:{ all -> 0x0095 }
            r1.append(r0)     // Catch:{ all -> 0x0095 }
            java.lang.String r8 = r1.toString()     // Catch:{ all -> 0x0095 }
        L_0x0095:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dynamic.manager.DownloadManager.m17876b(java.lang.String):java.lang.String");
    }

    class CheckTask implements Runnable {
        CheckTask() {
        }

        public void run() {
            if (DownloadManager.this.f21197w.compareAndSet(false, true)) {
                try {
                    if (DownloadUtil.isMainProcess(DownloadManager.this.f21185h)) {
                        long currentTimeMillis = System.currentTimeMillis() - DownloadUtil.getRequestTime(DownloadManager.this.f21185h);
                        if (currentTimeMillis < 0 || currentTimeMillis >= 30000) {
                            DownloadUtil.setRequestTime(DownloadManager.this.f21185h, System.currentTimeMillis());
                            DownloadManager.this.f21196v.set(true);
                            String fetchUrl = DownloadManager.this.getFetchUrl();
                            com.didi.dynamic.manager.utils.Log.m17927i(DownloadManager.f21174a, "fetchPluginInfo, url=" + DownloadManager.m17876b(fetchUrl));
                            String str = HttpUtil.get(fetchUrl);
                            com.didi.dynamic.manager.utils.Log.m17927i(DownloadManager.f21174a, "fetchPluginInfo, response=" + str);
                            JSONObject jSONObject = new JSONObject(str);
                            jSONObject.optString("errno");
                            JSONArray jSONArray = jSONObject.getJSONArray(DownloadManager.f21176c);
                            for (int i = 0; i < jSONArray.length(); i++) {
                                Module a = Module.m17890a(DownloadManager.this.f21185h, jSONArray.getJSONObject(i));
                                if (a != null) {
                                    if (DownloadManager.this.f21194t == null || DownloadManager.this.f21194t.contains(Integer.valueOf(a.moduleType))) {
                                        DownloadManager.this.f21186k.mo64042a(a);
                                    }
                                }
                            }
                            Map a2 = DownloadManager.this.m17882d();
                            HashSet hashSet = new HashSet();
                            hashSet.add(1);
                            hashSet.add(3);
                            CountDownLatch dispatchDownloadTask = DownloadManager.this.dispatchDownloadTask((Map<String, List<Module>>) a2, (Set<Integer>) hashSet, true);
                            while (true) {
                                dispatchDownloadTask.await();
                                break;
                            }
                            DownloadManager.this.f21186k.mo64041a(DownloadUtil.getVersionNameAndCode(DownloadManager.this.f21185h));
                            DownloadManager.this.m17875a((Map<String, List<Module>>) DownloadManager.this.m17882d());
                            DownloadManager.this.m17885e();
                            DownloadManager.this.f21197w.compareAndSet(true, false);
                            DownloadManager.this.f21195u.countDown();
                            return;
                        }
                        com.didi.dynamic.manager.utils.Log.m17931w(DownloadManager.f21174a, "checkModuleAndDownload, skip current request! duration: " + currentTimeMillis);
                    }
                    DownloadManager.this.f21197w.compareAndSet(true, false);
                    DownloadManager.this.f21195u.countDown();
                } catch (InterruptedException e) {
                    com.didi.dynamic.manager.utils.Log.m17933w(DownloadManager.f21174a, (Throwable) e);
                } catch (Throwable th) {
                    try {
                        com.didi.dynamic.manager.utils.Log.m17933w(DownloadManager.f21174a, th);
                    } catch (Throwable th2) {
                        DownloadManager.this.f21197w.compareAndSet(true, false);
                        DownloadManager.this.f21195u.countDown();
                        throw th2;
                    }
                }
            }
        }
    }

    class DownloadTask implements HttpUtil.OperationController, Runnable {
        CountDownLatch mCompletedSignal = new CountDownLatch(1);
        CountDownLatch mDoneSignal;
        Set<Integer> mLaunchTypeSet;
        Module mModule;
        boolean mNotifyCallback;

        DownloadTask(CountDownLatch countDownLatch, Module module, boolean z, Set<Integer> set) {
            this.mDoneSignal = countDownLatch;
            this.mModule = module;
            this.mNotifyCallback = z;
            this.mLaunchTypeSet = set;
        }

        public void continueDownloading(String str, File file, long j) throws HttpUtil.CanceledException {
            if (this.mModule.launchType == 3 && NetworkUtil.getLastNetworkType() != 1) {
                throw new HttpUtil.CanceledException("WiFi download task of " + this.mModule + " was canceled because of a none-WiFi network. downloaded size: " + j);
            }
        }

        /* JADX INFO: finally extract failed */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
            if (r0 != null) goto L_0x0021;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            r2 = com.didi.dynamic.manager.DownloadManager.m17886f(r6.this$0).mo64045b(r6.mModule.moduleCode, r6.mModule.version);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0076, code lost:
            if (r2 == null) goto L_0x008f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x007c, code lost:
            if (r2.isAvailable() == false) goto L_0x008f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x007f, code lost:
            r2 = com.didi.dynamic.manager.DownloadManager.m17889i(r6.this$0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0085, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0087, code lost:
            r0 = r6.mDoneSignal;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0089, code lost:
            if (r0 == null) goto L_0x0024;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            com.didi.dynamic.manager.utils.Log.m17923d(com.didi.dynamic.manager.DownloadManager.f21174a, "requestDownload again :" + r6.mModule);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00db, code lost:
            if (r0 != null) goto L_0x0021;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x0117, code lost:
            if (r0 != null) goto L_0x0021;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                r0 = 0
                java.util.Set<java.lang.Integer> r1 = r6.mLaunchTypeSet     // Catch:{ all -> 0x014d }
                if (r1 == 0) goto L_0x002d
                java.util.Set<java.lang.Integer> r1 = r6.mLaunchTypeSet     // Catch:{ all -> 0x014d }
                com.didi.dynamic.manager.Module r2 = r6.mModule     // Catch:{ all -> 0x014d }
                int r2 = r2.launchType     // Catch:{ all -> 0x014d }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x014d }
                boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x014d }
                if (r1 != 0) goto L_0x002d
                com.didi.dynamic.manager.DownloadManager r0 = com.didi.dynamic.manager.DownloadManager.this
                java.util.HashMap r1 = r0.f21188n
                monitor-enter(r1)
                monitor-exit(r1)     // Catch:{ all -> 0x002a }
                java.util.concurrent.CountDownLatch r0 = r6.mDoneSignal
                if (r0 == 0) goto L_0x0024
            L_0x0021:
                r0.countDown()
            L_0x0024:
                java.util.concurrent.CountDownLatch r0 = r6.mCompletedSignal
                r0.countDown()
                return
            L_0x002a:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x002a }
                throw r0
            L_0x002d:
                com.didi.dynamic.manager.DownloadManager r1 = com.didi.dynamic.manager.DownloadManager.this     // Catch:{ all -> 0x014d }
                java.util.HashMap r1 = r1.f21188n     // Catch:{ all -> 0x014d }
                monitor-enter(r1)     // Catch:{ all -> 0x014d }
                com.didi.dynamic.manager.DownloadManager r2 = com.didi.dynamic.manager.DownloadManager.this     // Catch:{ all -> 0x014a }
                java.util.HashMap r2 = r2.f21188n     // Catch:{ all -> 0x014a }
                com.didi.dynamic.manager.Module r3 = r6.mModule     // Catch:{ all -> 0x014a }
                java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x014a }
                com.didi.dynamic.manager.DownloadManager$DownloadTask r2 = (com.didi.dynamic.manager.DownloadManager.DownloadTask) r2     // Catch:{ all -> 0x014a }
                if (r2 == 0) goto L_0x00b0
                java.lang.String r3 = "DM.DownloadManager"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x014a }
                r4.<init>()     // Catch:{ all -> 0x014a }
                java.lang.String r5 = "requestDownload wait :"
                r4.append(r5)     // Catch:{ all -> 0x014a }
                com.didi.dynamic.manager.Module r5 = r6.mModule     // Catch:{ all -> 0x014a }
                java.lang.String r5 = r5.moduleCode     // Catch:{ all -> 0x014a }
                r4.append(r5)     // Catch:{ all -> 0x014a }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x014a }
                com.didi.dynamic.manager.utils.Log.m17923d(r3, r4)     // Catch:{ all -> 0x014a }
            L_0x005f:
                java.util.concurrent.CountDownLatch r3 = r2.mCompletedSignal     // Catch:{ InterruptedException -> 0x00a9 }
                r3.await()     // Catch:{ InterruptedException -> 0x00a9 }
                com.didi.dynamic.manager.DownloadManager r2 = com.didi.dynamic.manager.DownloadManager.this     // Catch:{ all -> 0x014a }
                com.didi.dynamic.manager.ModulesTable r2 = r2.f21186k     // Catch:{ all -> 0x014a }
                com.didi.dynamic.manager.Module r3 = r6.mModule     // Catch:{ all -> 0x014a }
                java.lang.String r3 = r3.moduleCode     // Catch:{ all -> 0x014a }
                com.didi.dynamic.manager.Module r4 = r6.mModule     // Catch:{ all -> 0x014a }
                java.lang.String r4 = r4.version     // Catch:{ all -> 0x014a }
                com.didi.dynamic.manager.Module r2 = r2.mo64045b(r3, r4)     // Catch:{ all -> 0x014a }
                if (r2 == 0) goto L_0x008f
                boolean r2 = r2.isAvailable()     // Catch:{ all -> 0x014a }
                if (r2 == 0) goto L_0x008f
                monitor-exit(r1)     // Catch:{ all -> 0x014a }
                com.didi.dynamic.manager.DownloadManager r0 = com.didi.dynamic.manager.DownloadManager.this
                java.util.HashMap r2 = r0.f21188n
                monitor-enter(r2)
                monitor-exit(r2)     // Catch:{ all -> 0x008c }
                java.util.concurrent.CountDownLatch r0 = r6.mDoneSignal
                if (r0 == 0) goto L_0x0024
                goto L_0x0021
            L_0x008c:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x008c }
                throw r0
            L_0x008f:
                java.lang.String r2 = "DM.DownloadManager"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x014a }
                r3.<init>()     // Catch:{ all -> 0x014a }
                java.lang.String r4 = "requestDownload again :"
                r3.append(r4)     // Catch:{ all -> 0x014a }
                com.didi.dynamic.manager.Module r4 = r6.mModule     // Catch:{ all -> 0x014a }
                r3.append(r4)     // Catch:{ all -> 0x014a }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x014a }
                com.didi.dynamic.manager.utils.Log.m17923d(r2, r3)     // Catch:{ all -> 0x014a }
                goto L_0x00b0
            L_0x00a9:
                r3 = move-exception
                java.lang.String r4 = "DM.DownloadManager"
                com.didi.dynamic.manager.utils.Log.m17933w((java.lang.String) r4, (java.lang.Throwable) r3)     // Catch:{ all -> 0x014a }
                goto L_0x005f
            L_0x00b0:
                com.didi.dynamic.manager.Module r2 = r6.mModule     // Catch:{ all -> 0x014a }
                boolean r2 = r2.isDownloaded()     // Catch:{ all -> 0x014a }
                if (r2 == 0) goto L_0x00e2
                java.lang.String r2 = "DM.DownloadManager"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x014a }
                r3.<init>()     // Catch:{ all -> 0x014a }
                java.lang.String r4 = "already downloaded, skip:"
                r3.append(r4)     // Catch:{ all -> 0x014a }
                com.didi.dynamic.manager.Module r4 = r6.mModule     // Catch:{ all -> 0x014a }
                r3.append(r4)     // Catch:{ all -> 0x014a }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x014a }
                com.didi.dynamic.manager.utils.Log.m17923d(r2, r3)     // Catch:{ all -> 0x014a }
                monitor-exit(r1)     // Catch:{ all -> 0x014a }
                com.didi.dynamic.manager.DownloadManager r0 = com.didi.dynamic.manager.DownloadManager.this
                java.util.HashMap r2 = r0.f21188n
                monitor-enter(r2)
                monitor-exit(r2)     // Catch:{ all -> 0x00df }
                java.util.concurrent.CountDownLatch r0 = r6.mDoneSignal
                if (r0 == 0) goto L_0x0024
                goto L_0x0021
            L_0x00df:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x00df }
                throw r0
            L_0x00e2:
                com.didi.dynamic.manager.DownloadManager r2 = com.didi.dynamic.manager.DownloadManager.this     // Catch:{ all -> 0x014a }
                java.util.HashMap r2 = r2.f21188n     // Catch:{ all -> 0x014a }
                com.didi.dynamic.manager.Module r3 = r6.mModule     // Catch:{ all -> 0x014a }
                r2.put(r3, r6)     // Catch:{ all -> 0x014a }
                r0 = 1
                monitor-exit(r1)     // Catch:{ all -> 0x014a }
                com.didi.dynamic.manager.Module r1 = r6.mModule     // Catch:{ all -> 0x014d }
                int r1 = r1.launchType     // Catch:{ all -> 0x014d }
                r2 = 3
                if (r1 != r2) goto L_0x011e
                com.didi.dynamic.manager.DownloadManager r1 = com.didi.dynamic.manager.DownloadManager.this     // Catch:{ all -> 0x014d }
                android.content.Context r1 = r1.f21185h     // Catch:{ all -> 0x014d }
                boolean r1 = com.didi.dynamic.manager.utils.NetworkUtil.isNetworkWifi(r1)     // Catch:{ all -> 0x014d }
                if (r1 != 0) goto L_0x011e
                com.didi.dynamic.manager.DownloadManager r0 = com.didi.dynamic.manager.DownloadManager.this
                java.util.HashMap r1 = r0.f21188n
                monitor-enter(r1)
                com.didi.dynamic.manager.DownloadManager r0 = com.didi.dynamic.manager.DownloadManager.this     // Catch:{ all -> 0x011b }
                java.util.HashMap r0 = r0.f21188n     // Catch:{ all -> 0x011b }
                com.didi.dynamic.manager.Module r2 = r6.mModule     // Catch:{ all -> 0x011b }
                r0.remove(r2)     // Catch:{ all -> 0x011b }
                monitor-exit(r1)     // Catch:{ all -> 0x011b }
                java.util.concurrent.CountDownLatch r0 = r6.mDoneSignal
                if (r0 == 0) goto L_0x0024
                goto L_0x0021
            L_0x011b:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x011b }
                throw r0
            L_0x011e:
                com.didi.dynamic.manager.DownloadManager r1 = com.didi.dynamic.manager.DownloadManager.this     // Catch:{ all -> 0x014d }
                com.didi.dynamic.manager.Module r2 = r6.mModule     // Catch:{ all -> 0x014d }
                boolean r3 = r6.mNotifyCallback     // Catch:{ all -> 0x014d }
                com.didi.dynamic.manager.Module unused = r1.m17869a(r2, r3, r6)     // Catch:{ all -> 0x014d }
                com.didi.dynamic.manager.DownloadManager r0 = com.didi.dynamic.manager.DownloadManager.this
                java.util.HashMap r1 = r0.f21188n
                monitor-enter(r1)
                com.didi.dynamic.manager.DownloadManager r0 = com.didi.dynamic.manager.DownloadManager.this     // Catch:{ all -> 0x0147 }
                java.util.HashMap r0 = r0.f21188n     // Catch:{ all -> 0x0147 }
                com.didi.dynamic.manager.Module r2 = r6.mModule     // Catch:{ all -> 0x0147 }
                r0.remove(r2)     // Catch:{ all -> 0x0147 }
                monitor-exit(r1)     // Catch:{ all -> 0x0147 }
                java.util.concurrent.CountDownLatch r0 = r6.mDoneSignal
                if (r0 == 0) goto L_0x0141
                r0.countDown()
            L_0x0141:
                java.util.concurrent.CountDownLatch r0 = r6.mCompletedSignal
                r0.countDown()
                return
            L_0x0147:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0147 }
                throw r0
            L_0x014a:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x014a }
                throw r2     // Catch:{ all -> 0x014d }
            L_0x014d:
                r1 = move-exception
                com.didi.dynamic.manager.DownloadManager r2 = com.didi.dynamic.manager.DownloadManager.this
                java.util.HashMap r2 = r2.f21188n
                monitor-enter(r2)
                if (r0 == 0) goto L_0x0162
                com.didi.dynamic.manager.DownloadManager r0 = com.didi.dynamic.manager.DownloadManager.this     // Catch:{ all -> 0x0170 }
                java.util.HashMap r0 = r0.f21188n     // Catch:{ all -> 0x0170 }
                com.didi.dynamic.manager.Module r3 = r6.mModule     // Catch:{ all -> 0x0170 }
                r0.remove(r3)     // Catch:{ all -> 0x0170 }
            L_0x0162:
                monitor-exit(r2)     // Catch:{ all -> 0x0170 }
                java.util.concurrent.CountDownLatch r0 = r6.mDoneSignal
                if (r0 == 0) goto L_0x016a
                r0.countDown()
            L_0x016a:
                java.util.concurrent.CountDownLatch r0 = r6.mCompletedSignal
                r0.countDown()
                throw r1
            L_0x0170:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0170 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.dynamic.manager.DownloadManager.DownloadTask.run():void");
        }
    }

    class Scheduler implements Application.ActivityLifecycleCallbacks, Runnable {
        int mActivityCount = 0;

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        Scheduler() {
        }

        public void onActivityResumed(Activity activity) {
            this.mActivityCount++;
        }

        public void onActivityStopped(Activity activity) {
            int i = this.mActivityCount - 1;
            this.mActivityCount = i;
            if (i == 0) {
                com.didi.dynamic.manager.utils.Log.m17927i(DownloadManager.f21174a, "Scheduled check task");
                DownloadManager.f21181i.postDelayed(this, 500);
            }
        }

        public void run() {
            DownloadManager.this.checkModuleAndDownload();
        }
    }
}
