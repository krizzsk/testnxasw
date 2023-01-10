package com.didi.drouter.utils;

import com.google.gson.Gson;

public class JsonConverter {

    /* renamed from: a */
    private static JsonConvert f21140a;

    public interface JsonConvert {
        <T> T fromJson(String str, Class<T> cls);

        String toJson(Object obj);
    }

    public static void setJsonConvert(JsonConvert jsonConvert) {
        f21140a = jsonConvert;
    }

    public static String toString(Object obj) {
        m17832a();
        return f21140a.toJson(obj);
    }

    public static <T> T toObject(String str, Class<T> cls) {
        RouterLogger.getCoreLogger().mo63952w("Json transform to object error", new Object[0]);
        return null;
    }

    /* renamed from: a */
    private static void m17832a() {
        if (f21140a == null) {
            f21140a = new InnerConvert();
        }
    }

    private static class InnerConvert implements JsonConvert {
        private final Gson gson;

        private InnerConvert() {
            this.gson = new Gson();
        }

        public String toJson(Object obj) {
            return this.gson.toJson(obj);
        }

        public <T> T fromJson(String str, Class<T> cls) {
            return this.gson.fromJson(str, cls);
        }
    }
}
