package com.yanzhenjie.permission.runtime;

import com.didi.sdk.apm.SystemUtils;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.bridge.BridgeRequest;
import com.yanzhenjie.permission.bridge.RequestManager;
import com.yanzhenjie.permission.checker.DoubleChecker;
import com.yanzhenjie.permission.checker.PermissionChecker;
import com.yanzhenjie.permission.checker.StandardChecker;
import com.yanzhenjie.permission.source.Source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.yanzhenjie.permission.runtime.b */
/* compiled from: MRequest */
class C21722b implements RequestExecutor, BridgeRequest.Callback, PermissionRequest {

    /* renamed from: a */
    private static final PermissionChecker f59003a = new StandardChecker();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final PermissionChecker f59004b = new DoubleChecker();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Source f59005c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String[] f59006d;

    /* renamed from: e */
    private Rationale<List<String>> f59007e = new MRequest$1(this);

    /* renamed from: f */
    private Action<List<String>> f59008f;

    /* renamed from: g */
    private Action<List<String>> f59009g;

    /* renamed from: h */
    private String[] f59010h;

    C21722b(Source source) {
        this.f59005c = source;
    }

    public PermissionRequest permission(String... strArr) {
        this.f59006d = strArr;
        return this;
    }

    public PermissionRequest rationale(Rationale<List<String>> rationale) {
        this.f59007e = rationale;
        return this;
    }

    public PermissionRequest onGranted(Action<List<String>> action) {
        this.f59008f = action;
        return this;
    }

    public PermissionRequest onDenied(Action<List<String>> action) {
        this.f59009g = action;
        return this;
    }

    public void start() {
        List<String> b = m44630b(f59003a, this.f59005c, this.f59006d);
        String[] strArr = (String[]) b.toArray(new String[b.size()]);
        this.f59010h = strArr;
        if (strArr.length > 0) {
            List<String> a = m44627a(this.f59005c, strArr);
            if (a.size() > 0) {
                this.f59007e.showRationale(this.f59005c.getContext(), a, this);
            } else {
                execute();
            }
        } else {
            onCallback();
        }
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f59005c);
        bridgeRequest.setType(2);
        bridgeRequest.setPermissions(this.f59010h);
        bridgeRequest.setCallback(this);
        RequestManager.get().add(bridgeRequest);
    }

    public void cancel() {
        onCallback();
    }

    public void onCallback() {
        new MRequest$2(this).execute(new Void[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m44631b() {
        if (this.f59008f != null) {
            List asList = Arrays.asList(this.f59006d);
            try {
                this.f59008f.onAction(asList);
            } catch (Exception e) {
                SystemUtils.log(6, "AndPermission", "Please check the onGranted() method body for bugs.", e, "com.yanzhenjie.permission.runtime.MRequest", 145);
                Action<List<String>> action = this.f59009g;
                if (action != null) {
                    action.onAction(asList);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m44629a(List<String> list) {
        Action<List<String>> action = this.f59009g;
        if (action != null) {
            action.onAction(list);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static List<String> m44630b(PermissionChecker permissionChecker, Source source, String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!permissionChecker.hasPermission(source.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static List<String> m44627a(Source source, String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (source.isShowRationalePermission(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
