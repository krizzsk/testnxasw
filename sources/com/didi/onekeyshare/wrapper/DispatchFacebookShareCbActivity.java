package com.didi.onekeyshare.wrapper;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.onekeyshare.wrapper.FacebookPlatform;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.share.ErrorCode;
import com.facebook.CallbackManager;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import com.taxis99.R;

public class DispatchFacebookShareCbActivity extends Activity {

    /* renamed from: a */
    CallbackManager f32289a;

    /* renamed from: b */
    ShareDialog f32290b;

    /* renamed from: c */
    private String f32291c;

    /* renamed from: d */
    private String f32292d;

    /* renamed from: e */
    private String f32293e;

    /* renamed from: f */
    private String f32294f;

    /* renamed from: g */
    private String f32295g;

    /* renamed from: h */
    private Bitmap f32296h;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView(R.layout.activity_facebook_share_entry);
        this.f32289a = CallbackManager.Factory.create();
        Intent intent = getIntent();
        if (intent == null) {
            finish();
        }
        this.f32291c = intent.getStringExtra("url");
        this.f32292d = intent.getStringExtra("title");
        this.f32293e = intent.getStringExtra("content");
        this.f32294f = intent.getStringExtra("imgUrl");
        this.f32295g = intent.getStringExtra("imgPath");
        ICallback.IPlatformShareCallback iPlatformShareCallback = FacebookPlatform.sCallback;
        if (!TextUtil.isEmpty(this.f32291c)) {
            ShareLinkContent build = ((ShareLinkContent.Builder) new ShareLinkContent.Builder().setContentUrl(Uri.parse(this.f32291c))).setQuote(this.f32292d + "\n" + this.f32293e).build();
            ShareDialog shareDialog = new ShareDialog((Activity) this);
            this.f32290b = shareDialog;
            if (iPlatformShareCallback != null) {
                shareDialog.registerCallback(this.f32289a, new FacebookPlatform.ShareCallback(iPlatformShareCallback));
            }
            this.f32290b.show((ShareContent<?, ?>) build, ShareDialog.Mode.AUTOMATIC);
        } else {
            SharePhoto.Builder builder = new SharePhoto.Builder();
            Bitmap bitmap = this.f32296h;
            if (bitmap != null) {
                builder.setBitmap(bitmap);
            } else if (!TextUtil.isEmpty(this.f32294f)) {
                builder.setImageUrl(Uri.parse(this.f32294f));
            } else if (!TextUtil.isEmpty(this.f32295g)) {
                builder.setImageUrl(Uri.parse(this.f32295g));
            } else {
                if (iPlatformShareCallback != null) {
                    if (iPlatformShareCallback instanceof ICallback.IPlatformShareCallback2) {
                        ((ICallback.IPlatformShareCallback2) iPlatformShareCallback).onError(SharePlatform.FACEBOOK_PLATFORM, ErrorCode.ERROR_PARAMS);
                    } else if (iPlatformShareCallback instanceof ICallback.IPlatformShareCallback) {
                        iPlatformShareCallback.onError(SharePlatform.FACEBOOK_PLATFORM);
                    }
                }
                finish();
                return;
            }
            SharePhotoContent build2 = new SharePhotoContent.Builder().addPhoto(builder.build()).build();
            ShareDialog shareDialog2 = new ShareDialog((Activity) this);
            this.f32290b = shareDialog2;
            if (iPlatformShareCallback != null) {
                shareDialog2.registerCallback(this.f32289a, new FacebookPlatform.ShareCallback(iPlatformShareCallback));
            }
            this.f32290b.show((ShareContent<?, ?>) build2, ShareDialog.Mode.AUTOMATIC);
        }
        FacebookPlatform.sCallback = null;
        FacebookPlatform.sBitmap = null;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        CallbackManager callbackManager = this.f32289a;
        if (callbackManager != null) {
            callbackManager.onActivityResult(i, i2, intent);
        }
        if (!isFinishing()) {
            finish();
        }
    }
}
