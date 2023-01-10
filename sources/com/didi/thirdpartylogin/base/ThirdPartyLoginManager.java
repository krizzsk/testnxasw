package com.didi.thirdpartylogin.base;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class ThirdPartyLoginManager {

    /* renamed from: a */
    private static List<AbsThirdPartyLoginBase> f46525a;

    /* renamed from: b */
    private static ThirdPartyLoginLogListener f46526b;

    public static void log(String str) {
        if (f46526b != null && !TextUtils.isEmpty(str)) {
            f46526b.addLogWithTab(str);
        }
    }

    public static void setLogListener(ThirdPartyLoginLogListener thirdPartyLoginLogListener) {
        if (thirdPartyLoginLogListener != null) {
            f46526b = thirdPartyLoginLogListener;
        }
    }

    public static List<AbsThirdPartyLoginBase> getThirdPartyLogins() {
        return f46525a;
    }

    public static void addThirdPartyLogin(AbsThirdPartyLoginBase absThirdPartyLoginBase) {
        if (absThirdPartyLoginBase != null) {
            if (f46525a == null) {
                f46525a = new ArrayList();
            }
            f46525a.add(absThirdPartyLoginBase);
        }
    }

    public static void removeThirdPartyLogin(AbsThirdPartyLoginBase absThirdPartyLoginBase) {
        List<AbsThirdPartyLoginBase> list = f46525a;
        if (list != null) {
            list.remove(absThirdPartyLoginBase);
        }
    }

    public static void filterUnsupported() {
        List<AbsThirdPartyLoginBase> list = f46525a;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (AbsThirdPartyLoginBase next : getThirdPartyLogins()) {
                if (next.isSupport()) {
                    arrayList.add(next);
                }
            }
            f46525a = arrayList;
        }
    }

    public static AbsThirdPartyLoginBase getImpByChannel(String str) {
        List<AbsThirdPartyLoginBase> list;
        if (!TextUtils.isEmpty(str) && (list = f46525a) != null) {
            for (AbsThirdPartyLoginBase next : list) {
                if (str.equals(next.getChannel()) && next.isSupport()) {
                    return next;
                }
            }
        }
        return null;
    }

    public static boolean isSupportThirdLogin() {
        List<AbsThirdPartyLoginBase> list = f46525a;
        if (list == null) {
            return false;
        }
        for (AbsThirdPartyLoginBase isSupport : list) {
            if (isSupport.isSupport()) {
                return true;
            }
        }
        return false;
    }
}
