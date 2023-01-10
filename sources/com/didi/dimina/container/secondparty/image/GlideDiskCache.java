package com.didi.dimina.container.secondparty.image;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

public class GlideDiskCache extends DiskLruCacheFactory {

    /* renamed from: a */
    private static final int f19014a = 262144000;

    /* renamed from: b */
    private static final String f19015b = "image_manager_disk_cache";

    /* renamed from: d */
    private static GlideDiskCache f19016d;

    /* renamed from: c */
    private DiskCache f19017c;

    public static GlideDiskCache getDiskCache(Context context) {
        if (f19016d == null) {
            synchronized (GlideDiskCache.class) {
                if (f19016d == null) {
                    f19016d = new GlideDiskCache(context, "image_manager_disk_cache", 262144000);
                }
            }
        }
        return f19016d;
    }

    public GlideDiskCache(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public GlideDiskCache(Context context, int i) {
        this(context, "image_manager_disk_cache", i);
    }

    public GlideDiskCache(final Context context, final String str, int i) {
        super((DiskLruCacheFactory.CacheDirectoryGetter) new DiskLruCacheFactory.CacheDirectoryGetter() {
            public File getCacheDirectory() {
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    return null;
                }
                return str != null ? new File(cacheDir, str) : cacheDir;
            }
        }, (long) i);
    }

    public DiskCache build() {
        if (this.f19017c == null) {
            this.f19017c = super.build();
        }
        return this.f19017c;
    }
}
