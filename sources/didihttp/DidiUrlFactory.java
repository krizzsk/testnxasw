package didihttp;

import android.text.TextUtils;
import android.util.Log;
import com.didi.hawaii.mapsdkv2.HWMapConstant;
import com.didiglobal.privacy.domainmonitor.urlconnection.HttpURLConnectionHooker;
import didihttp.internal.URLFilter;
import didihttp.internal.huc.DidiHttpURLConnection;
import didihttp.internal.huc.DidiHttpsURLConnection;
import didinet.ApolloAPI;
import didinet.Logger;
import didinet.NetEngine;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class DidiUrlFactory implements Cloneable, URLStreamHandlerFactory {

    /* renamed from: a */
    private static final String f59181a = "DidiUrlFactory";

    /* renamed from: e */
    private static List<String> f59182e = new CopyOnWriteArrayList();

    /* renamed from: f */
    private static URLStreamHandler f59183f = null;

    /* renamed from: g */
    private static URLStreamHandler f59184g = null;

    /* renamed from: i */
    private static final int f59185i = 30;

    /* renamed from: j */
    private static final int f59186j = 1;

    /* renamed from: l */
    private static Map<String, UrlModule> f59187l = new ConcurrentHashMap();

    /* renamed from: b */
    private DidiHttpClient f59188b;

    /* renamed from: c */
    private URLFilter f59189c;

    /* renamed from: d */
    private boolean f59190d;

    /* renamed from: h */
    private AtomicInteger f59191h = new AtomicInteger(0);

    /* renamed from: k */
    private int f59192k;

    static {
        try {
            URL url = new URL("http://localhost");
            URL url2 = new URL("https://localhost");
            f59183f = m44709a(url);
            f59184g = m44709a(url2);
        } catch (Throwable th) {
            Logger.m45047d(f59181a, "static initializer: " + Log.getStackTraceString(th));
        }
    }

    public static void addBlackList(String str) {
        if (!f59182e.contains(str)) {
            f59182e.add(str);
        }
        if (!f59187l.containsKey(str)) {
            UrlModule urlModule = new UrlModule();
            urlModule.url = str;
            urlModule.rate = 1.0f;
            f59187l.put(str, urlModule);
        }
    }

    /* renamed from: a */
    private static URLStreamHandler m44709a(URL url) {
        Field field;
        Field[] declaredFields = URL.class.getDeclaredFields();
        int i = 0;
        while (true) {
            if (i < declaredFields.length) {
                if (Modifier.isTransient(declaredFields[i].getModifiers()) && declaredFields[i].getType().equals(URLStreamHandler.class)) {
                    field = declaredFields[i];
                    break;
                }
                i++;
            } else {
                field = null;
                break;
            }
        }
        if (field == null) {
            return null;
        }
        field.setAccessible(true);
        try {
            return (URLStreamHandler) field.get(url);
        } catch (Throwable th) {
            Logger.m45048d(f59181a, "", th);
            return null;
        }
    }

    public DidiUrlFactory(DidiHttpClient didiHttpClient) {
        this.f59188b = didiHttpClient;
        m44710a();
    }

    /* renamed from: a */
    private void m44710a() {
        ApolloAPI apolloAPI = NetEngine.getInstance().getApolloAPI();
        this.f59190d = apolloAPI.getToggle("hook_uc").allow();
        Logger.m45047d(f59181a, "hookEnabled is " + this.f59190d);
        if (this.f59190d) {
            String str = (String) apolloAPI.getToggle("hook_uc").getExperiment().getParam("bl", "");
            int intValue = ((Integer) apolloAPI.getToggle("hook_uc").getExperiment().getParam("enable_domain", 0)).intValue();
            this.f59192k = intValue;
            if (intValue == 1) {
                m44715b(str);
            } else {
                m44711a(str);
            }
        }
    }

    /* renamed from: a */
    private void m44711a(String str) {
        Logger.m45047d(f59181a, String.format("blacklist [%s]", new Object[]{str}));
        f59182e.clear();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray("l");
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        f59182e.add(optString);
                    }
                }
            } catch (JSONException e) {
                Logger.m45047d(f59181a, "parseParam:" + Log.getStackTraceString(e));
            }
        }
    }

    /* renamed from: b */
    private void m44715b(String str) {
        Logger.m45047d(f59181a, String.format("new blacklist [%s]", new Object[]{str}));
        f59182e.clear();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray("l");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    f59187l.clear();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        String[] split = optJSONArray.optString(i, "").split(",");
                        if (split.length == 1) {
                            UrlModule urlModule = new UrlModule();
                            urlModule.url = split[0];
                            urlModule.rate = 1.0f;
                            f59187l.put(urlModule.url, urlModule);
                        } else if (split.length >= 2) {
                            UrlModule urlModule2 = new UrlModule();
                            urlModule2.url = split[0];
                            try {
                                urlModule2.rate = Float.parseFloat(split[1]);
                            } catch (NumberFormatException unused) {
                                urlModule2.rate = 0.0f;
                            }
                            f59187l.put(urlModule2.url, urlModule2);
                        }
                    }
                    Logger.m45047d(f59181a, "blurls size:" + f59187l.size());
                }
            } catch (JSONException e) {
                Logger.m45047d(f59181a, "parseParamNew:" + Log.getStackTraceString(e));
            }
        }
    }

    public DidiHttpClient client() {
        return this.f59188b;
    }

    public DidiUrlFactory setClient(DidiHttpClient didiHttpClient) {
        this.f59188b = didiHttpClient;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo179379a(URLFilter uRLFilter) {
        this.f59189c = uRLFilter;
    }

    public DidiUrlFactory clone() {
        return new DidiUrlFactory(this.f59188b);
    }

    public HttpURLConnection open(URL url) throws IOException {
        return HttpURLConnectionHooker.wrapConnection(mo179378a(url, this.f59188b.proxy()));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public HttpURLConnection mo179378a(URL url, Proxy proxy) throws IOException {
        String protocol = url.getProtocol();
        URLStreamHandler uRLStreamHandler = "https".equals(protocol) ? f59184g : f59183f;
        if ((!this.f59190d || this.f59192k == 1 || m44716c(m44714b(url))) && ((!this.f59190d || this.f59192k != 1 || m44717d(url.toString())) && uRLStreamHandler != null)) {
            if (!this.f59190d && this.f59191h.get() < 30) {
                this.f59191h.incrementAndGet();
                m44710a();
            }
            Logger.m45047d(f59181a, "use default StreamHandler");
            return (HttpURLConnection) new URL((URL) null, url.toString(), uRLStreamHandler).openConnection();
        }
        DidiHttpClient build = this.f59188b.newBuilder().proxy(proxy).build();
        if (protocol.equals("http")) {
            return new DidiHttpURLConnection(url, build, this.f59189c);
        }
        if (protocol.equals("https")) {
            return new DidiHttpsURLConnection(url, build, this.f59189c);
        }
        throw new IllegalArgumentException("Unexpected protocol: " + protocol);
    }

    /* renamed from: b */
    private String m44714b(URL url) {
        return url.getHost() + url.getPath();
    }

    /* renamed from: c */
    private boolean m44716c(String str) {
        if (TextUtils.isEmpty(str)) {
            Logger.m45047d(f59181a, "url is empty.");
            return false;
        }
        for (String contains : f59182e) {
            if (str.contains(contains)) {
                Logger.m45047d(f59181a, String.format("[%s] in blacklist", new Object[]{str}));
                return true;
            }
        }
        Logger.m45047d(f59181a, String.format("[%s] not in blacklist", new Object[]{str}));
        return false;
    }

    /* renamed from: d */
    private boolean m44717d(String str) {
        UrlModule urlModule = f59187l.get(m44719f(str));
        if (urlModule != null) {
            boolean a = m44713a(urlModule);
            Logger.m45047d(f59181a, String.format("[%s] api mode： [%s] in the black list => %b", new Object[]{f59181a, str, Boolean.valueOf(a)}));
            return a;
        }
        UrlModule urlModule2 = f59187l.get(m44719f(m44718e(str)));
        boolean a2 = urlModule2 != null ? m44713a(urlModule2) : false;
        Logger.m45047d(f59181a, String.format("[%s] domain mode： [%s] in the black list => %b", new Object[]{f59181a, str, Boolean.valueOf(a2)}));
        return a2;
    }

    /* renamed from: a */
    private boolean m44713a(UrlModule urlModule) {
        if (urlModule.rateStatus == -1) {
            urlModule.rateStatus = m44712a(urlModule.rate) ^ true ? 1 : 0;
        }
        if (urlModule.rateStatus == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    private String m44718e(String str) {
        try {
            URL url = new URL(str);
            return url.getProtocol() + HWMapConstant.HTTP.SEPARATOR + url.getHost() + "/*";
        } catch (Exception e) {
            Logger.m45050e(f59181a, "", e);
            return null;
        }
    }

    /* renamed from: f */
    private String m44719f(String str) {
        try {
            URL url = new URL(str);
            return url.getHost() + url.getPath();
        } catch (Exception e) {
            Logger.m45050e(f59181a, "", e);
            return null;
        }
    }

    /* renamed from: a */
    private boolean m44712a(float f) {
        return new Random().nextFloat() < f;
    }

    public URLStreamHandler createURLStreamHandler(final String str) {
        if (str.equals("http") || str.equals("https")) {
            return new URLStreamHandler() {
                /* access modifiers changed from: protected */
                public URLConnection openConnection(URL url) throws IOException {
                    return DidiUrlFactory.this.open(url);
                }

                /* access modifiers changed from: protected */
                public URLConnection openConnection(URL url, Proxy proxy) throws IOException {
                    return HttpURLConnectionHooker.wrapConnection(DidiUrlFactory.this.mo179378a(url, proxy));
                }

                /* access modifiers changed from: protected */
                public int getDefaultPort() {
                    if (str.equals("http")) {
                        return 80;
                    }
                    if (str.equals("https")) {
                        return 443;
                    }
                    throw new AssertionError();
                }
            };
        }
        return null;
    }

    private static class UrlModule {
        public static final int RATE_FAIL = 1;
        public static final int RATE_INIT = -1;
        public static final int RATE_SUCCESS = 0;
        float rate;
        volatile int rateStatus;
        String url;

        private UrlModule() {
            this.rateStatus = -1;
        }
    }
}
