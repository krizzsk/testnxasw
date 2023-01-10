package com.didi.entrega.customer.widget.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.entrega.customer.foundation.skin.SkinUtil;
import com.didi.entrega.customer.widget.dialog.DialogBuilder;
import com.taxis99.R;
import rui.base.ImageLoader;
import rui.util.ViewUtils;

public class CustomerCommonDialog extends Dialog {

    /* renamed from: a */
    private View f22256a;

    /* renamed from: b */
    private ImageView f22257b;

    /* renamed from: c */
    private ImageView f22258c;

    /* renamed from: d */
    private TextView f22259d;

    /* renamed from: e */
    private TextView f22260e;

    /* renamed from: f */
    private FrameLayout f22261f;

    /* renamed from: g */
    private TextView f22262g;

    /* renamed from: h */
    private TextView f22263h;

    /* renamed from: i */
    private TextView f22264i;

    /* renamed from: j */
    private View f22265j;

    /* renamed from: k */
    private LinearLayout f22266k;

    /* renamed from: l */
    private Context f22267l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public DialogBuilder.CustomerDialogModel f22268m;

    /* renamed from: n */
    private View.OnClickListener f22269n = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            CustomerCommonDialog.this.dismiss();
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

    public CustomerCommonDialog(Context context, DialogBuilder.CustomerDialogModel customerDialogModel) {
        this.f22268m = customerDialogModel;
        this.f22267l = context;
    }

    public View initRootView(LayoutInflater layoutInflater) {
        this.f22256a = layoutInflater.inflate(R.layout.entrega_customer_dialog_common, (ViewGroup) null);
        m18367e();
        return this.f22256a;
    }

    public View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.f22256a = layoutInflater.inflate(R.layout.entrega_customer_dialog_common, viewGroup, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.leftMargin = (int) ViewUtils.m7249dp(this.f22267l, 50.0f);
        layoutParams.rightMargin = (int) ViewUtils.m7249dp(this.f22267l, 50.0f);
        this.f22256a.setLayoutParams(layoutParams);
        m18367e();
        return this.f22256a;
    }

    public CustomerCommonDialog setContent(CharSequence charSequence) {
        this.f22260e.setText(charSequence);
        this.f22260e.setVisibility(0);
        return this;
    }

    public CustomerCommonDialog setContent(View view) {
        this.f22261f.addView(view);
        return this;
    }

    public CustomerCommonDialog setTitle(CharSequence charSequence) {
        this.f22259d.setText(charSequence);
        return this;
    }

    /* renamed from: e */
    private void m18367e() {
        this.f22257b = (ImageView) this.f22256a.findViewById(R.id.customer_iv_common_dialog_banner);
        this.f22258c = (ImageView) this.f22256a.findViewById(R.id.customer_iv_common_dialog_close);
        this.f22259d = (TextView) this.f22256a.findViewById(R.id.customer_tv_common_dialog_title);
        this.f22260e = (TextView) this.f22256a.findViewById(R.id.customer_tv_common_dialog_content);
        this.f22261f = (FrameLayout) this.f22256a.findViewById(R.id.customer_fl_common_dialog_content);
        this.f22262g = (TextView) this.f22256a.findViewById(R.id.customer_tv_common_dialog_sub_action1);
        this.f22263h = (TextView) this.f22256a.findViewById(R.id.customer_tv_common_dialog_sub_action2);
        this.f22264i = (TextView) this.f22256a.findViewById(R.id.customer_tv_common_dialog_main_action);
        this.f22266k = (LinearLayout) this.f22256a.findViewById(R.id.customer_ll_common_dialog_action2);
        this.f22265j = this.f22256a.findViewById(R.id.customer_view_commmon_dialog_divider3);
        this.f22264i.setTextColor(SkinUtil.getDialogMainActionTextColor());
        this.f22258c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CustomerCommonDialog.this.dismiss();
                if (CustomerCommonDialog.this.f22268m != null && CustomerCommonDialog.this.f22268m.onCloseListener != null) {
                    CustomerCommonDialog.this.f22268m.onCloseListener.onClick(view);
                }
            }
        });
        DialogBuilder.CustomerDialogModel customerDialogModel = this.f22268m;
        if (customerDialogModel != null) {
            setCancelable(customerDialogModel.mCancelable);
            if (this.f22268m.iconImage != null) {
                m18364a(this.f22268m.iconImage);
            }
            if (this.f22268m.hasClose) {
                m18362a(0);
            }
            if (!TextUtils.isEmpty(this.f22268m.title)) {
                setTitle(this.f22268m.title);
            }
            if (!TextUtils.isEmpty(this.f22268m.content)) {
                setContent(this.f22268m.content);
            }
            if (this.f22268m.mContentView != null) {
                setContent(this.f22268m.mContentView);
            }
            if (this.f22268m.mMainAction != null) {
                m18366c(this.f22268m.mMainAction);
            }
            if (this.f22268m.mSubAction1 != null) {
                m18363a(this.f22268m.mSubAction1);
            }
            if (this.f22268m.mSubAction2 != null) {
                m18365b(this.f22268m.mSubAction2);
            }
            if (this.f22268m.iconImage != null) {
                this.f22260e.setGravity(17);
            } else {
                this.f22260e.setGravity(3);
            }
        }
    }

    /* renamed from: a */
    private void m18364a(ImageLoader imageLoader) {
        this.f22257b.setVisibility(0);
        imageLoader.load(this.f22257b);
    }

    /* renamed from: a */
    private void m18362a(int i) {
        this.f22258c.setVisibility(i);
    }

    /* renamed from: a */
    private void m18363a(final DialogAction dialogAction) {
        this.f22262g.setText(dialogAction.mActionName);
        this.f22262g.setVisibility(0);
        this.f22265j.setVisibility(0);
        if (dialogAction.mListener == null) {
            this.f22262g.setOnClickListener(this.f22269n);
        } else {
            this.f22262g.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (dialogAction.mIsAutoDismiss) {
                        CustomerCommonDialog.this.dismiss();
                    }
                    dialogAction.mListener.onClick(view);
                }
            });
        }
    }

    /* renamed from: b */
    private void m18365b(final DialogAction dialogAction) {
        this.f22263h.setText(dialogAction.mActionName);
        this.f22266k.setVisibility(0);
        if (dialogAction.mListener == null) {
            this.f22263h.setOnClickListener(this.f22269n);
        } else {
            this.f22263h.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (dialogAction.mIsAutoDismiss) {
                        CustomerCommonDialog.this.dismiss();
                    }
                    dialogAction.mListener.onClick(view);
                }
            });
        }
    }

    /* renamed from: c */
    private void m18366c(final DialogAction dialogAction) {
        this.f22264i.setText(dialogAction.mActionName);
        if (dialogAction.mListener == null) {
            this.f22264i.setOnClickListener(this.f22269n);
        } else {
            this.f22264i.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (dialogAction.mIsAutoDismiss) {
                        CustomerCommonDialog.this.dismiss();
                    }
                    dialogAction.mListener.onClick(view);
                }
            });
        }
    }

    public static class DialogAction {
        public String mActionName;
        public boolean mIsAutoDismiss = true;
        public View.OnClickListener mListener;

        public DialogAction(String str) {
            this.mActionName = str;
            this.mListener = null;
        }

        public DialogAction(String str, View.OnClickListener onClickListener) {
            this.mActionName = str;
            this.mListener = onClickListener;
        }

        public DialogAction setAutoDismiss(boolean z) {
            this.mIsAutoDismiss = z;
            return this;
        }
    }
}
