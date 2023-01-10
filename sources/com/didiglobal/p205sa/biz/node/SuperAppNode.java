package com.didiglobal.p205sa.biz.node;

import android.os.Bundle;
import com.didi.component.never.core.node.NodeImpl;
import com.didi.component.never.core.node.NodeManager;
import com.didi.component_processor.annonation.NodeName;
import com.didiglobal.p205sa.biz.presenter.SuperAppNodePresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, mo148868d2 = {"Lcom/didiglobal/sa/biz/node/SuperAppNode;", "Lcom/didi/component/never/core/node/NodeImpl;", "Lcom/didiglobal/sa/biz/presenter/SuperAppNodePresenter;", "nodeManager", "Lcom/didi/component/never/core/node/NodeManager;", "bundle", "Landroid/os/Bundle;", "(Lcom/didi/component/never/core/node/NodeManager;Landroid/os/Bundle;)V", "createPresenter", "biz-library_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@NodeName(name = "NODE_SUPPER_APP")
/* renamed from: com.didiglobal.sa.biz.node.SuperAppNode */
/* compiled from: SuperAppNode.kt */
public final class SuperAppNode extends NodeImpl<SuperAppNodePresenter> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperAppNode(NodeManager nodeManager, Bundle bundle) {
        super(nodeManager, bundle);
        Intrinsics.checkNotNullParameter(nodeManager, "nodeManager");
    }

    public SuperAppNodePresenter createPresenter(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        return new SuperAppNodePresenter(this, bundle);
    }
}
