package com.didi.map.global.component.trafficreport.view.recycler;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.common.map.util.CollectionUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class ReportEventAdapter<G, GVH extends RecyclerView.ViewHolder, CVH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter {
    public static final int INVALID_POSITION = -1;
    private List<G> mGroups;
    private int mItemCount;
    /* access modifiers changed from: private */
    public OnChildClickListener mOnChildClickListener;

    public interface OnChildClickListener {
        void onChildClick(View view, int i, int i2);
    }

    public static class Position {
        public int child = -1;
        public int group;
    }

    /* access modifiers changed from: protected */
    public abstract int getChildCount(G g);

    /* access modifiers changed from: protected */
    public abstract void onBindChildViewHolder(CVH cvh, int i, int i2);

    /* access modifiers changed from: protected */
    public abstract void onBindGroupViewHolder(GVH gvh, int i);

    /* access modifiers changed from: protected */
    public abstract CVH onCreateChildViewHolder(ViewGroup viewGroup, int i);

    /* access modifiers changed from: protected */
    public abstract GVH onCreateGroupViewHolder(ViewGroup viewGroup);

    public ReportEventAdapter(List<G> list) {
        this.mGroups = list == null ? new ArrayList<>() : list;
        updateItemCount();
    }

    public void setOnChildClickListener(OnChildClickListener onChildClickListener) {
        this.mOnChildClickListener = onChildClickListener;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == ItemType.GROUP_TITLE.value) {
            return onCreateGroupViewHolder(viewGroup);
        }
        final RecyclerView.ViewHolder onCreateChildViewHolder = onCreateChildViewHolder(viewGroup, i);
        if (this.mOnChildClickListener != null) {
            onCreateChildViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (ReportEventAdapter.this.mOnChildClickListener != null) {
                        Position groupChildPosition = ReportEventAdapter.this.getGroupChildPosition(onCreateChildViewHolder.getAdapterPosition());
                        ReportEventAdapter.this.mOnChildClickListener.onChildClick(view, groupChildPosition.group, groupChildPosition.child);
                    }
                }
            });
        }
        return onCreateChildViewHolder;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Position groupChildPosition = getGroupChildPosition(i);
        if (groupChildPosition.child == -1) {
            onBindGroupViewHolder(viewHolder, groupChildPosition.group);
        } else {
            onBindChildViewHolder(viewHolder, groupChildPosition.group, groupChildPosition.child);
        }
    }

    public Position getGroupChildPosition(int i) {
        if (CollectionUtil.isEmpty((Collection<?>) this.mGroups)) {
            return null;
        }
        int i2 = 0;
        Position position = new Position();
        for (G next : this.mGroups) {
            if (i == i2) {
                position.child = -1;
                return position;
            }
            i2++;
            int childCount = getChildCount(next);
            if (childCount > 0) {
                position.child = i - i2;
                if (position.child < childCount) {
                    return position;
                }
                i2 += childCount;
            }
            position.group++;
        }
        return position;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public int getItemViewType(int i) {
        ItemType itemType = getItemType(i);
        if (itemType != null) {
            return itemType.value;
        }
        return 0;
    }

    private void updateItemCount() {
        int i = 0;
        for (G childCount : this.mGroups) {
            i += getChildCount(childCount) + 1;
        }
        this.mItemCount = i;
    }

    public int getGroupCount() {
        return this.mGroups.size();
    }

    public void add(List<G> list) {
        int itemCount = getItemCount();
        addGroups(list);
        updateItemCount();
        notifyItemRangeInserted(itemCount, this.mItemCount - itemCount);
    }

    public void update(List<G> list) {
        this.mGroups.clear();
        addGroups(list);
        updateItemCount();
        notifyDataSetChanged();
    }

    private void addGroups(List<G> list) {
        if (list != null) {
            this.mGroups.addAll(list);
        }
    }

    public G getGroup(int i) {
        List<G> list = this.mGroups;
        if (list == null || i >= list.size()) {
            return null;
        }
        return this.mGroups.get(i);
    }

    public ItemType getItemType(int i) {
        if (CollectionUtil.isEmpty((Collection<?>) this.mGroups)) {
            return null;
        }
        int i2 = 0;
        for (G next : this.mGroups) {
            if (i == i2) {
                return ItemType.GROUP_TITLE;
            }
            int childCount = getChildCount(next);
            int i3 = i2 + 1;
            if (i != i3 || childCount == 0) {
                i2 = i3 + childCount;
                if (i == i2 - 1) {
                    return ItemType.END_CHILD;
                }
                if (i < i2) {
                    return ItemType.NOT_FIRST_CHILD;
                }
            } else if (childCount == 1) {
                return ItemType.ONLY_ONE_CHILD;
            } else {
                return ItemType.FIRST_CHILD;
            }
        }
        throw new IllegalStateException("Could not find item type for item position " + i);
    }

    public enum ItemType {
        GROUP_TITLE(1),
        FIRST_CHILD(2),
        NOT_FIRST_CHILD(3),
        END_CHILD(4),
        ONLY_ONE_CHILD(5);
        
        /* access modifiers changed from: private */
        public final int value;

        private ItemType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }
}
