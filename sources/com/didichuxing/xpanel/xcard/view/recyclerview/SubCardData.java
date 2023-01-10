package com.didichuxing.xpanel.xcard.view.recyclerview;

import android.text.TextUtils;
import com.didi.soda.compose.card.BaseCard;
import com.didichuxing.xpanel.util.XPanelOmegaUtils;
import java.util.HashMap;
import java.util.Map;

public class SubCardData {
    public final String TAG = "SubCardData";

    /* renamed from: a */
    private int f52292a;

    /* renamed from: b */
    private String f52293b;

    /* renamed from: c */
    private long f52294c = -1;
    public String cardId;

    /* renamed from: d */
    private boolean f52295d;

    public SubCardData(String str, int i, String str2) {
        this.cardId = str;
        this.f52292a = i;
        this.f52293b = str2;
    }

    public final boolean moveIn() {
        if (TextUtils.isEmpty(this.f52293b) || this.f52295d) {
            return false;
        }
        this.f52294c = System.currentTimeMillis();
        this.f52295d = true;
        HashMap hashMap = new HashMap();
        m39328a(hashMap);
        XPanelOmegaUtils.trackEvent("xpanel_subcard_sw", hashMap);
        return true;
    }

    public final boolean moveOut() {
        if (TextUtils.isEmpty(this.f52293b) || !this.f52295d) {
            return false;
        }
        this.f52295d = false;
        HashMap hashMap = new HashMap();
        m39328a(hashMap);
        hashMap.put("time", Long.valueOf(System.currentTimeMillis() - this.f52294c));
        XPanelOmegaUtils.trackEvent("xpanel_subcard_sw_time", hashMap);
        return true;
    }

    /* renamed from: a */
    private void m39328a(Map map) {
        map.put("subcard_id", this.f52293b);
        map.put("position", Integer.valueOf(this.f52292a));
        map.put(BaseCard.KEY_CARD_ID, this.cardId);
    }
}
