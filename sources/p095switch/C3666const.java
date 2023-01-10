package p095switch;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.iproov.sdk.logging.IPLog;

/* renamed from: switch.const */
/* compiled from: TypefaceUtils */
public class C3666const {

    /* renamed from: a */
    private static final String f8781a = "const";

    /* renamed from: do */
    public static Typeface m7411do(Context context, String str) {
        try {
            return Typeface.createFromAsset(context.getAssets(), str);
        } catch (RuntimeException unused) {
            String str2 = f8781a;
            IPLog.m43494w(str2, "Font asset not found " + str);
            throw new RuntimeException("Font asset not found " + str);
        }
    }

    /* renamed from: do */
    public static Typeface m7410do(Context context, int i) {
        try {
            return ResourcesCompat.getFont(context, i);
        } catch (RuntimeException unused) {
            IPLog.m43494w(f8781a, "Font resource not found");
            throw new RuntimeException("Font resource not found");
        }
    }

    /* renamed from: do */
    public static void m7412do(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
            textView.setPaintFlags(textView.getPaintFlags() | 128);
        }
    }
}
