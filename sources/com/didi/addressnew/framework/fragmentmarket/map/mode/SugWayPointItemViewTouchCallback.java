package com.didi.addressnew.framework.fragmentmarket.map.mode;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.address.model.WayPoint;
import com.didi.addressnew.framework.fragmentmarket.map.adapter.SugWayPointListViewAdapter;

public class SugWayPointItemViewTouchCallback extends ItemTouchHelper.Callback {

    /* renamed from: a */
    private SugWayPointListViewAdapter f9006a;

    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    public boolean isLongPressDragEnabled() {
        return false;
    }

    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
    }

    public SugWayPointItemViewTouchCallback(SugWayPointListViewAdapter sugWayPointListViewAdapter) {
        this.f9006a = sugWayPointListViewAdapter;
    }

    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return makeMovementFlags(3, 0);
    }

    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        WayPoint wayPoint;
        if (!(!(viewHolder2 instanceof SugWayPointListViewAdapter.WayPointViewHolder) || (wayPoint = ((SugWayPointListViewAdapter.WayPointViewHolder) viewHolder2).wayPointEditView.getWayPoint()) == null || wayPoint.getWayPointType() == 1)) {
            this.f9006a.onItemMove(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
        }
        return true;
    }

    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        this.f9006a.dragEnd();
    }
}
