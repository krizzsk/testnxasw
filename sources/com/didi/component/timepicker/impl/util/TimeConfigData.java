package com.didi.component.timepicker.impl.util;

import android.os.Handler;
import android.text.TextUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.timepicker.TimePickerModel;
import com.didi.sdk.componentconfig.ComponentConfigEvent;
import com.didi.sdk.componentconfig.ComponentConfigInfo;
import com.didi.sdk.componentconfig.ComponentStore;
import com.didi.sdk.event.EventReceiver;
import com.didi.sdk.view.timepicker.TimeStrategy;
import com.didi.travel.psnger.utils.TextUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class TimeConfigData {
    public static final int MIS_DELAY = 500;

    /* renamed from: a */
    private TimeConfigParams f18006a;

    /* renamed from: b */
    private ConfigChangeListener f18007b;

    /* renamed from: c */
    private TimeInfo f18008c;

    /* renamed from: d */
    private TimeInfo f18009d;

    /* renamed from: e */
    private Handler f18010e;

    /* renamed from: f */
    private int f18011f;

    /* renamed from: g */
    private Runnable f18012g;

    public interface ConfigChangeListener {
        void configChange(TimePickerModel timePickerModel);
    }

    public TimeConfigData() {
        this.f18010e = new Handler();
        this.f18011f = 500;
        this.f18012g = new Runnable() {
            public void run() {
                TimeConfigData.this.m15267b();
            }
        };
        this.f18006a = new TimeConfigParams();
        this.f18009d = new TimeInfo(3, 15);
        m15265a();
    }

    public TimeConfigData(TimeConfigParams timeConfigParams) {
        this.f18010e = new Handler();
        this.f18011f = 500;
        this.f18012g = new Runnable() {
            public void run() {
                TimeConfigData.this.m15267b();
            }
        };
        this.f18006a = timeConfigParams;
    }

    public void initConfigData() {
        m15265a();
    }

    public void setDefaultTimeInfo(TimeInfo timeInfo) {
        this.f18009d = timeInfo;
    }

    public void setConfigChangeListener(ConfigChangeListener configChangeListener) {
        this.f18007b = configChangeListener;
    }

    public void setCarType(String str) {
        if (this.f18006a == null) {
            this.f18006a = new TimeConfigParams();
        }
        this.f18006a.carType = str;
        m15265a();
    }

    public void setProductId(int i) {
        if (this.f18006a == null) {
            this.f18006a = new TimeConfigParams();
        }
        this.f18006a.productId = i;
        m15265a();
    }

    public void setScene(String str) {
        if (this.f18006a == null) {
            this.f18006a = new TimeConfigParams();
        }
        this.f18006a.sceneType = str;
        m15265a();
    }

    /* renamed from: a */
    private void m15265a() {
        this.f18010e.removeCallbacks(this.f18012g);
        this.f18010e.postDelayed(this.f18012g, (long) this.f18011f);
    }

    public void setDelay(int i) {
        this.f18011f = i;
    }

    @EventReceiver
    public void onReceive(ComponentConfigEvent componentConfigEvent) {
        GLog.m11353d("TimeConfigData onReceive  " + componentConfigEvent);
        if (componentConfigEvent == null || TextUtils.isEmpty(componentConfigEvent.getEvent())) {
            GLog.m11353d("TimeConfigData onReceive event == null or empty");
            return;
        }
        GLog.m11353d("TimeConfigData onReceive  " + componentConfigEvent.getEvent());
        if (ComponentStore.EVENT.equals(componentConfigEvent.getEvent())) {
            m15265a();
        }
    }

    /* renamed from: a */
    private static TimeInfo m15263a(ComponentConfigInfo componentConfigInfo, TimeConfigParams timeConfigParams) {
        JSONObject optJSONObject;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("TimeConfigData processComponentConfig timeConfigParams=");
            sb.append(timeConfigParams != null ? timeConfigParams.toString() : null);
            sb.append(" configInfo=");
            sb.append(componentConfigInfo != null ? componentConfigInfo.data : null);
            GLog.m11353d(sb.toString());
            if (componentConfigInfo != null) {
                if (!TextUtils.isEmpty(componentConfigInfo.data)) {
                    if (!"0".equals(componentConfigInfo.errno)) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject(componentConfigInfo.data);
                    GLog.m11353d("TimeConfigData processComponentConfig data=" + componentConfigInfo.data);
                    if (timeConfigParams == null || (optJSONObject = jSONObject.optJSONObject("timer")) == null) {
                        return null;
                    }
                    JSONArray optJSONArray = optJSONObject.optJSONArray("" + timeConfigParams.productId);
                    if (optJSONArray == null) {
                        return null;
                    }
                    ArrayList arrayList = new ArrayList();
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        TimeInfo timeInfo = new TimeInfo();
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        timeInfo.orderType = jSONObject2.optString("order_type");
                        timeInfo.productId = jSONObject2.optInt("product_id");
                        timeInfo.carLevel = jSONObject2.optString("car_level");
                        timeInfo.scence = jSONObject2.optString("scence");
                        JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                        timeInfo.appointDay = optJSONObject2.optInt("max_apoint_day");
                        timeInfo.advanceMin = optJSONObject2.optInt("min_advance_min");
                        JSONObject optJSONObject3 = optJSONObject2.optJSONObject("time_span");
                        if (optJSONObject3 != null) {
                            timeInfo.from = optJSONObject3.optInt("from");
                            timeInfo.f18013to = optJSONObject3.optInt("to");
                            if (timeInfo.f18013to == 0) {
                                timeInfo.f18013to = 24;
                            }
                        }
                        arrayList.add(timeInfo);
                    }
                    TimeInfo a = m15264a((List<TimeInfo>) arrayList, timeConfigParams);
                    if (a != null) {
                        GLog.m11353d("TimeConfigData processComponentConfig  " + a);
                    }
                    return a;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static TimeInfo m15264a(List<TimeInfo> list, TimeConfigParams timeConfigParams) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            TimeInfo timeInfo = list.get(i);
            if (((TextUtils.isEmpty(timeInfo.scence) && TextUtils.isEmpty(timeConfigParams.sceneType)) || (timeInfo.scence != null && timeInfo.scence.equals(timeConfigParams.sceneType))) && ((TextUtil.isEmpty(timeInfo.carLevel) && TextUtil.isEmpty(timeConfigParams.carType)) || (timeInfo.carLevel != null && timeInfo.carLevel.equals(timeConfigParams.carType)))) {
                return timeInfo;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m15267b() {
        TimeInfo a = m15262a(this.f18006a);
        if ((a == null && this.f18008c == null) || (a != null && this.f18008c != null && a.advanceMin == this.f18008c.advanceMin && a.appointDay == this.f18008c.appointDay && a.from == this.f18008c.from && a.f18013to == this.f18008c.f18013to)) {
            GLog.m11353d("TimeConfigData handlerComponent data is not change " + this.f18008c);
            return;
        }
        this.f18008c = a;
        GLog.m11353d("TimeConfigData handlerComponent data " + this.f18008c);
        if (this.f18007b != null) {
            TimePickerModel timePickerModel = null;
            if (this.f18008c != null) {
                timePickerModel = new TimePickerModel();
                timePickerModel.appointmentDay = this.f18008c.appointDay;
                timePickerModel.earliestDelta = this.f18008c.advanceMin;
                timePickerModel.from = this.f18008c.from;
                timePickerModel.f17998to = this.f18008c.f18013to;
            }
            this.f18007b.configChange(timePickerModel);
        }
    }

    /* renamed from: a */
    private static TimeInfo m15262a(TimeConfigParams timeConfigParams) {
        StringBuilder sb = new StringBuilder();
        sb.append("TimeConfigData getComponentConfig ");
        sb.append(timeConfigParams != null ? timeConfigParams.toString() : null);
        GLog.m11353d(sb.toString());
        return m15263a(ComponentStore.getInstance().getComponentInfo(), timeConfigParams);
    }

    public static class TimeInfo {
        int advanceMin;
        int appointDay;
        String carLevel;
        int from = 0;
        String orderType;
        int productId;
        String scence;

        /* renamed from: to */
        int f18013to = 24;

        public TimeInfo(int i, int i2) {
            this.appointDay = i;
            this.advanceMin = i2;
        }

        public TimeInfo(int i, int i2, int i3, int i4) {
            this.appointDay = i;
            this.advanceMin = i2;
            this.from = i3;
            this.f18013to = i4;
        }

        public TimeInfo() {
        }

        public String toString() {
            return "TimeInfo{productId='" + this.productId + '\'' + ", orderType='" + this.orderType + '\'' + ", scence='" + this.scence + '\'' + ", carLevel='" + this.carLevel + '\'' + ", appointDay=" + this.appointDay + ", advanceMin=" + this.advanceMin + ", from=" + this.from + ", to=" + this.f18013to + '}';
        }
    }

    public static class TimeConfigParams {
        public String carType = "0";
        public int productId;
        public String sceneType;

        public TimeConfigParams() {
        }

        public TimeConfigParams(int i, String str, String str2) {
            this.productId = i;
            this.sceneType = str;
            this.carType = str2;
        }

        public String toString() {
            return "TimeConfigParams{productId='" + this.productId + '\'' + ", sceneType='" + this.sceneType + '\'' + ", carType='" + this.carType + '\'' + '}';
        }
    }

    public static boolean checkTimeValidate(long j, TimeConfigParams timeConfigParams, TimeInfo timeInfo, boolean z) {
        TimeStrategy timeStrategy = new TimeStrategy();
        TimeInfo a = m15262a(timeConfigParams);
        if (a != null) {
            timeInfo = a;
        }
        if (timeInfo == null) {
            return false;
        }
        timeStrategy.setAppointmentDay(timeInfo.appointDay);
        timeStrategy.setEarliestDelta(timeInfo.advanceMin);
        timeStrategy.setBeginHourInDay(timeInfo.from);
        timeStrategy.setEndHourInDay(timeInfo.f18013to);
        timeStrategy.setIsSupportNow(z);
        return !timeStrategy.isInvalid(j);
    }

    public static long getLatestAvailableTime(TimeConfigParams timeConfigParams, TimeInfo timeInfo) {
        TimeStrategy timeStrategy = new TimeStrategy();
        TimeInfo a = m15262a(timeConfigParams);
        if (a != null) {
            timeInfo = a;
        }
        GLog.m11353d("TimeConfigData getLatestAvailableTime " + timeInfo);
        if (timeInfo == null) {
            return 0;
        }
        timeStrategy.setAppointmentDay(timeInfo.appointDay);
        timeStrategy.setEarliestDelta(timeInfo.advanceMin);
        timeStrategy.setBeginHourInDay(timeInfo.from);
        timeStrategy.setEndHourInDay(timeInfo.f18013to);
        return timeStrategy.getLatestAvailableTime();
    }
}
