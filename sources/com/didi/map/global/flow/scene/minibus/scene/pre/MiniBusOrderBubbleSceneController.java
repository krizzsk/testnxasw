package com.didi.map.global.flow.scene.minibus.scene.pre;

import android.content.Context;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.markers.MarkersCompParams;
import com.didi.map.global.component.markers.MarkersComponent;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didi.map.global.flow.scene.minibus.MiniBusMarkerConfig;
import com.didi.map.global.flow.scene.minibus.component.MiniBusLineGroupComponent;
import com.didi.map.global.flow.scene.minibus.param.MiniBusParamInterface;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MiniBusOrderBubbleSceneController {

    /* renamed from: a */
    private Context f28899a;

    /* renamed from: b */
    private Map f28900b;

    /* renamed from: c */
    private MarkersComponent f28901c;

    /* renamed from: d */
    private MiniBusLineGroupComponent f28902d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Padding f28903e;

    public MiniBusOrderBubbleSceneController(Context context, Map map) {
        this.f28899a = context;
        this.f28900b = map;
    }

    public boolean doBestView(Padding padding) {
        this.f28903e = padding;
        DLog.m10773d("MiniBusOrderBubbleSceneController", "小巴最佳视野", new Object[0]);
        ArrayList arrayList = new ArrayList();
        MarkersComponent markersComponent = this.f28901c;
        if (markersComponent != null) {
            arrayList.addAll(markersComponent.getMarkers());
        }
        MiniBusLineGroupComponent miniBusLineGroupComponent = this.f28902d;
        if (miniBusLineGroupComponent != null) {
            arrayList.addAll(miniBusLineGroupComponent.getBestViewElements());
        }
        BestViewer.doBestView(this.f28900b, true, (List<IMapElement>) arrayList, padding, (Padding) null, (BestViewer.IBestViewListener) null);
        return true;
    }

    public void onDestroy() {
        DLog.m10773d("MiniBusOrderBubbleSceneController", "小巴销毁元素", new Object[0]);
        MarkersComponent markersComponent = this.f28901c;
        if (markersComponent != null) {
            markersComponent.destroy();
            this.f28901c = null;
        }
        MiniBusLineGroupComponent miniBusLineGroupComponent = this.f28902d;
        if (miniBusLineGroupComponent != null) {
            miniBusLineGroupComponent.destroy();
            this.f28902d = null;
        }
    }

    public void onChangeMiniBusCar(MiniBusParamInterface miniBusParamInterface) {
        systemOutLog(miniBusParamInterface);
        if (miniBusParamInterface != null) {
            List<CommonLineParam> miniBusLineParam = miniBusParamInterface.getMiniBusLineParam();
            List<CommonMarkerParam> configMarkerParam = MiniBusMarkerConfig.getConfigMarkerParam(miniBusParamInterface.getMiniBusMarkerParam());
            m22513b(miniBusLineParam);
            m22512a(configMarkerParam);
        }
    }

    public void systemOutLog(MiniBusParamInterface miniBusParamInterface) {
        if (miniBusParamInterface != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("marker参数内容");
            for (CommonMarkerParam next : miniBusParamInterface.getMiniBusMarkerParam()) {
                if (next != null) {
                    sb.append(next.toString());
                }
            }
            DLog.m10773d("MiniBusOrderBubble->marker->", sb.toString(), new Object[0]);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("line参数内容");
            for (CommonLineParam next2 : miniBusParamInterface.getMiniBusLineParam()) {
                if (next2 != null) {
                    sb2.append(next2.toString());
                }
            }
            DLog.m10773d("MiniBusOrderBubble->line->->", sb2.toString(), new Object[0]);
        }
    }

    /* renamed from: a */
    private void m22512a(List<CommonMarkerParam> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            this.f28901c = new MarkersComponent();
            ArrayList arrayList = new ArrayList();
            for (CommonMarkerParam a : list) {
                MarkerModel a2 = m22511a(a);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            this.f28901c.setConfigParam(new MarkersCompParams.Builder().markerModels(arrayList).build());
            this.f28901c.create(this.f28899a, this.f28900b);
        }
    }

    /* renamed from: b */
    private void m22513b(List<CommonLineParam> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            MiniBusLineGroupComponent miniBusLineGroupComponent = new MiniBusLineGroupComponent();
            this.f28902d = miniBusLineGroupComponent;
            miniBusLineGroupComponent.setConfigParam(list, 0);
            this.f28902d.create(this.f28899a, this.f28900b);
            this.f28902d.setLineDateListener(new MiniBusLineGroupComponent.LineDateListener() {
                public void onLineDateRequestSuccess() {
                    if (MiniBusOrderBubbleSceneController.this.f28903e != null) {
                        MiniBusOrderBubbleSceneController miniBusOrderBubbleSceneController = MiniBusOrderBubbleSceneController.this;
                        miniBusOrderBubbleSceneController.doBestView(miniBusOrderBubbleSceneController.f28903e);
                    }
                }
            });
            this.f28902d.start();
        }
    }

    /* renamed from: a */
    private MarkerModel m22511a(CommonMarkerParam commonMarkerParam) {
        if (commonMarkerParam == null) {
            return null;
        }
        MarkerModel markerModel = new MarkerModel();
        if (commonMarkerParam.getPoint() != null) {
            markerModel.setPoint(new LatLng(commonMarkerParam.getPoint().latitude, commonMarkerParam.getPoint().longitude));
        }
        markerModel.setAnchorU(commonMarkerParam.getAnchorU());
        markerModel.setAnchorV(commonMarkerParam.getAnchorV());
        markerModel.setMarkerIcon(commonMarkerParam.getMarkerIcon());
        markerModel.setId(commonMarkerParam.getId().name());
        markerModel.setZOrder(commonMarkerParam.getZIndex());
        return markerModel;
    }
}
