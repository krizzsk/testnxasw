package com.didi.soda.customer.coordshop.finder;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.mvp.loadmore.LoadMoreModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r*\u0002\u0007\n\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J \u0010\u0014\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0016J \u0010\u0017\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0016J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo148868d2 = {"Lcom/didi/soda/customer/coordshop/finder/FinderVisibleItem;", "Lcom/didi/soda/customer/coordshop/finder/IFinder;", "()V", "curFirstVisible", "", "curLastVisible", "onDataChanged", "com/didi/soda/customer/coordshop/finder/FinderVisibleItem$onDataChanged$1", "Lcom/didi/soda/customer/coordshop/finder/FinderVisibleItem$onDataChanged$1;", "onScrollListener", "com/didi/soda/customer/coordshop/finder/FinderVisibleItem$onScrollListener$1", "Lcom/didi/soda/customer/coordshop/finder/FinderVisibleItem$onScrollListener$1;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "checkVisible", "", "clear", "findFirstItemPosition", "findInRecycleView", "findLastItemPosition", "onScreenVisibleChanged", "visibleFirst", "visibleLast", "onVisibleRangeChanged", "lower", "upper", "refresh", "visibleRangeChanged", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FinderVisibleItem.kt */
public class FinderVisibleItem implements IFinder {

    /* renamed from: a */
    private int f43457a;

    /* renamed from: b */
    private int f43458b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public RecyclerView f43459c;

    /* renamed from: d */
    private FinderVisibleItem$onScrollListener$1 f43460d = new FinderVisibleItem$onScrollListener$1(this);

    /* renamed from: e */
    private FinderVisibleItem$onDataChanged$1 f43461e = new FinderVisibleItem$onDataChanged$1(this);

    public void onScreenVisibleChanged(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
    }

    public void findInRecycleView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.f43459c = recyclerView;
        recyclerView.addOnScrollListener(this.f43460d);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f43461e);
        }
    }

    /* renamed from: a */
    private final int m32521a(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        CustomerExtentionKt.safeThrow("协同店铺仅实现LinearLayoutManager，而传入layoutManager = lm");
        return -1;
    }

    /* renamed from: b */
    private final int m32523b(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        }
        CustomerExtentionKt.safeThrow("协同店铺仅实现LinearLayoutManager，而传入layoutManager = lm");
        return -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m32524c(RecyclerView recyclerView) {
        boolean z = false;
        int max = Math.max(m32521a(recyclerView), 0);
        int max2 = Math.max(m32523b(recyclerView), 0);
        if (max2 > this.f43458b) {
            this.f43458b = max2;
            z = true;
        }
        if (z) {
            m32525d(recyclerView);
        }
        onScreenVisibleChanged(recyclerView, max, max2);
    }

    /* renamed from: d */
    private final void m32525d(RecyclerView recyclerView) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        NovaRecyclerAdapter novaRecyclerAdapter = adapter instanceof NovaRecyclerAdapter ? (NovaRecyclerAdapter) adapter : null;
        if (novaRecyclerAdapter != null) {
            int i = this.f43458b;
            if (i >= 0 && i < novaRecyclerAdapter.getItemCount() && (novaRecyclerAdapter.getItem(i) instanceof LoadMoreModel)) {
                this.f43458b--;
            }
            onVisibleRangeChanged(recyclerView, this.f43457a, this.f43458b);
        }
    }

    public void onVisibleRangeChanged(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        LogUtil.m32584d("FindShopInfo", "curFirstVisible = " + i + " curLastVisible = " + i2);
    }

    public void clear() {
        RecyclerView.Adapter adapter;
        this.f43457a = 0;
        this.f43458b = 0;
        RecyclerView recyclerView = this.f43459c;
        if (recyclerView != null) {
            recyclerView.removeOnScrollListener(this.f43460d);
        }
        RecyclerView recyclerView2 = this.f43459c;
        if (!(recyclerView2 == null || (adapter = recyclerView2.getAdapter()) == null)) {
            adapter.unregisterAdapterDataObserver(this.f43461e);
        }
        this.f43459c = null;
    }

    public void refresh(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.f43457a = 0;
        this.f43458b = 0;
        recyclerView.post(new Runnable(recyclerView) {
            public final /* synthetic */ RecyclerView f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                FinderVisibleItem.m32522a(FinderVisibleItem.this, this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m32522a(FinderVisibleItem finderVisibleItem, RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(finderVisibleItem, "this$0");
        Intrinsics.checkNotNullParameter(recyclerView, "$recyclerView");
        finderVisibleItem.m32524c(recyclerView);
    }
}
