package com.didi.sdk.messagecenter.adapter;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.messagecenter.deserializer.DeserializerFactory;
import com.didi.sdk.messagecenter.model.PushMessage;
import com.didi.sdk.messagecenter.model.UnifyMessage;
import com.didi.sdk.messagecenter.subscribe.Subscription;
import com.didi.sdk.messagecenter.util.MLog;
import com.didi.sdk.push.manager.DPushBody;
import com.didi.sdk.push.manager.DPushLisenter;
import com.didi.sdk.push.manager.DPushManager;
import com.didi.sdk.push.manager.DPushType;
import com.didichuxing.bigdata.p174dp.locsdk.Const;

public class PushListenerAdapter {

    /* renamed from: a */
    private DPushLisenter f39527a;

    /* renamed from: b */
    private Handler f39528b = new Handler(Looper.getMainLooper());
    public Subscription subscription;

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m29756b(DPushBody dPushBody, Subscription subscription2) {
        try {
            m29755a(dPushBody, subscription2);
        } catch (IncompatibleClassChangeError e) {
            Log.d("PushListenerAdapter", "dispatch error", e);
        }
    }

    public PushListenerAdapter(Subscription subscription2) {
        this.f39527a = m29751a(subscription2);
        this.subscription = subscription2;
        MLog.m29816i("register push listener: " + this.f39527a);
        DPushManager.getInstance().registerPush(this.f39527a);
    }

    public void release() {
        MLog.m29816i("unregister push listener: " + this.f39527a);
        DPushManager.getInstance().unregisterPush(this.f39527a);
    }

    /* renamed from: a */
    private DPushLisenter m29751a(Subscription subscription2) {
        return new DPushListenerAdapter(subscription2);
    }

    /* renamed from: a */
    private void m29755a(DPushBody dPushBody, final Subscription subscription2) {
        if (dPushBody == null || dPushBody.getData() == null || subscription2 == null) {
            MLog.m29817w("dispatch: pushBody or subscription is null");
            return;
        }
        MLog.m29816i("dispatch: " + subscription2.type + "|" + subscription2.subscriberTopic);
        final PushMessage deserialize = DeserializerFactory.getDeserializer(subscription2.subscriberMessageClz, subscription2.type).deserialize(dPushBody.getData(), subscription2.subscriberMessageClz);
        if (deserialize == null) {
            MLog.m29817w("dispatch: message is null");
        } else if (!(deserialize instanceof UnifyMessage) || ((UnifyMessage) deserialize).f39543id == subscription2.subscriberUnifyId) {
            this.f39528b.post(new Runnable() {
                public void run() {
                    MLog.m29814d("dispatch: will handle message");
                    try {
                        subscription2.messageHandler.handle(deserialize);
                    } catch (Exception e) {
                        MLog.m29815e("dispatch: catch error [" + e.getMessage() + Const.jaRight);
                        e.printStackTrace();
                    }
                }
            });
        } else {
            MLog.m29816i("dispatch: unify id match failed");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public DPushType m29753a(String str) {
        if (TextUtils.equals(str, DPushType.GEITUI_PUSH.getName())) {
            return DPushType.GEITUI_PUSH;
        }
        if (TextUtils.equals(str, DPushType.GEITUI_PUSH_MIS_CLICK.getName())) {
            return DPushType.GEITUI_PUSH_MIS_CLICK;
        }
        if (TextUtils.equals(str, DPushType.XIAOMI_PUSH.getName())) {
            return DPushType.XIAOMI_PUSH;
        }
        if (TextUtils.equals(str, DPushType.FCM_PUSH.getName())) {
            return DPushType.FCM_PUSH;
        }
        if (TextUtils.equals(str, DPushType.TENCENT_PUSH.getName())) {
            return DPushType.TENCENT_PUSH;
        }
        return DPushType.TENCENT_PUSH;
    }

    private class DPushListenerAdapter implements DPushLisenter {
        private Subscription subscription;

        public DPushListenerAdapter(Subscription subscription2) {
            this.subscription = subscription2;
        }

        public DPushType pushType() {
            return PushListenerAdapter.this.m29753a(this.subscription.type);
        }

        public void pushBody(DPushBody dPushBody) {
            PushListenerAdapter.this.m29756b(dPushBody, this.subscription);
        }

        public String topic() {
            return this.subscription.subscriberTopic;
        }
    }
}
