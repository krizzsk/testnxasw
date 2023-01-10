package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.io.PrintStream;

public class ConsoleAgentLog implements AgentLog {

    /* renamed from: a */
    private int f50568a = 3;

    public void debug(String str) {
        if (this.f50568a == 5) {
            m37709a("DEBUG", str);
        }
    }

    public void verbose(String str) {
        if (this.f50568a >= 4) {
            m37709a("VERBOSE", str);
        }
    }

    public void info(String str) {
        if (this.f50568a >= 5) {
            m37709a("INFO", str);
        }
    }

    public void warning(String str) {
        if (this.f50568a >= 2) {
            m37709a("WARN", str);
        }
    }

    public void error(String str, Throwable th) {
        if (this.f50568a >= 1) {
            m37709a("ERROR", str + " " + th.getMessage());
        }
    }

    public void error(String str) {
        if (this.f50568a >= 1) {
            m37709a("ERROR", str);
        }
    }

    public int getLevel() {
        return this.f50568a;
    }

    public void setLevel(int i) {
        this.f50568a = i;
    }

    /* renamed from: a */
    private static void m37709a(String str, String str2) {
        PrintStream printStream = System.out;
        printStream.println(Const.jaLeft + str + "] " + str2);
    }
}
