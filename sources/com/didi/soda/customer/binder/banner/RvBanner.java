package com.didi.soda.customer.binder.banner;

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
import com.didi.nova.assembly.p128ui.banner.OnBannerClickListener;
import com.didi.passenger.C11267R;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CustomeRvExposeUtil;
import com.didi.soda.customer.widget.scroll.SlowLinearLayoutManager;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class RvBanner extends RecyclerView {
    public static final long DEFAULT_AUTO_PLAY_DELAY = 4100;
    public static final String TAG = "RvBanner";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Runnable f42978a;

    /* renamed from: b */
    private FitType f42979b;

    /* renamed from: c */
    private int f42980c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public RvBannerAdapter f42981d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f42982e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<String> f42983f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f42984g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f42985h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public long f42986i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Handler f42987j;
    public OnBannerClickListener mOnBannerClickListener;

    public RvBanner(Context context) {
        this(context, (AttributeSet) null);
    }

    public RvBanner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RvBanner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f42978a = new Runnable() {
            public void run() {
                if (RvBanner.this.f42984g > 1) {
                    RvBanner.this.smoothScrollToPosition((RvBanner.this.f42982e + 1) % RvBanner.this.f42981d.getItemCount());
                }
                if (RvBanner.this.f42985h) {
                    RvBanner.this.f42987j.postDelayed(RvBanner.this.f42978a, RvBanner.this.f42986i);
                }
            }
        };
        this.f42982e = -1;
        this.f42983f = new ArrayList();
        this.f42985h = false;
        this.f42986i = 4100;
        this.f42987j = new Handler(Looper.getMainLooper());
        m32132a(context, attributeSet);
        m32131a(context);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f42985h) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                start();
            } else if (action == 0) {
                stop();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setIsAutoPlay(boolean z) {
        this.f42985h = z;
    }

    public void setBannerClickListener(OnBannerClickListener onBannerClickListener) {
        this.mOnBannerClickListener = onBannerClickListener;
    }

    public void setDatas(Context context, float f, List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.f42983f.clear();
            this.f42983f.addAll(list);
            this.f42984g = list.size();
            RvBannerAdapter rvBannerAdapter = new RvBannerAdapter(this, context, f, this.f42983f);
            this.f42981d = rvBannerAdapter;
            rvBannerAdapter.f42989a = this.f42980c;
            this.f42981d.f42990b = this.f42979b;
            this.f42981d.f42991c = this.f42985h;
            setAdapter(this.f42981d);
            m32129a();
            if (getOnFlingListener() == null) {
                new CardSnapHelper().attachToRecyclerView(this);
            }
            if (this.f42985h) {
                this.f42982e = this.f42983f.size() * 1000;
                getLayoutManager().scrollToPosition(this.f42982e);
            } else {
                this.f42982e = 0;
            }
            start();
        }
    }

    public void start() {
        this.f42987j.removeCallbacks(this.f42978a);
        if (this.f42985h) {
            this.f42987j.postDelayed(this.f42978a, this.f42986i);
        }
    }

    public void stop() {
        this.f42987j.removeCallbacks(this.f42978a);
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

    /* renamed from: a */
    private void m32132a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.RvBanner);
        this.f42985h = obtainStyledAttributes.getBoolean(0, false);
        this.f42979b = FitType.values()[obtainStyledAttributes.getInt(6, 0)];
        this.f42980c = obtainStyledAttributes.getResourceId(3, 0);
        obtainStyledAttributes.recycle();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            LogUtil.m32588i("RvBanner", "initAttrs banner rv width =" + layoutParams.width + ",height = " + layoutParams.width);
        }
    }

    /* renamed from: a */
    private void m32131a(Context context) {
        setLayoutManager(new SlowLinearLayoutManager(context, 0, false));
        RecyclerViewCornerRadius recyclerViewCornerRadius = new RecyclerViewCornerRadius(this);
        recyclerViewCornerRadius.setCornerRadius(context.getResources().getDimensionPixelOffset(R.dimen.customer_40px));
        addItemDecoration(recyclerViewCornerRadius);
        new CustomeRvExposeUtil().setRecyclerItemExposeListener(this, new CustomeRvExposeUtil.OnItemExposeListener() {
            public final void onItemViewVisible(int i) {
                RvBanner.this.m32130a(i);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m32130a(int i) {
        if (this.mOnBannerClickListener != null) {
            if (this.f42985h) {
                i %= this.f42983f.size();
            }
            this.mOnBannerClickListener.onBannerPageSelected(i);
        }
    }

    /* renamed from: a */
    private void m32129a() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = this.f42981d.getHeight();
        layoutParams.width = -1;
        setLayoutParams(layoutParams);
        LogUtil.m32588i("RvBanner", "banner rv width =" + layoutParams.width + ",height = " + layoutParams.height);
    }

    /* renamed from: b */
    private void m32134b() {
        stop();
        this.mOnBannerClickListener = null;
    }

    private class CardSnapHelper extends PagerSnapHelper {
        private CardSnapHelper() {
        }

        public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
            int viewAdapterPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewAdapterPosition();
            int size = RvBanner.this.f42985h ? viewAdapterPosition % RvBanner.this.f42983f.size() : viewAdapterPosition;
            if (!(viewAdapterPosition == RvBanner.this.f42982e || size >= RvBanner.this.f42983f.size() || RvBanner.this.f42983f.get(size) == null)) {
                int unused = RvBanner.this.f42982e = viewAdapterPosition;
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
