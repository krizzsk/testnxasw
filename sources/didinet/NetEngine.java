package didinet;

import android.content.Context;
import android.os.SystemClock;
import didihttp.Interceptor;
import didihttp.StatisticalCallback;
import didihttp.internal.trace.LogStrategy;
import didinet.ApolloAPI;
import didinet.ConnectCallback;
import didinet.DnsCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import utils.ContextUtil;

public class NetEngine {

    /* renamed from: a */
    private HashSet<StatisticalCallback> f59874a;

    /* renamed from: b */
    private Lock f59875b;

    /* renamed from: c */
    private NetworkStateManager f59876c;

    /* renamed from: d */
    private OmegaAPI f59877d;

    /* renamed from: e */
    private ApolloAPI f59878e;

    /* renamed from: f */
    private NetworkDetectionAPI f59879f;

    /* renamed from: g */
    private PushAPI f59880g;

    /* renamed from: h */
    private NetConfig f59881h;

    /* renamed from: i */
    private volatile Interceptor f59882i;

    /* renamed from: j */
    private final List<DnsCallback> f59883j;

    /* renamed from: k */
    private final List<ConnectCallback> f59884k;

    /* renamed from: l */
    private String f59885l;

    /* renamed from: m */
    private ExternalParamGetter f59886m;

    /* renamed from: n */
    private volatile int f59887n;

    /* renamed from: o */
    private boolean f59888o;

    public interface ExternalParamGetter {
        ExternalParam onGetExternalParam();
    }

    public static NetEngine getInstance() {
        return Holder.STATISTICAL_DATA_MANAGER;
    }

    private static class Holder {
        /* access modifiers changed from: private */
        public static final NetEngine STATISTICAL_DATA_MANAGER = new NetEngine();

        private Holder() {
        }
    }

    private NetEngine() {
        this.f59874a = new HashSet<>();
        this.f59875b = new ReentrantLock();
        this.f59877d = OmegaAPI.NONE;
        this.f59878e = ApolloAPI.NONE;
        this.f59879f = NetworkDetectionAPI.NONE;
        this.f59880g = PushAPI.NONE;
        this.f59881h = NetConfig.f59849a;
        this.f59883j = new ArrayList();
        this.f59884k = new ArrayList();
        this.f59887n = -1;
        this.f59888o = true;
    }

    public void create(Context context) {
        ContextUtil.initApplicationContext(context);
        NetworkStateManager networkStateManager = new NetworkStateManager(context);
        this.f59876c = networkStateManager;
        networkStateManager.listene();
        ApolloKeySwitcher.getInstance().init(context);
        LogStrategy.getStrategy().readFromApollo();
    }

    public void destroy() {
        this.f59876c.remove();
        this.f59876c = null;
    }

    public NetworkStateManager getNetworkStateManager() {
        return this.f59876c;
    }

    public void addStatisticalCallback(StatisticalCallback statisticalCallback) {
        this.f59875b.lock();
        try {
            this.f59874a.add(statisticalCallback);
        } finally {
            this.f59875b.unlock();
        }
    }

    public void removeStatisticalCallback(StatisticalCallback statisticalCallback) {
        this.f59875b.lock();
        try {
            this.f59874a.remove(statisticalCallback);
        } finally {
            this.f59875b.unlock();
        }
    }

    public Collection<StatisticalCallback> getStatisticalCallbacks() {
        this.f59875b.lock();
        try {
            return new HashSet(this.f59874a);
        } finally {
            this.f59875b.unlock();
        }
    }

    public void addDnsCallback(DnsCallback dnsCallback) {
        synchronized (this.f59883j) {
            this.f59883j.add(dnsCallback);
        }
    }

    public void removeDnsCallback(DnsCallback dnsCallback) {
        synchronized (this.f59883j) {
            this.f59883j.remove(dnsCallback);
        }
    }

    public void notifyDnsCallback(DnsCallback.DnsContext dnsContext) {
        ArrayList<DnsCallback> arrayList;
        synchronized (this.f59883j) {
            arrayList = new ArrayList<>(this.f59883j);
        }
        for (DnsCallback onDnsFinished : arrayList) {
            onDnsFinished.onDnsFinished(dnsContext);
        }
    }

    public void addConnectCallback(ConnectCallback connectCallback) {
        synchronized (this.f59884k) {
            this.f59884k.add(connectCallback);
        }
    }

    public void removeConnectCallback(ConnectCallback connectCallback) {
        synchronized (this.f59884k) {
            this.f59884k.remove(connectCallback);
        }
    }

    public void notifyConnectCallback(ConnectCallback.ConnectContext connectContext) {
        ArrayList<ConnectCallback> arrayList;
        synchronized (this.f59883j) {
            arrayList = new ArrayList<>(this.f59884k);
        }
        for (ConnectCallback onConnectFinished : arrayList) {
            onConnectFinished.onConnectFinished(connectContext);
        }
    }

    public NetConfig getNetConfig() {
        return this.f59881h;
    }

    /* renamed from: a */
    private void m45061a() {
        try {
            ApolloAPI.Toggle toggle = this.f59878e.getToggle("net_config_expr");
            if (toggle.allow()) {
                this.f59881h = new NetConfig((String) toggle.getExperiment().getParam("cfg", ""));
            }
        } catch (Exception unused) {
            this.f59881h = NetConfig.f59849a;
        }
    }

    public void setOmegaAPI(OmegaAPI omegaAPI) {
        if (omegaAPI == null) {
            omegaAPI = OmegaAPI.NONE;
        }
        this.f59877d = omegaAPI;
    }

    public void setApolloAPI(ApolloAPI apolloAPI) {
        if (apolloAPI == null) {
            apolloAPI = ApolloAPI.NONE;
        }
        this.f59878e = apolloAPI;
        m45061a();
    }

    public OmegaAPI getOmegaAPI() {
        return this.f59877d;
    }

    public ApolloAPI getApolloAPI() {
        return this.f59878e;
    }

    public NetworkDetectionAPI getNetworkDetectionAPI() {
        return this.f59879f;
    }

    public void setNetworkDetectionAPI(NetworkDetectionAPI networkDetectionAPI) {
        if (networkDetectionAPI == null) {
            networkDetectionAPI = NetworkDetectionAPI.NONE;
        }
        this.f59879f = networkDetectionAPI;
    }

    public PushAPI getPushAPI() {
        return this.f59880g;
    }

    public void setPushAPI(PushAPI pushAPI) {
        if (pushAPI == null) {
            pushAPI = PushAPI.NONE;
        }
        this.f59880g = pushAPI;
    }

    public Interceptor getTransformInterceptor() {
        return this.f59882i;
    }

    public void setTransformInterceptor(Interceptor interceptor) {
        this.f59882i = interceptor;
    }

    public ExternalParamGetter getParamGetter() {
        return this.f59886m;
    }

    public void setParamGetter(ExternalParamGetter externalParamGetter) {
        this.f59886m = externalParamGetter;
    }

    public static class ExternalParam {
        public static final int APP_STATE_BACKGROUND = 2;
        public static final int APP_STATE_FOREGROUND = 1;
        private volatile int appState = -1;
        private volatile long backgroundTimeMillis;
        private volatile int cityId = -1;
        private volatile int flowTag = -1;

        public int getCityId() {
            return this.cityId;
        }

        public void setCityId(int i) {
            this.cityId = i;
        }

        public boolean hasCityId() {
            return this.cityId != -1;
        }

        public int getFlowTag() {
            return this.flowTag;
        }

        public void setFlowTag(int i) {
            this.flowTag = i;
        }

        public boolean hasFlowTag() {
            return this.flowTag != -1;
        }

        public int getAppState() {
            return this.appState;
        }

        public void setAppState(int i) {
            this.appState = i;
            if (this.appState == 2) {
                this.backgroundTimeMillis = SystemClock.elapsedRealtime();
            }
        }

        public boolean hasAppState() {
            return this.appState != -1;
        }

        public long getBackgroundDuration() {
            return SystemClock.elapsedRealtime() - this.backgroundTimeMillis;
        }
    }

    public int getBootStatus() {
        return this.f59887n;
    }

    public void setBootStatus(int i) {
        this.f59887n = i;
    }

    public String getTerminalTag() {
        return this.f59885l;
    }

    public void setTerminalTag(String str) {
        this.f59885l = str;
    }

    public void setTransEnabled(boolean z) {
        this.f59888o = z;
    }

    public boolean isTransEnabled() {
        return this.f59888o;
    }

    public boolean supportIpv6() {
        LocalIPStack localIPStack = getPushAPI().getLocalIPStack();
        return localIPStack == LocalIPStack.IPv6 || localIPStack == LocalIPStack.Dual;
    }
}
