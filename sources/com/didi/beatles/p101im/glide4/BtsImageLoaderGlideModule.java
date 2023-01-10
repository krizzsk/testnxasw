package com.didi.beatles.p101im.glide4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.GenericTransitionOptions;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.request.transition.ViewPropertyTransition;
import com.didi.beatles.p101im.IMCmLoader;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.imageloader.Animator;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p101im.utils.imageloader.Callback;
import com.didi.beatles.p101im.utils.imageloader.IBtsImageLoader;
import com.didi.beatles.p101im.utils.imageloader.IMImageRequestOptions;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.io.File;

@ServiceProvider({IBtsImageLoader.class})
/* renamed from: com.didi.beatles.im.glide4.BtsImageLoaderGlideModule */
public final class BtsImageLoaderGlideModule implements IBtsImageLoader {

    /* renamed from: a */
    private static final String f11053a = BtsImageLoaderGlideModule.class.getSimpleName();

    /* renamed from: b */
    private RequestManager f11054b;

    /* renamed from: c */
    private Context f11055c;

    public void cancel(Object obj) {
    }

    public IBtsImageLoader with(Context context) {
        try {
            this.f11054b = Glide.with(context);
        } catch (Exception e) {
            IMLog.m10021e(f11053a, e);
        }
        this.f11055c = context;
        return this;
    }

    public void loadInto(Object obj, View view) {
        if (m9622a(view)) {
            if (view instanceof ImageView) {
                m9621a(obj, (Animator) null).into((ImageView) view);
            } else {
                m9625b(obj, (Animator) null).into(new BitmapViewTarget(view, (Callback) null));
            }
        }
    }

    public void loadInto(Object obj, View view, Drawable drawable) {
        if (m9622a(view)) {
            if (view instanceof ImageView) {
                ((RequestBuilder) m9621a(obj, (Animator) null).placeholder(drawable)).into((ImageView) view);
            } else {
                ((RequestBuilder) m9625b(obj, (Animator) null).placeholder(drawable)).into(new BitmapViewTarget(view, (Callback) null));
            }
        }
    }

    public void loadInto(Object obj, View view, int i) {
        if (m9622a(view)) {
            if (view instanceof ImageView) {
                ((RequestBuilder) m9621a(obj, (Animator) null).placeholder(i)).into((ImageView) view);
            } else {
                ((RequestBuilder) m9625b(obj, (Animator) null).placeholder(i)).into(new BitmapViewTarget(view, (Callback) null));
            }
        }
    }

    public void loadInto(Object obj, View view, Callback callback) {
        if (m9622a(view)) {
            if (view instanceof ImageView) {
                m9621a(obj, (Animator) null).into(new DrawableTarget((ImageView) view, callback));
            } else {
                m9625b(obj, (Animator) null).into(new BitmapViewTarget(view, callback));
            }
        }
    }

    public void loadIntoAsGif(Object obj, View view, Callback callback) {
        if (m9622a(view)) {
            if (view instanceof ImageView) {
                m9620a(obj).into(new GifTarget((ImageView) view, callback));
            } else {
                m9620a(obj).into(new GifViewTarget(view, callback));
            }
        }
    }

    public void loadIntoAsGif(Object obj, View view, int i, Callback callback) {
        if (m9622a(view)) {
            if (view instanceof ImageView) {
                ((RequestBuilder) m9620a(obj).placeholder(i)).into(new GifTarget((ImageView) view, callback));
            } else {
                ((RequestBuilder) m9620a(obj).placeholder(i)).into(new GifViewTarget(view, callback));
            }
        }
    }

    public void loadRoundInto(Object obj, View view) {
        if (m9622a(view)) {
            if (view instanceof ImageView) {
                ((RequestBuilder) m9621a(obj, (Animator) null).transform((Transformation<Bitmap>) new RoundedCorners(IMCmLoader.getInstance().getViewUtil().dp2px(this.f11055c, 4.0f)))).into((ImageView) view);
            } else {
                ((RequestBuilder) m9625b(obj, (Animator) null).transform((Transformation<Bitmap>) new RoundedCorners(IMCmLoader.getInstance().getViewUtil().dp2px(this.f11055c, 4.0f)))).into(new BitmapViewTarget(view, (Callback) null));
            }
        }
    }

    public void loadRoundInto(Object obj, int i, View view) {
        if (m9622a(view)) {
            if (view instanceof ImageView) {
                ((RequestBuilder) m9621a(obj, (Animator) null).transform((Transformation<Bitmap>) new RoundedCorners(IMCmLoader.getInstance().getViewUtil().dp2px(this.f11055c, (float) i)))).into((ImageView) view);
            } else {
                ((RequestBuilder) m9625b(obj, (Animator) null).transform((Transformation<Bitmap>) new RoundedCorners(IMCmLoader.getInstance().getViewUtil().dp2px(this.f11055c, (float) i)))).into(new BitmapViewTarget(view, (Callback) null));
            }
        }
    }

    public void loadRoundInto(Object obj, View view, int i) {
        if (m9622a(view)) {
            if (view instanceof ImageView) {
                ((RequestBuilder) ((RequestBuilder) m9621a(obj, (Animator) null).transform((Transformation<Bitmap>) new RoundedCorners(IMCmLoader.getInstance().getViewUtil().dp2px(this.f11055c, 4.0f)))).placeholder(i)).into((ImageView) view);
            } else {
                ((RequestBuilder) ((RequestBuilder) m9625b(obj, (Animator) null).transform((Transformation<Bitmap>) new RoundedCorners(IMCmLoader.getInstance().getViewUtil().dp2px(this.f11055c, 4.0f)))).placeholder(i)).into(new BitmapViewTarget(view, (Callback) null));
            }
        }
    }

    public Object download(String str, Callback callback) {
        DownloadTarget downloadTarget = new DownloadTarget(callback);
        this.f11054b.asBitmap().load(str).into(downloadTarget);
        return downloadTarget;
    }

    public Object download(String str, int i, int i2, Callback callback) {
        DownloadTarget downloadTarget = new DownloadTarget(i, i2, callback);
        this.f11054b.asBitmap().load(str).into(downloadTarget);
        return downloadTarget;
    }

    public void loadInto(Object obj, View view, Animator animator, IMImageRequestOptions iMImageRequestOptions, Callback callback) {
        if (m9622a(view)) {
            if (view instanceof ImageView) {
                RequestBuilder<Drawable> a = m9621a(obj, animator);
                m9619a(a, iMImageRequestOptions);
                a.into((ImageView) view);
                return;
            }
            RequestBuilder<Bitmap> b = m9625b(obj, animator);
            m9623b(b, iMImageRequestOptions);
            b.into(new BitmapViewTarget(view, callback));
        }
    }

    public Object download(String str, int i, int i2, IMImageRequestOptions iMImageRequestOptions, Callback callback) {
        DownloadTarget downloadTarget = new DownloadTarget(i, i2, callback);
        RequestBuilder<Bitmap> load = this.f11054b.asBitmap().load(str);
        m9623b(load, iMImageRequestOptions);
        load.into(downloadTarget);
        return downloadTarget;
    }

    public void clearMemory() {
        Context context = this.f11055c;
        if (context != null) {
            Glide.get(context).clearMemory();
        }
    }

    /* renamed from: a */
    private RequestBuilder<Drawable> m9619a(RequestBuilder<Drawable> requestBuilder, IMImageRequestOptions iMImageRequestOptions) {
        DiskCacheStrategy diskCacheStrategy;
        if (iMImageRequestOptions == null) {
            return requestBuilder;
        }
        if (iMImageRequestOptions.isValidSizeMultiplier()) {
            requestBuilder.sizeMultiplier(iMImageRequestOptions.getSizeMultiplier());
        }
        if (iMImageRequestOptions.isValidOverrideSize()) {
            requestBuilder.override(iMImageRequestOptions.getOverrideWidth(), iMImageRequestOptions.getOverrideHeight());
        }
        if (iMImageRequestOptions.isValidPlaceholderId()) {
            requestBuilder.placeholder(iMImageRequestOptions.getPlaceholderId());
        }
        DiskCacheStrategy diskCacheStrategy2 = DiskCacheStrategy.AUTOMATIC;
        if (iMImageRequestOptions.getDiskCacheStrategy() == IMImageRequestOptions.DiskCacheStrategy.ALL) {
            diskCacheStrategy = DiskCacheStrategy.ALL;
        } else if (iMImageRequestOptions.getDiskCacheStrategy() == IMImageRequestOptions.DiskCacheStrategy.NONE) {
            diskCacheStrategy = DiskCacheStrategy.NONE;
        } else if (iMImageRequestOptions.getDiskCacheStrategy() == IMImageRequestOptions.DiskCacheStrategy.DATA) {
            diskCacheStrategy = DiskCacheStrategy.DATA;
        } else if (iMImageRequestOptions.getDiskCacheStrategy() == IMImageRequestOptions.DiskCacheStrategy.RESOURCE) {
            diskCacheStrategy = DiskCacheStrategy.RESOURCE;
        } else {
            diskCacheStrategy = DiskCacheStrategy.AUTOMATIC;
        }
        requestBuilder.diskCacheStrategy(diskCacheStrategy);
        if (iMImageRequestOptions.isValidCenterCrop()) {
            requestBuilder.centerCrop();
        }
        return requestBuilder;
    }

    /* renamed from: b */
    private RequestBuilder<Bitmap> m9623b(RequestBuilder<Bitmap> requestBuilder, IMImageRequestOptions iMImageRequestOptions) {
        DiskCacheStrategy diskCacheStrategy;
        if (iMImageRequestOptions == null) {
            return requestBuilder;
        }
        if (iMImageRequestOptions.isValidSizeMultiplier()) {
            requestBuilder.sizeMultiplier(iMImageRequestOptions.getSizeMultiplier());
        }
        if (iMImageRequestOptions.isValidOverrideSize()) {
            requestBuilder.override(iMImageRequestOptions.getOverrideWidth(), iMImageRequestOptions.getOverrideHeight());
        }
        if (iMImageRequestOptions.isValidPlaceholderId()) {
            requestBuilder.placeholder(iMImageRequestOptions.getPlaceholderId());
        }
        DiskCacheStrategy diskCacheStrategy2 = DiskCacheStrategy.AUTOMATIC;
        if (iMImageRequestOptions.getDiskCacheStrategy() == IMImageRequestOptions.DiskCacheStrategy.ALL) {
            diskCacheStrategy = DiskCacheStrategy.ALL;
        } else if (iMImageRequestOptions.getDiskCacheStrategy() == IMImageRequestOptions.DiskCacheStrategy.NONE) {
            diskCacheStrategy = DiskCacheStrategy.NONE;
        } else if (iMImageRequestOptions.getDiskCacheStrategy() == IMImageRequestOptions.DiskCacheStrategy.DATA) {
            diskCacheStrategy = DiskCacheStrategy.DATA;
        } else if (iMImageRequestOptions.getDiskCacheStrategy() == IMImageRequestOptions.DiskCacheStrategy.RESOURCE) {
            diskCacheStrategy = DiskCacheStrategy.RESOURCE;
        } else {
            diskCacheStrategy = DiskCacheStrategy.AUTOMATIC;
        }
        requestBuilder.diskCacheStrategy(diskCacheStrategy);
        if (iMImageRequestOptions.isValidCenterCrop()) {
            requestBuilder.centerCrop();
        }
        return requestBuilder;
    }

    /* renamed from: a */
    private RequestBuilder<Drawable> m9621a(Object obj, Animator animator) {
        RequestBuilder<Drawable> d = m9627d(obj);
        if (animator == null) {
            return (RequestBuilder) d.dontAnimate();
        }
        return d.transition(GenericTransitionOptions.with((ViewPropertyTransition.Animator) new AnimateWrapper(animator)));
    }

    /* renamed from: b */
    private RequestBuilder<Bitmap> m9625b(Object obj, Animator animator) {
        RequestBuilder<Bitmap> c = m9626c(obj);
        if (animator == null) {
            return (RequestBuilder) c.dontAnimate();
        }
        return c.transition(GenericTransitionOptions.with((ViewPropertyTransition.Animator) new AnimateWrapper(animator)));
    }

    /* renamed from: a */
    private RequestBuilder<GifDrawable> m9620a(Object obj) {
        return m9624b(obj);
    }

    /* renamed from: b */
    private RequestBuilder<GifDrawable> m9624b(Object obj) {
        if (obj instanceof Integer) {
            return this.f11054b.asGif().load((Integer) obj);
        }
        if (obj instanceof Uri) {
            return this.f11054b.asGif().load((Uri) obj);
        }
        if (obj instanceof String) {
            return this.f11054b.asGif().load((String) obj);
        }
        if (obj instanceof File) {
            return this.f11054b.asGif().load((File) obj);
        }
        IMLog.m10021e("IM_SDK", "load image failed while the src = " + obj);
        return this.f11054b.asGif().load("null");
    }

    /* renamed from: c */
    private RequestBuilder<Bitmap> m9626c(Object obj) {
        if (obj instanceof Integer) {
            return this.f11054b.asBitmap().load((Integer) obj);
        }
        if (obj instanceof Uri) {
            return this.f11054b.asBitmap().load((Uri) obj);
        }
        if (obj instanceof String) {
            return this.f11054b.asBitmap().load((String) obj);
        }
        if (obj instanceof File) {
            return this.f11054b.asBitmap().load((File) obj);
        }
        IMLog.m10021e("IM_SDK", "load image failed while the src = " + obj);
        return this.f11054b.asBitmap().load("null");
    }

    /* renamed from: d */
    private RequestBuilder<Drawable> m9627d(Object obj) {
        if (obj instanceof Integer) {
            return this.f11054b.load((Integer) obj);
        }
        if (obj instanceof Uri) {
            return this.f11054b.load((Uri) obj);
        }
        if (obj instanceof String) {
            return this.f11054b.load((String) obj);
        }
        if (obj instanceof File) {
            return this.f11054b.load((File) obj);
        }
        IMLog.m10021e("IM_SDK", "load image failed while the src = " + obj);
        return this.f11054b.load("null");
    }

    /* renamed from: a */
    private boolean m9622a(View view) {
        return (view == null || view.getVisibility() == 8) ? false : true;
    }

    /* renamed from: com.didi.beatles.im.glide4.BtsImageLoaderGlideModule$AnimateWrapper */
    private static class AnimateWrapper implements ViewPropertyTransition.Animator {
        final Animator animator;

        public AnimateWrapper(Animator animator2) {
            this.animator = animator2;
        }

        public void animate(View view) {
            this.animator.animate(view);
        }
    }

    /* renamed from: com.didi.beatles.im.glide4.BtsImageLoaderGlideModule$DownloadTarget */
    private static class DownloadTarget extends CustomTarget<Bitmap> {

        /* renamed from: cb */
        private final Callback f11057cb;

        public void onLoadCleared(Drawable drawable) {
        }

        private DownloadTarget(Callback callback) {
            this.f11057cb = callback == null ? BtsImageLoader.getEmptyCallback() : callback;
        }

        private DownloadTarget(int i, int i2, Callback callback) {
            super(i, i2);
            this.f11057cb = callback == null ? BtsImageLoader.getEmptyCallback() : callback;
        }

        public void onLoadStarted(Drawable drawable) {
            super.onLoadStarted(drawable);
            this.f11057cb.onStart();
        }

        public void onLoadFailed(Drawable drawable) {
            super.onLoadFailed(drawable);
            this.f11057cb.onFailed();
        }

        public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
            this.f11057cb.onSuccess(bitmap);
        }
    }

    /* renamed from: com.didi.beatles.im.glide4.BtsImageLoaderGlideModule$DrawableTarget */
    private static class DrawableTarget extends DrawableImageViewTarget {

        /* renamed from: cb */
        private final Callback f11058cb;

        private DrawableTarget(ImageView imageView, Callback callback) {
            super(imageView);
            this.f11058cb = callback == null ? BtsImageLoader.getEmptyCallback() : callback;
        }

        public void onLoadStarted(Drawable drawable) {
            super.onLoadStarted(drawable);
            this.f11058cb.onStart();
        }

        public void onLoadFailed(Drawable drawable) {
            super.onLoadFailed(drawable);
            this.f11058cb.onFailed();
        }

        public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
            super.onResourceReady(drawable, transition);
            this.f11058cb.onSuccess((Bitmap) null);
        }
    }

    /* renamed from: com.didi.beatles.im.glide4.BtsImageLoaderGlideModule$GifTarget */
    private static class GifTarget extends ImageViewTarget<GifDrawable> {

        /* renamed from: cb */
        private final Callback f11059cb;

        private GifTarget(ImageView imageView, Callback callback) {
            super(imageView);
            this.f11059cb = callback == null ? BtsImageLoader.getEmptyCallback() : callback;
        }

        public void onLoadStarted(Drawable drawable) {
            super.onLoadStarted(drawable);
            this.f11059cb.onStart();
        }

        public void onLoadFailed(Drawable drawable) {
            super.onLoadFailed(drawable);
            this.f11059cb.onFailed();
        }

        /* access modifiers changed from: protected */
        public void setResource(GifDrawable gifDrawable) {
            ((ImageView) this.view).setImageDrawable(gifDrawable);
        }

        public void onResourceReady(GifDrawable gifDrawable, Transition<? super GifDrawable> transition) {
            super.onResourceReady(gifDrawable, transition);
            this.f11059cb.onSuccess((Bitmap) null);
        }
    }

    /* renamed from: com.didi.beatles.im.glide4.BtsImageLoaderGlideModule$BitmapViewTarget */
    private static class BitmapViewTarget extends CustomViewTarget<View, Bitmap> {

        /* renamed from: cb */
        private final Callback f11056cb;

        /* access modifiers changed from: protected */
        public void onResourceCleared(Drawable drawable) {
        }

        public BitmapViewTarget(View view, Callback callback) {
            super(view);
            this.f11056cb = callback == null ? BtsImageLoader.getEmptyCallback() : callback;
        }

        /* access modifiers changed from: protected */
        public void onResourceLoading(Drawable drawable) {
            super.onResourceLoading(drawable);
            if (drawable != null) {
                IMCmLoader.getInstance().getViewUtil().setBackgroundCompat(this.view, drawable);
            }
            this.f11056cb.onStart();
        }

        public void onLoadFailed(Drawable drawable) {
            this.f11056cb.onFailed();
        }

        public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
            IMCmLoader.getInstance().getViewUtil().setBackgroundCompat(this.view, new BitmapDrawable(this.view.getResources(), bitmap));
            this.f11056cb.onSuccess(bitmap);
        }
    }

    /* renamed from: com.didi.beatles.im.glide4.BtsImageLoaderGlideModule$GifViewTarget */
    private static class GifViewTarget extends CustomViewTarget<View, GifDrawable> {

        /* renamed from: cb */
        private final Callback f11060cb;

        /* access modifiers changed from: protected */
        public void onResourceCleared(Drawable drawable) {
        }

        public GifViewTarget(View view, Callback callback) {
            super(view);
            this.f11060cb = callback == null ? BtsImageLoader.getEmptyCallback() : callback;
        }

        /* access modifiers changed from: protected */
        public void onResourceLoading(Drawable drawable) {
            super.onResourceLoading(drawable);
            if (drawable != null) {
                IMCmLoader.getInstance().getViewUtil().setBackgroundCompat(this.view, drawable);
            }
            this.f11060cb.onStart();
        }

        public void onLoadFailed(Drawable drawable) {
            this.f11060cb.onFailed();
        }

        public void onResourceReady(GifDrawable gifDrawable, Transition<? super GifDrawable> transition) {
            IMCmLoader.getInstance().getViewUtil().setBackgroundCompat(this.view, gifDrawable);
            this.f11060cb.onSuccess((Bitmap) null);
        }
    }
}
