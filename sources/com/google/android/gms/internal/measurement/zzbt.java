package com.google.android.gms.internal.measurement;

import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzbt {
    private static final Method zza;
    private static final Method zzb;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0045  */
    static {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 6
            java.lang.String r2 = "JobSchedulerCompat"
            r3 = 0
            r4 = 24
            r5 = 0
            if (r0 < r4) goto L_0x003e
            r0 = 4
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ NoSuchMethodException -> 0x002b }
            java.lang.Class<android.app.job.JobInfo> r6 = android.app.job.JobInfo.class
            r0[r3] = r6     // Catch:{ NoSuchMethodException -> 0x002b }
            r6 = 1
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r0[r6] = r7     // Catch:{ NoSuchMethodException -> 0x002b }
            r6 = 2
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x002b }
            r0[r6] = r7     // Catch:{ NoSuchMethodException -> 0x002b }
            r6 = 3
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r0[r6] = r7     // Catch:{ NoSuchMethodException -> 0x002b }
            java.lang.Class<android.app.job.JobScheduler> r6 = android.app.job.JobScheduler.class
            java.lang.String r7 = "scheduleAsPackage"
            java.lang.reflect.Method r0 = r6.getDeclaredMethod(r7, r0)     // Catch:{ NoSuchMethodException -> 0x002b }
            goto L_0x003f
        L_0x002b:
            boolean r0 = android.util.Log.isLoggable(r2, r1)
            if (r0 == 0) goto L_0x003e
            r6 = 6
            r9 = 0
            r11 = 3
            java.lang.String r7 = "JobSchedulerCompat"
            java.lang.String r8 = "No scheduleAsPackage method available, falling back to schedule"
            java.lang.String r10 = "com.google.android.gms.internal.measurement.zzbt"
            com.didi.sdk.apm.SystemUtils.log(r6, r7, r8, r9, r10, r11)
        L_0x003e:
            r0 = r5
        L_0x003f:
            zza = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r4) goto L_0x0063
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            java.lang.String r4 = "myUserId"
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x0050 }
            java.lang.reflect.Method r5 = r0.getDeclaredMethod(r4, r3)     // Catch:{ NoSuchMethodException -> 0x0050 }
            goto L_0x0063
        L_0x0050:
            boolean r0 = android.util.Log.isLoggable(r2, r1)
            if (r0 == 0) goto L_0x0063
            r6 = 6
            r9 = 0
            r11 = 6
            java.lang.String r7 = "JobSchedulerCompat"
            java.lang.String r8 = "No myUserId method available"
            java.lang.String r10 = "com.google.android.gms.internal.measurement.zzbt"
            com.didi.sdk.apm.SystemUtils.log(r6, r7, r8, r9, r10, r11)
        L_0x0063:
            zzb = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbt.<clinit>():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(android.content.Context r8, android.app.job.JobInfo r9, java.lang.String r10, java.lang.String r11) {
        /*
            java.lang.String r10 = "jobscheduler"
            java.lang.Object r10 = r8.getSystemService(r10)
            android.app.job.JobScheduler r10 = (android.app.job.JobScheduler) r10
            if (r10 == 0) goto L_0x0085
            java.lang.reflect.Method r11 = zza
            if (r11 == 0) goto L_0x0080
            java.lang.String r11 = "android.permission.UPDATE_DEVICE_STATS"
            int r8 = r8.checkSelfPermission(r11)
            if (r8 == 0) goto L_0x0017
            goto L_0x0080
        L_0x0017:
            java.lang.reflect.Method r8 = zzb
            r11 = 0
            if (r8 == 0) goto L_0x0045
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            java.lang.Object[] r1 = new java.lang.Object[r11]     // Catch:{ IllegalAccessException -> 0x002f, InvocationTargetException -> 0x002d }
            java.lang.Object r8 = r8.invoke(r0, r1)     // Catch:{ IllegalAccessException -> 0x002f, InvocationTargetException -> 0x002d }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ IllegalAccessException -> 0x002f, InvocationTargetException -> 0x002d }
            if (r8 == 0) goto L_0x0045
            int r8 = r8.intValue()     // Catch:{ IllegalAccessException -> 0x002f, InvocationTargetException -> 0x002d }
            goto L_0x0046
        L_0x002d:
            r8 = move-exception
            goto L_0x0030
        L_0x002f:
            r8 = move-exception
        L_0x0030:
            r3 = r8
            r8 = 6
            java.lang.String r0 = "JobSchedulerCompat"
            boolean r8 = android.util.Log.isLoggable(r0, r8)
            if (r8 == 0) goto L_0x0045
            r0 = 6
            r5 = 7
            java.lang.String r1 = "JobSchedulerCompat"
            java.lang.String r2 = "myUserId invocation illegal"
            java.lang.String r4 = "com.google.android.gms.internal.measurement.zzbt"
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)
        L_0x0045:
            r8 = 0
        L_0x0046:
            java.lang.reflect.Method r0 = zza
            java.lang.String r1 = "com.google.android.gms"
            java.lang.String r3 = "UploadAlarm"
            if (r0 == 0) goto L_0x007b
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException -> 0x006f, InvocationTargetException -> 0x006d }
            r2[r11] = r9     // Catch:{ IllegalAccessException -> 0x006f, InvocationTargetException -> 0x006d }
            r4 = 1
            r2[r4] = r1     // Catch:{ IllegalAccessException -> 0x006f, InvocationTargetException -> 0x006d }
            r1 = 2
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ IllegalAccessException -> 0x006f, InvocationTargetException -> 0x006d }
            r2[r1] = r8     // Catch:{ IllegalAccessException -> 0x006f, InvocationTargetException -> 0x006d }
            r8 = 3
            r2[r8] = r3     // Catch:{ IllegalAccessException -> 0x006f, InvocationTargetException -> 0x006d }
            java.lang.Object r8 = r0.invoke(r10, r2)     // Catch:{ IllegalAccessException -> 0x006f, InvocationTargetException -> 0x006d }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ IllegalAccessException -> 0x006f, InvocationTargetException -> 0x006d }
            if (r8 == 0) goto L_0x007f
            int r11 = r8.intValue()     // Catch:{ IllegalAccessException -> 0x006f, InvocationTargetException -> 0x006d }
            goto L_0x007f
        L_0x006d:
            r8 = move-exception
            goto L_0x0070
        L_0x006f:
            r8 = move-exception
        L_0x0070:
            r5 = r8
            r2 = 6
            r7 = 10
            java.lang.String r4 = "error calling scheduleAsPackage"
            java.lang.String r6 = "com.google.android.gms.internal.measurement.zzbt"
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
        L_0x007b:
            int r11 = r10.schedule(r9)
        L_0x007f:
            return r11
        L_0x0080:
            int r8 = r10.schedule(r9)
            return r8
        L_0x0085:
            r8 = 0
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbt.zza(android.content.Context, android.app.job.JobInfo, java.lang.String, java.lang.String):int");
    }
}
