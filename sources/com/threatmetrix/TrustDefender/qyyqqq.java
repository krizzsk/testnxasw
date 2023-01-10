package com.threatmetrix.TrustDefender;

import android.security.KeyChain;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyInfo;
import com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk;
import com.threatmetrix.TrustDefender.tqttqq;
import com.threatmetrix.TrustDefender.yyyyqy;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import kotlin.text.Typography;
import org.apache.commons.p074io.IOUtils;

public class qyyqqq {
    public static int b006200620062bb0062b = 1;
    public static int b0062b0062bb0062b = 25;
    private static final String b006D006D006D006Dmm;
    public static int bb00620062bb0062b = 0;
    public static int bbbb0062b0062b = 2;

    static {
        Class<qyyqqq> cls = qyyqqq.class;
        int i = b0062b0062bb0062b;
        int i2 = b006200620062bb0062b;
        int i3 = bbbb0062b0062b;
        if (((i + i2) * i) % i3 != bb00620062bb0062b) {
            if (((i2 + i) * i) % i3 != b00620062b0062b0062b()) {
                b0062b0062bb0062b = b0062bb0062b0062b();
                bb00620062bb0062b = b0062bb0062b0062b();
            }
            b0062b0062bb0062b = 4;
            bb00620062bb0062b = 76;
        }
        b006D006D006D006Dmm = yyyyqy.b0074t007400740074t(cls);
    }

    private qyyqqq() {
    }

    public static int b00620062b0062b0062b() {
        return 0;
    }

    public static int b0062bb0062b0062b() {
        return 37;
    }

    public static KeyPair b006800680068hhh(@Nonnull String str, String str2, @Nonnull String str3) {
        try {
            if (!tqttqq.qqtqtq.bu00750075u00750075()) {
                yyyyqy.qyyyqy.bt0074tttt(b006D006D006D006Dmm, jkkjkk.b0062bbbbbb("Pmy1}(nksiucue\u001fibun&\u0019j\\gj]eWU\u0010RZN_^O\\\bHXJ\u0004QQU@T>EG;;D<\u0004", '-', 196, 2));
                return null;
            } else if (!KeyChain.isKeyAlgorithmSupported(str)) {
                return null;
            } else {
                try {
                    KeyPairGenerator instance = KeyPairGenerator.getInstance(str, str2);
                    int i = b0062b0062bb0062b;
                    if (((b006200620062bb0062b + i) * i) % bbbb0062b0062b != bb00620062bb0062b) {
                        b0062b0062bb0062b = b0062bb0062b0062b();
                        bb00620062bb0062b = b0062bb0062b0062b();
                    }
                    KeyGenParameterSpec.Builder digests = new KeyGenParameterSpec.Builder(str3, 5).setDigests(new String[]{jkkjkk.b0062bbbbbb("/%\u001f\f\u0012\u0016\u0018", 150, 195, 3)});
                    if (jkkjkk.bb0062bbbbb("xxe", 199, 3).equals(str)) {
                        String[] strArr = new String[1];
                        int i2 = b0062b0062bb0062b;
                        if ((i2 * (b006200620062bb0062b + i2)) % bbbb0062b0062b != 0) {
                            b0062b0062bb0062b = b0062bb0062b0062b();
                            bb00620062bb0062b = b0062bb0062b0062b();
                        }
                        strArr[0] = jkkjkk.b0062bbbbbb("\n\u0004z\nf", '$', Typography.quote, 2);
                        digests = digests.setSignaturePaddings(strArr);
                    }
                    instance.initialize(digests.build());
                    return instance.generateKeyPair();
                } catch (InvalidAlgorithmParameterException e) {
                    e = e;
                    String str4 = b006D006D006D006Dmm;
                    String b0062bbbbbb = jkkjkk.b0062bbbbbb("\u001e;G~Ku8F83E5n\u00192E\u001b+2:fAB", 218, 181, 1);
                    yyyyqy.bttttt0074(str4, b0062bbbbbb, e.toString());
                    return null;
                } catch (NoSuchProviderException e2) {
                    e = e2;
                    String str42 = b006D006D006D006Dmm;
                    String b0062bbbbbb2 = jkkjkk.b0062bbbbbb("\u001e;G~Ku8F83E5n\u00192E\u001b+2:fAB", 218, 181, 1);
                    yyyyqy.bttttt0074(str42, b0062bbbbbb2, e.toString());
                    return null;
                } catch (NoSuchAlgorithmException e3) {
                    yyyyqy.qyyyqy.btt00740074tt(b006D006D006D006Dmm, jkkjkk.bb0062bbbbb("\u001d:F}Jt7E72D4m\u00181D\u001a*19e@A", 146, 1), e3.toString());
                    return null;
                } catch (Throwable th) {
                    try {
                        yyyyqy.btt007400740074t(b006D006D006D006Dmm, jkkjkk.bb0062bbbbb("\u00141=tAk.<.);+d\u000f(;\u0011!(0\\c-/', #\u001aS\u0018*\u0014\u0015\u001f\"\u0016\u001b\u0019RH#$", ':', 3), th.toString());
                        return null;
                    } catch (Exception e4) {
                        throw e4;
                    }
                }
            }
        } catch (Exception e5) {
            throw e5;
        }
    }

    public static boolean b0068hh0068hh(@Nullable PrivateKey privateKey, String str) {
        try {
            KeyInfo bhhh0068hh = bhhh0068hh(privateKey, str);
            if (bhhh0068hh == null) {
                yyyyqy.qyyyqy.bt0074tttt(b006D006D006D006Dmm, jkkjkk.bb0062bbbbb("]z\u0007>\u000b5w{wt{/yr\u0006+y{qnos0#tfqtgoa_\u001a\\dXihYf\u0012RbT\u000e[[_\nJ^HOQEENF\u000e", 'e', 2));
                int b0062bb0062b0062b = b0062bb0062b0062b();
                if ((b0062bb0062b0062b * (b006200620062bb0062b + b0062bb0062b0062b)) % bbbb0062b0062b != 0) {
                    b0062b0062bb0062b = b0062bb0062b0062b();
                    bb00620062bb0062b = b0062bb0062b0062b();
                }
                return true;
            }
            int origin = bhhh0068hh.getOrigin();
            int i = b0062b0062bb0062b;
            if ((i * (b006200620062bb0062b + i)) % bb0062b0062b0062b() != 0) {
                try {
                    b0062b0062bb0062b = b0062bb0062b0062b();
                    bb00620062bb0062b = 32;
                } catch (Exception e) {
                    throw e;
                }
            }
            return origin == 1;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static int bb0062b0062b0062b() {
        return 2;
    }

    public static boolean bh0068h0068hh(@Nullable PrivateKey privateKey, String str) {
        try {
            KeyInfo bhhh0068hh = bhhh0068hh(privateKey, str);
            if (bhhh0068hh == null) {
                yyyyqy.qyyyqy.bt0074tttt(b006D006D006D006Dmm, jkkjkk.b0062bbbbbb("\u0001 .g6b'-+*3h50ElBH@6}rF:GLAK??{@J@STGV\u0004FXL\bWY_\fNdPY]SU`Z$", 220, 159, 0));
                return false;
            }
            int i = b0062b0062bb0062b;
            int i2 = i * (b006200620062bb0062b + i);
            int i3 = b0062b0062bb0062b;
            if ((i3 * (b006200620062bb0062b + i3)) % bb0062b0062b0062b() != 0) {
                b0062b0062bb0062b = b0062bb0062b0062b();
                bb00620062bb0062b = 28;
            }
            try {
                if (i2 % bbbb0062b0062b != 0) {
                    b0062b0062bb0062b = 50;
                    bb00620062bb0062b = 56;
                }
                boolean isInsideSecureHardware = bhhh0068hh.isInsideSecureHardware();
                String str2 = b006D006D006D006Dmm;
                yyyyqy.qyyyqy.bt0074tttt(str2, jkkjkk.bb0062bbbbb("\u001c4D5G0@2k-+,3,*d", 184, 3) + isInsideSecureHardware);
                return isInsideSecureHardware;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static KeyInfo bhhh0068hh(@Nullable PrivateKey privateKey, String str) {
        if (tqttqq.qqtqtq.bu00750075u00750075() && tqttqq.ttttqq.qqqqtq.b006E006En006En006E >= 23 && privateKey != null) {
            try {
                return (KeyInfo) KeyFactory.getInstance(privateKey.getAlgorithm(), str).getKeySpec(privateKey, KeyInfo.class);
            } catch (NoSuchAlgorithmException e) {
                yyyyqy.qyyyqy.btt00740074tt(b006D006D006D006Dmm, jkkjkk.b0062bbbbbb("Dam%q\u001cgiZ\\\u0017j]Y\u0013=ViBb\\^P\nde", 131, 132, 1), e.toString());
            } catch (NoSuchProviderException | InvalidKeySpecException e2) {
                String str2 = b006D006D006D006Dmm;
                String b0062bbbbbb = jkkjkk.b0062bbbbbb("w\u0017%^-Y\u001e.\"\u001f3%`\r(=\u0015'0:hEH", 164, 239, 0);
                String[] strArr = new String[1];
                int i = b0062b0062bb0062b;
                if (((b006200620062bb0062b + i) * i) % bbbb0062b0062b != b00620062b0062b0062b()) {
                    b0062b0062bb0062b = 54;
                    bb00620062bb0062b = 37;
                }
                int i2 = b0062b0062bb0062b;
                if (((b006200620062bb0062b + i2) * i2) % bbbb0062b0062b != bb00620062bb0062b) {
                    b0062b0062bb0062b = 43;
                    bb00620062bb0062b = b0062bb0062b0062b();
                }
                strArr[0] = e2.toString();
                yyyyqy.bttttt0074(str2, b0062bbbbbb, strArr);
            } catch (Throwable th) {
                yyyyqy.btt007400740074t(b006D006D006D006Dmm, jkkjkk.b0062bbbbbb("m\r\u001bT#O\u0014$\u0018\u0015)\u001bV\u0003\u001e3\u000b\u001d&0^g3718.3,g.B.1=B8??zrOR", IOUtils.DIR_SEPARATOR_WINDOWS, 204, 3), th.toString());
            }
        }
        return null;
    }
}
