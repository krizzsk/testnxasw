package com.didi.dvm.patch.dvm_patch;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

public abstract class EventTracker {
    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo63966a(String str, Map map);

    public static String getStackTrace(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
