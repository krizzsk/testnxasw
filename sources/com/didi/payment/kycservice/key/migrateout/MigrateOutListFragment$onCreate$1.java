package com.didi.payment.kycservice.key.migrateout;

import com.didi.payment.kycservice.key.migrateout.adapter.MigrateOutListAdapter;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didi/payment/kycservice/key/migrateout/MigrateOutListFragment$onCreate$1", "Lcom/didi/payment/kycservice/key/migrateout/adapter/MigrateOutListAdapter$IItemClickListener;", "onItemClick", "", "position", "", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: MigrateOutListFragment.kt */
public final class MigrateOutListFragment$onCreate$1 implements MigrateOutListAdapter.IItemClickListener {
    final /* synthetic */ MigrateOutListFragment this$0;

    MigrateOutListFragment$onCreate$1(MigrateOutListFragment migrateOutListFragment) {
        this.this$0 = migrateOutListFragment;
    }

    public void onItemClick(int i) {
        MigrateOutListFragment.access$getVm(this.this$0).setPosition(i);
        MigrateOutListFragment.access$getVm(this.this$0).getPageSceneLD().setValue(101);
    }
}
