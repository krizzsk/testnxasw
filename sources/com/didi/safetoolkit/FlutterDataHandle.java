package com.didi.safetoolkit;

import p218io.flutter.plugin.common.MethodChannel;

public interface FlutterDataHandle {
    void onDetached();

    void onGetInfo(MethodChannel.Result result);
}
