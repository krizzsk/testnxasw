package com.didi.rfusion.widget.tag;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.passenger.C11267R;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.RFIconView;
import com.didi.rfusion.widget.RFTextView;
import com.taxis99.R;

public class RFTag extends FrameLayout {

    /* renamed from: a */
    private static final int f36528a = 0;

    /* renamed from: b */
    private static final int f36529b = 1;

    /* renamed from: c */
    private int f36530c;

    /* renamed from: d */
    private boolean f36531d;

    /* renamed from: e */
    private boolean f36532e;

    /* renamed from: f */
    private boolean f36533f;

    /* renamed from: g */
    private String f36534g;

    /* renamed from: h */
    private FrameLayout f36535h;

    /* renamed from: i */
    private RFTextView f36536i;

    /* renamed from: j */
    private FrameLayout f36537j;

    /* renamed from: k */
    private RFIconView f36538k;

    /* renamed from: l */
    private OnTagClickEventListener f36539l;

    /* renamed from: m */
    private OnTagStateChangeListener f36540m;

    /* renamed from: n */
    private Drawable f36541n;

    public interface OnTagClickEventListener {
        void onDeleteClick();

        void onTagClick(View view);
    }

    public interface OnTagStateChangeListener {
        void onSelectedChanged(boolean z);
    }

    public RFTag(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFTag(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFTag(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f36530c = 0;
        m27504a(context, attributeSet);
        m27503a(context);
    }

    /* renamed from: a */
    private void m27504a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.RFTag);
        this.f36530c = obtainStyledAttributes.getInt(2, 0);
        this.f36531d = obtainStyledAttributes.getBoolean(1, false);
        this.f36532e = obtainStyledAttributes.getBoolean(3, false);
        this.f36533f = obtainStyledAttributes.getBoolean(0, false);
        this.f36534g = obtainStyledAttributes.getString(4);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m27503a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.rf_tag, this);
        this.f36535h = (FrameLayout) findViewById(R.id.rf_tag_left_view);
        this.f36536i = (RFTextView) findViewById(R.id.rf_tag_content);
        this.f36537j = (FrameLayout) findViewById(R.id.rf_tag_right_view);
        this.f36538k = (RFIconView) findViewById(R.id.rf_tag_delete_icon);
        this.f36541n = getResources().getDrawable(R.drawable.rf_shape_bg_tag);
        setBackGroundColor(R.color.rf_color_gery_15_0_0D000000);
        setTagSpec(this.f36530c);
        setDisable(this.f36531d);
        setSelected(this.f36532e);
        setCheckable(this.f36533f);
        setTagText(this.f36534g);
        setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                RFTag.this.m27506b(view);
            }
        });
        this.f36538k.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                RFTag.this.m27505a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m27506b(View view) {
        if (!this.f36531d) {
            if (this.f36533f) {
                setSelected(!this.f36532e);
            }
            OnTagClickEventListener onTagClickEventListener = this.f36539l;
            if (onTagClickEventListener != null) {
                onTagClickEventListener.onTagClick(this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m27505a(View view) {
        setVisibility(8);
        OnTagClickEventListener onTagClickEventListener = this.f36539l;
        if (onTagClickEventListener != null) {
            onTagClickEventListener.onDeleteClick();
        }
    }

    public void setTagText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f36536i.setText(str);
            this.f36534g = str;
        }
    }

    public void setSelected(boolean z) {
        if (this.f36530c == 1) {
            this.f36532e = false;
            return;
        }
        if (z) {
            setBackGroundColor(R.color.rf_color_background_1_100);
            this.f36536i.setTextColor(RFResUtils.getColor(R.color.rf_color_brands_1_100));
        } else {
            setBackGroundColor(R.color.rf_color_gery_15_0_0D000000);
            this.f36536i.setTextColor(RFResUtils.getColor(R.color.rf_color_gery_1_0_000000));
        }
        this.f36532e = z;
        OnTagStateChangeListener onTagStateChangeListener = this.f36540m;
        if (onTagStateChangeListener != null) {
            onTagStateChangeListener.onSelectedChanged(z);
        }
    }

    public void setDisable(boolean z) {
        if (this.f36530c == 1) {
            this.f36531d = false;
            return;
        }
        if (z) {
            setBackGroundColor(R.color.rf_color_gery_15_0_0D000000);
            this.f36536i.setTextColor(RFResUtils.getColor(R.color.rf_color_gery_4_80_CCCCCC));
        } else {
            setSelected(this.f36532e);
        }
        this.f36531d = z;
    }

    public void setCheckable(boolean z) {
        if (this.f36530c == 1) {
            this.f36533f = false;
        } else {
            this.f36533f = z;
        }
    }

    public String getTagText() {
        return this.f36534g;
    }

    public boolean isTagSelected() {
        return this.f36532e;
    }

    public boolean isDisable() {
        return this.f36531d;
    }

    public boolean isCheckable() {
        return this.f36533f;
    }

    public void setOnTagClickEventListener(OnTagClickEventListener onTagClickEventListener) {
        this.f36539l = onTagClickEventListener;
    }

    public void setOnTagStateChangeListener(OnTagStateChangeListener onTagStateChangeListener) {
        this.f36540m = onTagStateChangeListener;
    }

    public void addLeftView(View view) {
        if (view != null) {
            this.f36535h.addView(view);
            setLeftViewVisible(true);
            return;
        }
        setLeftViewVisible(false);
    }

    public void setLeftViewVisible(boolean z) {
        int i = 8;
        if (this.f36530c == 1) {
            this.f36535h.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = this.f36535h;
        if (z) {
            i = 0;
        }
        frameLayout.setVisibility(i);
    }

    public void addRightView(View view) {
        if (view != null) {
            this.f36537j.addView(view);
            setRightViewVisible(true);
            return;
        }
        setRightViewVisible(false);
    }

    public void setRightViewVisible(boolean z) {
        int i = 8;
        if (this.f36530c == 1) {
            this.f36537j.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = this.f36537j;
        if (z) {
            i = 0;
        }
        frameLayout.setVisibility(i);
    }

    private void setTagSpec(int i) {
        if (i == 0) {
            this.f36538k.setVisibility(8);
        } else if (i == 1) {
            this.f36538k.setVisibility(0);
        }
    }

    private void setBackGroundColor(int i) {
        Drawable drawable = this.f36541n;
        if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setColor(RFResUtils.getColor(i));
        }
        setBackground(this.f36541n);
    }
}
