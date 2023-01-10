package com.didi.soda.customer.foundation.rpc.header;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class HintContentStruct implements Serializable {
    public static final String APP_TIMEOUT_MS = "app_timeout_ms";
    public static final String CITY_ID = "Cityid";
    public static final String LANG = "lang";
    public static final String LOCALE = "locale";
    public static final String LOCATION_CITY_ID = "location_cityid";
    public static final String LOCATION_COUNTRY = "location_country";
    public static final String UTC_OFFSET = "utc_offset";
    private static final long serialVersionUID = 4305699763601236167L;
    @SerializedName("app_timeout_ms")
    private long mAppTimeout;
    @SerializedName("Cityid")
    private int mCityId;
    @SerializedName("lang")
    private String mLang;
    @SerializedName("locale")
    private String mLocale;
    @SerializedName("location_cityid")
    private int mLocationCityId;
    @SerializedName("location_country")
    private String mLocationCountryId;
    @SerializedName("utc_offset")
    private String mUtcOffset;

    public void setAppTimeout(long j) {
        this.mAppTimeout = j;
    }

    public void setCityId(int i) {
        this.mCityId = i;
    }

    public void setLang(String str) {
        this.mLang = str;
    }

    public void setUtcOffset(String str) {
        this.mUtcOffset = str;
    }

    public void setLocale(String str) {
        this.mLocale = str;
    }

    public void setLocationCityId(int i) {
        this.mLocationCityId = i;
    }

    public void setLocationCountryId(String str) {
        this.mLocationCountryId = str;
    }
}
