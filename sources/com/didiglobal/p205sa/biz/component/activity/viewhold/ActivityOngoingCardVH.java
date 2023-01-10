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
import com.taxis99.R;
import java.util.Collection;

/* renamed from: com.didiglobal.sa.biz.component.activity.viewhold.ActivityOngoingCardVH */
public class ActivityOngoingCardVH extends BaseRecVH {

    /* renamed from: a */
    private final View f53308a;

    /* renamed from: b */
    private TextView f53309b;

    /* renamed from: c */
    private ImageView f53310c;

    /* renamed from: d */
    private TextView f53311d;

    /* renamed from: e */
    private TextView f53312e;

    /* renamed from: f */
    private TextView f53313f;

    /* renamed from: g */
    private TextView f53314g;

    public ActivityOngoingCardVH(View view) {
        super(view);
        this.f53312e = (TextView) view.findViewById(R.id.order_status);
        this.f53313f = (TextView) view.findViewById(R.id.order_status_detail);
        this.f53311d = (TextView) view.findViewById(R.id.order_flag);
        this.f53314g = (TextView) view.findViewById(R.id.order_flag_tips);
        this.f53310c = (ImageView) view.findViewById(R.id.business_image);
        this.f53309b = (TextView) view.findViewById(R.id.ongoing_card_btn);
        this.f53308a = view.findViewById(R.id.ongoing_content);
    }

    public void bindView(final ActivityCardModel activityCardModel) {
        if (activityCardModel != null) {
            String bg_color = activityCardModel.getBg_color();
            View view = this.f53308a;
            if (view != null) {
                try {
                    view.setBackgroundColor(Color.parseColor(bg_color));
                } catch (Exception unused) {
                    this.f53308a.findViewById(R.id.ongoing_content).setBackgroundColor(Color.parseColor("#F3F4F8"));
                }
            }
            if (activityCardModel.getOrder_status() != null) {
                activityCardModel.getOrder_status().bindTextView(this.f53312e);
            }
            if (activityCardModel.getOrder_status_detail() == null || TextUtils.isEmpty(activityCardModel.getOrder_status_detail().getContent())) {
                this.f53313f.setVisibility(8);
            } else {
                activityCardModel.getOrder_status_detail().bindTextView(this.f53313f);
            }
            if (activityCardModel.getOrder_flag() != null) {
                activityCardModel.getOrder_flag().bindTextView(this.f53311d);
            }
            if (activityCardModel.getOrder_flag_tips() != null) {
                activityCardModel.getOrder_flag_tips().bindTextView(this.f53314g);
            }
            if (!CollectionUtil.isEmpty((Collection<?>) activityCardModel.getButtons())) {
                this.f53309b.setVisibility(0);
                final ActivityCardModel.ButtonsBean buttonsBean = activityCardModel.getButtons().get(0);
                if (buttonsBean != null) {
                    if (buttonsBean.getInfo() != null) {
                        buttonsBean.getInfo().bindTextView(this.f53309b);
                    }
                    this.f53309b.setBackground(UiUtils.INSTANCE.getRadiusBgDrawable(this.f53309b.getContext(), buttonsBean.getStart_color(), buttonsBean.getEnd_color(), "#E9ECF2", 15.0f));
                    if (!TextUtils.isEmpty(buttonsBean.getAction())) {
                        this.f53309b.setOnClickListener(new View.OnClickListener() {
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
                this.f53309b.setVisibility(8);
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
            ((RequestBuilder) Glide.with(this.itemView.getContext()).load(activityCardModel.getBusiness_image()).placeholder((int) R.drawable.sa_business_default)).into(this.f53310c);
        }
    }
}
