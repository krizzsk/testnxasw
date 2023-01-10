package com.didichuxing.mlcp.drtc.interfaces;

public interface DrtcSDKInitializeListener extends C16688c {
    void onSDKInitializeResult(int i);

    void onSDKLogMessage(String str);

    void onSDKReleased();
}
