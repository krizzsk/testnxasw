package com.didi.addressnew.framework.fragmentmarket.map.view.fuzzymatch;

import android.content.Context;
import android.view.View;

public class FuzzyMatchCardController {

    /* renamed from: a */
    FuzzyMatchCardCallback f9044a;

    /* renamed from: b */
    private Context f9045b;

    public FuzzyMatchCardController(Context context, FuzzyMatchCardCallback fuzzyMatchCardCallback) {
        this.f9045b = context;
        this.f9044a = fuzzyMatchCardCallback;
    }

    public View getView(int i) {
        if (i == 0) {
            return new FuzzyMatchCardView(this.f9045b, this.f9044a);
        }
        if (i != 1) {
            return null;
        }
        return new FuzzyMatchListView(this.f9045b, this.f9044a);
    }
}
