package p218io.flutter.embedding.engine.loader;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import p218io.flutter.Log;

/* renamed from: io.flutter.embedding.engine.loader.ResourceExtractor */
class ResourceExtractor {

    /* renamed from: a */
    private static final String f60427a = "ResourceExtractor";

    /* renamed from: b */
    private static final String f60428b = "res_timestamp-";

    /* renamed from: c */
    private static final String[] f60429c = m45587c();

    /* renamed from: d */
    private final String f60430d;

    /* renamed from: e */
    private final String f60431e;

    /* renamed from: f */
    private final PackageManager f60432f;

    /* renamed from: g */
    private final AssetManager f60433g;

    /* renamed from: h */
    private final HashSet<String> f60434h = new HashSet<>();

    /* renamed from: i */
    private ExtractTask f60435i;

    /* renamed from: a */
    static long m45579a(PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return packageInfo.getLongVersionCode();
        }
        return (long) packageInfo.versionCode;
    }

    /* renamed from: io.flutter.embedding.engine.loader.ResourceExtractor$ExtractTask */
    private static class ExtractTask extends AsyncTask<Void, Void, Void> {
        private final AssetManager mAssetManager;
        private final String mDataDirPath;
        private final PackageManager mPackageManager;
        private final String mPackageName;
        private final HashSet<String> mResources;

        ExtractTask(String str, HashSet<String> hashSet, String str2, PackageManager packageManager, AssetManager assetManager) {
            this.mDataDirPath = str;
            this.mResources = hashSet;
            this.mAssetManager = assetManager;
            this.mPackageName = str2;
            this.mPackageManager = packageManager;
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... voidArr) {
            File file = new File(this.mDataDirPath);
            String a = ResourceExtractor.m45584b(file, this.mPackageManager, this.mPackageName);
            if (a == null) {
                return null;
            }
            ResourceExtractor.m45586b(this.mDataDirPath, this.mResources);
            if (extractAPK(file) && a != null) {
                try {
                    new File(file, a).createNewFile();
                } catch (IOException unused) {
                    Log.m45261w(ResourceExtractor.f60427a, "Failed to write resource timestamp");
                }
            }
            return null;
        }

        private boolean extractAPK(File file) {
            FileOutputStream fileOutputStream;
            Iterator<String> it = this.mResources.iterator();
            while (it.hasNext()) {
                String next = it.next();
                try {
                    File file2 = new File(file, next);
                    if (!file2.exists()) {
                        if (file2.getParentFile() != null) {
                            file2.getParentFile().mkdirs();
                        }
                        InputStream open = this.mAssetManager.open(next);
                        try {
                            fileOutputStream = new FileOutputStream(file2);
                            ResourceExtractor.m45585b(open, (OutputStream) fileOutputStream);
                            fileOutputStream.close();
                            if (open != null) {
                                open.close();
                            }
                        } catch (Throwable th) {
                            if (open != null) {
                                open.close();
                            }
                            throw th;
                        }
                    }
                } catch (FileNotFoundException unused) {
                } catch (IOException e) {
                    Log.m45261w(ResourceExtractor.f60427a, "Exception unpacking resources: " + e.getMessage());
                    ResourceExtractor.m45586b(this.mDataDirPath, this.mResources);
                    return false;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            return true;
            throw th;
        }
    }

    ResourceExtractor(String str, String str2, PackageManager packageManager, AssetManager assetManager) {
        this.f60430d = str;
        this.f60431e = str2;
        this.f60432f = packageManager;
        this.f60433g = assetManager;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ResourceExtractor mo182344a(String str) {
        this.f60434h.add(str);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ResourceExtractor mo182345a(Collection<String> collection) {
        this.f60434h.addAll(collection);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ResourceExtractor mo182343a() {
        ExtractTask extractTask = new ExtractTask(this.f60430d, this.f60434h, this.f60431e, this.f60432f, this.f60433g);
        this.f60435i = extractTask;
        extractTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo182346b() {
        ExtractTask extractTask = this.f60435i;
        if (extractTask != null) {
            try {
                extractTask.get();
            } catch (InterruptedException | CancellationException | ExecutionException unused) {
                m45586b(this.f60430d, this.f60434h);
            }
        }
    }

    /* renamed from: a */
    private static String[] m45583a(File file) {
        return file.list(new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.startsWith(ResourceExtractor.f60428b);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m45586b(String str, HashSet<String> hashSet) {
        File file = new File(str);
        Iterator<String> it = hashSet.iterator();
        while (it.hasNext()) {
            File file2 = new File(file, it.next());
            if (file2.exists()) {
                file2.delete();
            }
        }
        String[] a = m45583a(file);
        if (a != null) {
            for (String file3 : a) {
                new File(file, file3).delete();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m45584b(File file, PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = SystemUtils.getPackageInfo(packageManager, str, 0);
            if (packageInfo == null) {
                return f60428b;
            }
            String str2 = f60428b + m45579a(packageInfo) + "-" + packageInfo.lastUpdateTime;
            String[] a = m45583a(file);
            if (a == null) {
                return str2;
            }
            int length = a.length;
            if (a.length != 1 || !str2.equals(a[0])) {
                return str2;
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return f60428b;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m45585b(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[16384];
        while (true) {
            int read = inputStream.read(bArr);
            if (read >= 0) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    /* renamed from: c */
    private static String[] m45587c() {
        if (Build.VERSION.SDK_INT >= 21) {
            return Build.SUPPORTED_ABIS;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{Build.CPU_ABI, Build.CPU_ABI2}));
        arrayList.removeAll(Arrays.asList(new String[]{null, ""}));
        return (String[]) arrayList.toArray(new String[0]);
    }
}
