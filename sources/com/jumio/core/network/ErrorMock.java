package com.jumio.core.network;

import java.net.SocketTimeoutException;
import javax.net.ssl.SSLException;
import jumio.core.C19463a0;
import jumio.core.C19504s0;
import jumio.core.C19517z;
import org.json.JSONObject;

public class ErrorMock {
    public static String[] getAvailableApiMocks() {
        return new String[0];
    }

    public static String[] getAvailableAutomationResultMocks() {
        return new String[0];
    }

    public static String[] getAvailableCameraConnectionMocks() {
        return new String[0];
    }

    public static String[] getAvailableGoogleVisionMocks() {
        return new String[0];
    }

    public static String[] getAvailableLivenessResultMocks() {
        return new String[0];
    }

    public static String[] getAvailableOcrLoadingMocks() {
        return new String[0];
    }

    public static void onApiMock(int i) throws SocketTimeoutException, C19463a0, C19504s0, SSLException {
    }

    public static void onAutomationResultMock() throws C19517z {
    }

    public static void onCameraConnectionMock() throws Exception {
    }

    public static void onGoogleVisionMock() throws Exception {
    }

    public static void onLivenessResultMock() throws C19517z {
    }

    public static void onOcrLoadingMock() throws Exception {
    }

    public static void onSettingsMock(JSONObject jSONObject) {
    }
}
