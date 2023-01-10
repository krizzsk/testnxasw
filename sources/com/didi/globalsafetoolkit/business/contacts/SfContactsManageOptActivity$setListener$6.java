package com.didi.globalsafetoolkit.business.contacts;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, mo148868d2 = {"com/didi/globalsafetoolkit/business/contacts/SfContactsManageOptActivity$setListener$6", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "globalsafe-toolkit_release"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: SfContactsManageOptActivity.kt */
public final class SfContactsManageOptActivity$setListener$6 implements TextWatcher {
    final /* synthetic */ SfContactsManageOptActivity this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    SfContactsManageOptActivity$setListener$6(SfContactsManageOptActivity sfContactsManageOptActivity) {
        this.this$0 = sfContactsManageOptActivity;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (TextUtils.isEmpty(charSequence)) {
            ImageView access$getNameClearIcon$p = this.this$0.f24982e;
            if (access$getNameClearIcon$p != null) {
                access$getNameClearIcon$p.setVisibility(4);
                return;
            }
            return;
        }
        ImageView access$getNameClearIcon$p2 = this.this$0.f24982e;
        if (access$getNameClearIcon$p2 != null) {
            access$getNameClearIcon$p2.setVisibility(0);
        }
    }

    public void afterTextChanged(Editable editable) {
        EditText access$getNameInput$p = this.this$0.f24979b;
        boolean hasFocus = access$getNameInput$p != null ? access$getNameInput$p.hasFocus() : false;
        EditText access$getNameInput$p2 = this.this$0.f24979b;
        boolean isEmpty = TextUtils.isEmpty(access$getNameInput$p2 != null ? access$getNameInput$p2.getText() : null);
        SfContactsManageOptActivity sfContactsManageOptActivity = this.this$0;
        sfContactsManageOptActivity.m20031a(sfContactsManageOptActivity.f24988k, !isEmpty, hasFocus);
    }
}
