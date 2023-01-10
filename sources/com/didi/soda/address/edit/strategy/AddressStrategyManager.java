package com.didi.soda.address.edit.strategy;

import com.didi.app.nova.skeleton.ScopeContext;

public class AddressStrategyManager {

    /* renamed from: a */
    private IAddressStrategy f41487a;
    public ScopeContext mScopeContext;

    public IAddressStrategy getStrategy() {
        return this.f41487a;
    }

    public void setFromStrategy(ScopeContext scopeContext, int i, boolean z) {
        if (i == 0) {
            this.f41487a = new AddressListStrategy(scopeContext);
        } else if (i == 3) {
            this.f41487a = new AddressSearchStrategy(scopeContext, z);
        } else if (i == 4) {
            this.f41487a = new OrderAddressListAddStrategy(scopeContext);
        } else if (i != 5) {
            this.f41487a = new CartAddressStrategy(scopeContext);
        } else {
            this.f41487a = new OrderAddressListStrategy(scopeContext);
        }
    }
}
