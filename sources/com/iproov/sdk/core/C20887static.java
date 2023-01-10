package com.iproov.sdk.core;

import com.google.common.base.Ascii;
import com.iproov.sdk.core.C20782break;
import com.iproov.sdk.core.exception.IProovException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import org.json.JSONArray;
import org.json.JSONException;
import p095switch.C3667do;
import p095switch.C3676new;

/* renamed from: com.iproov.sdk.core.static */
/* compiled from: SecurityReport */
public class C20887static {

    /* renamed from: a */
    static final C20882import[] f57179a = {C20882import.AND1, C20882import.AND2, C20882import.AND3, C20882import.AND4, C20882import.AND5, C20882import.AND6, C20882import.AND7, C20882import.AND8, C20882import.AND9, C20882import.AND10, C20882import.AND11, C20882import.AND12, C20882import.AND13, C20882import.AND14};

    /* renamed from: b */
    static final C20782break.C20783do[] f57180b = {C20782break.C20783do.AND15, C20782break.C20783do.AND16, C20782break.C20783do.AND17, C20782break.C20783do.AND18, C20782break.C20783do.AND19};

    /* renamed from: c */
    static final C20888super[] f57181c = {C20888super.AND20, C20888super.AND21, C20888super.AND22, C20888super.AND23, C20888super.AND24, C20888super.AND25, C20888super.AND26, C20888super.AND27, C20888super.AND28, C20888super.AND29, C20888super.AND30, C20888super.AND31, C20888super.AND32};

    /* renamed from: a */
    private static boolean m43443a(C20882import importR) {
        return C20781b.m43060a(importR) == Boolean.TRUE;
    }

    /* renamed from: b */
    private static byte[] m43447b(String str) {
        return new StringBuilder(str).reverse().toString().getBytes(StandardCharsets.UTF_8);
    }

    /* renamed from: a */
    private static boolean m43442a(C20782break.C20783do doVar) {
        return C20781b.m43059a(doVar) == Boolean.TRUE;
    }

    /* renamed from: a */
    private static void m43439a(int i) {
        try {
            for (Method method : Class.forName(C20786catch.m43102a()).getMethods()) {
                if (method.getName().equals("error")) {
                    method.invoke((Object) null, new Object[]{Integer.valueOf(i)});
                    return;
                }
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private static void m43440a(int i, int i2, int i3) {
        if (i2 != i3) {
            m43439a(i);
        }
    }

    /* renamed from: a */
    private static void m43441a(JSONArray jSONArray) {
        int i;
        try {
            int i2 = 0;
            for (C20882import importR : f57179a) {
                i2 = i + 1;
                m43440a(i2, jSONArray.getInt(i2), 1);
            }
            for (C20782break.C20783do doVar : f57180b) {
                if (doVar == C20782break.C20783do.AND17 || doVar == C20782break.C20783do.AND18) {
                    i++;
                } else {
                    i++;
                    m43440a(i, jSONArray.getInt(i), 0);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    static String m43438a() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(0);
        for (C20882import a : f57179a) {
            jSONArray.put(m43448do(Boolean.valueOf(m43443a(a))));
        }
        for (C20782break.C20783do a2 : f57180b) {
            jSONArray.put(m43448do(Boolean.valueOf(m43442a(a2))));
        }
        for (C20888super a3 : f57181c) {
            jSONArray.put(m43448do(C20781b.m43061a(a3)));
        }
        m43441a(jSONArray);
        return jSONArray.toString();
    }

    /* renamed from: do */
    public static Object m43448do(Object obj) {
        return obj instanceof Boolean ? Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0) : obj;
    }

    /* renamed from: a */
    static byte[] m43444a(String str) throws NoSuchAlgorithmException {
        byte[] bArr = new byte[16];
        System.arraycopy(C3667do.m7413do(C3676new.m7426do(m43447b(str))), 0, bArr, 0, 16);
        return bArr;
    }

    /* renamed from: a */
    static byte[] m43445a(byte[] bArr, String str) throws IProovException {
        try {
            return C20780a.m43058a(m43438a(), m43444a(str), bArr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IProovException("Unknown data", e);
        }
    }

    /* renamed from: a */
    static byte[] m43446a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length + 12)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        int length = bArr.length + bArr2.length;
        bArr3[length] = (byte) (bArr2.length >> 16);
        bArr3[length + 1] = (byte) (bArr2.length >> 8);
        bArr3[length + 2] = (byte) bArr2.length;
        bArr3[length + 3] = 0;
        bArr3[length + 4] = 0;
        bArr3[length + 5] = 0;
        bArr3[length + 6] = 0;
        bArr3[length + 7] = 0;
        bArr3[length + 8] = 0;
        bArr3[length + 9] = 0;
        bArr3[length + 10] = 34;
        bArr3[length + 11] = Ascii.ESC;
        return bArr3;
    }

    /* renamed from: do */
    public static byte[] m43449do(byte[] bArr, byte[] bArr2, String str) throws IProovException {
        return m43446a(bArr, m43445a(bArr2, str));
    }
}
