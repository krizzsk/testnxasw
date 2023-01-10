package com.didiglobal.privacy.disclosure;

import android.content.Context;

public class PrivacyDisclosureManager extends PrivacyDisclosureBaseManager {

    /* renamed from: a */
    private static volatile PrivacyDisclosureManager f53018a;

    private PrivacyDisclosureManager() {
    }

    public static PrivacyDisclosureManager getInstance() {
        if (f53018a == null) {
            synchronized (PrivacyDisclosureManager.class) {
                if (f53018a == null) {
                    f53018a = new PrivacyDisclosureManager();
                }
            }
        }
        return f53018a;
    }

    public void uploadIfNeeded(Context context) {
        UploadParam b = DisclosureSpUtils.m39713b(context);
        if (b != null) {
            UploadUtils.upload(context, b);
        }
        DisclosureSpUtils.m39710a(context, false);
    }

    public void syncApolloToSp(Context context, IPrivacyType iPrivacyType) {
        DisclosureApolloUtils.m39704a(context);
        DisclosureApolloUtils.m39705a(context, iPrivacyType);
    }

    /* access modifiers changed from: protected */
    public boolean isEnabledByApollo(Context context, IPrivacyType iPrivacyType) {
        return DisclosureApolloUtils.m39705a(context, iPrivacyType);
    }

    /* access modifiers changed from: protected */
    public int getMostDisclosureTimes(Context context) {
        return DisclosureApolloUtils.m39704a(context);
    }

    /* access modifiers changed from: protected */
    public PrivacyDisclosureBaseDialog createDialog() {
        return initParam.getDialog();
    }
}
