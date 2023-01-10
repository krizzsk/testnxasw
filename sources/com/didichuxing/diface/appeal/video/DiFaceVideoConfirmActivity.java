package com.didichuxing.diface.appeal.video;

import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.dfbasesdk.utils.StringUtils;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.core.DiFaceVideoManager;
import com.didichuxing.diface.core.MVP.DiFaceBaseActivity;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.taxis99.R;
import java.io.File;
import java.util.Arrays;

public class DiFaceVideoConfirmActivity extends DiFaceBaseActivity {

    /* renamed from: a */
    private SurfaceView f49766a;

    /* renamed from: b */
    private TextView f49767b;

    /* renamed from: c */
    private ImageView f49768c;

    /* renamed from: d */
    private ImageView f49769d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public DiFaceVideoManager f49770e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f49771f;

    /* access modifiers changed from: protected */
    public boolean fullScreen() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_diface_video_confirm_layout);
        this.f49771f = getIntent().getStringExtra("videoPath");
        this.f49766a = (SurfaceView) findViewById(R.id.sv);
        this.f49767b = (TextView) findViewById(R.id.tv_confirm_hint);
        this.f49768c = (ImageView) findViewById(R.id.iv_back);
        this.f49769d = (ImageView) findViewById(R.id.iv_confirm);
        m37258a();
        m37260b();
    }

    /* renamed from: a */
    private void m37258a() {
        this.f49766a.getHolder().addCallback(new SurfaceHolder.Callback() {
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            }

            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                DiFaceVideoConfirmActivity.this.f49770e.startPlay(DiFaceVideoConfirmActivity.this.f49771f, surfaceHolder);
            }
        });
        this.f49768c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_CONFIRM_VIDEO_NO);
                DiFaceVideoConfirmActivity.this.f49770e.stopPlay();
                new File(DiFaceVideoConfirmActivity.this.f49771f).delete();
                DiFaceVideoConfirmActivity.this.finishWithResult(new DiFaceResult(102));
            }
        });
        this.f49769d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_CONFIRM_VIDEO_YES);
                DiFaceVideoConfirmActivity.this.finishWithResult(new DiFaceResult(1004));
            }
        });
        this.f49767b.setText(StringUtils.makeSpannableString(getString(R.string.appeal_video_confirm_hint), Arrays.asList(getResources().getStringArray(R.array.df_appeal_id_card_highlights)), "#FC9153"));
    }

    /* renamed from: b */
    private void m37260b() {
        this.f49770e = new DiFaceVideoManager();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f49770e.stopPlay();
    }

    public void onBackPressed() {
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_CONFIRM_VIDEO_NO);
        this.f49770e.stopPlay();
        new File(this.f49771f).delete();
        super.onBackPressed();
    }
}
