package com.threatmetrix.TrustDefender.TMXProfilingConnections;

import com.threatmetrix.TrustDefender.TMXModuleMetadataProviderInterface;
import com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.hkhhhh;
import com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.hkkhhh;
import com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.khhhhh;
import com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.khkhhh;
import com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhhh;
import com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhkh;
import com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkkhhh;
import com.threatmetrix.TrustDefender.TMXProfilingConnectionsInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.osgi.framework.VersionRange;

/* renamed from: com.threatmetrix.TrustDefender.TMXProfilingConnections.TMXProfilingConnections */
public final class C21569TMXProfilingConnections implements TMXModuleMetadataProviderInterface, TMXProfilingConnectionsInterface {
    public static int b006C006Cl006C006Cl = bl006C006C006C006Cl();
    public static int b006Cl006C006C006Cl = 2;
    public static int bll006C006C006Cl = 1;
    public static int blllll006C = bl006C006C006C006Cl();
    private static final String btttt0074t;
    private volatile int b00740074tt0074t = 0;
    @Nullable
    private byte[][] b0074t0074t0074t;
    @Nonnull
    private final List<khhkhh> b0074ttt0074t = new ArrayList(2);
    private ExecutorService bt00740074t0074t = Executors.newCachedThreadPool();
    private volatile int bt0074tt0074t = 10000;
    @Nullable
    private byte[][] btt0074t0074t;

    /* renamed from: com.threatmetrix.TrustDefender.TMXProfilingConnections.TMXProfilingConnections$khhkhh */
    public class khhkhh extends FutureTask<Void> {
        public khhkhh(Runnable runnable, Void voidR) {
            super(runnable, voidR);
        }

        public void run() {
            super.run();
            synchronized (C21569TMXProfilingConnections.b006Ajjj006A006A(C21569TMXProfilingConnections.this)) {
                C21569TMXProfilingConnections.b006Ajjj006A006A(C21569TMXProfilingConnections.this).remove(this);
            }
        }
    }

    static {
        Class<C21569TMXProfilingConnections> cls = C21569TMXProfilingConnections.class;
        int i = b006C006Cl006C006Cl;
        if ((i * (bll006C006C006Cl + i)) % b006Cl006C006C006Cl != 0) {
        }
        try {
            btttt0074t = kkhhhh.bj006A006A006Ajj(cls);
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ List b006Ajjj006A006A(C21569TMXProfilingConnections tMXProfilingConnections) {
        int bl006C006C006C006Cl = bl006C006C006C006Cl();
        if ((bl006C006C006C006Cl * (bll006C006C006Cl + bl006C006C006C006Cl)) % b006Cl006C006C006Cl != 0) {
            b006C006Cl006C006Cl = 28;
            blllll006C = bl006C006C006C006Cl();
        }
        return tMXProfilingConnections.b0074ttt0074t;
    }

    public static int b006C006C006C006C006Cl() {
        return 0;
    }

    public static int b006C006C006Cll006C() {
        return 2;
    }

    private static void bjj006Aj006A006A(@Nullable List<String> list) throws IllegalArgumentException {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                if (str == null || !hkkhhh.bjjjjj006A(str) || 64 != str.length()) {
                    kkhhhh.b006Aj006A006Ajj(btttt0074t, kkhhkh.b006Aj006A006A006A006A("m\u0012\u0019\u0003\r\t\u0003=\u0001\r\u000e\u0002}xu\bw@`\u0005pyunUn\u0002'lnrjgspqgkp\u001buv\u0018fdam\u0013E91!##\fL\\N\bHIHISVFD", 239, 21, 2), str);
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(kkhhkh.bj006A006A006A006A006A("Oktxrr/\u0005\u00012|\u0003~\u000bQ8b\t\u0012}\n\b\u0004@\u0005\b\u0016\u0019\u000f\r\u0011\f\u000b\u001f\u0011[\u001e$\u0012\u001d\u001b\u0016~\u001a/V\u000b\u0001zlpr]'!4*p", 130, 1));
                    int i2 = b006C006Cl006C006Cl;
                    if ((i2 * (bll006C006C006Cl + i2)) % b006C006C006Cll006C() != 0) {
                        b006C006Cl006C006Cl = 92;
                        blllll006C = bl006C006C006C006Cl();
                    }
                    throw illegalArgumentException;
                }
            }
        }
    }

    public static int bl006C006C006C006Cl() {
        return 33;
    }

    public List<khhkhh> b006A006Ajj006A006A() {
        List<khhkhh> list = this.b0074ttt0074t;
        int i = b006C006Cl006C006Cl;
        if ((i * (bll006C006C006Cl + i)) % b006Cl006C006C006Cl != 0) {
            b006C006Cl006C006Cl = 30;
            bll006C006C006Cl = bl006C006C006C006Cl();
        }
        return list;
    }

    public void bj006Ajj006A006A(Runnable runnable) {
        khhkhh khhkhh2 = new khhkhh(runnable, (Void) null);
        synchronized (this.b0074ttt0074t) {
            this.b0074ttt0074t.add(khhkhh2);
        }
        this.bt00740074t0074t.execute(khhkhh2);
    }

    public void cancelProfiling() {
        synchronized (this.b0074ttt0074t) {
            for (khhkhh cancel : this.b0074ttt0074t) {
                cancel.cancel(true);
            }
            this.b0074ttt0074t.clear();
        }
    }

    @Nonnull
    public C21569TMXProfilingConnections disableNonfatalLogs() {
        kkhhhh.bjj006Aj006Aj(true);
        int i = 4;
        while (true) {
            try {
                i /= 0;
            } catch (Exception unused) {
                b006C006Cl006C006Cl = bl006C006C006C006Cl();
                return this;
            }
        }
    }

    public String getModuleVersion() {
        if (((bl006C006C006C006Cl() + bll006C006C006Cl) * bl006C006C006C006Cl()) % b006Cl006C006C006Cl != blllll006C) {
            b006C006Cl006C006Cl = bl006C006C006C006Cl();
            blllll006C = bl006C006C006C006Cl();
        }
        try {
            return kkhhkh.b006Aj006A006A006A006A("zsyt\u0001y", 'p', 210, 3);
        } catch (Exception e) {
            throw e;
        }
    }

    public void httpRequest(@Nonnull TMXProfilingConnectionsInterface.HttpMethod httpMethod, @Nonnull String str, Map<String, String> map, byte[] bArr, TMXProfilingConnectionsInterface.TMXCallback tMXCallback) {
        try {
            try {
                hkhhhh hkhhhh = new hkhhhh(new kkkhhh(this.btt0074t0074t, this.b0074t0074t0074t, this.bt0074tt0074t), httpMethod, str, map, bArr, this.b00740074tt0074t, tMXCallback);
                int i = b006C006Cl006C006Cl;
                if (((bll006C006C006Cl + i) * i) % b006Cl006C006C006Cl != blllll006C) {
                    b006C006Cl006C006Cl = 65;
                    blllll006C = 40;
                }
                bj006Ajj006A006A(hkhhhh);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public void resolveHostByName(String str) {
        while (true) {
            String str2 = null;
            try {
                str2.length();
            } catch (Exception unused) {
                b006C006Cl006C006Cl = 1;
                while (true) {
                    try {
                        str2.length();
                    } catch (Exception unused2) {
                        b006C006Cl006C006Cl = bl006C006C006C006Cl();
                        while (true) {
                            try {
                                str2.length();
                            } catch (Exception unused3) {
                                b006C006Cl006C006Cl = bl006C006C006C006Cl();
                                try {
                                    bj006Ajj006A006A(new khhhhh(str));
                                    return;
                                } catch (Exception e) {
                                    throw e;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Nonnull
    public C21569TMXProfilingConnections setCertificateHashes(String str) throws IllegalArgumentException {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            while (true) {
                try {
                    int[] iArr = new int[-1];
                } catch (Exception unused) {
                    b006C006Cl006C006Cl = 2;
                    try {
                        bjj006Aj006A006A(arrayList);
                        this.btt0074t0074t = hkkhhh.b006A006A006A006A006Aj(arrayList);
                        return this;
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Nonnull
    public C21569TMXProfilingConnections setCertificateHashes(@Nullable List<String> list) throws IllegalArgumentException {
        bjj006Aj006A006A(list);
        String str = btttt0074t;
        StringBuilder sb = new StringBuilder();
        int bl006C006C006C006Cl = bl006C006C006C006Cl();
        if ((bl006C006C006C006Cl * (bll006C006C006Cl + bl006C006C006C006Cl)) % b006Cl006C006C006Cl != 0) {
            b006C006Cl006C006Cl = bl006C006C006C006Cl();
            blllll006C = 78;
        }
        sb.append(kkhhkh.bj006A006A006A006A006A("vw\u0004\u0005xtvol~n(ogxlhu!tn\u001emei\u001a6\u0018", '$', 4));
        sb.append(list);
        kkhhhh.hhkhhh.b00740074tt00740074(str, sb.toString());
        this.btt0074t0074t = hkkhhh.b006A006A006A006A006Aj(list);
        return this;
    }

    public C21569TMXProfilingConnections setConnectionTimeout(int i, TimeUnit timeUnit) {
        int i2 = b006C006Cl006C006Cl;
        if (((bll006C006C006Cl + i2) * i2) % b006Cl006C006C006Cl != b006C006C006C006C006Cl()) {
            b006C006Cl006C006Cl = 52;
            bll006C006C006Cl = bl006C006C006C006Cl();
        }
        this.bt0074tt0074t = (int) timeUnit.toMillis((long) i);
        if (this.bt0074tt0074t < 1) {
            this.bt0074tt0074t = 1;
        }
        return this;
    }

    public C21569TMXProfilingConnections setRetryTimes(int i) {
        if (i > 0) {
            int i2 = b006C006Cl006C006Cl;
            if (((bll006C006C006Cl + i2) * i2) % b006Cl006C006C006Cl != blllll006C) {
                b006C006Cl006C006Cl = 24;
                blllll006C = bl006C006C006C006Cl();
            }
        } else {
            i = 0;
        }
        this.b00740074tt0074t = i;
        return this;
    }

    @Nonnull
    public C21569TMXProfilingConnections setSubjectPublicKeyInfoHashes(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            int i = b006C006Cl006C006Cl;
            if (((bll006C006C006Cl + i) * i) % b006Cl006C006C006Cl != b006C006C006C006C006Cl()) {
                b006C006Cl006C006Cl = 50;
                blllll006C = bl006C006C006C006Cl();
            }
            arrayList.add(str);
            try {
                bjj006Aj006A006A(arrayList);
                this.b0074t0074t0074t = hkkhhh.b006A006A006A006A006Aj(arrayList);
                return this;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public C21569TMXProfilingConnections setSubjectPublicKeyInfoHashes(List<String> list) {
        try {
            bjj006Aj006A006A(list);
            String str = btttt0074t;
            StringBuilder sb = new StringBuilder();
            try {
                String b006Aj006A006A006A006A = kkhhkh.b006Aj006A006A006A006A("eiU^ZS\u000fYRe\u000bRJ[OKX\u0004WQ\u0001PHL|\u0019z", '4', VersionRange.RIGHT_OPEN, 2);
                int i = b006C006Cl006C006Cl;
                if (((bll006C006C006Cl + i) * i) % b006Cl006C006C006Cl != blllll006C) {
                    b006C006Cl006C006Cl = 73;
                    blllll006C = bl006C006C006C006Cl();
                }
                sb.append(b006Aj006A006A006A006A);
                sb.append(list);
                kkhhhh.hhkhhh.b00740074tt00740074(str, sb.toString());
                this.b0074t0074t0074t = hkkhhh.b006A006A006A006A006Aj(list);
                return this;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public void socketRequest(String str, int i, String str2) {
        bj006Ajj006A006A(new khkhhh(str, i, str2, this.bt0074tt0074t));
    }
}
