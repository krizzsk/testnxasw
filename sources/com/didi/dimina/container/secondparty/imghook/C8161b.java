package com.didi.dimina.container.secondparty.imghook;

import java.util.Locale;

/* renamed from: com.didi.dimina.container.secondparty.imghook.b */
/* compiled from: ImageCheck */
class C8161b {
    C8161b() {
    }

    /* renamed from: a */
    static boolean m16201a(String str) {
        String lowerCase = str.toLowerCase(Locale.US);
        return !lowerCase.contains("text/") && !lowerCase.contains("application/") && !lowerCase.contains("audio/") && !lowerCase.contains("video/") && lowerCase.contains("image/");
    }
}
