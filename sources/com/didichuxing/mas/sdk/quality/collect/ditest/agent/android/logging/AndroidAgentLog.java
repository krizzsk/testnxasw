package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging;

import com.didi.sdk.apm.SystemUtils;

public class AndroidAgentLog implements AgentLog {

    /* renamed from: a */
    private static final String f50566a = "com.didichuxing.mas.sdk.quality.collect.ditest.agent.android";

    /* renamed from: b */
    private int f50567b = 5;

    public void debug(String str) {
        if (this.f50567b == 5) {
            SystemUtils.log(3, f50566a, str, (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AndroidAgentLog", 19);
        }
    }

    public void verbose(String str) {
        if (this.f50567b >= 4) {
            SystemUtils.log(2, f50566a, str, (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AndroidAgentLog", 27);
        }
    }

    public void info(String str) {
        if (this.f50567b >= 3) {
            SystemUtils.log(4, f50566a, str, (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AndroidAgentLog", 35);
        }
    }

    public void warning(String str) {
        if (this.f50567b >= 2) {
            SystemUtils.log(5, f50566a, str, (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AndroidAgentLog", 43);
        }
    }

    public void error(String str) {
        if (this.f50567b >= 1) {
            SystemUtils.log(6, f50566a, str, (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AndroidAgentLog", 51);
        }
    }

    public void error(String str, Throwable th) {
        if (this.f50567b >= 1) {
            SystemUtils.log(6, f50566a, str, th, "com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AndroidAgentLog", 59);
        }
    }

    public int getLevel() {
        return this.f50567b;
    }

    public void setLevel(int i) {
        if (i > 5 || i < 1) {
            throw new IllegalArgumentException("Log level is not between ERROR and DEBUG");
        }
        this.f50567b = i;
    }
}
