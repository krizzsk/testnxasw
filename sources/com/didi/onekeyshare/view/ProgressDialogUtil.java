package com.didi.onekeyshare.view;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;

public class ProgressDialogUtil {

    /* renamed from: a */
    private DownloadProgressDialogFragment f32239a;

    public void showDialogLoading(Context context) {
        showDialogLoading(context, (String) null);
    }

    public void showDialogLoading(Context context, String str) {
        if (this.f32239a != null) {
            dismissDialog();
        }
        if (context instanceof FragmentActivity) {
            DownloadProgressDialogFragment downloadProgressDialogFragment = new DownloadProgressDialogFragment();
            this.f32239a = downloadProgressDialogFragment;
            downloadProgressDialogFragment.setContent(str);
            this.f32239a.setCancelable(false);
            this.f32239a.show(((FragmentActivity) context).getSupportFragmentManager(), "loading");
        }
    }

    public void dismissDialog() {
        DownloadProgressDialogFragment downloadProgressDialogFragment = this.f32239a;
        if (downloadProgressDialogFragment != null) {
            downloadProgressDialogFragment.dismiss();
            this.f32239a = null;
        }
    }
}
