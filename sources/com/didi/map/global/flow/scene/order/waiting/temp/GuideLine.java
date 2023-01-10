package com.didi.map.global.flow.scene.order.waiting.temp;

import android.content.Context;
import android.graphics.Color;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.model.location.LocationHelper;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;
import java.util.ArrayList;
import java.util.List;

public class GuideLine {

    /* renamed from: a */
    private Context f29478a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Map f29479b;

    /* renamed from: c */
    private DIDILocationListener f29480c = m22837a();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public LatLng f29481d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public GuideLineParam f29482e;

    /* renamed from: f */
    private Line f29483f;

    /* renamed from: g */
    private boolean f29484g;

    public GuideLine(Context context, Map map) {
        this.f29478a = context.getApplicationContext();
        this.f29479b = map;
    }

    public void setParam(GuideLineParam guideLineParam) {
        this.f29482e = guideLineParam;
    }

    /* renamed from: a */
    private DIDILocationListener m22837a() {
        DIDILocationListener dIDILocationListener = this.f29480c;
        if (dIDILocationListener != null) {
            return dIDILocationListener;
        }
        C105161 r0 = new DIDILocationListener() {
            public void onLocationError(int i, ErrInfo errInfo) {
            }

            public void onStatusUpdate(String str, int i, String str2) {
            }

            public void onLocationChanged(DIDILocation dIDILocation) {
                if (dIDILocation == null) {
                    return;
                }
                if (GuideLine.this.f29481d == null) {
                    LatLng unused = GuideLine.this.f29481d = new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude());
                    if (GuideLine.this.f29479b.getCameraPosition() != null) {
                        GuideLine guideLine = GuideLine.this;
                        guideLine.m22838a(guideLine.f29481d, GuideLine.this.f29482e.f29486b);
                    }
                } else if (dIDILocation.getLatitude() != GuideLine.this.f29481d.latitude && dIDILocation.getLongitude() != GuideLine.this.f29481d.longitude) {
                    GuideLine.this.f29481d.latitude = dIDILocation.getLatitude();
                    GuideLine.this.f29481d.longitude = dIDILocation.getLongitude();
                    GuideLine guideLine2 = GuideLine.this;
                    guideLine2.m22838a(guideLine2.f29481d, GuideLine.this.f29482e.f29486b);
                }
            }
        };
        this.f29480c = r0;
        return r0;
    }

    public boolean isVisible() {
        return this.f29484g;
    }

    public void show() {
        DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(this.f29478a);
        if (lastKnownLocation != null) {
            LatLng latLng = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
            this.f29481d = latLng;
            m22838a(latLng, this.f29482e.f29486b);
        }
        LocationHelper.registerListener(this.f29478a, DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY, this.f29480c);
    }

    public void hide() {
        LocationHelper.unRegisterListener(this.f29478a, this.f29480c);
    }

    public void updateTarget(LatLng latLng) {
        this.f29482e.f29486b = latLng;
        m22838a(this.f29481d, this.f29482e.f29486b);
    }

    public void destroy() {
        hide();
        m22841b();
    }

    /* renamed from: b */
    private void m22841b() {
        this.f29484g = false;
        Line line = this.f29483f;
        if (line != null) {
            this.f29479b.remove(line);
            this.f29483f = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22838a(LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null) {
            this.f29484g = true;
            ArrayList arrayList = new ArrayList();
            arrayList.add(latLng);
            arrayList.add(latLng2);
            Line line = this.f29483f;
            if (line == null) {
                LineOptions lineOptions = new LineOptions();
                lineOptions.type(2);
                lineOptions.add((List<LatLng>) arrayList);
                lineOptions.lineEndType(1);
                lineOptions.width((double) DisplayUtils.dp2px(this.f29478a, 4.0f));
                lineOptions.spacing((float) DisplayUtils.dp2px(this.f29478a, 5.0f));
                if (this.f29482e.f29485a != 0) {
                    lineOptions.color(this.f29482e.f29485a);
                } else {
                    lineOptions.color(Color.parseColor("#279CFD"));
                }
                this.f29483f = this.f29479b.addLine(lineOptions);
                return;
            }
            line.setPoints(arrayList);
        }
    }
}
