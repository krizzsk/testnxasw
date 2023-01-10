package com.didi.soda.business.component.address;

import android.os.Bundle;
import com.didi.common.map.model.LatLng;
import com.didi.soda.business.component.address.Contract;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.util.LocationUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\u000b\u001a\u00020\tH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, mo148868d2 = {"Lcom/didi/soda/business/component/address/BusinessAddressMapPresenter;", "Lcom/didi/soda/business/component/address/Contract$AbsBusinessAddressMapPresenter;", "()V", "businessAddress", "", "businessLatLng", "Lcom/didi/common/map/model/LatLng;", "businessName", "initParams", "", "onCreate", "onPageClose", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BusinessAddressMapPresenter.kt */
public final class BusinessAddressMapPresenter extends Contract.AbsBusinessAddressMapPresenter {

    /* renamed from: a */
    private LatLng f42078a;

    /* renamed from: b */
    private String f42079b;

    /* renamed from: c */
    private String f42080c;

    public void onPageClose() {
        getScopeContext().getNavigator().finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        LatLng latLng;
        super.onCreate();
        m31538a();
        ((Contract.AbsBusinessAddressMapView) getLogicView()).showBusinessInfoText(this.f42080c, this.f42079b);
        if (LocationUtil.hasValidPoi()) {
            latLng = new LatLng(LocationUtil.getPoiLat(), LocationUtil.getPoiLng());
        } else {
            latLng = LocationUtil.getCurrentLatLng();
        }
        ((Contract.AbsBusinessAddressMapView) getLogicView()).showLocationMarkView(latLng, this.f42078a);
    }

    /* renamed from: a */
    private final void m31538a() {
        Bundle bundle = getScopeContext().getBundle();
        Intrinsics.checkNotNullExpressionValue(bundle, "scopeContext.bundle");
        LatLng latLng = (LatLng) bundle.getParcelable(Const.PageParams.SHOP_ADDRESS_LAT_LNG);
        this.f42078a = latLng;
        if (latLng == null) {
            try {
                String string = bundle.getString(Const.PageParams.LATITUDE);
                double d = 0.0d;
                double parseDouble = string == null ? 0.0d : Double.parseDouble(string);
                String string2 = bundle.getString(Const.PageParams.LONGITUDE);
                if (string2 != null) {
                    d = Double.parseDouble(string2);
                }
                this.f42078a = new LatLng(parseDouble, d);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.f42079b = bundle.getString(Const.PageParams.SHOP_ADDRESS);
        this.f42080c = bundle.getString(Const.PageParams.SHOP_NAME);
    }
}
