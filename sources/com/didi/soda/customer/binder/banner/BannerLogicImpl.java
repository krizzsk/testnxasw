package com.didi.soda.customer.binder.banner;

import com.didi.soda.customer.base.binder.EmptyItemLogic;
import com.didi.soda.customer.binder.model.banner.BannerRvModel;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;

public class BannerLogicImpl extends RvBannerLogic {

    /* renamed from: a */
    private static final String f42977a = "BannerLogicImpl";

    public Class<EmptyItemLogic> bindLogicRepoType() {
        return EmptyItemLogic.class;
    }

    public void onBannerClick(BannerRvModel bannerRvModel, int i) {
        String str = bannerRvModel.mBannerList.get(i).mUrl;
        SchemeHelper.dispatchMsg(str);
        HomeOmegaHelper.getInstance().setBannerGuideParam(bannerRvModel.mBannerList.get(i));
        HomeOmegaHelper.getInstance().trackBannerClick(bannerRvModel, i);
        m32126a("onBannerClick", "c-act|").setOtherParam("url", str).build().info();
    }

    public void onBannerPageSelected(BannerRvModel bannerRvModel, int i) {
        HomeOmegaHelper.getInstance().itemExposureForBanner(bannerRvModel, i);
    }

    /* renamed from: a */
    private RecordTracker.Builder m32126a(String str, String str2) {
        return RecordTracker.Builder.create().setTag(f42977a).setLogModule("m-home|").setMessage(str).setLogCategory(str2);
    }
}
