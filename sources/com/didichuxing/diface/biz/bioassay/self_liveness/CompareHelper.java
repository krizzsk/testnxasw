package com.didichuxing.diface.biz.bioassay.self_liveness;

import android.os.Build;
import android.text.TextUtils;
import com.didi.sdk.p147ad.model.AdParams;
import com.didi.sdk.util.SystemUtil;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.dfbasesdk.http.MultiSerializerForAccessSecurity;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.NetworkUtils;
import com.didichuxing.dfbasesdk.utils.ResUtils;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.diface.appeal.AppealParam;
import com.didichuxing.diface.biz.bioassay.alpha.DFBioassayFailedAct;
import com.didichuxing.diface.biz.bioassay.alpha.p181M.compare.CompareModel;
import com.didichuxing.diface.biz.bioassay.alpha.p181M.compare.CompareParam;
import com.didichuxing.diface.biz.bioassay.alpha.p181M.compare.CompareResult;
import com.didichuxing.diface.biz.bioassay.alpha.p181M.compare.RealCompareModel;
import com.didichuxing.diface.biz.bioassay.alpha.p181M.report_failed.ReportFailedModel;
import com.didichuxing.diface.biz.bioassay.alpha.p181M.report_failed.ReportFailedParam;
import com.didichuxing.diface.biz.bioassay.alpha.p181M.report_failed.ReportFailedResult;
import com.didichuxing.diface.biz.guide.p183M.GuideResult;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.diface.utils.DFileUtils;
import com.didichuxing.diface.utils.FileUtils;
import com.didichuxing.diface.utils.http.AbsHttpCallback;
import com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback;
import com.didichuxing.sdk.alphaface.core.liveness.LivenessResult;
import com.taxis99.R;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class CompareHelper {
    public static final String WATER_MARK_FAIL = "-1";
    public static final String WATER_MARK_SUCCESS = "0";

    /* renamed from: a */
    private static final String f49843a = "NO_BEST_PIC";

    /* renamed from: b */
    private static final String f49844b = "ACTION_PIC_NOT_ENOUGH";

    /* renamed from: c */
    private static final String f49845c = "envPic";

    /* renamed from: d */
    private static final String f49846d = "actionPic";

    /* renamed from: e */
    private static final String f49847e = "bestPic";

    /* renamed from: f */
    private static final String f49848f = "markPic";
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final DiFaceSelfLivenessActivity f49849g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final GuideResult f49850h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final RoundMaskLiveness f49851i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f49852j;

    /* renamed from: k */
    private int f49853k = 3;

    public CompareHelper(DiFaceSelfLivenessActivity diFaceSelfLivenessActivity, GuideResult guideResult, RoundMaskLiveness roundMaskLiveness) {
        this.f49849g = diFaceSelfLivenessActivity;
        this.f49850h = guideResult;
        this.f49851i = roundMaskLiveness;
        if (guideResult != null && guideResult.data != null && guideResult.data.result != null && guideResult.data.result.getModelParam() != null && guideResult.data.result.getModelParam().getAlive() != null) {
            this.f49853k = guideResult.data.result.getModelParam().getAlive().getPicNum4AntiAttack();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00dd, code lost:
        r0 = r25.getBestActionPicList().iterator();
        r6 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00ec, code lost:
        if (r0.hasNext() == false) goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r6 = r0.next();
        r4.add(f49845c);
        r3.put("faceImage2QualityScore", java.lang.Double.valueOf(r6.qualityScore));
        r9.add(new com.didichuxing.dfbasesdk.http.MultiSerializerForAccessSecurity.MemJpg(com.didichuxing.dfbasesdk.encrypt.Encrypter.encrypt(com.didichuxing.diface.utils.DFileUtils.compressBitmap(r6.width, r6.height, r6.rgba), r5), "bestActionPic.jpg"));
        r6 = com.didichuxing.diface.utils.FileUtils.byteToMD5(r6.rgba);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0123, code lost:
        r7 = new org.json.JSONArray();
        r8 = new org.json.JSONArray();
        r13 = r25.getAttackPicList();
        r16 = r6;
        r6 = r11;
        r17 = f49845c;
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x013b, code lost:
        r18 = r12;
        r19 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0143, code lost:
        if (r0 >= r13.size()) goto L_0x01c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r15 = r13.get(r0);
        r20 = r13;
        r13 = new java.lang.StringBuilder();
        r13.append(f49846d);
        r14 = r0 + 1;
        r13.append(r14);
        r13 = r13.toString();
        r4.add(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0161, code lost:
        r21 = r10;
        r22 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r7.put(r15.qualityScore);
        r8.put(r15.attackScore);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0170, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        com.didichuxing.dfbasesdk.utils.LogUtils.logStackTrace(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x01c3, code lost:
        r21 = r10;
        r22 = r11;
        r20 = r13;
        r3.put("suspectImageQualityScore", r7);
        r3.put("suspectImageAttackScore", r8);
        r2.buildExtra(r3);
        r0 = r25.getWaterPicList();
        r3 = com.didichuxing.diface.utils.DFileUtils.compressBitmap(r0.get(0).width, r0.get(0).height, r0.get(0).rgba);
        r4.add(f49848f);
        r9.add(new com.didichuxing.dfbasesdk.http.MultiSerializerForAccessSecurity.MemJpg(com.didichuxing.dfbasesdk.encrypt.Encrypter.encrypt(com.didichuxing.diface.biz.bioassay.alpha.p181M.compare.CompareModel.addJpgSessionId(r1.f49849g, r3, r2.sessionId), r5), "markPic.jpg"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x021f, code lost:
        if (r0.get(0).qualityOk != 1.0d) goto L_0x023f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0221, code lost:
        r2.mark = r1.f49850h.data.result.getWaterMarking() + r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x023f, code lost:
        r2.mark = "-1";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0243, code lost:
        m37334b(r2, r4, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x024a, code lost:
        if (r21.isEmpty() == false) goto L_0x0253;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x024c, code lost:
        m37331a(f49843a, "活体检测失败,没有最佳图片");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0253, code lost:
        r0 = r20.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0259, code lost:
        if (r0 >= r1.f49853k) goto L_0x0280;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x025b, code lost:
        m37331a(f49844b, "动作图片与要求不符,（" + r0 + "/" + r1.f49853k + ")");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0284, code lost:
        if (android.text.TextUtils.isEmpty(r6) != false) goto L_0x0297;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x028a, code lost:
        if (r6.contains(com.didi.travel.psnger.common.net.base.ParamKeys.SIGN_AND) == false) goto L_0x0297;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x028c, code lost:
        r6 = r6.substring(0, r6.length() - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0297, code lost:
        r0 = new java.util.HashMap();
        r0.put("bioType", 2);
        r0.put(r19, r18);
        r0.put(f49846d, r6);
        r0.put(r17, r16);
        com.didichuxing.diface.core.DiFaceFacade.getInstance().report(com.didichuxing.diface.logger.DiFaceLogger.EVENT_ID_UPLOAD_PRE_PICTURES, (java.util.HashMap<java.lang.String, java.lang.Object>) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void compare(com.didichuxing.sdk.alphaface.core.liveness.LivenessResult r25) {
        /*
            r24 = this;
            r1 = r24
            com.didichuxing.diface.biz.bioassay.alpha.M.compare.CompareParam r2 = new com.didichuxing.diface.biz.bioassay.alpha.M.compare.CompareParam     // Catch:{ Exception -> 0x02c1 }
            r2.<init>()     // Catch:{ Exception -> 0x02c1 }
            com.didichuxing.diface.biz.guide.M.GuideResult r0 = r1.f49850h     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r0 = r0.token     // Catch:{ Exception -> 0x02c1 }
            r2.token = r0     // Catch:{ Exception -> 0x02c1 }
            com.didichuxing.diface.core.DiFaceFacade r0 = com.didichuxing.diface.core.DiFaceFacade.getInstance()     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r0 = r0.getSessionId()     // Catch:{ Exception -> 0x02c1 }
            r2.sessionId = r0     // Catch:{ Exception -> 0x02c1 }
            com.didichuxing.diface.core.DiFaceFacade r0 = com.didichuxing.diface.core.DiFaceFacade.getInstance()     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r0 = r0.getLanguage()     // Catch:{ Exception -> 0x02c1 }
            r2.language = r0     // Catch:{ Exception -> 0x02c1 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x02c1 }
            r3.<init>()     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r0 = "model"
            java.lang.String r4 = com.didi.sdk.util.SystemUtil.getModel()     // Catch:{ Exception -> 0x02c1 }
            r3.put(r0, r4)     // Catch:{ Exception -> 0x02c1 }
            com.didichuxing.diface.biz.bioassay.self_liveness.DiFaceSelfLivenessActivity r0 = r1.f49849g     // Catch:{ Exception -> 0x02c1 }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r0 = com.didi.sdk.util.SystemUtil.getVersionName(r0)     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r4 = "Android/%s %s/%s"
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r6 = android.os.Build.VERSION.RELEASE     // Catch:{ Exception -> 0x02c1 }
            r7 = 0
            r5[r7] = r6     // Catch:{ Exception -> 0x02c1 }
            com.didichuxing.diface.biz.bioassay.self_liveness.DiFaceSelfLivenessActivity r6 = r1.f49849g     // Catch:{ Exception -> 0x02c1 }
            android.content.Context r6 = r6.getApplicationContext()     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ Exception -> 0x02c1 }
            r8 = 1
            r5[r8] = r6     // Catch:{ Exception -> 0x02c1 }
            r6 = 2
            r5[r6] = r0     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r0 = java.lang.String.format(r4, r5)     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r4 = "userAgent"
            r3.put(r4, r0)     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r0 = "brand"
            java.lang.String r4 = android.os.Build.BRAND     // Catch:{ Exception -> 0x02c1 }
            r3.put(r0, r4)     // Catch:{ Exception -> 0x02c1 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x02c1 }
            r4.<init>()     // Catch:{ Exception -> 0x02c1 }
            byte[] r5 = com.didichuxing.dfbasesdk.encrypt.Encrypter.generateAesKey()     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r0 = "sc"
            java.lang.String r9 = com.didichuxing.dfbasesdk.encrypt.Encrypter.encryptAesKey(r5)     // Catch:{ Exception -> 0x02c1 }
            r3.put(r0, r9)     // Catch:{ Exception -> 0x02c1 }
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ Exception -> 0x02c1 }
            r9.<init>()     // Catch:{ Exception -> 0x02c1 }
            java.util.List r10 = r25.getBestPicList()     // Catch:{ Exception -> 0x02c1 }
            java.util.Iterator r0 = r10.iterator()     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r11 = ""
            r12 = r11
        L_0x0085:
            boolean r13 = r0.hasNext()     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r14 = "bestPic"
            if (r13 == 0) goto L_0x00dd
            java.lang.Object r12 = r0.next()     // Catch:{ Exception -> 0x02c1 }
            com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback$PicWithScore r12 = (com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback.PicWithScore) r12     // Catch:{ Exception -> 0x02c1 }
            r4.add(r14)     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r13 = "faceImageQualityScore"
            double r14 = r12.qualityScore     // Catch:{ Exception -> 0x02c1 }
            java.lang.Double r14 = java.lang.Double.valueOf(r14)     // Catch:{ Exception -> 0x02c1 }
            r3.put(r13, r14)     // Catch:{ Exception -> 0x02c1 }
            com.didichuxing.dfbasesdk.http.MultiSerializerForAccessSecurity$MemJpg r13 = new com.didichuxing.dfbasesdk.http.MultiSerializerForAccessSecurity$MemJpg     // Catch:{ Exception -> 0x02c1 }
            int r14 = r12.width     // Catch:{ Exception -> 0x02c1 }
            int r15 = r12.height     // Catch:{ Exception -> 0x02c1 }
            byte[] r6 = r12.rgba     // Catch:{ Exception -> 0x02c1 }
            byte[] r6 = com.didichuxing.diface.utils.DFileUtils.compressBitmap(r14, r15, r6)     // Catch:{ Exception -> 0x02c1 }
            byte[] r6 = com.didichuxing.dfbasesdk.encrypt.Encrypter.encrypt((byte[]) r6, (byte[]) r5)     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r14 = "bestPic.jpg"
            r13.<init>(r6, r14)     // Catch:{ Exception -> 0x02c1 }
            r9.add(r13)     // Catch:{ Exception -> 0x02c1 }
            byte[] r6 = r12.rgba     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r6 = com.didichuxing.diface.utils.FileUtils.byteToMD5(r6)     // Catch:{ Exception -> 0x02c1 }
            if (r12 == 0) goto L_0x00da
            java.lang.Object r12 = r9.get(r7)     // Catch:{ Exception -> 0x02c1 }
            com.didichuxing.dfbasesdk.http.MultiSerializerForAccessSecurity$MemJpg r12 = (com.didichuxing.dfbasesdk.http.MultiSerializerForAccessSecurity.MemJpg) r12     // Catch:{ Exception -> 0x02c1 }
            boolean r12 = r12.isEmpty()     // Catch:{ Exception -> 0x02c1 }
            if (r12 == 0) goto L_0x00da
            com.didichuxing.diface.core.DiFaceFacade r0 = com.didichuxing.diface.core.DiFaceFacade.getInstance()     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r2 = "304"
            r0.report(r2)     // Catch:{ Exception -> 0x02c1 }
            r24.m37330a((com.didichuxing.sdk.alphaface.core.liveness.LivenessResult) r25)     // Catch:{ Exception -> 0x02c1 }
            return
        L_0x00da:
            r12 = r6
            r6 = 2
            goto L_0x0085
        L_0x00dd:
            java.util.List r0 = r25.getBestActionPicList()     // Catch:{ Exception -> 0x02c1 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x02c1 }
            r6 = r11
        L_0x00e6:
            boolean r13 = r0.hasNext()     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r15 = "envPic"
            if (r13 == 0) goto L_0x0123
            java.lang.Object r6 = r0.next()     // Catch:{ Exception -> 0x02c1 }
            com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback$PicWithScore r6 = (com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback.PicWithScore) r6     // Catch:{ Exception -> 0x02c1 }
            r4.add(r15)     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r13 = "faceImage2QualityScore"
            double r7 = r6.qualityScore     // Catch:{ Exception -> 0x02c1 }
            java.lang.Double r7 = java.lang.Double.valueOf(r7)     // Catch:{ Exception -> 0x02c1 }
            r3.put(r13, r7)     // Catch:{ Exception -> 0x02c1 }
            com.didichuxing.dfbasesdk.http.MultiSerializerForAccessSecurity$MemJpg r7 = new com.didichuxing.dfbasesdk.http.MultiSerializerForAccessSecurity$MemJpg     // Catch:{ Exception -> 0x02c1 }
            int r8 = r6.width     // Catch:{ Exception -> 0x02c1 }
            int r13 = r6.height     // Catch:{ Exception -> 0x02c1 }
            byte[] r15 = r6.rgba     // Catch:{ Exception -> 0x02c1 }
            byte[] r8 = com.didichuxing.diface.utils.DFileUtils.compressBitmap(r8, r13, r15)     // Catch:{ Exception -> 0x02c1 }
            byte[] r8 = com.didichuxing.dfbasesdk.encrypt.Encrypter.encrypt((byte[]) r8, (byte[]) r5)     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r13 = "bestActionPic.jpg"
            r7.<init>(r8, r13)     // Catch:{ Exception -> 0x02c1 }
            r9.add(r7)     // Catch:{ Exception -> 0x02c1 }
            byte[] r6 = r6.rgba     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r6 = com.didichuxing.diface.utils.FileUtils.byteToMD5(r6)     // Catch:{ Exception -> 0x02c1 }
            r7 = 0
            r8 = 1
            goto L_0x00e6
        L_0x0123:
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch:{ Exception -> 0x02c1 }
            r7.<init>()     // Catch:{ Exception -> 0x02c1 }
            org.json.JSONArray r8 = new org.json.JSONArray     // Catch:{ Exception -> 0x02c1 }
            r8.<init>()     // Catch:{ Exception -> 0x02c1 }
            java.util.List r13 = r25.getAttackPicList()     // Catch:{ Exception -> 0x02c1 }
            r16 = r6
            r6 = r11
            r17 = r15
            r0 = 0
        L_0x0137:
            int r15 = r13.size()     // Catch:{ Exception -> 0x02c1 }
            r18 = r12
            java.lang.String r12 = "&"
            r19 = r14
            java.lang.String r14 = "actionPic"
            if (r0 >= r15) goto L_0x01c3
            java.lang.Object r15 = r13.get(r0)     // Catch:{ Exception -> 0x02c1 }
            com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback$PicWithScore r15 = (com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback.PicWithScore) r15     // Catch:{ Exception -> 0x02c1 }
            r20 = r13
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02c1 }
            r13.<init>()     // Catch:{ Exception -> 0x02c1 }
            r13.append(r14)     // Catch:{ Exception -> 0x02c1 }
            int r14 = r0 + 1
            r13.append(r14)     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x02c1 }
            r4.add(r13)     // Catch:{ Exception -> 0x02c1 }
            r21 = r10
            r22 = r11
            double r10 = r15.qualityScore     // Catch:{ Exception -> 0x0170 }
            r7.put(r10)     // Catch:{ Exception -> 0x0170 }
            double r10 = r15.attackScore     // Catch:{ Exception -> 0x0170 }
            r8.put(r10)     // Catch:{ Exception -> 0x0170 }
            goto L_0x0174
        L_0x0170:
            r0 = move-exception
            com.didichuxing.dfbasesdk.utils.LogUtils.logStackTrace(r0)     // Catch:{ Exception -> 0x02c1 }
        L_0x0174:
            com.didichuxing.dfbasesdk.http.MultiSerializerForAccessSecurity$MemJpg r0 = new com.didichuxing.dfbasesdk.http.MultiSerializerForAccessSecurity$MemJpg     // Catch:{ Exception -> 0x02c1 }
            int r10 = r15.width     // Catch:{ Exception -> 0x02c1 }
            int r11 = r15.height     // Catch:{ Exception -> 0x02c1 }
            r23 = r14
            byte[] r14 = r15.rgba     // Catch:{ Exception -> 0x02c1 }
            byte[] r10 = com.didichuxing.diface.utils.DFileUtils.compressBitmap(r10, r11, r14)     // Catch:{ Exception -> 0x02c1 }
            byte[] r10 = com.didichuxing.dfbasesdk.encrypt.Encrypter.encrypt((byte[]) r10, (byte[]) r5)     // Catch:{ Exception -> 0x02c1 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02c1 }
            r11.<init>()     // Catch:{ Exception -> 0x02c1 }
            r11.append(r13)     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r13 = ".jpg"
            r11.append(r13)     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x02c1 }
            r0.<init>(r10, r11)     // Catch:{ Exception -> 0x02c1 }
            r9.add(r0)     // Catch:{ Exception -> 0x02c1 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02c1 }
            r0.<init>()     // Catch:{ Exception -> 0x02c1 }
            r0.append(r6)     // Catch:{ Exception -> 0x02c1 }
            byte[] r6 = r15.rgba     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r6 = com.didichuxing.diface.utils.FileUtils.byteToMD5(r6)     // Catch:{ Exception -> 0x02c1 }
            r0.append(r6)     // Catch:{ Exception -> 0x02c1 }
            r0.append(r12)     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r6 = r0.toString()     // Catch:{ Exception -> 0x02c1 }
            r12 = r18
            r14 = r19
            r13 = r20
            r10 = r21
            r11 = r22
            r0 = r23
            goto L_0x0137
        L_0x01c3:
            r21 = r10
            r22 = r11
            r20 = r13
            java.lang.String r0 = "suspectImageQualityScore"
            r3.put(r0, r7)     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r0 = "suspectImageAttackScore"
            r3.put(r0, r8)     // Catch:{ Exception -> 0x02c1 }
            r2.buildExtra(r3)     // Catch:{ Exception -> 0x02c1 }
            java.util.List r0 = r25.getWaterPicList()     // Catch:{ Exception -> 0x02c1 }
            r3 = 0
            java.lang.Object r7 = r0.get(r3)     // Catch:{ Exception -> 0x02c1 }
            com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback$PicWithScore r7 = (com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback.PicWithScore) r7     // Catch:{ Exception -> 0x02c1 }
            int r7 = r7.width     // Catch:{ Exception -> 0x02c1 }
            java.lang.Object r8 = r0.get(r3)     // Catch:{ Exception -> 0x02c1 }
            com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback$PicWithScore r8 = (com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback.PicWithScore) r8     // Catch:{ Exception -> 0x02c1 }
            int r8 = r8.height     // Catch:{ Exception -> 0x02c1 }
            java.lang.Object r10 = r0.get(r3)     // Catch:{ Exception -> 0x02c1 }
            com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback$PicWithScore r10 = (com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback.PicWithScore) r10     // Catch:{ Exception -> 0x02c1 }
            byte[] r3 = r10.rgba     // Catch:{ Exception -> 0x02c1 }
            byte[] r3 = com.didichuxing.diface.utils.DFileUtils.compressBitmap(r7, r8, r3)     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r7 = "markPic"
            r4.add(r7)     // Catch:{ Exception -> 0x02c1 }
            com.didichuxing.dfbasesdk.http.MultiSerializerForAccessSecurity$MemJpg r7 = new com.didichuxing.dfbasesdk.http.MultiSerializerForAccessSecurity$MemJpg     // Catch:{ Exception -> 0x02c1 }
            com.didichuxing.diface.biz.bioassay.self_liveness.DiFaceSelfLivenessActivity r8 = r1.f49849g     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r10 = r2.sessionId     // Catch:{ Exception -> 0x02c1 }
            byte[] r3 = com.didichuxing.diface.biz.bioassay.alpha.p181M.compare.CompareModel.addJpgSessionId(r8, r3, r10)     // Catch:{ Exception -> 0x02c1 }
            byte[] r3 = com.didichuxing.dfbasesdk.encrypt.Encrypter.encrypt((byte[]) r3, (byte[]) r5)     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r5 = "markPic.jpg"
            r7.<init>(r3, r5)     // Catch:{ Exception -> 0x02c1 }
            r9.add(r7)     // Catch:{ Exception -> 0x02c1 }
            r3 = 0
            java.lang.Object r0 = r0.get(r3)     // Catch:{ Exception -> 0x02c1 }
            com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback$PicWithScore r0 = (com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback.PicWithScore) r0     // Catch:{ Exception -> 0x02c1 }
            double r7 = r0.qualityOk     // Catch:{ Exception -> 0x02c1 }
            r10 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r0 != 0) goto L_0x023f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02c1 }
            r0.<init>()     // Catch:{ Exception -> 0x02c1 }
            com.didichuxing.diface.biz.guide.M.GuideResult r3 = r1.f49850h     // Catch:{ Exception -> 0x02c1 }
            com.didichuxing.diface.biz.guide.M.GuideResult$Data r3 = r3.data     // Catch:{ Exception -> 0x02c1 }
            com.didichuxing.diface.biz.guide.M.GuideResult$Result r3 = r3.result     // Catch:{ Exception -> 0x02c1 }
            int r3 = r3.getWaterMarking()     // Catch:{ Exception -> 0x02c1 }
            r0.append(r3)     // Catch:{ Exception -> 0x02c1 }
            r3 = r22
            r0.append(r3)     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02c1 }
            r2.mark = r0     // Catch:{ Exception -> 0x02c1 }
            goto L_0x0243
        L_0x023f:
            java.lang.String r0 = "-1"
            r2.mark = r0     // Catch:{ Exception -> 0x02c1 }
        L_0x0243:
            r1.m37334b(r2, r4, r9)     // Catch:{ Exception -> 0x02c1 }
            boolean r0 = r21.isEmpty()     // Catch:{ Exception -> 0x02c1 }
            if (r0 == 0) goto L_0x0253
            java.lang.String r0 = "NO_BEST_PIC"
            java.lang.String r2 = "活体检测失败,没有最佳图片"
            r1.m37331a((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x02c1 }
        L_0x0253:
            int r0 = r20.size()     // Catch:{ Exception -> 0x02c1 }
            int r2 = r1.f49853k     // Catch:{ Exception -> 0x02c1 }
            if (r0 >= r2) goto L_0x0280
            java.lang.String r2 = "ACTION_PIC_NOT_ENOUGH"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02c1 }
            r3.<init>()     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r4 = "动作图片与要求不符,（"
            r3.append(r4)     // Catch:{ Exception -> 0x02c1 }
            r3.append(r0)     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r0 = "/"
            r3.append(r0)     // Catch:{ Exception -> 0x02c1 }
            int r0 = r1.f49853k     // Catch:{ Exception -> 0x02c1 }
            r3.append(r0)     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r0 = ")"
            r3.append(r0)     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x02c1 }
            r1.m37331a((java.lang.String) r2, (java.lang.String) r0)     // Catch:{ Exception -> 0x02c1 }
        L_0x0280:
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x02c1 }
            if (r0 != 0) goto L_0x0297
            boolean r0 = r6.contains(r12)     // Catch:{ Exception -> 0x02c1 }
            if (r0 == 0) goto L_0x0297
            int r0 = r6.length()     // Catch:{ Exception -> 0x02c1 }
            r2 = 1
            int r0 = r0 - r2
            r2 = 0
            java.lang.String r6 = r6.substring(r2, r0)     // Catch:{ Exception -> 0x02c1 }
        L_0x0297:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x02c1 }
            r0.<init>()     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r2 = "bioType"
            r3 = 2
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x02c1 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x02c1 }
            r11 = r18
            r2 = r19
            r0.put(r2, r11)     // Catch:{ Exception -> 0x02c1 }
            r0.put(r14, r6)     // Catch:{ Exception -> 0x02c1 }
            r6 = r16
            r2 = r17
            r0.put(r2, r6)     // Catch:{ Exception -> 0x02c1 }
            com.didichuxing.diface.core.DiFaceFacade r2 = com.didichuxing.diface.core.DiFaceFacade.getInstance()     // Catch:{ Exception -> 0x02c1 }
            java.lang.String r3 = "302"
            r2.report((java.lang.String) r3, (java.util.HashMap<java.lang.String, java.lang.Object>) r0)     // Catch:{ Exception -> 0x02c1 }
            goto L_0x02c5
        L_0x02c1:
            r0 = move-exception
            r0.printStackTrace()
        L_0x02c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.diface.biz.bioassay.self_liveness.CompareHelper.compare(com.didichuxing.sdk.alphaface.core.liveness.LivenessResult):void");
    }

    /* renamed from: a */
    private void m37330a(LivenessResult livenessResult) {
        String str;
        String str2;
        String str3;
        String str4;
        try {
            CompareParam compareParam = new CompareParam();
            compareParam.token = this.f49850h.token;
            compareParam.sessionId = DiFaceFacade.getInstance().getSessionId();
            compareParam.language = DiFaceFacade.getInstance().getLanguage();
            HashMap hashMap = new HashMap();
            hashMap.put("model", SystemUtil.getModel());
            hashMap.put(AdParams.USER_AGENT, String.format("Android/%s %s/%s", new Object[]{Build.VERSION.RELEASE, this.f49849g.getApplicationContext().getPackageName(), SystemUtil.getVersionName(this.f49849g.getApplicationContext())}));
            hashMap.put("brand", Build.BRAND);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            List<ILivenessCallback.PicWithScore> bestPicList = livenessResult.getBestPicList();
            Iterator<ILivenessCallback.PicWithScore> it = bestPicList.iterator();
            String str5 = "";
            while (true) {
                boolean hasNext = it.hasNext();
                str = f49847e;
                if (!hasNext) {
                    break;
                }
                ILivenessCallback.PicWithScore next = it.next();
                arrayList.add(str);
                hashMap.put("faceImageQualityScore", Double.valueOf(next.qualityScore));
                File file = new File(this.f49849g.getFilesDir(), "bestPic.jpg");
                CompressUtils.compressRGBA(file, next);
                arrayList2.add(file);
                str5 = FileUtils.byteToMD5(next.rgba);
            }
            Iterator<ILivenessCallback.PicWithScore> it2 = livenessResult.getBestActionPicList().iterator();
            String str6 = "";
            while (true) {
                boolean hasNext2 = it2.hasNext();
                str2 = f49845c;
                if (!hasNext2) {
                    break;
                }
                ILivenessCallback.PicWithScore next2 = it2.next();
                arrayList.add(str2);
                hashMap.put("faceImage2QualityScore", Double.valueOf(next2.qualityScore));
                File file2 = new File(this.f49849g.getFilesDir(), "bestActionPic.jpg");
                CompressUtils.compressRGBA(file2, next2);
                LogUtils.m37051d("bestPic new size is: " + (file2.length() / 1024) + "KB");
                arrayList2.add(file2);
                str6 = FileUtils.byteToMD5(next2.rgba);
                bestPicList = bestPicList;
            }
            List<ILivenessCallback.PicWithScore> list = bestPicList;
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            List<ILivenessCallback.PicWithScore> attackPicList = livenessResult.getAttackPicList();
            String str7 = "";
            int i = 0;
            while (true) {
                str3 = str6;
                str4 = str2;
                if (i >= attackPicList.size()) {
                    break;
                }
                ILivenessCallback.PicWithScore picWithScore = attackPicList.get(i);
                String str8 = str5;
                StringBuilder sb = new StringBuilder();
                sb.append(f49846d);
                int i2 = i + 1;
                sb.append(i2);
                String sb2 = sb.toString();
                arrayList.add(sb2);
                String str9 = str;
                List<ILivenessCallback.PicWithScore> list2 = attackPicList;
                try {
                    jSONArray.put(picWithScore.qualityScore);
                    jSONArray2.put(picWithScore.attackScore);
                } catch (Exception e) {
                    LogUtils.logStackTrace(e);
                }
                File file3 = new File(this.f49849g.getFilesDir(), sb2 + ".jpg");
                CompressUtils.compressRGBA(file3, picWithScore);
                arrayList2.add(file3);
                str7 = str7 + FileUtils.byteToMD5(picWithScore.rgba) + ParamKeys.SIGN_AND;
                i = i2;
                str6 = str3;
                str2 = str4;
                str5 = str8;
                str = str9;
                attackPicList = list2;
            }
            String str10 = str5;
            String str11 = str;
            List<ILivenessCallback.PicWithScore> list3 = attackPicList;
            hashMap.put("suspectImageQualityScore", jSONArray);
            hashMap.put("suspectImageAttackScore", jSONArray2);
            compareParam.buildExtra(hashMap);
            List<ILivenessCallback.PicWithScore> waterPicList = livenessResult.getWaterPicList();
            if (waterPicList != null) {
                arrayList.add(f49848f);
                File file4 = new File(this.f49849g.getFilesDir(), "markPic.jpg");
                CompressUtils.compressRGBA(file4, waterPicList.get(0));
                arrayList2.add(file4);
                if (waterPicList.get(0).qualityOk == 1.0d) {
                    compareParam.mark = this.f49850h.data.result.getWaterMarking() + "";
                } else {
                    compareParam.mark = "-1";
                }
            }
            m37326a(compareParam, (List<String>) arrayList, (List<File>) arrayList2);
            if (list.isEmpty()) {
                m37331a(f49843a, "活体检测失败,没有最佳图片");
            }
            int size = list3.size();
            if (size < this.f49853k) {
                m37331a(f49844b, "动作图片与要求不符,（" + size + "/" + this.f49853k + ")");
            }
            if (!TextUtils.isEmpty(str7) && str7.contains(ParamKeys.SIGN_AND)) {
                str7 = str7.substring(0, str7.length() - 1);
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("bioType", 2);
            hashMap2.put(str11, str10);
            hashMap2.put(f49846d, str7);
            hashMap2.put(str4, str3);
            DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_UPLOAD_PRE_PICTURES, (HashMap<String, Object>) hashMap2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37326a(final CompareParam compareParam, final List<String> list, final List<File> list2) {
        RoundMaskLiveness roundMaskLiveness = this.f49851i;
        if (roundMaskLiveness != null) {
            roundMaskLiveness.onFaceOk();
        }
        this.f49849g.changeTipStatus();
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_COMPARE_REQUEST_LAUNCH, DiFaceLogger.setBioType((HashMap<String, Object>) null, "3"));
        new RealCompareModel(this.f49849g).compare(compareParam, list, list2, new AbsHttpCallback<CompareResult>() {
            public void onSuccess(CompareResult compareResult) {
                if (!CompareHelper.this.f49849g.isFinishing()) {
                    CompareHelper.this.f49851i.cancelRectAnim();
                    CompareHelper.this.f49849g.uploadVideo();
                    DFileUtils.delFiles(list2);
                    int i = compareResult.data.code;
                    String str = compareResult.data.message;
                    String str2 = compareResult.data.result.session_id;
                    new HashMap().put("code", Integer.valueOf(i));
                    DiFaceFacade.getInstance().reportEventWithCode("16", i);
                    if (i == 100000) {
                        CompareHelper.this.f49849g.finishWithResult(new DiFaceResult(0, str));
                        return;
                    }
                    String str3 = compareResult.data.result.show_appeal_entry ? compareResult.data.result.appealInfo.faceSessionId : "";
                    AppealParam appealParam = new AppealParam();
                    appealParam.token = CompareHelper.this.f49850h.token;
                    appealParam.faceSessionId = str3;
                    appealParam.country = CompareHelper.this.f49850h.data.result.country;
                    appealParam.bizCode = CompareHelper.this.f49850h.bizCode;
                    CompareHelper.this.m37325a(i, str, appealParam);
                }
            }

            public void onFailed(int i, String str) {
                if (!CompareHelper.this.f49849g.isFinishing()) {
                    if (CompareHelper.this.f49852j) {
                        boolean unused = CompareHelper.this.f49852j = false;
                        if (!CompareHelper.this.f49849g.isFinishing()) {
                            CompareHelper.this.f49849g.uploadVideo();
                        }
                        DFileUtils.delFiles(list2);
                        CompareHelper.this.f49849g.finishWithResult(new DiFaceResult(3, str));
                    } else if (NetworkUtils.isNetworkConnected(CompareHelper.this.f49849g)) {
                        boolean unused2 = CompareHelper.this.f49852j = true;
                        CompareHelper.this.m37326a(compareParam, (List<String>) list, (List<File>) list2);
                    } else {
                        if (!CompareHelper.this.f49849g.isFinishing()) {
                            CompareHelper.this.f49849g.uploadVideo();
                        }
                        DFileUtils.delFiles(list2);
                        CompareHelper.this.m37324a(112, ResUtils.getString(R.string.df_no_net_connected_toast));
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m37334b(final CompareParam compareParam, final List<String> list, final List<MultiSerializerForAccessSecurity.MemJpg> list2) {
        RoundMaskLiveness roundMaskLiveness = this.f49851i;
        if (roundMaskLiveness != null) {
            roundMaskLiveness.onFaceOk();
        }
        this.f49849g.changeTipStatus();
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_COMPARE_REQUEST_LAUNCH, DiFaceLogger.setBioType((HashMap<String, Object>) null, "3"));
        new CompareModel(this.f49849g).compare(compareParam, list, list2, new AbsHttpCallback<CompareResult>() {
            public void onSuccess(CompareResult compareResult) {
                if (!CompareHelper.this.f49849g.isFinishing()) {
                    CompareHelper.this.f49851i.cancelRectAnim();
                    CompareHelper.this.f49849g.uploadVideo();
                    int i = compareResult.data.code;
                    String str = compareResult.data.message;
                    String str2 = compareResult.data.result.session_id;
                    new HashMap().put("code", Integer.valueOf(i));
                    DiFaceFacade.getInstance().reportEventWithCode("16", i);
                    if (i == 100000) {
                        CompareHelper.this.f49849g.finishWithResult(new DiFaceResult(0, str));
                        return;
                    }
                    String str3 = compareResult.data.result.show_appeal_entry ? compareResult.data.result.appealInfo.faceSessionId : "";
                    AppealParam appealParam = new AppealParam();
                    appealParam.token = CompareHelper.this.f49850h.token;
                    appealParam.faceSessionId = str3;
                    appealParam.country = CompareHelper.this.f49850h.data.result.country;
                    appealParam.bizCode = CompareHelper.this.f49850h.bizCode;
                    CompareHelper.this.m37325a(i, str, appealParam);
                }
            }

            public void onFailed(int i, String str) {
                if (!CompareHelper.this.f49849g.isFinishing()) {
                    if (CompareHelper.this.f49852j) {
                        boolean unused = CompareHelper.this.f49852j = false;
                        if (!CompareHelper.this.f49849g.isFinishing()) {
                            CompareHelper.this.f49849g.uploadVideo();
                        }
                        CompareHelper.this.f49849g.finishWithResult(new DiFaceResult(3, str));
                    } else if (NetworkUtils.isNetworkConnected(CompareHelper.this.f49849g)) {
                        boolean unused2 = CompareHelper.this.f49852j = true;
                        CompareHelper.this.m37334b(compareParam, list, list2);
                    } else {
                        if (!CompareHelper.this.f49849g.isFinishing()) {
                            CompareHelper.this.f49849g.uploadVideo();
                        }
                        CompareHelper.this.m37324a(112, ResUtils.getString(R.string.df_no_net_connected_toast));
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37324a(int i, String str) {
        DFBioassayFailedAct.start(this.f49849g, i, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37325a(int i, String str, AppealParam appealParam) {
        DFBioassayFailedAct.start(this.f49849g, i, str, appealParam);
    }

    /* renamed from: a */
    private void m37331a(String str, String str2) {
        ReportFailedParam reportFailedParam = new ReportFailedParam();
        reportFailedParam.aliveErrorCode = str;
        reportFailedParam.aliveErrorMsg = str2;
        reportFailedParam.token = this.f49850h.token;
        reportFailedParam.sessionId = DiFaceFacade.getInstance().getSessionId();
        new ReportFailedModel(this.f49849g).report(reportFailedParam, new AbsHttpCallback<ReportFailedResult>() {
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
}
