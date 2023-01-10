package com.didi.addressnew.framework.fragmentmarket.map.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.address.model.WayPoint;
import com.didi.addressnew.framework.animator.EaseCubicInterpolator;
import com.didi.addressnew.framework.fragmentmarket.map.adapter.SugWayPointListViewAdapter;
import com.didi.addressnew.framework.fragmentmarket.map.presenter.SugMapWayPointPagePresenter;
import com.didi.addressnew.framework.fragmentmarket.map.view.SugWayPointEditView;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SugWayPointListViewAdapter extends RecyclerView.Adapter<WayPointViewHolder> {

    /* renamed from: a */
    List<WayPoint> f8922a = new ArrayList();

    /* renamed from: b */
    private List<WeakReference<WayPointViewHolder>> f8923b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SugWayPointEditView.OnActionListener f8924c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public WayPointRecyclerAdapterCallback f8925d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SugMapWayPointPagePresenter f8926e;

    /* renamed from: f */
    private Context f8927f;

    /* renamed from: g */
    private boolean f8928g;

    public interface WayPointRecyclerAdapterCallback {
        boolean addStopAble();

        void addToStopPoints(WayPoint wayPoint);

        void clearStopPoints();

        void onDradEnd();

        void onDragStart(RecyclerView.ViewHolder viewHolder);
    }

    public void clearGuideView() {
    }

    public SugWayPointListViewAdapter(Context context) {
        this.f8927f = context;
    }

    public void setWayPointRecyclerAdapterCallback(WayPointRecyclerAdapterCallback wayPointRecyclerAdapterCallback) {
        this.f8925d = wayPointRecyclerAdapterCallback;
    }

    public void setOnActionListener(SugWayPointEditView.OnActionListener onActionListener) {
        this.f8924c = onActionListener;
    }

    public void setWayPointEditPagePresenter(SugMapWayPointPagePresenter sugMapWayPointPagePresenter) {
        this.f8926e = sugMapWayPointPagePresenter;
    }

    public void setDataList(List<WayPoint> list) {
        this.f8922a = list;
    }

    public void onItemMove(int i, int i2) {
        m7630a("onItemMove: fromPosition: " + i + ", toPosition: " + i2);
        List<WayPoint> list = this.f8922a;
        if (list != null && i >= 0 && i2 >= 0 && list.size() > i2 && this.f8922a.get(i2).isEditable()) {
            Collections.swap(this.f8922a, i, i2);
            notifyItemMoved(i, i2);
        }
    }

    public void updateDataType() {
        this.f8925d.clearStopPoints();
        if (this.f8922a != null) {
            WayPoint wayPoint = null;
            for (int i = 0; i < this.f8922a.size(); i++) {
                WayPoint wayPoint2 = this.f8922a.get(i);
                if (i == 0) {
                    if (wayPoint2.getWayPointType() != 1) {
                        wayPoint2.setWayPointType(1);
                        SugWayPointEditView.OnActionListener onActionListener = this.f8924c;
                        if (onActionListener != null) {
                            onActionListener.addToChangedWayPoints(wayPoint2);
                        }
                    }
                } else if (i != this.f8922a.size() - 1) {
                    wayPoint2.setWayPointType(2);
                    SugWayPointEditView.OnActionListener onActionListener2 = this.f8924c;
                    if (onActionListener2 != null) {
                        onActionListener2.addToChangedWayPoints(wayPoint2);
                    }
                    this.f8925d.addToStopPoints(wayPoint2);
                } else if (wayPoint2.getWayPointType() != 3) {
                    wayPoint2.setWayPointType(3);
                    SugWayPointEditView.OnActionListener onActionListener3 = this.f8924c;
                    if (onActionListener3 != null) {
                        onActionListener3.addToChangedWayPoints(wayPoint2);
                    }
                    wayPoint = wayPoint2;
                }
            }
            if (wayPoint != null) {
                wayPoint.setCanAdd(this.f8925d.addStopAble());
            }
            new Handler().post(new Runnable() {
                public final void run() {
                    SugWayPointListViewAdapter.this.m7634c();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m7634c() {
        notifyDataSetChanged();
    }

    public void dragEnd() {
        m7630a("dragEnd ...");
        m7632b();
        updateDataType();
        WayPointRecyclerAdapterCallback wayPointRecyclerAdapterCallback = this.f8925d;
        if (wayPointRecyclerAdapterCallback != null) {
            wayPointRecyclerAdapterCallback.onDradEnd();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7627a() {
        setItemAnimFlag(false);
        m7630a("onDragStart mViewHolderCacheList.size()=" + this.f8923b.size());
        if (this.f8923b.size() != 0) {
            for (WeakReference next : this.f8923b) {
                if (!(next == null || next.get() == null)) {
                    ((WayPointViewHolder) next.get()).wayPointEditView.onStartDrag();
                }
            }
        }
    }

    public void setItemAnimFlag(boolean z) {
        this.f8928g = z;
    }

    /* renamed from: b */
    private void m7632b() {
        if (this.f8923b.size() != 0) {
            for (WeakReference next : this.f8923b) {
                if (!(next == null || next.get() == null)) {
                    ((WayPointViewHolder) next.get()).wayPointEditView.onEndDrag();
                }
            }
        }
    }

    public WayPointViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        m7630a("onCreateViewHolder i=" + i);
        return new WayPointViewHolder(new SugWayPointEditView(viewGroup.getContext()));
    }

    public void onBindViewHolder(WayPointViewHolder wayPointViewHolder, int i) {
        if (wayPointViewHolder != null) {
            m7628a(wayPointViewHolder.itemView, i);
            wayPointViewHolder.onBindData(this.f8922a.get(i), i);
            this.f8923b.add(new WeakReference(wayPointViewHolder));
        }
    }

    public int getItemCount() {
        m7630a("getItemCount mWayPoints=" + this.f8922a.size());
        return this.f8922a.size();
    }

    /* renamed from: a */
    private void m7628a(View view, int i) {
        if (this.f8922a.size() > 2 && this.f8928g) {
            AnimationSet animationSet = new AnimationSet(true);
            if (i == this.f8922a.size() - 2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                animationSet.addAnimation(alphaAnimation);
                alphaAnimation.setDuration((long) 600);
            }
            if (i == this.f8922a.size() - 1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f8927f, R.anim.input_view_item_anim);
                long j = (long) 500;
                loadAnimation.setDuration(j);
                animationSet.addAnimation(loadAnimation);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setDuration(j);
                animationSet.addAnimation(alphaAnimation2);
            }
            animationSet.setInterpolator(new EaseCubicInterpolator(0.3f, 0.2f, 0.1f, 1.0f));
            animationSet.setFillAfter(true);
            view.startAnimation(animationSet);
        }
    }

    public class WayPointViewHolder extends RecyclerView.ViewHolder {
        public SugWayPointEditView wayPointEditView;

        public WayPointViewHolder(SugWayPointEditView sugWayPointEditView) {
            super(sugWayPointEditView);
            this.wayPointEditView = sugWayPointEditView;
            sugWayPointEditView.setPresenter(SugWayPointListViewAdapter.this.f8926e);
        }

        public void onBindData(WayPoint wayPoint, int i) {
            if (wayPoint != null) {
                this.wayPointEditView.update(wayPoint, i);
                this.wayPointEditView.setActionListener(SugWayPointListViewAdapter.this.f8924c);
                if (wayPoint.getWayPointType() != 1) {
                    this.wayPointEditView.setDragTouchListener(new View.OnTouchListener() {
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            return SugWayPointListViewAdapter.WayPointViewHolder.this.mo43695xbd2bf2fb(view, motionEvent);
                        }
                    });
                }
            }
        }

        /* renamed from: lambda$onBindData$0$SugWayPointListViewAdapter$WayPointViewHolder */
        public /* synthetic */ boolean mo43695xbd2bf2fb(View view, MotionEvent motionEvent) {
            SugWayPointListViewAdapter sugWayPointListViewAdapter = SugWayPointListViewAdapter.this;
            sugWayPointListViewAdapter.m7630a("onTouch action=" + motionEvent.getAction());
            if (motionEvent.getAction() != 0 || SugWayPointListViewAdapter.this.f8925d == null) {
                return false;
            }
            SugWayPointListViewAdapter.this.m7627a();
            this.wayPointEditView.onSelfStartDrag();
            SugWayPointListViewAdapter.this.f8925d.onDragStart(this);
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7630a(String str) {
        SystemUtils.log(4, "wayPointDebug", str, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.map.adapter.SugWayPointListViewAdapter", 253);
    }
}
