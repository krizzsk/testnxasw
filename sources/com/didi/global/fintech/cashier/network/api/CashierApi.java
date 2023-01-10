package com.didi.global.fintech.cashier.network.api;

import com.didi.global.fintech.cashier.model.net.request.AgreePolicyRequest;
import com.didi.global.fintech.cashier.model.net.request.CanChangeNewVersionRequest;
import com.didi.global.fintech.cashier.model.net.request.ChangePayInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.GetCVVInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.GetPayInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.GetPayStatusRequest;
import com.didi.global.fintech.cashier.model.net.request.GetSuccessInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.PaymentThreeDSDetailsRequest;
import com.didi.global.fintech.cashier.model.net.request.PrepayRequest;
import com.didi.global.fintech.cashier.model.net.response.AgreePolicyResponse;
import com.didi.global.fintech.cashier.model.net.response.CVVInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.CanChangeNewVersionResponse;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.PayStatusResponse;
import com.didi.global.fintech.cashier.model.net.response.PaymentThreeDSDetailsResponse;
import com.didi.global.fintech.cashier.model.net.response.PrepayResponse;
import com.didi.global.fintech.cashier.model.net.response.SuccessInfoResponse;
import com.didi.global.fintech.cashier.network.callback.CashierNetCallback;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(mo148867d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nH&J6\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\nH&J6\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nH&J6\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nH&J6\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00152\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\nH&J6\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00182\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010\nH&J6\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00182\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010\nH&J6\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u001b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00072\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0018\u00010\nH&J6\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u001e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00072\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e\u0018\u00010\nH&J6\u0010 \u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020!2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\"0\u00072\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!\u0018\u00010\nH&J6\u0010#\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020$2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020%0\u00072\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$\u0018\u00010\nH&¨\u0006&"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/network/api/CashierApi;", "", "agreePolicy", "", "request", "Lcom/didi/global/fintech/cashier/model/net/request/AgreePolicyRequest;", "callback", "Lcom/didi/global/fintech/cashier/network/callback/CashierNetCallback;", "Lcom/didi/global/fintech/cashier/model/net/response/AgreePolicyResponse;", "processor", "Lkotlin/Function1;", "canChangeNewVersion", "canChangeNewVersionRequest", "Lcom/didi/global/fintech/cashier/model/net/request/CanChangeNewVersionRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/CanChangeNewVersionResponse;", "changePayInfo", "getPayInfoRequest", "Lcom/didi/global/fintech/cashier/model/net/request/ChangePayInfoRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "changePayMethodInfo", "getCVVInfo", "Lcom/didi/global/fintech/cashier/model/net/request/GetCVVInfoRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/CVVInfoResponse;", "getPayInfo", "Lcom/didi/global/fintech/cashier/model/net/request/GetPayInfoRequest;", "getPayMethodInfo", "getPayStatus", "Lcom/didi/global/fintech/cashier/model/net/request/GetPayStatusRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/PayStatusResponse;", "getSuccessInfo", "Lcom/didi/global/fintech/cashier/model/net/request/GetSuccessInfoRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/SuccessInfoResponse;", "payment3DSDetails", "Lcom/didi/global/fintech/cashier/model/net/request/PaymentThreeDSDetailsRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/PaymentThreeDSDetailsResponse;", "prePay", "Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/PrepayResponse;", "cashier_network_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CashierApi.kt */
public interface CashierApi {
    void agreePolicy(AgreePolicyRequest agreePolicyRequest, CashierNetCallback<AgreePolicyResponse> cashierNetCallback, Function1<? super AgreePolicyRequest, AgreePolicyRequest> function1);

    void canChangeNewVersion(CanChangeNewVersionRequest canChangeNewVersionRequest, CashierNetCallback<CanChangeNewVersionResponse> cashierNetCallback, Function1<? super CanChangeNewVersionRequest, CanChangeNewVersionRequest> function1);

    void changePayInfo(ChangePayInfoRequest changePayInfoRequest, CashierNetCallback<PayInfoResponse> cashierNetCallback, Function1<? super ChangePayInfoRequest, ChangePayInfoRequest> function1);

    void changePayMethodInfo(ChangePayInfoRequest changePayInfoRequest, CashierNetCallback<PayInfoResponse> cashierNetCallback, Function1<? super ChangePayInfoRequest, ChangePayInfoRequest> function1);

    void getCVVInfo(GetCVVInfoRequest getCVVInfoRequest, CashierNetCallback<CVVInfoResponse> cashierNetCallback, Function1<? super GetCVVInfoRequest, GetCVVInfoRequest> function1);

    void getPayInfo(GetPayInfoRequest getPayInfoRequest, CashierNetCallback<PayInfoResponse> cashierNetCallback, Function1<? super GetPayInfoRequest, GetPayInfoRequest> function1);

    void getPayMethodInfo(GetPayInfoRequest getPayInfoRequest, CashierNetCallback<PayInfoResponse> cashierNetCallback, Function1<? super GetPayInfoRequest, GetPayInfoRequest> function1);

    void getPayStatus(GetPayStatusRequest getPayStatusRequest, CashierNetCallback<PayStatusResponse> cashierNetCallback, Function1<? super GetPayStatusRequest, GetPayStatusRequest> function1);

    void getSuccessInfo(GetSuccessInfoRequest getSuccessInfoRequest, CashierNetCallback<SuccessInfoResponse> cashierNetCallback, Function1<? super GetSuccessInfoRequest, GetSuccessInfoRequest> function1);

    void payment3DSDetails(PaymentThreeDSDetailsRequest paymentThreeDSDetailsRequest, CashierNetCallback<PaymentThreeDSDetailsResponse> cashierNetCallback, Function1<? super PaymentThreeDSDetailsRequest, PaymentThreeDSDetailsRequest> function1);

    void prePay(PrepayRequest prepayRequest, CashierNetCallback<PrepayResponse> cashierNetCallback, Function1<? super PrepayRequest, PrepayRequest> function1);

    @Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: CashierApi.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void canChangeNewVersion$default(CashierApi cashierApi, CanChangeNewVersionRequest canChangeNewVersionRequest, CashierNetCallback cashierNetCallback, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    function1 = null;
                }
                cashierApi.canChangeNewVersion(canChangeNewVersionRequest, cashierNetCallback, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: canChangeNewVersion");
        }

        public static /* synthetic */ void getPayInfo$default(CashierApi cashierApi, GetPayInfoRequest getPayInfoRequest, CashierNetCallback cashierNetCallback, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    function1 = null;
                }
                cashierApi.getPayInfo(getPayInfoRequest, cashierNetCallback, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPayInfo");
        }

        public static /* synthetic */ void getPayMethodInfo$default(CashierApi cashierApi, GetPayInfoRequest getPayInfoRequest, CashierNetCallback cashierNetCallback, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    function1 = null;
                }
                cashierApi.getPayMethodInfo(getPayInfoRequest, cashierNetCallback, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPayMethodInfo");
        }

        public static /* synthetic */ void changePayInfo$default(CashierApi cashierApi, ChangePayInfoRequest changePayInfoRequest, CashierNetCallback cashierNetCallback, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    function1 = null;
                }
                cashierApi.changePayInfo(changePayInfoRequest, cashierNetCallback, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changePayInfo");
        }

        public static /* synthetic */ void changePayMethodInfo$default(CashierApi cashierApi, ChangePayInfoRequest changePayInfoRequest, CashierNetCallback cashierNetCallback, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    function1 = null;
                }
                cashierApi.changePayMethodInfo(changePayInfoRequest, cashierNetCallback, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changePayMethodInfo");
        }

        public static /* synthetic */ void prePay$default(CashierApi cashierApi, PrepayRequest prepayRequest, CashierNetCallback cashierNetCallback, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    function1 = null;
                }
                cashierApi.prePay(prepayRequest, cashierNetCallback, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: prePay");
        }

        public static /* synthetic */ void getPayStatus$default(CashierApi cashierApi, GetPayStatusRequest getPayStatusRequest, CashierNetCallback cashierNetCallback, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    function1 = null;
                }
                cashierApi.getPayStatus(getPayStatusRequest, cashierNetCallback, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPayStatus");
        }

        public static /* synthetic */ void getSuccessInfo$default(CashierApi cashierApi, GetSuccessInfoRequest getSuccessInfoRequest, CashierNetCallback cashierNetCallback, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    function1 = null;
                }
                cashierApi.getSuccessInfo(getSuccessInfoRequest, cashierNetCallback, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSuccessInfo");
        }

        public static /* synthetic */ void payment3DSDetails$default(CashierApi cashierApi, PaymentThreeDSDetailsRequest paymentThreeDSDetailsRequest, CashierNetCallback cashierNetCallback, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    function1 = null;
                }
                cashierApi.payment3DSDetails(paymentThreeDSDetailsRequest, cashierNetCallback, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: payment3DSDetails");
        }

        public static /* synthetic */ void getCVVInfo$default(CashierApi cashierApi, GetCVVInfoRequest getCVVInfoRequest, CashierNetCallback cashierNetCallback, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    function1 = null;
                }
                cashierApi.getCVVInfo(getCVVInfoRequest, cashierNetCallback, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCVVInfo");
        }

        public static /* synthetic */ void agreePolicy$default(CashierApi cashierApi, AgreePolicyRequest agreePolicyRequest, CashierNetCallback cashierNetCallback, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    function1 = null;
                }
                cashierApi.agreePolicy(agreePolicyRequest, cashierNetCallback, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: agreePolicy");
        }
    }
}
