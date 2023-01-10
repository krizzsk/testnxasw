package com.didiglobal.p205sa.biz.component.sapanel.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.customview.widget.ViewDragHelper;
import com.didi.passenger.C11267R;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.diface.utils.DisplayUtils;
import com.didichuxing.sdk.alphaface.utils.UIHandler;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.didiglobal.p205sa.biz.component.sapanel.PanelAnimatorMgr;
import com.didiglobal.p205sa.biz.component.sapanel.model.AnimationModel;
import com.didiglobal.p205sa.biz.component.sapanel.model.PageTouchEventManger;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.view.SARecycleViewBehavior */
public class SARecycleViewBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;

    /* renamed from: e */
    private static final int f53691e = 140;

    /* renamed from: a */
    private Logger f53692a = LoggerFactory.getLogger("SARecycleViewBehavior");
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f53693b;

    /* renamed from: c */
    private int f53694c;

    /* renamed from: d */
    private int f53695d;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f53696f = false;

    /* renamed from: g */
    private int f53697g;

    /* renamed from: h */
    private int f53698h;

    /* renamed from: i */
    private int f53699i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f53700j = true;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f53701k = 4;

    /* renamed from: l */
    private ViewDragHelper f53702l;

    /* renamed from: m */
    private boolean f53703m;

    /* renamed from: n */
    private int f53704n;

    /* renamed from: o */
    private boolean f53705o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public WeakReference<V> f53706p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public WeakReference<View> f53707q;

    /* renamed from: r */
    private VelocityTracker f53708r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f53709s;

    /* renamed from: t */
    private int f53710t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public boolean f53711u;

    /* renamed from: v */
    private final ViewDragHelper.Callback f53712v = new ViewDragHelper.Callback() {
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        }

        public void onViewReleased(View view, float f, float f2) {
        }

        public boolean tryCaptureView(View view, int i) {
            if (SARecycleViewBehavior.this.f53701k == 1 || SARecycleViewBehavior.this.f53711u) {
                return false;
            }
            if (SARecycleViewBehavior.this.f53701k == 3 && SARecycleViewBehavior.this.f53709s == i) {
                View view2 = SARecycleViewBehavior.this.f53707q != null ? (View) SARecycleViewBehavior.this.f53707q.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            if (SARecycleViewBehavior.this.f53706p == null || SARecycleViewBehavior.this.f53706p.get() != view) {
                return false;
            }
            return true;
        }

        public void onViewDragStateChanged(int i) {
            if (i == 1 && SARecycleViewBehavior.this.f53700j) {
                SARecycleViewBehavior.this.m40073a(1);
            }
        }
    };

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didiglobal.sa.biz.component.sapanel.view.SARecycleViewBehavior$State */
    public @interface State {
    }

    public SARecycleViewBehavior() {
    }

    public SARecycleViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context.obtainStyledAttributes(attributeSet, C11267R.styleable.BottomSheetBehavior_Layout).recycle();
        ViewConfiguration.get(context);
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v), this.f53701k);
    }

    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, savedState.getSuperState());
        if (savedState.state == 1) {
            this.f53701k = 4;
        } else {
            this.f53701k = savedState.state;
        }
    }

    public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.f53706p = null;
        this.f53702l = null;
    }

    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.f53706p = null;
        this.f53702l = null;
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        View view;
        if (coordinatorLayout.getFitsSystemWindows() && !v.getFitsSystemWindows()) {
            v.setFitsSystemWindows(true);
        }
        if (this.f53706p == null) {
            this.f53706p = new WeakReference<>(v);
        }
        if (this.f53702l == null) {
            this.f53702l = ViewDragHelper.create(coordinatorLayout, this.f53712v);
        }
        coordinatorLayout.onLayoutChild(v, i);
        View childAt = ((ViewGroup) v).getChildAt(0);
        if (childAt != null && ComponentType.COMPONENT_RIDE_CARD.equals(childAt.getTag()) && ((view = this.f53693b) == null || childAt != view || (this.f53701k == 4 && this.f53694c != childAt.getHeight()))) {
            this.f53692a.info("onLayoutChild: change", new Object[0]);
            this.f53693b = childAt;
            if (childAt != null) {
                this.f53697g = childAt.getPaddingLeft();
                this.f53698h = this.f53693b.getPaddingRight();
                this.f53699i = this.f53693b.getPaddingTop();
                int height = this.f53693b.getHeight();
                this.f53694c = height;
                this.f53695d = height + 140;
            }
        }
        this.f53707q = new WeakReference<>(m40071a((View) v));
        return true;
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        this.f53704n = 0;
        this.f53705o = false;
        if ((i & 2) != 0) {
            return true;
        }
        return false;
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        if (i3 != 1) {
            if (this.f53696f) {
                iArr[1] = i2;
            } else if (i2 != 0 && this.f53693b != null && PageTouchEventManger.mapInFirstPosition && PageTouchEventManger.showMap) {
                WeakReference<View> weakReference = this.f53707q;
                if (view == (weakReference != null ? (View) weakReference.get() : null)) {
                    int height = this.f53693b.getHeight() - i2;
                    if (i2 > 0) {
                        if (height <= this.f53694c) {
                            m40073a(4);
                        } else if (this.f53700j) {
                            iArr[1] = i2;
                            m40073a(1);
                            resizeFirstChildHeight(i2);
                        } else {
                            return;
                        }
                    } else if (!view.canScrollVertically(-1) && height < DisplayUtils.getScreenHeight(v.getContext())) {
                        if (this.f53700j) {
                            iArr[1] = i2;
                            m40073a(1);
                            resizeFirstChildHeight(i2);
                            Logger logger = this.f53692a;
                            StringBuilder sb = new StringBuilder();
                            sb.append("onNestedPreScroll:pulldown: curH: ");
                            sb.append(this.f53693b.getHeight());
                            sb.append("-newHeight: ");
                            sb.append(height);
                            sb.append("-maxH: ");
                            sb.append(this.f53695d);
                            sb.append("-isExpand: ");
                            sb.append(height >= this.f53695d);
                            logger.info(sb.toString(), new Object[0]);
                            if (height >= this.f53695d) {
                                expandToRid(0);
                            }
                        } else {
                            return;
                        }
                    }
                    this.f53704n = i2;
                    this.f53705o = true;
                }
            }
        }
    }

    public void expandToRid(int i) {
        View view = this.f53693b;
        if (view != null && view.getContext() != null) {
            m40073a(3);
            View view2 = this.f53693b;
            PanelAnimatorMgr.valueAnimat(view2, view2.getHeight(), DisplayUtils.getScreenHeight(this.f53693b.getContext()) + 1000, 300, true, i, new PanelAnimatorMgr.AnimationListener() {
                public void onAnimationProcess(AnimationModel animationModel) {
                    boolean unused = SARecycleViewBehavior.this.f53696f = animationModel.getFraction() != 1.0f;
                    SARecycleViewBehavior.this.resizeViewPadding(1.0f - animationModel.getFraction());
                    int process = animationModel.getProcess();
                    SARecycleViewBehavior sARecycleViewBehavior = SARecycleViewBehavior.this;
                    sARecycleViewBehavior.resizeFirstChildHeight(sARecycleViewBehavior.f53693b.getHeight() - process);
                }
            });
        }
    }

    public void reverseAnimator() {
        View view = this.f53693b;
        if (view != null) {
            PanelAnimatorMgr.valueAnimat(view, view.getHeight(), this.f53694c, 300, false, -1, new PanelAnimatorMgr.AnimationListener() {
                public void onAnimationProcess(AnimationModel animationModel) {
                    int i = 1;
                    boolean unused = SARecycleViewBehavior.this.f53696f = animationModel.getFraction() != 1.0f;
                    SARecycleViewBehavior sARecycleViewBehavior = SARecycleViewBehavior.this;
                    if (animationModel.getFraction() == 1.0f) {
                        i = 4;
                    }
                    sARecycleViewBehavior.m40073a(i);
                    SARecycleViewBehavior.this.resizeViewPadding(animationModel.getFraction());
                    SARecycleViewBehavior sARecycleViewBehavior2 = SARecycleViewBehavior.this;
                    sARecycleViewBehavior2.resizeFirstChildHeight(sARecycleViewBehavior2.f53693b.getHeight() - animationModel.getProcess());
                    if (animationModel.getFraction() == 1.0f) {
                        UIHandler.post(new Runnable() {
                            public void run() {
                                if (SARecycleViewBehavior.this.f53693b != null) {
                                    ViewGroup.LayoutParams layoutParams = SARecycleViewBehavior.this.f53693b.getLayoutParams();
                                    layoutParams.height = -2;
                                    SARecycleViewBehavior.this.f53693b.setLayoutParams(layoutParams);
                                    SARecycleViewBehavior.this.f53693b.requestLayout();
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public void resizeFirstChildHeight(int i) {
        View view = this.f53693b;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.f53693b.getHeight() - i;
            this.f53693b.setLayoutParams(layoutParams);
            this.f53693b.requestLayout();
        }
    }

    public void resizeViewPadding(float f) {
        View view = this.f53693b;
        if (view != null) {
            view.setPadding((int) (((float) this.f53697g) * f), (int) (((float) this.f53699i) * f), (int) (((float) this.f53698h) * f), view.getPaddingBottom());
        }
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
        if (PageTouchEventManger.mapInFirstPosition && PageTouchEventManger.showMap) {
            View view2 = this.f53693b;
            if (view2 == null) {
                this.f53692a.info("onStopNestedScroll: firstChild == null", new Object[0]);
            } else if (this.f53696f) {
                this.f53692a.info("onStopNestedScroll: doingAnimation", new Object[0]);
            } else if (view2.getHeight() == this.f53694c) {
                Logger logger = this.f53692a;
                logger.info("onStopNestedScroll: curHeight == firstChildDefaultHeight-" + this.f53694c, new Object[0]);
                m40073a(4);
            } else {
                WeakReference<View> weakReference = this.f53707q;
                if (weakReference != null && view == weakReference.get() && this.f53705o) {
                    if (m40075a()) {
                        ValueAnimator duration = ValueAnimator.ofInt(new int[]{this.f53693b.getHeight(), this.f53694c}).setDuration(400);
                        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                int i = 1;
                                int i2 = (valueAnimator.getAnimatedFraction() > 1.0f ? 1 : (valueAnimator.getAnimatedFraction() == 1.0f ? 0 : -1));
                                boolean unused = SARecycleViewBehavior.this.f53696f = i2 != 0;
                                SARecycleViewBehavior sARecycleViewBehavior = SARecycleViewBehavior.this;
                                if (i2 == 0) {
                                    i = 4;
                                }
                                sARecycleViewBehavior.m40073a(i);
                                SARecycleViewBehavior sARecycleViewBehavior2 = SARecycleViewBehavior.this;
                                sARecycleViewBehavior2.resizeFirstChildHeight(sARecycleViewBehavior2.f53693b.getHeight() - intValue);
                            }
                        });
                        duration.start();
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", 0);
                        hashMap.put("style", 4);
                        OmegaSDKAdapter.trackEvent("ibt_gp_sa_map_to_ridehome_ck", (Map<String, Object>) hashMap);
                    } else if (this.f53701k != 3) {
                        expandToRid(0);
                    }
                    this.f53705o = false;
                }
            }
        }
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        WeakReference<View> weakReference = this.f53707q;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        if (this.f53701k != 4 || super.onNestedPreFling(coordinatorLayout, v, view, f, f2)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40073a(int i) {
        if (this.f53701k != i) {
            this.f53701k = i;
        }
    }

    public void reset() {
        this.f53709s = -1;
        VelocityTracker velocityTracker = this.f53708r;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f53708r = null;
        }
        this.f53693b = null;
    }

    /* renamed from: a */
    private boolean m40075a() {
        View view = this.f53693b;
        Logger logger = this.f53692a;
        StringBuilder sb = new StringBuilder();
        sb.append("shouldCollespe:-");
        sb.append(this.f53693b.getHeight());
        sb.append("-");
        sb.append(this.f53695d);
        sb.append("--");
        sb.append(view.getHeight() <= this.f53695d);
        logger.info(sb.toString(), new Object[0]);
        if (view.getHeight() <= this.f53695d) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private boolean m40078b() {
        return this.f53693b.getHeight() > this.f53695d;
    }

    /* renamed from: a */
    private View m40071a(View view) {
        if (view instanceof NestedScrollingChild) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View a = m40071a(viewGroup.getChildAt(i));
            if (a != null) {
                return a;
            }
        }
        return null;
    }

    /* renamed from: com.didiglobal.sa.biz.component.sapanel.view.SARecycleViewBehavior$SavedState */
    protected static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        final int state;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.state = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.state = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.state);
        }
    }

    public static <V extends View> SARecycleViewBehavior<V> from(V v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (behavior instanceof SARecycleViewBehavior) {
                return (SARecycleViewBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehaviorGoogleMapsLike");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }
}
