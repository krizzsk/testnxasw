package com.google.android.gms.internal.instantapps;

import android.os.Parcelable;

public final class zzi implements Parcelable.Creator<zzf> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzf[i];
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r14) {
        /*
            r13 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r14)
            r1 = 0
            r2 = 0
            r4 = r1
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r10 = r8
            r11 = r10
            r12 = r11
            r9 = 0
        L_0x000f:
            int r1 = r14.dataPosition()
            if (r1 >= r0) goto L_0x005c
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r14)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            switch(r2) {
                case 2: goto L_0x0057;
                case 3: goto L_0x0052;
                case 4: goto L_0x0020;
                case 5: goto L_0x004b;
                case 6: goto L_0x0044;
                case 7: goto L_0x003f;
                case 8: goto L_0x003a;
                case 9: goto L_0x0030;
                case 10: goto L_0x0020;
                case 11: goto L_0x0029;
                case 12: goto L_0x0024;
                default: goto L_0x0020;
            }
        L_0x0020:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r14, r1)
            goto L_0x000f
        L_0x0024:
            byte[] r12 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createByteArray(r14, r1)
            goto L_0x000f
        L_0x0029:
            android.os.Parcelable$Creator<com.google.android.gms.internal.instantapps.zzat> r2 = com.google.android.gms.internal.instantapps.zzat.CREATOR
            java.util.ArrayList r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedList(r14, r1, r2)
            goto L_0x000f
        L_0x0030:
            android.os.Parcelable$Creator r2 = android.content.pm.PackageInfo.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r14, r1, r2)
            r11 = r1
            android.content.pm.PackageInfo r11 = (android.content.pm.PackageInfo) r11
            goto L_0x000f
        L_0x003a:
            byte[] r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createByteArray(r14, r1)
            goto L_0x000f
        L_0x003f:
            int r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r14, r1)
            goto L_0x000f
        L_0x0044:
            android.os.Parcelable$Creator<com.google.android.gms.internal.instantapps.zzh> r2 = com.google.android.gms.internal.instantapps.zzh.CREATOR
            java.util.ArrayList r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedList(r14, r1, r2)
            goto L_0x000f
        L_0x004b:
            android.os.Parcelable$Creator<com.google.android.gms.internal.instantapps.zzap> r2 = com.google.android.gms.internal.instantapps.zzap.CREATOR
            java.util.ArrayList r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedList(r14, r1, r2)
            goto L_0x000f
        L_0x0052:
            java.lang.String r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r14, r1)
            goto L_0x000f
        L_0x0057:
            java.lang.String r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r14, r1)
            goto L_0x000f
        L_0x005c:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r14, r0)
            com.google.android.gms.internal.instantapps.zzf r14 = new com.google.android.gms.internal.instantapps.zzf
            r3 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.instantapps.zzi.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
