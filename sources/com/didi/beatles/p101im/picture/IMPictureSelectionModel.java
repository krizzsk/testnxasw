package com.didi.beatles.p101im.picture;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.didi.beatles.p101im.activity.IMPictureSelectorActivity;
import com.didi.beatles.p101im.picture.config.IMPictureSelectionConfig;
import com.didi.beatles.p101im.picture.entity.IMLocalMedia;
import com.didi.beatles.p101im.picture.utils.IMDoubleUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.beatles.im.picture.IMPictureSelectionModel */
public class IMPictureSelectionModel {

    /* renamed from: a */
    private IMPictureSelectionConfig f11189a;

    /* renamed from: b */
    private IMPictureSelector f11190b;

    public IMPictureSelectionModel(IMPictureSelector iMPictureSelector, int i) {
        this.f11190b = iMPictureSelector;
        IMPictureSelectionConfig cleanInstance = IMPictureSelectionConfig.getCleanInstance();
        this.f11189a = cleanInstance;
        cleanInstance.mimeType = i;
    }

    public IMPictureSelectionModel(IMPictureSelector iMPictureSelector, int i, boolean z) {
        this.f11190b = iMPictureSelector;
        IMPictureSelectionConfig cleanInstance = IMPictureSelectionConfig.getCleanInstance();
        this.f11189a = cleanInstance;
        cleanInstance.camera = z;
        this.f11189a.mimeType = i;
    }

    public IMPictureSelectionModel maxImageSize(int i) {
        this.f11189a.maxImageSize = i;
        return this;
    }

    public IMPictureSelectionModel selectionMode(int i) {
        this.f11189a.selectionMode = i;
        return this;
    }

    public IMPictureSelectionModel enablePreviewAudio(boolean z) {
        this.f11189a.enablePreviewAudio = z;
        return this;
    }

    public IMPictureSelectionModel freeStyleCropEnabled(boolean z) {
        this.f11189a.freeStyleCropEnabled = z;
        return this;
    }

    public IMPictureSelectionModel scaleEnabled(boolean z) {
        this.f11189a.scaleEnabled = z;
        return this;
    }

    public IMPictureSelectionModel rotateEnabled(boolean z) {
        this.f11189a.rotateEnabled = z;
        return this;
    }

    public IMPictureSelectionModel circleDimmedLayer(boolean z) {
        this.f11189a.circleDimmedLayer = z;
        return this;
    }

    public IMPictureSelectionModel showCropFrame(boolean z) {
        this.f11189a.showCropFrame = z;
        return this;
    }

    public IMPictureSelectionModel showCropGrid(boolean z) {
        this.f11189a.showCropGrid = z;
        return this;
    }

    public IMPictureSelectionModel hideBottomControls(boolean z) {
        this.f11189a.hideBottomControls = z;
        return this;
    }

    public IMPictureSelectionModel withAspectRatio(int i, int i2) {
        this.f11189a.aspect_ratio_x = i;
        this.f11189a.aspect_ratio_y = i2;
        return this;
    }

    public IMPictureSelectionModel maxSelectNum(int i) {
        this.f11189a.maxSelectNum = i;
        return this;
    }

    public IMPictureSelectionModel minSelectNum(int i) {
        this.f11189a.minSelectNum = i;
        return this;
    }

    public IMPictureSelectionModel videoQuality(int i) {
        this.f11189a.videoQuality = i;
        return this;
    }

    public IMPictureSelectionModel imageFormat(String str) {
        this.f11189a.suffixType = str;
        return this;
    }

    public IMPictureSelectionModel cropWH(int i, int i2) {
        this.f11189a.cropWidth = i;
        this.f11189a.cropHeight = i2;
        return this;
    }

    public IMPictureSelectionModel videoMaxSecond(int i) {
        this.f11189a.videoMaxSecond = i * 1000;
        return this;
    }

    public IMPictureSelectionModel videoMinSecond(int i) {
        this.f11189a.videoMinSecond = i * 1000;
        return this;
    }

    public IMPictureSelectionModel recordVideoSecond(int i) {
        this.f11189a.recordVideoSecond = i;
        return this;
    }

    public IMPictureSelectionModel glideOverride(int i, int i2) {
        this.f11189a.overrideWidth = i;
        this.f11189a.overrideHeight = i2;
        return this;
    }

    public IMPictureSelectionModel sizeMultiplier(float f) {
        this.f11189a.sizeMultiplier = f;
        return this;
    }

    public IMPictureSelectionModel imageSpanCount(int i) {
        this.f11189a.imageSpanCount = i;
        return this;
    }

    public IMPictureSelectionModel minimumCompressSize(int i) {
        this.f11189a.minimumCompressSize = i;
        return this;
    }

    public IMPictureSelectionModel cropCompressQuality(int i) {
        this.f11189a.cropCompressQuality = i;
        return this;
    }

    public IMPictureSelectionModel compress(boolean z) {
        this.f11189a.isCompress = z;
        return this;
    }

    public IMPictureSelectionModel synOrAsy(boolean z) {
        this.f11189a.synOrAsy = z;
        return this;
    }

    public IMPictureSelectionModel compressSavePath(String str) {
        this.f11189a.compressSavePath = str;
        return this;
    }

    public IMPictureSelectionModel isZoomAnim(boolean z) {
        this.f11189a.zoomAnim = z;
        return this;
    }

    public IMPictureSelectionModel previewEggs(boolean z) {
        this.f11189a.previewEggs = z;
        return this;
    }

    public IMPictureSelectionModel showCameraInGallery(boolean z) {
        this.f11189a.showCameraInGallery = z;
        return this;
    }

    public IMPictureSelectionModel setOutputCameraPath(String str) {
        this.f11189a.outputCameraPath = str;
        return this;
    }

    public IMPictureSelectionModel isGif(boolean z) {
        this.f11189a.isGif = z;
        return this;
    }

    public IMPictureSelectionModel previewImage(boolean z) {
        this.f11189a.enablePreview = z;
        return this;
    }

    public IMPictureSelectionModel previewVideo(boolean z) {
        this.f11189a.enPreviewVideo = z;
        return this;
    }

    public IMPictureSelectionModel isDragFrame(boolean z) {
        this.f11189a.isDragFrame = z;
        return this;
    }

    public IMPictureSelectionModel enableSelectOverlay(boolean z) {
        this.f11189a.enableSelectOverlay = z;
        return this;
    }

    public IMPictureSelectionModel selectionMedia(List<IMLocalMedia> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f11189a.selectionMedias = list;
        return this;
    }

    public void forResult(int i) {
        Activity a;
        if (!IMDoubleUtils.isFastDoubleClick() && (a = this.f11190b.mo47915a()) != null) {
            Intent intent = new Intent(a, IMPictureSelectorActivity.class);
            Fragment b = this.f11190b.mo47916b();
            if (b != null) {
                b.startActivityForResult(intent, i);
            } else {
                a.startActivityForResult(intent, i);
            }
        }
    }
}
