package com.didi.payment.utilities.scan.collect;

import java.util.HashMap;
import java.util.Map;

public class CollectionModel {

    /* renamed from: a */
    private String f34226a;

    /* renamed from: b */
    private String f34227b;

    /* renamed from: c */
    private int f34228c;

    /* renamed from: d */
    private boolean f34229d;

    /* renamed from: e */
    private boolean f34230e;

    public CollectionModel(String str, String str2, int i, boolean z, boolean z2) {
        this.f34227b = str;
        this.f34226a = str2;
        this.f34228c = i;
        this.f34229d = z;
        this.f34230e = z2;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put(CollectionConstant.EVENT_PARAM_ID, this.f34226a);
        hashMap.put(CollectionConstant.EVENT_PARAM_SEQ, Integer.valueOf(this.f34228c));
        String str = "1";
        hashMap.put(CollectionConstant.EVENT_PARAM_ACTION, this.f34229d ? str : "0");
        if (!this.f34230e) {
            str = "0";
        }
        hashMap.put(CollectionConstant.EVENT_PARAM_VALID, str);
        hashMap.put("data", this.f34227b);
        return hashMap;
    }
}
