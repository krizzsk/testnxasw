package com.didi.dvm.patch.dvm_patch;

import android.os.Handler;
import android.os.Looper;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DVMPatchDownloader {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static Logger f21149a = LoggerFactory.getLogger("DVMPatchDownloader");

    /* renamed from: b */
    private Map<String, PatchElement> f21150b = new ConcurrentHashMap();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f21151c = 7;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f21152d = 2;

    public void addTask(PatchElement patchElement) {
        this.f21150b.put(patchElement.f21171id, patchElement);
    }

    public void start() {
        this.f21151c = ((Integer) DVMPatchManager.getParam("delay", Integer.valueOf(this.f21151c))).intValue();
        this.f21152d = ((Integer) DVMPatchManager.getParam("retry", Integer.valueOf(this.f21152d))).intValue();
        if (this.f21150b.size() > 0) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                public void run() {
                    DVMPatchDownloader.this.m17847b();
                }
            }, ((long) this.f21151c) * 1000);
        } else {
            DVMPatchManager.takeEffect(true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17847b() {
        for (Map.Entry<String, PatchElement> value : this.f21150b.entrySet()) {
            final PatchElement patchElement = (PatchElement) value.getValue();
            new Thread(new Runnable() {
                int code = -1;

                /* JADX WARNING: Removed duplicated region for block: B:36:0x018a  */
                /* JADX WARNING: Removed duplicated region for block: B:37:0x01e3 A[SYNTHETIC, Splitter:B:37:0x01e3] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r18 = this;
                        r1 = r18
                        java.lang.String r2 = "zip file not validate"
                        java.lang.String r3 = "v"
                        java.lang.String r4 = "bin"
                        java.lang.String r5 = "id"
                        java.lang.String r6 = "download file "
                        com.didi.dvm.patch.dvm_patch.DVMPatchDownloader r0 = com.didi.dvm.patch.dvm_patch.DVMPatchDownloader.this
                        int r0 = r0.f21152d
                        int r7 = r0 + 1
                        r9 = 0
                    L_0x0017:
                        if (r9 >= r7) goto L_0x01fd
                        long r10 = android.os.SystemClock.uptimeMillis()     // Catch:{ Exception -> 0x0181 }
                        com.didichuxing.foundation.rpc.RpcServiceFactory r0 = new com.didichuxing.foundation.rpc.RpcServiceFactory     // Catch:{ Exception -> 0x0181 }
                        android.content.Context r12 = com.didi.dvm.patch.dvm_patch.DVMPatchManager.f21160h     // Catch:{ Exception -> 0x0181 }
                        r0.<init>(r12)     // Catch:{ Exception -> 0x0181 }
                        java.lang.String r12 = "http"
                        com.didichuxing.foundation.rpc.RpcClient r0 = r0.getRpcClient(r12)     // Catch:{ Exception -> 0x0181 }
                        com.didichuxing.foundation.net.rpc.http.HttpRpcClient r0 = (com.didichuxing.foundation.net.rpc.http.HttpRpcClient) r0     // Catch:{ Exception -> 0x0181 }
                        com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$Builder r12 = new com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$Builder     // Catch:{ Exception -> 0x0181 }
                        r12.<init>()     // Catch:{ Exception -> 0x0181 }
                        com.didi.dvm.patch.dvm_patch.PatchElement r13 = r1     // Catch:{ Exception -> 0x0181 }
                        java.lang.String r13 = r13.bin     // Catch:{ Exception -> 0x0181 }
                        com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$Builder r12 = r12.get(r13)     // Catch:{ Exception -> 0x0181 }
                        com.didichuxing.foundation.net.rpc.http.HttpRpcRequest r12 = r12.build()     // Catch:{ Exception -> 0x0181 }
                        com.didichuxing.foundation.net.rpc.http.HttpRpc r0 = r0.newRpc((com.didichuxing.foundation.net.rpc.http.HttpRpcRequest) r12)     // Catch:{ Exception -> 0x0181 }
                        com.didichuxing.foundation.rpc.RpcResponse r0 = r0.execute()     // Catch:{ Exception -> 0x0181 }
                        com.didichuxing.foundation.net.rpc.http.HttpRpcResponse r0 = (com.didichuxing.foundation.net.rpc.http.HttpRpcResponse) r0     // Catch:{ Exception -> 0x0181 }
                        int r12 = r0.getStatus()     // Catch:{ Exception -> 0x0181 }
                        r1.code = r12     // Catch:{ Exception -> 0x0181 }
                        boolean r12 = r0.isSuccessful()     // Catch:{ Exception -> 0x0181 }
                        if (r12 == 0) goto L_0x0132
                        com.didichuxing.foundation.net.http.HttpEntity r14 = r0.getEntity()     // Catch:{ Exception -> 0x012d }
                        long r14 = r14.getContentLength()     // Catch:{ Exception -> 0x012d }
                        com.didi.sdk.logging.Logger r12 = com.didi.dvm.patch.dvm_patch.DVMPatchDownloader.f21149a     // Catch:{ Exception -> 0x012d }
                        java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012d }
                        r13.<init>()     // Catch:{ Exception -> 0x012d }
                        java.lang.String r8 = "total = "
                        r13.append(r8)     // Catch:{ Exception -> 0x012d }
                        r13.append(r14)     // Catch:{ Exception -> 0x012d }
                        java.lang.String r8 = r13.toString()     // Catch:{ Exception -> 0x012d }
                        r13 = 0
                        java.lang.Object[] r14 = new java.lang.Object[r13]     // Catch:{ Exception -> 0x012d }
                        r12.debug((java.lang.String) r8, (java.lang.Object[]) r14)     // Catch:{ Exception -> 0x012d }
                        r8 = 10240(0x2800, float:1.4349E-41)
                        byte[] r8 = new byte[r8]     // Catch:{ Exception -> 0x012d }
                        java.io.RandomAccessFile r12 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x012d }
                        com.didi.dvm.patch.dvm_patch.PatchElement r13 = r1     // Catch:{ Exception -> 0x012d }
                        java.io.File r13 = r13.createDownloadTempFile()     // Catch:{ Exception -> 0x012d }
                        java.lang.String r14 = "rw"
                        r12.<init>(r13, r14)     // Catch:{ Exception -> 0x012d }
                        com.didichuxing.foundation.net.http.HttpEntity r0 = r0.getEntity()     // Catch:{ Exception -> 0x012d }
                        java.io.InputStream r0 = r0.getContent()     // Catch:{ Exception -> 0x012d }
                        r13 = 0
                    L_0x0093:
                        int r15 = r0.read(r8)     // Catch:{ Exception -> 0x012d }
                        if (r15 <= 0) goto L_0x00a8
                        r16 = r6
                        r17 = r7
                        long r6 = (long) r15
                        long r13 = r13 + r6
                        r6 = 0
                        r12.write(r8, r6, r15)     // Catch:{ Exception -> 0x017c }
                        r6 = r16
                        r7 = r17
                        goto L_0x0093
                    L_0x00a8:
                        r16 = r6
                        r17 = r7
                        r12.close()     // Catch:{ Exception -> 0x017c }
                        com.didi.sdk.logging.Logger r0 = com.didi.dvm.patch.dvm_patch.DVMPatchDownloader.f21149a     // Catch:{ Exception -> 0x017c }
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x017c }
                        r6.<init>()     // Catch:{ Exception -> 0x017c }
                        java.lang.String r7 = "downloading End, downloadSize = "
                        r6.append(r7)     // Catch:{ Exception -> 0x017c }
                        r6.append(r13)     // Catch:{ Exception -> 0x017c }
                        java.lang.String r7 = " fileUrl = "
                        r6.append(r7)     // Catch:{ Exception -> 0x017c }
                        com.didi.dvm.patch.dvm_patch.PatchElement r7 = r1     // Catch:{ Exception -> 0x017c }
                        java.lang.String r7 = r7.bin     // Catch:{ Exception -> 0x017c }
                        r6.append(r7)     // Catch:{ Exception -> 0x017c }
                        java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x017c }
                        r7 = 0
                        java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x017c }
                        r0.info((java.lang.String) r6, (java.lang.Object[]) r8)     // Catch:{ Exception -> 0x017c }
                        com.didi.dvm.patch.dvm_patch.PatchElement r0 = r1     // Catch:{ Exception -> 0x017c }
                        boolean r0 = r0.verify()     // Catch:{ Exception -> 0x017c }
                        if (r0 == 0) goto L_0x011d
                        com.didi.dvm.patch.dvm_patch.PatchElement r0 = r1     // Catch:{ Exception -> 0x017c }
                        r0.takeEffect()     // Catch:{ Exception -> 0x017c }
                        com.didi.dvm.patch.dvm_patch.DVMPatchManager.tryRefresh()     // Catch:{ Exception -> 0x017c }
                        java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x017c }
                        r0.<init>()     // Catch:{ Exception -> 0x017c }
                        com.didi.dvm.patch.dvm_patch.PatchElement r6 = r1     // Catch:{ Exception -> 0x017c }
                        java.lang.String r6 = r6.f21171id     // Catch:{ Exception -> 0x017c }
                        r0.put(r5, r6)     // Catch:{ Exception -> 0x017c }
                        com.didi.dvm.patch.dvm_patch.PatchElement r6 = r1     // Catch:{ Exception -> 0x017c }
                        long r6 = r6.version     // Catch:{ Exception -> 0x017c }
                        java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x017c }
                        r0.put(r3, r6)     // Catch:{ Exception -> 0x017c }
                        java.lang.String r6 = "t"
                        long r7 = android.os.SystemClock.uptimeMillis()     // Catch:{ Exception -> 0x017c }
                        long r7 = r7 - r10
                        java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ Exception -> 0x017c }
                        r0.put(r6, r7)     // Catch:{ Exception -> 0x017c }
                        com.didi.dvm.patch.dvm_patch.PatchElement r6 = r1     // Catch:{ Exception -> 0x017c }
                        java.lang.String r6 = r6.bin     // Catch:{ Exception -> 0x017c }
                        r0.put(r4, r6)     // Catch:{ Exception -> 0x017c }
                        com.didi.dvm.patch.dvm_patch.EventTracker r6 = com.didi.dvm.patch.dvm_patch.DVMPatchManager.f21155c     // Catch:{ Exception -> 0x017c }
                        java.lang.String r7 = "tech_dvm_patch_download_success"
                        r6.mo63966a(r7, r0)     // Catch:{ Exception -> 0x017c }
                        goto L_0x01fd
                    L_0x011d:
                        com.didi.sdk.logging.Logger r0 = com.didi.dvm.patch.dvm_patch.DVMPatchDownloader.f21149a     // Catch:{ Exception -> 0x017c }
                        r6 = 0
                        java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x017c }
                        r0.info((java.lang.String) r2, (java.lang.Object[]) r7)     // Catch:{ Exception -> 0x017c }
                        java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x017c }
                        r0.<init>(r2)     // Catch:{ Exception -> 0x017c }
                        throw r0     // Catch:{ Exception -> 0x017c }
                    L_0x012d:
                        r0 = move-exception
                        r17 = r7
                        r7 = r6
                        goto L_0x017f
                    L_0x0132:
                        r16 = r6
                        r17 = r7
                        com.didi.sdk.logging.Logger r0 = com.didi.dvm.patch.dvm_patch.DVMPatchDownloader.f21149a     // Catch:{ Exception -> 0x017c }
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x017c }
                        r6.<init>()     // Catch:{ Exception -> 0x017c }
                        r7 = r16
                        r6.append(r7)     // Catch:{ Exception -> 0x017a }
                        com.didi.dvm.patch.dvm_patch.PatchElement r8 = r1     // Catch:{ Exception -> 0x017a }
                        java.lang.String r8 = r8.bin     // Catch:{ Exception -> 0x017a }
                        r6.append(r8)     // Catch:{ Exception -> 0x017a }
                        java.lang.String r8 = " error,code:"
                        r6.append(r8)     // Catch:{ Exception -> 0x017a }
                        int r8 = r1.code     // Catch:{ Exception -> 0x017a }
                        r6.append(r8)     // Catch:{ Exception -> 0x017a }
                        java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x017a }
                        r8 = 0
                        java.lang.Object[] r10 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0178 }
                        r0.error((java.lang.String) r6, (java.lang.Object[]) r10)     // Catch:{ Exception -> 0x0178 }
                        java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x0178 }
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0178 }
                        r6.<init>()     // Catch:{ Exception -> 0x0178 }
                        java.lang.String r10 = "http code is not 200,code is "
                        r6.append(r10)     // Catch:{ Exception -> 0x0178 }
                        int r10 = r1.code     // Catch:{ Exception -> 0x0178 }
                        r6.append(r10)     // Catch:{ Exception -> 0x0178 }
                        java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0178 }
                        r0.<init>(r6)     // Catch:{ Exception -> 0x0178 }
                        throw r0     // Catch:{ Exception -> 0x0178 }
                    L_0x0178:
                        r0 = move-exception
                        goto L_0x0186
                    L_0x017a:
                        r0 = move-exception
                        goto L_0x017f
                    L_0x017c:
                        r0 = move-exception
                        r7 = r16
                    L_0x017f:
                        r8 = 0
                        goto L_0x0186
                    L_0x0181:
                        r0 = move-exception
                        r17 = r7
                        r8 = 0
                        r7 = r6
                    L_0x0186:
                        int r6 = r17 + -1
                        if (r9 != r6) goto L_0x01e3
                        com.didi.sdk.logging.Logger r6 = com.didi.dvm.patch.dvm_patch.DVMPatchDownloader.f21149a
                        java.lang.StringBuilder r10 = new java.lang.StringBuilder
                        r10.<init>()
                        r10.append(r7)
                        com.didi.dvm.patch.dvm_patch.PatchElement r11 = r1
                        java.lang.String r11 = r11.bin
                        r10.append(r11)
                        java.lang.String r11 = " error"
                        r10.append(r11)
                        java.lang.String r10 = r10.toString()
                        r6.error((java.lang.String) r10, (java.lang.Throwable) r0)
                        java.util.HashMap r6 = new java.util.HashMap
                        r6.<init>()
                        com.didi.dvm.patch.dvm_patch.PatchElement r10 = r1
                        java.lang.String r10 = r10.f21171id
                        r6.put(r5, r10)
                        com.didi.dvm.patch.dvm_patch.PatchElement r10 = r1
                        java.lang.String r10 = r10.bin
                        r6.put(r4, r10)
                        java.lang.String r10 = r0.toString()
                        java.lang.String r11 = "e"
                        r6.put(r11, r10)
                        java.lang.String r0 = com.didi.dvm.patch.dvm_patch.EventTracker.getStackTrace(r0)
                        java.lang.String r10 = "s"
                        r6.put(r10, r0)
                        com.didi.dvm.patch.dvm_patch.PatchElement r0 = r1
                        long r10 = r0.version
                        java.lang.Long r0 = java.lang.Long.valueOf(r10)
                        r6.put(r3, r0)
                        com.didi.dvm.patch.dvm_patch.EventTracker r0 = com.didi.dvm.patch.dvm_patch.DVMPatchManager.f21155c
                        java.lang.String r10 = "tech_dvm_patch_download_error"
                        r0.mo63966a(r10, r6)
                        goto L_0x01f6
                    L_0x01e3:
                        com.didi.dvm.patch.dvm_patch.DVMPatchDownloader r0 = com.didi.dvm.patch.dvm_patch.DVMPatchDownloader.this     // Catch:{ InterruptedException -> 0x01f2 }
                        int r0 = r0.f21151c     // Catch:{ InterruptedException -> 0x01f2 }
                        long r10 = (long) r0     // Catch:{ InterruptedException -> 0x01f2 }
                        r12 = 1000(0x3e8, double:4.94E-321)
                        long r10 = r10 * r12
                        java.lang.Thread.sleep(r10)     // Catch:{ InterruptedException -> 0x01f2 }
                        goto L_0x01f6
                    L_0x01f2:
                        r0 = move-exception
                        r0.printStackTrace()
                    L_0x01f6:
                        int r9 = r9 + 1
                        r6 = r7
                        r7 = r17
                        goto L_0x0017
                    L_0x01fd:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.didi.dvm.patch.dvm_patch.DVMPatchDownloader.C85422.run():void");
                }
            }).start();
        }
    }
}
