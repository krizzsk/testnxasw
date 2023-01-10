package com.didichuxing.omega.sdk.common.utils;

import android.view.View;

public class PrismUtil {
    private static final String PRISM_TOOL_DATA = "com.xiaojuchefu.prism.tool.data.";
    private static int isHavePrismTool;

    public static void invoke(String str, String str2, Object... objArr) {
        invoke("com.xiaojuchefu.prism.tool.security.", str, str2, objArr);
    }

    public static void bindCkEvent(View view, String str) {
        invoke(PRISM_TOOL_DATA, "DataBinder", "bindCkEvent", view, str);
    }

    public static void bindEpEvent(View view, String str) {
        invoke(PRISM_TOOL_DATA, "DataBinder", "bindEpEvent", view, str);
    }

    public static void bindCkEvent(View view, String str, String str2, String str3) {
        invoke(PRISM_TOOL_DATA, "DataBinder", "bindCkEvent", view, str, str2, str3);
    }

    public static void bindEpEvent(View view, String str, String str2, String str3) {
        invoke(PRISM_TOOL_DATA, "DataBinder", "bindEpEvent", view, str, str2, str3);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void invoke(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.Object... r7) {
        /*
            boolean r0 = isHavaPrismTool()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L_0x0088
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L_0x0015
            goto L_0x0088
        L_0x0015:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            r0.append(r5)
            java.lang.String r4 = r0.toString()
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x0088 }
            if (r4 != 0) goto L_0x002b
            return
        L_0x002b:
            r5 = 0
            r0 = 0
            if (r7 == 0) goto L_0x0065
            int r1 = r7.length
            if (r1 <= 0) goto L_0x0065
            int r1 = r7.length
            java.lang.Class[] r1 = new java.lang.Class[r1]
            r2 = 0
        L_0x0036:
            int r3 = r7.length
            if (r2 >= r3) goto L_0x0066
            r3 = r7[r2]
            boolean r3 = r3 instanceof android.app.Application
            if (r3 == 0) goto L_0x0044
            java.lang.Class<android.app.Application> r3 = android.app.Application.class
            r1[r2] = r3
            goto L_0x0062
        L_0x0044:
            r3 = r7[r2]
            boolean r3 = r3 instanceof android.content.Context
            if (r3 == 0) goto L_0x004f
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r1[r2] = r3
            goto L_0x0062
        L_0x004f:
            r3 = r7[r2]
            boolean r3 = r3 instanceof android.view.View
            if (r3 == 0) goto L_0x005a
            java.lang.Class<android.view.View> r3 = android.view.View.class
            r1[r2] = r3
            goto L_0x0062
        L_0x005a:
            r3 = r7[r2]
            java.lang.Class r3 = r3.getClass()
            r1[r2] = r3
        L_0x0062:
            int r2 = r2 + 1
            goto L_0x0036
        L_0x0065:
            r1 = r0
        L_0x0066:
            if (r1 != 0) goto L_0x006f
            java.lang.Class[] r1 = new java.lang.Class[r5]     // Catch:{  }
            java.lang.reflect.Method r4 = r4.getDeclaredMethod(r6, r1)     // Catch:{  }
            goto L_0x0073
        L_0x006f:
            java.lang.reflect.Method r4 = r4.getDeclaredMethod(r6, r1)     // Catch:{  }
        L_0x0073:
            if (r4 != 0) goto L_0x0076
            return
        L_0x0076:
            r6 = 1
            r4.setAccessible(r6)
            if (r7 == 0) goto L_0x0083
            int r6 = r7.length     // Catch:{  }
            if (r6 <= 0) goto L_0x0083
            r4.invoke(r0, r7)     // Catch:{  }
            goto L_0x0088
        L_0x0083:
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{  }
            r4.invoke(r0, r5)     // Catch:{  }
        L_0x0088:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.common.utils.PrismUtil.invoke(java.lang.String, java.lang.String, java.lang.String, java.lang.Object[]):void");
    }

    public static boolean isHavaPrismTool() {
        if (1 == isHavePrismTool) {
            return false;
        }
        try {
            if (Class.forName("com.xiaojuchefu.prism.tool.PrismTool") != null) {
                return true;
            }
            isHavePrismTool = 1;
            return false;
        } catch (Throwable unused) {
            isHavePrismTool = 1;
            return false;
        }
    }
}
