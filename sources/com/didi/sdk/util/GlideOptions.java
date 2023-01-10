package com.didi.sdk.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;

public final class GlideOptions extends RequestOptions implements Cloneable {

    /* renamed from: a */
    private static GlideOptions f40306a;

    /* renamed from: b */
    private static GlideOptions f40307b;

    /* renamed from: c */
    private static GlideOptions f40308c;

    /* renamed from: d */
    private static GlideOptions f40309d;

    /* renamed from: e */
    private static GlideOptions f40310e;

    /* renamed from: f */
    private static GlideOptions f40311f;

    public static GlideOptions sizeMultiplierOf(float f) {
        return new GlideOptions().sizeMultiplier(f);
    }

    public static GlideOptions diskCacheStrategyOf(DiskCacheStrategy diskCacheStrategy) {
        return new GlideOptions().diskCacheStrategy(diskCacheStrategy);
    }

    public static GlideOptions priorityOf(Priority priority) {
        return new GlideOptions().priority(priority);
    }

    public static GlideOptions placeholderOf(Drawable drawable) {
        return new GlideOptions().placeholder(drawable);
    }

    public static GlideOptions placeholderOf(int i) {
        return new GlideOptions().placeholder(i);
    }

    public static GlideOptions errorOf(Drawable drawable) {
        return new GlideOptions().error(drawable);
    }

    public static GlideOptions errorOf(int i) {
        return new GlideOptions().error(i);
    }

    public static GlideOptions skipMemoryCacheOf(boolean z) {
        return new GlideOptions().skipMemoryCache(z);
    }

    public static GlideOptions overrideOf(int i, int i2) {
        return new GlideOptions().override(i, i2);
    }

    public static GlideOptions overrideOf(int i) {
        return new GlideOptions().override(i);
    }

    public static GlideOptions signatureOf(Key key) {
        return new GlideOptions().signature(key);
    }

    public static GlideOptions fitCenterTransform() {
        if (f40306a == null) {
            f40306a = new GlideOptions().fitCenter().autoClone();
        }
        return f40306a;
    }

    public static GlideOptions centerInsideTransform() {
        if (f40307b == null) {
            f40307b = new GlideOptions().centerInside().autoClone();
        }
        return f40307b;
    }

    public static GlideOptions centerCropTransform() {
        if (f40308c == null) {
            f40308c = new GlideOptions().centerCrop().autoClone();
        }
        return f40308c;
    }

    public static GlideOptions circleCropTransform() {
        if (f40309d == null) {
            f40309d = new GlideOptions().circleCrop().autoClone();
        }
        return f40309d;
    }

    public static GlideOptions bitmapTransform(Transformation<Bitmap> transformation) {
        return new GlideOptions().transform((Transformation) transformation);
    }

    public static GlideOptions noTransformation() {
        if (f40310e == null) {
            f40310e = new GlideOptions().dontTransform().autoClone();
        }
        return f40310e;
    }

    public static <T> GlideOptions option(Option<T> option, T t) {
        return new GlideOptions().set((Option) option, (Object) t);
    }

    public static GlideOptions decodeTypeOf(Class<?> cls) {
        return new GlideOptions().decode((Class) cls);
    }

    public static GlideOptions formatOf(DecodeFormat decodeFormat) {
        return new GlideOptions().format(decodeFormat);
    }

    public static GlideOptions frameOf(long j) {
        return new GlideOptions().frame(j);
    }

    public static GlideOptions downsampleOf(DownsampleStrategy downsampleStrategy) {
        return new GlideOptions().downsample(downsampleStrategy);
    }

    public static GlideOptions timeoutOf(int i) {
        return new GlideOptions().timeout(i);
    }

    public static GlideOptions encodeQualityOf(int i) {
        return new GlideOptions().encodeQuality(i);
    }

    public static GlideOptions encodeFormatOf(Bitmap.CompressFormat compressFormat) {
        return new GlideOptions().encodeFormat(compressFormat);
    }

    public static GlideOptions noAnimation() {
        if (f40311f == null) {
            f40311f = new GlideOptions().dontAnimate().autoClone();
        }
        return f40311f;
    }

    public GlideOptions sizeMultiplier(float f) {
        return (GlideOptions) super.sizeMultiplier(f);
    }

    public GlideOptions useUnlimitedSourceGeneratorsPool(boolean z) {
        return (GlideOptions) super.useUnlimitedSourceGeneratorsPool(z);
    }

    public GlideOptions useAnimationPool(boolean z) {
        return (GlideOptions) super.useAnimationPool(z);
    }

    public GlideOptions onlyRetrieveFromCache(boolean z) {
        return (GlideOptions) super.onlyRetrieveFromCache(z);
    }

    public GlideOptions diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        return (GlideOptions) super.diskCacheStrategy(diskCacheStrategy);
    }

    public GlideOptions priority(Priority priority) {
        return (GlideOptions) super.priority(priority);
    }

    public GlideOptions placeholder(Drawable drawable) {
        return (GlideOptions) super.placeholder(drawable);
    }

    public GlideOptions placeholder(int i) {
        return (GlideOptions) super.placeholder(i);
    }

    public GlideOptions fallback(Drawable drawable) {
        return (GlideOptions) super.fallback(drawable);
    }

    public GlideOptions fallback(int i) {
        return (GlideOptions) super.fallback(i);
    }

    public GlideOptions error(Drawable drawable) {
        return (GlideOptions) super.error(drawable);
    }

    public GlideOptions error(int i) {
        return (GlideOptions) super.error(i);
    }

    public GlideOptions theme(Resources.Theme theme) {
        return (GlideOptions) super.theme(theme);
    }

    public GlideOptions skipMemoryCache(boolean z) {
        return (GlideOptions) super.skipMemoryCache(z);
    }

    public GlideOptions override(int i, int i2) {
        return (GlideOptions) super.override(i, i2);
    }

    public GlideOptions override(int i) {
        return (GlideOptions) super.override(i);
    }

    public GlideOptions signature(Key key) {
        return (GlideOptions) super.signature(key);
    }

    public GlideOptions clone() {
        return (GlideOptions) super.clone();
    }

    public <Y> GlideOptions set(Option<Y> option, Y y) {
        return (GlideOptions) super.set(option, y);
    }

    public GlideOptions decode(Class<?> cls) {
        return (GlideOptions) super.decode(cls);
    }

    public GlideOptions encodeFormat(Bitmap.CompressFormat compressFormat) {
        return (GlideOptions) super.encodeFormat(compressFormat);
    }

    public GlideOptions encodeQuality(int i) {
        return (GlideOptions) super.encodeQuality(i);
    }

    public GlideOptions frame(long j) {
        return (GlideOptions) super.frame(j);
    }

    public GlideOptions format(DecodeFormat decodeFormat) {
        return (GlideOptions) super.format(decodeFormat);
    }

    public GlideOptions disallowHardwareConfig() {
        return (GlideOptions) super.disallowHardwareConfig();
    }

    public GlideOptions downsample(DownsampleStrategy downsampleStrategy) {
        return (GlideOptions) super.downsample(downsampleStrategy);
    }

    public GlideOptions timeout(int i) {
        return (GlideOptions) super.timeout(i);
    }

    public GlideOptions optionalCenterCrop() {
        return (GlideOptions) super.optionalCenterCrop();
    }

    public GlideOptions centerCrop() {
        return (GlideOptions) super.centerCrop();
    }

    public GlideOptions optionalFitCenter() {
        return (GlideOptions) super.optionalFitCenter();
    }

    public GlideOptions fitCenter() {
        return (GlideOptions) super.fitCenter();
    }

    public GlideOptions optionalCenterInside() {
        return (GlideOptions) super.optionalCenterInside();
    }

    public GlideOptions centerInside() {
        return (GlideOptions) super.centerInside();
    }

    public GlideOptions optionalCircleCrop() {
        return (GlideOptions) super.optionalCircleCrop();
    }

    public GlideOptions circleCrop() {
        return (GlideOptions) super.circleCrop();
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.bumptech.glide.load.Transformation, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.sdk.util.GlideOptions transform(com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r1) {
        /*
            r0 = this;
            com.bumptech.glide.request.BaseRequestOptions r1 = super.transform((com.bumptech.glide.load.Transformation<android.graphics.Bitmap>) r1)
            com.didi.sdk.util.GlideOptions r1 = (com.didi.sdk.util.GlideOptions) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.util.GlideOptions.transform(com.bumptech.glide.load.Transformation):com.didi.sdk.util.GlideOptions");
    }

    @SafeVarargs
    public final GlideOptions transform(Transformation<Bitmap>... transformationArr) {
        return (GlideOptions) super.transform(transformationArr);
    }

    @Deprecated
    @SafeVarargs
    public final GlideOptions transforms(Transformation<Bitmap>... transformationArr) {
        return (GlideOptions) super.transforms(transformationArr);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.bumptech.glide.load.Transformation, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.sdk.util.GlideOptions optionalTransform(com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r1) {
        /*
            r0 = this;
            com.bumptech.glide.request.BaseRequestOptions r1 = super.optionalTransform(r1)
            com.didi.sdk.util.GlideOptions r1 = (com.didi.sdk.util.GlideOptions) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.util.GlideOptions.optionalTransform(com.bumptech.glide.load.Transformation):com.didi.sdk.util.GlideOptions");
    }

    public <Y> GlideOptions optionalTransform(Class<Y> cls, Transformation<Y> transformation) {
        return (GlideOptions) super.optionalTransform(cls, transformation);
    }

    public <Y> GlideOptions transform(Class<Y> cls, Transformation<Y> transformation) {
        return (GlideOptions) super.transform(cls, transformation);
    }

    public GlideOptions dontTransform() {
        return (GlideOptions) super.dontTransform();
    }

    public GlideOptions dontAnimate() {
        return (GlideOptions) super.dontAnimate();
    }

    public GlideOptions apply(BaseRequestOptions<?> baseRequestOptions) {
        return (GlideOptions) super.apply(baseRequestOptions);
    }

    public GlideOptions lock() {
        return (GlideOptions) super.lock();
    }

    public GlideOptions autoClone() {
        return (GlideOptions) super.autoClone();
    }
}
