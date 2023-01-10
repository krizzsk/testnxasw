package com.didi.soda.address.component.feed;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.didi.soda.address.component.feed.Contract;
import com.didi.soda.address.component.feed.binder.DeliveryAddressRvModel;
import com.didi.soda.address.manager.AddressMessageRepo;
import com.didi.soda.address.omega.AddressOmegaHelper;
import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.binder.abnormal.topgun.TopGunAbnormalRvModel;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressPageListEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.HomeAddressEntity;
import com.didi.soda.customer.foundation.tracker.performance.PageRenderingTrackerNew;
import com.didi.soda.customer.foundation.util.ClickUtils;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.LocalPermissionHelper;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.helper.CustomerLocationSettingHelper;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalFactory;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.didi.soda.manager.base.ICustomerHomeManager;
import com.didi.soda.router.DiRouter;
import com.taxis99.R;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* renamed from: com.didi.soda.address.component.feed.a */
/* compiled from: AddressFeedMessagePresenter */
class C14191a extends Contract.AbsAddressFeedMessagePresenter {

    /* renamed from: a */
    private static final String f41378a = "AddressFeedMessagePresenter";

    /* renamed from: b */
    private int f41379b;

    /* renamed from: c */
    private boolean f41380c;

    /* renamed from: d */
    private HomeAddressEntity f41381d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ChildDataListManager<RecyclerModel> f41382e;

    /* renamed from: f */
    private DeliveryAddressRvModel f41383f;

    /* renamed from: g */
    private DeliveryAddressRvModel f41384g;

    /* renamed from: h */
    private AddressFeedOmegaHelper f41385h;

    C14191a() {
    }

    public void onCreate() {
        super.onCreate();
        if (this.f41382e == null) {
            ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager();
            this.f41382e = createChildDataListManager;
            addDataManager(createChildDataListManager);
        }
        m31045b();
        AddressFeedOmegaHelper instance = AddressFeedOmegaHelper.getInstance();
        this.f41385h = instance;
        instance.attach(getScopeContext());
        m31033a();
        m31051c();
        this.f41385h.openAddressHomePage(this.f41379b, m31060l(), m31059k());
    }

    public void onResume() {
        if (!this.f41380c) {
            this.f41380c = true;
            return;
        }
        PageRenderingTrackerNew.Companion.trackExceptionUtil(getScopeContext());
        getAddressAllList();
        CustomerLocationSettingHelper.Companion.getInstance().updateWindowShownStatus(getContext(), 5, (Function2<? super Boolean, ? super Boolean, Unit>) null);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f41385h.detach(getScopeContext());
    }

    public void getAddressAllList() {
        m31055g();
    }

    public void goLogin() {
        LoginUtil.updateLoginPopToRootStatus(false);
        LoginUtil.loginActivityAndTrack(GlobalContext.getContext(), 10);
    }

    public void onAddressClick(AddressEntity addressEntity, int i, int i2) {
        if (AddressUtil.checkAddressValid(addressEntity)) {
            AddressFeedOmegaHelper addressFeedOmegaHelper = this.f41385h;
            String str = addressEntity.aid;
            String str2 = addressEntity.poi.poiId;
            String str3 = addressEntity.poi.poiType;
            boolean k = m31059k();
            ChildDataListManager<RecyclerModel> childDataListManager = this.f41382e;
            addressFeedOmegaHelper.trackActionOnAddress(i, str, str2, str3, k, i2, childDataListManager == null ? 0 : childDataListManager.size());
            if (m31052d()) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("entity", addressEntity);
                getScopeContext().getNavigator().finish(bundle);
                return;
            }
            ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).refreshHomeByAddress(addressEntity, m31054f() ? 9 : 1);
            getScopeContext().getNavigator().finish();
        }
    }

    public void onAddressDeleteClick(DeliveryAddressRvModel deliveryAddressRvModel, int i) {
        if (deliveryAddressRvModel != null && AddressUtil.checkAddressValid(deliveryAddressRvModel.mAddress)) {
            DialogUtil.showAddressDeleteDialog(getScopeContext().getNavigator(), new RFDialogInterface.OnClickListener(deliveryAddressRvModel, i) {
                public final /* synthetic */ DeliveryAddressRvModel f$1;
                public final /* synthetic */ int f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(RFDialog rFDialog) {
                    C14191a.this.m31039a(this.f$1, this.f$2, rFDialog);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m31039a(DeliveryAddressRvModel deliveryAddressRvModel, int i, RFDialog rFDialog) {
        if (AddressUtil.checkAddressEqualCurrent(deliveryAddressRvModel.mAddress)) {
            ((Contract.AbsAddressFeedMessageView) getLogicView()).showAddressUnableDeleteDialog();
        } else {
            m31038a(deliveryAddressRvModel, i);
        }
        rFDialog.dismiss();
    }

    public void onAddressEditClick(DeliveryAddressRvModel deliveryAddressRvModel, int i) {
        if (!LoginUtil.isLogin()) {
            goLogin();
        } else if (deliveryAddressRvModel == null || ClickUtils.isFastClick()) {
        } else {
            if (!m31052d() || !deliveryAddressRvModel.mIsChecked) {
                DiRouter.request().path(RoutePath.ADDRESS_EDIT).putSerializable(Const.PageParams.ADDRESS_ENTITY, deliveryAddressRvModel.mAddress).putInt("from", 0).putBoolean(Const.PageParams.CHECK_STATUS, deliveryAddressRvModel.mIsChecked).open();
                if (AddressUtil.checkAddressValid(deliveryAddressRvModel.mAddress)) {
                    AddressOmegaHelper.trackAddressEditCk(deliveryAddressRvModel.mAddress.poi.poiId, deliveryAddressRvModel.mAddress.aid, i);
                    return;
                }
                return;
            }
            int i2 = -1;
            ChildDataListManager<RecyclerModel> childDataListManager = this.f41382e;
            if (childDataListManager != null) {
                i2 = childDataListManager.indexOf(deliveryAddressRvModel);
            }
            onAddressClick(deliveryAddressRvModel.mAddress, deliveryAddressRvModel.addressType, i2);
        }
    }

    public void onOpenLocation() {
        CustomerLocationSettingHelper.Companion.getInstance().startLocationSettingRequest((Activity) GlobalContext.getContext(), 5, (CustomerLocationSettingHelper.ILocationSettingRequestCallback) null);
        this.f41385h.trackOpenGps(this.f41379b, true);
    }

    public void onRetryLocation() {
        AddressOmegaHelper.clickRefreshLocateAddress(this.f41383f.mAddress, this.f41379b);
        LocationUtil.getCurrentLocationOnce(new AddressFeedMessagePresenter$1(this));
    }

    public void onOpenLocationPermission() {
        LogUtil.m32588i(f41378a, "onOpenLocationPermission");
        LocalPermissionHelper.openPermissionSetting((Activity) GlobalContext.getContext());
        this.f41385h.trackOpenGps(this.f41379b, false);
    }

    /* renamed from: a */
    public void mo104792a(int i, String str) {
        DeliveryAddressRvModel deliveryAddressRvModel = this.f41383f;
        if (deliveryAddressRvModel == null || this.f41382e.indexOf(deliveryAddressRvModel) < 0) {
            m31057i();
            TopGunAbnormalRvModel topGunAbnormalRvModel = new TopGunAbnormalRvModel();
            topGunAbnormalRvModel.mHeight = -1;
            if (NetWorkUtils.isNetworkConnected(getContext())) {
                topGunAbnormalRvModel.setAbnormalVm(TopGunAbnormalFactory.buildHomeNoService(str, new View.OnClickListener() {
                    public final void onClick(View view) {
                        C14191a.this.m31046b(view);
                    }
                }));
            } else {
                topGunAbnormalRvModel.setAbnormalVm(TopGunAbnormalFactory.buildNoNetwork(new View.OnClickListener() {
                    public final void onClick(View view) {
                        C14191a.this.m31034a(view);
                    }
                }));
            }
            this.f41382e.add(topGunAbnormalRvModel);
        } else if (i == -1) {
            ToastUtil.showCustomerToast(getScopeContext(), ResourceHelper.getString(R.string.customer_get_data_failure));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m31046b(View view) {
        getAddressAllList();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m31034a(View view) {
        getAddressAllList();
    }

    /* renamed from: a */
    private void m31033a() {
        AddressPageListEntity addressPageListEntity;
        Bundle bundle = getScopeContext().getBundle();
        this.f41379b = bundle.getInt("from", -1);
        if (m31053e()) {
            addressPageListEntity = (AddressPageListEntity) bundle.getSerializable("entity");
            this.f41381d = addressPageListEntity.deliveryAddress;
        } else {
            this.f41381d = new HomeAddressEntity();
            if (m31052d()) {
                this.f41381d.address = (AddressEntity) bundle.getSerializable("entity");
            } else {
                this.f41381d.address = ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getDelieveryAddress();
            }
            addressPageListEntity = null;
        }
        if (addressPageListEntity != null) {
            PageRenderingTrackerNew.Companion.trackExceptionUtil(getScopeContext());
            m31040a(addressPageListEntity);
            return;
        }
        getAddressAllList();
    }

    /* renamed from: b */
    private void m31045b() {
        if (!m31059k() || !m31060l()) {
            DeliveryAddressRvModel buildLocationAddressRvModel = DeliveryAddressRvModel.buildLocationAddressRvModel((HomeAddressEntity) null, m31059k(), m31060l(), false, true);
            this.f41383f = buildLocationAddressRvModel;
            this.f41382e.add(buildLocationAddressRvModel);
        }
    }

    /* renamed from: c */
    private void m31051c() {
        ((AddressMessageRepo) RepoFactory.getRepo(AddressMessageRepo.class)).subscribeAddressDragStatus(getScopeContext(), new AddressFeedMessagePresenter$2(this));
    }

    /* renamed from: d */
    private boolean m31052d() {
        int i = this.f41379b;
        return i == 4 || i == 9;
    }

    /* renamed from: e */
    private boolean m31053e() {
        return this.f41379b == 5;
    }

    /* renamed from: f */
    private boolean m31054f() {
        return this.f41379b == 8;
    }

    /* renamed from: g */
    private void m31055g() {
        ((Contract.AbsAddressFeedMessageView) getLogicView()).showLoading();
        HomeAddressEntity homeAddressEntity = this.f41381d;
        boolean z = homeAddressEntity != null && AddressUtil.checkAddressValid(homeAddressEntity.address);
        CustomerRpcManagerProxy.get().getAddressAndHistoryList(z ? this.f41381d.address.poi : null, z ? this.f41381d.address.aid : "", new AddressFeedMessagePresenter$3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m31056h() {
        CustomerRpcManagerProxy.get().getAddressByLocation(new AddressFeedMessagePresenter$4(this));
    }

    /* renamed from: a */
    private void m31038a(DeliveryAddressRvModel deliveryAddressRvModel, int i) {
        if (deliveryAddressRvModel != null && deliveryAddressRvModel.mAddress != null) {
            AddressEntity addressEntity = deliveryAddressRvModel.mAddress;
            CustomerRpcManagerProxy.get().deleteAddress(TextUtils.isEmpty(addressEntity.aid) ? addressEntity.poi.poiId : addressEntity.aid, new AddressFeedMessagePresenter$5(this));
            int indexOf = this.f41382e.indexOf(deliveryAddressRvModel);
            if (indexOf >= 0 && indexOf < this.f41382e.size()) {
                this.f41382e.remove(indexOf);
            }
            if (AddressUtil.checkAddressValid(addressEntity)) {
                AddressOmegaHelper.trackAddressDeleteCk(addressEntity.poi.poiId, addressEntity.aid, i);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31040a(AddressPageListEntity addressPageListEntity) {
        String str;
        if (addressPageListEntity == null) {
            this.f41385h.resetAddressTrackerNum(this.f41379b, (String) null, (List<AddressEntity>) null);
            return;
        }
        boolean z = false;
        if (addressPageListEntity.deliveryAddress == null || !AddressUtil.checkAddressValid(addressPageListEntity.deliveryAddress.address)) {
            str = "";
        } else {
            str = addressPageListEntity.deliveryAddress.address.getAid();
            if (addressPageListEntity.locationAddress != null) {
                z = m31044a(addressPageListEntity.locationAddress.address, addressPageListEntity.deliveryAddress.address);
            }
        }
        m31057i();
        m31041a(addressPageListEntity, str);
        m31043a(addressPageListEntity.deliveryAddress, z);
        m31042a(z ? addressPageListEntity.deliveryAddress : addressPageListEntity.locationAddress);
        this.f41385h.resetAddressTrackerNum(this.f41379b, addressPageListEntity.recid, addressPageListEntity.historyAddressList);
        AddressOmegaHelper.trackRealexposureSw(addressPageListEntity);
    }

    /* renamed from: a */
    private void m31041a(AddressPageListEntity addressPageListEntity, String str) {
        List<DeliveryAddressRvModel> buildHistoryAddressRvModelList = DeliveryAddressRvModel.buildHistoryAddressRvModelList(addressPageListEntity.historyAddressList, str);
        if (!CollectionsUtil.isEmpty(buildHistoryAddressRvModelList)) {
            this.f41382e.addAll(buildHistoryAddressRvModelList);
        }
    }

    /* renamed from: a */
    private void m31043a(HomeAddressEntity homeAddressEntity, boolean z) {
        if (!z) {
            DeliveryAddressRvModel buildCurAddressRvModel = DeliveryAddressRvModel.buildCurAddressRvModel(homeAddressEntity, this.f41382e.size() == 0);
            this.f41384g = buildCurAddressRvModel;
            if (buildCurAddressRvModel != null) {
                this.f41382e.add(0, buildCurAddressRvModel);
                return;
            }
            return;
        }
        this.f41384g = null;
    }

    /* renamed from: a */
    private void m31042a(HomeAddressEntity homeAddressEntity) {
        AddressEntity addressEntity = null;
        AddressEntity addressEntity2 = homeAddressEntity != null ? homeAddressEntity.address : null;
        HomeAddressEntity homeAddressEntity2 = this.f41381d;
        if (homeAddressEntity2 != null) {
            addressEntity = homeAddressEntity2.address;
        }
        DeliveryAddressRvModel buildLocationAddressRvModel = DeliveryAddressRvModel.buildLocationAddressRvModel(homeAddressEntity, m31059k(), m31060l(), m31044a(addressEntity2, addressEntity), this.f41382e.size() == 0);
        this.f41383f = buildLocationAddressRvModel;
        this.f41382e.add(0, buildLocationAddressRvModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m31048b(HomeAddressEntity homeAddressEntity) {
        AddressEntity addressEntity = null;
        AddressEntity addressEntity2 = homeAddressEntity != null ? homeAddressEntity.address : null;
        boolean z = true;
        if (AddressUtil.checkAddressValid(addressEntity2)) {
            HomeAddressEntity homeAddressEntity2 = this.f41381d;
            if (homeAddressEntity2 != null) {
                addressEntity = homeAddressEntity2.address;
            }
            boolean a = m31044a(addressEntity2, addressEntity);
            HomeAddressEntity homeAddressEntity3 = new HomeAddressEntity();
            homeAddressEntity3.address = addressEntity;
            m31049b(homeAddressEntity3, a);
            if (this.f41382e.size() != 1) {
                z = false;
            }
            this.f41383f = DeliveryAddressRvModel.buildLocationAddressRvModel(homeAddressEntity, m31059k(), m31060l(), a, z);
        } else {
            if (this.f41382e.size() != 1) {
                z = false;
            }
            this.f41383f.setGpsEnable(m31059k(), m31060l(), z);
        }
        this.f41382e.set(0, this.f41383f);
    }

    /* renamed from: b */
    private void m31049b(HomeAddressEntity homeAddressEntity, boolean z) {
        if (z) {
            DeliveryAddressRvModel deliveryAddressRvModel = this.f41384g;
            if (deliveryAddressRvModel != null) {
                int indexOf = this.f41382e.indexOf(deliveryAddressRvModel);
                if (indexOf >= 0 && indexOf < this.f41382e.size()) {
                    this.f41382e.remove(indexOf);
                }
                this.f41384g = null;
            }
        } else if (this.f41384g == null) {
            DeliveryAddressRvModel buildCurAddressRvModel = DeliveryAddressRvModel.buildCurAddressRvModel(homeAddressEntity, this.f41382e.size() == 1);
            this.f41384g = buildCurAddressRvModel;
            if (buildCurAddressRvModel != null) {
                this.f41382e.add(1, buildCurAddressRvModel);
            }
        }
    }

    /* renamed from: i */
    private void m31057i() {
        this.f41382e.clear();
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m31058j() {
        DeliveryAddressRvModel deliveryAddressRvModel = this.f41383f;
        if (deliveryAddressRvModel != null && AddressUtil.checkAddressValid(deliveryAddressRvModel.mAddress)) {
            ToastUtil.showCustomerErrorToast(getScopeContext(), ResourceHelper.getString(R.string.customer_address_gps_no_location));
        }
    }

    /* renamed from: k */
    private boolean m31059k() {
        return CustomerSystemUtil.isGpsEnabled(getContext());
    }

    /* renamed from: l */
    private boolean m31060l() {
        return LocalPermissionHelper.checkoutPermission((Activity) GlobalContext.getContext(), LocalPermissionHelper.LOCATION_PERMISSIONS);
    }

    /* renamed from: a */
    private boolean m31044a(AddressEntity addressEntity, AddressEntity addressEntity2) {
        if (!AddressUtil.checkAddressValid(addressEntity) || !AddressUtil.checkAddressValid(addressEntity2)) {
            return false;
        }
        String str = addressEntity2.poi.poiId;
        if (!TextUtils.isEmpty(addressEntity2.getAid()) || !str.equals(addressEntity.poi.poiId) || !m31059k() || !m31060l()) {
            return false;
        }
        return true;
    }
}
