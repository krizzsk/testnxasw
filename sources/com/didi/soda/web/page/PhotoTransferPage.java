package com.didi.soda.web.page;

import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.SimpleSwapChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.VerticalChangeHandler;
import com.didi.onehybrid.BusinessAgent;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.FileUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.webview.image.PicUploadActivity;
import com.didi.soda.web.BizAgent;
import com.didi.soda.web.SodaFusionEngine;
import com.didi.soda.web.WebFileProvider;
import com.didi.soda.web.WebFusionCallback;
import com.didi.soda.web.config.WebConstant;
import com.didi.soda.web.model.CallBackModel;
import com.didi.soda.web.model.PhotoJsBridgeData;
import com.didi.soda.web.p168ui.WebMenuListPopup;
import com.didi.soda.web.tools.BitmapUtils;
import com.didi.soda.web.tools.ExifUtils;
import com.didi.soda.web.tools.LogUtil;
import com.didi.soda.web.tools.WebJsBridgeTool;
import com.didi.sofa.utils.ToastUtils;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

public class PhotoTransferPage extends Page {

    /* renamed from: a */
    private static final int f46437a = 1005;

    /* renamed from: b */
    private static final int f46438b = 1006;

    /* renamed from: c */
    private int f46439c;

    /* renamed from: d */
    private FrameLayout f46440d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public WebMenuListPopup f46441e;

    /* renamed from: f */
    private PhotoJsBridgeData.GetPhotoData f46442f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public File f46443g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f46444h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f46445i;

    /* renamed from: j */
    private float f46446j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Handler f46447k;

    /* renamed from: l */
    private String f46448l;

    /* renamed from: m */
    private Uri f46449m;

    /* renamed from: n */
    private WebMenuListPopup.MenuListClickListener f46450n = new WebMenuListPopup.MenuListClickListener() {
        public void onMenuCancel() {
            PhotoTransferPage.this.f46441e.dismiss();
            PhotoTransferPage.this.m34619h();
            PhotoTransferPage.this.finish();
        }

        public void onStartCamera() {
            PhotoTransferPage.this.m34615f();
        }

        public void onStartAlbum() {
            PhotoTransferPage.this.m34617g();
        }
    };

    /* renamed from: o */
    private String f46451o = "";

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        this.f46440d = frameLayout;
        frameLayout.setBackgroundColor(0);
        this.f46440d.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return this.f46440d;
    }

    public void onCreate(View view) {
        super.onCreate(view);
        this.f46447k = new Handler();
        WebMenuListPopup webMenuListPopup = new WebMenuListPopup(getBaseContext(), getScopeContext());
        this.f46441e = webMenuListPopup;
        webMenuListPopup.setListener(this.f46450n);
        m34599a();
    }

    public ControllerChangeHandler getPushHandler() {
        return new VerticalChangeHandler(false);
    }

    public ControllerChangeHandler getPopHandler() {
        return new SimpleSwapChangeHandler(false);
    }

    /* renamed from: a */
    private void m34599a() {
        PhotoJsBridgeData.GetPhotoData getPhotoData = (PhotoJsBridgeData.GetPhotoData) getArgs().getSerializable(WebConstant.Transfer.TRANSFER_PAGE_DATA);
        this.f46442f = getPhotoData;
        if (getPhotoData == null) {
            m34607b("param[transfer_page_data] is null");
            finish();
            return;
        }
        this.f46444h = getPhotoData.getResize().getWidth();
        this.f46445i = this.f46442f.getResize().getHeight();
        this.f46446j = this.f46442f.getQuality() * 100.0f;
        m34603a(this.f46442f.getType());
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0046  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m34603a(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = -1361224287(0xffffffffaedd5da1, float:-1.0066548E-10)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = -500264356(0xffffffffe22e925c, float:-8.0506994E20)
            if (r0 == r1) goto L_0x0020
            r1 = 92896879(0x5897e6f, float:1.2929862E-35)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "album"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 1
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "photograph"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 0
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "choice"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 2
            goto L_0x0035
        L_0x0034:
            r5 = -1
        L_0x0035:
            if (r5 == 0) goto L_0x0046
            if (r5 == r3) goto L_0x0042
            if (r5 == r2) goto L_0x003c
            goto L_0x0049
        L_0x003c:
            com.didi.soda.web.ui.WebMenuListPopup r5 = r4.f46441e
            r5.show()
            goto L_0x0049
        L_0x0042:
            r4.m34617g()
            goto L_0x0049
        L_0x0046:
            r4.m34615f()
        L_0x0049:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.web.page.PhotoTransferPage.m34603a(java.lang.String):void");
    }

    /* renamed from: a */
    private void m34600a(int i) {
        if (i == 1) {
            try {
                this.f46443g = m34610d();
                m34608c();
            } catch (Exception e) {
                e.printStackTrace();
                if (e instanceof ActivityNotFoundException) {
                    LogUtil.debug("PhotoTransferPage: ActivityNotFoundException");
                }
                m34607b(e.getMessage());
            }
        } else if (i == 2) {
            Intent intent = new Intent("android.intent.action.PICK", (Uri) null);
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, PicUploadActivity.IMAGE_UNSPECIFIED);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent, 1005);
                return;
            }
            LogUtil.debug("PhotoTransferPage: ALBUM intent.resolveActivity == null");
            if (Build.VERSION.SDK_INT >= 30) {
                startActivityForResult(intent, 1005);
                return;
            }
            LogUtil.debug("PhotoTransferPage: can not find target page");
            ToastUtils.show(getBaseContext(), (CharSequence) "can not find target page");
        }
    }

    /* renamed from: b */
    private Uri m34605b() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues());
        }
        return getContentResolver().insert(MediaStore.Images.Media.INTERNAL_CONTENT_URI, new ContentValues());
    }

    /* renamed from: c */
    private void m34608c() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(getPackageManager()) == null) {
            LogUtil.debug("PhotoTransferPage: CAMERA intent.resolveActivity == null");
            try {
                if (Build.VERSION.SDK_INT >= 30) {
                    Uri b = m34605b();
                    this.f46449m = b;
                    if (b != null) {
                        intent.putExtra("output", b);
                        intent.addFlags(2);
                        startActivityForResult(intent, 1006);
                    }
                }
            } catch (ActivityNotFoundException unused) {
                LogUtil.debug("PhotoTransferPage: CAMERA ActivityNotFoundException");
            }
        } else if (Build.VERSION.SDK_INT >= 29) {
            Uri b2 = m34605b();
            this.f46449m = b2;
            if (b2 != null) {
                intent.putExtra("output", b2);
                intent.addFlags(2);
                startActivityForResult(intent, 1006);
            }
        } else if (this.f46443g != null) {
            if (Build.VERSION.SDK_INT < 24) {
                intent.putExtra("output", Uri.fromFile(this.f46443g));
            } else {
                Context baseContext = getBaseContext();
                Uri uriForFile = WebFileProvider.getUriForFile(baseContext, getBaseContext().getPackageName() + WebConstant.WEB_FILE_PATH, this.f46443g);
                for (ResolveInfo resolveInfo : getBaseContext().getPackageManager().queryIntentActivities(intent, 65536)) {
                    getBaseContext().grantUriPermission(resolveInfo.activityInfo.packageName, uriForFile, 3);
                }
                intent.putExtra("output", uriForFile);
            }
            startActivityForResult(intent, 1006);
        } else {
            LogUtil.debug("PhotoTransferPage mCameraFile == null");
        }
    }

    /* renamed from: d */
    private File m34610d() {
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return new File(m34613e() + File.separator + "IMG_" + format + ".jpg");
    }

    /* renamed from: e */
    private String m34613e() {
        String str = getCacheRoot() + "photo/";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public String getPath() {
        if (ContextCompat.checkSelfPermission(getBaseContext(), Permission.READ_EXTERNAL_STORAGE) == 0 && ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable())) {
            return SystemUtils.getExternalStorageDirectory().getPath() + "/";
        } else if (getExternalCacheDir() == null) {
            return null;
        } else {
            return getExternalCacheDir().getPath() + "/";
        }
    }

    public final String getCacheRoot() {
        if (TextUtils.isEmpty(this.f46451o)) {
            if (TextUtils.isEmpty(getPath())) {
                m34607b("cache path is null");
                finish();
                return null;
            }
            this.f46451o = getPath() + "soda/";
            File file = new File(this.f46451o);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.f46451o;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m34615f() {
        this.f46439c = 1;
        BusinessAgent businessAgent = SodaFusionEngine.getBusinessAgent();
        if (!(businessAgent instanceof BizAgent) || ((BizAgent) businessAgent).needRequestPermission()) {
            requestPermissions(new String[]{Permission.CAMERA});
        } else {
            m34600a(this.f46439c);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m34617g() {
        this.f46439c = 2;
        BusinessAgent businessAgent = SodaFusionEngine.getBusinessAgent();
        if (!(businessAgent instanceof BizAgent) || ((BizAgent) businessAgent).needRequestPermission()) {
            requestPermissions(new String[]{Permission.WRITE_EXTERNAL_STORAGE});
        } else {
            m34600a(this.f46439c);
        }
    }

    public void onPermissionDenied(String[] strArr) {
        super.onPermissionDenied(strArr);
        m34619h();
        finish();
    }

    public void onPermissionGranted() {
        super.onPermissionGranted();
        m34600a(this.f46439c);
    }

    public boolean onHandleBack() {
        this.f46441e.dismiss();
        m34619h();
        finish();
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            Uri uri = null;
            if (i == 1005) {
                if (intent != null) {
                    String dataString = intent.getDataString();
                    if (dataString != null) {
                        uri = Uri.parse(dataString);
                    }
                    LogUtil.debug("PhotoTransferPage dataString == " + dataString);
                }
                LogUtil.debug("PhotoTransferPage uri == " + uri);
                if (uri != null) {
                    m34601a(uri);
                }
            } else if (i == 1006) {
                LogUtil.debug("PhotoTransferPage mCameraFile == " + this.f46443g);
                if (Build.VERSION.SDK_INT >= 29) {
                    Uri uri2 = this.f46449m;
                    if (uri2 != null) {
                        m34601a(uri2);
                    }
                } else {
                    File file = this.f46443g;
                    if (file == null || file.length() <= 0) {
                        FileUtil.deleteFile(this.f46443g);
                    } else {
                        m34601a(Uri.fromFile(this.f46443g));
                    }
                }
            }
        } else {
            m34619h();
        }
        finish();
    }

    /* renamed from: a */
    private void m34601a(final Uri uri) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    final String decodeSampledBitmap = PhotoTransferPage.this.decodeSampledBitmap(uri, PhotoTransferPage.this.f46444h, PhotoTransferPage.this.f46445i);
                    PhotoTransferPage.this.f46447k.post(new Runnable() {
                        /* JADX WARNING: Code restructure failed: missing block: B:10:0x008a, code lost:
                            if (com.didi.soda.web.page.PhotoTransferPage.m34616g(r8.this$1.this$0) == null) goto L_0x0097;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:11:0x008c, code lost:
                            com.didi.soda.web.page.PhotoTransferPage.m34616g(r8.this$1.this$0).delete();
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0097, code lost:
                            r8.this$1.this$0.finish();
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:13:0x009e, code lost:
                            return;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:4:0x004a, code lost:
                            if (com.didi.soda.web.page.PhotoTransferPage.m34616g(r8.this$1.this$0) != null) goto L_0x008c;
                         */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void run() {
                            /*
                                r8 = this;
                                java.lang.String r0 = "getPhoto"
                                java.lang.String r1 = "PhotoTransferPage doCallbackWithName"
                                org.json.JSONObject r2 = new org.json.JSONObject
                                r2.<init>()
                                r3 = 0
                                r4 = 1
                                java.lang.String r5 = "type"
                                java.lang.String r6 = "jpg"
                                r2.put(r5, r6)     // Catch:{ JSONException -> 0x004f }
                                java.lang.String r5 = "image"
                                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x004f }
                                r6.<init>()     // Catch:{ JSONException -> 0x004f }
                                java.lang.String r7 = "data:image/jpeg;base64,"
                                r6.append(r7)     // Catch:{ JSONException -> 0x004f }
                                java.lang.String r7 = r0     // Catch:{ JSONException -> 0x004f }
                                r6.append(r7)     // Catch:{ JSONException -> 0x004f }
                                java.lang.String r6 = r6.toString()     // Catch:{ JSONException -> 0x004f }
                                r2.put(r5, r6)     // Catch:{ JSONException -> 0x004f }
                                com.didi.soda.web.tools.LogUtil.debug(r1)
                                com.didi.soda.web.WebFusionCallback r1 = com.didi.soda.web.WebFusionCallback.getInstance()
                                java.lang.Object[] r4 = new java.lang.Object[r4]
                                com.didi.soda.web.model.CallBackModel r5 = new com.didi.soda.web.model.CallBackModel
                                r5.<init>(r2)
                                org.json.JSONObject r2 = com.didi.soda.web.tools.WebJsBridgeTool.buildResponse((com.didi.soda.web.model.CallBackModel) r5)
                                r4[r3] = r2
                                r1.doCallbackWithName(r0, r4)
                                com.didi.soda.web.page.PhotoTransferPage$2 r0 = com.didi.soda.web.page.PhotoTransferPage.C150172.this
                                com.didi.soda.web.page.PhotoTransferPage r0 = com.didi.soda.web.page.PhotoTransferPage.this
                                java.io.File r0 = r0.f46443g
                                if (r0 == 0) goto L_0x0097
                                goto L_0x008c
                            L_0x004d:
                                r5 = move-exception
                                goto L_0x009f
                            L_0x004f:
                                r5 = move-exception
                                r5.printStackTrace()     // Catch:{ all -> 0x004d }
                                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x004d }
                                r6.<init>()     // Catch:{ all -> 0x004d }
                                java.lang.String r7 = "PhotoTransferPage transfer json crash"
                                r6.append(r7)     // Catch:{ all -> 0x004d }
                                java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x004d }
                                r6.append(r5)     // Catch:{ all -> 0x004d }
                                java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x004d }
                                com.didi.soda.web.tools.LogUtil.debug(r5)     // Catch:{ all -> 0x004d }
                                com.didi.soda.web.tools.LogUtil.debug(r1)
                                com.didi.soda.web.WebFusionCallback r1 = com.didi.soda.web.WebFusionCallback.getInstance()
                                java.lang.Object[] r4 = new java.lang.Object[r4]
                                com.didi.soda.web.model.CallBackModel r5 = new com.didi.soda.web.model.CallBackModel
                                r5.<init>(r2)
                                org.json.JSONObject r2 = com.didi.soda.web.tools.WebJsBridgeTool.buildResponse((com.didi.soda.web.model.CallBackModel) r5)
                                r4[r3] = r2
                                r1.doCallbackWithName(r0, r4)
                                com.didi.soda.web.page.PhotoTransferPage$2 r0 = com.didi.soda.web.page.PhotoTransferPage.C150172.this
                                com.didi.soda.web.page.PhotoTransferPage r0 = com.didi.soda.web.page.PhotoTransferPage.this
                                java.io.File r0 = r0.f46443g
                                if (r0 == 0) goto L_0x0097
                            L_0x008c:
                                com.didi.soda.web.page.PhotoTransferPage$2 r0 = com.didi.soda.web.page.PhotoTransferPage.C150172.this
                                com.didi.soda.web.page.PhotoTransferPage r0 = com.didi.soda.web.page.PhotoTransferPage.this
                                java.io.File r0 = r0.f46443g
                                r0.delete()
                            L_0x0097:
                                com.didi.soda.web.page.PhotoTransferPage$2 r0 = com.didi.soda.web.page.PhotoTransferPage.C150172.this
                                com.didi.soda.web.page.PhotoTransferPage r0 = com.didi.soda.web.page.PhotoTransferPage.this
                                r0.finish()
                                return
                            L_0x009f:
                                com.didi.soda.web.tools.LogUtil.debug(r1)
                                com.didi.soda.web.WebFusionCallback r1 = com.didi.soda.web.WebFusionCallback.getInstance()
                                java.lang.Object[] r4 = new java.lang.Object[r4]
                                com.didi.soda.web.model.CallBackModel r6 = new com.didi.soda.web.model.CallBackModel
                                r6.<init>(r2)
                                org.json.JSONObject r2 = com.didi.soda.web.tools.WebJsBridgeTool.buildResponse((com.didi.soda.web.model.CallBackModel) r6)
                                r4[r3] = r2
                                r1.doCallbackWithName(r0, r4)
                                com.didi.soda.web.page.PhotoTransferPage$2 r0 = com.didi.soda.web.page.PhotoTransferPage.C150172.this
                                com.didi.soda.web.page.PhotoTransferPage r0 = com.didi.soda.web.page.PhotoTransferPage.this
                                java.io.File r0 = r0.f46443g
                                if (r0 == 0) goto L_0x00cb
                                com.didi.soda.web.page.PhotoTransferPage$2 r0 = com.didi.soda.web.page.PhotoTransferPage.C150172.this
                                com.didi.soda.web.page.PhotoTransferPage r0 = com.didi.soda.web.page.PhotoTransferPage.this
                                java.io.File r0 = r0.f46443g
                                r0.delete()
                            L_0x00cb:
                                com.didi.soda.web.page.PhotoTransferPage$2 r0 = com.didi.soda.web.page.PhotoTransferPage.C150172.this
                                com.didi.soda.web.page.PhotoTransferPage r0 = com.didi.soda.web.page.PhotoTransferPage.this
                                r0.finish()
                                throw r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.web.page.PhotoTransferPage.C150172.C150181.run():void");
                        }
                    });
                } catch (Exception e) {
                    final String message = e.getMessage();
                    LogUtil.debug("PhotoTransferPage decodeSampled bitmap crash:" + message);
                    PhotoTransferPage.this.f46447k.post(new Runnable() {
                        public void run() {
                            PhotoTransferPage.this.m34607b(message);
                            if (PhotoTransferPage.this.f46443g != null) {
                                PhotoTransferPage.this.f46443g.delete();
                            }
                            PhotoTransferPage.this.finish();
                        }
                    });
                }
            }
        }).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m34619h() {
        WebFusionCallback.getInstance().doCallbackWithName(WebConstant.BridgeMethod.GET_PHOTO, WebJsBridgeTool.buildResponse(2));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m34607b(String str) {
        LogUtil.debug("PhotoTransferPage: handlePicFail" + str);
        WebFusionCallback.getInstance().doCallbackWithName(WebConstant.BridgeMethod.GET_PHOTO, WebJsBridgeTool.buildResponse(new CallBackModel(1, str, (JSONObject) null)));
    }

    public String decodeSampledBitmap(Uri uri, int i, int i2) throws FileNotFoundException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), (Rect) null, options);
        options.inSampleSize = calculateInSampleSize(options, i, i2);
        options.inJustDecodeBounds = false;
        Bitmap decodeStream = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), (Rect) null, options);
        int exifOrientation = ExifUtils.getExifOrientation(getBaseContext(), uri);
        if (exifOrientation != 0) {
            decodeStream = m34596a(decodeStream, exifOrientation, true);
        }
        return m34598a(decodeStream, options);
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

    /* renamed from: a */
    private Bitmap m34596a(Bitmap bitmap, int i, boolean z) {
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

    /* renamed from: a */
    private String m34598a(Bitmap bitmap, BitmapFactory.Options options) {
        try {
            if (this.f46446j <= 0.0f) {
                this.f46446j = 75.0f;
            }
            int i = (int) this.f46446j;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (!TextUtil.isEmpty(this.f46448l) && this.f46448l.contains("jpeg")) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
                this.f46448l = com.didi.dimina.starbox.util.FileUtil.JPG;
            } else if (TextUtil.isEmpty(this.f46448l) || !this.f46448l.contains("png")) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
                String str = options.outMimeType;
                if (TextUtil.isEmpty(str) || !str.contains("/")) {
                    this.f46448l = "";
                } else {
                    this.f46448l = str.split("/")[1];
                }
            } else {
                this.f46448l = "png";
                bitmap.compress(Bitmap.CompressFormat.PNG, i, byteArrayOutputStream);
            }
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 4);
        } catch (IOException e) {
            LogUtil.debug("PhotoTransferPage bitmapToBase64 IOException crash" + e.getMessage());
            LogUtil.erro(e.toString());
            return "";
        } catch (Exception e2) {
            LogUtil.debug("PhotoTransferPage bitmapToBase64 Exception crash" + e2.getMessage());
            LogUtil.erro(e2.toString());
            return "";
        }
    }

    /* renamed from: b */
    private Bitmap m34604b(Uri uri) {
        int i;
        PhotoJsBridgeData.GetPhotoData.PicSize resize = this.f46442f.getResize();
        int i2 = 200;
        if (resize == null) {
            i = 200;
        } else {
            i2 = resize.getWidth();
            i = resize.getHeight();
        }
        return BitmapUtils.getBitmap(getApplicationContext().getContentResolver(), uri, i2, i);
    }
}
