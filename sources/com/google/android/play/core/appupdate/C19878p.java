package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.C20030ag;
import com.google.android.play.core.internal.C20031ah;
import com.google.android.play.core.internal.C20040aq;
import com.google.android.play.core.internal.C20076bz;
import com.google.android.play.core.internal.C20104o;
import com.google.android.play.core.splitcompat.C20164p;
import com.google.android.play.core.tasks.C20237i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;

/* renamed from: com.google.android.play.core.appupdate.p */
final class C19878p {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final C20030ag f55577b = new C20030ag("AppUpdateService");

    /* renamed from: c */
    private static final Intent f55578c = new Intent("com.google.android.play.core.install.BIND_UPDATE_SERVICE").setPackage("com.android.vending");

    /* renamed from: a */
    C20040aq<C20104o> f55579a;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final String f55580d;

    /* renamed from: e */
    private final Context f55581e;

    /* renamed from: f */
    private final C19880r f55582f;

    public C19878p(Context context, C19880r rVar) {
        this.f55580d = context.getPackageName();
        this.f55581e = context;
        this.f55582f = rVar;
        if (C20076bz.m42267a(context)) {
            this.f55579a = new C20040aq(C20164p.m42450a(context), f55577b, "AppUpdateService", f55578c, C19872j.f55565a);
        }
    }

    /* renamed from: a */
    static /* synthetic */ Bundle m41769a(C19878p pVar, String str) {
        Integer num;
        Bundle bundle = new Bundle();
        bundle.putAll(m41775d());
        bundle.putString("package.name", str);
        try {
            num = Integer.valueOf(SystemUtils.getPackageInfo(pVar.f55581e.getPackageManager(), pVar.f55581e.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            f55577b.mo164269b("The current version of the app could not be retrieved", new Object[0]);
            num = null;
        }
        if (num != null) {
            bundle.putInt("app.version.code", num.intValue());
        }
        return bundle;
    }

    /* renamed from: a */
    static /* synthetic */ AppUpdateInfo m41770a(C19878p pVar, Bundle bundle, String str) {
        Bundle bundle2 = bundle;
        return AppUpdateInfo.m41745a(str, bundle2.getInt("version.code", -1), bundle2.getInt("update.availability"), bundle2.getInt("install.status", 0), bundle2.getInt("client.version.staleness", -1) == -1 ? null : Integer.valueOf(bundle2.getInt("client.version.staleness")), bundle2.getInt("in.app.update.priority", 0), bundle2.getLong("bytes.downloaded"), bundle2.getLong("total.bytes.to.download"), bundle2.getLong("additional.size.required"), pVar.f55582f.mo163998a(), (PendingIntent) bundle2.getParcelable("blocking.intent"), (PendingIntent) bundle2.getParcelable("nonblocking.intent"), (PendingIntent) bundle2.getParcelable("blocking.destructive.intent"), (PendingIntent) bundle2.getParcelable("nonblocking.destructive.intent"));
    }

    /* renamed from: c */
    private static <T> Task<T> m41774c() {
        f55577b.mo164269b("onError(%d)", -9);
        return Tasks.m42595a((Exception) new InstallException(-9));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static Bundle m41775d() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore.version.code", 10802);
        return bundle;
    }

    /* renamed from: a */
    public final Task<AppUpdateInfo> mo163996a(String str) {
        if (this.f55579a == null) {
            return m41774c();
        }
        f55577b.mo164270c("requestUpdateInfo(%s)", str);
        C20237i iVar = new C20237i();
        this.f55579a.mo164279a((C20031ah) new C19873k(this, iVar, str, iVar));
        return iVar.mo164553a();
    }

    /* renamed from: b */
    public final Task<Void> mo163997b(String str) {
        if (this.f55579a == null) {
            return m41774c();
        }
        f55577b.mo164270c("completeUpdate(%s)", str);
        C20237i iVar = new C20237i();
        this.f55579a.mo164279a((C20031ah) new C19874l(this, iVar, iVar, str));
        return iVar.mo164553a();
    }
}
