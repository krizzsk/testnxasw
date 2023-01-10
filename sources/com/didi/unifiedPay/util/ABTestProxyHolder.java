package com.didi.unifiedPay.util;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public class ABTestProxyHolder {

    /* renamed from: a */
    private static INewUISwitchProxy f47254a;

    /* renamed from: b */
    private static IPayMethodGroupSwitchProxy f47255b;

    /* renamed from: c */
    private static OptimizedUISwitch f47256c;

    public interface INewUISwitchProxy {
        boolean isNewTrip();
    }

    public interface IPayMethodGroupSwitchProxy {
        boolean isAllowPayMethodGroup();
    }

    public static INewUISwitchProxy getNewUISwitch() {
        return f47254a;
    }

    public static void setNewUISwitch(INewUISwitchProxy iNewUISwitchProxy) {
        f47254a = iNewUISwitchProxy;
    }

    public static IPayMethodGroupSwitchProxy getPayMethodGroupSwitch() {
        if (f47255b == null) {
            f47255b = new IPayMethodGroupSwitchProxy() {
                public boolean isAllowPayMethodGroup() {
                    return ABTestProxyHolder.getStatus("ibt_cashier_new_pay_method_list_toggle", false);
                }
            };
        }
        return f47255b;
    }

    public static void setPayMethodGroupSwitch(IPayMethodGroupSwitchProxy iPayMethodGroupSwitchProxy) {
        f47255b = iPayMethodGroupSwitchProxy;
    }

    public static synchronized OptimizedUISwitch getOptimizedUISwitch() {
        OptimizedUISwitch optimizedUISwitch;
        synchronized (ABTestProxyHolder.class) {
            if (f47256c == null) {
                f47256c = new OptimizedUISwitch();
            }
            optimizedUISwitch = f47256c;
        }
        return optimizedUISwitch;
    }

    public static class OptimizedUISwitch {
        private boolean optimize = false;

        public void setOptimize(boolean z) {
            this.optimize = z;
        }

        public boolean optimized() {
            return this.optimize;
        }
    }

    public static boolean getStatus(String str, boolean z) {
        try {
            IToggle toggle = Apollo.getToggle(str, z);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return z;
    }
}
