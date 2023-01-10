package com.didi.entrega.home.shimmer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.entrega.customer.foundation.util.CollectionsUtil;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.home.shimmer.adapter.ShimmerBaseAdapter;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShimmerRecyclerView extends RecyclerView {

    /* renamed from: a */
    private static final int f22580a = 125;

    /* renamed from: b */
    private ShimmerViewType f22581b;

    /* renamed from: c */
    private int[] f22582c = {1726540011, -1712789269, -857151253, -1513237, -1513237, -857151253, -1712789269, 1726540011};
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AnimatorSet f22583d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f22584e = true;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ boolean m18583a(View view, MotionEvent motionEvent) {
        return true;
    }

    public ShimmerRecyclerView(Context context) {
        super(context);
        m18581a(context);
    }

    public ShimmerRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18581a(context);
    }

    public ShimmerRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18581a(context);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            AnimatorSet animatorSet = this.f22583d;
            if (animatorSet != null && !animatorSet.isRunning()) {
                this.f22584e = true;
                this.f22583d.start();
                return;
            }
            return;
        }
        AnimatorSet animatorSet2 = this.f22583d;
        if (animatorSet2 != null) {
            this.f22584e = false;
            animatorSet2.cancel();
            this.f22583d.end();
        }
    }

    public void startShimmerAnimator(ShimmerViewType shimmerViewType) {
        if (shimmerViewType != this.f22581b) {
            setAlpha(1.0f);
            setAdapter((RecyclerView.Adapter) null);
            m18579a();
            this.f22581b = shimmerViewType;
            setAdapter(ShimmerAdapterFactory.createShimmerAdapter(shimmerViewType));
            postDelayed(new Runnable() {
                public final void run() {
                    ShimmerRecyclerView.this.m18586b();
                }
            }, 200);
        }
    }

    public void stopShimmerAnimator(AnimatorListenerAdapter animatorListenerAdapter) {
        m18579a();
        m18580a(animatorListenerAdapter);
    }

    public void onDestroy() {
        m18579a();
    }

    /* renamed from: a */
    private void m18580a(AnimatorListenerAdapter animatorListenerAdapter) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, View.ALPHA, new float[]{1.0f, 0.0f});
        ofFloat.setDuration(350);
        if (animatorListenerAdapter != null) {
            ofFloat.addListener(animatorListenerAdapter);
        }
        ofFloat.start();
    }

    /* renamed from: a */
    private void m18579a() {
        this.f22584e = false;
        this.f22581b = null;
        AnimatorSet animatorSet = this.f22583d;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f22583d.end();
            this.f22583d.removeAllListeners();
            this.f22583d = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m18586b() {
        ShimmerBaseAdapter shimmerBaseAdapter = (ShimmerBaseAdapter) getAdapter();
        if (shimmerBaseAdapter != null && !CollectionsUtil.isEmpty(shimmerBaseAdapter.getAnimationViewSet())) {
            List<List<View>> animationViewSet = shimmerBaseAdapter.getAnimationViewSet();
            this.f22583d = new AnimatorSet();
            this.f22584e = true;
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < animationViewSet.size(); i++) {
                List list = animationViewSet.get(i);
                if (!CollectionsUtil.isEmpty(list)) {
                    ValueAnimator ofInt = ValueAnimator.ofInt(this.f22582c);
                    ofInt.setEvaluator(new ArgbEvaluator());
                    ofInt.setDuration(1000);
                    ofInt.setStartDelay((long) (i * 125));
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(list) {
                        public final /* synthetic */ List f$0;

                        {
                            this.f$0 = r1;
                        }

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            ShimmerRecyclerView.m18582a(this.f$0, valueAnimator);
                        }
                    });
                    arrayList.add(ofInt);
                }
            }
            if (arrayList.size() > 0) {
                this.f22583d.playTogether(arrayList);
                this.f22583d.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (ShimmerRecyclerView.this.f22584e && ShimmerRecyclerView.this.f22583d != null) {
                            ShimmerRecyclerView.this.f22583d.start();
                        }
                    }
                });
                this.f22583d.start();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m18582a(List list, ValueAnimator valueAnimator) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((GradientDrawable) ((View) it.next()).getBackground()).setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* renamed from: a */
    private void m18581a(Context context) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(1);
        setLayoutManager(linearLayoutManager);
        setOnTouchListener($$Lambda$ShimmerRecyclerView$dctEypjSyVI52Aaqv4eShOJius.INSTANCE);
        setBackgroundColor(ResourceHelper.getColor(R.color.rf_color_white_100_FFFFFF));
    }
}
