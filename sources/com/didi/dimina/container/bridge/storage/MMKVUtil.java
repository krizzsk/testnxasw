package com.didi.dimina.container.bridge.storage;

import com.tencent.mmkv.MMKV;

public class MMKVUtil {

    /* renamed from: a */
    private static MMKVUtil f18656a;

    /* renamed from: b */
    private final MMKV f18657b = MMKV.defaultMMKV();

    private MMKVUtil() {
    }

    public static MMKVUtil getInstance() {
        if (f18656a == null) {
            synchronized (MMKVUtil.class) {
                if (f18656a == null) {
                    f18656a = new MMKVUtil();
                }
            }
        }
        return f18656a;
    }

    public void remove(String str) {
        this.f18657b.remove(str);
    }

    public void clearAll() {
        this.f18657b.clearAll();
    }

    public String[] getAllKeys() {
        return this.f18657b.allKeys();
    }

    public void save(String str, Object obj) {
        if (obj instanceof String) {
            this.f18657b.encode(str, (String) obj);
        } else if (obj instanceof Integer) {
            this.f18657b.encode(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            this.f18657b.encode(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            this.f18657b.encode(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            this.f18657b.encode(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            this.f18657b.encode(str, ((Boolean) obj).booleanValue());
        } else {
            this.f18657b.encode(str, obj.toString());
        }
    }

    public Object get(String str, Object obj) {
        if (obj instanceof String) {
            return this.f18657b.decodeString(str, (String) obj);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(this.f18657b.decodeInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(this.f18657b.decodeLong(str, ((Long) obj).longValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(this.f18657b.decodeFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Double) {
            return Double.valueOf(this.f18657b.decodeDouble(str, ((Double) obj).doubleValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(this.f18657b.decodeBool(str, ((Boolean) obj).booleanValue()));
        }
        return obj != null ? this.f18657b.decodeString(str, obj.toString()) : "";
    }
}
