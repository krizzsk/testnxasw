package com.didi.payment.base.utils;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.soda.blocks.constant.Const;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 <2\u00020\u0001:\u0001<B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u000201J2\u00103\u001a\u0002012\b\b\u0002\u00104\u001a\u00020\u00162\n\b\u0002\u00105\u001a\u0004\u0018\u00010,2\b\b\u0002\u00106\u001a\u00020\u00162\n\b\u0002\u00107\u001a\u0004\u0018\u00010,J2\u00108\u001a\u0002012\b\b\u0002\u00104\u001a\u00020\u00162\n\b\u0002\u00109\u001a\u0004\u0018\u00010,2\b\b\u0002\u00106\u001a\u00020\u00162\n\b\u0002\u00107\u001a\u0004\u0018\u00010,J\u0006\u0010:\u001a\u000201J\u0012\u0010;\u001a\u0002012\b\u0010;\u001a\u0004\u0018\u00010\u0003H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u00038BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000f\u0010\u000bR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00038BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0013\u0010\u000bR\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u001e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u001e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u001e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00038BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b\u001e\u0010\u000bR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000¨\u0006="}, mo148868d2 = {"Lcom/didi/payment/base/utils/LoadingController;", "", "originalView", "Landroid/view/View;", "loadingConfig", "Lcom/didi/payment/base/utils/ILoadingConfig;", "(Landroid/view/View;Lcom/didi/payment/base/utils/ILoadingConfig;)V", "currentViewIndex", "", "customView", "getCustomView", "()Landroid/view/View;", "setCustomView", "(Landroid/view/View;)V", "emptyView", "getEmptyView", "emptyView$delegate", "Lkotlin/Lazy;", "errorView", "getErrorView", "errorView$delegate", "<set-?>", "", "isCustom", "()Z", "isEmpty", "isError", "isLoading", "isOriginal", "loadingView", "getLoadingView", "loadingView$delegate", "onEmptyBtnClickListener", "Landroid/view/View$OnClickListener;", "getOnEmptyBtnClickListener", "()Landroid/view/View$OnClickListener;", "setOnEmptyBtnClickListener", "(Landroid/view/View$OnClickListener;)V", "onErrorBtnClickListener", "getOnErrorBtnClickListener", "setOnErrorBtnClickListener", "parentView", "Landroid/view/ViewGroup;", "preEmptyButtonText", "", "preEmptyMsg", "preErrorButtonText", "preErrorMsg", "revert", "", "showCustom", "showEmpty", "showMsg", "emptyMsg", "showButton", "buttonText", "showError", "errorMsg", "showLoading", "showView", "Companion", "base_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: LoadingController.kt */
public final class LoadingController {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final View f32449a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final ILoadingConfig f32450b;

    /* renamed from: c */
    private View.OnClickListener f32451c;

    /* renamed from: d */
    private View.OnClickListener f32452d;

    /* renamed from: e */
    private final ViewGroup f32453e;

    /* renamed from: f */
    private final int f32454f;

    /* renamed from: g */
    private final Lazy f32455g;

    /* renamed from: h */
    private final Lazy f32456h;

    /* renamed from: i */
    private final Lazy f32457i;

    /* renamed from: j */
    private boolean f32458j;

    /* renamed from: k */
    private boolean f32459k;

    /* renamed from: l */
    private boolean f32460l;

    /* renamed from: m */
    private boolean f32461m;

    /* renamed from: n */
    private boolean f32462n;

    /* renamed from: o */
    private View f32463o;

    /* renamed from: p */
    private String f32464p;

    /* renamed from: q */
    private String f32465q;

    /* renamed from: r */
    private String f32466r;

    /* renamed from: s */
    private String f32467s;

    public /* synthetic */ LoadingController(View view, ILoadingConfig iLoadingConfig, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, iLoadingConfig);
    }

    private LoadingController(View view, ILoadingConfig iLoadingConfig) {
        this.f32449a = view;
        this.f32450b = iLoadingConfig;
        this.f32455g = LazyKt.lazy(new LoadingController$loadingView$2(this));
        this.f32456h = LazyKt.lazy(new LoadingController$errorView$2(this));
        this.f32457i = LazyKt.lazy(new LoadingController$emptyView$2(this));
        boolean z = true;
        if (this.f32449a != null) {
            if (!(this.f32450b != null)) {
                throw new IllegalArgumentException("loadingConfig is null".toString());
            } else if (this.f32449a.getParent() instanceof ViewGroup) {
                ViewParent parent = this.f32449a.getParent();
                if (parent != null) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    this.f32453e = viewGroup;
                    int indexOfChild = viewGroup.indexOfChild(this.f32449a);
                    this.f32454f = indexOfChild;
                    if (!(indexOfChild == -1 ? false : z)) {
                        throw new IllegalArgumentException("cannot find originalView index from it's parent!".toString());
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            } else {
                throw new IllegalArgumentException("originalView's parentView is not ViewGroup".toString());
            }
        } else {
            throw new IllegalArgumentException("originalView is null".toString());
        }
    }

    @Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006¨\u0006\r"}, mo148868d2 = {"Lcom/didi/payment/base/utils/LoadingController$Companion;", "", "()V", "create", "Lcom/didi/payment/base/utils/LoadingController;", "originalView", "Landroid/view/View;", "loadingConfig", "Lcom/didi/payment/base/utils/ILoadingConfig;", "replaceView", "", "src", "target", "base_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: LoadingController.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LoadingController create(View view, ILoadingConfig iLoadingConfig) {
            Intrinsics.checkNotNullParameter(view, "originalView");
            Intrinsics.checkNotNullParameter(iLoadingConfig, "loadingConfig");
            return new LoadingController(view, iLoadingConfig, (DefaultConstructorMarker) null);
        }

        public final void replaceView(View view, View view2) {
            int indexOfChild;
            Intrinsics.checkNotNullParameter(view, Const.BlockParamConst.SRC);
            Intrinsics.checkNotNullParameter(view2, "target");
            ViewParent parent = view.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null && (indexOfChild = viewGroup.indexOfChild(view)) != -1) {
                viewGroup.removeViewAt(indexOfChild);
                viewGroup.addView(view2, indexOfChild, view.getLayoutParams());
            }
        }
    }

    public final View.OnClickListener getOnErrorBtnClickListener() {
        return this.f32451c;
    }

    public final void setOnErrorBtnClickListener(View.OnClickListener onClickListener) {
        this.f32451c = onClickListener;
    }

    public final View.OnClickListener getOnEmptyBtnClickListener() {
        return this.f32452d;
    }

    public final void setOnEmptyBtnClickListener(View.OnClickListener onClickListener) {
        this.f32452d = onClickListener;
    }

    /* renamed from: a */
    private final View m24611a() {
        return (View) this.f32455g.getValue();
    }

    /* renamed from: b */
    private final View m24613b() {
        return (View) this.f32456h.getValue();
    }

    /* renamed from: c */
    private final View m24614c() {
        return (View) this.f32457i.getValue();
    }

    public final boolean isLoading() {
        return this.f32458j;
    }

    public final boolean isError() {
        return this.f32459k;
    }

    public final boolean isEmpty() {
        return this.f32460l;
    }

    public final boolean isOriginal() {
        return this.f32461m;
    }

    public final boolean isCustom() {
        return this.f32462n;
    }

    public final View getCustomView() {
        return this.f32463o;
    }

    public final void setCustomView(View view) {
        this.f32463o = view;
    }

    public final void showLoading() {
        View a = m24611a();
        if (a != null) {
            View findViewById = a.findViewById(this.f32450b.getLoadingViewId());
            if ((findViewById instanceof ImageView) && (findViewById.getBackground() instanceof AnimationDrawable)) {
                Drawable background = findViewById.getBackground();
                if (background != null) {
                    ((AnimationDrawable) background).start();
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
                }
            }
            m24612a(m24611a());
        }
    }

    public final void revert() {
        View a;
        if (this.f32458j && (a = m24611a()) != null) {
            View findViewById = a.findViewById(this.f32450b.getLoadingViewId());
            if ((findViewById instanceof ImageView) && (findViewById.getBackground() instanceof AnimationDrawable)) {
                Drawable background = findViewById.getBackground();
                if (background != null) {
                    ((AnimationDrawable) background).stop();
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
                }
            }
        }
        m24612a(this.f32449a);
    }

    public static /* synthetic */ void showError$default(LoadingController loadingController, boolean z, String str, boolean z2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        loadingController.showError(z, str, z2, str2);
    }

    public final void showError(boolean z, String str, boolean z2, String str2) {
        View b = m24613b();
        View view = null;
        View findViewById = b == null ? null : b.findViewById(this.f32450b.getErrorTextId());
        if (findViewById != null) {
            if (z) {
                if (findViewById.getVisibility() != 0) {
                    findViewById.setVisibility(0);
                }
                if (!Intrinsics.areEqual((Object) this.f32464p, (Object) str) && (findViewById instanceof TextView)) {
                    ((TextView) findViewById).setText(str);
                    this.f32464p = str;
                }
            } else if (findViewById.getVisibility() != 8) {
                findViewById.setVisibility(8);
            }
        }
        View b2 = m24613b();
        if (b2 != null) {
            view = b2.findViewById(this.f32450b.getErrorButtonId());
        }
        if (view != null) {
            if (z2) {
                if (view.getVisibility() != 0) {
                    view.setVisibility(0);
                }
                if (!Intrinsics.areEqual((Object) this.f32465q, (Object) str2) && (view instanceof TextView)) {
                    ((TextView) view).setText(str2);
                    this.f32465q = str2;
                }
                view.setOnClickListener(getOnErrorBtnClickListener());
            } else if (view.getVisibility() != 8) {
                view.setVisibility(8);
            }
        }
        m24612a(m24613b());
    }

    public static /* synthetic */ void showEmpty$default(LoadingController loadingController, boolean z, String str, boolean z2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        loadingController.showEmpty(z, str, z2, str2);
    }

    public final void showEmpty(boolean z, String str, boolean z2, String str2) {
        View c = m24614c();
        View view = null;
        View findViewById = c == null ? null : c.findViewById(this.f32450b.getEmptyTextId());
        if (findViewById != null) {
            if (z) {
                if (findViewById.getVisibility() != 0) {
                    findViewById.setVisibility(0);
                }
                if (!Intrinsics.areEqual((Object) this.f32466r, (Object) str) && (findViewById instanceof TextView)) {
                    ((TextView) findViewById).setText(str);
                    this.f32466r = str;
                }
            } else if (findViewById.getVisibility() != 8) {
                findViewById.setVisibility(8);
            }
        }
        View c2 = m24614c();
        if (c2 != null) {
            view = c2.findViewById(this.f32450b.getEmptyButtonId());
        }
        if (view != null) {
            if (z2) {
                if (view.getVisibility() != 0) {
                    view.setVisibility(0);
                }
                if (!Intrinsics.areEqual((Object) this.f32467s, (Object) str2) && (view instanceof TextView)) {
                    ((TextView) view).setText(str2);
                    this.f32467s = str2;
                }
                view.setOnClickListener(getOnEmptyBtnClickListener());
            } else if (view.getVisibility() != 8) {
                view.setVisibility(8);
            }
        }
        m24612a(m24614c());
    }

    public final void showCustom() {
        m24612a(this.f32463o);
    }

    /* renamed from: a */
    private final void m24612a(View view) {
        if (view != null && this.f32453e.getChildAt(this.f32454f) != view) {
            this.f32453e.removeViewAt(this.f32454f);
            this.f32453e.addView(view, this.f32454f, this.f32449a.getLayoutParams());
            boolean z = true;
            this.f32458j = view == m24611a();
            this.f32459k = view == m24613b();
            this.f32460l = view == m24614c();
            this.f32461m = view == this.f32449a;
            if (view != getCustomView()) {
                z = false;
            }
            this.f32462n = z;
        }
    }
}
