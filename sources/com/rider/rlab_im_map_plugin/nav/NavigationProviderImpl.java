package com.rider.rlab_im_map_plugin.nav;

import android.app.Activity;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.rider.rlab_im_map_plugin.ImMapActivity;
import com.rider.rlab_im_map_plugin.engine.ImMapConfig;
import com.rider.rlab_im_map_plugin.tool.ImMapUtils;
import com.rider.rlab_im_map_plugin.xpanel.XPanelLayout;

@ServiceProvider({INavigationProvider.class})
public class NavigationProviderImpl implements INavigationProvider {

    /* renamed from: a */
    private final Logger f58712a = LoggerFactory.getLogger("MapViewProviderImpl");

    /* renamed from: b */
    private ImNavigationView f58713b;

    /* renamed from: c */
    private XPanelLayout f58714c;

    public void setNavigationView(ImNavigationView imNavigationView) {
        this.f58713b = imNavigationView;
        this.f58712a.debug("setNavigationView", new Object[0]);
    }

    public void startMapNavigation(double d, double d2) {
        Activity scanForActivity;
        this.f58712a.debug("startMapNavigation", new Object[0]);
        if (getXPanelLayout() != null && (scanForActivity = ImMapUtils.scanForActivity(getXPanelLayout().getContext())) != null && (scanForActivity instanceof ImMapActivity)) {
            ((ImMapActivity) scanForActivity).startMapNavigation(d, d2, "");
        }
    }

    public void setNavigationPadding(double d, double d2, double d3, double d4) {
        this.f58712a.debug("setNavigationPadding", new Object[0]);
        ImNavigationView imNavigationView = this.f58713b;
        if (imNavigationView != null) {
            imNavigationView.setMapPadding((int) d2, (int) d, (int) d4, (int) d3);
        }
    }

    public void closeMapNavigation() {
        Activity scanForActivity;
        this.f58712a.debug("closeMapNavigation", new Object[0]);
        ImNavigationView imNavigationView = this.f58713b;
        if (imNavigationView != null && (scanForActivity = ImMapUtils.scanForActivity(imNavigationView.getContext())) != null && (scanForActivity instanceof ImMapActivity)) {
            ((ImMapActivity) scanForActivity).closeNewGoogleNaviPage();
        }
    }

    public void setMapNavigationRecenter() {
        this.f58712a.debug("setMapNavigationRecenter", new Object[0]);
        ImNavigationView imNavigationView = this.f58713b;
        if (imNavigationView != null) {
            imNavigationView.showOverView();
        }
    }

    public void setMapNavigationBestView() {
        this.f58712a.debug("setMapNavigationBestView", new Object[0]);
        ImNavigationView imNavigationView = this.f58713b;
        if (imNavigationView != null) {
            imNavigationView.showCurrentView();
        }
    }

    public void setMapNavigationOverView() {
        this.f58712a.debug("setMapNavigationOverView", new Object[0]);
        ImNavigationView imNavigationView = this.f58713b;
        if (imNavigationView != null) {
            imNavigationView.showOverView();
        }
    }

    public void setPanelFrameTouchLayout(XPanelLayout xPanelLayout) {
        this.f58712a.debug("setPanelFrameTouchLayout", new Object[0]);
        this.f58714c = xPanelLayout;
    }

    public XPanelLayout getXPanelLayout() {
        return this.f58714c;
    }

    public void openMapOutAppNavigation(double d, double d2, String str) {
        this.f58712a.debug("openMapOutAppNavigation", new Object[0]);
        int navType = ImMapConfig.getInstance().getNavType();
        XPanelLayout xPanelLayout = this.f58714c;
        if (xPanelLayout != null) {
            Activity scanForActivity = ImMapUtils.scanForActivity(xPanelLayout.getContext());
            int travelMode = NavigatorTools.getTravelMode(str);
            if (scanForActivity == null) {
                this.f58712a.info("gotoDownloadMapApp : activity is null", new Object[0]);
            } else if (navType == 2) {
                NavigatorTools.toGoogleMap(scanForActivity, d, d2, travelMode);
            } else if (navType == 3) {
                NavigatorTools.toWazeMap(scanForActivity, d, d2);
            }
        } else {
            this.f58712a.info("gotoDownloadMapApp : xPanelLayout is null", new Object[0]);
        }
    }
}
