package com.didi.entrega.home.manager;

import android.os.Bundle;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.entrega.customer.foundation.rpc.AccountErrorConsumer;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.customer.repo.CustomerResource;
import com.didi.entrega.home.component.feed.entity.HomeFeedEntity;
import com.didi.nova.assembly.serial.SerialTaskQueue;

public class HomeFeedRepo extends Repo<CustomerResource<HomeFeedEntity>> {

    /* renamed from: a */
    private AccountErrorConsumer f22558a;

    /* renamed from: b */
    private SerialTaskQueue f22559b = new SerialTaskQueue();

    public void fetchFeedIndex(ScopeContext scopeContext, final int i) {
        if (this.f22558a == null) {
            this.f22558a = new AccountErrorConsumer(scopeContext);
        }
        this.f22559b.append(new HomeFeedTask(new CustomerRpcCallback<HomeFeedEntity>(this.f22558a) {
            public void onRpcSuccess(HomeFeedEntity homeFeedEntity, long j) {
                Bundle bundle = new Bundle();
                bundle.putInt("from", i);
                HomeFeedRepo.this.setValue(CustomerResource.success(homeFeedEntity, bundle));
            }

            public void onRpcFailure(SFRpcException sFRpcException) {
                super.onRpcFailure(sFRpcException);
                HomeFeedEntity homeFeedEntity = sFRpcException.getResult() != null ? (HomeFeedEntity) sFRpcException.getResult().getData() : null;
                Bundle bundle = new Bundle();
                bundle.putInt("from", i);
                HomeFeedRepo.this.setValue(CustomerResource.error(sFRpcException.getCode(), sFRpcException.getMessage(), homeFeedEntity, bundle));
            }
        }), SerialTaskQueue.AppendMode.ReplaceStrict);
    }
}
