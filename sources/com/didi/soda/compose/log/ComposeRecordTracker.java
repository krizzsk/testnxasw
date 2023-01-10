package com.didi.soda.compose.log;

import android.text.TextUtils;
import com.didi.sofa.utils.TimeUtils;
import java.util.HashMap;
import java.util.Map;

public final class ComposeRecordTracker {

    /* renamed from: a */
    private HashMap<String, Object> f42700a;

    /* renamed from: b */
    private String f42701b;

    /* renamed from: c */
    private String f42702c;

    /* renamed from: d */
    private String f42703d;

    /* renamed from: e */
    private String f42704e;

    /* renamed from: f */
    private String f42705f;

    /* renamed from: g */
    private RecordTrakerGeneratorCompose f42706g;

    private ComposeRecordTracker(String str, String str2, String str3, String str4, HashMap<String, Object> hashMap, String str5) {
        this.f42700a = new HashMap<>();
        this.f42704e = str;
        this.f42701b = str2;
        this.f42702c = str3;
        this.f42703d = str4;
        this.f42700a = hashMap;
        this.f42705f = str5;
        this.f42706g = new RecordTrakerGeneratorCompose(this);
    }

    public static StringBuilder buildLogFormat(ComposeRecordTracker composeRecordTracker) {
        StringBuilder sb = new StringBuilder();
        if (composeRecordTracker == null) {
            return sb;
        }
        if (!TextUtils.isEmpty(composeRecordTracker.f42704e)) {
            sb.append(String.format("tag- %s |", new Object[]{composeRecordTracker.f42704e}));
        }
        if (!TextUtils.isEmpty(composeRecordTracker.f42703d)) {
            sb.append(String.format("msg- %s | ", new Object[]{composeRecordTracker.f42703d.trim()}));
        }
        if (!TextUtils.isEmpty(composeRecordTracker.f42705f)) {
            sb.append(String.format("time- %s |", new Object[]{composeRecordTracker.f42705f}));
        }
        if (!TextUtils.isEmpty(composeRecordTracker.f42701b)) {
            sb.append(composeRecordTracker.f42701b);
        }
        if (!TextUtils.isEmpty(composeRecordTracker.f42702c)) {
            sb.append(composeRecordTracker.f42702c);
        }
        HashMap<String, Object> hashMap = composeRecordTracker.f42700a;
        if (hashMap != null && hashMap.size() > 0) {
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry next : composeRecordTracker.f42700a.entrySet()) {
                Object value = next.getValue();
                sb2.append(((String) next.getKey()) + ":" + value + ",");
            }
            sb2.substring(0, sb2.length() - 1);
            sb.append(String.format("params- %s |", new Object[]{sb2.toString()}));
        }
        return sb;
    }

    public void error() {
        m32033a("l-ERROR|");
    }

    public void info() {
        m32033a("l-INFO|");
    }

    public void warn() {
        m32033a("l-WARNING|");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m32033a(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = -1713390571(0xffffffff99dfbc15, float:-2.3133625E-23)
            r2 = 1
            if (r0 == r1) goto L_0x001a
            r1 = 1801023681(0x6b5970c1, float:2.6286937E26)
            if (r0 == r1) goto L_0x0010
            goto L_0x0024
        L_0x0010:
            java.lang.String r0 = "l-WARNING|"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0024
            r4 = 0
            goto L_0x0025
        L_0x001a:
            java.lang.String r0 = "l-ERROR|"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0024
            r4 = 1
            goto L_0x0025
        L_0x0024:
            r4 = -1
        L_0x0025:
            if (r4 == 0) goto L_0x0039
            if (r4 == r2) goto L_0x0031
            java.lang.String r4 = r3.f42704e
            com.didi.soda.compose.log.ComposeRecordTracker$RecordTrakerGeneratorCompose r0 = r3.f42706g
            com.didi.soda.compose.log.ComposeLogUtil.m32029i((java.lang.String) r4, (com.didi.soda.compose.log.ComposeIMessageGenerator<java.lang.String>) r0)
            goto L_0x0040
        L_0x0031:
            java.lang.String r4 = r3.f42704e
            com.didi.soda.compose.log.ComposeRecordTracker$RecordTrakerGeneratorCompose r0 = r3.f42706g
            com.didi.soda.compose.log.ComposeLogUtil.m32027e((java.lang.String) r4, (com.didi.soda.compose.log.ComposeIMessageGenerator<java.lang.String>) r0)
            goto L_0x0040
        L_0x0039:
            java.lang.String r4 = r3.f42704e
            com.didi.soda.compose.log.ComposeRecordTracker$RecordTrakerGeneratorCompose r0 = r3.f42706g
            com.didi.soda.compose.log.ComposeLogUtil.m32031w((java.lang.String) r4, (com.didi.soda.compose.log.ComposeIMessageGenerator<java.lang.String>) r0)
        L_0x0040:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.compose.log.ComposeRecordTracker.m32033a(java.lang.String):void");
    }

    public static final class Builder {
        private String mCategory;
        private String mMessage;
        private String mModule;
        private HashMap<String, Object> mOtherParams = new HashMap<>();
        private String mTag;
        private String mTime = TimeUtils.getDateEN();

        private Builder() {
        }

        private Builder(String str, String str2) {
            this.mTag = str;
            this.mMessage = str2;
        }

        public static Builder create() {
            return new Builder();
        }

        public static Builder create(String str, String str2) {
            return new Builder(str, str2);
        }

        public ComposeRecordTracker build() {
            return new ComposeRecordTracker(this.mTag, this.mCategory, this.mModule, this.mMessage, this.mOtherParams, this.mTime);
        }

        public Builder setLogCategory(String str) {
            this.mCategory = str;
            return this;
        }

        public Builder setLogModule(String str) {
            this.mModule = str;
            return this;
        }

        public Builder setMessage(String str) {
            this.mMessage = str;
            return this;
        }

        public Builder setOtherParam(String str, Object obj) {
            this.mOtherParams.put(str, obj);
            return this;
        }

        public Builder setTag(String str) {
            this.mTag = str;
            return this;
        }

        public Builder setTime(String str) {
            this.mTime = str;
            return this;
        }
    }

    public static class RecordTrakerGeneratorCompose implements ComposeIMessageGenerator<String> {
        private ComposeRecordTracker mRecordTracker;

        public RecordTrakerGeneratorCompose(String str, String str2) {
            this.mRecordTracker = buildRecordTracker(str, str2);
        }

        public RecordTrakerGeneratorCompose(ComposeRecordTracker composeRecordTracker) {
            this.mRecordTracker = composeRecordTracker;
        }

        public String build() {
            return ComposeRecordTracker.buildLogFormat(this.mRecordTracker).toString();
        }

        private ComposeRecordTracker buildRecordTracker(String str, String str2) {
            return Builder.create(str, str2).setTime(TimeUtils.getDateEN()).build();
        }
    }
}
