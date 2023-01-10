package com.google.android.play.core.install;

import com.google.android.play.core.install.model.C20022a;
import com.google.android.play.core.tasks.C20238j;

public class InstallException extends C20238j {

    /* renamed from: a */
    private final int f56053a;

    public InstallException(int i) {
        super(String.format("Install Error(%d): %s", new Object[]{Integer.valueOf(i), C20022a.m42118a(i)}));
        if (i != 0) {
            this.f56053a = i;
            return;
        }
        throw new IllegalArgumentException("errorCode should not be 0.");
    }

    public int getErrorCode() {
        return this.f56053a;
    }
}
