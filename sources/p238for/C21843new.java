package p238for;

import org.json.JSONObject;

/* renamed from: for.new */
/* compiled from: GpaParameters */
public class C21843new {

    /* renamed from: case  reason: not valid java name */
    public final int f62450case;

    /* renamed from: do */
    public final float f60022do;

    /* renamed from: else  reason: not valid java name */
    public final int f62451else;

    /* renamed from: for  reason: not valid java name */
    public final int f62452for;

    /* renamed from: if */
    public final int f60023if;

    /* renamed from: new  reason: not valid java name */
    public final int f62453new;

    /* renamed from: try  reason: not valid java name */
    public final int f62454try;

    public C21843new(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f60022do = (float) i;
        this.f60023if = i2;
        this.f62452for = i3;
        this.f62453new = i4;
        this.f62454try = i5;
        this.f62450case = i6;
        this.f62451else = i7;
    }

    /* renamed from: do */
    public static C21843new m45177do() {
        return new C21843new(3500, 2, 1, 2, 2, 250, 800);
    }

    public C21843new(JSONObject jSONObject) {
        this.f60022do = (float) jSONObject.optInt("frs", 3500);
        this.f60023if = jSONObject.optInt("fpf", 2);
        this.f62452for = jSONObject.optInt("cfc", 1);
        this.f62453new = jSONObject.optInt("pfc", 2);
        this.f62454try = jSONObject.optInt("afc", 2);
        this.f62450case = jSONObject.optInt("lfd", 250);
        this.f62451else = jSONObject.optInt("ufd", 800);
    }
}
