package com.didi.entrega.customer.widget.dialog;

import android.view.View;
import android.widget.ImageView;
import com.didi.entrega.customer.widget.dialog.CustomerCommonDialog;
import rui.base.ImageLoader;
import rui.widget.dialog.DialogModel;

public class DialogBuilder {

    /* renamed from: a */
    private String f22286a;

    /* renamed from: b */
    private String f22287b;

    /* renamed from: c */
    private boolean f22288c = false;

    /* renamed from: d */
    private View.OnClickListener f22289d;

    /* renamed from: e */
    private View.OnClickListener f22290e;

    /* renamed from: f */
    private ImageLoader f22291f;

    /* renamed from: g */
    private ImageLoader f22292g;

    /* renamed from: h */
    private boolean f22293h;

    /* renamed from: i */
    private View f22294i;

    /* renamed from: j */
    private CustomerCommonDialog.DialogAction f22295j;

    /* renamed from: k */
    private CustomerCommonDialog.DialogAction f22296k;

    /* renamed from: l */
    private CustomerCommonDialog.DialogAction f22297l;

    public static class CustomerDialogModel extends DialogModel {
        public boolean mCancelable = false;
        public View mContentView;
        public CustomerCommonDialog.DialogAction mMainAction;
        public View.OnClickListener mOnHandleBackListener;
        public CustomerCommonDialog.DialogAction mSubAction1;
        public CustomerCommonDialog.DialogAction mSubAction2;
    }

    public DialogBuilder addMainAction(CustomerCommonDialog.DialogAction dialogAction) {
        this.f22297l = dialogAction;
        return this;
    }

    public DialogBuilder addSubAction1(String str) {
        this.f22295j = new CustomerCommonDialog.DialogAction(str, (View.OnClickListener) null);
        return this;
    }

    public DialogBuilder addSubAction1(CustomerCommonDialog.DialogAction dialogAction) {
        this.f22295j = dialogAction;
        return this;
    }

    public DialogBuilder addSubAction2(String str) {
        this.f22296k = new CustomerCommonDialog.DialogAction(str, (View.OnClickListener) null);
        return this;
    }

    public DialogBuilder addSubAction2(CustomerCommonDialog.DialogAction dialogAction) {
        this.f22296k = dialogAction;
        return this;
    }

    public CustomerDialogModel build() {
        CustomerDialogModel customerDialogModel = new CustomerDialogModel();
        customerDialogModel.title = this.f22286a;
        customerDialogModel.content = this.f22287b;
        customerDialogModel.headerImage = this.f22291f;
        customerDialogModel.iconImage = this.f22292g;
        customerDialogModel.hasClose = this.f22288c;
        customerDialogModel.onCloseListener = this.f22289d;
        customerDialogModel.mOnHandleBackListener = this.f22290e;
        customerDialogModel.mContentView = this.f22294i;
        customerDialogModel.mMainAction = this.f22297l;
        customerDialogModel.mSubAction1 = this.f22295j;
        customerDialogModel.mSubAction2 = this.f22296k;
        customerDialogModel.mCancelable = this.f22293h;
        return customerDialogModel;
    }

    public boolean getCancelable() {
        return this.f22293h;
    }

    public DialogBuilder setCancelable(boolean z) {
        this.f22293h = z;
        return this;
    }

    public DialogBuilder setContent(String str) {
        this.f22287b = str;
        return this;
    }

    public DialogBuilder setContent(View view) {
        this.f22294i = view;
        return this;
    }

    public DialogBuilder setHasClose(boolean z) {
        this.f22288c = z;
        return this;
    }

    public DialogBuilder setHeaderBackground(final int i) {
        this.f22291f = new ImageLoader() {
            public void load(ImageView imageView) {
                imageView.setBackgroundResource(i);
            }
        };
        return this;
    }

    public DialogBuilder setIconImage(final int i) {
        this.f22292g = new ImageLoader() {
            public void load(ImageView imageView) {
                imageView.setBackgroundResource(i);
            }
        };
        return this;
    }

    public DialogBuilder setOnCloseListener(View.OnClickListener onClickListener) {
        this.f22289d = onClickListener;
        return this;
    }

    public DialogBuilder setOnHandleBackListener(View.OnClickListener onClickListener) {
        this.f22290e = onClickListener;
        return this;
    }

    public DialogBuilder setTitle(String str) {
        this.f22286a = str;
        return this;
    }
}
