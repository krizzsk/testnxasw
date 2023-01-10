package com.didi.dimina.container.secondparty.jsmodule.jsbridge.photo;

import android.app.Activity;
import android.graphics.Color;
import com.didi.dimina.container.DMMina;

public class PhotoService {

    /* renamed from: a */
    private static SingleCallback<Base64Result> f19129a;

    /* renamed from: b */
    private static SingleCallback<ChooseImageResp> f19130b;

    public enum CaptureType {
        NORMAL,
        HOLD_CARD,
        CARD
    }

    public static void takePhoto2Base64(Config config, SingleCallback<Base64Result> singleCallback) {
        f19129a = singleCallback;
        JumpPhotoActivity.jumpSystemPhoto(config);
    }

    public static void chooseImage(ChooseImageReq chooseImageReq, SingleCallback<ChooseImageResp> singleCallback) {
        JumpPhotoActivity.startByChooseImage(chooseImageReq);
        f19130b = singleCallback;
    }

    /* renamed from: a */
    static void m16237a(int i, String str, String str2, String str3) {
        if (f19129a != null) {
            Base64Result base64Result = new Base64Result();
            base64Result.code = i;
            base64Result.bitmap = str;
            base64Result.permission = str3;
            base64Result.filePath = str2;
            f19129a.onCallback(base64Result);
            f19129a = null;
        }
        m16238a(i, str2);
    }

    /* renamed from: a */
    static void m16238a(int i, String... strArr) {
        if (f19130b != null) {
            f19130b.onCallback(ChooseImageResp.buildOne(i, strArr));
            f19130b = null;
        }
    }

    static class Base64Result {
        public static final int RESULT_CODE_CANCEL = 1002;
        public static final int RESULT_CODE_PERMISSION = 1001;
        public static final int RESULT_CODE_SUCC = 1000;
        public String bitmap;
        public int code;
        public String filePath;
        public String permission;

        Base64Result() {
        }
    }

    static class Config {
        public Activity activity;
        public int cameraDirection = 1;
        public CaptureType captureType = CaptureType.NORMAL;
        public DMMina mina;
        public int photoMaxSideLength = 650;
        public long photoMaxSize = 512000;
        public int themeColor = Color.parseColor("#2E2E3A");

        public Config(Activity activity2) {
            this.activity = activity2;
        }
    }
}
