package com.didiglobal.p205sa.biz.component.mapflow;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.util.ImageUtil;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didiglobal.p205sa.biz.util.ThreadPoolHelper;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didiglobal.sa.biz.component.mapflow.IconHelper */
public class IconHelper {

    /* renamed from: c */
    private static IconHelper f53543c;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Logger f53544a = LoggerFactory.getLogger(getClass());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Map<String, BitmapDescriptor> f53545b = new HashMap();

    /* renamed from: com.didiglobal.sa.biz.component.mapflow.IconHelper$IconChangeListener */
    public interface IconChangeListener {
        void iconChange();
    }

    public static IconHelper getInstance() {
        if (f53543c == null) {
            m39966a();
        }
        return f53543c;
    }

    /* renamed from: a */
    private static synchronized void m39966a() {
        synchronized (IconHelper.class) {
            if (f53543c == null) {
                f53543c = new IconHelper();
            }
        }
    }

    private IconHelper() {
    }

    public boolean haveCache(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        BitmapDescriptor bitmapDescriptorFromCache = getBitmapDescriptorFromCache(str);
        Logger logger = this.f53544a;
        logger.info("Iconhelper haveCache: " + bitmapDescriptorFromCache + ":>>mIconUrl>" + str, new Object[0]);
        if (bitmapDescriptorFromCache != null) {
            return true;
        }
        return false;
    }

    public void requestMisIcon(Context context, String str, boolean z, IconChangeListener iconChangeListener) {
        if (!TextUtils.isEmpty(str) && !this.f53545b.containsKey(str)) {
            Logger logger = this.f53544a;
            logger.info("requestMisIcon getSmoothDriverIcon url: " + str, new Object[0]);
            final Context context2 = context;
            final String str2 = str;
            final boolean z2 = z;
            final IconChangeListener iconChangeListener2 = iconChangeListener;
            ThreadPoolHelper.getInstance().execute(new Runnable() {
                public void run() {
                    final RequestBuilder requestBuilder = (RequestBuilder) Glide.with(context2).asBitmap().load(str2).fitCenter();
                    if (z2) {
                        requestBuilder.override(UiUtils.dip2px(context2, 35.0f), UiUtils.dip2px(context2, 35.0f));
                    }
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            requestBuilder.into(new CustomTarget<Bitmap>() {
                                public void onLoadCleared(Drawable drawable) {
                                }

                                public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                                    if (bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0) {
                                        IconHelper.this.f53544a.info("CarBuildHelper getSmoothDriverIcon resource is invalidate", new Object[0]);
                                        return;
                                    }
                                    Logger a = IconHelper.this.f53544a;
                                    a.info("requestMisIcon CarBuildHelper getSmoothDriverIcon resource is " + bitmap.getWidth() + ":" + bitmap.getHeight(), new Object[0]);
                                    if (!z2) {
                                        bitmap = ImageUtil.getScaledBitmap(context2, bitmap);
                                    }
                                    IconHelper.this.f53545b.put(str2, BitmapDescriptorFactory.fromBitmap(bitmap));
                                    if (iconChangeListener2 != null) {
                                        iconChangeListener2.iconChange();
                                    }
                                }
                            });
                        }
                    });
                }
            });
        }
    }

    public BitmapDescriptor getSmoothDriverIcon(Context context, String str, int i) {
        BitmapDescriptor bitmapDescriptorFromCache = getBitmapDescriptorFromCache(str);
        if (bitmapDescriptorFromCache != null) {
            return bitmapDescriptorFromCache;
        }
        this.f53544a.info("requestMisIcon get bitmap from local res", new Object[0]);
        Map<String, BitmapDescriptor> map = this.f53545b;
        BitmapDescriptor bitmapDescriptor = map.get(i + "");
        return bitmapDescriptor == null ? m39964a(context, i) : bitmapDescriptor;
    }

    public BitmapDescriptor getBitmapDescriptorFromCache(String str) {
        return this.f53545b.get(str);
    }

    /* renamed from: a */
    private BitmapDescriptor m39964a(Context context, int i) {
        BitmapDescriptor bitmapDescriptor = null;
        if (i != -1) {
            try {
                bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(context.getResources(), i));
                Logger logger = this.f53544a;
                StringBuilder sb = new StringBuilder();
                sb.append(" requestMisIcon getSmoothDriverIcon def icon is not null ? ");
                sb.append(bitmapDescriptor != null);
                logger.info(sb.toString(), new Object[0]);
                if (bitmapDescriptor != null) {
                    Map<String, BitmapDescriptor> map = this.f53545b;
                    map.put(i + "", bitmapDescriptor);
                }
            } catch (Exception e) {
                Logger logger2 = this.f53544a;
                logger2.info("requestMisIcon  getSmoothDriverIcon def Exception " + e.getMessage(), new Object[0]);
            }
        }
        return bitmapDescriptor;
    }
}
