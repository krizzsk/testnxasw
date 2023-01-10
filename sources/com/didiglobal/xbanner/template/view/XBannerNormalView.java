package com.didiglobal.xbanner.template.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.xbanner.basemodel.XBCardView;
import com.didi.global.xbanner.utils.XBannerUtil;
import com.didi.global.xbanner.view.recycler.XbCardReloadListener;
import com.didi.soda.compose.card.BaseCard;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.xbanner.router.XBRouter;
import com.didiglobal.xbanner.template.mdel.XBannerArrowModel;
import com.didiglobal.xbanner.template.mdel.XBannerCardClick;
import com.didiglobal.xbanner.template.mdel.XBannerModelContent;
import com.didiglobal.xbanner.template.mdel.normal.XBannerNormalModel;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class XBannerNormalView extends FrameLayout implements XBCardView<XBannerNormalModel> {

    /* renamed from: a */
    private ImageView f54030a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ImageView f54031b;

    /* renamed from: c */
    private TextView f54032c;

    /* renamed from: d */
    private TextView f54033d;

    /* renamed from: e */
    private ConstraintLayout f54034e;

    /* renamed from: f */
    private ImageView f54035f;

    public void setReloadListener(XbCardReloadListener xbCardReloadListener) {
    }

    public XBannerNormalView(Context context) {
        super(context);
        init(context);
    }

    public XBannerNormalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public XBannerNormalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.xbanner_normal_template_item, this);
        this.f54030a = (ImageView) findViewById(R.id.normal_right_icon);
        this.f54031b = (ImageView) findViewById(R.id.normal_bg_view);
        this.f54032c = (TextView) findViewById(R.id.normal_item_content);
        this.f54033d = (TextView) findViewById(R.id.normal_item_title);
        this.f54034e = (ConstraintLayout) findViewById(R.id.normal_item_cons_layout);
        this.f54035f = (ImageView) findViewById(R.id.right_arrow_icon);
    }

    public View createView(final Context context, final XBannerNormalModel xBannerNormalModel, final int i) {
        int i2;
        int i3;
        if (xBannerNormalModel == null) {
            return this;
        }
        XBannerArrowModel xBannerArrowModel = xBannerNormalModel.arrow;
        if (xBannerArrowModel != null) {
            i2 = xBannerArrowModel.position;
            i3 = xBannerArrowModel.type;
        } else {
            i3 = -1;
            i2 = 0;
        }
        if (!TextUtils.isEmpty(xBannerNormalModel.bg_image)) {
            Glide.with(context).asBitmap().load(xBannerNormalModel.bg_image).into(new CustomTarget<Bitmap>() {
                public void onLoadCleared(Drawable drawable) {
                }

                public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                    if (bitmap != null) {
                        Bitmap bitmapCut = BitmapCut.bitmapCut(bitmap, i, XBannerUtil.getItemHeight(context));
                        XBannerNormalView.this.f54031b.setScaleType(ImageView.ScaleType.FIT_XY);
                        ImageView a = XBannerNormalView.this.f54031b;
                        if (bitmapCut != null) {
                            bitmap = bitmapCut;
                        }
                        a.setImageBitmap(bitmap);
                    }
                }
            });
        } else if (!TextUtils.isEmpty(xBannerNormalModel.bg_color)) {
            try {
                this.f54031b.setBackgroundColor(XBannerUtil.getColor(xBannerNormalModel.bg_color));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        XBannerModelContent xBannerModelContent = xBannerNormalModel.subtitle;
        int i4 = 1;
        if (xBannerModelContent == null || TextUtils.isEmpty(xBannerModelContent.text)) {
            this.f54032c.setVisibility(8);
        } else {
            this.f54032c.setVisibility(0);
            this.f54032c.setText(xBannerModelContent.text);
            if (xBannerModelContent.size > 0) {
                this.f54032c.setTextSize(2, (float) xBannerModelContent.size);
            }
            this.f54032c.setText(C18075b.m40287b(context, xBannerModelContent.text, i3, i2));
            this.f54032c.setTextColor(XBannerUtil.getColor(xBannerModelContent.color));
            this.f54032c.setTypeface(Typeface.defaultFromStyle(xBannerModelContent.bold == 1 ? 1 : 0));
        }
        XBannerModelContent xBannerModelContent2 = xBannerNormalModel.title;
        if (xBannerModelContent2 == null || xBannerModelContent2.text == null) {
            this.f54033d.setVisibility(8);
        } else {
            this.f54033d.setVisibility(0);
            int i5 = this.f54032c.getVisibility() == 0 ? 1 : 2;
            this.f54033d.setMaxLines(i5);
            if (xBannerModelContent2.size > 0) {
                this.f54033d.setTextSize(2, (float) xBannerModelContent2.size);
            }
            this.f54033d.setTextColor(XBannerUtil.getColor(xBannerModelContent2.color));
            TextView textView = this.f54033d;
            if (xBannerModelContent2.bold != 1) {
                i4 = 0;
            }
            textView.setTypeface(Typeface.defaultFromStyle(i4));
            this.f54033d.setText(C18075b.m40285a(context, xBannerModelContent2.text, i3, i2, i5));
        }
        final XBannerCardClick xBannerCardClick = xBannerNormalModel.card_click;
        if (xBannerCardClick != null) {
            this.f54034e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    XBRouter.routerStart(xBannerCardClick.url, xBannerNormalModel.extension);
                    HashMap hashMap = new HashMap();
                    if (xBannerNormalModel.extension != null) {
                        hashMap.put(BaseCard.KEY_CARD_ID, xBannerNormalModel.extension.f54020id);
                        hashMap.put("rank", Integer.valueOf(xBannerNormalModel.extension.index));
                        if (xBannerNormalModel.extension.log_data != null) {
                            try {
                                hashMap.putAll((Map) new Gson().fromJson((JsonElement) xBannerNormalModel.extension.log_data, new HashMap().getClass()));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    hashMap.put("type", 1);
                    OmegaSDKAdapter.trackEvent("ibt_gp_operationcard_ck", (Map<String, Object>) hashMap);
                }
            });
        }
        Glide.with(context).load(xBannerNormalModel.right_icon).into(this.f54030a);
        if (C18075b.m40289c(i2)) {
            this.f54035f.setVisibility(0);
            this.f54035f.setImageDrawable(C18075b.m40282a(context, i3));
        } else {
            this.f54035f.setVisibility(8);
        }
        return this;
    }
}
