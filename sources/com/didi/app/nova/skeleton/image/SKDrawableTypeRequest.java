package com.didi.app.nova.skeleton.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.didi.app.nova.skeleton.image.glide.FitUri;
import com.didi.app.nova.skeleton.image.performance.ImagePerformance;
import java.io.File;

public class SKDrawableTypeRequest<TranscodeType> {

    /* renamed from: a */
    private RequestBuilder<TranscodeType> f10290a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ImageRequestListener<TranscodeType> f10291b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ImagePerformance f10292c;

    /* renamed from: a */
    private <T> T m9053a(Class<T> cls) {
        return null;
    }

    public SKDrawableTypeRequest(RequestBuilder<TranscodeType> requestBuilder) {
        ImagePerformance imagePerformance = new ImagePerformance();
        this.f10292c = imagePerformance;
        this.f10290a = requestBuilder;
        imagePerformance.startTime = System.currentTimeMillis();
        ((RequestBuilder) this.f10290a.diskCacheStrategy(DiskCacheStrategy.ALL)).listener(new RequestListener<TranscodeType>() {
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<TranscodeType> target, boolean z) {
                if (SKDrawableTypeRequest.this.f10291b != null) {
                    return SKDrawableTypeRequest.this.f10291b.onException(glideException, z);
                }
                return false;
            }

            public boolean onResourceReady(TranscodeType transcodetype, Object obj, Target<TranscodeType> target, DataSource dataSource, boolean z) {
                boolean z2 = dataSource == DataSource.MEMORY_CACHE;
                SKDrawableTypeRequest.this.f10292c.endTime = System.currentTimeMillis();
                SKDrawableTypeRequest.this.f10292c.totalTime = SKDrawableTypeRequest.this.f10292c.endTime - SKDrawableTypeRequest.this.f10292c.startTime;
                SKDrawableTypeRequest.this.f10292c.isFromMemoryCache = z2;
                Fly.m9033a(SKDrawableTypeRequest.this.f10292c);
                if (SKDrawableTypeRequest.this.f10291b != null) {
                    return SKDrawableTypeRequest.this.f10291b.onResourceReady(transcodetype, z2, z);
                }
                return false;
            }
        });
    }

    public SKDrawableTypeRequest<TranscodeType> load(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f10290a.load((String) m9053a(String.class));
            mo45816a("network", "");
        } else {
            this.f10290a.load(str);
            mo45816a("network", str);
        }
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> load(Uri uri) {
        if (uri == null) {
            this.f10290a.load((Uri) m9053a(Uri.class));
            mo45816a("network", "");
        } else {
            this.f10290a.load(uri);
            mo45816a("network", uri.toString());
        }
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> load(File file) {
        if (file == null) {
            this.f10290a.load((File) m9053a(File.class));
            mo45816a("file", "");
        } else {
            this.f10290a.load(file);
            mo45816a("file", file.getPath());
        }
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> load(Integer num) {
        this.f10290a.load(num);
        mo45816a("resource", String.valueOf(num));
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> load(FitType fitType, String str) {
        if (TextUtils.isEmpty(str)) {
            this.f10290a.load(m9053a(FitUri.class));
            mo45816a("network", "");
        } else {
            this.f10290a.load((Object) new FitUri(fitType, Uri.parse(str)));
            mo45816a("network", str);
        }
        return this;
    }

    public FutureTarget<TranscodeType> submit() {
        return this.f10290a.submit();
    }

    public FutureTarget<TranscodeType> submit(int i, int i2) {
        return this.f10290a.submit(i, i2);
    }

    /* renamed from: com.didi.app.nova.skeleton.image.SKDrawableTypeRequest$2 */
    static /* synthetic */ class C42902 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$app$nova$skeleton$image$Priority;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.didi.app.nova.skeleton.image.Priority[] r0 = com.didi.app.nova.skeleton.image.Priority.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$app$nova$skeleton$image$Priority = r0
                com.didi.app.nova.skeleton.image.Priority r1 = com.didi.app.nova.skeleton.image.Priority.IMMEDIATE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$app$nova$skeleton$image$Priority     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.app.nova.skeleton.image.Priority r1 = com.didi.app.nova.skeleton.image.Priority.HIGH     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$app$nova$skeleton$image$Priority     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.app.nova.skeleton.image.Priority r1 = com.didi.app.nova.skeleton.image.Priority.NORMAL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$app$nova$skeleton$image$Priority     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.app.nova.skeleton.image.Priority r1 = com.didi.app.nova.skeleton.image.Priority.LOW     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.app.nova.skeleton.image.SKDrawableTypeRequest.C42902.<clinit>():void");
        }
    }

    public SKDrawableTypeRequest<TranscodeType> priority(Priority priority) {
        int i = C42902.$SwitchMap$com$didi$app$nova$skeleton$image$Priority[priority.ordinal()];
        if (i == 1) {
            this.f10290a.priority(Priority.IMMEDIATE);
        } else if (i == 2) {
            this.f10290a.priority(Priority.HIGH);
        } else if (i == 3) {
            this.f10290a.priority(Priority.NORMAL);
        } else if (i == 4) {
            this.f10290a.priority(Priority.LOW);
        }
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> skipMemory(boolean z) {
        this.f10290a.skipMemoryCache(z);
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        this.f10290a.diskCacheStrategy(diskCacheStrategy);
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> fitCenter() {
        this.f10290a.fitCenter();
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> centerCrop() {
        this.f10290a.centerCrop();
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> transition(TransitionOptions<?, ? super TranscodeType> transitionOptions) {
        this.f10290a.transition(transitionOptions);
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> placeholder(int i) {
        this.f10290a.placeholder(i);
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> placeholder(Drawable drawable) {
        this.f10290a.placeholder(drawable);
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> fallback(Drawable drawable) {
        this.f10290a.fallback(drawable);
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> fallback(int i) {
        this.f10290a.fallback(i);
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> error(int i) {
        this.f10290a.error(i);
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> error(Drawable drawable) {
        this.f10290a.error(drawable);
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> override(int i, int i2) {
        this.f10290a.override(i, i2);
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> transform(BitmapTransformation... bitmapTransformationArr) {
        this.f10290a.transform((Transformation<Bitmap>[]) bitmapTransformationArr);
        return this;
    }

    public SKDrawableTypeRequest<TranscodeType> listener(ImageRequestListener imageRequestListener) {
        if (imageRequestListener != null) {
            this.f10291b = imageRequestListener;
        }
        return this;
    }

    public void into(ImageView imageView) {
        this.f10290a.into(imageView);
    }

    public void into(Target<TranscodeType> target) {
        this.f10290a.into(target);
    }

    public FutureTarget<TranscodeType> into(int i, int i2) {
        return this.f10290a.into(i, i2);
    }

    public void preload() {
        this.f10290a.preload();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45816a(String str, String str2) {
        this.f10292c.type = str;
        this.f10292c.url = str2;
    }
}
