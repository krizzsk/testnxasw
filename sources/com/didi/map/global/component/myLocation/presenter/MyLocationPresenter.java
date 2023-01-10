package com.didi.map.global.component.myLocation.presenter;

import android.content.Context;
import com.didi.common.sensor.OrientationListener;
import com.didi.common.sensor.OrientationManager;
import com.didi.map.global.component.myLocation.view.MyLocationView;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.global.model.location.LocationHelper2;
import com.didi.map.global.model.location.LocationRegisterParam;
import com.didi.map.global.model.location.NLPRegisterParam;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p174dp.locsdk.DLog;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;

public class MyLocationPresenter implements OrientationListener {

    /* renamed from: a */
    private boolean f28325a = false;

    /* renamed from: b */
    private Context f28326b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public MyLocationView f28327c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f28328d = "LocationRegister-->定位蓝点";

    /* renamed from: e */
    private NLPRegisterParam f28329e;

    /* renamed from: f */
    private DIDILocationListener f28330f = new DIDILocationListener() {
        public void onLocationError(int i, ErrInfo errInfo) {
        }

        public void onStatusUpdate(String str, int i, String str2) {
        }

        public void onLocationChanged(DIDILocation dIDILocation) {
            DLog.m36225d(MyLocationPresenter.this.f28328d + "更新蓝点");
            if (MyLocationPresenter.this.f28327c != null) {
                MyLocationPresenter.this.f28327c.refreshLocation(dIDILocation);
            }
        }
    };

    public MyLocationPresenter(Context context, MyLocationView myLocationView) {
        this.f28327c = myLocationView;
        this.f28326b = context;
    }

    public void startLocation() {
        if (this.f28326b != null && !this.f28325a) {
            m22187a();
            Context context = this.f28326b;
            if (context != null) {
                OrientationManager.getInstance(context).addOrientationListener(this);
            }
            this.f28325a = true;
        }
    }

    public void stopLocation() {
        Context context = this.f28326b;
        if (context != null) {
            OrientationManager.getInstance(context).removeOrientationListener(this);
            LocationHelper.unRegisterListener(this.f28326b, this.f28330f);
            LocationHelper2.unRegisterListener(this.f28326b, this.f28330f);
            this.f28325a = false;
        }
    }

    /* renamed from: a */
    private void m22187a() {
        LocationRegisterParam locationRegisterParam;
        if (this.f28329e != null) {
            DLog.m36225d(this.f28328d + "注册NLP");
            locationRegisterParam = new LocationRegisterParam(DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY, LocationRegisterParam.LocType.NLP);
            locationRegisterParam.setNlpRegisterParam(this.f28329e);
        } else {
            DLog.m36225d(this.f28328d + "注册FLP");
            locationRegisterParam = new LocationRegisterParam(DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY, LocationRegisterParam.LocType.FLP);
        }
        LocationHelper2.registerListener(this.f28326b, this.f28330f, locationRegisterParam);
    }

    public void onOrientationChanged(float f, float f2, float f3) {
        MyLocationView myLocationView = this.f28327c;
        if (myLocationView != null) {
            myLocationView.updateArrowRotateAngle(f);
        }
    }

    public void setNeedNlpLocation(NLPRegisterParam nLPRegisterParam) {
        this.f28329e = nLPRegisterParam;
        DLog.m36225d(this.f28328d + "数据变化，重新注册");
        LocationHelper2.unRegisterListener(this.f28326b, this.f28330f);
        m22187a();
    }
}
