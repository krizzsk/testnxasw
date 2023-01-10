package com.didi.map.global.component.departure.model;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.sdk.address.address.entity.Address;
import com.sdk.poibase.model.poi.FenceInfo;
import com.sdk.poibase.model.poi.SpecialPoiGuidance;
import java.util.ArrayList;
import java.util.List;

public class DepartureAddress {

    /* renamed from: a */
    private Address f27446a;

    /* renamed from: b */
    private Address f27447b;

    /* renamed from: c */
    private boolean f27448c;

    /* renamed from: d */
    private String f27449d;

    /* renamed from: e */
    private SpecialPoiGuidance f27450e;

    /* renamed from: f */
    private int f27451f = 2;

    /* renamed from: g */
    private FenceInfo f27452g;

    /* renamed from: h */
    private List<Address> f27453h;

    /* renamed from: i */
    private SpecialPois f27454i;

    /* renamed from: j */
    private String f27455j;

    /* renamed from: k */
    private ArrayList<String> f27456k;

    /* renamed from: l */
    private int f27457l;

    /* renamed from: m */
    private boolean f27458m = false;

    /* renamed from: n */
    private boolean f27459n = false;

    /* renamed from: o */
    private int f27460o;

    /* renamed from: p */
    private LatLng f27461p;

    /* renamed from: q */
    private String f27462q;

    /* renamed from: r */
    private String f27463r;

    /* renamed from: s */
    private String f27464s;
    public ArrayList<String> specialLocations;

    /* renamed from: t */
    private String f27465t;

    /* renamed from: u */
    private int f27466u;

    /* renamed from: v */
    private String f27467v;

    /* renamed from: w */
    private AddressExtendInfo f27468w;

    public String getPickIconUrl() {
        return this.f27463r;
    }

    public void setPickIconUrl(String str) {
        this.f27463r = str;
    }

    public String getNavigationText() {
        return this.f27464s;
    }

    public void setNavigationText(String str) {
        this.f27464s = str;
    }

    public int getCountryId() {
        return this.f27466u;
    }

    public void setCountryId(int i) {
        this.f27466u = i;
    }

    public String getCountryCode() {
        return this.f27467v;
    }

    public void setCountryCode(String str) {
        this.f27467v = str;
    }

    public String getEta() {
        return this.f27465t;
    }

    public void setEta(String str) {
        this.f27465t = str;
    }

    public int getIsAirPortPickUpPoint() {
        return this.f27460o;
    }

    public void setIsAirPortPickUpPoint(int i) {
        this.f27460o = i;
    }

    public Address getAddress() {
        return this.f27446a;
    }

    public LatLng getPosition() {
        Address address = this.f27446a;
        if (address == null || this.f27461p != null) {
            DLog.m10773d("departure position", "position！=null", new Object[0]);
        } else {
            this.f27461p = new LatLng(address.latitude, this.f27446a.longitude);
        }
        return this.f27461p;
    }

    public void setAddress(Address address) {
        this.f27446a = address;
    }

    public boolean isRecommendPoi() {
        return this.f27448c;
    }

    public String getDepartureDisplayName() {
        return this.f27449d;
    }

    public void setDepartureDisplayName(String str) {
        this.f27449d = str;
    }

    public SpecialPoiGuidance getSpecialPoiGuidance() {
        return this.f27450e;
    }

    public void setSpecialPoiGuidance(SpecialPoiGuidance specialPoiGuidance) {
        this.f27450e = specialPoiGuidance;
    }

    public void setRecommendPoi(boolean z) {
        this.f27448c = z;
    }

    public int getZoneType() {
        return this.f27451f;
    }

    public void setZoneType(int i) {
        this.f27451f = i;
    }

    public FenceInfo getFenceInfo() {
        return this.f27452g;
    }

    public void setFenceInfo(FenceInfo fenceInfo) {
        this.f27452g = fenceInfo;
    }

    public List<Address> getRecDestinations() {
        return this.f27453h;
    }

    public void setRecDestinations(List<Address> list) {
        this.f27453h = list;
    }

    public SpecialPois getSpecialPois() {
        return this.f27454i;
    }

    public void setSpecialPois(SpecialPois specialPois) {
        this.f27454i = specialPois;
    }

    public boolean hasSpecialPois() {
        SpecialPois specialPois = this.f27454i;
        return (specialPois == null || specialPois.pois == null || this.f27454i.pois.isEmpty()) ? false : true;
    }

    public ArrayList<String> getSpecialLocations() {
        return this.specialLocations;
    }

    public void setSpecialLocations(ArrayList<String> arrayList) {
        this.specialLocations = arrayList;
    }

    public String getLanguage() {
        return this.f27455j;
    }

    public void setLanguage(String str) {
        this.f27455j = str;
    }

    public ArrayList<String> getGeofenceTags() {
        return this.f27456k;
    }

    public void setGeofenceTags(ArrayList<String> arrayList) {
        this.f27456k = arrayList;
    }

    public int getPickUpPointSize() {
        return this.f27457l;
    }

    public void setPickUpPointSize(int i) {
        this.f27457l = i;
    }

    public boolean isShowSpecialNotifacation() {
        return this.f27458m;
    }

    public void setShowSpecialNotifacation(boolean z) {
        this.f27458m = z;
    }

    public boolean isShowRealPicInXpanel() {
        return this.f27459n;
    }

    public void setShowRealPicInXpanel(boolean z) {
        this.f27459n = z;
    }

    public String getStartParkingProperty() {
        return this.f27462q;
    }

    public void setStartParkingProperty(String str) {
        this.f27462q = str;
    }

    public AddressExtendInfo getExtendInfo() {
        return this.f27468w;
    }

    public void setExtendInfo(AddressExtendInfo addressExtendInfo) {
        this.f27468w = addressExtendInfo;
    }

    public Address getRgeoResult() {
        return this.f27447b;
    }

    public void setRgeoResult(Address address) {
        this.f27447b = address;
    }
}
