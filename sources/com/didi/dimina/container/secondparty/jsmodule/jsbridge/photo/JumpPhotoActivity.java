package com.didi.dimina.container.secondparty.jsmodule.jsbridge.photo;

import android.app.Activity;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.photo.PhotoService;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.photo.TakePhotoActivity;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.PermissionUtil;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.webview.image.PicUploadActivity;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.taxis99.R;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;

public class JumpPhotoActivity extends Activity {
    public static final String TAG = "JumpPhotoActivity";

    /* renamed from: a */
    private static final String f19101a = "param_camera_direction";

    /* renamed from: b */
    private static final String f19102b = "param_photo_max_size";

    /* renamed from: c */
    private static final String f19103c = "param_photo_max_side_length";

    /* renamed from: d */
    private static final String f19104d = "param_photo_theme_color";

    /* renamed from: e */
    private static final String f19105e = "param_photo_capture_type";

    /* renamed from: f */
    private static final String f19106f = "param_photo_source_type";

    /* renamed from: g */
    private static final String f19107g = "param_dimina_index";

    /* renamed from: h */
    private static final int f19108h = 3;

    /* renamed from: i */
    private static final int f19109i = 4;

    /* renamed from: j */
    private static final int f19110j = 5;

    /* renamed from: k */
    private static final int f19111k = 6;

    /* renamed from: l */
    private DMMina f19112l;

    /* renamed from: m */
    private int f19113m;

    /* renamed from: n */
    private long f19114n;

    /* renamed from: o */
    private int f19115o;

    /* renamed from: p */
    private String f19116p;

    /* renamed from: q */
    private int f19117q;

    /* renamed from: r */
    private int f19118r;

    /* renamed from: s */
    private PhotoDialog f19119s;

    /* renamed from: t */
    private String f19120t;

    /* renamed from: u */
    private int f19121u;

    public static void jumpSystemPhoto(PhotoService.Config config) {
        Activity activity = config.activity;
        if (activity != null) {
            if ((config.cameraDirection == 1 || config.cameraDirection == 0) && config.photoMaxSideLength > 0 && config.photoMaxSize > 0) {
                Intent intent = new Intent();
                intent.setClass(activity, JumpPhotoActivity.class);
                intent.putExtra(f19101a, config.cameraDirection);
                intent.putExtra(f19102b, config.photoMaxSize);
                intent.putExtra(f19103c, config.photoMaxSideLength);
                intent.putExtra(f19104d, config.themeColor);
                intent.putExtra(f19105e, config.captureType.ordinal());
                intent.putExtra(f19107g, config.mina.getMinaIndex());
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.dimina_photo_dialog_enter, 0);
            }
        }
    }

    public static void startByChooseImage(ChooseImageReq chooseImageReq) {
        Activity activity = chooseImageReq.activity;
        if (activity != null) {
            Intent intent = new Intent(activity, JumpPhotoActivity.class);
            intent.putExtra(f19106f, chooseImageReq.sourceType);
            intent.putExtra(f19105e, chooseImageReq.captureType);
            intent.putExtra(f19102b, ((long) chooseImageReq.maxSize) * 1024);
            intent.putExtra(f19107g, chooseImageReq.mina.getMinaIndex());
            intent.putExtra(Const.PageParams.COUNT, chooseImageReq.count);
            activity.startActivity(intent);
            activity.overridePendingTransition(R.anim.dimina_photo_dialog_enter, 0);
        }
    }

    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.f19112l = DMMinaPool.get(intent.getIntExtra(f19107g, -1));
        this.f19113m = intent.getIntExtra(f19101a, 1);
        this.f19114n = intent.getLongExtra(f19102b, 512000);
        this.f19115o = intent.getIntExtra(f19103c, 650);
        this.f19117q = intent.getIntExtra(f19104d, Color.parseColor("#2E2E3A"));
        this.f19118r = intent.getIntExtra(f19105e, PhotoService.CaptureType.NORMAL.ordinal());
        this.f19120t = intent.getStringExtra(f19106f);
        this.f19121u = intent.getIntExtra(Const.PageParams.COUNT, 1);
        if (TextUtils.isEmpty(this.f19120t)) {
            this.f19120t = "all";
        }
        if ("all".equals(this.f19120t)) {
            showDialog();
        } else if (ChooseImageReq.SOURCE_TYPE_ALBUM.equals(this.f19120t)) {
            m16228c();
        } else {
            m16222a();
        }
        if (Build.VERSION.SDK_INT != 26) {
            SystemUtils.hookSetRequestedOrientation(this, 1);
        }
    }

    public void showDialog() {
        PhotoDialog photoDialog = new PhotoDialog(this);
        this.f19119s = photoDialog;
        photoDialog.mo60717a(this.f19117q);
        this.f19119s.mo60718a((SingleCallback<Void>) new SingleCallback<Void>() {
            public void onCallback(Void voidR) {
                JumpPhotoActivity.this.m16228c();
            }
        });
        this.f19119s.mo60719b(new SingleCallback<Void>() {
            public void onCallback(Void voidR) {
                JumpPhotoActivity.this.m16222a();
            }
        });
        this.f19119s.mo60720c(new SingleCallback<Void>() {
            public void onCallback(Void voidR) {
                PhotoService.m16237a(1002, (String) null, (String) null, (String) null);
                JumpPhotoActivity.this.finish();
                JumpPhotoActivity.this.overridePendingTransition(0, R.anim.dimina_photo_dialog_outer);
            }
        });
        this.f19119s.mo60716a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16222a() {
        if (this.f19118r == PhotoService.CaptureType.NORMAL.ordinal()) {
            m16226b();
        } else if (this.f19118r == PhotoService.CaptureType.CARD.ordinal()) {
            m16225a(TakePhotoActivity.PhotoType.TYPE_CARD);
        } else if (this.f19118r == PhotoService.CaptureType.HOLD_CARD.ordinal()) {
            m16225a(TakePhotoActivity.PhotoType.TYPE_PEOPLE_HOLD_CARD);
        }
    }

    /* renamed from: b */
    private void m16226b() {
        if (!PermissionUtil.requestCameraPermission(this)) {
            PhotoService.m16237a(1001, (String) null, (String) null, (String) null);
            LogUtil.eRelease(TAG, "没有相机权限，直接返回");
            return;
        }
        m16231f();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 6) {
                ClipData clipData = intent.getClipData();
                if (clipData != null) {
                    LogUtil.iRelease(TAG, "用户选择了多张: " + clipData.toString());
                    m16223a(clipData);
                    return;
                }
                this.f19116p = Utils.getPath(this, intent.getData());
                LogUtil.iRelease(TAG, "用户只选择了一张:" + this.f19116p);
            }
            if (!(i == 5 || i == 3 || i != 4)) {
                if (Build.VERSION.SDK_INT >= 24) {
                    this.f19116p = Utils.getFilePathFromURIForAPI24(this, intent.getData());
                    LogUtil.iRelease(TAG, ">=24  data.getData().toString():" + intent.getData().toString());
                    LogUtil.iRelease(TAG, ">=24   mImagePath:" + this.f19116p);
                } else {
                    this.f19116p = Utils.m16260a((Context) this, intent.getData());
                    LogUtil.iRelease(TAG, "<24  data.getData().toString():" + intent.getData().toString());
                    LogUtil.iRelease(TAG, "<24   mImagePath:" + this.f19116p);
                }
            }
            if (!TextUtils.isEmpty(this.f19116p)) {
                String str = this.f19116p;
                int i3 = this.f19115o;
                Bitmap decodeSampledBitmap = Utils.decodeSampledBitmap(str, i3, i3);
                PrintStream printStream = System.out;
                printStream.println("sample bitmap1===" + decodeSampledBitmap);
                if (decodeSampledBitmap == null) {
                    ContentResolver contentResolver = getContentResolver();
                    Uri data = intent.getData();
                    int i4 = this.f19115o;
                    decodeSampledBitmap = Utils.decodeImgByUriStream(contentResolver, data, i4, i4);
                }
                PrintStream printStream2 = System.out;
                printStream2.println("sample bitmap2===" + decodeSampledBitmap);
                if (decodeSampledBitmap == null) {
                    PhotoService.m16237a(1001, (String) null, (String) null, (String) null);
                    finish();
                    return;
                }
                Bitmap a = Utils.m16258a(decodeSampledBitmap, this.f19114n);
                if (a == null) {
                    PhotoService.m16237a(1003, (String) null, (String) null, (String) null);
                    finish();
                    return;
                }
                File a2 = Utils.m16259a((Context) this);
                if (a2 == null) {
                    PhotoService.m16237a(1003, (String) null, (String) null, (String) null);
                    finish();
                    return;
                }
                String absolutePath = a2.getAbsolutePath();
                Bitmap a3 = m16221a(a, getImageOrientation(this.f19116p));
                Utils.m16262a(a3, absolutePath);
                String a4 = Utils.m16261a(a3);
                if (TextUtils.isEmpty(a4)) {
                    PhotoService.m16237a(1003, (String) null, (String) null, (String) null);
                    finish();
                    return;
                }
                PhotoService.m16237a(1000, a4, absolutePath, (String) null);
            } else {
                PhotoService.m16237a(1001, (String) null, (String) null, (String) null);
            }
        } else {
            PhotoService.m16237a(1002, (String) null, (String) null, (String) null);
        }
        finish();
        overridePendingTransition(0, R.anim.dimina_photo_dialog_outer);
    }

    public int getImageOrientation(String str) {
        try {
            return new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: a */
    private Bitmap m16221a(Bitmap bitmap, int i) {
        if (bitmap == null || i == 1) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i == 6) {
            matrix.setRotate(90.0f);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        } else if (i != 8) {
            return bitmap;
        } else {
            matrix.setRotate(270.0f);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        }
    }

    /* renamed from: a */
    private void m16223a(ClipData clipData) {
        int min = Math.min(this.f19121u, clipData.getItemCount());
        String[] strArr = new String[min];
        for (int i = 0; i < min; i++) {
            String filePathFromURIForAPI24 = Utils.getFilePathFromURIForAPI24(this, clipData.getItemAt(i).getUri());
            LogUtil.eRelease(TAG, "第" + i + "个的path是: " + filePathFromURIForAPI24);
            if (!TextUtils.isEmpty(filePathFromURIForAPI24)) {
                int i2 = this.f19115o;
                Bitmap decodeSampledBitmap = Utils.decodeSampledBitmap(filePathFromURIForAPI24, i2, i2);
                if (decodeSampledBitmap == null) {
                    LogUtil.eRelease(TAG, "1111 ");
                } else {
                    Bitmap a = Utils.m16258a(decodeSampledBitmap, this.f19114n);
                    if (a == null) {
                        LogUtil.eRelease(TAG, "22222");
                    } else {
                        File a2 = Utils.m16259a((Context) this);
                        if (a2 == null) {
                            LogUtil.eRelease(TAG, "33333");
                        } else {
                            String absolutePath = a2.getAbsolutePath();
                            Utils.m16262a(a, absolutePath);
                            strArr[i] = absolutePath;
                        }
                    }
                }
            } else {
                strArr[i] = null;
            }
        }
        LogUtil.iRelease(TAG, "最终返回的结果是:" + strArr);
        PhotoService.m16238a(1000, strArr);
        finish();
        overridePendingTransition(0, R.anim.dimina_photo_dialog_outer);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m16228c() {
        if (this.f19121u < 2) {
            m16229d();
        } else {
            m16230e();
        }
    }

    /* renamed from: d */
    private void m16229d() {
        Intent intent = new Intent("android.intent.action.PICK", (Uri) null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, PicUploadActivity.IMAGE_UNSPECIFIED);
        startActivityForResult(intent, 4);
    }

    /* renamed from: e */
    private void m16230e() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType(AsyncHttpRequest.HEADER_ACCEPT_ALL);
        ArrayList arrayList = new ArrayList();
        arrayList.add(PicUploadActivity.IMAGE_UNSPECIFIED);
        intent.putExtra("android.intent.extra.MIME_TYPES", arrayList);
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        intent.putExtra("android.intent.extra.LOCAL_ONLY", false);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 6);
        }
    }

    /* renamed from: f */
    private void m16231f() {
        Uri uri;
        File photoOutputFile = Utils.getPhotoOutputFile(this);
        if (photoOutputFile != null) {
            this.f19116p = photoOutputFile.getAbsolutePath();
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            int i = this.f19113m;
            if (i == 0) {
                intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
            } else if (i == 1) {
                intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                uri = FileProvider.getUriForFile(this, Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(this) + ".dimina.file.provider", photoOutputFile);
            } else {
                uri = Uri.fromFile(photoOutputFile);
            }
            intent.putExtra("output", uri);
            startActivityForResult(intent, 3);
        }
    }

    /* renamed from: a */
    private void m16225a(TakePhotoActivity.PhotoType photoType) {
        File photoOutputFile;
        if (photoType != null && (photoOutputFile = Utils.getPhotoOutputFile(this)) != null) {
            this.f19116p = photoOutputFile.getAbsolutePath();
            Intent intent = new Intent(this, TakePhotoActivity.class);
            intent.putExtra(TakePhotoActivity.KEY_DMMINA_INDEX, this.f19112l.getMinaIndex());
            intent.putExtra(TakePhotoActivity.KEY_FILEPATH, photoOutputFile.getAbsolutePath());
            intent.putExtra(TakePhotoActivity.KEY_PHOTOTYPE, photoType.ordinal());
            startActivityForResult(intent, 5);
        }
    }
}
