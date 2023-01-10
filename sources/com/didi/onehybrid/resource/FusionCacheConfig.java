package com.didi.onehybrid.resource;

public class FusionCacheConfig {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f32137a = false;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f32138b = true;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f32139c = true;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f32140d = true;

    public boolean isUseNetStream() {
        return this.f32137a;
    }

    public boolean isIgnoreHtml() {
        return this.f32138b;
    }

    public boolean needBlockImage() {
        return this.f32139c;
    }

    public boolean isCacheOnly() {
        return this.f32140d;
    }

    public static class Builder {
        private FusionCacheConfig fusionCacheConfig = new FusionCacheConfig();

        public Builder setUseNetStream(boolean z) {
            boolean unused = this.fusionCacheConfig.f32137a = z;
            return this;
        }

        public Builder setIgnoreHtml(boolean z) {
            boolean unused = this.fusionCacheConfig.f32138b = z;
            return this;
        }

        public Builder setBlockNetworkImage(boolean z) {
            boolean unused = this.fusionCacheConfig.f32139c = z;
            return this;
        }

        public Builder setCacheOnly(boolean z) {
            boolean unused = this.fusionCacheConfig.f32140d = z;
            return this;
        }

        public FusionCacheConfig build() {
            return this.fusionCacheConfig;
        }
    }
}
