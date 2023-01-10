package com.didichuxing.diface.appeal;

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
import com.didichuxing.dfbasesdk.utils.IOUtils;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.diface.act.DFStyleBaseAct;
import com.didichuxing.diface.appeal.mexico.model.DocumentCardsBean;
import com.didichuxing.diface.appeal.toolkit.ResizeTakePhoto;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.utils.DisplayUtils;
import com.didichuxing.saimageloader.DiSafetyImageLoader;
import com.taxis99.R;
import java.io.File;
import java.io.FileOutputStream;

public class TakePhotoAct extends DFStyleBaseAct {

    /* renamed from: a */
    private TextureView f49640a;

    /* renamed from: b */
    private TextView f49641b;

    /* renamed from: c */
    private ImageView f49642c;

    /* renamed from: d */
    private RelativeLayout f49643d;

    /* renamed from: e */
    private RelativeLayout f49644e;

    /* renamed from: f */
    private ImageView f49645f;

    /* renamed from: g */
    private ImageView f49646g;

    /* renamed from: h */
    private TextView f49647h;

    /* renamed from: i */
    private TextView f49648i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public DiFaceCameraManager f49649j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public SurfaceTexture f49650k;

    /* renamed from: l */
    private DocumentCardsBean f49651l;

    /* renamed from: m */
    private OrientationListenerImpl f49652m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public byte[] f49653n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public ResizeTakePhoto f49654o;

    /* renamed from: p */
    private String f49655p;

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
        return R.layout.act_df_take_photo_layout2;
    }

    /* access modifiers changed from: protected */
    public void makeFaceResult(DiFaceResult diFaceResult) {
    }

    public static void start(Activity activity, DocumentCardsBean documentCardsBean) {
        Intent intent = new Intent(activity, TakePhotoAct.class);
        intent.putExtra(TakePhotoInfo.EXTRA_KEY_PHOTO_TYPE, documentCardsBean);
        activity.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
        this.f49651l = (DocumentCardsBean) intent.getSerializableExtra(TakePhotoInfo.EXTRA_KEY_PHOTO_TYPE);
        int screenWidth = DisplayUtils.getScreenWidth(this);
        int screenHeight = DisplayUtils.getScreenHeight(this);
        LogUtils.m37051d("screenW===" + screenWidth + ", screenH=" + screenHeight);
        int i = (int) (((float) screenHeight) * 0.75f);
        LogUtils.m37051d("wanted prevW===" + screenWidth + ", prevH=" + i);
        this.f49649j = new DiFaceCameraManager(DisplayUtils.getWindowRotation(getWindow()), DisplayUtils.isPortrait(this), screenWidth, screenHeight, screenWidth, i);
        this.f49652m = new OrientationListenerImpl(this, this.f49649j);
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        if (this.f49651l == null) {
            finish();
            return;
        }
        this.f49654o = new ResizeTakePhoto(this, findViewById(R.id.fl_take_photo_container), findViewById(R.id.fl_bottom_container), findViewById(R.id.take_photo_preview_img));
        hideTitleArea();
        TextureView textureView = (TextureView) findViewById(R.id.live_camera_preview);
        this.f49640a = textureView;
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return true;
            }

            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (!(TakePhotoAct.this.f49649j.getCamera() == null || TakePhotoAct.this.f49649j.getCamera().getParameters() == null || TakePhotoAct.this.f49649j.getCamera().getParameters().getPreviewSize() == null)) {
                    Camera.Size previewSize = TakePhotoAct.this.f49649j.getCamera().getParameters().getPreviewSize();
                    TakePhotoAct.this.f49654o.resize(previewSize.width, previewSize.height);
                }
                SurfaceTexture unused = TakePhotoAct.this.f49650k = surfaceTexture;
                TakePhotoAct.this.f49649j.startPreview(surfaceTexture);
            }
        });
        this.f49640a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TakePhotoAct.this.f49649j.autoFocus();
            }
        });
        this.f49642c = (ImageView) findViewById(R.id.take_photo_preview_img);
        DiSafetyImageLoader.with(this).load(this.f49651l.getWireframePicDemo()).into(this.f49642c);
        this.f49641b = (TextView) findViewById(R.id.take_photo_note);
        this.f49643d = (RelativeLayout) findViewById(R.id.take_photo_preview_container);
        ImageView imageView = (ImageView) findViewById(R.id.back_icon);
        this.f49645f = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TakePhotoAct.this.finish();
            }
        });
        ImageView imageView2 = (ImageView) findViewById(R.id.take_photo_icon);
        this.f49646g = imageView2;
        imageView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TakePhotoAct.this.f49649j.takePhoto(new Camera.PictureCallback() {
                    public void onPictureTaken(byte[] bArr, Camera camera) {
                        LogUtils.m37051d("original jpeg data.length===" + (bArr.length / 1024) + "KB");
                        byte[] unused = TakePhotoAct.this.f49653n = bArr;
                        camera.stopPreview();
                        TakePhotoAct.this.m37161a(true);
                    }
                });
            }
        });
        this.f49644e = (RelativeLayout) findViewById(R.id.take_photo_confirm_container);
        TextView textView = (TextView) findViewById(R.id.photo_retake_icon);
        this.f49647h = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                byte[] unused = TakePhotoAct.this.f49653n = null;
                TakePhotoAct.this.f49649j.startPreview(TakePhotoAct.this.f49650k);
                TakePhotoAct.this.m37161a(false);
            }
        });
        TextView textView2 = (TextView) findViewById(R.id.photo_confirm_icon);
        this.f49648i = textView2;
        textView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TakePhotoAct.this.m37158a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37158a() {
        m37160a(this.f49651l.getArgs() + ".jpg");
        BusUtils.post(new TakePhotoDoneEvent2(this.f49651l));
        finish();
    }

    /* renamed from: b */
    private void m37164b() {
        this.f49653n = null;
        this.f49649j.startPreview(this.f49650k);
        m37161a(false);
        this.f49642c.setImageResource(R.drawable.df_appeal_rg_back_preview);
        this.f49641b.setText(R.string.df_take_photo_act_preview_note_rg_back);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37161a(boolean z) {
        if (z) {
            this.f49644e.setVisibility(0);
            this.f49643d.setVisibility(4);
            this.f49642c.setVisibility(4);
            this.f49655p = this.f49641b.getText().toString();
            this.f49641b.setText(R.string.df_take_photo_act_confirm_note);
            this.f49652m.disable();
            return;
        }
        this.f49644e.setVisibility(4);
        this.f49643d.setVisibility(0);
        this.f49642c.setVisibility(0);
        this.f49641b.setText(this.f49655p);
        this.f49652m.enable();
    }

    /* renamed from: a */
    private void m37160a(String str) {
        FileOutputStream fileOutputStream;
        Exception e;
        File file = new File(getCacheDir(), str);
        LogUtils.m37051d("save jpeg file====" + file);
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(this.f49653n, 0, this.f49653n.length);
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
                Bitmap rotateBitmap = BitmapUtils.rotateBitmap(decodeByteArray, this.f49652m.getRotation());
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
        this.f49652m.enable();
        this.f49649j.openCamera(m37165c(), true);
        SurfaceTexture surfaceTexture = this.f49650k;
        if (surfaceTexture != null) {
            this.f49649j.startPreview(surfaceTexture);
        }
    }

    /* renamed from: c */
    private int m37165c() {
        if (Camera.getNumberOfCameras() != 1 && this.f49651l.isUseFrontCamera() && !DiFaceFacade.getInstance().getConfig().getForceUseBackCamera() && CameraUtils.hasFacingFrontCamera()) {
            return 1;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f49652m.disable();
        this.f49649j.closeCamera();
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        StringBuilder sb = new StringBuilder();
        sb.append("onRestart need save photo = ");
        sb.append(this.f49653n != null);
        LogUtils.m37051d(sb.toString());
        if (this.f49653n != null) {
            m37158a();
        }
    }
}
