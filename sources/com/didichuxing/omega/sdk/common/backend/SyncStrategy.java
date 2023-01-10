package com.didichuxing.omega.sdk.common.backend;

import android.util.Base64;
import com.didi.entrega.customer.app.constant.Const;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.threadpool.ScheduledTaskObject;
import com.didichuxing.omega.sdk.common.transport.HttpResponse;
import com.didichuxing.omega.sdk.common.transport.HttpSender;
import com.didichuxing.omega.sdk.common.utils.BloomFilter;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import com.didichuxing.omega.sdk.common.utils.JsonUtil;
import com.didichuxing.omega.sdk.common.utils.OLog;
import com.didichuxing.omega.sdk.corelink.node.EventFilterNode;
import com.didichuxing.omega.sdk.corelink.node.EventSpecialNode;
import com.google.common.net.HttpHeaders;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SyncStrategy {
    public static final String KEY_LAST_POLICY_ID = "pid";
    public static final String KEY_LAST_SYNC_TIME = "lst";
    /* access modifiers changed from: private */
    public static volatile boolean mIsSync = false;
    private static Map<String, Object> remoteConfigMap = new HashMap();

    public static void async() {
        if (!mIsSync) {
            new Thread(new Runnable() {
                public void run() {
                    SyncStrategy.sync();
                }
            }).start();
        }
    }

    public static void delaySync() {
        ScheduledTaskObject.getInstance().start(new Runnable() {
            public void run() {
                boolean unused = SyncStrategy.mIsSync = false;
                SyncStrategy.sync();
            }
        }, (long) OmegaConfig.SYNC_REMOTE_INTERVAL, (long) OmegaConfig.SYNC_REMOTE_INTERVAL);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0049, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void sync() {
        /*
            java.lang.Class<com.didichuxing.omega.sdk.common.backend.SyncStrategy> r0 = com.didichuxing.omega.sdk.common.backend.SyncStrategy.class
            monitor-enter(r0)
            boolean r1 = com.didichuxing.omega.sdk.common.OmegaConfig.SWITCH_SYNC     // Catch:{ all -> 0x004a }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)
            return
        L_0x0009:
            java.util.Map r1 = load()     // Catch:{ all -> 0x004a }
            enforce(r1)     // Catch:{ all -> 0x004a }
            com.didichuxing.omega.sdk.analysis.OMGUserStateSetting$OMGUserState r2 = com.didichuxing.omega.sdk.analysis.OMGUserStateSetting.getUserState()     // Catch:{ all -> 0x004a }
            com.didichuxing.omega.sdk.analysis.OMGUserStateSetting$OMGUserState r3 = com.didichuxing.omega.sdk.analysis.OMGUserStateSetting.OMGUserState.OMGUserStateFullAuthorized     // Catch:{ all -> 0x004a }
            if (r2 != r3) goto L_0x001e
            boolean r2 = com.didichuxing.omega.sdk.common.collector.PersistentInfoCollector.getAppInSync()     // Catch:{ all -> 0x004a }
            if (r2 != 0) goto L_0x0026
        L_0x001e:
            boolean r2 = com.didichuxing.omega.sdk.common.OmegaConfig.isDebugModel()     // Catch:{ all -> 0x004a }
            if (r2 != 0) goto L_0x0026
            monitor-exit(r0)
            return
        L_0x0026:
            boolean r2 = mIsSync     // Catch:{ all -> 0x004a }
            if (r2 == 0) goto L_0x002c
            monitor-exit(r0)
            return
        L_0x002c:
            r2 = 1
            mIsSync = r2     // Catch:{ all -> 0x004a }
            java.util.Map r1 = sendAndGet(r1)     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x0048
            java.lang.String r2 = "lst"
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x004a }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x004a }
            r1.put(r2, r3)     // Catch:{ all -> 0x004a }
            dump(r1)     // Catch:{ all -> 0x004a }
            enforce(r1)     // Catch:{ all -> 0x004a }
        L_0x0048:
            monitor-exit(r0)
            return
        L_0x004a:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.common.backend.SyncStrategy.sync():void");
    }

    public static int getPolicyId() {
        Map<String, Object> load = load();
        if (load != null) {
            return CommonUtil.parseInt(load.get("pid"));
        }
        return 0;
    }

    private static Map<String, Object> sendAndGet(Map<String, Object> map) {
        HashMap hashMap;
        String body;
        if (map != null) {
            try {
                hashMap = new HashMap();
                Object obj = map.get(HttpHeaders.LAST_MODIFIED);
                if (obj != null && (obj instanceof String)) {
                    hashMap.put(HttpHeaders.IF_MODIFIED_SINCE, (String) obj);
                }
            } catch (Throwable unused) {
            }
        } else {
            hashMap = null;
        }
        HttpResponse httpResponse = HttpSender.get(UploadStrategy.getUploadSyncUrl(), hashMap);
        if (!(httpResponse == null || (body = httpResponse.getBody()) == null || body.length() == 0)) {
            Map<String, Object> json2Map = JsonUtil.json2Map(body);
            if (json2Map == null) {
                Tracker.trackGood("Sync.sendAndGet fail! json is null.", new Exception(body));
                return null;
            }
            int parseInt = CommonUtil.parseInt(json2Map.get("errno"));
            Object obj2 = json2Map.get("data");
            if (parseInt != 304 && parseInt == 0 && (obj2 instanceof Map)) {
                Map<String, Object> map2 = (Map) obj2;
                List list = httpResponse.getHeaders().get(HttpHeaders.LAST_MODIFIED);
                if (list != null && list.size() > 0) {
                    map2.put(HttpHeaders.LAST_MODIFIED, (String) list.get(0));
                }
                return map2;
            }
        }
        return null;
    }

    private static void enforce(Map<String, Object> map) {
        byte[] decode;
        if (map != null && !map.isEmpty()) {
            Map map2 = (Map) map.get("white_filter");
            if (map2 != null) {
                EventFilterNode.putWhite((List) map2.get("white_list"));
            }
            boolean z = false;
            try {
                Map map3 = (Map) map.get("white_bloom");
                if (map3 != null) {
                    String str = (String) map3.get("eventcode");
                    int intValue = ((Integer) map3.get(Const.PageParams.COUNT)).intValue();
                    if (str != null && !str.equals("") && intValue > 0 && (decode = Base64.decode(str, 0)) != null && decode.length * 8 == intValue) {
                        BloomFilter.getBloomFilter().init(decode, intValue);
                    }
                } else {
                    BloomFilter.getBloomFilter().clear();
                }
            } catch (Exception e) {
                OLog.m38206e("Sync stategy enforce error:" + e.getMessage());
            }
            Map map4 = (Map) map.get("special_list");
            if (map4 != null) {
                EventSpecialNode.putSpecial(map4);
            }
            Map map5 = (Map) map.get("auto_list");
            if (map5 != null) {
                OmegaConfig.addBlackPages((List) map5.get("black_page"));
            }
            Map map6 = (Map) map.get("event_filter");
            if (map6 != null) {
                EventFilterNode.putBlack((List) map6.get("black_list"));
            }
            Map map7 = (Map) map.get("omega_switch");
            if (map7 != null) {
                OmegaConfig.SWITCH_EVENT = CommonUtil.parseInt(map7.get("no_event")) == 0;
                OmegaConfig.SWITCH_CRASH = CommonUtil.parseInt(map7.get("no_crash")) == 0;
                OmegaConfig.SWITCH_OOM_DUMP = CommonUtil.parseInt(map7.get("oom_dump")) > 0;
                OmegaConfig.SWITCH_FULL_AUTO_UI = CommonUtil.parseInt(map7.get("autoui")) > 0;
                OmegaConfig.SWITCH_FULL_AUTO_UI_ENV = CommonUtil.parseInt(map7.get("autoui_env")) > 0;
                if (CommonUtil.parseInt(map7.get("use_https")) > 0) {
                    z = true;
                }
                OmegaConfig.SWITCH_USE_HTTPS = z;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0047 A[SYNTHETIC, Splitter:B:24:0x0047] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.Object> load() {
        /*
            java.util.Map<java.lang.String, java.lang.Object> r0 = remoteConfigMap
            if (r0 == 0) goto L_0x000d
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x000d
            java.util.Map<java.lang.String, java.lang.Object> r0 = remoteConfigMap
            return r0
        L_0x000d:
            java.io.File r0 = new java.io.File
            java.io.File r1 = com.didichuxing.omega.sdk.common.record.RecordStorage.getRecordDir()
            java.lang.String r2 = "remote.conf"
            r0.<init>(r1, r2)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x0021
            java.util.Map<java.lang.String, java.lang.Object> r0 = remoteConfigMap
            return r0
        L_0x0021:
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x003f }
            r2.<init>(r0)     // Catch:{ all -> 0x003f }
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x003c }
            byte[] r1 = com.didichuxing.omega.sdk.common.utils.CommonUtil.stream2ByteArray(r2)     // Catch:{ all -> 0x003c }
            java.lang.String r3 = "UTF-8"
            r0.<init>(r1, r3)     // Catch:{ all -> 0x003c }
            java.util.Map r0 = com.didichuxing.omega.sdk.common.utils.JsonUtil.json2Map(r0)     // Catch:{ all -> 0x003c }
            remoteConfigMap = r0     // Catch:{ all -> 0x003c }
            r2.close()     // Catch:{ IOException -> 0x004a }
            goto L_0x004a
        L_0x003c:
            r0 = move-exception
            r1 = r2
            goto L_0x0040
        L_0x003f:
            r0 = move-exception
        L_0x0040:
            java.lang.String r2 = "SyncStrategy load fail"
            com.didichuxing.omega.sdk.analysis.Tracker.trackGood(r2, r0)     // Catch:{ all -> 0x004d }
            if (r1 == 0) goto L_0x004a
            r1.close()     // Catch:{ IOException -> 0x004a }
        L_0x004a:
            java.util.Map<java.lang.String, java.lang.Object> r0 = remoteConfigMap
            return r0
        L_0x004d:
            r0 = move-exception
            if (r1 == 0) goto L_0x0053
            r1.close()     // Catch:{ IOException -> 0x0053 }
        L_0x0053:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.common.backend.SyncStrategy.load():java.util.Map");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002d A[SYNTHETIC, Splitter:B:14:0x002d] */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void dump(java.util.Map<java.lang.String, java.lang.Object> r3) {
        /*
            java.io.File r0 = new java.io.File
            java.io.File r1 = com.didichuxing.omega.sdk.common.record.RecordStorage.getRecordDir()
            java.lang.String r2 = "remote.conf"
            r0.<init>(r1, r2)
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0025 }
            r2.<init>(r0)     // Catch:{ all -> 0x0025 }
            java.lang.String r3 = com.didichuxing.omega.sdk.common.utils.JsonUtil.map2Json(r3)     // Catch:{ all -> 0x0022 }
            java.lang.String r0 = "UTF-8"
            byte[] r3 = r3.getBytes(r0)     // Catch:{ all -> 0x0022 }
            r2.write(r3)     // Catch:{ all -> 0x0022 }
            r2.close()     // Catch:{ IOException -> 0x0030 }
            goto L_0x0030
        L_0x0022:
            r3 = move-exception
            r1 = r2
            goto L_0x0026
        L_0x0025:
            r3 = move-exception
        L_0x0026:
            java.lang.String r0 = "SyncStrategy dump fail"
            com.didichuxing.omega.sdk.analysis.Tracker.trackGood(r0, r3)     // Catch:{ all -> 0x0031 }
            if (r1 == 0) goto L_0x0030
            r1.close()     // Catch:{ IOException -> 0x0030 }
        L_0x0030:
            return
        L_0x0031:
            r3 = move-exception
            if (r1 == 0) goto L_0x0037
            r1.close()     // Catch:{ IOException -> 0x0037 }
        L_0x0037:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.common.backend.SyncStrategy.dump(java.util.Map):void");
    }
}
