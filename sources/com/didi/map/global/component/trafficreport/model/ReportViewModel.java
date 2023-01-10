package com.didi.map.global.component.trafficreport.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.didi.sdk.address.address.entity.Address;

public class ReportViewModel extends ViewModel {

    /* renamed from: a */
    private final MutableLiveData<ReportItem> f28583a = new MutableLiveData<>();

    /* renamed from: b */
    private final MutableLiveData<TrafficEventParam> f28584b = new MutableLiveData<>();

    /* renamed from: c */
    private final MutableLiveData<Address> f28585c = new MutableLiveData<>();

    /* renamed from: d */
    private final MutableLiveData<Boolean> f28586d = new MutableLiveData<>();

    public void setItem(ReportItem reportItem) {
        this.f28583a.setValue(reportItem);
    }

    public LiveData<ReportItem> getItem() {
        return this.f28583a;
    }

    public void setStoredParam(TrafficEventParam trafficEventParam) {
        this.f28584b.setValue(trafficEventParam);
    }

    public LiveData<TrafficEventParam> getParam() {
        return this.f28584b;
    }

    public void setAddress(Address address) {
        this.f28585c.setValue(address);
    }

    public LiveData<Address> getAddress() {
        return this.f28585c;
    }

    public void setBackState(Boolean bool) {
        this.f28586d.setValue(bool);
    }

    public LiveData<Boolean> getBackPressState() {
        return this.f28586d;
    }
}
