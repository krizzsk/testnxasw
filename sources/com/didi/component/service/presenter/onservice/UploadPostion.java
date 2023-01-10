package com.didi.component.service.presenter.onservice;

import android.os.Handler;
import android.os.Message;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.common.track.DidiTrackingClient;
import com.didi.component.common.util.GLog;
import com.didi.sdk.messagecenter.p153pb.PassengerState;
import com.didi.travel.psnger.common.push.PushManager;
import com.didi.travel.psnger.model.response.CarOrder;
import java.lang.ref.WeakReference;

public class UploadPostion {

    /* renamed from: a */
    private static final int f17657a = 1;

    /* renamed from: b */
    private static final int f17658b = 1001;

    /* renamed from: c */
    private CarOrder f17659c = CarOrderHelper.getOrder();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f17660d;

    /* renamed from: e */
    private UploadHandler f17661e = new UploadHandler();

    private static class UploadHandler extends Handler {
        private WeakReference<UploadPostion> ref;

        private UploadHandler(UploadPostion uploadPostion) {
            this.ref = new WeakReference<>(uploadPostion);
        }

        public void handleMessage(Message message) {
            if (this.ref.get() != null) {
                UploadPostion uploadPostion = (UploadPostion) this.ref.get();
                int i = message.what;
                if (i != 1) {
                    if (i == 1001) {
                        uploadPostion.doPositionSendForCheat();
                    }
                } else if (!uploadPostion.f17660d) {
                    uploadPostion.m14944a();
                    uploadPostion.m14946b();
                }
            }
        }
    }

    public void initPositionUpload() {
        GLog.m11360i("upload position", "call the initPositionUpload");
        this.f17660d = false;
        this.f17661e.postDelayed(new Runnable() {
            public void run() {
                UploadPostion.this.m14944a();
            }
        }, 1600);
    }

    public void requestPassengerPositionSend() {
        GLog.m11360i("upload position", "call the requestPassengerPositionSend");
        this.f17661e.removeMessages(1001);
        this.f17661e.sendEmptyMessageDelayed(1001, 5000);
    }

    public void cancelPostionSend() {
        GLog.m11360i("upload position", "call the cancelPostionSend");
        this.f17661e.removeMessages(1);
        this.f17660d = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14944a() {
        GLog.m11360i("upload position", "call the requestPositionSend");
        this.f17661e.removeMessages(1);
        this.f17661e.sendEmptyMessageDelayed(1, 3000);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m14946b() {
        if (this.f17659c != null) {
            GLog.m11360i("upload position", "call the doPositionSend to send the position");
            DidiTrackingClient.getInstance().callTrackingAtOnce(1);
        }
    }

    public void doPositionSendForCheat() {
        if (this.f17659c != null) {
            GLog.m11360i("upload position", "call the doPositionSendForCheat");
            PushManager.sendLocation(this.f17659c, false, PassengerState.PassengerStateNormal.getValue());
        }
    }
}
