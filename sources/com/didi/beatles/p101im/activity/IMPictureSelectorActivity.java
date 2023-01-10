package com.didi.beatles.p101im.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.picture.IMPictureSelector;
import com.didi.beatles.p101im.picture.adapter.IMAlbumAdapter;
import com.didi.beatles.p101im.picture.adapter.IMMediaGridAdapter;
import com.didi.beatles.p101im.picture.config.IMPictureMimeType;
import com.didi.beatles.p101im.picture.entity.IMEventEntity;
import com.didi.beatles.p101im.picture.entity.IMLocalMedia;
import com.didi.beatles.p101im.picture.entity.IMLocalMediaFolder;
import com.didi.beatles.p101im.picture.loader.IMLocalMediaLoader;
import com.didi.beatles.p101im.picture.observable.IMMediaObservable;
import com.didi.beatles.p101im.picture.utils.IMPictureFileUtils;
import com.didi.beatles.p101im.picture.utils.IMStringUtils;
import com.didi.beatles.p101im.picture.widget.IMAlbumPopupWindow;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMPermissionUtil;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.didi.beatles.p101im.views.IMGridSpacingItemDecoration;
import com.didi.beatles.p101im.views.IMTipsToast;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* renamed from: com.didi.beatles.im.activity.IMPictureSelectorActivity */
public class IMPictureSelectorActivity extends IMPictureBaseActivity implements View.OnClickListener, IMAlbumAdapter.OnAlbumSelectListener, IMMediaGridAdapter.OnMediaSelectChangedListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f10843a = IMPictureSelectorActivity.class.getSimpleName();

    /* renamed from: b */
    private RelativeLayout f10844b;

    /* renamed from: c */
    private ImageView f10845c;

    /* renamed from: d */
    private TextView f10846d;

    /* renamed from: e */
    private FrameLayout f10847e;

    /* renamed from: f */
    private TextView f10848f;

    /* renamed from: g */
    private TextView f10849g;

    /* renamed from: h */
    private RecyclerView f10850h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public IMMediaGridAdapter f10851i;

    /* renamed from: j */
    private IMLocalMediaLoader f10852j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public List<IMLocalMediaFolder> f10853k = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: l */
    public List<IMLocalMedia> f10854l = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: m */
    public IMAlbumPopupWindow f10855m;

    /* access modifiers changed from: protected */
    public void onActivityCreate(Bundle bundle) {
        super.onActivityCreate(bundle);
        if (this.config == null) {
            IMLog.m10021e(f10843a, "[onActivityCreate] finish activity with NULL selection config.");
            SystemUtils.showToast(IMTipsToast.makeText((Context) this, (CharSequence) getString(R.string.bts_im_record_error_inner), 0));
            finish();
            return;
        }
        String str = f10843a;
        IMLog.m10020d(str, "[onActivityCreate] camera=" + this.config.camera);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        if (this.config.camera) {
            m9506a(bundle);
        } else {
            m9511b(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityDestroy() {
        super.onActivityDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    /* renamed from: a */
    private void m9506a(Bundle bundle) {
        if (bundle == null) {
            final String[] strArr = {Permission.CAMERA};
            IMPermissionUtil.checkAndRequestPermission((FragmentActivity) this, (IMPermissionUtil.OnPermissionGrantCallback) new IMPermissionUtil.OnPermissionGrantCallback() {
                public void onGranted(String... strArr) {
                    boolean z = false;
                    if (strArr != null) {
                        String[] strArr2 = strArr;
                        int length = strArr2.length;
                        int i = 0;
                        while (true) {
                            boolean z2 = true;
                            if (i >= length) {
                                z = true;
                                break;
                            }
                            String str = strArr2[i];
                            int length2 = strArr.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 >= length2) {
                                    z2 = false;
                                    break;
                                } else if (TextUtils.equals(str, strArr[i2])) {
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                            if (!z2) {
                                String b = IMPictureSelectorActivity.f10843a;
                                IMLog.m10020d(b, "[onGranted] requestPermission not granted : " + str);
                                break;
                            }
                            i++;
                        }
                    }
                    String b2 = IMPictureSelectorActivity.f10843a;
                    IMLog.m10020d(b2, "[onGranted] allGranted=" + z);
                    if (z) {
                        IMPictureSelectorActivity.this.onTakePhoto();
                    }
                }

                public void onDenied(IMPermissionUtil.PermissionDenyResult... permissionDenyResultArr) {
                    IMPictureSelectorActivity iMPictureSelectorActivity = IMPictureSelectorActivity.this;
                    SystemUtils.showToast(IMTipsToast.makeText((Context) iMPictureSelectorActivity, (CharSequence) iMPictureSelectorActivity.getString(R.string.im_picture_permission_reject_camera), 0));
                    IMPictureSelectorActivity.this.finish();
                }
            }, strArr);
        }
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.activity_im_picture_camera);
    }

    /* renamed from: b */
    private void m9511b(Bundle bundle) {
        setContentView((int) R.layout.activity_im_picture_selector);
        this.f10852j = new IMLocalMediaLoader(this, this.config.mimeType, this.config.isGif, (long) this.config.videoMaxSecond, (long) this.config.videoMinSecond);
        if (bundle != null) {
            this.selectionMedias = IMPictureSelector.obtainSelectorList(bundle);
        }
        m9513c();
        if (Build.VERSION.SDK_INT >= 16) {
            IMPermissionUtil.checkAndRequestPermission((FragmentActivity) this, (IMPermissionUtil.OnPermissionGrantCallback) new IMPermissionUtil.OnPermissionGrantCallback() {
                public void onGranted(String... strArr) {
                    IMLog.m10020d(IMPictureSelectorActivity.f10843a, "[onGranted] ......");
                    IMPictureSelectorActivity.this.readLocalMedia();
                }

                public void onDenied(IMPermissionUtil.PermissionDenyResult... permissionDenyResultArr) {
                    IMPictureSelectorActivity iMPictureSelectorActivity = IMPictureSelectorActivity.this;
                    SystemUtils.showToast(IMTipsToast.makeText((Context) iMPictureSelectorActivity, (CharSequence) iMPictureSelectorActivity.getString(R.string.im_picture_permission_reject_storage), 0));
                }
            }, new String[]{Permission.READ_EXTERNAL_STORAGE});
        } else {
            readLocalMedia();
        }
    }

    /* renamed from: c */
    private void m9513c() {
        this.f10844b = (RelativeLayout) findViewById(R.id.title_bar_layout_above);
        this.f10845c = (ImageView) findViewById(R.id.common_title_bar_left_img);
        this.f10846d = (TextView) findViewById(R.id.common_title_bar_middle_tv);
        this.f10847e = (FrameLayout) findViewById(R.id.im_picture_bottom_bar_container);
        this.f10848f = (TextView) findViewById(R.id.tv_picture_preview);
        this.f10849g = (TextView) findViewById(R.id.tv_send_image);
        this.f10850h = (RecyclerView) findViewById(R.id.im_media_recycler_view);
        this.f10844b.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_nomix_titlebar_bg));
        this.f10845c.setImageResource(IMResource.getDrawableID(R.drawable.im_common_title_bar_btn_back_selector));
        this.f10846d.setTextSize(0, IMResource.getDimension(R.dimen.im_nomix_titlebar_textsize, 18));
        this.f10846d.setTextColor(IMResource.getColor(R.color.im_nomix_color_titlebar_text));
        this.f10845c.setOnClickListener(this);
        this.f10846d.setOnClickListener(this);
        this.f10848f.setText(R.string.im_picture_preview);
        this.f10848f.setOnClickListener(this);
        this.f10849g.setOnClickListener(this);
        this.f10846d.setText(getString(R.string.im_picture_camera_roll));
        updateBottomBar((List<IMLocalMedia>) null);
        IMAlbumPopupWindow iMAlbumPopupWindow = new IMAlbumPopupWindow(this, this.config.mimeType);
        this.f10855m = iMAlbumPopupWindow;
        iMAlbumPopupWindow.setPictureTitleView(this.f10846d);
        this.f10855m.setOnAlbumSelectListener(this);
        IMMediaGridAdapter iMMediaGridAdapter = new IMMediaGridAdapter(this.mContext, this.config);
        this.f10851i = iMMediaGridAdapter;
        iMMediaGridAdapter.setOnMediaSelectChangedListener(this);
        this.f10851i.bindSelectImages(this.selectionMedias);
        this.f10850h.setHasFixedSize(true);
        if (this.config.imageSpanCount == 0) {
            IMLog.m10021e(f10843a, "[initViews] reset image span count");
            this.config.imageSpanCount = 4;
        }
        this.f10850h.addItemDecoration(new IMGridSpacingItemDecoration(this.config.imageSpanCount, IMViewUtil.dp2px(this, 2.0f), false));
        this.f10850h.setLayoutManager(new GridLayoutManager(this, this.config.imageSpanCount));
        ((SimpleItemAnimator) this.f10850h.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f10850h.setAdapter(this.f10851i);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        IMMediaGridAdapter iMMediaGridAdapter = this.f10851i;
        if (iMMediaGridAdapter != null) {
            IMPictureSelector.saveSelectorList(bundle, iMMediaGridAdapter.getSelectedImages());
        }
    }

    /* access modifiers changed from: protected */
    public void readLocalMedia() {
        IMLog.m10020d(f10843a, "[readLocalMedia] start...");
        this.f10852j.loadAllMedia(new IMLocalMediaLoader.LocalMediaLoadListener() {
            public void onLoadComplete(List<IMLocalMediaFolder> list) {
                if (list == null) {
                    IMLog.m10021e(IMPictureSelectorActivity.f10843a, "[readLocalMedia] Null folders");
                    return;
                }
                String b = IMPictureSelectorActivity.f10843a;
                StringBuilder sb = new StringBuilder();
                sb.append("[onLoadComplete] -> ");
                sb.append(list == null ? "NULL" : Integer.valueOf(list.size()));
                IMLog.m10020d(b, sb.toString());
                if (list.size() > 0) {
                    List unused = IMPictureSelectorActivity.this.f10853k = list;
                    IMLocalMediaFolder iMLocalMediaFolder = list.get(0);
                    iMLocalMediaFolder.setChecked(true);
                    List<IMLocalMedia> images = iMLocalMediaFolder.getImages();
                    if (images.size() >= IMPictureSelectorActivity.this.f10854l.size()) {
                        List unused2 = IMPictureSelectorActivity.this.f10854l = images;
                        IMPictureSelectorActivity.this.f10855m.bindFolder(list);
                    }
                }
                if (IMPictureSelectorActivity.this.f10851i != null) {
                    if (IMPictureSelectorActivity.this.f10854l == null) {
                        List unused3 = IMPictureSelectorActivity.this.f10854l = new ArrayList();
                    }
                    IMPictureSelectorActivity.this.f10851i.bindImagesData(IMPictureSelectorActivity.this.f10854l);
                }
            }
        });
    }

    public void startOpenCamera() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(getPackageManager()) != null) {
            File createCameraFile = IMPictureFileUtils.createCameraFile(this, this.config.mimeType == 0 ? 1 : this.config.mimeType, this.outputCameraPath, this.config.suffixType);
            this.cameraPath = createCameraFile.getAbsolutePath();
            Uri a = m9503a(createCameraFile);
            String str = f10843a;
            IMLog.m10020d(str, "[startOpenCamera] imageUri->" + a);
            if (a != null) {
                try {
                    intent.putExtra("output", a);
                    startActivityForResult(intent, 909);
                } catch (Exception e) {
                    IMLog.m10021e(f10843a, "[startOpenCamera]", e);
                    SystemUtils.showToast(IMTipsToast.makeText(this.mContext, (CharSequence) getString(R.string.bts_im_record_error_inner), 0));
                    finish();
                }
            } else {
                IMLog.m10021e(f10843a, "[startOpenCamera] generate invalid image uri");
                SystemUtils.showToast(IMTipsToast.makeText(this.mContext, (CharSequence) getString(R.string.bts_im_record_error_inner), 0));
                finish();
            }
        }
    }

    /* renamed from: a */
    private Uri m9503a(File file) {
        String str = getPackageName() + ".com.didi.beatles.im.fileprovider";
        if (Build.VERSION.SDK_INT < 23) {
            return Uri.fromFile(file);
        }
        try {
            return FileProvider.getUriForFile(this.mContext, str, file);
        } catch (Exception e) {
            IMLog.m10021e(f10843a, "[parUri]", e);
            return null;
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.common_title_bar_left_img) {
            if (this.f10855m.isShowing()) {
                this.f10855m.dismiss();
            } else {
                finish();
            }
        } else if (id == R.id.common_title_bar_middle_tv) {
            if (this.f10855m.isShowing()) {
                this.f10855m.dismiss();
                return;
            }
            List<IMLocalMedia> list = this.f10854l;
            if (list != null && list.size() > 0) {
                this.f10855m.showAsDropDown(this.f10846d);
                this.f10855m.notifyDataCheckedStatus(this.f10851i.getSelectedImages());
            }
        } else if (id == R.id.tv_picture_preview) {
            List<IMLocalMedia> selectedImages = this.f10851i.getSelectedImages();
            ArrayList arrayList = new ArrayList();
            for (IMLocalMedia add : selectedImages) {
                arrayList.add(add);
            }
            IMPictureGalleryPreviewActivity.startActivity(this, arrayList, selectedImages, true);
        } else if (id == R.id.tv_send_image) {
            List<IMLocalMedia> selectedImages2 = this.f10851i.getSelectedImages();
            int size = selectedImages2.size();
            if (this.config.minSelectNum > 0 && this.config.selectionMode == 2 && size < this.config.minSelectNum) {
                SystemUtils.showToast(IMTipsToast.makeText(this.mContext, (CharSequence) getString(R.string.im_picture_min_img_num, new Object[]{Integer.valueOf(this.config.minSelectNum)}), 0));
            } else if (this.config.isCompress) {
                compressImage(selectedImages2);
            } else {
                onResult(selectedImages2);
            }
        }
    }

    public void onTakePhoto() {
        startOpenCamera();
    }

    public void onMediaSelectChange(List<IMLocalMedia> list) {
        updateBottomBar(list);
    }

    public void onMediaPreviewClick(IMLocalMedia iMLocalMedia, int i) {
        startPreview(this.f10851i.getImages(), i);
    }

    public void startPreview(List<IMLocalMedia> list, int i) {
        int isPictureType = IMPictureMimeType.isPictureType(list.get(i).getPictureType());
        if (isPictureType != 1) {
            String str = f10843a;
            IMLog.m10021e(str, "[startPreview] with invalid mediaType : " + isPictureType);
            return;
        }
        List<IMLocalMedia> selectedImages = this.f10851i.getSelectedImages();
        IMMediaObservable.getInstance().saveLocalMedia(list);
        IMPictureGalleryPreviewActivity.startActivity(this, selectedImages, i);
    }

    public void updateBottomBar(List<IMLocalMedia> list) {
        if (list != null && list.size() > 0) {
            this.f10847e.setSelected(true);
            this.f10848f.setEnabled(true);
            this.f10848f.setAlpha(1.0f);
            this.f10849g.setEnabled(true);
            this.f10849g.setAlpha(1.0f);
            this.f10849g.setText(String.format(getString(R.string.im_picture_send_with_count), new Object[]{Integer.valueOf(list.size())}));
            return;
        }
        this.f10847e.setSelected(false);
        this.f10848f.setEnabled(false);
        this.f10848f.setAlpha(0.5f);
        this.f10849g.setEnabled(false);
        this.f10849g.setText(String.format(getString(R.string.im_picture_send), new Object[0]));
        this.f10849g.setAlpha(0.5f);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            ArrayList arrayList = new ArrayList();
            if (i == 909) {
                File file = new File(this.cameraPath);
                sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
                String absolutePath = file.getAbsolutePath();
                rotateImage(IMPictureFileUtils.readPictureDegree(absolutePath), file);
                IMLocalMedia iMLocalMedia = new IMLocalMedia();
                iMLocalMedia.setPath(this.cameraPath);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(absolutePath, options);
                iMLocalMedia.setWidth(options.outWidth);
                iMLocalMedia.setHeight(options.outHeight);
                iMLocalMedia.setSize(file.length());
                iMLocalMedia.setPictureType(IMPictureMimeType.createImageType(this.cameraPath));
                iMLocalMedia.setMimeType(this.config.mimeType);
                if (!this.config.camera) {
                    this.f10854l.add(0, iMLocalMedia);
                    IMMediaGridAdapter iMMediaGridAdapter = this.f10851i;
                    if (iMMediaGridAdapter != null) {
                        List<IMLocalMedia> selectedImages = iMMediaGridAdapter.getSelectedImages();
                        if (selectedImages.size() < this.config.maxSelectNum) {
                            if ((IMPictureMimeType.mimeToEqual(selectedImages.size() > 0 ? selectedImages.get(0).getPictureType() : "", iMLocalMedia.getPictureType()) || selectedImages.size() == 0) && selectedImages.size() < this.config.maxSelectNum) {
                                if (this.config.selectionMode == 1) {
                                    m9514d();
                                }
                                selectedImages.add(iMLocalMedia);
                                this.f10851i.bindSelectImages(selectedImages);
                            }
                        }
                        this.f10851i.notifyDataSetChanged();
                    }
                } else if (this.config.isCompress) {
                    arrayList.add(iMLocalMedia);
                    compressImage(arrayList);
                    if (this.f10851i != null) {
                        this.f10854l.add(0, iMLocalMedia);
                        this.f10851i.notifyDataSetChanged();
                    }
                } else {
                    arrayList.add(iMLocalMedia);
                    onResult(arrayList);
                }
                if (this.f10851i != null) {
                    m9507a(iMLocalMedia);
                }
            }
        } else if (i2 != 0) {
        } else {
            if (this.config == null) {
                IMLog.m10021e(f10843a, "[onActivityResult] NULL config");
                finish();
            } else if (this.config.camera) {
                finish();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void rotateImage(int i, File file) {
        if (i > 0) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 2;
                IMPictureFileUtils.saveBitmapFile(IMPictureFileUtils.rotaingImageView(i, BitmapFactory.decodeFile(file.getAbsolutePath(), options)), file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: d */
    private void m9514d() {
        List<IMLocalMedia> selectedImages;
        IMMediaGridAdapter iMMediaGridAdapter = this.f10851i;
        if (iMMediaGridAdapter != null && (selectedImages = iMMediaGridAdapter.getSelectedImages()) != null && selectedImages.size() > 0) {
            selectedImages.clear();
        }
    }

    /* renamed from: a */
    private void m9507a(IMLocalMedia iMLocalMedia) {
        try {
            createNewFolder(this.f10853k);
            IMLocalMediaFolder imageFolder = getImageFolder(iMLocalMedia.getPath(), this.f10853k);
            IMLocalMediaFolder iMLocalMediaFolder = this.f10853k.size() > 0 ? this.f10853k.get(0) : null;
            if (iMLocalMediaFolder != null && imageFolder != null) {
                iMLocalMediaFolder.setFirstImagePath(iMLocalMedia.getPath());
                iMLocalMediaFolder.setImages(this.f10854l);
                iMLocalMediaFolder.setImageNum(iMLocalMediaFolder.getImageNum() + 1);
                imageFolder.setImageNum(imageFolder.getImageNum() + 1);
                imageFolder.getImages().add(0, iMLocalMedia);
                imageFolder.setFirstImagePath(this.cameraPath);
                this.f10855m.bindFolder(this.f10853k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPictureEvent(IMEventEntity iMEventEntity) {
        String str = f10843a;
        IMLog.m10020d(str, "[onPictureEvent] what=" + iMEventEntity.what + " |position=" + iMEventEntity.position);
        int i = iMEventEntity.what;
        if (i == 2771) {
            List<IMLocalMedia> list = iMEventEntity.medias;
            if (list.size() > 0) {
                String pictureType = list.get(0).getPictureType();
                if (!this.config.isCompress || !pictureType.startsWith("image")) {
                    onResult(list);
                } else {
                    compressImage(list);
                }
            }
        } else if (i == 2774) {
            List<IMLocalMedia> list2 = iMEventEntity.medias;
            int i2 = iMEventEntity.position;
            String str2 = f10843a;
            IMLog.m10024i(str2, "[onPictureEvent] #UPDATE_FLAG# " + i2);
            this.f10851i.bindSelectImages(list2);
            this.f10851i.notifyItemChanged(i2);
        }
    }

    public void onAlbumSelect(String str, List<IMLocalMedia> list) {
        boolean isCamera = IMStringUtils.isCamera(str);
        if (!this.config.showCameraInGallery) {
            isCamera = false;
        }
        this.f10851i.setShowCamera(isCamera);
        this.f10846d.setText(str);
        this.f10851i.bindImagesData(list);
        this.f10855m.dismiss();
    }
}
