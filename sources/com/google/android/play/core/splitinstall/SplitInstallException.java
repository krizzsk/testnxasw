package com.google.android.play.core.splitinstall;

import com.google.android.play.core.splitinstall.model.C20204a;
import com.google.android.play.core.tasks.C20238j;

public class SplitInstallException extends C20238j {

    /* renamed from: a */
    private final int f56191a;

    public SplitInstallException(int i) {
        super(String.format("Split Install Error(%d): %s", new Object[]{Integer.valueOf(i), C20204a.m42537a(i)}));
        if (i != 0) {
            this.f56191a = i;
            return;
        }
        throw new IllegalArgumentException("errorCode should not be 0.");
    }

    public int getErrorCode() {
        return this.f56191a;
    }
}
