package com.wallet.flutter.wallet_flutter.function;

import androidx.core.app.NotificationCompat;
import com.didi.payment.base.exts.ApplicationContextProvider;
import com.didi.payment.base.utils.FileUtil;
import com.wallet.flutter.wallet_flutter.base.FlutterHelper;
import com.wallet.flutter.wallet_flutter.base.IActivityAwareOwner;
import com.wallet.flutter.wallet_flutter.base.IFlutterMethodCall;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import p218io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import p218io.flutter.plugin.common.MethodCall;
import p218io.flutter.plugin.common.MethodChannel;

@Metadata(mo148867d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J>\u0010\r\u001a\u00020\u00042\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u0012"}, mo148868d2 = {"Lcom/wallet/flutter/wallet_flutter/function/FlutterShareMethod;", "Lcom/wallet/flutter/wallet_flutter/base/IFlutterMethodCall;", "()V", "onCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "bindingOwner", "Lcom/wallet/flutter/wallet_flutter/base/IActivityAwareOwner;", "pluginBindingId", "", "performShareAction", "map", "", "", "Companion", "wallet_flutter_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FlutterShareMethod.kt */
public final class FlutterShareMethod implements IFlutterMethodCall {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String filePathKey = "filePath";
    public static final int requestShareCode = 10000;
    public static final int shareStatusCancel = 2;
    public static final int shareStatusComplete = 0;
    public static final int shareStatusError = 1;
    public static final String shareStatusKey = "shareStatusKey";

    @Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo148868d2 = {"Lcom/wallet/flutter/wallet_flutter/function/FlutterShareMethod$Companion;", "", "()V", "filePathKey", "", "requestShareCode", "", "shareStatusCancel", "shareStatusComplete", "shareStatusError", "shareStatusKey", "wallet_flutter_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: FlutterShareMethod.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void onCall(MethodCall methodCall, MethodChannel.Result result, IActivityAwareOwner iActivityAwareOwner, String str) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(iActivityAwareOwner, "bindingOwner");
        Intrinsics.checkNotNullParameter(str, "pluginBindingId");
        Map linkedHashMap = new LinkedHashMap();
        Object obj = methodCall.arguments;
        Object obj2 = null;
        Map map = obj instanceof Map ? (Map) obj : null;
        Object obj3 = map == null ? null : map.get("title");
        if (!(obj3 instanceof String)) {
            obj3 = null;
        }
        linkedHashMap.put("title", (String) obj3);
        Object obj4 = methodCall.arguments;
        Map map2 = obj4 instanceof Map ? (Map) obj4 : null;
        Object obj5 = map2 == null ? null : map2.get("desc");
        if (!(obj5 instanceof String)) {
            obj5 = null;
        }
        linkedHashMap.put("desc", (String) obj5);
        Object obj6 = methodCall.arguments;
        Map map3 = obj6 instanceof Map ? (Map) obj6 : null;
        Object obj7 = map3 == null ? null : map3.get("url");
        if (!(obj7 instanceof String)) {
            obj7 = null;
        }
        linkedHashMap.put("url", (String) obj7);
        Object obj8 = methodCall.arguments;
        Map map4 = obj8 instanceof Map ? (Map) obj8 : null;
        Object obj9 = map4 == null ? null : map4.get("datas");
        if (obj9 instanceof byte[]) {
            obj2 = obj9;
        }
        linkedHashMap.put("datas", (byte[]) obj2);
        m44490a(linkedHashMap, methodCall, result, iActivityAwareOwner, str);
    }

    /* renamed from: a */
    private final void m44490a(Map<String, Object> map, MethodCall methodCall, MethodChannel.Result result, IActivityAwareOwner iActivityAwareOwner, String str) {
        Map<String, Object> map2 = map;
        MethodChannel.Result result2 = result;
        String stringPlus = Intrinsics.stringPlus(UUID.randomUUID().toString(), "_share_pic.png");
        Object obj = map.get("datas");
        byte[] bArr = obj instanceof byte[] ? (byte[]) obj : null;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        if (bArr != null) {
            T byteToFile = FileUtil.byteToFile(bArr, stringPlus, ApplicationContextProvider.Companion.getContext());
            Intrinsics.checkNotNullExpressionValue(byteToFile, "byteToFile(it, fileName,…extProvider.getContext())");
            objectRef.element = byteToFile;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("fileName", stringPlus);
        jSONObject.putOpt("title", map.get("title"));
        jSONObject.putOpt("desc", map.get("desc"));
        jSONObject.putOpt("url", map.get("url"));
        JSONObject putOpt = jSONObject.putOpt(filePathKey, objectRef.element);
        ActivityPluginBinding activityPluginBinding = iActivityAwareOwner.getActivityPluginBinding();
        if (activityPluginBinding != null) {
            activityPluginBinding.addActivityResultListener(new C21643xe9efc581(activityPluginBinding, result2, objectRef));
        }
        if (!FlutterHelper.Companion.proxyByActivity(methodCall, iActivityAwareOwner, str, false, putOpt, true, 10000)) {
            result2.success((Object) null);
        }
    }
}
