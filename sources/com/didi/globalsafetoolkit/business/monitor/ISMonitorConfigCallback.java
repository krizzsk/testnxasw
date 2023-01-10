package com.didi.globalsafetoolkit.business.monitor;

import com.didi.globalsafetoolkit.business.toolkit.model.SfViewMonitorMenuModel;

public interface ISMonitorConfigCallback {
    void onFailed(String str);

    void onSuccess(SfViewMonitorMenuModel sfViewMonitorMenuModel);
}
