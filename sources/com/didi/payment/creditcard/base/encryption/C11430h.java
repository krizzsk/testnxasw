package com.didi.payment.creditcard.base.encryption;

import java.util.Random;

/* renamed from: com.didi.payment.creditcard.base.encryption.h */
/* compiled from: RandomUtil */
class C11430h {

    /* renamed from: a */
    public static Random f32759a = new Random();

    C11430h() {
    }

    /* renamed from: a */
    public static String m24871a(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            if (f32759a.nextInt(2) % 2 == 0) {
                sb.append((char) ((f32759a.nextInt(2) % 2 == 0 ? 65 : 97) + f32759a.nextInt(26)));
            } else {
                sb.append(Integer.toString(f32759a.nextInt(10)));
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static String m24872b(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(Integer.toString(f32759a.nextInt(10)));
        }
        return sb.toString();
    }
}
