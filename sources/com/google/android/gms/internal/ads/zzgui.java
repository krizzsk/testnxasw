package com.google.android.gms.internal.ads;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgui {
    static final long zza = ((long) zzC(byte[].class));
    static final boolean zzb;
    private static final Unsafe zzc = zzi();
    private static final Class zzd = zzgph.zza();
    private static final boolean zze = zzy(Long.TYPE);
    private static final zzguh zzf;
    private static final boolean zzg;
    private static final boolean zzh;
    private static final long zzi;

    /* JADX WARNING: Removed duplicated region for block: B:20:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x015c  */
    static {
        /*
            java.lang.Class<double[]> r0 = double[].class
            java.lang.Class<float[]> r1 = float[].class
            java.lang.Class<long[]> r2 = long[].class
            java.lang.Class<int[]> r3 = int[].class
            java.lang.Class<boolean[]> r4 = boolean[].class
            sun.misc.Unsafe r5 = zzi()
            zzc = r5
            java.lang.Class r5 = com.google.android.gms.internal.ads.zzgph.zza()
            zzd = r5
            java.lang.Class r5 = java.lang.Long.TYPE
            boolean r5 = zzy(r5)
            zze = r5
            java.lang.Class r5 = java.lang.Integer.TYPE
            boolean r5 = zzy(r5)
            sun.misc.Unsafe r6 = zzc
            r7 = 0
            if (r6 != 0) goto L_0x002a
            goto L_0x003b
        L_0x002a:
            boolean r8 = zze
            if (r8 == 0) goto L_0x0034
            com.google.android.gms.internal.ads.zzgug r7 = new com.google.android.gms.internal.ads.zzgug
            r7.<init>(r6)
            goto L_0x003b
        L_0x0034:
            if (r5 == 0) goto L_0x003b
            com.google.android.gms.internal.ads.zzguf r7 = new com.google.android.gms.internal.ads.zzguf
            r7.<init>(r6)
        L_0x003b:
            zzf = r7
            java.lang.String r5 = "getLong"
            java.lang.String r6 = "objectFieldOffset"
            r8 = 2
            r9 = 1
            r10 = 0
            if (r7 != 0) goto L_0x0048
        L_0x0046:
            r7 = 0
            goto L_0x0072
        L_0x0048:
            sun.misc.Unsafe r7 = r7.zza
            java.lang.Class r7 = r7.getClass()     // Catch:{ all -> 0x006d }
            java.lang.Class[] r11 = new java.lang.Class[r9]     // Catch:{ all -> 0x006d }
            java.lang.Class<java.lang.reflect.Field> r12 = java.lang.reflect.Field.class
            r11[r10] = r12     // Catch:{ all -> 0x006d }
            r7.getMethod(r6, r11)     // Catch:{ all -> 0x006d }
            java.lang.Class[] r11 = new java.lang.Class[r8]     // Catch:{ all -> 0x006d }
            java.lang.Class<java.lang.Object> r12 = java.lang.Object.class
            r11[r10] = r12     // Catch:{ all -> 0x006d }
            java.lang.Class r12 = java.lang.Long.TYPE     // Catch:{ all -> 0x006d }
            r11[r9] = r12     // Catch:{ all -> 0x006d }
            r7.getMethod(r5, r11)     // Catch:{ all -> 0x006d }
            java.lang.reflect.Field r7 = zzE()     // Catch:{ all -> 0x006d }
            if (r7 != 0) goto L_0x006b
            goto L_0x0046
        L_0x006b:
            r7 = 1
            goto L_0x0072
        L_0x006d:
            r7 = move-exception
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.ads.zzgui.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r7.toString()))
            goto L_0x0046
        L_0x0072:
            zzg = r7
            com.google.android.gms.internal.ads.zzguh r7 = zzf
            if (r7 != 0) goto L_0x007b
        L_0x0078:
            r5 = 0
            goto L_0x010d
        L_0x007b:
            sun.misc.Unsafe r7 = r7.zza
            java.lang.Class r7 = r7.getClass()     // Catch:{ all -> 0x0107 }
            java.lang.Class[] r11 = new java.lang.Class[r9]     // Catch:{ all -> 0x0107 }
            java.lang.Class<java.lang.reflect.Field> r12 = java.lang.reflect.Field.class
            r11[r10] = r12     // Catch:{ all -> 0x0107 }
            r7.getMethod(r6, r11)     // Catch:{ all -> 0x0107 }
            java.lang.Class[] r6 = new java.lang.Class[r9]     // Catch:{ all -> 0x0107 }
            java.lang.Class<java.lang.Class> r11 = java.lang.Class.class
            r6[r10] = r11     // Catch:{ all -> 0x0107 }
            java.lang.String r11 = "arrayBaseOffset"
            r7.getMethod(r11, r6)     // Catch:{ all -> 0x0107 }
            java.lang.Class[] r6 = new java.lang.Class[r9]     // Catch:{ all -> 0x0107 }
            java.lang.Class<java.lang.Class> r11 = java.lang.Class.class
            r6[r10] = r11     // Catch:{ all -> 0x0107 }
            java.lang.String r11 = "arrayIndexScale"
            r7.getMethod(r11, r6)     // Catch:{ all -> 0x0107 }
            java.lang.Class[] r6 = new java.lang.Class[r8]     // Catch:{ all -> 0x0107 }
            java.lang.Class<java.lang.Object> r11 = java.lang.Object.class
            r6[r10] = r11     // Catch:{ all -> 0x0107 }
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x0107 }
            r6[r9] = r11     // Catch:{ all -> 0x0107 }
            java.lang.String r11 = "getInt"
            r7.getMethod(r11, r6)     // Catch:{ all -> 0x0107 }
            r6 = 3
            java.lang.Class[] r11 = new java.lang.Class[r6]     // Catch:{ all -> 0x0107 }
            java.lang.Class<java.lang.Object> r12 = java.lang.Object.class
            r11[r10] = r12     // Catch:{ all -> 0x0107 }
            java.lang.Class r12 = java.lang.Long.TYPE     // Catch:{ all -> 0x0107 }
            r11[r9] = r12     // Catch:{ all -> 0x0107 }
            java.lang.Class r12 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0107 }
            r11[r8] = r12     // Catch:{ all -> 0x0107 }
            java.lang.String r12 = "putInt"
            r7.getMethod(r12, r11)     // Catch:{ all -> 0x0107 }
            java.lang.Class[] r11 = new java.lang.Class[r8]     // Catch:{ all -> 0x0107 }
            java.lang.Class<java.lang.Object> r12 = java.lang.Object.class
            r11[r10] = r12     // Catch:{ all -> 0x0107 }
            java.lang.Class r12 = java.lang.Long.TYPE     // Catch:{ all -> 0x0107 }
            r11[r9] = r12     // Catch:{ all -> 0x0107 }
            r7.getMethod(r5, r11)     // Catch:{ all -> 0x0107 }
            java.lang.Class[] r5 = new java.lang.Class[r6]     // Catch:{ all -> 0x0107 }
            java.lang.Class<java.lang.Object> r11 = java.lang.Object.class
            r5[r10] = r11     // Catch:{ all -> 0x0107 }
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x0107 }
            r5[r9] = r11     // Catch:{ all -> 0x0107 }
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x0107 }
            r5[r8] = r11     // Catch:{ all -> 0x0107 }
            java.lang.String r11 = "putLong"
            r7.getMethod(r11, r5)     // Catch:{ all -> 0x0107 }
            java.lang.Class[] r5 = new java.lang.Class[r8]     // Catch:{ all -> 0x0107 }
            java.lang.Class<java.lang.Object> r11 = java.lang.Object.class
            r5[r10] = r11     // Catch:{ all -> 0x0107 }
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x0107 }
            r5[r9] = r11     // Catch:{ all -> 0x0107 }
            java.lang.String r11 = "getObject"
            r7.getMethod(r11, r5)     // Catch:{ all -> 0x0107 }
            java.lang.Class[] r5 = new java.lang.Class[r6]     // Catch:{ all -> 0x0107 }
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            r5[r10] = r6     // Catch:{ all -> 0x0107 }
            java.lang.Class r6 = java.lang.Long.TYPE     // Catch:{ all -> 0x0107 }
            r5[r9] = r6     // Catch:{ all -> 0x0107 }
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            r5[r8] = r6     // Catch:{ all -> 0x0107 }
            java.lang.String r6 = "putObject"
            r7.getMethod(r6, r5)     // Catch:{ all -> 0x0107 }
            r5 = 1
            goto L_0x010d
        L_0x0107:
            r5 = move-exception
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.ads.zzgui.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r5.toString()))
            goto L_0x0078
        L_0x010d:
            zzh = r5
            java.lang.Class<byte[]> r5 = byte[].class
            int r5 = zzC(r5)
            long r5 = (long) r5
            zza = r5
            zzC(r4)
            zzD(r4)
            zzC(r3)
            zzD(r3)
            zzC(r2)
            zzD(r2)
            zzC(r1)
            zzD(r1)
            zzC(r0)
            zzD(r0)
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            zzC(r0)
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            zzD(r0)
            java.lang.reflect.Field r0 = zzE()
            r1 = -1
            if (r0 == 0) goto L_0x0151
            com.google.android.gms.internal.ads.zzguh r3 = zzf
            if (r3 != 0) goto L_0x014d
            goto L_0x0151
        L_0x014d:
            long r1 = r3.zzn(r0)
        L_0x0151:
            zzi = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x015c
            goto L_0x015d
        L_0x015c:
            r9 = 0
        L_0x015d:
            zzb = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgui.<clinit>():void");
    }

    private zzgui() {
    }

    static boolean zzA() {
        return zzh;
    }

    static boolean zzB() {
        return zzg;
    }

    private static int zzC(Class cls) {
        if (zzh) {
            return zzf.zzj(cls);
        }
        return -1;
    }

    private static int zzD(Class cls) {
        if (zzh) {
            return zzf.zzk(cls);
        }
        return -1;
    }

    private static Field zzE() {
        int i = zzgph.zza;
        Field zzF = zzF(Buffer.class, "effectiveDirectAddress");
        if (zzF != null) {
            return zzF;
        }
        Field zzF2 = zzF(Buffer.class, "address");
        if (zzF2 == null || zzF2.getType() != Long.TYPE) {
            return null;
        }
        return zzF2;
    }

    private static Field zzF(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void zzG(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int zzl = zzf.zzl(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zzf.zzp(obj, j2, ((b & 255) << i) | (zzl & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static void zzH(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        int i2 = (b & 255) << i;
        zzf.zzp(obj, j2, i2 | (zzf.zzl(obj, j2) & (~(255 << i))));
    }

    static byte zza(long j) {
        return zzf.zza(j);
    }

    static double zzb(Object obj, long j) {
        return zzf.zzb(obj, j);
    }

    static float zzc(Object obj, long j) {
        return zzf.zzc(obj, j);
    }

    static int zzd(Object obj, long j) {
        return zzf.zzl(obj, j);
    }

    static long zze(ByteBuffer byteBuffer) {
        return zzf.zzm(byteBuffer, zzi);
    }

    static long zzf(Object obj, long j) {
        return zzf.zzm(obj, j);
    }

    static Object zzg(Class cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    static Object zzh(Object obj, long j) {
        return zzf.zzo(obj, j);
    }

    static Unsafe zzi() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzgue());
        } catch (Throwable unused) {
            return null;
        }
    }

    static void zzo(long j, byte[] bArr, long j2, long j3) {
        zzf.zzd(j, bArr, j2, j3);
    }

    static void zzp(Object obj, long j, boolean z) {
        zzf.zze(obj, j, z);
    }

    static void zzq(byte[] bArr, long j, byte b) {
        zzf.zzf(bArr, zza + j, b);
    }

    static void zzr(Object obj, long j, double d) {
        zzf.zzg(obj, j, d);
    }

    static void zzs(Object obj, long j, float f) {
        zzf.zzh(obj, j, f);
    }

    static void zzt(Object obj, long j, int i) {
        zzf.zzp(obj, j, i);
    }

    static void zzu(Object obj, long j, long j2) {
        zzf.zzq(obj, j, j2);
    }

    static void zzv(Object obj, long j, Object obj2) {
        zzf.zzr(obj, j, obj2);
    }

    static /* synthetic */ boolean zzw(Object obj, long j) {
        return ((byte) ((zzf.zzl(obj, -4 & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    static /* synthetic */ boolean zzx(Object obj, long j) {
        return ((byte) ((zzf.zzl(obj, -4 & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    static boolean zzy(Class cls) {
        Class<byte[]> cls2 = byte[].class;
        int i = zzgph.zza;
        try {
            Class cls3 = zzd;
            cls3.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls3.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls3.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static boolean zzz(Object obj, long j) {
        return zzf.zzi(obj, j);
    }
}
