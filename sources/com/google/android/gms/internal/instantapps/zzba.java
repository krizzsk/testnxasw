package com.google.android.gms.internal.instantapps;

import com.google.android.gms.internal.instantapps.zzbc;
import com.google.android.gms.internal.instantapps.zzcx;

public final class zzba {

    public static final class zza extends zzcx<zza, C22236zza> implements zzeh {
        /* access modifiers changed from: private */
        public static final zza zzcv;
        private static volatile zzeo<zza> zzcw;
        private zzdc<zzb> zzcu = zzca();

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.instantapps.zzba$zza$zza  reason: collision with other inner class name */
        public static final class C22236zza extends zzcx.zza<zza, C22236zza> implements zzeh {
            private C22236zza() {
                super(zza.zzcv);
            }

            public final int zzd() {
                return ((zza) this.zzapa).zzd();
            }

            public final C22236zza zza(zzb zzb) {
                zzbs();
                ((zza) this.zzapa).zzb(zzb);
                return this;
            }

            public final C22236zza zza(int i, zzb zzb) {
                zzbs();
                ((zza) this.zzapa).zzb(i, zzb);
                return this;
            }

            /* synthetic */ C22236zza(zzaz zzaz) {
                this();
            }
        }

        public final int zzd() {
            return this.zzcu.size();
        }

        private final void zze() {
            if (!this.zzcu.zzr()) {
                zzdc<zzb> zzdc = this.zzcu;
                int size = zzdc.size();
                this.zzcu = zzdc.zzi(size == 0 ? 10 : size << 1);
            }
        }

        /* access modifiers changed from: private */
        public final void zzb(zzb zzb) {
            if (zzb != null) {
                zze();
                this.zzcu.add(zzb);
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public final void zzb(int i, zzb zzb) {
            if (zzb != null) {
                zze();
                this.zzcu.add(i, zzb);
                return;
            }
            throw null;
        }

        public static C22236zza zzf() {
            return (C22236zza) zzcv.zzby();
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.instantapps.zzcx$zzc, com.google.android.gms.internal.instantapps.zzeo<com.google.android.gms.internal.instantapps.zzba$zza>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzeo<zza> zzeo;
            switch (zzaz.zzct[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C22236zza((zzaz) null);
                case 3:
                    return zza((zzef) zzcv, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzcu", zzb.class});
                case 4:
                    return zzcv;
                case 5:
                    zzeo<zza> zzeo2 = zzcw;
                    zzeo<zza> zzeo3 = zzeo2;
                    if (zzeo2 == null) {
                        synchronized (zza.class) {
                            zzeo<zza> zzeo4 = zzcw;
                            zzeo = zzeo4;
                            if (zzeo4 == null) {
                                ? zzc = new zzcx.zzc(zzcv);
                                zzcw = zzc;
                                zzeo = zzc;
                            }
                        }
                        zzeo3 = zzeo;
                    }
                    return zzeo3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zza zza = new zza();
            zzcv = zza;
            zzcx.zza(zza.class, zza);
        }
    }

    public static final class zzb extends zzcx<zzb, zza> implements zzeh {
        private static volatile zzeo<zzb> zzcw;
        /* access modifiers changed from: private */
        public static final zzb zzda;
        private int zzcx;
        private int zzcy;
        private long zzcz;

        private zzb() {
        }

        public static final class zza extends zzcx.zza<zzb, zza> implements zzeh {
            private zza() {
                super(zzb.zzda);
            }

            public final zza zzb(zzbc.zza.zzb zzb) {
                zzbs();
                ((zzb) this.zzapa).zzc(zzb);
                return this;
            }

            public final zza zza(long j) {
                zzbs();
                ((zzb) this.zzapa).zzb(j);
                return this;
            }

            /* synthetic */ zza(zzaz zzaz) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzc(zzbc.zza.zzb zzb) {
            if (zzb != null) {
                this.zzcx |= 1;
                this.zzcy = zzb.zzk();
                return;
            }
            throw null;
        }

        /* access modifiers changed from: private */
        public final void zzb(long j) {
            this.zzcx |= 2;
            this.zzcz = j;
        }

        public static zza zzh() {
            return (zza) zzda.zzby();
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.instantapps.zzcx$zzc, com.google.android.gms.internal.instantapps.zzeo<com.google.android.gms.internal.instantapps.zzba$zzb>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzeo<zzb> zzeo;
            switch (zzaz.zzct[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzaz) null);
                case 3:
                    return zza((zzef) zzda, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\u0002\u0001", new Object[]{"zzcx", "zzcy", zzbc.zza.zzb.zzl(), "zzcz"});
                case 4:
                    return zzda;
                case 5:
                    zzeo<zzb> zzeo2 = zzcw;
                    zzeo<zzb> zzeo3 = zzeo2;
                    if (zzeo2 == null) {
                        synchronized (zzb.class) {
                            zzeo<zzb> zzeo4 = zzcw;
                            zzeo = zzeo4;
                            if (zzeo4 == null) {
                                ? zzc = new zzcx.zzc(zzda);
                                zzcw = zzc;
                                zzeo = zzc;
                            }
                        }
                        zzeo3 = zzeo;
                    }
                    return zzeo3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzb zzb = new zzb();
            zzda = zzb;
            zzcx.zza(zzb.class, zzb);
        }
    }
}
