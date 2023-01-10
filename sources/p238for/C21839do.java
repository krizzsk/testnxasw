package p238for;

import p242if.C22006new;

/* renamed from: for.do */
/* compiled from: FlashComponent */
public final class C21839do {

    /* renamed from: a */
    private char f60013a;

    public C21839do(char c) {
        this.f60013a = c;
    }

    /* renamed from: a */
    private String m45165a() {
        char c = this.f60013a;
        if (c == '0') {
            return "⬛️";
        }
        if (c == '1') {
            return "⬜️";
        }
        if (c == 'b') {
            return "🟦";
        }
        if (c == 'c') {
            return "🎽";
        }
        if (c == 'g') {
            return "🟩";
        }
        if (c == 'm') {
            return "🟪";
        }
        if (c == 'r') {
            return "🟥";
        }
        if (c != 'y') {
            return null;
        }
        return "🟨";
    }

    /* renamed from: do */
    public int mo180485do() {
        return C22006new.m45186do(this.f60013a);
    }

    public String toString() {
        return m45165a() + this.f60013a;
    }
}
