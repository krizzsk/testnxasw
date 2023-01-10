package p055case;

import java.util.HashSet;
import java.util.Set;

/* renamed from: case.else */
/* compiled from: EncoderType */
public enum C1272else {
    AVC("h264", C1273goto.f468do, 2),
    HEVC("h265", C1273goto.f469if, 1),
    VP9("vp9", C1273goto.f62272for, 3),
    VP8("vp8", C1273goto.f62273new, 4);
    

    /* renamed from: goto  reason: not valid java name */
    private static Set<String> f62267goto;

    /* renamed from: do */
    public final String f466do;

    /* renamed from: for  reason: not valid java name */
    public final int f62271for;

    /* renamed from: if */
    public final String f467if;

    static {
        int i;
        f62267goto = new HashSet();
        for (C1272else elseR : values()) {
            f62267goto.add(elseR.f467if);
        }
    }

    private C1272else(String str, String str2, int i) {
        this.f466do = str;
        this.f467if = str2;
        this.f62271for = i;
    }

    /* renamed from: do */
    public static C1272else m985do(String str) {
        if (str == null || str.isEmpty()) {
            return AVC;
        }
        for (C1272else elseR : values()) {
            if (elseR.f466do.equals(str)) {
                return elseR;
            }
        }
        throw new IllegalArgumentException(str + " is incorrect encoder name");
    }

    /* renamed from: for  reason: not valid java name */
    public static boolean m46083for(String str) {
        return f62267goto.contains(str);
    }

    /* renamed from: if */
    public static C1272else m986if(String str) {
        for (C1272else elseR : values()) {
            if (elseR.f467if.equals(str)) {
                return elseR;
            }
        }
        throw new IllegalArgumentException(str + " is incorrect encoder name");
    }
}
