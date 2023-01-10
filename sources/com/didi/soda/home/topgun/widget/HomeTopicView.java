package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.home.topgun.binder.HomeTopicBinder;
import com.didi.soda.home.topgun.binder.model.HomeTopicRvModel;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/HomeTopicView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "logic", "Lcom/didi/soda/home/topgun/binder/HomeTopicBinder$Companion$Logic;", "getLogic", "()Lcom/didi/soda/home/topgun/binder/HomeTopicBinder$Companion$Logic;", "setLogic", "(Lcom/didi/soda/home/topgun/binder/HomeTopicBinder$Companion$Logic;)V", "mBgLogo", "Landroid/widget/ImageView;", "mBgView", "mCountDownView", "Lcom/didi/soda/home/topgun/widget/TopicCountDownView;", "mDescView", "Landroid/widget/TextView;", "mItemAdapter", "Lcom/didi/soda/home/topgun/widget/HomeTopicItemAdapter;", "mLeftIcon", "mMoreArrow", "mRecyclerView", "Lcom/didi/soda/home/topgun/widget/HorizontalRecyclerView;", "mRootView", "Landroid/view/View;", "mSceneTitle", "mTopLayout", "topRightImgView", "topRightLottieAnimationView", "Lcom/airbnb/lottie/LottieAnimationView;", "bindData", "", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "rvModel", "Lcom/didi/soda/home/topgun/binder/model/HomeTopicRvModel;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HomeTopicView.kt */
public final class HomeTopicView extends RelativeLayout {

    /* renamed from: a */
    private LottieAnimationView f45714a;

    /* renamed from: b */
    private ImageView f45715b;

    /* renamed from: c */
    private TextView f45716c;

    /* renamed from: d */
    private HorizontalRecyclerView f45717d;

    /* renamed from: e */
    private HomeTopicItemAdapter f45718e;

    /* renamed from: f */
    private View f45719f;

    /* renamed from: g */
    private TextView f45720g;

    /* renamed from: h */
    private TopicCountDownView f45721h;

    /* renamed from: i */
    private View f45722i;

    /* renamed from: j */
    private TextView f45723j;

    /* renamed from: k */
    private ImageView f45724k;

    /* renamed from: l */
    private ImageView f45725l;

    /* renamed from: m */
    private ImageView f45726m;

    /* renamed from: n */
    private HomeTopicBinder.Companion.Logic f45727n;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m33918a(View view) {
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m33920b(View view) {
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeTopicView(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeTopicView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeTopicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.customer_binder_home_topic, this, true);
        View findViewById = inflate.findViewById(R.id.customer_topic_left_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_topic_left_icon)");
        this.f45726m = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_tv_home_sence_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_tv_home_sence_title)");
        this.f45716c = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_fl__home_sence_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.custom…fl__home_sence_container)");
        HorizontalRecyclerView horizontalRecyclerView = (HorizontalRecyclerView) findViewById3;
        this.f45717d = horizontalRecyclerView;
        horizontalRecyclerView.setPadding(CustomerExtentionKt.getPx(R.dimen.customer_25px), 0, CustomerExtentionKt.getPx(R.dimen.customer_25px), 0);
        this.f45718e = new HomeTopicItemAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(inflate.getContext());
        linearLayoutManager.setOrientation(0);
        this.f45717d.setAdapter(this.f45718e);
        this.f45717d.setLayoutManager(linearLayoutManager);
        this.f45717d.setNestedScrollingEnabled(false);
        View findViewById4 = inflate.findViewById(R.id.customer_la_home_sence_animator);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.customer_la_home_sence_animator)");
        this.f45714a = (LottieAnimationView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.customer_tv_home_sence_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.customer_tv_home_sence_desc)");
        this.f45720g = (TextView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.customer_rl_home_sence_root);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.customer_rl_home_sence_root)");
        this.f45719f = findViewById6;
        View findViewById7 = inflate.findViewById(R.id.customer_rl_home_topic_bg);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.customer_rl_home_topic_bg)");
        this.f45724k = (ImageView) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.customer_custom_home_sence_countdown);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.custom…tom_home_sence_countdown)");
        this.f45721h = (TopicCountDownView) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.customer_custom_home_sence_top_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.custom…om_home_sence_top_layout)");
        this.f45722i = findViewById9;
        View findViewById10 = inflate.findViewById(R.id.customer_tv_title_more);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.customer_tv_title_more)");
        this.f45723j = (TextView) findViewById10;
        View findViewById11 = inflate.findViewById(R.id.customer_home_topic_rt_img);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.customer_home_topic_rt_img)");
        this.f45715b = (ImageView) findViewById11;
        View findViewById12 = inflate.findViewById(R.id.customer_rl_home_topic_logo);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.customer_rl_home_topic_logo)");
        this.f45725l = (ImageView) findViewById12;
    }

    public final HomeTopicBinder.Companion.Logic getLogic() {
        return this.f45727n;
    }

    public final void setLogic(HomeTopicBinder.Companion.Logic logic) {
        this.f45727n = logic;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0025, code lost:
        r4 = r4.title;
     */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x02d1  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02d3  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bindData(com.didi.app.nova.skeleton.ScopeContext r19, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            java.lang.String r3 = "scopeContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "rvModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            com.didi.soda.blocks.scope.BlockScopeBase r3 = new com.didi.soda.blocks.scope.BlockScopeBase
            r3.<init>()
            java.lang.String r4 = "scope_context"
            r3.attach(r4, r1)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r4 = r20.getData()
            r5 = 0
            if (r4 != 0) goto L_0x0025
        L_0x0023:
            r4 = r5
            goto L_0x002c
        L_0x0025:
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity$TitleBean r4 = r4.title
            if (r4 != 0) goto L_0x002a
            goto L_0x0023
        L_0x002a:
            java.lang.String r4 = r4.content
        L_0x002c:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r6 = 1
            r7 = 0
            if (r4 == 0) goto L_0x003b
            int r4 = r4.length()
            if (r4 != 0) goto L_0x0039
            goto L_0x003b
        L_0x0039:
            r4 = 0
            goto L_0x003c
        L_0x003b:
            r4 = 1
        L_0x003c:
            r8 = 2
            r9 = 8
            if (r4 == 0) goto L_0x0048
            android.view.View r1 = r0.f45722i
            r1.setVisibility(r9)
            goto L_0x019b
        L_0x0048:
            android.view.View r4 = r0.f45722i
            r4.setVisibility(r7)
            android.widget.TextView r4 = r0.f45716c
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r10 = r20.getData()
            if (r10 != 0) goto L_0x0057
        L_0x0055:
            r10 = r5
            goto L_0x005e
        L_0x0057:
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity$TitleBean r10 = r10.title
            if (r10 != 0) goto L_0x005c
            goto L_0x0055
        L_0x005c:
            java.lang.String r10 = r10.content
        L_0x005e:
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r4.setText(r10)
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r4 = r20.getData()
            if (r4 != 0) goto L_0x006b
        L_0x0069:
            r4 = r5
            goto L_0x009c
        L_0x006b:
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity$TitleBean r4 = r4.title
            if (r4 != 0) goto L_0x0070
            goto L_0x0069
        L_0x0070:
            java.lang.String r4 = r4.icon
            if (r4 != 0) goto L_0x0075
            goto L_0x0069
        L_0x0075:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r10 = r4.length()
            if (r10 <= 0) goto L_0x007f
            r10 = 1
            goto L_0x0080
        L_0x007f:
            r10 = 0
        L_0x0080:
            if (r10 == 0) goto L_0x0099
            android.widget.TextView r10 = r0.f45723j
            r10.setText(r4)
            android.widget.TextView r4 = r0.f45723j
            r4.setVisibility(r7)
            android.view.View r4 = r0.f45722i
            com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicView$P_cp7-0K0AGihrAPaRVxjMYPG4k r10 = new com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicView$P_cp7-0K0AGihrAPaRVxjMYPG4k
            r10.<init>(r2)
            r4.setOnClickListener(r10)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            goto L_0x009c
        L_0x0099:
            r4 = r5
            kotlin.Unit r4 = (kotlin.Unit) r4
        L_0x009c:
            if (r4 != 0) goto L_0x00af
            r4 = r0
            com.didi.soda.home.topgun.widget.HomeTopicView r4 = (com.didi.soda.home.topgun.widget.HomeTopicView) r4
            android.widget.TextView r4 = r0.f45723j
            r4.setVisibility(r9)
            android.view.View r4 = r0.f45722i
            com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicView$lAW5MGuDSp8jshRBaQXekp_dqbY r10 = com.didi.soda.home.topgun.widget.$$Lambda$HomeTopicView$lAW5MGuDSp8jshRBaQXekp_dqbY.INSTANCE
            r4.setOnClickListener(r10)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
        L_0x00af:
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r4 = r20.getData()
            if (r4 != 0) goto L_0x00b7
            r4 = r5
            goto L_0x00b9
        L_0x00b7:
            java.lang.String r4 = r4.titleImg
        L_0x00b9:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            if (r4 == 0) goto L_0x00c6
            int r4 = r4.length()
            if (r4 != 0) goto L_0x00c4
            goto L_0x00c6
        L_0x00c4:
            r4 = 0
            goto L_0x00c7
        L_0x00c6:
            r4 = 1
        L_0x00c7:
            if (r4 == 0) goto L_0x00cf
            android.widget.ImageView r1 = r0.f45726m
            r1.setVisibility(r9)
            goto L_0x00f0
        L_0x00cf:
            android.widget.ImageView r4 = r0.f45726m
            r4.setVisibility(r7)
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r4 = r20.getData()
            if (r4 != 0) goto L_0x00dc
            r4 = r5
            goto L_0x00de
        L_0x00dc:
            java.lang.String r4 = r4.titleImg
        L_0x00de:
            if (r4 == 0) goto L_0x00e1
            goto L_0x00e3
        L_0x00e1:
            java.lang.String r4 = ""
        L_0x00e3:
            com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r1 = com.didi.soda.customer.foundation.util.FlyImageLoader.loadImageUnspecified((com.didi.app.nova.skeleton.ScopeContext) r1, (java.lang.String) r4)
            com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r1 = r1.centerCrop()
            android.widget.ImageView r4 = r0.f45726m
            r1.into((android.widget.ImageView) r4)
        L_0x00f0:
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r1 = r20.getData()
            if (r1 != 0) goto L_0x00f8
        L_0x00f6:
            r1 = r5
            goto L_0x0105
        L_0x00f8:
            com.didi.soda.customer.foundation.rpc.entity.topgun.CountDownEntity r1 = r1.countDown
            if (r1 != 0) goto L_0x00fd
            goto L_0x00f6
        L_0x00fd:
            int r1 = r1.getTime()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x0105:
            if (r1 == 0) goto L_0x0154
            com.didi.soda.home.topgun.widget.TopicCountDownView r1 = r0.f45721h
            long r10 = (long) r8
            long r12 = java.lang.System.currentTimeMillis()
            long r10 = r10 * r12
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r4 = r20.getData()
            r12 = 0
            if (r4 != 0) goto L_0x0119
            goto L_0x0128
        L_0x0119:
            com.didi.soda.customer.foundation.rpc.entity.topgun.CountDownEntity r4 = r4.countDown
            if (r4 != 0) goto L_0x011e
            goto L_0x0128
        L_0x011e:
            int r4 = r4.getTime()
            long r12 = (long) r4
            r4 = 1000(0x3e8, float:1.401E-42)
            long r14 = (long) r4
            long r12 = r12 * r14
        L_0x0128:
            long r10 = r10 + r12
            long r12 = r20.getCreateTime()
            long r10 = r10 - r12
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r4 = r20.getData()
            if (r4 != 0) goto L_0x0136
            r4 = r5
            goto L_0x0138
        L_0x0136:
            com.didi.soda.customer.foundation.rpc.entity.topgun.CountDownEntity r4 = r4.countDown
        L_0x0138:
            r1.setupTimeEntity(r10, r4)
            com.didi.soda.home.topgun.widget.TopicCountDownView r1 = r0.f45721h
            com.didi.soda.home.topgun.widget.HomeTopicView$bindData$3 r4 = new com.didi.soda.home.topgun.widget.HomeTopicView$bindData$3
            r4.<init>(r0)
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r1.setOnTimerFinished(r4)
            com.didi.soda.home.topgun.widget.TopicCountDownView r1 = r0.f45721h
            r1.setVisibility(r7)
            com.didi.soda.home.topgun.widget.TopicCountDownView r1 = r0.f45721h
            com.didi.soda.home.topgun.widget.-$$Lambda$HomeTopicView$hZHrsuZ052y5Fku6WKo7WNfOJwg r4 = com.didi.soda.home.topgun.widget.$$Lambda$HomeTopicView$hZHrsuZ052y5Fku6WKo7WNfOJwg.INSTANCE
            r1.setOnClickListener(r4)
            goto L_0x0159
        L_0x0154:
            com.didi.soda.home.topgun.widget.TopicCountDownView r1 = r0.f45721h
            r1.setVisibility(r9)
        L_0x0159:
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r1 = r20.getData()
            if (r1 != 0) goto L_0x0161
        L_0x015f:
            r1 = r5
            goto L_0x018f
        L_0x0161:
            java.lang.String r1 = r1.ruleDesc
            if (r1 != 0) goto L_0x0166
            goto L_0x015f
        L_0x0166:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x0170
            r1 = 1
            goto L_0x0171
        L_0x0170:
            r1 = 0
        L_0x0171:
            if (r1 == 0) goto L_0x018c
            android.widget.TextView r1 = r0.f45720g
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r4 = r20.getData()
            if (r4 != 0) goto L_0x017d
            r4 = r5
            goto L_0x017f
        L_0x017d:
            java.lang.String r4 = r4.ruleDesc
        L_0x017f:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r4)
            android.widget.TextView r1 = r0.f45720g
            r1.setVisibility(r7)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x018f
        L_0x018c:
            r1 = r5
            kotlin.Unit r1 = (kotlin.Unit) r1
        L_0x018f:
            if (r1 != 0) goto L_0x019b
            r1 = r0
            com.didi.soda.home.topgun.widget.HomeTopicView r1 = (com.didi.soda.home.topgun.widget.HomeTopicView) r1
            android.widget.TextView r1 = r0.f45720g
            r1.setVisibility(r9)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x019b:
            android.widget.ImageView r1 = r0.f45725l
            r1.setVisibility(r9)
            android.widget.ImageView r1 = r0.f45724k
            r1.setBackgroundColor(r7)
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r1 = r20.getData()
            if (r1 != 0) goto L_0x01ad
            r1 = r5
            goto L_0x01af
        L_0x01ad:
            java.lang.String r1 = r1.bgImg
        L_0x01af:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x01bc
            int r1 = r1.length()
            if (r1 != 0) goto L_0x01ba
            goto L_0x01bc
        L_0x01ba:
            r1 = 0
            goto L_0x01bd
        L_0x01bc:
            r1 = 1
        L_0x01bd:
            if (r1 == 0) goto L_0x01dc
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r1 = r20.getData()
            if (r1 != 0) goto L_0x01c7
            r1 = r5
            goto L_0x01c9
        L_0x01c7:
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity$BgColorBean r1 = r1.bgColor
        L_0x01c9:
            if (r1 != 0) goto L_0x01dc
            android.view.View r1 = r0.f45719f
            int r4 = r1.getPaddingLeft()
            android.view.View r10 = r0.f45719f
            int r10 = r10.getPaddingRight()
            r1.setPadding(r4, r7, r10, r7)
            goto L_0x02b2
        L_0x01dc:
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r1 = r20.getData()
            if (r1 != 0) goto L_0x01e4
            r1 = r5
            goto L_0x01e6
        L_0x01e4:
            java.lang.String r1 = r1.bgImg
        L_0x01e6:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x01f3
            int r1 = r1.length()
            if (r1 != 0) goto L_0x01f1
            goto L_0x01f3
        L_0x01f1:
            r1 = 0
            goto L_0x01f4
        L_0x01f3:
            r1 = 1
        L_0x01f4:
            r4 = 2131167534(0x7f07092e, float:1.7949344E38)
            r10 = 2131167748(0x7f070a04, float:1.7949778E38)
            if (r1 != 0) goto L_0x022f
            android.content.Context r1 = r18.getContext()
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r11 = r20.getData()
            if (r11 != 0) goto L_0x0208
            r11 = r5
            goto L_0x020a
        L_0x0208:
            java.lang.String r11 = r11.bgImg
        L_0x020a:
            com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r1 = com.didi.soda.customer.foundation.util.FlyImageLoader.loadImageUnspecified((android.content.Context) r1, (java.lang.String) r11)
            android.widget.ImageView r11 = r0.f45725l
            r1.into((android.widget.ImageView) r11)
            android.widget.ImageView r1 = r0.f45725l
            r1.setVisibility(r7)
            android.view.View r1 = r0.f45719f
            int r11 = r1.getPaddingLeft()
            int r12 = com.didi.soda.customer.foundation.util.ResourceHelper.getDimensionPixelSize(r10)
            android.view.View r13 = r0.f45719f
            int r13 = r13.getPaddingRight()
            int r14 = com.didi.soda.customer.foundation.util.ResourceHelper.getDimensionPixelSize(r4)
            r1.setPadding(r11, r12, r13, r14)
        L_0x022f:
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r1 = r20.getData()
            if (r1 != 0) goto L_0x0237
            r1 = r5
            goto L_0x0239
        L_0x0237:
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity$BgColorBean r1 = r1.bgColor
        L_0x0239:
            if (r1 == 0) goto L_0x02b2
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r1 = r20.getData()
            if (r1 != 0) goto L_0x0242
            goto L_0x029b
        L_0x0242:
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity$BgColorBean r1 = r1.bgColor
            if (r1 != 0) goto L_0x0247
            goto L_0x029b
        L_0x0247:
            android.widget.ImageView r11 = r0.f45724k
            android.graphics.drawable.GradientDrawable r12 = new android.graphics.drawable.GradientDrawable
            r12.<init>()
            java.util.List<java.lang.String> r13 = r1.color     // Catch:{ Exception -> 0x0283 }
            int r13 = r13.size()     // Catch:{ Exception -> 0x0283 }
            int[] r13 = new int[r13]     // Catch:{ Exception -> 0x0283 }
            java.util.List<java.lang.String> r14 = r1.color     // Catch:{ Exception -> 0x0283 }
            java.lang.String r15 = "it.color"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r15)     // Catch:{ Exception -> 0x0283 }
            java.lang.Iterable r14 = (java.lang.Iterable) r14     // Catch:{ Exception -> 0x0283 }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ Exception -> 0x0283 }
            r15 = 0
        L_0x0264:
            boolean r16 = r14.hasNext()     // Catch:{ Exception -> 0x0283 }
            if (r16 == 0) goto L_0x0280
            java.lang.Object r16 = r14.next()     // Catch:{ Exception -> 0x0283 }
            int r17 = r15 + 1
            if (r15 >= 0) goto L_0x0275
            kotlin.collections.CollectionsKt.throwIndexOverflow()     // Catch:{ Exception -> 0x0283 }
        L_0x0275:
            java.lang.String r16 = (java.lang.String) r16     // Catch:{ Exception -> 0x0283 }
            int r16 = android.graphics.Color.parseColor(r16)     // Catch:{ Exception -> 0x0283 }
            r13[r15] = r16     // Catch:{ Exception -> 0x0283 }
            r15 = r17
            goto L_0x0264
        L_0x0280:
            r12.setColors(r13)     // Catch:{ Exception -> 0x0283 }
        L_0x0283:
            int r1 = r1.angle
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            android.graphics.drawable.GradientDrawable$Orientation r1 = com.didi.soda.customer.foundation.util.ExtentionsKt.updateAngle(r12, r1)
            r12.setOrientation(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            android.graphics.drawable.Drawable r12 = (android.graphics.drawable.Drawable) r12
            r11.setBackground(r12)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x029b:
            android.view.View r1 = r0.f45719f
            int r11 = r1.getPaddingLeft()
            int r10 = com.didi.soda.customer.foundation.util.ResourceHelper.getDimensionPixelSize(r10)
            android.view.View r12 = r0.f45719f
            int r12 = r12.getPaddingRight()
            int r4 = com.didi.soda.customer.foundation.util.ResourceHelper.getDimensionPixelSize(r4)
            r1.setPadding(r11, r10, r12, r4)
        L_0x02b2:
            android.widget.ImageView r1 = r0.f45715b
            r1.setVisibility(r9)
            com.airbnb.lottie.LottieAnimationView r1 = r0.f45714a
            r1.setVisibility(r9)
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r1 = r20.getData()
            if (r1 != 0) goto L_0x02c3
            goto L_0x031a
        L_0x02c3:
            java.lang.String r1 = r1.iconImg
            if (r1 != 0) goto L_0x02c8
            goto L_0x031a
        L_0x02c8:
            r4 = r1
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x02d3
            r4 = 1
            goto L_0x02d4
        L_0x02d3:
            r4 = 0
        L_0x02d4:
            if (r4 == 0) goto L_0x0316
            java.lang.String r4 = ".json"
            boolean r4 = kotlin.text.StringsKt.endsWith$default(r1, r4, r7, r8, r5)
            if (r4 == 0) goto L_0x0300
            com.airbnb.lottie.LottieAnimationView r1 = r0.f45714a
            r1.setVisibility(r7)
            com.airbnb.lottie.LottieAnimationView r1 = r0.f45714a
            com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity r4 = r20.getData()
            if (r4 != 0) goto L_0x02ec
            goto L_0x02ee
        L_0x02ec:
            java.lang.String r5 = r4.iconImg
        L_0x02ee:
            r1.setAnimationFromUrl(r5)
            boolean r1 = r20.isPlayingRightTopAnim()
            if (r1 != 0) goto L_0x0316
            r2.setPlayingRightTopAnim(r6)
            com.airbnb.lottie.LottieAnimationView r1 = r0.f45714a
            r1.playAnimation()
            goto L_0x0316
        L_0x0300:
            android.widget.ImageView r4 = r0.f45715b
            r4.setVisibility(r7)
            android.content.Context r4 = r18.getContext()
            com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r1 = com.didi.soda.customer.foundation.util.FlyImageLoader.loadImage1x1((android.content.Context) r4, (java.lang.String) r1)
            com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r1 = r1.centerCrop()
            android.widget.ImageView r4 = r0.f45715b
            r1.into((android.widget.ImageView) r4)
        L_0x0316:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x031a:
            com.didi.soda.home.topgun.widget.HomeTopicItemAdapter r1 = r0.f45718e
            com.didi.soda.home.topgun.binder.HomeTopicBinder$Companion$Logic r4 = r0.f45727n
            r1.setData(r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.widget.HomeTopicView.bindData(com.didi.app.nova.skeleton.ScopeContext, com.didi.soda.home.topgun.binder.model.HomeTopicRvModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m33919a(HomeTopicView homeTopicView, HomeTopicRvModel homeTopicRvModel, View view) {
        Intrinsics.checkNotNullParameter(homeTopicView, "this$0");
        Intrinsics.checkNotNullParameter(homeTopicRvModel, "$rvModel");
        HomeTopicBinder.Companion.Logic logic = homeTopicView.getLogic();
        if (logic != null) {
            logic.toMorePage(homeTopicRvModel, true);
        }
    }
}
