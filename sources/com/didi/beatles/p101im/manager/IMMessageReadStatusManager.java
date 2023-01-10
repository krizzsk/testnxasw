package com.didi.beatles.p101im.manager;

import com.didi.beatles.p101im.event.IMMessageUpdateReadStatusEvent;
import com.didi.beatles.p101im.module.entity.IMMessage;
import com.didi.beatles.p101im.module.impl.IMMessageModule;
import com.didi.beatles.p101im.task.IMTriggerList;
import com.didi.beatles.p101im.utils.IMLog;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.beatles.im.manager.IMMessageReadStatusManager */
public class IMMessageReadStatusManager {

    /* renamed from: a */
    private static final int f11096a = 2000;

    /* renamed from: b */
    private static final int f11097b = 60000;

    /* renamed from: d */
    private static IMMessageReadStatusManager f11098d = null;

    /* renamed from: e */
    private static final String f11099e = "IMMessageReadStatusManager";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public IMTriggerList<IMMessage> f11100c;

    public static synchronized IMMessageReadStatusManager getInstance() {
        IMMessageReadStatusManager iMMessageReadStatusManager;
        synchronized (IMMessageReadStatusManager.class) {
            if (f11098d == null) {
                f11098d = new IMMessageReadStatusManager();
            }
            iMMessageReadStatusManager = f11098d;
        }
        return iMMessageReadStatusManager;
    }

    private IMMessageReadStatusManager() {
        IMTriggerList<IMMessage> iMTriggerList = new IMTriggerList<>();
        this.f11100c = iMTriggerList;
        iMTriggerList.addTriggerListener(new IMTriggerList.IMTriggerListener<IMMessage>() {
            public boolean onTrigger(List<IMMessage> list, boolean z) {
                if (z) {
                    IMLog.m10024i(IMMessageReadStatusManager.f11099e, "report repeat,enlarge the interval,size is " + list.size());
                    IMMessageReadStatusManager.this.f11100c.setTriggerTime(60000);
                } else {
                    IMLog.m10024i(IMMessageReadStatusManager.f11099e, "report nomal,size is " + list.size());
                    IMMessageReadStatusManager.this.f11100c.setTriggerTime(2000);
                }
                EventBus.getDefault().post(new IMMessageUpdateReadStatusEvent(list));
                return false;
            }
        });
    }

    public void ackHasReadMsg(IMMessage iMMessage) {
        if (iMMessage != null) {
            IMMessageModule iMMessageModule = (IMMessageModule) IMManager.getInstance().getMessageModel();
            if (iMMessageModule == null) {
                IMLog.m10026w(f11099e, "IMMessageModule is null,ack has read msg failed!");
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(iMMessage.getMid()));
            iMMessageModule.pushMessageReadStatus(iMMessage.getSid(), arrayList);
            IMLog.m10020d(f11099e, "report at once");
        }
    }

    public void addHasReadMsg(IMMessage iMMessage) {
        if (this.f11100c != null) {
            IMLog.m10020d(f11099e, "offer one msg");
            this.f11100c.setTriggerTime(2000);
            this.f11100c.add(iMMessage);
        }
    }

    public void removeHasReportMsg() {
        IMTriggerList<IMMessage> iMTriggerList = this.f11100c;
        if (iMTriggerList != null) {
            iMTriggerList.removeHasExecuted();
        }
    }

    public void removeHasReportMsg(List<IMMessage> list) {
        if (this.f11100c != null && list != null) {
            IMLog.m10024i(f11099e, "remove msgs which are report success, size is " + list.size());
            this.f11100c.removeAll(list);
        }
    }

    public void reportByHand() {
        IMTriggerList<IMMessage> iMTriggerList = this.f11100c;
        if (iMTriggerList != null) {
            iMTriggerList.ExecuteAll(true);
            IMLog.m10020d(f11099e, "report unread msgs by hand");
        }
    }

    public void destory() {
        f11098d = null;
    }
}
