package com.didi.component.matchtogo20.wait.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.component.business.util.HighlightUtil;
import com.didi.component.matchtogo20.wait.AbsMTGWaitAcceptPresenter;
import com.didi.component.matchtogo20.wait.model.WaitAcceptModel;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.DIDIBaseApplication;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.taxis99.R;

public class MTGWaitAcceptView implements IMTGWaitAcceptView {

    /* renamed from: a */
    private AbsMTGWaitAcceptPresenter f16413a;

    /* renamed from: b */
    private View f16414b;

    /* renamed from: c */
    private Context f16415c;

    /* renamed from: d */
    private TextView f16416d;

    /* renamed from: e */
    private TextView f16417e = ((TextView) this.f16414b.findViewById(R.id.tv_sub_title));

    /* renamed from: f */
    private TextView f16418f = ((TextView) this.f16414b.findViewById(R.id.tv_main_content));

    /* renamed from: g */
    private TextView f16419g = ((TextView) this.f16414b.findViewById(R.id.tv_sub_content));

    /* renamed from: h */
    private SimpleDraweeView f16420h = ((SimpleDraweeView) this.f16414b.findViewById(R.id.iv_main_icon));

    /* renamed from: i */
    private ImageView f16421i = ((ImageView) this.f16414b.findViewById(R.id.iv_sub_icon));

    /* renamed from: j */
    private long f16422j;

    public void updateWaitTime(int i) {
    }

    public MTGWaitAcceptView(Activity activity, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.match_to_go_wait_accept_layout_20, viewGroup, false);
        this.f16414b = inflate;
        this.f16416d = (TextView) inflate.findViewById(R.id.tv_title);
    }

    public View getView() {
        return this.f16414b;
    }

    public void setPresenter(AbsMTGWaitAcceptPresenter absMTGWaitAcceptPresenter) {
        this.f16413a = absMTGWaitAcceptPresenter;
    }

    public void setWaitAccept(WaitAcceptModel waitAcceptModel) {
        if (waitAcceptModel == null) {
            SystemUtils.log(6, "mtg", "wait accept data is null", (Throwable) null, "com.didi.component.matchtogo20.wait.view.MTGWaitAcceptView", 62);
            return;
        }
        this.f16416d.setText(waitAcceptModel.title);
        if (TextUtils.isEmpty(waitAcceptModel.sub_title)) {
            this.f16417e.setVisibility(8);
        } else {
            this.f16417e.setVisibility(0);
            this.f16417e.setText(waitAcceptModel.sub_title);
        }
        this.f16418f.setText(waitAcceptModel.main_content);
        this.f16419g.setText(HighlightUtil.highlight((CharSequence) waitAcceptModel.sub_content, Color.parseColor(ColorUtils.DIDI_GREEN_MOUTON), false));
        this.f16420h.setController(((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setUri(Uri.parse("res://" + this.f16414b.getContext().getPackageName() + "/" + R.drawable.webp_cab)).setAutoPlayAnimations(true)).build());
        ((RequestBuilder) Glide.with((Context) DIDIBaseApplication.getAppContext()).asBitmap().load(waitAcceptModel.sub_icon_url).error((int) R.drawable.global_driver_car_default_avatar)).into(this.f16421i);
        this.f16422j = waitAcceptModel.call_match_on_trip_time;
    }
}
