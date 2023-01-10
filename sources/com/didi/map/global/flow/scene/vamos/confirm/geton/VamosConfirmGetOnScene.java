package com.didi.map.global.flow.scene.vamos.confirm.geton;

import android.graphics.Color;
import com.didi.common.map.BestViewer;
import com.didi.common.map.MapVendor;
import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.CameraUpdateFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.line.excomponent.GuideLine;
import com.didi.map.global.component.line.excomponent.GuideLineParam;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.vamos.BaseVamosPageScene;
import com.didi.map.global.flow.scene.vamos.components.departure.VamosDeparturePin;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.sdk.departure.param.DepartureCompParam;
import com.didi.map.sdk.departure.param.DepartureLocationInfo;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.address.address.entity.Address;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;
import com.sdk.poibase.CallFrom;

@IScene.Scene(mo80431id = 2002)
public class VamosConfirmGetOnScene extends BaseVamosPageScene<VamosConfirmGetOnSceneParam> implements IVamosConfirmGetOnController {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public VamosDeparturePin f29594a;

    /* renamed from: b */
    private OnCameraChangeListener f29595b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Address f29596c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public GuideLine f29597d;

    /* renamed from: e */
    private DIDILocationListener f29598e = new DIDILocationListener() {
        public void onLocationError(int i, ErrInfo errInfo) {
        }

        public void onStatusUpdate(String str, int i, String str2) {
        }

        public void onLocationChanged(DIDILocation dIDILocation) {
            if (VamosConfirmGetOnScene.this.f29597d != null && dIDILocation != null) {
                LatLng latLng = new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude());
                if (LatLngUtils.locateCorrect(latLng)) {
                    VamosConfirmGetOnScene.this.f29597d.updateStartPosition(latLng);
                }
            }
        }
    };

    public VamosConfirmGetOnScene(VamosConfirmGetOnSceneParam vamosConfirmGetOnSceneParam, MapViewHolder mapViewHolder) {
        super(vamosConfirmGetOnSceneParam, mapViewHolder);
    }

    public void enter(Bundle bundle) {
        super.enter(bundle);
        if (getContext() != null) {
            LocationHelper.registerListener(getContext(), DIDILocationUpdateOption.IntervalMode.NORMAL, this.f29598e);
        }
        if (this.f29596c == null) {
            this.f29596c = ((VamosConfirmGetOnSceneParam) this.mParam).getStartAddress();
        }
        m22942a();
        m22946b();
        m22944a(((VamosConfirmGetOnSceneParam) this.mParam).getPinStartLatLng());
    }

    /* renamed from: a */
    private void m22942a() {
        if (getMap() != null) {
            this.f29595b = new OnCameraChangeListener() {
                public final void onCameraChange(CameraPosition cameraPosition) {
                    VamosConfirmGetOnScene.this.m22943a(cameraPosition);
                }
            };
            getMap().addOnCameraChangeListener(this.f29595b);
            getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(((VamosConfirmGetOnSceneParam) this.mParam).getPinStartLatLng(), ((VamosConfirmGetOnSceneParam) this.mParam).getZoomLevel()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m22943a(CameraPosition cameraPosition) {
        if (getMap() != null) {
            m22944a(getMap().getCameraPosition().target);
        }
    }

    /* renamed from: b */
    private void m22946b() {
        DepartureCompParam build = new DepartureCompParam.Builder().bizId(Integer.valueOf(PaxEnvironment.getInstance().getProductId()).intValue()).isDriverRole(false).requireByDrag(true).phoneNum(PaxEnvironment.getInstance().getPhoneNumber()).token(PaxEnvironment.getInstance().getToken()).userId(PaxEnvironment.getInstance().getUid()).departureTime(((VamosConfirmGetOnSceneParam) this.mParam).getPinInfo().getDepartureTime()).isPinVisible(((VamosConfirmGetOnSceneParam) this.mParam).getPinInfo().getPinVisible()).isRecPointVisible(((VamosConfirmGetOnSceneParam) this.mParam).getPinInfo().getRecommendVisible()).isFenceVisible(((VamosConfirmGetOnSceneParam) this.mParam).getPinInfo().getFenceVisible()).callFrom(CallFrom.PICKUP_PAGE).locationInfo(new DepartureLocationInfo(((VamosConfirmGetOnSceneParam) this.mParam).getPinStartLatLng(), this.f29596c, "wgs84")).pinStyle(((VamosConfirmGetOnSceneParam) this.mParam).getPinStyle()).recStyle(((VamosConfirmGetOnSceneParam) this.mParam).getRecPointStyle()).listener(((VamosConfirmGetOnSceneParam) this.mParam).getDeparturePinChangedListener()).zoom(((VamosConfirmGetOnSceneParam) this.mParam).getZoomLevel()).build();
        if (getMap() != null) {
            VamosDeparturePin vamosDeparturePin = new VamosDeparturePin(getContext(), getMap());
            this.f29594a = vamosDeparturePin;
            vamosDeparturePin.start(build);
        }
    }

    public void onResume() {
        if (this.isSceneValid && this.f29597d != null && ((VamosConfirmGetOnSceneParam) this.mParam).isShowGuideLine()) {
            this.f29597d.setVisible(true);
        }
    }

    public void onPause() {
        GuideLine guideLine;
        if (this.isSceneValid && (guideLine = this.f29597d) != null) {
            guideLine.setVisible(false);
        }
    }

    public void leave() {
        super.leave();
        this.f29596c = null;
        if (getMap() != null) {
            getMap().removeOnCameraChangeListener(this.f29595b);
        }
        VamosDeparturePin vamosDeparturePin = this.f29594a;
        if (vamosDeparturePin != null) {
            vamosDeparturePin.destroy();
            this.f29594a = null;
        }
        GuideLine guideLine = this.f29597d;
        if (guideLine != null) {
            guideLine.destroy();
            this.f29597d = null;
        }
        if (getContext() != null) {
            LocationHelper.unRegisterListener(getContext(), this.f29598e);
        }
    }

    /* renamed from: a */
    private void m22944a(LatLng latLng) {
        LatLng latLng2;
        if (this.mParam == null) {
            return;
        }
        if ((((VamosConfirmGetOnSceneParam) this.mParam).getPinInfo() == null || ((VamosConfirmGetOnSceneParam) this.mParam).getPinInfo().getPinVisible()) && latLng != null && ((VamosConfirmGetOnSceneParam) this.mParam).isShowGuideLine() && getMap() != null && getContext() != null) {
            GuideLine guideLine = this.f29597d;
            if (guideLine == null) {
                this.f29597d = new GuideLine();
                DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(getContext());
                int parseColor = ((VamosConfirmGetOnSceneParam) this.mParam).getGuideLineColor() <= 0 ? Color.parseColor("#279CFD") : ((VamosConfirmGetOnSceneParam) this.mParam).getGuideLineColor();
                if (lastKnownLocation == null) {
                    latLng2 = null;
                } else {
                    latLng2 = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
                }
                this.f29597d.setConfigParam(new GuideLineParam(parseColor, 5, 4, 5.0f, latLng2, latLng));
                this.f29597d.create(getContext(), getMap());
                return;
            }
            guideLine.updateEndPosition(latLng);
        }
    }

    public void showResetView() {
        VamosDeparturePin vamosDeparturePin = this.f29594a;
        if (vamosDeparturePin == null || !vamosDeparturePin.isAirPortPickUpPoint()) {
            super.showResetView();
        }
    }

    public void setPadding(Padding padding) {
        if (this.isSceneValid && getMap() != null && this.mParam != null) {
            if (this.mPadding == null || !this.mPadding.equals(getMap().getPadding())) {
                this.mPadding = padding;
                DLog.m10773d("VamosConfirmGetOnScene", "setPadding ; " + this.mPadding.toString(), new Object[0]);
                if (getMap().getCameraPosition() != null && this.mPadding != null) {
                    if (getMap().getMapVendor() == MapVendor.DIDI) {
                        getMap().setPadding(this.mPadding.left, this.mPadding.top, this.mPadding.right, this.mPadding.bottom);
                    } else {
                        BestViewer.doBestView(getMap(), false, Float.valueOf((float) getMap().getCameraPosition().zoom), getMap().getCameraPosition().target, this.mPadding, (BestViewer.IBestViewListener) null);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        r0 = com.didi.map.global.model.location.LocationHelper.getLastKnownLocation(getContext());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doBestView(com.didi.common.map.model.Padding r10) {
        /*
            r9 = this;
            super.doBestView(r10)
            boolean r0 = r9.isSceneValid
            if (r0 == 0) goto L_0x004e
            com.didi.common.map.Map r0 = r9.getMap()
            if (r0 == 0) goto L_0x004e
            com.didi.map.global.flow.scene.PageSceneParam r0 = r9.mParam
            if (r0 != 0) goto L_0x0012
            goto L_0x004e
        L_0x0012:
            android.content.Context r0 = r9.getContext()
            com.didichuxing.bigdata.dp.locsdk.DIDILocation r0 = com.didi.map.global.model.location.LocationHelper.getLastKnownLocation(r0)
            if (r0 == 0) goto L_0x004e
            r9.hideResetView()
            com.didi.map.global.flow.scene.vamos.components.departure.VamosDeparturePin r1 = r9.f29594a
            if (r1 == 0) goto L_0x0027
            r2 = 1
            r1.removeDepartureBubble(r2)
        L_0x0027:
            com.didi.common.map.Map r3 = r9.getMap()
            r4 = 1
            com.didi.map.global.flow.scene.PageSceneParam r1 = r9.mParam
            com.didi.map.global.flow.scene.vamos.confirm.geton.VamosConfirmGetOnSceneParam r1 = (com.didi.map.global.flow.scene.vamos.confirm.geton.VamosConfirmGetOnSceneParam) r1
            float r1 = r1.getZoomLevel()
            java.lang.Float r5 = java.lang.Float.valueOf(r1)
            com.didi.common.map.model.LatLng r6 = new com.didi.common.map.model.LatLng
            double r1 = r0.getLatitude()
            double r7 = r0.getLongitude()
            r6.<init>((double) r1, (double) r7)
            com.didi.map.global.flow.scene.vamos.confirm.geton.VamosConfirmGetOnScene$2 r8 = new com.didi.map.global.flow.scene.vamos.confirm.geton.VamosConfirmGetOnScene$2
            r8.<init>(r0)
            r7 = r10
            com.didi.common.map.BestViewer.doBestView((com.didi.common.map.Map) r3, (boolean) r4, (java.lang.Float) r5, (com.didi.common.map.model.LatLng) r6, (com.didi.common.map.model.Padding) r7, (com.didi.common.map.BestViewer.IBestViewListener) r8)
        L_0x004e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.vamos.confirm.geton.VamosConfirmGetOnScene.doBestView(com.didi.common.map.model.Padding):void");
    }

    public Bundle transferParams() {
        return new Bundle();
    }
}
