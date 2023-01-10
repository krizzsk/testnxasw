package com.didi.dimina.webview.resource.offline;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.dimina.webview.FusionEngine;
import com.didi.dimina.webview.FusionInitConfig;
import com.didi.dimina.webview.resource.FusionAsynDispatcher;
import com.didi.dimina.webview.resource.FusionHttpClient;
import com.didi.dimina.webview.util.C8407Util;
import com.didi.dimina.webview.util.DeviceUtil;
import com.didi.dimina.webview.util.HttpUtil;
import com.didi.dimina.webview.util.NetworkUtil;
import com.didi.dimina.webview.util.WsgSafeUtil;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OfflineBundleManager {

    /* renamed from: a */
    private static final String f20238a = "bundles";

    /* renamed from: b */
    private static final String f20239b = "app_version";

    /* renamed from: c */
    private static final String f20240c = "app_key";

    /* renamed from: d */
    private static final String f20241d = "device_type";

    /* renamed from: e */
    private static final String f20242e = "device_id";

    /* renamed from: f */
    private static final String f20243f = "os_type";

    /* renamed from: g */
    private static final String f20244g = "phone";

    /* renamed from: h */
    private static final String f20245h = "city";

    /* renamed from: i */
    private static final String f20246i = "fusion_hybrid";

    /* renamed from: j */
    private static final String f20247j = "download_temp";

    /* renamed from: k */
    private static OfflineBundleManager f20248k;

    /* renamed from: z */
    private static final AtomicBoolean f20249z = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f20250A = false;

    /* renamed from: B */
    private FusionOfflineEventBroadcastReceiver f20251B;

    /* renamed from: l */
    private final Context f20252l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final BundleInfoDao f20253m;

    /* renamed from: n */
    private String f20254n;

    /* renamed from: o */
    private final int f20255o;

    /* renamed from: p */
    private final String f20256p;

    /* renamed from: q */
    private final String f20257q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public File f20258r;

    /* renamed from: s */
    private File f20259s;

    /* renamed from: t */
    private ConcurrentHashMap<String, HashMap<String, ArrayList<OfflineBundleInfo>>> f20260t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public CopyOnWriteArrayList<OfflineBundleInfo> f20261u;

    /* renamed from: v */
    private final UrlTrieTree f20262v = new UrlTrieTree();
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f20263w = false;

    /* renamed from: x */
    private int f20264x = Integer.MAX_VALUE;

    /* renamed from: y */
    private NetworkChangedReceiver f20265y;

    public static synchronized void init(Application application, FusionInitConfig fusionInitConfig) {
        synchronized (OfflineBundleManager.class) {
            if (f20248k == null) {
                f20248k = new OfflineBundleManager(application, fusionInitConfig);
                f20249z.getAndSet(true);
            }
            f20248k.m17069a();
        }
    }

    public static OfflineBundleManager getInstance() {
        return f20248k;
    }

    public static boolean isInitialized() {
        return f20249z.get();
    }

    private OfflineBundleManager(Context context, FusionInitConfig fusionInitConfig) {
        this.f20252l = context;
        this.f20253m = new BundleInfoDao(context);
        this.f20257q = fusionInitConfig.getHybridUrl();
        this.f20256p = fusionInitConfig.getAppKey();
        this.f20254n = fusionInitConfig.getPhone();
        this.f20255o = fusionInitConfig.getCityId();
    }

    /* renamed from: a */
    private void m17069a() {
        this.f20258r = this.f20252l.getDir(f20246i, 0);
        File file = new File(this.f20258r, f20247j);
        this.f20259s = file;
        if (!file.exists()) {
            this.f20259s.mkdirs();
        }
    }

    public File findBundleFileEx(String str) {
        OfflineBundleInfo searchUrlEx;
        if (str.length() >= this.f20264x && (searchUrlEx = this.f20262v.searchUrlEx(str)) != null && searchUrlEx.isValid()) {
            File file = new File(new File(this.f20258r, searchUrlEx.getBundleDirName()), str.substring(searchUrlEx.getOriginUrl().length()));
            if (file.exists()) {
                return file;
            }
        }
        return null;
    }

    public void startUpdate() {
        if (TextUtils.isEmpty(this.f20254n)) {
            this.f20254n = FusionEngine.getBusinessAgent().getUserPhone();
        }
        if (TextUtils.isEmpty(this.f20254n)) {
            this.f20254n = "";
        }
        if (!TextUtils.isEmpty(this.f20257q) && !TextUtils.isEmpty(this.f20256p)) {
            FusionAsynDispatcher.Instance.asynRunTask(new Runnable() {
                public void run() {
                    OfflineBundleManager offlineBundleManager = OfflineBundleManager.this;
                    CopyOnWriteArrayList unused = offlineBundleManager.f20261u = offlineBundleManager.m17077c();
                    HashMap hashMap = new HashMap();
                    Iterator it = OfflineBundleManager.this.f20261u.iterator();
                    while (it.hasNext()) {
                        OfflineBundleInfo offlineBundleInfo = (OfflineBundleInfo) it.next();
                        hashMap.put(offlineBundleInfo.getBundleName(), offlineBundleInfo);
                    }
                    CopyOnWriteArrayList c = OfflineBundleManager.this.m17080d();
                    Iterator it2 = c.iterator();
                    while (it2.hasNext()) {
                        OfflineBundleInfo offlineBundleInfo2 = (OfflineBundleInfo) it2.next();
                        if (hashMap.containsKey(offlineBundleInfo2.getBundleName())) {
                            ((OfflineBundleInfo) hashMap.get(offlineBundleInfo2.getBundleName())).setState(0);
                        }
                    }
                    boolean unused2 = OfflineBundleManager.this.f20250A = true;
                    Iterator it3 = c.iterator();
                    while (it3.hasNext()) {
                        OfflineBundleInfo offlineBundleInfo3 = (OfflineBundleInfo) it3.next();
                        if (hashMap.containsKey(offlineBundleInfo3.getBundleName())) {
                            if (offlineBundleInfo3.isDelete() || offlineBundleInfo3.isRollback()) {
                                OfflineBundleInfo offlineBundleInfo4 = (OfflineBundleInfo) hashMap.get(offlineBundleInfo3.getBundleName());
                                File file = new File(OfflineBundleManager.this.f20258r, offlineBundleInfo4.getBundleDirName());
                                if (file.exists()) {
                                    file.delete();
                                }
                                offlineBundleInfo4.updateInfo(offlineBundleInfo3);
                                OfflineBundleManager.this.f20253m.deleteBundleInfo(offlineBundleInfo4);
                            } else if (offlineBundleInfo3.isComplete()) {
                                OfflineBundleManager.this.m17071a(offlineBundleInfo3, 1);
                                OfflineBundleInfo offlineBundleInfo5 = (OfflineBundleInfo) hashMap.get(offlineBundleInfo3.getBundleName());
                                File file2 = new File(OfflineBundleManager.this.f20258r, offlineBundleInfo5.getBundleDirName());
                                if (file2.exists()) {
                                    file2.delete();
                                }
                                offlineBundleInfo5.updateInfo(offlineBundleInfo3);
                                OfflineBundleManager.this.f20253m.updateBundleInfo(offlineBundleInfo5);
                            }
                        } else if (!offlineBundleInfo3.isDelete() && !offlineBundleInfo3.isRollback() && offlineBundleInfo3.isComplete()) {
                            OfflineBundleManager.this.m17071a(offlineBundleInfo3, 1);
                            OfflineBundleManager.this.f20261u.add(offlineBundleInfo3);
                            OfflineBundleManager.this.f20253m.addBundleInfo(offlineBundleInfo3);
                        }
                    }
                    OfflineBundleManager.this.f20253m.destroy();
                    OfflineBundleManager.this.m17075b();
                    if (OfflineBundleManager.this.f20263w) {
                        OfflineBundleManager.this.m17083f();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17075b() {
        CopyOnWriteArrayList<OfflineBundleInfo> copyOnWriteArrayList = this.f20261u;
        if (copyOnWriteArrayList != null) {
            Iterator<OfflineBundleInfo> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                m17070a(it.next());
            }
        }
    }

    /* renamed from: a */
    private void m17070a(OfflineBundleInfo offlineBundleInfo) {
        if (offlineBundleInfo.isValid()) {
            if (offlineBundleInfo.getOriginUrl().length() < this.f20264x) {
                this.f20264x = offlineBundleInfo.getOriginUrl().length();
            }
            this.f20262v.addNode(offlineBundleInfo.getOriginUrl(), offlineBundleInfo);
        }
    }

    /* renamed from: b */
    private void m17076b(OfflineBundleInfo offlineBundleInfo) {
        Uri parse = Uri.parse(offlineBundleInfo.getOriginUrl());
        String scheme = parse.getScheme();
        String host = parse.getHost();
        if (offlineBundleInfo.getOriginUrl().length() < this.f20264x) {
            this.f20264x = offlineBundleInfo.getOriginUrl().length();
        }
        if (!this.f20260t.containsKey(scheme)) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            arrayList.add(offlineBundleInfo);
            hashMap.put(host, arrayList);
            this.f20260t.put(scheme, hashMap);
        } else if (this.f20260t.get(scheme).containsKey(host)) {
            ((ArrayList) this.f20260t.get(scheme).get(host)).add(offlineBundleInfo);
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(offlineBundleInfo);
            this.f20260t.get(scheme).put(host, arrayList2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public CopyOnWriteArrayList<OfflineBundleInfo> m17077c() {
        return new CopyOnWriteArrayList<>(this.f20253m.loadAllBundleInfos());
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public CopyOnWriteArrayList<OfflineBundleInfo> m17080d() {
        CopyOnWriteArrayList<OfflineBundleInfo> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        HashMap hashMap = new HashMap();
        hashMap.put("app_key", this.f20256p);
        hashMap.put("app_version", C8407Util.getVersionNameAndCode(this.f20252l));
        hashMap.put("device_type", WsgSafeUtil.getModel(this.f20252l));
        hashMap.put("device_id", DeviceUtil.getUUID(this.f20252l));
        hashMap.put("os_type", Build.VERSION.SDK_INT + "");
        hashMap.put("phone", this.f20254n);
        hashMap.put("city", this.f20255o + "");
        hashMap.put(f20238a, m17082e());
        try {
            String executeGetRequest = new FusionHttpClient(HttpUtil.appendQueryParams(this.f20257q, hashMap), (Map<String, String>) null).executeGetRequest();
            if (!TextUtils.isEmpty(executeGetRequest)) {
                JSONArray jSONArray = new JSONObject(executeGetRequest).getJSONArray(f20238a);
                for (int i = 0; i < jSONArray.length(); i++) {
                    OfflineBundleInfo fromJson = OfflineBundleInfo.fromJson(jSONArray.getJSONObject(i));
                    if (fromJson != null) {
                        copyOnWriteArrayList.add(fromJson);
                    }
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return copyOnWriteArrayList;
    }

    /* renamed from: e */
    private String m17082e() {
        CopyOnWriteArrayList<OfflineBundleInfo> copyOnWriteArrayList = this.f20261u;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<OfflineBundleInfo> it = this.f20261u.iterator();
        while (it.hasNext()) {
            OfflineBundleInfo next = it.next();
            sb.append(String.format("%s:%s;", new Object[]{next.getBundleName(), next.getBundleVersion()}));
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00ad, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006a A[Catch:{ IOException -> 0x0063 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0079 A[Catch:{ IOException -> 0x0063 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a3  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m17071a(com.didi.dimina.webview.resource.offline.OfflineBundleInfo r8, int r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            if (r8 == 0) goto L_0x00ac
            boolean r0 = r8.isRollback()     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x000b
            goto L_0x00ac
        L_0x000b:
            android.content.Context r0 = r7.f20252l     // Catch:{ all -> 0x00a9 }
            boolean r0 = com.didi.dimina.webview.util.NetworkUtil.isNetworkWifi(r0)     // Catch:{ all -> 0x00a9 }
            r1 = 2
            r2 = 1
            if (r0 != 0) goto L_0x0023
            int r0 = r8.getDownloadMode()     // Catch:{ all -> 0x00a9 }
            if (r0 != r1) goto L_0x0023
            r9 = 4
            r8.setState(r9)     // Catch:{ all -> 0x00a9 }
            r7.f20263w = r2     // Catch:{ all -> 0x00a9 }
            monitor-exit(r7)
            return
        L_0x0023:
            r0 = 3
            if (r9 == r0) goto L_0x002e
            int r9 = r8.getDownloadMode()     // Catch:{ all -> 0x00a9 }
            if (r9 != r0) goto L_0x002e
            monitor-exit(r7)
            return
        L_0x002e:
            r8.setState(r2)     // Catch:{ all -> 0x00a9 }
            java.io.File r9 = new java.io.File     // Catch:{ all -> 0x00a9 }
            java.io.File r3 = r7.f20259s     // Catch:{ all -> 0x00a9 }
            java.lang.String r4 = r8.getBundleFileName()     // Catch:{ all -> 0x00a9 }
            r9.<init>(r3, r4)     // Catch:{ all -> 0x00a9 }
            boolean r3 = r9.exists()     // Catch:{ all -> 0x00a9 }
            r4 = 0
            if (r3 == 0) goto L_0x0067
            java.lang.String r3 = com.didi.dimina.webview.util.MD5Util.fileMD5(r9)     // Catch:{ IOException -> 0x0063 }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ IOException -> 0x0063 }
            if (r5 != 0) goto L_0x0058
            java.lang.String r5 = r8.getMd5()     // Catch:{ IOException -> 0x0063 }
            boolean r3 = r3.equalsIgnoreCase(r5)     // Catch:{ IOException -> 0x0063 }
            if (r3 == 0) goto L_0x0058
            goto L_0x0068
        L_0x0058:
            boolean r2 = r9.delete()     // Catch:{ IOException -> 0x0063 }
            if (r2 != 0) goto L_0x0067
            r8.setState(r0)     // Catch:{ IOException -> 0x0063 }
            monitor-exit(r7)
            return
        L_0x0063:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ all -> 0x00a9 }
        L_0x0067:
            r2 = 0
        L_0x0068:
            if (r2 != 0) goto L_0x0077
            com.didi.dimina.webview.resource.FusionHttpClient r2 = new com.didi.dimina.webview.resource.FusionHttpClient     // Catch:{ all -> 0x00a9 }
            java.lang.String r3 = r8.getDownloadUrl()     // Catch:{ all -> 0x00a9 }
            r2.<init>(r3)     // Catch:{ all -> 0x00a9 }
            boolean r2 = r2.executeDownload(r9)     // Catch:{ all -> 0x00a9 }
        L_0x0077:
            if (r2 == 0) goto L_0x009f
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x00a9 }
            java.io.File r5 = r7.f20258r     // Catch:{ all -> 0x00a9 }
            java.lang.String r6 = r8.getBundleDirName()     // Catch:{ all -> 0x00a9 }
            r3.<init>(r5, r6)     // Catch:{ all -> 0x00a9 }
            boolean r5 = r3.exists()     // Catch:{ all -> 0x00a9 }
            if (r5 == 0) goto L_0x008d
            r3.delete()     // Catch:{ all -> 0x00a9 }
        L_0x008d:
            r3.mkdirs()     // Catch:{ all -> 0x00a9 }
            com.didi.dimina.webview.util.ZipUtil.unzip(r9, r3)     // Catch:{ IOException -> 0x009d }
            boolean r3 = r9.exists()     // Catch:{ IOException -> 0x009d }
            if (r3 == 0) goto L_0x009f
            r9.delete()     // Catch:{ IOException -> 0x009d }
            goto L_0x009f
        L_0x009d:
            goto L_0x00a0
        L_0x009f:
            r4 = r2
        L_0x00a0:
            if (r4 == 0) goto L_0x00a3
            goto L_0x00a4
        L_0x00a3:
            r1 = 3
        L_0x00a4:
            r8.setState(r1)     // Catch:{ all -> 0x00a9 }
            monitor-exit(r7)
            return
        L_0x00a9:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        L_0x00ac:
            monitor-exit(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.webview.resource.offline.OfflineBundleManager.m17071a(com.didi.dimina.webview.resource.offline.OfflineBundleInfo, int):void");
    }

    public void registerEventListener() {
        this.f20251B = new FusionOfflineEventBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("fusion_offline_event");
        LocalBroadcastManager.getInstance(this.f20252l.getApplicationContext()).registerReceiver(this.f20251B, intentFilter);
    }

    public void unregisterEventListener() {
        LocalBroadcastManager.getInstance(this.f20252l.getApplicationContext()).unregisterReceiver(this.f20251B);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m17083f() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION);
        this.f20265y = new NetworkChangedReceiver();
        try {
            this.f20252l.getApplicationContext().registerReceiver(this.f20265y, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m17085g() {
        try {
            this.f20252l.getApplicationContext().unregisterReceiver(this.f20265y);
        } catch (Exception e) {
            Log.d("Context", "unregisterReceiver", e);
        }
    }

    public boolean isAllOfflineItemLoaded() {
        return this.f20250A;
    }

    public synchronized void downloadOfflineWhenEvent(final String str) {
        if (NetworkUtil.isAvailable(this.f20252l)) {
            FusionAsynDispatcher.Instance.asynRunTask(new Runnable() {
                public void run() {
                    if (OfflineBundleManager.this.f20261u != null && OfflineBundleManager.this.f20261u.size() > 0) {
                        Iterator it = OfflineBundleManager.this.f20261u.iterator();
                        while (it.hasNext()) {
                            OfflineBundleInfo offlineBundleInfo = (OfflineBundleInfo) it.next();
                            if (offlineBundleInfo.getBundleName().equalsIgnoreCase(str)) {
                                OfflineBundleManager.this.m17071a(offlineBundleInfo, 3);
                                OfflineBundleManager.this.f20253m.updateBundleInfo(offlineBundleInfo);
                                return;
                            }
                        }
                    }
                }
            });
            this.f20253m.destroy();
        }
    }

    private class NetworkChangedReceiver extends BroadcastReceiver {
        private NetworkChangedReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (NetworkUtil.isNetworkWifi(context) && NetworkUtil.isAvailable(context)) {
                FusionAsynDispatcher.Instance.asynRunTask(new Runnable() {
                    public void run() {
                        if (OfflineBundleManager.this.f20261u != null && OfflineBundleManager.this.f20261u.size() > 0) {
                            Iterator it = OfflineBundleManager.this.f20261u.iterator();
                            while (it.hasNext()) {
                                OfflineBundleInfo offlineBundleInfo = (OfflineBundleInfo) it.next();
                                if (offlineBundleInfo.getState() == 4) {
                                    OfflineBundleManager.this.m17071a(offlineBundleInfo, 2);
                                    OfflineBundleManager.this.f20253m.updateBundleInfo(offlineBundleInfo);
                                }
                            }
                        }
                    }
                });
                OfflineBundleManager.this.f20253m.destroy();
                OfflineBundleManager.this.m17085g();
            }
        }
    }
}
