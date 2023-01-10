package com.threatmetrix.TrustDefender;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.threatmetrix.TrustDefender.IInternalService;
import com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk;
import com.threatmetrix.TrustDefender.yyyyqy;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import kotlin.text.Typography;

public class InternalService extends Service {
    private static final String MAGISK = jkkjkk.bb0062bbbbb(">167@7", Typography.registered, 2);
    /* access modifiers changed from: private */
    public static final String TAG = yyyyqy.b0074t007400740074t(InternalService.class);
    public IInternalService.Stub binder = new IInternalService.Stub() {
        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x006e, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0077, code lost:
            throw r2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.util.List<java.lang.String> bq00710071007100710071() {
            /*
                r10 = this;
                java.io.File r0 = new java.io.File
                java.lang.String r1 = "H\u000b\u000e\f\u0001M\u0013\u0006\u000e\tR\u0012\u0015\u001c\u0016\u001d\u001d"
                r2 = 93
                r3 = 5
                java.lang.String r1 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.bb0062bbbbb(r1, r2, r3)
                r0.<init>(r1)
                boolean r1 = r0.exists()
                r2 = 180(0xb4, float:2.52E-43)
                if (r1 == 0) goto L_0x008a
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                r3 = 0
                java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0078 }
                java.io.FileReader r5 = new java.io.FileReader     // Catch:{ IOException -> 0x0078 }
                r5.<init>(r0)     // Catch:{ IOException -> 0x0078 }
                r4.<init>(r5)     // Catch:{ IOException -> 0x0078 }
            L_0x0026:
                java.lang.String r0 = r4.readLine()     // Catch:{ all -> 0x006c }
                if (r0 == 0) goto L_0x0068
                java.lang.String r5 = "8+01:1"
                r6 = 2
                java.lang.String r5 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.bb0062bbbbb(r5, r2, r6)     // Catch:{ all -> 0x006c }
                int r5 = r0.indexOf(r5)     // Catch:{ all -> 0x006c }
                if (r5 <= 0) goto L_0x0026
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x006c }
                r2.<init>()     // Catch:{ all -> 0x006c }
                java.lang.String r6 = "\\]("
                r7 = 90
                r8 = 3
                java.lang.String r6 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.bb0062bbbbb(r6, r7, r8)     // Catch:{ all -> 0x006c }
                r2.append(r6)     // Catch:{ all -> 0x006c }
                java.lang.String r6 = "7*/090"
                r7 = 183(0xb7, float:2.56E-43)
                r8 = 129(0x81, float:1.81E-43)
                r9 = 1
                java.lang.String r6 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.b0062bbbbbb(r6, r7, r8, r9)     // Catch:{ all -> 0x006c }
                int r6 = r6.length()     // Catch:{ all -> 0x006c }
                int r5 = r5 + r6
                java.lang.String r0 = r0.substring(r3, r5)     // Catch:{ all -> 0x006c }
                r2.append(r0)     // Catch:{ all -> 0x006c }
                java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x006c }
                r1.add(r0)     // Catch:{ all -> 0x006c }
            L_0x0068:
                r4.close()     // Catch:{ IOException -> 0x0078 }
                goto L_0x0089
            L_0x006c:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x006e }
            L_0x006e:
                r2 = move-exception
                r4.close()     // Catch:{ all -> 0x0073 }
                goto L_0x0077
            L_0x0073:
                r4 = move-exception
                r0.addSuppressed(r4)     // Catch:{ IOException -> 0x0078 }
            L_0x0077:
                throw r2     // Catch:{ IOException -> 0x0078 }
            L_0x0078:
                java.lang.String r0 = com.threatmetrix.TrustDefender.InternalService.TAG
                r2 = 173(0xad, float:2.42E-43)
                r4 = 38
                java.lang.String r5 = "Kjx2\u0001-}u2\u0007y\u0002|F\u0006\t\u0010\n\u0011\u0011>\u0006\n\u000e\b"
                java.lang.String r2 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.b0062bbbbbb(r5, r2, r4, r3)
                com.threatmetrix.TrustDefender.yyyyqy.qyyyqy.bt00740074ttt(r0, r2)
            L_0x0089:
                return r1
            L_0x008a:
                java.lang.String r0 = com.threatmetrix.TrustDefender.InternalService.TAG
                java.lang.String r1 = "c\u0003\u0011J\u0019E\b\u000b\f\u000f\u001e\u001fL!\u0014\u001c\u0017` #*$++X $(\""
                java.lang.String r1 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.bb0062bbbbb(r1, r2, r3)
                com.threatmetrix.TrustDefender.yyyyqy.qyyyqy.bt00740074ttt(r0, r1)
                r0 = 0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.InternalService.C215651.bq00710071007100710071():java.util.List");
        }

        public List<String> getResults(List<String> list) throws RemoteException {
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList(5);
            tqtqqt tqtqqt = new tqtqqt(InternalService.this.getApplicationContext());
            try {
                yyyyqy.b00740074ttt0074(true);
                boolean b0067gggg0067 = qqqyqy.bg00670067g0067g().b0067gggg0067(tqtqqt, jkkjkk.bb0062bbbbb("&\u001e(\u001f@<24626.rzqunxok(+%", 173, 2), false, false);
                String access$000 = InternalService.TAG;
                yyyyqy.qyyyqy.bt0074tttt(access$000, jkkjkk.bb0062bbbbb(",N?A{I;MAM;t@<4C1AGl59i\u001d\u0015\u001f\u0019*69+$%^", ' ', 2) + b0067gggg0067);
                List<String> b0071qq0071qq = yyqyyy.b0071qq0071qq(tqtqqt, list);
                if (b0071qq0071qq != null && !b0071qq0071qq.isEmpty()) {
                    arrayList.addAll(b0071qq0071qq);
                }
            } catch (InterruptedException e) {
                yyyyqy.qyyyqy.bt00740074ttt(InternalService.TAG, e.toString());
            }
            List<String> bq00710071007100710071 = bq00710071007100710071();
            if (bq00710071007100710071 != null && !bq00710071007100710071.isEmpty()) {
                arrayList.addAll(bq00710071007100710071);
            }
            return arrayList;
        }
    };

    @Nullable
    public IBinder onBind(Intent intent) {
        return this.binder;
    }
}
