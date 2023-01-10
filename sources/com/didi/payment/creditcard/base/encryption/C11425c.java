package com.didi.payment.creditcard.base.encryption;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/* renamed from: com.didi.payment.creditcard.base.encryption.c */
/* compiled from: CheckUtils */
class C11425c {

    /* renamed from: a */
    public static final String f32752a = "flowID,initiator,";

    C11425c() {
    }

    /* renamed from: a */
    public static void m24820a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str + " must be specified");
        } else if ((obj instanceof String) && obj.toString().trim().length() == 0) {
            throw new IllegalArgumentException(str + " must be specified");
        } else if (obj.getClass().isArray() && Array.getLength(obj) == 0) {
            throw new IllegalArgumentException(str + " must be specified");
        } else if ((obj instanceof Collection) && ((Collection) obj).isEmpty()) {
            throw new IllegalArgumentException(str + " must be specified");
        } else if ((obj instanceof Map) && ((Map) obj).isEmpty()) {
            throw new IllegalArgumentException(str + " must be specified");
        }
    }
}
