package com.didi.payment.base.view.webview.util.image;

import android.content.Intent;
import android.net.Uri;
import com.didi.drouter.router.RouterCallback;
import java.io.File;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo148868d2 = {"com/didi/payment/base/view/webview/util/image/PickImageHelper$dispatchCropImage$1", "Lcom/didi/drouter/router/RouterCallback$ActivityCallback;", "onActivityResult", "", "resultCode", "", "data", "Landroid/content/Intent;", "base_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PickImageHelper.kt */
public final class PickImageHelper$dispatchCropImage$1 extends RouterCallback.ActivityCallback {

    /* renamed from: $h */
    final /* synthetic */ int f32565$h;

    /* renamed from: $w */
    final /* synthetic */ int f32566$w;
    final /* synthetic */ PickImageHelper this$0;

    PickImageHelper$dispatchCropImage$1(PickImageHelper pickImageHelper, int i, int i2) {
        this.this$0 = pickImageHelper;
        this.f32566$w = i;
        this.f32565$h = i2;
    }

    public void onActivityResult(int i, Intent intent) {
        if (i == -1) {
            String stringExtra = intent == null ? null : intent.getStringExtra("CROP_PIC_PASS_KEY");
            CharSequence charSequence = stringExtra;
            if (!(charSequence == null || charSequence.length() == 0)) {
                this.this$0.m24688a(Uri.fromFile(new File(stringExtra)), this.f32566$w, this.f32565$h);
            } else {
                this.this$0.m24695d();
            }
        }
    }
}
