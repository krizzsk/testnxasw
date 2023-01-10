package com.threatmetrix.TrustDefender.fcuqtqpahmoqinu;

import com.threatmetrix.TrustDefender.qqqqqy;
import java.util.concurrent.atomic.AtomicBoolean;

public final class khkhhh {
    public static int b006C006C006Clll = b006Cll006Cll();
    public static int bl006C006Clll = b006Cll006Cll();
    public static int blll006Cll = 2;
    private static AtomicBoolean bt0074tttt = new AtomicBoolean(false);

    static {
        int i = bl006C006Clll;
        if ((i * (b006C006C006Clll + i)) % blll006Cll != 0) {
        }
    }

    private khkhhh() {
    }

    public static Long b006Ajj006A006Aj(int i) {
        try {
            long bj006A006Ajj006A = hhhkhh.b006Aj006Ajj006A().bj006A006Ajj006A(i);
            int i2 = bl006C006Clll;
            if ((i2 * (b006C006C006Clll + i2)) % blll006Cll != 0) {
                bl006C006Clll = b006Cll006Cll();
                b006C006C006Clll = 58;
            }
            try {
                if (bt0074tttt.get()) {
                    bj006A006Ajj006A |= qqqqqy.b0061a0061aaa;
                }
                return Long.valueOf(bj006A006Ajj006A);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static int b006Cll006Cll() {
        return 16;
    }

    public static void dbAction() {
        try {
            try {
                bt0074tttt.set(true);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
