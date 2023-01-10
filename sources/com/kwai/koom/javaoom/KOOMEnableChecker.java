package com.kwai.koom.javaoom;

import android.os.Build;
import android.text.TextUtils;
import com.kwai.koom.javaoom.common.KConstants;
import com.kwai.koom.javaoom.common.KGlobalConfig;
import com.kwai.koom.javaoom.common.KLog;
import com.kwai.koom.javaoom.common.KUtils;
import com.kwai.koom.javaoom.common.KVData;

public class KOOMEnableChecker {

    /* renamed from: a */
    private static KOOMEnableChecker f58347a;

    /* renamed from: b */
    private Result f58348b;

    public enum Result {
        NORMAL,
        EXPIRED_DATE,
        EXPIRED_TIMES,
        SPACE_NOT_ENOUGH,
        PROCESS_NOT_ENABLED,
        OS_VERSION_NO_COMPATIBILITY
    }

    public static KOOMEnableChecker get() {
        KOOMEnableChecker kOOMEnableChecker = f58347a;
        if (kOOMEnableChecker == null) {
            kOOMEnableChecker = new KOOMEnableChecker();
        }
        f58347a = kOOMEnableChecker;
        return kOOMEnableChecker;
    }

    public boolean isVersionPermit() {
        return Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT <= 30;
    }

    public boolean isMaxTimesOverflow() {
        String appVersion = KGlobalConfig.getRunningInfoFetcher().appVersion();
        int triggerTimes = KVData.getTriggerTimes(appVersion);
        KLog.m44291i("koom", "version:" + appVersion + " triggered times:" + triggerTimes);
        return triggerTimes > KConstants.EnableCheck.TRIGGER_MAX_TIMES;
    }

    public boolean isDateExpired() {
        String appVersion = KGlobalConfig.getRunningInfoFetcher().appVersion();
        long firstLaunchTime = KVData.firstLaunchTime(appVersion);
        KLog.m44291i("koom", "version:" + appVersion + " first launch time:" + firstLaunchTime);
        return System.currentTimeMillis() - firstLaunchTime > ((long) KConstants.EnableCheck.MAX_TIME_WINDOW_IN_DAYS) * KConstants.Time.DAY_IN_MILLS;
    }

    public boolean isSpaceEnough() {
        float spaceInGB = KUtils.getSpaceInGB(KGlobalConfig.getRootDir());
        if (KConstants.Debug.VERBOSE_LOG) {
            KLog.m44291i("koom", "Disk space:" + spaceInGB + "Gb");
        }
        return spaceInGB > KConstants.Disk.ENOUGH_SPACE_IN_GB;
    }

    public boolean isProcessPermitted() {
        String processName = KGlobalConfig.getKConfig().getProcessName();
        String processName2 = KUtils.getProcessName();
        KLog.m44291i("koom", "enabledProcess:" + processName + ", runningProcess:" + processName2);
        return TextUtils.equals(processName, processName2);
    }

    public static Result doCheck() {
        KOOMEnableChecker kOOMEnableChecker = get();
        f58347a = kOOMEnableChecker;
        Result result = kOOMEnableChecker.f58348b;
        if (result != null) {
            return result;
        }
        if (!kOOMEnableChecker.isVersionPermit()) {
            KOOMEnableChecker kOOMEnableChecker2 = f58347a;
            Result result2 = Result.OS_VERSION_NO_COMPATIBILITY;
            kOOMEnableChecker2.f58348b = result2;
            return result2;
        } else if (!f58347a.isSpaceEnough()) {
            KOOMEnableChecker kOOMEnableChecker3 = f58347a;
            Result result3 = Result.SPACE_NOT_ENOUGH;
            kOOMEnableChecker3.f58348b = result3;
            return result3;
        } else if (f58347a.isDateExpired()) {
            KOOMEnableChecker kOOMEnableChecker4 = f58347a;
            Result result4 = Result.EXPIRED_DATE;
            kOOMEnableChecker4.f58348b = result4;
            return result4;
        } else if (f58347a.isMaxTimesOverflow()) {
            KOOMEnableChecker kOOMEnableChecker5 = f58347a;
            Result result5 = Result.EXPIRED_TIMES;
            kOOMEnableChecker5.f58348b = result5;
            return result5;
        } else if (f58347a.isProcessPermitted()) {
            return Result.NORMAL;
        } else {
            KOOMEnableChecker kOOMEnableChecker6 = f58347a;
            Result result6 = Result.PROCESS_NOT_ENABLED;
            kOOMEnableChecker6.f58348b = result6;
            return result6;
        }
    }
}
