package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.tqqqqt;
import java.util.Map;

public class qyyqqy extends tqqqqt {
    private yqyqqy bp00700070007000700070;

    public qyyqqy(long j) {
        super(j);
    }

    public void b007500750075u0075u(Map<String, String> map) {
        if (map != null && this.bp00700070007000700070 != null) {
            String str = "";
            map.put(yyyyyq.NETWORK_INFO_BSSID.b00780078x00780078x(), this.bp00700070007000700070.bg00670067g00670067() == null ? str : this.bp00700070007000700070.bg00670067g00670067());
            map.put(yyyyyq.NETWORK_INFO_SSID_HASH.b00780078x00780078x(), this.bp00700070007000700070.bgg0067006700670067() == null ? str : yqqyqq.b00690069ii00690069(this.bp00700070007000700070.bgg0067006700670067().getBytes()));
            map.put(yyyyyq.NETWORK_INFO_SSID.b00780078x00780078x(), this.bp00700070007000700070.bgg0067006700670067() == null ? str : this.bp00700070007000700070.bgg0067006700670067());
            map.put(yyyyyq.NETWORK_INFO_RSSI.b00780078x00780078x(), this.bp00700070007000700070.bg0067g006700670067() == null ? str : this.bp00700070007000700070.bg0067g006700670067());
            map.put(yyyyyq.NETWORK_INFO_TYPE.b00780078x00780078x(), this.bp00700070007000700070.b0067g0067006700670067() == null ? str : this.bp00700070007000700070.b0067g0067006700670067());
            map.put(yyyyyq.NETWORK_INFO_IPV4.b00780078x00780078x(), this.bp00700070007000700070.b006700670067g00670067() == null ? str : this.bp00700070007000700070.b006700670067g00670067());
            map.put(yyyyyq.NETWORK_INFO_IPV6.b00780078x00780078x(), this.bp00700070007000700070.bggg006700670067() == null ? str : this.bp00700070007000700070.bggg006700670067());
            map.put(yyyyyq.NETWORK_INFO_MAC.b00780078x00780078x(), this.bp00700070007000700070.b0067gg006700670067() == null ? str : this.bp00700070007000700070.b0067gg006700670067());
            map.put(yyyyyq.NETWORK_INFO_WFS.b00780078x00780078x(), this.bp00700070007000700070.b00670067g006700670067() == null ? str : this.bp00700070007000700070.b00670067g006700670067());
            String b00780078x00780078x = yyyyyq.NETWORK_INFO_VPN.b00780078x00780078x();
            if (this.bp00700070007000700070.bg00670067006700670067() != null) {
                str = this.bp00700070007000700070.bg00670067006700670067();
            }
            map.put(b00780078x00780078x, str);
        }
    }

    public void b0075u0075u0075u(ttqqqt ttqqqt, Map<String, String> map) throws InterruptedException {
        if (ttqqqt.byy0079yyy() != null) {
            this.bp00700070007000700070 = yyqyyy.bq0071q0071q0071(ttqqqt.byy0079yyy());
        }
    }

    public tqqqqt.qtqqqt bu00750075u0075u() {
        return tqqqqt.qtqqqt.COLLECTOR_TYPE_NETWORK;
    }
}
