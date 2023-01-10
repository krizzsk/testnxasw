package org.mozilla.javascript.ast;

public class XmlDotQuery extends InfixExpression {

    /* renamed from: rp */
    private int f8485rp = -1;

    public XmlDotQuery() {
        this.type = 146;
    }

    public XmlDotQuery(int i) {
        super(i);
        this.type = 146;
    }

    public XmlDotQuery(int i, int i2) {
        super(i, i2);
        this.type = 146;
    }

    public int getRp() {
        return this.f8485rp;
    }

    public void setRp(int i) {
        this.f8485rp = i;
    }

    public String toSource(int i) {
        return makeIndent(i) + getLeft().toSource(0) + ".(" + getRight().toSource(0) + ")";
    }
}
