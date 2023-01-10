package didinet;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class ApolloKeySwitcher {

    /* renamed from: A */
    private static final String f59812A = "didihttp_transreq_driver";

    /* renamed from: B */
    private static final String f59813B = "didihttp_transreq_brazil_driver";

    /* renamed from: C */
    private static final String f59814C = "esapp_network_trans_toggle";

    /* renamed from: D */
    private static final String f59815D = "push_toggle";

    /* renamed from: E */
    private static final String f59816E = "http_log_psnger";

    /* renamed from: F */
    private static final String f59817F = "http_log_driver";

    /* renamed from: a */
    private static final String f59818a = "HTTP_DNS";

    /* renamed from: b */
    private static final String f59819b = "TRANS";

    /* renamed from: c */
    private static final String f59820c = "didi_http_log";

    /* renamed from: d */
    private static final String f59821d = "_";

    /* renamed from: l */
    private static final String f59822l = "com.didi.passenger";

    /* renamed from: m */
    private static final String f59823m = "com.sdu.didi.psnger";

    /* renamed from: n */
    private static final String f59824n = "com.didi.passenger.global";

    /* renamed from: o */
    private static final String f59825o = "com.sdu.didi.beatles";

    /* renamed from: p */
    private static final String f59826p = "com.taxis99";

    /* renamed from: q */
    private static final String f59827q = "com.sdu.didi.gsui";

    /* renamed from: r */
    private static final String f59828r = "com.app99.driver";

    /* renamed from: s */
    private static final String f59829s = "com.didi.es.psngr";

    /* renamed from: t */
    private static final String f59830t = "com.qingqikeji.operator";

    /* renamed from: u */
    private static final String f59831u = "httpdns_android_v5";

    /* renamed from: v */
    private static final String f59832v = "httpdns_brazil_psnger";

    /* renamed from: w */
    private static final String f59833w = "httpdns_android_driver";

    /* renamed from: x */
    private static final String f59834x = "httpdns_android_brazil_driver";

    /* renamed from: y */
    private static final String f59835y = "didihttp_transreq";

    /* renamed from: z */
    private static final String f59836z = "didihttp_transreq_brazil_psnger";

    /* renamed from: e */
    private String f59837e;

    /* renamed from: f */
    private String f59838f;

    /* renamed from: g */
    private String f59839g;

    /* renamed from: h */
    private Map<String, String> f59840h = new HashMap();

    /* renamed from: i */
    private Map<String, String> f59841i = new HashMap();

    /* renamed from: j */
    private Map<String, String> f59842j = new HashMap();

    /* renamed from: k */
    private Context f59843k;

    public void init(Context context) {
        this.f59840h.put(f59822l, f59831u);
        this.f59840h.put("com.sdu.didi.psnger", f59831u);
        this.f59840h.put(f59824n, f59831u);
        this.f59840h.put(f59825o, f59831u);
        this.f59840h.put("com.taxis99", f59832v);
        this.f59840h.put("com.sdu.didi.gsui", f59833w);
        this.f59840h.put("com.app99.driver", f59834x);
        this.f59841i.put(f59822l, f59835y);
        this.f59841i.put("com.sdu.didi.psnger", f59835y);
        this.f59841i.put(f59824n, f59835y);
        this.f59841i.put(f59825o, f59835y);
        this.f59841i.put("com.taxis99", f59836z);
        this.f59841i.put("com.sdu.didi.gsui", f59812A);
        this.f59841i.put("com.app99.driver", f59813B);
        this.f59841i.put("com.didi.es.psngr", f59814C);
        this.f59841i.put(f59830t, f59815D);
        this.f59842j.put(f59822l, f59816E);
        this.f59842j.put("com.sdu.didi.psnger", f59816E);
        this.f59842j.put(f59824n, f59816E);
        this.f59842j.put("com.sdu.didi.gsui", f59817F);
        this.f59843k = context.getApplicationContext();
    }

    public String getHttpDnsKey() {
        if (TextUtils.isEmpty(this.f59837e)) {
            Context context = this.f59843k;
            if (context != null) {
                this.f59837e = this.f59840h.get(context.getPackageName());
            }
            String terminalTag = NetEngine.getInstance().getTerminalTag();
            if (TextUtils.isEmpty(this.f59837e) && !TextUtils.isEmpty(terminalTag)) {
                this.f59837e = "HTTP_DNS_" + terminalTag;
            }
        }
        return this.f59837e;
    }

    public String getHttpTransReqKey() {
        if (TextUtils.isEmpty(this.f59838f)) {
            Context context = this.f59843k;
            if (context != null) {
                this.f59838f = this.f59841i.get(context.getPackageName());
            }
            String terminalTag = NetEngine.getInstance().getTerminalTag();
            if (TextUtils.isEmpty(this.f59838f) && !TextUtils.isEmpty(terminalTag)) {
                this.f59838f = "TRANS_" + terminalTag;
            }
        }
        return this.f59838f;
    }

    public String getHttpLogKey() {
        Context context;
        String terminalTag = NetEngine.getInstance().getTerminalTag();
        if (TextUtils.isEmpty(this.f59839g) && !TextUtils.isEmpty(terminalTag)) {
            this.f59839g = "didi_http_log_" + terminalTag;
        }
        if (TextUtils.isEmpty(this.f59839g) && (context = this.f59843k) != null) {
            this.f59839g = this.f59842j.get(context.getPackageName());
        }
        return this.f59839g;
    }

    static class SingletonHolder {
        static ApolloKeySwitcher INSTANCE = new ApolloKeySwitcher();

        SingletonHolder() {
        }
    }

    public static ApolloKeySwitcher getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
