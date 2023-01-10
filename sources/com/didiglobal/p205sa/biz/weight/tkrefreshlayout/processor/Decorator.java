package com.didiglobal.p205sa.biz.weight.tkrefreshlayout.processor;

import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout;

/* renamed from: com.didiglobal.sa.biz.weight.tkrefreshlayout.processor.Decorator */
public abstract class Decorator implements IDecorator {

    /* renamed from: cp */
    protected TwinklingRefreshLayout.CoContext f53880cp;
    protected IDecorator decorator;

    public Decorator(TwinklingRefreshLayout.CoContext coContext, IDecorator iDecorator) {
        this.f53880cp = coContext;
        this.decorator = iDecorator;
    }
}
