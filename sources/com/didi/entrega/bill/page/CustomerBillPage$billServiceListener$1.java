package com.didi.entrega.bill.page;

import android.content.Intent;
import android.text.TextUtils;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.entrega.customer.flutter.plugin.listener.OnCallPluginListener;
import com.didi.entrega.customer.foundation.util.GsonUtil;
import com.didi.entrega.customer.repo.CustomerActivityResultRepo;
import com.didi.entrega.uni_entrega_business.UniAPI;
import com.didi.entrega.uni_entrega_business.bill.GLEUniBillFlutterModuleService;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, mo148868d2 = {"com/didi/entrega/bill/page/CustomerBillPage$billServiceListener$1", "Lcom/didi/entrega/customer/flutter/plugin/listener/OnCallPluginListener;", "callPlugin", "", "action", "", "params", "", "", "resultListener", "Lcom/didi/entrega/customer/flutter/plugin/listener/OnPluginResultListener;", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CustomerBillPage.kt */
public final class CustomerBillPage$billServiceListener$1 implements OnCallPluginListener {
    final /* synthetic */ CustomerBillPage this$0;

    /* access modifiers changed from: private */
    /* renamed from: callPlugin$lambda-2$lambda-1$lambda-0  reason: not valid java name */
    public static final void m46802callPlugin$lambda2$lambda1$lambda0(Void voidR) {
    }

    CustomerBillPage$billServiceListener$1(CustomerBillPage customerBillPage) {
        this.this$0 = customerBillPage;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: BillAddressMapComponent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: BillAddressMapComponent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: BillAddressMapComponent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: ? extends java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: ? extends java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: BillAddressMapComponent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: BillAddressMapComponent} */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void callPlugin(java.lang.String r4, java.util.Map<java.lang.String, ? extends java.lang.Object> r5, com.didi.entrega.customer.flutter.plugin.listener.OnPluginResultListener r6) {
        /*
            r3 = this;
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            int r0 = r4.hashCode()
            r1 = 0
            switch(r0) {
                case -1042741794: goto L_0x00da;
                case -923621363: goto L_0x00ca;
                case -827015164: goto L_0x0067;
                case 238391086: goto L_0x0021;
                case 320515459: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x00f6
        L_0x000f:
            java.lang.String r6 = "showCoupon"
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto L_0x001a
            goto L_0x00f6
        L_0x001a:
            java.util.HashMap r5 = (java.util.HashMap) r5
            com.didi.entrega.customer.p114h5.CustomerVerticalWebPage.show(r5)
            goto L_0x00f6
        L_0x0021:
            java.lang.String r6 = "payMethodCallBack"
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto L_0x002c
            goto L_0x00f6
        L_0x002c:
            com.didi.entrega.bill.page.CustomerBillPage r4 = r3.this$0
            if (r5 != 0) goto L_0x0031
            goto L_0x0037
        L_0x0031:
            java.lang.String r6 = "fromPage"
            java.lang.Object r1 = r5.get(r6)
        L_0x0037:
            if (r1 == 0) goto L_0x005f
            java.lang.String r1 = (java.lang.String) r1
            r4.f21433g = r1
            java.lang.Class<com.didi.entrega.customer.repo.CustomerActivityResultRepo> r4 = com.didi.entrega.customer.repo.CustomerActivityResultRepo.class
            com.didi.app.nova.skeleton.repo.Repo r4 = com.didi.entrega.customer.repo.RepoFactory.getRepo(r4)
            com.didi.entrega.customer.repo.CustomerActivityResultRepo r4 = (com.didi.entrega.customer.repo.CustomerActivityResultRepo) r4
            com.didi.entrega.bill.page.CustomerBillPage r5 = r3.this$0
            com.didi.app.nova.skeleton.ScopeContext r5 = r5.getScopeContext()
            com.didi.entrega.bill.page.CustomerBillPage r6 = r3.this$0
            com.didi.entrega.bill.page.-$$Lambda$CustomerBillPage$billServiceListener$1$O-QmkxOZTb8sRTQvLpDCfZFXuJY r0 = new com.didi.entrega.bill.page.-$$Lambda$CustomerBillPage$billServiceListener$1$O-QmkxOZTb8sRTQvLpDCfZFXuJY
            r0.<init>()
            r6 = 1
            int[] r6 = new int[r6]
            r1 = 0
            r2 = 3
            r6[r1] = r2
            r4.subscribeResult(r5, r0, r6)
            goto L_0x00f6
        L_0x005f:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.String"
            r4.<init>(r5)
            throw r4
        L_0x0067:
            java.lang.String r0 = "getPayStatus"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x0071
            goto L_0x00f6
        L_0x0071:
            com.didi.entrega.bill.page.CustomerBillPage r4 = r3.this$0
            com.didi.app.nova.skeleton.ScopeContext r4 = r4.getScopeContext()
            if (r4 != 0) goto L_0x007b
            goto L_0x00f6
        L_0x007b:
            if (r5 != 0) goto L_0x007e
            goto L_0x0084
        L_0x007e:
            java.lang.String r0 = "entity"
            java.lang.Object r1 = r5.get(r0)
        L_0x0084:
            if (r1 == 0) goto L_0x00c2
            com.didi.entrega.foundation.rpc.entity.OrderCreateEntity r1 = (com.didi.entrega.foundation.rpc.entity.OrderCreateEntity) r1
            com.didi.entrega.manager.base.ICustomerPayManager$PayParamEntity r5 = new com.didi.entrega.manager.base.ICustomerPayManager$PayParamEntity
            r5.<init>()
            java.lang.String r0 = com.didi.entrega.customer.foundation.util.LoginUtil.getToken()
            r5.token = r0
            java.lang.String r0 = r1.getTransId()
            r5.transId = r0
            java.lang.String r0 = r1.getOrderId()
            r5.orderId = r0
            java.lang.Class<com.didi.entrega.manager.base.ICustomerPayManager> r0 = com.didi.entrega.manager.base.ICustomerPayManager.class
            com.didi.entrega.manager.base.ICustomerManager r0 = com.didi.entrega.manager.CustomerManagerLoader.loadManager(r0)
            com.didi.entrega.manager.base.ICustomerPayManager r0 = (com.didi.entrega.manager.base.ICustomerPayManager) r0
            android.content.Context r1 = com.didi.entrega.customer.app.GlobalContext.getContext()
            if (r1 == 0) goto L_0x00ba
            android.app.Activity r1 = (android.app.Activity) r1
            com.didi.entrega.bill.page.CustomerBillPage$billServiceListener$1$callPlugin$2$1 r2 = new com.didi.entrega.bill.page.CustomerBillPage$billServiceListener$1$callPlugin$2$1
            r2.<init>(r6)
            com.didi.entrega.manager.base.ICustomerPayManager$PayCallback r2 = (com.didi.entrega.manager.base.ICustomerPayManager.PayCallback) r2
            r0.getPayStatus(r1, r4, r5, r2)
            goto L_0x00f6
        L_0x00ba:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            java.lang.String r5 = "null cannot be cast to non-null type android.app.Activity"
            r4.<init>(r5)
            throw r4
        L_0x00c2:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            java.lang.String r5 = "null cannot be cast to non-null type com.didi.entrega.foundation.rpc.entity.OrderCreateEntity"
            r4.<init>(r5)
            throw r4
        L_0x00ca:
            java.lang.String r6 = "showTipPage"
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto L_0x00d4
            goto L_0x00f6
        L_0x00d4:
            com.didi.entrega.bill.page.BillTipPage$Companion r4 = com.didi.entrega.bill.page.BillTipPage.Companion
            r4.show(r5)
            goto L_0x00f6
        L_0x00da:
            java.lang.String r5 = "removeMarker"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00e4
            goto L_0x00f6
        L_0x00e4:
            com.didi.entrega.bill.page.CustomerBillPage r4 = r3.this$0
            BillAddressMapComponent r4 = r4.f21427a
            if (r4 != 0) goto L_0x00f2
            java.lang.String r4 = "billAddressComponent"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L_0x00f3
        L_0x00f2:
            r1 = r4
        L_0x00f3:
            r1.removeMarker()
        L_0x00f6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.bill.page.CustomerBillPage$billServiceListener$1.callPlugin(java.lang.String, java.util.Map, com.didi.entrega.customer.flutter.plugin.listener.OnPluginResultListener):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: callPlugin$lambda-2  reason: not valid java name */
    public static final void m46801callPlugin$lambda2(CustomerBillPage customerBillPage, CustomerActivityResultRepo.ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(customerBillPage, "this$0");
        if (activityResult != null && activityResult.requestCode == 3) {
            Intent intent = activityResult.data;
            Serializable serializableExtra = intent == null ? null : intent.getSerializableExtra("pay_method_list_result");
            if (serializableExtra != null) {
                HashMap hashMap = new HashMap();
                ArrayList arrayList = new ArrayList();
                if (serializableExtra != null) {
                    for (DidiGlobalPayMethodListData.SelectedPayMethod next : ((DidiGlobalPayMethodListData.PayMethodListResult) serializableExtra).selectedPayMethods) {
                        Map linkedHashMap = new LinkedHashMap();
                        if (!TextUtils.isEmpty(next.cardIndex)) {
                            String str = next.cardIndex;
                            if (str == null) {
                                str = "";
                            }
                            linkedHashMap.put("cardIndex", str);
                        }
                        linkedHashMap.put("channelId", Integer.valueOf(next.channelId));
                        arrayList.add(linkedHashMap);
                    }
                    Map map = hashMap;
                    String json = GsonUtil.toJson(arrayList);
                    Intrinsics.checkNotNullExpressionValue(json, "toJson(list)");
                    map.put(Const.FlutterBundleKey.PAY_CHANNEL4, json);
                    map.put("fromPage", customerBillPage.f21433g);
                    ((GLEUniBillFlutterModuleService) UniAPI.get(GLEUniBillFlutterModuleService.class)).updatePayChannel4(GsonUtil.toJson(hashMap), C8587xcf442ba6.INSTANCE);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.didi.sdk.global.DidiGlobalPayMethodListData.PayMethodListResult");
            }
        }
    }
}
