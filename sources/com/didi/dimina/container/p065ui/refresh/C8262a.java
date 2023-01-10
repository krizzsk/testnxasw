package com.didi.dimina.container.p065ui.refresh;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.dimina.container.util.LogUtil;

/* renamed from: com.didi.dimina.container.ui.refresh.a */
/* compiled from: ScrollUtil */
class C8262a {
    C8262a() {
    }

    /* renamed from: a */
    public static boolean m16601a(View view) {
        if (view instanceof AdapterView) {
            AdapterView adapterView = (AdapterView) view;
            if (adapterView.getFirstVisiblePosition() != 0 || (adapterView.getFirstVisiblePosition() == 0 && adapterView.getChildAt(0) != null && adapterView.getChildAt(0).getTop() < 0)) {
                return true;
            }
        } else if (view.getScrollY() > 0) {
            return true;
        }
        if (!(view instanceof RecyclerView)) {
            return false;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        View childAt = recyclerView.getChildAt(0);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
        LogUtil.m16841i("----:top" + childAt.getTop() + "");
        if (childAdapterPosition == 0 && childAt.getTop() == 0) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static View m16600a(ViewGroup viewGroup) {
        View childAt = viewGroup.getChildAt(1);
        if ((childAt instanceof RecyclerView) || (childAt instanceof AdapterView) || !(childAt instanceof ViewGroup)) {
            return childAt;
        }
        View childAt2 = ((ViewGroup) childAt).getChildAt(0);
        return ((childAt2 instanceof RecyclerView) || (childAt2 instanceof AdapterView)) ? childAt2 : childAt;
    }
}
