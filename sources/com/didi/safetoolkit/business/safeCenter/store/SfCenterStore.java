package com.didi.safetoolkit.business.safeCenter.store;

import com.didi.safetoolkit.business.safeCenter.model.SfCenterCardModel;
import com.didi.safetoolkit.business.safeCenter.request.SfSafeCenterRequest;
import com.didi.safetoolkit.business.safeCenter.response.SfSafetyCenterResponse;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.net.ISfRpcRequestParamListener;
import com.didi.safetoolkit.net.SfHttpManager;
import com.didi.safetoolkit.net.SfResponseListener;
import com.didi.safetoolkit.net.SfRpcCallback;
import com.didi.safetoolkit.util.SfContextHelper;
import com.didi.safetoolkit.util.SfLog;
import com.didi.safetoolkit.util.SfStringGetter;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class SfCenterStore {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public List<SfCenterCardModel> f37177a;

    public interface Callback {
        void onFailed(SfSafetyCenterResponse sfSafetyCenterResponse);

        void onSuccess(List<SfCenterCardModel> list);
    }

    public void request(final Callback callback) {
        SfSafeCenterRequest sfSafeCenterRequest = new SfSafeCenterRequest();
        sfSafeCenterRequest.vamosDriver = SafeToolKit.getIns().isVamosDriver() ? 1 : 0;
        ISfRpcRequestParamListener requestParamListener = SafeToolKit.getIns().getRequestParamListener();
        if (requestParamListener != null) {
            sfSafeCenterRequest.token = (String) requestParamListener.getParam("safetyCenter", "token");
            sfSafeCenterRequest.lang = (String) requestParamListener.getParam("safetyCenter", "lang");
            sfSafeCenterRequest.originId = (String) requestParamListener.getParam("safetyCenter", "origin_id");
        }
        SfHttpManager.getInstance(SfContextHelper.getContext()).performRequest(sfSafeCenterRequest, new SfRpcCallback<SfSafetyCenterResponse>(new SfResponseListener<SfSafetyCenterResponse>() {
            public void onSuccess(SfSafetyCenterResponse sfSafetyCenterResponse) {
                if (sfSafetyCenterResponse.data == null) {
                    SfLog.m28132e("safety center data is null!");
                    callback.onFailed((SfSafetyCenterResponse) null);
                    return;
                }
                SfSafetyCenterResponse.SfSafetyCenterData sfSafetyCenterData = sfSafetyCenterResponse.data;
                if (sfSafetyCenterData.safetyContent == null) {
                    List unused = SfCenterStore.this.f37177a = new ArrayList();
                } else {
                    List unused2 = SfCenterStore.this.f37177a = sfSafetyCenterData.safetyContent;
                }
                SfCenterStore sfCenterStore = SfCenterStore.this;
                List a = sfCenterStore.f37177a;
                boolean z = true;
                if (sfSafetyCenterData.showAdd != 1) {
                    z = false;
                }
                sfCenterStore.m28064a((List<SfCenterCardModel>) a, z);
                callback.onSuccess(SfCenterStore.this.f37177a);
            }

            public void onError(SfSafetyCenterResponse sfSafetyCenterResponse) {
                callback.onFailed(sfSafetyCenterResponse);
            }
        }) {
        });
    }

    public void getLocalData(Callback callback) {
        ArrayList arrayList = new ArrayList();
        m28064a((List<SfCenterCardModel>) arrayList, false);
        callback.onSuccess(arrayList);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28064a(List<SfCenterCardModel> list, boolean z) {
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
        return this.f37177a;
    }
}
