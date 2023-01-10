package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.activity;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.Agent;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLog;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLogManager;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;

public class PageStateMonitor {

    /* renamed from: a */
    private static PageStateMonitor f50470a = new PageStateMonitor();

    /* renamed from: b */
    private static final AgentLog f50471b = AgentLogManager.getAgentLog();

    public static PageStateMonitor getInstance() {
        return f50470a;
    }

    public void pageStarted(String str) {
        if (Agent.isApmUiEnable()) {
            AgentLog agentLog = f50471b;
            agentLog.debug("--page started:" + str);
            m37662a("apm_page_start", str);
        }
    }

    public void pageCreated(String str) {
        if (Agent.isApmUiEnable()) {
            AgentLog agentLog = f50471b;
            agentLog.debug("--page created:" + str);
            m37662a("apm_page_create", str);
        }
    }

    public void pageResumed(String str) {
        if (Agent.isApmUiEnable()) {
            AgentLog agentLog = f50471b;
            agentLog.debug("--page resumed:" + str);
            m37662a("apm_page_resume", str);
        }
    }

    /* renamed from: a */
    private void m37662a(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("ts", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("page", str2);
        OmegaSDKAdapter.trackMasEvent(str, (String) null, hashMap);
    }
}
