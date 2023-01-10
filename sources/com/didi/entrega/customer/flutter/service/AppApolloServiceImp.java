package com.didi.entrega.customer.flutter.service;

import android.text.TextUtils;
import com.didi.foundation.sdk.log.LogService;
import com.didi.rlab.uni_foundation.apollo.ApolloService;
import com.didi.rlab.uni_foundation.apollo.model.ApolloModel;
import com.didi.sdk.logging.Logger;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.google.gson.Gson;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class AppApolloServiceImp implements ApolloService {

    /* renamed from: a */
    private final Logger f21753a = LogService.getLogger("AppApolloServiceImpl");

    public ApolloModel fetchApolloData(String str) {
        return m18151a(str);
    }

    /* renamed from: a */
    private ApolloModel m18151a(String str) {
        JSONObject jsonObject;
        ApolloModel apolloModel = new ApolloModel();
        IToggle toggle = Apollo.getToggle(str, false);
        apolloModel.setEnable(toggle.allow());
        Logger logger = this.f21753a;
        logger.debug("get toggle allow : " + toggle.allow(), new Object[0]);
        if (toggle.allow() && (jsonObject = toggle.getExperiment().toJsonObject()) != null) {
            try {
                JSONObject jSONObject = jsonObject.getJSONObject("params");
                if (jSONObject != null && !TextUtils.isEmpty(jSONObject.toString())) {
                    Logger logger2 = this.f21753a;
                    logger2.debug("get toggle allow params : " + jSONObject.toString(), new Object[0]);
                    apolloModel.setData((HashMap) new Gson().fromJson(jSONObject.toString(), HashMap.class));
                }
            } catch (JSONException e) {
                Logger logger3 = this.f21753a;
                logger3.debug("get toggle exception : " + e.getMessage(), new Object[0]);
            }
        }
        return apolloModel;
    }
}
