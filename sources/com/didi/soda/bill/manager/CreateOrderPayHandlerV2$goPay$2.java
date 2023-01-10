package com.didi.soda.bill.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.global.fintech.cashier.soda.utils.SodaConsts;
import com.didi.global.fintech.cashier.user.facade.SodaPayResult;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo148868d2 = {"com/didi/soda/bill/manager/CreateOrderPayHandlerV2$goPay$2", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CreateOrderPayHandlerV2.kt */
public final class CreateOrderPayHandlerV2$goPay$2 extends BroadcastReceiver {
    final /* synthetic */ LocalBroadcastManager $localBroadcastManager;
    final /* synthetic */ OrderInfoEntity $order;
    final /* synthetic */ CreateOrderState $outerState;
    final /* synthetic */ CreateOrderPayHandlerV2 this$0;

    CreateOrderPayHandlerV2$goPay$2(LocalBroadcastManager localBroadcastManager, CreateOrderPayHandlerV2 createOrderPayHandlerV2, OrderInfoEntity orderInfoEntity, CreateOrderState createOrderState) {
        this.$localBroadcastManager = localBroadcastManager;
        this.this$0 = createOrderPayHandlerV2;
        this.$order = orderInfoEntity;
        this.$outerState = createOrderState;
    }

    public void onReceive(Context context, Intent intent) {
        Object obj;
        this.$localBroadcastManager.unregisterReceiver(this);
        SodaPayResult sodaPayResult = null;
        if (intent == null) {
            obj = null;
        } else {
            obj = intent.getSerializableExtra(SodaConsts.ARG_PAY_RESULT);
        }
        if (obj instanceof SodaPayResult) {
            sodaPayResult = (SodaPayResult) obj;
        }
        if (sodaPayResult != null) {
            CreateOrderPayHandlerV2 createOrderPayHandlerV2 = this.this$0;
            OrderInfoEntity orderInfoEntity = this.$order;
            CreateOrderState createOrderState = this.$outerState;
            if (Intrinsics.areEqual((Object) sodaPayResult.getSystem(), (Object) SodaPayResult.SYSTEM_CASHIER_SDK) || Intrinsics.areEqual((Object) sodaPayResult.getSystem(), (Object) SodaPayResult.SYSTEM_CASHIER_API)) {
                int errCode = sodaPayResult.getErrCode();
                if (errCode == -20004 || errCode == -20003 || errCode == -20001 || errCode == -20000) {
                    BillOmegaHelper.Companion.traceBillSDKCallBack(2, Integer.valueOf(sodaPayResult.getErrCode()), sodaPayResult.getSystem());
                    createOrderPayHandlerV2.m31415a(createOrderState);
                    return;
                } else if (errCode == 1) {
                    BillOmegaHelper.Companion.traceBillSDKCallBack(0, Integer.valueOf(sodaPayResult.getErrCode()), sodaPayResult.getSystem());
                    createOrderPayHandlerV2.m31416a(orderInfoEntity);
                    return;
                }
            }
            BillOmegaHelper.Companion.traceBillSDKCallBack(1, Integer.valueOf(sodaPayResult.getErrCode()), sodaPayResult.getSystem());
            createOrderPayHandlerV2.m31413a(sodaPayResult, orderInfoEntity);
        }
    }
}
