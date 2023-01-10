package com.wallet.flutter.wallet_flutter.http;

import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import p218io.flutter.plugin.common.MethodChannel;

@Metadata(mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¨\u0006\u0002"}, mo148868d2 = {"<anonymous>", "", "com/wallet/flutter/wallet_flutter/base/FlutterHelper$Companion$runOnMain$1"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FlutterHelper.kt */
public final class WalletFlutterHttpChannel$onFail$$inlined$runOnMain$1 implements Runnable {
    final /* synthetic */ int $errorCode$inlined;
    final /* synthetic */ String $errorMsg$inlined;
    final /* synthetic */ MethodChannel.Result $result$inlined;

    public WalletFlutterHttpChannel$onFail$$inlined$runOnMain$1(MethodChannel.Result result, int i, String str) {
        this.$result$inlined = result;
        this.$errorCode$inlined = i;
        this.$errorMsg$inlined = str;
    }

    public final void run() {
        MethodChannel.Result result = this.$result$inlined;
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.m41339to("platformError", true);
        pairArr[1] = TuplesKt.m41339to(Constants.ERROR_CODE, Integer.valueOf(this.$errorCode$inlined));
        String str = this.$errorMsg$inlined;
        if (str == null) {
            str = "";
        }
        pairArr[2] = TuplesKt.m41339to("errorMsg", str);
        result.success(MapsKt.mutableMapOf(pairArr));
        Unit unit = Unit.INSTANCE;
    }
}
