package com.didi.global.fintech.cashier.p118ui.widget.tickerview;

import com.didi.global.fintech.cashier.p118ui.widget.tickerview.TickerView;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.didi.global.fintech.cashier.ui.widget.tickerview.TickerCharacterList */
public class TickerCharacterList {

    /* renamed from: a */
    private final int f23874a;

    /* renamed from: b */
    private final char[] f23875b;

    /* renamed from: c */
    private final Map<Character, Integer> f23876c;

    TickerCharacterList(String str) {
        int i = 0;
        if (!str.contains(Character.toString(0))) {
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            this.f23874a = length;
            this.f23876c = new HashMap(length);
            for (int i2 = 0; i2 < length; i2++) {
                this.f23876c.put(Character.valueOf(charArray[i2]), Integer.valueOf(i2));
            }
            char[] cArr = new char[((length * 2) + 1)];
            this.f23875b = cArr;
            cArr[0] = 0;
            while (i < length) {
                char[] cArr2 = this.f23875b;
                int i3 = i + 1;
                cArr2[i3] = charArray[i];
                cArr2[length + 1 + i] = charArray[i];
                i = i3;
            }
            return;
        }
        throw new IllegalArgumentException("You cannot include TickerUtils.EMPTY_CHAR in the character list.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public CharacterIndices mo71418a(char c, char c2, TickerView.ScrollingDirection scrollingDirection) {
        int a = m19343a(c);
        int a2 = m19343a(c2);
        if (a < 0 || a2 < 0) {
            return null;
        }
        int i = C91131.f23877xcb589ba8[scrollingDirection.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (!(i != 3 || c == 0 || c2 == 0)) {
                    if (a2 < a) {
                        int i2 = a - a2;
                        int i3 = this.f23874a;
                        if ((i3 - a) + a2 < i2) {
                            a2 += i3;
                        }
                    } else if (a < a2) {
                        int i4 = a2 - a;
                        int i5 = this.f23874a;
                        if ((i5 - a2) + a < i4) {
                            a += i5;
                        }
                    }
                }
            } else if (a < a2) {
                a += this.f23874a;
            }
        } else if (c2 == 0) {
            a2 = this.f23875b.length;
        } else if (a2 < a) {
            a2 += this.f23874a;
        }
        return new CharacterIndices(a, a2);
    }

    /* renamed from: com.didi.global.fintech.cashier.ui.widget.tickerview.TickerCharacterList$1 */
    static /* synthetic */ class C91131 {

        /* renamed from: $SwitchMap$com$didi$global$fintech$cashier$ui$widget$tickerview$TickerView$ScrollingDirection */
        static final /* synthetic */ int[] f23877xcb589ba8;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didi.global.fintech.cashier.ui.widget.tickerview.TickerView$ScrollingDirection[] r0 = com.didi.global.fintech.cashier.p118ui.widget.tickerview.TickerView.ScrollingDirection.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23877xcb589ba8 = r0
                com.didi.global.fintech.cashier.ui.widget.tickerview.TickerView$ScrollingDirection r1 = com.didi.global.fintech.cashier.p118ui.widget.tickerview.TickerView.ScrollingDirection.DOWN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23877xcb589ba8     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.global.fintech.cashier.ui.widget.tickerview.TickerView$ScrollingDirection r1 = com.didi.global.fintech.cashier.p118ui.widget.tickerview.TickerView.ScrollingDirection.UP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f23877xcb589ba8     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.global.fintech.cashier.ui.widget.tickerview.TickerView$ScrollingDirection r1 = com.didi.global.fintech.cashier.p118ui.widget.tickerview.TickerView.ScrollingDirection.ANY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.p118ui.widget.tickerview.TickerCharacterList.C91131.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Set<Character> mo71419a() {
        return this.f23876c.keySet();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public char[] mo71420b() {
        return this.f23875b;
    }

    /* renamed from: a */
    private int m19343a(char c) {
        if (c == 0) {
            return 0;
        }
        if (this.f23876c.containsKey(Character.valueOf(c))) {
            return this.f23876c.get(Character.valueOf(c)).intValue() + 1;
        }
        return -1;
    }

    /* renamed from: com.didi.global.fintech.cashier.ui.widget.tickerview.TickerCharacterList$CharacterIndices */
    static class CharacterIndices {
        final int endIndex;
        final int startIndex;

        public CharacterIndices(int i, int i2) {
            this.startIndex = i;
            this.endIndex = i2;
        }
    }
}
