package com.didi.payment.wallet_ui.loading;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo148867d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001b\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/loading/ViewController;", "", "originalView", "Landroid/view/View;", "customView", "(Landroid/view/View;Landroid/view/View;)V", "currentViewIndex", "", "<set-?>", "", "isCustom", "()Z", "isOriginal", "parentView", "Landroid/view/ViewGroup;", "revert", "", "showCustom", "showView", "Companion", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ViewController.kt */
public final class ViewController {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final View f35637a;

    /* renamed from: b */
    private final View f35638b;

    /* renamed from: c */
    private final ViewGroup f35639c;

    /* renamed from: d */
    private final int f35640d;

    /* renamed from: e */
    private boolean f35641e;

    /* renamed from: f */
    private boolean f35642f;

    public /* synthetic */ ViewController(View view, View view2, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, view2);
    }

    private ViewController(View view, View view2) {
        int i;
        this.f35637a = view;
        this.f35638b = view2;
        ViewGroup viewGroup = null;
        ViewParent parent = view == null ? null : view.getParent();
        viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : viewGroup;
        this.f35639c = viewGroup;
        if (viewGroup == null) {
            i = -1;
        } else {
            i = viewGroup.indexOfChild(this.f35637a);
        }
        this.f35640d = i;
    }

    @Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006¨\u0006\f"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/loading/ViewController$Companion;", "", "()V", "create", "Lcom/didi/payment/wallet_ui/loading/ViewController;", "originalView", "Landroid/view/View;", "customView", "replaceView", "", "src", "target", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: ViewController.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewController create(View view, View view2) {
            return new ViewController(view, view2, (DefaultConstructorMarker) null);
        }

        public final void replaceView(View view, View view2) {
            int indexOfChild;
            if (view != null && view2 != null) {
                ViewParent parent = view.getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null && (indexOfChild = viewGroup.indexOfChild(view)) != -1) {
                    viewGroup.removeViewAt(indexOfChild);
                    viewGroup.addView(view2, indexOfChild, view.getLayoutParams());
                }
            }
        }
    }

    public final boolean isOriginal() {
        return this.f35641e;
    }

    public final boolean isCustom() {
        return this.f35642f;
    }

    public final void showCustom() {
        View view = this.f35638b;
        if (view != null) {
            if ((view instanceof ImageView) && (view.getBackground() instanceof AnimationDrawable)) {
                Drawable background = view.getBackground();
                if (background != null) {
                    ((AnimationDrawable) background).start();
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
                }
            }
            m26907a(view);
        }
    }

    public final void revert() {
        View view;
        if (this.f35642f && (view = this.f35638b) != null && (view instanceof ImageView) && (view.getBackground() instanceof AnimationDrawable)) {
            Drawable background = view.getBackground();
            if (background != null) {
                ((AnimationDrawable) background).stop();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
            }
        }
        m26907a(this.f35637a);
    }

    /* renamed from: a */
    private final void m26907a(View view) {
        ViewGroup viewGroup;
        int i;
        if (view != null && this.f35637a != null && (viewGroup = this.f35639c) != null && (i = this.f35640d) != -1 && viewGroup.getChildAt(i) != view) {
            this.f35639c.removeViewAt(this.f35640d);
            this.f35639c.addView(view, this.f35640d, this.f35637a.getLayoutParams());
            boolean z = true;
            this.f35641e = view == this.f35637a;
            if (view != this.f35638b) {
                z = false;
            }
            this.f35642f = z;
        }
    }
}
