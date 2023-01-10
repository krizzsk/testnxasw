package com.kwai.koom.javaoom.dump;

import android.os.Debug;
import com.kwai.koom.javaoom.KOOMEnableChecker;
import com.kwai.koom.javaoom.common.KGlobalConfig;
import com.kwai.koom.javaoom.common.KLog;
import java.io.IOException;

public class StripHprofHeapDumper implements HeapDumper {

    /* renamed from: a */
    private static final String f58459a = "StripHprofHeapDumper";

    /* renamed from: b */
    private boolean f58460b;

    public native void hprofName(String str);

    public native void initStripDump();

    public native boolean isStripSuccess();

    public StripHprofHeapDumper() {
        boolean loadLib = KGlobalConfig.getSoLoader().loadLib("koom-java");
        this.f58460b = loadLib;
        if (loadLib) {
            initStripDump();
        }
    }

    public boolean dump(String str) {
        KLog.m44291i(f58459a, "dump " + str);
        if (!this.f58460b) {
            KLog.m44290e(f58459a, "dump failed caused by so not loaded!");
            return false;
        } else if (!KOOMEnableChecker.get().isVersionPermit()) {
            KLog.m44290e(f58459a, "dump failed caused by version net permitted!");
            return false;
        } else {
            try {
                hprofName(str);
                Debug.dumpHprofData(str);
                return isStripSuccess();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}
