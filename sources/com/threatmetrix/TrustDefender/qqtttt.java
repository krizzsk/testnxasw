package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.tqqqqt;
import com.threatmetrix.TrustDefender.tqttqq;
import com.threatmetrix.TrustDefender.yyyyqy;
import java.util.Map;

public class qqtttt extends tqqqqt {
    private static final String bff0066fff = yyyyqy.b0074t007400740074t(tqttqt.class);
    private String b0066f0066fff;

    public qqtttt(long j) {
        super(j);
    }

    public void b007500750075u0075u(Map<String, String> map) {
        if (map != null) {
            map.put(yyyyyq.AGENT_OS_VERSION.b00780078x00780078x(), yqqyqq.b006900690069i00690069(tqttqq.ttttqq.qqqqtq.b006Enn006En006E));
            map.put(yyyyyq.AGENT_SECURITY_PATCH_LEVEL.b00780078x00780078x(), yqqyqq.b006900690069i00690069(tqttqq.ttttqq.qqqqtq.bnn006E006En006E));
            map.put(yyyyyq.AGENT_LANGUAGE.b00780078x00780078x(), yqqyqq.b006900690069i00690069(yqqqyq.b006200620062bbb));
            String b00780078x00780078x = yyyyyq.AGENT_BRAND.b00780078x00780078x();
            map.put(b00780078x00780078x, yqqyqq.b006900690069i00690069(tqttqq.ttttqq.b006Enn006E006En + ", " + tqttqq.ttttqq.b006Ennnn006E));
            map.put(yyyyyq.AGENT_DEVICE.b00780078x00780078x(), yqqyqq.b006900690069i00690069(tqttqq.ttttqq.b006En006E006E006En));
            map.put(yyyyyq.AGENT_MODEL.b00780078x00780078x(), yqqyqq.b006900690069i00690069(tqttqq.ttttqq.bn006E006E006E006En));
            map.put(yyyyyq.AGENT_OS.b00780078x00780078x(), yqqyqq.b006900690069i00690069(yyqyyy.b00710071q0071q0071()));
            map.put(yyyyyq.AGENT_CONF_OS.b00780078x00780078x(), yyqyyy.b007100710071q0071q());
            map.put(yyyyyq.AGENT_TYPE.b00780078x00780078x(), "agent_mobile");
            map.put(yyyyyq.AGENT_VERSION.b00780078x00780078x(), "6.3-80");
            map.put(yyyyyq.AGENT_APP_INFO.b00780078x00780078x(), this.b0066f0066fff);
        }
    }

    public void b0075u0075u0075u(ttqqqt ttqqqt, Map<String, String> map) throws InterruptedException {
        if (ttqqqt.byy0079yyy() != null && this.b0066f0066fff == null) {
            this.b0066f0066fff = yyqyyy.bqqqq0071q(ttqqqt.byy0079yyy());
            String str = bff0066fff;
            yyyyqy.qyyyqy.bt0074tttt(str, "got agent_app_info: " + this.b0066f0066fff);
        }
    }

    public tqqqqt.qtqqqt bu00750075u0075u() {
        return tqqqqt.qtqqqt.COLLECTOR_TYPE_DEVICE;
    }
}
