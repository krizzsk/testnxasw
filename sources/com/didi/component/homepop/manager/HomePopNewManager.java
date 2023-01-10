package com.didi.component.homepop.manager;

import android.app.Activity;
import android.content.Context;
import com.didi.component.business.constant.BffConstants;
import com.didi.component.common.util.GLog;
import com.didi.component.homepop.request.DrainageCoverRequest;
import com.didi.component.homepop.request.GradeRequest;
import com.didi.component.homepop.request.HomeAdAlertRequest;
import com.didi.component.homepop.request.HomeGGKConfigRequest;
import com.didi.component.homepop.request.HomePopupRequest;
import com.didi.component.homepop.request.PublicServiceRequest;
import com.didi.component.homepop.request.RegisterCouponRequest;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import java.util.ArrayList;
import java.util.List;

public class HomePopNewManager {

    /* renamed from: a */
    private List<HomePopupRequest> f15969a;

    public HomePopNewManager() {
        ArrayList arrayList = new ArrayList();
        this.f15969a = arrayList;
        arrayList.add(new PublicServiceRequest());
        this.f15969a.add(new GradeRequest());
        this.f15969a.add(new RegisterCouponRequest());
        this.f15969a.add(new DrainageCoverRequest());
        this.f15969a.add(new HomeGGKConfigRequest());
        this.f15969a.add(new HomeAdAlertRequest());
    }

    public void doRequest(final Context context) {
        if (NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow()) {
            m13262a();
            m13263a(context);
        }
        OneLoginFacade.getFunction().addLoginListener(new LoginListeners.LoginListener() {
            public void onSuccess(Activity activity, String str) {
                HomePopNewManager.this.m13262a();
                HomePopNewManager.this.m13263a(context);
            }

            public void onCancel() {
                GLog.m11354d("HomePopupManager", "login onCancel");
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13263a(Context context) {
        for (HomePopupRequest next : this.f15969a) {
            if (next != null) {
                GLog.m11354d("HomePopupManager", "@requestByService, class:" + next.getClass().getCanonicalName());
                next.requestByService(context, BffConstants.Services.BFF_HOME_POP_RESULT_SERVICE_NEW);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13262a() {
        for (HomePopupRequest next : this.f15969a) {
            if (next != null) {
                GLog.m11354d("HomePopupManager", "@cancelRequestByGroup, class:" + next.getClass().getCanonicalName());
                next.cancelGroup();
            }
        }
    }
}
