package com.didi.entrega.home.component.feed.binder.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.skeleton.image.FitType;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.CustomeRvExposeUtil;
import com.didi.entrega.customer.widget.scroll.SlowLinearLayoutManager;
import com.didi.nova.assembly.p128ui.banner.OnBannerClickListener;
import com.didi.passenger.C11267R;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class RvBanner extends RecyclerView {
    public static final long DEFAULT_AUTO_PLAY_DELAY = 4100;
    public static final String TAG = "RvBanner";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Runnable f22521a;

    /* renamed from: b */
    private FitType f22522b;

    /* renamed from: c */
    private int f22523c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public RvBannerAdapter f22524d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f22525e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<String> f22526f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f22527g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f22528h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public long f22529i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Handler f22530j;
    public OnBannerClickListener mOnBannerClickListener;

    public RvBanner(Context context) {
        this(context, (AttributeSet) null);
    }

    public RvBanner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RvBanner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22521a = new Runnable() {
            public void run() {
                if (RvBanner.this.f22527g > 1) {
                    RvBanner.this.smoothScrollToPosition((RvBanner.this.f22525e + 1) % RvBanner.this.f22524d.getItemCount());
                }
                if (RvBanner.this.f22528h) {
                    RvBanner.this.f22530j.postDelayed(RvBanner.this.f22521a, RvBanner.this.f22529i);
                }
            }
        };
        this.f22525e = -1;
        this.f22526f = new ArrayList();
        this.f22528h = false;
        this.f22529i = 4100;
        this.f22530j = new Handler(Looper.getMainLooper());
        m18543a(context, attributeSet);
        m18542a(context);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f22528h) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                start();
            } else if (action == 0) {
                stop();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        stop();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            stop();
        } else {
            start();
        }
    }

    public void setIsAutoPlay(boolean z) {
        this.f22528h = z;
    }

    public void setBannerClickListener(OnBannerClickListener onBannerClickListener) {
        this.mOnBannerClickListener = onBannerClickListener;
    }

    public void setDatas(Context context, float f, List<String> list, OnBannerImageDownLoadListener onBannerImageDownLoadListener) {
        if (list != null && !list.isEmpty()) {
            this.f22526f.clear();
            this.f22526f.addAll(list);
            this.f22527g = list.size();
            RvBannerAdapter rvBannerAdapter = new RvBannerAdapter(this, context, f, this.f22526f, onBannerImageDownLoadListener);
            this.f22524d = rvBannerAdapter;
            rvBannerAdapter.f22532a = this.f22523c;
            this.f22524d.f22533b = this.f22522b;
            this.f22524d.f22534c = this.f22528h;
            setAdapter(this.f22524d);
            m18540a();
            if (getOnFlingListener() == null) {
                new CardSnapHelper().attachToRecyclerView(this);
            }
            if (this.f22528h) {
                this.f22525e = this.f22526f.size() * 1000;
                getLayoutManager().scrollToPosition(this.f22525e);
            } else {
                this.f22525e = 0;
            }
            start();
        }
    }

    public void start() {
        this.f22530j.removeCallbacks(this.f22521a);
        if (this.f22528h) {
            this.f22530j.postDelayed(this.f22521a, this.f22529i);
        }
    }

    public void stop() {
        this.f22530j.removeCallbacks(this.f22521a);
    }

    /* renamed from: a */
    private void m18543a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.EntregaRvBanner);
        this.f22528h = obtainStyledAttributes.getBoolean(1, false);
        this.f22522b = FitType.values()[obtainStyledAttributes.getInt(0, 0)];
        this.f22523c = obtainStyledAttributes.getResourceId(4, 0);
        obtainStyledAttributes.recycle();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            LogUtil.m18185i("RvBanner", "initAttrs banner rv width =" + layoutParams.width + ",height = " + layoutParams.width);
        }
    }

    /* renamed from: a */
    private void m18542a(Context context) {
        setLayoutManager(new SlowLinearLayoutManager(context, 0, false));
        RecyclerViewCornerRadius recyclerViewCornerRadius = new RecyclerViewCornerRadius(this);
        recyclerViewCornerRadius.setCornerRadius(context.getResources().getDimensionPixelOffset(R.dimen.rf_dimen_40));
        addItemDecoration(recyclerViewCornerRadius);
        new CustomeRvExposeUtil().setRecyclerItemExposeListener(this, new CustomeRvExposeUtil.OnItemExposeListener() {
            public final void onItemViewVisible(int i) {
                RvBanner.this.m18541a(i);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18541a(int i) {
        if (this.mOnBannerClickListener != null) {
            if (this.f22528h) {
                i %= this.f22526f.size();
            }
            this.mOnBannerClickListener.onBannerPageSelected(i);
        }
    }

    /* renamed from: a */
    private void m18540a() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = this.f22524d.getHeight();
        layoutParams.width = -1;
        setLayoutParams(layoutParams);
        LogUtil.m18185i("RvBanner", "banner rv width =" + layoutParams.width + ",height = " + layoutParams.height);
    }

    /* renamed from: b */
    private void m18545b() {
        stop();
        this.mOnBannerClickListener = null;
    }

    private class CardSnapHelper extends PagerSnapHelper {
        private CardSnapHelper() {
        }

        public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
            int viewAdapterPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewAdapterPosition();
            int size = RvBanner.this.f22528h ? viewAdapterPosition % RvBanner.this.f22526f.size() : viewAdapterPosition;
            if (!(viewAdapterPosition == RvBanner.this.f22525e || size >= RvBanner.this.f22526f.size() || RvBanner.this.f22526f.get(size) == null)) {
                int unused = RvBanner.this.f22525e = viewAdapterPosition;
            }
            return super.calculateDistanceToFinalSnap(layoutManager, view);
        }
    }

    private class RecyclerViewCornerRadius extends RecyclerView.ItemDecoration {
        public static final String TAG = "RecyclerViewCornerRadius";
        /* access modifiers changed from: private */
        public int mBottomLeftRadius = 0;
        /* access modifiers changed from: private */
        public int mBottomRightRadius = 0;
        /* access modifiers changed from: private */
        public Path mPath;
        /* access modifiers changed from: private */
        public RectF mRectF;
        /* access modifiers changed from: private */
        public int mTopLeftRadius = 0;
        /* access modifiers changed from: private */
        public int mTopRightRadius = 0;

        RecyclerViewCornerRadius(final RecyclerView recyclerView) {
            recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(RvBanner.this) {
                public void onGlobalLayout() {
                    RectF unused = RecyclerViewCornerRadius.this.mRectF = new RectF(0.0f, 0.0f, (float) recyclerView.getMeasuredWidth(), (float) recyclerView.getMeasuredHeight());
                    Path unused2 = RecyclerViewCornerRadius.this.mPath = new Path();
                    RecyclerViewCornerRadius.this.mPath.reset();
                    RecyclerViewCornerRadius.this.mPath.addRoundRect(RecyclerViewCornerRadius.this.mRectF, new float[]{(float) RecyclerViewCornerRadius.this.mTopLeftRadius, (float) RecyclerViewCornerRadius.this.mTopLeftRadius, (float) RecyclerViewCornerRadius.this.mTopRightRadius, (float) RecyclerViewCornerRadius.this.mTopRightRadius, (float) RecyclerViewCornerRadius.this.mBottomLeftRadius, (float) RecyclerViewCornerRadius.this.mBottomLeftRadius, (float) RecyclerViewCornerRadius.this.mBottomRightRadius, (float) RecyclerViewCornerRadius.this.mBottomRightRadius}, Path.Direction.CCW);
                    recyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            RectF rectF = this.mRectF;
            if (rectF != null) {
                canvas.clipRect(rectF);
                canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
                if (Build.VERSION.SDK_INT >= 28) {
                    canvas.clipPath(this.mPath);
                } else {
                    canvas.clipPath(this.mPath, Region.Op.REPLACE);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setCornerRadius(int i) {
            this.mTopLeftRadius = i;
            this.mTopRightRadius = i;
            this.mBottomLeftRadius = i;
            this.mBottomRightRadius = i;
        }
    }
}
