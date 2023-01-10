package com.didi.map.global.component.line.pax.dropoffline;

import android.graphics.Color;
import com.didi.common.map.model.LatLng;
import com.didichuxing.routesearchsdk.CallFrom;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001a\u0010\u001e\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001c\u0010!\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000e¨\u0006$"}, mo148868d2 = {"Lcom/didi/map/global/component/line/pax/dropoffline/SingleWalkLineParam;", "", "()V", "caller", "Lcom/didichuxing/routesearchsdk/CallFrom;", "getCaller", "()Lcom/didichuxing/routesearchsdk/CallFrom;", "setCaller", "(Lcom/didichuxing/routesearchsdk/CallFrom;)V", "endPos", "Lcom/didi/common/map/model/LatLng;", "getEndPos", "()Lcom/didi/common/map/model/LatLng;", "setEndPos", "(Lcom/didi/common/map/model/LatLng;)V", "lineAColor", "", "getLineAColor", "()I", "setLineAColor", "(I)V", "lineASpace", "", "getLineASpace", "()F", "setLineASpace", "(F)V", "lineAWidth", "getLineAWidth", "setLineAWidth", "lineBSpace", "getLineBSpace", "setLineBSpace", "startPos", "getStartPos", "setStartPos", "compLine_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SingleWalkLineParam.kt */
public final class SingleWalkLineParam {

    /* renamed from: a */
    private LatLng f28142a;

    /* renamed from: b */
    private LatLng f28143b;

    /* renamed from: c */
    private CallFrom f28144c;

    /* renamed from: d */
    private float f28145d = 5.0f;

    /* renamed from: e */
    private int f28146e = 4;

    /* renamed from: f */
    private float f28147f = 5.0f;

    /* renamed from: g */
    private int f28148g = Color.parseColor("#000000");

    public final LatLng getStartPos() {
        return this.f28142a;
    }

    public final void setStartPos(LatLng latLng) {
        this.f28142a = latLng;
    }

    public final LatLng getEndPos() {
        return this.f28143b;
    }

    public final void setEndPos(LatLng latLng) {
        this.f28143b = latLng;
    }

    public final CallFrom getCaller() {
        return this.f28144c;
    }

    public final void setCaller(CallFrom callFrom) {
        this.f28144c = callFrom;
    }

    public final float getLineBSpace() {
        return this.f28145d;
    }

    public final void setLineBSpace(float f) {
        this.f28145d = f;
    }

    public final int getLineAWidth() {
        return this.f28146e;
    }

    public final void setLineAWidth(int i) {
        this.f28146e = i;
    }

    public final float getLineASpace() {
        return this.f28147f;
    }

    public final void setLineASpace(float f) {
        this.f28147f = f;
    }

    public final int getLineAColor() {
        return this.f28148g;
    }

    public final void setLineAColor(int i) {
        this.f28148g = i;
    }
}
