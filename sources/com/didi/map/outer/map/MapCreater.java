package com.didi.map.outer.map;

import android.content.Context;
import com.didi.util.CrashTryCatcher;

public class MapCreater {
    private MapCreater() {
    }

    public static DidiMap getDidiMap(Context context, MapView mapView) {
        Object obj;
        try {
            obj = m23528a("com.didi.map.outer.map.DidiMap_V1", new Class[]{MapView.class, Context.class}, new Object[]{mapView, context});
        } catch (Exception e) {
            CrashTryCatcher.logCrash(e);
            obj = null;
        }
        return (DidiMap) obj;
    }

    /* renamed from: a */
    private static Object m23528a(String str, Class[] clsArr, Object[] objArr) throws ClassNotFoundException {
        Class a = m23527a(str);
        if (a == null) {
            return null;
        }
        try {
            return a.getDeclaredConstructor(clsArr).newInstance(objArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static Class m23527a(String str) {
        try {
            return Class.forName(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
