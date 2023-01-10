package org.aspectj.internal.lang.reflect;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.DeclareErrorOrWarning;
import org.aspectj.lang.reflect.PointcutExpression;

public class DeclareErrorOrWarningImpl implements DeclareErrorOrWarning {
    private AjType declaringType;
    private boolean isError;
    private String msg;

    /* renamed from: pc */
    private PointcutExpression f7488pc;

    public DeclareErrorOrWarningImpl(String str, String str2, boolean z, AjType ajType) {
        this.f7488pc = new PointcutExpressionImpl(str);
        this.msg = str2;
        this.isError = z;
        this.declaringType = ajType;
    }

    public AjType getDeclaringType() {
        return this.declaringType;
    }

    public PointcutExpression getPointcutExpression() {
        return this.f7488pc;
    }

    public String getMessage() {
        return this.msg;
    }

    public boolean isError() {
        return this.isError;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("declare ");
        stringBuffer.append(isError() ? "error : " : "warning : ");
        stringBuffer.append(getPointcutExpression().asString());
        stringBuffer.append(" : ");
        stringBuffer.append(Const.jsQuote);
        stringBuffer.append(getMessage());
        stringBuffer.append(Const.jsQuote);
        return stringBuffer.toString();
    }
}
