package com.didi.component.home_exception.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.util.OnAntiShakeClickListener;
import com.didi.component.home_exception.widget.ExceptionCardModel;
import com.didi.drouter.api.DRouter;
import com.didiglobal.common.common.util.EeveeRichTextUtil;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class ExceptionCardView extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f15926a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ExceptionCardModel.Data f15927b;

    /* renamed from: c */
    private TextView f15928c;

    /* renamed from: d */
    private TextView f15929d;

    /* renamed from: e */
    private TextView f15930e;

    /* renamed from: f */
    private ImageView f15931f;

    /* renamed from: g */
    private ImageView f15932g;

    /* renamed from: h */
    private LinearLayout f15933h;

    /* renamed from: i */
    private TextView f15934i;

    public ExceptionCardView(Context context) {
        super(context);
        m13209a(context);
    }

    public ExceptionCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m13209a(context);
    }

    public ExceptionCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13209a(context);
    }

    /* renamed from: a */
    private void m13209a(Context context) {
        this.f15926a = context;
        LayoutInflater.from(context).inflate(R.layout.home_exception_layout, this);
        setOrientation(1);
        this.f15928c = (TextView) findViewById(R.id.main_title_tv);
        this.f15929d = (TextView) findViewById(R.id.content_tv);
        this.f15931f = (ImageView) findViewById(R.id.no_position_iv);
        this.f15930e = (TextView) findViewById(R.id.enable_service_btn);
        this.f15933h = (LinearLayout) findViewById(R.id.open_sug_ll);
        this.f15934i = (TextView) findViewById(R.id.open_sug_tv);
        this.f15932g = (ImageView) findViewById(R.id.open_sug_arrow);
        this.f15930e.setOnClickListener(new OnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (ExceptionCardView.this.f15927b != null && !TextUtils.isEmpty(ExceptionCardView.this.f15927b.btnScheme)) {
                    DRouter.build(ExceptionCardView.this.f15927b.btnScheme).start(ExceptionCardView.this.f15926a);
                }
            }
        });
        this.f15933h.setOnClickListener(new OnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (ExceptionCardView.this.f15927b != null && ExceptionCardView.this.f15927b.link != null && !TextUtils.isEmpty(ExceptionCardView.this.f15927b.link.url)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("action", 0);
                    GlobalOmegaUtils.trackEvent("map_loc_home_page_card_ck", (Map<String, Object>) hashMap);
                    DRouter.build(ExceptionCardView.this.f15927b.link.url).start(ExceptionCardView.this.f15926a);
                }
            }
        });
    }

    public void bindData(final ExceptionCardModel.Data data) {
        this.f15927b = data;
        if (data == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (data.title != null) {
            this.f15928c.setVisibility(0);
            EeveeRichTextUtil.setText(this.f15928c, data.title);
        } else {
            this.f15928c.setVisibility(8);
        }
        if (data.content != null) {
            this.f15929d.setVisibility(0);
            EeveeRichTextUtil.setText(this.f15929d, data.content);
        } else {
            this.f15929d.setVisibility(8);
        }
        if (TextUtils.isEmpty(data.img)) {
            this.f15931f.setVisibility(8);
        } else {
            this.f15931f.setVisibility(0);
            Glide.with((View) this).load(data.img).into(this.f15931f);
        }
        if (TextUtils.isEmpty(data.mainBtnText)) {
            this.f15930e.setVisibility(8);
        } else {
            this.f15930e.setVisibility(0);
            this.f15930e.setText(data.mainBtnText);
        }
        if (data.link != null) {
            this.f15933h.setVisibility(0);
            if (data.link.title != null) {
                this.f15934i.setVisibility(0);
                EeveeRichTextUtil.setText(this.f15934i, data.link.title);
            } else {
                this.f15934i.setVisibility(8);
            }
            if (!TextUtils.isEmpty(data.link.url)) {
                this.f15932g.setVisibility(0);
                this.f15933h.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (ExceptionCardView.this.f15926a != null) {
                            DRouter.build(data.link.url).start(ExceptionCardView.this.f15926a);
                        }
                    }
                });
                if (!TextUtils.isEmpty(data.linkArrow)) {
                    Glide.with((View) this).load(data.linkArrow).into(this.f15932g);
                    return;
                }
                return;
            }
            this.f15932g.setVisibility(8);
            return;
        }
        this.f15933h.setVisibility(8);
    }
}
