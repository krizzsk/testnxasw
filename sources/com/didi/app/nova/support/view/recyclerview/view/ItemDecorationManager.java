package com.didi.app.nova.support.view.recyclerview.view;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.data.BaseDataManager;

public class ItemDecorationManager extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private final NovaRecyclerAdapter f10451a;

    /* renamed from: a */
    private int m9125a(int i, int i2, boolean z) {
        boolean z2 = true;
        if (i2 == 1) {
            return 80;
        }
        boolean z3 = i == i2 - 1;
        boolean z4 = z ? z3 : i == 0;
        if (!z) {
            z2 = z3;
        } else if (i != 0) {
            z2 = false;
        }
        if (z4) {
            return 16;
        }
        return z2 ? 64 : 32;
    }

    public ItemDecorationManager(NovaRecyclerAdapter novaRecyclerAdapter) {
        this.f10451a = novaRecyclerAdapter;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        ItemBinder c;
        boolean a = m9129a(recyclerView);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition >= 0 && (c = m9133c(childAdapterPosition)) != null && c.isItemDecorationEnabled()) {
            int a2 = m9124a(recyclerView.getChildAdapterPosition(view));
            c.getItemOffsets(rect, a2, m9126a(recyclerView, childAdapterPosition, a2, m9131b(childAdapterPosition).size(), a));
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        m9127a(canvas, recyclerView, false);
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        m9127a(canvas, recyclerView, true);
    }

    /* renamed from: a */
    private void m9127a(Canvas canvas, RecyclerView recyclerView, boolean z) {
        boolean a = m9129a(recyclerView);
        int childCount = recyclerView.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = recyclerView.getChildAt(i);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
            if (childAdapterPosition >= 0) {
                ItemBinder c = m9133c(childAdapterPosition);
                if (c != null && c.isItemDecorationEnabled()) {
                    int a2 = m9124a(childAdapterPosition);
                    int a3 = m9126a(recyclerView, childAdapterPosition, a2, m9131b(childAdapterPosition).size(), a);
                    if (z) {
                        c.onDrawOver(canvas, recyclerView, childAt, a2, a3);
                    } else {
                        c.onDraw(canvas, recyclerView, childAt, a2, a3);
                    }
                }
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private boolean m9129a(RecyclerView recyclerView) {
        return (recyclerView.getLayoutManager() instanceof LinearLayoutManager) && ((LinearLayoutManager) recyclerView.getLayoutManager()).getReverseLayout();
    }

    /* renamed from: a */
    private int m9126a(RecyclerView recyclerView, int i, int i2, int i3, boolean z) {
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            return m9130b(recyclerView, i2, i, i3, z);
        }
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            return m9125a(i2, i3, z);
        }
        if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
            return m9132c(recyclerView, i2, i, i3, z);
        }
        return 0;
    }

    /* renamed from: b */
    private int m9130b(RecyclerView recyclerView, int i, int i2, int i3, boolean z) {
        int i4;
        boolean z2;
        int i5;
        int i6 = i2;
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        int spanCount = gridLayoutManager.getSpanCount();
        int i7 = i6 - i;
        boolean z3 = true;
        int i8 = i7;
        int i9 = 0;
        int i10 = 0;
        while (i8 <= i6) {
            int spanSize = gridLayoutManager.getSpanSizeLookup().getSpanSize(i8);
            int i11 = i10 + spanSize;
            if (i11 > spanCount) {
                i4 = spanSize;
                z2 = false;
            } else {
                z2 = z3;
                i4 = i11;
            }
            if (i8 == i6) {
                if (i4 - spanSize == 0) {
                    i9 |= 1;
                }
                if (i4 == spanCount) {
                    i9 |= 4;
                }
                int i12 = 8;
                if (z2) {
                    i5 = (z ? 8 : 2) | i9;
                } else {
                    i5 = i9;
                }
                if (m9128a(gridLayoutManager, i2, i7 + i3, i4, spanCount)) {
                    if (z) {
                        i12 = 2;
                    }
                    i9 = i5 | i12;
                } else {
                    i9 = i5;
                }
            }
            i8++;
            z3 = z2;
            i10 = i4;
        }
        return i9;
    }

    /* renamed from: c */
    private int m9132c(RecyclerView recyclerView, int i, int i2, int i3, boolean z) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
        int spanCount = staggeredGridLayoutManager.getSpanCount();
        View findViewByPosition = staggeredGridLayoutManager.findViewByPosition(i2);
        if (findViewByPosition != null && (findViewByPosition.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams)) {
            StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) findViewByPosition.getLayoutParams();
            if (layoutParams.getSpanIndex() != -1) {
                if (layoutParams.getSpanIndex() % spanCount == 0) {
                    return 1;
                }
                if (layoutParams.getSpanIndex() % spanCount == spanCount - 1) {
                    return 4;
                }
            }
        }
        return 0;
    }

    /* renamed from: a */
    private boolean m9128a(GridLayoutManager gridLayoutManager, int i, int i2, int i3, int i4) {
        for (int i5 = i + 1; i5 < i2; i5++) {
            i3 += gridLayoutManager.getSpanSizeLookup().getSpanSize(i5);
            if (i3 > i4) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private int m9124a(int i) {
        return this.f10451a.getItemPositionInDataManager(i);
    }

    /* renamed from: b */
    private BaseDataManager m9131b(int i) {
        return this.f10451a.getDataManager(i);
    }

    /* renamed from: c */
    private ItemBinder m9133c(int i) {
        return this.f10451a.getBinderForPosition(i);
    }
}
