package com.didi.sdk.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GSonUtil {

    /* renamed from: a */
    private static Gson f40305a;

    /* renamed from: a */
    private static Gson m30356a() {
        Gson gson;
        Gson gson2 = f40305a;
        if (gson2 != null) {
            return gson2;
        }
        synchronized (GSonUtil.class) {
            if (f40305a == null) {
                f40305a = new GsonBuilder().create();
            }
            gson = f40305a;
        }
        return gson;
    }

    public static String jsonFromObject(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return m30356a().toJson(obj);
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> T objectFromJson(String str, Class<T> cls) {
        if (str == null) {
            return null;
        }
        try {
            return m30356a().fromJson(str, cls);
        } catch (Exception unused) {
            return null;
        }
    }
}
