package com.didi.unifiedPay.component.presenter;

import android.text.TextUtils;
import com.didi.unifiedPay.sdk.model.BasicPayInfo;
import com.didi.unifiedPay.sdk.model.DeductionInfo;
import com.didi.unifiedPay.sdk.model.PayInfo;
import com.didi.unifiedPay.sdk.model.PayStatus;
import java.util.HashMap;

public class PayInfoManager {

    /* renamed from: a */
    private static PayInfoManager f47029a;

    /* renamed from: b */
    private HashMap<String, PayInfo> f47030b = new HashMap<>();

    /* renamed from: c */
    private HashMap<String, BasicPayInfo> f47031c = new HashMap<>();

    /* renamed from: d */
    private HashMap<String, PayStatus> f47032d = new HashMap<>();

    /* renamed from: e */
    private String f47033e;

    private PayInfoManager(String str) {
        this.f47033e = str;
    }

    public static PayInfoManager getInstance(String str) {
        if (f47029a == null) {
            f47029a = new PayInfoManager(str);
        }
        PayInfoManager payInfoManager = f47029a;
        payInfoManager.f47033e = str;
        return payInfoManager;
    }

    public BasicPayInfo getBasicPayInfo(String str) {
        String a = m34995a(str);
        if (!TextUtils.isEmpty(a)) {
            return this.f47031c.get(a);
        }
        return null;
    }

    public void setBasicPayInfo(String str, BasicPayInfo basicPayInfo) {
        String a = m34995a(str);
        if (!TextUtils.isEmpty(a)) {
            this.f47031c.put(a, basicPayInfo);
        }
    }

    public PayStatus getPayStatus(String str) {
        String a = m34995a(str);
        if (!TextUtils.isEmpty(a)) {
            return this.f47032d.get(a);
        }
        return null;
    }

    public void setPayStatus(String str, PayStatus payStatus) {
        String a = m34995a(str);
        if (!TextUtils.isEmpty(a)) {
            this.f47032d.put(a, payStatus);
        }
    }

    public PayInfo getPayInfo(String str) {
        String a = m34995a(str);
        if (!TextUtils.isEmpty(a)) {
            return this.f47030b.get(a);
        }
        return null;
    }

    public void setPayInfo(String str, PayInfo payInfo) {
        String a = m34995a(str);
        if (!TextUtils.isEmpty(a)) {
            this.f47030b.put(a, payInfo);
        }
    }

    public DeductionInfo getVoucherInfo(String str) {
        PayInfo payInfo;
        String a = m34995a(str);
        if (!(TextUtils.isEmpty(a) || (payInfo = this.f47030b.get(a)) == null || payInfo.billDetail == null || payInfo.billDetail.deductions == null)) {
            for (DeductionInfo deductionInfo : payInfo.billDetail.deductions) {
                if (deductionInfo != null && deductionInfo.type == 1) {
                    return deductionInfo;
                }
            }
        }
        return null;
    }

    public void clearData() {
        this.f47030b.clear();
        this.f47031c.clear();
        this.f47032d.clear();
    }

    public void clearPayInfo() {
        this.f47030b.clear();
    }

    /* renamed from: a */
    private String m34995a(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f47033e)) {
            return "";
        }
        return str + this.f47033e;
    }
}
