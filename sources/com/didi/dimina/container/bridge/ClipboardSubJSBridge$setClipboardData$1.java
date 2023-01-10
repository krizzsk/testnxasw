package com.didi.dimina.container.bridge;

import com.didi.dimina.container.bridge.toast.ToastServiceManager;
import com.didi.dimina.container.bridge.toast.ToastType;
import com.didi.dimina.container.util.LogUtil;
import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo148868d2 = {"<anonymous>", "", "run"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: ClipboardSubJSBridge.kt */
final class ClipboardSubJSBridge$setClipboardData$1 implements Runnable {
    final /* synthetic */ ClipboardSubJSBridge this$0;

    ClipboardSubJSBridge$setClipboardData$1(ClipboardSubJSBridge clipboardSubJSBridge) {
        this.this$0 = clipboardSubJSBridge;
    }

    public final void run() {
        ToastServiceManager toastServiceManager = new ToastServiceManager(this.this$0.f18449b);
        String access$getTAG$p = this.this$0.f18450c;
        LogUtil.m16842i(access$getTAG$p, "setClipboardData, 弹出toast，toast内容： " + this.this$0.f18449b.getString(R.string.dimina_content_is_copied));
        toastServiceManager.showToast(ToastType.NONE, this.this$0.f18449b.getString(R.string.dimina_content_is_copied), 1500);
    }
}
