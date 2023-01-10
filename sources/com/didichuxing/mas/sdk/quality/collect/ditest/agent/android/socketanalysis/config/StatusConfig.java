package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.socketanalysis.config;

import android.content.Context;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.SavedState;
import com.didichuxing.mas.sdk.quality.report.utils.CommonUtil;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;

public class StatusConfig {

    /* renamed from: a */
    private static final String f50613a = "fileCreatedTimeKey";

    /* renamed from: b */
    private static SavedState f50614b;

    public static void setSaveState(Context context) {
        f50614b = new SavedState(context);
    }

    public static boolean isUpperLimitByDay() {
        return CommonUtil.isUpperLimitByDay("upper_limit_socket_key", SocketConfig.MAX_UPLOAD_LIMIT_PER_DAY);
    }

    public static void addNetEventNum() {
        CommonUtil.addUpperLimitByDay("upper_limit_socket_key");
    }

    public static void savefileCreatedTime() {
        f50614b.save(f50613a, System.currentTimeMillis());
    }

    public static long getfileCreatedTime() {
        return f50614b.getLong(f50613a);
    }

    public static boolean hasFileExpiration() {
        long j = getfileCreatedTime();
        if (j == 0 || System.currentTimeMillis() - j <= SocketConfig.FILE_EXPIRATION_TIME) {
            return false;
        }
        OLog.m37859d("file has expirated, delete it!");
        return true;
    }
}
