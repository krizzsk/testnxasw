package com.didi.soda.home.kingkong;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.soda.customer.foundation.rpc.entity.TagEntity;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.customer.widget.text.RichTextView;
import com.didi.soda.home.kingkong.HomeKingKongItemAdapter;
import com.didi.soda.home.manager.KingKongOmegaHelper;
import com.didi.soda.home.manager.TagStorage;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class HomeKingKongItemAdapter extends RecyclerView.Adapter<KingKongViewHolder> {

    /* renamed from: a */
    private List<KingKongItemModel> f45132a = new ArrayList();

    /* renamed from: b */
    private OnItemClickListener f45133b;

    public interface OnItemClickListener {
        void onItemClick(KingKongItemModel kingKongItemModel);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f45133b = onItemClickListener;
    }

    public int getItemCount() {
        return this.f45132a.size();
    }

    public void onBindViewHolder(KingKongViewHolder kingKongViewHolder, int i) {
        List<KingKongItemModel> list;
        if (kingKongViewHolder != null && (list = this.f45132a) != null && i < list.size()) {
            KingKongItemModel kingKongItemModel = this.f45132a.get(i);
            Context context = kingKongViewHolder.itemView.getContext();
            if (kingKongItemModel != null && context != null) {
                FlyImageLoader.loadImageUnspecified(kingKongViewHolder.itemView.getContext(), kingKongItemModel.getImg()).centerCrop().placeholder((int) R.drawable.customer_skin_img_placeholder_x43).error((int) R.drawable.customer_skin_img_placeholder_x43).into(kingKongViewHolder.f45134iv);
                kingKongViewHolder.f45135tv.setText(kingKongItemModel.getTitle());
                kingKongViewHolder.itemView.setOnClickListener(new View.OnClickListener(kingKongItemModel, i, kingKongViewHolder) {
                    public final /* synthetic */ KingKongItemModel f$1;
                    public final /* synthetic */ int f$2;
                    public final /* synthetic */ HomeKingKongItemAdapter.KingKongViewHolder f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void onClick(View view) {
                        HomeKingKongItemAdapter.this.m33519a(this.f$1, this.f$2, this.f$3, view);
                    }
                });
                if (kingKongItemModel.getSelected().intValue() == 1) {
                    kingKongViewHolder.rootView.setBackground(ContextCompat.getDrawable(context, R.drawable.customer_shape_bg_king_kong_selected_card));
                    kingKongViewHolder.f45135tv.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_brand1_1_a100));
                    kingKongViewHolder.f45135tv.setFontType(IToolsService.FontType.BOLD);
                } else {
                    kingKongViewHolder.rootView.setBackground(ContextCompat.getDrawable(context, R.drawable.customer_shape_bg_king_kong_card));
                    kingKongViewHolder.f45135tv.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
                    kingKongViewHolder.f45135tv.setFontType(IToolsService.FontType.MEDIUM);
                }
                TagEntity tag = kingKongItemModel.getTag();
                if (m33520a(tag)) {
                    kingKongViewHolder.mTvTag.setVisibility(0);
                    kingKongViewHolder.mTvTag.setText(tag.getContent());
                    GradientDrawable gradientDrawable = (GradientDrawable) kingKongViewHolder.mTvTag.getContext().getResources().getDrawable(R.drawable.customer_tabbar_item_tag_bg);
                    if (gradientDrawable != null) {
                        try {
                            if (!TextUtils.isEmpty(tag.getBackColor())) {
                                gradientDrawable.setColor(Color.parseColor(tag.getBackColor()));
                            } else {
                                gradientDrawable.setColor(ResourceHelper.getColor(R.color.rf_color_v2_red1_1_a100));
                            }
                        } catch (Exception e) {
                            e.fillInStackTrace();
                        }
                        kingKongViewHolder.mTvTag.setBackground(gradientDrawable);
                        return;
                    }
                    return;
                }
                kingKongViewHolder.mTvTag.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33519a(KingKongItemModel kingKongItemModel, int i, KingKongViewHolder kingKongViewHolder, View view) {
        OnItemClickListener onItemClickListener = this.f45133b;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(kingKongItemModel);
        }
        KingKongOmegaHelper.onKingKongItemCk(kingKongItemModel, i);
        m33518a(kingKongItemModel.getTag(), kingKongViewHolder.mTvTag);
    }

    /* renamed from: a */
    private void m33518a(TagEntity tagEntity, RichTextView richTextView) {
        if (tagEntity != null && m33520a(tagEntity)) {
            richTextView.setVisibility(8);
            if (!TextUtils.isEmpty(tagEntity.getCacheKey())) {
                ((TagStorage) SingletonFactory.get(TagStorage.class)).putLong(tagEntity.getCacheKey(), System.currentTimeMillis());
            }
        }
    }

    /* renamed from: a */
    private boolean m33520a(TagEntity tagEntity) {
        if (tagEntity == null || TextUtils.isEmpty(tagEntity.getContent())) {
            return false;
        }
        long j = ((TagStorage) SingletonFactory.get(TagStorage.class)).getLong(tagEntity.getCacheKey());
        if (TextUtils.isEmpty(tagEntity.getCacheKey()) || j == 0 || System.currentTimeMillis() - j > ((long) (tagEntity.getWaitTime() * 24 * 60 * 60)) * 1000) {
            return true;
        }
        return false;
    }

    public KingKongViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new KingKongViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_widget_home_king_kong, viewGroup, false));
    }

    public void setData(List<KingKongItemModel> list) {
        this.f45132a.clear();
        notifyDataSetChanged();
        this.f45132a.addAll(list);
        notifyDataSetChanged();
    }

    static class KingKongViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */

        /* renamed from: iv */
        public ImageView f45134iv;
        /* access modifiers changed from: private */
        public RichTextView mTvTag;
        /* access modifiers changed from: private */
        public ConstraintLayout rootView;
        /* access modifiers changed from: private */

        /* renamed from: tv */
        public CustomerAppCompatTextView f45135tv;

        KingKongViewHolder(View view) {
            super(view);
            this.f45134iv = (ImageView) view.findViewById(R.id.iv);
            this.f45135tv = (CustomerAppCompatTextView) view.findViewById(R.id.tv);
            this.rootView = (ConstraintLayout) view.findViewById(R.id.home_king_kong);
            this.mTvTag = (RichTextView) view.findViewById(R.id.customer_tv_king_kong_item_tag);
        }
    }
}
