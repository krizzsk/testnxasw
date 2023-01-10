package com.didi.entrega.customer.widget.loading;

import android.os.Bundle;
import java.util.Arrays;

public class LoadingConfig {

    /* renamed from: a */
    private LoadingRenderType f22399a;

    /* renamed from: b */
    private Bundle f22400b;

    /* renamed from: c */
    private boolean f22401c;

    /* renamed from: d */
    private int f22402d;

    public LoadingConfig() {
    }

    public LoadingConfig(LoadingRenderType loadingRenderType, Bundle bundle, boolean z, int i) {
        this.f22399a = loadingRenderType;
        this.f22400b = bundle;
        this.f22401c = z;
        this.f22402d = i;
    }

    /* renamed from: a */
    private static boolean m18462a(Object obj, Object obj2) {
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
        if (this.f22401c == loadingConfig.f22401c && this.f22402d == loadingConfig.f22402d && this.f22399a == loadingConfig.f22399a && m18462a(this.f22400b, loadingConfig.f22400b)) {
            return true;
        }
        return false;
    }

    public int getLoadingGravity() {
        return this.f22402d;
    }

    public void setLoadingGravity(int i) {
        if (i == 48 || i == 80) {
            this.f22402d = i;
        }
    }

    public Bundle getRenderParams() {
        return this.f22400b;
    }

    public void setRenderParams(Bundle bundle) {
        this.f22400b = bundle;
    }

    public LoadingRenderType getRenderType() {
        return this.f22399a;
    }

    public void setRenderType(LoadingRenderType loadingRenderType) {
        this.f22399a = loadingRenderType;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f22399a, this.f22400b, Boolean.valueOf(this.f22401c), Integer.valueOf(this.f22402d)});
    }

    public boolean isWithMaskLayer() {
        return this.f22401c;
    }

    public void setWithMaskLayer(boolean z) {
        this.f22401c = z;
    }
}
