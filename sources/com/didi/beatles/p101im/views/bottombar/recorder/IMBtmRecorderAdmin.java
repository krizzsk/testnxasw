package com.didi.beatles.p101im.views.bottombar.recorder;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.common.IMBtsAudioHelper;
import com.didi.beatles.p101im.common.audio.IMRecorderManager;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.views.IMAudioDialog;
import com.didi.beatles.p101im.views.IMTipsToast;
import com.didi.beatles.p101im.views.bottombar.IMBaseBottomBar;
import com.didi.beatles.p101im.views.bottombar.IMBottomSkinManager;
import com.didi.beatles.p101im.views.bottombar.IMConversationBottomBar;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderAdmin */
public class IMBtmRecorderAdmin implements IMBtmRecorder {

    /* renamed from: b */
    private static final int f11897b = 0;

    /* renamed from: c */
    private static final int f11898c = 1;

    /* renamed from: a */
    private final String f11899a = "IMBtmRecorderAdmin";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public IMConversationBottomBar f11900d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextView f11901e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View f11902f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public IMBottomSkinManager f11903g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public IMBaseBottomBar.BottomBarListener f11904h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f11905i = 1;

    /* renamed from: j */
    private String f11906j = null;

    /* renamed from: k */
    private IMRecorderManager.Callback f11907k = null;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public IMAudioDialog f11908l;

    /* renamed from: m */
    private View.OnTouchListener f11909m = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                IMBtmRecorderAdmin.this.f11901e.setText(IMResource.getString(R.string.bts_im_record_bt_tip));
                IMBtmRecorderAdmin.this.f11901e.setTextColor(IMResource.getColor(R.color.im_color_333));
                IMBtmRecorderAdmin.this.f11901e.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_bottom_bar_voice_text_bg_recording));
                IMBtmRecorderAdmin.this.f11902f.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_bottom_bar_background_voice));
                IMBtmRecorderAdmin.this.f11903g.showDisableSkin();
                IMBtmRecorderAdmin.this.m10234a();
            } else if (action == 1) {
                IMBtmRecorderAdmin.this.f11900d.resumeInitStatus();
                if (motionEvent.getY() < 0.0f) {
                    IMBtmRecorderAdmin.this.m10242c();
                } else {
                    IMBtmRecorderAdmin.this.m10240b();
                }
            } else if (action != 2) {
                if (action == 3) {
                    IMLog.m10020d("hkc", "cancel");
                    IMBtmRecorderAdmin.this.f11900d.resumeInitStatus();
                    IMBtmRecorderAdmin.this.m10242c();
                }
            } else if (motionEvent.getY() < 0.0f) {
                IMBtmRecorderAdmin.this.f11901e.setText(IMResource.getString(R.string.bts_im_record_cancle_tip));
                IMBtmRecorderAdmin.this.f11901e.setTextColor(IMResource.getColor(R.color.white));
                IMBtmRecorderAdmin.this.f11901e.setBackgroundResource(0);
                IMBtmRecorderAdmin.this.f11902f.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_bottom_bar_background_red));
                IMBtmRecorderAdmin.this.f11903g.showCancelSkin();
                IMBtmRecorderAdmin.this.m10243d();
            } else {
                IMBtmRecorderAdmin.this.f11901e.setText(IMResource.getString(R.string.bts_im_record_bt_tip));
                IMBtmRecorderAdmin.this.f11901e.setTextColor(IMResource.getColor(R.color.im_color_333));
                IMBtmRecorderAdmin.this.f11901e.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_bottom_bar_voice_text_bg_recording));
                IMBtmRecorderAdmin.this.f11902f.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_bottom_bar_background_voice));
                IMBtmRecorderAdmin.this.f11903g.showDisableSkin();
                IMBtmRecorderAdmin.this.m10245e();
            }
            return false;
        }
    };

    public boolean interceptBackPressed() {
        return false;
    }

    public void bindListener(TextView textView, IMBaseBottomBar iMBaseBottomBar) {
        this.f11901e = textView;
        IMConversationBottomBar iMConversationBottomBar = (IMConversationBottomBar) iMBaseBottomBar;
        this.f11900d = iMConversationBottomBar;
        this.f11902f = iMConversationBottomBar.mContentRootView;
        this.f11903g = iMConversationBottomBar.mSkinManager;
        this.f11904h = iMConversationBottomBar.mListener;
        this.f11908l = new IMAudioDialog((Activity) iMBaseBottomBar.context);
        textView.setOnTouchListener(this.f11909m);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10234a() {
        IMLog.m10020d("IMBtmRecorderAdmin", this.f11905i + "");
        if (this.f11905i == 1) {
            this.f11905i = 0;
            IMBtsAudioHelper.stopPlaying();
            m10247f();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10240b() {
        IMLog.m10020d("IMBtmRecorderAdmin", this.f11905i + "");
        if (this.f11905i == 0) {
            this.f11905i = 1;
            IMRecorderManager.getInstance().stop(this.f11906j, this.f11907k);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m10242c() {
        if (this.f11905i == 0) {
            this.f11905i = 1;
            IMRecorderManager.getInstance().cancel(this.f11906j, this.f11907k);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m10243d() {
        this.f11908l.setTip(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m10245e() {
        this.f11908l.setTip(false);
    }

    /* renamed from: f */
    private void m10247f() {
        this.f11906j = IMRecorderManager.createFileId();
        this.f11907k = new IMRecorderManager.Callback() {
            public void onError(int i, String str) {
                if (i == 1) {
                    IMBtmRecorderAdmin.this.m10236a((int) R.drawable.im_toast_warm, str);
                    if (IMBtmRecorderAdmin.this.f11900d != null) {
                        IMLog.m10020d("hkc", "onError, resumeBar");
                        IMBtmRecorderAdmin.this.f11900d.resumeInitStatus();
                    }
                } else if (i == 2) {
                    IMBtmRecorderAdmin.this.m10235a((int) R.drawable.im_toast_warm, (int) R.string.bts_im_audio_recorded_so_short);
                } else if (i != 3) {
                    IMLog.m10026w(C4786I.m9980t("startAudioRecorder errNo ", Integer.valueOf(i), " errMsg ", str), new Object[0]);
                } else {
                    IMBtmRecorderAdmin.this.m10235a((int) R.drawable.im_toast_warm, (int) R.string.bts_im_record_error);
                }
            }

            public void onSuccess(String str, long j) {
                if (IMBtmRecorderAdmin.this.f11904h != null) {
                    IMBtmRecorderAdmin.this.f11904h.sendVoiceMessage(str, j);
                }
            }

            public void onStartRecord() {
                IMBtmRecorderAdmin.this.f11908l.show();
                IMBtmRecorderAdmin.this.f11908l.setTip(false);
            }

            public void onSoundLevelChange(int i) {
                if (IMBtmRecorderAdmin.this.f11905i == 0 && IMBtmRecorderAdmin.this.f11908l != null && IMBtmRecorderAdmin.this.f11908l.isShowing()) {
                    IMBtmRecorderAdmin.this.f11908l.changeBackGroundBySound(i);
                }
            }

            public void onResidueTimeChange(String str) {
                IMAudioDialog k = IMBtmRecorderAdmin.this.f11908l;
                k.showResidueTime(str + "");
            }

            public void onEndRecord() {
                if (IMBtmRecorderAdmin.this.f11908l != null) {
                    IMLog.m10020d("IMBtmRecorderAdmin", "dismiss");
                    IMBtmRecorderAdmin.this.f11908l.dissMissAudioDialog();
                }
            }
        };
        IMRecorderManager.getInstance().recorder(this.f11906j, this.f11907k);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10235a(int i, int i2) {
        m10236a(i, IMResource.getString(i2));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10236a(int i, String str) {
        Toast makeText = IMTipsToast.makeText(IMContextInfoHelper.getContext(), (CharSequence) str, 0);
        SystemUtils.showToast(makeText);
        IMTipsToast.setIcon(makeText, i);
        IMTipsToast.setText(makeText, str);
    }
}
