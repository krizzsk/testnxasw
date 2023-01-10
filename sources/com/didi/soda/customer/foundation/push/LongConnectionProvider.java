package com.didi.soda.customer.foundation.push;

import android.content.Context;
import com.didi.foundation.sdk.liveconnection.ConnectionListener;
import com.didi.foundation.sdk.liveconnection.LogListener;
import com.didi.foundation.sdk.liveconnection.MessageListener;
import com.didi.foundation.sdk.liveconnection.Option;
import com.didi.foundation.sdk.liveconnection.Request;
import com.didi.soda.customer.foundation.push.base.BaseLongConnectionService;

public final class LongConnectionProvider {
    public static final int COMMON_TOPIC = 3793;
    public static final int OUTER_TOPIC = 601;
    public static final int PAY_TOPIC = 2304;

    /* renamed from: a */
    private BaseLongConnectionService f43541a;

    private LongConnectionProvider() {
        this.f43541a = new BaseLongConnectionService();
    }

    public static LongConnectionProvider getInstance() {
        return Holder.PROVIDER;
    }

    public void init(Context context, Option option) {
        this.f43541a.init(context, option);
    }

    public boolean isConnected() {
        return this.f43541a.isConnected();
    }

    public void registerConnectListener(ConnectionListener connectionListener) {
        this.f43541a.registerConnectListener(connectionListener);
    }

    public void registerMessageListener(MessageListener messageListener) {
        this.f43541a.registerMessageListener(messageListener);
    }

    public void release() {
        this.f43541a.release();
    }

    public void sendRequest(Request request) {
        this.f43541a.sendRequest(request);
    }

    public void setLogListener(LogListener logListener) {
        this.f43541a.setLogListener(logListener);
    }

    public void startConnect() {
        this.f43541a.startConnect();
    }

    public void stopConnect() {
        this.f43541a.stopConnect();
    }

    public void unRegisterMessageListener(MessageListener messageListener) {
        this.f43541a.unRegisterMessageListener(messageListener);
    }

    public void unregisterConnectionListener(ConnectionListener connectionListener) {
        this.f43541a.unregisterConnectionListener(connectionListener);
    }

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final LongConnectionProvider PROVIDER = new LongConnectionProvider();

        private Holder() {
        }
    }
}
