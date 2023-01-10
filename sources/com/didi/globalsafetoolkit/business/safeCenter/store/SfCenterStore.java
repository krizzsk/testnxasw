package com.didi.globalsafetoolkit.business.safeCenter.store;

import com.didi.globalsafetoolkit.business.safeCenter.model.SfCenterCardModel;
import com.didi.globalsafetoolkit.business.safeCenter.request.SfSafeCenterRequest;
import com.didi.globalsafetoolkit.business.safeCenter.response.SfSafetyCenterResponse;
import com.didi.globalsafetoolkit.business.sdk.GlobalSafeToolKit;
import com.didi.globalsafetoolkit.net.ISfRpcRequestParamListener;
import com.didi.globalsafetoolkit.net.SfHttpManager;
import com.didi.globalsafetoolkit.net.SfResponseListener;
import com.didi.globalsafetoolkit.net.SfRpcCallback;
import com.didi.globalsafetoolkit.util.SfContextHelper;
import com.didi.globalsafetoolkit.util.SfLog;
import com.didi.globalsafetoolkit.util.SfStringGetter;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class SfCenterStore {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public List<SfCenterCardModel> f25081a;

    public interface Callback {
        void onFailed(SfSafetyCenterResponse sfSafetyCenterResponse);

        void onSuccess(List<SfCenterCardModel> list);
    }

    public void request(final Callback callback) {
        SfSafeCenterRequest sfSafeCenterRequest = new SfSafeCenterRequest();
        sfSafeCenterRequest.vamosDriver = 0;
        ISfRpcRequestParamListener requestParamListener = GlobalSafeToolKit.getIns().getRequestParamListener();
        if (requestParamListener != null) {
            sfSafeCenterRequest.token = (String) requestParamListener.getParam("safetyCenter", "token");
            sfSafeCenterRequest.lang = (String) requestParamListener.getParam("safetyCenter", "lang");
            sfSafeCenterRequest.originId = (String) requestParamListener.getParam("safetyCenter", "origin_id");
        }
        SfHttpManager.getInstance(SfContextHelper.getContext()).performRequest(sfSafeCenterRequest, new SfRpcCallback<SfSafetyCenterResponse>(new SfResponseListener<SfSafetyCenterResponse>() {
            public void onSuccess(SfSafetyCenterResponse sfSafetyCenterResponse) {
                if (sfSafetyCenterResponse.data == null) {
                    SfLog.m20146e("safety center data is null!");
                    callback.onFailed((SfSafetyCenterResponse) null);
                    return;
                }
                SfSafetyCenterResponse.SfSafetyCenterData sfSafetyCenterData = sfSafetyCenterResponse.data;
                if (sfSafetyCenterData.safetyContent == null) {
                    List unused = SfCenterStore.this.f25081a = new ArrayList();
                } else {
                    List unused2 = SfCenterStore.this.f25081a = sfSafetyCenterData.safetyContent;
                }
                SfCenterStore sfCenterStore = SfCenterStore.this;
                List a = sfCenterStore.f25081a;
                boolean z = true;
                if (sfSafetyCenterData.showAdd != 1) {
                    z = false;
                }
                sfCenterStore.m20083a((List<SfCenterCardModel>) a, z);
                callback.onSuccess(SfCenterStore.this.f25081a);
            }

            public void onError(SfSafetyCenterResponse sfSafetyCenterResponse) {
                callback.onFailed(sfSafetyCenterResponse);
            }
        }) {
        });
    }

    public void getLocalData(Callback callback) {
        ArrayList arrayList = new ArrayList();
        m20083a((List<SfCenterCardModel>) arrayList, false);
        callback.onSuccess(arrayList);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20083a(List<SfCenterCardModel> list, boolean z) {
        SfCenterCardModel sfCenterCardModel = new SfCenterCardModel();
        sfCenterCardModel.typeLocal = 2;
        sfCenterCardModel.title = SfStringGetter.getString(R.string.sf_trusted_contacts_title);
        sfCenterCardModel.content = SfStringGetter.getString(R.string.sf_safety_center_share_trip);
        if (z) {
            sfCenterCardModel.btnText = SfStringGetter.getString(R.string.sf_add);
        }
        list.add(0, sfCenterCardModel);
    }

    public List<SfCenterCardModel> getData() {
        return this.f25081a;
    }
}
