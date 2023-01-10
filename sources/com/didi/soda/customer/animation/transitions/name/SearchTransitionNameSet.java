package com.didi.soda.customer.animation.transitions.name;

import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;

public final class SearchTransitionNameSet {

    /* renamed from: a */
    private static String f42874a;

    private SearchTransitionNameSet() {
    }

    public static String getNormalTransitionName() {
        if (f42874a == null) {
            f42874a = ResourceHelper.getString(R.string.customer_transition_tag_search_home_search_box);
        }
        return f42874a;
    }
}
