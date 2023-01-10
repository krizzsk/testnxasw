package com.didi.sdk.sidebar.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.facebook.common.util.UriUtil;
import com.taxis99.R;
import rui.config.RConfigConstants;

public class SideBarSwitchItemView extends ComponentView {

    /* renamed from: a */
    private ImageView f40218a;

    /* renamed from: b */
    private TextView f40219b;

    /* renamed from: c */
    private TextView f40220c;

    /* renamed from: d */
    private Switch f40221d;

    /* renamed from: e */
    private OnCheckedChangeListener f40222e;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(boolean z);
    }

    public SideBarSwitchItemView(Context context) {
        super(context);
    }

    public View createView() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.slidebar_switch_item, (ViewGroup) null);
        this.f40218a = (ImageView) inflate.findViewById(R.id.item_icon);
        this.f40219b = (TextView) inflate.findViewById(R.id.item_content);
        this.f40220c = (TextView) inflate.findViewById(R.id.item_desc);
        Switch switchR = (Switch) inflate.findViewById(R.id.item_switch);
        this.f40221d = switchR;
        switchR.setClickable(false);
        return inflate;
    }

    public void setName(String str) {
        super.setName(str);
        this.f40219b.setText(str);
    }

    public void setIcon(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("http://") || str.startsWith("https://")) {
                ((RequestBuilder) Glide.with(this.context).load(str).placeholder(this.context.getResources().getDrawable(R.drawable.sidebar_icon_default))).into(this.f40218a);
            } else if (str.startsWith(UriUtil.QUALIFIED_RESOURCE_SCHEME)) {
                String host = Uri.parse(str).getHost();
                if (host != null && !host.startsWith("sidebar")) {
                    host = "sidebar_" + host;
                }
                this.f40218a.setImageResource(this.context.getResources().getIdentifier(host, RConfigConstants.TYPE_DRAWABLE, this.context.getPackageName()));
            }
        }
    }

    public void setIcon(String str, Bitmap bitmap) {
        this.f40218a.setImageBitmap(bitmap);
        setIcon(str);
    }

    public void setDesc(String str) {
        this.f40220c.setText(str);
    }

    public void setSwitchBtn(boolean z) {
        this.f40221d.setChecked(z);
    }

    public boolean isChecked() {
        return this.f40221d.isChecked();
    }

    public void setSwitchListener(final OnCheckedChangeListener onCheckedChangeListener) {
        this.f40221d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AutoTrackHelper.trackViewOnClick(compoundButton, z);
                OnCheckedChangeListener onCheckedChangeListener = onCheckedChangeListener;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(z);
                }
            }
        });
    }
}
