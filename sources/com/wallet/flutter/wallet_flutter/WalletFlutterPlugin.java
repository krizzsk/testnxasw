package com.wallet.flutter.wallet_flutter;

import com.wallet.flutter.wallet_flutter.base.FlutterHelper;
import com.wallet.flutter.wallet_flutter.base.IFlutterPluginBindingOwner;
import com.wallet.flutter.wallet_flutter.function.WalletFlutterMethodChannel;
import com.wallet.flutter.wallet_flutter.wallet_ui.WalletUIMethodChannel;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p218io.flutter.embedding.engine.plugins.FlutterPlugin;
import p218io.flutter.embedding.engine.plugins.activity.ActivityAware;
import p218io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import p218io.flutter.plugin.common.MethodChannel;

@Metadata(mo148867d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo148868d2 = {"Lcom/wallet/flutter/wallet_flutter/WalletFlutterPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/embedding/engine/plugins/activity/ActivityAware;", "Lcom/wallet/flutter/wallet_flutter/base/IFlutterPluginBindingOwner;", "()V", "activityBinding", "Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "ownerId", "", "walletFlutterChannel", "Lcom/wallet/flutter/wallet_flutter/function/WalletFlutterMethodChannel;", "walletUIChannel", "Lcom/wallet/flutter/wallet_flutter/wallet_ui/WalletUIMethodChannel;", "getFlutterActivityBinding", "getFlutterPluginBinding", "onAttachedToActivity", "", "onAttachedToEngine", "onDetachedFromActivity", "onDetachedFromActivityForConfigChanges", "onDetachedFromEngine", "onReattachedToActivityForConfigChanges", "wallet_flutter_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletFlutterPlugin.kt */
public final class WalletFlutterPlugin implements IFlutterPluginBindingOwner, FlutterPlugin, ActivityAware {

    /* renamed from: a */
    private WalletFlutterMethodChannel f58798a;

    /* renamed from: b */
    private WalletUIMethodChannel f58799b;

    /* renamed from: c */
    private FlutterPlugin.FlutterPluginBinding f58800c;

    /* renamed from: d */
    private String f58801d;

    /* renamed from: e */
    private ActivityPluginBinding f58802e;

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        this.f58800c = flutterPluginBinding;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        this.f58801d = uuid;
        FlutterHelper.Companion.registerFlutterPluginBindingOwner(uuid, this);
        this.f58798a = new WalletFlutterMethodChannel(flutterPluginBinding, uuid);
        this.f58799b = new WalletUIMethodChannel(flutterPluginBinding, uuid);
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        FlutterHelper.Companion.unregisterFlutterPluginBindingOwner(this.f58801d);
        this.f58800c = null;
        WalletFlutterMethodChannel walletFlutterMethodChannel = this.f58798a;
        if (walletFlutterMethodChannel != null) {
            walletFlutterMethodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
        this.f58798a = null;
        WalletUIMethodChannel walletUIMethodChannel = this.f58799b;
        if (walletUIMethodChannel != null) {
            walletUIMethodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
        this.f58799b = null;
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
        this.f58802e = activityPluginBinding;
        WalletFlutterMethodChannel walletFlutterMethodChannel = this.f58798a;
        if (walletFlutterMethodChannel != null) {
            walletFlutterMethodChannel.onAttachedToActivity(activityPluginBinding);
        }
        WalletUIMethodChannel walletUIMethodChannel = this.f58799b;
        if (walletUIMethodChannel != null) {
            walletUIMethodChannel.onAttachedToActivity(activityPluginBinding);
        }
    }

    public void onDetachedFromActivityForConfigChanges() {
        this.f58802e = null;
        WalletFlutterMethodChannel walletFlutterMethodChannel = this.f58798a;
        if (walletFlutterMethodChannel != null) {
            walletFlutterMethodChannel.onDetachedFromActivityForConfigChanges();
        }
        WalletUIMethodChannel walletUIMethodChannel = this.f58799b;
        if (walletUIMethodChannel != null) {
            walletUIMethodChannel.onDetachedFromActivityForConfigChanges();
        }
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
        this.f58802e = activityPluginBinding;
        WalletFlutterMethodChannel walletFlutterMethodChannel = this.f58798a;
        if (walletFlutterMethodChannel != null) {
            walletFlutterMethodChannel.onReattachedToActivityForConfigChanges(activityPluginBinding);
        }
        WalletUIMethodChannel walletUIMethodChannel = this.f58799b;
        if (walletUIMethodChannel != null) {
            walletUIMethodChannel.onReattachedToActivityForConfigChanges(activityPluginBinding);
        }
    }

    public void onDetachedFromActivity() {
        this.f58802e = null;
        WalletFlutterMethodChannel walletFlutterMethodChannel = this.f58798a;
        if (walletFlutterMethodChannel != null) {
            walletFlutterMethodChannel.onDetachedFromActivity();
        }
        WalletUIMethodChannel walletUIMethodChannel = this.f58799b;
        if (walletUIMethodChannel != null) {
            walletUIMethodChannel.onDetachedFromActivity();
        }
    }

    public FlutterPlugin.FlutterPluginBinding getFlutterPluginBinding() {
        return this.f58800c;
    }

    public ActivityPluginBinding getFlutterActivityBinding() {
        return this.f58802e;
    }
}
