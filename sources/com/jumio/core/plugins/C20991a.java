package com.jumio.core.plugins;

import com.jumio.core.util.ReflectionUtil;
import java.util.ArrayList;

/* renamed from: com.jumio.core.plugins.a */
/* compiled from: PluginRegistry */
public class C20991a {

    /* renamed from: a */
    public static final Object f57786a = new Object();

    /* renamed from: b */
    public static String f57787b = "com.jumio.core.extraction.linefinder.LineFinderPlugin";

    /* renamed from: c */
    public static String f57788c = "com.jumio.core.extraction.mrz.MrzPlugin";

    /* renamed from: d */
    public static String f57789d = "com.jumio.core.extraction.nfc.NfcPlugin";

    /* renamed from: e */
    public static String f57790e = "com.jumio.core.extraction.barcode.BarcodePlugin";

    /* renamed from: f */
    public static String f57791f = "com.jumio.core.extraction.barcode.vision.BarcodeVisionPlugin";

    /* renamed from: g */
    public static String f57792g = "com.jumio.core.extraction.facemanual.FaceManualPlugin";

    /* renamed from: h */
    public static String f57793h = "com.jumio.iproov.IproovPlugin";

    /* renamed from: i */
    public static String f57794i = "com.iproov.sdk.IProov";

    /* renamed from: j */
    public static String f57795j = "com.jumio.datadog.DataDogPlugin";

    /* renamed from: k */
    public static String f57796k = "com.datadog.android.Datadog";

    /* renamed from: l */
    public static String f57797l = "com.jumio.emulator.EmulatorPlugin";

    /* renamed from: com.jumio.core.plugins.a$a */
    /* compiled from: PluginRegistry */
    public static /* synthetic */ class C20992a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f57798a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f57799b;

        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|(3:27|28|30)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|(3:27|28|30)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0059 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x007b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0087 */
        static {
            /*
                com.jumio.core.plugins.a$b[] r0 = com.jumio.core.plugins.C20991a.C20993b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f57799b = r0
                r1 = 1
                com.jumio.core.plugins.a$b r2 = com.jumio.core.plugins.C20991a.C20993b.IPROOV     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f57799b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.jumio.core.plugins.a$b r3 = com.jumio.core.plugins.C20991a.C20993b.DATADOG     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.jumio.core.plugins.a$c[] r2 = com.jumio.core.plugins.C20991a.C20994c.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f57798a = r2
                com.jumio.core.plugins.a$c r3 = com.jumio.core.plugins.C20991a.C20994c.MRZ     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = f57798a     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.jumio.core.plugins.a$c r2 = com.jumio.core.plugins.C20991a.C20994c.NFC     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = f57798a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.jumio.core.plugins.a$c r1 = com.jumio.core.plugins.C20991a.C20994c.BARCODE     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f57798a     // Catch:{ NoSuchFieldError -> 0x004e }
                com.jumio.core.plugins.a$c r1 = com.jumio.core.plugins.C20991a.C20994c.BARCODE_NATIVE     // Catch:{ NoSuchFieldError -> 0x004e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f57798a     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.jumio.core.plugins.a$c r1 = com.jumio.core.plugins.C20991a.C20994c.LINEFINDER     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r0 = f57798a     // Catch:{ NoSuchFieldError -> 0x0064 }
                com.jumio.core.plugins.a$c r1 = com.jumio.core.plugins.C20991a.C20994c.MANUAL     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                int[] r0 = f57798a     // Catch:{ NoSuchFieldError -> 0x006f }
                com.jumio.core.plugins.a$c r1 = com.jumio.core.plugins.C20991a.C20994c.FACE_IPROOV     // Catch:{ NoSuchFieldError -> 0x006f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006f }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006f }
            L_0x006f:
                int[] r0 = f57798a     // Catch:{ NoSuchFieldError -> 0x007b }
                com.jumio.core.plugins.a$c r1 = com.jumio.core.plugins.C20991a.C20994c.FACE_MANUAL     // Catch:{ NoSuchFieldError -> 0x007b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007b }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                int[] r0 = f57798a     // Catch:{ NoSuchFieldError -> 0x0087 }
                com.jumio.core.plugins.a$c r1 = com.jumio.core.plugins.C20991a.C20994c.DATADOG     // Catch:{ NoSuchFieldError -> 0x0087 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                int[] r0 = f57798a     // Catch:{ NoSuchFieldError -> 0x0093 }
                com.jumio.core.plugins.a$c r1 = com.jumio.core.plugins.C20991a.C20994c.EMULATOR     // Catch:{ NoSuchFieldError -> 0x0093 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0093 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0093 }
            L_0x0093:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.plugins.C20991a.C20992a.<clinit>():void");
        }
    }

    /* renamed from: com.jumio.core.plugins.a$b */
    /* compiled from: PluginRegistry */
    public enum C20993b {
        IPROOV,
        DATADOG
    }

    /* renamed from: com.jumio.core.plugins.a$c */
    /* compiled from: PluginRegistry */
    public enum C20994c {
        MRZ(new C20993b[0]),
        NFC(new C20993b[0]),
        BARCODE(new C20993b[0]),
        BARCODE_NATIVE(new C20993b[0]),
        LINEFINDER(new C20993b[0]),
        MANUAL(new C20993b[0]),
        FACE_MANUAL(new C20993b[0]),
        FACE_IPROOV(C20993b.IPROOV),
        DATADOG(C20993b.DATADOG),
        EMULATOR(new C20993b[0]);
        

        /* renamed from: a */
        public final C20993b[] f57814a;

        /* access modifiers changed from: public */
        C20994c(C20993b... bVarArr) {
            this.f57814a = bVarArr;
        }
    }

    /* renamed from: a */
    public static String m43780a(C20994c cVar) {
        switch (C20992a.f57798a[cVar.ordinal()]) {
            case 1:
                return f57788c;
            case 2:
                return f57789d;
            case 3:
                return f57790e;
            case 4:
                return f57791f;
            case 5:
                return f57787b;
            case 6:
                return "com.jumio.core.extraction.manual.ManualPicturePlugin";
            case 7:
                return f57793h;
            case 8:
                return f57792g;
            case 9:
                return f57795j;
            case 10:
                return f57797l;
            default:
                return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:2|3|4|(3:6|7|8)|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0015 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T extends jumio.core.C19467c0> T m43783b(com.jumio.core.plugins.C20991a.C20994c r2) {
        /*
            java.lang.Object r0 = f57786a
            monitor-enter(r0)
            java.lang.String r2 = m43780a((com.jumio.core.plugins.C20991a.C20994c) r2)     // Catch:{ all -> 0x0017 }
            java.lang.Class r2 = com.jumio.core.util.ReflectionUtil.getClass(r2)     // Catch:{ all -> 0x0017 }
            r1 = 0
            if (r2 == 0) goto L_0x0015
            java.lang.Object r2 = r2.newInstance()     // Catch:{ all -> 0x0015 }
            jumio.core.c0 r2 = (jumio.core.C19467c0) r2     // Catch:{ all -> 0x0015 }
            r1 = r2
        L_0x0015:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            return r1
        L_0x0017:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.plugins.C20991a.m43783b(com.jumio.core.plugins.a$c):jumio.core.c0");
    }

    /* renamed from: c */
    public static boolean m43784c(C20994c cVar) {
        boolean z;
        synchronized (f57786a) {
            z = ReflectionUtil.getClass(m43780a(cVar)) != null;
            if (cVar.f57814a.length != 0) {
                z &= m43782a(cVar.f57814a);
            }
        }
        return z;
    }

    /* renamed from: a */
    public static String m43779a(C20993b bVar) {
        int i = C20992a.f57799b[bVar.ordinal()];
        if (i == 1) {
            return f57794i;
        }
        if (i != 2) {
            return null;
        }
        return f57796k;
    }

    /* renamed from: a */
    public static ArrayList<String> m43781a() {
        ArrayList<String> arrayList;
        synchronized (f57786a) {
            arrayList = new ArrayList<>();
            C20994c cVar = C20994c.MRZ;
            if (m43784c(cVar)) {
                arrayList.add(cVar.name());
            }
            C20994c cVar2 = C20994c.NFC;
            if (m43784c(cVar2)) {
                arrayList.add(cVar2.name());
            }
            C20994c cVar3 = C20994c.BARCODE;
            if (m43784c(cVar3)) {
                arrayList.add(cVar3.name());
            }
            C20994c cVar4 = C20994c.BARCODE_NATIVE;
            if (m43784c(cVar4)) {
                arrayList.add(cVar4.name());
            }
            C20994c cVar5 = C20994c.LINEFINDER;
            if (m43784c(cVar5)) {
                arrayList.add(cVar5.name());
            }
            C20994c cVar6 = C20994c.MANUAL;
            if (m43784c(cVar6)) {
                arrayList.add(cVar6.name());
            }
            C20994c cVar7 = C20994c.FACE_MANUAL;
            if (m43784c(cVar7)) {
                arrayList.add(cVar7.name());
            }
            C20994c cVar8 = C20994c.FACE_IPROOV;
            if (m43784c(cVar8)) {
                arrayList.add(cVar8.name());
            }
            C20994c cVar9 = C20994c.DATADOG;
            if (m43784c(cVar9)) {
                arrayList.add(cVar9.name());
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static boolean m43782a(C20993b... bVarArr) {
        boolean z;
        synchronized (f57786a) {
            int length = bVarArr.length;
            z = true;
            for (int i = 0; i < length; i++) {
                z &= ReflectionUtil.getClass(m43779a(bVarArr[i])) != null;
            }
        }
        return z;
    }
}
