package com.facebook;

import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0014\u0010\u0006\u001a\u00020\u00032\n\u0010\u0007\u001a\u00060\bj\u0002`\tH&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, mo148868d2 = {"Lcom/facebook/LoginStatusCallback;", "", "onCompleted", "", "accessToken", "Lcom/facebook/AccessToken;", "onError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onFailure", "facebook-common_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: LoginStatusCallback.kt */
public interface LoginStatusCallback {
    void onCompleted(AccessToken accessToken);

    void onError(Exception exc);

    void onFailure();
}
