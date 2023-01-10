package didihttpdns.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

public final class HttpDnsPrefs {
    public static final String KEY_TTL = "ttl";
    public static final String KEY_UPDATE_TIME = "update_time";
    public static final String SHARED_PREFS_NAME = "http_dns";

    /* renamed from: c */
    private static HttpDnsPrefs f59806c;

    /* renamed from: a */
    private SharedPreferences f59807a;

    /* renamed from: b */
    private SharedPreferences.Editor f59808b;

    private HttpDnsPrefs(Context context) {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context.getApplicationContext(), SHARED_PREFS_NAME, 0);
        this.f59807a = sharedPreferences;
        this.f59808b = sharedPreferences.edit();
    }

    public static HttpDnsPrefs getInstance(Context context) {
        if (f59806c == null) {
            synchronized (HttpDnsPrefs.class) {
                if (f59806c == null) {
                    f59806c = new HttpDnsPrefs(context);
                }
            }
        }
        return f59806c;
    }
}
