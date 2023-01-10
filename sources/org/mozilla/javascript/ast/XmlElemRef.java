package org.mozilla.javascript.ast;

import com.didichuxing.bigdata.p174dp.locsdk.Const;

public class XmlElemRef extends XmlRef {
    private AstNode indexExpr;

    /* renamed from: lb */
    private int f8486lb = -1;

    /* renamed from: rb */
    private int f8487rb = -1;

    public XmlElemRef() {
        this.type = 77;
    }

    public XmlElemRef(int i) {
        super(i);
        this.type = 77;
    }

    public XmlElemRef(int i, int i2) {
        super(i, i2);
        this.type = 77;
    }

    public AstNode getExpression() {
        return this.indexExpr;
    }

    public void setExpression(AstNode astNode) {
        assertNotNull(astNode);
        this.indexExpr = astNode;
        astNode.setParent(this);
    }

    public int getLb() {
        return this.f8486lb;
    }

    public void setLb(int i) {
        this.f8486lb = i;
    }

    public int getRb() {
        return this.f8487rb;
    }

    public void setRb(int i) {
        this.f8487rb = i;
    }

    public void setBrackets(int i, int i2) {
        this.f8486lb = i;
        this.f8487rb = i2;
    }

    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        if (isAttributeAccess()) {
            sb.append("@");
        }
        if (this.namespace != null) {
            sb.append(this.namespace.toSource(0));
            sb.append("::");
        }
        sb.append(Const.jaLeft);
        sb.append(this.indexExpr.toSource(0));
        sb.append(Const.jaRight);
        return sb.toString();
    }

    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            if (this.namespace != null) {
                this.namespace.visit(nodeVisitor);
            }
            this.indexExpr.visit(nodeVisitor);
        }
    }
}
