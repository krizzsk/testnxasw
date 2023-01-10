package com.didi.soda.home.manager;

import android.content.Context;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.soda.home.topgun.widget.floatlayout.FloatLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo148867d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00162\u00020\u0001:\u0005\u0016\u0017\u0018\u0019\u001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bJ\u0006\u0010\u0012\u001a\u00020\nJ\u0006\u0010\u0013\u001a\u00020\nJ\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo148868d2 = {"Lcom/didi/soda/home/manager/HomeRocketLaunchAnimManager;", "", "()V", "TAG", "", "mHomeListScrollChangeListener", "Lcom/didi/soda/home/manager/HomeRocketLaunchAnimManager$OnHomeListScrollChangeListener;", "mScrollToTopCallBack", "Lcom/didi/soda/home/manager/HomeRocketLaunchAnimManager$OnHomeScrollToTopCallBack;", "attach", "", "ctx", "Landroid/content/Context;", "recyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/NovaRecyclerView;", "floatLayout", "Lcom/didi/soda/home/topgun/widget/floatlayout/FloatLayout;", "onHomeScrollToTopCallBack", "backToTop", "release", "setOnHomeListScrollChangeListener", "homeListScrollChangeListener", "Companion", "Holder", "OnHomeListScrollChangeListener", "OnHomeScrollToTopCallBack", "ShowRocketScene", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HomeRocketLaunchAnimManager.kt */
public final class HomeRocketLaunchAnimManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static HomeRocketLaunchAnimManager f45160d = Holder.INSTANCE.getHolder();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public OnHomeListScrollChangeListener f45161a;

    /* renamed from: b */
    private OnHomeScrollToTopCallBack f45162b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String f45163c;

    @Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, mo148868d2 = {"Lcom/didi/soda/home/manager/HomeRocketLaunchAnimManager$OnHomeListScrollChangeListener;", "", "onScrollDownMoreThanOnePage", "", "onScrollUpLessThanOnePage", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: HomeRocketLaunchAnimManager.kt */
    public interface OnHomeListScrollChangeListener {
        void onScrollDownMoreThanOnePage();

        void onScrollUpLessThanOnePage();
    }

    @Metadata(mo148867d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo148868d2 = {"Lcom/didi/soda/home/manager/HomeRocketLaunchAnimManager$OnHomeScrollToTopCallBack;", "", "scrollToTop", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: HomeRocketLaunchAnimManager.kt */
    public interface OnHomeScrollToTopCallBack {
        void scrollToTop();
    }

    public /* synthetic */ HomeRocketLaunchAnimManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private HomeRocketLaunchAnimManager() {
        this.f45163c = "HomeRocketLaunchAnimManager";
    }

    @Metadata(mo148867d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, mo148868d2 = {"Lcom/didi/soda/home/manager/HomeRocketLaunchAnimManager$ShowRocketScene;", "", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: HomeRocketLaunchAnimManager.kt */
    public @interface ShowRocketScene {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int Default = 0;
        public static final int LessThanOnePage = 2;
        public static final int MoreThanOnePage = 1;

        @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/soda/home/manager/HomeRocketLaunchAnimManager$ShowRocketScene$Companion;", "", "()V", "Default", "", "LessThanOnePage", "MoreThanOnePage", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
        /* compiled from: HomeRocketLaunchAnimManager.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int Default = 0;
            public static final int LessThanOnePage = 2;
            public static final int MoreThanOnePage = 1;

            private Companion() {
            }
        }
    }

    public final void attach(Context context, NovaRecyclerView novaRecyclerView, FloatLayout floatLayout, OnHomeScrollToTopCallBack onHomeScrollToTopCallBack) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        Intrinsics.checkNotNullParameter(floatLayout, "floatLayout");
        Intrinsics.checkNotNullParameter(onHomeScrollToTopCallBack, "onHomeScrollToTopCallBack");
        Ref.IntRef intRef = new Ref.IntRef();
        Ref.IntRef intRef2 = new Ref.IntRef();
        if (novaRecyclerView != null) {
            novaRecyclerView.addOnScrollListener(new HomeRocketLaunchAnimManager$attach$1(intRef2, context, floatLayout, intRef, this));
        }
        this.f45162b = onHomeScrollToTopCallBack;
    }

    public final void setOnHomeListScrollChangeListener(OnHomeListScrollChangeListener onHomeListScrollChangeListener) {
        Intrinsics.checkNotNullParameter(onHomeListScrollChangeListener, "homeListScrollChangeListener");
        this.f45161a = onHomeListScrollChangeListener;
    }

    public final void backToTop() {
        OnHomeScrollToTopCallBack onHomeScrollToTopCallBack = this.f45162b;
        if (onHomeScrollToTopCallBack != null) {
            onHomeScrollToTopCallBack.scrollToTop();
        }
    }

    public final void release() {
        this.f45161a = null;
        this.f45162b = null;
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, mo148868d2 = {"Lcom/didi/soda/home/manager/HomeRocketLaunchAnimManager$Holder;", "", "()V", "holder", "Lcom/didi/soda/home/manager/HomeRocketLaunchAnimManager;", "getHolder", "()Lcom/didi/soda/home/manager/HomeRocketLaunchAnimManager;", "setHolder", "(Lcom/didi/soda/home/manager/HomeRocketLaunchAnimManager;)V", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: HomeRocketLaunchAnimManager.kt */
    private static final class Holder {
        public static final Holder INSTANCE = new Holder();
        private static HomeRocketLaunchAnimManager holder = new HomeRocketLaunchAnimManager((DefaultConstructorMarker) null);

        private Holder() {
        }

        public final HomeRocketLaunchAnimManager getHolder() {
            return holder;
        }

        public final void setHolder(HomeRocketLaunchAnimManager homeRocketLaunchAnimManager) {
            Intrinsics.checkNotNullParameter(homeRocketLaunchAnimManager, "<set-?>");
            holder = homeRocketLaunchAnimManager;
        }
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, mo148868d2 = {"Lcom/didi/soda/home/manager/HomeRocketLaunchAnimManager$Companion;", "", "()V", "<set-?>", "Lcom/didi/soda/home/manager/HomeRocketLaunchAnimManager;", "instance", "getInstance", "()Lcom/didi/soda/home/manager/HomeRocketLaunchAnimManager;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: HomeRocketLaunchAnimManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HomeRocketLaunchAnimManager getInstance() {
            return HomeRocketLaunchAnimManager.f45160d;
        }
    }
}
