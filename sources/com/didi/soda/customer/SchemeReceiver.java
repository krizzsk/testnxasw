package com.didi.soda.customer;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.repo.Action2;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.soda.customer.app.CustomerActivityManager;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.tracker.performance.ConversionOmegaHelper;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import java.util.Set;

public class SchemeReceiver implements IRouterHandler {

    /* renamed from: a */
    private static final String f42855a = "SchemeReceiver";

    /* renamed from: b */
    private boolean f42856b;

    public void handle(Request request, Result result) {
        Bundle extra = request.getExtra();
        Set<String> keySet = extra.keySet();
        Uri.Builder buildUpon = request.getUri().buildUpon();
        if (keySet != null && keySet.size() > 0) {
            for (String str : keySet) {
                buildUpon = buildUpon.appendQueryParameter(str, String.valueOf(extra.get(str)));
            }
        }
        m32044a(buildUpon.build());
    }

    /* renamed from: a */
    private void m32044a(final Uri uri) {
        String queryParameter = uri.getQueryParameter("closeSideMenu");
        if (!TextUtils.isEmpty(queryParameter) && "1".equals(queryParameter)) {
            CustomerActivityManager.getInstance().popToRoot();
        }
        LogUtil.m32588i(f42855a, "dispatchBundle = " + this.f42856b);
        ConversionOmegaHelper.trackTabInByUrl(uri);
        if (this.f42856b) {
            SchemeHelper.dispatchMsg(uri, false);
            return;
        }
        this.f42856b = true;
        if (!LocationUtil.hasValidLocation() || !LocationUtil.hasValidPoi()) {
            LogUtil.m32588i(f42855a, "dispatchBundle subscribeAddress");
            ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).subscribeAddressOnce(new Action2<AddressEntity>() {
                public void call(AddressEntity addressEntity, Subscription subscription) {
                    LogUtil.m32588i(SchemeReceiver.f42855a, "dispatchBundle dispatchMsg url =" + uri);
                    SchemeHelper.dispatchMsg(uri, false);
                }
            });
            return;
        }
        SchemeHelper.dispatchMsg(uri, false);
    }
}
