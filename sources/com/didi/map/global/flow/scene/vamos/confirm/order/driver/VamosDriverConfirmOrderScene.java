package com.didi.map.global.flow.scene.vamos.confirm.order.driver;

import android.view.View;
import com.didi.common.map.BestViewer;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
import com.didi.common.map.util.ImageUtil;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.component.line.component.OnLineDrawStatusListener;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.component.markers.MarkersCompParams;
import com.didi.map.global.component.markers.MarkersComponent;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.PageScene;
import com.didi.map.global.flow.scene.order.confirm.normal.IStartEndMarkerInfoWindowController;
import com.didi.map.global.flow.scene.order.confirm.normal.StartEndInfo;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@IScene.Scene(mo80431id = 2004)
public class VamosDriverConfirmOrderScene extends PageScene<VamosDriverConfirmOrderSceneParam> implements IVamosDriverConfirmOrderController {
    public static final String ID_MARKER_END = "id_marker_end";
    public static final String ID_MARKER_START = "id_marker_start";

    /* renamed from: a */
    private ICompLineContract f29617a;

    /* renamed from: b */
    private MarkersComponent f29618b;

    /* renamed from: c */
    private final int f29619c = 51;

    /* renamed from: d */
    private final int f29620d = 50;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f29621e = "VamosDriverConfirmOrderScene";

    public void onPause() {
    }

    public void onResume() {
    }

    public /* synthetic */ boolean showEndMarkerInfoWindowAdapter(View view, InfoWindow.Position position) {
        return IStartEndMarkerInfoWindowController.CC.$default$showEndMarkerInfoWindowAdapter(this, view, position);
    }

    public /* synthetic */ boolean showStartMarkerInfoWindowAdapter(View view, InfoWindow.Position position) {
        return IStartEndMarkerInfoWindowController.CC.$default$showStartMarkerInfoWindowAdapter(this, view, position);
    }

    public VamosDriverConfirmOrderScene(VamosDriverConfirmOrderSceneParam vamosDriverConfirmOrderSceneParam, MapViewHolder mapViewHolder) {
        super(vamosDriverConfirmOrderSceneParam, mapViewHolder);
    }

    public void enter(Bundle bundle) {
        super.enter(bundle);
        SystemUtils.log(3, "sfs", "VamosDriverConfirmOrderScene enter()", (Throwable) null, "com.didi.map.global.flow.scene.vamos.confirm.order.driver.VamosDriverConfirmOrderScene", 63);
        m22956a();
        m22957b();
    }

    /* renamed from: a */
    private void m22956a() {
        if (this.mParam != null && getMap() != null) {
            ArrayList arrayList = new ArrayList();
            if (startEndInfoConvertToModel(((VamosDriverConfirmOrderSceneParam) this.mParam).getStartInfo(), "id_marker_start", 51) != null) {
                arrayList.add(startEndInfoConvertToModel(((VamosDriverConfirmOrderSceneParam) this.mParam).getStartInfo(), "id_marker_start", 51));
            }
            if (startEndInfoConvertToModel(((VamosDriverConfirmOrderSceneParam) this.mParam).getEndInfo(), "id_marker_end", 50) != null) {
                arrayList.add(startEndInfoConvertToModel(((VamosDriverConfirmOrderSceneParam) this.mParam).getEndInfo(), "id_marker_end", 50));
            }
            this.f29618b = new MarkersComponent();
            this.f29618b.setConfigParam(new MarkersCompParams.Builder().markerModels(arrayList).build());
            this.f29618b.create(getContext(), getMap());
        }
    }

    public MarkerModel startEndInfoConvertToModel(StartEndInfo startEndInfo, String str, int i) {
        if (startEndInfo == null) {
            return null;
        }
        MarkerModel markerModel = new MarkerModel();
        markerModel.setId(str);
        markerModel.setPoint(new LatLng(startEndInfo.addressInfo.latitude, startEndInfo.addressInfo.longitude));
        markerModel.setAnchorU(startEndInfo.anchorU);
        markerModel.setAnchorV(startEndInfo.anchorV);
        markerModel.setMarkerIcon(ImageUtil.Drawable2Bitmap(startEndInfo.markerIcon));
        markerModel.setZOrder(i);
        return markerModel;
    }

    /* renamed from: a */
    private LatLng m22954a(StartEndInfo startEndInfo) {
        if (startEndInfo == null || startEndInfo.addressInfo == null) {
            return null;
        }
        return new LatLng(startEndInfo.addressInfo.latitude, startEndInfo.addressInfo.longitude);
    }

    /* renamed from: b */
    private void m22957b() {
        if (this.mParam != null && getMap() != null && ((VamosDriverConfirmOrderSceneParam) this.mParam).getStartInfo() != null && ((VamosDriverConfirmOrderSceneParam) this.mParam).getEndInfo() != null) {
            LatLng a = m22954a(((VamosDriverConfirmOrderSceneParam) this.mParam).getStartInfo());
            LatLng a2 = m22954a(((VamosDriverConfirmOrderSceneParam) this.mParam).getEndInfo());
            if (!((VamosDriverConfirmOrderSceneParam) this.mParam).isDrawLine() || a == null || a2 == null) {
                DLog.m10773d(this.f29621e, "起终点弧线参数异常", new Object[0]);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(a);
            arrayList.add(a2);
            LineParams lineParams = new LineParams(arrayList, ((VamosDriverConfirmOrderSceneParam) this.mParam).getLineColor(), ((VamosDriverConfirmOrderSceneParam) this.mParam).getLineWidth());
            ICompLineContract iCompLineContract = this.f29617a;
            if (iCompLineContract != null) {
                iCompLineContract.destroy();
                this.f29617a = null;
            }
            ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_ARC, getMap(), getContext(), lineParams);
            this.f29617a = createLineComponent;
            createLineComponent.setListener(new OnLineDrawStatusListener() {
                public /* synthetic */ void onLineDrawStart() {
                    OnLineDrawStatusListener.CC.$default$onLineDrawStart(this);
                }

                public void onLineDrawFinished() {
                    DLog.m10773d(VamosDriverConfirmOrderScene.this.f29621e, "起终点弧线连线成功", new Object[0]);
                }
            });
            this.f29617a.start();
        }
    }

    public void leave() {
        super.leave();
        SystemUtils.log(3, this.f29621e, "VamosDriverConfirmOrderScene leave()", (Throwable) null, "com.didi.map.global.flow.scene.vamos.confirm.order.driver.VamosDriverConfirmOrderScene", 152);
        MarkersComponent markersComponent = this.f29618b;
        if (markersComponent != null) {
            markersComponent.destroy();
            this.f29618b = null;
        }
        ICompLineContract iCompLineContract = this.f29617a;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
            this.f29617a = null;
        }
    }

    public void doBestView(Padding padding) {
        super.doBestView(padding);
        if (this.isSceneValid && getMap() != null) {
            hideResetView();
            this.f29618b.setMarkerVisible("id_marker_end", true);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f29618b.getMarkers());
            if (this.mMapView != null) {
                List<IMapElement> myLocationMarkers = this.mMapView.getMyLocationMarkers();
                if (!CollectionUtil.isEmpty((Collection<?>) myLocationMarkers)) {
                    arrayList.addAll(myLocationMarkers);
                }
            }
            Padding padding2 = new Padding();
            padding2.left = DisplayUtils.dp2px(getContext(), 10.0f);
            padding2.right = DisplayUtils.dp2px(getContext(), 10.0f);
            BestViewer.doBestView(getMap(), true, (List<IMapElement>) arrayList, padding, padding2, (BestViewer.IBestViewListener) null);
        }
    }

    public boolean showStartMarkerInfoWindow(View view) {
        return showStartMarkerInfoWindow(view, (InfoWindow.Position) null);
    }

    public boolean showStartMarkerInfoWindow(View view, InfoWindow.Position position) {
        MarkersComponent markersComponent;
        if (!this.isSceneValid || (markersComponent = this.f29618b) == null) {
            return false;
        }
        markersComponent.showMarkerInfoWindow("id_marker_start", view, position);
        return true;
    }

    public void setOnStartMarkerInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        MarkersComponent markersComponent;
        if (this.isSceneValid && (markersComponent = this.f29618b) != null) {
            markersComponent.setInfoWindowClickListener("id_marker_start", onInfoWindowClickListener);
        }
    }

    public void removeStartMarkerInfoWindow() {
        MarkersComponent markersComponent;
        if (this.isSceneValid && (markersComponent = this.f29618b) != null) {
            markersComponent.hideMarkerInfoWindow("id_marker_start");
        }
    }

    public boolean showEndMarkerInfoWindow(View view) {
        return showEndMarkerInfoWindow(view, (InfoWindow.Position) null);
    }

    public boolean showEndMarkerInfoWindow(View view, InfoWindow.Position position) {
        MarkersComponent markersComponent;
        if (!this.isSceneValid || (markersComponent = this.f29618b) == null) {
            return false;
        }
        markersComponent.showMarkerInfoWindow("id_marker_end", view, position);
        return true;
    }

    public void setOnEndMarkerInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        MarkersComponent markersComponent;
        if (this.isSceneValid && (markersComponent = this.f29618b) != null) {
            markersComponent.setInfoWindowClickListener("id_marker_end", onInfoWindowClickListener);
        }
    }

    public void removeEndMarkerInfoWindow() {
        MarkersComponent markersComponent;
        if (this.isSceneValid && (markersComponent = this.f29618b) != null) {
            markersComponent.hideMarkerInfoWindow("id_marker_end");
        }
    }
}
