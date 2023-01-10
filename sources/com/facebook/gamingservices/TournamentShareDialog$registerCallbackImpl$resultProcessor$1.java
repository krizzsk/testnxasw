package com.facebook.gamingservices;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.gamingservices.TournamentShareDialog;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AppCall;
import com.facebook.share.internal.ResultProcessor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo148868d2 = {"com/facebook/gamingservices/TournamentShareDialog$registerCallbackImpl$resultProcessor$1", "Lcom/facebook/share/internal/ResultProcessor;", "onSuccess", "", "appCall", "Lcom/facebook/internal/AppCall;", "results", "Landroid/os/Bundle;", "facebook-gamingservices_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TournamentShareDialog.kt */
public final class TournamentShareDialog$registerCallbackImpl$resultProcessor$1 extends ResultProcessor {
    final /* synthetic */ FacebookCallback<TournamentShareDialog.Result> $callback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TournamentShareDialog$registerCallbackImpl$resultProcessor$1(FacebookCallback<TournamentShareDialog.Result> facebookCallback) {
        super(facebookCallback);
        this.$callback = facebookCallback;
    }

    public void onSuccess(AppCall appCall, Bundle bundle) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        if (bundle != null) {
            if (bundle.getString("error_message") != null) {
                this.$callback.onError(new FacebookException(bundle.getString("error_message")));
                return;
            } else if (bundle.getString(SDKConstants.PARAM_TOURNAMENTS_ID) != null) {
                this.$callback.onSuccess(new TournamentShareDialog.Result(bundle));
                return;
            }
        }
        onCancel(appCall);
    }
}
