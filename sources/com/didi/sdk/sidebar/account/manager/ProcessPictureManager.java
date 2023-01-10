package com.didi.sdk.sidebar.account.manager;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.commoninterfacelib.permission.IntentUtil;
import com.didi.commoninterfacelib.permission.PermissionUtil;
import com.didi.commoninterfacelib.permission.TheOneBaseFragment;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.util.FileUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.webview.image.CropActivity;
import com.didi.sdk.webview.image.PicUploadActivity;
import com.didi.security.uuid.share.ShareDBHelper;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ProcessPictureManager {
    public static final int REQUEST_CODE_CAMERA_PERMISSION = 1008;
    public static final int REQUEST_CODE_CAPTURE_PIC = 1006;
    public static final int REQUEST_CODE_CROP_PIC = 1007;
    public static final int REQUEST_CODE_PHOTO_PERMISSION = 1009;
    public static final int REQUEST_CODE_SELECT_PIC = 1005;

    /* renamed from: a */
    private static final String f39894a = ".fileprovider";

    /* renamed from: b */
    private File f39895b;

    /* renamed from: c */
    private File f39896c;

    /* renamed from: d */
    private OnFinishPictureCallBack f39897d = null;

    /* renamed from: e */
    private final FragmentActivity f39898e;

    /* renamed from: f */
    private TheOneBaseFragment f39899f;

    public interface OnFinishPictureCallBack {
        void onCropFinish(File file);
    }

    public ProcessPictureManager(FragmentActivity fragmentActivity) {
        this.f39898e = fragmentActivity;
        this.f39895b = m30022a();
    }

    public ProcessPictureManager(TheOneBaseFragment theOneBaseFragment) {
        this.f39899f = theOneBaseFragment;
        this.f39898e = theOneBaseFragment.getActivity();
        this.f39895b = m30022a();
    }

    /* renamed from: a */
    private File m30022a() {
        Context context = this.f39898e;
        if (context == null) {
            context = this.f39899f.getContext();
        }
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        return new File(externalFilesDir, "IMG_" + format + ".jpg");
    }

    public String getCropFile() {
        File file = this.f39896c;
        if (file != null) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public void setCropFile(String str) {
        if (!TextUtil.isEmpty(str)) {
            this.f39896c = new File(str);
        }
    }

    public String getAvatarOriginFile() {
        File file = this.f39895b;
        if (file != null) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public void setAvatarOriginFile(String str) {
        if (!TextUtil.isEmpty(str)) {
            this.f39895b = new File(str);
        }
    }

    public void takePhotoByCamera() {
        Fragment findFragmentById;
        if (this.f39895b != null && (findFragmentById = this.f39898e.getSupportFragmentManager().findFragmentById(R.id.fragment_container)) != null) {
            if (PermissionUtil.checkPermissionAllGranted((Context) DIDIApplication.getAppContext(), new String[]{Permission.CAMERA, Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE})) {
                isAllGranted();
            } else {
                findFragmentById.requestPermissions(new String[]{Permission.CAMERA, Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE}, 1008);
            }
        }
    }

    public void isAllGranted() {
        try {
            Context context = this.f39898e == null ? this.f39899f.getContext() : this.f39898e;
            String absolutePath = this.f39895b.getAbsolutePath();
            m30023a(IntentUtil.getCameraIntent(context, absolutePath, context.getPackageName() + f39894a), 1006);
        } catch (Exception unused) {
        }
    }

    public void allGalleryAccess() {
        Intent intent = new Intent();
        intent.setType(PicUploadActivity.IMAGE_UNSPECIFIED);
        intent.setAction("android.intent.action.GET_CONTENT");
        try {
            m30023a(intent, 1005);
        } catch (Exception unused) {
            ToastHelper.showShortInfo(this.f39898e.getApplicationContext(), "无法打开图片库");
        }
    }

    public void selectPhotoFromGallery() {
        Fragment findFragmentById;
        if (this.f39895b != null && (findFragmentById = this.f39898e.getSupportFragmentManager().findFragmentById(R.id.fragment_container)) != null) {
            if (PermissionUtil.checkPermissionAllGranted((Context) this.f39898e, new String[]{Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE})) {
                allGalleryAccess();
            } else {
                findFragmentById.requestPermissions(new String[]{Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE}, 1009);
            }
        }
    }

    /* renamed from: a */
    private void m30023a(Intent intent, int i) {
        FragmentActivity fragmentActivity = this.f39898e;
        if (fragmentActivity == null) {
            this.f39899f.startActivityForResult(intent, i);
            return;
        }
        Fragment findFragmentById = fragmentActivity.getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (findFragmentById != null) {
            try {
                findFragmentById.startActivityForResult(intent, i);
            } catch (Exception unused) {
            }
        } else {
            this.f39898e.startActivityForResult(intent, i);
        }
    }

    public void processPhotoFromGallery(Intent intent) {
        FragmentActivity fragmentActivity = this.f39898e;
        if (fragmentActivity == null) {
            fragmentActivity = this.f39899f.getActivity();
        }
        if (intent == null) {
            ToastHelper.showShortInfo((Context) fragmentActivity, (int) R.string.sidebar_modify_error);
            return;
        }
        File file = this.f39895b;
        if (file == null) {
            ToastHelper.showShortInfo((Context) fragmentActivity, (int) R.string.sidebar_modify_error);
            return;
        }
        String absolutePath = file.getAbsolutePath();
        if (TextUtil.isEmpty(absolutePath)) {
            ToastHelper.showShortInfo((Context) fragmentActivity, (int) R.string.sidebar_modify_error);
            return;
        }
        Uri data = intent.getData();
        if (data == null) {
            ToastHelper.showShortInfo((Context) fragmentActivity, (int) R.string.sidebar_modify_error);
            return;
        }
        String path = FileUtil.getPath(fragmentActivity, data);
        if (TextUtil.isEmpty(path)) {
            ToastHelper.showShortInfo((Context) fragmentActivity, (int) R.string.sidebar_modify_error);
        } else if (!new File(path).exists()) {
            ToastHelper.showShortInfo((Context) fragmentActivity, (int) R.string.sidebar_modify_error);
        } else {
            FileUtil.copyFile(path, absolutePath);
            m30024a(Uri.fromFile(this.f39895b));
        }
    }

    public void processPhotoFromCamera() {
        FragmentActivity fragmentActivity = this.f39898e;
        if (fragmentActivity == null) {
            fragmentActivity = this.f39899f.getActivity();
        }
        File file = this.f39895b;
        if (file == null) {
            ToastHelper.showShortInfo((Context) fragmentActivity, (int) R.string.sidebar_modify_error);
        } else if (TextUtil.isEmpty(file.getAbsolutePath())) {
            ToastHelper.showShortInfo((Context) fragmentActivity, (int) R.string.sidebar_modify_error);
        } else {
            File file2 = this.f39895b;
            if (file2 != null) {
                m30024a(Uri.fromFile(file2));
            }
        }
    }

    public void processCropPhoto() {
        FragmentActivity fragmentActivity = this.f39898e;
        if (fragmentActivity == null) {
            fragmentActivity = this.f39899f.getActivity();
        }
        File file = this.f39896c;
        if (file == null) {
            ToastHelper.showShortInfo((Context) fragmentActivity, (int) R.string.sidebar_modify_error);
        } else if (TextUtil.isEmpty(file.getAbsolutePath())) {
            ToastHelper.showShortInfo((Context) fragmentActivity, (int) R.string.sidebar_modify_error);
        } else {
            OnFinishPictureCallBack onFinishPictureCallBack = this.f39897d;
            if (onFinishPictureCallBack != null) {
                onFinishPictureCallBack.onCropFinish(this.f39896c);
            }
        }
    }

    /* renamed from: a */
    private void m30024a(Uri uri) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeStream(this.f39898e.getContentResolver().openInputStream(uri), (Rect) null, options);
            if (options.outHeight >= 300 && options.outWidth >= 300) {
                this.f39896c = m30022a();
                Intent intent = new Intent(this.f39898e, CropActivity.class);
                intent.setData(uri);
                intent.putExtra("width", 300);
                intent.putExtra("height", 300);
                intent.putExtra("output", this.f39896c.getAbsolutePath());
                m30023a(intent, 1007);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Uri getImageContentUri(Context context, File file) {
        String absolutePath = file.getAbsolutePath();
        Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{ShareDBHelper.ID_NAME}, "_data=? ", new String[]{absolutePath}, (String) null);
        if (query != null && query.moveToFirst()) {
            int i = query.getInt(query.getColumnIndex(ShareDBHelper.ID_NAME));
            Uri parse = Uri.parse("content://media/external/images/media");
            return Uri.withAppendedPath(parse, "" + i);
        } else if (!file.exists()) {
            return null;
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_data", absolutePath);
            return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        }
    }

    public void deleteFile() {
        File file = this.f39895b;
        if (file != null) {
            FileUtil.deleteFile(file);
        }
        File file2 = this.f39896c;
        if (file2 != null) {
            FileUtil.deleteFile(file2);
        }
    }

    public void setOnFinishPictureCallBack(OnFinishPictureCallBack onFinishPictureCallBack) {
        this.f39897d = onFinishPictureCallBack;
    }
}
