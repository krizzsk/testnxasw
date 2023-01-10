package com.didi.safety.god2020.task;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import com.didi.safety.god.http.Card;
import com.didi.safety.god.http.SafetyHttp;
import com.didi.safety.god.http.SafetyTraceEventHandler;
import com.didi.safety.god.http.UploadResp2;
import com.didi.safety.god.manager.GodManager;
import com.didi.safety.god.p145ui.DetectBadFrameFragment;
import com.didi.safety.god.p145ui.GLSurfaceRecorder;
import com.didi.safety.god.p145ui.ImageDetector;
import com.didi.safety.god.p145ui.UploadFailedFragment;
import com.didi.safety.god.util.FileUtils;
import com.didi.safety.god.util.LogUtils;
import com.didi.safety.god2020.network.GodApi;
import com.didi.safety.god2020.p146ui.DetectTimeOutFragment;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.view.dialog.ProgressDialogFragment;
import com.didichuxing.dfbasesdk.utils.GsonUtils;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.taxis99.R;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class IDDetectionTask extends DetectionTask {

    /* renamed from: a */
    private String f37661a;

    /* renamed from: b */
    private int f37662b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f37663c;

    /* renamed from: d */
    private boolean f37664d;

    /* renamed from: e */
    private boolean f37665e;

    /* renamed from: f */
    private int f37666f;

    /* renamed from: c */
    static /* synthetic */ int m28368c(IDDetectionTask iDDetectionTask) {
        int i = iDDetectionTask.f37666f;
        iDDetectionTask.f37666f = i + 1;
        return i;
    }

    public IDDetectionTask(FragmentActivity fragmentActivity, View view, View view2, GLSurfaceRecorder gLSurfaceRecorder, Card card) {
        super(fragmentActivity, view, view2, gLSurfaceRecorder, card);
    }

    /* renamed from: a */
    private void m28358a(final String str, String str2) {
        DetectTimeOutFragment newInstance = DetectTimeOutFragment.newInstance(str, str2);
        newInstance.setRunnable(new Runnable() {
            public void run() {
                IDDetectionTask.this.m28361b(1, str);
            }
        });
        FragmentTransaction beginTransaction = this.activity.getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.detection_fragment_container, newInstance);
        beginTransaction.addToBackStack((String) null);
        beginTransaction.commitAllowingStateLoss();
    }

    /* renamed from: b */
    private void m28366b(final String str, String str2) {
        DetectBadFrameFragment newInstance = DetectBadFrameFragment.newInstance(str, str2);
        newInstance.setRunnable(new Runnable() {
            public void run() {
                IDDetectionTask.this.m28361b(1, str);
            }
        });
        FragmentTransaction beginTransaction = this.activity.getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.detection_fragment_container, newInstance);
        beginTransaction.addToBackStack((String) null);
        beginTransaction.commitAllowingStateLoss();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0067, code lost:
        if (r0 != null) goto L_0x006f;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m28347a(com.didi.safety.god.p145ui.GLSurfaceRecorder.PicInfo r17, com.didi.safety.god.p145ui.GLSurfaceRecorder.VideoInfo r18, org.json.JSONObject r19) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            r3 = r19
            r16.moveToUploadStep()
            java.lang.String r0 = "code"
            int r4 = r3.optInt(r0)
            androidx.fragment.app.FragmentActivity r0 = r1.activity
            android.view.LayoutInflater r0 = r0.getLayoutInflater()
            r5 = 2131626265(0x7f0e0919, float:1.8879761E38)
            r6 = 0
            android.view.View r5 = r0.inflate(r5, r6)
            r0 = 2131427698(0x7f0b0172, float:1.847702E38)
            android.view.View r0 = r5.findViewById(r0)
            r0.setOnClickListener(r1)
            r0 = 2131428108(0x7f0b030c, float:1.8477851E38)
            android.view.View r0 = r5.findViewById(r0)
            r7 = r0
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            r0 = 2131431560(0x7f0b1088, float:1.8484853E38)
            android.view.View r0 = r5.findViewById(r0)
            r8 = r0
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r0 = 2131428099(0x7f0b0303, float:1.8477833E38)
            android.view.View r0 = r5.findViewById(r0)
            r9 = r0
            android.widget.TextView r9 = (android.widget.TextView) r9
            java.io.File r0 = r2.path
            java.lang.String r10 = r0.getAbsolutePath()
            android.graphics.Bitmap r11 = android.graphics.BitmapFactory.decodeFile(r10)
            boolean r0 = r17.isXYValid()
            if (r0 == 0) goto L_0x006e
            int r0 = r2.f37517x1     // Catch:{ Exception -> 0x006a }
            int r12 = r2.f37519y1     // Catch:{ Exception -> 0x006a }
            int r13 = r2.f37518x2     // Catch:{ Exception -> 0x006a }
            int r14 = r2.f37517x1     // Catch:{ Exception -> 0x006a }
            int r13 = r13 - r14
            int r14 = r2.f37520y2     // Catch:{ Exception -> 0x006a }
            int r15 = r2.f37519y1     // Catch:{ Exception -> 0x006a }
            int r14 = r14 - r15
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r11, r0, r12, r13, r14)     // Catch:{ Exception -> 0x006a }
            if (r0 == 0) goto L_0x006e
            goto L_0x006f
        L_0x006a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x006e:
            r0 = r11
        L_0x006f:
            r7.setImageBitmap(r0)
            if (r11 == r0) goto L_0x0077
            r11.recycle()
        L_0x0077:
            android.view.ViewParent r7 = r8.getParent()
            android.view.View r7 = (android.view.View) r7
            com.didi.safety.god2020.task.IDDetectionTask$3 r8 = new com.didi.safety.god2020.task.IDDetectionTask$3
            r8.<init>(r10, r0)
            r7.setOnClickListener(r8)
            r0 = 2131428100(0x7f0b0304, float:1.8477835E38)
            android.view.View r0 = r5.findViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            r7 = 2131428098(0x7f0b0302, float:1.847783E38)
            android.view.View r7 = r5.findViewById(r7)
            android.widget.Button r7 = (android.widget.Button) r7
            java.lang.String r8 = "result"
            java.lang.String r3 = r3.optString(r8)
            java.lang.Class<com.didi.safety.god.http.UploadResp2> r8 = com.didi.safety.god.http.UploadResp2.class
            java.lang.Object r3 = com.didichuxing.dfbasesdk.utils.GsonUtils.fromJson((java.lang.String) r3, r8)
            com.didi.safety.god.http.UploadResp2 r3 = (com.didi.safety.god.http.UploadResp2) r3
            r8 = 100000(0x186a0, float:1.4013E-40)
            java.lang.String r10 = "upload resp data.result is null!!!"
            r12 = 2131433677(0x7f0b18cd, float:1.8489146E38)
            r13 = 2131433670(0x7f0b18c6, float:1.8489132E38)
            r14 = 2131433683(0x7f0b18d3, float:1.8489159E38)
            r15 = 2131433681(0x7f0b18d1, float:1.8489155E38)
            r6 = 0
            r11 = 8
            if (r4 != r8) goto L_0x00f9
            if (r3 != 0) goto L_0x00c2
            com.didi.safety.god.util.LogUtils.m28309e(r10)
            return
        L_0x00c2:
            r5.setVisibility(r6)
            com.didi.safety.god.http.Card r3 = r1.card
            java.lang.String r3 = r3.confirmUploadPageTitle
            r9.setText(r3)
            android.view.View r3 = r5.findViewById(r15)
            r3.setVisibility(r6)
            android.view.View r3 = r5.findViewById(r14)
            r3.setVisibility(r11)
            android.view.View r3 = r5.findViewById(r13)
            r3.setVisibility(r11)
            android.view.View r3 = r5.findViewById(r12)
            r3.setVisibility(r11)
            r3 = 2131433594(0x7f0b187a, float:1.8488978E38)
            android.view.View r3 = r5.findViewById(r3)
            com.didi.safety.god2020.task.IDDetectionTask$4 r4 = new com.didi.safety.god2020.task.IDDetectionTask$4
            r4.<init>()
            r3.setOnClickListener(r4)
            goto L_0x01f3
        L_0x00f9:
            r8 = 100004(0x186a4, float:1.40135E-40)
            if (r4 != r8) goto L_0x015a
            if (r3 != 0) goto L_0x0104
            com.didi.safety.god.util.LogUtils.m28309e(r10)
            return
        L_0x0104:
            r5.setVisibility(r6)
            r16.moveToOcrFailedStep()
            java.lang.String r4 = r3.content
            java.lang.String r3 = r3.title
            android.view.View r8 = r5.findViewById(r15)
            r8.setVisibility(r11)
            android.view.View r8 = r5.findViewById(r14)
            r8.setVisibility(r6)
            android.view.View r6 = r5.findViewById(r13)
            r6.setVisibility(r11)
            android.view.View r6 = r5.findViewById(r12)
            r6.setVisibility(r11)
            int r6 = r1.f37662b
            int r6 = r6 + 1
            r1.f37662b = r6
            r9.setText(r3)
            r3 = 2131433684(0x7f0b18d4, float:1.848916E38)
            android.view.View r3 = r5.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            boolean r6 = com.didi.sdk.util.TextUtil.isEmpty(r4)
            if (r6 != 0) goto L_0x0149
            android.text.Spanned r4 = android.text.Html.fromHtml(r4)
            r3.setText(r4)
        L_0x0149:
            r3 = 2131433594(0x7f0b187a, float:1.8488978E38)
            android.view.View r3 = r5.findViewById(r3)
            com.didi.safety.god2020.task.IDDetectionTask$5 r4 = new com.didi.safety.god2020.task.IDDetectionTask$5
            r4.<init>()
            r3.setOnClickListener(r4)
            goto L_0x01f3
        L_0x015a:
            r8 = 100016(0x186b0, float:1.40152E-40)
            if (r4 != r8) goto L_0x01c0
            r5.setVisibility(r6)
            android.view.View r4 = r5.findViewById(r15)
            r4.setVisibility(r11)
            android.view.View r4 = r5.findViewById(r14)
            r4.setVisibility(r11)
            android.view.View r4 = r5.findViewById(r13)
            r4.setVisibility(r6)
            android.view.View r4 = r5.findViewById(r12)
            r4.setVisibility(r11)
            r4 = 2131952437(0x7f130335, float:1.9541317E38)
            r9.setText(r4)
            r4 = 2131433673(0x7f0b18c9, float:1.8489138E38)
            android.view.View r4 = r5.findViewById(r4)
            com.didi.safety.god2020.task.IDDetectionTask$6 r8 = new com.didi.safety.god2020.task.IDDetectionTask$6
            r8.<init>()
            r4.setOnClickListener(r8)
            r4 = 2131433668(0x7f0b18c4, float:1.8489128E38)
            android.view.View r4 = r5.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r4.setVisibility(r6)
            if (r3 == 0) goto L_0x01f3
            com.didi.safety.god.http.OcrValue r4 = r3.ocrValue
            if (r4 == 0) goto L_0x01f3
            com.didi.safety.god.http.OcrValue r4 = r3.ocrValue
            java.lang.String r4 = r4.idno
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x01f3
            r4 = 2131433671(0x7f0b18c7, float:1.8489134E38)
            android.view.View r4 = r5.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            com.didi.safety.god.http.OcrValue r3 = r3.ocrValue
            java.lang.String r3 = r3.idno
            r4.setText(r3)
            goto L_0x01f3
        L_0x01c0:
            r16.moveToDefaultFailedStep()
            r1.f37662b = r6
            r9.setVisibility(r11)
            android.view.View r3 = r5.findViewById(r15)
            r3.setVisibility(r11)
            android.view.View r3 = r5.findViewById(r14)
            r3.setVisibility(r11)
            android.view.View r3 = r5.findViewById(r12)
            r3.setVisibility(r6)
            android.view.View r3 = r5.findViewById(r13)
            r3.setVisibility(r11)
            r3 = 2131433680(0x7f0b18d0, float:1.8489153E38)
            android.view.View r3 = r5.findViewById(r3)
            com.didi.safety.god2020.task.IDDetectionTask$7 r4 = new com.didi.safety.god2020.task.IDDetectionTask$7
            r4.<init>()
            r3.setOnClickListener(r4)
        L_0x01f3:
            com.didi.safety.god2020.task.IDDetectionTask$8 r3 = new com.didi.safety.god2020.task.IDDetectionTask$8
            r4 = r18
            r3.<init>(r2, r4)
            r0.setOnClickListener(r3)
            r0 = 2131952423(0x7f130327, float:1.9541288E38)
            r7.setText(r0)
            com.didi.safety.god2020.task.IDDetectionTask$9 r0 = new com.didi.safety.god2020.task.IDDetectionTask$9
            r0.<init>()
            r7.setOnClickListener(r0)
            androidx.fragment.app.FragmentActivity r0 = r1.activity
            r0.setContentView((android.view.View) r5)
            r2 = 0
            r1.f37661a = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.safety.god2020.task.IDDetectionTask.m28347a(com.didi.safety.god.ui.GLSurfaceRecorder$PicInfo, com.didi.safety.god.ui.GLSurfaceRecorder$VideoInfo, org.json.JSONObject):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28346a(GLSurfaceRecorder.PicInfo picInfo, GLSurfaceRecorder.VideoInfo videoInfo) {
        this.f37663c = false;
        ToastHelper.showShortCompleted((Context) this.activity, (int) R.string.GRider_OCR_Upload_successfully_VrMq);
        if (isLast()) {
            m28369d();
        }
        if (videoInfo != null) {
            File videoFile = videoInfo.getVideoFile();
            if (videoFile.exists()) {
                boolean delete = videoFile.delete();
                LogUtils.m28307d(videoFile.getAbsolutePath() + " delete ok? " + delete);
            }
        }
        if (picInfo.path.exists()) {
            boolean delete2 = picInfo.path.delete();
            LogUtils.m28307d(picInfo.path.getAbsolutePath() + " delete ok? " + delete2);
        }
        notifyTaskListener();
    }

    public void onLocalPicSelected(Uri uri) {
        super.onLocalPicSelected(uri);
    }

    public void onDetectWrongLabel() {
        super.onDetectWrongLabel();
    }

    public void onDetectNoGoodQuality(int i) {
        super.onDetectNoGoodQuality(i);
    }

    public void onLightnessChecked(float f) {
        super.onLightnessChecked(f);
    }

    public void onFinalInfoWithWrongPosSize(int i, boolean z) {
        handleFinalWrongSizeInfo(i, z);
    }

    public void onCaptureFinished(GLSurfaceRecorder.PicInfo picInfo) {
        m28362b(picInfo, (GLSurfaceRecorder.VideoInfo) null);
    }

    public void onRecordFinish(final GLSurfaceRecorder.PicInfo picInfo, final GLSurfaceRecorder.VideoInfo videoInfo, ImageDetector.DetectionResult detectionResult, boolean z) {
        LogUtils.m28307d("record finish, result = " + detectionResult + ", picInfo=" + picInfo + ", videoInfo=" + videoInfo);
        mo96471b();
        if (this.activity.isFinishing()) {
            LogUtils.m28307d("activity is finishing, ignore===");
        } else if (detectionResult == ImageDetector.DetectionResult.DETECTION_NO_GOOD_QUALITY) {
            clearWeakNotify();
            clearStrongNotify();
            restartDetection();
            ToastHelper.showShortInfo(this.activity.getApplicationContext(), (int) R.string.safety_god_detection_failed);
        } else if (detectionResult != ImageDetector.DetectionResult.SUCCESS) {
        } else {
            if (z) {
                m28366b(this.activity.getResources().getString(R.string.GRider_OCR_Please_take_zxKC), this.activity.getResources().getString(R.string.GRider_OCR_Got_it_tSiN));
            } else if (picInfo != null && videoInfo != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("cmd", "COLLVID");
                hashMap.put("collectType", this.card.getCardName());
                hashMap.put("code", 1);
                File videoFile = videoInfo.getVideoFile();
                String fileToMD5 = FileUtils.fileToMD5(videoFile);
                long length = videoFile.length();
                hashMap.put("info", fileToMD5 + ", " + length);
                hashMap.put("picInfo", picInfo.getStatsInfo());
                LogUtils.m28313i("COLLVID origMd5===" + fileToMD5 + ", len=" + length);
                SafetyTraceEventHandler.trace(hashMap, this.activity);
                this.activity.runOnUiThread(new Runnable() {
                    public void run() {
                        IDDetectionTask.this.m28362b(picInfo, videoInfo);
                    }
                });
            }
        }
    }

    public void onDetectTimeout(File file) {
        m28374h();
        clearWeakNotify();
        m28356a(file, 1);
        m28358a(this.activity.getApplicationContext().getString(R.string.GRider_OCR_Unable_to_XLAx), GodManager.getInstance().getConfig().appealUrl);
    }

    public void onTimeoutRecord() {
        mo96471b();
        clearWeakNotify();
        if (this.activity.isFinishing()) {
            LogUtils.m28307d("activity is finishing, ignore===");
            return;
        }
        recordAndCapture();
        m28372f();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28356a(final File file, final int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("cardsImgCode", this.card.getCardName());
        hashMap.put("timeoutImg", file);
        GodApi.getInstance().upload2(hashMap, new RpcService.Callback<String>() {
            public void onSuccess(String str) {
                file.delete();
            }

            public void onFailure(IOException iOException) {
                int i = i;
                if (i > 0) {
                    IDDetectionTask.this.m28356a(file, i - 1);
                } else {
                    file.delete();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m28362b(GLSurfaceRecorder.PicInfo picInfo, GLSurfaceRecorder.VideoInfo videoInfo) {
        String absolutePath = picInfo.path.getAbsolutePath();
        if (!new File(absolutePath).exists()) {
            LogUtils.m28309e("pic not exist!!!");
            return;
        }
        ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment();
        progressDialogFragment.setContent(this.activity.getString(R.string.GRider_OCR_Loading_rsnT), false);
        progressDialogFragment.show(this.activity.getSupportFragmentManager(), "loading");
        HashMap hashMap = new HashMap();
        hashMap.put("cardsImgCode", this.card.getCardName());
        hashMap.put("highImg", new File(absolutePath));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("x1", picInfo.f37517x1);
            jSONObject.put("y1", picInfo.f37519y1);
            jSONObject.put("x2", picInfo.f37518x2);
            jSONObject.put("y2", picInfo.f37520y2);
            jSONObject.put("qscore", String.format(Locale.CHINA, "%.6f", new Object[]{Float.valueOf(picInfo.quality)}));
            jSONObject.put("bscore", String.format(Locale.CHINA, "%.6f", new Object[]{Float.valueOf(picInfo.bscore)}));
            jSONObject.put("rscore", String.format(Locale.CHINA, "%.6f", new Object[]{Float.valueOf(picInfo.rscore)}));
            jSONObject.put("language", GodManager.getInstance().getLanguage());
            jSONObject.put("sdkVer", "7.0.0.7");
            hashMap.put("extraJsonObj", jSONObject.toString());
        } catch (JSONException e) {
            LogUtils.logStackTrace(e);
        }
        m28359a((Map<String, Object>) hashMap, (DialogFragment) progressDialogFragment, picInfo, videoInfo);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28359a(Map<String, Object> map, DialogFragment dialogFragment, GLSurfaceRecorder.PicInfo picInfo, GLSurfaceRecorder.VideoInfo videoInfo) {
        final HashMap hashMap = new HashMap();
        hashMap.put("collectType", this.card.getCardName());
        hashMap.put("cmd", "UPLOAD");
        hashMap.putAll(SafetyHttp.getCommonBodyParams());
        final long currentTimeMillis = System.currentTimeMillis();
        final DialogFragment dialogFragment2 = dialogFragment;
        final GLSurfaceRecorder.PicInfo picInfo2 = picInfo;
        final GLSurfaceRecorder.VideoInfo videoInfo2 = videoInfo;
        final Map<String, Object> map2 = map;
        GodApi.getInstance().upload2(map, new RpcService.Callback<String>() {
            public void onSuccess(String str) {
                hashMap.put("costTime", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int i = jSONObject.getInt("apiCode");
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    int i2 = 0;
                    if (optJSONObject != null) {
                        i2 = optJSONObject.optInt("code");
                    }
                    hashMap.put("apiCode", Integer.valueOf(i2));
                    if (i == 200) {
                        if (SafetyHttp.getHttpAction(i2) == SafetyHttp.HttpAction.SUCCESS) {
                            dialogFragment2.dismiss();
                            hashMap.put("code", 1);
                            hashMap.put(DMWebSocketListener.KEY_ERR_MSG, Integer.valueOf(i2));
                            SafetyTraceEventHandler.trace(hashMap, IDDetectionTask.this.activity);
                            if (IDDetectionTask.this.card.confirmUploadPageSwitch) {
                                boolean unused = IDDetectionTask.this.f37663c = true;
                                IDDetectionTask.this.m28347a(picInfo2, videoInfo2, optJSONObject);
                                return;
                            }
                            IDDetectionTask.this.m28346a(picInfo2, videoInfo2);
                            return;
                        }
                    }
                    if (i == 200 && UploadResp2.isSpecialFailCode(i2)) {
                        dialogFragment2.dismiss();
                        hashMap.put("code", 1);
                        hashMap.put(DMWebSocketListener.KEY_ERR_MSG, Integer.valueOf(i2));
                        SafetyTraceEventHandler.trace(hashMap, IDDetectionTask.this.activity);
                        IDDetectionTask.this.m28347a(picInfo2, videoInfo2, optJSONObject);
                    } else if (IDDetectionTask.m28368c(IDDetectionTask.this) < 3) {
                        hashMap.put("code", 2);
                        Map map = hashMap;
                        map.put(DMWebSocketListener.KEY_ERR_MSG, "retry, " + i2);
                        IDDetectionTask.this.m28373g();
                        SafetyTraceEventHandler.trace(hashMap, IDDetectionTask.this.activity);
                        IDDetectionTask.this.m28359a((Map<String, Object>) map2, dialogFragment2, picInfo2, videoInfo2);
                    } else {
                        hashMap.put("code", 2);
                        Map map2 = hashMap;
                        map2.put(DMWebSocketListener.KEY_ERR_MSG, "retry out, " + i2);
                        SafetyTraceEventHandler.trace(hashMap, IDDetectionTask.this.activity);
                        dialogFragment2.dismiss();
                        IDDetectionTask.this.m28357a(IDDetectionTask.this.activity.getString(R.string.GRider_OCR_Network_timeout_OyCj));
                    }
                } catch (Exception e) {
                    LogUtils.m28307d("error message is " + e.getMessage());
                    LogUtils.logStackTrace(e);
                }
            }

            public void onFailure(IOException iOException) {
                LogUtils.m28313i("upload api fail, msg=" + iOException.getMessage());
                hashMap.put("costTime", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                hashMap.put("code", 3);
                hashMap.put(DMWebSocketListener.KEY_ERR_MSG, iOException.getMessage());
                SafetyTraceEventHandler.trace(hashMap, IDDetectionTask.this.activity);
                if (IDDetectionTask.m28368c(IDDetectionTask.this) < 3) {
                    IDDetectionTask.this.m28359a((Map<String, Object>) map2, dialogFragment2, picInfo2, videoInfo2);
                    return;
                }
                dialogFragment2.dismiss();
                IDDetectionTask.this.m28357a((String) null);
            }
        });
    }

    /* renamed from: d */
    private void m28369d() {
        final HashMap hashMap = new HashMap();
        hashMap.put("collectType", this.card.getCardName());
        hashMap.put("cmd", "GETOCR");
        final long currentTimeMillis = System.currentTimeMillis();
        new HashMap();
        SafetyHttp.SafetyRequest safetyRequest = (SafetyHttp.SafetyRequest) new RpcServiceFactory(this.activity.getApplicationContext()).newRpcService(SafetyHttp.SafetyRequest.class, SafetyHttp.getApiHost());
        GodApi.getInstance().globalSdkCheck(SafetyHttp.getCommonBodyParams(), new RpcService.Callback<String>() {
            public void onSuccess(String str) {
                LogUtils.m28313i("get ocr info: " + str);
                hashMap.put("costTime", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optJSONObject("data").optInt("code");
                    hashMap.put("apiCode", Integer.valueOf(optInt));
                    if (optInt == 100000) {
                        hashMap.put("code", 1);
                        Map map = hashMap;
                        map.put(DMWebSocketListener.KEY_ERR_MSG, "json  code = " + optInt);
                        SafetyTraceEventHandler.trace(hashMap, IDDetectionTask.this.activity);
                        GodManager.getInstance().callBackLast(100000, "Upload Success", (String) SafetyHttp.getCommonBodyParams().get("KeeperId"), (Map) GsonUtils.fromJson(jSONObject, new HashMap().getClass()));
                        IDDetectionTask.this.activity.finish();
                        return;
                    }
                    hashMap.put("code", 2);
                    Map map2 = hashMap;
                    map2.put(DMWebSocketListener.KEY_ERR_MSG, "json  code = " + optInt);
                    SafetyTraceEventHandler.trace(hashMap, IDDetectionTask.this.activity);
                    GodManager.getInstance().callBackLast(100000, "Upload Success", (String) SafetyHttp.getCommonBodyParams().get("KeeperId"), (Map) GsonUtils.fromJson(jSONObject, new HashMap().getClass()));
                    IDDetectionTask.this.activity.finish();
                } catch (JSONException e) {
                    e.printStackTrace();
                    hashMap.put("code", 2);
                    hashMap.put(DMWebSocketListener.KEY_ERR_MSG, "json解析失败");
                    SafetyTraceEventHandler.trace(hashMap, IDDetectionTask.this.activity);
                }
            }

            public void onFailure(IOException iOException) {
                hashMap.put("costTime", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                hashMap.put("code", 3);
                hashMap.put(DMWebSocketListener.KEY_ERR_MSG, iOException == null ? "" : iOException.getMessage());
                SafetyTraceEventHandler.trace(hashMap, IDDetectionTask.this.activity);
                IDDetectionTask.this.activity.finish();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28357a(String str) {
        String str2;
        UploadFailedFragment newInstance = UploadFailedFragment.newInstance();
        if (str != null) {
            str2 = str;
        } else {
            str2 = this.activity.getString(R.string.GRider_OCR_Network_timeout_OyCj);
        }
        UploadFailedFragment buttonBackground = newInstance.setErrorMessage(str2).setButtonContent(this.activity.getString(R.string.GRider_OCR_Try_again_wqvh)).setButtonBackground(R.drawable.safety_god_global_btn_bg);
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString("message", str);
        } else {
            bundle.putString("message", this.activity.getString(R.string.GRider_OCR_Network_timeout_OyCj));
        }
        buttonBackground.setArguments(bundle);
        FragmentTransaction beginTransaction = this.activity.getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.detection_fragment_container, buttonBackground);
        beginTransaction.addToBackStack((String) null);
        beginTransaction.commitAllowingStateLoss();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m28365b(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", str);
        hashMap.put("collectType", this.card.getCardName());
        SafetyTraceEventHandler.trace(hashMap);
    }

    /* renamed from: a */
    private void m28345a(int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", "RECAPTURE");
        hashMap.put("code", Integer.valueOf(i));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(DMWebSocketListener.KEY_ERR_MSG, str);
        }
        hashMap.put("collectType", this.card.getCardName());
        SafetyTraceEventHandler.trace(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m28371e() {
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", "ZOOMINIMAGE");
        hashMap.put("collectType", this.card.getCardName());
        SafetyTraceEventHandler.trace(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28344a(int i) {
        m28345a(i, "");
        closeCamera();
        mo96470a();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m28361b(int i, String str) {
        m28345a(i, str);
        closeCamera();
        mo96470a();
    }

    /* renamed from: f */
    private void m28372f() {
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", "PICTIMEOUT");
        hashMap.put("collectType", this.card.getCardName());
        hashMap.put("cardName", this.card.getCardName());
        hashMap.put("cardImgDesc", this.card.getCardImgDesc());
        SafetyTraceEventHandler.trace(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m28373g() {
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", "REUPLOAD");
        SafetyTraceEventHandler.trace(hashMap);
    }

    /* renamed from: h */
    private void m28374h() {
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", "OVERTIMEUPLOAD");
        hashMap.put("collectType", this.card.getCardName());
        SafetyTraceEventHandler.trace(hashMap);
    }
}
