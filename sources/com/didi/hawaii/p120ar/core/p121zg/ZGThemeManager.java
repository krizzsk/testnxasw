package com.didi.hawaii.p120ar.core.p121zg;

import android.content.Context;
import com.taxis99.R;

/* renamed from: com.didi.hawaii.ar.core.zg.ZGThemeManager */
public class ZGThemeManager {

    /* renamed from: a */
    private Context f25444a;

    /* renamed from: b */
    private int f25445b;

    /* renamed from: com.didi.hawaii.ar.core.zg.ZGThemeManager$SingletonHolder */
    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final ZGThemeManager INSTANCE = new ZGThemeManager();

        private SingletonHolder() {
        }
    }

    private ZGThemeManager() {
        this.f25444a = null;
        this.f25445b = 0;
    }

    public static final ZGThemeManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void init(Context context, int i) {
        this.f25444a = context;
        this.f25445b = i;
    }

    public String getThemeString(int i) {
        Context context = this.f25444a;
        if (context == null) {
            return "";
        }
        if (this.f25445b == 1 && i == R.string.reach_end) {
            return context.getString(R.string.reach_end_bus);
        }
        return this.f25444a.getString(i);
    }

    public int fromResource(int i) {
        return (this.f25445b == 1 && i == R.drawable.direction_start) ? R.drawable.direction_start_bus : i;
    }

    public void reset() {
        this.f25444a = null;
        this.f25445b = 0;
    }
}
