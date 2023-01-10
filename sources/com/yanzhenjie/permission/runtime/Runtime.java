package com.yanzhenjie.permission.runtime;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;
import com.yanzhenjie.permission.runtime.option.RuntimeOption;
import com.yanzhenjie.permission.runtime.setting.AllRequest;
import com.yanzhenjie.permission.runtime.setting.SettingRequest;
import com.yanzhenjie.permission.source.Source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Runtime implements RuntimeOption {

    /* renamed from: a */
    private static final PermissionRequestFactory f58995a;

    /* renamed from: b */
    private static List<String> f58996b;

    /* renamed from: c */
    private Source f58997c;

    public interface PermissionRequestFactory {
        PermissionRequest create(Source source);
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            f58995a = new MRequestFactory();
        } else {
            f58995a = new LRequestFactory();
        }
    }

    public Runtime(Source source) {
        this.f58997c = source;
    }

    public PermissionRequest permission(String... strArr) {
        m44614a(strArr);
        return f58995a.create(this.f58997c).permission(strArr);
    }

    public PermissionRequest permission(String[]... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String[] strArr2 : strArr) {
            m44614a(strArr2);
            arrayList.addAll(Arrays.asList(strArr2));
        }
        return permission((String[]) arrayList.toArray(new String[0]));
    }

    public SettingRequest setting() {
        return new AllRequest(this.f58997c);
    }

    /* renamed from: a */
    private void m44614a(String... strArr) {
        if (f58996b == null) {
            f58996b = m44613a(this.f58997c.getContext());
        }
        if (strArr.length != 0) {
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str = strArr[i];
                if (f58996b.contains(str) || (Permission.ADD_VOICEMAIL.equals(str) && f58996b.contains("android.permission.ADD_VOICEMAIL"))) {
                    i++;
                } else {
                    throw new IllegalStateException(String.format("The permission %1$s is not registered in manifest.xml", new Object[]{str}));
                }
            }
            return;
        }
        throw new IllegalArgumentException("Please enter at least one permission.");
    }

    /* renamed from: a */
    private static List<String> m44613a(Context context) {
        try {
            String[] strArr = SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null && strArr.length != 0) {
                return Collections.unmodifiableList(Arrays.asList(strArr));
            }
            throw new IllegalStateException("You did not register any permissions in the manifest.xml.");
        } catch (PackageManager.NameNotFoundException unused) {
            throw new AssertionError("Package name cannot be found.");
        }
    }
}
