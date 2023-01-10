package com.didi.dimina.webview.resource.offline;

import android.text.TextUtils;
import com.didi.dimina.container.secondparty.bundle.util.PmFileConstant;
import com.didi.dimina.webview.resource.offline.FusionContract;
import org.json.JSONObject;

public class OfflineBundleInfo {
    public static final int DOWNLOAD_MODE_BEF = 1;
    public static final int DOWNLOAD_MODE_EVENT = 3;
    public static final int DOWNLOAD_MODE_WIFI = 2;

    /* renamed from: a */
    private static final String f20228a = "10000000";

    /* renamed from: b */
    private static final String f20229b = "-20000000";

    /* renamed from: c */
    private int f20230c;

    /* renamed from: d */
    private String f20231d;

    /* renamed from: e */
    private String f20232e;

    /* renamed from: f */
    private String f20233f;

    /* renamed from: g */
    private String f20234g;

    /* renamed from: h */
    private String f20235h;

    /* renamed from: i */
    private int f20236i;

    /* renamed from: j */
    private int f20237j = 0;

    public static class State {
        public static final int DOWNLOADING = 1;
        public static final int DOWNLOAD_FAIL = 3;
        public static final int DOWNLOAD_SUCCESS = 2;
        public static final int INVALID = 0;
        public static final int WAIT_WIFI = 4;
    }

    public static OfflineBundleInfo fromJson(JSONObject jSONObject) {
        OfflineBundleInfo offlineBundleInfo = new OfflineBundleInfo();
        try {
            offlineBundleInfo.f20231d = jSONObject.optString("bundle_name", "");
            offlineBundleInfo.f20232e = jSONObject.optString(FusionContract.OfflineBundle.COLUMN_NAME_ORIGIN_URL, "");
            offlineBundleInfo.f20233f = jSONObject.optString("download_url", "");
            offlineBundleInfo.f20234g = jSONObject.optString("version", "");
            offlineBundleInfo.f20236i = jSONObject.optInt("download_mode", 0);
            offlineBundleInfo.f20235h = jSONObject.optString("md5", "");
        } catch (Exception unused) {
            offlineBundleInfo = null;
        }
        if (TextUtils.isEmpty(offlineBundleInfo.f20231d)) {
            return null;
        }
        return offlineBundleInfo;
    }

    public void updateInfo(OfflineBundleInfo offlineBundleInfo) {
        this.f20233f = offlineBundleInfo.f20233f;
        this.f20234g = offlineBundleInfo.f20234g;
        this.f20235h = offlineBundleInfo.f20235h;
        this.f20237j = offlineBundleInfo.f20237j;
        this.f20236i = offlineBundleInfo.f20236i;
    }

    public void setId(int i) {
        this.f20230c = i;
    }

    public int getId() {
        return this.f20230c;
    }

    public String getBundleName() {
        return this.f20231d;
    }

    public void setBundleName(String str) {
        this.f20231d = str;
    }

    public String getOriginUrl() {
        return this.f20232e;
    }

    public void setOriginUrl(String str) {
        this.f20232e = str;
    }

    public String getDownloadUrl() {
        return this.f20233f;
    }

    public void setDownloadUrl(String str) {
        this.f20233f = str;
    }

    public String getBundleVersion() {
        return this.f20234g;
    }

    public void setBundleVersion(String str) {
        this.f20234g = str;
    }

    public String getMd5() {
        return this.f20235h;
    }

    public void setMd5(String str) {
        this.f20235h = str;
    }

    public void setState(int i) {
        this.f20237j = i;
    }

    public int getState() {
        return this.f20237j;
    }

    public boolean isRollback() {
        return f20228a.equals(this.f20234g);
    }

    public boolean isDelete() {
        return f20229b.equals(this.f20234g);
    }

    public boolean isComplete() {
        return !TextUtils.isEmpty(this.f20233f) && !TextUtils.isEmpty(this.f20232e);
    }

    public String getBundleFileName() {
        return this.f20231d + "_" + this.f20234g + PmFileConstant.ZIP_SUFFIX;
    }

    public String getBundleDirName() {
        return this.f20231d + "_" + this.f20234g;
    }

    public boolean isValid() {
        return this.f20237j == 2 && !isRollback() && !isDelete();
    }

    public int getDownloadMode() {
        return this.f20236i;
    }

    public void setDownloadMode(int i) {
        this.f20236i = i;
    }
}
