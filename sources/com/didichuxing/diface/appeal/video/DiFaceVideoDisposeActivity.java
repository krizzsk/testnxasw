package com.didichuxing.diface.appeal.video;

import android.graphics.Color;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.diface.core.DiFaceVideoManager;
import com.didichuxing.diface.core.MVP.DiFaceBaseActivity;
import com.taxis99.R;
import java.io.File;

public class DiFaceVideoDisposeActivity extends DiFaceBaseActivity {

    /* renamed from: a */
    private RelativeLayout f49772a;

    /* renamed from: b */
    private ImageView f49773b;

    /* renamed from: c */
    private ImageView f49774c;

    /* renamed from: d */
    private SurfaceView f49775d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public DiFaceVideoManager f49776e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SurfaceHolder f49777f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f49778g;

    /* access modifiers changed from: protected */
    public boolean fullScreen() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_diface_video_dispose_layout);
        this.f49772a = (RelativeLayout) findViewById(R.id.tb);
        this.f49773b = (ImageView) findViewById(R.id.iv_left);
        this.f49774c = (ImageView) findViewById(R.id.iv_right);
        this.f49775d = (SurfaceView) findViewById(R.id.sv);
        m37263a();
        m37265b();
    }

    /* renamed from: a */
    private void m37263a() {
        this.f49778g = getIntent().getStringExtra("videoPath");
        this.f49775d.getHolder().addCallback(new SurfaceHolder.Callback() {
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            }

            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                SurfaceHolder unused = DiFaceVideoDisposeActivity.this.f49777f = surfaceHolder;
                DiFaceVideoDisposeActivity.this.f49776e.startPlay(DiFaceVideoDisposeActivity.this.f49778g, surfaceHolder);
            }
        });
        this.f49772a.setBackgroundColor(Color.parseColor("#55000000"));
        this.f49774c.setImageResource(R.drawable.ic_trash_can);
        this.f49773b.setImageResource(R.drawable.ic_back_arrow_white);
        this.f49773b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiFaceVideoDisposeActivity.this.finishWithResult(new DiFaceResult(102));
            }
        });
        this.f49774c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiFaceVideoDisposeActivity.this.m37266c();
            }
        });
    }

    /* renamed from: b */
    private void m37265b() {
        this.f49776e = new DiFaceVideoManager();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f49776e.stopPlay();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m37266c() {
        this.f49776e.stopPlay();
        new AlertDialogFragment.Builder(this).setTitle(getString(R.string.df_appeal_delete_video_dialog_title)).setCancelable(false).setPositiveButton((int) R.string.df_delete_text, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
                new File(DiFaceVideoDisposeActivity.this.f49778g).delete();
                DiFaceVideoDisposeActivity.this.finishWithResult(new DiFaceResult(1005));
            }
        }).setPositiveButtonDefault().setNegativeButton((int) R.string.df_dialog_negative_btn_text, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
                DiFaceVideoDisposeActivity.this.f49776e.startPlay(DiFaceVideoDisposeActivity.this.f49778g, DiFaceVideoDisposeActivity.this.f49777f);
            }
        }).create().show(getSupportFragmentManager(), "");
    }
}
