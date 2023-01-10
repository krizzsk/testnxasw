package com.didi.map.global.component.departure;

import android.content.Context;
import android.view.View;
import com.didi.common.map.Map;
import com.didi.common.map.model.Padding;
import com.didi.map.global.component.departure.IDepartureCompContract;
import com.didi.map.global.component.departure.controller.DepartureInterceptController;
import com.didi.map.global.component.departure.departure.DepartureViewFactory;
import com.didi.map.global.component.departure.departure.IDepartureView;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;

public class DepartureComponent implements IDepartureCompContract {

    /* renamed from: a */
    private IDepartureView f27137a;

    /* renamed from: b */
    private DepartureCompParams f27138b;

    public void updateDepartureLocation(DepartureLocationInfo departureLocationInfo) {
        IDepartureView iDepartureView = this.f27137a;
        if (iDepartureView != null) {
            iDepartureView.updateDepartureLocation(departureLocationInfo, false);
        }
    }

    public View getDepartureCardView() {
        IDepartureView iDepartureView = this.f27137a;
        if (iDepartureView != null) {
            return iDepartureView.getDepartureCardView();
        }
        return null;
    }

    public DepartureLocationInfo getLocationInfo() {
        IDepartureView iDepartureView = this.f27137a;
        if (iDepartureView != null) {
            return iDepartureView.getLocationInfo();
        }
        return null;
    }

    public DepartureAddress getDepartureAddress() {
        IDepartureView iDepartureView = this.f27137a;
        if (iDepartureView != null) {
            return iDepartureView.getDepartureAddress();
        }
        return null;
    }

    public boolean isShowTerminalViewOnSetPickupSpotAfter() {
        IDepartureView iDepartureView = this.f27137a;
        if (iDepartureView != null) {
            return iDepartureView.isShowTerminalViewOnSetPickupSpotAfter();
        }
        return false;
    }

    public void startTerminalSelect() {
        IDepartureView iDepartureView = this.f27137a;
        if (iDepartureView != null) {
            iDepartureView.startTerminalSelect();
        }
    }

    public void onConfirmClickInBroadOther() {
        IDepartureView iDepartureView = this.f27137a;
        if (iDepartureView != null) {
            iDepartureView.onConfirmClickInBroadOther();
        }
    }

    public void setPadding(Padding padding) {
        IDepartureView iDepartureView = this.f27137a;
        if (iDepartureView != null) {
            iDepartureView.setPadding(padding);
        }
    }

    public void registerCallback(IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback) {
        IDepartureView iDepartureView = this.f27137a;
        if (iDepartureView != null) {
            iDepartureView.registerCallback(iDepartureComponentCallback);
        }
    }

    public void setFenceVisible(boolean z) {
        IDepartureView iDepartureView = this.f27137a;
        if (iDepartureView != null) {
            iDepartureView.setFenceVisible(z);
        }
    }

    public void addOrderInterceptListener(DepartureInterceptController.IInterceptListener iInterceptListener) {
        IDepartureView iDepartureView = this.f27137a;
        if (iDepartureView != null) {
            iDepartureView.addOrderInterceptListener(iInterceptListener);
        }
    }

    public void updatePositionWhenOutStation(DepartureLocationInfo departureLocationInfo) {
        IDepartureView iDepartureView = this.f27137a;
        if (iDepartureView != null) {
            iDepartureView.updatePositionWhenOutStation(departureLocationInfo);
        }
    }

    public void create(Context context, Map map) {
        this.f27137a = DepartureViewFactory.getView(this.f27138b.getSceneType(), map, context, this.f27138b);
    }

    public void destroy() {
        IDepartureView iDepartureView = this.f27137a;
        if (iDepartureView != null) {
            iDepartureView.destroy();
            this.f27137a = null;
        }
    }

    public void setConfigParam(DepartureCompParams departureCompParams) {
        this.f27138b = departureCompParams;
    }

    public void onMapVisible(boolean z) {
        IDepartureView iDepartureView = this.f27137a;
        if (iDepartureView != null) {
            iDepartureView.onMapVisible(z);
        }
    }

    public void start() {
        IDepartureView iDepartureView = this.f27137a;
        if (iDepartureView != null) {
            iDepartureView.start();
        }
    }

    public void stop() {
        IDepartureView iDepartureView = this.f27137a;
        if (iDepartureView != null) {
            iDepartureView.stop();
        }
    }
}
