package com.didi.map.global.component.trafficreport.view.recycler;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.common.map.util.CollectionUtil;
import com.didi.map.global.component.trafficreport.model.MapEntryItem;
import com.didi.map.global.component.trafficreport.model.RemarkItem;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class ReportDetailAdapter<G, GVH extends RecyclerView.ViewHolder, CVH extends RecyclerView.ViewHolder, MapEntryVH extends RecyclerView.ViewHolder, RemarkVH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter {
    public static final int INVALID_POSITION = -1;
    private static final String TAG = "ReportDetailAdapter";
    protected List<G> mGroups;
    private int mItemCount;
    private MapEntryItem mMapEntry;
    /* access modifiers changed from: private */
    public OnChildClickListener mOnChildClickListener;
    /* access modifiers changed from: private */
    public OnMapEntryClickListener mOnMapEntryClickListener;
    /* access modifiers changed from: private */
    public OnRemarkClickListener mOnRemarkClickListener;
    private RemarkItem mRemark;

    public interface OnChildClickListener {
        void onChildClick(View view, int i, int i2);
    }

    public interface OnMapEntryClickListener {
        void onMapEntryClick();
    }

    public interface OnRemarkClickListener {
        void onRemarkClick();
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
    public abstract void onBindMapEntryViewHolder(MapEntryVH mapentryvh, Address address);

    /* access modifiers changed from: protected */
    public abstract void onBindRemarkViewHolder(RemarkVH remarkvh, int i);

    /* access modifiers changed from: protected */
    public abstract CVH onCreateChildViewHolder(ViewGroup viewGroup, int i);

    /* access modifiers changed from: protected */
    public abstract GVH onCreateGroupViewHolder(ViewGroup viewGroup);

    /* access modifiers changed from: protected */
    public abstract MapEntryVH onCreateMapEntryViewHolder(ViewGroup viewGroup);

    /* access modifiers changed from: protected */
    public abstract RemarkVH onCreateRemarkViewHolder(ViewGroup viewGroup);

    public ReportDetailAdapter(List<G> list, MapEntryItem mapEntryItem, RemarkItem remarkItem) {
        this.mGroups = list == null ? new ArrayList<>() : list;
        this.mMapEntry = mapEntryItem;
        this.mRemark = remarkItem;
        updateItemCount();
    }

    public OnChildClickListener getOnChildClickListener() {
        return this.mOnChildClickListener;
    }

    public void setOnChildClickListener(OnChildClickListener onChildClickListener) {
        this.mOnChildClickListener = onChildClickListener;
    }

    public OnMapEntryClickListener getOnMapEntryClickListener() {
        return this.mOnMapEntryClickListener;
    }

    public void setOnMapEntryClickListener(OnMapEntryClickListener onMapEntryClickListener) {
        this.mOnMapEntryClickListener = onMapEntryClickListener;
    }

    public OnRemarkClickListener getOnRemarkClickListener() {
        return this.mOnRemarkClickListener;
    }

    public void setOnRemarkClickListener(OnRemarkClickListener onRemarkClickListener) {
        this.mOnRemarkClickListener = onRemarkClickListener;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        SystemUtils.log(3, TAG, "onCreateViewHolder: " + i, (Throwable) null, "com.didi.map.global.component.trafficreport.view.recycler.ReportDetailAdapter", 72);
        if (i == ItemType.MAP_ENTRY.value) {
            RecyclerView.ViewHolder onCreateMapEntryViewHolder = onCreateMapEntryViewHolder(viewGroup);
            if (this.mOnMapEntryClickListener != null) {
                onCreateMapEntryViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (ReportDetailAdapter.this.mOnMapEntryClickListener != null) {
                            ReportDetailAdapter.this.mOnMapEntryClickListener.onMapEntryClick();
                        }
                    }
                });
            }
            return onCreateMapEntryViewHolder;
        } else if (i == ItemType.GROUP_TITLE.value) {
            return onCreateGroupViewHolder(viewGroup);
        } else {
            if (i == ItemType.REMARK.value) {
                RecyclerView.ViewHolder onCreateRemarkViewHolder = onCreateRemarkViewHolder(viewGroup);
                if (this.mOnRemarkClickListener != null) {
                    onCreateRemarkViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            if (ReportDetailAdapter.this.mOnRemarkClickListener != null) {
                                ReportDetailAdapter.this.mOnRemarkClickListener.onRemarkClick();
                            }
                        }
                    });
                }
                return onCreateRemarkViewHolder;
            }
            final RecyclerView.ViewHolder onCreateChildViewHolder = onCreateChildViewHolder(viewGroup, i);
            if (this.mOnChildClickListener != null) {
                onCreateChildViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Position position;
                        AutoTrackHelper.trackViewOnClick(view);
                        if (ReportDetailAdapter.this.mOnChildClickListener != null && (position = ReportDetailAdapter.this.getPosition(onCreateChildViewHolder.getAdapterPosition())) != null) {
                            ReportDetailAdapter.this.mOnChildClickListener.onChildClick(view, position.group, position.child);
                        }
                    }
                });
            }
            return onCreateChildViewHolder;
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (i == 0) {
            onBindMapEntryViewHolder(viewHolder, (Address) null);
        } else if (i == getItemCount() - 1) {
            onBindRemarkViewHolder(viewHolder, i);
        } else {
            Position position = getPosition(i);
            if (position == null) {
                return;
            }
            if (position.child == -1) {
                onBindGroupViewHolder(viewHolder, position.group);
            } else {
                onBindChildViewHolder(viewHolder, position.group, position.child);
            }
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        if (list.isEmpty()) {
            onBindViewHolder(viewHolder, i);
        }
    }

    public int getItemCount() {
        SystemUtils.log(3, TAG, "getItemCount: " + this.mItemCount, (Throwable) null, "com.didi.map.global.component.trafficreport.view.recycler.ReportDetailAdapter", 151);
        return this.mItemCount;
    }

    public int getItemViewType(int i) {
        return getItemType(i).value;
    }

    private void updateItemCount() {
        int i = 0;
        for (G childCount : this.mGroups) {
            i += getChildCount(childCount) + 1;
        }
        this.mItemCount = i + 2;
    }

    public G getGroup(int i) {
        if (!CollectionUtil.isEmpty((Collection<?>) this.mGroups)) {
            return this.mGroups.get(i);
        }
        return null;
    }

    public ItemType getItemType(int i) {
        if (i == 0) {
            SystemUtils.log(3, TAG, "getItemType: " + ItemType.MAP_ENTRY, (Throwable) null, "com.didi.map.global.component.trafficreport.view.recycler.ReportDetailAdapter", 180);
            return ItemType.MAP_ENTRY;
        }
        int i2 = 1;
        for (G next : this.mGroups) {
            if (i == i2) {
                SystemUtils.log(3, TAG, "getItemType: " + ItemType.GROUP_TITLE + ", " + i, (Throwable) null, "com.didi.map.global.component.trafficreport.view.recycler.ReportDetailAdapter", 185);
                return ItemType.GROUP_TITLE;
            }
            int childCount = getChildCount(next);
            int i3 = i2 + 1;
            if (i != i3 || childCount == 0) {
                i2 = i3 + childCount;
                if (i < i2) {
                    SystemUtils.log(3, TAG, "getItemType: " + ItemType.NOT_FIRST_CHILD + ", " + i + "， " + i2, (Throwable) null, "com.didi.map.global.component.trafficreport.view.recycler.ReportDetailAdapter", 196);
                    return ItemType.NOT_FIRST_CHILD;
                }
            } else {
                SystemUtils.log(3, TAG, "getItemType: " + ItemType.FIRST_CHILD + ", " + i, (Throwable) null, "com.didi.map.global.component.trafficreport.view.recycler.ReportDetailAdapter", 191);
                return ItemType.FIRST_CHILD;
            }
        }
        if (i == i2) {
            SystemUtils.log(3, TAG, "getItemType: " + ItemType.REMARK + ", " + i, (Throwable) null, "com.didi.map.global.component.trafficreport.view.recycler.ReportDetailAdapter", 201);
            return ItemType.REMARK;
        }
        throw new IllegalStateException("Could not find item type for item position " + i);
    }

    public Position getPosition(int i) {
        if (CollectionUtil.isEmpty((Collection<?>) this.mGroups)) {
            return null;
        }
        Position position = new Position();
        int i2 = 1;
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

    public enum ItemType {
        GROUP_TITLE(1),
        FIRST_CHILD(2),
        NOT_FIRST_CHILD(3),
        MAP_ENTRY(4),
        REMARK(5);
        
        /* access modifiers changed from: private */
        public final int value;

        private ItemType(int i) {
            this.value = i;
        }

        /* access modifiers changed from: package-private */
        public int getValue() {
            return this.value;
        }
    }
}
