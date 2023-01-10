package com.didi.global.globalgenerickit.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.didi.theme.DidiThemeManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.global.globalgenerickit.dialog.GGKRealUsedModel;
import com.didi.global.globalgenerickit.utils.UiUtils;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.global.globalgenerickit.dialog.a */
/* compiled from: GGKDialogView */
class C9177a {

    /* renamed from: A */
    private Context f24022A;

    /* renamed from: B */
    private View f24023B;

    /* renamed from: a */
    private GGKRealUsedModel f24024a;

    /* renamed from: b */
    private View f24025b;

    /* renamed from: c */
    private View f24026c;

    /* renamed from: d */
    private View f24027d;

    /* renamed from: e */
    private View f24028e;

    /* renamed from: f */
    private View f24029f;

    /* renamed from: g */
    private View f24030g;

    /* renamed from: h */
    private View f24031h;

    /* renamed from: i */
    private View f24032i;

    /* renamed from: j */
    private View f24033j;

    /* renamed from: k */
    private TextView f24034k;

    /* renamed from: l */
    private TextView f24035l;

    /* renamed from: m */
    private EditText f24036m;

    /* renamed from: n */
    private CheckBox f24037n;

    /* renamed from: o */
    private TextView f24038o;

    /* renamed from: p */
    private TextView f24039p;

    /* renamed from: q */
    private View f24040q;

    /* renamed from: r */
    private TextView f24041r;

    /* renamed from: s */
    private View f24042s;

    /* renamed from: t */
    private TextView f24043t;

    /* renamed from: u */
    private TextView f24044u;

    /* renamed from: v */
    private TextView f24045v;

    /* renamed from: w */
    private TextView f24046w;

    /* renamed from: x */
    private TextView f24047x;

    /* renamed from: y */
    private TextView f24048y;

    /* renamed from: z */
    private ImageView f24049z;

    public C9177a(Context context, GGKRealUsedModel gGKRealUsedModel) {
        this.f24022A = context;
        this.f24024a = gGKRealUsedModel;
        m19431b();
    }

    /* renamed from: b */
    private void m19431b() {
        if (this.f24023B == null) {
            this.f24023B = LayoutInflater.from(this.f24022A).inflate(R.layout.dialog_common_layout, (ViewGroup) null);
        }
    }

    /* renamed from: a */
    private <T extends View> T m19430a(int i) {
        View view = this.f24023B;
        if (view == null) {
            return null;
        }
        return view.findViewById(i);
    }

    /* renamed from: a */
    public View mo71774a() {
        m19432c();
        return this.f24023B;
    }

    /* renamed from: c */
    private void m19432c() {
        m19433d();
        m19434e();
        m19435f();
        m19437h();
        m19436g();
        m19442m();
        m19438i();
        m19439j();
        m19440k();
        m19441l();
    }

    /* renamed from: d */
    private void m19433d() {
        this.f24025b = m19430a(R.id.ggk_dialog_title_include);
        this.f24026c = m19430a(R.id.ggk_dialog_content_include);
        this.f24027d = m19430a(R.id.ggk_dialog_checkbox_include);
        this.f24028e = m19430a(R.id.ggk_dialog_edit_include);
        this.f24029f = m19430a(R.id.ggk_dialog_btn_include);
        this.f24030g = m19430a(R.id.ggk_dialog_description_include);
        this.f24031h = m19430a(R.id.ggk_dialog_head_image_include);
        this.f24032i = m19430a(R.id.ggk_dialog_subtitle_include);
        this.f24033j = m19430a(R.id.ggk_dialog_subcontent_include);
        this.f24034k = (TextView) m19430a(R.id.ggk_dialog_title);
        this.f24035l = (TextView) m19430a(R.id.ggk_dialog_content);
        this.f24036m = (EditText) m19430a(R.id.ggk_dialog_edittext);
        this.f24037n = (CheckBox) m19430a(R.id.ggk_dialog_checkbox);
        this.f24038o = (TextView) m19430a(R.id.ggk_dialog_checkbox_content);
        this.f24039p = (TextView) m19430a(R.id.ggk_dialog_btn_main);
        this.f24041r = (TextView) m19430a(R.id.ggk_dialog_btn_other1);
        this.f24040q = m19430a(R.id.dialog_line2);
        this.f24043t = (TextView) m19430a(R.id.ggk_dialog_btn_other2);
        this.f24042s = m19430a(R.id.dialog_line3);
        this.f24044u = (TextView) m19430a(R.id.ggk_dialog_description_content);
        this.f24049z = (ImageView) m19430a(R.id.ggk_dialog_head_image);
        this.f24045v = (TextView) m19430a(R.id.ggk_dialog_subtitle);
        this.f24046w = (TextView) m19430a(R.id.ggk_dialog_subcontent_one);
        this.f24047x = (TextView) m19430a(R.id.ggk_dialog_subcontent_two);
        this.f24048y = (TextView) m19430a(R.id.ggk_dialog_subcontent_three);
    }

    /* renamed from: e */
    private void m19434e() {
        if (this.f24024a.f24003a != null) {
            this.f24025b.setVisibility(0);
            this.f24024a.f24003a.bind(this.f24034k);
        }
    }

    /* renamed from: f */
    private void m19435f() {
        if (this.f24024a.f24004b != null) {
            this.f24026c.setVisibility(0);
            if (this.f24024a.f24003a == null || TextUtils.isEmpty(this.f24024a.f24003a.text)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f24035l.getLayoutParams();
                layoutParams.topMargin = UiUtils.dip2px(this.f24022A, 16.0f);
                this.f24035l.setLayoutParams(layoutParams);
            }
            this.f24024a.f24004b.bind(this.f24035l);
        }
    }

    /* renamed from: g */
    private void m19436g() {
        if (this.f24024a.f24006d != null || this.f24024a.f24007e != null) {
            this.f24028e.setVisibility(0);
            this.f24036m.addTextChangedListener(this.f24024a.f24006d);
            this.f24036m.setHint(this.f24024a.f24007e);
        }
    }

    /* renamed from: h */
    private void m19437h() {
        if (this.f24024a.f24005c != null) {
            this.f24027d.setVisibility(0);
            this.f24024a.f24005c.bind(this.f24038o);
            this.f24037n.setOnCheckedChangeListener(this.f24024a.f24008f);
        }
    }

    /* renamed from: i */
    private void m19438i() {
        if (this.f24024a.f24010h != null) {
            this.f24030g.setVisibility(0);
            this.f24024a.f24010h.bind(this.f24044u);
            this.f24030g.setOnClickListener(this.f24024a.f24011i);
        }
    }

    /* renamed from: j */
    private void m19439j() {
        Drawable drawable;
        if (this.f24024a.f24012j != null) {
            this.f24031h.setVisibility(0);
            if (this.f24024a.f24012j.getImgPlaceHolder() != 0) {
                drawable = this.f24022A.getResources().getDrawable(this.f24024a.f24012j.getImgPlaceHolder());
            } else {
                drawable = DidiThemeManager.getIns().getResPicker(this.f24022A).getDrawable(R.attr.ggk_default_dialog_up_bg);
            }
            if (!TextUtils.isEmpty(this.f24024a.f24012j.getImgUrl()) || this.f24024a.f24012j.getImgResId() != 0) {
                ((RequestBuilder) Glide.with(this.f24022A).load(!TextUtils.isEmpty(this.f24024a.f24012j.getImgUrl()) ? this.f24024a.f24012j.getImgUrl() : this.f24024a.f24012j.getImgResId() != 0 ? Integer.valueOf(this.f24024a.f24012j.getImgResId()) : drawable).placeholder(drawable)).into(this.f24049z);
            }
        }
    }

    /* renamed from: k */
    private void m19440k() {
        if (this.f24024a.f24013k != null) {
            this.f24032i.setVisibility(0);
            this.f24024a.f24013k.bind(this.f24045v);
        }
    }

    /* renamed from: l */
    private void m19441l() {
        if (this.f24024a.f24014l != null) {
            this.f24033j.setVisibility(0);
            List<GGKRealUsedModel.TextWidgetModel> list = this.f24024a.f24014l;
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    list.get(0).bind(this.f24046w);
                } else if (i == 1) {
                    list.get(1).bind(this.f24047x);
                } else if (i == 2) {
                    list.get(2).bind(this.f24048y);
                }
            }
        }
    }

    /* renamed from: m */
    private void m19442m() {
        if (this.f24024a.f24009g != null) {
            int size = this.f24024a.f24009g.size();
            if (this.f24024a.f24005c != null && !TextUtils.isEmpty(this.f24024a.f24005c.text)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f24029f.getLayoutParams();
                layoutParams.topMargin = UiUtils.dip2px(this.f24022A, 0.0f);
                this.f24029f.setLayoutParams(layoutParams);
            }
            if (size == 1) {
                this.f24029f.setVisibility(0);
                this.f24041r.setVisibility(8);
                this.f24040q.setVisibility(8);
                this.f24043t.setVisibility(8);
                this.f24042s.setVisibility(8);
                this.f24039p.setText(this.f24024a.f24009g.get(0).getText());
                this.f24039p.setBackground(this.f24022A.getResources().getDrawable(R.drawable.ggk_dialog_last_btn_selector));
                this.f24039p.setOnClickListener(this.f24024a.f24009g.get(0).getListener());
            } else if (size == 2) {
                this.f24029f.setVisibility(0);
                this.f24043t.setVisibility(8);
                this.f24042s.setVisibility(8);
                this.f24039p.setText(this.f24024a.f24009g.get(0).getText());
                this.f24041r.setText(this.f24024a.f24009g.get(1).getText());
                this.f24041r.setBackground(this.f24022A.getResources().getDrawable(R.drawable.ggk_dialog_last_btn_selector));
                this.f24039p.setOnClickListener(this.f24024a.f24009g.get(0).getListener());
                this.f24041r.setOnClickListener(this.f24024a.f24009g.get(1).getListener());
            } else if (size == 3) {
                this.f24029f.setVisibility(0);
                this.f24039p.setText(this.f24024a.f24009g.get(0).getText());
                this.f24041r.setText(this.f24024a.f24009g.get(1).getText());
                this.f24043t.setText(this.f24024a.f24009g.get(2).getText());
                this.f24039p.setOnClickListener(this.f24024a.f24009g.get(0).getListener());
                this.f24041r.setOnClickListener(this.f24024a.f24009g.get(1).getListener());
                this.f24043t.setOnClickListener(this.f24024a.f24009g.get(2).getListener());
                this.f24043t.setBackground(this.f24022A.getResources().getDrawable(R.drawable.ggk_dialog_last_btn_selector));
            }
        }
    }
}
