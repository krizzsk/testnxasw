package com.dmap.navigation.engine.p207a;

import android.util.LruCache;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.didi.hawaii.log.HWLog;
import com.didi.map.base.TrafficEventRoutePoint;
import com.didi.soda.customer.app.constant.Const;
import com.dmap.navigation.api.route.IRouteEx;
import com.dmap.navigation.base.ctx.INaviContext;
import com.dmap.navigation.base.location.INaviLocation;
import com.dmap.navigation.base.route.IMatchRouteInfo;
import com.dmap.navigation.base.route.IRoute;
import com.dmap.navigation.engine.core.INaviEngine;
import com.dmap.navigation.engine.core.INaviEventListener;
import com.dmap.navigation.engine.event.AnalysisEvent;
import com.dmap.navigation.engine.event.ArriveEvent;
import com.dmap.navigation.engine.event.CameraEvent;
import com.dmap.navigation.engine.event.CongestionEvent;
import com.dmap.navigation.engine.event.DestinationEvent;
import com.dmap.navigation.engine.event.DownloadEvent;
import com.dmap.navigation.engine.event.DownloadMJOEvent;
import com.dmap.navigation.engine.event.DownloadVecEvent;
import com.dmap.navigation.engine.event.EnlargeMapEvent;
import com.dmap.navigation.engine.event.IllegalParkEvent;
import com.dmap.navigation.engine.event.IntersectionEvent;
import com.dmap.navigation.engine.event.LaneEvent;
import com.dmap.navigation.engine.event.LimitSpeedCameraEvent;
import com.dmap.navigation.engine.event.MJOPrepareEvent;
import com.dmap.navigation.engine.event.MatchLocationEvent;
import com.dmap.navigation.engine.event.MissionEvent;
import com.dmap.navigation.engine.event.MoreRouteEvent;
import com.dmap.navigation.engine.event.NaviEvent;
import com.dmap.navigation.engine.event.ParallelRoadEvent;
import com.dmap.navigation.engine.event.PassPointVerifyEvent;
import com.dmap.navigation.engine.event.QRPayEvent;
import com.dmap.navigation.engine.event.RoutesEvent;
import com.dmap.navigation.engine.event.SlopeInfoEvent;
import com.dmap.navigation.engine.event.SpeedIconEvent;
import com.dmap.navigation.engine.event.ToastTextEvent;
import com.dmap.navigation.engine.event.VDRInfoEvent;
import com.dmap.navigation.engine.event.VecEnlargeMapEvent;
import com.dmap.navigation.engine.event.VoiceEvent;
import com.dmap.navigation.engine.event.YawEvent;
import com.dmap.navigation.engine.simple.SimpleMatchRouteInfo;
import com.dmap.navigation.jni.sub.NaviLatLngNative;
import com.dmap.navigation.jni.sub.NaviLocationNative;
import com.dmap.navigation.jni.sub.NaviRouteNative;
import com.dmap.navigation.jni.sub.TrafficEventPointNative;
import com.dmap.navigation.jni.swig.AnalysisLogList;
import com.dmap.navigation.jni.swig.BindNaviLocation;
import com.dmap.navigation.jni.swig.GpsHealthInfo;
import com.dmap.navigation.jni.swig.LongList;
import com.dmap.navigation.jni.swig.MissionButtonList;
import com.dmap.navigation.jni.swig.NaviBusinessBridge;
import com.dmap.navigation.jni.swig.NaviCameraList;
import com.dmap.navigation.jni.swig.NaviEngine;
import com.dmap.navigation.jni.swig.NaviEventCallback;
import com.dmap.navigation.jni.swig.NaviGetter;
import com.dmap.navigation.jni.swig.NaviLatLng;
import com.dmap.navigation.jni.swig.NaviLocation;
import com.dmap.navigation.jni.swig.NaviOption;
import com.dmap.navigation.jni.swig.NaviRoute;
import com.dmap.navigation.jni.swig.OrderInfo;
import com.dmap.navigation.jni.swig.SWIGTYPE_p_unsigned_char;
import com.dmap.navigation.jni.swig.SafeNotifyInfo;
import com.dmap.navigation.jni.swig.StringList;
import com.dmap.navigation.jni.swig.TrafficEventPointList;
import com.dmap.navigation.jni.swig.UserInfo;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.dmap.navigation.engine.a.o */
/* compiled from: NaviEngineImpl */
public final class C18182o implements INaviEngine {

    /* renamed from: a */
    private final NaviEngine f54377a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final INaviContext f54378b;

    /* renamed from: c */
    private final LruCache<BigInteger, IRoute> f54379c;

    /* renamed from: d */
    private INaviEventListener f54380d;

    /* renamed from: e */
    private boolean f54381e = false;

    /* renamed from: f */
    private final NaviGetter f54382f = new NaviGetter() {
        public final String getTextByKey(String str) {
            int identifier = C18182o.this.f54378b.getAndroidContext().getResources().getIdentifier(str, TypedValues.Custom.S_STRING, C18182o.this.f54378b.getAndroidContext().getPackageName());
            return identifier > 0 ? C18182o.this.f54378b.getAndroidContext().getResources().getString(identifier) : "";
        }
    };

    /* renamed from: g */
    private final NaviEventCallback f54383g = new NaviEventCallback() {
        public final void onMatchLocationEvent(BigInteger bigInteger, NaviLocation naviLocation, int i, int i2, double d, int i3) {
            C18182o.m40470a(C18182o.this, new MatchLocationEvent(bigInteger, naviLocation, i, i2, d, i3));
        }

        public final void onVoiceEvent(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            C18182o.m40470a(C18182o.this, new VoiceEvent(str, str2, i, i2, i3, i4, i5, i6, i7));
        }

        public final void onArrivedEvent(boolean z, NaviLatLng naviLatLng, NaviLatLng naviLatLng2, NaviLatLng naviLatLng3, int i, int i2) {
            C18182o.m40470a(C18182o.this, new ArriveEvent(z, naviLatLng, naviLatLng2, naviLatLng3, i, i2));
        }

        public final void onDownloadEvent(StringList stringList) {
            C18182o.m40470a(C18182o.this, new DownloadEvent(stringList));
        }

        public final void onDownloadVecEvent(String str, String str2, SWIGTYPE_p_unsigned_char sWIGTYPE_p_unsigned_char, int i) {
            C18182o.m40470a(C18182o.this, new DownloadVecEvent(str, str2, C18180m.m40466a(sWIGTYPE_p_unsigned_char, i)));
        }

        public final void onDownloadMJOEvent(long j, String str, String str2, String str3) {
            C18182o.m40470a(C18182o.this, new DownloadMJOEvent(j, str, str2, str3));
        }

        public final void onMissionEvent(long j, int i, String str, String str2, NaviLatLng naviLatLng, SWIGTYPE_p_unsigned_char sWIGTYPE_p_unsigned_char, int i2, BigInteger bigInteger, MissionButtonList missionButtonList, int i3, String str3) {
            C18182o.m40470a(C18182o.this, new MissionEvent(j, i, str, str2, naviLatLng, C18180m.m40466a(sWIGTYPE_p_unsigned_char, i2), bigInteger, missionButtonList, i3, str3));
        }

        public final void onAnalysisEvent(String str, AnalysisLogList analysisLogList) {
            C18182o.m40470a(C18182o.this, new AnalysisEvent(str, analysisLogList));
        }

        public final void onCameraEvent(int i, NaviCameraList naviCameraList, int i2) {
            C18182o.m40470a(C18182o.this, new CameraEvent(i, naviCameraList, i2));
        }

        public final void onCongestionEvent(int i, int i2, int i3, int i4, int i5, int i6) {
            C18182o.m40470a(C18182o.this, new CongestionEvent(i, i2, i3, i4, i5, i6));
        }

        public final void onDestinationEvent(int i, int i2, int i3, int i4, int i5) {
            C18182o.m40470a(C18182o.this, new DestinationEvent(i, i2, i3, i4, i5));
        }

        public final void onEnlargeMapEvent(int i, String str, String str2) {
            C18182o.m40470a(C18182o.this, new EnlargeMapEvent(i, str, str2));
        }

        public final void onIllegalParkEvent(int i, int i2, int i3, String str, String str2, NaviLatLng naviLatLng, NaviLatLng naviLatLng2) {
            C18182o.m40470a(C18182o.this, new IllegalParkEvent(i, i2, i3, str, str2, naviLatLng, naviLatLng2));
        }

        public final void onIntersectionEvent(int i, String str, String str2, int i2, int i3, int i4, NaviLatLng naviLatLng, int i5, int i6, String str3, boolean z, int i7) {
            C18182o.m40470a(C18182o.this, new IntersectionEvent(i, str, str2, i2, i3, i4, naviLatLng, i5, i6, str3, z, i7));
        }

        public final void onLaneEvent(int i, String str, String str2, String str3, int i2, int i3, BigInteger bigInteger, NaviLatLng naviLatLng, int i4) {
            C18182o.m40470a(C18182o.this, new LaneEvent(i, str, str2, str3, i2, i3, bigInteger, naviLatLng, i4));
        }

        public final void onLimitSpeedCameraEvent(int i, int i2, int i3, NaviLatLng naviLatLng, String str) {
            C18182o.m40470a(C18182o.this, new LimitSpeedCameraEvent(i, i2, i3, naviLatLng, str));
        }

        public final void onMJOEvent(int i, long j, String str, BigInteger bigInteger) {
            C18182o.m40470a(C18182o.this, new MJOPrepareEvent(i, j, str, bigInteger));
        }

        public final void onMoreRouteEvent(int i, String str) {
            C18182o.m40470a(C18182o.this, new MoreRouteEvent(i, str));
        }

        public final void onParallelRoadEvent(int i, int i2) {
            C18182o.m40470a(C18182o.this, new ParallelRoadEvent(i, i2));
        }

        public final void onPassPointVerifyEvent(int i) {
            C18182o.m40470a(C18182o.this, new PassPointVerifyEvent(i));
        }

        public final void onQRPayEvent(int i, BigInteger bigInteger) {
            C18182o.m40470a(C18182o.this, new QRPayEvent(i, bigInteger));
        }

        public final void onRoutesEvent(LongList longList, int i) {
            C18182o oVar = C18182o.this;
            C18182o.m40470a(oVar, new RoutesEvent(longList, oVar.getCurrentRouteId(), i));
        }

        public final void onSlopeInfoEvent(int i) {
            C18182o.m40470a(C18182o.this, new SlopeInfoEvent(i));
        }

        public final void onSpeedIconEvent(int i, int i2, int i3, int i4, int i5, float f, int i6) {
            C18182o.m40470a(C18182o.this, new SpeedIconEvent(i, i2, i3, i4, i5, f, i6));
        }

        public final void onVDRInfoEvent(BigInteger bigInteger, double d, double d2, float f, int i, int i2) {
            C18182o.m40470a(C18182o.this, new VDRInfoEvent(bigInteger, d, d2, f, i, i2));
        }

        public final void onVecEnlargeMapEvent(int i, String str, String str2) {
            C18182o.m40470a(C18182o.this, new VecEnlargeMapEvent(i, str, str2));
        }

        public final void onYawEvent(BindNaviLocation bindNaviLocation, int i, int i2) {
            C18182o.m40470a(C18182o.this, new YawEvent(bindNaviLocation, bindNaviLocation.getIndex(), i, i2));
        }

        public final void onToastText(int i, String str) {
            C18182o.m40470a(C18182o.this, new ToastTextEvent(i, str));
        }
    };

    public C18182o(INaviContext iNaviContext) {
        this.f54378b = iNaviContext;
        this.f54379c = new LruCache<>(NaviBusinessBridge.getMAX_ROUTES_COUNT());
        this.f54377a = new NaviEngine(this.f54383g, this.f54382f);
    }

    public final void init() {
        this.f54377a.init((UserInfo) this.f54378b.getUserInfo(), (OrderInfo) this.f54378b.getOrderInfo(), (NaviOption) this.f54378b.getNaviOption());
    }

    public final void startNavi(IRoute iRoute, INaviLocation iNaviLocation) {
        HWLog.m20433i("navi_engine", "startNavi = " + iRoute.getRouteId() + " location = " + iNaviLocation + "isRun = " + this.f54381e);
        this.f54381e = true;
        this.f54377a.startNavi(new NaviRouteNative((IRouteEx) iRoute), new NaviLocationNative(iNaviLocation));
    }

    public final void stopNavi() {
        HWLog.m20433i("navi_engine", "stopNavi isRun = " + this.f54381e);
        if (this.f54381e) {
            this.f54381e = false;
            this.f54377a.stopNavi();
        }
    }

    public final void setNaviEventListener(INaviEventListener iNaviEventListener) {
        this.f54380d = iNaviEventListener;
    }

    public final void selectRoute(BigInteger bigInteger, boolean z) {
        HWLog.m20433i("navi_engine", "selectRoute = " + bigInteger.toString());
        this.f54377a.selectRoute(bigInteger, z);
    }

    public final void updateLocation(INaviLocation iNaviLocation) {
        HWLog.m20433i("navi_engine", "updateLocation = ".concat(String.valueOf(iNaviLocation)));
        this.f54377a.updateLocation(new NaviLocationNative(iNaviLocation));
    }

    public final BigInteger getCurrentRouteId() {
        return this.f54377a.getCurrentRouteId();
    }

    public final IRoute getRouteById(BigInteger bigInteger) {
        NaviRoute routeById;
        IRoute iRoute = this.f54379c.get(bigInteger);
        if (iRoute != null || (routeById = this.f54377a.getRouteById(bigInteger)) == null) {
            return iRoute;
        }
        C18174g gVar = new C18174g(routeById);
        this.f54379c.put(bigInteger, gVar);
        return gVar;
    }

    public final void addMoreRoutes(List<IRoute> list) {
        if (list != null && list.size() > 0) {
            this.f54377a.addMoreRoutes(((IRouteEx) list.get(0)).getPbHandle());
        }
    }

    public final void updateTrafficStatus(byte[] bArr) {
        if (this.f54381e) {
            if (bArr != null) {
                HWLog.m20433i("nv_t", "updateTrafficStatus = " + bArr.length);
                this.f54377a.updateTrafficStatus(bArr, bArr.length, (int) (System.currentTimeMillis() / 1000));
                return;
            }
            HWLog.m20433i("nv_t", "updateTrafficStatus pbdata == null");
        }
    }

    public final void updateTrafficEtas(int i, int[] iArr) {
        if (this.f54381e) {
            HWLog.m20433i("nv_t", "updateTrafficEtas = " + i + " , " + Arrays.toString(iArr));
            this.f54377a.updateTrafficEtas(i, iArr);
        }
    }

    public final void forcePassedNext() {
        this.f54377a.forcePassedNext();
    }

    public final void playMannalVoice() {
        this.f54377a.playMannalVoice();
    }

    public final void playOpenningVoice(INaviLocation iNaviLocation) {
        this.f54377a.playOpenningVoice(new NaviLocationNative(iNaviLocation));
    }

    public final void updateAppAction(int i) {
        this.f54377a.updateAppAction(i);
    }

    public final String getNGVoiceContent(int i) {
        return this.f54377a.getNGVoiceContent(i);
    }

    public final void setTrafficEventPoints(BigInteger bigInteger, List<TrafficEventRoutePoint> list) {
        TrafficEventPointList trafficEventPointList = new TrafficEventPointList();
        for (int i = 0; i < list.size(); i++) {
            trafficEventPointList.add(new TrafficEventPointNative(list.get(i)));
        }
        this.f54377a.setTrafficEventPoints(bigInteger, trafficEventPointList);
    }

    public final void changeNaviStutas(int i) {
        this.f54377a.changeNaviModel(i);
    }

    public final void setDayNight(boolean z) {
        this.f54377a.setDayNight(z);
    }

    public final Map<String, Long> getGpsHealthInfo() {
        GpsHealthInfo gpsHealthInfo = this.f54377a.getGpsHealthInfo();
        HashMap hashMap = new HashMap();
        hashMap.put("all_gps", Long.valueOf(gpsHealthInfo.getAll_gps().longValue()));
        hashMap.put("angle_gps", Long.valueOf(gpsHealthInfo.getAngle_gps().longValue()));
        hashMap.put("av_gps", Long.valueOf(gpsHealthInfo.getAv_gps().longValue()));
        hashMap.put("point_back", Long.valueOf(gpsHealthInfo.getBack_gps().longValue()));
        hashMap.put("no_gps", Long.valueOf(gpsHealthInfo.getNo_gps().longValue()));
        return hashMap;
    }

    public final void setVoiceAssistantState(int i) {
        this.f54377a.setVoiceAssistantState(i);
    }

    public final void closeCurrentMJO() {
        this.f54377a.closeCurrentMJO();
    }

    public final void setMJOEnable(boolean z) {
        this.f54377a.setMJOEnable(z);
    }

    public final void updateNaviScene() {
        this.f54377a.updateNaviScene();
    }

    public final void naviPushData(int i, String str) {
        if (i == 1) {
            SafeNotifyInfo safeNotifyInfo = new SafeNotifyInfo();
            try {
                JSONObject jSONObject = new JSONObject(str);
                safeNotifyInfo.setTtsContent(jSONObject.getString("text"));
                JSONObject jSONObject2 = jSONObject.getJSONObject("extra_info");
                safeNotifyInfo.setGeoPoint(new NaviLatLngNative(jSONObject2.getDouble(Const.PageParams.LATITUDE), jSONObject2.getDouble(Const.PageParams.LONGITUDE)));
                safeNotifyInfo.setAiUsedSpeed((float) jSONObject2.getDouble("speed"));
                safeNotifyInfo.setLimitSpeed(jSONObject2.getInt("speed_lmt"));
                safeNotifyInfo.setLinkId(BigInteger.valueOf(jSONObject2.getLong("link_id")));
                safeNotifyInfo.setInterveneType(jSONObject2.getInt("action_level"));
                safeNotifyInfo.setMapVersion(jSONObject2.getString("map_version"));
                safeNotifyInfo.setTimestamp(jSONObject2.getInt("strategy_ready_timestamp"));
                this.f54377a.addSafeNotifyInfo(safeNotifyInfo);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public final IMatchRouteInfo getMatchRouteInfo() {
        return new SimpleMatchRouteInfo(this.f54377a.getMatchedRouteInfo());
    }

    public final void setVecEnlargeInfo(int i, int i2) {
        this.f54377a.setVecEnlargeInfo(i, i2);
    }

    /* renamed from: a */
    static /* synthetic */ void m40470a(C18182o oVar, NaviEvent naviEvent) {
        if (oVar.f54380d != null) {
            HWLog.m20433i("nv_event", naviEvent.toString());
            oVar.f54380d.onEvent(naviEvent);
        }
    }
}
