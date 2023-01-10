package com.didichuxing.sdk.alphaface;

import android.content.Context;

public class AFConfig {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f51167a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f51168b;

    private AFConfig() {
    }

    public boolean isDebug() {
        return this.f51167a;
    }

    public Context getAppContext() {
        return this.f51168b;
    }

    public static class Builder {
        private AFConfig config = new AFConfig();

        public Builder setDebug(boolean z) {
            boolean unused = this.config.f51167a = z;
            return this;
        }

        public Builder setAppContext(Context context) {
            Context unused = this.config.f51168b = context.getApplicationContext();
            return this;
        }

        public AFConfig create() {
            return this.config;
        }
    }
}
