package com.didi.component.substitute.call.present;

import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.substitute.call.model.ContactModel;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n"}, mo148868d2 = {"<anonymous>", "", "s", "", "kotlin.jvm.PlatformType", "t", "Lcom/didi/component/substitute/call/model/ContactModel;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SubstituteCallPresent.kt */
final class SubstituteCallPresent$mSimpleRequestLis$1<T> implements BaseEventPublisher.OnEventListener {
    final /* synthetic */ SubstituteCallPresent this$0;

    SubstituteCallPresent$mSimpleRequestLis$1(SubstituteCallPresent substituteCallPresent) {
        this.this$0 = substituteCallPresent;
    }

    public final void onEvent(String str, ContactModel contactModel) {
        if (contactModel != null) {
            SubstituteCallPresent substituteCallPresent = this.this$0;
            substituteCallPresent.m15242b();
            substituteCallPresent.f17969a = contactModel.getType();
            substituteCallPresent.f17972d = contactModel.getId();
            substituteCallPresent.f17970b = contactModel.getName();
            substituteCallPresent.f17971c = contactModel.getPhone();
            substituteCallPresent.f17973e = contactModel.getCountryCode();
            substituteCallPresent.m15243c();
        }
    }
}
