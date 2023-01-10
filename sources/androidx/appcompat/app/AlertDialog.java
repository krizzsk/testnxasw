package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.C0087R;
import androidx.appcompat.app.AlertController;
import com.didi.sdk.apm.SystemUtils;

public class AlertDialog extends AppCompatDialog implements DialogInterface {
    static final int LAYOUT_HINT_NONE = 0;
    static final int LAYOUT_HINT_SIDE = 1;
    final AlertController mAlert;

    protected AlertDialog(Context context) {
        this(context, 0);
    }

    protected AlertDialog(Context context, int i) {
        super(context, resolveDialogTheme(context, i));
        this.mAlert = new AlertController(getContext(), this, getWindow());
    }

    protected AlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        this(context, 0);
        setCancelable(z);
        setOnCancelListener(onCancelListener);
    }

    static int resolveDialogTheme(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0087R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button getButton(int i) {
        return this.mAlert.getButton(i);
    }

    public ListView getListView() {
        return this.mAlert.getListView();
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.mAlert.setTitle(charSequence);
    }

    public void setCustomTitle(View view) {
        this.mAlert.setCustomTitle(view);
    }

    public void setMessage(CharSequence charSequence) {
        this.mAlert.setMessage(charSequence);
    }

    public void setView(View view) {
        this.mAlert.setView(view);
    }

    public void setView(View view, int i, int i2, int i3, int i4) {
        this.mAlert.setView(view, i, i2, i3, i4);
    }

    /* access modifiers changed from: package-private */
    public void setButtonPanelLayoutHint(int i) {
        this.mAlert.setButtonPanelLayoutHint(i);
    }

    public void setButton(int i, CharSequence charSequence, Message message) {
        this.mAlert.setButton(i, charSequence, (DialogInterface.OnClickListener) null, message, (Drawable) null);
    }

    public void setButton(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.setButton(i, charSequence, onClickListener, (Message) null, (Drawable) null);
    }

    public void setButton(int i, CharSequence charSequence, Drawable drawable, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.setButton(i, charSequence, onClickListener, (Message) null, drawable);
    }

    public void setIcon(int i) {
        this.mAlert.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        this.mAlert.setIcon(drawable);
    }

    public void setIconAttribute(int i) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i, typedValue, true);
        this.mAlert.setIcon(typedValue.resourceId);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAlert.installContent();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mAlert.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.mAlert.onKeyUp(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public static class Builder {

        /* renamed from: P */
        private final AlertController.AlertParams f55P;
        private final int mTheme;

        public Builder(Context context) {
            this(context, AlertDialog.resolveDialogTheme(context, 0));
        }

        public Builder(Context context, int i) {
            this.f55P = new AlertController.AlertParams(new ContextThemeWrapper(context, AlertDialog.resolveDialogTheme(context, i)));
            this.mTheme = i;
        }

        public Context getContext() {
            return this.f55P.mContext;
        }

        public Builder setTitle(int i) {
            AlertController.AlertParams alertParams = this.f55P;
            alertParams.mTitle = alertParams.mContext.getText(i);
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.f55P.mTitle = charSequence;
            return this;
        }

        public Builder setCustomTitle(View view) {
            this.f55P.mCustomTitleView = view;
            return this;
        }

        public Builder setMessage(int i) {
            AlertController.AlertParams alertParams = this.f55P;
            alertParams.mMessage = alertParams.mContext.getText(i);
            return this;
        }

        public Builder setMessage(CharSequence charSequence) {
            this.f55P.mMessage = charSequence;
            return this;
        }

        public Builder setIcon(int i) {
            this.f55P.mIconId = i;
            return this;
        }

        public Builder setIcon(Drawable drawable) {
            this.f55P.mIcon = drawable;
            return this;
        }

        public Builder setIconAttribute(int i) {
            TypedValue typedValue = new TypedValue();
            this.f55P.mContext.getTheme().resolveAttribute(i, typedValue, true);
            this.f55P.mIconId = typedValue.resourceId;
            return this;
        }

        public Builder setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f55P;
            alertParams.mPositiveButtonText = alertParams.mContext.getText(i);
            this.f55P.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f55P.mPositiveButtonText = charSequence;
            this.f55P.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButtonIcon(Drawable drawable) {
            this.f55P.mPositiveButtonIcon = drawable;
            return this;
        }

        public Builder setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f55P;
            alertParams.mNegativeButtonText = alertParams.mContext.getText(i);
            this.f55P.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f55P.mNegativeButtonText = charSequence;
            this.f55P.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButtonIcon(Drawable drawable) {
            this.f55P.mNegativeButtonIcon = drawable;
            return this;
        }

        public Builder setNeutralButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f55P;
            alertParams.mNeutralButtonText = alertParams.mContext.getText(i);
            this.f55P.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f55P.mNeutralButtonText = charSequence;
            this.f55P.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButtonIcon(Drawable drawable) {
            this.f55P.mNeutralButtonIcon = drawable;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.f55P.mCancelable = z;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.f55P.mOnCancelListener = onCancelListener;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.f55P.mOnDismissListener = onDismissListener;
            return this;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.f55P.mOnKeyListener = onKeyListener;
            return this;
        }

        public Builder setItems(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f55P;
            alertParams.mItems = alertParams.mContext.getResources().getTextArray(i);
            this.f55P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            this.f55P.mItems = charSequenceArr;
            this.f55P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            this.f55P.mAdapter = listAdapter;
            this.f55P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            this.f55P.mCursor = cursor;
            this.f55P.mLabelColumn = str;
            this.f55P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setMultiChoiceItems(int i, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.AlertParams alertParams = this.f55P;
            alertParams.mItems = alertParams.mContext.getResources().getTextArray(i);
            this.f55P.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.f55P.mCheckedItems = zArr;
            this.f55P.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f55P.mItems = charSequenceArr;
            this.f55P.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.f55P.mCheckedItems = zArr;
            this.f55P.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f55P.mCursor = cursor;
            this.f55P.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.f55P.mIsCheckedColumn = str;
            this.f55P.mLabelColumn = str2;
            this.f55P.mIsMultiChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(int i, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f55P;
            alertParams.mItems = alertParams.mContext.getResources().getTextArray(i);
            this.f55P.mOnClickListener = onClickListener;
            this.f55P.mCheckedItem = i2;
            this.f55P.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(Cursor cursor, int i, String str, DialogInterface.OnClickListener onClickListener) {
            this.f55P.mCursor = cursor;
            this.f55P.mOnClickListener = onClickListener;
            this.f55P.mCheckedItem = i;
            this.f55P.mLabelColumn = str;
            this.f55P.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            this.f55P.mItems = charSequenceArr;
            this.f55P.mOnClickListener = onClickListener;
            this.f55P.mCheckedItem = i;
            this.f55P.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            this.f55P.mAdapter = listAdapter;
            this.f55P.mOnClickListener = onClickListener;
            this.f55P.mCheckedItem = i;
            this.f55P.mIsSingleChoice = true;
            return this;
        }

        public Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.f55P.mOnItemSelectedListener = onItemSelectedListener;
            return this;
        }

        public Builder setView(int i) {
            this.f55P.mView = null;
            this.f55P.mViewLayoutResId = i;
            this.f55P.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setView(View view) {
            this.f55P.mView = view;
            this.f55P.mViewLayoutResId = 0;
            this.f55P.mViewSpacingSpecified = false;
            return this;
        }

        @Deprecated
        public Builder setView(View view, int i, int i2, int i3, int i4) {
            this.f55P.mView = view;
            this.f55P.mViewLayoutResId = 0;
            this.f55P.mViewSpacingSpecified = true;
            this.f55P.mViewSpacingLeft = i;
            this.f55P.mViewSpacingTop = i2;
            this.f55P.mViewSpacingRight = i3;
            this.f55P.mViewSpacingBottom = i4;
            return this;
        }

        @Deprecated
        public Builder setInverseBackgroundForced(boolean z) {
            this.f55P.mForceInverseBackground = z;
            return this;
        }

        public Builder setRecycleOnMeasureEnabled(boolean z) {
            this.f55P.mRecycleOnMeasure = z;
            return this;
        }

        public AlertDialog create() {
            AlertDialog alertDialog = new AlertDialog(this.f55P.mContext, this.mTheme);
            this.f55P.apply(alertDialog.mAlert);
            alertDialog.setCancelable(this.f55P.mCancelable);
            if (this.f55P.mCancelable) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.f55P.mOnCancelListener);
            alertDialog.setOnDismissListener(this.f55P.mOnDismissListener);
            if (this.f55P.mOnKeyListener != null) {
                alertDialog.setOnKeyListener(this.f55P.mOnKeyListener);
            }
            return alertDialog;
        }

        public AlertDialog show() {
            AlertDialog create = create();
            SystemUtils.showDialog(create);
            return create;
        }
    }
}
