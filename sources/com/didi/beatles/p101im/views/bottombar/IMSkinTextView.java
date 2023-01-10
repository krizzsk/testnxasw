package com.didi.beatles.p101im.views.bottombar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.resource.IMResource;
import java.util.Map;

/* renamed from: com.didi.beatles.im.views.bottombar.IMSkinTextView */
public class IMSkinTextView extends AppCompatTextView implements IIMSkin {
    public static final String IM_SKIN_CANCEL = "cancel";
    public static final String IM_SKIN_COMMON = "common";
    public static final String IM_SKIN_DISABLE = "disable";

    /* renamed from: a */
    private Map<String, IMSkinElement> f11847a;

    /* renamed from: b */
    private View f11848b;

    /* renamed from: c */
    private int f11849c;

    /* renamed from: d */
    private int f11850d;

    /* renamed from: e */
    private int f11851e;

    /* renamed from: f */
    private int f11852f;

    /* renamed from: g */
    private int f11853g;

    /* renamed from: h */
    private String f11854h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public long f11855i;

    public IMSkinTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMSkinTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public IMSkinTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11854h = IM_SKIN_COMMON;
        this.f11855i = 0;
        this.f11848b = this;
    }

    public void showDisableSkin() {
        m10183a("disable");
    }

    public void showCommonSkin() {
        m10183a(IM_SKIN_COMMON);
    }

    public void showCancelSkin() {
        m10183a("cancel");
    }

    public void showCustomSkin(String str) {
        m10183a(str);
    }

    public void setSkinMap(Map<String, IMSkinElement> map) {
        this.f11847a = map;
    }

    public void setShowImage(boolean z) {
        if (z) {
            m10181a();
        }
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        this.f11850d = i;
        this.f11851e = i2;
        this.f11852f = i3;
        this.f11853g = i4;
        View view = this.f11848b;
        if (view instanceof ImageView) {
            view.setPadding(i, i2, i3, i4);
        }
    }

    public void setVisibility(int i) {
        View view = this.f11848b;
        if (view instanceof ImageView) {
            view.setVisibility(i);
        } else {
            super.setVisibility(i);
        }
    }

    public void setClickable(boolean z) {
        View view = this.f11848b;
        if (view instanceof ImageView) {
            view.setClickable(z);
        } else {
            super.setClickable(z);
        }
    }

    /* renamed from: a */
    private void m10183a(String str) {
        Map<String, IMSkinElement> map = this.f11847a;
        if (map != null) {
            this.f11854h = str;
            IMSkinElement iMSkinElement = map.get(str);
            if (iMSkinElement != null) {
                m10182a(iMSkinElement);
            }
        }
    }

    public boolean post(Runnable runnable) {
        View view = this.f11848b;
        if (view instanceof ImageView) {
            return view.post(runnable);
        }
        return super.post(runnable);
    }

    public boolean postDelayed(Runnable runnable, long j) {
        View view = this.f11848b;
        if (view instanceof ImageView) {
            return view.postDelayed(runnable, j);
        }
        return super.postDelayed(runnable, j);
    }

    public void setImageSrcId(int i) {
        if (i != 0) {
            View view = this.f11848b;
            if (view instanceof ImageView) {
                ((ImageView) view).setImageResource(IMResource.getDrawableID(i));
            }
        }
    }

    /* renamed from: a */
    private void m10182a(IMSkinElement iMSkinElement) {
        if (iMSkinElement.getSrcDrawable() != 0) {
            setImageSrcId(iMSkinElement.getSrcDrawable());
            return;
        }
        if (iMSkinElement.getBgDrawable() != 0) {
            setBackgroundResource(iMSkinElement.getBgDrawable());
        } else if (iMSkinElement.getBgColor() != 0) {
            setBackgroundColor(iMSkinElement.getBgColor());
        }
        if (!TextUtils.isEmpty(iMSkinElement.getText())) {
            setText(iMSkinElement.getText());
            if (iMSkinElement.getTextColor() != 0) {
                setTextColor(iMSkinElement.getTextColor());
            }
        }
    }

    public void setViewClickListener(final View.OnClickListener onClickListener) {
        this.f11848b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                View.OnClickListener onClickListener;
                AutoTrackHelper.trackViewOnClick(view);
                if (System.currentTimeMillis() - IMSkinTextView.this.f11855i > 400 && (onClickListener = onClickListener) != null) {
                    onClickListener.onClick(IMSkinTextView.this);
                }
                long unused = IMSkinTextView.this.f11855i = System.currentTimeMillis();
            }
        });
    }

    /* renamed from: a */
    private void m10181a() {
        if (!(this.f11848b instanceof ImageView)) {
            ViewGroup viewGroup = (ViewGroup) getParent();
            int indexOfChild = viewGroup.indexOfChild(this);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(this.f11849c);
            imageView.setPadding(this.f11850d, this.f11851e, this.f11852f, this.f11853g);
            imageView.setLayoutParams(layoutParams);
            viewGroup.removeViewAt(indexOfChild);
            imageView.setId(getId());
            viewGroup.addView(imageView, indexOfChild);
            this.f11848b = imageView;
        }
    }

    public View getRealView() {
        return this.f11848b;
    }

    public void resetViewSkin() {
        m10183a(this.f11854h);
    }

    public void setImageContentDescription(String str) {
        if (this.f11848b != null && !TextUtils.isEmpty(str)) {
            this.f11848b.setContentDescription(str);
        }
    }
}
