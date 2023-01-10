package com.didi.soda.customer.widget.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.soda.customer.animation.CustomerVerticalTransformAnimation;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.MaxHeightScrollView;
import com.didi.soda.customer.widget.dialog.CustomerCommonDialog;
import com.didi.soda.customer.widget.dialog.DialogBuilder;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.customer.widget.text.IconTextView;
import com.taxis99.R;

public class CustomerBottomDialog extends Dialog implements BottomSheetDialog {
    public static final int ANIMATION_DURATION = 300;

    /* renamed from: a */
    private LinearLayout f44315a;

    /* renamed from: b */
    private DialogBuilder.CustomerDialogModel f44316b;

    /* renamed from: c */
    private Context f44317c;

    /* renamed from: d */
    private IconTextView f44318d;

    /* renamed from: e */
    private TextView f44319e;

    /* renamed from: f */
    private TextView f44320f;

    /* renamed from: g */
    private View.OnClickListener f44321g = new View.OnClickListener() {
        public final void onClick(View view) {
            CustomerBottomDialog.this.m32952b(view);
        }
    };

    public void onDestroy() {
    }

    public void onDismiss() {
    }

    public void onShow() {
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m32952b(View view) {
        dismiss();
    }

    public CustomerBottomDialog(Context context, DialogBuilder.CustomerDialogModel customerDialogModel) {
        this.f44316b = customerDialogModel;
        this.f44317c = context;
    }

    public View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.f44315a = (LinearLayout) layoutInflater.inflate(R.layout.customer_dialog_bottom_base, viewGroup, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.f44315a.setLayoutParams(layoutParams);
        m32953e();
        return this.f44315a;
    }

    public TransformAnimation getEnterAnimation() {
        return new CustomerVerticalTransformAnimation(300, true, new DecelerateInterpolator());
    }

    public TransformAnimation getExitAnimation() {
        return new CustomerVerticalTransformAnimation(300, true, new DecelerateInterpolator());
    }

    public boolean onHandleBack() {
        DialogBuilder.CustomerDialogModel customerDialogModel = this.f44316b;
        if (!(customerDialogModel == null || customerDialogModel.mOnHandleBackListener == null)) {
            this.f44316b.mOnHandleBackListener.onClick((View) null);
        }
        return super.onHandleBack();
    }

    /* renamed from: e */
    private void m32953e() {
        this.f44318d = (IconTextView) this.f44315a.findViewById(R.id.customer_custom_common_dialog_close);
        CustomerAppCompatTextView customerAppCompatTextView = (CustomerAppCompatTextView) this.f44315a.findViewById(R.id.customer_custom_common_dialog_title);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(customerAppCompatTextView, IToolsService.FontType.MEDIUM);
        View findViewById = this.f44315a.findViewById(R.id.customer_view_dialog_shadow);
        MaxHeightScrollView maxHeightScrollView = (MaxHeightScrollView) this.f44315a.findViewById(R.id.customer_custom_container);
        TextView textView = (TextView) this.f44315a.findViewById(R.id.customer_custom_common_dialog_confirm);
        this.f44319e = textView;
        textView.setTextColor(SkinUtil.getUponBrandPrimaryTextColorStateList());
        this.f44320f = (TextView) this.f44315a.findViewById(R.id.customer_custom_common_dialog_cancle);
        maxHeightScrollView.setMinimumHeight((CustomerSystemUtil.getScreenHeight(this.f44317c) / 4) - ResourceHelper.getDimensionPixelSize(R.dimen.customer_70px));
        maxHeightScrollView.setOnScrollChangeListener(new MaxHeightScrollView.OnScrollChangeListener() {
            public final void onScrollChanged(int i, int i2, int i3, int i4) {
                CustomerBottomDialog.m32949a(View.this, i, i2, i3, i4);
            }
        });
        DialogBuilder.CustomerDialogModel customerDialogModel = this.f44316b;
        if (customerDialogModel != null) {
            setCancelable(customerDialogModel.mCancelable);
            if (!TextUtils.isEmpty(this.f44316b.title)) {
                customerAppCompatTextView.setText(this.f44316b.title);
            }
            m32950a(this.f44319e, this.f44316b.mMainAction);
            m32950a(this.f44320f, this.f44316b.mSubAction1);
            if (this.f44316b.mContentView != null) {
                maxHeightScrollView.addView(this.f44316b.mContentView);
            }
        }
        this.f44318d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CustomerBottomDialog.this.m32948a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m32949a(View view, int i, int i2, int i3, int i4) {
        if (i2 > 0) {
            view.setVisibility(0);
        } else {
            view.setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m32948a(View view) {
        dismiss();
        DialogBuilder.CustomerDialogModel customerDialogModel = this.f44316b;
        if (customerDialogModel != null && customerDialogModel.onCloseListener != null) {
            this.f44316b.onCloseListener.onClick(view);
        }
    }

    /* renamed from: a */
    private void m32950a(TextView textView, CustomerCommonDialog.DialogAction dialogAction) {
        textView.setText(dialogAction.mActionName);
        textView.setVisibility(0);
        if (dialogAction.mListener == null) {
            textView.setOnClickListener(this.f44321g);
        } else {
            textView.setOnClickListener(new View.OnClickListener(dialogAction) {
                public final /* synthetic */ CustomerCommonDialog.DialogAction f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    CustomerBottomDialog.this.m32951a(this.f$1, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m32951a(CustomerCommonDialog.DialogAction dialogAction, View view) {
        if (dialogAction.mIsAutoDismiss) {
            dismiss();
        }
        dialogAction.mListener.onClick(view);
    }
}
