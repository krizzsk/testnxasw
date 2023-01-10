package p218io.flutter.embedding.engine.systemchannels;

import java.util.HashMap;
import java.util.Map;
import p218io.flutter.Log;
import p218io.flutter.embedding.engine.dart.DartExecutor;
import p218io.flutter.plugin.common.MethodChannel;
import p218io.flutter.plugin.common.StandardMethodCodec;

/* renamed from: io.flutter.embedding.engine.systemchannels.RestorationChannel */
public class RestorationChannel {

    /* renamed from: a */
    private static final String f60496a = "RestorationChannel";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public byte[] f60497b;

    /* renamed from: c */
    private MethodChannel f60498c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MethodChannel.Result f60499d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f60500e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f60501f;

    /* renamed from: g */
    private final MethodChannel.MethodCallHandler f60502g;
    public final boolean waitForRestorationData;

    public RestorationChannel(DartExecutor dartExecutor, boolean z) {
        this(new MethodChannel(dartExecutor, "flutter/restoration", StandardMethodCodec.INSTANCE), z);
    }

    RestorationChannel(MethodChannel methodChannel, boolean z) {
        this.f60500e = false;
        this.f60501f = false;
        C221002 r0 = new MethodChannel.MethodCallHandler() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x0059  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onMethodCall(p218io.flutter.plugin.common.MethodCall r5, p218io.flutter.plugin.common.MethodChannel.Result r6) {
                /*
                    r4 = this;
                    java.lang.String r0 = r5.method
                    java.lang.Object r5 = r5.arguments
                    int r1 = r0.hashCode()
                    r2 = 102230(0x18f56, float:1.43255E-40)
                    r3 = 1
                    if (r1 == r2) goto L_0x001e
                    r2 = 111375(0x1b30f, float:1.5607E-40)
                    if (r1 == r2) goto L_0x0014
                    goto L_0x0028
                L_0x0014:
                    java.lang.String r1 = "put"
                    boolean r0 = r0.equals(r1)
                    if (r0 == 0) goto L_0x0028
                    r0 = 0
                    goto L_0x0029
                L_0x001e:
                    java.lang.String r1 = "get"
                    boolean r0 = r0.equals(r1)
                    if (r0 == 0) goto L_0x0028
                    r0 = 1
                    goto L_0x0029
                L_0x0028:
                    r0 = -1
                L_0x0029:
                    if (r0 == 0) goto L_0x0059
                    if (r0 == r3) goto L_0x0031
                    r6.notImplemented()
                    goto L_0x0064
                L_0x0031:
                    io.flutter.embedding.engine.systemchannels.RestorationChannel r5 = p218io.flutter.embedding.engine.systemchannels.RestorationChannel.this
                    boolean unused = r5.f60501f = r3
                    io.flutter.embedding.engine.systemchannels.RestorationChannel r5 = p218io.flutter.embedding.engine.systemchannels.RestorationChannel.this
                    boolean r5 = r5.f60500e
                    if (r5 != 0) goto L_0x004b
                    io.flutter.embedding.engine.systemchannels.RestorationChannel r5 = p218io.flutter.embedding.engine.systemchannels.RestorationChannel.this
                    boolean r5 = r5.waitForRestorationData
                    if (r5 != 0) goto L_0x0045
                    goto L_0x004b
                L_0x0045:
                    io.flutter.embedding.engine.systemchannels.RestorationChannel r5 = p218io.flutter.embedding.engine.systemchannels.RestorationChannel.this
                    p218io.flutter.plugin.common.MethodChannel.Result unused = r5.f60499d = r6
                    goto L_0x0064
                L_0x004b:
                    io.flutter.embedding.engine.systemchannels.RestorationChannel r5 = p218io.flutter.embedding.engine.systemchannels.RestorationChannel.this
                    byte[] r0 = r5.f60497b
                    java.util.Map r5 = r5.m45625a((byte[]) r0)
                    r6.success(r5)
                    goto L_0x0064
                L_0x0059:
                    io.flutter.embedding.engine.systemchannels.RestorationChannel r0 = p218io.flutter.embedding.engine.systemchannels.RestorationChannel.this
                    byte[] r5 = (byte[]) r5
                    byte[] unused = r0.f60497b = r5
                    r5 = 0
                    r6.success(r5)
                L_0x0064:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: p218io.flutter.embedding.engine.systemchannels.RestorationChannel.C221002.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
            }
        };
        this.f60502g = r0;
        this.f60498c = methodChannel;
        this.waitForRestorationData = z;
        methodChannel.setMethodCallHandler(r0);
    }

    public byte[] getRestorationData() {
        return this.f60497b;
    }

    public void setRestorationData(final byte[] bArr) {
        this.f60500e = true;
        MethodChannel.Result result = this.f60499d;
        if (result != null) {
            result.success(m45625a(bArr));
            this.f60499d = null;
            this.f60497b = bArr;
        } else if (this.f60501f) {
            this.f60498c.invokeMethod("push", m45625a(bArr), new MethodChannel.Result() {
                public void notImplemented() {
                }

                public void success(Object obj) {
                    byte[] unused = RestorationChannel.this.f60497b = bArr;
                }

                public void error(String str, String str2, Object obj) {
                    Log.m45255e(RestorationChannel.f60496a, "Error " + str + " while sending restoration data to framework: " + str2);
                }
            });
        } else {
            this.f60497b = bArr;
        }
    }

    public void clearData() {
        this.f60497b = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Map<String, Object> m45625a(byte[] bArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("enabled", true);
        hashMap.put("data", bArr);
        return hashMap;
    }
}
