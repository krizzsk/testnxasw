package com.didi.map.sdk.departure.internal.pin;

import android.content.Context;
import android.view.View;
import com.didi.common.map.Map;
import com.didi.map.sdk.departure.internal.bubble.DepartureBubble;
import com.didi.map.sdk.departure.internal.bubble.DepartureBubbleFactory;
import com.didi.map.sdk.departure.internal.pin.DepartureMarkerView;
import com.didi.map.sdk.departure.param.PinStyle;

public class DeparturePinDrawer implements IPinDrawer {

    /* renamed from: a */
    private static final String f30657a = DeparturePinDrawer.class.getSimpleName();

    /* renamed from: b */
    private DepartureMarkerWrapperView f30658b = null;

    /* renamed from: c */
    private Map f30659c;

    /* renamed from: d */
    private PinStyle f30660d;

    /* renamed from: e */
    private long f30661e;

    public void startJumpAnimation(DepartureMarkerView.AnimationFinishListener animationFinishListener) {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f30658b;
        if (departureMarkerWrapperView != null) {
            departureMarkerWrapperView.startJump(animationFinishListener);
        }
    }

    public void startLoadingAnimation() {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f30658b;
        if (departureMarkerWrapperView != null) {
            departureMarkerWrapperView.startLoading();
        }
    }

    public void stopAnimation() {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f30658b;
        if (departureMarkerWrapperView != null) {
            departureMarkerWrapperView.setNormal();
        }
    }

    public void setNoStopZoneStatus() {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f30658b;
        if (departureMarkerWrapperView != null) {
            departureMarkerWrapperView.setNoStopZoneStatus();
        }
    }

    public <T extends DepartureBubble> T createDepartureBubble(Class<T> cls) {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f30658b;
        if (departureMarkerWrapperView == null || departureMarkerWrapperView.getBubbleLayout() == null) {
            return null;
        }
        return DepartureBubbleFactory.createDepartureBubble(cls, this.f30658b.getBubbleLayout());
    }

    public void removeDepartureBubble(boolean z) {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f30658b;
        if (departureMarkerWrapperView != null) {
            departureMarkerWrapperView.removeViewFromBubbleLayout(z);
        }
    }

    public View getDepartureBubbleView() {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f30658b;
        if (departureMarkerWrapperView != null) {
            return departureMarkerWrapperView.getDepartureBubbleView();
        }
        return null;
    }

    public int getPinHeight() {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f30658b;
        if (departureMarkerWrapperView != null) {
            return departureMarkerWrapperView.getHeight();
        }
        return 0;
    }

    public void setDurationMillis(long j) {
        this.f30661e = j;
    }

    public void create(Context context, Map map) {
        this.f30659c = map;
    }

    public void destroy() {
        remove();
        this.f30659c = null;
        this.f30660d = null;
    }

    public void setConfigParam(PinStyle pinStyle) {
        if (pinStyle != null) {
            this.f30660d = pinStyle;
            DepartureMarkerWrapperView departureMarkerWrapperView = this.f30658b;
            if (departureMarkerWrapperView != null) {
                departureMarkerWrapperView.setPinStyle(pinStyle);
            }
        }
    }

    public void onMapVisible(boolean z) {
        if (!z) {
            stopAnimation();
        }
    }

    public void add() {
        if (this.f30659c != null && this.f30660d != null) {
            DepartureMarkerWrapperView departureMarkerWrapperView = new DepartureMarkerWrapperView(this.f30659c.getContext(), this.f30660d);
            this.f30658b = departureMarkerWrapperView;
            this.f30659c.setTopViewToCenter(departureMarkerWrapperView, this.f30660d.anchorX, this.f30660d.anchorY);
            this.f30658b.animateBar(this.f30661e);
        }
    }

    public void remove() {
        Map map = this.f30659c;
        if (map != null) {
            map.removeTopView();
        }
    }

    public void visible(boolean z) {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f30658b;
        if (departureMarkerWrapperView != null) {
            departureMarkerWrapperView.setVisibility(z ? 0 : 4);
        }
    }

    public boolean isVisible() {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f30658b;
        if (departureMarkerWrapperView == null || departureMarkerWrapperView.getVisibility() != 0) {
            return false;
        }
        return true;
    }
}
