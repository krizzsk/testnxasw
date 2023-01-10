package com.didi.soda.customer.foundation.p164im;

import android.content.Context;
import com.didi.beatles.p101im.module.IMSessionUnreadCallback;
import com.didi.soda.customer.downgrade.CustomerDowngradeHelper;
import com.didi.soda.customer.foundation.log.util.LogUtil;

/* renamed from: com.didi.soda.customer.foundation.im.ImMessageHelper */
public final class ImMessageHelper implements IIMInterface {
    public static final String IM_ROLE_MERCHANT = "merchant";
    public static final String IM_ROLE_RIDER = "rider";

    /* renamed from: a */
    private static ImMessageHelper f43501a;

    /* renamed from: b */
    private static IIMInterface f43502b;

    public static ImMessageHelper getInstance() {
        if (f43501a == null) {
            f43501a = new ImMessageHelper();
            if (CustomerDowngradeHelper.isDowngradeIM()) {
                f43502b = new IMDowngradeImp();
            } else {
                f43502b = new IMDefaultImp();
            }
        }
        return f43501a;
    }

    public void startChatDetailActivity(Context context, String str, String str2, String str3, String str4, int i, String str5, String str6) {
        f43502b.startChatDetailActivity(context, str, str2, str3, str4, i, str5, str6);
    }

    public void startChatActivity(Context context) {
        f43502b.startChatActivity(context);
    }

    public void closeSession(String str, String str2) {
        f43502b.closeSession(str, str2);
    }

    public long getSessionId(String str, String str2) {
        return f43502b.getSessionId(str, str2);
    }

    public void setRiderMessageUnreadCountListener(String str, String str2, IMSessionUnreadCallback iMSessionUnreadCallback) {
        f43502b.setRiderMessageUnreadCountListener(str, str2, iMSessionUnreadCallback);
    }

    public void getUnreadMessageCount(String str, String str2, IMSessionUnreadCallback iMSessionUnreadCallback) {
        f43502b.getUnreadMessageCount(str, str2, iMSessionUnreadCallback);
    }

    public void setMerchantMessageUnreadCountListener(String str, String str2, IMSessionUnreadCallback iMSessionUnreadCallback) {
        f43502b.setMerchantMessageUnreadCountListener(str, str2, iMSessionUnreadCallback);
    }

    public void setRiderCommonWords(Context context) {
        LogUtil.m32588i("ImMessageHelper", "start setRiderCommonWords");
        f43502b.setRiderCommonWords(context);
    }

    public void setMerchantCommonWords(Context context) {
        f43502b.setMerchantCommonWords(context);
    }

    public boolean shouldUseImMessage(String str) {
        return f43502b.shouldUseImMessage(str);
    }

    public void addUserCenterMessageListener() {
        f43502b.addUserCenterMessageListener();
    }

    public void fetchUnReadNum() {
        f43502b.fetchUnReadNum();
    }
}
