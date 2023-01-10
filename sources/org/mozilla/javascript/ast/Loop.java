package org.mozilla.javascript.ast;

public abstract class Loop extends Scope {
    protected AstNode body;

    /* renamed from: lp */
    protected int f8479lp = -1;

    /* renamed from: rp */
    protected int f8480rp = -1;

    public Loop() {
    }

    public Loop(int i) {
        super(i);
    }

    public Loop(int i, int i2) {
        super(i, i2);
    }

    public AstNode getBody() {
        return this.body;
    }

    public void setBody(AstNode astNode) {
        this.body = astNode;
        setLength((astNode.getPosition() + astNode.getLength()) - getPosition());
        astNode.setParent(this);
    }

    public int getLp() {
        return this.f8479lp;
    }

    public void setLp(int i) {
        this.f8479lp = i;
    }

    public int getRp() {
        return this.f8480rp;
    }

    public void setRp(int i) {
        this.f8480rp = i;
    }

    public void setParens(int i, int i2) {
        this.f8479lp = i;
        this.f8480rp = i2;
    }
}
