package com.didi.dimina.container.bridge.storage;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.util.JSONUtil;
import java.util.List;

public class StorageServiceSP {

    /* renamed from: a */
    private final StoreImpl f18659a;

    public StorageServiceSP(DMMina dMMina) {
        this.f18659a = new StoreImpl(dMMina);
    }

    public void putInt(String str, int i) {
        this.f18659a.putInt(str, i);
    }

    public int getInt(String str, int i) {
        return this.f18659a.getInt(str, i);
    }

    public void putLong(String str, long j) {
        this.f18659a.putLong(str, j);
    }

    public long getLong(String str, long j) {
        return this.f18659a.getLong(str, j);
    }

    public void putBoolean(String str, boolean z) {
        this.f18659a.putBoolean(str, z);
    }

    public boolean getBoolean(String str, boolean z) {
        return this.f18659a.getBoolean(str, z);
    }

    public float getFloat(String str, float f) {
        return this.f18659a.getFloat(str, f);
    }

    public void putString(String str, String str2) {
        this.f18659a.putString(str, str2);
    }

    public void putFloat(String str, float f) {
        this.f18659a.putFloat(str, f);
    }

    public String getString(String str, String str2) {
        return this.f18659a.getString(str, str2);
    }

    public void putJsonObj(String str, Object obj) {
        this.f18659a.putObject(str, obj);
    }

    public void remove(String str) {
        this.f18659a.remove(str);
    }

    public void clearAll() {
        this.f18659a.clearAll();
    }

    public <T> List<T> getList(String str, Class<T> cls) {
        return this.f18659a.getList(str, cls);
    }

    public String[] getAllKeys() {
        return this.f18659a.getAllKey();
    }

    private static class StoreImpl {
        private final DMMina dmMina;

        public StoreImpl(DMMina dMMina) {
            this.dmMina = dMMina;
        }

        public void putObject(String str, Object obj) {
            if (obj != null) {
                putString(str, JSONUtil.jsonFromObject(obj));
            }
        }

        public <T> T getObject(String str, Class<T> cls) {
            String string = getString(str, (String) null);
            if (string == null) {
                return null;
            }
            return JSONUtil.objectFromJson(string, cls);
        }

        public <T> List<T> getList(String str, Class<T> cls) {
            String string = getString(str, (String) null);
            if (string == null) {
                return null;
            }
            return JSONUtil.jsonToList(string, cls);
        }

        public String getString(String str, String str2) {
            return (String) this.dmMina.getMMKVManager().get(str, str2);
        }

        public int getInt(String str, int i) {
            return ((Integer) this.dmMina.getMMKVManager().get(str, Integer.valueOf(i))).intValue();
        }

        public long getLong(String str, long j) {
            return ((Long) this.dmMina.getMMKVManager().get(str, Long.valueOf(j))).longValue();
        }

        public boolean getBoolean(String str, boolean z) {
            return ((Boolean) this.dmMina.getMMKVManager().get(str, Boolean.valueOf(z))).booleanValue();
        }

        public float getFloat(String str, float f) {
            return ((Float) this.dmMina.getMMKVManager().get(str, Float.valueOf(f))).floatValue();
        }

        public void putInt(String str, int i) {
            this.dmMina.getMMKVManager().save(str, Integer.valueOf(i));
        }

        public void putBoolean(String str, boolean z) {
            this.dmMina.getMMKVManager().save(str, Boolean.valueOf(z));
        }

        public void putLong(String str, long j) {
            this.dmMina.getMMKVManager().save(str, Long.valueOf(j));
        }

        public void putString(String str, String str2) {
            this.dmMina.getMMKVManager().save(str, str2);
        }

        public void putFloat(String str, float f) {
            this.dmMina.getMMKVManager().save(str, Float.valueOf(f));
        }

        public void remove(String str) {
            this.dmMina.getMMKVManager().remove(str);
        }

        public void clearAll() {
            this.dmMina.getMMKVManager().clearAll();
        }

        public String[] getAllKey() {
            return this.dmMina.getMMKVManager().getAllKeys();
        }
    }
}
