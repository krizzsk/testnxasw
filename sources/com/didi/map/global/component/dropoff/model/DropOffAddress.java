package com.didi.map.global.component.dropoff.model;

import com.didi.sdk.address.address.entity.Address;

public class DropOffAddress {

    /* renamed from: a */
    private Address f27787a;

    /* renamed from: b */
    private DropOffAddressExtendInfo f27788b;

    /* renamed from: c */
    private int f27789c;
    public boolean isRecommmend;

    public Address getAddress() {
        return this.f27787a;
    }

    public void setAddress(Address address) {
        this.f27787a = address;
    }

    public boolean isRecommmend() {
        return this.isRecommmend;
    }

    public void setRecommmend(boolean z) {
        this.isRecommmend = z;
    }

    public DropOffAddressExtendInfo getExtendInfo() {
        return this.f27788b;
    }

    public void setExtendInfo(DropOffAddressExtendInfo dropOffAddressExtendInfo) {
        this.f27788b = dropOffAddressExtendInfo;
    }

    public int getRecPointSize() {
        return this.f27789c;
    }

    public void setRecPointSize(int i) {
        this.f27789c = i;
    }
}
