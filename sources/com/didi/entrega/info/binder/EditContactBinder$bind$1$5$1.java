package com.didi.entrega.info.binder;

import android.text.Editable;
import com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity;
import com.didi.entrega.info.binder.EditContactBinder;
import com.didi.entrega.info.helper.InfoTextWatcher;
import com.didi.entrega.info.model.ContactModel;
import com.didi.rfusion.widget.RFIconView;
import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didi/entrega/info/binder/EditContactBinder$bind$1$5$1", "Lcom/didi/entrega/info/helper/InfoTextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: EditContactBinder.kt */
public final class EditContactBinder$bind$1$5$1 extends InfoTextWatcher {
    final /* synthetic */ EditContactBinder.ViewHolder $holder;
    final /* synthetic */ ContactModel $model;
    final /* synthetic */ EditContactBinder this$0;

    EditContactBinder$bind$1$5$1(ContactModel contactModel, EditContactBinder editContactBinder, EditContactBinder.ViewHolder viewHolder) {
        this.$model = contactModel;
        this.this$0 = editContactBinder;
        this.$holder = viewHolder;
    }

    public void afterTextChanged(Editable editable) {
        CommonInfoEntity.Contact contact = this.$model.getContact();
        CommonInfoEntity.PhoneNumber phoneNumber = contact == null ? null : contact.getPhoneNumber();
        if (phoneNumber != null) {
            phoneNumber.setPhoneNumber(String.valueOf(editable));
        }
        EditContactBinder.ContactCardClickListener contactCardClickListener = this.this$0.getContactCardClickListener();
        if (contactCardClickListener != null) {
            contactCardClickListener.textChangeOnModel(this.$model);
        }
        RFIconView rFIconView = (RFIconView) this.$holder.itemView.findViewById(R.id.ic_phone_clear);
        int i = 0;
        if ((editable == null ? 0 : editable.length()) <= 0) {
            i = 8;
        }
        rFIconView.setVisibility(i);
    }
}
