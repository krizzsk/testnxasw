package com.didi.onekeyshare.callback.intercept.impl;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import com.didi.onekeyshare.callback.intercept.IShareDialogIntercept;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.util.DownloadImageUtil;
import com.didi.onekeyshare.view.ProgressDialogUtil;
import com.didi.sdk.webview.image.PicUploadActivity;
import java.io.File;

public class SystemShareDialogInterceptImpl implements IShareDialogIntercept {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ProgressDialogUtil f32227a;

    public boolean intercept(FragmentActivity fragmentActivity, OneKeyShareInfo oneKeyShareInfo) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(oneKeyShareInfo.title)) {
            sb.append(oneKeyShareInfo.title);
            sb.append("\n");
        }
        if (!TextUtils.isEmpty(oneKeyShareInfo.content)) {
            sb.append(oneKeyShareInfo.content);
            sb.append("\n");
        }
        if (!TextUtils.isEmpty(oneKeyShareInfo.url)) {
            sb.append(oneKeyShareInfo.url);
        }
        boolean z = !TextUtils.isEmpty(oneKeyShareInfo.imageUrl) || !TextUtils.isEmpty(oneKeyShareInfo.imagePath);
        boolean z2 = !TextUtils.isEmpty(sb.toString());
        if (z) {
            if (!TextUtils.isEmpty(oneKeyShareInfo.imagePath)) {
                m24494a((Activity) fragmentActivity, oneKeyShareInfo.imagePath);
            } else if (!TextUtils.isEmpty(oneKeyShareInfo.imageUrl)) {
                m24495a(fragmentActivity, oneKeyShareInfo);
            }
        } else if (z2) {
            m24496a(fragmentActivity, sb);
        }
        return true;
    }

    /* renamed from: a */
    private void m24496a(FragmentActivity fragmentActivity, StringBuilder sb) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", sb.toString());
        intent.setType("text/plain");
        if (intent.resolveActivity(fragmentActivity.getPackageManager()) != null) {
            fragmentActivity.startActivity(intent);
        }
    }

    /* renamed from: a */
    private void m24495a(final FragmentActivity fragmentActivity, OneKeyShareInfo oneKeyShareInfo) {
        if (this.f32227a == null) {
            this.f32227a = new ProgressDialogUtil();
        }
        this.f32227a.showDialogLoading(fragmentActivity);
        DownloadImageUtil.downloadImage(fragmentActivity, oneKeyShareInfo.imageUrl, new DownloadImageUtil.DownLoadImageCallback() {
            public void onSuccess(String str, String str2) {
                SystemShareDialogInterceptImpl.this.m24494a((Activity) fragmentActivity, str2);
                SystemShareDialogInterceptImpl.this.f32227a.dismissDialog();
            }

            public void onFail() {
                SystemShareDialogInterceptImpl.this.f32227a.dismissDialog();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24494a(Activity activity, String str) {
        Uri uri;
        if (!TextUtils.isEmpty(str)) {
            if (Build.VERSION.SDK_INT >= 24) {
                uri = FileProvider.getUriForFile(activity, activity.getPackageName() + ".share.provider", new File(str));
            } else {
                uri = Uri.fromFile(new File(str));
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", uri);
            intent.setType(PicUploadActivity.IMAGE_UNSPECIFIED);
            intent.addFlags(1);
            if (intent.resolveActivity(activity.getPackageManager()) != null) {
                activity.startActivity(intent);
            }
        }
    }
}
