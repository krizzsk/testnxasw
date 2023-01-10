package p218io.flutter.plugin.editing;

import org.json.JSONException;
import org.json.JSONObject;
import p218io.flutter.Log;

/* renamed from: io.flutter.plugin.editing.TextEditingDelta */
public final class TextEditingDelta {

    /* renamed from: i */
    private static final String f60562i = "TextEditingDelta";

    /* renamed from: a */
    private CharSequence f60563a;

    /* renamed from: b */
    private CharSequence f60564b;

    /* renamed from: c */
    private int f60565c;

    /* renamed from: d */
    private int f60566d;

    /* renamed from: e */
    private int f60567e;

    /* renamed from: f */
    private int f60568f;

    /* renamed from: g */
    private int f60569g;

    /* renamed from: h */
    private int f60570h;

    public TextEditingDelta(CharSequence charSequence, int i, int i2, CharSequence charSequence2, int i3, int i4, int i5, int i6) {
        this.f60567e = i3;
        this.f60568f = i4;
        this.f60569g = i5;
        this.f60570h = i6;
        m45659a(charSequence, charSequence2.toString(), i, i2);
    }

    public TextEditingDelta(CharSequence charSequence, int i, int i2, int i3, int i4) {
        this.f60567e = i;
        this.f60568f = i2;
        this.f60569g = i3;
        this.f60570h = i4;
        m45659a(charSequence, "", -1, -1);
    }

    public CharSequence getOldText() {
        return this.f60563a;
    }

    public CharSequence getDeltaText() {
        return this.f60564b;
    }

    public int getDeltaStart() {
        return this.f60565c;
    }

    public int getDeltaEnd() {
        return this.f60566d;
    }

    public int getNewSelectionStart() {
        return this.f60567e;
    }

    public int getNewSelectionEnd() {
        return this.f60568f;
    }

    public int getNewComposingStart() {
        return this.f60569g;
    }

    public int getNewComposingEnd() {
        return this.f60570h;
    }

    /* renamed from: a */
    private void m45659a(CharSequence charSequence, CharSequence charSequence2, int i, int i2) {
        this.f60563a = charSequence;
        this.f60564b = charSequence2;
        this.f60565c = i;
        this.f60566d = i2;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oldText", this.f60563a.toString());
            jSONObject.put("deltaText", this.f60564b.toString());
            jSONObject.put("deltaStart", this.f60565c);
            jSONObject.put("deltaEnd", this.f60566d);
            jSONObject.put("selectionBase", this.f60567e);
            jSONObject.put("selectionExtent", this.f60568f);
            jSONObject.put("composingBase", this.f60569g);
            jSONObject.put("composingExtent", this.f60570h);
        } catch (JSONException e) {
            Log.m45255e(f60562i, "unable to create JSONObject: " + e);
        }
        return jSONObject;
    }
}
