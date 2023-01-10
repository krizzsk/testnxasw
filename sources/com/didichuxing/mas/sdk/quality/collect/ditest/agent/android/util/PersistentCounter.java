package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.util;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.SavedState;

public class PersistentCounter {

    /* renamed from: a */
    private SavedState f50634a;

    public PersistentCounter(SavedState savedState) {
        this.f50634a = savedState;
    }

    public boolean upperLimitToday(String str, long j) {
        String str2 = str + (System.currentTimeMillis() / 86400000);
        long j2 = this.f50634a.getLong(str2);
        this.f50634a.save(str2, 1 + j2);
        return j2 > j;
    }
}
