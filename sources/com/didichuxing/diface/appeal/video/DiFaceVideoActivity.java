package com.didichuxing.diface.appeal.video;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.dfbasesdk.camera.DiFaceCameraManager;
import com.didichuxing.dfbasesdk.utils.StringUtils;
import com.didichuxing.diface.DiFace;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.core.DiFaceVideoManager;
import com.didichuxing.diface.core.MVP.DiFaceBaseActivity;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.diface.utils.DisplayUtils;
import com.didichuxing.diface.utils.ToastUtil;
import com.taxis99.R;
import java.util.Arrays;
import java.util.HashMap;

public class DiFaceVideoActivity extends DiFaceBaseActivity {

    /* renamed from: m */
    private static final int f49750m = 15;

    /* renamed from: n */
    private static final int f49751n = 640;

    /* renamed from: o */
    private static final int f49752o = 480;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public RelativeLayout f49753a;

    /* renamed from: b */
    private ImageView f49754b;

    /* renamed from: c */
    private ImageView f49755c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public RelativeLayout f49756d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextView f49757e;

    /* renamed from: f */
    private SurfaceView f49758f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SurfaceHolder f49759g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ImageView f49760h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public TextView f49761i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ImageView f49762j;

    /* renamed from: k */
    private DiFaceVideoManager f49763k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public DiFaceCameraManager f49764l;

    /* renamed from: p */
    private String f49765p;

    /* access modifiers changed from: protected */
    public boolean fullScreen() {
        return true;
    }

    public void onBackPressed() {
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_VIDEO_TAKE_EXIT, DiFaceLogger.getExitType("1"), (HashMap<String, Object>) null);
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_diface_video_layout);
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_ENTER_VIDEO_TAKE);
        this.f49753a = (RelativeLayout) findViewById(R.id.tb);
        this.f49754b = (ImageView) findViewById(R.id.iv_left);
        this.f49755c = (ImageView) findViewById(R.id.iv_right);
        this.f49756d = (RelativeLayout) findViewById(R.id.rl_timer_container);
        this.f49757e = (TextView) findViewById(R.id.tv_timer);
        this.f49758f = (SurfaceView) findViewById(R.id.sv);
        this.f49760h = (ImageView) findViewById(R.id.iv_exclamation);
        this.f49761i = (TextView) findViewById(R.id.tv_take_hint);
        this.f49762j = (ImageView) findViewById(R.id.iv_take_video);
        m37242a();
        m37244b();
        m37245c();
    }

    /* renamed from: a */
    private void m37242a() {
        this.f49753a.setBackgroundColor(Color.parseColor("#55000000"));
        this.f49755c.setImageResource(R.drawable.ic_switch_camera);
        this.f49754b.setImageResource(R.drawable.ic_back_arrow_white);
        this.f49754b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_VIDEO_TAKE_EXIT, DiFaceLogger.getExitType("2"), (HashMap<String, Object>) null);
                DiFaceVideoActivity.this.finishWithResult(new DiFaceResult(102));
            }
        });
        this.f49755c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiFaceVideoActivity.this.f49764l.switchCamera(DiFaceVideoActivity.this.f49759g);
            }
        });
        this.f49758f.getHolder().addCallback(new SurfaceHolder.Callback() {
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            }

            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                SurfaceHolder unused = DiFaceVideoActivity.this.f49759g = surfaceHolder;
                DiFaceVideoActivity.this.f49764l.startPreview(surfaceHolder);
            }
        });
        this.f49758f.getHolder().setType(3);
        this.f49762j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiFaceVideoActivity.this.m37248d();
            }
        });
    }

    /* renamed from: b */
    private void m37244b() {
        this.f49764l = new DiFaceCameraManager(DisplayUtils.getWindowRotation(getWindow()), DisplayUtils.isPortrait(this), DisplayUtils.getScreenWidth(this), DisplayUtils.getScreenHeight(this));
    }

    /* renamed from: c */
    private void m37245c() {
        DiFaceVideoManager diFaceVideoManager = new DiFaceVideoManager();
        this.f49763k = diFaceVideoManager;
        diFaceVideoManager.initRecordParam(640, 480);
        this.f49765p = getIntent().getStringExtra("videoPath");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m37248d() {
        if (this.f49763k.isStartRecord()) {
            DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_STOP_VIDEO_TAKE);
            this.f49763k.stopRecord();
            m37249e();
            return;
        }
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_START_VIDEO_TAKE);
        this.f49763k.record(this.f49764l.getCamera(), this.f49764l.getMediaPlayerRotation(), this.f49759g.getSurface(), this.f49765p, 15, new DiFaceVideoManager.ITimerCallback() {
            public void onTick(int i) {
                if (i != 0) {
                    DiFaceVideoActivity.this.f49757e.setText(DiFaceVideoActivity.this.getString(R.string.df_appeal_video_record_remaining_time, new Object[]{Integer.valueOf(i)}));
                    return;
                }
                DiFaceVideoActivity.this.m37249e();
            }
        });
        m37252f();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m37249e() {
        this.f49762j.postDelayed(new Runnable() {
            public void run() {
                DiFaceVideoActivity.this.f49762j.setBackgroundResource(R.drawable.ic_take_video_start);
                DiFaceVideoActivity.this.f49756d.setVisibility(8);
                DiFaceVideoActivity.this.f49753a.setVisibility(0);
                DiFaceVideoActivity.this.f49761i.setText(DiFaceVideoActivity.this.getString(R.string.take_view_hint));
                DiFaceVideoActivity.this.f49760h.setVisibility(8);
            }
        }, 500);
        Intent intent = new Intent(this, DiFaceVideoConfirmActivity.class);
        intent.putExtra("videoPath", this.f49765p);
        startActivityForResult(intent, 1);
    }

    /* renamed from: f */
    private void m37252f() {
        this.f49762j.setBackgroundResource(R.drawable.ic_take_video_stop);
        this.f49756d.setVisibility(0);
        this.f49753a.setVisibility(8);
        this.f49757e.setText(getString(R.string.df_appeal_video_record_remaining_time, new Object[]{15}));
        this.f49761i.setText(StringUtils.makeSpannableString(getString(R.string.appeal_take_video_hint), Arrays.asList(getResources().getStringArray(R.array.df_appeal_id_card_highlights)), "#FC9153"));
        this.f49760h.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f49764l.openCamera();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f49764l.closeCamera();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1 || i2 != -1) {
            return;
        }
        if (((DiFaceResult) intent.getSerializableExtra(DiFace.DIFACE_RESULT_KEY)).getCode() == 102) {
            ToastUtil.showToastInfo((Context) this, (int) R.string.df_appeal_re_photo_video);
            return;
        }
        new HashMap();
        finishWithResult(new DiFaceResult(1004));
    }
}
