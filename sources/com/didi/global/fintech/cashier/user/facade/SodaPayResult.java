package com.didi.global.fintech.cashier.user.facade;

import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u000f"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/user/facade/SodaPayResult;", "Ljava/io/Serializable;", "system", "", "errCode", "", "errMsg", "(Ljava/lang/String;ILjava/lang/String;)V", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "getSystem", "toString", "Companion", "cashier_user_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SodaPayResult.kt */
public final class SodaPayResult implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String SYSTEM_CASHIER_API = "cashier-api";
    public static final String SYSTEM_CASHIER_SDK = "cashier-sdk";
    public static final String SYSTEM_RANDOM_VERIFY = "random-verify";
    private final int errCode;
    private final String errMsg;
    private final String system;

    public SodaPayResult(String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(str, "system");
        Intrinsics.checkNotNullParameter(str2, DMWebSocketListener.KEY_ERR_MSG);
        this.system = str;
        this.errCode = i;
        this.errMsg = str2;
    }

    public final int getErrCode() {
        return this.errCode;
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public final String getSystem() {
        return this.system;
    }

    @Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0010\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/user/facade/SodaPayResult$Companion;", "", "()V", "SYSTEM_CASHIER_API", "", "SYSTEM_CASHIER_SDK", "SYSTEM_RANDOM_VERIFY", "new3DSFailResult", "Lcom/didi/global/fintech/cashier/user/facade/SodaPayResult;", "newNetErrResult", "newPaddingTimeOutResult", "newPayTimeOutResult", "newRandomVerifyFailResult", "errCode", "", "errMsg", "newSuccessResult", "cashier_user_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: SodaPayResult.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SodaPayResult newSuccessResult() {
            return new SodaPayResult(SodaPayResult.SYSTEM_CASHIER_SDK, 1, "SUCCESS");
        }

        public final SodaPayResult newRandomVerifyFailResult(int i, String str) {
            if (str == null) {
                str = "";
            }
            return new SodaPayResult(SodaPayResult.SYSTEM_RANDOM_VERIFY, i, str);
        }

        public final SodaPayResult newNetErrResult() {
            return new SodaPayResult(SodaPayResult.SYSTEM_CASHIER_SDK, CashierPayResult.CODE_NET_ERR, "NET ERR");
        }

        public final SodaPayResult newPayTimeOutResult() {
            return new SodaPayResult(SodaPayResult.SYSTEM_CASHIER_SDK, CashierPayResult.CODE_MAX_WAIT_TIME_OUT, "PAY MAX WAIT TIME OUT");
        }

        public final SodaPayResult new3DSFailResult() {
            return new SodaPayResult(SodaPayResult.SYSTEM_CASHIER_SDK, -10000, "3DS FAIL");
        }

        public final SodaPayResult newPaddingTimeOutResult() {
            return new SodaPayResult(SodaPayResult.SYSTEM_CASHIER_SDK, CashierPayResult.PLATFORM_CASHIER_PADDING_TIMEOUT, "CASHIER PADDING TIMEOUT");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("system:" + this.system + ' ');
        sb.append("errCode:" + this.errCode + ' ');
        sb.append(Intrinsics.stringPlus("errMsg:", this.errMsg));
        Intrinsics.checkNotNullExpressionValue(sb, "sb.append(\"errMsg:${errMsg}\")");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }
}
