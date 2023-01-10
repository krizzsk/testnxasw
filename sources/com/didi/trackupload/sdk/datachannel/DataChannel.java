package com.didi.trackupload.sdk.datachannel;

import android.content.Context;
import com.didi.sdk.protobuf.BinaryMsg;
import com.didi.trackupload.sdk.Constants;
import com.didi.trackupload.sdk.TrackController;
import com.didi.trackupload.sdk.datachannel.protobuf.TrackUploadReq;
import com.didi.trackupload.sdk.utils.ApolloUtils;
import com.didi.trackupload.sdk.utils.LocUtils;
import com.didi.trackupload.sdk.utils.NetworkUtils;
import com.didi.trackupload.sdk.utils.TrackLog;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import okio.ByteString;

public class DataChannel implements IDataChannelMsgCallback {

    /* renamed from: a */
    private static final String f46623a = "DataChannel";

    /* renamed from: b */
    private static final long f46624b = 16000;

    /* renamed from: f */
    private static boolean f46625f = ApolloUtils.isAllowHttpUpload();

    /* renamed from: c */
    private SendMessageThreadLocal f46626c;

    /* renamed from: d */
    private Context f46627d;

    /* renamed from: e */
    private HttpSender f46628e;

    private DataChannel() {
        this.f46626c = new SendMessageThreadLocal();
    }

    private static class SingletonHolder {
        static final DataChannel INSTANCE = new DataChannel();

        private SingletonHolder() {
        }
    }

    public static DataChannel getIntance() {
        return SingletonHolder.INSTANCE;
    }

    public void init(Context context) {
        this.f46627d = context;
        IDataChannel dataChannel = TrackController.getIntance().getInitParams().getDataChannel();
        if (Constants.DEBUG && dataChannel != null) {
            dataChannel.setMsgCallback(this);
        }
        this.f46628e = new HttpSender(this.f46627d);
        TrackLog.m34830d(f46623a, "use http:" + f46625f);
    }

    public boolean isConnected() {
        return m34792a() || (f46625f && NetworkUtils.isNetworkConnected(this.f46627d));
    }

    /* renamed from: a */
    private boolean m34792a() {
        IDataChannel dataChannel = TrackController.getIntance().getInitParams().getDataChannel();
        return dataChannel != null && dataChannel.isConnected();
    }

    public SendResult sendMessage(TrackUploadReq trackUploadReq, long j, String str) {
        byte[] bArr;
        int i = 0;
        SendResult sendResult = new SendResult(-1, SendResult.DETAIL_ERR_CODE_PB_2_BYTES, 0);
        if (m34792a()) {
            bArr = m34794a(m34790a(trackUploadReq, j | 8));
            StringBuilder sb = new StringBuilder();
            sb.append("bytes.size=");
            sb.append(bArr == null ? 0 : bArr.length);
            TrackLog.m34830d(f46623a, sb.toString());
            if (bArr != null) {
                sendResult = sendMessageByPushAsync(bArr);
            }
        } else if (f46625f) {
            bArr = m34794a(m34790a(trackUploadReq, j | 16));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("bytes.size=");
            sb2.append(bArr == null ? 0 : bArr.length);
            TrackLog.m34830d(f46623a, sb2.toString());
            if (bArr != null) {
                sendResult = m34789a(bArr, str);
            }
        } else {
            sendResult = new SendResult(-1, 0);
            bArr = null;
        }
        if (bArr != null) {
            i = bArr.length;
        }
        sendResult.setBytesLength(i);
        return sendResult;
    }

    /* renamed from: a */
    private byte[] m34794a(TrackUploadReq trackUploadReq) {
        try {
            return trackUploadReq.toByteArray();
        } catch (Exception e) {
            TrackLog.m34830d(f46623a, "req 2 bytes exception, msg=" + e.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    private TrackUploadReq m34790a(TrackUploadReq trackUploadReq, long j) {
        return new TrackUploadReq.Builder(trackUploadReq).loc(LocUtils.addTrackFlag(trackUploadReq.loc, j)).build();
    }

    /* renamed from: a */
    private SendResult m34789a(byte[] bArr, String str) {
        return this.f46628e.mo115991a(bArr, str);
    }

    public SendResult sendMessageByPushSync(byte[] bArr) {
        SendMessageLatch sendMessageLatch = new SendMessageLatch();
        this.f46626c.set(sendMessageLatch);
        BigInteger a = m34791a(Constants.TRACK_PUSH_MSG_TYPE, new BinaryMsg.Builder().type(Integer.valueOf(Constants.TRACK_BINARY_MSG_TYPE)).payload(ByteString.m6997of(bArr)).build());
        sendMessageLatch.setMsgSeqId(a);
        SendResult waitForResult = m34793a(a) ? sendMessageLatch.waitForResult() : new SendResult(-1, 0);
        this.f46626c.clear();
        return waitForResult;
    }

    public SendResult sendMessageByPushAsync(byte[] bArr) {
        return m34793a(m34791a(Constants.TRACK_PUSH_MSG_TYPE, new BinaryMsg.Builder().type(Integer.valueOf(Constants.TRACK_BINARY_MSG_TYPE)).payload(ByteString.m6997of(bArr)).build())) ? new SendResult(0, 0) : new SendResult(-1, 0);
    }

    /* renamed from: a */
    private BigInteger m34791a(int i, BinaryMsg binaryMsg) {
        IDataChannel dataChannel = TrackController.getIntance().getInitParams().getDataChannel();
        if (dataChannel != null) {
            return dataChannel.sendMessage(i, binaryMsg);
        }
        return BigInteger.ZERO;
    }

    /* renamed from: a */
    private boolean m34793a(BigInteger bigInteger) {
        return bigInteger != null && bigInteger.compareTo(BigInteger.ZERO) > 0;
    }

    public void onSuccess(BigInteger bigInteger) {
        this.f46626c.dispatchOnSuccess(bigInteger);
    }

    public void onFail(BigInteger bigInteger) {
        this.f46626c.dispatchOnFail(bigInteger);
    }

    private class SendMessageThreadLocal {
        private Map<Long, SendMessageLatch> mSendMessageLatchs;

        private SendMessageThreadLocal() {
            this.mSendMessageLatchs = new HashMap();
        }

        /* access modifiers changed from: package-private */
        public synchronized SendMessageLatch get() {
            return this.mSendMessageLatchs.get(Long.valueOf(Thread.currentThread().getId()));
        }

        /* access modifiers changed from: package-private */
        public synchronized void set(SendMessageLatch sendMessageLatch) {
            this.mSendMessageLatchs.put(Long.valueOf(Thread.currentThread().getId()), sendMessageLatch);
        }

        /* access modifiers changed from: package-private */
        public synchronized void clear() {
            this.mSendMessageLatchs.remove(Long.valueOf(Thread.currentThread().getId()));
        }

        /* access modifiers changed from: package-private */
        public synchronized void dispatchOnSuccess(BigInteger bigInteger) {
            for (SendMessageLatch next : this.mSendMessageLatchs.values()) {
                if (next != null) {
                    next.onSuccess(bigInteger);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized void dispatchOnFail(BigInteger bigInteger) {
            for (SendMessageLatch next : this.mSendMessageLatchs.values()) {
                if (next != null) {
                    next.onFail(bigInteger);
                }
            }
        }
    }

    private class SendMessageLatch extends CountDownLatch implements IDataChannelMsgCallback {
        private Map<BigInteger, Boolean> mCachedMsgResult = new HashMap();
        private BigInteger mMsgSeqId;
        private SendResult mSendResult = null;

        SendMessageLatch() {
            super(1);
        }

        /* access modifiers changed from: package-private */
        public synchronized void setMsgSeqId(BigInteger bigInteger) {
            this.mMsgSeqId = bigInteger;
            SendResult cachedMsgResult = getCachedMsgResult(bigInteger);
            this.mSendResult = cachedMsgResult;
            if (cachedMsgResult != null) {
                countDown();
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized BigInteger getMsgSeqId() {
            return this.mMsgSeqId;
        }

        /* access modifiers changed from: package-private */
        public synchronized void addCachedMsgResult(BigInteger bigInteger, Boolean bool) {
            if (this.mMsgSeqId == null) {
                this.mCachedMsgResult.put(bigInteger, bool);
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized SendResult getCachedMsgResult(BigInteger bigInteger) {
            Boolean bool;
            bool = this.mCachedMsgResult.get(bigInteger);
            this.mCachedMsgResult.clear();
            return bool != null ? bool.booleanValue() ? new SendResult(0, 0) : new SendResult(-1, 0) : null;
        }

        /* access modifiers changed from: package-private */
        public SendResult waitForResult() {
            try {
                if (await(DataChannel.f46624b, TimeUnit.MILLISECONDS)) {
                    return this.mSendResult;
                }
                return new SendResult(-2, 0);
            } catch (InterruptedException unused) {
                return new SendResult(-1, 0);
            }
        }

        public void onSuccess(BigInteger bigInteger) {
            BigInteger msgSeqId = getMsgSeqId();
            if (msgSeqId == null) {
                addCachedMsgResult(bigInteger, true);
            } else if (msgSeqId.equals(bigInteger)) {
                this.mSendResult = new SendResult(0, 0);
                countDown();
            }
        }

        public void onFail(BigInteger bigInteger) {
            BigInteger msgSeqId = getMsgSeqId();
            if (msgSeqId == null) {
                addCachedMsgResult(bigInteger, false);
            } else if (msgSeqId.equals(bigInteger)) {
                this.mSendResult = new SendResult(-1, 0);
                countDown();
            }
        }
    }
}
