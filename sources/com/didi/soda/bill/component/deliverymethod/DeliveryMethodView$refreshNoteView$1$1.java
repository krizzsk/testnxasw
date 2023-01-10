package com.didi.soda.bill.component.deliverymethod;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.didi.raven.config.RavenKey;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, mo148868d2 = {"com/didi/soda/bill/component/deliverymethod/DeliveryMethodView$refreshNoteView$1$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: DeliveryMethodView.kt */
public final class DeliveryMethodView$refreshNoteView$1$1 implements TextWatcher {
    final /* synthetic */ EditText $it;
    final /* synthetic */ DeliveryMethodView this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, RavenKey.STACK);
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, RavenKey.STACK);
    }

    DeliveryMethodView$refreshNoteView$1$1(DeliveryMethodView deliveryMethodView, EditText editText) {
        this.this$0 = deliveryMethodView;
        this.$it = editText;
    }

    public void afterTextChanged(Editable editable) {
        Intrinsics.checkNotNullParameter(editable, RavenKey.STACK);
        if (editable.length() == 0) {
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.this$0.getMNote(), IToolsService.FontType.LIGHT);
        } else if (this.$it.getTypeface() != null && !Intrinsics.areEqual((Object) this.$it.getTypeface(), (Object) ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).getFontTypeFace(IToolsService.FontType.MEDIUM))) {
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.$it, IToolsService.FontType.MEDIUM);
        }
    }
}
