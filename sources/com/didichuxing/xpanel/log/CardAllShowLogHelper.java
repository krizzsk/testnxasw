package com.didichuxing.xpanel.log;

import android.text.TextUtils;
import com.didichuxing.xpanel.base.XPanelCardData;
import com.didichuxing.xpanel.util.LogcatUtil;
import com.didichuxing.xpanel.util.XPanelOmegaUtils;
import java.util.Map;

public class CardAllShowLogHelper {

    /* renamed from: a */
    private static final String f52102a = "CardAllShowLogHelper";

    /* renamed from: b */
    private boolean f52103b = false;

    /* renamed from: c */
    private XPanelCardData f52104c;

    public CardAllShowLogHelper(XPanelCardData xPanelCardData) {
        this.f52104c = xPanelCardData;
    }

    public final boolean moveAllIn(Map<String, Object> map) {
        if (this.f52103b) {
            return false;
        }
        this.f52103b = true;
        if (!TextUtils.isEmpty(this.f52104c.f51896id)) {
            XPanelOmegaUtils.trackEvent("xpanel_card_all_sw", this.f52104c.getOmegaParams(map));
            if (this.f52104c.iCardShow != null) {
                this.f52104c.iCardShow.onCardAllShow(map);
            }
            LogcatUtil.m39237d(f52102a, "moveAllIn :  id : " + this.f52104c.f51896id);
        }
        return true;
    }

    public final boolean moveAllOut(Map<String, Object> map) {
        if (!this.f52103b) {
            return false;
        }
        this.f52103b = false;
        return true;
    }

    public boolean isAllInScreen() {
        return this.f52103b;
    }
}
