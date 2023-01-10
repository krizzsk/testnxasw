package com.didi.flutter.nacho.p115ui.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.didi.flutter.nacho.ui.blur.b */
/* compiled from: RenderScriptBlurHelper */
final class C8876b {

    /* renamed from: a */
    private static final String f22993a = C8876b.class.getSimpleName();

    private C8876b() {
    }

    /* renamed from: a */
    public static Bitmap m18971a(Bitmap bitmap, int i, boolean z, Context context) {
        if (!z) {
            bitmap = bitmap.copy(bitmap.getConfig(), true);
        }
        if (bitmap.getConfig() == Bitmap.Config.RGB_565) {
            bitmap = m18970a(bitmap);
        }
        try {
            RenderScript create = RenderScript.create(context);
            Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
            Allocation createTyped = Allocation.createTyped(create, createFromBitmap.getType());
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            create2.setRadius((float) i);
            create2.setInput(createFromBitmap);
            create2.forEach(createTyped);
            createTyped.copyTo(bitmap);
            return bitmap;
        } catch (RSRuntimeException unused) {
            SystemUtils.log(6, f22993a, "RenderScript known error : https://code.google.com/p/android/issues/detail?id=71347 continue with the FastBlur approach.", (Throwable) null, "com.didi.flutter.nacho.ui.blur.RenderScriptBlurHelper", 66);
            return null;
        }
    }

    /* renamed from: a */
    private static Bitmap m18970a(Bitmap bitmap) {
        return bitmap.copy(Bitmap.Config.ARGB_8888, true);
    }
}
