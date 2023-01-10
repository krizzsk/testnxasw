package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C20030ag;
import com.google.android.play.core.internal.C20087cj;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Properties;

/* renamed from: com.google.android.play.core.assetpacks.dr */
final class C19987dr {

    /* renamed from: a */
    private static final C20030ag f55981a = new C20030ag("SliceMetadataManager");

    /* renamed from: b */
    private final byte[] f55982b = new byte[8192];

    /* renamed from: c */
    private final C19917bb f55983c;

    /* renamed from: d */
    private final String f55984d;

    /* renamed from: e */
    private final int f55985e;

    /* renamed from: f */
    private final long f55986f;

    /* renamed from: g */
    private final String f55987g;

    /* renamed from: h */
    private int f55988h;

    C19987dr(C19917bb bbVar, String str, int i, long j, String str2) {
        this.f55983c = bbVar;
        this.f55984d = str;
        this.f55985e = i;
        this.f55986f = j;
        this.f55987g = str2;
        this.f55988h = -1;
    }

    /* renamed from: e */
    private final File m42041e() {
        File f = this.f55983c.mo164118f(this.f55984d, this.f55985e, this.f55986f, this.f55987g);
        if (!f.exists()) {
            f.mkdirs();
        }
        return f;
    }

    /* renamed from: f */
    private final File m42042f() throws IOException {
        File c = this.f55983c.mo164106c(this.f55984d, this.f55985e, this.f55986f, this.f55987g);
        c.getParentFile().mkdirs();
        c.createNewFile();
        return c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final C19986dq mo164209a() throws IOException {
        File c = this.f55983c.mo164106c(this.f55984d, this.f55985e, this.f55986f, this.f55987g);
        if (c.exists()) {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(c);
            try {
                properties.load(fileInputStream);
                fileInputStream.close();
                if (properties.getProperty("fileStatus") == null || properties.getProperty("previousChunk") == null) {
                    throw new C19937bv("Slice checkpoint file corrupt.");
                }
                try {
                    int parseInt = Integer.parseInt(properties.getProperty("fileStatus"));
                    String property = properties.getProperty("fileName");
                    long parseLong = Long.parseLong(properties.getProperty("fileOffset", "-1"));
                    long parseLong2 = Long.parseLong(properties.getProperty("remainingBytes", "-1"));
                    int parseInt2 = Integer.parseInt(properties.getProperty("previousChunk"));
                    this.f55988h = Integer.parseInt(properties.getProperty("metadataFileCounter", "0"));
                    return new C19986dq(parseInt, property, parseLong, parseLong2, parseInt2);
                } catch (NumberFormatException e) {
                    throw new C19937bv("Slice checkpoint file corrupt.", (Exception) e);
                }
            } catch (Throwable th) {
                C20087cj.m42281a(th, th);
            }
        } else {
            throw new C19937bv("Slice checkpoint file does not exist.");
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo164210a(int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "3");
        properties.put("fileOffset", String.valueOf(mo164217b().length()));
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.f55988h));
        FileOutputStream fileOutputStream = new FileOutputStream(m42042f());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C20087cj.m42281a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo164211a(long j, byte[] bArr, int i, int i2) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(mo164217b(), "rw");
        try {
            randomAccessFile.seek(j);
            randomAccessFile.write(bArr, i, i2);
            randomAccessFile.close();
            return;
        } catch (Throwable th) {
            C20087cj.m42281a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo164212a(InputStream inputStream, long j) throws IOException {
        int read;
        RandomAccessFile randomAccessFile = new RandomAccessFile(mo164217b(), "rw");
        try {
            randomAccessFile.seek(j);
            do {
                read = inputStream.read(this.f55982b);
                if (read > 0) {
                    randomAccessFile.write(this.f55982b, 0, read);
                }
            } while (read == this.f55982b.length);
            randomAccessFile.close();
            return;
        } catch (Throwable th) {
            C20087cj.m42281a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo164213a(String str, long j, long j2, int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "1");
        properties.put("fileName", str);
        properties.put("fileOffset", String.valueOf(j));
        properties.put("remainingBytes", String.valueOf(j2));
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.f55988h));
        FileOutputStream fileOutputStream = new FileOutputStream(m42042f());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C20087cj.m42281a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo164214a(byte[] bArr) throws IOException {
        FileOutputStream fileOutputStream;
        this.f55988h++;
        try {
            fileOutputStream = new FileOutputStream(new File(m42041e(), String.format("%s-LFH.dat", new Object[]{Integer.valueOf(this.f55988h)})));
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return;
        } catch (IOException e) {
            throw new C19937bv("Could not write metadata file.", (Exception) e);
        } catch (Throwable th) {
            C20087cj.m42281a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo164215a(byte[] bArr, int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "2");
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.f55988h));
        FileOutputStream fileOutputStream = new FileOutputStream(m42042f());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            File d = this.f55983c.mo164110d(this.f55984d, this.f55985e, this.f55986f, this.f55987g);
            if (d.exists()) {
                d.delete();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(d);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.close();
                return;
            } catch (Throwable th) {
                C20087cj.m42281a(th, th);
            }
            throw th;
            throw th;
        } catch (Throwable th2) {
            C20087cj.m42281a(th, th2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo164216a(byte[] bArr, InputStream inputStream) throws IOException {
        this.f55988h++;
        FileOutputStream fileOutputStream = new FileOutputStream(mo164217b());
        try {
            fileOutputStream.write(bArr);
            int read = inputStream.read(this.f55982b);
            while (read > 0) {
                fileOutputStream.write(this.f55982b, 0, read);
                read = inputStream.read(this.f55982b);
            }
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C20087cj.m42281a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final File mo164217b() {
        return new File(m42041e(), String.format("%s-NAM.dat", new Object[]{Integer.valueOf(this.f55988h)}));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo164218b(int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "4");
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.f55988h));
        FileOutputStream fileOutputStream = new FileOutputStream(m42042f());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C20087cj.m42281a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo164219b(byte[] bArr, int i) throws IOException {
        this.f55988h++;
        FileOutputStream fileOutputStream = new FileOutputStream(mo164217b());
        try {
            fileOutputStream.write(bArr, 0, i);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C20087cj.m42281a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final int mo164220c() throws IOException {
        File c = this.f55983c.mo164106c(this.f55984d, this.f55985e, this.f55986f, this.f55987g);
        if (!c.exists()) {
            return 0;
        }
        FileInputStream fileInputStream = new FileInputStream(c);
        try {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
            if (Integer.parseInt(properties.getProperty("fileStatus", "-1")) == 4) {
                return -1;
            }
            if (properties.getProperty("previousChunk") != null) {
                return Integer.parseInt(properties.getProperty("previousChunk")) + 1;
            }
            throw new C19937bv("Slice checkpoint file corrupt.");
        } catch (Throwable th) {
            C20087cj.m42281a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final boolean mo164221d() {
        FileInputStream fileInputStream;
        File c = this.f55983c.mo164106c(this.f55984d, this.f55985e, this.f55986f, this.f55987g);
        if (!c.exists()) {
            return false;
        }
        try {
            fileInputStream = new FileInputStream(c);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
            if (properties.getProperty("fileStatus") != null) {
                return Integer.parseInt(properties.getProperty("fileStatus")) == 4;
            }
            f55981a.mo164269b("Slice checkpoint file corrupt while checking if extraction finished.", new Object[0]);
            return false;
        } catch (IOException e) {
            f55981a.mo164269b("Could not read checkpoint while checking if extraction finished. %s", e);
            return false;
        } catch (Throwable th) {
            C20087cj.m42281a(th, th);
        }
        throw th;
    }
}
