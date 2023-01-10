package com.didi.component.comp_selectseat.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.StringUtil;
import com.didi.component.common.util.UIUtils;
import com.didi.component.comp_selectseat.SeatSelectUtils;
import com.didi.component.comp_selectseat.model.HybridIconAndTextListModel;
import com.didi.component.comp_selectseat.model.SeatOptionsModel;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.sdk.util.TextUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class SeatsSelectedAdapter extends RecyclerView.Adapter<SeatsViewHolder> {

    /* renamed from: a */
    private static final String f14229a = "SeatsSelectedAdapter";

    /* renamed from: b */
    private final List<SeatOptionsModel> f14230b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final SeatSelectItemClickListener f14231c;

    /* renamed from: d */
    private final Context f14232d;

    /* renamed from: e */
    private final LoadingTimeOutListener f14233e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f14234f = true;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final List<Boolean> f14235g = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f14236h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f14237i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f14238j;

    public SeatsSelectedAdapter(Context context, SeatSelectItemClickListener seatSelectItemClickListener, LoadingTimeOutListener loadingTimeOutListener) {
        this.f14232d = context;
        this.f14231c = seatSelectItemClickListener;
        this.f14233e = loadingTimeOutListener;
    }

    public SeatsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new SeatsViewHolder(LayoutInflater.from(this.f14232d).inflate(R.layout.seat_item_view, viewGroup, false));
    }

    public void onBindViewHolder(final SeatsViewHolder seatsViewHolder, final int i) {
        final SeatOptionsModel seatOptionsModel = this.f14230b.get(i);
        if (seatOptionsModel != null) {
            if (this.f14238j) {
                seatsViewHolder.mSelectIcon.setImageResource(R.drawable.icon_minibus_unselected);
                seatsViewHolder.mPriceLayout.setVisibility(8);
            } else {
                if (this.f14235g.get(i).booleanValue()) {
                    seatsViewHolder.mSelectIcon.setImageResource(R.drawable.icon_minibus_selected);
                    m11807a(seatsViewHolder, this.f14237i);
                } else {
                    seatsViewHolder.mSelectIcon.setImageResource(R.drawable.icon_minibus_unselected);
                    m11807a(seatsViewHolder, false);
                }
                if (this.f14237i) {
                    seatsViewHolder.mPriceLayout.setVisibility(8);
                } else {
                    seatsViewHolder.mPriceLayout.setVisibility(0);
                }
            }
            if (seatOptionsModel.text == null || TextUtil.isEmpty(seatOptionsModel.text.getContent())) {
                GLog.m11357e(f14229a, "onBindViewHolder >> text is null or size =0");
            } else {
                seatOptionsModel.text.bindTextView(seatsViewHolder.mSeatCount);
            }
            m11806a(seatsViewHolder, seatOptionsModel.priceList);
            m11805a(seatsViewHolder.mHybridIconAndTextLayout, seatOptionsModel.hybridIconAndTextList);
            seatsViewHolder.mItemRoot.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (!((Boolean) SeatsSelectedAdapter.this.f14235g.get(i)).booleanValue() && !SeatsSelectedAdapter.this.f14237i && SeatsSelectedAdapter.this.f14234f) {
                        int unused = SeatsSelectedAdapter.this.f14236h = i;
                        boolean unused2 = SeatsSelectedAdapter.this.f14238j = true;
                        SeatsSelectedAdapter.this.notifyDataSetChanged();
                        boolean unused3 = SeatsSelectedAdapter.this.f14234f = false;
                        SeatsSelectedAdapter.this.f14235g.set(i, true);
                        SeatsSelectedAdapter.this.f14231c.seatSelectListener(i, seatOptionsModel.seatNum, seatOptionsModel.paramsModel, seatsViewHolder.itemView.getY());
                    }
                }
            });
            return;
        }
        this.f14233e.showLoadingTimeoutView();
        GLog.m11357e(f14229a, "onBindViewHolder >> seatOptionsModel is null");
    }

    /* renamed from: a */
    private void m11805a(LinearLayout linearLayout, List<HybridIconAndTextListModel> list) {
        if (list == null || list.size() <= 0) {
            linearLayout.setVisibility(8);
            GLog.m11357e(f14229a, "setHybridIconAndText >> hybridIconAndTextList is null or size=0");
            return;
        }
        linearLayout.removeAllViews();
        linearLayout.setVisibility(0);
        for (int size = list.size() - 1; size >= 0; size--) {
            HybridIconAndTextListModel hybridIconAndTextListModel = list.get(size);
            if (hybridIconAndTextListModel.type == 1 && !StringUtil.isNullOrEmpty(hybridIconAndTextListModel.icon) && !SeatSelectUtils.isDestroy((Activity) this.f14232d)) {
                View inflate = LayoutInflater.from(this.f14232d).inflate(R.layout.seat_select_item_dynamic_layout, linearLayout, false);
                linearLayout.addView(inflate);
                inflate.setVisibility(0);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.new_estimate_dynamic);
                imageView.setVisibility(0);
                Glide.with(this.f14232d).load(hybridIconAndTextListModel.icon).into(imageView);
                if (list.size() == 1) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
                    layoutParams.bottomMargin = UiUtils.dip2px(this.f14232d, 3.0f);
                    layoutParams.rightMargin = UiUtils.dip2px(this.f14232d, 0.0f);
                    inflate.setLayoutParams(layoutParams);
                }
            } else if (hybridIconAndTextListModel.type != 2 || hybridIconAndTextListModel.info == null || StringUtil.isNullOrEmpty(hybridIconAndTextListModel.info.getContent())) {
                if (hybridIconAndTextListModel.type == 3 && hybridIconAndTextListModel.info != null && !StringUtil.isNullOrEmpty(hybridIconAndTextListModel.info.getContent())) {
                    View inflate2 = LayoutInflater.from(this.f14232d).inflate(R.layout.new_estimate_item_discount_icon_text_layout, linearLayout, false);
                    linearLayout.addView(inflate2);
                    inflate2.setVisibility(0);
                    ImageView imageView2 = (ImageView) inflate2.findViewById(R.id.new_estimate_discount_icon);
                    if (StringUtil.isNullOrEmpty(hybridIconAndTextListModel.icon) || SeatSelectUtils.isDestroy((Activity) this.f14232d)) {
                        imageView2.setVisibility(8);
                    } else {
                        imageView2.setVisibility(0);
                        Glide.with(this.f14232d).load(hybridIconAndTextListModel.icon).into(imageView2);
                    }
                    TextView textView = (TextView) inflate2.findViewById(R.id.new_estimate_discount);
                    textView.setVisibility(0);
                    hybridIconAndTextListModel.info.bindTextView(textView);
                    if (!StringUtil.isNullOrEmpty(hybridIconAndTextListModel.colorStart) && !StringUtil.isNullOrEmpty(hybridIconAndTextListModel.colorEnd)) {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                        gradientDrawable.setColors(new int[]{Color.parseColor(hybridIconAndTextListModel.colorStart), Color.parseColor(hybridIconAndTextListModel.colorEnd)});
                        gradientDrawable.setCornerRadius(UIUtils.dip2px(this.f14232d, 6.0f));
                        inflate2.setBackground(gradientDrawable);
                    }
                }
            } else if (StringUtil.isNullOrEmpty(hybridIconAndTextListModel.colorStart) || StringUtil.isNullOrEmpty(hybridIconAndTextListModel.colorEnd)) {
                View inflate3 = LayoutInflater.from(this.f14232d).inflate(R.layout.new_estimate_item_origin_price_layout, linearLayout, false);
                linearLayout.addView(inflate3);
                inflate3.setVisibility(0);
                TextView textView2 = (TextView) inflate3.findViewById(R.id.new_estimate_origin_price);
                textView2.setVisibility(0);
                hybridIconAndTextListModel.info.bindTextView(textView2);
            } else {
                View inflate4 = LayoutInflater.from(this.f14232d).inflate(R.layout.new_estimate_item_discount_icon_text_layout, linearLayout, false);
                linearLayout.addView(inflate4);
                inflate4.setVisibility(0);
                ((ImageView) inflate4.findViewById(R.id.new_estimate_discount_icon)).setVisibility(8);
                TextView textView3 = (TextView) inflate4.findViewById(R.id.new_estimate_discount);
                textView3.setVisibility(0);
                hybridIconAndTextListModel.info.bindTextView(textView3);
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                gradientDrawable2.setColors(new int[]{Color.parseColor(hybridIconAndTextListModel.colorStart), Color.parseColor(hybridIconAndTextListModel.colorEnd)});
                gradientDrawable2.setCornerRadius(UIUtils.dip2px(this.f14232d, 6.0f));
                inflate4.setBackground(gradientDrawable2);
            }
        }
    }

    /* renamed from: a */
    private void m11806a(SeatsViewHolder seatsViewHolder, List<SeatOptionsModel.PriceValue> list) {
        if (list == null || list.size() <= 0) {
            seatsViewHolder.mPriceContainer.setVisibility(8);
            GLog.m11357e(f14229a, "setPrice >> priceList is null or size =0");
            return;
        }
        seatsViewHolder.mPriceContainer.removeAllViews();
        seatsViewHolder.mPriceContainer.setVisibility(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                if (list.get(i).valueText != null) {
                    LEGORichInfo lEGORichInfo = list.get(i).valueText;
                    TextView textView = new TextView(this.f14232d);
                    textView.setGravity(17);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(0, 0, 0, UIUtils.dip2pxInt(this.f14232d, ((float) list.get(i).length) / 2.0f));
                    seatsViewHolder.mPriceContainer.addView(textView, layoutParams);
                    lEGORichInfo.bindTextView(textView);
                } else {
                    GLog.m11357e(f14229a, "setPrice >> priceList is null or size =0");
                }
            }
        }
    }

    public int getItemCount() {
        return this.f14230b.size();
    }

    public void setDate(List<SeatOptionsModel> list, boolean z) {
        if (z) {
            this.f14236h = 0;
        }
        this.f14230b.clear();
        this.f14235g.clear();
        this.f14230b.addAll(list);
        this.f14237i = false;
        for (int i = 0; i < list.size(); i++) {
            if (this.f14236h == i) {
                this.f14235g.add(true);
            } else {
                this.f14235g.add(false);
            }
        }
        notifyDataSetChanged();
        this.f14234f = true;
    }

    /* renamed from: a */
    private void m11807a(SeatsViewHolder seatsViewHolder, boolean z) {
        if (z) {
            seatsViewHolder.mLoadingTopView.setVisibility(0);
            seatsViewHolder.mLoadingBottomView.setVisibility(0);
            return;
        }
        seatsViewHolder.mLoadingTopView.setVisibility(8);
        seatsViewHolder.mLoadingBottomView.setVisibility(8);
    }

    public void showLoadingStatus() {
        this.f14238j = false;
        this.f14237i = true;
        this.f14235g.clear();
        for (int i = 0; i < this.f14230b.size(); i++) {
            this.f14235g.add(false);
        }
        this.f14235g.set(this.f14236h, true);
        notifyDataSetChanged();
    }
}
