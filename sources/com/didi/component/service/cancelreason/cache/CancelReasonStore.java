package com.didi.component.service.cancelreason.cache;

import android.content.Context;
import android.util.LruCache;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.common.util.GLog;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.store.BaseStore;
import com.didi.sdk.util.SingletonHolder;
import com.didi.travel.psnger.model.response.CancelReasonInfo;
import com.google.gson.Gson;

public class CancelReasonStore extends BaseStore {

    /* renamed from: d */
    private static final String f17629d = "LID";

    /* renamed from: e */
    private static final String f17630e = "PID";

    /* renamed from: f */
    private static final String f17631f = "DARR";

    /* renamed from: g */
    private static final String f17632g = "CASH";

    /* renamed from: h */
    private static final String f17633h = "V2";

    /* renamed from: a */
    private Context f17634a = DIDIApplication.getAppContext();

    /* renamed from: b */
    private Gson f17635b = new Gson();

    /* renamed from: c */
    private LruCache<String, CancelReasonInfo> f17636c = new LruCache<>(4);

    private CancelReasonStore() {
        super("business-cancelReasonList");
    }

    public static CancelReasonStore getInstance() {
        return (CancelReasonStore) SingletonHolder.getInstance(CancelReasonStore.class);
    }

    /* renamed from: a */
    private CancelReasonInfo m14932a(String str) {
        try {
            CancelReasonInfo cancelReasonInfo = this.f17636c.get(str);
            if (cancelReasonInfo != null) {
                return cancelReasonInfo;
            }
            return (CancelReasonInfo) this.f17635b.fromJson(new String(load(this.f17634a, str).data), CancelReasonInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public CancelReasonInfo getCurrCancelReasonInfo() {
        String a = m14933a();
        GLog.m11354d("CancelReasonStore", "getKey:" + a);
        return m14932a(a);
    }

    public void saveCancelReasonInfo(String str, int i, boolean z, boolean z2, CancelReasonInfo cancelReasonInfo) {
        m14935a(m14934a(str, i, z, z2), cancelReasonInfo);
    }

    /* renamed from: a */
    private void m14935a(String str, CancelReasonInfo cancelReasonInfo) {
        this.f17636c.put(str, cancelReasonInfo);
        save(this.f17634a, str, this.f17635b.toJson((Object) cancelReasonInfo).getBytes());
    }

    public void saveCurrCancelReasonInfo(CancelReasonInfo cancelReasonInfo) {
        String a = m14933a();
        GLog.m11354d("CancelReasonStore", "saveKey:" + a);
        m14935a(a, cancelReasonInfo);
    }

    /* renamed from: a */
    private String m14934a(String str, int i, boolean z, boolean z2) {
        return f17629d + str + f17630e + i + f17631f + z + f17632g + z2 + f17633h;
    }

    /* renamed from: a */
    private String m14933a() {
        if (CarOrderHelper.getOrder() == null) {
            return "";
        }
        return m14934a(NationTypeUtil.getNationComponentData().getLocaleCode(), CarOrderHelper.isCarPoolLineHaveOrder() ? CarOrderHelper.getOrder().comboType : CarOrderHelper.getOrder().productid, CancelTripCache.getInstance().isDriverArrived(), CarOrderHelper.getOrder().payType == 1024);
    }
}
