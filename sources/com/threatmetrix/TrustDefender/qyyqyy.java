package com.threatmetrix.TrustDefender;

import android.content.Context;
import android.os.PowerManager;
import com.threatmetrix.TrustDefender.tqttqq;
import com.threatmetrix.TrustDefender.yyyyqy;
import javax.annotation.Nonnull;

public class qyyqyy {
    private static final String b0066f0066f00660066 = yyyyqy.b0074t007400740074t(qyyqyy.class);

    private qyyqyy() {
    }

    public static boolean bq0071q007100710071(@Nonnull Context context) {
        if (tqttqq.ttqttq.b007600760076v0076v() && tqttqq.ttttqq.qqqqtq.b006E006En006En006E >= tqttqq.ttttqq.tqqqtq.b006Enn006E006E006E) {
            try {
                Object systemService = context.getSystemService("power");
                if (!(systemService instanceof PowerManager)) {
                    return true;
                }
                return ((PowerManager) systemService).isInteractive();
            } catch (SecurityException e) {
                yyyyqy.qyyyqy.b00740074tttt(b0066f0066f00660066, "User refuse granting permission {}", e.toString());
                qqqtqt.byyyy0079y(e);
            } catch (Exception e2) {
                yyyyqy.bt0074007400740074t(b0066f0066f00660066, e2.toString());
            }
        }
        return true;
    }
}
