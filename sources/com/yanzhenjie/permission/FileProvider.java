package com.yanzhenjie.permission;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.p074io.IOUtils;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider extends ContentProvider {

    /* renamed from: a */
    private static final String f58911a = "FileProvider";

    /* renamed from: b */
    private static final String[] f58912b = {"_display_name", "_size"};

    /* renamed from: c */
    private static final String f58913c = "android.support.FILE_PROVIDER_PATHS";

    /* renamed from: d */
    private static final String f58914d = "root-path";

    /* renamed from: e */
    private static final String f58915e = "files-path";

    /* renamed from: f */
    private static final String f58916f = "cache-path";

    /* renamed from: g */
    private static final String f58917g = "external-path";

    /* renamed from: h */
    private static final String f58918h = "external-files-path";

    /* renamed from: i */
    private static final String f58919i = "external-cache-path";

    /* renamed from: j */
    private static final String f58920j = "external-media-path";

    /* renamed from: k */
    private static final String f58921k = "name";

    /* renamed from: l */
    private static final String f58922l = "path";

    /* renamed from: m */
    private static final File f58923m = new File("/");

    /* renamed from: n */
    private static final HashMap<String, PathStrategy> f58924n = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: o */
    public PathStrategy f58925o;

    interface PathStrategy {
        File getFileForUri(Uri uri);

        Uri getUriForFile(File file);
    }

    public boolean onCreate() {
        return true;
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        } else if (providerInfo.grantUriPermissions) {
            this.f58925o = new SimplePathStrategy(providerInfo.authority);
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            final Context context2 = context;
            final ProviderInfo providerInfo2 = providerInfo;
            new Thread() {
                public void run() {
                    super.run();
                    PathStrategy unused = FileProvider.this.f58925o = FileProvider.m44532b(context2, providerInfo2.authority);
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    SystemUtils.log(3, FileProvider.f58911a, "FileProvider#attachInfo#getPathStrategy cost time:" + (elapsedRealtime - elapsedRealtime), (Throwable) null, "com.yanzhenjie.permission.FileProvider$1", 102);
                }
            }.start();
        } else {
            throw new SecurityException("Provider must grant uri permissions");
        }
    }

    public static Uri getUriForFile(Context context, String str, File file) {
        return m44532b(context, str).getUriForFile(file);
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i;
        File fileForUri = this.f58925o.getFileForUri(uri);
        if (strArr == null) {
            strArr = f58912b;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i2 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i2] = "_display_name";
                i = i2 + 1;
                objArr[i2] = fileForUri.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i2] = "_size";
                i = i2 + 1;
                objArr[i2] = Long.valueOf(fileForUri.length());
            }
            i2 = i;
        }
        String[] a = m44531a(strArr3, i2);
        Object[] a2 = m44530a(objArr, i2);
        MatrixCursor matrixCursor = new MatrixCursor(a, 1);
        matrixCursor.addRow(a2);
        return matrixCursor;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r3 = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(r3.getName().substring(r0 + 1));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getType(android.net.Uri r3) {
        /*
            r2 = this;
            com.yanzhenjie.permission.FileProvider$PathStrategy r0 = r2.f58925o
            java.io.File r3 = r0.getFileForUri(r3)
            java.lang.String r0 = r3.getName()
            r1 = 46
            int r0 = r0.lastIndexOf(r1)
            if (r0 < 0) goto L_0x0027
            java.lang.String r3 = r3.getName()
            int r0 = r0 + 1
            java.lang.String r3 = r3.substring(r0)
            android.webkit.MimeTypeMap r0 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r3 = r0.getMimeTypeFromExtension(r3)
            if (r3 == 0) goto L_0x0027
            return r3
        L_0x0027:
            java.lang.String r3 = "application/octet-stream"
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yanzhenjie.permission.FileProvider.getType(android.net.Uri):java.lang.String");
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return this.f58925o.getFileForUri(uri).delete() ? 1 : 0;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        return ParcelFileDescriptor.open(this.f58925o.getFileForUri(uri), m44526a(str));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static PathStrategy m44532b(Context context, String str) {
        PathStrategy pathStrategy;
        synchronized (f58924n) {
            pathStrategy = f58924n.get(str);
            if (pathStrategy == null) {
                try {
                    pathStrategy = m44533c(context, str);
                    f58924n.put(str, pathStrategy);
                } catch (IOException e) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);
                } catch (XmlPullParserException e2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                }
            }
        }
        return pathStrategy;
    }

    /* renamed from: c */
    private static PathStrategy m44533c(Context context, String str) throws IOException, XmlPullParserException {
        SimplePathStrategy simplePathStrategy = new SimplePathStrategy(str);
        XmlResourceParser loadXmlMetaData = context.getPackageManager().resolveContentProvider(str, 128).loadXmlMetaData(context.getPackageManager(), f58913c);
        if (loadXmlMetaData != null) {
            while (true) {
                int next = loadXmlMetaData.next();
                if (next == 1) {
                    return simplePathStrategy;
                }
                if (next == 2) {
                    String name = loadXmlMetaData.getName();
                    File file = null;
                    String attributeValue = loadXmlMetaData.getAttributeValue((String) null, "name");
                    String attributeValue2 = loadXmlMetaData.getAttributeValue((String) null, "path");
                    if (f58914d.equals(name)) {
                        file = f58923m;
                    } else if (f58915e.equals(name)) {
                        file = context.getFilesDir();
                    } else if (f58916f.equals(name)) {
                        file = context.getCacheDir();
                    } else if (f58917g.equals(name)) {
                        file = SystemUtils.getExternalStorageDirectory();
                    } else if (f58918h.equals(name)) {
                        File[] d = m44534d(context, (String) null);
                        if (d.length > 0) {
                            file = d[0];
                        }
                    } else if (f58919i.equals(name)) {
                        File[] externalCacheDirs = getExternalCacheDirs(context);
                        if (externalCacheDirs.length > 0) {
                            file = externalCacheDirs[0];
                        }
                    } else if (Build.VERSION.SDK_INT >= 21 && f58920j.equals(name)) {
                        File[] externalMediaDirs = context.getExternalMediaDirs();
                        if (externalMediaDirs.length > 0) {
                            file = externalMediaDirs[0];
                        }
                    }
                    if (file != null) {
                        simplePathStrategy.addRoot(attributeValue, m44529a(file, attributeValue2));
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
    }

    static class SimplePathStrategy implements PathStrategy {
        private final String mAuthority;
        private final HashMap<String, File> mRoots = new HashMap<>();

        SimplePathStrategy(String str) {
            this.mAuthority = str;
        }

        /* access modifiers changed from: package-private */
        public void addRoot(String str, File file) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.mRoots.put(str, file.getCanonicalFile());
                } catch (IOException e) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e);
                }
            } else {
                throw new IllegalArgumentException("Name must not be empty");
            }
        }

        public Uri getUriForFile(File file) {
            String str;
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry entry = null;
                Iterator<Map.Entry<String, File>> it = this.mRoots.entrySet().iterator();
                while (true) {
                    boolean z = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry next = it.next();
                    String path = ((File) next.getValue()).getPath();
                    if (entry != null && path.length() <= ((File) entry.getValue()).getPath().length()) {
                        z = false;
                    }
                    if (canonicalPath.startsWith(path) && z) {
                        entry = next;
                    }
                }
                if (entry != null) {
                    String path2 = ((File) entry.getValue()).getPath();
                    if (path2.endsWith("/")) {
                        str = canonicalPath.substring(path2.length());
                    } else {
                        str = canonicalPath.substring(path2.length() + 1);
                    }
                    return new Uri.Builder().scheme("content").authority(this.mAuthority).encodedPath(Uri.encode((String) entry.getKey()) + IOUtils.DIR_SEPARATOR_UNIX + Uri.encode(str, "/")).build();
                }
                throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        public File getFileForUri(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = this.mRoots.get(decode);
            if (file != null) {
                File file2 = new File(file, decode2);
                try {
                    File canonicalFile = file2.getCanonicalFile();
                    if (canonicalFile.getPath().startsWith(file.getPath())) {
                        return canonicalFile;
                    }
                    throw new SecurityException("Resolved path jumped beyond configured root");
                } catch (IOException unused) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
                }
            } else {
                throw new IllegalArgumentException("Unable to find configured root for " + uri);
            }
        }
    }

    /* renamed from: a */
    private static int m44526a(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }

    /* renamed from: a */
    private static File m44529a(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    /* renamed from: a */
    private static String[] m44531a(String[] strArr, int i) {
        String[] strArr2 = new String[i];
        System.arraycopy(strArr, 0, strArr2, 0, i);
        return strArr2;
    }

    /* renamed from: a */
    private static Object[] m44530a(Object[] objArr, int i) {
        Object[] objArr2 = new Object[i];
        System.arraycopy(objArr, 0, objArr2, 0, i);
        return objArr2;
    }

    /* renamed from: d */
    private static File[] m44534d(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            return context.getExternalFilesDirs(str);
        }
        return new File[]{context.getExternalFilesDir(str)};
    }

    public static File[] getExternalCacheDirs(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return context.getExternalCacheDirs();
        }
        return new File[]{context.getExternalCacheDir()};
    }
}
