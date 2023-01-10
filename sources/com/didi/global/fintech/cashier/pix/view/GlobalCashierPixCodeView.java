package com.didi.global.fintech.cashier.pix.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.global.fintech.cashier.core.contract.IPresenter;
import com.didi.global.fintech.cashier.core.contract.IView;
import com.didi.global.fintech.cashier.p118ui.util.ThemeManager;
import com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixController;
import com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixPresenter;
import com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixView;
import com.taxis99.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class GlobalCashierPixCodeView extends FrameLayout implements IGlobalCashierPixView {

    /* renamed from: a */
    private Button f23518a;

    /* renamed from: b */
    private Button f23519b;

    /* renamed from: c */
    private Button f23520c;

    /* renamed from: d */
    private TextView f23521d;

    /* renamed from: e */
    private TextView f23522e;

    /* renamed from: f */
    private TextView f23523f;

    /* renamed from: g */
    private String f23524g;

    /* renamed from: h */
    private IGlobalCashierPixPresenter f23525h;

    public ViewGroup getView() {
        return this;
    }

    public GlobalCashierPixCodeView(Context context) {
        super(context);
        m19216a();
    }

    public GlobalCashierPixCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19216a();
    }

    public GlobalCashierPixCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19216a();
    }

    /* renamed from: a */
    private void m19216a() {
        LayoutInflater.from(getContext()).cloneInContext(ThemeManager.getContextThemeWrapper(getContext())).inflate(R.layout.global_cashier_payment_pix_code, this);
        this.f23518a = (Button) findViewById(R.id.btn_pix_code_confirm);
        this.f23519b = (Button) findViewById(R.id.btn_pix_code_paid);
        this.f23520c = (Button) findViewById(R.id.btn_pix_code_cancel);
        this.f23521d = (TextView) findViewById(R.id.tv_pix_code_detail);
        this.f23522e = (TextView) findViewById(R.id.tv_pix_code_title);
        this.f23523f = (TextView) findViewById(R.id.tv_pix_code_info);
        this.f23518a.setText(getResources().getString(R.string.GRider_payment_Copy_PIX_ybbs));
        this.f23519b.setText(getResources().getString(R.string.GRider_payment_I_have_uyIU));
        this.f23520c.setText(getResources().getString(R.string.GRider_payment_Cancel_ntbd));
    }

    public void bindPresenter(IPresenter<? extends IView> iPresenter) {
        this.f23525h = (IGlobalCashierPixPresenter) iPresenter;
    }

    public void updatePixCode(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f23524g = str;
            this.f23521d.setText(str);
        }
    }

    public void setOnConfirmClickListener(Function0<Unit> function0) {
        this.f23518a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                GlobalCashierPixCodeView.m19219c(Function0.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ void m19219c(Function0 function0, View view) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void setOnCancelClickListener(Function0<Unit> function0) {
        this.f23520c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                GlobalCashierPixCodeView.m19218b(Function0.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m19218b(Function0 function0, View view) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void setOnPaidClickListener(Function0<Unit> function0) {
        this.f23519b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Function0.this.invoke();
            }
        });
    }

    public void animExpand(int i) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f23521d, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f23522e, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f23523f, "alpha", new float[]{0.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        animatorSet.setDuration((long) ((int) (((double) i) * 1.5d)));
        animatorSet.start();
    }

    /* renamed from: com.didi.global.fintech.cashier.pix.view.GlobalCashierPixCodeView$1 */
    static /* synthetic */ class C90771 {

        /* renamed from: $SwitchMap$com$didi$global$fintech$cashier$pix$contract$IGlobalCashierPixController$State */
        static final /* synthetic */ int[] f23526x6b7c7572;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixController$State[] r0 = com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixController.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23526x6b7c7572 = r0
                com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixController$State r1 = com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixController.State.Normal     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23526x6b7c7572     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixController$State r1 = com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixController.State.Timeout     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.pix.view.GlobalCashierPixCodeView.C90771.<clinit>():void");
        }
    }

    public void updateState(IGlobalCashierPixController.State state) {
        int i = C90771.f23526x6b7c7572[state.ordinal()];
        int i2 = 0;
        if (i == 1 || i == 2) {
            this.f23518a.setVisibility(state.equals(IGlobalCashierPixController.State.Normal) ? 0 : 8);
            Button button = this.f23519b;
            if (!state.equals(IGlobalCashierPixController.State.Timeout)) {
                i2 = 8;
            }
            button.setVisibility(i2);
            visibility(true);
            return;
        }
        visibility(false);
    }

    public void visibility(boolean z) {
        setVisibility(z ? 0 : 8);
    }
}
