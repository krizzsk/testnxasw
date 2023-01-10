package com.google.android.gms.internal.instantapps;

import android.os.Parcelable;

public final class zzv implements Parcelable.Creator<zzw> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzw[i];
    }

    /* JADX WARNING: type inference failed for: r2v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v4, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v5, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v6, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r21) {
        /*
            r20 = this;
            r0 = r21
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r21)
            r2 = 0
            r3 = 0
            r6 = r3
            r8 = r6
            r9 = r8
            r10 = r9
            r11 = r10
            r13 = r11
            r14 = r13
            r17 = r14
            r18 = r17
            r19 = r18
            r5 = 0
            r7 = 0
            r12 = 0
            r15 = 0
            r16 = 0
        L_0x001b:
            int r2 = r21.dataPosition()
            if (r2 >= r1) goto L_0x008f
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r21)
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r2)
            switch(r3) {
                case 2: goto L_0x008a;
                case 3: goto L_0x0085;
                case 4: goto L_0x0080;
                case 5: goto L_0x0076;
                case 6: goto L_0x006c;
                case 7: goto L_0x002c;
                case 8: goto L_0x0062;
                case 9: goto L_0x0058;
                case 10: goto L_0x0053;
                case 11: goto L_0x004e;
                case 12: goto L_0x0049;
                case 13: goto L_0x0044;
                case 14: goto L_0x003f;
                case 15: goto L_0x003a;
                case 16: goto L_0x0035;
                case 17: goto L_0x0030;
                default: goto L_0x002c;
            }
        L_0x002c:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r0, r2)
            goto L_0x001b
        L_0x0030:
            byte[] r18 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createByteArray(r0, r2)
            goto L_0x001b
        L_0x0035:
            int r16 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x001b
        L_0x003a:
            android.os.Bundle r19 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBundle(r0, r2)
            goto L_0x001b
        L_0x003f:
            java.lang.String r17 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x001b
        L_0x0044:
            int r15 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x001b
        L_0x0049:
            java.lang.String r14 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x001b
        L_0x004e:
            byte[] r13 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createByteArray(r0, r2)
            goto L_0x001b
        L_0x0053:
            boolean r12 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x001b
        L_0x0058:
            android.os.Parcelable$Creator<com.google.android.gms.internal.instantapps.zzap> r3 = com.google.android.gms.internal.instantapps.zzap.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r11 = r2
            com.google.android.gms.internal.instantapps.zzap r11 = (com.google.android.gms.internal.instantapps.zzap) r11
            goto L_0x001b
        L_0x0062:
            android.os.Parcelable$Creator<com.google.android.gms.internal.instantapps.zzf> r3 = com.google.android.gms.internal.instantapps.zzf.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r10 = r2
            com.google.android.gms.internal.instantapps.zzf r10 = (com.google.android.gms.internal.instantapps.zzf) r10
            goto L_0x001b
        L_0x006c:
            android.os.Parcelable$Creator r3 = android.content.Intent.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r9 = r2
            android.content.Intent r9 = (android.content.Intent) r9
            goto L_0x001b
        L_0x0076:
            android.os.Parcelable$Creator r3 = android.content.Intent.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r8 = r2
            android.content.Intent r8 = (android.content.Intent) r8
            goto L_0x001b
        L_0x0080:
            boolean r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x001b
        L_0x0085:
            java.lang.String r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x001b
        L_0x008a:
            int r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x001b
        L_0x008f:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r0, r1)
            com.google.android.gms.internal.instantapps.zzw r0 = new com.google.android.gms.internal.instantapps.zzw
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.instantapps.zzv.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
