package com.didi.beatles.p101im.manager;

import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.api.entity.IMSendActionTipRequest;
import com.didi.beatles.p101im.module.IIMSessionModule;
import com.didi.beatles.p101im.module.IMSendActionTipCallback;
import com.didi.beatles.p101im.pref.IMPreference;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMLog;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.didi.beatles.im.manager.IMActionTipManager */
public class IMActionTipManager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f11063a = IMActionTipManager.class.getSimpleName();

    /* renamed from: b */
    private static final int f11064b = 3;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Set<String> f11065c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Set<Long> f11066d;

    private IMActionTipManager() {
    }

    public static IMActionTipManager getInstance() {
        return Holder.INSTANCE;
    }

    public void onSystemActionsUpdated(int i, long j, long j2, List<Integer> list) {
        if (j != 0 && list != null && !list.isEmpty()) {
            for (Integer intValue : list) {
                if (intValue.intValue() == 1) {
                    m9630a(i, j, j2);
                }
            }
        }
    }

    /* renamed from: a */
    private void m9630a(int i, long j, long j2) {
        if (!IMContextInfoHelper.enableSendImage()) {
            IMLog.m10020d(f11063a, C4786I.m9980t("[onTakePhotoActionUpdate] disable send image"));
            return;
        }
        if (this.f11065c == null) {
            this.f11065c = IMPreference.getInstance(IMContextInfoHelper.getContext()).getTakPhotoActionTip(IMContextInfoHelper.getUid());
        }
        if (this.f11065c == null) {
            this.f11065c = new HashSet();
        }
        Set<Long> set = this.f11066d;
        if (set == null || !set.contains(Long.valueOf(j))) {
            final int size = this.f11065c.size();
            if (size >= 3) {
                IMLog.m10020d(f11063a, C4786I.m9980t("[onTakePhotoActionUpdate] Reach max count ->", Integer.valueOf(size)));
            } else if (this.f11065c.contains(String.valueOf(j))) {
                IMLog.m10020d(f11063a, C4786I.m9980t("[onTakePhotoActionUpdate] Tip has showed for session ->", Long.valueOf(j)));
            } else {
                if (this.f11066d == null) {
                    this.f11066d = new HashSet();
                }
                this.f11066d.add(Long.valueOf(j));
                IIMSessionModule sessionModel = IMManager.getInstance().getSessionModel();
                if (sessionModel != null) {
                    final long j3 = j;
                    sessionModel.sendActionTipRequest(i, IMContextInfoHelper.getUid(), j2, IMSendActionTipRequest.ACTION_SEND_IMAGE, size, new IMSendActionTipCallback() {
                        public void onSucceed() {
                            IMLog.m10020d(IMActionTipManager.f11063a, C4786I.m9980t("[onTakePhotoActionUpdate] send action tip success. tipCount ->", Integer.valueOf(size)));
                            IMActionTipManager.this.f11065c.add(String.valueOf(j3));
                            IMPreference.getInstance(IMContextInfoHelper.getContext()).setTakePhotoActionTip(IMContextInfoHelper.getUid(), IMActionTipManager.this.f11065c);
                            IMActionTipManager.this.f11066d.remove(Long.valueOf(j3));
                        }

                        public void onFailed() {
                            IMActionTipManager.this.f11066d.remove(Long.valueOf(j3));
                            IMLog.m10020d(IMActionTipManager.f11063a, C4786I.m9980t("[onTakePhotoActionUpdate] send action tip failed. "));
                        }
                    });
                }
            }
        } else {
            IMLog.m10020d(f11063a, C4786I.m9980t("[onTakePhotoActionUpdate] Session is requesting action tip. ->", Long.valueOf(j)));
        }
    }

    /* renamed from: com.didi.beatles.im.manager.IMActionTipManager$Holder */
    private static final class Holder {
        /* access modifiers changed from: private */
        public static final IMActionTipManager INSTANCE = new IMActionTipManager();

        private Holder() {
        }
    }
}
