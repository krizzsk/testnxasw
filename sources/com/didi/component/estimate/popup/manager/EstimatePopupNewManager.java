package com.didi.component.estimate.popup.manager;

import android.content.Context;
import com.didi.component.business.constant.BffConstants;
import com.didi.component.common.util.GLog;
import com.didi.component.estimate.popup.request.EstimateComponentConfigNewRequest;
import com.didi.component.estimate.popup.request.EstimateConfuciusRequest;
import com.didi.component.estimate.popup.request.EstimatePopupRequest;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.nation.NationTypeUtil;
import java.util.ArrayList;
import java.util.List;

public class EstimatePopupNewManager {

    /* renamed from: a */
    private List<EstimatePopupRequest> f15078a;
    protected final Logger mLogger = LoggerFactory.getLogger(getClass());

    public EstimatePopupNewManager() {
        ArrayList arrayList = new ArrayList();
        this.f15078a = arrayList;
        arrayList.add(new EstimateComponentConfigNewRequest());
        this.f15078a.add(new EstimateConfuciusRequest());
    }

    public void doRequest(Context context, String str, int i) {
        if (NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow()) {
            m12388a();
            m12390a(context, str, i);
        }
    }

    /* renamed from: a */
    private void m12390a(Context context, String str, int i) {
        for (EstimatePopupRequest next : this.f15078a) {
            if (next != null) {
                Logger logger = this.mLogger;
                logger.info("@requestByService, class:" + next.getClass().getCanonicalName(), new Object[0]);
                next.requestByService(context, BffConstants.Services.BFF_ESTIMATE_POP_RESULT_SERVICE_NEW, str, i);
            }
        }
    }

    public void doRequest(Context context, int i, int i2, int i3, String str, int i4) {
        if (NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow()) {
            m12388a();
            m12389a(context, i, i2, i3, str, i4);
        }
    }

    /* renamed from: a */
    private void m12389a(Context context, int i, int i2, int i3, String str, int i4) {
        for (EstimatePopupRequest next : this.f15078a) {
            if (next != null) {
                GLog.m11354d("HomePopupManager", "@requestByService, class:" + next.getClass().getCanonicalName());
                next.requestByService(context, BffConstants.Services.BFF_ESTIMATE_POP_RESULT_SERVICE_NEW, i, i2, i3, str, i4);
            }
        }
    }

    /* renamed from: a */
    private void m12388a() {
        for (EstimatePopupRequest next : this.f15078a) {
            if (next != null) {
                Logger logger = this.mLogger;
                logger.info("@cancelRequestByGroup, class:" + next.getClass().getCanonicalName(), new Object[0]);
                next.cancelGroup();
            }
        }
    }
}
