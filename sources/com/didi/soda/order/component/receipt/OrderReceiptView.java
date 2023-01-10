package com.didi.soda.order.component.receipt;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.soda.address.AndroidBug5497Workaround;
import com.didi.soda.customer.binder.CustomerDividerLineBinder;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.widget.SendSuccessView;
import com.didi.soda.customer.widget.text.IconTextView;
import com.didi.soda.customer.widget.titlebar.OnBackClickListener;
import com.didi.soda.customer.widget.titlebar.TitleBarView;
import com.didi.soda.order.binder.receipt.OrderReceiptHeaderBinder;
import com.didi.soda.order.binder.receipt.OrderReceiptInputBinder;
import com.didi.soda.order.component.receipt.Contract;
import com.taxis99.R;

class OrderReceiptView extends Contract.AbsOrderReceiptView implements ViewTreeObserver.OnGlobalLayoutListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public View f45999a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TextView f46000b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View f46001c;

    /* renamed from: d */
    private int f46002d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Runnable f46003e;

    /* renamed from: f */
    private Runnable f46004f;

    /* renamed from: g */
    private RecyclerView.OnScrollListener f46005g;
    @BindView(17962)
    RFMainButton mConfirmView;
    @BindView(19229)
    View mDividerLine;
    @BindView(18464)
    IconTextView mPageBackArea;
    @BindView(19120)
    TextView mReceiptTipTv;
    @BindView(18696)
    NovaRecyclerView mRecyclerView;
    @BindView(18508)
    SendSuccessView mSuccessLayout;
    @BindView(18746)
    TitleBarView mTitleView;

    /* access modifiers changed from: protected */
    public boolean useLinearLayout() {
        return true;
    }

    OrderReceiptView() {
    }

    public void onCreate() {
        super.onCreate();
        m34143a();
    }

    public void onGlobalLayout() {
        int height;
        NovaRecyclerView novaRecyclerView = this.mRecyclerView;
        if (novaRecyclerView != null && (height = novaRecyclerView.getHeight()) != this.f46002d) {
            this.f46002d = height;
            getView().postDelayed(this.f46004f, 50);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (getView() != null) {
            getView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
            getView().removeCallbacks(this.f46004f);
        }
        NovaRecyclerView novaRecyclerView = this.mRecyclerView;
        if (novaRecyclerView != null) {
            novaRecyclerView.removeOnScrollListener(this.f46005g);
            this.mRecyclerView.removeCallbacks(this.f46003e);
        }
        KeyboardUtils.hideSoftInput(getContext(), getView());
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_component_send_receipt, viewGroup, true);
    }

    /* access modifiers changed from: protected */
    public INovaRecyclerView generateNovaRecyclerView() {
        return this.mRecyclerView;
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        registerBinder(new OrderReceiptHeaderBinder() {
            public void onBind(View view, TextView textView) {
                View unused = OrderReceiptView.this.f45999a = view;
                TextView unused2 = OrderReceiptView.this.f46000b = textView;
            }
        });
        registerBinder(new OrderReceiptInputBinder(getScopeContext(), ((Contract.AbsOrderReceiptPresenter) getPresenter()).provideComponentLogicUnit()) {
            public void onBind(View view) {
                View unused = OrderReceiptView.this.f46001c = view;
            }
        });
        registerBinder(new CustomerDividerLineBinder());
    }

    /* access modifiers changed from: package-private */
    public void showErrorToast(String str) {
        ToastUtil.showCustomerErrorToast(getScopeContext(), getString(R.string.customer_order_email_verify));
    }

    /* access modifiers changed from: package-private */
    public void updateConfirmButtonState(boolean z, View.OnClickListener onClickListener) {
        this.mConfirmView.setClickable(z);
        this.mConfirmView.setOnClickListener(onClickListener);
    }

    /* access modifiers changed from: package-private */
    public void updateViewStyle(boolean z) {
        if (z) {
            this.mConfirmView.setText(getString(R.string.customer_order_send_text));
            this.mReceiptTipTv.setVisibility(8);
            return;
        }
        this.mConfirmView.setText(getString(R.string.customer_receipt_save));
        this.mReceiptTipTv.setVisibility(0);
    }

    /* access modifiers changed from: package-private */
    public void showLoading() {
        this.mConfirmView.setLoading(true);
        hideSoftInput();
    }

    /* access modifiers changed from: package-private */
    public void hideLoading() {
        this.mConfirmView.setLoading(false);
    }

    /* access modifiers changed from: package-private */
    public void hideSoftInput() {
        KeyboardUtils.hideSoftInput(getContext(), this.f46001c);
    }

    /* access modifiers changed from: package-private */
    public void showSendSuccessView(String str) {
        this.mRecyclerView.setVisibility(4);
        this.mConfirmView.setVisibility(4);
        this.mSuccessLayout.showSendSuccessView(str, new View.OnClickListener() {
            public final void onClick(View view) {
                OrderReceiptView.this.m34150c(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m34150c(View view) {
        ((Contract.AbsOrderReceiptPresenter) getPresenter()).goBack();
    }

    /* renamed from: a */
    private void m34143a() {
        this.mTitleView.setTitleText((int) R.string.customer_order_send_receipts);
        this.mTitleView.setOnBackClickListener(new OnBackClickListener() {
            public final void onBackClick(View view) {
                OrderReceiptView.this.m34148b(view);
            }
        });
        this.mConfirmView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OrderReceiptView.this.m34144a(view);
            }
        });
        C148963 r0 = new RecyclerView.OnScrollListener() {
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                OrderReceiptView.this.mRecyclerView.post(OrderReceiptView.this.f46003e);
            }
        };
        this.f46005g = r0;
        this.mRecyclerView.addOnScrollListener(r0);
        this.f46003e = new Runnable() {
            public final void run() {
                OrderReceiptView.this.m34151d();
            }
        };
        this.f46004f = new Runnable() {
            public final void run() {
                OrderReceiptView.this.m34149c();
            }
        };
        this.mRecyclerView.setDescendantFocusability(131072);
        this.mRecyclerView.setFocusable(true);
        this.mRecyclerView.setFocusableInTouchMode(true);
        this.mRecyclerView.setOnTouchListener($$Lambda$OrderReceiptView$AZjHZsHqYmBEgedwy2Thi66EMBw.INSTANCE);
        getView().getViewTreeObserver().addOnGlobalLayoutListener(this);
        AndroidBug5497Workaround.getInstance((Activity) getContext()).assistComponent(getScopeContext(), getView());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m34148b(View view) {
        m34147b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m34144a(View view) {
        ((Contract.AbsOrderReceiptPresenter) getPresenter()).onConformClicked();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m34151d() {
        NovaRecyclerView novaRecyclerView;
        if (!getScopeContext().getLiveHandler().isDestroyed() && (novaRecyclerView = this.mRecyclerView) != null) {
            int top = novaRecyclerView.getTop();
            View view = this.f45999a;
            if (view != null) {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                int i = iArr[1];
                int height = view.getHeight();
                if (i < 0) {
                    this.mTitleView.getTitleView().setAlpha(1.0f);
                    this.mTitleView.getTitleView().setVisibility(0);
                    this.mDividerLine.setVisibility(0);
                } else if (i > top) {
                    this.mTitleView.getTitleView().setAlpha(0.0f);
                    this.mTitleView.getTitleView().setVisibility(4);
                    this.mDividerLine.setVisibility(4);
                } else {
                    float f = ((float) (top - i)) / ((float) height);
                    this.mTitleView.getTitleView().setAlpha(f);
                    this.mTitleView.getTitleView().setVisibility(0);
                    this.mDividerLine.setAlpha(f);
                    this.mDividerLine.setVisibility(0);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m34149c() {
        NovaRecyclerView novaRecyclerView;
        if (!getScopeContext().getLiveHandler().isDestroyed() && (novaRecyclerView = this.mRecyclerView) != null) {
            ((LinearLayoutManager) novaRecyclerView.getLayoutManager()).scrollToPosition(this.mRecyclerView.getAdapter().getItemCount() - 1);
            this.mRecyclerView.postDelayed(this.f46003e, 50);
        }
    }

    /* renamed from: b */
    private void m34147b() {
        getScopeContext().getNavigator().finish();
    }
}
