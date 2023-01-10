package com.iproov.sdk.core;

import com.didi.soda.customer.p165h5.hybird.model.GuideParamModel;
import com.google.firebase.abt.FirebaseABTesting;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p095switch.C3682while;

/* renamed from: com.iproov.sdk.core.final */
/* compiled from: LivenessParameters */
public class C20870final {

    /* renamed from: a */
    private final double f57087a;

    /* renamed from: b */
    private final int f57088b;

    /* renamed from: c */
    private final double f57089c;

    /* renamed from: d */
    private final double f57090d;

    /* renamed from: e */
    private final double[] f57091e;

    /* renamed from: f */
    private final double f57092f;

    /* renamed from: g */
    private final double f57093g;

    /* renamed from: h */
    private final double f57094h;

    /* renamed from: i */
    private final double f57095i;

    /* renamed from: j */
    private final double f57096j;

    /* renamed from: k */
    private final int f57097k;

    /* renamed from: l */
    private final int f57098l;

    public C20870final(JSONObject jSONObject) throws JSONException {
        this.f57087a = jSONObject.optDouble("lui", 0.2d);
        this.f57088b = jSONObject.optInt(FirebaseABTesting.OriginService.REMOTE_CONFIG, 10);
        this.f57089c = jSONObject.optDouble("fdt", 0.1d);
        this.f57090d = jSONObject.optDouble("fsr", 1.25d);
        JSONArray optJSONArray = jSONObject.optJSONArray("wgv");
        if (optJSONArray == null) {
            this.f57091e = new double[]{1.0d, 1.0d, 1.3d};
        } else {
            this.f57091e = new double[]{optJSONArray.getDouble(0), optJSONArray.getDouble(1), optJSONArray.getDouble(2)};
        }
        this.f57092f = jSONObject.optDouble("vps", 0.8d);
        this.f57093g = jSONObject.optDouble(GuideParamModel.ACTION_SET, 0.15d);
        this.f57094h = jSONObject.optDouble("smf", 0.58d);
        this.f57095i = jSONObject.optDouble("lgf", 0.9d);
        this.f57096j = jSONObject.optDouble("lft", 0.58d);
        this.f57097k = jSONObject.optInt("frw", 5);
        this.f57098l = jSONObject.optInt("mmx", 50);
    }

    /* renamed from: break  reason: not valid java name */
    public double m48110break() {
        return this.f57094h;
    }

    /* renamed from: case  reason: not valid java name */
    public double m48111case() {
        return this.f57096j;
    }

    /* renamed from: catch  reason: not valid java name */
    public double m48112catch() {
        return this.f57092f;
    }

    /* renamed from: class  reason: not valid java name */
    public C3682while m48113class() {
        return new C3682while(this.f57091e);
    }

    /* renamed from: do */
    public double mo171478do() {
        return this.f57089c;
    }

    /* renamed from: else  reason: not valid java name */
    public double m48114else() {
        return this.f57095i;
    }

    /* renamed from: for  reason: not valid java name */
    public double m48115for() {
        return this.f57090d;
    }

    /* renamed from: goto  reason: not valid java name */
    public int m48116goto() {
        return ((int) this.f57087a) * 1000;
    }

    /* renamed from: if */
    public double mo171482if() {
        return this.f57093g;
    }

    /* renamed from: new  reason: not valid java name */
    public int m48117new() {
        return this.f57088b;
    }

    /* renamed from: this  reason: not valid java name */
    public int m48118this() {
        return this.f57098l;
    }

    public String toString() {
        return "LivenessParameters{locoUpdateInterval=" + this.f57087a + ", frameCount=" + this.f57088b + ", finalDistanceFromTarget=" + this.f57089c + ", finalSizeRatio=" + this.f57090d + ", weightsVector=" + Arrays.toString(this.f57091e) + ", vectorProgressScale=" + this.f57092f + ", finalSizeErrorFromTarget=" + this.f57093g + ", smallFaceWidth=" + this.f57094h + ", largeFaceWidth=" + this.f57095i + ", largeFaceThreshold=" + this.f57096j + ", frameSelectionWindow=" + this.f57097k + ", maximumMotionUpdatesPerCheckpoint=" + this.f57098l + '}';
    }

    /* renamed from: try  reason: not valid java name */
    public int m48119try() {
        return this.f57097k;
    }
}
