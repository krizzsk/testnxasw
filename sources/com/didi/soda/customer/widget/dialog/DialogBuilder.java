package com.didi.soda.customer.widget.dialog;

import android.view.View;
import android.widget.ImageView;
import com.didi.soda.customer.widget.dialog.CustomerCommonDialog;
import rui.base.ImageLoader;
import rui.widget.dialog.DialogModel;

public class DialogBuilder {

    /* renamed from: a */
    private String f44393a;

    /* renamed from: b */
    private String f44394b;

    /* renamed from: c */
    private boolean f44395c = false;

    /* renamed from: d */
    private View.OnClickListener f44396d;

    /* renamed from: e */
    private View.OnClickListener f44397e;

    /* renamed from: f */
    private ImageLoader f44398f;

    /* renamed from: g */
    private ImageLoader f44399g;

    /* renamed from: h */
    private boolean f44400h;

    /* renamed from: i */
    private View f44401i;

    /* renamed from: j */
    private CustomerCommonDialog.DialogAction f44402j;

    /* renamed from: k */
    private CustomerCommonDialog.DialogAction f44403k;

    /* renamed from: l */
    private CustomerCommonDialog.DialogAction f44404l;

    public static class CustomerDialogModel extends DialogModel {
        public boolean mCancelable = false;
        public View mContentView;
        public CustomerCommonDialog.DialogAction mMainAction;
        public View.OnClickListener mOnHandleBackListener;
        public CustomerCommonDialog.DialogAction mSubAction1;
        public CustomerCommonDialog.DialogAction mSubAction2;
    }

    public DialogBuilder addMainAction(CustomerCommonDialog.DialogAction dialogAction) {
        this.f44404l = dialogAction;
        return this;
    }

    public DialogBuilder addSubAction1(String str) {
        this.f44402j = new CustomerCommonDialog.DialogAction(str, (View.OnClickListener) null);
        return this;
    }

    public DialogBuilder addSubAction1(CustomerCommonDialog.DialogAction dialogAction) {
        this.f44402j = dialogAction;
        return this;
    }

    public DialogBuilder addSubAction2(String str) {
        this.f44403k = new CustomerCommonDialog.DialogAction(str, (View.OnClickListener) null);
        return this;
    }

    public DialogBuilder addSubAction2(CustomerCommonDialog.DialogAction dialogAction) {
        this.f44403k = dialogAction;
        return this;
    }

    public CustomerDialogModel build() {
        CustomerDialogModel customerDialogModel = new CustomerDialogModel();
        customerDialogModel.title = this.f44393a;
        customerDialogModel.content = this.f44394b;
        customerDialogModel.headerImage = this.f44398f;
        customerDialogModel.iconImage = this.f44399g;
        customerDialogModel.hasClose = this.f44395c;
        customerDialogModel.onCloseListener = this.f44396d;
        customerDialogModel.mOnHandleBackListener = this.f44397e;
        customerDialogModel.mContentView = this.f44401i;
        customerDialogModel.mMainAction = this.f44404l;
        customerDialogModel.mSubAction1 = this.f44402j;
        customerDialogModel.mSubAction2 = this.f44403k;
        customerDialogModel.mCancelable = this.f44400h;
        return customerDialogModel;
    }

    public boolean getCancelable() {
        return this.f44400h;
    }

    public DialogBuilder setCancelable(boolean z) {
        this.f44400h = z;
        return this;
    }

    public DialogBuilder setContent(String str) {
        this.f44394b = str;
        return this;
    }

    public DialogBuilder setContent(View view) {
        this.f44401i = view;
        return this;
    }

    public DialogBuilder setHasClose(boolean z) {
        this.f44395c = z;
        return this;
    }

    public DialogBuilder setHeaderBackground(final int i) {
        this.f44398f = new ImageLoader() {
            public void load(ImageView imageView) {
                imageView.setBackgroundResource(i);
            }
        };
        return this;
    }

    public DialogBuilder setIconImage(final int i) {
        this.f44399g = new ImageLoader() {
            public void load(ImageView imageView) {
                imageView.setBackgroundResource(i);
            }
        };
        return this;
    }

    public DialogBuilder setOnCloseListener(View.OnClickListener onClickListener) {
        this.f44396d = onClickListener;
        return this;
    }

    public DialogBuilder setOnHandleBackListener(View.OnClickListener onClickListener) {
        this.f44397e = onClickListener;
        return this;
    }

    public DialogBuilder setTitle(String str) {
        this.f44393a = str;
        return this;
    }
}
