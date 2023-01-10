package com.didi.soda.bill;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.p165h5.WebMessage;
import com.didi.soda.customer.p165h5.WebMessageRepo;
import com.didi.soda.customer.repo.RepoFactory;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J9\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010\fJ7\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, mo148868d2 = {"Lcom/didi/soda/bill/BillEventToJS;", "", "()V", "createEvent", "Lorg/json/JSONObject;", "action", "", "errno", "msg", "", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "(ILjava/lang/Integer;Ljava/lang/String;Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;)Lorg/json/JSONObject;", "triggerEvent", "", "(ILjava/lang/Integer;Ljava/lang/String;Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;)V", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BillEventToJS.kt */
public final class BillEventToJS {
    public static final BillEventToJS INSTANCE = new BillEventToJS();

    private BillEventToJS() {
    }

    public static /* synthetic */ void triggerEvent$default(BillEventToJS billEventToJS, int i, Integer num, String str, IEntity iEntity, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        if ((i2 & 8) != 0) {
            iEntity = null;
        }
        billEventToJS.triggerEvent(i, num, str, iEntity);
    }

    public final void triggerEvent(int i, Integer num, String str, IEntity iEntity) {
        try {
            ((WebMessageRepo) RepoFactory.getRepo(WebMessageRepo.class)).dispatch(new WebMessage(1, m31185a(i, num, str, iEntity)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    static /* synthetic */ JSONObject m31186a(BillEventToJS billEventToJS, int i, Integer num, String str, IEntity iEntity, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        if ((i2 & 8) != 0) {
            iEntity = null;
        }
        return billEventToJS.m31185a(i, num, str, iEntity);
    }

    /* renamed from: a */
    private final JSONObject m31185a(int i, Integer num, String str, IEntity iEntity) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", i);
            if (num != null) {
                jSONObject.put("errno", num.intValue());
            }
            if (str != null) {
                jSONObject.put("msg", str);
            }
            if (iEntity != null) {
                jSONObject.put("data", new JSONObject(GsonUtil.toJson(iEntity)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
