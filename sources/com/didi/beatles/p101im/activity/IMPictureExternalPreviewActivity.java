package com.didi.beatles.p101im.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.picture.config.IMPictureConfig;
import com.didi.beatles.p101im.picture.config.IMPictureMimeType;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMStreetUtils;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p101im.utils.imageloader.Callback;
import com.didi.beatles.p101im.utils.imageloader.IMImageRequestOptions;
import com.didi.beatles.p101im.views.widget.IMViewPager;
import com.didi.beatles.p101im.views.widget.longimage.IMImageSource;
import com.didi.beatles.p101im.views.widget.longimage.IMImageViewState;
import com.didi.beatles.p101im.views.widget.longimage.IMSubsamplingScaleImageView;
import com.didi.beatles.p101im.views.widget.photoview.IMPhotoView;
import com.didi.beatles.p101im.views.widget.photoview.OnViewTapListener;
import com.taxis99.R;
import java.util.ArrayList;

/* renamed from: com.didi.beatles.im.activity.IMPictureExternalPreviewActivity */
public class IMPictureExternalPreviewActivity extends IMPictureBaseActivity {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f10823a = IMPictureExternalPreviewActivity.class.getSimpleName();

    /* renamed from: b */
    private IMViewPager f10824b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ArrayList<String> f10825c = new ArrayList<>();

    /* renamed from: d */
    private int f10826d = 0;

    /* renamed from: e */
    private String f10827e;

    /* renamed from: f */
    private PreviewFragmentAdapter f10828f;

    public static void startActivity(Context context, int i, ArrayList<String> arrayList, String str) {
        Intent intent = new Intent(context, IMPictureExternalPreviewActivity.class);
        intent.putStringArrayListExtra(IMPictureConfig.EXTRA_PREVIEW_SELECT_LIST, arrayList);
        intent.putExtra("position", i);
        intent.putExtra(IMPictureConfig.EXTRA_WATER_MARK, str);
        boolean z = context instanceof Activity;
        if (!z) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        if (z) {
            ((Activity) context).overridePendingTransition(R.anim.im_activity_scale_in, 0);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityCreate(Bundle bundle) {
        super.onActivityCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.activity_im_picture_external_preview);
        if (getIntent() != null) {
            Intent intent = getIntent();
            this.f10826d = intent.getIntExtra("position", 0);
            this.f10825c = intent.getStringArrayListExtra(IMPictureConfig.EXTRA_PREVIEW_SELECT_LIST);
            this.f10827e = intent.getStringExtra(IMPictureConfig.EXTRA_WATER_MARK);
        }
        m9483c();
        m9484d();
    }

    /* renamed from: c */
    private void m9483c() {
        this.f10824b = (IMViewPager) findViewById(R.id.preview_pager);
        PreviewFragmentAdapter previewFragmentAdapter = new PreviewFragmentAdapter();
        this.f10828f = previewFragmentAdapter;
        this.f10824b.setAdapter(previewFragmentAdapter);
        this.f10824b.setCurrentItem(this.f10826d);
        this.f10824b.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                String b = IMPictureExternalPreviewActivity.f10823a;
                IMLog.m10020d(b, "[onPageSelected]" + (i + 1) + " / " + IMPictureExternalPreviewActivity.this.f10825c.size());
            }
        });
    }

    /* renamed from: d */
    private void m9484d() {
        if (!TextUtils.isEmpty(this.f10827e)) {
            IMStreetUtils.addWaterMark(this, this.f10827e);
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.im_activity_scale_out);
    }

    /* renamed from: com.didi.beatles.im.activity.IMPictureExternalPreviewActivity$PreviewFragmentAdapter */
    public class PreviewFragmentAdapter extends PagerAdapter {
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public PreviewFragmentAdapter() {
        }

        public int getCount() {
            if (IMPictureExternalPreviewActivity.this.f10825c != null) {
                return IMPictureExternalPreviewActivity.this.f10825c.size();
            }
            return 0;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.im_picture_image_preview, viewGroup, false);
            final IMPhotoView iMPhotoView = (IMPhotoView) inflate.findViewById(R.id.preview_image);
            final IMSubsamplingScaleImageView iMSubsamplingScaleImageView = (IMSubsamplingScaleImageView) inflate.findViewById(R.id.long_img);
            final ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.progress_bar);
            IMViewUtil.show((View) progressBar);
            IMImageRequestOptions diskCacheStrategy = new IMImageRequestOptions().diskCacheStrategy(IMImageRequestOptions.DiskCacheStrategy.ALL);
            BtsImageLoader.getInstance().download((String) IMPictureExternalPreviewActivity.this.f10825c.get(i), 480, 800, diskCacheStrategy, new Callback() {
                public void onFailed() {
                }

                public void onStart() {
                }

                public void onSuccess(Bitmap bitmap) {
                    if (bitmap != null) {
                        int width = bitmap.getWidth();
                        int height = bitmap.getHeight();
                        IMViewUtil.hide((View) progressBar);
                        if (IMPictureMimeType.isLongImg(width, height)) {
                            iMSubsamplingScaleImageView.setVisibility(0);
                            PreviewFragmentAdapter.this.displayLongPic(bitmap, iMSubsamplingScaleImageView);
                            return;
                        }
                        iMSubsamplingScaleImageView.setVisibility(8);
                        iMPhotoView.setImageBitmap(bitmap);
                    }
                }
            });
            iMPhotoView.setOnViewTapListener(new OnViewTapListener() {
                public void onViewTap(View view, float f, float f2) {
                    IMPictureExternalPreviewActivity.this.finish();
                }
            });
            iMSubsamplingScaleImageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    IMPictureExternalPreviewActivity.this.finish();
                }
            });
            viewGroup.addView(inflate, 0);
            return inflate;
        }

        /* access modifiers changed from: private */
        public void displayLongPic(Bitmap bitmap, IMSubsamplingScaleImageView iMSubsamplingScaleImageView) {
            iMSubsamplingScaleImageView.setQuickScaleEnabled(true);
            iMSubsamplingScaleImageView.setZoomEnabled(true);
            iMSubsamplingScaleImageView.setPanEnabled(true);
            iMSubsamplingScaleImageView.setDoubleTapZoomDuration(100);
            iMSubsamplingScaleImageView.setMinimumScaleType(2);
            iMSubsamplingScaleImageView.setDoubleTapZoomDpi(2);
            iMSubsamplingScaleImageView.setImage(IMImageSource.cachedBitmap(bitmap), new IMImageViewState(0.0f, new PointF(0.0f, 0.0f), 0));
        }
    }
}
