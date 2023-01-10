package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.tqttqq;
import com.threatmetrix.TrustDefender.yqyqqy;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class qqqyqy {
    private static final Lock b007000700070p00700070 = new ReentrantLock();
    private static volatile qqqyqy b00700070pp00700070 = null;
    private static final String b0070p0070p00700070 = "Native code:";
    private static final String bp00700070p00700070 = "Thread interrupt detected, throwing";
    private static final String bpp0070p00700070 = yyyyqy.b0074t007400740074t(qqqyqy.class);
    private boolean b00700070p007000700070 = false;
    public boolean b0070pp007000700070 = false;
    private final Lock bp0070p007000700070 = new ReentrantLock();
    private final NativeGathererHelper bppp007000700070 = new NativeGathererHelper();

    private qqqyqy() {
    }

    public static qqqyqy bg00670067g0067g() {
        if (b00700070pp00700070 == null) {
            try {
                b007000700070p00700070.lock();
                if (b00700070pp00700070 == null) {
                    b00700070pp00700070 = new qqqyqy();
                }
            } finally {
                b007000700070p00700070.unlock();
            }
        }
        return b00700070pp00700070;
    }

    @Nullable
    public static yqyqqy.qqyqqy[] bgggg0067g() {
        try {
            if (bg00670067g0067g().b00670067ggg0067()) {
                return (yqyqqy.qqyqqy[]) bg00670067g0067g().b0067gg00670067g().getAddresses(yqyqqy.qqyqqy.class);
            }
            return null;
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
            return null;
        }
    }

    public String b00670067006700670067g(String str) {
        try {
            return this.b0070pp007000700070 ? this.bppp007000700070.getTextSectionHash(str) : "";
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
            return "";
        }
    }

    public String b0067006700670067g0067(String str) {
        try {
            if (this.b0070pp007000700070) {
                return this.bppp007000700070.validatePackage(str);
            }
            return null;
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
            return null;
        }
    }

    public void b0067006700670067gg() {
        if (this.b0070pp007000700070) {
            this.bppp007000700070.finit();
        }
        this.b0070pp007000700070 = false;
    }

    public int b006700670067g0067g(tqtqqt tqtqqt, @Nonnull String str, @Nullable String str2) {
        try {
            if (!this.b0070pp007000700070 || str2 == null) {
                return -1;
            }
            return this.bppp007000700070.getIntConfig(tqtqqt.bll006C006C006C006C, str, str2);
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
            return -1;
        }
    }

    public void b006700670067gg0067(int i) {
        try {
            if (this.b0070pp007000700070) {
                this.bppp007000700070.setInfoLogging(i);
            }
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
        }
    }

    @Nullable
    public String b00670067g00670067g(int i) {
        try {
            if (!this.b0070pp007000700070 || i <= 0) {
                return null;
            }
            return this.bppp007000700070.getRandomString(i);
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
            return null;
        }
    }

    @Nullable
    public String b00670067g0067g0067(@Nonnull byte[] bArr) {
        try {
            if (!this.b0070pp007000700070 || bArr == null || bArr.length <= 0) {
                return null;
            }
            return this.bppp007000700070.sha1Base32Encode(bArr);
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
            return null;
        }
    }

    @Nullable
    public String b00670067gg0067g(@Nonnull tqtqqt tqtqqt) {
        try {
            if (!this.b0070pp007000700070 || tqttqq.ttttqq.qqqqtq.b006E006En006En006E >= tqttqq.ttttqq.tqqqtq.bkk006Bkkk) {
                return null;
            }
            return this.bppp007000700070.getConnections(tqtqqt.bll006C006C006C006C);
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
            return null;
        }
    }

    public boolean b00670067ggg0067() {
        return this.b0070pp007000700070;
    }

    @Nullable
    public String b0067g006700670067g(tqtqqt tqtqqt, @Nonnull String str, @Nullable String str2) {
        try {
            if (!this.b0070pp007000700070 || str2 == null) {
                return null;
            }
            return this.bppp007000700070.getStringConfig(tqtqqt.bll006C006C006C006C, str, str2);
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
            return null;
        }
    }

    @Nullable
    public String b0067g00670067g0067(@Nullable byte[] bArr) {
        try {
            if (!this.b0070pp007000700070 || bArr == null) {
                return null;
            }
            return this.bppp007000700070.sha256HexEncode(bArr);
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
            return null;
        }
    }

    public int b0067g00670067gg() {
        try {
            if (this.b0070pp007000700070) {
                return this.bppp007000700070.cancel();
            }
            return -1;
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
            return -1;
        }
    }

    @Nullable
    public List<String> b0067g0067g0067g(@Nullable String str) throws InterruptedException {
        String[] fontList;
        List<String> list = null;
        try {
            if (!(!this.b0070pp007000700070 || str == null || (fontList = this.bppp007000700070.getFontList(str)) == null)) {
                list = Arrays.asList(fontList);
            }
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
        }
        if (!Thread.interrupted()) {
            return list;
        }
        yyyyqy.bt0074007400740074t(bpp0070p00700070, bp00700070p00700070);
        throw new InterruptedException();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017 A[RETURN, SYNTHETIC] */
    @javax.annotation.Nonnull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String b0067g0067gg0067(java.lang.String r4) {
        /*
            r3 = this;
            r0 = -1
            boolean r1 = r3.b0070pp007000700070     // Catch:{ all -> 0x000c }
            if (r1 == 0) goto L_0x0014
            com.threatmetrix.TrustDefender.NativeGathererHelper r1 = r3.bppp007000700070     // Catch:{ all -> 0x000c }
            int r4 = r1.jniDetectedDebugStatus(r4)     // Catch:{ all -> 0x000c }
            goto L_0x0015
        L_0x000c:
            r4 = move-exception
            java.lang.String r1 = bpp0070p00700070
            java.lang.String r2 = "Native code:"
            com.threatmetrix.TrustDefender.yyyyqy.b00740074t00740074t(r1, r2, r4)
        L_0x0014:
            r4 = -1
        L_0x0015:
            if (r0 != r4) goto L_0x001a
            java.lang.String r4 = ""
            goto L_0x0023
        L_0x001a:
            if (r4 <= 0) goto L_0x001e
            r4 = 1
            goto L_0x001f
        L_0x001e:
            r4 = 0
        L_0x001f:
            java.lang.String r4 = java.lang.String.valueOf(r4)
        L_0x0023:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.qqqyqy.b0067g0067gg0067(java.lang.String):java.lang.String");
    }

    @Nonnull
    public NativeGathererHelper b0067gg00670067g() {
        return this.bppp007000700070;
    }

    public int b0067gg0067g0067(tqtqqt tqtqqt, @Nonnull String str, @Nullable String str2, long j) throws InterruptedException {
        int i = -1;
        try {
            if (this.b0070pp007000700070 && str2 != null) {
                i = this.bppp007000700070.setLongConfig(tqtqqt.bll006C006C006C006C, str, str2, j);
            }
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
        }
        if (!Thread.interrupted()) {
            return i;
        }
        yyyyqy.bt0074007400740074t(bpp0070p00700070, bp00700070p00700070);
        throw new InterruptedException();
    }

    @Nullable
    public String b0067ggg00670067(@Nullable String str, @Nullable String str2) {
        try {
            if (!this.b0070pp007000700070 || !yqqyqq.b0069ii0069i0069(str2) || !yqqyqq.b0069ii0069i0069(str)) {
                return null;
            }
            return this.bppp007000700070.xor(str, str2);
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
            return null;
        }
    }

    public long b0067ggg0067g(String str) {
        try {
            if (this.b0070pp007000700070) {
                return this.bppp007000700070.getAppTime(str);
            }
            return 0;
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
            return 0;
        }
    }

    public boolean b0067gggg0067(@Nonnull tqtqqt tqtqqt, @Nonnull final String str, boolean z, boolean z2) {
        String[] list;
        String absolutePath = tqtqqt.bll006C006C006C006C.getFilesDir().getAbsolutePath();
        String bu007500750075u0075 = new tqttqq.qtttqq(tqtqqt).bu007500750075u0075();
        if (!(bg0067ggg0067(absolutePath, str, z, z2) || (list = new File(bu007500750075u0075).list(new FilenameFilter() {
            public boolean accept(File file, @Nonnull String str) {
                return str.contains(str);
            }
        })) == null || list.length == 0)) {
            this.b00700070p007000700070 = true;
        }
        return this.b0070pp007000700070;
    }

    public long bg0067006700670067g(int i) {
        try {
            if (this.b0070pp007000700070) {
                return this.bppp007000700070.getTamperCode(i);
            }
            return 0;
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
            return 0;
        }
    }

    @Nullable
    public String bg006700670067g0067(@Nullable String str) {
        try {
            if (!this.b0070pp007000700070 || str == null) {
                return null;
            }
            return this.bppp007000700070.urlEncode(str);
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
            return null;
        }
    }

    @Nullable
    public String[] bg006700670067gg(@Nullable String[] strArr) throws InterruptedException {
        String[] strArr2 = null;
        try {
            yyyyqy.bt0074007400740074t(bpp0070p00700070, this.b0070pp007000700070 ? " available " : "not available ");
            if (this.b0070pp007000700070 && strArr != null) {
                strArr2 = this.bppp007000700070.checkURLs(strArr);
            }
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
        }
        if (!Thread.interrupted()) {
            return strArr2;
        }
        yyyyqy.bt0074007400740074t(bpp0070p00700070, bp00700070p00700070);
        throw new InterruptedException();
    }

    @Nullable
    public String bg00670067gg0067(@Nullable String str) {
        try {
            if (!this.b0070pp007000700070 || str == null) {
                return null;
            }
            return this.bppp007000700070.md5(str);
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
            return null;
        }
    }

    @Nullable
    public String[] bg0067g00670067g() throws InterruptedException {
        String[] strArr = null;
        try {
            if (this.b0070pp007000700070 && tqttqq.ttttqq.qqqqtq.b006E006En006En006E < tqttqq.ttttqq.tqqqtq.bkk006Bkkk) {
                strArr = this.bppp007000700070.getNetworkInfo();
            }
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
        }
        if (!Thread.interrupted()) {
            return strArr;
        }
        yyyyqy.bt0074007400740074t(bpp0070p00700070, bp00700070p00700070);
        throw new InterruptedException();
    }

    public int bg0067g0067g0067(tqtqqt tqtqqt, @Nonnull String str, @Nullable String str2, @Nullable String str3) throws InterruptedException {
        int i = -1;
        try {
            if (!(!this.b0070pp007000700070 || str2 == null || str3 == null)) {
                i = this.bppp007000700070.setStringConfig(tqtqqt.bll006C006C006C006C, str, str2, str3);
            }
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
        }
        if (!Thread.interrupted()) {
            return i;
        }
        yyyyqy.bt0074007400740074t(bpp0070p00700070, bp00700070p00700070);
        throw new InterruptedException();
    }

    @Nullable
    public String bg0067gg0067g() {
        try {
            if (this.b0070pp007000700070) {
                return this.bppp007000700070.getBinaryArch();
            }
            return null;
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
            return null;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0021 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean bg0067ggg0067(java.lang.String r3, java.lang.String r4, boolean r5, boolean r6) {
        /*
            r2 = this;
            boolean r0 = r2.b0070pp007000700070
            if (r0 == 0) goto L_0x0006
            r3 = 1
            return r3
        L_0x0006:
            java.util.concurrent.locks.Lock r0 = r2.bp0070p007000700070     // Catch:{ all -> 0x0035 }
            r0.lock()     // Catch:{ all -> 0x0035 }
            boolean r0 = r2.b0070pp007000700070     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0017
            boolean r3 = r2.b0070pp007000700070     // Catch:{ all -> 0x0035 }
            java.util.concurrent.locks.Lock r4 = r2.bp0070p007000700070
            r4.unlock()
            return r3
        L_0x0017:
            r0 = 0
            com.threatmetrix.TrustDefender.NativeGathererHelper r1 = r2.bppp007000700070     // Catch:{ UnsatisfiedLinkError -> 0x0024, all -> 0x0021 }
            boolean r3 = r1.bg0067gg00670067(r3, r4, r5, r6)     // Catch:{ UnsatisfiedLinkError -> 0x0024, all -> 0x0021 }
            r2.b0070pp007000700070 = r3     // Catch:{ UnsatisfiedLinkError -> 0x0024, all -> 0x0021 }
            goto L_0x002d
        L_0x0021:
            r2.b0070pp007000700070 = r0     // Catch:{ all -> 0x0035 }
            goto L_0x002d
        L_0x0024:
            r3 = move-exception
            java.lang.String r4 = bpp0070p00700070     // Catch:{ all -> 0x0035 }
            java.lang.String r5 = "Native code:"
            com.threatmetrix.TrustDefender.yyyyqy.qyyyqy.b0074tt0074tt(r4, r5, r3)     // Catch:{ all -> 0x0035 }
            goto L_0x0021
        L_0x002d:
            java.util.concurrent.locks.Lock r3 = r2.bp0070p007000700070
            r3.unlock()
            boolean r3 = r2.b0070pp007000700070
            return r3
        L_0x0035:
            r3 = move-exception
            java.util.concurrent.locks.Lock r4 = r2.bp0070p007000700070
            r4.unlock()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.qqqyqy.bg0067ggg0067(java.lang.String, java.lang.String, boolean, boolean):boolean");
    }

    @Nullable
    public qyqqyq bgg006700670067g() throws InterruptedException {
        int selinuxMode;
        qyqqyq qyqqyq = null;
        try {
            if (this.b0070pp007000700070 && ((selinuxMode = this.bppp007000700070.getSelinuxMode()) >= 0 || selinuxMode <= 4)) {
                qyqqyq = qyqqyq.values()[selinuxMode];
            }
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
        }
        if (!Thread.interrupted()) {
            return qyqqyq;
        }
        yyyyqy.bt0074007400740074t(bpp0070p00700070, bp00700070p00700070);
        throw new InterruptedException();
    }

    @Nullable
    public String bgg00670067g0067(@Nullable byte[] bArr) {
        try {
            if (!this.b0070pp007000700070 || bArr == null) {
                return null;
            }
            return this.bppp007000700070.sha1HexEncode(bArr);
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
            return null;
        }
    }

    public int bgg0067g0067g() {
        try {
            if (this.b0070pp007000700070) {
                return this.bppp007000700070.getCpuCores();
            }
            return 0;
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
            return 0;
        }
    }

    public boolean bgg0067gg0067() {
        return this.b00700070p007000700070;
    }

    public long bggg00670067g(tqtqqt tqtqqt, @Nonnull String str, @Nullable String str2) {
        try {
            if (!this.b0070pp007000700070 || str2 == null) {
                return -1;
            }
            return this.bppp007000700070.getLongConfig(tqtqqt.bll006C006C006C006C, str, str2);
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
            return -1;
        }
    }

    public int bggg0067g0067(tqtqqt tqtqqt, @Nonnull String str, @Nullable String str2, int i) throws InterruptedException {
        int i2 = -1;
        try {
            if (this.b0070pp007000700070 && str2 != null) {
                i2 = this.bppp007000700070.setIntConfig(tqtqqt.bll006C006C006C006C, str, str2, i);
            }
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
        }
        if (!Thread.interrupted()) {
            return i2;
        }
        yyyyqy.bt0074007400740074t(bpp0070p00700070, bp00700070p00700070);
        throw new InterruptedException();
    }

    public int bgggg00670067() {
        try {
            if (this.b0070pp007000700070) {
                return this.bppp007000700070.waitUntilCancelled();
            }
            return -1;
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
            return -1;
        }
    }

    @Nullable
    public String bggggg0067(@Nullable String str, tqtttt tqtttt) throws InterruptedException {
        String str2 = null;
        try {
            if (this.b0070pp007000700070 && yqqyqq.b0069ii0069i0069(str)) {
                str2 = this.bppp007000700070.hashFile(str, tqtttt.bf00660066fff);
            }
        } catch (Throwable th) {
            yyyyqy.b00740074t00740074t(bpp0070p00700070, b0070p0070p00700070, th);
        }
        if (!Thread.interrupted()) {
            return str2;
        }
        yyyyqy.bt0074007400740074t(bpp0070p00700070, bp00700070p00700070);
        throw new InterruptedException();
    }
}
