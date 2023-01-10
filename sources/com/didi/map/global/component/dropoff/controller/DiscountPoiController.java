package com.didi.map.global.component.dropoff.controller;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.text.TextUtils;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.map.global.component.dropoff.card.RichTextInfo;
import com.didi.map.global.component.dropoff.model.DropOffLocationInfo;
import com.didi.map.global.component.dropoff.util.DropOffUtils;
import com.didi.map.global.component.line.pax.dropoffline.SingleWalkLineManager;
import com.didi.map.global.component.line.pax.dropoffline.SingleWalkLineParam;
import com.didi.map.global.component.line.pax.dropoffline.WalkLineCallback;
import com.didi.map.global.component.markers.IMarkersCompContract;
import com.didi.map.global.component.markers.MarkersCompParams;
import com.didi.map.global.component.markers.MarkersComponent;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didi.map.sdk.proto.driver_gl.SingleRouteRes;
import com.didichuxing.routesearchsdk.CallFrom;
import com.google.gson.Gson;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiscountPoiController {

    /* renamed from: a */
    private Context f27724a;

    /* renamed from: b */
    private Map f27725b;

    /* renamed from: c */
    private DropOffLocationInfo f27726c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public SingleWalkLineParam f27727d;

    /* renamed from: e */
    private SingleWalkLineManager f27728e;

    /* renamed from: f */
    private IMarkersCompContract f27729f;

    /* renamed from: g */
    private String f27730g = "DiscountPoiController_child";

    /* renamed from: h */
    private String f27731h = "DiscountPoiController_parent";

    /* renamed from: i */
    private final float f27732i = 1.4f;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public WalkLineResultListener f27733j;

    /* renamed from: k */
    private WalkLineCallback f27734k = new WalkLineCallback() {
        public void onFinishToSearch(boolean z, SingleRouteRes singleRouteRes) {
            int i;
            int i2;
            if (z) {
                i2 = singleRouteRes.eta.intValue();
                i = singleRouteRes.distance.intValue();
            } else {
                i = (int) DDSphericalUtil.computeDistanceBetween(DiscountPoiController.this.f27727d.getStartPos(), DiscountPoiController.this.f27727d.getEndPos());
                i2 = (int) ((((float) i) / 1.4f) / 60.0f);
            }
            if (DiscountPoiController.this.f27733j != null) {
                DiscountPoiController.this.f27733j.onGetEtaEda(z, i2, i);
            }
        }
    };

    public interface WalkLineResultListener {
        void onGetEtaEda(boolean z, int i, int i2);
    }

    public DiscountPoiController(Context context, Map map, DropOffLocationInfo dropOffLocationInfo) {
        this.f27724a = context;
        this.f27725b = map;
        this.f27726c = dropOffLocationInfo;
    }

    public void start() {
        m21896a();
        m21899c();
    }

    /* renamed from: a */
    private void m21896a() {
        if (this.f27726c != null && this.f27725b != null && this.f27724a != null) {
            this.f27729f = new MarkersComponent();
            ArrayList arrayList = new ArrayList();
            if (this.f27726c.sugPoi != null) {
                MarkerModel markerModel = new MarkerModel();
                LatLng latLng = new LatLng(this.f27726c.sugPoi.latitude, this.f27726c.sugPoi.longitude);
                markerModel.setZOrder(99);
                markerModel.setPoint(latLng);
                markerModel.setMarkerIcon(BitmapFactory.decodeResource(this.f27724a.getResources(), R.drawable.map_input_icon_destination));
                markerModel.setLabelZIndex(99);
                markerModel.setAnchorU(0.5f);
                markerModel.setAnchorV(0.5f);
                markerModel.setClickable(false);
                markerModel.setId(this.f27730g);
                arrayList.add(markerModel);
                DropOffUtils.LOGD(" add Discount Poi Marker");
            }
            if (this.f27726c.parentPoi != null) {
                MarkerModel markerModel2 = new MarkerModel();
                LatLng latLng2 = new LatLng(this.f27726c.parentPoi.latitude, this.f27726c.parentPoi.longitude);
                markerModel2.setZOrder(99);
                markerModel2.setPoint(latLng2);
                markerModel2.setMarkerIcon(BitmapFactory.decodeResource(this.f27724a.getResources(), R.drawable.map_discount_parent_icon));
                markerModel2.setLabelZIndex(99);
                markerModel2.setAnchorU(0.5f);
                markerModel2.setAnchorV(0.5f);
                markerModel2.setClickable(false);
                markerModel2.setId(this.f27731h);
                arrayList.add(markerModel2);
                DropOffUtils.LOGD(" add Parent Poi Marker = ");
            }
            MarkersCompParams.Builder builder = new MarkersCompParams.Builder();
            builder.markerModels(arrayList);
            this.f27729f.setConfigParam(builder.build());
            this.f27729f.create(this.f27724a, this.f27725b);
            m21898b();
        }
    }

    /* renamed from: b */
    private void m21898b() {
        if (!TextUtils.isEmpty(this.f27726c.parentPoi.displayName) && this.f27729f != null) {
            this.f27729f.showMarkerInfoWindow(this.f27731h, new DropOffInfoWindow().getView(this.f27724a, this.f27726c.parentPoi.displayName), InfoWindow.Position.TOP);
            DropOffUtils.LOGD(" add Parent Poi Bubble");
        }
    }

    /* renamed from: c */
    private void m21899c() {
        DropOffLocationInfo dropOffLocationInfo = this.f27726c;
        if (dropOffLocationInfo != null && dropOffLocationInfo.sugPoi != null && this.f27726c.parentPoi != null) {
            if (this.f27728e == null) {
                LatLng latLng = new LatLng(this.f27726c.sugPoi.latitude, this.f27726c.sugPoi.longitude);
                LatLng latLng2 = new LatLng(this.f27726c.parentPoi.latitude, this.f27726c.parentPoi.longitude);
                SingleWalkLineParam singleWalkLineParam = new SingleWalkLineParam();
                this.f27727d = singleWalkLineParam;
                singleWalkLineParam.setStartPos(latLng);
                this.f27727d.setEndPos(latLng2);
                this.f27727d.setLineAColor(Color.parseColor("#33BBFF"));
                this.f27727d.setLineAWidth(4);
                this.f27727d.setLineASpace(5.0f);
                this.f27727d.setLineBSpace(20.0f);
                this.f27727d.setCaller(CallFrom.ORDERROUTEAPI_BUBBLE);
                this.f27728e = new SingleWalkLineManager(this.f27724a, this.f27725b, this.f27727d, this.f27734k);
            }
            this.f27728e.requestLine();
        }
    }

    public List<IMapElement> getMapElements() {
        ArrayList arrayList = new ArrayList();
        IMarkersCompContract iMarkersCompContract = this.f27729f;
        if (iMarkersCompContract != null) {
            arrayList.addAll(iMarkersCompContract.getMarkers());
        }
        SingleWalkLineManager singleWalkLineManager = this.f27728e;
        if (singleWalkLineManager != null) {
            List<IMapElement> mapElements = singleWalkLineManager.getMapElements();
            if (!CollectionUtil.isEmpty((Collection<?>) mapElements)) {
                arrayList.addAll(mapElements);
            }
        }
        return arrayList;
    }

    public String generateSubTitleRichJson(String str) {
        RichTextInfo richTextInfo = new RichTextInfo();
        richTextInfo.setInfo(str);
        Matcher matcher = Pattern.compile("[\\d.]+[ ]*%").matcher(richTextInfo.getContent());
        int start = matcher.find() ? matcher.start() : -1;
        if (start != -1) {
            List<RichTextInfo.RichInfo> infoList = richTextInfo.getInfoList();
            if (!CollectionUtil.isEmpty((Collection<?>) infoList)) {
                infoList.get(infoList.size() - 1).start = start;
            }
        }
        String json = new Gson().toJson((Object) richTextInfo);
        DropOffUtils.LOGD("discountXXX Transform = " + start);
        return json;
    }

    public void destroy() {
        IMarkersCompContract iMarkersCompContract = this.f27729f;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.destroy();
            this.f27729f = null;
        }
        SingleWalkLineManager singleWalkLineManager = this.f27728e;
        if (singleWalkLineManager != null) {
            singleWalkLineManager.destroy();
        }
        this.f27728e = null;
        this.f27727d = null;
        this.f27725b = null;
        this.f27724a = null;
    }

    public void setWalkLineResultListener(WalkLineResultListener walkLineResultListener) {
        this.f27733j = walkLineResultListener;
    }
}
