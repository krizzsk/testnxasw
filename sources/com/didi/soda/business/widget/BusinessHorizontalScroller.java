package com.didi.soda.business.widget;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.raven.config.RavenKey;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.blocks.widget.scroller.HorizontalScrollerWithEntrance;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@WidgetNameMeta(realTimeExposure = true, widgetName = "ChevronHorizontalScroller")
@Metadata(mo148867d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u0002002\u0006\u00104\u001a\u000205H\u0002J\u0010\u00106\u001a\u0002002\u0006\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u0002002\u0006\u0010:\u001a\u00020\u000eH\u0002J\b\u0010;\u001a\u000200H\u0002Jj\u0010<\u001a\u00020'2\u0006\u0010=\u001a\u00020>2\u0010\u0010?\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010A\u0018\u00010@2F\u0010B\u001aB\u0012\u0013\u0012\u00110>¢\u0006\f\bD\u0012\b\bE\u0012\u0004\b\b(=\u0012\u0013\u0012\u00110F¢\u0006\f\bD\u0012\b\bE\u0012\u0004\b\b(G\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010A\u0018\u00010@\u0012\u0004\u0012\u0002000CH\u0016Jt\u0010H\u001a\u00020'2\u0006\u0010=\u001a\u00020>2\b\u0010I\u001a\u0004\u0018\u00010\u00062\u0010\u0010?\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010A\u0018\u00010@2F\u0010B\u001aB\u0012\u0013\u0012\u00110>¢\u0006\f\bD\u0012\b\bE\u0012\u0004\b\b(=\u0012\u0013\u0012\u00110F¢\u0006\f\bD\u0012\b\bE\u0012\u0004\b\b(G\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010A\u0018\u00010@\u0012\u0004\u0012\u0002000CH\u0016J(\u0010J\u001a\u0002002\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020L2\u0006\u0010N\u001a\u00020L2\u0006\u0010O\u001a\u00020LH\u0016J\u0018\u0010P\u001a\u00020'2\u0006\u0010Q\u001a\u0002052\u0006\u00101\u001a\u000202H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u000e\u0010\u001c\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\u001a\u0010!\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R\u0010\u0010.\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, mo148868d2 = {"Lcom/didi/soda/business/widget/BusinessHorizontalScroller;", "Lcom/didi/soda/blocks/widget/scroller/HorizontalScrollerWithEntrance;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "WidgetTriggerBean", "Lcom/didi/soda/business/widget/WidgetTriggerBean;", "getWidgetTriggerBean", "()Lcom/didi/soda/business/widget/WidgetTriggerBean;", "setWidgetTriggerBean", "(Lcom/didi/soda/business/widget/WidgetTriggerBean;)V", "actionDownX", "", "getActionDownX", "()F", "setActionDownX", "(F)V", "actionDownY", "getActionDownY", "setActionDownY", "arrowClickBean", "getArrowClickBean", "setArrowClickBean", "clickBean", "getClickBean", "setClickBean", "dealLastX", "dealLastY", "dealtX", "getDealtX", "setDealtX", "dealtY", "getDealtY", "setDealtY", "inAnim", "Landroid/animation/ObjectAnimator;", "isInAnim", "", "()Z", "setInAnim", "(Z)V", "isMoved", "isOutAnim", "setOutAnim", "outAnim", "actionCanelAndUp", "", "ev", "Landroid/view/MotionEvent;", "dealEntranceBottomMargin", "view", "Landroid/view/View;", "generateEntrance", "root", "Landroid/view/ViewGroup;", "generateGoneAnim", "nowAlpha", "generateVisAnim", "handleClickTrigger", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "actions", "", "Lcom/didi/soda/blocks/action/BaseAction;", "handler", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Lcom/didi/soda/blocks/widget/Buildable;", "widget", "handleOtherTrigger", "callBackType", "mOnScrollChanged", "l", "", "t", "oldl", "oldt", "onScrollerViewTouch", "v", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BusinessHorizontalScroller.kt */
public final class BusinessHorizontalScroller extends HorizontalScrollerWithEntrance {

    /* renamed from: a */
    private final String f42406a = "BusinessHorizontalScroller";

    /* renamed from: b */
    private WidgetTriggerBean f42407b;

    /* renamed from: c */
    private WidgetTriggerBean f42408c;

    /* renamed from: d */
    private WidgetTriggerBean f42409d;

    /* renamed from: e */
    private ObjectAnimator f42410e;

    /* renamed from: f */
    private ObjectAnimator f42411f;

    /* renamed from: g */
    private boolean f42412g;

    /* renamed from: h */
    private float f42413h;

    /* renamed from: i */
    private float f42414i;

    /* renamed from: j */
    private float f42415j;

    /* renamed from: k */
    private float f42416k;

    /* renamed from: l */
    private float f42417l;

    /* renamed from: m */
    private float f42418m;

    /* renamed from: n */
    private boolean f42419n;

    /* renamed from: o */
    private boolean f42420o;

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m31913b(View view) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BusinessHorizontalScroller(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final WidgetTriggerBean getWidgetTriggerBean() {
        return this.f42407b;
    }

    public final void setWidgetTriggerBean(WidgetTriggerBean widgetTriggerBean) {
        this.f42407b = widgetTriggerBean;
    }

    public final WidgetTriggerBean getArrowClickBean() {
        return this.f42408c;
    }

    public final void setArrowClickBean(WidgetTriggerBean widgetTriggerBean) {
        this.f42408c = widgetTriggerBean;
    }

    public final WidgetTriggerBean getClickBean() {
        return this.f42409d;
    }

    public final void setClickBean(WidgetTriggerBean widgetTriggerBean) {
        this.f42409d = widgetTriggerBean;
    }

    public final float getActionDownX() {
        return this.f42415j;
    }

    public final void setActionDownX(float f) {
        this.f42415j = f;
    }

    public final float getActionDownY() {
        return this.f42416k;
    }

    public final void setActionDownY(float f) {
        this.f42416k = f;
    }

    public final float getDealtX() {
        return this.f42417l;
    }

    public final void setDealtX(float f) {
        this.f42417l = f;
    }

    public final float getDealtY() {
        return this.f42418m;
    }

    public final void setDealtY(float f) {
        this.f42418m = f;
    }

    public void generateEntrance(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "root");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_dy_business_horizontal_entrance, (ViewGroup) null);
        setEntrance((ViewGroup) inflate.findViewById(R.id.customer_cl_business_entrance));
        ViewGroup entrance = getEntrance();
        if (entrance != null) {
            entrance.setAlpha(0.0f);
        }
        m31908a();
        m31909a(1.0f);
        viewGroup.addView(inflate);
        Intrinsics.checkNotNullExpressionValue(inflate, "entranceView");
        m31911a(inflate);
        inflate.bringToFront();
        viewGroup.addOnLayoutChangeListener(new BusinessHorizontalScroller$generateEntrance$listener$1(inflate, viewGroup));
    }

    /* renamed from: a */
    private final void m31911a(View view) {
        try {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                ((FrameLayout.LayoutParams) layoutParams).bottomMargin = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_n1);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final boolean isInAnim() {
        return this.f42419n;
    }

    public final void setInAnim(boolean z) {
        this.f42419n = z;
    }

    public final boolean isOutAnim() {
        return this.f42420o;
    }

    public final void setOutAnim(boolean z) {
        this.f42420o = z;
    }

    public void mOnScrollChanged(int i, int i2, int i3, int i4) {
        ViewGroup entrance;
        ViewGroup entrance2;
        if (isShowArrow() != 0) {
            if (((float) getMScolledX()) > getAppearThreshold()) {
                LogUtil.m32584d(Intrinsics.stringPlus(this.f42406a, Const.BlockParamConst.APPEAR_THRESHOLD), Intrinsics.stringPlus("vis:", Float.valueOf(getAppearThreshold())));
                if (!this.f42419n) {
                    this.f42419n = true;
                    this.f42420o = false;
                    ObjectAnimator objectAnimator = this.f42410e;
                    if (objectAnimator != null) {
                        objectAnimator.pause();
                    }
                    ObjectAnimator objectAnimator2 = this.f42411f;
                    if (objectAnimator2 != null) {
                        objectAnimator2.start();
                    }
                    WidgetTriggerBean widgetTriggerBean = this.f42408c;
                    if (widgetTriggerBean != null && (entrance2 = getEntrance()) != null) {
                        entrance2.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                BusinessHorizontalScroller.m31912a(WidgetTriggerBean.this, view);
                            }
                        });
                    }
                }
            } else if (!this.f42420o) {
                this.f42420o = true;
                this.f42419n = false;
                LogUtil.m32584d(Intrinsics.stringPlus(this.f42406a, Const.BlockParamConst.APPEAR_THRESHOLD), Intrinsics.stringPlus("gone:", Float.valueOf(getAppearThreshold())));
                ViewGroup entrance3 = getEntrance();
                m31909a(entrance3 == null ? 1.0f : entrance3.getAlpha());
                ObjectAnimator objectAnimator3 = this.f42411f;
                if (objectAnimator3 != null) {
                    objectAnimator3.pause();
                }
                ObjectAnimator objectAnimator4 = this.f42410e;
                if (objectAnimator4 != null) {
                    objectAnimator4.start();
                }
                if (this.f42408c != null && (entrance = getEntrance()) != null) {
                    entrance.setOnClickListener($$Lambda$BusinessHorizontalScroller$Wmo5ZdRkd7M7FIeCQ8XSlDc3p8.INSTANCE);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31912a(WidgetTriggerBean widgetTriggerBean, View view) {
        Intrinsics.checkNotNullParameter(widgetTriggerBean, "$bean");
        Function3<IBlockScope, Buildable, List<? extends BaseAction>, Unit> handler = widgetTriggerBean.getHandler();
        if (handler != null) {
            handler.invoke(widgetTriggerBean.getScope(), widgetTriggerBean.getWidgetBuildable(), widgetTriggerBean.getActions());
        }
    }

    /* renamed from: a */
    private final void m31908a() {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(getEntrance(), new PropertyValuesHolder[]{ofFloat});
        this.f42411f = ofPropertyValuesHolder;
        if (ofPropertyValuesHolder != null) {
            ofPropertyValuesHolder.setAutoCancel(true);
        }
        ObjectAnimator objectAnimator = this.f42411f;
        if (objectAnimator != null) {
            objectAnimator.setRepeatCount(0);
        }
    }

    /* renamed from: a */
    private final void m31909a(float f) {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("alpha", new float[]{f, 0.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(getEntrance(), new PropertyValuesHolder[]{ofFloat});
        this.f42410e = ofPropertyValuesHolder;
        if (ofPropertyValuesHolder != null) {
            ofPropertyValuesHolder.setAutoCancel(true);
        }
        ObjectAnimator objectAnimator = this.f42410e;
        if (objectAnimator != null) {
            objectAnimator.setRepeatCount(0);
        }
    }

    public boolean onScrollerViewTouch(View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(view, RavenKey.VERSION);
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        super.onScrollerViewTouch(view, motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            boolean z = true;
            if (action == 1) {
                m31910a(motionEvent);
                LogUtil.m32584d(this.f42406a, Intrinsics.stringPlus("ACTION_UP:", Boolean.valueOf(this.f42412g)));
                if (!this.f42412g) {
                    WidgetTriggerBean widgetTriggerBean = this.f42409d;
                    if (widgetTriggerBean == null) {
                        widgetTriggerBean = null;
                    } else {
                        Function3<IBlockScope, Buildable, List<? extends BaseAction>, Unit> handler = widgetTriggerBean.getHandler();
                        if (handler != null) {
                            handler.invoke(widgetTriggerBean.getScope(), widgetTriggerBean.getWidgetBuildable(), widgetTriggerBean.getActions());
                        }
                    }
                    if (widgetTriggerBean == null) {
                        LogUtil.m32584d(this.f42406a, "clickBean is null");
                    }
                }
                this.f42412g = false;
            } else if (action == 2) {
                this.f42417l += this.f42415j - motionEvent.getX();
                this.f42418m += this.f42416k - motionEvent.getY();
                if (Math.abs(this.f42417l) < 5.0f && Math.abs(this.f42418m) < 5.0f) {
                    z = false;
                }
                this.f42412g = z;
                LogUtil.m32584d(this.f42406a, Intrinsics.stringPlus("isMoved:", Boolean.valueOf(z)));
                LogUtil.m32584d(this.f42406a, Intrinsics.stringPlus("dealtX:", Float.valueOf(this.f42417l)));
                LogUtil.m32584d(this.f42406a, Intrinsics.stringPlus("dealtY:", Float.valueOf(this.f42418m)));
            } else if (action == 3) {
                m31910a(motionEvent);
                this.f42412g = false;
                LogUtil.m32584d(this.f42406a, Intrinsics.stringPlus("ACTION_CANCEL:", false));
            }
        } else {
            this.f42415j = motionEvent.getX();
            this.f42416k = motionEvent.getY();
        }
        return false;
    }

    /* renamed from: a */
    private final void m31910a(MotionEvent motionEvent) {
        HashMap<String, Object> contextParams;
        HashMap<String, Object> contextParams2;
        if (this.f42417l > 0.0f) {
            WidgetNodeModel virtualNode = getVirtualNode();
            if (!(virtualNode == null || (contextParams2 = virtualNode.getContextParams()) == null)) {
                contextParams2.put(BlocksConst.DRAG_DIRECTION, 0);
            }
        } else {
            WidgetNodeModel virtualNode2 = getVirtualNode();
            if (!(virtualNode2 == null || (contextParams = virtualNode2.getContextParams()) == null)) {
                contextParams.put(BlocksConst.DRAG_DIRECTION, 1);
            }
        }
        WidgetTriggerBean widgetTriggerBean = this.f42407b;
        if (widgetTriggerBean == null) {
            widgetTriggerBean = null;
        } else {
            Function3<IBlockScope, Buildable, List<? extends BaseAction>, Unit> handler = widgetTriggerBean.getHandler();
            if (handler != null) {
                handler.invoke(widgetTriggerBean.getScope(), widgetTriggerBean.getWidgetBuildable(), widgetTriggerBean.getActions());
            }
        }
        if (widgetTriggerBean == null) {
            LogUtil.m32584d(this.f42406a, "WidgetTriggerBean is null");
        }
        this.f42413h = motionEvent.getX();
        this.f42414i = motionEvent.getY();
        this.f42417l = 0.0f;
        this.f42418m = 0.0f;
    }

    public boolean handleOtherTrigger(IBlockScope iBlockScope, String str, List<? extends BaseAction> list, Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3) {
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        Intrinsics.checkNotNullParameter(function3, "handler");
        if (Intrinsics.areEqual((Object) str, (Object) getOnArrowClick())) {
            this.f42408c = new WidgetTriggerBean(iBlockScope, this, list, function3);
        }
        if (!Intrinsics.areEqual((Object) str, (Object) BlocksConst.BLOCK_ON_DRAGEND)) {
            return true;
        }
        this.f42407b = new WidgetTriggerBean(iBlockScope, this, list, function3);
        return true;
    }

    public boolean handleClickTrigger(IBlockScope iBlockScope, List<? extends BaseAction> list, Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3) {
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        Intrinsics.checkNotNullParameter(function3, "handler");
        this.f42409d = new WidgetTriggerBean(iBlockScope, this, list, function3);
        return true;
    }
}
