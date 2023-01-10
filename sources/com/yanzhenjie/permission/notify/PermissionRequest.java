package com.yanzhenjie.permission.notify;

import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.Rationale;

public interface PermissionRequest {
    PermissionRequest onDenied(Action<Void> action);

    PermissionRequest onGranted(Action<Void> action);

    PermissionRequest rationale(Rationale<Void> rationale);

    void start();
}
