package com.didiglobal.travel.biz.experim;

import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.soda.customer.p165h5.CustomerWebActivity;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"}, mo148868d2 = {"checkCancelOrderNewPage", "", "common_release"}, mo148869k = 2, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalExperims.kt */
public final class GlobalExperims {
    public static final boolean checkCancelOrderNewPage() {
        Integer num = (Integer) GlobalApolloUtil.getAvailableParams("Optimazation_of_Cancel_action_blocking_page_new", CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0);
        return num == null || num.intValue() != 0;
    }
}
