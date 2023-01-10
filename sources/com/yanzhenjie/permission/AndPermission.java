package com.yanzhenjie.permission;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.os.Build;
import androidx.fragment.app.Fragment;
import com.yanzhenjie.permission.checker.DoubleChecker;
import com.yanzhenjie.permission.checker.PermissionChecker;
import com.yanzhenjie.permission.option.Option;
import com.yanzhenjie.permission.source.ActivitySource;
import com.yanzhenjie.permission.source.ContextSource;
import com.yanzhenjie.permission.source.FragmentSource;
import com.yanzhenjie.permission.source.Source;
import com.yanzhenjie.permission.source.SupportFragmentSource;
import java.io.File;
import java.util.List;

public class AndPermission {

    /* renamed from: a */
    private static final PermissionChecker f58907a = new DoubleChecker();

    public static Option with(Context context) {
        return new Boot(m44523a(context));
    }

    public static Option with(Fragment fragment) {
        return new Boot(new SupportFragmentSource(fragment));
    }

    public static Option with(android.app.Fragment fragment) {
        return new Boot(new FragmentSource(fragment));
    }

    public static Option with(Activity activity) {
        return new Boot(new ActivitySource(activity));
    }

    public static boolean hasAlwaysDeniedPermission(Context context, List<String> list) {
        return m44524a(m44523a(context), list);
    }

    public static boolean hasAlwaysDeniedPermission(Fragment fragment, List<String> list) {
        return m44524a((Source) new SupportFragmentSource(fragment), list);
    }

    public static boolean hasAlwaysDeniedPermission(android.app.Fragment fragment, List<String> list) {
        return m44524a((Source) new FragmentSource(fragment), list);
    }

    public static boolean hasAlwaysDeniedPermission(Activity activity, List<String> list) {
        return m44524a((Source) new ActivitySource(activity), list);
    }

    /* renamed from: a */
    private static boolean m44524a(Source source, List<String> list) {
        for (String isShowRationalePermission : list) {
            if (!source.isShowRationalePermission(isShowRationalePermission)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasAlwaysDeniedPermission(Context context, String... strArr) {
        return m44525a(m44523a(context), strArr);
    }

    public static boolean hasAlwaysDeniedPermission(Fragment fragment, String... strArr) {
        return m44525a((Source) new SupportFragmentSource(fragment), strArr);
    }

    public static boolean hasAlwaysDeniedPermission(android.app.Fragment fragment, String... strArr) {
        return m44525a((Source) new FragmentSource(fragment), strArr);
    }

    public static boolean hasAlwaysDeniedPermission(Activity activity, String... strArr) {
        return m44525a((Source) new ActivitySource(activity), strArr);
    }

    /* renamed from: a */
    private static boolean m44525a(Source source, String... strArr) {
        for (String isShowRationalePermission : strArr) {
            if (!source.isShowRationalePermission(isShowRationalePermission)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasPermissions(Context context, String... strArr) {
        return f58907a.hasPermission(context, strArr);
    }

    public static boolean hasPermissions(Fragment fragment, String... strArr) {
        return hasPermissions((Activity) fragment.getActivity(), strArr);
    }

    public static boolean hasPermissions(android.app.Fragment fragment, String... strArr) {
        return hasPermissions(fragment.getActivity(), strArr);
    }

    public static boolean hasPermissions(Activity activity, String... strArr) {
        return f58907a.hasPermission((Context) activity, strArr);
    }

    public static boolean hasPermissions(Context context, String[]... strArr) {
        for (String[] hasPermission : strArr) {
            if (!f58907a.hasPermission(context, hasPermission)) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasPermissions(Fragment fragment, String[]... strArr) {
        return hasPermissions((Activity) fragment.getActivity(), strArr);
    }

    public static boolean hasPermissions(android.app.Fragment fragment, String[]... strArr) {
        return hasPermissions(fragment.getActivity(), strArr);
    }

    public static boolean hasPermissions(Activity activity, String[]... strArr) {
        for (String[] hasPermission : strArr) {
            if (!f58907a.hasPermission((Context) activity, hasPermission)) {
                return false;
            }
        }
        return true;
    }

    public static Uri getFileUri(Context context, File file) {
        if (Build.VERSION.SDK_INT < 24) {
            return Uri.fromFile(file);
        }
        return FileProvider.getUriForFile(context, context.getPackageName() + ".file.path.share", file);
    }

    public static Uri getFileUri(Fragment fragment, File file) {
        return getFileUri(fragment.getContext(), file);
    }

    public static Uri getFileUri(android.app.Fragment fragment, File file) {
        return getFileUri(fragment.getActivity(), file);
    }

    public static Uri getFileUri(Activity activity, File file) {
        if (Build.VERSION.SDK_INT < 24) {
            return Uri.fromFile(file);
        }
        return FileProvider.getUriForFile(activity, activity.getPackageName() + ".file.path.share", file);
    }

    /* renamed from: a */
    private static Source m44523a(Context context) {
        if (context instanceof Activity) {
            return new ActivitySource((Activity) context);
        }
        if (context instanceof ContextWrapper) {
            return m44523a(((ContextWrapper) context).getBaseContext());
        }
        return new ContextSource(context);
    }

    private AndPermission() {
    }
}
