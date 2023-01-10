package com.didichuxing.xpanel.log;

import com.didichuxing.xpanel.base.XPanelCardData;
import com.didichuxing.xpanel.util.XPanelOmegaUtils;
import java.util.Map;

public class CardHalfShowLogHelper {

    /* renamed from: a */
    private boolean f52105a = false;

    /* renamed from: b */
    private long f52106b = -1;

    /* renamed from: c */
    private XPanelCardData f52107c;

    public CardHalfShowLogHelper(XPanelCardData xPanelCardData) {
        this.f52107c = xPanelCardData;
    }

    public final boolean moveHalfIn() {
        if (this.f52105a) {
            return false;
        }
        this.f52106b = System.currentTimeMillis();
        this.f52105a = true;
        return true;
    }

    public boolean isCurrentEfficientShow() {
        if (!this.f52105a || System.currentTimeMillis() - this.f52106b < 1000) {
            return false;
        }
        return true;
    }

    public final boolean moveHalfOut(Map<String, Object> map) {
        if (!this.f52105a) {
            return false;
        }
        this.f52105a = false;
        long currentTimeMillis = System.currentTimeMillis() - this.f52106b;
        if (currentTimeMillis < 1000) {
            return false;
        }
        Map<String, Object> omegaParams = this.f52107c.getOmegaParams(map);
        omegaParams.put("time", Long.valueOf(currentTimeMillis));
        XPanelOmegaUtils.trackEvent("xpanel_card_eff_sw", omegaParams);
        return true;
    }
}
