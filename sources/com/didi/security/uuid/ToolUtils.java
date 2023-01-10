package com.didi.security.uuid;

import android.content.Context;
import android.content.pm.Signature;
import android.util.DisplayMetrics;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.apm.SystemUtils;
import com.google.common.base.Ascii;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class ToolUtils {

    /* renamed from: a */
    private static int f41244a = 4097;

    /* renamed from: b */
    private static int f41245b = 4098;

    /* renamed from: c */
    private static int f41246c = 4099;

    /* renamed from: d */
    private static int f41247d = 4101;

    /* renamed from: e */
    private static int f41248e = 4102;

    /* renamed from: f */
    private static int f41249f = 4103;

    /* renamed from: g */
    private static int f41250g = 4104;

    /* renamed from: h */
    private static int f41251h = 4105;

    /* renamed from: i */
    private static int f41252i = 4112;

    /* renamed from: j */
    private static int f41253j = 8193;

    /* renamed from: k */
    private static int f41254k = 8194;

    /* renamed from: l */
    private static int f41255l = 8195;

    /* renamed from: m */
    private static int f41256m = 8196;

    /* renamed from: n */
    private static int f41257n = 8197;

    /* renamed from: o */
    private static int f41258o = 8198;

    /* renamed from: p */
    private static int f41259p = 8199;

    /* renamed from: q */
    private static int f41260q = 8200;

    /* renamed from: r */
    private static int f41261r = 8201;

    /* renamed from: s */
    private static int f41262s = 8208;

    /* renamed from: t */
    private static int f41263t = 8209;

    /* renamed from: u */
    private Context f41264u;

    /* renamed from: v */
    private final char[] f41265v = C2948a.f6666a.toCharArray();

    private static class Holder {
        /* access modifiers changed from: private */
        public static ToolUtils instance = new ToolUtils();

        private Holder() {
        }
    }

    public static ToolUtils getInstance() {
        return Holder.instance;
    }

    public void initContext(Context context) {
        this.f41264u = context;
    }

    /* renamed from: a */
    private String m30975a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            if (instance == null) {
                return null;
            }
            byte[] digest = instance.digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    private String m30973a(Signature signature) {
        if (signature == null) {
            return null;
        }
        return m30975a(signature.toByteArray());
    }

    /* renamed from: a */
    private String m30972a() {
        JSONArray jSONArray = new JSONArray();
        Context context = this.f41264u;
        if (context == null) {
            return jSONArray.toString();
        }
        try {
            for (Signature signature : SystemUtils.getPackageInfo(context.getPackageManager(), this.f41264u.getPackageName(), 64).signatures) {
                try {
                    X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
                    JSONObject jSONObject = new JSONObject();
                    Principal subjectDN = x509Certificate.getSubjectDN();
                    if (subjectDN != null) {
                        jSONObject.put(RavenKey.STACK, subjectDN.getName());
                    }
                    Principal issuerDN = x509Certificate.getIssuerDN();
                    if (issuerDN != null) {
                        jSONObject.put("i", issuerDN.getName());
                    }
                    jSONObject.put("sha1", m30973a(signature));
                    jSONArray.put(jSONObject);
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
        }
        return jSONArray.toString();
    }

    /* renamed from: a */
    private String m30974a(String str) {
        String str2;
        if (str == null || !str.contains(":")) {
            return null;
        }
        String[] split = str.split(":");
        if (split.length != 2 || (str2 = split[1]) == null) {
            return null;
        }
        return str2.trim();
    }

    /* renamed from: b */
    private int m30976b() {
        try {
            return new File(Coder.decode("C91F1A0DC9070F1E1D131DC91D0F0D03100F0EC91D131DC9")).listFiles(new FileFilter() {
                public boolean accept(File file) {
                    return Pattern.matches(Coder.decode("F7D3C7DAF51F1A0D"), file.getName());
                }
            }).length;
        } catch (Exception unused) {
            return 1;
        }
    }

    /* renamed from: c */
    private long m30977c() {
        long j = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(Coder.decode("1B0F1C00F9120B07F9090008031F1A0DC91B0F1C001F1A0DC9DA1F1A0DC91F1A0DC9070F1E1D131DC91D0F0D03100F0EC91D131DC9")));
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                j = Long.parseLong(readLine);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return j;
    }

    /* renamed from: d */
    private String m30978d() {
        File file = new File(Coder.decode("090008031F1A0DC90D091C1AC9"));
        JSONObject jSONObject = new JSONObject();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (readLine.startsWith(Coder.decode("1C091D1D0F0D091CFA"))) {
                    jSONObject.put(Coder.decode("060F0E09E71F1A0D"), m30974a(readLine));
                } else if (readLine.startsWith(Coder.decode("0F1C0B110E1C0BE2"))) {
                    jSONObject.put(Coder.decode("1C090E080FF01F1A0D"), m30974a(readLine));
                }
            }
            bufferedReader.close();
            jSONObject.put(Coder.decode("1E081F09ED1F1A0D"), m30976b());
            jSONObject.put(Coder.decode("1B0F1CE0120B07"), m30977c());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* renamed from: e */
    private String m30979e() {
        Context context = this.f41264u;
        if (context == null) {
            return null;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return String.format("%d,%d,%d", new Object[]{Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels), Integer.valueOf(displayMetrics.densityDpi)});
    }

    public Object get(int i) {
        if (i == f41244a) {
            return m30972a();
        }
        if (i == f41245b) {
            return m30978d();
        }
        if (i == f41246c) {
            return new BuildInfo().getInfo();
        }
        if (i == f41247d) {
            return m30979e();
        }
        if (i == f41248e) {
            return new NetUtils().netInterfaceInfo();
        }
        if (i == f41249f) {
            return new RunningServices().services(this.f41264u);
        }
        if (i == f41250g) {
            return new BatteryInfo().getBatteryInfo(this.f41264u);
        }
        if (i == f41251h) {
            return new Zpose().checkInfo();
        }
        if (i == f41252i) {
            return new GpsInfo().getGpsInfo(this.f41264u);
        }
        return null;
    }

    public String toHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(this.f41265v[(b >> 4) & 15]);
            sb.append(this.f41265v[b & Ascii.f55148SI]);
        }
        return sb.toString();
    }
}
