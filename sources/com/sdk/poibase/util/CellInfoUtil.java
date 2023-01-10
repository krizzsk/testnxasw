package com.sdk.poibase.util;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocBusinessHelper;
import com.didichuxing.bigdata.p174dp.locsdk.LocDataDef;

public class CellInfoUtil {
    public static String getCellInfoJson() {
        LocDataDef.LocCellInfo currentCellInfo = DIDILocBusinessHelper.getInstance().getCurrentCellInfo();
        if (currentCellInfo == null) {
            return null;
        }
        return "\"cell\":" + m44445a(currentCellInfo);
    }

    /* renamed from: a */
    private static String m44445a(LocDataDef.LocCellInfo locCellInfo) {
        StringBuilder sb = new StringBuilder(Const.jaLeft);
        if (locCellInfo.neighcells != null && locCellInfo.neighcells.size() > 0) {
            for (int i = 0; i < locCellInfo.neighcells.size(); i++) {
                if (i != 0) {
                    sb.append(",");
                }
                sb.append(m44446a(locCellInfo.neighcells.get(i)));
            }
        }
        sb.append(Const.jaRight);
        StringBuilder sb2 = new StringBuilder(Const.jaLeft);
        if (locCellInfo.pre_cell != null && locCellInfo.pre_cell.size() > 0) {
            for (int i2 = 0; i2 < locCellInfo.pre_cell.size(); i2++) {
                if (i2 != 0) {
                    sb2.append(",");
                }
                sb2.append(m44447a(locCellInfo.pre_cell.get(i2)));
            }
        }
        sb2.append(Const.jaRight);
        return Const.joLeft + Const.js_req_cell_mcc + ":" + locCellInfo.mcc + "," + Const.js_req_cell_mnc_sid + ":" + locCellInfo.mnc_sid + "," + Const.js_req_cell_lac_nid + ":" + locCellInfo.lac_nid + "," + Const.js_req_cell_cellid_bsid + ":" + locCellInfo.cellid_bsid + "," + "\"rssi\"" + ":" + locCellInfo.rssi + "," + "\"type\"" + ":" + locCellInfo.type + "," + Const.js_req_cell_neighcells + ":" + sb + "," + Const.js_req_cell_precell + ":" + sb2 + "}";
    }

    /* renamed from: a */
    private static String m44446a(LocDataDef.LocNeighboringCellInfo locNeighboringCellInfo) {
        return "{\"lac\":" + locNeighboringCellInfo.lac + ",\"cid\":" + locNeighboringCellInfo.cid + ",\"rssi\":" + locNeighboringCellInfo.rssi + "}";
    }

    /* renamed from: a */
    private static String m44447a(LocDataDef.LocPreCellInfo locPreCellInfo) {
        return "{\"mcc\":" + locPreCellInfo.mcc + ",\"mnc_sid\":" + locPreCellInfo.mnc_sid + ",\"lac_nid\":" + locPreCellInfo.lac_nid + ",\"cellid_bsid\":" + locPreCellInfo.cellid_bsid + ",\"type\":" + locPreCellInfo.type + ",\"dt\":" + locPreCellInfo.f48367dt + ",\"rssi\":" + locPreCellInfo.rssi + "}";
    }
}
