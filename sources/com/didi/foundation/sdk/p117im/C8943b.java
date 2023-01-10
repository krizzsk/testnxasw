package com.didi.foundation.sdk.p117im;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.didi.beatles.p101im.access.IMContext;
import com.didi.beatles.p101im.api.url.IMApiUrlGlobal;
import com.didi.beatles.p101im.api.url.IMBaseUrl;
import com.didi.foundation.sdk.log.LogService;
import com.didi.foundation.sdk.login.LoginService;
import com.didi.foundation.sdk.login.LoginServiceProvider;
import com.didi.sdk.logging.Logger;
import java.util.ArrayList;
import java.util.Locale;

/* renamed from: com.didi.foundation.sdk.im.b */
/* compiled from: FoundationIMContext */
class C8943b extends IMContext {

    /* renamed from: a */
    private Logger f23038a = LogService.getLogger("FoundationIMContext");

    /* renamed from: b */
    private final Application f23039b;

    /* renamed from: c */
    private final IMContextProvider f23040c;

    /* renamed from: d */
    private LoginServiceProvider f23041d = LoginService.getInstance();

    public String getCurrenLoginUser() {
        return null;
    }

    public boolean getIMBottomConfig(int i) {
        return false;
    }

    public Uri getNotificationSoundUri() {
        return null;
    }

    C8943b(Application application, IMContextProvider iMContextProvider) {
        this.f23039b = application;
        this.f23040c = iMContextProvider;
    }

    public long getUid() {
        try {
            return Long.parseLong(this.f23041d.getUid());
        } catch (NumberFormatException e) {
            Logger logger = this.f23038a;
            logger.error("getUid error: " + e, new Object[0]);
            return 0;
        }
    }

    public String getToken() {
        return this.f23041d.getToken();
    }

    public boolean isLoginNow() {
        return this.f23041d.isLogin();
    }

    public String getDeviceId() {
        return this.f23040c.getDeviceId();
    }

    public String getVersionName() {
        return this.f23040c.getVersionName();
    }

    public Class<?> getAppMainClass() {
        return this.f23040c.getAppMainClass();
    }

    public boolean isMainActivityAlive() {
        return this.f23040c.isMainActivityAlive();
    }

    public ArrayList<String> getQuickReplyList(int i) {
        return this.f23040c.getQuickReplyList(i);
    }

    public IMBaseUrl getIMUrlDelegate() {
        return new IMApiUrlGlobal();
    }

    public String getWebActivityScheme() {
        return this.f23040c.getWebActivityScheme();
    }

    public int getAppChannel() {
        return this.f23040c.getAppChannel();
    }

    public int getActivityTheme() {
        return this.f23040c.getActivityTheme();
    }

    public boolean isPad() {
        return this.f23040c.isPad();
    }

    public Locale getLocale() {
        return this.f23040c.getLocale();
    }

    public boolean handLink(Context context, String str) {
        return this.f23040c.handleLink(context, str);
    }

    public boolean isMoveInnerStorage() {
        return this.f23040c.isMoveInnerStorage();
    }

    public String locationTopScheme() {
        return this.f23040c.locationTopScheme();
    }

    public boolean useDecorFloatStyle() {
        return this.f23040c.useDecorFloatStyle();
    }
}
