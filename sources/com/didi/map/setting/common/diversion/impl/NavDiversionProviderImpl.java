package com.didi.map.setting.common.diversion.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.didi.map.setting.common.diversion.INavDiversionProvider;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class NavDiversionProviderImpl implements INavDiversionProvider {

    /* renamed from: a */
    private static final int f31403a = 10;

    /* renamed from: b */
    private static final String f31404b = "nav_diversion_driver_config";

    /* renamed from: c */
    private static final String f31405c = "nav_d_record";

    /* renamed from: d */
    private static final String f31406d = "nav_d_has_start";

    /* renamed from: e */
    private SharedPreferences f31407e;

    /* renamed from: f */
    private Context f31408f;

    public NavDiversionProviderImpl(Context context) {
        this.f31408f = context;
    }

    /* renamed from: a */
    private SharedPreferences m23974a() {
        if (this.f31407e == null) {
            this.f31407e = SystemUtils.getSharedPreferences(this.f31408f, f31404b, 0);
        }
        return this.f31407e;
    }

    public void setHasStartedNav() {
        SharedPreferences a;
        if (!hasStartedNav() && (a = m23974a()) != null) {
            a.edit().putBoolean(f31406d, true).apply();
        }
    }

    public boolean hasStartedNav() {
        SharedPreferences a = m23974a();
        if (a != null) {
            return a.getBoolean(f31406d, false);
        }
        return false;
    }

    public void appendNavRecord(String str) {
        SharedPreferences a;
        if (!TextUtils.isEmpty(str) && (a = m23974a()) != null) {
            List<String> navRecord = getNavRecord();
            SharedPreferences.Editor edit = a.edit();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(str);
            if (navRecord.size() > 0) {
                for (String put : navRecord) {
                    jSONArray.put(put);
                    if (jSONArray.length() >= 10) {
                        break;
                    }
                }
            }
            String jSONArray2 = jSONArray.toString();
            if (!TextUtils.isEmpty(jSONArray2)) {
                edit.putString(f31405c, jSONArray2).apply();
            }
        }
    }

    public List<String> getNavRecord() {
        SharedPreferences a = m23974a();
        if (a == null) {
            return Collections.emptyList();
        }
        String string = a.getString(f31405c, "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                ArrayList arrayList = new ArrayList();
                int min = Math.min(jSONArray.length(), 10);
                for (int i = 0; i < min; i++) {
                    String optString = jSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList.add(optString);
                    }
                }
                return arrayList;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return Collections.emptyList();
    }

    public void clearNavRecord() {
        SharedPreferences a = m23974a();
        if (a != null && !TextUtils.isEmpty(a.getString(f31405c, ""))) {
            a.edit().putString(f31405c, "").apply();
        }
    }
}
