package com.didi.dimina.container.p065ui.swipeback;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.didi.dimina.container.p065ui.swipeback.SwipeBackLayout;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.didi.dimina.container.ui.swipeback.SwipeBackActivity */
public class SwipeBackActivity extends AppCompatActivity {

    /* renamed from: a */
    private SwipeBackLayout f19666a;

    /* renamed from: b */
    private int f19667b = 0;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        mo61652a();
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.f19666a.attachToActivity(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r1 = r2.f19666a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View findViewById(int r3) {
        /*
            r2 = this;
            android.view.View r0 = super.findViewById(r3)
            if (r0 != 0) goto L_0x000f
            com.didi.dimina.container.ui.swipeback.SwipeBackLayout r1 = r2.f19666a
            if (r1 == 0) goto L_0x000f
            android.view.View r3 = r1.findViewById(r3)
            return r3
        L_0x000f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.p065ui.swipeback.SwipeBackActivity.findViewById(int):android.view.View");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo61652a() {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().getDecorView().setBackgroundDrawable((Drawable) null);
        this.f19666a = new SwipeBackLayout(this);
        this.f19666a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }

    /* access modifiers changed from: protected */
    public void setEdgeLevel(SwipeBackLayout.EdgeLevel edgeLevel) {
        this.f19666a.setEdgeLevel(edgeLevel);
    }

    /* access modifiers changed from: protected */
    public void setEdgeLevel(int i) {
        this.f19666a.setEdgeLevel(i);
    }

    public SwipeBackLayout getSwipeBackLayout() {
        return this.f19666a;
    }

    public void setSwipeBackEnable(boolean z) {
        this.f19666a.setEnableGesture(z);
    }

    public boolean swipeBackPriority() {
        return getSupportFragmentManager().getBackStackEntryCount() <= 1;
    }

    /* access modifiers changed from: protected */
    public void setDefaultFragmentBackground(int i) {
        this.f19667b = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo61653b() {
        return this.f19667b;
    }
}
