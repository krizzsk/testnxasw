package com.didi.sdk.misconfig;

import android.app.Activity;
import android.util.Pair;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.BusinessContextManager;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.app.DIDIApplicationDelegate;
import com.didi.sdk.envsetbase.EnvPreferenceUtil;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.map.ILocation;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.misconfig.p154v2.ConfProxy;
import com.didi.sdk.misconfig.p154v2.SecondConfProxy;
import com.didi.sdk.misconfig.store.MisRequestParams;
import com.didi.sdk.oneconf.OneConfStore;
import com.didi.sdk.util.ApplicationLifeUtils;
import com.didi.sdk.util.EventKeys;
import com.didi.sdk.util.SaApolloUtil;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MisConfigInitializationer {
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final Logger f39602d = LoggerFactory.getLogger("MisConfigInitialization");

    /* renamed from: a */
    LoginListeners.LoginListener f39603a = new LoginListeners.LoginListener() {
        public void onCancel() {
        }

        public void onSuccess(Activity activity, String str) {
            MisConfigInitializationer.this.m29829d();
        }
    };

    /* renamed from: b */
    LoginListeners.LoginOutListener f39604b = new LoginListeners.LoginOutListener() {
        public void onSuccess() {
            MisConfigInitializationer.this.m29829d();
        }
    };

    /* renamed from: c */
    ILocation.ILocationChangedListener f39605c = new ILocation.ILocationChangedListener() {
        public void onLocationChanged(DIDILocation dIDILocation) {
            if (dIDILocation == null) {
                MisConfigInitializationer.f39602d.info("MisConfigStore tencentLocation is null...", new Object[0]);
                return;
            }
            LocationPerformer.getInstance().removeLocationListener(this);
            Logger a = MisConfigInitializationer.f39602d;
            a.info("MisConfigStore tencentLocation lat = " + dIDILocation.getLatitude() + " lng = " + dIDILocation.getLongitude() + " CoordinateType = " + dIDILocation.getCoordinateType(), new Object[0]);
            double latitude = dIDILocation.getLatitude();
            MisConfigInitializationer.this.m29821a(dIDILocation.getLongitude(), latitude, OneConfStore.getInstance().getCityId());
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f39606e;

    /* renamed from: f */
    private volatile boolean f39607f = false;

    /* renamed from: a */
    static /* synthetic */ int m29819a(MisConfigInitializationer misConfigInitializationer) {
        int i = misConfigInitializationer.f39606e;
        misConfigInitializationer.f39606e = i + 1;
        return i;
    }

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final MisConfigInitializationer instance = new MisConfigInitializationer();

        private SingletonHolder() {
        }
    }

    public static MisConfigInitializationer getInstance() {
        return SingletonHolder.instance;
    }

    public void init() {
        if (!SaApolloUtil.INSTANCE.getSaState() && !this.f39607f && EnvPreferenceUtil.getBooleanSafely(DIDIApplication.getAppContext(), "mis_fetch_net_enable", true)) {
            this.f39607f = true;
            m29830e();
            EventBus.getDefault().register(this);
            m29827c();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceive(Pair<String, Integer> pair) {
        if (EventKeys.MisConfig.REFRESH_MIS.equals(pair.first)) {
            boolean z = true;
            if (((Integer) pair.second).intValue() != 1) {
                z = false;
            }
            m29824a(z);
        }
    }

    /* renamed from: b */
    private void m29826b() {
        ActivityLifecycleManager.getInstance().addAppStateListener(new ActivityLifecycleManager.AppStateListener() {
            public void onStateChanged(int i) {
                Logger a = MisConfigInitializationer.f39602d;
                a.info("MisConfigStore state change = " + i, new Object[0]);
                if (i == 1) {
                    MisConfigInitializationer.m29819a(MisConfigInitializationer.this);
                    if (MisConfigInitializationer.this.f39606e == 1) {
                        MisConfigInitializationer.f39602d.info("MisConfigStore lanuch ", new Object[0]);
                        return;
                    }
                    MisConfigInitializationer.f39602d.info("MisConfigStore back to foreground to refresh mis ", new Object[0]);
                    if (BusinessContextManager.getInstance().isInHomePage()) {
                        MisConfigInitializationer.this.m29829d();
                    }
                }
            }
        });
    }

    /* renamed from: c */
    private void m29827c() {
        OneLoginFacade.getFunction().addLoginListener(this.f39603a);
        OneLoginFacade.getFunction().addLoginOutListener(this.f39604b);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m29829d() {
        m29830e();
    }

    /* renamed from: e */
    private void m29830e() {
        m29824a(true);
    }

    /* renamed from: a */
    private void m29824a(boolean z) {
        DIDILocation lastLocation = LocationPerformer.getInstance().getLastLocation();
        if (lastLocation == null || ApplicationLifeUtils.isApplicationInit(DIDIApplicationDelegate.getAppContext())) {
            LocationPerformer.getInstance().addLocationListener(this.f39605c);
            return;
        }
        Logger logger = f39602d;
        logger.info("MisConfigStore lastLocation is not null lat = " + lastLocation.getLatitude() + " lng = " + lastLocation.getLongitude() + " maptype = " + lastLocation.getCoordinateType(), new Object[0]);
        m29822a(lastLocation.getLongitude(), lastLocation.getLatitude(), OneConfStore.getInstance().getCityId(), z);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29821a(double d, double d2, int i) {
        m29822a(d, d2, i, true);
    }

    /* renamed from: a */
    private void m29822a(double d, double d2, int i, boolean z) {
        MisRequestParams misRequestParams = new MisRequestParams();
        misRequestParams.lat = d2;
        misRequestParams.lng = d;
        misRequestParams.cityId = i;
        misRequestParams.mapType = "wgs84";
        ConfProxy.getInstance().getConfigFromNet(misRequestParams);
        if (z) {
            SecondConfProxy.getInstance().getSecConfigFromNet(d, d2, i);
        }
    }
}
