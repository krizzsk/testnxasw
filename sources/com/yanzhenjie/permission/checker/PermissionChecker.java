package com.yanzhenjie.permission.checker;

import android.content.Context;
import java.util.List;

public interface PermissionChecker {
    boolean hasPermission(Context context, List<String> list);

    boolean hasPermission(Context context, String... strArr);
}
