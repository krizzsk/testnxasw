package com.didi.beatles.p101im.picture.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.picture.config.IMPictureMimeType;
import com.didi.beatles.p101im.picture.entity.IMLocalMedia;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p101im.utils.imageloader.Callback;
import com.didi.beatles.p101im.utils.imageloader.IMImageRequestOptions;
import com.didi.beatles.p101im.views.widget.longimage.IMImageSource;
import com.didi.beatles.p101im.views.widget.longimage.IMImageViewState;
import com.didi.beatles.p101im.views.widget.longimage.IMSubsamplingScaleImageView;
import com.didi.beatles.p101im.views.widget.photoview.IMPhotoView;
import com.didi.beatles.p101im.views.widget.photoview.OnViewTapListener;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.beatles.im.picture.adapter.IMPicturePreviewFragmentAdapter */
public class IMPicturePreviewFragmentAdapter extends PagerAdapter {

    /* renamed from: a */
    private List<IMLocalMedia> f11217a;

    /* renamed from: b */
    private Context f11218b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OnCallBackActivity f11219c;

    /* renamed from: com.didi.beatles.im.picture.adapter.IMPicturePreviewFragmentAdapter$OnCallBackActivity */
    public interface OnCallBackActivity {
        void onActivityBackPressed();
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public IMPicturePreviewFragmentAdapter(List<IMLocalMedia> list, Context context, OnCallBackActivity onCallBackActivity) {
        this.f11217a = list;
        this.f11218b = context;
        this.f11219c = onCallBackActivity;
    }

    public int getCount() {
        List<IMLocalMedia> list = this.f11217a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        String str;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.im_picture_gallery_image_preview, viewGroup, false);
        final IMPhotoView iMPhotoView = (IMPhotoView) inflate.findViewById(R.id.preview_image);
        final IMSubsamplingScaleImageView iMSubsamplingScaleImageView = (IMSubsamplingScaleImageView) inflate.findViewById(R.id.long_img);
        IMLocalMedia iMLocalMedia = this.f11217a.get(i);
        if (iMLocalMedia != null) {
            String pictureType = iMLocalMedia.getPictureType();
            if (iMLocalMedia.isCut() && !iMLocalMedia.isCompressed()) {
                str = iMLocalMedia.getCutPath();
            } else if (iMLocalMedia.isCompressed() || (iMLocalMedia.isCut() && iMLocalMedia.isCompressed())) {
                str = iMLocalMedia.getCompressPath();
            } else {
                str = iMLocalMedia.getPath();
            }
            String str2 = str;
            boolean isGif = IMPictureMimeType.isGif(pictureType);
            final boolean isLongImg = IMPictureMimeType.isLongImg(iMLocalMedia);
            int i2 = 8;
            iMPhotoView.setVisibility((!isLongImg || isGif) ? 0 : 8);
            if (isLongImg && !isGif) {
                i2 = 0;
            }
            iMSubsamplingScaleImageView.setVisibility(i2);
            if (!isGif || iMLocalMedia.isCompressed()) {
                BtsImageLoader.getInstance().download(str2, 480, 800, new IMImageRequestOptions().diskCacheStrategy(IMImageRequestOptions.DiskCacheStrategy.ALL), new Callback() {
                    public void onFailed() {
                    }

                    public void onStart() {
                    }

                    public void onSuccess(Bitmap bitmap) {
                        if (bitmap == null) {
                            return;
                        }
                        if (isLongImg) {
                            IMPicturePreviewFragmentAdapter.this.m9763a(bitmap, iMSubsamplingScaleImageView);
                        } else {
                            iMPhotoView.setImageBitmap(bitmap);
                        }
                    }
                });
            } else {
                BtsImageLoader.getInstance().loadIntoAsGif(str2, iMPhotoView, (Callback) null);
            }
            iMPhotoView.setOnViewTapListener(new OnViewTapListener() {
                public void onViewTap(View view, float f, float f2) {
                    if (IMPicturePreviewFragmentAdapter.this.f11219c != null) {
                        IMPicturePreviewFragmentAdapter.this.f11219c.onActivityBackPressed();
                    }
                }
            });
            iMSubsamplingScaleImageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (IMPicturePreviewFragmentAdapter.this.f11219c != null) {
                        IMPicturePreviewFragmentAdapter.this.f11219c.onActivityBackPressed();
                    }
                }
            });
        }
        viewGroup.addView(inflate, 0);
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9763a(Bitmap bitmap, IMSubsamplingScaleImageView iMSubsamplingScaleImageView) {
        iMSubsamplingScaleImageView.setQuickScaleEnabled(true);
        iMSubsamplingScaleImageView.setZoomEnabled(true);
        iMSubsamplingScaleImageView.setPanEnabled(true);
        iMSubsamplingScaleImageView.setDoubleTapZoomDuration(100);
        iMSubsamplingScaleImageView.setMinimumScaleType(2);
        iMSubsamplingScaleImageView.setDoubleTapZoomDpi(2);
        iMSubsamplingScaleImageView.setImage(IMImageSource.cachedBitmap(bitmap), new IMImageViewState(0.0f, new PointF(0.0f, 0.0f), 0));
    }
}
