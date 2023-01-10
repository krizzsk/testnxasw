package com.threatmetrix.TrustDefender;

import android.content.Context;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class qqyyqy {
    public static final String b007000700070p0070p = "MODULE_TYPE_DEVICE_SECURITY";
    private static final String b00700070pp0070p = "TRUE";
    public static final String b0070p0070p0070p = "MODULE_TYPE_BIOMETRICS";
    public static final String bp00700070p0070p = "MODULE_TYPE_AUTHENTICATION";
    private static final String bpp0070p0070p = "NATIVE_BLOCKED";
    private boolean b00700070007000700070p;
    public Object b00700070p00700070p;
    public Object b0070p007000700070p;
    public Object b0070pp00700070p;
    private String b0070pppp0070;
    private Object bp0070007000700070p;
    public Object bp0070p00700070p;
    public Object bpp007000700070p;
    public Object bppp00700070p;
    private String bppppp0070;

    public qqyyqy(Object obj, String str) {
        if (obj instanceof Map) {
            Map map = (Map) obj;
            this.bppp00700070p = map.get("moduleInstance");
            this.b0070pp00700070p = map.get("getTypeHandler");
            this.bp0070p00700070p = map.get("configureHandler");
            this.bp0070007000700070p = map.get("startDataCollectionHandler");
            this.b0070p007000700070p = map.get("cancelHandler");
            this.bpp007000700070p = map.get("moduleMetadataHandler");
            this.b00700070p00700070p = map.get("getDeniedPermissionsHandler");
        }
        this.b00700070007000700070p = false;
        this.b0070pppp0070 = str;
    }

    public Long b0074007400740074t0074(int i) {
        ArrayList arrayList = new ArrayList(1);
        b0074ttt00740074((Method) this.bpp007000700070p, Integer.valueOf(i), arrayList);
        return Long.valueOf(!arrayList.isEmpty() ? ((Long) arrayList.get(0)).longValue() : 0);
    }

    public void b00740074t0074t0074() {
        b0074ttt00740074((Method) this.b0070p007000700070p, new Object[0]);
    }

    public boolean b00740074tt00740074(Object obj) {
        return obj instanceof Method;
    }

    public Set<String> b0074t00740074t0074() {
        HashSet hashSet = new HashSet();
        b0074ttt00740074((Method) this.b00700070p00700070p, hashSet);
        return hashSet;
    }

    public void b0074t0074t00740074() {
        this.b00700070007000700070p = true;
    }

    public void b0074ttt00740074(Method method, Object... objArr) {
        Object obj;
        if (method != null && (obj = this.bppp00700070p) != null) {
            kkjkjk.bs00730073s007300730073(obj, method, objArr);
        }
    }

    public boolean b00750075007500750075u() {
        return this.bppp00700070p != null && b00740074tt00740074(this.b0070pp00700070p) && b00740074tt00740074(this.bp0070p00700070p) && b00740074tt00740074(this.bp0070007000700070p) && b00740074tt00740074(this.b0070p007000700070p) && b00740074tt00740074(this.bpp007000700070p) && b00740074tt00740074(this.b00700070p00700070p);
    }

    public String bt007400740074t0074() {
        return this.b0070pppp0070;
    }

    public Map<String, String> bt00740074t00740074(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        b0074ttt00740074((Method) this.bp0070007000700070p, map, hashMap);
        if (!hashMap.isEmpty()) {
            return hashMap;
        }
        return null;
    }

    public boolean bt0074tt00740074() {
        return this.b00700070007000700070p;
    }

    public boolean btt00740074t0074(Context context, Map<String, Object> map) {
        ArrayList arrayList = new ArrayList(1);
        b0074ttt00740074((Method) this.bp0070p00700070p, context, map, arrayList);
        if (!arrayList.isEmpty()) {
            String str = (String) arrayList.get(0);
            this.bppppp0070 = str;
            if (str.equals(b00700070pp0070p) || this.bppppp0070.equals(bpp0070p0070p)) {
                return true;
            }
        }
        return false;
    }

    public boolean btt0074t00740074() {
        return this.bppppp0070.equals(bpp0070p0070p);
    }

    public String btttt00740074() {
        ArrayList arrayList = new ArrayList(1);
        b0074ttt00740074((Method) this.b0070pp00700070p, arrayList);
        return !arrayList.isEmpty() ? (String) arrayList.get(0) : "";
    }
}
