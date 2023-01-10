package com.google.android.play.core.splitinstall.testing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.internal.C20029af;
import com.google.android.play.core.internal.C20046aw;
import com.google.android.play.core.internal.C20075by;
import com.google.android.play.core.splitcompat.C20164p;
import com.google.android.play.core.splitinstall.C20195e;
import com.google.android.play.core.splitinstall.C20198h;
import com.google.android.play.core.splitinstall.C20202l;
import com.google.android.play.core.splitinstall.C20207p;
import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class FakeSplitInstallManager implements SplitInstallManager {

    /* renamed from: a */
    public static final /* synthetic */ int f56284a = 0;

    /* renamed from: c */
    private static final long f56285c = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: b */
    private final Handler f56286b;

    /* renamed from: d */
    private final Context f56287d;

    /* renamed from: e */
    private final C20207p f56288e;

    /* renamed from: f */
    private final C20075by f56289f;

    /* renamed from: g */
    private final C20029af<SplitInstallSessionState> f56290g;

    /* renamed from: h */
    private final Executor f56291h;

    /* renamed from: i */
    private final C20195e f56292i;

    /* renamed from: j */
    private final File f56293j;

    /* renamed from: k */
    private final AtomicReference<SplitInstallSessionState> f56294k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final Set<String> f56295l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final Set<String> f56296m;

    /* renamed from: n */
    private final AtomicBoolean f56297n;

    /* renamed from: o */
    private final C20212a f56298o;

    @Deprecated
    public FakeSplitInstallManager(Context context, File file) {
        this(context, file, new C20207p(context, context.getPackageName()));
    }

    FakeSplitInstallManager(Context context, File file, C20207p pVar) {
        Executor a = C20164p.m42452a();
        C20075by byVar = new C20075by(context);
        C20212a aVar = C20212a.f56300a;
        this.f56286b = new Handler(Looper.getMainLooper());
        this.f56294k = new AtomicReference<>();
        this.f56295l = Collections.synchronizedSet(new HashSet());
        this.f56296m = Collections.synchronizedSet(new HashSet());
        this.f56297n = new AtomicBoolean(false);
        this.f56287d = context;
        this.f56293j = file;
        this.f56288e = pVar;
        this.f56291h = a;
        this.f56289f = byVar;
        this.f56298o = aVar;
        this.f56290g = new C20029af<>();
        this.f56292i = C20202l.f56264a;
    }

    /* renamed from: a */
    static final /* synthetic */ SplitInstallSessionState m42557a(int i, SplitInstallSessionState splitInstallSessionState) {
        int status;
        if (splitInstallSessionState != null && i == splitInstallSessionState.sessionId() && ((status = splitInstallSessionState.status()) == 1 || status == 2 || status == 8 || status == 9 || status == 7)) {
            return SplitInstallSessionState.create(i, 7, splitInstallSessionState.errorCode(), splitInstallSessionState.bytesDownloaded(), splitInstallSessionState.totalBytesToDownload(), splitInstallSessionState.moduleNames(), splitInstallSessionState.languages());
        }
        throw new SplitInstallException(-3);
    }

    /* renamed from: a */
    private final synchronized SplitInstallSessionState m42558a(C20221j jVar) {
        SplitInstallSessionState c = m42571c();
        SplitInstallSessionState a = jVar.mo164526a(c);
        if (this.f56294k.compareAndSet(c, a)) {
            return a;
        }
        return null;
    }

    /* renamed from: a */
    static final /* synthetic */ SplitInstallSessionState m42559a(Integer num, int i, int i2, Long l, Long l2, List list, List list2, SplitInstallSessionState splitInstallSessionState) {
        SplitInstallSessionState create = splitInstallSessionState == null ? SplitInstallSessionState.create(0, 0, 0, 0, 0, new ArrayList(), new ArrayList()) : splitInstallSessionState;
        return SplitInstallSessionState.create(num == null ? create.sessionId() : num.intValue(), i, i2, l == null ? create.bytesDownloaded() : l.longValue(), l2 == null ? create.totalBytesToDownload() : l2.longValue(), list == null ? create.moduleNames() : list, list2 == null ? create.languages() : list2);
    }

    /* renamed from: a */
    private static String m42560a(String str) {
        return str.split("\\.config\\.", 2)[0];
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m42565a(List<Intent> list, List<String> list2, List<String> list3, long j, boolean z) {
        List<Intent> list4 = list;
        this.f56292i.mo164511a().mo164283a(list, new C20220i(this, list2, list3, j, z, list));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final boolean m42566a(int i) {
        return m42567a(6, i, (Long) null, (Long) null, (List<String>) null, (Integer) null, (List<String>) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final boolean m42567a(int i, int i2, Long l, Long l2, List<String> list, Integer num, List<String> list2) {
        SplitInstallSessionState a = m42558a((C20221j) new C20213b(num, i, i2, l, l2, list, list2));
        if (a == null) {
            return false;
        }
        m42570b(a);
        return true;
    }

    /* renamed from: b */
    private final void m42570b(SplitInstallSessionState splitInstallSessionState) {
        this.f56286b.post(new C20217f(this, splitInstallSessionState));
    }

    /* renamed from: c */
    private final SplitInstallSessionState m42571c() {
        return this.f56294k.get();
    }

    /* renamed from: d */
    private final C20198h m42572d() {
        C20198h c = this.f56288e.mo164518c();
        if (c != null) {
            return c;
        }
        throw new IllegalStateException("Language information could not be found. Make sure you are using the target application context, not the tests context, and the app is built as a bundle.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final File mo164520a() {
        return this.f56293j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo164521a(long j, List list, List list2, List list3) {
        long j2 = j;
        long j3 = j2 / 3;
        long j4 = 0;
        int i = 0;
        while (i < 3) {
            j4 = Math.min(j2, j4 + j3);
            m42567a(2, 0, Long.valueOf(j4), Long.valueOf(j), (List<String>) null, (Integer) null, (List<String>) null);
            SystemClock.sleep(f56285c);
            SplitInstallSessionState c = m42571c();
            if (c.status() != 9 && c.status() != 7 && c.status() != 6) {
                i++;
            } else {
                return;
            }
        }
        this.f56291h.execute(new C20219h(this, list, list2, list3, j));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo164522a(SplitInstallSessionState splitInstallSessionState) {
        this.f56290g.mo164265a(splitInstallSessionState);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo164523a(List list, List list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            String a = C20046aw.m42171a(file);
            Uri fromFile = Uri.fromFile(file);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(fromFile, this.f56287d.getContentResolver().getType(fromFile));
            intent.addFlags(1);
            intent.putExtra("module_name", m42560a(a));
            intent.putExtra("split_id", a);
            arrayList.add(intent);
            arrayList2.add(m42560a(C20046aw.m42171a(file)));
        }
        SplitInstallSessionState c = m42571c();
        if (c != null) {
            this.f56291h.execute(new C20218g(this, c.totalBytesToDownload(), arrayList, arrayList2, list2));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo164524a(List list, List list2, List list3, long j) {
        if (this.f56297n.get()) {
            m42566a(-6);
        } else {
            m42565a((List<Intent>) list, (List<String>) list2, (List<String>) list3, j, false);
        }
    }

    public final Task<Void> cancelInstall(int i) {
        try {
            SplitInstallSessionState a = m42558a((C20221j) new C20216e(i));
            if (a != null) {
                m42570b(a);
            }
            return Tasks.m42596a(null);
        } catch (SplitInstallException e) {
            return Tasks.m42595a((Exception) e);
        }
    }

    public final Task<Void> deferredInstall(List<String> list) {
        return Tasks.m42595a((Exception) new SplitInstallException(-5));
    }

    public final Task<Void> deferredLanguageInstall(List<Locale> list) {
        return Tasks.m42595a((Exception) new SplitInstallException(-5));
    }

    public final Task<Void> deferredLanguageUninstall(List<Locale> list) {
        return Tasks.m42595a((Exception) new SplitInstallException(-5));
    }

    public final Task<Void> deferredUninstall(List<String> list) {
        return Tasks.m42595a((Exception) new SplitInstallException(-5));
    }

    public final Set<String> getInstalledLanguages() {
        HashSet hashSet = new HashSet();
        if (this.f56288e.mo164517b() != null) {
            hashSet.addAll(this.f56288e.mo164517b());
        }
        hashSet.addAll(this.f56296m);
        return hashSet;
    }

    public final Set<String> getInstalledModules() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.f56288e.mo164516a());
        hashSet.addAll(this.f56295l);
        return hashSet;
    }

    public final Task<SplitInstallSessionState> getSessionState(int i) {
        SplitInstallSessionState c = m42571c();
        return (c == null || c.sessionId() != i) ? Tasks.m42595a((Exception) new SplitInstallException(-4)) : Tasks.m42596a(c);
    }

    public final Task<List<SplitInstallSessionState>> getSessionStates() {
        SplitInstallSessionState c = m42571c();
        return Tasks.m42596a(c != null ? Collections.singletonList(c) : Collections.emptyList());
    }

    public final void registerListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.f56290g.mo164264a(splitInstallStateUpdatedListener);
    }

    public void setShouldNetworkError(boolean z) {
        this.f56297n.set(z);
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, Activity activity, int i) throws IntentSender.SendIntentException {
        return false;
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, IntentSenderForResultStarter intentSenderForResultStarter, int i) throws IntentSender.SendIntentException {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0137, code lost:
        if (r4.contains(r15) == false) goto L_0x013e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.play.core.tasks.Task<java.lang.Integer> startInstall(com.google.android.play.core.splitinstall.SplitInstallRequest r25) {
        /*
            r24 = this;
            r9 = r24
            com.google.android.play.core.splitinstall.testing.d r0 = new com.google.android.play.core.splitinstall.testing.d     // Catch:{ SplitInstallException -> 0x0238 }
            r1 = r25
            r0.<init>(r1)     // Catch:{ SplitInstallException -> 0x0238 }
            com.google.android.play.core.splitinstall.SplitInstallSessionState r0 = r9.m42558a((com.google.android.play.core.splitinstall.testing.C20221j) r0)     // Catch:{ SplitInstallException -> 0x0238 }
            if (r0 == 0) goto L_0x022c
            int r0 = r0.sessionId()     // Catch:{ SplitInstallException -> 0x0238 }
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.List r2 = r25.getLanguages()
            java.util.Iterator r2 = r2.iterator()
        L_0x0020:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0034
            java.lang.Object r3 = r2.next()
            java.util.Locale r3 = (java.util.Locale) r3
            java.lang.String r3 = r3.getLanguage()
            r10.add(r3)
            goto L_0x0020
        L_0x0034:
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.io.File r3 = r9.f56293j
            java.io.File[] r3 = r3.listFiles()
            if (r3 != 0) goto L_0x005e
            r12 = 5
            r15 = 0
            r17 = -1
            java.lang.String r13 = "FakeSplitInstallManager"
            java.lang.String r14 = "Specified splits directory does not exist."
            java.lang.String r16 = "com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager"
            com.didi.sdk.apm.SystemUtils.log(r12, r13, r14, r15, r16, r17)
            com.google.android.play.core.splitinstall.SplitInstallException r0 = new com.google.android.play.core.splitinstall.SplitInstallException
            r1 = -5
            r0.<init>(r1)
            com.google.android.play.core.tasks.Task r0 = com.google.android.play.core.tasks.Tasks.m42595a((java.lang.Exception) r0)
            return r0
        L_0x005e:
            int r4 = r3.length
            r8 = 0
            r12 = 0
        L_0x0062:
            if (r8 >= r4) goto L_0x01a3
            r14 = r3[r8]
            java.lang.String r15 = com.google.android.play.core.internal.C20046aw.m42171a(r14)
            java.lang.String r5 = m42560a((java.lang.String) r15)
            java.util.List r6 = r25.getModuleNames()
            boolean r5 = r6.contains(r5)
            if (r5 == 0) goto L_0x013a
            java.lang.String r5 = m42560a((java.lang.String) r15)
            java.util.HashSet r6 = new java.util.HashSet
            com.google.android.play.core.internal.by r7 = r9.f56289f
            java.util.List r7 = r7.mo164318a()
            r6.<init>(r7)
            com.google.android.play.core.splitinstall.h r7 = r24.m42572d()
            r1 = 1
            java.lang.String[] r1 = new java.lang.String[r1]
            r18 = 0
            r1[r18] = r5
            java.util.List r1 = java.util.Arrays.asList(r1)
            java.util.Map r1 = r7.mo164514a(r1)
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>()
            java.util.Collection r7 = r1.values()
            java.util.Iterator r7 = r7.iterator()
        L_0x00a7:
            boolean r19 = r7.hasNext()
            if (r19 == 0) goto L_0x00bd
            java.lang.Object r19 = r7.next()
            r20 = r3
            r3 = r19
            java.util.Set r3 = (java.util.Set) r3
            r5.addAll(r3)
            r3 = r20
            goto L_0x00a7
        L_0x00bd:
            r20 = r3
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.Iterator r6 = r6.iterator()
        L_0x00c8:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00f4
            java.lang.Object r7 = r6.next()
            java.lang.String r7 = (java.lang.String) r7
            r19 = r4
            java.lang.String r4 = "_"
            boolean r21 = r7.contains(r4)
            if (r21 == 0) goto L_0x00e9
            r21 = r6
            r6 = -1
            java.lang.String[] r4 = r7.split(r4, r6)
            r6 = 0
            r7 = r4[r6]
            goto L_0x00ec
        L_0x00e9:
            r21 = r6
            r6 = 0
        L_0x00ec:
            r3.add(r7)
            r4 = r19
            r6 = r21
            goto L_0x00c8
        L_0x00f4:
            r19 = r4
            r6 = 0
            java.util.Set<java.lang.String> r4 = r9.f56296m
            r3.addAll(r4)
            r3.addAll(r10)
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x010c:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x012d
            java.lang.Object r7 = r1.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r6 = r7.getKey()
            boolean r6 = r3.contains(r6)
            if (r6 == 0) goto L_0x012b
            java.lang.Object r6 = r7.getValue()
            java.util.Collection r6 = (java.util.Collection) r6
            r4.addAll(r6)
        L_0x012b:
            r6 = 0
            goto L_0x010c
        L_0x012d:
            boolean r1 = r5.contains(r15)
            if (r1 == 0) goto L_0x018a
            boolean r1 = r4.contains(r15)
            if (r1 == 0) goto L_0x013e
            goto L_0x018a
        L_0x013a:
            r20 = r3
            r19 = r4
        L_0x013e:
            java.util.List r1 = r25.getLanguages()
            java.util.ArrayList r3 = new java.util.ArrayList
            java.util.Set<java.lang.String> r4 = r9.f56295l
            r3.<init>(r4)
            java.lang.String r4 = ""
            java.lang.String r5 = "base"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5}
            java.util.List r4 = java.util.Arrays.asList(r4)
            r3.addAll(r4)
            com.google.android.play.core.splitinstall.h r4 = r24.m42572d()
            java.util.Map r3 = r4.mo164514a(r3)
            java.util.Iterator r1 = r1.iterator()
        L_0x0164:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0199
            java.lang.Object r4 = r1.next()
            java.util.Locale r4 = (java.util.Locale) r4
            java.lang.String r5 = r4.getLanguage()
            boolean r5 = r3.containsKey(r5)
            if (r5 == 0) goto L_0x0164
            java.lang.String r4 = r4.getLanguage()
            java.lang.Object r4 = r3.get(r4)
            java.util.Set r4 = (java.util.Set) r4
            boolean r4 = r4.contains(r15)
            if (r4 == 0) goto L_0x0164
        L_0x018a:
            long r3 = r14.length()
            long r12 = r12 + r3
            java.lang.String r1 = com.google.android.play.core.internal.C20046aw.m42171a(r14)
            r2.add(r1)
            r11.add(r14)
        L_0x0199:
            int r8 = r8 + 1
            r1 = r25
            r4 = r19
            r3 = r20
            goto L_0x0062
        L_0x01a3:
            java.lang.String r1 = java.lang.String.valueOf(r2)
            java.util.List r3 = r25.getModuleNames()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = java.lang.String.valueOf(r1)
            int r4 = r4.length()
            java.lang.String r5 = java.lang.String.valueOf(r3)
            int r5 = r5.length()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            int r4 = r4 + 21
            int r4 = r4 + r5
            r6.<init>(r4)
            java.lang.String r4 = "availableSplits"
            r6.append(r4)
            r6.append(r1)
            java.lang.String r1 = " want "
            r6.append(r1)
            r6.append(r3)
            java.lang.String r20 = r6.toString()
            r18 = 4
            r21 = 0
            r23 = -1
            java.lang.String r19 = "FakeSplitInstallManager"
            java.lang.String r22 = "com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager"
            com.didi.sdk.apm.SystemUtils.log(r18, r19, r20, r21, r22, r23)
            java.util.HashSet r1 = new java.util.HashSet
            java.util.List r3 = r25.getModuleNames()
            r1.<init>(r3)
            boolean r1 = r2.containsAll(r1)
            if (r1 != 0) goto L_0x0202
            com.google.android.play.core.splitinstall.SplitInstallException r0 = new com.google.android.play.core.splitinstall.SplitInstallException
            r1 = -2
            r0.<init>(r1)
            com.google.android.play.core.tasks.Task r0 = com.google.android.play.core.tasks.Tasks.m42595a((java.lang.Exception) r0)
            return r0
        L_0x0202:
            r1 = 0
            java.lang.Long r4 = java.lang.Long.valueOf(r1)
            java.lang.Long r5 = java.lang.Long.valueOf(r12)
            java.util.List r6 = r25.getModuleNames()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2 = 1
            r3 = 0
            r1 = r24
            r7 = r0
            r8 = r10
            r1.m42567a(r2, r3, r4, r5, r6, r7, r8)
            java.util.concurrent.Executor r1 = r9.f56291h
            com.google.android.play.core.splitinstall.testing.c r2 = new com.google.android.play.core.splitinstall.testing.c
            r2.<init>(r9, r11, r10)
            r1.execute(r2)
            com.google.android.play.core.tasks.Task r0 = com.google.android.play.core.tasks.Tasks.m42596a(r0)
            return r0
        L_0x022c:
            com.google.android.play.core.splitinstall.SplitInstallException r0 = new com.google.android.play.core.splitinstall.SplitInstallException     // Catch:{ SplitInstallException -> 0x0238 }
            r1 = -100
            r0.<init>(r1)     // Catch:{ SplitInstallException -> 0x0238 }
            com.google.android.play.core.tasks.Task r0 = com.google.android.play.core.tasks.Tasks.m42595a((java.lang.Exception) r0)     // Catch:{ SplitInstallException -> 0x0238 }
            return r0
        L_0x0238:
            r0 = move-exception
            com.google.android.play.core.tasks.Task r0 = com.google.android.play.core.tasks.Tasks.m42595a((java.lang.Exception) r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager.startInstall(com.google.android.play.core.splitinstall.SplitInstallRequest):com.google.android.play.core.tasks.Task");
    }

    public final void unregisterListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.f56290g.mo164266b(splitInstallStateUpdatedListener);
    }
}
