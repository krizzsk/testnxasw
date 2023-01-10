package com.didi.dimina.container.secondparty.trace.inner;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TextUtil;
import com.tencent.mmkv.MMKV;
import java.io.File;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\tJ\u0012\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0002J\u0015\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u001c¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u001f\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010 \u001a\u00020\u0011H\u0016J\u0006\u0010!\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\""}, mo148868d2 = {"Lcom/didi/dimina/container/secondparty/trace/inner/LogCollectThread;", "Ljava/lang/Thread;", "()V", "LOG_BUNDLE_COUNT", "", "TAG", "", "logQueue", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lcom/didi/dimina/container/secondparty/trace/inner/LogBase;", "mPid", "mTempFileCount", "getMTempFileCount", "()I", "setMTempFileCount", "(I)V", "add", "", "log", "addLogRecord", "fileName", "addTempLogRecord", "deleteFile", "doubleDelete", "file", "Ljava/io/File;", "generateFileName", "getAllMkKey", "", "()[Ljava/lang/String;", "remove", "removeTempLogRecord", "run", "startCollect", "2party-impl_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: LogCollectThread.kt */
public final class LogCollectThread extends Thread {
    public static final LogCollectThread INSTANCE = new LogCollectThread();

    /* renamed from: a */
    private static final LinkedBlockingQueue<LogBase> f19347a = new LinkedBlockingQueue<>();

    /* renamed from: b */
    private static final int f19348b = Process.myPid();

    /* renamed from: c */
    private static final int f19349c = 10;

    /* renamed from: d */
    private static final String f19350d = "LogCollectThread";

    /* renamed from: e */
    private static int f19351e;

    private LogCollectThread() {
        super("DMTraceInnerLogCollectThread");
    }

    public final void startCollect() {
        try {
            if (!isAlive()) {
                start();
            }
        } catch (Exception e) {
            LogUtil.eRelease(f19350d, "got an exception " + Log.getStackTraceString(e));
        }
    }

    public final void add(LogBase logBase) {
        if (logBase != null) {
            f19347a.offer(logBase);
        }
    }

    public void run() {
        MMKV mmkv;
        MMKV mmkv2 = null;
        String str = null;
        while (true) {
            int i = 0;
            while (true) {
                try {
                    LogBase take = f19347a.take();
                    if (take != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("get a log logcount is ");
                        int i2 = i + 1;
                        sb.append(i2);
                        LogUtil.iRelease(f19350d, sb.toString());
                        if (i == 0 || mmkv2 == null) {
                            LogUtil.iRelease(f19350d, "generate a new file to store logs");
                            str = m16419a();
                            m16423c(str);
                            mmkv2 = MMKV.mmkvWithID(str, LogManager.INSTANCE.getMRecordDataPath());
                        }
                        if (mmkv2 != null) {
                            mmkv2.encode(take.getSeq(), take.toJsonStr());
                        }
                        if (i2 >= 10) {
                            try {
                                LogUtil.iRelease(f19350d, "log count >= 10");
                                if (mmkv2 != null) {
                                    mmkv2.close();
                                }
                                mmkv = null;
                                try {
                                    m16422b(str);
                                    m16421a(str);
                                    LogUtil.iRelease(f19350d, "LogFileSendThread.wakeup()");
                                    LogFileSendThread.INSTANCE.wakeUp();
                                    break;
                                } catch (Throwable th) {
                                    th = th;
                                    mmkv2 = mmkv;
                                    i = 0;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                i = i2;
                                LogUtil.eRelease(f19350d, "got a exception " + th);
                            }
                        } else {
                            i = i2;
                        }
                    } else {
                        continue;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    LogUtil.eRelease(f19350d, "got a exception " + th);
                }
            }
            mmkv2 = mmkv;
        }
    }

    public final int getMTempFileCount() {
        return f19351e;
    }

    public final void setMTempFileCount(int i) {
        f19351e = i;
    }

    /* renamed from: a */
    private final void m16421a(String str) {
        LogUtil.iRelease(f19350d, "removeTempLogRecord");
        if (!TextUtils.isEmpty(str)) {
            synchronized (LogTracker.INSTANCE.getClass()) {
                LogManager logManager = LogManager.INSTANCE;
                logManager.printIsNotMainProcess$2party_impl_release("removeTempLogRecord: " + str);
                MMKV mmkvWithID = MMKV.mmkvWithID(LogManager.MMKV_KEY_TEMP_FILE, LogManager.INSTANCE.getMRecordRootPath());
                if (mmkvWithID != null) {
                    mmkvWithID.removeValueForKey(str);
                }
                int i = f19351e;
                f19351e = i + 1;
                if (i >= 10) {
                    if (mmkvWithID != null) {
                        mmkvWithID.trim();
                    }
                    f19351e = 0;
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* renamed from: b */
    private final void m16422b(String str) {
        LogUtil.iRelease(f19350d, "addLogRecord");
        if (!TextUtils.isEmpty(str)) {
            synchronized (LogTracker.INSTANCE.getClass()) {
                LogManager logManager = LogManager.INSTANCE;
                logManager.printIsNotMainProcess$2party_impl_release("addLogRecord: " + str);
                MMKV mmkvWithID = MMKV.mmkvWithID(LogManager.MMKV_KEY_SEND_FILE, LogManager.INSTANCE.getMRecordRootPath());
                if (mmkvWithID != null) {
                    Boolean.valueOf(mmkvWithID.encode(str, " "));
                }
            }
        }
    }

    /* renamed from: c */
    private final void m16423c(String str) {
        LogUtil.iRelease(f19350d, "addTempLogRecord");
        if (!TextUtil.isEmpty(str)) {
            synchronized (LogTracker.INSTANCE.getClass()) {
                LogManager logManager = LogManager.INSTANCE;
                logManager.printIsNotMainProcess$2party_impl_release("addTempLogRecord: " + str);
                MMKV mmkvWithID = MMKV.mmkvWithID(LogManager.MMKV_KEY_TEMP_FILE, LogManager.INSTANCE.getMRecordRootPath());
                if (mmkvWithID != null) {
                    Boolean.valueOf(mmkvWithID.encode(str, " "));
                }
            }
        }
    }

    /* renamed from: a */
    private final String m16419a() {
        String str = "log_cache_" + f19348b + '_' + System.currentTimeMillis();
        LogUtil.iRelease(f19350d, "filename is :" + str);
        return str;
    }

    public final String[] getAllMkKey() {
        String[] allKeys;
        synchronized (LogTracker.INSTANCE.getClass()) {
            LogManager.INSTANCE.printIsNotMainProcess$2party_impl_release("getAllMkKey");
            MMKV mmkvWithID = MMKV.mmkvWithID(LogManager.MMKV_KEY_SEND_FILE, LogManager.INSTANCE.getMRecordRootPath());
            allKeys = mmkvWithID != null ? mmkvWithID.allKeys() : null;
        }
        return allKeys;
    }

    public final void remove(String str) {
        MMKV mmkvWithID;
        synchronized (LogTracker.INSTANCE.getClass()) {
            LogManager logManager = LogManager.INSTANCE;
            logManager.printIsNotMainProcess$2party_impl_release("remove: " + str);
            if (!(str == null || (mmkvWithID = MMKV.mmkvWithID((String) LogManager.MMKV_KEY_SEND_FILE, LogManager.INSTANCE.getMRecordRootPath())) == null)) {
                mmkvWithID.remove(str);
            }
        }
    }

    public final void deleteFile(String str) {
        synchronized (LogTracker.INSTANCE.getClass()) {
            LogManager.INSTANCE.printIsNotMainProcess$2party_impl_release("deleteFile: " + str);
            String stringPlus = Intrinsics.stringPlus(LogManager.INSTANCE.getMRecordDataPath(), File.separator);
            if (str != null) {
                MMKV mmkvWithID = MMKV.mmkvWithID(str, LogManager.INSTANCE.getMRecordDataPath());
                String str2 = stringPlus + (mmkvWithID != null ? mmkvWithID.mmapID() : null);
                LogUtil.iRelease(f19350d, "delete :" + str2);
                INSTANCE.m16420a(new File(str2));
                INSTANCE.m16420a(new File(str2 + ".crc"));
            }
        }
    }

    /* renamed from: a */
    private final void m16420a(File file) {
        if (file == null || !file.exists() || !file.isFile()) {
            LogUtil.iRelease(f19350d, "file not exists");
        } else if (!file.delete() && !file.delete()) {
            LogUtil.eRelease(f19350d, "delete file fail");
        }
    }
}
