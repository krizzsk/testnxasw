package com.didi.globalsafetoolkit.store;

import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.globalsafetoolkit.apollo.SfApolloUtil;
import com.didi.globalsafetoolkit.business.contacts.model.SfContactsManageModel;
import com.didi.globalsafetoolkit.business.contacts.request.SfSyncContactRequest;
import com.didi.globalsafetoolkit.net.SfHttpManager;
import com.didi.globalsafetoolkit.net.SfResponseListener;
import com.didi.globalsafetoolkit.net.SfRpcCallback;
import com.didi.globalsafetoolkit.util.SfContextHelper;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;

public class SfContactsRequestBiz {
    public static void getTrustedContacts(SfResponseListener<SfContactsManageModel> sfResponseListener) {
        SfSyncContactRequest sfSyncContactRequest = new SfSyncContactRequest();
        sfSyncContactRequest.type = 1;
        if (SfApolloUtil.isNewSyncContactInterface()) {
            m20141a(sfSyncContactRequest, sfResponseListener);
        } else {
            SfHttpManager.getInstance(SfContextHelper.getContext()).performRequest(sfSyncContactRequest, new SfRpcCallback<SfContactsManageModel>(sfResponseListener) {
            });
        }
    }

    public static void addContact(String str, SfResponseListener<SfContactsManageModel> sfResponseListener) {
        SfSyncContactRequest sfSyncContactRequest = new SfSyncContactRequest();
        sfSyncContactRequest.nameAndPhones = str;
        sfSyncContactRequest.type = 0;
        if (SfApolloUtil.isNewSyncContactInterface()) {
            m20141a(sfSyncContactRequest, sfResponseListener);
        } else {
            SfHttpManager.getInstance(SfContextHelper.getContext()).performRequest(sfSyncContactRequest, new SfRpcCallback<SfContactsManageModel>(sfResponseListener) {
            });
        }
    }

    public static void updateContact(String str, SfResponseListener<SfContactsManageModel> sfResponseListener) {
        SfSyncContactRequest sfSyncContactRequest = new SfSyncContactRequest();
        sfSyncContactRequest.nameAndPhones = str;
        sfSyncContactRequest.type = 3;
        if (SfApolloUtil.isNewSyncContactInterface()) {
            m20141a(sfSyncContactRequest, sfResponseListener);
        } else {
            SfHttpManager.getInstance(SfContextHelper.getContext()).performRequest(sfSyncContactRequest, new SfRpcCallback<SfContactsManageModel>(sfResponseListener) {
            });
        }
    }

    public static void deleteContact(String str, SfResponseListener<SfContactsManageModel> sfResponseListener) {
        SfSyncContactRequest sfSyncContactRequest = new SfSyncContactRequest();
        sfSyncContactRequest.nameAndPhones = str;
        sfSyncContactRequest.type = 2;
        if (SfApolloUtil.isNewSyncContactInterface()) {
            m20141a(sfSyncContactRequest, sfResponseListener);
        } else {
            SfHttpManager.getInstance(SfContextHelper.getContext()).performRequest(sfSyncContactRequest, new SfRpcCallback<SfContactsManageModel>(sfResponseListener) {
            });
        }
    }

    /* renamed from: a */
    private static void m20141a(SfSyncContactRequest sfSyncContactRequest, final SfResponseListener<SfContactsManageModel> sfResponseListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(sfSyncContactRequest.type));
        hashMap.put("params", sfSyncContactRequest.nameAndPhones);
        Bff.call(new IBffProxy.Ability.Builder(SfContextHelper.getContext(), "ibt-sec-heimdallr/passengerContact").setParams(hashMap).setCallback(new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                sfResponseListener.onSuccess((SfContactsManageModel) new Gson().fromJson(jsonObject.toString(), SfContactsManageModel.class));
            }

            public void onFailure(IOException iOException) {
                sfResponseListener.onFail(-1, iOException.getMessage());
            }
        }).build());
    }
}
