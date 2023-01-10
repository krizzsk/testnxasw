package com.didi.addressnew.util;

import android.content.Context;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.sdk.address.address.entity.Address;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import com.sdk.poibase.model.common.RpcCommon;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.taxis99.R;
import java.util.ArrayList;

public class AddressConvertUtil {
    public static RpcCommon convertToCommon(Context context, RpcRecSug rpcRecSug) {
        RpcCommon rpcCommon = new RpcCommon();
        rpcCommon.errno = 0;
        rpcCommon.commonAddresses = new ArrayList<>();
        RpcCommonPoi recsugToCommon = recsugToCommon(rpcRecSug.home_poi);
        if (recsugToCommon != null) {
            recsugToCommon.name = context.getString(R.string.poi_one_address_home_param);
            recsugToCommon.type = 3;
            rpcCommon.commonAddresses.add(recsugToCommon);
        }
        RpcCommonPoi recsugToCommon2 = recsugToCommon(rpcRecSug.company_poi);
        if (recsugToCommon2 != null) {
            recsugToCommon2.name = context.getString(R.string.poi_one_address_company_param);
            recsugToCommon2.type = 4;
            rpcCommon.commonAddresses.add(recsugToCommon2);
        }
        ArrayList<RpcPoi> arrayList = rpcRecSug.favorite_poi_list;
        if (arrayList != null && arrayList.size() > 0) {
            for (RpcPoi recsugToCommon3 : arrayList) {
                RpcCommonPoi recsugToCommon4 = recsugToCommon(recsugToCommon3);
                recsugToCommon4.type = 5;
                rpcCommon.commonAddresses.add(recsugToCommon4);
            }
        }
        return rpcCommon;
    }

    public static RpcCommonPoi recsugToCommon(RpcPoi rpcPoi) {
        if (rpcPoi == null || rpcPoi.base_info == null) {
            return null;
        }
        RpcCommonPoi rpcCommonPoi = new RpcCommonPoi();
        rpcCommonPoi.displayName = rpcPoi.base_info.displayname;
        rpcCommonPoi.address = rpcPoi.base_info.address;
        rpcCommonPoi.addressDetail = rpcPoi.base_info.addressAll;
        rpcCommonPoi.latitude = rpcPoi.base_info.lat;
        rpcCommonPoi.longitude = rpcPoi.base_info.lng;
        rpcCommonPoi.cityId = rpcPoi.base_info.city_id;
        rpcCommonPoi.cityName = rpcPoi.base_info.city_name;
        rpcCommonPoi.poi_id = rpcPoi.base_info.poi_id;
        rpcCommonPoi.uid = rpcPoi.base_info.poi_id;
        rpcCommonPoi.countryID = rpcPoi.base_info.countryId;
        rpcCommonPoi.countryCode = rpcPoi.base_info.countryCode;
        rpcCommonPoi.hide_address = rpcPoi.base_info.hide_address;
        rpcCommonPoi.srcTag = rpcPoi.base_info.srctag;
        rpcCommonPoi.coordinateType = rpcPoi.base_info.coordinate_type;
        if (rpcPoi.extend_info != null) {
            rpcCommonPoi.aliasName = rpcPoi.extend_info.alias_name;
            rpcCommonPoi.primaryId = rpcPoi.extend_info.primary_id;
            rpcCommonPoi.pre_logo_url = rpcPoi.extend_info.pre_logo_url;
        }
        return rpcCommonPoi;
    }

    public static RpcPoi commonToRecSug(RpcCommonPoi rpcCommonPoi) {
        if (rpcCommonPoi == null) {
            return null;
        }
        RpcPoi rpcPoi = new RpcPoi();
        rpcPoi.base_info = new RpcPoiBaseInfo();
        rpcPoi.base_info.displayname = rpcCommonPoi.displayName;
        rpcPoi.base_info.address = rpcCommonPoi.address;
        rpcPoi.base_info.addressAll = rpcCommonPoi.addressDetail;
        rpcPoi.base_info.lat = rpcCommonPoi.latitude;
        rpcPoi.base_info.lng = rpcCommonPoi.longitude;
        rpcPoi.base_info.city_name = rpcCommonPoi.cityName;
        rpcPoi.base_info.city_id = rpcCommonPoi.cityId;
        rpcPoi.base_info.poi_id = rpcCommonPoi.poi_id;
        rpcPoi.base_info.countryId = rpcCommonPoi.countryID;
        rpcPoi.base_info.countryCode = rpcCommonPoi.countryCode;
        rpcPoi.base_info.hide_address = rpcCommonPoi.hide_address;
        rpcPoi.base_info.srctag = rpcCommonPoi.srcTag;
        rpcPoi.base_info.coordinate_type = rpcCommonPoi.coordinateType;
        return rpcPoi;
    }

    public static Address convertAddressFromDepartureAddress(Context context, DepartureAddress departureAddress) {
        Address address = new Address();
        if (departureAddress == null || departureAddress.getAddress() == null || context == null) {
        }
        return address;
    }

    public static RpcCommonPoi addressToRpcCommonPoi(Address address, RpcCommonPoi rpcCommonPoi) {
        RpcCommonPoi rpcCommonPoi2 = new RpcCommonPoi();
        if (address != null) {
            rpcCommonPoi2.address = address.address;
            rpcCommonPoi2.longitude = address.longitude;
            rpcCommonPoi2.latitude = address.latitude;
            rpcCommonPoi2.displayName = address.displayName;
            rpcCommonPoi2.cityId = address.cityId;
            rpcCommonPoi2.poi_id = address.poiId;
            rpcCommonPoi2.countryID = address.countryID;
            rpcCommonPoi2.countryCode = address.countryCode;
            rpcCommonPoi2.hide_address = address.hideAddress;
            rpcCommonPoi2.srcTag = address.srcTag;
            rpcCommonPoi2.coordinateType = address.coordinate_type;
            if (rpcCommonPoi != null) {
                rpcCommonPoi2.primaryId = rpcCommonPoi.primaryId;
                rpcCommonPoi2.aliasName = rpcCommonPoi.aliasName;
            }
        }
        return rpcCommonPoi2;
    }
}
