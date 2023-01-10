package com.didi.sdk.resource.warehouse.image;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.resource.warehouse.image.provider.FrescoCacheProvider;
import com.didi.sdk.resource.warehouse.image.provider.GlideCacheProvider;
import com.didi.sdk.resource.warehouse.image.strategy.FixedIntervalRetryStrategy;
import com.didi.sdk.resource.warehouse.tools.LogUtil;
import java.util.HashMap;
import java.util.Map;

public class OnlineImageCacheManager {
    public static int DEFAULT_MAX_RETRY_COUNT = 5;
    public static final long DRAWABLE_ID_NONE = -1;

    /* renamed from: a */
    private static final String f39819a = OnlineImageCacheManager.class.getSimpleName();

    /* renamed from: b */
    private static OnlineImageCacheManager f39820b;

    /* renamed from: c */
    private static final IRetryStrategy f39821c = new FixedIntervalRetryStrategy(1000, DEFAULT_MAX_RETRY_COUNT);

    /* renamed from: d */
    private Context f39822d;

    /* renamed from: e */
    private Map<String, CacheItem> f39823e = new HashMap();

    /* renamed from: f */
    private Map<Long, CacheItem> f39824f = new HashMap();

    /* renamed from: g */
    private Map<String, ICacheProvider> f39825g = new HashMap();

    public static synchronized OnlineImageCacheManager getInstance(Context context) {
        OnlineImageCacheManager onlineImageCacheManager;
        synchronized (OnlineImageCacheManager.class) {
            if (f39820b == null) {
                f39820b = new OnlineImageCacheManager(context);
            }
            onlineImageCacheManager = f39820b;
        }
        return onlineImageCacheManager;
    }

    private OnlineImageCacheManager(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            this.f39822d = applicationContext;
            registerCacheProvider(new GlideCacheProvider(applicationContext));
            registerCacheProvider(new FrescoCacheProvider());
            return;
        }
        throw new NullPointerException(f39819a + ".new:context is null");
    }

    public void registerCacheProvider(ICacheProvider iCacheProvider) {
        String str = f39819a;
        LogUtil.m29980i(str, "registerCacheProvider:provider = " + iCacheProvider);
        if (iCacheProvider != null) {
            this.f39825g.put(iCacheProvider.getProviderKey(), iCacheProvider);
        }
    }

    public void register(String str, PriorityType priorityType, String str2) {
        register(-1, str, priorityType, this.f39825g.get(str2), f39821c);
    }

    public void register(long j, String str, PriorityType priorityType, String str2) {
        register(j, str, priorityType, this.f39825g.get(str2), f39821c);
    }

    public void register(String str, PriorityType priorityType, String str2, IRetryStrategy iRetryStrategy) {
        register(-1, str, priorityType, this.f39825g.get(str2), iRetryStrategy);
    }

    public void register(long j, String str, PriorityType priorityType, String str2, IRetryStrategy iRetryStrategy) {
        register(j, str, priorityType, this.f39825g.get(str2), iRetryStrategy);
    }

    public void register(String str, PriorityType priorityType, ICacheProvider iCacheProvider) {
        register(-1, str, priorityType, iCacheProvider, f39821c);
    }

    public void register(long j, String str, PriorityType priorityType, ICacheProvider iCacheProvider) {
        register(j, str, priorityType, iCacheProvider, f39821c);
    }

    public void register(String str, PriorityType priorityType, ICacheProvider iCacheProvider, IRetryStrategy iRetryStrategy) {
        register(-1, str, priorityType, iCacheProvider, iRetryStrategy);
    }

    public void register(long j, String str, PriorityType priorityType, ICacheProvider iCacheProvider, IRetryStrategy iRetryStrategy) {
        String str2 = f39819a;
        LogUtil.m29980i(str2, "register:url = " + str + ", priorityType = " + priorityType + ", provider = " + iCacheProvider + ", strategy = " + iRetryStrategy);
        if (TextUtils.isEmpty(str)) {
            LogUtil.m29979e(f39819a, "register:url is empty");
        } else if (iCacheProvider == null) {
            String str3 = f39819a;
            LogUtil.m29979e(str3, "register:provider is null, url = " + str);
        } else {
            if (iRetryStrategy == null) {
                String str4 = f39819a;
                LogUtil.m29982w(str4, "register:strategy is null, url = " + str + ", priorityType = " + priorityType + ", provider = " + iCacheProvider);
            }
            CacheItem cacheItem = new CacheItem(j, str, priorityType, iCacheProvider, iRetryStrategy);
            this.f39823e.put(str, cacheItem);
            if (j >= 0) {
                this.f39824f.put(Long.valueOf(j), cacheItem);
            }
            iCacheProvider.cache(str, priorityType, iRetryStrategy);
        }
    }

    public boolean hasCache(String str, String str2) {
        ICacheProvider iCacheProvider;
        if (!TextUtils.isEmpty(str) && (iCacheProvider = this.f39825g.get(str2)) != null) {
            return iCacheProvider.hasCache(str);
        }
        return false;
    }
}
