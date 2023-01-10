package com.didi.sdk.view.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.log.TraceLogUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.view.dialog.AlertController;
import com.didichuxing.bigdata.p174dp.locsdk.Const;

@Deprecated
public class AlertDialogFragment extends AlertDialogBase {

    /* renamed from: a */
    private OnDismissListener f40676a;

    /* renamed from: b */
    private OnCancelListener f40677b;
    protected AlertController mAlertController;

    public interface OnCancelListener {
        void onCancel(AlertDialogFragment alertDialogFragment);
    }

    public interface OnClickListener {
        void onClick(AlertDialogFragment alertDialogFragment, View view);
    }

    public interface OnDismissListener {
        void onDismiss(AlertDialogFragment alertDialogFragment);
    }

    public interface RemindCheckboxListener {
        void onStateChanged(boolean z);
    }

    public AlertController getAlertController() {
        return this.mAlertController;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static AlertDialogFragment m30539b(Context context) {
        AlertDialogFragment alertDialogFragment = new AlertDialogFragment();
        alertDialogFragment.m30540c(context);
        return alertDialogFragment;
    }

    /* access modifiers changed from: protected */
    public View getRootView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        AlertController alertController = this.mAlertController;
        if (alertController != null) {
            return alertController.getLayout();
        }
        UiThreadHandler.post(new Runnable() {
            public void run() {
                AlertDialogFragment.this.dismiss();
            }
        });
        return null;
    }

    public TextView getMessageView() {
        return this.mAlertController.getTextMessage();
    }

    public void show(FragmentManager fragmentManager, String str) {
        try {
            super.show(fragmentManager, str);
            if (this.mAlertController != null) {
                String title = this.mAlertController.getTitle();
                String message = this.mAlertController.getMessage();
                TraceLogUtil.addLogWithTab("alert_stat", "[title" + title + "][msg=" + message + Const.jaRight);
            }
        } catch (Exception e) {
            Log.e("AlertDialogFragment", "show dialog error", e);
        }
    }

    public int show(FragmentTransaction fragmentTransaction, String str) {
        int i = 0;
        try {
            if (!isAdded() && !isVisible()) {
                if (!isRemoving()) {
                    int show = super.show(fragmentTransaction, str);
                    try {
                        if (this.mAlertController == null) {
                            return show;
                        }
                        String title = this.mAlertController.getTitle();
                        String message = this.mAlertController.getMessage();
                        TraceLogUtil.addLogWithTab("alert_stat", "[title" + title + "][msg=" + message + Const.jaRight);
                        return show;
                    } catch (Exception e) {
                        e = e;
                        i = show;
                        Log.e("AlertDialogFragment", "show dialog error", e);
                        return i;
                    }
                }
            }
            return 0;
        } catch (Exception e2) {
            e = e2;
            Log.e("AlertDialogFragment", "show dialog error", e);
            return i;
        }
    }

    public void dismiss() {
        if (getFragmentManager() != null) {
            try {
                super.dismiss();
            } catch (Exception unused) {
            }
        }
    }

    public void dismissAllowingStateLoss() {
        if (getFragmentManager() != null) {
            super.dismissAllowingStateLoss();
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        m30534a();
        OnDismissListener onDismissListener = this.f40676a;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this);
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        OnCancelListener onCancelListener = this.f40677b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(this);
        }
    }

    /* renamed from: c */
    private void m30540c(Context context) {
        this.mAlertController = new AlertController(LayoutInflater.from(context), this);
    }

    /* renamed from: a */
    private void m30534a() {
        ViewParent parent;
        if (getView() != null && (parent = getView().getParent()) != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(getView());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30536a(OnDismissListener onDismissListener) {
        this.f40676a = onDismissListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30535a(OnCancelListener onCancelListener) {
        this.f40677b = onCancelListener;
    }

    public static class Builder {

        /* renamed from: P */
        public AlertController.AlertParams f40678P;

        @Deprecated
        public Builder setIconVisible(boolean z) {
            return this;
        }

        @Deprecated
        public Builder setRemindCheckBox(boolean z, RemindCheckboxListener remindCheckboxListener) {
            return this;
        }

        public Builder(Context context) {
            this.f40678P = new AlertController.AlertParams(context);
        }

        public Context getContext() {
            return this.f40678P.mContext;
        }

        public Builder hideDiverContentLine() {
            this.f40678P.setHideDiverContentLine(true);
            return this;
        }

        public Builder showDiverContentLine() {
            this.f40678P.setHideDiverContentLine(false);
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.f40678P.mCancelable = z;
            return this;
        }

        public Builder setDefaultButtonTxtColor(int i) {
            this.f40678P.mDefaultButtonTextColorId = getContext().getResources().getColor(i);
            return this;
        }

        public Builder setDefaultButtonColor(int i) {
            this.f40678P.mDefaultButtonTextColorId = i;
            return this;
        }

        public Builder setSupprtMullineTitle(boolean z) {
            this.f40678P.isSupportMullineTitle = z;
            return this;
        }

        public Builder setOnDismissListener(OnDismissListener onDismissListener) {
            this.f40678P.mOnDismissListener = onDismissListener;
            return this;
        }

        public Builder setOnCancelListener(OnCancelListener onCancelListener) {
            this.f40678P.mOnCancelListener = onCancelListener;
            return this;
        }

        public Builder setContentView(View view) {
            this.f40678P.mCustomContentView = view;
            return this;
        }

        public Builder setCloseVisible(boolean z) {
            this.f40678P.mIsCloseVisible = z;
            return this;
        }

        public Builder setIcon(int i) {
            this.f40678P.mIconId = i;
            return this;
        }

        public Builder setIcon(Drawable drawable) {
            this.f40678P.mIcon = drawable;
            return this;
        }

        public Builder setIcon(AlertController.IconType iconType) {
            this.f40678P.mIconType = iconType;
            return this;
        }

        public Builder setLink(CharSequence charSequence, OnClickListener onClickListener) {
            this.f40678P.mLinkHint = charSequence;
            this.f40678P.linkListener = new ListenerAdapter(onClickListener);
            return this;
        }

        public Builder setBackground(int i) {
            this.f40678P.background = i;
            return this;
        }

        public Builder setLinkIconVisible(boolean z) {
            this.f40678P.mLinkIconVisible = z;
            return this;
        }

        public Builder setLinkForceCenter() {
            this.f40678P.mLinkForceCenter = true;
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.f40678P.mTitle = charSequence;
            return this;
        }

        public Builder setMessage(CharSequence charSequence) {
            this.f40678P.mMessage = charSequence;
            return this;
        }

        public Builder setRemindCheckBox(CharSequence charSequence, RemindCheckboxListener remindCheckboxListener) {
            this.f40678P.mCheckboxHintText = charSequence;
            this.f40678P.mCheckboxListener = remindCheckboxListener;
            return this;
        }

        public Builder setPositiveButton(int i, OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f40678P;
            alertParams.mPositiveButtonText = alertParams.mContext.getText(i);
            this.f40678P.mPositiveButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        public Builder setPositiveButton(int i) {
            AlertController.AlertParams alertParams = this.f40678P;
            alertParams.mPositiveButtonText = alertParams.mContext.getText(i);
            this.f40678P.mPositiveButtonListener = new ListenerAdapter((OnClickListener) new DefaultListener());
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, OnClickListener onClickListener) {
            this.f40678P.mPositiveButtonText = charSequence;
            this.f40678P.mPositiveButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence) {
            this.f40678P.mPositiveButtonText = charSequence;
            this.f40678P.mPositiveButtonListener = new ListenerAdapter((OnClickListener) new DefaultListener());
            return this;
        }

        public Builder setNegativeButton(int i, OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f40678P;
            alertParams.mNegativeButtonText = alertParams.mContext.getText(i);
            this.f40678P.mNegativeButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        public Builder setNegativeButton(int i) {
            AlertController.AlertParams alertParams = this.f40678P;
            alertParams.mNegativeButtonText = alertParams.mContext.getText(i);
            this.f40678P.mNegativeButtonListener = new ListenerAdapter((OnClickListener) new DefaultListener());
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence, OnClickListener onClickListener) {
            this.f40678P.mNegativeButtonText = charSequence;
            this.f40678P.mNegativeButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence) {
            this.f40678P.mNegativeButtonText = charSequence;
            this.f40678P.mNegativeButtonListener = new ListenerAdapter((OnClickListener) new DefaultListener());
            return this;
        }

        public Builder setNeutralButton(int i, OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f40678P;
            alertParams.mNeutralButtonText = alertParams.mContext.getText(i);
            this.f40678P.mNeutralButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        public Builder setNeutralButton(int i) {
            AlertController.AlertParams alertParams = this.f40678P;
            alertParams.mNeutralButtonText = alertParams.mContext.getText(i);
            this.f40678P.mNeutralButtonListener = new ListenerAdapter((OnClickListener) new DefaultListener());
            return this;
        }

        public Builder setNeutralButton(CharSequence charSequence, OnClickListener onClickListener) {
            this.f40678P.mNeutralButtonText = charSequence;
            this.f40678P.mNeutralButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        public Builder setNeutralButton(CharSequence charSequence) {
            this.f40678P.mNeutralButtonText = charSequence;
            this.f40678P.mNeutralButtonListener = new ListenerAdapter((OnClickListener) new DefaultListener());
            return this;
        }

        @Deprecated
        public Builder setPositiveButton(int i, View.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f40678P;
            alertParams.mPositiveButtonText = alertParams.mContext.getText(i);
            this.f40678P.mPositiveButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        @Deprecated
        public Builder setPositiveButton(CharSequence charSequence, View.OnClickListener onClickListener) {
            this.f40678P.mPositiveButtonText = charSequence;
            this.f40678P.mPositiveButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        @Deprecated
        public Builder setNegativeButton(int i, View.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f40678P;
            alertParams.mNegativeButtonText = alertParams.mContext.getText(i);
            this.f40678P.mNegativeButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        @Deprecated
        public Builder setNegativeButton(CharSequence charSequence, View.OnClickListener onClickListener) {
            this.f40678P.mNegativeButtonText = charSequence;
            this.f40678P.mNegativeButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        @Deprecated
        public Builder setNeutralButton(int i, View.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f40678P;
            alertParams.mNeutralButtonText = alertParams.mContext.getText(i);
            this.f40678P.mNeutralButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        @Deprecated
        public Builder setNeutralButton(CharSequence charSequence, View.OnClickListener onClickListener) {
            this.f40678P.mNeutralButtonText = charSequence;
            this.f40678P.mNeutralButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        public Builder setNegativeButtonDefault() {
            this.f40678P.mIsNegativeDefault = true;
            return this;
        }

        public Builder setPositiveButtonDefault() {
            this.f40678P.mIsPositiveDefault = true;
            return this;
        }

        public Builder setNeutralButtonDefault() {
            this.f40678P.mIsNeutralDefault = true;
            return this;
        }

        public void setCustomCheckLayout(View view) {
            this.f40678P.mCustomCheckLayout = view;
        }

        public AlertDialogFragment create() {
            AlertDialogFragment a = AlertDialogFragment.m30539b(getContext());
            this.f40678P.apply(a, a.mAlertController);
            a.setCancelable(this.f40678P.mCancelable);
            a.m30536a(this.f40678P.mOnDismissListener);
            a.m30535a(this.f40678P.mOnCancelListener);
            return a;
        }
    }

    static class ListenerAdapter implements View.OnClickListener {
        private AlertDialogFragment mFragment;
        private OnClickListener mListener;
        private View.OnClickListener mViewOnClickListener;

        ListenerAdapter(OnClickListener onClickListener) {
            this.mListener = onClickListener;
        }

        ListenerAdapter(View.OnClickListener onClickListener) {
            this.mViewOnClickListener = onClickListener;
        }

        public final void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            OnClickListener onClickListener = this.mListener;
            if (onClickListener != null) {
                onClickListener.onClick(this.mFragment, view);
                return;
            }
            View.OnClickListener onClickListener2 = this.mViewOnClickListener;
            if (onClickListener2 != null) {
                onClickListener2.onClick(view);
            }
        }

        public void attachAlertDialogFragment(AlertDialogFragment alertDialogFragment) {
            this.mFragment = alertDialogFragment;
        }
    }

    static class DefaultListener implements OnClickListener {
        DefaultListener() {
        }

        public void onClick(AlertDialogFragment alertDialogFragment, View view) {
            if (alertDialogFragment != null) {
                alertDialogFragment.dismiss();
            }
        }
    }
}
