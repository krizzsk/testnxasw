package com.didi.hawaii.mapsdkv2;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.hawaii.utils.C10024IO;
import com.didi.hawaii.utils.StringUtil;
import com.didi.map.MapApolloHawaii;
import com.didi.map.constant.FileNameConstant;
import com.didi.sdk.apm.SystemUtils;
import java.io.File;

public class Prefs {

    /* renamed from: b */
    private static final String f25939b = "com.didi.map";

    /* renamed from: c */
    private static final String f25940c = "sdk2_version";

    /* renamed from: a */
    private SharedPreferences f25941a = null;

    /* renamed from: d */
    private String f25942d;

    /* renamed from: e */
    private String f25943e;

    /* renamed from: f */
    private String f25944f;

    /* renamed from: g */
    private Context f25945g;

    /* renamed from: h */
    private String f25946h;

    public Prefs(Context context) {
        this.f25945g = context;
        this.f25944f = context.getFilesDir().getAbsolutePath() + FileNameConstant.CONFIG_FOLDER;
        this.f25946h = context.getFilesDir().getAbsolutePath() + FileNameConstant.MAP_GUARD_FOLDER;
        String str = this.f25944f;
        String a = m20499a(context);
        int i = MapApolloHawaii.BASE_MAP_VERSION;
        if (StringUtil.isEmpty(a)) {
            this.f25942d = str + FileNameConstant.RENDER_FOLDER_CONFIG + "_" + i + "d/";
        } else {
            this.f25942d = str + FileNameConstant.RENDER_SUB_FOLDER_CONFIG + "_" + i + "d/";
        }
        this.f25943e = str + FileNameConstant.SAT_FOLDER_V2;
    }

    public String getCachedSDKVersion() {
        if (this.f25941a == null) {
            this.f25941a = SystemUtils.getSharedPreferences(this.f25945g, "com.didi.map", 0);
        }
        return this.f25941a.getString(f25940c, (String) null);
    }

    public void setCachedSDKVersion(String str) {
        this.f25941a.edit().putString(f25940c, str).apply();
    }

    public String getMapPath4Language(int i) {
        String str = this.f25942d;
        if (i == 1) {
            if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1);
            }
            str = str + "_eng/";
        } else if (i == 2) {
            if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1);
            }
            str = str + "_gat/";
        } else if (i == 3) {
            if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1);
            }
            str = str + "_pt/";
        } else if (i == 4) {
            if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1);
            }
            str = str + "_es/";
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public String getSatPath() {
        return this.f25943e;
    }

    public String getConfigPath() {
        return this.f25944f;
    }

    public String getMapGuardPath() {
        C10024IO.ensureDir(this.f25946h);
        return this.f25946h;
    }

    public String getWmsPath() {
        return this.f25944f + FileNameConstant.WMS_FOLDER_V2;
    }

    /* renamed from: a */
    private static String m20499a(Context context) {
        if (context == null) {
            return "";
        }
        try {
            String packageName = context.getPackageName();
            if (packageName != null) {
                if (packageName.length() != 0) {
                    return packageName.length() > 255 ? packageName.substring(0, 254) : packageName;
                }
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
