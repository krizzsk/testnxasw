package com.didi.soda.home.shimmer;

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
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.home.shimmer.adapter.ShimmerBaseAdapter;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShimmerRecyclerView extends RecyclerView {

    /* renamed from: a */
    private static final int f45216a = 125;

    /* renamed from: b */
    private ShimmerViewType f45217b;

    /* renamed from: c */
    private int[] f45218c = {1726211046, -1713118234, -857480218, -1842202, -1842202, -857480218, -1713118234, 1726211046};
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AnimatorSet f45219d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f45220e = true;

    /* renamed from: f */
    private boolean f45221f = true;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ boolean m33558a(View view, MotionEvent motionEvent) {
        return true;
    }

    public void setListDelay(boolean z) {
        this.f45221f = z;
    }

    public ShimmerRecyclerView(Context context) {
        super(context);
        m33556a(context);
    }

    public ShimmerRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33556a(context);
    }

    public ShimmerRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33556a(context);
    }

    public void startShimmerAnimator(ShimmerViewType shimmerViewType) {
        if (shimmerViewType != this.f45217b) {
            setAlpha(1.0f);
            setAdapter((RecyclerView.Adapter) null);
            m33554a();
            this.f45217b = shimmerViewType;
            setAdapter(ShimmerAdapterFactory.creatShimmerAdapter(shimmerViewType));
            postDelayed(new Runnable() {
                public final void run() {
                    ShimmerRecyclerView.this.m33562c();
                }
            }, 200);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m33562c() {
        try {
            m33561b();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopShimmerAnimator(AnimatorListenerAdapter animatorListenerAdapter) {
        m33554a();
        m33555a(animatorListenerAdapter);
    }

    public void onDestory() {
        m33554a();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            AnimatorSet animatorSet = this.f45219d;
            if (animatorSet != null && !animatorSet.isRunning()) {
                this.f45220e = true;
                this.f45219d.start();
                return;
            }
            return;
        }
        AnimatorSet animatorSet2 = this.f45219d;
        if (animatorSet2 != null) {
            this.f45220e = false;
            animatorSet2.cancel();
            this.f45219d.end();
        }
    }

    /* renamed from: a */
    private void m33555a(AnimatorListenerAdapter animatorListenerAdapter) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, View.ALPHA, new float[]{1.0f, 0.0f});
        ofFloat.setDuration(350);
        if (animatorListenerAdapter != null) {
            ofFloat.addListener(animatorListenerAdapter);
        }
        ofFloat.start();
    }

    /* renamed from: a */
    private void m33554a() {
        this.f45220e = false;
        this.f45217b = null;
        AnimatorSet animatorSet = this.f45219d;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f45219d.end();
            this.f45219d.removeAllListeners();
            this.f45219d = null;
        }
    }

    /* renamed from: b */
    private void m33561b() {
        ShimmerBaseAdapter shimmerBaseAdapter = (ShimmerBaseAdapter) getAdapter();
        if (shimmerBaseAdapter != null && !CollectionsUtil.isEmpty(shimmerBaseAdapter.getAnimationViewSet()) && !this.f45220e) {
            List<List<View>> animationViewSet = shimmerBaseAdapter.getAnimationViewSet();
            this.f45219d = new AnimatorSet();
            this.f45220e = true;
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < animationViewSet.size(); i++) {
                List list = animationViewSet.get(i);
                if (!CollectionsUtil.isEmpty(list)) {
                    ValueAnimator ofInt = ValueAnimator.ofInt(this.f45218c);
                    ofInt.setEvaluator(new ArgbEvaluator());
                    ofInt.setDuration(1000);
                    if (this.f45221f) {
                        ofInt.setStartDelay((long) (i * 125));
                    }
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(list) {
                        public final /* synthetic */ List f$0;

                        {
                            this.f$0 = r1;
                        }

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            ShimmerRecyclerView.m33557a(this.f$0, valueAnimator);
                        }
                    });
                    arrayList.add(ofInt);
                }
            }
            if (arrayList.size() > 0) {
                this.f45219d.playTogether(arrayList);
                this.f45219d.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (ShimmerRecyclerView.this.f45220e && ShimmerRecyclerView.this.f45219d != null) {
                            ShimmerRecyclerView.this.f45219d.start();
                        }
                    }
                });
                this.f45219d.start();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m33557a(List list, ValueAnimator valueAnimator) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((GradientDrawable) ((View) it.next()).getBackground()).setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* renamed from: a */
    private void m33556a(Context context) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(1);
        setLayoutManager(linearLayoutManager);
        setOnTouchListener($$Lambda$ShimmerRecyclerView$G5p_vRk8e4pczNTPJdl9oOVGso.INSTANCE);
        setBackgroundColor(context.getResources().getColor(R.color.rf_color_v2_grey2_10_a100));
    }
}
