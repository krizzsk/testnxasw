package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.pm.PackageManager;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.play.core.internal.C20046aw;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.play.core.splitcompat.c */
public final class C20151c {

    /* renamed from: a */
    private final long f56164a;

    /* renamed from: b */
    private final Context f56165b;

    /* renamed from: c */
    private File f56166c;

    public C20151c(Context context) throws PackageManager.NameNotFoundException {
        this.f56165b = context;
        this.f56164a = (long) SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionCode;
    }

    /* renamed from: a */
    private static File m42414a(File file, String str) throws IOException {
        File file2 = new File(file, str);
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
            return file2;
        }
        throw new IllegalArgumentException("split ID cannot be placed in target directory");
    }

    /* renamed from: c */
    public static void m42415c(File file) throws IOException {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File c : listFiles) {
                m42415c(c);
            }
        }
        if (file.exists() && !file.delete()) {
            throw new IOException(String.format("Failed to delete '%s'", new Object[]{file.getAbsolutePath()}));
        }
    }

    /* renamed from: d */
    private static void m42416d(File file) throws IOException {
        if (!file.exists()) {
            file.mkdirs();
            if (!file.isDirectory()) {
                String valueOf = String.valueOf(file.getAbsolutePath());
                throw new IOException(valueOf.length() != 0 ? "Unable to create directory: ".concat(valueOf) : new String("Unable to create directory: "));
            }
        } else if (!file.isDirectory()) {
            throw new IllegalArgumentException("File input must be directory when it exists.");
        }
    }

    /* renamed from: f */
    private final File m42417f() throws IOException {
        File file = new File(m42418g(), "verified-splits");
        m42416d(file);
        return file;
    }

    /* renamed from: g */
    private final File m42418g() throws IOException {
        File file = new File(m42420h(), Long.toString(this.f56164a));
        m42416d(file);
        return file;
    }

    /* renamed from: g */
    private final File m42419g(String str) throws IOException {
        File a = m42414a(m42422i(), str);
        m42416d(a);
        return a;
    }

    /* renamed from: h */
    private final File m42420h() throws IOException {
        if (this.f56166c == null) {
            Context context = this.f56165b;
            if (context != null) {
                this.f56166c = context.getFilesDir();
            } else {
                throw new IllegalStateException("context must be non-null to populate null filesDir");
            }
        }
        File file = new File(this.f56166c, "splitcompat");
        m42416d(file);
        return file;
    }

    /* renamed from: h */
    private static String m42421h(String str) {
        return String.valueOf(str).concat(".apk");
    }

    /* renamed from: i */
    private final File m42422i() throws IOException {
        File file = new File(m42418g(), "native-libraries");
        m42416d(file);
        return file;
    }

    /* renamed from: a */
    public final File mo164432a(File file) throws IOException {
        return m42414a(m42417f(), file.getName());
    }

    /* renamed from: a */
    public final File mo164433a(String str) throws IOException {
        return m42414a(mo164439c(), m42421h(str));
    }

    /* renamed from: a */
    public final File mo164434a(String str, String str2) throws IOException {
        return m42414a(m42419g(str), str2);
    }

    /* renamed from: a */
    public final void mo164435a() throws IOException {
        File h = m42420h();
        String[] list = h.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals(Long.toString(this.f56164a))) {
                    File file = new File(h, str);
                    String valueOf = String.valueOf(file);
                    long j = this.f56164a;
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118);
                    sb.append("FileStorage: removing directory for different version code (directory = ");
                    sb.append(valueOf);
                    sb.append(", current version code = ");
                    sb.append(j);
                    sb.append(")");
                    SystemUtils.log(3, "SplitCompat", sb.toString(), (Throwable) null, "com.google.android.play.core.splitcompat.c", -1);
                    m42415c(file);
                }
            }
        }
    }

    /* renamed from: b */
    public final File mo164436b() throws IOException {
        return new File(m42418g(), "lock.tmp");
    }

    /* renamed from: b */
    public final File mo164437b(String str) throws IOException {
        return m42414a(m42417f(), m42421h(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo164438b(File file) throws IOException {
        C20046aw.m42173a(file.getParentFile().getParentFile().equals(m42422i()), (Object) "File to remove is not a native library");
        m42415c(file);
    }

    /* renamed from: c */
    public final File mo164439c() throws IOException {
        File file = new File(m42418g(), "unverified-splits");
        m42416d(file);
        return file;
    }

    /* renamed from: c */
    public final File mo164440c(String str) throws IOException {
        File file = new File(m42418g(), "dex");
        m42416d(file);
        File a = m42414a(file, str);
        m42416d(a);
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final Set<C20165q> mo164441d() throws IOException {
        File f = m42417f();
        HashSet hashSet = new HashSet();
        File[] listFiles = f.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile() && file.getName().endsWith(".apk")) {
                    String name = file.getName();
                    hashSet.add(new C20165q(file, name.substring(0, name.length() - 4)));
                }
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo164442d(String str) throws IOException {
        m42415c(m42419g(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final List<String> mo164443e() throws IOException {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = m42422i().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    arrayList.add(file.getName());
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final Set<File> mo164444e(String str) throws IOException {
        HashSet hashSet = new HashSet();
        File[] listFiles = m42419g(str).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile()) {
                    hashSet.add(file);
                }
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final void mo164445f(String str) throws IOException {
        m42415c(mo164437b(str));
    }
}
