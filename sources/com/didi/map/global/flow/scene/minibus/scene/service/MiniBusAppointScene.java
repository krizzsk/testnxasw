package com.didi.map.global.flow.scene.minibus.scene.service;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.common.map.BestViewer;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.common.map.util.MapUtils;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.component.markers.MarkersCompParams;
import com.didi.map.global.component.markers.MarkersComponent;
import com.didi.map.global.component.markers.view.IconLabelMarker;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.ISceneController;
import com.didi.map.global.flow.scene.minibus.component.MiniBusLineGroupComponent;
import com.didi.map.global.flow.scene.minibus.dialog.JumpNavConfirmDialog;
import com.didi.map.global.flow.scene.minibus.dialog.JumpNavErrorHintDialog;
import com.didi.map.global.flow.scene.minibus.param.MiniBusParamInterface;
import com.didi.map.global.flow.scene.minibus.scene.BaseMiniBusScene;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.global.flow.utils.LaunchExternalMapUtil;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@IScene.Scene(mo80431id = 3002)
public class MiniBusAppointScene extends BaseMiniBusScene<MiniBusAppointParam> implements ISceneController {

    /* renamed from: a */
    private String f28913a = "MiniBusAppointScene";

    /* renamed from: b */
    private MarkersComponent f28914b;

    /* renamed from: c */
    private MiniBusLineGroupComponent f28915c;

    /* renamed from: d */
    private IconLabelMarker f28916d;

    /* renamed from: e */
    private JumpNavConfirmDialog f28917e;

    /* renamed from: f */
    private JumpNavErrorHintDialog f28918f;

    /* renamed from: g */
    private List<CommonLineParam> f28919g;

    /* renamed from: h */
    private List<CommonMarkerParam> f28920h;

    /* renamed from: i */
    private MiniBusTripSceneState f28921i;

    public MiniBusAppointScene(MiniBusAppointParam miniBusAppointParam, MapViewHolder mapViewHolder) {
        super(miniBusAppointParam, mapViewHolder);
        if (miniBusAppointParam != null) {
            miniBusAppointParam.systemOutLog();
        }
    }

    public void enter(Bundle bundle) {
        super.enter(bundle);
        if (this.mParam != null) {
            MiniBusParamInterface miniBusParamInterface = ((MiniBusAppointParam) this.mParam).getMiniBusParamInterface();
            this.f28921i = ((MiniBusAppointParam) this.mParam).getSceneState();
            this.f28919g = miniBusParamInterface.getMiniBusLineParam();
            this.f28920h = miniBusParamInterface.getMiniBusMarkerParam();
            if (this.f28921i == MiniBusTripSceneState.STATE_ETA_BELOW_25) {
                m22545a(this.f28919g);
                initMarkerComponentForETALessThen25(this.f28920h);
                this.f28916d = m22550c();
                return;
            }
            m22549b(this.f28919g);
            initMarkerComponentForETAMoreThen25(this.f28920h);
        }
    }

    /* renamed from: a */
    private void m22543a() {
        boolean isInstallGoogleMap = LaunchExternalMapUtil.isInstallGoogleMap(getContext());
        if (this.mParam == null || ((MiniBusAppointParam) this.mParam).getContext() == null) {
            DLog.m10773d(this.f28913a, "弹窗依赖context 为null", new Object[0]);
        } else if (isInstallGoogleMap) {
            if (this.f28917e == null) {
                JumpNavConfirmDialog jumpNavConfirmDialog = new JumpNavConfirmDialog(((MiniBusAppointParam) this.mParam).getContext());
                this.f28917e = jumpNavConfirmDialog;
                jumpNavConfirmDialog.setOnConfirmClickListener(new JumpNavConfirmDialog.OnConfirmClickListener() {
                    public final void onConfirm() {
                        MiniBusAppointScene.this.m22552e();
                    }
                });
            }
            SystemUtils.showDialog(this.f28917e);
        } else {
            if (this.f28917e == null) {
                this.f28918f = new JumpNavErrorHintDialog(((MiniBusAppointParam) this.mParam).getContext());
            }
            SystemUtils.showDialog(this.f28918f);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m22552e() {
        List<CommonMarkerParam> list = this.f28920h;
        LatLng latLng = null;
        if (list != null) {
            for (CommonMarkerParam next : list) {
                if (next != null && MapElementId.ID_MARKER_PICK_UP == next.getId()) {
                    latLng = next.getPoint();
                }
            }
        }
        if (LatLngUtils.locateCorrect(latLng)) {
            LaunchExternalMapUtil.launchGoogleMapWithWalkNav(getContext(), latLng, LaunchExternalMapUtil.NavMode.WALKING);
        } else {
            DLog.m10773d(this.f28913a, "导航目标点坐标异常", new Object[0]);
        }
        LaunchExternalMapUtil.launchGoogleMapWithWalkNav(getContext(), latLng, LaunchExternalMapUtil.NavMode.WALKING);
        JumpNavConfirmDialog jumpNavConfirmDialog = this.f28917e;
        if (jumpNavConfirmDialog != null) {
            jumpNavConfirmDialog.dismiss();
        }
    }

    public void leave() {
        super.leave();
        MarkersComponent markersComponent = this.f28914b;
        if (markersComponent != null) {
            markersComponent.destroy();
        }
        MiniBusLineGroupComponent miniBusLineGroupComponent = this.f28915c;
        if (miniBusLineGroupComponent != null) {
            miniBusLineGroupComponent.destroy();
        }
        IconLabelMarker iconLabelMarker = this.f28916d;
        if (iconLabelMarker != null) {
            iconLabelMarker.destory();
        }
        JumpNavConfirmDialog jumpNavConfirmDialog = this.f28917e;
        if (jumpNavConfirmDialog != null) {
            if (jumpNavConfirmDialog.isShowing()) {
                this.f28917e.dismiss();
            }
            this.f28917e = null;
        }
        JumpNavErrorHintDialog jumpNavErrorHintDialog = this.f28918f;
        if (jumpNavErrorHintDialog != null) {
            if (jumpNavErrorHintDialog.isShowing()) {
                this.f28918f.dismiss();
            }
            this.f28918f = null;
        }
    }

    public void initMarkerComponentForETALessThen25(List<CommonMarkerParam> list) {
        MarkerModel paramConvertToMarkerModel;
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            this.f28914b = new MarkersComponent();
            ArrayList arrayList = new ArrayList();
            for (CommonMarkerParam next : list) {
                if (!(next == null || MapElementId.ID_MARKER_PICK_UP != next.getId() || (paramConvertToMarkerModel = paramConvertToMarkerModel(next)) == null)) {
                    arrayList.add(paramConvertToMarkerModel);
                }
            }
            this.f28914b.setConfigParam(new MarkersCompParams.Builder().markerModels(arrayList).build());
            this.f28914b.create(getContext(), getMap());
        }
    }

    public void initMarkerComponentForETAMoreThen25(List<CommonMarkerParam> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            this.f28914b = new MarkersComponent();
            ArrayList arrayList = new ArrayList();
            for (CommonMarkerParam paramConvertToMarkerModel : list) {
                MarkerModel paramConvertToMarkerModel2 = paramConvertToMarkerModel(paramConvertToMarkerModel);
                if (paramConvertToMarkerModel2 != null) {
                    arrayList.add(paramConvertToMarkerModel2);
                }
            }
            this.f28914b.setConfigParam(new MarkersCompParams.Builder().markerModels(arrayList).build());
            this.f28914b.create(getContext(), getMap());
        }
    }

    public void doBestView(Padding padding) {
        super.doBestView(padding);
        if (this.f28921i == MiniBusTripSceneState.STATE_ETA_BELOW_25) {
            m22548b(padding);
        } else {
            m22544a(padding);
        }
    }

    /* renamed from: a */
    private void m22544a(Padding padding) {
        ArrayList arrayList = new ArrayList();
        MarkersComponent markersComponent = this.f28914b;
        if (markersComponent != null) {
            arrayList.addAll(markersComponent.getMarkers());
        }
        MiniBusLineGroupComponent miniBusLineGroupComponent = this.f28915c;
        if (miniBusLineGroupComponent != null) {
            arrayList.addAll(miniBusLineGroupComponent.getBestViewElements());
        }
        BestViewer.doBestView(getMap(), true, (List<IMapElement>) arrayList, padding, getDefaultPadding(), (BestViewer.IBestViewListener) null);
    }

    /* renamed from: b */
    private void m22548b(Padding padding) {
        ArrayList arrayList = new ArrayList();
        if (this.mMapView != null) {
            List<IMapElement> myLocationMarkers = this.mMapView.getMyLocationMarkers();
            if (!CollectionUtil.isEmpty((Collection<?>) myLocationMarkers)) {
                arrayList.addAll(myLocationMarkers);
            }
        }
        List<IMapElement> a = m22542a(MapElementId.ID_MARKER_PICK_UP.name());
        if (!CollectionUtil.isEmpty((Collection<?>) a)) {
            arrayList.addAll(a);
        }
        IconLabelMarker iconLabelMarker = this.f28916d;
        if (iconLabelMarker != null && !CollectionUtil.isEmpty((Collection<?>) iconLabelMarker.getMarkers())) {
            arrayList.addAll(this.f28916d.getMarkers());
        }
        MiniBusLineGroupComponent miniBusLineGroupComponent = this.f28915c;
        if (miniBusLineGroupComponent != null) {
            List<IMapElement> bestViewElements = miniBusLineGroupComponent.getBestViewElements(MapElementId.ID_LINE_START_PICKUP.name());
            if (!CollectionUtil.isEmpty((Collection<?>) bestViewElements)) {
                arrayList.addAll(bestViewElements);
            }
        }
        BestViewer.doBestView(getMap(), true, (List<IMapElement>) arrayList, padding, getDefaultPadding(), (BestViewer.IBestViewListener) null);
    }

    /* renamed from: b */
    private LatLng m22546b() {
        try {
            if (this.mParam == null || ((MiniBusAppointParam) this.mParam).getContext() == null) {
                return null;
            }
            DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(((MiniBusAppointParam) this.mParam).getContext());
            return new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
        } catch (Exception e) {
            e.printStackTrace();
            DLog.m10773d(this.f28913a, "getPassengerLatLng is null", new Object[0]);
            return null;
        }
    }

    /* renamed from: a */
    private List<IMapElement> m22542a(String str) {
        ArrayList arrayList = new ArrayList();
        MarkersComponent markersComponent = this.f28914b;
        if (markersComponent != null) {
            List<Marker> markers = markersComponent.getMarkers(str);
            if (!CollectionUtil.isEmpty((Collection<?>) markers)) {
                arrayList.addAll(markers);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m22545a(List<CommonLineParam> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            for (CommonLineParam next : list) {
                if (next != null && MapElementId.ID_LINE_START_PICKUP == next.getId()) {
                    LatLng b = m22546b();
                    if (b != null) {
                        next.setStartPoint(b);
                    }
                    next.setAnimate(true);
                    if (!(next.getStartPoint() == null || next.getEndPoint() == null)) {
                        double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(next.getStartPoint(), next.getEndPoint());
                        String str = this.f28913a;
                        DLog.m10773d(str, "乘客位置和上车点之间的距离：" + computeDistanceBetween, new Object[0]);
                    }
                }
            }
            MiniBusLineGroupComponent miniBusLineGroupComponent = new MiniBusLineGroupComponent();
            this.f28915c = miniBusLineGroupComponent;
            miniBusLineGroupComponent.setConfigParam(list, 2);
            this.f28915c.setDidiVersion(PaxEnvironment.getInstance().getAppVersion());
            this.f28915c.setProductId(PaxEnvironment.getInstance().getProductId());
            this.f28915c.setOrderStage(3);
            this.f28915c.create(getContext(), getMap());
            this.f28915c.setLineDateListener(new MiniBusLineGroupComponent.LineDateListener() {
                public void onLineDateRequestSuccess() {
                    MiniBusAppointScene miniBusAppointScene = MiniBusAppointScene.this;
                    miniBusAppointScene.doBestView(miniBusAppointScene.mPadding);
                }
            });
            this.f28915c.start();
        }
    }

    /* renamed from: b */
    private void m22549b(List<CommonLineParam> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            MiniBusLineGroupComponent miniBusLineGroupComponent = new MiniBusLineGroupComponent();
            this.f28915c = miniBusLineGroupComponent;
            miniBusLineGroupComponent.setConfigParam(list, 2);
            this.f28915c.setProductId(PaxEnvironment.getInstance().getProductId());
            this.f28915c.create(getContext(), getMap());
            this.f28915c.setLineDateListener(new MiniBusLineGroupComponent.LineDateListener() {
                public void onLineDateRequestSuccess() {
                    MiniBusAppointScene miniBusAppointScene = MiniBusAppointScene.this;
                    miniBusAppointScene.doBestView(miniBusAppointScene.mPadding);
                }
            });
            this.f28915c.start();
        }
    }

    /* renamed from: c */
    private IconLabelMarker m22550c() {
        MarkerModel d = m22551d();
        if (d == null) {
            return null;
        }
        return new IconLabelMarker(getMap(), d.getId(), getContext()).create(new IconLabelMarker.IconLabelMarkerInfo.Builder().latlng(d.getPoint()).markerIcon(d.getMarkerIcon()).markerIconAnchorU(d.getAnchorU()).markerIconAnchorV(d.getAnchorV()).markerIconZIndex(d.getZOrder()).isClickable(true).build());
    }

    /* renamed from: d */
    private MarkerModel m22551d() {
        List<CommonMarkerParam> list;
        if (this.f28914b == null || getContext() == null || getMap() == null || (list = this.f28920h) == null) {
            return null;
        }
        CommonMarkerParam commonMarkerParam = null;
        for (CommonMarkerParam next : list) {
            if (next != null && next.getId() == MapElementId.ID_MARKER_PICK_UP) {
                commonMarkerParam = next;
            }
        }
        if (commonMarkerParam == null) {
            return null;
        }
        View inflate = View.inflate(getContext(), R.layout.map_comp_layout_minibus_appoint_bubble_view, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tv_content)).setText(TextUtils.isEmpty(commonMarkerParam.getAddressName()) ? "" : commonMarkerParam.getAddressName());
        Bitmap viewBitmap = MapUtils.getViewBitmap(inflate);
        if (viewBitmap == null) {
            return null;
        }
        MarkerModel markerModel = new MarkerModel();
        markerModel.setId(MapElementId.ID_MARKER_START_NAV.name());
        markerModel.setAnchorU(-0.05f);
        markerModel.setAnchorV(1.1f);
        markerModel.setZOrder(204);
        markerModel.setPoint(commonMarkerParam.getPoint());
        markerModel.setMarkerIcon(viewBitmap);
        markerModel.setClickable(false);
        return markerModel;
    }
}
