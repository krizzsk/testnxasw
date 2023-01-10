package com.didi.payment.base.view.webview.util.image;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.fragment.app.FragmentActivity;
import com.didi.payment.base.utils.ktx.ActivityKtxKt;
import com.didi.sdk.webview.image.PicUploadActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PickImageHelper.kt */
final class PickImageHelper$dispatchSelectFromAlbum$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PickImageHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PickImageHelper$dispatchSelectFromAlbum$2(PickImageHelper pickImageHelper) {
        super(0);
        this.this$0 = pickImageHelper;
    }

    public final void invoke() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, PicUploadActivity.IMAGE_UNSPECIFIED);
        if (intent.resolveActivity(this.this$0.f32556a.getPackageManager()) != null) {
            FragmentActivity access$getActivity$p = this.this$0.f32556a;
            final PickImageHelper pickImageHelper = this.this$0;
            ActivityKtxKt.startActivityForResult(access$getActivity$p, intent, new Function2<Integer, Intent, Unit>() {
                public /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke(((Number) obj).intValue(), (Intent) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i, Intent intent) {
                    if (i == -1) {
                        Uri data = intent == null ? null : intent.getData();
                        if (data != null) {
                            pickImageHelper.m24687a(data);
                        } else {
                            pickImageHelper.m24695d();
                        }
                    } else {
                        pickImageHelper.m24695d();
                    }
                }
            });
            return;
        }
        PickImageHelper.m24689a(this.this$0, (Throwable) null, 1, (Object) null);
    }
}
