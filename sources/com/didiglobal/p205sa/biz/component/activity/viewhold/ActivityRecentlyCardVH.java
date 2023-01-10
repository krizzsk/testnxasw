package com.didiglobal.p205sa.biz.component.activity.viewhold;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didiglobal.p205sa.biz.component.activity.model.ActivityCardModel;
import com.didiglobal.p205sa.biz.component.activity.omega.ActivityOmegaTracker;
import com.didiglobal.p205sa.biz.util.UiUtils;
import com.google.gson.Gson;
import com.taxis99.R;
import java.util.Collection;

/* renamed from: com.didiglobal.sa.biz.component.activity.viewhold.ActivityRecentlyCardVH */
public class ActivityRecentlyCardVH extends BaseRecVH {

    /* renamed from: a */
    private View f53317a;

    /* renamed from: b */
    private Gson f53318b = new Gson();

    /* renamed from: c */
    private TextView f53319c;

    /* renamed from: d */
    private ImageView f53320d;

    /* renamed from: e */
    private TextView f53321e;

    /* renamed from: f */
    private TextView f53322f;

    /* renamed from: g */
    private TextView f53323g;

    /* renamed from: h */
    private TextView f53324h;

    public ActivityRecentlyCardVH(View view) {
        super(view);
        this.f53322f = (TextView) view.findViewById(R.id.order_status);
        this.f53323g = (TextView) view.findViewById(R.id.order_status_detail);
        this.f53321e = (TextView) view.findViewById(R.id.order_flag);
        this.f53324h = (TextView) view.findViewById(R.id.order_flag_tips);
        this.f53320d = (ImageView) view.findViewById(R.id.business_image);
        this.f53319c = (TextView) view.findViewById(R.id.pass_card_btn);
        this.f53317a = view.findViewById(R.id.pass_content);
    }

    public void bindView(final ActivityCardModel activityCardModel) {
        if (activityCardModel != null) {
            String bg_color = activityCardModel.getBg_color();
            View view = this.f53317a;
            if (view != null) {
                try {
                    view.setBackgroundColor(Color.parseColor(bg_color));
                } catch (Exception unused) {
                    this.f53317a.findViewById(R.id.ongoing_content).setBackgroundColor(Color.parseColor("#D9ffffff"));
                }
            }
            if (activityCardModel.getOrder_status() != null) {
                activityCardModel.getOrder_status().bindTextView(this.f53322f);
            }
            if (activityCardModel.getOrder_status_detail() == null || TextUtils.isEmpty(activityCardModel.getOrder_status_detail().getContent())) {
                this.f53323g.setVisibility(8);
            } else {
                this.f53323g.setVisibility(0);
                activityCardModel.getOrder_status_detail().bindTextView(this.f53323g);
            }
            if (activityCardModel.getOrder_flag() != null) {
                activityCardModel.getOrder_flag().bindTextView(this.f53321e);
            }
            if (activityCardModel.getOrder_flag_tips() != null) {
                activityCardModel.getOrder_flag_tips().bindTextView(this.f53324h);
            }
            if (!CollectionUtil.isEmpty((Collection<?>) activityCardModel.getButtons())) {
                this.f53319c.setVisibility(0);
                final ActivityCardModel.ButtonsBean buttonsBean = activityCardModel.getButtons().get(0);
                if (buttonsBean != null) {
                    if (buttonsBean.getInfo() != null) {
                        buttonsBean.getInfo().bindTextView(this.f53319c);
                    }
                    this.f53319c.setBackground(UiUtils.INSTANCE.getRadiusBgDrawable(this.f53319c.getContext(), buttonsBean.getStart_color(), buttonsBean.getEnd_color(), "#FFFFFF", 15.0f));
                    if (!TextUtils.isEmpty(buttonsBean.getAction())) {
                        this.f53319c.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                AutoTrackHelper.trackViewOnClick(view);
                                ActivityOmegaTracker.OmegaCardBtnClick(activityCardModel, buttonsBean);
                                DRouter.build(buttonsBean.getAction()).start();
                            }
                        });
                    } else {
                        ActivityOmegaTracker.OmegaError(5);
                    }
                }
            } else {
                this.f53319c.setVisibility(8);
            }
            this.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (!TextUtils.isEmpty(activityCardModel.getCard_url())) {
                        ActivityOmegaTracker.OmegaCardClick(activityCardModel);
                        DRouter.build(activityCardModel.getCard_url()).start();
                    }
                }
            });
            ((RequestBuilder) Glide.with(this.itemView.getContext()).load(activityCardModel.getBusiness_image()).placeholder((int) R.drawable.sa_business_default)).into(this.f53320d);
        }
    }
}
