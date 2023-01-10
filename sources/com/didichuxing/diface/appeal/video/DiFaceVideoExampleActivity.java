package com.didichuxing.diface.appeal.video;

import android.graphics.Color;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.core.DiFaceVideoManager;
import com.didichuxing.diface.core.MVP.DiFaceBaseActivity;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.taxis99.R;

public class DiFaceVideoExampleActivity extends DiFaceBaseActivity {

    /* renamed from: a */
    private RelativeLayout f49779a;

    /* renamed from: b */
    private ImageView f49780b;

    /* renamed from: c */
    private TextView f49781c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ProgressBar f49782d;

    /* renamed from: e */
    private SurfaceView f49783e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SurfaceHolder f49784f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ImageView f49785g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ImageView f49786h;

    /* renamed from: i */
    private DiFaceVideoManager f49787i;

    /* renamed from: j */
    private String f49788j;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_diface_video_example_layout);
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_ENTER_VIDEO_DEMO_CHECK);
        this.f49779a = (RelativeLayout) findViewById(R.id.tb);
        this.f49780b = (ImageView) findViewById(R.id.iv_left);
        this.f49781c = (TextView) findViewById(R.id.tv_title);
        this.f49782d = (ProgressBar) findViewById(R.id.pb);
        this.f49783e = (SurfaceView) findViewById(R.id.sv);
        this.f49785g = (ImageView) findViewById(R.id.iv_replay);
        this.f49786h = (ImageView) findViewById(R.id.iv_to_take_video);
        m37270a();
        m37273b();
    }

    /* renamed from: a */
    private void m37270a() {
        this.f49779a.setBackgroundColor(Color.parseColor("#55000000"));
        this.f49780b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiFaceVideoExampleActivity.this.finishWithResult(new DiFaceResult(102));
            }
        });
        this.f49781c.setText(getString(R.string.video_example_title));
        this.f49783e.getHolder().addCallback(new SurfaceHolder.Callback() {
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            }

            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                SurfaceHolder unused = DiFaceVideoExampleActivity.this.f49784f = surfaceHolder;
                DiFaceVideoExampleActivity.this.m37275c();
            }
        });
        this.f49785g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiFaceVideoExampleActivity.this.m37275c();
            }
        });
        this.f49786h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiFaceVideoExampleActivity.this.finishWithResult(new DiFaceResult(1003));
            }
        });
    }

    /* renamed from: b */
    private void m37273b() {
        this.f49787i = new DiFaceVideoManager();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m37275c() {
        showProgress();
        this.f49785g.setVisibility(8);
        this.f49786h.setVisibility(8);
        this.f49787i.startPlay(this.f49788j, this.f49784f, false, new DiFaceVideoManager.IVideoProgressListener() {
            public void onStart(int i) {
                LogUtils.m37051d("on Max: " + i);
                DiFaceVideoExampleActivity.this.f49782d.setMax(i);
                DiFaceVideoExampleActivity.this.hideProgress();
            }

            public void onProgress(int i) {
                LogUtils.m37051d("on Progress: " + i);
                DiFaceVideoExampleActivity.this.f49782d.setProgress(i);
            }

            public void onCompletion() {
                LogUtils.m37051d("on Completion");
                DiFaceVideoExampleActivity.this.f49782d.setProgress(0);
                DiFaceVideoExampleActivity.this.f49785g.setVisibility(0);
                DiFaceVideoExampleActivity.this.f49786h.setVisibility(0);
            }

            public void onStop() {
                DiFaceVideoExampleActivity.this.setProgress(0);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f49787i.stopPlay();
    }
}
