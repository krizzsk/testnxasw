package com.didi.travel.psnger.common.push;

import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.messagecenter.C13289M;
import com.didi.sdk.messagecenter.MessageCenter;
import com.didi.sdk.messagecenter.interfaces.IHandler;
import com.didi.sdk.messagecenter.model.BaseMessage;
import com.didi.sdk.messagecenter.p153pb.BinaryMsg;
import com.didi.sdk.messagecenter.p153pb.CommonMsgReq;
import com.didi.sdk.messagecenter.p153pb.MsgType;
import com.didi.sdk.messagecenter.util.MLog;
import com.didi.travel.psnger.TravelSDK;
import com.didi.travel.psnger.model.response.NextPayResult;
import com.didi.travel.psnger.model.response.NextTotalFeeDetail;
import com.didi.travel.psnger.model.response.OrderRealtimePriceCount;
import com.didichuxing.apollo.sdk.Apollo;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import okio.ByteString;

public class PushCenter {

    public interface CommonMessageListener {
        void onMessageReceived(int i, String str);
    }

    public static void sendPushRequest(int i, byte[] bArr) {
        try {
            m34841a(i, bArr);
        } catch (NoSuchFieldError e) {
            Log.d("PushCenter", "sendPushRequest", e);
        }
    }

    public static void sendPushRequest(MsgType msgType, int i, byte[] bArr) {
        try {
            m34843a(msgType, i, bArr);
        } catch (NoSuchFieldError e) {
            Log.d("PushCenter", "sendPushRequest", e);
        }
    }

    public static void registerCommonMessageListener(final CommonMessageListener commonMessageListener) {
        subscribe(C13289M.CommonMsg.class, new IHandler<C13289M.CommonMsg>() {
            public void handle(C13289M.CommonMsg commonMsg) {
                Integer num = ((CommonMsgReq) commonMsg.msg).recommond_type;
                CommonMsgReq commonMsgReq = (CommonMsgReq) commonMsg.msg;
                int intValue = ((Integer) Wire.get(num, CommonMsgReq.DEFAULT_RECOMMOND_TYPE)).intValue();
                String str = ((CommonMsgReq) commonMsg.msg).recommond_msg;
                CommonMsgReq commonMsgReq2 = (CommonMsgReq) commonMsg.msg;
                String str2 = (String) Wire.get(str, "");
                MLog.m29814d("handle M.CommonMsg: recommendType = " + intValue + ", recommendMsg = " + str2);
                commonMessageListener.onMessageReceived(intValue, str2);
            }
        });
    }

    public static void unregisterCommonMessageListener() {
        unsubscribe(C13289M.CommonMsg.class);
    }

    /* renamed from: a */
    private static void m34841a(int i, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            BinaryMsg.Builder builder = new BinaryMsg.Builder();
            builder.type(Integer.valueOf(i));
            builder.payload(ByteString.m6998of(bArr, 0, bArr.length));
            m34842a(builder);
            MessageCenter.send(builder.build());
        }
    }

    /* renamed from: a */
    private static void m34843a(MsgType msgType, int i, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            BinaryMsg.Builder builder = new BinaryMsg.Builder();
            builder.type(Integer.valueOf(i));
            builder.payload(ByteString.m6998of(bArr, 0, bArr.length));
            m34842a(builder);
            MessageCenter.send(msgType, (Message) builder.build());
        }
    }

    public static void registerOrderRealtimePriceCountListener(PushCallBackListener<OrderRealtimePriceCount> pushCallBackListener) {
        subscribe(C13289M.OrderRealtimeFeeMsg.class, pushCallBackListener, OrderRealtimePriceCount.class);
    }

    public static void unregisterOrderRealtimePriceCountListener() {
        unsubscribe(C13289M.OrderRealtimeFeeMsg.class);
    }

    public static void registerOrderTotalFeeDetailListener(PushCallBackListener<NextTotalFeeDetail> pushCallBackListener) {
        subscribe(C13289M.OrderTotalFeeMsg.class, pushCallBackListener, NextTotalFeeDetail.class);
    }

    public static void unregisterOrderTotalFeeDetailListener() {
        unsubscribe(C13289M.OrderTotalFeeMsg.class);
    }

    public static void registerPayResultMessageListener(PushCallBackListener<NextPayResult> pushCallBackListener) {
        subscribe(C13289M.OrderPaySucMsg.class, pushCallBackListener, NextPayResult.class);
    }

    public static void unregisterPayResultMessageListener() {
        unsubscribe(C13289M.OrderPaySucMsg.class);
    }

    /* renamed from: a */
    private static void m34842a(BinaryMsg.Builder builder) {
        if (Apollo.getToggle("remote_keep_alive_android_switch_v5").allow() && TravelSDK.travelParam() != null) {
            int curBid = TravelSDK.travelParam().curBid();
            int locCity = TravelSDK.travelParam().locCity();
            String tripCountry = TravelSDK.travelParam().tripCountry();
            if (locCity > 0) {
                builder.city_id(Long.valueOf((long) locCity));
            }
            if (curBid > 0) {
                builder.product_id(Long.valueOf((long) curBid));
            }
            if (!TextUtils.isEmpty(tripCountry)) {
                builder.trip_country(tripCountry);
            }
        }
    }

    public static <T extends BaseMessage, K> void subscribe(Class<T> cls, final PushCallBackListener<K> pushCallBackListener, final Class<K> cls2) {
        subscribe(cls, new IHandler<T>() {
            public void handle(T t) {
                Object parse = new MessageParser(cls2).parse(t);
                if (parse == null) {
                    MLog.m29817w("PushManager#handle: model is null");
                    return;
                }
                MLog.m29814d("PushManager#handle onReceive: " + parse);
                pushCallBackListener.onReceive(parse);
            }
        });
    }

    public static <T extends BaseMessage> void subscribe(Class<T> cls, IHandler<T> iHandler) {
        MessageCenter.bind(cls).subscribe(cls).handler(iHandler);
    }

    public static void unsubscribe(Class<? extends BaseMessage> cls) {
        MessageCenter.release(cls);
    }
}
