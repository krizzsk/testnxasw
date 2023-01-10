package com.didi.map.global.component.departure.pin;

import android.content.Context;
import android.view.View;
import com.didi.common.map.Map;
import com.didi.map.global.component.departure.bubble.DepartureBubble;
import com.didi.map.global.component.departure.bubble.DepartureBubbleFactory;
import com.didi.map.global.component.departure.model.PinStyle;
import com.didi.map.global.component.departure.pin.DepartureMarkerView;

public class DeparturePinDrawer implements IPinDrawer {

    /* renamed from: a */
    private DepartureMarkerWrapperView f27506a = null;

    /* renamed from: b */
    private Map f27507b;

    /* renamed from: c */
    private PinStyle f27508c;

    /* renamed from: d */
    private long f27509d;

    public void startJumpAnimation(DepartureMarkerView.AnimationFinishListener animationFinishListener) {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f27506a;
        if (departureMarkerWrapperView != null) {
            departureMarkerWrapperView.startJump(animationFinishListener);
        }
    }

    public void startLoadingAnimation() {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f27506a;
        if (departureMarkerWrapperView != null) {
            departureMarkerWrapperView.startLoading();
        }
    }

    public void stopAnimation() {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f27506a;
        if (departureMarkerWrapperView != null) {
            departureMarkerWrapperView.setNormal();
        }
    }

    public void setNoStopZoneStatus() {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f27506a;
        if (departureMarkerWrapperView != null) {
            departureMarkerWrapperView.setNoStopZoneStatus();
        }
    }

    public <T extends DepartureBubble> T createDepartureBubble(Class<T> cls) {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f27506a;
        if (departureMarkerWrapperView == null || departureMarkerWrapperView.getBubbleLayout() == null) {
            return null;
        }
        return DepartureBubbleFactory.createDepartureBubble(cls, this.f27506a.getBubbleLayout());
    }

    public void removeDepartureBubble(boolean z) {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f27506a;
        if (departureMarkerWrapperView != null) {
            departureMarkerWrapperView.removeViewFromBubbleLayout(z);
        }
    }

    public View getDepartureBubbleView() {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f27506a;
        if (departureMarkerWrapperView != null) {
            return departureMarkerWrapperView.getDepartureBubbleView();
        }
        return null;
    }

    public int getPinHeight() {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f27506a;
        if (departureMarkerWrapperView != null) {
            return departureMarkerWrapperView.getHeight();
        }
        return 0;
    }

    public void setDurationMillis(long j) {
        this.f27509d = j;
    }

    public void create(Context context, Map map) {
        this.f27507b = map;
    }

    public void destroy() {
        remove();
        this.f27507b = null;
        this.f27508c = null;
    }

    public void setConfigParam(PinStyle pinStyle) {
        if (pinStyle != null) {
            this.f27508c = pinStyle;
            DepartureMarkerWrapperView departureMarkerWrapperView = this.f27506a;
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
        if (this.f27507b != null && this.f27508c != null) {
            DepartureMarkerWrapperView departureMarkerWrapperView = new DepartureMarkerWrapperView(this.f27507b.getContext(), this.f27508c);
            this.f27506a = departureMarkerWrapperView;
            this.f27507b.setTopViewToCenter(departureMarkerWrapperView, this.f27508c.anchorX, this.f27508c.anchorY);
            this.f27506a.animateBar(this.f27509d);
        }
    }

    public void remove() {
        Map map = this.f27507b;
        if (map != null) {
            map.removeTopView();
        }
    }

    public void visible(boolean z) {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f27506a;
        if (departureMarkerWrapperView != null) {
            departureMarkerWrapperView.setVisibility(z ? 0 : 4);
        }
    }

    public boolean isVisible() {
        DepartureMarkerWrapperView departureMarkerWrapperView = this.f27506a;
        if (departureMarkerWrapperView == null || departureMarkerWrapperView.getVisibility() != 0) {
            return false;
        }
        return true;
    }
}
