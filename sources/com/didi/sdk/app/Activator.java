package com.didi.sdk.app;

import com.didi.sdk.sidebar.setup.mutilocale.LocaleSwarmServiceImpl;
import com.didi.sdk.swarm.NationServiceImpl;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didichuxing.swarm.launcher.toolkit.NationService;
import com.didichuxing.swarm.toolkit.AuthenticationService;
import com.didichuxing.swarm.toolkit.BusinessContextService;
import com.didichuxing.swarm.toolkit.DeviceService;
import com.didichuxing.swarm.toolkit.DistributionService;
import com.didichuxing.swarm.toolkit.LanguageService;
import com.didichuxing.swarm.toolkit.LocationService;
import com.didichuxing.swarm.toolkit.LogService;
import com.didichuxing.swarm.toolkit.OmegaService;
import com.didichuxing.swarm.toolkit.ScreenshotService;
import com.didichuxing.swarm.toolkit.SecurityService;
import com.didichuxing.swarm.toolkit.TransmissionService;
import com.didichuxing.swarm.toolkit.UserService;
import java.util.Dictionary;
import org.osgi.framework.BundleContext;

@ServiceProvider({AbsActivator.class})
public class Activator extends AbsActivator {
    public static String[] ASSET_BUNDLES = {"bundles/theonelog/manifest.json", "bundles/com.didichuxing.apollo.sdk.swarm/manifest.json", "bundles/com.xiaoju.nova.passenger.sidebar/manifest.json", "bundles/alpha/manifest.json", "bundles/devicemanager/manifest.json", "bundles/feedback/manifest.json", "bundles/omega-swarm/manifest.json", "bundles/zhongce-h5test/manifest.json", "bundles/autotest/manifest.json"};

    /* renamed from: a */
    private final BusinessContextService f37846a = new C12835b();

    /* renamed from: b */
    private final C12836c f37847b = new C12836c();

    /* renamed from: c */
    private final C12838e f37848c = new C12838e();

    /* renamed from: d */
    private final OmegaService f37849d = new C12841h();

    /* renamed from: e */
    private final UserService f37850e = new C12844k();

    /* renamed from: f */
    private final TransmissionService f37851f = new C12843j();

    /* renamed from: g */
    private final SecurityServiceImpl f37852g = new SecurityServiceImpl();

    /* renamed from: h */
    private final ScreenshotService f37853h = new ScreenshotServiceImpl(DIDIBaseApplication.getAppContext());

    /* renamed from: i */
    private final DistributionService f37854i = new C12837d();

    /* renamed from: j */
    private final LogService f37855j = new C12839f();

    /* renamed from: k */
    private final AuthenticationService f37856k = new C12834a(DIDIBaseApplication.getAppContext());

    /* renamed from: l */
    private final LanguageService f37857l = new LocaleSwarmServiceImpl();

    /* renamed from: m */
    private final NationService f37858m = new NationServiceImpl();

    public String[] getAssetBundles() {
        return ASSET_BUNDLES;
    }

    public void start(BundleContext bundleContext) {
        bundleContext.registerService(BusinessContextService.class, this.f37846a, (Dictionary<String, ?>) null);
        bundleContext.registerService(DeviceService.class, this.f37847b, (Dictionary<String, ?>) null);
        bundleContext.registerService(LocationService.class, this.f37848c, (Dictionary<String, ?>) null);
        bundleContext.registerService(OmegaService.class, this.f37849d, (Dictionary<String, ?>) null);
        bundleContext.registerService(UserService.class, this.f37850e, (Dictionary<String, ?>) null);
        bundleContext.registerService(TransmissionService.class, this.f37851f, (Dictionary<String, ?>) null);
        bundleContext.registerService(SecurityService.class, this.f37852g, (Dictionary<String, ?>) null);
        bundleContext.registerService(ScreenshotService.class, this.f37853h, (Dictionary<String, ?>) null);
        bundleContext.registerService(DistributionService.class, this.f37854i, (Dictionary<String, ?>) null);
        bundleContext.registerService(LogService.class, this.f37855j, (Dictionary<String, ?>) null);
        bundleContext.registerService(AuthenticationService.class, this.f37856k, (Dictionary<String, ?>) null);
        bundleContext.registerService(LanguageService.class, this.f37857l, (Dictionary<String, ?>) null);
        bundleContext.registerService(NationService.class, this.f37858m, (Dictionary<String, ?>) null);
    }

    public void stop(BundleContext bundleContext) {
        bundleContext.ungetService(bundleContext.getServiceReference(BusinessContextService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(DeviceService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(LocationService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(OmegaService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(UserService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(TransmissionService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(SecurityService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(ScreenshotService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(DistributionService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(LogService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(AuthenticationService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(LanguageService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(NationService.class));
    }
}
