package com.threatmetrix.TrustDefender;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import com.threatmetrix.TrustDefender.tqttqq;
import com.threatmetrix.TrustDefender.yyyyqy;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class qyqyyq {
    private static final String b00610061a0061a0061 = "TMCNG_";
    public static final String b0061a00610061a0061 = "trsp";
    private static final String ba0061a0061a0061 = yyyyqy.b0074t007400740074t(qyqyyq.class);
    private static final String baa00610061a0061 = "TMJRS_";

    public static String b00780078x007800780078(@Nonnull String str) {
        return baa00610061a0061 + str;
    }

    public static String bx0078x007800780078(@Nonnull String str) {
        return b00610061a0061a0061 + str;
    }

    private static boolean bxx0078007800780078() {
        return !tqttqq.tqtttq.bv0076vvv0076() || !tqttqq.tqtttq.b00760076vvv0076();
    }

    @Nonnull
    public String b0069iiiii(@Nonnull Context context, @Nonnull String str, @Nullable List<String> list) {
        if (context == null || yqqyqq.bi0069i0069i0069(str) || bxx0078007800780078()) {
            yyyyqy.qyyyqy.bt0074tttt(ba0061a0061a0061, "Invalid SharedPreferences state");
            return "";
        }
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context, b0061a00610061a0061, 0);
        bx00780078007800780078(sharedPreferences, str, list);
        String b0078x0078007800780078 = b0078x0078007800780078(sharedPreferences, str);
        return b0078x0078007800780078 == null ? "" : b0078x0078007800780078;
    }

    @Nullable
    public String b0078x0078007800780078(@Nonnull SharedPreferences sharedPreferences, @Nonnull String str) {
        SharedPreferences.Editor b00760076v00760076v;
        String b00780078x007800780078 = b00780078x007800780078(str);
        String bvvvvv0076 = tqttqq.tqtttq.bvvvvv0076(sharedPreferences, b00780078x007800780078, (String) null);
        if (bvvvvv0076 == null || (b00760076v00760076v = tqttqq.tqtttq.b00760076v00760076v(sharedPreferences)) == null) {
            return null;
        }
        tqttqq.tqtttq.bv00760076vv0076(b00780078x007800780078, (String) null, b00760076v00760076v);
        b00760076v00760076v.apply();
        return bvvvvv0076;
    }

    public boolean bx00780078007800780078(@Nonnull SharedPreferences sharedPreferences, @Nonnull String str, @Nullable List<String> list) {
        String str2;
        String str3;
        if (list == null || list.isEmpty()) {
            str2 = ba0061a0061a0061;
            str3 = "Invalid input";
        } else {
            String bx00780078x0078x = yqqqqy.bx00780078x0078x(yqqyqq.bii00690069i0069(list, ";", true), str);
            if (yqqyqq.bi0069i0069i0069(bx00780078x0078x)) {
                str2 = ba0061a0061a0061;
                str3 = "Failed to encode paths";
            } else {
                SharedPreferences.Editor b00760076v00760076v = tqttqq.tqtttq.b00760076v00760076v(sharedPreferences);
                if (b00760076v00760076v == null) {
                    return false;
                }
                tqttqq.tqtttq.bv00760076vv0076(bx0078x007800780078(str), bx00780078x0078x, b00760076v00760076v);
                return b00760076v00760076v.commit();
            }
        }
        yyyyqy.qyyyqy.bt00740074ttt(str2, str3);
        return false;
    }
}
