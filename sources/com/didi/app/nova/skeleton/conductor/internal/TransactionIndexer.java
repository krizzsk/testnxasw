package com.didi.app.nova.skeleton.conductor.internal;

import android.os.Bundle;

public class TransactionIndexer {

    /* renamed from: a */
    private static final String f10243a = "TransactionIndexer.currentIndex";

    /* renamed from: b */
    private int f10244b;

    public int nextIndex() {
        int i = this.f10244b + 1;
        this.f10244b = i;
        return i;
    }

    public void saveInstanceState(Bundle bundle) {
        bundle.putInt(f10243a, this.f10244b);
    }

    public void restoreInstanceState(Bundle bundle) {
        this.f10244b = bundle.getInt(f10243a);
    }
}
