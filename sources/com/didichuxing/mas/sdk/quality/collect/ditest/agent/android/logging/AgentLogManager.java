package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging;

public class AgentLogManager {

    /* renamed from: a */
    private static DefaultAgentLog f50565a = new DefaultAgentLog();

    public static AgentLog getAgentLog() {
        return f50565a;
    }

    public static void setAgentLog(AgentLog agentLog) {
        f50565a.setImpl(agentLog);
    }
}
