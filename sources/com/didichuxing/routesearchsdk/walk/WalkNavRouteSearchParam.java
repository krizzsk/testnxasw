package com.didichuxing.routesearchsdk.walk;

import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.VisitorInfo;
import com.didi.map.sdk.proto.driver_gl.WalkScene;
import com.didi.map.sdk.proto.driver_gl.WalkState;
import com.didichuxing.routesearchsdk.CallFrom;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001TB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010R\u001a\u0004\u0018\u00010\u001aJ\b\u0010S\u001a\u00020\u001aH\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b)\u0010\b\"\u0004\b*\u0010\nR\u001c\u0010+\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001c\"\u0004\b-\u0010\u001eR\u001e\u0010.\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b/\u0010\u0015\"\u0004\b0\u0010\u0017R\u001c\u00101\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010%\"\u0004\b3\u0010'R\u001e\u00104\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b5\u0010\b\"\u0004\b6\u0010\nR\u001c\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010=\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001c\"\u0004\b?\u0010\u001eR\u001c\u0010@\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010%\"\u0004\bB\u0010'R\u001c\u0010C\u001a\u0004\u0018\u00010DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001e\u0010I\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\bJ\u0010\b\"\u0004\bK\u0010\nR\u001c\u0010L\u001a\u0004\u0018\u00010MX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010Q¨\u0006U"}, mo148868d2 = {"Lcom/didichuxing/routesearchsdk/walk/WalkNavRouteSearchParam;", "", "builder", "Lcom/didichuxing/routesearchsdk/walk/WalkNavRouteSearchParam$Builder;", "(Lcom/didichuxing/routesearchsdk/walk/WalkNavRouteSearchParam$Builder;)V", "bizType", "", "getBizType", "()Ljava/lang/Integer;", "setBizType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "caller", "Lcom/didichuxing/routesearchsdk/CallFrom;", "getCaller", "()Lcom/didichuxing/routesearchsdk/CallFrom;", "setCaller", "(Lcom/didichuxing/routesearchsdk/CallFrom;)V", "curRouteId", "", "getCurRouteId", "()Ljava/lang/Long;", "setCurRouteId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "didiVersion", "", "getDidiVersion", "()Ljava/lang/String;", "setDidiVersion", "(Ljava/lang/String;)V", "driverId", "getDriverId", "setDriverId", "endPoint", "Lcom/didi/map/sdk/proto/driver_gl/DoublePoint;", "getEndPoint", "()Lcom/didi/map/sdk/proto/driver_gl/DoublePoint;", "setEndPoint", "(Lcom/didi/map/sdk/proto/driver_gl/DoublePoint;)V", "eventType", "getEventType", "setEventType", "orderId", "getOrderId", "setOrderId", "passengerID", "getPassengerID", "setPassengerID", "psgPos", "getPsgPos", "setPsgPos", "role", "getRole", "setRole", "scene", "Lcom/didi/map/sdk/proto/driver_gl/WalkScene;", "getScene", "()Lcom/didi/map/sdk/proto/driver_gl/WalkScene;", "setScene", "(Lcom/didi/map/sdk/proto/driver_gl/WalkScene;)V", "sdkMapType", "getSdkMapType", "setSdkMapType", "startPoint", "getStartPoint", "setStartPoint", "state", "Lcom/didi/map/sdk/proto/driver_gl/WalkState;", "getState", "()Lcom/didi/map/sdk/proto/driver_gl/WalkState;", "setState", "(Lcom/didi/map/sdk/proto/driver_gl/WalkState;)V", "type", "getType", "setType", "visitorInfo", "Lcom/didi/map/sdk/proto/driver_gl/VisitorInfo;", "getVisitorInfo", "()Lcom/didi/map/sdk/proto/driver_gl/VisitorInfo;", "setVisitorInfo", "(Lcom/didi/map/sdk/proto/driver_gl/VisitorInfo;)V", "checkParam", "toString", "Builder", "RouteSearchSDK_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalkNavRouteSearchParam.kt */
public final class WalkNavRouteSearchParam {

    /* renamed from: a */
    private VisitorInfo f51134a;

    /* renamed from: b */
    private Long f51135b;

    /* renamed from: c */
    private Integer f51136c;

    /* renamed from: d */
    private DoublePoint f51137d;

    /* renamed from: e */
    private DoublePoint f51138e;

    /* renamed from: f */
    private DoublePoint f51139f;

    /* renamed from: g */
    private Integer f51140g;

    /* renamed from: h */
    private Integer f51141h;

    /* renamed from: i */
    private Long f51142i;

    /* renamed from: j */
    private String f51143j;

    /* renamed from: k */
    private Integer f51144k;

    /* renamed from: l */
    private Long f51145l;

    /* renamed from: m */
    private WalkState f51146m;

    /* renamed from: n */
    private WalkScene f51147n;

    /* renamed from: o */
    private String f51148o;

    /* renamed from: p */
    private CallFrom f51149p;

    /* renamed from: q */
    private String f51150q;

    public final String checkParam() {
        return null;
    }

    public final VisitorInfo getVisitorInfo() {
        return this.f51134a;
    }

    public final void setVisitorInfo(VisitorInfo visitorInfo) {
        this.f51134a = visitorInfo;
    }

    public final Long getPassengerID() {
        return this.f51135b;
    }

    public final void setPassengerID(Long l) {
        this.f51135b = l;
    }

    public final Integer getBizType() {
        return this.f51136c;
    }

    public final void setBizType(Integer num) {
        this.f51136c = num;
    }

    public final DoublePoint getStartPoint() {
        return this.f51137d;
    }

    public final void setStartPoint(DoublePoint doublePoint) {
        this.f51137d = doublePoint;
    }

    public final DoublePoint getEndPoint() {
        return this.f51138e;
    }

    public final void setEndPoint(DoublePoint doublePoint) {
        this.f51138e = doublePoint;
    }

    public final DoublePoint getPsgPos() {
        return this.f51139f;
    }

    public final void setPsgPos(DoublePoint doublePoint) {
        this.f51139f = doublePoint;
    }

    public final Integer getRole() {
        return this.f51140g;
    }

    public final void setRole(Integer num) {
        this.f51140g = num;
    }

    public final Integer getType() {
        return this.f51141h;
    }

    public final void setType(Integer num) {
        this.f51141h = num;
    }

    public final Long getDriverId() {
        return this.f51142i;
    }

    public final void setDriverId(Long l) {
        this.f51142i = l;
    }

    public final String getOrderId() {
        return this.f51143j;
    }

    public final void setOrderId(String str) {
        this.f51143j = str;
    }

    public final Integer getEventType() {
        return this.f51144k;
    }

    public final void setEventType(Integer num) {
        this.f51144k = num;
    }

    public final Long getCurRouteId() {
        return this.f51145l;
    }

    public final void setCurRouteId(Long l) {
        this.f51145l = l;
    }

    public final WalkState getState() {
        return this.f51146m;
    }

    public final void setState(WalkState walkState) {
        this.f51146m = walkState;
    }

    public final WalkScene getScene() {
        return this.f51147n;
    }

    public final void setScene(WalkScene walkScene) {
        this.f51147n = walkScene;
    }

    public final String getSdkMapType() {
        return this.f51148o;
    }

    public final void setSdkMapType(String str) {
        this.f51148o = str;
    }

    public final CallFrom getCaller() {
        return this.f51149p;
    }

    public final void setCaller(CallFrom callFrom) {
        this.f51149p = callFrom;
    }

    public final String getDidiVersion() {
        return this.f51150q;
    }

    public final void setDidiVersion(String str) {
        this.f51150q = str;
    }

    public WalkNavRouteSearchParam(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f51134a = builder.getVisitorInfo();
        this.f51139f = builder.getPsgPos();
        this.f51135b = builder.getPassengerId();
        this.f51136c = builder.getBizType();
        this.f51140g = builder.getRole();
        this.f51141h = builder.getType();
        this.f51143j = builder.getOrderId();
        this.f51142i = builder.getDriverId();
        this.f51144k = builder.getEventType();
        this.f51145l = builder.getCurRouteId();
        this.f51146m = builder.getState();
        this.f51147n = builder.getScene();
        this.f51137d = builder.getStartPoint();
        this.f51138e = builder.getEndPoint();
        this.f51148o = builder.getSdkMapType();
        this.f51150q = builder.getDidiVersion();
        this.f51149p = builder.getCaller();
    }

    public String toString() {
        return "WalkNavRouteSearchParam(visitorInfo=" + this.f51134a + ", passengerID=" + this.f51135b + ", bizType=" + this.f51136c + ", startPoint=" + this.f51137d + ", endPoint=" + this.f51138e + ", psgPos=" + this.f51139f + ", role=" + this.f51140g + ", type=" + this.f51141h + ", driverId=" + this.f51142i + ", orderId=" + this.f51143j + ", eventType=" + this.f51144k + ", curRouteId=" + this.f51145l + ", state=" + this.f51146m + ", scene=" + this.f51147n + ", sdkMapType=" + this.f51148o + ", caller=" + this.f51149p + ", didiVersion=" + this.f51150q + VersionRange.RIGHT_OPEN;
    }

    @Metadata(mo148867d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010P\u001a\u00020QJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0011J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020!J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0004J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0018J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010R\u001a\u00020\u0011J\u000e\u0010S\u001a\u00020\u00002\u0006\u0010T\u001a\u00020!J\u000e\u00102\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0004J\u000e\u00105\u001a\u00020\u00002\u0006\u00105\u001a\u000206J\u000e\u0010;\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u0018J\u000e\u0010>\u001a\u00020\u00002\u0006\u0010>\u001a\u00020!J\u000e\u0010A\u001a\u00020\u00002\u0006\u0010A\u001a\u00020BJ\u000e\u0010G\u001a\u00020\u00002\u0006\u0010G\u001a\u00020\u0004J\u000e\u0010J\u001a\u00020\u00002\u0006\u0010J\u001a\u00020KR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR\u001c\u0010)\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR\u001e\u0010,\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0015R\u001c\u0010/\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010#\"\u0004\b1\u0010%R\u001e\u00102\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR\u001c\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001a\"\u0004\b=\u0010\u001cR\u001c\u0010>\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010#\"\u0004\b@\u0010%R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001e\u0010G\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\bH\u0010\u0006\"\u0004\bI\u0010\bR\u001c\u0010J\u001a\u0004\u0018\u00010KX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010O¨\u0006U"}, mo148868d2 = {"Lcom/didichuxing/routesearchsdk/walk/WalkNavRouteSearchParam$Builder;", "", "()V", "bizType", "", "getBizType", "()Ljava/lang/Integer;", "setBizType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "caller", "Lcom/didichuxing/routesearchsdk/CallFrom;", "getCaller", "()Lcom/didichuxing/routesearchsdk/CallFrom;", "setCaller", "(Lcom/didichuxing/routesearchsdk/CallFrom;)V", "curRouteId", "", "getCurRouteId", "()Ljava/lang/Long;", "setCurRouteId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "didiVersion", "", "getDidiVersion", "()Ljava/lang/String;", "setDidiVersion", "(Ljava/lang/String;)V", "driverId", "getDriverId", "setDriverId", "endPoint", "Lcom/didi/map/sdk/proto/driver_gl/DoublePoint;", "getEndPoint", "()Lcom/didi/map/sdk/proto/driver_gl/DoublePoint;", "setEndPoint", "(Lcom/didi/map/sdk/proto/driver_gl/DoublePoint;)V", "eventType", "getEventType", "setEventType", "orderId", "getOrderId", "setOrderId", "passengerId", "getPassengerId", "setPassengerId", "psgPos", "getPsgPos", "setPsgPos", "role", "getRole", "setRole", "scene", "Lcom/didi/map/sdk/proto/driver_gl/WalkScene;", "getScene", "()Lcom/didi/map/sdk/proto/driver_gl/WalkScene;", "setScene", "(Lcom/didi/map/sdk/proto/driver_gl/WalkScene;)V", "sdkMapType", "getSdkMapType", "setSdkMapType", "startPoint", "getStartPoint", "setStartPoint", "state", "Lcom/didi/map/sdk/proto/driver_gl/WalkState;", "getState", "()Lcom/didi/map/sdk/proto/driver_gl/WalkState;", "setState", "(Lcom/didi/map/sdk/proto/driver_gl/WalkState;)V", "type", "getType", "setType", "visitorInfo", "Lcom/didi/map/sdk/proto/driver_gl/VisitorInfo;", "getVisitorInfo", "()Lcom/didi/map/sdk/proto/driver_gl/VisitorInfo;", "setVisitorInfo", "(Lcom/didi/map/sdk/proto/driver_gl/VisitorInfo;)V", "build", "Lcom/didichuxing/routesearchsdk/walk/WalkNavRouteSearchParam;", "passengerID", "psgPoint", "psg", "RouteSearchSDK_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: WalkNavRouteSearchParam.kt */
    public static final class Builder {
        private Integer bizType;
        private CallFrom caller;
        private Long curRouteId;
        private String didiVersion;
        private Long driverId;
        private DoublePoint endPoint;
        private Integer eventType;
        private String orderId;
        private Long passengerId;
        private DoublePoint psgPos;
        private Integer role;
        private WalkScene scene;
        private String sdkMapType;
        private DoublePoint startPoint;
        private WalkState state;
        private Integer type;
        private VisitorInfo visitorInfo;

        public final VisitorInfo getVisitorInfo() {
            return this.visitorInfo;
        }

        public final void setVisitorInfo(VisitorInfo visitorInfo2) {
            this.visitorInfo = visitorInfo2;
        }

        public final Long getPassengerId() {
            return this.passengerId;
        }

        public final void setPassengerId(Long l) {
            this.passengerId = l;
        }

        public final Integer getBizType() {
            return this.bizType;
        }

        public final void setBizType(Integer num) {
            this.bizType = num;
        }

        public final DoublePoint getStartPoint() {
            return this.startPoint;
        }

        public final void setStartPoint(DoublePoint doublePoint) {
            this.startPoint = doublePoint;
        }

        public final DoublePoint getEndPoint() {
            return this.endPoint;
        }

        public final void setEndPoint(DoublePoint doublePoint) {
            this.endPoint = doublePoint;
        }

        public final DoublePoint getPsgPos() {
            return this.psgPos;
        }

        public final void setPsgPos(DoublePoint doublePoint) {
            this.psgPos = doublePoint;
        }

        public final Integer getRole() {
            return this.role;
        }

        public final void setRole(Integer num) {
            this.role = num;
        }

        public final Integer getType() {
            return this.type;
        }

        public final void setType(Integer num) {
            this.type = num;
        }

        public final Long getDriverId() {
            return this.driverId;
        }

        public final void setDriverId(Long l) {
            this.driverId = l;
        }

        public final String getOrderId() {
            return this.orderId;
        }

        public final void setOrderId(String str) {
            this.orderId = str;
        }

        public final Integer getEventType() {
            return this.eventType;
        }

        public final void setEventType(Integer num) {
            this.eventType = num;
        }

        public final Long getCurRouteId() {
            return this.curRouteId;
        }

        public final void setCurRouteId(Long l) {
            this.curRouteId = l;
        }

        public final WalkState getState() {
            return this.state;
        }

        public final void setState(WalkState walkState) {
            this.state = walkState;
        }

        public final WalkScene getScene() {
            return this.scene;
        }

        public final void setScene(WalkScene walkScene) {
            this.scene = walkScene;
        }

        public final String getSdkMapType() {
            return this.sdkMapType;
        }

        public final void setSdkMapType(String str) {
            this.sdkMapType = str;
        }

        public final CallFrom getCaller() {
            return this.caller;
        }

        public final void setCaller(CallFrom callFrom) {
            this.caller = callFrom;
        }

        public final String getDidiVersion() {
            return this.didiVersion;
        }

        public final void setDidiVersion(String str) {
            this.didiVersion = str;
        }

        public final Builder role(int i) {
            this.role = Integer.valueOf(i);
            return this;
        }

        public final Builder sdkMapType(String str) {
            Intrinsics.checkNotNullParameter(str, "sdkMapType");
            this.sdkMapType = str;
            return this;
        }

        public final Builder caller(CallFrom callFrom) {
            Intrinsics.checkNotNullParameter(callFrom, "caller");
            this.caller = callFrom;
            return this;
        }

        public final Builder didiVersion(String str) {
            Intrinsics.checkNotNullParameter(str, "didiVersion");
            this.didiVersion = str;
            return this;
        }

        public final Builder state(WalkState walkState) {
            Intrinsics.checkNotNullParameter(walkState, "state");
            this.state = walkState;
            return this;
        }

        public final Builder scene(WalkScene walkScene) {
            Intrinsics.checkNotNullParameter(walkScene, "scene");
            this.scene = walkScene;
            return this;
        }

        public final Builder curRouteId(long j) {
            this.curRouteId = Long.valueOf(j);
            return this;
        }

        public final Builder eventType(int i) {
            this.eventType = Integer.valueOf(i);
            return this;
        }

        public final Builder type(int i) {
            this.type = Integer.valueOf(i);
            return this;
        }

        public final Builder orderId(String str) {
            Intrinsics.checkNotNullParameter(str, "orderId");
            this.orderId = str;
            return this;
        }

        public final Builder driverId(long j) {
            this.driverId = Long.valueOf(j);
            return this;
        }

        public final Builder visitorInfo(VisitorInfo visitorInfo2) {
            Intrinsics.checkNotNullParameter(visitorInfo2, "visitorInfo");
            this.visitorInfo = visitorInfo2;
            return this;
        }

        public final Builder passengerId(long j) {
            this.passengerId = Long.valueOf(j);
            return this;
        }

        public final Builder bizType(int i) {
            this.bizType = Integer.valueOf(i);
            return this;
        }

        public final Builder startPoint(DoublePoint doublePoint) {
            Intrinsics.checkNotNullParameter(doublePoint, "startPoint");
            this.startPoint = doublePoint;
            return this;
        }

        public final Builder endPoint(DoublePoint doublePoint) {
            Intrinsics.checkNotNullParameter(doublePoint, "endPoint");
            this.endPoint = doublePoint;
            return this;
        }

        public final Builder psgPoint(DoublePoint doublePoint) {
            Intrinsics.checkNotNullParameter(doublePoint, "psg");
            this.psgPos = doublePoint;
            return this;
        }

        public final WalkNavRouteSearchParam build() {
            return new WalkNavRouteSearchParam(this);
        }
    }
}
