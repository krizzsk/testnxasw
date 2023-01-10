package com.didi.entrega.customer;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.entrega.customer.app.CustomerActivityManager;
import com.didi.entrega.customer.biz.scheme.SchemeHelper;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.LocationUtil;
import com.didi.entrega.customer.repo.CustomerFragmentInitRepo;
import java.util.Set;

public class SchemeReceiver implements IRouterHandler {

    /* renamed from: a */
    private static final String f21617a = "SchemeReceiver";

    /* renamed from: b */
    private boolean f21618b;

    public void handle(Request request, Result result) {
        Bundle extra = request.getExtra();
        Set<String> keySet = extra.keySet();
        final Uri.Builder buildUpon = request.getUri().buildUpon();
        if (keySet != null && keySet.size() > 0) {
            for (String str : keySet) {
                buildUpon = buildUpon.appendQueryParameter(str, String.valueOf(extra.get(str)));
            }
        }
        CustomerFragmentInitRepo.getInstance().subscribe(new Action1<Boolean>() {
            public void call(Boolean bool) {
                if (bool.booleanValue()) {
                    SchemeReceiver.this.m18072a(buildUpon.build());
                    CustomerFragmentInitRepo.getInstance().remove(this);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18072a(Uri uri) {
        String queryParameter = uri.getQueryParameter("closeSideMenu");
        if (!TextUtils.isEmpty(queryParameter) && "1".equals(queryParameter)) {
            CustomerActivityManager.getInstance().popToRoot();
        }
        LogUtil.m18185i(f21617a, "dispatchBundle = " + this.f21618b);
        if (this.f21618b) {
            SchemeHelper.dispatchMsg(uri, false);
            return;
        }
        this.f21618b = true;
        if (LocationUtil.hasValidLocation()) {
            SchemeHelper.dispatchMsg(uri, false);
        } else {
            LogUtil.m18185i(f21617a, "dispatchBundle subscribeAddress");
        }
    }
}
