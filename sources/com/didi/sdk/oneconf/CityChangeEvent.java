package com.didi.sdk.oneconf;

import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.event.Event;

public class CityChangeEvent implements Event {
    public static final String EVENT_GUARANA_CITY_CHANGE = "guarana_city_change";

    /* renamed from: a */
    private Address f39662a;

    /* renamed from: b */
    private String f39663b;

    public CityChangeEvent(String str, Address address) {
        this.f39663b = str;
        this.f39662a = address;
    }

    public String getEvent() {
        return this.f39663b;
    }

    public void setEvent(String str) {
        this.f39663b = str;
    }

    public Address getAddress() {
        return this.f39662a;
    }
}
