package com.didi.unifylogin.flutter.request;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.pojo.request.GetCaptchaParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p218io.flutter.plugin.common.MethodCall;
import p218io.flutter.plugin.common.MethodChannel;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo148868d2 = {"Lcom/didi/unifylogin/flutter/request/FGetCaptcha;", "Lcom/didi/unifylogin/flutter/request/BaseFlutterRequest;", "context", "Landroid/content/Context;", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "(Landroid/content/Context;Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "request", "", "OneLogin_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: FGetCaptcha.kt */
public final class FGetCaptcha extends BaseFlutterRequest {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FGetCaptcha(Context context, MethodCall methodCall, MethodChannel.Result result) {
        super(context, methodCall, result);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(result, "result");
    }

    public void request() {
        String str = (String) getCall().argument("cell");
        getMessenger().setCaptchaCell(str);
        LoginModel.getFlutterNet(getContext()).getCaptcha(new GetCaptchaParam(getContext(), getMessenger().getSceneNum()).setCell(str), new FGetCaptcha$request$1(this));
    }
}
