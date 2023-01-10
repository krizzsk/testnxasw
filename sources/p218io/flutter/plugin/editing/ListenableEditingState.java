package p218io.flutter.plugin.editing;

import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import java.util.ArrayList;
import java.util.Iterator;
import p218io.flutter.Log;
import p218io.flutter.embedding.engine.systemchannels.TextInputChannel;

/* renamed from: io.flutter.plugin.editing.ListenableEditingState */
class ListenableEditingState extends SpannableStringBuilder {

    /* renamed from: a */
    private static final String f60549a = "ListenableEditingState";

    /* renamed from: b */
    private int f60550b = 0;

    /* renamed from: c */
    private int f60551c = 0;

    /* renamed from: d */
    private ArrayList<EditingStateWatcher> f60552d = new ArrayList<>();

    /* renamed from: e */
    private ArrayList<EditingStateWatcher> f60553e = new ArrayList<>();

    /* renamed from: f */
    private ArrayList<TextEditingDelta> f60554f = new ArrayList<>();

    /* renamed from: g */
    private String f60555g;

    /* renamed from: h */
    private String f60556h;

    /* renamed from: i */
    private int f60557i;

    /* renamed from: j */
    private int f60558j;

    /* renamed from: k */
    private int f60559k;

    /* renamed from: l */
    private int f60560l;

    /* renamed from: m */
    private BaseInputConnection f60561m;

    /* renamed from: io.flutter.plugin.editing.ListenableEditingState$EditingStateWatcher */
    interface EditingStateWatcher {
        void didChangeEditingState(boolean z, boolean z2, boolean z3);
    }

    public ListenableEditingState(TextInputChannel.TextEditState textEditState, View view) {
        if (textEditState != null) {
            mo182551a(textEditState);
        }
        this.f60561m = new BaseInputConnection(view, true) {
            public Editable getEditable() {
                return this;
            }
        };
    }

    /* renamed from: a */
    public ArrayList<TextEditingDelta> mo182549a() {
        ArrayList<TextEditingDelta> arrayList = new ArrayList<>(this.f60554f);
        this.f60554f.clear();
        return arrayList;
    }

    /* renamed from: b */
    public void mo182553b() {
        this.f60554f.clear();
    }

    /* renamed from: c */
    public void mo182555c() {
        this.f60550b++;
        if (this.f60551c > 0) {
            Log.m45255e(f60549a, "editing state should not be changed in a listener callback");
        }
        if (this.f60550b == 1 && !this.f60552d.isEmpty()) {
            this.f60556h = toString();
            this.f60557i = mo182557e();
            this.f60558j = mo182558f();
            this.f60559k = mo182559g();
            this.f60560l = mo182560h();
        }
    }

    /* renamed from: d */
    public void mo182556d() {
        int i = this.f60550b;
        if (i == 0) {
            Log.m45255e(f60549a, "endBatchEdit called without a matching beginBatchEdit");
            return;
        }
        if (i == 1) {
            Iterator<EditingStateWatcher> it = this.f60553e.iterator();
            while (it.hasNext()) {
                m45645a(it.next(), true, true, true);
            }
            if (!this.f60552d.isEmpty()) {
                Log.m45259v(f60549a, "didFinishBatchEdit with " + String.valueOf(this.f60552d.size()) + " listener(s)");
                boolean equals = toString().equals(this.f60556h) ^ true;
                boolean z = false;
                boolean z2 = (this.f60557i == mo182557e() && this.f60558j == mo182558f()) ? false : true;
                if (!(this.f60559k == mo182559g() && this.f60560l == mo182560h())) {
                    z = true;
                }
                m45646a(equals, z2, z);
            }
        }
        this.f60552d.addAll(this.f60553e);
        this.f60553e.clear();
        this.f60550b--;
    }

    /* renamed from: a */
    public void mo182550a(int i, int i2) {
        if (i < 0 || i >= i2) {
            BaseInputConnection.removeComposingSpans(this);
        } else {
            this.f60561m.setComposingRegion(i, i2);
        }
    }

    /* renamed from: a */
    public void mo182551a(TextInputChannel.TextEditState textEditState) {
        mo182555c();
        replace(0, length(), textEditState.text);
        if (textEditState.hasSelection()) {
            Selection.setSelection(this, textEditState.selectionStart, textEditState.selectionEnd);
        } else {
            Selection.removeSelection(this);
        }
        mo182550a(textEditState.composingStart, textEditState.composingEnd);
        mo182553b();
        mo182556d();
    }

    /* renamed from: a */
    public void mo182552a(EditingStateWatcher editingStateWatcher) {
        if (this.f60551c > 0) {
            Log.m45255e(f60549a, "adding a listener " + editingStateWatcher.toString() + " in a listener callback");
        }
        if (this.f60550b > 0) {
            Log.m45261w(f60549a, "a listener was added to EditingState while a batch edit was in progress");
            this.f60553e.add(editingStateWatcher);
            return;
        }
        this.f60552d.add(editingStateWatcher);
    }

    /* renamed from: b */
    public void mo182554b(EditingStateWatcher editingStateWatcher) {
        if (this.f60551c > 0) {
            Log.m45255e(f60549a, "removing a listener " + editingStateWatcher.toString() + " in a listener callback");
        }
        this.f60552d.remove(editingStateWatcher);
        if (this.f60550b > 0) {
            this.f60553e.remove(editingStateWatcher);
        }
    }

    public SpannableStringBuilder replace(int i, int i2, CharSequence charSequence, int i3, int i4) {
        boolean z;
        boolean z2;
        if (this.f60551c > 0) {
            Log.m45255e(f60549a, "editing state should not be changed in a listener callback");
        }
        String listenableEditingState = toString();
        int i5 = i2 - i;
        boolean z3 = i5 != i4 - i3;
        for (int i6 = 0; i6 < i5 && !z3; i6++) {
            z3 |= charAt(i + i6) != charSequence.charAt(i3 + i6);
        }
        CharSequence charSequence2 = charSequence;
        if (z3) {
            this.f60555g = null;
        }
        int e = mo182557e();
        int f = mo182558f();
        int g = mo182559g();
        int h = mo182560h();
        SpannableStringBuilder replace = super.replace(i, i2, charSequence, i3, i4);
        TextEditingDelta textEditingDelta = r1;
        boolean z4 = z3;
        int i7 = h;
        TextEditingDelta textEditingDelta2 = new TextEditingDelta(listenableEditingState, i, i2, charSequence, mo182557e(), mo182558f(), mo182559g(), mo182560h());
        this.f60554f.add(textEditingDelta);
        if (this.f60550b > 0) {
            return replace;
        }
        boolean z5 = (mo182557e() == e && mo182558f() == f) ? false : true;
        if (mo182559g() == g && mo182560h() == i7) {
            z = z4;
            z2 = false;
        } else {
            z = z4;
            z2 = true;
        }
        m45646a(z, z5, z2);
        return replace;
    }

    /* renamed from: a */
    private void m45645a(EditingStateWatcher editingStateWatcher, boolean z, boolean z2, boolean z3) {
        this.f60551c++;
        editingStateWatcher.didChangeEditingState(z, z2, z3);
        this.f60551c--;
    }

    /* renamed from: a */
    private void m45646a(boolean z, boolean z2, boolean z3) {
        if (z || z2 || z3) {
            Iterator<EditingStateWatcher> it = this.f60552d.iterator();
            while (it.hasNext()) {
                m45645a(it.next(), z, z2, z3);
            }
        }
    }

    /* renamed from: e */
    public final int mo182557e() {
        return Selection.getSelectionStart(this);
    }

    /* renamed from: f */
    public final int mo182558f() {
        return Selection.getSelectionEnd(this);
    }

    /* renamed from: g */
    public final int mo182559g() {
        return BaseInputConnection.getComposingSpanStart(this);
    }

    /* renamed from: h */
    public final int mo182560h() {
        return BaseInputConnection.getComposingSpanEnd(this);
    }

    public void setSpan(Object obj, int i, int i2, int i3) {
        super.setSpan(obj, i, i2, i3);
        this.f60554f.add(new TextEditingDelta(toString(), mo182557e(), mo182558f(), mo182559g(), mo182560h()));
    }

    public String toString() {
        String str = this.f60555g;
        if (str != null) {
            return str;
        }
        String spannableStringBuilder = super.toString();
        this.f60555g = spannableStringBuilder;
        return spannableStringBuilder;
    }
}
