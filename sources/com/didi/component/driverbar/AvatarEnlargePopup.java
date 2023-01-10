package com.didi.component.driverbar;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class AvatarEnlargePopup extends PopupWindow {

    /* renamed from: a */
    private Context f14762a;

    /* renamed from: b */
    private View f14763b;

    /* renamed from: c */
    private ImageView f14764c;

    /* renamed from: d */
    private ImageView f14765d;

    /* renamed from: e */
    private String f14766e;

    /* renamed from: f */
    private View f14767f;

    public AvatarEnlargePopup(Context context, View view, int i, int i2, String str) {
        super(view, i, i2);
        this.f14763b = view;
        this.f14766e = str;
        this.f14762a = context;
        m12171a();
    }

    public void show() {
        setClippingEnabled(false);
        setOutsideTouchable(true);
        showAtLocation(this.f14763b, 17, 0, 0);
    }

    /* renamed from: a */
    private void m12171a() {
        this.f14765d = (ImageView) this.f14763b.findViewById(R.id.enlarge_popup_img);
        this.f14764c = (ImageView) this.f14763b.findViewById(R.id.enlarge_popup_close);
        this.f14767f = this.f14763b.findViewById(R.id.bg);
        setBackgroundDrawable(new ColorDrawable(0));
        this.f14767f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AvatarEnlargePopup.this.dismiss();
            }
        });
        this.f14765d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.f14764c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AvatarEnlargePopup.this.dismiss();
            }
        });
        ((RequestBuilder) ((RequestBuilder) Glide.with(this.f14762a).asBitmap().load(this.f14766e).placeholder((int) R.drawable.driver_card_default_avatar_v2_big)).dontAnimate()).into(this.f14765d);
    }
}
