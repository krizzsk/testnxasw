package com.didi.soda.customer.widget.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.dialog.CustomerCommonDialog;
import com.didi.soda.customer.widget.dialog.DialogBuilder;
import com.taxis99.R;

public class CustomerPolicyDialog extends Dialog {

    /* renamed from: a */
    private View f44364a;

    /* renamed from: b */
    private TextView f44365b;

    /* renamed from: c */
    private FrameLayout f44366c;

    /* renamed from: d */
    private TextView f44367d;

    /* renamed from: e */
    private TextView f44368e;

    /* renamed from: f */
    private View f44369f;

    /* renamed from: g */
    private Context f44370g;

    /* renamed from: h */
    private DialogBuilder.CustomerDialogModel f44371h;

    /* renamed from: i */
    private View.OnClickListener f44372i = new View.OnClickListener() {
        public void onClick(View view) {
            CustomerPolicyDialog.this.dismiss();
        }
    };

    public TransformAnimation getEnterAnimation() {
        return null;
    }

    public TransformAnimation getExitAnimation() {
        return null;
    }

    public void onDestroy() {
    }

    public void onDismiss() {
    }

    public void onShow() {
    }

    public CustomerPolicyDialog(Context context, DialogBuilder.CustomerDialogModel customerDialogModel) {
        this.f44371h = customerDialogModel;
        this.f44370g = context;
    }

    public View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.f44364a = layoutInflater.inflate(R.layout.customer_dialog_policy, viewGroup, false);
        m32988e();
        return this.f44364a;
    }

    public CustomerPolicyDialog setContent(View view) {
        this.f44366c.addView(view);
        return this;
    }

    public CustomerPolicyDialog setTitle(CharSequence charSequence) {
        this.f44365b.setText(charSequence);
        return this;
    }

    /* renamed from: e */
    private void m32988e() {
        this.f44365b = (TextView) this.f44364a.findViewById(R.id.customer_tv_common_dialog_title);
        this.f44366c = (FrameLayout) this.f44364a.findViewById(R.id.customer_fl_common_dialog_content);
        this.f44367d = (TextView) this.f44364a.findViewById(R.id.customer_tv_common_dialog_sub_action1);
        this.f44368e = (TextView) this.f44364a.findViewById(R.id.customer_tv_common_dialog_main_action);
        this.f44369f = this.f44364a.findViewById(R.id.customer_view_commmon_dialog_divider3);
        this.f44368e.setTextColor(SkinUtil.getDialogMainActionTextColor());
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f44365b, IToolsService.FontType.BOLD);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f44367d, IToolsService.FontType.BOLD);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f44368e, IToolsService.FontType.BOLD);
        DialogBuilder.CustomerDialogModel customerDialogModel = this.f44371h;
        if (customerDialogModel != null) {
            setCancelable(customerDialogModel.mCancelable);
            if (!TextUtils.isEmpty(this.f44371h.title)) {
                setTitle(this.f44371h.title);
            }
            if (this.f44371h.mContentView != null) {
                setContent(this.f44371h.mContentView);
            }
            if (this.f44371h.mMainAction != null) {
                m32987b(this.f44371h.mMainAction);
            }
            if (this.f44371h.mSubAction1 != null) {
                m32986a(this.f44371h.mSubAction1);
            }
        }
    }

    /* renamed from: a */
    private void m32986a(final CustomerCommonDialog.DialogAction dialogAction) {
        this.f44367d.setText(dialogAction.mActionName);
        this.f44367d.setVisibility(0);
        this.f44369f.setVisibility(0);
        if (dialogAction.mListener == null) {
            this.f44367d.setOnClickListener(this.f44372i);
        } else {
            this.f44367d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (dialogAction.mIsAutoDismiss) {
                        CustomerPolicyDialog.this.dismiss();
                    }
                    dialogAction.mListener.onClick(view);
                }
            });
        }
    }

    /* renamed from: b */
    private void m32987b(final CustomerCommonDialog.DialogAction dialogAction) {
        this.f44368e.setText(dialogAction.mActionName);
        if (dialogAction.mListener == null) {
            this.f44368e.setOnClickListener(this.f44372i);
        } else {
            this.f44368e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (dialogAction.mIsAutoDismiss) {
                        CustomerPolicyDialog.this.dismiss();
                    }
                    dialogAction.mListener.onClick(view);
                }
            });
        }
    }
}
