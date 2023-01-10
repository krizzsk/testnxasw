package com.didi.global.globaluikit.dialog;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.android.didi.theme.DidiThemeManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.global.globaluikit.button.UnitUtils;
import com.didi.global.globaluikit.dialog.LEGORealUsedModel;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.global.globaluikit.widget.RoundCornerRelativeLayout;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.global.globaluikit.dialog.a */
/* compiled from: LEGODialogView */
class C9243a {

    /* renamed from: A */
    private View f24412A;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public LEGORealUsedModel f24413a;

    /* renamed from: b */
    private RoundCornerRelativeLayout f24414b;

    /* renamed from: c */
    private View f24415c;

    /* renamed from: d */
    private View f24416d;

    /* renamed from: e */
    private View f24417e;

    /* renamed from: f */
    private View f24418f;

    /* renamed from: g */
    private View f24419g;

    /* renamed from: h */
    private View f24420h;

    /* renamed from: i */
    private View f24421i;

    /* renamed from: j */
    private View f24422j;

    /* renamed from: k */
    private TextView f24423k;

    /* renamed from: l */
    private TextView f24424l;

    /* renamed from: m */
    private CheckBox f24425m;

    /* renamed from: n */
    private TextView f24426n;

    /* renamed from: o */
    private TextView f24427o;

    /* renamed from: p */
    private View f24428p;

    /* renamed from: q */
    private TextView f24429q;

    /* renamed from: r */
    private View f24430r;

    /* renamed from: s */
    private TextView f24431s;

    /* renamed from: t */
    private TextView f24432t;

    /* renamed from: u */
    private TextView f24433u;

    /* renamed from: v */
    private TextView f24434v;

    /* renamed from: w */
    private TextView f24435w;

    /* renamed from: x */
    private TextView f24436x;

    /* renamed from: y */
    private LEGORoundImageView f24437y;

    /* renamed from: z */
    private Context f24438z;

    public C9243a(Context context, LEGORealUsedModel lEGORealUsedModel) {
        this.f24438z = context;
        this.f24413a = lEGORealUsedModel;
        m19616b();
    }

    /* renamed from: b */
    private void m19616b() {
        if (this.f24412A == null) {
            this.f24412A = LayoutInflater.from(this.f24438z).inflate(R.layout.lego_dialog_common_layout, (ViewGroup) null);
        }
    }

    /* renamed from: a */
    private <T extends View> T m19614a(int i) {
        View view = this.f24412A;
        if (view == null) {
            return null;
        }
        return view.findViewById(i);
    }

    /* renamed from: a */
    public View mo72139a() {
        m19617c();
        return this.f24412A;
    }

    /* renamed from: c */
    private void m19617c() {
        m19618d();
        m19619e();
        m19620f();
        m19621g();
        m19626l();
        m19622h();
        m19623i();
        m19624j();
        m19625k();
    }

    /* renamed from: d */
    private void m19618d() {
        RoundCornerRelativeLayout roundCornerRelativeLayout = (RoundCornerRelativeLayout) m19614a((int) R.id.lego_dialog_bg_layout);
        this.f24414b = roundCornerRelativeLayout;
        roundCornerRelativeLayout.setRadius(UnitUtils.dp2px(this.f24438z, 20.0f));
        this.f24415c = m19614a((int) R.id.lego_dialog_title_include);
        this.f24416d = m19614a((int) R.id.lego_dialog_content_include);
        this.f24417e = m19614a((int) R.id.lego_dialog_checkbox_include);
        this.f24418f = m19614a((int) R.id.lego_dialog_btn_include);
        this.f24419g = m19614a((int) R.id.lego_dialog_description_include);
        this.f24420h = m19614a((int) R.id.lego_dialog_head_image_include);
        this.f24421i = m19614a((int) R.id.lego_dialog_subtitle_include);
        this.f24422j = m19614a((int) R.id.lego_dialog_subcontent_include);
        this.f24423k = (TextView) m19614a((int) R.id.lego_dialog_title);
        this.f24424l = (TextView) m19614a((int) R.id.lego_dialog_content);
        this.f24425m = (CheckBox) m19614a((int) R.id.lego_dialog_checkbox);
        this.f24426n = (TextView) m19614a((int) R.id.lego_dialog_checkbox_content);
        this.f24427o = (TextView) m19614a((int) R.id.lego_dialog_btn_main);
        this.f24429q = (TextView) m19614a((int) R.id.lego_dialog_btn_other1);
        this.f24428p = m19614a((int) R.id.dialog_line2);
        this.f24431s = (TextView) m19614a((int) R.id.lego_dialog_btn_other2);
        this.f24430r = m19614a((int) R.id.dialog_line3);
        this.f24432t = (TextView) m19614a((int) R.id.lego_dialog_description_content);
        this.f24437y = (LEGORoundImageView) m19614a((int) R.id.lego_dialog_head_image);
        this.f24433u = (TextView) m19614a((int) R.id.lego_dialog_subtitle);
        this.f24434v = (TextView) m19614a((int) R.id.lego_dialog_subcontent_one);
        this.f24435w = (TextView) m19614a((int) R.id.lego_dialog_subcontent_two);
        this.f24436x = (TextView) m19614a((int) R.id.lego_dialog_subcontent_three);
    }

    /* renamed from: e */
    private void m19619e() {
        if (this.f24413a.mRichTitle != null) {
            this.f24415c.setVisibility(0);
            this.f24413a.mRichTitle.bindTextView(this.f24423k);
        } else if (this.f24413a.mTitle != null) {
            this.f24415c.setVisibility(0);
            this.f24413a.mTitle.bind(this.f24423k);
        }
    }

    /* renamed from: f */
    private void m19620f() {
        if (this.f24413a.mRichSubTitle != null) {
            this.f24416d.setVisibility(0);
            if (this.f24413a.mRichSubTitle == null || TextUtils.isEmpty(this.f24413a.mRichSubTitle.getContent())) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f24424l.getLayoutParams();
                layoutParams.topMargin = UiUtils.dip2px(this.f24438z, 16.0f);
                this.f24424l.setLayoutParams(layoutParams);
            }
            this.f24413a.mRichSubTitle.bindTextView(this.f24424l);
        } else if (this.f24413a.mContent != null) {
            this.f24416d.setVisibility(0);
            if (this.f24413a.mTitle == null || TextUtils.isEmpty(this.f24413a.mTitle.text)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f24424l.getLayoutParams();
                layoutParams2.topMargin = UiUtils.dip2px(this.f24438z, 16.0f);
                this.f24424l.setLayoutParams(layoutParams2);
            }
            this.f24413a.mContent.bind(this.f24424l);
        }
    }

    /* renamed from: g */
    private void m19621g() {
        if (this.f24413a.mRichCheckbox == null || this.f24413a.mCheckListener == null) {
            this.f24417e.setVisibility(8);
        } else {
            this.f24417e.setVisibility(0);
            this.f24413a.mRichCheckbox.bindTextView(this.f24426n);
            this.f24425m.setChecked(this.f24413a.mIsChecked);
            this.f24425m.setOnCheckedChangeListener(new LEGODialogView$1(this));
        }
        if (this.f24413a.mCheckContent != null) {
            this.f24417e.setVisibility(0);
            this.f24413a.mCheckContent.bind(this.f24426n);
            this.f24425m.setOnCheckedChangeListener(this.f24413a.mLEGOCheckboxListener);
        }
    }

    /* renamed from: h */
    private void m19622h() {
        if (this.f24413a.mDescription != null) {
            this.f24419g.setVisibility(0);
            this.f24413a.mDescription.bind(this.f24432t);
            this.f24419g.setOnClickListener(this.f24413a.mLinkClickedListener);
        }
    }

    /* renamed from: i */
    private void m19623i() {
        Drawable drawable;
        if (this.f24413a.mImageModel != null) {
            this.f24420h.setVisibility(0);
            if (this.f24413a.mImageModel.getImgPlaceHolder() != 0) {
                drawable = this.f24438z.getResources().getDrawable(this.f24413a.mImageModel.getImgPlaceHolder());
            } else {
                drawable = DidiThemeManager.getIns().getResPicker(this.f24438z).getDrawable(R.attr.ggk_default_dialog_up_bg);
            }
            Context context = this.f24438z;
            if (context instanceof FragmentActivity) {
                if (((FragmentActivity) context).isDestroyed()) {
                    return;
                }
            } else if ((context instanceof Activity) && ((Activity) context).isDestroyed()) {
                return;
            }
            if (!TextUtils.isEmpty(this.f24413a.mImageModel.getImgUrl()) || this.f24413a.mImageModel.getImgResId() != 0) {
                ((RequestBuilder) Glide.with(this.f24438z).load(!TextUtils.isEmpty(this.f24413a.mImageModel.getImgUrl()) ? this.f24413a.mImageModel.getImgUrl() : this.f24413a.mImageModel.getImgResId() != 0 ? Integer.valueOf(this.f24413a.mImageModel.getImgResId()) : drawable).placeholder(drawable)).into((ImageView) this.f24437y);
            }
        }
    }

    /* renamed from: j */
    private void m19624j() {
        if (this.f24413a.mSubTitle != null) {
            this.f24421i.setVisibility(0);
            this.f24413a.mSubTitle.bind(this.f24433u);
        }
    }

    /* renamed from: k */
    private void m19625k() {
        if (this.f24413a.mSubContents != null) {
            this.f24422j.setVisibility(0);
            List<LEGORealUsedModel.TextWidgetModel> list = this.f24413a.mSubContents;
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    list.get(0).bind(this.f24434v);
                } else if (i == 1) {
                    list.get(1).bind(this.f24435w);
                } else if (i == 2) {
                    list.get(2).bind(this.f24436x);
                }
            }
        }
    }

    /* renamed from: l */
    private void m19626l() {
        if (this.f24413a.mListOfBtns != null) {
            int size = this.f24413a.mListOfBtns.size();
            if (this.f24413a.mCheckContent != null && !TextUtils.isEmpty(this.f24413a.mCheckContent.text)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f24418f.getLayoutParams();
                layoutParams.topMargin = UiUtils.dip2px(this.f24438z, 0.0f);
                this.f24418f.setLayoutParams(layoutParams);
            }
            if (size == 1) {
                this.f24418f.setVisibility(0);
                this.f24429q.setVisibility(8);
                this.f24428p.setVisibility(8);
                this.f24431s.setVisibility(8);
                this.f24430r.setVisibility(8);
                this.f24427o.setText(this.f24413a.mListOfBtns.get(0).getText());
                this.f24427o.setBackground(this.f24438z.getResources().getDrawable(R.drawable.lego_dialog_last_btn_selector));
                this.f24427o.setOnClickListener(this.f24413a.mListOfBtns.get(0).getListener());
            } else if (size == 2) {
                this.f24418f.setVisibility(0);
                this.f24431s.setVisibility(8);
                this.f24430r.setVisibility(8);
                this.f24427o.setText(this.f24413a.mListOfBtns.get(0).getText());
                this.f24429q.setText(this.f24413a.mListOfBtns.get(1).getText());
                this.f24429q.setBackground(this.f24438z.getResources().getDrawable(R.drawable.lego_dialog_last_btn_selector));
                this.f24427o.setOnClickListener(this.f24413a.mListOfBtns.get(0).getListener());
                this.f24429q.setOnClickListener(this.f24413a.mListOfBtns.get(1).getListener());
            } else if (size == 3) {
                this.f24418f.setVisibility(0);
                this.f24427o.setText(this.f24413a.mListOfBtns.get(0).getText());
                this.f24429q.setText(this.f24413a.mListOfBtns.get(1).getText());
                this.f24431s.setText(this.f24413a.mListOfBtns.get(2).getText());
                this.f24427o.setOnClickListener(this.f24413a.mListOfBtns.get(0).getListener());
                this.f24429q.setOnClickListener(this.f24413a.mListOfBtns.get(1).getListener());
                this.f24431s.setOnClickListener(this.f24413a.mListOfBtns.get(2).getListener());
                this.f24431s.setBackground(this.f24438z.getResources().getDrawable(R.drawable.lego_dialog_last_btn_selector));
            }
        }
    }
}
