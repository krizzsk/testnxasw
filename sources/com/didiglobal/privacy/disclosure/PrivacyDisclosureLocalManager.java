package com.didiglobal.privacy.disclosure;

import android.content.Context;

public class PrivacyDisclosureLocalManager extends PrivacyDisclosureBaseManager {

    /* renamed from: a */
    private static volatile PrivacyDisclosureLocalManager f53017a;

    private PrivacyDisclosureLocalManager() {
    }

    public static PrivacyDisclosureLocalManager getInstance() {
        if (f53017a == null) {
            synchronized (PrivacyDisclosureLocalManager.class) {
                if (f53017a == null) {
                    f53017a = new PrivacyDisclosureLocalManager();
                }
            }
        }
        return f53017a;
    }

    /* access modifiers changed from: protected */
    public boolean isEnabledByApollo(Context context, IPrivacyType iPrivacyType) {
        return DisclosureSpUtils.m39720d(context, iPrivacyType);
    }

    /* access modifiers changed from: protected */
    public int getMostDisclosureTimes(Context context) {
        return DisclosureSpUtils.m39706a(context);
    }

    /* access modifiers changed from: protected */
    public PrivacyDisclosureBaseDialog createDialog() {
        return initParam.getLocalDialog();
    }
}
