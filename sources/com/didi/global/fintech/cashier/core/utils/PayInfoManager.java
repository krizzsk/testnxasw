package com.didi.global.fintech.cashier.core.utils;

import android.text.TextUtils;
import com.didi.global.fintech.cashier.model.net.response.BasicPayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.PayStatusResponse;
import java.util.HashMap;

public class PayInfoManager {

    /* renamed from: a */
    private static PayInfoManager f23358a;

    /* renamed from: b */
    private HashMap<String, PayInfoResponse> f23359b = new HashMap<>();

    /* renamed from: c */
    private HashMap<String, BasicPayInfoResponse> f23360c = new HashMap<>();

    /* renamed from: d */
    private HashMap<String, PayStatusResponse> f23361d = new HashMap<>();

    private PayInfoManager() {
    }

    public static PayInfoManager getInstance() {
        if (f23358a == null) {
            f23358a = new PayInfoManager();
        }
        return f23358a;
    }

    public BasicPayInfoResponse getBasicPayInfo(String str) {
        String a = m19171a(str);
        if (!TextUtils.isEmpty(a)) {
            return this.f23360c.get(a);
        }
        return null;
    }

    public void setBasicPayInfo(String str, BasicPayInfoResponse basicPayInfoResponse) {
        String a = m19171a(str);
        if (!TextUtils.isEmpty(a)) {
            this.f23360c.put(a, basicPayInfoResponse);
        }
    }

    public PayStatusResponse getPayStatus(String str) {
        String a = m19171a(str);
        if (!TextUtils.isEmpty(a)) {
            return this.f23361d.get(a);
        }
        return null;
    }

    public void setPayStatus(String str, PayStatusResponse payStatusResponse) {
        String a = m19171a(str);
        if (!TextUtils.isEmpty(a)) {
            this.f23361d.put(a, payStatusResponse);
        }
    }

    public PayInfoResponse getPayInfo(String str) {
        String a = m19171a(str);
        if (!TextUtils.isEmpty(a)) {
            return this.f23359b.get(a);
        }
        return null;
    }

    public void setPayInfo(String str, PayInfoResponse payInfoResponse) {
        String a = m19171a(str);
        if (!TextUtils.isEmpty(a)) {
            this.f23359b.put(a, payInfoResponse);
        }
    }

    public void removeData(String str) {
        this.f23359b.remove(str);
        this.f23360c.remove(str);
        this.f23361d.remove(str);
    }

    /* renamed from: a */
    private String m19171a(String str) {
        return !TextUtils.isEmpty(str) ? str : "";
    }
}
