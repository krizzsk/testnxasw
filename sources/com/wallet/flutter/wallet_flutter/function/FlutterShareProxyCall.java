package com.wallet.flutter.wallet_flutter.function;

import com.wallet.flutter.wallet_flutter.base.FlutterProxyActivityCallAdapter;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\r"}, mo148868d2 = {"Lcom/wallet/flutter/wallet_flutter/function/FlutterShareProxyCall;", "Lcom/wallet/flutter/wallet_flutter/base/FlutterProxyActivityCallAdapter;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "activity", "Landroidx/fragment/app/FragmentActivity;", "params", "", "otherParams", "pluginBindingId", "wallet_flutter_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FlutterShareProxyCall.kt */
public final class FlutterShareProxyCall extends FlutterProxyActivityCallAdapter {
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001f, code lost:
        r9 = r9.toString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r7, androidx.fragment.app.FragmentActivity r8, java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            r6 = this;
            java.lang.String r7 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r7)
            java.util.Map r7 = com.wallet.flutter.wallet_flutter.base.FlutterHelperKt.jsonToMap(r10)
            if (r7 != 0) goto L_0x0013
            com.wallet.flutter.wallet_flutter.base.FlutterHelper$Companion r7 = com.wallet.flutter.wallet_flutter.base.FlutterHelper.Companion
            r9 = 2
            r10 = 0
            com.wallet.flutter.wallet_flutter.base.FlutterHelper.Companion.callbackMethodFail$default(r7, r8, r10, r9, r10)
            return
        L_0x0013:
            java.lang.String r9 = "title"
            java.lang.Object r9 = r7.get(r9)
            java.lang.String r10 = ""
            if (r9 != 0) goto L_0x001f
        L_0x001d:
            r1 = r10
            goto L_0x0027
        L_0x001f:
            java.lang.String r9 = r9.toString()
            if (r9 != 0) goto L_0x0026
            goto L_0x001d
        L_0x0026:
            r1 = r9
        L_0x0027:
            java.lang.String r9 = "desc"
            java.lang.Object r9 = r7.get(r9)
            if (r9 != 0) goto L_0x0031
        L_0x002f:
            r2 = r10
            goto L_0x0039
        L_0x0031:
            java.lang.String r9 = r9.toString()
            if (r9 != 0) goto L_0x0038
            goto L_0x002f
        L_0x0038:
            r2 = r9
        L_0x0039:
            java.lang.String r9 = "url"
            java.lang.Object r9 = r7.get(r9)
            java.lang.String r11 = "WEB_99_DOWN_PAGE"
            if (r9 != 0) goto L_0x0045
        L_0x0043:
            r3 = r11
            goto L_0x004d
        L_0x0045:
            java.lang.String r9 = r9.toString()
            if (r9 != 0) goto L_0x004c
            goto L_0x0043
        L_0x004c:
            r3 = r9
        L_0x004d:
            java.lang.String r9 = "filePath"
            java.lang.Object r7 = r7.get(r9)
            if (r7 != 0) goto L_0x0057
        L_0x0055:
            r4 = r10
            goto L_0x005f
        L_0x0057:
            java.lang.String r7 = r7.toString()
            if (r7 != 0) goto L_0x005e
            goto L_0x0055
        L_0x005e:
            r4 = r7
        L_0x005f:
            com.wallet.flutter.wallet_flutter.function.FlutterShareProxyCall$onCreate$1$1 r7 = new com.wallet.flutter.wallet_flutter.function.FlutterShareProxyCall$onCreate$1$1
            r7.<init>(r8)
            r5 = r7
            com.didi.payment.commonsdk.utils.NCommonShareManager$CommonShareCallback r5 = (com.didi.payment.commonsdk.utils.NCommonShareManager.CommonShareCallback) r5
            r0 = r8
            com.didi.payment.commonsdk.utils.NCommonShareManager.showCommonShareWindow(r0, r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wallet.flutter.wallet_flutter.function.FlutterShareProxyCall.onCreate(android.os.Bundle, androidx.fragment.app.FragmentActivity, java.lang.String, java.lang.String, java.lang.String):void");
    }
}
