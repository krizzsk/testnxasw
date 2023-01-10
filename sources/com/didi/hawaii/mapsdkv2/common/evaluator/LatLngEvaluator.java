package com.didi.hawaii.mapsdkv2.common.evaluator;

import android.animation.TypeEvaluator;
import com.didi.hawaii.mapsdkv2.jni.NativeSpeedUp;
import com.didi.map.outer.model.LatLng;

public class LatLngEvaluator implements TypeEvaluator<LatLng> {

    /* renamed from: a */
    private LatLng f26053a;

    public LatLng evaluate(float f, LatLng latLng, LatLng latLng2) {
        double doubleEvaluateNative = NativeSpeedUp.doubleEvaluateNative(latLng.longitude, latLng2.longitude, f);
        double doubleEvaluateNative2 = NativeSpeedUp.doubleEvaluateNative(latLng.latitude, latLng2.latitude, f);
        LatLng latLng3 = this.f26053a;
        if (latLng3 != null) {
            latLng3.longitude = doubleEvaluateNative;
            this.f26053a.latitude = doubleEvaluateNative2;
        } else {
            this.f26053a = new LatLng(doubleEvaluateNative2, doubleEvaluateNative);
        }
        return this.f26053a;
    }
}
