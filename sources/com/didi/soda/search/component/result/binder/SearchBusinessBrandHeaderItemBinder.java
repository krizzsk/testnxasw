package com.didi.soda.search.component.result.binder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.business.BusinessOpen;
import com.didi.soda.customer.animation.transitions.name.BusinessTransitionNameSet;
import com.didi.soda.customer.base.binder.logic.CustomerLogicItemBinder;
import com.didi.soda.customer.base.binder.logic.EmptyLogicRepo;
import com.didi.soda.customer.widget.search.SearchFoodItemView;
import com.didi.soda.home.topgun.binder.HomeBusinessItemBinder;
import com.didi.soda.home.topgun.binder.HomeBusinessItemBinderNewLogic;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.didi.soda.home.topgun.widget.brand.BusinessBrandHeaderView;
import com.didi.soda.search.helper.SearchLogHelper;
import com.didi.soda.search.helper.SearchNewOmegaHelper;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0002\u0016\u0017B\u0011\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0016J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016¨\u0006\u0018"}, mo148868d2 = {"Lcom/didi/soda/search/component/result/binder/SearchBusinessBrandHeaderItemBinder;", "Lcom/didi/soda/customer/base/binder/logic/CustomerLogicItemBinder;", "Lcom/didi/soda/home/topgun/binder/HomeBusinessItemBinderNewLogic;", "Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "Lcom/didi/soda/search/component/result/binder/SearchBusinessBrandHeaderItemBinder$ViewHolder;", "impl", "Lcom/didi/soda/home/topgun/binder/HomeBusinessItemBinder$HomeBusinessOmegaInterface;", "(Lcom/didi/soda/home/topgun/binder/HomeBusinessItemBinder$HomeBusinessOmegaInterface;)V", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "extraCanBindCondition", "", "onCreateBinderLogic", "HomeBusinessItemBinderLogicNewImpl", "ViewHolder", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SearchBusinessBrandHeaderItemBinder.kt */
public class SearchBusinessBrandHeaderItemBinder extends CustomerLogicItemBinder<HomeBusinessItemBinderNewLogic, HomeBusinessInfoRvModel, ViewHolder> {
    public Class<HomeBusinessInfoRvModel> bindDataType() {
        return HomeBusinessInfoRvModel.class;
    }

    public SearchBusinessBrandHeaderItemBinder(HomeBusinessItemBinder.HomeBusinessOmegaInterface homeBusinessOmegaInterface) {
        ((HomeBusinessItemBinderNewLogic) getBinderLogic()).setBusinessOmegaInterface(homeBusinessOmegaInterface);
    }

    public HomeBusinessItemBinderNewLogic onCreateBinderLogic() {
        return new HomeBusinessItemBinderLogicNewImpl();
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new ViewHolder(new BusinessBrandHeaderView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null));
    }

    public void bind(ViewHolder viewHolder, HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (homeBusinessInfoRvModel != null) {
            ((BusinessBrandHeaderView) viewHolder.itemView).bindData(homeBusinessInfoRvModel, (HomeBusinessItemBinderNewLogic) getBinderLogic());
            ((HomeBusinessItemBinderNewLogic) getBinderLogic()).onOmegaBusinessSw(homeBusinessInfoRvModel, false);
        }
    }

    public boolean extraCanBindCondition(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        return Intrinsics.areEqual((Object) homeBusinessInfoRvModel == null ? null : homeBusinessInfoRvModel.mComponentType, (Object) "2");
    }

    @Metadata(mo148867d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, mo148868d2 = {"Lcom/didi/soda/search/component/result/binder/SearchBusinessBrandHeaderItemBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: SearchBusinessBrandHeaderItemBinder.kt */
    public static final class ViewHolder extends ItemViewHolder<HomeBusinessInfoRvModel> {
        public ViewHolder(View view) {
            super(view);
        }
    }

    @Metadata(mo148867d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bJ\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo148868d2 = {"Lcom/didi/soda/search/component/result/binder/SearchBusinessBrandHeaderItemBinder$HomeBusinessItemBinderLogicNewImpl;", "Lcom/didi/soda/home/topgun/binder/HomeBusinessItemBinderNewLogic;", "()V", "mOmegaImpl", "Lcom/didi/soda/home/topgun/binder/HomeBusinessItemBinder$HomeBusinessOmegaInterface;", "bindLogicRepoType", "Ljava/lang/Class;", "Lcom/didi/soda/customer/base/binder/logic/EmptyLogicRepo;", "getBusinessBiData", "", "rvModel", "Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "onItemClick", "", "onOmegaBusinessCk", "isCompose", "", "onOmegaBusinessSw", "openBusinessHomePage", "setBusinessOmegaInterface", "impl", "setOmegaGuideParam", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: SearchBusinessBrandHeaderItemBinder.kt */
    public static final class HomeBusinessItemBinderLogicNewImpl extends HomeBusinessItemBinderNewLogic {
        private HomeBusinessItemBinder.HomeBusinessOmegaInterface mOmegaImpl;

        public Class<EmptyLogicRepo> bindLogicRepoType() {
            return EmptyLogicRepo.class;
        }

        public void onItemClick(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
            Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "rvModel");
            setOmegaGuideParam(homeBusinessInfoRvModel);
            onOmegaBusinessCk(homeBusinessInfoRvModel, false);
            openBusinessHomePage(homeBusinessInfoRvModel);
        }

        public void setBusinessOmegaInterface(HomeBusinessItemBinder.HomeBusinessOmegaInterface homeBusinessOmegaInterface) {
            this.mOmegaImpl = homeBusinessOmegaInterface;
        }

        public final void openBusinessHomePage(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
            Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "rvModel");
            BusinessOpen.Companion.create(homeBusinessInfoRvModel.mShopId).transitionName(homeBusinessInfoRvModel.mTransitionNameSet).businessAnimationSource(Integer.valueOf(homeBusinessInfoRvModel.mSource)).biData(SearchNewOmegaHelper.genBusinessBiData(homeBusinessInfoRvModel, (SearchFoodItemView.SearchFoodItemModel) null)).businessType(homeBusinessInfoRvModel.businessType).url(homeBusinessInfoRvModel.url).open();
            HashMap hashMap = new HashMap();
            Map map = hashMap;
            map.put("shopId", homeBusinessInfoRvModel.mShopId);
            map.put("shopName", homeBusinessInfoRvModel.mShopName);
            BusinessTransitionNameSet businessTransitionNameSet = homeBusinessInfoRvModel.mTransitionNameSet;
            String str = "";
            map.put("transitionName", businessTransitionNameSet == null ? str : businessTransitionNameSet);
            map.put(ParamKeys.PARAM_FLIER_BUSINESSTYPE, Integer.valueOf(homeBusinessInfoRvModel.businessType));
            String str2 = homeBusinessInfoRvModel.url;
            if (str2 != null) {
                str = str2;
            }
            map.put("url", str);
            SearchLogHelper.setLogTracker("SearchBusinessBrandHeaderItemBinder", "c-act|", hashMap);
        }

        public void onOmegaBusinessSw(HomeBusinessInfoRvModel homeBusinessInfoRvModel, boolean z) {
            HomeBusinessItemBinder.HomeBusinessOmegaInterface homeBusinessOmegaInterface = this.mOmegaImpl;
            if (homeBusinessOmegaInterface != null) {
                homeBusinessOmegaInterface.onOmegaBusinessSw(homeBusinessInfoRvModel, z);
            }
        }

        public void onOmegaBusinessCk(HomeBusinessInfoRvModel homeBusinessInfoRvModel, boolean z) {
            HomeBusinessItemBinder.HomeBusinessOmegaInterface homeBusinessOmegaInterface = this.mOmegaImpl;
            if (homeBusinessOmegaInterface != null) {
                homeBusinessOmegaInterface.onOmegaBusinessCk(homeBusinessInfoRvModel, z);
            }
        }

        public void setOmegaGuideParam(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
            HomeBusinessItemBinder.HomeBusinessOmegaInterface homeBusinessOmegaInterface = this.mOmegaImpl;
            if (homeBusinessOmegaInterface != null) {
                homeBusinessOmegaInterface.setOmegaGuideParam(homeBusinessInfoRvModel);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
            r3 = r0.getBusinessBiData(r3);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String getBusinessBiData(com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel r3) {
            /*
                r2 = this;
                com.didi.soda.home.topgun.binder.HomeBusinessItemBinder$HomeBusinessOmegaInterface r0 = r2.mOmegaImpl
                java.lang.String r1 = ""
                if (r0 != 0) goto L_0x0007
                goto L_0x000f
            L_0x0007:
                java.lang.String r3 = r0.getBusinessBiData(r3)
                if (r3 != 0) goto L_0x000e
                goto L_0x000f
            L_0x000e:
                r1 = r3
            L_0x000f:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.search.component.result.binder.SearchBusinessBrandHeaderItemBinder.HomeBusinessItemBinderLogicNewImpl.getBusinessBiData(com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel):java.lang.String");
        }
    }
}
