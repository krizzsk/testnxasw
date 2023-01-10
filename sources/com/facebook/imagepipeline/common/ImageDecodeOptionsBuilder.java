package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
import javax.annotation.Nullable;

public class ImageDecodeOptionsBuilder {
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;
    @Nullable
    private BitmapTransformation mBitmapTransformation;
    @Nullable
    private ImageDecoder mCustomImageDecoder;
    private boolean mDecodeAllFrames;
    private boolean mDecodePreviewFrame;
    private boolean mForceStaticImage;
    private int mMinDecodeIntervalMs = 100;
    private boolean mTransformToSRGB;
    private boolean mUseLastFrameForPreview;

    public ImageDecodeOptionsBuilder setFrom(ImageDecodeOptions imageDecodeOptions) {
        this.mDecodePreviewFrame = imageDecodeOptions.decodePreviewFrame;
        this.mUseLastFrameForPreview = imageDecodeOptions.useLastFrameForPreview;
        this.mDecodeAllFrames = imageDecodeOptions.decodeAllFrames;
        this.mForceStaticImage = imageDecodeOptions.forceStaticImage;
        this.mBitmapConfig = imageDecodeOptions.bitmapConfig;
        this.mCustomImageDecoder = imageDecodeOptions.customImageDecoder;
        this.mTransformToSRGB = imageDecodeOptions.transformToSRGB;
        this.mBitmapTransformation = imageDecodeOptions.bitmapTransformation;
        return this;
    }

    public ImageDecodeOptionsBuilder setMinDecodeIntervalMs(int i) {
        this.mMinDecodeIntervalMs = i;
        return this;
    }

    public int getMinDecodeIntervalMs() {
        return this.mMinDecodeIntervalMs;
    }

    public ImageDecodeOptionsBuilder setDecodePreviewFrame(boolean z) {
        this.mDecodePreviewFrame = z;
        return this;
    }

    public boolean getDecodePreviewFrame() {
        return this.mDecodePreviewFrame;
    }

    public boolean getUseLastFrameForPreview() {
        return this.mUseLastFrameForPreview;
    }

    public ImageDecodeOptionsBuilder setUseLastFrameForPreview(boolean z) {
        this.mUseLastFrameForPreview = z;
        return this;
    }

    public boolean getDecodeAllFrames() {
        return this.mDecodeAllFrames;
    }

    public ImageDecodeOptionsBuilder setDecodeAllFrames(boolean z) {
        this.mDecodeAllFrames = z;
        return this;
    }

    public ImageDecodeOptionsBuilder setForceStaticImage(boolean z) {
        this.mForceStaticImage = z;
        return this;
    }

    public ImageDecodeOptionsBuilder setCustomImageDecoder(@Nullable ImageDecoder imageDecoder) {
        this.mCustomImageDecoder = imageDecoder;
        return this;
    }

    @Nullable
    public ImageDecoder getCustomImageDecoder() {
        return this.mCustomImageDecoder;
    }

    public boolean getForceStaticImage() {
        return this.mForceStaticImage;
    }

    public Bitmap.Config getBitmapConfig() {
        return this.mBitmapConfig;
    }

    public ImageDecodeOptionsBuilder setBitmapConfig(Bitmap.Config config) {
        this.mBitmapConfig = config;
        return this;
    }

    public boolean getTransformToSRGB() {
        return this.mTransformToSRGB;
    }

    public ImageDecodeOptionsBuilder setTransformToSRGB(boolean z) {
        this.mTransformToSRGB = z;
        return this;
    }

    public ImageDecodeOptionsBuilder setBitmapTransformation(@Nullable BitmapTransformation bitmapTransformation) {
        this.mBitmapTransformation = bitmapTransformation;
        return this;
    }

    @Nullable
    public BitmapTransformation getBitmapTransformation() {
        return this.mBitmapTransformation;
    }

    public ImageDecodeOptions build() {
        return new ImageDecodeOptions(this);
    }
}
