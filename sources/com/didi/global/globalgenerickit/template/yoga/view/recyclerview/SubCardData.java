package com.didi.global.globalgenerickit.template.yoga.view.recyclerview;

import android.text.TextUtils;
import com.didi.soda.compose.card.BaseCard;
import java.util.HashMap;
import java.util.Map;

public class SubCardData {
    public final String TAG = "SubCardData";

    /* renamed from: a */
    private int f24245a;

    /* renamed from: b */
    private String f24246b;

    /* renamed from: c */
    private long f24247c = -1;
    public String cardId;

    /* renamed from: d */
    private boolean f24248d;

    public SubCardData(String str, int i, String str2) {
        this.cardId = str;
        this.f24245a = i;
        this.f24246b = str2;
    }

    public final boolean moveIn() {
        if (TextUtils.isEmpty(this.f24246b) || this.f24248d) {
            return false;
        }
        this.f24247c = System.currentTimeMillis();
        this.f24248d = true;
        m19530a(new HashMap());
        return true;
    }

    public final boolean moveOut() {
        if (TextUtils.isEmpty(this.f24246b) || !this.f24248d) {
            return false;
        }
        this.f24248d = false;
        HashMap hashMap = new HashMap();
        m19530a(hashMap);
        hashMap.put("time", Long.valueOf(System.currentTimeMillis() - this.f24247c));
        return true;
    }

    /* renamed from: a */
    private void m19530a(Map map) {
        map.put("subcard_id", this.f24246b);
        map.put("position", Integer.valueOf(this.f24245a));
        map.put(BaseCard.KEY_CARD_ID, this.cardId);
    }
}
