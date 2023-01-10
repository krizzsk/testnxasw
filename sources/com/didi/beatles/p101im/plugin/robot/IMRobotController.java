package com.didi.beatles.p101im.plugin.robot;

import android.text.TextUtils;
import com.didi.beatles.p101im.plugin.robot.net.IMRobotStore;
import com.didi.beatles.p101im.plugin.robot.net.callback.IMRobotConfigureCallback;
import com.didi.beatles.p101im.plugin.robot.net.callback.IMRobotPraiseListCallback;
import com.didi.beatles.p101im.plugin.robot.net.callback.IMRobotUnlockCallback;
import com.didi.beatles.p101im.plugin.robot.net.request.IMSendRobotMessageContent;
import com.didi.beatles.p101im.plugin.robot.net.response.IMRobotGetConfigureResponse;
import com.didi.beatles.p101im.plugin.robot.net.response.IMRobotPraise;
import com.didi.beatles.p101im.plugin.robot.net.response.IMRobotUnlockRobotResponse;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMLog;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.beatles.im.plugin.robot.IMRobotController */
public class IMRobotController {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f11313a = IMRobotController.class.getSimpleName();

    /* renamed from: b */
    private static final int f11314b = -1;

    /* renamed from: c */
    private static final int f11315c = 4;

    /* renamed from: d */
    private static final int f11316d = 3;

    /* renamed from: e */
    private IMRobotStore f11317e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public IIMRobotPanelView f11318f;

    /* renamed from: g */
    private int f11319g = -1;

    public IMRobotController(IIMRobotPanelView iIMRobotPanelView, int i, long j, String str, String str2) {
        this.f11317e = new IMRobotStore(i, j, str, str2);
        this.f11318f = iIMRobotPanelView;
    }

    public void loadConfigure() {
        IIMRobotPanelView iIMRobotPanelView;
        if (this.f11317e == null || (iIMRobotPanelView = this.f11318f) == null) {
            IMLog.m10021e(f11313a, "[loadConfigure] Null store or panelView");
            return;
        }
        iIMRobotPanelView.onLoading();
        this.f11317e.loadConfigure(new IMRobotConfigureCallback() {
            public void onSucceed(IMRobotGetConfigureResponse.Body body) {
                IMLog.m10020d(IMRobotController.f11313a, "[loadConfigure] #onSucceed#");
                if (IMRobotController.this.f11318f != null) {
                    IMRobotController.this.f11318f.onLoadConfigureSuccess(body);
                }
            }

            public void onFailed() {
                IMLog.m10021e(IMRobotController.f11313a, "[loadConfigure] #onFailed#");
                if (IMRobotController.this.f11318f != null) {
                    IMRobotController.this.f11318f.onLoadConfigureFail();
                }
            }
        });
    }

    public void selectRobotItem(int i, boolean z) {
        this.f11319g = i;
        IMRobotGetConfigureResponse.Robot currentRobot = getCurrentRobot();
        if (currentRobot == null) {
            IMLog.m10021e(f11313a, C4786I.m9980t("[selectRobotItem] Null robot with index : ", Integer.valueOf(i)));
            return;
        }
        m9825a(currentRobot, nextPraise(currentRobot, false), z);
    }

    public IMRobotPraise getRobotPraise(int i) {
        IMRobotGetConfigureResponse.Robot robot = getRobot(i);
        if (robot != null) {
            return nextPraise(robot, false);
        }
        IMLog.m10021e(f11313a, C4786I.m9980t("[getRobotPraise] Null robot with index : ", Integer.valueOf(i)));
        return null;
    }

    public boolean switchPraise(int i) {
        int i2 = this.f11319g;
        if (i != i2) {
            IMLog.m10021e(f11313a, C4786I.m9980t("[switchPraise] Not selected item. currentItem=", Integer.valueOf(i2), " |index=", Integer.valueOf(i)));
            return false;
        }
        IMRobotGetConfigureResponse.Robot currentRobot = getCurrentRobot();
        if (currentRobot == null) {
            IMLog.m10021e(f11313a, C4786I.m9980t("[switchPraise] Null robot with index : ", Integer.valueOf(this.f11319g)));
            return false;
        }
        m9825a(currentRobot, nextPraise(currentRobot, true), false);
        return true;
    }

    public void unlockRobot() {
        if (this.f11317e == null || this.f11318f == null) {
            IMLog.m10021e(f11313a, "[shareRobot] Null store or panelView");
            return;
        }
        final IMRobotGetConfigureResponse.Robot currentRobot = getCurrentRobot();
        if (currentRobot == null) {
            IMLog.m10021e(f11313a, C4786I.m9980t("[shareRobot] Null robot with index : ", Integer.valueOf(this.f11319g)));
        } else if (TextUtils.isEmpty(currentRobot.robotId)) {
            IMLog.m10021e(f11313a, C4786I.m9980t("[shareRobot] Null robot id"));
        } else if (!IMRobotBridge.navigation(currentRobot.shareUrl)) {
            IMLog.m10021e(f11313a, C4786I.m9980t("[unlockRobot] invoke navigation fail. shareUrl=", currentRobot.shareUrl));
        } else {
            this.f11317e.unlockRobot(currentRobot.robotId, new IMRobotUnlockCallback() {
                public void onSucceed(IMRobotUnlockRobotResponse.Body body) {
                    IMLog.m10020d(IMRobotController.f11313a, "[unlockRobot] #onSucceed#");
                    currentRobot.praiseList = body.praiseList;
                    currentRobot.canLoadPraiseList = false;
                    currentRobot.isLock = 0;
                    IMRobotGetConfigureResponse.Robot robot = currentRobot;
                    robot.guidePraiseIndex = robot.guidePraiseList != null ? currentRobot.guidePraiseList.size() : -1;
                    if (IMRobotController.this.f11318f != null) {
                        IMRobotController.this.f11318f.onUnlockRobotSuccess(currentRobot);
                    }
                }

                public void onFailed() {
                    IMLog.m10021e(IMRobotController.f11313a, "[unlockRobot] #onFailed#");
                    if (IMRobotController.this.f11318f != null) {
                        IMRobotController.this.f11318f.onUnlockRobotFailed();
                    }
                }
            });
        }
    }

    public void sendRobotMessage(IMRobotPraise iMRobotPraise, boolean z) {
        if (iMRobotPraise == null) {
            IMLog.m10020d(f11313a, C4786I.m9980t("[sendRobotMessage] Null praise"));
            return;
        }
        IMLog.m10020d(f11313a, C4786I.m9980t("[sendRobotMessage] isAnon=", Boolean.valueOf(z), " |praiseId=", iMRobotPraise.praiseId));
        IMRobotGetConfigureResponse.Robot currentRobot = getCurrentRobot();
        if (currentRobot == null) {
            IMLog.m10021e(f11313a, C4786I.m9980t("[sendRobotMessage] Null robot with index : ", Integer.valueOf(this.f11319g)));
        } else if (TextUtils.isEmpty(currentRobot.robotId)) {
            IMLog.m10021e(f11313a, C4786I.m9980t("[sendRobotMessage] Null robot id"));
        } else {
            IMSendRobotMessageContent iMSendRobotMessageContent = new IMSendRobotMessageContent();
            iMSendRobotMessageContent.isAnon = z ? 1 : 0;
            iMSendRobotMessageContent.praiseId = iMRobotPraise.praiseId;
            iMSendRobotMessageContent.robotId = currentRobot.robotId;
            iMSendRobotMessageContent.title = currentRobot.title;
            iMSendRobotMessageContent.text = iMRobotPraise.text;
            iMSendRobotMessageContent.cardImg = currentRobot.cardImg;
            iMSendRobotMessageContent.voice = iMRobotPraise.voice;
            iMSendRobotMessageContent.shareUrl = currentRobot.shareUrl;
            iMSendRobotMessageContent.shareBtnText = m9826b();
            iMSendRobotMessageContent.orderId = IMRobotConstant.getOrderId();
            IMRobotBridge.sendPluginMessage(iMSendRobotMessageContent, iMRobotPraise.text, currentRobot.eid);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004c, code lost:
        if (r3 >= (r9.praiseList != null ? r9.praiseList.size() : 0)) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004f, code lost:
        if (r3 < 0) goto L_0x0051;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.beatles.p101im.plugin.robot.net.response.IMRobotPraise nextPraise(com.didi.beatles.p101im.plugin.robot.net.response.IMRobotGetConfigureResponse.Robot r9, boolean r10) {
        /*
            r8 = this;
            int r0 = r9.guidePraiseIndex
            int r1 = r9.praiseIndex
            int r2 = r9.guidePraiseIndex
            java.util.List<com.didi.beatles.im.plugin.robot.net.response.IMRobotPraise> r3 = r9.guidePraiseList
            r4 = 0
            if (r3 == 0) goto L_0x0012
            java.util.List<com.didi.beatles.im.plugin.robot.net.response.IMRobotPraise> r3 = r9.guidePraiseList
            int r3 = r3.size()
            goto L_0x0013
        L_0x0012:
            r3 = 0
        L_0x0013:
            if (r10 == 0) goto L_0x001a
            if (r2 >= r3) goto L_0x001d
            int r2 = r2 + 1
            goto L_0x001d
        L_0x001a:
            if (r2 >= 0) goto L_0x001d
            r2 = 0
        L_0x001d:
            r9.guidePraiseIndex = r2
            java.util.List<com.didi.beatles.im.plugin.robot.net.response.IMRobotPraise> r3 = r9.guidePraiseList
            if (r3 == 0) goto L_0x0036
            if (r2 < 0) goto L_0x0036
            java.util.List<com.didi.beatles.im.plugin.robot.net.response.IMRobotPraise> r3 = r9.guidePraiseList
            int r3 = r3.size()
            if (r2 >= r3) goto L_0x0036
            java.util.List<com.didi.beatles.im.plugin.robot.net.response.IMRobotPraise> r3 = r9.guidePraiseList
            java.lang.Object r2 = r3.get(r2)
            com.didi.beatles.im.plugin.robot.net.response.IMRobotPraise r2 = (com.didi.beatles.p101im.plugin.robot.net.response.IMRobotPraise) r2
            goto L_0x0037
        L_0x0036:
            r2 = 0
        L_0x0037:
            int r3 = r9.praiseIndex
            r5 = 4
            if (r2 != 0) goto L_0x0089
            if (r10 == 0) goto L_0x004f
            int r3 = r3 + 1
            java.util.List<com.didi.beatles.im.plugin.robot.net.response.IMRobotPraise> r6 = r9.praiseList
            if (r6 == 0) goto L_0x004b
            java.util.List<com.didi.beatles.im.plugin.robot.net.response.IMRobotPraise> r6 = r9.praiseList
            int r6 = r6.size()
            goto L_0x004c
        L_0x004b:
            r6 = 0
        L_0x004c:
            if (r3 < r6) goto L_0x0052
            goto L_0x0051
        L_0x004f:
            if (r3 >= 0) goto L_0x0052
        L_0x0051:
            r3 = 0
        L_0x0052:
            r9.praiseIndex = r3
            java.util.List<com.didi.beatles.im.plugin.robot.net.response.IMRobotPraise> r6 = r9.praiseList
            if (r6 == 0) goto L_0x0089
            if (r3 < 0) goto L_0x0089
            java.util.List<com.didi.beatles.im.plugin.robot.net.response.IMRobotPraise> r6 = r9.praiseList
            int r6 = r6.size()
            if (r3 >= r6) goto L_0x0089
            java.util.List<com.didi.beatles.im.plugin.robot.net.response.IMRobotPraise> r2 = r9.praiseList
            java.lang.Object r2 = r2.get(r3)
            com.didi.beatles.im.plugin.robot.net.response.IMRobotPraise r2 = (com.didi.beatles.p101im.plugin.robot.net.response.IMRobotPraise) r2
            if (r10 == 0) goto L_0x0089
            boolean r6 = r9.canLoadPraiseList
            if (r6 == 0) goto L_0x0089
            boolean r6 = r9.isLock()
            if (r6 != 0) goto L_0x0089
            java.util.List<com.didi.beatles.im.plugin.robot.net.response.IMRobotPraise> r6 = r9.praiseList
            int r6 = r6.size()
            int r6 = r6 - r3
            if (r6 >= r5) goto L_0x0089
            java.lang.String r3 = f11313a
            java.lang.String r6 = "[nextPraise] trigger load praise list"
            com.didi.beatles.p101im.utils.IMLog.m10020d(r3, r6)
            r8.m9824a((com.didi.beatles.p101im.plugin.robot.net.response.IMRobotGetConfigureResponse.Robot) r9)
        L_0x0089:
            java.lang.String r3 = f11313a
            r6 = 12
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.String r7 = "[nextPraise] robotId="
            r6[r4] = r7
            java.lang.String r4 = r9.robotId
            r7 = 1
            r6[r7] = r4
            r4 = 2
            java.lang.String r7 = " |needUpdate="
            r6[r4] = r7
            r4 = 3
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            r6[r4] = r10
            java.lang.String r10 = " |tempIndex="
            r6[r5] = r10
            r10 = 5
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r6[r10] = r1
            r10 = 6
            java.lang.String r1 = " |tempGuideIndex="
            r6[r10] = r1
            r10 = 7
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r6[r10] = r0
            r10 = 8
            java.lang.String r0 = " |praiseIndex="
            r6[r10] = r0
            r10 = 9
            int r0 = r9.praiseIndex
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r6[r10] = r0
            r10 = 10
            java.lang.String r0 = " |praiseGuideIndex="
            r6[r10] = r0
            r10 = 11
            int r0 = r9.guidePraiseIndex
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r6[r10] = r0
            java.lang.String r10 = com.didi.beatles.p101im.utils.C4786I.m9980t(r6)
            com.didi.beatles.p101im.utils.IMLog.m10020d(r3, r10)
            if (r2 == 0) goto L_0x00f0
            java.lang.String r10 = r2.btnText
            if (r10 != 0) goto L_0x00f0
            int r10 = r2.type
            java.lang.String r10 = r8.m9823a((int) r10)
            r2.btnText = r10
        L_0x00f0:
            if (r2 == 0) goto L_0x00f6
            java.lang.String r9 = r9.robotId
            r2.robotId = r9
        L_0x00f6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p101im.plugin.robot.IMRobotController.nextPraise(com.didi.beatles.im.plugin.robot.net.response.IMRobotGetConfigureResponse$Robot, boolean):com.didi.beatles.im.plugin.robot.net.response.IMRobotPraise");
    }

    /* renamed from: a */
    private void m9824a(final IMRobotGetConfigureResponse.Robot robot) {
        IMLog.m10020d(f11313a, C4786I.m9980t("[loadPraiseList] robot=", robot.robotId));
        if (TextUtils.isEmpty(robot.robotId)) {
            robot.canLoadPraiseList = false;
            IMLog.m10021e(f11313a, "[loadPraiseList] null robot id");
            return;
        }
        robot.loadPraiseRetryCount++;
        this.f11317e.loadPraiseList(robot.robotId, new IMRobotPraiseListCallback() {
            public void onSucceed(List<IMRobotPraise> list) {
                IMLog.m10020d(IMRobotController.f11313a, "[loadPraiseList] #onSucceed#");
                robot.canLoadPraiseList = false;
                if (list != null) {
                    if (robot.praiseList == null) {
                        robot.praiseList = new ArrayList();
                    }
                    robot.praiseList.addAll(list);
                }
            }

            public void onFailed() {
                IMLog.m10021e(IMRobotController.f11313a, C4786I.m9980t("[loadPraiseList] #onFailed# loadPraiseRetryCount=", Integer.valueOf(robot.loadPraiseRetryCount)));
                if (robot.loadPraiseRetryCount > 3) {
                    robot.canLoadPraiseList = false;
                }
            }
        });
    }

    /* renamed from: a */
    private void m9825a(IMRobotGetConfigureResponse.Robot robot, IMRobotPraise iMRobotPraise, boolean z) {
        IIMRobotPanelView iIMRobotPanelView = this.f11318f;
        if (iIMRobotPanelView != null) {
            iIMRobotPanelView.onUpdatePraise(robot, iMRobotPraise, z);
        }
    }

    public IMRobotGetConfigureResponse.Robot getCurrentRobot() {
        return getRobot(this.f11319g);
    }

    public IMRobotGetConfigureResponse.Robot getRobot(int i) {
        return this.f11317e.getRobot(i);
    }

    /* renamed from: a */
    private String m9823a(int i) {
        return this.f11317e.getPraiseBtnText(i);
    }

    /* renamed from: b */
    private String m9826b() {
        IMRobotStore iMRobotStore = this.f11317e;
        if (iMRobotStore != null) {
            return iMRobotStore.getShareBtnText();
        }
        return null;
    }
}
