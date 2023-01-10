package com.didi.payment.pix.qrcode;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globaluikit.utils.UIThreadHandler;
import com.didi.hawaii.mapsdk.gesture.NNGestureClassfy;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.commonsdk.p130ui.WBaseActivity;
import com.didi.payment.commonsdk.p130ui.WBaseViewModel;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.pix.qrcode.PixPhotoInputActivity;
import com.didi.payment.pix.qrcode.p139vm.PixQueryQrCodeVM;
import com.didi.payment.pix.widget.NonExceptionImageView;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.FileUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.webview.image.PicUploadActivity;
import com.didi.unifiedPay.util.UIUtils;
import com.didi.util.ImageDecoder;
import com.didichuxing.apollo.sdk.log.LogUtils;
import com.taxis99.R;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PixPhotoInputActivity extends WBaseActivity<PixQueryQrCodeVM> {

    /* renamed from: a */
    private static final int f33676a = 10;

    /* renamed from: b */
    private static final int f33677b = 11;

    /* renamed from: c */
    private static final String f33678c = ".fileprovider";

    /* renamed from: d */
    private static final int f33679d = 4;

    /* renamed from: e */
    private static final int f33680e = 1;

    /* renamed from: f */
    private NonExceptionImageView f33681f;

    /* renamed from: g */
    private View f33682g;

    /* renamed from: h */
    private View f33683h;

    /* renamed from: i */
    private TextView f33684i;

    /* renamed from: j */
    private TextView f33685j;

    /* renamed from: k */
    private Uri f33686k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Bitmap f33687l;

    /* renamed from: m */
    private File f33688m;

    /* renamed from: n */
    private File f33689n;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.pix_photo_input_layout);
        m25561a();
        m25566b();
        this.f32639vm = (WBaseViewModel) new ViewModelProvider((ViewModelStoreOwner) this, (ViewModelProvider.Factory) new PixQueryQrCodeVM.Factory(getApplication())).get(PixQueryQrCodeVM.class);
        subscribeUi((PixQueryQrCodeVM) this.f32639vm);
        FinOmegaSDK.trackEvent("ibt_didipay_pix_photo_input_upload_sw");
    }

    /* renamed from: a */
    private void m25561a() {
        this.f33681f = (NonExceptionImageView) findViewById(R.id.cs_photo_input);
        this.f33682g = findViewById(R.id.pix_photo_input_title);
        this.f33683h = findViewById(R.id.error_layout);
        this.f33684i = (TextView) findViewById(R.id.error_msg);
        this.f33685j = (TextView) findViewById(R.id.error_tip);
        this.f33683h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                PixPhotoInputActivity.this.finish();
            }
        });
        try {
            ((TextView) findViewById(R.id.photo_scan_button)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    FinOmegaSDK.trackEvent("ibt_didipay_pix_photo_input_upload_ck");
                    PixPhotoInputActivity pixPhotoInputActivity = PixPhotoInputActivity.this;
                    WalletToastNew.showMsg(pixPhotoInputActivity, pixPhotoInputActivity.getString(R.string.GRider_payment_Image_recognition_FjUJ));
                    PixPhotoInputActivity pixPhotoInputActivity2 = PixPhotoInputActivity.this;
                    pixPhotoInputActivity2.scanPhoto(pixPhotoInputActivity2.f33687l);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
        ((ImageView) findViewById(R.id.title_back)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                PixPhotoInputActivity.this.finish();
            }
        });
    }

    public void subscribeUi(PixQueryQrCodeVM pixQueryQrCodeVM) {
        super.subscribeUi(pixQueryQrCodeVM);
        pixQueryQrCodeVM.mErrorMessage.observe(this, new Observer<String>() {
            public void onChanged(final String str) {
                UIThreadHandler.post(new Runnable() {
                    public void run() {
                        if (!TextUtil.isEmpty(str)) {
                            PixPhotoInputActivity.this.showQrCodeErrorView(str);
                        } else {
                            PixPhotoInputActivity.this.showQrCodeErrorView(PixPhotoInputActivity.this.getString(R.string.GRider_payment_Invalid_QR_yyIJ));
                        }
                    }
                }, 500);
            }
        });
        pixQueryQrCodeVM.mQuerySuccess.observe(this, new Observer<Boolean>() {
            public void onChanged(Boolean bool) {
                if (bool.booleanValue()) {
                    PixPhotoInputActivity.this.finish();
                } else {
                    FinOmegaSDK.trackEvent("ibt_didipay_pix_photo_input_api_fail_bt");
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return this.f33682g;
    }

    public void scanPhoto(final Bitmap bitmap) {
        if (bitmap == null) {
            FinOmegaSDK.trackEvent("ibt_didipay_pix_photo_input_upload_fail_sw");
            showQrCodeErrorView(getString(R.string.GRider_payment_Didn_t_HzNP));
            return;
        }
        new Thread() {
            public void run() {
                try {
                    String syncDecodeQRCode = ImageDecoder.syncDecodeQRCode((Context) PixPhotoInputActivity.this, Bitmap.createBitmap(bitmap));
                    if (TextUtils.isEmpty(syncDecodeQRCode)) {
                        FinOmegaSDK.trackEvent("ibt_didipay_pix_photo_input_upload_fail_sw");
                        UiThreadHandler.post(new Runnable() {
                            public final void run() {
                                PixPhotoInputActivity.C116596.this.lambda$run$0$PixPhotoInputActivity$6();
                            }
                        });
                        return;
                    }
                    ((PixQueryQrCodeVM) PixPhotoInputActivity.this.f32639vm).queryQrCode(syncDecodeQRCode, "phone_input_scan");
                } catch (Throwable th) {
                    th.printStackTrace();
                    UiThreadHandler.post(new Runnable() {
                        public final void run() {
                            PixPhotoInputActivity.C116596.this.lambda$run$1$PixPhotoInputActivity$6();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$run$0$PixPhotoInputActivity$6() {
                PixPhotoInputActivity pixPhotoInputActivity = PixPhotoInputActivity.this;
                pixPhotoInputActivity.showQrCodeErrorView(pixPhotoInputActivity.getString(R.string.GRider_payment_Didn_t_HzNP));
            }

            public /* synthetic */ void lambda$run$1$PixPhotoInputActivity$6() {
                PixPhotoInputActivity pixPhotoInputActivity = PixPhotoInputActivity.this;
                pixPhotoInputActivity.showQrCodeErrorView(pixPhotoInputActivity.getString(R.string.GRider_payment_Didn_t_HzNP));
            }
        }.start();
    }

    public void showQrCodeErrorView(String str) {
        this.f33684i.setText(str);
        this.f33683h.setVisibility(0);
    }

    /* renamed from: a */
    private void m25562a(Uri uri) {
        try {
            Bitmap b = m25564b(uri);
            this.f33687l = b;
            if (b == null) {
                WalletToastNew.showFailedMsg(getApplication(), getString(R.string.GRider_payment_Didn_t_HzNP));
                finish();
                return;
            }
            this.f33681f.setImageBitmap(b);
        } catch (Throwable unused) {
            WalletToastNew.showFailedMsg(getApplication(), getString(R.string.GRider_payment_Didn_t_HzNP));
            finish();
        }
    }

    /* renamed from: b */
    private void m25566b() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.PICK");
        intent.setType(PicUploadActivity.IMAGE_UNSPECIFIED);
        try {
            startActivityForResult(intent, 10);
        } catch (ActivityNotFoundException e) {
            LogUtils.m36180e(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.f33688m != null && this.f33688m.exists()) {
                this.f33688m.delete();
            }
            if (this.f33689n != null && this.f33689n.exists()) {
                this.f33689n.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private Bitmap m25564b(Uri uri) {
        int i;
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
            if (!WalletApolloUtil.isBoletoPhotoCrop()) {
                return bitmap;
            }
            int height = bitmap.getHeight();
            int width = bitmap.getWidth();
            if (height <= width) {
                i = UIUtils.getScreenHeight(this) / height;
            } else {
                i = UIUtils.getScreenWidth(this) / width;
            }
            if (i < 1) {
                i = 1;
            } else if (i > 4) {
                i = 4;
            }
            Matrix matrix = new Matrix();
            float f = (float) i;
            matrix.postScale(f, f);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private void m25563a(String str) {
        File c = m25567c();
        this.f33688m = c;
        FileUtil.copyFile(str, c.getAbsolutePath());
        Uri fromFile = Uri.fromFile(this.f33688m);
        Intent intent = new Intent("com.android.camera.action.CROP");
        String str2 = getPackageName() + f33678c;
        if (Build.VERSION.SDK_INT >= 24) {
            Uri uriForFile = FileProvider.getUriForFile(this, str2, new File(fromFile.getPath()));
            intent.addFlags(1);
            intent.setDataAndType(uriForFile, PicUploadActivity.IMAGE_UNSPECIFIED);
        } else if (Build.VERSION.SDK_INT >= 19) {
            intent.setDataAndType(Uri.fromFile(new File(FileUtil.getPath(this, fromFile))), PicUploadActivity.IMAGE_UNSPECIFIED);
        } else {
            intent.setDataAndType(fromFile, PicUploadActivity.IMAGE_UNSPECIFIED);
        }
        File d = m25568d();
        this.f33689n = d;
        this.f33686k = Uri.fromFile(d);
        intent.putExtra("crop", "true");
        intent.putExtra(NNGestureClassfy.SCALE_LABLE, true);
        intent.putExtra("return-data", false);
        intent.putExtra("output", this.f33686k);
        intent.putExtra("noFaceDetection", true);
        startActivityForResult(intent, 11);
    }

    /* renamed from: c */
    private File m25567c() {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        return new File(externalStoragePublicDirectory, "IMG_" + format + "_output.jpg");
    }

    /* renamed from: d */
    private File m25568d() {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        return new File(externalStoragePublicDirectory, "IMG_" + format + "_crop.jpg");
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (-1 == i2) {
            if (i == 10) {
                Uri data = intent.getData();
                if (WalletApolloUtil.isBoletoPhotoCrop()) {
                    try {
                        m25563a(FileUtil.getPath(this, data));
                    } catch (Exception e) {
                        e.printStackTrace();
                        m25562a(data);
                    }
                } else {
                    m25562a(data);
                }
            } else if (i == 11) {
                m25562a(this.f33686k);
            }
        } else if (i2 == 0) {
            finish();
        }
    }
}
