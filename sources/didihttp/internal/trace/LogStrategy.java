package didihttp.internal.trace;

import android.text.TextUtils;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.raven.config.RavenKey;
import didinet.ApolloAPI;
import didinet.ApolloKeySwitcher;
import didinet.NetEngine;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

public class LogStrategy {

    /* renamed from: a */
    private boolean f59676a;

    /* renamed from: b */
    private List<URLItem> f59677b;

    /* renamed from: a */
    private boolean m44980a(int i) {
        return i == 2;
    }

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static LogStrategy INSTANCE = new LogStrategy();

        private SingletonHolder() {
        }
    }

    public static LogStrategy getStrategy() {
        return SingletonHolder.INSTANCE;
    }

    private LogStrategy() {
        this.f59677b = new ArrayList();
    }

    public void readFromApollo() {
        if (!this.f59676a) {
            ApolloAPI apolloAPI = NetEngine.getInstance().getApolloAPI();
            String httpLogKey = ApolloKeySwitcher.getInstance().getHttpLogKey();
            if (!TextUtils.isEmpty(httpLogKey)) {
                boolean allow = apolloAPI.getToggle(httpLogKey).allow();
                this.f59676a = allow;
                if (allow) {
                    m44982b((String) apolloAPI.getToggle(httpLogKey).getExperiment().getParam(GPageIdConstant.G_PAGE_ID_CONF, ""));
                }
            }
        }
    }

    /* renamed from: b */
    private void m44982b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (m44980a(jSONObject.optInt(RavenKey.VERSION))) {
                    m44978a(jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    private void m44978a(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("l");
        if (optJSONArray != null) {
            this.f59677b.clear();
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString = optJSONArray.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    if (split.length > 1) {
                        String str = split[0];
                        try {
                            this.f59677b.add(new URLItem(str, Float.parseFloat(split[1])));
                        } catch (NumberFormatException unused) {
                        }
                    } else {
                        this.f59677b.add(new URLItem(optString));
                    }
                }
            }
        }
    }

    public boolean isLogOpen(String str) {
        if (this.f59676a) {
            return m44983c(m44977a(str));
        }
        return false;
    }

    /* renamed from: c */
    private boolean m44983c(String str) {
        for (URLItem next : this.f59677b) {
            if (m44981a(str, next.url)) {
                return m44979a(next.rate);
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m44979a(float f) {
        return new Random().nextFloat() < f;
    }

    /* renamed from: a */
    static String m44977a(String str) {
        int indexOf = str.indexOf(63);
        return indexOf < 0 ? str : str.substring(0, indexOf);
    }

    /* renamed from: a */
    private static boolean m44981a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (!str.equals("https://" + str2)) {
            if (str.equals("http://" + str2)) {
                return true;
            }
            return false;
        }
        return true;
    }

    static class URLItem {
        float rate;
        String url;

        public URLItem(String str, float f) {
            this.url = str;
            this.rate = f;
        }

        public URLItem(String str) {
            this.url = str;
            this.rate = 1.0f;
        }
    }
}
