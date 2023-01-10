package com.didi.soda.business.model;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.skeleton.repo.Subscription;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0016J\"\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010¨\u0006\u0011"}, mo148868d2 = {"Lcom/didi/soda/business/model/BusinessPageLifeStateRepo;", "Lcom/didi/app/nova/skeleton/repo/Repo;", "Lcom/didi/soda/business/model/BusinessPageLifeState;", "()V", "getValue", "setState", "", "state", "", "setValue", "businessPageLifeState", "subscriptionNoViscous", "Lcom/didi/app/nova/skeleton/repo/Subscription;", "pageContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "action", "Lcom/didi/app/nova/skeleton/repo/Action;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BusinessPageLifeStateRepo.kt */
public final class BusinessPageLifeStateRepo extends Repo<BusinessPageLifeState> {
    public BusinessPageLifeState getValue() {
        Object value = super.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "super.getValue()");
        return (BusinessPageLifeState) value;
    }

    public void setValue(BusinessPageLifeState businessPageLifeState) {
        Intrinsics.checkNotNullParameter(businessPageLifeState, "businessPageLifeState");
        super.setValue(businessPageLifeState);
    }

    public final void setState(int i) {
        setValue(new BusinessPageLifeState(i));
    }

    public final Subscription subscriptionNoViscous(ScopeContext scopeContext, Action<BusinessPageLifeState> action) {
        return getLiveData().from().shutViscidityNotice().subscribe(scopeContext, action);
    }
}
