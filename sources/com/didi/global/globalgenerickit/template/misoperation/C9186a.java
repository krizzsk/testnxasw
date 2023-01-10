package com.didi.global.globalgenerickit.template.misoperation;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.global.globalgenerickit.eventtracker.ImgLoadTracker;
import com.didi.global.globalgenerickit.template.yoga.EventListener;
import com.taxis99.R;
import java.util.HashMap;

/* renamed from: com.didi.global.globalgenerickit.template.misoperation.a */
/* compiled from: MisOperationBinder */
class C9186a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final EventListener f24115a;

    /* renamed from: b */
    private LinearLayout f24116b;

    /* renamed from: c */
    private TextView f24117c;

    /* renamed from: d */
    private TextView f24118d;

    /* renamed from: e */
    private ImageView f24119e;

    /* renamed from: f */
    private TextView[] f24120f;

    /* renamed from: g */
    private View[] f24121g;

    /* renamed from: h */
    private ImageView[] f24122h;

    /* renamed from: i */
    private View[] f24123i;

    /* renamed from: j */
    private final String f24124j = "notice";

    /* renamed from: k */
    private View f24125k;

    public C9186a(View view, EventListener eventListener) {
        this.f24125k = view;
        this.f24115a = eventListener;
        this.f24117c = (TextView) view.findViewById(R.id.oc_x_panel_operation_title);
        this.f24116b = (LinearLayout) view.findViewById(R.id.oc_x_panel_operation_text_layout);
        this.f24118d = (TextView) view.findViewById(R.id.oc_x_panel_operation_content);
        this.f24119e = (ImageView) view.findViewById(R.id.oc_x_panel_operation_image);
        this.f24120f = new TextView[]{(TextView) view.findViewById(R.id.txt0), (TextView) view.findViewById(R.id.txt1), (TextView) view.findViewById(R.id.txt2)};
        this.f24122h = new ImageView[]{(ImageView) view.findViewById(R.id.image0), (ImageView) view.findViewById(R.id.image1), (ImageView) view.findViewById(R.id.image2)};
        this.f24121g = new View[]{null, view.findViewById(R.id.divider0), view.findViewById(R.id.divider1)};
        this.f24123i = new View[]{view.findViewById(R.id.bottombar0), view.findViewById(R.id.bottombar1), view.findViewById(R.id.bottombar2)};
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71839a(MisOperationData misOperationData) {
        String str = misOperationData.title;
        String str2 = misOperationData.content;
        String str3 = misOperationData.imageUrl;
        String str4 = misOperationData.link;
        if (!TextUtils.isEmpty(str)) {
            this.f24117c.setText(str);
            this.f24117c.setVisibility(0);
        } else {
            this.f24117c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f24118d.setText(str2);
            this.f24118d.setVisibility(0);
        } else {
            this.f24118d.setVisibility(8);
        }
        if (this.f24117c.getVisibility() == 0 || this.f24118d.getVisibility() == 0) {
            this.f24116b.setVisibility(0);
        }
        if (TextUtils.isEmpty(str3) || "notice".equals(misOperationData.type)) {
            this.f24119e.setVisibility(8);
        } else {
            this.f24119e.setImageDrawable(this.f24118d.getResources().getDrawable(R.drawable.oc_x_panel_operation_image));
            this.f24119e.setVisibility(0);
        }
        if (!TextUtils.isEmpty(str4)) {
            this.f24125k.setOnClickListener(new ViewHolder$1(this, str3));
        } else {
            this.f24125k.setOnClickListener((View.OnClickListener) null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo71840b(MisOperationData misOperationData) {
        if (misOperationData.bottombarTxts != null) {
            for (int i = 0; i < this.f24123i.length; i++) {
                if (i >= misOperationData.bottombarTxts.length) {
                    this.f24123i[i].setVisibility(8);
                    View[] viewArr = this.f24121g;
                    if (viewArr[i] != null) {
                        viewArr[i].setVisibility(8);
                    }
                } else if (!TextUtils.isEmpty(misOperationData.bottombarTxts[i])) {
                    String str = misOperationData.bottombarLinks[i];
                    if (!TextUtils.isEmpty(str)) {
                        this.f24123i[i].setOnClickListener(new ViewHolder$2(this, i, str));
                    } else {
                        this.f24123i[i].setOnClickListener((View.OnClickListener) null);
                    }
                    if (TextUtils.isEmpty(misOperationData.bottombarImages[i])) {
                        this.f24122h[i].setVisibility(8);
                    }
                    if (!TextUtils.isEmpty(misOperationData.bottombarTxts[i])) {
                        this.f24120f[i].setText(misOperationData.bottombarTxts[i]);
                        this.f24120f[i].setVisibility(0);
                    } else {
                        this.f24120f[i].setVisibility(8);
                    }
                    View[] viewArr2 = this.f24121g;
                    if (viewArr2[i] != null) {
                        viewArr2[i].setVisibility(0);
                    }
                    this.f24123i[i].setBackgroundResource(R.drawable.oc_x_panel_operation_selector);
                    this.f24123i[i].setVisibility(0);
                } else {
                    this.f24123i[i].setVisibility(8);
                }
            }
        }
    }

    /* renamed from: c */
    public void mo71841c(MisOperationData misOperationData) {
        mo71839a(misOperationData);
        mo71840b(misOperationData);
        String str = misOperationData.imageUrl;
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(misOperationData.activityId)) {
                hashMap.put("act_id", misOperationData.activityId);
            }
            long currentTimeMillis = System.currentTimeMillis();
            ImgLoadTracker.loadUrlOmega(str, hashMap);
            ((RequestBuilder) Glide.with(this.f24125k.getContext()).load(str).error((int) R.drawable.oc_x_panel_operation_image)).listener(new ViewHolder$3(this, str, hashMap, currentTimeMillis)).into(this.f24119e);
        }
    }
}
