package com.didi.component.common.view.card;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.component.business.util.HighlightUtil;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.UIUtils;
import com.didi.component.common.view.card.GlobalTemplateCardModel;
import com.didi.sdk.log.Logger;
import com.taxis99.R;

public class GlobalTemplateCardView extends LinearLayout {

    /* renamed from: a */
    private static final String f13732a = "GlobalTemplateBaseCardView";

    /* renamed from: b */
    private TextView f13733b;

    /* renamed from: c */
    private TextView f13734c;

    /* renamed from: d */
    private TextView f13735d;

    /* renamed from: e */
    private TextView f13736e;

    /* renamed from: f */
    private TextView f13737f;

    /* renamed from: g */
    private TextView f13738g;

    /* renamed from: h */
    private ImageView f13739h;

    /* renamed from: i */
    private View f13740i;

    /* renamed from: j */
    private ViewStub f13741j;

    /* renamed from: k */
    private TextView f13742k;

    /* renamed from: l */
    private FrameLayout f13743l;

    /* renamed from: m */
    private FrameLayout f13744m;

    /* renamed from: n */
    private volatile boolean f13745n;

    /* renamed from: o */
    private ViewStub f13746o;

    /* renamed from: p */
    private TextView f13747p;

    /* access modifiers changed from: protected */
    public int getLayoutResId() {
        return R.layout.global_template_card_layout;
    }

    public GlobalTemplateCardView(Context context) {
        this(context, (AttributeSet) null);
    }

    public GlobalTemplateCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GlobalTemplateCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13745n = false;
    }

    /* renamed from: a */
    private void m11427a() {
        LayoutInflater.from(getContext()).inflate(getLayoutResId(), this, true);
        setOrientation(1);
        this.f13733b = (TextView) findViewById(R.id.global_template_card_main_title_tv);
        this.f13734c = (TextView) findViewById(R.id.global_template_card_sub_title_tv);
        this.f13735d = (TextView) findViewById(R.id.global_template_card_content_tv);
        this.f13736e = (TextView) findViewById(R.id.global_template_card_btn_describe);
        this.f13737f = (TextView) findViewById(R.id.global_template_card_right_btn);
        this.f13738g = (TextView) findViewById(R.id.global_template_card_left_btn);
        this.f13739h = (ImageView) findViewById(R.id.global_template_card_content_iv);
        this.f13743l = (FrameLayout) findViewById(R.id.global_template_card_big_extend_layout);
        this.f13744m = (FrameLayout) findViewById(R.id.global_template_card_small_extend_layout);
        this.f13740i = findViewById(R.id.global_template_card_btn_container);
        this.f13746o = (ViewStub) findViewById(R.id.global_template_card_btn_container_new_style);
        this.f13741j = (ViewStub) findViewById(R.id.global_template_card_link_btn_container);
    }

    public void setData(GlobalTemplateCardModel globalTemplateCardModel) {
        if (globalTemplateCardModel == null) {
            setVisibility(8);
            Logger.m29537e(f13732a, "data is null! view is gone!");
            return;
        }
        m11430b();
        setTextColorStyle(globalTemplateCardModel.getTextColorStyle());
        setTextAreaModel(globalTemplateCardModel.textAreaModel);
        setBtnModel(globalTemplateCardModel.btnModel);
        setLinkBtnModel(globalTemplateCardModel.linkBtnModel);
        setBigExtendsViewModel(globalTemplateCardModel.bigExtendsViewModel);
        setSmallExtendsViewModel(globalTemplateCardModel.smallExtendsViewModel);
        setImageModel(globalTemplateCardModel.imageModel);
        setNewBtnModel(globalTemplateCardModel.newBtnModel);
        if (globalTemplateCardModel.getCardBackGround() != 0) {
            setBackgroundResource(globalTemplateCardModel.getCardBackGround());
        }
    }

    /* renamed from: b */
    private void m11430b() {
        if (!this.f13745n) {
            m11427a();
            this.f13745n = true;
        }
    }

    public ViewGroup getBigExtendsContainer() {
        return this.f13743l;
    }

    public ViewGroup getSmallExtendsContainer() {
        return this.f13744m;
    }

    public void setTextAreaModel(GlobalTemplateCardModel.TextAreaModel textAreaModel) {
        if (textAreaModel != null) {
            m11430b();
            m11429a(this.f13733b, HighlightUtil.highlight(getContext(), textAreaModel.maintTitleText));
            m11429a(this.f13734c, (CharSequence) textAreaModel.subTitleText);
            m11429a(this.f13735d, HighlightUtil.highlight(getContext(), textAreaModel.contentText));
            setMainTitleMaxLine(textAreaModel.mainTitleMaxLine);
        }
    }

    public void setBigExtendsViewModel(GlobalTemplateCardModel.ExtendsViewModel extendsViewModel) {
        m11430b();
        m11428a((ViewGroup) this.f13743l, extendsViewModel);
        if (this.f13740i.getVisibility() == 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f13743l.getLayoutParams();
            marginLayoutParams.bottomMargin = UiUtils.dip2px(getContext(), 16.0f);
            this.f13743l.setLayoutParams(marginLayoutParams);
        }
    }

    public void setSmallExtendsViewModel(GlobalTemplateCardModel.ExtendsViewModel extendsViewModel) {
        m11430b();
        m11428a((ViewGroup) this.f13744m, extendsViewModel);
    }

    /* renamed from: a */
    private void m11428a(ViewGroup viewGroup, GlobalTemplateCardModel.ExtendsViewModel extendsViewModel) {
        if (extendsViewModel == null || extendsViewModel.view == null) {
            viewGroup.setVisibility(8);
            return;
        }
        viewGroup.setVisibility(0);
        viewGroup.removeAllViews();
        if (extendsViewModel.layoutParams == null) {
            viewGroup.addView(extendsViewModel.view);
        } else {
            viewGroup.addView(extendsViewModel.view, extendsViewModel.layoutParams);
        }
    }

    /* renamed from: b */
    private void m11431b(ViewGroup viewGroup, GlobalTemplateCardModel.ExtendsViewModel extendsViewModel) {
        if (extendsViewModel == null || extendsViewModel.view == null) {
            viewGroup.setVisibility(8);
            return;
        }
        viewGroup.setVisibility(0);
        viewGroup.removeAllViews();
        if (extendsViewModel.layoutParams == null) {
            viewGroup.addView(extendsViewModel.view);
        } else {
            viewGroup.addView(extendsViewModel.view, extendsViewModel.layoutParams);
        }
    }

    public void setLinkBtnModel(GlobalTemplateCardModel.LinkBtnModel linkBtnModel) {
        if (linkBtnModel == null || TextUtils.isEmpty(linkBtnModel.linkText)) {
            this.f13741j.setVisibility(8);
            return;
        }
        if (this.f13742k == null) {
            this.f13741j.inflate();
            this.f13742k = (TextView) findViewById(R.id.global_template_card_link_btn);
        }
        this.f13741j.setVisibility(0);
        this.f13742k.setText(linkBtnModel.linkText);
        this.f13742k.setOnClickListener(linkBtnModel.listener);
    }

    public void setBtnModel(GlobalTemplateCardModel.BtnModel btnModel) {
        m11430b();
        if (btnModel == null) {
            this.f13740i.setVisibility(8);
        } else if (btnModel.type == 0) {
            this.f13740i.setVisibility(0);
            m11429a(this.f13736e, (CharSequence) btnModel.describeText);
            m11429a(this.f13737f, (CharSequence) btnModel.btnText);
            this.f13740i.setOnClickListener(btnModel.listener);
        } else if (btnModel.type == 1) {
            this.f13738g.setVisibility(0);
            m11429a(this.f13738g, (CharSequence) btnModel.btnText);
            this.f13738g.setOnClickListener(btnModel.listener);
        }
    }

    public void setNewBtnModel(GlobalTemplateCardModel.NewBtnModel newBtnModel) {
        m11430b();
        if (newBtnModel != null) {
            this.f13746o.inflate();
            TextView textView = (TextView) findViewById(R.id.global_template_card_btn_new_style);
            this.f13747p = textView;
            m11429a(textView, (CharSequence) newBtnModel.btnText);
            this.f13747p.setOnClickListener(newBtnModel.listener);
        }
    }

    public void setImageModel(GlobalTemplateCardModel.ImageModel imageModel) {
        m11430b();
        if (imageModel != null) {
            if (imageModel.width != 0 && imageModel.height != 0) {
                ViewGroup.LayoutParams layoutParams = this.f13739h.getLayoutParams();
                layoutParams.height = UIUtils.dip2pxInt(getContext(), (float) imageModel.height);
                layoutParams.width = UIUtils.dip2pxInt(getContext(), (float) imageModel.width);
                this.f13739h.setLayoutParams(layoutParams);
                this.f13739h.setVisibility(0);
            } else if (imageModel.drawableId == 0 && !TextUtils.isEmpty(imageModel.drawableUri)) {
                GLog.m11357e(f13732a, "imageView will not load net image while you not set the width or height!!!");
                return;
            }
            if (imageModel.drawableId != 0) {
                this.f13739h.setImageResource(imageModel.drawableId);
            } else if (!TextUtils.isEmpty(imageModel.drawableUri)) {
                ((RequestBuilder) Glide.with(getContext()).asBitmap().load(imageModel.drawableUri).placeholder(imageModel.defaultDrawableId)).into(this.f13739h);
            } else if (imageModel.defaultDrawableId != 0) {
                this.f13739h.setImageResource(imageModel.defaultDrawableId);
            }
            if (imageModel.style == 1) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f13739h.getLayoutParams();
                layoutParams2.rightMargin = UIUtils.dip2pxInt(getContext(), 0.0f);
                layoutParams2.addRule(11);
            } else if (imageModel.style == 4) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f13739h.getLayoutParams();
                layoutParams3.rightMargin = UIUtils.dip2pxInt(getContext(), 16.0f);
                layoutParams3.topMargin = UIUtils.dip2pxInt(getContext(), 18.0f);
                layoutParams3.addRule(11);
            } else if (imageModel.style == 2) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f13739h.getLayoutParams();
                layoutParams4.rightMargin = UIUtils.dip2pxInt(getContext(), 16.0f);
                layoutParams4.addRule(15);
            } else if (imageModel.style == 3) {
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f13739h.getLayoutParams();
                layoutParams5.rightMargin = UIUtils.dip2pxInt(getContext(), 0.0f);
                layoutParams5.addRule(15);
            }
        }
    }

    public void setTextColorStyle(int i) {
        if (i == 1) {
            this.f13737f.setTextColor(-1);
            this.f13733b.setTextColor(-1);
            this.f13734c.setTextColor(-1);
            this.f13736e.setTextColor(-1);
            this.f13735d.setTextColor(-1);
            this.f13737f.setCompoundDrawables((Drawable) null, (Drawable) null, getContext().getResources().getDrawable(R.drawable.global_template_card_arrow_white), (Drawable) null);
            this.f13740i.setBackgroundResource(R.drawable.global_template_btn_light_text_bg);
            return;
        }
        this.f13737f.setTextColor(getContext().getResources().getColor(R.color.g_color_333333));
        this.f13733b.setTextColor(getContext().getResources().getColor(R.color.g_color_333333));
        this.f13736e.setTextColor(getContext().getResources().getColor(R.color.g_color_333333));
        this.f13734c.setTextColor(getContext().getResources().getColor(R.color.g_color_999999));
        this.f13735d.setTextColor(getContext().getResources().getColor(R.color.g_color_999999));
        this.f13737f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getContext().getResources().getDrawable(R.drawable.global_template_card_arrow_black), (Drawable) null);
        this.f13740i.setBackgroundResource(R.drawable.global_template_btn_dark_text_bg);
    }

    /* renamed from: a */
    private void m11429a(TextView textView, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else if (!TextUtils.equals(charSequence, textView.getText())) {
            textView.setText(charSequence);
            textView.setVisibility(0);
        }
    }

    private void setMainTitleMaxLine(int i) {
        this.f13733b.setMaxLines(i);
    }
}
