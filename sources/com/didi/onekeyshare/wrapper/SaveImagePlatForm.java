package com.didi.onekeyshare.wrapper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.didi.global.ninja.Ninja;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.onekeyshare.util.DownloadImageUtil;
import com.didi.onekeyshare.view.ProgressDialogUtil;
import com.didi.permission.DPermission;
import com.didi.permission.OnPermissionCallback;
import com.didi.permission.OnTipDialogCallback;
import com.didi.share.ErrorCode;
import com.didi.sharesdk.AppKeyManager;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.io.File;
import java.io.FileOutputStream;

@ServiceProvider({IPlatform.class})
public class SaveImagePlatForm implements IPlatform {

    /* renamed from: a */
    private Context f32302a;

    /* renamed from: b */
    private SharePlatform f32303b;

    /* renamed from: c */
    private ICallback.IPlatformShareCallback f32304c;

    /* renamed from: d */
    private ICallback.IPlatformShareCallback2 f32305d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ProgressDialogUtil f32306e;

    public void share(final Context context, final OneKeyShareInfo oneKeyShareInfo, final ICallback.IPlatformShareCallback iPlatformShareCallback) {
        if (!Ninja.getInstance(context).isHit("SAVEIMAGE_SHARE")) {
            this.f32302a = context;
            this.f32303b = oneKeyShareInfo.platform;
            this.f32304c = iPlatformShareCallback;
            if (iPlatformShareCallback instanceof ICallback.IPlatformShareCallback2) {
                this.f32305d = (ICallback.IPlatformShareCallback2) iPlatformShareCallback;
            }
            if (this.f32306e == null) {
                this.f32306e = new ProgressDialogUtil();
            }
            if (!TextUtils.isEmpty(oneKeyShareInfo.imageUrl)) {
                if (context instanceof Activity) {
                    DPermission.permissionRequest((Activity) context, 1, (OnPermissionCallback) new OnPermissionCallback() {
                        public void onPermissionGranted(int i) {
                            SaveImagePlatForm.this.f32306e.showDialogLoading(context);
                            DownloadImageUtil.downloadImage(context, oneKeyShareInfo.imageUrl, new DownloadImageUtil.DownLoadImageCallback() {
                                public void onSuccess(String str, String str2) {
                                    SaveImagePlatForm.this.m24539a(context, str2, iPlatformShareCallback, false);
                                    SaveImagePlatForm.this.f32306e.dismissDialog();
                                }

                                public void onFail() {
                                    SaveImagePlatForm.this.m24538a(ErrorCode.DOWNLOAD_FAIL);
                                    SaveImagePlatForm.this.f32306e.dismissDialog();
                                }
                            });
                        }

                        public void onPermissionDenied(String str, int i, boolean z) {
                            SaveImagePlatForm.this.m24537a();
                        }
                    });
                }
            } else if (TextUtils.isEmpty(oneKeyShareInfo.imagePath)) {
                m24538a(ErrorCode.ERROR_PARAMS);
            } else if (context instanceof Activity) {
                DPermission.permissionRequest((Activity) context, 1, (OnPermissionCallback) new OnPermissionCallback() {
                    public void onPermissionGranted(int i) {
                        SaveImagePlatForm.this.f32306e.showDialogLoading(context);
                        SaveImagePlatForm.this.m24539a(context, oneKeyShareInfo.imagePath, iPlatformShareCallback, false);
                        SaveImagePlatForm.this.f32306e.dismissDialog();
                    }

                    public void onPermissionDenied(String str, int i, boolean z) {
                        SaveImagePlatForm.this.m24537a();
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24537a() {
        Context context = this.f32302a;
        DPermission.showTipDialog(context, AppKeyManager.getAppName(this.f32302a) + "想访问您的照片", "保存图片需要访问您的相册", "取消", "设置权限", new OnTipDialogCallback() {
            public void onSure() {
            }

            public void onCancel() {
                SaveImagePlatForm.this.m24538a(ErrorCode.ERR_AUTH_DENIED);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24538a(int i) {
        this.f32304c.onError(this.f32303b);
        ICallback.IPlatformShareCallback2 iPlatformShareCallback2 = this.f32305d;
        if (iPlatformShareCallback2 != null) {
            iPlatformShareCallback2.onError(this.f32303b, i);
        }
    }

    public boolean matchPlatform(String str) {
        return SharePlatform.SAVEIMAGE_PLATFORM.platformName().equals(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24539a(Context context, String str, ICallback.IPlatformShareCallback iPlatformShareCallback, boolean z) {
        String str2;
        if (z) {
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(str);
                File cacheDir = DownloadImageUtil.getCacheDir(context);
                File file = new File(cacheDir, System.currentTimeMillis() + ".jpg");
                str2 = file.getAbsolutePath();
                decodeFile.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(file));
            } catch (Exception e) {
                e.printStackTrace();
                if (z) {
                    m24538a(ErrorCode.ERR_COMM);
                    return;
                } else {
                    m24539a(context, str, iPlatformShareCallback, true);
                    return;
                }
            }
        } else {
            str2 = str;
        }
        MediaStore.Images.Media.insertImage(context.getContentResolver(), str2, str2, (String) null);
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str2))));
        if (iPlatformShareCallback != null) {
            iPlatformShareCallback.onComplete(this.f32303b);
        }
    }
}
