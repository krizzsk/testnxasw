package com.didichuxing.diface.appeal;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didichuxing.dfbasesdk.utils.BusUtils;
import com.didichuxing.diface.act.DFBaseAct;
import com.facebook.internal.AnalyticsEvents;
import com.taxis99.R;
import java.io.File;

public class ViewPhotoAct extends DFBaseAct {

    /* renamed from: a */
    private ImageView f49660a;

    /* renamed from: b */
    private ImageView f49661b;

    /* renamed from: c */
    private ImageView f49662c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f49663d;

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
        return R.layout.act_df_view_photo_layout;
    }

    public static void start(Context context, String str) {
        Intent intent = new Intent(context, ViewPhotoAct.class);
        intent.putExtra(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO, str);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
        this.f49663d = intent.getStringExtra(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO);
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        hideTitleArea();
        ImageView imageView = (ImageView) findViewById(R.id.back_icon);
        this.f49660a = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ViewPhotoAct.this.finish();
            }
        });
        this.f49661b = (ImageView) findViewById(R.id.photo_preview);
        this.f49661b.setImageDrawable(Drawable.createFromPath(new File(getCacheDir(), this.f49663d).getAbsolutePath()));
        ImageView imageView2 = (ImageView) findViewById(R.id.del_photo_icon);
        this.f49662c = imageView2;
        imageView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ViewPhotoAct.this.m37169a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37169a() {
        new AlertDialogFragment.Builder(this).setTitle(getString(R.string.df_del_photo_dialog_title)).setMessage(getString(R.string.df_del_photo_dialog_msg)).setPositiveButton((int) R.string.df_del_photo_dialog_confirm_btn_text, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
                BusUtils.post(new DelPhotoDoneEvent(ViewPhotoAct.this.f49663d));
                ViewPhotoAct.this.finish();
            }
        }).setPositiveButtonDefault().setCancelable(false).setNegativeButton((int) R.string.df_del_photo_dialog_cancel_btn_text, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
            }
        }).create().show(getSupportFragmentManager(), "");
    }
}
