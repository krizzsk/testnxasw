package com.didi.map.global.component.departure.bubble;

import com.didi.common.map.Map;
import com.didi.map.global.component.departure.bubble.MapBubble;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.departure.pin.IPinDrawer;
import com.sdk.poibase.model.RpcPoi;

public class DepartureBubbleController {

    /* renamed from: d */
    private static final String f27154d = "DptBubbleController";

    /* renamed from: a */
    private Map f27155a;

    /* renamed from: b */
    private IPinDrawer f27156b;

    /* renamed from: c */
    private MapBubble.OnClickListener f27157c;

    /* renamed from: a */
    private void m21410a(DepartureAddress departureAddress) {
    }

    /* renamed from: a */
    private void m21411a(String str, MapBubble.OnClickListener onClickListener) {
    }

    /* renamed from: a */
    private boolean m21412a(RpcPoi rpcPoi) {
        return true;
    }

    /* renamed from: b */
    private void m21413b(DepartureAddress departureAddress) {
    }

    /* renamed from: b */
    private boolean m21414b(RpcPoi rpcPoi) {
        return true;
    }

    /* renamed from: c */
    private void m21415c(DepartureAddress departureAddress) {
    }

    /* renamed from: c */
    private boolean m21416c(RpcPoi rpcPoi) {
        return true;
    }

    /* renamed from: d */
    private boolean m21417d(DepartureAddress departureAddress) {
        return true;
    }

    /* renamed from: e */
    private boolean m21418e(DepartureAddress departureAddress) {
        return true;
    }

    public static boolean enableBubblePicture(RpcPoi rpcPoi) {
        return true;
    }

    public void removeBubble() {
    }

    public void showBubble(DepartureAddress departureAddress) {
    }

    public void showLoaddingBubble() {
    }

    public DepartureBubbleController(Map map, IPinDrawer iPinDrawer) {
        this.f27155a = map;
        this.f27156b = iPinDrawer;
    }

    public void setOnClickListener(MapBubble.OnClickListener onClickListener) {
        this.f27157c = onClickListener;
    }
}
