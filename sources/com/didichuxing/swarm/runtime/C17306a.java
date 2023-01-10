package com.didichuxing.swarm.runtime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;
import org.osgi.framework.Version;

/* renamed from: com.didichuxing.swarm.runtime.a */
/* compiled from: BundleImpl */
class C17306a extends AbstractBundle {

    /* renamed from: j */
    private final Gson f51790j;

    /* renamed from: k */
    private BundleManifest f51791k = null;

    /* renamed from: l */
    private final String f51792l;

    /* renamed from: m */
    private final Version f51793m;

    public void stop(int i) throws BundleException {
    }

    public void uninstall() throws BundleException {
    }

    public void update() throws BundleException {
    }

    public void update(InputStream inputStream) throws BundleException {
    }

    public C17306a(C17307b bVar, BundleContext bundleContext, long j, String str, InputStream inputStream) {
        super(bVar, j, str);
        Gson create = new GsonBuilder().create();
        this.f51790j = create;
        try {
            this.f51791k = (BundleManifest) create.fromJson((Reader) new InputStreamReader(inputStream), BundleManifest.class);
        } catch (IncompatibleClassChangeError e) {
            e.printStackTrace();
        }
        if (this.f51791k == null) {
            this.f51791k = new BundleManifest();
        }
        this.f51792l = this.f51791k.getSymbolicName();
        this.f51793m = new Version(this.f51791k.getVersion());
        if (this.f51791k.getName() != null) {
            this.f51773c.put(Constants.BUNDLE_NAME, this.f51791k.getName());
        }
        if (this.f51791k.getSymbolicName() != null) {
            this.f51773c.put(Constants.BUNDLE_SYMBOLICNAME, this.f51791k.getSymbolicName());
        }
        if (this.f51791k.getDescription() != null) {
            this.f51773c.put(Constants.BUNDLE_DESCRIPTION, this.f51791k.getDescription());
        }
        if (this.f51791k.getActivator() != null) {
            this.f51773c.put(Constants.BUNDLE_ACTIVATOR, this.f51791k.getActivator());
        }
        if (this.f51791k.getVersion() != null) {
            this.f51773c.put(Constants.BUNDLE_VERSION, this.f51791k.getVersion());
        }
        if (this.f51791k.getVendor() != null) {
            this.f51773c.put(Constants.BUNDLE_VENDOR, this.f51791k.getVendor());
        }
        Map<String, String> dependencies = this.f51791k.getDependencies();
        if (dependencies != null) {
            this.f51773c.put("Bundle-Dependency", this.f51790j.toJson((Object) dependencies));
        }
    }

    public String getSymbolicName() {
        return this.f51792l;
    }

    public Version getVersion() {
        return this.f51793m;
    }

    public void start(int i) throws BundleException {
        mo127800a(i);
    }

    public void start() throws BundleException {
        start(0);
    }

    public void stop() throws BundleException {
        stop(0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo127800a(int i) throws BundleException {
        this.f51779i = 8;
        try {
            BundleActivator bundleActivator = (BundleActivator) loadClass(this.f51791k.getActivator()).newInstance();
            if (bundleActivator instanceof SwarmPlugin) {
                ((SwarmPlugin) bundleActivator).setBundle(this);
            }
            bundleActivator.start(this.f51772b);
            this.f51779i = 32;
        } catch (Exception e) {
            throw new BundleException("Error starting bundle " + toString(), 5, e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo127799a() throws BundleException {
        this.f51771a.f51795j.put(Long.valueOf(getBundleId()), this);
        this.f51771a.f51796k.put(getLocation(), this);
        this.f51771a.f51797l.mo127761a(getSymbolicName(), this);
    }
}
