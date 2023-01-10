package com.didiglobal.p205sa.biz.component.topbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.didi.component.never.core.IView;
import com.didi.sdk.util.AppUtils;
import com.didiglobal.p205sa.biz.fragment.SaTitleBarFragment;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\n\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo148868d2 = {"Lcom/didiglobal/sa/biz/component/topbar/TopBarView;", "Lcom/didi/component/never/core/IView;", "Lcom/didiglobal/sa/biz/component/topbar/TopBarPresenter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "container", "Landroid/view/ViewGroup;", "divider", "Landroid/view/View;", "fragment", "Lcom/didiglobal/sa/biz/fragment/SaTitleBarFragment;", "presenter", "rootView", "getView", "initListener", "", "initView", "setPresenter", "biz-library_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.topbar.TopBarView */
/* compiled from: TopBarView.kt */
public final class TopBarView implements IView<TopBarPresenter> {

    /* renamed from: a */
    private View f53722a;

    /* renamed from: b */
    private TopBarPresenter f53723b;

    /* renamed from: c */
    private View f53724c;

    /* renamed from: d */
    private ViewGroup f53725d;

    /* renamed from: e */
    private SaTitleBarFragment f53726e = new SaTitleBarFragment();

    /* renamed from: a */
    private final void m40087a() {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m40089a(View view) {
    }

    public TopBarView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        m40088a(context);
        m40087a();
    }

    /* renamed from: a */
    private final void m40088a(Context context) {
        ViewGroup.LayoutParams layoutParams = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.sa_component_top_bar, (ViewGroup) null, false);
        this.f53722a = inflate;
        if (inflate != null) {
            inflate.setOnClickListener($$Lambda$TopBarView$bA1aNwXyDhwtMXXizXdU_VM94.INSTANCE);
        }
        View view = this.f53722a;
        this.f53724c = view == null ? null : view.findViewById(R.id.divider);
        View view2 = this.f53722a;
        this.f53725d = view2 == null ? null : (ViewGroup) view2.findViewById(R.id.container);
        if (context instanceof FragmentActivity) {
            ((FragmentActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.container, this.f53726e).commitAllowingStateLoss();
        }
        View view3 = this.f53724c;
        if (view3 != null) {
            layoutParams = view3.getLayoutParams();
        }
        int statusBarHeight = AppUtils.getStatusBarHeight(context);
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).topMargin = statusBarHeight;
        }
    }

    public View getView() {
        return this.f53722a;
    }

    public void setPresenter(TopBarPresenter topBarPresenter) {
        this.f53723b = topBarPresenter;
    }
}
