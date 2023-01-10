package com.google.android.gms.internal.instantapps;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zzfs {
    private static final Logger logger = Logger.getLogger(zzfs.class.getName());
    private static final Class<?> zzakl = zzbi.zzq();
    private static final boolean zzalq = zzeg();
    private static final Unsafe zzarm = zzef();
    private static final boolean zzati = zzj(Long.TYPE);
    private static final boolean zzatj = zzj(Integer.TYPE);
    private static final zzd zzatk;
    private static final boolean zzatl = zzeh();
    private static final long zzatm = ((long) zzh(byte[].class));
    private static final long zzatn;
    private static final long zzato;
    private static final long zzatp;
    private static final long zzatq;
    private static final long zzatr;
    private static final long zzats;
    private static final long zzatt;
    private static final long zzatu;
    private static final long zzatv;
    private static final long zzatw;
    private static final long zzatx = ((long) zzh(Object[].class));
    private static final long zzaty = ((long) zzi(Object[].class));
    private static final long zzatz;
    private static final int zzaua = ((int) (zzatm & 7));
    static final boolean zzaub = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    private zzfs() {
    }

    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzy(Object obj, long j) {
            if (zzfs.zzaub) {
                return zzfs.zzq(obj, j);
            }
            return zzfs.zzr(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzfs.zzaub) {
                zzfs.zza(obj, j, b);
            } else {
                zzfs.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            if (zzfs.zzaub) {
                return zzfs.zzs(obj, j);
            }
            return zzfs.zzt(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzfs.zzaub) {
                zzfs.zzb(obj, j, z);
            } else {
                zzfs.zzc(obj, j, z);
            }
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzy(Object obj, long j) {
            return this.zzaue.getByte(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            this.zzaue.putByte(obj, j, b);
        }

        public final boolean zzm(Object obj, long j) {
            return this.zzaue.getBoolean(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zzaue.putBoolean(obj, j, z);
        }

        public final float zzn(Object obj, long j) {
            return this.zzaue.getFloat(obj, j);
        }

        public final void zza(Object obj, long j, float f) {
            this.zzaue.putFloat(obj, j, f);
        }

        public final double zzo(Object obj, long j) {
            return this.zzaue.getDouble(obj, j);
        }

        public final void zza(Object obj, long j, double d) {
            this.zzaue.putDouble(obj, j, d);
        }
    }

    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzy(Object obj, long j) {
            if (zzfs.zzaub) {
                return zzfs.zzq(obj, j);
            }
            return zzfs.zzr(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzfs.zzaub) {
                zzfs.zza(obj, j, b);
            } else {
                zzfs.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            if (zzfs.zzaub) {
                return zzfs.zzs(obj, j);
            }
            return zzfs.zzt(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzfs.zzaub) {
                zzfs.zzb(obj, j, z);
            } else {
                zzfs.zzc(obj, j, z);
            }
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    static boolean zzed() {
        return zzalq;
    }

    static abstract class zzd {
        Unsafe zzaue;

        zzd(Unsafe unsafe) {
            this.zzaue = unsafe;
        }

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zze(Object obj, long j, byte b);

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);

        public final int zzk(Object obj, long j) {
            return this.zzaue.getInt(obj, j);
        }

        public final void zzb(Object obj, long j, int i) {
            this.zzaue.putInt(obj, j, i);
        }

        public final long zzl(Object obj, long j) {
            return this.zzaue.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzaue.putLong(obj, j, j2);
        }
    }

    static boolean zzee() {
        return zzatl;
    }

    static <T> T zzg(Class<T> cls) {
        try {
            return zzarm.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzh(Class<?> cls) {
        if (zzalq) {
            return zzatk.zzaue.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzi(Class<?> cls) {
        if (zzalq) {
            return zzatk.zzaue.arrayIndexScale(cls);
        }
        return -1;
    }

    static int zzk(Object obj, long j) {
        return zzatk.zzk(obj, j);
    }

    static void zzb(Object obj, long j, int i) {
        zzatk.zzb(obj, j, i);
    }

    static long zzl(Object obj, long j) {
        return zzatk.zzl(obj, j);
    }

    static void zza(Object obj, long j, long j2) {
        zzatk.zza(obj, j, j2);
    }

    static boolean zzm(Object obj, long j) {
        return zzatk.zzm(obj, j);
    }

    static void zza(Object obj, long j, boolean z) {
        zzatk.zza(obj, j, z);
    }

    static float zzn(Object obj, long j) {
        return zzatk.zzn(obj, j);
    }

    static void zza(Object obj, long j, float f) {
        zzatk.zza(obj, j, f);
    }

    static double zzo(Object obj, long j) {
        return zzatk.zzo(obj, j);
    }

    static void zza(Object obj, long j, double d) {
        zzatk.zza(obj, j, d);
    }

    static Object zzp(Object obj, long j) {
        return zzatk.zzaue.getObject(obj, j);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzatk.zzaue.putObject(obj, j, obj2);
    }

    static byte zza(byte[] bArr, long j) {
        return zzatk.zzy(bArr, zzatm + j);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzatk.zze(bArr, zzatm + j, b);
    }

    static Unsafe zzef() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzfu());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzeg() {
        Unsafe unsafe = zzarm;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
            cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
            if (zzbi.zzp()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});
            cls.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});
            cls.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});
            cls.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzeh() {
        Unsafe unsafe = zzarm;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            if (zzei() == null) {
                return false;
            }
            if (zzbi.zzp()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Long.TYPE});
            cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
            cls.getMethod("getInt", new Class[]{Long.TYPE});
            cls.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Long.TYPE});
            cls.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzj(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!zzbi.zzp()) {
            return false;
        }
        try {
            Class<?> cls3 = zzakl;
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

    private static Field zzei() {
        Field zzb2;
        if (zzbi.zzp() && (zzb2 = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
            return zzb2;
        }
        Field zzb3 = zzb(Buffer.class, "address");
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) (((~j) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzr(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int zzk = zzk(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk(obj, j2) & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzt(Object obj, long j) {
        return zzr(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00d2, code lost:
        r1 = zzatk;
     */
    static {
        /*
            java.lang.Class<double[]> r0 = double[].class
            java.lang.Class<float[]> r1 = float[].class
            java.lang.Class<long[]> r2 = long[].class
            java.lang.Class<int[]> r3 = int[].class
            java.lang.Class<boolean[]> r4 = boolean[].class
            java.lang.Class<com.google.android.gms.internal.instantapps.zzfs> r5 = com.google.android.gms.internal.instantapps.zzfs.class
            java.lang.String r5 = r5.getName()
            java.util.logging.Logger r5 = java.util.logging.Logger.getLogger(r5)
            logger = r5
            sun.misc.Unsafe r5 = zzef()
            zzarm = r5
            java.lang.Class r5 = com.google.android.gms.internal.instantapps.zzbi.zzq()
            zzakl = r5
            java.lang.Class r5 = java.lang.Long.TYPE
            boolean r5 = zzj(r5)
            zzati = r5
            java.lang.Class r5 = java.lang.Integer.TYPE
            boolean r5 = zzj(r5)
            zzatj = r5
            sun.misc.Unsafe r5 = zzarm
            r6 = 0
            if (r5 != 0) goto L_0x0038
            goto L_0x005d
        L_0x0038:
            boolean r5 = com.google.android.gms.internal.instantapps.zzbi.zzp()
            if (r5 == 0) goto L_0x0056
            boolean r5 = zzati
            if (r5 == 0) goto L_0x004a
            com.google.android.gms.internal.instantapps.zzfs$zzc r6 = new com.google.android.gms.internal.instantapps.zzfs$zzc
            sun.misc.Unsafe r5 = zzarm
            r6.<init>(r5)
            goto L_0x005d
        L_0x004a:
            boolean r5 = zzatj
            if (r5 == 0) goto L_0x005d
            com.google.android.gms.internal.instantapps.zzfs$zza r6 = new com.google.android.gms.internal.instantapps.zzfs$zza
            sun.misc.Unsafe r5 = zzarm
            r6.<init>(r5)
            goto L_0x005d
        L_0x0056:
            com.google.android.gms.internal.instantapps.zzfs$zzb r6 = new com.google.android.gms.internal.instantapps.zzfs$zzb
            sun.misc.Unsafe r5 = zzarm
            r6.<init>(r5)
        L_0x005d:
            zzatk = r6
            boolean r5 = zzeh()
            zzatl = r5
            boolean r5 = zzeg()
            zzalq = r5
            java.lang.Class<byte[]> r5 = byte[].class
            int r5 = zzh(r5)
            long r5 = (long) r5
            zzatm = r5
            int r5 = zzh(r4)
            long r5 = (long) r5
            zzatn = r5
            int r4 = zzi(r4)
            long r4 = (long) r4
            zzato = r4
            int r4 = zzh(r3)
            long r4 = (long) r4
            zzatp = r4
            int r3 = zzi(r3)
            long r3 = (long) r3
            zzatq = r3
            int r3 = zzh(r2)
            long r3 = (long) r3
            zzatr = r3
            int r2 = zzi(r2)
            long r2 = (long) r2
            zzats = r2
            int r2 = zzh(r1)
            long r2 = (long) r2
            zzatt = r2
            int r1 = zzi(r1)
            long r1 = (long) r1
            zzatu = r1
            int r1 = zzh(r0)
            long r1 = (long) r1
            zzatv = r1
            int r0 = zzi(r0)
            long r0 = (long) r0
            zzatw = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzatx = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = zzi(r0)
            long r0 = (long) r0
            zzaty = r0
            java.lang.reflect.Field r0 = zzei()
            if (r0 == 0) goto L_0x00de
            com.google.android.gms.internal.instantapps.zzfs$zzd r1 = zzatk
            if (r1 != 0) goto L_0x00d7
            goto L_0x00de
        L_0x00d7:
            sun.misc.Unsafe r1 = r1.zzaue
            long r0 = r1.objectFieldOffset(r0)
            goto L_0x00e0
        L_0x00de:
            r0 = -1
        L_0x00e0:
            zzatz = r0
            long r0 = zzatm
            r2 = 7
            long r0 = r0 & r2
            int r1 = (int) r0
            zzaua = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x00f4
            r0 = 1
            goto L_0x00f5
        L_0x00f4:
            r0 = 0
        L_0x00f5:
            zzaub = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.instantapps.zzfs.<clinit>():void");
    }
}
