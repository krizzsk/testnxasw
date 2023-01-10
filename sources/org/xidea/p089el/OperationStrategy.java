package org.xidea.p089el;

/* renamed from: org.xidea.el.OperationStrategy */
public interface OperationStrategy {
    Object evaluate(ExpressionToken expressionToken, ValueStack valueStack);

    Object getVar(ValueStack valueStack, Object obj);
}
