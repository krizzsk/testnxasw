package com.didi.payment.wallet.global.router;

import com.didi.drouter.router.IRouterHandler;

public class WalletBalanceHandler implements IRouterHandler {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: com.didi.payment.base.view.PayRichInfo} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handle(com.didi.drouter.router.Request r21, com.didi.drouter.router.Result r22) {
        /*
            r20 = this;
            android.net.Uri r1 = r21.getUri()
            java.lang.String r0 = "params"
            java.lang.String r0 = r1.getQueryParameter(r0)
            java.lang.String r2 = ""
            r3 = 0
            r4 = 0
            r5 = 0
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0068 }
            if (r7 != 0) goto L_0x005e
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x0068 }
            r7.<init>(r0)     // Catch:{ Exception -> 0x0068 }
            java.lang.String r0 = "balanceMessage"
            java.lang.String r0 = r7.optString(r0)     // Catch:{ Exception -> 0x0068 }
            com.google.gson.Gson r8 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0068 }
            r8.<init>()     // Catch:{ Exception -> 0x0068 }
            java.lang.Class<com.didi.payment.base.view.PayRichInfo> r9 = com.didi.payment.base.view.PayRichInfo.class
            java.lang.Object r0 = r8.fromJson((java.lang.String) r0, r9)     // Catch:{ Exception -> 0x0068 }
            r8 = r0
            com.didi.payment.base.view.PayRichInfo r8 = (com.didi.payment.base.view.PayRichInfo) r8     // Catch:{ Exception -> 0x0068 }
            java.lang.String r0 = "channelId"
            int r4 = r7.optInt(r0)     // Catch:{ Exception -> 0x005a }
            java.lang.String r0 = "status"
            int r9 = r7.optInt(r0)     // Catch:{ Exception -> 0x0055 }
            java.lang.String r0 = "detailsMessage"
            java.lang.String r2 = r7.optString(r0)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r0 = "balanceAmount"
            double r5 = r7.optDouble(r0)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r0 = "tab"
            int r0 = r7.optInt(r0)     // Catch:{ Exception -> 0x0050 }
            r3 = r4
            r4 = r8
            goto L_0x0060
        L_0x0050:
            r0 = move-exception
            r7 = r0
            r0 = r4
            r4 = r8
            goto L_0x006c
        L_0x0055:
            r0 = move-exception
            r7 = r0
            r0 = r4
            r4 = r8
            goto L_0x006b
        L_0x005a:
            r0 = move-exception
            r7 = r0
            r4 = r8
            goto L_0x006a
        L_0x005e:
            r0 = 0
            r9 = 0
        L_0x0060:
            r13 = r2
            r12 = r3
            r11 = r4
            r14 = r5
            r16 = r9
            r3 = r0
            goto L_0x008f
        L_0x0068:
            r0 = move-exception
            r7 = r0
        L_0x006a:
            r0 = 0
        L_0x006b:
            r9 = 0
        L_0x006c:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = "catch exception when receive router request with uri: "
            r8.append(r10)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r8.append(r1)
            java.lang.String r1 = r8.toString()
            java.lang.String r8 = "WalletBalanceHandler"
            com.didi.unifiedPay.util.LogUtil.m35171d(r8, r1)
            r7.printStackTrace()
            r12 = r0
            r13 = r2
            r11 = r4
            r14 = r5
            r16 = r9
        L_0x008f:
            android.content.Context r10 = r21.getContext()
            r17 = 0
            r18 = 1
            r0 = 2
            if (r3 != r0) goto L_0x009e
            r0 = 7
            r19 = 7
            goto L_0x00a1
        L_0x009e:
            r0 = 6
            r19 = 6
        L_0x00a1:
            com.didi.payment.wallet.global.utils.WalletRouter.gotoAccountBalancePage(r10, r11, r12, r13, r14, r16, r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.router.WalletBalanceHandler.handle(com.didi.drouter.router.Request, com.didi.drouter.router.Result):void");
    }
}
