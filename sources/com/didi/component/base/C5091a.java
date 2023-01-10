package com.didi.component.base;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import androidx.fragment.app.Fragment;
import com.didi.component.common.dialog.CommonDialogHandler;
import com.didi.component.common.dialog.DialogHandler;
import com.didi.component.core.IGroupView;
import com.didi.component.core.IPageSwitcher;
import com.didi.component.core.IPresenter;
import com.didi.component.core.PresenterGroup;
import com.didi.component.core.dialog.DialogInfo;
import com.didi.component.core.dialog.ToastHandler;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.IComponent;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didichuxing.omega.sdk.leak.LeakFacade;

@Deprecated
/* renamed from: com.didi.component.base.a */
/* compiled from: BaseFragment */
abstract class C5091a<P extends PresenterGroup> extends Fragment implements KeyEvent.Callback, IGroupView<P>, IComponent<BusinessContext> {

    /* renamed from: a */
    protected P f12827a;

    /* renamed from: b */
    private BusinessContext f12828b;

    /* renamed from: c */
    private IPageSwitcher f12829c;

    /* renamed from: d */
    private ToastHandler f12830d;

    /* renamed from: e */
    private DialogHandler f12831e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View f12832f;

    /* renamed from: g */
    private int f12833g;

    /* renamed from: h */
    private boolean f12834h = false;

    /* renamed from: i */
    private ViewTreeObserver.OnGlobalLayoutListener f12835i = new BaseFragment$1(this);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo50538a(Bundle bundle);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public View mo50539a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo50541a(int i);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo50545a(int i, int i2) {
        return false;
    }

    /* renamed from: a */
    public boolean mo50546a(int i, int i2, Intent intent) {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract int mo50547b(BusinessContext businessContext);

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract P mo50550d();

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo50552f() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo50553g() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void mo50555h() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public void mo50556i() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public void mo50558k() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo50559l() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public Animator mo50560m() {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public Animator mo50561n() {
        return null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return false;
    }

    public void setBackVisible(boolean z) {
    }

    public void setTitle(String str) {
    }

    C5091a() {
    }

    /* renamed from: a */
    public void setBusinessContext(BusinessContext businessContext) {
        this.f12828b = businessContext;
        this.f12833g = mo50547b(businessContext);
        IPageSwitcher iPageSwitcher = this.f12829c;
        if (iPageSwitcher != null) {
            iPageSwitcher.updateBusinessContext(businessContext);
        }
    }

    /* renamed from: a */
    public BusinessContext getBusinessContext() {
        return this.f12828b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final IPageSwitcher mo50548b() {
        IPageSwitcher iPageSwitcher = this.f12829c;
        if (iPageSwitcher != null) {
            return iPageSwitcher;
        }
        IPageSwitcher c = mo50549c();
        this.f12829c = c;
        return c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public IPageSwitcher mo50549c() {
        return new BasePagerSwitcher(getBusinessContext(), this);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        P p;
        if (!mo50546a(i, i2, intent) && (p = this.f12827a) != null) {
            p.onDispatchActivityResult(i, i2, intent);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f12834h = false;
        m10819o();
        this.f12830d = new ToastHandler(getContext());
        this.f12831e = new CommonDialogHandler(getBusinessContext(), this);
        setPresenter(mo50550d());
        this.f12827a.setPageSwitcher(mo50548b());
        this.f12827a.setIView(this);
        View a = mo50539a(layoutInflater, viewGroup, bundle);
        this.f12832f = a;
        a.getViewTreeObserver().addOnGlobalLayoutListener(this.f12835i);
        this.f12827a.dispatchPageCreate();
        return this.f12832f;
    }

    /* renamed from: a */
    public void setPresenter(P p) {
        this.f12827a = p;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo50542a(View view, View view2) {
        if (view2 != null && (view instanceof ViewGroup)) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.setClipChildren(false);
                if (view != parent) {
                    mo50542a(view, (View) viewGroup);
                }
            }
        }
    }

    /* renamed from: o */
    private void m10819o() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            int a = mo50538a(arguments);
            this.f12833g = a;
            if (a > 0) {
                mo50541a(a);
                return;
            }
        }
        int b = mo50547b(getBusinessContext());
        this.f12833g = b;
        if (b > 0) {
            mo50541a(b);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public int mo50551e() {
        return this.f12833g;
    }

    public final void onStart() {
        super.onStart();
        this.f12827a.dispatchPageStart();
        mo50552f();
    }

    public final void onResume() {
        super.onResume();
        this.f12827a.dispatchPageResume();
        mo50553g();
        OmegaSDK.fireFragmentResumed(this);
    }

    public final void onPause() {
        super.onPause();
        this.f12827a.dispatchPagePause();
        mo50555h();
        OmegaSDK.fireFragmentPaused(this);
    }

    public final void onStop() {
        super.onStop();
        this.f12827a.dispatchPageStop();
        mo50556i();
    }

    public final void onDestroyView() {
        this.f12834h = true;
        super.onDestroyView();
        m10820p();
        this.f12827a.dispatchPageDestroy();
        mo50558k();
        this.f12829c = null;
        this.f12827a = null;
        this.f12830d = null;
        this.f12831e = null;
        this.f12832f = null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public boolean mo50557j() {
        return this.f12834h;
    }

    /* renamed from: p */
    private void m10820p() {
        DialogHandler dialogHandler = this.f12831e;
        if (dialogHandler != null) {
            dialogHandler.dismissCurrent();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        LeakFacade.watch(this);
    }

    public final void showDialog(DialogInfo dialogInfo) {
        DialogHandler dialogHandler;
        if (!mo50557j() && (dialogHandler = this.f12831e) != null) {
            dialogHandler.show(dialogInfo);
        }
    }

    public boolean isDialogShowing() {
        return this.f12831e.isDialogShowing();
    }

    public final void dismissDialog(int i) {
        DialogHandler dialogHandler;
        if (!mo50557j() && (dialogHandler = this.f12831e) != null) {
            dialogHandler.dismiss(i);
        }
    }

    public final void onDialogClicked(int i, int i2) {
        P p;
        if (!mo50557j() && !mo50545a(i, i2) && (p = this.f12827a) != null) {
            p.dispatchDialogAction(i, i2);
        }
    }

    public final void showToast(ToastHandler.ToastInfo toastInfo) {
        ToastHandler toastHandler;
        if (!mo50557j() && (toastHandler = this.f12830d) != null) {
            toastHandler.showToast(toastInfo);
        }
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        m10818a(z);
        return super.onCreateAnimation(i, z, i2);
    }

    /* renamed from: a */
    private void m10818a(boolean z) {
        Animator n = !z ? mo50561n() : null;
        if (n != null) {
            n.start();
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (mo50557j() || keyEvent.getKeyCode() != 4) {
            return false;
        }
        DialogHandler dialogHandler = this.f12831e;
        if (dialogHandler == null || !dialogHandler.onBackPressed()) {
            return this.f12827a.dispatchBackPressed(IPresenter.BackType.BackKey);
        }
        return true;
    }
}
