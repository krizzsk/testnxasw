package com.didiglobal.p205sa.biz.component.welcome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.component.never.core.IView;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.sdk.app.DIDIApplication;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0003J\u0015\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\u0007H\u0016J\u0012\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo148868d2 = {"Lcom/didiglobal/sa/biz/component/welcome/WelcomeView;", "Lcom/didi/component/never/core/IView;", "Lcom/didiglobal/sa/biz/component/welcome/WelcomePresenter;", "()V", "throld", "", "view", "Landroid/view/View;", "changeColorByPos", "", "scrollY", "(Ljava/lang/Integer;)V", "getView", "setPresenter", "p0", "biz-library_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.welcome.WelcomeView */
/* compiled from: WelcomeView.kt */
public final class WelcomeView implements IView<WelcomePresenter> {

    /* renamed from: a */
    private View f53728a;

    /* renamed from: b */
    private int f53729b = UiUtils.dip2px(DIDIApplication.getAppContext(), 15.0f);

    public void setPresenter(WelcomePresenter welcomePresenter) {
    }

    public View getView() {
        View findViewById;
        Context appContext = DIDIApplication.getAppContext();
        ViewGroup.LayoutParams layoutParams = null;
        View inflate = LayoutInflater.from(appContext).inflate(R.layout.sa_component_welcome, (ViewGroup) null, false);
        this.f53728a = inflate;
        if (!(inflate == null || (findViewById = inflate.findViewById(R.id.container)) == null)) {
            layoutParams = findViewById.getLayoutParams();
        }
        if (layoutParams != null) {
            ((ConstraintLayout.LayoutParams) layoutParams).height = UIUtils.getStatusBarHeight(appContext);
            View view = this.f53728a;
            Intrinsics.checkNotNull(view);
            return view;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void changeColorByPos(Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() < this.f53729b) {
            View view = this.f53728a;
            if (view != null) {
                view.setAlpha(((((float) num.intValue()) * 1.0f) / ((float) this.f53729b)) * 0.7f);
                return;
            }
            return;
        }
        View view2 = this.f53728a;
        if (view2 != null) {
            view2.setAlpha(0.7f);
        }
    }
}
