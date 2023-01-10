package com.didi.onehybrid.util;

import com.google.common.base.Ascii;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class MD5Util {
    public static final String md5(String str) {
        try {
            byte[] bytes = str.getBytes();
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(bytes);
            return byteArrayToHex(instance.digest());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String fileMD5(File file) throws IOException {
        DigestInputStream digestInputStream;
        FileInputStream fileInputStream;
        Throwable th;
        String str = null;
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            fileInputStream = new FileInputStream(file);
            try {
                digestInputStream = new DigestInputStream(fileInputStream, instance);
                try {
                    byte[] bArr = new byte[1024];
                    for (int read = digestInputStream.read(bArr); read > 0; read = digestInputStream.read(bArr)) {
                    }
                    str = byteArrayToHex(digestInputStream.getMessageDigest().digest());
                } catch (NoSuchAlgorithmException unused) {
                } catch (Throwable th2) {
                    th = th2;
                    FileUtil.closeQuietly(digestInputStream);
                    FileUtil.closeQuietly(fileInputStream);
                    throw th;
                }
            } catch (NoSuchAlgorithmException unused2) {
                digestInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                digestInputStream = null;
                FileUtil.closeQuietly(digestInputStream);
                FileUtil.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (NoSuchAlgorithmException unused3) {
            digestInputStream = null;
            fileInputStream = null;
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
            digestInputStream = null;
            FileUtil.closeQuietly(digestInputStream);
            FileUtil.closeQuietly(fileInputStream);
            throw th;
        }
        FileUtil.closeQuietly(digestInputStream);
        FileUtil.closeQuietly(fileInputStream);
        return str;
    }

    public static String byteArrayToHex(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b >>> 4) & 15];
            i = i2 + 1;
            cArr2[i2] = cArr[b & Ascii.f55148SI];
        }
        return new String(cArr2);
    }
}
