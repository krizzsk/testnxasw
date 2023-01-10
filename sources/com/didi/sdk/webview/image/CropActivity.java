package com.didi.sdk.webview.image;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CropActivity extends Activity {
    public static final String CROP_PIC_PASS_KEY = "CROP_PIC_PASS_KEY";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public CropImageView f41136a;

    /* renamed from: b */
    private CropView f41137b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f41138c = 500;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f41139d = 340;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f41140e = null;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Bitmap.CompressFormat f41141f = Bitmap.CompressFormat.JPEG;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f41142g = false;

    /* renamed from: h */
    private CommonTitleBar f41143h;

    /* renamed from: i */
    private View.OnClickListener f41144i = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (CropActivity.this.f41142g) {
                new CropHeadWorker().execute(new Void[0]);
            }
        }
    };

    /* renamed from: j */
    private View.OnClickListener f41145j = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            CropActivity.this.finish();
        }
    };

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView(R.layout.a_crop);
        m30867a();
        this.f41136a = (CropImageView) findViewById(R.id.src_pic);
        this.f41137b = (CropView) findViewById(R.id.crop_view);
        m30870b();
    }

    /* renamed from: a */
    private void m30867a() {
        CommonTitleBar commonTitleBar = (CommonTitleBar) findViewById(R.id.title_bar);
        this.f41143h = commonTitleBar;
        commonTitleBar.setLeftImage((int) R.drawable.common_title_bar_btn_back_selector, this.f41145j);
        this.f41143h.setTitle("");
        this.f41143h.setRightText(getString(R.string.crop_image_to_use), this.f41144i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00e9 A[Catch:{ Exception -> 0x0109 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00f3 A[Catch:{ Exception -> 0x0109 }] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m30870b() {
        /*
            r7 = this;
            android.content.Intent r0 = r7.getIntent()
            r1 = 2131953832(0x7f1308a8, float:1.9544146E38)
            if (r0 != 0) goto L_0x0014
            java.lang.String r0 = r7.getString(r1)
            com.didi.sdk.util.ToastHelper.showLongInfo((android.content.Context) r7, (java.lang.String) r0)
            r7.finish()
            return
        L_0x0014:
            android.net.Uri r2 = r0.getData()
            if (r2 != 0) goto L_0x0025
            java.lang.String r0 = r7.getString(r1)
            com.didi.sdk.util.ToastHelper.showLongInfo((android.content.Context) r7, (java.lang.String) r0)
            r7.finish()
            return
        L_0x0025:
            java.lang.String r1 = "output"
            java.lang.String r1 = r0.getStringExtra(r1)
            r7.f41140e = r1
            r1 = 500(0x1f4, float:7.0E-43)
            java.lang.String r3 = "width"
            int r1 = r0.getIntExtra(r3, r1)
            r7.f41138c = r1
            r1 = 340(0x154, float:4.76E-43)
            java.lang.String r3 = "height"
            int r0 = r0.getIntExtra(r3, r1)
            r7.f41139d = r0
            int r1 = r7.f41138c
            int r0 = getMaxGY(r1, r0)
            com.didi.sdk.webview.image.CropView r1 = r7.f41137b
            int r3 = r7.f41138c
            int r3 = r3 / r0
            r1.setWidthScale(r3)
            com.didi.sdk.webview.image.CropImageView r1 = r7.f41136a
            int r3 = r7.f41138c
            int r3 = r3 / r0
            r1.setWidthScale(r3)
            com.didi.sdk.webview.image.CropView r1 = r7.f41137b
            int r3 = r7.f41139d
            int r3 = r3 / r0
            r1.setHeightScale(r3)
            com.didi.sdk.webview.image.CropImageView r1 = r7.f41136a
            int r3 = r7.f41139d
            int r3 = r3 / r0
            r1.setHeightScale(r3)
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x0109 }
            r0.<init>()     // Catch:{ Exception -> 0x0109 }
            r1 = 1
            r0.inJustDecodeBounds = r1     // Catch:{ Exception -> 0x0109 }
            android.content.ContentResolver r3 = r7.getContentResolver()     // Catch:{ Exception -> 0x0109 }
            java.io.InputStream r3 = r3.openInputStream(r2)     // Catch:{ Exception -> 0x0109 }
            r4 = 0
            android.graphics.BitmapFactory.decodeStream(r3, r4, r0)     // Catch:{ Exception -> 0x0109 }
            int r3 = r0.outHeight     // Catch:{ Exception -> 0x0109 }
            int r5 = r7.f41139d     // Catch:{ Exception -> 0x0109 }
            if (r3 < r5) goto L_0x00fb
            int r3 = r0.outWidth     // Catch:{ Exception -> 0x0109 }
            int r5 = r7.f41138c     // Catch:{ Exception -> 0x0109 }
            if (r3 >= r5) goto L_0x008a
            goto L_0x00fb
        L_0x008a:
            r3 = 1073741824(0x40000000, float:2.0)
            int r5 = r0.outHeight     // Catch:{ Exception -> 0x0109 }
            float r5 = (float) r5     // Catch:{ Exception -> 0x0109 }
            int r6 = r7.m30871c()     // Catch:{ Exception -> 0x0109 }
            float r6 = (float) r6     // Catch:{ Exception -> 0x0109 }
            float r6 = r6 * r3
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 > 0) goto L_0x00b6
            int r5 = r0.outWidth     // Catch:{ Exception -> 0x0109 }
            float r5 = (float) r5     // Catch:{ Exception -> 0x0109 }
            int r6 = r7.m30873d()     // Catch:{ Exception -> 0x0109 }
            float r6 = (float) r6     // Catch:{ Exception -> 0x0109 }
            float r6 = r6 * r3
            int r3 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r3 <= 0) goto L_0x00a9
            goto L_0x00b6
        L_0x00a9:
            android.content.ContentResolver r0 = r7.getContentResolver()     // Catch:{ Exception -> 0x0109 }
            java.io.InputStream r0 = r0.openInputStream(r2)     // Catch:{ Exception -> 0x0109 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r0)     // Catch:{ Exception -> 0x0109 }
            goto L_0x00e3
        L_0x00b6:
            int r3 = r0.outHeight     // Catch:{ Exception -> 0x0109 }
            int r5 = r7.m30871c()     // Catch:{ Exception -> 0x0109 }
            int r3 = r3 / r5
            float r3 = (float) r3     // Catch:{ Exception -> 0x0109 }
            int r3 = java.lang.Math.round(r3)     // Catch:{ Exception -> 0x0109 }
            int r5 = r0.outWidth     // Catch:{ Exception -> 0x0109 }
            int r6 = r7.m30873d()     // Catch:{ Exception -> 0x0109 }
            int r5 = r5 / r6
            float r5 = (float) r5     // Catch:{ Exception -> 0x0109 }
            int r5 = java.lang.Math.round(r5)     // Catch:{ Exception -> 0x0109 }
            int r3 = java.lang.Math.max(r3, r5)     // Catch:{ Exception -> 0x0109 }
            r0.inSampleSize = r3     // Catch:{ Exception -> 0x0109 }
            r3 = 0
            r0.inJustDecodeBounds = r3     // Catch:{ Exception -> 0x0109 }
            android.content.ContentResolver r3 = r7.getContentResolver()     // Catch:{ Exception -> 0x0109 }
            java.io.InputStream r3 = r3.openInputStream(r2)     // Catch:{ Exception -> 0x0109 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r3, r4, r0)     // Catch:{ Exception -> 0x0109 }
        L_0x00e3:
            int r2 = com.didi.sdk.webview.image.ExifUtils.getExifOrientation(r7, r2)     // Catch:{ Exception -> 0x0109 }
            if (r2 == 0) goto L_0x00f3
            android.graphics.Bitmap r0 = r7.m30866a(r0, r2, r1)     // Catch:{ Exception -> 0x0109 }
            com.didi.sdk.webview.image.CropImageView r2 = r7.f41136a     // Catch:{ Exception -> 0x0109 }
            r2.setImageBitmap(r0)     // Catch:{ Exception -> 0x0109 }
            goto L_0x00f8
        L_0x00f3:
            com.didi.sdk.webview.image.CropImageView r2 = r7.f41136a     // Catch:{ Exception -> 0x0109 }
            r2.setImageBitmap(r0)     // Catch:{ Exception -> 0x0109 }
        L_0x00f8:
            r7.f41142g = r1     // Catch:{ Exception -> 0x0109 }
            return
        L_0x00fb:
            r0 = 2131953835(0x7f1308ab, float:1.9544152E38)
            java.lang.String r0 = r7.getString(r0)     // Catch:{ Exception -> 0x0109 }
            com.didi.sdk.util.ToastHelper.showLongInfo((android.content.Context) r7, (java.lang.String) r0)     // Catch:{ Exception -> 0x0109 }
            r7.finish()     // Catch:{ Exception -> 0x0109 }
            return
        L_0x0109:
            r0 = move-exception
            r0.printStackTrace()
            r0 = 2131953833(0x7f1308a9, float:1.9544148E38)
            java.lang.String r0 = r7.getString(r0)
            com.didi.sdk.util.ToastHelper.showLongInfo((android.content.Context) r7, (java.lang.String) r0)
            r7.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.webview.image.CropActivity.m30870b():void");
    }

    class CropHeadWorker extends AsyncTask<Void, Void, Void> {
        private Bitmap mBitmap;

        /* access modifiers changed from: protected */
        public void onPreExecute() {
        }

        CropHeadWorker() {
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... voidArr) {
            File file = new File(CropActivity.this.f41140e);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Uri fromFile = Uri.fromFile(file);
            Bitmap cropUpPercentTen = CropActivity.this.f41136a.cropUpPercentTen((float) CropActivity.this.f41138c, (float) CropActivity.this.f41139d);
            this.mBitmap = cropUpPercentTen;
            if (cropUpPercentTen == null) {
                return null;
            }
            try {
                cropUpPercentTen.compress(CropActivity.this.f41141f, 75, CropActivity.this.getContentResolver().openOutputStream(fromFile));
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (RuntimeException e3) {
                e3.printStackTrace();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void voidR) {
            Intent intent = new Intent();
            intent.putExtra("CROP_PIC_PASS_KEY", CropActivity.this.f41140e);
            CropActivity.this.setResult(-1, intent);
            Bitmap bitmap = this.mBitmap;
            if (bitmap != null) {
                bitmap.recycle();
            }
            CropActivity.this.finish();
        }
    }

    public static int getMaxGY(int i, int i2) {
        if (i == i2) {
            return i2;
        }
        while (true) {
            int i3 = i % i2;
            if (i3 == 0) {
                return i2;
            }
            int i4 = i2;
            i2 = i3;
            i = i4;
        }
    }

    /* renamed from: c */
    private int m30871c() {
        return getResources().getDisplayMetrics().heightPixels;
    }

    /* renamed from: d */
    private int m30873d() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    /* renamed from: a */
    private Bitmap m30866a(Bitmap bitmap, int i, boolean z) {
        if (i == 0) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        if (z) {
            bitmap.recycle();
        }
        return createBitmap;
    }
}
