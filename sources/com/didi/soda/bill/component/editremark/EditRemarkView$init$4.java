package com.didi.soda.bill.component.editremark;

import android.text.Editable;
import android.text.TextWatcher;
import com.didi.raven.config.RavenKey;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.support.CustomerEditTextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, mo148868d2 = {"com/didi/soda/bill/component/editremark/EditRemarkView$init$4", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: EditRemarkView.kt */
public final class EditRemarkView$init$4 implements TextWatcher {
    final /* synthetic */ EditRemarkView this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, RavenKey.STACK);
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, RavenKey.STACK);
    }

    EditRemarkView$init$4(EditRemarkView editRemarkView) {
        this.this$0 = editRemarkView;
    }

    public void afterTextChanged(Editable editable) {
        Intrinsics.checkNotNullParameter(editable, RavenKey.STACK);
        CustomerEditTextCompat customerEditTextCompat = null;
        if (editable.length() == 0) {
            IToolsService iToolsService = (IToolsService) CustomerServiceManager.getService(IToolsService.class);
            CustomerEditTextCompat access$getContentEt$p = this.this$0.f41649a;
            if (access$getContentEt$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentEt");
            } else {
                customerEditTextCompat = access$getContentEt$p;
            }
            iToolsService.setTypeface(customerEditTextCompat, IToolsService.FontType.LIGHT);
            return;
        }
        CustomerEditTextCompat access$getContentEt$p2 = this.this$0.f41649a;
        if (access$getContentEt$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentEt");
            access$getContentEt$p2 = null;
        }
        if (access$getContentEt$p2.getTypeface() != null) {
            CustomerEditTextCompat access$getContentEt$p3 = this.this$0.f41649a;
            if (access$getContentEt$p3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentEt");
                access$getContentEt$p3 = null;
            }
            if (!Intrinsics.areEqual((Object) access$getContentEt$p3.getTypeface(), (Object) ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).getFontTypeFace(IToolsService.FontType.MEDIUM))) {
                IToolsService iToolsService2 = (IToolsService) CustomerServiceManager.getService(IToolsService.class);
                CustomerEditTextCompat access$getContentEt$p4 = this.this$0.f41649a;
                if (access$getContentEt$p4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentEt");
                } else {
                    customerEditTextCompat = access$getContentEt$p4;
                }
                iToolsService2.setTypeface(customerEditTextCompat, IToolsService.FontType.MEDIUM);
            }
        }
    }
}
