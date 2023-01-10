package com.didiglobal.mew.framework.widget.p201ff;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didiglobal.mew.framework.widget.ff.MFallsFlow */
public class MFallsFlow extends RelativeLayout {

    /* renamed from: a */
    private MFallsFlowScrollView f52775a;

    /* renamed from: b */
    private MFallsFlowHeader f52776b;

    /* renamed from: c */
    private MFallsFlowListView f52777c;

    /* renamed from: d */
    private RelativeLayout f52778d;

    /* renamed from: e */
    private MFFAdapter f52779e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ViewGroup.OnHierarchyChangeListener f52780f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public NestedScrollView.OnScrollChangeListener f52781g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public RecyclerView.OnScrollListener f52782h;

    /* renamed from: i */
    private RecyclerView.OnScrollListener f52783i = new RecyclerView.OnScrollListener() {
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (MFallsFlow.this.f52782h != null) {
                MFallsFlow.this.f52782h.onScrollStateChanged(recyclerView, i);
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (MFallsFlow.this.f52782h != null) {
                MFallsFlow.this.f52782h.onScrolled(recyclerView, i, i2);
            }
        }
    };

    /* renamed from: j */
    private ViewGroup.OnHierarchyChangeListener f52784j = new ViewGroup.OnHierarchyChangeListener() {
        public void onChildViewAdded(View view, View view2) {
            if (MFallsFlow.this.f52780f != null) {
                MFallsFlow.this.f52780f.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            if (MFallsFlow.this.f52780f != null) {
                MFallsFlow.this.f52780f.onChildViewAdded(view, view2);
            }
        }
    };

    /* renamed from: k */
    private NestedScrollView.OnScrollChangeListener f52785k = new NestedScrollView.OnScrollChangeListener() {
        public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
            if (MFallsFlow.this.f52781g != null) {
                MFallsFlow.this.f52781g.onScrollChange(nestedScrollView, i, i2, i3, i4);
            }
        }
    };

    public MFallsFlow(Context context) {
        super(context);
        m39621a(context, (AttributeSet) null, 0);
    }

    public MFallsFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m39621a(context, attributeSet, 0);
    }

    public MFallsFlow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m39621a(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m39621a(Context context, AttributeSet attributeSet, int i) {
        View.inflate(context, R.layout.mew_widget_falls_flow, this);
        this.f52775a = (MFallsFlowScrollView) findViewById(R.id.mew_falls_flow_scroll_view);
        this.f52776b = (MFallsFlowHeader) findViewById(R.id.mew_falls_flow_header);
        this.f52777c = (MFallsFlowListView) findViewById(R.id.mew_falls_flow_list_view);
        this.f52778d = (RelativeLayout) findViewById(R.id.mew_falls_flow_list_view_bg);
        this.f52775a.setOnScrollChangeListener(this.f52785k);
        this.f52777c.addOnScrollListener(this.f52783i);
        this.f52776b.setOnHierarchyChangeListener(this.f52784j);
        MFFAdapter mFFAdapter = new MFFAdapter();
        this.f52779e = mFFAdapter;
        this.f52777c.setAdapter(mFFAdapter);
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener, NestedScrollView.OnScrollChangeListener onScrollChangeListener) {
        this.f52782h = onScrollListener;
        this.f52781g = onScrollChangeListener;
    }

    public void setHeaderViewChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f52780f = onHierarchyChangeListener;
    }

    public void initHeaderView(View view) {
        this.f52776b.removeAllViews();
        this.f52776b.addView(view);
    }

    public void setAlignBottom(boolean z) {
        this.f52777c.setAlignBottom(z);
    }

    public void setListViewElevation(int i, int i2) {
        this.f52779e.setElevation(i, i2);
    }

    public void setHeaderViewBgColor(int i) {
        this.f52776b.setBackgroundColor(i);
    }

    public void setVisibility(boolean z) {
        this.f52776b.setVisibility(z ? 0 : 8);
    }

    public void setOverlapSpace(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f52778d.getLayoutParams();
        layoutParams.topMargin = i;
        this.f52778d.setLayoutParams(layoutParams);
    }

    public void clear() {
        this.f52779e.clear();
    }

    public void setData(List<MFFCardProperty> list) {
        this.f52779e.setCardPropertyList(list);
    }

    public void addData(List<MFFCardProperty> list) {
        this.f52779e.addCardPropertyList(list);
    }

    public void addData(int i, MFFCardProperty mFFCardProperty) {
        this.f52779e.addCardProperty(i, mFFCardProperty);
    }
}
