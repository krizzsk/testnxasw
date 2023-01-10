package com.didi.soda.customer.widget.loading;

import android.os.Bundle;
import java.util.Arrays;

public class LoadingConfig {

    /* renamed from: a */
    private LoadingRenderType f44642a;

    /* renamed from: b */
    private Bundle f44643b;

    /* renamed from: c */
    private boolean f44644c;

    /* renamed from: d */
    private int f44645d;

    public LoadingConfig() {
    }

    public LoadingConfig(LoadingRenderType loadingRenderType, Bundle bundle, boolean z, int i) {
        this.f44642a = loadingRenderType;
        this.f44643b = bundle;
        this.f44644c = z;
        this.f44645d = i;
    }

    /* renamed from: a */
    private static boolean m33150a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LoadingConfig loadingConfig = (LoadingConfig) obj;
        if (this.f44644c == loadingConfig.f44644c && this.f44645d == loadingConfig.f44645d && this.f44642a == loadingConfig.f44642a && m33150a(this.f44643b, loadingConfig.f44643b)) {
            return true;
        }
        return false;
    }

    public int getLoadingGravity() {
        return this.f44645d;
    }

    public void setLoadingGravity(int i) {
        if (i == 48 || i == 80) {
            this.f44645d = i;
        }
    }

    public Bundle getRenderParams() {
        return this.f44643b;
    }

    public void setRenderParams(Bundle bundle) {
        this.f44643b = bundle;
    }

    public LoadingRenderType getRenderType() {
        return this.f44642a;
    }

    public void setRenderType(LoadingRenderType loadingRenderType) {
        this.f44642a = loadingRenderType;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f44642a, this.f44643b, Boolean.valueOf(this.f44644c), Integer.valueOf(this.f44645d)});
    }

    public boolean isWithMaskLayer() {
        return this.f44644c;
    }

    public void setWithMaskLayer(boolean z) {
        this.f44644c = z;
    }
}
