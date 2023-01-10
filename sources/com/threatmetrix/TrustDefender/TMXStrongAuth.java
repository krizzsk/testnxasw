package com.threatmetrix.TrustDefender;

import android.app.Activity;
import android.content.Intent;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TMXStrongAuth {
    public static final String AUTH_ACTION = "auth_action";
    public static final String AUTH_CONTEXT = "auth_context";
    public static final String AUTH_METHOD = "auth_method";
    public static final String AUTH_PROMPT = "auth_prompt";
    public static final String AUTH_REQUEST_ID = "auth_request_id";
    public static final String AUTH_TITLE = "title";
    public static final String b00640064d00640064d = "stepup";
    private static final int b0064d006400640064d = 65534;
    private static final Map<Integer, AuthenticationCallback> bdd006400640064d = new HashMap(2);

    public enum AuthMethod {
        TMX_UNKNOWN_METHOD("unknownmethod"),
        TMX_USER_PRESENCE("tmxuserpresence"),
        TMX_DEVICE_PRESENCE("tmxdevicepresence");
        
        public final String name;

        private AuthMethod(String str) {
            this.name = str;
        }

        public static AuthMethod b0073s00730073s0073s(String str) {
            for (AuthMethod authMethod : values()) {
                if (str.equals(authMethod.name)) {
                    return authMethod;
                }
            }
            return TMX_UNKNOWN_METHOD;
        }
    }

    public static class AuthParamResult {
        @Nonnull
        public final AuthResult b00640064006400640064d;
        @Nullable
        public final String bddddd0064;

        public AuthParamResult(@Nonnull AuthResult authResult, @Nullable String str) {
            this.b00640064006400640064d = authResult;
            this.bddddd0064 = str;
        }
    }

    public enum AuthResult {
        ALREADY_REGISTERED("ALREADY_REGISTERED", TMXStatusCode.TMX_StrongAuth_AlreadyRegistered),
        CONTEXT_NOT_FOUND("CONTEXT_NOT_FOUND", TMXStatusCode.TMX_StrongAuth_UserNotFound),
        DEREGISTRATION_FAILED("DEREGISTRATION_FAILED", TMXStatusCode.TMX_StrongAuth_Failed),
        DEREGISTERED("DEREGISTERED", TMXStatusCode.TMX_OK),
        MISSING_FUNCTION("MISSING_FUNCTION", TMXStatusCode.TMX_Internal_Error),
        MISSING_PARAMETER("MISSING_PARAMETER", TMXStatusCode.TMX_Internal_Error),
        NOT_SUPPORTED("NOT_SUPPORTED", TMXStatusCode.TMX_StrongAuth_Unsupported),
        REGISTRATION_FAILED("REGISTRATION_FAILED", TMXStatusCode.TMX_StrongAuth_Failed),
        REGISTRATION_CANCELLED("REGISTRATION_CANCELLED", TMXStatusCode.TMX_StrongAuth_Cancelled),
        REGISTERED("REGISTERED", TMXStatusCode.TMX_OK),
        STEPUP_CANCELLED("STEPUP_CANCELLED", TMXStatusCode.TMX_StrongAuth_Cancelled),
        STEPUP_COMPLETE("STEPUP_COMPLETE", TMXStatusCode.TMX_OK),
        STEPUP_FAILED("STEPUP_FAILED", TMXStatusCode.TMX_StrongAuth_Failed);
        
        public final String b0064dddd0064;
        public final TMXStatusCode bd0064ddd0064;

        private AuthResult(String str, TMXStatusCode tMXStatusCode) {
            this.b0064dddd0064 = str;
            this.bd0064ddd0064 = tMXStatusCode;
        }
    }

    public static class AuthenticationCallback implements StrongAuthCallback {
        private int b006400640064dd0064 = 0;
        private final Activity b0064d0064dd0064;
        private int bd00640064dd0064;
        private final CountDownLatch bdd0064dd0064;

        public AuthenticationCallback(Activity activity) {
            this.b0064d0064dd0064 = activity;
            this.bdd0064dd0064 = new CountDownLatch(1);
            this.bd00640064dd0064 = (int) (Math.random() * 65534.0d);
        }

        /* access modifiers changed from: private */
        public void b00730073ss00730073s(int i) {
            this.bd00640064dd0064 = i;
        }

        /* access modifiers changed from: private */
        public CountDownLatch b0073sss00730073s() {
            return this.bdd0064dd0064;
        }

        /* access modifiers changed from: private */
        public void bs0073ss00730073s(int i) {
            this.b006400640064dd0064 = i;
        }

        public int callIntent(Intent intent) {
            try {
                this.b0064d0064dd0064.startActivityForResult(intent, this.bd00640064dd0064);
                this.bdd0064dd0064.await();
                return this.b006400640064dd0064;
            } catch (InterruptedException unused) {
                return 0;
            }
        }

        public int getRequestCode() {
            return this.bd00640064dd0064;
        }
    }

    public enum AuthenticationStatus {
        TMX_STRONG_AUTH_NOT_POSSIBLE,
        TMX_STRONG_AUTH_OK,
        TMX_STRONG_AUTH_FAILED,
        TMX_STRONG_AUTH_CANCELLED
    }

    public interface StrongAuthCallback {
        int callIntent(@Nullable Intent intent);
    }

    public static final class StrongAuthConfiguration {
        public String b00640064d0064d0064;
        public String b0064d00640064d0064;
        public String b0064dd0064d0064;
        public String bd006400640064d0064;
        public String bd0064d0064d0064;
        public String bdd00640064d0064;

        public StrongAuthConfiguration() {
        }

        public StrongAuthConfiguration(@Nonnull String str, @Nonnull String str2, @Nonnull String str3, @Nonnull String str4, @Nullable String str5, @Nonnull String str6) {
            this.bd006400640064d0064 = str2;
            this.bdd00640064d0064 = str6;
            this.b00640064d0064d0064 = str4;
            this.bd0064d0064d0064 = str3;
            this.b0064dd0064d0064 = str;
            this.b0064d00640064d0064 = str5;
        }

        public StrongAuthConfiguration setAuthAction(String str) {
            this.b0064dd0064d0064 = str;
            return this;
        }

        public StrongAuthConfiguration setAuthContext(String str) {
            this.b00640064d0064d0064 = str;
            return this;
        }

        public StrongAuthConfiguration setAuthMethod(String str) {
            this.bd006400640064d0064 = str;
            return this;
        }

        public StrongAuthConfiguration setAuthPrompt(String str) {
            this.bdd00640064d0064 = str;
            return this;
        }

        public StrongAuthConfiguration setAuthRequestId(String str) {
            this.bd0064d0064d0064 = str;
            return this;
        }

        public StrongAuthConfiguration setAuthTitle(String str) {
            this.b0064d00640064d0064 = str;
            return this;
        }
    }

    private TMXStrongAuth() {
    }

    @Nonnull
    public static AuthParamResult generateAuthParamResult(@Nonnull AuthResult authResult, @Nullable String str) {
        return new AuthParamResult(authResult, str);
    }

    public static AuthenticationCallback newAuthenticationCallback(Activity activity) {
        AuthenticationCallback authenticationCallback = new AuthenticationCallback(activity);
        int requestCode = authenticationCallback.getRequestCode();
        synchronized (bdd006400640064d) {
            if (bdd006400640064d.get(Integer.valueOf(requestCode)) != null) {
                authenticationCallback.b00730073ss00730073s((int) (Math.random() * 65534.0d));
            }
            bdd006400640064d.put(Integer.valueOf(authenticationCallback.getRequestCode()), authenticationCallback);
        }
        return authenticationCallback;
    }

    public static void processAuthenticationResult(int i, int i2) {
        synchronized (bdd006400640064d) {
            AuthenticationCallback authenticationCallback = bdd006400640064d.get(Integer.valueOf(i));
            if (authenticationCallback != null) {
                authenticationCallback.bs0073ss00730073s(i2);
                authenticationCallback.b0073sss00730073s().countDown();
            }
            bdd006400640064d.remove(Integer.valueOf(i));
        }
    }
}
