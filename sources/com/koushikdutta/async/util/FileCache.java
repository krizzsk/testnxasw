package com.koushikdutta.async.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class FileCache {

    /* renamed from: a */
    static MessageDigest f58302a = null;

    /* renamed from: j */
    private static String f58303j = "MD5";

    /* renamed from: b */
    boolean f58304b;

    /* renamed from: c */
    Random f58305c = new Random();

    /* renamed from: d */
    long f58306d = 4096;

    /* renamed from: e */
    InternalCache f58307e;

    /* renamed from: f */
    File f58308f;

    /* renamed from: g */
    long f58309g;

    /* renamed from: h */
    Comparator<File> f58310h = new Comparator<File>() {
        public int compare(File file, File file2) {
            long lastModified = file.lastModified();
            long lastModified2 = file2.lastModified();
            if (lastModified < lastModified2) {
                return -1;
            }
            return lastModified2 > lastModified ? 1 : 0;
        }
    };

    /* renamed from: i */
    boolean f58311i;

    class CacheEntry {
        final long size;

        public CacheEntry(File file) {
            this.size = file.length();
        }
    }

    public static class Snapshot {
        FileInputStream[] fins;
        long[] lens;

        Snapshot(FileInputStream[] fileInputStreamArr, long[] jArr) {
            this.fins = fileInputStreamArr;
            this.lens = jArr;
        }

        public long getLength(int i) {
            return this.lens[i];
        }

        public void close() {
            StreamUtility.closeQuietly(this.fins);
        }
    }

    /* renamed from: b */
    private static MessageDigest m44194b() {
        if (!MessageDigestAlgorithms.MD5.equals(f58303j)) {
            return null;
        }
        for (Provider services : Security.getProviders()) {
            for (Provider.Service algorithm : services.getServices()) {
                String algorithm2 = algorithm.getAlgorithm();
                f58303j = algorithm2;
                try {
                    MessageDigest instance = MessageDigest.getInstance(algorithm2);
                    if (instance != null) {
                        return instance;
                    }
                } catch (NoSuchAlgorithmException unused) {
                }
            }
        }
        return null;
    }

    static {
        try {
            f58302a = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        } catch (NoSuchAlgorithmException e) {
            MessageDigest b = m44194b();
            f58302a = b;
            if (b == null) {
                throw new RuntimeException(e);
            }
        }
        try {
            f58302a = (MessageDigest) f58302a.clone();
        } catch (CloneNotSupportedException unused) {
        }
    }

    public static synchronized String toKeyString(Object... objArr) {
        String bigInteger;
        synchronized (FileCache.class) {
            f58302a.reset();
            for (Object obj : objArr) {
                f58302a.update(obj.toString().getBytes());
            }
            bigInteger = new BigInteger(1, f58302a.digest()).toString(16);
        }
        return bigInteger;
    }

    public File getTempFile() {
        File file;
        do {
            file = new File(this.f58308f, new BigInteger(128, this.f58305c).toString(16));
        } while (file.exists());
        return file;
    }

    public File[] getTempFiles(int i) {
        File[] fileArr = new File[i];
        for (int i2 = 0; i2 < i; i2++) {
            fileArr[i2] = getTempFile();
        }
        return fileArr;
    }

    public static void removeFiles(File... fileArr) {
        if (fileArr != null) {
            for (File delete : fileArr) {
                delete.delete();
            }
        }
    }

    public void remove(String str) {
        for (int i = 0; this.f58307e.remove(mo173861a(str, i)) != null; i++) {
        }
        mo173863a(str);
    }

    public boolean exists(String str, int i) {
        return mo173864b(str, i).exists();
    }

    public boolean exists(String str) {
        return mo173864b(str, 0).exists();
    }

    public File touch(File file) {
        this.f58307e.get(file.getName());
        file.setLastModified(System.currentTimeMillis());
        return file;
    }

    public FileInputStream get(String str) throws IOException {
        return new FileInputStream(touch(mo173864b(str, 0)));
    }

    public File getFile(String str) {
        return touch(mo173864b(str, 0));
    }

    public FileInputStream[] get(String str, int i) throws IOException {
        FileInputStream[] fileInputStreamArr = new FileInputStream[i];
        int i2 = 0;
        while (i2 < i) {
            try {
                fileInputStreamArr[i2] = new FileInputStream(touch(mo173864b(str, i2)));
                i2++;
            } catch (IOException e) {
                for (int i3 = 0; i3 < i; i3++) {
                    StreamUtility.closeQuietly(fileInputStreamArr[i3]);
                }
                remove(str);
                throw e;
            }
        }
        return fileInputStreamArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo173861a(String str, int i) {
        return str + "." + i;
    }

    public void commitTempFiles(String str, File... fileArr) {
        mo173863a(str);
        for (int i = 0; i < fileArr.length; i++) {
            File file = fileArr[i];
            File b = mo173864b(str, i);
            if (!file.renameTo(b)) {
                removeFiles(fileArr);
                remove(str);
                return;
            }
            remove(file.getName());
            this.f58307e.put(mo173861a(str, i), new CacheEntry(b));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo173863a(String str) {
        int i = 0;
        while (true) {
            File b = mo173864b(str, i);
            if (b.exists()) {
                b.delete();
                i++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public File mo173864b(String str, int i) {
        return new File(this.f58308f, mo173861a(str, i));
    }

    public void setBlockSize(long j) {
        this.f58306d = j;
    }

    class InternalCache extends LruCache<String, CacheEntry> {
        public InternalCache() {
            super(FileCache.this.f58309g);
        }

        /* access modifiers changed from: protected */
        public long sizeOf(String str, CacheEntry cacheEntry) {
            return Math.max(FileCache.this.f58306d, cacheEntry.size);
        }

        /* access modifiers changed from: protected */
        public void entryRemoved(boolean z, String str, CacheEntry cacheEntry, CacheEntry cacheEntry2) {
            super.entryRemoved(z, str, cacheEntry, cacheEntry2);
            if (cacheEntry2 == null && !FileCache.this.f58311i) {
                new File(FileCache.this.f58308f, str).delete();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo173862a() {
        this.f58311i = true;
        try {
            File[] listFiles = this.f58308f.listFiles();
            if (listFiles != null) {
                ArrayList arrayList = new ArrayList();
                Collections.addAll(arrayList, listFiles);
                Collections.sort(arrayList, this.f58310h);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    File file = (File) it.next();
                    String name = file.getName();
                    this.f58307e.put(name, new CacheEntry(file));
                    this.f58307e.get(name);
                }
                this.f58311i = false;
            }
        } finally {
            this.f58311i = false;
        }
    }

    /* renamed from: c */
    private void m44195c() {
        if (this.f58304b) {
            new Thread() {
                public void run() {
                    FileCache.this.mo173862a();
                }
            }.start();
        } else {
            mo173862a();
        }
    }

    public FileCache(File file, long j, boolean z) {
        this.f58308f = file;
        this.f58309g = j;
        this.f58304b = z;
        this.f58307e = new InternalCache();
        file.mkdirs();
        m44195c();
    }

    public long size() {
        return this.f58307e.size();
    }

    public void clear() {
        removeFiles(this.f58308f.listFiles());
        this.f58307e.evictAll();
    }

    public Set<String> keySet() {
        HashSet hashSet = new HashSet();
        File[] listFiles = this.f58308f.listFiles();
        if (listFiles == null) {
            return hashSet;
        }
        for (File name : listFiles) {
            String name2 = name.getName();
            int lastIndexOf = name2.lastIndexOf(46);
            if (lastIndexOf != -1) {
                hashSet.add(name2.substring(0, lastIndexOf));
            }
        }
        return hashSet;
    }

    public void setMaxSize(long j) {
        this.f58307e.setMaxSize(j);
        m44195c();
    }
}
