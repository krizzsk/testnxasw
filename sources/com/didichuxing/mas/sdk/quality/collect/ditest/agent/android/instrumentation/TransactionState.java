package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation;

import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.api.common.TransactionData;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLog;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLogManager;

public final class TransactionState {

    /* renamed from: a */
    private static final AgentLog f50513a = AgentLogManager.getAgentLog();

    /* renamed from: b */
    private final String f50514b = "businesstype";

    /* renamed from: c */
    private String f50515c;

    /* renamed from: d */
    private String f50516d;

    /* renamed from: e */
    private int f50517e;

    /* renamed from: f */
    private int f50518f;

    /* renamed from: g */
    private long f50519g;

    /* renamed from: h */
    private long f50520h;

    /* renamed from: i */
    private long f50521i = System.currentTimeMillis();

    /* renamed from: j */
    private long f50522j;

    /* renamed from: k */
    private String f50523k = "unknown";

    /* renamed from: l */
    private String f50524l = "unknown";

    /* renamed from: m */
    private State f50525m = State.READY;

    /* renamed from: n */
    private String f50526n;

    /* renamed from: o */
    private TransactionData f50527o;

    /* renamed from: p */
    private int f50528p;

    /* renamed from: q */
    private String f50529q;

    /* renamed from: r */
    private boolean f50530r;

    /* renamed from: s */
    private long f50531s;

    /* renamed from: t */
    private long f50532t;

    /* renamed from: u */
    private NetIntfaceType f50533u = NetIntfaceType.UNKNOWN;

    /* renamed from: v */
    private long f50534v;

    /* renamed from: w */
    private long f50535w;

    /* renamed from: x */
    private String f50536x;

    /* renamed from: y */
    private String f50537y;

    public enum NetIntfaceType {
        HTTP_URL_CONNECTION,
        HTTPCLIENT,
        OKHTTP2,
        UNKNOWN
    }

    private enum State {
        READY,
        SENT,
        COMPLETE
    }

    public TransactionState(NetIntfaceType netIntfaceType) {
        this.f50533u = netIntfaceType;
    }

    public TransactionState() {
    }

    public void setCarrier(String str) {
        if (!isSent()) {
            this.f50523k = str;
            return;
        }
        AgentLog agentLog = f50513a;
        agentLog.warning("setCarrier(...) called on TransactionState in " + this.f50525m.toString() + " state");
    }

    public void setWanType(String str) {
        if (!isSent()) {
            this.f50524l = str;
            return;
        }
        AgentLog agentLog = f50513a;
        agentLog.warning("setWanType(...) called on TransactionState in " + this.f50525m.toString() + " state");
    }

    public long getBytesHeaderSent() {
        return this.f50531s;
    }

    public void setBytesHeaderSent(long j) {
        this.f50531s = j;
    }

    public long getBytesHeaderReceived() {
        return this.f50532t;
    }

    public void setBytesHeaderReceived(long j) {
        this.f50532t = j;
    }

    public void setUrl(String str) {
        parseBusinessType(str);
        if (str == null) {
            return;
        }
        if (!isSent()) {
            this.f50534v += (long) (str.length() + 14);
            this.f50515c = str;
            return;
        }
        f50513a.warning("setUrl(...) called on TransactionState in " + this.f50525m.toString() + " state");
    }

    public void setHttpMethod(String str) {
        if (!isSent()) {
            this.f50516d = str;
            return;
        }
        AgentLog agentLog = f50513a;
        agentLog.warning("setHttpMethod(...) called on TransactionState in " + this.f50525m.toString() + " state");
    }

    public String getUrl() {
        return this.f50515c;
    }

    public String getHttpMethod() {
        return this.f50516d;
    }

    public boolean isSent() {
        return this.f50525m.ordinal() >= State.SENT.ordinal();
    }

    public boolean isComplete() {
        return this.f50525m.ordinal() >= State.COMPLETE.ordinal();
    }

    public void setStatusCode(int i) {
        if (!isComplete()) {
            this.f50517e = i;
            this.f50535w += 16;
            return;
        }
        f50513a.warning("setStatusCode(...) called on TransactionState in " + this.f50525m.toString() + " state");
    }

    public int getStatusCode() {
        return this.f50517e;
    }

    public void setErrorCode(int i) {
        if (!isComplete()) {
            this.f50518f = i;
            return;
        }
        AgentLog agentLog = f50513a;
        agentLog.warning("setErrorCode(...) called on TransactionState in " + this.f50525m.toString() + " state");
    }

    public int getErrorCode() {
        return this.f50518f;
    }

    public void setBytesSent(long j) {
        if (!isComplete()) {
            this.f50519g = j;
            this.f50525m = State.SENT;
            return;
        }
        AgentLog agentLog = f50513a;
        agentLog.warning("setBytesSent(...) called on TransactionState in " + this.f50525m.toString() + " state");
    }

    public void setBytesReceived(long j) {
        if (!isComplete()) {
            this.f50520h = j;
            return;
        }
        AgentLog agentLog = f50513a;
        agentLog.warning("setBytesReceived(...) called on TransactionState in " + this.f50525m.toString() + " state, value:" + j);
    }

    public long getBytesReceived() {
        return this.f50520h;
    }

    public TransactionData end() {
        if (!isComplete()) {
            this.f50525m = State.COMPLETE;
            this.f50522j = System.currentTimeMillis();
        }
        return m37685a();
    }

    /* renamed from: a */
    private TransactionData m37685a() {
        if (!isComplete()) {
            f50513a.warning("toTransactionData() called on incomplete TransactionState");
        }
        if (this.f50520h + this.f50532t + this.f50535w == 0) {
            AgentLog agentLog = f50513a;
            agentLog.debug("apm net interface type:" + this.f50533u.toString());
        }
        String str = this.f50515c;
        if (str == null) {
            f50513a.error("Attempted to convert a TransactionState instance with no URL into a TransactionData");
            return null;
        }
        if (this.f50527o == null) {
            TransactionData transactionData = r3;
            TransactionData transactionData2 = new TransactionData(str, this.f50516d, this.f50523k, this.f50522j - this.f50521i, this.f50517e, this.f50518f, this.f50519g + this.f50531s + this.f50534v, this.f50520h + this.f50532t + this.f50535w, this.f50524l, this.f50528p, this.f50529q, this.f50530r, this.f50536x, this.f50537y);
            this.f50527o = transactionData;
        }
        return this.f50527o;
    }

    public int getBusinessType() {
        return this.f50528p;
    }

    public void setBusinessType(int i) {
        this.f50528p = i;
    }

    public String getTraceId() {
        return this.f50529q;
    }

    public void setTraceId(String str) {
        this.f50529q = str;
    }

    public String getContentType() {
        return this.f50526n;
    }

    public void setContentType(String str) {
        this.f50526n = str;
    }

    public void parseBusinessType(String str) {
        if (str != null) {
            int indexOf = str.indexOf(63);
            if (indexOf > 0) {
                str = str.substring(indexOf + 1);
            }
            String[] split = str.split(ParamKeys.SIGN_AND);
            for (String split2 : split) {
                String[] split3 = split2.split("=");
                if (split3.length == 2 && split3[0].equals("businesstype")) {
                    try {
                        setBusinessType(Integer.parseInt(split3[1]));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        }
    }

    public long getBytesRequestLine() {
        return this.f50534v;
    }

    public void setBytesRequestLine(long j) {
        this.f50534v = j;
    }

    public long getBytesStatusLine() {
        return this.f50535w;
    }

    public void setBytesStatusLine(long j) {
        this.f50535w = j;
    }

    public String getErrCodeClass() {
        return this.f50536x;
    }

    public void setErrCodeClass(String str) {
        this.f50536x = str;
    }

    public String getErrCodeInfo() {
        return this.f50537y;
    }

    public void setErrCodeInfo(String str) {
        this.f50537y = str;
    }

    public String toString() {
        return "TransactionState{url='" + this.f50515c + '\'' + ", httpMethod='" + this.f50516d + '\'' + ", statusCode=" + this.f50517e + ", errorCode=" + this.f50518f + ", bytesSent=" + this.f50519g + ", bytesReceived=" + this.f50520h + ", startTime=" + this.f50521i + ", endTime=" + this.f50522j + ", carrier='" + this.f50523k + '\'' + ", wanType='" + this.f50524l + '\'' + ", state=" + this.f50525m + ", contentType='" + this.f50526n + '\'' + ", transactionData=" + this.f50527o + '}';
    }
}
