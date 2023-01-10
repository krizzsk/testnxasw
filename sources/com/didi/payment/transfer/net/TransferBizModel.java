package com.didi.payment.transfer.net;

import android.content.Context;
import android.text.TextUtils;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.commonsdk.fastpay.FastPayUtils;
import com.didi.payment.transfer.accounts.presenter.TransAccountRecordResp;
import com.didi.payment.transfer.accounts.presenter.TransVerifyAccountResp;
import com.didi.payment.transfer.channels.TransChannelResp;
import com.didi.payment.transfer.channels.presenter.TransAccountStatusResp;
import com.didi.payment.transfer.fillamount.TransCreateOrderResp;
import com.didi.payment.transfer.fillamount.TransServiceFeeResp;
import com.didi.payment.transfer.fillphone.TransCountryCodeResp;
import com.didi.payment.transfer.newaccount.TransBankAccountTypeResp;
import com.didi.payment.transfer.orderdetail.presenter.TransPayResultResp;
import com.didi.payment.transfer.orderdetail.presenter.TransRemindMsgResp;
import com.didi.payment.transfer.records.TransHistoryListResp;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.soda.customer.app.constant.Const;
import com.didi.wallet.dimina.DiminaLaunchModel;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.util.HashMap;
import java.util.Map;
import org.osgi.framework.AdminPermission;

public class TransferBizModel {

    /* renamed from: a */
    private static final String f33942a = "https://wallet.didiglobal.com";

    /* renamed from: d */
    private static TransferBizModel f33943d;

    /* renamed from: b */
    private TransferRpcService f33944b;

    /* renamed from: c */
    private Context f33945c;

    public static TransferBizModel getInstance(Context context) {
        if (f33943d == null) {
            synchronized (TransferBizModel.class) {
                if (f33943d == null) {
                    f33943d = new TransferBizModel(context);
                }
            }
        }
        return f33943d;
    }

    private TransferBizModel(Context context) {
        this.f33945c = context;
        this.f33944b = (TransferRpcService) new RpcServiceFactory(context).newRpcService(TransferRpcService.class, "https://wallet.didiglobal.com");
    }

    /* renamed from: a */
    private HashMap<String, Object> m25848a(Context context) {
        return PayBaseParamUtil.getHttpBaseParams(context);
    }

    public void loadTransferChannels(Map<String, Object> map, RpcService.Callback<TransChannelResp> callback) {
        HashMap<String, Object> a = m25848a(this.f33945c);
        if (!CollectionUtil.isEmpty((Map<?, ?>) map)) {
            for (String next : map.keySet()) {
                a.put(next, map.get(next));
            }
        }
        this.f33944b.requestTransferMethods(a, (Map<String, Object>) null, callback);
    }

    public void createTransferOrder(int i, int i2, String str, String str2, String str3, boolean z, RpcService.Callback<TransCreateOrderResp> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put(DiminaLaunchModel.PRODUCT_LINE, Integer.valueOf(i));
        hashMap.put(AdminPermission.METADATA, str);
        hashMap.put("orderType", Integer.valueOf(i2));
        hashMap.put("useFastPay", Boolean.valueOf(z));
        hashMap.put(Const.PayParams.BIZ_CONTENT, str2);
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("passwordToken", str3);
        }
        hashMap.put("thirdParty", FastPayUtils.INSTANCE.getThreeParty());
        hashMap.put("thirdPartyAbility", FastPayUtils.INSTANCE.getThreePartyAbility());
        this.f33944b.createTransOrder(m25848a(this.f33945c), hashMap, callback);
    }

    public void cancelTransferOrder(String str, RpcService.Callback<TransRemindMsgResp> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put("orderId", str);
        this.f33944b.cancelTransferOrder(m25848a(this.f33945c), hashMap, callback);
    }

    public void requestRemindReceiveMsg(String str, RpcService.Callback<TransRemindMsgResp> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put("orderId", str);
        this.f33944b.requestRemindRecieveMsg(m25848a(this.f33945c), hashMap, callback);
    }

    public void getHistoryList(String str, int i, int i2, int i3, RpcService.Callback<TransHistoryListResp> callback) {
        HashMap<String, Object> a = m25848a(this.f33945c);
        a.put("product_line", Integer.valueOf(i));
        a.put("productLines", str);
        a.put("start_index", Integer.valueOf(i2));
        a.put("page_size", 20);
        if (i3 >= 0) {
            a.put("order_type", Integer.valueOf(i3));
        }
        this.f33944b.getHistoryList(a, callback);
    }

    public void queryServiceFee(int i, int i2, String str, RpcService.Callback<TransServiceFeeResp> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put("cityId", Integer.valueOf(i));
        hashMap.put(DiminaLaunchModel.PRODUCT_LINE, Integer.valueOf(i2));
        hashMap.put("toCpf", str);
        this.f33944b.queryServiceFee(m25848a(this.f33945c), hashMap, callback);
    }

    public void getOrderDetailInfo(int i, String str, RpcService.Callback<TransPayResultResp> callback) {
        HashMap<String, Object> a = m25848a(this.f33945c);
        a.put("order_id", str);
        this.f33944b.queryOrderStatus(a, callback);
    }

    public void verifyUserAccount(String str, String str2, RpcService.Callback<TransVerifyAccountResp> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put("tel", str);
        hashMap.put("countryCallingCode", str2);
        this.f33944b.check99AccountByTel(m25848a(this.f33945c), hashMap, callback);
    }

    public void queryAccountStatus(RpcService.Callback<TransAccountStatusResp> callback) {
        this.f33944b.checkAccountStatus(m25848a(this.f33945c), (Map<String, Object>) null, callback);
    }

    public void queryCountryList(RpcService.Callback<TransCountryCodeResp> callback) {
        this.f33944b.queryCountryList(m25848a(this.f33945c), (Map<String, Object>) null, callback);
    }

    public void loadHistoryTransAccounts(int i, int i2, int i3, RpcService.Callback<TransAccountRecordResp> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(i));
        hashMap.put("start_index", Integer.valueOf(i2));
        hashMap.put("page_size", Integer.valueOf(i3));
        this.f33944b.queryTransferAccounts(m25848a(this.f33945c), hashMap, callback);
    }

    public void getBankAccountTypeList(RpcService.Callback<TransBankAccountTypeResp> callback) {
        this.f33944b.getBankAccountTypeList(m25848a(this.f33945c), callback);
    }
}
