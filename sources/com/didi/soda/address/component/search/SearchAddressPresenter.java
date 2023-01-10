package com.didi.soda.address.component.search;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.app.nova.skeleton.tools.Cancelable;
import com.didi.nova.assembly.serial.SerialTaskQueue;
import com.didi.soda.address.component.search.Contract;
import com.didi.soda.address.component.search.SearchAddressComponent;
import com.didi.soda.address.model.AddressSearchRvModel;
import com.didi.soda.address.omega.AddressOmegaHelper;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.SearchPoiEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.util.ClickUtils;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerHomeManager;
import com.didi.soda.router.DiRouter;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.List;

public class SearchAddressPresenter extends Contract.AbsSearchAddressPresenter {

    /* renamed from: a */
    private static final String f41393a = "SearchAddressPresenter";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f41394b;

    /* renamed from: c */
    private SerialTaskQueue f41395c = new SerialTaskQueue();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Cancelable f41396d;

    /* renamed from: e */
    private int f41397e;

    /* renamed from: f */
    private String f41398f;

    /* renamed from: g */
    private int f41399g = 0;

    public void onCreate() {
        super.onCreate();
        m31068a();
    }

    public void showOrHide(boolean z, SearchAddressComponent.OnSearchAnimationListener onSearchAnimationListener) {
        ((Contract.AbsSearchAddressView) getLogicView()).showOrHideContent(z, onSearchAnimationListener);
        if (!z) {
            clearDataManagers();
        }
    }

    /* access modifiers changed from: package-private */
    public void onSearchTextChange(String str) {
        this.f41394b = str;
        if (TextUtils.isEmpty(str)) {
            this.f41395c.clear();
            Cancelable cancelable = this.f41396d;
            if (cancelable != null) {
                cancelable.cancel();
            }
            clearDataManagers();
            ((Contract.AbsSearchAddressView) getLogicView()).searchEmptyText();
            ((Contract.AbsSearchAddressView) getLogicView()).showOrHideSearchLoading(false);
            ((Contract.AbsSearchAddressView) getLogicView()).showOrHideLoading(false);
            return;
        }
        m31072a(true);
    }

    /* access modifiers changed from: package-private */
    public void onRetryAction() {
        ((Contract.AbsSearchAddressView) getLogicView()).hideLoadError();
        m31072a(false);
    }

    /* access modifiers changed from: package-private */
    public void onAddressSelected(AddressSearchRvModel addressSearchRvModel, int i) {
        KeyboardUtils.hideSoftInput(getContext(), (View) null);
        if (!ClickUtils.isFastClick()) {
            m31070a(addressSearchRvModel.mAddress, i);
            if (m31073b()) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("entity", addressSearchRvModel.mAddress);
                getScopeContext().getNavigator().finish(bundle);
            } else if (!LoginUtil.isLogin()) {
                ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).refreshHomeByAddress(addressSearchRvModel.mAddress, 0);
                getScopeContext().getNavigator().finish();
            } else {
                DiRouter.request().path(RoutePath.ADDRESS_EDIT).putSerializable(Const.PageParams.ADDRESS_ENTITY, addressSearchRvModel.mAddress).putInt("from", 3).putBoolean(Const.PageParams.CHECK_STATUS, true).putBoolean(Const.PageParams.IS_FROM_BUSINESS, m31074c()).open();
            }
        }
    }

    /* renamed from: a */
    private void m31068a() {
        int i = getScopeContext().getBundle().getInt("from", -1);
        this.f41397e = i;
        if (i == 4) {
            AddressOmegaHelper.traceCartAddressPoiCk();
        }
    }

    /* renamed from: a */
    private void m31072a(boolean z) {
        if (z) {
            ((Contract.AbsSearchAddressView) getLogicView()).showOrHideSearchLoading(true);
        } else {
            ((Contract.AbsSearchAddressView) getLogicView()).showOrHideLoading(true);
        }
        this.f41396d = this.f41395c.append(new SearchAddressTask(new CustomerRpcCallback<SearchPoiEntity>() {
            public void onRpcFailure(SFRpcException sFRpcException) {
                super.onRpcFailure(sFRpcException);
                ((Contract.AbsSearchAddressView) SearchAddressPresenter.this.getLogicView()).showOrHideSearchLoading(false);
                ((Contract.AbsSearchAddressView) SearchAddressPresenter.this.getLogicView()).showOrHideLoading(false);
                ((Contract.AbsSearchAddressView) SearchAddressPresenter.this.getLogicView()).showLoadError(sFRpcException.getMessage());
                SearchAddressPresenter searchAddressPresenter = SearchAddressPresenter.this;
                searchAddressPresenter.m31071a((SearchPoiEntity) null, searchAddressPresenter.f41394b, false, String.valueOf(sFRpcException.getCode()), sFRpcException.getMessage());
                Cancelable unused = SearchAddressPresenter.this.f41396d = null;
            }

            public void onRpcSuccess(SearchPoiEntity searchPoiEntity, long j) {
                ((Contract.AbsSearchAddressView) SearchAddressPresenter.this.getLogicView()).showOrHideSearchLoading(false);
                ((Contract.AbsSearchAddressView) SearchAddressPresenter.this.getLogicView()).showOrHideLoading(false);
                ((Contract.AbsSearchAddressView) SearchAddressPresenter.this.getLogicView()).showLoadSuccess();
                List<AddressSearchRvModel> convertFromSearchPoiEntity = AddressSearchRvModel.convertFromSearchPoiEntity(searchPoiEntity.poiList);
                if (convertFromSearchPoiEntity.size() > 0) {
                    SearchAddressPresenter.this.clearDataManagers();
                    SearchAddressPresenter searchAddressPresenter = SearchAddressPresenter.this;
                    searchAddressPresenter.addDataManager(searchAddressPresenter.createChildDataListManager(convertFromSearchPoiEntity));
                } else {
                    ((Contract.AbsSearchAddressView) SearchAddressPresenter.this.getLogicView()).showLoadNoResult();
                }
                SearchAddressPresenter searchAddressPresenter2 = SearchAddressPresenter.this;
                searchAddressPresenter2.m31071a(searchPoiEntity, searchAddressPresenter2.f41394b, true, "", "");
                Cancelable unused = SearchAddressPresenter.this.f41396d = null;
            }
        }, this.f41394b), SerialTaskQueue.AppendMode.ReplaceStrict);
    }

    /* renamed from: b */
    private boolean m31073b() {
        int i = this.f41397e;
        return i == 4 || i == 9;
    }

    /* renamed from: c */
    private boolean m31074c() {
        return this.f41397e == 8;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31071a(SearchPoiEntity searchPoiEntity, String str, boolean z, String str2, String str3) {
        String str4;
        int i;
        if (searchPoiEntity != null) {
            this.f41398f = searchPoiEntity.recid;
            if (searchPoiEntity.poiList != null) {
                this.f41399g = searchPoiEntity.poiList.size();
                JsonArray jsonArray = new JsonArray();
                int i2 = 0;
                for (int i3 = 0; i3 < this.f41399g; i3++) {
                    AddressEntity.PoiEntity poiEntity = searchPoiEntity.poiList.get(i3);
                    if (!TextUtils.isEmpty(poiEntity.distStr)) {
                        i2 = 1;
                    }
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("index", (Number) Integer.valueOf(i3));
                    jsonObject.addProperty("poi_id", poiEntity.poiId);
                    jsonArray.add((JsonElement) jsonObject);
                }
                str4 = jsonArray.toString();
                i = i2;
                int i4 = CustomerSystemUtil.isGpsEnabled(getContext()) ? 1 : 0;
                AddressOmegaHelper.searchAddress(getScopeContext(), i4, str, this.f41399g, i, z, str2, str3, str4);
            }
        }
        str4 = "";
        i = 0;
        int i42 = CustomerSystemUtil.isGpsEnabled(getContext()) ? 1 : 0;
        AddressOmegaHelper.searchAddress(getScopeContext(), i42, str, this.f41399g, i, z, str2, str3, str4);
    }

    /* renamed from: a */
    private void m31070a(AddressEntity addressEntity, int i) {
        boolean isGpsEnabled = CustomerSystemUtil.isGpsEnabled(getContext());
        AddressOmegaHelper.trackSearchAddressClick(isGpsEnabled ? 1 : 0, this.f41394b, this.f41399g, i, addressEntity.poi);
    }
}
