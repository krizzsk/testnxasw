package com.didi.foundation.sdk.swarm;

import android.app.Application;
import com.didichuxing.swarm.runtime.SwarmPlugin;
import com.didichuxing.swarm.toolkit.AuthenticationService;
import com.didichuxing.swarm.toolkit.BusinessContextService;
import com.didichuxing.swarm.toolkit.DeviceService;
import com.didichuxing.swarm.toolkit.DistributionService;
import com.didichuxing.swarm.toolkit.LanguageService;
import com.didichuxing.swarm.toolkit.LocationService;
import com.didichuxing.swarm.toolkit.LogService;
import com.didichuxing.swarm.toolkit.ScreenshotService;
import com.didichuxing.swarm.toolkit.SecurityService;
import com.didichuxing.swarm.toolkit.TraceLogService;
import com.didichuxing.swarm.toolkit.TransmissionService;
import com.didichuxing.swarm.toolkit.UserService;
import java.util.Arrays;
import java.util.Collections;
import java.util.Dictionary;
import java.util.List;
import org.osgi.framework.BundleContext;

public final class Activator extends SwarmPlugin {
    public static final List<String> ASSET_BUNDLES = Collections.unmodifiableList(Arrays.asList(new String[]{"bundles/theonelog/manifest.json", "bundles/com.didichuxing.apollo.sdk.swarm/manifest.json", "bundles/feedback/manifest.json", "bundles/omega-swarm/manifest.json"}));

    /* renamed from: a */
    private final BusinessContextService f23187a = new C8978a();

    /* renamed from: b */
    private final DeviceService f23188b = new C8979b();

    /* renamed from: c */
    private final LocationService f23189c = new C8981d();

    /* renamed from: d */
    private final UserService f23190d = new C8986i();

    /* renamed from: e */
    private final TransmissionService f23191e = new C8985h();

    /* renamed from: f */
    private final SecurityService f23192f = new C8983f();

    /* renamed from: g */
    private final LogService f23193g = new C8982e();

    /* renamed from: h */
    private final ScreenshotService f23194h;

    /* renamed from: i */
    private final DistributionService f23195i;

    /* renamed from: j */
    private final TraceLogService f23196j;

    /* renamed from: k */
    private final AuthenticationService f23197k;

    /* renamed from: l */
    private final LanguageService f23198l;

    public Activator(Application application) {
        this.f23194h = new ScreenShotServiceImp(application);
        this.f23195i = new C8980c();
        this.f23197k = new AuthenticationServiceImpl(application);
        this.f23196j = new C8984g();
        this.f23198l = new LanguageServiceImpl();
    }

    public void start(BundleContext bundleContext) {
        bundleContext.registerService(BusinessContextService.class, this.f23187a, (Dictionary<String, ?>) null);
        bundleContext.registerService(DeviceService.class, this.f23188b, (Dictionary<String, ?>) null);
        bundleContext.registerService(LocationService.class, this.f23189c, (Dictionary<String, ?>) null);
        bundleContext.registerService(UserService.class, this.f23190d, (Dictionary<String, ?>) null);
        bundleContext.registerService(TransmissionService.class, this.f23191e, (Dictionary<String, ?>) null);
        bundleContext.registerService(SecurityService.class, this.f23192f, (Dictionary<String, ?>) null);
        bundleContext.registerService(LogService.class, this.f23193g, (Dictionary<String, ?>) null);
        bundleContext.registerService(ScreenshotService.class, this.f23194h, (Dictionary<String, ?>) null);
        bundleContext.registerService(UserService.class, this.f23190d, (Dictionary<String, ?>) null);
        bundleContext.registerService(TraceLogService.class, this.f23196j, (Dictionary<String, ?>) null);
        bundleContext.registerService(AuthenticationService.class, this.f23197k, (Dictionary<String, ?>) null);
        bundleContext.registerService(DistributionService.class, this.f23195i, (Dictionary<String, ?>) null);
        bundleContext.registerService(LanguageService.class, this.f23198l, (Dictionary<String, ?>) null);
    }

    public void stop(BundleContext bundleContext) {
        bundleContext.ungetService(bundleContext.getServiceReference(BusinessContextService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(DeviceService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(LocationService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(UserService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(TransmissionService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(SecurityService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(LogService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(ScreenshotService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(UserService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(TraceLogService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(AuthenticationService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(LanguageService.class));
    }
}
