package com.didi.soda.address.component.feed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.helper.NovaItemTouchHelper;

public class AddressRecyclerView extends NovaRecyclerView {

    /* renamed from: a */
    NovaItemTouchHelper f41389a;

    /* renamed from: b */
    private AddressItemViewHolder f41390b;

    /* renamed from: c */
    private boolean f41391c;

    public AddressRecyclerView(Context context) {
        super(context);
    }

    public AddressRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AddressRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setItemTouchControlEnable(boolean z) {
        if (z) {
            if (this.f41389a == null) {
                this.f41389a = new NovaItemTouchHelper();
            }
            this.f41389a.attachToRecyclerView(this);
            return;
        }
        NovaItemTouchHelper novaItemTouchHelper = this.f41389a;
        if (novaItemTouchHelper != null) {
            novaItemTouchHelper.detachToRecyclerView();
        }
    }

    public void setOneOpenToggle(boolean z) {
        this.f41391c = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AddressItemViewHolder addressItemViewHolder;
        if (motionEvent.getAction() == 0) {
            int y = (int) motionEvent.getY();
            if (this.f41391c && (addressItemViewHolder = this.f41390b) != null) {
                int top = addressItemViewHolder.itemView.getTop();
                int bottom = this.f41390b.itemView.getBottom();
                if ((y < top || y > bottom) && this.f41390b.itemView.getScrollX() != 0) {
                    this.f41390b.onMoveIn();
                }
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        NovaItemTouchHelper novaItemTouchHelper;
        if (motionEvent.getAction() == 2 && this.f41391c && (novaItemTouchHelper = this.f41389a) != null && novaItemTouchHelper.mSelected != null && (this.f41389a.mSelected instanceof AddressItemViewHolder)) {
            this.f41390b = (AddressItemViewHolder) this.f41389a.mSelected;
        }
        return super.onTouchEvent(motionEvent);
    }
}
