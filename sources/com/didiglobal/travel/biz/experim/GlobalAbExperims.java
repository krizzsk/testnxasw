package com.didiglobal.travel.biz.experim;

import com.didi.component.business.util.GlobalApolloUtil;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"}, mo148868d2 = {"checkSugAddrPax", "", "common_release"}, mo148869k = 2, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalAbExperims.kt */
public final class GlobalAbExperims {
    public static final boolean checkSugAddrPax() {
        return GlobalApolloUtil.getStatus("map_sug_address_android_pax");
    }
}
