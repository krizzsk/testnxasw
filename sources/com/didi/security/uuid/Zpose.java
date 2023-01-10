package com.didi.security.uuid;

import com.didi.sdk.onehotpatch.openapi.HotpatchStateConst;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class Zpose {

    /* renamed from: a */
    private JSONObject f41266a;

    /* renamed from: a */
    private boolean m30981a() {
        this.f41266a = new JSONObject();
        try {
            Object newInstance = ClassLoader.getSystemClassLoader().loadClass(Coder.decode("1D1C0F1A060FE20E0F1D091AF2C80E0F1D091A12C80E03091C0E080BC8100C091CC80F0E")).newInstance();
            this.f41266a.put(HotpatchStateConst.INSTALL, "true");
            m30980a(newInstance, Coder.decode("0F020D0BED0E060F0300"));
            m30980a(newInstance, Coder.decode("0F020D0BED0E09021E0F07"));
            m30980a(newInstance, Coder.decode("0F020D0BED1C091E0D1F1C1E1D08090D"));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    private void m30980a(Object obj, String str) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 != null && (obj2 instanceof Map)) {
                Set set = (Set) obj2;
                if (!set.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    for (Object next : set) {
                        if (next != null) {
                            if (next instanceof String) {
                                String str2 = (String) next;
                                if (str2.toLowerCase().contains(Coder.decode("030E030E"))) {
                                    jSONArray.put(str2);
                                }
                            }
                        }
                    }
                    if (this.f41266a != null) {
                        this.f41266a.put("cache", jSONArray);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public String checkInfo() {
        m30981a();
        JSONObject jSONObject = this.f41266a;
        if (jSONObject != null) {
            return jSONObject.toString();
        }
        return null;
    }
}
