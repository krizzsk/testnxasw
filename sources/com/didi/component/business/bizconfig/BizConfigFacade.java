package com.didi.component.business.bizconfig;

import android.content.Context;
import android.text.TextUtils;
import com.didi.component.business.bizconfig.BizConfigServerParams;
import com.didi.component.business.bizconfig.store.BizConfigModel;
import com.didi.component.business.bizconfig.store.BizConfigStore;
import com.didi.component.business.constant.HostConstants;
import com.didi.component.business.util.BusinessUtils;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.common.util.GLog;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.common.DDRpcServiceHelper;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.model.CarGrop;
import com.didi.sdk.misconfig.model.CarInfo;
import com.didi.sdk.misconfig.p154v2.ConfProxy;
import com.didi.sdk.util.SingletonHolder;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@Deprecated
public class BizConfigFacade {

    /* renamed from: a */
    private Context f13004a = DIDIApplication.getAppContext();

    /* renamed from: b */
    private BizConfigStore f13005b = BizConfigStore.getInstance();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Logger f13006c = LoggerFactory.getLogger(getClass());

    private BizConfigFacade() {
    }

    public static BizConfigFacade getInstance() {
        return (BizConfigFacade) SingletonHolder.getInstance(BizConfigFacade.class);
    }

    public String getBizConfigServicePhone(CarOrder carOrder, String str) {
        CarOrder order;
        if (GlobalApolloUtil.isBffStageNewFifth() && (order = CarOrderHelper.getOrder()) != null) {
            return order.servicePhone;
        }
        if (carOrder == null) {
            return str;
        }
        return getBizConfigServicePhone(carOrder.productid + "", str);
    }

    public String getBizConfigServicePhone(String str, String str2) {
        BizConfigModel a = m10981a(str);
        return (a == null || TextUtils.isEmpty(a.getServicePhone())) ? str2 : a.getServicePhone();
    }

    public void sendRequest(BusinessContext businessContext) {
        GLog.m11353d("bizconfig sendRequest businessContext");
        if (businessContext != null) {
            sendRequest(ConfProxy.getInstance().getGroupByType(businessContext.getBusinessGroupType()));
        }
    }

    public void sendRequest(CarGrop carGrop) {
        GLog.m11353d("bizconfig sendRequest CarGrop list " + carGrop);
        HashSet<String> hashSet = new HashSet<>();
        if (!(carGrop == null || carGrop.getCarInfo() == null || carGrop.getCarInfo().size() <= 0)) {
            for (CarInfo next : carGrop.getCarInfo()) {
                if (next != null) {
                    hashSet.add(next.getBusinessNumId() + "");
                }
            }
        }
        GLog.m11353d("sendRequest keySet " + hashSet);
        if (hashSet.size() > 0) {
            HashMap hashMap = new HashMap();
            for (String str : hashSet) {
                hashMap.put(str, Integer.valueOf(m10989b(str)));
            }
            m10986a((Map<String, Integer>) hashMap);
        }
    }

    public void sendRequest(String str) {
        GLog.m11353d("bizconfig sendRequest bid " + str);
        HashMap hashMap = new HashMap();
        hashMap.put(str, Integer.valueOf(m10989b(str)));
        m10986a((Map<String, Integer>) hashMap);
    }

    public void doubleCheckBizConfig(BusinessContext businessContext, String str) {
        GLog.m11353d("doubleCheckBizConfig bid" + str);
        if (((businessContext == null || str == null || !m10988a(businessContext, str)) ? null : getInstance().m10981a(str)) == null) {
            getInstance().sendRequest(str);
        }
    }

    /* renamed from: a */
    private void m10986a(final Map<String, Integer> map) {
        if (!GlobalApolloUtil.isBffStageNewFifth() && map != null && !map.isEmpty()) {
            this.f13006c.info("bizconfig really sendRequest map", new Object[0]);
            ((BizConfigServerParams.BizConfigService) DDRpcServiceHelper.getRpcServiceFactory().newRpcService(BizConfigServerParams.BizConfigService.class, HostConstants.getHostApi())).getBizConfig(BizConfigServerParams.createParams(this.f13004a, map), new RpcService.Callback<String>() {
                public void onFailure(IOException iOException) {
                    Logger a = BizConfigFacade.this.f13006c;
                    a.info("onFailure :" + iOException, new Object[0]);
                }

                public void onSuccess(String str) {
                    Logger a = BizConfigFacade.this.f13006c;
                    a.info("onSuccess :" + str, new Object[0]);
                    BizConfigFacade.this.m10987a((Map<String, Integer>) map, str);
                }
            });
        }
    }

    /* renamed from: a */
    private BizConfigModel m10981a(String str) {
        return this.f13005b.getBizConfigModel(str);
    }

    /* renamed from: a */
    private boolean m10988a(BusinessContext businessContext, String str) {
        List<CarInfo> confCarInfoList;
        GLog.m11353d("sendRequest");
        if (str == null || businessContext == null || (confCarInfoList = BusinessUtils.getConfCarInfoList(businessContext.getBusinessGroupType())) == null || confCarInfoList.size() <= 0) {
            return false;
        }
        for (CarInfo next : confCarInfoList) {
            if (next != null) {
                if (str.equals(next.getBusinessNumId() + "")) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10987a(Map<String, Integer> map, String str) {
        JSONObject optJSONObject;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (map != null && jSONObject.optInt("errno") == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("0");
                for (Map.Entry next : map.entrySet()) {
                    JSONObject a = m10983a(optJSONObject2, optJSONObject.optJSONObject((String) next.getKey()));
                    GLog.m11353d("BizConfigModel bizStroe :" + ((String) next.getKey()) + ":" + next.getValue() + ":" + a);
                    m10985a((String) next.getKey(), ((Integer) next.getValue()).intValue(), a);
                }
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private JSONObject m10983a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            jSONObject2.keys();
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                try {
                    String next = keys.next();
                    jSONObject.put(next, jSONObject2.get(next));
                } catch (Exception e) {
                    Logger logger = this.f13006c;
                    logger.info("BizConfigFacade error:" + e.getMessage(), new Object[0]);
                }
            }
            return jSONObject;
        } else if (jSONObject2 != null) {
            return jSONObject2;
        } else {
            return null;
        }
    }

    /* renamed from: a */
    private void m10985a(String str, int i, JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.optInt("version") != i) {
            this.f13005b.saveBizConfigModel(str, BizConfigModel.parseFromJSON(str, jSONObject), jSONObject);
        }
    }

    /* renamed from: b */
    private int m10989b(String str) {
        BizConfigModel bizConfigModel = this.f13005b.getBizConfigModel(str);
        if (bizConfigModel == null) {
            return -1;
        }
        GLog.m11353d("getBidVersion model:" + bizConfigModel);
        return bizConfigModel.getVersion();
    }
}
