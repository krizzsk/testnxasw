package com.didi.entrega.address.list.component.feed.core;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.common.map.model.LatLng;
import com.didi.entrega.address.data.entity.AddressCheckEntity;
import com.didi.entrega.address.list.component.feed.core.Contract;
import com.didi.entrega.address.list.component.feed.model.AddressListSplitRvModel;
import com.didi.entrega.address.list.component.feed.model.AddressListTitleRvModel;
import com.didi.entrega.address.list.component.feed.model.AddressPageListEntity;
import com.didi.entrega.address.list.component.feed.model.DeliveryAddressRvModel;
import com.didi.entrega.address.utils.AddressUtil;
import com.didi.entrega.address.utils.omega.AddressOmegaHelper;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.customer.foundation.util.ClickUtils;
import com.didi.entrega.customer.foundation.util.CollectionsUtil;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.foundation.util.DialogUtil;
import com.didi.entrega.customer.foundation.util.LocalPermissionHelper;
import com.didi.entrega.customer.foundation.util.LocationUtil;
import com.didi.entrega.customer.foundation.util.NetWorkUtils;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.foundation.util.ToastUtil;
import com.didi.entrega.customer.widget.abnormal.AbnormalRvModel;
import com.didi.entrega.customer.widget.abnormal.AbnormalViewModelFactory;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerContactManager;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.taxis99.R;
import java.util.List;

public class AddressFeedMessagePresenter extends Contract.AbsAddressFeedMessagePresenter {

    /* renamed from: a */
    private static final String f21287a = "AddressFeedMessagePresenter";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f21288b;

    /* renamed from: c */
    private boolean f21289c;

    /* renamed from: d */
    private int f21290d;

    /* renamed from: e */
    private int f21291e;

    /* renamed from: f */
    private ChildDataListManager<RecyclerModel> f21292f;

    /* renamed from: g */
    private DeliveryAddressRvModel f21293g;

    /* renamed from: h */
    private int f21294h = 0;

    /* renamed from: i */
    private AddressListTitleRvModel f21295i;

    /* renamed from: j */
    private AddressListSplitRvModel f21296j;

    public void onCreate() {
        super.onCreate();
        if (this.f21292f == null) {
            ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager();
            this.f21292f = createChildDataListManager;
            addDataManager(createChildDataListManager);
        }
        m17981c();
        m17975b();
    }

    public void onResume() {
        if (!this.f21289c) {
            this.f21289c = true;
        } else {
            m17966a();
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void getAddressAllList() {
        m17984d();
    }

    /* renamed from: a */
    private void m17966a() {
        boolean i = m17989i();
        boolean hasValidLocation = LocationUtil.hasValidLocation();
        LogUtil.m18185i(f21287a, "refreshLocation---- hasValidLocation=" + hasValidLocation + "----locationPermission=" + i + "---size=" + this.f21294h);
        if (i && hasValidLocation) {
            onRetryLocation();
        } else if (this.f21294h == 0) {
            m17985e();
        }
    }

    public void onAddressClick(DeliveryAddressRvModel deliveryAddressRvModel) {
        if (!ClickUtils.isFastClick()) {
            ChildDataListManager<RecyclerModel> childDataListManager = this.f21292f;
            if (childDataListManager == null || deliveryAddressRvModel == null) {
                LogUtil.m18185i(f21287a, " mAddressListManager is " + this.f21292f + " deliveryAddressRvModel is " + deliveryAddressRvModel);
                return;
            }
            AddressOmegaHelper.INSTANCE.trackDeliverySearchResultCk("", this.f21294h, childDataListManager.indexOf(deliveryAddressRvModel), deliveryAddressRvModel.addressType, this.f21288b);
            m17973a(deliveryAddressRvModel.mAddress);
        }
    }

    /* renamed from: a */
    private void m17973a(AddressEntity addressEntity) {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        final AddressEntity addressEntity2 = addressEntity;
        if (AddressUtil.checkAddressValid(addressEntity)) {
            ((Contract.AbsAddressFeedMessageView) getLogicView()).showLoading();
            double d6 = 0.0d;
            if (AddressUtil.isSenderAddressSelected(this.f21288b)) {
                double d7 = addressEntity2.poi.lat;
                double d8 = addressEntity2.poi.lng;
                AddressEntity receiveContact = ((ICustomerContactManager) CustomerManagerLoader.loadManager(ICustomerContactManager.class)).getReceiveContact();
                if (AddressUtil.checkAddressValid(receiveContact)) {
                    d6 = receiveContact.poi.lat;
                    d4 = receiveContact.poi.lng;
                } else {
                    d4 = 0.0d;
                }
                d = d6;
                d3 = d7;
                d2 = d8;
            } else {
                AddressEntity sendContact = ((ICustomerContactManager) CustomerManagerLoader.loadManager(ICustomerContactManager.class)).getSendContact();
                if (AddressUtil.checkAddressValid(sendContact)) {
                    d6 = sendContact.poi.lat;
                    d5 = sendContact.poi.lng;
                } else {
                    d5 = 0.0d;
                }
                double d9 = addressEntity2.poi.lat;
                d4 = addressEntity2.poi.lng;
                d3 = d6;
                d2 = d5;
                d = d9;
            }
            CustomerRpcManagerProxy.get().checkAddress(d3, d2, d, d4, 2, this.f21288b, new CustomerRpcCallback<AddressCheckEntity>() {
                public void onRpcSuccess(AddressCheckEntity addressCheckEntity, long j) {
                    ((Contract.AbsAddressFeedMessageView) AddressFeedMessagePresenter.this.getLogicView()).hideLoading();
                    if (addressCheckEntity == null) {
                        return;
                    }
                    if (addressCheckEntity.legal) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("entity", addressEntity2);
                        AddressFeedMessagePresenter.this.getScopeContext().getNavigator().finish(bundle);
                    } else if (!TextUtils.isEmpty(addressCheckEntity.content)) {
                        ToastUtil.showCustomerToast(AddressFeedMessagePresenter.this.getScopeContext(), addressCheckEntity.content);
                        AddressOmegaHelper.INSTANCE.trackDeliverySearchResultToastSw("", addressCheckEntity.toastType, AddressFeedMessagePresenter.this.f21288b);
                    }
                }

                public void onRpcFailure(SFRpcException sFRpcException) {
                    super.onRpcFailure(sFRpcException);
                    ((Contract.AbsAddressFeedMessageView) AddressFeedMessagePresenter.this.getLogicView()).hideLoading();
                    ToastUtil.showCustomerToast(AddressFeedMessagePresenter.this.getScopeContext(), ResourceHelper.getString(R.string.FoodC_orderlist3_Check_the_uDiY));
                }
            });
            return;
        }
        ToastUtil.showCustomerToast(getScopeContext(), ResourceHelper.getString(R.string.FoodC_search_Address_error_jdye));
    }

    public void onOpenLocation() {
        CustomerSystemUtil.openLocationSettingActivity(getContext());
    }

    public void onRetryLocation() {
        LocationUtil.getCurrentLocationOnce(new LocationUtil.LocationCallback() {
            public void onLocationError() {
                LogUtil.m18185i(AddressFeedMessagePresenter.f21287a, "onLocationError");
                AddressFeedMessagePresenter.this.m17985e();
                AddressFeedMessagePresenter.this.m17987g();
            }

            public void onLocationSuccess(LatLng latLng) {
                LogUtil.m18185i(AddressFeedMessagePresenter.f21287a, "onLocationSuccess");
                AddressFeedMessagePresenter.this.getAddressAllList();
            }
        });
    }

    public void onOpenLocationPermission() {
        LogUtil.m18185i(f21287a, "onOpenLocationPermission");
        LocalPermissionHelper.openPermissionSetting((Activity) GlobalContext.getContext());
    }

    public void showErrorView(int i, String str) {
        DeliveryAddressRvModel deliveryAddressRvModel = this.f21293g;
        if (deliveryAddressRvModel == null || this.f21292f.indexOf(deliveryAddressRvModel) < 0) {
            m17986f();
            AbnormalRvModel abnormalRvModel = new AbnormalRvModel();
            abnormalRvModel.mHeight = -1;
            if (NetWorkUtils.isNetworkConnected(getContext())) {
                abnormalRvModel.setAbnormalVm(AbnormalViewModelFactory.buildNoService(str, new View.OnClickListener() {
                    public final void onClick(View view) {
                        AddressFeedMessagePresenter.this.m17976b(view);
                    }
                }));
            } else {
                abnormalRvModel.setAbnormalVm(AbnormalViewModelFactory.buildNoNetwork(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AddressFeedMessagePresenter.this.m17967a(view);
                    }
                }));
            }
            this.f21292f.add(abnormalRvModel);
            return;
        }
        if (i == -1) {
            ToastUtil.showCustomerToast(getScopeContext(), ResourceHelper.getString(R.string.FoodC_remind_Unable_to_Wjlz));
        }
        m17985e();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m17976b(View view) {
        getAddressAllList();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m17967a(View view) {
        getAddressAllList();
    }

    /* renamed from: b */
    private void m17975b() {
        this.f21288b = getScopeContext().getBundle().getInt("from", -1);
    }

    /* renamed from: c */
    private void m17981c() {
        boolean i = m17989i();
        boolean hasValidLocation = LocationUtil.hasValidLocation();
        LogUtil.m18185i(f21287a, "initLocationData---- hasValidLocation=" + hasValidLocation + "----locationPermission=" + i);
        if (!i || !hasValidLocation) {
            DeliveryAddressRvModel buildLocationAddressRvModel = DeliveryAddressRvModel.buildLocationAddressRvModel((AddressEntity) null, m17988h(), m17989i(), false, true);
            this.f21293g = buildLocationAddressRvModel;
            this.f21292f.add(buildLocationAddressRvModel);
            return;
        }
        getAddressAllList();
    }

    /* renamed from: d */
    private void m17984d() {
        ((Contract.AbsAddressFeedMessageView) getLogicView()).showLoading();
        CustomerRpcManagerProxy.get().getAddressList(new CustomerRpcCallback<AddressPageListEntity>() {
            public void onRpcFailure(SFRpcException sFRpcException) {
                super.onRpcFailure(sFRpcException);
                ((Contract.AbsAddressFeedMessageView) AddressFeedMessagePresenter.this.getLogicView()).hideLoading();
                AddressFeedMessagePresenter.this.showErrorView(sFRpcException.getCode(), sFRpcException.getMessage());
            }

            public void onRpcSuccess(AddressPageListEntity addressPageListEntity, long j) {
                ((Contract.AbsAddressFeedMessageView) AddressFeedMessagePresenter.this.getLogicView()).hideLoading();
                AddressFeedMessagePresenter.this.m17970a(addressPageListEntity);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17970a(AddressPageListEntity addressPageListEntity) {
        if (addressPageListEntity != null) {
            m17986f();
            if (AddressUtil.checkAddressValid(addressPageListEntity.locationAddress)) {
                m17978b(addressPageListEntity);
            } else {
                m17980b(addressPageListEntity.locationAddress);
            }
        }
    }

    /* renamed from: b */
    private void m17978b(AddressPageListEntity addressPageListEntity) {
        if (addressPageListEntity != null) {
            if (!CollectionsUtil.isEmpty(addressPageListEntity.nearbyAddress) || !CollectionsUtil.isEmpty(addressPageListEntity.addressList) || !CollectionsUtil.isEmpty(addressPageListEntity.sodaAddressList)) {
                ((Contract.AbsAddressFeedMessageView) getLogicView()).showLoadSuccess();
                m17983c(addressPageListEntity);
            } else {
                ((Contract.AbsAddressFeedMessageView) getLogicView()).showEmptyNearbyResult();
            }
            AddressOmegaHelper.INSTANCE.trackDeliverySearchExposureSw(this.f21288b, !CollectionsUtil.isEmpty(addressPageListEntity.nearbyAddress), this.f21290d, this.f21291e);
            AddressOmegaHelper.INSTANCE.trackDeliverySearchResultSw("", this.f21294h);
        }
    }

    /* renamed from: c */
    private void m17983c(AddressPageListEntity addressPageListEntity) {
        int i = 0;
        List<DeliveryAddressRvModel> buildAddressRvModelList = DeliveryAddressRvModel.buildAddressRvModelList(addressPageListEntity.nearbyAddress, 0);
        if (!CollectionsUtil.isEmpty(buildAddressRvModelList)) {
            AddressListTitleRvModel addressListTitleRvModel = new AddressListTitleRvModel();
            addressListTitleRvModel.title = ResourceHelper.getString(R.string.FoodC_search_Near_address_rIJX);
            addressListTitleRvModel.isFirst = true;
            this.f21292f.add(addressListTitleRvModel);
            this.f21292f.addAll(buildAddressRvModelList);
            i = buildAddressRvModelList.size();
        }
        List<DeliveryAddressRvModel> buildAddressRvModelList2 = DeliveryAddressRvModel.buildAddressRvModelList(addressPageListEntity.addressList, 3);
        List<DeliveryAddressRvModel> buildAddressRvModelList3 = DeliveryAddressRvModel.buildAddressRvModelList(addressPageListEntity.sodaAddressList, 2);
        if (!CollectionsUtil.isEmpty(buildAddressRvModelList2) || !CollectionsUtil.isEmpty(buildAddressRvModelList3)) {
            AddressListTitleRvModel addressListTitleRvModel2 = new AddressListTitleRvModel();
            this.f21295i = addressListTitleRvModel2;
            addressListTitleRvModel2.title = ResourceHelper.getString(R.string.FoodC_info_List_of_QGFT);
            this.f21292f.add(this.f21295i);
        }
        if (!CollectionsUtil.isEmpty(buildAddressRvModelList2)) {
            this.f21292f.addAll(buildAddressRvModelList2);
            this.f21291e = buildAddressRvModelList2.size();
        }
        if (!CollectionsUtil.isEmpty(buildAddressRvModelList3)) {
            AddressListSplitRvModel addressListSplitRvModel = new AddressListSplitRvModel();
            this.f21296j = addressListSplitRvModel;
            this.f21292f.add(addressListSplitRvModel);
            this.f21292f.addAll(buildAddressRvModelList3);
            this.f21290d = buildAddressRvModelList3.size();
        }
        this.f21294h = i + this.f21290d + this.f21291e;
    }

    /* renamed from: b */
    private void m17980b(AddressEntity addressEntity) {
        DeliveryAddressRvModel buildLocationAddressRvModel = DeliveryAddressRvModel.buildLocationAddressRvModel(addressEntity, m17988h(), m17989i(), false, this.f21292f.size() == 0);
        this.f21293g = buildLocationAddressRvModel;
        this.f21292f.add(0, buildLocationAddressRvModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m17985e() {
        boolean z = true;
        if (this.f21292f.size() != 1) {
            z = false;
        }
        DeliveryAddressRvModel deliveryAddressRvModel = this.f21293g;
        if (deliveryAddressRvModel != null) {
            deliveryAddressRvModel.setGpsEnable(m17988h(), m17989i(), z);
            this.f21292f.set(0, this.f21293g);
        }
    }

    /* renamed from: f */
    private void m17986f() {
        this.f21292f.clear();
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m17987g() {
        DeliveryAddressRvModel deliveryAddressRvModel = this.f21293g;
        if (deliveryAddressRvModel != null && AddressUtil.checkAddressValid(deliveryAddressRvModel.mAddress)) {
            ToastUtil.showCustomerErrorToast(getScopeContext(), ResourceHelper.getString(R.string.FoodC_search_Unable_to_UwcS));
        }
    }

    /* renamed from: h */
    private boolean m17988h() {
        return CustomerSystemUtil.isGpsEnabled(getContext());
    }

    /* renamed from: i */
    private boolean m17989i() {
        return LocalPermissionHelper.checkoutPermission((Activity) GlobalContext.getContext(), LocalPermissionHelper.LOCATION_PERMISSIONS);
    }

    public void onAddressDeleteClick(DeliveryAddressRvModel deliveryAddressRvModel) {
        DialogUtil.showWarningDialog(ResourceHelper.getString(R.string.FoodC_info_Delete_Records_IzwE), ResourceHelper.getString(R.string.FoodC_info_Confirm_deletion_JaYz), R.string.FoodC_up_Cancel_anHR, R.string.FoodC_up_Confirmation_hKaf, getScopeContext(), C8569xf6e56995.INSTANCE, new RFDialogInterface.OnClickListener(deliveryAddressRvModel) {
            public final /* synthetic */ DeliveryAddressRvModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(RFDialog rFDialog) {
                AddressFeedMessagePresenter.this.m17972a(this.f$1, rFDialog);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m17974a(RFDialog rFDialog) {
        if (rFDialog != null) {
            rFDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m17972a(DeliveryAddressRvModel deliveryAddressRvModel, RFDialog rFDialog) {
        if (rFDialog != null) {
            rFDialog.dismiss();
        }
        m17971a(deliveryAddressRvModel);
    }

    /* renamed from: a */
    private void m17971a(final DeliveryAddressRvModel deliveryAddressRvModel) {
        if (deliveryAddressRvModel.mAddress != null && !TextUtils.isEmpty(deliveryAddressRvModel.mAddress.aid)) {
            ((Contract.AbsAddressFeedMessageView) getLogicView()).showLoading();
            CustomerRpcManagerProxy.get().deleteContact(deliveryAddressRvModel.mAddress.aid, new CustomerRpcCallback<Object>() {
                public void onRpcSuccess(Object obj, long j) {
                    ((Contract.AbsAddressFeedMessageView) AddressFeedMessagePresenter.this.getLogicView()).hideLoading();
                    AddressFeedMessagePresenter.this.m17979b(deliveryAddressRvModel);
                }

                public void onRpcFailure(SFRpcException sFRpcException) {
                    super.onRpcFailure(sFRpcException);
                    ((Contract.AbsAddressFeedMessageView) AddressFeedMessagePresenter.this.getLogicView()).hideLoading();
                    String string = ResourceHelper.getString(R.string.FoodC_info_Unable_to_tlve);
                    if (sFRpcException != null && !TextUtils.isEmpty(sFRpcException.getMessage())) {
                        string = sFRpcException.getMessage();
                    }
                    ToastUtil.showCustomerErrorToast(AddressFeedMessagePresenter.this.getScopeContext(), string);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17979b(DeliveryAddressRvModel deliveryAddressRvModel) {
        AddressListSplitRvModel addressListSplitRvModel;
        this.f21292f.remove(this.f21292f.indexOf(deliveryAddressRvModel));
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < this.f21292f.size(); i++) {
            RecyclerModel recyclerModel = this.f21292f.get(i);
            if (recyclerModel instanceof DeliveryAddressRvModel) {
                int i2 = ((DeliveryAddressRvModel) recyclerModel).addressType;
                if (i2 == 3) {
                    z = true;
                } else if (i2 == 2) {
                    z2 = true;
                }
            }
        }
        if (!z && !z2) {
            AddressListTitleRvModel addressListTitleRvModel = this.f21295i;
            if (addressListTitleRvModel != null) {
                this.f21292f.remove(this.f21292f.indexOf(addressListTitleRvModel));
            }
            AddressListSplitRvModel addressListSplitRvModel2 = this.f21296j;
            if (addressListSplitRvModel2 != null) {
                this.f21292f.remove(this.f21292f.indexOf(addressListSplitRvModel2));
            }
        }
        if (!z && z2 && (addressListSplitRvModel = this.f21296j) != null) {
            this.f21292f.remove(this.f21292f.indexOf(addressListSplitRvModel));
        }
    }
}
