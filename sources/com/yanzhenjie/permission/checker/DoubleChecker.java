package com.yanzhenjie.permission.checker;

import android.content.Context;
import java.util.List;

public final class DoubleChecker implements PermissionChecker {

    /* renamed from: a */
    private static final PermissionChecker f58940a = new StandardChecker();

    /* renamed from: b */
    private static final PermissionChecker f58941b = new StrictChecker();

    public boolean hasPermission(Context context, String... strArr) {
        return f58941b.hasPermission(context, strArr) && f58940a.hasPermission(context, strArr);
    }

    public boolean hasPermission(Context context, List<String> list) {
        return f58941b.hasPermission(context, list) && f58940a.hasPermission(context, list);
    }
}
