package com.didi.flutter.nacho2.p116v2;

/* renamed from: com.didi.flutter.nacho2.v2.NachoMainActionHolder */
public class NachoMainActionHolder {

    /* renamed from: a */
    private static NachoAction f23005a;

    private NachoMainActionHolder() {
    }

    public static void setMainAction(NachoAction nachoAction) {
        if (f23005a == null) {
            f23005a = nachoAction;
            return;
        }
        throw new RuntimeException("Nacho MainAction duplicated init.");
    }

    public static NachoAction getMainAction() {
        return f23005a;
    }
}
