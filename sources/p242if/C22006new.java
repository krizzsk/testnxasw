package p242if;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.view.Display;
import android.view.WindowManager;
import com.datadog.android.rum.RumAttributes;
import com.iproov.sdk.core.C20889this;
import com.jumio.core.environment.Environment;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import p069native.C2946do;
import p095switch.C3679throw;

/* renamed from: if.new */
/* compiled from: ClaimUtils */
public class C22006new {

    /* renamed from: if.new$do */
    /* compiled from: ClaimUtils */
    static /* synthetic */ class C22007do {

        /* renamed from: do */
        static final /* synthetic */ int[] f60047do;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                if.do[] r0 = p242if.C21998do.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f60047do = r0
                if.do r1 = p242if.C21998do.LIVENESS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f60047do     // Catch:{ NoSuchFieldError -> 0x001d }
                if.do r1 = p242if.C21998do.GENUINE_PRESENCE_ASSURANCE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p242if.C22006new.C22007do.<clinit>():void");
        }
    }

    /* renamed from: do */
    public static int m45186do(char c) {
        return c != '0' ? c != '1' ? c != 'b' ? c != 'c' ? c != 'g' ? c != 'm' ? c != 'r' ? c != 'y' ? R.color.iproov__black : R.color.iproov__yellow : R.color.iproov__red : R.color.iproov__magenta : R.color.iproov__green : R.color.iproov__cyan : R.color.iproov__blue : R.color.iproov__white : R.color.iproov__black;
    }

    /* renamed from: do */
    public static String m45187do(Context context, C22001for forR, double d, boolean z, C21998do doVar) {
        if (d < 0.75d) {
            return context.getResources().getString(z ? R.string.iproov__progress_streaming_slow : R.string.iproov__progress_streaming);
        } else if (d < 0.875d) {
            if (forR.equals(C22001for.ENROL)) {
                return context.getResources().getString(R.string.iproov__progress_finding_face);
            }
            return context.getResources().getString(R.string.iproov__progress_identifying_face);
        } else if (d < 0.94d) {
            if (forR.equals(C22001for.ENROL)) {
                return context.getResources().getString(R.string.iproov__progress_creating_identity);
            }
            return context.getResources().getString(R.string.iproov__progress_confirming_identity);
        } else if (d >= 0.975d) {
            return context.getResources().getString(R.string.iproov__progress_loading);
        } else {
            if (C22007do.f60047do[doVar.ordinal()] != 1) {
                return context.getResources().getString(R.string.iproov__progress_assessing_genuine_presence);
            }
            return context.getResources().getString(R.string.iproov__progress_assessing_liveness);
        }
    }

    /* renamed from: do */
    public static String m45188do(Context context, C22005if ifVar) {
        String str;
        if (ifVar.mo181311b() == null) {
            return "";
        }
        if (ifVar.m48269catch() == C22001for.ENROL) {
            str = context.getString(R.string.iproov__enrol);
        } else {
            str = context.getString(R.string.iproov__authenticate);
        }
        if (ifVar.mo181310a() != null) {
            return context.getString(R.string.iproov__message_format_with_username, new Object[]{str, ifVar.mo181310a(), ifVar.mo181311b()});
        }
        return context.getString(R.string.iproov__message_format, new Object[]{str, ifVar.mo181311b()});
    }

    /* renamed from: do */
    public static Map<String, String> m45189do(Context context, String str, C20889this thisR) {
        Point a = m45185a(context);
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "Android");
        hashMap.put("name", Build.MODEL);
        hashMap.put("model", Build.BRAND);
        hashMap.put("language", Locale.getDefault().getLanguage());
        hashMap.put("language_file", context.getResources().getString(R.string.iproov__language_file));
        hashMap.put("manufacturer", Build.MANUFACTURER);
        hashMap.put("os", Build.DISPLAY);
        hashMap.put("type", Build.DEVICE);
        hashMap.put("dpi", context.getResources().getDisplayMetrics().toString());
        hashMap.put("width", String.valueOf(a.x));
        hashMap.put("height", String.valueOf(a.y));
        hashMap.put("version", Build.VERSION.RELEASE);
        hashMap.put("details", Settings.Secure.getString(context.getApplicationContext().getContentResolver(), "android_id"));
        hashMap.put("identifier", Settings.Secure.getString(context.getApplicationContext().getContentResolver(), "android_id"));
        hashMap.put("app_id", context.getPackageName());
        hashMap.put("app_version", String.format(TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(C3679throw.m7438do(context))}));
        hashMap.put("app_version_name", C3679throw.m7444if(context));
        hashMap.put("sdk_version", Environment.IPROOV_VERSION);
        hashMap.put("token", str);
        hashMap.put("language_version", "0.9.25");
        hashMap.put("gaze_x_buffer", "0.045");
        hashMap.put("transport", "socketio");
        hashMap.put("device_id", C2946do.m6433do(context));
        hashMap.put(RumAttributes.VARIANT, thisR.f57184do.f57186do);
        return hashMap;
    }

    /* renamed from: a */
    private static Point m45185a(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }
}
