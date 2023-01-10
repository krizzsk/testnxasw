package com.didi.soda.address.manager;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Action2;
import com.didi.app.nova.skeleton.repo.Action3;
import com.didi.app.nova.skeleton.repo.Action4;
import com.didi.app.nova.skeleton.repo.Event;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class AddressStateRepo extends Repo<AddressEntity> {

    /* renamed from: a */
    private static final String f41494a = "AddressStateRepo";

    /* renamed from: b */
    private List<AddressStateSubscription> f41495b = new ArrayList();

    /* renamed from: c */
    private String f41496c;

    /* renamed from: d */
    private int f41497d = 0;

    AddressStateRepo() {
    }

    /* renamed from: a */
    public int mo105119a() {
        return this.f41497d;
    }

    /* renamed from: a */
    public void mo105121a(int i) {
        this.f41497d = i;
    }

    /* renamed from: b */
    public String mo105125b() {
        return this.f41496c;
    }

    /* renamed from: a */
    public void mo105124a(String str) {
        this.f41496c = str;
    }

    /* renamed from: c */
    public void mo105127c() {
        setValue((AddressEntity) null);
        this.f41496c = null;
        this.f41497d = 0;
        ((AddressStorage) SingletonFactory.get(AddressStorage.class)).clear();
    }

    /* renamed from: a */
    public void setValue(AddressEntity addressEntity) {
        super.setValue(addressEntity);
        m31142a(addressEntity, (AddressEntity) getValue());
        if (AddressUtil.checkAddressValid(addressEntity)) {
            ((AddressStorage) SingletonFactory.get(AddressStorage.class)).setData(addressEntity);
        }
    }

    /* renamed from: b */
    public void mo105126b(AddressEntity addressEntity) {
        AddressEntity addressEntity2 = (AddressEntity) getValue();
        boolean checkAddressValid = AddressUtil.checkAddressValid(addressEntity2);
        if (AddressUtil.checkAddressValid(addressEntity)) {
            if (!addressEntity.poi.poiId.equals(checkAddressValid ? addressEntity2.poi.poiId : "")) {
                setValue(addressEntity);
            }
        } else if (!checkAddressValid) {
            setValue(addressEntity);
        }
    }

    public Subscription subscribe(ScopeContext scopeContext, Action<AddressEntity> action) {
        return super.subscribe(scopeContext, action);
    }

    /* renamed from: a */
    public Subscription mo105120a(ScopeContext scopeContext, Action<AddressEntity> action) {
        return from().shutViscidityNotice().subscribe(scopeContext, action);
    }

    /* renamed from: a */
    public void mo105122a(Action<AddressEntity> action) {
        this.f41495b.add(new AddressStateSubscription(action));
        LogUtil.m32584d(f41494a, "Subscriber without life" + this.f41495b.size());
    }

    /* renamed from: a */
    private void m31142a(AddressEntity addressEntity, AddressEntity addressEntity2) {
        Iterator<AddressStateSubscription> it = this.f41495b.iterator();
        LogUtil.m32584d(f41494a, "Subscriber without life" + this.f41495b.size() + " call:" + addressEntity);
        while (it.hasNext()) {
            AddressStateSubscription next = it.next();
            if (next.isUnsubscribed()) {
                it.remove();
            } else {
                if (next.mAction instanceof Action1) {
                    ((Action1) next.mAction).call(addressEntity);
                } else if (next.mAction instanceof Action2) {
                    ((Action2) next.mAction).call(addressEntity, next);
                } else if (next.mAction instanceof Action3) {
                    ((Action3) next.mAction).invoke(addressEntity, next);
                } else if (next.mAction instanceof Action4) {
                    ((Action4) next.mAction).call(new Event(addressEntity2, addressEntity, next));
                } else {
                    ((Action1) next.mAction).call(addressEntity);
                }
                if (next.isUnsubscribed()) {
                    it.remove();
                }
            }
        }
    }

    class AddressStateSubscription implements Subscription {
        /* access modifiers changed from: private */
        public Action<AddressEntity> mAction;
        private boolean mActive = true;

        AddressStateSubscription(Action<AddressEntity> action) {
            this.mAction = action;
        }

        public boolean isUnsubscribed() {
            return !this.mActive;
        }

        public void unsubscribe() {
            this.mActive = false;
        }

        public void activeChange(boolean z) throws Exception {
            this.mActive = z;
        }
    }
}
