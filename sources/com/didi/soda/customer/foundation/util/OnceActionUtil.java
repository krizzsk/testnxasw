package com.didi.soda.customer.foundation.util;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import java.util.ArrayList;
import java.util.List;

public final class OnceActionUtil {

    /* renamed from: a */
    private static ActionPool f43851a = new ActionPool();

    private OnceActionUtil() {
    }

    public static void doGlobalOnceAction(OnceAction... onceActionArr) {
        f43851a.doAction(onceActionArr);
    }

    public static void resetGlobalActions() {
        f43851a.mDoneActionList.clear();
    }

    public static abstract class OnceAction implements Runnable {
        protected String mActionName;

        public OnceAction(String str) {
            this.mActionName = str;
        }

        public OnceAction(Object... objArr) {
            StringBuilder sb = new StringBuilder();
            for (Object append : objArr) {
                sb.append(append);
            }
            this.mActionName = sb.toString();
        }
    }

    public static class ActionPool {
        List<String> mDoneActionList = new ArrayList();

        public synchronized void doAction(OnceAction... onceActionArr) {
            if (onceActionArr != null) {
                if (onceActionArr.length > 0) {
                    for (OnceAction onceAction : onceActionArr) {
                        boolean contains = this.mDoneActionList.contains(onceAction.mActionName);
                        LogUtil.m32588i(com.didi.soda.blocks.action.ActionPool.TAG, "ActionName = " + onceAction.mActionName + ", hasDone = " + contains);
                        if (!contains) {
                            onceAction.run();
                            this.mDoneActionList.add(onceAction.mActionName);
                        }
                    }
                }
            }
        }

        public synchronized void reset() {
            this.mDoneActionList.clear();
        }
    }
}
