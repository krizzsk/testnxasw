package com.didi.component.grade;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.view.BaseDialogFragment;
import com.didichuxing.publicservice.resourcecontrol.utils.DensityUtil;
import com.taxis99.R;

public class HomeImageDialog extends BaseDialogFragment {

    /* renamed from: a */
    private View f15849a;

    /* renamed from: b */
    private ImageView f15850b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ImageView f15851c;

    /* renamed from: d */
    private ImageView f15852d;

    /* renamed from: e */
    private Builder f15853e;

    /* renamed from: f */
    private int f15854f;

    /* renamed from: g */
    private int f15855g;

    /* renamed from: h */
    private TextView f15856h;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, 2132017496);
        setCancelable(false);
        this.f15854f = DensityUtil.dip2px(getContext(), 267.0f);
        this.f15855g = DensityUtil.dip2px(getContext(), 356.0f);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.global_dialog_home_image, viewGroup, false);
        m13160a(inflate);
        return inflate;
    }

    /* renamed from: a */
    private void m13160a(View view) {
        this.f15849a = view.findViewById(R.id.global_home_image_content);
        this.f15850b = (ImageView) view.findViewById(R.id.global_image_iv);
        this.f15851c = (ImageView) view.findViewById(R.id.global_loading_img);
        this.f15852d = (ImageView) view.findViewById(R.id.global_image_close);
        this.f15856h = (TextView) view.findViewById(R.id.global_member_level_prompt_tv);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((AnimationDrawable) this.f15851c.getDrawable()).start();
        Builder builder = this.f15853e;
        if (builder != null) {
            if (!TextUtils.isEmpty(builder.imgUrl)) {
                ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) Glide.with(getContext()).load(this.f15853e.imgUrl).override(this.f15854f, this.f15855g)).centerCrop()).dontAnimate()).into(new CustomTarget<Drawable>() {
                    public void onLoadCleared(Drawable drawable) {
                    }

                    public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                        HomeImageDialog.this.f15851c.setVisibility(8);
                    }
                });
            }
            if (!TextUtil.isEmpty(this.f15853e.text)) {
                this.f15856h.setVisibility(0);
                this.f15856h.setText(this.f15853e.text);
            }
            if (this.f15853e.listener != null) {
                this.f15849a.setOnClickListener(this.f15853e.listener);
            }
        }
        this.f15852d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                HomeImageDialog.this.dismiss();
            }
        });
    }

    public Builder build() {
        Builder builder = new Builder();
        this.f15853e = builder;
        return builder;
    }

    public class Builder {
        String imgUrl;
        View.OnClickListener listener;
        String text;

        public Builder() {
        }

        public Builder image(String str) {
            this.imgUrl = str;
            return this;
        }

        public Builder promptText(String str) {
            this.text = str;
            return this;
        }

        public Builder actions(View.OnClickListener onClickListener) {
            this.listener = onClickListener;
            return this;
        }

        public void show(final FragmentManager fragmentManager, final String str) {
            UiThreadHandler.post(new Runnable() {
                public void run() {
                    if (fragmentManager != null) {
                        HomeImageDialog.this.show(fragmentManager, str);
                    }
                }
            });
        }
    }
}
