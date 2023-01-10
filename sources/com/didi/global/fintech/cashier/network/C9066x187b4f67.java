package com.didi.global.fintech.cashier.network;

import android.util.Log;
import com.didi.global.fintech.cashier.model.CashierError;
import com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.network.callback.CashierNetCallback;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.Gson;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\u0014\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0018\u00010\u000bH\u0016¨\u0006\f¸\u0006\u0000"}, mo148868d2 = {"com/didi/global/fintech/cashier/network/callback/CashierNetCallbackKt$getBaseResponseCallback$1", "Lcom/didichuxing/foundation/rpc/RpcService$CallbackV2;", "Lcom/didi/global/fintech/cashier/model/net/response/CashierBaseResponse;", "onFailure", "", "request", "Lcom/didichuxing/foundation/rpc/RpcRequest;", "exception", "Ljava/io/IOException;", "onSuccess", "response", "Lcom/didichuxing/foundation/rpc/RpcResponseProxy;", "cashier_network_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.global.fintech.cashier.network.CashierNetwork$getPayMethodInfo$$inlined$getBaseResponseCallback$1 */
/* compiled from: CashierNetCallback.kt */
public final class C9066x187b4f67 implements RpcService.CallbackV2<CashierBaseResponse<PayInfoResponse>> {
    final /* synthetic */ CashierNetCallback $callback;

    public C9066x187b4f67(CashierNetCallback cashierNetCallback) {
        this.$callback = cashierNetCallback;
    }

    public void onSuccess(RpcResponseProxy<CashierBaseResponse<PayInfoResponse>> rpcResponseProxy) {
        String str;
        String errmsg;
        CashierBaseResponse content;
        Object obj = null;
        Log.i("Arirus", Intrinsics.stringPlus("onSuccess: ", rpcResponseProxy == null ? null : rpcResponseProxy.getContent()));
        Log.i("Arirus", Intrinsics.stringPlus("onSuccess: ", PayInfoResponse.class));
        boolean z = false;
        if (!(rpcResponseProxy == null || (content = rpcResponseProxy.getContent()) == null || content.getErrno() != 0)) {
            z = true;
        }
        if (!z) {
            CashierNetCallback cashierNetCallback = this.$callback;
            Intrinsics.checkNotNull(rpcResponseProxy);
            CashierBaseResponse<PayInfoResponse> content2 = rpcResponseProxy.getContent();
            Intrinsics.checkNotNull(content2);
            int errno = content2.getErrno();
            CashierBaseResponse content3 = rpcResponseProxy.getContent();
            String str2 = "";
            if (content3 == null || (str = content3.getErrtitle()) == null) {
                str = str2;
            }
            CashierBaseResponse content4 = rpcResponseProxy.getContent();
            if (!(content4 == null || (errmsg = content4.getErrmsg()) == null)) {
                str2 = errmsg;
            }
            cashierNetCallback.onFailure(new CashierError(errno, str, str2));
            return;
        }
        CashierBaseResponse content5 = rpcResponseProxy.getContent();
        if ((content5 == null ? null : content5.getData()) != null) {
            Gson gson = new Gson();
            CashierBaseResponse content6 = rpcResponseProxy.getContent();
            Log.i("Arirus", Intrinsics.stringPlus("onSuccess: ", gson.toJson(content6 == null ? null : content6.getData())));
            CashierNetCallback cashierNetCallback2 = this.$callback;
            CashierBaseResponse content7 = rpcResponseProxy.getContent();
            if (content7 != null) {
                obj = content7.getData();
            }
            Intrinsics.checkNotNull(obj);
            cashierNetCallback2.onSuccess(obj);
            return;
        }
        Log.i("Arirus", "NET_ERROR: XXXXXXXXXXXXXXXXXXXXXXX1");
        new RuntimeException().printStackTrace();
        this.$callback.onFailure(CashierError.Companion.getSERVER_UNKNOWN_ERR());
    }

    public void onFailure(RpcRequest rpcRequest, IOException iOException) {
        String str;
        Log.i("Arirus", "NET_ERROR: XXXXXXXXXXXXXXXXXXXXXXX2");
        if (rpcRequest == null) {
            str = null;
        } else {
            str = rpcRequest.getUrl();
        }
        Log.i("Arirus", Intrinsics.stringPlus("NET_ERROR: ", str));
        if (iOException != null) {
            iOException.printStackTrace();
        }
        this.$callback.onFailure(CashierError.Companion.getNET_ERROR());
    }
}
