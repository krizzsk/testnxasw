package com.didi.entrega.address.list.component.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.helper.NovaItemTouchHelper;
import com.didi.entrega.address.list.component.feed.binder.AddressItemViewHolder;

public class AddressRecyclerView extends NovaRecyclerView {

    /* renamed from: a */
    NovaItemTouchHelper f21298a;

    /* renamed from: b */
    private AddressItemViewHolder f21299b;

    /* renamed from: c */
    private boolean f21300c;

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
            if (this.f21298a == null) {
                this.f21298a = new NovaItemTouchHelper();
            }
            this.f21298a.attachToRecyclerView(this);
            return;
        }
        NovaItemTouchHelper novaItemTouchHelper = this.f21298a;
        if (novaItemTouchHelper != null) {
            novaItemTouchHelper.detachToRecyclerView();
        }
    }

    public void setOneOpenToggle(boolean z) {
        this.f21300c = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AddressItemViewHolder addressItemViewHolder;
        if (motionEvent.getAction() == 0) {
            int y = (int) motionEvent.getY();
            if (this.f21300c && (addressItemViewHolder = this.f21299b) != null) {
                int top = addressItemViewHolder.itemView.getTop();
                int bottom = this.f21299b.itemView.getBottom();
                if ((y < top || y > bottom) && this.f21299b.itemView.getScrollX() != 0) {
                    this.f21299b.onMoveIn();
                }
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        NovaItemTouchHelper novaItemTouchHelper;
        if (motionEvent.getAction() == 2 && this.f21300c && (novaItemTouchHelper = this.f21298a) != null && novaItemTouchHelper.mSelected != null && (this.f21298a.mSelected instanceof AddressItemViewHolder)) {
            this.f21299b = (AddressItemViewHolder) this.f21298a.mSelected;
        }
        return super.onTouchEvent(motionEvent);
    }
}
