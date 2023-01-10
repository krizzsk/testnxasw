package com.didi.soda.home.widget;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.raven.config.RavenKey;
import com.didi.rfusion.widget.RFTextView;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.home.bub.HomeBubRepo;
import com.didi.soda.home.bub.TaskBubModel;
import com.didichuxing.dfbasesdk.utils.UIHandler;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 62\u00020\u0001:\u00016B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'J\b\u0010(\u001a\u00020%H\u0002J\b\u0010)\u001a\u00020%H\u0002J\b\u0010*\u001a\u00020%H\u0014J\u0006\u0010+\u001a\u00020%J\u0006\u0010,\u001a\u00020%J\b\u0010-\u001a\u00020%H\u0002J\u000e\u0010.\u001a\u00020%2\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010/\u001a\u00020%2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u00100\u001a\u00020%2\u0006\u00101\u001a\u000202J\u0012\u00103\u001a\u00020%2\b\u00104\u001a\u0004\u0018\u00010\u0012H\u0016J\u0006\u00105\u001a\u00020%R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00067"}, mo148868d2 = {"Lcom/didi/soda/home/widget/TaskBubView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "HIDE_X", "", "LAND_X", "SCROLL_X", "clickListener", "Landroid/view/View$OnClickListener;", "deep", "mAnimator", "Landroid/animation/ObjectAnimator;", "model", "Lcom/didi/soda/home/bub/TaskBubModel;", "redirectUrl", "", "runCB", "Ljava/lang/Runnable;", "time", "", "timerTask", "Landroid/os/CountDownTimer;", "getTimerTask", "()Landroid/os/CountDownTimer;", "setTimerTask", "(Landroid/os/CountDownTimer;)V", "addToParent", "", "parent", "Landroid/view/ViewGroup;", "initView", "initX", "onDetachedFromWindow", "onHomeFeedScroll", "onHomeFeedStopScroll", "playAnim", "randerView", "setData", "setEnable", "enable", "", "setOnClickListener", "l", "siu2Hide", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TaskBubView.kt */
public final class TaskBubView extends ConstraintLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: l */
    private static final long f45883l = 5000;

    /* renamed from: a */
    private float f45884a;

    /* renamed from: b */
    private float f45885b;

    /* renamed from: c */
    private float f45886c;

    /* renamed from: d */
    private ObjectAnimator f45887d;

    /* renamed from: e */
    private String f45888e;

    /* renamed from: f */
    private TaskBubModel f45889f;

    /* renamed from: g */
    private final Runnable f45890g = new Runnable() {
        public final void run() {
            TaskBubView.m34032a(TaskBubView.this);
        }
    };

    /* renamed from: h */
    private View.OnClickListener f45891h;

    /* renamed from: i */
    private long f45892i = 1000;

    /* renamed from: j */
    private CountDownTimer f45893j = new TaskBubView$timerTask$1(this, 1000);

    /* renamed from: k */
    private int f45894k;

    public void _$_clearFindViewByIdCache() {
    }

    @Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo148868d2 = {"Lcom/didi/soda/home/widget/TaskBubView$Companion;", "", "()V", "HIDE_INTERVAL", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: TaskBubView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m34032a(TaskBubView taskBubView) {
        Intrinsics.checkNotNullParameter(taskBubView, "this$0");
        HomeBubRepo homeBubRepo = (HomeBubRepo) RepoFactory.getRepo(HomeBubRepo.class);
        TaskBubModel taskBubModel = taskBubView.f45889f;
        if (taskBubModel != null) {
            taskBubModel.setCurrentState(HomeTaskBubStateEnum.INSTANCE.getHIDE());
        }
        Unit unit = Unit.INSTANCE;
        homeBubRepo.setValue(taskBubModel);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.f45891h = onClickListener;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TaskBubView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        m34031a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TaskBubView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
        m34031a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TaskBubView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
        m34031a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TaskBubView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
        m34031a();
    }

    /* renamed from: a */
    private final void m34031a() {
        View.inflate(getContext(), R.layout.customer_widget_task_bub, this);
        LogUtil.m32584d("homebub", Intrinsics.stringPlus("x", Float.valueOf(getX())));
    }

    public final void addToParent(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        viewGroup.addView(this);
    }

    /* renamed from: b */
    private final void m34033b() {
        float measuredWidth = (float) (getMeasuredWidth() - ((LottieAnimationView) findViewById(R.id.icon)).getMeasuredWidth());
        this.f45884a = measuredWidth;
        this.f45885b = (measuredWidth + (((float) ((LottieAnimationView) findViewById(R.id.icon)).getMeasuredWidth()) / 2.0f)) - 10.0f;
        this.f45886c = 0.0f;
    }

    public final void randerView(TaskBubModel taskBubModel) {
        Intrinsics.checkNotNullParameter(taskBubModel, "model");
        setData(taskBubModel);
        UIHandler.post(new Runnable() {
            public final void run() {
                TaskBubView.m34034b(TaskBubView.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m34034b(TaskBubView taskBubView) {
        Intrinsics.checkNotNullParameter(taskBubView, "this$0");
        taskBubView.m34033b();
        taskBubView.m34035c();
        ((HomeBubRepo) RepoFactory.getRepo(HomeBubRepo.class)).setHasSet(true);
    }

    private final void setData(TaskBubModel taskBubModel) {
        TaskBubModel taskBubModel2 = this.f45889f;
        if (taskBubModel2 == null || !Intrinsics.areEqual((Object) taskBubModel2, (Object) taskBubModel)) {
            this.f45889f = taskBubModel;
            FlyImageLoader.loadImage1x1(getContext(), taskBubModel.getIcon()).centerCrop().dontAnimate().placeholder((int) R.drawable.customer_ic_home_bub_default).into((ImageView) (LottieAnimationView) findViewById(R.id.icon));
            CharSequence title = taskBubModel.getTitle();
            boolean z = true;
            if (title == null || title.length() == 0) {
                ((RFTextView) findViewById(R.id.title)).setVisibility(8);
            } else {
                ((RFTextView) findViewById(R.id.title)).setVisibility(0);
                ((RFTextView) findViewById(R.id.title)).setText(taskBubModel.getTitle());
            }
            CharSequence subTitle = taskBubModel.getSubTitle();
            if (!(subTitle == null || subTitle.length() == 0)) {
                z = false;
            }
            if (z) {
                ((RFTextView) findViewById(R.id.sub_title)).setVisibility(8);
            } else {
                ((RFTextView) findViewById(R.id.sub_title)).setVisibility(0);
                ((RFTextView) findViewById(R.id.sub_title)).setText(taskBubModel.getSubTitle());
            }
            this.f45888e = taskBubModel.getRedirectUrl();
        }
    }

    public final CountDownTimer getTimerTask() {
        return this.f45893j;
    }

    public final void setTimerTask(CountDownTimer countDownTimer) {
        this.f45893j = countDownTimer;
    }

    /* renamed from: c */
    private final void m34035c() {
        TaskBubModel taskBubModel = this.f45889f;
        Integer valueOf = taskBubModel == null ? null : Integer.valueOf(taskBubModel.getCurrentState());
        int land = HomeTaskBubStateEnum.INSTANCE.getLAND();
        if (valueOf != null && valueOf.intValue() == land) {
            LogUtil.m32584d("homebub", "randerView LAND");
            if (((HomeBubRepo) RepoFactory.getRepo(HomeBubRepo.class)).getHasSet()) {
                setX(this.f45884a);
                UIHandler.removeCallbacks(this.f45890g);
                LogUtil.m32584d("homebub", "randerView LAND hide");
                return;
            }
            setX(this.f45886c);
            UIHandler.postDelayed(f45883l, this.f45890g);
            LogUtil.m32584d("homebub", "randerView LAND Land");
            return;
        }
        int hide = HomeTaskBubStateEnum.INSTANCE.getHIDE();
        if (valueOf != null && valueOf.intValue() == hide) {
            LogUtil.m32584d("homebub", "randerView HIDE");
            siu2Hide();
            return;
        }
        int scroll = HomeTaskBubStateEnum.INSTANCE.getSCROLL();
        if (valueOf != null && valueOf.intValue() == scroll) {
            LogUtil.m32584d("homebub", "randerView SCROLL");
            UIHandler.removeCallbacks(this.f45890g);
            CountDownTimer countDownTimer = this.f45893j;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            onHomeFeedScroll();
            return;
        }
        int scroll_stop = HomeTaskBubStateEnum.INSTANCE.getSCROLL_STOP();
        if (valueOf != null && valueOf.intValue() == scroll_stop) {
            LogUtil.m32584d("homebub", "randerView SCROLL_STOP");
            CountDownTimer countDownTimer2 = this.f45893j;
            if (countDownTimer2 != null) {
                countDownTimer2.start();
            }
        }
    }

    public final void siu2Hide() {
        ObjectAnimator objectAnimator;
        if (getX() <= this.f45884a) {
            ObjectAnimator objectAnimator2 = this.f45887d;
            if ((objectAnimator2 != null && objectAnimator2.isRunning()) && (objectAnimator = this.f45887d) != null) {
                objectAnimator.cancel();
            }
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(C17272q.f51679a, new float[]{getX(), this.f45884a})});
            this.f45887d = ofPropertyValuesHolder;
            if (ofPropertyValuesHolder != null) {
                ofPropertyValuesHolder.setDuration(300);
            }
            ObjectAnimator objectAnimator3 = this.f45887d;
            if (objectAnimator3 != null) {
                objectAnimator3.addListener(new TaskBubView$siu2Hide$1());
            }
            ObjectAnimator objectAnimator4 = this.f45887d;
            if (objectAnimator4 != null) {
                objectAnimator4.start();
            }
        }
    }

    public final void onHomeFeedScroll() {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = this.f45887d;
        if ((objectAnimator2 != null && objectAnimator2.isRunning()) && (objectAnimator = this.f45887d) != null) {
            objectAnimator.cancel();
        }
        setEnable(false);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(C17272q.f51679a, new float[]{getX(), this.f45885b})});
        this.f45887d = ofPropertyValuesHolder;
        if (ofPropertyValuesHolder != null) {
            ofPropertyValuesHolder.setDuration(300);
        }
        ObjectAnimator objectAnimator3 = this.f45887d;
        if (objectAnimator3 != null) {
            objectAnimator3.addListener(new TaskBubView$onHomeFeedScroll$1());
        }
        ObjectAnimator objectAnimator4 = this.f45887d;
        if (objectAnimator4 != null) {
            objectAnimator4.start();
        }
    }

    public final void setEnable(boolean z) {
        if (z) {
            setAlpha(1.0f);
            setOnClickListener(this.f45891h);
            return;
        }
        setAlpha(0.3f);
        setOnClickListener((View.OnClickListener) null);
    }

    public final void onHomeFeedStopScroll() {
        ObjectAnimator objectAnimator = this.f45887d;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            int i = this.f45894k;
            if (i < 1) {
                this.f45894k = i + 1;
                ObjectAnimator objectAnimator2 = this.f45887d;
                if (objectAnimator2 != null) {
                    objectAnimator2.addListener(new TaskBubView$onHomeFeedStopScroll$1(this));
                    return;
                }
                return;
            }
            ObjectAnimator objectAnimator3 = this.f45887d;
            if (objectAnimator3 != null) {
                objectAnimator3.cancel();
            }
        }
        setEnable(true);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(C17272q.f51679a, new float[]{getX(), this.f45884a})});
        this.f45887d = ofPropertyValuesHolder;
        if (ofPropertyValuesHolder != null) {
            ofPropertyValuesHolder.setDuration(300);
        }
        ObjectAnimator objectAnimator4 = this.f45887d;
        if (objectAnimator4 != null) {
            objectAnimator4.addListener(new TaskBubView$onHomeFeedStopScroll$2());
        }
        ObjectAnimator objectAnimator5 = this.f45887d;
        if (objectAnimator5 != null) {
            objectAnimator5.start();
        }
        this.f45894k = 0;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CountDownTimer countDownTimer = this.f45893j;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f45893j = null;
        ObjectAnimator objectAnimator = this.f45887d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }
}
