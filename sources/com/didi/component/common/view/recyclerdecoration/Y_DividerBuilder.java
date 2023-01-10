package com.didi.component.common.view.recyclerdecoration;

public class Y_DividerBuilder {

    /* renamed from: a */
    private Y_SideLine f13748a;

    /* renamed from: b */
    private Y_SideLine f13749b;

    /* renamed from: c */
    private Y_SideLine f13750c;

    /* renamed from: d */
    private Y_SideLine f13751d;

    /* renamed from: e */
    private Y_SideLine f13752e = new Y_SideLine(false, -10066330, 0, 0, 0);

    public Y_DividerBuilder setLeftSideLine(boolean z, int i, int i2, int i3, int i4) {
        this.f13748a = new Y_SideLine(z, i, i2, i3, i4);
        return this;
    }

    public Y_DividerBuilder setTopSideLine(boolean z, int i, int i2, int i3, int i4) {
        this.f13749b = new Y_SideLine(z, i, i2, i3, i4);
        return this;
    }

    public Y_DividerBuilder setRightSideLine(boolean z, int i, int i2, int i3, int i4) {
        this.f13750c = new Y_SideLine(z, i, i2, i3, i4);
        return this;
    }

    public Y_DividerBuilder setBottomSideLine(boolean z, int i, int i2, int i3, int i4) {
        this.f13751d = new Y_SideLine(z, i, i2, i3, i4);
        return this;
    }

    public Y_Divider create() {
        Y_SideLine y_SideLine = this.f13748a;
        if (y_SideLine == null) {
            y_SideLine = this.f13752e;
        }
        this.f13748a = y_SideLine;
        Y_SideLine y_SideLine2 = this.f13749b;
        if (y_SideLine2 == null) {
            y_SideLine2 = this.f13752e;
        }
        this.f13749b = y_SideLine2;
        Y_SideLine y_SideLine3 = this.f13750c;
        if (y_SideLine3 == null) {
            y_SideLine3 = this.f13752e;
        }
        this.f13750c = y_SideLine3;
        Y_SideLine y_SideLine4 = this.f13751d;
        if (y_SideLine4 == null) {
            y_SideLine4 = this.f13752e;
        }
        this.f13751d = y_SideLine4;
        return new Y_Divider(this.f13748a, this.f13749b, this.f13750c, y_SideLine4);
    }
}
