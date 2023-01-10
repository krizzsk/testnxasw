package com.didi.soda.home.component.city;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.soda.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.soda.customer.binder.abnormal.topgun.TopGunAbnormalRvModel;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeServiceCityEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeServiceCountryEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeServiceCountryListEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalFactory;
import com.didi.soda.home.component.city.model.HomeCityItemRvModel;
import com.didi.soda.home.component.city.model.HomeCityTitleRvModel;
import com.didi.soda.home.manager.HomeSimpleOmegaHelper;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerHomeManager;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class HomeCityListPresenter extends CustomerRecyclerPresenter<HomeCityListView> {

    /* renamed from: a */
    private static final String f45054a = "HomeCityListPresenter";

    /* renamed from: b */
    private String f45055b;

    /* renamed from: c */
    private int f45056c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ChildDataListManager<RecyclerModel> f45057d;

    public void reverseLocation(HomeCityItemRvModel homeCityItemRvModel) {
        HomeSimpleOmegaHelper.trackHomeCityListCK(this.f45056c);
        ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).refreshHomeByCityInfo(homeCityItemRvModel.mLat, homeCityItemRvModel.mLng, homeCityItemRvModel.mCityId);
        getScopeContext().getNavigator().popToRoot();
    }

    public void initDataManagers() {
        super.initDataManagers();
        if (this.f45057d == null) {
            ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager();
            this.f45057d = createChildDataListManager;
            addDataManager(createChildDataListManager);
        }
    }

    public void onCreate() {
        super.onCreate();
        m33421a();
        m33425b();
        ((HomeCityListView) getLogicView()).setTitle(this.f45055b);
        HomeSimpleOmegaHelper.trackHomeCityListSW(this.f45056c);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    /* renamed from: a */
    private void m33421a() {
        Bundle bundle = getScopeContext().getBundle();
        this.f45055b = bundle.getString("param_title");
        this.f45056c = bundle.getInt("param_error_code", 0);
    }

    /* renamed from: b */
    private void m33425b() {
        ((HomeCityListView) getLogicView()).showLoadingView();
        CustomerRpcManagerProxy.get().getServiceCityList(new CustomerRpcCallback<HomeServiceCountryListEntity>() {
            public void onRpcSuccess(HomeServiceCountryListEntity homeServiceCountryListEntity, long j) {
                ((HomeCityListView) HomeCityListPresenter.this.getLogicView()).dismissLoadingDialog();
                List a = HomeCityListPresenter.this.m33419a(homeServiceCountryListEntity);
                if (CollectionsUtil.isEmpty(a)) {
                    HomeCityListPresenter.this.m33424a(ResourceHelper.getString(R.string.customer_get_data_failure));
                    return;
                }
                HomeCityListPresenter.this.f45057d.clear();
                HomeCityListPresenter.this.f45057d.addAll(a);
            }

            public void onRpcFailure(SFRpcException sFRpcException) {
                ((HomeCityListView) HomeCityListPresenter.this.getLogicView()).dismissLoadingDialog();
                String string = HomeCityListPresenter.this.getContext().getResources().getString(R.string.customer_service_not_connected);
                if (sFRpcException != null && !TextUtils.isEmpty(sFRpcException.getMessage())) {
                    string = sFRpcException.getMessage();
                }
                HomeCityListPresenter.this.m33424a(string);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33424a(String str) {
        if (NetWorkUtils.isNetworkConnected(getContext())) {
            TopGunAbnormalRvModel topGunAbnormalRvModel = new TopGunAbnormalRvModel();
            topGunAbnormalRvModel.mHeight = -1;
            topGunAbnormalRvModel.setAbnormalVm(TopGunAbnormalFactory.buildHomeNoService(str, new View.OnClickListener() {
                public final void onClick(View view) {
                    HomeCityListPresenter.this.m33426b(view);
                }
            }));
            this.f45057d.clear();
            this.f45057d.add(topGunAbnormalRvModel);
            return;
        }
        TopGunAbnormalRvModel topGunAbnormalRvModel2 = new TopGunAbnormalRvModel();
        topGunAbnormalRvModel2.mHeight = -1;
        topGunAbnormalRvModel2.setAbnormalVm(TopGunAbnormalFactory.buildNoNetwork(new View.OnClickListener() {
            public final void onClick(View view) {
                HomeCityListPresenter.this.m33422a(view);
            }
        }));
        this.f45057d.clear();
        this.f45057d.add(topGunAbnormalRvModel2);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m33426b(View view) {
        m33425b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33422a(View view) {
        m33425b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public List<RecyclerModel> m33419a(HomeServiceCountryListEntity homeServiceCountryListEntity) {
        ArrayList arrayList = new ArrayList();
        if (homeServiceCountryListEntity != null && !CollectionsUtil.isEmpty(homeServiceCountryListEntity.countryList)) {
            int size = homeServiceCountryListEntity.countryList.size();
            int i = 0;
            for (HomeServiceCountryEntity next : homeServiceCountryListEntity.countryList) {
                if (next != null && !CollectionsUtil.isEmpty(next.cities)) {
                    arrayList.add(new HomeCityTitleRvModel(next.countryName));
                    int size2 = next.cities.size();
                    int i2 = 0;
                    for (HomeServiceCityEntity homeCityItemRvModel : next.cities) {
                        arrayList.add(new HomeCityItemRvModel(homeCityItemRvModel, true ^ (i2 == size2 + -1 && i != size + -1)));
                        i2++;
                    }
                    i++;
                }
            }
        }
        return arrayList;
    }
}
