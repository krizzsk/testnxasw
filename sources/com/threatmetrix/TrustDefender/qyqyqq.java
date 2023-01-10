package com.threatmetrix.TrustDefender;

import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import com.threatmetrix.TrustDefender.tqttqq;
import javax.annotation.Nonnull;

public class qyqyqq {
    private static final String bbbb0062b0062 = yyyyqy.b0074t007400740074t(qyqyqq.class);

    private qyqyqq() {
    }

    public static void b0069ii00690069i(@Nonnull tqtqqt tqtqqt, @Nonnull String str, @Nonnull kjjjjj kjjjjj) throws InterruptedException {
        if (!tqttqq.tqtttq.bv0076vvv0076() || tqtqqt == null) {
            yyyyqy.b007400740074tt0074(bbbb0062b0062, "Invalid state, failed to access pref");
            return;
        }
        SharedPreferences.Editor b00760076v00760076v = tqttqq.tqtttq.b00760076v00760076v(SystemUtils.getSharedPreferences(tqtqqt.bll006C006C006C006C, str, 0));
        if (b00760076v00760076v != null) {
            tqttqq.tqtttq.b0076v0076vv0076(kjjjjj.b006D006Dm006D006D006D, kjjjjj.b0068hh00680068h(), b00760076v00760076v);
            tqttqq.tqtttq.b0076v0076vv0076(kjjjjj.bmm006D006D006D006D, kjjjjj.bhhh00680068h(), b00760076v00760076v);
            tqttqq.tqtttq.bv00760076vv0076("sdkVersion", "6.3-80", b00760076v00760076v);
            tqttqq.tqtttq.bvv0076vv0076(kjjjjj.b006Dm006D006D006D006D, kjjjjj.bh0068h00680068h(), b00760076v00760076v);
            b00760076v00760076v.apply();
        }
    }

    public static kjjjjj biii00690069i(@Nonnull tqtqqt tqtqqt, @Nonnull String str) {
        if (!tqttqq.tqtttq.bv0076vvv0076() || tqtqqt == null) {
            yyyyqy.b007400740074tt0074(bbbb0062b0062, "Invalid state, failed to access pref");
            return null;
        }
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(tqtqqt.bll006C006C006C006C, str, 0);
        try {
            kjjjjj kjjjjj = new kjjjjj();
            kjjjjj.b0068h006800680068h(tqttqq.tqtttq.bv0076007600760076v(sharedPreferences, kjjjjj.b006D006Dm006D006D006D, 0));
            kjjjjj.bhh006800680068h(tqttqq.tqtttq.bv0076007600760076v(sharedPreferences, kjjjjj.bmm006D006D006D006D, 0));
            kjjjjj.b00680068006800680068h(tqttqq.tqtttq.bvvvvv0076(sharedPreferences, "sdkVersion", ""));
            kjjjjj.bh0068006800680068h(tqttqq.tqtttq.bvv007600760076v(sharedPreferences, kjjjjj.b006Dm006D006D006D006D, 0));
            return kjjjjj;
        } catch (ClassCastException e) {
            yyyyqy.b00740074007400740074t(bbbb0062b0062, "Found preference of different type", e);
            return null;
        }
    }
}
