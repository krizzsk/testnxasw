package com.didi.app.nova.support.view.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.data.BaseDataManager;
import com.didi.app.nova.support.view.recyclerview.util.RecyclerDataParser;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class NovaRecyclerAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f10425a = 1;

    /* renamed from: b */
    private List<BaseDataManager> f10426b = new ArrayList();

    /* renamed from: c */
    private List<BaseDataManager> f10427c = new ArrayList();

    /* renamed from: d */
    private List<ItemBinder> f10428d = new ArrayList();

    /* renamed from: e */
    private int f10429e = 1;

    /* renamed from: f */
    private INovaRecyclerView.LoadMoreListener f10430f;

    /* renamed from: g */
    private final GridLayoutManager.SpanSizeLookup f10431g = new GridLayoutManager.SpanSizeLookup() {
        public int getSpanSize(int i) {
            return NovaRecyclerAdapter.this.f10425a / NovaRecyclerAdapter.this.getBinderForPosition(i).getColumnCount();
        }
    };

    public final ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return this.f10428d.get(i).create(LayoutInflater.from(viewGroup.getContext()), viewGroup);
    }

    public final void onBindViewHolder(ItemViewHolder itemViewHolder, int i) {
        INovaRecyclerView.LoadMoreListener loadMoreListener;
        itemViewHolder.itemView.setTag(R.id.nova_support_nova_recycler_view_tag, itemViewHolder);
        this.f10428d.get(itemViewHolder.getItemViewType()).bindViewHolder(itemViewHolder, getItem(i), getItemPositionInDataManager(i));
        if (this.f10429e > 1 && getItemCount() > this.f10429e && i == getItemCount() - this.f10429e && (loadMoreListener = this.f10430f) != null) {
            loadMoreListener.onLoadMore();
        }
    }

    public void onViewRecycled(ItemViewHolder itemViewHolder) {
        this.f10428d.get(itemViewHolder.getItemViewType()).onRecycled(itemViewHolder);
        super.onViewRecycled(itemViewHolder);
    }

    public final int getItemCount() {
        int i = 0;
        for (BaseDataManager count : this.f10426b) {
            i += count.getCount();
        }
        return i;
    }

    public final int getItemViewType(int i) {
        ItemBinder binderForPosition = getBinderForPosition(i);
        if (binderForPosition != null) {
            return this.f10428d.indexOf(binderForPosition);
        }
        return super.getItemViewType(i);
    }

    public final void addDataManager(BaseDataManager baseDataManager) {
        this.f10426b.add(m9092a(), baseDataManager);
        notifyDataSetChanged();
    }

    public final void addDataManagers(BaseDataManager... baseDataManagerArr) {
        for (BaseDataManager add : baseDataManagerArr) {
            this.f10426b.add(m9092a(), add);
        }
        notifyDataSetChanged();
    }

    public final void addDataManagers(List<BaseDataManager> list) {
        this.f10426b.addAll(m9092a(), list);
        notifyDataSetChanged();
    }

    public final void addDataManagersWithoutNotify(List<BaseDataManager> list) {
        this.f10426b.addAll(m9092a(), list);
    }

    public void setPreLoadNumber(int i) {
        this.f10429e = Math.max(1, i);
    }

    public void setPreLoadMoreListener(INovaRecyclerView.LoadMoreListener loadMoreListener) {
        this.f10430f = loadMoreListener;
    }

    /* renamed from: a */
    private int m9092a() {
        return this.f10426b.size() - this.f10427c.size();
    }

    public final void addFootDataManager(BaseDataManager baseDataManager) {
        this.f10426b.add(baseDataManager);
        this.f10427c.add(baseDataManager);
        notifyDataSetChanged();
    }

    public final void clearDataManagers() {
        this.f10426b.clear();
        this.f10427c.clear();
        notifyDataSetChanged();
    }

    public final void registerBinder(ItemBinder itemBinder) {
        if (!this.f10428d.contains(itemBinder)) {
            this.f10428d.add(itemBinder);
        }
    }

    public List<ItemBinder> getRegisteredBinderList() {
        return this.f10428d;
    }

    /* renamed from: b */
    private int m9094b() {
        int i = 1;
        for (ItemBinder columnCount : this.f10428d) {
            i *= columnCount.getColumnCount();
        }
        return i;
    }

    public final GridLayoutManager.SpanSizeLookup getSpanSizeLookup() {
        return this.f10431g;
    }

    public final int getSpanCount() {
        int b = m9094b();
        this.f10425a = b;
        return b;
    }

    public void moveData(int i, int i2) {
        BaseDataManager dataManager;
        BaseDataManager dataManager2;
        if (i >= 0 && i2 >= 0 && (dataManager = getDataManager(i)) == (dataManager2 = getDataManager(i2))) {
            int itemPositionInDataManager = getItemPositionInDataManager(i);
            int itemPositionInDataManager2 = getItemPositionInDataManager(i2);
            if (dataManager.equals(dataManager2)) {
                dataManager.move(itemPositionInDataManager, itemPositionInDataManager2);
            }
        }
    }

    public <T> T getItem(int i) {
        return RecyclerDataParser.getItemForPosition(this.f10426b, i);
    }

    public <T extends BaseDataManager> T getDataManager(int i) {
        return RecyclerDataParser.getDataManagerForPosition(this.f10426b, i);
    }

    public ItemBinder getBinderForPosition(int i) {
        return RecyclerDataParser.getBinderForPosition(this.f10426b, this.f10428d, i);
    }

    public int getItemPositionInDataManager(int i) {
        return RecyclerDataParser.getPositionInDataManager(this.f10426b, i);
    }

    public int getItemPositionForItem(Object obj) {
        return RecyclerDataParser.getPositionForItem(this.f10426b, obj);
    }

    public final void notifyBinderItemRangeChanged(BaseDataManager baseDataManager, int i, int i2, Object obj) {
        notifyItemRangeChanged(RecyclerDataParser.getItemPositionInRV(this.f10426b, baseDataManager, i), i2, obj);
    }

    public final void notifyBinderItemMoved(BaseDataManager baseDataManager, int i, int i2) {
        notifyItemMoved(RecyclerDataParser.getItemPositionInRV(this.f10426b, baseDataManager, i), RecyclerDataParser.getItemPositionInRV(this.f10426b, baseDataManager, i2));
    }

    public final void notifyBinderItemRangeInserted(BaseDataManager baseDataManager, int i, int i2) {
        notifyItemRangeInserted(RecyclerDataParser.getItemPositionInRV(this.f10426b, baseDataManager, i), i2);
    }

    public final void notifyBinderItemRangeRemoved(BaseDataManager baseDataManager, int i, int i2) {
        notifyItemRangeRemoved(RecyclerDataParser.getItemPositionInRV(this.f10426b, baseDataManager, i), i2);
    }
}
