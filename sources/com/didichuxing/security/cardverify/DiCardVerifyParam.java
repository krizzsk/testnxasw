package com.didichuxing.security.cardverify;

import android.content.Context;
import android.os.Build;
import com.didi.sdk.util.SystemUtil;

public class DiCardVerifyParam {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f51428a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f51429b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f51430c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f51431d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f51432e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f51433f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f51434g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f51435h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f51436i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public String f51437j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public String f51438k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public String f51439l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public String f51440m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public String f51441n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public String f51442o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public String f51443p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public String f51444q;

    private DiCardVerifyParam() {
    }

    public String getUid() {
        return this.f51428a;
    }

    public String getCardIndex() {
        return this.f51429b;
    }

    public String getCountry() {
        return this.f51430c;
    }

    public String getLanguage() {
        return this.f51431d;
    }

    public String getToken() {
        return this.f51432e;
    }

    public String getTerminalId() {
        return this.f51433f;
    }

    public String getProductId() {
        return this.f51434g;
    }

    public String getCardNo() {
        return this.f51435h;
    }

    public String getLatitude() {
        return this.f51436i;
    }

    public String getLongitude() {
        return this.f51437j;
    }

    public String getIp() {
        return this.f51438k;
    }

    public String getPhone() {
        return this.f51439l;
    }

    public String getAppVersion() {
        return this.f51440m;
    }

    public String getSdkVersion() {
        return this.f51441n;
    }

    public String getOstype() {
        return this.f51442o;
    }

    public String getOs() {
        return this.f51443p;
    }

    public String getSence() {
        return this.f51444q;
    }

    public static class Builder {
        private DiCardVerifyParam param;

        public Builder(Context context) {
            DiCardVerifyParam diCardVerifyParam = new DiCardVerifyParam();
            this.param = diCardVerifyParam;
            String unused = diCardVerifyParam.f51440m = SystemUtil.getVersionName(context);
            String unused2 = this.param.f51441n = BuildConfig.VERSION_NAME;
            String unused3 = this.param.f51442o = "1";
            String unused4 = this.param.f51443p = String.valueOf(Build.VERSION.SDK_INT);
            String unused5 = this.param.f51444q = "1";
        }

        public Builder uid(String str) {
            String unused = this.param.f51428a = str;
            return this;
        }

        public Builder cardIndex(String str) {
            String unused = this.param.f51429b = str;
            return this;
        }

        public Builder country(String str) {
            String unused = this.param.f51430c = str;
            return this;
        }

        public Builder language(String str) {
            String unused = this.param.f51431d = str;
            return this;
        }

        public Builder token(String str) {
            String unused = this.param.f51432e = str;
            return this;
        }

        public Builder terminalId(String str) {
            String unused = this.param.f51433f = str;
            return this;
        }

        public Builder productId(String str) {
            String unused = this.param.f51434g = str;
            return this;
        }

        public Builder cardNo(String str) {
            String unused = this.param.f51435h = str;
            return this;
        }

        public Builder latitude(String str) {
            String unused = this.param.f51436i = str;
            return this;
        }

        public Builder longitude(String str) {
            String unused = this.param.f51437j = str;
            return this;
        }

        /* renamed from: ip */
        public Builder mo127256ip(String str) {
            String unused = this.param.f51438k = str;
            return this;
        }

        public Builder phone(String str) {
            String unused = this.param.f51439l = str;
            return this;
        }

        public DiCardVerifyParam build() {
            return this.param;
        }
    }
}
