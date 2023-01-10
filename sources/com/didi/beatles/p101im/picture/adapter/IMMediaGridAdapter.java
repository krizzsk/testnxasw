package com.didi.beatles.p101im.picture.adapter;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.picture.anim.IMOptAnimationLoader;
import com.didi.beatles.p101im.picture.config.IMPictureMimeType;
import com.didi.beatles.p101im.picture.config.IMPictureSelectionConfig;
import com.didi.beatles.p101im.picture.entity.IMLocalMedia;
import com.didi.beatles.p101im.picture.utils.IMPictureFileUtils;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.didi.beatles.p101im.utils.imageloader.Animator;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p101im.utils.imageloader.Callback;
import com.didi.beatles.p101im.utils.imageloader.IMImageRequestOptions;
import com.didi.beatles.p101im.views.IMTipsToast;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.didi.beatles.im.picture.adapter.IMMediaGridAdapter */
public class IMMediaGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a */
    private static final int f11197a = 450;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f11198b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f11199c = true;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public OnMediaSelectChangedListener f11200d;

    /* renamed from: e */
    private int f11201e;

    /* renamed from: f */
    private List<IMLocalMedia> f11202f = new ArrayList();

    /* renamed from: g */
    private List<IMLocalMedia> f11203g = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f11204h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f11205i = 2;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f11206j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f11207k = false;

    /* renamed from: l */
    private boolean f11208l;

    /* renamed from: m */
    private int f11209m;

    /* renamed from: n */
    private int f11210n;

    /* renamed from: o */
    private float f11211o;

    /* renamed from: p */
    private Animation f11212p;

    /* renamed from: q */
    private IMPictureSelectionConfig f11213q;

    /* renamed from: r */
    private int f11214r;

    /* renamed from: s */
    private boolean f11215s;

    /* renamed from: t */
    private boolean f11216t;

    /* renamed from: com.didi.beatles.im.picture.adapter.IMMediaGridAdapter$OnMediaSelectChangedListener */
    public interface OnMediaSelectChangedListener {
        void onMediaPreviewClick(IMLocalMedia iMLocalMedia, int i);

        void onMediaSelectChange(List<IMLocalMedia> list);

        void onTakePhoto();
    }

    public IMMediaGridAdapter(Context context, IMPictureSelectionConfig iMPictureSelectionConfig) {
        this.f11198b = context;
        this.f11213q = iMPictureSelectionConfig;
        this.f11205i = iMPictureSelectionConfig.selectionMode;
        this.f11199c = iMPictureSelectionConfig.showCameraInGallery;
        this.f11201e = iMPictureSelectionConfig.maxSelectNum;
        this.f11204h = iMPictureSelectionConfig.enablePreview;
        this.f11206j = iMPictureSelectionConfig.enPreviewVideo;
        this.f11207k = iMPictureSelectionConfig.enablePreviewAudio;
        this.f11208l = iMPictureSelectionConfig.enableSelectOverlay;
        this.f11209m = iMPictureSelectionConfig.overrideWidth;
        this.f11210n = iMPictureSelectionConfig.overrideHeight;
        this.f11211o = iMPictureSelectionConfig.sizeMultiplier;
        this.f11214r = iMPictureSelectionConfig.mimeType;
        this.f11215s = iMPictureSelectionConfig.zoomAnim;
        this.f11212p = IMOptAnimationLoader.loadAnimation(context, R.anim.im_picture_modal_in);
    }

    public void setShowCamera(boolean z) {
        this.f11199c = z;
    }

    public void bindImagesData(List<IMLocalMedia> list) {
        this.f11202f = list;
        notifyDataSetChanged();
    }

    public void bindSelectImages(List<IMLocalMedia> list) {
        ArrayList arrayList = new ArrayList();
        for (IMLocalMedia add : list) {
            arrayList.add(add);
        }
        this.f11203g = arrayList;
        m9754b();
        OnMediaSelectChangedListener onMediaSelectChangedListener = this.f11200d;
        if (onMediaSelectChangedListener != null) {
            onMediaSelectChangedListener.onMediaSelectChange(this.f11203g);
        }
    }

    public List<IMLocalMedia> getSelectedImages() {
        if (this.f11203g == null) {
            this.f11203g = new ArrayList();
        }
        return this.f11203g;
    }

    public List<IMLocalMedia> getImages() {
        if (this.f11202f == null) {
            this.f11202f = new ArrayList();
        }
        return this.f11202f;
    }

    public int getItemViewType(int i) {
        return (!this.f11199c || i != 0) ? 2 : 1;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new CameraViewHolder(LayoutInflater.from(this.f11198b).inflate(R.layout.im_picture_camera_item_view, viewGroup, false));
        }
        return new ImageViewHolder(LayoutInflater.from(this.f11198b).inflate(R.layout.im_picture_image_item_view, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int i2 = i;
        if (getItemViewType(i2) == 1) {
            ((CameraViewHolder) viewHolder).headerView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (IMMediaGridAdapter.this.f11200d != null) {
                        IMMediaGridAdapter.this.f11200d.onTakePhoto();
                    }
                }
            });
            return;
        }
        ImageViewHolder imageViewHolder = (ImageViewHolder) viewHolder;
        IMLocalMedia iMLocalMedia = this.f11202f.get(this.f11199c ? i2 - 1 : i2);
        iMLocalMedia.position = imageViewHolder.getAdapterPosition();
        String path = iMLocalMedia.getPath();
        String pictureType = iMLocalMedia.getPictureType();
        m9751a(imageViewHolder, iMLocalMedia);
        selectImage(imageViewHolder, isSelected(iMLocalMedia), false);
        int isPictureType = IMPictureMimeType.isPictureType(pictureType);
        boolean isGif = IMPictureMimeType.isGif(pictureType);
        boolean isLongImg = IMPictureMimeType.isLongImg(iMLocalMedia);
        if (isGif) {
            IMViewUtil.show((View) imageViewHolder.tvImageTag);
            imageViewHolder.tvImageTag.setText(this.f11198b.getResources().getString(R.string.im_picture_gif_tag));
        } else if (isLongImg) {
            IMViewUtil.show((View) imageViewHolder.tvImageTag);
            imageViewHolder.tvImageTag.setText(this.f11198b.getResources().getString(R.string.im_picture_long_chart));
        } else {
            IMViewUtil.hide((View) imageViewHolder.tvImageTag);
            imageViewHolder.tvImageTag.setText("");
        }
        IMImageRequestOptions placeholder = new IMImageRequestOptions().diskCacheStrategy(IMImageRequestOptions.DiskCacheStrategy.ALL).centerCrop().placeholder(R.drawable.im_bg_picture_image);
        if (this.f11209m > 0 || this.f11210n > 0) {
            placeholder.override(this.f11209m, this.f11210n);
        } else {
            placeholder.sizeMultiplier(this.f11211o);
        }
        BtsImageLoader.getInstance().loadInto(path, imageViewHolder.ivImage, (Animator) null, placeholder, (Callback) null);
        if (this.f11204h || this.f11206j || this.f11207k) {
            final String str = path;
            final int i3 = isPictureType;
            final ImageViewHolder imageViewHolder2 = imageViewHolder;
            final IMLocalMedia iMLocalMedia2 = iMLocalMedia;
            imageViewHolder.viewSelectMask.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (!IMPictureFileUtils.isFileExists(IMMediaGridAdapter.this.f11198b, str)) {
                        SystemUtils.showToast(IMTipsToast.makeText(IMMediaGridAdapter.this.f11198b, (CharSequence) IMPictureMimeType.m9767s(IMMediaGridAdapter.this.f11198b, i3), 0));
                    } else {
                        IMMediaGridAdapter.this.m9756b(imageViewHolder2, iMLocalMedia2);
                    }
                }
            });
        }
        final String str2 = path;
        final int i4 = isPictureType;
        final int i5 = i;
        final IMLocalMedia iMLocalMedia3 = iMLocalMedia;
        final ImageViewHolder imageViewHolder3 = imageViewHolder;
        imageViewHolder.contentView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                boolean z = false;
                if (!IMPictureFileUtils.isFileExists(IMMediaGridAdapter.this.f11198b, str2)) {
                    SystemUtils.showToast(IMTipsToast.makeText(IMMediaGridAdapter.this.f11198b, (CharSequence) IMPictureMimeType.m9767s(IMMediaGridAdapter.this.f11198b, i4), 0));
                    return;
                }
                int i = IMMediaGridAdapter.this.f11199c ? i5 - 1 : i5;
                if ((i4 == 1 && IMMediaGridAdapter.this.f11204h) || ((i4 == 2 && (IMMediaGridAdapter.this.f11206j || IMMediaGridAdapter.this.f11205i == 1)) || (i4 == 3 && (IMMediaGridAdapter.this.f11207k || IMMediaGridAdapter.this.f11205i == 1)))) {
                    z = true;
                }
                if (z) {
                    IMMediaGridAdapter.this.f11200d.onMediaPreviewClick(iMLocalMedia3, i);
                } else {
                    IMMediaGridAdapter.this.m9756b(imageViewHolder3, iMLocalMedia3);
                }
            }
        });
    }

    public int getItemCount() {
        return this.f11199c ? this.f11202f.size() + 1 : this.f11202f.size();
    }

    /* renamed from: com.didi.beatles.im.picture.adapter.IMMediaGridAdapter$CameraViewHolder */
    public class CameraViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public View headerView;
        private TextView tvCamera;

        public CameraViewHolder(View view) {
            super(view);
            this.headerView = view;
            TextView textView = (TextView) view.findViewById(R.id.picture_item_tv_camera);
            this.tvCamera = textView;
            textView.setText(IMMediaGridAdapter.this.f11198b.getString(R.string.im_picture_take_picture));
        }
    }

    /* renamed from: com.didi.beatles.im.picture.adapter.IMMediaGridAdapter$ImageViewHolder */
    public class ImageViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public View contentView;
        /* access modifiers changed from: private */
        public ImageView ivImage;
        /* access modifiers changed from: private */
        public TextView tvImageTag;
        /* access modifiers changed from: private */
        public TextView tvSelect;
        /* access modifiers changed from: private */
        public View viewSelectMask;

        public ImageViewHolder(View view) {
            super(view);
            this.contentView = view;
            this.ivImage = (ImageView) view.findViewById(R.id.iv_image);
            this.viewSelectMask = view.findViewById(R.id.view_select_mask);
            this.tvSelect = (TextView) view.findViewById(R.id.tv_select);
            this.tvImageTag = (TextView) view.findViewById(R.id.tv_image_tag);
        }
    }

    public boolean isSelected(IMLocalMedia iMLocalMedia) {
        for (IMLocalMedia path : this.f11203g) {
            if (path.getPath().equals(iMLocalMedia.getPath())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m9751a(ImageViewHolder imageViewHolder, IMLocalMedia iMLocalMedia) {
        imageViewHolder.tvSelect.setText("");
        for (IMLocalMedia next : this.f11203g) {
            if (next.getPath().equals(iMLocalMedia.getPath())) {
                iMLocalMedia.setNum(next.getNum());
                next.setPosition(iMLocalMedia.getPosition());
                imageViewHolder.tvSelect.setText(String.valueOf(iMLocalMedia.getNum()));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9756b(ImageViewHolder imageViewHolder, IMLocalMedia iMLocalMedia) {
        boolean isSelected = imageViewHolder.tvSelect.isSelected();
        int size = this.f11203g.size();
        int i = this.f11201e;
        if (size < i || isSelected) {
            if (isSelected) {
                Iterator<IMLocalMedia> it = this.f11203g.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    IMLocalMedia next = it.next();
                    if (next.getPath().equals(iMLocalMedia.getPath())) {
                        this.f11203g.remove(next);
                        m9754b();
                        m9755b(imageViewHolder.ivImage);
                        break;
                    }
                }
            } else {
                if (this.f11205i == 1) {
                    m9749a();
                }
                this.f11203g.add(iMLocalMedia);
                iMLocalMedia.setNum(this.f11203g.size());
                m9750a(imageViewHolder.ivImage);
            }
            notifyItemChanged(imageViewHolder.getAdapterPosition());
            selectImage(imageViewHolder, !isSelected, true);
            OnMediaSelectChangedListener onMediaSelectChangedListener = this.f11200d;
            if (onMediaSelectChangedListener != null) {
                onMediaSelectChangedListener.onMediaSelectChange(this.f11203g);
                return;
            }
            return;
        }
        Context context = this.f11198b;
        SystemUtils.showToast(IMTipsToast.makeText(context, (CharSequence) context.getString(R.string.im_picture_message_max_num, new Object[]{Integer.valueOf(i)}), 0));
    }

    /* renamed from: a */
    private void m9749a() {
        List<IMLocalMedia> list = this.f11203g;
        if (list != null && list.size() > 0) {
            this.f11216t = true;
            int i = 0;
            IMLocalMedia iMLocalMedia = this.f11203g.get(0);
            if (this.f11213q.showCameraInGallery || this.f11216t) {
                i = iMLocalMedia.position;
            } else if (iMLocalMedia.position > 0) {
                i = iMLocalMedia.position - 1;
            }
            notifyItemChanged(i);
            this.f11203g.clear();
        }
    }

    /* renamed from: b */
    private void m9754b() {
        int size = this.f11203g.size();
        int i = 0;
        while (i < size) {
            IMLocalMedia iMLocalMedia = this.f11203g.get(i);
            i++;
            iMLocalMedia.setNum(i);
            notifyItemChanged(iMLocalMedia.position);
        }
    }

    public void selectImage(ImageViewHolder imageViewHolder, boolean z, boolean z2) {
        imageViewHolder.tvSelect.setSelected(z);
        if (z2 && z && this.f11212p != null) {
            imageViewHolder.tvSelect.startAnimation(this.f11212p);
        }
        if (!this.f11208l) {
            return;
        }
        if (z) {
            imageViewHolder.ivImage.setColorFilter(ContextCompat.getColor(this.f11198b, R.color.im_picture_image_selected_overlay), PorterDuff.Mode.SRC_ATOP);
        } else {
            imageViewHolder.ivImage.clearColorFilter();
        }
    }

    public void setOnMediaSelectChangedListener(OnMediaSelectChangedListener onMediaSelectChangedListener) {
        this.f11200d = onMediaSelectChangedListener;
    }

    /* renamed from: a */
    private void m9750a(ImageView imageView) {
        if (this.f11215s) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new android.animation.Animator[]{ObjectAnimator.ofFloat(imageView, "scaleX", new float[]{1.0f, 1.12f}), ObjectAnimator.ofFloat(imageView, "scaleY", new float[]{1.0f, 1.12f})});
            animatorSet.setDuration(450);
            animatorSet.start();
        }
    }

    /* renamed from: b */
    private void m9755b(ImageView imageView) {
        if (this.f11215s) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new android.animation.Animator[]{ObjectAnimator.ofFloat(imageView, "scaleX", new float[]{1.12f, 1.0f}), ObjectAnimator.ofFloat(imageView, "scaleY", new float[]{1.12f, 1.0f})});
            animatorSet.setDuration(450);
            animatorSet.start();
        }
    }
}
