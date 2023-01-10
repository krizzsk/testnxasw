package com.didi.sdk.resource.warehouse.image.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.didi.sdk.resource.warehouse.image.ICacheProvider;
import com.didi.sdk.resource.warehouse.image.IRetryStrategy;
import com.didi.sdk.resource.warehouse.image.PriorityType;
import com.didi.sdk.resource.warehouse.tools.HandlerUtil;
import com.didi.sdk.resource.warehouse.tools.LogUtil;
import com.didi.sdk.resource.warehouse.tools.OmegaUtil;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class GlideCacheProvider implements ICacheProvider {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f39827a = GlideCacheProvider.class.getSimpleName();

    /* renamed from: b */
    private Context f39828b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Set<String> f39829c = new HashSet();

    public String getProviderKey() {
        return ICacheProvider.PROVIDER_KEY_GLIDE;
    }

    public GlideCacheProvider(Context context) {
        this.f39828b = context.getApplicationContext();
    }

    public boolean hasCache(String str) {
        boolean contains = this.f39829c.contains(str);
        String str2 = f39827a;
        LogUtil.m29980i(str2, "hasCache:url = " + str + ", hasCache = " + contains);
        return contains;
    }

    public void cache(String str, PriorityType priorityType, IRetryStrategy iRetryStrategy) {
        String str2 = f39827a;
        LogUtil.m29980i(str2, "cache:url = " + str + ", priorityType = " + priorityType + ", listener = " + iRetryStrategy);
        m29977a(str, priorityType, 0, iRetryStrategy);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29977a(String str, PriorityType priorityType, int i, IRetryStrategy iRetryStrategy) {
        final boolean hasCache = hasCache(str);
        String str2 = f39827a;
        LogUtil.m29980i(str2, "retry:url = " + str + ", priorityType = " + priorityType + ", retryTime = " + i + ", listener = " + iRetryStrategy + ", hasCache = " + hasCache);
        if (!TextUtils.isEmpty(str)) {
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            if (!hasCache) {
                OmegaUtil.downloadUrlEvent(str, i);
            }
            final String str3 = str;
            final int i2 = i;
            final IRetryStrategy iRetryStrategy2 = iRetryStrategy;
            final PriorityType priorityType2 = priorityType;
            Glide.with(this.f39828b).downloadOnly().load(str).into(new CustomTarget<File>() {
                public void onLoadCleared(Drawable drawable) {
                }

                public void onResourceReady(File file, Transition<? super File> transition) {
                    String a = GlideCacheProvider.f39827a;
                    LogUtil.m29979e(a, "retry.onResourceReady:url = " + str3 + ", resource = " + file);
                    if (!hasCache) {
                        OmegaUtil.downloadUrlSuccessEvent(str3, i2, SystemClock.elapsedRealtime() - elapsedRealtime);
                    }
                    GlideCacheProvider.this.f39829c.add(str3);
                }

                public void onLoadFailed(Drawable drawable) {
                    super.onLoadFailed(drawable);
                    String a = GlideCacheProvider.f39827a;
                    LogUtil.m29979e(a, "retry.onLoadFailed:url = " + str3 + ", errorDrawable = " + drawable);
                    int i = i2;
                    final int i2 = 1;
                    if (i > 0) {
                        i2 = 1 + i;
                    }
                    Throwable th = new Throwable("errorDrawable = " + drawable);
                    IRetryStrategy iRetryStrategy = iRetryStrategy2;
                    if (iRetryStrategy != null && iRetryStrategy.isContinue(str3, i2, th)) {
                        int interval = iRetryStrategy2.interval(str3, i2, th);
                        if (interval < 0) {
                            interval = 0;
                        }
                        HandlerUtil.postRunnableDelayed(new Runnable() {
                            public void run() {
                                GlideCacheProvider.this.m29977a(str3, priorityType2, i2, iRetryStrategy2);
                            }
                        }, (long) interval);
                    }
                    if (!hasCache) {
                        OmegaUtil.downloadUrlFailEvent(str3, i2, SystemClock.elapsedRealtime() - elapsedRealtime, th.toString());
                    }
                    GlideCacheProvider.this.f39829c.remove(str3);
                }
            });
        }
    }

    /* renamed from: a */
    private Priority m29973a(PriorityType priorityType) {
        Priority priority = Priority.NORMAL;
        if (priorityType == PriorityType.HIGH) {
            return Priority.HIGH;
        }
        return priorityType == PriorityType.LOW ? Priority.LOW : priority;
    }
}
