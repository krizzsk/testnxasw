package com.didi.travel.psnger.common.net.host;

import com.didi.travel.psnger.IHostConfig;
import com.didi.travel.psnger.utils.TextUtil;

public class HostGroupManager {

    /* renamed from: g */
    private static HostGroupManager f46714g;

    /* renamed from: a */
    private String f46715a;

    /* renamed from: b */
    private String f46716b;

    /* renamed from: c */
    private String f46717c;

    /* renamed from: d */
    private String f46718d;

    /* renamed from: e */
    private String f46719e;

    /* renamed from: f */
    private String f46720f;

    private HostGroupManager() {
        initDefaultHost();
    }

    public static HostGroupManager getInstance() {
        if (f46714g == null) {
            synchronized (HostGroupManager.class) {
                if (f46714g == null) {
                    f46714g = new HostGroupManager();
                }
            }
        }
        return f46714g;
    }

    public void initDefaultHost() {
        this.f46715a = "https://api.didiglobal.com/";
        this.f46716b = "https://api.didiglobal.com/";
        this.f46717c = "https://common.didiglobal.com/";
        this.f46718d = "https://api.didiglobal.com/";
        this.f46719e = "https://common.didiglobal.com/";
        this.f46720f = "https://esapi.didiglobal.com/";
    }

    public void configTargetHostGroup(IHostConfig iHostConfig) {
        initDefaultHost();
        if (iHostConfig != null) {
            String businessHost = iHostConfig.businessHost();
            if (!TextUtil.isEmpty(businessHost)) {
                this.f46715a = businessHost;
            }
            String evaluateHost = iHostConfig.evaluateHost();
            if (!TextUtil.isEmpty(evaluateHost)) {
                this.f46716b = evaluateHost;
            }
            String activityHost = iHostConfig.activityHost();
            if (!TextUtil.isEmpty(activityHost)) {
                this.f46718d = activityHost;
            }
            String carSlidingHost = iHostConfig.carSlidingHost();
            if (!TextUtil.isEmpty(carSlidingHost)) {
                this.f46717c = carSlidingHost;
            }
            String routeTrackHost = iHostConfig.routeTrackHost();
            if (!TextUtil.isEmpty(routeTrackHost)) {
                this.f46719e = routeTrackHost;
            }
            String enterprisePayHost = iHostConfig.enterprisePayHost();
            if (!TextUtil.isEmpty(enterprisePayHost)) {
                this.f46720f = enterprisePayHost;
            }
        }
    }

    public String getDiDiBizHost() {
        return this.f46715a;
    }

    public String getDiDiEvaluateHost() {
        return this.f46716b;
    }

    public String getDiDiCarslidingHost() {
        return this.f46717c;
    }

    public String getDiDiResourcesHost() {
        return this.f46718d;
    }

    public String getDiDiRouteTrackHost() {
        return this.f46719e;
    }

    public String getDiDiPayEnterpriseHost() {
        return this.f46720f;
    }
}
