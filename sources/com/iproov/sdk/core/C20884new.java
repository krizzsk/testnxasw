package com.iproov.sdk.core;

import android.text.TextUtils;
import com.iproov.sdk.cameray.C20776try;
import com.iproov.sdk.face.FaceDetector;
import com.iproov.sdk.face.model.FaceFeature;
import com.iproov.sdk.face.model.Pose;
import com.iproov.sdk.graphics.iproov.OpenGLRenderer;
import java.util.Locale;
import p055case.C1269do;
import p094super.C3650for;
import p230const.C21729if;
import p235do.C21827new;
import p242if.C22005if;

/* renamed from: com.iproov.sdk.core.new */
/* compiled from: DebugUtils */
public class C20884new {
    /* renamed from: if */
    public static String m43433if(Double d) {
        if (d == null) {
            d = Double.valueOf(-1.0d);
        }
        return String.format(Locale.getDefault(), "%.3f", new Object[]{d});
    }

    /* renamed from: a */
    static String m43430a(C3650for forR, C22005if ifVar, FaceFeature faceFeature, OpenGLRenderer openGLRenderer, C20776try tryR, C21827new newR, FaceDetector faceDetector, C1269do doVar, float f, C21729if ifVar2, C21729if ifVar3) {
        String str;
        if (ifVar == null) {
            return "<Awaiting Claim Response>";
        }
        float f2 = ifVar2.mo178976do();
        float f3 = ifVar3.mo178976do();
        Pose pose = null;
        if (newR == null) {
            str = null;
        } else {
            str = newR.mo171312if().mo180435if() + " x " + newR.mo171312if().mo180432do();
        }
        String screenSizeString = openGLRenderer.getScreenSizeString();
        if (faceFeature != null) {
            pose = faceFeature.getPose();
        }
        String[] strArr = new String[7];
        strArr[0] = "Camera: " + tryR.mo171306if();
        strArr[1] = "Preview: " + str + ", Display: " + screenSizeString + ")";
        StringBuilder sb = new StringBuilder();
        sb.append("FPS renderer: ");
        Locale locale = Locale.ENGLISH;
        sb.append(String.format(locale, "%.1f", new Object[]{Float.valueOf(f)}));
        sb.append(" camera: ");
        sb.append(String.format(locale, "%.1f", new Object[]{Float.valueOf(f2)}));
        sb.append(", processing: ");
        sb.append(String.format(locale, "%.1f", new Object[]{Float.valueOf(f3)}));
        strArr[2] = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Face detector: ");
        sb2.append(faceDetector != null ? faceDetector.getFaceDetector() : "NULL");
        strArr[3] = sb2.toString();
        strArr[4] = "Encoder: " + doVar.mo14141if();
        strArr[5] = forR != null ? forR.mo43462do() : "Lighting model: Disabled";
        strArr[6] = "Feature: " + m43429a(pose);
        return TextUtils.join("\n", strArr);
    }

    /* renamed from: a */
    private static String m43429a(Pose pose) {
        if (pose == null) {
            return "🔄 Pose not supported";
        }
        return "🔄 " + m43432do(Float.valueOf(pose.roll)) + ", ↔️ " + m43432do(Float.valueOf(pose.yaw)) + ", ↕️ " + m43432do(Float.valueOf(pose.pitch));
    }

    /* renamed from: do */
    public static String m43432do(Float f) {
        return m43433if(Double.valueOf((double) f.floatValue()));
    }

    /* renamed from: do */
    public static String m43431do(Double d) {
        if (d == null) {
            d = Double.valueOf(0.0d);
        }
        return Math.abs(d.doubleValue() - 1.0d) < 0.1d ? "T" : "F";
    }
}
