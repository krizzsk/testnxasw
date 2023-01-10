package com.didi.soda.customer.widget.dialog;

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
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.widget.dialog.DialogBuilder;
import com.taxis99.R;
import rui.base.ImageLoader;
import rui.util.ViewUtils;

public class CustomerCommonDialog extends Dialog {

    /* renamed from: a */
    private View f44322a;

    /* renamed from: b */
    private ImageView f44323b;

    /* renamed from: c */
    private ImageView f44324c;

    /* renamed from: d */
    private TextView f44325d;

    /* renamed from: e */
    private TextView f44326e;

    /* renamed from: f */
    private FrameLayout f44327f;

    /* renamed from: g */
    private TextView f44328g;

    /* renamed from: h */
    private TextView f44329h;

    /* renamed from: i */
    private TextView f44330i;

    /* renamed from: j */
    private View f44331j;

    /* renamed from: k */
    private LinearLayout f44332k;

    /* renamed from: l */
    private Context f44333l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public DialogBuilder.CustomerDialogModel f44334m;

    /* renamed from: n */
    private View.OnClickListener f44335n = new View.OnClickListener() {
        public void onClick(View view) {
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
        this.f44334m = customerDialogModel;
        this.f44333l = context;
    }

    public View initRootView(LayoutInflater layoutInflater) {
        this.f44322a = layoutInflater.inflate(R.layout.customer_dialog_common, (ViewGroup) null);
        m32960e();
        return this.f44322a;
    }

    public View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.f44322a = layoutInflater.inflate(R.layout.customer_dialog_common, viewGroup, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.leftMargin = (int) ViewUtils.m7249dp(this.f44333l, 50.0f);
        layoutParams.rightMargin = (int) ViewUtils.m7249dp(this.f44333l, 50.0f);
        this.f44322a.setLayoutParams(layoutParams);
        m32960e();
        return this.f44322a;
    }

    public CustomerCommonDialog setContent(CharSequence charSequence) {
        this.f44326e.setText(charSequence);
        this.f44326e.setVisibility(0);
        return this;
    }

    public CustomerCommonDialog setContent(View view) {
        this.f44327f.addView(view);
        return this;
    }

    public CustomerCommonDialog setTitle(CharSequence charSequence) {
        this.f44325d.setText(charSequence);
        return this;
    }

    /* renamed from: e */
    private void m32960e() {
        this.f44323b = (ImageView) this.f44322a.findViewById(R.id.customer_iv_common_dialog_banner);
        this.f44324c = (ImageView) this.f44322a.findViewById(R.id.customer_iv_common_dialog_close);
        this.f44325d = (TextView) this.f44322a.findViewById(R.id.customer_tv_common_dialog_title);
        this.f44326e = (TextView) this.f44322a.findViewById(R.id.customer_tv_common_dialog_content);
        this.f44327f = (FrameLayout) this.f44322a.findViewById(R.id.customer_fl_common_dialog_content);
        this.f44328g = (TextView) this.f44322a.findViewById(R.id.customer_tv_common_dialog_sub_action1);
        this.f44329h = (TextView) this.f44322a.findViewById(R.id.customer_tv_common_dialog_sub_action2);
        this.f44330i = (TextView) this.f44322a.findViewById(R.id.customer_tv_common_dialog_main_action);
        this.f44332k = (LinearLayout) this.f44322a.findViewById(R.id.customer_ll_common_dialog_action2);
        this.f44331j = this.f44322a.findViewById(R.id.customer_view_commmon_dialog_divider3);
        this.f44330i.setTextColor(SkinUtil.getDialogMainActionTextColor());
        this.f44324c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CustomerCommonDialog.this.dismiss();
                if (CustomerCommonDialog.this.f44334m != null && CustomerCommonDialog.this.f44334m.onCloseListener != null) {
                    CustomerCommonDialog.this.f44334m.onCloseListener.onClick(view);
                }
            }
        });
        DialogBuilder.CustomerDialogModel customerDialogModel = this.f44334m;
        if (customerDialogModel != null) {
            setCancelable(customerDialogModel.mCancelable);
            if (this.f44334m.iconImage != null) {
                m32957a(this.f44334m.iconImage);
            }
            if (this.f44334m.hasClose) {
                m32955a(0);
            }
            if (!TextUtils.isEmpty(this.f44334m.title)) {
                setTitle(this.f44334m.title);
            }
            if (!TextUtils.isEmpty(this.f44334m.content)) {
                setContent(this.f44334m.content);
            }
            if (this.f44334m.mContentView != null) {
                setContent(this.f44334m.mContentView);
            }
            if (this.f44334m.mMainAction != null) {
                m32959c(this.f44334m.mMainAction);
            }
            if (this.f44334m.mSubAction1 != null) {
                m32956a(this.f44334m.mSubAction1);
            }
            if (this.f44334m.mSubAction2 != null) {
                m32958b(this.f44334m.mSubAction2);
            }
            if (this.f44334m.iconImage != null) {
                this.f44326e.setGravity(17);
            } else {
                this.f44326e.setGravity(3);
            }
        }
    }

    /* renamed from: a */
    private void m32957a(ImageLoader imageLoader) {
        this.f44323b.setVisibility(0);
        imageLoader.load(this.f44323b);
    }

    /* renamed from: a */
    private void m32955a(int i) {
        this.f44324c.setVisibility(i);
    }

    /* renamed from: a */
    private void m32956a(final DialogAction dialogAction) {
        this.f44328g.setText(dialogAction.mActionName);
        this.f44328g.setVisibility(0);
        this.f44331j.setVisibility(0);
        if (dialogAction.mListener == null) {
            this.f44328g.setOnClickListener(this.f44335n);
        } else {
            this.f44328g.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (dialogAction.mIsAutoDismiss) {
                        CustomerCommonDialog.this.dismiss();
                    }
                    dialogAction.mListener.onClick(view);
                }
            });
        }
    }

    /* renamed from: b */
    private void m32958b(final DialogAction dialogAction) {
        this.f44329h.setText(dialogAction.mActionName);
        this.f44332k.setVisibility(0);
        if (dialogAction.mListener == null) {
            this.f44329h.setOnClickListener(this.f44335n);
        } else {
            this.f44329h.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (dialogAction.mIsAutoDismiss) {
                        CustomerCommonDialog.this.dismiss();
                    }
                    dialogAction.mListener.onClick(view);
                }
            });
        }
    }

    /* renamed from: c */
    private void m32959c(final DialogAction dialogAction) {
        this.f44330i.setText(dialogAction.mActionName);
        if (dialogAction.mListener == null) {
            this.f44330i.setOnClickListener(this.f44335n);
        } else {
            this.f44330i.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
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
