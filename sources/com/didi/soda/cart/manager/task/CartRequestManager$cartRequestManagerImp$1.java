package com.didi.soda.cart.manager.task;

import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, mo148868d2 = {"<anonymous>", "", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CartRequestManager.kt */
final class CartRequestManager$cartRequestManagerImp$1 extends Lambda implements Function2<CartInfoEntity, SFRpcException, Unit> {
    final /* synthetic */ CartRequestManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CartRequestManager$cartRequestManagerImp$1(CartRequestManager cartRequestManager) {
        super(2);
        this.this$0 = cartRequestManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((CartInfoEntity) obj, (SFRpcException) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(CartInfoEntity cartInfoEntity, SFRpcException sFRpcException) {
        Object obj;
        Unit unit;
        Function2<CartInfoEntity, SFRpcException, Unit> runRollback;
        Function2<CartInfoEntity, SFRpcException, Unit> runRollback2;
        boolean z;
        CartRequestManagerKt.m32001a("------ 准备回滚 ------");
        if (this.this$0.f42579b.isWaitMerge() || this.this$0.f42580c.isWaitMerge()) {
            CartRequestManagerKt.m32001a("------ 有请求正在merge ------");
            this.this$0.f42581d.add(new C14333a(cartInfoEntity, sFRpcException));
            return;
        }
        CartRequestManagerKt.m32001a("------ 执行回滚 ------");
        if (cartInfoEntity == null) {
            Iterator it = this.this$0.f42581d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((C14333a) obj).mo107692a() != null) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            C14333a aVar = (C14333a) obj;
            if (aVar == null || (runRollback2 = this.this$0.getRunRollback()) == null) {
                unit = null;
            } else {
                runRollback2.invoke(aVar.mo107692a(), sFRpcException);
                unit = Unit.INSTANCE;
            }
            if (unit == null && (runRollback = this.this$0.getRunRollback()) != null) {
                runRollback.invoke(null, sFRpcException);
            }
        } else {
            Function2<CartInfoEntity, SFRpcException, Unit> runRollback3 = this.this$0.getRunRollback();
            if (runRollback3 != null) {
                runRollback3.invoke(cartInfoEntity, sFRpcException);
            }
        }
        this.this$0.f42581d.clear();
    }
}
