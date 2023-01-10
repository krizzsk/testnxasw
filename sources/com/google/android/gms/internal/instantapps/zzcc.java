package com.google.android.gms.internal.instantapps;

import java.io.IOException;
import java.util.List;

final class zzcc implements zzev {
    private int tag;
    private final zzcb zzali;
    private int zzalj;
    private int zzalk = 0;

    public static zzcc zza(zzcb zzcb) {
        if (zzcb.zzalg != null) {
            return zzcb.zzalg;
        }
        return new zzcc(zzcb);
    }

    private zzcc(zzcb zzcb) {
        zzcb zzcb2 = (zzcb) zzcy.zza(zzcb, "input");
        this.zzali = zzcb2;
        zzcb2.zzalg = this;
    }

    public final int zzas() throws IOException {
        int i = this.zzalk;
        if (i != 0) {
            this.tag = i;
            this.zzalk = 0;
        } else {
            this.tag = this.zzali.zzaa();
        }
        int i2 = this.tag;
        if (i2 == 0 || i2 == this.zzalj) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    public final int getTag() {
        return this.tag;
    }

    public final boolean zzat() throws IOException {
        int i;
        if (this.zzali.zzaq() || (i = this.tag) == this.zzalj) {
            return false;
        }
        return this.zzali.zzn(i);
    }

    private final void zzr(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzdf.zzck();
        }
    }

    public final double readDouble() throws IOException {
        zzr(1);
        return this.zzali.readDouble();
    }

    public final float readFloat() throws IOException {
        zzr(5);
        return this.zzali.readFloat();
    }

    public final long zzab() throws IOException {
        zzr(0);
        return this.zzali.zzab();
    }

    public final long zzac() throws IOException {
        zzr(0);
        return this.zzali.zzac();
    }

    public final int zzad() throws IOException {
        zzr(0);
        return this.zzali.zzad();
    }

    public final long zzae() throws IOException {
        zzr(1);
        return this.zzali.zzae();
    }

    public final int zzaf() throws IOException {
        zzr(5);
        return this.zzali.zzaf();
    }

    public final boolean zzag() throws IOException {
        zzr(0);
        return this.zzali.zzag();
    }

    public final String readString() throws IOException {
        zzr(2);
        return this.zzali.readString();
    }

    public final String zzah() throws IOException {
        zzr(2);
        return this.zzali.zzah();
    }

    public final <T> T zza(zzeu<T> zzeu, zzck zzck) throws IOException {
        zzr(2);
        return zzc(zzeu, zzck);
    }

    public final <T> T zzb(zzeu<T> zzeu, zzck zzck) throws IOException {
        zzr(3);
        return zzd(zzeu, zzck);
    }

    private final <T> T zzc(zzeu<T> zzeu, zzck zzck) throws IOException {
        int zzaj = this.zzali.zzaj();
        if (this.zzali.zzald < this.zzali.zzale) {
            int zzo = this.zzali.zzo(zzaj);
            T newInstance = zzeu.newInstance();
            this.zzali.zzald++;
            zzeu.zza(newInstance, this, zzck);
            zzeu.zzc(newInstance);
            this.zzali.zzm(0);
            zzcb zzcb = this.zzali;
            zzcb.zzald--;
            this.zzali.zzp(zzo);
            return newInstance;
        }
        throw new zzdf("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final <T> T zzd(zzeu<T> zzeu, zzck zzck) throws IOException {
        int i = this.zzalj;
        this.zzalj = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzeu.newInstance();
            zzeu.zza(newInstance, this, zzck);
            zzeu.zzc(newInstance);
            if (this.tag == this.zzalj) {
                return newInstance;
            }
            throw zzdf.zzcl();
        } finally {
            this.zzalj = i;
        }
    }

    public final zzbp zzai() throws IOException {
        zzr(2);
        return this.zzali.zzai();
    }

    public final int zzaj() throws IOException {
        zzr(0);
        return this.zzali.zzaj();
    }

    public final int zzak() throws IOException {
        zzr(0);
        return this.zzali.zzak();
    }

    public final int zzal() throws IOException {
        zzr(5);
        return this.zzali.zzal();
    }

    public final long zzam() throws IOException {
        zzr(1);
        return this.zzali.zzam();
    }

    public final int zzan() throws IOException {
        zzr(0);
        return this.zzali.zzan();
    }

    public final long zzao() throws IOException {
        zzr(0);
        return this.zzali.zzao();
    }

    public final void zza(List<Double> list) throws IOException {
        int zzaa;
        int zzaa2;
        if (list instanceof zzcj) {
            zzcj zzcj = (zzcj) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzcj.zzc(this.zzali.readDouble());
                    if (!this.zzali.zzaq()) {
                        zzaa2 = this.zzali.zzaa();
                    } else {
                        return;
                    }
                } while (zzaa2 == this.tag);
                this.zzalk = zzaa2;
            } else if (i == 2) {
                int zzaj = this.zzali.zzaj();
                zzs(zzaj);
                int zzar = this.zzali.zzar() + zzaj;
                do {
                    zzcj.zzc(this.zzali.readDouble());
                } while (this.zzali.zzar() < zzar);
            } else {
                throw zzdf.zzck();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.zzali.readDouble()));
                    if (!this.zzali.zzaq()) {
                        zzaa = this.zzali.zzaa();
                    } else {
                        return;
                    }
                } while (zzaa == this.tag);
                this.zzalk = zzaa;
            } else if (i2 == 2) {
                int zzaj2 = this.zzali.zzaj();
                zzs(zzaj2);
                int zzar2 = this.zzali.zzar() + zzaj2;
                do {
                    list.add(Double.valueOf(this.zzali.readDouble()));
                } while (this.zzali.zzar() < zzar2);
            } else {
                throw zzdf.zzck();
            }
        }
    }

    public final void zzb(List<Float> list) throws IOException {
        int zzaa;
        int zzaa2;
        if (list instanceof zzcw) {
            zzcw zzcw = (zzcw) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzaj = this.zzali.zzaj();
                zzt(zzaj);
                int zzar = this.zzali.zzar() + zzaj;
                do {
                    zzcw.zzc(this.zzali.readFloat());
                } while (this.zzali.zzar() < zzar);
            } else if (i == 5) {
                do {
                    zzcw.zzc(this.zzali.readFloat());
                    if (!this.zzali.zzaq()) {
                        zzaa2 = this.zzali.zzaa();
                    } else {
                        return;
                    }
                } while (zzaa2 == this.tag);
                this.zzalk = zzaa2;
            } else {
                throw zzdf.zzck();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzaj2 = this.zzali.zzaj();
                zzt(zzaj2);
                int zzar2 = this.zzali.zzar() + zzaj2;
                do {
                    list.add(Float.valueOf(this.zzali.readFloat()));
                } while (this.zzali.zzar() < zzar2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zzali.readFloat()));
                    if (!this.zzali.zzaq()) {
                        zzaa = this.zzali.zzaa();
                    } else {
                        return;
                    }
                } while (zzaa == this.tag);
                this.zzalk = zzaa;
            } else {
                throw zzdf.zzck();
            }
        }
    }

    public final void zzc(List<Long> list) throws IOException {
        int zzaa;
        int zzaa2;
        if (list instanceof zzdt) {
            zzdt zzdt = (zzdt) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzdt.zzn(this.zzali.zzab());
                    if (!this.zzali.zzaq()) {
                        zzaa2 = this.zzali.zzaa();
                    } else {
                        return;
                    }
                } while (zzaa2 == this.tag);
                this.zzalk = zzaa2;
            } else if (i == 2) {
                int zzar = this.zzali.zzar() + this.zzali.zzaj();
                do {
                    zzdt.zzn(this.zzali.zzab());
                } while (this.zzali.zzar() < zzar);
                zzu(zzar);
            } else {
                throw zzdf.zzck();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzali.zzab()));
                    if (!this.zzali.zzaq()) {
                        zzaa = this.zzali.zzaa();
                    } else {
                        return;
                    }
                } while (zzaa == this.tag);
                this.zzalk = zzaa;
            } else if (i2 == 2) {
                int zzar2 = this.zzali.zzar() + this.zzali.zzaj();
                do {
                    list.add(Long.valueOf(this.zzali.zzab()));
                } while (this.zzali.zzar() < zzar2);
                zzu(zzar2);
            } else {
                throw zzdf.zzck();
            }
        }
    }

    public final void zzd(List<Long> list) throws IOException {
        int zzaa;
        int zzaa2;
        if (list instanceof zzdt) {
            zzdt zzdt = (zzdt) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzdt.zzn(this.zzali.zzac());
                    if (!this.zzali.zzaq()) {
                        zzaa2 = this.zzali.zzaa();
                    } else {
                        return;
                    }
                } while (zzaa2 == this.tag);
                this.zzalk = zzaa2;
            } else if (i == 2) {
                int zzar = this.zzali.zzar() + this.zzali.zzaj();
                do {
                    zzdt.zzn(this.zzali.zzac());
                } while (this.zzali.zzar() < zzar);
                zzu(zzar);
            } else {
                throw zzdf.zzck();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzali.zzac()));
                    if (!this.zzali.zzaq()) {
                        zzaa = this.zzali.zzaa();
                    } else {
                        return;
                    }
                } while (zzaa == this.tag);
                this.zzalk = zzaa;
            } else if (i2 == 2) {
                int zzar2 = this.zzali.zzar() + this.zzali.zzaj();
                do {
                    list.add(Long.valueOf(this.zzali.zzac()));
                } while (this.zzali.zzar() < zzar2);
                zzu(zzar2);
            } else {
                throw zzdf.zzck();
            }
        }
    }

    public final void zze(List<Integer> list) throws IOException {
        int zzaa;
        int zzaa2;
        if (list instanceof zzcz) {
            zzcz zzcz = (zzcz) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzcz.zzal(this.zzali.zzad());
                    if (!this.zzali.zzaq()) {
                        zzaa2 = this.zzali.zzaa();
                    } else {
                        return;
                    }
                } while (zzaa2 == this.tag);
                this.zzalk = zzaa2;
            } else if (i == 2) {
                int zzar = this.zzali.zzar() + this.zzali.zzaj();
                do {
                    zzcz.zzal(this.zzali.zzad());
                } while (this.zzali.zzar() < zzar);
                zzu(zzar);
            } else {
                throw zzdf.zzck();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzali.zzad()));
                    if (!this.zzali.zzaq()) {
                        zzaa = this.zzali.zzaa();
                    } else {
                        return;
                    }
                } while (zzaa == this.tag);
                this.zzalk = zzaa;
            } else if (i2 == 2) {
                int zzar2 = this.zzali.zzar() + this.zzali.zzaj();
                do {
                    list.add(Integer.valueOf(this.zzali.zzad()));
                } while (this.zzali.zzar() < zzar2);
                zzu(zzar2);
            } else {
                throw zzdf.zzck();
            }
        }
    }

    public final void zzf(List<Long> list) throws IOException {
        int zzaa;
        int zzaa2;
        if (list instanceof zzdt) {
            zzdt zzdt = (zzdt) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzdt.zzn(this.zzali.zzae());
                    if (!this.zzali.zzaq()) {
                        zzaa2 = this.zzali.zzaa();
                    } else {
                        return;
                    }
                } while (zzaa2 == this.tag);
                this.zzalk = zzaa2;
            } else if (i == 2) {
                int zzaj = this.zzali.zzaj();
                zzs(zzaj);
                int zzar = this.zzali.zzar() + zzaj;
                do {
                    zzdt.zzn(this.zzali.zzae());
                } while (this.zzali.zzar() < zzar);
            } else {
                throw zzdf.zzck();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zzali.zzae()));
                    if (!this.zzali.zzaq()) {
                        zzaa = this.zzali.zzaa();
                    } else {
                        return;
                    }
                } while (zzaa == this.tag);
                this.zzalk = zzaa;
            } else if (i2 == 2) {
                int zzaj2 = this.zzali.zzaj();
                zzs(zzaj2);
                int zzar2 = this.zzali.zzar() + zzaj2;
                do {
                    list.add(Long.valueOf(this.zzali.zzae()));
                } while (this.zzali.zzar() < zzar2);
            } else {
                throw zzdf.zzck();
            }
        }
    }

    public final void zzg(List<Integer> list) throws IOException {
        int zzaa;
        int zzaa2;
        if (list instanceof zzcz) {
            zzcz zzcz = (zzcz) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzaj = this.zzali.zzaj();
                zzt(zzaj);
                int zzar = this.zzali.zzar() + zzaj;
                do {
                    zzcz.zzal(this.zzali.zzaf());
                } while (this.zzali.zzar() < zzar);
            } else if (i == 5) {
                do {
                    zzcz.zzal(this.zzali.zzaf());
                    if (!this.zzali.zzaq()) {
                        zzaa2 = this.zzali.zzaa();
                    } else {
                        return;
                    }
                } while (zzaa2 == this.tag);
                this.zzalk = zzaa2;
            } else {
                throw zzdf.zzck();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzaj2 = this.zzali.zzaj();
                zzt(zzaj2);
                int zzar2 = this.zzali.zzar() + zzaj2;
                do {
                    list.add(Integer.valueOf(this.zzali.zzaf()));
                } while (this.zzali.zzar() < zzar2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzali.zzaf()));
                    if (!this.zzali.zzaq()) {
                        zzaa = this.zzali.zzaa();
                    } else {
                        return;
                    }
                } while (zzaa == this.tag);
                this.zzalk = zzaa;
            } else {
                throw zzdf.zzck();
            }
        }
    }

    public final void zzh(List<Boolean> list) throws IOException {
        int zzaa;
        int zzaa2;
        if (list instanceof zzbn) {
            zzbn zzbn = (zzbn) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzbn.addBoolean(this.zzali.zzag());
                    if (!this.zzali.zzaq()) {
                        zzaa2 = this.zzali.zzaa();
                    } else {
                        return;
                    }
                } while (zzaa2 == this.tag);
                this.zzalk = zzaa2;
            } else if (i == 2) {
                int zzar = this.zzali.zzar() + this.zzali.zzaj();
                do {
                    zzbn.addBoolean(this.zzali.zzag());
                } while (this.zzali.zzar() < zzar);
                zzu(zzar);
            } else {
                throw zzdf.zzck();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zzali.zzag()));
                    if (!this.zzali.zzaq()) {
                        zzaa = this.zzali.zzaa();
                    } else {
                        return;
                    }
                } while (zzaa == this.tag);
                this.zzalk = zzaa;
            } else if (i2 == 2) {
                int zzar2 = this.zzali.zzar() + this.zzali.zzaj();
                do {
                    list.add(Boolean.valueOf(this.zzali.zzag()));
                } while (this.zzali.zzar() < zzar2);
                zzu(zzar2);
            } else {
                throw zzdf.zzck();
            }
        }
    }

    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    public final void zzi(List<String> list) throws IOException {
        zza(list, true);
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int zzaa;
        int zzaa2;
        if ((this.tag & 7) != 2) {
            throw zzdf.zzck();
        } else if (!(list instanceof zzdm) || z) {
            do {
                list.add(z ? zzah() : readString());
                if (!this.zzali.zzaq()) {
                    zzaa = this.zzali.zzaa();
                } else {
                    return;
                }
            } while (zzaa == this.tag);
            this.zzalk = zzaa;
        } else {
            zzdm zzdm = (zzdm) list;
            do {
                zzdm.zzc(zzai());
                if (!this.zzali.zzaq()) {
                    zzaa2 = this.zzali.zzaa();
                } else {
                    return;
                }
            } while (zzaa2 == this.tag);
            this.zzalk = zzaa2;
        }
    }

    public final <T> void zza(List<T> list, zzeu<T> zzeu, zzck zzck) throws IOException {
        int zzaa;
        int i = this.tag;
        if ((i & 7) == 2) {
            do {
                list.add(zzc(zzeu, zzck));
                if (!this.zzali.zzaq() && this.zzalk == 0) {
                    zzaa = this.zzali.zzaa();
                } else {
                    return;
                }
            } while (zzaa == i);
            this.zzalk = zzaa;
            return;
        }
        throw zzdf.zzck();
    }

    public final <T> void zzb(List<T> list, zzeu<T> zzeu, zzck zzck) throws IOException {
        int zzaa;
        int i = this.tag;
        if ((i & 7) == 3) {
            do {
                list.add(zzd(zzeu, zzck));
                if (!this.zzali.zzaq() && this.zzalk == 0) {
                    zzaa = this.zzali.zzaa();
                } else {
                    return;
                }
            } while (zzaa == i);
            this.zzalk = zzaa;
            return;
        }
        throw zzdf.zzck();
    }

    public final void zzj(List<zzbp> list) throws IOException {
        int zzaa;
        if ((this.tag & 7) == 2) {
            do {
                list.add(zzai());
                if (!this.zzali.zzaq()) {
                    zzaa = this.zzali.zzaa();
                } else {
                    return;
                }
            } while (zzaa == this.tag);
            this.zzalk = zzaa;
            return;
        }
        throw zzdf.zzck();
    }

    public final void zzk(List<Integer> list) throws IOException {
        int zzaa;
        int zzaa2;
        if (list instanceof zzcz) {
            zzcz zzcz = (zzcz) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzcz.zzal(this.zzali.zzaj());
                    if (!this.zzali.zzaq()) {
                        zzaa2 = this.zzali.zzaa();
                    } else {
                        return;
                    }
                } while (zzaa2 == this.tag);
                this.zzalk = zzaa2;
            } else if (i == 2) {
                int zzar = this.zzali.zzar() + this.zzali.zzaj();
                do {
                    zzcz.zzal(this.zzali.zzaj());
                } while (this.zzali.zzar() < zzar);
                zzu(zzar);
            } else {
                throw zzdf.zzck();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzali.zzaj()));
                    if (!this.zzali.zzaq()) {
                        zzaa = this.zzali.zzaa();
                    } else {
                        return;
                    }
                } while (zzaa == this.tag);
                this.zzalk = zzaa;
            } else if (i2 == 2) {
                int zzar2 = this.zzali.zzar() + this.zzali.zzaj();
                do {
                    list.add(Integer.valueOf(this.zzali.zzaj()));
                } while (this.zzali.zzar() < zzar2);
                zzu(zzar2);
            } else {
                throw zzdf.zzck();
            }
        }
    }

    public final void zzl(List<Integer> list) throws IOException {
        int zzaa;
        int zzaa2;
        if (list instanceof zzcz) {
            zzcz zzcz = (zzcz) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzcz.zzal(this.zzali.zzak());
                    if (!this.zzali.zzaq()) {
                        zzaa2 = this.zzali.zzaa();
                    } else {
                        return;
                    }
                } while (zzaa2 == this.tag);
                this.zzalk = zzaa2;
            } else if (i == 2) {
                int zzar = this.zzali.zzar() + this.zzali.zzaj();
                do {
                    zzcz.zzal(this.zzali.zzak());
                } while (this.zzali.zzar() < zzar);
                zzu(zzar);
            } else {
                throw zzdf.zzck();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzali.zzak()));
                    if (!this.zzali.zzaq()) {
                        zzaa = this.zzali.zzaa();
                    } else {
                        return;
                    }
                } while (zzaa == this.tag);
                this.zzalk = zzaa;
            } else if (i2 == 2) {
                int zzar2 = this.zzali.zzar() + this.zzali.zzaj();
                do {
                    list.add(Integer.valueOf(this.zzali.zzak()));
                } while (this.zzali.zzar() < zzar2);
                zzu(zzar2);
            } else {
                throw zzdf.zzck();
            }
        }
    }

    public final void zzm(List<Integer> list) throws IOException {
        int zzaa;
        int zzaa2;
        if (list instanceof zzcz) {
            zzcz zzcz = (zzcz) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzaj = this.zzali.zzaj();
                zzt(zzaj);
                int zzar = this.zzali.zzar() + zzaj;
                do {
                    zzcz.zzal(this.zzali.zzal());
                } while (this.zzali.zzar() < zzar);
            } else if (i == 5) {
                do {
                    zzcz.zzal(this.zzali.zzal());
                    if (!this.zzali.zzaq()) {
                        zzaa2 = this.zzali.zzaa();
                    } else {
                        return;
                    }
                } while (zzaa2 == this.tag);
                this.zzalk = zzaa2;
            } else {
                throw zzdf.zzck();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzaj2 = this.zzali.zzaj();
                zzt(zzaj2);
                int zzar2 = this.zzali.zzar() + zzaj2;
                do {
                    list.add(Integer.valueOf(this.zzali.zzal()));
                } while (this.zzali.zzar() < zzar2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzali.zzal()));
                    if (!this.zzali.zzaq()) {
                        zzaa = this.zzali.zzaa();
                    } else {
                        return;
                    }
                } while (zzaa == this.tag);
                this.zzalk = zzaa;
            } else {
                throw zzdf.zzck();
            }
        }
    }

    public final void zzn(List<Long> list) throws IOException {
        int zzaa;
        int zzaa2;
        if (list instanceof zzdt) {
            zzdt zzdt = (zzdt) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzdt.zzn(this.zzali.zzam());
                    if (!this.zzali.zzaq()) {
                        zzaa2 = this.zzali.zzaa();
                    } else {
                        return;
                    }
                } while (zzaa2 == this.tag);
                this.zzalk = zzaa2;
            } else if (i == 2) {
                int zzaj = this.zzali.zzaj();
                zzs(zzaj);
                int zzar = this.zzali.zzar() + zzaj;
                do {
                    zzdt.zzn(this.zzali.zzam());
                } while (this.zzali.zzar() < zzar);
            } else {
                throw zzdf.zzck();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zzali.zzam()));
                    if (!this.zzali.zzaq()) {
                        zzaa = this.zzali.zzaa();
                    } else {
                        return;
                    }
                } while (zzaa == this.tag);
                this.zzalk = zzaa;
            } else if (i2 == 2) {
                int zzaj2 = this.zzali.zzaj();
                zzs(zzaj2);
                int zzar2 = this.zzali.zzar() + zzaj2;
                do {
                    list.add(Long.valueOf(this.zzali.zzam()));
                } while (this.zzali.zzar() < zzar2);
            } else {
                throw zzdf.zzck();
            }
        }
    }

    public final void zzo(List<Integer> list) throws IOException {
        int zzaa;
        int zzaa2;
        if (list instanceof zzcz) {
            zzcz zzcz = (zzcz) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzcz.zzal(this.zzali.zzan());
                    if (!this.zzali.zzaq()) {
                        zzaa2 = this.zzali.zzaa();
                    } else {
                        return;
                    }
                } while (zzaa2 == this.tag);
                this.zzalk = zzaa2;
            } else if (i == 2) {
                int zzar = this.zzali.zzar() + this.zzali.zzaj();
                do {
                    zzcz.zzal(this.zzali.zzan());
                } while (this.zzali.zzar() < zzar);
                zzu(zzar);
            } else {
                throw zzdf.zzck();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzali.zzan()));
                    if (!this.zzali.zzaq()) {
                        zzaa = this.zzali.zzaa();
                    } else {
                        return;
                    }
                } while (zzaa == this.tag);
                this.zzalk = zzaa;
            } else if (i2 == 2) {
                int zzar2 = this.zzali.zzar() + this.zzali.zzaj();
                do {
                    list.add(Integer.valueOf(this.zzali.zzan()));
                } while (this.zzali.zzar() < zzar2);
                zzu(zzar2);
            } else {
                throw zzdf.zzck();
            }
        }
    }

    public final void zzp(List<Long> list) throws IOException {
        int zzaa;
        int zzaa2;
        if (list instanceof zzdt) {
            zzdt zzdt = (zzdt) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzdt.zzn(this.zzali.zzao());
                    if (!this.zzali.zzaq()) {
                        zzaa2 = this.zzali.zzaa();
                    } else {
                        return;
                    }
                } while (zzaa2 == this.tag);
                this.zzalk = zzaa2;
            } else if (i == 2) {
                int zzar = this.zzali.zzar() + this.zzali.zzaj();
                do {
                    zzdt.zzn(this.zzali.zzao());
                } while (this.zzali.zzar() < zzar);
                zzu(zzar);
            } else {
                throw zzdf.zzck();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzali.zzao()));
                    if (!this.zzali.zzaq()) {
                        zzaa = this.zzali.zzaa();
                    } else {
                        return;
                    }
                } while (zzaa == this.tag);
                this.zzalk = zzaa;
            } else if (i2 == 2) {
                int zzar2 = this.zzali.zzar() + this.zzali.zzaj();
                do {
                    list.add(Long.valueOf(this.zzali.zzao()));
                } while (this.zzali.zzar() < zzar2);
                zzu(zzar2);
            } else {
                throw zzdf.zzck();
            }
        }
    }

    private static void zzs(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzdf.zzcl();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        if (zzat() != false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        throw new com.google.android.gms.internal.instantapps.zzdf("Unable to parse map entry.");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void zza(java.util.Map<K, V> r8, com.google.android.gms.internal.instantapps.zzdw<K, V> r9, com.google.android.gms.internal.instantapps.zzck r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.zzr(r0)
            com.google.android.gms.internal.instantapps.zzcb r1 = r7.zzali
            int r1 = r1.zzaj()
            com.google.android.gms.internal.instantapps.zzcb r2 = r7.zzali
            int r1 = r2.zzo(r1)
            K r2 = r9.zzarf
            V r3 = r9.zzarh
        L_0x0014:
            int r4 = r7.zzas()     // Catch:{ all -> 0x0064 }
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x005b
            com.google.android.gms.internal.instantapps.zzcb r5 = r7.zzali     // Catch:{ all -> 0x0064 }
            boolean r5 = r5.zzaq()     // Catch:{ all -> 0x0064 }
            if (r5 != 0) goto L_0x005b
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L_0x0046
            if (r4 == r0) goto L_0x0039
            boolean r4 = r7.zzat()     // Catch:{ zzde -> 0x004e }
            if (r4 == 0) goto L_0x0033
            goto L_0x0014
        L_0x0033:
            com.google.android.gms.internal.instantapps.zzdf r4 = new com.google.android.gms.internal.instantapps.zzdf     // Catch:{ zzde -> 0x004e }
            r4.<init>(r6)     // Catch:{ zzde -> 0x004e }
            throw r4     // Catch:{ zzde -> 0x004e }
        L_0x0039:
            com.google.android.gms.internal.instantapps.zzgd r4 = r9.zzarg     // Catch:{ zzde -> 0x004e }
            V r5 = r9.zzarh     // Catch:{ zzde -> 0x004e }
            java.lang.Class r5 = r5.getClass()     // Catch:{ zzde -> 0x004e }
            java.lang.Object r3 = r7.zza((com.google.android.gms.internal.instantapps.zzgd) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.instantapps.zzck) r10)     // Catch:{ zzde -> 0x004e }
            goto L_0x0014
        L_0x0046:
            com.google.android.gms.internal.instantapps.zzgd r4 = r9.zzare     // Catch:{ zzde -> 0x004e }
            r5 = 0
            java.lang.Object r2 = r7.zza((com.google.android.gms.internal.instantapps.zzgd) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.instantapps.zzck) r5)     // Catch:{ zzde -> 0x004e }
            goto L_0x0014
        L_0x004e:
            boolean r4 = r7.zzat()     // Catch:{ all -> 0x0064 }
            if (r4 == 0) goto L_0x0055
            goto L_0x0014
        L_0x0055:
            com.google.android.gms.internal.instantapps.zzdf r8 = new com.google.android.gms.internal.instantapps.zzdf     // Catch:{ all -> 0x0064 }
            r8.<init>(r6)     // Catch:{ all -> 0x0064 }
            throw r8     // Catch:{ all -> 0x0064 }
        L_0x005b:
            r8.put(r2, r3)     // Catch:{ all -> 0x0064 }
            com.google.android.gms.internal.instantapps.zzcb r8 = r7.zzali
            r8.zzp(r1)
            return
        L_0x0064:
            r8 = move-exception
            com.google.android.gms.internal.instantapps.zzcb r9 = r7.zzali
            r9.zzp(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.instantapps.zzcc.zza(java.util.Map, com.google.android.gms.internal.instantapps.zzdw, com.google.android.gms.internal.instantapps.zzck):void");
    }

    private final Object zza(zzgd zzgd, Class<?> cls, zzck zzck) throws IOException {
        switch (zzcf.zzals[zzgd.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzag());
            case 2:
                return zzai();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzak());
            case 5:
                return Integer.valueOf(zzaf());
            case 6:
                return Long.valueOf(zzae());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzad());
            case 9:
                return Long.valueOf(zzac());
            case 10:
                zzr(2);
                return zzc(zzeq.zzdi().zze(cls), zzck);
            case 11:
                return Integer.valueOf(zzal());
            case 12:
                return Long.valueOf(zzam());
            case 13:
                return Integer.valueOf(zzan());
            case 14:
                return Long.valueOf(zzao());
            case 15:
                return zzah();
            case 16:
                return Integer.valueOf(zzaj());
            case 17:
                return Long.valueOf(zzab());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static void zzt(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzdf.zzcl();
        }
    }

    private final void zzu(int i) throws IOException {
        if (this.zzali.zzar() != i) {
            throw zzdf.zzcf();
        }
    }
}
