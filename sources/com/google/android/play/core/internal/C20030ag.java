package com.google.android.play.core.internal;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.util.IllegalFormatException;
import java.util.Locale;

/* renamed from: com.google.android.play.core.internal.ag */
public final class C20030ag {

    /* renamed from: a */
    private final String f56062a;

    public C20030ag(String str) {
        int myUid = Process.myUid();
        int myPid = Process.myPid();
        StringBuilder sb = new StringBuilder(39);
        sb.append("UID: [");
        sb.append(myUid);
        sb.append("]  PID: [");
        sb.append(myPid);
        sb.append("] ");
        String valueOf = String.valueOf(sb.toString());
        String valueOf2 = String.valueOf(str);
        this.f56062a = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    /* renamed from: a */
    private final int m42127a(int i, String str, Object[] objArr) {
        if (Log.isLoggable("PlayCore", i)) {
            return SystemUtils.log(4, "PlayCore", m42128a(this.f56062a, str, objArr), (Throwable) null, "com.google.android.play.core.internal.ag", -1);
        }
        return 0;
    }

    /* renamed from: a */
    private static String m42128a(String str, String str2, Object... objArr) {
        if (objArr.length > 0) {
            try {
                str2 = String.format(Locale.US, str2, objArr);
            } catch (IllegalFormatException e) {
                IllegalFormatException illegalFormatException = e;
                String valueOf = String.valueOf(str2);
                SystemUtils.log(6, "PlayCore", valueOf.length() != 0 ? "Unable to format ".concat(valueOf) : new String("Unable to format "), illegalFormatException, "com.google.android.play.core.internal.ag", -1);
                String join = TextUtils.join(", ", objArr);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 3 + String.valueOf(join).length());
                sb.append(str2);
                sb.append(" [");
                sb.append(join);
                sb.append(Const.jaRight);
                str2 = sb.toString();
            }
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append(" : ");
        sb2.append(str2);
        return sb2.toString();
    }

    /* renamed from: a */
    public final void mo164267a(String str, Object... objArr) {
        m42127a(3, str, objArr);
    }

    /* renamed from: a */
    public final void mo164268a(Throwable th, String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            SystemUtils.log(6, "PlayCore", m42128a(this.f56062a, str, objArr), th, "com.google.android.play.core.internal.ag", -1);
        }
    }

    /* renamed from: b */
    public final void mo164269b(String str, Object... objArr) {
        m42127a(6, str, objArr);
    }

    /* renamed from: c */
    public final void mo164270c(String str, Object... objArr) {
        m42127a(4, str, objArr);
    }

    /* renamed from: d */
    public final void mo164271d(String str, Object... objArr) {
        m42127a(5, str, objArr);
    }
}
