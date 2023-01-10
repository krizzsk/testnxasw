package com.didi.sdk.oneconf;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.DIDIApplicationDelegate;
import com.didi.sdk.bff.BffConstants;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.store.BaseStore;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OneConfStore extends BaseStore {

    /* renamed from: a */
    private static final String f39664a = "OneConfStore";

    /* renamed from: d */
    private static OneConfStore f39665d;

    /* renamed from: b */
    private Logger f39666b;

    /* renamed from: c */
    private RpcServiceFactory f39667c;

    /* renamed from: e */
    private List<OneConfConfigChangeListener> f39668e;

    /* renamed from: f */
    private SharedPreferences f39669f;

    /* renamed from: g */
    private OneConfData f39670g;

    /* renamed from: h */
    private Context f39671h;

    /* renamed from: i */
    private int f39672i;

    /* renamed from: j */
    private int f39673j;

    /* renamed from: k */
    private double f39674k;

    /* renamed from: l */
    private double f39675l;

    /* renamed from: m */
    private String f39676m;

    public interface OneConfConfigChangeListener {
        void onChanged(OneConfData oneConfData, double d, double d2);
    }

    private OneConfStore() {
        super("framework_oneconf");
        this.f39666b = LoggerFactory.getLogger(f39664a);
        this.f39668e = new ArrayList();
        this.f39669f = null;
        this.f39670g = new OneConfData();
        this.f39676m = "KEY_ONECONF_COUNTRYISOCODE";
        this.f39669f = SystemUtils.getSharedPreferences(DIDIApplicationDelegate.getAppContext(), "framework_oneconf", 0);
    }

    public static OneConfStore getInstance() {
        if (f39665d == null) {
            f39665d = new OneConfStore();
        }
        return f39665d;
    }

    /* renamed from: a */
    private RpcServiceFactory m29865a(Context context) {
        if (this.f39667c == null) {
            this.f39667c = new RpcServiceFactory(context);
        }
        return this.f39667c;
    }

    /* renamed from: a */
    private void m29867a(int i) {
        this.f39669f.edit().putInt("city_id", i).apply();
    }

    /* renamed from: b */
    private void m29871b(int i) {
        this.f39669f.edit().putInt("country_id", i).apply();
    }

    /* renamed from: a */
    private void m29869a(String str) {
        this.f39669f.edit().putString(this.f39676m, str).apply();
    }

    public int getCityId() {
        if (this.f39670g.cityId != -1) {
            return this.f39670g.cityId;
        }
        return this.f39669f.getInt("city_id", this.f39670g.cityId);
    }

    public int getCountryId() {
        if (this.f39670g.countryId != -1) {
            return this.f39670g.countryId;
        }
        return this.f39669f.getInt("country_id", this.f39670g.countryId);
    }

    public String getCountryIsoCode() {
        if (!TextUtils.isEmpty(this.f39670g.countryIsoCode)) {
            return this.f39670g.countryIsoCode;
        }
        return this.f39669f.getString(this.f39676m, this.f39670g.countryIsoCode);
    }

    public double getLatitude() {
        return this.f39674k;
    }

    public double getLongitude() {
        return this.f39675l;
    }

    public void getOneConf(Context context, double d, double d2) {
        final double d3 = d;
        final double d4 = d2;
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABLITY_CLIENT_GCONF).setCallback(new RpcService.Callback<JsonObject>() {
            public void onFailure(IOException iOException) {
            }

            public void onSuccess(JsonObject jsonObject) {
                OneConfStore.this.m29870a(jsonObject.toString(), d3, d4);
            }
        }).build());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29870a(String str, double d, double d2) {
        this.f39670g.parse(str);
        m29867a(this.f39670g.cityId);
        m29871b(this.f39670g.countryId);
        m29869a(this.f39670g.countryIsoCode);
        m29866a(d, d2, this.f39670g.countryId, this.f39670g.cityId);
        synchronized (this.f39668e) {
            for (int i = 0; i < this.f39668e.size(); i++) {
                this.f39668e.get(i).onChanged(this.f39670g, d, d2);
            }
        }
    }

    /* renamed from: a */
    private void m29866a(double d, double d2, int i, int i2) {
        this.f39674k = d;
        this.f39675l = d2;
        if (this.f39672i != i || this.f39673j != i2) {
            this.f39672i = i;
            this.f39673j = i2;
            Address address = new Address();
            address.setCityId(i2);
            address.setLatitude(d);
            address.setLongitude(d2);
            dispatchEvent(new CityChangeEvent(CityChangeEvent.EVENT_GUARANA_CITY_CHANGE, address));
        }
    }

    public void addOneConfChangeListener(OneConfConfigChangeListener oneConfConfigChangeListener) {
        synchronized (this.f39668e) {
            this.f39668e.add(oneConfConfigChangeListener);
        }
    }

    public void removeOneConfChangeListener(OneConfConfigChangeListener oneConfConfigChangeListener) {
        synchronized (this.f39668e) {
            this.f39668e.remove(oneConfConfigChangeListener);
        }
    }
}
