package com.didi.rfusion.widget.selector;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bumptech.glide.Glide;
import com.didi.passenger.C11267R;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.RFIconView;
import com.didi.rfusion.widget.RFTextView;
import com.taxis99.R;

public abstract class RFSelectorButton extends LinearLayout implements Checkable {

    /* renamed from: a */
    private static final String f36470a = "RFSelectorButton";

    /* renamed from: b */
    private static final int[] f36471b = {16842912};

    /* renamed from: c */
    private ImageView f36472c;

    /* renamed from: d */
    private RFTextView f36473d;

    /* renamed from: e */
    private RFTextView f36474e;

    /* renamed from: f */
    private RFTextView f36475f;

    /* renamed from: g */
    private int f36476g;

    /* renamed from: h */
    private boolean f36477h;

    /* renamed from: i */
    private boolean f36478i;

    /* renamed from: j */
    private OnCheckedChangeListener f36479j;

    /* renamed from: k */
    private OnCheckedChangeListener f36480k;
    protected boolean mBroadcasting;
    protected RFIconView mRfivLeftChoice;
    protected RFIconView mRfivRightChoice;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(RFSelectorButton rFSelectorButton, boolean z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract boolean mo94543a();

    /* access modifiers changed from: protected */
    public abstract int getCheckedIcon();

    /* access modifiers changed from: protected */
    public abstract int getUnCheckedIcon();

    public RFSelectorButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFSelectorButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFSelectorButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f36476g = -1;
        this.f36478i = false;
        setOrientation(0);
        setGravity(16);
        m27467b();
        m27466a(attributeSet);
    }

    /* renamed from: b */
    private void m27467b() {
        LayoutInflater.from(getContext()).inflate(R.layout.rf_selector, this);
        this.f36472c = (ImageView) findViewById(R.id.rf_iv_icon);
        this.mRfivLeftChoice = (RFIconView) findViewById(R.id.rf_rfci_left);
        this.mRfivRightChoice = (RFIconView) findViewById(R.id.rf_rfci_right);
        this.f36473d = (RFTextView) findViewById(R.id.rf_tv_title);
        this.f36474e = (RFTextView) findViewById(R.id.rf_tv_tips);
        this.f36475f = (RFTextView) findViewById(R.id.rf_tv_emphasize);
        this.mRfivLeftChoice.setClickable(false);
        this.mRfivRightChoice.setClickable(false);
        updateCheckboxUI();
    }

    /* renamed from: a */
    private void m27466a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C11267R.styleable.RFSelectorButton);
        String string = obtainStyledAttributes.getString(6);
        String string2 = obtainStyledAttributes.getString(5);
        String string3 = obtainStyledAttributes.getString(1);
        boolean z = obtainStyledAttributes.getBoolean(2, true);
        Drawable drawable = obtainStyledAttributes.getDrawable(3);
        boolean z2 = obtainStyledAttributes.getBoolean(0, false);
        int i = obtainStyledAttributes.getInt(4, 1);
        obtainStyledAttributes.recycle();
        setTitle(string);
        setTips(string2);
        setEmphasize(string3);
        setType(i);
        setChecked(z2);
        setClickable(true);
        setEnabled(z);
        setIcon(drawable);
    }

    public void setType(int i) {
        if (this.f36476g != i) {
            this.f36476g = i;
            m27468c();
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.mRfivLeftChoice.setEnabled(z);
        this.mRfivRightChoice.setEnabled(z);
        this.f36473d.setEnabled(z);
        this.f36475f.setEnabled(z);
    }

    /* renamed from: c */
    private void m27468c() {
        if (this.f36476g == 1) {
            this.mRfivRightChoice.setVisibility(0);
            this.f36472c.setVisibility(0);
            this.mRfivLeftChoice.setVisibility(8);
            if (!TextUtils.isEmpty(this.f36474e.getText())) {
                this.f36474e.setVisibility(0);
                return;
            }
            return;
        }
        this.mRfivRightChoice.setVisibility(8);
        this.f36472c.setVisibility(8);
        this.mRfivLeftChoice.setVisibility(0);
        this.f36474e.setVisibility(8);
    }

    public void setIcon(int i) {
        this.f36472c.setVisibility(0);
        this.f36472c.setImageResource(i);
    }

    public void setIcon(Drawable drawable) {
        if (drawable == null) {
            this.f36472c.setVisibility(8);
            return;
        }
        this.f36472c.setVisibility(0);
        this.f36472c.setImageDrawable(drawable);
    }

    public void setIconSrc(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f36472c.setVisibility(8);
            return;
        }
        this.f36472c.setVisibility(0);
        Glide.with(getContext()).load(str).into(this.f36472c);
    }

    public void setTitle(String str) {
        this.f36473d.setText(str);
    }

    public void setTips(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f36474e.setVisibility(8);
            return;
        }
        this.f36474e.setText(str);
        this.f36474e.setVisibility(0);
    }

    public void setEmphasize(String str) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mRfivRightChoice.getLayoutParams();
        if (TextUtils.isEmpty(str)) {
            this.f36475f.setVisibility(8);
            marginLayoutParams.leftMargin = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_btn_compound_emphasize_margin_left);
        } else {
            this.f36475f.setText(str);
            this.f36475f.setVisibility(0);
            marginLayoutParams.leftMargin = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_btn_compound_right_cb_margin_left);
        }
        this.mRfivRightChoice.setLayoutParams(marginLayoutParams);
    }

    /* access modifiers changed from: protected */
    public void updateCheckboxUI() {
        int checkedIcon = this.f36477h ? getCheckedIcon() : getUnCheckedIcon();
        this.mRfivLeftChoice.setText(checkedIcon);
        this.mRfivLeftChoice.setSelected(this.f36477h);
        this.mRfivRightChoice.setText(checkedIcon);
        this.mRfivRightChoice.setSelected(this.f36477h);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f36479j = onCheckedChangeListener;
    }

    /* access modifiers changed from: package-private */
    public void setOnCheckedChangeWidgetListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f36480k = onCheckedChangeListener;
    }

    public void setChecked(boolean z) {
        if (mo94543a() || this.f36477h != z) {
            this.f36477h = z;
            refreshDrawableState();
            if (!this.mBroadcasting) {
                updateCheckboxUI();
                this.mBroadcasting = true;
                OnCheckedChangeListener onCheckedChangeListener = this.f36479j;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(this, this.f36477h);
                }
                OnCheckedChangeListener onCheckedChangeListener2 = this.f36480k;
                if (onCheckedChangeListener2 != null) {
                    onCheckedChangeListener2.onCheckedChanged(this, this.f36477h);
                }
                this.mBroadcasting = false;
            } else {
                return;
            }
        }
        this.f36473d.setSelected(this.f36477h);
        this.f36475f.setSelected(this.f36477h);
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f36471b);
        }
        return onCreateDrawableState;
    }

    public void toggle() {
        setChecked(!this.f36477h);
    }

    public boolean performClick() {
        if (mo94543a()) {
            setChecked(true);
        } else {
            toggle();
        }
        boolean performClick = super.performClick();
        if (!performClick) {
            playSoundEffect(0);
        }
        return performClick;
    }

    public boolean isChecked() {
        return this.f36477h;
    }
}
