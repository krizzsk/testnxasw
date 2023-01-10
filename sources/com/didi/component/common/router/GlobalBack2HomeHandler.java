package com.didi.component.common.router;

import android.net.Uri;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.common.util.GLog;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;

public class GlobalBack2HomeHandler implements IRouterHandler {

    /* renamed from: a */
    private String f13546a = GlobalBack2HomeHandler.class.getSimpleName();

    public void handle(Request request, Result result) {
        Uri uri = request.getUri();
        String str = this.f13546a;
        GLog.m11354d(str, "routeHandler uri = " + uri);
        if (uri != null) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Componentization.EVENT_COMPONENTIZATION_BACK_HOME, uri.getQueryParameter("groupType") != null ? uri.getQueryParameter("groupType") : "");
        }
    }
}
