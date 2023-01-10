package com.didi.soda.address.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.util.Log;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action;
import com.didi.app.nova.skeleton.repo.Action2;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.AccountErrorConsumer;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.didi.soda.manager.base.ICustomerHomeManager;
import java.lang.ref.WeakReference;

public class CustomerAddressManager implements ICustomerAddressManager {

    /* renamed from: a */
    private static final String f41498a = "CustomerAddressManager";

    /* renamed from: b */
    private GpsStatusReceiver f41499b;

    /* renamed from: c */
    private AccountErrorConsumer f41500c;

    public String getManagerName() {
        return f41498a;
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public AddressEntity getCacheAddress() {
        return ((AddressStorage) SingletonFactory.get(AddressStorage.class)).getData();
    }

    public void setDeliveryAddress(AddressEntity addressEntity, boolean z, int i) {
        if (z) {
            AddressStateRepo addressStateRepo = (AddressStateRepo) RepoFactory.getRepo(AddressStateRepo.class);
            addressStateRepo.setValue(addressEntity);
            addressStateRepo.mo105124a(addressEntity.aid);
            addressStateRepo.mo105121a(i);
            ((C14211b) RepoFactory.getRepo(C14211b.class)).setValue(null);
            return;
        }
        ((AddressStateRepo) RepoFactory.getRepo(AddressStateRepo.class)).mo105126b(addressEntity);
    }

    public AddressEntity getDelieveryAddress() {
        return (AddressEntity) ((AddressStateRepo) RepoFactory.getRepo(AddressStateRepo.class)).getValue();
    }

    public String getSelectedAid() {
        return ((AddressStateRepo) RepoFactory.getRepo(AddressStateRepo.class)).mo105125b();
    }

    public int getSenceOfSelectedAddress() {
        return ((AddressStateRepo) RepoFactory.getRepo(AddressStateRepo.class)).mo105119a();
    }

    public void clearDeliveryAddress() {
        ((AddressStateRepo) RepoFactory.getRepo(AddressStateRepo.class)).mo105127c();
    }

    public void dispatchDeliveryAddress() {
        ((AddressStateRepo) RepoFactory.getRepo(AddressStateRepo.class)).setValue(getDelieveryAddress());
    }

    public Subscription subscribeAddress(ScopeContext scopeContext, Action<AddressEntity> action) {
        return ((AddressStateRepo) RepoFactory.getRepo(AddressStateRepo.class)).subscribe(scopeContext, action);
    }

    public void subscribeAddress(Action<AddressEntity> action) {
        ((AddressStateRepo) RepoFactory.getRepo(AddressStateRepo.class)).mo105122a(action);
    }

    public Subscription subscribeAddressNoViscous(ScopeContext scopeContext, Action<AddressEntity> action) {
        return ((AddressStateRepo) RepoFactory.getRepo(AddressStateRepo.class)).mo105120a(scopeContext, action);
    }

    public void subscribeAddressOnce(final Action2<AddressEntity> action2) {
        ((AddressStateRepo) RepoFactory.getRepo(AddressStateRepo.class)).mo105122a((Action<AddressEntity>) new Action2<AddressEntity>() {
            public void call(AddressEntity addressEntity, Subscription subscription) {
                if (AddressUtil.checkAddressValid(addressEntity)) {
                    action2.call(addressEntity, subscription);
                    subscription.unsubscribe();
                }
            }
        });
    }

    public void subscribeAddressAbnormalMessage(ScopeContext scopeContext, Action<Boolean> action) {
        ((C14210a) RepoFactory.getRepo(C14210a.class)).subscribe(scopeContext, action);
    }

    public void showAddressAbnormal() {
        ((C14210a) RepoFactory.getRepo(C14210a.class)).setValue(true);
    }

    public void hideAddressAbnormal() {
        ((C14210a) RepoFactory.getRepo(C14210a.class)).setValue(false);
    }

    public boolean isShowAddressAbnormal() {
        Boolean bool = (Boolean) ((C14210a) RepoFactory.getRepo(C14210a.class)).getValue();
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public Subscription subscribeAddressTip(ScopeContext scopeContext, Action<AddressTipInfo> action) {
        return ((C14211b) RepoFactory.getRepo(C14211b.class)).subscribe(scopeContext, action);
    }

    public void setAddressTip(AddressTipInfo addressTipInfo) {
        ((C14211b) RepoFactory.getRepo(C14211b.class)).setValue(addressTipInfo);
    }

    public AddressTipInfo getAddressTip() {
        return ((C14211b) RepoFactory.getRepo(C14211b.class)).getValue();
    }

    public void clearAddressTip() {
        ((C14211b) RepoFactory.getRepo(C14211b.class)).setValue(null);
    }

    public void updateAddressTip(ScopeContext scopeContext, double d, double d2) {
        m31152a(scopeContext, d, d2);
    }

    public void registerGpsReceiver(ScopeContext scopeContext, Context context) {
        if (this.f41499b == null) {
            IntentFilter intentFilter = new IntentFilter();
            this.f41499b = new GpsStatusReceiver(scopeContext, context);
            intentFilter.addAction("android.location.PROVIDERS_CHANGED");
            try {
                context.registerReceiver(this.f41499b, intentFilter);
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
        }
    }

    public void unRegisterGpsReceiver(Context context) {
        GpsStatusReceiver gpsStatusReceiver = this.f41499b;
        if (gpsStatusReceiver != null) {
            try {
                context.unregisterReceiver(gpsStatusReceiver);
            } catch (Exception e) {
                try {
                    Log.d("Context", "unregisterReceiver", e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    private void m31152a(ScopeContext scopeContext, double d, double d2) {
        AddressEntity delieveryAddress = getDelieveryAddress();
        AddressEntity.PoiEntity poiEntity = AddressUtil.checkAddressValid(delieveryAddress) ? delieveryAddress.poi : null;
        if (this.f41500c == null) {
            this.f41500c = new AccountErrorConsumer(scopeContext);
        }
        LogUtil.m32588i(f41498a, "getBackToFrontAddressTip");
        CustomerRpcManagerProxy.get().getBackToFrontAddressTip(poiEntity, d, d2, new CustomerRpcCallback<AddressTipInfo>(this.f41500c) {
            public void onRpcFailure(SFRpcException sFRpcException) {
                LogUtil.m32588i(CustomerAddressManager.f41498a, "getBackToFrontAddressTip onRpcFailure" + sFRpcException);
            }

            public void onRpcSuccess(AddressTipInfo addressTipInfo, long j) {
                ((C14211b) RepoFactory.getRepo(C14211b.class)).setValue(addressTipInfo);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m31153a(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network");
    }

    private class GpsStatusReceiver extends BroadcastReceiver {
        private boolean mPreGpsState;
        private WeakReference<ScopeContext> mScopeContext;

        GpsStatusReceiver(ScopeContext scopeContext, Context context) {
            this.mScopeContext = new WeakReference<>(scopeContext);
            this.mPreGpsState = CustomerAddressManager.this.m31153a(context);
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.location.PROVIDERS_CHANGED")) {
                boolean a = CustomerAddressManager.this.m31153a(context);
                if (a != this.mPreGpsState) {
                    LogUtil.m32584d(CustomerAddressManager.f41498a, "GpsStatusReceiver" + a);
                    ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).locateThenRefreshHome(6);
                }
                this.mPreGpsState = a;
            }
        }
    }
}
