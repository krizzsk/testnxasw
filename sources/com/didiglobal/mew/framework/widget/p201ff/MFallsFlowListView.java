package com.didiglobal.mew.framework.widget.p201ff;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: com.didiglobal.mew.framework.widget.ff.MFallsFlowListView */
public class MFallsFlowListView extends RecyclerView {

    /* renamed from: a */
    private Context f52786a;

    public MFallsFlowListView(Context context) {
        super(context);
        m39625a(context, (AttributeSet) null, 0);
    }

    public MFallsFlowListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m39625a(context, attributeSet, 0);
    }

    public MFallsFlowListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m39625a(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m39625a(Context context, AttributeSet attributeSet, int i) {
        this.f52786a = context;
        setNestedScrollingEnabled(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(1);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        setLayoutManager(linearLayoutManager);
    }

    public void setAlignBottom(boolean z) {
        LinearLayoutManager linearLayoutManager;
        if (z) {
            linearLayoutManager = new LinearLayoutManager(this.f52786a, 1, false);
            linearLayoutManager.setStackFromEnd(true);
        } else {
            linearLayoutManager = new LinearLayoutManager(this.f52786a);
            linearLayoutManager.setOrientation(1);
        }
        setLayoutManager(linearLayoutManager);
    }
}
