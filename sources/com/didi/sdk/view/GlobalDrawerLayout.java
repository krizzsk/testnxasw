package com.didi.sdk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import com.didi.sdk.apm.utils.DebugUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.omega.sdk.Omega;

public class GlobalDrawerLayout extends DrawerLayout {

    /* renamed from: a */
    private Logger f40547a = LoggerFactory.getLogger("FragmentStackContainer");

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        try {
            m30453a(i, i2);
        } catch (Exception e) {
            Log.d("DrawerLayout", "onMeasure", e);
        }
    }

    public GlobalDrawerLayout(Context context) {
        super(context);
    }

    public GlobalDrawerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GlobalDrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void removeView(View view) {
        this.f40547a.info("removeView", new Object[0]);
    }

    public void removeViewAt(int i) {
        this.f40547a.info("removeViewAt", new Object[0]);
    }

    public void onViewRemoved(View view) {
        this.f40547a.info("onViewRemoved", new Object[0]);
    }

    public void removeViewInLayout(View view) {
        this.f40547a.info("removeViewInLayout", new Object[0]);
    }

    public void removeViews(int i, int i2) {
        this.f40547a.info("removeViews", new Object[0]);
    }

    public void removeAllViews() {
        this.f40547a.info("removeAllViews", new Object[0]);
    }

    /* renamed from: a */
    private void m30453a(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (NullPointerException e) {
            if (!DebugUtils.isDebuggableApp(getContext())) {
                Omega.trackError("MainActivity", e);
                return;
            }
            throw e;
        }
    }
}
