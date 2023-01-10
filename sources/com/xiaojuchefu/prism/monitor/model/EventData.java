package com.xiaojuchefu.prism.monitor.model;

import android.app.Activity;
import android.view.View;
import com.google.gson.annotations.SerializedName;
import com.xiaojuchefu.prism.monitor.PrismConstants;
import java.util.HashMap;
import java.util.Map;

public class EventData {
    public Activity activity;
    @SerializedName("an")

    /* renamed from: an */
    public String f58875an;
    public long avd;
    @SerializedName("data")
    public HashMap<String, Object> data;
    @SerializedName("eventId")
    public String eventId;
    @SerializedName("eventTime")
    public long eventTime = System.currentTimeMillis();
    @SerializedName("eventType")
    public int eventType;
    public long fvd;
    @SerializedName("h5")

    /* renamed from: h5 */
    public String f58876h5;
    @SerializedName("downX")
    public float mDownX;
    @SerializedName("downY")
    public float mDownY;
    @SerializedName("vf")

    /* renamed from: vf */
    public String f58877vf;
    @SerializedName("vi")

    /* renamed from: vi */
    public String f58878vi;
    public View view;
    @SerializedName("vl")

    /* renamed from: vl */
    public String f58879vl;
    @SerializedName("vp")

    /* renamed from: vp */
    public String f58880vp;
    @SerializedName("vq")

    /* renamed from: vq */
    public String f58881vq;
    @SerializedName("vr")

    /* renamed from: vr */
    public String f58882vr;
    @SerializedName("w")

    /* renamed from: w */
    public String f58883w;
    @SerializedName("wu")

    /* renamed from: wu */
    public String f58884wu;

    public EventData(int i) {
        this.eventType = i;
    }

    public static EventData getEventData(View view2, Map<String, String> map, int i) {
        if (view2 == null || map == null || map.size() == 0) {
            return null;
        }
        EventData eventData = new EventData(i);
        eventData.view = view2;
        eventData.f58883w = map.get("w");
        eventData.f58878vi = map.get("vi");
        eventData.f58882vr = map.get("vr");
        eventData.f58881vq = map.get("vq");
        eventData.f58879vl = map.get("vl");
        eventData.f58880vp = map.get("vp");
        eventData.f58884wu = map.get("wu");
        eventData.f58877vf = map.get("vf");
        eventData.f58876h5 = map.get(PrismConstants.Symbol.f58843H5);
        return eventData;
    }

    public String getEventId() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("e_&_");
        sb.append(this.eventType);
        if (this.eventId != null) {
            str = "_^_" + this.eventId;
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }
}
