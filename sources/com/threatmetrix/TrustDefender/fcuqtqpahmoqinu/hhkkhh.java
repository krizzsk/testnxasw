package com.threatmetrix.TrustDefender.fcuqtqpahmoqinu;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import com.threatmetrix.TrustDefender.TMXStrongAuth;
import com.threatmetrix.TrustDefender.fcuqtqpahmoqinu.hkkhhh;
import javax.annotation.Nullable;

public class hhkkhh {
    public static int b006C006Cll006C006C = 56;
    public static int b006Cl006Cl006C006C = 1;
    public static int bl006C006Cl006C006C = 2;
    public static int bll006Cl006C006C = b006C006C006Cl006C006C();
    private static final String bttt00740074t;

    static {
        String bjjjjj006A = hkkhhh.bjjjjj006A(hhkkhh.class);
        int i = b006C006Cll006C006C;
        if (((b006Cl006Cl006C006C + i) * i) % bl006C006Cl006C006C != bll006Cl006C006C) {
        }
        bttt00740074t = bjjjjj006A;
    }

    private hhkkhh() {
    }

    public static TMXStrongAuth.AuthenticationStatus b006A006Ajj006A006A(Context context, String str, String str2, @Nullable TMXStrongAuth.StrongAuthCallback strongAuthCallback) {
        if (strongAuthCallback == null) {
            hkkhhh.kkkhhh.m44484d(bttt00740074t, khhkhk.bqqqqq0071("Busfbjoc\\Yk_db\u0013XRY[c_Q%\nJ][N(EON#ABI|ENyGMCB\u0001sE7EEA<6:2i\u001d\u0015\u001f%\u0018\u0018\u0015\u0011\u000f\u0007\u001e~\u0012\u0010\u0003\u0019\u0007\u0007\u000b\u0015\u0005\u0003\u0006\u0005yqzr", '~', 3));
            return TMXStrongAuth.AuthenticationStatus.TMX_STRONG_AUTH_NOT_POSSIBLE;
        }
        Object systemService = context.getSystemService(khhkhk.bqqqqq0071(">7J7D/?0", 15, 4));
        if (!(systemService instanceof KeyguardManager)) {
            hkkhhh.kkkhhh.m44484d(bttt00740074t, khhkhk.b00710071007100710071q("w--\" *1'\"!5+22d,(15?=1\u0007m8>G3?=9uB=RAP=OB~SFTYMHK\u0013\b[O_a_\\X^X\u0012GAMUJLKIIC\\?TTIaQSYeWW\\]TNYS", '{', ':', 3));
            return TMXStrongAuth.AuthenticationStatus.TMX_STRONG_AUTH_NOT_POSSIBLE;
        }
        Intent createConfirmDeviceCredentialIntent = ((KeyguardManager) systemService).createConfirmDeviceCredentialIntent(str, str2);
        if (createConfirmDeviceCredentialIntent == null) {
            hkkhhh.kkkhhh.m44484d(bttt00740074t, khhkhk.b00710071007100710071q("n$$\u0019\u0017!(\u001e\u0019\u0018,\"))[#\u001f(,64(}d,(15//kA=n3C74H:u\u0018MMB@JQGBAUKRR.T[MW^\u000b^Rbdb_[a[\u0015JDPXMONLLF_BWWLdTV\\hZZ_`WQ\\V", '8', 243, 3));
            return TMXStrongAuth.AuthenticationStatus.TMX_STRONG_AUTH_NOT_POSSIBLE;
        }
        try {
            int callIntent = strongAuthCallback.callIntent(createConfirmDeviceCredentialIntent);
            if (callIntent == -1) {
                return TMXStrongAuth.AuthenticationStatus.TMX_STRONG_AUTH_OK;
            }
            if (callIntent == 0) {
                hkkhhh.kkkhhh.m44484d(bttt00740074t, khhkhk.b00710071007100710071q("9nncakrhcbvlss&mirv\u0001~rH/\u0006\u0005w\u00064xw\u0006{~\u0007\b\u0002\u0002>\u0001\u0016\u0016\u000b\t\u0013\u001a\u0010\u000b\n\u001e\u0014\u001b\u001b", 254, 246, 3));
                return TMXStrongAuth.AuthenticationStatus.TMX_STRONG_AUTH_CANCELLED;
            }
            String str3 = bttt00740074t;
            hkkhhh.kkkhhh.m44484d(str3, khhkhk.b00710071007100710071q("i\u001f\u001f\u0014\u0012\u001c#\u0019\u0014\u0013'\u001d$$V\u001e\u001a#'1/#x_46(4\u001a6f;=+?A@m8Cp", 'V', 'Q', 3) + callIntent);
            return TMXStrongAuth.AuthenticationStatus.TMX_STRONG_AUTH_FAILED;
        } catch (Throwable th) {
            String str4 = bttt00740074t;
            StringBuilder sb = new StringBuilder();
            int i = b006C006Cll006C006C;
            if (((b006Cl006Cl006C006C + i) * i) % bl006C006Cl006C006C != bll006Cl006C006C) {
                b006C006Cll006C006C = 57;
                bll006Cl006C006C = b006C006C006Cl006C006C();
            }
            sb.append(khhkhk.bqqqqq0071("\u001c4*<3'$4$\"\\!3\u001d\u001e(+\u001f$\"R!\u0014\u0013$ \u001f\u0011\u000fI \u0010\f\u0014D\u0007\u0004\u000e\r\t\r\u0005<~{\u0006\u0005`\u0005\ny\u0002\u00071}t\u0003u{o*", 146, 4));
            sb.append(th.toString());
            hkkhhh.m44478e(str4, sb.toString());
            return TMXStrongAuth.AuthenticationStatus.TMX_STRONG_AUTH_FAILED;
        }
    }

    public static int b006C006C006Cl006C006C() {
        return 50;
    }
}
