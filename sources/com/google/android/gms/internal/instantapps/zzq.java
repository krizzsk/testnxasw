package com.google.android.gms.internal.instantapps;

import android.os.Parcelable;

public final class zzq implements Parcelable.Creator<zzn> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzn[i];
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v4, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r13) {
        /*
            r12 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r13)
            r1 = 0
            r2 = 0
            r3 = 0
            r10 = r1
            r11 = r10
            r7 = r3
            r6 = 0
            r9 = 0
        L_0x000d:
            int r1 = r13.dataPosition()
            if (r1 >= r0) goto L_0x0051
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r13)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            r3 = 2
            if (r2 == r3) goto L_0x004c
            r3 = 3
            if (r2 == r3) goto L_0x0047
            r3 = 4
            if (r2 == r3) goto L_0x0042
            r3 = 5
            if (r2 == r3) goto L_0x0038
            r3 = 6
            if (r2 == r3) goto L_0x002e
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r13, r1)
            goto L_0x000d
        L_0x002e:
            android.os.Parcelable$Creator r2 = android.accounts.Account.CREATOR
            java.lang.Object[] r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedArray(r13, r1, r2)
            r11 = r1
            android.accounts.Account[] r11 = (android.accounts.Account[]) r11
            goto L_0x000d
        L_0x0038:
            android.os.Parcelable$Creator r2 = android.accounts.Account.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r13, r1, r2)
            r10 = r1
            android.accounts.Account r10 = (android.accounts.Account) r10
            goto L_0x000d
        L_0x0042:
            int r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r13, r1)
            goto L_0x000d
        L_0x0047:
            long r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r13, r1)
            goto L_0x000d
        L_0x004c:
            int r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r13, r1)
            goto L_0x000d
        L_0x0051:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r13, r0)
            com.google.android.gms.internal.instantapps.zzn r13 = new com.google.android.gms.internal.instantapps.zzn
            r5 = r13
            r5.<init>(r6, r7, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.instantapps.zzq.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
