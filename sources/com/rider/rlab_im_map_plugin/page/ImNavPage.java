package com.rider.rlab_im_map_plugin.page;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.SimpleSwapChangeHandler;
import com.didi.component.comp_xpanel.XPanelScene;
import com.didi.flutter.nacho2.p116v2.NachoLifecycleManager;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.google.android.libraries.navigation.Waypoint;
import com.rider.rlab_im_map_plugin.channel.MapIMPluginHelper;
import com.rider.rlab_im_map_plugin.channel.NavIMServiceImpl;
import com.rider.rlab_im_map_plugin.nav.ImNavigationView;
import com.rider.rlab_im_map_plugin.nav.ImNavigator;
import com.taxis99.R;

public class ImNavPage extends Page {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Logger f58724a = LoggerFactory.getLogger("ImNavPage");
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ImNavigationView f58725b;

    /* renamed from: c */
    private Waypoint f58726c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final ImNavigator f58727d = new ImNavigator();

    /* renamed from: e */
    private final ImNavigator.NavigationListener f58728e = new ImNavigator.NavigationListener() {
        public void onSuccess() {
            ImNavPage.this.f58724a.info("Navigator onSuccess", new Object[0]);
            MapIMPluginHelper.setIMNavigationState(0, "onSuccess");
        }

        public void onFail(String str) {
            Logger a = ImNavPage.this.f58724a;
            a.info("Navigator onFail : " + str, new Object[0]);
            MapIMPluginHelper.setIMNavigationState(1, str);
        }
    };

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.rider_im_nav_page, viewGroup, false);
        this.f58725b = (ImNavigationView) inflate.findViewById(R.id.rider_im_nav_view);
        this.f58724a.info("onInflateView", new Object[0]);
        return inflate;
    }

    public void onCreate(View view) {
        super.onCreate(view);
        this.f58724a.info(NachoLifecycleManager.LIFECYCLE_ON_CREATE, new Object[0]);
        this.f58725b.onCreate((Bundle) null);
        NavIMServiceImpl.iNavigationProvider.setNavigationView(this.f58725b);
        if (getArgs() != null && getArgs().containsKey("lat") && getArgs().containsKey("lng") && getArgs().containsKey("address")) {
            double d = getArgs().getDouble("lat");
            double d2 = getArgs().getDouble("lng");
            String string = getArgs().getString("address");
            Logger logger = this.f58724a;
            logger.info("create nav to way point : lat : " + d + " lng : " + d2, new Object[0]);
            this.f58726c = Waypoint.fromLatLng(d, d2, string);
        }
        m44410a(this.f58726c);
    }

    /* renamed from: a */
    private void m44410a(Waypoint waypoint) {
        Context context = this.f58725b.getContext();
        if (waypoint != null && context != null && (context instanceof Activity)) {
            this.f58727d.navigate((Activity) context, waypoint, this.f58728e);
        }
    }

    public void onStart() {
        super.onStart();
        this.f58725b.onStart();
        this.f58724a.info("onStart", new Object[0]);
    }

    public void onResume() {
        super.onResume();
        this.f58725b.onResume();
        this.f58724a.info("onResume", new Object[0]);
    }

    public void onPause() {
        super.onPause();
        this.f58725b.onPause();
        this.f58724a.info("onPause", new Object[0]);
    }

    public void onStop() {
        super.onStop();
        this.f58725b.onStop();
        this.f58724a.info("onStop", new Object[0]);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f58724a.info(NachoLifecycleManager.LIFECYCLE_ON_DESTROY, new Object[0]);
        this.f58725b.onDestroy();
        this.f58727d.release();
        MapIMPluginHelper.setIMNavigationState(2, XPanelScene.SCENE_FINISH);
        NavIMServiceImpl.iNavigationProvider.setNavigationView((ImNavigationView) null);
    }

    public ControllerChangeHandler getPushHandler() {
        return new SimpleSwapChangeHandler();
    }

    public ControllerChangeHandler getPopHandler() {
        return new SimpleSwapChangeHandler();
    }

    public void reLoad() {
        if (getArgs() != null && getArgs().containsKey("lat") && getArgs().containsKey("lng") && getArgs().containsKey("address")) {
            double d = getArgs().getDouble("lat");
            double d2 = getArgs().getDouble("lng");
            this.f58726c = Waypoint.fromLatLng(d, d2, getArgs().getString("address"));
            if (this.f58727d.getNavigatorInit().get()) {
                Logger logger = this.f58724a;
                logger.info("create nav to way point : lat : " + d + " lng : " + d2, new Object[0]);
                this.f58727d.navToWayPoint(this.f58726c, this.f58728e);
                return;
            }
            Logger logger2 = this.f58724a;
            logger2.info("reLoad init nav : lat : " + d + " lng : " + d2, new Object[0]);
            m44410a(this.f58726c);
        }
    }
}
