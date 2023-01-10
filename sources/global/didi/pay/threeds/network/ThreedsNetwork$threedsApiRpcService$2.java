package global.didi.pay.threeds.network;

import com.didi.payment.wallet.global.constant.GlobalServer;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import global.didi.pay.threeds.network.api.ThreedsApiRpcService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n"}, mo148868d2 = {"<anonymous>", "Lglobal/didi/pay/threeds/network/api/ThreedsApiRpcService;", "kotlin.jvm.PlatformType"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ThreedsNetwork.kt */
final class ThreedsNetwork$threedsApiRpcService$2 extends Lambda implements Function0<ThreedsApiRpcService> {
    final /* synthetic */ ThreedsNetwork this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ThreedsNetwork$threedsApiRpcService$2(ThreedsNetwork threedsNetwork) {
        super(0);
        this.this$0 = threedsNetwork;
    }

    public final ThreedsApiRpcService invoke() {
        return (ThreedsApiRpcService) new RpcServiceFactory(this.this$0.context).newRpcService(ThreedsApiRpcService.class, GlobalServer.GLOBAL_ONLINE_ORIGIN_URL);
    }
}
