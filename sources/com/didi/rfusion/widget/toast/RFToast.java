package com.didi.rfusion.widget.toast;

import com.didi.rfusion.utils.RFResUtils;

public class RFToast {

    /* renamed from: a */
    private static int f36761a;

    public static void setDefaultType(int i) {
        f36761a = i;
    }

    public static int getDefaultType() {
        return f36761a;
    }

    public static void show(String str) {
        show(str, f36761a);
    }

    public static void show(String str, int i) {
        RFToastController.m27731a().mo95015a(str, i, false);
    }

    public static void show(int i) {
        show(i, f36761a);
    }

    public static void show(int i, int i2) {
        show(RFResUtils.getString(i), i2);
    }

    public static void showAllowInBg(String str) {
        showAllowInBg(str, f36761a);
    }

    public static void showAllowInBg(String str, int i) {
        RFToastController.m27731a().mo95015a(str, i, true);
    }

    public static void showAllowInBg(int i) {
        showAllowInBg(i, f36761a);
    }

    public static void showAllowInBg(int i, int i2) {
        showAllowInBg(RFResUtils.getString(i), i2);
    }
}
