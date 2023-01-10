package com.didichuxing.mlcp.drtc.utils;

import com.didichuxing.mlcp.drtc.interfaces.C16686a;
import com.didichuxing.mlcp.drtc.interfaces.C16687b;

/* renamed from: com.didichuxing.mlcp.drtc.utils.c */
/* compiled from: DrtcMessengerFactory */
public class C16717c {
    /* renamed from: a */
    public static C16687b m38164a(String str, C16686a aVar) {
        if (str.indexOf("ws") == 0) {
            return new C16725h(str, aVar);
        }
        return new C16720e(str, aVar);
    }
}
