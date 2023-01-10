package com.didi.component.splitfare.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.model.GlideUrl;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.splitfare.model.NewSplitFareMsg;
import com.taxis99.R;

public class SplitFloatWindow implements View.OnClickListener {

    /* renamed from: a */
    private Context f17885a;

    /* renamed from: b */
    private View f17886b;

    /* renamed from: c */
    private TextView f17887c = ((TextView) this.f17886b.findViewById(R.id.split_float_content_view));

    /* renamed from: d */
    private ImageView f17888d;

    /* renamed from: e */
    private OnClickCallback f17889e;

    /* renamed from: f */
    private NewSplitFareMsg f17890f;

    public interface OnClickCallback {
        void onClick(View view);
    }

    public SplitFloatWindow(Context context, NewSplitFareMsg newSplitFareMsg) {
        this.f17890f = newSplitFareMsg;
        this.f17885a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.split_float_view, (ViewGroup) null, false);
        this.f17886b = inflate;
        this.f17888d = (ImageView) inflate.findViewById(R.id.split_float_img);
        this.f17886b.setOnClickListener(this);
        m15206a();
    }

    /* renamed from: a */
    private void m15206a() {
        NewSplitFareMsg newSplitFareMsg = this.f17890f;
        if (newSplitFareMsg != null) {
            setContent(newSplitFareMsg.msg);
            setHeader(this.f17890f.iconUrl);
        }
    }

    public void setContent(String str) {
        this.f17887c.setText(str);
    }

    public void setHeader(String str) {
        if (!TextUtils.isEmpty(str)) {
            ((RequestBuilder) Glide.with(this.f17885a).load((Object) new GlideUrl(str)).placeholder((int) R.drawable.split_float_icon)).into(this.f17888d);
        }
    }

    public void setOnClickCallback(OnClickCallback onClickCallback) {
        this.f17889e = onClickCallback;
    }

    public View getView() {
        return this.f17886b;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        OnClickCallback onClickCallback = this.f17889e;
        if (onClickCallback != null) {
            onClickCallback.onClick(this.f17886b);
        }
    }
}
