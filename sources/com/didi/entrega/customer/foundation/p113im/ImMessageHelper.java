package com.didi.entrega.customer.foundation.p113im;

import android.content.Context;
import com.didi.beatles.p101im.module.IMSessionUnreadCallback;

/* renamed from: com.didi.entrega.customer.foundation.im.ImMessageHelper */
public final class ImMessageHelper implements IIMInterface {
    public static final String IM_ROLE_MERCHANT = "merchant";
    public static final String IM_ROLE_RIDER = "rider";

    /* renamed from: a */
    private static ImMessageHelper f21758a;

    /* renamed from: b */
    private static IIMInterface f21759b;

    public static ImMessageHelper getInstance() {
        if (f21758a == null) {
            f21758a = new ImMessageHelper();
            f21759b = new IMDefaultImp();
        }
        return f21758a;
    }

    public void startChatDetailActivity(Context context, String str, String str2, String str3, String str4, int i, String str5, String str6) {
        f21759b.startChatDetailActivity(context, str, str2, str3, str4, i, str5, str6);
    }

    public void startChatActivity(Context context) {
        f21759b.startChatActivity(context);
    }

    public void closeSession(String str, String str2) {
        f21759b.closeSession(str, str2);
    }

    public long getSessionId(String str, String str2) {
        return f21759b.getSessionId(str, str2);
    }

    public void setRiderMessageUnreadCountListener(String str, String str2, IMSessionUnreadCallback iMSessionUnreadCallback) {
        f21759b.setRiderMessageUnreadCountListener(str, str2, iMSessionUnreadCallback);
    }

    public void getUnreadMessageCount(String str, String str2, IMSessionUnreadCallback iMSessionUnreadCallback) {
        f21759b.getUnreadMessageCount(str, str2, iMSessionUnreadCallback);
    }

    public void setMerchantMessageUnreadCountListener(String str, String str2, IMSessionUnreadCallback iMSessionUnreadCallback) {
        f21759b.setMerchantMessageUnreadCountListener(str, str2, iMSessionUnreadCallback);
    }

    public void setRiderCommonWords(Context context) {
        f21759b.setRiderCommonWords(context);
    }

    public void setMerchantCommonWords(Context context) {
        f21759b.setMerchantCommonWords(context);
    }

    public boolean shouldUseImMessage(String str) {
        return f21759b.shouldUseImMessage(str);
    }
}
