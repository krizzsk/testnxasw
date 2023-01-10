package com.didichuxing.swarm.runtime;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;
import org.osgi.framework.FrameworkEvent;
import org.osgi.framework.FrameworkListener;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.Version;
import org.osgi.framework.launch.Framework;

/* renamed from: com.didichuxing.swarm.runtime.b */
/* compiled from: Swarm */
class C17307b extends AbstractBundle implements Framework {

    /* renamed from: r */
    private static final String f51794r = "Swarm";

    /* renamed from: j */
    protected final Map<Long, AbstractBundle> f51795j = new HashMap(1);

    /* renamed from: k */
    protected final Map<String, AbstractBundle> f51796k = new HashMap(1);

    /* renamed from: l */
    protected final MultiMap<String, AbstractBundle> f51797l = new MultiMap<>(1);

    /* renamed from: m */
    protected final MultiMap<String, ServiceReference<?>> f51798m = new MultiMap<>();

    /* renamed from: n */
    protected final Properties f51799n = new Properties(System.getProperties());

    /* renamed from: o */
    protected final List<FrameworkListener> f51800o = new ArrayList(1);

    /* renamed from: p */
    final ClassLoader f51801p;

    /* renamed from: q */
    final ClassLoader f51802q = getClass().getClassLoader();

    /* renamed from: s */
    private final AtomicLong f51803s = new AtomicLong(0);

    /* renamed from: t */
    private final Version f51804t = new Version(BuildConfig.VERSION.replaceAll("\\-SNAPSHOT", ""));

    public final long getBundleId() {
        return 0;
    }

    public final String getLocation() {
        return Constants.SYSTEM_BUNDLE_LOCATION;
    }

    public final String getSymbolicName() {
        return Constants.SYSTEM_BUNDLE_SYMBOLICNAME;
    }

    public void uninstall() throws BundleException {
    }

    public void update() throws BundleException {
    }

    public void update(InputStream inputStream) throws BundleException {
    }

    public FrameworkEvent waitForStop(long j) throws InterruptedException {
        return null;
    }

    public C17307b(Map<String, String> map) {
        String property = this.f51799n.getProperty(Constants.FRAMEWORK_BUNDLE_PARENT);
        if ("app".equals(property)) {
            this.f51801p = ClassLoader.getSystemClassLoader();
        } else if ("framework".equals(property)) {
            this.f51801p = this.f51802q;
        } else if ("ext".equals(property)) {
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            while (systemClassLoader.getParent() != null) {
                systemClassLoader = systemClassLoader.getParent();
            }
            this.f51801p = systemClassLoader;
        } else {
            this.f51801p = new Swarm$1(this, Object.class.getClassLoader());
        }
    }

    public final Version getVersion() {
        return this.f51804t;
    }

    public void init() throws BundleException {
        init(new FrameworkListener[0]);
    }

    public void init(FrameworkListener... frameworkListenerArr) throws BundleException {
        if (32 != this.f51779i && 8 != this.f51779i && 16 != this.f51779i) {
            if (frameworkListenerArr != null && frameworkListenerArr.length > 0) {
                for (FrameworkListener frameworkListener : frameworkListenerArr) {
                    if (frameworkListener != null) {
                        this.f51800o.add(frameworkListener);
                    }
                }
            }
            this.f51795j.put(Long.valueOf(getBundleId()), this);
            this.f51796k.put(getLocation(), this);
            this.f51797l.mo127761a(getSymbolicName(), this);
            this.f51799n.setProperty(Constants.FRAMEWORK_UUID, UUID.randomUUID().toString());
            this.f51779i = 8;
        }
    }

    public void start() throws BundleException {
        start(0);
    }

    public void start(int i) throws BundleException {
        if (32 != this.f51779i) {
            if (8 != this.f51779i) {
                init();
            }
            this.f51779i = 32;
            mo127806a(1, (Bundle) this, (Throwable) null);
        }
    }

    public void stop() throws BundleException {
        stop(0);
    }

    public void stop(int i) throws BundleException {
        new Thread(new Swarm$2(this));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo127805a() {
        this.f51779i = 16;
        this.f51795j.clear();
        this.f51774d.clear();
        this.f51779i = 4;
    }

    /* renamed from: a */
    public Bundle mo127801a(long j) {
        return this.f51795j.get(Long.valueOf(j));
    }

    /* renamed from: a */
    public Bundle mo127802a(String str) {
        return this.f51796k.get(str);
    }

    /* renamed from: b */
    public Bundle[] mo127808b() {
        return (Bundle[]) this.f51795j.values().toArray(new Bundle[this.f51795j.size()]);
    }

    /* renamed from: a */
    public Bundle mo127803a(BundleContext bundleContext, String str) throws BundleException {
        String str2;
        if (str.indexOf(":") > -1) {
            str2 = str;
        } else {
            str2 = "file:." + File.separator + str;
        }
        InputStream inputStream = null;
        try {
            InputStream inputStream2 = new URL(str2).openConnection().getInputStream();
            Bundle a = mo127804a(bundleContext, str, inputStream2);
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException unused) {
                }
            }
            return a;
        } catch (IOException e) {
            throw new BundleException("Cannot retrieve bundle from " + str, 11, e);
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    /* renamed from: a */
    public Bundle mo127804a(BundleContext bundleContext, String str, InputStream inputStream) throws BundleException {
        C17306a aVar = new C17306a(this, bundleContext, this.f51803s.incrementAndGet(), str, inputStream);
        aVar.mo127799a();
        return aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo127806a(int i, Bundle bundle, Throwable th) {
        List<FrameworkListener> list = this.f51800o;
        mo127807a((FrameworkListener[]) list.toArray(new FrameworkListener[list.size()]), i, bundle, th);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo127807a(FrameworkListener[] frameworkListenerArr, int i, Bundle bundle, Throwable th) {
        if (frameworkListenerArr != null && frameworkListenerArr.length > 0) {
            FrameworkEvent frameworkEvent = new FrameworkEvent(i, bundle, th);
            for (FrameworkListener frameworkListener : frameworkListenerArr) {
                if (frameworkListener != null) {
                    frameworkListener.frameworkEvent(frameworkEvent);
                }
            }
        }
    }
}
