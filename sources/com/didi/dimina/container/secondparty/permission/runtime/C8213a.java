package com.didi.dimina.container.secondparty.permission.runtime;

import com.didi.dimina.container.secondparty.permission.Action;
import com.didi.dimina.container.secondparty.permission.Rationale;
import com.didi.dimina.container.secondparty.permission.checker.PermissionChecker;
import com.didi.dimina.container.secondparty.permission.checker.StrictChecker;
import com.didi.dimina.container.secondparty.permission.source.Source;
import com.didi.dimina.container.util.LogUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.didi.dimina.container.secondparty.permission.runtime.a */
/* compiled from: LRequest */
class C8213a implements PermissionRequest {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final PermissionChecker f19277a = new StrictChecker();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Source f19278b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String[] f19279c;

    /* renamed from: d */
    private Action<List<String>> f19280d;

    /* renamed from: e */
    private Action<List<String>> f19281e;

    public PermissionRequest rationale(Rationale<List<String>> rationale) {
        return this;
    }

    C8213a(Source source) {
        this.f19278b = source;
    }

    public PermissionRequest permission(String... strArr) {
        this.f19279c = strArr;
        return this;
    }

    public PermissionRequest onGranted(Action<List<String>> action) {
        this.f19280d = action;
        return this;
    }

    public PermissionRequest onDenied(Action<List<String>> action) {
        this.f19281e = action;
        return this;
    }

    public void start() {
        new LRequest$1(this).execute(new Void[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m16375b() {
        if (this.f19280d != null) {
            List asList = Arrays.asList(this.f19279c);
            try {
                this.f19280d.onAction(asList);
            } catch (Exception e) {
                LogUtil.m16840e("AndPermission", "Please check the onGranted() method body for bugs." + e);
                Action<List<String>> action = this.f19281e;
                if (action != null) {
                    action.onAction(asList);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16373a(List<String> list) {
        Action<List<String>> action = this.f19281e;
        if (action != null) {
            action.onAction(list);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static List<String> m16374b(PermissionChecker permissionChecker, Source source, String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!permissionChecker.hasPermission(source.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
