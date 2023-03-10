package com.google.android.gms.internal.instantapps;

import com.google.android.gms.internal.instantapps.zzcx;
import com.google.android.gms.internal.instantapps.zzcx.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzcx<MessageType extends zzcx<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzbe<MessageType, BuilderType> {
    private static Map<Object, zzcx<?, ?>> zzape = new ConcurrentHashMap();
    protected zzfp zzapc = zzfp.zzea();
    private int zzapd = -1;

    public static class zzc<T extends zzcx<T, ?>> extends zzbg<T> {
        private final T zzaoz;

        public zzc(T t) {
            this.zzaoz = t;
        }
    }

    /* 'enum' modifier removed */
    public static final class zzd {
        public static final int zzapg = 1;
        public static final int zzaph = 2;
        public static final int zzapi = 3;
        public static final int zzapj = 4;
        public static final int zzapk = 5;
        public static final int zzapl = 6;
        public static final int zzapm = 7;
        private static final /* synthetic */ int[] zzapn = {1, 2, 3, 4, 5, 6, 7};
        public static final int zzapo = 1;
        public static final int zzapp = 2;
        private static final /* synthetic */ int[] zzapq = {1, 2};
        public static final int zzapr = 1;
        public static final int zzaps = 2;
        private static final /* synthetic */ int[] zzapt = {1, 2};

        public static int[] zzce() {
            return (int[]) zzapn.clone();
        }
    }

    public static class zze<ContainingType extends zzef, Type> extends zzci<ContainingType, Type> {
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    public static abstract class zzb<MessageType extends zzb<MessageType, BuilderType>, BuilderType> extends zzcx<MessageType, BuilderType> implements zzeh {
        protected zzcq<Object> zzapf = zzcq.zzbl();

        /* access modifiers changed from: package-private */
        public final zzcq<Object> zzcd() {
            if (this.zzapf.isImmutable()) {
                this.zzapf = (zzcq) this.zzapf.clone();
            }
            return this.zzapf;
        }
    }

    public String toString() {
        return zzeg.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zzakh != 0) {
            return this.zzakh;
        }
        this.zzakh = zzeq.zzdi().zzp(this).hashCode(this);
        return this.zzakh;
    }

    public static abstract class zza<MessageType extends zzcx<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzbh<MessageType, BuilderType> {
        private final MessageType zzaoz;
        protected MessageType zzapa;
        private boolean zzapb = false;

        protected zza(MessageType messagetype) {
            this.zzaoz = messagetype;
            this.zzapa = (zzcx) messagetype.zza(zzd.zzapj, (Object) null, (Object) null);
        }

        /* access modifiers changed from: protected */
        public final void zzbs() {
            if (this.zzapb) {
                MessageType messagetype = (zzcx) this.zzapa.zza(zzd.zzapj, (Object) null, (Object) null);
                zza(messagetype, this.zzapa);
                this.zzapa = messagetype;
                this.zzapb = false;
            }
        }

        public final boolean isInitialized() {
            return zzcx.zza(this.zzapa, false);
        }

        /* renamed from: zzbt */
        public MessageType zzbv() {
            if (this.zzapb) {
                return this.zzapa;
            }
            MessageType messagetype = this.zzapa;
            zzeq.zzdi().zzp(messagetype).zzc(messagetype);
            this.zzapb = true;
            return this.zzapa;
        }

        /* renamed from: zzbu */
        public final MessageType zzbw() {
            MessageType messagetype = (zzcx) zzbv();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzfn(messagetype);
        }

        public final BuilderType zza(MessageType messagetype) {
            zzbs();
            zza(this.zzapa, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzeq.zzdi().zzp(messagetype).zzc(messagetype, messagetype2);
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzck zzck) throws zzdf {
            zzbs();
            try {
                zzeq.zzdi().zzp(this.zzapa).zza(this.zzapa, bArr, 0, i2 + 0, new zzbk(zzck));
                return this;
            } catch (zzdf e) {
                throw e;
            } catch (IndexOutOfBoundsException unused) {
                throw zzdf.zzcf();
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: zzb */
        public final BuilderType zza(zzcb zzcb, zzck zzck) throws IOException {
            zzbs();
            try {
                zzeq.zzdi().zzp(this.zzapa).zza(this.zzapa, zzcc.zza(zzcb), zzck);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        public final /* synthetic */ zzbh zza(byte[] bArr, int i, int i2, zzck zzck) throws zzdf {
            return zzb(bArr, 0, i2, zzck);
        }

        public final /* synthetic */ zzbh zzo() {
            return (zza) clone();
        }

        public final /* synthetic */ zzef zzbx() {
            return this.zzaoz;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza = (zza) ((zzcx) this.zzaoz).zza(zzd.zzapk, (Object) null, (Object) null);
            zza.zza((zzcx) zzbv());
            return zza;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzcx) zza(zzd.zzapl, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzeq.zzdi().zzp(this).equals(this, (zzcx) obj);
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzcx<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzby() {
        return (zza) zza(zzd.zzapk, (Object) null, (Object) null);
    }

    public final boolean isInitialized() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    /* access modifiers changed from: package-private */
    public final int zzn() {
        return this.zzapd;
    }

    /* access modifiers changed from: package-private */
    public final void zze(int i) {
        this.zzapd = i;
    }

    public final void zzb(zzce zzce) throws IOException {
        zzeq.zzdi().zze(getClass()).zza(this, zzch.zza(zzce));
    }

    public final int zzbz() {
        if (this.zzapd == -1) {
            this.zzapd = zzeq.zzdi().zzp(this).zzm(this);
        }
        return this.zzapd;
    }

    static <T extends zzcx<?, ?>> T zzc(Class<T> cls) {
        T t = (zzcx) zzape.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzcx) zzape.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzcx) ((zzcx) zzfs.zzg(cls)).zza(zzd.zzapl, (Object) null, (Object) null);
            if (t != null) {
                zzape.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzcx<?, ?>> void zza(Class<T> cls, T t) {
        zzape.put(cls, t);
    }

    protected static Object zza(zzef zzef, String str, Object[] objArr) {
        return new zzes(zzef, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static final <T extends zzcx<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zzd.zzapg, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzo = zzeq.zzdi().zzp(t).zzo(t);
        if (z) {
            t.zza(zzd.zzaph, (Object) zzo ? t : null, (Object) null);
        }
        return zzo;
    }

    protected static <E> zzdc<E> zzca() {
        return zzet.zzdl();
    }

    public final /* synthetic */ zzee zzcb() {
        zza zza2 = (zza) zza(zzd.zzapk, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    public final /* synthetic */ zzee zzcc() {
        return (zza) zza(zzd.zzapk, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzef zzbx() {
        return (zzcx) zza(zzd.zzapl, (Object) null, (Object) null);
    }
}
