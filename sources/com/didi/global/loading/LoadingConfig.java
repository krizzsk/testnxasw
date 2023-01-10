package com.didi.global.loading;

import android.os.Bundle;
import java.util.Arrays;

public class LoadingConfig {
    public static final int DEFAULT_MASK_LAYER_BACKGROUND_COLOR = 1291845631;

    /* renamed from: a */
    private LoadingRenderType f24561a;

    /* renamed from: b */
    private Bundle f24562b;

    /* renamed from: c */
    private boolean f24563c;

    /* renamed from: d */
    private int f24564d;

    /* renamed from: e */
    private int f24565e;

    /* renamed from: f */
    private long f24566f;

    public static Builder create() {
        LoadingConfig loadingConfig = new LoadingConfig();
        loadingConfig.m19745a(300);
        loadingConfig.setLoadingGravity(80);
        loadingConfig.setRenderType(LoadingRenderType.ANIMATION);
        loadingConfig.setMaskBackgroundColor(DEFAULT_MASK_LAYER_BACKGROUND_COLOR);
        return new Builder(loadingConfig);
    }

    public void merge(LoadingConfig loadingConfig) {
        if (loadingConfig != null) {
            if (loadingConfig.getStartDelay() > 0) {
                m19745a(loadingConfig.getStartDelay());
            }
            setWithMaskLayer(loadingConfig.isWithMaskLayer());
            if (loadingConfig.getRenderType() != null) {
                setRenderType(loadingConfig.getRenderType());
            }
            if (loadingConfig.getMaskBackgroundColor() != 0) {
                setMaskBackgroundColor(loadingConfig.getMaskBackgroundColor());
            }
            if (loadingConfig.getLoadingGravity() != 0) {
                setLoadingGravity(loadingConfig.getLoadingGravity());
            }
            if (loadingConfig.getRenderParams() != null) {
                Bundle renderParams = getRenderParams();
                if (renderParams != null) {
                    renderParams.putAll(loadingConfig.getRenderParams());
                } else {
                    setRenderParams(loadingConfig.getRenderParams());
                }
            }
        }
    }

    public static class Builder {
        private LoadingConfig config;

        Builder(LoadingConfig loadingConfig) {
            this.config = loadingConfig;
        }

        public Builder setStartDelay(long j) {
            this.config.m19745a(j);
            return this;
        }

        public Builder setRenderType(LoadingRenderType loadingRenderType) {
            this.config.setRenderType(loadingRenderType);
            return this;
        }

        public Builder setRenderParams(Bundle bundle) {
            this.config.setRenderParams(bundle);
            return this;
        }

        public Builder setWithMaskLayer(boolean z) {
            this.config.setWithMaskLayer(z);
            return this;
        }

        public Builder setLoadingGravity(int i) {
            this.config.setLoadingGravity(i);
            return this;
        }

        public Builder setMaskBackgroundColor(int i) {
            this.config.setMaskBackgroundColor(i);
            return this;
        }

        public LoadingConfig build() {
            return this.config;
        }
    }

    public long getStartDelay() {
        return this.f24566f;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19745a(long j) {
        this.f24566f = j;
    }

    public LoadingRenderType getRenderType() {
        return this.f24561a;
    }

    public void setRenderType(LoadingRenderType loadingRenderType) {
        this.f24561a = loadingRenderType;
    }

    public Bundle getRenderParams() {
        return this.f24562b;
    }

    public void setRenderParams(Bundle bundle) {
        this.f24562b = bundle;
    }

    public void setMaskBackgroundColor(int i) {
        this.f24564d = i;
    }

    public int getMaskBackgroundColor() {
        return this.f24564d;
    }

    public boolean isWithMaskLayer() {
        return this.f24563c;
    }

    public void setWithMaskLayer(boolean z) {
        this.f24563c = z;
    }

    public int getLoadingGravity() {
        return this.f24565e;
    }

    public void setLoadingGravity(int i) {
        if (i == 48 || i == 80) {
            this.f24565e = i;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LoadingConfig loadingConfig = (LoadingConfig) obj;
        if (this.f24563c == loadingConfig.f24563c && this.f24565e == loadingConfig.f24565e && this.f24566f == loadingConfig.f24566f && this.f24561a == loadingConfig.f24561a && m19747a((Object) this.f24562b, (Object) loadingConfig.f24562b)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m19747a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f24561a, this.f24562b, Boolean.valueOf(this.f24563c), Integer.valueOf(this.f24565e), Long.valueOf(this.f24566f)});
    }
}
