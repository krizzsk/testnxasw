package com.didi.dimina.container.secondparty.permission.runtime;

import com.didi.dimina.container.secondparty.permission.Action;
import com.didi.dimina.container.secondparty.permission.Rationale;
import com.didi.dimina.container.secondparty.permission.RequestExecutor;
import com.didi.dimina.container.secondparty.permission.bridge.BridgeRequest;
import com.didi.dimina.container.secondparty.permission.bridge.RequestManager;
import com.didi.dimina.container.secondparty.permission.checker.DoubleChecker;
import com.didi.dimina.container.secondparty.permission.checker.PermissionChecker;
import com.didi.dimina.container.secondparty.permission.checker.StandardChecker;
import com.didi.dimina.container.secondparty.permission.source.Source;
import com.didi.dimina.container.util.LogUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.didi.dimina.container.secondparty.permission.runtime.b */
/* compiled from: MRequest */
class C8214b implements RequestExecutor, BridgeRequest.Callback, PermissionRequest {

    /* renamed from: a */
    private static final PermissionChecker f19282a = new StandardChecker();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final PermissionChecker f19283b = new DoubleChecker();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Source f19284c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String[] f19285d;

    /* renamed from: e */
    private Rationale<List<String>> f19286e = new MRequest$1(this);

    /* renamed from: f */
    private Action<List<String>> f19287f;

    /* renamed from: g */
    private Action<List<String>> f19288g;

    /* renamed from: h */
    private String[] f19289h;

    C8214b(Source source) {
        this.f19284c = source;
    }

    public PermissionRequest permission(String... strArr) {
        this.f19285d = strArr;
        return this;
    }

    public PermissionRequest rationale(Rationale<List<String>> rationale) {
        this.f19286e = rationale;
        return this;
    }

    public PermissionRequest onGranted(Action<List<String>> action) {
        this.f19287f = action;
        return this;
    }

    public PermissionRequest onDenied(Action<List<String>> action) {
        this.f19288g = action;
        return this;
    }

    public void start() {
        List<String> b = m16384b(f19282a, this.f19284c, this.f19285d);
        String[] strArr = (String[]) b.toArray(new String[b.size()]);
        this.f19289h = strArr;
        if (strArr.length > 0) {
            List<String> a = m16381a(this.f19284c, strArr);
            if (a.size() > 0) {
                this.f19286e.showRationale(this.f19284c.getContext(), a, this);
            } else {
                execute();
            }
        } else {
            onCallback();
        }
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f19284c);
        bridgeRequest.setType(2);
        bridgeRequest.setPermissions(this.f19289h);
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
    public void m16385b() {
        if (this.f19287f != null) {
            List asList = Arrays.asList(this.f19285d);
            try {
                this.f19287f.onAction(asList);
            } catch (Exception e) {
                LogUtil.m16840e("AndPermission", "Please check the onGranted() method body for bugs." + e);
                Action<List<String>> action = this.f19288g;
                if (action != null) {
                    action.onAction(asList);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16383a(List<String> list) {
        Action<List<String>> action = this.f19288g;
        if (action != null) {
            action.onAction(list);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static List<String> m16384b(PermissionChecker permissionChecker, Source source, String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!permissionChecker.hasPermission(source.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static List<String> m16381a(Source source, String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (source.isShowRationalePermission(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
