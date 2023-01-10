package com.didichuxing.mlcp.drtc.utils;

import java.util.Random;

/* renamed from: com.didichuxing.mlcp.drtc.utils.f */
/* compiled from: RandomString */
public class C16723f {

    /* renamed from: a */
    final Random f51031a = new Random();

    /* renamed from: a */
    public String mo125582a(Integer num) {
        StringBuilder sb = new StringBuilder(num.intValue());
        for (int i = 0; i < num.intValue(); i++) {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(this.f51031a.nextInt(62)));
        }
        return sb.toString();
    }
}
