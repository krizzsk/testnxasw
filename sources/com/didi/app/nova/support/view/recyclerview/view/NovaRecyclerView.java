package com.didi.app.nova.support.view.recyclerview.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.MvpItemBinder;
import com.didi.app.nova.support.view.recyclerview.listener.ItemDragListener;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.helper.NovaItemTouchHelper;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.INovaLayoutManager;

public class NovaRecyclerView extends RecyclerView implements ItemDragListener, INovaRecyclerView {

    /* renamed from: a */
    private boolean f10452a = false;

    /* renamed from: b */
    private boolean f10453b = false;

    /* renamed from: c */
    private int f10454c = 1;

    /* renamed from: d */
    private boolean f10455d = false;

    /* renamed from: e */
    private INovaLayoutManager f10456e;

    /* renamed from: f */
    private NovaRecyclerAdapter f10457f;

    /* renamed from: g */
    private OnLoadMoreScrollListener f10458g;

    /* renamed from: h */
    private ItemTouchHelper f10459h;

    /* renamed from: i */
    private NovaItemTouchHelper f10460i;

    /* renamed from: j */
    private MvpItemBinder.NovaOnChildAttachStateChangeListener f10461j;

    /* renamed from: k */
    private MvpItemBinder.NovaRecyclerListener f10462k;

    /* renamed from: l */
    private ItemDecorationManager f10463l;

    public NovaRecyclerView(Context context) {
        super(context);
        m9134a();
    }

    public NovaRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9134a();
    }

    public NovaRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9134a();
    }

    /* renamed from: a */
    private void m9134a() {
        this.f10458g = new OnLoadMoreScrollListener();
        this.f10461j = new MvpItemBinder.NovaOnChildAttachStateChangeListener(this);
        this.f10462k = new MvpItemBinder.NovaRecyclerListener(this);
    }

    public void setNovaLayoutManager(INovaLayoutManager iNovaLayoutManager) {
        if (iNovaLayoutManager instanceof RecyclerView.LayoutManager) {
            setLayoutManager((RecyclerView.LayoutManager) iNovaLayoutManager);
            return;
        }
        throw new IllegalStateException("novaLayoutManager must be instance of LayoutManager");
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof INovaLayoutManager) {
            INovaLayoutManager iNovaLayoutManager = (INovaLayoutManager) layoutManager;
            this.f10456e = iNovaLayoutManager;
            NovaRecyclerAdapter novaRecyclerAdapter = this.f10457f;
            if (novaRecyclerAdapter != null) {
                iNovaLayoutManager.init(novaRecyclerAdapter);
            }
            super.setLayoutManager(layoutManager);
            return;
        }
        throw new IllegalStateException("NovaRecyclerView only accept INovaLayoutManager");
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        if (adapter instanceof NovaRecyclerAdapter) {
            NovaRecyclerAdapter novaRecyclerAdapter = (NovaRecyclerAdapter) adapter;
            this.f10457f = novaRecyclerAdapter;
            INovaLayoutManager iNovaLayoutManager = this.f10456e;
            if (iNovaLayoutManager != null) {
                iNovaLayoutManager.init(novaRecyclerAdapter);
            }
            super.setAdapter(this.f10457f);
            return;
        }
        throw new IllegalStateException("NovaRecyclerView only accept NovaRecyclerAdapter");
    }

    public void setFootLoadMoreEnable(boolean z) {
        if (this.f10453b != z) {
            this.f10453b = z;
            if (z) {
                removeOnScrollListener(this.f10458g);
                addOnScrollListener(this.f10458g);
                return;
            }
            removeOnScrollListener(this.f10458g);
        }
    }

    public boolean isScrollable() {
        INovaLayoutManager iNovaLayoutManager = this.f10456e;
        return iNovaLayoutManager != null && iNovaLayoutManager.findFirstCompletelyVisibleItemPosition() > 0;
    }

    public void setLoadMoreListener(INovaRecyclerView.LoadMoreListener loadMoreListener) {
        this.f10458g.setLoadMoreListener(loadMoreListener);
        this.f10457f.setPreLoadMoreListener(loadMoreListener);
    }

    public void setPreLoadNumber(int i) {
        this.f10454c = i;
        this.f10457f.setPreLoadNumber(i);
    }

    public boolean isAutoPreLoad() {
        return this.f10454c > 1;
    }

    public final ItemDecorationManager getItemDecorationManager() {
        if (this.f10463l == null) {
            this.f10463l = new ItemDecorationManager(this.f10457f);
        }
        return this.f10463l;
    }

    public void setItemDecorationEnable(boolean z) {
        if (this.f10452a != z) {
            if (z) {
                addItemDecoration(getItemDecorationManager());
            } else {
                removeItemDecoration(getItemDecorationManager());
            }
            this.f10452a = z;
        }
    }

    public void setItemTouchControlEnable(boolean z) {
        if (z) {
            if (this.f10460i == null) {
                this.f10460i = new NovaItemTouchHelper();
            }
            this.f10460i.attachToRecyclerView(this);
            return;
        }
        NovaItemTouchHelper novaItemTouchHelper = this.f10460i;
        if (novaItemTouchHelper != null) {
            novaItemTouchHelper.detachToRecyclerView();
        }
    }

    public void setItemDragEnable(boolean z) {
        if (z) {
            if (this.f10459h == null) {
                this.f10459h = new ItemTouchHelper(new C4344a(this.f10457f));
            }
            this.f10459h.attachToRecyclerView(this);
            return;
        }
        ItemTouchHelper itemTouchHelper = this.f10459h;
        if (itemTouchHelper != null) {
            itemTouchHelper.attachToRecyclerView((RecyclerView) null);
        }
    }

    public void setItemMvpEnable(boolean z) {
        if (this.f10455d != z) {
            this.f10455d = z;
            if (z) {
                addOnChildAttachStateChangeListener(this.f10461j);
                super.setRecyclerListener(this.f10462k);
            } else {
                removeOnChildAttachStateChangeListener(this.f10461j);
                if (!this.f10462k.hasRecyclerListener()) {
                    super.setRecyclerListener((RecyclerView.RecyclerListener) null);
                }
            }
            this.f10462k.setItemMvpEnable(z);
        }
    }

    public void setRecyclerListener(RecyclerView.RecyclerListener recyclerListener) {
        if (recyclerListener == null && !this.f10455d) {
            super.setRecyclerListener((RecyclerView.RecyclerListener) null);
        }
        this.f10462k.setRecyclerListener(recyclerListener);
        super.setRecyclerListener(this.f10462k);
    }

    public void smoothScrollToItem(Object obj) {
        int itemPositionForItem = this.f10457f.getItemPositionForItem(obj);
        if (itemPositionForItem >= 0) {
            super.smoothScrollToPosition(itemPositionForItem);
        }
    }

    public void scrollToItem(Object obj) {
        RecyclerView.LayoutManager layoutManager;
        int itemPositionForItem = this.f10457f.getItemPositionForItem(obj);
        if (itemPositionForItem >= 0 && (layoutManager = getLayoutManager()) != null) {
            layoutManager.scrollToPosition(itemPositionForItem);
        }
    }

    public void startDrag(ItemViewHolder itemViewHolder) {
        ItemTouchHelper itemTouchHelper = this.f10459h;
        if (itemTouchHelper != null) {
            itemTouchHelper.startDrag(itemViewHolder);
        }
    }

    private class OnLoadMoreScrollListener extends RecyclerView.OnScrollListener {
        private INovaRecyclerView.LoadMoreListener mLoadMoreListener;

        private OnLoadMoreScrollListener() {
        }

        /* access modifiers changed from: package-private */
        public void setLoadMoreListener(INovaRecyclerView.LoadMoreListener loadMoreListener) {
            this.mLoadMoreListener = loadMoreListener;
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (recyclerView.getLayoutManager().getChildCount() > 0 && i == 0 && canTriggerLoadMore(recyclerView)) {
                onLoadMore();
            }
        }

        private boolean canTriggerLoadMore(RecyclerView recyclerView) {
            if (recyclerView.getLayoutManager() instanceof INovaLayoutManager) {
                INovaLayoutManager iNovaLayoutManager = (INovaLayoutManager) recyclerView.getLayoutManager();
                return iNovaLayoutManager.getItemCount() - 1 == iNovaLayoutManager.findLastVisibleItemPosition();
            }
            throw new IllegalStateException("novaLayoutManager must be instance of LayoutManager");
        }

        public void onLoadMore() {
            INovaRecyclerView.LoadMoreListener loadMoreListener = this.mLoadMoreListener;
            if (loadMoreListener != null) {
                loadMoreListener.onLoadMore();
            }
        }
    }
}
