package com.didi.global.globalgenerickit.template.yoga.view.recyclerview;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.global.globalgenerickit.helper.KitHelper;
import com.didi.global.globalgenerickit.template.yoga.EventListener;
import com.didi.global.globalgenerickit.template.yoga.ILifecycle;
import com.didi.global.globalgenerickit.template.yoga.IParser;
import com.didi.global.globalgenerickit.template.yoga.IView;
import com.didi.global.globalgenerickit.template.yoga.view.Border;
import com.didi.global.globalgenerickit.template.yoga.view.Corner;
import com.facebook.yoga.YogaNode;

public class XPanelHorizontalRecyclerView extends RecyclerView implements ILifecycle, IParser, IView {

    /* renamed from: a */
    private String f24249a;

    /* renamed from: b */
    private StartSnapHelper f24250b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f24251c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ScrollManager f24252d;
    public int decorationPadding;
    public MyRecylerAdapter myRecylerAdapter;

    public View getView() {
        return this;
    }

    public void onParseEnd() {
    }

    public void setBorder(Border border) {
    }

    public void setCorner(Corner corner) {
    }

    public XPanelHorizontalRecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public XPanelHorizontalRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XPanelHorizontalRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f24249a = "XpanelHorizontalRecyclerView";
        this.decorationPadding = 0;
        m19532a(context);
    }

    public void setDecorationPadding(int i) {
        this.decorationPadding = i;
        addItemDecoration(new XpanelItemDecoration(i));
    }

    /* renamed from: a */
    private void m19532a(Context context) {
        this.f24251c = context;
        StartSnapHelper startSnapHelper = new StartSnapHelper();
        this.f24250b = startSnapHelper;
        startSnapHelper.attachToRecyclerView(this);
        MyRecylerAdapter myRecylerAdapter2 = new MyRecylerAdapter(context, this.f24250b, this);
        this.myRecylerAdapter = myRecylerAdapter2;
        setAdapter(myRecylerAdapter2);
        C91971 r0 = new LinearLayoutManager(context, 0, false) {
            public void onLayoutCompleted(RecyclerView.State state) {
                super.onLayoutCompleted(state);
                XPanelHorizontalRecyclerView.this.f24252d.checkScrollX();
            }
        };
        setLayoutManager(r0);
        setDecorationPadding(this.decorationPadding);
        ScrollManager scrollManager = new ScrollManager(this, context, r0);
        this.f24252d = scrollManager;
        scrollManager.initScrollListener();
        setOverScrollMode(2);
    }

    public void addChildView(View view) {
        this.myRecylerAdapter.mo71938a(view);
    }

    public void addView(View view) {
        this.myRecylerAdapter.mo71938a(view);
    }

    public void setCardData(String str) {
        this.myRecylerAdapter.mo71941a(str);
    }

    public void onResume() {
        this.f24252d.checkScrollX();
    }

    public void onPause() {
        this.f24252d.pauseStatus();
    }

    public void cardMoveOut() {
        this.f24252d.pauseStatus();
    }

    public void cardMoveIn() {
        this.f24252d.checkScrollX();
    }

    public void bindXCardListener(EventListener eventListener) {
        MyRecylerAdapter myRecylerAdapter2 = this.myRecylerAdapter;
        if (myRecylerAdapter2 != null) {
            myRecylerAdapter2.mo71939a(eventListener);
            ScrollManager scrollManager = this.f24252d;
            if (scrollManager != null) {
                scrollManager.setXCardListener(eventListener);
            }
        }
    }

    public class XpanelItemDecoration extends RecyclerView.ItemDecoration {
        private int mDividerWidth;
        private int mPadding;

        public XpanelItemDecoration(int i) {
            this.mPadding = i;
            this.mDividerWidth = KitHelper.dip2px(XPanelHorizontalRecyclerView.this.f24251c, 6.0f) - 16;
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (childAdapterPosition == recyclerView.getAdapter().getItemCount() - 1) {
                rect.set(0, 0, this.mPadding, 0);
            } else if (childAdapterPosition == 0) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(0, 0, this.mDividerWidth, 0);
            }
        }
    }

    public void parse(String str, String str2, YogaNode yogaNode) {
        String str3;
        int hashCode = str.hashCode();
        if (hashCode == 622269923) {
            str3 = "pagingMeasurements";
        } else if (hashCode == 695731883) {
            str3 = "flex-direction";
        } else {
            return;
        }
        boolean equals = str.equals(str3);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }
}
