package com.didi.component.payentrance.view.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.component.common.loading.AbsLoadingPresenter;
import com.didi.component.core.IPresenter;
import com.didi.component.payentrance.model.Jumpable;
import com.didi.component.payentrance.view.IPayEntranceView;
import com.didi.component.payentrance.view.IPayEntranceViewContainer;
import com.didi.component.payentrance.view.Mode;
import com.didi.unifiedPay.sdk.model.DeductionInfo;
import java.util.List;

public class PayEntranceView implements IPayEntranceViewContainer {

    /* renamed from: a */
    private IPayEntranceView.OnPayListener f16920a;

    /* renamed from: b */
    private IPayEntranceView.OnCancelRuleClickListener f16921b;

    /* renamed from: c */
    private IPayEntranceView.OnJumpableClickListener f16922c;

    /* renamed from: d */
    private IPayEntranceView.OnErrorClickListener f16923d;

    /* renamed from: e */
    private IPayEntranceView.OnInputValueChangeListener f16924e;

    /* renamed from: f */
    private IPayEntranceView.OnBindCardClickListener f16925f;

    /* renamed from: g */
    private Mode f16926g;

    /* renamed from: h */
    private IPresenter f16927h;

    /* renamed from: i */
    private boolean f16928i;
    protected FrameLayout mContainer;
    protected Context mContext;
    protected IPayEntranceView mEntranceView;

    public PayEntranceView(Context context) {
        this.mContext = context;
        FrameLayout frameLayout = new FrameLayout(context);
        this.mContainer = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void setMode(Mode mode) {
        if (this.f16926g != mode) {
            this.f16926g = mode;
            m14179a(createViewByMode(mode, this.f16928i));
            m14178a();
        }
    }

    public void hide() {
        this.mContainer.setVisibility(8);
    }

    /* renamed from: a */
    private void m14178a() {
        setOnPayListener(this.f16920a);
        setOnCancelRuleClickListener(this.f16921b);
        setOnJumpableClickListener(this.f16922c);
        setOnErrorListener(this.f16923d);
        setOnInputValueChangeListener(this.f16924e);
        setOnBindCardClickListener(this.f16925f);
    }

    public Mode getMode() {
        IPayEntranceView iPayEntranceView = this.mEntranceView;
        if (iPayEntranceView != null) {
            return iPayEntranceView.getMode();
        }
        return null;
    }

    public void showLoading() {
        IPresenter iPresenter = this.f16927h;
        if (iPresenter instanceof AbsLoadingPresenter) {
            ((AbsLoadingPresenter) iPresenter).showLoading();
        }
        IPayEntranceView iPayEntranceView = this.mEntranceView;
        if (iPayEntranceView != null) {
            iPayEntranceView.showLoading();
        }
    }

    public void hideLoading() {
        IPresenter iPresenter = this.f16927h;
        if (iPresenter instanceof AbsLoadingPresenter) {
            ((AbsLoadingPresenter) iPresenter).hideLoading();
        }
        IPayEntranceView iPayEntranceView = this.mEntranceView;
        if (iPayEntranceView != null) {
            iPayEntranceView.hideLoading();
        }
    }

    public void showError(CharSequence charSequence) {
        IPayEntranceView iPayEntranceView = this.mEntranceView;
        if (iPayEntranceView != null) {
            iPayEntranceView.showError(charSequence);
        }
    }

    public void hideError() {
        IPayEntranceView iPayEntranceView = this.mEntranceView;
        if (iPayEntranceView != null) {
            iPayEntranceView.hideError();
        }
    }

    public void setOnErrorListener(IPayEntranceView.OnErrorClickListener onErrorClickListener) {
        this.f16923d = onErrorClickListener;
        IPayEntranceView iPayEntranceView = this.mEntranceView;
        if (iPayEntranceView != null) {
            iPayEntranceView.setOnErrorListener(onErrorClickListener);
        }
    }

    public void setInputLabel(CharSequence charSequence) {
        IPayEntranceView iPayEntranceView = this.mEntranceView;
        if (iPayEntranceView != null) {
            iPayEntranceView.setInputLabel(charSequence);
        }
    }

    public void setInputHint(CharSequence charSequence) {
        IPayEntranceView iPayEntranceView = this.mEntranceView;
        if (iPayEntranceView != null) {
            iPayEntranceView.setInputHint(charSequence);
        }
    }

    public void setOnInputValueChangeListener(IPayEntranceView.OnInputValueChangeListener onInputValueChangeListener) {
        this.f16924e = onInputValueChangeListener;
        IPayEntranceView iPayEntranceView = this.mEntranceView;
        if (iPayEntranceView != null) {
            iPayEntranceView.setOnInputValueChangeListener(onInputValueChangeListener);
        }
    }

    public void setPayWay(String str) {
        IPayEntranceView iPayEntranceView = this.mEntranceView;
        if (iPayEntranceView != null) {
            iPayEntranceView.setPayWay(str);
        }
    }

    public void showBindCard(boolean z) {
        IPayEntranceView iPayEntranceView = this.mEntranceView;
        if (iPayEntranceView != null) {
            iPayEntranceView.showBindCard(z);
        }
    }

    public void setOnBindCardClickListener(IPayEntranceView.OnBindCardClickListener onBindCardClickListener) {
        this.f16925f = onBindCardClickListener;
        IPayEntranceView iPayEntranceView = this.mEntranceView;
        if (iPayEntranceView != null) {
            iPayEntranceView.setOnBindCardClickListener(onBindCardClickListener);
        }
    }

    /* renamed from: a */
    private void m14179a(View view) {
        this.mContainer.addView(view, new ViewGroup.LayoutParams(-1, -2));
        if (this.mContainer.getChildCount() > 1) {
            this.mContainer.removeViewAt(0);
        }
    }

    public void setFeeDescribe(CharSequence charSequence) {
        IPayEntranceView iPayEntranceView = this.mEntranceView;
        if (iPayEntranceView != null) {
            iPayEntranceView.setFeeDescribe(charSequence);
        }
    }

    public void setPrice(double d) {
        IPayEntranceView iPayEntranceView = this.mEntranceView;
        if (iPayEntranceView != null) {
            iPayEntranceView.setPrice(d);
        }
    }

    public void setPrice(String str) {
        IPayEntranceView iPayEntranceView = this.mEntranceView;
        if (iPayEntranceView != null) {
            iPayEntranceView.setPrice(str);
        }
    }

    public void setMessage(CharSequence charSequence) {
        IPayEntranceView iPayEntranceView = this.mEntranceView;
        if (iPayEntranceView != null) {
            iPayEntranceView.setMessage(charSequence);
        }
    }

    public void setCouponSupplement(String str, String str2) {
        IPayEntranceView iPayEntranceView = this.mEntranceView;
        if (iPayEntranceView != null) {
            iPayEntranceView.setCouponSupplement(str, str2);
        }
    }

    public void addSupplement(DeductionInfo deductionInfo, String str) {
        IPayEntranceView iPayEntranceView = this.mEntranceView;
        if (iPayEntranceView != null) {
            iPayEntranceView.addSupplement(deductionInfo, str);
        }
    }

    public void removeSupplement() {
        IPayEntranceView iPayEntranceView = this.mEntranceView;
        if (iPayEntranceView != null) {
            iPayEntranceView.removeSupplement();
        }
    }

    public void setActionText(String str) {
        IPayEntranceView iPayEntranceView = this.mEntranceView;
        if (iPayEntranceView != null) {
            iPayEntranceView.setActionText(str);
        }
    }

    public void setActionButtonEnable(boolean z) {
        IPayEntranceView iPayEntranceView = this.mEntranceView;
        if (iPayEntranceView != null) {
            iPayEntranceView.setActionButtonEnable(z);
        }
    }

    public void setOnPayListener(IPayEntranceView.OnPayListener onPayListener) {
        IPayEntranceView iPayEntranceView = this.mEntranceView;
        if (iPayEntranceView != null) {
            iPayEntranceView.setOnPayListener(onPayListener);
        } else {
            this.f16920a = onPayListener;
        }
    }

    public void setIconShow(boolean z) {
        IPayEntranceView iPayEntranceView = this.mEntranceView;
        if (iPayEntranceView != null) {
            iPayEntranceView.setIconShow(z);
        }
    }

    public void setJumpableItems(List<Jumpable> list) {
        IPayEntranceView iPayEntranceView = this.mEntranceView;
        if (iPayEntranceView != null) {
            iPayEntranceView.setJumpableItems(list);
        }
    }

    public void setOnJumpableClickListener(IPayEntranceView.OnJumpableClickListener onJumpableClickListener) {
        IPayEntranceView iPayEntranceView = this.mEntranceView;
        if (iPayEntranceView != null) {
            iPayEntranceView.setOnJumpableClickListener(onJumpableClickListener);
        } else {
            this.f16922c = onJumpableClickListener;
        }
    }

    public void setCancelRuleShow(boolean z) {
        IPayEntranceView iPayEntranceView = this.mEntranceView;
        if (iPayEntranceView != null) {
            iPayEntranceView.setCancelRuleShow(z);
        }
    }

    public void setOnCancelRuleClickListener(IPayEntranceView.OnCancelRuleClickListener onCancelRuleClickListener) {
        IPayEntranceView iPayEntranceView = this.mEntranceView;
        if (iPayEntranceView != null) {
            iPayEntranceView.setOnCancelRuleClickListener(onCancelRuleClickListener);
        } else {
            this.f16921b = onCancelRuleClickListener;
        }
    }

    public void showTipsCheckbox(String str, boolean z, IPayEntranceView.OnTipsCheckChangeListener onTipsCheckChangeListener) {
        IPayEntranceView iPayEntranceView = this.mEntranceView;
        if (iPayEntranceView != null) {
            iPayEntranceView.showTipsCheckbox(str, z, onTipsCheckChangeListener);
        }
    }

    /* renamed from: com.didi.component.payentrance.view.impl.PayEntranceView$1 */
    static /* synthetic */ class C70571 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$component$payentrance$view$Mode;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.component.payentrance.view.Mode[] r0 = com.didi.component.payentrance.view.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$component$payentrance$view$Mode = r0
                com.didi.component.payentrance.view.Mode r1 = com.didi.component.payentrance.view.Mode.NormalPay     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$component$payentrance$view$Mode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.component.payentrance.view.Mode r1 = com.didi.component.payentrance.view.Mode.SelfInputPay     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$component$payentrance$view$Mode     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.component.payentrance.view.Mode r1 = com.didi.component.payentrance.view.Mode.FinishPay     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$component$payentrance$view$Mode     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.component.payentrance.view.Mode r1 = com.didi.component.payentrance.view.Mode.EvaluatedUnpay     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$component$payentrance$view$Mode     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.component.payentrance.view.Mode r1 = com.didi.component.payentrance.view.Mode.CashPayed     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$didi$component$payentrance$view$Mode     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.component.payentrance.view.Mode r1 = com.didi.component.payentrance.view.Mode.ClosePay     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$didi$component$payentrance$view$Mode     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.didi.component.payentrance.view.Mode r1 = com.didi.component.payentrance.view.Mode.NoStateView     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$didi$component$payentrance$view$Mode     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.didi.component.payentrance.view.Mode r1 = com.didi.component.payentrance.view.Mode.RISKVIEW     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.component.payentrance.view.impl.PayEntranceView.C70571.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public View createViewByMode(Mode mode, boolean z) {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        switch (C70571.$SwitchMap$com$didi$component$payentrance$view$Mode[mode.ordinal()]) {
            case 1:
                if (!z) {
                    this.mEntranceView = new NormalPayView(this.mContext, from, this.mContainer);
                    break;
                } else {
                    this.mEntranceView = new NormalPayNewView(this.mContext, from, this.mContainer);
                    break;
                }
            case 2:
                this.mEntranceView = new SelfInputView(this.mContext, from, this.mContainer);
                break;
            case 3:
                if (!z) {
                    this.mEntranceView = new FinishPayView(this.mContext, from, this.mContainer);
                    break;
                } else {
                    this.mEntranceView = new FinishPayNewView(this.mContext, from, this.mContainer);
                    break;
                }
            case 4:
                this.mEntranceView = new EvaluatedUnpayView(this.mContext, from, this.mContainer);
                break;
            case 5:
                this.mEntranceView = new CashPayView(this.mContext, from, this.mContainer);
                break;
            case 6:
                this.mEntranceView = new PayClosedView(this.mContext, from, this.mContainer);
                break;
            case 7:
                if (!z) {
                    this.mEntranceView = new NoStatePayView(this.mContext, from, this.mContainer);
                    break;
                } else {
                    this.mEntranceView = new NoStatePayNewView(this.mContext, from, this.mContainer);
                    break;
                }
            case 8:
                if (!z) {
                    this.mEntranceView = new RiskView(this.mContext, from, this.mContainer);
                    break;
                } else {
                    this.mEntranceView = new RiskNewView(this.mContext, from, this.mContainer);
                    break;
                }
        }
        this.mEntranceView.setMode(mode);
        return this.mEntranceView.getView();
    }

    public View getView() {
        return this.mContainer;
    }

    public void setPresenter(IPresenter iPresenter) {
        this.f16927h = iPresenter;
    }

    public void setNewCard(boolean z) {
        this.f16928i = z;
    }
}
