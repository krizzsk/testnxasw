package com.didichuxing.diface.biz.bioassay.alpha;

import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.sdk.p147ad.model.AdParams;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.dfbasesdk.encrypt.Encrypter;
import com.didichuxing.dfbasesdk.http.MultiSerializerForAccessSecurity;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.MathUtils;
import com.didichuxing.dfbasesdk.utils.NetworkUtils;
import com.didichuxing.dfbasesdk.utils.ResUtils;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.diface.act.DFBaseAct;
import com.didichuxing.diface.appeal.AppealParam;
import com.didichuxing.diface.biz.bioassay.alpha.p181M.compare.CompareModel;
import com.didichuxing.diface.biz.bioassay.alpha.p181M.compare.CompareParam;
import com.didichuxing.diface.biz.bioassay.alpha.p181M.compare.CompareResult;
import com.didichuxing.diface.biz.bioassay.alpha.p181M.compare.RealCompareModel;
import com.didichuxing.diface.biz.bioassay.alpha.p181M.report_failed.ReportFailedModel;
import com.didichuxing.diface.biz.bioassay.alpha.p181M.report_failed.ReportFailedParam;
import com.didichuxing.diface.biz.bioassay.alpha.p181M.report_failed.ReportFailedResult;
import com.didichuxing.diface.biz.bioassay.alpha.util.ICamera;
import com.didichuxing.diface.biz.bioassay.self_liveness.CompressUtils;
import com.didichuxing.diface.biz.bioassay.self_liveness.RecordHelper;
import com.didichuxing.diface.biz.guide.GuideHelper;
import com.didichuxing.diface.biz.guide.p183M.GuideResult;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.core.MVP.DiFaceBaseActivity;
import com.didichuxing.diface.custom_view.RoundMask;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.diface.utils.DFileUtils;
import com.didichuxing.diface.utils.DisplayUtils;
import com.didichuxing.diface.utils.FileUtils;
import com.didichuxing.diface.utils.SystemUtils;
import com.didichuxing.diface.utils.http.AbsHttpCallback;
import com.didichuxing.sdk.alphaface.AlphaFace;
import com.didichuxing.sdk.alphaface.core.BioassayManager;
import com.didichuxing.sdk.alphaface.core.RendererDecorate;
import com.squareup.otto.Subscribe;
import com.taxis99.R;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;

public class DiFaceBioassayActivity extends DFBaseAct implements Camera.PreviewCallback {
    public static final String WATER_MARK_FAIL = "-1";

    /* renamed from: g */
    private static final int f49798g = 640;

    /* renamed from: h */
    private static final int f49799h = 480;

    /* renamed from: t */
    private static final String f49800t = "1";

    /* renamed from: u */
    private static final String f49801u = "2";

    /* renamed from: a */
    private RelativeLayout f49802a;

    /* renamed from: b */
    private GLSurfaceView f49803b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public RoundMask f49804c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TextView f49805d;

    /* renamed from: e */
    private BioassayManager f49806e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ICamera f49807f;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public GuideResult f49808i;

    /* renamed from: j */
    private GuideResult.ModelParam f49809j;

    /* renamed from: k */
    private GuideResult.Result.CaptureInfo f49810k;

    /* renamed from: l */
    private RendererDecorate f49811l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public RecordHelper f49812m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f49813n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f49814o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public String f49815p = "";

    /* renamed from: q */
    private String f49816q = "";
    /* access modifiers changed from: private */

    /* renamed from: r */
    public String f49817r = "";

    /* renamed from: s */
    private String f49818s = "";

    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return R.string.df_act_title;
    }

    /* access modifiers changed from: protected */
    public int getContentLayout() {
        return R.layout.activity_diface_bioasay_layout;
    }

    /* access modifiers changed from: protected */
    public boolean needEventBus() {
        return true;
    }

    /* access modifiers changed from: protected */
    public int progressMsgResId() {
        return R.string.df_fpp_act_loading_msg;
    }

    public static void start(final DiFaceBaseActivity diFaceBaseActivity, final GuideResult guideResult) {
        AlphaFace.initialize(new AlphaFace.IInitCallback() {
            public void onResult(int i, String str) {
                if (i == 100000) {
                    Intent intent = new Intent(diFaceBaseActivity, DiFaceBioassayActivity.class);
                    intent.putExtra(GuideHelper.EXTRA_KEY_GUIDE_RESULT, guideResult);
                    diFaceBaseActivity.startActivityForResult(intent, 1);
                    return;
                }
                diFaceBaseActivity.finishWithResult(new DiFaceResult(118));
            }
        });
    }

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
        GuideResult guideResult = (GuideResult) intent.getSerializableExtra(GuideHelper.EXTRA_KEY_GUIDE_RESULT);
        this.f49808i = guideResult;
        GuideResult.ModelParam modelParam = guideResult.data.result.getModelParam();
        this.f49809j = modelParam;
        this.f49814o = modelParam.getAlive().getPicNum4AntiAttack();
        this.f49810k = this.f49808i.data.result.captureInfo;
    }

    /* access modifiers changed from: protected */
    public void onLeftTitleBtnClicked() {
        super.onLeftTitleBtnClicked();
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_BIOASSAY_EXIT, DiFaceLogger.getExitType("2"), (HashMap<String, Object>) null);
    }

    public void onBackPressed() {
        super.onBackPressed();
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_BIOASSAY_EXIT, DiFaceLogger.getExitType("1"), (HashMap<String, Object>) null);
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        this.f49802a = (RelativeLayout) findViewById(R.id.rl_root);
        this.f49803b = (GLSurfaceView) findViewById(R.id.gsv);
        this.f49805d = (TextView) findViewById(R.id.face_note2);
        m37302b();
        this.f49807f = new ICamera(DisplayUtils.getScreenWidth(this), DisplayUtils.getScreenHeight(this), 640, 480);
        DiFaceFacade.getInstance().report("11");
        SystemUtils.changeActBrightness(this, 0.8f);
    }

    /* renamed from: a */
    private void m37287a() {
        if (this.f49806e == null) {
            this.f49806e = new BioassayManager.Builder().setWaterType(this.f49808i.data.result.getWaterMarking()).setFps(this.f49807f.getFps()).setDetectTime(this.f49809j.getAlive().getTime4AntiAttack()).setFrameSkip(3).setActionPicCount(Math.min(this.f49814o, 5)).setBestPicQualityThreshold((double) this.f49809j.getQuality().getMinFaceQuality()).setAttackPicQualityThreshold((double) this.f49809j.getAlive().getMinFaceQuality4AntiAttack()).setBioassayListener(new BioassayManager.IBioassayListener() {
                public void onDetectFace(BioassayManager.FaceInfo faceInfo) {
                }

                public void onFailed(int i, String str) {
                }

                public void onProcess(int i) {
                    DiFaceBioassayActivity.this.f49804c.setProgress(MathUtils.clamp(i, 0, 100));
                }

                public void onFaceError(int i) {
                    DiFaceBioassayActivity.this.f49805d.setBackgroundResource(R.color.df_face_error_red_bg_color);
                    DiFaceBioassayActivity.this.f49805d.setTextColor(ResUtils.getColor(R.color.df_face_error_text_color));
                    int i2 = R.string.df_bioassay_act_error_not_centered;
                    if (i != 0) {
                        if (i == 1) {
                            i2 = R.string.df_bioassay_act_error_face_too_close;
                        } else if (i == 2) {
                            i2 = R.string.df_bioassay_act_error_face_too_far;
                        } else if (i != 3) {
                            i2 = i == 4 ? R.string.df_bioassay_act_error_pose : i == 5 ? R.string.df_bioassay_act_error_occ : i == 6 ? R.string.df_bioassay_act_error_blur : i == 7 ? R.string.df_bioassay_act_error_illum : R.string.df_bioassay_act_correct_tip;
                        }
                    }
                    DiFaceBioassayActivity.this.f49805d.setText(i2);
                }

                public void onFaceQualityError() {
                    DiFaceBioassayActivity.this.f49805d.setBackgroundResource(R.color.df_face_error_red_bg_color);
                    DiFaceBioassayActivity.this.f49805d.setTextColor(ResUtils.getColor(R.color.df_face_error_text_color));
                    DiFaceBioassayActivity.this.f49805d.setText(R.string.df_bioassay_act_correct_tip);
                }

                public void onSuccess(int i, List<BioassayManager.PicWithScore> list, List<BioassayManager.PicWithScore> list2, List<BioassayManager.PicWithScore> list3) {
                    DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_BI_DETECT_DONE);
                    DiFaceBioassayActivity diFaceBioassayActivity = DiFaceBioassayActivity.this;
                    String unused = diFaceBioassayActivity.f49815p = diFaceBioassayActivity.m37286a(list);
                    DiFaceBioassayActivity diFaceBioassayActivity2 = DiFaceBioassayActivity.this;
                    String unused2 = diFaceBioassayActivity2.f49817r = diFaceBioassayActivity2.m37286a(list2);
                    HashMap hashMap = new HashMap();
                    hashMap.put("bioType", 1);
                    hashMap.put("bestPic", DiFaceBioassayActivity.this.f49815p);
                    hashMap.put("actionPic", DiFaceBioassayActivity.this.f49817r);
                    DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_SOURCE_PICTURES, (HashMap<String, Object>) hashMap);
                    if (list.isEmpty()) {
                        DiFaceBioassayActivity.this.m37297a("1", "NO_BEST_PIC");
                    }
                    int size = list2.size();
                    if (size < DiFaceBioassayActivity.this.f49814o) {
                        DiFaceBioassayActivity diFaceBioassayActivity3 = DiFaceBioassayActivity.this;
                        diFaceBioassayActivity3.m37297a("2", "ACTION_PIC_NOT_ENOUGH, has " + size + ", requires " + DiFaceBioassayActivity.this.f49814o);
                    }
                    DiFaceBioassayActivity.this.m37298a(list, list2, list3);
                }
            }).create();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m37286a(List<BioassayManager.PicWithScore> list) {
        String str = "";
        if (list == null) {
            return str;
        }
        int size = list.size();
        int i = 0;
        while (i < size) {
            str = str + FileUtils.byteToMD5(list.get(i).rgba);
            i++;
            if (i < size) {
                str = str + ParamKeys.SIGN_AND;
            }
        }
        return str;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37297a(String str, String str2) {
        ReportFailedParam reportFailedParam = new ReportFailedParam();
        reportFailedParam.aliveErrorCode = str;
        reportFailedParam.aliveErrorMsg = str2;
        reportFailedParam.token = this.f49808i.token;
        reportFailedParam.sessionId = DiFaceFacade.getInstance().getSessionId();
        new ReportFailedModel(this).report(reportFailedParam, new AbsHttpCallback<ReportFailedResult>() {
            public void onSuccess(ReportFailedResult reportFailedResult) {
                int i = reportFailedResult.data.code;
                String str = reportFailedResult.data.message;
                LogUtils.m37051d("report living failed done, code=" + i + ", msg=" + str);
            }

            public void onFailed(int i, String str) {
                LogUtils.m37051d("report living failed failed, code=" + i + ", msg=" + str);
            }
        });
    }

    /* renamed from: b */
    private void m37302b() {
        this.f49803b.setEGLContextClientVersion(2);
        C162364 r0 = new RendererDecorate(this, this.f49803b) {
            public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig, SurfaceTexture surfaceTexture) {
                if (DiFaceBioassayActivity.this.f49807f != null) {
                    DiFaceBioassayActivity.this.f49807f.startPreview(surfaceTexture);
                    DiFaceBioassayActivity.this.f49807f.actionDetect(DiFaceBioassayActivity.this);
                }
                if (DiFaceBioassayActivity.this.f49812m != null) {
                    DiFaceFacade.getInstance().report("200", DiFaceLogger.setBioType((HashMap<String, Object>) null, "2"), (HashMap<String, Object>) null);
                    DiFaceBioassayActivity.this.f49812m.onStart();
                }
            }
        };
        this.f49811l = r0;
        this.f49803b.setRenderer(r0);
        this.f49803b.setRenderMode(0);
        GuideResult.Result.CaptureInfo captureInfo = this.f49810k;
        if (captureInfo != null) {
            this.f49811l.setRecordVideo(captureInfo.captureEnable, 640, 480, true, this.f49810k.bpp, this.f49810k.fps);
            this.f49812m = new RecordHelper(this, this.f49811l, "2", this.f49810k.maxTime, (long) this.f49810k.thresholdWifi, (long) this.f49810k.threshold4G);
            getLifecycle().addObserver(this.f49812m);
        }
        m37307c();
    }

    /* renamed from: c */
    private void m37307c() {
        int screenWidth = ResUtils.getScreenWidth();
        int i = (int) (((float) screenWidth) * 0.7f);
        int i2 = (int) (((float) i) * 1.3333334f);
        LogUtils.m37051d("screenW====" + screenWidth + ", glW=" + i + ", glH=" + i2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
        layoutParams.addRule(14);
        this.f49803b.setLayoutParams(layoutParams);
        m37288a(i, i2);
    }

    /* renamed from: a */
    private void m37288a(int i, int i2) {
        this.f49804c = new RoundMask(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
        layoutParams.addRule(6, R.id.gsv);
        layoutParams.addRule(5, R.id.gsv);
        this.f49802a.addView(this.f49804c, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.mRecreated) {
            finish();
            return;
        }
        this.f49807f.openCamera(this, true);
        if (!this.f49807f.isUsingFrontCamera()) {
            m37309d();
        }
        this.f49803b.onResume();
        m37287a();
    }

    /* renamed from: d */
    private void m37309d() {
        new AlertDialogFragment.Builder(this).setTitle(getString(R.string.df_bi_act_no_front_camera_dialog_title)).setMessage(getString(R.string.df_bi_act_no_front_camera_dialog_msg)).setPositiveButton((int) R.string.df_ok, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
            }
        }).setCancelable(false).create().show(getSupportFragmentManager(), "");
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.f49806e != null) {
            this.f49806e.detect(bArr, 640, 480, this.f49807f.isUsingFrontCamera() ? this.f49807f.getCameraAngle() : this.f49807f.getCameraAngle() + 180, 4, this.f49809j.getDetect().getCenterRatio(), this.f49809j.getDetect().getMinCropRatio(), this.f49809j.getDetect().getMaxCropRatio());
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f49803b.onPause();
        this.f49807f.closeCamera();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37298a(List<BioassayManager.PicWithScore> list, List<BioassayManager.PicWithScore> list2, List<BioassayManager.PicWithScore> list3) {
        List<BioassayManager.PicWithScore> list4 = list2;
        List<BioassayManager.PicWithScore> list5 = list3;
        CompareParam compareParam = new CompareParam();
        compareParam.token = this.f49808i.token;
        compareParam.sessionId = DiFaceFacade.getInstance().getSessionId();
        compareParam.language = DiFaceFacade.getInstance().getLanguage();
        HashMap hashMap = new HashMap();
        hashMap.put("model", SystemUtil.getModel());
        hashMap.put(AdParams.USER_AGENT, String.format("Android/%s %s/%s", new Object[]{Build.VERSION.RELEASE, getApplicationContext().getPackageName(), SystemUtil.getVersionName(getApplicationContext())}));
        hashMap.put("brand", Build.BRAND);
        ArrayList arrayList = new ArrayList();
        byte[] generateAesKey = Encrypter.generateAesKey();
        hashMap.put("sc", Encrypter.encryptAesKey(generateAesKey));
        ArrayList arrayList2 = new ArrayList();
        for (BioassayManager.PicWithScore next : list) {
            arrayList.add("bestPic");
            hashMap.put("faceImageQualityScore", Double.valueOf(next.qualityScore));
            arrayList2.add(new MultiSerializerForAccessSecurity.MemJpg(Encrypter.encrypt(DFileUtils.compressBitmap(next.width, next.height, next.rgba), generateAesKey), "bestPic.jpg"));
            if (next != null && ((MultiSerializerForAccessSecurity.MemJpg) arrayList2.get(0)).isEmpty()) {
                DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_AES_XOR);
                m37305b(list, list2, list3);
                return;
            }
        }
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        int i = 0;
        while (i < list2.size()) {
            BioassayManager.PicWithScore picWithScore = list4.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append("actionPic");
            int i2 = i + 1;
            sb.append(i2);
            String sb2 = sb.toString();
            arrayList.add(sb2);
            String str = sb2;
            try {
                jSONArray.put(picWithScore.qualityScore);
                jSONArray2.put(picWithScore.attackScore);
            } catch (Exception e) {
                LogUtils.logStackTrace(e);
            }
            byte[] encrypt = Encrypter.encrypt(DFileUtils.compressBitmap(picWithScore.width, picWithScore.height, picWithScore.rgba), generateAesKey);
            arrayList2.add(new MultiSerializerForAccessSecurity.MemJpg(encrypt, str + ".jpg"));
            i = i2;
        }
        hashMap.put("suspectImageQualityScore", jSONArray);
        hashMap.put("suspectImageAttackScore", jSONArray2);
        if (list5 != null && list3.size() > 0) {
            BioassayManager.PicWithScore picWithScore2 = list5.get(0);
            byte[] compressBitmap = DFileUtils.compressBitmap(picWithScore2.width, picWithScore2.height, picWithScore2.rgba);
            arrayList.add("markPic");
            arrayList2.add(new MultiSerializerForAccessSecurity.MemJpg(Encrypter.encrypt(CompareModel.addJpgSessionId(this, compressBitmap, compareParam.sessionId), generateAesKey), "markPic.jpg"));
            if (list5.get(0).qualityOk == 1.0d) {
                compareParam.mark = this.f49808i.data.result.getWaterMarking() + "";
            } else {
                compareParam.mark = "-1";
            }
        }
        compareParam.buildExtra(hashMap);
        this.f49816q = m37286a(list);
        this.f49818s = m37286a(list4);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("bioType", 1);
        hashMap2.put("bestPic", this.f49816q);
        hashMap2.put("actionPic", this.f49818s);
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_UPLOAD_PRE_PICTURES, (HashMap<String, Object>) hashMap2);
        if (!this.f49815p.equals(this.f49816q) || !this.f49817r.equals(this.f49818s)) {
            DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_MD5_COMPARE);
        }
        m37296a(compareParam, (List<String>) arrayList, (List<MultiSerializerForAccessSecurity.MemJpg>) arrayList2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37296a(final CompareParam compareParam, final List<String> list, final List<MultiSerializerForAccessSecurity.MemJpg> list2) {
        this.f49804c.onFaceOk();
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_COMPARE_REQUEST_LAUNCH);
        new CompareModel(this).compare(compareParam, list, list2, new AbsHttpCallback<CompareResult>() {
            public void onSuccess(CompareResult compareResult) {
                DiFaceBioassayActivity.this.f49804c.cancelRectAnim();
                if (DiFaceBioassayActivity.this.f49812m != null) {
                    DiFaceBioassayActivity.this.f49812m.onSuccess();
                }
                int i = compareResult.data.code;
                String str = compareResult.data.message;
                LogUtils.m37051d("compare onSuccess code=" + i + ", msg=" + str);
                DiFaceFacade.getInstance().reportEventWithCode("16", i);
                if (i == 100000) {
                    DiFaceBioassayActivity.this.finishWithResult(new DiFaceResult(0, str));
                    return;
                }
                String str2 = compareResult.data.result.show_appeal_entry ? compareResult.data.result.appealInfo.faceSessionId : "";
                AppealParam appealParam = new AppealParam();
                appealParam.token = DiFaceBioassayActivity.this.f49808i.token;
                appealParam.faceSessionId = str2;
                appealParam.country = DiFaceBioassayActivity.this.f49808i.data.result.country;
                appealParam.bizCode = DiFaceBioassayActivity.this.f49808i.bizCode;
                DiFaceBioassayActivity.this.m37290a(i, str, appealParam);
            }

            public void onFailed(int i, String str) {
                LogUtils.m37051d("compare onFailed code=" + i + ", msg=" + str);
                DiFaceBioassayActivity.this.f49804c.cancelRectAnim();
                if (DiFaceBioassayActivity.this.f49813n) {
                    boolean unused = DiFaceBioassayActivity.this.f49813n = false;
                    if (DiFaceBioassayActivity.this.f49812m != null) {
                        DiFaceBioassayActivity.this.f49812m.onSuccess();
                    }
                    DiFaceBioassayActivity.this.finishWithResult(new DiFaceResult(3, str));
                } else if (NetworkUtils.isNetworkConnected(DiFaceBioassayActivity.this)) {
                    boolean unused2 = DiFaceBioassayActivity.this.f49813n = true;
                    DiFaceBioassayActivity.this.m37296a(compareParam, (List<String>) list, (List<MultiSerializerForAccessSecurity.MemJpg>) list2);
                } else {
                    if (DiFaceBioassayActivity.this.f49812m != null) {
                        DiFaceBioassayActivity.this.f49812m.onSuccess();
                    }
                    DiFaceBioassayActivity diFaceBioassayActivity = DiFaceBioassayActivity.this;
                    diFaceBioassayActivity.m37289a(112, diFaceBioassayActivity.getString(R.string.df_no_net_connected_toast));
                }
            }
        });
    }

    /* renamed from: b */
    private void m37305b(List<BioassayManager.PicWithScore> list, List<BioassayManager.PicWithScore> list2, List<BioassayManager.PicWithScore> list3) {
        List<BioassayManager.PicWithScore> list4 = list2;
        List<BioassayManager.PicWithScore> list5 = list3;
        CompareParam compareParam = new CompareParam();
        compareParam.token = this.f49808i.token;
        compareParam.sessionId = DiFaceFacade.getInstance().getSessionId();
        compareParam.language = DiFaceFacade.getInstance().getLanguage();
        HashMap hashMap = new HashMap();
        hashMap.put("model", SystemUtil.getModel());
        hashMap.put(AdParams.USER_AGENT, String.format("Android/%s %s/%s", new Object[]{Build.VERSION.RELEASE, getApplicationContext().getPackageName(), SystemUtil.getVersionName(getApplicationContext())}));
        hashMap.put("brand", Build.BRAND);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (BioassayManager.PicWithScore next : list) {
            arrayList.add("bestPic");
            hashMap.put("faceImageQualityScore", Double.valueOf(next.qualityScore));
            File file = new File(getFilesDir(), "bestPic.jpg");
            CompressUtils.compressRGBA(file, next);
            arrayList2.add(file);
        }
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        int i = 0;
        while (i < list2.size()) {
            BioassayManager.PicWithScore picWithScore = list4.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append("actionPic");
            int i2 = i + 1;
            sb.append(i2);
            String sb2 = sb.toString();
            arrayList.add(sb2);
            try {
                jSONArray.put(picWithScore.qualityScore);
                jSONArray2.put(picWithScore.attackScore);
            } catch (Exception e) {
                LogUtils.logStackTrace(e);
            }
            File filesDir = getFilesDir();
            File file2 = new File(filesDir, sb2 + ".jpg");
            CompressUtils.compressRGBA(file2, picWithScore);
            arrayList2.add(file2);
            i = i2;
        }
        hashMap.put("suspectImageQualityScore", jSONArray);
        hashMap.put("suspectImageAttackScore", jSONArray2);
        if (list5 != null && list3.size() > 0) {
            arrayList.add("markPic");
            File file3 = new File(getFilesDir(), "markPic.jpg");
            CompressUtils.compressRGBA(file3, list5.get(0));
            arrayList2.add(file3);
            if (list5.get(0).qualityOk == 1.0d) {
                compareParam.mark = this.f49808i.data.result.getWaterMarking() + "";
            } else {
                compareParam.mark = "-1";
            }
        }
        compareParam.buildExtra(hashMap);
        this.f49816q = m37286a(list);
        this.f49818s = m37286a(list4);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("bioType", 1);
        hashMap2.put("bestPic", this.f49816q);
        hashMap2.put("actionPic", this.f49818s);
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_UPLOAD_PRE_PICTURES, (HashMap<String, Object>) hashMap2);
        if (!this.f49815p.equals(this.f49816q) || !this.f49817r.equals(this.f49818s)) {
            DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_MD5_COMPARE);
        }
        m37304b(compareParam, (List<String>) arrayList, (List<File>) arrayList2);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m37304b(final CompareParam compareParam, final List<String> list, final List<File> list2) {
        this.f49804c.onFaceOk();
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_COMPARE_REQUEST_LAUNCH);
        new RealCompareModel(this).compare(compareParam, list, list2, new AbsHttpCallback<CompareResult>() {
            public void onSuccess(CompareResult compareResult) {
                DiFaceBioassayActivity.this.f49804c.cancelRectAnim();
                if (DiFaceBioassayActivity.this.f49812m != null) {
                    DiFaceBioassayActivity.this.f49812m.onSuccess();
                }
                DFileUtils.delFiles(list2);
                int i = compareResult.data.code;
                String str = compareResult.data.message;
                LogUtils.m37051d("compare onSuccess code=" + i + ", msg=" + str);
                DiFaceFacade.getInstance().reportEventWithCode("16", i);
                if (i == 100000) {
                    DiFaceBioassayActivity.this.finishWithResult(new DiFaceResult(0, str));
                    return;
                }
                String str2 = compareResult.data.result.show_appeal_entry ? compareResult.data.result.appealInfo.faceSessionId : "";
                AppealParam appealParam = new AppealParam();
                appealParam.token = DiFaceBioassayActivity.this.f49808i.token;
                appealParam.faceSessionId = str2;
                appealParam.country = DiFaceBioassayActivity.this.f49808i.data.result.country;
                appealParam.bizCode = DiFaceBioassayActivity.this.f49808i.bizCode;
                DiFaceBioassayActivity.this.m37290a(i, str, appealParam);
            }

            public void onFailed(int i, String str) {
                LogUtils.m37051d("compare onFailed code=" + i + ", msg=" + str);
                DiFaceBioassayActivity.this.f49804c.cancelRectAnim();
                if (DiFaceBioassayActivity.this.f49813n) {
                    boolean unused = DiFaceBioassayActivity.this.f49813n = false;
                    if (DiFaceBioassayActivity.this.f49812m != null) {
                        DiFaceBioassayActivity.this.f49812m.onSuccess();
                    }
                    DFileUtils.delFiles(list2);
                    DiFaceBioassayActivity.this.finishWithResult(new DiFaceResult(3, str));
                } else if (NetworkUtils.isNetworkConnected(DiFaceBioassayActivity.this)) {
                    boolean unused2 = DiFaceBioassayActivity.this.f49813n = true;
                    DiFaceBioassayActivity.this.m37304b(compareParam, (List<String>) list, (List<File>) list2);
                } else {
                    if (DiFaceBioassayActivity.this.f49812m != null) {
                        DiFaceBioassayActivity.this.f49812m.onSuccess();
                    }
                    DFileUtils.delFiles(list2);
                    DiFaceBioassayActivity diFaceBioassayActivity = DiFaceBioassayActivity.this;
                    diFaceBioassayActivity.m37289a(112, diFaceBioassayActivity.getString(R.string.df_no_net_connected_toast));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37289a(int i, String str) {
        DFBioassayFailedAct.start(this, i, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37290a(int i, String str, AppealParam appealParam) {
        DFBioassayFailedAct.start(this, i, str, appealParam);
    }

    @Subscribe
    public void onBioassayFailedDoneEvent(BioassayFailedDoneEvent bioassayFailedDoneEvent) {
        finishWithResult(bioassayFailedDoneEvent.result);
    }

    @Subscribe
    public void onAppealAfterCompareFailedEvent(AppealAfterCompareFailedEvent appealAfterCompareFailedEvent) {
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        AlphaFace.unInit();
        BioassayManager bioassayManager = this.f49806e;
        if (bioassayManager != null) {
            bioassayManager.quit();
        }
    }
}
