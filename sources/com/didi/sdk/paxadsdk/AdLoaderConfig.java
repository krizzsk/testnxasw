package com.didi.sdk.paxadsdk;

public class AdLoaderConfig {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f39683a;

    public boolean isShowIndicatorOnView() {
        return this.f39683a;
    }

    public static class Builder {
        boolean showIndicatorOnView = false;

        public Builder showIndicatorOnView(boolean z) {
            this.showIndicatorOnView = z;
            return this;
        }

        public AdLoaderConfig build() {
            AdLoaderConfig adLoaderConfig = new AdLoaderConfig();
            applyConfig(adLoaderConfig);
            return adLoaderConfig;
        }

        private void applyConfig(AdLoaderConfig adLoaderConfig) {
            boolean unused = adLoaderConfig.f39683a = this.showIndicatorOnView;
        }
    }
}
