package androidx.navigation;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo148868d2 = {"findNavController", "Landroidx/navigation/NavController;", "Landroid/app/Activity;", "viewId", "", "navigation-runtime-ktx_release"}, mo148869k = 2, mo148870mv = {1, 1, 16})
/* compiled from: Activity.kt */
public final class ActivityKt {
    public static final NavController findNavController(Activity activity, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "$this$findNavController");
        NavController findNavController = Navigation.findNavController(activity, i);
        Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavController(this, viewId)");
        return findNavController;
    }
}
