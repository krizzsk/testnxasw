package com.threatmetrix.TrustDefender;

import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface TMXProfilingConnectionsInterface {

    public enum HttpMethod {
        GET,
        POST
    }

    public interface TMXCallback {
        boolean onComplete(@Nonnull TMXHttpResponseCode tMXHttpResponseCode, @Nullable InputStream inputStream);
    }

    public static class TMXHttpResponseCode {
        public static final int HttpResponseCRLError = -15;
        public static final int HttpResponseCertPathBuilderError = -12;
        public static final int HttpResponseCertPathValidatorError = -13;
        public static final int HttpResponseCertStoreError = -14;
        public static final int HttpResponseCertificateEncodingError = -8;
        public static final int HttpResponseCertificateError = -7;
        public static final int HttpResponseCertificateExpired = -9;
        public static final int HttpResponseCertificateMismatch = -6;
        public static final int HttpResponseCertificateNotYetValid = -10;
        public static final int HttpResponseCertificateParsingError = -11;
        public static final int HttpResponseConnectionError = -1;
        public static final int HttpResponseHostNotFoundError = -3;
        public static final int HttpResponseHostVerificationError = -5;
        public static final int HttpResponseNetworkTimeoutError = -4;
        public static final int HttpResponseNotYet = -2;
        public static final int HttpResponseOK = 200;
        private int bd0064dd0064d;

        public TMXHttpResponseCode(int i) {
            this.bd0064dd0064d = i;
        }

        public int getHttpResponseCode() {
            return this.bd0064dd0064d;
        }

        public void setHttpResponseCode(int i) {
            this.bd0064dd0064d = i;
        }

        public boolean succeeded() {
            int i = this.bd0064dd0064d;
            return i == 200 || i == 204;
        }

        public String toString() {
            return String.valueOf(this.bd0064dd0064d);
        }
    }

    void cancelProfiling();

    void httpRequest(@Nonnull HttpMethod httpMethod, @Nonnull String str, Map<String, String> map, byte[] bArr, @Nullable TMXCallback tMXCallback);

    void resolveHostByName(String str);

    void socketRequest(String str, int i, String str2);
}
