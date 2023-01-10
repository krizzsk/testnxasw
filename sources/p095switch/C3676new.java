package p095switch;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: switch.new */
/* compiled from: CryptoUtils */
public class C3676new {
    /* renamed from: do */
    public static byte[] m7426do(byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        instance.reset();
        return instance.digest(bArr);
    }
}
