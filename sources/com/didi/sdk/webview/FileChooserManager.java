package com.didi.sdk.webview;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.ValueCallback;
import androidx.core.app.ActivityCompat;
import com.didi.sdk.webview.BaseWebView;
import com.didi.sdk.webview.image.BottomListMenu;
import com.didi.sdk.webview.image.ImageFileConfig;
import com.didi.sdk.webview.image.PicUploadActivity;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.File;

public class FileChooserManager {
    public static final int REQUEST_CODE_CAPTURE_PIC = 1006;
    public static final int REQUEST_CODE_SELECT_PIC = 1005;

    /* renamed from: a */
    private static final int f41093a = -1;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public BaseWebActivity f41094b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View f41095c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public File f41096d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ValueCallback<Uri> f41097e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ValueCallback<Uri[]> f41098f;

    /* renamed from: g */
    private BaseWebView.FileChooserListener f41099g = new BaseWebView.FileChooserListener() {
        public void openFileChooser(ValueCallback<Uri> valueCallback) {
            ValueCallback unused = FileChooserManager.this.f41097e = valueCallback;
            showMenuDialog();
        }

        public void openFileChooserAboveL(ValueCallback<Uri[]> valueCallback) {
            ValueCallback unused = FileChooserManager.this.f41098f = valueCallback;
            showMenuDialog();
        }

        private void showMenuDialog() {
            BottomListMenu bottomListMenu = new BottomListMenu(FileChooserManager.this.f41094b, FileChooserManager.this.f41095c, FileChooserManager.this.f41094b.getResources().getStringArray(R.array.avatar_menu));
            bottomListMenu.setListMenuListener(new BottomListMenu.ListMenuListener() {
                public void onItemSelected(int i, String str) {
                    if (i == 0) {
                        if (ActivityCompat.checkSelfPermission(FileChooserManager.this.f41094b, Permission.CAMERA) == 0 && ActivityCompat.checkSelfPermission(FileChooserManager.this.f41094b, Permission.WRITE_EXTERNAL_STORAGE) == 0) {
                            File unused = FileChooserManager.this.f41096d = ImageFileConfig.getPhotoOutputFile(FileChooserManager.this.f41094b);
                            try {
                                FileChooserManager.this.f41094b.startActivityForResult(ImageFileConfig.getCameraIntent(FileChooserManager.this.f41094b, FileChooserManager.this.f41096d), 1006);
                            } catch (Exception e) {
                                e.printStackTrace();
                                FileChooserManager.this.onActivityResult(1006, -1, (Intent) null);
                            }
                        } else {
                            ActivityCompat.requestPermissions(FileChooserManager.this.f41094b, new String[]{Permission.CAMERA, Permission.WRITE_EXTERNAL_STORAGE}, 1);
                            FileChooserManager.this.onActivityResult(1006, -1, (Intent) null);
                        }
                    } else if (i == 1) {
                        Intent intent = new Intent();
                        intent.setType(PicUploadActivity.IMAGE_UNSPECIFIED);
                        intent.setAction("android.intent.action.GET_CONTENT");
                        try {
                            FileChooserManager.this.f41094b.startActivityForResult(intent, 1005);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            });
            bottomListMenu.setDismissListener(new BottomListMenu.OnDismissListener() {
                public void dismiss() {
                    File unused = FileChooserManager.this.f41096d = null;
                    FileChooserManager.this.onActivityResult(1006, -1, (Intent) null);
                }
            });
            bottomListMenu.showDialog();
        }
    };

    public FileChooserManager(BaseWebActivity baseWebActivity) {
        this.f41094b = baseWebActivity;
        this.f41095c = baseWebActivity.getRootView();
    }

    public void setFileChooserListener(BaseWebView baseWebView) {
        baseWebView.setFileChooserListener(this.f41099g);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1005 && i != 1006) {
            return;
        }
        if (this.f41098f != null) {
            m30815b(i, i2, intent);
        } else {
            m30812a(i, i2, intent);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r6 = r6.getDataString();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m30812a(int r4, int r5, android.content.Intent r6) {
        /*
            r3 = this;
            r0 = -1
            r1 = 0
            r2 = 1005(0x3ed, float:1.408E-42)
            if (r4 != r2) goto L_0x0013
            if (r5 != r0) goto L_0x0013
            java.lang.String r6 = r6.getDataString()
            if (r6 == 0) goto L_0x0013
            android.net.Uri r6 = android.net.Uri.parse(r6)
            goto L_0x0014
        L_0x0013:
            r6 = r1
        L_0x0014:
            r2 = 1006(0x3ee, float:1.41E-42)
            if (r4 != r2) goto L_0x0022
            if (r5 != r0) goto L_0x0022
            java.io.File r4 = r3.f41096d
            if (r4 == 0) goto L_0x0022
            android.net.Uri r6 = android.net.Uri.fromFile(r4)
        L_0x0022:
            android.webkit.ValueCallback<android.net.Uri> r4 = r3.f41097e
            if (r4 == 0) goto L_0x0029
            r4.onReceiveValue(r6)
        L_0x0029:
            r3.f41097e = r1
            r3.f41096d = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.webview.FileChooserManager.m30812a(int, int, android.content.Intent):void");
    }

    /* renamed from: b */
    private void m30815b(int i, int i2, Intent intent) {
        Uri[] uriArr;
        File file;
        if (this.f41098f != null) {
            if (i == 1005 && i2 == -1 && intent != null) {
                String dataString = intent.getDataString();
                ClipData clipData = intent.getClipData();
                if (clipData != null) {
                    uriArr = new Uri[clipData.getItemCount()];
                    for (int i3 = 0; i3 < clipData.getItemCount(); i3++) {
                        uriArr[i3] = clipData.getItemAt(i3).getUri();
                    }
                } else {
                    uriArr = null;
                }
                if (dataString != null) {
                    uriArr = new Uri[]{Uri.parse(dataString)};
                }
            } else {
                uriArr = null;
            }
            if (i == 1006 && i2 == -1 && (file = this.f41096d) != null) {
                uriArr = new Uri[]{Uri.fromFile(file)};
            }
            this.f41098f.onReceiveValue(uriArr);
            this.f41098f = null;
        }
    }
}
