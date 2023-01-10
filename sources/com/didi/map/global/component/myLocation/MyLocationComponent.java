package com.didi.map.global.component.myLocation;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.map.global.component.myLocation.MyLocationCompParam;
import com.didi.map.global.component.myLocation.view.MyLocationView;
import com.didi.map.global.model.location.NLPRegisterParam;
import java.util.List;

public class MyLocationComponent implements IMyLocationCompContract {

    /* renamed from: a */
    private MyLocationView f28319a;

    /* renamed from: b */
    private MyLocationCompParam f28320b;

    /* renamed from: c */
    private final int f28321c = 1;

    public void setNeedNlpLocation(NLPRegisterParam nLPRegisterParam) {
        MyLocationView myLocationView = this.f28319a;
        if (myLocationView != null) {
            myLocationView.setNeedNlpLocation(nLPRegisterParam);
        }
    }

    public void setZIndex(int i) {
        MyLocationView myLocationView = this.f28319a;
        if (myLocationView != null) {
            myLocationView.setZIndex(i);
        }
    }

    public List<IMapElement> getMyLocationMarkers() {
        MyLocationView myLocationView = this.f28319a;
        if (myLocationView != null) {
            return myLocationView.getBestViewElements();
        }
        return null;
    }

    public void setVisible(boolean z) {
        MyLocationView myLocationView = this.f28319a;
        if (myLocationView == null || !z) {
            MyLocationView myLocationView2 = this.f28319a;
            if (myLocationView2 != null && !z) {
                myLocationView2.hide();
                return;
            }
            return;
        }
        myLocationView.show();
    }

    public boolean isVisible() {
        MyLocationView myLocationView = this.f28319a;
        return myLocationView != null && myLocationView.isVisible();
    }

    public void create(Context context, Map map) {
        if (this.f28319a == null) {
            if (this.f28320b == null) {
                this.f28320b = new MyLocationCompParam.Builder(1).build();
            }
            MyLocationView myLocationView = new MyLocationView(map, Math.min(this.f28320b.getzIndex(), 1), this.f28320b.getArrowIcon(), this.f28320b.getPositionIcon());
            this.f28319a = myLocationView;
            myLocationView.show();
        }
    }

    public void destroy() {
        MyLocationView myLocationView = this.f28319a;
        if (myLocationView != null) {
            myLocationView.destroy();
            this.f28319a = null;
        }
    }

    public void setConfigParam(MyLocationCompParam myLocationCompParam) {
        if (myLocationCompParam != null) {
            this.f28320b = myLocationCompParam;
        }
    }

    public void onMapVisible(boolean z) {
        MyLocationView myLocationView = this.f28319a;
        if (myLocationView != null && !z) {
            myLocationView.hide();
        }
        MyLocationView myLocationView2 = this.f28319a;
        if (myLocationView2 != null && z) {
            myLocationView2.show();
        }
    }
}
