package com.yanzhenjie.permission.runtime;

import com.didi.sdk.apm.SystemUtils;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.checker.PermissionChecker;
import com.yanzhenjie.permission.checker.StrictChecker;
import com.yanzhenjie.permission.source.Source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.yanzhenjie.permission.runtime.a */
/* compiled from: LRequest */
class C21721a implements PermissionRequest {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final PermissionChecker f58998a = new StrictChecker();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Source f58999b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String[] f59000c;

    /* renamed from: d */
    private Action<List<String>> f59001d;

    /* renamed from: e */
    private Action<List<String>> f59002e;

    public PermissionRequest rationale(Rationale<List<String>> rationale) {
        return this;
    }

    C21721a(Source source) {
        this.f58999b = source;
    }

    public PermissionRequest permission(String... strArr) {
        this.f59000c = strArr;
        return this;
    }

    public PermissionRequest onGranted(Action<List<String>> action) {
        this.f59001d = action;
        return this;
    }

    public PermissionRequest onDenied(Action<List<String>> action) {
        this.f59002e = action;
        return this;
    }

    public void start() {
        new LRequest$1(this).execute(new Void[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m44621b() {
        if (this.f59001d != null) {
            List asList = Arrays.asList(this.f59000c);
            try {
                this.f59001d.onAction(asList);
            } catch (Exception e) {
                SystemUtils.log(6, "AndPermission", "Please check the onGranted() method body for bugs.", e, "com.yanzhenjie.permission.runtime.LRequest", 100);
                Action<List<String>> action = this.f59002e;
                if (action != null) {
                    action.onAction(asList);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m44619a(List<String> list) {
        Action<List<String>> action = this.f59002e;
        if (action != null) {
            action.onAction(list);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static List<String> m44620b(PermissionChecker permissionChecker, Source source, String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!permissionChecker.hasPermission(source.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
