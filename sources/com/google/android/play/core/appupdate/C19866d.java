package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import com.google.android.play.core.common.IntentSenderForResultStarter;

/* renamed from: com.google.android.play.core.appupdate.d */
final class C19866d implements IntentSenderForResultStarter {

    /* renamed from: a */
    final /* synthetic */ Activity f55554a;

    C19866d(Activity activity) {
        this.f55554a = activity;
    }

    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        this.f55554a.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
