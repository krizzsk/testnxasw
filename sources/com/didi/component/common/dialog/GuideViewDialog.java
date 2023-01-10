package com.didi.component.common.dialog;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.component.common.dialog.IDialog;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.taxis99.R;

public class GuideViewDialog extends BaseCustomViewDialog {

    /* renamed from: a */
    private TextView f13386a;

    /* renamed from: b */
    private LinearLayout f13387b;

    /* renamed from: c */
    private boolean f13388c;

    /* renamed from: d */
    private BusinessContext f13389d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AlertDialogFragment f13390e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View f13391f;

    public GuideViewDialog(BusinessContext businessContext) {
        super(businessContext.getContext());
        this.f13389d = businessContext;
    }

    /* access modifiers changed from: protected */
    public View customView() {
        View inflate = this.mInflate.inflate(R.layout.comp_dialog_guide_custom, (ViewGroup) null);
        this.f13391f = inflate;
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void initView(View view) {
        this.f13386a = (TextView) view.findViewById(R.id.gua_new_user_title);
        this.f13387b = (LinearLayout) view.findViewById(R.id.gua_new_user_item_group);
    }

    public void show() {
        if (this.f13390e != null) {
            this.f13388c = true;
            this.f13389d.getNavigation().showDialog(this.f13390e);
        }
    }

    public boolean isShowing() {
        return this.f13388c;
    }

    public void dismiss() {
        if (this.f13390e != null) {
            this.f13389d.getNavigation().dismissDialog(this.f13390e);
            this.f13388c = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11223a(CharSequence charSequence) {
        this.f13386a.setText(charSequence);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11224a(String... strArr) {
        for (String text : strArr) {
            View inflate = this.mInflate.inflate(R.layout.comp_guide_custom_view_item, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.gua_new_user_txt)).setText(text);
            this.f13387b.addView(inflate);
        }
    }

    public static class DialogBuilder {
        private BusinessContext bizContext;
        private GuideViewDialogInfo dialogInfo;
        private Integer mActionHappend;
        private IDialog.DialogListener mListener;
        private AlertDialogFragment.OnClickListener mNegativeListener = new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                DialogBuilder.this.handleOnClick(alertDialogFragment, 1);
            }
        };
        private AlertDialogFragment.OnClickListener mPositiveListener = new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                DialogBuilder.this.handleOnClick(alertDialogFragment, 2);
            }
        };

        public DialogBuilder(BusinessContext businessContext) {
            this.bizContext = businessContext;
        }

        public void setDialogInfo(GuideViewDialogInfo guideViewDialogInfo) {
            this.dialogInfo = guideViewDialogInfo;
        }

        public void setListener(IDialog.DialogListener dialogListener) {
            this.mListener = dialogListener;
        }

        public GuideViewDialog build() {
            GuideViewDialog guideViewDialog = new GuideViewDialog(this.bizContext);
            AlertDialogFragment.Builder builder = new AlertDialogFragment.Builder(this.bizContext.getContext());
            builder.setCancelable(false);
            builder.setContentView(guideViewDialog.f13391f);
            guideViewDialog.m11223a((CharSequence) this.dialogInfo.f13392a);
            guideViewDialog.m11224a(this.dialogInfo.f13393b);
            builder.setNegativeButtonDefault().setNegativeButton((CharSequence) this.dialogInfo.f13394c, this.mNegativeListener);
            builder.setPositiveButtonDefault().setPositiveButton((CharSequence) this.dialogInfo.f13395d, this.mPositiveListener);
            AlertDialogFragment unused = guideViewDialog.f13390e = builder.create();
            return guideViewDialog;
        }

        /* access modifiers changed from: private */
        public void handleOnClick(AlertDialogFragment alertDialogFragment, int i) {
            this.mActionHappend = Integer.valueOf(i);
            IDialog.DialogListener dialogListener = this.mListener;
            if (dialogListener != null) {
                dialogListener.onAction(i);
            }
            if (alertDialogFragment != null && alertDialogFragment.isAdded()) {
                this.bizContext.getNavigation().dismissDialog(alertDialogFragment);
            }
        }
    }
}
