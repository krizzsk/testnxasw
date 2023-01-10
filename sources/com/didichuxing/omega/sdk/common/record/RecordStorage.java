package com.didichuxing.omega.sdk.common.record;

import android.content.Context;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.backend.UploadStrategy;
import com.didichuxing.omega.sdk.common.perforence.RuntimeCheck;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import com.didichuxing.omega.sdk.common.utils.Constants;
import java.io.File;
import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RecordStorage {
    private static Context mContext;
    private static File mInternalRecordDir;
    private static String mNativeCrashDirecotry;
    private static File mNativeCrashDmpCacheDir;
    private static File mRecordCacheDir;
    private static File mRecordDir;

    public static void init(Context context) {
        mContext = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0068, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void save(com.didichuxing.omega.sdk.common.record.Record r5) {
        /*
            java.lang.Class<com.didichuxing.omega.sdk.common.record.RecordStorage> r0 = com.didichuxing.omega.sdk.common.record.RecordStorage.class
            monitor-enter(r0)
            boolean r1 = r5 instanceof com.didichuxing.omega.sdk.common.record.EventsRecord     // Catch:{ all -> 0x008c }
            if (r1 == 0) goto L_0x0069
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x008c }
            r1.<init>()     // Catch:{ all -> 0x008c }
            java.lang.String r2 = "omega_e_"
            r1.append(r2)     // Catch:{ all -> 0x008c }
            java.lang.String r2 = com.didichuxing.omega.sdk.common.perforence.RuntimeCheck.getProcessNameInMD5()     // Catch:{ all -> 0x008c }
            r1.append(r2)     // Catch:{ all -> 0x008c }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ all -> 0x008c }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x008c }
            r1.append(r2)     // Catch:{ all -> 0x008c }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ all -> 0x008c }
            java.lang.String r2 = r5.getRecordId()     // Catch:{ all -> 0x008c }
            r1.append(r2)     // Catch:{ all -> 0x008c }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ all -> 0x008c }
            java.lang.Long r2 = r5.getSeq()     // Catch:{ all -> 0x008c }
            r1.append(r2)     // Catch:{ all -> 0x008c }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x008c }
            java.util.List r2 = packRecord(r5)     // Catch:{ all -> 0x008c }
            r3 = 0
            boolean r4 = r5 instanceof com.didichuxing.omega.sdk.common.record.EventsRecord     // Catch:{ all -> 0x0059 }
            if (r4 == 0) goto L_0x0052
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0059 }
            java.io.File r4 = getInternalRecordDir()     // Catch:{ all -> 0x0059 }
            r3.<init>(r4, r1)     // Catch:{ all -> 0x0059 }
        L_0x0052:
            com.didichuxing.omega.sdk.analysis.Security.zip(r5, r2, r3)     // Catch:{ all -> 0x0059 }
            r3.length()     // Catch:{ all -> 0x0059 }
            goto L_0x0067
        L_0x0059:
            java.lang.String r1 = "RecordStorage.save() fail"
            com.didichuxing.omega.sdk.common.utils.OLog.m38212w(r1)     // Catch:{ all -> 0x008c }
            boolean r1 = r5 instanceof com.didichuxing.omega.sdk.common.record.EventsRecord     // Catch:{ all -> 0x008c }
            if (r1 == 0) goto L_0x0067
            com.didichuxing.omega.sdk.common.record.EventsRecord r5 = (com.didichuxing.omega.sdk.common.record.EventsRecord) r5     // Catch:{ all -> 0x008c }
            com.didichuxing.omega.sdk.common.backend.UploadStrategy.sendDirectly(r5, r2)     // Catch:{ all -> 0x008c }
        L_0x0067:
            monitor-exit(r0)
            return
        L_0x0069:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x008c }
            r1.<init>()     // Catch:{ all -> 0x008c }
            java.lang.String r2 = "RecordStorage.save(): Unexpected record type:"
            r1.append(r2)     // Catch:{ all -> 0x008c }
            java.lang.Class r5 = r5.getClass()     // Catch:{ all -> 0x008c }
            java.lang.String r5 = r5.getName()     // Catch:{ all -> 0x008c }
            r1.append(r5)     // Catch:{ all -> 0x008c }
            java.lang.String r5 = "."
            r1.append(r5)     // Catch:{ all -> 0x008c }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x008c }
            com.didichuxing.omega.sdk.common.utils.OLog.m38206e(r5)     // Catch:{ all -> 0x008c }
            monitor-exit(r0)
            return
        L_0x008c:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.common.record.RecordStorage.save(com.didichuxing.omega.sdk.common.record.Record):void");
    }

    public static String sendWithoutSave(String str, Record record) {
        return UploadStrategy.sendDirectly(str, record, packRecord(record));
    }

    public static synchronized List<File> getAllRecordFiles() {
        LinkedList linkedList;
        synchronized (RecordStorage.class) {
            linkedList = new LinkedList();
            File internalRecordDir = getInternalRecordDir();
            if (internalRecordDir != null) {
                File[] listFiles = internalRecordDir.listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        if (file.getName().startsWith("omega_e_" + RuntimeCheck.getProcessNameInMD5())) {
                            linkedList.add(file);
                        }
                    }
                }
            } else {
                Tracker.trackGood("event internalrecordDir is null", (Throwable) null);
            }
        }
        return linkedList;
    }

    public static void deleteRecordFile(File file) {
        doubleDelete(file);
    }

    private static void doubleDelete(File file) {
        if (file != null && file.exists() && file.isFile() && !file.delete() && !file.delete()) {
            Tracker.trackError("delete_record_file_failed", "DeleteRecordFileFailed", "", "", (Map<String, Object>) null);
        }
    }

    public static void deleteRecordFile(String str) {
        deleteRecordFile(new File(getRecordDir(), str));
    }

    public static List<Map.Entry<String, byte[]>> packRecord(Record record) {
        LinkedList linkedList = new LinkedList();
        String json = record.toJson();
        linkedList.add(new AbstractMap.SimpleEntry(0 + ".json", json.getBytes()));
        return linkedList;
    }

    public static File getInternalRecordDir() {
        if (mInternalRecordDir == null) {
            mInternalRecordDir = new File(mContext.getFilesDir(), Constants.DIR_STORAGE_CACHE_ROOT);
        }
        try {
            if (!mInternalRecordDir.exists()) {
                mInternalRecordDir.mkdir();
            }
        } catch (Throwable unused) {
        }
        return mInternalRecordDir;
    }

    public static File getRecordDir() {
        if (mRecordDir == null) {
            File file = null;
            try {
                file = mContext.getExternalFilesDir("omega");
            } catch (Throwable th) {
                Tracker.trackGood("getExternalFilesDir fail", th);
            }
            if (file == null) {
                mRecordDir = mContext.getFilesDir();
            } else if (CommonUtil.getAPILevel() >= 19) {
                mRecordDir = file;
            } else {
                mRecordDir = mContext.getFilesDir();
            }
        }
        return mRecordDir;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File getRecordCacheDir() {
        /*
            java.io.File r0 = mRecordCacheDir
            if (r0 != 0) goto L_0x0034
            r0 = 0
            android.content.Context r1 = mContext     // Catch:{ all -> 0x001e }
            java.io.File r0 = r1.getExternalCacheDir()     // Catch:{ all -> 0x001e }
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x001e }
            java.lang.String r2 = "omega"
            r1.<init>(r0, r2)     // Catch:{ all -> 0x001e }
            boolean r0 = r1.exists()     // Catch:{ all -> 0x001c }
            if (r0 != 0) goto L_0x0027
            r1.mkdir()     // Catch:{ all -> 0x001c }
            goto L_0x0027
        L_0x001c:
            r0 = move-exception
            goto L_0x0022
        L_0x001e:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
        L_0x0022:
            java.lang.String r2 = "getExternalCacheDir fail"
            com.didichuxing.omega.sdk.analysis.Tracker.trackGood(r2, r0)
        L_0x0027:
            if (r1 != 0) goto L_0x0032
            android.content.Context r0 = mContext
            java.io.File r0 = r0.getCacheDir()
            mRecordCacheDir = r0
            goto L_0x0034
        L_0x0032:
            mRecordCacheDir = r1
        L_0x0034:
            java.io.File r0 = mRecordCacheDir
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.common.record.RecordStorage.getRecordCacheDir():java.io.File");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File getNativeCrashDmpCacheDir() {
        /*
            java.io.File r0 = mNativeCrashDmpCacheDir
            if (r0 != 0) goto L_0x002b
            r0 = 0
            android.content.Context r1 = mContext     // Catch:{ all -> 0x001d }
            java.io.File r0 = r1.getExternalCacheDir()     // Catch:{ all -> 0x001d }
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x001d }
            java.lang.String r2 = "alpha_nc"
            r1.<init>(r0, r2)     // Catch:{ all -> 0x001d }
            boolean r0 = r1.exists()     // Catch:{ all -> 0x001c }
            if (r0 != 0) goto L_0x001e
            r1.mkdir()     // Catch:{ all -> 0x001c }
            goto L_0x001e
        L_0x001c:
            r0 = r1
        L_0x001d:
            r1 = r0
        L_0x001e:
            if (r1 != 0) goto L_0x0029
            android.content.Context r0 = mContext
            java.io.File r0 = r0.getCacheDir()
            mNativeCrashDmpCacheDir = r0
            goto L_0x002b
        L_0x0029:
            mNativeCrashDmpCacheDir = r1
        L_0x002b:
            java.io.File r0 = mNativeCrashDmpCacheDir
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.common.record.RecordStorage.getNativeCrashDmpCacheDir():java.io.File");
    }

    public static File getLogFile(File[] fileArr) {
        for (File file : fileArr) {
            if (file.getName().equals("1.log")) {
                return file;
            }
        }
        return null;
    }

    public static File[] getNativeCrashFiles() {
        if (getNativeCrashPath() == null) {
            return null;
        }
        File file = new File(getNativeCrashPath());
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        return file.listFiles();
    }

    public static String getNativeCrashPath() {
        String str = mNativeCrashDirecotry;
        if (str != null) {
            return str;
        }
        String absolutePath = getNativeCrashDmpCacheDir().getAbsolutePath();
        mNativeCrashDirecotry = absolutePath;
        return absolutePath;
    }

    public static void setNativeCrashDirecotry(String str) {
        mNativeCrashDirecotry = str;
    }

    public static boolean doubleDeleteFile(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        boolean delete = file.delete();
        return !delete ? file.delete() : delete;
    }
}
