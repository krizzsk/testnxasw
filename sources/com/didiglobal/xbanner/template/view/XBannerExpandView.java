package com.didiglobal.xbanner.template.view;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didi.global.xbanner.basemodel.XBCardView;
import com.didi.global.xbanner.utils.XBannerUtil;
import com.didi.global.xbanner.view.recycler.XbCardReloadListener;
import com.didi.soda.compose.card.BaseCard;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.xbanner.router.XBRouter;
import com.didiglobal.xbanner.template.mdel.XBannerArrowModel;
import com.didiglobal.xbanner.template.mdel.XBannerCardClick;
import com.didiglobal.xbanner.template.mdel.XBannerExtension;
import com.didiglobal.xbanner.template.mdel.XBannerModelContent;
import com.didiglobal.xbanner.template.mdel.expand.XBannerExpandBtn;
import com.didiglobal.xbanner.template.mdel.expand.XBannerExpandModel;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class XBannerExpandView extends FrameLayout implements XBCardView<XBannerExpandModel> {

    /* renamed from: a */
    private Context f54021a;

    /* renamed from: b */
    private ImageView f54022b;

    /* renamed from: c */
    private TextView f54023c;

    /* renamed from: d */
    private TextView f54024d;

    /* renamed from: e */
    private TextView f54025e;

    /* renamed from: f */
    private CardView f54026f;

    /* renamed from: g */
    private ConstraintLayout f54027g;

    /* renamed from: h */
    private ImageView f54028h;

    /* renamed from: i */
    private ImageView f54029i;

    public void setReloadListener(XbCardReloadListener xbCardReloadListener) {
    }

    public XBannerExpandView(Context context) {
        super(context);
        init(context);
    }

    public XBannerExpandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public XBannerExpandView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void init(Context context) {
        this.f54021a = context;
        LayoutInflater.from(context).inflate(R.layout.xbanner_expand_template_item, this);
        this.f54022b = (ImageView) findViewById(R.id.expand_right_icon);
        this.f54023c = (TextView) findViewById(R.id.expand_btn_text);
        this.f54024d = (TextView) findViewById(R.id.expand_content);
        this.f54025e = (TextView) findViewById(R.id.expand_title);
        this.f54026f = (CardView) findViewById(R.id.expand_btn_view);
        this.f54027g = (ConstraintLayout) findViewById(R.id.expand_layout);
        this.f54028h = (ImageView) findViewById(R.id.expand_bg_view);
        this.f54029i = (ImageView) findViewById(R.id.right_arrow_icon);
    }

    public View createView(Context context, final XBannerExpandModel xBannerExpandModel, int i) {
        int i2;
        int i3;
        if (xBannerExpandModel == null) {
            return this;
        }
        XBannerArrowModel xBannerArrowModel = xBannerExpandModel.arrow;
        int i4 = 0;
        if (xBannerArrowModel != null) {
            i3 = xBannerArrowModel.position;
            i2 = xBannerArrowModel.type;
        } else {
            i2 = -1;
            i3 = 0;
        }
        if (!TextUtils.isEmpty(xBannerExpandModel.bg_image)) {
            ((RequestBuilder) Glide.with(context).load(xBannerExpandModel.bg_image).centerCrop()).into(this.f54028h);
        } else if (!TextUtils.isEmpty(xBannerExpandModel.bg_color)) {
            try {
                this.f54028h.setBackgroundColor(XBannerUtil.getColor(xBannerExpandModel.bg_color));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        XBannerModelContent xBannerModelContent = xBannerExpandModel.title;
        if (xBannerModelContent == null || xBannerModelContent.text == null) {
            this.f54025e.setVisibility(8);
        } else {
            this.f54025e.setVisibility(0);
            this.f54025e.setText(C18075b.m40284a(context, xBannerModelContent.text, i2, i3));
            if (xBannerModelContent.size > 0) {
                this.f54025e.setTextSize(2, (float) xBannerModelContent.size);
            }
            this.f54025e.setTextColor(XBannerUtil.getColor(xBannerModelContent.color));
            this.f54025e.setTypeface(Typeface.defaultFromStyle(xBannerModelContent.bold == 1 ? 1 : 0));
        }
        XBannerModelContent xBannerModelContent2 = xBannerExpandModel.subtitle;
        if (xBannerModelContent2 == null || xBannerModelContent2.text == null) {
            this.f54024d.setVisibility(8);
        } else {
            this.f54024d.setVisibility(0);
            this.f54024d.setText(C18075b.m40287b(context, xBannerModelContent2.text, i2, i3));
            if (xBannerModelContent2.size > 0) {
                this.f54024d.setTextSize(2, (float) xBannerModelContent2.size);
            }
            this.f54024d.setTextColor(XBannerUtil.getColor(xBannerModelContent2.color));
            this.f54024d.setTypeface(Typeface.defaultFromStyle(xBannerModelContent2.bold == 1 ? 1 : 0));
        }
        final XBannerCardClick xBannerCardClick = xBannerExpandModel.card_click;
        if (xBannerCardClick != null) {
            this.f54027g.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    XBRouter.routerStart(xBannerCardClick.url, xBannerExpandModel.extension);
                    HashMap hashMap = new HashMap();
                    if (xBannerExpandModel.extension != null) {
                        hashMap.put(BaseCard.KEY_CARD_ID, xBannerExpandModel.extension.f54020id);
                        if (xBannerExpandModel.extension.log_data != null) {
                            try {
                                hashMap.putAll((Map) new Gson().fromJson((JsonElement) xBannerExpandModel.extension.log_data, new HashMap().getClass()));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    hashMap.put("type", 0);
                    hashMap.put("rank", 0);
                    OmegaSDKAdapter.trackEvent("ibt_gp_operationcard_ck", (Map<String, Object>) hashMap);
                }
            });
        }
        if (!TextUtils.isEmpty(xBannerExpandModel.right_icon)) {
            this.f54022b.setVisibility(0);
            Glide.with(context).load(xBannerExpandModel.right_icon).into(this.f54022b);
        } else {
            this.f54022b.setVisibility(4);
        }
        if (C18075b.m40289c(i3)) {
            this.f54029i.setVisibility(0);
            this.f54029i.setImageDrawable(C18075b.m40282a(context, i2));
        } else {
            this.f54029i.setVisibility(8);
        }
        final XBannerExpandBtn xBannerExpandBtn = xBannerExpandModel.button_click;
        if (xBannerExpandBtn == null || xBannerExpandBtn.text == null || TextUtils.isEmpty(xBannerExpandBtn.text.text)) {
            this.f54026f.setVisibility(8);
        } else {
            this.f54026f.setVisibility(0);
            this.f54023c.setBackgroundColor(XBannerUtil.getColor(xBannerExpandBtn.bg_color));
            this.f54023c.setText(xBannerExpandBtn.text.text);
            if (!TextUtils.isEmpty(xBannerExpandBtn.text.color)) {
                this.f54023c.setTextColor(XBannerUtil.getColor(xBannerExpandBtn.text.color));
            }
            if (xBannerExpandBtn.text.size > 0) {
                this.f54023c.setTextSize(2, (float) xBannerExpandBtn.text.size);
            }
            TextView textView = this.f54023c;
            if (xBannerExpandBtn.text.bold == 1) {
                i4 = 1;
            }
            textView.setTypeface(Typeface.defaultFromStyle(i4));
            if (!TextUtils.isEmpty(xBannerExpandBtn.url)) {
                this.f54026f.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        XBannerExtension xBannerExtension = xBannerExpandModel.extension;
                        XBRouter.routerStart(xBannerExpandBtn.url, xBannerExtension);
                        HashMap hashMap = new HashMap();
                        hashMap.put(BaseCard.KEY_CARD_ID, xBannerExtension.f54020id);
                        if (xBannerExtension.log_data != null) {
                            try {
                                hashMap.putAll((Map) new Gson().fromJson((JsonElement) xBannerExpandModel.extension.log_data, new HashMap().getClass()));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        hashMap.put("type", 0);
                        hashMap.put(Const.BUTTON_ID, xBannerExpandBtn.optionId);
                        hashMap.put("rank", 0);
                        OmegaSDKAdapter.trackEvent("ibt_gp_operationcard_button_ck", (Map<String, Object>) hashMap);
                    }
                });
            }
        }
        return this;
    }
}
