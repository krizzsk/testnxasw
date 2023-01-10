package com.threatmetrix.TrustDefender;

import android.util.Base64;
import com.threatmetrix.TrustDefender.yyyyqy;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.UUID;
import java.util.zip.CRC32;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class yqqqqy {
    private static final int b0065ee00650065e = 16;
    private static final int be0065e00650065e = 16;
    private static final String beee00650065e = yyyyqy.b0074t007400740074t(yqqqqy.class);

    private yqqqqy() {
    }

    @Nullable
    public static String b007800780078x0078x(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        if (!yqqyqq.bi0069i0069i0069(str) && !yqqyqq.bi0069i0069i0069(str2) && !yqqyqq.bi0069i0069i0069(str3)) {
            try {
                byte[] bii0069i00690069 = yqqyqq.bii0069i00690069((str3 + str2).getBytes(StandardCharsets.UTF_8));
                if (bii0069i00690069 == null) {
                    return null;
                }
                byte[] bytes = str3.getBytes(StandardCharsets.UTF_8);
                byte[] b00780078xx0078x = b00780078xx0078x(str.getBytes(StandardCharsets.UTF_8), Arrays.copyOfRange(bii0069i00690069, 0, 16), Arrays.copyOfRange(bii0069i00690069, 16, bii0069i00690069.length));
                if (b00780078xx0078x == null) {
                    yyyyqy.qyyyqy.bt00740074ttt(beee00650065e, "Failure: failed to encrypt the payload");
                    return null;
                }
                byte[] encode = Base64.encode(bx0078x00780078x(b00780078xx0078x, bytes), 2);
                if (encode != null) {
                    return new String(encode, StandardCharsets.UTF_8);
                }
                yyyyqy.qyyyqy.bt00740074ttt(beee00650065e, "Failure: Base64 failed");
                return null;
            } catch (IllegalArgumentException e) {
                yyyyqy.qyyyqy.b0074tt0074tt(beee00650065e, "Obfuscation Error", e);
            }
        }
        return null;
    }

    @Nullable
    public static byte[] b00780078xx0078x(@Nullable byte[] bArr, @Nullable byte[] bArr2, @Nullable byte[] bArr3) {
        if (!(bArr == null || bArr2 == null || bArr3 == null)) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                instance.init(1, secretKeySpec, new IvParameterSpec(bArr3));
                return instance.doFinal(bArr);
            } catch (IllegalArgumentException | InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
                yyyyqy.qyyyqy.b0074tt0074tt(beee00650065e, "Obfuscation Error", e);
            }
        }
        return null;
    }

    @Nullable
    public static String b0078x0078x0078x(@Nullable byte[] bArr, @Nullable String str, @Nullable String str2) {
        if (bArr != null && !yqqyqq.bi0069i0069i0069(str) && !yqqyqq.bi0069i0069i0069(str2)) {
            try {
                byte[] decode = Base64.decode(bArr, 0);
                if (decode != null) {
                    if (decode.length >= 32) {
                        ByteBuffer allocate = ByteBuffer.allocate(decode.length - 16);
                        ByteBuffer allocate2 = ByteBuffer.allocate(16);
                        if (bxx0078x0078x(decode, 16, allocate, allocate2) && allocate.hasArray()) {
                            if (allocate2.hasArray()) {
                                byte[] b0078xxx0078x = b0078xxx0078x(allocate.array(), bxxx00780078x(allocate2.array(), str, str2));
                                if (b0078xxx0078x == null) {
                                    yyyyqy.qyyyqy.bt00740074ttt(beee00650065e, "failed to decrypt the conf response");
                                    return null;
                                }
                                String str3 = new String(b0078xxx0078x, StandardCharsets.UTF_8);
                                String str4 = beee00650065e;
                                yyyyqy.qyyyqy.bt0074tttt(str4, "conf response " + str3);
                                return str3;
                            }
                        }
                        yyyyqy.qyyyqy.bt00740074ttt(beee00650065e, "Failure: failed to deinterlace nonce from input");
                    }
                }
                return null;
            } catch (IOException | IllegalArgumentException e) {
                yyyyqy.qyyyqy.b0074tt0074tt(beee00650065e, "Deobfuscate Error", e);
            }
        }
        return null;
    }

    public static int b0078xx00780078x(@Nullable byte[] bArr, @Nullable byte[] bArr2) throws IllegalArgumentException, IOException {
        if (bArr == null || bArr2 == null) {
            throw new IllegalArgumentException("Illegal argument for CRC32 key");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(bArr);
        byteArrayOutputStream.write(bArr2);
        CRC32 crc32 = new CRC32();
        crc32.update(byteArrayOutputStream.toByteArray());
        return (int) crc32.getValue();
    }

    @Nullable
    public static byte[] b0078xxx0078x(@Nullable byte[] bArr, @Nullable byte[] bArr2) {
        return bx0078xx0078x(bArr, bArr2, new byte[16]);
    }

    @Nullable
    public static String bx00780078x0078x(@Nullable String str, @Nullable String str2) {
        return b007800780078x0078x(str, str2, UUID.randomUUID().toString());
    }

    public static byte[] bx0078x00780078x(@Nonnull byte[] bArr, @Nonnull byte[] bArr2) {
        int length = bArr.length;
        int length2 = bArr2.length;
        boolean z = length >= length2;
        int i = z ? length2 * 2 : length * 2;
        int i2 = z ? length : length2;
        ByteBuffer allocate = ByteBuffer.allocate(length + length2);
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4 += 2) {
            allocate.put(bArr[i3]);
            allocate.put(bArr2[i3]);
            i3++;
        }
        while (i3 < i2) {
            allocate.put(z ? bArr[i3] : bArr2[i3]);
            i3++;
        }
        return allocate.array();
    }

    @Nullable
    public static byte[] bx0078xx0078x(@Nullable byte[] bArr, @Nullable byte[] bArr2, @Nullable byte[] bArr3) {
        if (!(bArr == null || bArr2 == null || bArr3 == null)) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                instance.init(2, secretKeySpec, new IvParameterSpec(bArr3));
                return instance.doFinal(bArr);
            } catch (IllegalArgumentException | InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
                yyyyqy.b00740074t00740074t(beee00650065e, "decrypt error: ", e);
            }
        }
        return null;
    }

    public static boolean bxx0078x0078x(@Nonnull byte[] bArr, int i, @Nonnull ByteBuffer byteBuffer, @Nonnull ByteBuffer byteBuffer2) {
        boolean z;
        int i2 = 0;
        if (bArr == null || bArr.length < i) {
            return false;
        }
        int i3 = i * 2;
        if (bArr.length < i3) {
            i3 = (bArr.length - i) * 2;
            z = true;
        } else {
            z = false;
        }
        while (i2 < i3) {
            byteBuffer.put(bArr[i2]);
            byteBuffer2.put(bArr[i2 + 1]);
            i2 += 2;
        }
        while (i2 < bArr.length) {
            if (z) {
                byteBuffer2.put(bArr[i2]);
            } else {
                byteBuffer.put(bArr[i2]);
            }
            i2++;
        }
        return true;
    }

    public static byte[] bxxx00780078x(byte[] bArr, String str, String str2) throws IllegalArgumentException, IOException {
        ByteBuffer allocate = ByteBuffer.allocate(16);
        allocate.putInt(b0078xx00780078x(bArr, str2.getBytes(StandardCharsets.UTF_8)));
        allocate.putInt(b0078xx00780078x(bArr, str.getBytes(StandardCharsets.UTF_8)));
        allocate.putInt(b0078xx00780078x(str2.getBytes(StandardCharsets.UTF_8), bArr));
        allocate.putInt(b0078xx00780078x(str.getBytes(StandardCharsets.UTF_8), bArr));
        return allocate.array();
    }
}
