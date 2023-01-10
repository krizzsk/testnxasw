package com.didichuxing.diface.appeal.brazil;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.dfbasesdk.camera.DiFaceCameraManager;
import com.didichuxing.dfbasesdk.utils.BitmapUtils;
import com.didichuxing.dfbasesdk.utils.BusUtils;
import com.didichuxing.dfbasesdk.utils.CameraUtils;
import com.didichuxing.dfbasesdk.utils.CheckUtils;
import com.didichuxing.dfbasesdk.utils.IOUtils;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.diface.act.DFBaseAct;
import com.didichuxing.diface.appeal.OrientationListenerImpl;
import com.didichuxing.diface.appeal.TakePhotoDoneEvent;
import com.didichuxing.diface.appeal.TakePhotoInfo;
import com.didichuxing.diface.appeal.toolkit.ResizeTakePhoto;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.utils.DisplayUtils;
import com.taxis99.R;
import java.io.File;
import java.io.FileOutputStream;

public class BRTakePhotoAct extends DFBaseAct {

    /* renamed from: a */
    private TextureView f49677a;

    /* renamed from: b */
    private TextView f49678b;

    /* renamed from: c */
    private ImageView f49679c;

    /* renamed from: d */
    private RelativeLayout f49680d;

    /* renamed from: e */
    private RelativeLayout f49681e;

    /* renamed from: f */
    private ImageView f49682f;

    /* renamed from: g */
    private ImageView f49683g;

    /* renamed from: h */
    private TextView f49684h;

    /* renamed from: i */
    private TextView f49685i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public DiFaceCameraManager f49686j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public SurfaceTexture f49687k;

    /* renamed from: l */
    private int f49688l;

    /* renamed from: m */
    private String[] f49689m;

    /* renamed from: n */
    private int[] f49690n;

    /* renamed from: o */
    private OrientationListenerImpl f49691o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public byte[] f49692p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public ResizeTakePhoto f49693q;

    /* renamed from: r */
    private int f49694r;

    /* renamed from: s */
    private String f49695s;

    /* access modifiers changed from: protected */
    public boolean fullScreen() {
        return true;
    }

    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getContentLayout() {
        return R.layout.br_act_df_take_photo_layout2;
    }

    /* access modifiers changed from: protected */
    public void makeFaceResult(DiFaceResult diFaceResult) {
    }

    public static void start(Activity activity, int i) {
        Intent intent = new Intent(activity, BRTakePhotoAct.class);
        intent.putExtra(TakePhotoInfo.EXTRA_KEY_PHOTO_TYPE, i);
        activity.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
        this.f49688l = intent.getIntExtra(TakePhotoInfo.EXTRA_KEY_PHOTO_TYPE, 0);
        this.f49689m = getResources().getStringArray(R.array.df_take_photo_act_confirm_notes);
        this.f49690n = new int[]{R.drawable.br_df_appeal_driver_license_g1_preview, R.drawable.df_appeal_driver_license_g2_qr_preview, R.drawable.df_appeal_rg_front_preview, R.drawable.df_appeal_cdr_preview, R.drawable.br_df_appeal_cdt_preview, R.drawable.br_df_appeal_passport_preview, R.drawable.br_df_appeal_self_photo_preview};
        int screenWidth = DisplayUtils.getScreenWidth(this);
        int screenHeight = DisplayUtils.getScreenHeight(this);
        LogUtils.m37051d("screenW===" + screenWidth + ", screenH=" + screenHeight);
        int i = (int) (((float) screenHeight) * 0.75f);
        LogUtils.m37051d("wanted prevW===" + screenWidth + ", prevH=" + i);
        this.f49686j = new DiFaceCameraManager(DisplayUtils.getWindowRotation(getWindow()), DisplayUtils.isPortrait(this), screenWidth, screenHeight, screenWidth, i);
        this.f49691o = new OrientationListenerImpl(this, this.f49686j);
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        boolean isValidType = TakePhotoInfo.isValidType(this.f49688l);
        CheckUtils.checkAssert(isValidType, "invalid photoType, mPhotoType=" + this.f49688l);
        if (!isValidType) {
            finish();
            return;
        }
        this.f49693q = new ResizeTakePhoto(this, findViewById(R.id.fl_take_photo_container), findViewById(R.id.fl_bottom_container), findViewById(R.id.take_photo_preview_img));
        hideTitleArea();
        TextureView textureView = (TextureView) findViewById(R.id.live_camera_preview);
        this.f49677a = textureView;
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return true;
            }

            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (!(BRTakePhotoAct.this.f49686j.getCamera() == null || BRTakePhotoAct.this.f49686j.getCamera().getParameters() == null || BRTakePhotoAct.this.f49686j.getCamera().getParameters().getPreviewSize() == null)) {
                    Camera.Size previewSize = BRTakePhotoAct.this.f49686j.getCamera().getParameters().getPreviewSize();
                    BRTakePhotoAct.this.f49693q.resize(previewSize.width, previewSize.height);
                }
                SurfaceTexture unused = BRTakePhotoAct.this.f49687k = surfaceTexture;
                BRTakePhotoAct.this.f49686j.startPreview(surfaceTexture);
            }
        });
        this.f49677a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BRTakePhotoAct.this.f49686j.autoFocus();
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.take_photo_preview_img);
        this.f49679c = imageView;
        imageView.setImageResource(this.f49690n[this.f49688l - 1]);
        this.f49678b = (TextView) findViewById(R.id.take_photo_note);
        if (TakePhotoInfo.isSpecialRGType(this.f49688l)) {
            this.f49678b.setText(R.string.df_take_photo_act_preview_note_rg);
        } else if (this.f49688l == 7) {
            this.f49678b.setText(R.string.df_take_photo_act_preview_note_self_photo);
        }
        this.f49680d = (RelativeLayout) findViewById(R.id.take_photo_preview_container);
        ImageView imageView2 = (ImageView) findViewById(R.id.back_icon);
        this.f49682f = imageView2;
        imageView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BRTakePhotoAct.this.finish();
            }
        });
        ImageView imageView3 = (ImageView) findViewById(R.id.take_photo_icon);
        this.f49683g = imageView3;
        imageView3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BRTakePhotoAct.this.f49686j.takePhoto(new Camera.PictureCallback() {
                    public void onPictureTaken(byte[] bArr, Camera camera) {
                        LogUtils.m37051d("original jpeg data.length===" + (bArr.length / 1024) + "KB");
                        byte[] unused = BRTakePhotoAct.this.f49692p = bArr;
                        camera.stopPreview();
                        BRTakePhotoAct.this.m37189a(true);
                    }
                });
            }
        });
        this.f49681e = (RelativeLayout) findViewById(R.id.take_photo_confirm_container);
        TextView textView = (TextView) findViewById(R.id.photo_retake_icon);
        this.f49684h = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                byte[] unused = BRTakePhotoAct.this.f49692p = null;
                BRTakePhotoAct.this.f49686j.startPreview(BRTakePhotoAct.this.f49687k);
                BRTakePhotoAct.this.m37189a(false);
            }
        });
        TextView textView2 = (TextView) findViewById(R.id.photo_confirm_icon);
        this.f49685i = textView2;
        textView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BRTakePhotoAct.this.m37186a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37186a() {
        String fileName = TakePhotoInfo.getFileName(this.f49688l, this.f49694r);
        m37188a(fileName);
        BusUtils.post(new TakePhotoDoneEvent(fileName));
        if (this.f49694r != 0 || !TakePhotoInfo.isSpecialRGType(this.f49688l)) {
            finish();
            return;
        }
        m37192b();
        this.f49694r++;
    }

    /* renamed from: b */
    private void m37192b() {
        this.f49692p = null;
        this.f49686j.startPreview(this.f49687k);
        m37189a(false);
        this.f49679c.setImageResource(R.drawable.df_appeal_rg_back_preview);
        this.f49678b.setText(R.string.df_take_photo_act_preview_note_rg_back);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37189a(boolean z) {
        if (z) {
            this.f49681e.setVisibility(0);
            this.f49680d.setVisibility(4);
            this.f49679c.setVisibility(4);
            this.f49695s = this.f49678b.getText().toString();
            this.f49678b.setText(this.f49689m[this.f49688l - 1]);
            this.f49691o.disable();
            return;
        }
        this.f49681e.setVisibility(4);
        this.f49680d.setVisibility(0);
        this.f49679c.setVisibility(0);
        this.f49678b.setText(this.f49695s);
        this.f49691o.enable();
    }

    /* renamed from: a */
    private void m37188a(String str) {
        FileOutputStream fileOutputStream;
        Exception e;
        File file = new File(getCacheDir(), str);
        LogUtils.m37051d("save jpeg file====" + file);
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(this.f49692p, 0, this.f49692p.length);
                int width = decodeByteArray.getWidth();
                int height = decodeByteArray.getHeight();
                LogUtils.m37051d("origin bitmap w=" + width + ", h=" + height);
                if (width * height > 307200) {
                    int i = 640;
                    int i2 = 480;
                    if (width < height) {
                        i = 480;
                        i2 = 640;
                    }
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, i, i2, false);
                    LogUtils.m37051d("create scaled bitmap...");
                    if (!(createScaledBitmap == null || createScaledBitmap == decodeByteArray)) {
                        decodeByteArray.recycle();
                        decodeByteArray = createScaledBitmap;
                    }
                }
                Bitmap rotateBitmap = BitmapUtils.rotateBitmap(decodeByteArray, this.f49691o.getRotation());
                LogUtils.m37051d("rotated bitmap w=" + rotateBitmap.getWidth() + ", h=" + rotateBitmap.getHeight());
                rotateBitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                LogUtils.m37051d("after 90% compress, file length====" + (file.length() / 1024) + "KB");
                rotateBitmap.recycle();
            } catch (Exception e2) {
                e = e2;
                try {
                    LogUtils.logStackTrace(e);
                    IOUtils.closeQuietly(fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuietly(fileOutputStream);
                    throw th;
                }
            }
        } catch (Exception e3) {
            fileOutputStream = null;
            e = e3;
            LogUtils.logStackTrace(e);
            IOUtils.closeQuietly(fileOutputStream);
        } catch (Throwable th2) {
            fileOutputStream = null;
            th = th2;
            IOUtils.closeQuietly(fileOutputStream);
            throw th;
        }
        IOUtils.closeQuietly(fileOutputStream);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f49691o.enable();
        this.f49686j.openCamera(m37193c(), true);
        SurfaceTexture surfaceTexture = this.f49687k;
        if (surfaceTexture != null) {
            this.f49686j.startPreview(surfaceTexture);
        }
    }

    /* renamed from: c */
    private int m37193c() {
        if (Camera.getNumberOfCameras() != 1 && this.f49688l == 7 && !DiFaceFacade.getInstance().getConfig().getForceUseBackCamera() && CameraUtils.hasFacingFrontCamera()) {
            return 1;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f49691o.disable();
        this.f49686j.closeCamera();
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        StringBuilder sb = new StringBuilder();
        sb.append("onRestart need save photo = ");
        sb.append(this.f49692p != null);
        LogUtils.m37051d(sb.toString());
        if (this.f49692p != null) {
            m37186a();
        }
    }
}
