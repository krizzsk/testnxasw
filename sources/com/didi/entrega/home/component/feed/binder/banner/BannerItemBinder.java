package com.didi.entrega.home.component.feed.binder.banner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.support.view.recyclerview.binder.StaggerItemViewHolder;
import com.didi.entrega.customer.base.binder.logic.CustomerLogicItemBinder;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.home.component.feed.binder.model.banner.BannerRvModel;
import com.didi.entrega.home.manager.HomeOmegaHelper;
import com.didi.entrega.home.widget.CustomerIndicator;
import com.didi.nova.assembly.p128ui.banner.OnBannerClickListener;
import com.taxis99.R;
import java.util.ArrayList;

public class BannerItemBinder extends CustomerLogicItemBinder<RvBannerLogic, BannerRvModel, ViewHolder> {
    public static final float INDEX_V3_BANNER_SIZE_RATIO = 0.31778425f;
    public static final float USER_CENTER_BANNER_SIZE_RATIO = 0.2682216f;

    /* renamed from: a */
    private float f22519a;
    public RvBannerLogic bannerLogic;

    public BannerItemBinder(float f) {
        this.f22519a = f;
    }

    public Class<BannerRvModel> bindDataType() {
        return BannerRvModel.class;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.entrega_item_rv_banner, viewGroup, false), this.f22519a);
    }

    public void bind(final ViewHolder viewHolder, final BannerRvModel bannerRvModel) {
        if (bannerRvModel.mDataChanged) {
            ArrayList arrayList = new ArrayList();
            for (BannerRvModel.BannerItemRvModel bannerItemRvModel : bannerRvModel.mBannerList) {
                arrayList.add(bannerItemRvModel.mImg);
            }
            viewHolder.mBanner.setIsAutoPlay(arrayList.size() >= 2);
            viewHolder.mBanner.setDatas(viewHolder.itemView.getContext(), this.f22519a, arrayList, new OnBannerImageDownLoadListener() {
                public void onFail(int i) {
                    HomeOmegaHelper.Companion.homeBannerImageDownLoadTime(bannerRvModel, i, -1);
                }

                public void onSuccess(int i, long j) {
                    HomeOmegaHelper.Companion.homeBannerImageDownLoadTime(bannerRvModel, i, j);
                }
            });
            viewHolder.mIndicator.initIndicator(bannerRvModel.mBannerList.size());
            bannerRvModel.mDataChanged = false;
        }
        viewHolder.mBanner.setBannerClickListener(new OnBannerClickListener() {
            public void onBannerClick(int i) {
                ((RvBannerLogic) BannerItemBinder.this.getBinderLogic()).onBannerClick(bannerRvModel, i);
            }

            public void onBannerPageSelected(int i) {
                viewHolder.mIndicator.setSelectedPage(i);
                ((RvBannerLogic) BannerItemBinder.this.getBinderLogic()).onBannerPageSelected(bannerRvModel, i);
            }
        });
        viewHolder.mBanner.setFocusable(false);
        viewHolder.mBanner.setFocusableInTouchMode(false);
    }

    public RvBannerLogic onCreateBinderLogic() {
        RvBannerLogic rvBannerLogic = this.bannerLogic;
        if (rvBannerLogic != null) {
            return rvBannerLogic;
        }
        return new BannerLogicImpl();
    }

    static class ViewHolder extends StaggerItemViewHolder<BannerRvModel> {
        /* access modifiers changed from: private */
        public RvBanner mBanner = ((RvBanner) findViewById(R.id.customer_custom_rv_banner));
        /* access modifiers changed from: private */
        public CustomerIndicator mIndicator = ((CustomerIndicator) findViewById(R.id.customer_custom_indicator));

        ViewHolder(View view, float f) {
            super(view);
            ViewGroup.LayoutParams layoutParams = this.mBanner.getLayoutParams();
            layoutParams.width = CustomerSystemUtil.getScreenWidth(view.getContext()) - ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_64);
            layoutParams.height = (int) (((float) layoutParams.width) * f);
            this.mBanner.setLayoutParams(layoutParams);
        }
    }
}
