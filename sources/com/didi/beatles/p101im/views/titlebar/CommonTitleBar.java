package com.didi.beatles.p101im.views.titlebar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.beatles.p101im.access.utils.IMBusinessConfig;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.resource.IMThemeConstant;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.titlebar.CommonTitleBar */
public class CommonTitleBar extends RelativeLayout {

    /* renamed from: a */
    private ImageView f12282a;

    /* renamed from: b */
    private TextView f12283b;

    /* renamed from: c */
    private TextView f12284c;

    /* renamed from: d */
    private TextView f12285d;

    /* renamed from: e */
    private ImageView f12286e;

    /* renamed from: f */
    private ImageView f12287f;

    /* renamed from: g */
    private LinearLayout f12288g;

    /* renamed from: h */
    private ImageView f12289h;

    /* renamed from: i */
    private ViewGroup f12290i;

    /* renamed from: b */
    private boolean m10496b(int i) {
        return i == 0 || i == 8 || i == 4;
    }

    public CommonTitleBar(Context context) {
        super(context);
        m10491a();
    }

    public CommonTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10491a();
    }

    public CommonTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10491a();
    }

    public CommonTitleBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m10491a();
    }

    public void resetLayout(int i) {
        removeAllViews();
        m10492a(i);
    }

    /* renamed from: a */
    private void m10491a() {
        m10492a((int) R.layout.im_common_title_bar);
        initResource();
    }

    /* renamed from: a */
    private void m10492a(int i) {
        LayoutInflater.from(getContext()).inflate(i, this, true);
        this.f12290i = (ViewGroup) findViewById(R.id.title_bar_layout_above);
        this.f12282a = (ImageView) findViewById(R.id.common_title_bar_left_img);
        this.f12287f = (ImageView) findViewById(R.id.ub_title_bar_left_img);
        this.f12283b = (TextView) findViewById(R.id.common_title_bar_middle_tv);
        this.f12284c = (TextView) findViewById(R.id.common_title_bar_sub_tv);
        this.f12285d = (TextView) findViewById(R.id.common_title_bar_right_tv);
        this.f12289h = (ImageView) findViewById(R.id.common_title_bar_line);
        this.f12286e = (ImageView) findViewById(R.id.common_title_bar_right_iv);
        this.f12288g = (LinearLayout) findViewById(R.id.common_title_bar_right_layout);
    }

    public void initResource() {
        ViewGroup viewGroup = this.f12290i;
        if (viewGroup != null && this.f12283b != null) {
            viewGroup.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_nomix_titlebar_bg));
            this.f12283b.setTextSize(0, IMResource.getDimension(R.dimen.im_nomix_titlebar_textsize, 18));
            this.f12283b.setTextColor(IMResource.getColor(R.color.im_nomix_color_titlebar_text));
        }
    }

    public ImageView getLeftImgView() {
        return this.f12282a;
    }

    public TextView getRightTextView() {
        return this.f12285d;
    }

    public void setTitle(int i) {
        TextView textView = this.f12283b;
        if (textView != null) {
            m10494a(textView, i);
            m10493a((View) this.f12283b);
        }
    }

    public void setTitle(String str) {
        TextView textView = this.f12283b;
        if (textView != null) {
            m10495a(textView, str);
            m10493a((View) this.f12283b);
        }
    }

    public void setRightText(int i) {
        TextView textView = this.f12285d;
        if (textView != null) {
            m10494a(textView, i);
            m10493a((View) this.f12285d);
        }
    }

    public void setRightText(String str) {
        TextView textView = this.f12285d;
        if (textView != null) {
            m10495a(textView, str);
            m10493a((View) this.f12285d);
        }
    }

    public void setRightExtendIv(int i, View.OnClickListener onClickListener) {
        ImageView imageView = this.f12286e;
        if (imageView != null) {
            imageView.setImageResource(i);
            if (onClickListener != null) {
                this.f12286e.setOnClickListener(onClickListener);
            }
        }
    }

    public void setRightExtendIvVisible(int i) {
        ImageView imageView = this.f12286e;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
    }

    public boolean isRightExtendViewIsShowing() {
        ImageView imageView = this.f12286e;
        if (imageView == null) {
            return false;
        }
        return imageView.isShown();
    }

    public ImageView getRightExtendView() {
        return this.f12286e;
    }

    public void setRightImg(int i) {
        TextView textView = this.f12285d;
        if (textView != null) {
            m10495a(textView, "");
            m10493a((View) this.f12285d);
            this.f12285d.setBackgroundResource(IMResource.getDrawableID(i));
        }
    }

    public View getRightImg() {
        if (this.f12285d == null) {
            return null;
        }
        return this.f12286e;
    }

    public void hideRightImg() {
        TextView textView = this.f12285d;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public LinearLayout getRightLayout() {
        return this.f12288g;
    }

    public void setRightText(int i, View.OnClickListener onClickListener) {
        TextView textView = this.f12285d;
        if (textView != null) {
            if (onClickListener != null) {
                textView.setOnClickListener(onClickListener);
            }
            m10494a(this.f12285d, i);
            m10493a((View) this.f12285d);
        }
    }

    public void setRightText(String str, View.OnClickListener onClickListener) {
        TextView textView = this.f12285d;
        if (textView != null) {
            if (onClickListener != null) {
                textView.setOnClickListener(onClickListener);
            }
            m10495a(this.f12285d, str);
            m10493a((View) this.f12285d);
        }
    }

    public void setLeftBackListener(View.OnClickListener onClickListener) {
        setLeftImage(IMResource.getDrawableID(R.drawable.im_common_title_bar_btn_back_selector), onClickListener);
        ImageView imageView = this.f12287f;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void setLeftImage(int i, View.OnClickListener onClickListener) {
        ImageView imageView = this.f12282a;
        if (imageView != null) {
            if (onClickListener != null) {
                imageView.setOnClickListener(onClickListener);
            }
            this.f12282a.setImageResource(i);
            m10493a((View) this.f12282a);
        }
    }

    public void setLeftImage(Drawable drawable, View.OnClickListener onClickListener) {
        ImageView imageView = this.f12282a;
        if (imageView != null) {
            if (onClickListener != null) {
                imageView.setOnClickListener(onClickListener);
            }
            if (drawable != null) {
                this.f12282a.setImageDrawable(drawable);
            }
            m10493a((View) this.f12282a);
        }
    }

    public void setLeftVisible(int i) {
        if (this.f12282a != null && m10496b(i)) {
            this.f12282a.setVisibility(i);
        }
    }

    public void setTitleLineVisible(int i) {
        if (this.f12283b != null && m10496b(i)) {
            this.f12283b.setVisibility(i);
        }
    }

    public void setRightVisible(int i) {
        if (this.f12285d != null && m10496b(i)) {
            this.f12285d.setVisibility(i);
        }
    }

    public void setTitleBarLineVisible(int i) {
        if (this.f12289h != null && m10496b(i)) {
            this.f12289h.setVisibility(i);
        }
    }

    public void setTitleBackground(int i) {
        ViewGroup viewGroup = this.f12290i;
        if (viewGroup != null) {
            viewGroup.setBackgroundResource(i);
        }
    }

    public void setTitleConfig(IMBusinessConfig iMBusinessConfig) {
        if (this.f12282a != null && this.f12287f != null && this.f12283b != null && this.f12289h != null && this.f12290i != null && iMBusinessConfig != null) {
            if (iMBusinessConfig.isUber()) {
                this.f12282a.setVisibility(8);
                this.f12287f.setVisibility(0);
                this.f12283b.getPaint().setFakeBoldText(true);
                this.f12283b.setTextColor(getContext().getResources().getColor(R.color.black));
                this.f12289h.setImageResource(R.color.ub_title_bar_line_bg);
                this.f12290i.setBackgroundResource(R.color.ub_title_bar_bg);
                return;
            }
            if (iMBusinessConfig.getExtendDrawableResource(IMThemeConstant.IM_TITLE_ICON) != -1) {
                this.f12282a.setImageResource(iMBusinessConfig.getExtendDrawableResource(IMThemeConstant.IM_TITLE_ICON));
            }
            if (iMBusinessConfig.getExtendColorResource(IMThemeConstant.IM_TITLE_BG) != -1) {
                this.f12290i.setBackgroundResource(iMBusinessConfig.getExtendColorResource(IMThemeConstant.IM_TITLE_BG));
            }
            if (iMBusinessConfig.getExtendColorResource(IMThemeConstant.IM_TITLE_FONT_COLOR) != -1) {
                this.f12283b.setTextColor(getContext().getResources().getColor(iMBusinessConfig.getExtendColorResource(IMThemeConstant.IM_TITLE_FONT_COLOR)));
            }
            if (iMBusinessConfig.getExtendColorResource(IMThemeConstant.IM_TITLE_DIVIDE_COLOR) != -1) {
                this.f12289h.setImageResource(iMBusinessConfig.getExtendColorResource(IMThemeConstant.IM_TITLE_DIVIDE_COLOR));
            }
        }
    }

    public void setRightTextColor(int i) {
        TextView textView = this.f12285d;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setRightClickListener(View.OnClickListener onClickListener) {
        TextView textView = this.f12285d;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    /* renamed from: a */
    private void m10494a(TextView textView, int i) {
        textView.setText(i);
    }

    /* renamed from: a */
    private void m10495a(TextView textView, String str) {
        textView.setText(str);
    }

    /* renamed from: a */
    private void m10493a(View view) {
        view.setVisibility(0);
    }

    public void setSubTitle(String str) {
        TextView textView = this.f12284c;
        if (textView != null) {
            textView.setText(str);
            this.f12284c.setVisibility(0);
        }
    }
}
