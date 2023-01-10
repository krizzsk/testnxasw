package com.didiglobal.dittoview.view.recyclerview;

import android.text.TextUtils;
import com.didi.soda.compose.card.BaseCard;
import java.util.HashMap;
import java.util.Map;

public class SubCardData {
    public final String TAG = "SubCardData";

    /* renamed from: a */
    private int f52584a;

    /* renamed from: b */
    private String f52585b;

    /* renamed from: c */
    private long f52586c = -1;
    public String cardId;

    /* renamed from: d */
    private boolean f52587d;

    public SubCardData(String str, int i, String str2) {
        this.cardId = str;
        this.f52584a = i;
        this.f52585b = str2;
    }

    public final boolean moveIn() {
        if (TextUtils.isEmpty(this.f52585b) || this.f52587d) {
            return false;
        }
        this.f52586c = System.currentTimeMillis();
        this.f52587d = true;
        m39467a(new HashMap());
        return true;
    }

    public final boolean moveOut() {
        if (TextUtils.isEmpty(this.f52585b) || !this.f52587d) {
            return false;
        }
        this.f52587d = false;
        HashMap hashMap = new HashMap();
        m39467a(hashMap);
        hashMap.put("time", Long.valueOf(System.currentTimeMillis() - this.f52586c));
        return true;
    }

    /* renamed from: a */
    private void m39467a(Map map) {
        map.put("subcard_id", this.f52585b);
        map.put("position", Integer.valueOf(this.f52584a));
        map.put(BaseCard.KEY_CARD_ID, this.cardId);
    }
}
