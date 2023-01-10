package com.didi.trackupload.sdk.datachannel;

import com.didichuxing.bigdata.p174dp.locsdk.Const;

public class SendResult {
    public static final int DETAIL_ERR_CODE_HTTP_BUILD_WHOLE_MSG = -1101;
    public static final int DETAIL_ERR_CODE_HTTP_RESPONSE_OTHER_EXCEPTION = -1000;
    public static final int DETAIL_ERR_CODE_HTTP_TRHEAD_INTERRUPT = -1001;
    public static final int DETAIL_ERR_CODE_LOCAL_OTHER = -9999;
    public static final int DETAIL_ERR_CODE_PARSE_HTTP_RESPONSE = -1002;
    public static final int DETAIL_ERR_CODE_PB_2_BYTES = -1100;
    public static final int RESULT_FAIL = -1;
    public static final int RESULT_SUCC = 0;
    public static final int RESULT_TIMEOUT = -2;
    public static final int SEND_TYPE_HTTP = 1;
    public static final int SEND_TYPE_PUSH = 0;

    /* renamed from: a */
    private int f46637a;

    /* renamed from: b */
    private int f46638b;

    /* renamed from: c */
    private int f46639c;

    /* renamed from: d */
    private int f46640d;

    public int getBytesLength() {
        return this.f46640d;
    }

    public void setBytesLength(int i) {
        this.f46640d = i;
    }

    public int getResultCode() {
        return this.f46637a;
    }

    public int getSendType() {
        return this.f46638b;
    }

    public int getDetailCode() {
        return this.f46639c;
    }

    public void setDetailCode(int i) {
        this.f46639c = i;
    }

    public SendResult(int i, int i2) {
        this.f46637a = i;
        this.f46638b = i2;
        this.f46639c = -9999;
    }

    public SendResult(int i, int i2, int i3) {
        this.f46637a = i;
        this.f46639c = i2;
        this.f46638b = i3;
    }

    public String toString() {
        return Const.joLeft + this.f46638b + "," + this.f46640d + "," + this.f46637a + "," + this.f46639c + "}";
    }
}
