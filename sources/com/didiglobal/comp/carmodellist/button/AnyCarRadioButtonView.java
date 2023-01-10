package com.didiglobal.comp.carmodellist.button;

import android.content.Context;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.autofill.AutofillValue;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didiglobal.comp.carmodellist.button.AnyCarRadioButtonModel;

public abstract class AnyCarRadioButtonView extends LinearLayout implements View.OnClickListener, Checkable {

    /* renamed from: a */
    private static final String f52353a = AnyCarRadioButtonView.class.getSimpleName();

    /* renamed from: k */
    private static final int[] f52354k = {16842912};

    /* renamed from: b */
    private boolean f52355b;

    /* renamed from: c */
    private boolean f52356c;

    /* renamed from: d */
    private boolean f52357d;

    /* renamed from: e */
    private OnCheckedChangeListener f52358e;

    /* renamed from: f */
    private LinearLayout.LayoutParams f52359f;

    /* renamed from: g */
    private Context f52360g;

    /* renamed from: h */
    private ImageView f52361h;

    /* renamed from: i */
    private TextView f52362i;

    /* renamed from: j */
    private AnyCarRadioButtonModel.ViewModel f52363j;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(AnyCarRadioButtonView anyCarRadioButtonView, boolean z);
    }

    public abstract ImageView getIcon();

    public abstract int getLayoutResId();

    public abstract TextView getTitle();

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
    }

    public AnyCarRadioButtonView(Context context) {
        super(context);
        this.f52360g = context;
        m39358a(context, (AttributeSet) null);
    }

    public AnyCarRadioButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f52360g = context;
        m39358a(context, attributeSet);
    }

    public AnyCarRadioButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m39358a(context, attributeSet);
    }

    /* renamed from: a */
    private void m39358a(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(getLayoutResId(), this, true);
        this.f52361h = getIcon();
        this.f52362i = getTitle();
        setChecked(false);
        setOnClickListener(this);
    }

    public void setData(AnyCarRadioButtonModel.ViewModel viewModel) {
        this.f52363j = viewModel;
        if (viewModel != null) {
            int i = viewModel.f52352id;
            if (i == -1) {
                i = View.generateViewId();
            }
            this.f52363j.f52352id = i;
            setId(i);
            setChildrenChecked(this.f52363j.isChecked);
        }
    }

    public void setDisable(boolean z) {
        this.f52356c = z;
        if (z) {
            AnyCarRadioButtonModel.ViewModel viewModel = this.f52363j;
            if (viewModel != null) {
                if (viewModel.titleDisable != null) {
                    this.f52362i.setText(this.f52363j.titleDisable.text);
                    this.f52362i.setTextColor(Color.parseColor(this.f52363j.titleDisable.textColor));
                }
                if (this.f52355b) {
                    this.f52361h.setBackground(this.f52363j.iconDisable);
                } else {
                    this.f52361h.setBackground(this.f52363j.iconUnChecked);
                }
                setBackground(this.f52363j.bgDisable);
                return;
            }
            return;
        }
        setChildrenChecked(this.f52355b);
    }

    public void setExtLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.f52359f = layoutParams;
    }

    public LinearLayout.LayoutParams getExtLayoutParams() {
        return this.f52359f;
    }

    public void setChecked(boolean z) {
        if (this.f52355b != z) {
            this.f52355b = z;
            setChildrenChecked(z);
            refreshDrawableState();
            if (!this.f52357d) {
                this.f52357d = true;
                OnCheckedChangeListener onCheckedChangeListener = this.f52358e;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(this, this.f52355b);
                }
                this.f52357d = false;
            }
        }
    }

    public boolean isChecked() {
        return this.f52355b;
    }

    public void toggle() {
        if (!this.f52356c && !this.f52355b) {
            setChecked(true);
        }
    }

    public boolean performClick() {
        toggle();
        boolean performClick = super.performClick();
        if (!performClick) {
            playSoundEffect(0);
        }
        return performClick;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f52354k);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    /* access modifiers changed from: package-private */
    public void setOnCheckedChangeWidgetListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f52358e = onCheckedChangeListener;
    }

    private void setChildrenChecked(boolean z) {
        AnyCarRadioButtonModel.ViewModel viewModel = this.f52363j;
        if (viewModel != null) {
            this.f52355b = z;
            if (z) {
                this.f52361h.setBackground(viewModel.iconChecked);
                if (this.f52363j.titleChecked != null) {
                    this.f52362i.setText(this.f52363j.titleChecked.text);
                    this.f52362i.setTextColor(Color.parseColor(this.f52363j.titleChecked.textColor));
                }
                setBackground(this.f52363j.bgChecked);
            } else {
                this.f52361h.setBackground(viewModel.iconUnChecked);
                if (this.f52363j.titleUnChecked != null) {
                    this.f52362i.setText(this.f52363j.titleUnChecked.text);
                    this.f52362i.setTextColor(Color.parseColor(this.f52363j.titleUnChecked.textColor));
                }
                setBackground(this.f52363j.bgUnChecked);
            }
            setChecked(this.f52355b);
        }
    }

    public AnyCarRadioButtonModel.ViewModel getButtonViewModel() {
        return this.f52363j;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean checked;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.checked = ((Boolean) parcel.readValue((ClassLoader) null)).booleanValue();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.checked));
        }

        public String toString() {
            return "CompoundButton.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " checked=" + this.checked + "}";
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.checked = isChecked();
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.checked);
        requestLayout();
    }

    public void autofill(AutofillValue autofillValue) {
        if (isEnabled() && autofillValue.isToggle()) {
            setChecked(autofillValue.getToggleValue());
        }
    }

    public int getAutofillType() {
        return isEnabled() ? 2 : 0;
    }

    public AutofillValue getAutofillValue() {
        if (isEnabled()) {
            return AutofillValue.forToggle(isChecked());
        }
        return null;
    }
}
