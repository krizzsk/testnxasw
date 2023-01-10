package com.didi.beatles.p101im.resource;

import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.access.IMEngine;
import com.didi.beatles.p101im.access.utils.IMBusinessConfig;
import com.didi.beatles.p101im.omega.IMTraceError;
import com.didi.beatles.p101im.utils.IMLog;

@Deprecated
/* renamed from: com.didi.beatles.im.resource.IMResource */
public class IMResource {

    /* renamed from: a */
    private static IMBusinessConfig f11420a = null;

    /* renamed from: b */
    private static final String f11421b = "IMResource";

    /* renamed from: c */
    private static final String f11422c = "IMResource#NullContext#";

    public static void setBusinessId(int i) {
        if (i == 259 && IMContextInfoHelper.getContext() != null && "com.didi.echo".equals(IMContextInfoHelper.getContext().getPackageName())) {
            i = 280;
        }
        f11420a = IMEngine.getInstance(IMContextInfoHelper.getContext()).getCurrentBusinessConfig(i);
        IMLog.m10020d(f11421b, "setBusinessId id is " + i);
        if (f11420a == null) {
            IMLog.m10021e(f11421b, "mBusinessConfig is null while businessId is " + i);
        }
    }

    public static IMBusinessConfig getBusinessConfig() {
        return f11420a;
    }

    /* renamed from: a */
    private static int m9875a(int i) {
        if (IMContextInfoHelper.getContext() == null) {
            IMTraceError.trackError("IMResource#NullContext#[getResourceId]", new Exception("getResourceId"));
            return i;
        }
        String resourceEntryName = IMContextInfoHelper.getContext().getResources().getResourceEntryName(i);
        IMBusinessConfig iMBusinessConfig = f11420a;
        if (iMBusinessConfig != null && iMBusinessConfig.getExtendResource(resourceEntryName) != -1) {
            return f11420a.getExtendResource(resourceEntryName);
        }
        int appResouceId = IMEngine.getInstance(IMContextInfoHelper.getContext()).getAppResouceId(resourceEntryName);
        return appResouceId != 0 ? appResouceId : i;
    }

    public static int getDrawableID(int i) {
        return m9875a(i);
    }

    public static int getColor(int i) {
        if (IMContextInfoHelper.getContext() == null) {
            IMTraceError.trackError("IMResource#NullContext#[getColor]", new Exception("getColor"));
            return 0;
        }
        try {
            return IMContextInfoHelper.getContext().getResources().getColor(m9875a(i));
        } catch (Exception unused) {
            IMLog.m10021e(f11421b, "with the key can't find source !,the key is " + IMContextInfoHelper.getContext().getResources().getResourceEntryName(i));
            return IMContextInfoHelper.getContext().getResources().getColor(i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005d, code lost:
        com.didi.beatles.p101im.utils.IMLog.m10021e(f11421b, "getString", r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0067, code lost:
        return "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002a, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002c */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a A[ExcHandler: NotFoundException (r8v2 'e' android.content.res.Resources$NotFoundException A[CUSTOM_DECLARE]), Splitter:B:5:0x0019] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getString(int r8) {
        /*
            java.lang.String r0 = "IMResource"
            android.content.Context r1 = com.didi.beatles.p101im.IMContextInfoHelper.getContext()
            java.lang.String r2 = ""
            java.lang.String r3 = "getString"
            if (r1 != 0) goto L_0x0017
            java.lang.Exception r8 = new java.lang.Exception
            r8.<init>(r3)
            java.lang.String r0 = "IMResource#NullContext#[getString]"
            com.didi.beatles.p101im.omega.IMTraceError.trackError(r0, r8)
            return r2
        L_0x0017:
            r1 = 1
            r4 = 0
            android.content.Context r5 = com.didi.beatles.p101im.IMContextInfoHelper.getContext()     // Catch:{ Exception -> 0x002c, NotFoundException -> 0x002a }
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ Exception -> 0x002c, NotFoundException -> 0x002a }
            int r6 = m9875a(r8)     // Catch:{ Exception -> 0x002c, NotFoundException -> 0x002a }
            java.lang.String r8 = r5.getString(r6)     // Catch:{ Exception -> 0x002c, NotFoundException -> 0x002a }
            return r8
        L_0x002a:
            r8 = move-exception
            goto L_0x005d
        L_0x002c:
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ NotFoundException -> 0x002a, Exception -> 0x0067 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ NotFoundException -> 0x002a, Exception -> 0x0067 }
            r6.<init>()     // Catch:{ NotFoundException -> 0x002a, Exception -> 0x0067 }
            java.lang.String r7 = "with the key can't find source !,the key is "
            r6.append(r7)     // Catch:{ NotFoundException -> 0x002a, Exception -> 0x0067 }
            android.content.Context r7 = com.didi.beatles.p101im.IMContextInfoHelper.getContext()     // Catch:{ NotFoundException -> 0x002a, Exception -> 0x0067 }
            android.content.res.Resources r7 = r7.getResources()     // Catch:{ NotFoundException -> 0x002a, Exception -> 0x0067 }
            java.lang.String r7 = r7.getResourceEntryName(r8)     // Catch:{ NotFoundException -> 0x002a, Exception -> 0x0067 }
            r6.append(r7)     // Catch:{ NotFoundException -> 0x002a, Exception -> 0x0067 }
            java.lang.String r6 = r6.toString()     // Catch:{ NotFoundException -> 0x002a, Exception -> 0x0067 }
            r5[r4] = r6     // Catch:{ NotFoundException -> 0x002a, Exception -> 0x0067 }
            com.didi.beatles.p101im.utils.IMLog.m10021e(r0, r5)     // Catch:{ NotFoundException -> 0x002a, Exception -> 0x0067 }
            android.content.Context r5 = com.didi.beatles.p101im.IMContextInfoHelper.getContext()     // Catch:{ NotFoundException -> 0x002a, Exception -> 0x0067 }
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ NotFoundException -> 0x002a, Exception -> 0x0067 }
            java.lang.String r8 = r5.getString(r8)     // Catch:{ NotFoundException -> 0x002a, Exception -> 0x0067 }
            return r8
        L_0x005d:
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r4] = r3
            r5[r1] = r8
            com.didi.beatles.p101im.utils.IMLog.m10021e(r0, r5)
        L_0x0067:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p101im.resource.IMResource.getString(int):java.lang.String");
    }

    public static float getDimension(int i, int i2) {
        if (IMContextInfoHelper.getContext() == null) {
            IMTraceError.trackError("IMResource#NullContext#[getDimension]", new Exception("getDimension"));
            return (float) i2;
        }
        try {
            return IMContextInfoHelper.getContext().getResources().getDimension(m9875a(i));
        } catch (Exception unused) {
            try {
                IMLog.m10021e(f11421b, "with the key can't find source! ,the key is " + IMContextInfoHelper.getContext().getResources().getResourceEntryName(i));
                return IMContextInfoHelper.getContext().getResources().getDimension(i);
            } catch (Exception unused2) {
                return (float) i2;
            }
        }
    }
}
