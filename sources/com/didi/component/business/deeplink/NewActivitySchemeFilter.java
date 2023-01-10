package com.didi.component.business.deeplink;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.deeplink.jumpstrategy.DeepLinkManage;
import com.didi.component.business.event.ActivityDeepLinkEvent;
import com.didi.component.business.event.BaseDeepLinkEvent;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.DidiLoadDexActivity;
import com.didi.sdk.app.SchemeDispatcher;
import com.didi.sdk.app.scheme.AbsSchemeDispatcherFilter;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({AbsSchemeDispatcherFilter.class})
public class NewActivitySchemeFilter extends AbsSchemeDispatcherFilter {

    /* renamed from: a */
    private static DeepLinkManage f13134a = new DeepLinkManage();

    public boolean doFilter(Intent intent, SchemeDispatcher schemeDispatcher) {
        Uri data = intent.getData();
        if (data == null || !f13134a.filterHost(data.getHost()) || !f13134a.filterPath(data.getPath())) {
            return false;
        }
        if (m11012a()) {
            handleScheme(schemeDispatcher, data);
        } else {
            m11011a(BaseEventKeys.Service.DeepLink.EVENT_HAND_DEEP_LINK, new ActivityDeepLinkEvent(data));
            m11010a(schemeDispatcher);
        }
        schemeDispatcher.finish();
        return true;
    }

    /* renamed from: a */
    private void m11011a(String str, BaseDeepLinkEvent baseDeepLinkEvent) {
        if (!TextUtils.isEmpty(str)) {
            BaseEventPublisher.getPublisher().removeStickyEvent(str);
            BaseEventPublisher.getPublisher().publishSticky(str, baseDeepLinkEvent);
        }
    }

    /* renamed from: a */
    private boolean m11012a() {
        return ActivityLifecycleManager.getInstance().isMainActivityRunning();
    }

    /* renamed from: a */
    private void m11010a(SchemeDispatcher schemeDispatcher) {
        if (!m11012a()) {
            schemeDispatcher.startActivity(new Intent(schemeDispatcher, DidiLoadDexActivity.class));
            schemeDispatcher.finish();
        }
    }

    public static void handleScheme(Activity activity, Uri uri) {
        f13134a.query(uri.getPath()).deepLink(activity, uri);
    }
}
