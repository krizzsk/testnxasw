package com.didi.component.substitute.call.addPassenger;

import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.unifylogin.base.net.pojo.response.CountryListResponse;
import com.didi.unifylogin.flutter.LoginEventHandler;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n"}, mo148868d2 = {"<anonymous>", "", "countryRule", "Lcom/didi/unifylogin/base/net/pojo/response/CountryListResponse$CountryRule;", "kotlin.jvm.PlatformType"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: AddPassengerActivity.kt */
final class AddPassengerActivity$openCountries$1 implements LoginEventHandler.CountryCodeSelectListener {
    final /* synthetic */ AddPassengerActivity this$0;

    AddPassengerActivity$openCountries$1(AddPassengerActivity addPassengerActivity) {
        this.this$0 = addPassengerActivity;
    }

    public final void onCountrySelected(CountryListResponse.CountryRule countryRule) {
        this.this$0.m15219a(countryRule.getNationalFlagUrl(), countryRule.getJSONObj().optString(ParamConst.PARAM_CALLING_CODE));
    }
}
