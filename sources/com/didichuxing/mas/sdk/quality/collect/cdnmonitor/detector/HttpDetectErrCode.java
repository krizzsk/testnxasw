package com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detector;

import android.text.TextUtils;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class HttpDetectErrCode {
    public static final int CONNECTION_FAILED = 1002;
    public static final int CONNECTION_TIMEOUT = 1004;
    public static final int DNS_PARSE_FAILED = 1001;
    public static final int HTTP_IO_ERROR = 1010;
    public static final int HTTP_MD5_ERROR = 1008;
    public static final int HTTP_OK_DOWN = 2200;
    public static final int HTTP_UNKNOWN_ERROR = 1000;
    public static final int HTTP_URL_ERROR = 1009;
    public static final int READ_TIMEOUT = 1006;
    public static final int SSL_HANDSHAKE_TIMEOUT = 1005;
    public static final int UNKNOWN_TIMEOUT = 1003;
    public static final int WAIT_TIMEOUT = 1007;
    public static final int WRITE_TIMEOUT = 1007;

    /* renamed from: a */
    private static final String f50333a = "connect";

    /* renamed from: b */
    private static final String f50334b = "read";

    /* renamed from: c */
    private static final String f50335c = "write";

    /* renamed from: d */
    private static final String f50336d = "ssl";

    public static int praseException(Throwable th) {
        if (th instanceof MalformedURLException) {
            return 1009;
        }
        if (th instanceof UnknownHostException) {
            return 1001;
        }
        if (th instanceof SocketTimeoutException) {
            if (TextUtils.isEmpty(th.getMessage())) {
                return 1003;
            }
            String lowerCase = th.getMessage().toLowerCase();
            if (lowerCase.contains("connect")) {
                return 1004;
            }
            if (lowerCase.contains(f50336d)) {
                return 1005;
            }
            if (lowerCase.contains(f50334b)) {
                return 1006;
            }
            if (lowerCase.contains(f50335c)) {
                return 1007;
            }
            return 1003;
        } else if (th instanceof ConnectException) {
            return 1002;
        } else {
            return th instanceof IOException ? 1010 : 1000;
        }
    }
}
