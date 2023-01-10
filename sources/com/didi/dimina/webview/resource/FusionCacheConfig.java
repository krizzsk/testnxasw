package com.didi.dimina.webview.resource;

public class FusionCacheConfig {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f20201a = false;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f20202b = true;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f20203c = true;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f20204d = true;

    public boolean isUseNetStream() {
        return this.f20201a;
    }

    public boolean isIgnoreHtml() {
        return this.f20202b;
    }

    public boolean needBlockImage() {
        return this.f20203c;
    }

    public boolean isCacheOnly() {
        return this.f20204d;
    }

    public static class Builder {
        private final FusionCacheConfig fusionCacheConfig = new FusionCacheConfig();

        public Builder setUseNetStream(boolean z) {
            boolean unused = this.fusionCacheConfig.f20201a = z;
            return this;
        }

        public Builder setIgnoreHtml(boolean z) {
            boolean unused = this.fusionCacheConfig.f20202b = z;
            return this;
        }

        public Builder setBlockNetworkImage(boolean z) {
            boolean unused = this.fusionCacheConfig.f20203c = z;
            return this;
        }

        public Builder setCacheOnly(boolean z) {
            boolean unused = this.fusionCacheConfig.f20204d = z;
            return this;
        }

        public FusionCacheConfig build() {
            return this.fusionCacheConfig;
        }
    }
}
