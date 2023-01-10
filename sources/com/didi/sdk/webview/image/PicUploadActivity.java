package com.didi.sdk.webview.image;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.permission.PermissionCallback;
import com.didi.commoninterfacelib.permission.PermissionContext;
import com.didi.commoninterfacelib.permission.PermissionUtil;
import com.didi.commoninterfacelib.permission.TheOneBaseActivity;
import com.didi.hawaii.mapsdk.gesture.NNGestureClassfy;
import com.didi.payment.utilities.scan.collect.CollectionConstant;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.common.DDRpcServiceHelper;
import com.didi.sdk.util.FileUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.privacy.disclosure.PositiveResultReason;
import com.didiglobal.privacy.disclosure.PrivacyDisclosureBaseDialog;
import com.didiglobal.privacy.disclosure.PrivacyDisclosureManager;
import com.didiglobal.privacy.disclosure.PrivacyTypeEnum;
import com.facebook.internal.AnalyticsEvents;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

public class PicUploadActivity extends TheOneBaseActivity {
    public static final String DATA_PARAMS_KEY = "DATA_PARAMS_KEY";
    public static final String FINAL_PIC_MSG_KEY = "pic_msg_key";
    public static final String IMAGE_UNSPECIFIED = "image/*";
    public static final int REQUEST_CODE_SYSTEM_RESIZE_IMAGE = 104;
    public static final String TAG = "PicUploadActivity";
    public static final String UPLOAD_URL_KEY = "UPLOAD_URL_KEY";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static ImageUploadCallback f41173a = null;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static ImageCallback f41174b = null;

    /* renamed from: e */
    private static final int f41175e = 100;

    /* renamed from: f */
    private static final int f41176f = 101;

    /* renamed from: g */
    private static final int f41177g = 102;

    /* renamed from: c */
    private ListView f41178c;

    /* renamed from: d */
    private TextView f41179d;

    /* renamed from: h */
    private String f41180h;

    /* renamed from: i */
    private String f41181i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public File f41182j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public File f41183k;

    /* renamed from: l */
    private String f41184l;

    /* renamed from: m */
    private RelativeLayout f41185m;

    /* renamed from: n */
    private String f41186n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f41187o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f41188p;

    /* renamed from: q */
    private String f41189q = "";

    /* renamed from: r */
    private boolean f41190r;

    /* renamed from: s */
    private ProgressDialog f41191s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public Handler f41192t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public String f41193u;

    /* renamed from: v */
    private File f41194v = null;

    /* renamed from: w */
    private AdapterView.OnItemClickListener f41195w = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
            if (i == 0) {
                PicUploadActivity picUploadActivity = PicUploadActivity.this;
                File unused = picUploadActivity.f41182j = ImageFileConfig.getPhotoOutputFile(picUploadActivity.getApplicationContext());
                PicUploadActivity.this.m30922e();
            } else if (i == 1) {
                PicUploadActivity.this.m30927g();
            }
        }
    };

    /* renamed from: x */
    private View.OnClickListener f41196x = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (PicUploadActivity.f41174b != null) {
                PicUploadActivity.f41174b.onCancel();
            }
            PicUploadActivity.this.finish();
        }
    };

    public static void setImageUploadCallback(ImageUploadCallback imageUploadCallback) {
        f41173a = imageUploadCallback;
    }

    public static void setImageCallback(ImageCallback imageCallback) {
        f41174b = imageCallback;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        if (bundle != null) {
            this.f41184l = bundle.getString("mOutPutFile");
        }
        this.f41192t = new Handler();
        m30916c();
    }

    public void finish() {
        super.finish();
        f41173a = null;
        f41174b = null;
    }

    /* renamed from: a */
    private int m30903a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: c */
    private void m30916c() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f41186n = intent.getStringExtra("type");
            String stringExtra = intent.getStringExtra(UPLOAD_URL_KEY);
            this.f41180h = stringExtra;
            if (!TextUtils.isEmpty(stringExtra) && Uri.parse(this.f41180h).isRelative()) {
                finish();
            }
            this.f41181i = intent.getStringExtra(DATA_PARAMS_KEY);
            this.f41187o = m30903a(intent.getStringExtra("width"));
            this.f41188p = m30903a(intent.getStringExtra("height"));
            this.f41189q = intent.getStringExtra(CollectionConstant.APOLLO_PARAM_QUALITY);
            this.f41190r = intent.getBooleanExtra("cut", false);
        }
        File photoOutputFile = ImageFileConfig.getPhotoOutputFile(getApplicationContext());
        this.f41183k = photoOutputFile;
        if (photoOutputFile != null) {
            this.f41184l = photoOutputFile.getAbsolutePath();
        }
        if (this.f41186n.equals("camera")) {
            this.f41182j = ImageFileConfig.getPhotoOutputFile(getApplicationContext());
            m30922e();
        } else if (this.f41186n.equals(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO)) {
            m30927g();
        } else {
            overridePendingTransition(R.anim.down_to_up_slide_in, R.anim.up_to_down_slide_out);
            setContentView((int) R.layout.image_pick_dialog_layout);
            m30920d();
        }
    }

    /* renamed from: d */
    private void m30920d() {
        this.f41178c = (ListView) findViewById(R.id.pic_menu_list);
        this.f41185m = (RelativeLayout) findViewById(R.id.bts_upload_rela);
        this.f41178c.setAdapter(new ArrayAdapter(this, R.layout.v_pic_upload_list, getResources().getStringArray(R.array.avatar_menu)));
        this.f41178c.setOnItemClickListener(this.f41195w);
        TextView textView = (TextView) findViewById(R.id.cancel_text);
        this.f41179d = textView;
        textView.setOnClickListener(this.f41196x);
    }

    public static boolean isCameraCanUse() {
        Camera camera;
        boolean z = false;
        try {
            camera = Camera.open(0);
            try {
                camera.setDisplayOrientation(90);
                z = true;
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            camera = null;
        }
        if (z) {
            camera.release();
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m30922e() {
        PrivacyDisclosureManager.getInstance().openPrivacyDisclosureDialog(this, PrivacyTypeEnum.CAMERA, new String[]{Permission.CAMERA, Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE}, new PrivacyDisclosureBaseDialog.Callback() {
            public void onPositiveResult(PositiveResultReason positiveResultReason) {
                PicUploadActivity.this.m30925f();
            }

            public void onNegativeResult() {
                if (PicUploadActivity.f41174b != null) {
                    PicUploadActivity.f41174b.onPermissionFail();
                }
                PicUploadActivity.this.finish();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m30925f() {
        final Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(getPackageManager()) != null && this.f41182j != null) {
            PermissionUtil.checkAndRequestPermissions((PermissionContext) this, (PermissionCallback) new PermissionCallback() {
                public void isAllGranted(boolean z, String[] strArr) {
                    Uri uri;
                    if (z) {
                        if (Build.VERSION.SDK_INT < 24) {
                            intent.putExtra("output", Uri.fromFile(PicUploadActivity.this.f41182j));
                        } else {
                            if (Apollo.getToggle("global_pick_image_provider_uri", true).allow()) {
                                PicUploadActivity picUploadActivity = PicUploadActivity.this;
                                uri = FileProvider.getUriForFile(picUploadActivity, PicUploadActivity.this.getPackageName() + ".fileprovider", PicUploadActivity.this.f41182j);
                            } else {
                                ContentValues contentValues = new ContentValues(1);
                                contentValues.put("_data", PicUploadActivity.this.f41182j.getAbsolutePath());
                                uri = PicUploadActivity.this.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                            }
                            intent.putExtra("output", uri);
                            intent.addFlags(2);
                        }
                        PicUploadActivity.this.startActivityForResult(intent, 101);
                        return;
                    }
                    if (PicUploadActivity.f41174b != null) {
                        PicUploadActivity.f41174b.onPermissionFail();
                    }
                    PicUploadActivity.this.finish();
                }
            }, new String[]{Permission.CAMERA, Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE}, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m30927g() {
        PrivacyDisclosureManager.getInstance().openPrivacyDisclosureDialog(this, PrivacyTypeEnum.ALBUM, new String[]{Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE}, new PrivacyDisclosureBaseDialog.Callback() {
            public void onPositiveResult(PositiveResultReason positiveResultReason) {
                PicUploadActivity.this.m30929h();
            }

            public void onNegativeResult() {
                if (PicUploadActivity.f41174b != null) {
                    PicUploadActivity.f41174b.onPermissionFail();
                }
                PicUploadActivity.this.finish();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m30929h() {
        PermissionUtil.checkAndRequestPermissions((PermissionContext) this, (PermissionCallback) new PermissionCallback() {
            public void isAllGranted(boolean z, String[] strArr) {
                if (z) {
                    try {
                        Intent intent = new Intent("android.intent.action.PICK", (Uri) null);
                        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, PicUploadActivity.IMAGE_UNSPECIFIED);
                        PicUploadActivity.this.startActivityForResult(intent, 100);
                    } catch (Exception unused) {
                        ToastHelper.showShortInfo((Context) PicUploadActivity.this, "Open Pick App Error");
                    }
                } else {
                    if (PicUploadActivity.f41174b != null) {
                        PicUploadActivity.f41174b.onPermissionFail();
                    }
                    PicUploadActivity.this.finish();
                }
            }
        }, new String[]{Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE}, true);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0) {
            ImageCallback imageCallback = f41174b;
            if (imageCallback != null) {
                imageCallback.onCancel();
            }
            finish();
        } else if (i != 104) {
            switch (i) {
                case 100:
                    if (i2 == -1) {
                        if (this.f41183k == null) {
                            finish();
                        }
                        if (this.f41187o == 0 || this.f41188p == 0) {
                            Uri data = intent.getData();
                            String path = FileUtil.getPath(this, data);
                            File photoOutputFile = ImageFileConfig.getPhotoOutputFile(getApplicationContext());
                            FileUtil.copyFile(path, photoOutputFile.getAbsolutePath());
                            if (this.f41190r) {
                                m30917c(Uri.fromFile(photoOutputFile));
                                return;
                            } else {
                                m30913b(data);
                                return;
                            }
                        } else if (!this.f41190r || !m30910a(intent.getData())) {
                            m30913b(intent.getData());
                            return;
                        } else {
                            return;
                        }
                    } else {
                        ImageCallback imageCallback2 = f41174b;
                        if (imageCallback2 != null) {
                            imageCallback2.onCancel();
                        }
                        finish();
                        return;
                    }
                case 101:
                    if (i2 == -1) {
                        File file = this.f41182j;
                        if (file == null || file.length() <= 0) {
                            FileUtil.deleteFile(this.f41182j);
                            ImageCallback imageCallback3 = f41174b;
                            if (imageCallback3 != null) {
                                imageCallback3.onFail();
                            }
                            finish();
                            return;
                        }
                        Uri fromFile = Uri.fromFile(this.f41182j);
                        if (this.f41187o == 0 || this.f41188p == 0) {
                            if (this.f41190r) {
                                m30917c(fromFile);
                                return;
                            } else {
                                m30913b(fromFile);
                                return;
                            }
                        } else if (!this.f41190r || !m30910a(fromFile)) {
                            m30913b(fromFile);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        FileUtil.deleteFile(this.f41182j);
                        if (f41174b != null) {
                            if (ActivityCompat.checkSelfPermission(this, Permission.CAMERA) != 0 || !isCameraCanUse()) {
                                f41174b.onPermissionFail();
                            } else {
                                f41174b.onCancel();
                            }
                        }
                        finish();
                        return;
                    }
                case 102:
                    if (i2 != -1 || intent == null) {
                        ImageCallback imageCallback4 = f41174b;
                        if (imageCallback4 != null) {
                            imageCallback4.onFail();
                        }
                        finish();
                        return;
                    }
                    RelativeLayout relativeLayout = this.f41185m;
                    if (relativeLayout != null) {
                        relativeLayout.setVisibility(8);
                    }
                    String stringExtra = intent.getStringExtra("CROP_PIC_PASS_KEY");
                    if (!TextUtils.isEmpty(this.f41180h)) {
                        m30921d(stringExtra);
                        return;
                    }
                    ImageUploadCallback imageUploadCallback = f41173a;
                    if (imageUploadCallback != null) {
                        imageUploadCallback.onSuccess(m30915c(stringExtra));
                    }
                    ImageCallback imageCallback5 = f41174b;
                    if (imageCallback5 != null) {
                        imageCallback5.onSuccess(m30915c(stringExtra), this.f41193u, m30912b(stringExtra));
                    }
                    finish();
                    return;
                default:
                    return;
            }
        } else if (i2 == -1) {
            final Uri fromFile2 = Uri.fromFile(this.f41194v);
            new Thread(new Runnable() {
                public void run() {
                    try {
                        final String decodeSampledBitmap = PicUploadActivity.this.decodeSampledBitmap(fromFile2, 600, 600);
                        PicUploadActivity.this.f41192t.post(new Runnable() {
                            public void run() {
                                if (PicUploadActivity.f41174b != null) {
                                    PicUploadActivity.f41174b.onSuccess(decodeSampledBitmap, PicUploadActivity.this.f41193u, PicUploadActivity.this.m30912b(FileUtil.getPath(PicUploadActivity.this, fromFile2)));
                                }
                                PicUploadActivity.this.finish();
                            }
                        });
                    } catch (Exception unused) {
                        PicUploadActivity.this.f41192t.post(new Runnable() {
                            public void run() {
                                if (PicUploadActivity.f41174b != null) {
                                    PicUploadActivity.f41174b.onFail();
                                }
                                PicUploadActivity.this.finish();
                            }
                        });
                    }
                }
            }).start();
            this.f41178c.setOnItemClickListener((AdapterView.OnItemClickListener) null);
        } else {
            ImageCallback imageCallback6 = f41174b;
            if (imageCallback6 != null) {
                imageCallback6.onCancel();
            }
            finish();
        }
    }

    /* renamed from: a */
    private boolean m30910a(Uri uri) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), (Rect) null, options);
            if (options.outHeight < this.f41188p || options.outWidth < this.f41187o) {
                return false;
            }
            Intent intent = new Intent(this, CropActivity.class);
            intent.setData(uri);
            intent.putExtra("width", this.f41187o);
            intent.putExtra("height", this.f41188p);
            intent.putExtra("output", this.f41184l);
            startActivityForResult(intent, 102);
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m30912b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String exifDateTime = ExifUtils.getExifDateTime(str);
            if (!TextUtils.isEmpty(exifDateTime)) {
                return exifDateTime;
            }
            return new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.getDefault()).format(new Date(new File(str).lastModified()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    private void m30913b(final Uri uri) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    final String decodeSampledBitmap = PicUploadActivity.this.decodeSampledBitmap(uri, PicUploadActivity.this.f41187o, PicUploadActivity.this.f41188p);
                    PicUploadActivity.this.f41192t.post(new Runnable() {
                        public void run() {
                            if (PicUploadActivity.f41174b != null) {
                                PicUploadActivity.f41174b.onSuccess(decodeSampledBitmap, PicUploadActivity.this.f41193u, PicUploadActivity.this.m30912b(FileUtil.getPath(PicUploadActivity.this, uri)));
                            }
                            PicUploadActivity.this.finish();
                        }
                    });
                } catch (Exception unused) {
                    PicUploadActivity.this.f41192t.post(new Runnable() {
                        public void run() {
                            if (PicUploadActivity.f41174b != null) {
                                PicUploadActivity.f41174b.onFail();
                            }
                            PicUploadActivity.this.finish();
                        }
                    });
                }
            }
        }).start();
        ListView listView = this.f41178c;
        if (listView != null) {
            listView.setOnItemClickListener((AdapterView.OnItemClickListener) null);
        }
    }

    /* renamed from: c */
    private void m30917c(Uri uri) {
        try {
            Intent intent = new Intent("com.android.camera.action.CROP");
            if (Build.VERSION.SDK_INT >= 24) {
                Uri uriForFile = FileProvider.getUriForFile(this, "com.didi.sdk.fileprovider.global", new File(uri.getPath()));
                intent.addFlags(1);
                intent.setDataAndType(uriForFile, IMAGE_UNSPECIFIED);
            } else if (Build.VERSION.SDK_INT >= 19) {
                intent.setDataAndType(Uri.fromFile(new File(FileUtil.getPath(this, uri))), IMAGE_UNSPECIFIED);
            } else {
                intent.setDataAndType(uri, IMAGE_UNSPECIFIED);
            }
            File photoOutputFile = ImageFileConfig.getPhotoOutputFile(getApplicationContext());
            this.f41194v = photoOutputFile;
            Uri fromFile = Uri.fromFile(photoOutputFile);
            intent.putExtra("crop", "true");
            intent.putExtra(NNGestureClassfy.SCALE_LABLE, true);
            intent.putExtra("return-data", false);
            intent.putExtra("output", fromFile);
            intent.putExtra("noFaceDetection", true);
            startActivityForResult(intent, 104);
        } catch (Exception unused) {
            ToastHelper.showShortError((Context) this, getString(R.string.crop_pic_modify_error2));
        }
    }

    public int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 1;
        }
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 <= i2 && i4 <= i) {
            return 1;
        }
        int round = Math.round(((float) i3) / ((float) i2));
        int round2 = Math.round(((float) i4) / ((float) i));
        return round < round2 ? round : round2;
    }

    public String decodeSampledBitmap(Uri uri, int i, int i2) throws FileNotFoundException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), (Rect) null, options);
        options.inSampleSize = calculateInSampleSize(options, i, i2);
        options.inJustDecodeBounds = false;
        Bitmap decodeStream = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), (Rect) null, options);
        int exifOrientation = ExifUtils.getExifOrientation(this, uri);
        if (exifOrientation != 0) {
            decodeStream = m30904a(decodeStream, exifOrientation, true);
        }
        return m30907a(decodeStream, options);
    }

    /* renamed from: a */
    private Bitmap m30904a(Bitmap bitmap, int i, boolean z) {
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

    /* renamed from: c */
    private String m30915c(String str) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        try {
            if (TextUtil.isEmpty(this.f41189q)) {
                this.f41189q = "100";
            }
            int parseInt = Integer.parseInt(this.f41189q);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            decodeFile.compress(Bitmap.CompressFormat.JPEG, parseInt, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 4);
        } catch (IOException e) {
            SystemUtils.log(3, TAG, e.toString(), (Throwable) null, "com.didi.sdk.webview.image.PicUploadActivity", 674);
            return "";
        } catch (Exception e2) {
            SystemUtils.log(3, TAG, e2.toString(), (Throwable) null, "com.didi.sdk.webview.image.PicUploadActivity", 676);
            return "";
        }
    }

    /* renamed from: a */
    private String m30907a(Bitmap bitmap, BitmapFactory.Options options) {
        try {
            if (TextUtil.isEmpty(this.f41189q)) {
                this.f41189q = "75";
            }
            int parseInt = Integer.parseInt(this.f41189q);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (!TextUtil.isEmpty(this.f41193u) && this.f41193u.contains("jpeg")) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, parseInt, byteArrayOutputStream);
                this.f41193u = com.didi.dimina.starbox.util.FileUtil.JPG;
            } else if (TextUtil.isEmpty(this.f41193u) || !this.f41193u.contains("png")) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, parseInt, byteArrayOutputStream);
                String str = options.outMimeType;
                if (TextUtil.isEmpty(str) || !str.contains("/")) {
                    this.f41193u = "";
                } else {
                    this.f41193u = str.split("/")[1];
                }
            } else {
                this.f41193u = "png";
                bitmap.compress(Bitmap.CompressFormat.PNG, parseInt, byteArrayOutputStream);
            }
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 4);
        } catch (IOException e) {
            SystemUtils.log(3, TAG, e.toString(), (Throwable) null, "com.didi.sdk.webview.image.PicUploadActivity", 710);
            return "";
        } catch (Exception e2) {
            SystemUtils.log(3, TAG, e2.toString(), (Throwable) null, "com.didi.sdk.webview.image.PicUploadActivity", 712);
            return "";
        }
    }

    /* renamed from: i */
    private void m30931i() {
        try {
            if (this.f41191s == null) {
                this.f41191s = new ProgressDialog(this);
            }
            this.f41191s.setMessage(getString(R.string.image_uploading));
            this.f41191s.setCancelable(false);
            this.f41191s.setCanceledOnTouchOutside(false);
            SystemUtils.showDialog(this.f41191s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m30932j() {
        ProgressDialog progressDialog = this.f41191s;
        if (progressDialog != null) {
            if (progressDialog.isShowing()) {
                try {
                    this.f41191s.dismiss();
                } catch (Exception unused) {
                }
            }
            this.f41191s = null;
        }
    }

    /* renamed from: d */
    private void m30921d(String str) {
        if (!TextUtils.isEmpty(str)) {
            m30931i();
            ImageUploadService imageUploadService = (ImageUploadService) DDRpcServiceHelper.getRpcServiceFactory().newRpcService(ImageUploadService.class, this.f41180h);
            HashMap<String, Object> createParams = UploadParams.createParams(this, new File(str), this.f41181i);
            try {
                imageUploadService.uploadImage(UploadParams.createQueryParams(this), createParams, new RpcService.Callback<String>() {
                    public void onSuccess(String str) {
                        PicUploadActivity.this.m30932j();
                        FileUtil.deleteFile(PicUploadActivity.this.f41183k);
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            int optInt = jSONObject.optInt("errno");
                            String optString = jSONObject.optString("errmsg");
                            if (optInt != 0) {
                                ToastHelper.showShortError((Context) PicUploadActivity.this, optString);
                            } else if (PicUploadActivity.f41173a != null) {
                                PicUploadActivity.f41173a.onSuccess(str);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        PicUploadActivity.this.finish();
                    }

                    public void onFailure(IOException iOException) {
                        PicUploadActivity.this.m30932j();
                        ToastHelper.showShortError((Context) PicUploadActivity.this, (int) R.string.image_upload_failed);
                        FileUtil.deleteFile(PicUploadActivity.this.f41183k);
                        PicUploadActivity.this.finish();
                    }
                });
            } catch (UndeclaredThrowableException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("mOutPutFile", this.f41184l);
    }

    public void onBackPressed() {
        ImageCallback imageCallback = f41174b;
        if (imageCallback != null) {
            imageCallback.onCancel();
        }
        super.onBackPressed();
    }
}
