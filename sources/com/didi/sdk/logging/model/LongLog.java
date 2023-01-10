package com.didi.sdk.logging.model;

import android.os.Process;
import android.text.TextUtils;
import com.didi.sdk.logging.Level;
import com.didi.sdk.logging.util.LoggerUtils;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class LongLog extends AbstractLog {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f39341a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Object[] f39342b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Date f39343c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f39344d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f39345e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f39346f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f39347g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f39348h = "";
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f39349i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Map<?, ?> f39350j;

    public String getContent() {
        Object[] objArr;
        String str = this.f39341a;
        if (this.f39347g && (objArr = this.f39342b) != null && objArr.length > 0) {
            try {
                str = String.format(Locale.getDefault(), this.f39341a, this.f39342b);
            } catch (Exception unused) {
            }
        }
        if (!this.f39347g || TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Const.jaLeft);
        sb.append(this.logLevel.name);
        sb.append(Const.jaRight);
        sb.append(Const.jaLeft);
        sb.append(LoggerUtils.formatForLogHead(this.f39343c));
        sb.append(Const.jaRight);
        sb.append(Const.jaLeft);
        sb.append(this.f39348h);
        sb.append(":");
        sb.append(this.f39349i);
        sb.append(Const.jaRight);
        sb.append(Const.jaLeft);
        sb.append(this.f39344d);
        sb.append(Const.jaRight);
        sb.append("||msg=");
        sb.append(str);
        sb.append("||");
        Map<?, ?> map = this.f39350j;
        if (map != null) {
            sb.append(map.toString());
        }
        sb.append(Const.jaLeft);
        sb.append(Process.myPid());
        sb.append("-");
        sb.append(this.f39345e);
        sb.append(Const.jaRight);
        return sb.toString();
    }

    public String getTag() {
        String str = this.f39344d;
        return str == null ? "" : str;
    }

    public String getMsg() {
        Object[] objArr = this.f39342b;
        if (objArr != null && objArr.length > 0) {
            try {
                return String.format(Locale.getDefault(), this.f39341a, this.f39342b);
            } catch (Exception unused) {
            }
        }
        return this.f39341a;
    }

    public byte[] getData() {
        throw new UnsupportedOperationException();
    }

    public static final class Builder {
        private Level logLevel;
        private Object[] mArgs;
        private String mClassName;
        private Date mDate;
        private boolean mFormat = true;
        private int mLine;
        private String mMsg;
        private String mTag;
        private int mTid;
        private String mTnm;
        private Map<?, ?> userInfo;

        public static Builder create() {
            return new Builder();
        }

        public Builder setMsg(String str) {
            this.mMsg = str;
            return this;
        }

        public Builder setLogLevel(Level level) {
            this.logLevel = level;
            return this;
        }

        public Builder setArgs(Object[] objArr) {
            this.mArgs = objArr;
            return this;
        }

        public Builder setDate(Date date) {
            this.mDate = date;
            return this;
        }

        public Builder setTag(String str) {
            this.mTag = str;
            return this;
        }

        public Builder setTid(int i) {
            this.mTid = i;
            return this;
        }

        public Builder setTnm(String str) {
            this.mTnm = str;
            return this;
        }

        public Builder setFormat(boolean z) {
            this.mFormat = z;
            return this;
        }

        public Builder setClassName(String str) {
            this.mClassName = str;
            return this;
        }

        public Builder setLine(int i) {
            this.mLine = i;
            return this;
        }

        public Builder setUserInfo(Map<?, ?> map) {
            this.userInfo = map;
            return this;
        }

        public LongLog build() {
            LongLog longLog = new LongLog();
            Date unused = longLog.f39343c = this.mDate;
            longLog.logLevel = this.logLevel;
            int unused2 = longLog.f39345e = this.mTid;
            String unused3 = longLog.f39341a = this.mMsg;
            String unused4 = longLog.f39344d = this.mTag;
            String unused5 = longLog.f39346f = this.mTnm;
            Object[] unused6 = longLog.f39342b = this.mArgs;
            boolean unused7 = longLog.f39347g = this.mFormat;
            String unused8 = longLog.f39348h = this.mClassName;
            int unused9 = longLog.f39349i = this.mLine;
            Map unused10 = longLog.f39350j = this.userInfo;
            return longLog;
        }
    }
}
