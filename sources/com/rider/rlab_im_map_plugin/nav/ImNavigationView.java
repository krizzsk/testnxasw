package com.rider.rlab_im_map_plugin.nav;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.google.android.libraries.navigation.NavigationView;
import com.google.android.libraries.navigation.StylingOptions;
import com.rider.rlab_im_map_plugin.channel.MapIMPluginHelper;
import com.taxis99.R;

public class ImNavigationView extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public NavigationView f58697a;

    /* renamed from: b */
    private final Logger f58698b;

    /* renamed from: c */
    private float f58699c;

    /* renamed from: d */
    private float f58700d;

    /* renamed from: e */
    private int f58701e;

    /* renamed from: f */
    private final ComponentCallbacks2 f58702f;

    public ImNavigationView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ImNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f58698b = LoggerFactory.getLogger("RiderNavigationView");
        this.f58699c = 0.0f;
        this.f58700d = 0.0f;
        this.f58701e = 0;
        this.f58702f = new ComponentCallbacks2() {
            public void onConfigurationChanged(Configuration configuration) {
            }

            public void onLowMemory() {
            }

            public void onTrimMemory(int i) {
                if (ImNavigationView.this.f58697a != null) {
                    ImNavigationView.this.f58697a.onTrimMemory(i);
                }
            }
        };
        m44392a(context);
    }

    /* renamed from: a */
    private void m44392a(Context context) {
        setOrientation(1);
        StatusBarView statusBarView = new StatusBarView(context);
        statusBarView.setBackgroundColor(getContext().getResources().getColor(R.color.rider_color_08AE67));
        addView(statusBarView);
        NavigationView navigationView = new NavigationView(context);
        this.f58697a = navigationView;
        addView(navigationView);
        setNavigationView(context);
    }

    public NavigationView getNavigationView() {
        return this.f58697a;
    }

    private void setNavigationView(Context context) {
        m44391a(0);
        this.f58697a.setEtaCardEnabled(false);
        this.f58697a.setRecenterButtonEnabled(false);
        this.f58697a.setForceNightMode(1);
        this.f58697a.setStylingOptions(new StylingOptions().headerDistanceUnitsTextColor(-1).primaryDayModeThemeColor(Integer.valueOf(context.getResources().getColor(R.color.rider_color_08AE67))).primaryNightModeThemeColor(Integer.valueOf(context.getResources().getColor(R.color.rider_color_08AE67))).secondaryDayModeThemeColor(Integer.valueOf(context.getResources().getColor(R.color.rider_color_008751))).secondaryNightModeThemeColor(Integer.valueOf(context.getResources().getColor(R.color.rider_color_008751))));
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f58701e == 0) {
            this.f58701e = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f58699c = motionEvent.getX();
            this.f58700d = motionEvent.getY();
        } else if (action == 1) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            float f = x - this.f58699c;
            float f2 = y - this.f58700d;
            if (Math.abs(f) > ((float) this.f58701e) || Math.abs(f2) > ((float) this.f58701e)) {
                MapIMPluginHelper.setMapNavigationDragDidChange();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void showOverView() {
        NavigationView navigationView = this.f58697a;
        if (navigationView != null) {
            navigationView.getCamera().showRouteOverview();
        }
    }

    public void showCurrentView() {
        NavigationView navigationView = this.f58697a;
        if (navigationView != null) {
            navigationView.getCamera().followMyLocation(0);
        }
    }

    public void setMapPadding(int i, int i2, int i3, int i4) {
        NavigationView navigationView = this.f58697a;
        if (navigationView != null) {
            navigationView.getMap().setPadding(i, i2, i3, i4);
        }
    }

    public void onCreate(Bundle bundle) {
        NavigationView navigationView = this.f58697a;
        if (navigationView != null) {
            navigationView.onCreate(bundle);
            getContext().registerComponentCallbacks(this.f58702f);
        }
    }

    public void onStart() {
        NavigationView navigationView = this.f58697a;
        if (navigationView != null) {
            navigationView.onStart();
        }
    }

    public void onResume() {
        NavigationView navigationView = this.f58697a;
        if (navigationView != null) {
            navigationView.onResume();
        }
    }

    public void onPause() {
        NavigationView navigationView = this.f58697a;
        if (navigationView != null) {
            navigationView.onPause();
        }
    }

    public void onStop() {
        NavigationView navigationView = this.f58697a;
        if (navigationView != null) {
            navigationView.onStop();
        }
    }

    public void onDestroy() {
        if (getContext() != null) {
            getContext().unregisterComponentCallbacks(this.f58702f);
        }
        try {
            this.f58697a.onDestroy();
        } catch (Exception e) {
            this.f58698b.error("navigationView destroy throw exception：", (Throwable) e);
        }
    }

    /* renamed from: a */
    private void m44391a(int i) {
        this.f58697a.getCamera().followMyLocation(i);
    }
}
