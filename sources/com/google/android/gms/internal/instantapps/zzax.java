package com.google.android.gms.internal.instantapps;

import android.os.Parcelable;

public final class zzax implements Parcelable.Creator<zzay> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzay[i];
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r11) {
        /*
            r10 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r11)
            r1 = 0
            r3 = r1
            r4 = r3
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
        L_0x000c:
            int r1 = r11.dataPosition()
            if (r1 >= r0) goto L_0x004e
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r11)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            switch(r2) {
                case 2: goto L_0x0044;
                case 3: goto L_0x003f;
                case 4: goto L_0x003a;
                case 5: goto L_0x0035;
                case 6: goto L_0x0030;
                case 7: goto L_0x002b;
                case 8: goto L_0x0021;
                default: goto L_0x001d;
            }
        L_0x001d:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r11, r1)
            goto L_0x000c
        L_0x0021:
            android.os.Parcelable$Creator<com.google.android.gms.internal.instantapps.zzm> r2 = com.google.android.gms.internal.instantapps.zzm.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r11, r1, r2)
            r9 = r1
            com.google.android.gms.internal.instantapps.zzm r9 = (com.google.android.gms.internal.instantapps.zzm) r9
            goto L_0x000c
        L_0x002b:
            java.util.ArrayList r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createStringList(r11, r1)
            goto L_0x000c
        L_0x0030:
            java.lang.String r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r11, r1)
            goto L_0x000c
        L_0x0035:
            java.lang.String r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r11, r1)
            goto L_0x000c
        L_0x003a:
            java.lang.String r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r11, r1)
            goto L_0x000c
        L_0x003f:
            java.lang.String r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r11, r1)
            goto L_0x000c
        L_0x0044:
            android.os.Parcelable$Creator<com.google.android.gms.common.data.BitmapTeleporter> r2 = com.google.android.gms.common.data.BitmapTeleporter.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r11, r1, r2)
            r3 = r1
            com.google.android.gms.common.data.BitmapTeleporter r3 = (com.google.android.gms.common.data.BitmapTeleporter) r3
            goto L_0x000c
        L_0x004e:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r11, r0)
            com.google.android.gms.internal.instantapps.zzay r11 = new com.google.android.gms.internal.instantapps.zzay
            r2 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.instantapps.zzax.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
