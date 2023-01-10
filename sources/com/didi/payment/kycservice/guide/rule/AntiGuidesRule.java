package com.didi.payment.kycservice.guide.rule;

import com.didi.payment.base.exts.ApplicationContextProvider;
import com.didi.payment.kycservice.utils.KycPreferencesUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;

@ServiceProvider({IKycGuidesRule.class})
@Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo148868d2 = {"Lcom/didi/payment/kycservice/guide/rule/AntiGuidesRule;", "Lcom/didi/payment/kycservice/guide/rule/IKycGuidesRule;", "()V", "displayedGuideRule", "", "key", "", "showGuideRule", "", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: AntiGuidesRule.kt */
public final class AntiGuidesRule implements IKycGuidesRule {
    public String key() {
        return "4";
    }

    public boolean showGuideRule() {
        boolean antiKycNeedGuides = KycPreferencesUtil.antiKycNeedGuides(ApplicationContextProvider.Companion.getContext());
        if (antiKycNeedGuides) {
            KycPreferencesUtil.antiKycShowGuides(ApplicationContextProvider.Companion.getContext(), 1);
        }
        return antiKycNeedGuides;
    }

    public void displayedGuideRule() {
        KycPreferencesUtil.antiKycShowGuides(ApplicationContextProvider.Companion.getContext(), 99);
    }
}
