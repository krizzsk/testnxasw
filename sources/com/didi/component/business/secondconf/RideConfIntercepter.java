package com.didi.component.business.secondconf;

import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.util.GlobalApolloUtils;
import com.didichuxing.bigdata.p174dp.locsdk.EvilTransform;

public class RideConfIntercepter {

    /* renamed from: a */
    private Address f13175a;

    /* renamed from: b */
    private int f13176b = ((Integer) GlobalApolloUtils.getParamByStatus("refresh_product_conf_distance_filter", "rideMenu", 200, true)).intValue();

    public boolean interceptAddress(Address address) {
        if (address == null) {
            return false;
        }
        Address address2 = this.f13175a;
        if (address2 == null) {
            this.f13175a = address;
        } else if (EvilTransform.calcdistance(address2.longitude, this.f13175a.latitude, address.longitude, address.latitude) > ((double) this.f13176b)) {
            this.f13175a = address;
            return true;
        } else if (this.f13175a.cityId != address.cityId) {
            this.f13175a = address;
            return true;
        }
        return false;
    }
}
