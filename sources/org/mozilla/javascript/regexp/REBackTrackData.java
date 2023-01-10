package org.mozilla.javascript.regexp;

/* compiled from: NativeRegExp */
class REBackTrackData {
    final int continuationOp;
    final int continuationPc;

    /* renamed from: cp */
    final int f8492cp;

    /* renamed from: op */
    final int f8493op;
    final long[] parens;

    /* renamed from: pc */
    final int f8494pc;
    final REBackTrackData previous;
    final REProgState stateStackTop;

    REBackTrackData(REGlobalData rEGlobalData, int i, int i2, int i3, int i4, int i5) {
        this.previous = rEGlobalData.backTrackStackTop;
        this.f8493op = i;
        this.f8494pc = i2;
        this.f8492cp = i3;
        this.continuationOp = i4;
        this.continuationPc = i5;
        this.parens = rEGlobalData.parens;
        this.stateStackTop = rEGlobalData.stateStackTop;
    }
}
