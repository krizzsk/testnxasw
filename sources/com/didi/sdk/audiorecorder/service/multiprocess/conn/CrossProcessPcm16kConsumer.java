package com.didi.sdk.audiorecorder.service.multiprocess.conn;

import com.didi.sdk.audiorecorder.IGetDataServerAddressCallback;
import com.didi.sdk.audiorecorder.helper.recorder.Supporter;
import com.didi.sdk.audiorecorder.service.multiprocess.socket.DataTransferClient;
import com.didi.sdk.audiorecorder.utils.TextUtil;

public class CrossProcessPcm16kConsumer extends IGetDataServerAddressCallback.Stub implements DataTransferClient.DataReceivedListener {

    /* renamed from: a */
    private DataTransferClient f38234a;

    /* renamed from: b */
    private Supporter.Pcm16kConsumer f38235b;

    /* renamed from: c */
    private String f38236c;

    CrossProcessPcm16kConsumer() {
        DataTransferClient dataTransferClient = new DataTransferClient((String) null, 6400);
        this.f38234a = dataTransferClient;
        dataTransferClient.addDataReceivedListener(this);
    }

    public void setInnerConsumer(Supporter.Pcm16kConsumer pcm16kConsumer) {
        this.f38235b = pcm16kConsumer;
        m28837a();
    }

    /* renamed from: a */
    private void m28837a() {
        if (this.f38235b == null || TextUtil.isEmpty(this.f38236c)) {
            m28838a((String) null);
            this.f38234a.disconnect();
            return;
        }
        this.f38234a.connect();
    }

    public void onReceived(byte[] bArr, int i) {
        Supporter.Pcm16kConsumer pcm16kConsumer = this.f38235b;
        if (pcm16kConsumer != null) {
            pcm16kConsumer.onPcm16kFeed(bArr, i);
        }
    }

    public void onGetAddress(String str) {
        m28838a(str);
        m28837a();
    }

    /* renamed from: a */
    private void m28838a(String str) {
        this.f38236c = str;
        this.f38234a.updateServerName(str);
    }
}
