package com.didi.sdk.componentspi;

import android.app.Application;
import android.content.Context;
import com.didi.product.global.BuildConfig;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.app.DIDIApplicationDelegate;
import com.didi.sdk.developermode.DevModePreference;
import com.didi.sdk.developermode.DevModeUtil;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.nation.INationTypeComponent;
import com.didi.sdk.nation.MapType;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.util.AnalysisAPK;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.EventKeys;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.domainservice.DomainServiceManager;
import com.didiglobal.domainservice.utils.DomainUtil;
import com.didiglobal.domainservice.utils.ELog;

@ServiceProvider({INationTypeComponent.class})
public class NationTypeComponent implements INationTypeComponent {

    /* renamed from: a */
    private static Logger f38458a = LoggerFactory.getLogger("NationTypeComponent");

    /* renamed from: b */
    private NationComponentData f38459b;

    /* renamed from: c */
    private final NationComponentData.LoginAction f38460c = new NationComponentData.LoginAction() {
        public void login() {
            OneLoginFacade.getAction().go2Login(DIDIApplicationDelegate.getAppContext());
        }

        public void loginout(String str) {
            OneLoginFacade.getAction().activeLogout(DIDIApplicationDelegate.getAppContext(), str);
        }

        public void go2Login() {
            OneLoginFacade.getAction().go2Login(DIDIApplicationDelegate.getAppContext());
        }
    };

    public NationComponentData getNationComponentData() {
        m29010a();
        return this.f38459b;
    }

    public void refreshPushHost() {
        NationComponentData nationComponentData = this.f38459b;
        if (nationComponentData == null) {
            m29010a();
        } else {
            nationComponentData.setPushConfig(m29009a(DIDIApplication.getAppContext()));
        }
    }

    /* renamed from: a */
    private void m29010a() {
        if (this.f38459b == null) {
            this.f38459b = new NationComponentDataDelegate();
            Application appContext = DIDIApplicationDelegate.getAppContext();
            this.f38459b.setPushConfig(m29009a(appContext));
            this.f38459b.setLoginAction(this.f38460c);
            this.f38459b.setOriginID(AppUtils.getMetaDataByKey("origin_id"));
            if (DomainUtil.isSupportDomainSwitch(appContext)) {
                String rebuildHost = DomainUtil.rebuildHost("omgup.didiglobal.com", DomainServiceManager.getInstance().getDomainSuffix(appContext));
                ELog.log("rebuild omega upload host for sdk init with: " + rebuildHost);
                this.f38459b.setOmegaUploadHost(rebuildHost);
            } else {
                this.f38459b.setOmegaUploadHost("omgup.didiglobal.com");
            }
            this.f38459b.setMapTypeString((AnalysisAPK.isGlobalHmsApk(appContext) ? MapType.MATYPE_HMS : MapType.MATYPE_GMAP).getMapTypeString());
            this.f38459b.setMapTypeInt(MapType.MAPTYPE_WGS84.getMapTypeInt());
            this.f38459b.setCoordinateType(MapType.MAPTYPE_WGS84.getMapTypeString());
            this.f38459b.setPlatform_type("2");
            this.f38459b.setTerminal_id(AppUtils.getMetaDataByKey("terminal_id"));
            this.f38459b.setBiz_type("1");
            this.f38459b.setProductPreFix(AppUtils.getMetaDataByKey(EventKeys.APP_SCHEME_PREFIX));
            this.f38459b.setUserAgentPrefix(AppUtils.getMetaDataByKey(EventKeys.USER_AGENT_PREFIX));
            this.f38459b.setBrand(AppUtils.getMetaDataByKey("brand"));
        }
    }

    /* renamed from: a */
    private NationComponentData.PushConfig m29009a(Context context) {
        int i;
        String str;
        NationComponentData.PushConfig pushConfig = new NationComponentData.PushConfig();
        ELog.log("DevModeUtil.getDevEnvironment(context) = " + DevModeUtil.getDevEnvironment(context));
        if (DevModeUtil.getDevEnvironment(context) == DevModeUtil.DevEnvironment.DEBUG) {
            str = DevModePreference.getPushIp(context);
            i = Integer.valueOf(DevModePreference.getPushPort(context)).intValue();
        } else {
            if (DomainUtil.isSupportDomainSwitch(context)) {
                String domainSuffix = DomainServiceManager.getInstance().getDomainSuffix(context);
                str = DomainUtil.rebuildHost(BuildConfig.PUSH_IP, domainSuffix);
                ELog.log("in getPushCfg() suffix = " + domainSuffix);
            } else {
                str = BuildConfig.PUSH_IP;
            }
            i = 25269;
        }
        ELog.log("push_ip: " + str + " &push_port = " + i);
        pushConfig.setIp(str);
        pushConfig.setPort(i);
        return pushConfig;
    }
}
