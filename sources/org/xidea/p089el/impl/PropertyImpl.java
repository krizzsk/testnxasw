package org.xidea.p089el.impl;

import org.xidea.p089el.ExpressionToken;
import org.xidea.p089el.OperationStrategy;
import org.xidea.p089el.ValueStack;

/* renamed from: org.xidea.el.impl.PropertyImpl */
/* compiled from: OptimizeExpressionImpl */
class PropertyImpl extends OptimizeExpressionImpl {
    private Object key;

    public PropertyImpl(ExpressionToken expressionToken, OperationStrategy operationStrategy, String str, Object obj) {
        super(expressionToken, operationStrategy, str);
        this.key = obj;
    }

    /* access modifiers changed from: protected */
    public Object compute(ValueStack valueStack) {
        return ReflectUtil.getValue(this.strategy.getVar(valueStack, this.name), this.key);
    }
}
