package com.threatmetrix.TrustDefender;

import android.content.Context;
import com.datadog.android.log.LogAttributes;
import com.threatmetrix.TrustDefender.TMXStrongAuth;
import java.lang.reflect.Method;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class qqqtqq extends qqyyqy {
    private Object b006E006E006Ennn;
    private Object b006E006Ennnn;
    private Object b006En006Ennn;
    private Object bn006E006Ennn;
    private Object bn006Ennnn;
    private Object bnn006Ennn;

    public qqqtqq(Object obj, String str) {
        super(obj, str);
        if (obj instanceof Map) {
            Map map = (Map) obj;
            this.bn006Ennnn = map.get("registerHandler");
            this.b006E006Ennnn = map.get("deregisterHandler");
            this.bnn006Ennn = map.get("stepUpHandler");
            this.b006En006Ennn = map.get("getFingerprintCapsHandler");
            this.bn006E006Ennn = map.get("attestStrongIdHandler");
            this.b006E006E006Ennn = map.get("isNativeLibAvailableHandler");
        }
    }

    public boolean b00750075007500750075u() {
        return (this.bppp00700070p == null || this.b0070pp00700070p == null || this.b0070p007000700070p == null || this.bp0070p00700070p == null || this.b00700070p00700070p == null || this.bn006Ennnn == null || this.b006E006Ennnn == null || this.bnn006Ennn == null || this.b006En006Ennn == null || this.bn006E006Ennn == null || this.b006E006E006Ennn == null || this.bpp007000700070p == null) ? false : true;
    }

    public TMXStrongAuth.AuthParamResult b0075u007500750075u(@Nonnull String str) {
        ArrayList arrayList = new ArrayList();
        b0074ttt00740074((Method) this.b006E006Ennnn, str, arrayList);
        if (arrayList.isEmpty()) {
            return null;
        }
        return (TMXStrongAuth.AuthParamResult) arrayList.get(0);
    }

    public TMXStrongAuth.AuthParamResult b0075uuuu0075(@Nonnull Context context, @Nonnull String str, @Nonnull String str2, @Nonnull String str3, @Nonnull byte[] bArr, @Nullable TMXStrongAuth.StrongAuthCallback strongAuthCallback) {
        ArrayList arrayList = new ArrayList();
        b0074ttt00740074((Method) this.bn006Ennnn, context, str, str2, str3, bArr, strongAuthCallback, arrayList);
        if (arrayList.isEmpty()) {
            return null;
        }
        return (TMXStrongAuth.AuthParamResult) arrayList.get(0);
    }

    public String bu0075007500750075u(@Nonnull Context context, boolean z) {
        ArrayList arrayList = new ArrayList();
        b0074ttt00740074((Method) this.b006En006Ennn, context, Boolean.valueOf(z), arrayList);
        return arrayList.isEmpty() ? "" : (String) arrayList.get(0);
    }

    public TMXStrongAuth.AuthParamResult bu0075uuu0075(@Nonnull Context context, @Nonnull TMXStrongAuth.AuthMethod authMethod, @Nonnull String str, @Nonnull String str2, @Nonnull String str3, @Nonnull byte[] bArr, @Nullable TMXStrongAuth.StrongAuthCallback strongAuthCallback, boolean z, PrivateKey privateKey, long j) {
        ArrayList arrayList = new ArrayList();
        b0074ttt00740074((Method) this.bnn006Ennn, context, authMethod, str, str2, str3, bArr, strongAuthCallback, Boolean.valueOf(z), privateKey, Long.valueOf(j), arrayList);
        if (arrayList.isEmpty()) {
            return null;
        }
        return (TMXStrongAuth.AuthParamResult) arrayList.get(0);
    }

    public qqqyqq buu007500750075u(String str, String str2, Context context) {
        qqqyqq qqqyqq = new qqqyqq();
        HashMap hashMap = new HashMap();
        b0074ttt00740074((Method) this.bn006E006Ennn, str, str2, context, hashMap);
        if (hashMap.containsKey("signature")) {
            qqqyqq.b00620062b006200620062 = (String) hashMap.get("signature");
        }
        if (hashMap.containsKey("random")) {
            qqqyqq.bbb0062006200620062 = (String) hashMap.get("random");
        }
        if (hashMap.containsKey("type")) {
            qqqyqq.bb00620062006200620062 = (String) hashMap.get("type");
        }
        if (hashMap.containsKey(LogAttributes.DATE)) {
            qqqyqq.b006Dmmmmm = (String) hashMap.get(LogAttributes.DATE);
        }
        if (hashMap.containsKey("key")) {
            qqqyqq.bm006Dmmmm = (String) hashMap.get("key");
        }
        if (hashMap.containsKey("imported")) {
            qqqyqq.b006D006Dmmmm = (String) hashMap.get("imported");
        }
        if (hashMap.containsKey("error")) {
            qqqyqq.b0062b0062006200620062 = (String) hashMap.get("error");
        }
        return qqqyqq;
    }

    public boolean buuuuu0075() {
        ArrayList arrayList = new ArrayList();
        b0074ttt00740074((Method) this.b006E006E006Ennn, arrayList);
        return !arrayList.isEmpty() && ((String) arrayList.get(0)).compareTo("TRUE") == 0;
    }
}
