package com.didi.sdk.apm.utils;

import android.content.BroadcastReceiver;
import android.text.TextUtils;
import android.util.Log;

public class PendingResultHelper {

    /* renamed from: a */
    private static final String f37823a = "PendingResultHelper";

    /* renamed from: a */
    private static boolean m28498a(BroadcastReceiver.PendingResult pendingResult) {
        if (pendingResult != null) {
            return ((Boolean) ReflectUtils.tryGetFiled(pendingResult, "mFinished")).booleanValue();
        }
        return true;
    }

    public static void finish(BroadcastReceiver.PendingResult pendingResult) {
        if (pendingResult != null && !m28498a(pendingResult)) {
            try {
                Log.d(f37823a, "PendingResult finish via PendingResultHelper");
                pendingResult.finish();
            } catch (Exception e) {
                if (e instanceof IllegalStateException) {
                    String message = e.getMessage();
                    if (!TextUtils.isEmpty(message) && message.contains("Broadcast already finished")) {
                        Log.e(f37823a, "PendingResult#finish must be call once,after Hook PendingResult#finish may called several times, so catch this error!");
                    }
                }
            }
        }
    }
}
