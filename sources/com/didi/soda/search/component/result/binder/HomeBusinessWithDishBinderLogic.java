package com.didi.soda.search.component.result.binder;

import com.didi.soda.customer.base.binder.logic.EmptyLogicRepo;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.widget.search.SearchFoodItemView;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.didi.soda.search.component.result.binder.HomeBusinessWithDishBinder;
import com.didi.soda.search.helper.SearchNewOmegaHelper;

public class HomeBusinessWithDishBinderLogic extends HomeBusinessWithDishBinder.HomeBusinessDishItemBinderLogic {

    /* renamed from: a */
    private static final String f46310a = "HomeBusinessWithDishBinderLogic";

    public String getBusinessBiData(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        return "";
    }

    public Class<EmptyLogicRepo> bindLogicRepoType() {
        return EmptyLogicRepo.class;
    }

    public void onShopClick(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        onBusinessClick(homeBusinessInfoRvModel, 4);
        onOmegaBusinessCk(homeBusinessInfoRvModel, false);
    }

    public void onDishImageClick(HomeBusinessInfoRvModel homeBusinessInfoRvModel, SearchFoodItemView.SearchFoodItemModel searchFoodItemModel, int i) {
        String str;
        if (i == 3) {
            onBusinessClick(homeBusinessInfoRvModel, i);
        } else {
            if (i == 1) {
                str = searchFoodItemModel.buttonUrl;
            } else {
                str = searchFoodItemModel.url;
            }
            onGoodItemClick(homeBusinessInfoRvModel, searchFoodItemModel, i, str);
        }
        m34460a(homeBusinessInfoRvModel, searchFoodItemModel, i);
    }

    public void onDishItemShown(HomeBusinessInfoRvModel homeBusinessInfoRvModel, SearchFoodItemView.SearchFoodItemModel searchFoodItemModel, boolean z) {
        if (!z) {
            SearchNewOmegaHelper.getInstance().itemExposureForDish(homeBusinessInfoRvModel, searchFoodItemModel);
        }
    }

    public void onOmegaBusinessSw(HomeBusinessInfoRvModel homeBusinessInfoRvModel, boolean z) {
        SearchNewOmegaHelper.getInstance().itemExposure(homeBusinessInfoRvModel, false);
    }

    public void onOmegaBusinessCk(HomeBusinessInfoRvModel homeBusinessInfoRvModel, boolean z) {
        m34459a(homeBusinessInfoRvModel);
    }

    public void setOmegaGuideParam(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        SearchNewOmegaHelper.getInstance().setBusinessGuideParam(homeBusinessInfoRvModel);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0126  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onGoodItemClick(com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel r9, com.didi.soda.customer.widget.search.SearchFoodItemView.SearchFoodItemModel r10, int r11, java.lang.String r12) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = com.didi.soda.search.helper.SearchNewOmegaHelper.genBusinessBiData(r9, r10)
            r2 = 0
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0050 }
            r3.<init>()     // Catch:{ JSONException -> 0x0050 }
            java.lang.String r2 = "clickItemId"
            if (r10 != 0) goto L_0x0012
            r4 = r0
            goto L_0x0014
        L_0x0012:
            java.lang.String r4 = r10.goodsId     // Catch:{ JSONException -> 0x004e }
        L_0x0014:
            r3.put(r2, r4)     // Catch:{ JSONException -> 0x004e }
            java.lang.String r2 = "clickItemStatus"
            if (r10 != 0) goto L_0x001d
            r4 = r0
            goto L_0x0023
        L_0x001d:
            int r4 = r10.status     // Catch:{ JSONException -> 0x004e }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ JSONException -> 0x004e }
        L_0x0023:
            r3.put(r2, r4)     // Catch:{ JSONException -> 0x004e }
            java.lang.String r2 = "exactMatchType"
            int r4 = r9.mExactMatchType     // Catch:{ JSONException -> 0x004e }
            r3.put(r2, r4)     // Catch:{ JSONException -> 0x004e }
            java.lang.String r2 = "matchItemIds"
            java.lang.String r4 = r9.mMatchItemIds     // Catch:{ JSONException -> 0x004e }
            r3.put(r2, r4)     // Catch:{ JSONException -> 0x004e }
            java.lang.Class<com.didi.soda.search.repo.SearchWordRepo> r2 = com.didi.soda.search.repo.SearchWordRepo.class
            com.didi.app.nova.skeleton.repo.Repo r2 = com.didi.soda.customer.repo.RepoFactory.getRepo(r2)     // Catch:{ JSONException -> 0x004e }
            com.didi.soda.search.repo.SearchWordRepo r2 = (com.didi.soda.search.repo.SearchWordRepo) r2     // Catch:{ JSONException -> 0x004e }
            com.didi.soda.search.repo.SearchWordModel r2 = r2.getValue()     // Catch:{ JSONException -> 0x004e }
            if (r2 == 0) goto L_0x0057
            java.lang.String r4 = r2.mSearchTag     // Catch:{ JSONException -> 0x004e }
            if (r4 == 0) goto L_0x0057
            java.lang.String r4 = "searchWord"
            java.lang.String r2 = r2.mSearchTag     // Catch:{ JSONException -> 0x004e }
            r3.put(r4, r2)     // Catch:{ JSONException -> 0x004e }
            goto L_0x0057
        L_0x004e:
            r2 = move-exception
            goto L_0x0054
        L_0x0050:
            r3 = move-exception
            r7 = r3
            r3 = r2
            r2 = r7
        L_0x0054:
            r2.printStackTrace()
        L_0x0057:
            r2 = 1
            if (r11 != r2) goto L_0x005c
            r4 = 3
            goto L_0x005d
        L_0x005c:
            r4 = 2
        L_0x005d:
            com.didi.soda.customer.foundation.rpc.entity.ActionInfoEntity r5 = new com.didi.soda.customer.foundation.rpc.entity.ActionInfoEntity
            r5.<init>()
            if (r10 != 0) goto L_0x0066
            r6 = r0
            goto L_0x0068
        L_0x0066:
            java.lang.String r6 = r10.goodsId
        L_0x0068:
            r5.setItemId(r6)
            r5.setType(r4)
            com.didi.soda.customer.foundation.push.model.AnchorInfoModel r4 = new com.didi.soda.customer.foundation.push.model.AnchorInfoModel
            if (r10 != 0) goto L_0x0074
            r6 = r0
            goto L_0x0076
        L_0x0074:
            java.lang.String r6 = r10.goodsId
        L_0x0076:
            r4.<init>(r6, r2)
            com.didi.soda.business.BusinessOpen$Companion r2 = com.didi.soda.business.BusinessOpen.Companion
            java.lang.String r6 = r9.mShopId
            com.didi.soda.business.BusinessOpen r2 = r2.create(r6)
            com.didi.soda.customer.animation.transitions.name.BusinessTransitionNameSet r6 = r9.mTransitionNameSet
            com.didi.soda.business.BusinessOpen r2 = r2.transitionName(r6)
            int r6 = r9.mSource
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            com.didi.soda.business.BusinessOpen r2 = r2.businessAnimationSource(r6)
            com.didi.soda.business.BusinessOpen r2 = r2.biData(r1)
            if (r3 == 0) goto L_0x009c
            java.lang.String r6 = r3.toString()
            goto L_0x009d
        L_0x009c:
            r6 = r0
        L_0x009d:
            com.didi.soda.business.BusinessOpen r2 = r2.searchInfo(r6)
            java.lang.String r6 = com.didi.soda.customer.foundation.util.GsonUtil.toJson(r5)
            com.didi.soda.business.BusinessOpen r2 = r2.actionInfoDict(r6)
            java.lang.String r6 = com.didi.soda.customer.foundation.util.GsonUtil.toJson(r4)
            com.didi.soda.business.BusinessOpen r2 = r2.anchorInfo(r6)
            int r6 = r9.businessType
            com.didi.soda.business.BusinessOpen r2 = r2.businessType(r6)
            com.didi.soda.business.BusinessOpen r12 = r2.url(r12)
            r12.open()
            java.util.HashMap r12 = new java.util.HashMap
            r12.<init>()
            java.lang.String r2 = r9.mShopId
            java.lang.String r6 = "shopId"
            r12.put(r6, r2)
            java.lang.String r2 = r9.mShopName
            java.lang.String r6 = "shopName"
            r12.put(r6, r2)
            if (r10 != 0) goto L_0x00d5
            r10 = r0
            goto L_0x00d7
        L_0x00d5:
            java.lang.String r10 = r10.goodsId
        L_0x00d7:
            java.lang.String r2 = "itemId"
            r12.put(r2, r10)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r11)
            java.lang.String r11 = "clickType"
            r12.put(r11, r10)
            java.lang.String r10 = "biData"
            r12.put(r10, r1)
            if (r3 == 0) goto L_0x00f1
            java.lang.String r10 = r3.toString()
            goto L_0x00f2
        L_0x00f1:
            r10 = r0
        L_0x00f2:
            java.lang.String r11 = "searchInfo"
            r12.put(r11, r10)
            java.lang.String r10 = com.didi.soda.customer.foundation.util.GsonUtil.toJson(r5)
            java.lang.String r11 = "actionInfo"
            r12.put(r11, r10)
            java.lang.String r10 = com.didi.soda.customer.foundation.util.GsonUtil.toJson(r4)
            java.lang.String r11 = "anchorInfo"
            r12.put(r11, r10)
            com.didi.soda.customer.animation.transitions.name.BusinessTransitionNameSet r10 = r9.mTransitionNameSet
            if (r10 != 0) goto L_0x010f
            r10 = r0
            goto L_0x0111
        L_0x010f:
            com.didi.soda.customer.animation.transitions.name.BusinessTransitionNameSet r10 = r9.mTransitionNameSet
        L_0x0111:
            java.lang.String r11 = "transitionName"
            r12.put(r11, r10)
            int r10 = r9.businessType
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.String r11 = "businessType"
            r12.put(r11, r10)
            java.lang.String r10 = r9.url
            if (r10 != 0) goto L_0x0126
            goto L_0x0128
        L_0x0126:
            java.lang.String r0 = r9.url
        L_0x0128:
            java.lang.String r9 = "url"
            r12.put(r9, r0)
            java.lang.String r9 = "onGoodItemClick"
            java.lang.String r10 = "c-act|"
            com.didi.soda.search.helper.SearchLogHelper.setLogTracker(r9, r10, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.search.component.result.binder.HomeBusinessWithDishBinderLogic.onGoodItemClick(com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel, com.didi.soda.customer.widget.search.SearchFoodItemView$SearchFoodItemModel, int, java.lang.String):void");
    }

    public void onBusinessClick(HomeBusinessInfoRvModel homeBusinessInfoRvModel, int i) {
        onGoodItemClick(homeBusinessInfoRvModel, !CollectionsUtil.isEmpty(homeBusinessInfoRvModel.mFoodItems) ? homeBusinessInfoRvModel.mFoodItems.get(0) : null, 2, homeBusinessInfoRvModel.url);
    }

    /* renamed from: a */
    private void m34459a(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        SearchNewOmegaHelper.getInstance().setBusinessGuideParam(homeBusinessInfoRvModel);
        SearchNewOmegaHelper.getInstance().trackBusinessClick(homeBusinessInfoRvModel, (SearchFoodItemView.SearchFoodItemModel) null, false);
    }

    /* renamed from: a */
    private void m34460a(HomeBusinessInfoRvModel homeBusinessInfoRvModel, SearchFoodItemView.SearchFoodItemModel searchFoodItemModel, int i) {
        SearchNewOmegaHelper.getInstance().setGoodsGuideParam(homeBusinessInfoRvModel, searchFoodItemModel);
        SearchNewOmegaHelper.getInstance().trackGoodsClick(homeBusinessInfoRvModel, searchFoodItemModel, false, i);
    }
}
