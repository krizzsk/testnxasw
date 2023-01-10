package com.didi.soda.address.component.feed;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.address.omega.AddressOmegaHelper;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import java.lang.ref.WeakReference;
import java.util.List;

public class AddressFeedOmegaHelper {

    /* renamed from: a */
    private static AddressFeedOmegaHelper f41371a = new AddressFeedOmegaHelper();

    /* renamed from: b */
    private String f41372b;

    /* renamed from: c */
    private int f41373c;

    /* renamed from: d */
    private int f41374d;

    /* renamed from: e */
    private int f41375e;

    /* renamed from: f */
    private int f41376f;

    /* renamed from: g */
    private WeakReference<ScopeContext> f41377g;

    public static AddressFeedOmegaHelper getInstance() {
        return f41371a;
    }

    public void attach(ScopeContext scopeContext) {
        this.f41377g = new WeakReference<>(scopeContext);
    }

    public void detach(ScopeContext scopeContext) {
        WeakReference<ScopeContext> weakReference = this.f41377g;
        if (weakReference != null && scopeContext == weakReference.get()) {
            this.f41377g = null;
        }
    }

    public void trackOpenGps(int i, boolean z) {
        AddressOmegaHelper.clickManuGetAddress(3, i, z);
    }

    public void openAddressHomePage(int i, boolean z, boolean z2) {
        WeakReference<ScopeContext> weakReference = this.f41377g;
        AddressOmegaHelper.openAddressHomePage(weakReference != null ? (ScopeContext) weakReference.get() : null, i, z, z2);
    }

    public void trackActionOnAddress(int i, String str, String str2, String str3, boolean z, int i2, int i3) {
        AddressOmegaHelper.chooseAddress(i, str2, str, str3, z, i2, i3);
    }

    public void resetAddressTrackerNum(int i, String str, List<AddressEntity> list) {
        this.f41376f = i;
        if (str == null) {
            str = "";
        }
        this.f41372b = str;
        this.f41373c = 0;
        this.f41374d = 0;
        this.f41375e = 0;
        if (list != null) {
            for (AddressEntity next : list) {
                if (next.type == 1) {
                    this.f41373c = 1;
                } else if (next.type == 2) {
                    this.f41374d = 1;
                } else {
                    this.f41375e++;
                }
            }
        }
    }
}
