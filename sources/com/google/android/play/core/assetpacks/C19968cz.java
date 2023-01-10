package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import com.google.android.play.core.common.LocalTestingException;
import com.google.android.play.core.internal.C20030ag;
import com.google.android.play.core.internal.C20046aw;
import com.google.android.play.core.internal.C20088ck;
import com.google.android.play.core.internal.C20098i;
import com.google.android.play.core.tasks.C20237i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.play.core.assetpacks.cz */
final class C19968cz implements C20013w {

    /* renamed from: a */
    private static final C20030ag f55908a = new C20030ag("FakeAssetPackService");

    /* renamed from: h */
    private static final AtomicInteger f55909h = new AtomicInteger(1);

    /* renamed from: b */
    private final String f55910b;

    /* renamed from: c */
    private final C19911aw f55911c;

    /* renamed from: d */
    private final C19941bz f55912d;

    /* renamed from: e */
    private final Context f55913e;

    /* renamed from: f */
    private final C19981dl f55914f;

    /* renamed from: g */
    private final C20088ck<Executor> f55915g;

    /* renamed from: i */
    private final Handler f55916i = new Handler(Looper.getMainLooper());

    C19968cz(File file, C19911aw awVar, C19941bz bzVar, Context context, C19981dl dlVar, C20088ck<Executor> ckVar) {
        this.f55910b = file.getAbsolutePath();
        this.f55911c = awVar;
        this.f55912d = bzVar;
        this.f55913e = context;
        this.f55914f = dlVar;
        this.f55915g = ckVar;
    }

    /* renamed from: a */
    static long m41989a(int i, long j) {
        if (i == 2) {
            return j / 2;
        }
        if (i == 3 || i == 4) {
            return j;
        }
        return 0;
    }

    /* renamed from: a */
    private final AssetPackState m41990a(String str, int i) throws LocalTestingException {
        long j = 0;
        for (File length : m41993b(str)) {
            j += length.length();
        }
        return AssetPackState.m41802a(str, i, 0, m41989a(i, j), j, this.f55912d.mo164158b(str), 1);
    }

    /* renamed from: a */
    private static String m41991a(File file) throws LocalTestingException {
        try {
            return C19971db.m42013a((List<File>) Arrays.asList(new File[]{file}));
        } catch (NoSuchAlgorithmException e) {
            throw new LocalTestingException("SHA256 algorithm not supported.", e);
        } catch (IOException e2) {
            throw new LocalTestingException(String.format("Could not digest file: %s.", new Object[]{file}), e2);
        }
    }

    /* renamed from: a */
    private final void m41992a(int i, String str, int i2) throws LocalTestingException {
        Bundle bundle = new Bundle();
        bundle.putInt("app_version_code", this.f55914f.mo164199a());
        bundle.putInt("session_id", i);
        File[] b = m41993b(str);
        ArrayList arrayList = new ArrayList();
        long j = 0;
        for (File file : b) {
            j += file.length();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(i2 == 3 ? new Intent().setData(Uri.EMPTY) : null);
            String a = C20046aw.m42171a(file);
            bundle.putParcelableArrayList(C20098i.m42302a("chunk_intents", str, a), arrayList2);
            bundle.putString(C20098i.m42302a("uncompressed_hash_sha256", str, a), m41991a(file));
            bundle.putLong(C20098i.m42302a("uncompressed_size", str, a), file.length());
            arrayList.add(a);
        }
        bundle.putStringArrayList(C20098i.m42301a("slice_ids", str), arrayList);
        bundle.putLong(C20098i.m42301a("pack_version", str), (long) this.f55914f.mo164199a());
        bundle.putInt(C20098i.m42301a("status", str), i2);
        bundle.putInt(C20098i.m42301a("error_code", str), 0);
        bundle.putLong(C20098i.m42301a("bytes_downloaded", str), m41989a(i2, j));
        bundle.putLong(C20098i.m42301a("total_bytes_to_download", str), j);
        bundle.putStringArrayList("pack_names", new ArrayList(Arrays.asList(new String[]{str})));
        bundle.putLong("bytes_downloaded", m41989a(i2, j));
        bundle.putLong("total_bytes_to_download", j);
        this.f55916i.post(new C19967cy(this, new Intent("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE").putExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE", bundle)));
    }

    /* renamed from: b */
    private final File[] m41993b(String str) throws LocalTestingException {
        File file = new File(this.f55910b);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles(new C19966cx(str));
            if (listFiles != null) {
                if (r1 != 0) {
                    for (File a : listFiles) {
                        if (C20046aw.m42171a(a).equals(str)) {
                            return listFiles;
                        }
                    }
                    throw new LocalTestingException(String.format("No master slice available for pack '%s'.", new Object[]{str}));
                }
                throw new LocalTestingException(String.format("No APKs available for pack '%s'.", new Object[]{str}));
            }
            throw new LocalTestingException(String.format("Failed fetching APKs for pack '%s'.", new Object[]{str}));
        }
        throw new LocalTestingException(String.format("Local testing directory '%s' not found.", new Object[]{file}));
    }

    /* renamed from: a */
    public final Task<AssetPackStates> mo164074a(List<String> list, C19914az azVar, Map<String, Long> map) {
        f55908a.mo164270c("getPackStates(%s)", list);
        C20237i iVar = new C20237i();
        this.f55915g.mo164325a().execute(new C19964cv(this, list, azVar, iVar));
        return iVar.mo164553a();
    }

    /* renamed from: a */
    public final Task<AssetPackStates> mo164075a(List<String> list, List<String> list2, Map<String, Long> map) {
        f55908a.mo164270c("startDownload(%s)", list2);
        C20237i iVar = new C20237i();
        this.f55915g.mo164325a().execute(new C19963cu(this, list2, iVar, list));
        return iVar.mo164553a();
    }

    /* renamed from: a */
    public final Task<List<String>> mo164076a(Map<String, Long> map) {
        f55908a.mo164270c("syncPacks()", new Object[0]);
        return Tasks.m42596a(new ArrayList());
    }

    /* renamed from: a */
    public final void mo164077a() {
        f55908a.mo164270c("keepAlive", new Object[0]);
    }

    /* renamed from: a */
    public final void mo164078a(int i) {
        f55908a.mo164270c("notifySessionFailed", new Object[0]);
    }

    /* renamed from: a */
    public final void mo164079a(int i, String str) {
        f55908a.mo164270c("notifyModuleCompleted", new Object[0]);
        this.f55915g.mo164325a().execute(new C19965cw(this, i, str));
    }

    /* renamed from: a */
    public final void mo164080a(int i, String str, String str2, int i2) {
        f55908a.mo164270c("notifyChunkTransferred", new Object[0]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo164183a(Intent intent) {
        this.f55911c.mo163986a(this.f55913e, intent);
    }

    /* renamed from: a */
    public final void mo164081a(String str) {
        f55908a.mo164270c("removePack(%s)", str);
    }

    /* renamed from: a */
    public final void mo164082a(List<String> list) {
        f55908a.mo164270c("cancelDownload(%s)", list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo164184a(List list, C19914az azVar, C20237i iVar) {
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                AssetPackState a = m41990a(str, azVar.mo164090a(8, str));
                j += a.totalBytesToDownload();
                hashMap.put(str, a);
            } catch (LocalTestingException e) {
                iVar.mo164554a((Exception) e);
                return;
            }
        }
        iVar.mo164555a(AssetPackStates.m41804a(j, (Map<String, AssetPackState>) hashMap));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo164185a(List list, C20237i iVar, List list2) {
        C20237i iVar2 = iVar;
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                AssetPackState a = m41990a(str, 1);
                j += a.totalBytesToDownload();
                hashMap.put(str, a);
            } catch (LocalTestingException e) {
                iVar2.mo164554a((Exception) e);
                return;
            }
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            try {
                int andIncrement = f55909h.getAndIncrement();
                m41992a(andIncrement, str2, 1);
                m41992a(andIncrement, str2, 2);
                m41992a(andIncrement, str2, 3);
            } catch (LocalTestingException e2) {
                iVar2.mo164554a((Exception) e2);
                return;
            }
        }
        Iterator it3 = list2.iterator();
        while (it3.hasNext()) {
            String str3 = (String) it3.next();
            hashMap.put(str3, AssetPackState.m41802a(str3, 4, 0, 0, 0, 0.0d, 1));
        }
        iVar2.mo164555a(AssetPackStates.m41804a(j, (Map<String, AssetPackState>) hashMap));
    }

    /* renamed from: b */
    public final Task<ParcelFileDescriptor> mo164083b(int i, String str, String str2, int i2) {
        f55908a.mo164270c("getChunkFileDescriptor(session=%d, %s, %s, %d)", Integer.valueOf(i), str, str2, Integer.valueOf(i2));
        C20237i iVar = new C20237i();
        try {
            for (File file : m41993b(str)) {
                if (C20046aw.m42171a(file).equals(str2)) {
                    iVar.mo164555a(ParcelFileDescriptor.open(file, 268435456));
                    return iVar.mo164553a();
                }
            }
            throw new LocalTestingException(String.format("Local testing slice for '%s' not found.", new Object[]{str2}));
        } catch (FileNotFoundException e) {
            f55908a.mo164271d("getChunkFileDescriptor failed", e);
            iVar.mo164554a((Exception) new LocalTestingException("Asset Slice file not found.", e));
        } catch (LocalTestingException e2) {
            f55908a.mo164271d("getChunkFileDescriptor failed", e2);
            iVar.mo164554a((Exception) e2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo164186b(int i, String str) {
        try {
            m41992a(i, str, 4);
        } catch (LocalTestingException e) {
            f55908a.mo164271d("notifyModuleCompleted failed", e);
        }
    }
}
