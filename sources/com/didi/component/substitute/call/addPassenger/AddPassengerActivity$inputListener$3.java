package com.didi.component.substitute.call.addPassenger;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, mo148868d2 = {"com/didi/component/substitute/call/addPassenger/AddPassengerActivity$inputListener$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "comp-substitute-call_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: AddPassengerActivity.kt */
public final class AddPassengerActivity$inputListener$3 implements TextWatcher {
    final /* synthetic */ AddPassengerActivity this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    AddPassengerActivity$inputListener$3(AddPassengerActivity addPassengerActivity) {
        this.this$0 = addPassengerActivity;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.this$0.f17935o = String.valueOf(charSequence);
    }

    public void afterTextChanged(Editable editable) {
        this.this$0.m15223c();
    }
}
