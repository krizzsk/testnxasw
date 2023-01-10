package com.didi.map.global.flow.scene.order.waiting;

import android.view.View;
import com.didi.common.map.BestViewer;
import com.didi.common.map.listener.CancelableCallback;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.PageScene;
import com.didi.map.global.flow.scene.order.waiting.temp.GuideLine;
import com.didi.map.global.flow.scene.order.waiting.temp.GuideLineParam;
import com.didi.map.global.flow.scene.order.waiting.temp.StartEndMarker;
import com.didi.map.global.model.location.LocationHelper;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import java.util.ArrayList;
import java.util.List;

@IScene.Scene(mo80431id = 1004)
public class WaitingForReplyOldScene extends PageScene<WaitingForReplyParam> implements IWaitingForReplyController {

    /* renamed from: a */
    private StartEndMarker f29470a;

    /* renamed from: b */
    private LatLng f29471b;

    /* renamed from: c */
    private GuideLine f29472c;

    public void animateCamera(CameraPosition cameraPosition, int i, CancelableCallback cancelableCallback) {
    }

    public void sendOrderSuc(String str, String str2) {
    }

    public WaitingForReplyOldScene(WaitingForReplyParam waitingForReplyParam, MapViewHolder mapViewHolder) {
        super(waitingForReplyParam, mapViewHolder);
    }

    /* renamed from: a */
    private void m22834a(boolean z) {
        if (z && this.f29470a != null) {
            GuideLine guideLine = new GuideLine(getContext(), getMap());
            this.f29472c = guideLine;
            guideLine.setParam(new GuideLineParam(((WaitingForReplyParam) this.mParam).getDottedLineColor(), this.f29470a.getStartMarkerPosition()));
            this.f29472c.show();
        }
    }

    public void enter(Bundle bundle) {
        super.enter(bundle);
        StartEndMarker startEndMarker = new StartEndMarker(this.mMapView.getMapView());
        this.f29470a = startEndMarker;
        startEndMarker.update(((WaitingForReplyParam) this.mParam).getStartEndMarkerModel());
        m22834a(((WaitingForReplyParam) this.mParam).isShowWalkLine());
    }

    public void leave() {
        super.leave();
        StartEndMarker startEndMarker = this.f29470a;
        if (startEndMarker != null) {
            startEndMarker.destroy();
            this.f29470a = null;
        }
        GuideLine guideLine = this.f29472c;
        if (guideLine != null) {
            guideLine.destroy();
            this.f29472c = null;
        }
    }

    public void onResume() {
        if (this.isSceneValid) {
            GuideLine guideLine = this.f29472c;
            if (guideLine != null) {
                guideLine.show();
            }
            doBestView(getMap().getPadding());
        }
    }

    public void onPause() {
        GuideLine guideLine;
        if (this.isSceneValid && (guideLine = this.f29472c) != null) {
            guideLine.hide();
        }
    }

    public void doBestView(Padding padding) {
        super.doBestView(padding);
        if (this.isSceneValid && getMap() != null) {
            hideResetView();
            this.mHandler.removeCallbacksAndMessages((Object) null);
            DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(getContext());
            if (lastKnownLocation != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude()));
                arrayList.add(this.f29470a.getStartMarkerPosition());
                int dp2px = DisplayUtils.dp2px(getContext(), 40.0f);
                BestViewer.doBestView(getMap(), true, this.f29470a.getStartMarkerPosition(), (List<LatLng>) arrayList, padding, new Padding(dp2px, dp2px, DisplayUtils.dp2px(getContext(), 40.0f), dp2px));
                return;
            }
            BestViewer.doBestView(getMap(), true, Float.valueOf(15.0f), this.f29470a.getStartMarkerPosition(), padding, (BestViewer.IBestViewListener) null);
        }
    }

    public void updateWaitingForReplyBubble(View view) {
        StartEndMarker startEndMarker;
        if (this.isSceneValid && (startEndMarker = this.f29470a) != null) {
            startEndMarker.showStartMarkerInfoWindow(view, (InfoWindow.Position) null);
        }
    }
}
