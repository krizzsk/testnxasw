package com.didi.global.fintech.cashier.user.facade;

import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/user/facade/CashierPayResult;", "", "()V", "CODE_3DS_FAIL", "", "CODE_3DS_USER_CANCEL", "CODE_API_UNKNOWN", "CODE_CONFIRM_PAY_FAIL", "CODE_CONFIRM_PAY_USER_CANCEL", "CODE_MAX_WAIT_TIME_OUT", "CODE_METHOD_CHANGE", "CODE_NET_ERR", "CODE_OPEN_URL_FAIL", "CODE_PASSWORD_FAIL", "CODE_PASSWORD_USER_CANCEL", "CODE_PAY_FAILED", "CODE_PAY_SUCCESS", "CODE_PAY_SUCCESS_HOLD", "CODE_PIX_FAIL", "CODE_PIX_TIMEOUT", "CODE_PIX_USER_CANCEL", "CODE_RANDOM_VERIFY_FAIL", "CODE_UPDATE_CARD_FAIL", "CODE_UPDATE_CARD_USER_CANCEL", "CODE_USER_CANCEL", "PLATFORM_CASHIER_PADDING_TIMEOUT", "cashier_user_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CashierPayResult.kt */
public final class CashierPayResult {
    public static final int CODE_3DS_FAIL = -10000;
    public static final int CODE_3DS_USER_CANCEL = -10001;
    public static final int CODE_API_UNKNOWN = -20000;
    public static final int CODE_CONFIRM_PAY_FAIL = -10401;
    public static final int CODE_CONFIRM_PAY_USER_CANCEL = -10400;
    public static final int CODE_MAX_WAIT_TIME_OUT = -20003;
    public static final int CODE_METHOD_CHANGE = 5;
    public static final int CODE_NET_ERR = -20001;
    public static final int CODE_OPEN_URL_FAIL = -10500;
    public static final int CODE_PASSWORD_FAIL = -10301;
    public static final int CODE_PASSWORD_USER_CANCEL = -10300;
    public static final int CODE_PAY_FAILED = 3;
    public static final int CODE_PAY_SUCCESS = 1;
    public static final int CODE_PAY_SUCCESS_HOLD = 7;
    public static final int CODE_PIX_FAIL = -10600;
    public static final int CODE_PIX_TIMEOUT = 4;
    public static final int CODE_PIX_USER_CANCEL = -10601;
    public static final int CODE_RANDOM_VERIFY_FAIL = -10100;
    public static final int CODE_UPDATE_CARD_FAIL = -10200;
    public static final int CODE_UPDATE_CARD_USER_CANCEL = -10200;
    public static final int CODE_USER_CANCEL = 2;
    public static final CashierPayResult INSTANCE = new CashierPayResult();
    public static final int PLATFORM_CASHIER_PADDING_TIMEOUT = -20004;

    private CashierPayResult() {
    }
}
