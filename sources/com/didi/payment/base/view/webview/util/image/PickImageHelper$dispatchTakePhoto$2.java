package com.didi.payment.base.view.webview.util.image;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import com.didi.payment.base.utils.ktx.ActivityKtxKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PickImageHelper.kt */
final class PickImageHelper$dispatchTakePhoto$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PickImageHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PickImageHelper$dispatchTakePhoto$2(PickImageHelper pickImageHelper) {
        super(0);
        this.this$0 = pickImageHelper;
    }

    public final void invoke() {
        final Uri uri;
        final File photoOutputFile = ImageFileConfig.getPhotoOutputFile(this.this$0.f32556a.getApplicationContext());
        if (!photoOutputFile.exists()) {
            try {
                photoOutputFile.createNewFile();
            } catch (Throwable th) {
                this.this$0.m24691a(th);
            }
        }
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (Build.VERSION.SDK_INT < 24) {
            uri = Uri.fromFile(photoOutputFile);
            Intrinsics.checkNotNullExpressionValue(uri, "{\n                Uri.fr…cameraFile)\n            }");
        } else {
            uri = FileProvider.getUriForFile(this.this$0.f32556a, Intrinsics.stringPlus(this.this$0.f32556a.getPackageName(), ".share.provider"), photoOutputFile);
            Intrinsics.checkNotNullExpressionValue(uri, "{\n                FilePr…          )\n            }");
        }
        intent.putExtra("output", uri);
        intent.addFlags(2);
        if (intent.resolveActivity(this.this$0.f32556a.getPackageManager()) != null) {
            FragmentActivity access$getActivity$p = this.this$0.f32556a;
            final PickImageHelper pickImageHelper = this.this$0;
            ActivityKtxKt.startActivityForResult(access$getActivity$p, intent, new Function2<Integer, Intent, Unit>() {
                public /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke(((Number) obj).intValue(), (Intent) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i, Intent intent) {
                    if (i != -1) {
                        pickImageHelper.m24695d();
                    } else if (!photoOutputFile.exists() || photoOutputFile.length() <= 0) {
                        pickImageHelper.m24695d();
                    } else {
                        pickImageHelper.m24687a(uri);
                    }
                }
            });
            return;
        }
        PickImageHelper.m24689a(this.this$0, (Throwable) null, 1, (Object) null);
    }
}
