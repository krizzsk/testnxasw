package com.didi.beatles.p101im.views.widget.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;

/* renamed from: com.didi.beatles.im.views.widget.photoview.IMPhotoView */
public class IMPhotoView extends ImageView {

    /* renamed from: a */
    private PhotoViewAttacher f12447a;

    /* renamed from: b */
    private ImageView.ScaleType f12448b;

    public IMPhotoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMPhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMPhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10612a();
    }

    public IMPhotoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m10612a();
    }

    /* renamed from: a */
    private void m10612a() {
        this.f12447a = new PhotoViewAttacher(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.f12448b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f12448b = null;
        }
    }

    public PhotoViewAttacher getAttacher() {
        return this.f12447a;
    }

    public ImageView.ScaleType getScaleType() {
        return this.f12447a.getScaleType();
    }

    public Matrix getImageMatrix() {
        return this.f12447a.getImageMatrix();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f12447a.setOnLongClickListener(onLongClickListener);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f12447a.setOnClickListener(onClickListener);
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        PhotoViewAttacher photoViewAttacher = this.f12447a;
        if (photoViewAttacher == null) {
            this.f12448b = scaleType;
        } else {
            photoViewAttacher.setScaleType(scaleType);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        PhotoViewAttacher photoViewAttacher = this.f12447a;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        PhotoViewAttacher photoViewAttacher = this.f12447a;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        PhotoViewAttacher photoViewAttacher = this.f12447a;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    /* access modifiers changed from: protected */
    public boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (frame) {
            this.f12447a.update();
        }
        return frame;
    }

    public void setRotationTo(float f) {
        this.f12447a.setRotationTo(f);
    }

    public void setRotationBy(float f) {
        this.f12447a.setRotationBy(f);
    }

    @Deprecated
    public boolean isZoomEnabled() {
        return this.f12447a.isZoomEnabled();
    }

    public boolean isZoomable() {
        return this.f12447a.isZoomable();
    }

    public void setZoomable(boolean z) {
        this.f12447a.setZoomable(z);
    }

    public RectF getDisplayRect() {
        return this.f12447a.getDisplayRect();
    }

    public void getDisplayMatrix(Matrix matrix) {
        this.f12447a.getDisplayMatrix(matrix);
    }

    public boolean setDisplayMatrix(Matrix matrix) {
        return this.f12447a.setDisplayMatrix(matrix);
    }

    public void getSuppMatrix(Matrix matrix) {
        this.f12447a.getSuppMatrix(matrix);
    }

    public boolean setSuppMatrix(Matrix matrix) {
        return this.f12447a.setDisplayMatrix(matrix);
    }

    public float getMinimumScale() {
        return this.f12447a.getMinimumScale();
    }

    public float getMediumScale() {
        return this.f12447a.getMediumScale();
    }

    public float getMaximumScale() {
        return this.f12447a.getMaximumScale();
    }

    public float getScale() {
        return this.f12447a.getScale();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f12447a.setAllowParentInterceptOnEdge(z);
    }

    public void setMinimumScale(float f) {
        this.f12447a.setMinimumScale(f);
    }

    public void setMediumScale(float f) {
        this.f12447a.setMediumScale(f);
    }

    public void setMaximumScale(float f) {
        this.f12447a.setMaximumScale(f);
    }

    public void setScaleLevels(float f, float f2, float f3) {
        this.f12447a.setScaleLevels(f, f2, f3);
    }

    public void setOnMatrixChangeListener(OnMatrixChangedListener onMatrixChangedListener) {
        this.f12447a.setOnMatrixChangeListener(onMatrixChangedListener);
    }

    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
        this.f12447a.setOnPhotoTapListener(onPhotoTapListener);
    }

    public void setOnOutsidePhotoTapListener(OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        this.f12447a.setOnOutsidePhotoTapListener(onOutsidePhotoTapListener);
    }

    public void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        this.f12447a.setOnViewTapListener(onViewTapListener);
    }

    public void setOnViewDragListener(OnViewDragListener onViewDragListener) {
        this.f12447a.setOnViewDragListener(onViewDragListener);
    }

    public void setScale(float f) {
        this.f12447a.setScale(f);
    }

    public void setScale(float f, boolean z) {
        this.f12447a.setScale(f, z);
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        this.f12447a.setScale(f, f2, f3, z);
    }

    public void setZoomTransitionDuration(int i) {
        this.f12447a.setZoomTransitionDuration(i);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f12447a.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnScaleChangeListener(OnScaleChangedListener onScaleChangedListener) {
        this.f12447a.setOnScaleChangeListener(onScaleChangedListener);
    }

    public void setOnSingleFlingListener(OnSingleFlingListener onSingleFlingListener) {
        this.f12447a.setOnSingleFlingListener(onSingleFlingListener);
    }
}
