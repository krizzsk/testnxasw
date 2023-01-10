package com.didi.dimina.container.bridge.blankscreen;

import android.view.View;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.webengine.WebViewEngine;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo148868d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onReceiveValue"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: CheckBlankScreenManager.kt */
final class CheckBlankScreenManager$checkIsSkeletonShow$1<T> implements WebViewEngine.WebViewEngineValueCallback<String> {
    final /* synthetic */ DMConfig.BlankScreenConfig $config;
    final /* synthetic */ int $currentTimes;
    final /* synthetic */ float $rate;
    final /* synthetic */ WebViewEngine $webview;
    final /* synthetic */ CheckBlankScreenManager this$0;

    CheckBlankScreenManager$checkIsSkeletonShow$1(CheckBlankScreenManager checkBlankScreenManager, DMConfig.BlankScreenConfig blankScreenConfig, int i, float f, WebViewEngine webViewEngine) {
        this.this$0 = checkBlankScreenManager;
        this.$config = blankScreenConfig;
        this.$currentTimes = i;
        this.$rate = f;
        this.$webview = webViewEngine;
    }

    public final void onReceiveValue(String str) {
        CheckBlankScreenManager checkBlankScreenManager = this.this$0;
        checkBlankScreenManager.m15752a("检测骨架屏结果为：" + str);
        if (str == null || !Boolean.parseBoolean(str)) {
            this.this$0.m15751a(this.$config, this.$currentTimes, -1, this.$rate);
            return;
        }
        this.this$0.m15751a(this.$config, this.$currentTimes, 2, this.$rate);
        this.this$0.m15749a(this.$currentTimes, (View) this.$webview.getWebView(), this.$config);
    }
}
