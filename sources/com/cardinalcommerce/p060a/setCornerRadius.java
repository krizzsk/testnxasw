package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setCornerRadius */
public final class setCornerRadius extends getSDKAppID.Cardinal {

    /* renamed from: a */
    private setBackgroundColor f2749a = new setBackgroundColor(this, (getAcsTransactionID) null, (getAcsTransactionID) null);

    public final boolean CardinalRenderType() {
        return false;
    }

    public final boolean cca_continue(int i) {
        return i == 6;
    }

    public final int configure() {
        return 131;
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        return new setBackgroundColor(this, getacstransactionid, getacstransactionid2, z);
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        return new setBackgroundColor(this, getacstransactionid, getacstransactionid2, getacstransactionidArr, z);
    }

    public final getAcsTransactionID configure(BigInteger bigInteger) {
        return new getTextFontName(bigInteger);
    }

    public final getSDKAppID getInstance() {
        return new setCornerRadius();
    }

    public final ChallengeParameters init() {
        return this.f2749a;
    }

    public setCornerRadius() {
        super(131, 2, 3, 8);
        this.getInstance = new getTextFontName(new BigInteger(1, setTextDirection.getInstance("07A11B09A76B562144418FF3FF8C2570B8")));
        this.Cardinal = new getTextFontName(new BigInteger(1, setTextDirection.getInstance("0217C05610884B63B9C6C7291678F9D341")));
        this.cca_continue = new BigInteger(1, setTextDirection.getInstance("0400000000000000023123953A9464B54D"));
        this.init = BigInteger.valueOf(2);
        this.cleanup = 6;
    }

    public final getMessageVersion Cardinal(ChallengeParameters[] challengeParametersArr, final int i) {
        final long[] jArr = new long[((i * 3) << 1)];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            ChallengeParameters challengeParameters = challengeParametersArr[i3];
            long[] jArr2 = ((getTextFontName) challengeParameters.getWarnings()).cca_continue;
            jArr[i2] = jArr2[0];
            jArr[i2 + 1] = jArr2[1];
            jArr[i2 + 2] = jArr2[2];
            int i4 = i2 + 3;
            long[] jArr3 = ((getTextFontName) challengeParameters.CardinalActionCode()).cca_continue;
            jArr[i4] = jArr3[0];
            jArr[i4 + 1] = jArr3[1];
            jArr[i4 + 2] = jArr3[2];
            i2 = i4 + 3;
        }
        return new getMessageVersion() {
            public final int getInstance() {
                return i;
            }

            public final ChallengeParameters Cardinal(int i) {
                long[] jArr = new long[3];
                long[] jArr2 = new long[3];
                int i2 = 0;
                for (int i3 = 0; i3 < i; i3++) {
                    long j = (long) (((i3 ^ i) - 1) >> 31);
                    for (int i4 = 0; i4 < 3; i4++) {
                        long j2 = jArr[i4];
                        long[] jArr3 = jArr;
                        jArr[i4] = j2 ^ (jArr3[i2 + i4] & j);
                        jArr2[i4] = jArr2[i4] ^ (jArr3[(i2 + 3) + i4] & j);
                    }
                    i2 += 6;
                }
                return new setBackgroundColor(setCornerRadius.this, new getTextFontName(jArr), new getTextFontName(jArr2), false);
            }
        };
    }
}
