package com.didi.dimina.container.mina;

import android.content.Context;
import com.didi.dimina.container.util.LogUtil;
import com.tencent.mmkv.MMKV;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public class DMMinaPerfStorage {

    /* renamed from: a */
    private final MMKV f18783a;

    public DMMinaPerfStorage(Context context, String str) {
        this.f18783a = MMKV.mmkvWithID(str + "_PerfStorage", new File(context.getFilesDir(), "DMMinaPerfStorage").getAbsolutePath());
    }

    public void plusStorage(String str, Object obj) {
        if (obj instanceof JSONArray) {
            this.f18783a.putString(str, obj.toString());
        } else if (obj instanceof JSONObject) {
            this.f18783a.putString(str, obj.toString());
        } else if (obj instanceof Boolean) {
            this.f18783a.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Double) {
            this.f18783a.putFloat(str, ((Double) obj).floatValue());
        } else if (obj instanceof Integer) {
            this.f18783a.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            this.f18783a.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof String) {
            this.f18783a.putString(str, (String) obj);
        }
    }

    public void minusStorage(String str) {
        this.f18783a.remove(str);
    }

    public void clear() {
        this.f18783a.clear();
    }

    public long getTotal() {
        long currentTimeMillis = System.currentTimeMillis();
        String[] allKeys = this.f18783a.allKeys();
        long j = 0;
        if (allKeys != null) {
            for (String valueActualSize : allKeys) {
                j += (long) this.f18783a.getValueActualSize(valueActualSize);
            }
        }
        LogUtil.m16838d(getClass().getSimpleName(), "getTotal: " + j + " duration:  " + (System.currentTimeMillis() - currentTimeMillis));
        return j;
    }
}
