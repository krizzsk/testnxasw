package org.xidea.p089el;

import org.xidea.p089el.impl.ExpressionFactoryImpl;

/* renamed from: org.xidea.el.ExpressionFactory */
public abstract class ExpressionFactory {
    public abstract Expression create(Object obj);

    public abstract Object parse(String str);

    public static ExpressionFactory getInstance() {
        return ExpressionFactoryImpl.getInstance();
    }
}
