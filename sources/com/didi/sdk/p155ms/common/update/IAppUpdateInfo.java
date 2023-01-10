package com.didi.sdk.p155ms.common.update;

/* renamed from: com.didi.sdk.ms.common.update.IAppUpdateInfo */
public interface IAppUpdateInfo {
    int availableVersionCode();

    String getPackageName();

    int installStatus();

    boolean isUpdateAvailable();

    boolean isUpdateDeveloperTriggeredInProgress();

    boolean isUpdateTypeAllowed(int i);

    int updateAvailability();
}
