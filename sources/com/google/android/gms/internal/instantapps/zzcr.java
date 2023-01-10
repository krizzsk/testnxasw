package com.google.android.gms.internal.instantapps;

import java.lang.reflect.Type;

public enum zzcr {
    DOUBLE(0, zzct.SCALAR, zzdh.DOUBLE),
    FLOAT(1, zzct.SCALAR, zzdh.FLOAT),
    INT64(2, zzct.SCALAR, zzdh.LONG),
    UINT64(3, zzct.SCALAR, zzdh.LONG),
    INT32(4, zzct.SCALAR, zzdh.INT),
    FIXED64(5, zzct.SCALAR, zzdh.LONG),
    FIXED32(6, zzct.SCALAR, zzdh.INT),
    BOOL(7, zzct.SCALAR, zzdh.BOOLEAN),
    STRING(8, zzct.SCALAR, zzdh.STRING),
    MESSAGE(9, zzct.SCALAR, zzdh.MESSAGE),
    BYTES(10, zzct.SCALAR, zzdh.BYTE_STRING),
    UINT32(11, zzct.SCALAR, zzdh.INT),
    ENUM(12, zzct.SCALAR, zzdh.ENUM),
    SFIXED32(13, zzct.SCALAR, zzdh.INT),
    SFIXED64(14, zzct.SCALAR, zzdh.LONG),
    SINT32(15, zzct.SCALAR, zzdh.INT),
    SINT64(16, zzct.SCALAR, zzdh.LONG),
    GROUP(17, zzct.SCALAR, zzdh.MESSAGE),
    DOUBLE_LIST(18, zzct.VECTOR, zzdh.DOUBLE),
    FLOAT_LIST(19, zzct.VECTOR, zzdh.FLOAT),
    INT64_LIST(20, zzct.VECTOR, zzdh.LONG),
    UINT64_LIST(21, zzct.VECTOR, zzdh.LONG),
    INT32_LIST(22, zzct.VECTOR, zzdh.INT),
    FIXED64_LIST(23, zzct.VECTOR, zzdh.LONG),
    FIXED32_LIST(24, zzct.VECTOR, zzdh.INT),
    BOOL_LIST(25, zzct.VECTOR, zzdh.BOOLEAN),
    STRING_LIST(26, zzct.VECTOR, zzdh.STRING),
    MESSAGE_LIST(27, zzct.VECTOR, zzdh.MESSAGE),
    BYTES_LIST(28, zzct.VECTOR, zzdh.BYTE_STRING),
    UINT32_LIST(29, zzct.VECTOR, zzdh.INT),
    ENUM_LIST(30, zzct.VECTOR, zzdh.ENUM),
    SFIXED32_LIST(31, zzct.VECTOR, zzdh.INT),
    SFIXED64_LIST(32, zzct.VECTOR, zzdh.LONG),
    SINT32_LIST(33, zzct.VECTOR, zzdh.INT),
    SINT64_LIST(34, zzct.VECTOR, zzdh.LONG),
    DOUBLE_LIST_PACKED(35, zzct.PACKED_VECTOR, zzdh.DOUBLE),
    FLOAT_LIST_PACKED(36, zzct.PACKED_VECTOR, zzdh.FLOAT),
    INT64_LIST_PACKED(37, zzct.PACKED_VECTOR, zzdh.LONG),
    UINT64_LIST_PACKED(38, zzct.PACKED_VECTOR, zzdh.LONG),
    INT32_LIST_PACKED(39, zzct.PACKED_VECTOR, zzdh.INT),
    FIXED64_LIST_PACKED(40, zzct.PACKED_VECTOR, zzdh.LONG),
    FIXED32_LIST_PACKED(41, zzct.PACKED_VECTOR, zzdh.INT),
    BOOL_LIST_PACKED(42, zzct.PACKED_VECTOR, zzdh.BOOLEAN),
    UINT32_LIST_PACKED(43, zzct.PACKED_VECTOR, zzdh.INT),
    ENUM_LIST_PACKED(44, zzct.PACKED_VECTOR, zzdh.ENUM),
    SFIXED32_LIST_PACKED(45, zzct.PACKED_VECTOR, zzdh.INT),
    SFIXED64_LIST_PACKED(46, zzct.PACKED_VECTOR, zzdh.LONG),
    SINT32_LIST_PACKED(47, zzct.PACKED_VECTOR, zzdh.INT),
    SINT64_LIST_PACKED(48, zzct.PACKED_VECTOR, zzdh.LONG),
    GROUP_LIST(49, zzct.VECTOR, zzdh.MESSAGE),
    MAP(50, zzct.MAP, zzdh.VOID);
    
    private static final zzcr[] zzaol = null;
    private static final Type[] zzaom = null;

    /* renamed from: id */
    private final int f55538id;
    private final zzdh zzaoh;
    private final zzct zzaoi;
    private final Class<?> zzaoj;
    private final boolean zzaok;

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002d, code lost:
        r5 = com.google.android.gms.internal.instantapps.zzcu.zzaov[r6.ordinal()];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzcr(int r4, com.google.android.gms.internal.instantapps.zzct r5, com.google.android.gms.internal.instantapps.zzdh r6) {
        /*
            r1 = this;
            r1.<init>(r2, r3)
            r1.f55538id = r4
            r1.zzaoi = r5
            r1.zzaoh = r6
            int[] r2 = com.google.android.gms.internal.instantapps.zzcu.zzaou
            int r3 = r5.ordinal()
            r2 = r2[r3]
            r3 = 2
            r4 = 1
            if (r2 == r4) goto L_0x0022
            if (r2 == r3) goto L_0x001b
            r2 = 0
            r1.zzaoj = r2
            goto L_0x0028
        L_0x001b:
            java.lang.Class r2 = r6.zzco()
            r1.zzaoj = r2
            goto L_0x0028
        L_0x0022:
            java.lang.Class r2 = r6.zzco()
            r1.zzaoj = r2
        L_0x0028:
            r2 = 0
            com.google.android.gms.internal.instantapps.zzct r0 = com.google.android.gms.internal.instantapps.zzct.SCALAR
            if (r5 != r0) goto L_0x003d
            int[] r5 = com.google.android.gms.internal.instantapps.zzcu.zzaov
            int r6 = r6.ordinal()
            r5 = r5[r6]
            if (r5 == r4) goto L_0x003d
            if (r5 == r3) goto L_0x003d
            r3 = 3
            if (r5 == r3) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r4 = 0
        L_0x003e:
            r1.zzaok = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.instantapps.zzcr.<init>(java.lang.String, int, int, com.google.android.gms.internal.instantapps.zzct, com.google.android.gms.internal.instantapps.zzdh):void");
    }

    /* renamed from: id */
    public final int mo157219id() {
        return this.f55538id;
    }

    static {
        int i;
        zzaom = new Type[0];
        zzcr[] values = values();
        zzaol = new zzcr[values.length];
        for (zzcr zzcr : values) {
            zzaol[zzcr.f55538id] = zzcr;
        }
    }
}
