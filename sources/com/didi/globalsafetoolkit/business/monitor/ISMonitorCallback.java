package com.didi.globalsafetoolkit.business.monitor;

public interface ISMonitorCallback {
    void onFailed(Exception exc);

    void onSuccess(String str);
}
