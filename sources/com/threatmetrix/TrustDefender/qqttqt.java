package com.threatmetrix.TrustDefender;

import android.content.Context;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;

public final class qqttqt extends qqyyqy {
    private Object brr00720072rr;

    public qqttqt(Object obj, String str) {
        super(obj, str);
        if (obj instanceof Map) {
            this.brr00720072rr = ((Map) obj).get("scanHandler");
        }
    }

    public boolean b00750075007500750075u() {
        return super.b00750075007500750075u() && b00740074tt00740074(this.brr00720072rr);
    }

    public boolean by00790079y0079y(Context context, boolean z, long j, int i) {
        ArrayList arrayList = new ArrayList(1);
        b0074ttt00740074((Method) this.brr00720072rr, context, Boolean.valueOf(z), Long.valueOf(j), Integer.valueOf(i), arrayList);
        return !arrayList.isEmpty() && ((String) arrayList.get(0)).equalsIgnoreCase("TRUE");
    }
}
