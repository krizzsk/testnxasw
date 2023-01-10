package com.didi.entrega.customer.base.binder.logic;

import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.entrega.customer.base.binder.ComponentLogicUnit;
import com.didi.entrega.customer.base.binder.logic.BinderLogic;

public abstract class CustomerLogicItemBinder<L extends BinderLogic, T, VH extends ItemViewHolder<T>> extends ItemBinder<T, VH> {

    /* renamed from: a */
    private L f21658a;

    public abstract L onCreateBinderLogic();

    public CustomerLogicItemBinder() {
        m18098a((ComponentLogicUnit) null);
    }

    public CustomerLogicItemBinder(ItemDecorator itemDecorator) {
        this(itemDecorator, (ComponentLogicUnit) null);
    }

    public CustomerLogicItemBinder(ComponentLogicUnit componentLogicUnit) {
        m18098a(componentLogicUnit);
    }

    public CustomerLogicItemBinder(ItemDecorator itemDecorator, ComponentLogicUnit componentLogicUnit) {
        super(itemDecorator);
        m18098a(componentLogicUnit);
    }

    public L getBinderLogic() {
        return this.f21658a;
    }

    /* renamed from: a */
    private void m18098a(ComponentLogicUnit componentLogicUnit) {
        L onCreateBinderLogic = onCreateBinderLogic();
        this.f21658a = onCreateBinderLogic;
        if (componentLogicUnit != null) {
            onCreateBinderLogic.attachLogicUnit(componentLogicUnit);
        }
    }
}
