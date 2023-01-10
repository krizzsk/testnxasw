package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.util.Base64;
import com.google.android.play.core.internal.C20046aw;
import com.google.android.play.core.internal.C20087cj;
import com.google.android.play.core.splitcompat.C20164p;
import com.google.common.base.Ascii;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipException;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.google.android.play.core.assetpacks.db */
public final class C19971db {

    /* renamed from: a */
    private static C19888a f55926a;

    /* renamed from: a */
    static int m42009a(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << Ascii.CAN) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    /* renamed from: a */
    static AssetLocation m42010a(String str, String str2) throws IOException {
        Long l;
        String str3 = str;
        String str4 = str2;
        C20046aw.m42173a(str3 != null, (Object) "Attempted to get file location from a null apk path.");
        C20046aw.m42173a(str4 != null, (Object) String.format("Attempted to get file location in apk %s with a null file path.", new Object[]{str3}));
        RandomAccessFile randomAccessFile = new RandomAccessFile(str3, "r");
        byte[] bArr = new byte[22];
        randomAccessFile.seek(randomAccessFile.length() - 22);
        randomAccessFile.readFully(bArr);
        C19925bj a = m42009a(bArr, 0) == 1347093766 ? m42012a(bArr) : null;
        byte b = 5;
        if (a == null) {
            long length = randomAccessFile.length() - 22;
            long j = -65536 + length;
            if (j < 0) {
                j = 0;
            }
            int min = (int) Math.min(1024, randomAccessFile.length());
            byte[] bArr2 = new byte[min];
            byte[] bArr3 = new byte[22];
            loop0:
            while (true) {
                long max = Math.max(3 + (length - ((long) min)), j);
                randomAccessFile.seek(max);
                randomAccessFile.readFully(bArr2);
                for (int i = min - 4; i >= 0; i -= 4) {
                    byte b2 = bArr2[i];
                    int i2 = b2 != b ? b2 != 6 ? b2 != 75 ? b2 != 80 ? -1 : 0 : 1 : 3 : 2;
                    if (i2 >= 0 && i >= i2 && m42009a(bArr2, i - i2) == 1347093766) {
                        randomAccessFile.seek((max + ((long) i)) - ((long) i2));
                        randomAccessFile.readFully(bArr3);
                        a = m42012a(bArr3);
                        break loop0;
                    }
                    b = 5;
                }
                if (max != j) {
                    length = max;
                } else {
                    throw new ZipException(String.format("End Of Central Directory signature not found in APK %s", new Object[]{str3}));
                }
            }
        }
        long j2 = a.f55755a;
        byte[] bytes = str4.getBytes("UTF-8");
        byte[] bArr4 = new byte[46];
        byte[] bArr5 = new byte[str2.length()];
        int i3 = 0;
        while (true) {
            if (i3 >= a.f55756b) {
                l = null;
                break;
            }
            randomAccessFile.seek(j2);
            randomAccessFile.readFully(bArr4);
            int a2 = m42009a(bArr4, 0);
            if (a2 == 1347092738) {
                randomAccessFile.seek(j2 + 28);
                int c = m42018c(bArr4, 28);
                if (c == str2.length()) {
                    randomAccessFile.seek(46 + j2);
                    randomAccessFile.read(bArr5);
                    if (Arrays.equals(bArr5, bytes)) {
                        l = Long.valueOf(m42016b(bArr4, 42));
                        break;
                    }
                }
                j2 += (long) (c + 46 + m42018c(bArr4, 30) + m42018c(bArr4, 32));
                i3++;
            } else {
                throw new ZipException(String.format("Missing central directory file header signature when looking for file %s in APK %s. Read %d entries out of %d. Found %d instead of the header signature %d.", new Object[]{str4, str3, Integer.valueOf(i3), Integer.valueOf(a.f55756b), Integer.valueOf(a2), 1347092738}));
            }
        }
        if (l == null) {
            return null;
        }
        long longValue = l.longValue();
        byte[] bArr6 = new byte[8];
        randomAccessFile.seek(22 + longValue);
        randomAccessFile.readFully(bArr6);
        return AssetLocation.m41795a(str3, longValue + 30 + ((long) m42018c(bArr6, 4)) + ((long) m42018c(bArr6, 6)), m42016b(bArr6, 0));
    }

    /* renamed from: a */
    static synchronized C19888a m42011a(Context context) {
        C19888a aVar;
        synchronized (C19971db.class) {
            if (f55926a == null) {
                C19932bq bqVar = new C19932bq((byte[]) null);
                bqVar.mo164149a(new C20004n(C20164p.m42450a(context)));
                f55926a = bqVar.mo164148a();
            }
            aVar = f55926a;
        }
        return aVar;
    }

    /* renamed from: a */
    private static C19925bj m42012a(byte[] bArr) {
        int c = m42018c(bArr, 10);
        m42016b(bArr, 12);
        return new C19925bj(m42016b(bArr, 16), c);
    }

    /* renamed from: a */
    static String m42013a(List<File> list) throws NoSuchAlgorithmException, IOException {
        int read;
        MessageDigest instance = MessageDigest.getInstance("SHA256");
        byte[] bArr = new byte[8192];
        for (File fileInputStream : list) {
            FileInputStream fileInputStream2 = new FileInputStream(fileInputStream);
            do {
                try {
                    read = fileInputStream2.read(bArr);
                    if (read > 0) {
                        instance.update(bArr, 0, read);
                    }
                } catch (Throwable th) {
                    C20087cj.m42281a(th, th);
                }
            } while (read != -1);
            fileInputStream2.close();
        }
        return Base64.encodeToString(instance.digest(), 11);
        throw th;
    }

    /* renamed from: a */
    public static boolean m42014a(int i) {
        return i == 1 || i == 7 || i == 2 || i == 3;
    }

    /* renamed from: a */
    static boolean m42015a(int i, int i2) {
        if (i == 5) {
            if (i2 != 5) {
                return true;
            }
            i = 5;
        }
        if (i == 6 && i2 != 6 && i2 != 5) {
            return true;
        }
        if (i == 4 && i2 != 4) {
            return true;
        }
        if (i == 3 && (i2 == 2 || i2 == 7 || i2 == 1 || i2 == 8)) {
            return true;
        }
        if (i == 2) {
            return i2 == 1 || i2 == 8;
        }
        return false;
    }

    /* renamed from: b */
    static long m42016b(byte[] bArr, int i) {
        return ((long) ((m42018c(bArr, i + 2) << 16) | m42018c(bArr, i))) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
    }

    /* renamed from: b */
    public static boolean m42017b(int i) {
        return i == 5 || i == 6 || i == 4;
    }

    /* renamed from: c */
    static int m42018c(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    /* renamed from: c */
    public static boolean m42019c(int i) {
        return i == 2 || i == 7 || i == 3;
    }
}
