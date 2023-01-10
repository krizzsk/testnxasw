package com.didi.nova.assembly;

import com.didi.nova.assembly.ALog;

public class Assembly {
    public static void setLog(ALog.ILog iLog) {
        ALog.f31545a = iLog != null;
        ALog.f31546b = iLog;
    }
}
